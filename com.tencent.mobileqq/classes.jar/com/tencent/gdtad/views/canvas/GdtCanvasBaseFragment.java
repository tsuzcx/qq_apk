package com.tencent.gdtad.views.canvas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.canvas.framework.GdtCanvasView;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.fragment.PublicBaseFragment;

public class GdtCanvasBaseFragment
  extends PublicBaseFragment
{
  private GdtCanvasView a;
  
  public static void a(Activity paramActivity, Class paramClass, GdtCanvasData paramGdtCanvasData)
  {
    a(paramActivity, paramClass, paramGdtCanvasData, new Bundle());
  }
  
  public static void a(Activity paramActivity, Class paramClass, GdtCanvasData paramGdtCanvasData, Bundle paramBundle)
  {
    if ((paramActivity == null) || (paramGdtCanvasData == null) || (!paramGdtCanvasData.isValid()) || (paramBundle == null))
    {
      GdtLog.b("GdtCanvasBaseFragment", "start error");
      return;
    }
    GdtLog.b("GdtCanvasBaseFragment", "start");
    paramBundle.putSerializable("data", paramGdtCanvasData);
    paramGdtCanvasData = new Intent();
    paramGdtCanvasData.putExtra("public_fragment_window_feature", 1);
    paramGdtCanvasData.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
    paramGdtCanvasData.putExtras(paramBundle);
    PublicFragmentActivity.a(paramActivity, paramGdtCanvasData, paramClass);
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
    if (this.a != null) {
      return this.a.a();
    }
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if ((getArguments() == null) || (!(getArguments().getSerializable("data") instanceof GdtCanvasData))) {
      return null;
    }
    paramLayoutInflater = (GdtCanvasData)GdtCanvasData.class.cast(getArguments().getSerializable("data"));
    this.a = new GdtCanvasView(getActivity());
    this.a.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.a.setData(paramLayoutInflater);
    return this.a;
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
 * Qualified Name:     com.tencent.gdtad.views.canvas.GdtCanvasBaseFragment
 * JD-Core Version:    0.7.0.1
 */