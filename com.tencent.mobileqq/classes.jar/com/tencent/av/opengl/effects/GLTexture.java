package com.tencent.av.opengl.effects;

public class GLTexture
{
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static GLTexture b;
  private static int c = 0;
  public int a;
  private GLTexture jdField_a_of_type_ComTencentAvOpenglEffectsGLTexture;
  public int b;
  
  private GLTexture(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public static GLTexture a(int paramInt1, int paramInt2)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_b_of_type_ComTencentAvOpenglEffectsGLTexture != null)
      {
        GLTexture localGLTexture = jdField_b_of_type_ComTencentAvOpenglEffectsGLTexture;
        jdField_b_of_type_ComTencentAvOpenglEffectsGLTexture = localGLTexture.jdField_a_of_type_ComTencentAvOpenglEffectsGLTexture;
        localGLTexture.jdField_a_of_type_ComTencentAvOpenglEffectsGLTexture = null;
        localGLTexture.jdField_a_of_type_Int = paramInt1;
        localGLTexture.jdField_b_of_type_Int = paramInt2;
        c -= 1;
        return localGLTexture;
      }
      return new GLTexture(paramInt1, paramInt2);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (c < 4)
      {
        this.jdField_a_of_type_ComTencentAvOpenglEffectsGLTexture = jdField_b_of_type_ComTencentAvOpenglEffectsGLTexture;
        jdField_b_of_type_ComTencentAvOpenglEffectsGLTexture = this;
        c += 1;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.opengl.effects.GLTexture
 * JD-Core Version:    0.7.0.1
 */