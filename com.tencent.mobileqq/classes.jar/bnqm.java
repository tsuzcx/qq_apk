import dov.com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture;

public class bnqm
{
  private static bnqm jdField_a_of_type_Bnqm = new bnqm();
  private static String jdField_a_of_type_JavaLangString;
  private bnqn jdField_a_of_type_Bnqn;
  
  private bnqm()
  {
    jdField_a_of_type_JavaLangString = getClass().getSimpleName();
  }
  
  public static bnqm a()
  {
    return jdField_a_of_type_Bnqm;
  }
  
  private void a(boolean paramBoolean1, int paramInt, String paramString, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_Bnqn != null)
    {
      if (paramBoolean1) {
        this.jdField_a_of_type_Bnqn.a(paramInt, paramString, paramBoolean2);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Bnqn.b(paramInt, paramString, paramBoolean2);
  }
  
  public boolean a(Object paramObject, int paramInt, String paramString)
  {
    if ((paramObject instanceof AudioCapture)) {}
    switch (paramInt)
    {
    default: 
      return true;
    }
    a(true, 2001, alud.a(2131704589) + 2001 + "）", true);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnqm
 * JD-Core Version:    0.7.0.1
 */