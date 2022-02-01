package com.tencent.mobileqq.auto.engine.main.fragment;

import android.app.LocalActivityManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.auto.engine.enter.ASEngineEnter;
import com.tencent.mobileqq.auto.engine.lib.ASEnterBean;
import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.List;

public class ASPluginFragment
  extends BasePartFragment
{
  private View a;
  private FrameLayout b;
  private LocalActivityManager c;
  private View d;
  private ASEnterBean e;
  
  private void a()
  {
    if (this.d != null)
    {
      QLog.d("ASPluginFragment", 1, "getPluginIntent : mFSTabView not null ");
      return;
    }
    if (this.e == null)
    {
      QLog.d("ASPluginFragment", 1, "start LocalActivityManager failed no init data ");
      return;
    }
    HostUIHelper.getInstance().setPluginIntentHook(new ASPluginFragment.1(this));
    ASEngineEnter.a(this.e);
  }
  
  private void a(int paramInt)
  {
    if (this.d == null) {
      return;
    }
    if (paramInt != 1) {
      if (paramInt != 2) {
        if (paramInt != 3) {
          if (paramInt != 4) {
            return;
          }
        }
      }
    }
    try
    {
      e().dispatchDestroy(false);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    e().dispatchStop();
    return;
    e().dispatchPause(false);
    return;
    e().dispatchResume();
    return;
  }
  
  private LocalActivityManager e()
  {
    if (this.c == null)
    {
      this.c = new LocalActivityManager(getActivity(), true);
      this.c.dispatchCreate(null);
    }
    return this.c;
  }
  
  public String b()
  {
    return null;
  }
  
  protected int c()
  {
    return 0;
  }
  
  protected List<Part> d()
  {
    return null;
  }
  
  protected int j()
  {
    return 0;
  }
  
  public boolean onBackEvent()
  {
    boolean bool = super.onBackEvent();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("asPluginFragment onBackEvent:");
    localStringBuilder.append(bool);
    QLog.d("ASDynamicEngine_back", 1, localStringBuilder.toString());
    return bool;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getArguments();
    if (paramBundle == null)
    {
      QLog.d("ASPluginFragment", 1, "init bundle is empty");
      return;
    }
    if (paramBundle.containsKey("KEY_AS_ENTER_BEAN"))
    {
      this.e = ((ASEnterBean)paramBundle.getSerializable("KEY_AS_ENTER_BEAN"));
      QLog.d("ASPluginFragment", 1, "plugin fragment has enterBean");
      return;
    }
    QLog.d("ASPluginFragment", 1, "plugin fragment params error ");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.a = paramLayoutInflater.inflate(2131624267, paramViewGroup, false);
    this.b = ((FrameLayout)this.a.findViewById(2131428943));
    paramLayoutInflater = this.a;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    a(4);
  }
  
  public void onPause()
  {
    super.onPause();
    a(2);
  }
  
  public void onResume()
  {
    super.onResume();
    this.a.post(new ASPluginFragment.2(this));
  }
  
  public void onStop()
  {
    super.onStop();
    a(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.auto.engine.main.fragment.ASPluginFragment
 * JD-Core Version:    0.7.0.1
 */