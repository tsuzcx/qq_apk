package com.tencent.gdtad.api.adbox;

import android.content.Context;

public class GdtAdBox
{
  private Context jdField_a_of_type_AndroidContentContext;
  private GdtAdBoxData jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBoxData;
  private GdtAdBoxDialog jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBoxDialog;
  private GdtAdBoxListener jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBoxListener;
  
  public static GdtAdBoxBuilder a(Context paramContext)
  {
    return new GdtAdBoxBuilder(paramContext);
  }
  
  public GdtAdBoxData a()
  {
    return this.jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBoxData;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBoxDialog = new GdtAdBoxDialogCompact(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBoxDialog.a(this);
    this.jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBoxDialog.show();
  }
  
  void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  void a(GdtAdBoxData paramGdtAdBoxData)
  {
    this.jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBoxData = paramGdtAdBoxData;
  }
  
  void a(GdtAdBoxListener paramGdtAdBoxListener)
  {
    this.jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBoxListener = paramGdtAdBoxListener;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBoxDialog != null) && (this.jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBoxDialog.isShowing()))
    {
      this.jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBoxDialog.dismiss();
      this.jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBoxDialog = null;
    }
    this.jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBoxListener = null;
    this.jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBoxData = null;
    this.jdField_a_of_type_AndroidContentContext = null;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBoxListener != null) {
      this.jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBoxListener.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.api.adbox.GdtAdBox
 * JD-Core Version:    0.7.0.1
 */