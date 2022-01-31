import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.gallery.model.GalleryBaseData;
import com.tencent.mobileqq.gallery.model.pic.AIOFilePicData;
import com.tencent.mobileqq.gallery.model.pic.AIOPicData;
import com.tencent.mobileqq.gallery.model.video.AIOFileVideoData;
import com.tencent.mobileqq.gallery.model.video.AIOShortVideoData;
import com.tencent.qphone.base.util.QLog;

public class aqmi
  extends aqmm
{
  public int a;
  public Rect a;
  public GalleryBaseData a;
  public boolean a;
  public int b;
  Rect b;
  public boolean b;
  public boolean c;
  
  public aqmi(GalleryBaseData paramGalleryBaseData)
  {
    this.jdField_a_of_type_Int = -2;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData = paramGalleryBaseData;
    this.d = true;
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public Rect a()
  {
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Boolean)) {
      return this.jdField_a_of_type_AndroidGraphicsRect;
    }
    return super.a();
  }
  
  public Drawable a()
  {
    for (;;)
    {
      try
      {
        Drawable localDrawable;
        if ((this.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData instanceof AIOPicData))
        {
          localDrawable = new aqmq().a((AIOPicData)this.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData);
          localObject2 = a();
          if ((localDrawable != null) && ((localDrawable.getIntrinsicHeight() * 3 < localDrawable.getIntrinsicWidth()) || (localDrawable.getIntrinsicWidth() * 3 < localDrawable.getIntrinsicHeight()))) {
            this.d = false;
          }
          if ((localDrawable != null) && (localObject2 != null))
          {
            this.jdField_b_of_type_Int = a((Rect)localObject2, localDrawable);
            if (localDrawable.getIntrinsicHeight() == -1) {
              break;
            }
            localObject2 = localDrawable;
            if (localDrawable.getIntrinsicWidth() != -1) {
              return localObject2;
            }
            break;
          }
        }
        else
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData instanceof AIOShortVideoData))
          {
            localDrawable = new aqmu().a((AIOShortVideoData)this.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData);
            continue;
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData instanceof AIOFilePicData))
          {
            localDrawable = new aqmp().a((AIOFilePicData)this.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData);
            continue;
          }
          if (!(this.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData instanceof AIOFileVideoData)) {
            break label219;
          }
          localDrawable = new aqmr().a((AIOFileVideoData)this.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData);
          continue;
        }
        return null;
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AIOImageInfo", 2, "getAnimationBitmap ", localThrowable);
        }
        return null;
      }
      label219:
      Object localObject1 = null;
    }
    Object localObject2 = null;
    return localObject2;
  }
  
  public int b()
  {
    return 0;
  }
  
  public Rect b()
  {
    return this.jdField_b_of_type_AndroidGraphicsRect;
  }
  
  public int c()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqmi
 * JD-Core Version:    0.7.0.1
 */