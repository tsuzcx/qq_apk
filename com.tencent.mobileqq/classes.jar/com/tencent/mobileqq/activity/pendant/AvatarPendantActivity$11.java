package com.tencent.mobileqq.activity.pendant;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicBoolean;

class AvatarPendantActivity$11
  implements Runnable
{
  AvatarPendantActivity$11(AvatarPendantActivity paramAvatarPendantActivity) {}
  
  public void run()
  {
    boolean bool = FaceUtil.b();
    Object localObject1 = null;
    Object localObject4 = null;
    Object localObject3;
    Object localObject2;
    if (bool) {
      try
      {
        localObject1 = FaceUtil.c();
        Object localObject5 = new File((String)localObject1);
        localObject3 = new BitmapFactory.Options();
        localObject5 = new BufferedInputStream(new FileInputStream((File)localObject5));
        if (this.this$0.ai.get()) {
          ((BitmapFactory.Options)localObject3).inSampleSize = ((int)ImageUtil.a((InputStream)localObject5, this.this$0.D.getWidth(), this.this$0.D.getHeight()));
        } else {
          ((BitmapFactory.Options)localObject3).inSampleSize = ((int)ImageUtil.a((InputStream)localObject5, 120, 120));
        }
        ((BufferedInputStream)localObject5).close();
        localObject3 = BitmapManager.a((String)localObject1, (BitmapFactory.Options)localObject3);
        localObject1 = localObject3;
        if (localObject3 != null) {
          try
          {
            localObject1 = this.this$0.app;
            localObject1 = QQAppInterface.getCircleFaceBitmap((Bitmap)localObject3, ((Bitmap)localObject3).getWidth(), ((Bitmap)localObject3).getHeight());
          }
          catch (Exception localException2) {}
        }
      }
      catch (Exception localException1)
      {
        localObject3 = localException2;
        Exception localException3 = localException1;
        localObject2 = localObject3;
        if (QLog.isColorLevel())
        {
          QLog.d("AvatarPendantActivity", 2, localException3.toString());
          localObject2 = localObject3;
        }
      }
    }
    if (localObject2 != null)
    {
      this.this$0.runOnUiThread(new AvatarPendantActivity.11.1(this, localObject2));
    }
    else
    {
      localObject3 = this.this$0;
      AvatarPendantActivity.a((AvatarPendantActivity)localObject3, ((AvatarPendantActivity)localObject3).L.uin);
    }
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("AvatarPendantActivity decode Avatar, bitmap is null:");
      if (localObject2 == null) {
        bool = true;
      } else {
        bool = false;
      }
      ((StringBuilder)localObject3).append(bool);
      QLog.d("Q.dynamicAvatar", 2, ((StringBuilder)localObject3).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.pendant.AvatarPendantActivity.11
 * JD-Core Version:    0.7.0.1
 */