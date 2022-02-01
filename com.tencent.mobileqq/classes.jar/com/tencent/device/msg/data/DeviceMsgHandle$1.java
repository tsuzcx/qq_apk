package com.tencent.device.msg.data;

import android.os.Bundle;
import com.tencent.device.file.DeviceFileObserver;
import com.tencent.litetransfersdk.ActionInfo;
import com.tencent.litetransfersdk.Session;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class DeviceMsgHandle$1
  extends DeviceFileObserver
{
  DeviceMsgHandle$1(DeviceMsgHandle paramDeviceMsgHandle) {}
  
  private List<DeviceFileObserver> a(Session paramSession)
  {
    if ((paramSession != null) && (paramSession.actionInfo != null)) {
      paramSession = paramSession.actionInfo.strServiceName;
    } else {
      paramSession = "";
    }
    return a(paramSession);
  }
  
  private List<DeviceFileObserver> a(String paramString)
  {
    if (paramString == null) {
      paramString = "";
    }
    if (paramString != null) {
      return (List)this.a.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    }
    return null;
  }
  
  public void a(Bundle paramBundle)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(DeviceMsgHandle.jdField_a_of_type_JavaLangString, 4, "OnDataPointFileMsgProgress");
    }
    Object localObject = a("");
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((DeviceFileObserver)((Iterator)localObject).next()).a(paramBundle);
      }
    }
  }
  
  public void a(Session paramSession)
  {
    if (paramSession.isFileAssist) {
      return;
    }
    if (QLog.isDevelopLevel())
    {
      localObject = DeviceMsgHandle.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onServiceSessionNew:");
      localStringBuilder.append(paramSession.uSessionID);
      QLog.d((String)localObject, 4, localStringBuilder.toString());
    }
    Object localObject = a(paramSession);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((DeviceFileObserver)((Iterator)localObject).next()).a(paramSession);
      }
    }
  }
  
  public void a(Session paramSession, float paramFloat)
  {
    if (QLog.isDevelopLevel())
    {
      localObject = DeviceMsgHandle.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onServiceSessionProgress:");
      localStringBuilder.append(paramSession.uSessionID);
      QLog.d((String)localObject, 4, localStringBuilder.toString());
    }
    Object localObject = a(paramSession);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((DeviceFileObserver)((Iterator)localObject).next()).a(paramSession, paramFloat);
      }
    }
  }
  
  public void a(Session paramSession, boolean paramBoolean)
  {
    if (QLog.isDevelopLevel())
    {
      localObject = DeviceMsgHandle.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onServiceSessionComplete:");
      localStringBuilder.append(paramSession.uSessionID);
      QLog.d((String)localObject, 4, localStringBuilder.toString());
    }
    Object localObject = a(paramSession);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((DeviceFileObserver)((Iterator)localObject).next()).a(paramSession, paramBoolean);
      }
    }
  }
  
  public void b(Bundle paramBundle)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(DeviceMsgHandle.jdField_a_of_type_JavaLangString, 4, "OnDataPointFileMsgSendRet");
    }
    Object localObject = a("");
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((DeviceFileObserver)((Iterator)localObject).next()).b(paramBundle);
      }
    }
  }
  
  public void b(Session paramSession)
  {
    if (QLog.isDevelopLevel())
    {
      localObject = DeviceMsgHandle.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onServiceSessionStart:");
      localStringBuilder.append(paramSession.uSessionID);
      QLog.d((String)localObject, 4, localStringBuilder.toString());
    }
    Object localObject = a(paramSession);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((DeviceFileObserver)((Iterator)localObject).next()).b(paramSession);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.device.msg.data.DeviceMsgHandle.1
 * JD-Core Version:    0.7.0.1
 */