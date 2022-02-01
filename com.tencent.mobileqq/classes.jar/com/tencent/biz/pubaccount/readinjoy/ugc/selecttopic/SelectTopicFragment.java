package com.tencent.biz.pubaccount.readinjoy.ugc.selecttopic;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJQQAppInterfaceUtil;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.biz.pubaccount.readinjoy.mvp.ListContract.IListModel;
import com.tencent.biz.pubaccount.readinjoy.mvp.ListPresenter;
import com.tencent.biz.pubaccount.readinjoy.ugc.RIJUgcUtils;
import com.tencent.biz.pubaccount.readinjoy.ugc.mycolumn.MyColumnModel;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.ClickableToastView;
import com.tencent.mobileqq.widget.ClickableToastView.RightActionParams;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/ugc/selecttopic/SelectTopicFragment;", "Landroid/support/v4/app/Fragment;", "()V", "finish", "", "handleVideoAddToTopicResult", "errorCode", "", "activity", "Landroid/support/v4/app/FragmentActivity;", "topicId", "rowKey", "", "errorMsg", "needShowServerErrorMsg", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class SelectTopicFragment
  extends ReportV4Fragment
{
  public static final SelectTopicFragment.Companion a;
  private HashMap a;
  
  static
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelecttopicSelectTopicFragment$Companion = new SelectTopicFragment.Companion(null);
  }
  
  private final void a(int paramInt1, FragmentActivity paramFragmentActivity, int paramInt2, String paramString1, String paramString2)
  {
    int j = 1;
    CharSequence localCharSequence;
    if (paramInt1 == 0)
    {
      paramString2 = BaseActivity.sTopActivity;
      if ((paramString2 != null) && (!paramString2.isFinishing()))
      {
        paramString2 = (Activity)paramString2;
        localCharSequence = (CharSequence)paramFragmentActivity.getResources().getString(2131718432);
        ClickableToastView.RightActionParams localRightActionParams = new ClickableToastView.RightActionParams();
        localRightActionParams.jdField_a_of_type_JavaLangString = paramFragmentActivity.getResources().getString(2131718433);
        localRightActionParams.jdField_a_of_type_AndroidViewView$OnClickListener = ((View.OnClickListener)new SelectTopicFragment.handleVideoAddToTopicResult..inlined.apply.lambda.1(paramFragmentActivity, paramInt2));
        ClickableToastView.a(paramString2, 2, localCharSequence, localRightActionParams).a();
      }
      paramFragmentActivity = RIJQQAppInterfaceUtil.a();
      if (paramFragmentActivity != null)
      {
        paramFragmentActivity = new RIJTransMergeKanDianReport.ReportR5Builder().a("uin", paramFragmentActivity.getCurrentAccountUin()).a("column_id", Integer.valueOf(paramInt2)).a("rowkey", paramString1);
        if (RIJUgcUtils.h()) {}
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          paramFragmentActivity = paramFragmentActivity.a("ugc_column_flag", Integer.valueOf(paramInt1)).a();
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountSimpleReportWithR5("0X800ADD1", paramFragmentActivity);
          return;
        }
      }
      QLog.e("SelectTopicFragment", 1, "getQQApp, app == null");
      return;
    }
    int i;
    if (a(paramInt1))
    {
      localCharSequence = (CharSequence)paramString2;
      if ((localCharSequence == null) || (localCharSequence.length() == 0))
      {
        i = 1;
        if (i != 0) {
          break label344;
        }
        label231:
        QQToast.a((Context)paramFragmentActivity, (CharSequence)paramString2, 0).a();
        paramFragmentActivity = RIJQQAppInterfaceUtil.a();
        if (paramFragmentActivity == null) {
          break label363;
        }
        paramFragmentActivity = new RIJTransMergeKanDianReport.ReportR5Builder().a("uin", paramFragmentActivity.getCurrentAccountUin()).a("column_id", Integer.valueOf(paramInt2)).a("rowkey", paramString1);
        if (!RIJUgcUtils.h()) {
          break label358;
        }
      }
    }
    label344:
    label358:
    for (paramInt2 = j;; paramInt2 = 0)
    {
      paramFragmentActivity = paramFragmentActivity.a("ugc_column_flag", Integer.valueOf(paramInt2)).a("reason_flag", Integer.valueOf(paramInt1)).a();
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountSimpleReportWithR5("0X800ADD2", paramFragmentActivity);
      return;
      i = 0;
      break;
      paramString2 = paramFragmentActivity.getResources().getString(2131718431);
      break label231;
    }
    label363:
    QLog.e("SelectTopicFragment", 1, "getQQApp, app == null");
  }
  
  private final boolean a(int paramInt)
  {
    return (paramInt == 100010) || (paramInt == 110010);
  }
  
  private final void b()
  {
    Object localObject = getActivity();
    if (localObject != null)
    {
      ((FragmentActivity)localObject).getSupportFragmentManager().beginTransaction().remove((Fragment)this).commit();
      localObject = ((FragmentActivity)localObject).getWindow();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "window");
      localObject = ((Window)localObject).getDecorView().findViewById(16908290);
      if (localObject == null) {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
      }
      localObject = (ViewGroup)localObject;
      View localView = ((ViewGroup)localObject).findViewById(2131376573);
      if (localView != null) {
        ((ViewGroup)localObject).removeView(localView);
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    int j = 0;
    super.onCreate(paramBundle);
    paramBundle = getArguments();
    Object localObject;
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getString("key_rowKey");
      if (paramBundle != null)
      {
        localObject = getArguments();
        if (localObject == null) {
          break label187;
        }
      }
    }
    label187:
    for (int i = ((Bundle)localObject).getInt("key_from");; i = 0)
    {
      if (((CharSequence)paramBundle).length() > 0) {
        j = 1;
      }
      if (j == 0) {
        break label192;
      }
      localObject = getActivity();
      if (localObject != null)
      {
        SelectTopicView localSelectTopicView = new SelectTopicView((FragmentActivity)localObject, new ListPresenter((ListContract.IListModel)new MyColumnModel()));
        SlidingUpDialog localSlidingUpDialog = new SlidingUpDialog((Activity)localObject, (View)localSelectTopicView, new RelativeLayout.LayoutParams(-1, -2));
        localSelectTopicView.setSelectCallback((Function1)new SelectTopicFragment.onCreate..inlined.let.lambda.1(localSlidingUpDialog, (FragmentActivity)localObject, this, i, paramBundle));
        localSlidingUpDialog.setOnDismissListener((DialogInterface.OnDismissListener)new SelectTopicFragment.onCreate..inlined.let.lambda.2(this, i, paramBundle));
        localSlidingUpDialog.show();
      }
      return;
      paramBundle = "";
      break;
    }
    label192:
    QLog.e("SelectTopicFragment", 1, "start select topic failed, rowkey isEmpty");
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.selecttopic.SelectTopicFragment
 * JD-Core Version:    0.7.0.1
 */