import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.qphone.base.util.QLog;

class bkxv
  implements avzm
{
  bkxv(bkxu parambkxu, blas paramblas, avza paramavza, PublishVideoEntry paramPublishVideoEntry, bkxx parambkxx) {}
  
  public void a()
  {
    if (this.jdField_a_of_type_Blas != null) {
      this.jdField_a_of_type_Blas.a(this.jdField_a_of_type_Avza.a, this.jdField_a_of_type_Avza.b);
    }
    QLog.w("MergeEditVideo", 1, "mp4ReEncoder start!");
  }
  
  public void a(String arg1)
  {
    synchronized (bkxu.a(this.jdField_a_of_type_Bkxu))
    {
      bkxu.a(this.jdField_a_of_type_Bkxu, true);
      bkxu.a(this.jdField_a_of_type_Bkxu).notifyAll();
      if (this.jdField_a_of_type_Blas != null) {
        this.jdField_a_of_type_Blas.a();
      }
      QLog.w("MergeEditVideo", 1, "mp4ReEncoder encode finish!");
      return;
    }
  }
  
  public void a_(int paramInt, Throwable arg2)
  {
    ved.c("MergeEditVideo", "encode error errorCode = " + paramInt + " Exception = ", ???);
    if (paramInt > 10000) {
      synchronized (bkxu.a(this.jdField_a_of_type_Bkxu))
      {
        bkxu.a(this.jdField_a_of_type_Bkxu, true);
        bkxu.a(this.jdField_a_of_type_Bkxu).notifyAll();
        return;
      }
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.isCancel)
    {
      this.jdField_a_of_type_Bkxx.c();
      QLog.w("MergeEditVideo", 1, "mergeVideo cancel!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkxv
 * JD-Core Version:    0.7.0.1
 */