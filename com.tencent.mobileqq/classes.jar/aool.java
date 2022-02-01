import com.tencent.mobileqq.app.face.GroupIconHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;

class aool
  extends anwt
{
  private aool(aooj paramaooj) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (aooj.a(this.a) == null) {
      return;
    }
    String str;
    int i;
    if (this.a.jdField_a_of_type_Aooi != null)
    {
      if (!GroupIconHelper.a(paramString)) {
        break label223;
      }
      str = GroupIconHelper.b(paramString);
      i = 1001;
    }
    for (;;)
    {
      paramString = this.a.a(i, paramString, 0, (byte)3);
      if ((paramBoolean1) && (paramString != null)) {
        if (i != 1001) {
          break label185;
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.qqhead.FaceDecoderImpl", 2, "====faceDecoderImpl onUpdateDiscussionFaceIcon === isSuccess: " + paramBoolean1 + ", isComplete: " + paramBoolean2 + ",disUin: " + str + ",type: " + i + ",style: " + -1);
        }
        if ((this.a.jdField_a_of_type_Boolean) || (this.a.jdField_a_of_type_JavaUtilLinkedList.isEmpty()) || (this.a.b >= this.a.jdField_a_of_type_Int)) {
          break;
        }
        this.a.e();
        return;
        label185:
        this.a.jdField_a_of_type_Aooi.onDecodeTaskCompleted(this.a.b + this.a.jdField_a_of_type_JavaUtilLinkedList.size(), i, str, paramString);
      }
      label223:
      i = 101;
      str = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aool
 * JD-Core Version:    0.7.0.1
 */