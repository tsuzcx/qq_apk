import java.util.ArrayList;
import java.util.List;

public class ashy
{
  public int a;
  public long a;
  public String a;
  public List<asht> a;
  public boolean a;
  public byte[] a;
  public int b;
  public int c;
  
  public ashy()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramObject != null)
    {
      bool1 = bool2;
      if ((paramObject instanceof ashy))
      {
        paramObject = (ashy)paramObject;
        bool1 = bool2;
        if (paramObject.jdField_a_of_type_JavaLangString != null)
        {
          bool1 = bool2;
          if (this.jdField_a_of_type_JavaLangString.equals(paramObject.jdField_a_of_type_JavaLangString)) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mUpdateTime").append("=").append(this.jdField_a_of_type_Long);
    localStringBuilder.append(" ").append("mUpdateTime").append("=").append(this.jdField_a_of_type_Long);
    localStringBuilder.append(" ").append("mSearchKey").append("=").append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(" ").append("mLoadOver").append("=").append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(" ").append("mCurPos").append("=").append(this.b);
    localStringBuilder.append(" ").append("mOffset").append("=").append(this.c);
    localStringBuilder.append(" ").append("size").append("=").append(this.jdField_a_of_type_JavaUtilList.size());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ashy
 * JD-Core Version:    0.7.0.1
 */