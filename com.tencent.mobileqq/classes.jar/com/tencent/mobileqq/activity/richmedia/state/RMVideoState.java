package com.tencent.mobileqq.activity.richmedia.state;

import com.tencent.maxvideo.common.MessageStruct;
import com.tencent.maxvideo.mediadevice.AVCodec.AVCodecCallback;
import com.tencent.mobileqq.shortvideo.common.TCTimer.TCTimerCallback;
import com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraControl.CustomSize;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy.CameraPreviewObservable;
import com.tencent.qphone.base.util.QLog;

public abstract class RMVideoState
{
  public abstract void a();
  
  public void a(AVCodec.AVCodecCallback paramAVCodecCallback, MessageStruct paramMessageStruct) {}
  
  public void a(TCTimer.TCTimerCallback paramTCTimerCallback, boolean paramBoolean, int paramInt1, int paramInt2) {}
  
  public void a(Object paramObject, int paramInt, Object... paramVarArgs)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[@] notify called eventId=");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("RMVideoState", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = RMVideoStateMgr.a();
    if ((paramObject instanceof AudioCapture))
    {
      if (paramInt != 9) {
        return;
      }
      ((RMVideoStateMgr)localObject).i();
      return;
    }
    if ((paramObject instanceof CameraProxy.CameraPreviewObservable))
    {
      paramObject = new StringBuilder();
      paramObject.append(" notify EVENT_SET_CAMERA_PARAM eventId");
      paramObject.append(paramInt);
      paramObject.append(", rmStateMgr:");
      paramObject.append(localObject);
      QLog.d("faceuu", 2, paramObject.toString());
      if (localObject != null)
      {
        if (paramInt != 2)
        {
          if (paramInt != 10) {
            return;
          }
          if (QLog.isColorLevel())
          {
            paramObject = new StringBuilder();
            paramObject.append("RMVideoState viewST:");
            paramObject.append(((RMVideoStateMgr)localObject).a);
            QLog.d("faceuu", 2, paramObject.toString());
          }
          if (((RMVideoStateMgr)localObject).a != null) {
            ((RMVideoStateMgr)localObject).a.i();
          }
        }
        else if ((paramVarArgs != null) && (((RMVideoStateMgr)localObject).a != null))
        {
          if ((paramVarArgs[0] instanceof CameraControl.CustomSize))
          {
            paramObject = (CameraControl.CustomSize)paramVarArgs[0];
            try
            {
              ((RMVideoStateMgr)localObject).a.a(paramObject.a, paramObject.b);
              QLog.d("RMVideoState", 2, "[@] EVENT_SET_CAMERA_PARAM[success]");
              return;
            }
            catch (NullPointerException paramObject)
            {
              paramObject.printStackTrace();
              if (localObject == null) {
                return;
              }
            }
            paramObject = new StringBuilder();
            paramObject.append("[@] EVENT_SET_CAMERA_PARAM:rmStateMgr=");
            paramObject.append(localObject);
            paramObject.append(" viewST=");
            paramObject.append(((RMVideoStateMgr)localObject).a);
            QLog.d("RMVideoState", 2, paramObject.toString());
          }
          else
          {
            paramObject = new StringBuilder();
            paramObject.append("[@] EVENT_SET_CAMERA_PARAM: no CustomSize obj[0]=");
            paramObject.append(paramVarArgs[0]);
            QLog.d("RMVideoState", 2, paramObject.toString());
          }
        }
        else
        {
          paramObject = new StringBuilder();
          paramObject.append("[@] EVENT_SET_CAMERA_PARAM[2]:obj=");
          paramObject.append(paramVarArgs);
          QLog.d("RMVideoState", 2, paramObject.toString());
          if (localObject != null)
          {
            paramObject = new StringBuilder();
            paramObject.append("[@] EVENT_SET_CAMERA_PARAM[2]:viewST=");
            paramObject.append(((RMVideoStateMgr)localObject).a);
            QLog.d("RMVideoState", 2, paramObject.toString());
          }
        }
      }
      else {
        QLog.d("faceuu", 2, " notify EVENT_SET_CAMERA_PARAM  rmStateMgr==null");
      }
    }
  }
  
  public void a(boolean paramBoolean) {}
  
  public abstract void b();
  
  public void f() {}
  
  public void g() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.state.RMVideoState
 * JD-Core Version:    0.7.0.1
 */