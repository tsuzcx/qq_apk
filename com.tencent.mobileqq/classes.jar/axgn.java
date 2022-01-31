import com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture;

public class axgn
{
  private static axgn jdField_a_of_type_Axgn = new axgn();
  private static String jdField_a_of_type_JavaLangString;
  private axgo jdField_a_of_type_Axgo;
  
  private axgn()
  {
    jdField_a_of_type_JavaLangString = getClass().getSimpleName();
  }
  
  public static axgn a()
  {
    return jdField_a_of_type_Axgn;
  }
  
  private void a(boolean paramBoolean1, int paramInt, String paramString, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_Axgo != null)
    {
      if (paramBoolean1) {
        this.jdField_a_of_type_Axgo.a(paramInt, paramString, paramBoolean2);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Axgo.b(paramInt, paramString, paramBoolean2);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Axgo = null;
  }
  
  public void a(axgo paramaxgo)
  {
    this.jdField_a_of_type_Axgo = paramaxgo;
  }
  
  public boolean a(Object paramObject, int paramInt, String paramString)
  {
    if ((paramObject instanceof AudioCapture)) {}
    switch (paramInt)
    {
    default: 
      return true;
    }
    a(true, 2001, ajyc.a(2131704197) + 2001 + "）", true);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axgn
 * JD-Core Version:    0.7.0.1
 */