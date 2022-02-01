package com.tencent.mobileqq.activity.aio.zhitu;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.SendPhotoTask;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

class ZhituPicAdapter$1
  implements Runnable
{
  ZhituPicAdapter$1(ZhituPicAdapter paramZhituPicAdapter, ZhituPicData paramZhituPicData) {}
  
  public void run()
  {
    Object localObject3;
    Object localObject2;
    if (!this.a.jdField_b_of_type_Boolean)
    {
      localObject3 = ZhituManager.a(ZhituPicAdapter.a(this.this$0)).a(this.a.jdField_a_of_type_JavaLangString, this.a.c);
      Object localObject1;
      if ((this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof BitmapDrawable)) {
        localObject1 = ((BitmapDrawable)this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable).getBitmap();
      } else {
        localObject1 = null;
      }
      if (localObject1 == null) {
        return;
      }
      try
      {
        if (!((File)localObject3).exists())
        {
          ((File)localObject3).getParentFile().mkdirs();
          ((File)localObject3).createNewFile();
        }
        boolean bool = FileUtils.saveBitmapToFile((Bitmap)localObject1, ((File)localObject3).getAbsolutePath());
        localObject1 = localObject3;
        if (bool) {
          break label229;
        }
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        ZhituManager.a(localOutOfMemoryError1);
        return;
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
        return;
      }
    }
    else if (this.a.jdField_b_of_type_JavaLangString == null)
    {
      try
      {
        String str = ZhituManager.a(ZhituPicAdapter.a(this.this$0)).a(this.a);
      }
      catch (OutOfMemoryError localOutOfMemoryError2)
      {
        QLog.e("ZhituManager", 1, "oom when save bitmap");
        ZhituManager.a(localOutOfMemoryError2);
        localObject2 = null;
      }
      if (localObject2 == null) {
        return;
      }
      localObject2 = new File((String)localObject2);
    }
    else
    {
      localObject2 = ZhituManager.a(ZhituPicAdapter.a(this.this$0)).a(this.a.jdField_a_of_type_JavaLangString, this.a.c);
      FileUtils.copyFile(this.a.jdField_b_of_type_JavaLangString, ((File)localObject2).getAbsolutePath());
    }
    label229:
    if (ZhituManager.a(ZhituPicAdapter.a(this.this$0)).a() == 7220)
    {
      this.a.jdField_b_of_type_JavaLangString = ((File)localObject2).getAbsolutePath();
      ZhituManager.a(ZhituPicAdapter.a(this.this$0)).f(this.a);
    }
    else
    {
      localObject3 = new Intent();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(((File)localObject2).getAbsolutePath());
      ((Intent)localObject3).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
      ((Intent)localObject3).putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1044);
      ((Intent)localObject3).putExtra("uin", ZhituPicAdapter.a(this.this$0).jdField_a_of_type_JavaLangString);
      ((Intent)localObject3).putExtra("uintype", ZhituPicAdapter.a(this.this$0).jdField_a_of_type_Int);
      ((Intent)localObject3).putExtra("troop_uin", ZhituPicAdapter.a(this.this$0).jdField_b_of_type_JavaLangString);
      ((Intent)localObject3).putExtra("PhotoConst.SEND_SIZE_SPEC", 0);
      ((Intent)localObject3).putExtra("send_in_background", true);
      ((Intent)localObject3).putExtra("PhotoConst.SINGLE_PHOTO_PATH", localArrayList);
      new SendPhotoTask(ZhituPicAdapter.a(this.this$0), (Intent)localObject3, null).run();
    }
    ReportController.b(ZhituPicAdapter.a(this.this$0), "dc00898", "", "", "0X8008C72", "0X8008C72", ZhituManager.a(ZhituManager.a(ZhituPicAdapter.a(this.this$0)).a()), 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.zhitu.ZhituPicAdapter.1
 * JD-Core Version:    0.7.0.1
 */