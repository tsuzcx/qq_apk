package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.Context;
import android.content.res.Resources;
import android.os.AsyncTask;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.ImageInfo;
import com.tencent.mobileqq.activity.photo.StatisticConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicUploadInfo.Builder;
import com.tencent.mobileqq.pic.api.IPicBus;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import java.util.List;

final class PlusPanelUtils$6
  extends AsyncTask<Void, Void, ImageInfo>
{
  PlusPanelUtils$6(SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface, Context paramContext, String paramString) {}
  
  protected ImageInfo a(Void... paramVarArgs)
  {
    ImageUtil.a(-1L, this.a.a, true, "image_send_prepare", "sessionInfo.handleScreenPhoto");
    String str = ImageUtil.b(this.b.getApplication(), this.d, this.a.a);
    paramVarArgs = new ImageInfo();
    ImageUtil.a(paramVarArgs, "compress_start", "sessionInfo.handleScreenPhoto");
    ImageUtil.a(3, this.c, this.d, str, true, paramVarArgs, this.a.a);
    if (!FileUtils.fileExistsAndNotEmpty(paramVarArgs.f)) {
      return null;
    }
    try
    {
      int i = this.a.a;
      QQAppInterface localQQAppInterface = this.b;
      StatisticConstants.a(new String[] { str }, i, false, false, -1, localQQAppInterface);
      return paramVarArgs;
    }
    catch (Exception localException) {}
    return paramVarArgs;
  }
  
  protected void a(ImageInfo paramImageInfo)
  {
    int i = 0;
    if (paramImageInfo != null)
    {
      Object localObject = new PicUploadInfo.Builder();
      ((PicUploadInfo.Builder)localObject).a(paramImageInfo.f);
      ((PicUploadInfo.Builder)localObject).d(1027);
      ((PicUploadInfo.Builder)localObject).d(this.a.b);
      if (paramImageInfo.B == 2) {
        i = 1;
      }
      ((PicUploadInfo.Builder)localObject).c(i);
      ((PicUploadInfo.Builder)localObject).e(this.a.c);
      ((PicUploadInfo.Builder)localObject).c(this.b.getCurrentAccountUin());
      ((PicUploadInfo.Builder)localObject).e(this.a.a);
      PicReq localPicReq = ((IPicBus)QRoute.api(IPicBus.class)).createPicReq(2, 1027);
      localPicReq.a(((PicUploadInfo.Builder)localObject).k());
      ((IPicBus)QRoute.api(IPicBus.class)).launch(localPicReq);
      localObject = new ArrayList();
      ((ArrayList)localObject).add(paramImageInfo);
      ImageUtil.a(this.c, (List)localObject, this.a.a);
      return;
    }
    ImageUtil.a(-1L, this.a.a, true, "image_send_prepared_failed", "sessionInfo.handleScreenPhoto");
    paramImageInfo = this.c;
    QQToast.makeText(paramImageInfo, paramImageInfo.getResources().getString(2131892634), 0).show(this.c.getResources().getDimensionPixelSize(2131299920));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PlusPanelUtils.6
 * JD-Core Version:    0.7.0.1
 */