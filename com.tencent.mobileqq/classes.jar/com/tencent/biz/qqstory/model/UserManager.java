package com.tencent.biz.qqstory.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.Copyable;
import com.tencent.biz.qqstory.base.OneObjectCacheList;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.database.UnionIdMapEntity;
import com.tencent.biz.qqstory.database.UserEntry;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.QQUserUIItem.UserID;
import com.tencent.biz.qqstory.network.handler.GetUserInfoHandler;
import com.tencent.biz.qqstory.network.handler.GetUserInfoHandler.OnGetUserInfoCallback;
import com.tencent.biz.qqstory.network.handler.GetUserInfoHandler.UpdateUserInfoEvent;
import com.tencent.biz.qqstory.network.request.ConvertUinAndUnionIdRequest;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialCareUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import java.util.List;

public class UserManager
  implements IManager
{
  protected OneObjectCacheList<String, QQUserUIItem> a = new OneObjectCacheList(300);
  private GetUserInfoHandler b = new GetUserInfoHandler();
  
  public static List<? extends Entity> a(EntityManager paramEntityManager, Class<? extends Entity> paramClass, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return paramEntityManager.query(paramClass, paramString1, false, paramString2, paramArrayOfString, null, null, null, null, null);
  }
  
  private QQStoryContext f()
  {
    return QQStoryContext.a();
  }
  
  protected static String g(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("k_");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public QQUserUIItem a(QQUserUIItem paramQQUserUIItem)
  {
    String str = paramQQUserUIItem.uid;
    b(str);
    paramQQUserUIItem = (QQUserUIItem)this.a.a(g(str), paramQQUserUIItem);
    f().d().createEntityManager().persistOrReplace(paramQQUserUIItem.convert2UserEntry());
    return paramQQUserUIItem;
  }
  
  public QQUserUIItem a(@NonNull String paramString)
  {
    AssertUtils.checkNotEmpty(paramString);
    QQUserUIItem localQQUserUIItem = b(paramString);
    paramString = localQQUserUIItem;
    if (localQQUserUIItem == null)
    {
      paramString = new QQUserUIItem();
      paramString.uid = QQStoryContext.a().i();
      paramString.qq = PlayModeUtils.b().getCurrentAccountUin();
      paramString.nickName = PlayModeUtils.b().getCurrentNickname();
      paramString.headUrl = "";
      SLog.d("Q.qqstory.user.UserManager", "create fake feed item while QQUserUIItem is null! use fake QQUserUIItem to instead.", new Object[] { paramString.toString() });
    }
    return paramString;
  }
  
  /* Error */
  public String a(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 148	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +6 -> 10
    //   7: ldc 150
    //   9: areturn
    //   10: invokestatic 43	com/tencent/biz/qqstory/app/QQStoryContext:a	()Lcom/tencent/biz/qqstory/app/QQStoryContext;
    //   13: aload_1
    //   14: invokevirtual 153	com/tencent/biz/qqstory/app/QQStoryContext:b	(Ljava/lang/String;)Z
    //   17: ifeq +10 -> 27
    //   20: invokestatic 43	com/tencent/biz/qqstory/app/QQStoryContext:a	()Lcom/tencent/biz/qqstory/app/QQStoryContext;
    //   23: invokevirtual 155	com/tencent/biz/qqstory/app/QQStoryContext:g	()Ljava/lang/String;
    //   26: areturn
    //   27: aload_0
    //   28: aload_1
    //   29: invokevirtual 68	com/tencent/biz/qqstory/model/UserManager:b	(Ljava/lang/String;)Lcom/tencent/biz/qqstory/model/item/QQUserUIItem;
    //   32: astore_3
    //   33: aload_3
    //   34: ifnull +18 -> 52
    //   37: aload_3
    //   38: getfield 117	com/tencent/biz/qqstory/model/item/QQUserUIItem:qq	Ljava/lang/String;
    //   41: invokestatic 148	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   44: ifne +8 -> 52
    //   47: aload_3
    //   48: getfield 117	com/tencent/biz/qqstory/model/item/QQUserUIItem:qq	Ljava/lang/String;
    //   51: areturn
    //   52: aload_0
    //   53: invokespecial 75	com/tencent/biz/qqstory/model/UserManager:f	()Lcom/tencent/biz/qqstory/app/QQStoryContext;
    //   56: invokevirtual 79	com/tencent/biz/qqstory/app/QQStoryContext:d	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   59: invokevirtual 85	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   62: ldc 157
    //   64: ldc 157
    //   66: invokevirtual 162	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   69: invokestatic 165	com/tencent/biz/qqstory/database/UnionIdMapEntity:selectionUnionId	()Ljava/lang/String;
    //   72: iconst_1
    //   73: anewarray 167	java/lang/String
    //   76: dup
    //   77: iconst_0
    //   78: aload_1
    //   79: aastore
    //   80: invokestatic 169	com/tencent/biz/qqstory/model/UserManager:a	(Lcom/tencent/mobileqq/persistence/EntityManager;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Ljava/util/List;
    //   83: astore_3
    //   84: aload_3
    //   85: ifnull +26 -> 111
    //   88: aload_3
    //   89: invokeinterface 175 1 0
    //   94: ifle +17 -> 111
    //   97: aload_3
    //   98: iconst_0
    //   99: invokeinterface 179 2 0
    //   104: checkcast 157	com/tencent/biz/qqstory/database/UnionIdMapEntity
    //   107: getfield 180	com/tencent/biz/qqstory/database/UnionIdMapEntity:qq	Ljava/lang/String;
    //   110: areturn
    //   111: iload_2
    //   112: ifeq +9 -> 121
    //   115: ldc 182
    //   117: astore_3
    //   118: goto +6 -> 124
    //   121: ldc 184
    //   123: astore_3
    //   124: ldc 130
    //   126: ldc 186
    //   128: iconst_2
    //   129: anewarray 4	java/lang/Object
    //   132: dup
    //   133: iconst_0
    //   134: aload_1
    //   135: aastore
    //   136: dup
    //   137: iconst_1
    //   138: aload_3
    //   139: aastore
    //   140: invokestatic 138	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   143: new 188	com/tencent/biz/qqstory/model/item/QQUserUIItem$UserID
    //   146: dup
    //   147: ldc 150
    //   149: aload_1
    //   150: invokespecial 191	com/tencent/biz/qqstory/model/item/QQUserUIItem$UserID:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   153: astore_3
    //   154: aload_0
    //   155: iconst_1
    //   156: aload_3
    //   157: invokevirtual 194	com/tencent/biz/qqstory/model/UserManager:a	(ILcom/tencent/biz/qqstory/model/item/QQUserUIItem$UserID;)V
    //   160: iload_2
    //   161: ifne +6 -> 167
    //   164: ldc 150
    //   166: areturn
    //   167: invokestatic 200	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   170: invokestatic 203	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   173: if_acmpne +13 -> 186
    //   176: ldc 130
    //   178: ldc 205
    //   180: invokestatic 208	com/tencent/biz/qqstory/support/logging/SLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   183: ldc 150
    //   185: areturn
    //   186: aload_3
    //   187: monitorenter
    //   188: aload_3
    //   189: ldc2_w 209
    //   192: invokevirtual 214	java/lang/Object:wait	(J)V
    //   195: goto +29 -> 224
    //   198: astore_1
    //   199: goto +47 -> 246
    //   202: astore 4
    //   204: ldc 130
    //   206: ldc 216
    //   208: iconst_2
    //   209: anewarray 4	java/lang/Object
    //   212: dup
    //   213: iconst_0
    //   214: aload_1
    //   215: aastore
    //   216: dup
    //   217: iconst_1
    //   218: aload 4
    //   220: aastore
    //   221: invokestatic 138	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   224: aload_3
    //   225: monitorexit
    //   226: ldc 130
    //   228: ldc 218
    //   230: iconst_1
    //   231: anewarray 4	java/lang/Object
    //   234: dup
    //   235: iconst_0
    //   236: aload_1
    //   237: aastore
    //   238: invokestatic 138	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   241: aload_3
    //   242: getfield 220	com/tencent/biz/qqstory/model/item/QQUserUIItem$UserID:a	Ljava/lang/String;
    //   245: areturn
    //   246: aload_3
    //   247: monitorexit
    //   248: aload_1
    //   249: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	250	0	this	UserManager
    //   0	250	1	paramString	String
    //   0	250	2	paramBoolean	boolean
    //   32	215	3	localObject	Object
    //   202	17	4	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   188	195	198	finally
    //   204	224	198	finally
    //   224	226	198	finally
    //   246	248	198	finally
    //   188	195	202	java/lang/InterruptedException
  }
  
  public void a() {}
  
  protected void a(int paramInt, QQUserUIItem.UserID paramUserID)
  {
    if (paramInt == 1) {
      localObject = "unionId";
    } else {
      localObject = "uin";
    }
    SLog.d("Q.qqstory.user.UserManager", "start get user id: %s , convert from %s", new Object[] { paramUserID, localObject });
    long l = System.currentTimeMillis();
    Object localObject = new ConvertUinAndUnionIdRequest();
    ((ConvertUinAndUnionIdRequest)localObject).e = paramInt;
    ((ConvertUinAndUnionIdRequest)localObject).f.add(paramUserID);
    boolean bool = paramUserID.a();
    CmdTaskManger.a().a((NetworkRequest)localObject, new UserManager.2(this, paramUserID, bool, l));
  }
  
  public void a(@NonNull String paramString, GetUserInfoHandler.OnGetUserInfoCallback paramOnGetUserInfoCallback)
  {
    QQUserUIItem localQQUserUIItem = c(paramString, false);
    GetUserInfoHandler.UpdateUserInfoEvent localUpdateUserInfoEvent = new GetUserInfoHandler.UpdateUserInfoEvent();
    if (localQQUserUIItem != null)
    {
      localUpdateUserInfoEvent.a = localQQUserUIItem;
      paramOnGetUserInfoCallback.a(localUpdateUserInfoEvent);
      return;
    }
    ThreadManager.excute(new UserManager.1(this, paramString, localUpdateUserInfoEvent, paramOnGetUserInfoCallback), 32, null, true);
  }
  
  public void a(@NonNull String paramString1, @NonNull String paramString2)
  {
    AssertUtils.checkNotNull(paramString1);
    AssertUtils.checkNotNull(paramString2);
    EntityManager localEntityManager = f().d().createEntityManager();
    UnionIdMapEntity localUnionIdMapEntity = new UnionIdMapEntity();
    localUnionIdMapEntity.unionId = paramString1;
    localUnionIdMapEntity.qq = paramString2;
    localEntityManager.persistOrReplace(localUnionIdMapEntity);
  }
  
  @Nullable
  public QQUserUIItem b(@NonNull String paramString)
  {
    return c(paramString, true);
  }
  
  /* Error */
  public String b(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 299	com/tencent/biz/qqstory/model/UserManager:f	(Ljava/lang/String;)Lcom/tencent/biz/qqstory/model/item/QQUserUIItem;
    //   5: astore_3
    //   6: aload_3
    //   7: ifnull +18 -> 25
    //   10: aload_3
    //   11: getfield 65	com/tencent/biz/qqstory/model/item/QQUserUIItem:uid	Ljava/lang/String;
    //   14: invokestatic 148	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   17: ifne +8 -> 25
    //   20: aload_3
    //   21: getfield 65	com/tencent/biz/qqstory/model/item/QQUserUIItem:uid	Ljava/lang/String;
    //   24: areturn
    //   25: aload_0
    //   26: invokespecial 75	com/tencent/biz/qqstory/model/UserManager:f	()Lcom/tencent/biz/qqstory/app/QQStoryContext;
    //   29: invokevirtual 79	com/tencent/biz/qqstory/app/QQStoryContext:d	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   32: invokevirtual 85	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   35: ldc 157
    //   37: ldc 157
    //   39: invokevirtual 162	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   42: invokestatic 302	com/tencent/biz/qqstory/database/UnionIdMapEntity:selectionQQ	()Ljava/lang/String;
    //   45: iconst_1
    //   46: anewarray 167	java/lang/String
    //   49: dup
    //   50: iconst_0
    //   51: aload_1
    //   52: aastore
    //   53: invokestatic 169	com/tencent/biz/qqstory/model/UserManager:a	(Lcom/tencent/mobileqq/persistence/EntityManager;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Ljava/util/List;
    //   56: astore_3
    //   57: aload_3
    //   58: ifnull +26 -> 84
    //   61: aload_3
    //   62: invokeinterface 175 1 0
    //   67: ifle +17 -> 84
    //   70: aload_3
    //   71: iconst_0
    //   72: invokeinterface 179 2 0
    //   77: checkcast 157	com/tencent/biz/qqstory/database/UnionIdMapEntity
    //   80: getfield 295	com/tencent/biz/qqstory/database/UnionIdMapEntity:unionId	Ljava/lang/String;
    //   83: areturn
    //   84: iload_2
    //   85: ifeq +9 -> 94
    //   88: ldc 182
    //   90: astore_3
    //   91: goto +6 -> 97
    //   94: ldc 184
    //   96: astore_3
    //   97: ldc 130
    //   99: ldc_w 304
    //   102: iconst_2
    //   103: anewarray 4	java/lang/Object
    //   106: dup
    //   107: iconst_0
    //   108: aload_1
    //   109: aastore
    //   110: dup
    //   111: iconst_1
    //   112: aload_3
    //   113: aastore
    //   114: invokestatic 138	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   117: new 188	com/tencent/biz/qqstory/model/item/QQUserUIItem$UserID
    //   120: dup
    //   121: aload_1
    //   122: ldc 125
    //   124: invokespecial 191	com/tencent/biz/qqstory/model/item/QQUserUIItem$UserID:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   127: astore_3
    //   128: aload_0
    //   129: iconst_0
    //   130: aload_3
    //   131: invokevirtual 194	com/tencent/biz/qqstory/model/UserManager:a	(ILcom/tencent/biz/qqstory/model/item/QQUserUIItem$UserID;)V
    //   134: iload_2
    //   135: ifne +6 -> 141
    //   138: ldc 125
    //   140: areturn
    //   141: invokestatic 200	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   144: invokestatic 203	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   147: if_acmpne +13 -> 160
    //   150: ldc 130
    //   152: ldc 205
    //   154: invokestatic 208	com/tencent/biz/qqstory/support/logging/SLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   157: ldc 125
    //   159: areturn
    //   160: aload_3
    //   161: monitorenter
    //   162: aload_3
    //   163: ldc2_w 209
    //   166: invokevirtual 214	java/lang/Object:wait	(J)V
    //   169: goto +29 -> 198
    //   172: astore_1
    //   173: goto +47 -> 220
    //   176: astore 4
    //   178: ldc 130
    //   180: ldc 216
    //   182: iconst_2
    //   183: anewarray 4	java/lang/Object
    //   186: dup
    //   187: iconst_0
    //   188: aload_1
    //   189: aastore
    //   190: dup
    //   191: iconst_1
    //   192: aload 4
    //   194: aastore
    //   195: invokestatic 138	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   198: aload_3
    //   199: monitorexit
    //   200: ldc 130
    //   202: ldc 218
    //   204: iconst_1
    //   205: anewarray 4	java/lang/Object
    //   208: dup
    //   209: iconst_0
    //   210: aload_1
    //   211: aastore
    //   212: invokestatic 138	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   215: aload_3
    //   216: getfield 306	com/tencent/biz/qqstory/model/item/QQUserUIItem$UserID:b	Ljava/lang/String;
    //   219: areturn
    //   220: aload_3
    //   221: monitorexit
    //   222: aload_1
    //   223: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	224	0	this	UserManager
    //   0	224	1	paramString	String
    //   0	224	2	paramBoolean	boolean
    //   5	216	3	localObject	Object
    //   176	17	4	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   162	169	172	finally
    //   178	198	172	finally
    //   198	200	172	finally
    //   220	222	172	finally
    //   162	169	176	java/lang/InterruptedException
  }
  
  public void b() {}
  
  public QQUserUIItem c()
  {
    return b(QQStoryContext.a().i());
  }
  
  public QQUserUIItem c(@NonNull String paramString)
  {
    QQUserUIItem localQQUserUIItem = b(paramString);
    if ((localQQUserUIItem == null) || (!localQQUserUIItem.isAvailable())) {
      this.b.a(paramString);
    }
    return localQQUserUIItem;
  }
  
  @Nullable
  public QQUserUIItem c(@NonNull String paramString, boolean paramBoolean)
  {
    String str = paramString;
    if ("0_1000".equals(paramString)) {
      str = (String)((StoryConfigManager)SuperManager.a(10)).c("qqstory_my_union_id", paramString);
    }
    paramString = (QQUserUIItem)this.a.a(g(str));
    if (paramString == null)
    {
      if (!paramBoolean) {
        return paramString;
      }
      paramString = e(str);
      if (paramString == null) {
        SLog.d("Q.qqstory.user.UserManager", "%s get userItem is null", new Object[] { str });
      }
      return paramString;
    }
    return paramString;
  }
  
  public void d()
  {
    String str = QQStoryContext.a().i();
    if ((str.equals("0_1000")) || (c() == null))
    {
      SLog.d("Q.qqstory.user.UserManager", "current union %s is default or userItem is null", new Object[] { str });
      a(1, new QQUserUIItem.UserID(QQStoryContext.a().g(), str));
    }
  }
  
  public boolean d(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(QQStoryContext.k().getCurrentAccountUin());
    localStringBuilder.append(paramString);
    return QvipSpecialCareUtil.a(localStringBuilder.toString());
  }
  
  @Nullable
  protected QQUserUIItem e(String paramString)
  {
    Object localObject = a(f().d().createEntityManager(), UserEntry.class, UserEntry.class.getSimpleName(), UserEntry.getUserSelectionNoArg(), new String[] { paramString });
    if ((localObject != null) && (((List)localObject).size() != 0))
    {
      paramString = (UserEntry)((List)localObject).get(0);
      localObject = new QQUserUIItem(paramString);
      return (QQUserUIItem)this.a.a(g(paramString.unionId), (Copyable)localObject);
    }
    SLog.a("Q.qqstory.user.UserManager", "%s cannot get userItem from db", paramString);
    return null;
  }
  
  public void e()
  {
    this.a.a(0);
  }
  
  protected QQUserUIItem f(String paramString)
  {
    Object localObject = a(f().d().createEntityManager(), UserEntry.class, UserEntry.class.getSimpleName(), UserEntry.getUserSelectionByQQ(), new String[] { paramString });
    if ((localObject != null) && (((List)localObject).size() != 0))
    {
      paramString = (UserEntry)((List)localObject).get(0);
      localObject = new QQUserUIItem(paramString);
      return (QQUserUIItem)this.a.a(g(paramString.qq), (Copyable)localObject);
    }
    SLog.a("Q.qqstory.user.UserManager", "qq %s cannot get userItem from db", paramString);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.UserManager
 * JD-Core Version:    0.7.0.1
 */