import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.qphone.base.util.QLog;

class bnzw
  implements bagj
{
  bnzw(bnzv parambnzv, bobz parambobz, bafx parambafx, PublishVideoEntry paramPublishVideoEntry, bnzy parambnzy) {}
  
  public void onEncodeError(int paramInt, Throwable arg2)
  {
    xvv.c("MergeEditVideo", "encode error errorCode = " + paramInt + " Exception = ", ???);
    if (paramInt > 10000) {
      synchronized (bnzv.a(this.jdField_a_of_type_Bnzv))
      {
        bnzv.a(this.jdField_a_of_type_Bnzv, true);
        bnzv.a(this.jdField_a_of_type_Bnzv).notifyAll();
        return;
      }
    }
  }
  
  public void onEncodeFinish(String arg1)
  {
    synchronized (bnzv.a(this.jdField_a_of_type_Bnzv))
    {
      bnzv.a(this.jdField_a_of_type_Bnzv, true);
      bnzv.a(this.jdField_a_of_type_Bnzv).notifyAll();
      if (this.jdField_a_of_type_Bobz != null) {
        this.jdField_a_of_type_Bobz.a();
      }
      QLog.w("MergeEditVideo", 1, "mp4ReEncoder encode finish!");
      return;
    }
  }
  
  public void onEncodeFrame()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.isCancel)
    {
      this.jdField_a_of_type_Bnzy.a();
      QLog.w("MergeEditVideo", 1, "mergeVideo cancel!");
    }
  }
  
  public void onEncodeStart()
  {
    if (this.jdField_a_of_type_Bobz != null) {
      this.jdField_a_of_type_Bobz.a(this.jdField_a_of_type_Bafx.a, this.jdField_a_of_type_Bafx.b);
    }
    QLog.w("MergeEditVideo", 1, "mp4ReEncoder start!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnzw
 * JD-Core Version:    0.7.0.1
 */