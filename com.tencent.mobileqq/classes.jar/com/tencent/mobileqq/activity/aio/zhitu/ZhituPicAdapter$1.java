package com.tencent.mobileqq.activity.aio.zhitu;

import aeor;
import aepg;
import aepi;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import awqx;
import bace;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity.sendPhotoTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ZhituPicAdapter$1
  implements Runnable
{
  public ZhituPicAdapter$1(aepg paramaepg, aepi paramaepi) {}
  
  public void run()
  {
    Object localObject1 = null;
    Object localObject3;
    if (!this.a.jdField_b_of_type_Boolean)
    {
      localObject3 = aeor.a(aepg.a(this.this$0)).a(this.a.jdField_a_of_type_JavaLangString, this.a.c);
      if ((this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof BitmapDrawable)) {
        localObject1 = ((BitmapDrawable)this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable).getBitmap();
      }
      if (localObject1 == null) {
        return;
      }
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
          boolean bool = bace.a((Bitmap)localObject1, ((File)localObject3).getAbsolutePath());
          if (!bool) {
            break;
          }
          localObject1 = localObject3;
          if (aeor.a(aepg.a(this.this$0)).a() != 7220) {
            break label320;
          }
          this.a.jdField_b_of_type_JavaLangString = ((File)localObject1).getAbsolutePath();
          aeor.a(aepg.a(this.this$0)).f(this.a);
          awqx.b(aepg.a(this.this$0), "dc00898", "", "", "0X8008C72", "0X8008C72", aeor.a(aeor.a(aepg.a(this.this$0)).a()), 0, "", "", "", "");
          return;
        }
        catch (IOException localIOException)
        {
          localIOException.printStackTrace();
          return;
        }
        catch (OutOfMemoryError localOutOfMemoryError1)
        {
          aeor.a(localOutOfMemoryError1);
          return;
        }
        if (this.a.jdField_b_of_type_JavaLangString == null) {
          try
          {
            Object localObject2 = aeor.a(aepg.a(this.this$0)).a(this.a);
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
              aeor.a(localOutOfMemoryError2);
              localFile = null;
            }
          }
        }
      }
      File localFile = aeor.a(aepg.a(this.this$0)).a(this.a.jdField_a_of_type_JavaLangString, this.a.c);
      bace.d(this.a.jdField_b_of_type_JavaLangString, localFile.getAbsolutePath());
      continue;
      label320:
      localObject3 = new Intent();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localFile.getAbsolutePath());
      ((Intent)localObject3).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
      ((Intent)localObject3).putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1044);
      ((Intent)localObject3).putExtra("uin", aepg.a(this.this$0).jdField_a_of_type_JavaLangString);
      ((Intent)localObject3).putExtra("uintype", aepg.a(this.this$0).jdField_a_of_type_Int);
      ((Intent)localObject3).putExtra("troop_uin", aepg.a(this.this$0).jdField_b_of_type_JavaLangString);
      ((Intent)localObject3).putExtra("PhotoConst.SEND_SIZE_SPEC", 0);
      ((Intent)localObject3).putExtra("send_in_background", true);
      ((Intent)localObject3).putExtra("PhotoConst.SINGLE_PHOTO_PATH", localArrayList);
      new SendPhotoActivity.sendPhotoTask(aepg.a(this.this$0), (Intent)localObject3).run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.zhitu.ZhituPicAdapter.1
 * JD-Core Version:    0.7.0.1
 */