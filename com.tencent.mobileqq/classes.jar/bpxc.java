import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bpxc
  implements View.OnClickListener
{
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private String b;
  
  public bpxc(View paramView, String paramString)
  {
    a(paramView);
    this.b = paramString;
  }
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131381346));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363788));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131379932));
    paramView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131381464);
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131381465);
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ColorDrawable localColorDrawable = new ColorDrawable(-16777216);
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
    localObject = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/files/20180423/4c3ece054ae044eb85797d31fa487ce7.jpg", (URLDrawable.URLDrawableOptions)localObject);
    ((URLDrawable)localObject).setURLDrawableListener(new bpxd(this.jdField_a_of_type_AndroidWidgetTextView));
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
        this.jdField_a_of_type_AndroidWidgetButton.setText(anzj.a(2131715682));
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setText(anzj.a(2131715684));
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    if (this.jdField_a_of_type_Boolean) {
      zqd.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext(), this.b, this.jdField_a_of_type_JavaLangString);
    }
    for (String str = "clk_open";; str = "clk_download")
    {
      yup.a("weishi_share", str, 0, 0, new String[0]);
      break;
      QQToast.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext(), anzj.a(2131715681), 0).a();
      zqd.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext(), this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpxc
 * JD-Core Version:    0.7.0.1
 */