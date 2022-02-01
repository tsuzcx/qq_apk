import android.graphics.Canvas;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public abstract class arqz
{
  protected int a;
  protected arra a;
  protected arru a;
  protected final arsm a;
  protected arsz a;
  protected arte a;
  private ArrayList<arsp> a;
  protected final List<arrl> a;
  protected final TreeSet<arrl> a;
  
  protected arqz(arru paramarru, arra paramarra, Comparator<arrl> paramComparator, arte paramarte, arsz paramarsz)
  {
    this.jdField_a_of_type_Arru = paramarru;
    this.jdField_a_of_type_Arra = paramarra;
    this.jdField_a_of_type_Arte = paramarte;
    this.jdField_a_of_type_Arsz = paramarsz;
    this.jdField_a_of_type_Arsm = new arsm(paramarra);
    this.jdField_a_of_type_JavaUtilTreeSet = new TreeSet(paramComparator);
    this.jdField_a_of_type_JavaUtilList = new LinkedList();
    a();
  }
  
  public static arqz a(arru paramarru, arra paramarra, Comparator<arrl> paramComparator, arte paramarte, arsz paramarsz)
  {
    return new arrk(paramarru, paramarra, paramComparator, paramarte, paramarsz);
  }
  
  private void a(Canvas paramCanvas, arru paramarru, long paramLong)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (paramCanvas != null))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((arsp)localIterator.next()).a(paramCanvas, paramarru, paramLong);
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public abstract arrl a(arti paramarti);
  
  public List<arrl> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a() {}
  
  public final void a(Canvas paramCanvas, long paramLong)
  {
    b(paramCanvas, paramLong);
    a(paramCanvas, this.jdField_a_of_type_Arru, paramLong);
  }
  
  protected void a(Canvas paramCanvas, arrl paramarrl)
  {
    arsl localarsl = this.jdField_a_of_type_Arru.a(paramarrl);
    this.jdField_a_of_type_Arsm.a(paramCanvas, paramarrl, this.jdField_a_of_type_Arru, localarsl);
    paramarrl.f();
  }
  
  public void a(arrl paramarrl)
  {
    this.jdField_a_of_type_JavaUtilTreeSet.add(paramarrl);
  }
  
  public abstract void b();
  
  public abstract void b(Canvas paramCanvas, long paramLong);
  
  public void b(arrl paramarrl)
  {
    paramarrl.c(true);
    paramarrl.d(true);
    float f = paramarrl.f();
    arri.a(this.jdField_a_of_type_Arru, paramarrl);
    paramarrl.c((paramarrl.f() + paramarrl.f()) / (f + paramarrl.f()));
  }
  
  public abstract void c();
  
  public abstract void c(arrl paramarrl);
  
  public void d()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public abstract void d(arrl paramarrl);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arqz
 * JD-Core Version:    0.7.0.1
 */