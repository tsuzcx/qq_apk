import com.tencent.mobileqq.app.GroupIconHelper;
import com.tencent.mobileqq.util.FaceInfo;
import com.tencent.qphone.base.util.QLog;

public class baxy
  implements baxw
{
  public String a;
  
  baxy(baxv parambaxv, baxt parambaxt)
  {
    if ((parambaxt != null) && (parambaxt.a != null)) {
      this.jdField_a_of_type_JavaLangString = parambaxt.a.jdField_a_of_type_JavaLangString;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    int i;
    if (GroupIconHelper.a(paramString)) {
      i = 1001;
    }
    for (String str = GroupIconHelper.b(paramString);; str = paramString)
    {
      if (paramBoolean2) {
        this.jdField_a_of_type_Baxv.a(paramBoolean1, i, str, this.jdField_a_of_type_Baxv.a);
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.qqhead.FaceDrawableImpl", 2, "====faceDrawableImpl onUpdateDiscussionFaceIcon === isSuccess: " + paramBoolean1 + ", isComplete: " + paramBoolean2 + ",disUin: " + paramString + ",type: " + i);
        }
        return;
        this.jdField_a_of_type_Baxv.a(paramBoolean1, i, str, null);
      }
      i = 101;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     baxy
 * JD-Core Version:    0.7.0.1
 */