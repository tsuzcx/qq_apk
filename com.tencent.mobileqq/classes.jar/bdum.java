import android.os.Handler;
import android.os.Looper;
import android.webkit.ValueCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class bdum
  extends bduq<Integer, Integer>
{
  public static final Integer a;
  public static final Integer b = Integer.valueOf(2);
  protected Handler a;
  private List<bdup> a;
  
  static
  {
    jdField_a_of_type_JavaLangInteger = Integer.valueOf(1);
  }
  
  public bdum()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public void a(bdup parambdup)
  {
    try
    {
      if (!this.jdField_a_of_type_JavaUtilList.contains(parambdup)) {
        this.jdField_a_of_type_JavaUtilList.add(parambdup);
      }
      return;
    }
    finally
    {
      parambdup = finally;
      throw parambdup;
    }
  }
  
  public void a(bdur parambdur)
  {
    bdur localbdur = a();
    super.a(parambdur);
    if (parambdur != localbdur) {
      a(localbdur, parambdur);
    }
  }
  
  protected void a(bdur parambdur1, bdur parambdur2)
  {
    try
    {
      parambdur1 = this.jdField_a_of_type_JavaUtilList.iterator();
      while (parambdur1.hasNext())
      {
        parambdur2 = (bdup)parambdur1.next();
        if (parambdur2 != null) {
          parambdur2.a();
        }
      }
    }
    finally {}
  }
  
  public void a(Integer paramInteger)
  {
    Object localObject = a();
    if ((localObject instanceof bdun))
    {
      localObject = (bdun)localObject;
      if ((bdun.a((bdun)localObject) != null) && (jdField_a_of_type_JavaLangInteger == paramInteger)) {
        a(bdun.a((bdun)localObject));
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        super.a(paramInteger);
      }
      return;
    }
  }
  
  public abstract void a(String paramString1, ValueCallback paramValueCallback, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdum
 * JD-Core Version:    0.7.0.1
 */