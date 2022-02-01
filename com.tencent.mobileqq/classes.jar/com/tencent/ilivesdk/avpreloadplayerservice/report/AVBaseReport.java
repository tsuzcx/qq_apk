package com.tencent.ilivesdk.avpreloadplayerservice.report;

import com.tencent.falco.base.libapi.http.HttpInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class AVBaseReport
  implements AVReportInterface
{
  HttpInterface jdField_a_of_type_ComTencentFalcoBaseLibapiHttpHttpInterface;
  private LogInterface jdField_a_of_type_ComTencentFalcoBaseLibapiLogLogInterface = null;
  protected Map<String, String> a;
  
  public AVBaseReport()
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  private String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("_dc=");
    localStringBuilder.append(Math.random());
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    if (localIterator.hasNext())
    {
      localObject = (Map.Entry)localIterator.next();
      localStringBuilder.append("&");
      localStringBuilder.append((String)((Map.Entry)localObject).getKey());
      localStringBuilder.append("=");
      if (((Map.Entry)localObject).getValue() == null) {}
      for (localObject = " ";; localObject = (String)((Map.Entry)localObject).getValue())
      {
        localStringBuilder.append((String)localObject);
        break;
      }
    }
    Object localObject = localStringBuilder.toString();
    localObject = "https://h.trace.qq.com/kv?" + (String)localObject;
    if (this.jdField_a_of_type_ComTencentFalcoBaseLibapiLogLogInterface != null) {
      this.jdField_a_of_type_ComTencentFalcoBaseLibapiLogLogInterface.d("AVReport", "AVReport | send=" + (String)localObject, new Object[0]);
    }
    return localObject;
  }
  
  public abstract void a();
  
  public void a(HttpInterface paramHttpInterface)
  {
    this.jdField_a_of_type_ComTencentFalcoBaseLibapiHttpHttpInterface = paramHttpInterface;
  }
  
  public void a(LogInterface paramLogInterface)
  {
    this.jdField_a_of_type_ComTencentFalcoBaseLibapiLogLogInterface = paramLogInterface;
    this.jdField_a_of_type_ComTencentFalcoBaseLibapiHttpHttpInterface.init(new AVBaseReport.1(this, paramLogInterface));
    a();
  }
  
  public void b()
  {
    a();
    this.jdField_a_of_type_ComTencentFalcoBaseLibapiHttpHttpInterface.post("https://h.trace.qq.com/kv", this.jdField_a_of_type_JavaUtilMap, new AVBaseReport.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.avpreloadplayerservice.report.AVBaseReport
 * JD-Core Version:    0.7.0.1
 */