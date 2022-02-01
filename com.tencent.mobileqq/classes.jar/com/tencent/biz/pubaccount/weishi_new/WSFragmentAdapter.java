package com.tencent.biz.pubaccount.weishi_new;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.tencent.mobileqq.app.QBaseFragment;
import java.util.List;

public class WSFragmentAdapter
  extends FragmentPagerAdapter
{
  private List<QBaseFragment> a;
  
  public WSFragmentAdapter(FragmentManager paramFragmentManager, List<QBaseFragment> paramList)
  {
    super(paramFragmentManager);
    this.a = paramList;
  }
  
  public QBaseFragment a(int paramInt)
  {
    return (QBaseFragment)this.a.get(paramInt);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSFragmentAdapter
 * JD-Core Version:    0.7.0.1
 */