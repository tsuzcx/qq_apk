import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.activity.miniaio.MiniMultiForwardFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;

public class aqep
  extends aqgo
{
  private ChatMessage a;
  
  public aqep(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  public static void a(aqbe paramaqbe, long paramLong)
  {
    String str2 = paramaqbe.c();
    String str1 = str2;
    if (!TextUtils.isEmpty(str2))
    {
      if (!str2.startsWith(ajya.a(2131704791))) {
        break label216;
      }
      str1 = str2.substring(4);
    }
    for (;;)
    {
      str2 = paramaqbe.jdField_a_of_type_AndroidOsBundle.getString("uin");
      int i = paramaqbe.jdField_a_of_type_AndroidOsBundle.getInt("uintype", 0);
      Intent localIntent = new Intent();
      localIntent.setClass(paramaqbe.jdField_a_of_type_AndroidAppActivity, MiniChatActivity.class);
      localIntent.addFlags(268435456);
      localIntent.putExtra("uin", str2);
      localIntent.putExtra("uintype", i);
      localIntent.putExtra("uinname", str1);
      localIntent.putExtra("public_fragment_window_feature", 1);
      localIntent.putExtra("minaio_scaled_ration", paramaqbe.a(0.78F));
      localIntent.putExtra("minaio_height_ration", 0.86F);
      localIntent.putExtra("member_dialog_title", str1);
      localIntent.putExtra("structmsg_uniseq", paramLong);
      localIntent.putExtra("multi_forward_title", ajya.a(2131704783));
      localIntent.putExtra("multi_forward_type", 3);
      localIntent.putExtra("key_mini_from", 4);
      abtq.a(paramaqbe.jdField_a_of_type_AndroidAppActivity, localIntent, MiniChatActivity.class, MiniMultiForwardFragment.class);
      return;
      label216:
      str1 = str2;
      if (str2.startsWith(ajya.a(2131704784))) {
        str1 = str2.substring(3);
      }
    }
  }
  
  protected View a()
  {
    View localView = super.a();
    if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) {
      localView.findViewById(2131366651).setOnClickListener(new aqeq(this));
    }
    return localView;
  }
  
  public String a()
  {
    String str2 = super.a();
    String str1 = str2;
    if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) {
      str1 = ajya.a(2131704785) + str2;
    }
    return str1;
  }
  
  protected void a()
  {
    if (k()) {
      this.jdField_a_of_type_JavaUtilSet.add(d);
    }
    if (l()) {
      this.jdField_a_of_type_JavaUtilSet.add(c);
    }
    if (m()) {
      this.jdField_a_of_type_JavaUtilSet.add(b);
    }
  }
  
  public boolean a()
  {
    boolean bool = super.a();
    long l = this.jdField_a_of_type_AndroidOsBundle.getLong("FORWARD_MSG_UNISEQ", -1L);
    if (l == -1L) {
      return bool;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = ((avqu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(340)).a(l);
    if (QLog.isColorLevel()) {
      QLog.d("ForwardReplyMsgOption", 2, "ForwardReplyMsgOption preloadData mChatMessage=" + this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
    }
    return bool;
  }
  
  protected boolean b(String paramString1, String paramString2, int paramInt)
  {
    int i = adgc.a().a();
    this.jdField_a_of_type_AndroidOsBundle.putInt("KEY_MSG_FORWARD_ID", i);
    return super.b(paramString1, paramString2, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqep
 * JD-Core Version:    0.7.0.1
 */