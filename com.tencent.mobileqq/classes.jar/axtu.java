import android.text.TextUtils;

public class axtu
{
  public int a;
  public long a;
  public String a;
  public boolean a;
  public int b;
  public long b;
  public boolean b;
  public boolean c;
  
  public axtu()
  {
    this(null, 0, true, false);
  }
  
  public axtu(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(paramString, paramInt, paramBoolean1, paramBoolean2, 0L, 0L);
  }
  
  public axtu(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean2;
    this.jdField_b_of_type_Boolean = paramBoolean1;
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_b_of_type_Long = paramLong2;
  }
  
  public boolean a(axtu paramaxtu)
  {
    if (paramaxtu == null) {
      throw new NullPointerException();
    }
    boolean bool = false;
    if (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramaxtu.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_JavaLangString = paramaxtu.jdField_a_of_type_JavaLangString;
      bool = true;
    }
    if (this.jdField_a_of_type_Int != paramaxtu.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_Int = paramaxtu.jdField_a_of_type_Int;
      bool = true;
    }
    if (this.jdField_a_of_type_Boolean != paramaxtu.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = paramaxtu.jdField_a_of_type_Boolean;
      bool = true;
    }
    if (this.jdField_b_of_type_Boolean != paramaxtu.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = paramaxtu.jdField_b_of_type_Boolean;
      bool = true;
    }
    if (this.jdField_a_of_type_Long != paramaxtu.jdField_a_of_type_Long)
    {
      this.jdField_a_of_type_Long = paramaxtu.jdField_a_of_type_Long;
      bool = true;
    }
    if (this.jdField_b_of_type_Long != paramaxtu.jdField_b_of_type_Long)
    {
      this.jdField_b_of_type_Long = paramaxtu.jdField_b_of_type_Long;
      bool = true;
    }
    if (this.jdField_b_of_type_Int != paramaxtu.jdField_b_of_type_Int)
    {
      this.jdField_b_of_type_Int = paramaxtu.jdField_b_of_type_Int;
      bool = true;
    }
    if (this.c != paramaxtu.c)
    {
      this.c = paramaxtu.c;
      return true;
    }
    return bool;
  }
  
  public String toString()
  {
    return "inputFilePath=" + this.jdField_a_of_type_JavaLangString + " speedType=" + this.jdField_a_of_type_Int + " noSleep=" + this.jdField_a_of_type_Boolean + " repeat=" + this.jdField_b_of_type_Boolean + " startTimeMillSecond=" + this.jdField_a_of_type_Long + " endTimeMillSecond=" + this.jdField_b_of_type_Long;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axtu
 * JD-Core Version:    0.7.0.1
 */