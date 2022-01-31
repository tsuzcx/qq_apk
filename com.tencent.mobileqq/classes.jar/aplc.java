import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class aplc
  extends apkz
{
  private String h;
  private String i;
  
  public aplc(Intent paramIntent)
  {
    super(paramIntent);
    this.h = paramIntent.getStringExtra("uin");
    this.i = paramIntent.getStringExtra("uinname");
  }
  
  private View a(String paramString, Drawable paramDrawable)
  {
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131493344, null);
    TextView localTextView = (TextView)localView.findViewById(2131312699);
    ImageView localImageView = (ImageView)localView.findViewById(2131302411);
    localTextView.setText(paramString);
    localImageView.setImageDrawable(paramDrawable);
    return localView;
  }
  
  protected View a()
  {
    return a(String.format("[%s]%s", new Object[] { ajjy.a(2131638993), this.i }), azwp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, this.h));
  }
  
  protected boolean h()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aplc
 * JD-Core Version:    0.7.0.1
 */