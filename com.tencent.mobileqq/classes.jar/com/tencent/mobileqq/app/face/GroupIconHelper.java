package com.tencent.mobileqq.app.face;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import com.tencent.av.utils.PstnUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.avatar.handler.DiscussionAvatarHandler;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.avatar.utils.AvatarUtil;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.listener.IPhoneContactListener;
import com.tencent.mobileqq.troop.api.handler.ITroopAvatarHandler;
import com.tencent.mobileqq.troop.api.handler.ITroopMemberListHandler;
import com.tencent.mobileqq.troop.api.observer.TroopAvatarObserver;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.util.PuzzleAvatarUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
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

public class GroupIconHelper
  extends AvatarObserver
  implements Handler.Callback, IPhoneContactListener
{
  private static boolean jdField_a_of_type_Boolean;
  int jdField_a_of_type_Int;
  private BusinessHandler jdField_a_of_type_ComTencentMobileqqAppBusinessHandler;
  private GroupIconHelper.CheckDisIconThread jdField_a_of_type_ComTencentMobileqqAppFaceGroupIconHelper$CheckDisIconThread = null;
  private GroupIconHelper.WeakReferHandler jdField_a_of_type_ComTencentMobileqqAppFaceGroupIconHelper$WeakReferHandler;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString;
  private HashMap<String, GroupIconHelper.GroupIconInfo> jdField_a_of_type_JavaUtilHashMap;
  private Hashtable<String, Long> jdField_a_of_type_JavaUtilHashtable;
  private Set<String> jdField_a_of_type_JavaUtilSet;
  ConcurrentLinkedQueue<GroupIconHelper.GenerateIconRunner> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private int jdField_b_of_type_Int = 60000;
  private Set<String> jdField_b_of_type_JavaUtilSet;
  private int c = 90000;
  
  public GroupIconHelper(String paramString, BusinessHandler paramBusinessHandler)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("Create GroupIconHelper For [");
      paramString.append(this.jdField_a_of_type_JavaLangString);
      paramString.append("]");
      QLog.d("Q.qqhead.dih", 2, paramString.toString());
    }
    paramString = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilHashtable = new Hashtable();
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_b_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_ComTencentMobileqqAppFaceGroupIconHelper$WeakReferHandler = new GroupIconHelper.WeakReferHandler(paramString.getApp().getMainLooper(), this, null);
    this.jdField_a_of_type_ComTencentMobileqqAppBusinessHandler = paramBusinessHandler;
    paramString.execute(new GroupIconHelper.CheckIsLowPerformanceMachineRunner(this));
    ThreadManagerV2.executeOnSubThread(new GroupIconHelper.1(this, paramString));
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBusinessHandler instanceof DiscussionHandler))
    {
      this.jdField_a_of_type_Int = 101;
      return;
    }
    this.jdField_a_of_type_Int = 113;
  }
  
  private Pair<Boolean, Bitmap> a(String arg1, String paramString2, ArrayList<String> paramArrayList, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject3 = null;
    int i;
    if ((??? != null) && (???.length() > 1))
    {
      i = 0;
    }
    else
    {
      if (!paramBoolean2) {
        return Pair.create(Boolean.valueOf(false), null);
      }
      i = 1;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    float f2 = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().density;
    float f1 = f2;
    if (f2 < 1.0F) {
      f1 = 1.0F;
    }
    double d = 50.0F * f1;
    Double.isNaN(d);
    int k = (int)(d + 0.5D);
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("createDiscussionIcon density=");
      ((StringBuilder)localObject1).append(f1);
      ((StringBuilder)localObject1).append(";imageWidth=");
      ((StringBuilder)localObject1).append(k);
      ((StringBuilder)localObject1).append(",hasPstnIcon: ");
      ((StringBuilder)localObject1).append(paramBoolean1);
      ((StringBuilder)localObject1).append(", hasRealPhoneUser: ");
      ((StringBuilder)localObject1).append(paramBoolean2);
      QLog.d("Q.qqhead.dih", 2, ((StringBuilder)localObject1).toString());
    }
    if (i == 0) {
      localObject1 = ???.split(";");
    } else {
      localObject1 = null;
    }
    if (localObject1 != null)
    {
      if (localObject1.length > 4) {
        i = 4;
      } else {
        i = localObject1.length;
      }
    }
    else {
      i = 0;
    }
    if ((i < 4) && (paramBoolean1))
    {
      localObject2 = PstnUtils.a(localQQAppInterface, paramString2, 3000, 4 - i);
      ??? = (String)localObject2;
      if (localObject2 != null)
      {
        ??? = (String)localObject2;
        if (((List)localObject2).size() > 0)
        {
          j = ((List)localObject2).size() + i;
          synchronized (this.jdField_a_of_type_JavaUtilSet)
          {
            this.jdField_a_of_type_JavaUtilSet.add(paramString2);
            ??? = (String)localObject2;
          }
        }
      }
    }
    else
    {
      ??? = null;
    }
    int j = i;
    Object localObject2 = new Bitmap[j];
    j = 0;
    paramBoolean1 = true;
    while (j < i)
    {
      String str = localObject1[j];
      Pair localPair = localQQAppInterface.getScaledFaceBitmap(str, (byte)5, 0, 0);
      if (!((Boolean)localPair.first).booleanValue())
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getScaledFaceBitmap fail, disUin=");
          localStringBuilder.append(paramString2);
          localStringBuilder.append(", uin=");
          localStringBuilder.append(str);
          QLog.d("Q.qqhead.dih", 2, localStringBuilder.toString());
        }
        paramArrayList.remove(str);
        paramBoolean1 = false;
      }
      localObject2[j] = ((Bitmap)localPair.second);
      j += 1;
    }
    if ((??? != null) && (???.size() > 0))
    {
      j = 0;
      while (j < ???.size())
      {
        localObject2[(j + i)] = ((Bitmap)???.get(j));
        j += 1;
      }
    }
    try
    {
      ??? = a(k, (Bitmap[])localObject2);
    }
    catch (Throwable ???)
    {
      if (QLog.isColorLevel())
      {
        paramArrayList = new StringBuilder();
        paramArrayList.append("createDiscussionIcon fail, disUin=");
        paramArrayList.append(paramString2);
        paramArrayList.append(", throwable : ");
        paramArrayList.append(???.toString());
        QLog.d("Q.qqhead.dih", 2, paramArrayList.toString());
      }
      paramBoolean1 = false;
      ??? = localObject3;
    }
    return Pair.create(Boolean.valueOf(paramBoolean1), ???);
  }
  
  private Pair<Boolean, Boolean> a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString3, QQAppInterface paramQQAppInterface, byte paramByte, String paramString4, File arg10, boolean paramBoolean4, Bitmap paramBitmap)
  {
    localObject = paramBitmap;
    boolean bool = false;
    if (paramBoolean1) {}
    for (;;)
    {
      try
      {
        if (this.jdField_b_of_type_JavaUtilSet == null) {
          continue;
        }
        synchronized (this.jdField_b_of_type_JavaUtilSet)
        {
          this.jdField_b_of_type_JavaUtilSet.add(paramString2);
        }
        if (??? == null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.qqhead.dih", 2, "createAndSaveDiscussionIcon2File | file is null ");
          }
          return Pair.create(Boolean.valueOf(paramBoolean3), Boolean.valueOf(false));
        }
        if (!???.exists()) {
          ???.createNewFile();
        }
        ??? = new BufferedOutputStream(new FileOutputStream(???));
        paramBitmap = ???;
        localFile = ???;
      }
      catch (Throwable paramString1)
      {
        continue;
        ??? = null;
        paramBoolean3 = true;
        continue;
      }
      finally
      {
        paramBitmap = null;
        continue;
        File localFile = null;
        continue;
        localObject = paramString1;
        continue;
        continue;
      }
      try
      {
        try
        {
          paramBoolean3 = ((Bitmap)localObject).compress(Bitmap.CompressFormat.PNG, 90, ???);
          paramBitmap = ???;
          localFile = ???;
          ???.flush();
          paramBitmap = ???;
          localFile = ???;
          if (QLog.isDevelopLevel())
          {
            paramBitmap = ???;
            localFile = ???;
            StringBuilder localStringBuilder = new StringBuilder();
            paramBitmap = ???;
            localFile = ???;
            localStringBuilder.append("createAndSaveDiscussionIcon2File,[");
            paramBitmap = ???;
            localFile = ???;
            localStringBuilder.append(paramBoolean3);
            paramBitmap = ???;
            localFile = ???;
            localStringBuilder.append(",");
            paramBitmap = ???;
            localFile = ???;
            localStringBuilder.append(paramString2);
            paramBitmap = ???;
            localFile = ???;
            localStringBuilder.append(",");
            paramBitmap = ???;
            localFile = ???;
            localStringBuilder.append(paramString1);
            paramBitmap = ???;
            localFile = ???;
            localStringBuilder.append(",");
            paramBitmap = ???;
            localFile = ???;
            localStringBuilder.append(paramString3);
            paramBitmap = ???;
            localFile = ???;
            localStringBuilder.append("],hasPstnIcon | ");
            paramBitmap = ???;
            localFile = ???;
            localStringBuilder.append(paramBoolean1);
            paramBitmap = ???;
            localFile = ???;
            localStringBuilder.append(",hasRealPstnUser: ");
            paramBitmap = ???;
            localFile = ???;
            localStringBuilder.append(paramBoolean2);
            paramBitmap = ???;
            localFile = ???;
            QLog.i("Q.qqhead.dih", 4, localStringBuilder.toString());
          }
          if (paramByte == 3)
          {
            paramBitmap = ???;
            localFile = ???;
            paramString1 = QQAppInterface.getCircleFaceBitmap((Bitmap)localObject, 50, 50);
          }
          else
          {
            if (paramByte != 1) {
              continue;
            }
            paramBitmap = ???;
            localFile = ???;
            paramString1 = QQAppInterface.getShapeRoundFaceBitmap((Bitmap)localObject, 10, 50, 50);
          }
        }
        finally
        {
          continue;
        }
        paramBitmap = ???;
        localFile = ???;
        paramQQAppInterface.putBitmapToCache(paramString4, (Bitmap)localObject, (byte)2);
        if (??? != null) {
          try
          {
            ???.close();
          }
          catch (Throwable paramString1)
          {
            paramString1.printStackTrace();
          }
        }
        paramBoolean1 = paramBoolean3;
      }
      catch (Throwable paramString1) {}
    }
    break label520;
    if (paramBitmap != null) {
      try
      {
        paramBitmap.close();
      }
      catch (Throwable paramString2)
      {
        paramString2.printStackTrace();
      }
    }
    throw paramString1;
    label520:
    paramBoolean1 = bool;
    if (localFile != null) {
      try
      {
        localFile.close();
        paramBoolean1 = bool;
      }
      catch (Throwable paramString1)
      {
        paramString1.printStackTrace();
        paramBoolean1 = bool;
      }
    }
    return Pair.create(Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean4));
  }
  
  private GroupIconHelper.GroupIconInfo a(String paramString, boolean paramBoolean1, GroupIconHelper.GroupIconInfo paramGroupIconInfo, boolean paramBoolean2)
  {
    return a(paramString, paramBoolean1, paramGroupIconInfo, paramBoolean2, true);
  }
  
  private GroupIconHelper.GroupIconInfo a(String paramString, boolean paramBoolean1, GroupIconHelper.GroupIconInfo paramGroupIconInfo, boolean paramBoolean2, boolean paramBoolean3)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Object localObject2;
    if (this.jdField_a_of_type_Int == 101)
    {
      localObject1 = ((DiscussionManager)localQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).b(paramString);
    }
    else
    {
      localObject2 = (TroopManager)localQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      localObject1 = ((TroopManager)localObject2).a(paramString);
      localObject2 = ((TroopManager)localObject2).c(paramString);
      if ((localObject2 != null) && (((ArrayList)localObject1).size() == 0)) {
        if (!paramBoolean3) {
          ((ArrayList)localObject1).add(localQQAppInterface.getCurrentUin());
        } else if (((TroopInfo)localObject2).wMemberNum > 1) {
          ((ITroopMemberListHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_LIST_HANDLER)).a(Long.parseLong(paramString));
        }
      }
    }
    if (QLog.isColorLevel()) {
      if ((localObject1 != null) && (((ArrayList)localObject1).size() != 0))
      {
        localObject2 = new StringBuilder();
        Object localObject3 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          String str = (String)((Iterator)localObject3).next();
          if ((str != null) && (str.length() > 5)) {
            ((StringBuilder)localObject2).append(str.substring(0, 4));
          } else {
            ((StringBuilder)localObject2).append(str);
          }
          ((StringBuilder)localObject2).append(";");
        }
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("discussionUin=");
        ((StringBuilder)localObject3).append(paramString);
        ((StringBuilder)localObject3).append(" memberUinList is:");
        ((StringBuilder)localObject3).append(((StringBuilder)localObject2).toString());
        QLog.d("Q.qqhead.dih", 2, ((StringBuilder)localObject3).toString());
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("discussionUin=");
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append(" memberUinList is empty...");
        QLog.d("Q.qqhead.dih", 2, ((StringBuilder)localObject2).toString());
      }
    }
    if ((localObject1 != null) && (((ArrayList)localObject1).size() != 0)) {
      paramGroupIconInfo.jdField_a_of_type_Int = ((ArrayList)localObject1).size();
    } else {
      paramGroupIconInfo.jdField_a_of_type_Int = 0;
    }
    Object localObject1 = a((ArrayList)localObject1, paramBoolean2);
    paramGroupIconInfo.jdField_a_of_type_JavaLangString = ((String)localObject1);
    a(paramString, paramBoolean1, paramGroupIconInfo, localQQAppInterface, (String)localObject1);
    return paramGroupIconInfo;
  }
  
  public static String a(String paramString)
  {
    if ((paramString != null) && (paramString.length() != 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("_");
      localStringBuilder.append(1001);
      return localStringBuilder.toString();
    }
    QLog.i("Q.qqhead.dih", 1, "===getPstnDiscussionUin discussionUin is null ===");
    return null;
  }
  
  public static String a(ArrayList<String> paramArrayList, boolean paramBoolean)
  {
    StringBuilder localStringBuilder;
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      localStringBuilder = new StringBuilder(128);
      paramArrayList = (ArrayList)paramArrayList.clone();
      String[] arrayOfString = new String[paramArrayList.size()];
      int k = 0;
      int i = 0;
      while (i < arrayOfString.length)
      {
        arrayOfString[i] = ((String)paramArrayList.get(i));
        i += 1;
      }
      Arrays.sort(arrayOfString, a());
      int j = 0;
      i = k;
      while (i < arrayOfString.length)
      {
        localStringBuilder.append(arrayOfString[i]);
        localStringBuilder.append(";");
        j += 1;
        if (((paramBoolean) && (a()) && (j >= 4)) || (j >= 4)) {
          break;
        }
        i += 1;
      }
      paramArrayList = localStringBuilder.toString();
    }
    else
    {
      paramArrayList = " ";
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("createFaceUinSet, ret=");
      localStringBuilder.append(paramArrayList);
      localStringBuilder.append(",sureChanged=");
      localStringBuilder.append(paramBoolean);
      QLog.d("Q.qqhead.dih", 2, localStringBuilder.toString());
    }
    return paramArrayList;
  }
  
  public static ArrayList<String> a(ArrayList<String> paramArrayList)
  {
    if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      ArrayList localArrayList = (ArrayList)paramArrayList.clone();
      int i = paramArrayList.size();
      paramArrayList = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      if (i <= 4)
      {
        if (!localArrayList.contains(paramArrayList)) {
          localArrayList.add(paramArrayList);
        }
      }
      else {
        localArrayList.remove(paramArrayList);
      }
      if (QLog.isColorLevel())
      {
        paramArrayList = new StringBuilder();
        paramArrayList.append("handleNewGroupSecHeadUins, memberUinSize=");
        paramArrayList.append(localArrayList.size());
        QLog.d("Q.qqhead.dih", 2, paramArrayList.toString());
      }
      return localArrayList;
    }
    QLog.d("Q.qqhead.dih", 2, "handleDiscussionSecHeadUins memberUinList is null");
    return paramArrayList;
  }
  
  public static ArrayList<String> a(ArrayList<String> paramArrayList, TroopInfo paramTroopInfo)
  {
    if ((paramArrayList != null) && (!paramArrayList.isEmpty()) && (paramTroopInfo != null))
    {
      if (paramTroopInfo == null)
      {
        QLog.d("Q.qqhead.dih", 2, "handleNewGroupSecHeadUins troopInfo is null");
        return paramArrayList;
      }
      paramArrayList = (ArrayList)paramArrayList.clone();
      Object localObject = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      TroopUtils.a(paramArrayList);
      if (paramTroopInfo.wMemberNumClient <= 4)
      {
        if (!paramArrayList.contains(localObject)) {
          paramArrayList.add(localObject);
        }
      }
      else {
        paramArrayList.remove(localObject);
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleNewGroupSecHeadUins, discussionUin=");
        ((StringBuilder)localObject).append(paramTroopInfo.troopuin);
        ((StringBuilder)localObject).append(",NumClient=");
        ((StringBuilder)localObject).append(paramTroopInfo.wMemberNumClient);
        ((StringBuilder)localObject).append(",memberUinSize=");
        ((StringBuilder)localObject).append(paramArrayList);
        QLog.d("Q.qqhead.dih", 2, ((StringBuilder)localObject).toString());
      }
      return paramArrayList;
    }
    QLog.d("Q.qqhead.dih", 2, "handleNewGroupSecHeadUins memberUinList is null");
    return paramArrayList;
  }
  
  public static Comparator<String> a()
  {
    return new GroupIconHelper.2();
  }
  
  private void a(GroupIconHelper.GenerateIconRunner paramGenerateIconRunner)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.offer(paramGenerateIconRunner);
    b();
  }
  
  private void a(String paramString, GroupIconHelper.GroupIconInfo paramGroupIconInfo, boolean paramBoolean)
  {
    if (paramGroupIconInfo.jdField_a_of_type_Byte == 3)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("CreateIcon created: ");
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append(", iconCount=");
        ((StringBuilder)localObject1).append(paramGroupIconInfo.jdField_a_of_type_JavaUtilArrayList.size());
        ((StringBuilder)localObject1).append(", totalCount=");
        ((StringBuilder)localObject1).append(paramGroupIconInfo.jdField_a_of_type_Int);
        QLog.d("Q.qqhead.dih", 2, ((StringBuilder)localObject1).toString());
      }
      return;
    }
    Object localObject1 = b(paramGroupIconInfo.jdField_a_of_type_JavaLangString, paramString, paramGroupIconInfo.jdField_a_of_type_JavaUtilArrayList, paramGroupIconInfo.c, paramGroupIconInfo.d);
    boolean bool1 = ((Boolean)((Pair)localObject1).first).booleanValue();
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    boolean bool2 = ((Boolean)((Pair)localObject1).second).booleanValue();
    if (bool1)
    {
      paramGroupIconInfo.jdField_b_of_type_Int += 1;
      String str = a(paramGroupIconInfo.jdField_a_of_type_JavaUtilArrayList, paramBoolean);
      paramGroupIconInfo.jdField_b_of_type_JavaLangString = str;
      int i = this.jdField_a_of_type_Int;
      Object localObject3 = null;
      if (i == 101)
      {
        localObject1 = (DiscussionManager)localQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
        if (localObject1 != null) {
          localObject2 = ((DiscussionManager)localObject1).a(paramString);
        } else {
          localObject2 = null;
        }
        localObject1 = localObject3;
        if (localObject2 != null)
        {
          ((DiscussionInfo)localObject2).faceUinSet = str;
          localObject1 = localQQAppInterface.getEntityManagerFactory().createEntityManager();
          ((EntityManager)localObject1).update((Entity)localObject2);
          ((EntityManager)localObject1).close();
          localObject1 = localObject3;
          if (QLog.isColorLevel()) {
            localObject1 = ((DiscussionInfo)localObject2).discussionName;
          }
        }
      }
      else
      {
        localObject2 = (TroopManager)localQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        TroopInfo localTroopInfo = ((TroopManager)localObject2).c(paramString);
        localObject1 = localObject3;
        if (localTroopInfo != null)
        {
          localTroopInfo.mHeaderUinsOld = str;
          ((TroopManager)localObject2).b(localTroopInfo);
          localObject1 = localTroopInfo.getTroopDisplayName();
        }
      }
      if ((paramGroupIconInfo.jdField_a_of_type_JavaUtilArrayList.size() >= paramGroupIconInfo.jdField_a_of_type_Int) && (bool2)) {
        paramGroupIconInfo.jdField_a_of_type_Byte = 3;
      }
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppBusinessHandler;
      if ((localObject2 instanceof DiscussionHandler))
      {
        if (paramGroupIconInfo.c)
        {
          ((DiscussionHandler)this.jdField_a_of_type_ComTencentMobileqqAppBusinessHandler).a(bool1, bool2, a(paramString));
          ((DiscussionAvatarHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_AVATAR_HANDLER)).a(bool1, bool2, a(paramString));
        }
        else
        {
          ((DiscussionHandler)this.jdField_a_of_type_ComTencentMobileqqAppBusinessHandler).a(bool1, bool2, paramString);
          ((DiscussionAvatarHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_AVATAR_HANDLER)).a(bool1, bool2, paramString);
          localQQAppInterface.sendQQHeadBroadcast(101, paramString, 0, localQQAppInterface.getCustomFaceFilePath(101, paramString, 0));
        }
      }
      else if ((localObject2 instanceof ITroopAvatarHandler))
      {
        localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_AVATAR_HANDLER).notifyUI(TroopAvatarObserver.TYPE_NOTIFY_GET_NEW_TROOP_HEAD, bool1, Pair.create(Boolean.valueOf(bool2), paramString));
        localQQAppInterface.sendQQHeadBroadcast(113, paramString, 0, localQQAppInterface.getCustomFaceFilePath(113, paramString, 0));
      }
      if (QLog.isColorLevel())
      {
        localObject2 = localObject1;
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          if (((String)localObject1).length() > 3)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(((String)localObject1).substring(0, 2));
            ((StringBuilder)localObject2).append(".");
            ((StringBuilder)localObject2).append(((String)localObject1).charAt(((String)localObject1).length() - 1));
            localObject2 = ((StringBuilder)localObject2).toString();
          }
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("CreateIcon Done: uin=");
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append(", name=");
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(", isComplete=");
        ((StringBuilder)localObject1).append(bool2);
        ((StringBuilder)localObject1).append(", newFaceUinSet=");
        ((StringBuilder)localObject1).append(str);
        ((StringBuilder)localObject1).append(paramGroupIconInfo.toString());
        QLog.d("Q.qqhead.dih", 2, ((StringBuilder)localObject1).toString());
      }
    }
    else if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("CreateIcon fail: ");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(", iconCount=");
      ((StringBuilder)localObject1).append(paramGroupIconInfo.jdField_a_of_type_JavaUtilArrayList.size());
      ((StringBuilder)localObject1).append(", totalCount=");
      ((StringBuilder)localObject1).append(paramGroupIconInfo.jdField_a_of_type_Int);
      QLog.d("Q.qqhead.dih", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  private void a(String paramString1, boolean paramBoolean, GroupIconHelper.GroupIconInfo paramGroupIconInfo, QQAppInterface paramQQAppInterface, String paramString2)
  {
    if (paramBoolean)
    {
      Object localObject2 = null;
      int i = this.jdField_a_of_type_Int;
      Object localObject1;
      if (i == 101)
      {
        paramString1 = ((DiscussionManager)paramQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).a(paramString1);
        localObject1 = localObject2;
        if (paramString1 != null) {
          localObject1 = paramString1.faceUinSet;
        }
      }
      else
      {
        localObject1 = localObject2;
        if (i == 113)
        {
          paramString1 = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).c(paramString1);
          localObject1 = localObject2;
          if (paramString1 != null) {
            localObject1 = paramString1.mHeaderUinsOld;
          }
        }
      }
      paramBoolean = true;
      if (((localObject1 != null) && (!"".equals(((String)localObject1).trim()))) || ((paramString2 == null) || ("".equals(paramString2.trim())) || (((paramString2 == null) || (paramString2.equals(localObject1))) && ((localObject1 == null) || (((String)localObject1).equals(paramString2))) && ((paramGroupIconInfo.jdField_a_of_type_Byte != 2) || (paramString2 == null) || (paramString2.equals(paramGroupIconInfo.jdField_b_of_type_JavaLangString)) || (!paramGroupIconInfo.e))))) {
        paramBoolean = false;
      }
      paramGroupIconInfo.jdField_a_of_type_Boolean = paramBoolean;
    }
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_Boolean;
  }
  
  public static boolean a(String paramString)
  {
    if ((paramString != null) && (paramString.length() != 0)) {
      return paramString.contains("_1001");
    }
    QLog.i("Q.qqhead.dih", 1, "===isPstnDiscussionUin discussionUin is null ===");
    return false;
  }
  
  private boolean a(String paramString, boolean paramBoolean)
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        long l = System.currentTimeMillis();
        Object localObject1;
        Object localObject2;
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))
        {
          localObject1 = (GroupIconHelper.GroupIconInfo)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
          if (((GroupIconHelper.GroupIconInfo)localObject1).jdField_a_of_type_Byte != 3) {
            break label468;
          }
          bool = true;
          if (((!bool) && (l - ((GroupIconHelper.GroupIconInfo)localObject1).jdField_a_of_type_Long < this.c)) || ((bool) && (!paramBoolean) && (l - ((GroupIconHelper.GroupIconInfo)localObject1).jdField_a_of_type_Long < 3600000L)))
          {
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("putDiscussionIconInfo notDo, disUin=");
              ((StringBuilder)localObject2).append(paramString);
              ((StringBuilder)localObject2).append(",isFromCreate=");
              ((StringBuilder)localObject2).append(paramBoolean);
              ((StringBuilder)localObject2).append(",isRealCreated=");
              ((StringBuilder)localObject2).append(bool);
              ((StringBuilder)localObject2).append(",startTime=");
              ((StringBuilder)localObject2).append(((GroupIconHelper.GroupIconInfo)localObject1).jdField_a_of_type_Long);
              ((StringBuilder)localObject2).append(",state=");
              ((StringBuilder)localObject2).append(((GroupIconHelper.GroupIconInfo)localObject1).jdField_a_of_type_Byte);
              QLog.d("Q.qqhead.dih", 2, ((StringBuilder)localObject2).toString());
            }
            return false;
          }
          if ((QLog.isColorLevel()) && (!bool))
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("putDiscussionIconInfo reset, disUin=");
            ((StringBuilder)localObject2).append(paramString);
            ((StringBuilder)localObject2).append(",isFromCreate=");
            ((StringBuilder)localObject2).append(paramBoolean);
            ((StringBuilder)localObject2).append(",isRealCreated=");
            ((StringBuilder)localObject2).append(bool);
            ((StringBuilder)localObject2).append(",state=");
            ((StringBuilder)localObject2).append(((GroupIconHelper.GroupIconInfo)localObject1).jdField_a_of_type_Byte);
            QLog.d("Q.qqhead.dih", 2, ((StringBuilder)localObject2).toString());
          }
          ((GroupIconHelper.GroupIconInfo)localObject1).a(((GroupIconHelper.GroupIconInfo)localObject1).jdField_a_of_type_Byte);
        }
        else
        {
          localObject2 = new GroupIconHelper.GroupIconInfo(this, null);
          this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localObject2);
          localObject1 = localObject2;
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("putDiscussionIconInfo  not hit, disUin=");
            ((StringBuilder)localObject1).append(paramString);
            QLog.d("Q.qqhead.dih", 2, ((StringBuilder)localObject1).toString());
            localObject1 = localObject2;
          }
        }
        if (a(paramString))
        {
          localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          ((GroupIconHelper.GroupIconInfo)localObject1).c = true;
          ((GroupIconHelper.GroupIconInfo)localObject1).d = PstnUtils.a((QQAppInterface)localObject2, b(paramString), 3000);
        }
        ((GroupIconHelper.GroupIconInfo)localObject1).jdField_a_of_type_Long = l;
        this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localObject1);
        return true;
      }
      label468:
      boolean bool = false;
    }
  }
  
  private boolean a(String paramString1, boolean paramBoolean1, boolean paramBoolean2, QQAppInterface paramQQAppInterface, String paramString2, File paramFile)
  {
    if ((paramString1 != null) && (paramString1.trim().length() <= 0))
    {
      if ((paramFile != null) && (paramFile.exists()) && (paramFile.isFile())) {
        paramFile.delete();
      }
      if ((!paramBoolean1) || ((paramBoolean1) && (!paramBoolean2)))
      {
        paramString1 = null;
        int i = this.jdField_a_of_type_Int;
        if (i == 101) {
          paramString1 = ImageUtil.e();
        } else if (i == 113) {
          paramString1 = ImageUtil.e();
        }
        if (paramString1 != null) {
          paramQQAppInterface.putBitmapToCache(paramString2, paramString1, (byte)2);
        }
        return true;
      }
    }
    return false;
  }
  
  private Pair<Boolean, Boolean> b(String paramString1, String paramString2, ArrayList<String> paramArrayList, boolean paramBoolean1, boolean paramBoolean2)
  {
    Boolean localBoolean = Boolean.valueOf(false);
    QQAppInterface localQQAppInterface;
    String str1;
    byte b1;
    String str2;
    File localFile;
    if ((paramString2 != null) && ((paramString1 != null) || (paramBoolean2)))
    {
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (!paramBoolean1) {
        str1 = localQQAppInterface.getCustomFaceFilePath(this.jdField_a_of_type_Int, paramString2, 0);
      } else {
        str1 = null;
      }
      b1 = AvatarUtil.a((byte)3);
      str2 = localQQAppInterface.getFaceBitmapCacheKey(this.jdField_a_of_type_Int, paramString2, b1, 0);
      if (paramBoolean1) {
        str2 = localQQAppInterface.getFaceBitmapCacheKey(1001, a(paramString2), b1, 0);
      }
      if (!TextUtils.isEmpty(str1)) {
        localFile = new File(str1);
      } else {
        localFile = null;
      }
      if (a(paramString1, paramBoolean1, paramBoolean2, localQQAppInterface, str2, localFile)) {
        return Pair.create(Boolean.valueOf(true), Boolean.valueOf(true));
      }
    }
    try
    {
      Pair localPair = a(paramString1, paramString2, paramArrayList, paramBoolean1, paramBoolean2);
      paramArrayList = (Bitmap)localPair.second;
      bool = ((Boolean)localPair.first).booleanValue();
    }
    catch (Throwable paramArrayList)
    {
      boolean bool;
      label196:
      break label196;
    }
    paramArrayList = null;
    bool = true;
    if (paramArrayList == null) {
      return Pair.create(localBoolean, localBoolean);
    }
    return a(paramString1, paramString2, paramBoolean1, paramBoolean2, false, str1, localQQAppInterface, b1, str2, localFile, bool, paramArrayList);
    return Pair.create(localBoolean, localBoolean);
  }
  
  public static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.i("Q.qqhead.dih", 1, "===getDiscussionUinFromPstn pstnDiscussionUin is null ===");
      return null;
    }
    int i = paramString.indexOf("_");
    if ((i >= 0) && (i <= paramString.length())) {
      return paramString.substring(0, i);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("===getDiscussionUinFromPstn pstnDiscussionUin is invalid, pstnDiscussionUin | ");
    localStringBuilder.append(paramString);
    QLog.i("Q.qqhead.dih", 1, localStringBuilder.toString());
    return null;
  }
  
  private void b()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("runNext: mRunningTaskNum=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
      ((StringBuilder)localObject).append(", queueSize=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size());
      QLog.d("Q.qqhead.dih", 2, ((StringBuilder)localObject).toString());
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() < 3)
    {
      localObject = (GroupIconHelper.GenerateIconRunner)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.poll();
      if (localObject != null)
      {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
        ThreadManager.post((Runnable)localObject, 10, null, true);
      }
    }
  }
  
  private void g(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFaceGroupIconHelper$WeakReferHandler.removeMessages(9527, paramString);
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppFaceGroupIconHelper$WeakReferHandler.obtainMessage(9527, paramString);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceGroupIconHelper$WeakReferHandler.sendMessageDelayed(paramString, 300L);
  }
  
  public Bitmap a(int paramInt, Bitmap[] paramArrayOfBitmap)
  {
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject1 = null;
    try
    {
      Bitmap localBitmap = PuzzleAvatarUtil.a(paramInt, paramArrayOfBitmap);
      localObject1 = localBitmap;
      localObject2 = localBitmap;
      localObject3 = localBitmap;
      paramArrayOfBitmap = localBitmap;
      if (QLog.isColorLevel())
      {
        paramArrayOfBitmap = localBitmap;
        if (localBitmap == null)
        {
          localObject1 = localBitmap;
          localObject2 = localBitmap;
          localObject3 = localBitmap;
          QLog.i("Q.qqhead.dih", 2, "createDiscussionIcon| mask = ");
          return localBitmap;
        }
      }
    }
    catch (Error localError)
    {
      paramArrayOfBitmap = localObject1;
      if (QLog.isColorLevel())
      {
        QLog.i("Q.qqhead.dih", 2, localError.toString());
        return localObject1;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      paramArrayOfBitmap = localObject2;
      if (QLog.isColorLevel())
      {
        QLog.i("Q.qqhead.dih", 2, localOutOfMemoryError.toString());
        return localObject2;
      }
    }
    catch (Exception localException)
    {
      paramArrayOfBitmap = localObject3;
      if (QLog.isColorLevel())
      {
        QLog.i("Q.qqhead.dih", 2, localException.toString());
        paramArrayOfBitmap = localObject3;
      }
    }
    return paramArrayOfBitmap;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.dih", 2, "GroupIconHelper release.");
    }
    ??? = this.jdField_a_of_type_ComTencentMobileqqAppFaceGroupIconHelper$CheckDisIconThread;
    if (??? != null)
    {
      ((GroupIconHelper.CheckDisIconThread)???).jdField_a_of_type_Boolean = false;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_JavaLangObject.notifyAll();
      }
    }
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      this.jdField_a_of_type_JavaUtilHashMap.notifyAll();
      Object localObject3 = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        String str = (String)((Iterator)localObject3).next();
        Object localObject5 = this.jdField_a_of_type_JavaUtilHashMap.get(str);
        if ((localObject5 != null) && ((localObject5 instanceof GroupIconHelper.GroupIconInfo)))
        {
          localObject5 = (GroupIconHelper.GroupIconInfo)localObject5;
          if ((localObject5 != null) && (((GroupIconHelper.GroupIconInfo)localObject5).jdField_a_of_type_Byte != 3) && ((this.jdField_a_of_type_ComTencentMobileqqAppBusinessHandler instanceof DiscussionHandler))) {
            ((DiscussionHandler)this.jdField_a_of_type_ComTencentMobileqqAppBusinessHandler).a(false, true, str);
          }
        }
      }
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      ??? = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localObject3 = (IPhoneContactService)((QQAppInterface)???).getRuntimeService(IPhoneContactService.class, "");
      if (localObject3 != null) {
        ((IPhoneContactService)localObject3).removeListener(this);
      }
      ((QQAppInterface)???).removeObserver(this);
      this.jdField_a_of_type_ComTencentMobileqqAppBusinessHandler = null;
      return;
    }
    for (;;)
    {
      throw localObject4;
    }
  }
  
  public void a(int paramInt) {}
  
  public void a(long paramLong) {}
  
  public void a(String paramString)
  {
    boolean bool = a(paramString, true);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("createDisIcon: ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", isNeedToDo=");
      localStringBuilder.append(bool);
      QLog.d("Q.qqhead.dih", 2, localStringBuilder.toString());
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkDisIcon: ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(", isNeedToDo=");
        localStringBuilder.append(bool);
        QLog.d("Q.qqhead.dih", 2, localStringBuilder.toString());
      }
      a(new GroupIconHelper.GenerateIconRunner(this, 1, paramString));
    }
  }
  
  public void c(int paramInt)
  {
    Set localSet;
    if (paramInt == 1)
    {
      localSet = this.jdField_a_of_type_JavaUtilSet;
      if (localSet == null) {}
    }
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_JavaUtilSet.size() > 0)
        {
          ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilSet);
          int i = localArrayList.size();
          paramInt = 0;
          if (paramInt < i)
          {
            String str = (String)localArrayList.get(paramInt);
            if ((str == null) || (str.length() == 0)) {
              break label111;
            }
            e(str);
            break label111;
          }
          this.jdField_a_of_type_JavaUtilSet.clear();
        }
        return;
      }
      finally {}
      return;
      label111:
      paramInt += 1;
    }
  }
  
  public void c(String paramString)
  {
    long l = System.currentTimeMillis();
    if ((this.jdField_a_of_type_JavaUtilHashtable.containsKey(paramString)) && (l - ((Long)this.jdField_a_of_type_JavaUtilHashtable.get(paramString)).longValue() < this.jdField_b_of_type_Int))
    {
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("refreshDisIcon repeat: ");
        ((StringBuilder)???).append(paramString);
        QLog.d("Q.qqhead.dih", 2, ((StringBuilder)???).toString());
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("refreshDisIcon: ");
      ((StringBuilder)???).append(paramString);
      QLog.d("Q.qqhead.dih", 2, ((StringBuilder)???).toString());
    }
    this.jdField_a_of_type_JavaUtilHashtable.put(paramString, Long.valueOf(l));
    a(new GroupIconHelper.GenerateIconRunner(this, 3, paramString));
    ??? = this.jdField_b_of_type_JavaUtilSet;
    if ((??? != null) && (((Set)???).contains(paramString)))
    {
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("refreshDisIcon mDisCallUinSet has it ");
        ((StringBuilder)???).append(paramString);
        QLog.d("Q.qqhead.dih", 2, ((StringBuilder)???).toString());
      }
      synchronized (this.jdField_b_of_type_JavaUtilSet)
      {
        this.jdField_b_of_type_JavaUtilSet.remove(paramString);
        e(paramString);
        return;
      }
    }
  }
  
  public void d(String paramString)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("removeDiscussion: ");
      ((StringBuilder)???).append(paramString);
      QLog.d("Q.qqhead.dih", 2, ((StringBuilder)???).toString());
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
      localQQAppInterface.removeBitmapFromCache(localQQAppInterface.getFaceBitmapCacheKey(1001, a(paramString), (byte)3, 0));
      a(str);
    }
  }
  
  public void f(String paramString)
  {
    ??? = PstnUtils.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramString, 3000);
    if (((??? == null) || (((String)???).length() == 0)) && (this.jdField_a_of_type_JavaUtilSet.contains(paramString))) {
      synchronized (this.jdField_a_of_type_JavaUtilSet)
      {
        this.jdField_a_of_type_JavaUtilSet.remove(paramString);
        e(paramString);
        return;
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 9527)
    {
      paramMessage = (String)paramMessage.obj;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleMessage ACTION_GENERATE_DISCUSSION: groupUin=");
        localStringBuilder.append(paramMessage);
        QLog.d("Q.qqhead.dih", 2, localStringBuilder.toString());
      }
      a(new GroupIconHelper.GenerateIconRunner(this, 2, paramMessage));
    }
    return true;
  }
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onUpdateCustomHead isSuccess | ");
      ((StringBuilder)localObject1).append(paramBoolean);
      ((StringBuilder)localObject1).append(", uin=");
      QLog.d("Q.qqhead.dih", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2;
    label486:
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
      localObject1 = null;
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        localObject2 = this.jdField_a_of_type_JavaUtilHashMap.get(str1);
        if ((localObject2 == null) || (!(localObject2 instanceof GroupIconHelper.GroupIconInfo))) {
          break label486;
        }
        localObject2 = (GroupIconHelper.GroupIconInfo)localObject2;
        if ((localObject2 != null) && (((GroupIconHelper.GroupIconInfo)localObject2).jdField_a_of_type_JavaLangString != null))
        {
          String str2;
          StringBuilder localStringBuilder;
          if (((GroupIconHelper.GroupIconInfo)localObject2).c)
          {
            str2 = ((GroupIconHelper.GroupIconInfo)localObject2).jdField_a_of_type_JavaLangString;
            if ((paramBoolean) && (str2.contains(paramString)))
            {
              if (QLog.isColorLevel())
              {
                localStringBuilder = new StringBuilder();
                localStringBuilder.append("onUpdateCustomHead pstn: disUin=");
                localStringBuilder.append(str1);
                localStringBuilder.append(", uin=");
                localStringBuilder.append(paramString);
                localStringBuilder.append(", faceUinSet=");
                localStringBuilder.append(str2);
                QLog.d("Q.qqhead.dih", 2, localStringBuilder.toString());
              }
              if (((GroupIconHelper.GroupIconInfo)localObject2).jdField_a_of_type_Byte != 3)
              {
                ((GroupIconHelper.GroupIconInfo)localObject2).jdField_a_of_type_JavaUtilArrayList.add(paramString);
                g(str1);
              }
              else
              {
                localObject2 = localObject1;
                if (localObject1 == null) {
                  localObject2 = new ArrayList();
                }
                ((ArrayList)localObject2).add(str1);
                localObject1 = localObject2;
              }
            }
          }
          else if (((GroupIconHelper.GroupIconInfo)localObject2).jdField_a_of_type_Byte != 3)
          {
            str2 = ((GroupIconHelper.GroupIconInfo)localObject2).jdField_a_of_type_JavaLangString;
            if ((paramBoolean) && (str2.contains(paramString)))
            {
              if (QLog.isColorLevel())
              {
                localStringBuilder = new StringBuilder();
                localStringBuilder.append("onUpdateCustomHead: disUin=");
                localStringBuilder.append(str1);
                localStringBuilder.append(", uin=");
                localStringBuilder.append(paramString);
                localStringBuilder.append(", faceUinSet=");
                localStringBuilder.append(str2);
                QLog.d("Q.qqhead.dih", 2, localStringBuilder.toString());
              }
              ((GroupIconHelper.GroupIconInfo)localObject2).jdField_a_of_type_JavaUtilArrayList.add(paramString);
              g(str1);
            }
          }
        }
      }
      if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
      {
        paramString = ((ArrayList)localObject1).iterator();
        while (paramString.hasNext()) {
          e(b((String)paramString.next()));
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.GroupIconHelper
 * JD-Core Version:    0.7.0.1
 */