import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.picbrowser.PicBrowserImage.1;
import com.tencent.mobileqq.nearby.picbrowser.PicBrowserImage.3;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class atob
  extends xpy
{
  protected Context a;
  public PicInfo a;
  int e;
  
  public atob(Context paramContext, PicInfo paramPicInfo)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo = paramPicInfo;
  }
  
  public int a()
  {
    return this.e;
  }
  
  public View a(int paramInt, Handler paramHandler, atod paramatod)
  {
    File localFile = null;
    URL localURL = null;
    URLDrawable localURLDrawable = null;
    boolean bool2 = true;
    URLImageView localURLImageView = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo == null) {
      return localURLImageView;
    }
    Object localObject1;
    Object localObject3;
    label258:
    long l;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.c))
    {
      localObject1 = URLDrawable.getDrawable(new File(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.c), null);
      localObject3 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject1);
      ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Drawable)localObject1);
      ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels;
      ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().heightPixels;
      ((URLDrawable.URLDrawableOptions)localObject3).mPlayGifImage = true;
      ((URLDrawable.URLDrawableOptions)localObject3).mExtraInfo = this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.c)) {
        localObject1 = localURLDrawable;
      }
    }
    else
    {
      try
      {
        localFile = new File(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.c);
        localObject1 = localURLDrawable;
        localURL = localFile.toURL();
        localObject1 = localURLDrawable;
        localURLDrawable = URLDrawable.getDrawable(new URL("nearbylocalimage", localURL.getAuthority(), localURL.getFile()), (URLDrawable.URLDrawableOptions)localObject3);
        localObject1 = localURLDrawable;
        localURLImageView.setImageDrawable(localURLDrawable);
        localObject1 = localURLDrawable;
        if (!localFile.exists()) {
          break label441;
        }
        localObject1 = localURLDrawable;
        bool1 = localFile.isFile();
        if (!bool1) {
          break label441;
        }
        bool1 = true;
        localObject1 = localURLDrawable;
      }
      catch (MalformedURLException localMalformedURLException1)
      {
        for (;;)
        {
          label315:
          if (QLog.isDevelopLevel()) {
            localMalformedURLException1.printStackTrace();
          }
          bool1 = false;
        }
      }
      if ((localObject1 == null) || (((URLDrawable)localObject1).getStatus() == 1) || (((URLDrawable)localObject1).getStatus() == 2) || (((URLDrawable)localObject1).getStatus() == 4)) {
        break label627;
      }
      localURLImageView.setURLDrawableDownListener(new atoc(this, paramatod, paramInt));
      if (!bool1) {
        break label619;
      }
      l = 1000L;
      paramHandler.postDelayed(new PicBrowserImage.3(this, (URLDrawable)localObject1, paramatod, paramInt), l);
    }
    for (;;)
    {
      label441:
      Object localObject2;
      for (;;)
      {
        return localURLImageView;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.b))
        {
          String str = this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.b.replaceFirst("http", "nearbyimage");
          if (ayog.b(str))
          {
            localObject3 = URLDrawable.getDrawable(str, null);
            localObject1 = localObject3;
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.i("PicBrowser", 2, "PicBrowserGalleryAdapter getView loadingDrawble is: " + str);
            localObject1 = localObject3;
            break;
          }
          localObject1 = aywk.a;
          break;
        }
        localObject1 = aywk.a;
        break;
        bool1 = false;
        localObject1 = localURLDrawable;
        break label258;
        localObject2 = localURL;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.a))
        {
          localObject1 = localFile;
          try
          {
            localObject2 = aysr.a(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.a);
            localObject1 = localFile;
            this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.a = ((URL)localObject2).toString();
            localObject1 = localFile;
            localObject2 = URLDrawable.getDrawable((URL)localObject2, (URLDrawable.URLDrawableOptions)localObject3);
            localObject1 = localObject2;
            ((URLDrawable)localObject2).setDownloadListener(new asyw(this.jdField_a_of_type_AndroidContentContext, "actNearbyPicBrowser"));
            localObject1 = localObject2;
            localURLImageView.setImageDrawable((Drawable)localObject2);
            localObject1 = localObject2;
            bool1 = ayog.b(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.a);
            localObject1 = localObject2;
          }
          catch (MalformedURLException localMalformedURLException2)
          {
            localObject2 = localObject1;
            if (QLog.isDevelopLevel())
            {
              localMalformedURLException2.printStackTrace();
              localObject2 = localObject1;
            }
          }
        }
      }
      bool1 = false;
      localObject1 = localObject2;
      break label258;
      label619:
      l = 300L;
      break label315;
      label627:
      if (localObject1 != null) {
        break label643;
      }
      paramatod.a(paramInt, false);
    }
    label643:
    if (((URLDrawable)localObject1).getStatus() == 1) {}
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramatod.a(paramInt, bool1);
      break;
    }
  }
  
  public void a()
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo != null) {
      localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.a;
    }
    try
    {
      localObject = aysr.a((String)localObject);
      if (localObject != null)
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mExtraInfo = this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo;
        localObject = URLDrawable.getDrawable((URL)localObject, localURLDrawableOptions);
        ((URLDrawable)localObject).setDownloadListener(new asyw(this.jdField_a_of_type_AndroidContentContext));
        ThreadManager.postImmediately(new PicBrowserImage.1(this, (URLDrawable)localObject), null, true);
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public void a(View paramView, int paramInt, atod paramatod)
  {
    paramView = (URLImageView)paramView;
    URLDrawable localURLDrawable = (URLDrawable)paramView.getDrawable();
    if (localURLDrawable == null) {
      return;
    }
    if ((localURLDrawable.getStatus() != 1) && (localURLDrawable.getStatus() != 2))
    {
      int i = localURLDrawable.getProgress();
      if (i > 0) {
        paramatod.b(paramInt, i / 100);
      }
      paramView.setMinimumHeight(10);
      paramView.setMinimumWidth(10);
      return;
    }
    if (localURLDrawable.getStatus() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      paramatod.a(paramInt, bool);
      break;
    }
  }
  
  public void a(boolean paramBoolean) {}
  
  public Drawable c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo == null) {
      return null;
    }
    Object localObject1 = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = aywk.a;
    ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = aywk.a;
    ((URLDrawable.URLDrawableOptions)localObject1).mPlayGifImage = true;
    ((URLDrawable.URLDrawableOptions)localObject1).mExtraInfo = this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.c)) {}
    for (;;)
    {
      Object localObject4;
      Object localObject2;
      try
      {
        localObject1 = URLDrawable.getDrawable(new File(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.c).toURL(), (URLDrawable.URLDrawableOptions)localObject1);
        localObject4 = b();
        if ((localObject1 == null) || (localObject4 == null)) {
          break;
        }
        this.e = a((Rect)localObject4, (Drawable)localObject1);
        if (QLog.isColorLevel()) {
          QLog.d("PicBrowser", 2, "getAnimationDrawable ,cutValue = " + this.e);
        }
        return localObject1;
      }
      catch (MalformedURLException localMalformedURLException1)
      {
        if (QLog.isDevelopLevel()) {
          localMalformedURLException1.printStackTrace();
        }
        localObject2 = null;
        continue;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.b)) {
        try
        {
          localObject4 = new URL(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.b);
          localObject4 = new URL("nearbyimage", ((URL)localObject4).getAuthority(), ((URL)localObject4).getFile());
          if (ayog.b(((URL)localObject4).toString()))
          {
            localObject2 = URLDrawable.getDrawable((URL)localObject4, (URLDrawable.URLDrawableOptions)localObject2);
            continue;
          }
          localObject4 = new URL(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.a);
          localObject2 = URLDrawable.getDrawable(new URL("nearbyimage", ((URL)localObject4).getAuthority(), ((URL)localObject4).getFile()), (URLDrawable.URLDrawableOptions)localObject2);
        }
        catch (MalformedURLException localMalformedURLException2)
        {
          if (QLog.isDevelopLevel()) {
            localMalformedURLException2.printStackTrace();
          }
        }
      } else {
        Object localObject3 = null;
      }
    }
  }
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atob
 * JD-Core Version:    0.7.0.1
 */