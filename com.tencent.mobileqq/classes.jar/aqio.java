import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public final class aqio
  extends aqin
{
  public boolean a;
  public int c;
  public String c = "";
  
  public aqio()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public static aqin a(JSONObject paramJSONObject)
  {
    Object localObject = paramJSONObject.optString("type");
    if (("diy_chartlet".equalsIgnoreCase((String)localObject)) || ("static".equalsIgnoreCase((String)localObject)))
    {
      aqio localaqio = new aqio();
      localaqio.jdField_b_of_type_JavaLangString = ((String)localObject);
      localObject = BaseApplicationImpl.getApplication().getApplicationContext();
      localaqio.jdField_a_of_type_JavaLangString = paramJSONObject.optString("align").toUpperCase();
      if (paramJSONObject.has("rect"))
      {
        JSONArray localJSONArray = paramJSONObject.optJSONArray("rect");
        localaqio.jdField_a_of_type_ArrayOfInt = new int[4];
        int i = 0;
        while (i < localJSONArray.length())
        {
          localaqio.jdField_a_of_type_ArrayOfInt[i] = DisplayUtil.dip2px((Context)localObject, localJSONArray.optInt(i) / 2);
          i += 1;
        }
      }
      localaqio.jdField_a_of_type_Boolean = paramJSONObject.optBoolean("mirror", true);
      if (QLog.isColorLevel()) {
        QLog.d("DiyBubbleConfig", 2, "Resolve DiyBubblePasterConfig json->" + paramJSONObject);
      }
      return localaqio;
    }
    QLog.e("DiyBubbleConfig", 1, "error! paster type: " + (String)localObject);
    return null;
  }
  
  @TargetApi(11)
  public Rect a(aqjb paramaqjb, Canvas paramCanvas)
  {
    int i1 = 0;
    paramCanvas = paramaqjb.getBounds();
    Resources localResources = BaseApplicationImpl.getContext().getResources();
    if (jdField_b_of_type_Int == -1) {
      jdField_b_of_type_Int = AIOUtils.dp2px(48.0F, localResources);
    }
    int j = this.jdField_a_of_type_ArrayOfInt[3];
    int i = this.jdField_a_of_type_ArrayOfInt[2];
    int m;
    int n;
    int k;
    if (paramCanvas.height() >= jdField_b_of_type_Int)
    {
      AIOUtils.dp2px(10.0F, localResources);
      AIOUtils.dp2px(9.0F, localResources);
      m = 0;
      n = 0;
      k = j;
      j = n;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_JavaLangString.startsWith("T")) {
        n = m + this.jdField_a_of_type_ArrayOfInt[1];
      }
      for (;;)
      {
        label111:
        if (this.jdField_a_of_type_JavaLangString.endsWith("L")) {
          m = this.jdField_a_of_type_ArrayOfInt[0] + j;
        }
        for (;;)
        {
          j = m;
          if (paramaqjb.b)
          {
            j = m;
            if (!this.jdField_a_of_type_Boolean) {
              j = paramCanvas.width() - m - i;
            }
          }
          return new Rect(j, n, i + j, k + n);
          n = AIOUtils.dp2px(10.0F, localResources);
          m = AIOUtils.dp2px(7.0F, localResources);
          if ("static".equalsIgnoreCase(this.jdField_b_of_type_JavaLangString))
          {
            m = -AIOUtils.dp2px(2.0F, localResources);
            k = j;
            j = 0;
            break;
          }
          k = j;
          if (j <= m * 2) {
            break label407;
          }
          m *= 2;
          j = this.jdField_a_of_type_ArrayOfInt[2] * m / this.jdField_a_of_type_ArrayOfInt[3];
          i = j;
          k = m;
          if (j >= n * 2) {
            break label407;
          }
          int i2 = j / 2;
          k = m;
          i = j;
          j = n - i2;
          m = 0;
          break;
          if (!this.jdField_a_of_type_JavaLangString.startsWith("B")) {
            break label401;
          }
          n = this.jdField_a_of_type_ArrayOfInt[1] + this.jdField_a_of_type_ArrayOfInt[3] + paramCanvas.height() - k - m;
          break label111;
          m = i1;
          if (this.jdField_a_of_type_JavaLangString.endsWith("R")) {
            m = this.jdField_a_of_type_ArrayOfInt[0] + this.jdField_a_of_type_ArrayOfInt[2] + paramCanvas.width() - i - j;
          }
        }
        label401:
        n = 0;
      }
      label407:
      m = 0;
      j = 0;
    }
  }
  
  public void a(aqjb paramaqjb, Canvas paramCanvas)
  {
    if ((paramCanvas == null) || (paramaqjb == null)) {}
    for (;;)
    {
      return;
      Bitmap localBitmap;
      if ("diy_chartlet".equalsIgnoreCase(this.jdField_b_of_type_JavaLangString)) {
        localBitmap = aqhg.a().b(paramaqjb, this);
      }
      while (localBitmap != null)
      {
        int i = paramCanvas.save();
        if ((paramaqjb.b) && (this.jdField_a_of_type_Boolean)) {
          paramCanvas.scale(-1.0F, 1.0F, paramaqjb.getBounds().centerX(), paramaqjb.getBounds().centerY());
        }
        Paint localPaint = new Paint();
        paramaqjb = a(paramaqjb, paramCanvas);
        if (paramCanvas.getHeight() < jdField_b_of_type_Int) {
          paramCanvas.drawBitmap(localBitmap, null, paramaqjb, localPaint);
        }
        for (;;)
        {
          paramCanvas.restoreToCount(i);
          return;
          if (!"static".equalsIgnoreCase(this.jdField_b_of_type_JavaLangString)) {
            break label166;
          }
          localBitmap = aqhg.a().a(paramaqjb, this);
          break;
          paramCanvas.drawBitmap(localBitmap, paramaqjb.left, paramaqjb.top, localPaint);
        }
        label166:
        localBitmap = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqio
 * JD-Core Version:    0.7.0.1
 */