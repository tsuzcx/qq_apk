import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.qphone.base.util.QLog;

class bnjf
  implements axrl
{
  bnjf(bnje parambnje, bnmc parambnmc, axqz paramaxqz, PublishVideoEntry paramPublishVideoEntry, bnjh parambnjh) {}
  
  public void a()
  {
    if (this.jdField_a_of_type_Bnmc != null) {
      this.jdField_a_of_type_Bnmc.a(this.jdField_a_of_type_Axqz.a, this.jdField_a_of_type_Axqz.b);
    }
    QLog.w("MergeEditVideo", 1, "mp4ReEncoder start!");
  }
  
  public void a(String arg1)
  {
    synchronized (bnje.a(this.jdField_a_of_type_Bnje))
    {
      bnje.a(this.jdField_a_of_type_Bnje, true);
      bnje.a(this.jdField_a_of_type_Bnje).notifyAll();
      if (this.jdField_a_of_type_Bnmc != null) {
        this.jdField_a_of_type_Bnmc.a();
      }
      QLog.w("MergeEditVideo", 1, "mp4ReEncoder encode finish!");
      return;
    }
  }
  
  public void a_(int paramInt, Throwable arg2)
  {
    wsv.c("MergeEditVideo", "encode error errorCode = " + paramInt + " Exception = ", ???);
    if (paramInt > 10000) {
      synchronized (bnje.a(this.jdField_a_of_type_Bnje))
      {
        bnje.a(this.jdField_a_of_type_Bnje, true);
        bnje.a(this.jdField_a_of_type_Bnje).notifyAll();
        return;
      }
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.isCancel)
    {
      this.jdField_a_of_type_Bnjh.c();
      QLog.w("MergeEditVideo", 1, "mergeVideo cancel!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnjf
 * JD-Core Version:    0.7.0.1
 */