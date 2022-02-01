import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoArtFilter;
import dov.com.tencent.biz.qqstory.takevideo.artfilter.ArtFilterItemView;
import java.util.concurrent.atomic.AtomicInteger;

public class bpbz
  extends Handler
{
  public bpbz(EditVideoArtFilter paramEditVideoArtFilter) {}
  
  public void dispatchMessage(Message paramMessage)
  {
    super.dispatchMessage(paramMessage);
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return;
        EditVideoArtFilter.a(this.a, false);
        localObject = (String)paramMessage.obj;
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.publish.edit.EditVideoArtFilter", 2, "GET_FILTER SUCCESS,fileOutputPath:" + (String)localObject);
        }
        this.a.a((String)localObject, paramMessage.arg1);
        this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoArtfilterArtFilterItemView.a(0, true);
        return;
        EditVideoArtFilter.a(this.a, false);
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.publish.edit.EditVideoArtFilter", 2, "GET_FILTER ERROR");
        }
        this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoArtfilterArtFilterItemView.a();
        QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690128), 0).a();
        return;
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.publish.edit.EditVideoArtFilter", 2, "GET_FILTER TIMEOUT,state:isProcessing:" + this.a.jdField_a_of_type_Boolean + ",taskId:" + paramMessage.obj + ",currentFilterTaskId:" + this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger);
        }
      } while ((!this.a.jdField_a_of_type_Boolean) || (((Integer)paramMessage.obj).intValue() != this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()));
      EditVideoArtFilter.a(this.a, false);
      this.a.c();
      QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690128), 0).a();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.publish.edit.EditVideoArtFilter", 2, "UPDATE_FILTER_PROGRESS,state:isProcessing:" + this.a.jdField_a_of_type_Boolean + ",taskId:" + paramMessage.arg1 + ",updateCount:" + paramMessage.arg2 + ",currentFilterTaskId:" + this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger);
      }
    } while ((!this.a.jdField_a_of_type_Boolean) || (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoArtfilterArtFilterItemView.a.getVisibility() != 0) || (paramMessage.arg1 != this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()));
    this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoArtfilterArtFilterItemView.a(paramMessage.arg2, false);
    Object localObject = EditVideoArtFilter.a(this.a).obtainMessage(38);
    ((Message)localObject).arg1 = paramMessage.arg1;
    ((Message)localObject).arg2 = (paramMessage.arg2 + 1);
    EditVideoArtFilter.a(this.a).sendMessageDelayed((Message)localObject, 100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpbz
 * JD-Core Version:    0.7.0.1
 */