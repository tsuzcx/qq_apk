package com.tencent.biz.pubaccount.readinjoy.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadinjoyJumpUtils;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.DailyModeConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.MultiVideoConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJKanDianTabReport;
import com.tencent.biz.pubaccount.readinjoy.dt.RIJDtReportHelper;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.model.FastWebModule.FastWebContentGetCallback;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.multivideo.MultiVideoHelper;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.webarticle.RIJWebArticleUtil;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.mobileqq.widget.WebViewProgressBarController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadinjoyJumpActivity
  extends IphoneTitleBarFragment
  implements FastWebModule.FastWebContentGetCallback
{
  private static Runnable jdField_b_of_type_JavaLangRunnable;
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = -1L;
  private ReadInJoyObserver jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver = new ReadinjoyJumpActivity.2(this);
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = null;
  private WebViewProgressBar jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar;
  private WebViewProgressBarController jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ReadinjoyJumpActivity.1(this);
  private boolean jdField_a_of_type_Boolean = false;
  private boolean jdField_b_of_type_Boolean = false;
  private boolean c = false;
  
  public static void a(Context paramContext, Intent paramIntent, long paramLong)
  {
    if (jdField_b_of_type_JavaLangRunnable != null) {
      ThreadManager.getSubThreadHandler().removeCallbacks(jdField_b_of_type_JavaLangRunnable);
    }
    long l = paramIntent.getLongExtra("jump_article_param_ids", -1L);
    paramIntent.removeExtra("jump_article_param_ids");
    jdField_b_of_type_JavaLangRunnable = new ReadinjoyJumpActivity.4(l, paramIntent, paramContext);
    if (l != -1L) {
      ThreadManager.getSubThreadHandler().postDelayed(jdField_b_of_type_JavaLangRunnable, paramLong);
    }
    QLog.d("ReadinjoyJumpActivity", 1, "jump activity, ids : " + l + ", delay : " + paramLong);
  }
  
  public static boolean a(Intent paramIntent)
  {
    return paramIntent.hasExtra("jump_article_param_ids");
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar = ((WebViewProgressBar)this.mContentView.findViewById(2131373555));
    this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController = new WebViewProgressBarController();
    this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController.a(this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar);
    this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar.setController(this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController);
    this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController.a((byte)0);
  }
  
  public static boolean b(Intent paramIntent)
  {
    return paramIntent.hasExtra("daily_lock_screen_flag");
  }
  
  private void c()
  {
    boolean bool1;
    try
    {
      FragmentActivity localFragmentActivity = getActivity();
      if (localFragmentActivity != null)
      {
        bool1 = this.c;
        if (!bool1) {
          break label25;
        }
      }
      for (;;)
      {
        return;
        label25:
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
          break;
        }
        localFragmentActivity.finish();
      }
      this.jdField_b_of_type_Boolean = true;
    }
    finally {}
    this.c = true;
    int i = ReadinjoyJumpUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    switch (i)
    {
    }
    for (;;)
    {
      for (;;)
      {
        ReadInJoyLogicEngine.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID, System.currentTimeMillis());
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.invalidateProteusTemplateBean();
        Object localObject = new JSONObject();
        try
        {
          ((JSONObject)localObject).put("algorithm_id", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mAlgorithmID);
          ((JSONObject)localObject).put("rowkey", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
          RIJKanDianTabReport.a(false, (JSONObject)localObject);
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X80094C3", "0X80094C3", 0, 0, "" + this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID + "", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId + "", ((JSONObject)localObject).toString(), false);
          QLog.d("ReadinjoyJumpActivity", 1, new Object[] { "do dump action, type : ", Integer.valueOf(i), ", needFinfishActivity : " + this.jdField_b_of_type_Boolean });
          if (!this.jdField_b_of_type_Boolean) {
            break;
          }
          localContext.finish();
          break;
          localObject = ReadinjoyJumpUtils.b(localContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
          ((Intent)localObject).putExtra("from_native", true);
          if (!((Intent)localObject).getBooleanExtra("is_native_fast_web", false)) {
            this.jdField_b_of_type_Boolean = false;
          }
          localContext.startActivity((Intent)localObject);
          if (RIJWebArticleUtil.a.d())
          {
            localContext.overridePendingTransition(2130771984, 0);
          }
          else
          {
            localContext.overridePendingTransition(0, 0);
            continue;
            Intent localIntent = ReadinjoyJumpUtils.a(localContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
            localIntent.putExtra("VIDEO_FROM_TYPE", 27);
            localObject = localIntent.getExtras();
            bool1 = false;
            try
            {
              boolean bool2 = MultiVideoConfigHandler.a(((Bundle)localObject).getInt("VIDEO_FROM_TYPE", -1), Integer.valueOf(((Bundle)localObject).getString("VIDEO_WIDTH")).intValue(), Integer.valueOf(((Bundle)localObject).getString("VIDEO_HEIGHT")).intValue(), Integer.valueOf(((Bundle)localObject).getString("VIDEO_TIME")).intValue());
              bool1 = bool2;
            }
            catch (Exception localException)
            {
              label487:
              break label487;
            }
            if (bool1)
            {
              localIntent = new Intent();
              localIntent.putExtras((Bundle)localObject);
              MultiVideoHelper.a(localContext, localIntent);
            }
            else
            {
              localContext.startActivity(localIntent);
            }
          }
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
          }
        }
      }
    }
  }
  
  public static boolean c(Intent paramIntent)
  {
    return paramIntent.hasExtra("kan_dian_lock_screen_flag");
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    a();
    if (this.leftView != null)
    {
      this.leftView.setTextColor(-14408926);
      this.leftView.setText(HardCodeUtil.a(2131712959));
      this.leftView.setBackgroundResource(2130849916);
    }
    if (getTitleBarView() != null)
    {
      getTitleBarView().setBackgroundResource(0);
      if (!ThemeUtil.isInNightMode(ReadInJoyUtils.a())) {
        break label95;
      }
      getTitleBarView().setBackgroundColor(Color.parseColor("#888888"));
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = true;
      return;
      label95:
      getTitleBarView().setBackgroundColor(-1);
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController.a((byte)2);
    if (this.mContentView != null) {
      this.mContentView.findViewById(2131366420).setVisibility(0);
    }
    QLog.d("ReadinjoyJumpActivity", 1, "show error page!");
  }
  
  public void a()
  {
    FragmentActivity localFragmentActivity = getActivity();
    SystemBarCompact localSystemBarCompact;
    if ((localFragmentActivity != null) && ((localFragmentActivity instanceof PublicFragmentActivity)))
    {
      localSystemBarCompact = ((PublicFragmentActivity)localFragmentActivity).mSystemBarComp;
      if ((localSystemBarCompact != null) && (needImmersive()) && (needStatusTrans()) && (ImmersiveUtils.isSupporImmersive() == 1))
      {
        if (!ThemeUtil.isInNightMode(((PublicFragmentActivity)localFragmentActivity).getAppRuntime())) {
          break label95;
        }
        if ((SystemUtil.b()) || (SystemUtil.d())) {
          break label82;
        }
        localSystemBarCompact.setStatusBarColor(-7829368);
      }
    }
    return;
    label82:
    localSystemBarCompact.setStatusBarColor(-7829368);
    localSystemBarCompact.setStatusBarDarkMode(true);
    return;
    label95:
    if ((Build.VERSION.SDK_INT >= 23) && (!SystemUtil.b()) && (!SystemUtil.d()))
    {
      ((PublicFragmentActivity)localFragmentActivity).getWindow().getDecorView().setSystemUiVisibility(9216);
      localSystemBarCompact.setStatusBarColor(-1);
      return;
    }
    if (!SystemUtil.d())
    {
      localSystemBarCompact.setStatusBarColor(-2368549);
      return;
    }
    localSystemBarCompact.setStatusBarColor(-1);
    localSystemBarCompact.setStatusBarDarkMode(true);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, FastWebArticleInfo paramFastWebArticleInfo)
  {
    QLog.d("ReadinjoyJumpActivity", 2, "get fastWeb info resp, isSucc : " + paramBoolean1 + ", useWeb : " + paramBoolean2 + ", data : " + paramFastWebArticleInfo + ", needFinfish : " + this.jdField_b_of_type_Boolean);
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    if ((paramBoolean1) && (getActivity() != null))
    {
      c();
      return;
    }
    e();
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    int i = 0;
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    getActivity().getWindow().setFlags(16777216, 16777216);
    b();
    this.jdField_a_of_type_Long = getActivity().getIntent().getLongExtra("jump_article_param_ids", -1L);
    this.jdField_a_of_type_Int = getActivity().getIntent().getIntExtra("jump_activity_launch_from", 0);
    if (this.jdField_a_of_type_Long == -1L)
    {
      getActivity().finish();
      return;
    }
    paramLayoutInflater = new JSONObject();
    RIJKanDianTabReport.a(false, paramLayoutInflater);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X80094C1", "0X80094C1", 0, 0, "" + this.jdField_a_of_type_Int, this.jdField_a_of_type_Long + "", "", paramLayoutInflater.toString(), false);
    QLog.d("ReadinjoyJumpActivity", 1, "param_article_id : " + this.jdField_a_of_type_Long);
    if (getActivity().getIntent().getBooleanExtra("daily_lock_screen_param", false)) {
      i = DailyModeConfigHandler.b();
    }
    int j = i;
    if (this.jdField_a_of_type_Int == 0) {
      j = getActivity().getIntent().getIntExtra("arg_channel_cover_id", i);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = ReadInJoyLogicEngine.a().b(j, this.jdField_a_of_type_Long);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null)
    {
      ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 60000L);
      ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
    }
    RIJDtReportHelper.a.a(getActivity());
  }
  
  public int getContentLayoutId()
  {
    return 2131560335;
  }
  
  public boolean onBackEvent()
  {
    String str = this.jdField_a_of_type_Long + "";
    JSONObject localJSONObject = new JSONObject();
    RIJKanDianTabReport.a(false, localJSONObject);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X80094C2", "0X80094C2", 0, 0, this.jdField_a_of_type_Int + "", str, "", localJSONObject.toString(), false);
    this.jdField_b_of_type_Boolean = true;
    return super.onBackEvent();
  }
  
  public void onDestroy()
  {
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
    super.onDestroy();
  }
  
  public void onResume()
  {
    super.onResume();
    d();
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.jdField_b_of_type_Boolean)
    {
      ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
      getActivity().finish();
    }
    QLog.d("ReadinjoyJumpActivity", 2, "onStop, needFinfish : " + this.jdField_b_of_type_Boolean);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) && (!this.c)) {
      ThreadManager.getSubThreadHandler().post(new ReadinjoyJumpActivity.3(this));
    }
    if ((!paramBoolean) && (this.c) && (this.jdField_b_of_type_Boolean)) {
      getActivity().finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadinjoyJumpActivity
 * JD-Core Version:    0.7.0.1
 */