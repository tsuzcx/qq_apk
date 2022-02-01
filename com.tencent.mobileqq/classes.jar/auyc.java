import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class auyc
  extends anwt
{
  auyc(auxu paramauxu) {}
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardBaseOption", 2, "updateDiscussionInfo start: isSuccess=" + paramBoolean);
    }
    String str = this.a.jdField_a_of_type_AndroidOsBundle.getString("uin");
    paramObject = (ArrayList)paramObject;
    int i = paramObject.indexOf(str);
    if (i != -1)
    {
      paramObject = (Boolean)paramObject.get(i + 1);
      if ((paramBoolean) && (paramObject.booleanValue()))
      {
        paramObject = ((anws)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53)).a(str);
        if ((paramObject != null) && (!TextUtils.isEmpty(paramObject.discussionName)) && (this.a.jdField_a_of_type_Bhpc != null)) {
          this.a.jdField_a_of_type_Bhpc.setTitle(anzj.a(2131703630) + auyl.g + paramObject.discussionName);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     auyc
 * JD-Core Version:    0.7.0.1
 */