import com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture;

public class bche
{
  private static bche jdField_a_of_type_Bche = new bche();
  private static String jdField_a_of_type_JavaLangString;
  private bchf jdField_a_of_type_Bchf;
  
  private bche()
  {
    jdField_a_of_type_JavaLangString = getClass().getSimpleName();
  }
  
  public static bche a()
  {
    return jdField_a_of_type_Bche;
  }
  
  private void a(boolean paramBoolean1, int paramInt, String paramString, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_Bchf != null)
    {
      if (paramBoolean1) {
        this.jdField_a_of_type_Bchf.a(paramInt, paramString, paramBoolean2);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Bchf.b(paramInt, paramString, paramBoolean2);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bchf = null;
  }
  
  public void a(bchf parambchf)
  {
    this.jdField_a_of_type_Bchf = parambchf;
  }
  
  public boolean a(Object paramObject, int paramInt, String paramString)
  {
    if ((paramObject instanceof AudioCapture)) {}
    switch (paramInt)
    {
    default: 
      return true;
    }
    a(true, 2001, anni.a(2131702989) + 2001 + "）", true);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bche
 * JD-Core Version:    0.7.0.1
 */