package com.tencent.av.opengl.multiplevideos.renderbase;

import android.util.Log;

public abstract class RenderObject
{
  protected RenderContext a;
  private String a;
  
  public RenderObject()
  {
    this.jdField_a_of_type_JavaLangString = (getClass().getSimpleName() + "-" + Integer.toHexString(hashCode()));
  }
  
  public void a(RenderContext paramRenderContext)
  {
    Log.d(this.jdField_a_of_type_JavaLangString, "init");
    this.jdField_a_of_type_ComTencentAvOpenglMultiplevideosRenderbaseRenderContext = paramRenderContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.opengl.multiplevideos.renderbase.RenderObject
 * JD-Core Version:    0.7.0.1
 */