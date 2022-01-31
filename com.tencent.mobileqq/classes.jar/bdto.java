import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.data.BmqqUserSimpleInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qidian.QidianManager.1;
import com.tencent.qidian.QidianManager.10;
import com.tencent.qidian.QidianManager.2;
import com.tencent.qidian.QidianManager.3;
import com.tencent.qidian.QidianManager.4;
import com.tencent.qidian.QidianManager.6;
import com.tencent.qidian.QidianManager.7;
import com.tencent.qidian.QidianManager.8;
import com.tencent.qidian.QidianManager.9;
import com.tencent.qidian.data.BmqqAccountType;
import com.tencent.qidian.data.QidianCorpInfo;
import com.tencent.qidian.data.QidianExternalInfo;
import com.tencent.qidian.data.QidianInternalInfo;
import com.tencent.qidian.data.QidianPAForWpa;
import com.tencent.qidian.data.QidianProfileUiInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class bdto
  implements Manager
{
  public static final AtomicBoolean a;
  public AppInterface a;
  private List<bdtq> a;
  public Map<String, Integer> a;
  public Map<String, QidianExternalInfo> b;
  public Map<String, QidianInternalInfo> c;
  public Map<String, QidianCorpInfo> d;
  public Map<String, QidianProfileUiInfo> e;
  public Map<String, BmqqUserSimpleInfo> f;
  public Map<String, QidianPAForWpa> g;
  public Map<String, String> h;
  public Map<String, List<MessageRecord>> i;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  public bdto(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.b = new HashMap();
    this.c = new HashMap();
    this.f = new HashMap();
    this.d = new HashMap();
    this.e = new HashMap();
    this.g = new HashMap();
    this.i = new HashMap();
    this.h = new HashMap();
    if (bfnh.a()) {
      ThreadManager.getSubThreadHandler().post(new QidianManager.1(this));
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
      return;
      a();
    }
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString)
  {
    String str = bbcl.m(paramQQAppInterface, paramString);
    if ((TextUtils.isEmpty(str)) || (str.equals(paramString)))
    {
      paramQQAppInterface = ((bdto)paramQQAppInterface.getManager(165)).a(String.valueOf(paramString));
      if (paramQQAppInterface != null) {
        return paramQQAppInterface.nickname;
      }
    }
    return str;
  }
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QidianManager", 4, "initial ...");
    }
    localaukn = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getEntityManagerFactory().createEntityManager();
    try
    {
      a(localaukn);
      b(localaukn);
      d(localaukn);
      e(localaukn);
      c(localaukn);
      f(localaukn);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QidianManager", 2, "QidianManager get data from db error: " + localException.getMessage());
        }
        localaukn.a();
      }
    }
    finally
    {
      localaukn.a();
    }
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  /* Error */
  public static void a(android.app.Activity paramActivity, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: aload 5
    //   5: ifnonnull +195 -> 200
    //   8: aconst_null
    //   9: astore 5
    //   11: aload_2
    //   12: ifnonnull +204 -> 216
    //   15: ldc 200
    //   17: astore 9
    //   19: aload_3
    //   20: ifnonnull +211 -> 231
    //   23: ldc 200
    //   25: astore_2
    //   26: aload 4
    //   28: ifnonnull +217 -> 245
    //   31: ldc 200
    //   33: astore_3
    //   34: new 179	java/lang/StringBuilder
    //   37: dup
    //   38: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   41: astore 10
    //   43: iload_1
    //   44: bipush 6
    //   46: if_icmpne +233 -> 279
    //   49: ldc 202
    //   51: astore 4
    //   53: aload 10
    //   55: aload 4
    //   57: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: aload 10
    //   63: ldc 204
    //   65: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload 10
    //   71: ldc 206
    //   73: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: aload 5
    //   78: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload 10
    //   84: ldc 208
    //   86: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload 9
    //   91: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: aload 10
    //   97: ldc 210
    //   99: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload_2
    //   103: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: aload 10
    //   109: ldc 212
    //   111: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: aload_3
    //   115: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: aload 10
    //   121: ldc 214
    //   123: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: astore_3
    //   127: iload 8
    //   129: ifeq +158 -> 287
    //   132: ldc 216
    //   134: astore_2
    //   135: aload_3
    //   136: aload_2
    //   137: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: aload 10
    //   143: ldc 218
    //   145: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: iload 7
    //   150: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   153: pop
    //   154: aload 10
    //   156: ldc 223
    //   158: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: aload 6
    //   163: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: new 225	android/content/Intent
    //   170: dup
    //   171: ldc 227
    //   173: aload 10
    //   175: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: invokestatic 233	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   181: invokespecial 236	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   184: astore_2
    //   185: aload_2
    //   186: ldc 238
    //   188: ldc 240
    //   190: invokevirtual 244	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   193: pop
    //   194: aload_0
    //   195: aload_2
    //   196: invokevirtual 250	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   199: return
    //   200: aload 5
    //   202: ldc 252
    //   204: invokevirtual 256	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   207: iconst_2
    //   208: invokestatic 262	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   211: astore 5
    //   213: goto -202 -> 11
    //   216: aload_2
    //   217: ldc 252
    //   219: invokevirtual 256	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   222: iconst_2
    //   223: invokestatic 262	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   226: astore 9
    //   228: goto -209 -> 19
    //   231: aload_3
    //   232: ldc 252
    //   234: invokevirtual 256	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   237: iconst_2
    //   238: invokestatic 262	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   241: astore_2
    //   242: goto -216 -> 26
    //   245: aload 4
    //   247: ldc 252
    //   249: invokevirtual 256	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   252: iconst_2
    //   253: invokestatic 262	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   256: astore_3
    //   257: goto -223 -> 34
    //   260: astore_3
    //   261: aconst_null
    //   262: astore 9
    //   264: aconst_null
    //   265: astore 5
    //   267: aconst_null
    //   268: astore_2
    //   269: aload_3
    //   270: invokevirtual 265	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   273: aload 10
    //   275: astore_3
    //   276: goto -242 -> 34
    //   279: ldc_w 267
    //   282: astore 4
    //   284: goto -231 -> 53
    //   287: ldc_w 269
    //   290: astore_2
    //   291: goto -156 -> 135
    //   294: astore_3
    //   295: aconst_null
    //   296: astore 9
    //   298: aconst_null
    //   299: astore_2
    //   300: goto -31 -> 269
    //   303: astore_3
    //   304: aconst_null
    //   305: astore_2
    //   306: goto -37 -> 269
    //   309: astore_3
    //   310: goto -41 -> 269
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	313	0	paramActivity	android.app.Activity
    //   0	313	1	paramInt1	int
    //   0	313	2	paramString1	String
    //   0	313	3	paramString2	String
    //   0	313	4	paramString3	String
    //   0	313	5	paramString4	String
    //   0	313	6	paramString5	String
    //   0	313	7	paramInt2	int
    //   0	313	8	paramBoolean	boolean
    //   17	280	9	str	String
    //   1	273	10	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   200	213	260	java/io/UnsupportedEncodingException
    //   216	228	294	java/io/UnsupportedEncodingException
    //   231	242	303	java/io/UnsupportedEncodingException
    //   245	257	309	java/io/UnsupportedEncodingException
  }
  
  public static void a(Context paramContext, ArrayList<bbje> paramArrayList)
  {
    paramContext = paramContext.getPackageManager();
    if (new Intent().setPackage("com.tencent.qidian").setData(Uri.parse("qdapi://")).resolveActivity(paramContext) != null) {
      paramArrayList.add(bbje.a(19));
    }
  }
  
  private void a(aukn paramaukn)
  {
    paramaukn = paramaukn.a(QidianExternalInfo.class);
    if (paramaukn != null)
    {
      paramaukn = paramaukn.iterator();
      while (paramaukn.hasNext())
      {
        QidianExternalInfo localQidianExternalInfo = (QidianExternalInfo)paramaukn.next();
        if (QLog.isColorLevel()) {
          QLog.d("QidianManager", 4, "loadExternalInfo query from db: " + localQidianExternalInfo);
        }
        String str = localQidianExternalInfo.uin;
        this.b.put(str, localQidianExternalInfo);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    for (;;)
    {
      try
      {
        Long.parseLong(paramString);
        if (!myy.a(paramString)) {
          return;
        }
        bdto localbdto = (bdto)paramQQAppInterface.getManager(165);
        boolean bool1 = b(paramInt);
        boolean bool2 = a(paramInt);
        boolean bool3 = c(paramInt);
        if ((!bool1) && (!bool2) && (!bool3))
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("QidianManager", 2, "updateQidianAccountType ignore uin: " + paramString + " | cSpecialFlag: " + paramInt);
          return;
        }
        if (localbdto.g(paramString))
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("QidianManager", 2, "updateQidianAccountType requested uin: " + paramString + " | cSpecialFlag: " + paramInt);
          return;
        }
        if (bool1)
        {
          localBmqqAccountType = new BmqqAccountType(paramString, 6);
          localbdto.a(localBmqqAccountType);
          if (!bool1) {
            continue;
          }
          QidianExternalInfo localQidianExternalInfo = localbdto.a(paramString);
          paramString = localbdto.a(paramString);
          if ((localQidianExternalInfo != null) && (paramString != null)) {
            continue;
          }
          if (bfnh.a()) {
            ThreadManager.post(new QidianManager.10(localbdto, paramQQAppInterface, localBmqqAccountType), 5, null, true);
          }
        }
        else
        {
          if (bool2)
          {
            localBmqqAccountType = new BmqqAccountType(paramString, 1);
            continue;
          }
          if (!bool3) {
            break label283;
          }
          localBmqqAccountType = new BmqqAccountType(paramString, 3);
          continue;
        }
        localbdto.b(paramQQAppInterface.getApp().getBaseContext(), localBmqqAccountType);
        return;
      }
      catch (Exception paramQQAppInterface)
      {
        return;
      }
      label283:
      BmqqAccountType localBmqqAccountType = null;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Friends paramFriends)
  {
    if (paramFriends == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QidianManager", 2, "updateQidianAccountType friend is null");
      }
      return;
    }
    a(paramQQAppInterface, paramFriends.cSpecialFlag, paramFriends.uin);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    try
    {
      Long.parseLong(paramString1);
      if (!myy.a(paramString1)) {
        return;
      }
      ((bdto)paramQQAppInterface.getManager(165)).h.put(paramString1, paramString2);
      return;
    }
    catch (Exception paramQQAppInterface) {}
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Friends[] paramArrayOfFriends)
  {
    bdto localbdto;
    if (paramArrayOfFriends != null)
    {
      localbdto = (bdto)paramQQAppInterface.getManager(165);
      if (bfnh.a()) {
        ThreadManager.postImmediately(new QidianManager.9(localbdto, paramQQAppInterface, paramArrayOfFriends), null, false);
      }
    }
    else
    {
      return;
    }
    localbdto.b(paramQQAppInterface, paramArrayOfFriends);
  }
  
  private void a(QidianPAForWpa paramQidianPAForWpa, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QidianManager", 2, "updateQidianPAForWpa");
    }
    paramString1 = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getEntityManagerFactory().createEntityManager();
    if (paramString1 != null) {
      if (paramQidianPAForWpa == null) {}
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        try
        {
          paramString1.b(paramQidianPAForWpa);
          if (QLog.isColorLevel()) {
            QLog.d("QidianManager", 2, "updateQidianPAForWpa success");
          }
          return;
        }
        catch (Exception paramQidianPAForWpa)
        {
          paramQidianPAForWpa.printStackTrace();
          return;
        }
        finally
        {
          paramString1.a();
        }
        if (QLog.isColorLevel()) {
          QLog.d("QidianManager", 2, "updateQidianPAForWpa uiInfo is null");
        }
      }
    }
    QLog.d("QidianManager", 2, "updateQidianPAForWpa em is null");
  }
  
  private void a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (paramString1.contains("isNeedReply=")) && (paramString1.contains("QidianKfUin=")))
    {
      bool1 = false;
      bool2 = false;
      str3 = "";
      str2 = "";
      str1 = "";
      localMatcher = Pattern.compile("((?:isNeedReply|isNeedLbs|QidianKfUin|isExt|FromStaff|cqq))=([^\\?&=]+)").matcher(paramString1);
      while (localMatcher.find()) {
        if ("isNeedReply".equals(localMatcher.group(1))) {
          bool2 = "true".equals(localMatcher.group(2));
        } else if ("isNeedLbs".equals(localMatcher.group(1))) {
          bool1 = "true".equals(localMatcher.group(2));
        } else if ("QidianKfUin".equals(localMatcher.group(1))) {
          str3 = localMatcher.group(2);
        } else if ("isExt".equals(localMatcher.group(1)))
        {
          if (paramInt2 == 2) {
            try
            {
              bool3 = Boolean.parseBoolean(localMatcher.group(2));
              if (bool3)
              {
                paramInt2 = 0;
                continue;
              }
              paramInt2 = 1;
            }
            catch (Exception localException)
            {
              paramInt2 = 0;
            }
          }
        }
        else if ("FromStaff".equals(localMatcher.group(1))) {
          str2 = localMatcher.group(2);
        } else if ("cqq".equals(localMatcher.group(1))) {
          str1 = localMatcher.group(2);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("QidianManager", 2, "isNeedLbs: " + bool1 + " | isNeedReply: " + bool2 + " | masterUin: " + str3 + " | srcType: " + paramInt2);
      }
      if (bool2)
      {
        if (!bool1) {
          break label364;
        }
        SosoInterface.a(new bdtp(this, 1, true, true, 0L, true, false, "QidianManager", paramString1, paramInt1, str3, paramInt2, str2, str1, paramString2));
      }
    }
    label364:
    while (!QLog.isColorLevel())
    {
      boolean bool1;
      boolean bool2;
      String str3;
      String str2;
      String str1;
      Matcher localMatcher;
      boolean bool3;
      return;
      a(paramString1, paramInt1, bool1, 0.0D, 0.0D, str3, paramInt2, str2, str1, paramString2);
      return;
    }
    QLog.d("QidianManager", 2, "key is null or don't contain isNeedReply : " + paramString1);
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt & 0x4) != 0;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Friends paramFriends, int paramInt)
  {
    boolean bool2 = true;
    paramQQAppInterface = (bdto)paramQQAppInterface.getManager(165);
    boolean bool1 = bool2;
    if (paramFriends != null)
    {
      bool1 = bool2;
      if (b(paramFriends.cSpecialFlag)) {
        if ((paramInt != 1) && (paramInt != 2) && (paramInt != 13) && (paramInt != 10001) && (paramInt != 7)) {
          break label67;
        }
      }
    }
    label67:
    for (bool1 = true;; bool1 = false) {
      return bool1;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return false;
    }
    return ((((bdto)paramQQAppInterface.getManager(165)).a(paramMessageRecord.frienduin)) || (paramMessageRecord.istroop == 1024)) && (!TextUtils.isEmpty(paramMessageRecord.getExtInfoFromExtStr("is_eman_sc_message")));
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    return ((bdto)paramQQAppInterface.getManager(165)).e(paramString);
  }
  
  private boolean a(String paramString, int paramInt)
  {
    Object localObject = (ajxn)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(51);
    if (localObject != null)
    {
      localObject = ((ajxn)localObject).b(paramString);
      if ((localObject != null) && (((Friends)localObject).cSpecialFlag < 0))
      {
        QLog.i("QidianManager", 1, "isSpecialAccountInFriend meet error!!");
        return false;
      }
      if ((localObject != null) && ((((Friends)localObject).cSpecialFlag & paramInt) != 0)) {
        QLog.i("QidianManager", 1, MsfSdkUtils.getShortUin(paramString) + " isSpecialAccountInFriend isSpecialAccount is true, friendInfo.cSpecialFlag: " + ((Friends)localObject).cSpecialFlag + " | flag: " + paramInt);
      }
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private boolean a(String paramString, QQAppInterface paramQQAppInterface)
  {
    if (TextUtils.isEmpty(paramQQAppInterface.getAccount())) {
      if (QLog.isColorLevel()) {
        QLog.i("QidianManager", 2, "app.getAccount() is null");
      }
    }
    do
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.i("QidianManager", 2, "initParm uin = " + paramString);
      }
      if (!TextUtils.isEmpty(paramString)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("QidianManager", 2, "mAllinone is null");
    return false;
    return true;
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1)) {
      if (!TextUtils.isEmpty(paramString2)) {
        break label50;
      }
    }
    for (;;)
    {
      if ((!TextUtils.isEmpty(paramString3)) && (paramString3.contains("isNeedReply=")) && (paramString3.contains("QidianKfUin=")))
      {
        return true;
        paramString2 = paramString1;
        break;
      }
      return false;
      label50:
      paramString3 = paramString2;
    }
  }
  
  public static String b(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = (bdto)paramQQAppInterface.getManager(165);
    if (paramQQAppInterface.f(paramString)) {
      if (paramQQAppInterface.b.containsKey(paramString))
      {
        paramQQAppInterface = (QidianExternalInfo)paramQQAppInterface.b.get(paramString);
        if (paramQQAppInterface != null) {
          return paramQQAppInterface.masterUin;
        }
      }
      else if (paramQQAppInterface.h.containsKey(paramString))
      {
        return (String)paramQQAppInterface.h.get(paramString);
      }
    }
    return "";
  }
  
  private void b(aukn paramaukn)
  {
    paramaukn = paramaukn.a(QidianInternalInfo.class);
    if (paramaukn != null)
    {
      paramaukn = paramaukn.iterator();
      while (paramaukn.hasNext())
      {
        QidianInternalInfo localQidianInternalInfo = (QidianInternalInfo)paramaukn.next();
        if (QLog.isColorLevel()) {
          QLog.d("QidianManager", 4, "loadInternalInfo query from db: " + localQidianInternalInfo);
        }
        String str = localQidianInternalInfo.uin;
        this.c.put(str, localQidianInternalInfo);
      }
    }
  }
  
  /* Error */
  private void b(QQAppInterface paramQQAppInterface, Friends[] paramArrayOfFriends)
  {
    // Byte code:
    //   0: aload_2
    //   1: arraylength
    //   2: istore 4
    //   4: iconst_0
    //   5: istore_3
    //   6: iload_3
    //   7: iload 4
    //   9: if_icmpge +275 -> 284
    //   12: aload_2
    //   13: iload_3
    //   14: aaload
    //   15: astore 9
    //   17: aload 9
    //   19: getfield 424	com/tencent/mobileqq/data/Friends:uin	Ljava/lang/String;
    //   22: astore 10
    //   24: aload 9
    //   26: getfield 423	com/tencent/mobileqq/data/Friends:cSpecialFlag	B
    //   29: istore 5
    //   31: aload 10
    //   33: invokestatic 362	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   36: pop2
    //   37: aload 10
    //   39: invokestatic 367	myy:a	(Ljava/lang/String;)Z
    //   42: ifne +4 -> 46
    //   45: return
    //   46: iload 5
    //   48: invokestatic 370	bdto:b	(I)Z
    //   51: istore 6
    //   53: iload 5
    //   55: invokestatic 372	bdto:a	(I)Z
    //   58: istore 7
    //   60: iload 5
    //   62: invokestatic 374	bdto:c	(I)Z
    //   65: istore 8
    //   67: iload 6
    //   69: ifne +60 -> 129
    //   72: iload 7
    //   74: ifne +55 -> 129
    //   77: iload 8
    //   79: ifne +50 -> 129
    //   82: invokestatic 139	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   85: ifeq +200 -> 285
    //   88: ldc 141
    //   90: iconst_2
    //   91: new 179	java/lang/StringBuilder
    //   94: dup
    //   95: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   98: ldc_w 376
    //   101: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: aload 10
    //   106: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: ldc_w 378
    //   112: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: iload 5
    //   117: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   120: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: invokestatic 146	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   126: goto +159 -> 285
    //   129: aconst_null
    //   130: astore 9
    //   132: iload 6
    //   134: ifeq +109 -> 243
    //   137: new 384	com/tencent/qidian/data/BmqqAccountType
    //   140: dup
    //   141: aload 10
    //   143: bipush 6
    //   145: invokespecial 387	com/tencent/qidian/data/BmqqAccountType:<init>	(Ljava/lang/String;I)V
    //   148: astore 9
    //   150: aload 9
    //   152: ifnull +133 -> 285
    //   155: aload_0
    //   156: aload 10
    //   158: invokevirtual 591	bdto:a	(Ljava/lang/String;)I
    //   161: aload 9
    //   163: invokevirtual 595	com/tencent/qidian/data/BmqqAccountType:getAccountType	()I
    //   166: if_icmpeq +119 -> 285
    //   169: aload_0
    //   170: getfield 50	bdto:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   173: aload 10
    //   175: aload 9
    //   177: invokevirtual 595	com/tencent/qidian/data/BmqqAccountType:getAccountType	()I
    //   180: invokestatic 600	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   183: invokeinterface 335 3 0
    //   188: pop
    //   189: iload 6
    //   191: ifeq +94 -> 285
    //   194: aload_0
    //   195: aload 10
    //   197: invokevirtual 126	bdto:a	(Ljava/lang/String;)Lcom/tencent/qidian/data/QidianExternalInfo;
    //   200: astore 11
    //   202: aload_0
    //   203: aload 10
    //   205: invokevirtual 393	bdto:a	(Ljava/lang/String;)Lcom/tencent/qidian/data/QidianProfileUiInfo;
    //   208: astore 10
    //   210: aload 11
    //   212: ifnull +8 -> 220
    //   215: aload 10
    //   217: ifnonnull +68 -> 285
    //   220: aload_0
    //   221: aload_1
    //   222: invokevirtual 405	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   225: invokevirtual 411	com/tencent/qphone/base/util/BaseApplication:getBaseContext	()Landroid/content/Context;
    //   228: aload 9
    //   230: invokevirtual 414	bdto:b	(Landroid/content/Context;Lcom/tencent/qidian/data/BmqqAccountType;)Z
    //   233: pop
    //   234: goto +51 -> 285
    //   237: astore_1
    //   238: aload_1
    //   239: invokevirtual 445	java/lang/Exception:printStackTrace	()V
    //   242: return
    //   243: iload 7
    //   245: ifeq +18 -> 263
    //   248: new 384	com/tencent/qidian/data/BmqqAccountType
    //   251: dup
    //   252: aload 10
    //   254: iconst_1
    //   255: invokespecial 387	com/tencent/qidian/data/BmqqAccountType:<init>	(Ljava/lang/String;I)V
    //   258: astore 9
    //   260: goto -110 -> 150
    //   263: iload 8
    //   265: ifeq -115 -> 150
    //   268: new 384	com/tencent/qidian/data/BmqqAccountType
    //   271: dup
    //   272: aload 10
    //   274: iconst_3
    //   275: invokespecial 387	com/tencent/qidian/data/BmqqAccountType:<init>	(Ljava/lang/String;I)V
    //   278: astore 9
    //   280: goto -130 -> 150
    //   283: astore_1
    //   284: return
    //   285: iload_3
    //   286: iconst_1
    //   287: iadd
    //   288: istore_3
    //   289: goto -283 -> 6
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	292	0	this	bdto
    //   0	292	1	paramQQAppInterface	QQAppInterface
    //   0	292	2	paramArrayOfFriends	Friends[]
    //   5	284	3	j	int
    //   2	8	4	k	int
    //   29	87	5	m	int
    //   51	139	6	bool1	boolean
    //   58	186	7	bool2	boolean
    //   65	199	8	bool3	boolean
    //   15	264	9	localObject1	Object
    //   22	251	10	localObject2	Object
    //   200	11	11	localQidianExternalInfo	QidianExternalInfo
    // Exception table:
    //   from	to	target	type
    //   0	4	237	java/lang/Exception
    //   17	31	237	java/lang/Exception
    //   37	45	237	java/lang/Exception
    //   46	67	237	java/lang/Exception
    //   82	126	237	java/lang/Exception
    //   137	150	237	java/lang/Exception
    //   155	189	237	java/lang/Exception
    //   194	210	237	java/lang/Exception
    //   220	234	237	java/lang/Exception
    //   248	260	237	java/lang/Exception
    //   268	280	237	java/lang/Exception
    //   31	37	283	java/lang/Exception
  }
  
  private void b(BmqqUserSimpleInfo paramBmqqUserSimpleInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QidianManager", 2, "updateBmqqExtInfo");
    }
    aukn localaukn = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getEntityManagerFactory().createEntityManager();
    if (localaukn != null) {
      if (paramBmqqUserSimpleInfo == null) {}
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        try
        {
          localaukn.b(paramBmqqUserSimpleInfo);
          if (QLog.isColorLevel()) {
            QLog.d("QidianManager", 2, "updateBmqqExtInfo success");
          }
          return;
        }
        catch (Exception paramBmqqUserSimpleInfo)
        {
          paramBmqqUserSimpleInfo.printStackTrace();
          return;
        }
        finally
        {
          localaukn.a();
        }
        if (QLog.isColorLevel()) {
          QLog.d("QidianManager", 2, "updateBmqqExtInfo uiInfo is null");
        }
      }
    }
    QLog.d("QidianManager", 2, "updateBmqqExtInfo em is null");
  }
  
  private void b(QidianExternalInfo paramQidianExternalInfo, QidianInternalInfo paramQidianInternalInfo, QidianCorpInfo paramQidianCorpInfo, QidianProfileUiInfo paramQidianProfileUiInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QidianManager", 2, "saveQidianExtInfoInSubThread");
    }
    aukn localaukn = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getEntityManagerFactory().createEntityManager();
    if (localaukn != null) {
      if (paramQidianExternalInfo == null) {}
    }
    label62:
    label124:
    while (!QLog.isColorLevel())
    {
      try
      {
        localaukn.b(paramQidianExternalInfo);
        if (paramQidianInternalInfo == null) {
          break label124;
        }
        localaukn.b(paramQidianInternalInfo);
      }
      catch (Exception paramQidianExternalInfo)
      {
        for (;;)
        {
          paramQidianExternalInfo.printStackTrace();
          return;
          if (QLog.isColorLevel()) {
            QLog.d("QidianManager", 2, "saveQidianIntInfoInSubThread internalInfo is null");
          }
        }
      }
      finally
      {
        localaukn.a();
      }
      if (paramQidianCorpInfo != null)
      {
        localaukn.b(paramQidianCorpInfo);
        if (paramQidianProfileUiInfo == null) {
          break label168;
        }
        localaukn.b(paramQidianProfileUiInfo);
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QidianManager", 2, "saveQidianExtInfoInSubThread success");
        }
        localaukn.a();
        return;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("QidianManager", 2, "saveQidianExtInfoInSubThread externalInfo is null");
        break;
        if (!QLog.isColorLevel()) {
          break label62;
        }
        QLog.d("QidianManager", 2, "saveQidianExtInfoInSubThread corpInfo is null");
        break label62;
        if (QLog.isColorLevel()) {
          QLog.d("QidianManager", 2, "saveQidianExtInfoInSubThread uiInfo is null");
        }
      }
    }
    label168:
    QLog.d("QidianManager", 2, "saveQidianExtInfoInSubThread em is null");
  }
  
  private void b(QidianExternalInfo paramQidianExternalInfo, QidianProfileUiInfo paramQidianProfileUiInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QidianManager", 2, "saveQidianMasterInfoInSubThread");
    }
    aukn localaukn = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getEntityManagerFactory().createEntityManager();
    if (localaukn != null) {
      if (paramQidianExternalInfo == null) {}
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        try
        {
          localaukn.b(paramQidianExternalInfo);
          if (paramQidianProfileUiInfo == null) {
            continue;
          }
          localaukn.b(paramQidianProfileUiInfo);
        }
        catch (Exception paramQidianExternalInfo)
        {
          paramQidianExternalInfo.printStackTrace();
          return;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("QidianManager", 2, "saveQidianMasterInfoInSubThread uiInfo is null");
          continue;
        }
        finally
        {
          localaukn.a();
        }
        if (QLog.isColorLevel()) {
          QLog.d("QidianManager", 2, "saveQidianMasterInfoInSubThread success");
        }
        localaukn.a();
        return;
        if (QLog.isColorLevel()) {
          QLog.d("QidianManager", 2, "saveQidianMasterInfoInSubThread externalInfo is null");
        }
      }
    }
    QLog.d("QidianManager", 2, "saveQidianMasterInfoInSubThread em is null");
  }
  
  public static boolean b(int paramInt)
  {
    return (paramInt & 0x10) != 0;
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, String paramString)
  {
    return ((bdto)paramQQAppInterface.getManager(165)).f(paramString);
  }
  
  private String c(String paramString)
  {
    String str = "";
    if (a(paramString))
    {
      QidianExternalInfo localQidianExternalInfo = (QidianExternalInfo)this.b.get(paramString);
      if ((localQidianExternalInfo != null) && (!TextUtils.isEmpty(localQidianExternalInfo.masterUin)))
      {
        paramString = (QidianCorpInfo)this.d.get(localQidianExternalInfo.masterUin);
        if (paramString == null) {
          break label122;
        }
      }
    }
    label122:
    for (paramString = paramString.corpName;; paramString = "")
    {
      str = paramString;
      do
      {
        do
        {
          return str;
        } while (!QLog.isColorLevel());
        QLog.d("QidianManager", 4, "QidianExternalInfo is null or masterUin is empty for uin: " + paramString);
        return "";
      } while (!QLog.isColorLevel());
      QLog.d("QidianManager", 4, "uin is no qidian account");
      return "";
    }
  }
  
  private void c(aukn paramaukn)
  {
    paramaukn = paramaukn.a(BmqqUserSimpleInfo.class);
    if (paramaukn != null)
    {
      paramaukn = paramaukn.iterator();
      while (paramaukn.hasNext())
      {
        BmqqUserSimpleInfo localBmqqUserSimpleInfo = (BmqqUserSimpleInfo)paramaukn.next();
        if (QLog.isColorLevel()) {
          QLog.d("QidianManager", 4, "loadBmqqExtInfo query from db: " + localBmqqUserSimpleInfo);
        }
        String str = localBmqqUserSimpleInfo.mBmqqUin;
        this.f.put(str, localBmqqUserSimpleInfo);
      }
    }
  }
  
  public static boolean c(int paramInt)
  {
    return (paramInt & 0x1) != 0;
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = (bdto)paramQQAppInterface.getManager(165);
    return (paramQQAppInterface.a(paramString)) || (paramQQAppInterface.f(paramString));
  }
  
  private void d(aukn paramaukn)
  {
    paramaukn = paramaukn.a(QidianCorpInfo.class);
    if (paramaukn != null)
    {
      paramaukn = paramaukn.iterator();
      while (paramaukn.hasNext())
      {
        QidianCorpInfo localQidianCorpInfo = (QidianCorpInfo)paramaukn.next();
        if (QLog.isColorLevel()) {
          QLog.d("QidianManager", 4, "loadCorpInfo query from db: " + localQidianCorpInfo);
        }
        String str = localQidianCorpInfo.corpUin;
        this.d.put(str, localQidianCorpInfo);
      }
    }
  }
  
  private void e(aukn paramaukn)
  {
    paramaukn = paramaukn.a(QidianProfileUiInfo.class);
    if (paramaukn != null)
    {
      paramaukn = paramaukn.iterator();
      while (paramaukn.hasNext())
      {
        QidianProfileUiInfo localQidianProfileUiInfo = (QidianProfileUiInfo)paramaukn.next();
        if (QLog.isColorLevel()) {
          QLog.d("QidianManager", 4, "loadQidianProfileUiInfo query from db: " + localQidianProfileUiInfo);
        }
        this.e.put(localQidianProfileUiInfo.uin, localQidianProfileUiInfo);
      }
    }
  }
  
  private void f(aukn paramaukn)
  {
    paramaukn = paramaukn.a(QidianPAForWpa.class);
    if (paramaukn != null)
    {
      paramaukn = paramaukn.iterator();
      while (paramaukn.hasNext())
      {
        QidianPAForWpa localQidianPAForWpa = (QidianPAForWpa)paramaukn.next();
        this.g.put(localQidianPAForWpa.puin, localQidianPAForWpa);
      }
    }
  }
  
  public int a(String paramString)
  {
    return ((Integer)this.jdField_a_of_type_JavaUtilMap.get(paramString)).intValue();
  }
  
  public int a(String paramString, QQAppInterface paramQQAppInterface)
  {
    int j = 1;
    if (!a(paramString, paramQQAppInterface)) {
      j = 5;
    }
    do
    {
      return j;
      if (f(paramString)) {
        return 6;
      }
      if (nbc.b(paramQQAppInterface, paramString, 0)) {
        return 3;
      }
    } while (a(paramString));
    if (a(paramString, true)) {
      return 0;
    }
    return 4;
  }
  
  public QidianCorpInfo a(String paramString)
  {
    QidianCorpInfo localQidianCorpInfo = null;
    if (this.d.containsKey(paramString)) {
      localQidianCorpInfo = (QidianCorpInfo)this.d.get(paramString);
    }
    return localQidianCorpInfo;
  }
  
  public QidianExternalInfo a(String paramString)
  {
    QidianExternalInfo localQidianExternalInfo = null;
    if (this.b.containsKey(paramString)) {
      localQidianExternalInfo = (QidianExternalInfo)this.b.get(paramString);
    }
    return localQidianExternalInfo;
  }
  
  public QidianInternalInfo a(String paramString)
  {
    QidianInternalInfo localQidianInternalInfo = null;
    if (this.c.containsKey(paramString)) {
      localQidianInternalInfo = (QidianInternalInfo)this.c.get(paramString);
    }
    return localQidianInternalInfo;
  }
  
  public QidianProfileUiInfo a(String paramString)
  {
    QidianProfileUiInfo localQidianProfileUiInfo = null;
    if (this.e.containsKey(paramString)) {
      localQidianProfileUiInfo = (QidianProfileUiInfo)this.e.get(paramString);
    }
    return localQidianProfileUiInfo;
  }
  
  public String a(Context paramContext, String paramString)
  {
    paramString = c(paramString);
    if (!TextUtils.isEmpty(paramString)) {
      return String.format(paramContext.getString(2131698572), new Object[] { paramString });
    }
    return paramContext.getString(2131698571);
  }
  
  public String a(String paramString)
  {
    if (this.b.containsKey(paramString))
    {
      paramString = (QidianExternalInfo)this.b.get(paramString);
      if (paramString != null) {
        return paramString.masterUin;
      }
    }
    return "";
  }
  
  public void a(QQAppInterface paramQQAppInterface, long paramLong, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    Object localObject1;
    Object localObject2;
    FragmentActivity localFragmentActivity;
    do
    {
      do
      {
        return;
        localObject1 = String.valueOf(paramLong);
        localObject2 = axuy.a(paramString.getBytes(), 0);
      } while ((localObject2 == null) || ((!(BaseActivity.sTopActivity instanceof SplashActivity)) && (!(BaseActivity.sTopActivity instanceof ChatActivity))));
      localFragmentActivity = (FragmentActivity)BaseActivity.sTopActivity;
    } while ((localFragmentActivity.getChatFragment() == null) || (!localFragmentActivity.getChatFragment().a.a.jdField_a_of_type_JavaLangString.equals(localObject1)));
    paramString = (MessageForStructing)axaq.a(-2011);
    paramString.msgtype = -2011;
    paramString.istroop = localFragmentActivity.getChatFragment().a.a.jdField_a_of_type_Int;
    paramString.issend = 0;
    paramString.isread = true;
    paramString.selfuin = paramQQAppInterface.getCurrentAccountUin();
    paramString.mIsParsed = true;
    paramString.frienduin = ((String)localObject1);
    paramString.senderuin = ((String)localObject1);
    paramString.structingMsg = ((AbsStructMsg)localObject2);
    paramString.msgData = ((AbsStructMsg)localObject2).getBytes();
    paramString.saveExtInfoToExtStr("is_eman_sc_message", "1");
    if (this.i.get(localObject1) == null)
    {
      localObject2 = new ArrayList();
      ((List)localObject2).add(paramString);
      this.i.put(localObject1, localObject2);
    }
    for (;;)
    {
      localObject1 = new ArrayList();
      if (akau.a(paramQQAppInterface, paramString, false)) {
        break;
      }
      ((ArrayList)localObject1).add(paramString);
      paramQQAppInterface.a().c((List)localObject1, String.valueOf(paramQQAppInterface.getCurrentAccountUin()));
      return;
      ((List)this.i.get(localObject1)).add(paramString);
    }
  }
  
  public void a(BmqqUserSimpleInfo paramBmqqUserSimpleInfo)
  {
    if (paramBmqqUserSimpleInfo != null) {
      this.f.put(paramBmqqUserSimpleInfo.mBmqqUin, paramBmqqUserSimpleInfo);
    }
    if (bfnh.a())
    {
      ThreadManager.post(new QidianManager.2(this, paramBmqqUserSimpleInfo), 5, null, true);
      return;
    }
    b(paramBmqqUserSimpleInfo);
  }
  
  public void a(BmqqAccountType paramBmqqAccountType)
  {
    if (paramBmqqAccountType != null) {
      this.jdField_a_of_type_JavaUtilMap.put(paramBmqqAccountType.getUin(), Integer.valueOf(paramBmqqAccountType.getAccountType()));
    }
  }
  
  public void a(QidianExternalInfo paramQidianExternalInfo, QidianInternalInfo paramQidianInternalInfo, QidianCorpInfo paramQidianCorpInfo, QidianProfileUiInfo paramQidianProfileUiInfo)
  {
    if (paramQidianExternalInfo != null) {
      this.b.put(paramQidianExternalInfo.uin, paramQidianExternalInfo);
    }
    if (paramQidianCorpInfo != null) {
      this.d.put(paramQidianCorpInfo.corpUin, paramQidianCorpInfo);
    }
    if (paramQidianProfileUiInfo != null) {
      this.e.put(paramQidianProfileUiInfo.uin, paramQidianProfileUiInfo);
    }
    if (paramQidianInternalInfo != null) {
      this.c.put(paramQidianInternalInfo.uin, paramQidianInternalInfo);
    }
    if (bfnh.a())
    {
      ThreadManager.post(new QidianManager.3(this, paramQidianExternalInfo, paramQidianInternalInfo, paramQidianCorpInfo, paramQidianProfileUiInfo), 5, null, true);
      return;
    }
    b(paramQidianExternalInfo, paramQidianInternalInfo, paramQidianCorpInfo, paramQidianProfileUiInfo);
  }
  
  public void a(QidianExternalInfo paramQidianExternalInfo, QidianProfileUiInfo paramQidianProfileUiInfo)
  {
    if (paramQidianExternalInfo != null) {
      this.b.put(paramQidianExternalInfo.uin, paramQidianExternalInfo);
    }
    if (paramQidianProfileUiInfo != null) {
      this.e.put(paramQidianProfileUiInfo.uin, paramQidianProfileUiInfo);
    }
    if (bfnh.a())
    {
      ThreadManager.post(new QidianManager.8(this, paramQidianExternalInfo, paramQidianProfileUiInfo), 5, null, true);
      return;
    }
    b(paramQidianExternalInfo, paramQidianProfileUiInfo);
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    Object localObject1;
    Object localObject2;
    do
    {
      do
      {
        return;
        localObject1 = paramString.split("\\?");
      } while (localObject1.length != 2);
      localObject2 = localObject1[1].split("&");
      localObject1 = new HashMap();
      int k = localObject2.length;
      int j = 0;
      if (j < k)
      {
        String[] arrayOfString = localObject2[j].split("=");
        if (arrayOfString.length != 2) {}
        for (;;)
        {
          j += 1;
          break;
          ((HashMap)localObject1).put(arrayOfString[0], arrayOfString[1]);
        }
      }
      localObject2 = (String)((HashMap)localObject1).get("aioType");
      localObject1 = (String)((HashMap)localObject1).get("uin");
    } while ((TextUtils.isEmpty((CharSequence)localObject2)) && (TextUtils.isEmpty((CharSequence)localObject1)));
    a(paramString, (String)localObject2, (String)localObject1);
  }
  
  public void a(String paramString, int paramInt)
  {
    Object localObject = (List)this.i.get(paramString);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        if ((localMessageRecord != null) && (paramInt == localMessageRecord.istroop)) {
          ((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).a().b(paramString, localMessageRecord.istroop, localMessageRecord.uniseq);
        }
      }
    }
  }
  
  public void a(String paramString1, int paramInt1, boolean paramBoolean, double paramDouble1, double paramDouble2, String paramString2, int paramInt2, String paramString3, String paramString4, String paramString5)
  {
    ((bduw)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(85)).a(paramString1, paramInt1, paramBoolean, 0.0D, 0.0D, paramString2, paramInt2, paramString3, paramString4, paramString5);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.g.containsKey(paramString1)) {}
    for (QidianPAForWpa localQidianPAForWpa = (QidianPAForWpa)this.g.get(paramString1);; localQidianPAForWpa = new QidianPAForWpa())
    {
      localQidianPAForWpa.puin = paramString1;
      localQidianPAForWpa.kfuin = paramString2;
      this.g.put(paramString1, localQidianPAForWpa);
      if (!bfnh.a()) {
        break;
      }
      ThreadManager.post(new QidianManager.6(this, localQidianPAForWpa, paramString1, paramString2), 5, null, true);
      return;
    }
    a(localQidianPAForWpa, paramString1, paramString2);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    String str = "";
    if (paramString2.equals("1")) {
      paramString2 = str;
    }
    for (;;)
    {
      ((bduw)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(85)).a(paramString1, paramString2, paramString3);
      return;
      if (paramString2.equals("2"))
      {
        paramString2 = paramString3;
        paramString3 = "";
      }
      else
      {
        paramString3 = "";
        paramString2 = str;
      }
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5)
  {
    if (TextUtils.isEmpty(paramString2)) {
      if (!TextUtils.isEmpty(paramString3)) {
        break label31;
      }
    }
    for (;;)
    {
      a(paramString4, 1, paramInt, paramString5);
      return;
      paramString3 = paramString2;
      break;
      label31:
      paramString4 = paramString3;
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if ((!myy.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (myy.a(null, paramString))) {
      ((ajtk)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(2)).a(paramString, paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((bdtq)localIterator.next()).a(paramBoolean);
    }
  }
  
  public boolean a(Context paramContext, BmqqAccountType paramBmqqAccountType)
  {
    if (paramBmqqAccountType == null) {}
    for (;;)
    {
      return false;
      paramContext = paramBmqqAccountType.getUin();
      try
      {
        long l = Long.parseLong(paramContext);
        if (myy.a(paramContext))
        {
          switch (paramBmqqAccountType.getAccountType())
          {
          default: 
            return false;
          case 1: 
            ((bduw)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(85)).b(l);
            return true;
          }
          ((bduw)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(85)).d(l);
          return true;
        }
      }
      catch (Exception paramContext) {}
    }
    return false;
  }
  
  public boolean a(String paramString)
  {
    return b(paramString, true);
  }
  
  public boolean a(String paramString, boolean paramBoolean)
  {
    boolean bool = true;
    try
    {
      Long.parseLong(paramString);
      if (!myy.a(paramString)) {}
      while ((myy.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (!myy.a(null, paramString))) {
        return false;
      }
      if (this.f.containsKey(paramString)) {}
      for (;;)
      {
        return bool;
        if (!a(paramString, 1))
        {
          if (!paramBoolean) {
            a(paramString, false);
          }
          bool = false;
        }
      }
      return false;
    }
    catch (Exception paramString) {}
  }
  
  public String b(String paramString)
  {
    paramString = (QidianPAForWpa)this.g.get(paramString);
    if (paramString != null) {
      return paramString.kfuin;
    }
    return null;
  }
  
  public void b(String paramString)
  {
    ((ajtk)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(2)).f(paramString);
  }
  
  public boolean b(Context paramContext, BmqqAccountType paramBmqqAccountType)
  {
    if (paramBmqqAccountType == null) {}
    for (;;)
    {
      return false;
      paramContext = paramBmqqAccountType.getUin();
      try
      {
        long l = Long.parseLong(paramContext);
        if (myy.a(paramContext))
        {
          switch (paramBmqqAccountType.getAccountType())
          {
          case 3: 
          case 4: 
          case 5: 
          default: 
            return false;
          case 0: 
          case 2: 
            ((myv)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(37)).a(paramContext);
            return true;
          case 1: 
            ((bduw)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(85)).a(l);
            return true;
          }
          ((bduw)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(85)).c(l);
          return true;
        }
      }
      catch (Exception paramContext) {}
    }
    return false;
  }
  
  public boolean b(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.b.containsKey(paramString))
    {
      paramString = (QidianExternalInfo)this.b.get(paramString);
      bool1 = bool2;
      if (paramString != null) {
        if (paramString.isShowCall != 1) {
          break label49;
        }
      }
    }
    label49:
    for (bool1 = true;; bool1 = false) {
      return bool1;
    }
  }
  
  public boolean b(String paramString, boolean paramBoolean)
  {
    boolean bool2;
    try
    {
      Long.parseLong(paramString);
      if (!myy.a(paramString))
      {
        bool2 = false;
        return bool2;
      }
    }
    catch (Exception paramString)
    {
      return false;
    }
    if ((myy.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (!myy.a(null, paramString))) {
      return false;
    }
    boolean bool1;
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))
    {
      if (((Integer)this.jdField_a_of_type_JavaUtilMap.get(paramString)).intValue() != 1) {
        break label152;
      }
      bool1 = true;
    }
    for (;;)
    {
      bool2 = bool1;
      if (!bool1) {
        break;
      }
      bool2 = bool1;
      if (this.b.get(paramString) != null) {
        break;
      }
      bool2 = bool1;
      if (paramBoolean) {
        break;
      }
      if (!bfnh.a()) {
        break label157;
      }
      ThreadManager.post(new QidianManager.4(this, paramString), 5, null, true);
      return bool1;
      if (a(paramString, 4))
      {
        bool1 = true;
      }
      else
      {
        if (!paramBoolean) {
          a(paramString, false);
        }
        label152:
        bool1 = false;
      }
    }
    label157:
    b(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getBaseContext(), new BmqqAccountType(paramString, 1));
    return bool1;
  }
  
  public boolean c(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.b.containsKey(paramString))
    {
      paramString = (QidianExternalInfo)this.b.get(paramString);
      bool1 = bool2;
      if (paramString != null) {
        if (paramString.isShowVideoCall != 1) {
          break label49;
        }
      }
    }
    label49:
    for (bool1 = true;; bool1 = false) {
      return bool1;
    }
  }
  
  public boolean c(String paramString, boolean paramBoolean)
  {
    boolean bool1 = false;
    label393:
    for (;;)
    {
      try
      {
        Long.parseLong(paramString);
        if (!myy.a(paramString))
        {
          paramBoolean = bool1;
          if (QLog.isColorLevel())
          {
            QLog.d("QidianManager", 2, "isQidianMaster uin is not in bmqqsegment");
            paramBoolean = bool1;
          }
          return paramBoolean;
        }
        if ((myy.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (myy.a(null, paramString)))
        {
          paramBoolean = bool1;
          if (QLog.isColorLevel())
          {
            QLog.d("QidianManager", 2, "isQidianMaster is bmqquin");
            return false;
          }
        }
        else
        {
          bool1 = a(paramString, 16);
          boolean bool2;
          if (!bool1)
          {
            if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))
            {
              if (((Integer)this.jdField_a_of_type_JavaUtilMap.get(paramString)).intValue() != 6) {
                break label393;
              }
              QLog.i("QidianManager", 1, MsfSdkUtils.getShortUin(paramString) + " isQidianMaster is qidianmain");
              bool2 = true;
              bool1 = bool2;
              if (!paramBoolean)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("QidianManager", 2, "isQidianMaster not only in cache 0");
                }
                b(paramString);
                bool1 = bool2;
              }
              if ((bool1) && (!paramBoolean))
              {
                QidianExternalInfo localQidianExternalInfo = a(String.valueOf(paramString));
                QidianProfileUiInfo localQidianProfileUiInfo = a(String.valueOf(paramString));
                if ((localQidianExternalInfo == null) || (localQidianProfileUiInfo == null))
                {
                  if (!bfnh.a()) {
                    continue;
                  }
                  ThreadManager.post(new QidianManager.7(this, paramString), 5, null, true);
                }
              }
              paramBoolean = bool1;
              if (!bool1) {
                continue;
              }
              QLog.i("QidianManager", 1, MsfSdkUtils.getShortUin(paramString) + " isQidianMaster is true finally");
              return bool1;
            }
            if (!paramBoolean)
            {
              if (QLog.isColorLevel()) {
                QLog.d("QidianManager", 2, "isQidianMaster not only in cache 1");
              }
              b(paramString);
              continue;
            }
          }
          else if (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))
          {
            a(new BmqqAccountType(paramString, 6));
            if (QLog.isColorLevel()) {
              QLog.d("QidianManager", 2, "isQidianMaster update account type");
            }
          }
          continue;
          b(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getBaseContext(), new BmqqAccountType(paramString, 6));
          if (QLog.isColorLevel())
          {
            QLog.d("QidianManager", 2, "isQidianMaster get user detail");
            continue;
            bool2 = bool1;
          }
        }
      }
      catch (Exception paramString)
      {
        return false;
      }
    }
  }
  
  public boolean d(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(a(paramString)))
    {
      bool1 = bool2;
      if (b(paramString)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean e(String paramString)
  {
    try
    {
      Long.parseLong(paramString);
      if ((this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) && (((Integer)this.jdField_a_of_type_JavaUtilMap.get(paramString)).intValue() == 3)) {
        return true;
      }
    }
    catch (Exception paramString)
    {
      return false;
    }
    return false;
  }
  
  public boolean f(String paramString)
  {
    return c(paramString, true);
  }
  
  public boolean g(String paramString)
  {
    return this.jdField_a_of_type_JavaUtilMap.containsKey(paramString);
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QidianManager", 4, "onDestroyd ...");
    }
    if (this.jdField_a_of_type_JavaUtilMap != null) {
      this.jdField_a_of_type_JavaUtilMap.clear();
    }
    if (this.b != null) {
      this.b.clear();
    }
    if (this.c != null) {
      this.c.clear();
    }
    if (this.d != null) {
      this.d.clear();
    }
    if (this.e != null) {
      this.e.clear();
    }
    if (this.f != null) {
      this.f.clear();
    }
    if (this.g != null) {
      this.g.clear();
    }
    if (this.h != null) {
      this.h.clear();
    }
    if (this.i != null) {
      this.i.clear();
    }
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     bdto
 * JD-Core Version:    0.7.0.1
 */