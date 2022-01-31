import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qqmini.sdk.core.widget.TabBar;

public class bent
{
  public Drawable a;
  public View a;
  public ImageView a;
  public TextView a;
  public besn a;
  public beso a;
  public boolean a;
  public Drawable b;
  public View b;
  public TextView b;
  public View c;
  public View d;
  public View e;
  
  public static bent a(View paramView, beso parambeso, besn parambesn)
  {
    bent localbent = new bent();
    localbent.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377032));
    localbent.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367679));
    localbent.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131370294);
    localbent.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131370291);
    localbent.c = paramView.findViewById(2131370292);
    localbent.e = paramView.findViewById(2131370293);
    localbent.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370289));
    localbent.jdField_b_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
    localbent.jdField_b_of_type_AndroidWidgetTextView.setMaxEms(3);
    localbent.jdField_b_of_type_AndroidWidgetTextView.setSingleLine();
    localbent.d = paramView;
    localbent.jdField_a_of_type_Besn = parambesn;
    localbent.jdField_a_of_type_Beso = parambeso;
    return localbent;
  }
  
  public void a()
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if ("top".equals(this.jdField_a_of_type_Besn.jdField_b_of_type_JavaLangString))
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      localLayoutParams.bottomMargin = bfgl.a(this.d.getContext(), 15.0F);
      localLayoutParams.topMargin = bfgl.a(this.d.getContext(), 15.0F);
      this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 15.0F);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Beso.jdField_b_of_type_JavaLangString);
      if (!"top".equals(this.jdField_a_of_type_Besn.jdField_b_of_type_JavaLangString)) {
        break label225;
      }
    }
    for (;;)
    {
      a(false);
      return;
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      localLayoutParams.bottomMargin = bfgl.a(this.d.getContext(), 5.0F);
      localLayoutParams.topMargin = bfgl.a(this.d.getContext(), 0.0F);
      this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 12.0F);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      break;
      label225:
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(this.d.getContext().getResources(), this.jdField_a_of_type_Beso.a);
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(this.d.getContext().getResources(), this.jdField_a_of_type_Beso.jdField_b_of_type_AndroidGraphicsBitmap);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    int j = 855638016;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.d.setBackgroundColor(this.jdField_a_of_type_Besn.c);
    if (!paramBoolean)
    {
      localObject = this.jdField_a_of_type_AndroidWidgetTextView;
      if (this.jdField_a_of_type_Besn.jdField_a_of_type_Int == 0)
      {
        i = TabBar.jdField_a_of_type_Int;
        ((TextView)localObject).setTextColor(i);
        if (!"top".equals(this.jdField_a_of_type_Besn.jdField_b_of_type_JavaLangString)) {
          break label147;
        }
        this.c.setVisibility(8);
        label76:
        if (!"top".equals(this.jdField_a_of_type_Besn.jdField_b_of_type_JavaLangString)) {
          break label244;
        }
        localObject = this.jdField_b_of_type_AndroidViewView;
        if (!"black".equals(this.jdField_a_of_type_Besn.jdField_a_of_type_JavaLangString)) {
          break label238;
        }
      }
    }
    label147:
    label224:
    label238:
    for (int i = 855638016;; i = 872415231)
    {
      ((View)localObject).setBackgroundColor(i);
      this.c.setBackgroundColor(this.jdField_a_of_type_Besn.jdField_b_of_type_Int);
      return;
      i = this.jdField_a_of_type_Besn.jdField_a_of_type_Int;
      break;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      break label76;
      localObject = this.jdField_a_of_type_AndroidWidgetTextView;
      if (this.jdField_a_of_type_Besn.jdField_b_of_type_Int == 0) {}
      for (i = TabBar.jdField_a_of_type_Int;; i = this.jdField_a_of_type_Besn.jdField_b_of_type_Int)
      {
        ((TextView)localObject).setTextColor(i);
        if (!"top".equals(this.jdField_a_of_type_Besn.jdField_b_of_type_JavaLangString)) {
          break label224;
        }
        this.c.setVisibility(0);
        break;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
      break label76;
    }
    label244:
    Object localObject = this.jdField_a_of_type_AndroidViewView;
    if ("black".equals(this.jdField_a_of_type_Besn.jdField_a_of_type_JavaLangString)) {}
    for (i = j;; i = 872415231)
    {
      ((View)localObject).setBackgroundColor(i);
      return;
    }
  }
  
  public void b()
  {
    a(this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bent
 * JD-Core Version:    0.7.0.1
 */