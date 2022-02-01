package com.tencent.biz.qqcircle.publish.uploader;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.publish.uploader.report.QcirclrBusinessReport;
import com.tencent.component.network.module.report.ExtendData;
import com.tencent.upload.report.Report;
import com.tencent.upload.uinterface.IUploadReport;
import com.tencent.upload.uinterface.TaskTypeConfig;
import java.util.Map;

public class QcircleUploadReport
  implements IUploadReport
{
  public static int a(TaskTypeConfig paramTaskTypeConfig)
  {
    if (TaskTypeConfig.NewQunUploadTaskType.equals(paramTaskTypeConfig)) {
      return 10;
    }
    if (TaskTypeConfig.ImageUploadTaskType.equals(paramTaskTypeConfig)) {
      return 0;
    }
    if (TaskTypeConfig.UppUploadTaskType.equals(paramTaskTypeConfig)) {
      return 8;
    }
    if (TaskTypeConfig.UpsUploadTaskType.equals(paramTaskTypeConfig)) {
      return 12;
    }
    if (TaskTypeConfig.PhotoWallUploadTaskType.equals(paramTaskTypeConfig)) {
      return 14;
    }
    if (TaskTypeConfig.MobileLogUploadTaskType.equals(paramTaskTypeConfig)) {
      return 16;
    }
    if (TaskTypeConfig.VideoUploadTaskType.equals(paramTaskTypeConfig)) {
      return 2;
    }
    return -1;
  }
  
  public static QcircleUploadReport.UploadReportObj a(Report paramReport)
  {
    if (paramReport == null) {
      return null;
    }
    ExtendData localExtendData = new ExtendData();
    if (!TextUtils.isEmpty(paramReport.filePath)) {
      localObject = new String(paramReport.filePath);
    } else {
      localObject = "the path of upload file is empty";
    }
    localExtendData.put(5, (String)localObject);
    Object localObject = paramReport.transfer;
    String str;
    if (localObject != null)
    {
      str = (String)((Map)localObject).get("task_state");
      if (!TextUtils.isEmpty(str)) {
        localExtendData.put(8, str);
      }
      localObject = (String)((Map)localObject).get("business_refer");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        localExtendData.put(9, (String)localObject);
      }
    }
    localObject = new QcircleUploadReport.UploadReportObj();
    int i = a(paramReport.uploadType);
    if (i != 0)
    {
      if (i != 2)
      {
        if (i != 8)
        {
          if (i != 10)
          {
            if (i != 12)
            {
              if (i != 14)
              {
                if (i == 16)
                {
                  localObject = new QcircleUploadReport.UploadReportObj();
                  ((QcircleUploadReport.UploadReportObj)localObject).v = "mobilelog";
                }
              }
              else
              {
                localObject = new QcircleUploadReport.UploadReportObj();
                ((QcircleUploadReport.UploadReportObj)localObject).v = "photowall";
              }
            }
            else
            {
              localObject = new QcircleUploadReport.UploadReportObj();
              ((QcircleUploadReport.UploadReportObj)localObject).v = "ups";
            }
          }
          else
          {
            localObject = new QcircleUploadReport.QQQunReportObj();
            ((QcircleUploadReport.UploadReportObj)localObject).v = "qun";
          }
        }
        else
        {
          localObject = new QcircleUploadReport.UppReportObj();
          ((QcircleUploadReport.UploadReportObj)localObject).v = "upp";
        }
      }
      else
      {
        localObject = new QcircleUploadReport.UploadReportObj();
        ((QcircleUploadReport.UploadReportObj)localObject).v = "video";
      }
    }
    else
    {
      localObject = new QcircleUploadReport.UploadReportObj();
      ((QcircleUploadReport.UploadReportObj)localObject).v = "photo";
    }
    ((QcircleUploadReport.UploadReportObj)localObject).n = paramReport.serverIp;
    ((QcircleUploadReport.UploadReportObj)localObject).a = paramReport.retry;
    ((QcircleUploadReport.UploadReportObj)localObject).b = paramReport.ipsrctype;
    ((QcircleUploadReport.UploadReportObj)localObject).q = paramReport.flowId;
    ((QcircleUploadReport.UploadReportObj)localObject).l = paramReport.networkType;
    ((QcircleUploadReport.UploadReportObj)localObject).m = paramReport.retCode;
    ((QcircleUploadReport.UploadReportObj)localObject).o = paramReport.fileSize;
    ((QcircleUploadReport.UploadReportObj)localObject).t = paramReport.startTime;
    ((QcircleUploadReport.UploadReportObj)localObject).u = paramReport.endTime;
    ((QcircleUploadReport.UploadReportObj)localObject).p = (paramReport.endTime - paramReport.startTime);
    StringBuilder localStringBuilder = ((QcircleUploadReport.UploadReportObj)localObject).r;
    if (paramReport.errMsg == null) {
      str = "";
    } else {
      str = paramReport.errMsg;
    }
    localStringBuilder.append(str);
    ((QcircleUploadReport.UploadReportObj)localObject).s = localExtendData;
    ((QcircleUploadReport.UploadReportObj)localObject).c = paramReport.entry;
    ((QcircleUploadReport.UploadReportObj)localObject).d = (paramReport.ctrlEnd - paramReport.ctrlStart);
    ((QcircleUploadReport.UploadReportObj)localObject).e = (paramReport.dataEnd - paramReport.dataStart);
    ((QcircleUploadReport.UploadReportObj)localObject).g = paramReport.reportType;
    ((QcircleUploadReport.UploadReportObj)localObject).h = paramReport.isIPV6;
    return localObject;
  }
  
  public void batchComplete()
  {
    QcirclrBusinessReport.a(0, 0);
    QcirclrBusinessReport.a(2, 0);
  }
  
  public void onUploadReport(Report paramReport)
  {
    QcirclrBusinessReport.a(a(paramReport), a(paramReport.uploadType), 0);
  }
  
  public void openSessionReport(int paramInt1, String paramString1, String paramString2, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.uploader.QcircleUploadReport
 * JD-Core Version:    0.7.0.1
 */