import android.os.Bundle;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MsgBoxInterFollowManager;
import com.tencent.mobileqq.dating.MsgBoxListActivity;
import com.tencent.qphone.base.util.QLog;

public class apik
  extends apio
{
  public apik(MsgBoxListActivity paramMsgBoxListActivity) {}
  
  protected void a(boolean paramBoolean1, String paramString, int paramInt, long paramLong, boolean paramBoolean2, Bundle paramBundle)
  {
    if (!paramBoolean1) {
      if (QLog.isColorLevel()) {
        QLog.i("MsgBoxListActivity", 2, "onGetInteractLastFeed = false");
      }
    }
    for (;;)
    {
      return;
      if (paramBoolean2) {
        this.a.app.a().addMessage(paramString, 0, paramInt, paramLong, 1);
      }
      while (!this.a.isFinishing())
      {
        this.a.a();
        return;
        if (this.a.app.a().isInMsgBoxRecentList(alof.al, this.a.jdField_a_of_type_Int))
        {
          paramInt = this.a.app.a().a(alof.al, this.a.jdField_a_of_type_Int);
          this.a.app.a().a(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_Int, alof.al, this.a.app.getCurrentAccountUin());
          if (paramInt > 0)
          {
            ajlb.b(this.a.app, alof.al, this.a.jdField_a_of_type_Int);
            this.a.app.a().a(alof.al, this.a.jdField_a_of_type_Int, true, true);
          }
        }
      }
    }
  }
  
  protected void b(boolean paramBoolean1, String paramString, int paramInt, long paramLong, boolean paramBoolean2, Bundle paramBundle)
  {
    if (!paramBoolean1) {
      if (QLog.isColorLevel()) {
        QLog.i("MsgBoxListActivity", 2, "onGetInteractLastFeed = false");
      }
    }
    for (;;)
    {
      return;
      if (paramBoolean2) {
        this.a.app.a().addMessage(paramString, 0, paramInt, paramLong, 2);
      }
      while (!this.a.isFinishing())
      {
        this.a.a();
        return;
        if (this.a.app.a().isInMsgBoxRecentList(alof.am, this.a.jdField_a_of_type_Int))
        {
          paramInt = this.a.app.a().a(alof.am, this.a.jdField_a_of_type_Int);
          this.a.app.a().a(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_Int, alof.am, this.a.app.getCurrentAccountUin());
          if (paramInt > 0)
          {
            ajlb.b(this.a.app, alof.am, this.a.jdField_a_of_type_Int);
            this.a.app.a().a(alof.am, this.a.jdField_a_of_type_Int, true, true);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apik
 * JD-Core Version:    0.7.0.1
 */