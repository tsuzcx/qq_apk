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

public class bkpv
  extends bbck
{
  private BitmapFactory.Options a = new BitmapFactory.Options();
  
  public bkpv(FaceDecoder paramFaceDecoder)
  {
    super(paramFaceDecoder);
  }
  
  public void a(bayt parambayt, bbhb parambbhb)
  {
    parambbhb.a().setMaxWidth(800);
    bkpu localbkpu = (bkpu)parambayt;
    ImageView localImageView = parambbhb.b();
    localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    if ((5 == localbkpu.f) || (localbkpu.jdField_a_of_type_Boolean))
    {
      localImageView.setImageResource(2130844068);
      if (localbkpu.jdField_d_of_type_JavaLangString == null) {
        break label186;
      }
      parambayt = URLDrawable.URLDrawableOptions.obtain();
      parambayt.mRequestHeight = parambbhb.b().getHeight();
      parambayt.mRequestWidth = parambbhb.b().getWidth();
      if ((5 != localbkpu.f) && (!localbkpu.jdField_a_of_type_Boolean)) {
        break label136;
      }
      localImageView.setBackgroundDrawable(URLDrawable.getDrawable(localbkpu.jdField_d_of_type_JavaLangString, parambayt));
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
        localImageView.setImageDrawable(URLDrawable.getDrawable(localbkpu.jdField_d_of_type_JavaLangString, parambayt));
        return;
      }
      catch (Exception parambayt) {}
    } while (!QLog.isColorLevel());
    QLog.d("FavoriteSearchResultPresenter", 2, "bindFace exception = " + parambayt.toString());
    return;
    label186:
    if (localbkpu.jdField_d_of_type_Int != 0)
    {
      if ((5 == localbkpu.f) || (localbkpu.jdField_a_of_type_Boolean))
      {
        localImageView.setBackgroundResource(localbkpu.jdField_d_of_type_Int);
        return;
      }
      localImageView.setImageResource(localbkpu.jdField_d_of_type_Int);
      return;
    }
    if (localbkpu.jdField_a_of_type_ArrayOfByte != null)
    {
      this.a.inJustDecodeBounds = true;
      BitmapFactory.decodeByteArray(localbkpu.jdField_a_of_type_ArrayOfByte, 0, localbkpu.jdField_a_of_type_ArrayOfByte.length, this.a);
      this.a.inJustDecodeBounds = false;
      this.a.inSampleSize = (this.a.outWidth / parambbhb.b().getMeasuredWidth());
      try
      {
        parambayt = new BitmapDrawable(null, BitmapFactory.decodeByteArray(localbkpu.jdField_a_of_type_ArrayOfByte, 0, localbkpu.jdField_a_of_type_ArrayOfByte.length, this.a));
        if ((5 == localbkpu.f) || (localbkpu.jdField_a_of_type_Boolean))
        {
          localImageView.setBackgroundDrawable(parambayt);
          return;
        }
      }
      catch (OutOfMemoryError parambayt)
      {
        for (;;)
        {
          parambayt = null;
        }
        localImageView.setImageDrawable(parambayt);
        return;
      }
    }
    super.a(parambayt, parambbhb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkpv
 * JD-Core Version:    0.7.0.1
 */