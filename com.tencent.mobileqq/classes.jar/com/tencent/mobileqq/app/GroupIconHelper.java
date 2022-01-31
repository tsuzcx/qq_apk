package com.tencent.mobileqq.app;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import com.tencent.av.utils.PstnUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.model.PhoneContactManager.IPhoneContactListener;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
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
import zlj;
import zlk;
import zll;
import zlm;
import zln;
import zlo;

public class GroupIconHelper
  extends FriendListObserver
  implements Handler.Callback, PhoneContactManager.IPhoneContactListener
{
  private static boolean jdField_a_of_type_Boolean;
  public int a;
  private BusinessHandler jdField_a_of_type_ComTencentMobileqqAppBusinessHandler;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private Hashtable jdField_a_of_type_JavaUtilHashtable;
  private Set jdField_a_of_type_JavaUtilSet;
  ConcurrentLinkedQueue jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  private zlk jdField_a_of_type_Zlk;
  private zlo jdField_a_of_type_Zlo;
  public volatile int b;
  private Set b;
  private int c = 60000;
  private int d = 90000;
  
  public GroupIconHelper(String paramString, BusinessHandler paramBusinessHandler)
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = paramString;
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.dih", 2, "Create GroupIconHelper For [" + this.jdField_a_of_type_JavaLangString + "]");
    }
    paramString = paramBusinessHandler.b;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilHashtable = new Hashtable();
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_b_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_Zlo = new zlo(paramString.getApp().getMainLooper(), this, null);
    this.jdField_a_of_type_ComTencentMobileqqAppBusinessHandler = paramBusinessHandler;
    paramString.a(new zll(this));
    paramString.addObserver(this);
    paramString = (PhoneContactManagerImp)paramString.getManager(10);
    if (paramString != null) {
      paramString.a(this);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBusinessHandler instanceof DiscussionHandler))
    {
      this.jdField_a_of_type_Int = 101;
      return;
    }
    this.jdField_a_of_type_Int = 113;
  }
  
  private Pair a(String paramString1, String paramString2, ArrayList paramArrayList, boolean paramBoolean1, boolean paramBoolean2)
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
        if (arrayOfString.length > 5) {
          i = 5;
        }
      }
      else
      {
        if ((i >= 5) || (!paramBoolean1)) {
          break label531;
        }
        paramString1 = PstnUtils.a(localQQAppInterface, paramString2, 3000, 5 - i);
        if ((paramString1 == null) || (paramString1.size() <= 0)) {
          break label524;
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
            Pair localPair = localQQAppInterface.a(str, 0, 0);
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
        label524:
        j = i;
        continue;
        label531:
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
  
  public static String a(ArrayList paramArrayList, boolean paramBoolean)
  {
    int j = 0;
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder(128);
      paramArrayList = (ArrayList)paramArrayList.clone();
      String[] arrayOfString = new String[paramArrayList.size()];
      int i = 0;
      while (i < arrayOfString.length)
      {
        arrayOfString[i] = ((String)paramArrayList.get(i));
        i += 1;
      }
      Arrays.sort(arrayOfString, a());
      int k = 0;
      i = j;
      j = k;
      for (;;)
      {
        if (i < arrayOfString.length)
        {
          localStringBuilder.append(arrayOfString[i]).append(";");
          j += 1;
          if ((!paramBoolean) || (!a()) || (j < 4)) {
            break label133;
          }
        }
        label133:
        while (j >= 5) {
          return localStringBuilder.toString();
        }
        i += 1;
      }
    }
    return " ";
  }
  
  public static Comparator a()
  {
    return new zlj();
  }
  
  private zln a(String paramString, boolean paramBoolean1, zln paramzln, boolean paramBoolean2)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Object localObject1;
    label87:
    label105:
    Object localObject3;
    Object localObject2;
    if (this.jdField_a_of_type_Int == 101)
    {
      localObject1 = ((DiscussionManager)localQQAppInterface.getManager(52)).b(paramString);
      if (QLog.isColorLevel())
      {
        if ((localObject1 != null) && (((ArrayList)localObject1).size() != 0)) {
          break label293;
        }
        QLog.d("Q.qqhead.dih", 2, "discussionUin=" + paramString + " memberUinList is empty...");
      }
      if ((localObject1 != null) && (((ArrayList)localObject1).size() != 0)) {
        break label423;
      }
      paramzln.jdField_a_of_type_Int = 0;
      localObject3 = a((ArrayList)localObject1, paramBoolean2);
      paramzln.jdField_a_of_type_JavaLangString = ((String)localObject3);
      if (paramBoolean1)
      {
        localObject2 = null;
        if (this.jdField_a_of_type_Int != 101) {
          break label435;
        }
        paramString = ((DiscussionManager)localQQAppInterface.getManager(52)).a(paramString);
        if (paramString == null) {
          break label562;
        }
      }
    }
    label163:
    label293:
    label423:
    label562:
    for (paramString = paramString.faceUinSet;; paramString = null)
    {
      localObject1 = paramString;
      if (((localObject1 == null) || ("".equals(((String)localObject1).trim()))) && ((localObject3 == null) || ("".equals(((String)localObject3).trim())))) {
        paramBoolean1 = false;
      }
      for (;;)
      {
        paramzln.jdField_a_of_type_Boolean = paramBoolean1;
        return paramzln;
        localObject1 = (TroopManager)localQQAppInterface.getManager(51);
        localObject2 = ((TroopManager)localObject1).a(paramString);
        localObject3 = ((TroopManager)localObject1).b(paramString);
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
        ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppBusinessHandler).b(Long.parseLong(paramString));
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
        break label87;
        paramzln.jdField_a_of_type_Int = ((ArrayList)localObject1).size();
        break label105;
        label435:
        localObject1 = localObject2;
        if (this.jdField_a_of_type_Int != 113) {
          break label163;
        }
        paramString = ((TroopManager)localQQAppInterface.getManager(51)).b(paramString);
        localObject1 = localObject2;
        if (paramString == null) {
          break label163;
        }
        localObject1 = paramString.mHeaderUinsOld;
        break label163;
        if ((localObject3 != null) && (!((String)localObject3).equals(localObject1))) {
          paramBoolean1 = true;
        } else if ((localObject1 != null) && (!((String)localObject1).equals(localObject3))) {
          paramBoolean1 = true;
        } else if ((paramzln.jdField_a_of_type_Byte == 2) && (localObject3 != null) && (!((String)localObject3).equals(paramzln.jdField_b_of_type_JavaLangString)) && (paramzln.e)) {
          paramBoolean1 = true;
        } else {
          paramBoolean1 = false;
        }
      }
    }
  }
  
  private void a(String paramString, zln paramzln, boolean paramBoolean)
  {
    Object localObject1 = null;
    if (paramzln.jdField_a_of_type_Byte == 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqhead.dih", 2, "CreateIcon created: " + paramString + ", iconCount=" + paramzln.jdField_a_of_type_JavaUtilArrayList.size() + ", totalCount=" + paramzln.jdField_a_of_type_Int);
      }
      return;
    }
    Object localObject3 = b(paramzln.jdField_a_of_type_JavaLangString, paramString, paramzln.jdField_a_of_type_JavaUtilArrayList, paramzln.c, paramzln.d);
    boolean bool1 = ((Boolean)((Pair)localObject3).first).booleanValue();
    Object localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    boolean bool2 = ((Boolean)((Pair)localObject3).second).booleanValue();
    if (bool1)
    {
      paramzln.jdField_b_of_type_Int += 1;
      localObject3 = a(paramzln.jdField_a_of_type_JavaUtilArrayList, paramBoolean);
      paramzln.jdField_b_of_type_JavaLangString = ((String)localObject3);
      if (this.jdField_a_of_type_Int == 101)
      {
        localObject1 = (DiscussionManager)((QQAppInterface)localObject2).getManager(52);
        if (localObject1 == null) {
          break label606;
        }
      }
    }
    label536:
    label606:
    for (localObject1 = ((DiscussionManager)localObject1).a(paramString);; localObject1 = null)
    {
      if (localObject1 != null)
      {
        ((DiscussionInfo)localObject1).faceUinSet = ((String)localObject3);
        localObject2 = ((QQAppInterface)localObject2).getEntityManagerFactory().createEntityManager();
        ((EntityManager)localObject2).a((Entity)localObject1);
        ((EntityManager)localObject2).a();
        if (QLog.isColorLevel()) {
          localObject1 = ((DiscussionInfo)localObject1).discussionName;
        }
      }
      for (;;)
      {
        if ((paramzln.jdField_a_of_type_JavaUtilArrayList.size() >= paramzln.jdField_a_of_type_Int) && (bool2)) {
          paramzln.jdField_a_of_type_Byte = 3;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqAppBusinessHandler instanceof DiscussionHandler)) {
          if (paramzln.c) {
            ((DiscussionHandler)this.jdField_a_of_type_ComTencentMobileqqAppBusinessHandler).a(bool1, bool2, a(paramString));
          }
        }
        for (;;)
        {
          if (!QLog.isColorLevel()) {
            break label536;
          }
          localObject2 = localObject1;
          if (localObject1 != null)
          {
            localObject2 = localObject1;
            if (((String)localObject1).length() > 3) {
              localObject2 = ((String)localObject1).substring(0, 2) + "." + ((String)localObject1).charAt(((String)localObject1).length() - 1);
            }
          }
          QLog.d("Q.qqhead.dih", 2, "CreateIcon Done: uin=" + paramString + ", name=" + (String)localObject2 + ", isComplete=" + bool2 + ", newFaceUinSet=" + (String)localObject3 + paramzln.toString());
          return;
          localObject2 = (TroopManager)((QQAppInterface)localObject2).getManager(51);
          TroopInfo localTroopInfo = ((TroopManager)localObject2).b(paramString);
          if (localTroopInfo == null) {
            break;
          }
          localTroopInfo.mHeaderUinsOld = ((String)localObject3);
          ((TroopManager)localObject2).b(localTroopInfo);
          localObject1 = localTroopInfo.getTroopName();
          break;
          ((DiscussionHandler)this.jdField_a_of_type_ComTencentMobileqqAppBusinessHandler).a(bool1, bool2, paramString);
          continue;
          if ((this.jdField_a_of_type_ComTencentMobileqqAppBusinessHandler instanceof TroopHandler)) {
            ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppBusinessHandler).a(bool1, bool2, paramString);
          }
        }
        break;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.qqhead.dih", 2, "CreateIcon fail: " + paramString + ", iconCount=" + paramzln.jdField_a_of_type_JavaUtilArrayList.size() + ", totalCount=" + paramzln.jdField_a_of_type_Int);
        return;
        localObject1 = null;
      }
    }
  }
  
  private void a(zlm paramzlm)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.offer(paramzlm);
    b();
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
        zln localzln;
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))
        {
          localzln = (zln)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
          if (localzln.jdField_a_of_type_Byte == 3)
          {
            bool = true;
            if (((!bool) && (l - localzln.jdField_a_of_type_Long < this.d)) || ((bool) && (!paramBoolean) && (l - localzln.jdField_a_of_type_Long < 3600000L)))
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.qqhead.dih", 2, "putDiscussionIconInfo notDo, disUin=" + paramString + ",isFromCreate=" + paramBoolean + ",isRealCreated=" + bool + ",startTime=" + localzln.jdField_a_of_type_Long + ",state=" + localzln.jdField_a_of_type_Byte);
              }
              return false;
            }
            if ((QLog.isColorLevel()) && (!bool)) {
              QLog.d("Q.qqhead.dih", 2, "putDiscussionIconInfo reset, disUin=" + paramString + ",isFromCreate=" + paramBoolean + ",isRealCreated=" + bool + ",state=" + localzln.jdField_a_of_type_Byte);
            }
            localzln.a(localzln.jdField_a_of_type_Byte);
            if (a(paramString))
            {
              QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
              localzln.c = true;
              localzln.d = PstnUtils.a(localQQAppInterface, b(paramString), 3000);
            }
            localzln.jdField_a_of_type_Long = l;
            this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localzln);
            return true;
          }
        }
        else
        {
          localzln = new zln(this, null);
          this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localzln);
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
  private Pair b(String paramString1, String paramString2, ArrayList arg3, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +17 -> 18
    //   4: iconst_0
    //   5: invokestatic 159	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   8: iconst_0
    //   9: invokestatic 159	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   12: invokestatic 165	android/util/Pair:create	(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;
    //   15: astore_2
    //   16: aload_2
    //   17: areturn
    //   18: aload_1
    //   19: ifnonnull +20 -> 39
    //   22: iload 5
    //   24: ifne +15 -> 39
    //   27: iconst_0
    //   28: invokestatic 159	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   31: iconst_0
    //   32: invokestatic 159	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   35: invokestatic 165	android/util/Pair:create	(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;
    //   38: areturn
    //   39: invokestatic 171	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   42: invokevirtual 175	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   45: checkcast 100	com/tencent/mobileqq/app/QQAppInterface
    //   48: astore 13
    //   50: iload 4
    //   52: ifne +648 -> 700
    //   55: aload 13
    //   57: aload_0
    //   58: getfield 142	com/tencent/mobileqq/app/GroupIconHelper:jdField_a_of_type_Int	I
    //   61: aload_2
    //   62: iconst_0
    //   63: invokevirtual 548	com/tencent/mobileqq/app/QQAppInterface:a	(ILjava/lang/String;I)Ljava/lang/String;
    //   66: astore 11
    //   68: aload 13
    //   70: aload_0
    //   71: getfield 142	com/tencent/mobileqq/app/GroupIconHelper:jdField_a_of_type_Int	I
    //   74: aload_2
    //   75: iconst_1
    //   76: iconst_0
    //   77: invokevirtual 551	com/tencent/mobileqq/app/QQAppInterface:a	(ILjava/lang/String;BI)Ljava/lang/String;
    //   80: astore 10
    //   82: iload 4
    //   84: ifeq +613 -> 697
    //   87: aload 13
    //   89: sipush 1001
    //   92: aload_2
    //   93: invokestatic 448	com/tencent/mobileqq/app/GroupIconHelper:a	(Ljava/lang/String;)Ljava/lang/String;
    //   96: iconst_1
    //   97: iconst_0
    //   98: invokevirtual 551	com/tencent/mobileqq/app/QQAppInterface:a	(ILjava/lang/String;BI)Ljava/lang/String;
    //   101: astore 10
    //   103: aload 11
    //   105: invokestatic 556	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   108: ifne +583 -> 691
    //   111: new 558	java/io/File
    //   114: dup
    //   115: aload 11
    //   117: invokespecial 560	java/io/File:<init>	(Ljava/lang/String;)V
    //   120: astore 8
    //   122: aload_1
    //   123: ifnull +111 -> 234
    //   126: aload_1
    //   127: invokevirtual 342	java/lang/String:trim	()Ljava/lang/String;
    //   130: invokevirtual 153	java/lang/String:length	()I
    //   133: ifgt +101 -> 234
    //   136: aload 8
    //   138: ifnull +25 -> 163
    //   141: aload 8
    //   143: invokevirtual 563	java/io/File:exists	()Z
    //   146: ifeq +17 -> 163
    //   149: aload 8
    //   151: invokevirtual 566	java/io/File:isFile	()Z
    //   154: ifeq +9 -> 163
    //   157: aload 8
    //   159: invokevirtual 569	java/io/File:delete	()Z
    //   162: pop
    //   163: iload 4
    //   165: ifeq +13 -> 178
    //   168: iload 4
    //   170: ifeq +64 -> 234
    //   173: iload 5
    //   175: ifne +59 -> 234
    //   178: aconst_null
    //   179: astore_1
    //   180: aload_0
    //   181: getfield 142	com/tencent/mobileqq/app/GroupIconHelper:jdField_a_of_type_Int	I
    //   184: bipush 101
    //   186: if_icmpne +32 -> 218
    //   189: invokestatic 575	com/tencent/mobileqq/utils/ImageUtil:h	()Landroid/graphics/Bitmap;
    //   192: astore_1
    //   193: aload_1
    //   194: ifnull +12 -> 206
    //   197: aload 13
    //   199: aload 10
    //   201: aload_1
    //   202: iconst_2
    //   203: invokevirtual 578	com/tencent/mobileqq/app/QQAppInterface:a	(Ljava/lang/String;Landroid/graphics/Bitmap;B)V
    //   206: iconst_1
    //   207: invokestatic 159	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   210: iconst_1
    //   211: invokestatic 159	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   214: invokestatic 165	android/util/Pair:create	(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;
    //   217: areturn
    //   218: aload_0
    //   219: getfield 142	com/tencent/mobileqq/app/GroupIconHelper:jdField_a_of_type_Int	I
    //   222: bipush 113
    //   224: if_icmpne -31 -> 193
    //   227: invokestatic 581	com/tencent/mobileqq/utils/ImageUtil:f	()Landroid/graphics/Bitmap;
    //   230: astore_1
    //   231: goto -38 -> 193
    //   234: aload_0
    //   235: aload_1
    //   236: aload_2
    //   237: aload_3
    //   238: iload 4
    //   240: iload 5
    //   242: invokespecial 583	com/tencent/mobileqq/app/GroupIconHelper:a	(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;ZZ)Landroid/util/Pair;
    //   245: astore_3
    //   246: aload_3
    //   247: getfield 256	android/util/Pair:second	Ljava/lang/Object;
    //   250: checkcast 235	android/graphics/Bitmap
    //   253: astore 12
    //   255: aload_3
    //   256: getfield 241	android/util/Pair:first	Ljava/lang/Object;
    //   259: checkcast 155	java/lang/Boolean
    //   262: invokevirtual 244	java/lang/Boolean:booleanValue	()Z
    //   265: istore 7
    //   267: aload 12
    //   269: ifnonnull +25 -> 294
    //   272: iconst_0
    //   273: invokestatic 159	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   276: iconst_0
    //   277: invokestatic 159	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   280: invokestatic 165	android/util/Pair:create	(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;
    //   283: areturn
    //   284: astore_3
    //   285: iconst_1
    //   286: istore 7
    //   288: aconst_null
    //   289: astore 12
    //   291: goto -24 -> 267
    //   294: aconst_null
    //   295: astore 9
    //   297: iload 4
    //   299: ifeq +218 -> 517
    //   302: aload_0
    //   303: getfield 96	com/tencent/mobileqq/app/GroupIconHelper:jdField_b_of_type_JavaUtilSet	Ljava/util/Set;
    //   306: ifnull +377 -> 683
    //   309: aload_0
    //   310: getfield 96	com/tencent/mobileqq/app/GroupIconHelper:jdField_b_of_type_JavaUtilSet	Ljava/util/Set;
    //   313: astore_3
    //   314: aload_3
    //   315: monitorenter
    //   316: aload_0
    //   317: getfield 96	com/tencent/mobileqq/app/GroupIconHelper:jdField_b_of_type_JavaUtilSet	Ljava/util/Set;
    //   320: aload_2
    //   321: invokeinterface 233 2 0
    //   326: pop
    //   327: aload_3
    //   328: monitorexit
    //   329: iconst_1
    //   330: istore 6
    //   332: aconst_null
    //   333: astore_3
    //   334: aload_3
    //   335: astore 9
    //   337: aload_3
    //   338: astore 8
    //   340: invokestatic 586	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   343: ifeq +89 -> 432
    //   346: aload_3
    //   347: astore 9
    //   349: aload_3
    //   350: astore 8
    //   352: ldc 56
    //   354: iconst_4
    //   355: new 58	java/lang/StringBuilder
    //   358: dup
    //   359: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   362: ldc_w 588
    //   365: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: iload 6
    //   370: invokevirtual 209	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   373: ldc_w 590
    //   376: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: aload_2
    //   380: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: ldc_w 590
    //   386: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: aload_1
    //   390: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: ldc_w 590
    //   396: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: aload 11
    //   401: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   404: ldc_w 592
    //   407: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: iload 4
    //   412: invokevirtual 209	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   415: ldc_w 594
    //   418: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: iload 5
    //   423: invokevirtual 209	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   426: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   429: invokestatic 276	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   432: aload_3
    //   433: astore 9
    //   435: aload_3
    //   436: astore 8
    //   438: aload 13
    //   440: aload 10
    //   442: aload 12
    //   444: iconst_2
    //   445: invokevirtual 578	com/tencent/mobileqq/app/QQAppInterface:a	(Ljava/lang/String;Landroid/graphics/Bitmap;B)V
    //   448: aload_3
    //   449: ifnull +227 -> 676
    //   452: aload_3
    //   453: invokevirtual 599	java/io/BufferedOutputStream:close	()V
    //   456: iload 6
    //   458: istore 4
    //   460: iload 4
    //   462: invokestatic 159	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   465: iload 7
    //   467: invokestatic 159	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   470: invokestatic 165	android/util/Pair:create	(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;
    //   473: areturn
    //   474: astore_1
    //   475: aload_3
    //   476: monitorexit
    //   477: aload_1
    //   478: athrow
    //   479: astore_1
    //   480: aload 9
    //   482: astore_1
    //   483: iconst_0
    //   484: istore 5
    //   486: iload 5
    //   488: istore 4
    //   490: aload_1
    //   491: ifnull -31 -> 460
    //   494: aload_1
    //   495: invokevirtual 599	java/io/BufferedOutputStream:close	()V
    //   498: iload 5
    //   500: istore 4
    //   502: goto -42 -> 460
    //   505: astore_1
    //   506: aload_1
    //   507: invokevirtual 602	java/lang/Throwable:printStackTrace	()V
    //   510: iload 5
    //   512: istore 4
    //   514: goto -54 -> 460
    //   517: aload 8
    //   519: ifnonnull +51 -> 570
    //   522: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   525: ifeq +12 -> 537
    //   528: ldc 56
    //   530: iconst_2
    //   531: ldc_w 604
    //   534: invokestatic 276	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   537: iconst_0
    //   538: invokestatic 159	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   541: iconst_0
    //   542: invokestatic 159	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   545: invokestatic 165	android/util/Pair:create	(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;
    //   548: astore_1
    //   549: aload_1
    //   550: astore_2
    //   551: iconst_0
    //   552: ifeq -536 -> 16
    //   555: new 606	java/lang/NullPointerException
    //   558: dup
    //   559: invokespecial 607	java/lang/NullPointerException:<init>	()V
    //   562: athrow
    //   563: astore_2
    //   564: aload_2
    //   565: invokevirtual 602	java/lang/Throwable:printStackTrace	()V
    //   568: aload_1
    //   569: areturn
    //   570: aload 8
    //   572: invokevirtual 563	java/io/File:exists	()Z
    //   575: ifne +9 -> 584
    //   578: aload 8
    //   580: invokevirtual 610	java/io/File:createNewFile	()Z
    //   583: pop
    //   584: new 596	java/io/BufferedOutputStream
    //   587: dup
    //   588: new 612	java/io/FileOutputStream
    //   591: dup
    //   592: aload 8
    //   594: invokespecial 615	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   597: invokespecial 618	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   600: astore_3
    //   601: aload_3
    //   602: astore 9
    //   604: aload_3
    //   605: astore 8
    //   607: aload 12
    //   609: getstatic 624	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   612: bipush 90
    //   614: aload_3
    //   615: invokevirtual 628	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   618: istore 6
    //   620: aload_3
    //   621: astore 9
    //   623: aload_3
    //   624: astore 8
    //   626: aload_3
    //   627: invokevirtual 631	java/io/BufferedOutputStream:flush	()V
    //   630: goto -296 -> 334
    //   633: astore_1
    //   634: aload 9
    //   636: astore_1
    //   637: goto -154 -> 483
    //   640: astore_1
    //   641: aload_1
    //   642: invokevirtual 602	java/lang/Throwable:printStackTrace	()V
    //   645: goto -189 -> 456
    //   648: astore_1
    //   649: aconst_null
    //   650: astore 8
    //   652: aload 8
    //   654: ifnull +8 -> 662
    //   657: aload 8
    //   659: invokevirtual 599	java/io/BufferedOutputStream:close	()V
    //   662: aload_1
    //   663: athrow
    //   664: astore_2
    //   665: aload_2
    //   666: invokevirtual 602	java/lang/Throwable:printStackTrace	()V
    //   669: goto -7 -> 662
    //   672: astore_1
    //   673: goto -21 -> 652
    //   676: iload 6
    //   678: istore 4
    //   680: goto -220 -> 460
    //   683: iconst_1
    //   684: istore 6
    //   686: aconst_null
    //   687: astore_3
    //   688: goto -354 -> 334
    //   691: aconst_null
    //   692: astore 8
    //   694: goto -572 -> 122
    //   697: goto -594 -> 103
    //   700: aconst_null
    //   701: astore 11
    //   703: goto -635 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	706	0	this	GroupIconHelper
    //   0	706	1	paramString1	String
    //   0	706	2	paramString2	String
    //   0	706	4	paramBoolean1	boolean
    //   0	706	5	paramBoolean2	boolean
    //   330	355	6	bool1	boolean
    //   265	201	7	bool2	boolean
    //   120	573	8	localObject	Object
    //   295	340	9	localArrayList	ArrayList
    //   80	361	10	str1	String
    //   66	636	11	str2	String
    //   253	355	12	localBitmap	Bitmap
    //   48	391	13	localQQAppInterface	QQAppInterface
    // Exception table:
    //   from	to	target	type
    //   234	267	284	java/lang/Throwable
    //   316	329	474	finally
    //   475	477	474	finally
    //   302	316	479	java/lang/Throwable
    //   477	479	479	java/lang/Throwable
    //   522	537	479	java/lang/Throwable
    //   537	549	479	java/lang/Throwable
    //   570	584	479	java/lang/Throwable
    //   584	601	479	java/lang/Throwable
    //   494	498	505	java/lang/Throwable
    //   555	563	563	java/lang/Throwable
    //   340	346	633	java/lang/Throwable
    //   352	432	633	java/lang/Throwable
    //   438	448	633	java/lang/Throwable
    //   607	620	633	java/lang/Throwable
    //   626	630	633	java/lang/Throwable
    //   452	456	640	java/lang/Throwable
    //   302	316	648	finally
    //   477	479	648	finally
    //   522	537	648	finally
    //   537	549	648	finally
    //   570	584	648	finally
    //   584	601	648	finally
    //   657	662	664	java/lang/Throwable
    //   340	346	672	finally
    //   352	432	672	finally
    //   438	448	672	finally
    //   607	620	672	finally
    //   626	630	672	finally
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
    if (this.jdField_b_of_type_Int < 3)
    {
      zlm localzlm = (zlm)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.poll();
      if (localzlm != null)
      {
        this.jdField_b_of_type_Int += 1;
        ThreadManager.post(localzlm, 10, null, true);
      }
    }
  }
  
  private void g(String paramString)
  {
    this.jdField_a_of_type_Zlo.removeMessages(9527, paramString);
    paramString = this.jdField_a_of_type_Zlo.obtainMessage(9527, paramString);
    this.jdField_a_of_type_Zlo.sendMessageDelayed(paramString, 300L);
  }
  
  /* Error */
  public Bitmap a(int paramInt, Bitmap[] paramArrayOfBitmap)
  {
    // Byte code:
    //   0: invokestatic 171	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   3: invokevirtual 179	com/tencent/common/app/BaseApplicationImpl:getResources	()Landroid/content/res/Resources;
    //   6: ldc_w 671
    //   9: invokestatic 677	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   12: astore 4
    //   14: iload_1
    //   15: aload_2
    //   16: aload 4
    //   18: fconst_1
    //   19: invokestatic 682	com/tencent/mobileqq/util/PuzzleAvatarUtil:a	(I[Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
    //   22: astore_2
    //   23: aload_2
    //   24: astore_3
    //   25: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   28: ifeq +38 -> 66
    //   31: aload_2
    //   32: astore_3
    //   33: aload_2
    //   34: ifnonnull +32 -> 66
    //   37: ldc 56
    //   39: iconst_2
    //   40: new 58	java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   47: ldc_w 684
    //   50: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: aload 4
    //   55: invokevirtual 687	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   58: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokestatic 276	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   64: aload_2
    //   65: astore_3
    //   66: aload_3
    //   67: areturn
    //   68: astore 4
    //   70: aconst_null
    //   71: astore_2
    //   72: aload_2
    //   73: astore_3
    //   74: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   77: ifeq -11 -> 66
    //   80: ldc 56
    //   82: iconst_2
    //   83: aload 4
    //   85: invokevirtual 688	java/lang/Exception:toString	()Ljava/lang/String;
    //   88: invokestatic 276	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   91: aload_2
    //   92: areturn
    //   93: astore 4
    //   95: aconst_null
    //   96: astore_2
    //   97: aload_2
    //   98: astore_3
    //   99: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   102: ifeq -36 -> 66
    //   105: ldc 56
    //   107: iconst_2
    //   108: aload 4
    //   110: invokevirtual 689	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   113: invokestatic 276	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   116: aload_2
    //   117: areturn
    //   118: astore 4
    //   120: aconst_null
    //   121: astore_2
    //   122: aload_2
    //   123: astore_3
    //   124: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   127: ifeq -61 -> 66
    //   130: ldc 56
    //   132: iconst_2
    //   133: aload 4
    //   135: invokevirtual 690	java/lang/Error:toString	()Ljava/lang/String;
    //   138: invokestatic 276	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   141: aload_2
    //   142: areturn
    //   143: astore 4
    //   145: goto -23 -> 122
    //   148: astore 4
    //   150: goto -53 -> 97
    //   153: astore 4
    //   155: goto -83 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	this	GroupIconHelper
    //   0	158	1	paramInt	int
    //   0	158	2	paramArrayOfBitmap	Bitmap[]
    //   24	100	3	arrayOfBitmap	Bitmap[]
    //   12	42	4	localBitmap	Bitmap
    //   68	16	4	localException1	java.lang.Exception
    //   93	16	4	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   118	16	4	localError1	java.lang.Error
    //   143	1	4	localError2	java.lang.Error
    //   148	1	4	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   153	1	4	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   0	23	68	java/lang/Exception
    //   0	23	93	java/lang/OutOfMemoryError
    //   0	23	118	java/lang/Error
    //   25	31	143	java/lang/Error
    //   37	64	143	java/lang/Error
    //   25	31	148	java/lang/OutOfMemoryError
    //   37	64	148	java/lang/OutOfMemoryError
    //   25	31	153	java/lang/Exception
    //   37	64	153	java/lang/Exception
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.dih", 2, "GroupIconHelper release.");
    }
    if (this.jdField_a_of_type_Zlk != null) {
      this.jdField_a_of_type_Zlk.jdField_a_of_type_Boolean = false;
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
          if ((localObject4 != null) && ((localObject4 instanceof zln)))
          {
            localObject4 = (zln)localObject4;
            if ((localObject4 != null) && (((zln)localObject4).jdField_a_of_type_Byte != 3) && ((this.jdField_a_of_type_ComTencentMobileqqAppBusinessHandler instanceof DiscussionHandler))) {
              ((DiscussionHandler)this.jdField_a_of_type_ComTencentMobileqqAppBusinessHandler).a(false, true, str);
            }
          }
        }
      }
    }
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    ??? = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)((QQAppInterface)???).getManager(10);
    if (localPhoneContactManagerImp != null) {
      localPhoneContactManagerImp.b(this);
    }
    ((QQAppInterface)???).removeObserver(this);
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
      a(new zlm(this, 1, paramString));
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
    if ((this.jdField_a_of_type_JavaUtilHashtable.containsKey(paramString)) && (l - ((Long)this.jdField_a_of_type_JavaUtilHashtable.get(paramString)).longValue() < this.c)) {
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
      a(new zlm(this, 3, paramString));
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
      localQQAppInterface.a(localQQAppInterface.a(1001, a(paramString), (byte)1, 0));
      a(str);
    }
  }
  
  public void f(String paramString)
  {
    ??? = PstnUtils.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramString, 3000);
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
      a(new zlm(this, 2, (String)paramMessage.obj));
    }
  }
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.dih", 2, "onUpdateCustomHead isSuccess | " + paramBoolean + ", uin=");
    }
    label414:
    label417:
    label420:
    label426:
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
          if ((localObject == null) || (!(localObject instanceof zln))) {
            break label420;
          }
          localObject = (zln)localObject;
          if ((localObject == null) || (((zln)localObject).jdField_a_of_type_JavaLangString == null)) {
            continue;
          }
          if (((zln)localObject).c)
          {
            str2 = ((zln)localObject).jdField_a_of_type_JavaLangString;
            if ((!paramBoolean) || (!str2.contains(paramString))) {
              break label417;
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.qqhead.dih", 2, "onUpdateCustomHead pstn: disUin=" + str1 + ", uin=" + paramString + ", faceUinSet=" + str2);
            }
            if (((zln)localObject).jdField_a_of_type_Byte != 3)
            {
              ((zln)localObject).jdField_a_of_type_JavaUtilArrayList.add(paramString);
              g(str1);
              break label426;
            }
            if (localArrayList != null) {
              break label414;
            }
            localArrayList = new ArrayList();
            localArrayList.add(str1);
            break label426;
          }
          if (((zln)localObject).jdField_a_of_type_Byte == 3) {
            continue;
          }
          String str2 = ((zln)localObject).jdField_a_of_type_JavaLangString;
          if ((!paramBoolean) || (!str2.contains(paramString))) {
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.qqhead.dih", 2, "onUpdateCustomHead: disUin=" + str1 + ", uin=" + paramString + ", faceUinSet=" + str2);
          }
          ((zln)localObject).jdField_a_of_type_JavaUtilArrayList.add(paramString);
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
      break label426;
      Object localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.GroupIconHelper
 * JD-Core Version:    0.7.0.1
 */