import android.graphics.Bitmap;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.wxapi.WXShareHelper;

final class axxn
  implements URLDrawable.URLDrawableListener
{
  axxn(String paramString1, axxq paramaxxq, String paramString2, String paramString3, String paramString4, QQAppInterface paramQQAppInterface) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    paramURLDrawable = bgyo.b(BaseApplicationImpl.getApplication().getResources(), 2130845279);
    WXShareHelper.a().a(new axxp(this));
    WXShareHelper.a().a(this.jdField_a_of_type_JavaLangString, this.b, paramURLDrawable, this.c, this.d);
    new axxu().h("video").i("playpage_fw_suc").a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    Bitmap localBitmap = axxe.a(paramURLDrawable);
    paramURLDrawable = localBitmap;
    if (localBitmap == null) {
      paramURLDrawable = bgyo.b(BaseApplicationImpl.getApplication().getResources(), 2130845279);
    }
    WXShareHelper.a().a(new axxo(this));
    WXShareHelper.a().a(this.jdField_a_of_type_JavaLangString, this.b, paramURLDrawable, this.c, this.d);
    new axxu().h("video").i("playpage_fw_suc").a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axxn
 * JD-Core Version:    0.7.0.1
 */