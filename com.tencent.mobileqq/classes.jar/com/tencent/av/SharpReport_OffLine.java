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
  private static SharpReport_OffLine jdField_a_of_type_ComTencentAvSharpReport_OffLine = null;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "UNKNOWN", "WIFI", "CMWAP", "CMNET", "UNIWAP", "UNINET", "CTWAP", "CTNET", "3GWAP", "3GNET" };
  private int jdField_a_of_type_Int = 0;
  private UniPacket jdField_a_of_type_ComQqJceWupUniPacket = null;
  private SharpReport_OffLine.ReportHeader jdField_a_of_type_ComTencentAvSharpReport_OffLine$ReportHeader = null;
  private strupbuff jdField_a_of_type_ComTencentAvVideoJceQQServiceStrupbuff = null;
  private Map<String, ArrayList<byte[]>> jdField_a_of_type_JavaUtilMap = null;
  private byte[] jdField_a_of_type_ArrayOfByte = null;
  
  private int a()
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
  
  private int a(int paramInt)
  {
    if (this.jdField_a_of_type_ArrayOfByte == null) {
      return -1;
    }
    b(this.jdField_a_of_type_ComTencentAvSharpReport_OffLine$ReportHeader.jdField_a_of_type_JavaLangString.length());
    int i = a(this.jdField_a_of_type_ComTencentAvSharpReport_OffLine$ReportHeader.jdField_a_of_type_JavaLangString);
    if (i < 0) {
      return i;
    }
    b(this.jdField_a_of_type_ComTencentAvSharpReport_OffLine$ReportHeader.jdField_b_of_type_JavaLangString.length());
    i = a(this.jdField_a_of_type_ComTencentAvSharpReport_OffLine$ReportHeader.jdField_b_of_type_JavaLangString);
    if (i < 0) {
      return i;
    }
    b(this.jdField_a_of_type_ComTencentAvSharpReport_OffLine$ReportHeader.jdField_c_of_type_JavaLangString.length());
    i = a(this.jdField_a_of_type_ComTencentAvSharpReport_OffLine$ReportHeader.jdField_c_of_type_JavaLangString);
    if (i < 0) {
      return i;
    }
    b(this.jdField_a_of_type_ComTencentAvSharpReport_OffLine$ReportHeader.f.length());
    i = a(this.jdField_a_of_type_ComTencentAvSharpReport_OffLine$ReportHeader.f);
    if (i < 0) {
      return i;
    }
    b(this.jdField_a_of_type_ComTencentAvSharpReport_OffLine$ReportHeader.d.length());
    i = a(this.jdField_a_of_type_ComTencentAvSharpReport_OffLine$ReportHeader.d);
    if (i < 0) {
      return i;
    }
    b(this.jdField_a_of_type_ComTencentAvSharpReport_OffLine$ReportHeader.e.length());
    i = a(this.jdField_a_of_type_ComTencentAvSharpReport_OffLine$ReportHeader.e);
    if (i < 0) {
      return i;
    }
    a(this.jdField_a_of_type_ComTencentAvSharpReport_OffLine$ReportHeader.jdField_c_of_type_Long);
    a(this.jdField_a_of_type_ComTencentAvSharpReport_OffLine$ReportHeader.jdField_a_of_type_Long);
    a(this.jdField_a_of_type_ComTencentAvSharpReport_OffLine$ReportHeader.jdField_a_of_type_Int);
    a(this.jdField_a_of_type_ComTencentAvSharpReport_OffLine$ReportHeader.jdField_b_of_type_Long);
    a(this.jdField_a_of_type_ComTencentAvSharpReport_OffLine$ReportHeader.jdField_b_of_type_Int);
    a(paramInt);
    return 0;
  }
  
  private int a(long paramLong, byte[] paramArrayOfByte)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilMap;
    if ((localObject != null) && (this.jdField_a_of_type_ComQqJceWupUniPacket != null))
    {
      if (this.jdField_a_of_type_ComTencentAvVideoJceQQServiceStrupbuff == null) {
        return 0;
      }
      ((Map)localObject).clear();
      this.jdField_a_of_type_JavaUtilMap.put("617", new ArrayList());
      ((ArrayList)this.jdField_a_of_type_JavaUtilMap.get("617")).add(paramArrayOfByte);
      this.jdField_a_of_type_ComQqJceWupUniPacket.put("Data", this.jdField_a_of_type_ComTencentAvVideoJceQQServiceStrupbuff);
      paramArrayOfByte = this.jdField_a_of_type_ComQqJceWupUniPacket.encode();
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
        byte[] arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
        int j = this.jdField_a_of_type_Int;
        arrayOfByte[j] = paramString[i];
        this.jdField_a_of_type_Int = (j + 1);
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
    if (jdField_a_of_type_ComTencentAvSharpReport_OffLine == null) {
      jdField_a_of_type_ComTencentAvSharpReport_OffLine = new SharpReport_OffLine();
    }
    return jdField_a_of_type_ComTencentAvSharpReport_OffLine;
  }
  
  private String a()
  {
    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
  }
  
  private void a(int paramInt)
  {
    int i = (byte)(paramInt & 0xFF);
    byte[] arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    paramInt = this.jdField_a_of_type_Int;
    arrayOfByte[paramInt] = i;
    this.jdField_a_of_type_Int = (paramInt + 1);
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
    byte[] arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    int i4 = this.jdField_a_of_type_Int;
    arrayOfByte[i4] = i;
    arrayOfByte[(i4 + 1)] = j;
    arrayOfByte[(i4 + 2)] = k;
    arrayOfByte[(i4 + 3)] = m;
    arrayOfByte[(i4 + 4)] = n;
    arrayOfByte[(i4 + 5)] = i1;
    arrayOfByte[(i4 + 6)] = i2;
    arrayOfByte[(i4 + 7)] = i3;
    this.jdField_a_of_type_Int = (i4 + 8);
  }
  
  public static void a(long paramLong1, long paramLong2, int paramInt)
  {
    SharpReport_OffLine localSharpReport_OffLine = a();
    localSharpReport_OffLine.a(0L, paramLong1, paramLong2);
    localSharpReport_OffLine.a(paramInt, 2, paramLong2);
  }
  
  private void b(int paramInt)
  {
    int i = (byte)(paramInt >> 8 & 0xFF);
    int j = (byte)(paramInt & 0xFF);
    byte[] arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    paramInt = this.jdField_a_of_type_Int;
    arrayOfByte[paramInt] = i;
    arrayOfByte[(paramInt + 1)] = j;
    this.jdField_a_of_type_Int = (paramInt + 2);
  }
  
  public int a(int paramInt1, int paramInt2, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentAvSharpReport_OffLine$ReportHeader == null) {
      return -1;
    }
    int i = a();
    Object localObject = this.jdField_a_of_type_ComTencentAvSharpReport_OffLine$ReportHeader;
    ((SharpReport_OffLine.ReportHeader)localObject).e = jdField_a_of_type_ArrayOfJavaLangString[i];
    ((SharpReport_OffLine.ReportHeader)localObject).d = a();
    localObject = this.jdField_a_of_type_ComTencentAvSharpReport_OffLine$ReportHeader;
    ((SharpReport_OffLine.ReportHeader)localObject).jdField_a_of_type_Int = 0;
    ((SharpReport_OffLine.ReportHeader)localObject).jdField_b_of_type_Int = paramInt2;
    if (paramLong != 0L) {
      ((SharpReport_OffLine.ReportHeader)localObject).jdField_b_of_type_Long = paramLong;
    }
    this.jdField_a_of_type_Int = 0;
    if (a(paramInt1) < 0) {
      return -1;
    }
    paramInt2 = this.jdField_a_of_type_Int;
    if (paramInt2 > 0)
    {
      localObject = new byte[paramInt2];
      paramInt2 = 0;
      while (paramInt2 < this.jdField_a_of_type_Int)
      {
        localObject[paramInt2] = this.jdField_a_of_type_ArrayOfByte[paramInt2];
        paramInt2 += 1;
      }
      a(this.jdField_a_of_type_ComTencentAvSharpReport_OffLine$ReportHeader.jdField_a_of_type_Long, (byte[])localObject);
      this.jdField_a_of_type_Int = 0;
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
    SharpReport_OffLine.ReportHeader localReportHeader = this.jdField_a_of_type_ComTencentAvSharpReport_OffLine$ReportHeader;
    if (localReportHeader == null) {
      return;
    }
    localReportHeader.jdField_b_of_type_Long = paramLong3;
    localReportHeader.jdField_a_of_type_Long = paramLong2;
    localReportHeader.jdField_c_of_type_Long = paramLong1;
    localReportHeader.jdField_c_of_type_JavaLangString = String.valueOf(AppSetting.a());
    this.jdField_a_of_type_ComTencentAvSharpReport_OffLine$ReportHeader.f = AppSetting.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.SharpReport_OffLine
 * JD-Core Version:    0.7.0.1
 */