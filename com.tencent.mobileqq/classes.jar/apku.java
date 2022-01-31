import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.forward.ForwardQFavBatchOption.1;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class apku
  extends aphp
{
  boolean i = false;
  
  public apku(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  public String a()
  {
    if (!this.i) {}
    for (this.jdField_a_of_type_JavaLangString = ajjy.a(2131638985);; this.jdField_a_of_type_JavaLangString = null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardQFavBatchOption", 2, "DialogContent:mForwardText=" + this.jdField_a_of_type_JavaLangString);
      }
      return this.jdField_a_of_type_JavaLangString;
    }
  }
  
  public boolean a()
  {
    super.a();
    this.i = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("bSinglePicSelected", false);
    if ((this.i) && (TextUtils.isEmpty(this.b))) {
      this.b = this.jdField_a_of_type_AndroidOsBundle.getString("forward_filepath");
    }
    if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("qqfav_extra_skip_confirm", false)) {
      v();
    }
    return true;
  }
  
  protected void b()
  {
    this.jdField_a_of_type_Bafb.setMessageWithEmo(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Float);
    TextView localTextView = this.jdField_a_of_type_Bafb.getMessageTextView();
    ViewGroup.LayoutParams localLayoutParams = localTextView.getLayoutParams();
    localLayoutParams.width = -1;
    localTextView.setLayoutParams(localLayoutParams);
    localTextView.setGravity(17);
  }
  
  public String c()
  {
    return this.jdField_a_of_type_AndroidOsBundle.getString("uinname");
  }
  
  protected void s()
  {
    if (this.i) {
      t();
    }
  }
  
  public void v()
  {
    String str1 = this.jdField_a_of_type_AndroidOsBundle.getString("troop_uin");
    String str2 = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
    String str3 = this.jdField_a_of_type_AndroidOsBundle.getString("uinname");
    int m = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
    Object localObject2 = new Intent();
    boolean bool = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("needStartChatActivity", false);
    ((Intent)localObject2).putExtra("needStartChatActivity", bool);
    Object localObject1 = localObject2;
    if (bool)
    {
      localObject1 = aciy.a((Intent)localObject2, null);
      ((Intent)localObject1).putExtras(this.jdField_a_of_type_AndroidOsBundle);
    }
    this.jdField_a_of_type_AndroidAppActivity.getIntent().putExtra("isFromFavorites", true);
    this.jdField_a_of_type_AndroidAppActivity.setResult(-1, (Intent)localObject1);
    this.jdField_a_of_type_AndroidAppActivity.finish();
    localObject1 = new Intent((Intent)localObject1);
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    int j;
    ArrayList localArrayList;
    int k;
    label180:
    Object localObject3;
    MqqHandler localMqqHandler;
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("forwardFromAIO", false))
    {
      j = 2;
      localArrayList = this.jdField_a_of_type_AndroidContentIntent.getParcelableArrayListExtra("bundleList");
      k = 0;
      if (k >= localArrayList.size()) {
        break label275;
      }
      localObject3 = (Bundle)localArrayList.get(k);
      if (localObject3 != null)
      {
        localMqqHandler = ThreadManager.getUIHandler();
        localObject3 = new ForwardQFavBatchOption.1(this, (Bundle)localObject3, (String)localObject2, str2, str1, m, j, str3, (Intent)localObject1);
        if (k != 0) {
          break label265;
        }
      }
    }
    label265:
    for (long l = 200L;; l = k * 10)
    {
      localMqqHandler.postDelayed((Runnable)localObject3, l);
      k += 1;
      break label180;
      j = 1;
      break;
    }
    label275:
    bfhz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "User_BatchForwardSendBtnClick", 0, 0, localArrayList.size());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apku
 * JD-Core Version:    0.7.0.1
 */