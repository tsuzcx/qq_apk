import android.app.Activity;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.richmediabrowser.listener.IGalleryImageListener;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.view.recyclerview.BrowserScaleView;

class baxd
  implements IGalleryImageListener
{
  baxd(baxc parambaxc, URLDrawable paramURLDrawable, RichMediaBrowserInfo paramRichMediaBrowserInfo) {}
  
  public void onLoadDrawable(int paramInt, URLDrawable paramURLDrawable) {}
  
  public void onLoadSuccessed(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Baxc.a.b.setVisibility(8);
    if (paramBoolean)
    {
      this.jdField_a_of_type_Baxc.a(paramInt, this.jdField_a_of_type_ComTencentImageURLDrawable);
      paramInt = this.jdField_a_of_type_ComTencentImageURLDrawable.getExifOrientation();
      this.jdField_a_of_type_ComTencentRichmediabrowserModelRichMediaBrowserInfo.orientation = paramInt;
      if (this.jdField_a_of_type_Baxc.a.a != null) {
        this.jdField_a_of_type_Baxc.a.a.initDrawable(this.jdField_a_of_type_ComTencentImageURLDrawable, this.jdField_a_of_type_Baxc.a.mScreenWidthPx, this.jdField_a_of_type_Baxc.a.mScreenHeightPx, this.jdField_a_of_type_Baxc.getRotation(paramInt));
      }
      return;
    }
    QQToast.a(this.jdField_a_of_type_Baxc.a.mContext, this.jdField_a_of_type_Baxc.a.mContext.getString(2131694413), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baxd
 * JD-Core Version:    0.7.0.1
 */