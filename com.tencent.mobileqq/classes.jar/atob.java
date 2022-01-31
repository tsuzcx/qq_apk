import android.text.TextUtils;
import com.tencent.mobileqq.listentogether.ListenTogetherSession;
import com.tencent.mobileqq.listentogether.data.ISong;
import com.tencent.mobileqq.listentogether.data.MusicInfo;
import com.tencent.mobileqq.listentogether.lyrics.FloatIconLayout;
import com.tencent.qphone.base.util.QLog;

class atob
  extends atml
{
  atob(atnw paramatnw) {}
  
  protected void a()
  {
    if ((this.a.jdField_b_of_type_Boolean) && (this.a.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout != null)) {
      this.a.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.e();
    }
  }
  
  protected void a(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean1) {}
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("LyricsController", 2, "onLyricModuleSwitchChange, newUserClosed:" + paramBoolean1 + " type:" + paramInt + " uin:" + paramString + " mFloatParams:" + this.a.jdField_a_of_type_Atnu);
      }
      if ((this.a.jdField_a_of_type_Atnu.a(paramInt, paramString)) && (this.a.jdField_a_of_type_Atnu.jdField_b_of_type_Boolean != paramBoolean1))
      {
        this.a.jdField_a_of_type_Atnu.jdField_b_of_type_Boolean = paramBoolean1;
        atnw.a(this.a);
        if ((!TextUtils.isEmpty(this.a.jdField_b_of_type_JavaLangString)) && (!paramBoolean1) && (paramBoolean2))
        {
          atnw.a(this.a, this.a.jdField_b_of_type_JavaLangString);
          if (this.a.jdField_a_of_type_JavaLangBoolean != null) {
            atnw.a(this.a, this.a.jdField_b_of_type_JavaLangString, this.a.c, this.a.jdField_a_of_type_JavaLangBoolean.booleanValue());
          }
          atnw.a(this.a, this.a.jdField_b_of_type_JavaLangString, this.a.i);
        }
      }
      if (paramBoolean2) {
        this.a.b(paramInt, paramString, paramBoolean1);
      }
      return;
    }
  }
  
  protected void a(ListenTogetherSession paramListenTogetherSession)
  {
    if (paramListenTogetherSession == null) {
      return;
    }
    if (paramListenTogetherSession.h == 2) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("LyricsController", 2, "onUIModuleNeedRefresh sessionJoined:" + bool);
      }
      if (!bool) {
        break;
      }
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (paramListenTogetherSession != null)
      {
        paramListenTogetherSession = paramListenTogetherSession.a();
        localObject1 = localObject2;
        if (paramListenTogetherSession != null) {
          localObject1 = paramListenTogetherSession.jdField_e_of_type_JavaLangString;
        }
      }
      this.a.jdField_a_of_type_Atnu.a = ((String)localObject1);
      atnw.a(this.a);
      return;
    }
  }
  
  protected void a(ISong paramISong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LyricsController", 2, "onPlayMusicChange song.id:" + paramISong.a());
    }
    atnw.a(this.a, paramISong.a());
    this.a.jdField_a_of_type_Atnu.a = paramISong.d();
    atnw.a(this.a);
  }
  
  protected void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LyricsController", 2, "onPlayStateChange state:" + paramInt);
    }
    if (paramInt == 2) {
      if (this.a.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.setPlayState(true);
      }
    }
    for (;;)
    {
      atnw.b(this.a, paramString, paramInt);
      baoc.a().a();
      return;
      if (paramInt == 3)
      {
        if (this.a.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout != null) {
          this.a.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.setPlayState(false);
        }
      }
      else if ((paramInt == 4) && (this.a.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout != null)) {
        this.a.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.setPlayState(false);
      }
    }
  }
  
  protected void a(String paramString, int paramInt1, int paramInt2)
  {
    atnw.a(this.a, paramString, paramInt1, paramInt2);
  }
  
  protected void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    this.a.a(paramString1, paramString2, paramBoolean);
  }
  
  protected void a(boolean paramBoolean, ListenTogetherSession paramListenTogetherSession)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LyricsController", 2, "onFloatNeedShowOrDismiss show:" + paramBoolean + " session:" + paramListenTogetherSession);
    }
    if (paramListenTogetherSession == null) {
      return;
    }
    int i = paramListenTogetherSession.jdField_e_of_type_Int;
    String str = paramListenTogetherSession.jdField_e_of_type_JavaLangString;
    if (paramBoolean)
    {
      Object localObject = null;
      MusicInfo localMusicInfo = paramListenTogetherSession.a();
      paramListenTogetherSession = localObject;
      if (localMusicInfo != null) {
        paramListenTogetherSession = localMusicInfo.jdField_e_of_type_JavaLangString;
      }
      this.a.jdField_a_of_type_Atnu.a = paramListenTogetherSession;
      this.a.a(i, str);
      return;
    }
    this.a.b(i, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atob
 * JD-Core Version:    0.7.0.1
 */