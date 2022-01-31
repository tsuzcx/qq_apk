import android.os.Bundle;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoArtFilter;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.concurrent.atomic.AtomicInteger;

public class bjud
  implements EIPCResultCallback
{
  public bjud(EditVideoArtFilter paramEditVideoArtFilter, vkb paramvkb) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (paramEIPCResult.data == null) {}
    int j;
    Object localObject;
    do
    {
      return;
      int i = paramEIPCResult.data.getInt("param_art_filter_task_id");
      j = paramEIPCResult.data.getInt("param_art_filter_style_id");
      localObject = paramEIPCResult.data.getString("param_art_filter_resource_path");
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.publish.edit.EditVideoArtFilter", 2, "QIPCResult: resultFilterTaskId:" + i + " currentFilterTaskId:" + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoArtFilter.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() + " currentStyleId:" + EditVideoArtFilter.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoArtFilter) + " resultFilterStyleId:" + j + " resultFilterOriginImgPath:" + (String)localObject);
      }
    } while ((EditVideoArtFilter.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoArtFilter) != j) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoArtFilter.d == null) || (!((String)localObject).equals(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoArtFilter.d)) || (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoArtFilter.jdField_a_of_type_Boolean));
    if (paramEIPCResult.data.getInt("param_art_filter_task_result") == 0)
    {
      paramEIPCResult = paramEIPCResult.data.getString("param_art_filter_output_path");
      localObject = EditVideoArtFilter.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoArtFilter).obtainMessage(34);
      ((Message)localObject).obj = paramEIPCResult;
      ((Message)localObject).arg1 = this.jdField_a_of_type_Vkb.a;
      EditVideoArtFilter.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoArtFilter).sendMessage((Message)localObject);
      return;
    }
    paramEIPCResult = EditVideoArtFilter.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoArtFilter).obtainMessage(37);
    EditVideoArtFilter.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoArtFilter).sendMessage(paramEIPCResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjud
 * JD-Core Version:    0.7.0.1
 */