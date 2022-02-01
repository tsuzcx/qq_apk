package com.tencent.mobileqq.apollo.process.data;

import amwn;
import amyk;
import amym;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import anvx;
import bgua;
import bgyo;
import bhyo;
import bhyq;
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
  public CmGameCommonShare$4(amyk paramamyk, int paramInt) {}
  
  public void run()
  {
    if (TextUtils.isEmpty(amyk.b(this.this$0))) {
      amyk.a(this.this$0, "shareQRCode_default_v2.png");
    }
    Object localObject2;
    Object localObject1;
    if ((amyk.b(this.this$0).startsWith("http")) || (amyk.b(this.this$0).startsWith("https")))
    {
      localObject2 = new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/game/" + amyk.a(this.this$0) + File.separator + Utils.Crc64String(amyk.b(this.this$0)) + "_shareQRCode.png");
      localObject1 = localObject2;
      if (!((File)localObject2).exists())
      {
        bhyo localbhyo = new bhyo(amyk.b(this.this$0), (File)localObject2);
        localbhyo.p = false;
        localbhyo.j = false;
        localbhyo.n = true;
        localbhyo.s = false;
        localbhyo.q = true;
        localbhyo.r = true;
        localbhyo.b = true;
        localbhyo.f = "apollo_res";
        localObject1 = localObject2;
        if (bhyq.a(localbhyo, amwn.a().getCurrentAccountUin(), BaseApplicationImpl.getContext()) != 0) {
          ApolloItemBuilder.a(anvx.a(2131701562), 1, BaseApplicationImpl.getContext());
        }
      }
    }
    else
    {
      localObject1 = new File(amyk.c(this.this$0));
    }
    for (;;)
    {
      try
      {
        if ((!((File)localObject1).isFile()) || (!((File)localObject1).exists()))
        {
          QLog.e("apollo_cmGame_CmGameCommonShare", 1, new Object[] { "shareResult2WXFriendOrCircle sharefile is not exsit:", ((File)localObject1).getAbsolutePath() });
          localObject1 = new File(amyk.a(this.this$0, amyk.a(this.this$0)));
          if (!((File)localObject1).exists())
          {
            localObject1 = new File(amyk.b(this.this$0, amyk.a(this.this$0)));
            if (((File)localObject1).exists())
            {
              localObject2 = BitmapFactory.decodeFile(((File)localObject1).getAbsolutePath());
              if (localObject2 == null) {
                break;
              }
              localObject2 = bgua.a((Bitmap)localObject2);
              WXShareHelper.a().a(new amym(this));
              WXShareHelper.a().a(((File)localObject1).getAbsolutePath(), (Bitmap)localObject2, this.a);
              return;
            }
            localObject2 = bgyo.b(BaseApplicationImpl.getApplication().getResources(), 2130838660);
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