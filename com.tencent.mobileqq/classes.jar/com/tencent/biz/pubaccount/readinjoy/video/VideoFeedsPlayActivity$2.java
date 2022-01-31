package com.tencent.biz.pubaccount.readinjoy.video;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;
import azue;
import azvv;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import qei;

public class VideoFeedsPlayActivity$2
  implements Runnable
{
  VideoFeedsPlayActivity$2(VideoFeedsPlayActivity paramVideoFeedsPlayActivity, VideoInfo paramVideoInfo) {}
  
  public void run()
  {
    if ((!this.a.e()) || (TextUtils.isEmpty(this.a.a.g)) || (TextUtils.isEmpty(this.a.a.f)))
    {
      VideoFeedsPlayActivity.a(this.this$0).setVisibility(8);
      return;
    }
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    try
    {
      localObject = URLDrawable.getDrawable(new URL(this.a.a.g), (URLDrawable.URLDrawableOptions)localObject);
      ((URLDrawable)localObject).setTag(azue.b(0, 0, azvv.a(this.this$0, 3.0F)));
      ((URLDrawable)localObject).setDecodeHandler(azue.i);
      VideoFeedsPlayActivity.a(this.this$0).setImageDrawable((Drawable)localObject);
      VideoFeedsPlayActivity.a(this.this$0).setText(this.a.a.f);
      VideoFeedsPlayActivity.a(this.this$0).setOnClickListener(new qei(this));
      VideoFeedsPlayActivity.a(this.this$0).setVisibility(0);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, "innerConfigHeaderAppJump() ERROR e = " + localException.getMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity.2
 * JD-Core Version:    0.7.0.1
 */