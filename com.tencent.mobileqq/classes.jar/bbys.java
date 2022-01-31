import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qrcode.activity.QRLoginAuthActivity;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.open.agent.AgentActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.manager.WtloginManager;
import mqq.observer.WtloginObserver;

public class bbys
{
  private static volatile bbys jdField_a_of_type_Bbys;
  public static boolean a;
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  private WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new bbyu(this);
  private byte[] jdField_a_of_type_ArrayOfByte;
  
  static
  {
    jdField_a_of_type_Boolean = true;
  }
  
  private bbys()
  {
    a();
  }
  
  public static bbys a()
  {
    if (jdField_a_of_type_Bbys == null) {}
    try
    {
      if (jdField_a_of_type_Bbys == null) {
        jdField_a_of_type_Bbys = new bbys();
      }
      return jdField_a_of_type_Bbys;
    }
    finally {}
  }
  
  @Nullable
  private static OpenSDKAppInterface a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof OpenSDKAppInterface)) {
      return (OpenSDKAppInterface)localAppRuntime;
    }
    return null;
  }
  
  private void a()
  {
    int i = 1;
    if (BaseApplicationImpl.sProcessId == 1) {}
    for (;;)
    {
      if (i != 0) {
        QIPCServerHelper.getInstance().register(new bbyt(this, "QR_LOGIN_QIPC_MODULE_NAME"));
      }
      return;
      i = 0;
    }
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {}
    for (paramArrayOfByte = new String(paramArrayOfByte);; paramArrayOfByte = ajjy.a(2131645398))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QrAgentLoginManager", 2, "onQRCodeExpired: invoked.  error: " + paramArrayOfByte);
      }
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
      {
        paramArrayOfByte = (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (paramArrayOfByte != null) {
          paramArrayOfByte.setVisibility(8);
        }
      }
      paramArrayOfByte = BaseActivity.sTopActivity;
      if (!(paramArrayOfByte instanceof ScannerActivity)) {
        break;
      }
      Intent localIntent = new Intent(paramArrayOfByte, QRLoginAuthActivity.class);
      localIntent.putExtra("QR_CODE_STRING", this.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("KEY_QR_CODE_EXPIRED", true);
      paramArrayOfByte.startActivityForResult(localIntent, 2);
      return;
    }
    paramArrayOfByte = new Intent(BaseApplicationImpl.context, QRLoginAuthActivity.class);
    paramArrayOfByte.putExtra("QR_CODE_STRING", this.jdField_a_of_type_JavaLangString);
    paramArrayOfByte.putExtra("KEY_QR_CODE_EXPIRED", true);
    BaseApplicationImpl.context.startActivity(paramArrayOfByte);
  }
  
  public void a(long paramLong, String paramString)
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    Intent localIntent = new Intent(localBaseActivity, AgentActivity.class);
    localIntent.putExtra("key_action", "action_login");
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("key_login_by_qr_scan", true);
    localBundle.putString("client_id", String.valueOf(paramLong));
    localBundle.putString("sdkp", paramString);
    localBundle.putLong("KEY_ONLINE_STATUS", this.jdField_a_of_type_Long);
    localBundle.putByteArray("key_qr_code", this.jdField_a_of_type_ArrayOfByte);
    localIntent.putExtra("key_params", localBundle);
    localBaseActivity.startActivity(localIntent);
  }
  
  public void a(Bundle paramBundle, boolean paramBoolean)
  {
    OpenSDKAppInterface localOpenSDKAppInterface = a();
    if (localOpenSDKAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QrAgentLoginManager", 2, " openSDKApp: " + localOpenSDKAppInterface);
      }
      return;
    }
    long l = paramBundle.getLong("KEY_ONLINE_STATUS");
    paramBundle = paramBundle.getByteArray("key_qr_code");
    Object localObject1 = vvp.a(l);
    Object localObject2 = ByteBuffer.allocate(localObject1.length + 4);
    ((ByteBuffer)localObject2).putShort((short)2);
    ((ByteBuffer)localObject2).putShort((short)localObject1.length);
    ((ByteBuffer)localObject2).put((byte[])localObject1);
    Object localObject3 = ((ByteBuffer)localObject2).array();
    localObject1 = localOpenSDKAppInterface.getAccount();
    localObject2 = new ArrayList();
    if ((!TextUtils.isEmpty("")) && (!"".equals(localObject1)))
    {
      byte[] arrayOfByte = "".getBytes();
      ByteBuffer localByteBuffer = ByteBuffer.allocate(arrayOfByte.length + 4);
      localByteBuffer.putShort((short)1);
      localByteBuffer.putShort((short)arrayOfByte.length);
      localByteBuffer.put(arrayOfByte);
      arrayOfByte = localByteBuffer.array();
      localByteBuffer = ByteBuffer.allocate(arrayOfByte.length + 4);
      localByteBuffer.putShort((short)4);
      localByteBuffer.putShort((short)arrayOfByte.length);
      localByteBuffer.put(arrayOfByte);
      arrayOfByte = localByteBuffer.array();
      ((ArrayList)localObject2).add(bach.a((byte[])localObject3));
      ((ArrayList)localObject2).add(bach.a(arrayOfByte));
      localObject3 = ByteBuffer.allocate(8);
      ((ByteBuffer)localObject3).putShort((short)21);
      ((ByteBuffer)localObject3).putShort((short)4);
      if (!paramBoolean) {
        break label349;
      }
    }
    label349:
    for (int i = 1;; i = 0)
    {
      ((ByteBuffer)localObject3).putInt(i);
      ((ArrayList)localObject2).add(bach.a(((ByteBuffer)localObject3).array()));
      ((WtloginManager)localOpenSDKAppInterface.getManager(1)).CloseCode((String)localObject1, 16L, paramBundle, 1, (ArrayList)localObject2, this.jdField_a_of_type_MqqObserverWtloginObserver);
      return;
      ((ArrayList)localObject2).add(bach.a((byte[])localObject3));
      break;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QrAgentLoginManager", 2, "requestQRLogin: invoked.  qrCodeStr: " + paramString);
    }
    this.jdField_a_of_type_Long = paramQQAppInterface.a();
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    this.jdField_a_of_type_JavaLangString = paramString;
    BaseApplicationImpl.context.getSharedPreferences("SP_QR_AGENT_LOGIN", 4).edit().putString("KEY_QR_AGENT_LOGIN_CODE" + paramQQAppInterface.c(), this.jdField_a_of_type_JavaLangString).apply();
    paramView = (WtloginManager)paramQQAppInterface.getManager(1);
    int i = paramString.indexOf("?k=") + 3;
    Object localObject = paramString.substring(i, i + 32);
    this.jdField_a_of_type_ArrayOfByte = QRLoginAuthActivity.a(((String)localObject).getBytes(), ((String)localObject).length());
    paramString = paramString.substring(paramString.indexOf("&f=") + 3);
    paramQQAppInterface = paramQQAppInterface.getAccount();
    if (QLog.isColorLevel()) {
      QLog.i("QrAgentLoginManager", 2, "requestQRLogin: invoked.  userAccount: " + paramQQAppInterface + " carAppIdString: " + paramString + " content: " + (String)localObject);
    }
    paramString = this.jdField_a_of_type_ArrayOfByte;
    localObject = this.jdField_a_of_type_MqqObserverWtloginObserver;
    paramView.VerifyCode(paramQQAppInterface, 16L, true, paramString, new int[] { 3, 5, 32, 54 }, 1, (WtloginObserver)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bbys
 * JD-Core Version:    0.7.0.1
 */