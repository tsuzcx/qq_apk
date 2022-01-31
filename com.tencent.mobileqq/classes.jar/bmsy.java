import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.animation.LinearInterpolator;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class bmsy
  extends bmth
{
  private int jdField_a_of_type_Int;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private int jdField_b_of_type_Int;
  private Rect jdField_b_of_type_AndroidGraphicsRect = new Rect();
  private String jdField_b_of_type_JavaLangString;
  private int c;
  private int d;
  private int e;
  
  public bmsy(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
    a(paramString);
    b();
    c();
  }
  
  public static String a(int paramInt, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", paramInt);
      localJSONObject.put("city_bitmap_path", paramString);
      paramString = localJSONObject.toString();
      if (QLog.isColorLevel()) {
        QLog.d("CityStickerDrawable", 2, paramString);
      }
      return paramString;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("CityStickerDrawable", 2, paramString, new Object[0]);
        }
        paramString = null;
      }
    }
  }
  
  protected void a(Canvas paramCanvas, ArrayList<Integer> paramArrayList)
  {
    int i;
    int k;
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      i = 225;
      k = this.e;
      if (paramArrayList == null) {
        break label200;
      }
    }
    for (;;)
    {
      try
      {
        j = ((Integer)paramArrayList.get(this.jdField_a_of_type_Int)).intValue();
        int n;
        QLog.e("CityStickerDrawable", 1, paramArrayList, new Object[0]);
      }
      catch (RuntimeException paramArrayList)
      {
        try
        {
          n = ((Integer)paramArrayList.get(this.jdField_b_of_type_Int)).intValue();
          i = n;
          m = ((Integer)paramArrayList.get(this.c)).intValue();
          k = n;
          i = j;
          j = m;
          this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(k);
          paramCanvas.save();
          this.jdField_b_of_type_AndroidGraphicsRect.set(this.jdField_a_of_type_AndroidGraphicsRect);
          this.jdField_b_of_type_AndroidGraphicsRect.offset(0, i);
          paramCanvas.clipRect(0, 0, this.d, j);
          paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, null, this.jdField_b_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
          paramCanvas.restore();
          return;
        }
        catch (RuntimeException paramArrayList)
        {
          for (;;)
          {
            int m = j;
            j = i;
            i = m;
          }
        }
        paramArrayList = paramArrayList;
        j = 225;
        i = 0;
      }
      m = j;
      int j = k;
      k = m;
      continue;
      label200:
      j = k;
      k = 225;
      i = 0;
    }
  }
  
  public String[] a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString != null)
      {
        this.f = paramString.optInt("type", 0);
        this.jdField_b_of_type_JavaLangString = paramString.optString("city_bitmap_path");
      }
      return new String[] { this.jdField_b_of_type_JavaLangString };
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        QLog.e("CityStickerDrawable", 1, paramString, new Object[0]);
        paramString = null;
      }
    }
  }
  
  protected void b()
  {
    if ((this.jdField_b_of_type_JavaLangString != null) && (new File(this.jdField_b_of_type_JavaLangString).exists()))
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeFile(this.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
      float f1 = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() / 3.0F;
      float f2 = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() / 3.0F;
      int i = a(f1, this.jdField_a_of_type_AndroidContentContext.getResources());
      int j = a(f2, this.jdField_a_of_type_AndroidContentContext.getResources());
      this.d = i;
      this.e = j;
      this.jdField_a_of_type_AndroidGraphicsRect = new Rect(0, 0, i, j);
      i = a(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      this.jdField_a_of_type_Int = this.jdField_a_of_type_Bmsv.a("offsetY", 0L, 500L, -i, 0, new LinearInterpolator());
      this.jdField_b_of_type_Int = this.jdField_a_of_type_Bmsv.a("alpha", 0L, 500L, 0, 255, new LinearInterpolator());
      this.c = this.jdField_a_of_type_Bmsv.a("height", 0L, 500L, 0, this.e, new LinearInterpolator());
    }
  }
  
  public int getIntrinsicHeight()
  {
    return this.e;
  }
  
  public int getIntrinsicWidth()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmsy
 * JD-Core Version:    0.7.0.1
 */