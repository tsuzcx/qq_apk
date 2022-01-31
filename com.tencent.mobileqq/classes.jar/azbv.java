import com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture;

public class azbv
{
  private static azbv jdField_a_of_type_Azbv = new azbv();
  private static String jdField_a_of_type_JavaLangString;
  private azbw jdField_a_of_type_Azbw;
  
  private azbv()
  {
    jdField_a_of_type_JavaLangString = getClass().getSimpleName();
  }
  
  public static azbv a()
  {
    return jdField_a_of_type_Azbv;
  }
  
  private void a(boolean paramBoolean1, int paramInt, String paramString, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_Azbw != null)
    {
      if (paramBoolean1) {
        this.jdField_a_of_type_Azbw.a(paramInt, paramString, paramBoolean2);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Azbw.b(paramInt, paramString, paramBoolean2);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Azbw = null;
  }
  
  public void a(azbw paramazbw)
  {
    this.jdField_a_of_type_Azbw = paramazbw;
  }
  
  public boolean a(Object paramObject, int paramInt, String paramString)
  {
    if ((paramObject instanceof AudioCapture)) {}
    switch (paramInt)
    {
    default: 
      return true;
    }
    a(true, 2001, alpo.a(2131704580) + 2001 + "）", true);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azbv
 * JD-Core Version:    0.7.0.1
 */