package com.tencent.mobileqq.apollo.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import ankx;
import ankz;
import bgua;
import bgyo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ApolloGameShare$2
  implements Runnable
{
  public ApolloGameShare$2(ankx paramankx, int paramInt) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/game/").append(ankx.a(this.this$0)).append("/inviteIcon.png");
    try
    {
      if (new File(((StringBuilder)localObject).toString()).exists()) {
        localObject = BitmapFactory.decodeFile(((StringBuilder)localObject).toString());
      } else {
        localObject = bgyo.b(BaseApplicationImpl.getApplication().getResources(), 2130838660);
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.e("ApolloGameShare", 1, "fail to invite wxFriend, oom happens, errInfo->" + localOutOfMemoryError.getMessage());
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloGameShare", 1, "fail to invite wxFriend, error happens, errInfo->" + localThrowable.getMessage());
      return;
    }
    Bitmap localBitmap;
    while (localBitmap != null)
    {
      localBitmap = bgua.a(localThrowable);
      ankx.a(this.this$0, String.valueOf(System.currentTimeMillis()));
      WXShareHelper.a().a(new ankz(this));
      WXShareHelper.a().a(ankx.a(this.this$0), ankx.b(this.this$0), localBitmap, ankx.c(this.this$0), ankx.d(this.this$0), this.a);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloGameShare.2
 * JD-Core Version:    0.7.0.1
 */