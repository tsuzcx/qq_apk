import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ange
{
  private static angb jdField_a_of_type_Angb;
  private static angr jdField_a_of_type_Angr;
  private static angu jdField_a_of_type_Angu;
  private static final String jdField_a_of_type_JavaLangString = ange.class.getSimpleName();
  private int jdField_a_of_type_Int;
  private final SparseArray<angp> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private angi jdField_a_of_type_Angi;
  private angj jdField_a_of_type_Angj;
  private angl jdField_a_of_type_Angl;
  private angm jdField_a_of_type_Angm;
  private angn jdField_a_of_type_Angn;
  private ango jdField_a_of_type_Ango;
  private angq jdField_a_of_type_Angq;
  private angy jdField_a_of_type_Angy = new angy();
  private final anhk<Drawable> jdField_a_of_type_Anhk;
  private List<angv> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  private ange(angg paramangg)
  {
    this.jdField_a_of_type_Boolean = angg.a(paramangg);
    this.jdField_a_of_type_Ango = angg.a(paramangg);
    this.jdField_a_of_type_Angm = angg.a(paramangg);
    this.jdField_a_of_type_Angl = angg.a(paramangg);
    jdField_a_of_type_Angr = angg.a(paramangg);
    this.jdField_a_of_type_Angq = angg.a(paramangg);
    this.jdField_a_of_type_Angn = paramangg.jdField_a_of_type_Angn;
    this.jdField_a_of_type_Angj = paramangg.jdField_a_of_type_Angj;
    this.jdField_a_of_type_Angi = angg.a(paramangg);
    this.jdField_a_of_type_Int = angg.a(paramangg);
    this.b = angg.b(paramangg);
    this.jdField_a_of_type_Anhk = new anhk();
    a(paramangg);
    c();
  }
  
  public static angb a()
  {
    if (jdField_a_of_type_Angb == null) {}
    try
    {
      if (jdField_a_of_type_Angb == null) {
        jdField_a_of_type_Angb = new angb();
      }
      return jdField_a_of_type_Angb;
    }
    finally {}
  }
  
  public static angg a()
  {
    return new angg(null);
  }
  
  public static angu a()
  {
    if (jdField_a_of_type_Angu == null) {}
    try
    {
      if ((jdField_a_of_type_Angu == null) && (jdField_a_of_type_Angr != null)) {
        jdField_a_of_type_Angu = jdField_a_of_type_Angr.a();
      }
      if (jdField_a_of_type_Angu == null) {
        jdField_a_of_type_Angu = new angu();
      }
      return jdField_a_of_type_Angu;
    }
    finally {}
  }
  
  private void a(angg paramangg)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.addAll(angg.a(paramangg));
  }
  
  private void c()
  {
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Ango == null)) {
      throw new IllegalArgumentException("Danmaku module need an IDanmakuPlayTimeSupplier or is live setter for computing timeline");
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Angn != null) {
      return this.jdField_a_of_type_Angn.a();
    }
    return (int)Math.ceil(anhw.a(a()));
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_Ango == null) {
      return -1L;
    }
    return this.jdField_a_of_type_Ango.a();
  }
  
  public anfv a(int paramInt)
  {
    Object localObject;
    if (paramInt == -2147483647) {
      localObject = new angd(this);
    }
    anfv localanfv;
    do
    {
      return localObject;
      localanfv = null;
      if (this.jdField_a_of_type_Angj != null) {
        localanfv = this.jdField_a_of_type_Angj.a(this, paramInt);
      }
      localObject = localanfv;
    } while (localanfv != null);
    return new anga(this);
  }
  
  public angp a(int paramInt)
  {
    Object localObject3 = (angp)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    Object localObject1 = localObject3;
    if (localObject3 == null) {}
    try
    {
      localObject3 = (angp)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        localObject1 = localObject3;
        if (this.jdField_a_of_type_Angq != null)
        {
          localObject1 = this.jdField_a_of_type_Angq.a(paramInt);
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
  
  public angv a(anfv paramanfv)
  {
    Iterator localIterator = a().iterator();
    Object localObject;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = (angv)localIterator.next();
    } while (!((angv)localObject).a(paramanfv));
    for (paramanfv = (anfv)localObject;; paramanfv = null)
    {
      localObject = paramanfv;
      if (paramanfv == null) {
        localObject = this.jdField_a_of_type_Angy;
      }
      return localObject;
    }
  }
  
  public List<angv> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Angi != null) {
      this.jdField_a_of_type_Angi.a();
    }
  }
  
  public void a(anfv paramanfv)
  {
    if (this.jdField_a_of_type_Angm != null) {
      this.jdField_a_of_type_Angm.a(paramanfv);
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
    this.jdField_a_of_type_Anhk.a(0);
  }
  
  public boolean b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ange
 * JD-Core Version:    0.7.0.1
 */