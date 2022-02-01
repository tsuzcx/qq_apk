import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class arew
{
  private static aret jdField_a_of_type_Aret;
  private static arfj jdField_a_of_type_Arfj;
  private static arfm jdField_a_of_type_Arfm;
  private static final String jdField_a_of_type_JavaLangString = arew.class.getSimpleName();
  private int jdField_a_of_type_Int;
  private final SparseArray<arfh> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private arfa jdField_a_of_type_Arfa;
  private arfb jdField_a_of_type_Arfb;
  private arfd jdField_a_of_type_Arfd;
  private arfe jdField_a_of_type_Arfe;
  private arff jdField_a_of_type_Arff;
  private arfg jdField_a_of_type_Arfg;
  private arfi jdField_a_of_type_Arfi;
  private arfq jdField_a_of_type_Arfq = new arfq();
  private final argc<Drawable> jdField_a_of_type_Argc;
  private List<arfn> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  private arew(arey paramarey)
  {
    this.jdField_a_of_type_Boolean = arey.a(paramarey);
    this.jdField_a_of_type_Arfg = arey.a(paramarey);
    this.jdField_a_of_type_Arfe = arey.a(paramarey);
    this.jdField_a_of_type_Arfd = arey.a(paramarey);
    jdField_a_of_type_Arfj = arey.a(paramarey);
    this.jdField_a_of_type_Arfi = arey.a(paramarey);
    this.jdField_a_of_type_Arff = paramarey.jdField_a_of_type_Arff;
    this.jdField_a_of_type_Arfb = paramarey.jdField_a_of_type_Arfb;
    this.jdField_a_of_type_Arfa = arey.a(paramarey);
    this.jdField_a_of_type_Int = arey.a(paramarey);
    this.b = arey.b(paramarey);
    this.jdField_a_of_type_Argc = new argc();
    a(paramarey);
    c();
  }
  
  public static aret a()
  {
    if (jdField_a_of_type_Aret == null) {}
    try
    {
      if (jdField_a_of_type_Aret == null) {
        jdField_a_of_type_Aret = new aret();
      }
      return jdField_a_of_type_Aret;
    }
    finally {}
  }
  
  public static arey a()
  {
    return new arey(null);
  }
  
  public static arfm a()
  {
    if (jdField_a_of_type_Arfm == null) {}
    try
    {
      if ((jdField_a_of_type_Arfm == null) && (jdField_a_of_type_Arfj != null)) {
        jdField_a_of_type_Arfm = jdField_a_of_type_Arfj.a();
      }
      if (jdField_a_of_type_Arfm == null) {
        jdField_a_of_type_Arfm = new arfm();
      }
      return jdField_a_of_type_Arfm;
    }
    finally {}
  }
  
  private void a(arey paramarey)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.addAll(arey.a(paramarey));
  }
  
  private void c()
  {
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Arfg == null)) {
      throw new IllegalArgumentException("Danmaku module need an IDanmakuPlayTimeSupplier or is live setter for computing timeline");
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Arff != null) {
      return this.jdField_a_of_type_Arff.a();
    }
    return (int)Math.ceil(argo.a(a()));
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_Arfg == null) {
      return -1L;
    }
    return this.jdField_a_of_type_Arfg.a();
  }
  
  public aren a(int paramInt)
  {
    Object localObject;
    if (paramInt == -2147483647) {
      localObject = new arev(this);
    }
    aren localaren;
    do
    {
      return localObject;
      localaren = null;
      if (this.jdField_a_of_type_Arfb != null) {
        localaren = this.jdField_a_of_type_Arfb.a(this, paramInt);
      }
      localObject = localaren;
    } while (localaren != null);
    return new ares(this);
  }
  
  public arfh a(int paramInt)
  {
    Object localObject3 = (arfh)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    Object localObject1 = localObject3;
    if (localObject3 == null) {}
    try
    {
      localObject3 = (arfh)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        localObject1 = localObject3;
        if (this.jdField_a_of_type_Arfi != null)
        {
          localObject1 = this.jdField_a_of_type_Arfi.a(paramInt);
          this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject1);
        }
      }
      localObject3 = localObject1;
      if (localObject1 == null) {
        localObject3 = a();
      }
      return localObject3;
    }
    finally {}
  }
  
  public arfn a(aren paramaren)
  {
    Iterator localIterator = a().iterator();
    Object localObject;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = (arfn)localIterator.next();
    } while (!((arfn)localObject).a(paramaren));
    for (paramaren = (aren)localObject;; paramaren = null)
    {
      localObject = paramaren;
      if (paramaren == null) {
        localObject = this.jdField_a_of_type_Arfq;
      }
      return localObject;
    }
  }
  
  public List<arfn> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Arfa != null) {
      this.jdField_a_of_type_Arfa.a();
    }
  }
  
  public void a(aren paramaren)
  {
    if (this.jdField_a_of_type_Arfe != null) {
      this.jdField_a_of_type_Arfe.a(paramaren);
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Boolean) || (a() < 0L);
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Argc.a(0);
  }
  
  public boolean b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arew
 * JD-Core Version:    0.7.0.1
 */