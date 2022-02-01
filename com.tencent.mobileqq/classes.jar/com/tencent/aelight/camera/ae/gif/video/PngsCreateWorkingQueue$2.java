package com.tencent.aelight.camera.ae.gif.video;

import com.tencent.aelight.camera.aebase.Util;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;

class PngsCreateWorkingQueue$2
  implements PngsCreator.Callback
{
  PngsCreateWorkingQueue$2(PngsCreateWorkingQueue paramPngsCreateWorkingQueue, MaterialWrapper paramMaterialWrapper, String[] paramArrayOfString, Semaphore paramSemaphore) {}
  
  public void a(String paramString)
  {
    Object localObject1 = PngsCreateWorkingQueue.a();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("create pngs for material index = ");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentAelightCameraAeGifVideoMaterialWrapper.a);
    ((StringBuilder)localObject2).append(" end, pngDir = ");
    ((StringBuilder)localObject2).append(paramString);
    QLog.d((String)localObject1, 4, ((StringBuilder)localObject2).toString());
    this.jdField_a_of_type_ArrayOfJavaLangString[0] = paramString;
    localObject1 = new File(paramString).list();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append(File.separator);
    ((StringBuilder)localObject2).append("snapshot.png");
    localObject2 = ((StringBuilder)localObject2).toString();
    if (localObject1.length != 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(File.separator);
      localStringBuilder.append(localObject1[0]);
      Util.a(localStringBuilder.toString(), 320, 320, (String)localObject2);
    }
    PngsCreateWorkingQueue.a(this.jdField_a_of_type_ComTencentAelightCameraAeGifVideoPngsCreateWorkingQueue).c.add(localObject2);
    PngsCreateWorkingQueue.a(this.jdField_a_of_type_ComTencentAelightCameraAeGifVideoPngsCreateWorkingQueue).a.add(paramString);
    if ((this.jdField_a_of_type_ComTencentAelightCameraAeGifVideoMaterialWrapper.c != null) && (!this.jdField_a_of_type_ComTencentAelightCameraAeGifVideoMaterialWrapper.c.equals(""))) {
      PngsCreateWorkingQueue.a(this.jdField_a_of_type_ComTencentAelightCameraAeGifVideoPngsCreateWorkingQueue).b.add(this.jdField_a_of_type_ComTencentAelightCameraAeGifVideoMaterialWrapper.c);
    } else {
      PngsCreateWorkingQueue.a(this.jdField_a_of_type_ComTencentAelightCameraAeGifVideoPngsCreateWorkingQueue).b.add(this.jdField_a_of_type_ComTencentAelightCameraAeGifVideoMaterialWrapper.b);
    }
    PngsCreateWorkingQueue.a(this.jdField_a_of_type_ComTencentAelightCameraAeGifVideoPngsCreateWorkingQueue).d.add(Integer.valueOf(this.jdField_a_of_type_ComTencentAelightCameraAeGifVideoMaterialWrapper.a));
    this.jdField_a_of_type_JavaUtilConcurrentSemaphore.release();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.video.PngsCreateWorkingQueue.2
 * JD-Core Version:    0.7.0.1
 */