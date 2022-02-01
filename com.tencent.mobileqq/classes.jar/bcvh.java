import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser.IMiniMsgActionCallback;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUserParam;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bcvh
  extends MiniMsgUser
{
  int jdField_a_of_type_Int = -1;
  MiniMsgUserParam jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUserParam;
  BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  String jdField_a_of_type_JavaLangString = "";
  String b = "";
  
  public bcvh(BaseActivity paramBaseActivity, MiniMsgUserParam paramMiniMsgUserParam, String paramString1, int paramInt, String paramString2)
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
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUserParam.actionCallback != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUserParam.actionCallback.onOpenMiniAIOCallback();
      }
      String str = this.jdField_a_of_type_JavaLangString;
      int i = this.jdField_a_of_type_Int;
      if ((i != -1) && (!TextUtils.isEmpty(str)))
      {
        MiniChatActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, i, str, this.b);
        hideUnread();
      }
    }
  }
  
  public void updateUnreadCountSync(int paramInt)
  {
    super.updateUnreadCountSync(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcvh
 * JD-Core Version:    0.7.0.1
 */