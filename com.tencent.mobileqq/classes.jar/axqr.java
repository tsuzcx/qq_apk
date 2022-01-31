import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class axqr
{
  public final int a;
  public final long a;
  private List<axpr> a;
  private int b;
  public final long b;
  private int c;
  
  public axqr(int paramInt, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_b_of_type_Long = paramLong2;
  }
  
  private void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((axpr)localIterator.next()).b();
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_Int = 0;
  }
  
  private void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((axpr)localIterator.next()).c();
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_Int = 0;
  }
  
  public int a(float paramFloat)
  {
    int i = this.jdField_a_of_type_JavaUtilList.size();
    if (i >= 6)
    {
      axpr localaxpr1 = (axpr)this.jdField_a_of_type_JavaUtilList.get(0);
      axpr localaxpr2 = (axpr)this.jdField_a_of_type_JavaUtilList.get(i - 1);
      float f = (float)(localaxpr2.b() - localaxpr1.b()) * 1000.0F / (i - 1);
      paramFloat = (float)(Math.abs(localaxpr2.a()) - Math.abs(localaxpr1.a())) / ((i - 1) * paramFloat);
      f = 1.1F * f;
      if (f < paramFloat) {
        return 1;
      }
      i = (int)Math.floor(f / (f - paramFloat));
      wsv.a("FlowEdit_VideoFlowDecodeTask", "averageDecodeTime = %.1f us, averagePlayTime = %.1f us, dropRate = %d", Float.valueOf(f), Float.valueOf(paramFloat), Integer.valueOf(i));
      return Math.min(8, i);
    }
    return 1;
  }
  
  public String toString()
  {
    return "DecodeSegmentInfo{Index=" + this.jdField_a_of_type_Int + ", StartUs=" + this.jdField_a_of_type_Long + ", EndUs=" + this.jdField_b_of_type_Long + ", Size=" + this.jdField_a_of_type_JavaUtilList.size() + ", Decoding=" + this.jdField_b_of_type_Int + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axqr
 * JD-Core Version:    0.7.0.1
 */