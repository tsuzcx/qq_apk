import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.qphone.base.util.QLog;

class bqel
  implements batv
{
  bqel(bqek parambqek, bqhc parambqhc, batj parambatj, PublishVideoEntry paramPublishVideoEntry, bqen parambqen) {}
  
  public void a()
  {
    if (this.jdField_a_of_type_Bqhc != null) {
      this.jdField_a_of_type_Bqhc.a(this.jdField_a_of_type_Batj.a, this.jdField_a_of_type_Batj.b);
    }
    QLog.w("MergeEditVideo", 1, "mp4ReEncoder start!");
  }
  
  public void a(String arg1)
  {
    synchronized (bqek.a(this.jdField_a_of_type_Bqek))
    {
      bqek.a(this.jdField_a_of_type_Bqek, true);
      bqek.a(this.jdField_a_of_type_Bqek).notifyAll();
      if (this.jdField_a_of_type_Bqhc != null) {
        this.jdField_a_of_type_Bqhc.a();
      }
      QLog.w("MergeEditVideo", 1, "mp4ReEncoder encode finish!");
      return;
    }
  }
  
  public void a_(int paramInt, Throwable arg2)
  {
    yqp.c("MergeEditVideo", "encode error errorCode = " + paramInt + " Exception = ", ???);
    if (paramInt > 10000) {
      synchronized (bqek.a(this.jdField_a_of_type_Bqek))
      {
        bqek.a(this.jdField_a_of_type_Bqek, true);
        bqek.a(this.jdField_a_of_type_Bqek).notifyAll();
        return;
      }
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.isCancel)
    {
      this.jdField_a_of_type_Bqen.c();
      QLog.w("MergeEditVideo", 1, "mergeVideo cancel!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqel
 * JD-Core Version:    0.7.0.1
 */