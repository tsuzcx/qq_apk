import android.app.Activity;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class blrs
{
  public int a;
  protected SegmentKeeper a;
  public Object a;
  public ArrayList<blrt> a;
  public int b;
  protected int c;
  
  public blrs(Object paramObject)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Int = 2;
    this.jdField_a_of_type_JavaLangObject = paramObject;
  }
  
  public abstract float a();
  
  public abstract int a();
  
  public abstract int a(Activity paramActivity, int paramInt);
  
  public String a()
  {
    return String.valueOf(this.jdField_a_of_type_JavaLangObject.hashCode());
  }
  
  public void a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      if (localIterator.hasNext()) {
        ((blrt)localIterator.next()).a(this);
      }
    }
  }
  
  public void a(int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      if (localIterator.hasNext()) {
        ((blrt)localIterator.next()).a(this, paramInt);
      }
    }
  }
  
  public abstract void a(Activity paramActivity, int paramInt);
  
  public void a(blrt paramblrt)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramblrt)) {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramblrt);
      }
      return;
    }
  }
  
  public void a(SegmentKeeper paramSegmentKeeper)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper = paramSegmentKeeper;
  }
  
  public int b()
  {
    return 1;
  }
  
  public void b()
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      if (localIterator.hasNext()) {
        ((blrt)localIterator.next()).b(this);
      }
    }
  }
  
  public void b(Activity paramActivity, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blrs
 * JD-Core Version:    0.7.0.1
 */