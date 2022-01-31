import com.tencent.mobileqq.widget.QQToast;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPartManager;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoSave;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoUi;

public class anux
  implements Runnable
{
  public anux(EditVideoSave paramEditVideoSave) {}
  
  public void run()
  {
    this.a.j();
    if (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.a() != 102) {
      QQToast.a(this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a(), 2, "保存成功", 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anux
 * JD-Core Version:    0.7.0.1
 */