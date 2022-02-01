package com.tencent.gdtad.basics.adbox;

import android.content.Context;

public class GdtAdBoxBuilder
{
  private Context jdField_a_of_type_AndroidContentContext;
  private GdtAdBoxData jdField_a_of_type_ComTencentGdtadBasicsAdboxGdtAdBoxData;
  private GdtAdBoxListener jdField_a_of_type_ComTencentGdtadBasicsAdboxGdtAdBoxListener;
  
  GdtAdBoxBuilder(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public GdtAdBox a()
  {
    GdtAdBox localGdtAdBox = new GdtAdBox();
    localGdtAdBox.a(this.jdField_a_of_type_AndroidContentContext);
    localGdtAdBox.a(this.jdField_a_of_type_ComTencentGdtadBasicsAdboxGdtAdBoxData);
    localGdtAdBox.a(this.jdField_a_of_type_ComTencentGdtadBasicsAdboxGdtAdBoxListener);
    return localGdtAdBox;
  }
  
  public GdtAdBoxBuilder a(GdtAdBoxData paramGdtAdBoxData)
  {
    this.jdField_a_of_type_ComTencentGdtadBasicsAdboxGdtAdBoxData = paramGdtAdBoxData;
    return this;
  }
  
  public GdtAdBoxBuilder a(GdtAdBoxListener paramGdtAdBoxListener)
  {
    this.jdField_a_of_type_ComTencentGdtadBasicsAdboxGdtAdBoxListener = paramGdtAdBoxListener;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.basics.adbox.GdtAdBoxBuilder
 * JD-Core Version:    0.7.0.1
 */