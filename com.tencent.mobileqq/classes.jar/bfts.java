import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import cooperation.qzone.contentbox.BaseMsgView;
import java.lang.ref.WeakReference;

public class bfts
  extends Handler
{
  private WeakReference<BaseMsgView> a;
  
  public bfts(BaseMsgView paramBaseMsgView)
  {
    this.a = new WeakReference(paramBaseMsgView);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    BaseMsgView localBaseMsgView = (BaseMsgView)this.a.get();
    if (localBaseMsgView == null) {}
    ViewPager localViewPager;
    do
    {
      return;
      switch (paramMessage.what)
      {
      default: 
        localBaseMsgView.a(paramMessage);
        return;
      }
      localViewPager = (ViewPager)((WeakReference)paramMessage.obj).get();
    } while (localViewPager == null);
    int i = paramMessage.arg1;
    localViewPager.setCurrentItem((localViewPager.getCurrentItem() + 1) % i, true);
    localBaseMsgView.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bfts
 * JD-Core Version:    0.7.0.1
 */