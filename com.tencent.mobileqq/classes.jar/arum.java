import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.dataline.activities.LiteActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.utils.LightAppSettingInfo;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RouterHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.forward.ForwardBaseOption.7;
import com.tencent.mobileqq.forward.ForwardBaseOption.8;
import com.tencent.mobileqq.hiboom.HiBoomTextView;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class arum
  implements DialogInterface.OnDismissListener, arub, aruc, arvd
{
  static int jdField_a_of_type_Int;
  static SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat;
  public static String e;
  float jdField_a_of_type_Float;
  public long a;
  almw jdField_a_of_type_Almw = new arup(this);
  public Activity a;
  public Context a;
  DialogInterface.OnClickListener jdField_a_of_type_AndroidContentDialogInterface$OnClickListener;
  public Intent a;
  public Bundle a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  public bdfq a;
  protected bepp a;
  public QQAppInterface a;
  protected String a;
  private ArrayList<ResultRecord> jdField_a_of_type_JavaUtilArrayList;
  protected Set<Integer> a;
  private zcp jdField_a_of_type_Zcp;
  protected zcs a;
  public boolean a;
  protected int b;
  DialogInterface.OnClickListener jdField_b_of_type_AndroidContentDialogInterface$OnClickListener;
  protected bepp b;
  protected String b;
  private ArrayList<ResultRecord> jdField_b_of_type_JavaUtilArrayList;
  protected boolean b;
  protected int c;
  DialogInterface.OnClickListener jdField_c_of_type_AndroidContentDialogInterface$OnClickListener;
  public String c;
  private ArrayList<ResultRecord> jdField_c_of_type_JavaUtilArrayList;
  protected boolean c;
  public String d;
  public boolean d;
  boolean e;
  protected String f;
  protected boolean f;
  protected boolean g;
  protected boolean h;
  
  static
  {
    jdField_e_of_type_JavaLangString = "key_thumb_style_centerinside";
  }
  
  public arum(Intent paramIntent)
  {
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_b_of_type_Int = 11;
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    if (paramIntent.getExtras() != null) {}
    for (paramIntent = paramIntent.getExtras();; paramIntent = new Bundle())
    {
      this.jdField_a_of_type_AndroidOsBundle = paramIntent;
      this.jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.getApplication().getApplicationContext();
      this.jdField_b_of_type_Boolean = false;
      return;
    }
  }
  
  private void G()
  {
    int i = this.jdField_a_of_type_AndroidOsBundle.getInt("key_forward_ability_type");
    if ((i == jdField_g_of_type_JavaLangInteger.intValue()) || (i == j.intValue()) || (i == m.intValue()) || (i == jdField_e_of_type_JavaLangInteger.intValue())) {
      this.jdField_a_of_type_AndroidOsBundle.putBoolean("is_ark_display_share", false);
    }
    if ((!this.jdField_a_of_type_AndroidOsBundle.getBoolean("share_msg_by_server_enable_entry", false)) && ((i == jdField_f_of_type_JavaLangInteger.intValue()) || (i == k.intValue()))) {
      this.jdField_a_of_type_AndroidOsBundle.putBoolean("is_ark_display_share", false);
    }
  }
  
  private void H()
  {
    if ((this.jdField_a_of_type_AndroidAppActivity == null) || (this.jdField_a_of_type_AndroidAppActivity.isFinishing()))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ForwardOption.ForwardBaseOption", 2, " qbShowShareResultDialog error mActivity = null");
      }
      return;
    }
    if (this.jdField_a_of_type_Zcp == null) {
      this.jdField_a_of_type_Zcp = new zcp(this.jdField_a_of_type_AndroidAppActivity);
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131719909);
    String str = this.jdField_a_of_type_AndroidOsBundle.getString("app_name");
    Object localObject1 = localObject2;
    if (str != null) {
      localObject1 = (String)localObject2 + str;
    }
    localObject2 = new arun(this);
    this.jdField_a_of_type_Zcp.a((String)localObject1, (DialogInterface.OnClickListener)localObject2);
    this.jdField_a_of_type_Zcp.a((DialogInterface.OnClickListener)localObject2);
    this.jdField_a_of_type_Zcp.show();
  }
  
  private void I()
  {
    int i = -1;
    if (f())
    {
      localObject = a().iterator();
      while (((Iterator)localObject).hasNext())
      {
        ResultRecord localResultRecord = (ResultRecord)((Iterator)localObject).next();
        a(localResultRecord.jdField_a_of_type_JavaLangString, localResultRecord.a());
      }
    }
    if (this.jdField_a_of_type_AndroidOsBundle != null) {}
    for (Object localObject = this.jdField_a_of_type_AndroidOsBundle.getString("uin");; localObject = "")
    {
      if (this.jdField_a_of_type_AndroidOsBundle != null) {
        i = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype", -1);
      }
      a((String)localObject, i);
      return;
    }
  }
  
  private void J()
  {
    Bundle localBundle = new Bundle();
    if (f())
    {
      Iterator localIterator = a().iterator();
      while (localIterator.hasNext())
      {
        localBundle.putLong("key_receiver_type", ((ResultRecord)localIterator.next()).a());
        QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:peak", "ae_camera_get_info_client", "action_get_send_to_info", localBundle, null);
      }
    }
    if (this.jdField_a_of_type_AndroidOsBundle != null) {}
    for (long l = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype", -1);; l = -1L)
    {
      localBundle.putLong("key_receiver_type", l);
      QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:peak", "ae_camera_get_info_client", "action_get_send_to_info", localBundle, null);
      return;
    }
  }
  
  private void K()
  {
    arwl localarwl = new arwl(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_Bdfq = localarwl;
    if (!d()) {}
    for (boolean bool = true;; bool = false)
    {
      localarwl.a(bool);
      localarwl.b(210);
      localarwl.a(a());
      localarwl.setCanceledOnTouchOutside(false);
      localarwl.a(c(), d(), this.jdField_a_of_type_AndroidAppActivity.getResources().getString(a()), this.jdField_a_of_type_AndroidAppActivity.getResources().getString(b()), a(), b());
      a(localarwl);
      if (!this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
        localarwl.show();
      }
      this.jdField_a_of_type_Bdfq.setOnDismissListener(this);
      return;
    }
  }
  
  public static int a(Bundle paramBundle)
  {
    int m = paramBundle.getInt("forward_source_business_type", -1);
    int j = -11;
    int i = m;
    int k;
    if (m == -1)
    {
      k = paramBundle.getInt("forward_source_uin_type", -1);
      if (k != 0) {
        break label85;
      }
      i = 100101;
      j = k;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardBaseOption", 2, "getForwardSrcBusinessType, srcBusinessType = " + i + ",sourceUinType = " + j);
      }
      return i;
      label85:
      if (k == 1)
      {
        i = 100100;
        j = k;
      }
      else
      {
        j = k;
        i = m;
        if (k == 3000)
        {
          i = 100300;
          j = k;
        }
      }
    }
  }
  
  @Deprecated
  public static void a(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    a(paramActivity, paramIntent, ForwardRecentActivity.class, paramInt, -1, "");
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, int paramInt1, int paramInt2)
  {
    a(paramActivity, paramIntent, ForwardRecentActivity.class, paramInt1, paramInt2, "");
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, int paramInt1, int paramInt2, String paramString)
  {
    a(paramActivity, paramIntent, ForwardRecentActivity.class, paramInt1, paramInt2, paramString);
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, int paramInt, String paramString)
  {
    a(paramActivity, paramIntent, ForwardRecentActivity.class, paramInt, paramString);
  }
  
  @Deprecated
  public static void a(Activity paramActivity, Intent paramIntent, Class<?> paramClass, int paramInt)
  {
    a(paramActivity, paramIntent, paramClass, paramInt, -1, "");
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, Class<?> paramClass, int paramInt1, int paramInt2, String paramString)
  {
    paramIntent.setClass(paramActivity, paramClass);
    paramIntent.putExtra("caller_name", paramActivity.getClass().getSimpleName());
    paramIntent.putExtra("forward_source_business_type", paramInt2);
    paramIntent.putExtra("forward_source_sub_business_type", paramString);
    paramActivity.startActivityForResult(paramIntent, paramInt1);
  }
  
  public static void a(Activity paramActivity, String paramString, Intent paramIntent, int paramInt1, int paramInt2)
  {
    a(paramActivity, paramString, paramIntent, ForwardRecentActivity.class, paramInt1, paramInt2);
  }
  
  private static void a(Activity paramActivity, String paramString, Intent paramIntent, Class<?> paramClass, int paramInt1, int paramInt2)
  {
    paramIntent.setClass(paramActivity, paramClass);
    if (TextUtils.isEmpty(paramString)) {
      paramIntent.putExtra("caller_name", paramActivity.getClass().getSimpleName());
    }
    for (;;)
    {
      paramIntent.putExtra("forward_source_business_type", paramInt2);
      paramActivity.startActivityForResult(paramIntent, paramInt1);
      return;
      paramIntent.putExtra("caller_name", paramString);
    }
  }
  
  @Deprecated
  public static void a(Context paramContext, Intent paramIntent)
  {
    a(paramContext, paramIntent, ForwardRecentActivity.class, -1, "");
  }
  
  @Deprecated
  public static void a(Context paramContext, Intent paramIntent, Class<?> paramClass)
  {
    a(paramContext, paramIntent, paramClass, -1, "");
  }
  
  private static void a(Context paramContext, Intent paramIntent, Class<?> paramClass, int paramInt, String paramString)
  {
    if (paramContext != null)
    {
      paramIntent.setClass(paramContext, paramClass);
      paramIntent.putExtra("forward_source_business_type", paramInt);
      paramIntent.putExtra("forward_source_sub_business_type", paramString);
      paramContext.startActivity(paramIntent);
    }
  }
  
  private void a(Bundle paramBundle, int paramInt, String paramString)
  {
    long l = paramBundle.getLong("req_share_id", 0L);
    boolean bool;
    if (l == 0L)
    {
      paramBundle = paramBundle.getString("forward_ark_app_meta");
      if (TextUtils.isEmpty(paramBundle)) {
        if (QLog.isColorLevel()) {
          QLog.d("ForwardOption.ForwardBaseOption", 2, "reportClickSend arkAppId is empty");
        }
      }
      label88:
      do
      {
        return;
        try
        {
          paramBundle = new JSONObject(paramBundle).optJSONObject("news");
          if (paramBundle == null) {
            break;
          }
          paramBundle = paramBundle.optString("appid");
        }
        catch (JSONException paramBundle)
        {
          for (;;)
          {
            paramBundle.printStackTrace();
            paramBundle = null;
          }
        }
        if ((paramInt != 1) && (paramInt != 2)) {
          break label206;
        }
        bool = true;
        if (QLog.isColorLevel()) {
          QLog.d("ForwardOption.ForwardBaseOption", 2, "reportClickSend ,isForwardC2cOrGroup = " + bool);
        }
      } while ((!"101492711".equals(paramBundle)) || (!bool));
      if (paramInt != 1) {
        break label212;
      }
    }
    label206:
    label212:
    for (String str = "c2c_AIO";; str = "Grp_AIO")
    {
      azmj.b(null, "dc00899", str, "", "video_tab", "videoark_share", 0, 0, paramString, paramBundle, "", "");
      return;
      paramBundle = l + "";
      break;
      bool = false;
      break label88;
    }
  }
  
  private void a(bdgv parambdgv)
  {
    if (parambdgv == null) {}
    String str2;
    int i;
    boolean bool;
    String str1;
    do
    {
      return;
      localObject = a();
      if (localObject != null) {
        break;
      }
      str2 = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
      i = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype", 0);
      bool = this.jdField_a_of_type_AndroidOsBundle.getBoolean("new_create_troop", false);
      str1 = c();
    } while ((!a(i)) || (TextUtils.isEmpty(str1)));
    String str3 = alpo.a(2131705118);
    Object localObject = str1;
    if (str1.startsWith(str3)) {
      localObject = str1.substring(str3.length());
    }
    localObject = ((String)localObject).trim();
    parambdgv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, str2, i, (String)localObject, bool);
    return;
    if (((List)localObject).size() == 1)
    {
      localObject = (ResultRecord)((List)localObject).get(0);
      parambdgv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, ((ResultRecord)localObject).jdField_a_of_type_JavaLangString, ((ResultRecord)localObject).a(), ((ResultRecord)localObject).jdField_b_of_type_JavaLangString, false);
      return;
    }
    parambdgv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, (List)localObject, true);
  }
  
  private void a(AIORichMediaData paramAIORichMediaData, String paramString)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("startToAioImagePreview: msgId=");
      if (paramAIORichMediaData == null) {
        break label98;
      }
    }
    label98:
    for (Object localObject = Long.valueOf(paramAIORichMediaData.f);; localObject = "")
    {
      QLog.d("ForwardOption.ForwardBaseOption", 2, localObject);
      if (paramAIORichMediaData != null)
      {
        paramString = new AIOImageProviderService(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), paramString, 0, null);
        localObject = new Bundle();
        ((Bundle)localObject).putBoolean("extra.EXTRA_NOT_CLEAR_TOP", true);
        a((Bundle)localObject, paramString, paramAIORichMediaData);
        D();
      }
      return;
    }
  }
  
  private void a(MessageForPic paramMessageForPic, String paramString)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("startToAioImagePreview: uniseq=");
      if (paramMessageForPic == null) {
        break label101;
      }
    }
    label101:
    for (Object localObject = Long.valueOf(paramMessageForPic.uniseq);; localObject = "")
    {
      QLog.d("ForwardOption.ForwardBaseOption", 2, localObject);
      if (paramMessageForPic != null)
      {
        paramString = new AIOImageProviderService(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), paramString, 0, paramMessageForPic);
        localObject = new Bundle();
        ((Bundle)localObject).putBoolean("extra.EXTRA_NOT_CLEAR_TOP", true);
        a((Bundle)localObject, paramString, agem.a(paramMessageForPic));
        D();
      }
      return;
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidContentIntent != null) && (("ChatActivity".equals(this.jdField_a_of_type_AndroidContentIntent.getStringExtra("caller_name"))) || ("SplashActivity".equals(this.jdField_a_of_type_AndroidContentIntent.getStringExtra("caller_name"))))) {
      afsf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt, this.jdField_a_of_type_AndroidContentIntent.getStringExtra("forward_photo_sender_uin"), this.jdField_a_of_type_AndroidContentIntent.getStringExtra("forward_photo_md5"), "0X8009F55", paramString);
    }
    while ((this.jdField_a_of_type_AndroidContentIntent == null) || (!"PublicTransFragmentActivity".equals(this.jdField_a_of_type_AndroidContentIntent.getStringExtra("caller_name")))) {
      return;
    }
    afsf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt, this.jdField_a_of_type_AndroidContentIntent.getStringExtra("forward_photo_sender_uin"), this.jdField_a_of_type_AndroidContentIntent.getStringExtra("forward_photo_md5"), "0X8009F56", paramString);
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardBaseOption", 2, "startToAioImagePreviewWithPath: path=" + paramString1);
    }
    if (!TextUtils.isEmpty(paramString1))
    {
      AIOImageData localAIOImageData = new AIOImageData();
      localAIOImageData.jdField_a_of_type_JavaLangString = paramString1;
      localAIOImageData.jdField_b_of_type_JavaLangString = paramString1;
      localAIOImageData.jdField_c_of_type_JavaLangString = paramString1;
      localAIOImageData.jdField_e_of_type_Boolean = false;
      paramString1 = new Bundle();
      paramString1.putBoolean("extra.EXTRA_NOT_CLEAR_TOP", true);
      a(paramString1, new AIOImageProviderService(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), paramString2, 0, null), localAIOImageData);
      D();
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("key_mini_report_event_action_type", paramString1);
    localBundle.putString("key_mini_report_event_sub_action_type", paramString2);
    localBundle.putString("key_mini_report_event_reserves", paramString3);
    localBundle.putString("key_mini_report_event_reserves2", paramString4);
    QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_report_event", localBundle, null);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString)
  {
    boolean bool;
    String str;
    if ((paramInt == 1) || (paramInt == 2))
    {
      bool = true;
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardBaseOption", 2, "reportClickSend ,isAudioReqType = " + paramBoolean1 + ",isMusicArkView = " + paramBoolean2 + ",isForwardC2cOrGroup = " + bool);
      }
      if (((paramBoolean1) || (paramBoolean2)) && (bool))
      {
        if (paramInt != 1) {
          break label132;
        }
        str = "c2c_AIO";
        label89:
        if (paramInt != 1) {
          break label140;
        }
        paramString = "";
      }
    }
    label132:
    label140:
    for (;;)
    {
      azmj.b(null, "dc00899", str, "", "music_tab", "musicark_share", 0, 0, paramString, "", "", "");
      return;
      bool = false;
      break;
      str = "Grp_AIO";
      break label89;
    }
  }
  
  private boolean a(int paramInt)
  {
    if ((paramInt == 1) || (paramInt == 0) || (paramInt == 1006) || (paramInt == 3000) || (paramInt == 1000)) {}
    while (f()) {
      return true;
    }
    return false;
  }
  
  public static boolean a(Bundle paramBundle)
  {
    int i = paramBundle.getInt("forward_source_uin_type", -1);
    return (i == 1004) || (i == 1000);
  }
  
  private boolean d()
  {
    int i = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype", 0);
    int j = this.jdField_a_of_type_AndroidOsBundle.getInt("key_forward_ability_type");
    if (a(i)) {}
    while ((j == jdField_f_of_type_JavaLangInteger.intValue()) || (j == k.intValue()) || (i == 1024) || (i == 1025)) {
      return true;
    }
    return false;
  }
  
  private void e()
  {
    if (jdField_a_of_type_Int <= 0)
    {
      Display localDisplay = ((WindowManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("window")).getDefaultDisplay();
      int i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297299);
      int j = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297301);
      jdField_a_of_type_Int = (localDisplay.getWidth() - i * 2 - j * 3) / 4;
    }
  }
  
  private int f()
  {
    if (d()) {
      return 2;
    }
    return 0;
  }
  
  public void A()
  {
    int i = e();
    String str = this.jdField_a_of_type_AndroidOsBundle.getString("forward_source_sub_business_type", "");
    int j = a(this.jdField_a_of_type_AndroidOsBundle.getInt("forward_type", 2147483647));
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardBaseOption", 2, "reportShowForwardRecent srcBusinessType = " + i + ",srcSubBusinessType = " + str);
    }
    azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A7EB", "0X800A7EB", i, 0, "", "", String.valueOf(j), str);
  }
  
  public void B()
  {
    if (jdField_a_of_type_JavaTextSimpleDateFormat == null) {
      jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    }
    int i = e();
    String str1 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_source_sub_business_type", "");
    String str2 = jdField_a_of_type_JavaTextSimpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
    int k = this.jdField_a_of_type_AndroidOsBundle.getInt("forward_type", 2147483647);
    int j = a(k);
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardBaseOption", 2, "reportFinalSelectedTargets srcBusinessType = " + i + ",srcSubBusinessType = " + str1 + ",forwardType = " + k + ",forwardMsgType = " + j + ",operateTime = " + str2);
    }
    Object localObject;
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    }
    while (((Iterator)localObject).hasNext())
    {
      ResultRecord localResultRecord = (ResultRecord)((Iterator)localObject).next();
      String str3 = localResultRecord.jdField_a_of_type_JavaLangString;
      k = localResultRecord.jdField_b_of_type_Int;
      int m = a(str3, k);
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str3, "0X800A7EC", "0X800A7EC", i, 0, str2, String.valueOf(m), String.valueOf(j), str1);
      if (QLog.isColorLevel())
      {
        QLog.d("ForwardOption.ForwardBaseOption", 2, "reportFinalSelectedTargets multi,,targetUin = " + str3 + ",targetUinType = " + k + ",forwardTargetType = " + m + ",srcSubBusinessType = " + str1);
        continue;
        k = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
        localObject = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
        m = a((String)localObject, k);
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", (String)localObject, "0X800A7EC", "0X800A7EC", i, 0, str2, String.valueOf(m), String.valueOf(j), str1);
        if (QLog.isColorLevel()) {
          QLog.d("ForwardOption.ForwardBaseOption", 2, "reportFinalSelectedTargets single,,targetUin = " + (String)localObject + ",targetUinType = " + k + ",forwardTargetType = " + m + ",srcSubBusinessType = " + str1);
        }
      }
    }
  }
  
  public void C()
  {
    if (jdField_a_of_type_JavaTextSimpleDateFormat == null) {
      jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    }
    int j = e();
    String str2 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_source_sub_business_type", "");
    String str1 = "";
    Object localObject2 = jdField_a_of_type_JavaTextSimpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
    int i = this.jdField_a_of_type_AndroidOsBundle.getInt("forward_type", 2147483647);
    int k = a(i);
    Object localObject1 = "";
    if ((this.jdField_a_of_type_Bdfq instanceof bdgl))
    {
      localObject1 = ((bdgl)this.jdField_a_of_type_Bdfq).getInputValue();
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label655;
      }
    }
    label641:
    label655:
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardBaseOption", 2, "reportClickSend srcBusinessType = " + j + ",srcSubBusinessType = " + str2 + ",forwardType = " + i + ",forwardMsgType = " + k + ",hasLeftAMessage = " + bool + ",operateTime = " + (String)localObject2);
      }
      label230:
      int m;
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        i = -1;
        localObject1 = str1;
        if (((Iterator)localObject2).hasNext())
        {
          localObject1 = (ResultRecord)((Iterator)localObject2).next();
          str1 = ((ResultRecord)localObject1).jdField_a_of_type_JavaLangString;
          m = ((ResultRecord)localObject1).jdField_b_of_type_Int;
          i = a(str1, m);
          QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          if (bool) {}
          for (localObject1 = "1";; localObject1 = "2")
          {
            azmj.b(localQQAppInterface, "dc00898", "", str1, "0X800A7ED", "0X800A7ED", j, 0, (String)localObject1, String.valueOf(i), String.valueOf(k), str2);
            if (QLog.isColorLevel()) {
              QLog.d("ForwardOption.ForwardBaseOption", 2, "reportClickSend multi,,targetUin = " + str1 + ",targetUinType = " + m + ",forwardTargetType = " + i + ",srcSubBusinessType = " + str2);
            }
            localObject1 = str1;
            break label230;
            if (!(this.jdField_a_of_type_Bdfq instanceof arwl)) {
              break;
            }
            localObject1 = ((arwl)this.jdField_a_of_type_Bdfq).getInputValue();
            break;
          }
        }
      }
      else
      {
        this.jdField_a_of_type_AndroidOsBundle.getInt("forward_source_uin_type");
        m = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
        str1 = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
        i = a(str1, m);
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (!bool) {
          break label641;
        }
        localObject1 = "1";
        azmj.b((QQAppInterface)localObject2, "dc00898", "", str1, "0X800A7ED", "0X800A7ED", j, 0, (String)localObject1, String.valueOf(i), String.valueOf(k), str2);
        if (QLog.isColorLevel()) {
          QLog.d("ForwardOption.ForwardBaseOption", 2, "reportClickSend single,,targetUin = " + str1 + ",targetUinType = " + m + ",forwardTargetType = " + i + ",srcSubBusinessType = " + str2);
        }
        localObject1 = str1;
      }
      if (2 == this.jdField_a_of_type_AndroidOsBundle.getInt("req_type")) {}
      for (bool = true;; bool = false)
      {
        a(bool, "music".equals(this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_view")), i, (String)localObject1);
        a(this.jdField_a_of_type_AndroidOsBundle, i, (String)localObject1);
        return;
        localObject1 = "2";
        break;
      }
    }
  }
  
  public void D()
  {
    azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009BE9", "0X8009BE9", this.jdField_b_of_type_Int, 0, "", "", "", "");
  }
  
  public void E()
  {
    azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009BEA", "0X8009BEA", this.jdField_b_of_type_Int, 0, "", "", "", "");
    C();
  }
  
  public void F()
  {
    if (!this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("key_forward_image_share", false)) {}
    String str;
    do
    {
      do
      {
        return;
        str = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("key_forward_image_share_appid");
      } while (TextUtils.isEmpty(str));
      int i = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("key_forward_image_share_uin_type", 0);
      azmj.b(null, "dc00898", "", "", "0X800A27", "0X800A27", 0, 0, "", ForwardUtils.a(this.jdField_a_of_type_AndroidOsBundle.getInt("uintype")), str, ForwardUtils.b(i));
    } while (!QLog.isColorLevel());
    QLog.d("ForwardOption.ForwardBaseOption", 2, "大图转发=0X800A27, appid" + str);
  }
  
  public float a(float paramFloat)
  {
    Display localDisplay = this.jdField_a_of_type_AndroidAppActivity.getWindowManager().getDefaultDisplay();
    float f2 = localDisplay.getWidth();
    int i = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131296779);
    float f1 = paramFloat;
    if (i > f2 * paramFloat)
    {
      f2 = i / localDisplay.getWidth();
      f1 = paramFloat;
      if (f2 > paramFloat)
      {
        f1 = paramFloat;
        if (f2 < 1.0D) {
          f1 = f2;
        }
      }
    }
    return f1;
  }
  
  public int a()
  {
    return 2131690648;
  }
  
  int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 100;
    case -1: 
      return 1;
    case 1: 
      return 2;
    case 8: 
      return 3;
    case 21: 
      return 4;
    case 3: 
      return 5;
    case -5: 
      return 6;
    case 14: 
      return 7;
    case 20: 
    case 23: 
      return 8;
    case 24: 
      return 9;
    case -3: 
    case 1001: 
      return 10;
    }
    return 11;
  }
  
  int a(String paramString, int paramInt)
  {
    if (aljq.z.equals(paramString)) {
      paramInt = 4;
    }
    do
    {
      return paramInt;
      if ("-1010".equals(paramString)) {
        return 6;
      }
      switch (paramInt)
      {
      default: 
        return 100;
      case 0: 
        paramInt = 1;
      }
    } while (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramString));
    return 5;
    return 2;
    return 3;
    return 7;
  }
  
  protected final DialogInterface.OnClickListener a()
  {
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener == null) {
      this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new aruq(this);
    }
    return this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener;
  }
  
  public Bundle a()
  {
    return this.jdField_a_of_type_AndroidOsBundle;
  }
  
  protected View.OnClickListener a(aruy paramaruy)
  {
    String str = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
    if (this.jdField_a_of_type_AndroidViewView$OnClickListener == null) {
      this.jdField_a_of_type_AndroidViewView$OnClickListener = new arut(this, str, paramaruy);
    }
    return this.jdField_a_of_type_AndroidViewView$OnClickListener;
  }
  
  protected View a()
  {
    return null;
  }
  
  public String a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardBaseOption", 2, "DialogContent:mForwardText=" + this.jdField_a_of_type_JavaLangString);
    }
    return this.jdField_a_of_type_JavaLangString;
  }
  
  protected List<ResultRecord> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public List<RecentUser> a(List<RecentUser> paramList)
  {
    boolean bool = p();
    ArrayList localArrayList = new ArrayList();
    RecentUser localRecentUser;
    if ((bool) && (this.jdField_c_of_type_Int == 2))
    {
      localRecentUser = new RecentUser(aljq.z, 6000);
      localRecentUser.displayName = alpo.a(2131694652);
      localArrayList.add(localRecentUser);
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localRecentUser = (RecentUser)paramList.next();
      if ((bool) && (this.jdField_c_of_type_Int == 1) && (localRecentUser != null) && (TextUtils.equals(localRecentUser.uin, aljq.z))) {
        localArrayList.add(localRecentUser);
      } else if ((localRecentUser != null) && (!bdal.a(localRecentUser.uin)) && (localRecentUser.getType() != 1020) && (localRecentUser.getType() != 1008) && (localRecentUser.getType() != 1005) && ((localRecentUser.getType() != 1006) || (a(aruc.jdField_h_of_type_JavaLangInteger))) && (localRecentUser.getType() != 1009) && (localRecentUser.getType() != 1021) && (localRecentUser.getType() != 1001) && (localRecentUser.getType() != 10002) && (localRecentUser.getType() != 10004) && (localRecentUser.getType() != 1022) && (localRecentUser.getType() != 1032) && (localRecentUser.getType() != 1033) && (localRecentUser.getType() != 1034) && (localRecentUser.getType() != 7000) && (localRecentUser.getType() != 6004) && (localRecentUser.getType() != 9501) && ((localRecentUser.getType() != 1) || (!a(localRecentUser.uin))) && ((localRecentUser.getType() != 0) || (!ndv.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser.uin, localRecentUser.getType()))) && (((localRecentUser.getType() != 1004) && (localRecentUser.getType() != 1000)) || (this.jdField_b_of_type_Boolean))) {
        localArrayList.add(localRecentUser);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("ForwardOption.ForwardBaseOption", 2, "getForwardRecentList result size is: " + localArrayList.size());
    }
    return localArrayList;
  }
  
  public Set<Integer> a()
  {
    if (this.jdField_a_of_type_JavaUtilSet == null)
    {
      this.jdField_a_of_type_JavaUtilSet = new HashSet();
      a();
    }
    return this.jdField_a_of_type_JavaUtilSet;
  }
  
  protected void a()
  {
    if (m()) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_b_of_type_JavaLangInteger);
    }
    if (k()) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_d_of_type_JavaLangInteger);
    }
    if (l()) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_c_of_type_JavaLangInteger);
    }
    if (j()) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_h_of_type_JavaLangInteger);
    }
    if (n()) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_e_of_type_JavaLangInteger);
    }
    this.jdField_a_of_type_JavaUtilSet.add(i);
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_b_of_type_Bepp == null) {
      this.jdField_b_of_type_Bepp = new bepp(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
    }
    this.jdField_b_of_type_Bepp.c(paramInt);
    if (!this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
      this.jdField_b_of_type_Bepp.show();
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if (!e()) {
      return;
    }
    if (paramInt >= 0) {
      this.jdField_a_of_type_AndroidOsBundle.putInt("key_forward_ability_type", paramInt);
    }
    if (paramBundle != null)
    {
      this.jdField_g_of_type_Boolean = paramBundle.getBoolean("from_outside_share", false);
      this.jdField_h_of_type_Boolean = paramBundle.getBoolean("from_dataline_aio", false);
      this.jdField_f_of_type_JavaLangString = paramBundle.getString("caller_name", "");
      this.jdField_a_of_type_AndroidOsBundle.putAll(paramBundle);
    }
    this.jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_AndroidOsBundle.getParcelableArrayList("forward_multi_target");
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      paramBundle = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramBundle.hasNext())
      {
        ResultRecord localResultRecord = (ResultRecord)paramBundle.next();
        if ((localResultRecord.jdField_b_of_type_Int != 6000) && (localResultRecord.jdField_b_of_type_Int != 6003)) {
          this.jdField_b_of_type_JavaUtilArrayList.add(localResultRecord);
        } else {
          this.jdField_c_of_type_JavaUtilArrayList.add(localResultRecord);
        }
      }
    }
    l();
  }
  
  protected void a(Intent paramIntent) {}
  
  public void a(Drawable paramDrawable, boolean paramBoolean)
  {
    if (paramBoolean) {
      baul.a((URLDrawable)paramDrawable, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), true);
    }
    if (paramDrawable == null) {}
    while (paramBoolean) {
      return;
    }
    paramDrawable.setBounds(bdda.a(paramDrawable, 36, 100, this.jdField_a_of_type_Float));
  }
  
  protected void a(Drawable paramDrawable, boolean paramBoolean, int paramInt)
  {
    a(paramDrawable, paramBoolean, paramInt, false);
  }
  
  public void a(Drawable paramDrawable, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new ForwardBaseOption.7(this, paramDrawable, paramBoolean1, paramInt, paramBoolean2));
  }
  
  public void a(Bundle paramBundle)
  {
    if ((this.jdField_a_of_type_Bdfq != null) && (this.jdField_a_of_type_Bdfq.isShowing())) {
      paramBundle.putBundle("key_forward_base_option_bundle", this.jdField_a_of_type_AndroidOsBundle);
    }
  }
  
  protected void a(Bundle paramBundle, AIOImageProviderService paramAIOImageProviderService, AIORichMediaData paramAIORichMediaData)
  {
    bilx.a(this.jdField_a_of_type_AndroidAppActivity, paramBundle, paramAIOImageProviderService, paramAIORichMediaData, 19001, 4);
  }
  
  protected void a(Bundle paramBundle, String paramString, da paramda)
  {
    allz localallz = (allz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8);
    paramBundle = "";
    if ((this.jdField_a_of_type_Bdfq instanceof bdgl)) {
      paramBundle = ((bdgl)this.jdField_a_of_type_Bdfq).getInputValue();
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramBundle))
      {
        if (QLog.isColorLevel()) {
          QLog.i("ForwardOption.ForwardBaseOption", 2, "sendDataLineMessage: invoked.  textAndEmoji: " + paramBundle);
        }
        b(new Intent());
        Bundle localBundle = new Bundle();
        localBundle.putBoolean("sendMultiple", false);
        localBundle.putInt("dataline_forward_type", 102);
        localBundle.putString("dataline_forward_text", paramBundle);
        int i = localallz.a().b(paramString, localBundle, paramda);
        if (QLog.isColorLevel()) {
          QLog.i("ForwardOption.ForwardBaseOption", 2, "sendDataLineMessage: invoked.  noteRet: " + i);
        }
      }
      return;
      if ((this.jdField_a_of_type_Bdfq instanceof arwl)) {
        paramBundle = ((arwl)this.jdField_a_of_type_Bdfq).getInputValue();
      }
    }
  }
  
  public void a(bdfq parambdfq) {}
  
  public void a(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidAppActivity.getResources().getDisplayMetrics().density;
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidOsBundle != null) {
      this.jdField_a_of_type_AndroidOsBundle.remove(paramString);
    }
  }
  
  protected final void a(String paramString, bdfq parambdfq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardBaseOption", 2, "addSourceNameView start! sourceName =" + paramString);
    }
    if ((paramString == null) || ("".equals(paramString)) || (parambdfq == null)) {
      return;
    }
    TextView localTextView = new TextView(this.jdField_a_of_type_AndroidAppActivity);
    localTextView.setText(paramString);
    localTextView.setTextSize(12.0F);
    localTextView.setPadding(0, 0, 0, 0);
    localTextView.setIncludeFontPadding(false);
    localTextView.setTextColor(-8355712);
    parambdfq.addView(localTextView);
  }
  
  public void a(String paramString1, String paramString2, Bundle paramBundle)
  {
    this.jdField_d_of_type_Boolean = true;
    Bundle localBundle = new Bundle();
    if (paramBundle != null) {
      localBundle.putAll(paramBundle);
    }
    localBundle.putString("uin", paramString1);
    localBundle.putInt("uintype", 1);
    localBundle.putBoolean("new_create_troop", true);
    localBundle.putString("uinname", alpo.a(2131705117) + paramString2);
    a(aruc.jdField_d_of_type_JavaLangInteger.intValue(), localBundle);
  }
  
  public void a(boolean paramBoolean) {}
  
  public boolean a()
  {
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("forward_thumb");
    this.jdField_a_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("forward_urldrawable", false);
    this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("forward_urldrawable_thumb_url");
    this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("forward_urldrawable_big_url");
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("forward_text");
    this.jdField_f_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("forward_from_jump", false);
    this.jdField_c_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("key_share_data_line_support_type", 0);
    if (this.jdField_a_of_type_AndroidOsBundle != null)
    {
      if (this.jdField_a_of_type_AndroidOsBundle.getInt("forward_type", -1) == 11) {
        this.jdField_c_of_type_Boolean = true;
      }
      this.jdField_a_of_type_Long = this.jdField_a_of_type_AndroidOsBundle.getLong("req_share_id", 0L);
    }
    e();
    return true;
  }
  
  public boolean a(int paramInt1, String paramString, int paramInt2)
  {
    if ((paramInt2 == jdField_f_of_type_JavaLangInteger.intValue()) || (paramInt2 == k.intValue())) {}
    boolean bool1;
    do
    {
      do
      {
        return false;
      } while ((this.jdField_c_of_type_Boolean) || ((this instanceof arzf)) || ((this instanceof aruz)) || (this.jdField_a_of_type_AndroidOsBundle.getInt("cmshow_game_id") > 0));
      bool1 = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("forward_source_from_shoot_quick", false);
      bool2 = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("forward_source_from_pre_guide", false);
    } while ((bool1) || (bool2));
    if (paramInt1 == 1) {
      if (((bcjl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48)).a(paramString, true).jdField_a_of_type_Boolean)
      {
        bool1 = false;
        bool2 = bool1;
        if (bool1)
        {
          bool2 = bool1;
          if ((this instanceof arvo))
          {
            paramString = (arvo)this;
            bool2 = bool1;
            if (paramString.a != null)
            {
              bool2 = bool1;
              if (paramString.a.b() != 10006) {}
            }
          }
        }
      }
    }
    for (boolean bool2 = false;; bool2 = true)
    {
      return bool2;
      bool1 = true;
      break;
    }
  }
  
  protected boolean a(Intent paramIntent)
  {
    boolean bool2 = this.jdField_a_of_type_AndroidOsBundle.getBoolean("isFromFavorites");
    boolean bool1 = bool2;
    if (!bool2)
    {
      String str = this.jdField_a_of_type_AndroidOsBundle.getString("app_name");
      bool1 = bool2;
      if (!TextUtils.isEmpty(str))
      {
        bool1 = bool2;
        if (str.equals(this.jdField_a_of_type_AndroidAppActivity.getString(2131692422))) {
          bool1 = true;
        }
      }
    }
    if (bool1)
    {
      this.jdField_a_of_type_AndroidOsBundle.putBoolean("isBack2Root", true);
      this.jdField_a_of_type_AndroidOsBundle.putString("leftBackText", this.jdField_a_of_type_AndroidAppActivity.getString(2131720570));
      paramIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
    }
    bool2 = this.jdField_a_of_type_AndroidOsBundle.getBoolean("isFromAIOPlus");
    return (bool1) && (bool2);
  }
  
  protected boolean a(bdfq parambdfq)
  {
    return true;
  }
  
  protected boolean a(LightAppSettingInfo paramLightAppSettingInfo)
  {
    boolean bool = true;
    if (paramLightAppSettingInfo == null) {}
    do
    {
      return false;
      paramLightAppSettingInfo = paramLightAppSettingInfo.jdField_a_of_type_JavaUtilArrayList;
    } while ((paramLightAppSettingInfo == null) || (this.jdField_a_of_type_AndroidOsBundle == null));
    switch (this.jdField_a_of_type_AndroidOsBundle.getInt("req_type"))
    {
    default: 
      bool = false;
    }
    for (;;)
    {
      return bool;
      if (!paramLightAppSettingInfo.contains(Integer.valueOf(11005))) {
        break;
      }
      continue;
      if (!paramLightAppSettingInfo.contains(Integer.valueOf(11003))) {
        break;
      }
    }
  }
  
  public boolean a(Integer paramInteger)
  {
    return (this.jdField_a_of_type_JavaUtilSet != null) && (this.jdField_a_of_type_JavaUtilSet.contains(paramInteger));
  }
  
  public boolean a(String paramString)
  {
    HotChatManager localHotChatManager = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60);
    return (localHotChatManager != null) && (localHotChatManager.b(paramString));
  }
  
  protected boolean a(boolean paramBoolean)
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
    this.jdField_a_of_type_AndroidAppActivity.setResult(-1, localIntent);
    if (paramBoolean) {
      this.jdField_a_of_type_AndroidAppActivity.finish();
    }
    return false;
  }
  
  public DeviceInfo[] a(DeviceInfo[] paramArrayOfDeviceInfo)
  {
    return null;
  }
  
  public int b()
  {
    return 2131690797;
  }
  
  protected final DialogInterface.OnClickListener b()
  {
    if (this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener == null) {
      this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener = new arur(this);
    }
    return this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener;
  }
  
  public String b()
  {
    String str2 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("k_forward_title");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = alpo.a(2131705120);
    }
    return str1;
  }
  
  protected List<ResultRecord> b()
  {
    return this.jdField_b_of_type_JavaUtilArrayList;
  }
  
  protected void b()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    this.jdField_a_of_type_Bdfq.setMessageWithEmo(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Float);
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardBaseOption", 2, "-->forwardToDataLine--type = " + paramInt);
    }
    boolean bool1 = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("isJumpAIO", false);
    boolean bool2 = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("forward_source_from_shoot_quick", false);
    boolean bool3 = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("forward_source_from_pre_guide", false);
    if ((bool1) || (bool2) || (bool3))
    {
      if ((bool2) || (bool3))
      {
        this.jdField_a_of_type_AndroidOsBundle.remove("PhotoConst.SEND_FLAG");
        this.jdField_a_of_type_AndroidContentIntent.removeExtra("PhotoConst.SEND_FLAG");
      }
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardBaseOption", 2, "-->forwardToDataLine jumpAIO ");
      }
      c(paramInt);
      return;
    }
    Bundle localBundle = new Bundle();
    String str = aljq.z;
    if (paramInt == k.intValue()) {
      str = aljq.A;
    }
    for (;;)
    {
      localBundle.putAll(this.jdField_a_of_type_AndroidOsBundle);
      Intent localIntent = new Intent();
      aruw localaruw = new aruw(this);
      allz localallz = (allz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8);
      if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("sendMultiple", false))
      {
        a(localIntent);
        localBundle.putAll(localIntent.getExtras());
        paramInt = localallz.a().a(str, localBundle, localaruw);
        a(localBundle, str, null);
        label257:
        if ((f()) || (paramInt != 0)) {
          break label359;
        }
        cx.b(this.jdField_a_of_type_AndroidAppActivity, paramInt);
        this.jdField_a_of_type_AndroidContentIntent.putExtra("NOCANCEL4DATALIN", true);
        if (e() != 100200) {
          break label361;
        }
        this.jdField_a_of_type_AndroidAppActivity.setResult(-1, this.jdField_a_of_type_AndroidContentIntent);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidAppActivity.finish();
        return;
        b(localIntent);
        localBundle.putAll(localIntent.getExtras());
        paramInt = localallz.a().b(str, localBundle, localaruw);
        a(localBundle, str, null);
        break label257;
        label359:
        break;
        label361:
        this.jdField_a_of_type_AndroidAppActivity.setResult(0, this.jdField_a_of_type_AndroidContentIntent);
      }
    }
  }
  
  protected void b(Intent paramIntent) {}
  
  public void b(Bundle paramBundle)
  {
    paramBundle = paramBundle.getBundle("key_forward_base_option_bundle");
    if (paramBundle != null) {
      a(paramBundle.getInt("key_forward_ability_type", aruc.a.intValue()), paramBundle);
    }
  }
  
  protected void b(String paramString) {}
  
  protected final void b(String paramString, bdfq parambdfq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardBaseOption", 2, "updateImageView: filepath=" + paramString);
    }
    ThreadManager.post(new ForwardBaseOption.8(this, paramString, parambdfq), 8, null, false);
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardBaseOption", 2, "updateImageView end! ");
    }
  }
  
  public boolean b()
  {
    return false;
  }
  
  protected boolean b(String paramString1, String paramString2, int paramInt)
  {
    String str = "";
    int i;
    Object localObject;
    if ((this.jdField_a_of_type_Bdfq instanceof bdgl))
    {
      str = ((bdgl)this.jdField_a_of_type_Bdfq).getInputValue();
      if (TextUtils.isEmpty(str)) {
        break label270;
      }
      if (QLog.isColorLevel()) {
        QLog.i("ForwardOption.ForwardBaseOption", 2, "sendMessageOnConfirm: invoked.  textAndEmoji: " + str);
      }
      this.jdField_a_of_type_AndroidOsBundle.putString("share_comment_message", str);
      i = aeyf.a().a();
      if (!f()) {
        break label255;
      }
      int[] arrayOfInt = this.jdField_a_of_type_AndroidOsBundle.getIntArray("KEY_MSG_FORWARD_ID_ARRAY");
      this.jdField_a_of_type_AndroidOsBundle.remove("KEY_MSG_FORWARD_ID_ARRAY");
      if (arrayOfInt == null) {
        break label241;
      }
      localObject = new int[arrayOfInt.length + 1];
      if (arrayOfInt.length > 0) {
        System.arraycopy(arrayOfInt, 0, localObject, 0, arrayOfInt.length);
      }
      localObject[arrayOfInt.length] = i;
      label156:
      this.jdField_a_of_type_AndroidOsBundle.putIntArray("KEY_MSG_FORWARD_ID_ARRAY", (int[])localObject);
    }
    for (;;)
    {
      localObject = new SessionInfo();
      ((SessionInfo)localObject).jdField_a_of_type_Int = paramInt;
      ((SessionInfo)localObject).jdField_a_of_type_JavaLangString = paramString1;
      ((SessionInfo)localObject).jdField_b_of_type_JavaLangString = paramString2;
      if (!(this instanceof arzs)) {
        aeyf.a().a((SessionInfo)localObject, str, i);
      }
      return true;
      if (!(this.jdField_a_of_type_Bdfq instanceof arwl)) {
        break;
      }
      str = ((arwl)this.jdField_a_of_type_Bdfq).getInputValue();
      break;
      label241:
      localObject = new int[1];
      localObject[0] = i;
      break label156;
      label255:
      this.jdField_a_of_type_AndroidOsBundle.putInt("KEY_MSG_FORWARD_ID", i);
    }
    label270:
    return false;
  }
  
  protected int c()
  {
    return this.jdField_a_of_type_AndroidOsBundle.getInt("emoInputType", f());
  }
  
  protected final DialogInterface.OnClickListener c()
  {
    if (this.jdField_c_of_type_AndroidContentDialogInterface$OnClickListener == null) {
      this.jdField_c_of_type_AndroidContentDialogInterface$OnClickListener = new arus(this);
    }
    return this.jdField_c_of_type_AndroidContentDialogInterface$OnClickListener;
  }
  
  public String c()
  {
    int i = this.jdField_a_of_type_AndroidOsBundle.getInt("key_forward_ability_type");
    String str1;
    if (i == jdField_e_of_type_JavaLangInteger.intValue()) {
      str1 = "QQ空间";
    }
    for (;;)
    {
      String str2 = str1;
      if (!TextUtils.isEmpty(str1)) {
        str2 = alpo.a(2131705116) + str1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardBaseOption", 2, "dialogTitle=" + str2);
      }
      return str2;
      if (i == jdField_f_of_type_JavaLangInteger.intValue()) {
        str1 = alpo.a(2131694652);
      } else if (i == k.intValue()) {
        str1 = "我的iPad";
      } else if (i == jdField_g_of_type_JavaLangInteger.intValue()) {
        str1 = alpo.a(2131705111);
      } else if (i == m.intValue()) {
        str1 = ugx.jdField_a_of_type_JavaLangString;
      } else {
        str1 = this.jdField_a_of_type_AndroidOsBundle.getString("uinname");
      }
    }
  }
  
  public void c()
  {
    azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005A0F", "0X8005A0F", 0, 0, "0", "", "", "");
  }
  
  protected void c(int paramInt)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, LiteActivity.class);
    if (paramInt == k.intValue())
    {
      localIntent.putExtra("targetUin", aljq.A);
      localIntent.putExtra("device_type", 1);
      if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("isFromShare", false))
      {
        this.jdField_a_of_type_AndroidOsBundle.putString("leftBackText", alpo.a(2131705110));
        localIntent.addFlags(268435456);
        localIntent.addFlags(67108864);
        this.jdField_a_of_type_AndroidOsBundle.putBoolean("isBack2Root", true);
      }
      localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
      localIntent.putExtra("MigSdkShareNotDone", false);
      if (!this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("sendMultiple", false)) {
        break label207;
      }
      a(localIntent);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
      this.jdField_a_of_type_AndroidOsBundle.putBoolean("isBack2Root", false);
      localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
      this.jdField_a_of_type_AndroidAppActivity.setResult(0, localIntent);
      this.jdField_a_of_type_AndroidAppActivity.finish();
      return;
      localIntent.putExtra("targetUin", aljq.z);
      localIntent.putExtra("device_type", 0);
      break;
      label207:
      b(localIntent);
    }
  }
  
  protected void c(String paramString)
  {
    Object localObject1 = (zpa)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
    Object localObject2 = ((zpa)localObject1).a(Long.parseLong(paramString));
    ((zpa)localObject1).a(this.jdField_a_of_type_AndroidAppActivity, (DeviceInfo)localObject2, false);
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("sendMultiple", false)) {
      localObject1 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("forward_filepath");
    }
    for (;;)
    {
      localObject2 = (RouterHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(48);
      ArrayList localArrayList = new ArrayList();
      try
      {
        localArrayList.add(new FileInfo((String)localObject1));
        label93:
        ((RouterHandler)localObject2).a(localArrayList, null, null, Long.parseLong(paramString));
        return;
        localObject1 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("forward_filepath");
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        break label93;
      }
    }
  }
  
  protected boolean c()
  {
    if (f()) {
      return a(false);
    }
    return a(true);
  }
  
  protected int d()
  {
    return -1;
  }
  
  protected String d()
  {
    int i = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype", 0);
    int j = this.jdField_a_of_type_AndroidOsBundle.getInt("key_forward_ability_type");
    if (a(i)) {
      return alpo.a(2131705114);
    }
    if ((j == jdField_f_of_type_JavaLangInteger.intValue()) || (j == k.intValue())) {
      return alpo.a(2131705119);
    }
    return "";
  }
  
  protected void d()
  {
    int i = 0;
    if (f())
    {
      List localList = b();
      if ((localList != null) && (!localList.isEmpty()))
      {
        int j = localList.size();
        while (i < j)
        {
          ResultRecord localResultRecord = (ResultRecord)localList.get(i);
          if (g()) {
            b(localResultRecord.jdField_a_of_type_JavaLangString, localResultRecord.jdField_c_of_type_JavaLangString, localResultRecord.a());
          }
          i += 1;
        }
        this.jdField_a_of_type_AndroidOsBundle.putBoolean("isBack2Root", true);
        c();
      }
      return;
    }
    E();
    if (this.jdField_d_of_type_Boolean)
    {
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005793", "0X8005793", 0, 0, "", "", "", "");
      this.jdField_d_of_type_Boolean = false;
    }
    if (g()) {
      q();
    }
    v();
  }
  
  protected void d(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardBaseOption", 2, "-->showQfavResultDialog--code = " + paramInt);
    }
    if ((this.jdField_a_of_type_Bdfq != null) && (this.jdField_a_of_type_Bdfq.isShowing())) {
      this.jdField_a_of_type_Bdfq.dismiss();
    }
    x();
    aruo localaruo = new aruo(this);
    if (this.jdField_a_of_type_Zcs == null) {
      this.jdField_a_of_type_Zcs = new zcs(this.jdField_a_of_type_AndroidAppActivity);
    }
    for (;;)
    {
      String str = this.jdField_a_of_type_AndroidAppActivity.getString(2131690623);
      Object localObject = str;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_AndroidOsBundle.getString("app_name"))) {
        localObject = str + this.jdField_a_of_type_AndroidOsBundle.getString("app_name");
      }
      this.jdField_a_of_type_Zcs.a((String)localObject, localaruo);
      this.jdField_a_of_type_Zcs.a(2131692306);
      localObject = this.jdField_a_of_type_Zcs;
      boolean bool;
      if (paramInt == 0)
      {
        bool = true;
        ((zcs)localObject).a(bool);
        this.jdField_a_of_type_Zcs.a(2131720041);
        this.jdField_a_of_type_Zcs.b(0);
        this.jdField_a_of_type_Zcs.c(2131720042);
        this.jdField_a_of_type_Zcs.b(this.jdField_a_of_type_AndroidAppActivity.getString(2131695052), localaruo);
      }
      try
      {
        this.jdField_a_of_type_Zcs.show();
        return;
        this.jdField_a_of_type_Zcs.dismiss();
        continue;
        bool = false;
      }
      catch (Exception localException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("ForwardOption.ForwardBaseOption", 2, "-->showQfavResultDialog--resultDlg.show() failed");
      }
    }
  }
  
  public void d(String paramString)
  {
    if (!this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("key_forward_share", false)) {}
    String str;
    int i;
    do
    {
      return;
      str = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("key_forward_share_title");
      i = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("key_forward_image_share_uin_type", 0);
      azmj.b(null, "dc00898", "", "", "0X800A631", "0X800A631", 0, 0, paramString, ForwardUtils.b(i), str, "");
    } while (!QLog.isColorLevel());
    QLog.d("ForwardOption.ForwardBaseOption", 2, new Object[] { "图文或者音乐转发=0X800A631, type=", paramString, ", title=", str, ", uinType=", ForwardUtils.b(i) });
  }
  
  public int e()
  {
    return a(this.jdField_a_of_type_AndroidOsBundle);
  }
  
  protected boolean e()
  {
    if ((this.jdField_a_of_type_Bdfq != null) && (this.jdField_a_of_type_Bdfq.isShowing())) {
      return false;
    }
    if ((this.jdField_a_of_type_Zcs != null) && (this.jdField_a_of_type_Zcs.isShowing())) {
      this.jdField_a_of_type_Zcs.dismiss();
    }
    x();
    return true;
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_AndroidOsBundle != null) && (this.jdField_a_of_type_AndroidOsBundle.getBoolean("k_forward_show_direct_share_tips", false))) {
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A220", "0X800A220", 0, 0, "0", "", "", "");
    }
    B();
  }
  
  protected boolean f()
  {
    List localList = a();
    return (localList != null) && (!localList.isEmpty());
  }
  
  public void g() {}
  
  protected boolean g()
  {
    return true;
  }
  
  public void h()
  {
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    a();
  }
  
  protected boolean h()
  {
    return false;
  }
  
  protected void i()
  {
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("k_favorites", true)) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_g_of_type_JavaLangInteger);
    }
  }
  
  public boolean i()
  {
    return true;
  }
  
  public void j()
  {
    if ((this.jdField_a_of_type_Bdfq instanceof bdfh)) {
      ((bdfh)this.jdField_a_of_type_Bdfq).a(0);
    }
  }
  
  protected boolean j()
  {
    aubm localaubm = (aubm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
    if ((localaubm != null) && (localaubm.c())) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardBaseOption", 2, "-->allowPhoneContactAbility--allow = " + bool);
      }
      return bool;
    }
  }
  
  public void k()
  {
    if ((this.jdField_a_of_type_Bdfq instanceof bdfh)) {
      ((bdfh)this.jdField_a_of_type_Bdfq).a(1);
    }
    if ((this.jdField_a_of_type_Bepp != null) && (this.jdField_a_of_type_Bepp.isShowing())) {
      this.jdField_a_of_type_Bepp.dismiss();
    }
  }
  
  protected boolean k()
  {
    Object localObject = (almv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53);
    if (localObject != null)
    {
      localObject = ((almv)localObject).a();
      if ((localObject == null) || (((ArrayList)localObject).size() <= 0)) {}
    }
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardBaseOption", 2, "-->allowDiscussAbility--allow = " + bool);
      }
      return bool;
    }
  }
  
  @TargetApi(11)
  public final void l()
  {
    if (h())
    {
      K();
      return;
    }
    G();
    int i = c();
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardBaseOption", 2, "-->buildConfirmDialog--editTextType = " + i);
    }
    if (i == 0)
    {
      i = this.jdField_a_of_type_AndroidOsBundle.getInt("forward_type");
      if ((i == 27) || (i == 39))
      {
        this.jdField_a_of_type_Bdfq = bdcd.a(this.jdField_a_of_type_AndroidAppActivity, c(), this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_AndroidAppActivity.getResources().getInteger(2131427338));
        this.jdField_a_of_type_Bdfq.setMessage("");
        this.jdField_a_of_type_Bdfq.setNegativeButton(2131690648, b());
        this.jdField_a_of_type_Bdfq.setPositiveButton(2131690797, a());
        this.jdField_a_of_type_Bdfq.show();
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Bdfq instanceof bdgv)) {
        a((bdgv)this.jdField_a_of_type_Bdfq);
      }
      Object localObject1 = d();
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        this.jdField_a_of_type_Bdfq.setEditLint((String)localObject1);
      }
      if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("miniAppNeedOnlyPreview", false))
      {
        ((bdfh)this.jdField_a_of_type_Bdfq).a(c());
        ((bdfh)this.jdField_a_of_type_Bdfq).a();
      }
      this.jdField_a_of_type_Bdfq.setOnDismissListener(this);
      this.jdField_a_of_type_Bdfq.adjustTitle();
      b();
      this.jdField_a_of_type_Bdfq.setMsgMaxLineWithEnd(this.jdField_a_of_type_JavaLangString, 3);
      if (a(this.jdField_a_of_type_Bdfq)) {
        b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Bdfq);
      }
      if (this.jdField_a_of_type_AndroidOsBundle.getInt(jdField_e_of_type_JavaLangString, 0) == 1) {
        this.jdField_a_of_type_Bdfq.setPreviewImageScaleType(true);
      }
      if (this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
        break;
      }
      this.jdField_a_of_type_Bdfq.show();
      return;
      this.jdField_a_of_type_Bdfq = bdcd.a(this.jdField_a_of_type_AndroidAppActivity, c(), a(), d(), a(), b(), a(), b());
      continue;
      if (i == 1)
      {
        m();
        if ((this.jdField_a_of_type_AndroidOsBundle.getBoolean("is_ark_display_share")) && (this.jdField_a_of_type_AndroidOsBundle.getBoolean("forward_ark_from_h5_parse_meta_success")))
        {
          this.jdField_a_of_type_Bdfq = bdcd.a(this.jdField_a_of_type_AndroidAppActivity, c(), this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_AndroidAppActivity.getResources().getInteger(2131427338));
          this.jdField_a_of_type_Bdfq.setMessage("");
          this.jdField_a_of_type_Bdfq.setNegativeButton(2131690648, b());
          this.jdField_a_of_type_Bdfq.setPositiveButton(2131690797, a());
          this.jdField_a_of_type_Bdfq.show();
          continue;
        }
        this.jdField_a_of_type_Bdfq = bdcd.a(this.jdField_a_of_type_AndroidAppActivity, c(), a(), null, a(), b());
        continue;
      }
      if (i == 2)
      {
        i = this.jdField_a_of_type_AndroidOsBundle.getInt("req_type");
        if ((this.jdField_a_of_type_AndroidOsBundle.getBoolean("is_ark_display_share", false)) && (i != 5))
        {
          this.jdField_a_of_type_Bdfq = bdcd.a(this.jdField_a_of_type_AndroidAppActivity, c(), this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_AndroidAppActivity.getResources().getInteger(2131427338));
          localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("shareArkInfo");
          if (TextUtils.isEmpty((CharSequence)localObject1)) {}
        }
      }
      try
      {
        Object localObject3 = new JSONObject((String)localObject1);
        localObject1 = ((JSONObject)localObject3).optString("app");
        Object localObject2 = ((JSONObject)localObject3).optString("view");
        localObject3 = ((JSONObject)localObject3).optString("meta");
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty((CharSequence)localObject3))) {
          anjv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, "AIOArkSdkSelectSend", 1, 0, 0L, 0L, 0L, (String)localObject2, "");
        }
        label690:
        this.jdField_a_of_type_Bdfq.setMessage("");
        this.jdField_a_of_type_Bdfq.setNegativeButton(2131690648, b());
        this.jdField_a_of_type_Bdfq.setPositiveButton(2131690797, a());
        this.jdField_a_of_type_Bdfq.show();
        continue;
        this.jdField_a_of_type_Bdfq = bdcd.a(this.jdField_a_of_type_AndroidAppActivity, c(), a(), null, a(), b(), this.jdField_a_of_type_AndroidAppActivity.getResources().getInteger(2131427338));
        i = this.jdField_a_of_type_AndroidOsBundle.getInt("key_forward_ability_type");
        boolean bool = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("forward_ability_entrence_show_in_share", false);
        if ((i != jdField_e_of_type_JavaLangInteger.intValue()) || (!bool)) {
          continue;
        }
        localObject1 = (bdgl)this.jdField_a_of_type_Bdfq;
        ((bdgl)localObject1).b();
        ((bdgl)localObject1).getEditText().setHint(alpo.a(2131705112));
        continue;
        if (i == 3)
        {
          this.jdField_a_of_type_Bdfq = bdcd.a(this.jdField_a_of_type_AndroidAppActivity, c(), a(), null, a(), b(), this.jdField_a_of_type_AndroidAppActivity.getResources().getInteger(2131427338), false);
          continue;
        }
        if (i == 4)
        {
          localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("choose_friend_content");
          localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("choose_friend_subcontent");
          localObject3 = this.jdField_a_of_type_AndroidOsBundle.getStringArrayList("choose_friend_feedbacks");
          this.jdField_a_of_type_Bdfq = bdcd.a(this.jdField_a_of_type_AndroidAppActivity, c(), (String)localObject1, (String)localObject2, (ArrayList)localObject3, null, a(), b(), this.jdField_a_of_type_AndroidAppActivity.getResources().getInteger(2131427338), false);
          continue;
        }
        if (i == 5)
        {
          i = this.jdField_a_of_type_AndroidOsBundle.getInt("key_hiboom_id");
          this.jdField_a_of_type_Bdfq = bdcd.a(this.jdField_a_of_type_AndroidAppActivity, c(), "", null, a(), b(), this.jdField_a_of_type_AndroidAppActivity.getResources().getInteger(2131427338), false);
          localObject1 = new HiBoomTextView(this.jdField_a_of_type_AndroidAppActivity);
          ((HiBoomTextView)localObject1).setHiBoom(i, 0, asnx.jdField_a_of_type_Asnq);
          ((HiBoomTextView)localObject1).setText(this.jdField_a_of_type_JavaLangString);
          ((HiBoomTextView)localObject1).setMaxSize(asnx.jdField_a_of_type_Int);
          localObject2 = new LinearLayout.LayoutParams(500, 500);
          ((LinearLayout.LayoutParams)localObject2).gravity = 17;
          this.jdField_a_of_type_Bdfq.addView((View)localObject1, (LinearLayout.LayoutParams)localObject2);
          continue;
        }
        this.jdField_a_of_type_Bdfq = bdcd.a(this.jdField_a_of_type_AndroidAppActivity, c(), a(), null, a(), b(), this.jdField_a_of_type_AndroidAppActivity.getResources().getInteger(2131427338), false);
      }
      catch (JSONException localJSONException)
      {
        break label690;
      }
    }
  }
  
  protected boolean l()
  {
    Object localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    if (localObject != null)
    {
      localObject = ((TroopManager)localObject).a();
      if ((localObject == null) || (((ArrayList)localObject).size() <= 0)) {}
    }
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardBaseOption", 2, "-->allowTroopAbility--allow = " + bool);
      }
      return bool;
    }
  }
  
  public void m()
  {
    boolean bool = true;
    String str = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_meta");
    if (!TextUtils.isEmpty(str)) {}
    for (;;)
    {
      try
      {
        new JSONObject(str);
        this.jdField_a_of_type_AndroidOsBundle.putBoolean("forward_ark_from_h5_parse_meta_success", bool);
        return;
      }
      catch (Exception localException)
      {
        ArkAppCenter.c("ForwardOption.ForwardBaseOption", String.format("CheckMetaLegality,appMeta is parse error and msg=%s", new Object[] { localException.getMessage() }));
        bool = false;
        continue;
      }
      bool = false;
    }
  }
  
  protected boolean m()
  {
    Object localObject = (aloz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    if (localObject != null)
    {
      localObject = ((aloz)localObject).e();
      if (localObject != null)
      {
        localObject = ((ArrayList)localObject).iterator();
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
        } while (((Groups)((Iterator)localObject).next()).group_friend_count <= 0);
      }
    }
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardBaseOption", 2, "-->allowFriendAbility--allow = " + bool);
      }
      return bool;
    }
  }
  
  protected void n() {}
  
  protected boolean n()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardBaseOption", 2, "-->allowQZoneAbility--allow = false");
    }
    return false;
  }
  
  protected void o() {}
  
  protected boolean o()
  {
    boolean bool2 = false;
    boolean bool1 = false;
    boolean bool3 = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("sendMultiple", false);
    int i;
    if (aukx.a().c() > 1)
    {
      i = 1;
      int j = this.jdField_a_of_type_AndroidOsBundle.getInt("from_busi_type");
      if ((!bool3) && (i == 0) && (j != 2)) {
        break label84;
      }
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("ForwardOption.ForwardBaseOption", 2, "-->allowSmartDeviceAbility--allow = false");
        bool2 = bool1;
      }
    }
    label84:
    do
    {
      return bool2;
      i = 0;
      break;
      Object localObject = (zpa)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
      bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (((zpa)localObject).a())
        {
          localObject = ((zpa)localObject).a();
          bool1 = bool2;
          if (localObject != null)
          {
            bool1 = bool2;
            if (localObject.length > 0) {
              bool1 = true;
            }
          }
        }
      }
      bool2 = bool1;
    } while (!QLog.isColorLevel());
    QLog.d("ForwardOption.ForwardBaseOption", 2, "-->allowSmartDeviceAbility--allow = " + bool1);
    return bool1;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    int j = 0;
    int i;
    if ((!(this.jdField_a_of_type_AndroidAppActivity instanceof DirectForwardActivity)) && ((this.jdField_a_of_type_AndroidAppActivity.getIntent() == null) || (!this.jdField_a_of_type_AndroidAppActivity.getIntent().getBooleanExtra("key_share_from_screen_need_finish", false))))
    {
      i = j;
      if (this.jdField_a_of_type_AndroidAppActivity.getIntent() != null)
      {
        i = j;
        if (this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("key_req", -1) != ForwardRecentActivity.f) {}
      }
    }
    else
    {
      i = 1;
    }
    if (i != 0) {
      this.jdField_a_of_type_AndroidAppActivity.finish();
    }
    if ((this.jdField_a_of_type_Bdfq instanceof bdfh)) {
      QLog.d("ForwardOption.ForwardBaseOption", 1, "QQCustomArkDialog dismiss");
    }
  }
  
  public void p()
  {
    d();
  }
  
  public boolean p()
  {
    if (this.jdField_a_of_type_AndroidContentIntent == null) {}
    int i;
    do
    {
      return false;
      i = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("key_req", -1);
    } while ((i != ForwardRecentActivity.f) && (i != ForwardRecentActivity.g));
    return true;
  }
  
  protected void q()
  {
    int i = 1;
    String str1 = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
    String str2 = this.jdField_a_of_type_AndroidOsBundle.getString("troop_uin");
    int j = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
    if (b(str1, str2, j)) {
      if (j != 0) {
        break label80;
      }
    }
    for (;;)
    {
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8009AAE", "0X8009AAE", i, 0, "", "", "", "");
      return;
      label80:
      if (j == 1) {
        i = 2;
      } else if (j == 3000) {
        i = 3;
      } else {
        i = 0;
      }
    }
  }
  
  protected void r()
  {
    this.jdField_d_of_type_Boolean = false;
    if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("miniAppNeedOnlyPreview", false)) {
      QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_direct_share_fail", null, null);
    }
  }
  
  public void s() {}
  
  protected void t()
  {
    this.jdField_a_of_type_Bdfq.setImageOnClickListener(a(new aruv(this)));
  }
  
  public void u()
  {
    int i = d();
    if (this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
      return;
    }
    d(i);
  }
  
  protected void v()
  {
    this.jdField_a_of_type_AndroidOsBundle.putBoolean("isBack2Root", true);
    if (this.jdField_a_of_type_AndroidOsBundle.getInt("uintype") == 6002) {
      c(this.jdField_a_of_type_AndroidOsBundle.getString("uin"));
    }
    while (c()) {
      return;
    }
    azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004047", "0X8004047", 0, 0, "", "", "", "");
  }
  
  public void w()
  {
    if ((this.jdField_a_of_type_Bdfq != null) && (this.jdField_a_of_type_Bdfq.isShowing())) {
      this.jdField_a_of_type_Bdfq.dismiss();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Almw);
  }
  
  public void x()
  {
    if ((this.jdField_b_of_type_Bepp != null) && (this.jdField_b_of_type_Bepp.isShowing())) {
      this.jdField_b_of_type_Bepp.dismiss();
    }
  }
  
  protected void y() {}
  
  protected void z() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arum
 * JD-Core Version:    0.7.0.1
 */