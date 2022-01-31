import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.activity.miniaio.MiniMsgIPCClient;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser.IMiniMsgActionCallback;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUserParam;

public class aqqm
  implements View.OnClickListener
{
  aciv jdField_a_of_type_Aciv = aciv.a();
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  private WindowManager.LayoutParams jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
  private WindowManager jdField_a_of_type_AndroidViewWindowManager;
  MiniMsgUserParam jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUserParam;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  public aqqm(Activity paramActivity, String paramString1, String paramString2, MiniMsgUserParam paramMiniMsgUserParam)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUserParam = paramMiniMsgUserParam;
    this.b = paramString2;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = View.inflate(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), 2131497012, null);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      String str = azge.a("", this.jdField_a_of_type_JavaLangString, 0);
      axoa.a(str);
      Object localObject2 = (RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131304577);
      URLImageView localURLImageView = (URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131304578);
      Object localObject1 = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131304579);
      localObject2 = (RelativeLayout.LayoutParams)((RelativeLayout)localObject2).getLayoutParams();
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localURLImageView.getLayoutParams();
      localObject1 = (RelativeLayout.LayoutParams)((TextView)localObject1).getLayoutParams();
      int i = bajq.b(32.0F);
      int j = bajq.b(28.0F);
      ((RelativeLayout.LayoutParams)localObject2).width = i;
      ((RelativeLayout.LayoutParams)localObject2).height = j;
      i = bajq.b(24.0F);
      localLayoutParams.width = i;
      localLayoutParams.height = i;
      localLayoutParams.leftMargin = bajq.b(4.0F);
      localURLImageView.setPadding(0, 0, 0, 0);
      localURLImageView.setBackgroundDrawable(null);
      localURLImageView.setImageDrawable(URLDrawable.getDrawable(str, null));
      if (AppSetting.c) {
        azve.b(this.jdField_a_of_type_AndroidViewView, false);
      }
      this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)this.jdField_a_of_type_AndroidAppActivity.getApplicationContext().getSystemService("window"));
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams = new WindowManager.LayoutParams();
      if (QLog.isColorLevel()) {
        QLog.d("WatchTogetherMiniAioHelper", 0, "is activity window focused " + this.jdField_a_of_type_AndroidAppActivity.hasWindowFocus());
      }
      i = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUserParam.positionX;
      j = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUserParam.positionY;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.type = 1002;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.format = 1;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.flags = 40;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.gravity = 51;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.x = i;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.y = j;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.width = -2;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.height = -2;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.token = this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView().getWindowToken();
      this.jdField_a_of_type_AndroidViewWindowManager.addView(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUserParam != null)
    {
      MiniMsgIPCClient.getInstance();
      MiniMsgIPCClient.register(this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUserParam.businessName, BaseApplicationImpl.getApplication().getQQProcessName());
      MiniMsgIPCClient.getInstance().syncGetUnread();
      MiniMsgIPCClient.getInstance();
      MiniMsgIPCClient.onProcessForeGround(this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUserParam.businessName);
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUserParam != null)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUserParam.accessType == 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUserParam.entryType == 0))
      {
        afui localafui = MiniMsgIPCClient.getInstance().getBusinessInfo(this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUserParam.businessName);
        if (localafui != null)
        {
          int[] arrayOfInt = ((afug)this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUserParam.unreadCallback).a();
          if (arrayOfInt != null)
          {
            localafui.c = arrayOfInt[0];
            localafui.d = arrayOfInt[1];
          }
        }
      }
      MiniMsgIPCClient.getInstance();
      MiniMsgIPCClient.onProcessBackground(this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUserParam.businessName);
    }
  }
  
  public void d() {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUserParam == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUserParam.actionCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUserParam.actionCallback.onOpenMiniAIOCallback();
    }
    paramView = new Intent();
    paramView.putExtra("key_mini_need_update_unread", true);
    paramView.putExtra("key_mini_msgtab_businame", this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUserParam.businessName);
    paramView.putExtra("key_mini_msgtab_type", this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUserParam.filterMsgType);
    paramView.putExtra("key_mini_msgtab_need_full_screen", this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUserParam.isNeedFullScreen);
    paramView.putExtra("key_mini_msgtab_isneed_back_conversation", this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUserParam.isNeedBackConversation);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUserParam.isNeedBackConversation) {
      paramView.putExtra("key_mini_msgtab_back_pending_intent", this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUserParam.backConversationIntent);
    }
    MiniChatActivity.a(this.jdField_a_of_type_AndroidAppActivity, 1, this.jdField_a_of_type_JavaLangString, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aqqm
 * JD-Core Version:    0.7.0.1
 */