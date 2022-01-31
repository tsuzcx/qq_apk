package com.tencent.mobileqq.arcard;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.ar.arcloud.pb.ARRelationShipListPb.RspBody;
import com.tencent.mobileqq.ar.arcloud.pb.ARRelationShipSendVideoPb.RspBody;
import com.tencent.qphone.base.util.QLog;

public class ARCardObserver
  implements BusinessObserver
{
  public void a(int paramInt, ARRelationShipListPb.RspBody paramRspBody) {}
  
  public void a(int paramInt, ARRelationShipSendVideoPb.RspBody paramRspBody) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARRelationShipHandler", 2, "type=" + paramInt + ", isSuccess=" + paramBoolean);
    }
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      paramObject = (Object[])paramObject;
      paramInt = ((Integer)paramObject[0]).intValue();
      try
      {
        a(paramInt, (ARRelationShipListPb.RspBody)paramObject[1]);
        return;
      }
      catch (Exception paramObject)
      {
        a(paramInt, null);
        return;
      }
    }
    paramObject = (Object[])paramObject;
    paramInt = ((Integer)paramObject[0]).intValue();
    try
    {
      a(paramInt, (ARRelationShipSendVideoPb.RspBody)paramObject[1]);
      return;
    }
    catch (Exception paramObject)
    {
      a(paramInt, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.arcard.ARCardObserver
 * JD-Core Version:    0.7.0.1
 */