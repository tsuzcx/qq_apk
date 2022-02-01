package com.tencent.biz.pubaccount.NativeAd.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import bjna;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import java.util.ArrayList;
import ohb;
import ohj;

public class AdModuleAdapter
  extends PagerAdapter
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<ohj> jdField_a_of_type_JavaUtilArrayList;
  private ohb jdField_a_of_type_Ohb;
  private String b;
  private String c;
  
  public AdModuleAdapter(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, ohb paramohb, ArrayList<ohj> paramArrayList)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Ohb = paramohb;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public void a()
  {
    ohj localohj = (ohj)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
    bjna.a().b(localohj);
    if (localohj.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler != null) {
      AppNetConnInfo.unregisterNetInfoHandler(localohj.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    }
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramObject = (ohj)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
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
    ohj localohj = (ohj)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    Context localContext = this.jdField_a_of_type_AndroidContentContext;
    String str1 = this.jdField_a_of_type_JavaLangString;
    String str2 = this.b;
    String str3 = this.c;
    int i = this.jdField_a_of_type_Int;
    ohb localohb = this.jdField_a_of_type_Ohb;
    if (paramInt == getCount() - 1) {}
    for (boolean bool = true;; bool = false)
    {
      localohj.jdField_a_of_type_AndroidViewView = localohj.a(localContext, str1, str2, str3, i, localohb, bool);
      paramViewGroup.addView(localohj.jdField_a_of_type_AndroidViewView);
      return localohj.jdField_a_of_type_AndroidViewView;
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