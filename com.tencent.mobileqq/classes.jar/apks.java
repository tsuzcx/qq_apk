import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

class apks
  extends apkt
{
  public ImageView a;
  public TextView a;
  
  public apks(View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_Int = apkm.jdField_a_of_type_Int;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131302411));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131312700));
    paramView.setTag(this);
  }
  
  public void a(String paramString1, String paramString2, azwg paramazwg)
  {
    Object localObject = paramString2;
    if (paramString2 == null) {
      localObject = paramString1;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(new axkd((CharSequence)localObject, 2));
    localObject = paramazwg.a(1, paramString1);
    paramString2 = (String)localObject;
    if (localObject == null)
    {
      localObject = bacm.a();
      paramString2 = (String)localObject;
      if (!paramazwg.a())
      {
        paramazwg.a(paramString1, 1, false);
        paramString2 = (String)localObject;
      }
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apks
 * JD-Core Version:    0.7.0.1
 */