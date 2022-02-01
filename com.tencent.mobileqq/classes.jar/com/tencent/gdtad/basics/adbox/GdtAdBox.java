package com.tencent.gdtad.basics.adbox;

import android.content.Context;
import android.view.Window;
import com.tencent.biz.subscribe.utils.NavigationBarUtil;

public class GdtAdBox
  implements IGdtAdBox
{
  private Context jdField_a_of_type_AndroidContentContext;
  private GdtAdBoxData jdField_a_of_type_ComTencentGdtadBasicsAdboxGdtAdBoxData;
  private GdtAdBoxDialog jdField_a_of_type_ComTencentGdtadBasicsAdboxGdtAdBoxDialog;
  private GdtAdBoxListener jdField_a_of_type_ComTencentGdtadBasicsAdboxGdtAdBoxListener;
  
  public static GdtAdBoxBuilder a(Context paramContext)
  {
    return new GdtAdBoxBuilder(paramContext);
  }
  
  public GdtAdBoxData a()
  {
    return this.jdField_a_of_type_ComTencentGdtadBasicsAdboxGdtAdBoxData;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentGdtadBasicsAdboxGdtAdBoxDialog = new GdtAdBoxDialogCompact(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentGdtadBasicsAdboxGdtAdBoxDialog.a(this);
    Window localWindow = this.jdField_a_of_type_ComTencentGdtadBasicsAdboxGdtAdBoxDialog.getWindow();
    NavigationBarUtil.a(localWindow);
    NavigationBarUtil.b(localWindow);
    this.jdField_a_of_type_ComTencentGdtadBasicsAdboxGdtAdBoxDialog.show();
    NavigationBarUtil.c(localWindow);
  }
  
  void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  void a(GdtAdBoxData paramGdtAdBoxData)
  {
    this.jdField_a_of_type_ComTencentGdtadBasicsAdboxGdtAdBoxData = paramGdtAdBoxData;
  }
  
  void a(GdtAdBoxListener paramGdtAdBoxListener)
  {
    this.jdField_a_of_type_ComTencentGdtadBasicsAdboxGdtAdBoxListener = paramGdtAdBoxListener;
  }
  
  public void b()
  {
    GdtAdBoxDialog localGdtAdBoxDialog = this.jdField_a_of_type_ComTencentGdtadBasicsAdboxGdtAdBoxDialog;
    if ((localGdtAdBoxDialog != null) && (localGdtAdBoxDialog.isShowing()))
    {
      this.jdField_a_of_type_ComTencentGdtadBasicsAdboxGdtAdBoxDialog.dismiss();
      this.jdField_a_of_type_ComTencentGdtadBasicsAdboxGdtAdBoxDialog = null;
    }
    this.jdField_a_of_type_ComTencentGdtadBasicsAdboxGdtAdBoxListener = null;
    this.jdField_a_of_type_ComTencentGdtadBasicsAdboxGdtAdBoxData = null;
    this.jdField_a_of_type_AndroidContentContext = null;
  }
  
  public void c()
  {
    GdtAdBoxListener localGdtAdBoxListener = this.jdField_a_of_type_ComTencentGdtadBasicsAdboxGdtAdBoxListener;
    if (localGdtAdBoxListener != null) {
      localGdtAdBoxListener.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.basics.adbox.GdtAdBox
 * JD-Core Version:    0.7.0.1
 */