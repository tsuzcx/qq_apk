import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class apbz
{
  private static apbw jdField_a_of_type_Apbw;
  private static apcm jdField_a_of_type_Apcm;
  private static apcp jdField_a_of_type_Apcp;
  private static final String jdField_a_of_type_JavaLangString = apbz.class.getSimpleName();
  private int jdField_a_of_type_Int;
  private final SparseArray<apck> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private apcd jdField_a_of_type_Apcd;
  private apce jdField_a_of_type_Apce;
  private apcg jdField_a_of_type_Apcg;
  private apch jdField_a_of_type_Apch;
  private apci jdField_a_of_type_Apci;
  private apcj jdField_a_of_type_Apcj;
  private apcl jdField_a_of_type_Apcl;
  private apct jdField_a_of_type_Apct = new apct();
  private final apdf<Drawable> jdField_a_of_type_Apdf;
  private List<apcq> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  private apbz(apcb paramapcb)
  {
    this.jdField_a_of_type_Boolean = apcb.a(paramapcb);
    this.jdField_a_of_type_Apcj = apcb.a(paramapcb);
    this.jdField_a_of_type_Apch = apcb.a(paramapcb);
    this.jdField_a_of_type_Apcg = apcb.a(paramapcb);
    jdField_a_of_type_Apcm = apcb.a(paramapcb);
    this.jdField_a_of_type_Apcl = apcb.a(paramapcb);
    this.jdField_a_of_type_Apci = paramapcb.jdField_a_of_type_Apci;
    this.jdField_a_of_type_Apce = paramapcb.jdField_a_of_type_Apce;
    this.jdField_a_of_type_Apcd = apcb.a(paramapcb);
    this.jdField_a_of_type_Int = apcb.a(paramapcb);
    this.b = apcb.b(paramapcb);
    this.jdField_a_of_type_Apdf = new apdf();
    a(paramapcb);
    c();
  }
  
  public static apbw a()
  {
    if (jdField_a_of_type_Apbw == null) {}
    try
    {
      if (jdField_a_of_type_Apbw == null) {
        jdField_a_of_type_Apbw = new apbw();
      }
      return jdField_a_of_type_Apbw;
    }
    finally {}
  }
  
  public static apcb a()
  {
    return new apcb(null);
  }
  
  public static apcp a()
  {
    if (jdField_a_of_type_Apcp == null) {}
    try
    {
      if ((jdField_a_of_type_Apcp == null) && (jdField_a_of_type_Apcm != null)) {
        jdField_a_of_type_Apcp = jdField_a_of_type_Apcm.a();
      }
      if (jdField_a_of_type_Apcp == null) {
        jdField_a_of_type_Apcp = new apcp();
      }
      return jdField_a_of_type_Apcp;
    }
    finally {}
  }
  
  private void a(apcb paramapcb)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.addAll(apcb.a(paramapcb));
  }
  
  private void c()
  {
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Apcj == null)) {
      throw new IllegalArgumentException("Danmaku module need an IDanmakuPlayTimeSupplier or is live setter for computing timeline");
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Apci != null) {
      return this.jdField_a_of_type_Apci.a();
    }
    return (int)Math.ceil(apdr.a(a()));
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_Apcj == null) {
      return -1L;
    }
    return this.jdField_a_of_type_Apcj.a();
  }
  
  public apbq a(int paramInt)
  {
    Object localObject;
    if (paramInt == -2147483647) {
      localObject = new apby(this);
    }
    apbq localapbq;
    do
    {
      return localObject;
      localapbq = null;
      if (this.jdField_a_of_type_Apce != null) {
        localapbq = this.jdField_a_of_type_Apce.a(this, paramInt);
      }
      localObject = localapbq;
    } while (localapbq != null);
    return new apbv(this);
  }
  
  public apck a(int paramInt)
  {
    Object localObject3 = (apck)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    Object localObject1 = localObject3;
    if (localObject3 == null) {}
    try
    {
      localObject3 = (apck)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        localObject1 = localObject3;
        if (this.jdField_a_of_type_Apcl != null)
        {
          localObject1 = this.jdField_a_of_type_Apcl.a(paramInt);
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
  
  public apcq a(apbq paramapbq)
  {
    Iterator localIterator = a().iterator();
    Object localObject;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = (apcq)localIterator.next();
    } while (!((apcq)localObject).a(paramapbq));
    for (paramapbq = (apbq)localObject;; paramapbq = null)
    {
      localObject = paramapbq;
      if (paramapbq == null) {
        localObject = this.jdField_a_of_type_Apct;
      }
      return localObject;
    }
  }
  
  public List<apcq> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Apcd != null) {
      this.jdField_a_of_type_Apcd.a();
    }
  }
  
  public void a(apbq paramapbq)
  {
    if (this.jdField_a_of_type_Apch != null) {
      this.jdField_a_of_type_Apch.a(paramapbq);
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
    this.jdField_a_of_type_Apdf.a(0);
  }
  
  public boolean b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apbz
 * JD-Core Version:    0.7.0.1
 */