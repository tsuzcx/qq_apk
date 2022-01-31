import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;

public class bgqu
  extends awsa
{
  private BitmapFactory.Options a = new BitmapFactory.Options();
  
  public bgqu(baxy parambaxy)
  {
    super(parambaxy);
  }
  
  public void a(awoi paramawoi, awwr paramawwr)
  {
    paramawwr.a().setMaxWidth(800);
    bgqt localbgqt = (bgqt)paramawoi;
    ImageView localImageView = paramawwr.b();
    localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    if ((5 == localbgqt.f) || (localbgqt.jdField_a_of_type_Boolean))
    {
      localImageView.setImageResource(2130843370);
      if (localbgqt.jdField_d_of_type_JavaLangString == null) {
        break label186;
      }
      paramawoi = URLDrawable.URLDrawableOptions.obtain();
      paramawoi.mRequestHeight = paramawwr.b().getHeight();
      paramawoi.mRequestWidth = paramawwr.b().getWidth();
      if ((5 != localbgqt.f) && (!localbgqt.jdField_a_of_type_Boolean)) {
        break label136;
      }
      localImageView.setBackgroundDrawable(URLDrawable.getDrawable(localbgqt.jdField_d_of_type_JavaLangString, paramawoi));
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
        localImageView.setImageDrawable(URLDrawable.getDrawable(localbgqt.jdField_d_of_type_JavaLangString, paramawoi));
        return;
      }
      catch (Exception paramawoi) {}
    } while (!QLog.isColorLevel());
    QLog.d("FavoriteSearchResultPresenter", 2, "bindFace exception = " + paramawoi.toString());
    return;
    label186:
    if (localbgqt.jdField_d_of_type_Int != 0)
    {
      if ((5 == localbgqt.f) || (localbgqt.jdField_a_of_type_Boolean))
      {
        localImageView.setBackgroundResource(localbgqt.jdField_d_of_type_Int);
        return;
      }
      localImageView.setImageResource(localbgqt.jdField_d_of_type_Int);
      return;
    }
    if (localbgqt.jdField_a_of_type_ArrayOfByte != null)
    {
      this.a.inJustDecodeBounds = true;
      BitmapFactory.decodeByteArray(localbgqt.jdField_a_of_type_ArrayOfByte, 0, localbgqt.jdField_a_of_type_ArrayOfByte.length, this.a);
      this.a.inJustDecodeBounds = false;
      this.a.inSampleSize = (this.a.outWidth / paramawwr.b().getMeasuredWidth());
      try
      {
        paramawoi = new BitmapDrawable(null, BitmapFactory.decodeByteArray(localbgqt.jdField_a_of_type_ArrayOfByte, 0, localbgqt.jdField_a_of_type_ArrayOfByte.length, this.a));
        if ((5 == localbgqt.f) || (localbgqt.jdField_a_of_type_Boolean))
        {
          localImageView.setBackgroundDrawable(paramawoi);
          return;
        }
      }
      catch (OutOfMemoryError paramawoi)
      {
        for (;;)
        {
          paramawoi = null;
        }
        localImageView.setImageDrawable(paramawoi);
        return;
      }
    }
    super.a(paramawoi, paramawwr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgqu
 * JD-Core Version:    0.7.0.1
 */