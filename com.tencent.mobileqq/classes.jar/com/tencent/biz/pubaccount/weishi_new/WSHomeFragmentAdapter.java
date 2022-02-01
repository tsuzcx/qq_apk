package com.tencent.biz.pubaccount.weishi_new;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.tencent.mobileqq.app.BaseFragment;
import java.util.List;

public class WSHomeFragmentAdapter
  extends FragmentPagerAdapter
{
  private List<BaseFragment> a;
  
  public WSHomeFragmentAdapter(FragmentManager paramFragmentManager, List<BaseFragment> paramList)
  {
    super(paramFragmentManager);
    this.a = paramList;
  }
  
  public BaseFragment a(int paramInt)
  {
    return (BaseFragment)this.a.get(paramInt);
  }
  
  public int getCount()
  {
    List localList = this.a;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSHomeFragmentAdapter
 * JD-Core Version:    0.7.0.1
 */