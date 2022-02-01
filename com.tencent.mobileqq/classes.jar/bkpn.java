import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy.IDrawableLoadedCallBack;

class bkpn
  implements URLDrawable.URLDrawableListener
{
  bkpn(bkpb parambkpb, MiniAppProxy.IDrawableLoadedCallBack paramIDrawableLoadedCallBack) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyMiniAppProxy$IDrawableLoadedCallBack.onLoadSuccessed(paramURLDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkpn
 * JD-Core Version:    0.7.0.1
 */