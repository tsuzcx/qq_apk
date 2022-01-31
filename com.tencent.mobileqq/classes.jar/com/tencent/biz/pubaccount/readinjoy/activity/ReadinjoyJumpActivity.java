package com.tencent.biz.pubaccount.readinjoy.activity;

import ajjy;
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
import azzu;
import bbpa;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.multivideo.MultiVideoFragment;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import mqq.os.MqqHandler;
import ndn;
import nme;
import obz;
import oci;
import odw;
import ogy;
import ohb;
import ohe;
import opk;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadinjoyJumpActivity
  extends IphoneTitleBarFragment
  implements opk
{
  private static Runnable jdField_b_of_type_JavaLangRunnable;
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = -1L;
  private bbpa jdField_a_of_type_Bbpa;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private WebViewProgressBar jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ReadinjoyJumpActivity.1(this);
  private ohe jdField_a_of_type_Ohe = new nme(this);
  private boolean jdField_a_of_type_Boolean;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  
  public static void a(Context paramContext, Intent paramIntent, long paramLong)
  {
    if (jdField_b_of_type_JavaLangRunnable != null) {
      ThreadManager.getSubThreadHandler().removeCallbacks(jdField_b_of_type_JavaLangRunnable);
    }
    jdField_b_of_type_JavaLangRunnable = new ReadinjoyJumpActivity.4(paramIntent, paramContext);
    ThreadManager.getSubThreadHandler().postDelayed(jdField_b_of_type_JavaLangRunnable, paramLong);
    QLog.d("ReadinjoyJumpActivity", 2, "jump activity, ids : " + paramIntent.getLongExtra("jump_article_param_ids", -1L) + ", delay : " + paramLong);
  }
  
  public static boolean a(Intent paramIntent)
  {
    return paramIntent.hasExtra("jump_article_param_ids");
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar = ((WebViewProgressBar)this.mContentView.findViewById(2131306308));
    this.jdField_a_of_type_Bbpa = new bbpa();
    this.jdField_a_of_type_Bbpa.a(this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar);
    this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar.setController(this.jdField_a_of_type_Bbpa);
    this.jdField_a_of_type_Bbpa.a((byte)0);
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
    int i = oci.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    switch (i)
    {
    }
    for (;;)
    {
      for (;;)
      {
        ogy.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID, System.currentTimeMillis());
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.invalidateProteusTemplateBean();
        Object localObject = new JSONObject();
        try
        {
          ((JSONObject)localObject).put("algorithm_id", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mAlgorithmID);
          ((JSONObject)localObject).put("rowkey", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
          obz.a(false, (JSONObject)localObject);
          ndn.a(null, "", "0X80094C3", "0X80094C3", 0, 0, "" + this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID + "", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId + "", ((JSONObject)localObject).toString(), false);
          QLog.d("ReadinjoyJumpActivity", 1, new Object[] { "do dump action, type : ", Integer.valueOf(i), ", needFinfishActivity : " + this.jdField_b_of_type_Boolean });
          if (!this.jdField_b_of_type_Boolean) {
            break;
          }
          localContext.finish();
          break;
          localObject = oci.b(localContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
          ((Intent)localObject).putExtra("from_native", true);
          if (!((Intent)localObject).getBooleanExtra("is_native_fast_web", false)) {
            this.jdField_b_of_type_Boolean = false;
          }
          localContext.startActivity((Intent)localObject);
          localContext.overridePendingTransition(0, 0);
          continue;
          Intent localIntent = oci.a(localContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
          localIntent.putExtra("VIDEO_FROM_TYPE", 27);
          localObject = localIntent.getExtras();
          bool1 = false;
          try
          {
            boolean bool2 = odw.a(((Bundle)localObject).getInt("VIDEO_FROM_TYPE", -1), Integer.valueOf(((Bundle)localObject).getString("VIDEO_WIDTH")).intValue(), Integer.valueOf(((Bundle)localObject).getString("VIDEO_HEIGHT")).intValue(), Integer.valueOf(((Bundle)localObject).getString("VIDEO_TIME")).intValue());
            bool1 = bool2;
          }
          catch (Exception localException)
          {
            label455:
            break label455;
          }
          if (bool1)
          {
            localIntent = new Intent();
            localIntent.putExtras((Bundle)localObject);
            MultiVideoFragment.a(localContext, localIntent);
          }
          else
          {
            localContext.startActivity(localIntent);
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
  
  private void d()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    a();
    if (this.leftView != null)
    {
      this.leftView.setTextColor(-14408926);
      this.leftView.setText(ajjy.a(2131647206));
      this.leftView.setBackgroundResource(2130848260);
    }
    if (getTitleBarView() != null)
    {
      getTitleBarView().setBackgroundResource(0);
      if (!ThemeUtil.isInNightMode(obz.a())) {
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
    this.jdField_a_of_type_Bbpa.a((byte)2);
    if (this.mContentView != null) {
      this.mContentView.findViewById(2131300141).setVisibility(0);
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
        if ((azzu.b()) || (azzu.d())) {
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
    if ((Build.VERSION.SDK_INT >= 23) && (!azzu.b()) && (!azzu.d()))
    {
      ((PublicFragmentActivity)localFragmentActivity).getWindow().getDecorView().setSystemUiVisibility(9216);
      localSystemBarCompact.setStatusBarColor(-1);
      return;
    }
    if (!azzu.d())
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
    if (this.jdField_a_of_type_Long == -1L) {
      getActivity().finish();
    }
    do
    {
      return;
      paramLayoutInflater = new JSONObject();
      obz.a(false, paramLayoutInflater);
      ndn.a(null, "", "0X80094C1", "0X80094C1", 0, 0, "" + this.jdField_a_of_type_Int, this.jdField_a_of_type_Long + "", "", paramLayoutInflater.toString(), false);
      QLog.d("ReadinjoyJumpActivity", 1, "param_article_id : " + this.jdField_a_of_type_Long);
      if (this.jdField_a_of_type_Int == 0) {
        i = getActivity().getIntent().getIntExtra("arg_channel_cover_id", 0);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = ogy.a().b(i, this.jdField_a_of_type_Long);
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null);
    ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 60000L);
    ohb.a().a(this.jdField_a_of_type_Ohe);
  }
  
  public int getContentLayoutId()
  {
    return 2131494382;
  }
  
  public boolean onBackEvent()
  {
    String str = this.jdField_a_of_type_Long + "";
    JSONObject localJSONObject = new JSONObject();
    obz.a(false, localJSONObject);
    ndn.a(null, "", "0X80094C2", "0X80094C2", 0, 0, this.jdField_a_of_type_Int + "", str, "", localJSONObject.toString(), false);
    this.jdField_b_of_type_Boolean = true;
    return super.onBackEvent();
  }
  
  public void onDestroy()
  {
    ohb.a().b(this.jdField_a_of_type_Ohe);
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
      ohb.a().b(this.jdField_a_of_type_Ohe);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadinjoyJumpActivity
 * JD-Core Version:    0.7.0.1
 */