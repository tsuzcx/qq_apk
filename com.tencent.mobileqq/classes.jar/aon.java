import android.os.Bundle;
import android.text.TextUtils;
import com.qq.im.poi.LbsPackManager;
import com.qq.im.poi.LbsPackObserver;
import com.qq.im.poi.LbsPackSendActivity;
import com.tencent.qphone.base.util.QLog;

public class aon
  extends LbsPackObserver
{
  public aon(LbsPackSendActivity paramLbsPackSendActivity) {}
  
  public void onGetLbsPid(boolean paramBoolean, Bundle paramBundle)
  {
    this.a.d();
    String str = paramBundle.getString("key_pid");
    paramBundle = paramBundle.getString("key_erro_msg");
    if ((paramBoolean) && (str != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LbsPack", 2, "onGetLbsPid  pid = " + str);
      }
      this.a.jdField_b_of_type_JavaLangString = str;
      this.a.a(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_Int, this.a.jdField_b_of_type_Int, this.a.jdField_b_of_type_JavaLangString, this.a.jdField_a_of_type_ComQqImPoiPoiInfo);
      return;
    }
    if (TextUtils.isEmpty(paramBundle))
    {
      this.a.a(this.a.getString(2131438772), -1);
      return;
    }
    this.a.a(paramBundle, -1);
  }
  
  public void onGetSendPOIList(boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LbsPack", 2, "onGetSendPOIList  isSuccess = " + paramBoolean);
    }
    if (paramBoolean)
    {
      this.a.a(this.a.jdField_a_of_type_ComQqImPoiLbsPackManager.a());
      return;
    }
    this.a.a(2131438761, 2131438762);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aon
 * JD-Core Version:    0.7.0.1
 */