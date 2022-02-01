package com.tencent.gdtad.jsbridge;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.gdtad.hippy.GdtHippyEngine;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import org.json.JSONObject;

public class GdtQQHippyDemoFragment
  extends PublicBaseFragment
{
  private ViewGroup a;
  public HippyQQEngine a;
  
  private void a()
  {
    GdtLog.b("GdtQQHippyDemoFragment", "initHippy");
    JSONObject localJSONObject = new JSONObject();
    this.jdField_a_of_type_ComTencentHippyQqAppHippyQQEngine.initHippy(this.jdField_a_of_type_AndroidViewViewGroup, localJSONObject, false, new GdtQQHippyDemoFragment.1(this));
  }
  
  public static void a(Activity paramActivity)
  {
    GdtLog.b("GdtQQHippyDemoFragment", "start");
    Intent localIntent = new Intent();
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
    PublicFragmentActivity.Launcher.a(paramActivity, localIntent, PublicFragmentActivity.class, GdtQQHippyDemoFragment.class);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    GdtLog.b("GdtQQHippyDemoFragment", "onCreateView");
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramLayoutInflater.inflate(2131559253, paramViewGroup, false));
    if (this.jdField_a_of_type_ComTencentHippyQqAppHippyQQEngine == null)
    {
      this.jdField_a_of_type_ComTencentHippyQqAppHippyQQEngine = new GdtHippyEngine(this, "tangramHippyPage", null);
      this.jdField_a_of_type_ComTencentHippyQqAppHippyQQEngine.setJsBundleType("react");
    }
    a();
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewViewGroup;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    GdtLog.b("GdtQQHippyDemoFragment", "onDestroy");
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentHippyQqAppHippyQQEngine != null)
    {
      this.jdField_a_of_type_ComTencentHippyQqAppHippyQQEngine.onDestroy();
      this.jdField_a_of_type_ComTencentHippyQqAppHippyQQEngine = null;
    }
  }
  
  public void onPause()
  {
    GdtLog.b("GdtQQHippyDemoFragment", "onPause");
    super.onPause();
    if (this.jdField_a_of_type_ComTencentHippyQqAppHippyQQEngine != null) {
      this.jdField_a_of_type_ComTencentHippyQqAppHippyQQEngine.onPause();
    }
  }
  
  public void onResume()
  {
    GdtLog.b("GdtQQHippyDemoFragment", "onResume");
    super.onResume();
    if (this.jdField_a_of_type_ComTencentHippyQqAppHippyQQEngine != null) {
      this.jdField_a_of_type_ComTencentHippyQqAppHippyQQEngine.onResume();
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    GdtLog.b("GdtQQHippyDemoFragment", "onViewCreated");
    super.onViewCreated(paramView, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtQQHippyDemoFragment
 * JD-Core Version:    0.7.0.1
 */