import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;

public class blkl
  extends bbqp
{
  private BitmapFactory.Options a = new BitmapFactory.Options();
  
  public blkl(aobu paramaobu)
  {
    super(paramaobu);
  }
  
  public void a(bbmy parambbmy, bbvg parambbvg)
  {
    parambbvg.a().setMaxWidth(800);
    blkk localblkk = (blkk)parambbmy;
    ImageView localImageView = parambbvg.b();
    localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    if ((5 == localblkk.f) || (localblkk.jdField_a_of_type_Boolean))
    {
      localImageView.setImageResource(2130844170);
      if (localblkk.jdField_d_of_type_JavaLangString == null) {
        break label186;
      }
      parambbmy = URLDrawable.URLDrawableOptions.obtain();
      parambbmy.mRequestHeight = parambbvg.b().getHeight();
      parambbmy.mRequestWidth = parambbvg.b().getWidth();
      if ((5 != localblkk.f) && (!localblkk.jdField_a_of_type_Boolean)) {
        break label136;
      }
      localImageView.setBackgroundDrawable(URLDrawable.getDrawable(localblkk.jdField_d_of_type_JavaLangString, parambbmy));
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
        localImageView.setImageDrawable(URLDrawable.getDrawable(localblkk.jdField_d_of_type_JavaLangString, parambbmy));
        return;
      }
      catch (Exception parambbmy) {}
    } while (!QLog.isColorLevel());
    QLog.d("FavoriteSearchResultPresenter", 2, "bindFace exception = " + parambbmy.toString());
    return;
    label186:
    if (localblkk.jdField_d_of_type_Int != 0)
    {
      if ((5 == localblkk.f) || (localblkk.jdField_a_of_type_Boolean))
      {
        localImageView.setBackgroundResource(localblkk.jdField_d_of_type_Int);
        return;
      }
      localImageView.setImageResource(localblkk.jdField_d_of_type_Int);
      return;
    }
    if (localblkk.jdField_a_of_type_ArrayOfByte != null)
    {
      this.a.inJustDecodeBounds = true;
      BitmapFactory.decodeByteArray(localblkk.jdField_a_of_type_ArrayOfByte, 0, localblkk.jdField_a_of_type_ArrayOfByte.length, this.a);
      this.a.inJustDecodeBounds = false;
      this.a.inSampleSize = (this.a.outWidth / parambbvg.b().getMeasuredWidth());
      try
      {
        parambbmy = new BitmapDrawable(null, BitmapFactory.decodeByteArray(localblkk.jdField_a_of_type_ArrayOfByte, 0, localblkk.jdField_a_of_type_ArrayOfByte.length, this.a));
        if ((5 == localblkk.f) || (localblkk.jdField_a_of_type_Boolean))
        {
          localImageView.setBackgroundDrawable(parambbmy);
          return;
        }
      }
      catch (OutOfMemoryError parambbmy)
      {
        for (;;)
        {
          parambbmy = null;
        }
        localImageView.setImageDrawable(parambbmy);
        return;
      }
    }
    super.a(parambbmy, parambbvg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blkl
 * JD-Core Version:    0.7.0.1
 */