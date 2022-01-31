package com.tencent.mobileqq.apollo.process.data;

import aing;
import aipf;
import aiph;
import aiys;
import ajjy;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import azsq;
import azvq;
import batm;
import bato;
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
  public CmGameCommonShare$4(aipf paramaipf, int paramInt) {}
  
  public void run()
  {
    if (TextUtils.isEmpty(aipf.b(this.this$0))) {
      aipf.a(this.this$0, "shareQRCode_default_v2.png");
    }
    Object localObject2;
    Object localObject1;
    if ((aipf.b(this.this$0).startsWith("http")) || (aipf.b(this.this$0).startsWith("https")))
    {
      localObject2 = new File(aiys.s + aipf.a(this.this$0) + File.separator + Utils.Crc64String(aipf.b(this.this$0)) + "_shareQRCode.png");
      localObject1 = localObject2;
      if (!((File)localObject2).exists())
      {
        batm localbatm = new batm(aipf.b(this.this$0), (File)localObject2);
        localbatm.p = false;
        localbatm.j = false;
        localbatm.n = true;
        localbatm.s = false;
        localbatm.q = true;
        localbatm.r = true;
        localbatm.b = true;
        localbatm.f = "apollo_res";
        localObject1 = localObject2;
        if (bato.a(localbatm, aing.a().getCurrentAccountUin(), BaseApplicationImpl.getContext()) != 0) {
          ApolloItemBuilder.a(ajjy.a(2131636270), 1, BaseApplicationImpl.getContext());
        }
      }
    }
    else
    {
      localObject1 = new File(aipf.c(this.this$0));
    }
    for (;;)
    {
      try
      {
        if ((!((File)localObject1).isFile()) || (!((File)localObject1).exists()))
        {
          QLog.e("apollo_cmGame_CmGameCommonShare", 1, new Object[] { "shareResult2WXFriendOrCircle sharefile is not exsit:", ((File)localObject1).getAbsolutePath() });
          localObject1 = new File(aipf.a(this.this$0, aipf.a(this.this$0)));
          if (!((File)localObject1).exists())
          {
            localObject1 = new File(aipf.b(this.this$0, aipf.a(this.this$0)));
            if (((File)localObject1).exists())
            {
              localObject2 = BitmapFactory.decodeFile(((File)localObject1).getAbsolutePath());
              if (localObject2 == null) {
                break;
              }
              localObject2 = azsq.a((Bitmap)localObject2);
              WXShareHelper.a().a(new aiph(this));
              WXShareHelper.a().a(((File)localObject1).getAbsolutePath(), (Bitmap)localObject2, this.a);
              return;
            }
            localObject2 = azvq.b(BaseApplicationImpl.getApplication().getResources(), 2130838430);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.data.CmGameCommonShare.4
 * JD-Core Version:    0.7.0.1
 */