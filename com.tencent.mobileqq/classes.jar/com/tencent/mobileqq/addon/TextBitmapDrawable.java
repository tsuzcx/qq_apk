package com.tencent.mobileqq.addon;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextPaint;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.util.LRULinkedHashMap;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class TextBitmapDrawable
  implements DiyPendantFetcher.Invalidatable
{
  static LRULinkedHashMap<String, Bitmap> jdField_a_of_type_ComTencentUtilLRULinkedHashMap = new LRULinkedHashMap(10);
  Bundle jdField_a_of_type_AndroidOsBundle;
  WeakReference<MessengerService> jdField_a_of_type_JavaLangRefWeakReference;
  JSONObject jdField_a_of_type_OrgJsonJSONObject;
  
  public TextBitmapDrawable(JSONObject paramJSONObject, Bundle paramBundle, WeakReference<MessengerService> paramWeakReference)
  {
    this.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
  }
  
  public Object a()
  {
    return new Object();
  }
  
  public void invalidateSelf()
  {
    Object localObject3 = this.jdField_a_of_type_OrgJsonJSONObject.optString("text");
    int j = this.jdField_a_of_type_OrgJsonJSONObject.optInt("width");
    int k = this.jdField_a_of_type_OrgJsonJSONObject.optInt("height");
    int m = this.jdField_a_of_type_OrgJsonJSONObject.optInt("fontId");
    Object localObject1 = this.jdField_a_of_type_OrgJsonJSONObject.optString("fontColor");
    int n = this.jdField_a_of_type_OrgJsonJSONObject.optInt("fontType");
    TextPaint localTextPaint = new TextPaint();
    Rect localRect = new Rect(3, 5, j - 3, k - 3);
    float f = AvatarPendantUtil.a(localTextPaint, localRect, (String)localObject3);
    try
    {
      i = Color.parseColor((String)localObject1);
    }
    catch (Exception localException2)
    {
      int i;
      label111:
      String str;
      Object localObject2;
      WeakReference localWeakReference;
      break label111;
    }
    i = 0;
    if (n == 1)
    {
      localObject1 = DiyPendantFetcher.a().a(this, (String)localObject3, m, n, f, i, j, k, localTextPaint);
    }
    else
    {
      localObject1 = DiyPendantFetcher.a().a(this, m, n);
      if (localObject1 != null) {
        localTextPaint.setTypeface((Typeface)localObject1);
      }
      localTextPaint.setColor(i);
      localTextPaint.setTextAlign(Paint.Align.CENTER);
      localTextPaint.setTextSize(f);
      localObject1 = localTextPaint.getFontMetrics();
      f = (localRect.bottom + localRect.top - ((Paint.FontMetrics)localObject1).bottom - ((Paint.FontMetrics)localObject1).top) / 2.0F;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(j);
      ((StringBuilder)localObject1).append("_");
      ((StringBuilder)localObject1).append(k);
      str = ((StringBuilder)localObject1).toString();
      localObject2 = (Bitmap)jdField_a_of_type_ComTencentUtilLRULinkedHashMap.get(str);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = Bitmap.createBitmap(j, k, Bitmap.Config.ARGB_8888);
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          jdField_a_of_type_ComTencentUtilLRULinkedHashMap.put(str, localObject2);
          localObject1 = localObject2;
        }
      }
      if (localObject1 != null)
      {
        localObject2 = new Canvas((Bitmap)localObject1);
        ((Canvas)localObject2).drawColor(0, PorterDuff.Mode.CLEAR);
        ((Canvas)localObject2).drawText((String)localObject3, localRect.centerX(), f, localTextPaint);
      }
    }
    if (localObject1 != null)
    {
      localObject2 = new Bundle();
      try
      {
        localObject3 = new ByteArrayOutputStream();
        ((Bitmap)localObject1).compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject3);
        localObject1 = Base64Util.encodeToString(((ByteArrayOutputStream)localObject3).toByteArray(), 2);
        ((ByteArrayOutputStream)localObject3).close();
        ((Bundle)localObject2).putBoolean("updateResult", true);
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("data:image/png;base64,");
        ((StringBuilder)localObject3).append((String)localObject1);
        ((Bundle)localObject2).putString("file", ((StringBuilder)localObject3).toString());
      }
      catch (Exception localException1)
      {
        ((Bundle)localObject2).putBoolean("updateResult", false);
        ((Bundle)localObject2).putString("errMsg", localException1.getMessage());
      }
      this.jdField_a_of_type_AndroidOsBundle.putBundle("response", (Bundle)localObject2);
      localWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
      if ((localWeakReference != null) && (localWeakReference.get() != null)) {
        ((MessengerService)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(this.jdField_a_of_type_AndroidOsBundle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.addon.TextBitmapDrawable
 * JD-Core Version:    0.7.0.1
 */