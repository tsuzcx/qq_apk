import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.DownloaderFactory;
import com.tencent.component.network.downloader.Downloader;
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

public class auoe
  implements View.OnTouchListener, auon, Manager
{
  public static final float a;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private auoh jdField_a_of_type_Auoh;
  private auoi jdField_a_of_type_Auoi = new auoi(this, Looper.getMainLooper());
  private baup jdField_a_of_type_Baup;
  private bgmb jdField_a_of_type_Bgmb;
  private Downloader jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader = DownloaderFactory.getInstance(BaseApplicationImpl.getContext()).getCommonDownloader();
  private DiniFlyAnimationView jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
  private ParticleDropView jdField_a_of_type_ComTencentMobileqqQzonevipGiftParticleParticleDropView;
  private ParticleExplodeView jdField_a_of_type_ComTencentMobileqqQzonevipGiftParticleParticleExplodeView;
  private WeakReference<FrameLayout> jdField_a_of_type_JavaLangRefWeakReference;
  private HashMap<String, amgn> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private bgmb jdField_b_of_type_Bgmb;
  
  static
  {
    jdField_a_of_type_Float = bajq.a() / 720.0F;
  }
  
  private bgmb a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("QzoneGiftManager", 1, "createAnimationDrawable mZipPath = null");
      return null;
    }
    bgmb localbgmb = new bgmb();
    String str = auok.a(paramString);
    if (QLog.isDevelopLevel()) {
      QLog.i("QzoneGiftManager", 4, "createAnimationDrawable mZipPath = " + paramString + " resUrl = " + str);
    }
    localbgmb.a(str, paramInt);
    localbgmb.a(jdField_a_of_type_Float);
    localbgmb.a();
    return localbgmb;
  }
  
  private void a(int paramInt)
  {
    a(paramInt, 0);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Auoi == null) {
      return;
    }
    if (this.jdField_a_of_type_Auoi.hasMessages(paramInt1)) {
      this.jdField_a_of_type_Auoi.removeMessages(paramInt1);
    }
    this.jdField_a_of_type_Auoi.sendEmptyMessageDelayed(paramInt1, paramInt2);
  }
  
  private void a(amgm paramamgm, String paramString1, String paramString2)
  {
    Object localObject = new StringBuilder().append("loadVipARConfig bean == null ");
    boolean bool;
    if (paramamgm == null)
    {
      bool = true;
      QLog.i("VipAR", 1, bool + " giftName = " + paramString1);
      if (paramamgm != null) {
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
      if ((paramamgm.jdField_a_of_type_Int != 1) || (paramamgm.jdField_a_of_type_JavaUtilArrayList == null)) {
        break label146;
      }
      paramamgm = paramamgm.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramamgm.hasNext())
      {
        localObject = (amgn)paramamgm.next();
        if ((localObject != null) && (!TextUtils.isEmpty(paramString1)) && (paramString1.equalsIgnoreCase(((amgn)localObject).jdField_a_of_type_JavaLangString))) {
          this.jdField_a_of_type_JavaUtilHashMap.put(paramString2, localObject);
        }
      }
    }
    label146:
    this.jdField_a_of_type_JavaUtilHashMap.remove(paramString2);
    QLog.i("VipAR", 1, "checkARGift not AR gift switch = " + paramamgm.jdField_a_of_type_Int + " configlist == null " + paramamgm.jdField_a_of_type_JavaUtilArrayList);
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_Auoh != null) && (this.jdField_a_of_type_Auoh.jdField_a_of_type_Int == 1) && (!TextUtils.isEmpty(this.jdField_a_of_type_Auoh.d));
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Auoi == null) {}
    for (;;)
    {
      return;
      int i = 1;
      while (i < 9)
      {
        if (this.jdField_a_of_type_Auoi.hasMessages(i)) {
          this.jdField_a_of_type_Auoi.removeMessages(i);
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
    String str = QzoneZipCacheHelper.getBasePath("aio_lottie_gift", String.valueOf(this.jdField_a_of_type_Auoh.d.hashCode())) + ".zip";
    if (QLog.isColorLevel()) {
      QLog.i("QzoneGiftManager", 2, " preloadLottieZip local path = " + str + " zipUrl = " + this.jdField_a_of_type_Auoh.d);
    }
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.download(this.jdField_a_of_type_Auoh.d, str, new auof(this));
  }
  
  private void f()
  {
    baup localbaup = new baup(null, BaseApplicationImpl.getContext());
    localbaup.a((int)(MemoryManager.a() / 2L));
    this.jdField_a_of_type_Baup = localbaup;
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = new DiniFlyAnimationView(BaseApplicationImpl.getContext());
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.loop(false);
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.addAnimatorListener(new auog(this));
  }
  
  private void h()
  {
    if (!a()) {
      return;
    }
    f();
    g();
    String str = QzoneZipCacheHelper.getBasePath("aio_lottie_gift", String.valueOf(this.jdField_a_of_type_Auoh.d.hashCode())) + ".zip";
    this.jdField_a_of_type_Baup.a(this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView, this.jdField_a_of_type_Auoh.d, str, true);
    a(1);
  }
  
  public amgn a(String paramString)
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
          paramString = (amgn)localEntry.getValue();
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
    if ((this.jdField_a_of_type_Auoh == null) || (TextUtils.isEmpty(this.jdField_a_of_type_Auoh.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(this.jdField_a_of_type_Auoh.b)) || (TextUtils.isEmpty(this.jdField_a_of_type_Auoh.c)))
    {
      QLog.e("QzoneGiftManager", 1, "onSuccess show fail : data = null ");
      return;
    }
    this.jdField_a_of_type_Bgmb = a(this.jdField_a_of_type_Auoh.jdField_a_of_type_JavaLangString, 10);
    this.jdField_b_of_type_Bgmb = a(this.jdField_a_of_type_Auoh.b, 10);
    if (this.jdField_b_of_type_Bgmb != null)
    {
      this.jdField_b_of_type_Bgmb.b(true);
      this.jdField_b_of_type_Bgmb.a(false);
    }
    String str = auok.a(this.jdField_a_of_type_Auoh.c, "qzone_aio_gift");
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
    this.jdField_a_of_type_Auoh = auoh.a(paramString);
    if (a())
    {
      e();
      return;
    }
    if (this.jdField_a_of_type_Auoh != null)
    {
      auok.a(null, this.jdField_a_of_type_Auoh.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Auoh.b, this.jdField_a_of_type_Auoh.c);
      return;
    }
    QLog.e("QzoneGiftManager", 1, "preloadGiftData error with data = null");
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Auoh == null)
    {
      QLog.e("QzoneGiftManager", 1, "onFail show fail mGiftData = null");
      return;
    }
    QLog.e("QzoneGiftManager", 1, "onFail show fail mGiftData = " + this.jdField_a_of_type_Auoh.toString());
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QzoneGiftManager", 2, " startPlay data = " + paramString);
    }
    this.jdField_a_of_type_Auoh = auoh.a(paramString);
    if (a())
    {
      h();
      return;
    }
    if (this.jdField_a_of_type_Auoh != null)
    {
      auok.a(this, this.jdField_a_of_type_Auoh.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Auoh.b, this.jdField_a_of_type_Auoh.c);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     auoe
 * JD-Core Version:    0.7.0.1
 */