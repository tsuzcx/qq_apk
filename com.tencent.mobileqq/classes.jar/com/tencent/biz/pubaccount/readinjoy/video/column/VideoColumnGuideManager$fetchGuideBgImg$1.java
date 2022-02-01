package com.tencent.biz.pubaccount.readinjoy.video.column;

import android.widget.ImageView;
import java.net.URL;
import kotlin.Metadata;
import shi;
import shl;
import tdu;
import tdv;
import tdw;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
public final class VideoColumnGuideManager$fetchGuideBgImg$1
  implements Runnable
{
  public VideoColumnGuideManager$fetchGuideBgImg$1(shi paramshi) {}
  
  public final void run()
  {
    int j = 0;
    tdw localtdw = new tdw();
    ImageView localImageView = shi.a(this.this$0);
    if (localImageView != null) {}
    for (int i = localImageView.getWidth();; i = 0)
    {
      localtdw.jdField_a_of_type_Int = i;
      localImageView = shi.a(this.this$0);
      i = j;
      if (localImageView != null) {
        i = localImageView.getHeight();
      }
      localtdw.b = i;
      localtdw.jdField_a_of_type_JavaNetURL = new URL("https://kd.qpic.cn/kamlin/assets/video_column_guide_bg_d59dfa8a.jpg");
      tdv.a().a(localtdw, (tdu)new shl(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.column.VideoColumnGuideManager.fetchGuideBgImg.1
 * JD-Core Version:    0.7.0.1
 */