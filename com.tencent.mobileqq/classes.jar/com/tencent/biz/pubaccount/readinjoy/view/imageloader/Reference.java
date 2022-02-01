package com.tencent.biz.pubaccount.readinjoy.view.imageloader;

import com.tencent.qphone.base.util.QLog;

public class Reference<T>
{
  public static final String a;
  private int jdField_a_of_type_Int;
  private final Releaser<T> jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderReleaser;
  private T jdField_a_of_type_JavaLangObject;
  
  static
  {
    jdField_a_of_type_JavaLangString = "zimage." + Reference.class.getSimpleName();
  }
  
  public Reference(T paramT, Releaser<T> paramReleaser)
  {
    this.jdField_a_of_type_JavaLangObject = paramT;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderReleaser = paramReleaser;
    this.jdField_a_of_type_Int = 1;
  }
  
  public T a()
  {
    try
    {
      Object localObject1 = this.jdField_a_of_type_JavaLangObject;
      return localObject1;
    }
    finally
    {
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_Int += 1;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void b()
  {
    try
    {
      this.jdField_a_of_type_Int -= 1;
      if (this.jdField_a_of_type_Int == 0)
      {
        if (QLog.isColorLevel()) {
          Utils.a("Reference", " decReference 0 " + this.jdField_a_of_type_JavaLangObject);
        }
        if (this.jdField_a_of_type_JavaLangObject != null)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderReleaser.a(this.jdField_a_of_type_JavaLangObject);
          this.jdField_a_of_type_JavaLangObject = null;
        }
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.imageloader.Reference
 * JD-Core Version:    0.7.0.1
 */