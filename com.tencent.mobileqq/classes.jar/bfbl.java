import android.os.Handler;
import android.os.Looper;
import android.webkit.ValueCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class bfbl
  extends bfbp<Integer, Integer>
{
  public static final Integer a;
  public static final Integer b = Integer.valueOf(2);
  protected Handler a;
  private List<bfbo> a;
  
  static
  {
    jdField_a_of_type_JavaLangInteger = Integer.valueOf(1);
  }
  
  public bfbl()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public void a(bfbo parambfbo)
  {
    try
    {
      if (!this.jdField_a_of_type_JavaUtilList.contains(parambfbo)) {
        this.jdField_a_of_type_JavaUtilList.add(parambfbo);
      }
      return;
    }
    finally
    {
      parambfbo = finally;
      throw parambfbo;
    }
  }
  
  public void a(bfbq parambfbq)
  {
    bfbq localbfbq = a();
    super.a(parambfbq);
    if (parambfbq != localbfbq) {
      a(localbfbq, parambfbq);
    }
  }
  
  protected void a(bfbq parambfbq1, bfbq parambfbq2)
  {
    try
    {
      parambfbq1 = this.jdField_a_of_type_JavaUtilList.iterator();
      while (parambfbq1.hasNext())
      {
        parambfbq2 = (bfbo)parambfbq1.next();
        if (parambfbq2 != null) {
          parambfbq2.a();
        }
      }
    }
    finally {}
  }
  
  public void a(Integer paramInteger)
  {
    Object localObject = a();
    if ((localObject instanceof bfbm))
    {
      localObject = (bfbm)localObject;
      if ((bfbm.a((bfbm)localObject) != null) && (jdField_a_of_type_JavaLangInteger == paramInteger)) {
        a(bfbm.a((bfbm)localObject));
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
 * Qualified Name:     bfbl
 * JD-Core Version:    0.7.0.1
 */