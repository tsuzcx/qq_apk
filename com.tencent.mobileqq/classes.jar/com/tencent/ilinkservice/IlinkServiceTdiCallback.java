package com.tencent.ilinkservice;

import com.tencent.ilink.tdi.b.a;
import com.tencent.ilink.tdi.b.b;
import com.tencent.ilink.tdi.b.d;
import com.tencent.ilink.tdi.b.g;
import com.tencent.ilink.tdi.b.j;
import com.tencent.ilink.tdi.b.l;
import com.tencent.ilink.tdi.b.n;
import com.tencent.ilink.tdi.b.p;
import com.tencent.ilink.tdi.b.r;
import com.tencent.ilink.tdi.b.v;
import com.tencent.ilink.tdi.x;
import com.tencent.mars.ilink.xlog.Log;
import java.util.Iterator;
import java.util.Vector;

final class IlinkServiceTdiCallback
  implements x
{
  private static final String TAG = "IlinkServiceTdiCB";
  private String m_appid_;
  private IlinkServiceTdiCallback.a m_observer_;
  
  IlinkServiceTdiCallback(String paramString, IlinkServiceTdiCallback.a parama)
  {
    this.m_appid_ = paramString;
    this.m_observer_ = parama;
  }
  
  public void onAppSessionTimeout()
  {
    IlinkServiceTdiCallback.a locala = this.m_observer_;
    String str = this.m_appid_;
    locala.addServiceCallbackTask(str, "onAppSessionTimeout", new Class[] { String.class }, new Object[] { str });
  }
  
  public void onCancelOAuthComplete(int paramInt1, int paramInt2)
  {
    Class localClass1 = Integer.TYPE;
    Class localClass2 = Integer.TYPE;
    IlinkServiceTdiCallback.a locala = this.m_observer_;
    String str = this.m_appid_;
    locala.addServiceCallbackTask(str, "onCancelOAuthComplete", new Class[] { String.class, localClass1, localClass2 }, new Object[] { str, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public void onCheckLoginQrCodeComplete(int paramInt, b.g paramg)
  {
    Class localClass = Integer.TYPE;
    IlinkServiceTdiCallback.a locala = this.m_observer_;
    String str = this.m_appid_;
    paramg = paramg.toByteArray();
    locala.addServiceCallbackTask(str, "onCheckLoginQrCode", new Class[] { String.class, localClass, [B.class }, new Object[] { str, Integer.valueOf(paramInt), paramg });
  }
  
  public void onFaceExtVerifyComplete(int paramInt, b.j paramj)
  {
    Class localClass = Integer.TYPE;
    IlinkServiceTdiCallback.a locala = this.m_observer_;
    String str = this.m_appid_;
    paramj = paramj.toByteArray();
    locala.addServiceCallbackTask(str, "onFaceExtVerifyComplete", new Class[] { String.class, localClass, [B.class }, new Object[] { str, Integer.valueOf(paramInt), paramj });
  }
  
  public void onFaceRecognizeComplete(int paramInt, b.n paramn)
  {
    Class localClass = Integer.TYPE;
    IlinkServiceTdiCallback.a locala = this.m_observer_;
    String str = this.m_appid_;
    paramn = paramn.toByteArray();
    locala.addServiceCallbackTask(str, "onFaceRecognizeComplete", new Class[] { String.class, localClass, [B.class }, new Object[] { str, Integer.valueOf(paramInt), paramn });
  }
  
  public void onFaceRecognizeConfigComplete(int paramInt, b.l paraml)
  {
    Class localClass = Integer.TYPE;
    IlinkServiceTdiCallback.a locala = this.m_observer_;
    String str = this.m_appid_;
    paraml = paraml.toByteArray();
    locala.addServiceCallbackTask(str, "onFaceRecognizeConfigComplete", new Class[] { String.class, localClass, [B.class }, new Object[] { str, Integer.valueOf(paramInt), paraml });
  }
  
  public void onGetAppPushTokenComplete(int paramInt1, int paramInt2, b.b paramb)
  {
    Class localClass1 = Integer.TYPE;
    Class localClass2 = Integer.TYPE;
    IlinkServiceTdiCallback.a locala = this.m_observer_;
    String str = this.m_appid_;
    paramb = paramb.toByteArray();
    locala.addServiceCallbackTask(str, "onNewGetAppPushTokenComplete", new Class[] { String.class, localClass1, localClass2, [B.class }, new Object[] { str, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramb });
  }
  
  public void onGetLoginQrCodeComplete(int paramInt, b.p paramp)
  {
    Class localClass = Integer.TYPE;
    IlinkServiceTdiCallback.a locala = this.m_observer_;
    String str = this.m_appid_;
    paramp = paramp.toByteArray();
    locala.addServiceCallbackTask(str, "onGetLoginQrCodeComplete", new Class[] { String.class, localClass, [B.class }, new Object[] { str, Integer.valueOf(paramInt), paramp });
  }
  
  public void onGetOAuthCodeComplete(int paramInt1, int paramInt2, b.r paramr)
  {
    Class localClass1 = Integer.TYPE;
    Class localClass2 = Integer.TYPE;
    IlinkServiceTdiCallback.a locala = this.m_observer_;
    String str = this.m_appid_;
    paramr = paramr.toByteArray();
    locala.addServiceCallbackTask(str, "onGetOAuthCodeComplete", new Class[] { String.class, localClass1, localClass2, [B.class }, new Object[] { str, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramr });
  }
  
  public void onLoginComplete(int paramInt, b.v paramv)
  {
    Class localClass = Integer.TYPE;
    IlinkServiceTdiCallback.a locala = this.m_observer_;
    String str = this.m_appid_;
    paramv = paramv.toByteArray();
    locala.addServiceCallbackTask(str, "onTdiLoginComplete", new Class[] { String.class, localClass, [B.class }, new Object[] { str, Integer.valueOf(paramInt), paramv });
  }
  
  public void onLogoutComplete(int paramInt)
  {
    Class localClass = Integer.TYPE;
    IlinkServiceTdiCallback.a locala = this.m_observer_;
    String str = this.m_appid_;
    locala.addServiceCallbackTask(str, "onLogoutComplete", new Class[] { String.class, localClass }, new Object[] { str, Integer.valueOf(paramInt) });
  }
  
  public void onReceiveAppMessage(b.a parama)
  {
    Class[] arrayOfClass = new Class[2];
    arrayOfClass[0] = String.class;
    arrayOfClass[1] = [B.class;
    Object localObject = this.m_observer_;
    String str = this.m_appid_;
    ((IlinkServiceTdiCallback.a)localObject).addServiceCallbackTask(str, "onReceiveAppMessage", arrayOfClass, new Object[] { str, parama.toByteArray() });
    localObject = this.m_observer_.getCloneCallers(this.m_appid_);
    if (localObject != null)
    {
      localObject = ((Vector)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        str = (String)((Iterator)localObject).next();
        this.m_observer_.addDeviceCallbackTask(str, "onReceiveAppMessage", arrayOfClass, new Object[] { this.m_appid_, parama.toByteArray() });
      }
    }
  }
  
  public void onReceiveAppResponse(int paramInt1, int paramInt2, b.d paramd)
  {
    String str1 = this.m_observer_.getCallerByTaskid(paramInt1);
    if (str1.equals(""))
    {
      paramd = new StringBuilder();
      paramd.append("could not find caller by taskid:");
      paramd.append(paramInt1);
      Log.e("IlinkServiceTdiCB", paramd.toString());
      return;
    }
    Class localClass1 = Integer.TYPE;
    Class localClass2 = Integer.TYPE;
    IlinkServiceTdiCallback.a locala = this.m_observer_;
    String str2 = this.m_appid_;
    paramd = paramd.toByteArray();
    locala.addDeviceCallbackTask(str1, "onReceiveAppResponse", new Class[] { String.class, localClass1, localClass2, [B.class }, new Object[] { str2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramd });
  }
  
  public void onRequestUploadLogfiles(byte[] paramArrayOfByte)
  {
    IlinkServiceTdiCallback.a locala = this.m_observer_;
    String str = this.m_appid_;
    locala.addServiceCallbackTask(str, "OnRequestUploadLogfiles", new Class[] { String.class, [B.class }, new Object[] { str, paramArrayOfByte });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilinkservice.IlinkServiceTdiCallback
 * JD-Core Version:    0.7.0.1
 */