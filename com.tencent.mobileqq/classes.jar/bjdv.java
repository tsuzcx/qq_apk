public abstract class bjdv
  extends bbwt
{
  public abstract void a(int paramInt);
  
  public abstract void a(String paramString);
  
  public abstract void a(String paramString, int paramInt);
  
  public abstract void a(String paramString, boolean paramBoolean);
  
  public abstract void a(String paramString, boolean paramBoolean, int paramInt);
  
  public void onCancel(bbwu parambbwu)
  {
    super.onCancel(parambbwu);
    a(parambbwu.jdField_a_of_type_JavaLangString);
  }
  
  public void onDone(bbwu parambbwu)
  {
    String str = parambbwu.jdField_a_of_type_JavaLangString;
    if (parambbwu.a() == 3) {}
    for (boolean bool = true;; bool = false)
    {
      a(str, bool, parambbwu.jdField_a_of_type_Int);
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
  
  public void onProgress(bbwu parambbwu)
  {
    super.onProgress(parambbwu);
    int i = (int)parambbwu.jdField_a_of_type_Float;
    a(parambbwu.jdField_a_of_type_JavaLangString, i);
  }
  
  public boolean onStart(bbwu parambbwu)
  {
    super.onStart(parambbwu);
    a(parambbwu.jdField_a_of_type_JavaLangString, true);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjdv
 * JD-Core Version:    0.7.0.1
 */