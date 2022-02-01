package com.tencent.biz.pubaccount.readinjoy.video.column;

import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.IBitmapCallback;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ImageManager;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ImageRequest;
import java.net.URL;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class VideoColumnGuideManager$fetchGuideBgImg$1
  implements Runnable
{
  VideoColumnGuideManager$fetchGuideBgImg$1(VideoColumnGuideManager paramVideoColumnGuideManager) {}
  
  public final void run()
  {
    int j = 0;
    ImageRequest localImageRequest = new ImageRequest();
    ImageView localImageView = VideoColumnGuideManager.a(this.this$0);
    if (localImageView != null) {}
    for (int i = localImageView.getWidth();; i = 0)
    {
      localImageRequest.jdField_a_of_type_Int = i;
      localImageView = VideoColumnGuideManager.a(this.this$0);
      i = j;
      if (localImageView != null) {
        i = localImageView.getHeight();
      }
      localImageRequest.b = i;
      localImageRequest.jdField_a_of_type_JavaNetURL = new URL("https://kd.qpic.cn/kamlin/assets/video_column_guide_bg_d59dfa8a.jpg");
      ImageManager.a().a(localImageRequest, (IBitmapCallback)new VideoColumnGuideManager.fetchGuideBgImg.1.1(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.column.VideoColumnGuideManager.fetchGuideBgImg.1
 * JD-Core Version:    0.7.0.1
 */