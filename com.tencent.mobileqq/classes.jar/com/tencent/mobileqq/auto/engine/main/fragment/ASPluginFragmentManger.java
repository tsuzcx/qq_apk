package com.tencent.mobileqq.auto.engine.main.fragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.auto.engine.event.ASEngineTabBackEvent;
import com.tencent.mobileqq.auto.engine.event.ASEngineTabStatusEvent;
import com.tencent.mobileqq.auto.engine.main.IASBaseFrame;
import com.tencent.mobileqq.flashshow.api.events.FSAccountChangeEvent;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class ASPluginFragmentManger
  extends IASBaseFrame
{
  private static final HashMap<String, ASPluginFragmentManger> c = new HashMap();
  private ASPluginFragment d;
  private String e;
  
  private ASPluginFragmentManger(String paramString)
  {
    this.e = paramString;
  }
  
  public static ASPluginFragmentManger a(@NonNull String paramString)
  {
    try
    {
      ASPluginFragmentManger localASPluginFragmentManger2 = (ASPluginFragmentManger)c.get(paramString);
      ASPluginFragmentManger localASPluginFragmentManger1 = localASPluginFragmentManger2;
      if (localASPluginFragmentManger2 == null)
      {
        localASPluginFragmentManger1 = new ASPluginFragmentManger(paramString);
        c.put(paramString, localASPluginFragmentManger1);
      }
      return localASPluginFragmentManger1;
    }
    finally {}
  }
  
  public void a()
  {
    if (this.d == null) {
      return;
    }
    SimpleEventBus.getInstance().dispatchEvent(new ASEngineTabStatusEvent(this.e, true));
  }
  
  public void a(boolean paramBoolean)
  {
    SimpleEventBus.getInstance().dispatchEvent(new FSAccountChangeEvent(paramBoolean));
  }
  
  public void b()
  {
    if (this.d == null) {
      return;
    }
    SimpleEventBus.getInstance().dispatchEvent(new ASEngineTabStatusEvent(this.e, false));
  }
  
  public void c()
  {
    if (this.d == null) {
      return;
    }
    g().onDestroy();
    this.d = null;
  }
  
  public boolean d()
  {
    if (this.d == null) {
      return false;
    }
    SimpleEventBus.getInstance().dispatchEvent(new ASEngineTabBackEvent(this.e));
    QLog.d("ASDynamicEngine_back", 1, "pluginFragmentManger onBackEvent  true all ways");
    return true;
  }
  
  public void f()
  {
    if (this.d == null) {
      return;
    }
    QLog.i("ASPluginFragmentManger", 1, "fs_lifecycle onBottomPageUnSelected-> to destroy");
    this.d = null;
  }
  
  public Fragment g()
  {
    if (this.d == null)
    {
      this.d = new ASPluginFragment();
      QLog.i("ASPluginFragmentManger", 1, "getMainFragment  init fragment");
    }
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.auto.engine.main.fragment.ASPluginFragmentManger
 * JD-Core Version:    0.7.0.1
 */