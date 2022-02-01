package com.tencent.mobileqq.activity.aio.zhitu;

import aioi;
import aioz;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import bdla;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.photo.SendPhotoTask;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

class ZhituPanelView$1
  implements Runnable
{
  ZhituPanelView$1(ZhituPanelView paramZhituPanelView, aioz paramaioz) {}
  
  public void run()
  {
    Object localObject3;
    if (!this.a.jdField_b_of_type_Boolean)
    {
      localObject3 = aioi.a(this.this$0.a.app).a(this.a.jdField_a_of_type_JavaLangString, this.a.c);
      if (!(this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof BitmapDrawable)) {
        break label496;
      }
    }
    File localFile;
    label340:
    label496:
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
            boolean bool = FileUtils.saveBitmapToFile((Bitmap)localObject1, ((File)localObject3).getAbsolutePath());
            if (!bool) {
              break;
            }
            localObject1 = localObject3;
            if (aioi.a(this.this$0.a.app).a() != 7220) {
              break label340;
            }
            this.a.jdField_b_of_type_JavaLangString = ((File)localObject1).getAbsolutePath();
            aioi.a(this.this$0.a.app).f(this.a);
            bdla.b(this.this$0.a.app, "dc00898", "", "", "0X8008C72", "0X8008C72", aioi.a(aioi.a(this.this$0.a.app).a()), 0, "", "", "", "");
            return;
          }
          catch (IOException localIOException)
          {
            localIOException.printStackTrace();
            return;
          }
          catch (OutOfMemoryError localOutOfMemoryError1)
          {
            aioi.a(localOutOfMemoryError1);
            return;
          }
          if (this.a.jdField_b_of_type_JavaLangString == null) {
            try
            {
              Object localObject2 = aioi.a(this.this$0.a.app).a(this.a);
              if (localObject2 == null) {
                break;
              }
              localObject2 = new File((String)localObject2);
            }
            catch (OutOfMemoryError localOutOfMemoryError2)
            {
              for (;;)
              {
                QLog.e(ZhituPanelView.b(), 1, "oom when save bitmap");
                aioi.a(localOutOfMemoryError2);
                localFile = null;
              }
            }
          }
        }
        localFile = aioi.a(this.this$0.a.app).a(this.a.jdField_a_of_type_JavaLangString, this.a.c);
        FileUtils.copyFile(this.a.jdField_b_of_type_JavaLangString, localFile.getAbsolutePath());
        continue;
        localObject3 = new Intent();
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(localFile.getAbsolutePath());
        ((Intent)localObject3).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
        ((Intent)localObject3).putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1049);
        ((Intent)localObject3).putExtra("uin", this.this$0.a.sessionInfo.curFriendUin);
        ((Intent)localObject3).putExtra("uintype", this.this$0.a.sessionInfo.curType);
        ((Intent)localObject3).putExtra("troop_uin", this.this$0.a.sessionInfo.troopUin);
        ((Intent)localObject3).putExtra("PhotoConst.SEND_SIZE_SPEC", 0);
        ((Intent)localObject3).putExtra("send_in_background", true);
        ((Intent)localObject3).putExtra("PhotoConst.SINGLE_PHOTO_PATH", localArrayList);
        new SendPhotoTask(this.this$0.a.getActivity(), (Intent)localObject3, null).run();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.zhitu.ZhituPanelView.1
 * JD-Core Version:    0.7.0.1
 */