import android.graphics.Canvas;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public abstract class anfo
{
  protected int a;
  protected anfp a;
  protected angj a;
  protected final anhb a;
  protected anho a;
  protected anht a;
  private ArrayList<anhe> a;
  protected final List<anga> a;
  protected final TreeSet<anga> a;
  
  protected anfo(angj paramangj, anfp paramanfp, Comparator<anga> paramComparator, anht paramanht, anho paramanho)
  {
    this.jdField_a_of_type_Angj = paramangj;
    this.jdField_a_of_type_Anfp = paramanfp;
    this.jdField_a_of_type_Anht = paramanht;
    this.jdField_a_of_type_Anho = paramanho;
    this.jdField_a_of_type_Anhb = new anhb(paramanfp);
    this.jdField_a_of_type_JavaUtilTreeSet = new TreeSet(paramComparator);
    this.jdField_a_of_type_JavaUtilList = new LinkedList();
    a();
  }
  
  public static anfo a(angj paramangj, anfp paramanfp, Comparator<anga> paramComparator, anht paramanht, anho paramanho)
  {
    return new anfz(paramangj, paramanfp, paramComparator, paramanht, paramanho);
  }
  
  private void a(Canvas paramCanvas, angj paramangj, long paramLong)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (paramCanvas != null))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((anhe)localIterator.next()).a(paramCanvas, paramangj, paramLong);
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public abstract anga a(anhx paramanhx);
  
  public List<anga> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a() {}
  
  public final void a(Canvas paramCanvas, long paramLong)
  {
    b(paramCanvas, paramLong);
    a(paramCanvas, this.jdField_a_of_type_Angj, paramLong);
  }
  
  protected void a(Canvas paramCanvas, anga paramanga)
  {
    anha localanha = this.jdField_a_of_type_Angj.a(paramanga);
    this.jdField_a_of_type_Anhb.a(paramCanvas, paramanga, this.jdField_a_of_type_Angj, localanha);
    paramanga.f();
  }
  
  public void a(anga paramanga)
  {
    this.jdField_a_of_type_JavaUtilTreeSet.add(paramanga);
  }
  
  public abstract void b();
  
  public abstract void b(Canvas paramCanvas, long paramLong);
  
  public void b(anga paramanga)
  {
    paramanga.c(true);
    paramanga.d(true);
    float f = paramanga.f();
    anfx.a(this.jdField_a_of_type_Angj, paramanga);
    paramanga.c((paramanga.f() + paramanga.f()) / (f + paramanga.f()));
  }
  
  public abstract void c();
  
  public abstract void c(anga paramanga);
  
  public void d()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public abstract void d(anga paramanga);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     anfo
 * JD-Core Version:    0.7.0.1
 */