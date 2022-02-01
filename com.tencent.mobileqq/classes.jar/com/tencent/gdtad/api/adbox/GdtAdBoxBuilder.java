package com.tencent.gdtad.api.adbox;

import android.content.Context;

public class GdtAdBoxBuilder
{
  private Context jdField_a_of_type_AndroidContentContext;
  private GdtAdBoxData jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBoxData;
  private GdtAdBoxListener jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBoxListener;
  
  GdtAdBoxBuilder(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public GdtAdBox a()
  {
    GdtAdBox localGdtAdBox = new GdtAdBox();
    localGdtAdBox.a(this.jdField_a_of_type_AndroidContentContext);
    localGdtAdBox.a(this.jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBoxData);
    localGdtAdBox.a(this.jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBoxListener);
    return localGdtAdBox;
  }
  
  public GdtAdBoxBuilder a(GdtAdBoxData paramGdtAdBoxData)
  {
    this.jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBoxData = paramGdtAdBoxData;
    return this;
  }
  
  public GdtAdBoxBuilder a(GdtAdBoxListener paramGdtAdBoxListener)
  {
    this.jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBoxListener = paramGdtAdBoxListener;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.api.adbox.GdtAdBoxBuilder
 * JD-Core Version:    0.7.0.1
 */