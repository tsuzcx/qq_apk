import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class bjuc
  implements bjgv
{
  private int jdField_a_of_type_Int = -1;
  private bjww jdField_a_of_type_Bjww;
  private String jdField_a_of_type_JavaLangString = "";
  
  public bjuc(bjww parambjww)
  {
    this.jdField_a_of_type_Bjww = parambjww;
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
      QLog.d("EditVideoAblumList", 2, "download Res Finished , type id, " + this.jdField_a_of_type_Int + " isSuccess : " + paramBoolean + " url : " + paramString + " StickerStr : " + this.jdField_a_of_type_JavaLangString + " mParent : " + this.jdField_a_of_type_Bjww);
    }
    if ((this.jdField_a_of_type_Int != -1) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_Bjww != null)) {
      this.jdField_a_of_type_Bjww.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjuc
 * JD-Core Version:    0.7.0.1
 */