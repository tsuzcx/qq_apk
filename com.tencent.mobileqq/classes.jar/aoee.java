import android.app.Activity;
import dov.com.tencent.biz.qqstory.takevideo.EditRecordVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditTakeVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams.EditSource;
import dov.com.tencent.biz.qqstory.takevideo.EditWebVideoHallowenUpload;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import dov.com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask;
import dov.com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask.ResultListener;

public class aoee
  implements Runnable
{
  public aoee(EditWebVideoHallowenUpload paramEditWebVideoHallowenUpload, EditVideoParams.EditSource paramEditSource, PublishParam paramPublishParam, Activity paramActivity) {}
  
  public void run()
  {
    EditWebVideoHallowenUpload.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditWebVideoHallowenUpload, null);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditWebVideoHallowenUpload.a = 0;
    boolean bool;
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditRecordVideoSource))
    {
      EditWebVideoHallowenUpload.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditWebVideoHallowenUpload);
      bool = false;
    }
    for (;;)
    {
      EncodeVideoTask localEncodeVideoTask = new EncodeVideoTask(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishPublishParam.b, bool, EditWebVideoHallowenUpload.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditWebVideoHallowenUpload), true);
      localEncodeVideoTask.a(EditWebVideoHallowenUpload.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditWebVideoHallowenUpload));
      localEncodeVideoTask.execute(new Void[0]);
      return;
      if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource))
      {
        int i = EditWebVideoHallowenUpload.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditWebVideoHallowenUpload, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishPublishParam);
        if (i != 0) {
          EditWebVideoHallowenUpload.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditWebVideoHallowenUpload).a(i);
        }
        bool = true;
      }
      else
      {
        EditWebVideoHallowenUpload.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditWebVideoHallowenUpload).a(-1);
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aoee
 * JD-Core Version:    0.7.0.1
 */