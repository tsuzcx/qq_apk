import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import dov.com.qq.im.capture.text.DynamicTextItem;
import java.util.List;

public class bluj
  extends DynamicTextItem
{
  public static final int b;
  public static final int c;
  public static final int d;
  private float jdField_a_of_type_Float;
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private TextPaint jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
  bluk jdField_a_of_type_Bluk;
  private boolean jdField_a_of_type_Boolean = true;
  private float b;
  private int e;
  
  static
  {
    Resources localResources = BaseApplicationImpl.getContext().getResources();
    jdField_b_of_type_Int = aekt.a(36.0F, localResources);
    d = aekt.a(6.0F, localResources);
    int i = bmtu.a();
    c = localResources.getDisplayMetrics().widthPixels - wzs.a - i * 2;
  }
  
  public bluj(int paramInt, List<String> paramList, Typeface paramTypeface)
  {
    super(paramInt, paramList);
    this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(Typeface.DEFAULT);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextAlign(Paint.Align.CENTER);
    if (paramTypeface == null) {
      this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(Typeface.defaultFromStyle(1));
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidTextTextPaint.setAntiAlias(true);
      this.jdField_a_of_type_AndroidTextTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
      this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(jdField_b_of_type_Int);
      this.jdField_a_of_type_AndroidTextTextPaint.setColor(-1);
      this.jdField_a_of_type_AndroidTextTextPaint.setTextAlign(Paint.Align.LEFT);
      if (!paramList.isEmpty()) {
        a(0, (String)paramList.get(0));
      }
      return;
      this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(paramTypeface);
    }
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public int a()
  {
    return 1;
  }
  
  public void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
    String str = super.b(paramInt);
    paramString = str;
    if (TextUtils.isEmpty(str)) {
      paramString = "　　";
    }
    this.e = aekt.a(18.0F, BaseApplicationImpl.getContext().getResources());
    this.jdField_a_of_type_Bluk = new bluk(0);
    this.jdField_a_of_type_Bluk.b(new bltw(-65536, d));
    this.jdField_a_of_type_Bluk.a(paramString, c, jdField_b_of_type_Int, this.jdField_a_of_type_AndroidTextTextPaint);
    this.jdField_a_of_type_Bluk.a(new blts(this.e));
    this.jdField_a_of_type_Float = this.jdField_a_of_type_Bluk.a(1, this.jdField_a_of_type_Bluk.a()).width();
    this.jdField_b_of_type_Float = this.jdField_a_of_type_Bluk.a(1, this.jdField_a_of_type_Bluk.a()).height();
    this.jdField_a_of_type_Bluk.a(new blss(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float));
  }
  
  public void a(Canvas paramCanvas)
  {
    this.jdField_a_of_type_Bluk.a(paramCanvas, 0, 0);
    if (super.b(0))
    {
      this.jdField_a_of_type_AndroidGraphicsRectF.set(this.jdField_a_of_type_Bluk.a(1, this.jdField_a_of_type_Bluk.a()));
      paramCanvas.drawRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, 6.0F, 6.0F, a());
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public float b()
  {
    return this.jdField_b_of_type_Float;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bluj
 * JD-Core Version:    0.7.0.1
 */