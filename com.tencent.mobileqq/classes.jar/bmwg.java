import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.text.InputFilter;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.ChnToSpell;
import dov.com.qq.im.capture.text.DynamicTextItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bmwg
  extends DynamicTextItem
{
  private Resources jdField_a_of_type_AndroidContentResResources;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private InputFilter jdField_a_of_type_AndroidTextInputFilter;
  private TextPaint jdField_a_of_type_AndroidTextTextPaint;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private int jdField_b_of_type_Int;
  private TextPaint jdField_b_of_type_AndroidTextTextPaint;
  private ArrayList<Integer> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private int jdField_c_of_type_Int;
  private ArrayList<ArrayList<Integer>> jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  private int jdField_d_of_type_Int;
  private ArrayList<Integer> jdField_d_of_type_JavaUtilArrayList = new ArrayList();
  
  public bmwg(int paramInt, @NonNull List<String> paramList, Typeface paramTypeface1, Typeface paramTypeface2, Bitmap paramBitmap)
  {
    super(paramInt, paramList);
    a(BaseApplicationImpl.getContext(), paramTypeface1, paramTypeface2, paramBitmap);
    if (!paramList.isEmpty()) {
      a(0, (String)paramList.get(0));
    }
  }
  
  private int a(float paramFloat)
  {
    return (int)(this.jdField_a_of_type_AndroidContentResResources.getDisplayMetrics().density * paramFloat);
  }
  
  private int a(ArrayList<Integer> paramArrayList)
  {
    int i = this.jdField_c_of_type_Int;
    paramArrayList = paramArrayList.iterator();
    i *= 2;
    if (paramArrayList.hasNext())
    {
      Integer localInteger = (Integer)paramArrayList.next();
      if (localInteger.intValue() <= i) {
        break label51;
      }
      i = localInteger.intValue();
    }
    label51:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  private void a(Context paramContext, Typeface paramTypeface1, Typeface paramTypeface2, Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidContentResResources = paramContext.getResources();
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    a(paramTypeface2, paramTypeface1);
    this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
  }
  
  private void a(Typeface paramTypeface1, Typeface paramTypeface2)
  {
    this.jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
    this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(paramTypeface2);
    this.jdField_a_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(Color.parseColor("#ffffff"));
    this.jdField_a_of_type_AndroidTextTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(a(79.5F));
    this.jdField_a_of_type_AndroidTextTextPaint.setTextAlign(Paint.Align.CENTER);
    this.jdField_c_of_type_Int = ((int)this.jdField_a_of_type_AndroidTextTextPaint.measureText(amtj.a(2131705125)));
    this.jdField_b_of_type_AndroidTextTextPaint = new TextPaint();
    this.jdField_b_of_type_AndroidTextTextPaint.setTypeface(paramTypeface1);
    this.jdField_b_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidTextTextPaint.setColor(Color.parseColor("#ffffff"));
    this.jdField_b_of_type_AndroidTextTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    this.jdField_b_of_type_AndroidTextTextPaint.setTextSize(a(14.0F));
    this.jdField_a_of_type_AndroidTextTextPaint.setTextAlign(Paint.Align.LEFT);
    this.jdField_d_of_type_Int = ((int)(this.jdField_c_of_type_Int * 1.3F));
  }
  
  public float a()
  {
    return this.jdField_b_of_type_Int + 10;
  }
  
  public int a()
  {
    return 1;
  }
  
  public InputFilter a()
  {
    if (this.jdField_a_of_type_AndroidTextInputFilter == null) {
      this.jdField_a_of_type_AndroidTextInputFilter = new bmwi(this, 20);
    }
    return this.jdField_a_of_type_AndroidTextInputFilter;
  }
  
  public void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_d_of_type_JavaUtilArrayList.clear();
    paramString = super.a(paramInt, new bmwh(this)).split("\n");
    int i = paramString.length;
    paramInt = 0;
    if (paramInt < i)
    {
      Object localObject = paramString[paramInt];
      if ((((String)localObject).length() == 6) && (i == 1))
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
        this.jdField_d_of_type_JavaUtilArrayList.add(Integer.valueOf((int)this.jdField_a_of_type_AndroidTextTextPaint.measureText((String)localObject)));
      }
      for (;;)
      {
        paramInt += 1;
        break;
        String str;
        if (((String)localObject).length() > 15)
        {
          str = ((String)localObject).substring(0, 5);
          this.jdField_a_of_type_JavaUtilArrayList.add(str);
          this.jdField_d_of_type_JavaUtilArrayList.add(Integer.valueOf((int)this.jdField_a_of_type_AndroidTextTextPaint.measureText(str)));
          str = ((String)localObject).substring(5, 10);
          this.jdField_a_of_type_JavaUtilArrayList.add(str);
          this.jdField_d_of_type_JavaUtilArrayList.add(Integer.valueOf((int)this.jdField_a_of_type_AndroidTextTextPaint.measureText(str)));
          str = ((String)localObject).substring(10, 15);
          this.jdField_a_of_type_JavaUtilArrayList.add(str);
          this.jdField_d_of_type_JavaUtilArrayList.add(Integer.valueOf((int)this.jdField_a_of_type_AndroidTextTextPaint.measureText(str)));
          localObject = ((String)localObject).substring(15, ((String)localObject).length());
          this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
          this.jdField_d_of_type_JavaUtilArrayList.add(Integer.valueOf((int)this.jdField_a_of_type_AndroidTextTextPaint.measureText((String)localObject)));
        }
        else if (((String)localObject).length() > 10)
        {
          str = ((String)localObject).substring(0, 5);
          this.jdField_a_of_type_JavaUtilArrayList.add(str);
          this.jdField_d_of_type_JavaUtilArrayList.add(Integer.valueOf((int)this.jdField_a_of_type_AndroidTextTextPaint.measureText(str)));
          str = ((String)localObject).substring(5, 10);
          this.jdField_a_of_type_JavaUtilArrayList.add(str);
          this.jdField_d_of_type_JavaUtilArrayList.add(Integer.valueOf((int)this.jdField_a_of_type_AndroidTextTextPaint.measureText(str)));
          localObject = ((String)localObject).substring(10, ((String)localObject).length());
          this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
          this.jdField_d_of_type_JavaUtilArrayList.add(Integer.valueOf((int)this.jdField_a_of_type_AndroidTextTextPaint.measureText((String)localObject)));
        }
        else if (((String)localObject).length() > 5)
        {
          str = ((String)localObject).substring(0, 5);
          this.jdField_a_of_type_JavaUtilArrayList.add(str);
          this.jdField_d_of_type_JavaUtilArrayList.add(Integer.valueOf((int)this.jdField_a_of_type_AndroidTextTextPaint.measureText(str)));
          localObject = ((String)localObject).substring(5, ((String)localObject).length());
          this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
          this.jdField_d_of_type_JavaUtilArrayList.add(Integer.valueOf((int)this.jdField_a_of_type_AndroidTextTextPaint.measureText((String)localObject)));
        }
        else
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
          this.jdField_d_of_type_JavaUtilArrayList.add(Integer.valueOf((int)this.jdField_a_of_type_AndroidTextTextPaint.measureText((String)localObject)));
        }
      }
    }
    this.jdField_b_of_type_Int = a(this.jdField_d_of_type_JavaUtilArrayList);
  }
  
  public void a(Canvas paramCanvas)
  {
    if (super.b(0)) {
      paramCanvas.drawRoundRect(new RectF(5.0F, 5.0F, a() - 5.0F, b() - 5.0F), 6.0F, 6.0F, a());
    }
    paramCanvas.save();
    paramCanvas.translate(this.jdField_b_of_type_Int - a(77.0F), this.jdField_d_of_type_Int - a(78.0F));
    Object localObject1 = new RectF();
    ((RectF)localObject1).set(0.0F, 0.0F, a(45.0F), a(45.0F));
    paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsRect, (RectF)localObject1, null);
    paramCanvas.restore();
    int i = this.jdField_d_of_type_Int;
    int i1 = this.jdField_a_of_type_JavaUtilArrayList.size();
    int j = 0;
    while (j < i1)
    {
      int n = (this.jdField_b_of_type_Int - ((Integer)this.jdField_d_of_type_JavaUtilArrayList.get(j)).intValue()) / 2;
      String str = (String)this.jdField_a_of_type_JavaUtilArrayList.get(j);
      int k = 0;
      int m = 0;
      if (m < str.length())
      {
        Object localObject2 = str.substring(m, m + 1);
        label242:
        int i3;
        int i2;
        if (bmwy.a(((String)localObject2).charAt(0)) == 3)
        {
          localObject1 = localObject2;
          Rect localRect = new Rect();
          this.jdField_a_of_type_AndroidTextTextPaint.getTextBounds((String)localObject2, 0, 1, localRect);
          i3 = Math.abs(localRect.top - localRect.bottom) + 20;
          i2 = Math.abs(localRect.right - localRect.left) + 20;
          paramCanvas.drawText((String)localObject2, n, i - 0.085F * this.jdField_d_of_type_Int, this.jdField_a_of_type_AndroidTextTextPaint);
          float f1 = n;
          float f2 = i - this.jdField_d_of_type_Int + (this.jdField_d_of_type_Int - i3) / 2;
          float f3 = n + i2;
          int i4 = this.jdField_d_of_type_Int;
          localObject2 = new RectF(f1, f2, f3, (i3 + this.jdField_d_of_type_Int) / 2 + (i - i4));
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localRect = new Rect();
            this.jdField_b_of_type_AndroidTextTextPaint.getTextBounds((String)localObject1, 0, ((String)localObject1).length(), localRect);
            i3 = localRect.right - localRect.left;
            if (k % 2 != 0) {
              break label510;
            }
            paramCanvas.drawText((String)localObject1, (i2 - i3) / 2 + n, ((RectF)localObject2).top, this.jdField_b_of_type_AndroidTextTextPaint);
          }
        }
        for (;;)
        {
          n += i2;
          m += 1;
          k += 1;
          break;
          localObject1 = ChnToSpell.a((String)localObject2, 1).a;
          break label242;
          label510:
          paramCanvas.drawText((String)localObject1, (i2 - i3) / 2 + n, ((RectF)localObject2).bottom + 30.0F, this.jdField_b_of_type_AndroidTextTextPaint);
        }
      }
      k = this.jdField_d_of_type_Int;
      j += 1;
      i += k;
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public float b()
  {
    int j = this.jdField_d_of_type_Int;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0) {}
    for (int i = 1;; i = this.jdField_a_of_type_JavaUtilArrayList.size()) {
      return i * j + 10;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmwg
 * JD-Core Version:    0.7.0.1
 */