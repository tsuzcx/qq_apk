import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

class aqgv
  extends aqgw
{
  public ImageView a;
  public TextView a;
  
  public aqgv(View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_Int = aqgp.jdField_a_of_type_Int;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368031));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378524));
    paramView.setTag(this);
  }
  
  public void a(String paramString1, String paramString2, baxk parambaxk)
  {
    Object localObject = paramString2;
    if (paramString2 == null) {
      localObject = paramString1;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(new ayki((CharSequence)localObject, 2));
    localObject = parambaxk.a(1, paramString1);
    paramString2 = (String)localObject;
    if (localObject == null)
    {
      localObject = bbdr.a();
      paramString2 = (String)localObject;
      if (!parambaxk.a())
      {
        parambaxk.a(paramString1, 1, false);
        paramString2 = (String)localObject;
      }
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqgv
 * JD-Core Version:    0.7.0.1
 */