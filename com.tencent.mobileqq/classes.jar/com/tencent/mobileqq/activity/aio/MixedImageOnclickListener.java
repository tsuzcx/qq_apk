package com.tencent.mobileqq.activity.aio;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.item.PicItemBuilder;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment;
import com.tencent.mobileqq.pic.api.IPicAIO;
import com.tencent.mobileqq.pic.api.IPicHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FolderUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class MixedImageOnclickListener
  implements View.OnClickListener
{
  public SessionInfo a;
  private long b = 0L;
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (l - this.b >= 1000L)
    {
      this.b = l;
      Object localObject = (URLImageView)paramView;
      MessageForPic localMessageForPic = (MessageForPic)((URLImageView)localObject).getTag(2131430592);
      URLDrawable localURLDrawable = (URLDrawable)((URLImageView)localObject).getDrawable();
      if (localURLDrawable != null)
      {
        int i = localURLDrawable.getStatus();
        if (i != 0)
        {
          if (i != 1)
          {
            if (i == 2)
            {
              localObject = ((IPicAIO)QRoute.api(IPicAIO.class)).getReceivePicFailedTip(localURLDrawable);
              if (localObject != null) {
                QQToast.makeText(paramView.getContext(), (CharSequence)localObject, 0).show();
              } else if (FolderUtils.a(paramView.getContext())) {
                localURLDrawable.restartDownload();
              }
            }
          }
          else if (((IPicHelper)QRoute.api(IPicHelper.class)).isEmotion(localMessageForPic))
          {
            AIOEmotionFragment.a(paramView.getContext(), localMessageForPic, this.a, AnimationUtils.a(paramView));
          }
          else
          {
            localMessageForPic.isInMixedMsg = true;
            PicItemBuilder.a(PlayModeUtils.b(), paramView.getContext(), (View)localObject, localMessageForPic, this.a, false, true, true, null);
          }
        }
        else if (!localURLDrawable.isDownloadStarted()) {
          localURLDrawable.startDownload();
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.MixedImageOnclickListener
 * JD-Core Version:    0.7.0.1
 */