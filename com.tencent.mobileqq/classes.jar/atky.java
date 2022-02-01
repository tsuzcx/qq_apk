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
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.utils.LightAppSettingInfo;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.AppConstants;
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
import com.tencent.mobileqq.forward.ForwardBaseOption.12;
import com.tencent.mobileqq.forward.ForwardBaseOption.13;
import com.tencent.mobileqq.forward.ForwardBaseOption.3;
import com.tencent.mobileqq.forward.ForwardBaseOption.4;
import com.tencent.mobileqq.forward.ForwardBaseOption.5;
import com.tencent.mobileqq.forward.ForwardChooseFriendOption;
import com.tencent.mobileqq.forward.ForwardFileOption;
import com.tencent.mobileqq.forward.ForwardSendHongBaoOption;
import com.tencent.mobileqq.forward.ForwardShareCardOption;
import com.tencent.mobileqq.hiboom.HiBoomTextView;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.RegionalThumbDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.QQCustomArkDialog;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQCustomDialogWtihEmoticonInput;
import com.tencent.mobileqq.utils.QQCustomDialogWtihForwardAvatar;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class atky
  implements DialogInterface.OnDismissListener, atkt, atku, atlp
{
  protected static int a;
  static SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat;
  public static String e;
  protected float a;
  protected long a;
  private aael jdField_a_of_type_Aael;
  protected aaeo a;
  amrc jdField_a_of_type_Amrc = new atlg(this);
  public Activity a;
  public Context a;
  DialogInterface.OnClickListener jdField_a_of_type_AndroidContentDialogInterface$OnClickListener;
  protected Intent a;
  public Bundle a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  protected bhht a;
  public QQAppInterface a;
  public QQCustomDialog a;
  protected String a;
  protected ArrayList<ResultRecord> a;
  protected Set<Integer> a;
  public boolean a;
  private boolean[] jdField_a_of_type_ArrayOfBoolean;
  protected int b;
  DialogInterface.OnClickListener jdField_b_of_type_AndroidContentDialogInterface$OnClickListener;
  protected bhht b;
  protected String b;
  private ArrayList<ResultRecord> jdField_b_of_type_JavaUtilArrayList;
  protected boolean b;
  protected int c;
  DialogInterface.OnClickListener jdField_c_of_type_AndroidContentDialogInterface$OnClickListener;
  private bhht jdField_c_of_type_Bhht;
  String jdField_c_of_type_JavaLangString;
  private ArrayList<ResultRecord> jdField_c_of_type_JavaUtilArrayList;
  protected boolean c;
  protected int d;
  String d;
  public boolean d;
  protected boolean e;
  protected String f;
  protected boolean f;
  protected boolean g;
  protected boolean h;
  
  static
  {
    jdField_e_of_type_JavaLangString = "key_thumb_style_centerinside";
  }
  
  public atky(Intent paramIntent)
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
  
  private void I()
  {
    n();
    if ((this.jdField_a_of_type_AndroidOsBundle.getBoolean("is_ark_display_share")) && (this.jdField_a_of_type_AndroidOsBundle.getBoolean("forward_ark_from_h5_parse_meta_success")))
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = bfur.a(this.jdField_a_of_type_AndroidAppActivity, c(), this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_AndroidAppActivity.getResources().getInteger(2131427338));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage("");
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131690620, b());
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131690709, a());
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = bfur.a(this.jdField_a_of_type_AndroidAppActivity, c(), a(), null, a(), b());
  }
  
  private void J()
  {
    int i = this.jdField_a_of_type_AndroidOsBundle.getInt("forward_type");
    if ((i == 27) || (i == 39) || (i == 46))
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = bfur.a(this.jdField_a_of_type_AndroidAppActivity, c(), this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_AndroidAppActivity.getResources().getInteger(2131427338));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage("");
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131690620, b());
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131690709, a());
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = bfur.a(this.jdField_a_of_type_AndroidAppActivity, c(), a(), d(), a(), b(), a(), b());
  }
  
  private void K()
  {
    int i = this.jdField_a_of_type_AndroidOsBundle.getInt("key_forward_ability_type");
    if ((i == jdField_g_of_type_JavaLangInteger.intValue()) || (i == j.intValue()) || (i == m.intValue()) || (i == jdField_e_of_type_JavaLangInteger.intValue())) {
      this.jdField_a_of_type_AndroidOsBundle.putBoolean("is_ark_display_share", false);
    }
  }
  
  private void L()
  {
    if ((this.jdField_a_of_type_AndroidAppActivity == null) || (this.jdField_a_of_type_AndroidAppActivity.isFinishing()))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ForwardOption.ForwardBaseOption", 2, " qbShowShareResultDialog error mActivity = null");
      }
      return;
    }
    if (this.jdField_a_of_type_Aael == null) {
      this.jdField_a_of_type_Aael = new aael(this.jdField_a_of_type_AndroidAppActivity);
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131718238);
    String str = this.jdField_a_of_type_AndroidOsBundle.getString("app_name");
    Object localObject1 = localObject2;
    if (str != null) {
      localObject1 = (String)localObject2 + str;
    }
    localObject2 = new atkz(this);
    this.jdField_a_of_type_Aael.a((String)localObject1, (DialogInterface.OnClickListener)localObject2);
    this.jdField_a_of_type_Aael.a((DialogInterface.OnClickListener)localObject2);
    this.jdField_a_of_type_Aael.show();
  }
  
  private void M()
  {
    if ((this.jdField_c_of_type_JavaUtilArrayList != null) && (!this.jdField_c_of_type_JavaUtilArrayList.isEmpty()))
    {
      Iterator localIterator = this.jdField_c_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        ResultRecord localResultRecord = (ResultRecord)localIterator.next();
        if (localResultRecord.uinType == 6000) {
          b(jdField_f_of_type_JavaLangInteger.intValue());
        } else if (localResultRecord.uinType == 6003) {
          b(k.intValue());
        }
      }
      if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
      {
        this.jdField_a_of_type_AndroidContentIntent.putExtra("NOCANCEL4DATALIN", true);
        this.jdField_a_of_type_AndroidAppActivity.setResult(0, this.jdField_a_of_type_AndroidContentIntent);
        this.jdField_a_of_type_AndroidAppActivity.finish();
      }
      this.jdField_a_of_type_AndroidOsBundle.putParcelableArrayList("forward_multi_target", this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_AndroidContentIntent.putParcelableArrayListExtra("forward_multi_target", this.jdField_a_of_type_JavaUtilArrayList);
    }
    d();
    if (this.jdField_c_of_type_Boolean) {}
    do
    {
      return;
      if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("system_share", false))
      {
        ForwardUtils.jumpToMainFragment4Local(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidOsBundle);
        return;
      }
      if ((this.jdField_g_of_type_Boolean) && (!this.jdField_h_of_type_Boolean))
      {
        ThreadManager.getUIHandler().postDelayed(new ForwardBaseOption.3(this), 500L);
        return;
      }
      this.jdField_a_of_type_AndroidAppActivity.finish();
    } while (!this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("is_need_show_toast", true));
    ThreadManager.getUIHandler().postDelayed(new ForwardBaseOption.4(this), 500L);
  }
  
  private void N()
  {
    if (this.jdField_a_of_type_AndroidOsBundle != null) {}
    for (boolean bool = this.jdField_a_of_type_AndroidOsBundle.getBoolean("from_card", false);; bool = false)
    {
      Object localObject2;
      Object localObject1;
      if (bool)
      {
        localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("pubUin");
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        odq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", (String)localObject1, "0X8005A2C", "0X8005A2C", 0, 0, "", "", "", "", false);
      }
      int i;
      if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("forward_source_from_shoot_quick", false))
      {
        i = this.jdField_a_of_type_AndroidOsBundle.getInt("forward_type");
        localObject1 = "";
        if (i != 21) {
          break label415;
        }
        localObject1 = "0X800780B";
      }
      for (;;)
      {
        bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", (String)localObject1, (String)localObject1, 0, 0, "", "", "", "");
        if ((this.jdField_a_of_type_AndroidOsBundle != null) && (this.jdField_a_of_type_AndroidOsBundle.getBoolean("forward_report_confirm")))
        {
          localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_report_confirm_action_name");
          String str = this.jdField_a_of_type_AndroidOsBundle.getString("forward_report_confirm_reverse2");
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localObject2 = str;
          if (str == null) {
            localObject2 = "";
          }
          bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", (String)localObject1, (String)localObject1, 0, 0, (String)localObject2, "", "", "");
        }
        if (this.jdField_c_of_type_Boolean) {
          bhvw.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "", String.valueOf(this.jdField_a_of_type_Long), "1000", "50", "0", false);
        }
        if ((this.jdField_a_of_type_AndroidOsBundle != null) && (this.jdField_a_of_type_AndroidOsBundle.getInt("extra_key_from_apollo") > 0)) {
          VipUtils.a(null, "cmshow", "Apollo", "QQSend", 0, 0, new String[0]);
        }
        if ((this.jdField_a_of_type_AndroidOsBundle != null) && (this.jdField_a_of_type_AndroidOsBundle.getBoolean("KEY_FROM_OCR", false))) {
          bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009C8E", "0X8009C8E", 0, 0, "", "", "", "");
        }
        if ((this.jdField_a_of_type_AndroidOsBundle != null) && (this.jdField_a_of_type_AndroidOsBundle.getBoolean("KEY_FROM_TRANSLATE", false))) {
          bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009C85", "0X8009C85", 0, 0, "", "", "", "");
        }
        return;
        label415:
        if (i == 1) {
          localObject1 = "0X8007811";
        }
      }
    }
  }
  
  private void O()
  {
    int i = -1;
    if (i())
    {
      localObject = a().iterator();
      while (((Iterator)localObject).hasNext())
      {
        ResultRecord localResultRecord = (ResultRecord)((Iterator)localObject).next();
        a(localResultRecord.uin, localResultRecord.getUinType());
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
  
  private void P()
  {
    Bundle localBundle = new Bundle();
    if (i())
    {
      Iterator localIterator = a().iterator();
      while (localIterator.hasNext())
      {
        localBundle.putLong("key_receiver_type", ((ResultRecord)localIterator.next()).getUinType());
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
  
  private void Q()
  {
    if (this.jdField_c_of_type_Bhht == null)
    {
      this.jdField_c_of_type_Bhht = new bhht(this.jdField_a_of_type_AndroidAppActivity, 0, 2131561246, 17);
      this.jdField_c_of_type_Bhht.setContentView(2131562728);
      this.jdField_c_of_type_Bhht.a("正在发送");
      this.jdField_c_of_type_Bhht.setCancelable(true);
    }
    if (this.jdField_c_of_type_Bhht.isShowing()) {
      this.jdField_c_of_type_Bhht.dismiss();
    }
    this.jdField_c_of_type_Bhht.show();
  }
  
  private void R()
  {
    if ((this.jdField_c_of_type_Bhht != null) && (this.jdField_c_of_type_Bhht.isShowing())) {
      this.jdField_c_of_type_Bhht.dismiss();
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
  
  private Drawable a()
  {
    if ((this.jdField_d_of_type_JavaLangString != null) && (AbsDownloader.hasFile(this.jdField_d_of_type_JavaLangString))) {}
    for (Object localObject1 = this.jdField_d_of_type_JavaLangString; localObject1 != null; localObject1 = this.jdField_c_of_type_JavaLangString)
    {
      Object localObject2 = a((String)localObject1, "file:");
      Object localObject3 = localObject1;
      if (localObject2 != null)
      {
        localObject3 = localObject1;
        if (((File)localObject2).exists())
        {
          localObject3 = ((File)localObject2).getAbsolutePath();
          this.jdField_a_of_type_AndroidOsBundle.putString("EditImagePath", (String)localObject3);
          localObject2 = RegionalThumbDownloader.generateURLForNew((String)localObject3, ScreenUtil.dip2px(100.0F), ScreenUtil.dip2px(300.0F));
          if (localObject2 != null) {
            localObject1 = ((URL)localObject2).toString();
          }
          localObject2 = localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            localObject2 = localObject3;
          }
          localObject3 = localObject2;
          if (QLog.isColorLevel())
          {
            QLog.e("ForwardOption.ForwardBaseOption", 2, "getURLDrawable updateImageView  fixedUrlString=" + (String)localObject2);
            localObject3 = localObject2;
          }
        }
      }
      try
      {
        localObject1 = URLDrawable.getDrawable((String)localObject3);
        return localObject1;
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          break label204;
        }
        QLog.d("ForwardOption.ForwardBaseOption", 2, "getURLDrawable fixedUrlString url is illegal = " + localException);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e("ForwardOption.ForwardBaseOption", 2, "getURLDrawable isURLDrawablFoward is true, but mBigURLDrawableUrl and URLDrawableUrl are null");
    }
    return null;
    label204:
    return null;
  }
  
  private Drawable a(String paramString)
  {
    Object localObject2 = null;
    Object localObject3 = null;
    String str = "";
    if (paramString == null) {
      localObject1 = localObject3;
    }
    URL localURL;
    do
    {
      do
      {
        return localObject1;
        localURL = RegionalThumbDownloader.generateURLForNew(paramString, ScreenUtil.dip2px(100.0F), ScreenUtil.dip2px(300.0F));
        localObject1 = localObject3;
      } while (localURL == null);
      localObject1 = localObject3;
    } while (!AbsDownloader.hasFile(localURL.toString()));
    Object localObject1 = str;
    if (localURL != null) {
      localObject1 = localURL.toString();
    }
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject1 = paramString;
    }
    for (;;)
    {
      paramString = localObject2;
      try
      {
        localObject1 = URLDrawable.getDrawable((String)localObject1);
        paramString = (String)localObject1;
        URLDrawableHelper.decodeLocalImage((URLDrawable)localObject1, null, false);
        return localObject1;
      }
      catch (Exception localException)
      {
        localObject1 = paramString;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ForwardOption.ForwardBaseOption", 2, "getNormalDrawable urlString url is illegal = " + localException);
      return paramString;
    }
  }
  
  private File a(String paramString1, String paramString2)
  {
    if (paramString1.toLowerCase(Locale.US).startsWith(paramString2)) {}
    for (;;)
    {
      try
      {
        if (!paramString1.substring(0, paramString2.length()).equalsIgnoreCase(paramString2)) {
          break label111;
        }
        paramString1 = new File(paramString1.substring(paramString2.length()));
        boolean bool1 = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("forward_source_from_shoot_quick", false);
        boolean bool2 = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("forward_source_from_pre_guide", false);
        if ((bool1) || (bool2)) {
          paramString1 = new File(this.jdField_c_of_type_JavaLangString);
        }
        return paramString1;
      }
      catch (IndexOutOfBoundsException paramString1)
      {
        paramString1 = null;
        continue;
      }
      paramString1 = AbsDownloader.getFile(AbsDownloader.covertUrlForAioImage(paramString1));
      continue;
      label111:
      paramString1 = null;
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
      bcef.b(null, "dc00899", str, "", "video_tab", "videoark_share", 0, 0, paramString, paramBundle, "", "");
      return;
      paramBundle = l + "";
      break;
      bool = false;
      break label88;
    }
  }
  
  private void a(AIOImageData paramAIOImageData, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardBaseOption", 2, "getImageEditListener from AIOImageData");
    }
    if ((paramAIOImageData.a(4)) && (paramAIOImageData.a(4) != null)) {
      a(paramAIOImageData, paramString);
    }
    do
    {
      return;
      if ((paramAIOImageData.a(2)) && (paramAIOImageData.a(2) != null))
      {
        a(paramAIOImageData, paramString);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ForwardOption.ForwardBaseOption", 2, "Edit Forward Image: image does not exist");
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
        paramString = new AIOImageProviderService(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), paramString, 0, null);
        localObject = new Bundle();
        ((Bundle)localObject).putBoolean("extra.EXTRA_NOT_CLEAR_TOP", true);
        a((Bundle)localObject, paramString, paramAIORichMediaData);
        F();
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
        paramString = new AIOImageProviderService(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), paramString, 0, paramMessageForPic);
        localObject = new Bundle();
        ((Bundle)localObject).putBoolean("extra.EXTRA_NOT_CLEAR_TOP", true);
        a((Bundle)localObject, paramString, agzl.a(paramMessageForPic));
        F();
      }
      return;
    }
  }
  
  private void a(MessageForPic paramMessageForPic, String paramString, atlm paramatlm)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardBaseOption", 2, "getImageEditListener from MessageForPic");
    }
    paramatlm = new File(paramMessageForPic.path);
    if ((paramatlm != null) && (paramatlm.exists()) && (paramatlm.length() == paramMessageForPic.size)) {}
    a(paramMessageForPic, paramString);
  }
  
  private void a(String paramString, int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidContentIntent != null) && (("ChatActivity".equals(this.jdField_a_of_type_AndroidContentIntent.getStringExtra("caller_name"))) || ("SplashActivity".equals(this.jdField_a_of_type_AndroidContentIntent.getStringExtra("caller_name"))))) {
      agjt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt, this.jdField_a_of_type_AndroidContentIntent.getStringExtra("forward_photo_sender_uin"), this.jdField_a_of_type_AndroidContentIntent.getStringExtra("forward_photo_md5"), "0X8009F55", paramString);
    }
    while ((this.jdField_a_of_type_AndroidContentIntent == null) || (!"PublicTransFragmentActivity".equals(this.jdField_a_of_type_AndroidContentIntent.getStringExtra("caller_name")))) {
      return;
    }
    agjt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt, this.jdField_a_of_type_AndroidContentIntent.getStringExtra("forward_photo_sender_uin"), this.jdField_a_of_type_AndroidContentIntent.getStringExtra("forward_photo_md5"), "0X8009F56", paramString);
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
      a(paramString1, new AIOImageProviderService(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), paramString2, 0, null), localAIOImageData);
      F();
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
      bcef.b(null, "dc00899", str, "", "music_tab", "musicark_share", 0, 0, paramString, "", "", "");
      return;
      bool = false;
      break;
      str = "Grp_AIO";
      break label89;
    }
  }
  
  private void a(int[] paramArrayOfInt, String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2, boolean[] paramArrayOfBoolean)
  {
    bdgl localbdgl = (bdgl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(184);
    int i = 0;
    while (i < paramArrayOfBoolean.length)
    {
      if (paramArrayOfBoolean[i] != 0) {
        localbdgl.b(paramArrayOfString1[i], paramArrayOfString2[i], paramArrayOfInt[i], paramString);
      }
      i += 1;
    }
    Q();
    paramArrayOfInt = new atli(this, paramArrayOfBoolean, paramArrayOfString1, paramArrayOfString2, paramArrayOfInt, this.jdField_a_of_type_AndroidOsBundle.getInt("forward_write_together_number"));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(paramArrayOfInt);
  }
  
  private boolean a(int paramInt)
  {
    if ((paramInt == 1) || (paramInt == 0) || (paramInt == 1006) || (paramInt == 3000) || (paramInt == 1000)) {}
    while (i()) {
      return true;
    }
    return false;
  }
  
  public static boolean a(Bundle paramBundle)
  {
    int i = paramBundle.getInt("forward_source_uin_type", -1);
    return (i == 1004) || (i == 1000);
  }
  
  private boolean a(RecentUser paramRecentUser)
  {
    return (paramRecentUser != null) && (!bftf.a(paramRecentUser.uin)) && ((paramRecentUser.getType() != 1006) || (a(atku.jdField_h_of_type_JavaLangInteger))) && (b(paramRecentUser)) && ((paramRecentUser.getType() != 1) || (!a(paramRecentUser.uin))) && ((paramRecentUser.getType() != 0) || (!npt.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentUser.uin, paramRecentUser.getType()))) && (((paramRecentUser.getType() != 1004) && (paramRecentUser.getType() != 1000)) || (this.jdField_b_of_type_Boolean));
  }
  
  private boolean b(RecentUser paramRecentUser)
  {
    return (paramRecentUser.getType() != 1020) && (paramRecentUser.getType() != 1008) && (paramRecentUser.getType() != 1005) && (paramRecentUser.getType() != 1009) && (paramRecentUser.getType() != 1021) && (paramRecentUser.getType() != 1001) && (paramRecentUser.getType() != 10002) && (paramRecentUser.getType() != 10004) && (paramRecentUser.getType() != 1022) && (paramRecentUser.getType() != 1032) && (paramRecentUser.getType() != 1033) && (paramRecentUser.getType() != 1034) && (paramRecentUser.getType() != 7000) && (paramRecentUser.getType() != 6004) && (paramRecentUser.getType() != 9501);
  }
  
  private boolean b(String paramString)
  {
    str = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
    i = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype", 0);
    if (((bfbz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48)).a(str, true).jdField_a_of_type_Boolean)
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131696866, 0).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131299076));
      return false;
    }
    j = a().getInt("key_forward_ability_type");
    QLog.d("ForwardOption.ForwardBaseOption", 1, "-->getConfirmListener--onClick--type = " + j);
    for (;;)
    {
      try
      {
        if ((j != jdField_f_of_type_JavaLangInteger.intValue()) && (j != k.intValue())) {
          continue;
        }
        b(j);
      }
      catch (Throwable paramString)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("ForwardOption.ForwardBaseOption", 2, "Throwable", paramString);
        continue;
        if (j != j.intValue()) {
          continue;
        }
        A();
        continue;
        if (j != m.intValue()) {
          continue;
        }
        B();
        continue;
        if (j != jdField_e_of_type_JavaLangInteger.intValue()) {
          continue;
        }
        paramString = null;
        if (!(this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog instanceof QQCustomDialogWtihEmoticonInput)) {
          continue;
        }
        paramString = ((QQCustomDialogWtihEmoticonInput)this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog).getPalinText();
        b(paramString);
        continue;
        if (a(str, i)) {
          continue;
        }
        d();
        continue;
      }
      if ((this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("is_need_show_toast", true)) && (a(i, str, j))) {
        ThreadManager.getUIHandler().postDelayed(new ForwardBaseOption.5(this), 300L);
      }
      f(j);
      N();
      return true;
      if (j != jdField_g_of_type_JavaLangInteger.intValue()) {
        continue;
      }
      w();
    }
  }
  
  private void e()
  {
    int i = this.jdField_a_of_type_AndroidOsBundle.getInt("req_type");
    Object localObject1;
    if ((this.jdField_a_of_type_AndroidOsBundle.getBoolean("is_ark_display_share", false)) && (i != 5))
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = bfur.a(this.jdField_a_of_type_AndroidAppActivity, c(), this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_AndroidAppActivity.getResources().getInteger(2131427338));
      localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("shareArkInfo");
      if (TextUtils.isEmpty((CharSequence)localObject1)) {}
    }
    try
    {
      Object localObject2 = new JSONObject((String)localObject1);
      localObject1 = ((JSONObject)localObject2).optString("app");
      String str = ((JSONObject)localObject2).optString("view");
      localObject2 = ((JSONObject)localObject2).optString("meta");
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject2))) {
        aovl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, "AIOArkSdkSelectSend", 1, 0, 0L, 0L, 0L, str, "");
      }
      label160:
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage("");
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131690620, b());
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131690709, a());
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      boolean bool;
      do
      {
        return;
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = bfur.a(this.jdField_a_of_type_AndroidAppActivity, c(), a(), null, a(), b(), this.jdField_a_of_type_AndroidAppActivity.getResources().getInteger(2131427338));
        i = this.jdField_a_of_type_AndroidOsBundle.getInt("key_forward_ability_type");
        bool = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("forward_ability_entrence_show_in_share", false);
      } while ((i != jdField_e_of_type_JavaLangInteger.intValue()) || (!bool));
      localObject1 = (QQCustomDialogWtihEmoticonInput)this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
      ((QQCustomDialogWtihEmoticonInput)localObject1).setQzoneTextBuilder();
      ((QQCustomDialogWtihEmoticonInput)localObject1).getEditText().setHint(amtj.a(2131703857));
      return;
    }
    catch (JSONException localJSONException)
    {
      break label160;
    }
  }
  
  private void e(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 10: 
      a("user_click", "more_about", "share", "success");
      return;
    case 11: 
      a("user_click", "custom_button", "share_QQ", "success");
      return;
    }
    a("user_click", "more_button", "share_QQ", "success");
  }
  
  private void e(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardBaseOption", 2, "getImageEditListener from other");
    }
    String str = this.jdField_a_of_type_AndroidOsBundle.getString("forward_filepath");
    if (str != null) {
      a(str, paramString);
    }
    do
    {
      return;
      if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("key_flag_from_plugin", false))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ForwardOption.ForwardBaseOption", 2, "Edit Forward Image: from QZone");
        }
        this.jdField_a_of_type_AndroidOsBundle.putBoolean("FORWARD_IS_QZONE_SHARE", true);
        a(this.jdField_b_of_type_JavaLangString, paramString);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ForwardOption.ForwardBaseOption", 2, "Edit Forward Image: Unknown source");
  }
  
  private int f()
  {
    if (h()) {
      return 2;
    }
    return 0;
  }
  
  private void f(int paramInt)
  {
    boolean bool;
    String str1;
    Object localObject2;
    Object localObject1;
    Object localObject3;
    if (this.jdField_a_of_type_AndroidOsBundle != null)
    {
      bool = this.jdField_a_of_type_AndroidOsBundle.getBoolean("from_web", false);
      if (bool)
      {
        str1 = this.jdField_a_of_type_AndroidOsBundle.getString("struct_uin");
        if (str1 != null) {
          break label405;
        }
        str1 = "";
        localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("struct_url");
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localObject3 = this.jdField_a_of_type_AndroidOsBundle.getString("strurt_msgid");
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = "";
        }
        localObject3 = AccountDetailActivity.a((String)localObject1);
        if (paramInt == jdField_e_of_type_JavaLangInteger.intValue())
        {
          paramInt = 1002;
          label112:
          String str2 = this.jdField_a_of_type_AndroidOsBundle.getString("source_puin");
          if ((str2 == null) || ("".equals(str2))) {
            break label371;
          }
          str1 = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
          if ((str1 == null) || (paramInt == 1002)) {
            str1 = "";
          }
          odq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", str1, "0X8005B07", "0X8005B07", paramInt, 0, str2, (String)localObject2, (String)localObject1, (String)localObject3, false);
        }
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_AndroidOsBundle != null) && (!bool))
      {
        localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("source_puin");
        if (localObject2 != null)
        {
          localObject1 = this.jdField_a_of_type_AndroidContentIntent.getByteArrayExtra("stuctmsg_bytes");
          if (localObject1 != null)
          {
            localObject3 = bchh.a((byte[])localObject1);
            if (localObject3 != null)
            {
              str1 = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
              localObject1 = str1;
              if (str1 == null) {
                localObject1 = "";
              }
              odq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", (String)localObject1, "0X8005B06", "0X8005B06", 0, 0, (String)localObject2, "" + ((AbsStructMsg)localObject3).msgId, "", "", false);
              odq.a("0X8005B06", (String)localObject1, (String)localObject2, "" + ((AbsStructMsg)localObject3).msgId, "", "");
            }
          }
        }
      }
      return;
      paramInt = 1001;
      break label112;
      label371:
      odq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X80059DC", "0X80059DC", paramInt, 0, str1, (String)localObject2, (String)localObject1, (String)localObject3, false);
      continue;
      label405:
      break;
      bool = false;
    }
  }
  
  protected void A() {}
  
  protected void B() {}
  
  public void C()
  {
    int i = e();
    String str = this.jdField_a_of_type_AndroidOsBundle.getString("forward_source_sub_business_type", "");
    int j = a(this.jdField_a_of_type_AndroidOsBundle.getInt("forward_type", 2147483647));
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardBaseOption", 2, "reportShowForwardRecent srcBusinessType = " + i + ",srcSubBusinessType = " + str);
    }
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A7EB", "0X800A7EB", i, 0, "", "", String.valueOf(j), str);
  }
  
  public void D()
  {
    if (this.jdField_a_of_type_AndroidOsBundle == null) {
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardBaseOption", 2, "reportFinalSelectedTargets return, mExtraData is null");
      }
    }
    String str1;
    int k;
    Object localObject;
    int m;
    do
    {
      int i;
      String str2;
      int j;
      for (;;)
      {
        return;
        if (jdField_a_of_type_JavaTextSimpleDateFormat == null) {
          jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        }
        i = e();
        str1 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_source_sub_business_type", "");
        str2 = jdField_a_of_type_JavaTextSimpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
        k = this.jdField_a_of_type_AndroidOsBundle.getInt("forward_type", 2147483647);
        j = a(k);
        if (QLog.isColorLevel()) {
          QLog.d("ForwardOption.ForwardBaseOption", 2, "reportFinalSelectedTargets srcBusinessType = " + i + ",srcSubBusinessType = " + str1 + ",forwardType = " + k + ",forwardMsgType = " + j + ",operateTime = " + str2);
        }
        if ((this.jdField_b_of_type_JavaUtilArrayList == null) || (this.jdField_b_of_type_JavaUtilArrayList.size() <= 0)) {
          break;
        }
        localObject = this.jdField_b_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          ResultRecord localResultRecord = (ResultRecord)((Iterator)localObject).next();
          String str3 = localResultRecord.uin;
          k = localResultRecord.uinType;
          m = a(str3, k);
          bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str3, "0X800A7EC", "0X800A7EC", i, 0, str2, String.valueOf(m), String.valueOf(j), str1);
          if (QLog.isColorLevel()) {
            QLog.d("ForwardOption.ForwardBaseOption", 2, "reportFinalSelectedTargets multi,,targetUin = " + str3 + ",targetUinType = " + k + ",forwardTargetType = " + m + ",srcSubBusinessType = " + str1);
          }
        }
      }
      k = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
      localObject = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
      m = a((String)localObject, k);
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", (String)localObject, "0X800A7EC", "0X800A7EC", i, 0, str2, String.valueOf(m), String.valueOf(j), str1);
    } while (!QLog.isColorLevel());
    QLog.d("ForwardOption.ForwardBaseOption", 2, "reportFinalSelectedTargets single,,targetUin = " + (String)localObject + ",targetUinType = " + k + ",forwardTargetType = " + m + ",srcSubBusinessType = " + str1);
  }
  
  public void E()
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
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog instanceof QQCustomDialogWtihEmoticonInput))
    {
      localObject1 = ((QQCustomDialogWtihEmoticonInput)this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog).getInputValue();
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label656;
      }
    }
    label642:
    label656:
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardBaseOption", 2, "reportClickSend srcBusinessType = " + j + ",srcSubBusinessType = " + str2 + ",forwardType = " + i + ",forwardMsgType = " + k + ",hasLeftAMessage = " + bool + ",operateTime = " + (String)localObject2);
      }
      label229:
      int m;
      if ((this.jdField_b_of_type_JavaUtilArrayList != null) && (this.jdField_b_of_type_JavaUtilArrayList.size() > 0))
      {
        localObject2 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
        i = -1;
        localObject1 = str1;
        if (((Iterator)localObject2).hasNext())
        {
          localObject1 = (ResultRecord)((Iterator)localObject2).next();
          str1 = ((ResultRecord)localObject1).uin;
          m = ((ResultRecord)localObject1).uinType;
          i = a(str1, m);
          QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          if (bool) {}
          for (localObject1 = "1";; localObject1 = "2")
          {
            bcef.b(localQQAppInterface, "dc00898", "", str1, "0X800A7ED", "0X800A7ED", j, 0, (String)localObject1, String.valueOf(i), String.valueOf(k), str2);
            if (QLog.isColorLevel()) {
              QLog.d("ForwardOption.ForwardBaseOption", 2, "reportClickSend multi,,targetUin = " + str1 + ",targetUinType = " + m + ",forwardTargetType = " + i + ",srcSubBusinessType = " + str2);
            }
            localObject1 = str1;
            break label229;
            if (!(this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog instanceof atmx)) {
              break;
            }
            localObject1 = ((atmx)this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog).getInputValue();
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
          break label642;
        }
        localObject1 = "1";
        bcef.b((QQAppInterface)localObject2, "dc00898", "", str1, "0X800A7ED", "0X800A7ED", j, 0, (String)localObject1, String.valueOf(i), String.valueOf(k), str2);
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
  
  public void F()
  {
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009BE9", "0X8009BE9", this.jdField_b_of_type_Int, 0, "", "", "", "");
  }
  
  public void G()
  {
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009BEA", "0X8009BEA", this.jdField_b_of_type_Int, 0, "", "", "", "");
    E();
  }
  
  public void H()
  {
    if (!this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("key_forward_image_share", false)) {}
    String str1;
    String str2;
    do
    {
      do
      {
        return;
        str1 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("key_forward_image_share_appid");
      } while (TextUtils.isEmpty(str1));
      int i = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("key_forward_image_share_uin_type", 0);
      str2 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("key_forward_image_share_title");
      bcef.b(null, "dc00898", "", "", "0X800A427", "0X800A427", 0, 0, "", ForwardUtils.toTypeSimple(i), str1, str2);
    } while (!QLog.isColorLevel());
    QLog.d("ForwardOption.ForwardBaseOption", 2, new Object[] { "大图转发=", "0X800A427", ", appid", str1, ", title=", str2 });
  }
  
  public float a(float paramFloat)
  {
    Display localDisplay = this.jdField_a_of_type_AndroidAppActivity.getWindowManager().getDefaultDisplay();
    float f2 = localDisplay.getWidth();
    int i = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131296896);
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
    return 2131690620;
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
    int i = 100;
    if (AppConstants.DATALINE_PC_UIN.equals(paramString)) {
      i = 4;
    }
    do
    {
      do
      {
        return i;
        if ("-1010".equals(paramString)) {
          return 6;
        }
        switch (paramInt)
        {
        }
      } while (!ChatActivityUtils.a(paramInt));
      return 3;
      i = 1;
    } while (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramString));
    return 5;
    return 2;
    return 7;
  }
  
  protected final DialogInterface.OnClickListener a()
  {
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener == null) {
      this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new atlh(this);
    }
    return this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener;
  }
  
  public Bundle a()
  {
    return this.jdField_a_of_type_AndroidOsBundle;
  }
  
  protected View.OnClickListener a(atlm paramatlm)
  {
    String str = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
    if (this.jdField_a_of_type_AndroidViewView$OnClickListener == null) {
      this.jdField_a_of_type_AndroidViewView$OnClickListener = new atll(this, str, paramatlm);
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
    return this.jdField_b_of_type_JavaUtilArrayList;
  }
  
  public List<RecentUser> a(List<RecentUser> paramList)
  {
    boolean bool = s();
    ArrayList localArrayList = new ArrayList();
    RecentUser localRecentUser;
    if ((bool) && (this.jdField_c_of_type_Int == 2))
    {
      localRecentUser = new RecentUser(AppConstants.DATALINE_PC_UIN, 6000);
      localRecentUser.displayName = amtj.a(2131694020);
      localArrayList.add(localRecentUser);
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localRecentUser = (RecentUser)paramList.next();
      if ((bool) && (this.jdField_c_of_type_Int == 1) && (localRecentUser != null) && (TextUtils.equals(localRecentUser.uin, AppConstants.DATALINE_PC_UIN))) {
        localArrayList.add(localRecentUser);
      } else if (a(localRecentUser)) {
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
    if (q()) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_b_of_type_JavaLangInteger);
    }
    if (o()) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_d_of_type_JavaLangInteger);
    }
    if (p()) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_c_of_type_JavaLangInteger);
    }
    if (n()) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_h_of_type_JavaLangInteger);
    }
    if (e()) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_e_of_type_JavaLangInteger);
    }
    this.jdField_a_of_type_JavaUtilSet.add(i);
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_b_of_type_Bhht == null) {
      this.jdField_b_of_type_Bhht = new bhht(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299076));
    }
    this.jdField_b_of_type_Bhht.c(paramInt);
    if (!this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
      this.jdField_b_of_type_Bhht.show();
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if (!g()) {
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
    this.jdField_b_of_type_JavaUtilArrayList = this.jdField_a_of_type_AndroidOsBundle.getParcelableArrayList("forward_multi_target");
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    if (this.jdField_b_of_type_JavaUtilArrayList != null)
    {
      paramBundle = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (paramBundle.hasNext())
      {
        ResultRecord localResultRecord = (ResultRecord)paramBundle.next();
        if ((localResultRecord.uinType != 6000) && (localResultRecord.uinType != 6003)) {
          this.jdField_a_of_type_JavaUtilArrayList.add(localResultRecord);
        } else {
          this.jdField_c_of_type_JavaUtilArrayList.add(localResultRecord);
        }
      }
    }
    m();
  }
  
  protected void a(Intent paramIntent) {}
  
  public void a(Drawable paramDrawable, boolean paramBoolean)
  {
    if (paramBoolean) {
      URLDrawableHelper.decodeLocalImage((URLDrawable)paramDrawable, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), true);
    }
    if (paramDrawable == null) {}
    while (paramBoolean) {
      return;
    }
    paramDrawable.setBounds(bfvo.a(paramDrawable, 36, 100, this.jdField_a_of_type_Float));
  }
  
  protected void a(Drawable paramDrawable, boolean paramBoolean, int paramInt)
  {
    a(paramDrawable, paramBoolean, paramInt, false);
  }
  
  public void a(Drawable paramDrawable, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new ForwardBaseOption.12(this, paramDrawable, paramBoolean1, paramInt, paramBoolean2));
  }
  
  public void a(Bundle paramBundle)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      paramBundle.putBundle("key_forward_base_option_bundle", this.jdField_a_of_type_AndroidOsBundle);
    }
  }
  
  protected void a(Bundle paramBundle, AIOImageProviderService paramAIOImageProviderService, AIORichMediaData paramAIORichMediaData)
  {
    bkkh.a(this.jdField_a_of_type_AndroidAppActivity, paramBundle, paramAIOImageProviderService, paramAIORichMediaData, 19001, 4);
  }
  
  protected void a(Bundle paramBundle, String paramString, df paramdf)
  {
    amqd localamqd = (amqd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(8);
    paramBundle = "";
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog instanceof QQCustomDialogWtihEmoticonInput)) {
      paramBundle = ((QQCustomDialogWtihEmoticonInput)this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog).getInputValue();
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
        int i = localamqd.a().b(paramString, localBundle, paramdf);
        if (QLog.isColorLevel()) {
          QLog.i("ForwardOption.ForwardBaseOption", 2, "sendDataLineMessage: invoked.  noteRet: " + i);
        }
      }
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog instanceof atmx)) {
        paramBundle = ((atmx)this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog).getInputValue();
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidAppActivity.getResources().getDisplayMetrics().density;
  }
  
  public void a(QQCustomDialog paramQQCustomDialog) {}
  
  protected void a(QQCustomDialogWtihForwardAvatar paramQQCustomDialogWtihForwardAvatar)
  {
    if (paramQQCustomDialogWtihForwardAvatar == null) {}
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
    String str3 = amtj.a(2131703863);
    Object localObject = str1;
    if (str1.startsWith(str3)) {
      localObject = str1.substring(str3.length());
    }
    localObject = ((String)localObject).trim();
    paramQQCustomDialogWtihForwardAvatar.showForwardTargetAvatar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, str2, i, (String)localObject, bool);
    return;
    if (((List)localObject).size() == 1)
    {
      localObject = (ResultRecord)((List)localObject).get(0);
      paramQQCustomDialogWtihForwardAvatar.showForwardTargetAvatar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, ((ResultRecord)localObject).uin, ((ResultRecord)localObject).getUinType(), ((ResultRecord)localObject).name, false);
      return;
    }
    paramQQCustomDialogWtihForwardAvatar.showForwardTargetAvatar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, (List)localObject, true);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidOsBundle != null) {
      this.jdField_a_of_type_AndroidOsBundle.remove(paramString);
    }
  }
  
  protected final void a(String paramString, QQCustomDialog paramQQCustomDialog)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardBaseOption", 2, "addSourceNameView start! sourceName =" + paramString);
    }
    if ((paramString == null) || ("".equals(paramString)) || (paramQQCustomDialog == null)) {
      return;
    }
    TextView localTextView = new TextView(this.jdField_a_of_type_AndroidAppActivity);
    localTextView.setText(paramString);
    localTextView.setTextSize(12.0F);
    localTextView.setPadding(0, 0, 0, 0);
    localTextView.setIncludeFontPadding(false);
    localTextView.setTextColor(-8355712);
    paramQQCustomDialog.addView(localTextView);
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
    localBundle.putString("uinname", amtj.a(2131703862) + paramString2);
    a(atku.jdField_d_of_type_JavaLangInteger.intValue(), localBundle);
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
    h();
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
      } while ((this.jdField_c_of_type_Boolean) || ((this instanceof ForwardSendHongBaoOption)) || ((this instanceof ForwardChooseFriendOption)) || (this.jdField_a_of_type_AndroidOsBundle.getInt("cmshow_game_id") > 0));
      bool1 = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("forward_source_from_shoot_quick", false);
      bool2 = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("forward_source_from_pre_guide", false);
    } while ((bool1) || (bool2));
    if (paramInt1 == 1) {
      if (((bfbz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48)).a(paramString, true).jdField_a_of_type_Boolean)
      {
        bool1 = false;
        bool2 = bool1;
        if (bool1)
        {
          bool2 = bool1;
          if ((this instanceof ForwardFileOption))
          {
            paramString = (ForwardFileOption)this;
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
        if (str.equals(this.jdField_a_of_type_AndroidAppActivity.getString(2131692058))) {
          bool1 = true;
        }
      }
    }
    if (bool1)
    {
      this.jdField_a_of_type_AndroidOsBundle.putBoolean("isBack2Root", true);
      this.jdField_a_of_type_AndroidOsBundle.putString("leftBackText", this.jdField_a_of_type_AndroidAppActivity.getString(2131718771));
      paramIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
    }
    bool2 = this.jdField_a_of_type_AndroidOsBundle.getBoolean("isFromAIOPlus");
    return (bool1) && (bool2);
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
  
  protected boolean a(QQCustomDialog paramQQCustomDialog)
  {
    return true;
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
  
  protected boolean a(String paramString, int paramInt)
  {
    boolean[] arrayOfBoolean = this.jdField_a_of_type_AndroidOsBundle.getBooleanArray("forward_is_write_together");
    int[] arrayOfInt = this.jdField_a_of_type_AndroidOsBundle.getIntArray("forward_write_together_base_rev");
    String str = this.jdField_a_of_type_AndroidOsBundle.getString("forward_source_uin");
    String[] arrayOfString1 = this.jdField_a_of_type_AndroidOsBundle.getStringArray("forward_write_together_pad_id");
    String[] arrayOfString2 = this.jdField_a_of_type_AndroidOsBundle.getStringArray("forward_write_together_token");
    if ((paramInt != 1) || (!paramString.equals(str))) {}
    for (;;)
    {
      return false;
      if ((arrayOfBoolean != null) && (arrayOfInt != null) && (arrayOfString1 != null) && (arrayOfString2 != null))
      {
        this.jdField_a_of_type_ArrayOfBoolean = new boolean[arrayOfBoolean.length];
        int i = arrayOfBoolean.length;
        paramInt = 0;
        while (paramInt < i)
        {
          if (arrayOfBoolean[paramInt] != 0)
          {
            a(arrayOfInt, str, arrayOfString1, arrayOfString2, arrayOfBoolean);
            return true;
          }
          paramInt += 1;
        }
      }
    }
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
    return 2131690709;
  }
  
  protected final DialogInterface.OnClickListener b()
  {
    if (this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener == null) {
      this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener = new atlj(this);
    }
    return this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener;
  }
  
  public String b()
  {
    String str2 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("k_forward_title");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = amtj.a(2131703865);
    }
    return str1;
  }
  
  protected List<ResultRecord> b()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  protected void b()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessageWithEmo(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Float);
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
    String str = AppConstants.DATALINE_PC_UIN;
    if (paramInt == k.intValue()) {
      str = AppConstants.DATALINE_IPAD_UIN;
    }
    for (;;)
    {
      localBundle.putAll(this.jdField_a_of_type_AndroidOsBundle);
      Intent localIntent = new Intent();
      atld localatld = new atld(this);
      amqd localamqd = (amqd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(8);
      if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("sendMultiple", false))
      {
        a(localIntent);
        localBundle.putAll(localIntent.getExtras());
        paramInt = localamqd.a().a(str, localBundle, localatld);
        a(localBundle, str, null);
        label257:
        if ((i()) || (paramInt != 0)) {
          break label359;
        }
        dc.b(this.jdField_a_of_type_AndroidAppActivity, paramInt);
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
        paramInt = localamqd.a().b(str, localBundle, localatld);
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
      a(paramBundle.getInt("key_forward_ability_type", atku.a.intValue()), paramBundle);
    }
  }
  
  protected void b(String paramString) {}
  
  protected final void b(String paramString, QQCustomDialog paramQQCustomDialog)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardBaseOption", 2, "updateImageView: filepath=" + paramString);
    }
    ThreadManager.post(new ForwardBaseOption.13(this, paramString, paramQQCustomDialog), 8, null, false);
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
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog instanceof QQCustomDialogWtihEmoticonInput))
    {
      str = ((QQCustomDialogWtihEmoticonInput)this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog).getInputValue();
      if (TextUtils.isEmpty(str)) {
        break label270;
      }
      if (QLog.isColorLevel()) {
        QLog.i("ForwardOption.ForwardBaseOption", 2, "sendMessageOnConfirm: invoked.  textAndEmoji: " + str);
      }
      this.jdField_a_of_type_AndroidOsBundle.putString("share_comment_message", str);
      i = afoa.a().a();
      if (!i()) {
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
      ((SessionInfo)localObject).curType = paramInt;
      ((SessionInfo)localObject).curFriendUin = paramString1;
      ((SessionInfo)localObject).troopUin = paramString2;
      if (!(this instanceof ForwardShareCardOption)) {
        afoa.a().a((SessionInfo)localObject, str, i);
      }
      return true;
      if (!(this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog instanceof atmx)) {
        break;
      }
      str = ((atmx)this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog).getInputValue();
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
      this.jdField_c_of_type_AndroidContentDialogInterface$OnClickListener = new atlk(this);
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
        str2 = amtj.a(2131703861) + str1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardBaseOption", 2, "dialogTitle=" + str2);
      }
      return str2;
      if (i == jdField_f_of_type_JavaLangInteger.intValue()) {
        str1 = amtj.a(2131694020);
      } else if (i == k.intValue()) {
        str1 = "我的iPad";
      } else if (i == jdField_g_of_type_JavaLangInteger.intValue()) {
        str1 = amtj.a(2131703856);
      } else if (i == m.intValue()) {
        str1 = vkm.jdField_a_of_type_JavaLangString;
      } else {
        str1 = this.jdField_a_of_type_AndroidOsBundle.getString("uinname");
      }
    }
  }
  
  public void c()
  {
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005A0F", "0X8005A0F", 0, 0, "0", "", "", "");
  }
  
  protected void c(int paramInt)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, LiteActivity.class);
    if (paramInt == k.intValue())
    {
      localIntent.putExtra("targetUin", AppConstants.DATALINE_IPAD_UIN);
      localIntent.putExtra("device_type", 1);
      if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("isFromShare", false))
      {
        this.jdField_a_of_type_AndroidOsBundle.putString("leftBackText", amtj.a(2131703855));
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
      localIntent.putExtra("targetUin", AppConstants.DATALINE_PC_UIN);
      localIntent.putExtra("device_type", 0);
      break;
      label207:
      b(localIntent);
    }
  }
  
  protected void c(String paramString)
  {
    Object localObject1 = (aara)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(51);
    Object localObject2 = ((aara)localObject1).a(Long.parseLong(paramString));
    ((aara)localObject1).a(this.jdField_a_of_type_AndroidAppActivity, (DeviceInfo)localObject2, false);
    localObject1 = this.jdField_a_of_type_AndroidContentIntent;
    String str = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("forward_filepath");
    localObject1 = (RouterHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(48);
    localObject2 = new ArrayList();
    try
    {
      ((ArrayList)localObject2).add(new FileInfo(str));
      label84:
      ((RouterHandler)localObject1).a((ArrayList)localObject2, null, null, Long.parseLong(paramString));
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      break label84;
    }
  }
  
  protected boolean c()
  {
    if (i()) {
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
      return amtj.a(2131703859);
    }
    if ((j == jdField_f_of_type_JavaLangInteger.intValue()) || (j == k.intValue())) {
      return amtj.a(2131703864);
    }
    return "";
  }
  
  protected void d()
  {
    int i = 0;
    if (i())
    {
      List localList = b();
      if ((localList != null) && (!localList.isEmpty()))
      {
        int j = localList.size();
        while (i < j)
        {
          ResultRecord localResultRecord = (ResultRecord)localList.get(i);
          if (k()) {
            b(localResultRecord.uin, localResultRecord.groupUin, localResultRecord.getUinType());
          }
          i += 1;
        }
        this.jdField_a_of_type_AndroidOsBundle.putBoolean("isBack2Root", true);
        c();
      }
      return;
    }
    G();
    if (this.jdField_d_of_type_Boolean)
    {
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005793", "0X8005793", 0, 0, "", "", "", "");
      this.jdField_d_of_type_Boolean = false;
    }
    if (k()) {
      r();
    }
    x();
  }
  
  protected void d(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardBaseOption", 2, "-->showQfavResultDialog--code = " + paramInt);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    z();
    atlf localatlf = new atlf(this);
    if (this.jdField_a_of_type_Aaeo == null) {
      this.jdField_a_of_type_Aaeo = new aaeo(this.jdField_a_of_type_AndroidAppActivity);
    }
    for (;;)
    {
      String str = this.jdField_a_of_type_AndroidAppActivity.getString(2131690599);
      Object localObject = str;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_AndroidOsBundle.getString("app_name"))) {
        localObject = str + this.jdField_a_of_type_AndroidOsBundle.getString("app_name");
      }
      this.jdField_a_of_type_Aaeo.a((String)localObject, localatlf);
      this.jdField_a_of_type_Aaeo.a(2131691962);
      localObject = this.jdField_a_of_type_Aaeo;
      boolean bool;
      if (paramInt == 0)
      {
        bool = true;
        ((aaeo)localObject).a(bool);
        this.jdField_a_of_type_Aaeo.a(2131718401);
        this.jdField_a_of_type_Aaeo.b(0);
        this.jdField_a_of_type_Aaeo.c(2131718402);
        this.jdField_a_of_type_Aaeo.b(this.jdField_a_of_type_AndroidAppActivity.getString(2131694253), localatlf);
      }
      try
      {
        this.jdField_a_of_type_Aaeo.show();
        return;
        this.jdField_a_of_type_Aaeo.dismiss();
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
      bcef.b(null, "dc00898", "", "", "0X800A631", "0X800A631", 0, 0, paramString, ForwardUtils.toTypeSimple(i), str, String.valueOf(this.jdField_a_of_type_Long));
    } while (!QLog.isColorLevel());
    QLog.d("ForwardOption.ForwardBaseOption", 2, new Object[] { "图文或者音乐转发=0X800A631, type=", paramString, ", title=", str, ", uinType=", ForwardUtils.toTypeSimple(i) });
  }
  
  public int e()
  {
    return a(this.jdField_a_of_type_AndroidOsBundle);
  }
  
  protected boolean e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardBaseOption", 2, "-->allowQZoneAbility--allow = false");
    }
    return false;
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_AndroidOsBundle != null) && (this.jdField_a_of_type_AndroidOsBundle.getBoolean("k_forward_show_direct_share_tips", false))) {
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A220", "0X800A220", 0, 0, "0", "", "", "");
    }
    D();
  }
  
  public boolean f()
  {
    return false;
  }
  
  public void g() {}
  
  protected boolean g()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      return false;
    }
    if ((this.jdField_a_of_type_Aaeo != null) && (this.jdField_a_of_type_Aaeo.isShowing())) {
      this.jdField_a_of_type_Aaeo.dismiss();
    }
    z();
    return true;
  }
  
  void h()
  {
    if (jdField_a_of_type_Int <= 0)
    {
      Display localDisplay = ((WindowManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("window")).getDefaultDisplay();
      int i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297429);
      int j = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297431);
      jdField_a_of_type_Int = (localDisplay.getWidth() - i * 2 - j * 3) / 4;
    }
  }
  
  protected boolean h()
  {
    int i = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype", 0);
    int j = this.jdField_a_of_type_AndroidOsBundle.getInt("key_forward_ability_type");
    if (a(i)) {}
    while ((j == jdField_f_of_type_JavaLangInteger.intValue()) || (j == k.intValue()) || (i == 1024) || (i == 1025)) {
      return true;
    }
    return false;
  }
  
  public void i()
  {
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    a();
  }
  
  protected boolean i()
  {
    List localList = a();
    return (localList != null) && (!localList.isEmpty());
  }
  
  protected void j()
  {
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("k_favorites", true)) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_g_of_type_JavaLangInteger);
    }
  }
  
  protected boolean j()
  {
    boolean bool2 = false;
    boolean[] arrayOfBoolean = this.jdField_a_of_type_AndroidOsBundle.getBooleanArray("forward_is_write_together");
    int[] arrayOfInt = this.jdField_a_of_type_AndroidOsBundle.getIntArray("forward_write_together_base_rev");
    String str = this.jdField_a_of_type_AndroidOsBundle.getString("forward_source_uin");
    String[] arrayOfString1 = this.jdField_a_of_type_AndroidOsBundle.getStringArray("forward_write_together_pad_id");
    String[] arrayOfString2 = this.jdField_a_of_type_AndroidOsBundle.getStringArray("forward_write_together_token");
    boolean bool1 = bool2;
    if (arrayOfBoolean != null)
    {
      bool1 = bool2;
      if (arrayOfInt != null)
      {
        bool1 = bool2;
        if (arrayOfString1 != null)
        {
          bool1 = bool2;
          if (arrayOfString2 != null)
          {
            List localList = b();
            this.jdField_a_of_type_ArrayOfBoolean = new boolean[arrayOfBoolean.length];
            int i = 0;
            bool1 = false;
            while (i < localList.size())
            {
              ResultRecord localResultRecord = (ResultRecord)localList.get(i);
              bool2 = bool1;
              if (localResultRecord.getUinType() == 1)
              {
                if (!localResultRecord.uin.equals(str)) {
                  bool2 = bool1;
                }
              }
              else
              {
                i += 1;
                bool1 = bool2;
                continue;
              }
              int k = arrayOfBoolean.length;
              int j = 0;
              for (;;)
              {
                bool2 = bool1;
                if (j >= k) {
                  break;
                }
                if (arrayOfBoolean[j] != 0)
                {
                  a(arrayOfInt, str, arrayOfString1, arrayOfString2, arrayOfBoolean);
                  bool2 = true;
                  break;
                }
                j += 1;
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public void k()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog instanceof QQCustomArkDialog)) {
      ((QQCustomArkDialog)this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog).onEvent(0);
    }
  }
  
  protected boolean k()
  {
    return true;
  }
  
  public void l()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog instanceof QQCustomArkDialog)) {
      ((QQCustomArkDialog)this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog).onEvent(1);
    }
    if ((this.jdField_a_of_type_Bhht != null) && (this.jdField_a_of_type_Bhht.isShowing())) {
      this.jdField_a_of_type_Bhht.dismiss();
    }
  }
  
  protected boolean l()
  {
    return false;
  }
  
  @TargetApi(11)
  public final void m()
  {
    if (l())
    {
      v();
      return;
    }
    K();
    int i = c();
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardBaseOption", 2, "-->buildConfirmDialog--editTextType = " + i);
    }
    if (i == 0) {
      J();
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog instanceof QQCustomDialogWtihForwardAvatar)) {
        a((QQCustomDialogWtihForwardAvatar)this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog);
      }
      Object localObject1 = d();
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setEditLint((String)localObject1);
      }
      if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("miniAppNeedOnlyPreview", false))
      {
        ((QQCustomArkDialog)this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog).hideForwardTargetAvatar(c());
        ((QQCustomArkDialog)this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog).hideInputContainer();
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnDismissListener(this);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.adjustTitle();
      b();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMsgMaxLineWithEnd(this.jdField_a_of_type_JavaLangString, 3);
      if (a(this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog)) {
        b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog);
      }
      if (this.jdField_a_of_type_AndroidOsBundle.getInt(jdField_e_of_type_JavaLangString, 0) == 1) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPreviewImageScaleType(true);
      }
      if (this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      return;
      if (i == 1)
      {
        I();
      }
      else if (i == 2)
      {
        e();
      }
      else if (i == 3)
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = bfur.a(this.jdField_a_of_type_AndroidAppActivity, c(), a(), null, a(), b(), this.jdField_a_of_type_AndroidAppActivity.getResources().getInteger(2131427338), false);
      }
      else
      {
        Object localObject2;
        if (i == 4)
        {
          localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("choose_friend_content");
          localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("choose_friend_subcontent");
          ArrayList localArrayList = this.jdField_a_of_type_AndroidOsBundle.getStringArrayList("choose_friend_feedbacks");
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = bfur.a(this.jdField_a_of_type_AndroidAppActivity, c(), (String)localObject1, (String)localObject2, localArrayList, null, a(), b(), this.jdField_a_of_type_AndroidAppActivity.getResources().getInteger(2131427338), false);
        }
        else if (i == 5)
        {
          i = this.jdField_a_of_type_AndroidOsBundle.getInt("key_hiboom_id");
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = bfur.a(this.jdField_a_of_type_AndroidAppActivity, c(), "", null, a(), b(), this.jdField_a_of_type_AndroidAppActivity.getResources().getInteger(2131427338), false);
          localObject1 = new HiBoomTextView(this.jdField_a_of_type_AndroidAppActivity);
          ((HiBoomTextView)localObject1).setHiBoom(i, 0, auen.jdField_a_of_type_Aueg);
          ((HiBoomTextView)localObject1).setText(this.jdField_a_of_type_JavaLangString);
          ((HiBoomTextView)localObject1).setMaxSize(auen.jdField_a_of_type_Int);
          localObject2 = new LinearLayout.LayoutParams(500, 500);
          ((LinearLayout.LayoutParams)localObject2).gravity = 17;
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.addView((View)localObject1, (LinearLayout.LayoutParams)localObject2);
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = bfur.a(this.jdField_a_of_type_AndroidAppActivity, c(), a(), null, a(), b(), this.jdField_a_of_type_AndroidAppActivity.getResources().getInteger(2131427338), false);
        }
      }
    }
  }
  
  public boolean m()
  {
    return true;
  }
  
  public void n()
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
  
  protected boolean n()
  {
    avsy localavsy = (avsy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
    if ((localavsy != null) && (localavsy.d())) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardBaseOption", 2, "-->allowPhoneContactAbility--allow = " + bool);
      }
      return bool;
    }
  }
  
  protected void o() {}
  
  protected boolean o()
  {
    Object localObject = (amrb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53);
    if (localObject != null)
    {
      localObject = ((amrb)localObject).a();
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
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog instanceof QQCustomArkDialog)) {
      QLog.d("ForwardOption.ForwardBaseOption", 1, "QQCustomArkDialog dismiss");
    }
  }
  
  protected void p() {}
  
  protected boolean p()
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
  
  public void q()
  {
    d();
  }
  
  protected boolean q()
  {
    Object localObject = (amsw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    if (localObject != null)
    {
      localObject = ((amsw)localObject).e();
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
  
  protected void r()
  {
    int i = 1;
    String str1 = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
    String str2 = this.jdField_a_of_type_AndroidOsBundle.getString("troop_uin");
    int j = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
    if (b(str1, str2, j)) {
      if (j != 0) {
        break label82;
      }
    }
    for (;;)
    {
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8009AAE", "0X8009AAE", i, 0, "", "", "", "");
      return;
      label82:
      if (j == 1) {
        i = 2;
      } else if (j == 3000) {
        i = 3;
      } else {
        i = 0;
      }
    }
  }
  
  protected boolean r()
  {
    boolean bool2 = false;
    boolean bool1 = false;
    boolean bool3 = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("sendMultiple", false);
    int i;
    if (awcm.a().c() > 1)
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
      Object localObject = (aara)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(51);
      bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (((aara)localObject).a())
        {
          localObject = ((aara)localObject).a();
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
  
  protected void s()
  {
    this.jdField_d_of_type_Boolean = false;
    if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("miniAppNeedOnlyPreview", false)) {
      QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_direct_share_fail", null, null);
    }
    if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("avgame_share_callback_key", false)) {
      anha.a().a(this.jdField_a_of_type_AndroidAppActivity, false);
    }
  }
  
  public boolean s()
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
  
  public void t() {}
  
  protected void u()
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setImageOnClickListener(a(new atlb(this)));
  }
  
  protected void v()
  {
    atmx localatmx = new atmx(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = localatmx;
    if (!h()) {}
    for (boolean bool = true;; bool = false)
    {
      localatmx.a(bool);
      localatmx.c(210);
      localatmx.a(a());
      localatmx.setCanceledOnTouchOutside(false);
      localatmx.a(c(), d(), this.jdField_a_of_type_AndroidAppActivity.getResources().getString(a()), this.jdField_a_of_type_AndroidAppActivity.getResources().getString(b()), a(), b());
      localatmx.a(new atlc(this));
      a(localatmx);
      if (!this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
        localatmx.show();
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnDismissListener(this);
      return;
    }
  }
  
  public void w()
  {
    int i = d();
    if (this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
      return;
    }
    d(i);
  }
  
  protected void x()
  {
    this.jdField_a_of_type_AndroidOsBundle.putBoolean("isBack2Root", true);
    if (this.jdField_a_of_type_AndroidOsBundle.getInt("uintype") == 6002) {
      c(this.jdField_a_of_type_AndroidOsBundle.getString("uin"));
    }
    while (c()) {
      return;
    }
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004047", "0X8004047", 0, 0, "", "", "", "");
  }
  
  public void y()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Amrc);
  }
  
  public void z()
  {
    if ((this.jdField_b_of_type_Bhht != null) && (this.jdField_b_of_type_Bhht.isShowing())) {
      this.jdField_b_of_type_Bhht.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     atky
 * JD-Core Version:    0.7.0.1
 */