package com.tencent.biz.subscribe.widget.relativevideo;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.tencent.mobileqq.app.BaseFragment;
import java.util.List;

class RelativePersonalBottomView$RelativePersonalBottomAdapter
  extends FragmentPagerAdapter
{
  public RelativePersonalBottomView$RelativePersonalBottomAdapter(RelativePersonalBottomView paramRelativePersonalBottomView, FragmentManager paramFragmentManager)
  {
    super(paramFragmentManager);
  }
  
  public BaseFragment a(int paramInt)
  {
    if (paramInt < RelativePersonalBottomView.a(this.a).size()) {
      return (BaseFragment)RelativePersonalBottomView.a(this.a).get(paramInt);
    }
    return null;
  }
  
  public int getCount()
  {
    return RelativePersonalBottomView.a(this.a).size();
  }
  
  public int getItemPosition(Object paramObject)
  {
    return -2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.RelativePersonalBottomView.RelativePersonalBottomAdapter
 * JD-Core Version:    0.7.0.1
 */