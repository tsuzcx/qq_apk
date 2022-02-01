package com.tencent.av;

import com.qq.jce.wup.UniPacket;
import com.tencent.av.video.jce.QQService.strupbuff;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public class SharpReport_OffLine
{
  private static final String[] d = { "UNKNOWN", "WIFI", "CMWAP", "CMNET", "UNIWAP", "UNINET", "CTWAP", "CTNET", "3GWAP", "3GNET" };
  private static SharpReport_OffLine e = null;
  private UniPacket a = null;
  private Map<String, ArrayList<byte[]>> b = null;
  private strupbuff c = null;
  private SharpReport_OffLine.ReportHeader f = null;
  private byte[] g = null;
  private int h = 0;
  
  private int a(long paramLong, byte[] paramArrayOfByte)
  {
    Object localObject = this.b;
    if ((localObject != null) && (this.a != null))
    {
      if (this.c == null) {
        return 0;
      }
      ((Map)localObject).clear();
      this.b.put("617", new ArrayList());
      ((ArrayList)this.b.get("617")).add(paramArrayOfByte);
      this.a.put("Data", this.c);
      paramArrayOfByte = this.a.encode();
      localObject = new ToServiceMsg(MsfServiceSdk.get().getMsfServiceName(), String.valueOf(paramLong), "CliLogSvc.UploadReq");
      ((ToServiceMsg)localObject).setNeedCallback(false);
      ((ToServiceMsg)localObject).putWupBuffer(paramArrayOfByte);
      ((ToServiceMsg)localObject).setNeedRemindSlowNetwork(false);
      try
      {
        int i = MsfServiceSdk.get().sendMsg((ToServiceMsg)localObject);
        if (i >= 0) {
          return 1;
        }
        return 0;
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
    return 0;
  }
  
  private int a(String paramString)
  {
    try
    {
      paramString = paramString.getBytes("utf-8");
      int i = 0;
      while (i < paramString.length)
      {
        byte[] arrayOfByte = this.g;
        int j = this.h;
        arrayOfByte[j] = paramString[i];
        this.h = (j + 1);
        i += 1;
      }
      return 0;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString.printStackTrace();
    }
    return -1;
  }
  
  public static SharpReport_OffLine a()
  {
    if (e == null) {
      e = new SharpReport_OffLine();
    }
    return e;
  }
  
  private void a(int paramInt)
  {
    int i = (byte)(paramInt & 0xFF);
    byte[] arrayOfByte = this.g;
    paramInt = this.h;
    arrayOfByte[paramInt] = i;
    this.h = (paramInt + 1);
  }
  
  private void a(long paramLong)
  {
    int i = (byte)(int)(paramLong >> 56 & 0xFF);
    int j = (byte)(int)(paramLong >> 48 & 0xFF);
    int k = (byte)(int)(paramLong >> 40 & 0xFF);
    int m = (byte)(int)(paramLong >> 32 & 0xFF);
    int n = (byte)(int)(paramLong >> 24 & 0xFF);
    int i1 = (byte)(int)(paramLong >> 16 & 0xFF);
    int i2 = (byte)(int)(paramLong >> 8 & 0xFF);
    int i3 = (byte)(int)(paramLong & 0xFF);
    byte[] arrayOfByte = this.g;
    int i4 = this.h;
    arrayOfByte[i4] = i;
    arrayOfByte[(i4 + 1)] = j;
    arrayOfByte[(i4 + 2)] = k;
    arrayOfByte[(i4 + 3)] = m;
    arrayOfByte[(i4 + 4)] = n;
    arrayOfByte[(i4 + 5)] = i1;
    arrayOfByte[(i4 + 6)] = i2;
    arrayOfByte[(i4 + 7)] = i3;
    this.h = (i4 + 8);
  }
  
  public static void a(long paramLong1, long paramLong2, int paramInt)
  {
    SharpReport_OffLine localSharpReport_OffLine = a();
    localSharpReport_OffLine.a(0L, paramLong1, paramLong2);
    localSharpReport_OffLine.a(paramInt, 2, paramLong2);
  }
  
  private String b()
  {
    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
  }
  
  private void b(int paramInt)
  {
    int i = (byte)(paramInt >> 8 & 0xFF);
    int j = (byte)(paramInt & 0xFF);
    byte[] arrayOfByte = this.g;
    paramInt = this.h;
    arrayOfByte[paramInt] = i;
    arrayOfByte[(paramInt + 1)] = j;
    this.h = (paramInt + 2);
  }
  
  private int c()
  {
    Object localObject = NetworkUtil.getApn(BaseApplication.getContext());
    int i;
    if ("wifi".equals(localObject)) {
      i = 1;
    } else if ("cmnet".equals(localObject)) {
      i = 3;
    } else if ("cmwap".equals(localObject)) {
      i = 2;
    } else if ("ctnet".equals(localObject)) {
      i = 7;
    } else if ("ctwap".equals(localObject)) {
      i = 6;
    } else if ("uninet".equals(localObject)) {
      i = 5;
    } else if ("uniwap".equals(localObject)) {
      i = 4;
    } else if ("3gnet".equals(localObject)) {
      i = 9;
    } else if ("3gwap".equals(localObject)) {
      i = 8;
    } else {
      i = 0;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getApn: ");
      ((StringBuilder)localObject).append(i);
      QLog.d("SharpReport_OffLine", 2, ((StringBuilder)localObject).toString());
    }
    return i;
  }
  
  private int c(int paramInt)
  {
    if (this.g == null) {
      return -1;
    }
    b(this.f.a.length());
    int i = a(this.f.a);
    if (i < 0) {
      return i;
    }
    b(this.f.b.length());
    i = a(this.f.b);
    if (i < 0) {
      return i;
    }
    b(this.f.c.length());
    i = a(this.f.c);
    if (i < 0) {
      return i;
    }
    b(this.f.f.length());
    i = a(this.f.f);
    if (i < 0) {
      return i;
    }
    b(this.f.d.length());
    i = a(this.f.d);
    if (i < 0) {
      return i;
    }
    b(this.f.e.length());
    i = a(this.f.e);
    if (i < 0) {
      return i;
    }
    a(this.f.i);
    a(this.f.g);
    a(this.f.j);
    a(this.f.h);
    a(this.f.k);
    a(paramInt);
    return 0;
  }
  
  public int a(int paramInt1, int paramInt2, long paramLong)
  {
    if (this.f == null) {
      return -1;
    }
    int i = c();
    Object localObject = this.f;
    ((SharpReport_OffLine.ReportHeader)localObject).e = d[i];
    ((SharpReport_OffLine.ReportHeader)localObject).d = b();
    localObject = this.f;
    ((SharpReport_OffLine.ReportHeader)localObject).j = 0;
    ((SharpReport_OffLine.ReportHeader)localObject).k = paramInt2;
    if (paramLong != 0L) {
      ((SharpReport_OffLine.ReportHeader)localObject).h = paramLong;
    }
    this.h = 0;
    if (c(paramInt1) < 0) {
      return -1;
    }
    paramInt2 = this.h;
    if (paramInt2 > 0)
    {
      localObject = new byte[paramInt2];
      paramInt2 = 0;
      while (paramInt2 < this.h)
      {
        localObject[paramInt2] = this.g[paramInt2];
        paramInt2 += 1;
      }
      a(this.f.g, (byte[])localObject);
      this.h = 0;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("report_node is");
        ((StringBuilder)localObject).append(paramInt1);
        QLog.d("SharpReport_Node", 2, ((StringBuilder)localObject).toString());
      }
      return 0;
    }
    return -1;
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3)
  {
    SharpReport_OffLine.ReportHeader localReportHeader = this.f;
    if (localReportHeader == null) {
      return;
    }
    localReportHeader.h = paramLong3;
    localReportHeader.g = paramLong2;
    localReportHeader.i = paramLong1;
    localReportHeader.c = String.valueOf(AppSetting.d());
    this.f.f = AppSetting.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.SharpReport_OffLine
 * JD-Core Version:    0.7.0.1
 */