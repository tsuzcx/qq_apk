package com.tencent.mobileqq.armap;

import abjw;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.MemoryManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.armap.wealthgod.ARMapDPC;
import com.tencent.mobileqq.armap.wealthgod.SplashBitmapUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;
import java.util.List;

public class FrameBmpCache
{
  public int a;
  private long jdField_a_of_type_Long = 1000 / this.jdField_a_of_type_Int;
  volatile abjw jdField_a_of_type_Abjw;
  Resources jdField_a_of_type_AndroidContentResResources;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  public MQLruCache a;
  private FrameBmpCache.EndListener jdField_a_of_type_ComTencentMobileqqArmapFrameBmpCache$EndListener;
  public Object a;
  LinkedList jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  public List a;
  public boolean a;
  public int b;
  private long b;
  public boolean b;
  private int jdField_c_of_type_Int = -1;
  private volatile boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private volatile boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean = true;
  
  public FrameBmpCache(Resources paramResources)
  {
    this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache = BaseApplicationImpl.sImageCache;
    this.jdField_a_of_type_Int = 10;
    this.jdField_b_of_type_Int = ((int)(this.jdField_a_of_type_Int / 2.0F));
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_AndroidContentResResources = paramResources;
  }
  
  private int a(int paramInt)
  {
    return paramInt % this.jdField_a_of_type_JavaUtilList.size();
  }
  
