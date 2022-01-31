package com.app.hubert.guide.util;

import android.app.Activity;
import android.graphics.Rect;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.Window;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;

public class ViewUtils
{
  private static final String FRAGMENT_CON = "NoSaveStateFrameLayout";
  
  public static Rect getLocationInView(View paramView1, View paramView2)
  {
    if ((paramView2 == null) || (paramView1 == null)) {
      throw new IllegalArgumentException("parent and child can not be null .");
    }
    Object localObject = paramView2.getContext();
    if ((localObject instanceof Activity)) {}
    for (View localView1 = ((Activity)localObject).getWindow().getDecorView();; localView1 = null)
    {
      Rect localRect1 = new Rect();
      Rect localRect2 = new Rect();
      View localView2;
      if (paramView2 == paramView1)
      {
        paramView2.getHitRect(localRect1);
        return localRect1;
        int i;
        if ((localView2.getParent() instanceof ScrollView))
        {
          i = ((ScrollView)localView2.getParent()).getScrollY();
          LogUtil.i("scrollY:" + i);
          localRect1.top -= i;
        }
        if ((localView2.getParent() instanceof HorizontalScrollView))
        {
          i = ((HorizontalScrollView)localView2.getParent()).getScrollX();
          LogUtil.i("scrollX:" + i);
          localRect1.left -= i;
        }
        localObject = localView2;
        if (localView2.getParent() != null)
        {
          localObject = localView2;
          if (!(localView2.getParent() instanceof ViewPager)) {}
        }
      }
      for (localObject = (View)localView2.getParent();; localObject = paramView2)
      {
        if ((localObject != localView1) && (localObject != paramView1))
        {
          LogUtil.i("tmp class:" + localObject.getClass().getSimpleName());
          ((View)localObject).getHitRect(localRect2);
          LogUtil.i("tmp hit Rect:" + localRect2);
          if (!localObject.getClass().equals("NoSaveStateFrameLayout"))
          {
            localRect1.left += localRect2.left;
            localRect1.top += localRect2.top;
          }
          localView2 = (View)((View)localObject).getParent();
          if (localView2 != null) {
            break;
          }
          throw new IllegalArgumentException("the view is not showing in the window!");
        }
        localRect1.right = (localRect1.left + paramView2.getMeasuredWidth());
        localRect1.bottom = (localRect1.top + paramView2.getMeasuredHeight());
        return localRect1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.app.hubert.guide.util.ViewUtils
 * JD-Core Version:    0.7.0.1
 */