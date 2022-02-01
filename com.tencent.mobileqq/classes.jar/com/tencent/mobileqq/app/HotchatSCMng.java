package com.tencent.mobileqq.app;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Xml;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.portal.PortalManager;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.manager.Manager;
import oicq.wlogin_sdk.tools.MD5;
import org.xmlpull.v1.XmlPullParser;

public class HotchatSCMng
  implements Manager
{
  static boolean jdField_a_of_type_Boolean = true;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  String jdField_a_of_type_JavaLangString;
  Comparator<HotchatSCMng.HotchatNote> jdField_a_of_type_JavaUtilComparator = null;
  HashMap<String, HotchatSCMng.HotchatNotice> jdField_a_of_type_JavaUtilHashMap = new HashMap(1);
  List<WeakReference<HotchatSCMng.HCSCObserver>> jdField_a_of_type_JavaUtilList = new ArrayList();
  public boolean b = false;
  
  public HotchatSCMng(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private HotchatSCMng.HotchatNote a(HotchatSCMng.HotchatNotice paramHotchatNotice, HotchatSCMng.HotchatNote paramHotchatNote1, HotchatSCMng.HotchatNote paramHotchatNote2, long paramLong, int paramInt)
  {
    HotchatSCMng.HotchatNote localHotchatNote = paramHotchatNote1;
    if (paramHotchatNotice.jdField_a_of_type_Int >= 0)
    {
      localHotchatNote = paramHotchatNote1;
      if (paramHotchatNotice.jdField_a_of_type_Int >= paramHotchatNotice.jdField_a_of_type_JavaUtilArrayList.size()) {}
    }
    int i;
    switch (paramInt)
    {
    default: 
      paramHotchatNote2 = paramHotchatNote1;
      localHotchatNote = paramHotchatNote2;
      if (QLog.isDevelopLevel())
      {
        NearbyUtils.a("HotchatSCMng", "findShowHotChatNote", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramHotchatNotice.jdField_a_of_type_Int), paramHotchatNote2 });
        localHotchatNote = paramHotchatNote2;
      }
      return localHotchatNote;
    case 0: 
      i = paramHotchatNotice.jdField_a_of_type_Int;
      if (i < paramHotchatNotice.jdField_a_of_type_JavaUtilArrayList.size())
      {
        paramHotchatNote2 = (HotchatSCMng.HotchatNote)paramHotchatNotice.jdField_a_of_type_JavaUtilArrayList.get(i);
        if (paramHotchatNote2 == null) {}
        while ((paramHotchatNote2.jdField_a_of_type_Boolean) || (paramLong < paramHotchatNote2.jdField_a_of_type_Long) || (paramLong > paramHotchatNote2.jdField_b_of_type_Long) || (!a(paramHotchatNote2)))
        {
          i += 1;
          break;
        }
        paramHotchatNotice.jdField_a_of_type_Int = i;
        paramHotchatNote1 = paramHotchatNote2;
      }
      break;
    }
    for (;;)
    {
      paramHotchatNote2 = paramHotchatNote1;
      break;
      localHotchatNote = (HotchatSCMng.HotchatNote)paramHotchatNotice.jdField_a_of_type_JavaUtilArrayList.get(paramHotchatNotice.jdField_a_of_type_Int);
      paramHotchatNote2 = paramHotchatNote1;
      if (paramLong < localHotchatNote.jdField_a_of_type_Long) {
        break;
      }
      paramHotchatNote2 = paramHotchatNote1;
      if (paramLong > localHotchatNote.jdField_b_of_type_Long) {
        break;
      }
      paramHotchatNote2 = paramHotchatNote1;
      if (!a(localHotchatNote)) {
        break;
      }
      paramHotchatNote2 = localHotchatNote;
      break;
      i = paramHotchatNotice.jdField_a_of_type_Int;
      paramHotchatNote2 = paramHotchatNote1;
      if (i >= paramHotchatNotice.jdField_a_of_type_JavaUtilArrayList.size()) {
        break;
      }
      paramHotchatNote2 = (HotchatSCMng.HotchatNote)paramHotchatNotice.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (paramHotchatNote2 == null) {}
      while (paramHotchatNote2.jdField_a_of_type_Boolean)
      {
        i += 1;
        break;
      }
      break;
    }
  }
  
  private HotchatSCMng.HotchatNotice a(HotchatSCMng.HotchatNotice paramHotchatNotice, HotchatSCMng.HotchatNote paramHotchatNote, long paramLong, String paramString)
  {
    if (paramHotchatNotice.jdField_a_of_type_Int >= 0) {}
    label174:
    do
    {
      return paramHotchatNotice;
      if (this.jdField_a_of_type_JavaUtilComparator == null) {
        this.jdField_a_of_type_JavaUtilComparator = new HotchatSCMng.1(this);
      }
      Collections.sort(paramHotchatNotice.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_JavaUtilComparator);
      if (QLog.isDevelopLevel()) {
        NearbyUtils.a("HotchatSCMng", "sort start", new Object[] { paramString });
      }
      int i = 0;
      if (i < paramHotchatNotice.jdField_a_of_type_JavaUtilArrayList.size())
      {
        paramHotchatNote = (HotchatSCMng.HotchatNote)paramHotchatNotice.jdField_a_of_type_JavaUtilArrayList.get(i);
        if (paramHotchatNote == null) {}
        for (;;)
        {
          i += 1;
          break;
          if ((paramHotchatNotice.jdField_a_of_type_Int < 0) && (paramLong <= paramHotchatNote.jdField_b_of_type_Long)) {}
          for (paramHotchatNotice.jdField_a_of_type_Int = i;; paramHotchatNotice.jdField_a_of_type_Int = i) {
            do
            {
              if (!QLog.isDevelopLevel()) {
                break label174;
              }
              NearbyUtils.a("HotchatSCMng", String.valueOf(i), new Object[] { paramHotchatNote });
              break;
            } while ((paramLong > paramHotchatNote.jdField_b_of_type_Long) || (!paramHotchatNote.jdField_a_of_type_Boolean));
          }
        }
      }
      if (paramHotchatNotice.jdField_a_of_type_Int < 0) {
        paramHotchatNotice.jdField_a_of_type_Int = paramHotchatNotice.jdField_a_of_type_JavaUtilArrayList.size();
      }
      if (QLog.isDevelopLevel()) {
        NearbyUtils.a("HotchatSCMng", "sort end", new Object[] { paramString });
      }
    } while (!QLog.isDevelopLevel());
    NearbyUtils.a("HotchatSCMng", "sortHotChatNotice", new Object[] { Integer.valueOf(paramHotchatNotice.jdField_a_of_type_Int) });
    return paramHotchatNotice;
  }
  
  @TargetApi(11)
  private void a(Set<String> paramSet)
  {
    try
    {
      localEditor = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).edit();
      if (Build.VERSION.SDK_INT < 11) {
        break label73;
      }
      localEditor.putStringSet("hotchat_scene_config", paramSet);
      localEditor.commit();
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        SharedPreferences.Editor localEditor;
        label73:
        Iterator localIterator;
        int i;
        localThrowable.printStackTrace();
        continue;
        paramSet = Integer.valueOf(paramSet.size());
      }
    }
    if (QLog.isColorLevel())
    {
      if (paramSet == null)
      {
        paramSet = "null";
        NearbyUtils.a("HotchatSCMng", new Object[] { "saveConfigs", paramSet });
      }
    }
    else
    {
      return;
      localEditor.putInt("hotchat_scene_config_count", paramSet.size());
      localIterator = paramSet.iterator();
      i = 0;
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localEditor.putString("hotchat_scene_config_" + i, str);
        i += 1;
      }
    }
  }
  
  private boolean a(ConfigurationService.Config paramConfig, boolean paramBoolean, String paramString, List<String> paramList, Set<String> paramSet)
  {
    boolean bool1 = paramBoolean;
    int i;
    String str;
    if (paramConfig.content_list.has())
    {
      List localList = paramConfig.content_list.get();
      if ((localList == null) || (localList.size() <= 0)) {
        break label263;
      }
      i = 0;
      if (i < localList.size())
      {
        str = (String)localList.get(i);
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 49,content: " + str + ",version: " + paramConfig.version.get());
        }
        if (str == null) {
          break label306;
        }
        if (str.length() != 0) {}
      }
    }
    label263:
    label306:
    for (;;)
    {
      i += 1;
      break;
      HotchatSCMng.ConfigData localConfigData = HotchatSCMng.ConfigData.a(str);
      if (localConfigData != null)
      {
        paramSet.add(str);
        boolean bool2 = a(localConfigData, paramString);
        if ((paramList != null) && (paramList.size() > 0)) {
          paramList.remove(localConfigData.c);
        }
        bool1 = bool2;
        if (this.b)
        {
          a(paramString + "/" + localConfigData.c);
          bool1 = bool2;
        }
      }
      for (;;)
      {
        if (!bool1)
        {
          paramBoolean = false;
          break;
          bool1 = false;
          continue;
          bool1 = paramBoolean;
          do
          {
            return bool1;
            bool1 = paramBoolean;
          } while (!QLog.isColorLevel());
          QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 49,content_list is empty ,version: " + paramConfig.version.get());
          return paramBoolean;
        }
      }
    }
  }
  
  @TargetApi(11)
  private String[] a()
  {
    label127:
    do
    {
      try
      {
        localObject4 = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
        if (Build.VERSION.SDK_INT < 11) {
          break label127;
        }
        localObject1 = ((SharedPreferences)localObject4).getStringSet("hotchat_scene_config", new HashSet());
        if ((localObject1 == null) || (((Set)localObject1).size() <= 0)) {
          break label240;
        }
        localObject1 = (String[])((Set)localObject1).toArray(new String[((Set)localObject1).size()]);
      }
      catch (Throwable localThrowable1)
      {
        for (;;)
        {
          try
          {
            Object localObject2;
            int j;
            int i;
            localObject2[i] = ((SharedPreferences)localObject4).getString("hotchat_scene_config_" + i, "");
            i += 1;
          }
          catch (Throwable localThrowable2)
          {
            Object localObject4;
            localObject1 = localObject3;
            Object localObject3 = localThrowable2;
            continue;
          }
          localThrowable1 = localThrowable1;
          Object localObject1 = null;
          localThrowable1.printStackTrace();
          continue;
          localObject3 = Integer.valueOf(localObject1.length);
          continue;
          localObject4 = "";
          continue;
          localObject1 = null;
        }
      }
      if (QLog.isColorLevel())
      {
        if (localObject1 != null) {
          break label210;
        }
        localObject2 = "null";
        if ((localObject1 == null) || (localObject1.length <= 0)) {
          break label220;
        }
        localObject4 = localObject1[0];
        NearbyUtils.a("HotchatSCMng", new Object[] { "getConfigs", localObject2, localObject4 });
      }
      return localObject1;
      j = ((SharedPreferences)localObject4).getInt("hotchat_scene_config_count", 0);
      if (j <= 0) {
        break label240;
      }
      localObject2 = new String[j];
      i = 0;
      localObject1 = localObject2;
    } while (i >= j);
  }
  
  public HotchatSCMng.HotchatNote a(String paramString, int paramInt, long paramLong)
  {
    if (TextUtils.isEmpty(paramString)) {
      if (QLog.isDevelopLevel()) {
        NearbyUtils.a("HotchatSCMng", "getHotchatNote", new Object[] { "id is null or empty" });
      }
    }
    HotchatSCMng.HotchatNotice localHotchatNotice;
    do
    {
      return null;
      localHotchatNotice = (HotchatSCMng.HotchatNotice)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    } while ((localHotchatNotice == null) || (localHotchatNotice.jdField_a_of_type_JavaUtilArrayList.size() <= 0));
    return a(a(localHotchatNotice, null, paramLong, paramString), null, null, paramLong, paramInt);
  }
  
  /* Error */
  public String a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 44	com/tencent/mobileqq/app/HotchatSCMng:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   8: astore_2
    //   9: aload_2
    //   10: ifnonnull +7 -> 17
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_1
    //   16: areturn
    //   17: aload_2
    //   18: invokevirtual 128	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   21: astore_2
    //   22: aload_2
    //   23: ifnull -10 -> 13
    //   26: aload_0
    //   27: getfield 326	com/tencent/mobileqq/app/HotchatSCMng:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   30: ifnull +13 -> 43
    //   33: aload_0
    //   34: getfield 326	com/tencent/mobileqq/app/HotchatSCMng:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   37: invokevirtual 254	java/lang/String:length	()I
    //   40: ifgt +105 -> 145
    //   43: aload_0
    //   44: aload_2
    //   45: invokevirtual 332	android/content/Context:getFilesDir	()Ljava/io/File;
    //   48: invokevirtual 337	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   51: putfield 326	com/tencent/mobileqq/app/HotchatSCMng:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   54: aload_0
    //   55: getfield 326	com/tencent/mobileqq/app/HotchatSCMng:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   58: ldc_w 274
    //   61: invokevirtual 341	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   64: ifne +30 -> 94
    //   67: aload_0
    //   68: new 190	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   75: aload_0
    //   76: getfield 326	com/tencent/mobileqq/app/HotchatSCMng:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   79: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: ldc_w 274
    //   85: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: putfield 326	com/tencent/mobileqq/app/HotchatSCMng:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   94: aload_0
    //   95: new 190	java/lang/StringBuilder
    //   98: dup
    //   99: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   102: aload_0
    //   103: getfield 326	com/tencent/mobileqq/app/HotchatSCMng:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   106: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: ldc 147
    //   111: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: putfield 326	com/tencent/mobileqq/app/HotchatSCMng:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   120: getstatic 21	com/tencent/mobileqq/app/HotchatSCMng:jdField_a_of_type_Boolean	Z
    //   123: ifeq +22 -> 145
    //   126: ldc 65
    //   128: ldc_w 343
    //   131: iconst_1
    //   132: anewarray 4	java/lang/Object
    //   135: dup
    //   136: iconst_0
    //   137: aload_0
    //   138: getfield 326	com/tencent/mobileqq/app/HotchatSCMng:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   141: aastore
    //   142: invokestatic 78	com/tencent/mobileqq/nearby/NearbyUtils:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   145: aload_0
    //   146: getfield 326	com/tencent/mobileqq/app/HotchatSCMng:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   149: astore_1
    //   150: goto -137 -> 13
    //   153: astore_1
    //   154: aload_0
    //   155: monitorexit
    //   156: aload_1
    //   157: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	this	HotchatSCMng
    //   1	149	1	str	String
    //   153	4	1	localObject1	Object
    //   8	37	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   4	9	153	finally
    //   17	22	153	finally
    //   26	43	153	finally
    //   43	94	153	finally
    //   94	145	153	finally
    //   145	150	153	finally
  }
  
  public void a()
  {
    if (this.b) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      if (this.b) {
        return;
      }
    }
    String[] arrayOfString = a();
    if (QLog.isColorLevel()) {
      if (arrayOfString != null) {
        break label103;
      }
    }
    label103:
    for (Object localObject2 = "null";; localObject2 = Integer.valueOf(arrayOfString.length))
    {
      NearbyUtils.a("HotchatSCMng", new Object[] { "initCache", localObject2 });
      if ((arrayOfString == null) || (arrayOfString.length <= 0)) {
        break label365;
      }
      localObject2 = a();
      if (localObject2 != null) {
        break;
      }
      return;
    }
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        String str = arrayOfString[i];
        if ((str != null) && (str.length() > 0))
        {
          HotchatSCMng.ConfigData localConfigData = HotchatSCMng.ConfigData.a(str);
          if (localConfigData != null)
          {
            for (;;)
            {
              try
              {
                if (new File((String)localObject2 + "/" + localConfigData.c).exists()) {
                  break label290;
                }
                bool = a(localConfigData, (String)localObject2);
                if (!bool) {
                  break;
                }
                a((String)localObject2 + "/" + localConfigData.c);
              }
              catch (Exception localException)
              {
                if (!QLog.isColorLevel()) {
                  break label408;
                }
              }
              NearbyUtils.a("HotchatSCMng", new Object[] { "initCache", "parse config xml fail", localException.toString() });
              break label408;
              label290:
              boolean bool = true;
            }
            if (QLog.isColorLevel()) {
              NearbyUtils.a("HotchatSCMng", new Object[] { "initCache", "download config xml fail", localConfigData });
            }
          }
          else if (QLog.isColorLevel())
          {
            NearbyUtils.a("HotchatSCMng", new Object[] { "initCache", "parse ConfigData fail", localException });
          }
        }
      }
      else
      {
        label365:
        this.b = true;
        if (QLog.isColorLevel()) {
          NearbyUtils.a("HotchatSCMng", new Object[] { "initCache", Integer.valueOf(this.jdField_a_of_type_JavaUtilHashMap.size()) });
        }
        return;
      }
      label408:
      i += 1;
    }
  }
  
  public void a(HotchatSCMng.HCSCObserver paramHCSCObserver)
  {
    if (paramHCSCObserver == null) {
      return;
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        if (this.jdField_a_of_type_JavaUtilList.size() > 0)
        {
          Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
          if (!localIterator.hasNext()) {
            break label105;
          }
          WeakReference localWeakReference = (WeakReference)localIterator.next();
          if ((localWeakReference == null) || (localWeakReference.get() != paramHCSCObserver)) {
            continue;
          }
          i = 1;
          if (i == 0)
          {
            paramHCSCObserver = new WeakReference(paramHCSCObserver);
            this.jdField_a_of_type_JavaUtilList.add(paramHCSCObserver);
          }
        }
        return;
      }
      label105:
      int i = 0;
    }
  }
  
  public void a(String paramString)
  {
    localObject4 = null;
    if (QLog.isDevelopLevel()) {
      NearbyUtils.a("HotchatSCMng", "parse", new Object[] { paramString });
    }
    BufferedInputStream localBufferedInputStream;
    String str1;
    for (;;)
    {
      XmlPullParser localXmlPullParser;
      try
      {
        paramString = new FileInputStream(paramString);
      }
      catch (FileNotFoundException localFileNotFoundException1)
      {
        Object localObject1;
        paramString = null;
      }
      for (;;)
      {
        try
        {
          localBufferedInputStream = new BufferedInputStream(paramString);
          str1 = paramString;
          if (localBufferedInputStream == null) {
            continue;
          }
        }
        catch (FileNotFoundException localFileNotFoundException2)
        {
          Object localObject2;
          continue;
          if (i == 1) {
            continue;
          }
          paramString = str2;
          Object localObject3 = localObject4;
          switch (i)
          {
          }
          paramString = str2;
          localObject3 = localObject4;
          break;
        }
        try
        {
          localXmlPullParser = Xml.newPullParser();
          localXmlPullParser.setInput(localBufferedInputStream, "UTF-8");
          i = localXmlPullParser.getEventType();
          str2 = null;
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
          if (!QLog.isColorLevel()) {
            continue;
          }
          NearbyUtils.a("HotchatSCMng", new Object[] { "parseNotice exception", paramString.toString() });
        }
      }
      i = localXmlPullParser.next();
      str2 = paramString;
      localObject4 = localObject1;
      break label306;
      localFileNotFoundException1.printStackTrace();
      localBufferedInputStream = null;
      str1 = paramString;
      continue;
      localObject2 = new HotchatSCMng.ParserHandler(this, str2, localObject4, localXmlPullParser).a();
      paramString = ((HotchatSCMng.ParserHandler)localObject2).a();
      localObject2 = ((HotchatSCMng.ParserHandler)localObject2).a();
      continue;
      localObject2 = new HotchatSCMng.ParserHandler(this, str2, localObject4, localXmlPullParser).b();
      paramString = ((HotchatSCMng.ParserHandler)localObject2).a();
      localObject2 = ((HotchatSCMng.ParserHandler)localObject2).a();
    }
    if (localBufferedInputStream != null) {}
    try
    {
      localBufferedInputStream.close();
      if (str1 == null) {}
    }
    catch (Exception paramString)
    {
      try
      {
        do
        {
          str1.close();
          return;
          paramString = paramString;
          paramString.printStackTrace();
        } while (!QLog.isColorLevel());
        NearbyUtils.a("HotchatSCMng", new Object[] { "parseNotice exception", paramString.toString() });
      }
      catch (Exception paramString)
      {
        do
        {
          paramString.printStackTrace();
        } while (!QLog.isColorLevel());
        NearbyUtils.a("HotchatSCMng", new Object[] { "parseNotice exception", paramString.toString() });
        return;
      }
    }
  }
  
  public boolean a(HotchatSCMng.ConfigData paramConfigData, String paramString)
  {
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramConfigData != null)
    {
      if (TextUtils.isEmpty(paramConfigData.jdField_a_of_type_JavaLangString)) {
        bool2 = bool1;
      }
    }
    else {
      return bool2;
    }
    if (QLog.isColorLevel()) {
      NearbyUtils.a("HotchatSCMng", new Object[] { "download", paramConfigData });
    }
    paramString = new File(paramString + "/" + paramConfigData.c);
    String str;
    if (paramString.exists()) {
      if (!TextUtils.isEmpty(paramConfigData.jdField_b_of_type_JavaLangString))
      {
        str = MD5.getFileMD5(paramString);
        bool2 = paramConfigData.jdField_b_of_type_JavaLangString.equals(str);
        bool1 = bool2;
        if (!bool2)
        {
          bool1 = bool2;
          if (QLog.isColorLevel())
          {
            NearbyUtils.a("download", new Object[] { "cache md5 confilict", str, paramConfigData.jdField_b_of_type_JavaLangString });
            bool1 = bool2;
          }
        }
      }
    }
    for (;;)
    {
      label167:
      if (!bool1)
      {
        bool2 = HttpDownloadUtil.download(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramConfigData.jdField_a_of_type_JavaLangString, paramString);
        bool1 = bool2;
        if (bool2)
        {
          bool1 = bool2;
          if (!TextUtils.isEmpty(paramConfigData.jdField_b_of_type_JavaLangString))
          {
            str = MD5.getFileMD5(paramString);
            bool2 = paramConfigData.jdField_b_of_type_JavaLangString.equals(str);
            bool1 = bool2;
            if (!bool2)
            {
              bool1 = bool2;
              if (QLog.isColorLevel())
              {
                NearbyUtils.a("download", new Object[] { "md5 conflict", paramConfigData.jdField_b_of_type_JavaLangString, str });
                bool1 = bool2;
              }
            }
          }
        }
      }
      for (;;)
      {
        for (;;)
        {
          bool2 = bool1;
          if (bool1) {
            break;
          }
          bool2 = bool1;
          try
          {
            if (!paramString.exists()) {
              break;
            }
            paramString.delete();
            return bool1;
          }
          catch (Exception paramConfigData)
          {
            paramConfigData.printStackTrace();
            return bool1;
          }
        }
        bool1 = true;
        break label167;
      }
      bool1 = false;
    }
  }
  
  public boolean a(HotchatSCMng.HotchatNote paramHotchatNote)
  {
    boolean bool;
    if ((paramHotchatNote == null) || (TextUtils.isEmpty(paramHotchatNote.jdField_b_of_type_JavaLangString))) {
      bool = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        NearbyUtils.a("HotchatSCMng", new Object[] { "checkHasGrabHbTask", paramHotchatNote, Boolean.valueOf(bool) });
      }
      return bool;
      PortalManager localPortalManager = (PortalManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_PORTAL);
      if ((localPortalManager != null) && (localPortalManager.a())) {
        bool = true;
      } else {
        bool = false;
      }
    }
  }
  
  /* Error */
  public boolean a(ConfigurationService.Config paramConfig)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +5 -> 6
    //   4: iconst_0
    //   5: ireturn
    //   6: aload_0
    //   7: getfield 35	com/tencent/mobileqq/app/HotchatSCMng:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   10: astore 8
    //   12: aload 8
    //   14: monitorenter
    //   15: aload_0
    //   16: getfield 35	com/tencent/mobileqq/app/HotchatSCMng:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   19: invokevirtual 480	java/util/HashMap:clear	()V
    //   22: aload_0
    //   23: invokevirtual 351	com/tencent/mobileqq/app/HotchatSCMng:a	()Ljava/lang/String;
    //   26: astore 9
    //   28: aload 9
    //   30: ifnonnull +8 -> 38
    //   33: aload 8
    //   35: monitorexit
    //   36: iconst_0
    //   37: ireturn
    //   38: aconst_null
    //   39: astore 5
    //   41: new 334	java/io/File
    //   44: dup
    //   45: aload 9
    //   47: invokespecial 353	java/io/File:<init>	(Ljava/lang/String;)V
    //   50: astore 6
    //   52: aload 6
    //   54: invokevirtual 356	java/io/File:exists	()Z
    //   57: ifeq +84 -> 141
    //   60: aload 6
    //   62: invokevirtual 483	java/io/File:list	()[Ljava/lang/String;
    //   65: astore 7
    //   67: aload 7
    //   69: ifnull +72 -> 141
    //   72: aload 7
    //   74: arraylength
    //   75: ifle +66 -> 141
    //   78: new 39	java/util/ArrayList
    //   81: dup
    //   82: aload 7
    //   84: arraylength
    //   85: invokespecial 484	java/util/ArrayList:<init>	(I)V
    //   88: astore 6
    //   90: aload 7
    //   92: arraylength
    //   93: istore_3
    //   94: iconst_0
    //   95: istore_2
    //   96: aload 6
    //   98: astore 5
    //   100: iload_2
    //   101: iload_3
    //   102: if_icmpge +42 -> 144
    //   105: aload 7
    //   107: iload_2
    //   108: aaload
    //   109: astore 5
    //   111: aload 5
    //   113: ifnull +21 -> 134
    //   116: aload 5
    //   118: invokevirtual 254	java/lang/String:length	()I
    //   121: ifle +13 -> 134
    //   124: aload 6
    //   126: aload 5
    //   128: invokeinterface 374 2 0
    //   133: pop
    //   134: iload_2
    //   135: iconst_1
    //   136: iadd
    //   137: istore_2
    //   138: goto -42 -> 96
    //   141: aconst_null
    //   142: astore 5
    //   144: new 283	java/util/HashSet
    //   147: dup
    //   148: invokespecial 284	java/util/HashSet:<init>	()V
    //   151: astore 6
    //   153: aload_0
    //   154: aload_1
    //   155: iconst_1
    //   156: aload 9
    //   158: aload 5
    //   160: aload 6
    //   162: invokespecial 486	com/tencent/mobileqq/app/HotchatSCMng:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;ZLjava/lang/String;Ljava/util/List;Ljava/util/Set;)Z
    //   165: istore 4
    //   167: aload_0
    //   168: aload 6
    //   170: invokespecial 488	com/tencent/mobileqq/app/HotchatSCMng:a	(Ljava/util/Set;)V
    //   173: aload 5
    //   175: ifnull +107 -> 282
    //   178: aload 5
    //   180: invokeinterface 232 1 0
    //   185: ifle +97 -> 282
    //   188: aload 5
    //   190: invokeinterface 366 1 0
    //   195: astore_1
    //   196: aload_1
    //   197: invokeinterface 184 1 0
    //   202: ifeq +80 -> 282
    //   205: aload_1
    //   206: invokeinterface 188 1 0
    //   211: checkcast 109	java/lang/String
    //   214: astore 5
    //   216: new 334	java/io/File
    //   219: dup
    //   220: new 190	java/lang/StringBuilder
    //   223: dup
    //   224: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   227: aload 9
    //   229: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: ldc_w 274
    //   235: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: aload 5
    //   240: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   246: invokespecial 353	java/io/File:<init>	(Ljava/lang/String;)V
    //   249: invokevirtual 455	java/io/File:delete	()Z
    //   252: pop
    //   253: goto -57 -> 196
    //   256: astore 5
    //   258: aload 5
    //   260: invokevirtual 423	java/lang/Exception:printStackTrace	()V
    //   263: goto -67 -> 196
    //   266: astore_1
    //   267: aload 8
    //   269: monitorexit
    //   270: aload_1
    //   271: athrow
    //   272: astore 6
    //   274: aload 6
    //   276: invokevirtual 423	java/lang/Exception:printStackTrace	()V
    //   279: goto -135 -> 144
    //   282: aload 8
    //   284: monitorexit
    //   285: invokestatic 63	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   288: ifeq +33 -> 321
    //   291: ldc 65
    //   293: ldc_w 490
    //   296: iconst_2
    //   297: anewarray 4	java/lang/Object
    //   300: dup
    //   301: iconst_0
    //   302: iload 4
    //   304: invokestatic 463	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   307: aastore
    //   308: dup
    //   309: iconst_1
    //   310: aload_0
    //   311: getfield 28	com/tencent/mobileqq/app/HotchatSCMng:b	Z
    //   314: invokestatic 463	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   317: aastore
    //   318: invokestatic 78	com/tencent/mobileqq/nearby/NearbyUtils:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   321: iload 4
    //   323: ireturn
    //   324: astore 7
    //   326: aload 6
    //   328: astore 5
    //   330: aload 7
    //   332: astore 6
    //   334: goto -60 -> 274
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	337	0	this	HotchatSCMng
    //   0	337	1	paramConfig	ConfigurationService.Config
    //   95	43	2	i	int
    //   93	10	3	j	int
    //   165	157	4	bool	boolean
    //   39	200	5	localObject1	Object
    //   256	3	5	localException1	Exception
    //   328	1	5	localObject2	Object
    //   50	119	6	localObject3	Object
    //   272	55	6	localException2	Exception
    //   332	1	6	localObject4	Object
    //   65	41	7	arrayOfString	String[]
    //   324	7	7	localException3	Exception
    //   10	273	8	localHashMap	HashMap
    //   26	202	9	str	String
    // Exception table:
    //   from	to	target	type
    //   216	253	256	java/lang/Exception
    //   15	28	266	finally
    //   33	36	266	finally
    //   41	67	266	finally
    //   72	90	266	finally
    //   90	94	266	finally
    //   116	134	266	finally
    //   144	173	266	finally
    //   178	196	266	finally
    //   196	216	266	finally
    //   216	253	266	finally
    //   258	263	266	finally
    //   267	270	266	finally
    //   274	279	266	finally
    //   282	285	266	finally
    //   41	67	272	java/lang/Exception
    //   72	90	272	java/lang/Exception
    //   90	94	324	java/lang/Exception
    //   116	134	324	java/lang/Exception
  }
  
  public void b(HotchatSCMng.HCSCObserver paramHCSCObserver)
  {
    if (paramHCSCObserver == null) {
      return;
    }
    for (;;)
    {
      int i;
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        if (this.jdField_a_of_type_JavaUtilList.size() > 0)
        {
          i = this.jdField_a_of_type_JavaUtilList.size() - 1;
          if (i >= 0)
          {
            WeakReference localWeakReference = (WeakReference)this.jdField_a_of_type_JavaUtilList.get(i);
            if ((localWeakReference == null) || (localWeakReference.get() != paramHCSCObserver)) {
              break label91;
            }
            this.jdField_a_of_type_JavaUtilList.remove(i);
            break label91;
          }
        }
        return;
      }
      label91:
      i -= 1;
    }
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_JavaUtilHashMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.HotchatSCMng
 * JD-Core Version:    0.7.0.1
 */