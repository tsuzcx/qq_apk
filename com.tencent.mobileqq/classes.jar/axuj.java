import android.app.Activity;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.richmediabrowser.listener.IGalleryImageListener;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.BasePresenter;

class axuj
  implements IGalleryImageListener
{
  axuj(axui paramaxui, URLDrawable paramURLDrawable, RichMediaBrowserInfo paramRichMediaBrowserInfo) {}
  
  public void onLoadDrawable(int paramInt, URLDrawable paramURLDrawable) {}
  
  public void onLoadSuccessed(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Axui.a.b.setVisibility(8);
    if (paramBoolean)
    {
      this.jdField_a_of_type_Axui.a(this.jdField_a_of_type_ComTencentImageURLDrawable);
      paramInt = this.jdField_a_of_type_ComTencentImageURLDrawable.getExifOrientation();
      this.jdField_a_of_type_ComTencentRichmediabrowserModelRichMediaBrowserInfo.orientation = paramInt;
      BasePresenter.updateRotation(this.jdField_a_of_type_Axui.a.galleryView, this.jdField_a_of_type_ComTencentImageURLDrawable, paramInt);
      return;
    }
    QQToast.a(this.jdField_a_of_type_Axui.a.mContext, this.jdField_a_of_type_Axui.a.mContext.getString(2131695499), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axuj
 * JD-Core Version:    0.7.0.1
 */