import android.graphics.Canvas;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public abstract class apbe
{
  protected int a;
  protected apbf a;
  protected apbz a;
  protected final apcr a;
  protected apde a;
  protected apdj a;
  private ArrayList<apcu> a;
  protected final List<apbq> a;
  protected final TreeSet<apbq> a;
  
  protected apbe(apbz paramapbz, apbf paramapbf, Comparator<apbq> paramComparator, apdj paramapdj, apde paramapde)
  {
    this.jdField_a_of_type_Apbz = paramapbz;
    this.jdField_a_of_type_Apbf = paramapbf;
    this.jdField_a_of_type_Apdj = paramapdj;
    this.jdField_a_of_type_Apde = paramapde;
    this.jdField_a_of_type_Apcr = new apcr(paramapbf);
    this.jdField_a_of_type_JavaUtilTreeSet = new TreeSet(paramComparator);
    this.jdField_a_of_type_JavaUtilList = new LinkedList();
    a();
  }
  
  public static apbe a(apbz paramapbz, apbf paramapbf, Comparator<apbq> paramComparator, apdj paramapdj, apde paramapde)
  {
    return new apbp(paramapbz, paramapbf, paramComparator, paramapdj, paramapde);
  }
  
  private void a(Canvas paramCanvas, apbz paramapbz, long paramLong)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (paramCanvas != null))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((apcu)localIterator.next()).a(paramCanvas, paramapbz, paramLong);
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public abstract apbq a(apdn paramapdn);
  
  public List<apbq> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a() {}
  
  public final void a(Canvas paramCanvas, long paramLong)
  {
    b(paramCanvas, paramLong);
    a(paramCanvas, this.jdField_a_of_type_Apbz, paramLong);
  }
  
  protected void a(Canvas paramCanvas, apbq paramapbq)
  {
    apcq localapcq = this.jdField_a_of_type_Apbz.a(paramapbq);
    this.jdField_a_of_type_Apcr.a(paramCanvas, paramapbq, this.jdField_a_of_type_Apbz, localapcq);
    paramapbq.f();
  }
  
  public void a(apbq paramapbq)
  {
    this.jdField_a_of_type_JavaUtilTreeSet.add(paramapbq);
  }
  
  public abstract void b();
  
  public abstract void b(Canvas paramCanvas, long paramLong);
  
  public void b(apbq paramapbq)
  {
    paramapbq.c(true);
    paramapbq.d(true);
    float f = paramapbq.f();
    apbn.a(this.jdField_a_of_type_Apbz, paramapbq);
    paramapbq.c((paramapbq.f() + paramapbq.f()) / (f + paramapbq.f()));
  }
  
  public abstract void c();
  
  public abstract void c(apbq paramapbq);
  
  public void d()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public abstract void d(apbq paramapbq);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apbe
 * JD-Core Version:    0.7.0.1
 */