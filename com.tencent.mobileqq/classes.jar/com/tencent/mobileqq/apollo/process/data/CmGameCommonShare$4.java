package com.tencent.mobileqq.apollo.process.data;

import ajae;
import ajcd;
import ajcf;
import ajmu;
import ajyc;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import batu;
import bawu;
import bbwg;
import bbwi;
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
  public CmGameCommonShare$4(ajcd paramajcd, int paramInt) {}
  
  public void run()
  {
    if (TextUtils.isEmpty(ajcd.b(this.this$0))) {
      ajcd.a(this.this$0, "shareQRCode_default_v2.png");
    }
    Object localObject2;
    Object localObject1;
    if ((ajcd.b(this.this$0).startsWith("http")) || (ajcd.b(this.this$0).startsWith("https")))
    {
      localObject2 = new File(ajmu.s + ajcd.a(this.this$0) + File.separator + Utils.Crc64String(ajcd.b(this.this$0)) + "_shareQRCode.png");
      localObject1 = localObject2;
      if (!((File)localObject2).exists())
      {
        bbwg localbbwg = new bbwg(ajcd.b(this.this$0), (File)localObject2);
        localbbwg.p = false;
        localbbwg.j = false;
        localbbwg.n = true;
        localbbwg.s = false;
        localbbwg.q = true;
        localbbwg.r = true;
        localbbwg.b = true;
        localbbwg.f = "apollo_res";
        localObject1 = localObject2;
        if (bbwi.a(localbbwg, ajae.a().getCurrentAccountUin(), BaseApplicationImpl.getContext()) != 0) {
          ApolloItemBuilder.a(ajyc.a(2131702054), 1, BaseApplicationImpl.getContext());
        }
      }
    }
    else
    {
      localObject1 = new File(ajcd.c(this.this$0));
    }
    for (;;)
    {
      try
      {
        if ((!((File)localObject1).isFile()) || (!((File)localObject1).exists()))
        {
          QLog.e("apollo_cmGame_CmGameCommonShare", 1, new Object[] { "shareResult2WXFriendOrCircle sharefile is not exsit:", ((File)localObject1).getAbsolutePath() });
          localObject1 = new File(ajcd.a(this.this$0, ajcd.a(this.this$0)));
          if (!((File)localObject1).exists())
          {
            localObject1 = new File(ajcd.b(this.this$0, ajcd.a(this.this$0)));
            if (((File)localObject1).exists())
            {
              localObject2 = BitmapFactory.decodeFile(((File)localObject1).getAbsolutePath());
              if (localObject2 == null) {
                break;
              }
              localObject2 = batu.a((Bitmap)localObject2);
              WXShareHelper.a().a(new ajcf(this));
              WXShareHelper.a().a(((File)localObject1).getAbsolutePath(), (Bitmap)localObject2, this.a);
              return;
            }
            localObject2 = bawu.b(BaseApplicationImpl.getApplication().getResources(), 2130838438);
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