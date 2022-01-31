import com.tencent.commonsdk.pool.RecyclablePool.Recyclable;

public class axtx
  extends RecyclablePool.Recyclable
{
  public long a;
  public String a;
  public boolean a;
  public long b;
  public String b;
  public long c;
  public long d;
  
  public void recycle()
  {
    super.recycle();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    localStringBuilder.append("StorageItem info[size=").append(this.jdField_a_of_type_Long);
    localStringBuilder.append(",accessTime=").append(this.jdField_b_of_type_Long);
    localStringBuilder.append(",isFile=").append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(",fileCount=").append(this.c);
    localStringBuilder.append(",dirCount=").append(this.d);
    localStringBuilder.append(",name=").append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(",path=").append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axtx
 * JD-Core Version:    0.7.0.1
 */