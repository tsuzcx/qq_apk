import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.StyleSpan;
import android.util.LruCache;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.LbsManagerService;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ExtendFriendUserInfo;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager.3;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager.4;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager.5;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager.9;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xdb1.oidb_0xdb1.RspBody;
import tencent.im.oidb.cmd0xdb1.oidb_0xdb1.SchoolInfo;
import tencent.im.oidb.cmd0xdb1.oidb_0xdb1.SearchKeyWord;
import tencent.im.oidb.cmd0xdb1.oidb_0xdb1.matchTaskInfo;
import tencent.im.oidb.cmd0xdb1.oidb_0xdb1.oneTask;
import tencent.im.oidb.cmd0xe03.oidb_0xe03.RspBody;
import tencent.im.oidb.cmd0xe03.oidb_0xe03.matchTaskInfo;
import tencent.im.oidb.cmd0xe03.oidb_0xe03.oneTask;

public class aslo
  implements asmf, Manager
{
  public static asnu a;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  public static final String a;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private LruCache<String, ExtendFriendUserInfo> jdField_a_of_type_AndroidUtilLruCache = new LruCache(50);
  private aslx jdField_a_of_type_Aslx;
  private aslz jdField_a_of_type_Aslz = new asls(this);
  private asma jdField_a_of_type_Asma;
  private asqa jdField_a_of_type_Asqa;
  asss jdField_a_of_type_Asss;
  private azrs jdField_a_of_type_Azrs;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new aslp(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private List<asqs> jdField_a_of_type_JavaUtilList = new ArrayList();
  private oidb_0xdb1.SchoolInfo jdField_a_of_type_TencentImOidbCmd0xdb1Oidb_0xdb1$SchoolInfo;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private asqa jdField_b_of_type_Asqa;
  private Object jdField_b_of_type_JavaLangObject = new Object();
  public String b;
  private ArrayList<String> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private List<asmp> jdField_b_of_type_JavaUtilList;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private volatile long jdField_d_of_type_Long;
  private String jdField_d_of_type_JavaLangString = "";
  private volatile boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private String jdField_e_of_type_JavaLangString = "";
  private volatile boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int = -1;
  private volatile boolean jdField_f_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_JavaLangString = anvx.a(2131703747);
  }
  
  public aslo(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aslz);
    this.jdField_a_of_type_Asma = new asma(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Asma.a(this);
    this.jdField_a_of_type_Asqa = new asqa(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2);
    this.jdField_b_of_type_Asqa = new asqa(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    this.jdField_a_of_type_Asss = new asss(paramQQAppInterface);
    ThreadManager.postImmediately(new ExtendFriendManager.3(this), null, true);
  }
  
  private static int a(QQAppInterface paramQQAppInterface)
  {
    int i = 0;
    if (paramQQAppInterface != null) {
      i = bhhr.a(paramQQAppInterface.getCurrentAccountUin(), "extend_friend_config_785").getInt("sp_extend_friend_forbid_flag", 0);
    }
    return i;
  }
  
  private static long a(QQAppInterface paramQQAppInterface)
  {
    long l = 0L;
    if (paramQQAppInterface != null) {
      l = bhhr.a(paramQQAppInterface.getCurrentAccountUin(), "extend_friend_config_785").getLong("sp_extend_friend_forbid_end_time", 0L);
    }
    return l;
  }
  
  public static SpannableStringBuilder a(BaseActivity paramBaseActivity, String paramString, QQAppInterface paramQQAppInterface, boolean paramBoolean, long paramLong)
  {
    paramString = new SpannableStringBuilder(paramString);
    if (paramBoolean) {
      return paramString;
    }
    paramString.append("\n");
    Object localObject = new SpannableString("图");
    int i = ViewUtils.dip2px(20.0F);
    Drawable localDrawable = paramBaseActivity.getResources().getDrawable(2130841418);
    localDrawable.setBounds(0, 0, i, i);
    ((SpannableString)localObject).setSpan(new ImageSpan(localDrawable, 1), 0, ((SpannableString)localObject).length(), 17);
    paramString.append((CharSequence)localObject);
    paramString.append(" ");
    paramBaseActivity = paramBaseActivity.getString(2131698462);
    localObject = a(paramQQAppInterface, paramLong);
    paramQQAppInterface = String.format(" %s ", new Object[] { ((ArrayList)localObject).get(0) });
    localObject = (String)((ArrayList)localObject).get(1);
    localObject = new SpannableString(paramBaseActivity + paramQQAppInterface + (String)localObject);
    ((SpannableString)localObject).setSpan(new AbsoluteSizeSpan(14, true), 0, ((SpannableString)localObject).length(), 17);
    ((SpannableString)localObject).setSpan(new ForegroundColorSpan(Color.parseColor("#878B99")), 0, ((SpannableString)localObject).length(), 17);
    i = paramBaseActivity.length();
    int j = paramBaseActivity.length() + paramQQAppInterface.length();
    ((SpannableString)localObject).setSpan(new AbsoluteSizeSpan(24, true), i, j, 33);
    ((SpannableString)localObject).setSpan(new StyleSpan(1), i, j, 33);
    paramString.append((CharSequence)localObject);
    return paramString;
  }
  
  private aslx a(String paramString)
  {
    int j = 0;
    aslx localaslx = new aslx();
    for (;;)
    {
      int i;
      try
      {
        paramString = new JSONObject(paramString);
        localaslx.jdField_a_of_type_JavaLangString = paramString.optString("contactEntranceTitle");
        localaslx.jdField_b_of_type_JavaLangString = paramString.optString("contactEntranceLine1");
        localaslx.jdField_c_of_type_JavaLangString = paramString.optString("contactEntranceLine2");
        localaslx.jdField_d_of_type_JavaLangString = paramString.optString("addEntranceTitle");
        localaslx.jdField_e_of_type_JavaLangString = paramString.optString("addEntranceLine1");
        localaslx.jdField_a_of_type_Int = paramString.optInt("maxPlayers");
        localaslx.jdField_b_of_type_Int = paramString.optInt("minPlayers");
        localaslx.jdField_c_of_type_Int = paramString.optInt("voiceMaxLength");
        localaslx.jdField_d_of_type_Int = paramString.optInt("maxSlipTimes");
        localaslx.jdField_e_of_type_Int = paramString.optInt("redisplayInterval");
        localaslx.jdField_f_of_type_JavaLangString = paramString.optString("defaultDecleration");
        localaslx.jdField_f_of_type_Int = paramString.optInt("declerationMinLen");
        localaslx.jdField_g_of_type_Int = paramString.optInt("isExpandEntranceOnTop");
        localaslx.jdField_g_of_type_JavaLangString = paramString.optString("resourceURL");
        localaslx.jdField_h_of_type_JavaLangString = paramString.optString("resourceMD5");
        localaslx.jdField_h_of_type_Int = paramString.optInt("isShowGroup");
        localaslx.jdField_j_of_type_JavaLangString = paramString.optString("ExpandExamImg");
        localaslx.jdField_m_of_type_Int = paramString.optInt("exposureTimeLimit", 2);
        localaslx.jdField_a_of_type_Boolean = paramString.optBoolean("showVipIcon", false);
        localaslx.n = paramString.optInt("GrayTipsMsgCount", 50);
        localaslx.jdField_k_of_type_JavaLangString = paramString.optString("GrayTipsMsg");
        localaslx.jdField_l_of_type_JavaLangString = paramString.optString("GrayTipsMsgLight");
        localaslx.o = paramString.optInt("IceBreakSwitch", 1);
        localaslx.jdField_m_of_type_JavaLangString = paramString.optString("BeatWarning");
        localaslx.q = paramString.optInt("sendPicAndVoiceMessageLimitCount", 2);
        if (QLog.isColorLevel()) {
          QLog.d("ExtendFriendManager", 2, "parseConfig config.exposureTimeLimit:" + localaslx.jdField_m_of_type_Int + ", config.sendPicAndVoiceMessageLimitCount = " + localaslx.q);
        }
        localaslx.jdField_a_of_type_JavaUtilList.clear();
        JSONArray localJSONArray = paramString.optJSONArray("defaultTags");
        if (localJSONArray != null)
        {
          i = 0;
          if (i < localJSONArray.length())
          {
            localaslx.jdField_a_of_type_JavaUtilList.add(localJSONArray.optString(i));
            i += 1;
            continue;
          }
        }
        localaslx.jdField_b_of_type_JavaUtilList.clear();
        localJSONArray = paramString.optJSONArray("searchTags");
        if (localJSONArray != null)
        {
          i = 0;
          if (i < localJSONArray.length())
          {
            localaslx.jdField_b_of_type_JavaUtilList.add(localJSONArray.optString(i));
            i += 1;
            continue;
          }
        }
        localaslx.jdField_i_of_type_JavaLangString = paramString.optString("searchHint");
        localJSONArray = paramString.optJSONArray("ExpandMatchRes");
        if (localJSONArray != null)
        {
          i = j;
          if (i < localJSONArray.length())
          {
            JSONObject localJSONObject = localJSONArray.optJSONObject(i);
            if (localJSONObject == null) {
              break label777;
            }
            asly localasly = new asly(this);
            localasly.jdField_a_of_type_JavaLangString = localJSONObject.optString("name");
            if ("aioVideo".equals(localasly.jdField_a_of_type_JavaLangString))
            {
              localasly.jdField_b_of_type_JavaLangString = localJSONObject.optString("resourceURLAndroid");
              localasly.jdField_c_of_type_JavaLangString = localJSONObject.optString("resourceMD5Android");
              if (QLog.isColorLevel()) {
                QLog.d("ExtendFriendManager", 2, String.format("aiovideo use android url:%s", new Object[] { localasly.jdField_b_of_type_JavaLangString }));
              }
              if (!localasly.a()) {
                break label777;
              }
              localaslx.jdField_a_of_type_JavaUtilHashMap.put(localasly.jdField_a_of_type_JavaLangString, localasly);
              break label777;
            }
            localasly.jdField_b_of_type_JavaLangString = localJSONObject.optString("resourceURL");
            localasly.jdField_c_of_type_JavaLangString = localJSONObject.optString("resourceMD5");
            continue;
          }
        }
        localaslx.jdField_i_of_type_Int = paramString.optInt("ExpandMatchSwitch");
      }
      catch (JSONException paramString)
      {
        QLog.e("ExtendFriendManager", 2, "parseConfig fail.", paramString);
        return null;
      }
      localaslx.jdField_j_of_type_Int = paramString.optInt("isNuanSSFirst");
      localaslx.jdField_k_of_type_Int = paramString.optInt("isVoiceMatchOpen");
      localaslx.jdField_l_of_type_Int = paramString.optInt("isSignalOpen");
      localaslx.p = paramString.optInt("coldPalaceGrayTipPosition", localaslx.p);
      return localaslx;
      label777:
      i += 1;
    }
  }
  
  public static ArrayList<String> a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramLong > 86400L)
    {
      localArrayList.add(String.valueOf((paramLong + 86400L - 1L) / 86400L));
      localArrayList.add(paramQQAppInterface.getApp().getString(2131691419));
      return localArrayList;
    }
    if (paramLong > 3600L)
    {
      localArrayList.add(String.valueOf((paramLong + 3600L - 1L) / 3600L));
      localArrayList.add(paramQQAppInterface.getApp().getString(2131693131));
      return localArrayList;
    }
    if (paramLong > 60L)
    {
      localArrayList.add(String.valueOf((paramLong + 60L - 1L) / 60L));
      localArrayList.add(paramQQAppInterface.getApp().getString(2131694022));
      return localArrayList;
    }
    if (paramLong > 0L)
    {
      localArrayList.add(String.valueOf(paramLong));
      localArrayList.add(paramQQAppInterface.getApp().getString(2131718413));
      return localArrayList;
    }
    localArrayList.add(String.valueOf(0));
    localArrayList.add(paramQQAppInterface.getApp().getString(2131718413));
    return localArrayList;
  }
  
  private void a(Context paramContext, assu paramassu)
  {
    if (paramassu == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, "getExtendFriendLocationInfoAsync start");
    }
    if ((!NetworkUtil.isNetSupport(paramContext)) || (!asru.a()))
    {
      a(false, null, paramassu);
      return;
    }
    long l = System.currentTimeMillis();
    if (l - this.jdField_d_of_type_Long < 3600000L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendManager", 2, "getExtendFriendLocationInfoAsync get cache");
      }
      paramContext = LbsManagerService.getCachedLbsInfo("extend_friend");
      if ((paramContext != null) && (paramContext.mLocation != null))
      {
        a(true, paramContext, paramassu);
        return;
      }
    }
    this.jdField_d_of_type_Long = l;
    LbsManagerService.startLocation(new aslv(this, "extend_friend", false, paramassu));
  }
  
  private static void a(QQAppInterface paramQQAppInterface, int paramInt, long paramLong)
  {
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = bhhr.a(paramQQAppInterface.getCurrentAccountUin(), "extend_friend_config_785").edit();
      paramQQAppInterface.putInt("sp_extend_friend_forbid_flag", paramInt);
      paramQQAppInterface.putLong("sp_extend_friend_forbid_end_time", paramLong);
      paramQQAppInterface.commit();
    }
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, String.format("setAnswerQuestionFlag, uin: %s, flag: %s", new Object[] { paramString, Boolean.valueOf(paramBoolean) }));
    }
    bhhr.g(paramString).edit().putBoolean("sp_extend_friend_question", paramBoolean).apply();
  }
  
  private void a(oidb_0xdb1.SchoolInfo paramSchoolInfo)
  {
    int j = 0;
    if (paramSchoolInfo != null)
    {
      this.jdField_a_of_type_Azrs = new azrs();
      Object localObject = this.jdField_a_of_type_Azrs;
      int i;
      if (paramSchoolInfo.uint32_idx.has())
      {
        i = paramSchoolInfo.uint32_idx.get();
        ((azrs)localObject).jdField_a_of_type_Int = i;
        localObject = this.jdField_a_of_type_Azrs;
        i = j;
        if (paramSchoolInfo.uint32_category.has()) {
          i = paramSchoolInfo.uint32_category.get();
        }
        ((azrs)localObject).jdField_b_of_type_Int = i;
        azrs localazrs = this.jdField_a_of_type_Azrs;
        if (!paramSchoolInfo.str_school_id.has()) {
          break label147;
        }
        localObject = paramSchoolInfo.str_school_id.get();
        label104:
        localazrs.jdField_a_of_type_JavaLangString = ((String)localObject);
        localObject = this.jdField_a_of_type_Azrs;
        if (!paramSchoolInfo.str_school_name.has()) {
          break label154;
        }
      }
      label147:
      label154:
      for (paramSchoolInfo = paramSchoolInfo.str_school_name.get();; paramSchoolInfo = "")
      {
        ((azrs)localObject).jdField_b_of_type_JavaLangString = paramSchoolInfo;
        return;
        i = 0;
        break;
        localObject = "";
        break label104;
      }
    }
    this.jdField_a_of_type_Azrs = null;
  }
  
  private void a(boolean paramBoolean, SosoInterface.SosoLbsInfo paramSosoLbsInfo, assu paramassu)
  {
    paramassu.a(paramBoolean, asmo.a(paramSosoLbsInfo));
  }
  
  public static boolean a(BaseActivity paramBaseActivity, QQAppInterface paramQQAppInterface)
  {
    if ((paramBaseActivity == null) || (paramQQAppInterface == null) || (paramBaseActivity.isFinishing())) {}
    int i;
    do
    {
      return false;
      i = a(paramQQAppInterface);
    } while (i == 0);
    long l = a(paramQQAppInterface) - NetConnInfoCenter.getServerTime();
    if ((i != 1) || (l > 8640000L)) {}
    for (boolean bool = true; (bool) || (l > 0L); bool = false)
    {
      QQCustomDialog localQQCustomDialog = bhdj.a(paramBaseActivity, 230);
      SpannableStringBuilder localSpannableStringBuilder = a(paramBaseActivity, paramBaseActivity.getString(2131698461), paramQQAppInterface, bool, l);
      localQQCustomDialog.setTitle(paramBaseActivity.getString(2131698463)).setMessage(localSpannableStringBuilder).setPositiveButton(paramBaseActivity.getString(2131698460), new aslr(paramBaseActivity)).setOnKeyListener(new aslq(paramBaseActivity));
      localQQCustomDialog.show();
      bdla.b(paramQQAppInterface, "dc00898", "", "", "0X800B076", "0X800B076", (int)(l / 86400L), 0, "", "", "", "");
      return true;
    }
    a(paramQQAppInterface, 0, 0L);
    return false;
  }
  
  public static boolean a(String paramString)
  {
    boolean bool = bhhr.g(paramString).getBoolean("sp_extend_friend_question", true);
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, "needAnswerQuestion: " + bool);
    }
    return bool;
  }
  
  private void d(boolean paramBoolean)
  {
    ((aslm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).notifyUI(5, true, Boolean.valueOf(paramBoolean));
  }
  
  private void e(boolean paramBoolean)
  {
    bhhr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "extend_friend_config_785").edit().putBoolean("sp_extend_friend_is_user_student", paramBoolean).commit();
  }
  
  private void f(boolean paramBoolean)
  {
    QLog.i("ExtendFriendManager", 2, "setExtendFriendUsing o " + paramBoolean);
    this.jdField_f_of_type_Boolean = paramBoolean;
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_d_of_type_Boolean = bhhr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "extend_friend_config_785").getBoolean("sp_extend_friend_is_user_student", false);
    }
  }
  
  private void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, String.format("checkToDownloadResource mConfig=%s mDownloader=%s", new Object[] { this.jdField_a_of_type_Aslx, this.jdField_a_of_type_Asma }));
    }
    if ((this.jdField_a_of_type_Aslx != null) && (this.jdField_a_of_type_Asma != null)) {
      try
      {
        this.jdField_a_of_type_Asma.a(this.jdField_a_of_type_Aslx.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_Aslx.jdField_h_of_type_JavaLangString);
        if (!this.jdField_a_of_type_Asma.a())
        {
          this.jdField_a_of_type_Asma.a();
          b(false);
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendManager", 2, String.format("checkToDownloadResource mResourceReady=%s", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean) }));
          }
          return;
          b(true);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("ExtendFriendManager", 1, "checkToDownloadResource fail.", localException);
        }
      }
    }
    if (this.jdField_a_of_type_Aslx == null)
    {
      QLog.e("ExtendFriendManager", 2, String.format("checkToDownloadResource mConfig is null", new Object[0]));
      return;
    }
    QLog.e("ExtendFriendManager", 2, String.format("checkToDownloadResource mDownloader is null", new Object[0]));
  }
  
  private void k()
  {
    String str = assx.a("expand_question_dialog.png");
    File localFile = new File(str);
    boolean bool = localFile.exists();
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, String.format("downloadQuestionRes, filePath:%s, isExist:%s", new Object[] { str, Boolean.valueOf(bool) }));
    }
    if (bool) {}
    int i;
    do
    {
      return;
      if ((this.jdField_a_of_type_Aslx == null) || (TextUtils.isEmpty(this.jdField_a_of_type_Aslx.jdField_j_of_type_JavaLangString))) {
        break label152;
      }
      i = bhyq.a(new bhyo(this.jdField_a_of_type_Aslx.jdField_j_of_type_JavaLangString, localFile), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (i != 0) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ExtendFriendManager", 2, "downloadQuestionRes success!");
    return;
    QLog.e("ExtendFriendManager", 1, String.format("downloadQuestionRes fail, ret = %s", new Object[] { Integer.valueOf(i) }));
    return;
    label152:
    QLog.e("ExtendFriendManager", 1, "downloadQuestionRes, config or url is empty!");
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {}
    for (;;)
    {
      try
      {
        Card localCard = ((anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
        if (localCard != null)
        {
          if (TextUtils.isEmpty(localCard.declaration)) {
            continue;
          }
          bool1 = true;
          boolean bool2 = localCard.isShowCard;
          if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendManager", 2, String.format("updateSwitchInCacheData profileComplete=%s showCard=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
          }
          if (jdField_a_of_type_Asnu != null)
          {
            jdField_a_of_type_Asnu.jdField_a_of_type_Boolean = bool1;
            jdField_a_of_type_Asnu.jdField_b_of_type_Boolean = bool2;
          }
        }
      }
      catch (Exception localException)
      {
        boolean bool1;
        QLog.e("ExtendFriendManager", 1, "updateSwitchInCacheData fail.", localException);
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendManager", 2, String.format("updateSwitchInCacheData %s", new Object[] { jdField_a_of_type_Asnu }));
      }
      return;
      bool1 = false;
    }
  }
  
  private void m()
  {
    SharedPreferences localSharedPreferences = bhhr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "extend_friend_config_785");
    long l1 = localSharedPreferences.getLong("sp_extend_friend_first_enter_everyday", 0L);
    long l2 = bcrg.a();
    boolean bool = false;
    if (l2 - l1 > 86400L) {
      bool = true;
    }
    for (;;)
    {
      if (bool) {
        localSharedPreferences.edit().putLong("sp_extend_friend_first_enter_everyday", l2).remove("sp_extend_friend_signal_everyday_report_" + l1).commit();
      }
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendManager", 2, "checkFirstEnterExtendFriendEveryDay first:" + l1 + " current:" + l2 + " isFirstTimeToday:" + bool);
      }
      return;
      Calendar localCalendar1 = Calendar.getInstance();
      localCalendar1.setTimeInMillis(1000L * l1);
      Calendar localCalendar2 = Calendar.getInstance();
      localCalendar2.setTimeInMillis(1000L * l2);
      if (localCalendar1.get(6) != localCalendar2.get(6)) {
        bool = true;
      }
    }
  }
  
  private void n()
  {
    SharedPreferences localSharedPreferences = bhhr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "extend_friend_config_785");
    long l1 = localSharedPreferences.getLong("sp_extend_friend_first_enter_everyday", 0L);
    if (l1 > 0L)
    {
      String str = "sp_extend_friend_signal_everyday_report_" + l1;
      boolean bool = localSharedPreferences.getBoolean(str, false);
      if (!bool)
      {
        long l2 = bcrg.a();
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AE99", "0X800AE99", 0, 0, String.valueOf(l2 - l1), "", "", "");
        localSharedPreferences.edit().putBoolean(str, true).commit();
      }
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendManager", 2, "checkReportForFirstReceiveCardEveryDay " + l1 + " " + bool);
      }
    }
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public aslx a()
  {
    return this.jdField_a_of_type_Aslx;
  }
  
  public asmo a()
  {
    SosoInterface.SosoLbsInfo localSosoLbsInfo = LbsManagerService.getCachedLbsInfo("extend_friend");
    asmo localasmo = null;
    if (localSosoLbsInfo != null) {
      localasmo = asmo.a(localSosoLbsInfo);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, "getExtendFriendLocationInfoSync " + localasmo);
    }
    long l = System.currentTimeMillis();
    if ((NetworkUtil.isNetSupport(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getBaseContext())) && (asru.a()) && (l - this.jdField_d_of_type_Long > 3600000L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendManager", 2, "getExtendFriendLocationInfoSync start");
      }
      this.jdField_d_of_type_Long = l;
      ThreadManager.getSubThreadHandler().post(new ExtendFriendManager.9(this));
    }
    return localasmo;
  }
  
  public asmp a()
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      if ((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.isEmpty())) {
        break label163;
      }
      long l = bcrg.a();
      Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        asmp localasmp2 = (asmp)localIterator.next();
        if (l - localasmp2.jdField_a_of_type_Long > 86400L)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendManager", 2, "checkAndGetLatestSignalBombCardData remove timeout data " + localasmp2.jdField_a_of_type_JavaLangString);
          }
          localIterator.remove();
        }
      }
    }
    if (!this.jdField_b_of_type_JavaUtilList.isEmpty())
    {
      asmp localasmp1 = (asmp)this.jdField_b_of_type_JavaUtilList.remove(0);
      return localasmp1;
    }
    label163:
    return null;
  }
  
  public asqa a()
  {
    return this.jdField_a_of_type_Asqa;
  }
  
  public asss a()
  {
    return this.jdField_a_of_type_Asss;
  }
  
  public azrs a()
  {
    return this.jdField_a_of_type_Azrs;
  }
  
  public ExtendFriendUserInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null) || (!this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.isOpen())) {
      return null;
    }
    return (ExtendFriendUserInfo)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.find(ExtendFriendUserInfo.class, paramString);
  }
  
  public ExtendFriendUserInfo a(String paramString, boolean paramBoolean)
  {
    ExtendFriendUserInfo localExtendFriendUserInfo2 = (ExtendFriendUserInfo)this.jdField_a_of_type_AndroidUtilLruCache.get(paramString);
    ExtendFriendUserInfo localExtendFriendUserInfo1 = localExtendFriendUserInfo2;
    if (localExtendFriendUserInfo2 == null)
    {
      localExtendFriendUserInfo1 = localExtendFriendUserInfo2;
      if (paramBoolean)
      {
        localExtendFriendUserInfo2 = a(paramString);
        localExtendFriendUserInfo1 = localExtendFriendUserInfo2;
        if (localExtendFriendUserInfo2 != null)
        {
          this.jdField_a_of_type_AndroidUtilLruCache.put(paramString, localExtendFriendUserInfo2);
          localExtendFriendUserInfo1 = localExtendFriendUserInfo2;
        }
      }
    }
    return localExtendFriendUserInfo1;
  }
  
  public String a()
  {
    int k = 0;
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
    {
      String str = String.valueOf(c());
      int i = str.length();
      int m = str.length() / 3 + i;
      int n = str.length() % 3;
      i = n;
      int j = m;
      if (n == 0)
      {
        i = n + 3;
        j = m - 1;
      }
      char[] arrayOfChar = new char[j];
      m = 0;
      j = k;
      k = i;
      i = m;
      if (i < arrayOfChar.length)
      {
        if (i == k)
        {
          k += 4;
          arrayOfChar[i] = ',';
          j += 1;
        }
        for (;;)
        {
          i += 1;
          break;
          arrayOfChar[i] = str.charAt(i - j);
        }
      }
      this.jdField_c_of_type_JavaLangString = new String(arrayOfChar);
    }
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public ArrayList<arhw> a()
  {
    return arhx.a().a();
  }
  
  public List<asqs> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public List<String> a(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramInt == 1)
    {
      String[] arrayOfString = bcur.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin());
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendManager", 2, String.format("getDefaultTags campusHotTags=%s", new Object[] { Arrays.toString(arrayOfString) }));
      }
      if ((arrayOfString != null) && (arrayOfString.length > 0))
      {
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        this.jdField_a_of_type_JavaUtilArrayList.addAll(Arrays.asList(arrayOfString));
      }
      paramInt = this.jdField_a_of_type_JavaUtilArrayList.size();
      if (paramInt > 0)
      {
        paramInt = Math.min(paramInt, 10);
        localArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList.subList(0, paramInt));
      }
    }
    for (;;)
    {
      localArrayList.add(0, jdField_a_of_type_JavaLangString);
      return localArrayList;
      paramInt = this.jdField_b_of_type_JavaUtilArrayList.size();
      if (paramInt > 0)
      {
        paramInt = Math.min(paramInt, 5);
        localArrayList.addAll(this.jdField_b_of_type_JavaUtilArrayList.subList(0, paramInt));
      }
    }
  }
  
  public oidb_0xdb1.SchoolInfo a()
  {
    return this.jdField_a_of_type_TencentImOidbCmd0xdb1Oidb_0xdb1$SchoolInfo;
  }
  
  public void a()
  {
    this.jdField_c_of_type_Long += 1L;
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, "increaseMatchedCount matchedCount = " + this.jdField_c_of_type_Long);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_f_of_type_Int = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, "updateCampusCertificateStatus campusCertificateStatus = " + this.jdField_e_of_type_Int + ",new status = " + paramInt1);
    }
    this.jdField_e_of_type_Int = paramInt1;
    assp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt1, paramInt2);
  }
  
  public void a(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, "updateCurExtendFriendSchoolInfo ,idx = " + paramInt1 + ",schoolName = " + paramString1 + ",schoolId = " + paramString2 + ",schoolCategory = " + paramInt2);
    }
    if (TextUtils.isEmpty(paramString1))
    {
      this.jdField_a_of_type_Azrs = null;
      return;
    }
    if (this.jdField_a_of_type_Azrs == null) {
      this.jdField_a_of_type_Azrs = new azrs();
    }
    this.jdField_a_of_type_Azrs.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_Azrs.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Azrs.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Azrs.jdField_b_of_type_Int = paramInt2;
  }
  
  public void a(Activity paramActivity)
  {
    ThreadManager.getSubThreadHandler().post(new ExtendFriendManager.5(this));
  }
  
  public void a(asmp paramasmp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, "addExtendFriendSignalBombCardData " + paramasmp);
    }
    if (paramasmp != null) {
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        if (this.jdField_b_of_type_JavaUtilList == null) {
          this.jdField_b_of_type_JavaUtilList = new ArrayList(5);
        }
        this.jdField_b_of_type_JavaUtilList.add(0, paramasmp);
        return;
      }
    }
  }
  
  public void a(asne paramasne)
  {
    Object localObject2;
    String str;
    Object localObject1;
    label185:
    int j;
    boolean bool;
    if (paramasne != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().c(paramasne.jdField_b_of_type_JavaLangString, paramasne.jdField_a_of_type_JavaLangString, paramasne.jdField_a_of_type_ArrayOfByte);
      if (k())
      {
        a(asmp.a(paramasne));
        if (paramasne.jdField_a_of_type_Asmk != null)
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          str = paramasne.jdField_b_of_type_JavaLangString;
          i = paramasne.jdField_a_of_type_Asmk.jdField_d_of_type_Int;
          if (!this.jdField_d_of_type_Boolean) {
            break label265;
          }
          localObject1 = "1";
          bdla.b((QQAppInterface)localObject2, "dc00898", "", str, "0X800AE9A", "0X800AE9A", i, 0, "", (String)localObject1, paramasne.jdField_a_of_type_Asmk.jdField_j_of_type_JavaLangString, paramasne.jdField_a_of_type_Asmk.jdField_k_of_type_JavaLangString);
        }
        n();
      }
      aweo.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramasne.jdField_b_of_type_JavaLangString);
      aweo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramasne.jdField_b_of_type_JavaLangString, 1044);
      if (((anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramasne.jdField_b_of_type_JavaLangString)) {
        break label273;
      }
      aweo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramasne, paramasne.jdField_a_of_type_Long, 1);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      localObject2 = paramasne.jdField_b_of_type_JavaLangString;
      j = paramasne.jdField_b_of_type_Int;
      str = paramasne.jdField_f_of_type_JavaLangString;
      if (TextUtils.isEmpty(paramasne.jdField_c_of_type_JavaLangString)) {
        break label286;
      }
      bool = true;
      label221:
      if (paramasne.jdField_a_of_type_Asmk == null) {
        break label292;
      }
    }
    label265:
    label273:
    label286:
    label292:
    for (int i = paramasne.jdField_a_of_type_Asmk.jdField_c_of_type_Int;; i = -1)
    {
      aweo.a((QQAppInterface)localObject1, (String)localObject2, j, str, bool, i, true, 4);
      ContactUtils.getBuddyName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramasne.jdField_b_of_type_JavaLangString, true);
      return;
      localObject1 = "2";
      break;
      QLog.d("ExtendFriendManager", 1, "updateSignalBombPush already friend.");
      break label185;
      bool = false;
      break label221;
    }
  }
  
  public void a(ExtendFriendUserInfo paramExtendFriendUserInfo)
  {
    if (paramExtendFriendUserInfo == null) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_AndroidUtilLruCache.put(paramExtendFriendUserInfo.uin, paramExtendFriendUserInfo);
      if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null) && (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.isOpen()))
      {
        if (paramExtendFriendUserInfo.getStatus() != 1000) {
          break label87;
        }
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.persistOrReplace(paramExtendFriendUserInfo);
      }
      while (QLog.isColorLevel())
      {
        QLog.d("ExtendFriendManager", 2, "updateExtendFriendUserInfo " + paramExtendFriendUserInfo);
        return;
        label87:
        if (paramExtendFriendUserInfo.getStatus() == 1001) {
          this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.update(paramExtendFriendUserInfo);
        }
      }
    }
  }
  
  @SuppressLint({"WrongConstant"})
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, oidb_0xdb1.RspBody paramRspBody)
  {
    Object localObject2 = "";
    int k = 0;
    int j;
    String str1;
    label45:
    int i;
    label62:
    label89:
    boolean bool;
    label98:
    String str2;
    label131:
    label140:
    label167:
    label191:
    Object localObject1;
    label219:
    label253:
    ArrayList localArrayList;
    label290:
    label329:
    label347:
    Iterator localIterator;
    if (paramRspBody.enum_school_verify_status.has())
    {
      j = paramRspBody.enum_school_verify_status.get();
      if (!paramRspBody.str_school_verify_tips.has()) {
        break label459;
      }
      str1 = paramRspBody.str_school_verify_tips.get();
      this.jdField_e_of_type_JavaLangString = str1;
      if (!TextUtils.isEmpty(str1)) {
        break label466;
      }
      i = 1;
      a(j, i);
      if (!paramRspBody.uint32_user_identity.has()) {
        break label472;
      }
      i = paramRspBody.uint32_user_identity.get();
      if (i != 1) {
        break label478;
      }
      bool = true;
      this.jdField_d_of_type_Boolean = bool;
      e(this.jdField_d_of_type_Boolean);
      if (!paramRspBody.uint32_need_display_school_info.has()) {
        break label484;
      }
      i = paramRspBody.uint32_need_display_school_info.get();
      if (i != 1) {
        break label490;
      }
      bool = true;
      this.jdField_c_of_type_Boolean = bool;
      if (!paramRspBody.msg_new_school_info.has()) {
        break label496;
      }
      paramFromServiceMsg = (oidb_0xdb1.SchoolInfo)paramRspBody.msg_new_school_info.get();
      this.jdField_a_of_type_TencentImOidbCmd0xdb1Oidb_0xdb1$SchoolInfo = paramFromServiceMsg;
      if (!paramRspBody.str_suggest_school_name.has()) {
        break label501;
      }
      str2 = paramRspBody.str_suggest_school_name.get();
      this.jdField_d_of_type_JavaLangString = str2;
      if (!paramRspBody.msg_kuolie_school_info.has()) {
        break label508;
      }
      localObject1 = (oidb_0xdb1.SchoolInfo)paramRspBody.msg_kuolie_school_info.get();
      a((oidb_0xdb1.SchoolInfo)localObject1);
      paramFromServiceMsg = (FromServiceMsg)localObject2;
      if (localObject1 != null)
      {
        if (!((oidb_0xdb1.SchoolInfo)localObject1).str_school_name.has()) {
          break label514;
        }
        paramFromServiceMsg = ((oidb_0xdb1.SchoolInfo)localObject1).str_school_name.get();
      }
      i = k;
      if (paramToServiceMsg.extraData.getBoolean("key_need_get_online_number", false))
      {
        if (!paramRspBody.uint32_online_num.has()) {
          break label520;
        }
        i = paramRspBody.uint32_online_num.get();
      }
      this.jdField_b_of_type_Int = i;
      if (!paramToServiceMsg.extraData.getBoolean("key_need_get_search_keywords", false)) {
        break label637;
      }
      if (!paramRspBody.msg_campus_search_keywords.has()) {
        break label526;
      }
      localObject1 = paramRspBody.msg_campus_search_keywords.get();
      if (!paramRspBody.msg_voice_search_keywords.has()) {
        break label532;
      }
      paramToServiceMsg = paramRspBody.msg_voice_search_keywords.get();
      localObject2 = new ArrayList();
      localArrayList = new ArrayList();
      if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
        break label544;
      }
      localIterator = ((List)localObject1).iterator();
    }
    label389:
    label520:
    label526:
    label532:
    label542:
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label544;
      }
      localObject1 = (oidb_0xdb1.SearchKeyWord)localIterator.next();
      if (((oidb_0xdb1.SearchKeyWord)localObject1).str_school_name.has()) {}
      for (localObject1 = ((oidb_0xdb1.SearchKeyWord)localObject1).str_school_name.get();; localObject1 = "")
      {
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label542;
        }
        ((List)localObject2).add(localObject1);
        break label389;
        j = 0;
        break;
        label459:
        str1 = "";
        break label45;
        label466:
        i = 2;
        break label62;
        label472:
        i = 0;
        break label89;
        label478:
        bool = false;
        break label98;
        label484:
        i = 0;
        break label131;
        label490:
        bool = false;
        break label140;
        label496:
        paramFromServiceMsg = null;
        break label167;
        label501:
        str2 = "";
        break label191;
        label508:
        localObject1 = null;
        break label219;
        paramFromServiceMsg = "";
        break label253;
        i = 0;
        break label290;
        localObject1 = null;
        break label329;
        paramToServiceMsg = null;
        break label347;
      }
    }
    label514:
    label544:
    if ((paramToServiceMsg != null) && (paramToServiceMsg.size() > 0))
    {
      localObject1 = paramToServiceMsg.iterator();
      label627:
      while (((Iterator)localObject1).hasNext())
      {
        paramToServiceMsg = (oidb_0xdb1.SearchKeyWord)((Iterator)localObject1).next();
        if (paramToServiceMsg.str_school_name.has()) {}
        for (paramToServiceMsg = paramToServiceMsg.str_school_name.get();; paramToServiceMsg = "")
        {
          if (TextUtils.isEmpty(paramToServiceMsg)) {
            break label627;
          }
          localArrayList.add(paramToServiceMsg);
          break;
        }
      }
    }
    a((List)localObject2, localArrayList);
    label637:
    long l;
    if (paramRspBody.uint32_forbid_flag.has())
    {
      k = paramRspBody.uint32_forbid_flag.get();
      if (!paramRspBody.uint32_forbid_end_time.has()) {
        break label883;
      }
      l = paramRspBody.uint32_forbid_end_time.get();
      label675:
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, k, l);
      if (!paramRspBody.bytes_birthday.has()) {
        break label889;
      }
    }
    label883:
    label889:
    for (int m = ByteBuffer.wrap(paramRspBody.bytes_birthday.get().toByteArray()).getInt();; m = 0)
    {
      this.jdField_c_of_type_Int = m;
      a(paramRspBody);
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendManager", 2, "handleGetExtendFriendPermissionAndStatusResponse. ,verifyStatus = " + j + ",verifyTips = " + str1 + ",serverSuggestSchoolName = " + str2 + ",schoolNameInExtendFriendCard = " + paramFromServiceMsg + ",onlineNumber = " + i + ",needShowEduBackgroundUpdateDialog = " + this.jdField_c_of_type_Boolean + ",profileNewSchoolInfo = " + this.jdField_a_of_type_TencentImOidbCmd0xdb1Oidb_0xdb1$SchoolInfo + ",isUserStudentOrNot = " + this.jdField_d_of_type_Boolean + ",userBirthday = " + this.jdField_c_of_type_Int + ",forbidFlag = " + k + ",forbidEndTime = " + l);
      }
      return;
      k = 0;
      break;
      l = 0L;
      break label675;
    }
  }
  
  public void a(String arg1)
  {
    aslx localaslx = a(???);
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_Aslx = localaslx;
      this.jdField_b_of_type_Boolean = true;
      boolean bool = asrl.a(this.jdField_a_of_type_Aslx);
      ThreadManager.getSubThreadHandler().post(new ExtendFriendManager.4(this, bool));
      return;
    }
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    ExtendFriendUserInfo localExtendFriendUserInfo2 = a(paramString, true);
    ExtendFriendUserInfo localExtendFriendUserInfo1 = localExtendFriendUserInfo2;
    if (localExtendFriendUserInfo2 == null) {
      localExtendFriendUserInfo1 = new ExtendFriendUserInfo();
    }
    localExtendFriendUserInfo1.uin = paramString;
    localExtendFriendUserInfo1.fromType = paramBundle.getInt("fromType", 3);
    a(localExtendFriendUserInfo1);
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, "getUnlimitMatchUserInfo() uin = " + paramString1 + " matchUin = " + paramString2 + "uinType=" + paramInt);
    }
    ((aslm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).a(paramString1, paramString2, paramInt);
  }
  
  public void a(List<String> paramList1, List<String> paramList2)
  {
    if (paramList2 != null)
    {
      this.jdField_b_of_type_JavaUtilArrayList.clear();
      this.jdField_b_of_type_JavaUtilArrayList.addAll(paramList2);
    }
  }
  
  public void a(oidb_0xdb1.RspBody paramRspBody)
  {
    long l2 = 0L;
    long l1;
    if (paramRspBody.uint64_max_match_times.has())
    {
      l1 = paramRspBody.uint64_max_match_times.get();
      this.jdField_b_of_type_Long = l1;
      l1 = l2;
      if (paramRspBody.uint64_matched_times.has()) {
        l1 = paramRspBody.uint64_matched_times.get();
      }
      this.jdField_c_of_type_Long = l1;
      if (!paramRspBody.msg_task_info.has()) {
        break label575;
      }
    }
    label575:
    for (paramRspBody = (oidb_0xdb1.matchTaskInfo)paramRspBody.msg_task_info.get();; paramRspBody = null)
    {
      ArrayList localArrayList = new ArrayList();
      if (paramRspBody != null)
      {
        asqs localasqs;
        if (paramRspBody.msg_base_info.has())
        {
          localasqs = new asqs();
          localasqs.jdField_a_of_type_Int = 1;
          localasqs.jdField_b_of_type_Int = paramRspBody.msg_base_info.uint32_task_match_times.get();
          localasqs.jdField_a_of_type_JavaLangString = paramRspBody.msg_base_info.str_msg.get();
          localasqs.jdField_c_of_type_Int = paramRspBody.msg_base_info.uint32_task_status.get();
          localArrayList.add(localasqs);
        }
        if (paramRspBody.msg_kuolie_school.has())
        {
          localasqs = new asqs();
          localasqs.jdField_a_of_type_Int = 2;
          localasqs.jdField_b_of_type_Int = paramRspBody.msg_kuolie_school.uint32_task_match_times.get();
          localasqs.jdField_a_of_type_JavaLangString = paramRspBody.msg_kuolie_school.str_msg.get();
          localasqs.jdField_c_of_type_Int = paramRspBody.msg_kuolie_school.uint32_task_status.get();
          localArrayList.add(localasqs);
        }
        if (paramRspBody.msg_kuolie_declaration.has())
        {
          localasqs = new asqs();
          localasqs.jdField_a_of_type_Int = 3;
          localasqs.jdField_b_of_type_Int = paramRspBody.msg_kuolie_declaration.uint32_task_match_times.get();
          localasqs.jdField_a_of_type_JavaLangString = paramRspBody.msg_kuolie_declaration.str_msg.get();
          localasqs.jdField_c_of_type_Int = paramRspBody.msg_kuolie_declaration.uint32_task_status.get();
          localArrayList.add(localasqs);
        }
        if (paramRspBody.msg_personal_label.has())
        {
          localasqs = new asqs();
          localasqs.jdField_a_of_type_Int = 4;
          localasqs.jdField_b_of_type_Int = paramRspBody.msg_personal_label.uint32_task_match_times.get();
          localasqs.jdField_a_of_type_JavaLangString = paramRspBody.msg_personal_label.str_msg.get();
          localasqs.jdField_c_of_type_Int = paramRspBody.msg_personal_label.uint32_task_status.get();
          localArrayList.add(localasqs);
        }
        if (paramRspBody.msg_photo.has())
        {
          localasqs = new asqs();
          localasqs.jdField_a_of_type_Int = 5;
          localasqs.jdField_b_of_type_Int = paramRspBody.msg_photo.uint32_task_match_times.get();
          localasqs.jdField_a_of_type_JavaLangString = paramRspBody.msg_photo.str_msg.get();
          localasqs.jdField_c_of_type_Int = paramRspBody.msg_photo.uint32_task_status.get();
          localArrayList.add(localasqs);
        }
      }
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll(localArrayList);
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendManager", 2, "updateMatchChatCompletePersonalDataTaskBy0xdb1 ,maxMatchCount" + this.jdField_b_of_type_Long + ",matchedCount" + this.jdField_c_of_type_Long + ",completePesonalDataTasks" + this.jdField_a_of_type_JavaUtilList);
      }
      return;
      l1 = 0L;
      break;
    }
  }
  
  public void a(oidb_0xe03.RspBody paramRspBody)
  {
    long l1 = 0L;
    int i;
    long l2;
    if (paramRspBody.enum_matchopretcode.has())
    {
      i = paramRspBody.enum_matchopretcode.get();
      if (12 != i) {
        break label618;
      }
      if (!paramRspBody.uint64_max_match_times.has()) {
        break label607;
      }
      l2 = paramRspBody.uint64_max_match_times.get();
      label45:
      this.jdField_b_of_type_Long = l2;
      if (paramRspBody.uint64_matched_times.has()) {
        l1 = paramRspBody.uint64_matched_times.get();
      }
      this.jdField_c_of_type_Long = l1;
      if (!paramRspBody.msg_task_info.has()) {
        break label613;
      }
      paramRspBody = (oidb_0xe03.matchTaskInfo)paramRspBody.msg_task_info.get();
      label95:
      ArrayList localArrayList = new ArrayList();
      if (paramRspBody != null)
      {
        asqs localasqs;
        if (paramRspBody.msg_base_info.has())
        {
          localasqs = new asqs();
          localasqs.jdField_a_of_type_Int = 1;
          localasqs.jdField_b_of_type_Int = paramRspBody.msg_base_info.uint32_task_match_times.get();
          localasqs.jdField_a_of_type_JavaLangString = paramRspBody.msg_base_info.str_msg.get();
          localasqs.jdField_c_of_type_Int = paramRspBody.msg_base_info.uint32_task_status.get();
          localArrayList.add(localasqs);
        }
        if (paramRspBody.msg_kuolie_school.has())
        {
          localasqs = new asqs();
          localasqs.jdField_a_of_type_Int = 2;
          localasqs.jdField_b_of_type_Int = paramRspBody.msg_kuolie_school.uint32_task_match_times.get();
          localasqs.jdField_a_of_type_JavaLangString = paramRspBody.msg_kuolie_school.str_msg.get();
          localasqs.jdField_c_of_type_Int = paramRspBody.msg_kuolie_school.uint32_task_status.get();
          localArrayList.add(localasqs);
        }
        if (paramRspBody.msg_kuolie_declaration.has())
        {
          localasqs = new asqs();
          localasqs.jdField_a_of_type_Int = 3;
          localasqs.jdField_b_of_type_Int = paramRspBody.msg_kuolie_declaration.uint32_task_match_times.get();
          localasqs.jdField_a_of_type_JavaLangString = paramRspBody.msg_kuolie_declaration.str_msg.get();
          localasqs.jdField_c_of_type_Int = paramRspBody.msg_kuolie_declaration.uint32_task_status.get();
          localArrayList.add(localasqs);
        }
        if (paramRspBody.msg_personal_label.has())
        {
          localasqs = new asqs();
          localasqs.jdField_a_of_type_Int = 4;
          localasqs.jdField_b_of_type_Int = paramRspBody.msg_personal_label.uint32_task_match_times.get();
          localasqs.jdField_a_of_type_JavaLangString = paramRspBody.msg_personal_label.str_msg.get();
          localasqs.jdField_c_of_type_Int = paramRspBody.msg_personal_label.uint32_task_status.get();
          localArrayList.add(localasqs);
        }
        if (paramRspBody.msg_photo.has())
        {
          localasqs = new asqs();
          localasqs.jdField_a_of_type_Int = 5;
          localasqs.jdField_b_of_type_Int = paramRspBody.msg_photo.uint32_task_match_times.get();
          localasqs.jdField_a_of_type_JavaLangString = paramRspBody.msg_photo.str_msg.get();
          localasqs.jdField_c_of_type_Int = paramRspBody.msg_photo.uint32_task_status.get();
          localArrayList.add(localasqs);
        }
      }
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll(localArrayList);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendManager", 2, "updateMatchChatCompletePersonalDataTaskBy0xe03 ,retCode " + i + ",maxMatchCount " + this.jdField_b_of_type_Long + ",matchedCount " + this.jdField_c_of_type_Long + ",completePesonalDataTasks " + this.jdField_a_of_type_JavaUtilList);
      }
      return;
      i = -1;
      break;
      label607:
      l2 = 0L;
      break label45;
      label613:
      paramRspBody = null;
      break label95;
      label618:
      if (i == 0)
      {
        if (paramRspBody.uint64_matched_times.has()) {
          l1 = paramRspBody.uint64_matched_times.get();
        }
        this.jdField_c_of_type_Long = l1;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    b(paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, String.format("onResourceDownloadComplete mResourceReady=%s", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean) }));
    }
    if (!paramBoolean) {
      QLog.e("ExtendFriendManager", 2, "onResourceDownloadComplete FAILED!");
    }
  }
  
  public boolean a()
  {
    if (b() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendManager", 2, "isAllCompleteDataTaskDone result = " + bool);
      }
      return bool;
    }
  }
  
  public boolean a(aslx paramaslx)
  {
    boolean bool = true;
    if ((paramaslx == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return false;
    }
    for (;;)
    {
      try
      {
        paramaslx = bhhr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "extend_friend_config_785");
        int i = paramaslx.getInt("sp_extend_friend_entry_contact", 0);
        int j = paramaslx.getInt("sp_extend_friend_entry_add_friend", 0);
        if ((i != 1) || (j != 1)) {
          break label88;
        }
        return bool;
      }
      catch (Exception paramaslx)
      {
        paramaslx.printStackTrace();
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("ExtendFriendManager", 2, paramaslx.getMessage());
      return false;
      label88:
      bool = false;
    }
  }
  
  public int b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      if (((asqs)localIterator.next()).jdField_c_of_type_Int == 2) {
        break label79;
      }
      i += 1;
    }
    label79:
    for (;;)
    {
      break;
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendManager", 2, "getUnFinishedCompletePeronalInfoTaskCount count = " + i);
      }
      return i;
    }
  }
  
  public long b()
  {
    return this.jdField_c_of_type_Long;
  }
  
  public aslx b()
  {
    if (!b()) {
      b();
    }
    return this.jdField_a_of_type_Aslx;
  }
  
  public asqa b()
  {
    return this.jdField_b_of_type_Asqa;
  }
  
  public String b()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (b())
    {
      aslx localaslx = a();
      localObject1 = localObject2;
      if (localaslx != null) {
        localObject1 = localaslx.jdField_i_of_type_JavaLangString;
      }
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = anvx.a(2131703744);
    }
    return localObject2;
  }
  
  public List<String> b(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramInt == 1) {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
        localArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
      }
    }
    while (this.jdField_b_of_type_JavaUtilArrayList.size() <= 0) {
      return localArrayList;
    }
    localArrayList.addAll(this.jdField_b_of_type_JavaUtilArrayList);
    return localArrayList;
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 695	aslo:jdField_b_of_type_Boolean	Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: getfield 94	aslo:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   12: invokevirtual 538	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   15: aload_0
    //   16: getfield 94	aslo:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   19: invokevirtual 152	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   22: ldc 154
    //   24: invokestatic 1509	bhdc:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   27: astore_1
    //   28: aload_1
    //   29: invokestatic 844	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   32: ifne +76 -> 108
    //   35: aload_0
    //   36: aload_1
    //   37: invokespecial 1349	aslo:a	(Ljava/lang/String;)Laslx;
    //   40: astore_2
    //   41: getstatic 52	aslo:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   44: astore_1
    //   45: aload_1
    //   46: monitorenter
    //   47: aload_0
    //   48: getfield 695	aslo:jdField_b_of_type_Boolean	Z
    //   51: ifne +13 -> 64
    //   54: aload_0
    //   55: aload_2
    //   56: putfield 287	aslo:jdField_a_of_type_Aslx	Laslx;
    //   59: aload_0
    //   60: iconst_1
    //   61: putfield 695	aslo:jdField_b_of_type_Boolean	Z
    //   64: aload_1
    //   65: monitorexit
    //   66: invokestatic 421	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   69: ifeq -62 -> 7
    //   72: ldc_w 423
    //   75: iconst_2
    //   76: ldc_w 1511
    //   79: invokestatic 797	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   82: return
    //   83: astore_1
    //   84: invokestatic 421	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   87: ifeq -80 -> 7
    //   90: ldc_w 423
    //   93: iconst_2
    //   94: aload_1
    //   95: invokevirtual 1495	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   98: aload_1
    //   99: invokestatic 1513	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   102: return
    //   103: astore_2
    //   104: aload_1
    //   105: monitorexit
    //   106: aload_2
    //   107: athrow
    //   108: getstatic 52	aslo:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   111: astore_1
    //   112: aload_1
    //   113: monitorenter
    //   114: aload_0
    //   115: getfield 695	aslo:jdField_b_of_type_Boolean	Z
    //   118: ifne +8 -> 126
    //   121: aload_0
    //   122: iconst_1
    //   123: putfield 695	aslo:jdField_b_of_type_Boolean	Z
    //   126: aload_1
    //   127: monitorexit
    //   128: ldc_w 423
    //   131: iconst_2
    //   132: ldc_w 1515
    //   135: invokestatic 822	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   138: goto -72 -> 66
    //   141: astore_2
    //   142: aload_1
    //   143: monitorexit
    //   144: aload_2
    //   145: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	this	aslo
    //   83	22	1	localException	Exception
    //   40	16	2	localaslx	aslx
    //   103	4	2	localObject3	Object
    //   141	4	2	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   8	28	83	java/lang/Exception
    //   47	64	103	finally
    //   64	66	103	finally
    //   104	106	103	finally
    //   114	126	141	finally
    //   126	128	141	finally
    //   142	144	141	finally
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    d(paramBoolean);
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public int c()
  {
    if (this.jdField_a_of_type_Int == 0) {
      if ((this.jdField_a_of_type_Aslx == null) || (this.jdField_a_of_type_Aslx.jdField_a_of_type_Int <= 0)) {
        break label66;
      }
    }
    label66:
    for (this.jdField_a_of_type_Int = (this.jdField_a_of_type_Aslx.jdField_b_of_type_Int + new Random().nextInt(this.jdField_a_of_type_Aslx.jdField_a_of_type_Int - this.jdField_a_of_type_Aslx.jdField_b_of_type_Int));; this.jdField_a_of_type_Int = new Random().nextInt(10000000)) {
      return this.jdField_a_of_type_Int;
    }
  }
  
  public long c()
  {
    long l1 = 0L;
    long l2 = this.jdField_b_of_type_Long - this.jdField_c_of_type_Long;
    if (l2 < 0L) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendManager", 2, String.format("getLeftMatchCount max:%d,matched:%d,left:%d", new Object[] { Long.valueOf(this.jdField_b_of_type_Long), Long.valueOf(this.jdField_c_of_type_Long), Long.valueOf(l1) }));
      }
      return l1;
      l1 = l2;
    }
  }
  
  public String c()
  {
    String str2 = "";
    String str1 = str2;
    if (b())
    {
      str1 = str2;
      if (this.jdField_a_of_type_Aslx != null) {
        str1 = this.jdField_a_of_type_Aslx.jdField_k_of_type_JavaLangString;
      }
    }
    return str1;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, "updateMatchChatConfig ");
    }
    ((aslm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).notifyUI(18, true, null);
  }
  
  public void c(boolean paramBoolean)
  {
    QLog.i("ExtendFriendManager", 2, "setSingalBombWaiting o " + paramBoolean);
    this.jdField_e_of_type_Boolean = paramBoolean;
  }
  
  public boolean c()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public int d()
  {
    int j = 2147483647;
    int i = j;
    if (b())
    {
      i = j;
      if (this.jdField_a_of_type_Aslx != null) {
        i = this.jdField_a_of_type_Aslx.n;
      }
    }
    return i;
  }
  
  public String d()
  {
    String str2 = "";
    String str1 = str2;
    if (b())
    {
      str1 = str2;
      if (this.jdField_a_of_type_Aslx != null) {
        str1 = this.jdField_a_of_type_Aslx.jdField_l_of_type_JavaLangString;
      }
    }
    return str1;
  }
  
  public void d()
  {
    this.jdField_a_of_type_AndroidUtilLruCache.evictAll();
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null) && (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.isOpen())) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.drop(ExtendFriendUserInfo.class);
    }
  }
  
  public boolean d()
  {
    if (!this.jdField_a_of_type_Boolean) {
      QLog.e("ExtendFriendManager", 2, "isResourceReady NOT READY!");
    }
    return this.jdField_a_of_type_Boolean;
  }
  
  public int e()
  {
    return this.jdField_e_of_type_Int;
  }
  
  public String e()
  {
    String str2 = "";
    String str1 = str2;
    if (b())
    {
      str1 = str2;
      if (this.jdField_a_of_type_Aslx != null) {
        str1 = this.jdField_a_of_type_Aslx.jdField_m_of_type_JavaLangString;
      }
    }
    return str1;
  }
  
  public void e()
  {
    f(true);
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getBaseContext(), new aslt(this));
    m();
  }
  
  public boolean e()
  {
    if ((b()) && (this.jdField_a_of_type_Aslx != null)) {}
    for (int i = this.jdField_a_of_type_Aslx.o;; i = 1) {
      return i == 1;
    }
  }
  
  public int f()
  {
    int j = 1;
    int i = j;
    if (b())
    {
      i = j;
      if (this.jdField_a_of_type_Aslx != null)
      {
        j = this.jdField_a_of_type_Aslx.p;
        i = j;
        if (QLog.isColorLevel())
        {
          QLog.d("ExtendFriendManager", 2, "coldPalaceGrayTipPosition  " + j);
          i = j;
        }
      }
    }
    return i;
  }
  
  public String f()
  {
    return this.jdField_d_of_type_JavaLangString;
  }
  
  public void f()
  {
    f(false);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      ((aslm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).b();
    }
  }
  
  public boolean f()
  {
    boolean bool2 = false;
    boolean bool3 = assp.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    boolean bool1 = bool2;
    if (bool3) {
      if ((this.jdField_e_of_type_Int != 0) && (this.jdField_e_of_type_Int != 2))
      {
        bool1 = bool2;
        if (this.jdField_e_of_type_Int != 3) {}
      }
      else
      {
        bool1 = true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, "isNeedShowCertificateBanner result = " + bool1 + ",showFlag = " + bool3);
    }
    return bool1;
  }
  
  public int g()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public String g()
  {
    if (this.jdField_a_of_type_Azrs != null) {
      return this.jdField_a_of_type_Azrs.jdField_b_of_type_JavaLangString;
    }
    return "";
  }
  
  public void g()
  {
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getBaseContext(), new aslu(this));
  }
  
  public boolean g()
  {
    if (this.jdField_a_of_type_Aslx == null) {}
    while (this.jdField_a_of_type_Aslx.jdField_i_of_type_Int != 1) {
      return false;
    }
    return true;
  }
  
  public void h()
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      if (this.jdField_b_of_type_JavaUtilList != null) {
        this.jdField_b_of_type_JavaUtilList.clear();
      }
      return;
    }
  }
  
  public boolean h()
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_Aslx != null) && (this.jdField_a_of_type_Aslx.jdField_k_of_type_Int == 1)) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendManager", 2, "bVoiceMatchOpen  " + bool);
      }
      return bool;
      bool = false;
    }
  }
  
  public boolean i()
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_Aslx != null) && (this.jdField_a_of_type_Aslx.jdField_l_of_type_Int == 1)) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendManager", 2, "bSignalBombOpen  " + bool);
      }
      return bool;
      bool = false;
    }
  }
  
  public boolean j()
  {
    QLog.i("ExtendFriendManager", 2, "getIsSingalBombWaiting o " + this.jdField_e_of_type_Boolean);
    return this.jdField_e_of_type_Boolean;
  }
  
  public boolean k()
  {
    QLog.i("ExtendFriendManager", 2, "getIsExtendFriendUsing " + this.jdField_f_of_type_Boolean);
    return this.jdField_f_of_type_Boolean;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aslz);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    if (this.jdField_a_of_type_Asma != null)
    {
      this.jdField_a_of_type_Asma.b();
      this.jdField_a_of_type_Asma.a(null);
      this.jdField_a_of_type_Asma = null;
      this.jdField_a_of_type_Boolean = false;
    }
    jdField_a_of_type_Asnu = null;
    if (this.jdField_a_of_type_AndroidUtilLruCache != null) {
      this.jdField_a_of_type_AndroidUtilLruCache.evictAll();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aslo
 * JD-Core Version:    0.7.0.1
 */