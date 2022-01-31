import com.tencent.mobileqq.widget.QQToast;
import dov.com.tencent.biz.qqstory.takevideo.EditPicSave;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPartManager;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoUi;

class anrm
  implements Runnable
{
  anrm(anrl paramanrl) {}
  
  public void run()
  {
    this.a.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
    this.a.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(EditPicSave.a(this.a.a));
    this.a.a.jdField_a_of_type_Boolean = true;
    this.a.a.a(100);
    this.a.a.d();
    if (this.a.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.a() == 102)
    {
      EditPicSave.a(this.a.a, this.a.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.a());
      return;
    }
    QQToast.a(this.a.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a(), 2, "保存成功", 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anrm
 * JD-Core Version:    0.7.0.1
 */