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

public class bkhu
{
  private static int a(@NonNull String paramString, int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0) || (bbjw.a(paramString)))
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
  
  public static bjzq a(Context paramContext, @NonNull Drawable paramDrawable, @NonNull String paramString, int paramInt)
  {
    int i = actn.a(47.0F, paramContext.getResources());
    int k = actn.a(27.0F, paramContext.getResources());
    int m = actn.a(14.0F, paramContext.getResources());
    Paint localPaint = new Paint();
    localPaint.setTextSize(m);
    int j = (int)localPaint.measureText(paramString) + (actn.a(10.0F, paramContext.getResources()) + paramDrawable.getBounds().width() + actn.a(6.0F, paramContext.getResources())) + actn.a(8.0F, paramContext.getResources());
    if (j < i) {}
    for (;;)
    {
      paramContext = new bjzq(i, k, -1, m, paramInt);
      veg.b("DoodleUtil", "LayerParams:" + paramContext.toString());
      return paramContext;
      i = j;
    }
  }
  
  public static bkab a(bkbe parambkbe, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return new bkab(paramFloat1, paramFloat2, paramFloat3, 0.0F, 0.0F, 0.0F, parambkbe.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth(), parambkbe.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight());
  }
  
  public static bkab a(bkfq parambkfq, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    if (!a(parambkfq)) {
      return null;
    }
    veg.b("DoodleUtil", "item:" + parambkfq.toString());
    int i = 0;
    paramInt2 = 0;
    if (parambkfq.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      i = parambkfq.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getBounds().width();
      paramInt2 = parambkfq.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getBounds().height();
    }
    float f2 = parambkfq.jdField_a_of_type_Bkfr.c;
    float f1 = parambkfq.jdField_a_of_type_Bkfr.d;
    float f3 = parambkfq.jdField_a_of_type_Bkfr.e;
    f2 = f2 * (paramInt1 / f3) / i;
    paramInt1 = (int)(parambkfq.jdField_a_of_type_Bkfr.b / f1 * paramInt2);
    parambkfq = new bkab(paramFloat1, paramFloat2, f2, 0.0F, 0.0F, 0.0F, i, paramInt2 + a(parambkfq.b, paramInt1, i) * 2 + 32, parambkfq.b, Color.parseColor(parambkfq.jdField_a_of_type_Bkfr.a), paramInt1);
    veg.b("DoodleUtil", "LayerParams:" + parambkfq.toString());
    return parambkfq;
  }
  
  public static bkab a(bkfq parambkfq, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (!a(parambkfq)) {
      return null;
    }
    veg.b("DoodleUtil", "item:" + parambkfq.toString());
    int i = 0;
    paramInt2 = 0;
    if (parambkfq.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      i = parambkfq.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getBounds().width();
      paramInt2 = parambkfq.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getBounds().height();
    }
    float f = parambkfq.jdField_a_of_type_Bkfr.c;
    f = parambkfq.jdField_a_of_type_Bkfr.d;
    paramFloat3 = paramInt1 * paramFloat3 / i;
    paramInt1 = (int)(parambkfq.jdField_a_of_type_Bkfr.b / f * paramInt2);
    parambkfq = new bkab(paramFloat1, paramFloat2, paramFloat3, 0.0F, 0.0F, 0.0F, i, paramInt2 + a(parambkfq.b, paramInt1, i) * 2 + 32, parambkfq.b, Color.parseColor(parambkfq.jdField_a_of_type_Bkfr.a), paramInt1);
    veg.b("DoodleUtil", "LayerParams:" + parambkfq.toString());
    return parambkfq;
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
          localDynamicStickerData.mGifDecoder = new bjei(localDynamicStickerData.path);
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
        localDynamicStickerData.mGifDecoder = new bjeh(localDynamicStickerData.type, localDynamicStickerData.data);
        continue;
        if (!QLog.isColorLevel()) {
          break;
        }
      }
      catch (Exception paramString) {}
      QLog.d("DoodleUtil", 2, "e= " + paramString);
      return null;
      label380:
      localDynamicStickerData.mGifDecoder = new bjei(localDynamicStickerData.path);
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
  
  public static boolean a(bkfq parambkfq)
  {
    if (parambkfq == null)
    {
      veg.e("DoodleUtil", "item is null.");
      return false;
    }
    if (TextUtils.isEmpty(parambkfq.e))
    {
      veg.e("DoodleUtil", "item layoutJson is empty,can't parse.");
      return false;
    }
    if (!parambkfq.a())
    {
      veg.e("DoodleUtil", "parseJson error:" + parambkfq.e);
      return false;
    }
    if (parambkfq.jdField_a_of_type_Bkfr.b < 0)
    {
      veg.e("DoodleUtil", "item textSize < 0. textSize:" + parambkfq.jdField_a_of_type_Bkfr.b);
      return false;
    }
    if ((parambkfq.jdField_a_of_type_Bkfr.c <= 0) || (parambkfq.jdField_a_of_type_Bkfr.d <= 0))
    {
      veg.e("DoodleUtil", "item pictureWidth <= 0 or item pictureHeight <= 0. pictureWidth:" + parambkfq.jdField_a_of_type_Bkfr.c + ",pictureHeight:" + parambkfq.jdField_a_of_type_Bkfr.d);
      return false;
    }
    if ((parambkfq.jdField_a_of_type_Bkfr.e <= 0) || (parambkfq.jdField_a_of_type_Bkfr.f <= 0))
    {
      veg.e("DoodleUtil", "item standardWidth <= 0 or item standardHeight <= 0. standardWidth:" + parambkfq.jdField_a_of_type_Bkfr.e + ",standardHeight:" + parambkfq.jdField_a_of_type_Bkfr.f);
      return false;
    }
    try
    {
      Color.parseColor(parambkfq.jdField_a_of_type_Bkfr.a);
      return true;
    }
    catch (Exception localException)
    {
      veg.e("DoodleUtil", "item color is illegal:" + parambkfq.jdField_a_of_type_Bkfr.a);
      localException.printStackTrace();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkhu
 * JD-Core Version:    0.7.0.1
 */