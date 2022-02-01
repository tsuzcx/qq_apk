import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.utils.ffmpeg.ExecuteBinResponseCallback;
import com.tencent.mobileqq.activity.aio.photo.PeakActivity;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

class bpjm
  extends ExecuteBinResponseCallback
{
  bpjm(bpjk parambpjk, String paramString1, PeakActivity paramPeakActivity, String paramString2, String paramString3, PublishVideoEntry paramPublishVideoEntry) {}
  
  public void onFailure(String paramString)
  {
    bpjk.a(this.jdField_a_of_type_Bpjk, 1, this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry);
  }
  
  public void onFinish(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SaveVideoActivity", 2, "combine music finish: " + paramBoolean);
    }
    FileUtils.deleteFile(this.jdField_a_of_type_JavaLangString);
    if (paramBoolean)
    {
      bpjk.a(this.jdField_a_of_type_Bpjk, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakActivity, this.b, this.c, this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry);
      return;
    }
    bpjk.a(this.jdField_a_of_type_Bpjk, 1, this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpjm
 * JD-Core Version:    0.7.0.1
 */