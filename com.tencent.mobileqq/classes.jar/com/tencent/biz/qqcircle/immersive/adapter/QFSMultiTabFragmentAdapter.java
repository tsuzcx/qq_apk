package com.tencent.biz.qqcircle.immersive.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.tencent.biz.qqcircle.richframework.part.utils.ArrayUtils;
import java.util.ArrayList;
import java.util.List;

public class QFSMultiTabFragmentAdapter
  extends FragmentPagerAdapter
{
  private final List<Fragment> a = new ArrayList();
  private final List<String> b = new ArrayList();
  
  public QFSMultiTabFragmentAdapter(FragmentManager paramFragmentManager)
  {
    super(paramFragmentManager);
  }
  
  public void a(List<? extends Fragment> paramList)
  {
    this.a.clear();
    this.a.addAll(paramList);
  }
  
  public void b(List<String> paramList)
  {
    this.b.clear();
    this.b.addAll(paramList);
  }
  
  public int getCount()
  {
    return this.a.size();
  }
  
  public Fragment getItem(int paramInt)
  {
    if (ArrayUtils.a(paramInt, this.a)) {
      return null;
    }
    return (Fragment)this.a.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return ((Fragment)this.a.get(paramInt)).hashCode();
  }
  
  public int getItemPosition(Object paramObject)
  {
    return -2;
  }
  
  public CharSequence getPageTitle(int paramInt)
  {
    if (ArrayUtils.a(paramInt, this.b)) {
      return "";
    }
    return (CharSequence)this.b.get(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.adapter.QFSMultiTabFragmentAdapter
 * JD-Core Version:    0.7.0.1
 */