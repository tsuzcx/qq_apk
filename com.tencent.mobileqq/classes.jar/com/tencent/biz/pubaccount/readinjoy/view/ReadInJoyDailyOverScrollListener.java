package com.tencent.biz.pubaccount.readinjoy.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyDailyViewController;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyActivityHelper;
import com.tencent.biz.pubaccount.readinjoy.common.KandianDailyReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.DailyModeConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.InsertArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import com.tencent.widget.ReadInJoyOverScrollViewListener;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.List;
import mqq.app.AppRuntime;

public class ReadInJoyDailyOverScrollListener
  implements ReadInJoyOverScrollViewListener
{
  private float jdField_a_of_type_Float = 0.0F;
  private Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator = new AccelerateInterpolator();
  
  private ImageView a(ListView paramListView)
  {
    if ((paramListView != null) && (paramListView.getOverScrollFooterView() != null)) {
      return (ImageView)paramListView.getOverScrollFooterView().findViewById(2131369743);
    }
    return null;
  }
  
  public static String a(Context paramContext)
  {
    return (String)ReadInJoyHelper.a("kandian_daily_wrapper_default_text", paramContext.getResources().getString(2131718178));
  }
  
  public static void a(int paramInt)
  {
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = RIJTransMergeKanDianReport.a();
    localReportR5Builder.b("jump_src", DailyModeConfigHandler.b());
    localReportR5Builder.b("entrance", "" + paramInt);
    localReportR5Builder.b("cmd", ReadInJoyHelper.i());
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009883", "0X8009883", 0, 0, "", "", "", localReportR5Builder.a(), false);
  }
  
  public static void a(Activity paramActivity)
  {
    a(paramActivity, null);
  }
  
  public static void a(Activity paramActivity, Bundle paramBundle)
  {
    Bundle localBundle = new Bundle();
    List localList = ReadInJoyLogicEngine.a().a(Integer.valueOf(DailyModeConfigHandler.b()));
    if ((localList != null) && (!localList.isEmpty()))
    {
      KandianMergeManager localKandianMergeManager = (KandianMergeManager)ReadInJoyUtils.a().getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
      KandianMergeManager.InsertArticleInfo localInsertArticleInfo = new KandianMergeManager.InsertArticleInfo();
      localInsertArticleInfo.jdField_a_of_type_Long = ((Long)localList.get(localList.size() - 1)).longValue();
      localInsertArticleInfo.jdField_a_of_type_Int = 13;
      localKandianMergeManager.a(localInsertArticleInfo);
    }
    paramActivity.finish();
    paramActivity.overridePendingTransition(2130771992, 2130772362);
    localBundle.putString("folder_status", KandianDailyReportUtils.a());
    localBundle.putBoolean("force_refresh", true);
    if (paramBundle != null) {
      localBundle.putAll(paramBundle);
    }
    ReadInJoyActivityHelper.a((QQAppInterface)ReadInJoyUtils.a(), paramActivity, 13, 0, localBundle);
  }
  
  private void a(ListView paramListView)
  {
    paramListView = a(paramListView);
    if (paramListView == null) {
      return;
    }
    paramListView.setPivotX(paramListView.getWidth() / 2);
    paramListView.setPivotY(paramListView.getHeight() / 2);
    paramListView.setRotation(0.0F);
  }
  
  private void b(ListView paramListView)
  {
    if (ReadInJoyDailyViewController.a() == 1)
    {
      a((Activity)paramListView.getContext());
      a(1);
    }
    String str;
    do
    {
      return;
      str = DailyModeConfigHandler.a();
    } while (TextUtils.isEmpty(str));
    ReadInJoyUtils.a(paramListView.getContext(), str);
    a(1);
  }
  
  public void onNotCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    QLog.d("ReadInJoyDailyOverScrollListener", 2, "[onNotCompleteVisable] " + paramInt);
    if (paramInt == 1) {
      a(paramListView);
    }
  }
  
  public void onNotCompleteVisable(int paramInt1, View paramView, ListView paramListView, int paramInt2)
  {
    QLog.d("ReadInJoyDailyOverScrollListener", 2, "[onNotCompleteVisable] " + paramInt1);
    if (paramInt1 == 1) {
      a(paramListView);
    }
  }
  
  public void onScrollView(View paramView, ListView paramListView, int paramInt)
  {
    float f1 = paramView.getHeight();
    float f2 = (float)(paramInt * 1.0D / f1);
    f1 = f2;
    if (f2 >= 1.0D) {
      f1 = 1.0F;
    }
    this.jdField_a_of_type_Float = f1;
    f1 = this.jdField_a_of_type_AndroidViewAnimationInterpolator.getInterpolation(f1);
    paramView = a(paramListView);
    if (paramView == null) {
      return;
    }
    paramView.setPivotX(paramView.getWidth() / 2);
    paramView.setPivotY(paramView.getHeight() / 2);
    paramView.setRotation(f1 * 180.0F);
  }
  
  public void onViewCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    QLog.d("ReadInJoyDailyOverScrollListener", 2, "[onViewCompleteVisable] ");
  }
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    QLog.d("ReadInJoyDailyOverScrollListener", 2, "[onViewCompleteVisableAndReleased] " + paramInt);
    if (paramInt == 1) {
      b(paramListView);
    }
    return false;
  }
  
  public void onViewNotCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    QLog.d("ReadInJoyDailyOverScrollListener", 2, "[onViewNotCompleteVisableAndReleased] " + paramInt);
    if (paramInt != 1) {}
    do
    {
      return;
      a(paramListView);
    } while (this.jdField_a_of_type_Float <= DailyModeConfigHandler.a());
    QLog.d("ReadInJoyDailyOverScrollListener", 2, "[onViewCompleteVisableAndReleased] ");
    b(paramListView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyDailyOverScrollListener
 * JD-Core Version:    0.7.0.1
 */