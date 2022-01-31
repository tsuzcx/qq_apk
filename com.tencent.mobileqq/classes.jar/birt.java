import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;

public class birt
  extends aynd
{
  private BitmapFactory.Options a = new BitmapFactory.Options();
  
  public birt(bcws parambcws)
  {
    super(parambcws);
  }
  
  public void a(ayjl paramayjl, ayru paramayru)
  {
    paramayru.a().setMaxWidth(800);
    birs localbirs = (birs)paramayjl;
    ImageView localImageView = paramayru.b();
    localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    if ((5 == localbirs.f) || (localbirs.jdField_a_of_type_Boolean))
    {
      localImageView.setImageResource(2130843723);
      if (localbirs.jdField_d_of_type_JavaLangString == null) {
        break label186;
      }
      paramayjl = URLDrawable.URLDrawableOptions.obtain();
      paramayjl.mRequestHeight = paramayru.b().getHeight();
      paramayjl.mRequestWidth = paramayru.b().getWidth();
      if ((5 != localbirs.f) && (!localbirs.jdField_a_of_type_Boolean)) {
        break label136;
      }
      localImageView.setBackgroundDrawable(URLDrawable.getDrawable(localbirs.jdField_d_of_type_JavaLangString, paramayjl));
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
        localImageView.setImageDrawable(URLDrawable.getDrawable(localbirs.jdField_d_of_type_JavaLangString, paramayjl));
        return;
      }
      catch (Exception paramayjl) {}
    } while (!QLog.isColorLevel());
    QLog.d("FavoriteSearchResultPresenter", 2, "bindFace exception = " + paramayjl.toString());
    return;
    label186:
    if (localbirs.jdField_d_of_type_Int != 0)
    {
      if ((5 == localbirs.f) || (localbirs.jdField_a_of_type_Boolean))
      {
        localImageView.setBackgroundResource(localbirs.jdField_d_of_type_Int);
        return;
      }
      localImageView.setImageResource(localbirs.jdField_d_of_type_Int);
      return;
    }
    if (localbirs.jdField_a_of_type_ArrayOfByte != null)
    {
      this.a.inJustDecodeBounds = true;
      BitmapFactory.decodeByteArray(localbirs.jdField_a_of_type_ArrayOfByte, 0, localbirs.jdField_a_of_type_ArrayOfByte.length, this.a);
      this.a.inJustDecodeBounds = false;
      this.a.inSampleSize = (this.a.outWidth / paramayru.b().getMeasuredWidth());
      try
      {
        paramayjl = new BitmapDrawable(null, BitmapFactory.decodeByteArray(localbirs.jdField_a_of_type_ArrayOfByte, 0, localbirs.jdField_a_of_type_ArrayOfByte.length, this.a));
        if ((5 == localbirs.f) || (localbirs.jdField_a_of_type_Boolean))
        {
          localImageView.setBackgroundDrawable(paramayjl);
          return;
        }
      }
      catch (OutOfMemoryError paramayjl)
      {
        for (;;)
        {
          paramayjl = null;
        }
        localImageView.setImageDrawable(paramayjl);
        return;
      }
    }
    super.a(paramayjl, paramayru);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     birt
 * JD-Core Version:    0.7.0.1
 */