package com.tencent.hippy.qq.tuwen.adapter;

import android.content.Intent;
import android.os.Looper;
import android.os.MessageQueue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.collection.ArraySet;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListFragment.HippyCommentPageListener;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentUtils;
import com.tencent.biz.pubaccount.readinjoy.comment.data.AnchorData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentDataManager;
import com.tencent.biz.pubaccount.readinjoy.comment.handler.bean.FirstCommentCreateData;
import com.tencent.biz.pubaccount.readinjoy.comment.topic.RIJCommentTopicUtil;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebPTSUtils;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.hippy.qq.fragment.HippyActivityLifecycleDispatcher;
import com.tencent.hippy.qq.fragment.HippyActivityLifecycleOwner;
import com.tencent.hippy.qq.tuwen.app.TKDTuWenHippyEngine;
import com.tencent.hippy.qq.tuwen.callback.ITKDTuWenHippyCallback;
import com.tencent.hippy.qq.tuwen.callback.ITKDTuWenHippyObservable;
import com.tencent.hippy.qq.tuwen.callback.ITKDTuWenHippyObserver;
import com.tencent.hippy.qq.tuwen.view.HippyRootLayout;
import com.tencent.hippy.qq.tuwen.view.NSRIJCommentListView;
import com.tencent.hippy.qq.utils.tkd.TKDCommentDispatcher;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.mobileqq.widget.WebViewProgressBarController;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.Pair;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ListView;
import java.util.Iterator;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

