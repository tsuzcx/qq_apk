package com.tencent.biz.pubaccount.readinjoy.pts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.pts.bridge.PTSJSBridgeManager;
import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.core.PTSAppInstance.Builder;
import com.tencent.pts.core.PTSThreadUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import orn;
import orp;
import plm;
import pqu;
import pti;
import qya;
import qyb;
import qyc;
import qyd;
import rag;
import rah;

public class PTSFragment
  extends PublicBaseFragment
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private PTSAppInstance jdField_a_of_type_ComTencentPtsCorePTSAppInstance;
  private String jdField_a_of_type_JavaLangString;
  orp jdField_a_of_type_Orp = new qyc(this);
  private String b;
  private String c;
  private String d;
  private String e;
  
  private void a()
  {
    Intent localIntent = this.jdField_a_of_type_AndroidAppActivity.getIntent();
    if (localIntent != null)
    {
      this.jdField_a_of_type_JavaLangString = localIntent.getStringExtra("com.tencent.biz.pubaccount.readinjoy.pts.PageName");
      this.b = localIntent.getStringExtra("com.tencent.biz.pubaccount.readinjoy.pts.FrameTreeJson");
      this.c = localIntent.getStringExtra("com.tencent.biz.pubaccount.readinjoy.pts.PageJs");
      this.d = localIntent.getStringExtra("com.tencent.biz.pubaccount.readinjoy.pts.BindDataJs");
      this.e = localIntent.getStringExtra("com.tencent.biz.pubaccount.readinjoy.pts.AnimationJs");
    }
    QLog.i("PTSFragment", 1, "[initArguments], pageName = " + this.jdField_a_of_type_JavaLangString);
  }
  
  private void a(View paramView)
  {
    orn.a().a(9999, this.jdField_a_of_type_Orp);
    this.jdField_a_of_type_ComTencentPtsCorePTSAppInstance.addOnRecyclerViewScrollListener(new qyd(this));
  }
  
  private void a(ViewGroup paramViewGroup)
  {
    if (paramViewGroup == null) {}
    while (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, "daily_feeds")) {
      return;
    }
    paramViewGroup = View.inflate(this.jdField_a_of_type_AndroidAppActivity, 2131560207, paramViewGroup);
    View localView1 = paramViewGroup.findViewById(2131370603);
    View localView2 = paramViewGroup.findViewById(2131370611);
    ((TextView)paramViewGroup.findViewById(2131380223)).setVisibility(8);
    localView1.setOnClickListener(new qya(this));
    localView2.setOnClickListener(new qyb(this));
  }
  
  private void b()
  {
    rag.a("0X800A7C7", "", "", "", new rah().a("page_name", this.jdField_a_of_type_JavaLangString).a());
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidAppActivity = getActivity();
    a();
    paramViewGroup = paramLayoutInflater.inflate(2131560301, paramViewGroup, false);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      paramViewGroup.setFitsSystemWindows(true);
      paramViewGroup.setPadding(0, ImmersiveUtils.getStatusBarHeight(paramLayoutInflater.getContext()), 0, 0);
    }
    paramLayoutInflater = (ViewGroup)paramViewGroup.findViewById(2131365174);
    a((ViewGroup)paramViewGroup.findViewById(2131379024));
    paramBundle = PTSJSBridgeManager.getInstance().getJSBridge(this.jdField_a_of_type_AndroidAppActivity, this.d, this.e);
    this.jdField_a_of_type_ComTencentPtsCorePTSAppInstance = new PTSAppInstance.Builder().withContext(this.jdField_a_of_type_AndroidAppActivity).withRootView(paramLayoutInflater).withRootNodeType(0).withPTSJSBridge(paramBundle).withPageName(this.jdField_a_of_type_JavaLangString).withFrameTreeJson(this.b).withPageJs(this.c).build();
    this.jdField_a_of_type_ComTencentPtsCorePTSAppInstance.onCreate();
    a(paramViewGroup);
    b();
    VideoReport.addToDetectionWhitelist(getActivity());
    VideoReport.setPageId(paramViewGroup, "14");
    VideoReport.setPageParams(paramViewGroup, new pti().a(Integer.valueOf(plm.b())).a());
    V4FragmentCollector.onV4FragmentViewCreated(this, paramViewGroup);
    return paramViewGroup;
  }
  
  public void onDestroy()
  {
    QLog.i("PTSFragment", 1, "[onDestroy]");
    super.onDestroy();
    PTSThreadUtil.runOnSubThread(new PTSFragment.1(this, this.jdField_a_of_type_AndroidAppActivity));
    orn.a().b(9999, this.jdField_a_of_type_Orp);
  }
  
  public void onFinish()
  {
    QLog.i("PTSFragment", 2, "[onFinish]");
    super.onFinish();
    PTSThreadUtil.runOnSubThread(new PTSFragment.2(this));
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_ComTencentPtsCorePTSAppInstance.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    pqu.a(this.jdField_a_of_type_AndroidAppActivity, true, pqu.a(this.jdField_a_of_type_AndroidAppActivity));
    this.jdField_a_of_type_ComTencentPtsCorePTSAppInstance.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.PTSFragment
 * JD-Core Version:    0.7.0.1
 */