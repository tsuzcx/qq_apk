package com.tencent.mobileqq.apollo.process.data;

import ampj;
import amrg;
import amri;
import ancb;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import anni;
import bgbw;
import bggl;
import bhhf;
import bhhh;
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
  public CmGameCommonShare$4(amrg paramamrg, int paramInt) {}
  
  public void run()
  {
    if (TextUtils.isEmpty(amrg.b(this.this$0))) {
      amrg.a(this.this$0, "shareQRCode_default_v2.png");
    }
    Object localObject2;
    Object localObject1;
    if ((amrg.b(this.this$0).startsWith("http")) || (amrg.b(this.this$0).startsWith("https")))
    {
      localObject2 = new File(ancb.s + amrg.a(this.this$0) + File.separator + Utils.Crc64String(amrg.b(this.this$0)) + "_shareQRCode.png");
      localObject1 = localObject2;
      if (!((File)localObject2).exists())
      {
        bhhf localbhhf = new bhhf(amrg.b(this.this$0), (File)localObject2);
        localbhhf.p = false;
        localbhhf.j = false;
        localbhhf.n = true;
        localbhhf.s = false;
        localbhhf.q = true;
        localbhhf.r = true;
        localbhhf.b = true;
        localbhhf.f = "apollo_res";
        localObject1 = localObject2;
        if (bhhh.a(localbhhf, ampj.a().getCurrentAccountUin(), BaseApplicationImpl.getContext()) != 0) {
          ApolloItemBuilder.a(anni.a(2131700869), 1, BaseApplicationImpl.getContext());
        }
      }
    }
    else
    {
      localObject1 = new File(amrg.c(this.this$0));
    }
    for (;;)
    {
      try
      {
        if ((!((File)localObject1).isFile()) || (!((File)localObject1).exists()))
        {
          QLog.e("apollo_cmGame_CmGameCommonShare", 1, new Object[] { "shareResult2WXFriendOrCircle sharefile is not exsit:", ((File)localObject1).getAbsolutePath() });
          localObject1 = new File(amrg.a(this.this$0, amrg.a(this.this$0)));
          if (!((File)localObject1).exists())
          {
            localObject1 = new File(amrg.b(this.this$0, amrg.a(this.this$0)));
            if (((File)localObject1).exists())
            {
              localObject2 = BitmapFactory.decodeFile(((File)localObject1).getAbsolutePath());
              if (localObject2 == null) {
                break;
              }
              localObject2 = bgbw.a((Bitmap)localObject2);
              WXShareHelper.a().a(new amri(this));
              WXShareHelper.a().a(((File)localObject1).getAbsolutePath(), (Bitmap)localObject2, this.a);
              return;
            }
            localObject2 = bggl.b(BaseApplicationImpl.getApplication().getResources(), 2130838606);
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