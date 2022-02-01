import android.view.View;
import java.util.ArrayList;
import java.util.List;

public class bmoz
{
  private float jdField_a_of_type_Float = 30.0F;
  private int jdField_a_of_type_Int = 30;
  private long jdField_a_of_type_Long;
  private View jdField_a_of_type_AndroidViewView;
  private bmoy jdField_a_of_type_Bmoy = new bmoy();
  private bmpd jdField_a_of_type_Bmpd;
  private ArrayList<bmpd> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private final List<bmpa> jdField_a_of_type_JavaUtilList = new ArrayList();
  private int jdField_b_of_type_Int = 15;
  private long jdField_b_of_type_Long;
  
  public bmoz()
  {
    c();
  }
  
  private int a(float paramFloat)
  {
    int j = 1;
    int k = this.jdField_a_of_type_JavaUtilArrayList.indexOf(this.jdField_a_of_type_Bmpd);
    int m = (int)(this.jdField_a_of_type_Float * paramFloat);
    int i;
    if (paramFloat > 1.0F) {
      if (m >= this.jdField_a_of_type_Int)
      {
        i = j;
        if (k - 1 >= 0)
        {
          i = j;
          if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
          {
            a((bmpd)this.jdField_a_of_type_JavaUtilArrayList.get(k - 1));
            i = 0;
          }
        }
      }
    }
    do
    {
      do
      {
        return i;
        return 2;
        i = j;
      } while (paramFloat >= 1.0F);
      if (m > this.jdField_b_of_type_Int) {
        break;
      }
      i = j;
    } while (k + 1 >= this.jdField_a_of_type_JavaUtilArrayList.size());
    a((bmpd)this.jdField_a_of_type_JavaUtilArrayList.get(k + 1));
    return 0;
    return 2;
  }
  
  private void a(bmpd parambmpd)
  {
    this.jdField_a_of_type_Bmpd = parambmpd;
    b();
  }
  
  private int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  private void b()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if (this.jdField_a_of_type_Bmpd != null)
    {
      int k = (int)this.jdField_a_of_type_Bmpd.a(b() - a());
      int i = 0;
      if (i < k + 1)
      {
        bmpa localbmpa = new bmpa();
        if (i % 2 == 0) {}
        for (int j = 0;; j = 1)
        {
          localbmpa.b(j);
          localbmpa.a(i);
          this.jdField_a_of_type_JavaUtilList.add(localbmpa);
          i += 1;
          break;
        }
      }
    }
  }
  
  private void b(float paramFloat)
  {
    this.jdField_a_of_type_Float *= paramFloat;
  }
  
  private void c()
  {
    Object localObject = new bmpb(1.0F);
    this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
    localObject = new bmpb(1.5F);
    this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
    localObject = new bmpb(2.5F);
    this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
    localObject = new bmpb(5.0F);
    this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
    localObject = new bmpb(7.5F);
    this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
    localObject = new bmpc(0.5F);
    this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
    localObject = new bmpc(1.0F);
    this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
    localObject = new bmpc(1.5F);
    this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
    localObject = new bmpc(2.5F);
    this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
    localObject = new bmpc(5.0F);
    this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
    this.jdField_a_of_type_Bmpd = ((bmpd)this.jdField_a_of_type_JavaUtilArrayList.get(6));
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public float a(long paramLong)
  {
    float f = 0.0F;
    if (this.jdField_a_of_type_Bmpd != null) {
      f = this.jdField_a_of_type_Bmpd.a(paramLong);
    }
    return f;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int a(long paramLong)
  {
    return (int)(this.jdField_a_of_type_Float * this.jdField_a_of_type_Bmpd.a(paramLong));
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public long a(float paramFloat)
  {
    paramFloat /= this.jdField_a_of_type_Float;
    long l = a();
    return this.jdField_a_of_type_Bmpd.a(paramFloat) + l;
  }
  
  public long a(bmpa parambmpa)
  {
    if (parambmpa == null) {
      return -1L;
    }
    try
    {
      long l1 = a();
      long l2 = this.jdField_a_of_type_Bmpd.a(parambmpa.a());
      return l2 + l1;
    }
    catch (IllegalArgumentException parambmpa)
    {
      parambmpa.printStackTrace();
    }
    return -1L;
  }
  
  public String a(bmpa parambmpa)
  {
    if (parambmpa == null) {
      return null;
    }
    try
    {
      long l1 = a();
      long l2 = this.jdField_a_of_type_Bmpd.a(parambmpa.a());
      parambmpa = this.jdField_a_of_type_Bmpd.a(l1 + l2);
      return parambmpa;
    }
    catch (IllegalArgumentException parambmpa)
    {
      parambmpa.printStackTrace();
    }
    return null;
  }
  
  public List<bmpa> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    float f = 0.0F;
    bmoy localbmoy;
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      localbmoy = this.jdField_a_of_type_Bmoy;
      if (this.jdField_a_of_type_Float > 0.0F) {
        break label29;
      }
    }
    for (;;)
    {
      localbmoy.a(f);
      return;
      label29:
      f = this.jdField_a_of_type_AndroidViewView.getScrollX() / this.jdField_a_of_type_Float;
    }
  }
  
  public void a(float paramFloat)
  {
    long l = c();
    int i = a(paramFloat);
    if (i != 1)
    {
      if (i != 0) {
        break label70;
      }
      if (paramFloat <= 1.0F) {
        break label58;
      }
      this.jdField_a_of_type_Float = b();
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView.invalidate();
      i = a(l);
      this.jdField_a_of_type_AndroidViewView.scrollTo(i, 0);
      return;
      label58:
      this.jdField_a_of_type_Float = a();
      continue;
      label70:
      b(paramFloat);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Float = paramInt;
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_Bmpd != null) {
      this.jdField_b_of_type_Long = paramLong;
    }
    b();
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public long b()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public long b(float paramFloat)
  {
    if ((int)(a() * a(b())) <= paramFloat) {
      return b();
    }
    paramFloat /= this.jdField_a_of_type_Float;
    long l = a();
    return this.jdField_a_of_type_Bmpd.a(paramFloat) + l;
  }
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public long c()
  {
    return a() + this.jdField_a_of_type_Bmpd.a(this.jdField_a_of_type_Bmoy.a());
  }
  
  public void c(int paramInt)
  {
    if (paramInt > this.jdField_a_of_type_JavaUtilArrayList.size() - 1) {
      return;
    }
    this.jdField_a_of_type_Bmpd = ((bmpd)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmoz
 * JD-Core Version:    0.7.0.1
 */