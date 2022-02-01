package com.tencent.biz.subscribe.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.PermissionUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.utils.Md5Utils;
import com.tencent.util.Pair;
import com.tencent.widget.ActionSheet;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SubscribeDraftManager
{
  public static String a = "SubscribeDraftManager";
  private static SubscribeDraftManager b;
  private String c = AppConstants.SUBSCRIBE_DRAFT;
  private String d = AppConstants.SUBSCRIBE_DRAFT_SIMPLE;
  private String e = ".draft";
  private Handler f;
  
  private SubscribeDraftManager()
  {
    HandlerThread localHandlerThread = ThreadManager.newFreeHandlerThread("SubscribeDraftManager", 0);
    localHandlerThread.start();
    this.f = new Handler(localHandlerThread.getLooper());
  }
  
  public static SubscribeDraftManager a()
  {
    try
    {
      if (b == null) {
        b = new SubscribeDraftManager();
      }
      SubscribeDraftManager localSubscribeDraftManager = b;
      return localSubscribeDraftManager;
    }
    finally {}
  }
  
  private Pair<String, String> b(String paramString)
  {
    String str = MD5Utils.toMD5(paramString);
    paramString = new StringBuilder();
    paramString.append(this.c);
    paramString.append(str);
    paramString = paramString.toString();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.d);
    ((StringBuilder)localObject).append(str);
    str = ((StringBuilder)localObject).toString();
    localObject = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("createDraftDirectory currentFolder:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" currentSimpleFolder:");
    localStringBuilder.append(str);
    QLog.d((String)localObject, 2, localStringBuilder.toString());
    try
    {
      FileUtils.createDirectory(paramString);
      FileUtils.createDirectory(str);
      paramString = new Pair(paramString, str);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private Pair<String, String> b(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.d(a, 4, "generate draft failed UID is empty");
      return null;
    }
    Pair localPair = b(paramString1);
    if (localPair != null)
    {
      Object localObject = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("generate draft id:");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("\n,mUid =");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", md5 = ");
      localStringBuilder.append(Md5Utils.getMD5(paramString1));
      QLog.d((String)localObject, 4, localStringBuilder.toString());
      paramString1 = new StringBuilder();
      paramString1.append((String)localPair.first);
      paramString1.append("/");
      paramString1.append(paramString2);
      paramString1.append(this.e);
      paramString1 = paramString1.toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append((String)localPair.second);
      ((StringBuilder)localObject).append("/");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(this.e);
      return new Pair(paramString1, ((StringBuilder)localObject).toString());
    }
    QLog.d(a, 4, "generate draft failed UID ,SDCARD generate folder failed");
    return null;
  }
  
  /* Error */
  private String c(String paramString)
  {
    // Byte code:
    //   0: new 82	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   7: astore 5
    //   9: aconst_null
    //   10: astore 4
    //   12: aconst_null
    //   13: astore_2
    //   14: new 155	java/io/BufferedReader
    //   17: dup
    //   18: new 157	java/io/FileReader
    //   21: dup
    //   22: new 159	java/io/File
    //   25: dup
    //   26: aload_1
    //   27: invokespecial 162	java/io/File:<init>	(Ljava/lang/String;)V
    //   30: invokespecial 165	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   33: invokespecial 168	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   36: astore_1
    //   37: aload_1
    //   38: invokevirtual 171	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   41: astore_2
    //   42: aload_2
    //   43: ifnull +13 -> 56
    //   46: aload 5
    //   48: aload_2
    //   49: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: goto -16 -> 37
    //   56: aload_1
    //   57: invokevirtual 174	java/io/BufferedReader:close	()V
    //   60: goto +45 -> 105
    //   63: astore_3
    //   64: aload_1
    //   65: astore_2
    //   66: aload_3
    //   67: astore_1
    //   68: goto +43 -> 111
    //   71: astore_3
    //   72: goto +11 -> 83
    //   75: astore_1
    //   76: goto +35 -> 111
    //   79: astore_3
    //   80: aload 4
    //   82: astore_1
    //   83: aload_1
    //   84: astore_2
    //   85: aload_3
    //   86: invokevirtual 116	java/lang/Exception:printStackTrace	()V
    //   89: aload_1
    //   90: ifnull +15 -> 105
    //   93: aload_1
    //   94: invokevirtual 174	java/io/BufferedReader:close	()V
    //   97: goto +8 -> 105
    //   100: astore_1
    //   101: aload_1
    //   102: invokevirtual 116	java/lang/Exception:printStackTrace	()V
    //   105: aload 5
    //   107: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: areturn
    //   111: aload_2
    //   112: ifnull +15 -> 127
    //   115: aload_2
    //   116: invokevirtual 174	java/io/BufferedReader:close	()V
    //   119: goto +8 -> 127
    //   122: astore_2
    //   123: aload_2
    //   124: invokevirtual 116	java/lang/Exception:printStackTrace	()V
    //   127: goto +5 -> 132
    //   130: aload_1
    //   131: athrow
    //   132: goto -2 -> 130
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	this	SubscribeDraftManager
    //   0	135	1	paramString	String
    //   13	103	2	str	String
    //   122	2	2	localException1	Exception
    //   63	4	3	localObject1	Object
    //   71	1	3	localException2	Exception
    //   79	7	3	localException3	Exception
    //   10	71	4	localObject2	Object
    //   7	99	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   37	42	63	finally
    //   46	53	63	finally
    //   37	42	71	java/lang/Exception
    //   46	53	71	java/lang/Exception
    //   14	37	75	finally
    //   85	89	75	finally
    //   14	37	79	java/lang/Exception
    //   56	60	100	java/lang/Exception
    //   93	97	100	java/lang/Exception
    //   115	119	122	java/lang/Exception
  }
  
  public void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, SubscribeDraftManager.SubDraftListener paramSubDraftListener)
  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 23) {
      bool = PermissionUtils.isStorePermissionEnable(paramActivity);
    } else {
      bool = true;
    }
    if (!bool)
    {
      DialogUtil.a(paramActivity);
      return;
    }
    if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2)) && (TextUtils.isEmpty(paramString3)) && (TextUtils.isEmpty(paramString4)))
    {
      if (paramSubDraftListener != null) {
        paramSubDraftListener.a(3, false, paramString2, new Object[0]);
      }
      QLog.d(a, 4, "modifyDraft failed because something is empty");
      return;
    }
    this.f.post(new SubscribeDraftManager.1(this, paramString1, paramString2, paramString3, paramString4, paramSubDraftListener));
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, int paramInt, SubscribeFollowUserUtil.ResultListener paramResultListener)
  {
    if (paramContext == null) {
      return;
    }
    paramContext = ActionSheet.create(paramContext);
    paramContext.addButton(paramInt, 3);
    paramContext.addCancelButton(2131887648);
    paramContext.setOnBottomCancelListener(new SubscribeDraftManager.6(this, paramResultListener, paramString1, paramContext));
    paramContext.setOnButtonClickListener(new SubscribeDraftManager.7(this, paramString1, paramString2, paramResultListener, paramContext));
    if (!paramContext.isShowing()) {
      paramContext.show();
    }
  }
  
  public void a(String paramString, SubscribeDraftManager.SubDraftListener paramSubDraftListener)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.d(a, 4, "qureyAllSimpleDraft failed because uin is empty");
      return;
    }
    this.f.post(new SubscribeDraftManager.2(this, paramString, paramSubDraftListener));
  }
  
  public void a(String paramString1, String paramString2, SubscribeDraftManager.SubDraftListener paramSubDraftListener)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      this.f.post(new SubscribeDraftManager.4(this, paramString1, paramString2, paramSubDraftListener));
      return;
    }
    QLog.d(a, 4, "deletDraft failed because uin or draftID is empty");
  }
  
  public boolean a(String paramString)
  {
    paramString = b(paramString);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null)
    {
      paramString = new File((String)paramString.second);
      bool1 = bool2;
      if (paramString.exists())
      {
        bool1 = bool2;
        if (paramString.isDirectory())
        {
          paramString = paramString.listFiles();
          bool1 = bool2;
          if (paramString != null)
          {
            bool1 = bool2;
            if (paramString.length > 0) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    Object localObject = null;
    try
    {
      paramString1 = new File(paramString1);
      if (!paramString1.exists())
      {
        paramString1.createNewFile();
      }
      else
      {
        paramString1.delete();
        paramString1.createNewFile();
      }
      paramString1 = new FileWriter(paramString1, false);
    }
    catch (Throwable paramString1)
    {
      for (;;)
      {
        try
        {
          label61:
          paramString1.close();
          return false;
        }
        catch (IOException paramString1) {}
        paramString1 = paramString1;
        paramString1 = localObject;
      }
    }
    try
    {
      paramString1.write(paramString2);
      paramString1.flush();
      paramString1.close();
      return true;
    }
    catch (Throwable paramString2)
    {
      break label61;
    }
    if (paramString1 != null) {}
    return false;
  }
  
  public void b(String paramString1, String paramString2, SubscribeDraftManager.SubDraftListener paramSubDraftListener)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      this.f.post(new SubscribeDraftManager.5(this, paramString1, paramString2, paramSubDraftListener));
      return;
    }
    QLog.d(a, 4, "deletDraft failed because uin or draftID is empty");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.utils.SubscribeDraftManager
 * JD-Core Version:    0.7.0.1
 */