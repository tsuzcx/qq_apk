import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

class avdh
  extends avdi
{
  public ImageView a;
  public TextView a;
  
  public avdh(View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_Int = avdb.jdField_a_of_type_Int;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368580));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380309));
    paramView.setTag(this);
  }
  
  public void a(String paramString1, String paramString2, aoof paramaoof)
  {
    Object localObject = paramString2;
    if (paramString2 == null) {
      localObject = paramString1;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(new begp((CharSequence)localObject, 2));
    localObject = paramaoof.a(1, paramString1);
    paramString2 = (String)localObject;
    if (localObject == null)
    {
      localObject = bhmq.a();
      paramString2 = (String)localObject;
      if (!paramaoof.a())
      {
        paramaoof.a(paramString1, 1, false);
        paramString2 = (String)localObject;
      }
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avdh
 * JD-Core Version:    0.7.0.1
 */