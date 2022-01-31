import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class aqer
  extends aqeo
{
  private String h;
  private String i;
  
  public aqer(Intent paramIntent)
  {
    super(paramIntent);
    this.h = paramIntent.getStringExtra("uin");
    this.i = paramIntent.getStringExtra("uinname");
  }
  
  private View a(String paramString, Drawable paramDrawable)
  {
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131558905, null);
    TextView localTextView = (TextView)localView.findViewById(2131378528);
    ImageView localImageView = (ImageView)localView.findViewById(2131368031);
    localTextView.setText(paramString);
    localImageView.setImageDrawable(paramDrawable);
    return localView;
  }
  
  protected View a()
  {
    return a(String.format("[%s]%s", new Object[] { ajya.a(2131704789), this.i }), bayh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, this.h));
  }
  
  protected boolean h()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqer
 * JD-Core Version:    0.7.0.1
 */