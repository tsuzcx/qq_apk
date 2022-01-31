import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.image.VideoDrawable;
import com.tencent.image.VideoDrawable.VideoDrawableParams;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.picbrowser.GalleryItemVideo.1;
import com.tencent.mobileqq.nearby.picbrowser.GalleryItemVideo.2;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;

public class avjc
  extends avjm
  implements antz
{
  int jdField_a_of_type_Int;
  Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  antx jdField_a_of_type_Antx;
  anug jdField_a_of_type_Anug;
  WeakReference<URLImageView> jdField_a_of_type_JavaLangRefWeakReference;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 0;
  WeakReference<avjo> jdField_b_of_type_JavaLangRefWeakReference;
  int d = 0;
  
  public avjc(Context paramContext, PicInfo paramPicInfo)
  {
    super(paramContext, paramPicInfo);
    paramContext = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if ((paramContext instanceof QQAppInterface)) {
      this.jdField_a_of_type_Anug = ((anug)paramContext.getManager(180));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Anug == null) {}
      this.jdField_a_of_type_Antx = this.jdField_a_of_type_Anug.a();
      this.jdField_a_of_type_Antx.a(this);
      return;
      if ((paramContext instanceof NearbyAppInterface)) {
        this.jdField_a_of_type_Anug = ((anug)paramContext.getManager(180));
      }
    }
  }
  
  @NonNull
  private URLDrawable.URLDrawableOptions a(Drawable paramDrawable)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = paramDrawable;
    localURLDrawableOptions.mUseMemoryCache = false;
    localURLDrawableOptions.mMemoryCacheKeySuffix = "GalleryItemVideo";
    paramDrawable = new VideoDrawable.VideoDrawableParams();
    paramDrawable.mPlayVideoFrame = true;
    paramDrawable.mPlayAudioFrame = true;
    paramDrawable.mEnableAntiAlias = true;
    paramDrawable.mEnableFilter = true;
    localURLDrawableOptions.mUseMemoryCache = false;
    localURLDrawableOptions.mExtraInfo = paramDrawable;
    return localURLDrawableOptions;
  }
  
  private URLDrawable a(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty(paramString))
    {
      String str = paramString.replaceFirst("http", "nearbyimage");
      localObject1 = localObject2;
      if (baqn.b(str))
      {
        paramString = URLDrawable.getDrawable(str, null);
        localObject1 = paramString;
        if (QLog.isColorLevel())
        {
          QLog.i("GalleryItemVideo", 2, "PicBrowserGalleryAdapter getView loadingDrawble is: " + str);
          localObject1 = paramString;
        }
      }
    }
    return localObject1;
  }
  
  public View a(int paramInt, Handler paramHandler, avjo paramavjo)
  {
    this.jdField_a_of_type_Int = paramInt;
    URLImageView localURLImageView = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo == null) {
      return localURLImageView;
    }
    if (QLog.isColorLevel()) {
      QLog.i("GalleryItemVideo", 2, "getView pos:" + paramInt);
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(localURLImageView);
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramavjo);
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = bayu.a;
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = bayu.a;
    paramHandler = a(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.a);
    int i;
    label148:
    label186:
    boolean bool2;
    if (paramHandler != null)
    {
      i = 1;
      if (i == 0)
      {
        paramHandler = a(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.b);
        if (paramHandler == null) {
          break label454;
        }
        i = 1;
        if (i == 0)
        {
          if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.b)) {
            break label460;
          }
          paramHandler = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.b.replaceFirst("http", "nearbyimage"), (URLDrawable.URLDrawableOptions)localObject);
        }
      }
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.e)) {
        break label520;
      }
      localObject = new File(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.e);
      bool2 = ((File)localObject).exists();
      bool1 = bool2;
      if (bool2) {
        localURLImageView.setImageDrawable(URLDrawable.getDrawable((File)localObject, a(paramHandler)));
      }
    }
    label520:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.d))
        {
          bool1 = antx.b(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.d);
          bool2 = bool1;
          if (bool1)
          {
            localURLImageView.setImageDrawable(URLDrawable.getDrawable(antx.a(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.d), a(paramHandler)));
            bool2 = bool1;
          }
        }
      }
      if (!bool2) {
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.d))
        {
          this.d = 0;
          localURLImageView.setImageDrawable(paramHandler);
          paramHandler = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
          if (this.jdField_a_of_type_Antx.a(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.d)) {
            this.jdField_b_of_type_Int = 0;
          }
          paramavjo.a(paramInt, this.jdField_b_of_type_Int);
          label396:
          if (QLog.isColorLevel()) {
            QLog.i("GalleryItemVideo", 2, "fileNotExsits progress:" + this.jdField_b_of_type_Int + " url:" + this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.d);
          }
        }
      }
      for (;;)
      {
        return localURLImageView;
        i = 0;
        break;
        label454:
        i = 0;
        break label148;
        label460:
        paramHandler = bayu.a;
        break label186;
        localURLImageView.setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(2130837968));
        this.d = 2;
        paramavjo.a(paramInt, false);
        break label396;
        this.jdField_b_of_type_Int = 0;
        this.d = 1;
        paramavjo.a(paramInt, true);
      }
    }
  }
  
  public void a()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.d))
    {
      if (QLog.isColorLevel()) {
        QLog.i("GalleryItemVideo", 2, "preload:" + this.jdField_a_of_type_Int);
      }
      if (!antx.b(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.d)) {
        this.jdField_a_of_type_Antx.a(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.d);
      }
    }
  }
  
  public void a(View paramView, int paramInt, avjo paramavjo)
  {
    boolean bool2 = true;
    paramView = (URLImageView)paramView;
    Drawable localDrawable = paramView.getDrawable();
    if ((localDrawable == null) || (!(localDrawable instanceof URLDrawable))) {
      return;
    }
    if ((this.d != 1) && (this.d != 2) && (this.d != 3) && (this.d != 4))
    {
      if (QLog.isColorLevel()) {
        QLog.i("GalleryItemVideo", 2, "updateProgressOnSelected:" + this.jdField_b_of_type_Int);
      }
      if (this.jdField_b_of_type_Int > 0) {
        paramavjo.b(paramInt, this.jdField_b_of_type_Int / 100);
      }
      paramView.setMinimumHeight(10);
      paramView.setMinimumWidth(10);
      return;
    }
    boolean bool1 = bool2;
    if (this.d != 1) {
      if (this.d != 4) {
        break label165;
      }
    }
    label165:
    for (bool1 = bool2;; bool1 = false)
    {
      paramavjo.a(paramInt, bool1);
      break;
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.d))
    {
      this.jdField_b_of_type_Int = paramInt;
      if ((this.jdField_b_of_type_JavaLangRefWeakReference != null) && (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null)) {
        ((avjo)this.jdField_b_of_type_JavaLangRefWeakReference.get()).b(this.jdField_a_of_type_Int, paramInt);
      }
    }
  }
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 0;
    if (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.d)) {
      if (!paramBoolean1) {
        break label90;
      }
    }
    label90:
    for (int i = 1;; i = 2)
    {
      this.d = i;
      if (QLog.isColorLevel()) {
        QLog.i("GalleryItemVideo", 2, "onDownloadFinish pos:" + this.jdField_a_of_type_Int + " suc:" + paramBoolean1);
      }
      if ((this.jdField_b_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference != null)) {
        break;
      }
      return;
    }
    Object localObject = (avjo)this.jdField_b_of_type_JavaLangRefWeakReference.get();
    paramString = (URLImageView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject != null)
    {
      ((avjo)localObject).a(this.jdField_a_of_type_Int, paramBoolean1);
      ((avjo)localObject).a(this.jdField_a_of_type_Int);
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onDownloadFinish onloadli=null:");
      if (localObject != null) {
        break label302;
      }
    }
    label302:
    for (paramBoolean2 = true;; paramBoolean2 = false)
    {
      QLog.i("GalleryItemVideo", 2, paramBoolean2);
      if (paramString == null) {
        break;
      }
      i = j;
      if (paramBoolean1)
      {
        i = j;
        if (antx.b(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.d))
        {
          localObject = URLDrawable.getDrawable(antx.a(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.d), a(paramString.getDrawable()));
          this.jdField_a_of_type_AndroidOsHandler.post(new GalleryItemVideo.1(this, paramString, (URLDrawable)localObject));
          i = 1;
        }
      }
      if (i != 0) {
        break;
      }
      localObject = BaseApplicationImpl.getApplication().getResources().getDrawable(2130837968);
      this.jdField_a_of_type_AndroidOsHandler.post(new GalleryItemVideo.2(this, paramString, (Drawable)localObject));
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      b();
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("GalleryItemVideo", 2, "pause audio:" + this.jdField_a_of_type_Int);
    }
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      Object localObject = (URLImageView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localObject != null)
      {
        localObject = ((URLImageView)localObject).getDrawable();
        if ((localObject != null) && ((localObject instanceof URLDrawable)))
        {
          localObject = (URLDrawable)localObject;
          if ((((URLDrawable)localObject).getCurrDrawable() instanceof VideoDrawable)) {
            ((VideoDrawable)((URLDrawable)localObject).getCurrDrawable()).stopAudio();
          }
        }
      }
    }
  }
  
  public Drawable c()
  {
    Object localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo == null) {
      localObject2 = null;
    }
    for (;;)
    {
      return localObject2;
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mFailedDrawable = bayu.a;
      localURLDrawableOptions.mLoadingDrawable = bayu.a;
      localObject2 = a(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.a);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = a(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.b);
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      try
      {
        localObject1 = new URL(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.b);
        localObject1 = URLDrawable.getDrawable(new URL("nearbyimage", ((URL)localObject1).getAuthority(), ((URL)localObject1).getFile()), localURLDrawableOptions);
        localObject2 = b();
        if ((localObject1 != null) && (localObject2 != null))
        {
          this.e = a((Rect)localObject2, (Drawable)localObject1);
          localObject2 = localObject1;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("GalleryItemVideo", 2, "getAnimationDrawable ,cutValue = " + this.e);
          return localObject1;
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        for (;;)
        {
          localObject1 = localObject2;
          if (QLog.isDevelopLevel())
          {
            localMalformedURLException.printStackTrace();
            localObject1 = localObject2;
          }
        }
      }
    }
    return null;
  }
  
  public void c()
  {
    this.jdField_a_of_type_Boolean = true;
    b();
    super.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avjc
 * JD-Core Version:    0.7.0.1
 */