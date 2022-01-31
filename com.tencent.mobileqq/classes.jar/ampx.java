import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ampx
{
  private static ampu jdField_a_of_type_Ampu;
  private static amqk jdField_a_of_type_Amqk;
  private static amqn jdField_a_of_type_Amqn;
  private static final String jdField_a_of_type_JavaLangString = ampx.class.getSimpleName();
  private int jdField_a_of_type_Int;
  private amqb jdField_a_of_type_Amqb;
  private amqc jdField_a_of_type_Amqc;
  private amqe jdField_a_of_type_Amqe;
  private amqf jdField_a_of_type_Amqf;
  private amqg jdField_a_of_type_Amqg;
  private amqh jdField_a_of_type_Amqh;
  private amqj jdField_a_of_type_Amqj;
  private amqr jdField_a_of_type_Amqr = new amqr();
  private final amrd<Drawable> jdField_a_of_type_Amrd;
  private final SparseArray<amqi> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private List<amqo> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  private ampx(ampz paramampz)
  {
    this.jdField_a_of_type_Boolean = ampz.a(paramampz);
    this.jdField_a_of_type_Amqh = ampz.a(paramampz);
    this.jdField_a_of_type_Amqf = ampz.a(paramampz);
    this.jdField_a_of_type_Amqe = ampz.a(paramampz);
    jdField_a_of_type_Amqk = ampz.a(paramampz);
    this.jdField_a_of_type_Amqj = ampz.a(paramampz);
    this.jdField_a_of_type_Amqg = paramampz.jdField_a_of_type_Amqg;
    this.jdField_a_of_type_Amqc = paramampz.jdField_a_of_type_Amqc;
    this.jdField_a_of_type_Amqb = ampz.a(paramampz);
    this.jdField_a_of_type_Int = ampz.a(paramampz);
    this.b = ampz.b(paramampz);
    this.jdField_a_of_type_Amrd = new amrd();
    a(paramampz);
    c();
  }
  
  public static ampu a()
  {
    if (jdField_a_of_type_Ampu == null) {}
    try
    {
      if (jdField_a_of_type_Ampu == null) {
        jdField_a_of_type_Ampu = new ampu();
      }
      return jdField_a_of_type_Ampu;
    }
    finally {}
  }
  
  public static ampz a()
  {
    return new ampz(null);
  }
  
  public static amqn a()
  {
    if (jdField_a_of_type_Amqn == null) {}
    try
    {
      if ((jdField_a_of_type_Amqn == null) && (jdField_a_of_type_Amqk != null)) {
        jdField_a_of_type_Amqn = jdField_a_of_type_Amqk.a();
      }
      if (jdField_a_of_type_Amqn == null) {
        jdField_a_of_type_Amqn = new amqn();
      }
      return jdField_a_of_type_Amqn;
    }
    finally {}
  }
  
  private void a(ampz paramampz)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.addAll(ampz.a(paramampz));
  }
  
  private void c()
  {
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Amqh == null)) {
      throw new IllegalArgumentException("Danmaku module need an IDanmakuPlayTimeSupplier or is live setter for computing timeline");
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Amqg != null) {
      return this.jdField_a_of_type_Amqg.a();
    }
    return (int)Math.ceil(amrp.a(a()));
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_Amqh == null) {
      return -1L;
    }
    return this.jdField_a_of_type_Amqh.a();
  }
  
  public ampo a(int paramInt)
  {
    Object localObject;
    if (paramInt == -2147483647) {
      localObject = new ampw(this);
    }
    ampo localampo;
    do
    {
      return localObject;
      localampo = null;
      if (this.jdField_a_of_type_Amqc != null) {
        localampo = this.jdField_a_of_type_Amqc.a(this, paramInt);
      }
      localObject = localampo;
    } while (localampo != null);
    return new ampt(this);
  }
  
  public amqi a(int paramInt)
  {
    Object localObject3 = (amqi)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    Object localObject1 = localObject3;
    if (localObject3 == null) {}
    try
    {
      localObject3 = (amqi)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        localObject1 = localObject3;
        if (this.jdField_a_of_type_Amqj != null)
        {
          localObject1 = this.jdField_a_of_type_Amqj.a(paramInt);
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
  
  public amqo a(ampo paramampo)
  {
    Iterator localIterator = a().iterator();
    Object localObject;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = (amqo)localIterator.next();
    } while (!((amqo)localObject).a(paramampo));
    for (paramampo = (ampo)localObject;; paramampo = null)
    {
      localObject = paramampo;
      if (paramampo == null) {
        localObject = this.jdField_a_of_type_Amqr;
      }
      return localObject;
    }
  }
  
  public List<amqo> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Amqb != null) {
      this.jdField_a_of_type_Amqb.a();
    }
  }
  
  public void a(ampo paramampo)
  {
    if (this.jdField_a_of_type_Amqf != null) {
      this.jdField_a_of_type_Amqf.a(paramampo);
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
    this.jdField_a_of_type_Amrd.a(0);
  }
  
  public boolean b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ampx
 * JD-Core Version:    0.7.0.1
 */