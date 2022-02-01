package com.tencent.aelight.camera.aioeditor.takevideo.doodle.util;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.LocationFacePackage.Item;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.LocationFacePackage.Item.ItemParams;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.FaceLayer.LayerParams;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.model.SelectedItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.richmedia.capture.data.DynamicStickerData;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DoodleUtil
{
  private static int a(@NonNull String paramString, int paramInt1, int paramInt2)
  {
    Object localObject;
    if ((paramInt1 > 0) && (paramInt2 > 0) && (!StringUtil.a(paramString)))
    {
      localObject = new TextPaint();
      ((TextPaint)localObject).setTextSize(paramInt1);
      paramString = new StaticLayout(paramString, (TextPaint)localObject, paramInt2, Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false);
      localObject = new Rect();
      paramString.getLineBounds(0, (Rect)localObject);
      return ((Rect)localObject).height();
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getLineHeight quit:");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("DoodleUtil", 2, ((StringBuilder)localObject).toString());
    }
    return 1;
  }
  
  public static FaceLayer.LayerParams a(LocationFacePackage.Item paramItem, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    if (!a(paramItem)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("item:");
    localStringBuilder.append(paramItem.toString());
    SLog.b("DoodleUtil", localStringBuilder.toString());
    int i;
    if (paramItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      i = paramItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getBounds().width();
      paramInt2 = paramItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getBounds().height();
    }
    else
    {
      paramInt2 = 0;
      i = 0;
    }
    float f2 = paramItem.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceLocationFacePackage$Item$ItemParams.c;
    float f1 = paramItem.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceLocationFacePackage$Item$ItemParams.d;
    float f3 = paramItem.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceLocationFacePackage$Item$ItemParams.e;
    f2 = f2 * (paramInt1 / f3) / i;
    paramInt1 = (int)(paramItem.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceLocationFacePackage$Item$ItemParams.b / f1 * paramInt2);
    paramItem = new FaceLayer.LayerParams(paramFloat1, paramFloat2, f2, 0.0F, 0.0F, 0.0F, i, paramInt2 + a(paramItem.b, paramInt1, i) * 2 + 32, paramItem.b, Color.parseColor(paramItem.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceLocationFacePackage$Item$ItemParams.a), paramInt1);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("LayerParams:");
    localStringBuilder.append(paramItem.toString());
    SLog.b("DoodleUtil", localStringBuilder.toString());
    return paramItem;
  }
  
  public static FaceLayer.LayerParams a(LocationFacePackage.Item paramItem, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (!a(paramItem)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("item:");
    localStringBuilder.append(paramItem.toString());
    SLog.b("DoodleUtil", localStringBuilder.toString());
    int i;
    if (paramItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      i = paramItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getBounds().width();
      paramInt2 = paramItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getBounds().height();
    }
    else
    {
      paramInt2 = 0;
      i = 0;
    }
    int j = paramItem.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceLocationFacePackage$Item$ItemParams.c;
    float f = paramItem.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceLocationFacePackage$Item$ItemParams.d;
    paramFloat3 = paramInt1 * paramFloat3 / i;
    paramInt1 = (int)(paramItem.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceLocationFacePackage$Item$ItemParams.b / f * paramInt2);
    paramItem = new FaceLayer.LayerParams(paramFloat1, paramFloat2, paramFloat3, 0.0F, 0.0F, 0.0F, i, paramInt2 + a(paramItem.b, paramInt1, i) * 2 + 32, paramItem.b, Color.parseColor(paramItem.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceLocationFacePackage$Item$ItemParams.a), paramInt1);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("LayerParams:");
    localStringBuilder.append(paramItem.toString());
    SLog.b("DoodleUtil", localStringBuilder.toString());
    return paramItem;
  }
  
  public static FaceLayer.LayerParams a(SelectedItem paramSelectedItem, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return new FaceLayer.LayerParams(paramFloat1, paramFloat2, paramFloat3, 0.0F, 0.0F, 0.0F, paramSelectedItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth(), paramSelectedItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight());
  }
  
  public static String a(ArrayList<DynamicStickerData> paramArrayList)
  {
    if (paramArrayList.isEmpty()) {
      return null;
    }
    Object localObject = new JSONArray();
    try
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        DynamicStickerData localDynamicStickerData = (DynamicStickerData)paramArrayList.next();
        if (localDynamicStickerData != null)
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("centerP_x", localDynamicStickerData.centerP.x);
          localJSONObject.put("centerP_y", localDynamicStickerData.centerP.y);
          localJSONObject.put("scale", localDynamicStickerData.scale);
          localJSONObject.put("rotate", localDynamicStickerData.rotate);
          localJSONObject.put("translateX", localDynamicStickerData.translateX);
          localJSONObject.put("translateY", localDynamicStickerData.translateY);
          localJSONObject.put("width", localDynamicStickerData.width);
          localJSONObject.put("height", localDynamicStickerData.height);
          localJSONObject.put("path", localDynamicStickerData.path);
          localJSONObject.put("type", localDynamicStickerData.type);
          localJSONObject.put("data", localDynamicStickerData.data);
          localJSONObject.put("layerWidth", localDynamicStickerData.layerWidth);
          localJSONObject.put("layerHeight", localDynamicStickerData.layerHeight);
          ((JSONArray)localObject).put(localJSONObject);
        }
      }
      paramArrayList = new JSONObject();
      paramArrayList.put("list", localObject);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("DynamicStickersToJson result= ");
        ((StringBuilder)localObject).append(paramArrayList.toString());
        QLog.d("DoodleUtil", 2, ((StringBuilder)localObject).toString());
      }
      paramArrayList = paramArrayList.toString();
      return paramArrayList;
    }
    catch (JSONException paramArrayList)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("e= ");
        ((StringBuilder)localObject).append(paramArrayList);
        QLog.d("DoodleUtil", 2, ((StringBuilder)localObject).toString());
      }
    }
    return null;
  }
  
  public static void a(Bitmap paramBitmap, int paramInt)
  {
    int[] arrayOfInt = new int[paramInt * paramInt];
    int i4 = paramBitmap.getHeight() / paramInt;
    int i5 = paramBitmap.getWidth() / paramInt;
    int i6 = paramBitmap.getHeight() % paramInt;
    int i7 = paramBitmap.getWidth() % paramInt;
    int n;
    int m;
    int i8;
    int i1;
    int j;
    int k;
    int i2;
    int i3;
    for (int i = 0; i < i4; i = m + 1)
    {
      n = 0;
      m = i;
      while (n < i5)
      {
        i8 = m * paramInt;
        int i9 = n * paramInt;
        paramBitmap.getPixels(arrayOfInt, 0, paramInt, i9, i8, paramInt, paramInt);
        i1 = 0;
        i = 0;
        j = 0;
        for (k = 0; i1 < paramInt; k = i2)
        {
          i2 = i;
          i3 = 0;
          i = k;
          k = i2;
          i2 = i3;
          while (i2 < paramInt)
          {
            i3 = arrayOfInt[(i1 * paramInt + i2)];
            k += (i3 >> 16 & 0xFF);
            j += (i3 >> 8 & 0xFF);
            i += (i3 & 0xFF);
            i2 += 1;
          }
          i1 += 1;
          i2 = i;
          i = k;
        }
        i1 = i / paramInt / paramInt;
        i2 = j / paramInt / paramInt;
        k = k / paramInt / paramInt;
        i = 0;
        while (i < paramInt)
        {
          j = 0;
          while (j < paramInt)
          {
            arrayOfInt[(i * paramInt + j)] = (i1 << 16 | 0xFF000000 | i2 << 8 | k);
            j += 1;
          }
          i += 1;
        }
        paramBitmap.setPixels(arrayOfInt, 0, paramInt, i9, i8, paramInt, paramInt);
        n += 1;
      }
    }
    if (i7 > 0)
    {
      m = 0;
      while (m < i4)
      {
        i2 = m * paramInt;
        i8 = i5 * paramInt;
        n = 0;
        i = 0;
        j = 0;
        for (k = 0; n < paramInt; k = i1)
        {
          i1 = i;
          i3 = 0;
          i = k;
          k = i1;
          i1 = i3;
          while (i1 < i7)
          {
            i3 = paramBitmap.getPixel(i8 + i1, i2 + n);
            k += (i3 >> 16 & 0xFF);
            j += (i3 >> 8 & 0xFF);
            i += (i3 & 0xFF);
            i1 += 1;
          }
          n += 1;
          i1 = i;
          i = k;
        }
        n = i / paramInt / i7;
        i1 = j / paramInt / i7;
        i3 = k / paramInt / i7;
        i = 0;
        j = i2;
        while (i < paramInt)
        {
          k = 0;
          while (k < i7)
          {
            paramBitmap.setPixel(i8 + k, j + i, n << 16 | 0xFF000000 | i1 << 8 | i3);
            k += 1;
          }
          i += 1;
        }
        m += 1;
      }
    }
    if (i6 > 0)
    {
      m = 0;
      while (m < i5)
      {
        i3 = i4 * paramInt;
        i7 = m * paramInt;
        n = 0;
        i = 0;
        j = 0;
        for (k = 0; n < i6; k = i1)
        {
          i1 = i;
          i2 = 0;
          i = k;
          k = i1;
          i1 = i2;
          while (i1 < paramInt)
          {
            i2 = paramBitmap.getPixel(i7 + i1, i3 + n);
            k += (i2 >> 16 & 0xFF);
            j += (i2 >> 8 & 0xFF);
            i += (i2 & 0xFF);
            i1 += 1;
          }
          n += 1;
          i1 = i;
          i = k;
        }
        n = i / paramInt / i6;
        i1 = j / paramInt / i6;
        k = k / paramInt / i6;
        i = 0;
        while (i < i6)
        {
          j = 0;
          while (j < paramInt)
          {
            paramBitmap.setPixel(i7 + j, i3 + i, n << 16 | 0xFF000000 | i1 << 8 | k);
            j += 1;
          }
          i += 1;
        }
        m += 1;
      }
    }
  }
  
  public static boolean a(LocationFacePackage.Item paramItem)
  {
    if (paramItem == null)
    {
      SLog.e("DoodleUtil", "item is null.");
      return false;
    }
    if (TextUtils.isEmpty(paramItem.e))
    {
      SLog.e("DoodleUtil", "item layoutJson is empty,can't parse.");
      return false;
    }
    StringBuilder localStringBuilder1;
    if (!paramItem.a())
    {
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("parseJson error:");
      localStringBuilder1.append(paramItem.e);
      SLog.e("DoodleUtil", localStringBuilder1.toString());
      return false;
    }
    if (paramItem.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceLocationFacePackage$Item$ItemParams.b < 0)
    {
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("item textSize < 0. textSize:");
      localStringBuilder1.append(paramItem.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceLocationFacePackage$Item$ItemParams.b);
      SLog.e("DoodleUtil", localStringBuilder1.toString());
      return false;
    }
    if ((paramItem.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceLocationFacePackage$Item$ItemParams.c > 0) && (paramItem.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceLocationFacePackage$Item$ItemParams.d > 0))
    {
      if ((paramItem.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceLocationFacePackage$Item$ItemParams.e > 0) && (paramItem.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceLocationFacePackage$Item$ItemParams.f > 0)) {
        try
        {
          Color.parseColor(paramItem.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceLocationFacePackage$Item$ItemParams.a);
          return true;
        }
        catch (Exception localException)
        {
          StringBuilder localStringBuilder3 = new StringBuilder();
          localStringBuilder3.append("item color is illegal:");
          localStringBuilder3.append(paramItem.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceLocationFacePackage$Item$ItemParams.a);
          SLog.e("DoodleUtil", localStringBuilder3.toString());
          localException.printStackTrace();
          return false;
        }
      }
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("item standardWidth <= 0 or item standardHeight <= 0. standardWidth:");
      localStringBuilder2.append(paramItem.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceLocationFacePackage$Item$ItemParams.e);
      localStringBuilder2.append(",standardHeight:");
      localStringBuilder2.append(paramItem.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceLocationFacePackage$Item$ItemParams.f);
      SLog.e("DoodleUtil", localStringBuilder2.toString());
      return false;
    }
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("item pictureWidth <= 0 or item pictureHeight <= 0. pictureWidth:");
    localStringBuilder2.append(paramItem.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceLocationFacePackage$Item$ItemParams.c);
    localStringBuilder2.append(",pictureHeight:");
    localStringBuilder2.append(paramItem.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceLocationFacePackage$Item$ItemParams.d);
    SLog.e("DoodleUtil", localStringBuilder2.toString());
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.util.DoodleUtil
 * JD-Core Version:    0.7.0.1
 */