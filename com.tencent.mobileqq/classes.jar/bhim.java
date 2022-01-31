public abstract class bhim
  extends batl
{
  public abstract void a(int paramInt);
  
  public abstract void a(String paramString);
  
  public abstract void a(String paramString, int paramInt);
  
  public abstract void a(String paramString, boolean paramBoolean);
  
  public abstract void a(String paramString, boolean paramBoolean, int paramInt);
  
  public void onCancel(batm parambatm)
  {
    super.onCancel(parambatm);
    a(parambatm.jdField_a_of_type_JavaLangString);
  }
  
  public void onDone(batm parambatm)
  {
    String str = parambatm.jdField_a_of_type_JavaLangString;
    if (parambatm.a() == 3) {}
    for (boolean bool = true;; bool = false)
    {
      a(str, bool, parambatm.jdField_a_of_type_Int);
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
  
  public void onProgress(batm parambatm)
  {
    super.onProgress(parambatm);
    int i = (int)parambatm.jdField_a_of_type_Float;
    a(parambatm.jdField_a_of_type_JavaLangString, i);
  }
  
  public boolean onStart(batm parambatm)
  {
    super.onStart(parambatm);
    a(parambatm.jdField_a_of_type_JavaLangString, true);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhim
 * JD-Core Version:    0.7.0.1
 */