import com.tencent.biz.qqstory.base.videoupload.VideoCompositeHelper.VideoCompositeCallBack;
import com.tencent.biz.qqstory.support.logging.SLog;

final class anzh
  implements Runnable
{
  anzh(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong1, long paramLong2, VideoCompositeHelper.VideoCompositeCallBack paramVideoCompositeCallBack) {}
  
  public void run()
  {
    try
    {
      try
      {
        int i = anzg.a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.c, this.d, this.e, this.f, this.jdField_a_of_type_Long, this.jdField_b_of_type_Long);
        if (this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadVideoCompositeHelper$VideoCompositeCallBack != null) {
          this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadVideoCompositeHelper$VideoCompositeCallBack.a(i, "", this.jdField_b_of_type_JavaLangString);
        }
        return;
      }
      finally {}
      return;
    }
    catch (Exception localException)
    {
      SLog.c("CropVideoActivity", "do composite exception", localException);
      if (this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadVideoCompositeHelper$VideoCompositeCallBack != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadVideoCompositeHelper$VideoCompositeCallBack.a(940001, localException.getMessage(), "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anzh
 * JD-Core Version:    0.7.0.1
 */