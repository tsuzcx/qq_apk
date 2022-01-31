import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.qphone.base.util.QLog;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.atomic.AtomicBoolean;

class awfo
  implements Observer
{
  awfo(awfm paramawfm) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof Integer)) {
      switch (((Integer)paramObject).intValue())
      {
      }
    }
    do
    {
      return;
      paramObservable = this.a.a();
    } while ((paramObservable == null) || (paramObservable.a.get()) || (this.a.b != true) || (this.a.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus == null) || (this.a.c) || (this.a.d));
    if (QLog.isColorLevel()) {
      QLog.i("BaseSignViewHolder", 2, "update tplId=" + this.a.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.tplId);
    }
    ThreadManager.getUIHandlerV2().removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
    ThreadManager.getUIHandlerV2().post(this.a.jdField_a_of_type_JavaLangRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awfo
 * JD-Core Version:    0.7.0.1
 */