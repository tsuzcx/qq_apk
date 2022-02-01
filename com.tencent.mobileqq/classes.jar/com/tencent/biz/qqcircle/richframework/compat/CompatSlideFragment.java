package com.tencent.biz.qqcircle.richframework.compat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.richframework.compat.CompatPublicFragment;
import com.tencent.biz.richframework.part.Part;
import java.util.List;

public class CompatSlideFragment
  extends QCircleBaseFragment
{
  private ViewPager c;
  private CompatSlideFragment.SlidePageAdapter d;
  
  public int a()
  {
    return -1;
  }
  
  public void a(int paramInt)
  {
    ViewPager localViewPager = this.c;
    if (localViewPager != null) {
      localViewPager.setCurrentItem(paramInt);
    }
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    this.c = ((ViewPager)this.D.findViewById(2131450006));
    this.d = new CompatSlideFragment.SlidePageAdapter(getChildFragmentManager(), getActivity().getIntent());
    this.c.setAdapter(this.d);
    this.c.setOffscreenPageLimit(2);
  }
  
  public String b()
  {
    return "CompatSlideFragment";
  }
  
  protected int c()
  {
    return 2131626962;
  }
  
  protected List<Part> d()
  {
    return null;
  }
  
  public CompatPublicFragment u()
  {
    CompatSlideFragment.SlidePageAdapter localSlidePageAdapter = this.d;
    if (localSlidePageAdapter != null) {
      return localSlidePageAdapter.a();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.compat.CompatSlideFragment
 * JD-Core Version:    0.7.0.1
 */