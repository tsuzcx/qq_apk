package com.tencent.biz.qqstory.takevideo.doodle.ui.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import java.util.ArrayList;
import java.util.List;
import ygs;
import ygt;

public class FaceViewPager
  extends ViewPager
{
  private List<ygt> a;
  
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
    setOnPageChangeListener(new ygs(this));
  }
  
  public void a(ygt paramygt)
  {
    if (!this.a.contains(paramygt)) {
      this.a.add(paramygt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.ui.widget.FaceViewPager
 * JD-Core Version:    0.7.0.1
 */