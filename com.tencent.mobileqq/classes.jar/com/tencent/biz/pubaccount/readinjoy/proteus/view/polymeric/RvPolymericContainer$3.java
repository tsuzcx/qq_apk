package com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric;

import android.support.v7.widget.RecyclerView.OnChildAttachStateChangeListener;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.utils.VideoPlayControlUtils;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoyVideoView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeVideoView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class RvPolymericContainer$3
  implements RecyclerView.OnChildAttachStateChangeListener
{
  RvPolymericContainer$3(RvPolymericContainer paramRvPolymericContainer) {}
  
  public void onChildViewAttachedToWindow(View paramView)
  {
    if ((paramView instanceof Container))
    {
      if (RvPolymericContainer.a(this.a) != null)
      {
        int j = RvPolymericContainer.a(this.a).getChildCount();
        int i = 0;
        while (i < j)
        {
          Iterator localIterator = ((Container)RvPolymericContainer.a(this.a).getChildAt(i)).getViewIdMapping().entrySet().iterator();
          while (localIterator.hasNext())
          {
            Object localObject = (Map.Entry)localIterator.next();
            if ((((Map.Entry)localObject).getValue() instanceof ReadInJoyVideoView))
            {
              localObject = (ReadInJoyVideoView)((Map.Entry)localObject).getValue();
              if ((((ReadInJoyVideoView)localObject).a() instanceof NativeVideoView))
              {
                localObject = ((ReadInJoyVideoView)localObject).a();
                if (localObject != null) {
                  ((NativeVideoView)localObject).setVideoPlayListener(new RvPolymericContainer.3.1(this));
                }
              }
            }
          }
          i += 1;
        }
      }
      VideoPlayControlUtils.a((Container)paramView);
    }
  }
  
  public void onChildViewDetachedFromWindow(View paramView)
  {
    if ((paramView instanceof Container)) {
      VideoPlayControlUtils.b((Container)paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.RvPolymericContainer.3
 * JD-Core Version:    0.7.0.1
 */