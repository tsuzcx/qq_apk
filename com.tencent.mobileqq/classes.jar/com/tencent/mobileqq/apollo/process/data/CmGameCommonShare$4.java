package com.tencent.mobileqq.apollo.process.data;

import akro;
import aktn;
import aktp;
import alef;
import alpo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import bctc;
import bcwc;
import bdvv;
import bdvx;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class CmGameCommonShare$4
  implements Runnable
{
  public CmGameCommonShare$4(aktn paramaktn, int paramInt) {}
  
  public void run()
  {
    if (TextUtils.isEmpty(aktn.b(this.this$0))) {
      aktn.a(this.this$0, "shareQRCode_default_v2.png");
    }
    Object localObject2;
    Object localObject1;
    if ((aktn.b(this.this$0).startsWith("http")) || (aktn.b(this.this$0).startsWith("https")))
    {
      localObject2 = new File(alef.s + aktn.a(this.this$0) + File.separator + Utils.Crc64String(aktn.b(this.this$0)) + "_shareQRCode.png");
      localObject1 = localObject2;
      if (!((File)localObject2).exists())
      {
        bdvv localbdvv = new bdvv(aktn.b(this.this$0), (File)localObject2);
        localbdvv.p = false;
        localbdvv.j = false;
        localbdvv.n = true;
        localbdvv.s = false;
        localbdvv.q = true;
        localbdvv.r = true;
        localbdvv.b = true;
        localbdvv.f = "apollo_res";
        localObject1 = localObject2;
        if (bdvx.a(localbdvv, akro.a().getCurrentAccountUin(), BaseApplicationImpl.getContext()) != 0) {
          ApolloItemBuilder.a(alpo.a(2131702437), 1, BaseApplicationImpl.getContext());
        }
      }
    }
    else
    {
      localObject1 = new File(aktn.c(this.this$0));
    }
    for (;;)
    {
      try
      {
        if ((!((File)localObject1).isFile()) || (!((File)localObject1).exists()))
        {
          QLog.e("apollo_cmGame_CmGameCommonShare", 1, new Object[] { "shareResult2WXFriendOrCircle sharefile is not exsit:", ((File)localObject1).getAbsolutePath() });
          localObject1 = new File(aktn.a(this.this$0, aktn.a(this.this$0)));
          if (!((File)localObject1).exists())
          {
            localObject1 = new File(aktn.b(this.this$0, aktn.a(this.this$0)));
            if (((File)localObject1).exists())
            {
              localObject2 = BitmapFactory.decodeFile(((File)localObject1).getAbsolutePath());
              if (localObject2 == null) {
                break;
              }
              localObject2 = bctc.a((Bitmap)localObject2);
              WXShareHelper.a().a(new aktp(this));
              WXShareHelper.a().a(((File)localObject1).getAbsolutePath(), (Bitmap)localObject2, this.a);
              return;
            }
            localObject2 = bcwc.b(BaseApplicationImpl.getApplication().getResources(), 2130838498);
            continue;
          }
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        QLog.e("apollo_cmGame_CmGameCommonShare", 1, "fail to invite wxFriend, oom happens, errInfo->" + localOutOfMemoryError.getMessage());
        return;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("apollo_cmGame_CmGameCommonShare", 1, "fail to invite wxFriend, error happens, errInfo->" + localThrowable.getMessage());
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.data.CmGameCommonShare.4
 * JD-Core Version:    0.7.0.1
 */