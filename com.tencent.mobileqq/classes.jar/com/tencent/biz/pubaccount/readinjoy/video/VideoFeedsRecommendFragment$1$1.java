package com.tencent.biz.pubaccount.readinjoy.video;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import rnu;
import roj;
import rrp;
import tpn;

public class VideoFeedsRecommendFragment$1$1
  implements Runnable
{
  public VideoFeedsRecommendFragment$1$1(rrp paramrrp, int paramInt) {}
  
  public void run()
  {
    if (VideoFeedsRecommendFragment.a(this.jdField_a_of_type_Rrp.a).getScrollState() != 0) {}
    Object localObject1;
    do
    {
      return;
      localObject1 = (LinearLayoutManager)VideoFeedsRecommendFragment.a(this.jdField_a_of_type_Rrp.a).getLayoutManager();
      int i = ((LinearLayoutManager)localObject1).findFirstVisibleItemPosition();
      int j = ((LinearLayoutManager)localObject1).findLastVisibleItemPosition();
      localObject1 = null;
      if (i < j)
      {
        Object localObject2 = VideoFeedsRecommendFragment.a(this.jdField_a_of_type_Rrp.a).getLayoutManager().findViewByPosition(i);
        if (localObject2 == null) {}
        for (;;)
        {
          i += 1;
          break;
          localObject2 = VideoFeedsRecommendFragment.a(this.jdField_a_of_type_Rrp.a).getChildViewHolder((View)localObject2);
          if (i == this.jdField_a_of_type_Int) {
            localObject1 = localObject2;
          }
          if (localObject2 != null) {
            if ((localObject2 instanceof roj))
            {
              localObject2 = ((roj)localObject2).a;
              if (localObject2 != null) {
                ((VideoFeedsAlphaMaskView)localObject2).setAlpha(0.0F);
              }
            }
          }
        }
      }
    } while ((VideoFeedsRecommendFragment.a(this.jdField_a_of_type_Rrp.a) == null) || (VideoFeedsRecommendFragment.a(this.jdField_a_of_type_Rrp.a).d()) || (localObject1 == null));
    VideoFeedsRecommendFragment.a(this.jdField_a_of_type_Rrp.a).a((RecyclerView.ViewHolder)localObject1);
    tpn.a(this.jdField_a_of_type_Rrp.a.getActivity(), VideoFeedsRecommendFragment.a(this.jdField_a_of_type_Rrp.a));
    tpn.b(this.jdField_a_of_type_Rrp.a.getActivity(), VideoFeedsRecommendFragment.a(this.jdField_a_of_type_Rrp.a));
    VideoFeedsRecommendFragment.a(this.jdField_a_of_type_Rrp.a).d();
    VideoFeedsRecommendFragment.a(this.jdField_a_of_type_Rrp.a).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendFragment.1.1
 * JD-Core Version:    0.7.0.1
 */