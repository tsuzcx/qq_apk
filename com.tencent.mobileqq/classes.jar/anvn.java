import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import dov.com.tencent.biz.qqstory.takevideo.EditWebVideoHallowenUpload;

public class anvn
  implements Runnable
{
  public anvn(EditWebVideoHallowenUpload paramEditWebVideoHallowenUpload, boolean paramBoolean, String paramString1, String paramString2) {}
  
  public void run()
  {
    Runnable localRunnable = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditWebVideoHallowenUpload.jdField_a_of_type_JavaLangRunnable;
    if (localRunnable != null) {
      localRunnable.run();
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditWebVideoHallowenUpload.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditWebVideoHallowenUpload.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString, this.b);
      return;
    }
    QQToast.a(BaseApplicationImpl.sApplication, "上传失败", 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anvn
 * JD-Core Version:    0.7.0.1
 */