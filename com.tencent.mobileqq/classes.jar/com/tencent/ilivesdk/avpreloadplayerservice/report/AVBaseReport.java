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
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("_dc=");
    ((StringBuilder)localObject2).append(Math.random());
    Object localObject3 = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject1 = (Map.Entry)((Iterator)localObject3).next();
      ((StringBuilder)localObject2).append("&");
      ((StringBuilder)localObject2).append((String)((Map.Entry)localObject1).getKey());
      ((StringBuilder)localObject2).append("=");
      if (((Map.Entry)localObject1).getValue() == null) {
        localObject1 = " ";
      } else {
        localObject1 = (String)((Map.Entry)localObject1).getValue();
      }
      ((StringBuilder)localObject2).append((String)localObject1);
    }
    Object localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("https://h.trace.qq.com/kv?");
    ((StringBuilder)localObject2).append((String)localObject1);
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = this.jdField_a_of_type_ComTencentFalcoBaseLibapiLogLogInterface;
    if (localObject2 != null)
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("AVReport | send=");
      ((StringBuilder)localObject3).append((String)localObject1);
      ((LogInterface)localObject2).d("AVReport", ((StringBuilder)localObject3).toString(), new Object[0]);
    }
    return localObject1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.avpreloadplayerservice.report.AVBaseReport
 * JD-Core Version:    0.7.0.1
 */