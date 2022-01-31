package com.tencent.mobileqq.armap.map;

import com.tencent.mobileqq.armap.ARGLSurfaceView;
import com.tencent.mobileqq.armap.ARMapActivity;
import com.tencent.mobileqq.armap.ArMapObserver;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class MapEngineCallback$1
  extends ArMapObserver
{
  MapEngineCallback$1(MapEngineCallback paramMapEngineCallback) {}
  
  public void onGetC2CPOIList(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MapEngineCallback", 2, "onGetC2CPOIList isSuccess:" + paramBoolean + ",data = " + paramObject);
    }
    if (paramObject != null)
    {
      paramObject = (Object[])paramObject;
      if (paramObject.length < 7) {}
    }
    try
    {
      ((Integer)paramObject[0]).intValue();
      byte[] arrayOfByte = (byte[])paramObject[1];
      long l1 = ((Long)paramObject[2]).longValue();
      long l2 = ((Long)paramObject[3]).longValue();
      ((Boolean)paramObject[4]).booleanValue();
      long l3 = ((Long)paramObject[6]).longValue();
      long l4 = this.this$0.mActivity.a.getEngineHandler();
      if (QLog.isColorLevel()) {
        QLog.d("MapEngineCallback", 2, "onGetC2CPOIList ,curNativeGLSurfaceViewContext  = " + l4 + ",nativeGLSurfaceViewContext = " + l3);
      }
      if ((l3 == l4) && (this.this$0.mActivity != null) && (this.this$0.mActivity.a != null) && (l2 != 0L)) {
        this.this$0.mActivity.a.queueEvent(new MapEngineCallback.1.2(this, paramBoolean, arrayOfByte, l1, l2));
      }
      return;
    }
    catch (Exception paramObject)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("MapEngineCallback", 2, "onGetC2CPOIList exception", paramObject);
    }
  }
  
  public void onGetPOIList(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MapEngineCallback", 2, "onGetPOIList isSuccess:" + paramBoolean + ",data = " + paramObject);
    }
    if (paramObject != null)
    {
      paramObject = (Object[])paramObject;
      if (paramObject.length >= 7) {
        try
        {
          ((Integer)paramObject[0]).intValue();
          byte[] arrayOfByte = (byte[])paramObject[1];
          long l1 = ((Long)paramObject[2]).longValue();
          long l2 = ((Long)paramObject[3]).longValue();
          long l3 = ((Long)paramObject[6]).longValue();
          ((Boolean)paramObject[4]).booleanValue();
          if ((this.this$0.mActivity != null) && (this.this$0.mActivity.a != null) && (l2 != 0L))
          {
            long l4 = this.this$0.mActivity.a.getEngineHandler();
            if (QLog.isColorLevel()) {
              QLog.d("MapEngineCallback", 2, "onGetPOIList ,curNativeGLSurfaceViewContext  = " + l4 + ",nativeGLSurfaceViewContext = " + l3);
            }
            if (l3 == l4)
            {
              this.this$0.mActivity.a.queueEvent(new MapEngineCallback.1.1(this, paramBoolean, arrayOfByte, l1, l2));
              return;
            }
            QLog.d("MapEngineCallback", 1, "onGetPOIList ,different NativeGLSurfaceViewContext ,do not updatepoilist");
            StatisticCollector.a(BaseApplication.getContext()).a(null, "actARMapDifferentInstanc", false, 0L, 0L, null, "", false);
            return;
          }
        }
        catch (Exception paramObject)
        {
          if (QLog.isColorLevel()) {
            QLog.d("MapEngineCallback", 2, "onGetPOIList exception", paramObject);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.map.MapEngineCallback.1
 * JD-Core Version:    0.7.0.1
 */