import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public final class anxv
  extends anxt
{
  public int c;
  public String c;
  public int d;
  public int e;
  
  public anxv()
  {
    this.jdField_c_of_type_Int = -1;
  }
  
  public static anxt a(JSONObject paramJSONObject)
  {
    anxv localanxv = new anxv();
    Context localContext = BaseApplicationImpl.getApplication().getApplicationContext();
    localanxv.jdField_a_of_type_JavaLangString = paramJSONObject.optString("align");
    localanxv.d = (bdaq.c(localContext, paramJSONObject.optInt("text_size") / 2) + 1);
    localanxv.jdField_c_of_type_JavaLangString = paramJSONObject.optString("text_align");
    String str = paramJSONObject.optString("text_color");
    Object localObject = str;
    if (str.startsWith("0x")) {
      localObject = str.substring(2);
    }
    try
    {
      localanxv.jdField_c_of_type_Int = Color.parseColor("#" + (String)localObject);
      if (paramJSONObject.has("rect"))
      {
        localObject = paramJSONObject.optJSONArray("rect");
        localanxv.jdField_a_of_type_ArrayOfInt = new int[4];
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          localanxv.jdField_a_of_type_ArrayOfInt[i] = bdaq.a(localContext, ((JSONArray)localObject).optInt(i) / 2);
          i += 1;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DiyBubbleConfig", 2, "diy text_color invalid");
        }
      }
      localanxv.e = paramJSONObject.optInt("text_max_count");
      if (QLog.isColorLevel()) {
        QLog.d("DiyBubbleConfig", 2, "Resolve DiyBubbleTextConfig json->" + paramJSONObject);
      }
    }
    return localanxv;
  }
  
  @TargetApi(11)
  public Rect a(anyh paramanyh, Canvas paramCanvas, Paint paramPaint)
  {
    float f1 = 0.0F;
    paramCanvas = paramanyh.getBounds();
    Object localObject = BaseApplicationImpl.getContext().getResources();
    if (b == -1) {
      b = aepi.a(48.0F, (Resources)localObject);
    }
    float f4 = 1.0F;
    float f3 = this.jdField_a_of_type_ArrayOfInt[3];
    int i;
    if (paramCanvas.height() < b)
    {
      i = aepi.a(2.0F, (Resources)localObject);
      int j = aepi.a(9.0F, (Resources)localObject);
      int k = aepi.a(7.0F, (Resources)localObject);
      f4 = (paramCanvas.height() - k * 2) * 1.0F / (b - j * 2);
      f3 = this.jdField_a_of_type_ArrayOfInt[3] * f4;
    }
    for (;;)
    {
      float f2;
      if (this.jdField_a_of_type_JavaLangString.startsWith("T")) {
        f2 = this.jdField_a_of_type_ArrayOfInt[1] - i;
      }
      for (;;)
      {
        label162:
        float f5;
        if (this.jdField_a_of_type_JavaLangString.endsWith("L"))
        {
          f1 = this.jdField_a_of_type_ArrayOfInt[0];
          i = this.jdField_a_of_type_ArrayOfInt[2];
          if (this.d != 0) {
            paramPaint.setTextSize(f4 * this.d);
          }
          paramPaint.setAntiAlias(true);
          paramPaint.setFakeBoldText(true);
          localObject = anwm.a().a(paramanyh, paramanyh.jdField_a_of_type_JavaLangString);
          Paint.FontMetrics localFontMetrics = paramPaint.getFontMetrics();
          f4 = anxt.a(paramPaint, (String)localObject);
          f5 = f2 + f3 / 2.0F - (localFontMetrics.bottom - localFontMetrics.top) / 2.0F - localFontMetrics.top;
          if (!this.jdField_c_of_type_JavaLangString.equals("center")) {
            break label403;
          }
          f2 = f1 + (i - f4) / 2.0F;
        }
        for (;;)
        {
          if (!paramanyh.b) {
            break label433;
          }
          f1 = paramCanvas.width() - f2 - f4;
          return new Rect((int)f1, (int)f5, (int)(i + f1), (int)(f3 + f5));
          if (!this.jdField_a_of_type_JavaLangString.startsWith("B")) {
            break label460;
          }
          f2 = this.jdField_a_of_type_ArrayOfInt[1] + this.jdField_a_of_type_ArrayOfInt[3] + paramCanvas.height();
          f2 = i + (f2 - f3);
          break;
          if (!this.jdField_a_of_type_JavaLangString.endsWith("R")) {
            break label162;
          }
          f1 = this.jdField_a_of_type_ArrayOfInt[0] + paramCanvas.width();
          break label162;
          label403:
          f2 = f1;
          if (this.jdField_c_of_type_JavaLangString.equals("right")) {
            f2 = f1 + i - f4;
          }
        }
        label433:
        return new Rect((int)f2, (int)f5, (int)(i + f2), (int)(f3 + f5));
        label460:
        f2 = 0.0F;
      }
      i = 0;
    }
  }
  
  public void a(anyh paramanyh, Canvas paramCanvas)
  {
    if ((paramCanvas == null) || (paramanyh == null)) {}
    String str;
    do
    {
      return;
      str = anwm.a().a(paramanyh, paramanyh.jdField_a_of_type_JavaLangString);
    } while ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)));
    Paint localPaint = new Paint();
    if (this.jdField_c_of_type_Int != -1) {
      localPaint.setColor(this.jdField_c_of_type_Int);
    }
    paramanyh = a(paramanyh, paramCanvas, localPaint);
    paramCanvas.drawText(str, paramanyh.left, paramanyh.top, localPaint);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anxv
 * JD-Core Version:    0.7.0.1
 */