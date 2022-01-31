package com.tencent.biz.videostory.capture;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import bgxt;
import bgya;
import bhcm;
import com.tencent.biz.videostory.capture.widgets.AEPlayShowPageView;
import java.util.LinkedList;
import java.util.List;
import wus;

public class PlayViewPagerAdapter
  extends PagerAdapter
{
  private int jdField_a_of_type_Int = -1;
  private Context jdField_a_of_type_AndroidContentContext;
  private AEPlayShowPageView jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsAEPlayShowPageView;
  private List<bgxt> jdField_a_of_type_JavaUtilList;
  private wus jdField_a_of_type_Wus;
  
  public PlayViewPagerAdapter(@NonNull Context paramContext, @NonNull wus paramwus, @NonNull List<bgxt> paramList)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Wus = paramwus;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  private int a(int paramInt)
  {
    bgxt localbgxt = (bgxt)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localbgxt == null) {
      return 2;
    }
    return localbgxt.b;
  }
  
  private String a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > paramInt)) {
      return ((bgxt)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_JavaLangString;
    }
    return "-1";
  }
  
  private List<bgya> a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_JavaUtilList.size() > paramInt) {
        localObject1 = (bgxt)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      }
    }
    if ((localObject1 == null) || (((bgxt)localObject1).jdField_a_of_type_JavaUtilList == null)) {
      return new LinkedList();
    }
    return ((bgxt)localObject1).jdField_a_of_type_JavaUtilList;
  }
  
  public AEPlayShowPageView a()
  {
    return this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsAEPlayShowPageView;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Int <= 0) {
      return "-1";
    }
    return a(this.jdField_a_of_type_Int);
  }
  
  public List<bgxt> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(List<bgxt> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    if ((paramObject instanceof AEPlayShowPageView)) {
      ((AEPlayShowPageView)paramObject).c();
    }
    paramViewGroup.removeView((View)paramObject);
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public int getItemPosition(Object paramObject)
  {
    return -2;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    AEPlayShowPageView localAEPlayShowPageView = new AEPlayShowPageView(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Wus, a(paramInt), a(paramInt));
    paramViewGroup.addView(localAEPlayShowPageView);
    return localAEPlayShowPageView;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public void setPrimaryItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    super.setPrimaryItem(paramViewGroup, paramInt, paramObject);
    if (this.jdField_a_of_type_Int != paramInt)
    {
      this.jdField_a_of_type_Int = paramInt;
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > paramInt))
      {
        paramViewGroup = (bgxt)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        if (paramViewGroup != null) {
          bhcm.a().f(paramViewGroup.jdField_a_of_type_JavaLangString + "");
        }
      }
      if ((paramObject instanceof AEPlayShowPageView))
      {
        this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsAEPlayShowPageView = ((AEPlayShowPageView)paramObject);
        this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsAEPlayShowPageView.post(new PlayViewPagerAdapter.1(this, paramInt));
        this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsAEPlayShowPageView.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.videostory.capture.PlayViewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */