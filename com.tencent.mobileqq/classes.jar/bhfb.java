import android.os.Handler;
import android.os.Looper;
import android.webkit.ValueCallback;

public abstract class bhfb
  extends bhfe<Integer, Integer>
{
  public static final Integer a;
  public static final Integer b = Integer.valueOf(2);
  protected Handler a;
  
  static
  {
    jdField_a_of_type_JavaLangInteger = Integer.valueOf(1);
  }
  
  public bhfb()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  public void a(Integer paramInteger)
  {
    Object localObject = getCurrState();
    if ((localObject instanceof bhfc))
    {
      localObject = (bhfc)localObject;
      if ((bhfc.a((bhfc)localObject) != null) && (jdField_a_of_type_JavaLangInteger == paramInteger)) {
        setCurrState(bhfc.a((bhfc)localObject));
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        super.sendEvent(paramInteger);
      }
      return;
    }
  }
  
  public abstract void a(String paramString1, ValueCallback paramValueCallback, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhfb
 * JD-Core Version:    0.7.0.1
 */