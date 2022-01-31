import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;

public class bjmh
  implements View.OnClickListener
{
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private String b;
  
  public bjmh(View paramView, String paramString)
  {
    a(paramView);
    this.b = paramString;
  }
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131379422));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363521));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131378248));
    paramView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131379517);
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131379518);
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ColorDrawable localColorDrawable = new ColorDrawable(-16777216);
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
    localObject = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/files/20180423/4c3ece054ae044eb85797d31fa487ce7.jpg", (URLDrawable.URLDrawableOptions)localObject);
    ((URLDrawable)localObject).setURLDrawableListener(new bjmi(this.jdField_a_of_type_AndroidWidgetTextView));
    paramView.setBackgroundDrawable((Drawable)localObject);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  public RelativeLayout a()
  {
    return this.jdField_a_of_type_AndroidWidgetRelativeLayout;
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(paramOnClickListener);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean != paramBoolean)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_AndroidWidgetButton.setText(ajya.a(2131716912));
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setText(ajya.a(2131716914));
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    if (this.jdField_a_of_type_Boolean) {
      vzw.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext(), this.b, this.jdField_a_of_type_JavaLangString);
    }
    for (paramView = "clk_open";; paramView = "clk_download")
    {
      vei.a("weishi_share", paramView, 0, 0, new String[0]);
      return;
      bcql.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext(), ajya.a(2131716911), 0).a();
      vzw.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext(), this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjmh
 * JD-Core Version:    0.7.0.1
 */