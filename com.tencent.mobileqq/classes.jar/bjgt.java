import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.qphone.base.util.QLog;

class bjgt
  implements auzr
{
  bjgt(bjgs parambjgs, bjjq parambjjq, auzf paramauzf, PublishVideoEntry paramPublishVideoEntry, bjgv parambjgv) {}
  
  public void a()
  {
    if (this.jdField_a_of_type_Bjjq != null) {
      this.jdField_a_of_type_Bjjq.a(this.jdField_a_of_type_Auzf.a, this.jdField_a_of_type_Auzf.b);
    }
    QLog.w("MergeEditVideo", 1, "mp4ReEncoder start!");
  }
  
  public void a(String arg1)
  {
    synchronized (bjgs.a(this.jdField_a_of_type_Bjgs))
    {
      bjgs.a(this.jdField_a_of_type_Bjgs, true);
      bjgs.a(this.jdField_a_of_type_Bjgs).notifyAll();
      if (this.jdField_a_of_type_Bjjq != null) {
        this.jdField_a_of_type_Bjjq.a();
      }
      QLog.w("MergeEditVideo", 1, "mp4ReEncoder encode finish!");
      return;
    }
  }
  
  public void a_(int paramInt, Throwable arg2)
  {
    urk.c("MergeEditVideo", "encode error errorCode = " + paramInt + " Exception = ", ???);
    if (paramInt > 10000) {
      synchronized (bjgs.a(this.jdField_a_of_type_Bjgs))
      {
        bjgs.a(this.jdField_a_of_type_Bjgs, true);
        bjgs.a(this.jdField_a_of_type_Bjgs).notifyAll();
        return;
      }
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.isCancel)
    {
      this.jdField_a_of_type_Bjgv.c();
      QLog.w("MergeEditVideo", 1, "mergeVideo cancel!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjgt
 * JD-Core Version:    0.7.0.1
 */