package com.tencent.biz.pubaccount.readinjoy.video;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import oaj;
import qls;
import qmg;
import qqr;

public class VideoFeedsRecommendFragment$1$1
  implements Runnable
{
  public VideoFeedsRecommendFragment$1$1(qqr paramqqr, int paramInt) {}
  
  public void run()
  {
    if (VideoFeedsRecommendFragment.a(this.jdField_a_of_type_Qqr.a).getScrollState() != 0) {}
    Object localObject1;
    do
    {
      return;
      localObject1 = (LinearLayoutManager)VideoFeedsRecommendFragment.a(this.jdField_a_of_type_Qqr.a).getLayoutManager();
      int i = ((LinearLayoutManager)localObject1).findFirstVisibleItemPosition();
      int j = ((LinearLayoutManager)localObject1).findLastVisibleItemPosition();
      localObject1 = null;
      if (i < j)
      {
        Object localObject2 = VideoFeedsRecommendFragment.a(this.jdField_a_of_type_Qqr.a).getLayoutManager().findViewByPosition(i);
        if (localObject2 == null) {}
        for (;;)
        {
          i += 1;
          break;
          localObject2 = VideoFeedsRecommendFragment.a(this.jdField_a_of_type_Qqr.a).getChildViewHolder((View)localObject2);
          if (i == this.jdField_a_of_type_Int) {
            localObject1 = localObject2;
          }
          if (localObject2 != null) {
            if ((localObject2 instanceof qmg))
            {
              localObject2 = ((qmg)localObject2).a;
              if (localObject2 != null) {
                ((VideoFeedsAlphaMaskView)localObject2).setAlpha(0.0F);
              }
            }
          }
        }
      }
    } while ((VideoFeedsRecommendFragment.a(this.jdField_a_of_type_Qqr.a) == null) || (VideoFeedsRecommendFragment.a(this.jdField_a_of_type_Qqr.a).d()) || (localObject1 == null));
    VideoFeedsRecommendFragment.a(this.jdField_a_of_type_Qqr.a).a((RecyclerView.ViewHolder)localObject1);
    oaj.a(this.jdField_a_of_type_Qqr.a.getActivity(), VideoFeedsRecommendFragment.a(this.jdField_a_of_type_Qqr.a));
    oaj.b(this.jdField_a_of_type_Qqr.a.getActivity(), VideoFeedsRecommendFragment.a(this.jdField_a_of_type_Qqr.a));
    VideoFeedsRecommendFragment.a(this.jdField_a_of_type_Qqr.a).d();
    VideoFeedsRecommendFragment.a(this.jdField_a_of_type_Qqr.a).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendFragment.1.1
 * JD-Core Version:    0.7.0.1
 */