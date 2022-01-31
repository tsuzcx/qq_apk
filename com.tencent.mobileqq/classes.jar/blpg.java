public abstract class blpg
  extends bdvu
{
  public abstract void a(int paramInt);
  
  public abstract void a(String paramString);
  
  public abstract void a(String paramString, int paramInt);
  
  public abstract void a(String paramString, boolean paramBoolean);
  
  public abstract void a(String paramString, boolean paramBoolean, int paramInt);
  
  public void onCancel(bdvv parambdvv)
  {
    super.onCancel(parambdvv);
    a(parambdvv.jdField_a_of_type_JavaLangString);
  }
  
  public void onDone(bdvv parambdvv)
  {
    String str = parambdvv.jdField_a_of_type_JavaLangString;
    if (parambdvv.a() == 3) {}
    for (boolean bool = true;; bool = false)
    {
      a(str, bool, parambdvv.jdField_a_of_type_Int);
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
  
  public void onProgress(bdvv parambdvv)
  {
    super.onProgress(parambdvv);
    int i = (int)parambdvv.jdField_a_of_type_Float;
    a(parambdvv.jdField_a_of_type_JavaLangString, i);
  }
  
  public boolean onStart(bdvv parambdvv)
  {
    super.onStart(parambdvv);
    a(parambdvv.jdField_a_of_type_JavaLangString, true);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blpg
 * JD-Core Version:    0.7.0.1
 */