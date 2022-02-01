package com.tencent.biz.pubaccount.NativeAd.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import bjwq;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import java.util.ArrayList;
import nyq;
import nyy;

public class AdModuleAdapter
  extends PagerAdapter
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<nyy> jdField_a_of_type_JavaUtilArrayList;
  private nyq jdField_a_of_type_Nyq;
  private String b;
  private String c;
  
  public AdModuleAdapter(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, nyq paramnyq, ArrayList<nyy> paramArrayList)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Nyq = paramnyq;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public void a()
  {
    nyy localnyy = (nyy)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
    bjwq.a().b(localnyy);
    if (localnyy.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler != null) {
      AppNetConnInfo.unregisterNetInfoHandler(localnyy.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    }
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramObject = (nyy)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    paramViewGroup.removeView(paramObject.jdField_a_of_type_AndroidViewView);
    paramObject.c();
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      return this.jdField_a_of_type_JavaUtilArrayList.size();
    }
    return 0;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    nyy localnyy = (nyy)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    Context localContext = this.jdField_a_of_type_AndroidContentContext;
    String str1 = this.jdField_a_of_type_JavaLangString;
    String str2 = this.b;
    String str3 = this.c;
    int i = this.jdField_a_of_type_Int;
    nyq localnyq = this.jdField_a_of_type_Nyq;
    if (paramInt == getCount() - 1) {}
    for (boolean bool = true;; bool = false)
    {
      localnyy.jdField_a_of_type_AndroidViewView = localnyy.a(localContext, str1, str2, str3, i, localnyq, bool);
      paramViewGroup.addView(localnyy.jdField_a_of_type_AndroidViewView);
      return localnyy.jdField_a_of_type_AndroidViewView;
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.adapter.AdModuleAdapter
 * JD-Core Version:    0.7.0.1
 */