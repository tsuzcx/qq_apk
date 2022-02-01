package com.tencent.falco.base.datareport;

import android.text.TextUtils;
import com.tencent.falco.base.libapi.datareport.DataReportInterface;
import com.tencent.falco.base.libapi.datareport.QualityReportTask;
import java.util.HashMap;
import java.util.Map;

public class QualityReportTaskImpl
  implements QualityReportTask
{
  private static final boolean DEBUG = true;
  private static final String TAG = "QualityReportTaskImpl";
  private boolean isRealTime = false;
  String mActType;
  DataReportService mDataReportInterface;
  private int mQualityType = 1;
  Map<String, String> map = new HashMap();
  
  public QualityReportTask addKeyValue(String paramString, double paramDouble)
  {
    this.map.put(paramString, String.valueOf(paramDouble));
    return this;
  }
  
  public QualityReportTask addKeyValue(String paramString, int paramInt)
  {
    this.map.put(paramString, String.valueOf(paramInt));
    return this;
  }
  
  public QualityReportTask addKeyValue(String paramString, long paramLong)
  {
    this.map.put(paramString, String.valueOf(paramLong));
    return this;
  }
  
  public QualityReportTask addKeyValue(String paramString1, String paramString2)
  {
    this.map.put(paramString1, paramString2);
    return this;
  }
  
  public void send()
  {
    if (TextUtils.isEmpty(this.mActType)) {
      throw new NullPointerException("缺少上报基础字段，请检查 actType以及他们的描述");
    }
    if (this.mQualityType == 2) {
      this.mDataReportInterface.reportAudienceQualityEvent(this.mActType, this.map, this.isRealTime);
    }
    do
    {
      return;
      if (this.mQualityType == 1)
      {
        this.mDataReportInterface.reportAnchorQualityEvent(this.mActType, this.map, this.isRealTime);
        return;
      }
    } while (this.mQualityType != 3);
    this.mDataReportInterface.reportQualityEvent(this.map, this.isRealTime);
  }
  
  public QualityReportTask setActType(String paramString)
  {
    this.mActType = paramString;
    this.map.put("act_type", paramString);
    return this;
  }
  
  public QualityReportTask setActTypeDesc(String paramString)
  {
    this.map.put("act_type_desc", paramString);
    return this;
  }
  
  public void setDataReportService(DataReportInterface paramDataReportInterface)
  {
    this.mDataReportInterface = ((DataReportService)paramDataReportInterface);
  }
  
  public QualityReportTask setModule(String paramString)
  {
    this.map.put("page_module", paramString);
    return this;
  }
  
  public QualityReportTask setModuleDes(String paramString)
  {
    this.map.put("page_module_desc", paramString);
    return this;
  }
  
  public QualityReportTask setPage(String paramString)
  {
    this.map.put("page", paramString);
    return this;
  }
  
  public QualityReportTask setPageDes(String paramString)
  {
    this.map.put("page_desc", paramString);
    return this;
  }
  
  public void setQualityType(int paramInt)
  {
    this.mQualityType = paramInt;
  }
  
  public QualityReportTask setRealTimeUpload(boolean paramBoolean)
  {
    this.isRealTime = paramBoolean;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.base.datareport.QualityReportTaskImpl
 * JD-Core Version:    0.7.0.1
 */