package com.tencent.device.file;

import android.os.Bundle;
import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.MessageRecord;

public class DeviceFileObserver
  implements BusinessObserver
{
  public void a(Bundle paramBundle) {}
  
  public void a(Session paramSession) {}
  
  public void a(Session paramSession, float paramFloat) {}
  
  public void a(Session paramSession, boolean paramBoolean) {}
  
  public void a(MessageRecord paramMessageRecord, float paramFloat) {}
  
  public void a(MessageRecord paramMessageRecord, Boolean paramBoolean) {}
  
  public void b(Bundle paramBundle) {}
  
  public void b(Session paramSession) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    switch (paramInt)
    {
    default: 
    case 105: 
      paramObject = (Bundle)paramObject;
      if (paramObject != null)
      {
        b(paramObject);
        return;
      }
      break;
    case 104: 
      paramObject = (Bundle)paramObject;
      if (paramObject != null)
      {
        a(paramObject);
        return;
      }
      break;
    case 103: 
      paramObject = (Session)paramObject;
      if (paramObject != null)
      {
        a(paramObject, paramBoolean);
        return;
      }
      break;
    case 102: 
      paramObject = (Object[])paramObject;
      if (paramObject.length <= 1) {
        return;
      }
      Session localSession = (Session)paramObject[0];
      if (localSession != null)
      {
        a(localSession, ((Float)paramObject[1]).floatValue());
        return;
      }
      break;
    case 101: 
      paramObject = (Session)paramObject;
      if (paramObject != null)
      {
        b(paramObject);
        return;
      }
      break;
    case 100: 
      paramObject = (Session)paramObject;
      if (paramObject != null) {
        a(paramObject);
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.file.DeviceFileObserver
 * JD-Core Version:    0.7.0.1
 */