package com.tencent.biz.pubaccount.readinjoy.video.column;

import android.widget.ImageView;
import java.net.URL;
import kotlin.Metadata;
import sfq;
import sft;
import sym;
import syn;
import syo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
public final class VideoColumnGuideManager$fetchGuideBgImg$1
  implements Runnable
{
  public VideoColumnGuideManager$fetchGuideBgImg$1(sfq paramsfq) {}
  
  public final void run()
  {
    int j = 0;
    syo localsyo = new syo();
    ImageView localImageView = sfq.a(this.this$0);
    if (localImageView != null) {}
    for (int i = localImageView.getWidth();; i = 0)
    {
      localsyo.jdField_a_of_type_Int = i;
      localImageView = sfq.a(this.this$0);
      i = j;
      if (localImageView != null) {
        i = localImageView.getHeight();
      }
      localsyo.b = i;
      localsyo.jdField_a_of_type_JavaNetURL = new URL("https://kd.qpic.cn/kamlin/assets/video_column_guide_bg_d59dfa8a.jpg");
      syn.a().a(localsyo, (sym)new sft(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.column.VideoColumnGuideManager.fetchGuideBgImg.1
 * JD-Core Version:    0.7.0.1
 */