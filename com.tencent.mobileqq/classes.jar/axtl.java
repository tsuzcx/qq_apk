import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.richmediabrowser.model.AIOFilePictureData;
import com.tencent.mobileqq.richmediabrowser.model.AIOFileVideoData;
import com.tencent.mobileqq.richmediabrowser.model.AIOPictureData;
import com.tencent.mobileqq.richmediabrowser.model.AIOVideoData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmediabrowser.listener.IBrowserAnimationListener;
import com.tencent.richmediabrowser.model.BrowserAnimation;
import com.tencent.richmediabrowser.model.RichMediaBaseData;

public class axtl
  extends BrowserAnimation
  implements IBrowserAnimationListener
{
  public int a;
  public Rect a;
  private RichMediaBaseData a;
  Rect b;
  
  public axtl() {}
  
  public axtl(RichMediaBaseData paramRichMediaBaseData)
  {
    this.jdField_a_of_type_ComTencentRichmediabrowserModelRichMediaBaseData = paramRichMediaBaseData;
  }
  
  public Drawable getAnimationDrawable()
  {
    for (;;)
    {
      try
      {
        Drawable localDrawable;
        if ((this.jdField_a_of_type_ComTencentRichmediabrowserModelRichMediaBaseData instanceof AIOPictureData))
        {
          localDrawable = new axue().a((AIOPictureData)this.jdField_a_of_type_ComTencentRichmediabrowserModelRichMediaBaseData);
          localObject2 = getThumbRect();
          if ((localDrawable != null) && ((localDrawable.getIntrinsicHeight() * 3 < localDrawable.getIntrinsicWidth()) || (localDrawable.getIntrinsicWidth() * 3 < localDrawable.getIntrinsicHeight()))) {
            this.isImgCenterCropMode = false;
          }
          if ((localDrawable != null) && (localObject2 != null))
          {
            this.jdField_a_of_type_Int = getCutValue((Rect)localObject2, localDrawable);
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
          if ((this.jdField_a_of_type_ComTencentRichmediabrowserModelRichMediaBaseData instanceof AIOVideoData))
          {
            localDrawable = new axuf().a((AIOVideoData)this.jdField_a_of_type_ComTencentRichmediabrowserModelRichMediaBaseData);
            continue;
          }
          if ((this.jdField_a_of_type_ComTencentRichmediabrowserModelRichMediaBaseData instanceof AIOFilePictureData))
          {
            localDrawable = new axua().a((AIOFilePictureData)this.jdField_a_of_type_ComTencentRichmediabrowserModelRichMediaBaseData);
            continue;
          }
          if (!(this.jdField_a_of_type_ComTencentRichmediabrowserModelRichMediaBaseData instanceof AIOFileVideoData)) {
            break label219;
          }
          localDrawable = new axub().a((AIOFileVideoData)this.jdField_a_of_type_ComTencentRichmediabrowserModelRichMediaBaseData);
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
  
  public BrowserAnimation getBrowserAnimation(RichMediaBaseData paramRichMediaBaseData)
  {
    paramRichMediaBaseData = new axtl(paramRichMediaBaseData);
    paramRichMediaBaseData.jdField_a_of_type_AndroidGraphicsRect = this.jdField_a_of_type_AndroidGraphicsRect;
    return paramRichMediaBaseData;
  }
  
  public int getCutValue()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public Rect getStartSrcRect()
  {
    return this.b;
  }
  
  public int getStartX()
  {
    return 0;
  }
  
  public int getStartY()
  {
    return 0;
  }
  
  public Rect getThumbRect()
  {
    if (this.jdField_a_of_type_AndroidGraphicsRect != null) {
      return this.jdField_a_of_type_AndroidGraphicsRect;
    }
    return super.getThumbRect();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axtl
 * JD-Core Version:    0.7.0.1
 */