public class TKDTuWenHippyCommentAdapter
  extends BaseAdapter
  implements HippyActivityLifecycleOwner, ITKDTuWenHippyObservable
{
  private static final String TAG = "TKDTuWenHippyCommentAdapter";
  private int adTag;
  AnchorData anchorData;
  private int biuType;
  private ReadInJoyCommentDataManager commentDataManager;
  int contentSrc;
  private final QBaseActivity context;
  private TKDTuWenHippyCommentAdapter.MyDataChangeListener dataChangeListener;
  private final HippyActivityLifecycleDispatcher hippyActivityLifecycleDispatcher = new HippyActivityLifecycleDispatcher();
  private TKDTuWenHippyCommentAdapter.HippyCommentEventReceiver hippyCommentEventReceiver;
  private ReadInJoyCommentListFragment.HippyCommentPageListener hippyCommentPageListener;
  private TKDTuWenHippyEngine hippyEngine;
  private final Set<ITKDTuWenHippyObserver> hippyObservers = new ArraySet();
  private TKDTuWenHippyCommentAdapter.ActivityLifecycleCallbacks lifecycleCallbacks;
  ArticleInfo mArticleInfo;
  boolean openCommentEditor;
  private ITKDTuWenHippyCallback tuWenHippyCallback;
  private HippyRootLayout vContainer;
  private HippyRootView vHippyRoot;
  ListView vList;
  private WebViewProgressBar vProgress;
  
  public TKDTuWenHippyCommentAdapter(QBaseActivity paramQBaseActivity)
  {
    this.context = paramQBaseActivity;
  }
  
  private void addHippyViewToHippyLayout()
  {
    if (this.vContainer == null) {
      return;
    }
    if (this.vHippyRoot != null)
    {
      if (this.vHippyRoot.getParent() == null)
      {
        this.vContainer.addView(this.vHippyRoot);
        int i = this.vList.getMeasuredHeight();
        if (i > 0) {
          this.vContainer.setMaxHeight(i);
        }
      }
      this.vProgress.setVisibility(8);
    }
    for (;;)
    {
      AbsListView.LayoutParams localLayoutParams = (AbsListView.LayoutParams)this.vContainer.getLayoutParams();
      localLayoutParams.height = this.vContainer.getDesiredHeight();
      this.vContainer.setLayoutParams(localLayoutParams);
      return;
      this.vProgress.setVisibility(0);
    }
  }
  
  private boolean commentModuleInWhiteList()
  {
    return HippyQQEngine.getModuleOnlineConfig(this.hippyEngine.getModuleName()) == 1;
  }
  
  private HippyMap getPropMap()
  {
    int j = 0;
    HippyMap localHippyMap = new HippyMap();
    Pair localPair = ReadInJoyCommentUtils.a(this.mArticleInfo, null);
    this.biuType = ((Integer)localPair.first).intValue();
    this.adTag = ((Integer)localPair.second).intValue();
    localHippyMap.pushString("rowkey", this.mArticleInfo.innerUniqueID);
    localHippyMap.pushString("articleId", String.valueOf(this.mArticleInfo.mArticleID));
    localHippyMap.pushInt("contentSrcType", this.contentSrc);
    localHippyMap.pushString("reportData", "{1," + this.contentSrc + '}');
    localHippyMap.pushDouble("fontScale", FastWebPTSUtils.a().floatValue());
    if (this.openCommentEditor)
    {
      i = 1;
      localHippyMap.pushInt("isEdit", i);
      localHippyMap.pushBoolean("topicSwitch", RIJCommentTopicUtil.a());
      if (this.anchorData != null)
      {
        localHippyMap.pushString("anchorFirstCommentId", this.anchorData.jdField_a_of_type_JavaLangString);
        localHippyMap.pushString("anchorSubCommentId", this.anchorData.jdField_b_of_type_JavaLangString);
        if (!this.anchorData.jdField_b_of_type_Boolean) {
          break label272;
        }
      }
    }
    label272:
    for (int i = 0;; i = 1)
    {
      localHippyMap.pushInt("defaultCommentType", i);
      i = j;
      if (this.anchorData.jdField_a_of_type_Boolean) {
        i = 1;
      }
      localHippyMap.pushInt("isAwesome", i);
      QLog.d("TKDTuWenHippyCommentAdapter", 1, "pros: " + localHippyMap);
      return localHippyMap;
      i = 0;
      break;
    }
  }
  
  private boolean initHippyEngine()
  {
    this.hippyEngine = new TKDTuWenHippyEngine(this.context);
    this.hippyEngine.setTuWenHippyObservable(this);
    if (!commentModuleInWhiteList())
    {
      QLog.d("TKDTuWenHippyCommentAdapter", 1, "Hippy: module not in whitelist");
      notifyHippyLoadFinish(false);
      return false;
    }
    this.hippyEngine.setPropsMap(getPropMap());
    this.hippyEngine.setHippyActivityLifecycleOwner(this);
    this.hippyEngine.initHippyInContainer(null, new JSONObject(), false, new TKDTuWenHippyCommentAdapter.MyEngineListener(this, null));
    return true;
  }
  
  private void initView()
  {
    if (this.vContainer != null) {
      return;
    }
    this.vContainer = ((HippyRootLayout)LayoutInflater.from(this.context).inflate(2131560096, this.vList, false));
    this.vProgress = ((WebViewProgressBar)this.vContainer.findViewById(2131373554));
    WebViewProgressBarController localWebViewProgressBarController = new WebViewProgressBarController();
    localWebViewProgressBarController.a(this.vProgress);
    this.vProgress.setController(localWebViewProgressBarController);
    localWebViewProgressBarController.a((byte)0);
    addHippyViewToHippyLayout();
  }
  
  private void notifyHippyLoadFinish(boolean paramBoolean)
  {
    if (this.hippyCommentPageListener != null) {
      this.hippyCommentPageListener.a(paramBoolean);
    }
  }
  
  private void onEngineLoadSuccess()
  {
    if (this.hippyEngine == null) {
      return;
    }
    initDelay();
    initView();
    this.vHippyRoot = this.hippyEngine.getHippyRootView();
    addHippyViewToHippyLayout();
    notifyHippyLoadFinish(true);
    notifyDataSetChanged();
  }
  
  private void wrapperIntentForEditComment(Intent paramIntent)
  {
    if (paramIntent.hasExtra("comment_create_data")) {
      return;
    }
    FirstCommentCreateData localFirstCommentCreateData = new FirstCommentCreateData(this.contentSrc, "");
    localFirstCommentCreateData.b(this.mArticleInfo.innerUniqueID);
    localFirstCommentCreateData.c(String.valueOf(this.mArticleInfo.mArticleID));
    localFirstCommentCreateData.b(0);
    paramIntent.putExtra("comment_create_data", localFirstCommentCreateData);
  }
  
  public void destroy()
  {
    if (this.hippyEngine != null)
    {
      this.hippyEngine.onDestroy();
      this.hippyEngine = null;
    }
    this.hippyCommentPageListener = null;
    if (this.commentDataManager != null) {
      this.commentDataManager.a(this.dataChangeListener);
    }
    this.context.unregisterActivityLifecycleCallbacks(this.lifecycleCallbacks);
    TKDCommentDispatcher.INSTANCE.removeEventListener(this.hippyCommentEventReceiver);
  }
  
  public void forbidScroll(boolean paramBoolean)
  {
    if ((this.vList instanceof NSRIJCommentListView)) {
      ((NSRIJCommentListView)this.vList).setForbidScroll(paramBoolean);
    }
  }
  
  public int getCount()
  {
    return 1;
  }
  
  @NotNull
  public HippyActivityLifecycleDispatcher getDispatcher()
  {
    return this.hippyActivityLifecycleDispatcher;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    addHippyViewToHippyLayout();
    HippyRootLayout localHippyRootLayout = this.vContainer;
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localHippyRootLayout;
  }
  
  public void init()
  {
    if (initHippyEngine()) {
      initView();
    }
  }
  
  void initDelay()
  {
    this.hippyCommentEventReceiver = new TKDTuWenHippyCommentAdapter.HippyCommentEventReceiver(this, null);
    TKDCommentDispatcher.INSTANCE.addEventListener(this.hippyCommentEventReceiver);
    this.lifecycleCallbacks = new TKDTuWenHippyCommentAdapter.ActivityLifecycleCallbacks(this, null);
    this.lifecycleCallbacks.doOnActivityPostResumed(this.context);
    this.context.registerActivityLifecycleCallbacks(this.lifecycleCallbacks);
    this.commentDataManager = ReadInJoyCommentDataManager.a(this.mArticleInfo, this.contentSrc);
    this.dataChangeListener = new TKDTuWenHippyCommentAdapter.MyDataChangeListener(this, null);
    this.commentDataManager.a(this.dataChangeListener);
    this.commentDataManager.c(true);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 117) {
      wrapperIntentForEditComment(paramIntent);
    }
    this.hippyActivityLifecycleDispatcher.onActivityResult(this.context, paramInt1, paramInt2, paramIntent);
  }
  
  public void onHippyLoadStatusChanged(int paramInt)
  {
    if ((this.vContainer == null) || (!(this.vList instanceof NSRIJCommentListView)))
    {
      QLog.d("TKDTuWenHippyCommentAdapter", 1, "onHippyLoadStatusChanged: vContainer is null, status=" + paramInt);
      return;
    }
    QLog.d("TKDTuWenHippyCommentAdapter", 1, "onHippyLoadStatusChanged: status=" + paramInt);
    this.vContainer.setStatus(paramInt);
  }
  
  public void onOpenCommentEdit()
  {
    Iterator localIterator = this.hippyObservers.iterator();
    while (localIterator.hasNext())
    {
      ITKDTuWenHippyObserver localITKDTuWenHippyObserver = (ITKDTuWenHippyObserver)localIterator.next();
      if (localITKDTuWenHippyObserver != null) {
        localITKDTuWenHippyObserver.onOpenCommentPublisher();
      }
    }
  }
  
  public void onUpdate(long paramLong)
  {
    if (this.tuWenHippyCallback != null) {
      this.tuWenHippyCallback.onUpdate(paramLong);
    }
  }
  
  public void openSubCommentPage(String paramString1, String paramString2)
  {
    this.tuWenHippyCallback.openSubCommentPage(paramString1, paramString2);
  }
  
  public void register(ITKDTuWenHippyObserver paramITKDTuWenHippyObserver)
  {
    if (paramITKDTuWenHippyObserver != null) {
      this.hippyObservers.add(paramITKDTuWenHippyObserver);
    }
  }
  
  public void scrollToNew()
  {
    Looper.myQueue().addIdleHandler(new TKDTuWenHippyCommentAdapter.1(this));
  }
  
  public void sendCommentReadTime(long paramLong)
  {
    Iterator localIterator = this.hippyObservers.iterator();
    while (localIterator.hasNext())
    {
      ITKDTuWenHippyObserver localITKDTuWenHippyObserver = (ITKDTuWenHippyObserver)localIterator.next();
      if (localITKDTuWenHippyObserver != null) {
        localITKDTuWenHippyObserver.sendCommentReadTime(paramLong);
      }
    }
  }
  
  public void setHippyCommentPageListener(ReadInJoyCommentListFragment.HippyCommentPageListener paramHippyCommentPageListener)
  {
    this.hippyCommentPageListener = paramHippyCommentPageListener;
  }
  
  public void setTuWenHippyCallback(ITKDTuWenHippyCallback paramITKDTuWenHippyCallback)
  {
    this.tuWenHippyCallback = paramITKDTuWenHippyCallback;
  }
  
  public void unregister(ITKDTuWenHippyObserver paramITKDTuWenHippyObserver)
  {
    if (paramITKDTuWenHippyObserver != null) {
      this.hippyObservers.remove(paramITKDTuWenHippyObserver);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.tuwen.adapter.TKDTuWenHippyCommentAdapter
 * JD-Core Version:    0.7.0.1
 */