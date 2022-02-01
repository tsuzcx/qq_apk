public abstract class bpor
  extends biht
{
  public abstract void a(int paramInt);
  
  public abstract void a(String paramString);
  
  public abstract void a(String paramString, int paramInt);
  
  public abstract void a(String paramString, boolean paramBoolean);
  
  public abstract void a(String paramString, boolean paramBoolean, int paramInt);
  
  public void onCancel(bihu parambihu)
  {
    super.onCancel(parambihu);
    a(parambihu.jdField_a_of_type_JavaLangString);
  }
  
  public void onDone(bihu parambihu)
  {
    String str = parambihu.jdField_a_of_type_JavaLangString;
    if (parambihu.a() == 3) {}
    for (boolean bool = true;; bool = false)
    {
      a(str, bool, parambihu.jdField_a_of_type_Int);
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
  
  public void onProgress(bihu parambihu)
  {
    super.onProgress(parambihu);
    int i = (int)parambihu.jdField_a_of_type_Float;
    a(parambihu.jdField_a_of_type_JavaLangString, i);
  }
  
  public boolean onStart(bihu parambihu)
  {
    super.onStart(parambihu);
    a(parambihu.jdField_a_of_type_JavaLangString, true);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpor
 * JD-Core Version:    0.7.0.1
 */