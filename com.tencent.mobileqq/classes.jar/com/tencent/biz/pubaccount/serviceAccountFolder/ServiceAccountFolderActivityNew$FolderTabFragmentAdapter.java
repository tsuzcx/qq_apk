package com.tencent.biz.pubaccount.serviceAccountFolder;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.tencent.mobileqq.app.BaseFragment;
import java.util.ArrayList;

public class ServiceAccountFolderActivityNew$FolderTabFragmentAdapter
  extends FragmentPagerAdapter
{
  public ServiceAccountFolderActivityNew$FolderTabFragmentAdapter(ServiceAccountFolderActivityNew paramServiceAccountFolderActivityNew, FragmentManager paramFragmentManager)
  {
    super(paramFragmentManager);
  }
  
  public BaseFragment a(int paramInt)
  {
    if (ServiceAccountFolderActivityNew.j(this.a).size() > paramInt) {
      return (BaseFragment)ServiceAccountFolderActivityNew.j(this.a).get(paramInt);
    }
    return null;
  }
  
  public int getCount()
  {
    return ServiceAccountFolderActivityNew.j(this.a).size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivityNew.FolderTabFragmentAdapter
 * JD-Core Version:    0.7.0.1
 */