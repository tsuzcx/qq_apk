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
import com.tencent.mobileqq.richmedia.capture.data.DynamicStickerData;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.mobileqq.richmedia.capture.data.TrackerStickerParam;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bnnm
{
  private static int a(@NonNull String paramString, int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0) || (StringUtil.isEmpty(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoodleUtil", 2, "getLineHeight quit:" + paramInt1 + " " + paramInt2 + " " + paramString);
      }
      return 1;
    }
    Object localObject = new TextPaint();
    ((TextPaint)localObject).setTextSize(paramInt1);
    paramString = new StaticLayout(paramString, (TextPaint)localObject, paramInt2, Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false);
    localObject = new Rect();
    paramString.getLineBounds(0, (Rect)localObject);
    return ((Rect)localObject).height();
  }
  
  public static bngh a(bnhe parambnhe, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return new bngh(paramFloat1, paramFloat2, paramFloat3, 0.0F, 0.0F, 0.0F, parambnhe.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth(), parambnhe.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight());
  }
  
  public static bngh a(bnll parambnll, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    if (!a(parambnll)) {
      return null;
    }
    xvv.b("DoodleUtil", "item:" + parambnll.toString());
    int i = 0;
    paramInt2 = 0;
    if (parambnll.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      i = parambnll.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getBounds().width();
      paramInt2 = parambnll.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getBounds().height();
    }
    float f2 = parambnll.jdField_a_of_type_Bnlm.c;
    float f1 = parambnll.jdField_a_of_type_Bnlm.d;
    float f3 = parambnll.jdField_a_of_type_Bnlm.e;
    f2 = f2 * (paramInt1 / f3) / i;
    paramInt1 = (int)(parambnll.jdField_a_of_type_Bnlm.b / f1 * paramInt2);
    parambnll = new bngh(paramFloat1, paramFloat2, f2, 0.0F, 0.0F, 0.0F, i, paramInt2 + a(parambnll.b, paramInt1, i) * 2 + 32, parambnll.b, Color.parseColor(parambnll.jdField_a_of_type_Bnlm.a), paramInt1);
    xvv.b("DoodleUtil", "LayerParams:" + parambnll.toString());
    return parambnll;
  }
  
  public static bngh a(bnll parambnll, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (!a(parambnll)) {
      return null;
    }
    xvv.b("DoodleUtil", "item:" + parambnll.toString());
    int i = 0;
    paramInt2 = 0;
    if (parambnll.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      i = parambnll.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getBounds().width();
      paramInt2 = parambnll.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getBounds().height();
    }
    float f = parambnll.jdField_a_of_type_Bnlm.c;
    f = parambnll.jdField_a_of_type_Bnlm.d;
    paramFloat3 = paramInt1 * paramFloat3 / i;
    paramInt1 = (int)(parambnll.jdField_a_of_type_Bnlm.b / f * paramInt2);
    parambnll = new bngh(paramFloat1, paramFloat2, paramFloat3, 0.0F, 0.0F, 0.0F, i, paramInt2 + a(parambnll.b, paramInt1, i) * 2 + 32, parambnll.b, Color.parseColor(parambnll.jdField_a_of_type_Bnlm.a), paramInt1);
    xvv.b("DoodleUtil", "LayerParams:" + parambnll.toString());
    return parambnll;
  }
  
  public static String a(ArrayList<DynamicStickerData> paramArrayList)
  {
    if (paramArrayList.isEmpty()) {
      return null;
    }
    JSONArray localJSONArray = new JSONArray();
    try
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        Object localObject = (DynamicStickerData)paramArrayList.next();
        if (localObject != null)
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("centerP_x", ((DynamicStickerData)localObject).centerP.x);
          localJSONObject.put("centerP_y", ((DynamicStickerData)localObject).centerP.y);
          localJSONObject.put("scale", ((DynamicStickerData)localObject).scale);
          localJSONObject.put("rotate", ((DynamicStickerData)localObject).rotate);
          localJSONObject.put("translateX", ((DynamicStickerData)localObject).translateX);
          localJSONObject.put("translateY", ((DynamicStickerData)localObject).translateY);
          localJSONObject.put("width", ((DynamicStickerData)localObject).width);
          localJSONObject.put("height", ((DynamicStickerData)localObject).height);
          localJSONObject.put("path", ((DynamicStickerData)localObject).path);
          localJSONObject.put("type", ((DynamicStickerData)localObject).type);
          localJSONObject.put("data", ((DynamicStickerData)localObject).data);
          localJSONObject.put("layerWidth", ((DynamicStickerData)localObject).layerWidth);
          localJSONObject.put("layerHeight", ((DynamicStickerData)localObject).layerHeight);
          localJSONObject.put("motionTrack", TrackerStickerParam.motionMapToJarray(((DynamicStickerData)localObject).mapMotionTrack));
          localObject = ((DynamicStickerData)localObject).mSegmentKeeper.toJSONObject();
          if (localObject != null) {
            localJSONObject.put("segmentdata", localObject);
          }
          localJSONArray.put(localJSONObject);
        }
      }
      paramArrayList = new JSONObject();
    }
    catch (JSONException paramArrayList)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoodleUtil", 2, "e= " + paramArrayList);
      }
      return null;
    }
    paramArrayList.put("list", localJSONArray);
    if (QLog.isColorLevel()) {
      QLog.d("DoodleUtil", 2, "DynamicStickersToJson result= " + paramArrayList.toString());
    }
    paramArrayList = paramArrayList.toString();
    return paramArrayList;
  }
  
  public static ArrayList<DynamicStickerData> a(String paramString)
  {
    int i = 0;
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    for (;;)
    {
      ArrayList localArrayList;
      DynamicStickerData localDynamicStickerData;
      try
      {
        if (TextUtils.isEmpty(paramString)) {
          break;
        }
        localArrayList = new ArrayList();
        paramString = new JSONObject(paramString).optJSONArray("list");
        if (paramString == null) {
          break;
        }
        if (i >= paramString.length()) {
          break label393;
        }
        JSONObject localJSONObject = paramString.getJSONObject(i);
        if (localJSONObject == null) {
          break label427;
        }
        localDynamicStickerData = new DynamicStickerData();
        localDynamicStickerData.centerP = new PointF((float)localJSONObject.optDouble("centerP_x"), (float)localJSONObject.optDouble("centerP_y"));
        localDynamicStickerData.scale = ((float)localJSONObject.optDouble("scale"));
        localDynamicStickerData.rotate = ((float)localJSONObject.optDouble("rotate"));
        localDynamicStickerData.translateX = ((float)localJSONObject.optDouble("translateX"));
        localDynamicStickerData.translateY = ((float)localJSONObject.optDouble("translateY"));
        localDynamicStickerData.width = ((float)localJSONObject.optDouble("width"));
        localDynamicStickerData.height = ((float)localJSONObject.optDouble("height"));
        localDynamicStickerData.layerWidth = localJSONObject.optInt("layerWidth");
        localDynamicStickerData.layerHeight = localJSONObject.optInt("layerHeight");
        localDynamicStickerData.path = localJSONObject.optString("path");
        localDynamicStickerData.type = localJSONObject.optInt("type", 0);
        localDynamicStickerData.data = localJSONObject.optString("data", "");
        if (1 == localDynamicStickerData.type)
        {
          localDynamicStickerData.mGifDecoder = new bmtp(localDynamicStickerData.path);
          localDynamicStickerData.mapMotionTrack = TrackerStickerParam.mapMotionFromJarray(localJSONObject.getJSONArray("motionTrack"));
          if (localJSONObject.has("segmentdata")) {
            localDynamicStickerData.mSegmentKeeper.fromJSONObject(localJSONObject.getJSONObject("segmentdata"));
          }
          localArrayList.add(localDynamicStickerData);
          break label427;
        }
        if (3 != localDynamicStickerData.type) {
          break label373;
        }
        localDynamicStickerData.mGifDecoder = new bmto(localDynamicStickerData.type, localDynamicStickerData.data);
        continue;
        if (!QLog.isColorLevel()) {
          break;
        }
      }
      catch (Exception paramString) {}
      QLog.d("DoodleUtil", 2, "e= " + paramString);
      return null;
      label373:
      localDynamicStickerData.mGifDecoder = new bmtp(localDynamicStickerData.path);
      continue;
      label393:
      if (QLog.isColorLevel()) {
        QLog.d("DoodleUtil", 2, "getDynamicStickersFromJson= " + localArrayList);
      }
      return localArrayList;
      label427:
      i += 1;
    }
  }
  
  public static void a(Bitmap paramBitmap, int paramInt)
  {
    int[] arrayOfInt = new int[paramInt * paramInt];
    int i3 = paramBitmap.getHeight() / paramInt;
    int i4 = paramBitmap.getWidth() / paramInt;
    int i5 = paramBitmap.getHeight() % paramInt;
    int i6 = paramBitmap.getWidth() % paramInt;
    int i = 0;
    int j;
    int i7;
    int i8;
    int k;
    int m;
    int n;
    int i1;
    int i2;
    while (i < i3)
    {
      j = 0;
      while (j < i4)
      {
        i7 = i * paramInt;
        i8 = j * paramInt;
        paramBitmap.getPixels(arrayOfInt, 0, paramInt, i8, i7, paramInt, paramInt);
        k = 0;
        m = 0;
        n = 0;
        i1 = 0;
        while (k < paramInt)
        {
          i2 = 0;
          while (i2 < paramInt)
          {
            int i9 = arrayOfInt[(k * paramInt + i2)];
            i1 += (i9 >> 16 & 0xFF);
            n += (i9 >> 8 & 0xFF);
            m += (i9 & 0xFF);
            i2 += 1;
          }
          k += 1;
        }
        i1 = i1 / paramInt / paramInt;
        n = n / paramInt / paramInt;
        i2 = m / paramInt / paramInt;
        k = 0;
        while (k < paramInt)
        {
          m = 0;
          while (m < paramInt)
          {
            arrayOfInt[(k * paramInt + m)] = (0xFF000000 | i1 << 16 | n << 8 | i2);
            m += 1;
          }
          k += 1;
        }
        paramBitmap.setPixels(arrayOfInt, 0, paramInt, i8, i7, paramInt, paramInt);
        j += 1;
      }
      i += 1;
    }
    if (i6 > 0)
    {
      i = 0;
      while (i < i3)
      {
        i2 = i * paramInt;
        i7 = i4 * paramInt;
        n = 0;
        m = 0;
        k = 0;
        j = 0;
        while (j < paramInt)
        {
          i1 = 0;
          while (i1 < i6)
          {
            i8 = paramBitmap.getPixel(i7 + i1, i2 + j);
            n += (i8 >> 16 & 0xFF);
            m += (i8 >> 8 & 0xFF);
            k += (i8 & 0xFF);
            i1 += 1;
          }
          j += 1;
        }
        n = n / paramInt / i6;
        m = m / paramInt / i6;
        i1 = k / paramInt / i6;
        j = 0;
        while (j < paramInt)
        {
          k = 0;
          while (k < i6)
          {
            paramBitmap.setPixel(i7 + k, i2 + j, 0xFF000000 | n << 16 | m << 8 | i1);
            k += 1;
          }
          j += 1;
        }
        i += 1;
      }
    }
    if (i5 > 0)
    {
      i = 0;
      while (i < i4)
      {
        i2 = i3 * paramInt;
        i6 = i * paramInt;
        n = 0;
        m = 0;
        k = 0;
        j = 0;
        while (j < i5)
        {
          i1 = 0;
          while (i1 < paramInt)
          {
            i7 = paramBitmap.getPixel(i6 + i1, i2 + j);
            n += (i7 >> 16 & 0xFF);
            m += (i7 >> 8 & 0xFF);
            k += (i7 & 0xFF);
            i1 += 1;
          }
          j += 1;
        }
        n = n / paramInt / i5;
        m = m / paramInt / i5;
        i1 = k / paramInt / i5;
        j = 0;
        while (j < i5)
        {
          k = 0;
          while (k < paramInt)
          {
            paramBitmap.setPixel(i6 + k, i2 + j, 0xFF000000 | n << 16 | m << 8 | i1);
            k += 1;
          }
          j += 1;
        }
        i += 1;
      }
    }
  }
  
  public static boolean a(bnll parambnll)
  {
    if (parambnll == null)
    {
      xvv.e("DoodleUtil", "item is null.");
      return false;
    }
    if (TextUtils.isEmpty(parambnll.e))
    {
      xvv.e("DoodleUtil", "item layoutJson is empty,can't parse.");
      return false;
    }
    if (!parambnll.a())
    {
      xvv.e("DoodleUtil", "parseJson error:" + parambnll.e);
      return false;
    }
    if (parambnll.jdField_a_of_type_Bnlm.b < 0)
    {
      xvv.e("DoodleUtil", "item textSize < 0. textSize:" + parambnll.jdField_a_of_type_Bnlm.b);
      return false;
    }
    if ((parambnll.jdField_a_of_type_Bnlm.c <= 0) || (parambnll.jdField_a_of_type_Bnlm.d <= 0))
    {
      xvv.e("DoodleUtil", "item pictureWidth <= 0 or item pictureHeight <= 0. pictureWidth:" + parambnll.jdField_a_of_type_Bnlm.c + ",pictureHeight:" + parambnll.jdField_a_of_type_Bnlm.d);
      return false;
    }
    if ((parambnll.jdField_a_of_type_Bnlm.e <= 0) || (parambnll.jdField_a_of_type_Bnlm.f <= 0))
    {
      xvv.e("DoodleUtil", "item standardWidth <= 0 or item standardHeight <= 0. standardWidth:" + parambnll.jdField_a_of_type_Bnlm.e + ",standardHeight:" + parambnll.jdField_a_of_type_Bnlm.f);
      return false;
    }
    try
    {
      Color.parseColor(parambnll.jdField_a_of_type_Bnlm.a);
      return true;
    }
    catch (Exception localException)
    {
      xvv.e("DoodleUtil", "item color is illegal:" + parambnll.jdField_a_of_type_Bnlm.a);
      localException.printStackTrace();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnnm
 * JD-Core Version:    0.7.0.1
 */