import android.text.TextUtils;
import com.tencent.mobileqq.comment.DanmuItemBean;

public class aqsw
{
  public int a;
  public long a;
  public String a;
  public boolean a;
  public long b;
  public String b;
  public long c;
  public String c;
  public String d;
  
  public aqsw(DanmuItemBean paramDanmuItemBean)
  {
    this.jdField_a_of_type_Long = paramDanmuItemBean.jdField_b_of_type_Long;
    this.jdField_a_of_type_JavaLangString = String.valueOf(paramDanmuItemBean.jdField_a_of_type_Long);
    this.jdField_b_of_type_JavaLangString = paramDanmuItemBean.jdField_b_of_type_JavaLangString;
    this.jdField_c_of_type_JavaLangString = paramDanmuItemBean.jdField_a_of_type_JavaLangString;
    this.jdField_b_of_type_Long = paramDanmuItemBean.d;
    this.jdField_c_of_type_Long = paramDanmuItemBean.jdField_c_of_type_Long;
    this.jdField_a_of_type_Boolean = paramDanmuItemBean.jdField_a_of_type_Boolean;
    this.d = paramDanmuItemBean.jdField_c_of_type_JavaLangString;
    this.jdField_a_of_type_Int = paramDanmuItemBean.jdField_a_of_type_Int;
  }
  
  public String a()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (this.jdField_a_of_type_Boolean) {}
    for (String str = this.d;; str = this.jdField_b_of_type_JavaLangString) {
      return str + " : " + this.jdField_c_of_type_JavaLangString;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof aqsw))
    {
      paramObject = (aqsw)paramObject;
      bool1 = bool2;
      if (this.jdField_a_of_type_Long == paramObject.jdField_a_of_type_Long)
      {
        bool1 = bool2;
        if (this.jdField_b_of_type_Long == paramObject.jdField_b_of_type_Long)
        {
          bool1 = bool2;
          if (this.jdField_c_of_type_Long == paramObject.jdField_c_of_type_Long)
          {
            bool1 = bool2;
            if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
            {
              bool1 = bool2;
              if (!TextUtils.isEmpty(paramObject.jdField_a_of_type_JavaLangString))
              {
                bool1 = bool2;
                if (this.jdField_a_of_type_JavaLangString.equals(paramObject.jdField_a_of_type_JavaLangString)) {
                  bool1 = true;
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    return String.valueOf(this.jdField_a_of_type_Long).hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqsw
 * JD-Core Version:    0.7.0.1
 */