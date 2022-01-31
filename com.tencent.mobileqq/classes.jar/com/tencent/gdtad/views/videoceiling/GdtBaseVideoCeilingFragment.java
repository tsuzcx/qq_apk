package com.tencent.gdtad.views.videoceiling;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.fragment.PublicBaseFragment;

public abstract class GdtBaseVideoCeilingFragment
  extends PublicBaseFragment
{
  private GdtVideoCeilingView a;
  
  public static void a(Activity paramActivity, Class paramClass, GdtVideoCeilingData paramGdtVideoCeilingData)
  {
    a(paramActivity, paramClass, paramGdtVideoCeilingData, new Bundle());
  }
  
  public static void a(Activity paramActivity, Class paramClass, GdtVideoCeilingData paramGdtVideoCeilingData, Bundle paramBundle)
  {
    if ((paramActivity == null) || (paramGdtVideoCeilingData == null) || (!paramGdtVideoCeilingData.isValid()) || (paramBundle == null))
    {
      GdtLog.d("GdtBaseVideoCeilingFragment", "start error");
      return;
    }
    GdtLog.b("GdtBaseVideoCeilingFragment", "start");
    paramBundle.putSerializable("data", paramGdtVideoCeilingData);
    paramGdtVideoCeilingData = new Intent();
    paramGdtVideoCeilingData.putExtra("public_fragment_window_feature", 1);
    paramGdtVideoCeilingData.putExtras(paramBundle);
    PublicFragmentActivity.Launcher.a(paramActivity, paramGdtVideoCeilingData, PublicFragmentActivityForTool.class, paramClass);
  }
  
  public void a(Activity paramActivity)
  {
    super.a(paramActivity);
    if (paramActivity == null) {
      return;
    }
    paramActivity.setRequestedOrientation(1);
    paramActivity.getWindow().addFlags(1024);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean c()
  {
    return false;
  }
  
  public boolean d()
  {
    return (this.a != null) && (this.a.a());
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130969007, paramViewGroup, false);
    this.a = ((GdtVideoCeilingView)paramLayoutInflater.findViewById(2131364661));
    this.a.a(paramBundle);
    if ((getArguments() != null) && ((getArguments().getSerializable("data") instanceof GdtVideoCeilingData))) {
      this.a.setData((GdtVideoCeilingData)getArguments().getSerializable("data"));
    }
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    if (this.a != null) {
      this.a.a();
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    if (this.a != null) {
      this.a.c();
    }
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.a != null) {
      this.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.tencent.gdtad.views.videoceiling.GdtBaseVideoCeilingFragment
 * JD-Core Version:    0.7.0.1
 */