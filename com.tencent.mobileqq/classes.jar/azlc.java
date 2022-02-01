import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.util.MQLruCache;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.GifDrawable;
import com.tencent.image.NativeGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.item.ChatThumbView;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.ThumbWidthHeightDP;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.io.File;
import java.net.URL;

public class azlc
{
  agqk jdField_a_of_type_Agqk;
  ChatThumbView jdField_a_of_type_ComTencentMobileqqActivityAioItemChatThumbView;
  MessageForPic jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
  int[] jdField_a_of_type_ArrayOfInt;
  
  private azlc(azle paramazle)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic = paramazle.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemChatThumbView = paramazle.jdField_a_of_type_ComTencentMobileqqActivityAioItemChatThumbView;
    this.jdField_a_of_type_ArrayOfInt = paramazle.jdField_a_of_type_ArrayOfInt;
    this.jdField_a_of_type_Agqk = paramazle.jdField_a_of_type_Agqk;
  }
  
  private URLDrawable a(File paramFile)
  {
    Resources localResources = BaseApplication.getContext().getResources();
    int i2 = localResources.getDisplayMetrics().densityDpi;
    float f1 = i2 / 160.0F;
    URL localURL = this.jdField_a_of_type_Agqk.jdField_a_of_type_JavaNetURL;
    boolean bool1 = this.jdField_a_of_type_Agqk.jdField_a_of_type_Boolean;
    boolean bool2 = blvp.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.imageType);
    if (bool1) {}
    label453:
    label710:
    for (;;)
    {
      int m;
      int n;
      int i1;
      try
      {
        Rect localRect = NativeGifImage.getImageSize(paramFile, false);
        if (localRect == null) {
          break label453;
        }
        j = localRect.width();
        i = localRect.height();
        k = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.getThumbWidthHeightDP(bool2).mMinWidth;
        m = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.getThumbWidthHeightDP(bool2).mMinHeight;
        n = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.getThumbWidthHeightDP(bool2).mMaxWidth;
        i1 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.getThumbWidthHeightDP(bool2).mMaxHeight;
        f1 *= 12.0F;
        if ((j >= k) && (i >= m)) {
          break label607;
        }
        if (j >= i) {
          break label554;
        }
        f2 = k / j;
        j = (int)(i * f2 + 0.5F);
        i = j;
        if (j > i1) {
          i = i1;
        }
        j = k;
        f1 = f2 * f1;
        j = (j * i2 + 80) / 160;
        i = (i * i2 + 80) / 160;
        if (localRect == null) {
          break label779;
        }
        if (localRect.width() >= j) {
          break label710;
        }
        f1 *= localRect.width() / j;
        if (QLog.isColorLevel()) {
          QLog.d("AIOPicDrawableObject", 2, "getThumbDrawable,roundCornor:" + f1 + "  w:" + j + " h:" + i);
        }
        if (this.jdField_a_of_type_ArrayOfInt != null)
        {
          this.jdField_a_of_type_ArrayOfInt[0] = j;
          this.jdField_a_of_type_ArrayOfInt[1] = i;
        }
        paramFile = URLDrawableHelper.getLoadingDrawable();
        if (!(URLDrawableHelper.getLoadingDrawable() instanceof SkinnableBitmapDrawable)) {
          break label736;
        }
        paramFile = new asbe(localResources, ((SkinnableBitmapDrawable)URLDrawableHelper.getLoadingDrawable()).getBitmap(), j, i, -921103);
        paramFile = URLDrawableHelper.getDrawable(localURL, j, i, paramFile, URLDrawableHelper.getFailedDrawable(), true, f1);
        paramFile.setProgressDrawable(new biqx(URLDrawableHelper.getCommonProgressBitmap(), 0, false));
        paramFile.setIgnorePause(true);
        paramFile.setFadeInImage(true);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemChatThumbView != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioItemChatThumbView.jdField_a_of_type_Boolean = true;
        }
        return paramFile;
      }
      catch (Throwable localThrowable1)
      {
        localThrowable1.printStackTrace();
      }
      Object localObject = null;
      continue;
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      try
      {
        bheg.a(paramFile.getAbsolutePath(), localOptions);
        j = localOptions.outWidth;
        i = localOptions.outHeight;
        k = URLDrawableHelper.getExifRotation(paramFile.getAbsolutePath());
        if ((k != 90) && (k != 270)) {
          continue;
        }
        j = localOptions.outHeight;
        i = localOptions.outWidth;
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("AIOPicDrawableObject", 2, "getThumbDrawable", localThrowable2);
          }
        }
      }
      float f2 = m / i;
      int j = (int)(j * f2 + 0.5F);
      int i = j;
      if (j > n) {
        i = n;
      }
      j = m;
      int k = i;
      i = j;
      j = k;
      continue;
      label607:
      if ((j >= n) || (i >= i1))
      {
        if (j > i)
        {
          f2 = n / j;
          label639:
          if (j <= i) {
            break label698;
          }
        }
        for (float f3 = m / i;; f3 = k / j)
        {
          f2 = Math.max(f2, f3);
          j = (int)(j * f2 + 0.5F);
          i = (int)(i * f2 + 0.5F);
          break;
          f2 = i1 / i;
          break label639;
        }
        if (localObject.height() < i)
        {
          f1 *= localObject.height() / i;
          continue;
          label736:
          if ((URLDrawableHelper.getLoadingDrawable() instanceof BitmapDrawable)) {
            paramFile = new asbe(localResources, ((BitmapDrawable)URLDrawableHelper.getLoadingDrawable()).getBitmap(), j, i, -921103);
          } else {}
        }
      }
    }
  }
  
  private URLDrawable b()
  {
    float f = BaseApplication.getContext().getResources().getDisplayMetrics().densityDpi / 160.0F;
    URLDrawable localURLDrawable = URLDrawableHelper.getDrawable(this.jdField_a_of_type_Agqk.jdField_a_of_type_JavaNetURL, 0, 0, null, null, true, 12.0F * f);
    if (this.jdField_a_of_type_ArrayOfInt != null)
    {
      this.jdField_a_of_type_ArrayOfInt[0] = localURLDrawable.getIntrinsicWidth();
      this.jdField_a_of_type_ArrayOfInt[1] = localURLDrawable.getIntrinsicHeight();
    }
    return localURLDrawable;
  }
  
  private URLDrawable c()
  {
    Resources localResources = BaseApplication.getContext().getResources();
    int i2 = localResources.getDisplayMetrics().densityDpi;
    URL localURL = this.jdField_a_of_type_Agqk.jdField_a_of_type_JavaNetURL;
    boolean bool1 = this.jdField_a_of_type_Agqk.jdField_a_of_type_Boolean;
    boolean bool2 = blvp.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.imageType);
    int j = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.getThumbWidthHeightDP(bool2).mMinWidth;
    int k = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.getThumbWidthHeightDP(bool2).mMinHeight;
    int m = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.getThumbWidthHeightDP(bool2).mMaxWidth;
    int i = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.getThumbWidthHeightDP(bool2).mMaxHeight;
    int n = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.thumbWidth;
    int i1 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.thumbHeight;
    float f1;
    Object localObject;
    URLDrawable.URLDrawableOptions localURLDrawableOptions;
    if ((n > 0) && (i1 > 0)) {
      if ((n < j) || (i1 < k)) {
        if (n < i1)
        {
          k = (int)(j / n * i1 + 0.5F);
          if (k > i)
          {
            f1 = i2 / 160.0F;
            j = (int)(j * f1 + 0.5F);
            i = (int)(i * f1 + 0.5F);
            localObject = null;
            localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
            localURLDrawableOptions.mRequestWidth = j;
            localURLDrawableOptions.mRequestHeight = i;
            localURLDrawableOptions.mLoadingDrawable = URLDrawableHelper.getLoadingDrawable();
            localURLDrawableOptions.mFailedDrawable = URLDrawableHelper.getFailedDrawable();
            localURLDrawableOptions.mPlayGifImage = bool1;
            localURLDrawableOptions.mGifRoundCorner = 12.0F;
            localURLDrawableOptions.mImgType = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.imageType;
            if (this.jdField_a_of_type_ArrayOfInt != null)
            {
              this.jdField_a_of_type_ArrayOfInt[0] = j;
              this.jdField_a_of_type_ArrayOfInt[1] = i;
            }
            if (!(URLDrawableHelper.getLoadingDrawable() instanceof SkinnableBitmapDrawable)) {
              break label574;
            }
            localObject = new asbe(localResources, ((SkinnableBitmapDrawable)URLDrawableHelper.getLoadingDrawable()).getBitmap(), j, i, -921103);
          }
        }
      }
    }
    for (;;)
    {
      if (localObject != null) {
        localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
      }
      localObject = URLDrawable.getDrawable(localURL, localURLDrawableOptions);
      ((URLDrawable)localObject).setAutoDownload(true);
      ((URLDrawable)localObject).setProgressDrawable(new biqx(URLDrawableHelper.getCommonProgressBitmap(), 0, false));
      return localObject;
      i = k;
      break;
      j = (int)(k / i1 * n + 0.5F);
      i = j;
      if (j > m) {
        i = m;
      }
      j = i;
      i = k;
      break;
      if ((n < m) && (i1 < i))
      {
        i = i1;
        j = n;
        break;
      }
      if (n > i1)
      {
        f1 = m / n;
        label454:
        if (n <= i1) {
          break label509;
        }
      }
      label509:
      for (float f2 = k / i1;; f2 = j / n)
      {
        f1 = Math.max(f1, f2);
        j = (int)(n * f1 + 0.5F);
        i = (int)(f1 * i1 + 0.5F);
        break;
        f1 = i / i1;
        break label454;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AIOPicDrawableObject", 2, "MessageForPic without width/height of thumb, width = " + n + ", height = " + i1);
      }
      i = 99;
      j = 99;
      break;
      label574:
      if ((URLDrawableHelper.getLoadingDrawable() instanceof BitmapDrawable)) {
        localObject = new asbe(localResources, ((BitmapDrawable)URLDrawableHelper.getLoadingDrawable()).getBitmap(), j, i, -921103);
      }
    }
  }
  
  public URLDrawable a()
  {
    if (this.jdField_a_of_type_Agqk == null) {
      this.jdField_a_of_type_Agqk = new agqk(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic);
    }
    Object localObject = this.jdField_a_of_type_Agqk.jdField_a_of_type_JavaNetURL.toString();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemChatThumbView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemChatThumbView.jdField_a_of_type_Boolean = false;
    }
    if (BaseApplicationImpl.sImageCache.get(localObject) != null) {
      localObject = b();
    }
    for (;;)
    {
      ((URLDrawable)localObject).setTag(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic);
      if ((((URLDrawable)localObject).getCurrDrawable() instanceof GifDrawable)) {
        ((URLDrawable)localObject).getCurrDrawable().mutate();
      }
      return localObject;
      localObject = AbsDownloader.getFile((String)localObject);
      if (localObject != null) {
        localObject = a((File)localObject);
      } else {
        localObject = c();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azlc
 * JD-Core Version:    0.7.0.1
 */