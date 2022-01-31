import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.mobileqq.activity.aio.photo.PeakActivity;
import com.tencent.qphone.base.util.QLog;

class bnci
  extends xos
{
  bnci(bncg parambncg, String paramString1, PeakActivity paramPeakActivity, String paramString2, String paramString3, PublishVideoEntry paramPublishVideoEntry) {}
  
  public void onFailure(String paramString)
  {
    bncg.a(this.jdField_a_of_type_Bncg, 1, this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry);
  }
  
  public void onFinish(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SaveVideoActivity", 2, "combine music finish: " + paramBoolean);
    }
    bdcs.d(this.jdField_a_of_type_JavaLangString);
    if (paramBoolean)
    {
      bncg.a(this.jdField_a_of_type_Bncg, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakActivity, this.b, this.c, this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry);
      return;
    }
    bncg.a(this.jdField_a_of_type_Bncg, 1, this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnci
 * JD-Core Version:    0.7.0.1
 */