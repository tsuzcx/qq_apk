import QQWalletPay.ReqCheckChangePwdAuth;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

public class aoyp
  extends aoxg
{
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private aofr jdField_a_of_type_Aofr;
  private aoys jdField_a_of_type_Aoys;
  
  public aoyp(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  private boolean C()
  {
    if (!(this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) {
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("uin")) {}
    for (String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin"); !str.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()); str = "")
    {
      d();
      return false;
    }
    e();
    return false;
  }
  
  private void b(int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("android.intent.action.VIEW");
    localIntent.addCategory("android.intent.category.DEFAULT");
    localIntent.setData(Uri.parse("midas://open_modify_status?status=" + paramInt));
    if (this.jdField_a_of_type_AndroidContentContext.getPackageManager().queryIntentActivities(localIntent, 0).size() > 0) {
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    }
    ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).finish();
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidAppDialog = bhlq.a(this.jdField_a_of_type_AndroidContentContext, 2131692553, this.jdField_a_of_type_AndroidContentContext.getString(2131692540), 2131692542, 2131692541, new aoyq(this), new aoyr(this));
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  private void e()
  {
    Object localObject;
    String str1;
    label50:
    String str2;
    label75:
    String str3;
    label101:
    String str4;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("packageName"))
    {
      localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("packageName");
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("signareMode")) {
        break label311;
      }
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("signareMode");
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("appid")) {
        break label317;
      }
      str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("appid");
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("timeStamp")) {
        break label323;
      }
      str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("timeStamp");
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("resetWordMode")) {
        break label330;
      }
      str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("resetWordMode");
      label127:
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("offerid")) {
        break label337;
      }
    }
    label311:
    label317:
    label323:
    label330:
    label337:
    for (String str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("offerid");; str5 = "")
    {
      if (QLog.isColorLevel()) {
        QLog.d("QwalletModifyPassAction", 2, "packageName : " + (String)localObject + " signatureMode :" + str1 + " appid : " + str2 + " timestamp : " + str3 + " resetWordMode : " + str4 + " offerId : " + str5);
      }
      localObject = new ReqCheckChangePwdAuth((String)localObject, str1, str2, str3, str4, str5);
      ((aofq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(42)).a((ReqCheckChangePwdAuth)localObject);
      this.jdField_a_of_type_Aoys = new aoys(this, null);
      this.jdField_a_of_type_Aofr = new aofr(this.jdField_a_of_type_Aoys);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aofr);
      return;
      localObject = "";
      break;
      str1 = "";
      break label50;
      str2 = "";
      break label75;
      str3 = "";
      break label101;
      str4 = "";
      break label127;
    }
  }
  
  private void f()
  {
    com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp.f = true;
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("userId", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      localJSONObject.put("viewTag", "pswManage");
      if (!PayBridgeActivity.tenpay((Activity)this.jdField_a_of_type_AndroidContentContext, localJSONObject.toString(), 5, "")) {}
      for (int i = 1;; i = 0)
      {
        b(i);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      b(1);
    }
  }
  
  public boolean a()
  {
    try
    {
      boolean bool = C();
      return bool;
    }
    catch (Exception localException)
    {
      QLog.e("QwalletModifyPassAction", 1, "doAction error: " + localException.getMessage());
      a("QwalletModifyPassAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoyp
 * JD-Core Version:    0.7.0.1
 */