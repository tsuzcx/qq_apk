package com.tencent.biz.qqcircle.fragments.content;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.qflutter.qqcircle.TencentQQCirclePlugin;
import com.tencent.biz.qqcircle.beans.QCircleCommentInfo;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.events.QCircleAtUpdateEvent;
import com.tencent.biz.qqcircle.flutter.QQCircleMethodImpl;
import com.tencent.biz.qqcircle.flutter.QQCircleMethodMine;
import com.tencent.biz.qqcircle.flutter.QcircleFlutterEventReceiver;
import com.tencent.biz.qqcircle.flutter.event.QCircleFlutterCommentCloseEvent;
import com.tencent.biz.qqcircle.flutter.event.QCircleFlutterPolyLikeCloseEvent;
import com.tencent.biz.qqcircle.flutter.event.QCircleFlutterShareCloseEvent;
import com.tencent.biz.qqcircle.flutter.layer.QCircleFlutterCommentLayer;
import com.tencent.biz.qqcircle.flutter.layer.QCircleFlutterPolyLikeLayer;
import com.tencent.biz.qqcircle.flutter.utils.QCircleFlutterNativeShareUtils;
import com.tencent.biz.qqcircle.flutter.utils.QCircleFlutterNativeShareUtils.ShareActionSheetParam;
import com.tencent.biz.qqcircle.utils.QCircleThemeUtil;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.event.HostActivityResultEvent;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QCircleFlutterContentDetailTransFragment
  extends BasePartFragment
  implements SimpleEventReceiver
{
  private boolean a = true;
  private QCircleFlutterCommentLayer b;
  
  private void a()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity == null)
    {
      QLog.d("QCircleContentDetailFragment", 1, "[finishActivity] activity not is null.");
      return;
    }
    localFragmentActivity.finish();
  }
  
  private void a(ViewGroup paramViewGroup)
  {
    if (paramViewGroup == null) {
      return;
    }
    QCircleFlutterPolyLikeLayer localQCircleFlutterPolyLikeLayer = new QCircleFlutterPolyLikeLayer(getActivity());
    paramViewGroup.addView(localQCircleFlutterPolyLikeLayer);
    paramViewGroup.post(new QCircleFlutterContentDetailTransFragment.1(this, localQCircleFlutterPolyLikeLayer));
  }
  
  private void a(ViewGroup paramViewGroup, String paramString)
  {
    if (paramViewGroup == null) {
      return;
    }
    FeedCloudMeta.StFeed localStFeed = QQCircleMethodImpl.getInstance().getCurrentFeed();
    if (localStFeed == null)
    {
      QLog.w("QCircleContentDetailFragment", 1, "[handleComment] invalid feed");
      return;
    }
    this.b = new QCircleFlutterCommentLayer(getContext());
    QCircleReportBean localQCircleReportBean = new QCircleReportBean();
    localQCircleReportBean.setPageId(57);
    QCircleExtraTypeInfo localQCircleExtraTypeInfo = new QCircleExtraTypeInfo();
    localQCircleExtraTypeInfo.mFeed = localStFeed;
    try
    {
      if (QQCircleMethodMine.getCurrentReportParam() != null)
      {
        localQCircleExtraTypeInfo.mDataPosition = ((Integer)QQCircleMethodMine.getCurrentReportParam().get("current_index")).intValue();
        localQCircleExtraTypeInfo.sourceType = ((Integer)QQCircleMethodMine.getCurrentReportParam().get("source_type")).intValue();
        localQCircleReportBean.setFromPageId(((Integer)QQCircleMethodMine.getCurrentReportParam().get("from_page_id")).intValue());
      }
    }
    catch (Exception localException)
    {
      QLog.e("QCircleContentDetailFragment", 1, "[handleComment] error: ", localException);
    }
    localQCircleReportBean.setFromPageId(localQCircleExtraTypeInfo.sourceType);
    localQCircleExtraTypeInfo.mPlayScene = 2;
    localQCircleExtraTypeInfo.title = localStFeed.title.get();
    this.b.a(getActivity(), localQCircleReportBean);
    paramViewGroup.addView(this.b);
    paramViewGroup = new QCircleCommentInfo();
    paramViewGroup.b = localStFeed;
    paramViewGroup.c = localQCircleExtraTypeInfo;
    if (paramString.equals("CommentInputClick"))
    {
      paramViewGroup.h = 103;
      this.b.b(paramViewGroup);
      return;
    }
    if (paramString.equals("CommentClick")) {
      this.b.a(paramViewGroup);
    }
  }
  
  private void a(@NonNull QCircleFlutterPolyLikeCloseEvent paramQCircleFlutterPolyLikeCloseEvent)
  {
    if (paramQCircleFlutterPolyLikeCloseEvent.mIsClickItem == 1)
    {
      this.a = false;
      return;
    }
    if (this.a)
    {
      a();
      return;
    }
    this.a = true;
  }
  
  private void a(String paramString)
  {
    Object localObject = QQCircleMethodImpl.getInstance().getCurrentFeed();
    if (localObject == null)
    {
      QLog.w("QCircleContentDetailFragment", 1, "[handleComment] invalid feed");
      return;
    }
    QCircleExtraTypeInfo localQCircleExtraTypeInfo = new QCircleExtraTypeInfo();
    localQCircleExtraTypeInfo.mFeed = ((FeedCloudMeta.StFeed)localObject);
    Map localMap = QQCircleMethodMine.getCurrentReportParam();
    int i;
    if (localMap != null) {
      try
      {
        localQCircleExtraTypeInfo.mDataPosition = ((Integer)localMap.get("current_index")).intValue();
        localQCircleExtraTypeInfo.sourceType = ((Integer)localMap.get("source_type")).intValue();
        i = ((Integer)localMap.get("photo_index")).intValue();
      }
      catch (Exception localException)
      {
        QLog.e("QCircleContentDetailFragment", 1, "[handleShare]", localException);
      }
    } else {
      i = 0;
    }
    QCircleReportBean localQCircleReportBean = new QCircleReportBean();
    localQCircleReportBean.setPageId(57);
    localQCircleReportBean.setFromPageId(localQCircleExtraTypeInfo.sourceType);
    localQCircleExtraTypeInfo.mPlayScene = 2;
    localQCircleExtraTypeInfo.title = ((FeedCloudMeta.StFeed)localObject).title.get();
    localObject = new QCircleFlutterNativeShareUtils.ShareActionSheetParam();
    ((QCircleFlutterNativeShareUtils.ShareActionSheetParam)localObject).a(localQCircleExtraTypeInfo);
    ((QCircleFlutterNativeShareUtils.ShareActionSheetParam)localObject).a(i);
    ((QCircleFlutterNativeShareUtils.ShareActionSheetParam)localObject).a(localQCircleReportBean);
    if ("1".equals(paramString)) {
      ((QCircleFlutterNativeShareUtils.ShareActionSheetParam)localObject).a(false);
    }
    QCircleFlutterNativeShareUtils.a(getActivity(), (QCircleFlutterNativeShareUtils.ShareActionSheetParam)localObject);
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    QCircleThemeUtil.a(getActivity(), getContext().getResources().getColor(2131168376));
    SimpleEventBus.getInstance().registerReceiver(this);
    SimpleEventBus.getInstance().registerReceiver(QcircleFlutterEventReceiver.a());
    Object localObject = new HashMap();
    ((Map)localObject).put("eventType", "nativeWindowOpen");
    TencentQQCirclePlugin.sendEvent("tencent_qqcircle/dataChange", (Map)localObject);
    localObject = getActivity().getIntent().getStringExtra("type");
    String str = getActivity().getIntent().getStringExtra("only_show_share");
    switch (((String)localObject).hashCode())
    {
    default: 
      break;
    case 933846665: 
      if (((String)localObject).equals("CommentClick")) {
        i = 0;
      }
      break;
    case 179401993: 
      if (((String)localObject).equals("ShareClick")) {
        i = 2;
      }
      break;
    case 2206589: 
      if (((String)localObject).equals("CommentInputClick")) {
        i = 1;
      }
      break;
    case -1927373492: 
      if (((String)localObject).equals("PraiseClick")) {
        i = 3;
      }
      break;
    }
    int i = -1;
    if ((i != 0) && (i != 1))
    {
      if (i != 2)
      {
        if (i == 3) {
          a(paramViewGroup);
        }
      }
      else {
        a(str);
      }
    }
    else {
      a(paramViewGroup, (String)localObject);
    }
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public String b()
  {
    return null;
  }
  
  protected int c()
  {
    return 2131626823;
  }
  
  protected List<Part> d()
  {
    return null;
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleFlutterCommentCloseEvent.class);
    localArrayList.add(QCircleFlutterPolyLikeCloseEvent.class);
    localArrayList.add(QCircleFlutterShareCloseEvent.class);
    localArrayList.add(HostActivityResultEvent.class);
    return localArrayList;
  }
  
  protected int j()
  {
    return 0;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    QLog.d("QCircleContentDetailFragment", 1, new Object[] { "[onActivityResult] requestCode: ", Integer.valueOf(paramInt1), " | resultCode: ", Integer.valueOf(paramInt2) });
    if (257 == paramInt1)
    {
      paramIntent = new QCircleAtUpdateEvent(getContext(), paramIntent);
      SimpleEventBus.getInstance().dispatchEvent(paramIntent);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public void onDestroy()
  {
    SimpleEventBus.getInstance().unRegisterReceiver(this);
    Object localObject = new HashMap();
    ((Map)localObject).put("eventType", "nativeWindowClose");
    TencentQQCirclePlugin.sendEvent("tencent_qqcircle/dataChange", (Map)localObject);
    localObject = this.b;
    if (localObject != null)
    {
      ((QCircleFlutterCommentLayer)localObject).a();
      this.b = null;
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    getActivity().overridePendingTransition(0, 0);
    super.onPause();
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCircleFlutterCommentCloseEvent))
    {
      a();
      return;
    }
    if ((paramSimpleBaseEvent instanceof QCircleFlutterShareCloseEvent))
    {
      a();
      return;
    }
    if ((paramSimpleBaseEvent instanceof QCircleFlutterPolyLikeCloseEvent))
    {
      a((QCircleFlutterPolyLikeCloseEvent)paramSimpleBaseEvent);
      return;
    }
    if ((paramSimpleBaseEvent instanceof HostActivityResultEvent))
    {
      paramSimpleBaseEvent = (HostActivityResultEvent)paramSimpleBaseEvent;
      onActivityResult(paramSimpleBaseEvent.getRequestCode(), paramSimpleBaseEvent.getResultCode(), paramSimpleBaseEvent.getIntent());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.QCircleFlutterContentDetailTransFragment
 * JD-Core Version:    0.7.0.1
 */