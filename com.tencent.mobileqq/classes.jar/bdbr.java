import com.tencent.mobileqq.util.FaceInfo;
import com.tencent.qphone.base.util.QLog;

public class bdbr
  implements bdbs
{
  public String a;
  
  bdbr(bdbm parambdbm, bdbk parambdbk)
  {
    if ((parambdbk != null) && (parambdbk.a != null)) {
      this.jdField_a_of_type_JavaLangString = parambdbk.a.jdField_a_of_type_JavaLangString;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (paramBoolean2) {
      this.jdField_a_of_type_Bdbm.a(paramBoolean1, 113, paramString, this.jdField_a_of_type_Bdbm.a);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.FaceDrawableImpl", 2, "====faceDrawableImpl onUpdateGroupFaceIcon === isSuccess: " + paramBoolean1 + ", isComplete: " + paramBoolean2 + ",disUin: " + paramString + ",type: " + 113);
      }
      return;
      this.jdField_a_of_type_Bdbm.a(paramBoolean1, 113, paramString, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdbr
 * JD-Core Version:    0.7.0.1
 */