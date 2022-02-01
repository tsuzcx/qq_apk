package com.tencent.biz.qqcircle.list.bizblocks;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.qcircleshadow.lib.QCircleHostClassHelper;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants.AppConstants.Key;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants.AppConstants.Value;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants._ChatActivityConstants;
import com.tencent.biz.qcircleshadow.lib.QCircleHostDropFrameMonitorHelper._Constants;
import com.tencent.biz.qcircleshadow.lib.variation.HostChatUtils;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.fragments.chat.item.QCircleChatItemView;
import com.tencent.biz.qqcircle.fragments.person.QCirclePersonalDetailFragment;
import com.tencent.biz.qqcircle.list.QCircleBaseListBlock;
import com.tencent.biz.qqcircle.requests.QCircleChatBatchGetPMGiftInfoRequest;
import com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock.BaseListVH;
import com.tencent.biz.qqcircle.richframework.widget.drag.DragFrameLayout;
import com.tencent.biz.qqcircle.richframework.widget.drag.DragFrameLayout.IDragViewProvider;
import com.tencent.biz.qqcircle.richframework.widget.drag.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.biz.qqcircle.richframework.widget.drag.DragTextView;
import com.tencent.biz.qqcircle.utils.HardCodeUtil;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.block.BlockMerger;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.mobileqq.qcircle.api.data.QCircleRecentDataInterface;
import com.tencent.mobileqq.qcircle.api.helper.QCircleChatBoxHelper;
import com.tencent.mobileqq.qcircle.tempapi.interfaces.QCircleMessageFacadeListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.idata.IDataCallBack;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import qqcircle.QQCirclePrivateMsgShow.StBatchGetPMGiftInfoRsp;

