package com.qq.wx.voice.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import com.tencent.mobileqq.qmethodmonitor.monitor.NetworkMonitor;
import com.tencent.mobileqq.qmethodmonitor.monitor.PhoneInfoMonitor;
import java.io.ByteArrayInputStream;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Enumeration;

public class ManagerDeviceInfo
{
  private Context a = null;
  private int b;
  private int c;
  private String d;
  private String e;
  private String f;
  private String g;
  private String h;
  private int i;
  private String j;
  private boolean k;
  private String l;
  private int m = 0;
  private String n;
  
  private String a(String paramString)
  {
    try
    {
      paramString = this.a.getPackageManager().getPackageInfo(paramString, 64).signatures;
      Object localObject = CertificateFactory.getInstance("X.509");
      int i1 = 0;
      paramString = a((X509Certificate)((CertificateFactory)localObject).generateCertificate(new ByteArrayInputStream(paramString[0].toByteArray())));
      localObject = new StringBuffer();
      for (;;)
      {
        if (i1 >= paramString.length()) {
          return ((StringBuffer)localObject).toString();
        }
        ((StringBuffer)localObject).append(paramString.charAt(i1));
        i1 += 1;
      }
      return null;
    }
    catch (CertificateException paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private static String a(X509Certificate paramX509Certificate)
  {
    try
    {
      paramX509Certificate = Hex.encode(Hex.generateMD5(paramX509Certificate.getEncoded()));
      return paramX509Certificate;
    }
    catch (CertificateEncodingException paramX509Certificate)
    {
      paramX509Certificate.printStackTrace();
    }
    return null;
  }
  
  public String getAndroid_package_name()
  {
    return this.f;
  }
  
  public String getAndroid_signature()
  {
    return this.e;
  }
  
  public String getDeviceInfo()
  {
    return this.j;
  }
  
  public String getGuid()
  {
    return this.g;
  }
  
  public String getIP()
  {
    return this.n;
  }
  
  public boolean getIsWap()
  {
    return this.k;
  }
  
  public String getNetType()
  {
    return this.h;
  }
  
  public int getNetTypeNum()
  {
    String str = this.h;
    if (str == "2g") {
      return 1;
    }
    if (str == "ct3g") {
      return 2;
    }
    if (str == "cu3g") {
      return 3;
    }
    if (str == "wifi") {
      return 4;
    }
    return 0;
  }
  
  public int getOs()
  {
    return this.b;
  }
  
  public int getOsver()
  {
    return this.c;
  }
  
  public String getSigInfo()
  {
    return this.d;
  }
  
  public String getWapProxyIP()
  {
    String str = this.l;
    if (str != null) {
      return str;
    }
    return null;
  }
  
  public int getWapProxyPort()
  {
    return this.m;
  }
  
  public int init(Context paramContext)
  {
    this.a = paramContext;
    this.b = 2;
    setOSver();
    setGuid();
    setDeviceInfo();
    return setSigInfo();
  }
  
  public void setAndroid_package_name(String paramString)
  {
    this.f = paramString;
  }
  
  public void setAndroid_signature(String paramString)
  {
    this.e = paramString;
  }
  
  public void setDeviceInfo()
  {
    this.j = Build.MODEL;
  }
  
  public void setGuid()
  {
    if (this.a != null) {
      this.g = "Guid";
    }
  }
  
  public void setGuidNeedService()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      this.g = PhoneInfoMonitor.getDeviceId((TelephonyManager)((Context)localObject).getSystemService("phone"));
      localObject = new StringBuilder(String.valueOf(this.g));
      ((StringBuilder)localObject).append("-");
      this.g = ((StringBuilder)localObject).toString();
      localObject = NetworkMonitor.getConnectionInfo((WifiManager)this.a.getSystemService("wifi"));
      StringBuilder localStringBuilder = new StringBuilder(String.valueOf(this.g));
      localStringBuilder.append(((WifiInfo)localObject).getMacAddress());
      this.g = localStringBuilder.toString();
    }
  }
  
  public void setIpAddr()
  {
    try
    {
      Enumeration localEnumeration1 = NetworkMonitor.getNetworkInterfaces();
      while (localEnumeration1.hasMoreElements())
      {
        Enumeration localEnumeration2 = ((NetworkInterface)localEnumeration1.nextElement()).getInetAddresses();
        while (localEnumeration2.hasMoreElements())
        {
          InetAddress localInetAddress = (InetAddress)localEnumeration2.nextElement();
          if (!localInetAddress.isLoopbackAddress()) {
            this.n = localInetAddress.getHostAddress();
          }
        }
      }
      return;
    }
    catch (SocketException localSocketException)
    {
      localSocketException.printStackTrace();
      this.n = null;
    }
  }
  
  public int setNetType()
  {
    Object localObject = this.a;
    if (localObject == null) {
      return -101;
    }
    localObject = ((ConnectivityManager)((Context)localObject).getSystemService("connectivity")).getActiveNetworkInfo();
    if (localObject == null) {
      return -201;
    }
    int i1 = ((NetworkInfo)localObject).getType();
    if (i1 == 0)
    {
      this.h = ((NetworkInfo)localObject).getExtraInfo();
      this.i = ((NetworkInfo)localObject).getSubtype();
      switch (this.i)
      {
      case 5: 
      case 7: 
      case 14: 
      default: 
        this.h = "other";
        break;
      case 15: 
        this.h = "other";
        break;
      case 13: 
        this.h = "other";
        break;
      case 12: 
        this.h = "ct3g";
        break;
      case 11: 
        this.h = "other";
        break;
      case 10: 
        this.h = "other";
        break;
      case 9: 
        this.h = "other";
        break;
      case 8: 
        this.h = "cu3g";
        break;
      case 6: 
        this.h = "ct3g";
        break;
      case 4: 
        this.h = "2g";
        break;
      case 3: 
        this.h = "cu3g";
        break;
      case 2: 
        this.h = "2g";
        break;
      case 1: 
        this.h = "2g";
        break;
      }
    }
    else if (i1 == 1)
    {
      this.h = "wifi";
    }
    this.h = "wifi";
    return 0;
  }
  
  public void setNetType(String paramString)
  {
    this.h = paramString;
  }
  
  public void setOSver()
  {
    this.c = Build.VERSION.SDK_INT;
  }
  
  public int setSigInfo()
  {
    Object localObject = this.a.getPackageName();
    setAndroid_package_name((String)localObject);
    String str = a((String)localObject);
    setAndroid_signature(str);
    if ((localObject != null) && (str != null))
    {
      localObject = new StringBuilder(String.valueOf(localObject));
      ((StringBuilder)localObject).append(";");
      ((StringBuilder)localObject).append(str);
      this.d = ((StringBuilder)localObject).toString();
      return 0;
    }
    return -1;
  }
  
  public void setWap()
  {
    this.k = false;
    NetworkInfo localNetworkInfo = ((ConnectivityManager)this.a.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
    if ((localNetworkInfo != null) && (localNetworkInfo.getType() == 0))
    {
      this.k = true;
      int i1;
      if (Proxy.getDefaultPort() == -1) {
        i1 = 80;
      } else {
        i1 = Proxy.getDefaultPort();
      }
      this.m = i1;
      this.l = Proxy.getDefaultHost();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qq.wx.voice.util.ManagerDeviceInfo
 * JD-Core Version:    0.7.0.1
 */