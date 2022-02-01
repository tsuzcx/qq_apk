package com.tencent.av.avatar;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.avatar.AvatarParam;
import com.tencent.av.ui.avatar.QavAvatarCallback;
import com.tencent.av.ui.avatar.QavAvatarUtil;
import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.emoticon.DownloadInfo;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class QavAvatarHelper
{
  private static QavAvatarHelper jdField_a_of_type_ComTencentAvAvatarQavAvatarHelper;
  private final QQLruCache<String, Drawable> jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache = new QQLruCache(10002, 10, 5);
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private final ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  private Drawable a(String paramString)
  {
    synchronized (this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache)
    {
      paramString = (Drawable)this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.get(paramString);
      return paramString;
    }
  }
  
  public static QavAvatarHelper a()
  {
    if (jdField_a_of_type_ComTencentAvAvatarQavAvatarHelper == null) {
      try
      {
        if (jdField_a_of_type_ComTencentAvAvatarQavAvatarHelper == null) {
          jdField_a_of_type_ComTencentAvAvatarQavAvatarHelper = new QavAvatarHelper();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentAvAvatarQavAvatarHelper;
  }
  
  public static String a(AvatarParam paramAvatarParam, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramAvatarParam.jdField_a_of_type_Int);
    localStringBuilder.append("_");
    localStringBuilder.append(paramAvatarParam.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramAvatarParam.b);
    localStringBuilder.append("_");
    if (paramAvatarParam.jdField_a_of_type_Boolean) {
      paramAvatarParam = "0";
    } else {
      paramAvatarParam = "1";
    }
    localStringBuilder.append(paramAvatarParam);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt);
    return localStringBuilder.toString();
  }
  
  private void a(Resources paramResources, AvatarParam paramAvatarParam, int paramInt, String paramString, WeakReference<QavAvatarCallback> paramWeakReference)
  {
    Object localObject2 = null;
    if (paramWeakReference != null) {
      paramWeakReference = (QavAvatarCallback)paramWeakReference.get();
    } else {
      paramWeakReference = null;
    }
    if (!FileUtil.b(paramString))
    {
      if (QLog.isDevelopLevel())
      {
        paramResources = new StringBuilder();
        paramResources.append("decodeAvatar fail, param = ");
        paramResources.append(paramAvatarParam);
        QLog.i("QavAvatarHelper", 4, paramResources.toString());
      }
      if (paramWeakReference != null) {
        paramWeakReference.a(paramAvatarParam, null);
      }
      return;
    }
    Object localObject1;
    try
    {
      localObject1 = BitmapFactory.decodeFile(paramString);
      paramString = (String)localObject1;
      if (paramAvatarParam.jdField_a_of_type_Boolean)
      {
        paramString = (String)localObject1;
        if (localObject1 != null)
        {
          float f2 = paramResources.getDisplayMetrics().density;
          float f1 = f2;
          if (f2 < 0.001F) {
            f1 = 2.0F;
          }
          localObject1 = BaseImageUtil.a((Bitmap)localObject1, (int)(((Bitmap)localObject1).getWidth() / f1), (int)(((Bitmap)localObject1).getHeight() / f1));
          paramString = (String)localObject1;
          if (localObject1 == null)
          {
            paramString = (String)localObject1;
            if (QLog.isColorLevel())
            {
              paramString = new StringBuilder();
              paramString.append("decodeAvatar, getCircleFaceBitmap fail, param = ");
              paramString.append(paramAvatarParam);
              QLog.i("QavAvatarHelper", 2, paramString.toString());
              paramString = (String)localObject1;
            }
          }
        }
      }
      localObject1 = localObject2;
      if (paramString != null) {
        localObject1 = new BitmapDrawable(paramResources, paramString);
      }
    }
    catch (Throwable paramResources)
    {
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("decodeAvatar ");
        paramString.append(paramResources.toString());
        QLog.i("QavAvatarHelper", 2, paramString.toString());
        localObject1 = localObject2;
      }
    }
    if (QLog.isDevelopLevel())
    {
      paramResources = new StringBuilder();
      paramResources.append("decodeAvatar param = ");
      paramResources.append(paramAvatarParam);
      paramResources.append(", drawable = ");
      paramResources.append(localObject1);
      QLog.i("QavAvatarHelper", 4, paramResources.toString());
    }
    if (paramWeakReference != null) {
      paramWeakReference.a(paramAvatarParam, (Drawable)localObject1);
    }
    if (localObject1 != null) {
      a((Drawable)localObject1, a(paramAvatarParam, paramInt));
    }
  }
  
  private void a(Drawable paramDrawable, String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
      synchronized (this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache)
      {
        this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.put(paramString, paramDrawable);
        return;
      }
    }
  }
  
  private void a(VideoAppInterface paramVideoAppInterface, AvatarParam paramAvatarParam, int paramInt, String paramString, WeakReference<QavAvatarCallback> paramWeakReference)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    String str = FaceUtil.b(paramAvatarParam.jdField_a_of_type_JavaLangString);
    Object localObject1 = new File(str);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(((File)localObject1).getPath());
    ((StringBuilder)localObject2).append(System.currentTimeMillis());
    localObject2 = new File(((StringBuilder)localObject2).toString());
    ??? = MsfSdkUtils.insertMtype("friendlist", paramString);
    boolean bool1 = false;
    if (HttpDownloadUtil.downloadData(paramVideoAppInterface, new DownloadInfo((String)???, (File)localObject2, 0), null) == 0) {
      bool1 = true;
    }
    if (bool1) {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (((File)localObject2).exists()) {
          bool1 = ((File)localObject2).renameTo((File)localObject1);
        }
        if (QLog.isDevelopLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("downloadHDAvatar suc bRet = ");
          ((StringBuilder)localObject1).append(bool1);
          ((StringBuilder)localObject1).append(", path = ");
          ((StringBuilder)localObject1).append(str);
          ((StringBuilder)localObject1).append(", downloadURL = ");
          ((StringBuilder)localObject1).append(paramString);
          QLog.i("QavAvatarHelper", 4, ((StringBuilder)localObject1).toString());
        }
        bool2 = bool1;
        if (!bool1) {
          break label339;
        }
        a(paramVideoAppInterface.getApp().getResources(), paramAvatarParam, paramInt, str, paramWeakReference);
        bool2 = bool1;
      }
    }
    if (QLog.isDevelopLevel())
    {
      paramVideoAppInterface = new StringBuilder();
      paramVideoAppInterface.append("downloadHDAvatar fail bRet = ");
      paramVideoAppInterface.append(bool1);
      paramVideoAppInterface.append(", path = ");
      paramVideoAppInterface.append(str);
      paramVideoAppInterface.append(", downloadURL = ");
      paramVideoAppInterface.append(paramString);
      QLog.i("QavAvatarHelper", 4, paramVideoAppInterface.toString());
    }
    if (((File)localObject2).exists()) {
      ((File)localObject2).delete();
    }
    boolean bool2 = bool1;
    label339:
    if (!bool2)
    {
      if (paramWeakReference != null) {
        paramVideoAppInterface = (QavAvatarCallback)paramWeakReference.get();
      } else {
        paramVideoAppInterface = null;
      }
      if (paramVideoAppInterface != null) {
        paramVideoAppInterface.a(paramAvatarParam, null);
      }
    }
  }
  
  private void a(VideoAppInterface paramVideoAppInterface, AvatarParam paramAvatarParam, WeakReference<QavAvatarCallback> paramWeakReference, int paramInt)
  {
    try
    {
      b(paramVideoAppInterface, paramAvatarParam, paramWeakReference, paramInt);
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      label10:
      QavAvatarCallback localQavAvatarCallback;
      break label10;
    }
    if (paramWeakReference == null) {
      localQavAvatarCallback = null;
    } else {
      localQavAvatarCallback = (QavAvatarCallback)paramWeakReference.get();
    }
    localQavAvatarCallback.a(paramAvatarParam, null);
    ThreadManager.getSubThreadHandler().postDelayed(new QavAvatarHelper.1(this, paramVideoAppInterface, paramAvatarParam, paramWeakReference, paramInt), 5000L);
  }
  
  private void b(VideoAppInterface paramVideoAppInterface, AvatarParam paramAvatarParam, WeakReference<QavAvatarCallback> paramWeakReference, int paramInt)
  {
    String str = paramVideoAppInterface.a(paramAvatarParam, paramInt);
    paramInt = QavAvatarUtil.a(str);
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("tryDownloadHDAvatar, param = ");
      localStringBuilder.append(paramAvatarParam);
      localStringBuilder.append(", avatarSize = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", downloadUrl = ");
      localStringBuilder.append(str);
      QLog.i("QavAvatarHelper", 4, localStringBuilder.toString());
    }
    if ((!TextUtils.isEmpty(str)) && ((paramInt > 140) || (paramInt == 0)))
    {
      ThreadManager.excute(new QavAvatarHelper.2(this, paramVideoAppInterface, paramAvatarParam, paramInt, str, paramWeakReference), 128, null, false);
      return;
    }
    if (paramWeakReference == null) {
      paramVideoAppInterface = null;
    } else {
      paramVideoAppInterface = (QavAvatarCallback)paramWeakReference.get();
    }
    if (paramVideoAppInterface != null) {
      paramVideoAppInterface.a(paramAvatarParam, null);
    }
  }
  
  public void a(VideoAppInterface paramVideoAppInterface, AvatarParam paramAvatarParam, WeakReference<QavAvatarCallback> paramWeakReference)
  {
    if (paramWeakReference != null) {
      localObject = (QavAvatarCallback)paramWeakReference.get();
    } else {
      localObject = null;
    }
    if (!QavAvatarUtil.a(paramAvatarParam.jdField_a_of_type_Int))
    {
      if (QLog.isDevelopLevel())
      {
        paramVideoAppInterface = new StringBuilder();
        paramVideoAppInterface.append("getHDAvatarDrawable, not support, param = ");
        paramVideoAppInterface.append(paramAvatarParam);
        QLog.i("QavAvatarHelper", 4, paramVideoAppInterface.toString());
      }
      if (localObject != null) {
        ((QavAvatarCallback)localObject).a(paramAvatarParam, null);
      }
      return;
    }
    Drawable localDrawable = a(a(paramAvatarParam, 640));
    if (localDrawable != null)
    {
      if (localObject != null) {
        ((QavAvatarCallback)localObject).a(paramAvatarParam, localDrawable);
      }
      if (QLog.isDevelopLevel())
      {
        paramVideoAppInterface = new StringBuilder();
        paramVideoAppInterface.append("getHDAvatarDrawable, from cache, param = ");
        paramVideoAppInterface.append(paramAvatarParam);
        QLog.i("QavAvatarHelper", 4, paramVideoAppInterface.toString());
      }
      return;
    }
    Object localObject = FaceUtil.b(paramAvatarParam.jdField_a_of_type_JavaLangString);
    if (FileUtil.b((String)localObject))
    {
      a(paramVideoAppInterface.getApp().getResources(), paramAvatarParam, 640, (String)localObject, paramWeakReference);
      return;
    }
    a(paramVideoAppInterface, paramAvatarParam, paramWeakReference, 640);
  }
  
  public void a(String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Object localObject4 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      Object localObject1 = null;
      while (((Iterator)localObject4).hasNext())
      {
        String str = (String)((Iterator)localObject4).next();
        if (str.contains(paramString))
        {
          ??? = localObject1;
          if (localObject1 == null) {
            ??? = new ArrayList(2);
          }
          ((ArrayList)???).add(str);
          localObject1 = ???;
        }
      }
      if ((localObject1 != null) && (localObject1.size() > 0))
      {
        ??? = localObject1.iterator();
        while (((Iterator)???).hasNext())
        {
          localObject4 = (String)((Iterator)???).next();
          synchronized (this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache)
          {
            this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.remove(localObject4);
          }
        }
      }
      if (QLog.isDevelopLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("clearCache, uin = ");
        ((StringBuilder)???).append(paramString);
        ((StringBuilder)???).append(", list = ");
        ((StringBuilder)???).append(localObject1);
        QLog.i("QavAvatarHelper", 2, ((StringBuilder)???).toString());
      }
      return;
    }
    for (;;)
    {
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.avatar.QavAvatarHelper
 * JD-Core Version:    0.7.0.1
 */