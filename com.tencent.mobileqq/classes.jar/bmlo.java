import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;

public class bmlo
  extends bcji
{
  private BitmapFactory.Options a = new BitmapFactory.Options();
  
  public bmlo(aoof paramaoof)
  {
    super(paramaoof);
  }
  
  public void a(bcfr parambcfr, bcnz parambcnz)
  {
    parambcnz.a().setMaxWidth(800);
    bmln localbmln = (bmln)parambcfr;
    ImageView localImageView = parambcnz.b();
    localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    if ((5 == localbmln.f) || (localbmln.jdField_a_of_type_Boolean))
    {
      localImageView.setImageResource(2130844184);
      if (localbmln.jdField_d_of_type_JavaLangString == null) {
        break label186;
      }
      parambcfr = URLDrawable.URLDrawableOptions.obtain();
      parambcfr.mRequestHeight = parambcnz.b().getHeight();
      parambcfr.mRequestWidth = parambcnz.b().getWidth();
      if ((5 != localbmln.f) && (!localbmln.jdField_a_of_type_Boolean)) {
        break label136;
      }
      localImageView.setBackgroundDrawable(URLDrawable.getDrawable(localbmln.jdField_d_of_type_JavaLangString, parambcfr));
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
        localImageView.setImageDrawable(URLDrawable.getDrawable(localbmln.jdField_d_of_type_JavaLangString, parambcfr));
        return;
      }
      catch (Exception parambcfr) {}
    } while (!QLog.isColorLevel());
    QLog.d("FavoriteSearchResultPresenter", 2, "bindFace exception = " + parambcfr.toString());
    return;
    label186:
    if (localbmln.jdField_d_of_type_Int != 0)
    {
      if ((5 == localbmln.f) || (localbmln.jdField_a_of_type_Boolean))
      {
        localImageView.setBackgroundResource(localbmln.jdField_d_of_type_Int);
        return;
      }
      localImageView.setImageResource(localbmln.jdField_d_of_type_Int);
      return;
    }
    if (localbmln.jdField_a_of_type_ArrayOfByte != null)
    {
      this.a.inJustDecodeBounds = true;
      BitmapFactory.decodeByteArray(localbmln.jdField_a_of_type_ArrayOfByte, 0, localbmln.jdField_a_of_type_ArrayOfByte.length, this.a);
      this.a.inJustDecodeBounds = false;
      this.a.inSampleSize = (this.a.outWidth / parambcnz.b().getMeasuredWidth());
      try
      {
        parambcfr = new BitmapDrawable(null, BitmapFactory.decodeByteArray(localbmln.jdField_a_of_type_ArrayOfByte, 0, localbmln.jdField_a_of_type_ArrayOfByte.length, this.a));
        if ((5 == localbmln.f) || (localbmln.jdField_a_of_type_Boolean))
        {
          localImageView.setBackgroundDrawable(parambcfr);
          return;
        }
      }
      catch (OutOfMemoryError parambcfr)
      {
        for (;;)
        {
          parambcfr = null;
        }
        localImageView.setImageDrawable(parambcfr);
        return;
      }
    }
    super.a(parambcfr, parambcnz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmlo
 * JD-Core Version:    0.7.0.1
 */