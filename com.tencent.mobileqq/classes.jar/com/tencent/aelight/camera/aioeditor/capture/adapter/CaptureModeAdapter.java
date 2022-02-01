package com.tencent.aelight.camera.aioeditor.capture.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import java.util.List;

public class CaptureModeAdapter
  extends PagerAdapter
{
  private CaptureModeAdapter.OnItemClickListener a;
  private List<TextView> b;
  private int c;
  private int d;
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)this.b.get(paramInt));
  }
  
  public int getCount()
  {
    return this.b.size();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup.addView((View)this.b.get(paramInt));
    return this.b.get(paramInt);
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.adapter.CaptureModeAdapter
 * JD-Core Version:    0.7.0.1
 */