import android.graphics.Canvas;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public abstract class aqno
{
  protected int a;
  protected aqnp a;
  protected aqoj a;
  protected final aqpb a;
  protected aqpo a;
  protected aqpt a;
  private ArrayList<aqpe> a;
  protected final List<aqoa> a;
  protected final TreeSet<aqoa> a;
  
  protected aqno(aqoj paramaqoj, aqnp paramaqnp, Comparator<aqoa> paramComparator, aqpt paramaqpt, aqpo paramaqpo)
  {
    this.jdField_a_of_type_Aqoj = paramaqoj;
    this.jdField_a_of_type_Aqnp = paramaqnp;
    this.jdField_a_of_type_Aqpt = paramaqpt;
    this.jdField_a_of_type_Aqpo = paramaqpo;
    this.jdField_a_of_type_Aqpb = new aqpb(paramaqnp);
    this.jdField_a_of_type_JavaUtilTreeSet = new TreeSet(paramComparator);
    this.jdField_a_of_type_JavaUtilList = new LinkedList();
    a();
  }
  
  public static aqno a(aqoj paramaqoj, aqnp paramaqnp, Comparator<aqoa> paramComparator, aqpt paramaqpt, aqpo paramaqpo)
  {
    return new aqnz(paramaqoj, paramaqnp, paramComparator, paramaqpt, paramaqpo);
  }
  
  private void a(Canvas paramCanvas, aqoj paramaqoj, long paramLong)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (paramCanvas != null))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((aqpe)localIterator.next()).a(paramCanvas, paramaqoj, paramLong);
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public abstract aqoa a(aqpx paramaqpx);
  
  public List<aqoa> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a() {}
  
  public final void a(Canvas paramCanvas, long paramLong)
  {
    b(paramCanvas, paramLong);
    a(paramCanvas, this.jdField_a_of_type_Aqoj, paramLong);
  }
  
  protected void a(Canvas paramCanvas, aqoa paramaqoa)
  {
    aqpa localaqpa = this.jdField_a_of_type_Aqoj.a(paramaqoa);
    this.jdField_a_of_type_Aqpb.a(paramCanvas, paramaqoa, this.jdField_a_of_type_Aqoj, localaqpa);
    paramaqoa.f();
  }
  
  public void a(aqoa paramaqoa)
  {
    this.jdField_a_of_type_JavaUtilTreeSet.add(paramaqoa);
  }
  
  public abstract void b();
  
  public abstract void b(Canvas paramCanvas, long paramLong);
  
  public void b(aqoa paramaqoa)
  {
    paramaqoa.c(true);
    paramaqoa.d(true);
    float f = paramaqoa.f();
    aqnx.a(this.jdField_a_of_type_Aqoj, paramaqoa);
    paramaqoa.c((paramaqoa.f() + paramaqoa.f()) / (f + paramaqoa.f()));
  }
  
  public abstract void c();
  
  public abstract void c(aqoa paramaqoa);
  
  public void d()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public abstract void d(aqoa paramaqoa);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqno
 * JD-Core Version:    0.7.0.1
 */