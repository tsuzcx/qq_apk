import android.graphics.Canvas;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public abstract class artq
{
  protected int a;
  protected artr a;
  protected arul a;
  protected final arvd a;
  protected arvq a;
  protected arvv a;
  private ArrayList<arvg> a;
  protected final List<aruc> a;
  protected final TreeSet<aruc> a;
  
  protected artq(arul paramarul, artr paramartr, Comparator<aruc> paramComparator, arvv paramarvv, arvq paramarvq)
  {
    this.jdField_a_of_type_Arul = paramarul;
    this.jdField_a_of_type_Artr = paramartr;
    this.jdField_a_of_type_Arvv = paramarvv;
    this.jdField_a_of_type_Arvq = paramarvq;
    this.jdField_a_of_type_Arvd = new arvd(paramartr);
    this.jdField_a_of_type_JavaUtilTreeSet = new TreeSet(paramComparator);
    this.jdField_a_of_type_JavaUtilList = new LinkedList();
    a();
  }
  
  public static artq a(arul paramarul, artr paramartr, Comparator<aruc> paramComparator, arvv paramarvv, arvq paramarvq)
  {
    return new arub(paramarul, paramartr, paramComparator, paramarvv, paramarvq);
  }
  
  private void a(Canvas paramCanvas, arul paramarul, long paramLong)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (paramCanvas != null))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((arvg)localIterator.next()).a(paramCanvas, paramarul, paramLong);
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public abstract aruc a(arvz paramarvz);
  
  public List<aruc> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a() {}
  
  public final void a(Canvas paramCanvas, long paramLong)
  {
    b(paramCanvas, paramLong);
    a(paramCanvas, this.jdField_a_of_type_Arul, paramLong);
  }
  
  protected void a(Canvas paramCanvas, aruc paramaruc)
  {
    arvc localarvc = this.jdField_a_of_type_Arul.a(paramaruc);
    this.jdField_a_of_type_Arvd.a(paramCanvas, paramaruc, this.jdField_a_of_type_Arul, localarvc);
    paramaruc.f();
  }
  
  public void a(aruc paramaruc)
  {
    this.jdField_a_of_type_JavaUtilTreeSet.add(paramaruc);
  }
  
  public abstract void b();
  
  public abstract void b(Canvas paramCanvas, long paramLong);
  
  public void b(aruc paramaruc)
  {
    paramaruc.c(true);
    paramaruc.d(true);
    float f = paramaruc.f();
    artz.a(this.jdField_a_of_type_Arul, paramaruc);
    paramaruc.c((paramaruc.f() + paramaruc.f()) / (f + paramaruc.f()));
  }
  
  public abstract void c();
  
  public abstract void c(aruc paramaruc);
  
  public void d()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public abstract void d(aruc paramaruc);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     artq
 * JD-Core Version:    0.7.0.1
 */