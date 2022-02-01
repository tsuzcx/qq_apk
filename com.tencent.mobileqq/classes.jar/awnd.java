import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.listentogether.ListenTogetherSession;
import com.tencent.mobileqq.listentogether.data.ISong;
import com.tencent.mobileqq.listentogether.data.MusicInfo;
import com.tencent.mobileqq.listentogether.fragment.ListenTogetherPlayFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class awnd
  extends awmf
{
  public awnd(ListenTogetherPlayFragment paramListenTogetherPlayFragment) {}
  
  protected void a(int paramInt, String paramString1, String paramString2)
  {
    FragmentActivity localFragmentActivity = this.a.getActivity();
    if ((localFragmentActivity == null) || (localFragmentActivity.isFinishing()) || (!this.a.isAdded())) {}
    while (!this.a.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.e.equals(paramString1)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ListenTogetherPlayFragment", 2, String.format("onListenTogetherJoinedCountChange msg=%s", new Object[] { paramString2 }));
    }
    this.a.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_a_of_type_JavaLangString = paramString2;
    if (paramInt == 1)
    {
      this.a.jdField_a_of_type_Awlt.a(paramString1);
      return;
    }
    ListenTogetherPlayFragment.a(this.a, ListenTogetherPlayFragment.a(this.a), this.a.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_a_of_type_JavaLangString);
  }
  
  protected void a(ListenTogetherSession paramListenTogetherSession)
  {
    FragmentActivity localFragmentActivity = this.a.getActivity();
    if ((localFragmentActivity == null) || (localFragmentActivity.isFinishing()) || (!this.a.isAdded())) {}
    while (!this.a.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.e.equals(paramListenTogetherSession.e)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ListenTogetherPlayFragment", 2, String.format("onUIModuleNeedRefresh session=%s", new Object[] { paramListenTogetherSession }));
    }
    this.a.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession = paramListenTogetherSession;
    MusicInfo localMusicInfo = paramListenTogetherSession.a();
    if ((paramListenTogetherSession.h != 2) || (paramListenTogetherSession.g == 3) || (paramListenTogetherSession.g == 4) || (localMusicInfo == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ListenTogetherPlayFragment", 2, "onExit");
      }
      QQToast.a(localFragmentActivity, 2131693276, 1).a();
      this.a.getActivity().finish();
      return;
    }
    a(localMusicInfo);
    ListenTogetherPlayFragment.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqListentogetherDataISong.a(), paramListenTogetherSession.g, this.a.jdField_a_of_type_JavaLangString);
  }
  
  protected void a(ISong paramISong)
  {
    FragmentActivity localFragmentActivity = this.a.getActivity();
    if ((localFragmentActivity == null) || (localFragmentActivity.isFinishing()) || (!this.a.isAdded())) {}
    while (this.a.jdField_a_of_type_ComTencentMobileqqListentogetherDataISong.equals(paramISong)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ListenTogetherPlayFragment", 2, String.format("onPlayMusicChange %s", new Object[] { paramISong }));
    }
    this.a.jdField_a_of_type_ComTencentMobileqqListentogetherDataISong = paramISong;
    this.a.jdField_a_of_type_JavaLangString = null;
    ListenTogetherPlayFragment.a(this.a, paramISong);
  }
  
  protected void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    int i = 0;
    FragmentActivity localFragmentActivity = this.a.getActivity();
    if ((localFragmentActivity == null) || (localFragmentActivity.isFinishing()) || (!this.a.isAdded())) {}
    while (!this.a.jdField_a_of_type_ComTencentMobileqqListentogetherDataISong.a().equals(paramString1)) {
      return;
    }
    if (QLog.isColorLevel()) {
      if (paramString2 != null) {
        break label120;
      }
    }
    for (;;)
    {
      QLog.i("ListenTogetherPlayFragment", 2, String.format("onGetLyric %s %d", new Object[] { paramString1, Integer.valueOf(i) }));
      this.a.jdField_a_of_type_JavaLangString = paramString2;
      ListenTogetherPlayFragment.a(this.a, paramString1, this.a.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.g, paramString2);
      return;
      label120:
      i = paramString2.length();
    }
  }
  
  protected void a(boolean paramBoolean, String paramString, int paramInt, List<String> paramList)
  {
    FragmentActivity localFragmentActivity = this.a.getActivity();
    if ((localFragmentActivity == null) || (localFragmentActivity.isFinishing()) || (!this.a.isAdded())) {}
    while (!this.a.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.e.equals(paramString)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ListenTogetherPlayFragment", 2, String.format("onGetGroupJoinedUsers uin=%s num=%d", new Object[] { paramString, Integer.valueOf(paramInt) }));
    }
    ListenTogetherPlayFragment.a(this.a, paramList, this.a.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_a_of_type_JavaLangString);
  }
  
  protected void c(int paramInt, String paramString)
  {
    FragmentActivity localFragmentActivity = this.a.getActivity();
    if ((localFragmentActivity == null) || (localFragmentActivity.isFinishing()) || (!this.a.isAdded())) {}
    while (!this.a.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.e.equals(this.a.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.e)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ListenTogetherPlayFragment", 2, String.format("onPauseListenTogetherFail [%s, %d]", new Object[] { paramString, Integer.valueOf(paramInt) }));
    }
    QQToast.a(localFragmentActivity, 2131693282, 1).a();
  }
  
  protected void d(int paramInt, String paramString)
  {
    FragmentActivity localFragmentActivity = this.a.getActivity();
    if ((localFragmentActivity == null) || (localFragmentActivity.isFinishing()) || (!this.a.isAdded())) {}
    while (!this.a.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.e.equals(this.a.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.e)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ListenTogetherPlayFragment", 2, String.format("onResumeListenTogetherFail [%s, %d]", new Object[] { paramString, Integer.valueOf(paramInt) }));
    }
    QQToast.a(localFragmentActivity, 2131693284, 1).a();
  }
  
  protected void e(int paramInt, String paramString)
  {
    FragmentActivity localFragmentActivity = this.a.getActivity();
    if ((localFragmentActivity == null) || (localFragmentActivity.isFinishing()) || (!this.a.isAdded())) {}
    while (!this.a.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.e.equals(this.a.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.e)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ListenTogetherPlayFragment", 2, String.format("onCutListenTogetherFail [%s, %d]", new Object[] { paramString, Integer.valueOf(paramInt) }));
    }
    QQToast.a(localFragmentActivity, 2131693266, 1).a();
  }
  
  protected void f(int paramInt, String paramString)
  {
    FragmentActivity localFragmentActivity = this.a.getActivity();
    if ((localFragmentActivity == null) || (localFragmentActivity.isFinishing()) || (!this.a.isAdded())) {}
    while (!this.a.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.e.equals(this.a.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.e)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ListenTogetherPlayFragment", 2, String.format("onChangePlayModeListenTogetherFail [%s, %d]", new Object[] { paramString, Integer.valueOf(paramInt) }));
    }
    QQToast.a(localFragmentActivity, 2131693283, 1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awnd
 * JD-Core Version:    0.7.0.1
 */