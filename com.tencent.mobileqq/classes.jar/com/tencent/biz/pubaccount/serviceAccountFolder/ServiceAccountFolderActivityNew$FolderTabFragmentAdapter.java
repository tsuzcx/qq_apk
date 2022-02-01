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
    if (ServiceAccountFolderActivityNew.a(this.a).size() > paramInt) {
      return (BaseFragment)ServiceAccountFolderActivityNew.a(this.a).get(paramInt);
    }
    return null;
  }
  
  public int getCount()
  {
    return ServiceAccountFolderActivityNew.a(this.a).size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivityNew.FolderTabFragmentAdapter
 * JD-Core Version:    0.7.0.1
 */