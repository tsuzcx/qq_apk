package com.tencent.mobileqq.activity.aio.zhitu;

import aezn;
import afac;
import afae;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import axqw;
import bbdj;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.SendPhotoTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ZhituPicAdapter$1
  implements Runnable
{
  public ZhituPicAdapter$1(afac paramafac, afae paramafae) {}
  
  public void run()
  {
    Object localObject3;
    if (!this.a.jdField_b_of_type_Boolean)
    {
      localObject3 = aezn.a(afac.a(this.this$0)).a(this.a.jdField_a_of_type_JavaLangString, this.a.c);
      if (!(this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof BitmapDrawable)) {
        break label462;
      }
    }
    File localFile;
    label318:
    label462:
    for (Object localObject1 = ((BitmapDrawable)this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable).getBitmap();; localFile = null)
    {
      if (localObject1 == null) {
        return;
      }
      for (;;)
      {
        for (;;)
        {
          try
          {
            if (!((File)localObject3).exists())
            {
              ((File)localObject3).getParentFile().mkdirs();
              ((File)localObject3).createNewFile();
            }
            boolean bool = bbdj.a((Bitmap)localObject1, ((File)localObject3).getAbsolutePath());
            if (!bool) {
              break;
            }
            localObject1 = localObject3;
            if (aezn.a(afac.a(this.this$0)).a() != 7220) {
              break label318;
            }
            this.a.jdField_b_of_type_JavaLangString = ((File)localObject1).getAbsolutePath();
            aezn.a(afac.a(this.this$0)).f(this.a);
            axqw.b(afac.a(this.this$0), "dc00898", "", "", "0X8008C72", "0X8008C72", aezn.a(aezn.a(afac.a(this.this$0)).a()), 0, "", "", "", "");
            return;
          }
          catch (IOException localIOException)
          {
            localIOException.printStackTrace();
            return;
          }
          catch (OutOfMemoryError localOutOfMemoryError1)
          {
            aezn.a(localOutOfMemoryError1);
            return;
          }
          if (this.a.jdField_b_of_type_JavaLangString == null) {
            try
            {
              Object localObject2 = aezn.a(afac.a(this.this$0)).a(this.a);
              if (localObject2 == null) {
                break;
              }
              localObject2 = new File((String)localObject2);
            }
            catch (OutOfMemoryError localOutOfMemoryError2)
            {
              for (;;)
              {
                QLog.e("ZhituManager", 1, "oom when save bitmap");
                aezn.a(localOutOfMemoryError2);
                localFile = null;
              }
            }
          }
        }
        localFile = aezn.a(afac.a(this.this$0)).a(this.a.jdField_a_of_type_JavaLangString, this.a.c);
        bbdj.d(this.a.jdField_b_of_type_JavaLangString, localFile.getAbsolutePath());
        continue;
        localObject3 = new Intent();
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(localFile.getAbsolutePath());
        ((Intent)localObject3).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
        ((Intent)localObject3).putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1044);
        ((Intent)localObject3).putExtra("uin", afac.a(this.this$0).jdField_a_of_type_JavaLangString);
        ((Intent)localObject3).putExtra("uintype", afac.a(this.this$0).jdField_a_of_type_Int);
        ((Intent)localObject3).putExtra("troop_uin", afac.a(this.this$0).jdField_b_of_type_JavaLangString);
        ((Intent)localObject3).putExtra("PhotoConst.SEND_SIZE_SPEC", 0);
        ((Intent)localObject3).putExtra("send_in_background", true);
        ((Intent)localObject3).putExtra("PhotoConst.SINGLE_PHOTO_PATH", localArrayList);
        new SendPhotoTask(afac.a(this.this$0), (Intent)localObject3, null).run();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.zhitu.ZhituPicAdapter.1
 * JD-Core Version:    0.7.0.1
 */