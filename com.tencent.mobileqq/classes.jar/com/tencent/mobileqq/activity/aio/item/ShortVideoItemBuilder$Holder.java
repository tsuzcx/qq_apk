package com.tencent.mobileqq.activity.aio.item;

import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.customviews.VideoProgressView;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.utils.AIOSingleReporter;
import com.tencent.mobileqq.videoplatform.view.CropBubbleVideoView;
import java.util.concurrent.CopyOnWriteArraySet;

public class ShortVideoItemBuilder$Holder
  extends BaseBubbleBuilder.ViewHolder
{
  public CropBubbleVideoView a;
  public URLDrawable b;
  public VideoProgressView c;
  public RelativeLayout d;
  public TextView e;
  public TextView f;
  public TextView g;
  public ProgressBar s;
  public TextView t;
  public TextView u;
  public ImageView v;
  
  public ShortVideoItemBuilder$Holder(ShortVideoItemBuilder paramShortVideoItemBuilder) {}
  
  public void a()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      long l = ((CropBubbleVideoView)localObject).getCurPlayingPos();
      if (l > 0L)
      {
        localObject = AIOSingleReporter.a().b(Integer.valueOf(this.a.getId()));
        if (localObject != null) {
          ShortVideoItemBuilder.a(this.w, (MessageForShortVideo)localObject, l);
        }
      }
      this.a.releasePlayer(true);
      ShortVideoItemBuilder.k().remove(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder.Holder
 * JD-Core Version:    0.7.0.1
 */