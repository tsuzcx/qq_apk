package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import com.tencent.luggage.wxa.qz.o;
import java.util.HashSet;
import java.util.Set;

public abstract class b
  implements Parcelable
{
  private static final Set<Object> a = new HashSet();
  private Messenger b;
  private String c;
  
  public b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(Process.myPid());
    localStringBuilder.append("");
    localStringBuilder.append(hashCode());
    this.c = localStringBuilder.toString();
  }
  
  public abstract void a();
  
  void a(Messenger paramMessenger)
  {
    this.b = paramMessenger;
  }
  
  public void a(Parcel paramParcel) {}
  
  protected void a(boolean paramBoolean) {}
  
  public void b() {}
  
  void b(String paramString)
  {
    this.c = paramString;
  }
  
  public String d()
  {
    return this.c;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  protected final boolean e()
  {
    if (this.b == null) {
      return false;
    }
    Message localMessage = Message.obtain();
    localMessage.setData(AppBrandMainProcessService.a(this, false));
    try
    {
      this.b.send(localMessage);
      a(true);
      return true;
    }
    catch (Exception localException)
    {
      o.b("MicroMsg.MainProcessTask", "callback failed, class[%s], e=%s", new Object[] { getClass().getName(), localException });
      a(false);
    }
    return false;
  }
  
  public final boolean f()
  {
    return AppBrandMainProcessService.b(this);
  }
  
  public final void g()
  {
    AppBrandMainProcessService.a(this);
  }
  
  public void h()
  {
    a.add(this);
  }
  
  public void i()
  {
    a.remove(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.b
 * JD-Core Version:    0.7.0.1
 */