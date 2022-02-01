package com.tencent.mobileqq.apollo.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import annv;
import anor;
import anot;
import bhbx;
import bhgm;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ApolloGameShare$2
  implements Runnable
{
  public ApolloGameShare$2(anor paramanor, int paramInt) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(annv.s).append(anor.a(this.this$0)).append("/inviteIcon.png");
    try
    {
      if (new File(((StringBuilder)localObject).toString()).exists()) {
        localObject = BitmapFactory.decodeFile(((StringBuilder)localObject).toString());
      } else {
        localObject = bhgm.b(BaseApplicationImpl.getApplication().getResources(), 2130838619);
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
      localBitmap = bhbx.a(localThrowable);
      anor.a(this.this$0, String.valueOf(System.currentTimeMillis()));
      WXShareHelper.a().a(new anot(this));
      WXShareHelper.a().a(anor.a(this.this$0), anor.b(this.this$0), localBitmap, anor.c(this.this$0), anor.d(this.this$0), this.a);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloGameShare.2
 * JD-Core Version:    0.7.0.1
 */