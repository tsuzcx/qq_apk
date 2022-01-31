import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.listentogether.ListenTogetherSession;
import com.tencent.mobileqq.listentogether.data.MusicInfo;
import com.tencent.mobileqq.listentogether.fragment.ListenTogetherPlayFragment;
import com.tencent.qphone.base.util.QLog;

class aqyh
  extends aqvp
{
  aqyh(aqyg paramaqyg) {}
  
  protected void a(int paramInt, String paramString)
  {
    QLog.d("BaseListenTogetherPanel", 1, String.format("onJoinAndEnter [%d,%s] [%d,%s] resumed=[%b] ", new Object[] { Integer.valueOf(paramInt), paramString, Integer.valueOf(this.a.jdField_a_of_type_Aqyo.jdField_a_of_type_Int), this.a.jdField_a_of_type_Aqyo.jdField_a_of_type_JavaLangString, Boolean.valueOf(this.a.c) }));
    if ((!this.a.c) || (this.a.jdField_a_of_type_Aqyo.jdField_a_of_type_Int != paramInt) || (!this.a.jdField_a_of_type_Aqyo.jdField_a_of_type_JavaLangString.equalsIgnoreCase(paramString))) {
      return;
    }
    paramString = ListenTogetherManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app).a(paramInt, paramString);
    if ((paramString == null) || (this.a.jdField_a_of_type_Aqyo.b == 3))
    {
      bbmy.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131628196, 0).a();
      return;
    }
    if (this.a.jdField_a_of_type_Aqyo.c != 2)
    {
      bbmy.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131628198, 0).a();
      return;
    }
    if (this.a.jdField_a_of_type_Aqyo.b == 4)
    {
      bbmy.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131628201, 0).a();
      return;
    }
    MusicInfo localMusicInfo = paramString.a();
    ListenTogetherPlayFragment.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramString, localMusicInfo, this.a.jdField_a_of_type_Aqyo.jdField_a_of_type_Boolean, null);
  }
  
  protected void a(int paramInt, String paramString1, String paramString2)
  {
    aqyg.a(this.a, paramInt, paramString1, paramString2);
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
 * Qualified Name:     aqyh
 * JD-Core Version:    0.7.0.1
 */