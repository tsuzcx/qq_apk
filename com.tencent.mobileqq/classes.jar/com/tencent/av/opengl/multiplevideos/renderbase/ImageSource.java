package com.tencent.av.opengl.multiplevideos.renderbase;

import android.util.Log;
import java.util.LinkedList;
import java.util.List;

public abstract class ImageSource
{
  ImageSource.OutputDelegate jdField_a_of_type_ComTencentAvOpenglMultiplevideosRenderbaseImageSource$OutputDelegate;
  private RenderContext jdField_a_of_type_ComTencentAvOpenglMultiplevideosRenderbaseRenderContext;
  private String jdField_a_of_type_JavaLangString = getClass().getSimpleName() + "-" + Integer.toHexString(hashCode());
  private List<Filter> jdField_a_of_type_JavaUtilList = new LinkedList();
  
  public ImageSource()
  {
    Log.d(this.jdField_a_of_type_JavaLangString, "ImageSource: ");
  }
  
  public ImageSource a(Filter paramFilter)
  {
    Log.d(this.jdField_a_of_type_JavaLangString, "addTarget: " + paramFilter);
    this.jdField_a_of_type_JavaUtilList.add(paramFilter);
    paramFilter.a(this.jdField_a_of_type_ComTencentAvOpenglMultiplevideosRenderbaseRenderContext);
    return this;
  }
  
  protected abstract void a();
  
  public void a(ImageSource.OutputDelegate paramOutputDelegate)
  {
    this.jdField_a_of_type_ComTencentAvOpenglMultiplevideosRenderbaseImageSource$OutputDelegate = paramOutputDelegate;
  }
  
  protected abstract void b();
  
  protected void b(List<RefFrame> paramList, long paramLong)
  {
    int k = 0;
    if (this.jdField_a_of_type_JavaUtilList.size() == 0) {}
    for (;;)
    {
      return;
      int i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i >= paramList.size()) {
          break;
        }
        ((RefFrame)paramList.get(i)).a(this.jdField_a_of_type_JavaUtilList.size());
        i += 1;
      }
      while (j < this.jdField_a_of_type_JavaUtilList.size())
      {
        ((Filter)this.jdField_a_of_type_JavaUtilList.get(j)).a(paramList, paramLong);
        j += 1;
      }
    }
  }
  
  public void c()
  {
    Log.d(this.jdField_a_of_type_JavaLangString, "isolated: ");
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void d()
  {
    Log.d(this.jdField_a_of_type_JavaLangString, "init");
    this.jdField_a_of_type_ComTencentAvOpenglMultiplevideosRenderbaseRenderContext = new RenderContext();
    this.jdField_a_of_type_ComTencentAvOpenglMultiplevideosRenderbaseRenderContext.a = this;
    a();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      ((Filter)this.jdField_a_of_type_JavaUtilList.get(i)).a(this.jdField_a_of_type_ComTencentAvOpenglMultiplevideosRenderbaseRenderContext);
      i += 1;
    }
  }
  
  public void e()
  {
    Log.d(this.jdField_a_of_type_JavaLangString, "destroy");
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      ((Filter)this.jdField_a_of_type_JavaUtilList.get(i)).c();
      i += 1;
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.opengl.multiplevideos.renderbase.ImageSource
 * JD-Core Version:    0.7.0.1
 */