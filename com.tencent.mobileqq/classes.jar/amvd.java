public class amvd
{
  private amve jdField_a_of_type_Amve = new amve();
  private amvf jdField_a_of_type_Amvf = new amvf();
  
  public amvd()
  {
    this.jdField_a_of_type_Amve.a();
    this.jdField_a_of_type_Amvf.a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_Amve.c();
    this.jdField_a_of_type_Amvf.c();
  }
  
  public void a(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    if (paramInt1 == 36197)
    {
      this.jdField_a_of_type_Amvf.a(paramInt2, paramArrayOfFloat1, paramArrayOfFloat2);
      return;
    }
    if (paramInt1 == 3553)
    {
      this.jdField_a_of_type_Amve.a(paramInt2, paramArrayOfFloat1, paramArrayOfFloat2);
      return;
    }
    throw new RuntimeException("textureType must be GLES11Ext.GL_TEXTURE_EXTERNAL_OES or GLES20.GL_TEXTURE_2D.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amvd
 * JD-Core Version:    0.7.0.1
 */