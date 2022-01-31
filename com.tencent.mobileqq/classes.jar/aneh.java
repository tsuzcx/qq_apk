import android.content.Intent;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.FileUtils;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPartManager;
import dov.com.tencent.biz.qqstory.takevideo.publish.GenerateContext;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;

class aneh
  implements Runnable
{
  aneh(aneg paramaneg, GenerateContext paramGenerateContext) {}
  
  public void run()
  {
    PublishParam localPublishParam = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishGenerateContext.a;
    SLog.b("Q.qqstory.publish.edit.EditVideoPartManager", "publishParam = " + localPublishParam);
    if (this.jdField_a_of_type_Aneg.a.jdField_a_of_type_AndroidContentIntent == null) {}
    for (Intent localIntent = new Intent();; localIntent = this.jdField_a_of_type_Aneg.a.jdField_a_of_type_AndroidContentIntent)
    {
      localIntent.putExtra(PublishParam.a, localPublishParam);
      this.jdField_a_of_type_Aneg.a.a(localIntent, this.jdField_a_of_type_Aneg.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a(), localPublishParam);
      FileUtils.f(this.jdField_a_of_type_Aneg.a.a());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aneh
 * JD-Core Version:    0.7.0.1
 */