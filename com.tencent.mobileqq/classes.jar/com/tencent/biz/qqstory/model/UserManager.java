package com.tencent.biz.qqstory.model;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.Copyable;
import com.tencent.biz.qqstory.base.OneObjectCacheList;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.database.UnionIdMapEntity;
import com.tencent.biz.qqstory.database.UserEntry;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.QQUserUIItem.UserID;
import com.tencent.biz.qqstory.network.request.ConvertUinAndUnionIdRequest;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialCareManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import ndj;
import ndk;

public class UserManager
  implements IManager
{
  protected OneObjectCacheList a;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private Set jdField_a_of_type_JavaUtilSet = new HashSet();
  public boolean a;
  
  public UserManager()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBaseOneObjectCacheList = new OneObjectCacheList(300);
    this.jdField_a_of_type_Boolean = false;
  }
  
  private QQStoryContext a()
  {
    return QQStoryContext.a();
  }
  
  protected static String a(String paramString)
  {
    return "k_" + paramString;
  }
  
  public static List a(EntityManager paramEntityManager, Class paramClass, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return paramEntityManager.a(paramClass, paramString1, false, paramString2, paramArrayOfString, null, null, null, null, null);
  }
  
  public QQUserUIItem a()
  {
    return b(QQStoryContext.a().b());
  }
  
  public QQUserUIItem a(QQUserUIItem paramQQUserUIItem)
  {
    String str = paramQQUserUIItem.uid;
    b(str);
    paramQQUserUIItem = (QQUserUIItem)this.jdField_a_of_type_ComTencentBizQqstoryBaseOneObjectCacheList.a(a(str), paramQQUserUIItem);
    a().a().createEntityManager().b(paramQQUserUIItem.convert2UserEntry());
    return paramQQUserUIItem;
  }
  
  public QQUserUIItem a(@NonNull String paramString)
  {
    AssertUtils.a(paramString);
    QQUserUIItem localQQUserUIItem = b(paramString);
    paramString = localQQUserUIItem;
    if (localQQUserUIItem == null)
    {
      paramString = new QQUserUIItem();
      paramString.uid = QQStoryContext.a().b();
      paramString.qq = PlayModeUtils.a().getCurrentAccountUin();
      paramString.nickName = PlayModeUtils.a().getCurrentNickname();
      paramString.headUrl = "";
      SLog.d("Q.qqstory.user.UserManager", "create fake feed item while QQUserUIItem is null! use fake QQUserUIItem to instead.", new Object[] { paramString.toString() });
    }
    return paramString;
  }
  
  public QQUserUIItem a(@NonNull String paramString, boolean paramBoolean)
  {
    String str = paramString;
    if ("0_1000".equals(paramString)) {
      str = (String)((StoryConfigManager)SuperManager.a(10)).b("qqstory_my_union_id", paramString);
    }
    QQUserUIItem localQQUserUIItem = (QQUserUIItem)this.jdField_a_of_type_ComTencentBizQqstoryBaseOneObjectCacheList.a(a(str));
    paramString = localQQUserUIItem;
    if (localQQUserUIItem == null)
    {
      if (paramBoolean) {
        break label62;
      }
      paramString = localQQUserUIItem;
    }
    label62:
    do
    {
      return paramString;
      localQQUserUIItem = d(str);
      paramString = localQQUserUIItem;
    } while (localQQUserUIItem != null);
    SLog.d("Q.qqstory.user.UserManager", "%s get userItem is null", new Object[] { str });
    return localQQUserUIItem;
  }
  
  public String a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "-9";
    }
    if (QQStoryContext.a().a(paramString)) {
      return QQStoryContext.a().a();
    }
    Object localObject = b(paramString);
    if ((localObject != null) && (!TextUtils.isEmpty(((QQUserUIItem)localObject).qq))) {
      return ((QQUserUIItem)localObject).qq;
    }
    localObject = a(a().a().createEntityManager(), UnionIdMapEntity.class, UnionIdMapEntity.class.getSimpleName(), UnionIdMapEntity.selectionUnionId(), new String[] { paramString });
    if ((localObject != null) && (((List)localObject).size() > 0)) {
      return ((UnionIdMapEntity)((List)localObject).get(0)).qq;
    }
    if (paramBoolean) {}
    for (localObject = "wait and ask from net";; localObject = "ret")
    {
      SLog.d("Q.qqstory.user.UserManager", "unionId %s cannot find uin ,%s", new Object[] { paramString, localObject });
      localObject = new QQUserUIItem.UserID("-9", paramString);
      a(1, (QQUserUIItem.UserID)localObject);
      if (paramBoolean) {
        break;
      }
      return "-9";
    }
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      SLog.e("Q.qqstory.user.UserManager", "Cannot req on UI thread");
      return "-9";
    }
    try
    {
      localObject.wait(10000L);
      SLog.d("Q.qqstory.user.UserManager", "%s wait end", new Object[] { paramString });
      return ((QQUserUIItem.UserID)localObject).a;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        SLog.d("Q.qqstory.user.UserManager", "%s wait exception", new Object[] { paramString, localInterruptedException });
      }
    }
    finally {}
  }
  
  public void a() {}
  
  protected void a(int paramInt, QQUserUIItem.UserID paramUserID)
  {
    if (paramInt == 1) {}
    for (Object localObject = "unionId";; localObject = "uin")
    {
      SLog.d("Q.qqstory.user.UserManager", "start get user id: %s , convert from %s", new Object[] { paramUserID, localObject });
      long l = System.currentTimeMillis();
      localObject = new ConvertUinAndUnionIdRequest();
      ((ConvertUinAndUnionIdRequest)localObject).c = paramInt;
      ((ConvertUinAndUnionIdRequest)localObject).jdField_a_of_type_JavaUtilList.add(paramUserID);
      boolean bool = paramUserID.a();
      CmdTaskManger.a().a((NetworkRequest)localObject, new ndk(this, paramUserID, bool, l));
      return;
    }
  }
  
  public void a(@NonNull String paramString1, @NonNull String paramString2)
  {
    AssertUtils.a(paramString1);
    AssertUtils.a(paramString2);
    EntityManager localEntityManager = a().a().createEntityManager();
    UnionIdMapEntity localUnionIdMapEntity = new UnionIdMapEntity();
    localUnionIdMapEntity.unionId = paramString1;
    localUnionIdMapEntity.qq = paramString2;
    localEntityManager.b(localUnionIdMapEntity);
  }
  
  public boolean a(String paramString)
  {
    return QvipSpecialCareManager.a(QQStoryContext.a().getCurrentAccountUin() + paramString);
  }
  
  public QQUserUIItem b(@NonNull String paramString)
  {
    return a(paramString, true);
  }
  
  public String b(String paramString, boolean paramBoolean)
  {
    Object localObject = e(paramString);
    if ((localObject != null) && (!TextUtils.isEmpty(((QQUserUIItem)localObject).uid))) {
      return ((QQUserUIItem)localObject).uid;
    }
    localObject = a(a().a().createEntityManager(), UnionIdMapEntity.class, UnionIdMapEntity.class.getSimpleName(), UnionIdMapEntity.selectionQQ(), new String[] { paramString });
    if ((localObject != null) && (((List)localObject).size() > 0)) {
      return ((UnionIdMapEntity)((List)localObject).get(0)).unionId;
    }
    if (paramBoolean) {}
    for (localObject = "wait and ask from net";; localObject = "ret")
    {
      SLog.d("Q.qqstory.user.UserManager", "qq %s cannot find unionid ,%s", new Object[] { paramString, localObject });
      localObject = new QQUserUIItem.UserID(paramString, "");
      a(0, (QQUserUIItem.UserID)localObject);
      if (paramBoolean) {
        break;
      }
      return "";
    }
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      SLog.e("Q.qqstory.user.UserManager", "Cannot req on UI thread");
      return "";
    }
    try
    {
      localObject.wait(10000L);
      SLog.d("Q.qqstory.user.UserManager", "%s wait end", new Object[] { paramString });
      return ((QQUserUIItem.UserID)localObject).b;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        SLog.d("Q.qqstory.user.UserManager", "%s wait exception", new Object[] { paramString, localInterruptedException });
      }
    }
    finally {}
  }
  
  public void b() {}
  
  public boolean b(String paramString)
  {
    boolean bool = true;
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject = b(paramString);
    if (localObject != null)
    {
      if (((QQUserUIItem)localObject).relationType != -1)
      {
        if (((QQUserUIItem)localObject).relationType == 0) {}
        for (;;)
        {
          return bool;
          bool = false;
        }
      }
      localObject = a(paramString, false);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        return ((FriendsManager)PlayModeUtils.a().getManager(50)).b((String)localObject);
      }
      a(1, new QQUserUIItem.UserID("-9", paramString));
      return false;
    }
    a(1, new QQUserUIItem.UserID("-9", paramString));
    return false;
  }
  
  public QQUserUIItem c(@NonNull String paramString)
  {
    QQUserUIItem localQQUserUIItem = b(paramString);
    if ((localQQUserUIItem == null) || (!localQQUserUIItem.isAvailable()))
    {
      if (!this.jdField_a_of_type_JavaUtilSet.contains(paramString))
      {
        this.jdField_a_of_type_JavaUtilList.add(new QQUserUIItem.UserID("", paramString));
        this.jdField_a_of_type_JavaUtilSet.add(paramString);
      }
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = true;
        new Handler().postDelayed(new ndj(this), 600L);
      }
    }
    return localQQUserUIItem;
  }
  
  public void c()
  {
    String str = QQStoryContext.a().b();
    if ((str.equals("0_1000")) || (a() == null))
    {
      SLog.d("Q.qqstory.user.UserManager", "current union %s is default or userItem is null", new Object[] { str });
      a(1, new QQUserUIItem.UserID(QQStoryContext.a().a(), str));
    }
  }
  
  protected QQUserUIItem d(String paramString)
  {
    Object localObject = a(a().a().createEntityManager(), UserEntry.class, UserEntry.class.getSimpleName(), UserEntry.getUserSelectionNoArg(), new String[] { paramString });
    if ((localObject == null) || (((List)localObject).size() == 0))
    {
      SLog.a("Q.qqstory.user.UserManager", "%s cannot get userItem from db", paramString);
      return null;
    }
    paramString = (UserEntry)((List)localObject).get(0);
    localObject = new QQUserUIItem(paramString);
    return (QQUserUIItem)this.jdField_a_of_type_ComTencentBizQqstoryBaseOneObjectCacheList.a(a(paramString.unionId), (Copyable)localObject);
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBaseOneObjectCacheList.a(0);
  }
  
  protected QQUserUIItem e(String paramString)
  {
    Object localObject = a(a().a().createEntityManager(), UserEntry.class, UserEntry.class.getSimpleName(), UserEntry.getUserSelectionByQQ(), new String[] { paramString });
    if ((localObject == null) || (((List)localObject).size() == 0))
    {
      SLog.a("Q.qqstory.user.UserManager", "qq %s cannot get userItem from db", paramString);
      return null;
    }
    paramString = (UserEntry)((List)localObject).get(0);
    localObject = new QQUserUIItem(paramString);
    return (QQUserUIItem)this.jdField_a_of_type_ComTencentBizQqstoryBaseOneObjectCacheList.a(a(paramString.qq), (Copyable)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.UserManager
 * JD-Core Version:    0.7.0.1
 */