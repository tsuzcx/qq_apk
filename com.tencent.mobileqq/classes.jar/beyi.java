import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenManager;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenParams;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenParams.FloatingBuilder;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenPermission;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoOuterStatusListener;
import com.tencent.mobileqq.widget.qqfloatingscreen.videoview.TVKVideoController.2;
import com.tencent.mobileqq.widget.qqfloatingscreen.videoview.TVKVideoController.4;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

public class beyi
  implements aghw
{
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  private aiob jdField_a_of_type_Aiob;
  private aiqo jdField_a_of_type_Aiqo;
  private View jdField_a_of_type_AndroidViewView;
  auca jdField_a_of_type_Auca = new beyk(this);
  private beyl jdField_a_of_type_Beyl;
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private IVideoOuterStatusListener jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIVideoOuterStatusListener;
  public final Runnable a;
  private WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int c;
  
  public beyi(Context paramContext)
  {
    this.jdField_a_of_type_JavaLangRunnable = new TVKVideoController.4(this);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_a_of_type_Beyl = new beyl(this, null);
    this.jdField_a_of_type_Aiob = new aiob();
  }
  
  private void a(int paramInt)
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Aiob != null))
    {
      this.jdField_a_of_type_Aiob.a(paramInt);
      this.jdField_a_of_type_Beyl.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 100L);
    }
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    int i = 401;
    if (paramInt1 == 101) {
      i = 403;
    }
    int j = i;
    if (paramInt1 == 122) {
      if (paramInt2 != 204)
      {
        j = i;
        if (paramInt2 != 202) {}
      }
      else
      {
        j = 402;
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIVideoOuterStatusListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIVideoOuterStatusListener.onVideoError(j);
    }
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_Aiob != null) && (this.jdField_a_of_type_Aiqo != null))
    {
      if (this.jdField_a_of_type_Aiqo.jdField_a_of_type_Boolean) {
        break label50;
      }
      if (this.jdField_a_of_type_Aiqo.jdField_a_of_type_JavaLangString != null) {
        this.jdField_a_of_type_Aiob.a(this.jdField_a_of_type_Aiqo.jdField_a_of_type_JavaLangString, 0L);
      }
    }
    return;
    label50:
    String str1;
    if (this.jdField_a_of_type_Aiqo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null)
    {
      str1 = "0";
      if (this.jdField_a_of_type_Aiqo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null) {
        break label128;
      }
    }
    label128:
    for (String str2 = "";; str2 = this.jdField_a_of_type_Aiqo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.md5)
    {
      this.jdField_a_of_type_Aiob.a(this.jdField_a_of_type_Aiqo.a(), str1, this.jdField_a_of_type_Aiqo.jdField_a_of_type_ArrayOfJavaLangString, 0L, str2, (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
      return;
      str1 = String.valueOf(this.jdField_a_of_type_Aiqo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileTime);
      break;
    }
  }
  
  private void d()
  {
    int i = aubw.a().a(1, this.jdField_a_of_type_Auca);
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Aiob != null) && (i == 0))
    {
      this.jdField_a_of_type_Aiob.c();
      this.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_Beyl.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 100L);
    }
  }
  
  private void e()
  {
    aubw.a().a(this.jdField_a_of_type_Auca);
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Aiob != null) && (!this.jdField_b_of_type_Boolean))
    {
      this.jdField_a_of_type_Aiob.b();
      this.jdField_a_of_type_Int = 4;
      this.jdField_a_of_type_Beyl.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  private void f()
  {
    aubw.a().a(this.jdField_a_of_type_Auca);
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      ((AudioManager)((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getSystemService("audio")).abandonAudioFocus(null);
    }
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_Aiqo == null) {
      if (QLog.isColorLevel()) {
        QLog.d("TVKVideoController", 2, "clickPlay mCurInfo is null");
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("TVKVideoController", 2, new Object[] { "clickPlay curState:", Integer.valueOf(this.jdField_a_of_type_Int), " ,isCompleted:", Boolean.valueOf(this.jdField_b_of_type_Boolean), " ,path:", this.jdField_a_of_type_Aiqo.jdField_a_of_type_JavaLangString });
      }
      if (this.jdField_a_of_type_Int == 0)
      {
        if (this.jdField_b_of_type_Boolean)
        {
          c();
          this.jdField_b_of_type_Boolean = false;
        }
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        return;
      }
      if (this.jdField_a_of_type_Int == 2)
      {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        return;
      }
      if (this.jdField_a_of_type_Int == 3)
      {
        this.jdField_b_of_type_Boolean = false;
        d();
        return;
      }
    } while (this.jdField_a_of_type_Int != 4);
    d();
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIVideoOuterStatusListener = FloatingScreenManager.getInstance().setFloatingVideoListener(new beyj(this));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt2 < 0)) {
      break label8;
    }
    label8:
    label112:
    for (;;)
    {
      return;
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Aiob != null))
      {
        if (paramInt1 > paramInt2) {}
        for (float f = paramInt2 / paramInt1;; f = paramInt1 / paramInt2)
        {
          if ((f <= 0.5D) || (f >= 0.6D) || (!(this.jdField_a_of_type_AndroidViewView instanceof IVideoViewBase))) {
            break label112;
          }
          ((IVideoViewBase)this.jdField_a_of_type_AndroidViewView).setXYaxis(2);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("TVKVideoController", 2, new Object[] { "handleFullScreen ratio:", Float.valueOf(f) });
          return;
        }
      }
    }
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_Long == paramLong)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TVKVideoController", 2, new Object[] { "onRecokeMsg:", Long.valueOf(paramLong) });
      }
      ThreadManager.getUIHandler().post(new TVKVideoController.2(this));
    }
  }
  
  public void a(aiqo paramaiqo, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TVKVideoController", 2, new Object[] { "initTVKVideoController with mediaInfo :", paramaiqo.jdField_a_of_type_JavaLangString });
    }
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_a_of_type_Aiqo = paramaiqo;
    this.jdField_a_of_type_Aiqo.e = paramLong2;
    if (this.jdField_a_of_type_Aiob != null)
    {
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_Aiob.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_Beyl, this.jdField_a_of_type_Aiqo, null);
      if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidViewView != null))
      {
        this.jdField_a_of_type_Aiob.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), (IVideoViewBase)this.jdField_a_of_type_AndroidViewView);
        this.jdField_a_of_type_Boolean = true;
      }
    }
    aghu.a().a(this);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    this.jdField_b_of_type_Int = paramInt1;
    this.c = paramInt2;
    Object localObject;
    if (bdhb.b(paramString))
    {
      paramString = ShortVideoUtils.a(paramString);
      if (paramString != null)
      {
        paramString = paramString.toString();
        if (!TextUtils.isEmpty(paramString)) {
          localObject = new apkp(Color.rgb(214, 214, 214), paramInt1, paramInt2);
        }
      }
    }
    try
    {
      localObject = URLDrawable.getDrawable(paramString, (Drawable)localObject, (Drawable)localObject);
      if (((URLDrawable)localObject).getStatus() != 1) {
        ((URLDrawable)localObject).downloadImediatly();
      }
      if ((localObject instanceof URLDrawable)) {
        this.jdField_a_of_type_ComTencentImageURLDrawable = ((URLDrawable)localObject);
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("TVKVideoController", 2, "initCover():  getDrawable Exception, coverUrl=" + paramString, localException);
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TVKVideoController", 2, new Object[] { "initTVKVideoController with path:", paramString });
    }
    long l = 0L;
    File localFile = new File(paramString);
    if (localFile.exists()) {
      l = localFile.length();
    }
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_a_of_type_Aiqo = new aiqo();
    this.jdField_a_of_type_Aiqo.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Aiqo.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Aiqo.b = l;
    this.jdField_a_of_type_Aiqo.d = l;
    this.jdField_a_of_type_Aiqo.e = paramLong2;
    if (this.jdField_a_of_type_Aiob != null)
    {
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_Aiob.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_Beyl, this.jdField_a_of_type_Aiqo, null);
      if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidViewView != null))
      {
        this.jdField_a_of_type_Aiob.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), (IVideoViewBase)this.jdField_a_of_type_AndroidViewView);
        this.jdField_a_of_type_Boolean = true;
      }
    }
    aghu.a().a(this);
  }
  
  public boolean a(boolean paramBoolean, int paramInt)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TVKVideoController", 2, "enterFloat failed! mediaplay not init");
      }
      return false;
    }
    FloatingScreenParams localFloatingScreenParams = new FloatingScreenParams.FloatingBuilder().setIsHorizontal(paramBoolean).setCanMove(true).build();
    if (FloatingScreenManager.getInstance().enterFloatingScreen(BaseApplicationImpl.getContext(), this.jdField_a_of_type_AndroidViewView, localFloatingScreenParams, bext.a(paramInt)) == 1)
    {
      FloatingScreenPermission.enterPermissionRequestDialog((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
      return false;
    }
    a();
    this.jdField_b_of_type_Boolean = false;
    g();
    return true;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TVKVideoController", 2, "destory!");
    }
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      ((AudioManager)((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getSystemService("audio")).abandonAudioFocus(null);
    }
    this.jdField_a_of_type_Aiqo = null;
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_ComTencentImageURLDrawable = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    if (this.jdField_a_of_type_Aiob != null)
    {
      this.jdField_a_of_type_Aiob.a();
      this.jdField_a_of_type_Aiob = null;
    }
    if (this.jdField_a_of_type_Beyl != null)
    {
      this.jdField_a_of_type_Beyl.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_Beyl = null;
    }
    aubw.a().a(this.jdField_a_of_type_Auca);
    aghu.a().b(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beyi
 * JD-Core Version:    0.7.0.1
 */