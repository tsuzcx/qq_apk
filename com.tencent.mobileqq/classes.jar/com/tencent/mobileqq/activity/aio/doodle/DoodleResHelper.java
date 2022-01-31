package com.tencent.mobileqq.activity.aio.doodle;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.scribble.ScribbleResMgr;
import com.tencent.mobileqq.scribble.ScribbleResMgr.ResCallback;
import com.tencent.mobileqq.scribble.ScribbleResMgr.ResInfo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import upb;
import upc;
import upd;

public class DoodleResHelper
{
  static volatile DoodleResHelper jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleResHelper;
  private int jdField_a_of_type_Int;
  private final String jdField_a_of_type_JavaLangString = "DoodleResHelper";
  private Map jdField_a_of_type_JavaUtilMap;
  
  public static DoodleResHelper a()
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleResHelper == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleResHelper == null) {
        jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleResHelper = new DoodleResHelper();
      }
      return jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleResHelper;
    }
    finally {}
  }
  
  private String a(String paramString, int paramInt)
  {
    return "Aio_Doodle/Type_" + paramInt + "_" + paramString;
  }
  
  public Bitmap a(int paramInt1, int paramInt2)
  {
    String str = a(paramInt1, paramInt2);
    Object localObject1;
    if (TextUtils.isEmpty(str))
    {
      localObject1 = null;
      return localObject1;
    }
    if (paramInt2 > 0)
    {
      localObject1 = BaseApplicationImpl.sImageCache.get(a(str, 0));
      if (localObject1 != null) {
        return (Bitmap)localObject1;
      }
    }
    for (;;)
    {
      for (;;)
      {
        Bitmap localBitmap;
        try
        {
          localBitmap = BitmapFactory.decodeFile(str);
          localObject1 = localBitmap;
          if (localBitmap == null) {
            break;
          }
          localObject1 = localBitmap;
          if (3 == paramInt1) {
            break;
          }
          BaseApplicationImpl.sImageCache.put(a(str, 0), localBitmap);
          return localBitmap;
        }
        catch (Exception localException1)
        {
          return null;
        }
        catch (OutOfMemoryError localOutOfMemoryError1)
        {
          if (QLog.isColorLevel()) {
            QLog.e("DoodleResHelper", 2, "getBitmap OOM!");
          }
          System.gc();
        }
        try
        {
          localBitmap = BitmapFactory.decodeFile(str);
          if ((localBitmap != null) && (3 != paramInt1)) {
            BaseApplicationImpl.sImageCache.put(a(str, 0), localBitmap);
          }
          Object localObject2 = localBitmap;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("DoodleResHelper", 2, "reload after gc, succ!");
          return localBitmap;
        }
        catch (Exception localException2)
        {
          continue;
          return null;
        }
        catch (OutOfMemoryError localOutOfMemoryError2) {}
      }
    }
  }
  
  public Drawable a(int paramInt1, int paramInt2)
  {
    if (paramInt2 < 0) {
      return null;
    }
    String str = b(paramInt1, paramInt2);
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    Object localObject = BaseApplicationImpl.sImageCache.get(a(str, 1));
    if (localObject != null) {
      return (Drawable)localObject;
    }
    try
    {
      localObject = BitmapFactory.decodeFile(str);
      localObject = new BitmapDrawable(BaseApplicationImpl.getApplication().getApplicationContext().getResources(), (Bitmap)localObject);
      try
      {
        BaseApplicationImpl.sImageCache.put(a(str, 1), localObject);
        return localObject;
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        return localObject;
      }
      return null;
    }
    catch (OutOfMemoryError localOutOfMemoryError2) {}
  }
  
  public Drawable a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject1 = a(paramInt1, paramInt2);
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = null;
      return localObject1;
    }
    if (paramInt2 > 0)
    {
      localObject1 = new File((String)localObject1);
      Object localObject2 = BaseApplicationImpl.sImageCache;
      Object localObject3 = ((File)localObject1).toURI().toString();
      if (paramBoolean) {}
      for (paramInt2 = 2;; paramInt2 = 3)
      {
        localObject2 = ((MQLruCache)localObject2).get(a((String)localObject3, paramInt2));
        if (localObject2 == null) {
          break;
        }
        return (Drawable)localObject2;
      }
      localObject2 = BaseApplicationImpl.getContext();
      localObject3 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Context)localObject2).getResources().getDrawable(2130837564);
      ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Context)localObject2).getResources().getDrawable(2130837564);
      ((URLDrawable.URLDrawableOptions)localObject3).mExtraInfo = null;
      ((URLDrawable.URLDrawableOptions)localObject3).mUseMemoryCache = false;
      if (paramInt1 == 1)
      {
        ((URLDrawable.URLDrawableOptions)localObject3).mUseUnFinishCache = false;
        label151:
        if ((paramInt1 != 0) && (paramInt1 != 3)) {
          break label226;
        }
        ((URLDrawable.URLDrawableOptions)localObject3).mPlayGifImage = false;
      }
      for (;;)
      {
        localObject2 = URLDrawable.getDrawable((File)localObject1, (URLDrawable.URLDrawableOptions)localObject3);
        if (paramInt1 != 2)
        {
          localObject1 = localObject2;
          if (paramInt1 != 1) {
            break;
          }
        }
        ((URLDrawable)localObject2).setIgnorePause(true);
        return localObject2;
        ((URLDrawable.URLDrawableOptions)localObject3).mUseUnFinishCache = true;
        if (paramBoolean)
        {
          ((URLDrawable.URLDrawableOptions)localObject3).isFlashPic = true;
          break label151;
        }
        ((URLDrawable.URLDrawableOptions)localObject3).isFlashPic = false;
        break label151;
        label226:
        if ((paramInt1 == 2) && (paramBoolean)) {
          ((URLDrawable.URLDrawableOptions)localObject3).mPlayGifImage = true;
        } else if ((paramInt1 == 1) && (paramBoolean)) {
          ((URLDrawable.URLDrawableOptions)localObject3).mPlayGifImage = true;
        }
      }
    }
    return null;
  }
  
  public String a(int paramInt1, int paramInt2)
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (paramInt1 == 0) {
      localObject = ScribbleResMgr.a((QQAppInterface)localObject).b(1, paramInt2);
    }
    for (;;)
    {
      if (!FileUtils.a((String)localObject))
      {
        return null;
        if (paramInt1 == 1)
        {
          localObject = ScribbleResMgr.a((QQAppInterface)localObject).b(2, paramInt2);
          continue;
        }
        if (paramInt1 == 2)
        {
          localObject = ScribbleResMgr.a((QQAppInterface)localObject).b(2, paramInt2);
          localObject = ((String)localObject).substring(0, ((String)localObject).lastIndexOf('.')) + "ex.gif";
          continue;
        }
        if (paramInt1 == 3)
        {
          localObject = ScribbleResMgr.a((QQAppInterface)localObject).b(2, paramInt2);
          localObject = ((String)localObject).substring(0, ((String)localObject).lastIndexOf('.')) + "pre.png";
        }
      }
      else
      {
        return localObject;
      }
      localObject = null;
    }
  }
  
  public List a(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if ((paramInt == 1) || (paramInt == 2))
    {
      localObject = ScribbleResMgr.a((QQAppInterface)localObject).b();
      if ((localObject != null) && (((ArrayList)localObject).size() > 0)) {
        localObject = ((ArrayList)localObject).iterator();
      }
    }
    else
    {
      while (((Iterator)localObject).hasNext())
      {
        ScribbleResMgr.ResInfo localResInfo = (ScribbleResMgr.ResInfo)((Iterator)localObject).next();
        if ((localResInfo.resType == 2) && (localResInfo.isShow == 1) && ((localResInfo.showInApp & 0x2) > 0))
        {
          localArrayList.add(Integer.valueOf(localResInfo.sourceId));
          continue;
          if (paramInt == 0)
          {
            localObject = ScribbleResMgr.a((QQAppInterface)localObject).a();
            if ((localObject != null) && (((ArrayList)localObject).size() > 0))
            {
              localObject = ((ArrayList)localObject).iterator();
              while (((Iterator)localObject).hasNext())
              {
                localResInfo = (ScribbleResMgr.ResInfo)((Iterator)localObject).next();
                if ((localResInfo.resType == 1) && (localResInfo.isShow == 1) && ((localResInfo.showInApp & 0x2) > 0)) {
                  localArrayList.add(Integer.valueOf(localResInfo.sourceId));
                }
              }
            }
          }
        }
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_JavaUtilMap = null;
      return;
    }
    finally {}
  }
  
  public void a(int paramInt1, int paramInt2, View paramView, ScribbleResMgr.ResCallback paramResCallback)
  {
    if (Looper.getMainLooper() != Looper.myLooper()) {
      new Handler(Looper.getMainLooper()).post(new upb(this, paramInt1, paramInt2, paramView, paramResCallback));
    }
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (paramInt1 == 0)
      {
        ScribbleResMgr.a(localQQAppInterface).a(localQQAppInterface, 3, paramInt2, paramView, paramResCallback);
        return;
      }
    } while ((paramInt1 != 1) && (paramInt1 != 2));
    ScribbleResMgr.a(localQQAppInterface).a(localQQAppInterface, 4, paramInt2, paramView, paramResCallback);
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return;
    }
    try
    {
      if (this.jdField_a_of_type_JavaUtilMap == null) {
        return;
      }
    }
    finally {}
    Object localObject = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (((Iterator)localObject).hasNext())
    {
      upd localupd = (upd)((Iterator)localObject).next();
      if ((localupd.jdField_a_of_type_JavaLangRefWeakReference != null) && (localupd.jdField_a_of_type_JavaLangRefWeakReference.get() == paramBitmap))
      {
        localupd.jdField_a_of_type_Boolean = true;
        QLog.d("DoodleResHelper", 2, "releaseBitmap succ:" + this.jdField_a_of_type_JavaUtilMap.size());
        return;
      }
    }
    localObject = new upd(this);
    ((upd)localObject).b = paramBitmap.getHeight();
    ((upd)localObject).jdField_a_of_type_Int = paramBitmap.getWidth();
    ((upd)localObject).jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBitmap);
    ((upd)localObject).jdField_a_of_type_Boolean = true;
    paramBitmap = this.jdField_a_of_type_JavaUtilMap;
    int i = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = (i + 1);
    paramBitmap.put(Integer.valueOf(i), localObject);
    QLog.d("DoodleResHelper", 2, "releaseBitmap add new one:" + this.jdField_a_of_type_JavaUtilMap.size());
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    return !TextUtils.isEmpty(b(paramInt1, paramInt2));
  }
  
  public Bitmap b(int paramInt1, int paramInt2)
  {
    if (paramInt2 < 0) {
      return null;
    }
    String str = b(paramInt1, paramInt2);
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    Object localObject;
    if (paramInt2 > 0)
    {
      localObject = BaseApplicationImpl.sImageCache.get(a(str, 0));
      if (localObject != null) {
        return (Bitmap)localObject;
      }
    }
    try
    {
      localObject = BitmapFactory.decodeFile(str);
      try
      {
        BaseApplicationImpl.sImageCache.put(a(str, 0), localObject);
        return localObject;
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        return localObject;
      }
      return null;
    }
    catch (OutOfMemoryError localOutOfMemoryError2) {}
    return null;
  }
  
  public String b(int paramInt1, int paramInt2)
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (paramInt1 == 0) {
      localObject = ScribbleResMgr.a((QQAppInterface)localObject).a(1, paramInt2);
    }
    for (;;)
    {
      if (!FileUtils.a((String)localObject))
      {
        return null;
        if ((paramInt1 == 2) || (paramInt1 == 1)) {
          localObject = ScribbleResMgr.a((QQAppInterface)localObject).a(2, paramInt2);
        }
      }
      else
      {
        return localObject;
      }
      localObject = null;
    }
  }
  
  public void b(int paramInt1, int paramInt2, View paramView, ScribbleResMgr.ResCallback paramResCallback)
  {
    if (Looper.getMainLooper() != Looper.myLooper()) {
      new Handler(Looper.getMainLooper()).post(new upc(this, paramInt1, paramInt2, paramView, paramResCallback));
    }
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (paramInt1 == 0)
      {
        ScribbleResMgr.a(localQQAppInterface).a(localQQAppInterface, 1, paramInt2, paramView, paramResCallback);
        return;
      }
    } while ((paramInt1 != 1) && (paramInt1 != 2));
    ScribbleResMgr.a(localQQAppInterface).a(localQQAppInterface, 2, paramInt2, paramView, paramResCallback);
  }
  
  public boolean b(int paramInt1, int paramInt2)
  {
    return !TextUtils.isEmpty(a(paramInt1, paramInt2));
  }
  
  public Bitmap c(int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      return null;
    }
    for (;;)
    {
      Object localObject4;
      Object localObject5;
      try
      {
        if (this.jdField_a_of_type_JavaUtilMap == null) {
          this.jdField_a_of_type_JavaUtilMap = new HashMap();
        }
        if (this.jdField_a_of_type_JavaUtilMap.size() <= 0) {
          break label233;
        }
        localObject4 = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
        if (!((Iterator)localObject4).hasNext()) {
          break label233;
        }
        localObject5 = (upd)((Map.Entry)((Iterator)localObject4).next()).getValue();
        if ((localObject5 == null) || (((upd)localObject5).jdField_a_of_type_JavaLangRefWeakReference == null) || (((upd)localObject5).jdField_a_of_type_JavaLangRefWeakReference.get() == null))
        {
          ((Iterator)localObject4).remove();
          QLog.d("DoodleResHelper", 2, "getBitmap remove a invalid item");
          continue;
        }
        if (!((upd)localObject5).jdField_a_of_type_Boolean) {
          continue;
        }
      }
      finally {}
      if ((((upd)localObject5).b == paramInt2) && (((upd)localObject5).jdField_a_of_type_Int == paramInt1))
      {
        if (((upd)localObject5).jdField_a_of_type_JavaLangRefWeakReference != null) {}
        label233:
        Object localObject3;
        for (Object localObject2 = (Bitmap)((upd)localObject5).jdField_a_of_type_JavaLangRefWeakReference.get(); localObject2 != null; localObject3 = null)
        {
          QLog.d("DoodleResHelper", 2, "getBitmap find idle :" + this.jdField_a_of_type_JavaUtilMap.size());
          ((upd)localObject5).jdField_a_of_type_Boolean = false;
          return localObject2;
          QLog.d("DoodleResHelper", 2, "getBitmap add new item");
          localObject2 = new upd(this);
          ((upd)localObject2).b = paramInt2;
          ((upd)localObject2).jdField_a_of_type_Int = paramInt1;
          try
          {
            localObject4 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
            ((upd)localObject2).jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(localObject4);
            ((upd)localObject2).jdField_a_of_type_Boolean = false;
            localObject5 = this.jdField_a_of_type_JavaUtilMap;
            paramInt1 = this.jdField_a_of_type_Int;
            this.jdField_a_of_type_Int = (paramInt1 + 1);
            ((Map)localObject5).put(Integer.valueOf(paramInt1), localObject2);
            QLog.d("DoodleResHelper", 2, "getBitmap create new cache:" + this.jdField_a_of_type_JavaUtilMap.size());
            return localObject4;
          }
          catch (OutOfMemoryError localOutOfMemoryError)
          {
            localOutOfMemoryError.printStackTrace();
            if (QLog.isColorLevel()) {
              QLog.e("DoodleResHelper", 2, "getBitmap exception OOM!" + localOutOfMemoryError.toString());
            }
            if (QLog.isColorLevel()) {
              QLog.d("DoodleResHelper", 2, "getBitmap error!");
            }
            return null;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.e("DoodleResHelper", 2, "getBitmap exception:" + localException);
              }
            }
          }
        }
      }
    }
  }
  
  public boolean c(int paramInt1, int paramInt2)
  {
    return (b(paramInt1, paramInt2)) && (a(paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.DoodleResHelper
 * JD-Core Version:    0.7.0.1
 */