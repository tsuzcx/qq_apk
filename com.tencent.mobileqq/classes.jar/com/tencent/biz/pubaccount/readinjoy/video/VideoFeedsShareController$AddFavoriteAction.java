package com.tencent.biz.pubaccount.readinjoy.video;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.logic.ReadInJoyAtlasManager;
import com.tencent.biz.pubaccount.readinjoy.video.share.ShareAction;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;

class VideoFeedsShareController$AddFavoriteAction
  extends ShareAction
{
  VideoFeedsShareController$AddFavoriteAction(VideoFeedsShareController paramVideoFeedsShareController) {}
  
  public int a()
  {
    return 4;
  }
  
  public void a(int paramInt, VideoInfo paramVideoInfo, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if (!NetworkUtil.g(VideoFeedsShareController.a(this.a)))
    {
      QQToast.a(VideoFeedsShareController.a(this.a), 0, HardCodeUtil.a(2131716026), 0).a();
      return;
    }
    VideoFeedsHelper.a(VideoFeedsShareController.a(this.a), VideoFeedsShareController.a(this.a));
    paramVideoInfo.e = true;
    VideoFeedsShareController.a(this.a).b(VideoFeedsShareController.b(this.a));
    if ((VideoFeedsShareController.a(this.a) instanceof VideoFeedsPlayActivity)) {
      ((VideoFeedsPlayActivity)VideoFeedsShareController.a(this.a)).c(true);
    }
    paramString = paramVideoInfo.k;
    paramActionSheetItem = new Bundle();
    paramActionSheetItem.putInt("videoDuration", paramVideoInfo.jdField_d_of_type_Int);
    long l;
    if (TextUtils.isEmpty(paramVideoInfo.j))
    {
      l = 0L;
      paramActionSheetItem.putLong("publishAccountUin", l);
      paramActionSheetItem.putString("publishAccountName", paramString);
      paramActionSheetItem.putLong("feedsId", paramVideoInfo.jdField_d_of_type_Long);
      paramActionSheetItem.putInt("feedsType", paramVideoInfo.h);
      if (paramVideoInfo.a != 6) {
        break label289;
      }
      paramInt = 1;
      label189:
      paramActionSheetItem.putInt("videoType", paramInt);
      if (paramVideoInfo.g != null) {
        break label294;
      }
    }
    label289:
    label294:
    for (paramString = "";; paramString = paramVideoInfo.g)
    {
      ReadInJoyAtlasManager.a().a(VideoFeedsShareController.a(this.a), VideoFeedsShareController.a(this.a).getCurrentUin(), 2, paramString, paramVideoInfo.c, paramVideoInfo.jdField_d_of_type_JavaLangString, paramVideoInfo.b, paramVideoInfo.f + "&sourcefrom=6", paramActionSheetItem);
      paramVideoInfo.jdField_d_of_type_Boolean = true;
      return;
      l = Long.valueOf(paramVideoInfo.j).longValue();
      break;
      paramInt = 2;
      break label189;
    }
  }
  
  public int b()
  {
    return 6;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsShareController.AddFavoriteAction
 * JD-Core Version:    0.7.0.1
 */