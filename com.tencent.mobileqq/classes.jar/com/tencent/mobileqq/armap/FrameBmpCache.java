package com.tencent.mobileqq.armap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.memory.MemoryManager;
import java.util.LinkedList;
import java.util.List;

public class FrameBmpCache
{
  public int a;
  private long jdField_a_of_type_Long;
  Resources jdField_a_of_type_AndroidContentResResources;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  public MQLruCache<String, Object> a;
  volatile FrameBmpCache.CancelAbleRunnable jdField_a_of_type_ComTencentMobileqqArmapFrameBmpCache$CancelAbleRunnable;
  private FrameBmpCache.EndListener jdField_a_of_type_ComTencentMobileqqArmapFrameBmpCache$EndListener;
  Object jdField_a_of_type_JavaLangObject;
  LinkedList<FrameBmpCache.CancelAbleRunnable> jdField_a_of_type_JavaUtilLinkedList;
  public List<String> a;
  public boolean a;
  public int b;
  private long b;
  public boolean b;
  private int jdField_c_of_type_Int;
  private volatile boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private volatile boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean;
  
  public FrameBmpCache(Resources paramResources)
  {
    this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache = GlobalImageCache.jdField_a_of_type_AndroidSupportV4UtilMQLruCache;
    this.jdField_a_of_type_Int = 10;
    int i = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Long = (1000 / i);
    this.jdField_b_of_type_Int = ((int)(i / 2.0F));
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_c_of_type_Int = -1;
    this.jdField_d_of_type_Int = 0;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = true;
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
      localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inPreferredConfig = Bitmap.Config.RGB_565;
      if ((this.jdField_f_of_type_Boolean) && (this.jdField_a_of_type_AndroidContentResResources.getDisplayMetrics().density >= 2.0F)) {
        ((BitmapFactory.Options)localObject).inSampleSize = 1;
      } else {
        ((BitmapFactory.Options)localObject).inSampleSize = 2;
      }
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
      paramString = BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
      return paramString;
    }
    catch (OutOfMemoryError paramString)
    {
      if (QLog.isColorLevel())
      {
        QLog.e("FrameBmpCache", 2, "decodeBitmap oom", paramString);
        return null;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ecodeBitmap oom ");
      ((StringBuilder)localObject).append(paramString.getMessage());
      QLog.e("FrameBmpCache", 2, ((StringBuilder)localObject).toString());
    }
    return null;
  }
  
