package com.tencent.mobileqq.apollo.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.troopshare.TroopShareUtility;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class ApolloGameShare$2
  implements Runnable
{
  ApolloGameShare$2(ApolloGameShare paramApolloGameShare, int paramInt) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/game/").append(ApolloGameShare.a(this.this$0)).append("/inviteIcon.png");
    try
    {
      if (new File(((StringBuilder)localObject).toString()).exists()) {
        localObject = BitmapFactory.decodeFile(((StringBuilder)localObject).toString());
      } else {
        localObject = BitmapManager.b(BaseApplicationImpl.getApplication().getResources(), 2130838728);
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
      localBitmap = TroopShareUtility.a(localThrowable);
      ApolloGameShare.a(this.this$0, String.valueOf(System.currentTimeMillis()));
      WXShareHelper.a().a(new ApolloGameShare.2.1(this));
      WXShareHelper.a().a(ApolloGameShare.a(this.this$0), ApolloGameShare.b(this.this$0), localBitmap, ApolloGameShare.c(this.this$0), ApolloGameShare.d(this.this$0), this.a);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloGameShare.2
 * JD-Core Version:    0.7.0.1
 */