  private Bitmap a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
      if ((!this.jdField_f_of_type_Boolean) || (this.jdField_a_of_type_AndroidContentResResources.getDisplayMetrics().density < 2.0F)) {}
      for (localOptions.inSampleSize = 2;; localOptions.inSampleSize = 1)
      {
        localOptions.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(paramString, localOptions);
      }
      return null;
    }
    catch (OutOfMemoryError paramString)
    {
      if (QLog.isColorLevel())
      {
        QLog.e("FrameBmpCache", 2, "decodeBitmap oom", paramString);
        return null;
      }
      QLog.e("FrameBmpCache", 2, "ecodeBitmap oom " + paramString.getMessage());
    }
  }
  
  private void b(int paramInt)
  {
    for (;;)
    {
      int i;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        LinkedList localLinkedList = new LinkedList();
        i = paramInt;
        if ((i >= paramInt + 3) || ((i >= this.jdField_a_of_type_JavaUtilList.size()) && (!this.jdField_e_of_type_Boolean)))
        {
          if (localLinkedList.size() > 0)
          {
            this.jdField_a_of_type_JavaUtilLinkedList.addAll(0, localLinkedList);
            if (this.jdField_a_of_type_Abjw == null) {
              d();
            }
          }
          return;
        }
        Object localObject1 = (String)this.jdField_a_of_type_JavaUtilList.get(a(i));
        if (this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get(localObject1) == null) {
          break label224;
        }
        break label217;
        if (j >= this.jdField_a_of_type_JavaUtilLinkedList.size()) {
          break label211;
        }
        if (a(((abjw)this.jdField_a_of_type_JavaUtilLinkedList.get(j)).jdField_a_of_type_Int) == a(i))
        {
          localObject1 = (abjw)this.jdField_a_of_type_JavaUtilLinkedList.remove(j);
          Object localObject4 = localObject1;
          if (localObject1 == null) {
            localObject4 = new abjw(this, i);
          }
          localLinkedList.add(localObject4);
        }
      }
      j += 1;
      continue;
      label211:
      Object localObject3 = null;
      continue;
      label217:
      i += 1;
      continue;
      label224:
      int j = 0;
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_Abjw = ((abjw)this.jdField_a_of_type_JavaUtilLinkedList.poll());
    if (this.jdField_a_of_type_Abjw != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FrameBmpCache", 2, "keepRunning " + this.jdField_a_of_type_Abjw);
      }
      ThreadManager.postImmediately(this.jdField_a_of_type_Abjw, null, true);
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        Bitmap localBitmap = (Bitmap)this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get(this.jdField_a_of_type_JavaUtilList.get(i));
        if ((localBitmap != null) && (localBitmap != this.jdField_a_of_type_AndroidGraphicsBitmap)) {
          this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.remove(this.jdField_a_of_type_JavaUtilList.get(i));
        }
        i += 1;
      }
    }
  }
  
  private void f()
  {
    this.jdField_c_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Int = -1;
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = 0;
    this.jdField_a_of_type_Long = (1000 / this.jdField_a_of_type_Int);
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilLinkedList.clear();
      if (this.jdField_a_of_type_Abjw != null)
      {
        this.jdField_a_of_type_Abjw.a();
        this.jdField_a_of_type_Abjw = null;
      }
      return;
    }
  }
  
  public Bitmap a()
  {
    Object localObject = null;
    if (this.jdField_c_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FrameBmpCache", 2, "getCurrentBitmap, isStop");
      }
      if (this.jdField_d_of_type_Boolean) {
        localObject = this.jdField_a_of_type_AndroidGraphicsBitmap;
      }
    }
    int i;
    int j;
    do
    {
      return localObject;
      i = (int)(System.currentTimeMillis() - this.jdField_b_of_type_Long);
      j = this.jdField_c_of_type_Int;
      this.jdField_c_of_type_Int = ((int)(i / this.jdField_a_of_type_Long));
      if (this.jdField_c_of_type_Int != j) {
        b(j + 1);
      }
      if (this.jdField_c_of_type_Int < j) {
        this.jdField_c_of_type_Int = j;
      }
      if ((this.jdField_c_of_type_Int < this.jdField_a_of_type_JavaUtilList.size()) || (this.jdField_e_of_type_Boolean)) {
        break;
      }
      this.jdField_c_of_type_Int = (this.jdField_a_of_type_JavaUtilList.size() - 1);
      this.jdField_b_of_type_Boolean = true;
      if (this.jdField_a_of_type_ComTencentMobileqqArmapFrameBmpCache$EndListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqArmapFrameBmpCache$EndListener.a(null);
      }
    } while (!this.jdField_d_of_type_Boolean);
    return (Bitmap)this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get(this.jdField_a_of_type_JavaUtilList.get(a(this.jdField_c_of_type_Int)));
    Bitmap localBitmap = (Bitmap)this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get(this.jdField_a_of_type_JavaUtilList.get(a(this.jdField_c_of_type_Int)));
    localObject = localBitmap;
    if (localBitmap == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FrameBmpCache", 2, "getCurrentBitmap, cant find bitmap in cache, index=" + this.jdField_c_of_type_Int);
      }
      localBitmap = (Bitmap)this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get(this.jdField_a_of_type_JavaUtilList.get(a(this.jdField_d_of_type_Int)));
      localObject = localBitmap;
      if (localBitmap != null)
      {
        this.jdField_c_of_type_Int = this.jdField_d_of_type_Int;
        localObject = localBitmap;
      }
    }
    if ((this.jdField_c_of_type_Int != j) && (this.jdField_c_of_type_Int - j != 1)) {
      this.jdField_e_of_type_Int += 1;
    }
    if (localObject != null) {
      this.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      i = this.jdField_c_of_type_Int - 1;
      if ((i > 0) && (i < this.jdField_a_of_type_JavaUtilList.size()))
      {
        localObject = (String)this.jdField_a_of_type_JavaUtilList.get(i);
        this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.remove(localObject);
      }
    }
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  public Bitmap a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size()))
    {
      String str = (String)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      Bitmap localBitmap2 = (Bitmap)this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get(str);
      Bitmap localBitmap1 = localBitmap2;
      if (localBitmap2 == null)
      {
        localBitmap1 = a(str);
        this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.put(str, localBitmap1);
      }
      return localBitmap1;
    }
    return null;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("FrameBmpCache", 2, "startDecode");
    }
    Object localObject1 = this.jdField_a_of_type_JavaLangObject;
    int i = 0;
    try
    {
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        abjw localabjw = new abjw(this, i);
        this.jdField_a_of_type_JavaUtilLinkedList.add(localabjw);
        i += 1;
      }
      if (this.jdField_a_of_type_Abjw == null) {
        d();
      }
      return;
    }
    finally {}
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Long = (1000 / this.jdField_a_of_type_Int);
    this.jdField_b_of_type_Int = ((int)(this.jdField_a_of_type_Int / 2.0F));
  }
  
  public void a(FrameBmpCache.EndListener paramEndListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqArmapFrameBmpCache$EndListener = paramEndListener;
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_f_of_type_Int = 0;
    this.jdField_c_of_type_Boolean = false;
    if ((MemoryManager.a() <= 37748736L) || (SplashBitmapUtils.a().jdField_a_of_type_Boolean)) {
      this.jdField_f_of_type_Boolean = false;
    }
    QLog.d("FrameBmpCache", 1, "mUseHighQuality=" + this.jdField_f_of_type_Boolean);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilList != null;
  }
  
  public void b()
  {
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = 0;
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get(this.jdField_a_of_type_JavaUtilList.get(this.jdField_c_of_type_Int)));
    this.jdField_c_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public void c()
  {
    if (a())
    {
      f();
      e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.FrameBmpCache
 * JD-Core Version:    0.7.0.1
 */