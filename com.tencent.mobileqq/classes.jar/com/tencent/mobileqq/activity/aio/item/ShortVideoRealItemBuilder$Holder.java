package com.tencent.mobileqq.activity.aio.item;

import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.utils.AIOSingleReporter;
import com.tencent.mobileqq.videoplatform.view.CropBubbleVideoView;
import com.tencent.mobileqq.widget.MessageProgressView;
import java.util.concurrent.CopyOnWriteArraySet;

public class ShortVideoRealItemBuilder$Holder
  extends BaseBubbleBuilder.ViewHolder
{
  public CropBubbleVideoView a;
  public MessageProgressView b;
  public TextView c;
  public ImageView d;
  public ImageView e;
  public int f;
  
  public ShortVideoRealItemBuilder$Holder(ShortVideoRealItemBuilder paramShortVideoRealItemBuilder) {}
  
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
          this.g.a((MessageForShortVideo)localObject, l);
        }
      }
      this.a.releasePlayer(true);
      ShortVideoRealItemBuilder.y.remove(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder.Holder
 * JD-Core Version:    0.7.0.1
 */