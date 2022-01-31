import com.tencent.mobileqq.data.EmoticonPackage;

public class apsm
{
  public int a;
  public EmoticonPackage a;
  public int b;
  
  public apsm(int paramInt1, int paramInt2, EmoticonPackage paramEmoticonPackage)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage = paramEmoticonPackage;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof apsm)) {
        return false;
      }
      paramObject = (apsm)paramObject;
      if ((this.jdField_a_of_type_Int != paramObject.jdField_a_of_type_Int) || (this.b != paramObject.b)) {
        break;
      }
    } while (((this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage == null) && (paramObject.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage == null)) || ((this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage != null) && (paramObject.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage != null) && (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId != null) && (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId.equals(paramObject.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId))));
    return false;
    return false;
  }
  
  public String toString()
  {
    String str = "";
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage != null) {
      str = this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId;
    }
    return "EmotionPanelInfo [type=" + this.jdField_a_of_type_Int + ", columnNum=" + this.b + ", epid=" + str + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apsm
 * JD-Core Version:    0.7.0.1
 */