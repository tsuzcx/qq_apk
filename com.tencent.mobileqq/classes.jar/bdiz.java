import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qqmini.sdk.core.widget.TabBar;

public class bdiz
{
  public Drawable a;
  public View a;
  public ImageView a;
  public TextView a;
  public bdni a;
  public bdnj a;
  public boolean a;
  public Drawable b;
  public View b;
  public TextView b;
  public View c;
  public View d;
  public View e;
  
  public static bdiz a(View paramView, bdnj parambdnj, bdni parambdni)
  {
    bdiz localbdiz = new bdiz();
    localbdiz.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131311220));
    localbdiz.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131302061));
    localbdiz.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131304610);
    localbdiz.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131304607);
    localbdiz.c = paramView.findViewById(2131304608);
    localbdiz.e = paramView.findViewById(2131304609);
    localbdiz.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131304605));
    localbdiz.jdField_b_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
    localbdiz.jdField_b_of_type_AndroidWidgetTextView.setMaxEms(3);
    localbdiz.jdField_b_of_type_AndroidWidgetTextView.setSingleLine();
    localbdiz.d = paramView;
    localbdiz.jdField_a_of_type_Bdni = parambdni;
    localbdiz.jdField_a_of_type_Bdnj = parambdnj;
    return localbdiz;
  }
  
  public void a()
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if ("top".equals(this.jdField_a_of_type_Bdni.jdField_b_of_type_JavaLangString))
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      localLayoutParams.bottomMargin = bdyn.a(this.d.getContext(), 15.0F);
      localLayoutParams.topMargin = bdyn.a(this.d.getContext(), 15.0F);
      this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 15.0F);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Bdnj.jdField_b_of_type_JavaLangString);
      if (!"top".equals(this.jdField_a_of_type_Bdni.jdField_b_of_type_JavaLangString)) {
        break label225;
      }
    }
    for (;;)
    {
      a(false);
      return;
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      localLayoutParams.bottomMargin = bdyn.a(this.d.getContext(), 5.0F);
      localLayoutParams.topMargin = bdyn.a(this.d.getContext(), 0.0F);
      this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 12.0F);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      break;
      label225:
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(this.d.getContext().getResources(), this.jdField_a_of_type_Bdnj.a);
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(this.d.getContext().getResources(), this.jdField_a_of_type_Bdnj.jdField_b_of_type_AndroidGraphicsBitmap);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    int j = 855638016;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.d.setBackgroundColor(this.jdField_a_of_type_Bdni.c);
    if (!paramBoolean)
    {
      localObject = this.jdField_a_of_type_AndroidWidgetTextView;
      if (this.jdField_a_of_type_Bdni.jdField_a_of_type_Int == 0)
      {
        i = TabBar.jdField_a_of_type_Int;
        ((TextView)localObject).setTextColor(i);
        if (!"top".equals(this.jdField_a_of_type_Bdni.jdField_b_of_type_JavaLangString)) {
          break label147;
        }
        this.c.setVisibility(8);
        label76:
        if (!"top".equals(this.jdField_a_of_type_Bdni.jdField_b_of_type_JavaLangString)) {
          break label244;
        }
        localObject = this.jdField_b_of_type_AndroidViewView;
        if (!"black".equals(this.jdField_a_of_type_Bdni.jdField_a_of_type_JavaLangString)) {
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
      this.c.setBackgroundColor(this.jdField_a_of_type_Bdni.jdField_b_of_type_Int);
      return;
      i = this.jdField_a_of_type_Bdni.jdField_a_of_type_Int;
      break;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      break label76;
      localObject = this.jdField_a_of_type_AndroidWidgetTextView;
      if (this.jdField_a_of_type_Bdni.jdField_b_of_type_Int == 0) {}
      for (i = TabBar.jdField_a_of_type_Int;; i = this.jdField_a_of_type_Bdni.jdField_b_of_type_Int)
      {
        ((TextView)localObject).setTextColor(i);
        if (!"top".equals(this.jdField_a_of_type_Bdni.jdField_b_of_type_JavaLangString)) {
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
    if ("black".equals(this.jdField_a_of_type_Bdni.jdField_a_of_type_JavaLangString)) {}
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
 * Qualified Name:     bdiz
 * JD-Core Version:    0.7.0.1
 */