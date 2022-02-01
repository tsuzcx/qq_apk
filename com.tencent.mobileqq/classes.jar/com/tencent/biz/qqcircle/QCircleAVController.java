package com.tencent.biz.qqcircle;

import android.os.Handler;
import android.os.Looper;
import com.tencent.avbiz.AVBizModuleFactory;
import com.tencent.avbiz.IModule;
import com.tencent.avbiz.IModule.FocusChangeListener;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class QCircleAVController
  implements IModule.FocusChangeListener
{
  public static final QCircleAVController a = new QCircleAVController();
  private IModule b = AVBizModuleFactory.getModuleByName("小世界");
  private Handler c = new Handler(Looper.getMainLooper());
  private volatile boolean d = false;
  
  private QCircleAVController()
  {
    this.b.setListener(this);
  }
  
  public boolean a()
  {
    return this.d;
  }
  
  public void b()
  {
    this.b.abandonAVFocus();
  }
  
  public String c()
  {
    String str = this.b.requestAVFocus();
    HashMap localHashMap = new HashMap(2);
    if (!"true".equals(str))
    {
      localHashMap.put("state", Integer.valueOf(QCirclePluginConfig.PhoneCallState.TALKING.ordinal()));
      this.d = true;
    }
    else
    {
      localHashMap.put("state", Integer.valueOf(QCirclePluginConfig.PhoneCallState.IDLE.ordinal()));
      this.d = false;
    }
    this.c.post(new QCircleAVController.1(this, localHashMap));
    return str;
  }
  
  public void onFocusGain()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AVFocusGain:");
    localStringBuilder.append(hashCode());
    QLog.d("AVController", 1, localStringBuilder.toString());
    this.d = false;
    this.c.post(new QCircleAVController.3(this));
  }
  
  public void onFocusLoss()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AVFocusLoss:");
    localStringBuilder.append(hashCode());
    QLog.d("AVController", 1, localStringBuilder.toString());
    this.d = true;
    this.c.post(new QCircleAVController.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.QCircleAVController
 * JD-Core Version:    0.7.0.1
 */