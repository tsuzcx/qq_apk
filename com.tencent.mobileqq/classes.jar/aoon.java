import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;

class aoon
  extends aojs
{
  private aoon(aooj paramaooj) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (aooj.a(this.a) == null) {}
    do
    {
      return;
      if (this.a.jdField_a_of_type_Aooi != null)
      {
        Bitmap localBitmap = this.a.a(113, paramString, 0, (byte)3);
        if ((paramBoolean1) && (localBitmap != null))
        {
          this.a.jdField_a_of_type_Aooi.onDecodeTaskCompleted(this.a.b + this.a.jdField_a_of_type_JavaUtilLinkedList.size(), 113, paramString, localBitmap);
          if (QLog.isColorLevel()) {
            QLog.i("Q.qqhead.FaceDecoderImpl", 2, "====faceDecoderImpl onUpdateNewTroopFaceIcon === isSuccess: " + paramBoolean1 + ", isComplete: " + paramBoolean2 + ",disUin: " + paramString + ",type: " + 113 + ",style: " + -1);
          }
        }
      }
    } while ((this.a.jdField_a_of_type_Boolean) || (this.a.jdField_a_of_type_JavaUtilLinkedList.isEmpty()) || (this.a.b >= this.a.jdField_a_of_type_Int));
    this.a.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoon
 * JD-Core Version:    0.7.0.1
 */