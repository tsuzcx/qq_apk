package com.tencent.mobileqq.ark;

import aauo;
import aaup;
import aaur;
import aaus;
import aaut;
import aauv;
import aauw;
import aaux;
import aauy;
import aauz;
import aavc;
import aavd;
import aave;
import aavf;
import aavg;
import aavh;
import aavi;
import aavl;
import aavn;
import aavp;
import aavq;
import aavs;
import aavt;
import aavu;
import aavv;
import aavw;
import aavx;
import aavy;
import aawa;
import aawb;
import aawc;
import aawd;
import aawe;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.component.network.utils.AssertUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.util.WeakReferenceHandler;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ArkLocalAppMgr
  implements Handler.Callback
{
  private static boolean jdField_b_of_type_Boolean;
  private long jdField_a_of_type_Long;
  private final WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private final ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private final HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private long jdField_b_of_type_Long = 300L;
  private final WeakReference jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(this);
  private final ArrayList jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private final HashMap jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private final ArrayList jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  private final HashMap jdField_c_of_type_JavaUtilHashMap = new HashMap();
  private final ArrayList d = new ArrayList();
  
  static
  {
    if (!ArkLocalAppMgr.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  public ArkLocalAppMgr(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    i();
    a(10000);
    ThreadManager.post(new aauo(this), 5, null, true);
  }
  
  private static int a(int paramInt, long paramLong)
  {
    if (paramLong == 0L) {}
    int i;
    do
    {
      return paramInt;
      i = (int)((System.currentTimeMillis() - paramLong) / 86400000L);
      if (i > 30) {
        return paramInt + 20160;
      }
      if (i > 21) {
        return paramInt + 10080;
      }
      if (i > 14) {
        return paramInt + 4320;
      }
    } while (i <= 7);
    return paramInt + 1440;
  }
  
  private static int a(String paramString)
  {
    int i = 0;
    int k = 0;
    int j;
    if (TextUtils.isEmpty(paramString)) {
      j = k;
    }
    do
    {
      do
      {
        return j;
        paramString = paramString.split("\\|");
        j = k;
      } while (paramString == null);
      j = k;
    } while (paramString.length == 0);
    int m = paramString.length;
    k = 0;
    for (;;)
    {
      j = i;
      if (k >= m) {
        break;
      }
      j = b(paramString[k]);
      k += 1;
      i = j | i;
    }
  }
  
  private static long a(String paramString)
  {
    long l2;
    if (TextUtils.isEmpty(paramString)) {
      l2 = System.currentTimeMillis();
    }
    long l1;
    do
    {
      do
      {
        return l2;
        l2 = BaseApplication.getContext().getSharedPreferences("ArkAppLastUsedTime", 0).getLong(paramString, 0L);
        l1 = l2;
        if (l2 == 0L)
        {
          a(paramString);
          l1 = System.currentTimeMillis();
        }
        l2 = l1;
      } while (jdField_a_of_type_Boolean);
      l2 = l1;
    } while (l1 > 0L);
    throw new AssertionError();
  }
  
  private static Looper a()
  {
    if (Looper.myLooper() != null) {
      return Looper.myLooper();
    }
    return Looper.getMainLooper();
  }
  
  private ArkLocalAppMgr.AppPathInfo a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.length() == 0) || (!ArkAppCenter.b())) {}
    ArkLocalAppMgr.AppPathInfo localAppPathInfo;
    do
    {
      return null;
      a(paramString1);
      localAppPathInfo = b(paramString1);
    } while ((localAppPathInfo == null) || ((paramString2 != null) && (b(localAppPathInfo.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDesc.jdField_b_of_type_JavaLangString, paramString2) < 0)));
    if (1 != ArkAppEnvConfig.a().a())
    {
      long l = System.currentTimeMillis();
      if (c(paramString1))
      {
        ArkAppCenter.b("ArkApp.ArkLocalAppMgr", String.format("checkSignAfterAppPathCache,appName, time, app-name=%s, time=%.6f", new Object[] { paramString1, Float.valueOf((float)(System.currentTimeMillis() - l) / 1000.0F) }));
        return localAppPathInfo;
      }
      ArkAppCenter.b("ArkApp.ArkLocalAppMgr", String.format("checkSignAfterAppPathCache, checkSignAfterAppPathCache is failed", new Object[0]));
      return null;
    }
    ArkAppCenter.b("ArkApp.ArkLocalAppMgr", String.format("checkSignAfterAppPathCache,not checkSign and current arkEnvironment is Test", new Object[0]));
    return localAppPathInfo;
  }
  
  private static ArkLocalAppMgr.GetAppPathByActionResult a(Element paramElement, String paramString, int paramInt)
  {
    if (paramElement == null) {
      return null;
    }
    for (;;)
    {
      int i;
      try
      {
        NodeList localNodeList = paramElement.getChildNodes();
        if (localNodeList == null) {
          return null;
        }
        paramElement = null;
        Object localObject1 = null;
        localObject2 = null;
        int j = localNodeList.getLength();
        i = 0;
        Object localObject4 = null;
        if (i < j)
        {
          localObject3 = localNodeList.item(i);
          if (localObject3 != null)
          {
            if (((Node)localObject3).getNodeType() != 1)
            {
              localObject3 = paramElement;
              paramElement = (Element)localObject2;
              localObject2 = localObject3;
              break label332;
            }
            Object localObject5 = ((Node)localObject3).getNodeName();
            localObject3 = ((Node)localObject3).getTextContent();
            if (TextUtils.isEmpty((CharSequence)localObject5))
            {
              localObject3 = paramElement;
              paramElement = (Element)localObject2;
              localObject2 = localObject3;
              break label332;
            }
            if (((String)localObject5).equals("Intent"))
            {
              paramElement = (Element)localObject2;
              localObject2 = localObject3;
              break label332;
            }
            if (((String)localObject5).equals("Navigate"))
            {
              localObject5 = paramElement;
              paramElement = (Element)localObject2;
              localObject1 = localObject3;
              localObject2 = localObject5;
              break label332;
            }
            if (((String)localObject5).equals("Scene"))
            {
              localObject2 = paramElement;
              paramElement = (Element)localObject3;
              break label332;
            }
            if (((String)localObject5).equals("Feedback"))
            {
              localObject5 = paramElement;
              localObject4 = localObject3;
              paramElement = (Element)localObject2;
              localObject2 = localObject5;
              break label332;
            }
          }
        }
        else
        {
          if ((TextUtils.isEmpty(paramElement)) || (TextUtils.isEmpty(localObject1)) || (TextUtils.isEmpty((CharSequence)localObject2))) {
            break;
          }
          if (!paramElement.equals(paramString)) {
            return null;
          }
          i = a((String)localObject2);
          if ((i & paramInt) == 0) {
            return null;
          }
          paramElement = new ArkLocalAppMgr.GetAppPathByActionResult();
          paramElement.d = localObject1;
          paramElement.jdField_b_of_type_Int = i;
          paramElement.e = localObject4;
          return paramElement;
        }
      }
      catch (Exception paramElement)
      {
        ArkAppCenter.b("ArkApp.ArkLocalAppMgr", String.format("_parseAction, exception=%s", new Object[] { paramElement.getMessage() }));
        return null;
      }
      Object localObject3 = localObject2;
      Object localObject2 = paramElement;
      paramElement = (Element)localObject3;
      label332:
      i += 1;
      localObject3 = localObject2;
      localObject2 = paramElement;
      paramElement = (Element)localObject3;
    }
    return null;
  }
  
  private static String a(int paramInt)
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    if (localBaseApplication == null) {
      return "";
    }
    switch (paramInt)
    {
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    default: 
      if (paramInt > 0) {
        return localBaseApplication.getString(2131436174);
      }
      break;
    case 0: 
      return localBaseApplication.getString(2131436167);
    case 5: 
      return localBaseApplication.getString(2131436168);
    case 6: 
      return localBaseApplication.getString(2131436169);
    case 7: 
      return localBaseApplication.getString(2131436170);
    case -1: 
      return localBaseApplication.getString(2131436173);
    case -2: 
      return localBaseApplication.getString(2131436172);
    case -3: 
      return localBaseApplication.getString(2131436171);
    }
    return localBaseApplication.getString(2131436175);
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    Object localObject;
    do
    {
      do
      {
        return null;
        localObject = BaseApplication.getContext();
      } while (localObject == null);
      localObject = ((Context)localObject).getSharedPreferences("ArkAppDescCache", 0);
    } while (localObject == null);
    return ((SharedPreferences)localObject).getString(paramString, null);
  }
  
  /* Error */
  private String a(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_1
    //   4: ifnull +30 -> 34
    //   7: aload_1
    //   8: invokevirtual 164	java/lang/String:length	()I
    //   11: ifeq +23 -> 34
    //   14: aload_2
    //   15: ifnull +19 -> 34
    //   18: aload_2
    //   19: invokevirtual 164	java/lang/String:length	()I
    //   22: ifeq +12 -> 34
    //   25: aload_3
    //   26: ifnull +8 -> 34
    //   29: aload_3
    //   30: arraylength
    //   31: ifne +7 -> 38
    //   34: aconst_null
    //   35: astore_1
    //   36: aload_1
    //   37: areturn
    //   38: new 298	java/io/File
    //   41: dup
    //   42: aload_1
    //   43: invokestatic 300	com/tencent/mobileqq/ark/ArkLocalAppMgr:b	(Ljava/lang/String;)Ljava/lang/String;
    //   46: invokespecial 302	java/io/File:<init>	(Ljava/lang/String;)V
    //   49: astore 5
    //   51: aload 5
    //   53: invokevirtual 305	java/io/File:exists	()Z
    //   56: ifne +85 -> 141
    //   59: aload 5
    //   61: invokevirtual 308	java/io/File:delete	()Z
    //   64: pop
    //   65: aload 5
    //   67: invokevirtual 311	java/io/File:mkdirs	()Z
    //   70: pop
    //   71: aload_1
    //   72: aload_2
    //   73: invokestatic 313	com/tencent/mobileqq/ark/ArkLocalAppMgr:b	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   76: astore 5
    //   78: new 315	java/io/FileOutputStream
    //   81: dup
    //   82: aload 5
    //   84: invokespecial 316	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   87: astore_2
    //   88: aload_2
    //   89: astore_1
    //   90: aload_2
    //   91: aload_3
    //   92: invokevirtual 320	java/io/FileOutputStream:write	([B)V
    //   95: aload 5
    //   97: astore_1
    //   98: aload_2
    //   99: ifnull -63 -> 36
    //   102: aload_2
    //   103: invokevirtual 323	java/io/FileOutputStream:close	()V
    //   106: aload 5
    //   108: areturn
    //   109: astore_1
    //   110: ldc 192
    //   112: new 325	java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial 326	java/lang/StringBuilder:<init>	()V
    //   119: ldc_w 328
    //   122: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: aload_1
    //   126: invokevirtual 273	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   129: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: invokevirtual 335	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: invokestatic 208	com/tencent/mobileqq/ark/ArkAppCenter:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   138: aload 5
    //   140: areturn
    //   141: aload 5
    //   143: invokevirtual 338	java/io/File:isFile	()Z
    //   146: ifeq -75 -> 71
    //   149: aload 5
    //   151: invokevirtual 308	java/io/File:delete	()Z
    //   154: pop
    //   155: aload 5
    //   157: invokevirtual 311	java/io/File:mkdirs	()Z
    //   160: pop
    //   161: goto -90 -> 71
    //   164: astore_3
    //   165: aconst_null
    //   166: astore_2
    //   167: aload_2
    //   168: astore_1
    //   169: aload_3
    //   170: invokevirtual 341	java/lang/Exception:printStackTrace	()V
    //   173: aload_2
    //   174: astore_1
    //   175: ldc 192
    //   177: new 325	java/lang/StringBuilder
    //   180: dup
    //   181: invokespecial 326	java/lang/StringBuilder:<init>	()V
    //   184: ldc_w 328
    //   187: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: aload_3
    //   191: invokevirtual 273	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   194: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: invokevirtual 335	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   200: invokestatic 208	com/tencent/mobileqq/ark/ArkAppCenter:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   203: aload_2
    //   204: ifnull +7 -> 211
    //   207: aload_2
    //   208: invokevirtual 323	java/io/FileOutputStream:close	()V
    //   211: aconst_null
    //   212: areturn
    //   213: astore_1
    //   214: ldc 192
    //   216: new 325	java/lang/StringBuilder
    //   219: dup
    //   220: invokespecial 326	java/lang/StringBuilder:<init>	()V
    //   223: ldc_w 328
    //   226: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: aload_1
    //   230: invokevirtual 273	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   233: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: invokevirtual 335	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   239: invokestatic 208	com/tencent/mobileqq/ark/ArkAppCenter:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   242: goto -31 -> 211
    //   245: astore_1
    //   246: aload 4
    //   248: astore_2
    //   249: aload_2
    //   250: ifnull +7 -> 257
    //   253: aload_2
    //   254: invokevirtual 323	java/io/FileOutputStream:close	()V
    //   257: aload_1
    //   258: athrow
    //   259: astore_2
    //   260: ldc 192
    //   262: new 325	java/lang/StringBuilder
    //   265: dup
    //   266: invokespecial 326	java/lang/StringBuilder:<init>	()V
    //   269: ldc_w 328
    //   272: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: aload_2
    //   276: invokevirtual 273	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   279: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: invokevirtual 335	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   285: invokestatic 208	com/tencent/mobileqq/ark/ArkAppCenter:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   288: goto -31 -> 257
    //   291: astore_3
    //   292: aload_1
    //   293: astore_2
    //   294: aload_3
    //   295: astore_1
    //   296: goto -47 -> 249
    //   299: astore_3
    //   300: goto -133 -> 167
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	303	0	this	ArkLocalAppMgr
    //   0	303	1	paramString1	String
    //   0	303	2	paramString2	String
    //   0	303	3	paramArrayOfByte	byte[]
    //   1	246	4	localObject1	Object
    //   49	107	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   102	106	109	java/lang/Exception
    //   38	71	164	java/lang/Exception
    //   71	88	164	java/lang/Exception
    //   141	161	164	java/lang/Exception
    //   207	211	213	java/lang/Exception
    //   38	71	245	finally
    //   71	88	245	finally
    //   141	161	245	finally
    //   253	257	259	java/lang/Exception
    //   90	95	291	finally
    //   169	173	291	finally
    //   175	203	291	finally
    //   90	95	299	java/lang/Exception
  }
  
  private void a(int paramInt1, int paramInt2, String paramString, ArkLocalAppMgr.UpdateAppByNameTask paramUpdateAppByNameTask)
  {
    boolean bool2 = true;
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        this.jdField_a_of_type_JavaUtilArrayList.remove(paramUpdateAppByNameTask);
        QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        int i = (int)(System.currentTimeMillis() - paramUpdateAppByNameTask.jdField_a_of_type_Long);
        String str = "0";
        ??? = str;
        if (paramUpdateAppByNameTask.jdField_b_of_type_ComTencentMobileqqArkArkLocalAppMgr$AppPathInfo != null)
        {
          ??? = str;
          if (paramUpdateAppByNameTask.jdField_b_of_type_ComTencentMobileqqArkArkLocalAppMgr$AppPathInfo.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDesc != null)
          {
            ??? = str;
            if (!TextUtils.isEmpty(paramUpdateAppByNameTask.jdField_b_of_type_ComTencentMobileqqArkArkLocalAppMgr$AppPathInfo.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDesc.jdField_b_of_type_JavaLangString)) {
              ??? = paramUpdateAppByNameTask.jdField_b_of_type_ComTencentMobileqqArkArkLocalAppMgr$AppPathInfo.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDesc.jdField_b_of_type_JavaLangString;
            }
          }
        }
        ArkAppDataReport.a(localQQAppInterface, paramInt1, paramUpdateAppByNameTask.jdField_b_of_type_JavaLangString, (String)???, NetworkUtil.b(BaseApplication.getContext()), i);
        paramUpdateAppByNameTask.jdField_a_of_type_Int = paramInt1;
        paramUpdateAppByNameTask.jdField_b_of_type_Int = paramInt2;
        paramUpdateAppByNameTask.jdField_a_of_type_JavaLangString = paramString;
        if (paramUpdateAppByNameTask.jdField_b_of_type_Int == 0) {
          break;
        }
        if (paramUpdateAppByNameTask.jdField_b_of_type_Int != 0)
        {
          bool1 = true;
          AssertUtil.a(bool1);
          paramUpdateAppByNameTask.jdField_b_of_type_ComTencentMobileqqArkArkLocalAppMgr$AppPathInfo = null;
          this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.post(new aavp(this, paramUpdateAppByNameTask));
          return;
        }
      }
      bool1 = false;
    }
    if (paramUpdateAppByNameTask.jdField_b_of_type_Int == 0)
    {
      bool1 = true;
      label226:
      AssertUtil.a(bool1);
      if ((paramUpdateAppByNameTask.jdField_b_of_type_ComTencentMobileqqArkArkLocalAppMgr$AppPathInfo == null) || (paramUpdateAppByNameTask.jdField_b_of_type_ComTencentMobileqqArkArkLocalAppMgr$AppPathInfo.jdField_a_of_type_JavaLangString == null)) {
        break label322;
      }
    }
    label322:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      AssertUtil.a(bool1);
      paramInt1 = 1380;
      if (paramUpdateAppByNameTask.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDownloadInfo != null) {
        paramInt1 = (int)(paramUpdateAppByNameTask.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDownloadInfo.jdField_a_of_type_Int * (1.0D + 0.4D * Math.random() - 0.2D));
      }
      paramInt1 = Math.max(paramInt1, 60);
      a(paramUpdateAppByNameTask.jdField_b_of_type_JavaLangString, paramInt1);
      break;
      bool1 = false;
      break label226;
    }
  }
  
  private void a(aavw arg1)
  {
    if ((!jdField_a_of_type_Boolean) && (???.jdField_a_of_type_Boolean != true)) {
      throw new AssertionError();
    }
    if ((!jdField_a_of_type_Boolean) && (!???.jdField_a_of_type_JavaUtilSet.isEmpty())) {
      throw new AssertionError();
    }
    ???.jdField_a_of_type_Boolean = true;
    for (;;)
    {
      synchronized (this.jdField_c_of_type_JavaUtilArrayList)
      {
        if (this.jdField_c_of_type_JavaUtilArrayList.isEmpty()) {
          break label177;
        }
        aavw localaavw = (aavw)this.jdField_c_of_type_JavaUtilArrayList.get(0);
        if (localaavw.jdField_a_of_type_Boolean) {
          break label180;
        }
        if ((!jdField_a_of_type_Boolean) && (localaavw.jdField_a_of_type_JavaUtilSet.isEmpty())) {
          throw new AssertionError();
        }
      }
      ArkAppCenter.b("ArkApp.ArkLocalAppMgr", String.format("previous task not finished, action=%s.%s, unfinished-count=%d, total-count=%d", new Object[] { localObject.jdField_a_of_type_JavaLangString, localObject.jdField_b_of_type_JavaLangString, Integer.valueOf(localObject.jdField_a_of_type_JavaUtilSet.size()), Integer.valueOf(this.jdField_c_of_type_JavaUtilArrayList.size()) }));
      label177:
      return;
      label180:
      this.jdField_c_of_type_JavaUtilArrayList.remove(localObject);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.post(new aavf(this, localObject));
    }
  }
  
  private void a(aavw paramaavw, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    if ((!jdField_a_of_type_Boolean) && (TextUtils.isEmpty(paramString3))) {
      throw new AssertionError();
    }
    ThreadManager.post(new aave(this, paramInt, paramString2, paramString1, paramaavw, paramString3), 5, null, true);
  }
  
  private void a(aavx paramaavx)
  {
    if (paramaavx.jdField_a_of_type_Int != 0) {
      paramaavx.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr$AppPathInfo = null;
    }
    if ((paramaavx.jdField_a_of_type_Int == 0) && ((paramaavx.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr$AppPathInfo == null) || (paramaavx.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr$AppPathInfo.jdField_a_of_type_JavaLangString == null)))
    {
      AssertUtil.a(false);
      paramaavx.jdField_a_of_type_Int = -1;
      ArkAppCenter.b("ArkApp.ArkLocalAppMgr", String.format("notifyGetAppPathByNameTaskResult, retCode is success but task.appPathInfo.path==NULL, retCode=%d, app-name=%s", new Object[] { Integer.valueOf(paramaavx.jdField_a_of_type_Int), paramaavx.jdField_b_of_type_JavaLangString }));
    }
    ArkAppDataReport.a((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), paramaavx.jdField_b_of_type_JavaLangString, paramaavx.jdField_a_of_type_Int, System.currentTimeMillis() - paramaavx.jdField_a_of_type_Long, NetworkUtil.b(BaseApplication.getContext()));
    ArkLocalAppMgr.IGetAppPathByNameCallback localIGetAppPathByNameCallback = paramaavx.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr$IGetAppPathByNameCallback;
    if (localIGetAppPathByNameCallback != null)
    {
      if ((paramaavx.jdField_a_of_type_JavaLangString == null) || (paramaavx.jdField_a_of_type_JavaLangString.length() == 0)) {
        paramaavx.jdField_a_of_type_JavaLangString = a(paramaavx.jdField_a_of_type_Int);
      }
      localIGetAppPathByNameCallback.a(paramaavx.jdField_a_of_type_Int, paramaavx.jdField_a_of_type_JavaLangString, paramaavx.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr$AppPathInfo, paramaavx.jdField_a_of_type_JavaLangObject);
    }
  }
  
  private void a(aawa arg1)
  {
    ???.jdField_a_of_type_Boolean = true;
    Object localObject1 = new ArrayList();
    synchronized (this.d)
    {
      aawa localaawa;
      if (this.d.size() > 0)
      {
        localaawa = (aawa)this.d.get(0);
        if (localaawa.jdField_a_of_type_Boolean) {}
      }
      else
      {
        ??? = ((ArrayList)localObject1).iterator();
        while (???.hasNext())
        {
          localObject1 = (aawa)???.next();
          ((aawa)localObject1).jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr$IGetAppViewByIntentCallback.a(((aawa)localObject1).jdField_a_of_type_JavaLangString, ((aawa)localObject1).jdField_b_of_type_JavaLangString, ((aawa)localObject1).d, ((aawa)localObject1).e, ((aawa)localObject1).c);
        }
      }
      ((ArrayList)localObject1).add(localaawa);
      this.d.remove(0);
    }
  }
  
  private void a(aawb paramaawb)
  {
    aavu localaavu = new aavu(null);
    localaavu.jdField_a_of_type_Boolean = false;
    ThreadManager.post(new aavq(this, localaavu, paramaawb), 5, null, true);
  }
  
  private void a(aawc paramaawc)
  {
    ThreadManager.post(new aaux(this, new aavv(null), paramaawc), 5, null, true);
  }
  
  private void a(aawe paramaawe)
  {
    if ((paramaawe == null) || (paramaawe.jdField_a_of_type_JavaUtilArrayList == null) || (paramaawe.jdField_a_of_type_JavaUtilArrayList.size() == 0) || (!ArkAppCenter.b())) {
      return;
    }
    a(paramaawe.jdField_a_of_type_JavaUtilArrayList, paramaawe, new aauv(this));
  }
  
  private void a(ArkAppCGI.QueryAppInfoByAppNameBatchResult paramQueryAppInfoByAppNameBatchResult, HashMap paramHashMap)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localQQAppInterface == null)
    {
      ArkAppCenter.b("ArkApp.ArkLocalAppMgr", String.format("onUpdateApp_QueryAppInfoByAppNameResult app=null, task-count=%d", new Object[] { Integer.valueOf(paramHashMap.size()) }));
      paramQueryAppInfoByAppNameBatchResult = paramHashMap.values().iterator();
      while (paramQueryAppInfoByAppNameBatchResult.hasNext()) {
        a(0, -1, null, (ArkLocalAppMgr.UpdateAppByNameTask)paramQueryAppInfoByAppNameBatchResult.next());
      }
    }
    if (paramQueryAppInfoByAppNameBatchResult.jdField_a_of_type_Int > 0) {
      this.jdField_b_of_type_Long = paramQueryAppInfoByAppNameBatchResult.jdField_a_of_type_Int;
    }
    Iterator localIterator = paramHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ArkLocalAppMgr.UpdateAppByNameTask localUpdateAppByNameTask = (ArkLocalAppMgr.UpdateAppByNameTask)paramHashMap.get(str);
      ArkAppCGI.QueryAppInfoResult localQueryAppInfoResult = (ArkAppCGI.QueryAppInfoResult)paramQueryAppInfoByAppNameBatchResult.jdField_a_of_type_JavaUtilHashMap.get(str);
      if (localQueryAppInfoResult == null)
      {
        ArkAppCenter.b("ArkApp.ArkLocalAppMgr", String.format("onUpdateApp_QueryAppInfoByAppNameResult, info is null, app-name=%s", new Object[] { str }));
        a(0, -2, null, localUpdateAppByNameTask);
      }
      else if (localQueryAppInfoResult.jdField_a_of_type_Int != 0)
      {
        ArkAppCenter.b("ArkApp.ArkLocalAppMgr", String.format("onUpdateApp_QueryAppInfoByAppNameResult, retCode is not SUCCESS, app-name=%s, ret-code=%d", new Object[] { str, Integer.valueOf(localQueryAppInfoResult.jdField_a_of_type_Int) }));
        a(0, localQueryAppInfoResult.jdField_a_of_type_Int, localQueryAppInfoResult.jdField_a_of_type_JavaLangString, localUpdateAppByNameTask);
      }
      else if (localQueryAppInfoResult.jdField_b_of_type_Int == 3)
      {
        ArkAppCenter.b("ArkApp.ArkLocalAppMgr", String.format("onUpdateApp_QueryAppInfoByAppNameResult, app offline, app=%s", new Object[] { str }));
        a(str, true);
        a(0, -5, localQueryAppInfoResult.jdField_a_of_type_JavaLangString, localUpdateAppByNameTask);
      }
      else if (localQueryAppInfoResult.jdField_b_of_type_Int == 2)
      {
        ArkAppCenter.b("ArkApp.ArkLocalAppMgr", String.format("onUpdateApp_QueryAppInfoByAppNameResult, app no update, app=%s", new Object[] { str }));
        if (localUpdateAppByNameTask.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr$AppPathInfo != null)
        {
          ArkAppCenter.b("ArkApp.ArkLocalAppMgr", String.format("onUpdateApp_QueryAppInfoByAppNameResult, no update, app-name=%s, local-ver=%s", new Object[] { str, localUpdateAppByNameTask.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr$AppPathInfo.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDesc.jdField_b_of_type_JavaLangString }));
          localUpdateAppByNameTask.jdField_b_of_type_ComTencentMobileqqArkArkLocalAppMgr$AppPathInfo = localUpdateAppByNameTask.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr$AppPathInfo;
          a(2, 0, null, localUpdateAppByNameTask);
        }
        else
        {
          ArkAppCenter.b("ArkApp.ArkLocalAppMgr", String.format("onUpdateApp_QueryAppInfoByAppNameResult, no update, no invalid local info, app=%s", new Object[] { str }));
          a(0, -1, null, localUpdateAppByNameTask);
        }
      }
      else if (localQueryAppInfoResult.jdField_b_of_type_Int == 1)
      {
        if (localQueryAppInfoResult.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDownloadInfo == null)
        {
          ArkAppCenter.b("ArkApp.ArkLocalAppMgr", String.format(Locale.CHINA, "onUpdateApp_QueryAppInfoByAppNameResult, appResult.info is NULL, app-name=%s, ret-code=%d", new Object[] { str, Integer.valueOf(localQueryAppInfoResult.jdField_a_of_type_Int) }));
          a(0, -1, null, localUpdateAppByNameTask);
        }
        else
        {
          localUpdateAppByNameTask.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDownloadInfo = localQueryAppInfoResult.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDownloadInfo;
          localUpdateAppByNameTask.jdField_b_of_type_ComTencentMobileqqArkArkLocalAppMgr$AppPathInfo = new ArkLocalAppMgr.AppPathInfo();
          localUpdateAppByNameTask.jdField_b_of_type_ComTencentMobileqqArkArkLocalAppMgr$AppPathInfo.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDesc = localQueryAppInfoResult.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDownloadInfo.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDesc;
          ArkAppCGI localArkAppCGI = ((ArkAppCenter)localQQAppInterface.getManager(120)).a();
          SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("ArkLocalAppUpdateTime", 0).edit();
          localEditor.putString(str + "_sign", Base64.encodeToString(localQueryAppInfoResult.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDownloadInfo.jdField_a_of_type_ArrayOfByte, 0));
          localEditor.commit();
          localArkAppCGI.a(localQueryAppInfoResult.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDownloadInfo.jdField_a_of_type_JavaLangString, localQueryAppInfoResult.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDownloadInfo.jdField_a_of_type_ArrayOfByte, localUpdateAppByNameTask, new aavn(this));
        }
      }
      else
      {
        ArkAppCenter.b("ArkApp.ArkLocalAppMgr", String.format(Locale.CHINA, "onUpdateApp_QueryAppInfoByAppNameResult, invalid app state, app=%s, state=%d", new Object[] { str, Integer.valueOf(localQueryAppInfoResult.jdField_b_of_type_Int) }));
        a(0, -1, null, localUpdateAppByNameTask);
      }
    }
  }
  
  private static void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ThreadManager.post(new aavh(paramString), 5, null, false);
  }
  
  private void a(String paramString, int paramInt)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return;
    }
    synchronized (this.jdField_c_of_type_JavaUtilHashMap)
    {
      long l = System.currentTimeMillis();
      this.jdField_c_of_type_JavaUtilHashMap.put(paramString, new aavt(l, paramInt));
      a(paramString, l);
      b(paramString, paramInt);
      return;
    }
  }
  
  private static void a(String paramString, long paramLong)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return;
    }
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("ArkAppUpdateRecord", 0).edit();
    localEditor.putLong(paramString, paramLong);
    localEditor.commit();
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    do
    {
      do
      {
        return;
        localObject = BaseApplication.getContext();
      } while (localObject == null);
      localObject = ((Context)localObject).getSharedPreferences("ArkAppDescCache", 0);
    } while (localObject == null);
    Object localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putString(paramString1, paramString2);
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  /* Error */
  private static void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnull +23 -> 27
    //   7: aload_0
    //   8: invokevirtual 164	java/lang/String:length	()I
    //   11: ifeq +16 -> 27
    //   14: aload_1
    //   15: ifnull +12 -> 27
    //   18: aload_1
    //   19: invokevirtual 164	java/lang/String:length	()I
    //   22: istore_3
    //   23: iload_3
    //   24: ifne +7 -> 31
    //   27: ldc 2
    //   29: monitorexit
    //   30: return
    //   31: aload_0
    //   32: invokestatic 300	com/tencent/mobileqq/ark/ArkLocalAppMgr:b	(Ljava/lang/String;)Ljava/lang/String;
    //   35: astore_0
    //   36: aload_0
    //   37: ifnull -10 -> 27
    //   40: aload_0
    //   41: invokevirtual 164	java/lang/String:length	()I
    //   44: ifeq -17 -> 27
    //   47: new 298	java/io/File
    //   50: dup
    //   51: aload_0
    //   52: invokespecial 302	java/io/File:<init>	(Ljava/lang/String;)V
    //   55: astore_0
    //   56: aload_0
    //   57: invokevirtual 710	java/io/File:isDirectory	()Z
    //   60: ifeq -33 -> 27
    //   63: aload_0
    //   64: invokevirtual 305	java/io/File:exists	()Z
    //   67: ifeq -40 -> 27
    //   70: aload_0
    //   71: new 712	aavk
    //   74: dup
    //   75: aload_1
    //   76: iload_2
    //   77: invokespecial 714	aavk:<init>	(Ljava/lang/String;Z)V
    //   80: invokevirtual 718	java/io/File:listFiles	(Ljava/io/FileFilter;)[Ljava/io/File;
    //   83: pop
    //   84: goto -57 -> 27
    //   87: astore_0
    //   88: ldc 2
    //   90: monitorexit
    //   91: aload_0
    //   92: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	paramString1	String
    //   0	93	1	paramString2	String
    //   0	93	2	paramBoolean	boolean
    //   22	2	3	i	int
    // Exception table:
    //   from	to	target	type
    //   7	14	87	finally
    //   18	23	87	finally
    //   31	36	87	finally
    //   40	84	87	finally
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    int i = 0;
    paramString = b(paramString);
    if (paramBoolean)
    {
      File localFile = new File(String.format("%s_%d", new Object[] { paramString, Long.valueOf(System.currentTimeMillis()) }));
      new File(paramString).renameTo(localFile);
      a(localFile);
    }
    for (;;)
    {
      return;
      paramString = new File(paramString);
      if (paramString.isFile())
      {
        a(paramString);
        return;
      }
      paramString = paramString.listFiles();
      if (paramString != null)
      {
        int j = paramString.length;
        while (i < j)
        {
          paramString[i].delete();
          i += 1;
        }
      }
    }
  }
  
  private void a(ArrayList paramArrayList, Object paramObject, aawd paramaawd)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localQQAppInterface == null)
    {
      ArkAppCenter.b("ArkApp.ArkLocalAppMgr", String.format("updateAppByName, app=null", new Object[0]));
      return;
    }
    ThreadManager.post(new aavl(this, paramArrayList, paramObject, paramaawd, localQQAppInterface), 5, null, true);
  }
  
  private void a(boolean paramBoolean, byte[] paramArrayOfByte, ArkLocalAppMgr.UpdateAppByNameTask paramUpdateAppByNameTask)
  {
    if ((!paramBoolean) || (paramArrayOfByte.length == 0))
    {
      ArkAppCenter.b("ArkApp.ArkLocalAppMgr", String.format("onUpdateApp_DownloadAppPackageResult fail, app-name=%s", new Object[] { paramUpdateAppByNameTask.jdField_b_of_type_JavaLangString }));
      a(0, -2, null, paramUpdateAppByNameTask);
      return;
    }
    paramArrayOfByte = a(paramUpdateAppByNameTask.jdField_b_of_type_ComTencentMobileqqArkArkLocalAppMgr$AppPathInfo.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDesc.jdField_a_of_type_JavaLangString, paramUpdateAppByNameTask.jdField_b_of_type_ComTencentMobileqqArkArkLocalAppMgr$AppPathInfo.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDesc.jdField_b_of_type_JavaLangString, paramArrayOfByte);
    if (paramArrayOfByte == null)
    {
      ArkAppCenter.b("ArkApp.ArkLocalAppMgr", String.format("onUpdateApp_DownloadAppPackageResult, copyAppPackageToAppInstallDir fail, app-name=%s, app-version=%s", new Object[] { paramUpdateAppByNameTask.jdField_b_of_type_ComTencentMobileqqArkArkLocalAppMgr$AppPathInfo.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDesc.jdField_a_of_type_JavaLangString, paramUpdateAppByNameTask.jdField_b_of_type_ComTencentMobileqqArkArkLocalAppMgr$AppPathInfo.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDesc.jdField_b_of_type_JavaLangString }));
      a(0, -3, null, paramUpdateAppByNameTask);
      return;
    }
    int i = ArkAppCenter.a(paramArrayOfByte);
    if (i != 1)
    {
      ArkAppCenter.b("ArkApp.ArkLocalAppMgr", String.format("onUpdateApp_DownloadAppPackageResult, arkCheckAppVersion fail, ret=%d, app-name=%s, app-path=%s", new Object[] { Integer.valueOf(i), paramUpdateAppByNameTask.jdField_b_of_type_JavaLangString, paramArrayOfByte }));
      a(paramUpdateAppByNameTask.jdField_b_of_type_JavaLangString, false);
      a(0, 7, null, paramUpdateAppByNameTask);
      return;
    }
    String str = ArkAppCenter.b(paramArrayOfByte);
    a(paramUpdateAppByNameTask.jdField_b_of_type_ComTencentMobileqqArkArkLocalAppMgr$AppPathInfo.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDesc.jdField_a_of_type_JavaLangString, str);
    ArkAppCenter.b("ArkApp.ArkLocalAppMgr", String.format("onUpdateApp_DownloadAppPackageResult, success, app-name=%s, app-version=%s, app-path=%s", new Object[] { paramUpdateAppByNameTask.jdField_b_of_type_ComTencentMobileqqArkArkLocalAppMgr$AppPathInfo.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDesc.jdField_a_of_type_JavaLangString, paramUpdateAppByNameTask.jdField_b_of_type_ComTencentMobileqqArkArkLocalAppMgr$AppPathInfo.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDesc.jdField_b_of_type_JavaLangString, paramArrayOfByte }));
    paramUpdateAppByNameTask.jdField_b_of_type_ComTencentMobileqqArkArkLocalAppMgr$AppPathInfo.jdField_a_of_type_JavaLangString = paramArrayOfByte;
    a(paramUpdateAppByNameTask.jdField_b_of_type_JavaLangString, paramUpdateAppByNameTask.jdField_b_of_type_ComTencentMobileqqArkArkLocalAppMgr$AppPathInfo.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDesc.jdField_b_of_type_JavaLangString, true);
    a(1, 0, null, paramUpdateAppByNameTask);
  }
  
  public static boolean a(File paramFile)
  {
    int i = 0;
    if (paramFile != null)
    {
      if (!paramFile.isFile()) {
        break label28;
      }
      if (paramFile.delete()) {
        break label26;
      }
      paramFile.deleteOnExit();
    }
    label26:
    label28:
    while (!paramFile.isDirectory())
    {
      return false;
      return true;
    }
    File[] arrayOfFile = paramFile.listFiles();
    if (arrayOfFile != null)
    {
      int j = arrayOfFile.length;
      while (i < j)
      {
        a(arrayOfFile[i]);
        i += 1;
      }
    }
    return paramFile.delete();
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!paramString.matches("^[\\w\\d]+(\\.[\\w\\d]+)+$")) {
      return false;
    }
    return true;
  }
  
  /* Error */
  private byte[] a(String paramString)
  {
    // Byte code:
    //   0: new 298	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 302	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore 7
    //   10: aload 7
    //   12: invokevirtual 776	java/io/File:length	()J
    //   15: lstore 4
    //   17: lload 4
    //   19: ldc2_w 777
    //   22: lcmp
    //   23: ifle +5 -> 28
    //   26: aconst_null
    //   27: areturn
    //   28: lload 4
    //   30: l2i
    //   31: newarray byte
    //   33: astore 8
    //   35: new 780	java/io/FileInputStream
    //   38: dup
    //   39: aload 7
    //   41: invokespecial 783	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   44: astore 6
    //   46: iconst_0
    //   47: istore_2
    //   48: aload 6
    //   50: astore_1
    //   51: iload_2
    //   52: aload 8
    //   54: arraylength
    //   55: if_icmpge +31 -> 86
    //   58: aload 6
    //   60: astore_1
    //   61: aload 6
    //   63: aload 8
    //   65: iload_2
    //   66: aload 8
    //   68: arraylength
    //   69: iload_2
    //   70: isub
    //   71: invokevirtual 787	java/io/FileInputStream:read	([BII)I
    //   74: istore_3
    //   75: iload_3
    //   76: iflt +10 -> 86
    //   79: iload_2
    //   80: iload_3
    //   81: iadd
    //   82: istore_2
    //   83: goto -35 -> 48
    //   86: aload 6
    //   88: astore_1
    //   89: iload_2
    //   90: aload 8
    //   92: arraylength
    //   93: if_icmpeq +61 -> 154
    //   96: aload 6
    //   98: astore_1
    //   99: new 774	java/io/IOException
    //   102: dup
    //   103: new 325	java/lang/StringBuilder
    //   106: dup
    //   107: invokespecial 326	java/lang/StringBuilder:<init>	()V
    //   110: ldc_w 789
    //   113: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: aload 7
    //   118: invokevirtual 792	java/io/File:getName	()Ljava/lang/String;
    //   121: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: invokevirtual 335	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: invokespecial 793	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   130: athrow
    //   131: astore 7
    //   133: aload 6
    //   135: astore_1
    //   136: aload 7
    //   138: invokevirtual 794	java/io/IOException:printStackTrace	()V
    //   141: aload 6
    //   143: ifnull +8 -> 151
    //   146: aload 6
    //   148: invokevirtual 795	java/io/FileInputStream:close	()V
    //   151: aload 8
    //   153: areturn
    //   154: aload 6
    //   156: astore_1
    //   157: aload 6
    //   159: invokevirtual 795	java/io/FileInputStream:close	()V
    //   162: aload 6
    //   164: ifnull -13 -> 151
    //   167: aload 6
    //   169: invokevirtual 795	java/io/FileInputStream:close	()V
    //   172: goto -21 -> 151
    //   175: astore_1
    //   176: ldc 192
    //   178: new 325	java/lang/StringBuilder
    //   181: dup
    //   182: invokespecial 326	java/lang/StringBuilder:<init>	()V
    //   185: ldc_w 797
    //   188: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: aload_1
    //   192: invokevirtual 798	java/io/IOException:getMessage	()Ljava/lang/String;
    //   195: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: invokevirtual 335	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: iconst_0
    //   202: anewarray 4	java/lang/Object
    //   205: invokestatic 205	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   208: invokestatic 208	com/tencent/mobileqq/ark/ArkAppCenter:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   211: goto -60 -> 151
    //   214: astore_1
    //   215: ldc 192
    //   217: new 325	java/lang/StringBuilder
    //   220: dup
    //   221: invokespecial 326	java/lang/StringBuilder:<init>	()V
    //   224: ldc_w 797
    //   227: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: aload_1
    //   231: invokevirtual 798	java/io/IOException:getMessage	()Ljava/lang/String;
    //   234: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: invokevirtual 335	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: iconst_0
    //   241: anewarray 4	java/lang/Object
    //   244: invokestatic 205	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   247: invokestatic 208	com/tencent/mobileqq/ark/ArkAppCenter:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   250: goto -99 -> 151
    //   253: astore 6
    //   255: aconst_null
    //   256: astore_1
    //   257: aload_1
    //   258: ifnull +7 -> 265
    //   261: aload_1
    //   262: invokevirtual 795	java/io/FileInputStream:close	()V
    //   265: aload 6
    //   267: athrow
    //   268: astore_1
    //   269: ldc 192
    //   271: new 325	java/lang/StringBuilder
    //   274: dup
    //   275: invokespecial 326	java/lang/StringBuilder:<init>	()V
    //   278: ldc_w 797
    //   281: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: aload_1
    //   285: invokevirtual 798	java/io/IOException:getMessage	()Ljava/lang/String;
    //   288: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: invokevirtual 335	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   294: iconst_0
    //   295: anewarray 4	java/lang/Object
    //   298: invokestatic 205	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   301: invokestatic 208	com/tencent/mobileqq/ark/ArkAppCenter:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   304: goto -39 -> 265
    //   307: astore 6
    //   309: goto -52 -> 257
    //   312: astore 7
    //   314: aconst_null
    //   315: astore 6
    //   317: goto -184 -> 133
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	320	0	this	ArkLocalAppMgr
    //   0	320	1	paramString	String
    //   47	47	2	i	int
    //   74	8	3	j	int
    //   15	14	4	l	long
    //   44	124	6	localFileInputStream	java.io.FileInputStream
    //   253	13	6	localObject1	Object
    //   307	1	6	localObject2	Object
    //   315	1	6	localObject3	Object
    //   8	109	7	localFile	File
    //   131	6	7	localIOException1	java.io.IOException
    //   312	1	7	localIOException2	java.io.IOException
    //   33	119	8	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   51	58	131	java/io/IOException
    //   61	75	131	java/io/IOException
    //   89	96	131	java/io/IOException
    //   99	131	131	java/io/IOException
    //   157	162	131	java/io/IOException
    //   167	172	175	java/io/IOException
    //   146	151	214	java/io/IOException
    //   35	46	253	finally
    //   261	265	268	java/io/IOException
    //   51	58	307	finally
    //   61	75	307	finally
    //   89	96	307	finally
    //   99	131	307	finally
    //   136	141	307	finally
    //   157	162	307	finally
    //   35	46	312	java/io/IOException
  }
  
  private static int b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return 0;
      if (paramString.equals("MsgFlow")) {
        return 1;
      }
      if (paramString.equals("Input")) {
        return 2;
      }
    } while (!paramString.equals("MsgFlowSearch"));
    return 4;
  }
  
  private static int b(String paramString1, String paramString2)
  {
    int m = 0;
    paramString1 = paramString1.split("\\.");
    paramString2 = paramString2.split("\\.");
    int i = 0;
    int j = m;
    if (i < 4) {}
    for (;;)
    {
      try
      {
        if (paramString1.length <= i) {
          break label122;
        }
        j = Integer.parseInt(paramString1[i]);
        if (paramString2.length <= i) {
          break label116;
        }
        k = Integer.parseInt(paramString2[i]);
        if (j > k)
        {
          j = 1;
          return j;
        }
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        ArkAppCenter.b("ArkApp.ArkLocalAppMgr", "compareVersionString: Exception:" + paramString1.getMessage());
        return 0;
      }
      if (j < k) {
        return -1;
      }
      i += 1;
      break;
      label116:
      int k = 0;
      continue;
      label122:
      j = 0;
    }
  }
  
  private ArkLocalAppMgr.AppPathInfo b(String paramString)
  {
    ArkLocalAppMgr.AppPathInfo localAppPathInfo;
    synchronized (this.jdField_b_of_type_JavaUtilHashMap)
    {
      localAppPathInfo = (ArkLocalAppMgr.AppPathInfo)this.jdField_b_of_type_JavaUtilHashMap.get(paramString);
      if ((localAppPathInfo != null) && (localAppPathInfo.jdField_a_of_type_JavaLangString != null))
      {
        ??? = new File(localAppPathInfo.jdField_a_of_type_JavaLangString);
        if ((((File)???).exists()) && (((File)???).isFile())) {
          return localAppPathInfo;
        }
      }
    }
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      localAppPathInfo = (ArkLocalAppMgr.AppPathInfo)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
      ??? = localAppPathInfo;
      if (localAppPathInfo != null)
      {
        if (localAppPathInfo.jdField_a_of_type_JavaLangString != null) {
          break label144;
        }
        this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
        ??? = null;
      }
      label144:
      File localFile;
      do
      {
        if (??? != null) {
          return ???;
        }
        localAppPathInfo = c(paramString);
        if (localAppPathInfo != null) {
          break label197;
        }
        return null;
        paramString = finally;
        throw paramString;
        localFile = new File(localAppPathInfo.jdField_a_of_type_JavaLangString);
        if (!localFile.exists()) {
          break;
        }
        ??? = localAppPathInfo;
      } while (localFile.isFile());
      this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
      ??? = null;
    }
    label197:
    int i = ArkAppCenter.a(localAppPathInfo.jdField_a_of_type_JavaLangString);
    if (i != 1)
    {
      ArkAppCenter.b("ArkApp.ArkLocalAppMgr", String.format("getAppPathByNameFromLocal, arkCheckAppVersion fail, ret=%d, app-name=%s, app-ver=%s", new Object[] { Integer.valueOf(i), paramString, localAppPathInfo.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDesc.jdField_b_of_type_JavaLangString }));
      a(paramString, false);
      return null;
    }
    if ((!jdField_a_of_type_Boolean) && (localAppPathInfo == null)) {
      throw new AssertionError();
    }
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localAppPathInfo);
      return localAppPathInfo;
    }
    return ???;
  }
  
  public static String b(String paramString)
  {
    return String.format("%s/%s", new Object[] { ArkAppCenter.d(), paramString });
  }
  
  public static String b(String paramString1, String paramString2)
  {
    return String.format("%s/%s.app", new Object[] { b(paramString1), paramString2 });
  }
  
  private static void b(String paramString, int paramInt)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return;
    }
    paramInt = Math.max(10, paramInt);
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("ArkAppUpdatePeriod", 0).edit();
    localEditor.putInt(paramString, paramInt);
    localEditor.commit();
  }
  
  private static void b(String paramString1, String paramString2, int paramInt, ArrayList paramArrayList)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (paramArrayList == null)) {}
    do
    {
      return;
      paramArrayList.clear();
      paramString1 = ArkAppCenter.a(paramString1);
      if (TextUtils.isEmpty(paramString1))
      {
        ArkAppCenter.b("ArkApp.ArkLocalAppMgr", "findAppViewMatchIntent, manifest is empty");
        return;
      }
      try
      {
        localObject = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(paramString1.getBytes()));
        if (localObject == null)
        {
          ArkAppCenter.b("ArkApp.ArkLocalAppMgr", String.format("findAppViewMatchIntent, fail to parse xml, content=%s", new Object[] { paramString1 }));
          return;
        }
      }
      catch (Exception paramString1)
      {
        ArkAppCenter.b("ArkApp.ArkLocalAppMgr", String.format("findAppViewMatchIntent, exception, msg=%s", new Object[] { paramString1.getMessage() }));
        return;
      }
      localObject = ((Document)localObject).getElementsByTagName("ActionSet");
      if ((localObject == null) || (((NodeList)localObject).getLength() == 0))
      {
        ArkAppCenter.b("ArkApp.ArkLocalAppMgr", String.format("findAppViewMatchIntent, fail to get 'ActionSet' node, content=%s", new Object[] { paramString1 }));
        return;
      }
      localObject = ((NodeList)localObject).item(0);
      if ((localObject == null) || (((Node)localObject).getNodeType() != 1))
      {
        ArkAppCenter.b("ArkApp.ArkLocalAppMgr", String.format("findAppViewMatchIntent, 'ActionSet' Node is not element node", new Object[0]));
        return;
      }
      localObject = (Element)localObject;
    } while (localObject == null);
    Object localObject = ((Element)localObject).getElementsByTagName("Action");
    if (localObject == null)
    {
      ArkAppCenter.b("ArkApp.ArkLocalAppMgr", String.format("findAppViewMatchIntent, fail to get 'Action' node, content=%s", new Object[] { paramString1 }));
      return;
    }
    int j = ((NodeList)localObject).getLength();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        paramString1 = ((NodeList)localObject).item(i);
        if (paramString1 != null)
        {
          paramString1 = a((Element)paramString1, paramString2, paramInt);
          if (paramString1 != null) {
            paramArrayList.add(paramString1);
          }
        }
      }
      else
      {
        if (paramArrayList.isEmpty())
        {
          ArkAppCenter.b("ArkApp.ArkLocalAppMgr", String.format("findAppViewMatchIntent, 'Action' not found, intent=%s, scene=%d", new Object[] { paramString2, Integer.valueOf(paramInt) }));
          return;
        }
        ArkAppCenter.b("ArkApp.ArkLocalAppMgr", String.format("findAppViewMatchIntent, 'Action' found, intent=%s, scene=%d", new Object[] { paramString2, Integer.valueOf(paramInt) }));
        return;
      }
      i += 1;
    }
  }
  
  private void b(String paramString1, String paramString2, Object paramObject, ArkLocalAppMgr.IGetAppPathByNameCallback paramIGetAppPathByNameCallback)
  {
    Object localObject = a(paramString1, paramString2);
    if ((localObject != null) && ((paramString2 == null) || (b(((ArkLocalAppMgr.AppPathInfo)localObject).jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDesc.jdField_b_of_type_JavaLangString, paramString2) >= 0)))
    {
      paramString1 = new aavx();
      paramString1.jdField_a_of_type_Int = 0;
      paramString1.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr$AppPathInfo = ((ArkLocalAppMgr.AppPathInfo)localObject);
      paramString1.jdField_a_of_type_JavaLangObject = paramObject;
      paramString1.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr$IGetAppPathByNameCallback = paramIGetAppPathByNameCallback;
      paramString1.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(a(), this);
      paramString1.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(1916, paramString1).sendToTarget();
      return;
    }
    ArkAppCenter.b("ArkApp.ArkLocalAppMgr", String.format("getAppPathByName, app not found at local, update app, app-name=%s, min-ver=%s", new Object[] { paramString1, paramString2 }));
    localObject = new aavx();
    ((aavx)localObject).jdField_a_of_type_Int = -1;
    ((aavx)localObject).jdField_b_of_type_JavaLangString = paramString1;
    ((aavx)localObject).c = paramString2;
    ((aavx)localObject).jdField_a_of_type_JavaLangObject = paramObject;
    ((aavx)localObject).jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr$IGetAppPathByNameCallback = paramIGetAppPathByNameCallback;
    ((aavx)localObject).jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr$AppPathInfo = null;
    ((aavx)localObject).jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(a(), this);
    paramString2 = new ArrayList();
    paramString2.add(paramString1);
    a(paramString2, localObject, new aavi(this));
  }
  
  private static String[] b()
  {
    File[] arrayOfFile = new File(ArkAppCenter.d()).listFiles(new aauy());
    if ((arrayOfFile == null) || (arrayOfFile.length == 0)) {
      return null;
    }
    String[] arrayOfString = new String[arrayOfFile.length];
    int i = 0;
    while (i < arrayOfFile.length)
    {
      arrayOfString[i] = arrayOfFile[i].getName();
      i += 1;
    }
    return arrayOfString;
  }
  
  private static ArkLocalAppMgr.AppPathInfo c(String paramString)
  {
    Object localObject2 = b(paramString);
    Object localObject1 = localObject2;
    if (!((String)localObject2).endsWith("/")) {
      localObject1 = ((String)localObject2).concat("/");
    }
    File[] arrayOfFile = new File((String)localObject1).listFiles(new aauw());
    if (arrayOfFile == null) {
      localObject2 = null;
    }
    int j;
    int i;
    do
    {
      return localObject2;
      j = arrayOfFile.length;
      localObject1 = null;
      i = 0;
      localObject2 = localObject1;
    } while (i >= j);
    File localFile = arrayOfFile[i];
    localObject2 = localFile.getName();
    int k = ((String)localObject2).lastIndexOf('.');
    if (k < 0) {
      localObject2 = localObject1;
    }
    for (;;)
    {
      i += 1;
      localObject1 = localObject2;
      break;
      String str1 = ((String)localObject2).substring(k);
      String str2 = ((String)localObject2).substring(0, k);
      localObject2 = localObject1;
      if (str1.toLowerCase().equals(".app"))
      {
        localObject2 = localObject1;
        if (e(str2)) {
          if (localObject1 == null)
          {
            localObject2 = new ArkLocalAppMgr.AppPathInfo();
            ((ArkLocalAppMgr.AppPathInfo)localObject2).jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDesc.jdField_a_of_type_JavaLangString = paramString;
            ((ArkLocalAppMgr.AppPathInfo)localObject2).jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDesc.jdField_b_of_type_JavaLangString = str2;
            ((ArkLocalAppMgr.AppPathInfo)localObject2).jdField_a_of_type_JavaLangString = localFile.getAbsolutePath();
          }
          else
          {
            localObject2 = localObject1;
            if (b(str2, ((ArkLocalAppMgr.AppPathInfo)localObject1).jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDesc.jdField_b_of_type_JavaLangString) > 0)
            {
              ((ArkLocalAppMgr.AppPathInfo)localObject1).jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDesc.jdField_a_of_type_JavaLangString = paramString;
              ((ArkLocalAppMgr.AppPathInfo)localObject1).jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDesc.jdField_b_of_type_JavaLangString = str2;
              ((ArkLocalAppMgr.AppPathInfo)localObject1).jdField_a_of_type_JavaLangString = localFile.getAbsolutePath();
              localObject2 = localObject1;
            }
          }
        }
      }
    }
  }
  
  private boolean c(String paramString)
  {
    Object localObject1;
    Object localObject2;
    do
    {
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        if (this.jdField_a_of_type_JavaUtilHashMap.get(paramString) != null)
        {
          if (((ArkLocalAppMgr.AppPathInfo)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).jdField_a_of_type_JavaLangString == null)
          {
            this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
            ArkAppCenter.b("ArkApp.ArkLocalAppMgr", String.format("checkSignAfterAppPathCache, cachePath is error and checkCache is failed", new Object[0]));
          }
        }
        else {
          return true;
        }
        localObject1 = new File(((ArkLocalAppMgr.AppPathInfo)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).jdField_a_of_type_JavaLangString);
        if ((!((File)localObject1).exists()) || (!((File)localObject1).isFile()))
        {
          this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
          ArkAppCenter.b("ArkApp.ArkLocalAppMgr", String.format("checkSignAfterAppPathCache, cacheFile is error and checkCache is failed", new Object[0]));
        }
      }
      localObject1 = a(BaseApplication.getContext().getSharedPreferences("ArkLocalAppUpdateTime", 0).getString(paramString + "_sign", "bad"));
      localObject2 = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localObject2 == null)
      {
        ArkAppCenter.b("ArkApp.ArkLocalAppMgr", String.format("checkSignAfterAppPathCache, app=null", new Object[0]));
        return false;
      }
      localObject2 = ((ArkAppCenter)((QQAppInterface)localObject2).getManager(120)).a();
      if (localObject1 == null)
      {
        ArkAppCenter.b("ArkApp.ArkLocalAppMgr", String.format("checkSignAfterAppPathCache, checksign is null", new Object[0]));
        return false;
      }
    } while ((localObject1.length <= 0) || (((ArkAppCGI)localObject2).a(a(paramString), (byte[])localObject1) != true));
    a(paramString, false);
    ArkAppCenter.b("ArkApp.ArkLocalAppMgr", String.format("checkSignAfterAppPathCache, checksign is failed and app is clear", new Object[0]));
    return false;
  }
  
  public static void d()
  {
    String[] arrayOfString = b();
    if (arrayOfString == null) {}
    for (;;)
    {
      return;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        a(arrayOfString[i], true);
        i += 1;
      }
    }
  }
  
  private boolean d(String paramString)
  {
    long l2 = a(paramString);
    long l1;
    int i;
    long l3;
    synchronized (this.jdField_c_of_type_JavaUtilHashMap)
    {
      Object localObject = (aavt)this.jdField_c_of_type_JavaUtilHashMap.get(paramString);
      if (localObject != null)
      {
        l1 = ((aavt)localObject).jdField_a_of_type_Long;
        i = ((aavt)localObject).jdField_a_of_type_Int;
        i = a(i, l2);
        l3 = (System.currentTimeMillis() - l1) / 60000L;
        if (l3 > i)
        {
          ArkAppCenter.b("ArkApp.ArkLocalAppMgr", String.format("isAppNeedUpdate, need-update=true, app=%s, last-update=%d, delta=%d, update-period=%d, last-use-time=%d", new Object[] { paramString, Long.valueOf(l1), Long.valueOf(l3), Integer.valueOf(i), Long.valueOf(l2) }));
          return true;
        }
      }
      else
      {
        localObject = BaseApplication.getContext();
        l1 = ((Context)localObject).getSharedPreferences("ArkAppUpdateRecord", 0).getLong(paramString, 0L);
        i = ((Context)localObject).getSharedPreferences("ArkAppUpdatePeriod", 0).getInt(paramString, 1380);
        this.jdField_c_of_type_JavaUtilHashMap.put(paramString, new aavt(l1, i));
      }
    }
    ArkAppCenter.b("ArkApp.ArkLocalAppMgr", String.format("isAppNeedUpdate, need-update=false, app=%s, last-update=%d, delta=%d, update-period=%d, last-use-time=%d", new Object[] { paramString, Long.valueOf(l1), Long.valueOf(l3), Integer.valueOf(i), Long.valueOf(l2) }));
    return false;
  }
  
  private static boolean e(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    while (!paramString.matches("^\\d+(\\.\\d+){0,3}$")) {
      return false;
    }
    return true;
  }
  
  private void h()
  {
    long l = (System.currentTimeMillis() - this.jdField_a_of_type_Long) / 1000L / 60L;
    if ((this.jdField_a_of_type_Long != 0L) && (l <= this.jdField_b_of_type_Long) && (!jdField_b_of_type_Boolean))
    {
      ArkAppCenter.b("ArkApp.ArkLocalAppMgr", String.format("updateInstalledApps, not update time, delta=%d, interval=%d", new Object[] { Long.valueOf(l), Long.valueOf(this.jdField_b_of_type_Long) }));
      return;
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    a(new aaur(this));
  }
  
  private void i()
  {
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.postDelayed(new aaut(this), 10000L);
  }
  
  private void j()
  {
    String[] arrayOfString = b();
    if (arrayOfString == null) {}
    for (;;)
    {
      return;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        b(arrayOfString[i]);
        i += 1;
      }
    }
  }
  
  private static void k()
  {
    ArkAppCenter.b("ArkApp.ArkLocalAppMgr", "scheduleCleanOldApps");
    String[] arrayOfString = b();
    if (arrayOfString != null)
    {
      int j = arrayOfString.length;
      int i = 0;
      if (i < j)
      {
        String str = arrayOfString[i];
        ArkLocalAppMgr.AppPathInfo localAppPathInfo = c(str);
        if (localAppPathInfo == null) {}
        for (;;)
        {
          i += 1;
          break;
          if (localAppPathInfo.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDesc.jdField_b_of_type_JavaLangString != null) {
            a(str, localAppPathInfo.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDesc.jdField_b_of_type_JavaLangString, false);
          }
        }
      }
    }
  }
  
  public String a(String paramString1, String paramString2)
  {
    paramString1 = a(paramString1, paramString2);
    if (paramString1 != null) {
      return paramString1.jdField_a_of_type_JavaLangString;
    }
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler != null) {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.postDelayed(new aaus(this), paramInt);
  }
  
  public void a(String paramString1, String paramString2, int paramInt, ArkLocalAppMgr.IGetAppViewByIntentCallback arg4)
  {
    aawa localaawa = new aawa(null);
    localaawa.jdField_a_of_type_JavaLangString = paramString1;
    localaawa.jdField_b_of_type_JavaLangString = paramString2;
    localaawa.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr$IGetAppViewByIntentCallback = ???;
    synchronized (this.d)
    {
      this.d.add(localaawa);
      a(paramString1, "0.0.0.0", null, new aavg(this, paramString2, paramInt, localaawa));
      return;
    }
  }
  
  public void a(String paramString1, String paramString2, ArkLocalAppMgr.IGetLocalAppPath paramIGetLocalAppPath)
  {
    ThreadManager.post(new aavy(this, paramString1, paramString2, paramIGetLocalAppPath), 8, null, true);
  }
  
  public void a(String paramString1, String paramString2, Object paramObject, ArkLocalAppMgr.IGetAppPathByNameCallback paramIGetAppPathByNameCallback)
  {
    if ((paramString1 == null) || (paramString1.length() == 0) || (!ArkAppCenter.b()))
    {
      if (!jdField_a_of_type_Boolean) {
        throw new AssertionError();
      }
      paramString1 = new aavx();
      paramString1.jdField_a_of_type_Int = -1;
      paramString1.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr$AppPathInfo = null;
      paramString1.jdField_a_of_type_JavaLangObject = paramObject;
      paramString1.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr$IGetAppPathByNameCallback = paramIGetAppPathByNameCallback;
      paramString1.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(a(), this);
      paramString1.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(1916, paramString1).sendToTarget();
      return;
    }
    ThreadManager.post(new aavd(this, paramString1, paramString2, paramObject, paramIGetAppPathByNameCallback), 5, null, true);
  }
  
  public boolean a(String paramString1, String paramString2, int paramInt, ArrayList arg4, ArrayList paramArrayList2, Object paramObject, ArkLocalAppMgr.IGetAppPathByActionCallback paramIGetAppPathByActionCallback)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return false;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localQQAppInterface == null) {
      return false;
    }
    aavw localaavw = new aavw(null);
    localaavw.jdField_a_of_type_Boolean = false;
    localaavw.jdField_a_of_type_JavaLangString = paramString1;
    localaavw.jdField_b_of_type_JavaLangString = paramString2;
    localaavw.jdField_a_of_type_Int = paramInt;
    localaavw.jdField_a_of_type_JavaLangObject = paramObject;
    localaavw.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr$IGetAppPathByActionCallback = paramIGetAppPathByActionCallback;
    if (??? != null) {
      localaavw.jdField_a_of_type_JavaUtilArrayList.addAll(???);
    }
    if (paramArrayList2 != null) {
      localaavw.jdField_b_of_type_JavaUtilArrayList.addAll(paramArrayList2);
    }
    synchronized (this.jdField_c_of_type_JavaUtilArrayList)
    {
      this.jdField_c_of_type_JavaUtilArrayList.add(localaavw);
      if (!((ArkAppCenter)localQQAppInterface.getManager(120)).a().a(localaavw.jdField_a_of_type_JavaLangString, localaavw.jdField_b_of_type_JavaLangString, null, new aauz(this, localaavw)))
      {
        ArkAppCenter.b("ArkApp.ArkLocalAppMgr", String.format("getAppPathByAction, getAppNameByAction fail, action=%s.%s.", new Object[] { paramString1, paramString2 }));
        localaavw.jdField_a_of_type_Boolean = true;
        ThreadManager.post(new aavc(this, localaavw), 5, null, true);
        return true;
      }
    }
    return true;
  }
  
  public void b()
  {
    a(new aavs(this));
  }
  
  public void b(String paramString1, String paramString2)
  {
    ArkLocalAppMgr.AppPathInfo localAppPathInfo = new ArkLocalAppMgr.AppPathInfo();
    localAppPathInfo.jdField_a_of_type_JavaLangString = paramString2;
    localAppPathInfo.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDesc.jdField_a_of_type_JavaLangString = paramString1;
    localAppPathInfo.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDesc.jdField_b_of_type_JavaLangString = ArkAppCenter.d(paramString2);
    this.jdField_b_of_type_JavaUtilHashMap.put(paramString1, localAppPathInfo);
  }
  
  public void c()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localQQAppInterface == null)
    {
      ArkAppCenter.b("ArkApp.ArkLocalAppMgr", String.format("_updatePredownloadAppList, app=null", new Object[0]));
      return;
    }
    ThreadManager.post(new aaup(this, localQQAppInterface), 5, null, true);
  }
  
  public void e()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localQQAppInterface == null) {
      return;
    }
    ((ArkAppCenter)localQQAppInterface.getManager(120)).a().b();
  }
  
  public void f()
  {
    this.jdField_b_of_type_JavaUtilHashMap.clear();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1916)
    {
      a((aavx)paramMessage.obj);
      return true;
    }
    if (paramMessage.what == 1917)
    {
      b();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkLocalAppMgr
 * JD-Core Version:    0.7.0.1
 */