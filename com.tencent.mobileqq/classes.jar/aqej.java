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

public class aqej
  extends aqbe
{
  boolean i = false;
  
  public aqej(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  public String a()
  {
    if (!this.i) {}
    for (this.jdField_a_of_type_JavaLangString = ajya.a(2131704781);; this.jdField_a_of_type_JavaLangString = null)
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
    this.jdField_a_of_type_Bbgu.setMessageWithEmo(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Float);
    TextView localTextView = this.jdField_a_of_type_Bbgu.getMessageTextView();
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
      localObject1 = actj.a((Intent)localObject2, null);
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
    label191:
    Object localObject3;
    MqqHandler localMqqHandler;
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("forwardFromAIO", false))
    {
      j = 2;
      localArrayList = this.jdField_a_of_type_AndroidContentIntent.getParcelableArrayListExtra("bundleList");
      int n = this.jdField_a_of_type_AndroidOsBundle.getInt("KEY_MSG_FORWARD_ID");
      k = 0;
      if (k >= localArrayList.size()) {
        break label288;
      }
      localObject3 = (Bundle)localArrayList.get(k);
      if (localObject3 != null)
      {
        localMqqHandler = ThreadManager.getUIHandler();
        localObject3 = new ForwardQFavBatchOption.1(this, (Bundle)localObject3, str2, str1, m, n, (String)localObject2, j, str3, (Intent)localObject1);
        if (k != 0) {
          break label278;
        }
      }
    }
    label278:
    for (long l = 200L;; l = k * 10)
    {
      localMqqHandler.postDelayed((Runnable)localObject3, l);
      k += 1;
      break label191;
      j = 1;
      break;
    }
    label288:
    bgqi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "User_BatchForwardSendBtnClick", 0, 0, localArrayList.size());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqej
 * JD-Core Version:    0.7.0.1
 */