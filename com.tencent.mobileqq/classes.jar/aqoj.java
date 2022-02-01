import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import com.tencent.mobileqq.danmaku.util.DrawUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aqoj
{
  private static aqog jdField_a_of_type_Aqog;
  private static aqow jdField_a_of_type_Aqow;
  private static aqoz jdField_a_of_type_Aqoz;
  private static final String jdField_a_of_type_JavaLangString = aqoj.class.getSimpleName();
  private int jdField_a_of_type_Int;
  private final SparseArray<aqou> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private aqon jdField_a_of_type_Aqon;
  private aqoo jdField_a_of_type_Aqoo;
  private aqoq jdField_a_of_type_Aqoq;
  private aqor jdField_a_of_type_Aqor;
  private aqos jdField_a_of_type_Aqos;
  private aqot jdField_a_of_type_Aqot;
  private aqov jdField_a_of_type_Aqov;
  private aqpd jdField_a_of_type_Aqpd = new aqpd();
  private final aqpp<Drawable> jdField_a_of_type_Aqpp;
  private List<aqpa> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  private aqoj(aqol paramaqol)
  {
    this.jdField_a_of_type_Boolean = aqol.a(paramaqol);
    this.jdField_a_of_type_Aqot = aqol.a(paramaqol);
    this.jdField_a_of_type_Aqor = aqol.a(paramaqol);
    this.jdField_a_of_type_Aqoq = aqol.a(paramaqol);
    jdField_a_of_type_Aqow = aqol.a(paramaqol);
    this.jdField_a_of_type_Aqov = aqol.a(paramaqol);
    this.jdField_a_of_type_Aqos = paramaqol.jdField_a_of_type_Aqos;
    this.jdField_a_of_type_Aqoo = paramaqol.jdField_a_of_type_Aqoo;
    this.jdField_a_of_type_Aqon = aqol.a(paramaqol);
    this.jdField_a_of_type_Int = aqol.a(paramaqol);
    this.b = aqol.b(paramaqol);
    this.jdField_a_of_type_Aqpp = new aqpp();
    a(paramaqol);
    c();
  }
  
  public static aqog a()
  {
    if (jdField_a_of_type_Aqog == null) {}
    try
    {
      if (jdField_a_of_type_Aqog == null) {
        jdField_a_of_type_Aqog = new aqog();
      }
      return jdField_a_of_type_Aqog;
    }
    finally {}
  }
  
  public static aqol a()
  {
    return new aqol(null);
  }
  
  public static aqoz a()
  {
    if (jdField_a_of_type_Aqoz == null) {}
    try
    {
      if ((jdField_a_of_type_Aqoz == null) && (jdField_a_of_type_Aqow != null)) {
        jdField_a_of_type_Aqoz = jdField_a_of_type_Aqow.a();
      }
      if (jdField_a_of_type_Aqoz == null) {
        jdField_a_of_type_Aqoz = new aqoz();
      }
      return jdField_a_of_type_Aqoz;
    }
    finally {}
  }
  
  private void a(aqol paramaqol)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.addAll(aqol.a(paramaqol));
  }
  
  private void c()
  {
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Aqot == null)) {
      throw new IllegalArgumentException("Danmaku module need an IDanmakuPlayTimeSupplier or is live setter for computing timeline");
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Aqos != null) {
      return this.jdField_a_of_type_Aqos.a();
    }
    return (int)Math.ceil(DrawUtils.getDefaultLineHeight(a()));
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_Aqot == null) {
      return -1L;
    }
    return this.jdField_a_of_type_Aqot.a();
  }
  
  public aqoa a(int paramInt)
  {
    Object localObject;
    if (paramInt == -2147483647) {
      localObject = new aqoi(this);
    }
    aqoa localaqoa;
    do
    {
      return localObject;
      localaqoa = null;
      if (this.jdField_a_of_type_Aqoo != null) {
        localaqoa = this.jdField_a_of_type_Aqoo.a(this, paramInt);
      }
      localObject = localaqoa;
    } while (localaqoa != null);
    return new aqof(this);
  }
  
  public aqou a(int paramInt)
  {
    Object localObject3 = (aqou)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    Object localObject1 = localObject3;
    if (localObject3 == null) {}
    try
    {
      localObject3 = (aqou)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        localObject1 = localObject3;
        if (this.jdField_a_of_type_Aqov != null)
        {
          localObject1 = this.jdField_a_of_type_Aqov.a(paramInt);
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
  
  public aqpa a(aqoa paramaqoa)
  {
    Iterator localIterator = a().iterator();
    Object localObject;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = (aqpa)localIterator.next();
    } while (!((aqpa)localObject).a(paramaqoa));
    for (paramaqoa = (aqoa)localObject;; paramaqoa = null)
    {
      localObject = paramaqoa;
      if (paramaqoa == null) {
        localObject = this.jdField_a_of_type_Aqpd;
      }
      return localObject;
    }
  }
  
  public List<aqpa> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Aqon != null) {
      this.jdField_a_of_type_Aqon.a();
    }
  }
  
  public void a(aqoa paramaqoa)
  {
    if (this.jdField_a_of_type_Aqor != null) {
      this.jdField_a_of_type_Aqor.a(paramaqoa);
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
    this.jdField_a_of_type_Aqpp.a(0);
  }
  
  public boolean b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqoj
 * JD-Core Version:    0.7.0.1
 */