public class QCircleChatListBlock
  extends QCircleBaseListBlock<QCircleRecentDataInterface, QQCirclePrivateMsgShow.StBatchGetPMGiftInfoRsp>
  implements DragFrameLayout.IDragViewProvider, DragFrameLayout.OnDragModeChangedListener, QCircleMessageFacadeListener
{
  private static final int LOAD_COUNT_PER_PAGE = 20;
  private static final String TAG = "QCircleChatListBlock";
  private View mBottomLine;
  private DragFrameLayout mDragHost;
  private boolean mHasInit;
  private boolean mIsActive;
  private boolean mOnTabSelected;
  private TextView mTvTitle;
  private DragTextView mTvUnReadNum;
  
  public QCircleChatListBlock(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  private void clearUnReadInfo() {}
  
  private void dragItemView(int paramInt)
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("dragItemView: index");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("QCircleChatListBlock", 1, ((StringBuilder)localObject).toString());
      if ((getDataList() != null) && (getDataList().size() > paramInt))
      {
        localObject = (QCircleRecentDataInterface)getDataList().get(paramInt);
        if (localObject != null)
        {
          ArrayList localArrayList = new ArrayList();
          localArrayList.add(((QCircleRecentDataInterface)localObject).getRecentUserUin());
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("clearChatUnRead uin");
          localStringBuilder.append(((QCircleRecentDataInterface)localObject).getRecentUserUin());
          QLog.d("QCircleChatListBlock", 1, localStringBuilder.toString());
          HostChatUtils.clearQCircleChatUnread(localArrayList, false);
          return;
        }
      }
    }
    catch (Exception localException)
    {
      QLog.e("QCircleChatListBlock", 1, localException.getMessage());
    }
  }
  
  private HashMap<String, String> getEntry(QCircleRecentDataInterface paramQCircleRecentDataInterface)
  {
    HashMap localHashMap = new HashMap();
    if (paramQCircleRecentDataInterface != null)
    {
      String str = paramQCircleRecentDataInterface.getTaskId();
      if (TextUtils.isEmpty(str)) {
        localHashMap.put("ext6", "0");
      } else {
        localHashMap.put("ext6", str);
      }
      if (paramQCircleRecentDataInterface.getUnreadNum() > 0)
      {
        localHashMap.put("ext7", "1");
        return localHashMap;
      }
      localHashMap.put("ext7", "0");
    }
    return localHashMap;
  }
  
  private HashMap<String, String> getEntryByReddot()
  {
    HashMap localHashMap = new HashMap();
    DragTextView localDragTextView = this.mTvUnReadNum;
    if ((localDragTextView != null) && (localDragTextView.getVisibility() == 0))
    {
      localHashMap.put("ext7", "1");
      return localHashMap;
    }
    localHashMap.put("ext7", "0");
    return localHashMap;
  }
  
  private void jumpPrivateChat(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    if (getContext() != null)
    {
      if (TextUtils.isEmpty(paramString1)) {
        return;
      }
      Intent localIntent = new Intent(getContext(), QCircleHostClassHelper.getChatActivityClass());
      localIntent.putExtra(QCircleHostConstants._ChatActivityConstants.OPEN_CHAT_FRAGMENT(), true);
      localIntent.putExtra("PREVIOUS_WINDOW", QCirclePersonalDetailFragment.class.getName());
      localIntent.putExtra(QCircleHostConstants.AppConstants.Key.UIN(), paramString1);
      if (QCirclePluginUtil.e(paramString1))
      {
        localIntent.putExtra(QCircleHostConstants.AppConstants.Key.UIN_TYPE(), QCircleHostConstants.AppConstants.Value.UIN_TYPE_FRIEND());
      }
      else
      {
        localIntent.putExtra(HostChatUtils.QCIRCLE_CHAT_HIDE_MENU_KEY(), true);
        localIntent.putExtra(QCircleHostConstants.AppConstants.Key.UIN_TYPE(), QCircleHostConstants.AppConstants.Value.UIN_TYPE_TEMP_CIRCLE());
      }
      if (paramArrayOfByte != null) {
        localIntent.putExtra(HostChatUtils.QCIRLCE_CHAT_GIFT_INFO_BYTES_KEY(), paramArrayOfByte);
      }
      localIntent.putExtra(QCircleHostConstants._ChatActivityConstants.KEY_AIO_MSG_SOURCE(), QCircleHostConstants._ChatActivityConstants.TYPE_DETAIL_MSG_REMIND());
      paramArrayOfByte = HostDataTransUtils.getBuddyName(paramString1, true);
      if (paramArrayOfByte.equals(paramString1))
      {
        if (paramString1.equals(paramString2)) {
          paramString2 = "";
        }
      }
      else {
        paramString2 = paramArrayOfByte;
      }
      paramArrayOfByte = QCircleHostConstants.AppConstants.Key.UIN_NAME();
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = "";
      }
      localIntent.putExtra(paramArrayOfByte, paramString1);
      getContext().startActivity(localIntent);
    }
  }
  
  private void notifyInMainThread()
  {
    RFThreadManager.getUIHandler().post(new QCircleChatListBlock.2(this));
  }
  
  private void setTabUnReadNum(int paramInt)
  {
    if (this.mTvUnReadNum != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateTabUnReadNum value:");
      localStringBuilder.append(paramInt);
      QLog.d("QCircleChatListBlock", 1, localStringBuilder.toString());
      if (paramInt > 0)
      {
        this.mTvUnReadNum.setText(HostChatUtils.getMaxUnReadCountText(paramInt));
        this.mTvUnReadNum.setVisibility(0);
        return;
      }
      this.mTvUnReadNum.setVisibility(8);
    }
  }
  
  private void updateGiftInfo()
  {
    RFThreadManager.getUIHandler().post(new QCircleChatListBlock.1(this));
  }
  
  public String getAttachInfoFromItemData(QCircleRecentDataInterface paramQCircleRecentDataInterface)
  {
    return null;
  }
  
  public String getAttachInfoFromRsp(QQCirclePrivateMsgShow.StBatchGetPMGiftInfoRsp paramStBatchGetPMGiftInfoRsp)
  {
    return null;
  }
  
  public List<Part> getCustomParts()
  {
    return null;
  }
  
  public String getDaTongPageId()
  {
    return "pg_xsj_private_message_page";
  }
  
  public String getDropFrameMonitorTag()
  {
    return QCircleHostDropFrameMonitorHelper._Constants.QCIRCLE_CHAT_LIST();
  }
  
  public String getEmptyHint()
  {
    return null;
  }
  
  public boolean getIsFinishFromRsp(QQCirclePrivateMsgShow.StBatchGetPMGiftInfoRsp paramStBatchGetPMGiftInfoRsp)
  {
    return true;
  }
  
  public void getListDataAsync(IDataCallBack<QCircleRecentDataInterface> paramIDataCallBack, String paramString)
  {
    RFThreadManager.execute(new QCircleChatListBlock.3(this, paramIDataCallBack));
  }
  
  public List<QCircleRecentDataInterface> getListDataFromRsp(QQCirclePrivateMsgShow.StBatchGetPMGiftInfoRsp paramStBatchGetPMGiftInfoRsp)
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
  
  public BaseRequest getRequest(String paramString)
  {
    return null;
  }
  
  public ArrayList<String> getSendUinFromChatListData(List<QCircleRecentDataInterface> paramList)
  {
    HashSet localHashSet = new HashSet();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      QCircleRecentDataInterface localQCircleRecentDataInterface = (QCircleRecentDataInterface)paramList.next();
      if (localQCircleRecentDataInterface != null) {
        localHashSet.add(localQCircleRecentDataInterface.getRecentUserUin());
      }
    }
    return new ArrayList(localHashSet);
  }
  
  public String getTitle()
  {
    return HardCodeUtil.a(2131895651);
  }
  
  public View getTitleTabView(ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131626884, paramViewGroup, false);
    this.mTvTitle = ((TextView)paramViewGroup.findViewById(2131448792));
    this.mBottomLine = paramViewGroup.findViewById(2131449321);
    this.mTvUnReadNum = ((DragTextView)paramViewGroup.findViewById(2131448696));
    this.mTvUnReadNum.setDragViewType(2);
    this.mTvTitle.setText(HardCodeUtil.a(2131895651));
    this.mBottomLine.setVisibility(8);
    this.mTvUnReadNum.setVisibility(8);
    return paramViewGroup;
  }
  
  public int getViewTypeCount()
  {
    return 1;
  }
  
  public void initTitleBar(View paramView) {}
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    HostDataTransUtils.removeMsgFacadeObserver(this);
    QLog.d("QCircleChatListBlock", 1, "getMessageFacade deleteObserver");
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    super.onActivityPaused(paramActivity);
    QLog.d("QCircleChatListBlock", 1, "chatList is paused");
    this.mIsActive = false;
    paramActivity = this.mDragHost;
    if (paramActivity != null) {
      paramActivity.a();
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
    if (this.mHasInit)
    {
      QLog.d("QCircleChatListBlock", 1, "onActivityResumed refresh");
      refreshData();
    }
    else
    {
      QLog.d("QCircleChatListBlock", 1, "firstCome not refreshData");
      this.mHasInit = true;
    }
    this.mIsActive = true;
    clearUnReadInfo();
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (this.mDataList != null)
    {
      QCircleRecentDataInterface localQCircleRecentDataInterface = (QCircleRecentDataInterface)this.mDataList.get(paramInt);
      ((BaseListBlock.BaseListVH)paramViewHolder).a(localQCircleRecentDataInterface, paramInt, this.mExtraTypeInfo);
      paramViewHolder.itemView.setOnClickListener(new QCircleChatListBlock.5(this, localQCircleRecentDataInterface));
      QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(localQCircleRecentDataInterface.getRecentUserUin()).setActionType(80).setSubActionType(2).setThrActionType(0).setExtras(getEntry(localQCircleRecentDataInterface)));
    }
  }
  
  public void onChange(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    if (paramBoolean)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDragStateChange: isDone");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" dragType:");
      localStringBuilder.append(paramInt);
      QLog.d("QCircleChatListBlock", 1, localStringBuilder.toString());
      if (paramInt == 2)
      {
        QLog.d("QCircleChatListBlock", 1, "dragTabRed clear unRead");
        HostChatUtils.clearQCircleChatUnread(getSendUinFromChatListData(getDataList()), false);
        return;
      }
      if ((paramInt == 0) && (paramDragFrameLayout != null))
      {
        paramDragFrameLayout = paramDragFrameLayout.getDragView();
        if ((paramDragFrameLayout != null) && ((paramDragFrameLayout.getTag() instanceof Integer))) {
          dragItemView(((Integer)paramDragFrameLayout.getTag()).intValue());
        }
      }
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = new QCircleChatItemView(getContext());
    paramViewGroup.setDragFrameLayout(this.mDragHost);
    return new BaseListBlock.BaseListVH(paramViewGroup);
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
        localObject = ((QCircleChatItemView)localObject).getRedPointView();
        if ((localObject != null) && (((DragTextView)localObject).getVisibility() == 0) && (((DragTextView)localObject).getDragViewType() != -1)) {
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
    QLog.d("QCircleChatListBlock", 1, "getMessageFacade addObserver");
    HostDataTransUtils.addMsgFacadeObserver(this);
    this.mDragHost = DragFrameLayout.a(getActivity());
    this.mDragHost.a(this, true);
    this.mDragHost.setDragViewProvider(this);
    getBlockMerger().b("");
    paramBundle = this.mTvUnReadNum;
    if (paramBundle != null) {
      paramBundle.setOnModeChangeListener(this.mDragHost);
    }
  }
  
  public void onTitleTabSelectedChanged(View paramView, boolean paramBoolean)
  {
    if (paramView != null)
    {
      paramView = this.mBottomLine;
      int i;
      if (paramBoolean) {
        i = 0;
      } else {
        i = 8;
      }
      paramView.setVisibility(i);
      Object localObject = this.mTvTitle;
      if (paramBoolean) {
        paramView = Typeface.DEFAULT_BOLD;
      } else {
        paramView = Typeface.DEFAULT;
      }
      ((TextView)localObject).setTypeface(paramView);
      paramView = this.mTvTitle;
      localObject = QCircleSkinHelper.getInstance();
      if (paramBoolean) {
        i = 2131167084;
      } else {
        i = 2131167085;
      }
      paramView.setTextColor(((QCircleSkinHelper)localObject).getColor(i));
    }
    if (this.mOnTabSelected != paramBoolean)
    {
      this.mOnTabSelected = paramBoolean;
      if (this.mOnTabSelected) {
        QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(80).setSubActionType(1).setThrActionType(0).setExtras(getEntryByReddot()));
      }
    }
  }
  
  public void preHandleListData(List<QCircleRecentDataInterface> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    updateGiftInfo();
    if (getContext() == null) {
      return;
    }
    paramList = getSendUinFromChatListData(paramList);
    if (paramList != null)
    {
      if (paramList.size() <= 0) {
        return;
      }
      paramList = new QCircleChatBatchGetPMGiftInfoRequest(paramList);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reqCmd");
      localStringBuilder.append(paramList.getCmdName());
      QLog.d("QCircleChatListBlock", 1, localStringBuilder.toString());
      VSNetworkHelper.getInstance().sendRequest(getContext().hashCode(), paramList, new QCircleChatListBlock.4(this));
    }
  }
  
  public void refreshData()
  {
    DragFrameLayout localDragFrameLayout = this.mDragHost;
    if ((localDragFrameLayout != null) && (localDragFrameLayout.getMode() == -1)) {
      onRefreshData();
    }
  }
  
  public void tryRefreshData()
  {
    if (this.mIsActive)
    {
      QLog.d("QCircleChatListBlock", 1, "receiveQCircleMessage is active update");
      refreshData();
      QCircleChatBoxHelper.getInstance().clearUnReadInfo();
      return;
    }
    QLog.d("QCircleChatListBlock", 1, "receiveQCircleMessage is not active not update");
  }
  
  protected void updateChatInfo()
  {
    Iterator localIterator = getDataList().iterator();
    while (localIterator.hasNext()) {
      ((QCircleRecentDataInterface)localIterator.next()).update();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.list.bizblocks.QCircleChatListBlock
 * JD-Core Version:    0.7.0.1
 */