import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

class asev
  extends asew
{
  public ImageView a;
  public TextView a;
  
  public asev(View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_Int = asep.jdField_a_of_type_Int;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368180));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379199));
    paramView.setTag(this);
  }
  
  public void a(String paramString1, String paramString2, bdbb parambdbb)
  {
    Object localObject = paramString2;
    if (paramString2 == null) {
      localObject = paramString1;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(new bamp((CharSequence)localObject, 2));
    localObject = parambdbb.a(1, paramString1);
    paramString2 = (String)localObject;
    if (localObject == null)
    {
      localObject = bdhj.a();
      paramString2 = (String)localObject;
      if (!parambdbb.a())
      {
        parambdbb.a(paramString1, 1, false);
        paramString2 = (String)localObject;
      }
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asev
 * JD-Core Version:    0.7.0.1
 */