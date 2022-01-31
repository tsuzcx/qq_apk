import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;

public class amwc
  extends amvl
{
  public ArCloudConfigInfo a;
  
  public amwc(String paramString, int paramInt1, int paramInt2, ArCloudConfigInfo paramArCloudConfigInfo, int paramInt3, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    super(paramString, paramInt1, paramInt2, paramInt3, paramFloat1, paramFloat2, paramFloat3);
    this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = paramArCloudConfigInfo;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("MultiFragmentAnimARResourceInfo{");
    localStringBuilder.append("key=").append(this.jdField_a_of_type_JavaLangString).append('\'');
    localStringBuilder.append(", arType=").append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", trackMode=").append(this.b);
    localStringBuilder.append(", arResourceInfo=").append(this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amwc
 * JD-Core Version:    0.7.0.1
 */