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

public class axfj
  implements View.OnTouchListener, axfs, Manager
{
  public static final float a;
  private static axfj jdField_a_of_type_Axfj;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private axfm jdField_a_of_type_Axfm;
  private axfn jdField_a_of_type_Axfn = new axfn(this, Looper.getMainLooper());
  private bdwy jdField_a_of_type_Bdwy;
  private bjwu jdField_a_of_type_Bjwu;
  private Downloader jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader = DownloaderFactory.getInstance(BaseApplicationImpl.getContext()).getCommonDownloader();
  private DiniFlyAnimationView jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
  private ParticleDropView jdField_a_of_type_ComTencentMobileqqQzonevipGiftParticleParticleDropView;
  private ParticleExplodeView jdField_a_of_type_ComTencentMobileqqQzonevipGiftParticleParticleExplodeView;
  private WeakReference<FrameLayout> jdField_a_of_type_JavaLangRefWeakReference;
  private HashMap<String, aonx> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private bjwu jdField_b_of_type_Bjwu;
  
  static
  {
    jdField_a_of_type_Float = bdkf.a() / 720.0F;
  }
  
  public static axfj a()
  {
    if (jdField_a_of_type_Axfj == null) {}
    try
    {
      if (jdField_a_of_type_Axfj == null) {
        jdField_a_of_type_Axfj = new axfj();
      }
      return jdField_a_of_type_Axfj;
    }
    finally {}
  }
  
  private bjwu a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("QzoneGiftManager", 1, "createAnimationDrawable mZipPath = null");
      return null;
    }
    bjwu localbjwu = new bjwu();
    String str = axfp.a(paramString);
    if (QLog.isDevelopLevel()) {
      QLog.i("QzoneGiftManager", 4, "createAnimationDrawable mZipPath = " + paramString + " resUrl = " + str);
    }
    localbjwu.a(str, paramInt);
    localbjwu.a(jdField_a_of_type_Float);
    localbjwu.a();
    return localbjwu;
  }
  
  private void a(int paramInt)
  {
    a(paramInt, 0);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Axfn == null) {
      return;
    }
    if (this.jdField_a_of_type_Axfn.hasMessages(paramInt1)) {
      this.jdField_a_of_type_Axfn.removeMessages(paramInt1);
    }
    this.jdField_a_of_type_Axfn.sendEmptyMessageDelayed(paramInt1, paramInt2);
  }
  
  private void a(aonw paramaonw, String paramString1, String paramString2)
  {
    Object localObject = new StringBuilder().append("loadVipARConfig bean == null ");
    boolean bool;
    if (paramaonw == null)
    {
      bool = true;
      QLog.i("VipAR", 1, bool + " giftName = " + paramString1);
      if (paramaonw != null) {
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
      if ((paramaonw.jdField_a_of_type_Int != 1) || (paramaonw.jdField_a_of_type_JavaUtilArrayList == null)) {
        break label146;
      }
      paramaonw = paramaonw.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramaonw.hasNext())
      {
        localObject = (aonx)paramaonw.next();
        if ((localObject != null) && (!TextUtils.isEmpty(paramString1)) && (paramString1.equalsIgnoreCase(((aonx)localObject).jdField_a_of_type_JavaLangString))) {
          this.jdField_a_of_type_JavaUtilHashMap.put(paramString2, localObject);
        }
      }
    }
    label146:
    this.jdField_a_of_type_JavaUtilHashMap.remove(paramString2);
    QLog.i("VipAR", 1, "checkARGift not AR gift switch = " + paramaonw.jdField_a_of_type_Int + " configlist == null " + paramaonw.jdField_a_of_type_JavaUtilArrayList);
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_Axfm != null) && (this.jdField_a_of_type_Axfm.jdField_a_of_type_Int == 1) && (!TextUtils.isEmpty(this.jdField_a_of_type_Axfm.d));
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Axfn == null) {}
    for (;;)
    {
      return;
      int i = 1;
      while (i < 9)
      {
        if (this.jdField_a_of_type_Axfn.hasMessages(i)) {
          this.jdField_a_of_type_Axfn.removeMessages(i);
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
    String str = QzoneZipCacheHelper.getBasePath("aio_lottie_gift", String.valueOf(this.jdField_a_of_type_Axfm.d.hashCode())) + ".zip";
    if (QLog.isColorLevel()) {
      QLog.i("QzoneGiftManager", 2, " preloadLottieZip local path = " + str + " zipUrl = " + this.jdField_a_of_type_Axfm.d);
    }
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.download(this.jdField_a_of_type_Axfm.d, str, new axfk(this));
  }
  
  private void f()
  {
    bdwy localbdwy = new bdwy(null, BaseApplicationImpl.getContext());
    localbdwy.a((int)(MemoryManager.a() / 2L));
    this.jdField_a_of_type_Bdwy = localbdwy;
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = new DiniFlyAnimationView(BaseApplicationImpl.getContext());
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.loop(false);
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.addAnimatorListener(new axfl(this));
  }
  
  private void h()
  {
    if (!a()) {
      return;
    }
    f();
    g();
    String str = QzoneZipCacheHelper.getBasePath("aio_lottie_gift", String.valueOf(this.jdField_a_of_type_Axfm.d.hashCode())) + ".zip";
    this.jdField_a_of_type_Bdwy.a(this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView, this.jdField_a_of_type_Axfm.d, str, true);
    a(1);
  }
  
  public aonx a(String paramString)
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
          paramString = (aonx)localEntry.getValue();
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
    if ((this.jdField_a_of_type_Axfm == null) || (TextUtils.isEmpty(this.jdField_a_of_type_Axfm.b)) || (TextUtils.isEmpty(this.jdField_a_of_type_Axfm.c)))
    {
      QLog.e("QzoneGiftManager", 1, "onSuccess show fail : data = null ");
      return;
    }
    this.jdField_a_of_type_Bjwu = a(this.jdField_a_of_type_Axfm.jdField_a_of_type_JavaLangString, 10);
    this.jdField_b_of_type_Bjwu = a(this.jdField_a_of_type_Axfm.b, 10);
    if (this.jdField_b_of_type_Bjwu != null)
    {
      this.jdField_b_of_type_Bjwu.b(true);
      this.jdField_b_of_type_Bjwu.a(false);
    }
    String str = axfp.a(this.jdField_a_of_type_Axfm.c, "qzone_aio_gift");
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
    this.jdField_a_of_type_Axfm = axfm.a(paramString);
    if (a())
    {
      e();
      return;
    }
    if (this.jdField_a_of_type_Axfm != null)
    {
      axfp.a(null, this.jdField_a_of_type_Axfm.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Axfm.b, this.jdField_a_of_type_Axfm.c);
      return;
    }
    QLog.e("QzoneGiftManager", 1, "preloadGiftData error with data = null");
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Axfm == null)
    {
      QLog.e("QzoneGiftManager", 1, "onFail show fail mGiftData = null");
      return;
    }
    QLog.e("QzoneGiftManager", 1, "onFail show fail mGiftData = " + this.jdField_a_of_type_Axfm.toString());
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QzoneGiftManager", 2, " startPlay data = " + paramString);
    }
    this.jdField_a_of_type_Axfm = axfm.a(paramString);
    if (a())
    {
      h();
      return;
    }
    if (this.jdField_a_of_type_Axfm != null)
    {
      axfp.a(this, this.jdField_a_of_type_Axfm.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Axfm.b, this.jdField_a_of_type_Axfm.c);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axfj
 * JD-Core Version:    0.7.0.1
 */