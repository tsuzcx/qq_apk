import android.app.Activity;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.richmediabrowser.listener.IGalleryImageListener;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.view.recyclerview.BrowserScaleView;

class bbqg
  implements IGalleryImageListener
{
  bbqg(bbqf parambbqf, URLDrawable paramURLDrawable, RichMediaBrowserInfo paramRichMediaBrowserInfo) {}
  
  public void onLoadDrawable(int paramInt, URLDrawable paramURLDrawable) {}
  
  public void onLoadSuccessed(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Bbqf.a.b.setVisibility(8);
    if (paramBoolean)
    {
      this.jdField_a_of_type_Bbqf.a(paramInt, this.jdField_a_of_type_ComTencentImageURLDrawable);
      paramInt = this.jdField_a_of_type_ComTencentImageURLDrawable.getExifOrientation();
      this.jdField_a_of_type_ComTencentRichmediabrowserModelRichMediaBrowserInfo.orientation = paramInt;
      if (this.jdField_a_of_type_Bbqf.a.a != null) {
        this.jdField_a_of_type_Bbqf.a.a.initDrawable(this.jdField_a_of_type_ComTencentImageURLDrawable, this.jdField_a_of_type_Bbqf.a.mScreenWidthPx, this.jdField_a_of_type_Bbqf.a.mScreenHeightPx, this.jdField_a_of_type_Bbqf.getRotation(paramInt));
      }
      return;
    }
    QQToast.a(this.jdField_a_of_type_Bbqf.a.mContext, this.jdField_a_of_type_Bbqf.a.mContext.getString(2131694770), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbqg
 * JD-Core Version:    0.7.0.1
 */