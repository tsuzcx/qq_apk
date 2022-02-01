import com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture;

public class bczw
{
  private static bczw jdField_a_of_type_Bczw = new bczw();
  private static String jdField_a_of_type_JavaLangString;
  private bczx jdField_a_of_type_Bczx;
  
  private bczw()
  {
    jdField_a_of_type_JavaLangString = getClass().getSimpleName();
  }
  
  public static bczw a()
  {
    return jdField_a_of_type_Bczw;
  }
  
  private void a(boolean paramBoolean1, int paramInt, String paramString, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_Bczx != null)
    {
      if (paramBoolean1) {
        this.jdField_a_of_type_Bczx.a(paramInt, paramString, paramBoolean2);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Bczx.b(paramInt, paramString, paramBoolean2);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bczx = null;
  }
  
  public void a(bczx parambczx)
  {
    this.jdField_a_of_type_Bczx = parambczx;
  }
  
  public boolean a(Object paramObject, int paramInt, String paramString)
  {
    if ((paramObject instanceof AudioCapture)) {}
    switch (paramInt)
    {
    default: 
      return true;
    }
    a(true, 2001, anvx.a(2131703677) + 2001 + "）", true);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bczw
 * JD-Core Version:    0.7.0.1
 */