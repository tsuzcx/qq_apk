package com.tencent.biz.pubaccount.readinjoy.view.imageloader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BitmapCache
{
  public static final String a;
  int jdField_a_of_type_Int = 0;
  BytePool jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderBytePool = new BytePool(2097152);
  Releaser<Bitmap> jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderReleaser;
  List<byte[]> jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new LinkedList());
  int jdField_b_of_type_Int = 0;
  final List<SoftReference<Bitmap>> jdField_b_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
  
  static
  {
    jdField_a_of_type_JavaLangString = "zimage." + BitmapCache.class.getSimpleName();
  }
  
  BitmapCache(int paramInt)
  {
    while (paramInt < 5)
    {
      this.jdField_a_of_type_JavaUtilList.add(new byte[16384]);
      paramInt += 1;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderReleaser = new BitmapCache.1(this);
  }
  
  public static CloseableBitmap a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (GlobalImageCache.a != null)
    {
      paramString = GlobalImageCache.a.get(paramString);
      if ((paramString instanceof CloseableBitmap)) {
        return (CloseableBitmap)paramString;
      }
    }
    return null;
  }
  
  public static void a(String paramString, CloseableBitmap paramCloseableBitmap)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramCloseableBitmap == null)) {}
    while (GlobalImageCache.a == null) {
      return;
    }
    GlobalImageCache.a.put(paramString, paramCloseableBitmap);
  }
  
  Bitmap a(BitmapFactory.Options paramOptions)
  {
    for (;;)
    {
      int i;
      try
      {
        this.jdField_b_of_type_Int += 1;
        ArrayList localArrayList = new ArrayList();
        List localList = this.jdField_b_of_type_JavaUtilList;
        i = 0;
        try
        {
          if (i < this.jdField_b_of_type_JavaUtilList.size())
          {
            localBitmap = (Bitmap)((SoftReference)this.jdField_b_of_type_JavaUtilList.get(i)).get();
            if (localBitmap != null)
            {
              if (Utils.a(localBitmap, paramOptions))
              {
                localArrayList.add(this.jdField_b_of_type_JavaUtilList.get(i));
                str = "cache";
                if (!localArrayList.isEmpty()) {
                  this.jdField_b_of_type_JavaUtilList.removeAll(localArrayList);
                }
                if (localBitmap != null) {
                  this.jdField_a_of_type_Int += 1;
                }
                if (QLog.isColorLevel()) {
                  Utils.a(jdField_a_of_type_JavaLangString, "getReuseableBitmap found:" + str + " picSize:" + paramOptions.outWidth + "x" + paramOptions.outHeight + " bitmap:" + localBitmap + " state:" + toString());
                }
                return localBitmap;
              }
            }
            else {
              localArrayList.add(this.jdField_b_of_type_JavaUtilList.get(i));
            }
          }
        }
        finally {}
        String str = "notFound";
      }
      finally {}
      Bitmap localBitmap = null;
      continue;
      i += 1;
    }
  }
  
  CloseableBitmap a(ImageRequest paramImageRequest)
  {
    if (paramImageRequest == null) {}
    do
    {
      return null;
      paramImageRequest = a(paramImageRequest.a());
    } while (paramImageRequest == null);
    try
    {
      if (paramImageRequest.a())
      {
        CloseableBitmap localCloseableBitmap = paramImageRequest.a();
        return localCloseableBitmap;
      }
    }
    finally {}
    return null;
  }
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderBytePool.a();
      this.jdField_b_of_type_JavaUtilList.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  void a(ImageRequest paramImageRequest, CloseableBitmap paramCloseableBitmap)
  {
    if (paramImageRequest == null) {}
    for (;;)
    {
      return;
      try
      {
        a(paramImageRequest.a(), paramCloseableBitmap);
      }
      finally {}
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("total:");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(" reuse:");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    if (this.jdField_b_of_type_Int > 0) {
      localStringBuilder.append(" rate:").append(this.jdField_a_of_type_Int / this.jdField_b_of_type_Int);
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.imageloader.BitmapCache
 * JD-Core Version:    0.7.0.1
 */