import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.qphone.base.util.QLog;

class bnnr
  implements axvu
{
  bnnr(bnnq parambnnq, bnqo parambnqo, axvi paramaxvi, PublishVideoEntry paramPublishVideoEntry, bnnt parambnnt) {}
  
  public void a()
  {
    if (this.jdField_a_of_type_Bnqo != null) {
      this.jdField_a_of_type_Bnqo.a(this.jdField_a_of_type_Axvi.a, this.jdField_a_of_type_Axvi.b);
    }
    QLog.w("MergeEditVideo", 1, "mp4ReEncoder start!");
  }
  
  public void a(String arg1)
  {
    synchronized (bnnq.a(this.jdField_a_of_type_Bnnq))
    {
      bnnq.a(this.jdField_a_of_type_Bnnq, true);
      bnnq.a(this.jdField_a_of_type_Bnnq).notifyAll();
      if (this.jdField_a_of_type_Bnqo != null) {
        this.jdField_a_of_type_Bnqo.a();
      }
      QLog.w("MergeEditVideo", 1, "mp4ReEncoder encode finish!");
      return;
    }
  }
  
  public void a_(int paramInt, Throwable arg2)
  {
    wxe.c("MergeEditVideo", "encode error errorCode = " + paramInt + " Exception = ", ???);
    if (paramInt > 10000) {
      synchronized (bnnq.a(this.jdField_a_of_type_Bnnq))
      {
        bnnq.a(this.jdField_a_of_type_Bnnq, true);
        bnnq.a(this.jdField_a_of_type_Bnnq).notifyAll();
        return;
      }
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.isCancel)
    {
      this.jdField_a_of_type_Bnnt.c();
      QLog.w("MergeEditVideo", 1, "mergeVideo cancel!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnnr
 * JD-Core Version:    0.7.0.1
 */