import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class angj
{
  private static angg jdField_a_of_type_Angg;
  private static angw jdField_a_of_type_Angw;
  private static angz jdField_a_of_type_Angz;
  private static final String jdField_a_of_type_JavaLangString = angj.class.getSimpleName();
  private int jdField_a_of_type_Int;
  private final SparseArray<angu> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private angn jdField_a_of_type_Angn;
  private ango jdField_a_of_type_Ango;
  private angq jdField_a_of_type_Angq;
  private angr jdField_a_of_type_Angr;
  private angs jdField_a_of_type_Angs;
  private angt jdField_a_of_type_Angt;
  private angv jdField_a_of_type_Angv;
  private anhd jdField_a_of_type_Anhd = new anhd();
  private final anhp<Drawable> jdField_a_of_type_Anhp;
  private List<anha> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  private angj(angl paramangl)
  {
    this.jdField_a_of_type_Boolean = angl.a(paramangl);
    this.jdField_a_of_type_Angt = angl.a(paramangl);
    this.jdField_a_of_type_Angr = angl.a(paramangl);
    this.jdField_a_of_type_Angq = angl.a(paramangl);
    jdField_a_of_type_Angw = angl.a(paramangl);
    this.jdField_a_of_type_Angv = angl.a(paramangl);
    this.jdField_a_of_type_Angs = paramangl.jdField_a_of_type_Angs;
    this.jdField_a_of_type_Ango = paramangl.jdField_a_of_type_Ango;
    this.jdField_a_of_type_Angn = angl.a(paramangl);
    this.jdField_a_of_type_Int = angl.a(paramangl);
    this.b = angl.b(paramangl);
    this.jdField_a_of_type_Anhp = new anhp();
    a(paramangl);
    c();
  }
  
  public static angg a()
  {
    if (jdField_a_of_type_Angg == null) {}
    try
    {
      if (jdField_a_of_type_Angg == null) {
        jdField_a_of_type_Angg = new angg();
      }
      return jdField_a_of_type_Angg;
    }
    finally {}
  }
  
  public static angl a()
  {
    return new angl(null);
  }
  
  public static angz a()
  {
    if (jdField_a_of_type_Angz == null) {}
    try
    {
      if ((jdField_a_of_type_Angz == null) && (jdField_a_of_type_Angw != null)) {
        jdField_a_of_type_Angz = jdField_a_of_type_Angw.a();
      }
      if (jdField_a_of_type_Angz == null) {
        jdField_a_of_type_Angz = new angz();
      }
      return jdField_a_of_type_Angz;
    }
    finally {}
  }
  
  private void a(angl paramangl)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.addAll(angl.a(paramangl));
  }
  
  private void c()
  {
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Angt == null)) {
      throw new IllegalArgumentException("Danmaku module need an IDanmakuPlayTimeSupplier or is live setter for computing timeline");
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Angs != null) {
      return this.jdField_a_of_type_Angs.a();
    }
    return (int)Math.ceil(anib.a(a()));
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_Angt == null) {
      return -1L;
    }
    return this.jdField_a_of_type_Angt.a();
  }
  
  public anga a(int paramInt)
  {
    Object localObject;
    if (paramInt == -2147483647) {
      localObject = new angi(this);
    }
    anga localanga;
    do
    {
      return localObject;
      localanga = null;
      if (this.jdField_a_of_type_Ango != null) {
        localanga = this.jdField_a_of_type_Ango.a(this, paramInt);
      }
      localObject = localanga;
    } while (localanga != null);
    return new angf(this);
  }
  
  public angu a(int paramInt)
  {
    Object localObject3 = (angu)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    Object localObject1 = localObject3;
    if (localObject3 == null) {}
    try
    {
      localObject3 = (angu)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        localObject1 = localObject3;
        if (this.jdField_a_of_type_Angv != null)
        {
          localObject1 = this.jdField_a_of_type_Angv.a(paramInt);
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
  
  public anha a(anga paramanga)
  {
    Iterator localIterator = a().iterator();
    Object localObject;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = (anha)localIterator.next();
    } while (!((anha)localObject).a(paramanga));
    for (paramanga = (anga)localObject;; paramanga = null)
    {
      localObject = paramanga;
      if (paramanga == null) {
        localObject = this.jdField_a_of_type_Anhd;
      }
      return localObject;
    }
  }
  
  public List<anha> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Angn != null) {
      this.jdField_a_of_type_Angn.a();
    }
  }
  
  public void a(anga paramanga)
  {
    if (this.jdField_a_of_type_Angr != null) {
      this.jdField_a_of_type_Angr.a(paramanga);
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
    this.jdField_a_of_type_Anhp.a(0);
  }
  
  public boolean b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     angj
 * JD-Core Version:    0.7.0.1
 */