  private void b(int paramInt)
  {
    int i;
    int j;
    Object localObject3;
    label228:
    label235:
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      LinkedList localLinkedList = new LinkedList();
      i = paramInt;
      j = 0;
      if ((i < paramInt + 3) && ((i < this.jdField_a_of_type_JavaUtilList.size()) || (this.jdField_e_of_type_Boolean)))
      {
        Object localObject1 = (String)this.jdField_a_of_type_JavaUtilList.get(a(i));
        if (this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get(localObject1) != null)
        {
          break label235;
          localObject1 = localObject3;
          if (j < this.jdField_a_of_type_JavaUtilLinkedList.size())
          {
            if (a(((FrameBmpCache.CancelAbleRunnable)this.jdField_a_of_type_JavaUtilLinkedList.get(j)).jdField_a_of_type_Int) != a(i)) {
              break label228;
            }
            localObject1 = (FrameBmpCache.CancelAbleRunnable)this.jdField_a_of_type_JavaUtilLinkedList.remove(j);
          }
          localObject3 = localObject1;
          if (localObject1 == null) {
            localObject3 = new FrameBmpCache.CancelAbleRunnable(this, i);
          }
          localLinkedList.add(localObject3);
          break label235;
        }
      }
      else
      {
        if (localLinkedList.size() > 0)
        {
          this.jdField_a_of_type_JavaUtilLinkedList.addAll(0, localLinkedList);
          if (this.jdField_a_of_type_ComTencentMobileqqArmapFrameBmpCache$CancelAbleRunnable == null) {
            d();
          }
        }
        return;
      }
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqArmapFrameBmpCache$CancelAbleRunnable = ((FrameBmpCache.CancelAbleRunnable)this.jdField_a_of_type_JavaUtilLinkedList.poll());
    if (this.jdField_a_of_type_ComTencentMobileqqArmapFrameBmpCache$CancelAbleRunnable != null)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("keepRunning ");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqArmapFrameBmpCache$CancelAbleRunnable);
        QLog.i("FrameBmpCache", 2, localStringBuilder.toString());
      }
      ThreadManager.postImmediately(this.jdField_a_of_type_ComTencentMobileqqArmapFrameBmpCache$CancelAbleRunnable, null, true);
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return;
    }
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
      if (this.jdField_a_of_type_ComTencentMobileqqArmapFrameBmpCache$CancelAbleRunnable != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqArmapFrameBmpCache$CancelAbleRunnable.a();
        this.jdField_a_of_type_ComTencentMobileqqArmapFrameBmpCache$CancelAbleRunnable = null;
      }
      return;
    }
  }
  
  public Bitmap a()
  {
    boolean bool = this.jdField_c_of_type_Boolean;
    Object localObject = null;
    if (bool)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FrameBmpCache", 2, "getCurrentBitmap, isStop");
      }
      if (this.jdField_d_of_type_Boolean) {
        localObject = this.jdField_a_of_type_AndroidGraphicsBitmap;
      }
      return localObject;
    }
    int j = (int)(System.currentTimeMillis() - this.jdField_b_of_type_Long);
    int i = this.jdField_c_of_type_Int;
    this.jdField_c_of_type_Int = ((int)(j / this.jdField_a_of_type_Long));
    if (this.jdField_c_of_type_Int != i) {
      b(i + 1);
    }
    if (this.jdField_c_of_type_Int < i) {
      this.jdField_c_of_type_Int = i;
    }
    if ((this.jdField_c_of_type_Int >= this.jdField_a_of_type_JavaUtilList.size()) && (!this.jdField_e_of_type_Boolean))
    {
      this.jdField_c_of_type_Int = (this.jdField_a_of_type_JavaUtilList.size() - 1);
      this.jdField_b_of_type_Boolean = true;
      localObject = this.jdField_a_of_type_ComTencentMobileqqArmapFrameBmpCache$EndListener;
      if (localObject != null) {
        ((FrameBmpCache.EndListener)localObject).a(null);
      }
      if (this.jdField_d_of_type_Boolean) {
        return (Bitmap)this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get(this.jdField_a_of_type_JavaUtilList.get(a(this.jdField_c_of_type_Int)));
      }
      return null;
    }
    Bitmap localBitmap = (Bitmap)this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get(this.jdField_a_of_type_JavaUtilList.get(a(this.jdField_c_of_type_Int)));
    localObject = localBitmap;
    if (localBitmap == null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getCurrentBitmap, cant find bitmap in cache, index=");
        ((StringBuilder)localObject).append(this.jdField_c_of_type_Int);
        QLog.i("FrameBmpCache", 2, ((StringBuilder)localObject).toString());
      }
      localBitmap = (Bitmap)this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get(this.jdField_a_of_type_JavaUtilList.get(a(this.jdField_d_of_type_Int)));
      localObject = localBitmap;
      if (localBitmap != null)
      {
        this.jdField_c_of_type_Int = this.jdField_d_of_type_Int;
        localObject = localBitmap;
      }
    }
    j = this.jdField_c_of_type_Int;
    if ((j != i) && (j - i != 1)) {
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
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if ((localObject != null) && (paramInt >= 0) && (paramInt < ((List)localObject).size()))
    {
      String str = (String)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      Bitmap localBitmap = (Bitmap)this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get(str);
      localObject = localBitmap;
      if (localBitmap == null)
      {
        localObject = a(str);
        this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.put(str, localObject);
      }
      return localObject;
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
        FrameBmpCache.CancelAbleRunnable localCancelAbleRunnable = new FrameBmpCache.CancelAbleRunnable(this, i);
        this.jdField_a_of_type_JavaUtilLinkedList.add(localCancelAbleRunnable);
        i += 1;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqArmapFrameBmpCache$CancelAbleRunnable == null) {
        d();
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    paramInt = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Long = (1000 / paramInt);
    this.jdField_b_of_type_Int = ((int)(paramInt / 2.0F));
  }
  
  public void a(FrameBmpCache.EndListener paramEndListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqArmapFrameBmpCache$EndListener = paramEndListener;
  }
  
  public void a(List<String> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_f_of_type_Int = 0;
    this.jdField_c_of_type_Boolean = false;
    if (MemoryManager.a() <= 37748736L) {
      this.jdField_f_of_type_Boolean = false;
    }
    paramList = new StringBuilder();
    paramList.append("mUseHighQuality=");
    paramList.append(this.jdField_f_of_type_Boolean);
    QLog.d("FrameBmpCache", 1, paramList.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.armap.FrameBmpCache
 * JD-Core Version:    0.7.0.1
 */