package com.tencent.biz.pubaccount.readinjoy.video.column;

import android.widget.ImageView;
import java.net.URL;
import kotlin.Metadata;
import rym;
import ryp;
import sum;
import sun;
import suo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
public final class VideoColumnGuideManager$fetchGuideBgImg$1
  implements Runnable
{
  public VideoColumnGuideManager$fetchGuideBgImg$1(rym paramrym) {}
  
  public final void run()
  {
    int j = 0;
    suo localsuo = new suo();
    ImageView localImageView = rym.a(this.this$0);
    if (localImageView != null) {}
    for (int i = localImageView.getWidth();; i = 0)
    {
      localsuo.jdField_a_of_type_Int = i;
      localImageView = rym.a(this.this$0);
      i = j;
      if (localImageView != null) {
        i = localImageView.getHeight();
      }
      localsuo.b = i;
      localsuo.jdField_a_of_type_JavaNetURL = new URL("https://kd.qpic.cn/kamlin/assets/video_column_guide_bg_d59dfa8a.jpg");
      sun.a().a(localsuo, (sum)new ryp(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.column.VideoColumnGuideManager.fetchGuideBgImg.1
 * JD-Core Version:    0.7.0.1
 */