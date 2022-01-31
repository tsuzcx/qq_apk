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
import zbc;
import zbd;
import zbe;
import zbf;
import zbg;
import zbh;

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
  private zbd jdField_a_of_type_Zbd;
  private zbh jdField_a_of_type_Zbh;
  private int jdField_b_of_type_Int = 60000;
  private Set jdField_b_of_type_JavaUtilSet;
  private int c = 90000;
  
  public GroupIconHelper(String paramString, BusinessHandler paramBusinessHandler)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.dih", 2, "Create GroupIconHelper For [" + this.jdField_a_of_type_JavaLangString + "]");
    }
    paramString = paramBusinessHandler.b;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilHashtable = new Hashtable();
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_b_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_Zbh = new zbh(paramString.getApp().getMainLooper(), this, null);
    this.jdField_a_of_type_ComTencentMobileqqAppBusinessHandler = paramBusinessHandler;
    paramString.a(new zbe(this));
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
    return new zbc();
  }
  
  private zbg a(String paramString, boolean paramBoolean1, zbg paramzbg, boolean paramBoolean2)
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
      paramzbg.jdField_a_of_type_Int = 0;
      localObject3 = a((ArrayList)localObject1, paramBoolean2);
      paramzbg.jdField_a_of_type_JavaLangString = ((String)localObject3);
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
        paramzbg.jdField_a_of_type_Boolean = paramBoolean1;
        return paramzbg;
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
        paramzbg.jdField_a_of_type_Int = ((ArrayList)localObject1).size();
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
        } else if ((paramzbg.jdField_a_of_type_Byte == 2) && (localObject3 != null) && (!((String)localObject3).equals(paramzbg.jdField_b_of_type_JavaLangString)) && (paramzbg.e)) {
          paramBoolean1 = true;
        } else {
          paramBoolean1 = false;
        }
      }
    }
  }
  
  private void a(String paramString, zbg paramzbg, boolean paramBoolean)
  {
    Object localObject1 = null;
    if (paramzbg.jdField_a_of_type_Byte == 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqhead.dih", 2, "CreateIcon created: " + paramString + ", iconCount=" + paramzbg.jdField_a_of_type_JavaUtilArrayList.size() + ", totalCount=" + paramzbg.jdField_a_of_type_Int);
      }
      return;
    }
    Object localObject3 = b(paramzbg.jdField_a_of_type_JavaLangString, paramString, paramzbg.jdField_a_of_type_JavaUtilArrayList, paramzbg.c, paramzbg.d);
    boolean bool1 = ((Boolean)((Pair)localObject3).first).booleanValue();
    Object localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    boolean bool2 = ((Boolean)((Pair)localObject3).second).booleanValue();
    if (bool1)
    {
      paramzbg.jdField_b_of_type_Int += 1;
      localObject3 = a(paramzbg.jdField_a_of_type_JavaUtilArrayList, paramBoolean);
      paramzbg.jdField_b_of_type_JavaLangString = ((String)localObject3);
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
        if ((paramzbg.jdField_a_of_type_JavaUtilArrayList.size() >= paramzbg.jdField_a_of_type_Int) && (bool2)) {
          paramzbg.jdField_a_of_type_Byte = 3;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqAppBusinessHandler instanceof DiscussionHandler)) {
          if (paramzbg.c) {
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
          QLog.d("Q.qqhead.dih", 2, "CreateIcon Done: uin=" + paramString + ", name=" + (String)localObject2 + ", isComplete=" + bool2 + ", newFaceUinSet=" + (String)localObject3 + paramzbg.toString());
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
        QLog.d("Q.qqhead.dih", 2, "CreateIcon fail: " + paramString + ", iconCount=" + paramzbg.jdField_a_of_type_JavaUtilArrayList.size() + ", totalCount=" + paramzbg.jdField_a_of_type_Int);
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
        zbg localzbg;
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))
        {
          localzbg = (zbg)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
          if (localzbg.jdField_a_of_type_Byte == 3)
          {
            bool = true;
            if (((!bool) && (l - localzbg.jdField_a_of_type_Long < this.c)) || ((bool) && (!paramBoolean) && (l - localzbg.jdField_a_of_type_Long < 3600000L)))
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.qqhead.dih", 2, "putDiscussionIconInfo notDo, disUin=" + paramString + ",isFromCreate=" + paramBoolean + ",isRealCreated=" + bool + ",startTime=" + localzbg.jdField_a_of_type_Long + ",state=" + localzbg.jdField_a_of_type_Byte);
              }
              return false;
            }
            if ((QLog.isColorLevel()) && (!bool)) {
              QLog.d("Q.qqhead.dih", 2, "putDiscussionIconInfo reset, disUin=" + paramString + ",isFromCreate=" + paramBoolean + ",isRealCreated=" + bool + ",state=" + localzbg.jdField_a_of_type_Byte);
            }
            localzbg.a(localzbg.jdField_a_of_type_Byte);
            if (a(paramString))
            {
              QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
              localzbg.c = true;
              localzbg.d = PstnUtils.a(localQQAppInterface, b(paramString), 3000);
            }
            localzbg.jdField_a_of_type_Long = l;
            this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localzbg);
            return true;
          }
        }
        else
        {
          localzbg = new zbg(this, null);
          this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localzbg);
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
    //   5: invokestatic 151	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   8: iconst_0
    //   9: invokestatic 151	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   12: invokestatic 157	android/util/Pair:create	(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;
    //   15: astore_2
    //   16: aload_2
    //   17: areturn
    //   18: aload_1
    //   19: ifnonnull +20 -> 39
    //   22: iload 5
    //   24: ifne +15 -> 39
    //   27: iconst_0
    //   28: invokestatic 151	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   31: iconst_0
    //   32: invokestatic 151	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   35: invokestatic 157	android/util/Pair:create	(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;
    //   38: areturn
    //   39: invokestatic 163	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   42: invokevirtual 167	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   45: checkcast 92	com/tencent/mobileqq/app/QQAppInterface
    //   48: astore 13
    //   50: iload 4
    //   52: ifne +644 -> 696
    //   55: aload 13
    //   57: aload_0
    //   58: getfield 134	com/tencent/mobileqq/app/GroupIconHelper:jdField_a_of_type_Int	I
    //   61: aload_2
    //   62: iconst_0
    //   63: invokevirtual 534	com/tencent/mobileqq/app/QQAppInterface:a	(ILjava/lang/String;I)Ljava/lang/String;
    //   66: astore 11
    //   68: aload 13
    //   70: aload_0
    //   71: getfield 134	com/tencent/mobileqq/app/GroupIconHelper:jdField_a_of_type_Int	I
    //   74: aload_2
    //   75: iconst_1
    //   76: iconst_0
    //   77: invokevirtual 537	com/tencent/mobileqq/app/QQAppInterface:a	(ILjava/lang/String;BI)Ljava/lang/String;
    //   80: astore 10
    //   82: iload 4
    //   84: ifeq +609 -> 693
    //   87: aload 13
    //   89: sipush 1001
    //   92: aload_2
    //   93: invokestatic 438	com/tencent/mobileqq/app/GroupIconHelper:a	(Ljava/lang/String;)Ljava/lang/String;
    //   96: iconst_1
    //   97: iconst_0
    //   98: invokevirtual 537	com/tencent/mobileqq/app/QQAppInterface:a	(ILjava/lang/String;BI)Ljava/lang/String;
    //   101: astore 10
    //   103: aload 11
    //   105: invokestatic 542	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   108: ifne +579 -> 687
    //   111: new 544	java/io/File
    //   114: dup
    //   115: aload 11
    //   117: invokespecial 546	java/io/File:<init>	(Ljava/lang/String;)V
    //   120: astore 8
    //   122: aload_1
    //   123: ifnull +111 -> 234
    //   126: aload_1
    //   127: invokevirtual 334	java/lang/String:trim	()Ljava/lang/String;
    //   130: invokevirtual 145	java/lang/String:length	()I
    //   133: ifgt +101 -> 234
    //   136: aload 8
    //   138: ifnull +25 -> 163
    //   141: aload 8
    //   143: invokevirtual 549	java/io/File:exists	()Z
    //   146: ifeq +17 -> 163
    //   149: aload 8
    //   151: invokevirtual 552	java/io/File:isFile	()Z
    //   154: ifeq +9 -> 163
    //   157: aload 8
    //   159: invokevirtual 555	java/io/File:delete	()Z
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
    //   181: getfield 134	com/tencent/mobileqq/app/GroupIconHelper:jdField_a_of_type_Int	I
    //   184: bipush 101
    //   186: if_icmpne +32 -> 218
    //   189: invokestatic 561	com/tencent/mobileqq/utils/ImageUtil:h	()Landroid/graphics/Bitmap;
    //   192: astore_1
    //   193: aload_1
    //   194: ifnull +12 -> 206
    //   197: aload 13
    //   199: aload 10
    //   201: aload_1
    //   202: iconst_2
    //   203: invokevirtual 564	com/tencent/mobileqq/app/QQAppInterface:a	(Ljava/lang/String;Landroid/graphics/Bitmap;B)V
    //   206: iconst_1
    //   207: invokestatic 151	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   210: iconst_1
    //   211: invokestatic 151	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   214: invokestatic 157	android/util/Pair:create	(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;
    //   217: areturn
    //   218: aload_0
    //   219: getfield 134	com/tencent/mobileqq/app/GroupIconHelper:jdField_a_of_type_Int	I
    //   222: bipush 113
    //   224: if_icmpne -31 -> 193
    //   227: invokestatic 567	com/tencent/mobileqq/utils/ImageUtil:f	()Landroid/graphics/Bitmap;
    //   230: astore_1
    //   231: goto -38 -> 193
    //   234: aload_0
    //   235: aload_1
    //   236: aload_2
    //   237: aload_3
    //   238: iload 4
    //   240: iload 5
    //   242: invokespecial 569	com/tencent/mobileqq/app/GroupIconHelper:a	(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;ZZ)Landroid/util/Pair;
    //   245: astore_3
    //   246: aload_3
    //   247: getfield 248	android/util/Pair:second	Ljava/lang/Object;
    //   250: checkcast 227	android/graphics/Bitmap
    //   253: astore 12
    //   255: aload_3
    //   256: getfield 233	android/util/Pair:first	Ljava/lang/Object;
    //   259: checkcast 147	java/lang/Boolean
    //   262: invokevirtual 236	java/lang/Boolean:booleanValue	()Z
    //   265: istore 7
    //   267: aload 12
    //   269: ifnonnull +25 -> 294
    //   272: iconst_0
    //   273: invokestatic 151	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   276: iconst_0
    //   277: invokestatic 151	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   280: invokestatic 157	android/util/Pair:create	(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;
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
    //   299: ifeq +217 -> 516
    //   302: aload_0
    //   303: getfield 88	com/tencent/mobileqq/app/GroupIconHelper:jdField_b_of_type_JavaUtilSet	Ljava/util/Set;
    //   306: ifnull +373 -> 679
    //   309: aload_0
    //   310: getfield 88	com/tencent/mobileqq/app/GroupIconHelper:jdField_b_of_type_JavaUtilSet	Ljava/util/Set;
    //   313: astore_3
    //   314: aload_3
    //   315: monitorenter
    //   316: aload_0
    //   317: getfield 88	com/tencent/mobileqq/app/GroupIconHelper:jdField_b_of_type_JavaUtilSet	Ljava/util/Set;
    //   320: aload_2
    //   321: invokeinterface 225 2 0
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
    //   340: invokestatic 572	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   343: ifeq +89 -> 432
    //   346: aload_3
    //   347: astore 9
    //   349: aload_3
    //   350: astore 8
    //   352: ldc 47
    //   354: iconst_4
    //   355: new 49	java/lang/StringBuilder
    //   358: dup
    //   359: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   362: ldc_w 574
    //   365: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: iload 6
    //   370: invokevirtual 201	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   373: ldc_w 576
    //   376: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: aload_2
    //   380: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: ldc_w 576
    //   386: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: aload_1
    //   390: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: ldc_w 576
    //   396: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: aload 11
    //   401: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   404: ldc_w 578
    //   407: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: iload 4
    //   412: invokevirtual 201	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   415: ldc_w 580
    //   418: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: iload 5
    //   423: invokevirtual 201	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   426: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   429: invokestatic 268	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   432: aload_3
    //   433: astore 9
    //   435: aload_3
    //   436: astore 8
    //   438: aload 13
    //   440: aload 10
    //   442: aload 12
    //   444: iconst_2
    //   445: invokevirtual 564	com/tencent/mobileqq/app/QQAppInterface:a	(Ljava/lang/String;Landroid/graphics/Bitmap;B)V
    //   448: aload_3
    //   449: ifnull +223 -> 672
    //   452: aload_3
    //   453: invokevirtual 585	java/io/BufferedOutputStream:close	()V
    //   456: iload 6
    //   458: istore 4
    //   460: iload 4
    //   462: invokestatic 151	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   465: iload 7
    //   467: invokestatic 151	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   470: invokestatic 157	android/util/Pair:create	(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;
    //   473: areturn
    //   474: astore_1
    //   475: aload_3
    //   476: monitorexit
    //   477: aload_1
    //   478: athrow
    //   479: astore_1
    //   480: iconst_0
    //   481: istore 5
    //   483: iload 5
    //   485: istore 4
    //   487: aload 9
    //   489: ifnull -29 -> 460
    //   492: aload 9
    //   494: invokevirtual 585	java/io/BufferedOutputStream:close	()V
    //   497: iload 5
    //   499: istore 4
    //   501: goto -41 -> 460
    //   504: astore_1
    //   505: aload_1
    //   506: invokevirtual 588	java/lang/Throwable:printStackTrace	()V
    //   509: iload 5
    //   511: istore 4
    //   513: goto -53 -> 460
    //   516: aload 8
    //   518: ifnonnull +51 -> 569
    //   521: invokestatic 45	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   524: ifeq +12 -> 536
    //   527: ldc 47
    //   529: iconst_2
    //   530: ldc_w 590
    //   533: invokestatic 268	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   536: iconst_0
    //   537: invokestatic 151	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   540: iconst_0
    //   541: invokestatic 151	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   544: invokestatic 157	android/util/Pair:create	(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;
    //   547: astore_1
    //   548: aload_1
    //   549: astore_2
    //   550: iconst_0
    //   551: ifeq -535 -> 16
    //   554: new 592	java/lang/NullPointerException
    //   557: dup
    //   558: invokespecial 593	java/lang/NullPointerException:<init>	()V
    //   561: athrow
    //   562: astore_2
    //   563: aload_2
    //   564: invokevirtual 588	java/lang/Throwable:printStackTrace	()V
    //   567: aload_1
    //   568: areturn
    //   569: aload 8
    //   571: invokevirtual 549	java/io/File:exists	()Z
    //   574: ifne +9 -> 583
    //   577: aload 8
    //   579: invokevirtual 596	java/io/File:createNewFile	()Z
    //   582: pop
    //   583: new 582	java/io/BufferedOutputStream
    //   586: dup
    //   587: new 598	java/io/FileOutputStream
    //   590: dup
    //   591: aload 8
    //   593: invokespecial 601	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   596: invokespecial 604	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   599: astore_3
    //   600: aload_3
    //   601: astore 9
    //   603: aload_3
    //   604: astore 8
    //   606: aload 12
    //   608: getstatic 610	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   611: bipush 90
    //   613: aload_3
    //   614: invokevirtual 614	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   617: istore 6
    //   619: aload_3
    //   620: astore 9
    //   622: aload_3
    //   623: astore 8
    //   625: aload_3
    //   626: invokevirtual 617	java/io/BufferedOutputStream:flush	()V
    //   629: goto -295 -> 334
    //   632: astore_1
    //   633: goto -153 -> 480
    //   636: astore_1
    //   637: aload_1
    //   638: invokevirtual 588	java/lang/Throwable:printStackTrace	()V
    //   641: goto -185 -> 456
    //   644: astore_1
    //   645: aconst_null
    //   646: astore 8
    //   648: aload 8
    //   650: ifnull +8 -> 658
    //   653: aload 8
    //   655: invokevirtual 585	java/io/BufferedOutputStream:close	()V
    //   658: aload_1
    //   659: athrow
    //   660: astore_2
    //   661: aload_2
    //   662: invokevirtual 588	java/lang/Throwable:printStackTrace	()V
    //   665: goto -7 -> 658
    //   668: astore_1
    //   669: goto -21 -> 648
    //   672: iload 6
    //   674: istore 4
    //   676: goto -216 -> 460
    //   679: iconst_1
    //   680: istore 6
    //   682: aconst_null
    //   683: astore_3
    //   684: goto -350 -> 334
    //   687: aconst_null
    //   688: astore 8
    //   690: goto -568 -> 122
    //   693: goto -590 -> 103
    //   696: aconst_null
    //   697: astore 11
    //   699: goto -631 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	702	0	this	GroupIconHelper
    //   0	702	1	paramString1	String
    //   0	702	2	paramString2	String
    //   0	702	4	paramBoolean1	boolean
    //   0	702	5	paramBoolean2	boolean
    //   330	351	6	bool1	boolean
    //   265	201	7	bool2	boolean
    //   120	569	8	localObject	Object
    //   295	326	9	localArrayList	ArrayList
    //   80	361	10	str1	String
    //   66	632	11	str2	String
    //   253	354	12	localBitmap	Bitmap
    //   48	391	13	localQQAppInterface	QQAppInterface
    // Exception table:
    //   from	to	target	type
    //   234	267	284	java/lang/Throwable
    //   316	329	474	finally
    //   475	477	474	finally
    //   302	316	479	java/lang/Throwable
    //   477	479	479	java/lang/Throwable
    //   521	536	479	java/lang/Throwable
    //   536	548	479	java/lang/Throwable
    //   569	583	479	java/lang/Throwable
    //   583	600	479	java/lang/Throwable
    //   492	497	504	java/lang/Throwable
    //   554	562	562	java/lang/Throwable
    //   340	346	632	java/lang/Throwable
    //   352	432	632	java/lang/Throwable
    //   438	448	632	java/lang/Throwable
    //   606	619	632	java/lang/Throwable
    //   625	629	632	java/lang/Throwable
    //   452	456	636	java/lang/Throwable
    //   302	316	644	finally
    //   477	479	644	finally
    //   521	536	644	finally
    //   536	548	644	finally
    //   569	583	644	finally
    //   583	600	644	finally
    //   653	658	660	java/lang/Throwable
    //   340	346	668	finally
    //   352	432	668	finally
    //   438	448	668	finally
    //   606	619	668	finally
    //   625	629	668	finally
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
  
  private void g(String paramString)
  {
    this.jdField_a_of_type_Zbh.removeMessages(9527, paramString);
    paramString = this.jdField_a_of_type_Zbh.obtainMessage(9527, paramString);
    this.jdField_a_of_type_Zbh.sendMessageDelayed(paramString, 300L);
  }
  
  /* Error */
  public Bitmap a(int paramInt, Bitmap[] paramArrayOfBitmap)
  {
    // Byte code:
    //   0: invokestatic 163	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   3: invokevirtual 171	com/tencent/common/app/BaseApplicationImpl:getResources	()Landroid/content/res/Resources;
    //   6: ldc_w 646
    //   9: invokestatic 652	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   12: astore 4
    //   14: iload_1
    //   15: aload_2
    //   16: aload 4
    //   18: fconst_1
    //   19: invokestatic 657	com/tencent/mobileqq/util/PuzzleAvatarUtil:a	(I[Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
    //   22: astore_2
    //   23: aload_2
    //   24: astore_3
    //   25: invokestatic 45	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   28: ifeq +38 -> 66
    //   31: aload_2
    //   32: astore_3
    //   33: aload_2
    //   34: ifnonnull +32 -> 66
    //   37: ldc 47
    //   39: iconst_2
    //   40: new 49	java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   47: ldc_w 659
    //   50: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: aload 4
    //   55: invokevirtual 662	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   58: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokestatic 268	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   64: aload_2
    //   65: astore_3
    //   66: aload_3
    //   67: areturn
    //   68: astore 4
    //   70: aconst_null
    //   71: astore_2
    //   72: aload_2
    //   73: astore_3
    //   74: invokestatic 45	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   77: ifeq -11 -> 66
    //   80: ldc 47
    //   82: iconst_2
    //   83: aload 4
    //   85: invokevirtual 663	java/lang/Exception:toString	()Ljava/lang/String;
    //   88: invokestatic 268	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   91: aload_2
    //   92: areturn
    //   93: astore 4
    //   95: aconst_null
    //   96: astore_2
    //   97: aload_2
    //   98: astore_3
    //   99: invokestatic 45	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   102: ifeq -36 -> 66
    //   105: ldc 47
    //   107: iconst_2
    //   108: aload 4
    //   110: invokevirtual 664	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   113: invokestatic 268	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   116: aload_2
    //   117: areturn
    //   118: astore 4
    //   120: aconst_null
    //   121: astore_2
    //   122: aload_2
    //   123: astore_3
    //   124: invokestatic 45	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   127: ifeq -61 -> 66
    //   130: ldc 47
    //   132: iconst_2
    //   133: aload 4
    //   135: invokevirtual 665	java/lang/Error:toString	()Ljava/lang/String;
    //   138: invokestatic 268	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
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
    if (this.jdField_a_of_type_Zbd != null) {
      this.jdField_a_of_type_Zbd.jdField_a_of_type_Boolean = false;
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
          if ((localObject4 != null) && ((localObject4 instanceof zbg)))
          {
            localObject4 = (zbg)localObject4;
            if ((localObject4 != null) && (((zbg)localObject4).jdField_a_of_type_Byte != 3) && ((this.jdField_a_of_type_ComTencentMobileqqAppBusinessHandler instanceof DiscussionHandler))) {
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
      ThreadManager.post(new zbf(this, 1, paramString), 10, null, true);
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
      ThreadManager.post(new zbf(this, 3, paramString), 10, null, true);
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
    default: 
      return true;
    }
    ThreadManager.post(new zbf(this, 2, (String)paramMessage.obj), 10, null, true);
    return true;
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
          if ((localObject == null) || (!(localObject instanceof zbg))) {
            break label420;
          }
          localObject = (zbg)localObject;
          if ((localObject == null) || (((zbg)localObject).jdField_a_of_type_JavaLangString == null)) {
            continue;
          }
          if (((zbg)localObject).c)
          {
            str2 = ((zbg)localObject).jdField_a_of_type_JavaLangString;
            if ((!paramBoolean) || (!str2.contains(paramString))) {
              break label417;
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.qqhead.dih", 2, "onUpdateCustomHead pstn: disUin=" + str1 + ", uin=" + paramString + ", faceUinSet=" + str2);
            }
            if (((zbg)localObject).jdField_a_of_type_Byte != 3)
            {
              ((zbg)localObject).jdField_a_of_type_JavaUtilArrayList.add(paramString);
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
          if (((zbg)localObject).jdField_a_of_type_Byte == 3) {
            continue;
          }
          String str2 = ((zbg)localObject).jdField_a_of_type_JavaLangString;
          if ((!paramBoolean) || (!str2.contains(paramString))) {
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.qqhead.dih", 2, "onUpdateCustomHead: disUin=" + str1 + ", uin=" + paramString + ", faceUinSet=" + str2);
          }
          ((zbg)localObject).jdField_a_of_type_JavaUtilArrayList.add(paramString);
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