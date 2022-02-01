package com.tencent.mobileqq.ar.view;

import android.content.Context;
import com.tencent.mobileqq.app.HardCodeUtil;
import java.util.ArrayList;

public class ScanEntryProviderViewBuilder
{
  private int jdField_a_of_type_Int;
  private ArrayList<ScanEntryProviderViewBuilder.ScanEntryProviderViewItem> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public boolean a;
  private final int[] jdField_a_of_type_ArrayOfInt = { 2131374641, 2131372051, 2131362887 };
  private final String[] jdField_a_of_type_ArrayOfJavaLangString = { HardCodeUtil.a(2131713432), HardCodeUtil.a(2131718411), "AR" };
  public boolean b;
  private final int[] b;
  public boolean c;
  private final int[] c;
  private final int[] d = { 2130844868, 2130844869, 2130844870, 2130844871, 2130844872, 2130844873, 2130844874, 2130844875 };
  
  public ScanEntryProviderViewBuilder(int paramInt)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_b_of_type_ArrayOfInt = new int[] { 2130844876, 2130844877, 2130844878, 2130844879, 2130844880, 2130844881, 2130844882, 2130844883 };
    this.jdField_c_of_type_ArrayOfInt = new int[] { 2130844851, 2130844852, 2130844853, 2130844854, 2130844855, 2130844856, 2130844857, 2130844858 };
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a()
  {
    return this.jdField_b_of_type_ArrayOfInt.length;
  }
  
  public int a(int paramInt)
  {
    if (paramInt == 1) {
      return 0;
    }
    if (paramInt == 2) {
      return 1;
    }
    return 2;
  }
  
  public ScanEntryProviderView a(int paramInt, Context paramContext, ScanEntryContainerViewListener paramScanEntryContainerViewListener)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return null;
        }
        return new ARScanEntryView(paramContext, paramScanEntryContainerViewListener);
      }
      return new OCRScanEntryView(paramContext, paramScanEntryContainerViewListener);
    }
    return new QRScanEntryView(paramContext, paramScanEntryContainerViewListener);
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
        this.jdField_a_of_type_JavaUtilArrayList.add(new ScanEntryProviderViewBuilder.ScanEntryProviderViewItem(1, HardCodeUtil.a(2131713433)));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ScanEntryProviderViewBuilder
 * JD-Core Version:    0.7.0.1
 */