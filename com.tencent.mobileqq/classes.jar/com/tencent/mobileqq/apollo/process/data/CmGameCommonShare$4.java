package com.tencent.mobileqq.apollo.process.data;

import ajac;
import ajcb;
import ajcd;
import ajms;
import ajya;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import baui;
import baxi;
import bbwu;
import bbww;
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
  public CmGameCommonShare$4(ajcb paramajcb, int paramInt) {}
  
  public void run()
  {
    if (TextUtils.isEmpty(ajcb.b(this.this$0))) {
      ajcb.a(this.this$0, "shareQRCode_default_v2.png");
    }
    Object localObject2;
    Object localObject1;
    if ((ajcb.b(this.this$0).startsWith("http")) || (ajcb.b(this.this$0).startsWith("https")))
    {
      localObject2 = new File(ajms.s + ajcb.a(this.this$0) + File.separator + Utils.Crc64String(ajcb.b(this.this$0)) + "_shareQRCode.png");
      localObject1 = localObject2;
      if (!((File)localObject2).exists())
      {
        bbwu localbbwu = new bbwu(ajcb.b(this.this$0), (File)localObject2);
        localbbwu.p = false;
        localbbwu.j = false;
        localbbwu.n = true;
        localbbwu.s = false;
        localbbwu.q = true;
        localbbwu.r = true;
        localbbwu.b = true;
        localbbwu.f = "apollo_res";
        localObject1 = localObject2;
        if (bbww.a(localbbwu, ajac.a().getCurrentAccountUin(), BaseApplicationImpl.getContext()) != 0) {
          ApolloItemBuilder.a(ajya.a(2131702065), 1, BaseApplicationImpl.getContext());
        }
      }
    }
    else
    {
      localObject1 = new File(ajcb.c(this.this$0));
    }
    for (;;)
    {
      try
      {
        if ((!((File)localObject1).isFile()) || (!((File)localObject1).exists()))
        {
          QLog.e("apollo_cmGame_CmGameCommonShare", 1, new Object[] { "shareResult2WXFriendOrCircle sharefile is not exsit:", ((File)localObject1).getAbsolutePath() });
          localObject1 = new File(ajcb.a(this.this$0, ajcb.a(this.this$0)));
          if (!((File)localObject1).exists())
          {
            localObject1 = new File(ajcb.b(this.this$0, ajcb.a(this.this$0)));
            if (((File)localObject1).exists())
            {
              localObject2 = BitmapFactory.decodeFile(((File)localObject1).getAbsolutePath());
              if (localObject2 == null) {
                break;
              }
              localObject2 = baui.a((Bitmap)localObject2);
              WXShareHelper.a().a(new ajcd(this));
              WXShareHelper.a().a(((File)localObject1).getAbsolutePath(), (Bitmap)localObject2, this.a);
              return;
            }
            localObject2 = baxi.b(BaseApplicationImpl.getApplication().getResources(), 2130838438);
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