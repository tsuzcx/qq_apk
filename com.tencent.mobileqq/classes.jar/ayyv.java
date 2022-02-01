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
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.io.File;
import java.net.URL;

public class ayyv
{
  agru jdField_a_of_type_Agru;
  ChatThumbView jdField_a_of_type_ComTencentMobileqqActivityAioItemChatThumbView;
  MessageForPic jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
  int[] jdField_a_of_type_ArrayOfInt;
  
  private ayyv(ayyx paramayyx)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic = paramayyx.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemChatThumbView = paramayyx.jdField_a_of_type_ComTencentMobileqqActivityAioItemChatThumbView;
    this.jdField_a_of_type_ArrayOfInt = paramayyx.jdField_a_of_type_ArrayOfInt;
    this.jdField_a_of_type_Agru = paramayyx.jdField_a_of_type_Agru;
  }
  
  private URLDrawable a(File paramFile)
  {
    Resources localResources = BaseApplication.getContext().getResources();
    int i2 = localResources.getDisplayMetrics().densityDpi;
    float f1 = i2 / 160.0F;
    URL localURL = this.jdField_a_of_type_Agru.jdField_a_of_type_JavaNetURL;
    boolean bool1 = this.jdField_a_of_type_Agru.jdField_a_of_type_Boolean;
    boolean bool2 = bley.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.imageType);
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
        paramFile = bdzx.b();
        if (!(bdzx.b() instanceof SkinnableBitmapDrawable)) {
          break label736;
        }
        paramFile = new arnh(localResources, ((SkinnableBitmapDrawable)bdzx.b()).getBitmap(), j, i, -921103);
        paramFile = bdzx.a(localURL, j, i, paramFile, bdzx.a(), true, f1);
        paramFile.setProgressDrawable(new bhzg(bdzx.a(), 0, false));
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
        bgmo.a(paramFile.getAbsolutePath(), localOptions);
        j = localOptions.outWidth;
        i = localOptions.outHeight;
        k = bdzx.a(paramFile.getAbsolutePath());
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
          if ((bdzx.b() instanceof BitmapDrawable)) {
            paramFile = new arnh(localResources, ((BitmapDrawable)bdzx.b()).getBitmap(), j, i, -921103);
          } else {}
        }
      }
    }
  }
  
  private URLDrawable b()
  {
    float f = BaseApplication.getContext().getResources().getDisplayMetrics().densityDpi / 160.0F;
    URLDrawable localURLDrawable = bdzx.a(this.jdField_a_of_type_Agru.jdField_a_of_type_JavaNetURL, 0, 0, null, null, true, 12.0F * f);
    if (this.jdField_a_of_type_ArrayOfInt != null)
    {
      this.jdField_a_of_type_ArrayOfInt[0] = localURLDrawable.getIntrinsicWidth();
      this.jdField_a_of_type_ArrayOfInt[1] = localURLDrawable.getIntrinsicHeight();
    }
    return localURLDrawable;
  }
  
  private URLDrawable c()
  {
    Object localObject = BaseApplication.getContext();
    Resources localResources = ((Context)localObject).getResources();
    int i3 = localResources.getDisplayMetrics().densityDpi;
    URL localURL = this.jdField_a_of_type_Agru.jdField_a_of_type_JavaNetURL;
    boolean bool1 = this.jdField_a_of_type_Agru.jdField_a_of_type_Boolean;
    boolean bool2 = bley.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.imageType);
    int k;
    int j;
    int m;
    int n;
    int i;
    int i1;
    int i2;
    label190:
    float f1;
    if (!bdzx.a((Context)localObject))
    {
      k = 1;
      j = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.getThumbWidthHeightDP(bool2).mMinWidth;
      m = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.getThumbWidthHeightDP(bool2).mMinHeight;
      n = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.getThumbWidthHeightDP(bool2).mMaxWidth;
      i = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.getThumbWidthHeightDP(bool2).mMaxHeight;
      i1 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.thumbWidth;
      i2 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.thumbHeight;
      if ((i1 <= 0) || (i2 <= 0)) {
        break label552;
      }
      if ((i1 >= j) && (i2 >= m)) {
        break label448;
      }
      if (i1 >= i2) {
        break label409;
      }
      m = (int)(j / i1 * i2 + 0.5F);
      if (m <= i) {
        break label403;
      }
      f1 = i3 / 160.0F;
      j = (int)(j * f1 + 0.5F);
      i = (int)(i * f1 + 0.5F);
      localObject = null;
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = j;
      localURLDrawableOptions.mRequestHeight = i;
      localURLDrawableOptions.mLoadingDrawable = bdzx.b();
      localURLDrawableOptions.mFailedDrawable = bdzx.a();
      localURLDrawableOptions.mPlayGifImage = bool1;
      localURLDrawableOptions.mGifRoundCorner = 12.0F;
      localURLDrawableOptions.mImgType = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.imageType;
      if (this.jdField_a_of_type_ArrayOfInt != null)
      {
        this.jdField_a_of_type_ArrayOfInt[0] = j;
        this.jdField_a_of_type_ArrayOfInt[1] = i;
      }
      if (!(bdzx.b() instanceof SkinnableBitmapDrawable)) {
        break label606;
      }
      localObject = new arnh(localResources, ((SkinnableBitmapDrawable)bdzx.b()).getBitmap(), j, i, -921103);
      label339:
      if (localObject != null) {
        localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
      }
      localObject = URLDrawable.getDrawable(localURL, localURLDrawableOptions);
      if ((!ayxo.b) && (k == 0)) {
        break label646;
      }
      ((URLDrawable)localObject).setAutoDownload(true);
    }
    for (;;)
    {
      ((URLDrawable)localObject).setProgressDrawable(new bhzg(bdzx.a(), 0, false));
      return localObject;
      k = 0;
      break;
      label403:
      i = m;
      break label190;
      label409:
      j = (int)(m / i2 * i1 + 0.5F);
      i = j;
      if (j > n) {
        i = n;
      }
      j = i;
      i = m;
      break label190;
      label448:
      if ((i1 < n) && (i2 < i))
      {
        i = i2;
        j = i1;
        break label190;
      }
      if (i1 > i2)
      {
        f1 = n / i1;
        label486:
        if (i1 <= i2) {
          break label541;
        }
      }
      label541:
      for (float f2 = m / i2;; f2 = j / i1)
      {
        f1 = Math.max(f1, f2);
        j = (int)(i1 * f1 + 0.5F);
        i = (int)(f1 * i2 + 0.5F);
        break;
        f1 = i / i2;
        break label486;
      }
      label552:
      if (QLog.isColorLevel()) {
        QLog.d("AIOPicDrawableObject", 2, "MessageForPic without width/height of thumb, width = " + i1 + ", height = " + i2);
      }
      j = 99;
      i = 99;
      break label190;
      label606:
      if (!(bdzx.b() instanceof BitmapDrawable)) {
        break label339;
      }
      localObject = new arnh(localResources, ((BitmapDrawable)bdzx.b()).getBitmap(), j, i, -921103);
      break label339;
      label646:
      ((URLDrawable)localObject).setAutoDownload(false);
    }
  }
  
  public URLDrawable a()
  {
    if (this.jdField_a_of_type_Agru == null) {
      this.jdField_a_of_type_Agru = new agru(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic);
    }
    Object localObject = this.jdField_a_of_type_Agru.jdField_a_of_type_JavaNetURL.toString();
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
        ((GifDrawable)((URLDrawable)localObject).getCurrDrawable()).mutate();
      }
      return localObject;
      localObject = bdsh.a((String)localObject);
      if (localObject != null) {
        localObject = a((File)localObject);
      } else {
        localObject = c();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayyv
 * JD-Core Version:    0.7.0.1
 */