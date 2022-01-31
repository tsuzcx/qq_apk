import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bcee
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private ArrayList<bcea> jdField_a_of_type_JavaUtilArrayList;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  
  public bcee()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilArrayList = null;
  }
  
  public bcee(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, ArrayList<bcea> paramArrayList)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_b_of_type_Long = (System.currentTimeMillis() + paramInt1 * 1000);
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_b_of_type_Int = paramInt3;
    this.jdField_c_of_type_Int = (paramInt4 * 1000);
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public bcea a(long paramLong)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      bcea localbcea = (bcea)localIterator.next();
      if (localbcea.a() == paramLong) {
        return localbcea;
      }
    }
    return null;
  }
  
  public ArrayList<bcea> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public List<Long> a()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(Long.valueOf(((bcea)localIterator.next()).a()));
    }
    return localArrayList;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.jdField_c_of_type_Long = paramLong;
  }
  
  public boolean a(long paramLong)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      bcea localbcea = (bcea)localIterator.next();
      if ((localbcea.a() != paramLong) && (localbcea.a() == 0)) {
        return false;
      }
    }
    return true;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public long b()
  {
    return this.jdField_c_of_type_Long;
  }
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public int c()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public void c(int paramInt)
  {
    this.jdField_b_of_type_Long = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcee
 * JD-Core Version:    0.7.0.1
 */