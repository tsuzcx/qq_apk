package com.tencent.mobileqq.apollo.process.data;

import akwd;
import akyc;
import akye;
import aliu;
import alud;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import bcxl;
import bdal;
import beae;
import beag;
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
  public CmGameCommonShare$4(akyc paramakyc, int paramInt) {}
  
  public void run()
  {
    if (TextUtils.isEmpty(akyc.b(this.this$0))) {
      akyc.a(this.this$0, "shareQRCode_default_v2.png");
    }
    Object localObject2;
    Object localObject1;
    if ((akyc.b(this.this$0).startsWith("http")) || (akyc.b(this.this$0).startsWith("https")))
    {
      localObject2 = new File(aliu.s + akyc.a(this.this$0) + File.separator + Utils.Crc64String(akyc.b(this.this$0)) + "_shareQRCode.png");
      localObject1 = localObject2;
      if (!((File)localObject2).exists())
      {
        beae localbeae = new beae(akyc.b(this.this$0), (File)localObject2);
        localbeae.p = false;
        localbeae.j = false;
        localbeae.n = true;
        localbeae.s = false;
        localbeae.q = true;
        localbeae.r = true;
        localbeae.b = true;
        localbeae.f = "apollo_res";
        localObject1 = localObject2;
        if (beag.a(localbeae, akwd.a().getCurrentAccountUin(), BaseApplicationImpl.getContext()) != 0) {
          ApolloItemBuilder.a(alud.a(2131702449), 1, BaseApplicationImpl.getContext());
        }
      }
    }
    else
    {
      localObject1 = new File(akyc.c(this.this$0));
    }
    for (;;)
    {
      try
      {
        if ((!((File)localObject1).isFile()) || (!((File)localObject1).exists()))
        {
          QLog.e("apollo_cmGame_CmGameCommonShare", 1, new Object[] { "shareResult2WXFriendOrCircle sharefile is not exsit:", ((File)localObject1).getAbsolutePath() });
          localObject1 = new File(akyc.a(this.this$0, akyc.a(this.this$0)));
          if (!((File)localObject1).exists())
          {
            localObject1 = new File(akyc.b(this.this$0, akyc.a(this.this$0)));
            if (((File)localObject1).exists())
            {
              localObject2 = BitmapFactory.decodeFile(((File)localObject1).getAbsolutePath());
              if (localObject2 == null) {
                break;
              }
              localObject2 = bcxl.a((Bitmap)localObject2);
              WXShareHelper.a().a(new akye(this));
              WXShareHelper.a().a(((File)localObject1).getAbsolutePath(), (Bitmap)localObject2, this.a);
              return;
            }
            localObject2 = bdal.b(BaseApplicationImpl.getApplication().getResources(), 2130838499);
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