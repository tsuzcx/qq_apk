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
import com.tencent.util.LRULinkedHashMap;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class amsa
  implements amry
{
  static LRULinkedHashMap<String, Bitmap> jdField_a_of_type_ComTencentUtilLRULinkedHashMap = new LRULinkedHashMap(10);
  Bundle jdField_a_of_type_AndroidOsBundle;
  WeakReference<MessengerService> jdField_a_of_type_JavaLangRefWeakReference;
  JSONObject jdField_a_of_type_OrgJsonJSONObject;
  
  public amsa(JSONObject paramJSONObject, Bundle paramBundle, WeakReference<MessengerService> paramWeakReference)
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
    Object localObject4 = this.jdField_a_of_type_OrgJsonJSONObject.optString("text");
    int j = this.jdField_a_of_type_OrgJsonJSONObject.optInt("width");
    int k = this.jdField_a_of_type_OrgJsonJSONObject.optInt("height");
    int m = this.jdField_a_of_type_OrgJsonJSONObject.optInt("fontId");
    Object localObject1 = this.jdField_a_of_type_OrgJsonJSONObject.optString("fontColor");
    int n = this.jdField_a_of_type_OrgJsonJSONObject.optInt("fontType");
    TextPaint localTextPaint = new TextPaint();
    Rect localRect = new Rect(3, 5, j - 3, k - 3);
    float f = bhkt.a(localTextPaint, localRect, (String)localObject4);
    try
    {
      i = Color.parseColor((String)localObject1);
      if (n == 1)
      {
        localObject3 = amrx.a().a(this, (String)localObject4, m, n, f, i, j, k, localTextPaint);
        if (localObject3 != null) {
          localObject1 = new Bundle();
        }
      }
    }
    catch (Exception localException1)
    {
      try
      {
        do
        {
          int i;
          for (;;)
          {
            localObject4 = new ByteArrayOutputStream();
            ((Bitmap)localObject3).compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject4);
            localObject3 = bhkv.encodeToString(((ByteArrayOutputStream)localObject4).toByteArray(), 2);
            ((ByteArrayOutputStream)localObject4).close();
            ((Bundle)localObject1).putBoolean("updateResult", true);
            ((Bundle)localObject1).putString("file", "data:image/png;base64," + (String)localObject3);
            this.jdField_a_of_type_AndroidOsBundle.putBundle("response", (Bundle)localObject1);
            if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
              ((MessengerService)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(this.jdField_a_of_type_AndroidOsBundle);
            }
            return;
            localException1 = localException1;
            i = 0;
          }
          localObject2 = amrx.a().a(this, m, n);
          if (localObject2 != null) {
            localTextPaint.setTypeface((Typeface)localObject2);
          }
          localTextPaint.setColor(i);
          localTextPaint.setTextAlign(Paint.Align.CENTER);
          localTextPaint.setTextSize(f);
          localObject2 = localTextPaint.getFontMetrics();
          f = (localRect.bottom + localRect.top - ((Paint.FontMetrics)localObject2).bottom - ((Paint.FontMetrics)localObject2).top) / 2.0F;
          String str = j + "_" + k;
          localObject3 = (Bitmap)jdField_a_of_type_ComTencentUtilLRULinkedHashMap.get(str);
          localObject2 = localObject3;
          if (localObject3 == null)
          {
            localObject3 = Bitmap.createBitmap(j, k, Bitmap.Config.ARGB_8888);
            localObject2 = localObject3;
            if (localObject3 != null)
            {
              jdField_a_of_type_ComTencentUtilLRULinkedHashMap.put(str, localObject3);
              localObject2 = localObject3;
            }
          }
          localObject3 = localObject2;
        } while (localObject2 == null);
        Object localObject3 = new Canvas((Bitmap)localObject2);
        ((Canvas)localObject3).drawColor(0, PorterDuff.Mode.CLEAR);
        ((Canvas)localObject3).drawText((String)localObject4, localRect.centerX(), f, localTextPaint);
        localObject3 = localObject2;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Object localObject2;
          ((Bundle)localObject2).putBoolean("updateResult", false);
          ((Bundle)localObject2).putString("errMsg", localException2.getMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amsa
 * JD-Core Version:    0.7.0.1
 */