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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public final class apfl
  extends apfj
{
  public int c;
  public String c;
  public int d;
  public int e;
  
  public apfl()
  {
    this.jdField_c_of_type_Int = -1;
  }
  
  public static apfj a(JSONObject paramJSONObject)
  {
    apfl localapfl = new apfl();
    Context localContext = BaseApplicationImpl.getApplication().getApplicationContext();
    localapfl.jdField_a_of_type_JavaLangString = paramJSONObject.optString("align");
    localapfl.d = (DisplayUtil.sp2px(localContext, paramJSONObject.optInt("text_size") / 2) + 1);
    localapfl.jdField_c_of_type_JavaLangString = paramJSONObject.optString("text_align");
    String str = paramJSONObject.optString("text_color");
    Object localObject = str;
    if (str.startsWith("0x")) {
      localObject = str.substring(2);
    }
    try
    {
      localapfl.jdField_c_of_type_Int = Color.parseColor("#" + (String)localObject);
      if (paramJSONObject.has("rect"))
      {
        localObject = paramJSONObject.optJSONArray("rect");
        localapfl.jdField_a_of_type_ArrayOfInt = new int[4];
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          localapfl.jdField_a_of_type_ArrayOfInt[i] = DisplayUtil.dip2px(localContext, ((JSONArray)localObject).optInt(i) / 2);
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
      localapfl.e = paramJSONObject.optInt("text_max_count");
      if (QLog.isColorLevel()) {
        QLog.d("DiyBubbleConfig", 2, "Resolve DiyBubbleTextConfig json->" + paramJSONObject);
      }
    }
    return localapfl;
  }
  
  @TargetApi(11)
  public Rect a(apfx paramapfx, Canvas paramCanvas, Paint paramPaint)
  {
    float f1 = 0.0F;
    paramCanvas = paramapfx.getBounds();
    Object localObject = BaseApplicationImpl.getContext().getResources();
    if (b == -1) {
      b = AIOUtils.dp2px(48.0F, (Resources)localObject);
    }
    float f4 = 1.0F;
    float f3 = this.jdField_a_of_type_ArrayOfInt[3];
    int i;
    if (paramCanvas.height() < b)
    {
      i = AIOUtils.dp2px(2.0F, (Resources)localObject);
      int j = AIOUtils.dp2px(9.0F, (Resources)localObject);
      int k = AIOUtils.dp2px(7.0F, (Resources)localObject);
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
          localObject = apec.a().a(paramapfx, paramapfx.jdField_a_of_type_JavaLangString);
          Paint.FontMetrics localFontMetrics = paramPaint.getFontMetrics();
          f4 = apfj.a(paramPaint, (String)localObject);
          f5 = f2 + f3 / 2.0F - (localFontMetrics.bottom - localFontMetrics.top) / 2.0F - localFontMetrics.top;
          if (!this.jdField_c_of_type_JavaLangString.equals("center")) {
            break label403;
          }
          f2 = f1 + (i - f4) / 2.0F;
        }
        for (;;)
        {
          if (!paramapfx.b) {
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
  
  public void a(apfx paramapfx, Canvas paramCanvas)
  {
    if ((paramCanvas == null) || (paramapfx == null)) {}
    String str;
    do
    {
      return;
      str = apec.a().a(paramapfx, paramapfx.jdField_a_of_type_JavaLangString);
    } while ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)));
    Paint localPaint = new Paint();
    if (this.jdField_c_of_type_Int != -1) {
      localPaint.setColor(this.jdField_c_of_type_Int);
    }
    paramapfx = a(paramapfx, paramCanvas, localPaint);
    paramCanvas.drawText(str, paramapfx.left, paramapfx.top, localPaint);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apfl
 * JD-Core Version:    0.7.0.1
 */