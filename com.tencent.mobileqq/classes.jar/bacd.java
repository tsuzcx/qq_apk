import android.view.View;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.studyroom.ui.StudyRoomLoadingFragment;
import com.tencent.mobileqq.studyroom.ui.StudyRoomLoadingFragment.WeakCallback.1;
import com.tencent.mobileqq.studyroom.ui.StudyRoomLoadingFragment.WeakCallback.2;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class bacd
  implements baco
{
  private WeakReference<StudyRoomLoadingFragment> a;
  
  public bacd(StudyRoomLoadingFragment paramStudyRoomLoadingFragment)
  {
    this.a = new WeakReference(paramStudyRoomLoadingFragment);
  }
  
  public void a(Throwable paramThrowable)
  {
    ThreadManager.getUIHandler().post(new StudyRoomLoadingFragment.WeakCallback.1(this));
  }
  
  public void onCloseLoadingView()
  {
    QLog.d("studyroom.StudyRoomLoadingFragment", 4, "onCloseLoadingView");
    StudyRoomLoadingFragment localStudyRoomLoadingFragment = (StudyRoomLoadingFragment)this.a.get();
    if (localStudyRoomLoadingFragment != null)
    {
      StudyRoomLoadingFragment.a(localStudyRoomLoadingFragment);
      localStudyRoomLoadingFragment.a();
    }
  }
  
  public void onEnterComplete() {}
  
  public void onShowLoadingView(View paramView)
  {
    QLog.d("studyroom.StudyRoomLoadingFragment", 4, "onShowLoadingView");
    ThreadManager.getUIHandler().post(new StudyRoomLoadingFragment.WeakCallback.2(this, paramView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bacd
 * JD-Core Version:    0.7.0.1
 */