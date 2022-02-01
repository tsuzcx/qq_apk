package com.tencent.mobileqq.apollo.process.data;

import alvx;
import alxu;
import alxw;
import amip;
import amtj;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import bflj;
import bfpx;
import bgoe;
import bgog;
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
  public CmGameCommonShare$4(alxu paramalxu, int paramInt) {}
  
  public void run()
  {
    if (TextUtils.isEmpty(alxu.b(this.this$0))) {
      alxu.a(this.this$0, "shareQRCode_default_v2.png");
    }
    Object localObject2;
    Object localObject1;
    if ((alxu.b(this.this$0).startsWith("http")) || (alxu.b(this.this$0).startsWith("https")))
    {
      localObject2 = new File(amip.s + alxu.a(this.this$0) + File.separator + Utils.Crc64String(alxu.b(this.this$0)) + "_shareQRCode.png");
      localObject1 = localObject2;
      if (!((File)localObject2).exists())
      {
        bgoe localbgoe = new bgoe(alxu.b(this.this$0), (File)localObject2);
        localbgoe.p = false;
        localbgoe.j = false;
        localbgoe.n = true;
        localbgoe.s = false;
        localbgoe.q = true;
        localbgoe.r = true;
        localbgoe.b = true;
        localbgoe.f = "apollo_res";
        localObject1 = localObject2;
        if (bgog.a(localbgoe, alvx.a().getCurrentAccountUin(), BaseApplicationImpl.getContext()) != 0) {
          ApolloItemBuilder.a(amtj.a(2131701211), 1, BaseApplicationImpl.getContext());
        }
      }
    }
    else
    {
      localObject1 = new File(alxu.c(this.this$0));
    }
    for (;;)
    {
      try
      {
        if ((!((File)localObject1).isFile()) || (!((File)localObject1).exists()))
        {
          QLog.e("apollo_cmGame_CmGameCommonShare", 1, new Object[] { "shareResult2WXFriendOrCircle sharefile is not exsit:", ((File)localObject1).getAbsolutePath() });
          localObject1 = new File(alxu.a(this.this$0, alxu.a(this.this$0)));
          if (!((File)localObject1).exists())
          {
            localObject1 = new File(alxu.b(this.this$0, alxu.a(this.this$0)));
            if (((File)localObject1).exists())
            {
              localObject2 = BitmapFactory.decodeFile(((File)localObject1).getAbsolutePath());
              if (localObject2 == null) {
                break;
              }
              localObject2 = bflj.a((Bitmap)localObject2);
              WXShareHelper.getInstance().addObserver(new alxw(this));
              WXShareHelper.getInstance().shareImageToWX(((File)localObject1).getAbsolutePath(), (Bitmap)localObject2, this.a);
              return;
            }
            localObject2 = bfpx.b(BaseApplicationImpl.getApplication().getResources(), 2130838644);
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