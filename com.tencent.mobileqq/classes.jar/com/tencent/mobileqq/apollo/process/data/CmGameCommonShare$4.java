package com.tencent.mobileqq.apollo.process.data;

import anbd;
import anda;
import andc;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import annv;
import anzj;
import bhbx;
import bhgm;
import bihu;
import bihw;
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
  public CmGameCommonShare$4(anda paramanda, int paramInt) {}
  
  public void run()
  {
    if (TextUtils.isEmpty(anda.b(this.this$0))) {
      anda.a(this.this$0, "shareQRCode_default_v2.png");
    }
    Object localObject2;
    Object localObject1;
    if ((anda.b(this.this$0).startsWith("http")) || (anda.b(this.this$0).startsWith("https")))
    {
      localObject2 = new File(annv.s + anda.a(this.this$0) + File.separator + Utils.Crc64String(anda.b(this.this$0)) + "_shareQRCode.png");
      localObject1 = localObject2;
      if (!((File)localObject2).exists())
      {
        bihu localbihu = new bihu(anda.b(this.this$0), (File)localObject2);
        localbihu.p = false;
        localbihu.j = false;
        localbihu.n = true;
        localbihu.s = false;
        localbihu.q = true;
        localbihu.r = true;
        localbihu.b = true;
        localbihu.f = "apollo_res";
        localObject1 = localObject2;
        if (bihw.a(localbihu, anbd.a().getCurrentAccountUin(), BaseApplicationImpl.getContext()) != 0) {
          ApolloItemBuilder.a(anzj.a(2131700976), 1, BaseApplicationImpl.getContext());
        }
      }
    }
    else
    {
      localObject1 = new File(anda.c(this.this$0));
    }
    for (;;)
    {
      try
      {
        if ((!((File)localObject1).isFile()) || (!((File)localObject1).exists()))
        {
          QLog.e("apollo_cmGame_CmGameCommonShare", 1, new Object[] { "shareResult2WXFriendOrCircle sharefile is not exsit:", ((File)localObject1).getAbsolutePath() });
          localObject1 = new File(anda.a(this.this$0, anda.a(this.this$0)));
          if (!((File)localObject1).exists())
          {
            localObject1 = new File(anda.b(this.this$0, anda.a(this.this$0)));
            if (((File)localObject1).exists())
            {
              localObject2 = BitmapFactory.decodeFile(((File)localObject1).getAbsolutePath());
              if (localObject2 == null) {
                break;
              }
              localObject2 = bhbx.a((Bitmap)localObject2);
              WXShareHelper.a().a(new andc(this));
              WXShareHelper.a().a(((File)localObject1).getAbsolutePath(), (Bitmap)localObject2, this.a);
              return;
            }
            localObject2 = bhgm.b(BaseApplicationImpl.getApplication().getResources(), 2130838619);
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