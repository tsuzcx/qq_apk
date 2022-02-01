import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
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
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bqri
{
  private static int a(@NonNull String paramString, int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0) || (bhsr.a(paramString)))
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
  
  public static bqje a(Context paramContext, @NonNull Drawable paramDrawable, @NonNull String paramString, int paramInt)
  {
    int i = agej.a(47.0F, paramContext.getResources());
    int k = agej.a(27.0F, paramContext.getResources());
    int m = agej.a(14.0F, paramContext.getResources());
    Paint localPaint = new Paint();
    localPaint.setTextSize(m);
    int j = (int)localPaint.measureText(paramString) + (agej.a(10.0F, paramContext.getResources()) + paramDrawable.getBounds().width() + agej.a(6.0F, paramContext.getResources())) + agej.a(8.0F, paramContext.getResources());
    if (j < i) {}
    for (;;)
    {
      paramContext = new bqje(i, k, -1, m, paramInt);
      yuk.b("DoodleUtil", "LayerParams:" + paramContext.toString());
      return paramContext;
      i = j;
    }
  }
  
  public static bqjp a(bqks parambqks, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return new bqjp(paramFloat1, paramFloat2, paramFloat3, 0.0F, 0.0F, 0.0F, parambqks.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth(), parambqks.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight());
  }
  
  public static bqjp a(bqpe parambqpe, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    if (!a(parambqpe)) {
      return null;
    }
    yuk.b("DoodleUtil", "item:" + parambqpe.toString());
    int i = 0;
    paramInt2 = 0;
    if (parambqpe.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      i = parambqpe.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getBounds().width();
      paramInt2 = parambqpe.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getBounds().height();
    }
    float f2 = parambqpe.jdField_a_of_type_Bqpf.c;
    float f1 = parambqpe.jdField_a_of_type_Bqpf.d;
    float f3 = parambqpe.jdField_a_of_type_Bqpf.e;
    f2 = f2 * (paramInt1 / f3) / i;
    paramInt1 = (int)(parambqpe.jdField_a_of_type_Bqpf.b / f1 * paramInt2);
    parambqpe = new bqjp(paramFloat1, paramFloat2, f2, 0.0F, 0.0F, 0.0F, i, paramInt2 + a(parambqpe.b, paramInt1, i) * 2 + 32, parambqpe.b, Color.parseColor(parambqpe.jdField_a_of_type_Bqpf.a), paramInt1);
    yuk.b("DoodleUtil", "LayerParams:" + parambqpe.toString());
    return parambqpe;
  }
  
  public static bqjp a(bqpe parambqpe, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (!a(parambqpe)) {
      return null;
    }
    yuk.b("DoodleUtil", "item:" + parambqpe.toString());
    int i = 0;
    paramInt2 = 0;
    if (parambqpe.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      i = parambqpe.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getBounds().width();
      paramInt2 = parambqpe.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getBounds().height();
    }
    float f = parambqpe.jdField_a_of_type_Bqpf.c;
    f = parambqpe.jdField_a_of_type_Bqpf.d;
    paramFloat3 = paramInt1 * paramFloat3 / i;
    paramInt1 = (int)(parambqpe.jdField_a_of_type_Bqpf.b / f * paramInt2);
    parambqpe = new bqjp(paramFloat1, paramFloat2, paramFloat3, 0.0F, 0.0F, 0.0F, i, paramInt2 + a(parambqpe.b, paramInt1, i) * 2 + 32, parambqpe.b, Color.parseColor(parambqpe.jdField_a_of_type_Bqpf.a), paramInt1);
    yuk.b("DoodleUtil", "LayerParams:" + parambqpe.toString());
    return parambqpe;
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
          break label400;
        }
        JSONObject localJSONObject = paramString.getJSONObject(i);
        if (localJSONObject == null) {
          break label434;
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
          localDynamicStickerData.mGifDecoder = new bppv(localDynamicStickerData.path);
          localDynamicStickerData.mapMotionTrack = TrackerStickerParam.mapMotionFromJarray(localJSONObject.getJSONArray("motionTrack"));
          if (localJSONObject.has("segmentdata")) {
            localDynamicStickerData.mSegmentKeeper.fromJSONObject(localJSONObject.getJSONObject("segmentdata"));
          }
          localArrayList.add(localDynamicStickerData);
          break label434;
        }
        if (3 != localDynamicStickerData.type) {
          break label380;
        }
        localDynamicStickerData.mGifDecoder = new bppu(localDynamicStickerData.type, localDynamicStickerData.data);
        continue;
        if (!QLog.isColorLevel()) {
          break;
        }
      }
      catch (Exception paramString) {}
      QLog.d("DoodleUtil", 2, "e= " + paramString);
      return null;
      label380:
      localDynamicStickerData.mGifDecoder = new bppv(localDynamicStickerData.path);
      continue;
      label400:
      if (QLog.isColorLevel()) {
        QLog.d("DoodleUtil", 2, "getDynamicStickersFromJson= " + localArrayList);
      }
      return localArrayList;
      label434:
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
  
  public static boolean a(bqpe parambqpe)
  {
    if (parambqpe == null)
    {
      yuk.e("DoodleUtil", "item is null.");
      return false;
    }
    if (TextUtils.isEmpty(parambqpe.e))
    {
      yuk.e("DoodleUtil", "item layoutJson is empty,can't parse.");
      return false;
    }
    if (!parambqpe.a())
    {
      yuk.e("DoodleUtil", "parseJson error:" + parambqpe.e);
      return false;
    }
    if (parambqpe.jdField_a_of_type_Bqpf.b < 0)
    {
      yuk.e("DoodleUtil", "item textSize < 0. textSize:" + parambqpe.jdField_a_of_type_Bqpf.b);
      return false;
    }
    if ((parambqpe.jdField_a_of_type_Bqpf.c <= 0) || (parambqpe.jdField_a_of_type_Bqpf.d <= 0))
    {
      yuk.e("DoodleUtil", "item pictureWidth <= 0 or item pictureHeight <= 0. pictureWidth:" + parambqpe.jdField_a_of_type_Bqpf.c + ",pictureHeight:" + parambqpe.jdField_a_of_type_Bqpf.d);
      return false;
    }
    if ((parambqpe.jdField_a_of_type_Bqpf.e <= 0) || (parambqpe.jdField_a_of_type_Bqpf.f <= 0))
    {
      yuk.e("DoodleUtil", "item standardWidth <= 0 or item standardHeight <= 0. standardWidth:" + parambqpe.jdField_a_of_type_Bqpf.e + ",standardHeight:" + parambqpe.jdField_a_of_type_Bqpf.f);
      return false;
    }
    try
    {
      Color.parseColor(parambqpe.jdField_a_of_type_Bqpf.a);
      return true;
    }
    catch (Exception localException)
    {
      yuk.e("DoodleUtil", "item color is illegal:" + parambqpe.jdField_a_of_type_Bqpf.a);
      localException.printStackTrace();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqri
 * JD-Core Version:    0.7.0.1
 */