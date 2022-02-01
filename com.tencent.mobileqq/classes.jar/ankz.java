import java.util.ArrayList;
import java.util.List;

class ankz
{
  public int a;
  public String a;
  public List<ankx> a;
  public List<ankw> b = new ArrayList();
  
  public ankz()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("ThunderConfig{");
    localStringBuffer.append("mPageId=").append(this.jdField_a_of_type_Int);
    localStringBuffer.append(", mMd5='").append(this.jdField_a_of_type_JavaLangString).append('\'');
    localStringBuffer.append(", mCmdConfigs=").append(this.jdField_a_of_type_JavaUtilList);
    localStringBuffer.append(", mCGIConfigs=").append(this.b);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ankz
 * JD-Core Version:    0.7.0.1
 */