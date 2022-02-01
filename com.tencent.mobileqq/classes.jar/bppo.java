import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.qphone.base.util.QLog;

class bppo
  implements bbmy
{
  bppo(bppn parambppn, bprr parambprr, bbmm parambbmm, PublishVideoEntry paramPublishVideoEntry, bppq parambppq) {}
  
  public void onEncodeError(int paramInt, Throwable arg2)
  {
    ykq.c("MergeEditVideo", "encode error errorCode = " + paramInt + " Exception = ", ???);
    if (paramInt > 10000) {
      synchronized (bppn.a(this.jdField_a_of_type_Bppn))
      {
        bppn.a(this.jdField_a_of_type_Bppn, true);
        bppn.a(this.jdField_a_of_type_Bppn).notifyAll();
        return;
      }
    }
  }
  
  public void onEncodeFinish(String arg1)
  {
    synchronized (bppn.a(this.jdField_a_of_type_Bppn))
    {
      bppn.a(this.jdField_a_of_type_Bppn, true);
      bppn.a(this.jdField_a_of_type_Bppn).notifyAll();
      if (this.jdField_a_of_type_Bprr != null) {
        this.jdField_a_of_type_Bprr.a();
      }
      QLog.w("MergeEditVideo", 1, "mp4ReEncoder encode finish!");
      return;
    }
  }
  
  public void onEncodeFrame()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.isCancel)
    {
      this.jdField_a_of_type_Bppq.a();
      QLog.w("MergeEditVideo", 1, "mergeVideo cancel!");
    }
  }
  
  public void onEncodeStart()
  {
    if (this.jdField_a_of_type_Bprr != null) {
      this.jdField_a_of_type_Bprr.a(this.jdField_a_of_type_Bbmm.a, this.jdField_a_of_type_Bbmm.b);
    }
    QLog.w("MergeEditVideo", 1, "mp4ReEncoder start!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bppo
 * JD-Core Version:    0.7.0.1
 */