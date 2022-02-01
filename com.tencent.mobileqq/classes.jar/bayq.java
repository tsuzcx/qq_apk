import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.DownloaderFactory;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.MemoryManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.qzonevip.gift.QzoneGiftManager.3;
import com.tencent.mobileqq.qzonevip.gift.particle.ParticleDropView;
import com.tencent.mobileqq.qzonevip.gift.particle.ParticleExplodeView;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class bayq
  implements View.OnTouchListener, bayz, Manager
{
  public static final float a;
  private static bayq jdField_a_of_type_Bayq;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private bayu jdField_a_of_type_Bayu;
  private bayv jdField_a_of_type_Bayv = new bayv(this, Looper.getMainLooper());
  private biiy jdField_a_of_type_Biiy;
  private bnqp jdField_a_of_type_Bnqp;
  private Downloader jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader = DownloaderFactory.getInstance(BaseApplicationImpl.getContext()).getCommonDownloader();
  private DiniFlyAnimationView jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
  private ParticleDropView jdField_a_of_type_ComTencentMobileqqQzonevipGiftParticleParticleDropView;
  private ParticleExplodeView jdField_a_of_type_ComTencentMobileqqQzonevipGiftParticleParticleExplodeView;
  private WeakReference<FrameLayout> jdField_a_of_type_JavaLangRefWeakReference;
  private HashMap<String, arjx> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private bnqp jdField_b_of_type_Bnqp;
  private ImageView c;
  
  static
  {
    jdField_a_of_type_Float = bhtq.a() / 720.0F;
  }
  
  public static bayq a()
  {
    if (jdField_a_of_type_Bayq == null) {}
    try
    {
      if (jdField_a_of_type_Bayq == null) {
        jdField_a_of_type_Bayq = new bayq();
      }
      return jdField_a_of_type_Bayq;
    }
    finally {}
  }
  
  private bnqp a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("QzoneGiftManager", 1, "createAnimationDrawable mZipPath = null");
      return null;
    }
    bnqp localbnqp = new bnqp();
    String str = bayw.a(paramString);
    if (QLog.isDevelopLevel()) {
      QLog.i("QzoneGiftManager", 4, "createAnimationDrawable mZipPath = " + paramString + " resUrl = " + str);
    }
    localbnqp.a(str, paramInt);
    localbnqp.a(jdField_a_of_type_Float);
    localbnqp.a();
    return localbnqp;
  }
  
  private void a(int paramInt)
  {
    a(paramInt, 0);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Bayv == null) {
      return;
    }
    if (this.jdField_a_of_type_Bayv.hasMessages(paramInt1)) {
      this.jdField_a_of_type_Bayv.removeMessages(paramInt1);
    }
    this.jdField_a_of_type_Bayv.sendEmptyMessageDelayed(paramInt1, paramInt2);
  }
  
  private void a(arjw paramarjw, String paramString1, String paramString2)
  {
    Object localObject = new StringBuilder().append("loadVipARConfig bean == null ");
    boolean bool;
    if (paramarjw == null)
    {
      bool = true;
      QLog.i("VipAR", 1, bool + " giftName = " + paramString1);
      if (paramarjw != null) {
        break label65;
      }
      QLog.e("VipAR", 1, "checkARGift loadVipARConfig error VipARConfBean = null ");
    }
    for (;;)
    {
      return;
      bool = false;
      break;
      label65:
      if ((paramarjw.jdField_a_of_type_Int != 1) || (paramarjw.jdField_a_of_type_JavaUtilArrayList == null)) {
        break label146;
      }
      paramarjw = paramarjw.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramarjw.hasNext())
      {
        localObject = (arjx)paramarjw.next();
        if ((localObject != null) && (!TextUtils.isEmpty(paramString1)) && (paramString1.equalsIgnoreCase(((arjx)localObject).jdField_a_of_type_JavaLangString))) {
          this.jdField_a_of_type_JavaUtilHashMap.put(paramString2, localObject);
        }
      }
    }
    label146:
    this.jdField_a_of_type_JavaUtilHashMap.remove(paramString2);
    QLog.i("VipAR", 1, "checkARGift not AR gift switch = " + paramarjw.jdField_a_of_type_Int + " configlist == null " + paramarjw.jdField_a_of_type_JavaUtilArrayList);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Bayv == null) {}
    for (;;)
    {
      return;
      int i = 1;
      while (i < 9)
      {
        if (this.jdField_a_of_type_Bayv.hasMessages(i)) {
          this.jdField_a_of_type_Bayv.removeMessages(i);
        }
        i += 1;
      }
    }
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader == null) || (!a()))
    {
      QLog.e("QzoneGiftManager", 1, "preloadLottieZip error");
      return;
    }
    String str = QzoneZipCacheHelper.getBasePath("aio_lottie_gift", String.valueOf(this.jdField_a_of_type_Bayu.d.hashCode())) + ".zip";
    if (QLog.isColorLevel()) {
      QLog.i("QzoneGiftManager", 2, " preloadLottieZip local path = " + str + " zipUrl = " + this.jdField_a_of_type_Bayu.d);
    }
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.download(this.jdField_a_of_type_Bayu.d, str, new bayr(this));
  }
  
  private void f()
  {
    biiy localbiiy = new biiy(null, BaseApplicationImpl.getContext());
    localbiiy.a((int)(MemoryManager.a() / 2L));
    this.jdField_a_of_type_Biiy = localbiiy;
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = new DiniFlyAnimationView(BaseApplicationImpl.getContext());
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.loop(false);
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.addAnimatorListener(new bays(this));
  }
  
  private void h()
  {
    if (!a()) {
      return;
    }
    f();
    g();
    String str = QzoneZipCacheHelper.getBasePath("aio_lottie_gift", String.valueOf(this.jdField_a_of_type_Bayu.d.hashCode())) + ".zip";
    this.jdField_a_of_type_Biiy.a(this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView, this.jdField_a_of_type_Bayu.d, str, true);
    a(1);
  }
  
  private void i()
  {
    QLog.i("QzoneGiftManager", 1, "MSG_INIT_CONTENT_VIEW");
    FrameLayout localFrameLayout;
    if (BaseActivity.sTopActivity != null)
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference((FrameLayout)BaseActivity.sTopActivity.findViewById(16908290));
      localFrameLayout = (FrameLayout)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localFrameLayout == null) {
        QLog.e("QzoneGiftManager", 1, "mParentLayout = null");
      }
    }
    else
    {
      QLog.e("QzoneGiftManager", 1, "activity = null");
      return;
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(BaseApplicationImpl.getContext());
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setOnTouchListener(this);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    localFrameLayout.addView(this.jdField_a_of_type_AndroidWidgetFrameLayout, localLayoutParams);
    if (a())
    {
      this.jdField_a_of_type_Bayv.sendEmptyMessage(7);
      return;
    }
    a(2);
  }
  
  private void j()
  {
    QLog.i("QzoneGiftManager", 1, "MSG_INIT_VIEW");
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout == null)
    {
      QLog.e("QzoneGiftManager", 1, "mCotentLayout = null");
      return;
    }
    this.c = new ImageView(BaseApplicationImpl.getContext());
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.c);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(BaseApplicationImpl.getContext());
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_Bnqp);
    this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(BaseApplicationImpl.getContext());
    this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_b_of_type_Bnqp);
    this.jdField_b_of_type_AndroidWidgetImageView.setAlpha(0);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(bhtq.b(200.0F), bhtq.b(200.0F));
    localLayoutParams.gravity = 17;
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView, localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_b_of_type_AndroidWidgetImageView, localLayoutParams);
    this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftParticleParticleExplodeView = new ParticleExplodeView(BaseApplicationImpl.getContext());
    this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftParticleParticleDropView = new ParticleDropView(BaseApplicationImpl.getContext());
    this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftParticleParticleDropView.setBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
    localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftParticleParticleExplodeView, localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftParticleParticleDropView, localLayoutParams);
    a(3);
  }
  
  private void k()
  {
    QLog.i("QzoneGiftManager", 1, "MSG_BOX_ANIMATION_START");
    if (this.jdField_a_of_type_Bnqp != null)
    {
      this.jdField_a_of_type_Bnqp.start();
      a(5, this.jdField_a_of_type_Bnqp.a() - 330);
      a(4, this.jdField_a_of_type_Bnqp.a() - 300);
    }
    if (this.jdField_a_of_type_Bnqp == null) {
      a(4, 0);
    }
  }
  
  private void l()
  {
    QLog.i("QzoneGiftManager", 1, "MSG_GIFT_ANIMATION_START");
    n();
    if (this.jdField_b_of_type_Bnqp != null) {
      this.jdField_b_of_type_Bnqp.start();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftParticleParticleDropView != null) {
      this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftParticleParticleDropView.b();
    }
    AnimatorSet localAnimatorSet = new AnimatorSet();
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidWidgetImageView, "scaleX", new float[] { 0.0F, 1.0F });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidWidgetImageView, "scaleY", new float[] { 0.0F, 1.0F });
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidWidgetImageView, "alpha", new float[] { 0.0F, 1.0F });
    localObjectAnimator3.setInterpolator(new DecelerateInterpolator());
    localAnimatorSet.setDuration(400L);
    localAnimatorSet.play(localObjectAnimator1).with(localObjectAnimator2).with(localObjectAnimator3);
    localAnimatorSet.start();
    if (this.jdField_b_of_type_Bnqp != null) {
      a(6, this.jdField_b_of_type_Bnqp.a() + 2000);
    }
  }
  
  private void m()
  {
    QLog.i("QzoneGiftManager", 1, "MSG_GIFT_PARTICLE_EXPLODE");
    if (this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftParticleParticleExplodeView != null) {
      this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftParticleParticleExplodeView.b();
    }
  }
  
  private void n()
  {
    QLog.i("QzoneGiftManager", 1, "MSG_SHADER_SHOW");
    if (this.c != null)
    {
      this.c.setBackgroundColor(Color.parseColor("#000000"));
      this.c.setAlpha(0);
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.c, "alpha", new float[] { 0.0F, 0.5F });
      localObjectAnimator.setDuration(300L);
      localObjectAnimator.start();
    }
  }
  
  private void o()
  {
    QLog.i("QzoneGiftManager", 1, "MSG_GIFT_ANIMATION_STOP");
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetFrameLayout, "alpha", new float[] { 1.0F, 0.0F });
    localObjectAnimator.setDuration(500L);
    localObjectAnimator.addListener(new bayt(this));
    localObjectAnimator.start();
  }
  
  private void p()
  {
    QLog.i("QzoneGiftManager", 1, "MSG_GIFT_LOTTIE_ANIMATION_SHOW");
    if ((this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView == null) || (this.jdField_a_of_type_AndroidWidgetFrameLayout == null)) {
      return;
    }
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView, localLayoutParams);
  }
  
  private void q()
  {
    QLog.i("QzoneGiftManager", 1, "MSG_RECYCLE_VIEW");
    if (this.jdField_a_of_type_Bnqp != null) {
      this.jdField_a_of_type_Bnqp.b();
    }
    if (this.jdField_b_of_type_Bnqp != null) {
      this.jdField_b_of_type_Bnqp.b();
    }
    if (this.jdField_a_of_type_Biiy != null) {
      this.jdField_a_of_type_Biiy.c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView != null) {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.removeAllAnimatorListener();
    }
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    FrameLayout localFrameLayout;
    do
    {
      return;
      localFrameLayout = (FrameLayout)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while ((localFrameLayout == null) || (this.jdField_a_of_type_AndroidWidgetFrameLayout == null));
    localFrameLayout.removeView(this.jdField_a_of_type_AndroidWidgetFrameLayout);
  }
  
  public arjx a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString).optString("giftZipUrl");
      if (QLog.isColorLevel()) {
        QLog.i("VipAR", 2, "isNeedARShow gift key = " + paramString + " map = " + this.jdField_a_of_type_JavaUtilHashMap.toString());
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if ((localEntry != null) && (!TextUtils.isEmpty((CharSequence)localEntry.getKey())) && (paramString.contains((CharSequence)localEntry.getKey())))
        {
          paramString = (arjx)localEntry.getValue();
          return paramString;
        }
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Bayu == null) || (TextUtils.isEmpty(this.jdField_a_of_type_Bayu.b)) || (TextUtils.isEmpty(this.jdField_a_of_type_Bayu.c)))
    {
      QLog.e("QzoneGiftManager", 1, "onSuccess show fail : data = null ");
      return;
    }
    this.jdField_a_of_type_Bnqp = a(this.jdField_a_of_type_Bayu.jdField_a_of_type_JavaLangString, 10);
    this.jdField_b_of_type_Bnqp = a(this.jdField_a_of_type_Bayu.b, 10);
    if (this.jdField_b_of_type_Bnqp != null)
    {
      this.jdField_b_of_type_Bnqp.b(true);
      this.jdField_b_of_type_Bnqp.a(false);
    }
    String str = bayw.a(this.jdField_a_of_type_Bayu.c, "qzone_aio_gift");
    if (!TextUtils.isEmpty(str))
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("QzoneGiftManager", 4, "show Gift giftLocalPath = " + str);
      }
      this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeFile(str);
    }
    a(1);
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QzoneGiftManager", 2, " preload data = " + paramString);
    }
    this.jdField_a_of_type_Bayu = bayu.a(paramString);
    if (a())
    {
      e();
      return;
    }
    if (this.jdField_a_of_type_Bayu != null)
    {
      bayw.a(null, this.jdField_a_of_type_Bayu.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Bayu.b, this.jdField_a_of_type_Bayu.c);
      return;
    }
    QLog.e("QzoneGiftManager", 1, "preloadGiftData error with data = null");
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Bayu != null) && (this.jdField_a_of_type_Bayu.jdField_a_of_type_Int == 1) && (!TextUtils.isEmpty(this.jdField_a_of_type_Bayu.d));
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Bayu == null)
    {
      QLog.e("QzoneGiftManager", 1, "onFail show fail mGiftData = null");
      return;
    }
    QLog.e("QzoneGiftManager", 1, "onFail show fail mGiftData = " + this.jdField_a_of_type_Bayu.toString());
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QzoneGiftManager", 2, " startPlay data = " + paramString);
    }
    this.jdField_a_of_type_Bayu = bayu.a(paramString);
    if (a())
    {
      h();
      return;
    }
    if (this.jdField_a_of_type_Bayu != null)
    {
      bayw.a(this, this.jdField_a_of_type_Bayu.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Bayu.b, this.jdField_a_of_type_Bayu.c);
      return;
    }
    QLog.e("QzoneGiftManager", 1, "preloadGiftData error with data = null");
  }
  
  public void c()
  {
    QLog.i("QzoneGiftManager", 1, "onLoading");
  }
  
  public void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      try
      {
        Object localObject = new JSONObject(paramString).optJSONObject("giftData");
        if (localObject != null)
        {
          paramString = ((JSONObject)localObject).optString("giftName");
          localObject = ((JSONObject)localObject).optString("giftZipUrl");
          ThreadManager.getFileThreadHandler().post(new QzoneGiftManager.3(this, paramString, (String)localObject));
          QLog.i("VipARGiftManager", 1, "checkIsNeedARGiftShow key gift = " + (String)localObject);
          return;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        QLog.e("VipARGiftManager", 1, "checkIsNeedARGiftShow exception msg = " + paramString.getMessage());
      }
    }
  }
  
  public void onDestroy()
  {
    d();
    a(8);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      d();
      a(8);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bayq
 * JD-Core Version:    0.7.0.1
 */