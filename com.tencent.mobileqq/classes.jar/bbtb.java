import com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture;

public class bbtb
{
  private static bbtb jdField_a_of_type_Bbtb = new bbtb();
  private static String jdField_a_of_type_JavaLangString;
  private bbtc jdField_a_of_type_Bbtc;
  
  private bbtb()
  {
    jdField_a_of_type_JavaLangString = getClass().getSimpleName();
  }
  
  public static bbtb a()
  {
    return jdField_a_of_type_Bbtb;
  }
  
  private void a(boolean paramBoolean1, int paramInt, String paramString, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_Bbtc != null)
    {
      if (paramBoolean1) {
        this.jdField_a_of_type_Bbtc.a(paramInt, paramString, paramBoolean2);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Bbtc.b(paramInt, paramString, paramBoolean2);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bbtc = null;
  }
  
  public void a(bbtc parambbtc)
  {
    this.jdField_a_of_type_Bbtc = parambbtc;
  }
  
  public boolean a(Object paramObject, int paramInt, String paramString)
  {
    if ((paramObject instanceof AudioCapture)) {}
    switch (paramInt)
    {
    default: 
      return true;
    }
    a(true, 2001, amtj.a(2131703326) + 2001 + "）", true);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbtb
 * JD-Core Version:    0.7.0.1
 */