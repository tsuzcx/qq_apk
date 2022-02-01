public abstract class bomw
  extends bhhe
{
  public abstract void a(int paramInt);
  
  public abstract void a(String paramString);
  
  public abstract void a(String paramString, int paramInt);
  
  public abstract void a(String paramString, boolean paramBoolean);
  
  public abstract void a(String paramString, boolean paramBoolean, int paramInt);
  
  public void onCancel(bhhf parambhhf)
  {
    super.onCancel(parambhhf);
    a(parambhhf.jdField_a_of_type_JavaLangString);
  }
  
  public void onDone(bhhf parambhhf)
  {
    String str = parambhhf.jdField_a_of_type_JavaLangString;
    if (parambhhf.a() == 3) {}
    for (boolean bool = true;; bool = false)
    {
      a(str, bool, parambhhf.jdField_a_of_type_Int);
      return;
    }
  }
  
  public void onNetMobile2None()
  {
    super.onNetMobile2None();
    a(2);
  }
  
  public void onNetWifi2Mobile()
  {
    super.onNetWifi2Mobile();
    a(1);
  }
  
  public void onNetWifi2None()
  {
    super.onNetWifi2None();
    a(3);
  }
  
  public void onProgress(bhhf parambhhf)
  {
    super.onProgress(parambhhf);
    int i = (int)parambhhf.jdField_a_of_type_Float;
    a(parambhhf.jdField_a_of_type_JavaLangString, i);
  }
  
  public boolean onStart(bhhf parambhhf)
  {
    super.onStart(parambhhf);
    a(parambhhf.jdField_a_of_type_JavaLangString, true);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bomw
 * JD-Core Version:    0.7.0.1
 */