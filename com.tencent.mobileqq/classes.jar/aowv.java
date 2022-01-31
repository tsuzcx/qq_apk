import android.graphics.Canvas;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public abstract class aowv
{
  protected int a;
  protected aoww a;
  protected aoxq a;
  protected final aoyi a;
  protected aoyv a;
  protected aoza a;
  private ArrayList<aoyl> a;
  protected final List<aoxh> a;
  protected final TreeSet<aoxh> a;
  
  protected aowv(aoxq paramaoxq, aoww paramaoww, Comparator<aoxh> paramComparator, aoza paramaoza, aoyv paramaoyv)
  {
    this.jdField_a_of_type_Aoxq = paramaoxq;
    this.jdField_a_of_type_Aoww = paramaoww;
    this.jdField_a_of_type_Aoza = paramaoza;
    this.jdField_a_of_type_Aoyv = paramaoyv;
    this.jdField_a_of_type_Aoyi = new aoyi(paramaoww);
    this.jdField_a_of_type_JavaUtilTreeSet = new TreeSet(paramComparator);
    this.jdField_a_of_type_JavaUtilList = new LinkedList();
    a();
  }
  
  public static aowv a(aoxq paramaoxq, aoww paramaoww, Comparator<aoxh> paramComparator, aoza paramaoza, aoyv paramaoyv)
  {
    return new aoxg(paramaoxq, paramaoww, paramComparator, paramaoza, paramaoyv);
  }
  
  private void a(Canvas paramCanvas, aoxq paramaoxq, long paramLong)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (paramCanvas != null))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((aoyl)localIterator.next()).a(paramCanvas, paramaoxq, paramLong);
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public abstract aoxh a(aoze paramaoze);
  
  public List<aoxh> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a() {}
  
  public final void a(Canvas paramCanvas, long paramLong)
  {
    b(paramCanvas, paramLong);
    a(paramCanvas, this.jdField_a_of_type_Aoxq, paramLong);
  }
  
  protected void a(Canvas paramCanvas, aoxh paramaoxh)
  {
    aoyh localaoyh = this.jdField_a_of_type_Aoxq.a(paramaoxh);
    this.jdField_a_of_type_Aoyi.a(paramCanvas, paramaoxh, this.jdField_a_of_type_Aoxq, localaoyh);
    paramaoxh.f();
  }
  
  public void a(aoxh paramaoxh)
  {
    this.jdField_a_of_type_JavaUtilTreeSet.add(paramaoxh);
  }
  
  public abstract void b();
  
  public abstract void b(Canvas paramCanvas, long paramLong);
  
  public void b(aoxh paramaoxh)
  {
    paramaoxh.c(true);
    paramaoxh.d(true);
    float f = paramaoxh.f();
    aoxe.a(this.jdField_a_of_type_Aoxq, paramaoxh);
    paramaoxh.c((paramaoxh.f() + paramaoxh.f()) / (f + paramaoxh.f()));
  }
  
  public abstract void c();
  
  public abstract void c(aoxh paramaoxh);
  
  public void d()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public abstract void d(aoxh paramaoxh);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aowv
 * JD-Core Version:    0.7.0.1
 */