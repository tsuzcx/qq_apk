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
import java.util.Set;
import mqq.os.MqqHandler;

public class arxr
  extends arum
{
  boolean i = false;
  
  public arxr(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  public String a()
  {
    if (!this.i) {}
    for (this.jdField_a_of_type_JavaLangString = alpo.a(2131705153);; this.jdField_a_of_type_JavaLangString = null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardQFavBatchOption", 2, "DialogContent:mForwardText=" + this.jdField_a_of_type_JavaLangString);
      }
      return this.jdField_a_of_type_JavaLangString;
    }
  }
  
  protected void a()
  {
    super.a();
    Object localObject = this.jdField_a_of_type_AndroidContentIntent.getParcelableArrayListExtra("bundleList");
    if ((localObject != null) && (((ArrayList)localObject).size() == 1))
    {
      localObject = (Bundle)((ArrayList)localObject).get(0);
      if ((((Bundle)localObject).getInt("qfavType") == 5) && (((Bundle)localObject).getBoolean("k_dataline", false)))
      {
        this.jdField_a_of_type_JavaUtilSet.add(f);
        this.jdField_a_of_type_JavaUtilSet.add(k);
      }
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
    this.jdField_a_of_type_Bdfq.setMessageWithEmo(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Float);
    TextView localTextView = this.jdField_a_of_type_Bdfq.getMessageTextView();
    ViewGroup.LayoutParams localLayoutParams = localTextView.getLayoutParams();
    localLayoutParams.width = -1;
    localTextView.setLayoutParams(localLayoutParams);
    localTextView.setGravity(17);
  }
  
  protected void b(Intent paramIntent)
  {
    Object localObject1 = this.jdField_a_of_type_AndroidContentIntent.getParcelableArrayListExtra("bundleList");
    if ((localObject1 != null) && (((ArrayList)localObject1).size() == 1))
    {
      Bundle localBundle = (Bundle)((ArrayList)localObject1).get(0);
      if (localBundle.getInt("qfavType") == 5)
      {
        paramIntent.putExtra("dataline_forward_type", 100);
        Object localObject2 = localBundle.getString("forward_extra");
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = localBundle.getString("forward_extra");
        }
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = localBundle.getString("forward_filepath");
        }
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = localBundle.getString("forward_filepath");
        }
        if (localObject1 != null) {
          break label153;
        }
        localObject1 = localBundle.getString("GALLERY.FORWORD_LOCAL_PATH");
      }
    }
    label153:
    for (;;)
    {
      QLog.d("ForwardOption.ForwardQFavBatchOption", 1, "sendDatalineSingle filePath: " + (String)localObject1);
      paramIntent.putExtra("dataline_forward_path", (String)localObject1);
      bhnu.a(true, (String)localObject1);
      return;
    }
  }
  
  public String c()
  {
    String str = this.jdField_a_of_type_AndroidOsBundle.getString("uinname");
    if (this.jdField_a_of_type_AndroidOsBundle.getInt("key_forward_ability_type") == f.intValue()) {
      str = alpo.a(2131694652);
    }
    return str;
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
      localObject1 = aekt.a((Intent)localObject2, null);
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
    label193:
    Object localObject3;
    MqqHandler localMqqHandler;
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("forwardFromAIO", false))
    {
      j = 2;
      localArrayList = this.jdField_a_of_type_AndroidContentIntent.getParcelableArrayListExtra("bundleList");
      int n = this.jdField_a_of_type_AndroidOsBundle.getInt("KEY_MSG_FORWARD_ID");
      k = 0;
      if (k >= localArrayList.size()) {
        break label290;
      }
      localObject3 = (Bundle)localArrayList.get(k);
      if (localObject3 != null)
      {
        localMqqHandler = ThreadManager.getUIHandler();
        localObject3 = new ForwardQFavBatchOption.1(this, (Bundle)localObject3, str2, str1, m, n, (String)localObject2, j, str3, (Intent)localObject1);
        if (k != 0) {
          break label280;
        }
      }
    }
    label280:
    for (long l = 200L;; l = k * 10)
    {
      localMqqHandler.postDelayed((Runnable)localObject3, l);
      k += 1;
      break label193;
      j = 1;
      break;
    }
    label290:
    birh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "User_BatchForwardSendBtnClick", 0, 0, localArrayList.size());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arxr
 * JD-Core Version:    0.7.0.1
 */