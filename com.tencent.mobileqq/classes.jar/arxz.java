import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class arxz
  extends arxw
{
  private String h;
  private String i;
  
  public arxz(Intent paramIntent)
  {
    super(paramIntent);
    this.h = paramIntent.getStringExtra("uin");
    this.i = paramIntent.getStringExtra("uinname");
  }
  
  private View a(String paramString, Drawable paramDrawable)
  {
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131558942, null);
    TextView localTextView = (TextView)localView.findViewById(2131379140);
    ImageView localImageView = (ImageView)localView.findViewById(2131368169);
    localTextView.setText(paramString);
    localImageView.setImageDrawable(paramDrawable);
    return localView;
  }
  
  protected View a()
  {
    return a(String.format("[%s]%s", new Object[] { alpo.a(2131705161), this.i }), bcxb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, this.h));
  }
  
  protected boolean h()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arxz
 * JD-Core Version:    0.7.0.1
 */