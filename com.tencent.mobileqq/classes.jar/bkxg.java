import com.tencent.tar.jni.ScanFeatureFilterView;

public final class bkxg
{
  public float a;
  public int a;
  public long a;
  public boolean a;
  public float b;
  public int b;
  public long b;
  public boolean b;
  
  public float a(int paramInt, long paramLong)
  {
    if (paramLong < this.jdField_b_of_type_Long) {
      return 0.0F;
    }
    if (paramLong - this.jdField_b_of_type_Long > paramInt) {
      this.jdField_a_of_type_Boolean = true;
    }
    return (float)(paramLong - this.jdField_b_of_type_Long) / paramInt % 1.0F;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Long = ScanFeatureFilterView.a();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkxg
 * JD-Core Version:    0.7.0.1
 */