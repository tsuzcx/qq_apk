package com.tencent.mobileqq.apollo.api.player.impl;

import com.tencent.mobileqq.apollo.api.player.action.CMSAction;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class ApolloBrickPlayerImpl$BrickCMSPlayerListener$1
  implements Runnable
{
  ApolloBrickPlayerImpl$BrickCMSPlayerListener$1(ApolloBrickPlayerImpl.BrickCMSPlayerListener paramBrickCMSPlayerListener, byte[] paramArrayOfByte, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, CMSAction paramCMSAction) {}
  
  public void run()
  {
    Object localObject = null;
    try
    {
      byte[] arrayOfByte = (byte[])this.jdField_a_of_type_ArrayOfByte.clone();
      localObject = arrayOfByte;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        QLog.e("ApolloBrickPlayer", 1, "onRecordFrame error:", localOutOfMemoryError);
      }
      if ((ApolloBrickPlayerImpl.access$1400().containsKey(this.jdField_a_of_type_JavaLangString)) && (((FrameData)ApolloBrickPlayerImpl.access$1400().get(this.jdField_a_of_type_JavaLangString)).a() >= this.jdField_a_of_type_Int)) {
        break label104;
      }
      ApolloBrickPlayerImpl.access$1400().put(this.jdField_a_of_type_JavaLangString, new FrameData(this.jdField_a_of_type_Int, (byte[])localObject, this.b, this.c, this.d));
      label104:
      localObject = new ApolloBrickPlayerImpl.BrickCMSPlayerListener.1.1(this, (byte[])localObject);
      ApolloBrickPlayerImpl.BrickCMSPlayerListener.a(this.this$0, (Runnable)localObject);
    }
    if (localObject == null) {
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.player.impl.ApolloBrickPlayerImpl.BrickCMSPlayerListener.1
 * JD-Core Version:    0.7.0.1
 */