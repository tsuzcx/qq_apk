import com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture;

public class azge
{
  private static azge jdField_a_of_type_Azge = new azge();
  private static String jdField_a_of_type_JavaLangString;
  private azgf jdField_a_of_type_Azgf;
  
  private azge()
  {
    jdField_a_of_type_JavaLangString = getClass().getSimpleName();
  }
  
  public static azge a()
  {
    return jdField_a_of_type_Azge;
  }
  
  private void a(boolean paramBoolean1, int paramInt, String paramString, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_Azgf != null)
    {
      if (paramBoolean1) {
        this.jdField_a_of_type_Azgf.a(paramInt, paramString, paramBoolean2);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Azgf.b(paramInt, paramString, paramBoolean2);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Azgf = null;
  }
  
  public void a(azgf paramazgf)
  {
    this.jdField_a_of_type_Azgf = paramazgf;
  }
  
  public boolean a(Object paramObject, int paramInt, String paramString)
  {
    if ((paramObject instanceof AudioCapture)) {}
    switch (paramInt)
    {
    default: 
      return true;
    }
    a(true, 2001, alud.a(2131704592) + 2001 + "）", true);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azge
 * JD-Core Version:    0.7.0.1
 */