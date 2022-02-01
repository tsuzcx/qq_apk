import android.graphics.Bitmap;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.NearByFaceDownloader;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDownloader;
import com.tencent.mobileqq.app.face.FaceDrawableImpl.DisFaceObserver;
import com.tencent.mobileqq.app.face.FaceDrawableImpl.FaceObserver;
import com.tencent.mobileqq.app.face.FaceDrawableImpl.InternalDiscussionObserver;
import com.tencent.mobileqq.app.face.FaceDrawableImpl.InternalFriendListObserver;
import com.tencent.mobileqq.app.face.FaceDrawableImpl.InternalGroupObserver;
import com.tencent.mobileqq.app.face.FaceDrawableImpl.NewTroopFaceObserver;
import com.tencent.mobileqq.app.face.FaceInfo;
import com.tencent.mobileqq.app.face.FaceManager.1;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class aoke
  implements Manager
{
  MQLruCache<String, Object> jdField_a_of_type_AndroidSupportV4UtilMQLruCache;
  aokf jdField_a_of_type_Aokf;
  aokg jdField_a_of_type_Aokg;
  aokh jdField_a_of_type_Aokh;
  NearByFaceDownloader jdField_a_of_type_ComTencentMobileqqAppNearByFaceDownloader;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  NearbyAppInterface jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface;
  List<FaceDrawableImpl.FaceObserver> jdField_a_of_type_JavaUtilList;
  ConcurrentHashMap<String, Long> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(4);
  List<FaceDrawableImpl.DisFaceObserver> b;
  List<FaceDrawableImpl.NewTroopFaceObserver> c;
  
  public aoke(AppInterface paramAppInterface)
  {
    if ((paramAppInterface instanceof NearbyAppInterface))
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface = ((NearbyAppInterface)paramAppInterface);
      this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache = BaseApplicationImpl.sImageCache;
    }
    while (!(paramAppInterface instanceof QQAppInterface)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramAppInterface);
    this.jdField_a_of_type_Aokg = new aokg(this, null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addDefaultObservers(this.jdField_a_of_type_Aokg);
    this.jdField_a_of_type_Aokf = new aokf(this, null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addDefaultObservers(this.jdField_a_of_type_Aokf);
    this.jdField_a_of_type_Aokh = new aokh(this, null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aokh);
    this.jdField_a_of_type_JavaUtilList = new Vector();
    this.b = new Vector();
    this.c = new Vector();
  }
  
  public static byte a(byte paramByte)
  {
    byte b1 = paramByte;
    if (bdfk.a())
    {
      b1 = paramByte;
      if (!a(paramByte)) {
        b1 = 1;
      }
    }
    return b1;
  }
  
  public static byte a(int paramInt)
  {
    if (paramInt == 32) {
      return 1;
    }
    return 2;
  }
  
  public static <T> List<List<T>> a(List<T> paramList, int paramInt)
  {
    if ((paramList == null) || (paramInt < 1)) {
      return null;
    }
    int m = paramList.size();
    int i;
    ArrayList localArrayList;
    int j;
    if (m % paramInt == 0)
    {
      i = m / paramInt;
      localArrayList = new ArrayList();
      j = 0;
      label42:
      if (j >= i) {
        break label104;
      }
      if (j != i - 1) {
        break label94;
      }
    }
    label94:
    for (int k = m;; k = (j + 1) * paramInt)
    {
      localArrayList.add(paramList.subList(j * paramInt, k));
      j += 1;
      break label42;
      i = m / paramInt + 1;
      break;
    }
    label104:
    return localArrayList;
  }
  
  private void a(int paramInt, FaceDrawableImpl.DisFaceObserver paramDisFaceObserver, boolean paramBoolean, Object[] paramArrayOfObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    paramDisFaceObserver.onUpdateDiscussionFaceIcon(paramBoolean, ((Boolean)paramArrayOfObject[0]).booleanValue(), (String)paramArrayOfObject[1]);
  }
  
  private void a(int paramInt, FaceDrawableImpl.FaceObserver paramFaceObserver, boolean paramBoolean, Object[] paramArrayOfObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 39: 
      paramFaceObserver.onUpdateMobileQQHead(paramBoolean, (String)paramArrayOfObject[0]);
      return;
    case 4: 
      paramFaceObserver.onUpdateCustomHead(paramBoolean, (String)paramArrayOfObject[0]);
      return;
    case 30: 
      paramFaceObserver.onUpdateTroopHead(paramBoolean, (String)paramArrayOfObject[0]);
      return;
    case 5: 
      paramFaceObserver.onUpdateStrangerHead(paramBoolean, (String)paramArrayOfObject[0], ((Integer)paramArrayOfObject[1]).intValue(), ((Boolean)paramArrayOfObject[2]).booleanValue());
      return;
    case 6: 
      paramFaceObserver.onUpdateQCallHead(paramBoolean, (String)paramArrayOfObject[0], ((Integer)paramArrayOfObject[1]).intValue(), ((Boolean)paramArrayOfObject[2]).booleanValue());
      return;
    }
    paramFaceObserver.onUpdateApolloHead(paramBoolean, (String)paramArrayOfObject[0], ((Integer)paramArrayOfObject[1]).intValue());
  }
  
  private void a(int paramInt, FaceDrawableImpl.NewTroopFaceObserver paramNewTroopFaceObserver, boolean paramBoolean, Object[] paramArrayOfObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    paramNewTroopFaceObserver.onUpdateGroupFaceIcon(paramBoolean, ((Boolean)paramArrayOfObject[0]).booleanValue(), (String)paramArrayOfObject[1]);
  }
  
  private void a(int paramInt, Object paramObject, boolean paramBoolean, Object... paramVarArgs)
  {
    boolean bool2 = false;
    Object localObject;
    boolean bool1;
    if (((paramObject instanceof FaceDrawableImpl.InternalFriendListObserver)) && (paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      localObject = (FaceDrawableImpl.InternalFriendListObserver)paramObject;
      if ((TextUtils.isEmpty(((FaceDrawableImpl.InternalFriendListObserver)localObject).uin)) || (!((FaceDrawableImpl.InternalFriendListObserver)localObject).uin.equals((String)paramVarArgs[0]))) {
        break label272;
      }
      bool1 = true;
    }
    for (;;)
    {
      if (bool1)
      {
        paramObject = new FaceManager.1(this, paramObject, paramInt, paramBoolean, paramVarArgs);
        ThreadManager.getUIHandler().post(paramObject);
        if (QLog.isColorLevel()) {
          QLog.d("FaceManager", 2, "dispatchMessage , needDis:" + bool1 + ",type: " + paramInt + ",args: " + paramVarArgs);
        }
      }
      return;
      if (((paramObject instanceof FaceDrawableImpl.InternalDiscussionObserver)) && (paramVarArgs != null) && (paramVarArgs.length > 1))
      {
        localObject = (FaceDrawableImpl.InternalDiscussionObserver)paramObject;
        bool1 = bool2;
        if (!TextUtils.isEmpty(((FaceDrawableImpl.InternalDiscussionObserver)localObject).discussionUin))
        {
          bool1 = bool2;
          if (((FaceDrawableImpl.InternalDiscussionObserver)localObject).discussionUin.equals((String)paramVarArgs[1])) {
            bool1 = true;
          }
        }
      }
      else
      {
        if (((paramObject instanceof FaceDrawableImpl.InternalGroupObserver)) && (paramVarArgs != null) && (paramVarArgs.length > 1))
        {
          localObject = (FaceDrawableImpl.InternalGroupObserver)paramObject;
          if ((!TextUtils.isEmpty(((FaceDrawableImpl.InternalGroupObserver)localObject).discussionUin)) && (((FaceDrawableImpl.InternalGroupObserver)localObject).discussionUin.equals((String)paramVarArgs[1])))
          {
            bool1 = true;
            continue;
          }
        }
        bool1 = false;
        continue;
        label272:
        bool1 = false;
      }
    }
  }
  
  private static boolean a(byte paramByte)
  {
    return (paramByte == 4) || (paramByte == 5) || (paramByte == 8) || (paramByte == 7) || (paramByte == 6);
  }
  
  public Bitmap a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    synchronized (this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache)
    {
      Bitmap localBitmap2 = (Bitmap)this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get(paramString);
      Bitmap localBitmap1 = localBitmap2;
      if (localBitmap2 != null)
      {
        localBitmap1 = localBitmap2;
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
        {
          localBitmap1 = localBitmap2;
          if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))
          {
            long l = ((Long)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString)).longValue();
            localBitmap1 = localBitmap2;
            if (System.currentTimeMillis() - l > 86400000L)
            {
              this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
              this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.remove(paramString);
              localBitmap1 = null;
            }
          }
        }
      }
      return localBitmap1;
    }
  }
  
  public FaceDownloader a()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppNearByFaceDownloader == null) {
        this.jdField_a_of_type_ComTencentMobileqqAppNearByFaceDownloader = new NearByFaceDownloader(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface);
      }
      NearByFaceDownloader localNearByFaceDownloader = this.jdField_a_of_type_ComTencentMobileqqAppNearByFaceDownloader;
      return localNearByFaceDownloader;
    }
    finally {}
  }
  
  public Setting a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a().a(paramString);
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a().a();
  }
  
  public String a(FaceInfo paramFaceInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder(256);
    if (SystemUtil.isExistSDCard()) {
      localStringBuilder.append(AppConstants.PATH_HEAD_STRANGER);
    }
    for (;;)
    {
      localStringBuilder.append("stranger_").append(Integer.toString(paramFaceInfo.b)).append("_");
      String str = MD5.toMD5(paramFaceInfo.a);
      str = MD5.toMD5(str + paramFaceInfo.a);
      localStringBuilder.append(MD5.toMD5(str + paramFaceInfo.a));
      localStringBuilder.append(".jpg_");
      return localStringBuilder.toString();
      localStringBuilder.append("/data/data/com.tencent.mobileqq/files/head/_stranger/");
    }
  }
  
  public final void a(int paramInt, boolean paramBoolean, Object... paramVarArgs)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        if (localIterator.hasNext()) {
          a(paramInt, (FaceDrawableImpl.FaceObserver)localIterator.next(), paramBoolean, paramVarArgs);
        }
      }
    }
  }
  
  /* Error */
  public void a(FaceInfo paramFaceInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 283	aoke:jdField_a_of_type_ComTencentMobileqqAppNearByFaceDownloader	Lcom/tencent/mobileqq/app/NearByFaceDownloader;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnonnull +18 -> 26
    //   11: aload_0
    //   12: new 285	com/tencent/mobileqq/app/NearByFaceDownloader
    //   15: dup
    //   16: aload_0
    //   17: getfield 39	aoke:jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface	Lcom/tencent/mobileqq/nearby/NearbyAppInterface;
    //   20: invokespecial 288	com/tencent/mobileqq/app/NearByFaceDownloader:<init>	(Lcom/tencent/mobileqq/nearby/NearbyAppInterface;)V
    //   23: putfield 283	aoke:jdField_a_of_type_ComTencentMobileqqAppNearByFaceDownloader	Lcom/tencent/mobileqq/app/NearByFaceDownloader;
    //   26: aload_0
    //   27: getfield 283	aoke:jdField_a_of_type_ComTencentMobileqqAppNearByFaceDownloader	Lcom/tencent/mobileqq/app/NearByFaceDownloader;
    //   30: ifnull +11 -> 41
    //   33: aload_0
    //   34: getfield 283	aoke:jdField_a_of_type_ComTencentMobileqqAppNearByFaceDownloader	Lcom/tencent/mobileqq/app/NearByFaceDownloader;
    //   37: aload_1
    //   38: invokevirtual 356	com/tencent/mobileqq/app/NearByFaceDownloader:addDownloadRequest	(Lcom/tencent/mobileqq/app/face/FaceInfo;)V
    //   41: aload_0
    //   42: monitorexit
    //   43: return
    //   44: astore_2
    //   45: ldc 203
    //   47: iconst_1
    //   48: aload_2
    //   49: iconst_0
    //   50: anewarray 4	java/lang/Object
    //   53: invokestatic 360	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   56: goto -30 -> 26
    //   59: astore_1
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_1
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	aoke
    //   0	64	1	paramFaceInfo	FaceInfo
    //   6	2	2	localNearByFaceDownloader	NearByFaceDownloader
    //   44	5	2	localOutOfMemoryError	java.lang.OutOfMemoryError
    // Exception table:
    //   from	to	target	type
    //   11	26	44	java/lang/OutOfMemoryError
    //   2	7	59	finally
    //   11	26	59	finally
    //   26	41	59	finally
    //   45	56	59	finally
  }
  
  public void a(Setting paramSetting)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a().a(paramSetting);
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    do
    {
      return;
      if ((paramObject instanceof FaceDrawableImpl.FaceObserver)) {
        synchronized (this.jdField_a_of_type_JavaUtilList)
        {
          if (!this.jdField_a_of_type_JavaUtilList.contains(paramObject)) {
            this.jdField_a_of_type_JavaUtilList.add((FaceDrawableImpl.FaceObserver)paramObject);
          }
          return;
        }
      }
      if ((paramObject instanceof FaceDrawableImpl.DisFaceObserver)) {
        synchronized (this.b)
        {
          if (!this.b.contains(paramObject)) {
            this.b.add((FaceDrawableImpl.DisFaceObserver)paramObject);
          }
          return;
        }
      }
    } while (!(paramObject instanceof FaceDrawableImpl.NewTroopFaceObserver));
    synchronized (this.c)
    {
      if (!this.c.contains(paramObject)) {
        this.c.add((FaceDrawableImpl.NewTroopFaceObserver)paramObject);
      }
      return;
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    synchronized (this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache)
    {
      this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.remove(paramString);
      return;
    }
  }
  
  public void a(String paramString, Bitmap paramBitmap, byte paramByte)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramBitmap == null)) {
      return;
    }
    synchronized (this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache)
    {
      this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.put(paramString, paramBitmap, paramByte);
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Long.valueOf(System.currentTimeMillis()));
      }
      return;
    }
  }
  
  public void a(ArrayList<String> paramArrayList, long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a().a(paramArrayList, paramLong);
  }
  
  public boolean a(FaceInfo paramFaceInfo)
  {
    paramFaceInfo = a(paramFaceInfo);
    if (TextUtils.isEmpty(paramFaceInfo)) {
      return false;
    }
    return new File(paramFaceInfo).exists();
  }
  
  public String b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a().b();
  }
  
  public final void b(int paramInt, boolean paramBoolean, Object... paramVarArgs)
  {
    if ((this.b != null) && (this.b.size() > 0)) {
      synchronized (this.b)
      {
        Iterator localIterator = this.b.iterator();
        if (localIterator.hasNext()) {
          a(paramInt, (FaceDrawableImpl.DisFaceObserver)localIterator.next(), paramBoolean, paramVarArgs);
        }
      }
    }
  }
  
  public void b(Object paramObject)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    do
    {
      return;
      if ((paramObject instanceof FaceDrawableImpl.FaceObserver)) {
        synchronized (this.jdField_a_of_type_JavaUtilList)
        {
          this.jdField_a_of_type_JavaUtilList.remove(paramObject);
          return;
        }
      }
      if ((paramObject instanceof FaceDrawableImpl.DisFaceObserver)) {
        synchronized (this.b)
        {
          this.b.remove(paramObject);
          return;
        }
      }
    } while (!(paramObject instanceof FaceDrawableImpl.NewTroopFaceObserver));
    synchronized (this.c)
    {
      this.c.remove(paramObject);
      return;
    }
  }
  
  public final void c(int paramInt, boolean paramBoolean, Object... paramVarArgs)
  {
    if ((this.c != null) && (this.c.size() > 0)) {
      synchronized (this.c)
      {
        Iterator localIterator = this.c.iterator();
        if (localIterator.hasNext()) {
          a(paramInt, (FaceDrawableImpl.NewTroopFaceObserver)localIterator.next(), paramBoolean, paramVarArgs);
        }
      }
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aokg);
      this.b.clear();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aokf);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aokh);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoke
 * JD-Core Version:    0.7.0.1
 */