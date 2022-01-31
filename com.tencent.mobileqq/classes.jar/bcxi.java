import com.tencent.mobileqq.util.FaceInfo;
import com.tencent.qphone.base.util.QLog;

public class bcxi
  implements bcxj
{
  public String a;
  
  bcxi(bcxd parambcxd, bcxb parambcxb)
  {
    if ((parambcxb != null) && (parambcxb.a != null)) {
      this.jdField_a_of_type_JavaLangString = parambcxb.a.jdField_a_of_type_JavaLangString;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (paramBoolean2) {
      this.jdField_a_of_type_Bcxd.a(paramBoolean1, 113, paramString, this.jdField_a_of_type_Bcxd.a);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.FaceDrawableImpl", 2, "====faceDrawableImpl onUpdateGroupFaceIcon === isSuccess: " + paramBoolean1 + ", isComplete: " + paramBoolean2 + ",disUin: " + paramString + ",type: " + 113);
      }
      return;
      this.jdField_a_of_type_Bcxd.a(paramBoolean1, 113, paramString, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcxi
 * JD-Core Version:    0.7.0.1
 */