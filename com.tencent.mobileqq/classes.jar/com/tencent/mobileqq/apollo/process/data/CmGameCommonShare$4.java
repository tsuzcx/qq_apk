package com.tencent.mobileqq.apollo.process.data;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.Utils;
import com.tencent.mobileqq.apollo.api.aio.item.impl.ApolloItemBuilder;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.troopshare.TroopShareUtility;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class CmGameCommonShare$4
  implements Runnable
{
  CmGameCommonShare$4(CmGameCommonShare paramCmGameCommonShare, int paramInt) {}
  
  public void run()
  {
    if (TextUtils.isEmpty(CmGameCommonShare.b(this.this$0))) {
      CmGameCommonShare.a(this.this$0, "shareQRCode_default_v2.png");
    }
    Object localObject2;
    Object localObject1;
    if ((CmGameCommonShare.b(this.this$0).startsWith("http")) || (CmGameCommonShare.b(this.this$0).startsWith("https")))
    {
      localObject2 = new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/game/" + CmGameCommonShare.a(this.this$0) + File.separator + Utils.Crc64String(CmGameCommonShare.b(this.this$0)) + "_shareQRCode.png");
      localObject1 = localObject2;
      if (!((File)localObject2).exists())
      {
        DownloadTask localDownloadTask = new DownloadTask(CmGameCommonShare.b(this.this$0), (File)localObject2);
        localDownloadTask.p = false;
        localDownloadTask.j = false;
        localDownloadTask.n = true;
        localDownloadTask.s = false;
        localDownloadTask.q = true;
        localDownloadTask.r = true;
        localDownloadTask.b = true;
        localDownloadTask.f = "apollo_res";
        localObject1 = localObject2;
        if (DownloaderFactory.a(localDownloadTask, CmGameUtil.a().getCurrentAccountUin(), BaseApplicationImpl.getContext()) != 0) {
          ApolloItemBuilder.a(HardCodeUtil.a(2131702117), 1, BaseApplicationImpl.getContext());
        }
      }
    }
    else
    {
      localObject1 = new File(CmGameCommonShare.c(this.this$0));
    }
    for (;;)
    {
      try
      {
        if ((!((File)localObject1).isFile()) || (!((File)localObject1).exists()))
        {
          QLog.e("apollo_cmGame_CmGameCommonShare", 1, new Object[] { "shareResult2WXFriendOrCircle sharefile is not exsit:", ((File)localObject1).getAbsolutePath() });
          localObject1 = new File(CmGameCommonShare.a(this.this$0, CmGameCommonShare.a(this.this$0)));
          if (!((File)localObject1).exists())
          {
            localObject1 = new File(CmGameCommonShare.b(this.this$0, CmGameCommonShare.a(this.this$0)));
            if (((File)localObject1).exists())
            {
              localObject2 = BitmapFactory.decodeFile(((File)localObject1).getAbsolutePath());
              if (localObject2 == null) {
                break;
              }
              localObject2 = TroopShareUtility.a((Bitmap)localObject2);
              WXShareHelper.a().a(new CmGameCommonShare.4.1(this));
              WXShareHelper.a().a(((File)localObject1).getAbsolutePath(), (Bitmap)localObject2, this.a);
              return;
            }
            localObject2 = BitmapManager.b(BaseApplicationImpl.getApplication().getResources(), 2130838728);
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