import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser.IMiniMsgActionCallback;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUserParam;
import com.tencent.mobileqq.app.BaseActivity;

public class ayfl
  extends MiniMsgUser
{
  int jdField_a_of_type_Int = -1;
  MiniMsgUserParam jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUserParam;
  BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  String jdField_a_of_type_JavaLangString = "";
  String b = "";
  
  public ayfl(BaseActivity paramBaseActivity, MiniMsgUserParam paramMiniMsgUserParam, String paramString1, int paramInt, String paramString2)
  {
    super(paramBaseActivity, paramMiniMsgUserParam);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUserParam = paramMiniMsgUserParam;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.b = paramString2;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUserParam == null) {}
    int i;
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUserParam.actionCallback != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUserParam.actionCallback.onOpenMiniAIOCallback();
      }
      paramView = this.jdField_a_of_type_JavaLangString;
      i = this.jdField_a_of_type_Int;
    } while ((i == -1) || (TextUtils.isEmpty(paramView)));
    MiniChatActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, i, paramView, this.b);
    hideUnread();
  }
  
  public void updateUnreadCountSync(int paramInt)
  {
    super.updateUnreadCountSync(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ayfl
 * JD-Core Version:    0.7.0.1
 */