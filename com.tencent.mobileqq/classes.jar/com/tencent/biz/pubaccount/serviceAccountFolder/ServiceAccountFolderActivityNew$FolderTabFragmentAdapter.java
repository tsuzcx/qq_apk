package com.tencent.biz.pubaccount.serviceAccountFolder;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;

public class ServiceAccountFolderActivityNew$FolderTabFragmentAdapter
  extends FragmentPagerAdapter
{
  public ServiceAccountFolderActivityNew$FolderTabFragmentAdapter(ServiceAccountFolderActivityNew paramServiceAccountFolderActivityNew, FragmentManager paramFragmentManager)
  {
    super(paramFragmentManager);
  }
  
  public int getCount()
  {
    return ServiceAccountFolderActivityNew.a(this.a).size();
  }
  
  public Fragment getItem(int paramInt)
  {
    if (ServiceAccountFolderActivityNew.a(this.a).size() > paramInt) {
      return (Fragment)ServiceAccountFolderActivityNew.a(this.a).get(paramInt);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivityNew.FolderTabFragmentAdapter
 * JD-Core Version:    0.7.0.1
 */