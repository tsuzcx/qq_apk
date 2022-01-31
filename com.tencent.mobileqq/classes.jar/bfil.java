import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;

public class bfil
  extends avsf
{
  private BitmapFactory.Options a = new BitmapFactory.Options();
  
  public bfil(azwg paramazwg)
  {
    super(paramazwg);
  }
  
  public void a(avon paramavon, avww paramavww)
  {
    paramavww.a().setMaxWidth(800);
    bfik localbfik = (bfik)paramavon;
    ImageView localImageView = paramavww.b();
    localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    if ((5 == localbfik.f) || (localbfik.jdField_a_of_type_Boolean))
    {
      localImageView.setImageResource(2130843288);
      if (localbfik.jdField_d_of_type_JavaLangString == null) {
        break label186;
      }
      paramavon = URLDrawable.URLDrawableOptions.obtain();
      paramavon.mRequestHeight = paramavww.b().getHeight();
      paramavon.mRequestWidth = paramavww.b().getWidth();
      if ((5 != localbfik.f) && (!localbfik.jdField_a_of_type_Boolean)) {
        break label136;
      }
      localImageView.setBackgroundDrawable(URLDrawable.getDrawable(localbfik.jdField_d_of_type_JavaLangString, paramavon));
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
        localImageView.setImageDrawable(URLDrawable.getDrawable(localbfik.jdField_d_of_type_JavaLangString, paramavon));
        return;
      }
      catch (Exception paramavon) {}
    } while (!QLog.isColorLevel());
    QLog.d("FavoriteSearchResultPresenter", 2, "bindFace exception = " + paramavon.toString());
    return;
    label186:
    if (localbfik.jdField_d_of_type_Int != 0)
    {
      if ((5 == localbfik.f) || (localbfik.jdField_a_of_type_Boolean))
      {
        localImageView.setBackgroundResource(localbfik.jdField_d_of_type_Int);
        return;
      }
      localImageView.setImageResource(localbfik.jdField_d_of_type_Int);
      return;
    }
    if (localbfik.jdField_a_of_type_ArrayOfByte != null)
    {
      this.a.inJustDecodeBounds = true;
      BitmapFactory.decodeByteArray(localbfik.jdField_a_of_type_ArrayOfByte, 0, localbfik.jdField_a_of_type_ArrayOfByte.length, this.a);
      this.a.inJustDecodeBounds = false;
      this.a.inSampleSize = (this.a.outWidth / paramavww.b().getMeasuredWidth());
      try
      {
        paramavon = new BitmapDrawable(null, BitmapFactory.decodeByteArray(localbfik.jdField_a_of_type_ArrayOfByte, 0, localbfik.jdField_a_of_type_ArrayOfByte.length, this.a));
        if ((5 == localbfik.f) || (localbfik.jdField_a_of_type_Boolean))
        {
          localImageView.setBackgroundDrawable(paramavon);
          return;
        }
      }
      catch (OutOfMemoryError paramavon)
      {
        for (;;)
        {
          paramavon = null;
        }
        localImageView.setImageDrawable(paramavon);
        return;
      }
    }
    super.a(paramavon, paramavww);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bfil
 * JD-Core Version:    0.7.0.1
 */