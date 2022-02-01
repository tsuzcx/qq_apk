import android.app.Activity;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.richmediabrowser.listener.IGalleryImageListener;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.view.recyclerview.BrowserScaleView;

class bajr
  implements IGalleryImageListener
{
  bajr(bajq parambajq, URLDrawable paramURLDrawable, RichMediaBrowserInfo paramRichMediaBrowserInfo) {}
  
  public void onLoadDrawable(int paramInt, URLDrawable paramURLDrawable) {}
  
  public void onLoadSuccessed(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Bajq.a.b.setVisibility(8);
    if (paramBoolean)
    {
      this.jdField_a_of_type_Bajq.a(paramInt, this.jdField_a_of_type_ComTencentImageURLDrawable);
      paramInt = this.jdField_a_of_type_ComTencentImageURLDrawable.getExifOrientation();
      this.jdField_a_of_type_ComTencentRichmediabrowserModelRichMediaBrowserInfo.orientation = paramInt;
      if (this.jdField_a_of_type_Bajq.a.a != null) {
        this.jdField_a_of_type_Bajq.a.a.initDrawable(this.jdField_a_of_type_ComTencentImageURLDrawable, this.jdField_a_of_type_Bajq.a.mScreenWidthPx, this.jdField_a_of_type_Bajq.a.mScreenHeightPx, this.jdField_a_of_type_Bajq.getRotation(paramInt));
      }
      return;
    }
    QQToast.a(this.jdField_a_of_type_Bajq.a.mContext, this.jdField_a_of_type_Bajq.a.mContext.getString(2131694569), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bajr
 * JD-Core Version:    0.7.0.1
 */