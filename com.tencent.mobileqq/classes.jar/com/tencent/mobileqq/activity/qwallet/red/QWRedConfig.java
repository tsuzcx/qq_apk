package com.tencent.mobileqq.activity.qwallet.red;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;
import xgo;

public class QWRedConfig
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private transient String jdField_a_of_type_JavaLangString;
  private transient byte[] jdField_a_of_type_ArrayOfByte;
  private transient String b;
  public List pathInfos = new LinkedList();
  public long version;
  
  private QWRedConfig.PathInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Iterator localIterator = this.pathInfos.iterator();
    while (localIterator.hasNext())
    {
      QWRedConfig.PathInfo localPathInfo = (QWRedConfig.PathInfo)localIterator.next();
      if ((localPathInfo.isMatchPath(paramString)) && (localPathInfo.isShow())) {
        return localPathInfo;
      }
    }
    return null;
  }
  
  private static String a(AppRuntime paramAppRuntime)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramAppRuntime.getApplication().getFilesDir().getPath());
    localStringBuilder.append("/QWallet/").append(paramAppRuntime.getAccount()).append("/.config/");
    localStringBuilder.append(".redConfig");
    return localStringBuilder.toString();
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.b = paramQQAppInterface.getCurrentAccountUin();
    this.jdField_a_of_type_ArrayOfByte = new byte[0];
  }
  
  public static List parseConfigToPathInfos(String paramString)
  {
    localLinkedList = new LinkedList();
    try
    {
      paramString = new JSONObject(paramString).optJSONArray("list");
      if (paramString != null)
      {
        int i = 0;
        while (i < paramString.length())
        {
          QWRedConfig.PathInfo localPathInfo = QWRedConfig.PathInfo.parseToPathInfo(paramString.optJSONObject(i));
          if (localPathInfo != null) {
            localLinkedList.add(localPathInfo);
          }
          i += 1;
        }
      }
      return localLinkedList;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static QWRedConfig readConfig(QQAppInterface paramQQAppInterface)
  {
    String str = a(paramQQAppInterface);
    try
    {
      QWRedConfig localQWRedConfig1 = (QWRedConfig)QWalletTools.a(str);
      QWRedConfig localQWRedConfig2 = localQWRedConfig1;
      if (localQWRedConfig1 == null) {
        localQWRedConfig2 = new QWRedConfig();
      }
      localQWRedConfig2.a(paramQQAppInterface, str);
      if (QLog.isColorLevel()) {
        QLog.d("RedConfig", 2, "readQWRedConfig:" + localQWRedConfig2);
      }
      return localQWRedConfig2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        Object localObject = null;
      }
    }
  }
  
  public List getCurShowRedInfosByPath(String paramString)
  {
    paramString = a(paramString);
    if ((paramString == null) || (paramString.redInfos == null)) {
      return new LinkedList();
    }
    return paramString.getCurShowRedInfos();
  }
  
  public String getNotShowListStr()
  {
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator1 = this.pathInfos.iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((QWRedConfig.PathInfo)localIterator1.next()).redInfos.iterator();
      while (localIterator2.hasNext())
      {
        QWRedConfig.RedInfo localRedInfo = (QWRedConfig.RedInfo)localIterator2.next();
        if (localRedInfo.isShow == 0) {
          localLinkedList.add(localRedInfo);
        }
      }
    }
    return QWRedConfig.RedInfo.transToReportStr(localLinkedList);
  }
  
  public QWalletRedManager.ShowInfo getShowInfoByPath(String paramString)
  {
    paramString = a(paramString);
    if (paramString != null) {
      return paramString.getShowInfo();
    }
    return new QWalletRedManager.ShowInfo(false, false, "", "");
  }
  
  /* Error */
  public void parseConfig(com.tencent.mobileqq.activity.qwallet.config.QWalletConfig.ConfigInfo paramConfigInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +17 -> 20
    //   6: ldc 218
    //   8: aload_1
    //   9: getfield 221	com/tencent/mobileqq/activity/qwallet/config/QWalletConfig$ConfigInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   12: invokevirtual 226	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15: istore_2
    //   16: iload_2
    //   17: ifne +6 -> 23
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   26: ifeq +55 -> 81
    //   29: ldc 170
    //   31: iconst_2
    //   32: new 62	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 171	java/lang/StringBuilder:<init>	()V
    //   39: ldc 228
    //   41: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: aload_1
    //   45: getfield 230	com/tencent/mobileqq/activity/qwallet/config/QWalletConfig$ConfigInfo:jdField_a_of_type_Long	J
    //   48: invokevirtual 233	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   51: ldc 235
    //   53: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: aload_0
    //   57: getfield 237	com/tencent/mobileqq/activity/qwallet/red/QWRedConfig:version	J
    //   60: invokevirtual 233	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   63: ldc 235
    //   65: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: aload_1
    //   69: getfield 238	com/tencent/mobileqq/activity/qwallet/config/QWalletConfig$ConfigInfo:b	Ljava/lang/String;
    //   72: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: invokestatic 180	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   81: aload_1
    //   82: getfield 230	com/tencent/mobileqq/activity/qwallet/config/QWalletConfig$ConfigInfo:jdField_a_of_type_Long	J
    //   85: aload_0
    //   86: getfield 237	com/tencent/mobileqq/activity/qwallet/red/QWRedConfig:version	J
    //   89: lcmp
    //   90: ifle -70 -> 20
    //   93: aload_0
    //   94: aload_1
    //   95: getfield 238	com/tencent/mobileqq/activity/qwallet/config/QWalletConfig$ConfigInfo:b	Ljava/lang/String;
    //   98: invokestatic 240	com/tencent/mobileqq/activity/qwallet/red/QWRedConfig:parseConfigToPathInfos	(Ljava/lang/String;)Ljava/util/List;
    //   101: putfield 26	com/tencent/mobileqq/activity/qwallet/red/QWRedConfig:pathInfos	Ljava/util/List;
    //   104: aload_0
    //   105: aload_1
    //   106: getfield 230	com/tencent/mobileqq/activity/qwallet/config/QWalletConfig$ConfigInfo:jdField_a_of_type_Long	J
    //   109: putfield 237	com/tencent/mobileqq/activity/qwallet/red/QWRedConfig:version	J
    //   112: aload_0
    //   113: invokevirtual 243	com/tencent/mobileqq/activity/qwallet/red/QWRedConfig:saveConfig	()V
    //   116: goto -96 -> 20
    //   119: astore_1
    //   120: aload_0
    //   121: monitorexit
    //   122: aload_1
    //   123: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	this	QWRedConfig
    //   0	124	1	paramConfigInfo	com.tencent.mobileqq.activity.qwallet.config.QWalletConfig.ConfigInfo
    //   15	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   6	16	119	finally
    //   23	81	119	finally
    //   81	116	119	finally
  }
  
  public void saveConfig()
  {
    ThreadManager.getFileThreadHandler().post(new xgo(this));
  }
  
  public String toString()
  {
    return "QWRedConfig{pathInfos=" + this.pathInfos + ", version=" + this.version + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.red.QWRedConfig
 * JD-Core Version:    0.7.0.1
 */