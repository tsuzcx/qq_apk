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
    Object localObject1 = PngsCreateWorkingQueue.b();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("create pngs for material index = ");
    ((StringBuilder)localObject2).append(this.a.a);
    ((StringBuilder)localObject2).append(" end, pngDir = ");
    ((StringBuilder)localObject2).append(paramString);
    QLog.d((String)localObject1, 4, ((StringBuilder)localObject2).toString());
    this.b[0] = paramString;
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
    PngsCreateWorkingQueue.a(this.d).c.add(localObject2);
    PngsCreateWorkingQueue.a(this.d).a.add(paramString);
    if ((this.a.d != null) && (!this.a.d.equals(""))) {
      PngsCreateWorkingQueue.a(this.d).b.add(this.a.d);
    } else {
      PngsCreateWorkingQueue.a(this.d).b.add(this.a.c);
    }
    PngsCreateWorkingQueue.a(this.d).d.add(Integer.valueOf(this.a.a));
    this.c.release();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.video.PngsCreateWorkingQueue.2
 * JD-Core Version:    0.7.0.1
 */