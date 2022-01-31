import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.NinePatch;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import org.json.JSONException;
import org.json.JSONObject;

public class bmqb
  extends bmyj
{
  public int a;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  Rect jdField_a_of_type_AndroidGraphicsRect;
  RectF jdField_a_of_type_AndroidGraphicsRectF;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  StaticLayout jdField_a_of_type_AndroidTextStaticLayout;
  public String a;
  int jdField_b_of_type_Int;
  Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  public String b;
  int jdField_c_of_type_Int;
  String jdField_c_of_type_JavaLangString;
  
  public bmqb(bmqa parambmqa, @NonNull String paramString1, @NonNull Drawable paramDrawable, @NonNull String paramString2, @NonNull String paramString3, @NonNull bmqd parambmqd)
  {
    super(parambmqd.jdField_a_of_type_AndroidGraphicsPointF, parambmqd.jdField_a_of_type_Float, parambmqd.jdField_b_of_type_Float, parambmqd.jdField_c_of_type_Float, parambmqd.jdField_d_of_type_Float, parambmqd.jdField_a_of_type_Int, parambmqd.jdField_b_of_type_Int, false);
    this.jdField_a_of_type_Int = parambmqd.jdField_c_of_type_Int;
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(parambmqa.jdField_a_of_type_AndroidContentContext.getResources(), 2130845949);
      this.jdField_b_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(parambmqa.jdField_a_of_type_AndroidContentContext.getResources(), 2130845950);
      this.jdField_a_of_type_AndroidGraphicsRect = new Rect(0, 0, (int)this.u, (int)this.v);
      this.jdField_a_of_type_JavaLangString = paramString1;
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
      this.jdField_a_of_type_AndroidGraphicsRectF = new RectF(paramDrawable.getBounds());
      this.jdField_b_of_type_JavaLangString = paramString2;
      this.jdField_c_of_type_JavaLangString = paramString3;
      this.jdField_b_of_type_Int = parambmqd.e;
      this.jdField_c_of_type_Int = parambmqd.jdField_d_of_type_Int;
      return;
    }
    catch (OutOfMemoryError parambmqa)
    {
      for (;;)
      {
        wxe.c(bmqa.jdField_a_of_type_JavaLangString, "BitmapFactory.decodeResource outOfMemoryError : %s.", parambmqa);
      }
    }
  }
  
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("u", this.jdField_a_of_type_JavaLangString);
        localJSONObject.put("n", this.jdField_c_of_type_JavaLangString);
        localJSONObject.put("o", this.jdField_a_of_type_Int);
        if (this.jdField_a_of_type_Int != 0) {
          continue;
        }
        i = (int)((this.jdField_b_of_type_AndroidGraphicsPointF.x + this.s - this.u / 2.0F) / this.jdField_a_of_type_Bmqa.jdField_a_of_type_AndroidGraphicsRect.width() * 1000.0F);
        int j = (int)((this.jdField_b_of_type_AndroidGraphicsPointF.y + this.t) / this.jdField_a_of_type_Bmqa.jdField_a_of_type_AndroidGraphicsRect.height() * 1000.0F);
        localJSONObject.put("x", i);
        localJSONObject.put("y", j);
      }
      catch (JSONException localJSONException)
      {
        int i;
        float f1;
        float f2;
        float f3;
        localJSONException.printStackTrace();
        continue;
      }
      wxe.c(bmqa.jdField_a_of_type_JavaLangString, "AtItem toJsonObject:" + localJSONObject.toString());
      return localJSONObject;
      f1 = this.jdField_b_of_type_AndroidGraphicsPointF.x;
      f2 = this.s;
      f3 = this.u / 2.0F;
      i = this.jdField_a_of_type_Bmqa.jdField_a_of_type_AndroidGraphicsRect.width();
      i = (int)((f1 + f2 + f3) / i * 1000.0F);
    }
  }
  
  public void a(Canvas paramCanvas, boolean paramBoolean)
  {
    wxe.c(bmqa.jdField_a_of_type_JavaLangString, "AtItem draw start.");
    paramCanvas.save();
    paramCanvas.translate(-this.u / 2.0F, -this.v / 2.0F);
    NinePatch localNinePatch;
    if (this.jdField_a_of_type_Int == 0)
    {
      localNinePatch = new NinePatch(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsBitmap.getNinePatchChunk(), null);
      localNinePatch.draw(paramCanvas, this.jdField_a_of_type_AndroidGraphicsRect);
      paramCanvas.restore();
      paramCanvas.save();
      float f2 = (this.v - this.jdField_a_of_type_AndroidGraphicsRectF.height()) / 2.0F;
      if (this.jdField_a_of_type_Int != 0) {
        break label344;
      }
      paramCanvas.translate(-this.u / 2.0F, -this.v / 2.0F);
      f1 = aepi.a(10.0F, this.jdField_a_of_type_Bmqa.jdField_a_of_type_AndroidContentContext.getResources());
      label136:
      paramCanvas.translate(f1, f2);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      paramCanvas.restore();
      paramCanvas.save();
      paramCanvas.translate(-this.u / 2.0F, -this.v / 2.0F);
      if (this.jdField_a_of_type_Int != 0) {
        break label383;
      }
    }
    label344:
    label383:
    for (float f1 = aepi.a(36.0F, this.jdField_a_of_type_Bmqa.jdField_a_of_type_AndroidContentContext.getResources());; f1 = aepi.a(8.0F, this.jdField_a_of_type_Bmqa.jdField_a_of_type_AndroidContentContext.getResources()))
    {
      this.jdField_a_of_type_Bmqa.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.jdField_b_of_type_Int);
      this.jdField_a_of_type_Bmqa.jdField_a_of_type_AndroidTextTextPaint.setColor(this.jdField_c_of_type_Int);
      int i = (int)this.jdField_a_of_type_Bmqa.jdField_a_of_type_AndroidTextTextPaint.measureText(this.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidTextStaticLayout = new StaticLayout(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Bmqa.jdField_a_of_type_AndroidTextTextPaint, i, Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false);
      paramCanvas.translate(f1, (this.v - this.jdField_a_of_type_AndroidTextStaticLayout.getHeight()) / 2.0F);
      this.jdField_a_of_type_AndroidTextStaticLayout.draw(paramCanvas);
      paramCanvas.restore();
      wxe.c(bmqa.jdField_a_of_type_JavaLangString, "AtItem draw end.");
      return;
      localNinePatch = new NinePatch(this.jdField_b_of_type_AndroidGraphicsBitmap, this.jdField_b_of_type_AndroidGraphicsBitmap.getNinePatchChunk(), null);
      break;
      paramCanvas.translate(this.u / 2.0F, -this.v / 2.0F);
      f1 = -aepi.a(30.0F, this.jdField_a_of_type_Bmqa.jdField_a_of_type_AndroidContentContext.getResources());
      break label136;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmqb
 * JD-Core Version:    0.7.0.1
 */