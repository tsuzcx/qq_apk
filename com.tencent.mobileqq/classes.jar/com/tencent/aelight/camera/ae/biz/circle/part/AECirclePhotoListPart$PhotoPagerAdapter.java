package com.tencent.aelight.camera.ae.biz.circle.part;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import java.util.ArrayList;

class AECirclePhotoListPart$PhotoPagerAdapter
  extends PagerAdapter
{
  private Fragment jdField_a_of_type_AndroidAppFragment = null;
  private FragmentManager jdField_a_of_type_AndroidAppFragmentManager;
  private FragmentTransaction jdField_a_of_type_AndroidAppFragmentTransaction = null;
  
  public AECirclePhotoListPart$PhotoPagerAdapter(AECirclePhotoListPart paramAECirclePhotoListPart, Fragment paramFragment)
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      this.jdField_a_of_type_AndroidAppFragmentManager = paramFragment.getChildFragmentManager();
      return;
    }
    this.jdField_a_of_type_AndroidAppFragmentManager = paramFragment.getFragmentManager();
  }
  
  private String a(int paramInt, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("android:switcher:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(":");
    localStringBuilder.append(paramLong);
    return localStringBuilder.toString();
  }
  
  public long a(int paramInt)
  {
    return paramInt;
  }
  
  public Fragment a(int paramInt)
  {
    return (Fragment)AECirclePhotoListPart.a(this.jdField_a_of_type_ComTencentAelightCameraAeBizCirclePartAECirclePhotoListPart).get(paramInt);
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    if (this.jdField_a_of_type_AndroidAppFragmentTransaction == null) {
      this.jdField_a_of_type_AndroidAppFragmentTransaction = this.jdField_a_of_type_AndroidAppFragmentManager.beginTransaction();
    }
    this.jdField_a_of_type_AndroidAppFragmentTransaction.detach((Fragment)paramObject);
  }
  
  public void finishUpdate(ViewGroup paramViewGroup)
  {
    paramViewGroup = this.jdField_a_of_type_AndroidAppFragmentTransaction;
    if (paramViewGroup != null)
    {
      paramViewGroup.commitAllowingStateLoss();
      this.jdField_a_of_type_AndroidAppFragmentTransaction = null;
      this.jdField_a_of_type_AndroidAppFragmentManager.executePendingTransactions();
    }
  }
  
  public int getCount()
  {
    return AECirclePhotoListPart.a(this.jdField_a_of_type_ComTencentAelightCameraAeBizCirclePartAECirclePhotoListPart).size();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidAppFragmentTransaction == null) {
      this.jdField_a_of_type_AndroidAppFragmentTransaction = this.jdField_a_of_type_AndroidAppFragmentManager.beginTransaction();
    }
    long l = a(paramInt);
    Object localObject = a(paramViewGroup.getId(), l);
    localObject = this.jdField_a_of_type_AndroidAppFragmentManager.findFragmentByTag((String)localObject);
    if (localObject != null)
    {
      this.jdField_a_of_type_AndroidAppFragmentTransaction.attach((Fragment)localObject);
      paramViewGroup = (ViewGroup)localObject;
    }
    else
    {
      localObject = a(paramInt);
      this.jdField_a_of_type_AndroidAppFragmentTransaction.add(paramViewGroup.getId(), (Fragment)localObject, a(paramViewGroup.getId(), l));
      paramViewGroup = (ViewGroup)localObject;
    }
    if (paramViewGroup != this.jdField_a_of_type_AndroidAppFragment)
    {
      paramViewGroup.setMenuVisibility(false);
      paramViewGroup.setUserVisibleHint(false);
    }
    return paramViewGroup;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return ((Fragment)paramObject).getView() == paramView;
  }
  
  public void restoreState(Parcelable paramParcelable, ClassLoader paramClassLoader) {}
  
  public Parcelable saveState()
  {
    return null;
  }
  
  public void setPrimaryItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup = (Fragment)paramObject;
    paramObject = this.jdField_a_of_type_AndroidAppFragment;
    if (paramViewGroup != paramObject)
    {
      if (paramObject != null)
      {
        paramObject.setMenuVisibility(false);
        this.jdField_a_of_type_AndroidAppFragment.setUserVisibleHint(false);
      }
      if (paramViewGroup != null)
      {
        paramViewGroup.setMenuVisibility(true);
        paramViewGroup.setUserVisibleHint(true);
      }
      this.jdField_a_of_type_AndroidAppFragment = paramViewGroup;
    }
  }
  
  public void startUpdate(ViewGroup paramViewGroup) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.part.AECirclePhotoListPart.PhotoPagerAdapter
 * JD-Core Version:    0.7.0.1
 */