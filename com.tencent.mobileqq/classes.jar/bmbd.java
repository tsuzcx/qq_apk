import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.qphone.base.util.QLog;

public class bmbd
  extends bcjc
{
  private BitmapFactory.Options a = new BitmapFactory.Options();
  
  public bmbd(FaceDecoder paramFaceDecoder)
  {
    super(paramFaceDecoder);
  }
  
  public void a(bcfj parambcfj, bcnt parambcnt)
  {
    parambcnt.a().setMaxWidth(800);
    bmbc localbmbc = (bmbc)parambcfj;
    ImageView localImageView = parambcnt.b();
    localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    if ((5 == localbmbc.f) || (localbmbc.jdField_a_of_type_Boolean))
    {
      localImageView.setImageResource(2130844130);
      if (localbmbc.jdField_d_of_type_JavaLangString == null) {
        break label186;
      }
      parambcfj = URLDrawable.URLDrawableOptions.obtain();
      parambcfj.mRequestHeight = parambcnt.b().getHeight();
      parambcfj.mRequestWidth = parambcnt.b().getWidth();
      if ((5 != localbmbc.f) && (!localbmbc.jdField_a_of_type_Boolean)) {
        break label136;
      }
      localImageView.setBackgroundDrawable(URLDrawable.getDrawable(localbmbc.jdField_d_of_type_JavaLangString, parambcfj));
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
        localImageView.setImageDrawable(URLDrawable.getDrawable(localbmbc.jdField_d_of_type_JavaLangString, parambcfj));
        return;
      }
      catch (Exception parambcfj) {}
    } while (!QLog.isColorLevel());
    QLog.d("FavoriteSearchResultPresenter", 2, "bindFace exception = " + parambcfj.toString());
    return;
    label186:
    if (localbmbc.jdField_d_of_type_Int != 0)
    {
      if ((5 == localbmbc.f) || (localbmbc.jdField_a_of_type_Boolean))
      {
        localImageView.setBackgroundResource(localbmbc.jdField_d_of_type_Int);
        return;
      }
      localImageView.setImageResource(localbmbc.jdField_d_of_type_Int);
      return;
    }
    if (localbmbc.jdField_a_of_type_ArrayOfByte != null)
    {
      this.a.inJustDecodeBounds = true;
      BitmapFactory.decodeByteArray(localbmbc.jdField_a_of_type_ArrayOfByte, 0, localbmbc.jdField_a_of_type_ArrayOfByte.length, this.a);
      this.a.inJustDecodeBounds = false;
      this.a.inSampleSize = (this.a.outWidth / parambcnt.b().getMeasuredWidth());
      try
      {
        parambcfj = new BitmapDrawable(null, BitmapFactory.decodeByteArray(localbmbc.jdField_a_of_type_ArrayOfByte, 0, localbmbc.jdField_a_of_type_ArrayOfByte.length, this.a));
        if ((5 == localbmbc.f) || (localbmbc.jdField_a_of_type_Boolean))
        {
          localImageView.setBackgroundDrawable(parambcfj);
          return;
        }
      }
      catch (OutOfMemoryError parambcfj)
      {
        for (;;)
        {
          parambcfj = null;
        }
        localImageView.setImageDrawable(parambcfj);
        return;
      }
    }
    super.a(parambcfj, parambcnt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmbd
 * JD-Core Version:    0.7.0.1
 */