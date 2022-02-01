import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.process.ui.NativeUIManager.1;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class anah
{
  private int jdField_a_of_type_Int;
  private WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  public HashMap<String, anag> a;
  
  public anah(Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public anag a(String paramString)
  {
    amzz localamzz = null;
    Object localObject = null;
    if ("Dialog".equals(paramString))
    {
      localamzz = new amzz();
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
        break label38;
      }
    }
    label38:
    for (paramString = localObject;; paramString = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())
    {
      localamzz.a(paramString);
      return localamzz;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilHashMap != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = (anag)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
          if (localObject != null) {
            ((anag)localObject).a();
          }
        }
      }
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
  }
  
  public void a(anag paramanag)
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap != null) && (paramanag != null)) {
      this.jdField_a_of_type_JavaUtilHashMap.remove(paramanag.a());
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = amwn.a(this.jdField_a_of_type_Int);
    if (paramString1 != null)
    {
      paramString1 = paramString1.a();
      if (paramString1 != null) {
        paramString1.runRenderTask(new NativeUIManager.1(this, paramString1, paramString2, paramString3));
      }
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    anag localanag;
    if (!TextUtils.isEmpty(paramString1))
    {
      localanag = null;
      if (this.jdField_a_of_type_JavaUtilHashMap != null) {
        localanag = (anag)this.jdField_a_of_type_JavaUtilHashMap.get(paramString1);
      }
      if (localanag == null) {
        break label45;
      }
      localanag.a(paramString2, paramString4, this);
    }
    label45:
    do
    {
      do
      {
        return;
      } while ("destroy".equals(paramString3));
      localanag = a(paramString1);
    } while (localanag == null);
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, localanag);
    a(paramString1, paramString2, paramString3, paramString4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anah
 * JD-Core Version:    0.7.0.1
 */