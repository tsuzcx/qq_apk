import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import com.tencent.mobileqq.danmaku.util.DrawUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class arru
{
  private static arrr jdField_a_of_type_Arrr;
  private static arsh jdField_a_of_type_Arsh;
  private static arsk jdField_a_of_type_Arsk;
  private static final String jdField_a_of_type_JavaLangString = arru.class.getSimpleName();
  private int jdField_a_of_type_Int;
  private final SparseArray<arsf> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private arry jdField_a_of_type_Arry;
  private arrz jdField_a_of_type_Arrz;
  private arsb jdField_a_of_type_Arsb;
  private arsc jdField_a_of_type_Arsc;
  private arsd jdField_a_of_type_Arsd;
  private arse jdField_a_of_type_Arse;
  private arsg jdField_a_of_type_Arsg;
  private arso jdField_a_of_type_Arso = new arso();
  private final arta<Drawable> jdField_a_of_type_Arta;
  private List<arsl> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  private arru(arrw paramarrw)
  {
    this.jdField_a_of_type_Boolean = arrw.a(paramarrw);
    this.jdField_a_of_type_Arse = arrw.a(paramarrw);
    this.jdField_a_of_type_Arsc = arrw.a(paramarrw);
    this.jdField_a_of_type_Arsb = arrw.a(paramarrw);
    jdField_a_of_type_Arsh = arrw.a(paramarrw);
    this.jdField_a_of_type_Arsg = arrw.a(paramarrw);
    this.jdField_a_of_type_Arsd = paramarrw.jdField_a_of_type_Arsd;
    this.jdField_a_of_type_Arrz = paramarrw.jdField_a_of_type_Arrz;
    this.jdField_a_of_type_Arry = arrw.a(paramarrw);
    this.jdField_a_of_type_Int = arrw.a(paramarrw);
    this.b = arrw.b(paramarrw);
    this.jdField_a_of_type_Arta = new arta();
    a(paramarrw);
    c();
  }
  
  public static arrr a()
  {
    if (jdField_a_of_type_Arrr == null) {}
    try
    {
      if (jdField_a_of_type_Arrr == null) {
        jdField_a_of_type_Arrr = new arrr();
      }
      return jdField_a_of_type_Arrr;
    }
    finally {}
  }
  
  public static arrw a()
  {
    return new arrw(null);
  }
  
  public static arsk a()
  {
    if (jdField_a_of_type_Arsk == null) {}
    try
    {
      if ((jdField_a_of_type_Arsk == null) && (jdField_a_of_type_Arsh != null)) {
        jdField_a_of_type_Arsk = jdField_a_of_type_Arsh.a();
      }
      if (jdField_a_of_type_Arsk == null) {
        jdField_a_of_type_Arsk = new arsk();
      }
      return jdField_a_of_type_Arsk;
    }
    finally {}
  }
  
  private void a(arrw paramarrw)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.addAll(arrw.a(paramarrw));
  }
  
  private void c()
  {
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Arse == null)) {
      throw new IllegalArgumentException("Danmaku module need an IDanmakuPlayTimeSupplier or is live setter for computing timeline");
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Arsd != null) {
      return this.jdField_a_of_type_Arsd.a();
    }
    return (int)Math.ceil(DrawUtils.getDefaultLineHeight(a()));
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_Arse == null) {
      return -1L;
    }
    return this.jdField_a_of_type_Arse.a();
  }
  
  public arrl a(int paramInt)
  {
    Object localObject;
    if (paramInt == -2147483647) {
      localObject = new arrt(this);
    }
    arrl localarrl;
    do
    {
      return localObject;
      localarrl = null;
      if (this.jdField_a_of_type_Arrz != null) {
        localarrl = this.jdField_a_of_type_Arrz.a(this, paramInt);
      }
      localObject = localarrl;
    } while (localarrl != null);
    return new arrq(this);
  }
  
  public arsf a(int paramInt)
  {
    Object localObject3 = (arsf)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    Object localObject1 = localObject3;
    if (localObject3 == null) {}
    try
    {
      localObject3 = (arsf)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        localObject1 = localObject3;
        if (this.jdField_a_of_type_Arsg != null)
        {
          localObject1 = this.jdField_a_of_type_Arsg.a(paramInt);
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
  
  public arsl a(arrl paramarrl)
  {
    Iterator localIterator = a().iterator();
    Object localObject;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = (arsl)localIterator.next();
    } while (!((arsl)localObject).a(paramarrl));
    for (paramarrl = (arrl)localObject;; paramarrl = null)
    {
      localObject = paramarrl;
      if (paramarrl == null) {
        localObject = this.jdField_a_of_type_Arso;
      }
      return localObject;
    }
  }
  
  public List<arsl> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Arry != null) {
      this.jdField_a_of_type_Arry.a();
    }
  }
  
  public void a(arrl paramarrl)
  {
    if (this.jdField_a_of_type_Arsc != null) {
      this.jdField_a_of_type_Arsc.a(paramarrl);
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
    this.jdField_a_of_type_Arta.a(0);
  }
  
  public boolean b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arru
 * JD-Core Version:    0.7.0.1
 */