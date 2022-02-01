import com.tencent.biz.qqstory.base.videoupload.VideoCompositeHelper.VideoCompositeCallBack;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.mobileqq.activity.aio.photo.PeakActivity;

class bntt
  implements VideoCompositeHelper.VideoCompositeCallBack
{
  bntt(bnts parambnts, PeakActivity paramPeakActivity, String paramString1, String paramString2, PublishVideoEntry paramPublishVideoEntry) {}
  
  public void onVideoCompositeFinish(int paramInt, String paramString1, String paramString2)
  {
    if (paramInt == 0)
    {
      bnts.a(this.jdField_a_of_type_Bnts, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakActivity, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry);
      return;
    }
    bnts.a(this.jdField_a_of_type_Bnts, 1, this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bntt
 * JD-Core Version:    0.7.0.1
 */