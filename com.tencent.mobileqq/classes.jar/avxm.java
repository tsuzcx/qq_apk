import android.text.TextUtils;

public class avxm
{
  public int a;
  public long a;
  public String a;
  public boolean a;
  public int b;
  public long b;
  public boolean b;
  public boolean c;
  
  public avxm()
  {
    this(null, 0, true, false);
  }
  
  public avxm(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(paramString, paramInt, paramBoolean1, paramBoolean2, 0L, 0L);
  }
  
  public avxm(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean2;
    this.jdField_b_of_type_Boolean = paramBoolean1;
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_b_of_type_Long = paramLong2;
  }
  
  public boolean a(avxm paramavxm)
  {
    if (paramavxm == null) {
      throw new NullPointerException();
    }
    boolean bool = false;
    if (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramavxm.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_JavaLangString = paramavxm.jdField_a_of_type_JavaLangString;
      bool = true;
    }
    if (this.jdField_a_of_type_Int != paramavxm.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_Int = paramavxm.jdField_a_of_type_Int;
      bool = true;
    }
    if (this.jdField_a_of_type_Boolean != paramavxm.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = paramavxm.jdField_a_of_type_Boolean;
      bool = true;
    }
    if (this.jdField_b_of_type_Boolean != paramavxm.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = paramavxm.jdField_b_of_type_Boolean;
      bool = true;
    }
    if (this.jdField_a_of_type_Long != paramavxm.jdField_a_of_type_Long)
    {
      this.jdField_a_of_type_Long = paramavxm.jdField_a_of_type_Long;
      bool = true;
    }
    if (this.jdField_b_of_type_Long != paramavxm.jdField_b_of_type_Long)
    {
      this.jdField_b_of_type_Long = paramavxm.jdField_b_of_type_Long;
      bool = true;
    }
    if (this.jdField_b_of_type_Int != paramavxm.jdField_b_of_type_Int)
    {
      this.jdField_b_of_type_Int = paramavxm.jdField_b_of_type_Int;
      bool = true;
    }
    if (this.c != paramavxm.c)
    {
      this.c = paramavxm.c;
      return true;
    }
    return bool;
  }
  
  public String toString()
  {
    return "inputFilePath=" + this.jdField_a_of_type_JavaLangString + " speedType=" + this.jdField_a_of_type_Int + " noSleep=" + this.jdField_a_of_type_Boolean + " repeat=" + this.jdField_b_of_type_Boolean + " startTimeMillSecond=" + this.jdField_a_of_type_Long + " endTimeMillSecond=" + this.jdField_b_of_type_Long;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avxm
 * JD-Core Version:    0.7.0.1
 */