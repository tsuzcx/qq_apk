import android.graphics.Canvas;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public abstract class ampc
{
  protected int a;
  protected ampd a;
  protected ampx a;
  protected final amqp a;
  protected amrc a;
  protected amrh a;
  private ArrayList<amqs> a;
  protected final List<ampo> a;
  protected final TreeSet<ampo> a;
  
  protected ampc(ampx paramampx, ampd paramampd, Comparator<ampo> paramComparator, amrh paramamrh, amrc paramamrc)
  {
    this.jdField_a_of_type_Ampx = paramampx;
    this.jdField_a_of_type_Ampd = paramampd;
    this.jdField_a_of_type_Amrh = paramamrh;
    this.jdField_a_of_type_Amrc = paramamrc;
    this.jdField_a_of_type_Amqp = new amqp(paramampd);
    this.jdField_a_of_type_JavaUtilTreeSet = new TreeSet(paramComparator);
    this.jdField_a_of_type_JavaUtilList = new LinkedList();
    a();
  }
  
  public static ampc a(ampx paramampx, ampd paramampd, Comparator<ampo> paramComparator, amrh paramamrh, amrc paramamrc)
  {
    return new ampn(paramampx, paramampd, paramComparator, paramamrh, paramamrc);
  }
  
  private void a(Canvas paramCanvas, ampx paramampx, long paramLong)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (paramCanvas != null))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((amqs)localIterator.next()).a(paramCanvas, paramampx, paramLong);
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public abstract ampo a(amrl paramamrl);
  
  public List<ampo> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a() {}
  
  public void a(ampo paramampo)
  {
    this.jdField_a_of_type_JavaUtilTreeSet.add(paramampo);
  }
  
  public final void a(Canvas paramCanvas, long paramLong)
  {
    b(paramCanvas, paramLong);
    a(paramCanvas, this.jdField_a_of_type_Ampx, paramLong);
  }
  
  protected void a(Canvas paramCanvas, ampo paramampo)
  {
    amqo localamqo = this.jdField_a_of_type_Ampx.a(paramampo);
    this.jdField_a_of_type_Amqp.a(paramCanvas, paramampo, this.jdField_a_of_type_Ampx, localamqo);
    paramampo.f();
  }
  
  public abstract void b();
  
  public void b(ampo paramampo)
  {
    paramampo.c(true);
    paramampo.d(true);
    float f = paramampo.f();
    ampl.a(this.jdField_a_of_type_Ampx, paramampo);
    paramampo.c((paramampo.f() + paramampo.f()) / (f + paramampo.f()));
  }
  
  public abstract void b(Canvas paramCanvas, long paramLong);
  
  public abstract void c();
  
  public abstract void c(ampo paramampo);
  
  public void d()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public abstract void d(ampo paramampo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ampc
 * JD-Core Version:    0.7.0.1
 */