import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;

public class bgqd
  extends awry
{
  private BitmapFactory.Options a = new BitmapFactory.Options();
  
  public bgqd(baxk parambaxk)
  {
    super(parambaxk);
  }
  
  public void a(awog paramawog, awwp paramawwp)
  {
    paramawwp.a().setMaxWidth(800);
    bgqc localbgqc = (bgqc)paramawog;
    ImageView localImageView = paramawwp.b();
    localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    if ((5 == localbgqc.f) || (localbgqc.jdField_a_of_type_Boolean))
    {
      localImageView.setImageResource(2130843369);
      if (localbgqc.jdField_d_of_type_JavaLangString == null) {
        break label186;
      }
      paramawog = URLDrawable.URLDrawableOptions.obtain();
      paramawog.mRequestHeight = paramawwp.b().getHeight();
      paramawog.mRequestWidth = paramawwp.b().getWidth();
      if ((5 != localbgqc.f) && (!localbgqc.jdField_a_of_type_Boolean)) {
        break label136;
      }
      localImageView.setBackgroundDrawable(URLDrawable.getDrawable(localbgqc.jdField_d_of_type_JavaLangString, paramawog));
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
        localImageView.setImageDrawable(URLDrawable.getDrawable(localbgqc.jdField_d_of_type_JavaLangString, paramawog));
        return;
      }
      catch (Exception paramawog) {}
    } while (!QLog.isColorLevel());
    QLog.d("FavoriteSearchResultPresenter", 2, "bindFace exception = " + paramawog.toString());
    return;
    label186:
    if (localbgqc.jdField_d_of_type_Int != 0)
    {
      if ((5 == localbgqc.f) || (localbgqc.jdField_a_of_type_Boolean))
      {
        localImageView.setBackgroundResource(localbgqc.jdField_d_of_type_Int);
        return;
      }
      localImageView.setImageResource(localbgqc.jdField_d_of_type_Int);
      return;
    }
    if (localbgqc.jdField_a_of_type_ArrayOfByte != null)
    {
      this.a.inJustDecodeBounds = true;
      BitmapFactory.decodeByteArray(localbgqc.jdField_a_of_type_ArrayOfByte, 0, localbgqc.jdField_a_of_type_ArrayOfByte.length, this.a);
      this.a.inJustDecodeBounds = false;
      this.a.inSampleSize = (this.a.outWidth / paramawwp.b().getMeasuredWidth());
      try
      {
        paramawog = new BitmapDrawable(null, BitmapFactory.decodeByteArray(localbgqc.jdField_a_of_type_ArrayOfByte, 0, localbgqc.jdField_a_of_type_ArrayOfByte.length, this.a));
        if ((5 == localbgqc.f) || (localbgqc.jdField_a_of_type_Boolean))
        {
          localImageView.setBackgroundDrawable(paramawog);
          return;
        }
      }
      catch (OutOfMemoryError paramawog)
      {
        for (;;)
        {
          paramawog = null;
        }
        localImageView.setImageDrawable(paramawog);
        return;
      }
    }
    super.a(paramawog, paramawwp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgqd
 * JD-Core Version:    0.7.0.1
 */