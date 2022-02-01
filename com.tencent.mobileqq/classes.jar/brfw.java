import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.qphone.base.util.QLog;

class brfw
  implements bbmo
{
  brfw(brfv parambrfv, brio parambrio, bbmc parambbmc, PublishVideoEntry paramPublishVideoEntry, brfy parambrfy) {}
  
  public void a()
  {
    if (this.jdField_a_of_type_Brio != null) {
      this.jdField_a_of_type_Brio.a(this.jdField_a_of_type_Bbmc.a, this.jdField_a_of_type_Bbmc.b);
    }
    QLog.w("MergeEditVideo", 1, "mp4ReEncoder start!");
  }
  
  public void a(String arg1)
  {
    synchronized (brfv.a(this.jdField_a_of_type_Brfv))
    {
      brfv.a(this.jdField_a_of_type_Brfv, true);
      brfv.a(this.jdField_a_of_type_Brfv).notifyAll();
      if (this.jdField_a_of_type_Brio != null) {
        this.jdField_a_of_type_Brio.a();
      }
      QLog.w("MergeEditVideo", 1, "mp4ReEncoder encode finish!");
      return;
    }
  }
  
  public void a_(int paramInt, Throwable arg2)
  {
    yuk.c("MergeEditVideo", "encode error errorCode = " + paramInt + " Exception = ", ???);
    if (paramInt > 10000) {
      synchronized (brfv.a(this.jdField_a_of_type_Brfv))
      {
        brfv.a(this.jdField_a_of_type_Brfv, true);
        brfv.a(this.jdField_a_of_type_Brfv).notifyAll();
        return;
      }
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.isCancel)
    {
      this.jdField_a_of_type_Brfy.c();
      QLog.w("MergeEditVideo", 1, "mergeVideo cancel!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     brfw
 * JD-Core Version:    0.7.0.1
 */