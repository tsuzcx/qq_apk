import android.graphics.Bitmap;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.wxapi.WXShareHelper;

final class asml
  implements URLDrawable.URLDrawableListener
{
  asml(String paramString1, asmo paramasmo, String paramString2, String paramString3, String paramString4, QQAppInterface paramQQAppInterface) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    paramURLDrawable = azvq.b(BaseApplicationImpl.getApplication().getResources(), 2130844397);
    WXShareHelper.a().a(new asmn(this));
    WXShareHelper.a().a(this.jdField_a_of_type_JavaLangString, this.b, paramURLDrawable, this.c, this.d);
    new asmr().h("video").i("playpage_fw_suc").a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    Bitmap localBitmap = asmd.a(paramURLDrawable);
    paramURLDrawable = localBitmap;
    if (localBitmap == null) {
      paramURLDrawable = azvq.b(BaseApplicationImpl.getApplication().getResources(), 2130844397);
    }
    WXShareHelper.a().a(new asmm(this));
    WXShareHelper.a().a(this.jdField_a_of_type_JavaLangString, this.b, paramURLDrawable, this.c, this.d);
    new asmr().h("video").i("playpage_fw_suc").a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     asml
 * JD-Core Version:    0.7.0.1
 */