import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils.TruncateAt;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.widgets.KandianTextView;

public class bidd
{
  private float jdField_a_of_type_Float = 12.0F;
  private int jdField_a_of_type_Int = -1;
  private Context jdField_a_of_type_AndroidContentContext;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int = 17170445;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 17170445;
  private Drawable jdField_c_of_type_AndroidGraphicsDrawableDrawable;
  private int d = 5;
  private int e = 49;
  
  private bidd(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public bidc a()
  {
    try
    {
      int i = bdaq.a(this.jdField_a_of_type_AndroidContentContext, 300.0F);
      int j = bdaq.a(this.jdField_a_of_type_AndroidContentContext, 120.0F);
      LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      localLinearLayout.setOrientation(0);
      localLinearLayout.setPadding(bdaq.a(this.jdField_a_of_type_AndroidContentContext, 10.0F), bdaq.a(this.jdField_a_of_type_AndroidContentContext, 8.0F), bdaq.a(this.jdField_a_of_type_AndroidContentContext, 10.0F), bdaq.a(this.jdField_a_of_type_AndroidContentContext, 8.0F));
      Object localObject = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject).gravity = 17;
      localLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (this.jdField_b_of_type_Boolean) {}
      for (localObject = new KandianTextView(this.jdField_a_of_type_AndroidContentContext);; localObject = new TextView(this.jdField_a_of_type_AndroidContentContext))
      {
        ((TextView)localObject).setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(17170443));
        ((TextView)localObject).setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        localLinearLayout.addView((View)localObject);
        if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
        {
          int k = localLinearLayout.getPaddingLeft();
          int m = localLinearLayout.getPaddingTop();
          int n = localLinearLayout.getPaddingRight();
          int i1 = localLinearLayout.getPaddingBottom();
          localLinearLayout.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          localLinearLayout.setPadding(k, m, n, i1);
        }
        ((TextView)localObject).setMaxWidth(i);
        ((TextView)localObject).setMaxHeight(j);
        ((TextView)localObject).setEllipsize(TextUtils.TruncateAt.END);
        ((TextView)localObject).setText(this.jdField_a_of_type_JavaLangString);
        ((TextView)localObject).setTextSize(this.jdField_a_of_type_Float);
        ((TextView)localObject).setTextColor(this.jdField_a_of_type_Int);
        localLinearLayout.measure(i, j);
        localObject = new bidc(this.jdField_a_of_type_AndroidContentContext, localLinearLayout.getMeasuredWidth(), this.e);
        ((bidc)localObject).d(this.jdField_b_of_type_Int);
        ((bidc)localObject).a(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
        ((bidc)localObject).b(this.jdField_c_of_type_AndroidGraphicsDrawableDrawable);
        ((bidc)localObject).e(this.jdField_c_of_type_Int);
        ((bidc)localObject).setContentView(localLinearLayout);
        ((bidc)localObject).a(83);
        if (!this.jdField_a_of_type_Boolean) {
          ((bidc)localObject).setOutsideTouchable(false);
        }
        ((bidc)localObject).b(bdaq.a(this.jdField_a_of_type_AndroidContentContext, 6.0F));
        bidc.a((bidc)localObject, this.d);
        return localObject;
      }
      return null;
    }
    catch (Throwable localThrowable)
    {
      Log.e("CalloutPopupWindow", "[build] failed to build window", localThrowable);
    }
  }
  
  public bidd a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
    return this;
  }
  
  public bidd a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public bidd a(Drawable paramDrawable)
  {
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    return this;
  }
  
  public bidd a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public bidd a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public bidd b(int paramInt)
  {
    this.d = paramInt;
    return this;
  }
  
  public bidd b(Drawable paramDrawable)
  {
    this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    return this;
  }
  
  public bidd c(int paramInt)
  {
    this.e = paramInt;
    return this;
  }
  
  public bidd c(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bidd
 * JD-Core Version:    0.7.0.1
 */