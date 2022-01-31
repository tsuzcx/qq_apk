import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

class asam
  extends asan
{
  public ImageView a;
  public TextView a;
  
  public asam(View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_Int = asag.jdField_a_of_type_Int;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368169));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379141));
    paramView.setTag(this);
  }
  
  public void a(String paramString1, String paramString2, bcws parambcws)
  {
    Object localObject = paramString2;
    if (paramString2 == null) {
      localObject = paramString1;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(new baig((CharSequence)localObject, 2));
    localObject = parambcws.a(1, paramString1);
    paramString2 = (String)localObject;
    if (localObject == null)
    {
      localObject = bdda.a();
      paramString2 = (String)localObject;
      if (!parambcws.a())
      {
        parambcws.a(paramString1, 1, false);
        paramString2 = (String)localObject;
      }
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asam
 * JD-Core Version:    0.7.0.1
 */