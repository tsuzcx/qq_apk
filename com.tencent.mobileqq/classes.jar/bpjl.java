import com.tencent.biz.qqstory.base.videoupload.VideoCompositeHelper.VideoCompositeCallBack;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.mobileqq.activity.aio.photo.PeakActivity;

class bpjl
  implements VideoCompositeHelper.VideoCompositeCallBack
{
  bpjl(bpjk parambpjk, PeakActivity paramPeakActivity, String paramString1, String paramString2, PublishVideoEntry paramPublishVideoEntry) {}
  
  public void onVideoCompositeFinish(int paramInt, String paramString1, String paramString2)
  {
    if (paramInt == 0)
    {
      bpjk.a(this.jdField_a_of_type_Bpjk, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakActivity, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry);
      return;
    }
    bpjk.a(this.jdField_a_of_type_Bpjk, 1, this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpjl
 * JD-Core Version:    0.7.0.1
 */