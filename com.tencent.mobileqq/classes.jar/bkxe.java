import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.qphone.base.util.QLog;

class bkxe
  implements avzk
{
  bkxe(bkxd parambkxd, blab paramblab, avyy paramavyy, PublishVideoEntry paramPublishVideoEntry, bkxg parambkxg) {}
  
  public void a()
  {
    if (this.jdField_a_of_type_Blab != null) {
      this.jdField_a_of_type_Blab.a(this.jdField_a_of_type_Avyy.a, this.jdField_a_of_type_Avyy.b);
    }
    QLog.w("MergeEditVideo", 1, "mp4ReEncoder start!");
  }
  
  public void a(String arg1)
  {
    synchronized (bkxd.a(this.jdField_a_of_type_Bkxd))
    {
      bkxd.a(this.jdField_a_of_type_Bkxd, true);
      bkxd.a(this.jdField_a_of_type_Bkxd).notifyAll();
      if (this.jdField_a_of_type_Blab != null) {
        this.jdField_a_of_type_Blab.a();
      }
      QLog.w("MergeEditVideo", 1, "mp4ReEncoder encode finish!");
      return;
    }
  }
  
  public void a_(int paramInt, Throwable arg2)
  {
    veg.c("MergeEditVideo", "encode error errorCode = " + paramInt + " Exception = ", ???);
    if (paramInt > 10000) {
      synchronized (bkxd.a(this.jdField_a_of_type_Bkxd))
      {
        bkxd.a(this.jdField_a_of_type_Bkxd, true);
        bkxd.a(this.jdField_a_of_type_Bkxd).notifyAll();
        return;
      }
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.isCancel)
    {
      this.jdField_a_of_type_Bkxg.c();
      QLog.w("MergeEditVideo", 1, "mergeVideo cancel!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkxe
 * JD-Core Version:    0.7.0.1
 */