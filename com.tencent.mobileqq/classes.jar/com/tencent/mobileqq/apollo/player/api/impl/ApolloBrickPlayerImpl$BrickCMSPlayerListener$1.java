package com.tencent.mobileqq.apollo.player.api.impl;

import com.tencent.mobileqq.apollo.player.FrameData;
import com.tencent.mobileqq.apollo.player.action.CMSAction;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class ApolloBrickPlayerImpl$BrickCMSPlayerListener$1
  implements Runnable
{
  ApolloBrickPlayerImpl$BrickCMSPlayerListener$1(ApolloBrickPlayerImpl.BrickCMSPlayerListener paramBrickCMSPlayerListener, byte[] paramArrayOfByte, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, CMSAction paramCMSAction) {}
  
  public void run()
  {
    try
    {
      byte[] arrayOfByte = (byte[])this.jdField_a_of_type_ArrayOfByte.clone();
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.e("[cmshow]ApolloBrickPlayer", 1, "onRecordFrame error:", localOutOfMemoryError);
      localObject = null;
    }
    if (localObject == null) {
      return;
    }
    if ((!ApolloBrickPlayerImpl.access$1200().containsKey(this.jdField_a_of_type_JavaLangString)) || (((FrameData)ApolloBrickPlayerImpl.access$1200().get(this.jdField_a_of_type_JavaLangString)).a() < this.jdField_a_of_type_Int)) {
      ApolloBrickPlayerImpl.access$1200().put(this.jdField_a_of_type_JavaLangString, new FrameData(this.jdField_a_of_type_Int, (byte[])localObject, this.b, this.c, this.d));
    }
    Object localObject = new ApolloBrickPlayerImpl.BrickCMSPlayerListener.1.1(this, (byte[])localObject);
    ApolloBrickPlayerImpl.BrickCMSPlayerListener.a(this.this$0, (Runnable)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.player.api.impl.ApolloBrickPlayerImpl.BrickCMSPlayerListener.1
 * JD-Core Version:    0.7.0.1
 */