package com.tencent.biz.qqstory.takevideo.doodle.ui.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import java.util.ArrayList;
import java.util.List;
import xil;
import xim;

public class FaceViewPager
  extends ViewPager
{
  private List<xim> a;
  
  public FaceViewPager(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public FaceViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a()
  {
    this.a = new ArrayList();
    setOnPageChangeListener(new xil(this));
  }
  
  public void a(xim paramxim)
  {
    if (!this.a.contains(paramxim)) {
      this.a.add(paramxim);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.ui.widget.FaceViewPager
 * JD-Core Version:    0.7.0.1
 */