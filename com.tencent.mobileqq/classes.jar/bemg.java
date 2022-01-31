import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class bemg
  extends Dialog
{
  Bundle jdField_a_of_type_AndroidOsBundle;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private boolean jdField_a_of_type_Boolean;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  TextView c;
  TextView d;
  TextView e;
  TextView f;
  
  public bemg(Context paramContext)
  {
    super(paramContext, 2131755751);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2131559285, null);
    setContentView(paramContext);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramContext.findViewById(2131370207));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131370220));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131362882));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramContext.findViewById(2131378758));
    this.c = ((TextView)paramContext.findViewById(2131378786));
    this.d = ((TextView)paramContext.findViewById(2131362872));
    this.e = ((TextView)paramContext.findViewById(2131369106));
    this.f = ((TextView)paramContext.findViewById(2131375270));
    setCanceledOnTouchOutside(true);
    paramContext = getWindow();
    if (paramContext != null) {
      paramContext.setGravity(80);
    }
  }
  
  public Bundle a()
  {
    return this.jdField_a_of_type_AndroidOsBundle;
  }
  
  public void a(Drawable paramDrawable1, String paramString1, String paramString2, Drawable paramDrawable2, String paramString3, String paramString4, String paramString5, View.OnClickListener paramOnClickListener1, String paramString6, View.OnClickListener paramOnClickListener2)
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable1);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString1);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString2);
    if (paramDrawable2 == null)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      if (!TextUtils.isEmpty(paramString3)) {
        break label141;
      }
      this.c.setVisibility(8);
      label65:
      if (!TextUtils.isEmpty(paramString5)) {
        break label161;
      }
      this.e.setVisibility(8);
      label82:
      if (!TextUtils.isEmpty(paramString6)) {
        break label190;
      }
      this.f.setVisibility(8);
      label99:
      if (!TextUtils.isEmpty(paramString4)) {
        break label219;
      }
      this.d.setVisibility(8);
    }
    for (;;)
    {
      show();
      return;
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable2);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      break;
      label141:
      this.c.setText(paramString3);
      this.c.setVisibility(0);
      break label65;
      label161:
      this.e.setText(paramString5);
      this.e.setOnClickListener(paramOnClickListener1);
      this.e.setVisibility(0);
      break label82;
      label190:
      this.f.setText(paramString6);
      this.f.setOnClickListener(paramOnClickListener2);
      this.f.setVisibility(0);
      break label99;
      label219:
      this.d.setVisibility(0);
      this.d.setText(paramString4);
    }
  }
  
  public void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bemg
 * JD-Core Version:    0.7.0.1
 */