package com.tencent.mobileqq.apollo.utils;

import ajms;
import ajnn;
import ajnp;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import baui;
import baxi;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ApolloGameShare$2
  implements Runnable
{
  public ApolloGameShare$2(ajnn paramajnn, int paramInt) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(ajms.s).append(ajnn.a(this.this$0)).append("/inviteIcon.png");
    try
    {
      if (new File(((StringBuilder)localObject).toString()).exists()) {
        localObject = BitmapFactory.decodeFile(((StringBuilder)localObject).toString());
      } else {
        localObject = baxi.b(BaseApplicationImpl.getApplication().getResources(), 2130838438);
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
      localBitmap = baui.a(localThrowable);
      ajnn.a(this.this$0, String.valueOf(System.currentTimeMillis()));
      WXShareHelper.a().a(new ajnp(this));
      WXShareHelper.a().a(ajnn.a(this.this$0), ajnn.b(this.this$0), localBitmap, ajnn.c(this.this$0), ajnn.d(this.this$0), this.a);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloGameShare.2
 * JD-Core Version:    0.7.0.1
 */