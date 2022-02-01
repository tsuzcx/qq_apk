package com.tencent.falco.base.datareport;

import android.text.TextUtils;
import com.tencent.falco.base.libapi.datareport.DataReportInterface;
import com.tencent.falco.base.libapi.datareport.ReportTask;
import java.util.HashMap;
import java.util.Map;

public class ReportTaskImpl
  implements ReportTask
{
  private static final boolean DEBUG = true;
  private static final String TAG = "ReportTaskImpl";
  String mActType;
  DataReportInterface mDataReportInterface;
  String mModule;
  String mPage;
  Map<String, String> map = new HashMap();
  boolean realTimeEvent = false;
  
  public ReportTask addKeyValue(String paramString, double paramDouble)
  {
    this.map.put(paramString, String.valueOf(paramDouble));
    return this;
  }
  
  public ReportTask addKeyValue(String paramString, int paramInt)
  {
    this.map.put(paramString, String.valueOf(paramInt));
    return this;
  }
  
  public ReportTask addKeyValue(String paramString, long paramLong)
  {
    this.map.put(paramString, String.valueOf(paramLong));
    return this;
  }
  
  public ReportTask addKeyValue(String paramString1, String paramString2)
  {
    this.map.put(paramString1, paramString2);
    return this;
  }
  
  public void send()
  {
    String str = this.mActType + "#" + this.mPage + "#" + this.mModule;
    if ((TextUtils.isEmpty(this.mActType)) || (TextUtils.isEmpty(this.mPage)) || (TextUtils.isEmpty(this.mModule)) || (TextUtils.isEmpty((CharSequence)this.map.get("page_desc"))) || (TextUtils.isEmpty((CharSequence)this.map.get("page_module_desc"))) || (TextUtils.isEmpty((CharSequence)this.map.get("act_type_desc")))) {
      throw new NullPointerException("缺少上报基础字段，请检查 page,module,actType以及他们的描述");
    }
    this.mDataReportInterface.reportEvent(str, this.map, this.realTimeEvent);
  }
  
  public ReportTask setActType(String paramString)
  {
    this.mActType = paramString;
    this.map.put("act_type", paramString);
    return this;
  }
  
  public ReportTask setActTypeDesc(String paramString)
  {
    this.map.put("act_type_desc", paramString);
    return this;
  }
  
  public ReportTask setCommonet(String paramString)
  {
    this.map.put("report_commoent", paramString);
    return this;
  }
  
  public void setDataReportService(DataReportInterface paramDataReportInterface)
  {
    this.mDataReportInterface = paramDataReportInterface;
  }
  
  public ReportTask setModule(String paramString)
  {
    this.mModule = paramString;
    this.map.put("page_module", paramString);
    return this;
  }
  
  public ReportTask setModuleDesc(String paramString)
  {
    this.map.put("page_module_desc", paramString);
    return this;
  }
  
  public ReportTask setPage(String paramString)
  {
    this.mPage = paramString;
    this.map.put("page", paramString);
    return this;
  }
  
  public ReportTask setPageDesc(String paramString)
  {
    this.map.put("page_desc", paramString);
    return this;
  }
  
  public ReportTask setRealTimeUpload(boolean paramBoolean)
  {
    this.realTimeEvent = paramBoolean;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.base.datareport.ReportTaskImpl
 * JD-Core Version:    0.7.0.1
 */