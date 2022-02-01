public class aotu
{
  private aotv jdField_a_of_type_Aotv = new aotv();
  private aotw jdField_a_of_type_Aotw = new aotw();
  
  public aotu()
  {
    this.jdField_a_of_type_Aotv.a();
    this.jdField_a_of_type_Aotw.a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_Aotv.c();
    this.jdField_a_of_type_Aotw.c();
  }
  
  public void a(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    if (paramInt1 == 36197)
    {
      this.jdField_a_of_type_Aotw.a(paramInt2, paramArrayOfFloat1, paramArrayOfFloat2);
      return;
    }
    if (paramInt1 == 3553)
    {
      this.jdField_a_of_type_Aotv.a(paramInt2, paramArrayOfFloat1, paramArrayOfFloat2);
      return;
    }
    throw new RuntimeException("textureType must be GLES11Ext.GL_TEXTURE_EXTERNAL_OES or GLES20.GL_TEXTURE_2D.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aotu
 * JD-Core Version:    0.7.0.1
 */