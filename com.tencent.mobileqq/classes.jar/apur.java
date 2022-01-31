import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.JpegExifReader;
import com.tencent.image.RegionDrawableData;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.gallery.model.GalleryBaseData;
import com.tencent.mobileqq.gallery.model.pic.AIOFilePicData;
import com.tencent.mobileqq.gallery.presenter.AIOGalleryBasePresenter;
import com.tencent.mobileqq.gallery.view.GalleryUrlImageView;
import com.tencent.mobileqq.gallery.view.pic.AIOGalleryFilePicView.2;
import com.tencent.mobileqq.gallery.view.pic.AIOGalleryFilePicView.3;
import com.tencent.mobileqq.pic.PicShareToWX;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.widget.AdapterView;
import com.tencent.widget.Gallery;
import com.tencent.widget.Gallery.LayoutParams;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class apur
  extends apue
  implements View.OnClickListener, begz
{
  MessageQueue.IdleHandler a;
  public ImageView a;
  public SeekBar a;
  public TextView a;
  public aptg a;
  public String a;
  public ImageView b;
  public TextView b;
  public String b;
  public ImageButton c;
  public RelativeLayout c;
  public TextView c;
  public boolean c;
  
  public apur(Activity paramActivity, aptg paramaptg)
  {
    super(paramActivity, paramaptg);
    this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler = new apuu(this);
    this.jdField_a_of_type_Aptg = paramaptg;
  }
  
  private void a(long paramLong, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Aptg.b(paramLong, paramInt1, paramInt2);
    this.jdField_a_of_type_Aptg.a(paramLong, paramInt1, 1);
  }
  
  private void a(Uri paramUri, ArrayList<bahx> paramArrayList)
  {
    if ((this.jdField_a_of_type_AndroidAppActivity == null) || (this.jdField_a_of_type_AndroidAppActivity.isFinishing()) || (this.jdField_a_of_type_Aptg.a() == null)) {
      return;
    }
    Object localObject3 = this.jdField_a_of_type_Aptg.a().getSelectedView();
    SparseArray localSparseArray = new SparseArray(2);
    Object localObject1 = null;
    int j;
    int i;
    label119:
    Matrix localMatrix;
    if ((localObject3 != null) && ((((View)localObject3).getTag() instanceof apuw)))
    {
      localObject1 = ((apuw)((View)localObject3).getTag()).a;
      j = ((View)localObject3).getWidth();
      int k = ((View)localObject3).getHeight();
      if (j >= k * 2)
      {
        i = 1;
        if (k < j * 2) {
          break label349;
        }
        j = 1;
        if ((i == 0) && (j == 0)) {
          break label394;
        }
        localMatrix = new Matrix();
        localMatrix.set(this.jdField_a_of_type_Aptg.a().a((View)localObject3));
        localObject3 = new Rect(((View)localObject3).getLeft(), ((View)localObject3).getTop(), ((View)localObject3).getRight(), ((View)localObject3).getBottom());
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = ((GalleryUrlImageView)localObject1).a((Rect)localObject3, localMatrix, this.jdField_a_of_type_Aptg.a().getWidth(), this.jdField_a_of_type_Aptg.a().getHeight());
        if (localObject1 == null) {
          break label400;
        }
        i = vup.a((Bitmap)localObject1, true, 3, localSparseArray) | 0x0;
        apsm.a().a().a("AIOGalleryFilePicView", 4, String.format("checkQQCode bmp!=null result=%d", new Object[] { Integer.valueOf(i) }));
        if (localObject1 == null)
        {
          i = vup.a(paramUri, this.jdField_a_of_type_AndroidAppActivity, 3, localSparseArray);
          apsm.a().a().a("AIOGalleryFilePicView", 4, String.format("checkQQCode bmp=null result=%d", new Object[] { Integer.valueOf(i) }));
        }
        ThreadManager.getUIHandler().post(new AIOGalleryFilePicView.2(this, i, localSparseArray, paramArrayList));
        if (i > 0) {
          this.jdField_a_of_type_JavaLangString = paramUri.getPath();
        }
        akvj.b(i);
        return;
      }
      catch (Throwable localThrowable)
      {
        label349:
        apsm.a().a().a("AIOGalleryFilePicView", 4, "checkQQCode exception :" + localThrowable.getMessage());
      }
      i = 0;
      break;
      j = 0;
      break label119;
      label394:
      Object localObject2 = null;
      continue;
      label400:
      i = 0;
      continue;
      i = 0;
    }
  }
  
  private void a(apsr paramapsr, String paramString, URLDrawable paramURLDrawable, int paramInt)
  {
    if (paramapsr.jdField_a_of_type_Int == -2) {}
    try
    {
      paramapsr.jdField_a_of_type_Int = JpegExifReader.readOrientation(paramString);
      this.jdField_a_of_type_Aptg.a.put(Integer.valueOf(paramInt), paramURLDrawable);
      aptg.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, paramURLDrawable, paramapsr.jdField_a_of_type_Int);
      this.jdField_a_of_type_Aptg.b(paramInt, true);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        apsm.a().a().a("AIOGalleryFilePicView", 4, "read exif error" + paramString.getMessage());
        paramapsr.jdField_a_of_type_Int = 1;
      }
    }
  }
  
  private boolean a(AIOFilePicData paramAIOFilePicData, GalleryUrlImageView paramGalleryUrlImageView)
  {
    apsm.a().a().a("AIOGalleryFilePicView", 4, "dealThumbImage()");
    Object localObject2 = new apsy();
    if (((apsy)localObject2).a(paramAIOFilePicData, 16) != null)
    {
      Object localObject1 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = axwd.a;
      ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = axwd.a;
      localObject2 = ((apsy)localObject2).a(paramAIOFilePicData, 16);
      paramAIOFilePicData = null;
      try
      {
        localObject1 = URLDrawable.getDrawable((File)localObject2, (URLDrawable.URLDrawableOptions)localObject1);
        paramAIOFilePicData = (AIOFilePicData)localObject1;
        ((URLDrawable)localObject1).downloadImediatly();
        paramAIOFilePicData = (AIOFilePicData)localObject1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          apsm.a().a().a("AIOGalleryFilePicView", 4, "dealTempImage() exception = " + localException.getMessage());
        }
      }
      if ((paramAIOFilePicData != null) && (paramAIOFilePicData.getStatus() == 1))
      {
        paramAIOFilePicData.setTag(Integer.valueOf(1));
        paramGalleryUrlImageView.setImageDrawable(paramAIOFilePicData);
        apsm.a().a().a("AIOGalleryFilePicView", 4, "set thumb image");
        return true;
      }
    }
    return false;
  }
  
  private boolean a(GalleryUrlImageView paramGalleryUrlImageView)
  {
    apsm.a().a().a("AIOGalleryFilePicView", 4, "dealDefaultImage()");
    paramGalleryUrlImageView.setImageDrawable(axwd.a);
    return true;
  }
  
  private boolean b(AIOFilePicData paramAIOFilePicData, GalleryUrlImageView paramGalleryUrlImageView)
  {
    apsm.a().a().a("AIOGalleryFilePicView", 4, "dealErrorImage()");
    if (paramAIOFilePicData.jdField_d_of_type_Boolean)
    {
      paramGalleryUrlImageView.setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(2130837854));
      return true;
    }
    return false;
  }
  
  private void u()
  {
    Object localObject = this.jdField_a_of_type_Aptg.a();
    if ((localObject != null) && (((apsr)localObject).jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData != null) && (((apsr)localObject).jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.a() == 3))
    {
      localObject = (AIOFilePicData)((apsr)localObject).jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData;
      if (new apsy().a((AIOFilePicData)localObject, 20))
      {
        if (((AIOFilePicData)localObject).jdField_c_of_type_Long <= 0L) {
          break label98;
        }
        a(String.format(Locale.CHINA, this.jdField_a_of_type_AndroidAppActivity.getString(2131629660), new Object[] { apdh.a(((AIOFilePicData)localObject).jdField_c_of_type_Long) }));
      }
    }
    return;
    label98:
    a(this.jdField_a_of_type_AndroidAppActivity.getString(2131629657));
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (((paramView instanceof RelativeLayout)) && ((paramView.getTag() instanceof apuw)))
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView);
      paramViewGroup = ((apuw)paramView.getTag()).a;
    }
    apsr localapsr;
    for (;;)
    {
      r();
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      localapsr = this.jdField_a_of_type_Aptg.a(paramInt);
      if ((localapsr != null) && (localapsr.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData != null)) {
        break;
      }
      return paramViewGroup;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidAppActivity);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(new Gallery.LayoutParams(-1, -1));
      paramViewGroup = new GalleryUrlImageView(this.jdField_a_of_type_AndroidAppActivity);
      paramViewGroup.setId(2131302158);
      paramViewGroup.setScaleType(ImageView.ScaleType.FIT_CENTER);
      paramView = new RelativeLayout.LayoutParams(-1, -1);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramViewGroup, paramView);
    }
    Object localObject3;
    Object localObject1;
    if (localapsr.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.a() == 3)
    {
      paramView = this.jdField_a_of_type_Aptg.b();
      if ((paramView == null) || (paramView.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData == null) || (paramView.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.a() != 3) || (paramView.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.jdField_a_of_type_Long != localapsr.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.jdField_a_of_type_Long) || (paramView.jdField_c_of_type_Boolean)) {
        break label444;
      }
      awqx.b(null, "dc00898", "", "", "0X8009EF0", "0X8009EF0", 1, 0, "", "", "", "");
      paramView.jdField_c_of_type_Boolean = true;
      localObject3 = (AIOFilePicData)localapsr.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData;
      localObject1 = new apsy();
      paramViewGroup.setPosition(paramInt);
      paramViewGroup.setImageInfo(localapsr);
      paramViewGroup.setIgnoreLayout(false);
      paramView = (URLDrawable)this.jdField_a_of_type_Aptg.a.get(Integer.valueOf(paramInt));
      if ((paramView == null) || (paramView.getStatus() != 1)) {
        break label480;
      }
      paramViewGroup.setImageDrawable(paramView);
      localObject1 = ((apsy)localObject1).a((AIOFilePicData)localObject3, 20);
      localObject3 = paramView.getURL().toString();
      this.jdField_a_of_type_Aptg.b(paramInt, true);
      if (((String)localObject3).equals(localObject1)) {
        paramViewGroup.setOriginalImage(true);
      }
      if (localapsr.jdField_a_of_type_Int == -2) {
        localapsr.jdField_a_of_type_Int = JpegExifReader.readOrientation(paramView.getURL().getFile());
      }
      localObject1 = this.jdField_a_of_type_Aptg;
      aptg.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, paramView, localapsr.jdField_a_of_type_Int);
    }
    for (;;)
    {
      paramView = new apuw(this);
      paramView.a = paramViewGroup;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(paramView);
      return this.jdField_a_of_type_AndroidWidgetRelativeLayout;
      label444:
      awqx.b(null, "dc00898", "", "", "0X8009EF0", "0X8009EF0", 2, 0, "", "", "", "");
      break;
      label480:
      File localFile = ((apsy)localObject1).a((AIOFilePicData)localObject3, 20);
      if (localFile != null)
      {
        paramView = null;
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mRequestWidth = this.jdField_a_of_type_Int;
        localURLDrawableOptions.mRequestHeight = this.jdField_b_of_type_Int;
        if (((apsy)localObject1).a((AIOFilePicData)localObject3, 16) != null)
        {
          localObject1 = URLDrawable.getFileDrawable(((AIOFilePicData)localObject3).jdField_b_of_type_JavaLangString, null);
          ((URLDrawable)localObject1).downloadImediatly();
        }
        for (localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject1);; localURLDrawableOptions.mLoadingDrawable = axwd.a)
        {
          localURLDrawableOptions.mPlayGifImage = true;
          localURLDrawableOptions.mUseExifOrientation = false;
          try
          {
            localObject1 = URLDrawable.getFileDrawable(localFile.getAbsolutePath(), localURLDrawableOptions);
            paramView = (View)localObject1;
          }
          catch (Throwable localThrowable1)
          {
            for (;;)
            {
              apsm.a().a().a("AIOGalleryFilePicView", 4, "[getView] URLDrawable.getDrawable failed.");
              continue;
              if (paramView.getStatus() == 1) {
                a(localapsr, localThrowable1, paramView, paramInt);
              }
            }
          }
          if (paramView != null)
          {
            paramView.setTag(Integer.valueOf(1));
            this.jdField_a_of_type_Aptg.a.put(Integer.valueOf(paramInt), paramView);
          }
          localObject1 = localFile.getAbsolutePath();
          paramViewGroup.setGalleryImageListener(new apuv(this, localapsr, (String)localObject1, paramView, (AIOFilePicData)localObject3, paramViewGroup));
          if ((paramView.getStatus() != 0) && (paramView.getStatus() != 4)) {
            break label702;
          }
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          paramViewGroup.setImageDrawable(paramView);
          break;
        }
      }
      label702:
      localFile = localThrowable1.a((AIOFilePicData)localObject3, 18);
      if (localFile != null)
      {
        if (localFile != null) {}
        paramView = null;
        Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = this.jdField_a_of_type_Int;
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = this.jdField_b_of_type_Int;
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = axwd.a;
        ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = true;
        ((URLDrawable.URLDrawableOptions)localObject2).mUseExifOrientation = false;
        try
        {
          localObject2 = URLDrawable.getDrawable(localFile, (URLDrawable.URLDrawableOptions)localObject2);
          paramView = (View)localObject2;
          ((URLDrawable)localObject2).downloadImediatly();
          paramView = (View)localObject2;
          if (paramView != null)
          {
            paramView.setTag(Integer.valueOf(1));
            this.jdField_a_of_type_Aptg.a.put(Integer.valueOf(paramInt), paramView);
          }
          if ((paramView != null) && (paramView.getStatus() == 1)) {
            if (localapsr.jdField_a_of_type_Int != -2) {}
          }
        }
        catch (Throwable localThrowable2)
        {
          try
          {
            localapsr.jdField_a_of_type_Int = JpegExifReader.readOrientation(localFile.getAbsolutePath());
            localObject2 = this.jdField_a_of_type_Aptg;
            aptg.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, paramView, localapsr.jdField_a_of_type_Int);
            paramViewGroup.setImageDrawable(paramView);
            this.jdField_a_of_type_Aptg.b(paramInt, true);
            continue;
            localThrowable2 = localThrowable2;
            apsm.a().a().a("AIOGalleryFilePicView", 4, "[getView] URLDrawable.getDrawable failed.");
          }
          catch (Exception localException)
          {
            for (;;)
            {
              apsm.a().a().a("AIOGalleryFilePicView", 4, "read exif error" + localException.getMessage());
              localapsr.jdField_a_of_type_Int = 1;
            }
          }
          if ((!a((AIOFilePicData)localObject3, paramViewGroup)) && (!b((AIOFilePicData)localObject3, paramViewGroup))) {
            a(paramViewGroup);
          }
          a(((AIOFilePicData)localObject3).jdField_a_of_type_Long, ((AIOFilePicData)localObject3).jdField_a_of_type_Int, 18);
        }
      }
      else if (localException.a((AIOFilePicData)localObject3, 16) != null)
      {
        if ((!a((AIOFilePicData)localObject3, paramViewGroup)) && (!b((AIOFilePicData)localObject3, paramViewGroup))) {
          a(paramViewGroup);
        }
        a(((AIOFilePicData)localObject3).jdField_a_of_type_Long, ((AIOFilePicData)localObject3).jdField_a_of_type_Int, 18);
        apsm.a().a().a("AIOGalleryFilePicView", 4, "getView(): url is " + localException.a((AIOFilePicData)localObject3, 16) + ", file type is " + 16);
      }
      else
      {
        if (((AIOFilePicData)localObject3).jdField_e_of_type_Long <= aonj.c())
        {
          if (((AIOFilePicData)localObject3).jdField_d_of_type_Boolean) {
            a(paramViewGroup);
          }
          for (;;)
          {
            apsm.a().a().a("AIOGalleryFilePicView", 4, "getView(): No pic");
            break;
            a(paramViewGroup);
            a(((AIOFilePicData)localObject3).jdField_a_of_type_Long, ((AIOFilePicData)localObject3).jdField_a_of_type_Int, 18);
          }
        }
        paramViewGroup.setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(2130837854));
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        paramViewGroup.setTag(2131296386, Float.valueOf(1.5F));
      }
    }
  }
  
  public View a(int paramInt, apsr paramapsr)
  {
    Object localObject = (URLDrawable)this.jdField_a_of_type_Aptg.a.get(Integer.valueOf(paramInt));
    if (localObject != null) {
      if (((URLDrawable)localObject).getStatus() == 3) {
        ((URLDrawable)localObject).restartDownload();
      }
    }
    AIOFilePicData localAIOFilePicData;
    do
    {
      do
      {
        do
        {
          return null;
        } while ((paramapsr == null) || (paramapsr.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData == null) || (paramapsr.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.a() != 3));
        localAIOFilePicData = (AIOFilePicData)paramapsr.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData;
        apsy localapsy = new apsy();
        localObject = localapsy.a(localAIOFilePicData, 20);
        paramapsr = (apsr)localObject;
        if (localObject == null)
        {
          paramapsr = localapsy.a(localAIOFilePicData, 18);
          if (paramapsr == null) {}
        }
        else
        {
          localObject = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = axwd.a;
          ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = axwd.a;
          ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
          ((URLDrawable.URLDrawableOptions)localObject).mUseExifOrientation = false;
          paramapsr = URLDrawable.getDrawable(paramapsr, (URLDrawable.URLDrawableOptions)localObject);
          paramapsr.setTag(Integer.valueOf(1));
          paramapsr.startDownload();
          this.jdField_a_of_type_Aptg.a.put(Integer.valueOf(paramInt), paramapsr);
          return null;
        }
        paramapsr = localapsy.a(localAIOFilePicData, 16);
        if (paramapsr == null) {
          break;
        }
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = axwd.a;
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = axwd.a;
        URLDrawable.getDrawable(paramapsr, (URLDrawable.URLDrawableOptions)localObject).startDownload();
      } while ((!badq.h(this.jdField_a_of_type_AndroidAppActivity)) || (localAIOFilePicData.jdField_e_of_type_Long > aonj.c()));
      this.jdField_a_of_type_Aptg.b(localAIOFilePicData.jdField_a_of_type_Long, localAIOFilePicData.jdField_a_of_type_Int, 18);
      return null;
    } while ((!badq.h(this.jdField_a_of_type_AndroidAppActivity)) || (localAIOFilePicData.jdField_e_of_type_Long > aonj.c()));
    this.jdField_a_of_type_Aptg.b(localAIOFilePicData.jdField_a_of_type_Long, localAIOFilePicData.jdField_a_of_type_Int, 18);
    apsm.a().a().a("AIOGalleryFilePicView", 4, "onCreateView():Thumb and large pic is not exist, download it. Gallery position is " + paramInt);
    return null;
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    Object localObject1 = this.jdField_a_of_type_Aptg.a();
    AIOFilePicData localAIOFilePicData;
    Object localObject2;
    if ((localObject1 != null) && (((apsr)localObject1).jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData != null) && (((apsr)localObject1).jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.a() == 3))
    {
      localAIOFilePicData = (AIOFilePicData)((apsr)localObject1).jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData;
      apsy localapsy = new apsy();
      localObject2 = localapsy.a(localAIOFilePicData, 20);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = localapsy.a(localAIOFilePicData, 18);
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = localapsy.a(localAIOFilePicData, 16);
      }
      if ((localObject2 != null) || (!this.jdField_a_of_type_Apsx.a())) {}
    }
    else
    {
      return;
    }
    a(localAIOFilePicData, (File)localObject2, paramInt);
  }
  
  public void a(int paramInt, View paramView, RegionDrawableData paramRegionDrawableData)
  {
    if ((paramView != null) && ((paramView.getTag() instanceof apuw)))
    {
      paramView = ((apuw)paramView.getTag()).a.getDrawable();
      if (URLDrawable.class.isInstance(paramView)) {}
    }
    else
    {
      return;
    }
    ((URLDrawable)paramView).updateRegionBitmap(paramRegionDrawableData);
  }
  
  public void a(int paramInt, String paramString1, String paramString2, View paramView, boolean paramBoolean)
  {
    apsr localapsr = this.jdField_a_of_type_Aptg.a(paramInt);
    AIOFilePicData localAIOFilePicData;
    if ((localapsr != null) && (localapsr.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData != null) && (localapsr.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.a() == 3) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && ((paramView.getTag() instanceof apuw)))
    {
      paramView = ((apuw)paramView.getTag()).a;
      localAIOFilePicData = (AIOFilePicData)localapsr.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData;
      paramString1 = new apsy();
      if (!localAIOFilePicData.jdField_d_of_type_Boolean) {
        break label271;
      }
      paramString1 = paramView.getDrawable();
      if (!URLDrawable.class.isInstance(paramString1)) {
        break label552;
      }
      paramString1 = (URLDrawable)paramString1;
      paramString2 = paramString1.getURL().getRef();
    }
    for (;;)
    {
      if ((paramString2 == null) && (apdh.b(localAIOFilePicData.jdField_b_of_type_JavaLangString)))
      {
        paramString1 = URLDrawable.URLDrawableOptions.obtain();
        paramString1.mLoadingDrawable = axwd.a;
        paramString1.mFailedDrawable = axwd.a;
        paramString1 = URLDrawable.getDrawable(new File(localAIOFilePicData.jdField_b_of_type_JavaLangString), paramString1);
        if (paramString1 != null)
        {
          paramView.setImageDrawable(paramString1);
          paramString1.downloadImediatly();
        }
      }
      label271:
      File localFile;
      do
      {
        do
        {
          do
          {
            return;
          } while ((paramString1 != null) && (paramString2 != null) && (("PART".equals(paramString2)) || ("DISPLAY".equals(paramString2))));
          paramView.setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(2130837854));
          this.jdField_a_of_type_Aptg.b(paramInt, false);
          this.jdField_a_of_type_Aptg.a().d();
        } while (localAIOFilePicData.jdField_e_of_type_Long < aonj.c());
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        return;
        localFile = paramString1.a(localAIOFilePicData, 18);
      } while (localFile == null);
      paramString2 = paramString1.a(localAIOFilePicData, 18);
      paramString1 = paramString2;
      if (paramBoolean) {
        paramString1 = paramString2 + "#PART";
      }
      paramString2 = URLDrawable.URLDrawableOptions.obtain();
      paramString2.mUseExifOrientation = false;
      paramString2.mPlayGifImage = true;
      paramString2 = URLDrawable.getDrawable(localFile, paramString2);
      if (paramString2.getStatus() == 1) {
        if (localapsr.jdField_a_of_type_Int != -2) {}
      }
      for (;;)
      {
        try
        {
          localapsr.jdField_a_of_type_Int = JpegExifReader.readOrientation(localFile.getAbsolutePath());
          paramView.setImageDrawable(paramString2);
          this.jdField_a_of_type_Aptg.b(paramInt, true);
          paramView = this.jdField_a_of_type_Aptg;
          aptg.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, paramString2, localapsr.jdField_a_of_type_Int);
          paramString2 = bace.b(localAIOFilePicData.jdField_c_of_type_JavaLangString);
          apsm.a().a().a("AIOGalleryFilePicView", 4, "AIOGalleryAdapter.updateView(): Update large image, position=" + paramInt + "url = " + paramString1 + ",extName = " + paramString2);
          this.jdField_a_of_type_Aptg.a().c();
          return;
        }
        catch (Exception localException)
        {
          apsm.a().a().a("AIOGalleryFilePicView", 4, "read exif error" + localException.getMessage());
          localapsr.jdField_a_of_type_Int = 1;
          continue;
        }
        paramString2.setTag(Integer.valueOf(1));
        paramString2.startDownload();
        paramView.setDecodingDrawble(paramString2);
      }
      label552:
      paramString2 = null;
      paramString1 = null;
    }
  }
  
  public void a(Intent paramIntent)
  {
    super.a(paramIntent);
    this.jdField_c_of_type_Boolean = paramIntent.getExtras().getBoolean("extra.OCR", false);
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    super.a(paramViewGroup);
    b(paramViewGroup);
  }
  
  public void a(AIOFilePicData paramAIOFilePicData, File paramFile)
  {
    this.jdField_a_of_type_Bahv.a(new aput(this, paramAIOFilePicData, paramFile));
  }
  
  public void a(AIOFilePicData paramAIOFilePicData, File paramFile, int paramInt)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if (paramFile != null)
    {
      a(2131627268, 2130839591, 59, localArrayList1);
      if ((PicShareToWX.a().a()) && (PicShareToWX.a().a(paramFile))) {
        a(2131627278, 2130845718, 69, localArrayList1);
      }
      a(2131627277, 2130839599, 53, localArrayList1);
      awqx.b(null, "dc00898", "", "", "0X800A60D", "0X800A60D", 0, 0, "", "", "", "");
      a(2131627270, 2130843401, 67, localArrayList1);
      a(2131627279, 2130839600, 58, localArrayList1);
      a(2131627267, 2130839590, 57, localArrayList1);
      if ((this.jdField_a_of_type_Apsx.g()) && (!TextUtils.isEmpty(this.jdField_a_of_type_Apsx.c()))) {
        a(2131627281, 2130839601, 54, localArrayList2);
      }
      if (this.jdField_c_of_type_Boolean) {
        a(2131627273, 2130839595, 52, localArrayList2, 2);
      }
      ThreadManager.getFileThreadHandler().post(new AIOGalleryFilePicView.3(this, paramFile, localArrayList2));
    }
    for (;;)
    {
      a(paramAIOFilePicData, paramFile);
      paramAIOFilePicData = (List[])new ArrayList[] { localArrayList1, localArrayList2 };
      this.jdField_a_of_type_Bahv.a(paramAIOFilePicData);
      this.jdField_a_of_type_Bahv.a();
      return;
      if ((this.jdField_a_of_type_Apsx.g()) && (!TextUtils.isEmpty(this.jdField_a_of_type_Apsx.c()))) {
        a(2131627281, 2130839601, 54, localArrayList2);
      }
    }
  }
  
  public void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    super.a(paramAdapterView, paramView, paramInt, paramLong);
    if ((paramView != null) && ((paramView.getTag() instanceof apuw)))
    {
      paramAdapterView = (apuw)paramView.getTag();
      if (paramAdapterView.a != null)
      {
        paramView = paramAdapterView.a;
        paramAdapterView = paramView.getDrawable();
        apsr localapsr = this.jdField_a_of_type_Aptg.a();
        if ((!paramView.a()) && (localapsr != null) && (localapsr.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData != null) && (localapsr.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.a() == 1))
        {
          paramView = (AIOFilePicData)localapsr.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData;
          if (((paramAdapterView instanceof SkinnableBitmapDrawable)) && (paramView.jdField_b_of_type_Int == 1) && (paramView.jdField_c_of_type_Long > aonj.c()) && (this.jdField_a_of_type_Aptg.a() != null))
          {
            this.jdField_a_of_type_Aptg.a().b(false);
            this.jdField_a_of_type_Aptg.a().a(false);
          }
        }
      }
      j();
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(paramString);
    }
  }
  
  public boolean a()
  {
    Object localObject = this.jdField_a_of_type_Aptg.a();
    if ((localObject != null) && (((apsr)localObject).jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData != null) && (((apsr)localObject).jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.a() == 3))
    {
      localObject = (AIOFilePicData)((apsr)localObject).jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData;
      if (((AIOFilePicData)localObject).jdField_e_of_type_Int == 2)
      {
        this.jdField_a_of_type_Aptg.c(((AIOFilePicData)localObject).jdField_a_of_type_Long, ((AIOFilePicData)localObject).jdField_a_of_type_Int, 20);
        this.jdField_a_of_type_Aptg.a(((AIOFilePicData)localObject).jdField_a_of_type_Long, ((AIOFilePicData)localObject).jdField_a_of_type_Int, 0);
      }
    }
    return super.a();
  }
  
  public boolean a(apsr paramapsr)
  {
    return super.a(paramapsr);
  }
  
  public void an_()
  {
    this.jdField_a_of_type_Aptg.aJ_();
  }
  
  public void b()
  {
    super.b();
  }
  
  public void b(ViewGroup paramViewGroup)
  {
    super.b(paramViewGroup);
  }
  
  public void b(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.jdField_a_of_type_Aptg.j();
  }
  
  public void c(boolean paramBoolean)
  {
    super.c(paramBoolean);
    if ((this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.a().b()))
    {
      this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.a = false;
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.b(false);
    d(false);
    this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.s();
  }
  
  public boolean d()
  {
    Object localObject;
    if (super.d())
    {
      localObject = this.jdField_a_of_type_Aptg.a();
      if ((localObject != null) && (((apsr)localObject).jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData != null) && (((apsr)localObject).jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.a() == 3))
      {
        AIOFilePicData localAIOFilePicData = (AIOFilePicData)((apsr)localObject).jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData;
        apsy localapsy = new apsy();
        localObject = localapsy.a(localAIOFilePicData, 20);
        if (localObject != null) {
          break label113;
        }
        localObject = localapsy.a(localAIOFilePicData, 18);
      }
    }
    label113:
    for (;;)
    {
      if ((localObject == null) && (this.jdField_a_of_type_Apsx.a())) {
        return false;
      }
      return (!this.jdField_a_of_type_Apsx.a()) && (!this.jdField_a_of_type_Apsx.c());
    }
  }
  
  public void e()
  {
    super.e();
    Looper.myQueue().addIdleHandler(this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler);
    d(true);
    j();
  }
  
  public void e(boolean paramBoolean)
  {
    TextView localTextView;
    if (this.jdField_c_of_type_AndroidWidgetTextView != null)
    {
      if (paramBoolean) {
        u();
      }
      localTextView = this.jdField_c_of_type_AndroidWidgetTextView;
      if (!paramBoolean) {
        break label32;
      }
    }
    label32:
    for (int i = 0;; i = 8)
    {
      localTextView.setVisibility(i);
      return;
    }
  }
  
  public boolean e()
  {
    if ((this.jdField_a_of_type_AndroidAppActivity.getIntent().getBooleanExtra("extra.FROM_AIO", false)) || (this.jdField_a_of_type_Apsx.c() == 3) || (this.jdField_a_of_type_Apsx.c() == 2)) {}
    for (int i = 1;; i = 0)
    {
      Bundle localBundle = this.jdField_a_of_type_AndroidAppActivity.getIntent().getExtras();
      if (((i == 0) && ((this.jdField_a_of_type_Apsx.c() != 4) || (!localBundle.getBoolean("key_allow_forward_photo_preview_edit", false)))) || (akbm.a(this.jdField_a_of_type_Apsx.a()) == 1032) || (this.jdField_a_of_type_Apsx.a() == 1037) || (this.jdField_a_of_type_Apsx.a() == 1044)) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public void f()
  {
    d(false);
  }
  
  public void f(boolean paramBoolean)
  {
    ImageButton localImageButton;
    if (this.jdField_c_of_type_AndroidWidgetImageButton != null)
    {
      localImageButton = this.jdField_c_of_type_AndroidWidgetImageButton;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localImageButton.setVisibility(i);
      return;
    }
  }
  
  public void g(boolean paramBoolean)
  {
    if (this.jdField_c_of_type_AndroidWidgetImageButton != null) {
      this.jdField_c_of_type_AndroidWidgetImageButton.setEnabled(paramBoolean);
    }
  }
  
  public void j()
  {
    super.j();
    Object localObject = this.jdField_a_of_type_Aptg.a();
    AIOFilePicData localAIOFilePicData;
    if ((localObject != null) && (((apsr)localObject).jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData != null) && (((apsr)localObject).jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.a() == 3)) {
      localAIOFilePicData = (AIOFilePicData)((apsr)localObject).jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData;
    }
    switch (localAIOFilePicData.jdField_e_of_type_Int)
    {
    default: 
      apsm.a().a().a("AIOGalleryFilePicView", 4, "updateUI status is error, status = " + localAIOFilePicData.jdField_e_of_type_Int);
      return;
    case 1: 
      e(false);
      a(false);
      f(false);
      b(false);
      this.jdField_a_of_type_Aptg.a(this.jdField_a_of_type_Aptg.c(), localAIOFilePicData.f);
      return;
    case 2: 
      this.jdField_a_of_type_Aptg.b(this.jdField_a_of_type_Aptg.c(), true);
      e(false);
      a(false);
      f(false);
      b(false);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(ajjy.a(2131634262) + localAIOFilePicData.f / 100 + "%");
      this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(localAIOFilePicData.f / 100);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      return;
    }
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    a(d());
    b(a((apsr)localObject));
    boolean bool;
    if (!apdh.b(localAIOFilePicData.jdField_d_of_type_JavaLangString))
    {
      bool = true;
      e(bool);
      f(true);
      localObject = new apsy();
      if (localAIOFilePicData.jdField_e_of_type_Long <= 10485760L) {
        break label342;
      }
      g(false);
    }
    for (;;)
    {
      this.jdField_a_of_type_Aptg.b(this.jdField_a_of_type_Aptg.c(), true);
      return;
      bool = false;
      break;
      label342:
      if ((((apsy)localObject).a(localAIOFilePicData, 18) != null) || (((apsy)localObject).a(localAIOFilePicData, 20) != null)) {
        g(true);
      } else {
        g(false);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131304131: 
    case 2131298714: 
      do
      {
        do
        {
          return;
          paramView = this.jdField_a_of_type_Aptg.a();
        } while ((paramView == null) || (paramView.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData == null) || (paramView.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.a() != 3));
        this.jdField_a_of_type_Aptg.j();
        return;
        paramView = this.jdField_a_of_type_Aptg.a();
      } while ((paramView == null) || (paramView.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData == null));
      this.jdField_a_of_type_Aptg.c(paramView.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.jdField_a_of_type_Long, paramView.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.jdField_a_of_type_Int, 20);
      this.jdField_a_of_type_Aptg.a(paramView.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.jdField_a_of_type_Long, paramView.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.jdField_a_of_type_Int, 0);
      j();
      return;
    case 2131307315: 
      s();
      return;
    case 2131307312: 
      t();
      this.jdField_a_of_type_Aptg.aK_();
      return;
    case 2131307310: 
      l();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryFilePicView", 0, "onClick qq_gallery_danmaku_view ");
    }
    paramView = this.jdField_a_of_type_Aptg.a();
    if ((paramView != null) && (paramView.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData != null)) {
      MiniChatActivity.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Apsx.a(), this.jdField_a_of_type_Apsx.a(), false, 26, paramView.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.d, 0L);
    }
    this.jdField_a_of_type_Aptg.r();
  }
  
  public void r()
  {
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout == null)
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131493509, null));
      this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131309807));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131306326));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131298714));
      this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131310015));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131300291));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131303831));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131307312));
      this.jdField_c_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131307315));
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
      f(e());
      this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131307308));
      if (this.jdField_a_of_type_AndroidWidgetImageButton != null) {
        this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      }
      this.jdField_b_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131307310));
      if (this.jdField_b_of_type_AndroidWidgetImageButton != null) {
        this.jdField_b_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      }
    }
    if (!this.jdField_b_of_type_Boolean) {
      d(true);
    }
  }
  
  public void s()
  {
    Object localObject = this.jdField_a_of_type_Aptg.a();
    if ((localObject != null) && (((apsr)localObject).jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData != null) && (((apsr)localObject).jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.a() == 3) && (this.jdField_a_of_type_Aptg.e()))
    {
      if (!badq.d(this.jdField_a_of_type_AndroidAppActivity))
      {
        bbmy.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131628303), 0).a();
        j();
      }
    }
    else {
      return;
    }
    localObject = (AIOFilePicData)((apsr)localObject).jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData;
    if (((AIOFilePicData)localObject).g)
    {
      bbmy.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131627218), 0).a();
      j();
      return;
    }
    if (((AIOFilePicData)localObject).h) {
      j();
    }
    long l = aonj.a();
    if ((((AIOFilePicData)localObject).jdField_e_of_type_Long > l) && (apck.a())) {
      try
      {
        apck.a(false, this.jdField_a_of_type_AndroidAppActivity, new apus(this, (AIOFilePicData)localObject));
        return;
      }
      catch (Throwable localThrowable)
      {
        apsm.a().a().a("AIOGalleryFilePicView", 4, "showFlowDialog throwable = " + localThrowable.getMessage());
        return;
      }
    }
    this.jdField_a_of_type_Aptg.a(localThrowable.jdField_a_of_type_Long, localThrowable.jdField_a_of_type_Int, 2);
    this.jdField_a_of_type_Aptg.b(localThrowable.jdField_a_of_type_Long, localThrowable.jdField_a_of_type_Int, 20);
    if (this.jdField_a_of_type_Aptg.a() != null)
    {
      this.jdField_a_of_type_Aptg.a().b(true);
      this.jdField_a_of_type_Aptg.a().a(true);
    }
    j();
  }
  
  void t()
  {
    Object localObject1 = this.jdField_a_of_type_Aptg.a();
    AIOFilePicData localAIOFilePicData;
    Object localObject2;
    if ((localObject1 != null) && (((apsr)localObject1).jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData != null) && (((apsr)localObject1).jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.a() == 3))
    {
      localAIOFilePicData = (AIOFilePicData)((apsr)localObject1).jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData;
      apsy localapsy = new apsy();
      localObject2 = localapsy.a(localAIOFilePicData, 20);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = localapsy.a(localAIOFilePicData, 18);
      }
      if (localObject1 != null) {
        break label516;
      }
      localObject1 = localapsy.a(localAIOFilePicData, 16);
    }
    label516:
    for (;;)
    {
      if (localObject1 == null) {
        return;
      }
      this.jdField_b_of_type_JavaLangString = ((File)localObject1).getAbsolutePath();
      int i = 99;
      int j;
      boolean bool;
      int k;
      switch (this.jdField_a_of_type_Apsx.c())
      {
      default: 
        j = 0;
        bool = false;
        k = 0;
        localObject1 = EditPicActivity.a(this.jdField_a_of_type_AndroidAppActivity, ((File)localObject1).getAbsolutePath(), true, true, true, true, true, 2, i, 7);
        ((Intent)localObject1).putExtra("uintype", this.jdField_a_of_type_Apsx.a());
        ((Intent)localObject1).putExtra("open_chatfragment", true);
        ((Intent)localObject1).putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1041);
        ((Intent)localObject1).putExtra("key_enable_edit_title_bar", true);
        if (bool) {
          ((Intent)localObject1).putExtra("key_help_forward_pic", bool);
        }
        if (j != 0) {
          ((Intent)localObject1).putExtra("key_allow_multiple_forward_from_limit", false);
        }
        if (this.jdField_a_of_type_Aptg.e())
        {
          localObject2 = this.jdField_a_of_type_Aptg.a(localAIOFilePicData.jdField_a_of_type_Long, localAIOFilePicData.jdField_a_of_type_Int, this.jdField_a_of_type_Apsx.a());
          if (localObject2 != null)
          {
            ((Intent)localObject2).setExtrasClassLoader(ForwardFileInfo.class.getClassLoader());
            localObject2 = (ForwardFileInfo)((Intent)localObject2).getParcelableExtra("fileinfo");
            if (localObject2 != null) {
              ((Intent)localObject1).putExtra("fileinfo", (Parcelable)localObject2);
            }
          }
        }
        ((Intent)localObject1).putExtra("not_forward", true);
        if (k != 0) {
          this.jdField_a_of_type_AndroidAppActivity.startActivityForResult((Intent)localObject1, k);
        }
        break;
      }
      for (;;)
      {
        awqx.b(null, "dc00898", "", "", "0X8007ACE", "0X8007ACE", 0, 0, "", "", "", "");
        return;
        i = 125;
        j = 0;
        bool = true;
        k = 19002;
        break;
        i = 126;
        j = 1;
        bool = true;
        k = 19000;
        break;
        i = 127;
        j = 1;
        bool = true;
        k = 19000;
        break;
        i = 128;
        j = 1;
        bool = true;
        k = 19000;
        break;
        i = 129;
        j = 1;
        bool = true;
        k = 19000;
        break;
        i = 130;
        j = 0;
        bool = true;
        k = 19000;
        break;
        this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     apur
 * JD-Core Version:    0.7.0.1
 */