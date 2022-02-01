import android.graphics.Bitmap;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.wxapi.WXShareHelper;

final class awrl
  implements URLDrawable.URLDrawableListener
{
  awrl(String paramString1, awro paramawro, String paramString2, String paramString3, String paramString4, QQAppInterface paramQQAppInterface) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    paramURLDrawable = bfpx.b(BaseApplicationImpl.getApplication().getResources(), 2130845205);
    WXShareHelper.getInstance().addObserver(new awrn(this));
    WXShareHelper.getInstance().shareTroopToWXFriendCircle(this.jdField_a_of_type_JavaLangString, this.b, paramURLDrawable, this.c, this.d);
    new awrs().h("video").i("playpage_fw_suc").a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    Bitmap localBitmap = awrc.a(paramURLDrawable);
    paramURLDrawable = localBitmap;
    if (localBitmap == null) {
      paramURLDrawable = bfpx.b(BaseApplicationImpl.getApplication().getResources(), 2130845205);
    }
    WXShareHelper.getInstance().addObserver(new awrm(this));
    WXShareHelper.getInstance().shareTroopToWXFriendCircle(this.jdField_a_of_type_JavaLangString, this.b, paramURLDrawable, this.c, this.d);
    new awrs().h("video").i("playpage_fw_suc").a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awrl
 * JD-Core Version:    0.7.0.1
 */