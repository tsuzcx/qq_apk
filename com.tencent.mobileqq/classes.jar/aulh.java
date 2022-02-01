import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

class aulh
  extends auli
{
  public ImageView a;
  public TextView a;
  
  public aulh(View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_Int = aulb.jdField_a_of_type_Int;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368507));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380124));
    paramView.setTag(this);
  }
  
  public void a(String paramString1, String paramString2, aobu paramaobu)
  {
    Object localObject = paramString2;
    if (paramString2 == null) {
      localObject = paramString1;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(new bdnt((CharSequence)localObject, 2));
    localObject = paramaobu.a(1, paramString1);
    paramString2 = (String)localObject;
    if (localObject == null)
    {
      localObject = bgmo.a();
      paramString2 = (String)localObject;
      if (!paramaobu.a())
      {
        paramaobu.a(paramString1, 1, false);
        paramString2 = (String)localObject;
      }
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aulh
 * JD-Core Version:    0.7.0.1
 */