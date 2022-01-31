import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager.3;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager.4;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager.5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class anoe
  implements anop, Manager
{
  public static anpx a;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  public static final String a;
  private int jdField_a_of_type_Int;
  private ajfo jdField_a_of_type_Ajfo = new anof(this);
  private anoh jdField_a_of_type_Anoh;
  private anoj jdField_a_of_type_Anoj = new anog(this);
  private anok jdField_a_of_type_Anok;
  private anrt jdField_a_of_type_Anrt;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean jdField_a_of_type_Boolean;
  public String b;
  private boolean b;
  private String c;
  
  static
  {
    jdField_a_of_type_JavaLangString = ajjy.a(2131638482);
  }
  
  public anoe(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajfo);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anoj);
    this.jdField_a_of_type_Anok = new anok(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Anok.a(this);
    this.jdField_a_of_type_Anrt = new anrt(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    ThreadManager.postImmediately(new ExtendFriendManager.3(this), null, true);
  }
  
  private anoh a(String paramString)
  {
    int j = 0;
    anoh localanoh = new anoh();
    for (;;)
    {
      int i;
      try
      {
        paramString = new JSONObject(paramString);
        localanoh.jdField_a_of_type_JavaLangString = paramString.optString("contactEntranceTitle");
        localanoh.jdField_b_of_type_JavaLangString = paramString.optString("contactEntranceLine1");
        localanoh.jdField_c_of_type_JavaLangString = paramString.optString("contactEntranceLine2");
        localanoh.jdField_d_of_type_JavaLangString = paramString.optString("addEntranceTitle");
        localanoh.jdField_e_of_type_JavaLangString = paramString.optString("addEntranceLine1");
        localanoh.jdField_a_of_type_Int = paramString.optInt("maxPlayers");
        localanoh.jdField_b_of_type_Int = paramString.optInt("minPlayers");
        localanoh.jdField_c_of_type_Int = paramString.optInt("voiceMaxLength");
        localanoh.jdField_d_of_type_Int = paramString.optInt("maxSlipTimes");
        localanoh.jdField_e_of_type_Int = paramString.optInt("redisplayInterval");
        localanoh.jdField_f_of_type_JavaLangString = paramString.optString("defaultDecleration");
        localanoh.jdField_f_of_type_Int = paramString.optInt("declerationMinLen");
        localanoh.jdField_g_of_type_Int = paramString.optInt("isExpandEntranceOnTop");
        localanoh.jdField_g_of_type_JavaLangString = paramString.optString("resourceURL");
        localanoh.jdField_h_of_type_JavaLangString = paramString.optString("resourceMD5");
        localanoh.jdField_h_of_type_Int = paramString.optInt("isShowGroup");
        localanoh.jdField_j_of_type_JavaLangString = paramString.optString("ExpandExamImg");
        localanoh.jdField_j_of_type_Int = paramString.optInt("exposureTimeLimit", 2);
        localanoh.jdField_a_of_type_Boolean = paramString.optBoolean("showVipIcon", false);
        localanoh.jdField_k_of_type_Int = paramString.optInt("GrayTipsMsgCount", 50);
        localanoh.jdField_k_of_type_JavaLangString = paramString.optString("GrayTipsMsg");
        localanoh.jdField_l_of_type_JavaLangString = paramString.optString("GrayTipsMsgLight");
        localanoh.jdField_l_of_type_Int = paramString.optInt("IceBreakSwitch", 1);
        localanoh.m = paramString.optString("BeatWarning");
        if (QLog.isColorLevel()) {
          QLog.d("ExtendFriendManager", 2, "parseConfig config.exposureTimeLimit:" + localanoh.jdField_j_of_type_Int);
        }
        localanoh.jdField_a_of_type_JavaUtilList.clear();
        JSONArray localJSONArray = paramString.optJSONArray("defaultTags");
        if (localJSONArray != null)
        {
          i = 0;
          if (i < localJSONArray.length())
          {
            localanoh.jdField_a_of_type_JavaUtilList.add(localJSONArray.optString(i));
            i += 1;
            continue;
          }
        }
        localanoh.jdField_b_of_type_JavaUtilList.clear();
        localJSONArray = paramString.optJSONArray("searchTags");
        if (localJSONArray != null)
        {
          i = 0;
          if (i < localJSONArray.length())
          {
            localanoh.jdField_b_of_type_JavaUtilList.add(localJSONArray.optString(i));
            i += 1;
            continue;
          }
        }
        localanoh.jdField_i_of_type_JavaLangString = paramString.optString("searchHint");
        localJSONArray = paramString.optJSONArray("ExpandMatchRes");
        if (localJSONArray != null)
        {
          i = j;
          if (i < localJSONArray.length())
          {
            JSONObject localJSONObject = localJSONArray.optJSONObject(i);
            if (localJSONObject == null) {
              break label666;
            }
            anoi localanoi = new anoi(this);
            localanoi.jdField_a_of_type_JavaLangString = localJSONObject.optString("name");
            if ("aioVideo".equals(localanoi.jdField_a_of_type_JavaLangString))
            {
              localanoi.jdField_b_of_type_JavaLangString = localJSONObject.optString("resourceURLAndroid");
              localanoi.jdField_c_of_type_JavaLangString = localJSONObject.optString("resourceMD5Android");
              if (QLog.isColorLevel()) {
                QLog.d("ExtendFriendManager", 2, String.format("aiovideo use android url:%s", new Object[] { localanoi.jdField_b_of_type_JavaLangString }));
              }
              if (!localanoi.a()) {
                break label666;
              }
              localanoh.jdField_a_of_type_JavaUtilHashMap.put(localanoi.jdField_a_of_type_JavaLangString, localanoi);
              break label666;
            }
            localanoi.jdField_b_of_type_JavaLangString = localJSONObject.optString("resourceURL");
            localanoi.jdField_c_of_type_JavaLangString = localJSONObject.optString("resourceMD5");
            continue;
          }
        }
        localanoh.jdField_i_of_type_Int = paramString.optInt("ExpandMatchSwitch");
      }
      catch (JSONException paramString)
      {
        QLog.e("ExtendFriendManager", 2, "parseConfig fail.", paramString);
        return null;
      }
      return localanoh;
      label666:
      i += 1;
    }
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, String.format("setAnswerQuestionFlag, uin: %s, flag: %s", new Object[] { paramString, Boolean.valueOf(paramBoolean) }));
    }
    baig.g(paramString).edit().putBoolean("sp_extend_friend_question", paramBoolean).apply();
  }
  
  public static boolean a(String paramString)
  {
    boolean bool = baig.g(paramString).getBoolean("sp_extend_friend_question", true);
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, "needAnswerQuestion: " + bool);
    }
    return bool;
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, String.format("checkToDownloadResource mConfig=%s mDownloader=%s", new Object[] { this.jdField_a_of_type_Anoh, this.jdField_a_of_type_Anok }));
    }
    if ((this.jdField_a_of_type_Anoh != null) && (this.jdField_a_of_type_Anok != null)) {}
    try
    {
      this.jdField_a_of_type_Anok.a(this.jdField_a_of_type_Anoh.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_Anoh.jdField_h_of_type_JavaLangString);
      if (!this.jdField_a_of_type_Anok.a())
      {
        this.jdField_a_of_type_Anok.a();
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
  
  private void c()
  {
    String str = antz.a("expand_question_dialog.png");
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
      if ((this.jdField_a_of_type_Anoh == null) || (TextUtils.isEmpty(this.jdField_a_of_type_Anoh.jdField_j_of_type_JavaLangString))) {
        break label149;
      }
      i = bato.a(new batm(this.jdField_a_of_type_Anoh.jdField_j_of_type_JavaLangString, localFile), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (i != 0) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ExtendFriendManager", 2, "downloadQuestionRes success!");
    return;
    QLog.e("ExtendFriendManager", 1, String.format("downloadQuestionRes fail, ret = %s", new Object[] { Integer.valueOf(i) }));
    return;
    label149:
    QLog.e("ExtendFriendManager", 1, "downloadQuestionRes, config or url is empty!");
  }
  
  private void c(boolean paramBoolean)
  {
    ((anod)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(127)).notifyUI(5, true, Boolean.valueOf(paramBoolean));
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {}
    for (;;)
    {
      try
      {
        Card localCard = ((ajjj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
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
          if (jdField_a_of_type_Anpx != null)
          {
            jdField_a_of_type_Anpx.jdField_a_of_type_Boolean = bool1;
            jdField_a_of_type_Anpx.b = bool2;
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
        QLog.d("ExtendFriendManager", 2, String.format("updateSwitchInCacheData %s", new Object[] { jdField_a_of_type_Anpx }));
      }
      return;
      bool1 = false;
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Int == 0) {
      if ((this.jdField_a_of_type_Anoh == null) || (this.jdField_a_of_type_Anoh.jdField_a_of_type_Int <= 0)) {
        break label66;
      }
    }
    label66:
    for (this.jdField_a_of_type_Int = (this.jdField_a_of_type_Anoh.jdField_b_of_type_Int + new Random().nextInt(this.jdField_a_of_type_Anoh.jdField_a_of_type_Int - this.jdField_a_of_type_Anoh.jdField_b_of_type_Int));; this.jdField_a_of_type_Int = new Random().nextInt(10000000)) {
      return this.jdField_a_of_type_Int;
    }
  }
  
  public anoh a()
  {
    return this.jdField_a_of_type_Anoh;
  }
  
  public anrt a()
  {
    return this.jdField_a_of_type_Anrt;
  }
  
  public String a()
  {
    int k = 0;
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
    {
      String str = String.valueOf(a());
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
  
  public ArrayList<amhe> a()
  {
    return amhf.a().a();
  }
  
  public List<String> a()
  {
    ArrayList localArrayList = new ArrayList();
    if (a())
    {
      anoh localanoh = a();
      if (localanoh == null) {
        break label105;
      }
      localArrayList.addAll(localanoh.jdField_a_of_type_JavaUtilList);
    }
    for (;;)
    {
      if (localArrayList.size() == 0)
      {
        localArrayList.add(ajjy.a(2131638483));
        localArrayList.add(ajjy.a(2131638484));
        localArrayList.add(ajjy.a(2131638472));
        localArrayList.add(ajjy.a(2131638480));
        localArrayList.add(ajjy.a(2131638463));
      }
      localArrayList.add(0, jdField_a_of_type_JavaLangString);
      return localArrayList;
      label105:
      QLog.e("ExtendFriendManager", 2, "getDefaultTags CONFIG IS NULL ");
    }
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 365	anoe:b	Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: getfield 53	anoe:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   12: invokevirtual 545	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   15: aload_0
    //   16: getfield 53	anoe:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   19: invokevirtual 548	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   22: ldc_w 550
    //   25: invokestatic 555	babf:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   28: astore_1
    //   29: aload_1
    //   30: invokestatic 414	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   33: ifne +74 -> 107
    //   36: aload_0
    //   37: aload_1
    //   38: invokespecial 557	anoe:a	(Ljava/lang/String;)Lanoh;
    //   41: astore_2
    //   42: getstatic 37	anoe:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   45: astore_1
    //   46: aload_1
    //   47: monitorenter
    //   48: aload_0
    //   49: getfield 365	anoe:b	Z
    //   52: ifne +13 -> 65
    //   55: aload_0
    //   56: aload_2
    //   57: putfield 85	anoe:jdField_a_of_type_Anoh	Lanoh;
    //   60: aload_0
    //   61: iconst_1
    //   62: putfield 365	anoe:b	Z
    //   65: aload_1
    //   66: monitorexit
    //   67: invokestatic 221	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   70: ifeq -63 -> 7
    //   73: ldc 223
    //   75: iconst_2
    //   76: ldc_w 559
    //   79: invokestatic 561	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   82: return
    //   83: astore_1
    //   84: invokestatic 221	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   87: ifeq -80 -> 7
    //   90: ldc 223
    //   92: iconst_2
    //   93: aload_1
    //   94: invokevirtual 564	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   97: aload_1
    //   98: invokestatic 566	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   101: return
    //   102: astore_2
    //   103: aload_1
    //   104: monitorexit
    //   105: aload_2
    //   106: athrow
    //   107: getstatic 37	anoe:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   110: astore_1
    //   111: aload_1
    //   112: monitorenter
    //   113: aload_0
    //   114: getfield 365	anoe:b	Z
    //   117: ifne +8 -> 125
    //   120: aload_0
    //   121: iconst_1
    //   122: putfield 365	anoe:b	Z
    //   125: aload_1
    //   126: monitorexit
    //   127: goto -60 -> 67
    //   130: astore_2
    //   131: aload_1
    //   132: monitorexit
    //   133: aload_2
    //   134: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	this	anoe
    //   83	21	1	localException	Exception
    //   41	16	2	localanoh	anoh
    //   102	4	2	localObject3	Object
    //   130	4	2	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   8	29	83	java/lang/Exception
    //   48	65	102	finally
    //   65	67	102	finally
    //   103	105	102	finally
    //   113	125	130	finally
    //   125	127	130	finally
    //   131	133	130	finally
  }
  
  public void a(Activity paramActivity)
  {
    ThreadManager.getSubThreadHandler().post(new ExtendFriendManager.5(this));
  }
  
  public void a(String arg1)
  {
    anoh localanoh = a(???);
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_Anoh = localanoh;
      this.b = true;
      boolean bool = ansv.a(this.jdField_a_of_type_Anoh);
      ThreadManager.getSubThreadHandler().post(new ExtendFriendManager.4(this, bool));
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    b(paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, String.format("onResourceDownloadComplete mResourceReady=%s", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean) }));
    }
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  public boolean a(anoh paramanoh)
  {
    boolean bool = true;
    if ((paramanoh == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return false;
    }
    for (;;)
    {
      try
      {
        paramanoh = baig.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "extend_friend_config_785");
        int i = paramanoh.getInt("sp_extend_friend_entry_contact", 0);
        int j = paramanoh.getInt("sp_extend_friend_entry_add_friend", 0);
        if ((i != 1) || (j != 1)) {
          break label88;
        }
        return bool;
      }
      catch (Exception paramanoh)
      {
        paramanoh.printStackTrace();
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("ExtendFriendManager", 2, paramanoh.getMessage());
      return false;
      label88:
      bool = false;
    }
  }
  
  public int b()
  {
    int j = 2147483647;
    int i = j;
    if (a())
    {
      i = j;
      if (this.jdField_a_of_type_Anoh != null) {
        i = this.jdField_a_of_type_Anoh.jdField_k_of_type_Int;
      }
    }
    return i;
  }
  
  public anoh b()
  {
    if (!a()) {
      a();
    }
    return this.jdField_a_of_type_Anoh;
  }
  
  public String b()
  {
    String str1 = null;
    if (a()) {
      str1 = a().jdField_i_of_type_JavaLangString;
    }
    String str2 = str1;
    if (TextUtils.isEmpty(str1)) {
      str2 = ajjy.a(2131638479);
    }
    return str2;
  }
  
  public List<String> b()
  {
    ArrayList localArrayList = new ArrayList();
    if (a()) {
      localArrayList.addAll(a().jdField_b_of_type_JavaUtilList);
    }
    if (localArrayList.size() == 0)
    {
      localArrayList.add(ajjy.a(2131638456));
      localArrayList.add(ajjy.a(2131638451));
      localArrayList.add(ajjy.a(2131638487));
      localArrayList.add(ajjy.a(2131638455));
      localArrayList.add("语C");
      localArrayList.add(ajjy.a(2131638466));
      localArrayList.add(ajjy.a(2131638467));
      localArrayList.add(ajjy.a(2131638486));
    }
    return localArrayList;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    c(paramBoolean);
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public String c()
  {
    String str2 = "";
    String str1 = str2;
    if (a())
    {
      str1 = str2;
      if (this.jdField_a_of_type_Anoh != null) {
        str1 = this.jdField_a_of_type_Anoh.jdField_k_of_type_JavaLangString;
      }
    }
    return str1;
  }
  
  public boolean c()
  {
    if ((a()) && (this.jdField_a_of_type_Anoh != null)) {}
    for (int i = this.jdField_a_of_type_Anoh.jdField_l_of_type_Int;; i = 1) {
      return i == 1;
    }
  }
  
  public String d()
  {
    String str2 = "";
    String str1 = str2;
    if (a())
    {
      str1 = str2;
      if (this.jdField_a_of_type_Anoh != null) {
        str1 = this.jdField_a_of_type_Anoh.jdField_l_of_type_JavaLangString;
      }
    }
    return str1;
  }
  
  public boolean d()
  {
    if (this.jdField_a_of_type_Anoh == null) {}
    while (this.jdField_a_of_type_Anoh.jdField_i_of_type_Int != 1) {
      return false;
    }
    return true;
  }
  
  public String e()
  {
    String str2 = "";
    String str1 = str2;
    if (a())
    {
      str1 = str2;
      if (this.jdField_a_of_type_Anoh != null) {
        str1 = this.jdField_a_of_type_Anoh.m;
      }
    }
    return str1;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajfo);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anoj);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    if (this.jdField_a_of_type_Anok != null)
    {
      this.jdField_a_of_type_Anok.b();
      this.jdField_a_of_type_Anok.a(null);
      this.jdField_a_of_type_Anok = null;
      this.jdField_a_of_type_Boolean = false;
    }
    jdField_a_of_type_Anpx = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     anoe
 * JD-Core Version:    0.7.0.1
 */