import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aoxq
{
  private static aoxn jdField_a_of_type_Aoxn;
  private static aoyd jdField_a_of_type_Aoyd;
  private static aoyg jdField_a_of_type_Aoyg;
  private static final String jdField_a_of_type_JavaLangString = aoxq.class.getSimpleName();
  private int jdField_a_of_type_Int;
  private final SparseArray<aoyb> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private aoxu jdField_a_of_type_Aoxu;
  private aoxv jdField_a_of_type_Aoxv;
  private aoxx jdField_a_of_type_Aoxx;
  private aoxy jdField_a_of_type_Aoxy;
  private aoxz jdField_a_of_type_Aoxz;
  private aoya jdField_a_of_type_Aoya;
  private aoyc jdField_a_of_type_Aoyc;
  private aoyk jdField_a_of_type_Aoyk = new aoyk();
  private final aoyw<Drawable> jdField_a_of_type_Aoyw;
  private List<aoyh> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  private aoxq(aoxs paramaoxs)
  {
    this.jdField_a_of_type_Boolean = aoxs.a(paramaoxs);
    this.jdField_a_of_type_Aoya = aoxs.a(paramaoxs);
    this.jdField_a_of_type_Aoxy = aoxs.a(paramaoxs);
    this.jdField_a_of_type_Aoxx = aoxs.a(paramaoxs);
    jdField_a_of_type_Aoyd = aoxs.a(paramaoxs);
    this.jdField_a_of_type_Aoyc = aoxs.a(paramaoxs);
    this.jdField_a_of_type_Aoxz = paramaoxs.jdField_a_of_type_Aoxz;
    this.jdField_a_of_type_Aoxv = paramaoxs.jdField_a_of_type_Aoxv;
    this.jdField_a_of_type_Aoxu = aoxs.a(paramaoxs);
    this.jdField_a_of_type_Int = aoxs.a(paramaoxs);
    this.b = aoxs.b(paramaoxs);
    this.jdField_a_of_type_Aoyw = new aoyw();
    a(paramaoxs);
    c();
  }
  
  public static aoxn a()
  {
    if (jdField_a_of_type_Aoxn == null) {}
    try
    {
      if (jdField_a_of_type_Aoxn == null) {
        jdField_a_of_type_Aoxn = new aoxn();
      }
      return jdField_a_of_type_Aoxn;
    }
    finally {}
  }
  
  public static aoxs a()
  {
    return new aoxs(null);
  }
  
  public static aoyg a()
  {
    if (jdField_a_of_type_Aoyg == null) {}
    try
    {
      if ((jdField_a_of_type_Aoyg == null) && (jdField_a_of_type_Aoyd != null)) {
        jdField_a_of_type_Aoyg = jdField_a_of_type_Aoyd.a();
      }
      if (jdField_a_of_type_Aoyg == null) {
        jdField_a_of_type_Aoyg = new aoyg();
      }
      return jdField_a_of_type_Aoyg;
    }
    finally {}
  }
  
  private void a(aoxs paramaoxs)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.addAll(aoxs.a(paramaoxs));
  }
  
  private void c()
  {
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Aoya == null)) {
      throw new IllegalArgumentException("Danmaku module need an IDanmakuPlayTimeSupplier or is live setter for computing timeline");
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Aoxz != null) {
      return this.jdField_a_of_type_Aoxz.a();
    }
    return (int)Math.ceil(aozi.a(a()));
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_Aoya == null) {
      return -1L;
    }
    return this.jdField_a_of_type_Aoya.a();
  }
  
  public aoxh a(int paramInt)
  {
    Object localObject;
    if (paramInt == -2147483647) {
      localObject = new aoxp(this);
    }
    aoxh localaoxh;
    do
    {
      return localObject;
      localaoxh = null;
      if (this.jdField_a_of_type_Aoxv != null) {
        localaoxh = this.jdField_a_of_type_Aoxv.a(this, paramInt);
      }
      localObject = localaoxh;
    } while (localaoxh != null);
    return new aoxm(this);
  }
  
  public aoyb a(int paramInt)
  {
    Object localObject3 = (aoyb)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    Object localObject1 = localObject3;
    if (localObject3 == null) {}
    try
    {
      localObject3 = (aoyb)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        localObject1 = localObject3;
        if (this.jdField_a_of_type_Aoyc != null)
        {
          localObject1 = this.jdField_a_of_type_Aoyc.a(paramInt);
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
  
  public aoyh a(aoxh paramaoxh)
  {
    Iterator localIterator = a().iterator();
    Object localObject;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = (aoyh)localIterator.next();
    } while (!((aoyh)localObject).a(paramaoxh));
    for (paramaoxh = (aoxh)localObject;; paramaoxh = null)
    {
      localObject = paramaoxh;
      if (paramaoxh == null) {
        localObject = this.jdField_a_of_type_Aoyk;
      }
      return localObject;
    }
  }
  
  public List<aoyh> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Aoxu != null) {
      this.jdField_a_of_type_Aoxu.a();
    }
  }
  
  public void a(aoxh paramaoxh)
  {
    if (this.jdField_a_of_type_Aoxy != null) {
      this.jdField_a_of_type_Aoxy.a(paramaoxh);
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
    this.jdField_a_of_type_Aoyw.a(0);
  }
  
  public boolean b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoxq
 * JD-Core Version:    0.7.0.1
 */