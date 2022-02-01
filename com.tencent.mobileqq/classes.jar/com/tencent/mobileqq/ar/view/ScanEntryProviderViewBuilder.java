package com.tencent.mobileqq.ar.view;

import android.content.Context;
import com.tencent.mobileqq.app.HardCodeUtil;
import java.util.ArrayList;

public class ScanEntryProviderViewBuilder
{
  private int jdField_a_of_type_Int;
  private ArrayList<ScanEntryProviderViewBuilder.ScanEntryProviderViewItem> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public boolean a;
  private final int[] jdField_a_of_type_ArrayOfInt = { 2131375125, 2131372469, 2131362938 };
  private final String[] jdField_a_of_type_ArrayOfJavaLangString = { HardCodeUtil.a(2131713464), HardCodeUtil.a(2131718693), "AR" };
  public boolean b;
  private final int[] b;
  public boolean c;
  private final int[] c;
  private final int[] d = { 2130844992, 2130844993, 2130844994, 2130844995, 2130844996, 2130844997, 2130844998, 2130844999 };
  
  public ScanEntryProviderViewBuilder(int paramInt)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_b_of_type_ArrayOfInt = new int[] { 2130845000, 2130845001, 2130845002, 2130845003, 2130845004, 2130845005, 2130845006, 2130845007 };
    this.jdField_c_of_type_ArrayOfInt = new int[] { 2130844975, 2130844976, 2130844977, 2130844978, 2130844979, 2130844980, 2130844981, 2130844982 };
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a()
  {
    return this.jdField_b_of_type_ArrayOfInt.length;
  }
  
  public int a(int paramInt)
  {
    int i = 1;
    if (paramInt == 1) {
      i = 0;
    }
    while (paramInt == 2) {
      return i;
    }
    return 2;
  }
  
  public ScanEntryProviderView a(int paramInt, Context paramContext, ScanEntryContainerViewListener paramScanEntryContainerViewListener)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return new QRScanEntryView(paramContext, paramScanEntryContainerViewListener);
    case 3: 
      return new ARScanEntryView(paramContext, paramScanEntryContainerViewListener);
    }
    return new OCRScanEntryView(paramContext, paramScanEntryContainerViewListener);
  }
  
  public ScanEntryProviderViewBuilder.ScanEntryProviderViewItem a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < b())) {
      return (ScanEntryProviderViewBuilder.ScanEntryProviderViewItem)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    }
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Int == 1)
    {
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_JavaUtilArrayList.add(new ScanEntryProviderViewBuilder.ScanEntryProviderViewItem(1, HardCodeUtil.a(2131713465)));
      }
      if (this.jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_JavaUtilArrayList.add(new ScanEntryProviderViewBuilder.ScanEntryProviderViewItem(2, "OCR"));
      }
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_JavaUtilArrayList.add(new ScanEntryProviderViewBuilder.ScanEntryProviderViewItem(3, "AR"));
      }
    }
  }
  
  public int[] a()
  {
    return this.jdField_a_of_type_ArrayOfInt;
  }
  
  public int[] a(int paramInt)
  {
    if (paramInt == 0) {
      return this.jdField_b_of_type_ArrayOfInt;
    }
    if (paramInt == 1) {
      return this.d;
    }
    if (paramInt == 2) {
      return this.jdField_c_of_type_ArrayOfInt;
    }
    return null;
  }
  
  public String[] a()
  {
    return this.jdField_a_of_type_ArrayOfJavaLangString;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ScanEntryProviderViewBuilder
 * JD-Core Version:    0.7.0.1
 */