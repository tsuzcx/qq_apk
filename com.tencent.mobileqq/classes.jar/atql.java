import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.text.QQText;

class atql
  extends atqm
{
  public ImageView a;
  public TextView a;
  
  public atql(View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_Int = atqf.jdField_a_of_type_Int;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368605));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380035));
    paramView.setTag(this);
  }
  
  public void a(String paramString1, String paramString2, FaceDecoder paramFaceDecoder)
  {
    Object localObject = paramString2;
    if (paramString2 == null) {
      localObject = paramString1;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(new QQText((CharSequence)localObject, 2));
    localObject = paramFaceDecoder.getBitmapFromCache(1, paramString1);
    paramString2 = (String)localObject;
    if (localObject == null)
    {
      localObject = bfvo.a();
      paramString2 = (String)localObject;
      if (!paramFaceDecoder.isPausing())
      {
        paramFaceDecoder.requestDecodeFace(paramString1, 1, false);
        paramString2 = (String)localObject;
      }
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atql
 * JD-Core Version:    0.7.0.1
 */