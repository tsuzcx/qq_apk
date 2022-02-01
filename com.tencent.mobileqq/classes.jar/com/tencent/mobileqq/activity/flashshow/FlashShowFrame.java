package com.tencent.mobileqq.activity.flashshow;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.auto.engine.lib.ASEnterBean;
import com.tencent.mobileqq.auto.engine.main.ASFrameFactory;
import com.tencent.mobileqq.auto.engine.main.IASBaseFrame;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.Serializable;
import java.util.HashMap;

public class FlashShowFrame
  extends Frame
{
  private static String a = "FlashShowFrame";
  private IASBaseFrame b;
  private View c;
  private Fragment d;
  private ImmersiveTitleBar2 e;
  private int f;
  
  private void l()
  {
    try
    {
      if (this.b != null)
      {
        this.b.f();
        P().getSupportFragmentManager().beginTransaction().remove(this.d).commitAllowingStateLoss();
        this.d = null;
        return;
      }
    }
    catch (Exception localException)
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onAccountChanged exception:");
      localStringBuilder.append(localException.getMessage());
      QLog.d(str, 1, localStringBuilder.toString());
    }
  }
  
  private void m()
  {
    if (P() != null)
    {
      if (ImmersiveUtils.isSupporImmersive() != 0) {
        ImmersiveUtils.setStatusTextColor(false, P().getWindow());
      }
      ImmersiveTitleBar2 localImmersiveTitleBar2 = this.e;
      if (localImmersiveTitleBar2 != null) {
        localImmersiveTitleBar2.setBackgroundColor(this.f);
      }
    }
  }
  
  private void n()
  {
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("KEY_AS_ENTER_BEAN", o());
    this.d.setArguments(localBundle);
  }
  
  private Serializable o()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("fs_key_bundle_individual_folder_page", "false");
    return new ASEnterBean("flash-show-app").setSchemeAction("openfolder").setAttrs(localHashMap);
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    View localView = this.c;
    if (localView != null) {
      return localView;
    }
    this.b = ASFrameFactory.a("flash-show-app");
    this.c = ((FrameLayout)paramLayoutInflater.inflate(2131624862, null));
    paramLayoutInflater = this.b;
    if (paramLayoutInflater == null)
    {
      QLog.d(a, 1, "onCreateView controller is empty");
      return this.c;
    }
    this.d = paramLayoutInflater.a(this.c);
    if (this.d == null)
    {
      QLog.d(a, 1, "onCreateView fragment is empty");
      return this.c;
    }
    n();
    P().getSupportFragmentManager().beginTransaction().add(2131433378, this.d).commitAllowingStateLoss();
    QLog.d(a, 1, "onCreateView new fragment");
    return this.c;
  }
  
  protected void a()
  {
    super.a();
    this.f = Q().getColor(2131167023);
    this.e = ((ImmersiveTitleBar2)d(2131447582));
    IphoneTitleBarActivity.setLayerType(this.e);
    if (P() != null) {
      m();
    }
  }
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    Fragment localFragment = this.d;
    if (localFragment != null) {
      localFragment.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean) {
      l();
    }
    IASBaseFrame localIASBaseFrame = this.b;
    if (localIASBaseFrame != null) {
      localIASBaseFrame.a(paramBoolean);
    }
  }
  
  protected void d()
  {
    super.d();
    IASBaseFrame localIASBaseFrame = this.b;
    if (localIASBaseFrame != null) {
      localIASBaseFrame.c();
    }
  }
  
  public boolean h()
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      boolean bool = ((IASBaseFrame)localObject).d();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onBackPressed flashShowFrame:");
      ((StringBuilder)localObject).append(bool);
      QLog.d("ASDynamicEngine_back", 1, ((StringBuilder)localObject).toString());
      return bool;
    }
    return super.h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.flashshow.FlashShowFrame
 * JD-Core Version:    0.7.0.1
 */