public abstract class blts
  extends bead
{
  public abstract void a(int paramInt);
  
  public abstract void a(String paramString);
  
  public abstract void a(String paramString, int paramInt);
  
  public abstract void a(String paramString, boolean paramBoolean);
  
  public abstract void a(String paramString, boolean paramBoolean, int paramInt);
  
  public void onCancel(beae parambeae)
  {
    super.onCancel(parambeae);
    a(parambeae.jdField_a_of_type_JavaLangString);
  }
  
  public void onDone(beae parambeae)
  {
    String str = parambeae.jdField_a_of_type_JavaLangString;
    if (parambeae.a() == 3) {}
    for (boolean bool = true;; bool = false)
    {
      a(str, bool, parambeae.jdField_a_of_type_Int);
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
  
  public void onProgress(beae parambeae)
  {
    super.onProgress(parambeae);
    int i = (int)parambeae.jdField_a_of_type_Float;
    a(parambeae.jdField_a_of_type_JavaLangString, i);
  }
  
  public boolean onStart(beae parambeae)
  {
    super.onStart(parambeae);
    a(parambeae.jdField_a_of_type_JavaLangString, true);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blts
 * JD-Core Version:    0.7.0.1
 */