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
  private static final int jdField_a_of_type_Int = ScreenUtil.dip2px(240.0F);
  private static final int b = ScreenUtil.dip2px(240.0F);
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private List<View> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public void a()
  {
    if ((!CollectionUtils.isEmpty(this.jdField_a_of_type_JavaUtilList)) && (this.jdField_a_of_type_AndroidViewViewGroup != null))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        View localView = (View)localIterator.next();
        if ((localView instanceof DiniFlyAnimationView))
        {
          ((DiniFlyAnimationView)localView).cancelAnimation();
          this.jdField_a_of_type_AndroidViewViewGroup.removeView(localView);
        }
      }
      this.jdField_a_of_type_JavaUtilList.clear();
    }
  }
  
  public void a(ViewGroup paramViewGroup, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    paramViewGroup = new DiniFlyAnimationView(this.jdField_a_of_type_AndroidViewViewGroup.getContext());
    paramViewGroup.setAnimation("wsdoublelike/data.json");
    paramViewGroup.setSpeed(2.0F);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(jdField_a_of_type_Int, b);
    localLayoutParams.setMargins(paramInt1 - jdField_a_of_type_Int / 2, paramInt2 - b / 2, 0, 0);
    this.jdField_a_of_type_AndroidViewViewGroup.addView(paramViewGroup, localLayoutParams);
    this.jdField_a_of_type_JavaUtilList.add(paramViewGroup);
    paramViewGroup.addAnimatorListener(new WSDoubleLikeAnimation.1(this, paramViewGroup));
    paramViewGroup.playAnimation();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.like.WSDoubleLikeAnimation
 * JD-Core Version:    0.7.0.1
 */