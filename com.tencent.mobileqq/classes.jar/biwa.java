import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;

public class biwa
  extends ayrm
{
  private BitmapFactory.Options a = new BitmapFactory.Options();
  
  public biwa(bdbb parambdbb)
  {
    super(parambdbb);
  }
  
  public void a(aynu paramaynu, aywd paramaywd)
  {
    paramaywd.a().setMaxWidth(800);
    bivz localbivz = (bivz)paramaynu;
    ImageView localImageView = paramaywd.b();
    localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    if ((5 == localbivz.f) || (localbivz.jdField_a_of_type_Boolean))
    {
      localImageView.setImageResource(2130843795);
      if (localbivz.jdField_d_of_type_JavaLangString == null) {
        break label186;
      }
      paramaynu = URLDrawable.URLDrawableOptions.obtain();
      paramaynu.mRequestHeight = paramaywd.b().getHeight();
      paramaynu.mRequestWidth = paramaywd.b().getWidth();
      if ((5 != localbivz.f) && (!localbivz.jdField_a_of_type_Boolean)) {
        break label136;
      }
      localImageView.setBackgroundDrawable(URLDrawable.getDrawable(localbivz.jdField_d_of_type_JavaLangString, paramaynu));
    }
    label136:
    do
    {
      return;
      localImageView.setImageDrawable(null);
      localImageView.setBackgroundDrawable(null);
      break;
      try
      {
        localImageView.setImageDrawable(URLDrawable.getDrawable(localbivz.jdField_d_of_type_JavaLangString, paramaynu));
        return;
      }
      catch (Exception paramaynu) {}
    } while (!QLog.isColorLevel());
    QLog.d("FavoriteSearchResultPresenter", 2, "bindFace exception = " + paramaynu.toString());
    return;
    label186:
    if (localbivz.jdField_d_of_type_Int != 0)
    {
      if ((5 == localbivz.f) || (localbivz.jdField_a_of_type_Boolean))
      {
        localImageView.setBackgroundResource(localbivz.jdField_d_of_type_Int);
        return;
      }
      localImageView.setImageResource(localbivz.jdField_d_of_type_Int);
      return;
    }
    if (localbivz.jdField_a_of_type_ArrayOfByte != null)
    {
      this.a.inJustDecodeBounds = true;
      BitmapFactory.decodeByteArray(localbivz.jdField_a_of_type_ArrayOfByte, 0, localbivz.jdField_a_of_type_ArrayOfByte.length, this.a);
      this.a.inJustDecodeBounds = false;
      this.a.inSampleSize = (this.a.outWidth / paramaywd.b().getMeasuredWidth());
      try
      {
        paramaynu = new BitmapDrawable(null, BitmapFactory.decodeByteArray(localbivz.jdField_a_of_type_ArrayOfByte, 0, localbivz.jdField_a_of_type_ArrayOfByte.length, this.a));
        if ((5 == localbivz.f) || (localbivz.jdField_a_of_type_Boolean))
        {
          localImageView.setBackgroundDrawable(paramaynu);
          return;
        }
      }
      catch (OutOfMemoryError paramaynu)
      {
        for (;;)
        {
          paramaynu = null;
        }
        localImageView.setImageDrawable(paramaynu);
        return;
      }
    }
    super.a(paramaynu, paramaywd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     biwa
 * JD-Core Version:    0.7.0.1
 */