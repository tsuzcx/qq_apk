package com.tencent.mobileqq.apollo.utils;

import aiys;
import aizn;
import aizp;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import azsq;
import azvq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ApolloGameShare$2
  implements Runnable
{
  public ApolloGameShare$2(aizn paramaizn, int paramInt) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(aiys.s).append(aizn.a(this.this$0)).append("/inviteIcon.png");
    try
    {
      if (new File(((StringBuilder)localObject).toString()).exists()) {
        localObject = BitmapFactory.decodeFile(((StringBuilder)localObject).toString());
      } else {
        localObject = azvq.b(BaseApplicationImpl.getApplication().getResources(), 2130838430);
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
      localBitmap = azsq.a(localThrowable);
      aizn.a(this.this$0, String.valueOf(System.currentTimeMillis()));
      WXShareHelper.a().a(new aizp(this));
      WXShareHelper.a().a(aizn.a(this.this$0), aizn.b(this.this$0), localBitmap, aizn.c(this.this$0), aizn.d(this.this$0), this.a);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloGameShare.2
 * JD-Core Version:    0.7.0.1
 */