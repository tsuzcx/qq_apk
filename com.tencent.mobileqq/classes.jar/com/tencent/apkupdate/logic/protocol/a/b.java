package com.tencent.apkupdate.logic.protocol.a;

import android.os.Message;
import com.qq.taf.jce.JceStruct;
import com.tencent.apkupdate.b.i;
import com.tencent.apkupdate.logic.a;
import com.tencent.apkupdate.logic.protocol.BaseHttpRequest;
import com.tencent.apkupdate.logic.protocol.jce.ApkFileInfo;
import com.tencent.apkupdate.logic.protocol.jce.ReportApkFileInfoRequest;
import com.tencent.apkupdate.logic.protocol.jce.ReportApkFileInfoResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b
  extends BaseHttpRequest
{
  private final List a;
  
  public b(List paramList)
  {
    this.a = paramList;
  }
  
  protected final void onDataReceiveFailed()
  {
    Message localMessage = a.a().obtainMessage();
    localMessage.what = 4;
    localMessage.sendToTarget();
  }
  
  protected final void onFinished(JceStruct paramJceStruct1, JceStruct paramJceStruct2)
  {
    if ((paramJceStruct2 != null) && ((paramJceStruct2 instanceof ReportApkFileInfoResponse)))
    {
      paramJceStruct2 = (ReportApkFileInfoResponse)paramJceStruct2;
      StringBuilder localStringBuilder = new StringBuilder("UploadApkHttpRequest:onFinished; ret=");
      localStringBuilder.append(paramJceStruct2.ret);
      i.a("UploadApkHttpRequest", localStringBuilder.toString());
      if (paramJceStruct2.ret == 0)
      {
        paramJceStruct2 = a.a().obtainMessage();
        paramJceStruct2.what = 3;
        paramJceStruct2.sendToTarget();
        if (paramJceStruct1 != null)
        {
          paramJceStruct2 = (ReportApkFileInfoRequest)paramJceStruct1;
          paramJceStruct1 = new ArrayList();
          paramJceStruct2 = paramJceStruct2.apkFileInfoList.iterator();
          while (paramJceStruct2.hasNext()) {
            paramJceStruct1.add(((ApkFileInfo)paramJceStruct2.next()).packageName);
          }
          if (paramJceStruct1.size() > 0)
          {
            paramJceStruct2 = a.a().obtainMessage();
            paramJceStruct2.what = 8;
            paramJceStruct2.obj = paramJceStruct1;
            paramJceStruct2.sendToTarget();
          }
        }
      }
    }
  }
  
  protected final void prepareData()
  {
    super.prepareData();
    Object localObject1 = new ReportApkFileInfoRequest();
    ((ReportApkFileInfoRequest)localObject1).apkFileInfoList = ((ArrayList)this.a);
    setData((JceStruct)localObject1);
    localObject1 = new StringBuffer("UploadApkHttpRequest:prepareData;apkFileInfoList= [");
    Object localObject2 = this.a.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      ApkFileInfo localApkFileInfo = (ApkFileInfo)((Iterator)localObject2).next();
      StringBuilder localStringBuilder = new StringBuilder("pkgname=");
      localStringBuilder.append(localApkFileInfo.packageName);
      localStringBuilder.append(";apkId=");
      localStringBuilder.append(localApkFileInfo.apkId);
      localStringBuilder.append("| \n\r");
      ((StringBuffer)localObject1).append(localStringBuilder.toString());
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(((StringBuffer)localObject1).toString());
    ((StringBuilder)localObject2).append("]");
    i.a("UploadApkHttpRequest", ((StringBuilder)localObject2).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.apkupdate.logic.protocol.a.b
 * JD-Core Version:    0.7.0.1
 */