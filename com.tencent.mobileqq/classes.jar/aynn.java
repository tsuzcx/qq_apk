import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class aynn
  extends ReportDialog
{
  protected View.OnClickListener a;
  protected ImageView a;
  protected LinearLayout a;
  protected RelativeLayout a;
  protected TextView a;
  protected TextView b;
  
  public aynn(Context paramContext)
  {
    super(paramContext, 2131755829);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new ayno(this);
    a();
  }
  
  private void a()
  {
    setContentView(2131559037);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131368095));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379001));
    this.b = ((TextView)findViewById(2131370731));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131363726));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368666));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(anvx.a(2131706596));
  }
  
  public aynn a(View paramView, RelativeLayout.LayoutParams paramLayoutParams)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramView, paramLayoutParams);
    return this;
  }
  
  public aynn a(ayni paramayni)
  {
    Button localButton = new Button(getContext());
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams.topMargin = UIUtils.dip2px(getContext(), 10.0F);
    Object localObject;
    if (paramayni.jdField_a_of_type_JavaLangString != null)
    {
      localObject = paramayni.jdField_a_of_type_JavaLangString;
      localButton.setText((CharSequence)localObject);
      localButton.setTextSize(20.0F);
      if (paramayni.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
        break label134;
      }
      localObject = paramayni.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      label76:
      localButton.setBackgroundDrawable((Drawable)localObject);
      if (paramayni.jdField_a_of_type_Int == -1) {
        break label150;
      }
    }
    label134:
    label150:
    for (int i = paramayni.jdField_a_of_type_Int;; i = -1)
    {
      localButton.setTextColor(i);
      localButton.setOnClickListener(new aynp(this, paramayni));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localButton, localLayoutParams);
      return this;
      localObject = "";
      break;
      localObject = getContext().getResources().getDrawable(2130839347);
      break label76;
    }
  }
  
  public aynn a(CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramCharSequence);
    return this;
  }
  
  public aynn b(CharSequence paramCharSequence)
  {
    this.b.setText(paramCharSequence);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aynn
 * JD-Core Version:    0.7.0.1
 */