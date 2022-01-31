import android.os.Handler;
import android.os.Looper;
import android.webkit.ValueCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class bfau
  extends bfay<Integer, Integer>
{
  public static final Integer a;
  public static final Integer b = Integer.valueOf(2);
  protected Handler a;
  private List<bfax> a;
  
  static
  {
    jdField_a_of_type_JavaLangInteger = Integer.valueOf(1);
  }
  
  public bfau()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public void a(bfax parambfax)
  {
    try
    {
      if (!this.jdField_a_of_type_JavaUtilList.contains(parambfax)) {
        this.jdField_a_of_type_JavaUtilList.add(parambfax);
      }
      return;
    }
    finally
    {
      parambfax = finally;
      throw parambfax;
    }
  }
  
  public void a(bfaz parambfaz)
  {
    bfaz localbfaz = a();
    super.a(parambfaz);
    if (parambfaz != localbfaz) {
      a(localbfaz, parambfaz);
    }
  }
  
  protected void a(bfaz parambfaz1, bfaz parambfaz2)
  {
    try
    {
      parambfaz1 = this.jdField_a_of_type_JavaUtilList.iterator();
      while (parambfaz1.hasNext())
      {
        parambfaz2 = (bfax)parambfaz1.next();
        if (parambfaz2 != null) {
          parambfaz2.a();
        }
      }
    }
    finally {}
  }
  
  public void a(Integer paramInteger)
  {
    Object localObject = a();
    if ((localObject instanceof bfav))
    {
      localObject = (bfav)localObject;
      if ((bfav.a((bfav)localObject) != null) && (jdField_a_of_type_JavaLangInteger == paramInteger)) {
        a(bfav.a((bfav)localObject));
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
 * Qualified Name:     bfau
 * JD-Core Version:    0.7.0.1
 */