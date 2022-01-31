package com.tencent.biz.pubaccount.readinjoy.video;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import oag;
import qlp;
import qmd;
import qqo;

public class VideoFeedsRecommendFragment$1$1
  implements Runnable
{
  public VideoFeedsRecommendFragment$1$1(qqo paramqqo, int paramInt) {}
  
  public void run()
  {
    if (VideoFeedsRecommendFragment.a(this.jdField_a_of_type_Qqo.a).getScrollState() != 0) {}
    Object localObject1;
    do
    {
      return;
      localObject1 = (LinearLayoutManager)VideoFeedsRecommendFragment.a(this.jdField_a_of_type_Qqo.a).getLayoutManager();
      int i = ((LinearLayoutManager)localObject1).findFirstVisibleItemPosition();
      int j = ((LinearLayoutManager)localObject1).findLastVisibleItemPosition();
      localObject1 = null;
      if (i < j)
      {
        Object localObject2 = VideoFeedsRecommendFragment.a(this.jdField_a_of_type_Qqo.a).getLayoutManager().findViewByPosition(i);
        if (localObject2 == null) {}
        for (;;)
        {
          i += 1;
          break;
          localObject2 = VideoFeedsRecommendFragment.a(this.jdField_a_of_type_Qqo.a).getChildViewHolder((View)localObject2);
          if (i == this.jdField_a_of_type_Int) {
            localObject1 = localObject2;
          }
          if (localObject2 != null) {
            if ((localObject2 instanceof qmd))
            {
              localObject2 = ((qmd)localObject2).a;
              if (localObject2 != null) {
                ((VideoFeedsAlphaMaskView)localObject2).setAlpha(0.0F);
              }
            }
          }
        }
      }
    } while ((VideoFeedsRecommendFragment.a(this.jdField_a_of_type_Qqo.a) == null) || (VideoFeedsRecommendFragment.a(this.jdField_a_of_type_Qqo.a).d()) || (localObject1 == null));
    VideoFeedsRecommendFragment.a(this.jdField_a_of_type_Qqo.a).a((RecyclerView.ViewHolder)localObject1);
    oag.a(this.jdField_a_of_type_Qqo.a.getActivity(), VideoFeedsRecommendFragment.a(this.jdField_a_of_type_Qqo.a));
    oag.b(this.jdField_a_of_type_Qqo.a.getActivity(), VideoFeedsRecommendFragment.a(this.jdField_a_of_type_Qqo.a));
    VideoFeedsRecommendFragment.a(this.jdField_a_of_type_Qqo.a).d();
    VideoFeedsRecommendFragment.a(this.jdField_a_of_type_Qqo.a).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendFragment.1.1
 * JD-Core Version:    0.7.0.1
 */