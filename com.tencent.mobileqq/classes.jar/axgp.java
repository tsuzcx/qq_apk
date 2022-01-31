import com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture;

public class axgp
{
  private static axgp jdField_a_of_type_Axgp = new axgp();
  private static String jdField_a_of_type_JavaLangString;
  private axgq jdField_a_of_type_Axgq;
  
  private axgp()
  {
    jdField_a_of_type_JavaLangString = getClass().getSimpleName();
  }
  
  public static axgp a()
  {
    return jdField_a_of_type_Axgp;
  }
  
  private void a(boolean paramBoolean1, int paramInt, String paramString, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_Axgq != null)
    {
      if (paramBoolean1) {
        this.jdField_a_of_type_Axgq.a(paramInt, paramString, paramBoolean2);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Axgq.b(paramInt, paramString, paramBoolean2);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Axgq = null;
  }
  
  public void a(axgq paramaxgq)
  {
    this.jdField_a_of_type_Axgq = paramaxgq;
  }
  
  public boolean a(Object paramObject, int paramInt, String paramString)
  {
    if ((paramObject instanceof AudioCapture)) {}
    switch (paramInt)
    {
    default: 
      return true;
    }
    a(true, 2001, ajya.a(2131704208) + 2001 + "）", true);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axgp
 * JD-Core Version:    0.7.0.1
 */