import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.widget.ImageView;
import cooperation.qzone.contentbox.MsgPhotoView.WeakVipResourcesListener.1;
import cooperation.vip.vipcomponent.util.VipResourcesListener;
import java.lang.ref.WeakReference;

public class bjip
  implements VipResourcesListener
{
  private int jdField_a_of_type_Int;
  private WeakReference<Handler> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private WeakReference<ImageView> b;
  
  public bjip(Handler paramHandler, ImageView paramImageView, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramHandler);
    this.b = new WeakReference(paramImageView);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void onFailed() {}
  
  public void onLoaded(Drawable paramDrawable)
  {
    Handler localHandler = (Handler)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((paramDrawable != null) && (localHandler != null)) {
      localHandler.post(new MsgPhotoView.WeakVipResourcesListener.1(this, paramDrawable));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjip
 * JD-Core Version:    0.7.0.1
 */