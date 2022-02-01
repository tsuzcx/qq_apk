package com.tencent.biz.qqstory.takevideo.doodle.ui.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import java.util.ArrayList;
import java.util.List;
import zfr;
import zfs;

public class FaceViewPager
  extends ViewPager
{
  private List<zfs> a;
  
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
    setOnPageChangeListener(new zfr(this));
  }
  
  public void a(zfs paramzfs)
  {
    if (!this.a.contains(paramzfs)) {
      this.a.add(paramzfs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.ui.widget.FaceViewPager
 * JD-Core Version:    0.7.0.1
 */