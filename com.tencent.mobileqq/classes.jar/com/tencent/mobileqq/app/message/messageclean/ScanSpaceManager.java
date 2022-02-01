package com.tencent.mobileqq.app.message.messageclean;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.api.IFMSettings;
import com.tencent.mobileqq.filemanager.settings.FMSettings;
import com.tencent.mobileqq.statistics.storage.StorageReport;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ScanSpaceManager
  implements Handler.Callback
{
  public static final ArrayList<String> d = new ArrayList(2);
  public long a = 0L;
  public long b = 0L;
  public long c = 0L;
  private volatile boolean e = false;
  private IScanSpaceListener f;
  private Handler g;
  
  public ScanSpaceManager()
  {
    g();
    this.e = false;
    this.g = new Handler(Looper.getMainLooper(), this);
  }
  
  private void a(int paramInt)
  {
    Object localObject = this.g;
    if (localObject != null)
    {
      localObject = ((Handler)localObject).obtainMessage(1);
      ((Message)localObject).arg1 = paramInt;
      this.g.sendMessage((Message)localObject);
    }
  }
  
  private void g()
  {
    String str1 = FMSettings.a().getDefaultRecvPath();
    String str2 = FMSettings.a().getOtherRecvPath();
    d.clear();
    StringBuilder localStringBuilder;
    if (!TextUtils.isEmpty(str1))
    {
      d.add(str1);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(" need scan file path1 = ");
      localStringBuilder.append(str1);
      QLog.d("ScanSpaceManager", 2, localStringBuilder.toString());
    }
    if (!TextUtils.isEmpty(str2))
    {
      d.add(str2);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(" need scan file path2 = ");
      localStringBuilder.append(str2);
      QLog.d("ScanSpaceManager", 2, localStringBuilder.toString());
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(" need scan file path1 = ");
      localStringBuilder.append(str1);
      localStringBuilder.append(" path2 = ");
      localStringBuilder.append(str2);
      QLog.d("ScanSpaceManager", 2, localStringBuilder.toString());
    }
  }
  
  private void h()
  {
    Object localObject = this.g;
    if (localObject != null)
    {
      localObject = ((Handler)localObject).obtainMessage(2);
      this.g.sendMessageDelayed((Message)localObject, 200L);
    }
  }
  
  public void a()
  {
    if (!this.e)
    {
      IScanSpaceListener localIScanSpaceListener = this.f;
      if (localIScanSpaceListener != null)
      {
        localIScanSpaceListener.b();
        this.f.a(0);
      }
      StorageReport.c().post(new ScanSpaceManager.ScanSpaceTask(this));
    }
  }
  
  public void a(IScanSpaceListener paramIScanSpaceListener)
  {
    this.f = paramIScanSpaceListener;
  }
  
  public boolean b()
  {
    return this.e;
  }
  
  public long c()
  {
    if (this.e) {
      return this.a - this.b - this.c;
    }
    return 0L;
  }
  
  public long d()
  {
    if (this.e) {
      return this.c;
    }
    return 0L;
  }
  
  public long e()
  {
    if (this.e) {
      return this.a;
    }
    return 0L;
  }
  
  public void f()
  {
    this.e = false;
    StorageReport.d();
    d.clear();
    Handler localHandler = this.g;
    if (localHandler != null)
    {
      localHandler.removeCallbacksAndMessages(null);
      this.g = null;
    }
    this.f = null;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i == 2)
      {
        paramMessage = this.f;
        if (paramMessage != null)
        {
          long l1 = this.b;
          long l2 = this.a;
          long l3 = this.c;
          paramMessage.a(l1, l2 - l1 - l3, l3, l2);
        }
      }
    }
    else
    {
      IScanSpaceListener localIScanSpaceListener = this.f;
      if (localIScanSpaceListener != null) {
        localIScanSpaceListener.a(paramMessage.arg1);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.messageclean.ScanSpaceManager
 * JD-Core Version:    0.7.0.1
 */