public abstract class bmte
  extends bgod
{
  public static final int MOBILE_TO_NONE = 2;
  public static final int WIFI_TO_MOBILE = 1;
  public static final int WIFI_TO_NONE = 3;
  
  public void onCancel(bgoe parambgoe)
  {
    super.onCancel(parambgoe);
    onCancel(parambgoe.jdField_a_of_type_JavaLangString);
  }
  
  public abstract void onCancel(String paramString);
  
  public void onDone(bgoe parambgoe)
  {
    String str = parambgoe.jdField_a_of_type_JavaLangString;
    if (parambgoe.a() == 3) {}
    for (boolean bool = true;; bool = false)
    {
      onFinish(str, bool, parambgoe.jdField_a_of_type_Int);
      return;
    }
  }
  
  public abstract void onFinish(String paramString, boolean paramBoolean, int paramInt);
  
  public abstract void onNetChange(int paramInt);
  
  public void onNetMobile2None()
  {
    super.onNetMobile2None();
    onNetChange(2);
  }
  
  public void onNetWifi2Mobile()
  {
    super.onNetWifi2Mobile();
    onNetChange(1);
  }
  
  public void onNetWifi2None()
  {
    super.onNetWifi2None();
    onNetChange(3);
  }
  
  public void onProgress(bgoe parambgoe)
  {
    super.onProgress(parambgoe);
    int i = (int)parambgoe.jdField_a_of_type_Float;
    onProgress(parambgoe.jdField_a_of_type_JavaLangString, i);
  }
  
  public abstract void onProgress(String paramString, int paramInt);
  
  public abstract void onStart(String paramString, boolean paramBoolean);
  
  public boolean onStart(bgoe parambgoe)
  {
    super.onStart(parambgoe);
    onStart(parambgoe.jdField_a_of_type_JavaLangString, true);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmte
 * JD-Core Version:    0.7.0.1
 */