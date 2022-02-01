package com.tencent.biz.pubaccount.weishi_new.like;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WSDoubleLikeAnimation
{
  private static final int a = ScreenUtil.dip2px(240.0F);
  private static final int b = ScreenUtil.dip2px(240.0F);
  private ViewGroup c;
  private List<View> d = new ArrayList();
  
  public void a()
  {
    if ((!CollectionUtils.isEmpty(this.d)) && (this.c != null))
    {
      Iterator localIterator = this.d.iterator();
      while (localIterator.hasNext())
      {
        View localView = (View)localIterator.next();
        if ((localView instanceof DiniFlyAnimationView))
        {
          ((DiniFlyAnimationView)localView).cancelAnimation();
          this.c.removeView(localView);
        }
      }
      this.d.clear();
    }
  }
  
  public void a(ViewGroup paramViewGroup, int paramInt1, int paramInt2)
  {
    this.c = paramViewGroup;
    paramViewGroup = new DiniFlyAnimationView(this.c.getContext());
    paramViewGroup.setAnimation("wsdoublelike/data.json");
    paramViewGroup.setSpeed(2.0F);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(a, b);
    localLayoutParams.setMargins(paramInt1 - a / 2, paramInt2 - b / 2, 0, 0);
    this.c.addView(paramViewGroup, localLayoutParams);
    this.d.add(paramViewGroup);
    paramViewGroup.addAnimatorListener(new WSDoubleLikeAnimation.1(this, paramViewGroup));
    paramViewGroup.playAnimation();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.like.WSDoubleLikeAnimation
 * JD-Core Version:    0.7.0.1
 */