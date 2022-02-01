import dov.com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture;

public class bprp
{
  private static bprp jdField_a_of_type_Bprp = new bprp();
  private static String jdField_a_of_type_JavaLangString;
  private bprq jdField_a_of_type_Bprq;
  
  private bprp()
  {
    jdField_a_of_type_JavaLangString = getClass().getSimpleName();
  }
  
  public static bprp a()
  {
    return jdField_a_of_type_Bprp;
  }
  
  private void a(boolean paramBoolean1, int paramInt, String paramString, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_Bprq != null)
    {
      if (paramBoolean1) {
        this.jdField_a_of_type_Bprq.a(paramInt, paramString, paramBoolean2);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Bprq.b(paramInt, paramString, paramBoolean2);
  }
  
  public boolean a(Object paramObject, int paramInt, String paramString)
  {
    if ((paramObject instanceof AudioCapture)) {}
    switch (paramInt)
    {
    default: 
      return true;
    }
    a(true, 2001, anvx.a(2131703674) + 2001 + "）", true);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bprp
 * JD-Core Version:    0.7.0.1
 */