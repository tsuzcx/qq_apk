import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class arul
{
  private static arui jdField_a_of_type_Arui;
  private static aruy jdField_a_of_type_Aruy;
  private static arvb jdField_a_of_type_Arvb;
  private static final String jdField_a_of_type_JavaLangString = arul.class.getSimpleName();
  private int jdField_a_of_type_Int;
  private final SparseArray<aruw> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private arup jdField_a_of_type_Arup;
  private aruq jdField_a_of_type_Aruq;
  private arus jdField_a_of_type_Arus;
  private arut jdField_a_of_type_Arut;
  private aruu jdField_a_of_type_Aruu;
  private aruv jdField_a_of_type_Aruv;
  private arux jdField_a_of_type_Arux;
  private arvf jdField_a_of_type_Arvf = new arvf();
  private final arvr<Drawable> jdField_a_of_type_Arvr;
  private List<arvc> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  private arul(arun paramarun)
  {
    this.jdField_a_of_type_Boolean = arun.a(paramarun);
    this.jdField_a_of_type_Aruv = arun.a(paramarun);
    this.jdField_a_of_type_Arut = arun.a(paramarun);
    this.jdField_a_of_type_Arus = arun.a(paramarun);
    jdField_a_of_type_Aruy = arun.a(paramarun);
    this.jdField_a_of_type_Arux = arun.a(paramarun);
    this.jdField_a_of_type_Aruu = paramarun.jdField_a_of_type_Aruu;
    this.jdField_a_of_type_Aruq = paramarun.jdField_a_of_type_Aruq;
    this.jdField_a_of_type_Arup = arun.a(paramarun);
    this.jdField_a_of_type_Int = arun.a(paramarun);
    this.b = arun.b(paramarun);
    this.jdField_a_of_type_Arvr = new arvr();
    a(paramarun);
    c();
  }
  
  public static arui a()
  {
    if (jdField_a_of_type_Arui == null) {}
    try
    {
      if (jdField_a_of_type_Arui == null) {
        jdField_a_of_type_Arui = new arui();
      }
      return jdField_a_of_type_Arui;
    }
    finally {}
  }
  
  public static arun a()
  {
    return new arun(null);
  }
  
  public static arvb a()
  {
    if (jdField_a_of_type_Arvb == null) {}
    try
    {
      if ((jdField_a_of_type_Arvb == null) && (jdField_a_of_type_Aruy != null)) {
        jdField_a_of_type_Arvb = jdField_a_of_type_Aruy.a();
      }
      if (jdField_a_of_type_Arvb == null) {
        jdField_a_of_type_Arvb = new arvb();
      }
      return jdField_a_of_type_Arvb;
    }
    finally {}
  }
  
  private void a(arun paramarun)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.addAll(arun.a(paramarun));
  }
  
  private void c()
  {
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Aruv == null)) {
      throw new IllegalArgumentException("Danmaku module need an IDanmakuPlayTimeSupplier or is live setter for computing timeline");
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Aruu != null) {
      return this.jdField_a_of_type_Aruu.a();
    }
    return (int)Math.ceil(arwd.a(a()));
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_Aruv == null) {
      return -1L;
    }
    return this.jdField_a_of_type_Aruv.a();
  }
  
  public aruc a(int paramInt)
  {
    Object localObject;
    if (paramInt == -2147483647) {
      localObject = new aruk(this);
    }
    aruc localaruc;
    do
    {
      return localObject;
      localaruc = null;
      if (this.jdField_a_of_type_Aruq != null) {
        localaruc = this.jdField_a_of_type_Aruq.a(this, paramInt);
      }
      localObject = localaruc;
    } while (localaruc != null);
    return new aruh(this);
  }
  
  public aruw a(int paramInt)
  {
    Object localObject3 = (aruw)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    Object localObject1 = localObject3;
    if (localObject3 == null) {}
    try
    {
      localObject3 = (aruw)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        localObject1 = localObject3;
        if (this.jdField_a_of_type_Arux != null)
        {
          localObject1 = this.jdField_a_of_type_Arux.a(paramInt);
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
  
  public arvc a(aruc paramaruc)
  {
    Iterator localIterator = a().iterator();
    Object localObject;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = (arvc)localIterator.next();
    } while (!((arvc)localObject).a(paramaruc));
    for (paramaruc = (aruc)localObject;; paramaruc = null)
    {
      localObject = paramaruc;
      if (paramaruc == null) {
        localObject = this.jdField_a_of_type_Arvf;
      }
      return localObject;
    }
  }
  
  public List<arvc> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Arup != null) {
      this.jdField_a_of_type_Arup.a();
    }
  }
  
  public void a(aruc paramaruc)
  {
    if (this.jdField_a_of_type_Arut != null) {
      this.jdField_a_of_type_Arut.a(paramaruc);
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
    this.jdField_a_of_type_Arvr.a(0);
  }
  
  public boolean b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arul
 * JD-Core Version:    0.7.0.1
 */