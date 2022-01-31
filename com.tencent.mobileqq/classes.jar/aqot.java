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

public class aqot
  extends aqog
  implements View.OnClickListener, bfpk
{
  MessageQueue.IdleHandler a;
  public ImageView a;
  public SeekBar a;
  public TextView a;
  public aqnh a;
  public String a;
  public ImageView b;
  public TextView b;
  public String b;
  public ImageButton c;
  public RelativeLayout c;
  public TextView c;
  public boolean c;
  
  public aqot(Activity paramActivity, aqnh paramaqnh)
  {
    super(paramActivity, paramaqnh);
    this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler = new aqow(this);
    this.jdField_a_of_type_Aqnh = paramaqnh;
  }
  
  private void a(long paramLong, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Aqnh.b(paramLong, paramInt1, paramInt2);
    this.jdField_a_of_type_Aqnh.a(paramLong, paramInt1, 1);
  }
  
  private void a(Uri paramUri, ArrayList<bbjs> paramArrayList)
  {
    if ((this.jdField_a_of_type_AndroidAppActivity == null) || (this.jdField_a_of_type_AndroidAppActivity.isFinishing()) || (this.jdField_a_of_type_Aqnh.a() == null)) {
      return;
    }
    Object localObject3 = this.jdField_a_of_type_Aqnh.a().getSelectedView();
    SparseArray localSparseArray = new SparseArray(2);
    Object localObject1 = null;
    int j;
    int i;
    label119:
    Matrix localMatrix;
    if ((localObject3 != null) && ((((View)localObject3).getTag() instanceof aqoy)))
    {
      localObject1 = ((aqoy)((View)localObject3).getTag()).jdField_a_of_type_ComTencentMobileqqGalleryViewGalleryUrlImageView;
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
        localMatrix.set(this.jdField_a_of_type_Aqnh.a().a((View)localObject3));
        localObject3 = new Rect(((View)localObject3).getLeft(), ((View)localObject3).getTop(), ((View)localObject3).getRight(), ((View)localObject3).getBottom());
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = ((GalleryUrlImageView)localObject1).a((Rect)localObject3, localMatrix, this.jdField_a_of_type_Aqnh.a().getWidth(), this.jdField_a_of_type_Aqnh.a().getHeight());
        if (localObject1 == null) {
          break label400;
        }
        i = whj.a((Bitmap)localObject1, true, 3, localSparseArray) | 0x0;
        aqmd.a().a().a("AIOGalleryFilePicView", 4, String.format("checkQQCode bmp!=null result=%d", new Object[] { Integer.valueOf(i) }));
        if (localObject1 == null)
        {
          i = whj.a(paramUri, this.jdField_a_of_type_AndroidAppActivity, 3, localSparseArray);
          aqmd.a().a().a("AIOGalleryFilePicView", 4, String.format("checkQQCode bmp=null result=%d", new Object[] { Integer.valueOf(i) }));
        }
        ThreadManager.getUIHandler().post(new AIOGalleryFilePicView.2(this, i, localSparseArray, paramArrayList));
        if (i > 0) {
          this.jdField_a_of_type_JavaLangString = paramUri.getPath();
        }
        alju.b(i);
        return;
      }
      catch (Throwable localThrowable)
      {
        label349:
        aqmd.a().a().a("AIOGalleryFilePicView", 4, "checkQQCode exception :" + localThrowable.getMessage());
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
  
  private void a(aqmi paramaqmi, String paramString, URLDrawable paramURLDrawable, int paramInt)
  {
    if (paramaqmi.jdField_a_of_type_Int == -2) {}
    try
    {
      paramaqmi.jdField_a_of_type_Int = JpegExifReader.readOrientation(paramString);
      this.jdField_a_of_type_Aqnh.a.put(Integer.valueOf(paramInt), paramURLDrawable);
      aqnh.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, paramURLDrawable, paramaqmi.jdField_a_of_type_Int);
      this.jdField_a_of_type_Aqnh.b(paramInt, true);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        aqmd.a().a().a("AIOGalleryFilePicView", 4, "read exif error" + paramString.getMessage());
        paramaqmi.jdField_a_of_type_Int = 1;
      }
    }
  }
  
  private boolean a(AIOFilePicData paramAIOFilePicData, GalleryUrlImageView paramGalleryUrlImageView)
  {
    aqmd.a().a().a("AIOGalleryFilePicView", 4, "dealThumbImage()");
    Object localObject2 = new aqmp();
    if (((aqmp)localObject2).a(paramAIOFilePicData, 16) != null)
    {
      Object localObject1 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = aywm.a;
      ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = aywm.a;
      localObject2 = ((aqmp)localObject2).a(paramAIOFilePicData, 16);
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
          aqmd.a().a().a("AIOGalleryFilePicView", 4, "dealTempImage() exception = " + localException.getMessage());
        }
      }
      if ((paramAIOFilePicData != null) && (paramAIOFilePicData.getStatus() == 1))
      {
        paramAIOFilePicData.setTag(Integer.valueOf(1));
        paramGalleryUrlImageView.setImageDrawable(paramAIOFilePicData);
        aqmd.a().a().a("AIOGalleryFilePicView", 4, "set thumb image");
        return true;
      }
    }
    return false;
  }
  
  private boolean a(GalleryUrlImageView paramGalleryUrlImageView)
  {
    aqmd.a().a().a("AIOGalleryFilePicView", 4, "dealDefaultImage()");
    paramGalleryUrlImageView.setImageDrawable(aywm.a);
    return true;
  }
  
  private boolean b(AIOFilePicData paramAIOFilePicData, GalleryUrlImageView paramGalleryUrlImageView)
  {
    aqmd.a().a().a("AIOGalleryFilePicView", 4, "dealErrorImage()");
    if (paramAIOFilePicData.jdField_d_of_type_Boolean)
    {
      paramGalleryUrlImageView.setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(2130837911));
      return true;
    }
    return false;
  }
  
  private void v()
  {
    Object localObject = this.jdField_a_of_type_Aqnh.a();
    if ((localObject != null) && (((aqmi)localObject).jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData != null) && (((aqmi)localObject).jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.a() == 3))
    {
      localObject = (AIOFilePicData)((aqmi)localObject).jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData;
      if (new aqmp().a((AIOFilePicData)localObject, 20))
      {
        if (((AIOFilePicData)localObject).jdField_c_of_type_Long <= 0L) {
          break label98;
        }
        a(String.format(Locale.CHINA, this.jdField_a_of_type_AndroidAppActivity.getString(2131695342), new Object[] { apvd.a(((AIOFilePicData)localObject).jdField_c_of_type_Long) }));
      }
    }
    return;
    label98:
    a(this.jdField_a_of_type_AndroidAppActivity.getString(2131695339));
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    GalleryUrlImageView localGalleryUrlImageView;
    if (((paramView instanceof RelativeLayout)) && ((paramView.getTag() instanceof aqoy)))
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView);
      paramView = (aqoy)paramView.getTag();
      localGalleryUrlImageView = paramView.jdField_a_of_type_ComTencentMobileqqGalleryViewGalleryUrlImageView;
      paramViewGroup = paramView.jdField_a_of_type_AndroidWidgetTextView;
      paramViewGroup.setVisibility(8);
      paramView = (RelativeLayout.LayoutParams)localGalleryUrlImageView.getLayoutParams();
      paramView.width = -1;
      paramView.height = -1;
      localGalleryUrlImageView.setLayoutParams(paramView);
    }
    aqmi localaqmi;
    for (;;)
    {
      s();
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      localaqmi = this.jdField_a_of_type_Aqnh.a(paramInt);
      if ((localaqmi != null) && (localaqmi.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData != null)) {
        break;
      }
      return localGalleryUrlImageView;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidAppActivity);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(new Gallery.LayoutParams(-1, -1));
      localGalleryUrlImageView = new GalleryUrlImageView(this.jdField_a_of_type_AndroidAppActivity);
      localGalleryUrlImageView.setId(2131367776);
      localGalleryUrlImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      paramView = new RelativeLayout.LayoutParams(-1, -1);
      paramView.addRule(14);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localGalleryUrlImageView, paramView);
      paramViewGroup = new TextView(this.jdField_a_of_type_AndroidAppActivity);
      paramViewGroup.setTextSize(12.0F);
      paramViewGroup.setTextColor(-1);
      paramView = new RelativeLayout.LayoutParams(-2, -2);
      paramView.addRule(3, 2131367776);
      paramView.addRule(14);
      paramView.topMargin = actj.a(20.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramViewGroup, paramView);
      paramViewGroup.setVisibility(8);
    }
    AIOFilePicData localAIOFilePicData;
    Object localObject3;
    Object localObject4;
    Object localObject1;
    if (localaqmi.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.a() == 3)
    {
      paramView = this.jdField_a_of_type_Aqnh.b();
      if ((paramView == null) || (paramView.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData == null) || (paramView.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.a() != 3) || (paramView.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.jdField_a_of_type_Long != localaqmi.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.jdField_a_of_type_Long) || (paramView.jdField_c_of_type_Boolean)) {
        break label706;
      }
      axqy.b(null, "dc00898", "", "", "0X8009EF0", "0X8009EF0", 1, 0, "", "", "", "");
      paramView.jdField_c_of_type_Boolean = true;
      localAIOFilePicData = (AIOFilePicData)localaqmi.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData;
      localObject3 = new aqmp();
      localGalleryUrlImageView.setPosition(paramInt);
      localGalleryUrlImageView.setImageInfo(localaqmi);
      localGalleryUrlImageView.setIgnoreLayout(false);
      localGalleryUrlImageView.setContentDescription(this.jdField_a_of_type_AndroidAppActivity.getString(2131691609));
      localObject4 = (URLDrawable)this.jdField_a_of_type_Aqnh.a.get(Integer.valueOf(paramInt));
      String str1 = ((aqmp)localObject3).a(localAIOFilePicData, 20);
      String str2 = ((aqmp)localObject3).a(localAIOFilePicData, 18);
      String str3 = ((aqmp)localObject3).a(localAIOFilePicData, 16);
      localObject1 = "";
      paramView = (View)localObject1;
      if (localObject4 != null)
      {
        paramView = (View)localObject1;
        if (((URLDrawable)localObject4).getURL() != null) {
          paramView = ((URLDrawable)localObject4).getURL().toString();
        }
      }
      if ((localObject4 == null) || (((URLDrawable)localObject4).getStatus() != 1) || (TextUtils.isEmpty(paramView)) || ((!paramView.equals(str1)) && (!paramView.equals(str2)) && (!paramView.equals(str3)))) {
        break label742;
      }
      localGalleryUrlImageView.setImageDrawable((Drawable)localObject4);
      paramView = ((aqmp)localObject3).a(localAIOFilePicData, 20);
      localObject1 = ((URLDrawable)localObject4).getURL().toString();
      this.jdField_a_of_type_Aqnh.b(paramInt, true);
      if (((String)localObject1).equals(paramView)) {
        localGalleryUrlImageView.setOriginalImage(true);
      }
      if (localaqmi.jdField_a_of_type_Int == -2) {
        localaqmi.jdField_a_of_type_Int = JpegExifReader.readOrientation(((URLDrawable)localObject4).getURL().getFile());
      }
      paramView = this.jdField_a_of_type_Aqnh;
      aqnh.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, (URLDrawable)localObject4, localaqmi.jdField_a_of_type_Int);
    }
    for (;;)
    {
      paramView = new aqoy(this);
      paramView.jdField_a_of_type_ComTencentMobileqqGalleryViewGalleryUrlImageView = localGalleryUrlImageView;
      paramView.jdField_a_of_type_AndroidWidgetTextView = paramViewGroup;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(paramView);
      return this.jdField_a_of_type_AndroidWidgetRelativeLayout;
      label706:
      axqy.b(null, "dc00898", "", "", "0X8009EF0", "0X8009EF0", 2, 0, "", "", "", "");
      break;
      label742:
      localObject4 = ((aqmp)localObject3).a(localAIOFilePicData, 20);
      if (localObject4 != null)
      {
        paramView = null;
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = this.jdField_a_of_type_Int;
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = this.jdField_b_of_type_Int;
        if (((aqmp)localObject3).a(localAIOFilePicData, 16) != null)
        {
          localObject3 = URLDrawable.getFileDrawable(localAIOFilePicData.jdField_b_of_type_JavaLangString, null);
          ((URLDrawable)localObject3).downloadImediatly();
        }
        for (((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = ((Drawable)localObject3);; ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = aywm.a)
        {
          ((URLDrawable.URLDrawableOptions)localObject1).mPlayGifImage = true;
          ((URLDrawable.URLDrawableOptions)localObject1).mUseExifOrientation = false;
          try
          {
            localObject1 = URLDrawable.getFileDrawable(((File)localObject4).getAbsolutePath(), (URLDrawable.URLDrawableOptions)localObject1);
            paramView = (View)localObject1;
          }
          catch (Throwable localThrowable1)
          {
            for (;;)
            {
              aqmd.a().a().a("AIOGalleryFilePicView", 4, "[getView] URLDrawable.getDrawable failed.");
              continue;
              if (paramView.getStatus() == 1) {
                a(localaqmi, localThrowable1, paramView, paramInt);
              }
            }
          }
          if (paramView == null) {
            break;
          }
          paramView.setTag(Integer.valueOf(1));
          this.jdField_a_of_type_Aqnh.a.put(Integer.valueOf(paramInt), paramView);
          localObject1 = ((File)localObject4).getAbsolutePath();
          localGalleryUrlImageView.setGalleryImageListener(new aqox(this, localaqmi, (String)localObject1, paramView, localAIOFilePicData, localGalleryUrlImageView));
          if ((paramView.getStatus() != 0) && (paramView.getStatus() != 4)) {
            break label967;
          }
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          localGalleryUrlImageView.setImageDrawable(paramView);
          break;
        }
      }
      label967:
      localObject4 = ((aqmp)localObject3).a(localAIOFilePicData, 18);
      if (localObject4 != null)
      {
        if (localObject4 != null) {}
        paramView = null;
        Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = this.jdField_a_of_type_Int;
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = this.jdField_b_of_type_Int;
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = aywm.a;
        ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = true;
        ((URLDrawable.URLDrawableOptions)localObject2).mUseExifOrientation = false;
        try
        {
          localObject2 = URLDrawable.getDrawable((File)localObject4, (URLDrawable.URLDrawableOptions)localObject2);
          paramView = (View)localObject2;
          ((URLDrawable)localObject2).setTag(Integer.valueOf(1));
          paramView = (View)localObject2;
          ((URLDrawable)localObject2).downloadImediatly();
          paramView = (View)localObject2;
          if (paramView != null) {
            this.jdField_a_of_type_Aqnh.a.put(Integer.valueOf(paramInt), paramView);
          }
          if ((paramView != null) && (paramView.getStatus() == 1)) {
            if (localaqmi.jdField_a_of_type_Int != -2) {}
          }
        }
        catch (Throwable localThrowable2)
        {
          try
          {
            localaqmi.jdField_a_of_type_Int = JpegExifReader.readOrientation(((File)localObject4).getAbsolutePath());
            localObject2 = this.jdField_a_of_type_Aqnh;
            aqnh.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, paramView, localaqmi.jdField_a_of_type_Int);
            localGalleryUrlImageView.setImageDrawable(paramView);
            this.jdField_a_of_type_Aqnh.b(paramInt, true);
            continue;
            localThrowable2 = localThrowable2;
            aqmd.a().a().a("AIOGalleryFilePicView", 4, "[getView] URLDrawable.getDrawable failed.");
          }
          catch (Exception localException)
          {
            for (;;)
            {
              aqmd.a().a().a("AIOGalleryFilePicView", 4, "read exif error" + localException.getMessage());
              localaqmi.jdField_a_of_type_Int = 1;
            }
          }
          if ((!a(localAIOFilePicData, localGalleryUrlImageView)) && (!b(localAIOFilePicData, localGalleryUrlImageView))) {
            a(localGalleryUrlImageView);
          }
          a(localAIOFilePicData.jdField_a_of_type_Long, localAIOFilePicData.jdField_a_of_type_Int, 18);
        }
      }
      else if (((aqmp)localObject3).a(localAIOFilePicData, 16) != null)
      {
        if ((!a(localAIOFilePicData, localGalleryUrlImageView)) && (!b(localAIOFilePicData, localGalleryUrlImageView))) {
          a(localGalleryUrlImageView);
        }
        a(localAIOFilePicData.jdField_a_of_type_Long, localAIOFilePicData.jdField_a_of_type_Int, 18);
        aqmd.a().a().a("AIOGalleryFilePicView", 4, "getView(): url is " + ((aqmp)localObject3).a(localAIOFilePicData, 16) + ", file type is " + 16);
      }
      else
      {
        if ((!apvm.a(localAIOFilePicData.jdField_g_of_type_Int, localAIOFilePicData.jdField_h_of_type_Int, localAIOFilePicData.jdField_e_of_type_Long)) && (localAIOFilePicData.i != 1))
        {
          if (localAIOFilePicData.jdField_d_of_type_Boolean) {
            a(localGalleryUrlImageView);
          }
          for (;;)
          {
            aqmd.a().a().a("AIOGalleryFilePicView", 4, "getView(): No pic");
            break;
            a(localGalleryUrlImageView);
            a(localAIOFilePicData.jdField_a_of_type_Long, localAIOFilePicData.jdField_a_of_type_Int, 18);
          }
        }
        localGalleryUrlImageView.setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(2130843447));
        paramView = (RelativeLayout.LayoutParams)localGalleryUrlImageView.getLayoutParams();
        paramView.width = actj.a(60.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
        paramView.height = actj.a(60.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
        localGalleryUrlImageView.setLayoutParams(paramView);
        paramViewGroup.setVisibility(0);
        paramViewGroup.setText(2131692524);
        localGalleryUrlImageView.setTag(2131296386, Float.valueOf(1.5F));
        this.jdField_a_of_type_Aqnh.q();
      }
    }
  }
  
  public View a(int paramInt, aqmi paramaqmi)
  {
    Object localObject = (URLDrawable)this.jdField_a_of_type_Aqnh.a.get(Integer.valueOf(paramInt));
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
        } while ((paramaqmi == null) || (paramaqmi.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData == null) || (paramaqmi.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.a() != 3));
        localAIOFilePicData = (AIOFilePicData)paramaqmi.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData;
        aqmp localaqmp = new aqmp();
        localObject = localaqmp.a(localAIOFilePicData, 20);
        paramaqmi = (aqmi)localObject;
        if (localObject == null)
        {
          paramaqmi = localaqmp.a(localAIOFilePicData, 18);
          if (paramaqmi == null) {}
        }
        else
        {
          localObject = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = aywm.a;
          ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = aywm.a;
          ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
          ((URLDrawable.URLDrawableOptions)localObject).mUseExifOrientation = false;
          paramaqmi = URLDrawable.getDrawable(paramaqmi, (URLDrawable.URLDrawableOptions)localObject);
          paramaqmi.setTag(Integer.valueOf(1));
          paramaqmi.startDownload();
          this.jdField_a_of_type_Aqnh.a.put(Integer.valueOf(paramInt), paramaqmi);
          return null;
        }
        paramaqmi = localaqmp.a(localAIOFilePicData, 16);
        if (paramaqmi == null) {
          break;
        }
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = aywm.a;
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = aywm.a;
        URLDrawable.getDrawable(paramaqmi, (URLDrawable.URLDrawableOptions)localObject).startDownload();
      } while ((!bbfj.h(this.jdField_a_of_type_AndroidAppActivity)) || (localAIOFilePicData.jdField_e_of_type_Long > apei.c()));
      this.jdField_a_of_type_Aqnh.b(localAIOFilePicData.jdField_a_of_type_Long, localAIOFilePicData.jdField_a_of_type_Int, 18);
      return null;
    } while ((!bbfj.h(this.jdField_a_of_type_AndroidAppActivity)) || (localAIOFilePicData.jdField_e_of_type_Long > apei.c()));
    this.jdField_a_of_type_Aqnh.b(localAIOFilePicData.jdField_a_of_type_Long, localAIOFilePicData.jdField_a_of_type_Int, 18);
    aqmd.a().a().a("AIOGalleryFilePicView", 4, "onCreateView():Thumb and large pic is not exist, download it. Gallery position is " + paramInt);
    return null;
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    Object localObject1 = this.jdField_a_of_type_Aqnh.a();
    AIOFilePicData localAIOFilePicData;
    Object localObject2;
    if ((localObject1 != null) && (((aqmi)localObject1).jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData != null) && (((aqmi)localObject1).jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.a() == 3))
    {
      localAIOFilePicData = (AIOFilePicData)((aqmi)localObject1).jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData;
      aqmp localaqmp = new aqmp();
      localObject2 = localaqmp.a(localAIOFilePicData, 20);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = localaqmp.a(localAIOFilePicData, 18);
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = localaqmp.a(localAIOFilePicData, 16);
      }
      if ((localObject2 != null) || (!this.jdField_a_of_type_Aqmo.a())) {}
    }
    else
    {
      return;
    }
    a(localAIOFilePicData, (File)localObject2, paramInt);
  }
  
  public void a(int paramInt, View paramView, RegionDrawableData paramRegionDrawableData)
  {
    if ((paramView != null) && ((paramView.getTag() instanceof aqoy)))
    {
      paramView = ((aqoy)paramView.getTag()).jdField_a_of_type_ComTencentMobileqqGalleryViewGalleryUrlImageView.getDrawable();
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
    aqmi localaqmi = this.jdField_a_of_type_Aqnh.a(paramInt);
    Object localObject;
    AIOFilePicData localAIOFilePicData;
    if ((localaqmi != null) && (localaqmi.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData != null) && (localaqmi.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.a() == 3) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && ((paramView.getTag() instanceof aqoy)))
    {
      paramString1 = (aqoy)paramView.getTag();
      paramView = paramString1.jdField_a_of_type_ComTencentMobileqqGalleryViewGalleryUrlImageView;
      localObject = paramString1.jdField_a_of_type_AndroidWidgetTextView;
      localAIOFilePicData = (AIOFilePicData)localaqmi.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData;
      paramString1 = new aqmp();
      if (!localAIOFilePicData.jdField_d_of_type_Boolean) {
        break label393;
      }
      paramString1 = paramView.getDrawable();
      if (!URLDrawable.class.isInstance(paramString1)) {
        break label682;
      }
      paramString1 = (URLDrawable)paramString1;
      paramString2 = paramString1.getURL().getRef();
    }
    for (;;)
    {
      if ((paramString2 == null) && (apvd.b(localAIOFilePicData.jdField_b_of_type_JavaLangString)))
      {
        paramString1 = URLDrawable.URLDrawableOptions.obtain();
        paramString1.mLoadingDrawable = aywm.a;
        paramString1.mFailedDrawable = aywm.a;
        paramString1 = URLDrawable.getDrawable(new File(localAIOFilePicData.jdField_b_of_type_JavaLangString), paramString1);
        if (paramString1 != null)
        {
          paramView.setImageDrawable(paramString1);
          paramString1.downloadImediatly();
        }
      }
      label393:
      do
      {
        do
        {
          return;
        } while ((paramString1 != null) && (paramString2 != null) && (("PART".equals(paramString2)) || ("DISPLAY".equals(paramString2))));
        if ((apvm.a(localAIOFilePicData.jdField_g_of_type_Int, localAIOFilePicData.jdField_h_of_type_Int, localAIOFilePicData.jdField_e_of_type_Long)) || (localAIOFilePicData.i == 1))
        {
          paramView.setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(2130843447));
          paramString1 = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
          paramString1.width = actj.a(60.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
          paramString1.height = actj.a(60.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
          paramView.setLayoutParams(paramString1);
          ((TextView)localObject).setVisibility(0);
          ((TextView)localObject).setText(2131692524);
          paramView.setTag(2131296386, Float.valueOf(1.5F));
          this.jdField_a_of_type_Aqnh.q();
        }
        for (;;)
        {
          this.jdField_a_of_type_Aqnh.b(paramInt, false);
          this.jdField_a_of_type_Aqnh.a().d();
          return;
          paramView.setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(2130837911));
        }
        localObject = paramString1.a(localAIOFilePicData, 18);
      } while (localObject == null);
      paramString2 = paramString1.a(localAIOFilePicData, 18);
      paramString1 = paramString2;
      if (paramBoolean) {
        paramString1 = paramString2 + "#PART";
      }
      paramString2 = URLDrawable.URLDrawableOptions.obtain();
      paramString2.mUseExifOrientation = false;
      paramString2.mPlayGifImage = true;
      paramString2 = URLDrawable.getDrawable((File)localObject, paramString2);
      paramString2.setTag(Integer.valueOf(1));
      if (paramString2.getStatus() == 1) {
        if (localaqmi.jdField_a_of_type_Int != -2) {}
      }
      for (;;)
      {
        try
        {
          localaqmi.jdField_a_of_type_Int = JpegExifReader.readOrientation(((File)localObject).getAbsolutePath());
          paramView.setImageDrawable(paramString2);
          this.jdField_a_of_type_Aqnh.b(paramInt, true);
          paramView = this.jdField_a_of_type_Aqnh;
          aqnh.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, paramString2, localaqmi.jdField_a_of_type_Int);
          paramString2 = bbdx.b(localAIOFilePicData.jdField_c_of_type_JavaLangString);
          aqmd.a().a().a("AIOGalleryFilePicView", 4, "AIOGalleryAdapter.updateView(): Update large image, position=" + paramInt + "url = " + paramString1 + ",extName = " + paramString2);
          this.jdField_a_of_type_Aqnh.a().c();
          return;
        }
        catch (Exception localException)
        {
          aqmd.a().a().a("AIOGalleryFilePicView", 4, "read exif error" + localException.getMessage());
          localaqmi.jdField_a_of_type_Int = 1;
          continue;
        }
        paramString2.setTag(Integer.valueOf(1));
        paramString2.startDownload();
        paramView.setDecodingDrawble(paramString2);
      }
      label682:
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
    this.jdField_a_of_type_Bcvf.a(new aqov(this, paramAIOFilePicData, paramFile));
  }
  
  public void a(AIOFilePicData paramAIOFilePicData, File paramFile, int paramInt)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if (paramFile != null)
    {
      a(2131692907, 2130839638, 59, localArrayList1);
      if ((PicShareToWX.a().a()) && (PicShareToWX.a().a(paramFile))) {
        a(2131692917, 2130845906, 69, localArrayList1);
      }
      a(2131692916, 2130839647, 53, localArrayList1);
      axqy.b(null, "dc00898", "", "", "0X800A60D", "0X800A60D", 0, 0, "", "", "", "");
      a(2131692909, 2130843486, 67, localArrayList1);
      a(2131692918, 2130839648, 58, localArrayList1);
      a(2131692906, 2130839637, 57, localArrayList1);
      if ((this.jdField_a_of_type_Aqmo.g()) && (!TextUtils.isEmpty(this.jdField_a_of_type_Aqmo.c()))) {
        a(2131692920, 2130839649, 54, localArrayList2);
      }
      if (this.jdField_c_of_type_Boolean) {
        a(2131692912, 2130839642, 52, localArrayList2, 2);
      }
      ThreadManager.getFileThreadHandler().post(new AIOGalleryFilePicView.3(this, paramFile, localArrayList2));
    }
    for (;;)
    {
      a(paramAIOFilePicData, paramFile);
      paramAIOFilePicData = (List[])new ArrayList[] { localArrayList1, localArrayList2 };
      this.jdField_a_of_type_Bcvf.a(paramAIOFilePicData);
      this.jdField_a_of_type_Bcvf.a();
      return;
      if ((this.jdField_a_of_type_Aqmo.g()) && (!TextUtils.isEmpty(this.jdField_a_of_type_Aqmo.c()))) {
        a(2131692920, 2130839649, 54, localArrayList2);
      }
    }
  }
  
  public void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    super.a(paramAdapterView, paramView, paramInt, paramLong);
    if ((paramView != null) && ((paramView.getTag() instanceof aqoy)))
    {
      paramAdapterView = (aqoy)paramView.getTag();
      if (paramAdapterView.jdField_a_of_type_ComTencentMobileqqGalleryViewGalleryUrlImageView != null)
      {
        Object localObject = paramAdapterView.jdField_a_of_type_ComTencentMobileqqGalleryViewGalleryUrlImageView;
        paramView = ((GalleryUrlImageView)localObject).getDrawable();
        paramAdapterView = this.jdField_a_of_type_Aqnh.a();
        if ((!((GalleryUrlImageView)localObject).a()) && (paramAdapterView != null) && (paramAdapterView.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData != null) && (paramAdapterView.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.a() == 1))
        {
          localObject = (AIOFilePicData)paramAdapterView.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData;
          if (((paramView instanceof SkinnableBitmapDrawable)) && (((AIOFilePicData)localObject).jdField_b_of_type_Int == 1) && (((AIOFilePicData)localObject).jdField_c_of_type_Long > apei.c()) && (this.jdField_a_of_type_Aqnh.a() != null))
          {
            this.jdField_a_of_type_Aqnh.a().b(false);
            this.jdField_a_of_type_Aqnh.a().a(false);
          }
        }
        if ((paramAdapterView != null) && (paramAdapterView.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData != null) && ((paramAdapterView.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData instanceof AIOFilePicData)))
        {
          paramView = new aqmp();
          paramAdapterView = (AIOFilePicData)paramAdapterView.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData;
          if ((paramView.a(paramAdapterView, 20) == null) && (paramView.a(paramAdapterView, 18) == null) && (paramView.a(paramAdapterView, 16) == null) && ((apvm.a(paramAdapterView.jdField_g_of_type_Int, paramAdapterView.jdField_h_of_type_Int, paramAdapterView.jdField_e_of_type_Long)) || (paramAdapterView.i == 1))) {
            this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.q();
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
    return super.a();
  }
  
  public boolean a(aqmi paramaqmi)
  {
    return super.a(paramaqmi);
  }
  
  public void ak_()
  {
    this.jdField_a_of_type_Aqnh.aG_();
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
    this.jdField_a_of_type_Aqnh.j();
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
      localObject = this.jdField_a_of_type_Aqnh.a();
      if ((localObject != null) && (((aqmi)localObject).jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData != null) && (((aqmi)localObject).jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.a() == 3))
      {
        AIOFilePicData localAIOFilePicData = (AIOFilePicData)((aqmi)localObject).jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData;
        aqmp localaqmp = new aqmp();
        localObject = localaqmp.a(localAIOFilePicData, 20);
        if (localObject != null) {
          break label113;
        }
        localObject = localaqmp.a(localAIOFilePicData, 18);
      }
    }
    label113:
    for (;;)
    {
      if ((localObject == null) && (this.jdField_a_of_type_Aqmo.a())) {
        return false;
      }
      return (!this.jdField_a_of_type_Aqmo.a()) && (!this.jdField_a_of_type_Aqmo.c());
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
        v();
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
    if ((this.jdField_a_of_type_AndroidAppActivity.getIntent().getBooleanExtra("extra.FROM_AIO", false)) || (this.jdField_a_of_type_Aqmo.c() == 3) || (this.jdField_a_of_type_Aqmo.c() == 2)) {}
    for (int i = 1;; i = 0)
    {
      Bundle localBundle = this.jdField_a_of_type_AndroidAppActivity.getIntent().getExtras();
      if (((i == 0) && ((this.jdField_a_of_type_Aqmo.c() != 4) || (!localBundle.getBoolean("key_allow_forward_photo_preview_edit", false)))) || (akpx.a(this.jdField_a_of_type_Aqmo.a()) == 1032) || (this.jdField_a_of_type_Aqmo.a() == 1037) || (this.jdField_a_of_type_Aqmo.a() == 1044)) {
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
    Object localObject = this.jdField_a_of_type_Aqnh.a();
    AIOFilePicData localAIOFilePicData;
    if ((localObject != null) && (((aqmi)localObject).jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData != null) && (((aqmi)localObject).jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.a() == 3)) {
      localAIOFilePicData = (AIOFilePicData)((aqmi)localObject).jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData;
    }
    switch (localAIOFilePicData.jdField_e_of_type_Int)
    {
    default: 
      aqmd.a().a().a("AIOGalleryFilePicView", 4, "updateUI status is error, status = " + localAIOFilePicData.jdField_e_of_type_Int);
      return;
    case 1: 
      e(false);
      a(false);
      f(false);
      b(false);
      this.jdField_a_of_type_Aqnh.a(this.jdField_a_of_type_Aqnh.c(), localAIOFilePicData.f);
      return;
    case 2: 
      this.jdField_a_of_type_Aqnh.b(this.jdField_a_of_type_Aqnh.c(), true);
      e(false);
      a(false);
      f(false);
      b(false);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(ajya.a(2131700061) + localAIOFilePicData.f / 100 + "%");
      this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(localAIOFilePicData.f / 100);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      return;
    }
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    a(d());
    b(a((aqmi)localObject));
    boolean bool;
    if (!apvd.b(localAIOFilePicData.jdField_d_of_type_JavaLangString))
    {
      bool = true;
      e(bool);
      f(true);
      localObject = new aqmp();
      if (localAIOFilePicData.jdField_e_of_type_Long <= 10485760L) {
        break label342;
      }
      g(false);
    }
    for (;;)
    {
      this.jdField_a_of_type_Aqnh.b(this.jdField_a_of_type_Aqnh.c(), true);
      return;
      bool = false;
      break;
      label342:
      if ((((aqmp)localObject).a(localAIOFilePicData, 18) != null) || (((aqmp)localObject).a(localAIOFilePicData, 20) != null)) {
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
    case 2131369803: 
    case 2131364271: 
      do
      {
        do
        {
          return;
          paramView = this.jdField_a_of_type_Aqnh.a();
        } while ((paramView == null) || (paramView.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData == null) || (paramView.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.a() != 3));
        this.jdField_a_of_type_Aqnh.j();
        return;
        paramView = this.jdField_a_of_type_Aqnh.a();
      } while ((paramView == null) || (paramView.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData == null));
      this.jdField_a_of_type_Aqnh.c(paramView.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.jdField_a_of_type_Long, paramView.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.jdField_a_of_type_Int, 20);
      this.jdField_a_of_type_Aqnh.a(paramView.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.jdField_a_of_type_Long, paramView.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.jdField_a_of_type_Int, 0);
      j();
      return;
    case 2131373027: 
      t();
      return;
    case 2131373024: 
      u();
      this.jdField_a_of_type_Aqnh.aH_();
      return;
    case 2131373022: 
      l();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryFilePicView", 0, "onClick qq_gallery_danmaku_view ");
    }
    paramView = this.jdField_a_of_type_Aqnh.a();
    if ((paramView != null) && (paramView.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData != null)) {
      MiniChatActivity.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Aqmo.a(), this.jdField_a_of_type_Aqmo.a(), false, 26, paramView.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.d, 0L);
    }
    this.jdField_a_of_type_Aqnh.r();
  }
  
  public void s()
  {
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout == null)
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131559078, null));
      this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131375568));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131372023));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131364271));
      this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131375781));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131365891));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131369505));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131373024));
      this.jdField_c_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131373027));
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
      f(e());
      this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131373020));
      if (this.jdField_a_of_type_AndroidWidgetImageButton != null) {
        this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      }
      this.jdField_b_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131373022));
      if (this.jdField_b_of_type_AndroidWidgetImageButton != null) {
        this.jdField_b_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      }
    }
    if (!this.jdField_b_of_type_Boolean) {
      d(true);
    }
  }
  
  public void t()
  {
    Object localObject = this.jdField_a_of_type_Aqnh.a();
    if ((localObject != null) && (((aqmi)localObject).jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData != null) && (((aqmi)localObject).jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.a() == 3) && (this.jdField_a_of_type_Aqnh.e()))
    {
      if (!bbfj.d(this.jdField_a_of_type_AndroidAppActivity))
      {
        bcql.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131693945), 0).a();
        j();
      }
    }
    else {
      return;
    }
    localObject = (AIOFilePicData)((aqmi)localObject).jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData;
    if (((AIOFilePicData)localObject).jdField_g_of_type_Boolean)
    {
      bcql.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131692857), 0).a();
      j();
      return;
    }
    if (((AIOFilePicData)localObject).jdField_h_of_type_Boolean) {
      j();
    }
    long l = apei.a();
    if ((((AIOFilePicData)localObject).jdField_e_of_type_Long > l) && (apug.a())) {
      try
      {
        apug.a(false, this.jdField_a_of_type_AndroidAppActivity, new aqou(this, (AIOFilePicData)localObject));
        return;
      }
      catch (Throwable localThrowable)
      {
        aqmd.a().a().a("AIOGalleryFilePicView", 4, "showFlowDialog throwable = " + localThrowable.getMessage());
        return;
      }
    }
    this.jdField_a_of_type_Aqnh.a(localThrowable.jdField_a_of_type_Long, localThrowable.jdField_a_of_type_Int, 2);
    this.jdField_a_of_type_Aqnh.b(localThrowable.jdField_a_of_type_Long, localThrowable.jdField_a_of_type_Int, 20);
    if (this.jdField_a_of_type_Aqnh.a() != null)
    {
      this.jdField_a_of_type_Aqnh.a().b(true);
      this.jdField_a_of_type_Aqnh.a().a(true);
    }
    j();
  }
  
  void u()
  {
    Object localObject1 = this.jdField_a_of_type_Aqnh.a();
    AIOFilePicData localAIOFilePicData;
    Object localObject2;
    if ((localObject1 != null) && (((aqmi)localObject1).jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData != null) && (((aqmi)localObject1).jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.a() == 3))
    {
      localAIOFilePicData = (AIOFilePicData)((aqmi)localObject1).jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData;
      aqmp localaqmp = new aqmp();
      localObject2 = localaqmp.a(localAIOFilePicData, 20);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = localaqmp.a(localAIOFilePicData, 18);
      }
      if (localObject1 != null) {
        break label516;
      }
      localObject1 = localaqmp.a(localAIOFilePicData, 16);
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
      switch (this.jdField_a_of_type_Aqmo.c())
      {
      default: 
        j = 0;
        bool = false;
        k = 0;
        localObject1 = EditPicActivity.a(this.jdField_a_of_type_AndroidAppActivity, ((File)localObject1).getAbsolutePath(), true, true, true, true, true, 2, i, 7);
        ((Intent)localObject1).putExtra("uintype", this.jdField_a_of_type_Aqmo.a());
        ((Intent)localObject1).putExtra("open_chatfragment", true);
        ((Intent)localObject1).putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1041);
        ((Intent)localObject1).putExtra("key_enable_edit_title_bar", true);
        if (bool) {
          ((Intent)localObject1).putExtra("key_help_forward_pic", bool);
        }
        if (j != 0) {
          ((Intent)localObject1).putExtra("key_allow_multiple_forward_from_limit", false);
        }
        if (this.jdField_a_of_type_Aqnh.e())
        {
          localObject2 = this.jdField_a_of_type_Aqnh.a(localAIOFilePicData.jdField_a_of_type_Long, localAIOFilePicData.jdField_a_of_type_Int, this.jdField_a_of_type_Aqmo.a());
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
        axqy.b(null, "dc00898", "", "", "0X8007ACE", "0X8007ACE", 0, 0, "", "", "", "");
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
 * Qualified Name:     aqot
 * JD-Core Version:    0.7.0.1
 */