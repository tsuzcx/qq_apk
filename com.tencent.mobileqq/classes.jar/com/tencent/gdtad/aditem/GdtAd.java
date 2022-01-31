package com.tencent.gdtad.aditem;

import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import java.io.ByteArrayOutputStream;
import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DestInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo;

public class GdtAd
  implements Externalizable
{
  public long advertiserId = -2147483648L;
  private qq_ad_get.QQAdGetRsp.AdInfo info;
  public int reportState;
  
  public GdtAd() {}
  
  public GdtAd(qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo)
  {
    this.info = paramAdInfo;
  }
  
  private boolean a()
  {
    return this.info != null;
  }
  
  public String getCanvas()
  {
    if (a()) {
      return this.info.dest_info.canvas_json.get();
    }
    return null;
  }
  
  public String getTraceId()
  {
    if (a()) {
      return this.info.report_info.trace_info.traceid.get();
    }
    return null;
  }
  
  public String getUrlForAction()
  {
    if (a()) {
      return this.info.report_info.landing_page_report_url.get();
    }
    return null;
  }
  
  public String getUrlForClick()
  {
    if (a()) {
      return this.info.report_info.click_url.get();
    }
    return null;
  }
  
  public String getUrlForImpression()
  {
    if (a()) {
      return this.info.report_info.exposure_url.get();
    }
    return null;
  }
  
  public String getViewId()
  {
    if (a()) {
      return this.info.report_info.trace_info.view_id.get();
    }
    return null;
  }
  
  public void readExternal(ObjectInput paramObjectInput)
  {
    if (paramObjectInput == null)
    {
      GdtLog.d("GdtAd", "readExternal error");
      return;
    }
    this.advertiserId = paramObjectInput.readLong();
    int j = paramObjectInput.readInt();
    if (j <= 0)
    {
      GdtLog.d("GdtAd", "readExternal error");
      return;
    }
    Object localObject = new ByteArrayOutputStream();
    int i = 0;
    for (;;)
    {
      byte[] arrayOfByte;
      int k;
      if (i < j)
      {
        arrayOfByte = new byte[j - i];
        k = paramObjectInput.read(arrayOfByte);
        if (k < 0) {
          GdtLog.d("GdtAd", "readExternal error");
        }
      }
      else
      {
        ((ByteArrayOutputStream)localObject).close();
        paramObjectInput = ((ByteArrayOutputStream)localObject).toByteArray();
        if ((i == j) && (paramObjectInput.length == j)) {
          break;
        }
        GdtLog.d("GdtAd", "readExternal error");
        return;
      }
      i += k;
      ((ByteArrayOutputStream)localObject).write(arrayOfByte, 0, k);
    }
    localObject = new qq_ad_get.QQAdGetRsp.AdInfo();
    try
    {
      ((qq_ad_get.QQAdGetRsp.AdInfo)localObject).mergeFrom(paramObjectInput);
      this.info = ((qq_ad_get.QQAdGetRsp.AdInfo)localObject);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramObjectInput)
    {
      GdtLog.d("GdtAd", "readExternal", paramObjectInput);
    }
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
  {
    if ((paramObjectOutput == null) || (this.info == null))
    {
      GdtLog.d("GdtAd", "writeExternal error");
      return;
    }
    paramObjectOutput.writeLong(this.advertiserId);
    byte[] arrayOfByte = this.info.toByteArray();
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      GdtLog.d("GdtAd", "writeExternal error");
      return;
    }
    paramObjectOutput.writeInt(arrayOfByte.length);
    paramObjectOutput.write(arrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.gdtad.aditem.GdtAd
 * JD-Core Version:    0.7.0.1
 */