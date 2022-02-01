package com.tencent.biz.qqcircle.richframework.compat;

import android.content.Intent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.tencent.biz.richframework.compat.CompatPublicFragment;
import java.util.ArrayList;

class CompatSlideFragment$SlidePageAdapter
  extends FragmentPagerAdapter
{
  private final ArrayList<Fragment> a = new ArrayList();
  private CompatPublicFragment b;
  
  public CompatSlideFragment$SlidePageAdapter(FragmentManager paramFragmentManager, Intent paramIntent)
  {
    super(paramFragmentManager);
    try
    {
      this.a.add(a(paramIntent, paramIntent.getStringExtra("KEY_LEFT_FRAGMENT_CLASS_NAME")));
      this.b = a(paramIntent, paramIntent.getStringExtra("KEY_RIGHT_FRAGMENT_CLASS_NAME"));
      this.a.add(this.b);
      return;
    }
    catch (ClassNotFoundException paramFragmentManager)
    {
      paramFragmentManager.printStackTrace();
      return;
    }
    catch (InstantiationException paramFragmentManager)
    {
      paramFragmentManager.printStackTrace();
      return;
    }
    catch (IllegalAccessException paramFragmentManager)
    {
      paramFragmentManager.printStackTrace();
    }
  }
  
  private CompatPublicFragment a(Intent paramIntent, String paramString)
  {
    paramString = (CompatPublicFragment)Class.forName(paramString).newInstance();
    paramString.setArguments(paramIntent.getExtras());
    return paramString;
  }
  
  public CompatPublicFragment a()
  {
    return this.b;
  }
  
  public int getCount()
  {
    return this.a.size();
  }
  
  public Fragment getItem(int paramInt)
  {
    if (paramInt < this.a.size()) {
      return (Fragment)this.a.get(paramInt);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.compat.CompatSlideFragment.SlidePageAdapter
 * JD-Core Version:    0.7.0.1
 */