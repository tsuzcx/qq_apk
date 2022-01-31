import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.listentogether.ListenTogetherSession;
import com.tencent.mobileqq.listentogether.data.MusicInfo;
import com.tencent.mobileqq.listentogether.fragment.ListenTogetherPlayFragment;
import com.tencent.qphone.base.util.QLog;

class artz
  extends arrh
{
  artz(arty paramarty) {}
  
  protected void a(int paramInt, String paramString)
  {
    QLog.d("BaseListenTogetherPanel", 1, String.format("onJoinAndEnter [%d,%s] [%d,%s] resumed=[%b] ", new Object[] { Integer.valueOf(paramInt), paramString, Integer.valueOf(this.a.jdField_a_of_type_Arue.jdField_a_of_type_Int), this.a.jdField_a_of_type_Arue.jdField_a_of_type_JavaLangString, Boolean.valueOf(this.a.b) }));
    if ((!this.a.b) || (this.a.jdField_a_of_type_Arue.jdField_a_of_type_Int != paramInt) || (!this.a.jdField_a_of_type_Arue.jdField_a_of_type_JavaLangString.equalsIgnoreCase(paramString))) {
      return;
    }
    paramString = ListenTogetherManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app).a(paramInt, paramString);
    if ((paramString == null) || (this.a.jdField_a_of_type_Arue.b == 3))
    {
      bcql.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131693838, 0).a();
      return;
    }
    if (this.a.jdField_a_of_type_Arue.c != 2)
    {
      bcql.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131693840, 0).a();
      return;
    }
    if (this.a.jdField_a_of_type_Arue.b == 4)
    {
      bcql.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131693843, 0).a();
      return;
    }
    MusicInfo localMusicInfo = paramString.a();
    ListenTogetherPlayFragment.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramString, localMusicInfo, this.a.jdField_a_of_type_Arue.jdField_a_of_type_Boolean, null);
  }
  
  protected void a(int paramInt, String paramString1, String paramString2)
  {
    arty.a(this.a, paramInt, paramString1, paramString2);
  }
  
  protected void a(int paramInt, String paramString, boolean paramBoolean)
  {
    this.a.a(paramInt, paramString, paramBoolean);
  }
  
  protected void a(ListenTogetherSession paramListenTogetherSession)
  {
    this.a.a(paramListenTogetherSession);
  }
  
  protected void a(String paramString, int paramInt1, int paramInt2)
  {
    this.a.a(paramString, paramInt1, paramInt2);
  }
  
  protected void b(int paramInt, String paramString)
  {
    this.a.a(paramInt, paramString);
  }
  
  protected void h(int paramInt, String paramString)
  {
    this.a.b(paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     artz
 * JD-Core Version:    0.7.0.1
 */