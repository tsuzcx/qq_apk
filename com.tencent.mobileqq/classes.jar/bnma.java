import dov.com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture;

public class bnma
{
  private static bnma jdField_a_of_type_Bnma = new bnma();
  private static String jdField_a_of_type_JavaLangString;
  private bnmb jdField_a_of_type_Bnmb;
  
  private bnma()
  {
    jdField_a_of_type_JavaLangString = getClass().getSimpleName();
  }
  
  public static bnma a()
  {
    return jdField_a_of_type_Bnma;
  }
  
  private void a(boolean paramBoolean1, int paramInt, String paramString, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_Bnmb != null)
    {
      if (paramBoolean1) {
        this.jdField_a_of_type_Bnmb.a(paramInt, paramString, paramBoolean2);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Bnmb.b(paramInt, paramString, paramBoolean2);
  }
  
  public boolean a(Object paramObject, int paramInt, String paramString)
  {
    if ((paramObject instanceof AudioCapture)) {}
    switch (paramInt)
    {
    default: 
      return true;
    }
    a(true, 2001, alpo.a(2131704577) + 2001 + "）", true);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnma
 * JD-Core Version:    0.7.0.1
 */