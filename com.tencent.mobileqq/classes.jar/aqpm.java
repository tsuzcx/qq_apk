import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class aqpm
  implements aqpl
{
  int jdField_a_of_type_Int = 0;
  Rect jdField_a_of_type_AndroidGraphicsRect;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  bcnz jdField_a_of_type_Bcnz;
  boolean jdField_a_of_type_Boolean = false;
  boolean b = false;
  
  private void a(Activity paramActivity)
  {
    Object localObject1 = null;
    try
    {
      localObject2 = BitmapFactory.decodeResource(paramActivity.getResources(), 2130847638);
      localObject1 = localObject2;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      Object localObject2;
      label14:
      break label14;
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = Bitmap.createBitmap(4, 4, Bitmap.Config.ARGB_8888);
    }
    this.jdField_a_of_type_Bcnz = new bcnz((Bitmap)localObject2, (int)(paramActivity.getResources().getDisplayMetrics().density * 12.0F));
    this.jdField_a_of_type_Bcnz.setLevel(0);
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect(0, 0, 0, 0);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    if ((this.b) && (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 4))
    {
      if ((this.jdField_a_of_type_AndroidGraphicsRect.width() == 0) || (this.jdField_a_of_type_AndroidGraphicsRect.height() == 0))
      {
        this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, this.jdField_a_of_type_AndroidWidgetImageView.getWidth(), this.jdField_a_of_type_AndroidWidgetImageView.getHeight());
        this.jdField_a_of_type_Bcnz.setBounds(this.jdField_a_of_type_AndroidGraphicsRect);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_Bcnz);
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.b = true;
    if (this.jdField_a_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_AndroidGraphicsRect.width() == 0) || (this.jdField_a_of_type_AndroidGraphicsRect.height() == 0))
      {
        this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, this.jdField_a_of_type_AndroidWidgetImageView.getWidth(), this.jdField_a_of_type_AndroidWidgetImageView.getHeight());
        this.jdField_a_of_type_Bcnz.setBounds(this.jdField_a_of_type_AndroidGraphicsRect);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_Bcnz);
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    if ((paramInt >= 0) && (paramInt < 100))
    {
      this.jdField_a_of_type_Bcnz.setLevel(paramInt * 100);
      this.jdField_a_of_type_Bcnz.invalidateSelf();
      return;
    }
    this.jdField_a_of_type_Bcnz.a();
  }
  
  public void a(Activity paramActivity, aqoi paramaqoi)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((RelativeLayout)paramaqoi.a()).findViewById(2131372034));
    a(paramActivity);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    }
  }
  
  public boolean b()
  {
    return this.b;
  }
  
  public void c()
  {
    this.jdField_a_of_type_Int = 0;
    this.b = false;
    if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqpm
 * JD-Core Version:    0.7.0.1
 */