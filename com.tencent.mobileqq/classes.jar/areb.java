import android.graphics.Canvas;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public abstract class areb
{
  protected int a;
  protected arec a;
  protected arew a;
  protected final arfo a;
  protected argb a;
  protected argg a;
  private ArrayList<arfr> a;
  protected final List<aren> a;
  protected final TreeSet<aren> a;
  
  protected areb(arew paramarew, arec paramarec, Comparator<aren> paramComparator, argg paramargg, argb paramargb)
  {
    this.jdField_a_of_type_Arew = paramarew;
    this.jdField_a_of_type_Arec = paramarec;
    this.jdField_a_of_type_Argg = paramargg;
    this.jdField_a_of_type_Argb = paramargb;
    this.jdField_a_of_type_Arfo = new arfo(paramarec);
    this.jdField_a_of_type_JavaUtilTreeSet = new TreeSet(paramComparator);
    this.jdField_a_of_type_JavaUtilList = new LinkedList();
    a();
  }
  
  public static areb a(arew paramarew, arec paramarec, Comparator<aren> paramComparator, argg paramargg, argb paramargb)
  {
    return new arem(paramarew, paramarec, paramComparator, paramargg, paramargb);
  }
  
  private void a(Canvas paramCanvas, arew paramarew, long paramLong)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (paramCanvas != null))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((arfr)localIterator.next()).a(paramCanvas, paramarew, paramLong);
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public abstract aren a(argk paramargk);
  
  public List<aren> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a() {}
  
  public final void a(Canvas paramCanvas, long paramLong)
  {
    b(paramCanvas, paramLong);
    a(paramCanvas, this.jdField_a_of_type_Arew, paramLong);
  }
  
  protected void a(Canvas paramCanvas, aren paramaren)
  {
    arfn localarfn = this.jdField_a_of_type_Arew.a(paramaren);
    this.jdField_a_of_type_Arfo.a(paramCanvas, paramaren, this.jdField_a_of_type_Arew, localarfn);
    paramaren.f();
  }
  
  public void a(aren paramaren)
  {
    this.jdField_a_of_type_JavaUtilTreeSet.add(paramaren);
  }
  
  public abstract void b();
  
  public abstract void b(Canvas paramCanvas, long paramLong);
  
  public void b(aren paramaren)
  {
    paramaren.c(true);
    paramaren.d(true);
    float f = paramaren.f();
    arek.a(this.jdField_a_of_type_Arew, paramaren);
    paramaren.c((paramaren.f() + paramaren.f()) / (f + paramaren.f()));
  }
  
  public abstract void c();
  
  public abstract void c(aren paramaren);
  
  public void d()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public abstract void d(aren paramaren);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     areb
 * JD-Core Version:    0.7.0.1
 */