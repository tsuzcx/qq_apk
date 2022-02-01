package com.tencent.biz.qqcircle.list.bizblocks;

import aabe;
import aabj;
import aacv;
import aacw;
import alpt;
import alpv;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import anzj;
import bhlg;
import com.tencent.biz.qqcircle.fragments.chat.QCircleRecentChatListData;
import com.tencent.biz.qqcircle.fragments.chat.item.QCircleChatItemView;
import com.tencent.biz.qqcircle.fragments.person.QCirclePersonalDetailFragment;
import com.tencent.biz.qqcircle.requests.QCircleChatBatchGetPMGiftInfoRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import mqq.os.MqqHandler;
import qqcircle.QQCirclePrivateMsgShow.StBatchGetPMGiftInfoRsp;
import qqcircle.QQCirclePrivateMsgShow.UserPMGiftInfo;
import uzg;
import vjo;
import vlp;
import vqm;

public class QCircleChatListBlock
  extends vqm<QCircleRecentChatListData, QQCirclePrivateMsgShow.StBatchGetPMGiftInfoRsp>
  implements alpt, alpv, Observer
{
  private static final int LOAD_COUNT_PER_PAGE = 20;
  private static final String TAG = "QCircleChatListBlock";
  protected QQAppInterface mApp;
  private View mBottomLine;
  private DragFrameLayout mDragHost;
  private boolean mHasInit;
  private boolean mIsActive;
  private List<MessageRecord> mMessageRecord = new LinkedList();
  private TextView mTvTitle;
  private DragTextView mTvUnReadNum;
  
  public QCircleChatListBlock(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  private void clearUnReadInfo()
  {
    ThreadManager.post(new QCircleChatListBlock.2(this), 5, null, false);
  }
  
  private void dragItemView(int paramInt)
  {
    try
    {
      QLog.d("QCircleChatListBlock", 1, "dragItemView: index" + paramInt);
      if ((getDataList() != null) && (getDataList().size() > paramInt))
      {
        QCircleRecentChatListData localQCircleRecentChatListData = (QCircleRecentChatListData)getDataList().get(paramInt);
        if (localQCircleRecentChatListData != null)
        {
          ArrayList localArrayList = new ArrayList();
          localArrayList.add(localQCircleRecentChatListData.getRecentUserUin());
          QLog.d("QCircleChatListBlock", 1, "clearChatUnRead uin" + localQCircleRecentChatListData.getRecentUserUin());
          vjo.a(this.mApp, localArrayList, false);
        }
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QCircleChatListBlock", 1, localException.getMessage());
    }
  }
  
  private void jumpPrivateChat(String paramString, QQCirclePrivateMsgShow.UserPMGiftInfo paramUserPMGiftInfo)
  {
    if ((getContext() == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    Intent localIntent = new Intent(getContext(), ChatActivity.class);
    localIntent.putExtra("open_chatfragment", true);
    localIntent.putExtra("PREVIOUS_WINDOW", QCirclePersonalDetailFragment.class.getName());
    localIntent.putExtra("uin", paramString);
    if (uzg.a(getContext(), paramString)) {
      localIntent.putExtra("uintype", 0);
    }
    for (;;)
    {
      if ((paramUserPMGiftInfo != null) && (paramUserPMGiftInfo.has()) && (paramUserPMGiftInfo.giftInfos.size() > 0)) {
        localIntent.putExtra("qcirlce_chat_gift_info_bytes_key", paramUserPMGiftInfo.toByteArray());
      }
      localIntent.putExtra("aio_msg_source", 3);
      paramUserPMGiftInfo = bhlg.b(this.mApp, paramString, true);
      paramString = paramUserPMGiftInfo;
      if (paramUserPMGiftInfo == null) {
        paramString = "";
      }
      localIntent.putExtra("uinname", paramString);
      getContext().startActivity(localIntent);
      return;
      localIntent.putExtra("uintype", 10008);
    }
  }
  
  private void notifyInMainThread()
  {
    ThreadManager.getUIHandlerV2().post(new QCircleChatListBlock.1(this));
  }
  
  private void setTabUnReadNum(int paramInt)
  {
    if (this.mTvUnReadNum != null)
    {
      QLog.d("QCircleChatListBlock", 1, "updateTabUnReadNum value:" + paramInt);
      if (paramInt > 0)
      {
        this.mTvUnReadNum.setText(vjo.a(paramInt));
        this.mTvUnReadNum.setVisibility(0);
      }
    }
    else
    {
      return;
    }
    this.mTvUnReadNum.setVisibility(8);
  }
  
  private void tryRefreshData()
  {
    if ((this.mDragHost != null) && (this.mDragHost.a() == -1)) {
      onRefreshData();
    }
  }
  
  private void updateGiftInfo()
  {
    QLog.d("QCircleChatListBlock", 1, "updateGiftInfo");
    Iterator localIterator = getDataList().iterator();
    while (localIterator.hasNext())
    {
      QCircleRecentChatListData localQCircleRecentChatListData = (QCircleRecentChatListData)localIterator.next();
      localQCircleRecentChatListData.a(vlp.a().a(localQCircleRecentChatListData.getRecentUserUin()));
    }
  }
  
  public String getAttachInfoFromItemData(QCircleRecentChatListData paramQCircleRecentChatListData)
  {
    return null;
  }
  
  public String getAttachInfoFromRsp(QQCirclePrivateMsgShow.StBatchGetPMGiftInfoRsp paramStBatchGetPMGiftInfoRsp)
  {
    return null;
  }
  
  public List<aabe> getCustomParts()
  {
    return null;
  }
  
  public String getDropFrameMonitorTag()
  {
    return "qcircle_chat_list";
  }
  
  public String getEmptyHint()
  {
    return null;
  }
  
  public boolean getIsFinishFromRsp(QQCirclePrivateMsgShow.StBatchGetPMGiftInfoRsp paramStBatchGetPMGiftInfoRsp)
  {
    return true;
  }
  
  public void getListDataAsync(aacw<QCircleRecentChatListData> paramaacw, String paramString)
  {
    ThreadManager.getSubThreadHandler().post(new QCircleChatListBlock.3(this, paramaacw));
  }
  
  public List<QCircleRecentChatListData> getListDataFromRsp(QQCirclePrivateMsgShow.StBatchGetPMGiftInfoRsp paramStBatchGetPMGiftInfoRsp)
  {
    return null;
  }
  
  public String getLogTag()
  {
    return "QCircleChatListBlock";
  }
  
  public int getPageCount()
  {
    return 20;
  }
  
  public String getPageIdStr()
  {
    return null;
  }
  
  public VSBaseRequest getRequest(String paramString)
  {
    return null;
  }
  
  public String getTitle()
  {
    return anzj.a(2131697187);
  }
  
  public View getTitleTabView(ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560758, paramViewGroup, false);
    this.mTvTitle = ((TextView)paramViewGroup.findViewById(2131380117));
    this.mBottomLine = paramViewGroup.findViewById(2131380615);
    this.mTvUnReadNum = ((DragTextView)paramViewGroup.findViewById(2131380040));
    this.mTvUnReadNum.setDragViewType(2);
    this.mTvTitle.setText(anzj.a(2131697187));
    this.mBottomLine.setVisibility(8);
    this.mTvUnReadNum.setVisibility(8);
    return paramViewGroup;
  }
  
  public int getViewTypeCount()
  {
    return 1;
  }
  
  public void initTitleBar(View paramView) {}
  
  protected ArrayList<QCircleRecentChatListData> makeRecentBaseDataList(List<MessageRecord> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList == null) || (paramList.size() == 0)) {
      return localArrayList;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.next();
      if (localMessageRecord != null)
      {
        QCircleRecentChatListData localQCircleRecentChatListData = new QCircleRecentChatListData(localMessageRecord);
        localQCircleRecentChatListData.a(this.mApp, getContext());
        localQCircleRecentChatListData.a(vlp.a().a(localMessageRecord.senderuin));
        localArrayList.add(localQCircleRecentChatListData);
      }
    }
    return localArrayList;
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    if ((this.mApp != null) && (this.mApp.a() != null))
    {
      this.mApp.a().deleteObserver(this);
      QLog.d("QCircleChatListBlock", 1, "getMessageFacade deleteObserver");
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    QLog.d("QCircleChatListBlock", 1, "chatList is paused");
    this.mIsActive = false;
    if (this.mDragHost != null) {
      this.mDragHost.a();
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    if (this.mHasInit)
    {
      QLog.d("QCircleChatListBlock", 1, "onActivityResumed refresh");
      tryRefreshData();
    }
    for (;;)
    {
      this.mIsActive = true;
      clearUnReadInfo();
      return;
      QLog.d("QCircleChatListBlock", 1, "firstCome not refreshData");
      this.mHasInit = true;
    }
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (this.mDataList != null)
    {
      ((aacv)paramViewHolder).a(this.mDataList.get(paramInt), paramInt, this.mExtraTypeInfo);
      paramViewHolder.itemView.setOnClickListener(new QCircleChatListBlock.5(this, paramInt));
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public void onChange(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    if (paramBoolean)
    {
      QLog.d("QCircleChatListBlock", 1, "onDragStateChange: isDone" + paramBoolean + " dragType:" + paramInt);
      if (paramInt != 2) {
        break label70;
      }
      QLog.d("QCircleChatListBlock", 1, "dragTabRed clear unRead");
      vjo.a(this.mApp, vjo.a(getDataList()), false);
    }
    label70:
    do
    {
      do
      {
        return;
      } while ((paramInt != 0) || (paramDragFrameLayout == null));
      paramDragFrameLayout = paramDragFrameLayout.a();
    } while ((paramDragFrameLayout == null) || (!(paramDragFrameLayout.getTag() instanceof Integer)));
    dragItemView(((Integer)paramDragFrameLayout.getTag()).intValue());
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = new QCircleChatItemView(getContext());
    paramViewGroup.setDragFrameLayout(this.mDragHost);
    return new aacv(paramViewGroup);
  }
  
  public List<View> onGetVisiableDragView()
  {
    ArrayList localArrayList = new ArrayList();
    if (getParentRecyclerView() == null)
    {
      QLog.e("QCircleChatListBlock", 1, "getParentRecyclerView null");
      return localArrayList;
    }
    int j = getParentRecyclerView().getChildCount();
    int i = 0;
    while (i < j)
    {
      Object localObject = getParentRecyclerView().getChildAt(i);
      if ((localObject instanceof QCircleChatItemView))
      {
        localObject = ((QCircleChatItemView)localObject).a();
        if ((localObject != null) && (((DragTextView)localObject).getVisibility() == 0) && (((DragTextView)localObject).a() != -1)) {
          localArrayList.add(localObject);
        }
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public void onInitBlock(Bundle paramBundle)
  {
    QLog.d("QCircleChatListBlock", 1, "onPrepareParams");
    super.onInitBlock(paramBundle);
    if ((getActivity() instanceof BaseActivity))
    {
      QLog.d("QCircleChatListBlock", 1, "getMessageFacade addObserver");
      this.mApp = ((BaseActivity)getActivity()).app;
      this.mApp.a().addObserver(this);
      this.mDragHost = DragFrameLayout.a(getActivity());
      this.mDragHost.a(this, true);
      this.mDragHost.setDragViewProvider(this);
      getBlockMerger().a("");
      if (this.mTvUnReadNum != null) {
        this.mTvUnReadNum.setOnModeChangeListener(this.mDragHost);
      }
    }
  }
  
  public void onTitleTabSelectedChanged(View paramView, boolean paramBoolean)
  {
    Object localObject;
    if (paramView != null)
    {
      localObject = this.mBottomLine;
      if (!paramBoolean) {
        break label77;
      }
      i = 0;
      ((View)localObject).setVisibility(i);
      TextView localTextView = this.mTvTitle;
      if (!paramBoolean) {
        break label83;
      }
      localObject = Typeface.DEFAULT_BOLD;
      label37:
      localTextView.setTypeface((Typeface)localObject);
      localObject = this.mTvTitle;
      paramView = paramView.getContext().getResources();
      if (!paramBoolean) {
        break label91;
      }
    }
    label77:
    label83:
    label91:
    for (int i = 2131165343;; i = 2131166241)
    {
      ((TextView)localObject).setTextColor(paramView.getColor(i));
      return;
      i = 8;
      break;
      localObject = Typeface.DEFAULT;
      break label37;
    }
  }
  
  public void preHandleListData(List<QCircleRecentChatListData> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    updateGiftInfo();
    if (getParentFragment() == null) {}
    do
    {
      return;
      paramList = vjo.a(paramList);
    } while ((paramList == null) || (paramList.size() <= 0));
    paramList = new QCircleChatBatchGetPMGiftInfoRequest(paramList);
    QLog.d("QCircleChatListBlock", 1, "reqCmd" + paramList.getCmdName());
    VSNetworkHelper.a().a(getParentFragment().hashCode(), paramList, new QCircleChatListBlock.4(this));
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof MessageRecord)) {
      if (vjo.a(((MessageRecord)paramObject).istroop)) {}
    }
    while (!(paramObject instanceof RecentUser))
    {
      return;
      if (this.mIsActive)
      {
        QLog.d("QCircleChatListBlock", 1, "receiveQCircleMessage is active update");
        tryRefreshData();
        QCircleChatBoxHelper.getInstance().clearUnReadInfo();
        return;
      }
      QLog.d("QCircleChatListBlock", 1, "receiveQCircleMessage is not active not update");
      return;
    }
    QLog.d("QCircleChatListBlock", 1, "receiveQCircleRecentUser update");
    tryRefreshData();
  }
  
  protected void updateChatInfo()
  {
    Iterator localIterator = getDataList().iterator();
    while (localIterator.hasNext()) {
      ((QCircleRecentChatListData)localIterator.next()).a(this.mApp, getContext());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.list.bizblocks.QCircleChatListBlock
 * JD-Core Version:    0.7.0.1
 */