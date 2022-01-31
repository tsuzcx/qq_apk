package com.tencent.mobileqq.app;

import ajtd;
import ajvi;
import ajvk;
import ajxl;
import ajxw;
import ajxx;
import ajxy;
import akhq;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import askm;
import aukm;
import aukn;
import auko;
import bamn;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import msp;

public class GroupIconHelper
  extends ajxl
  implements Handler.Callback, askm
{
  private static boolean jdField_a_of_type_Boolean;
  int jdField_a_of_type_Int;
  private ajtd jdField_a_of_type_Ajtd;
  private ajxy jdField_a_of_type_Ajxy;
  private GroupIconHelper.CheckDisIconThread jdField_a_of_type_ComTencentMobileqqAppGroupIconHelper$CheckDisIconThread;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString;
  private HashMap<String, ajxx> jdField_a_of_type_JavaUtilHashMap;
  private Hashtable<String, Long> jdField_a_of_type_JavaUtilHashtable;
  private Set<String> jdField_a_of_type_JavaUtilSet;
  ConcurrentLinkedQueue<GroupIconHelper.GenerateIconRunner> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private int jdField_b_of_type_Int = 60000;
  private Set<String> jdField_b_of_type_JavaUtilSet;
  private int c = 90000;
  
  public GroupIconHelper(String paramString, ajtd paramajtd)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.dih", 2, "Create GroupIconHelper For [" + this.jdField_a_of_type_JavaLangString + "]");
    }
    paramString = paramajtd.app;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilHashtable = new Hashtable();
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_b_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_Ajxy = new ajxy(paramString.getApp().getMainLooper(), this, null);
    this.jdField_a_of_type_Ajtd = paramajtd;
    paramString.a(new GroupIconHelper.CheckIsLowPerformanceMachineRunner(this));
    ThreadManagerV2.executeOnSubThread(new GroupIconHelper.1(this, paramString));
    if ((this.jdField_a_of_type_Ajtd instanceof ajvi))
    {
      this.jdField_a_of_type_Int = 101;
      return;
    }
    this.jdField_a_of_type_Int = 113;
  }
  
  private ajxx a(String paramString, boolean paramBoolean1, ajxx paramajxx, boolean paramBoolean2)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Object localObject1;
    label85:
    label103:
    Object localObject3;
    Object localObject2;
    if (this.jdField_a_of_type_Int == 101)
    {
      localObject1 = ((ajvk)localQQAppInterface.getManager(53)).b(paramString);
      if (QLog.isColorLevel())
      {
        if ((localObject1 != null) && (((ArrayList)localObject1).size() != 0)) {
          break label300;
        }
        QLog.d("Q.qqhead.dih", 2, "discussionUin=" + paramString + " memberUinList is empty...");
      }
      if ((localObject1 != null) && (((ArrayList)localObject1).size() != 0)) {
        break label430;
      }
      paramajxx.jdField_a_of_type_Int = 0;
      localObject3 = a((ArrayList)localObject1, paramBoolean2);
      paramajxx.jdField_a_of_type_JavaLangString = ((String)localObject3);
      if (paramBoolean1)
      {
        localObject2 = null;
        if (this.jdField_a_of_type_Int != 101) {
          break label442;
        }
        paramString = ((ajvk)localQQAppInterface.getManager(53)).a(paramString);
        if (paramString == null) {
          break label569;
        }
      }
    }
    label161:
    label300:
    label430:
    label569:
    for (paramString = paramString.faceUinSet;; paramString = null)
    {
      localObject1 = paramString;
      if (((localObject1 == null) || ("".equals(((String)localObject1).trim()))) && ((localObject3 == null) || ("".equals(((String)localObject3).trim())))) {
        paramBoolean1 = false;
      }
      for (;;)
      {
        paramajxx.jdField_a_of_type_Boolean = paramBoolean1;
        return paramajxx;
        localObject1 = (TroopManager)localQQAppInterface.getManager(52);
        localObject2 = ((TroopManager)localObject1).b(paramString);
        localObject3 = ((TroopManager)localObject1).c(paramString);
        localObject1 = localObject2;
        if (localObject3 == null) {
          break;
        }
        localObject1 = localObject2;
        if (((ArrayList)localObject2).size() != 0) {
          break;
        }
        localObject1 = localObject2;
        if (((TroopInfo)localObject3).wMemberNum <= 1) {
          break;
        }
        localObject1 = localObject2;
        if (this.jdField_a_of_type_Ajtd == null) {
          break;
        }
        ((akhq)this.jdField_a_of_type_Ajtd).b(Long.parseLong(paramString));
        localObject1 = localObject2;
        break;
        localObject2 = new StringBuilder();
        localObject3 = ((ArrayList)localObject1).iterator();
        if (((Iterator)localObject3).hasNext())
        {
          String str = (String)((Iterator)localObject3).next();
          if ((str != null) && (str.length() > 5)) {
            ((StringBuilder)localObject2).append(str.substring(0, 4));
          }
          for (;;)
          {
            ((StringBuilder)localObject2).append(";");
            break;
            ((StringBuilder)localObject2).append(str);
          }
        }
        QLog.d("Q.qqhead.dih", 2, "discussionUin=" + paramString + " memberUinList is:" + ((StringBuilder)localObject2).toString());
        break label85;
        paramajxx.jdField_a_of_type_Int = ((ArrayList)localObject1).size();
        break label103;
        label442:
        localObject1 = localObject2;
        if (this.jdField_a_of_type_Int != 113) {
          break label161;
        }
        paramString = ((TroopManager)localQQAppInterface.getManager(52)).c(paramString);
        localObject1 = localObject2;
        if (paramString == null) {
          break label161;
        }
        localObject1 = paramString.mHeaderUinsOld;
        break label161;
        if ((localObject3 != null) && (!((String)localObject3).equals(localObject1))) {
          paramBoolean1 = true;
        } else if ((localObject1 != null) && (!((String)localObject1).equals(localObject3))) {
          paramBoolean1 = true;
        } else if ((paramajxx.jdField_a_of_type_Byte == 2) && (localObject3 != null) && (!((String)localObject3).equals(paramajxx.jdField_b_of_type_JavaLangString)) && (paramajxx.e)) {
          paramBoolean1 = true;
        } else {
          paramBoolean1 = false;
        }
      }
    }
  }
  
  private Pair<Boolean, Bitmap> a(String paramString1, String paramString2, ArrayList<String> paramArrayList, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 0;
    if ((paramString1 == null) || (paramString1.length() <= 1))
    {
      i = 1;
      if (!paramBoolean2) {
        return Pair.create(Boolean.valueOf(false), null);
      }
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    boolean bool = true;
    float f2 = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().density;
    float f1 = f2;
    if (f2 < 1.0F) {
      f1 = 1.0F;
    }
    int k = (int)(50.0F * f1 + 0.5D);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.dih", 2, "createDiscussionIcon density=" + f1 + ";imageWidth=" + k + ",hasPstnIcon: " + paramBoolean1 + ", hasRealPhoneUser: " + paramBoolean2);
    }
    if (i == 0) {}
    for (String[] arrayOfString = paramString1.split(";");; arrayOfString = null)
    {
      i = 0;
      int j;
      if (arrayOfString != null)
      {
        if (arrayOfString.length > 4) {
          i = 4;
        }
      }
      else
      {
        if ((i >= 4) || (!paramBoolean1)) {
          break label540;
        }
        paramString1 = msp.a(localQQAppInterface, paramString2, 3000, 4 - i);
        if ((paramString1 == null) || (paramString1.size() <= 0)) {
          break label533;
        }
        j = paramString1.size();
      }
      for (;;)
      {
        synchronized (this.jdField_a_of_type_JavaUtilSet)
        {
          this.jdField_a_of_type_JavaUtilSet.add(paramString2);
          j += i;
          ??? = new Bitmap[j];
          j = 0;
          paramBoolean1 = bool;
          if (j < i)
          {
            String str = arrayOfString[j];
            Pair localPair = localQQAppInterface.a(str, (byte)5, 0, 0);
            if (!((Boolean)localPair.first).booleanValue())
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.qqhead.dih", 2, "getScaledFaceBitmap fail, disUin=" + paramString2 + ", uin=" + str);
              }
              paramArrayList.remove(str);
              paramBoolean1 = false;
            }
            ???[j] = ((Bitmap)localPair.second);
            j += 1;
            continue;
            i = arrayOfString.length;
          }
        }
        if ((paramString1 != null) && (paramString1.size() > 0))
        {
          j = 0;
          while (j < paramString1.size())
          {
            ???[(j + i)] = ((Bitmap)paramString1.get(j));
            j += 1;
          }
        }
        try
        {
          paramString1 = a(k, (Bitmap[])???);
          return Pair.create(Boolean.valueOf(paramBoolean1), paramString1);
        }
        catch (Throwable paramString1)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.qqhead.dih", 2, "createDiscussionIcon fail, disUin=" + paramString2 + ", throwable : " + paramString1.toString());
            }
            paramBoolean1 = false;
            paramString1 = null;
          }
        }
        label533:
        j = i;
        continue;
        label540:
        paramString1 = null;
        j = i;
      }
    }
  }
  
  public static String a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      QLog.i("Q.qqhead.dih", 1, "===getPstnDiscussionUin discussionUin is null ===");
      return null;
    }
    return paramString + "_" + 1001;
  }
  
  public static String a(ArrayList<String> paramArrayList, boolean paramBoolean)
  {
    int j = 0;
    StringBuilder localStringBuilder;
    int i;
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      localStringBuilder = new StringBuilder(128);
      paramArrayList = (ArrayList)paramArrayList.clone();
      String[] arrayOfString = new String[paramArrayList.size()];
      i = 0;
      while (i < arrayOfString.length)
      {
        arrayOfString[i] = ((String)paramArrayList.get(i));
        i += 1;
      }
      Arrays.sort(arrayOfString, a());
      int k = 0;
      i = j;
      j = k;
      if (i < arrayOfString.length)
      {
        localStringBuilder.append(arrayOfString[i]).append(";");
        j += 1;
        if ((!paramBoolean) || (!a()) || (j < 4)) {
          break label178;
        }
      }
    }
    label128:
    for (paramArrayList = localStringBuilder.toString();; paramArrayList = " ")
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqhead.dih", 2, "createFaceUinSet, ret=" + paramArrayList + ",sureChanged=" + paramBoolean);
      }
      return paramArrayList;
      label178:
      if (j >= 4) {
        break label128;
      }
      i += 1;
      break;
    }
  }
  
  public static ArrayList<String> a(ArrayList<String> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty()))
    {
      QLog.d("Q.qqhead.dih", 2, "handleDiscussionSecHeadUins memberUinList is null");
      return paramArrayList;
    }
    ArrayList localArrayList = (ArrayList)paramArrayList.clone();
    int i = paramArrayList.size();
    paramArrayList = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    if (i <= 4) {
      if (!localArrayList.contains(paramArrayList)) {
        localArrayList.add(paramArrayList);
      }
    }
    for (;;)
    {
      paramArrayList = localArrayList;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.qqhead.dih", 2, "handleNewGroupSecHeadUins, memberUinSize=" + localArrayList.size());
      return localArrayList;
      localArrayList.remove(paramArrayList);
    }
  }
  
  public static ArrayList<String> a(ArrayList<String> paramArrayList, TroopInfo paramTroopInfo)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty()) || (paramTroopInfo == null))
    {
      QLog.d("Q.qqhead.dih", 2, "handleNewGroupSecHeadUins memberUinList is null");
      return paramArrayList;
    }
    if (paramTroopInfo == null)
    {
      QLog.d("Q.qqhead.dih", 2, "handleNewGroupSecHeadUins troopInfo is null");
      return paramArrayList;
    }
    paramArrayList = (ArrayList)paramArrayList.clone();
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    bamn.a(paramArrayList);
    if (paramTroopInfo.wMemberNumClient <= 4) {
      if (!paramArrayList.contains(str)) {
        paramArrayList.add(str);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqhead.dih", 2, "handleNewGroupSecHeadUins, discussionUin=" + paramTroopInfo.troopuin + ",NumClient=" + paramTroopInfo.wMemberNumClient + ",memberUinSize=" + paramArrayList);
      }
      return paramArrayList;
      paramArrayList.remove(str);
    }
  }
  
  public static Comparator<String> a()
  {
    return new ajxw();
  }
  
  private void a(GroupIconHelper.GenerateIconRunner paramGenerateIconRunner)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.offer(paramGenerateIconRunner);
    b();
  }
  
  private void a(String paramString, ajxx paramajxx, boolean paramBoolean)
  {
    if (paramajxx.jdField_a_of_type_Byte == 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqhead.dih", 2, "CreateIcon created: " + paramString + ", iconCount=" + paramajxx.jdField_a_of_type_JavaUtilArrayList.size() + ", totalCount=" + paramajxx.jdField_a_of_type_Int);
      }
      return;
    }
    Object localObject1 = b(paramajxx.jdField_a_of_type_JavaLangString, paramString, paramajxx.jdField_a_of_type_JavaUtilArrayList, paramajxx.c, paramajxx.d);
    boolean bool1 = ((Boolean)((Pair)localObject1).first).booleanValue();
    Object localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    boolean bool2 = ((Boolean)((Pair)localObject1).second).booleanValue();
    String str;
    if (bool1)
    {
      paramajxx.jdField_b_of_type_Int += 1;
      str = a(paramajxx.jdField_a_of_type_JavaUtilArrayList, paramBoolean);
      paramajxx.jdField_b_of_type_JavaLangString = str;
      localObject1 = null;
      if (this.jdField_a_of_type_Int == 101)
      {
        localObject1 = (ajvk)((QQAppInterface)localObject2).getManager(53);
        if (localObject1 == null) {
          break label642;
        }
      }
    }
    label642:
    for (localObject1 = ((ajvk)localObject1).a(paramString);; localObject1 = null)
    {
      Object localObject3;
      if (localObject1 != null)
      {
        ((DiscussionInfo)localObject1).faceUinSet = str;
        localObject3 = ((QQAppInterface)localObject2).getEntityManagerFactory().createEntityManager();
        ((aukn)localObject3).a((aukm)localObject1);
        ((aukn)localObject3).a();
        if (QLog.isColorLevel()) {
          localObject1 = ((DiscussionInfo)localObject1).discussionName;
        }
      }
      for (;;)
      {
        if ((paramajxx.jdField_a_of_type_JavaUtilArrayList.size() >= paramajxx.jdField_a_of_type_Int) && (bool2)) {
          paramajxx.jdField_a_of_type_Byte = 3;
        }
        if ((this.jdField_a_of_type_Ajtd instanceof ajvi)) {
          if (paramajxx.c) {
            ((ajvi)this.jdField_a_of_type_Ajtd).a(bool1, bool2, a(paramString));
          }
        }
        for (;;)
        {
          if (!QLog.isColorLevel()) {
            break label572;
          }
          localObject2 = localObject1;
          if (localObject1 != null)
          {
            localObject2 = localObject1;
            if (((String)localObject1).length() > 3) {
              localObject2 = ((String)localObject1).substring(0, 2) + "." + ((String)localObject1).charAt(((String)localObject1).length() - 1);
            }
          }
          QLog.d("Q.qqhead.dih", 2, "CreateIcon Done: uin=" + paramString + ", name=" + (String)localObject2 + ", isComplete=" + bool2 + ", newFaceUinSet=" + str + paramajxx.toString());
          return;
          localObject3 = (TroopManager)((QQAppInterface)localObject2).getManager(52);
          TroopInfo localTroopInfo = ((TroopManager)localObject3).c(paramString);
          if (localTroopInfo == null) {
            break;
          }
          localTroopInfo.mHeaderUinsOld = str;
          ((TroopManager)localObject3).b(localTroopInfo);
          localObject1 = localTroopInfo.getTroopName();
          break;
          ((ajvi)this.jdField_a_of_type_Ajtd).a(bool1, bool2, paramString);
          ((QQAppInterface)localObject2).a(101, paramString, 0, ((QQAppInterface)localObject2).a(101, paramString, 0));
          continue;
          if ((this.jdField_a_of_type_Ajtd instanceof akhq))
          {
            ((akhq)this.jdField_a_of_type_Ajtd).a(bool1, bool2, paramString);
            ((QQAppInterface)localObject2).a(113, paramString, 0, ((QQAppInterface)localObject2).a(113, paramString, 0));
          }
        }
        label572:
        break;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.qqhead.dih", 2, "CreateIcon fail: " + paramString + ", iconCount=" + paramajxx.jdField_a_of_type_JavaUtilArrayList.size() + ", totalCount=" + paramajxx.jdField_a_of_type_Int);
        return;
        localObject1 = null;
      }
    }
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_Boolean;
  }
  
  public static boolean a(String paramString)
  {
    boolean bool = true;
    if ((paramString == null) || (paramString.length() == 0))
    {
      QLog.i("Q.qqhead.dih", 1, "===isPstnDiscussionUin discussionUin is null ===");
      bool = false;
    }
    while (paramString.contains("_1001")) {
      return bool;
    }
    return false;
  }
  
  private boolean a(String paramString, boolean paramBoolean)
  {
    label390:
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        long l = System.currentTimeMillis();
        ajxx localajxx;
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))
        {
          localajxx = (ajxx)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
          if (localajxx.jdField_a_of_type_Byte == 3)
          {
            bool = true;
            if (((!bool) && (l - localajxx.jdField_a_of_type_Long < this.c)) || ((bool) && (!paramBoolean) && (l - localajxx.jdField_a_of_type_Long < 3600000L)))
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.qqhead.dih", 2, "putDiscussionIconInfo notDo, disUin=" + paramString + ",isFromCreate=" + paramBoolean + ",isRealCreated=" + bool + ",startTime=" + localajxx.jdField_a_of_type_Long + ",state=" + localajxx.jdField_a_of_type_Byte);
              }
              return false;
            }
            if ((QLog.isColorLevel()) && (!bool)) {
              QLog.d("Q.qqhead.dih", 2, "putDiscussionIconInfo reset, disUin=" + paramString + ",isFromCreate=" + paramBoolean + ",isRealCreated=" + bool + ",state=" + localajxx.jdField_a_of_type_Byte);
            }
            localajxx.a(localajxx.jdField_a_of_type_Byte);
            if (a(paramString))
            {
              QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
              localajxx.c = true;
              localajxx.d = msp.a(localQQAppInterface, b(paramString), 3000);
            }
            localajxx.jdField_a_of_type_Long = l;
            this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localajxx);
            return true;
          }
        }
        else
        {
          localajxx = new ajxx(this, null);
          this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localajxx);
          if (!QLog.isColorLevel()) {
            break label390;
          }
          QLog.d("Q.qqhead.dih", 2, "putDiscussionIconInfo  not hit, disUin=" + paramString);
        }
      }
      boolean bool = false;
    }
  }
  
  /* Error */
  private Pair<Boolean, Boolean> b(String paramString1, String paramString2, ArrayList<String> paramArrayList, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +17 -> 18
    //   4: iconst_0
    //   5: invokestatic 280	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   8: iconst_0
    //   9: invokestatic 280	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   12: invokestatic 286	android/util/Pair:create	(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;
    //   15: astore_2
    //   16: aload_2
    //   17: areturn
    //   18: aload_1
    //   19: ifnonnull +20 -> 39
    //   22: iload 5
    //   24: ifne +15 -> 39
    //   27: iconst_0
    //   28: invokestatic 280	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   31: iconst_0
    //   32: invokestatic 280	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   35: invokestatic 286	android/util/Pair:create	(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;
    //   38: areturn
    //   39: invokestatic 163	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   42: invokevirtual 167	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   45: checkcast 111	com/tencent/mobileqq/app/QQAppInterface
    //   48: astore 14
    //   50: iload 4
    //   52: ifne +707 -> 759
    //   55: aload 14
    //   57: aload_0
    //   58: getfield 150	com/tencent/mobileqq/app/GroupIconHelper:jdField_a_of_type_Int	I
    //   61: aload_2
    //   62: iconst_0
    //   63: invokevirtual 543	com/tencent/mobileqq/app/QQAppInterface:a	(ILjava/lang/String;I)Ljava/lang/String;
    //   66: astore 13
    //   68: iconst_3
    //   69: invokestatic 616	bayd:a	(B)B
    //   72: istore 6
    //   74: aload 14
    //   76: aload_0
    //   77: getfield 150	com/tencent/mobileqq/app/GroupIconHelper:jdField_a_of_type_Int	I
    //   80: aload_2
    //   81: iload 6
    //   83: iconst_0
    //   84: invokevirtual 619	com/tencent/mobileqq/app/QQAppInterface:a	(ILjava/lang/String;BI)Ljava/lang/String;
    //   87: astore 12
    //   89: iload 4
    //   91: ifeq +665 -> 756
    //   94: aload 14
    //   96: sipush 1001
    //   99: aload_2
    //   100: invokestatic 513	com/tencent/mobileqq/app/GroupIconHelper:a	(Ljava/lang/String;)Ljava/lang/String;
    //   103: iload 6
    //   105: iconst_0
    //   106: invokevirtual 619	com/tencent/mobileqq/app/QQAppInterface:a	(ILjava/lang/String;BI)Ljava/lang/String;
    //   109: astore 12
    //   111: aload 13
    //   113: invokestatic 623	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   116: ifne +634 -> 750
    //   119: new 625	java/io/File
    //   122: dup
    //   123: aload 13
    //   125: invokespecial 627	java/io/File:<init>	(Ljava/lang/String;)V
    //   128: astore 9
    //   130: aload_1
    //   131: ifnull +111 -> 242
    //   134: aload_1
    //   135: invokevirtual 208	java/lang/String:trim	()Ljava/lang/String;
    //   138: invokevirtual 252	java/lang/String:length	()I
    //   141: ifgt +101 -> 242
    //   144: aload 9
    //   146: ifnull +25 -> 171
    //   149: aload 9
    //   151: invokevirtual 630	java/io/File:exists	()Z
    //   154: ifeq +17 -> 171
    //   157: aload 9
    //   159: invokevirtual 633	java/io/File:isFile	()Z
    //   162: ifeq +9 -> 171
    //   165: aload 9
    //   167: invokevirtual 636	java/io/File:delete	()Z
    //   170: pop
    //   171: iload 4
    //   173: ifeq +13 -> 186
    //   176: iload 4
    //   178: ifeq +64 -> 242
    //   181: iload 5
    //   183: ifne +59 -> 242
    //   186: aconst_null
    //   187: astore_1
    //   188: aload_0
    //   189: getfield 150	com/tencent/mobileqq/app/GroupIconHelper:jdField_a_of_type_Int	I
    //   192: bipush 101
    //   194: if_icmpne +32 -> 226
    //   197: invokestatic 642	bbdr:h	()Landroid/graphics/Bitmap;
    //   200: astore_1
    //   201: aload_1
    //   202: ifnull +12 -> 214
    //   205: aload 14
    //   207: aload 12
    //   209: aload_1
    //   210: iconst_2
    //   211: invokevirtual 645	com/tencent/mobileqq/app/QQAppInterface:a	(Ljava/lang/String;Landroid/graphics/Bitmap;B)V
    //   214: iconst_1
    //   215: invokestatic 280	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   218: iconst_1
    //   219: invokestatic 280	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   222: invokestatic 286	android/util/Pair:create	(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;
    //   225: areturn
    //   226: aload_0
    //   227: getfield 150	com/tencent/mobileqq/app/GroupIconHelper:jdField_a_of_type_Int	I
    //   230: bipush 113
    //   232: if_icmpne -31 -> 201
    //   235: invokestatic 642	bbdr:h	()Landroid/graphics/Bitmap;
    //   238: astore_1
    //   239: goto -38 -> 201
    //   242: iconst_1
    //   243: istore 7
    //   245: aload_0
    //   246: aload_1
    //   247: aload_2
    //   248: aload_3
    //   249: iload 4
    //   251: iload 5
    //   253: invokespecial 647	com/tencent/mobileqq/app/GroupIconHelper:a	(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;ZZ)Landroid/util/Pair;
    //   256: astore_3
    //   257: aload_3
    //   258: getfield 360	android/util/Pair:second	Ljava/lang/Object;
    //   261: checkcast 341	android/graphics/Bitmap
    //   264: astore 10
    //   266: aload_3
    //   267: getfield 347	android/util/Pair:first	Ljava/lang/Object;
    //   270: checkcast 276	java/lang/Boolean
    //   273: invokevirtual 350	java/lang/Boolean:booleanValue	()Z
    //   276: istore 8
    //   278: aload 10
    //   280: ifnonnull +26 -> 306
    //   283: iconst_0
    //   284: invokestatic 280	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   287: iconst_0
    //   288: invokestatic 280	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   291: invokestatic 286	android/util/Pair:create	(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;
    //   294: areturn
    //   295: astore_3
    //   296: aconst_null
    //   297: astore 10
    //   299: iload 7
    //   301: istore 8
    //   303: goto -25 -> 278
    //   306: aconst_null
    //   307: astore 11
    //   309: iload 4
    //   311: ifeq +239 -> 550
    //   314: aload_0
    //   315: getfield 107	com/tencent/mobileqq/app/GroupIconHelper:jdField_b_of_type_JavaUtilSet	Ljava/util/Set;
    //   318: ifnull +424 -> 742
    //   321: aload_0
    //   322: getfield 107	com/tencent/mobileqq/app/GroupIconHelper:jdField_b_of_type_JavaUtilSet	Ljava/util/Set;
    //   325: astore_3
    //   326: aload_3
    //   327: monitorenter
    //   328: aload_0
    //   329: getfield 107	com/tencent/mobileqq/app/GroupIconHelper:jdField_b_of_type_JavaUtilSet	Ljava/util/Set;
    //   332: aload_2
    //   333: invokeinterface 339 2 0
    //   338: pop
    //   339: aload_3
    //   340: monitorexit
    //   341: iconst_1
    //   342: istore 7
    //   344: aconst_null
    //   345: astore_3
    //   346: aload_3
    //   347: astore 9
    //   349: aload_3
    //   350: astore 11
    //   352: invokestatic 650	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   355: ifeq +89 -> 444
    //   358: aload_3
    //   359: astore 9
    //   361: aload_3
    //   362: astore 11
    //   364: ldc 65
    //   366: iconst_4
    //   367: new 67	java/lang/StringBuilder
    //   370: dup
    //   371: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   374: ldc_w 652
    //   377: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: iload 7
    //   382: invokevirtual 320	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   385: ldc_w 654
    //   388: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: aload_2
    //   392: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: ldc_w 654
    //   398: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: aload_1
    //   402: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: ldc_w 654
    //   408: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: aload 13
    //   413: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: ldc_w 656
    //   419: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: iload 4
    //   424: invokevirtual 320	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   427: ldc_w 658
    //   430: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   433: iload 5
    //   435: invokevirtual 320	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   438: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   441: invokestatic 385	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   444: iload 6
    //   446: iconst_3
    //   447: if_icmpne +219 -> 666
    //   450: aload_3
    //   451: astore 9
    //   453: aload_3
    //   454: astore 11
    //   456: aload 10
    //   458: bipush 50
    //   460: bipush 50
    //   462: invokestatic 661	com/tencent/mobileqq/app/QQAppInterface:a	(Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;
    //   465: astore_1
    //   466: aload_3
    //   467: astore 9
    //   469: aload_3
    //   470: astore 11
    //   472: aload 14
    //   474: aload 12
    //   476: aload_1
    //   477: iconst_2
    //   478: invokevirtual 645	com/tencent/mobileqq/app/QQAppInterface:a	(Ljava/lang/String;Landroid/graphics/Bitmap;B)V
    //   481: aload_3
    //   482: ifnull +247 -> 729
    //   485: aload_3
    //   486: invokevirtual 666	java/io/BufferedOutputStream:close	()V
    //   489: iload 7
    //   491: istore 4
    //   493: iload 4
    //   495: invokestatic 280	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   498: iload 8
    //   500: invokestatic 280	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   503: invokestatic 286	android/util/Pair:create	(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;
    //   506: areturn
    //   507: astore_1
    //   508: aload_3
    //   509: monitorexit
    //   510: aload_1
    //   511: athrow
    //   512: astore_1
    //   513: aload 11
    //   515: astore_1
    //   516: iconst_0
    //   517: istore 5
    //   519: iload 5
    //   521: istore 4
    //   523: aload_1
    //   524: ifnull -31 -> 493
    //   527: aload_1
    //   528: invokevirtual 666	java/io/BufferedOutputStream:close	()V
    //   531: iload 5
    //   533: istore 4
    //   535: goto -42 -> 493
    //   538: astore_1
    //   539: aload_1
    //   540: invokevirtual 669	java/lang/Throwable:printStackTrace	()V
    //   543: iload 5
    //   545: istore 4
    //   547: goto -54 -> 493
    //   550: aload 9
    //   552: ifnonnull +51 -> 603
    //   555: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   558: ifeq +12 -> 570
    //   561: ldc 65
    //   563: iconst_2
    //   564: ldc_w 671
    //   567: invokestatic 385	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   570: iconst_0
    //   571: invokestatic 280	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   574: iconst_0
    //   575: invokestatic 280	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   578: invokestatic 286	android/util/Pair:create	(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;
    //   581: astore_1
    //   582: aload_1
    //   583: astore_2
    //   584: iconst_0
    //   585: ifeq -569 -> 16
    //   588: new 673	java/lang/NullPointerException
    //   591: dup
    //   592: invokespecial 674	java/lang/NullPointerException:<init>	()V
    //   595: athrow
    //   596: astore_2
    //   597: aload_2
    //   598: invokevirtual 669	java/lang/Throwable:printStackTrace	()V
    //   601: aload_1
    //   602: areturn
    //   603: aload 9
    //   605: invokevirtual 630	java/io/File:exists	()Z
    //   608: ifne +9 -> 617
    //   611: aload 9
    //   613: invokevirtual 677	java/io/File:createNewFile	()Z
    //   616: pop
    //   617: new 663	java/io/BufferedOutputStream
    //   620: dup
    //   621: new 679	java/io/FileOutputStream
    //   624: dup
    //   625: aload 9
    //   627: invokespecial 682	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   630: invokespecial 685	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   633: astore_3
    //   634: aload_3
    //   635: astore 9
    //   637: aload_3
    //   638: astore 11
    //   640: aload 10
    //   642: getstatic 691	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   645: bipush 90
    //   647: aload_3
    //   648: invokevirtual 695	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   651: istore 7
    //   653: aload_3
    //   654: astore 9
    //   656: aload_3
    //   657: astore 11
    //   659: aload_3
    //   660: invokevirtual 698	java/io/BufferedOutputStream:flush	()V
    //   663: goto -317 -> 346
    //   666: iload 6
    //   668: iconst_1
    //   669: if_icmpne +67 -> 736
    //   672: aload_3
    //   673: astore 9
    //   675: aload_3
    //   676: astore 11
    //   678: aload 10
    //   680: bipush 10
    //   682: bipush 50
    //   684: bipush 50
    //   686: invokestatic 701	com/tencent/mobileqq/app/QQAppInterface:a	(Landroid/graphics/Bitmap;III)Landroid/graphics/Bitmap;
    //   689: astore_1
    //   690: goto -224 -> 466
    //   693: astore_1
    //   694: aload_1
    //   695: invokevirtual 669	java/lang/Throwable:printStackTrace	()V
    //   698: goto -209 -> 489
    //   701: astore_1
    //   702: aconst_null
    //   703: astore 9
    //   705: aload 9
    //   707: ifnull +8 -> 715
    //   710: aload 9
    //   712: invokevirtual 666	java/io/BufferedOutputStream:close	()V
    //   715: aload_1
    //   716: athrow
    //   717: astore_2
    //   718: aload_2
    //   719: invokevirtual 669	java/lang/Throwable:printStackTrace	()V
    //   722: goto -7 -> 715
    //   725: astore_1
    //   726: goto -21 -> 705
    //   729: iload 7
    //   731: istore 4
    //   733: goto -240 -> 493
    //   736: aload 10
    //   738: astore_1
    //   739: goto -273 -> 466
    //   742: iconst_1
    //   743: istore 7
    //   745: aconst_null
    //   746: astore_3
    //   747: goto -401 -> 346
    //   750: aconst_null
    //   751: astore 9
    //   753: goto -623 -> 130
    //   756: goto -645 -> 111
    //   759: aconst_null
    //   760: astore 13
    //   762: goto -694 -> 68
    //   765: astore_1
    //   766: aload 11
    //   768: astore_1
    //   769: goto -253 -> 516
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	772	0	this	GroupIconHelper
    //   0	772	1	paramString1	String
    //   0	772	2	paramString2	String
    //   0	772	3	paramArrayList	ArrayList<String>
    //   0	772	4	paramBoolean1	boolean
    //   0	772	5	paramBoolean2	boolean
    //   72	598	6	b1	byte
    //   243	501	7	bool1	boolean
    //   276	223	8	bool2	boolean
    //   128	624	9	localObject	Object
    //   264	473	10	localBitmap	Bitmap
    //   307	460	11	localArrayList	ArrayList<String>
    //   87	388	12	str1	String
    //   66	695	13	str2	String
    //   48	425	14	localQQAppInterface	QQAppInterface
    // Exception table:
    //   from	to	target	type
    //   245	278	295	java/lang/Throwable
    //   328	341	507	finally
    //   508	510	507	finally
    //   314	328	512	java/lang/Throwable
    //   510	512	512	java/lang/Throwable
    //   555	570	512	java/lang/Throwable
    //   570	582	512	java/lang/Throwable
    //   603	617	512	java/lang/Throwable
    //   617	634	512	java/lang/Throwable
    //   527	531	538	java/lang/Throwable
    //   588	596	596	java/lang/Throwable
    //   485	489	693	java/lang/Throwable
    //   314	328	701	finally
    //   510	512	701	finally
    //   555	570	701	finally
    //   570	582	701	finally
    //   603	617	701	finally
    //   617	634	701	finally
    //   710	715	717	java/lang/Throwable
    //   352	358	725	finally
    //   364	444	725	finally
    //   456	466	725	finally
    //   472	481	725	finally
    //   640	653	725	finally
    //   659	663	725	finally
    //   678	690	725	finally
    //   352	358	765	java/lang/Throwable
    //   364	444	765	java/lang/Throwable
    //   456	466	765	java/lang/Throwable
    //   472	481	765	java/lang/Throwable
    //   640	653	765	java/lang/Throwable
    //   659	663	765	java/lang/Throwable
    //   678	690	765	java/lang/Throwable
  }
  
  public static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.i("Q.qqhead.dih", 1, "===getDiscussionUinFromPstn pstnDiscussionUin is null ===");
      return null;
    }
    int i = paramString.indexOf("_");
    if ((i < 0) || (i > paramString.length()))
    {
      QLog.i("Q.qqhead.dih", 1, "===getDiscussionUinFromPstn pstnDiscussionUin is invalid, pstnDiscussionUin | " + paramString);
      return null;
    }
    return paramString.substring(0, i);
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.dih", 2, "runNext: mRunningTaskNum=" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() + ", queueSize=" + this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size());
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() < 3)
    {
      GroupIconHelper.GenerateIconRunner localGenerateIconRunner = (GroupIconHelper.GenerateIconRunner)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.poll();
      if (localGenerateIconRunner != null)
      {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
        ThreadManager.post(localGenerateIconRunner, 10, null, true);
      }
    }
  }
  
  private void g(String paramString)
  {
    this.jdField_a_of_type_Ajxy.removeMessages(9527, paramString);
    paramString = this.jdField_a_of_type_Ajxy.obtainMessage(9527, paramString);
    this.jdField_a_of_type_Ajxy.sendMessageDelayed(paramString, 300L);
  }
  
  /* Error */
  public Bitmap a(int paramInt, Bitmap[] paramArrayOfBitmap)
  {
    // Byte code:
    //   0: iload_1
    //   1: aload_2
    //   2: invokestatic 754	bazq:a	(I[Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   5: astore_2
    //   6: aload_2
    //   7: astore_3
    //   8: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11: ifeq +20 -> 31
    //   14: aload_2
    //   15: astore_3
    //   16: aload_2
    //   17: ifnonnull +14 -> 31
    //   20: ldc 65
    //   22: iconst_2
    //   23: ldc_w 756
    //   26: invokestatic 385	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   29: aload_2
    //   30: astore_3
    //   31: aload_3
    //   32: areturn
    //   33: astore 4
    //   35: aconst_null
    //   36: astore_2
    //   37: aload_2
    //   38: astore_3
    //   39: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   42: ifeq -11 -> 31
    //   45: ldc 65
    //   47: iconst_2
    //   48: aload 4
    //   50: invokevirtual 757	java/lang/Exception:toString	()Ljava/lang/String;
    //   53: invokestatic 385	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   56: aload_2
    //   57: areturn
    //   58: astore 4
    //   60: aconst_null
    //   61: astore_2
    //   62: aload_2
    //   63: astore_3
    //   64: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   67: ifeq -36 -> 31
    //   70: ldc 65
    //   72: iconst_2
    //   73: aload 4
    //   75: invokevirtual 758	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   78: invokestatic 385	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   81: aload_2
    //   82: areturn
    //   83: astore 4
    //   85: aconst_null
    //   86: astore_2
    //   87: aload_2
    //   88: astore_3
    //   89: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   92: ifeq -61 -> 31
    //   95: ldc 65
    //   97: iconst_2
    //   98: aload 4
    //   100: invokevirtual 759	java/lang/Error:toString	()Ljava/lang/String;
    //   103: invokestatic 385	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   106: aload_2
    //   107: areturn
    //   108: astore 4
    //   110: goto -23 -> 87
    //   113: astore 4
    //   115: goto -53 -> 62
    //   118: astore 4
    //   120: goto -83 -> 37
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	this	GroupIconHelper
    //   0	123	1	paramInt	int
    //   0	123	2	paramArrayOfBitmap	Bitmap[]
    //   7	82	3	arrayOfBitmap	Bitmap[]
    //   33	16	4	localException1	java.lang.Exception
    //   58	16	4	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   83	16	4	localError1	java.lang.Error
    //   108	1	4	localError2	java.lang.Error
    //   113	1	4	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   118	1	4	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   0	6	33	java/lang/Exception
    //   0	6	58	java/lang/OutOfMemoryError
    //   0	6	83	java/lang/Error
    //   8	14	108	java/lang/Error
    //   20	29	108	java/lang/Error
    //   8	14	113	java/lang/OutOfMemoryError
    //   20	29	113	java/lang/OutOfMemoryError
    //   8	14	118	java/lang/Exception
    //   20	29	118	java/lang/Exception
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.dih", 2, "GroupIconHelper release.");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppGroupIconHelper$CheckDisIconThread != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppGroupIconHelper$CheckDisIconThread.jdField_a_of_type_Boolean = false;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaLangObject.notifyAll();
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        this.jdField_a_of_type_JavaUtilHashMap.notifyAll();
        Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          Object localObject4 = this.jdField_a_of_type_JavaUtilHashMap.get(str);
          if ((localObject4 != null) && ((localObject4 instanceof ajxx)))
          {
            localObject4 = (ajxx)localObject4;
            if ((localObject4 != null) && (((ajxx)localObject4).jdField_a_of_type_Byte != 3) && ((this.jdField_a_of_type_Ajtd instanceof ajvi))) {
              ((ajvi)this.jdField_a_of_type_Ajtd).a(false, true, str);
            }
          }
        }
      }
    }
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    ??? = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)((QQAppInterface)???).getManager(11);
    if (localPhoneContactManagerImp != null) {
      localPhoneContactManagerImp.b(this);
    }
    ((QQAppInterface)???).removeObserver(this);
    this.jdField_a_of_type_Ajtd = null;
  }
  
  public void a(int paramInt) {}
  
  public void a(long paramLong) {}
  
  public void a(String paramString)
  {
    boolean bool = a(paramString, true);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.dih", 2, "createDisIcon: " + paramString + ", isNeedToDo=" + bool);
    }
    if (bool) {
      g(paramString);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt) {}
  
  public void b(int paramInt) {}
  
  public void b(String paramString)
  {
    boolean bool = a(paramString, false);
    if (bool)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqhead.dih", 2, "checkDisIcon: " + paramString + ", isNeedToDo=" + bool);
      }
      a(new GroupIconHelper.GenerateIconRunner(this, 1, paramString));
    }
  }
  
  public void c(int paramInt)
  {
    if ((paramInt == 1) && (this.jdField_a_of_type_JavaUtilSet != null)) {
      for (;;)
      {
        synchronized (this.jdField_a_of_type_JavaUtilSet)
        {
          if (this.jdField_a_of_type_JavaUtilSet.size() > 0)
          {
            ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilSet);
            int i = localArrayList.size();
            paramInt = 0;
            if (paramInt < i)
            {
              String str = (String)localArrayList.get(paramInt);
              if ((str != null) && (str.length() != 0)) {
                e(str);
              }
            }
            else
            {
              this.jdField_a_of_type_JavaUtilSet.clear();
            }
          }
          else
          {
            return;
          }
        }
        paramInt += 1;
      }
    }
  }
  
  public void c(String paramString)
  {
    long l = System.currentTimeMillis();
    if ((this.jdField_a_of_type_JavaUtilHashtable.containsKey(paramString)) && (l - ((Long)this.jdField_a_of_type_JavaUtilHashtable.get(paramString)).longValue() < this.jdField_b_of_type_Int)) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqhead.dih", 2, "refreshDisIcon repeat: " + paramString);
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqhead.dih", 2, "refreshDisIcon: " + paramString);
      }
      this.jdField_a_of_type_JavaUtilHashtable.put(paramString, Long.valueOf(l));
      a(new GroupIconHelper.GenerateIconRunner(this, 3, paramString));
    } while ((this.jdField_b_of_type_JavaUtilSet == null) || (!this.jdField_b_of_type_JavaUtilSet.contains(paramString)));
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.dih", 2, "refreshDisIcon mDisCallUinSet has it " + paramString);
    }
    synchronized (this.jdField_b_of_type_JavaUtilSet)
    {
      this.jdField_b_of_type_JavaUtilSet.remove(paramString);
      e(paramString);
      return;
    }
  }
  
  public void d(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.dih", 2, "removeDiscussion: " + paramString);
    }
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
      return;
    }
  }
  
  public void e(String paramString)
  {
    String str = a(paramString);
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(str))
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      d(str);
      localQQAppInterface.a(localQQAppInterface.a(1001, a(paramString), (byte)3, 0));
      a(str);
    }
  }
  
  public void f(String paramString)
  {
    ??? = msp.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramString, 3000);
    if (((??? == null) || (((String)???).length() == 0)) && (this.jdField_a_of_type_JavaUtilSet.contains(paramString))) {}
    synchronized (this.jdField_a_of_type_JavaUtilSet)
    {
      this.jdField_a_of_type_JavaUtilSet.remove(paramString);
      e(paramString);
      return;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      paramMessage = (String)paramMessage.obj;
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqhead.dih", 2, "handleMessage ACTION_GENERATE_DISCUSSION: groupUin=" + paramMessage);
      }
      a(new GroupIconHelper.GenerateIconRunner(this, 2, paramMessage));
    }
  }
  
  public void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.dih", 2, "onUpdateCustomHead isSuccess | " + paramBoolean + ", uin=");
    }
    label417:
    label420:
    label423:
    label429:
    for (;;)
    {
      ArrayList localArrayList;
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
        localArrayList = null;
        if (localIterator.hasNext())
        {
          String str1 = (String)localIterator.next();
          localObject = this.jdField_a_of_type_JavaUtilHashMap.get(str1);
          if ((localObject == null) || (!(localObject instanceof ajxx))) {
            break label423;
          }
          localObject = (ajxx)localObject;
          if ((localObject == null) || (((ajxx)localObject).jdField_a_of_type_JavaLangString == null)) {
            continue;
          }
          if (((ajxx)localObject).c)
          {
            str2 = ((ajxx)localObject).jdField_a_of_type_JavaLangString;
            if ((!paramBoolean) || (!str2.contains(paramString))) {
              break label420;
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.qqhead.dih", 2, "onUpdateCustomHead pstn: disUin=" + str1 + ", uin=" + paramString + ", faceUinSet=" + str2);
            }
            if (((ajxx)localObject).jdField_a_of_type_Byte != 3)
            {
              ((ajxx)localObject).jdField_a_of_type_JavaUtilArrayList.add(paramString);
              g(str1);
              break label429;
            }
            if (localArrayList != null) {
              break label417;
            }
            localArrayList = new ArrayList();
            localArrayList.add(str1);
            break label429;
          }
          if (((ajxx)localObject).jdField_a_of_type_Byte == 3) {
            continue;
          }
          String str2 = ((ajxx)localObject).jdField_a_of_type_JavaLangString;
          if ((!paramBoolean) || (!str2.contains(paramString))) {
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.qqhead.dih", 2, "onUpdateCustomHead: disUin=" + str1 + ", uin=" + paramString + ", faceUinSet=" + str2);
          }
          ((ajxx)localObject).jdField_a_of_type_JavaUtilArrayList.add(paramString);
          g(str1);
        }
      }
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        paramString = localArrayList.iterator();
        while (paramString.hasNext()) {
          e(b((String)paramString.next()));
        }
      }
      return;
      continue;
      break label429;
      Object localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.GroupIconHelper
 * JD-Core Version:    0.7.0.1
 */