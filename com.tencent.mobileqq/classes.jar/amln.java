import android.os.Handler;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.apollo.ApolloBrickPlayer.BrickCMSPlayerListener.1;
import com.tencent.mobileqq.apollo.player.CMSActionStatus;
import com.tencent.mobileqq.apollo.player.action.CMSAction;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class amln
  implements amvk
{
  private int jdField_a_of_type_Int;
  private WeakReference<ImageView> jdField_a_of_type_JavaLangRefWeakReference;
  private WeakReference<ImageView> b;
  private WeakReference<RelativeLayout> c;
  private WeakReference<Handler> d;
  private WeakReference<Map<String, URLDrawable.URLDrawableOptions>> e;
  
  public amln(int paramInt, ImageView paramImageView1, ImageView paramImageView2, RelativeLayout paramRelativeLayout, Handler paramHandler, Map<String, URLDrawable.URLDrawableOptions> paramMap)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramImageView1);
    this.b = new WeakReference(paramImageView2);
    this.c = new WeakReference(paramRelativeLayout);
    this.d = new WeakReference(paramHandler);
    this.e = new WeakReference(paramMap);
  }
  
  public void a(@NotNull CMSAction paramCMSAction) {}
  
  public void a(@NotNull CMSAction paramCMSAction, @NotNull CMSActionStatus paramCMSActionStatus) {}
  
  public void a(@NotNull CMSAction paramCMSAction, boolean paramBoolean, @NotNull String paramString1, @Nullable String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.w("ApolloBrickPlayer", 2, "onRecordDone " + paramBoolean + " mActionId " + this.jdField_a_of_type_Int + " " + paramString2);
    }
    int i = paramCMSAction.c();
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        amlm.a().put(paramCMSAction.a(null, null), paramString2);
        if ((this.e == null) || (this.e.get() == null)) {
          continue;
        }
        paramCMSAction = (Map)this.e.get();
        paramCMSAction = amlm.a(paramString2, paramCMSAction);
      }
      catch (Exception paramCMSAction)
      {
        paramCMSAction.printStackTrace();
        paramCMSAction = null;
        continue;
        paramString1 = null;
        continue;
        paramString1.post(new ApolloBrickPlayer.BrickCMSPlayerListener.1(this, i, paramCMSAction));
      }
      if ((this.d == null) || (this.d.get() == null)) {
        continue;
      }
      paramString1 = (Handler)this.d.get();
      if (paramString1 != null) {
        continue;
      }
      return;
      paramCMSAction = null;
      continue;
      paramCMSAction = URLDrawableHelper.getFailedDrawable();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amln
 * JD-Core Version:    0.7.0.1
 */