import android.content.Intent;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.FileUtils;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPartManager;
import dov.com.tencent.biz.qqstory.takevideo.publish.GenerateContext;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;

class anum
  implements Runnable
{
  anum(anul paramanul, GenerateContext paramGenerateContext) {}
  
  public void run()
  {
    PublishParam localPublishParam = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishGenerateContext.a;
    SLog.b("Q.qqstory.publish.edit.EditVideoPartManager", "publishParam = " + localPublishParam);
    if (this.jdField_a_of_type_Anul.a.jdField_a_of_type_AndroidContentIntent == null) {}
    for (Intent localIntent = new Intent();; localIntent = this.jdField_a_of_type_Anul.a.jdField_a_of_type_AndroidContentIntent)
    {
      localIntent.putExtra(PublishParam.a, localPublishParam);
      this.jdField_a_of_type_Anul.a.a(localIntent, this.jdField_a_of_type_Anul.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a(), localPublishParam);
      FileUtils.g(this.jdField_a_of_type_Anul.a.a());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anum
 * JD-Core Version:    0.7.0.1
 */