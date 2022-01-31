import android.graphics.Canvas;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public abstract class anfj
{
  protected int a;
  protected anfk a;
  protected ange a;
  protected final angw a;
  protected anhj a;
  protected anho a;
  private ArrayList<angz> a;
  protected final List<anfv> a;
  protected final TreeSet<anfv> a;
  
  protected anfj(ange paramange, anfk paramanfk, Comparator<anfv> paramComparator, anho paramanho, anhj paramanhj)
  {
    this.jdField_a_of_type_Ange = paramange;
    this.jdField_a_of_type_Anfk = paramanfk;
    this.jdField_a_of_type_Anho = paramanho;
    this.jdField_a_of_type_Anhj = paramanhj;
    this.jdField_a_of_type_Angw = new angw(paramanfk);
    this.jdField_a_of_type_JavaUtilTreeSet = new TreeSet(paramComparator);
    this.jdField_a_of_type_JavaUtilList = new LinkedList();
    a();
  }
  
  public static anfj a(ange paramange, anfk paramanfk, Comparator<anfv> paramComparator, anho paramanho, anhj paramanhj)
  {
    return new anfu(paramange, paramanfk, paramComparator, paramanho, paramanhj);
  }
  
  private void a(Canvas paramCanvas, ange paramange, long paramLong)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (paramCanvas != null))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((angz)localIterator.next()).a(paramCanvas, paramange, paramLong);
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public abstract anfv a(anhs paramanhs);
  
  public List<anfv> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a() {}
  
  public final void a(Canvas paramCanvas, long paramLong)
  {
    b(paramCanvas, paramLong);
    a(paramCanvas, this.jdField_a_of_type_Ange, paramLong);
  }
  
  protected void a(Canvas paramCanvas, anfv paramanfv)
  {
    angv localangv = this.jdField_a_of_type_Ange.a(paramanfv);
    this.jdField_a_of_type_Angw.a(paramCanvas, paramanfv, this.jdField_a_of_type_Ange, localangv);
    paramanfv.f();
  }
  
  public void a(anfv paramanfv)
  {
    this.jdField_a_of_type_JavaUtilTreeSet.add(paramanfv);
  }
  
  public abstract void b();
  
  public abstract void b(Canvas paramCanvas, long paramLong);
  
  public void b(anfv paramanfv)
  {
    paramanfv.c(true);
    paramanfv.d(true);
    float f = paramanfv.f();
    anfs.a(this.jdField_a_of_type_Ange, paramanfv);
    paramanfv.c((paramanfv.f() + paramanfv.f()) / (f + paramanfv.f()));
  }
  
  public abstract void c();
  
  public abstract void c(anfv paramanfv);
  
  public void d()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public abstract void d(anfv paramanfv);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     anfj
 * JD-Core Version:    0.7.0.1
 */