import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class bmkp
  implements blxj
{
  private int jdField_a_of_type_Int = -1;
  private bmnj jdField_a_of_type_Bmnj;
  private String jdField_a_of_type_JavaLangString = "";
  
  public bmkp(bmnj parambmnj)
  {
    this.jdField_a_of_type_Bmnj = parambmnj;
  }
  
  public void a(float paramFloat, String paramString, int paramInt) {}
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EditVideoAblumList", 2, "download Res Finished , type id, " + this.jdField_a_of_type_Int + " isSuccess : " + paramBoolean + " url : " + paramString + " StickerStr : " + this.jdField_a_of_type_JavaLangString + " mParent : " + this.jdField_a_of_type_Bmnj);
    }
    if ((this.jdField_a_of_type_Int != -1) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_Bmnj != null)) {
      this.jdField_a_of_type_Bmnj.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmkp
 * JD-Core Version:    0.7.0.1
 */