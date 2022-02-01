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
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
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
    ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131380915);
    this.jdField_a_of_type_ComTencentHippyQqAppHippyQQEngine.initHippyInContainer(localViewGroup, localJSONObject, false, new GdtQQHippyDemoFragment.1(this));
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
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramLayoutInflater.inflate(2131559129, paramViewGroup, false));
    if (this.jdField_a_of_type_ComTencentHippyQqAppHippyQQEngine == null)
    {
      this.jdField_a_of_type_ComTencentHippyQqAppHippyQQEngine = new GdtHippyEngine(this, "tangramHippyPage", null);
      this.jdField_a_of_type_ComTencentHippyQqAppHippyQQEngine.setJsBundleType("react");
    }
    a();
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewViewGroup;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    GdtLog.b("GdtQQHippyDemoFragment", "onDestroy");
    super.onDestroy();
    HippyQQEngine localHippyQQEngine = this.jdField_a_of_type_ComTencentHippyQqAppHippyQQEngine;
    if (localHippyQQEngine != null)
    {
      localHippyQQEngine.onDestroy();
      this.jdField_a_of_type_ComTencentHippyQqAppHippyQQEngine = null;
    }
  }
  
  public void onPause()
  {
    GdtLog.b("GdtQQHippyDemoFragment", "onPause");
    super.onPause();
    HippyQQEngine localHippyQQEngine = this.jdField_a_of_type_ComTencentHippyQqAppHippyQQEngine;
    if (localHippyQQEngine != null) {
      localHippyQQEngine.onPause();
    }
  }
  
  public void onResume()
  {
    GdtLog.b("GdtQQHippyDemoFragment", "onResume");
    super.onResume();
    HippyQQEngine localHippyQQEngine = this.jdField_a_of_type_ComTencentHippyQqAppHippyQQEngine;
    if (localHippyQQEngine != null) {
      localHippyQQEngine.onResume();
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    GdtLog.b("GdtQQHippyDemoFragment", "onViewCreated");
    super.onViewCreated(paramView, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtQQHippyDemoFragment
 * JD-Core Version:    0.7.0.1
 */