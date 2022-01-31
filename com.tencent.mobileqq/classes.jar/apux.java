import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
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
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
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
import com.tencent.mobileqq.gallery.model.GalleryBaseData;
import com.tencent.mobileqq.gallery.model.pic.AIOPicData;
import com.tencent.mobileqq.gallery.presenter.AIOGalleryBasePresenter;
import com.tencent.mobileqq.gallery.view.GalleryUrlImageView;
import com.tencent.mobileqq.gallery.view.pic.AIOGalleryPicView.2;
import com.tencent.mobileqq.gallery.view.pic.AIOGalleryPicView.6;
import com.tencent.mobileqq.pic.PicShareToWX;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
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

public class apux
  extends apue
  implements View.OnClickListener, begz
{
  public long a;
  MessageQueue.IdleHandler jdField_a_of_type_AndroidOsMessageQueue$IdleHandler = new apvh(this);
  public ImageView a;
  public LinearLayout a;
  public SeekBar a;
  public TextView a;
  public apti a;
  public apvj a;
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  public String a;
  public ArrayList<String> a;
  public ImageView b;
  public TextView b;
  public String b;
  public ImageButton c;
  public RelativeLayout c;
  public TextView c;
  public boolean c;
  public int d;
  public boolean d;
  private int e;
  public boolean e;
  
  public apux(Activity paramActivity, apti paramapti)
  {
    super(paramActivity, paramapti);
    this.jdField_e_of_type_Int = -1;
    this.jdField_d_of_type_Int = 1;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Apti = paramapti;
  }
  
  private void a(long paramLong, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Apti.b(paramLong, paramInt1, paramInt2);
    this.jdField_a_of_type_Apti.a(paramLong, paramInt1, 1);
  }
  
  private void a(Uri paramUri, ArrayList<bahx> paramArrayList)
  {
    if ((this.jdField_a_of_type_AndroidAppActivity == null) || (this.jdField_a_of_type_AndroidAppActivity.isFinishing()) || (this.jdField_a_of_type_Apti.a() == null)) {
      return;
    }
    Object localObject3 = this.jdField_a_of_type_Apti.a().getSelectedView();
    SparseArray localSparseArray = new SparseArray(2);
    Object localObject1 = null;
    int j;
    int i;
    label119:
    Matrix localMatrix;
    if ((localObject3 != null) && ((((View)localObject3).getTag() instanceof apvi)))
    {
      localObject1 = ((apvi)((View)localObject3).getTag()).a;
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
        localMatrix.set(this.jdField_a_of_type_Apti.a().a((View)localObject3));
        localObject3 = new Rect(((View)localObject3).getLeft(), ((View)localObject3).getTop(), ((View)localObject3).getRight(), ((View)localObject3).getBottom());
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = ((GalleryUrlImageView)localObject1).a((Rect)localObject3, localMatrix, this.jdField_a_of_type_Apti.a().getWidth(), this.jdField_a_of_type_Apti.a().getHeight());
        if (localObject1 == null) {
          break label400;
        }
        i = vup.a((Bitmap)localObject1, true, 3, localSparseArray) | 0x0;
        apsm.a().a().a("AIOGalleryPicView", 4, String.format("checkQQCode bmp!=null result=%d", new Object[] { Integer.valueOf(i) }));
        if (localObject1 == null)
        {
          i = vup.a(paramUri, this.jdField_a_of_type_AndroidAppActivity, 3, localSparseArray);
          apsm.a().a().a("AIOGalleryPicView", 4, String.format("checkQQCode bmp=null result=%d", new Object[] { Integer.valueOf(i) }));
        }
        ThreadManager.getUIHandler().post(new AIOGalleryPicView.6(this, i, localSparseArray, paramArrayList));
        if (i > 0) {
          this.jdField_a_of_type_JavaLangString = paramUri.getPath();
        }
        akvj.b(i);
        return;
      }
      catch (Throwable localThrowable)
      {
        label349:
        apsm.a().a().a("AIOGalleryPicView", 4, "checkQQCode exception :" + localThrowable.getMessage());
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
      paramURLDrawable.setTag(Integer.valueOf(1));
      this.jdField_a_of_type_Apti.a.put(Integer.valueOf(paramInt), paramURLDrawable);
      paramString = this.jdField_a_of_type_Apti;
      apti.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, paramURLDrawable, paramapsr.jdField_a_of_type_Int);
      this.jdField_a_of_type_Apti.b(paramInt, true);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        apsm.a().a().a("AIOGalleryPicView", 4, "read exif error" + paramString.getMessage());
        paramapsr.jdField_a_of_type_Int = 1;
      }
    }
  }
  
  private void a(AIOPicData paramAIOPicData, apsr paramapsr)
  {
    Object localObject = new apsz();
    File localFile = ((apsz)localObject).a(paramAIOPicData, 4);
    if (localFile == null) {
      localFile = ((apsz)localObject).a(paramAIOPicData, 2);
    }
    for (;;)
    {
      if ((localFile == null) && (this.jdField_a_of_type_Apsx.a())) {
        return;
      }
      if (localFile != null) {
        this.jdField_b_of_type_JavaLangString = localFile.getPath();
      }
      localObject = begr.c(this.jdField_a_of_type_AndroidAppActivity);
      if ((!a((begr)localObject, paramAIOPicData)) && (akbm.a(this.jdField_a_of_type_Apsx.a()) != 1032))
      {
        localObject = new ArrayList();
        ArrayList localArrayList = new ArrayList();
        if (localFile != null)
        {
          if (this.jdField_d_of_type_Boolean)
          {
            a(2131627265, 2130839586, 48, (ArrayList)localObject);
            VasWebviewUtil.reportCommercialDrainage("", "QLbq", "ClickMore", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
          }
          if ((this.jdField_a_of_type_Apsx.a() != 1037) && (this.jdField_a_of_type_Apsx.a() != 1044)) {
            a(2131627268, 2130839591, 49, (ArrayList)localObject);
          }
          if ((PicShareToWX.a().a()) && (PicShareToWX.a().a(localFile))) {
            a(2131627278, 2130845718, 69, (ArrayList)localObject);
          }
          if (!aqcb.a().a()) {
            a(2131627277, 2130839599, 53, (ArrayList)localObject);
          }
          if (!this.jdField_d_of_type_Boolean) {
            a(2131627267, 2130839590, 57, (ArrayList)localObject);
          }
          if ((this.jdField_a_of_type_Apsx.a() != 1037) && (this.jdField_a_of_type_Apsx.a() != 1044))
          {
            if (paramAIOPicData.jdField_e_of_type_JavaLangString != null) {
              a(2131627272, 2130839594, 50, (ArrayList)localObject);
            }
            if ((this.jdField_c_of_type_Boolean) && (paramAIOPicData.jdField_e_of_type_JavaLangString != null)) {
              a(2131627269, 2130839592, 51, (ArrayList)localObject);
            }
          }
          a(2131627279, 2130839600, 58, (ArrayList)localObject);
          if ((this.jdField_a_of_type_Apsx.a() != 1037) && (this.jdField_a_of_type_Apsx.a() != 1044))
          {
            if ((this.jdField_a_of_type_Apsx.g()) && (!TextUtils.isEmpty(this.jdField_a_of_type_Apsx.c())) && (!this.jdField_a_of_type_Apsx.c())) {
              a(2131627281, 2130839601, 54, localArrayList);
            }
            if (this.jdField_e_of_type_Boolean) {
              a(2131627273, 2130839595, 52, localArrayList);
            }
            ThreadManager.getFileThreadHandler().post(new AIOGalleryPicView.2(this, localFile, localArrayList));
          }
        }
        for (;;)
        {
          if ((paramAIOPicData.jdField_g_of_type_Int == 4) && (!paramAIOPicData.l)) {
            a(2131627751, 2130845579, 66, (ArrayList)localObject);
          }
          a(paramAIOPicData, paramapsr, localFile);
          paramAIOPicData = (List[])new ArrayList[] { localObject, localArrayList };
          this.jdField_a_of_type_Bahv.a(paramAIOPicData);
          this.jdField_a_of_type_Bahv.a();
          return;
          if ((!this.jdField_a_of_type_Apsx.c()) && (this.jdField_a_of_type_Apsx.a() != 1037) && (this.jdField_a_of_type_Apsx.g()) && (!TextUtils.isEmpty(this.jdField_a_of_type_Apsx.c())) && (this.jdField_a_of_type_Apsx.a() != 1044)) {
            a(2131627281, 2130839601, 54, localArrayList);
          }
        }
      }
      if ((akbm.a(this.jdField_a_of_type_Apsx.a()) == 1032) && (localFile != null)) {
        ((begr)localObject).b(2131627752);
      }
      ((begr)localObject).c(2131627266);
      ((begr)localObject).a(new apva(this, (begr)localObject, paramAIOPicData, localFile));
      ((begr)localObject).show();
      ((begr)localObject).a(this);
      return;
    }
  }
  
  private boolean a(AIOPicData paramAIOPicData, GalleryUrlImageView paramGalleryUrlImageView)
  {
    apsm.a().a().a("AIOGalleryPicView", 4, "dealTempImage()");
    apsz localapsz = new apsz();
    if (localapsz.a(paramAIOPicData, 8) != null)
    {
      Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = axwd.a;
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = axwd.a;
      ((URLDrawable.URLDrawableOptions)localObject2).mUseExifOrientation = false;
      if ((paramAIOPicData.jdField_d_of_type_Int == 1) && ((paramAIOPicData.jdField_f_of_type_Int & 0x2) == 2)) {
        ((URLDrawable.URLDrawableOptions)localObject2).mUseAutoScaleParams = false;
      }
      Object localObject1 = null;
      try
      {
        localObject2 = URLDrawable.getDrawable(localapsz.a(paramAIOPicData, 8), (URLDrawable.URLDrawableOptions)localObject2);
        localObject1 = localObject2;
        ((URLDrawable)localObject2).downloadImediatly();
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          apsm.a().a().a("AIOGalleryPicView", 4, "dealTempImage() exception = " + localException.getMessage());
        }
        apsm.a().a().a("AIOGalleryPicView", 4, "getView(): url is " + localapsz.a(paramAIOPicData, 8) + ", file type is " + 8);
      }
      if ((localObject1 != null) && (localObject1.getStatus() == 1))
      {
        localObject1.setTag(Integer.valueOf(1));
        paramGalleryUrlImageView.setImageDrawable(localObject1);
        apsm.a().a().a("AIOGalleryPicView", 4, "set temp image");
        return true;
      }
    }
    return false;
  }
  
  private boolean a(GalleryUrlImageView paramGalleryUrlImageView)
  {
    apsm.a().a().a("AIOGalleryPicView", 4, "dealDefaultImage()");
    paramGalleryUrlImageView.setImageDrawable(axwd.a);
    return true;
  }
  
  private boolean b(AIOPicData paramAIOPicData, GalleryUrlImageView paramGalleryUrlImageView)
  {
    apsm.a().a().a("AIOGalleryPicView", 4, "dealThumbImage()");
    Object localObject2 = new apsz();
    if (((apsz)localObject2).a(paramAIOPicData, 1) != null)
    {
      Object localObject1 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = axwd.a;
      ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = axwd.a;
      if ((paramAIOPicData.jdField_d_of_type_Int == 1) && ((paramAIOPicData.jdField_f_of_type_Int & 0x2) == 2)) {
        ((URLDrawable.URLDrawableOptions)localObject1).mUseAutoScaleParams = false;
      }
      localObject2 = ((apsz)localObject2).a(paramAIOPicData, 1);
      paramAIOPicData = null;
      try
      {
        localObject1 = URLDrawable.getDrawable((File)localObject2, (URLDrawable.URLDrawableOptions)localObject1);
        paramAIOPicData = (AIOPicData)localObject1;
        ((URLDrawable)localObject1).downloadImediatly();
        paramAIOPicData = (AIOPicData)localObject1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          apsm.a().a().a("AIOGalleryPicView", 4, "dealTempImage() exception = " + localException.getMessage());
        }
      }
      if ((paramAIOPicData != null) && (paramAIOPicData.getStatus() == 1))
      {
        paramAIOPicData.setTag(Integer.valueOf(1));
        paramGalleryUrlImageView.setImageDrawable(paramAIOPicData);
        apsm.a().a().a("AIOGalleryPicView", 4, "set thumb image");
        return true;
      }
    }
    return false;
  }
  
  private boolean c(AIOPicData paramAIOPicData, GalleryUrlImageView paramGalleryUrlImageView)
  {
    boolean bool = false;
    apsm.a().a().a("AIOGalleryPicView", 4, "dealErrorImage()");
    if ((paramAIOPicData.jdField_f_of_type_Boolean) || (paramAIOPicData.jdField_e_of_type_Boolean) || (paramAIOPicData.jdField_d_of_type_Boolean))
    {
      paramGalleryUrlImageView.setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(2130837854));
      this.jdField_a_of_type_Apti.b(this.jdField_a_of_type_Apti.c(), false);
      bool = true;
    }
    return bool;
  }
  
  private void u()
  {
    Object localObject = this.jdField_a_of_type_Apti.a();
    if ((localObject != null) && (((apsr)localObject).jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData != null) && (((apsr)localObject).jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.a() == 1))
    {
      localObject = (AIOPicData)((apsr)localObject).jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData;
      if (new apsz().a((AIOPicData)localObject, 4))
      {
        if (((AIOPicData)localObject).jdField_c_of_type_Long <= 0L) {
          break label97;
        }
        a(String.format(Locale.CHINA, this.jdField_a_of_type_AndroidAppActivity.getString(2131629660), new Object[] { apdh.a(((AIOPicData)localObject).jdField_c_of_type_Long) }));
      }
    }
    return;
    label97:
    a(this.jdField_a_of_type_AndroidAppActivity.getString(2131629657));
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    GalleryUrlImageView localGalleryUrlImageView;
    if (((paramView instanceof RelativeLayout)) && ((paramView.getTag() instanceof apvi)))
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView);
      localGalleryUrlImageView = ((apvi)paramView.getTag()).a;
    }
    apsr localapsr;
    for (;;)
    {
      r();
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      localapsr = this.jdField_a_of_type_Apti.a(paramInt);
      if ((localapsr != null) && (localapsr.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData != null)) {
        break;
      }
      return localGalleryUrlImageView;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidAppActivity);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(new Gallery.LayoutParams(-1, -1));
      localGalleryUrlImageView = new GalleryUrlImageView(this.jdField_a_of_type_AndroidAppActivity);
      localGalleryUrlImageView.setId(2131302158);
      localGalleryUrlImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      paramView = new RelativeLayout.LayoutParams(-1, -1);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localGalleryUrlImageView, paramView);
    }
    AIOPicData localAIOPicData;
    Object localObject2;
    if (localapsr.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.a() == 1)
    {
      localAIOPicData = (AIOPicData)localapsr.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData;
      localObject2 = new apsz();
      paramView = this.jdField_a_of_type_Apti.b();
      if ((paramView == null) || (paramView.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData == null) || (paramView.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.a() != 1) || (paramView.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.jdField_a_of_type_Long != localapsr.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.jdField_a_of_type_Long) || (paramView.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.jdField_a_of_type_Int != localapsr.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.jdField_a_of_type_Int) || (paramView.jdField_c_of_type_Boolean)) {
        break label761;
      }
      awqx.b(null, "dc00898", "", "", "0X8009EEF", "0X8009EEF", 1, 0, "", "", "", "");
      paramView.jdField_c_of_type_Boolean = true;
    }
    boolean bool2;
    boolean bool1;
    Object localObject1;
    for (;;)
    {
      localGalleryUrlImageView.setPosition(paramInt);
      localGalleryUrlImageView.setImageInfo(localapsr);
      localGalleryUrlImageView.setIgnoreLayout(false);
      bool2 = false;
      bool1 = false;
      localObject1 = null;
      paramView = null;
      paramViewGroup = (URLDrawable)this.jdField_a_of_type_Apti.a.get(Integer.valueOf(paramInt));
      if ((paramViewGroup != null) && (paramViewGroup.getStatus() == 1))
      {
        localGalleryUrlImageView.setImageDrawable(paramViewGroup);
        paramView = ((apsz)localObject2).a(localAIOPicData, 4);
        localObject1 = paramViewGroup.getURL().toString();
        if (((String)localObject1).equals(paramView)) {
          localGalleryUrlImageView.setOriginalImage(true);
        }
        if (localapsr.jdField_a_of_type_Int == -2) {}
        try
        {
          localapsr.jdField_a_of_type_Int = JpegExifReader.readOrientation(paramViewGroup.getURL().getFile());
          paramView = this.jdField_a_of_type_Apti;
          apti.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, paramViewGroup, localapsr.jdField_a_of_type_Int);
          if (localGalleryUrlImageView.a())
          {
            paramView = localAIOPicData.jdField_c_of_type_JavaLangString;
            paramView = bace.b(paramView);
            apsm.a().a().a("AIOGalleryPicView", 4, "getView(): cache url is " + (String)localObject1 + ", cache type is " + ((apsz)localObject2).a(localAIOPicData, paramViewGroup.getURL().getFile()) + ",extName = + " + paramView);
            if (localAIOPicData.jdField_g_of_type_Boolean) {
              this.jdField_a_of_type_Apti.b(localAIOPicData.jdField_a_of_type_Long, localAIOPicData.jdField_a_of_type_Int, 2);
            }
            bool1 = true;
            if (!localGalleryUrlImageView.a()) {
              break label853;
            }
            paramView = "original";
            paramInt = 1;
            if (paramInt != 0)
            {
              paramInt = localapsr.hashCode();
              this.jdField_a_of_type_Apti.a(paramInt);
              paramViewGroup = this.jdField_a_of_type_Apti.a();
              paramViewGroup.a(paramInt);
              paramViewGroup.a(paramInt, localAIOPicData.jdField_e_of_type_Long, localAIOPicData.jdField_f_of_type_Long);
              paramViewGroup.b(paramInt, bfcq.a(localAIOPicData.jdField_c_of_type_Int));
              if (localAIOPicData.jdField_h_of_type_Boolean) {
                paramViewGroup.d(paramInt);
              }
              if (paramView != null)
              {
                paramViewGroup.a(paramInt, paramView);
                paramViewGroup.a(paramInt, bool1);
              }
            }
            paramView = localAIOPicData.jdField_a_of_type_Long + "_" + localAIOPicData.jdField_a_of_type_Int;
            if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramView))
            {
              this.jdField_a_of_type_Apti.a(localAIOPicData.jdField_a_of_type_Long, localAIOPicData.jdField_a_of_type_Int);
              this.jdField_a_of_type_JavaUtilArrayList.add(paramView);
            }
            paramView = new apvi(this);
            paramView.a = localGalleryUrlImageView;
            this.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(paramView);
            return this.jdField_a_of_type_AndroidWidgetRelativeLayout;
            label761:
            awqx.b(null, "dc00898", "", "", "0X8009EEF", "0X8009EEF", 2, 0, "", "", "", "");
          }
        }
        catch (Exception paramView)
        {
          for (;;)
          {
            apsm.a().a().a("AIOGalleryPicView", 4, "read exif error" + paramView.getMessage());
            localapsr.jdField_a_of_type_Int = 0;
            continue;
            paramView = localAIOPicData.jdField_b_of_type_JavaLangString;
            continue;
            label853:
            paramView = "large";
          }
        }
      }
    }
    Object localObject3 = ((apsz)localObject2).a(localAIOPicData, 4);
    int i;
    if (localObject3 != null)
    {
      if (localObject3 != null)
      {
        i = 1;
        label883:
        paramViewGroup = URLDrawable.URLDrawableOptions.obtain();
        paramViewGroup.mRequestWidth = this.jdField_a_of_type_Int;
        paramViewGroup.mRequestHeight = this.jdField_b_of_type_Int;
        if (((apsz)localObject2).a(localAIOPicData, 1) == null) {
          break label1100;
        }
        paramView = URLDrawable.getFileDrawable(localAIOPicData.jdField_a_of_type_JavaLangString, null);
        paramView.downloadImediatly();
        paramViewGroup.mLoadingDrawable = paramView;
        label933:
        paramViewGroup.mPlayGifImage = true;
        paramViewGroup.mUseExifOrientation = false;
        paramViewGroup.mDecodeFileStrategy = 2;
        if ((localAIOPicData.jdField_d_of_type_Int == 1) && ((localAIOPicData.jdField_f_of_type_Int & 0x2) == 2)) {
          paramViewGroup.mUseAutoScaleParams = false;
        }
        paramView = null;
        localObject1 = ((apsz)localObject2).a(localAIOPicData, 4);
      }
      try
      {
        paramViewGroup = URLDrawable.getDrawable((String)localObject1, paramViewGroup);
        paramView = paramViewGroup;
      }
      catch (Throwable paramViewGroup)
      {
        for (;;)
        {
          apsm.a().a().a("AIOGalleryPicView", 4, "[getView] URLDrawable.getDrawable failed.");
          continue;
          if (paramView.getStatus() == 1)
          {
            a(localapsr, paramViewGroup, paramView, paramInt);
            continue;
            bool1 = false;
            continue;
            paramView = "large";
          }
        }
      }
      paramViewGroup = ((File)localObject3).getAbsolutePath();
      localGalleryUrlImageView.setGalleryImageListener(new apuz(this, localapsr, paramViewGroup, paramView, localAIOPicData, localGalleryUrlImageView));
      if ((paramView.getStatus() == 0) || (paramView.getStatus() == 4))
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        localGalleryUrlImageView.setImageDrawable(paramView);
        if ((paramView == null) || (!paramView.isDownloadStarted())) {
          break label1860;
        }
        if (BaseApplicationImpl.sImageCache.get(paramView.getURL().toString()) == null) {
          break label1151;
        }
        bool1 = true;
        if (i == 0) {
          break label1157;
        }
        paramView = "original";
      }
    }
    for (;;)
    {
      for (;;)
      {
        paramInt = 1;
        break;
        i = 0;
        break label883;
        label1100:
        paramViewGroup.mLoadingDrawable = axwd.a;
        break label933;
        label1151:
        File localFile = ((apsz)localObject2).a(localAIOPicData, 2);
        label1157:
        if (localFile != null)
        {
          if (localObject3 != null)
          {
            i = 1;
            label1187:
            localObject3 = URLDrawable.URLDrawableOptions.obtain();
            ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = this.jdField_a_of_type_Int;
            ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = this.jdField_b_of_type_Int;
            ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = axwd.a;
            ((URLDrawable.URLDrawableOptions)localObject3).mPlayGifImage = true;
            ((URLDrawable.URLDrawableOptions)localObject3).mUseExifOrientation = false;
            ((URLDrawable.URLDrawableOptions)localObject3).mDecodeFileStrategy = 2;
            if ((localAIOPicData.jdField_d_of_type_Int == 1) && ((localAIOPicData.jdField_f_of_type_Int & 0x2) == 2)) {
              ((URLDrawable.URLDrawableOptions)localObject3).mUseAutoScaleParams = false;
            }
            paramViewGroup = null;
            if (i == 0) {
              break label1450;
            }
            paramView = ((apsz)localObject2).a(localAIOPicData, 4);
          }
          try
          {
            paramView = URLDrawable.getDrawable(paramView, (URLDrawable.URLDrawableOptions)localObject3);
            paramViewGroup = paramView;
            paramView.downloadImediatly();
            paramViewGroup = paramView;
            paramView = (View)localObject1;
            bool1 = bool2;
            if (paramViewGroup != null)
            {
              paramView = (View)localObject1;
              bool1 = bool2;
              if (paramViewGroup.isDownloadStarted())
              {
                if (BaseApplicationImpl.sImageCache.get(paramViewGroup.getURL().toString()) == null) {
                  break label1517;
                }
                bool1 = true;
                if (i == 0) {
                  break label1523;
                }
                paramView = "original";
              }
            }
            if ((paramViewGroup != null) && (paramViewGroup.getStatus() == 1)) {
              if (localapsr.jdField_a_of_type_Int != -2) {}
            }
          }
          catch (Throwable paramView)
          {
            for (;;)
            {
              try
              {
                localapsr.jdField_a_of_type_Int = JpegExifReader.readOrientation(localFile.getAbsolutePath());
                paramViewGroup.setTag(Integer.valueOf(1));
                this.jdField_a_of_type_Apti.a.put(Integer.valueOf(paramInt), paramViewGroup);
                localObject1 = this.jdField_a_of_type_Apti;
                apti.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, paramViewGroup, localapsr.jdField_a_of_type_Int);
                localGalleryUrlImageView.setImageDrawable(paramViewGroup);
                this.jdField_a_of_type_Apti.b(paramInt, true);
                paramInt = 1;
                break;
                i = 0;
                break label1187;
                label1450:
                localObject2 = ((apsz)localObject2).a(localAIOPicData, 2);
                paramView = (View)localObject2;
                if (!localAIOPicData.jdField_g_of_type_Boolean) {
                  continue;
                }
                paramView = (String)localObject2 + "#PART";
                continue;
                paramView = paramView;
                apsm.a().a().a("AIOGalleryPicView", 4, "[getView] URLDrawable.getDrawable failed.");
                continue;
                label1517:
                bool1 = false;
                continue;
                label1523:
                paramView = "large";
              }
              catch (Exception localException)
              {
                apsm.a().a().a("AIOGalleryPicView", 4, "read exif error" + localException.getMessage());
                localapsr.jdField_a_of_type_Int = 1;
                continue;
              }
              if ((!a(localAIOPicData, localGalleryUrlImageView)) && (!b(localAIOPicData, localGalleryUrlImageView)) && (!c(localAIOPicData, localGalleryUrlImageView))) {
                a(localGalleryUrlImageView);
              }
              a(localAIOPicData.jdField_a_of_type_Long, localAIOPicData.jdField_a_of_type_Int, 2);
            }
          }
        }
      }
      if (((apsz)localObject2).a(localAIOPicData, 8) != null)
      {
        if ((!a(localAIOPicData, localGalleryUrlImageView)) && (!b(localAIOPicData, localGalleryUrlImageView)) && (!c(localAIOPicData, localGalleryUrlImageView))) {
          a(localGalleryUrlImageView);
        }
        a(localAIOPicData.jdField_a_of_type_Long, localAIOPicData.jdField_a_of_type_Int, 2);
        paramInt = 1;
        break;
      }
      if (((apsz)localObject2).a(localAIOPicData, 1) != null)
      {
        if ((!b(localAIOPicData, localGalleryUrlImageView)) && (!c(localAIOPicData, localGalleryUrlImageView))) {
          a(localGalleryUrlImageView);
        }
        a(localAIOPicData.jdField_a_of_type_Long, localAIOPicData.jdField_a_of_type_Int, 2);
        paramInt = 1;
        break;
      }
      if ((localAIOPicData.jdField_f_of_type_Boolean) || (localAIOPicData.jdField_e_of_type_Boolean) || (localAIOPicData.jdField_d_of_type_Boolean))
      {
        if (c(localAIOPicData, localGalleryUrlImageView)) {
          break label1855;
        }
        a(localGalleryUrlImageView);
        paramInt = 0;
        break;
      }
      apsm.a().a().a("AIOGalleryPicView", 4, "getView(): No pic");
      a(localGalleryUrlImageView);
      a(localAIOPicData.jdField_a_of_type_Long, localAIOPicData.jdField_a_of_type_Int, 2);
      label1855:
      paramInt = 0;
      break;
      label1860:
      paramView = null;
      bool1 = false;
    }
  }
  
  public View a(int paramInt, apsr paramapsr)
  {
    Object localObject = (URLDrawable)this.jdField_a_of_type_Apti.a.get(Integer.valueOf(paramInt));
    if (localObject != null) {
      if (((URLDrawable)localObject).getStatus() == 3) {
        ((URLDrawable)localObject).restartDownload();
      }
    }
    while ((paramapsr == null) || (paramapsr.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData == null) || (paramapsr.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.a() != 1)) {
      return null;
    }
    AIOPicData localAIOPicData = (AIOPicData)paramapsr.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData;
    apsz localapsz = new apsz();
    localObject = localapsz.a(localAIOPicData, 4);
    if (localObject == null)
    {
      paramapsr = localapsz.a(localAIOPicData, 2);
      if (paramapsr == null) {}
    }
    for (;;)
    {
      int i;
      if (localObject != null)
      {
        i = 1;
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = axwd.a;
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = axwd.a;
        ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
        ((URLDrawable.URLDrawableOptions)localObject).mUseExifOrientation = false;
        if ((localAIOPicData.jdField_d_of_type_Int == 1) && ((localAIOPicData.jdField_f_of_type_Int & 0x2) == 2)) {
          ((URLDrawable.URLDrawableOptions)localObject).mUseAutoScaleParams = false;
        }
        if ((i != 0) || (!localAIOPicData.jdField_g_of_type_Boolean)) {
          break label260;
        }
      }
      label260:
      for (paramapsr = URLDrawable.getDrawable(localapsz.a(localAIOPicData, 2) + "#" + "PART", (URLDrawable.URLDrawableOptions)localObject);; paramapsr = URLDrawable.getDrawable(paramapsr, (URLDrawable.URLDrawableOptions)localObject))
      {
        paramapsr.setTag(Integer.valueOf(1));
        paramapsr.startDownload();
        this.jdField_a_of_type_Apti.a.put(Integer.valueOf(paramInt), paramapsr);
        return null;
        i = 0;
        break;
      }
      if ((localAIOPicData.jdField_f_of_type_Boolean) || (localAIOPicData.jdField_e_of_type_Boolean) || (localAIOPicData.jdField_d_of_type_Boolean)) {
        break;
      }
      if (localapsz.a(localAIOPicData, 1) != null)
      {
        paramapsr = URLDrawable.URLDrawableOptions.obtain();
        paramapsr.mLoadingDrawable = axwd.a;
        paramapsr.mFailedDrawable = axwd.a;
        if ((localAIOPicData.jdField_d_of_type_Int == 1) && ((localAIOPicData.jdField_f_of_type_Int & 0x2) == 2)) {
          paramapsr.mUseAutoScaleParams = false;
        }
        URLDrawable.getDrawable(localapsz.a(localAIOPicData, 1), paramapsr).startDownload();
        if ((!badq.h(this.jdField_a_of_type_AndroidAppActivity)) || (bfcq.a(localAIOPicData.jdField_c_of_type_Int))) {
          break;
        }
        this.jdField_a_of_type_Apti.b(localAIOPicData.jdField_a_of_type_Long, localAIOPicData.jdField_a_of_type_Int, 2);
        return null;
      }
      if ((!badq.h(this.jdField_a_of_type_AndroidAppActivity)) || (bfcq.a(localAIOPicData.jdField_c_of_type_Int))) {
        break;
      }
      this.jdField_a_of_type_Apti.b(localAIOPicData.jdField_a_of_type_Long, localAIOPicData.jdField_a_of_type_Int, 2);
      apsm.a().a().a("AIOGalleryPicView", 4, "onCreateView():Thumb and large pic is not exist, download it. Gallery position is " + paramInt);
      return null;
      paramapsr = (apsr)localObject;
    }
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    apsr localapsr = this.jdField_a_of_type_Apti.a();
    if ((localapsr != null) && (localapsr.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData != null) && (localapsr.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.a() == 1))
    {
      a((AIOPicData)localapsr.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData, localapsr);
      apsm.a().a().a("AIOGalleryPicView", 2, "showActionSheet, from:" + paramInt);
    }
  }
  
  public void a(int paramInt, Drawable paramDrawable, URLDrawable paramURLDrawable, GalleryUrlImageView paramGalleryUrlImageView)
  {
    if (((paramDrawable instanceof URLDrawable)) && (((URLDrawable)paramDrawable).isFakeSize()) && (paramURLDrawable == null))
    {
      paramDrawable = ((URLDrawable)paramDrawable).getURL();
      if (("file".equals(paramDrawable.getProtocol())) && (paramDrawable.getRef() == null))
      {
        if ((paramInt != this.jdField_e_of_type_Int) || (this.jdField_a_of_type_ComTencentImageURLDrawable == null)) {
          break label113;
        }
        paramDrawable = this.jdField_a_of_type_ComTencentImageURLDrawable;
        apsm.a().a().a("AIOGalleryPicView", 4, "use exist raw drawable");
      }
    }
    while (paramDrawable.getStatus() == 1)
    {
      paramGalleryUrlImageView.setIgnoreLayout(true);
      paramGalleryUrlImageView.setImageDrawable(paramDrawable);
      paramGalleryUrlImageView.setIgnoreLayout(false);
      return;
      label113:
      apsm.a().a().a("AIOGalleryPicView", 4, "rawDrawable is exist");
      paramDrawable = paramDrawable.toString() + "#" + "NOSAMPLE";
      paramURLDrawable = URLDrawable.URLDrawableOptions.obtain();
      paramURLDrawable.mUseExifOrientation = false;
      paramURLDrawable.mUseMemoryCache = false;
      paramDrawable = URLDrawable.getDrawable(paramDrawable, paramURLDrawable);
      paramDrawable.setTag(Integer.valueOf(2));
      this.jdField_a_of_type_ComTencentImageURLDrawable = paramDrawable;
      this.jdField_e_of_type_Int = paramInt;
      apsm.a().a().a("AIOGalleryPicView", 4, "create rawDrawable, position:" + paramInt);
    }
    paramGalleryUrlImageView.setDecodingDrawble(paramDrawable);
    paramDrawable.startDownload();
  }
  
  public void a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = (URLDrawable)this.jdField_a_of_type_Apti.a.get(Integer.valueOf(paramInt));
    if (paramView != null)
    {
      if (paramView.getStatus() == 0) {
        paramView.cancelDownload(true);
      }
      this.jdField_a_of_type_Apti.a.remove(Integer.valueOf(paramInt));
    }
    if (paramInt == this.jdField_e_of_type_Int)
    {
      if ((this.jdField_a_of_type_ComTencentImageURLDrawable != null) && (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 0)) {
        this.jdField_a_of_type_ComTencentImageURLDrawable.cancelDownload(true);
      }
      this.jdField_a_of_type_ComTencentImageURLDrawable = null;
      this.jdField_e_of_type_Int = -1;
    }
  }
  
  public void a(int paramInt, View paramView, apsr paramapsr)
  {
    if (paramInt == this.jdField_e_of_type_Int)
    {
      if ((this.jdField_a_of_type_ComTencentImageURLDrawable != null) && (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 0)) {
        this.jdField_a_of_type_ComTencentImageURLDrawable.cancelDownload(true);
      }
      this.jdField_a_of_type_ComTencentImageURLDrawable = null;
      this.jdField_e_of_type_Int = -1;
      apsm.a().a().a("AIOGalleryPicView", 4, "destory rawDrawable, position: " + paramInt);
    }
    if ((paramView != null) && ((paramView.getTag() instanceof apvi)))
    {
      paramView = ((apvi)paramView.getTag()).a.getDrawable();
      if ((paramapsr != null) && ((paramView instanceof URLDrawable)) && (this.jdField_a_of_type_Apti.a() != null)) {
        this.jdField_a_of_type_Apti.a().b(paramapsr.hashCode());
      }
    }
    if (this.jdField_a_of_type_Apti.a() != null) {
      this.jdField_a_of_type_Apti.a().a();
    }
  }
  
  public void a(int paramInt, View paramView, RegionDrawableData paramRegionDrawableData)
  {
    if ((paramView != null) && ((paramView.getTag() instanceof apvi)))
    {
      paramView = ((apvi)paramView.getTag()).a.getDrawable();
      if (URLDrawable.class.isInstance(paramView)) {}
    }
    else
    {
      return;
    }
    ((URLDrawable)paramView).updateRegionBitmap(paramRegionDrawableData);
  }
  
  public void a(int paramInt, Object paramObject, apsr paramapsr)
  {
    a(babr.a(this.jdField_a_of_type_AndroidAppActivity, 230, this.jdField_a_of_type_AndroidAppActivity.getString(2131652999), this.jdField_a_of_type_AndroidAppActivity.getString(2131652998), new apvf(this, paramInt, paramObject), new apvg(this)));
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    apsr localapsr = this.jdField_a_of_type_Apti.a(paramInt);
    Object localObject3;
    Object localObject2;
    Object localObject4;
    Object localObject1;
    if ((localapsr != null) && (localapsr.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData != null) && (localapsr.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.a() == 1) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && ((this.jdField_a_of_type_AndroidWidgetRelativeLayout.getTag() instanceof apvi)))
    {
      localObject3 = ((apvi)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getTag()).a;
      localObject2 = (AIOPicData)localapsr.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData;
      localObject4 = new apsz();
      if (!((AIOPicData)localObject2).jdField_e_of_type_Boolean) {
        break label211;
      }
      localObject1 = ((GalleryUrlImageView)localObject3).getDrawable();
      if (!URLDrawable.class.isInstance(localObject1)) {
        break label699;
      }
      localObject1 = (URLDrawable)localObject1;
      localObject2 = ((URLDrawable)localObject1).getURL().getRef();
    }
    for (;;)
    {
      if ((localObject1 == null) || (localObject2 == null) || ((!"PART".equals(localObject2)) && (!"DISPLAY".equals(localObject2))))
      {
        ((GalleryUrlImageView)localObject3).setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(2130837854));
        this.jdField_a_of_type_Apti.b(paramInt, false);
        this.jdField_a_of_type_Apti.a().d();
      }
      apsm.a().a().a("AIOGalleryPicView", 4, "AIOGalleryAdapter.updateView(): IMAGE_FILE_ERROR");
      return;
      label211:
      File localFile = ((apsz)localObject4).a((AIOPicData)localObject2, 2);
      if (localFile != null)
      {
        localObject1 = ((apsz)localObject4).a((AIOPicData)localObject2, 2);
        if (!paramBoolean) {
          break label696;
        }
        localObject1 = (String)localObject1 + "#PART";
      }
      label696:
      for (;;)
      {
        try
        {
          localapsr.jdField_a_of_type_Int = JpegExifReader.readOrientation(localFile.getAbsolutePath());
          apsm.a().a().a("AIOGalleryPicView", 4, "AIOGalleryAdapter.updateView(): read orientation:" + localapsr.jdField_a_of_type_Int);
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          if (((AIOPicData)localObject2).jdField_d_of_type_Int == 3)
          {
            localObject4 = ((apsz)localObject4).a((AIOPicData)localObject2, 1);
            if (localObject4 != null)
            {
              localObject4 = URLDrawable.getDrawable((File)localObject4, null);
              if (((URLDrawable)localObject4).getStatus() == 1)
              {
                localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject4);
                localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject4);
              }
            }
          }
          localURLDrawableOptions.mUseExifOrientation = false;
          localURLDrawableOptions.mPlayGifImage = true;
          localObject4 = URLDrawable.getDrawable((String)localObject1, localURLDrawableOptions);
          if ((((URLDrawable)localObject4).getStatus() == 1) && (!((AIOPicData)localObject2).jdField_g_of_type_Boolean)) {
            if (localapsr.jdField_a_of_type_Int != -2) {}
          }
        }
        catch (Exception localException2)
        {
          try
          {
            localapsr.jdField_a_of_type_Int = JpegExifReader.readOrientation(localFile.getAbsolutePath());
            ((GalleryUrlImageView)localObject3).setImageDrawable((Drawable)localObject4);
            this.jdField_a_of_type_Apti.b(paramInt, true);
            localObject3 = this.jdField_a_of_type_Apti;
            apti.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, (URLDrawable)localObject4, localapsr.jdField_a_of_type_Int);
            localObject3 = bace.b(((AIOPicData)localObject2).jdField_b_of_type_JavaLangString);
            apsm.a().a().a("AIOGalleryPicView", 4, "AIOGalleryAdapter.updateView(): Update large image, position=" + paramInt + "url = " + (String)localObject1 + ",extName = " + (String)localObject3);
            ((AIOPicData)localObject2).jdField_g_of_type_Boolean = paramBoolean;
            this.jdField_a_of_type_Apti.a().c();
            return;
            localException2 = localException2;
            apsm.a().a().a("AIOGalleryPicView", 4, "read exif error" + localException2.getMessage());
          }
          catch (Exception localException1)
          {
            apsm.a().a().a("AIOGalleryPicView", 4, "read exif error" + localException1.getMessage());
            localapsr.jdField_a_of_type_Int = 1;
            continue;
          }
          ((URLDrawable)localObject4).setTag(Integer.valueOf(1));
          ((URLDrawable)localObject4).startDownload();
          ((GalleryUrlImageView)localObject3).setDecodingDrawble((URLDrawable)localObject4);
          continue;
        }
        if (((apsz)localObject4).a((AIOPicData)localObject2, 1) == null) {
          break;
        }
        ((GalleryUrlImageView)localObject3).setImageDrawable(URLDrawable.getDrawable(((apsz)localObject4).a((AIOPicData)localObject2, 1), URLDrawable.URLDrawableOptions.obtain()));
        return;
      }
      label699:
      localObject2 = null;
      localObject1 = null;
    }
  }
  
  public void a(long paramLong)
  {
    boolean bool = true;
    super.a(paramLong);
    apsr localapsr = this.jdField_a_of_type_Apti.a();
    if ((localapsr == null) || (localapsr.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData == null) || (localapsr.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.a() != 1))
    {
      apsm.a().a().a("AIOGalleryPicView", 4, "onRevokeMsg exp!");
      return;
    }
    int i = this.jdField_a_of_type_Apti.a(localapsr.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.jdField_a_of_type_Long, localapsr.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.jdField_a_of_type_Int);
    if ((i >= 0) && (i < 100)) {}
    for (;;)
    {
      apsm.a().a().a("AIOGalleryPicView", 4, "onRevokeMsg isSaving:" + bool);
      if (!bool) {
        break;
      }
      this.jdField_a_of_type_Apti.c(localapsr.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.jdField_a_of_type_Long, localapsr.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.jdField_a_of_type_Int, 24);
      return;
      bool = false;
    }
  }
  
  public void a(Intent paramIntent)
  {
    super.a(paramIntent);
    paramIntent = paramIntent.getExtras();
    this.jdField_c_of_type_Boolean = paramIntent.getBoolean("extra.CAN_FORWARD_TO_GROUP_ALBUM", false);
    this.jdField_d_of_type_Int = paramIntent.getInt("extra.EXTRA_FORWARD_TO_QZONE_SRC");
    this.jdField_d_of_type_Boolean = paramIntent.getBoolean("group.emo.big.preview", false);
    this.jdField_e_of_type_Boolean = paramIntent.getBoolean("extra.OCR", false);
  }
  
  public void a(Configuration paramConfiguration)
  {
    super.a(paramConfiguration);
    i();
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    super.a(paramViewGroup);
    b(paramViewGroup);
  }
  
  public void a(apvj paramapvj)
  {
    this.jdField_a_of_type_Apvj = paramapvj;
  }
  
  public void a(URLDrawable paramURLDrawable, int paramInt)
  {
    if (this.jdField_a_of_type_Apti.a.get(Integer.valueOf(paramInt)) != null) {
      this.jdField_a_of_type_Apti.a.put(Integer.valueOf(paramInt), paramURLDrawable);
    }
  }
  
  public void a(AIOPicData paramAIOPicData, apsr paramapsr, File paramFile)
  {
    this.jdField_a_of_type_Bahv.a(new apvb(this, paramAIOPicData, paramapsr, paramFile));
    this.jdField_a_of_type_Bahv.a(new apve(this));
  }
  
  public void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    super.a(paramAdapterView, paramView, paramInt, paramLong);
    if ((paramView != null) && ((paramView.getTag() instanceof apvi)))
    {
      paramAdapterView = (apvi)paramView.getTag();
      if (paramAdapterView.a != null)
      {
        paramView = paramAdapterView.a;
        paramAdapterView = paramView.getDrawable();
        apsr localapsr = this.jdField_a_of_type_Apti.a();
        if ((!paramView.a()) && (localapsr != null) && (localapsr.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData != null) && (localapsr.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.a() == 1))
        {
          paramView = (AIOPicData)localapsr.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData;
          if (((paramAdapterView instanceof SkinnableBitmapDrawable)) && (paramView.jdField_b_of_type_Int == 1) && (paramView.jdField_c_of_type_Long > aonj.c()) && (this.jdField_a_of_type_Apti.a() != null))
          {
            this.jdField_a_of_type_Apti.a().b(false);
            this.jdField_a_of_type_Apti.a().a(false);
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
    Object localObject = this.jdField_a_of_type_Apti.a();
    if ((localObject != null) && (((apsr)localObject).jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData != null) && (((apsr)localObject).jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.a() == 1))
    {
      localObject = (AIOPicData)((apsr)localObject).jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData;
      if (((AIOPicData)localObject).jdField_h_of_type_Int == 2)
      {
        this.jdField_a_of_type_Apti.c(((AIOPicData)localObject).jdField_a_of_type_Long, ((AIOPicData)localObject).jdField_a_of_type_Int, 4);
        this.jdField_a_of_type_Apti.a(((AIOPicData)localObject).jdField_a_of_type_Long, ((AIOPicData)localObject).jdField_a_of_type_Int, 0);
      }
    }
    return super.a();
  }
  
  public void an_()
  {
    this.jdField_a_of_type_Apti.aJ_();
  }
  
  public void b()
  {
    super.b();
    a(new apuy(this));
  }
  
  public void b(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramView != null) && ((paramView.getTag() instanceof apvi)))
    {
      paramView = ((apvi)paramView.getTag()).a;
      paramViewGroup = paramView.getDrawable();
      URLDrawable localURLDrawable = paramView.jdField_a_of_type_ComTencentImageURLDrawable;
      if (((paramViewGroup instanceof URLDrawable)) && (((URLDrawable)paramViewGroup).isFakeSize()) && (localURLDrawable == null)) {
        a(paramInt, paramViewGroup, localURLDrawable, paramView);
      }
    }
  }
  
  public void b(ViewGroup paramViewGroup)
  {
    super.b(paramViewGroup);
  }
  
  public void b(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.jdField_a_of_type_Apti.j();
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
  
  public void d()
  {
    super.d();
    i();
  }
  
  public boolean d()
  {
    Object localObject;
    if (super.d())
    {
      localObject = this.jdField_a_of_type_Apti.a();
      if ((localObject != null) && (((apsr)localObject).jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData != null) && (((apsr)localObject).jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.a() == 1))
      {
        AIOPicData localAIOPicData = (AIOPicData)((apsr)localObject).jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData;
        apsz localapsz = new apsz();
        localObject = localapsz.a(localAIOPicData, 4);
        if (localObject != null) {
          break label111;
        }
        localObject = localapsz.a(localAIOPicData, 2);
      }
    }
    label111:
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
    if ((this.jdField_a_of_type_AndroidAppActivity.getIntent().getBooleanExtra("extra.FROM_AIO", false)) || (this.jdField_a_of_type_Apsx.c() == 3) || (this.jdField_a_of_type_Apsx.c() == 2) || (this.jdField_a_of_type_Apsx.c() == 6)) {}
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
    h(false);
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
  
  public void h()
  {
    super.h();
    if (this.jdField_a_of_type_Apsx.b()) {
      return;
    }
    i();
  }
  
  public void h(boolean paramBoolean)
  {
    int j = 0;
    Object localObject;
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
    {
      localObject = this.jdField_a_of_type_Apti.a();
      if ((localObject == null) || (((apsr)localObject).jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData == null)) {
        break label192;
      }
    }
    label192:
    for (long l = ((apsr)localObject).jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.jdField_a_of_type_Long;; l = 0L)
    {
      int i = j;
      if (paramBoolean)
      {
        i = j;
        if (localObject != null)
        {
          i = j;
          if (((apsr)localObject).jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData != null)
          {
            i = j;
            if (((apsr)localObject).jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.a() == 1)
            {
              i = j;
              if (autt.a())
              {
                i = j;
                if (ShortVideoUtils.g())
                {
                  localObject = (AIOPicData)((apsr)localObject).jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData;
                  i = j;
                  if (!TextUtils.isEmpty(((AIOPicData)localObject).o))
                  {
                    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
                    if (this.jdField_a_of_type_Long != l)
                    {
                      awqx.b(null, "dc00898", "", "", "0X800A91E", "0X800A91E", 1, 0, "", "", ((AIOPicData)localObject).o, "");
                      this.jdField_a_of_type_Long = l;
                    }
                    i = 1;
                  }
                }
              }
            }
          }
        }
      }
      if (i == 0) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      }
      return;
    }
  }
  
  public void i()
  {
    this.jdField_a_of_type_Apti.a.clear();
    if ((this.jdField_a_of_type_ComTencentImageURLDrawable != null) && (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 0)) {
      this.jdField_a_of_type_ComTencentImageURLDrawable.cancelDownload(true);
    }
    this.jdField_a_of_type_ComTencentImageURLDrawable = null;
    this.jdField_e_of_type_Int = -1;
  }
  
  public void j()
  {
    super.j();
    Object localObject = this.jdField_a_of_type_Apti.a();
    AIOPicData localAIOPicData;
    if ((localObject != null) && (((apsr)localObject).jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData != null) && (((apsr)localObject).jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.a() == 1)) {
      localAIOPicData = (AIOPicData)((apsr)localObject).jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData;
    }
    switch (localAIOPicData.jdField_h_of_type_Int)
    {
    default: 
      apsm.a().a().a("AIOGalleryPicView", 4, "updateUI status is error, status = " + localAIOPicData.jdField_h_of_type_Int);
      return;
    case 1: 
      e(false);
      a(false);
      f(false);
      this.jdField_a_of_type_Apti.a(this.jdField_a_of_type_Apti.c(), localAIOPicData.i);
      return;
    case 2: 
      this.jdField_a_of_type_Apti.b(this.jdField_a_of_type_Apti.c(), true);
      e(false);
      a(false);
      f(false);
      this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(localAIOPicData.i / 100);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(ajjy.a(2131634254) + localAIOPicData.i / 100 + "%");
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      return;
    case 3: 
      this.jdField_a_of_type_Apti.b(this.jdField_a_of_type_Apti.c(), true);
      e(false);
      a(false);
      b(false);
      f(false);
      this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(localAIOPicData.i / 100);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(ajjy.a(2131634238) + localAIOPicData.i / 100 + "%");
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_Apti.b(this.jdField_a_of_type_Apti.c(), true);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    a(d());
    b(a((apsr)localObject));
    f(e());
    h(true);
    localObject = new apsz();
    if ((((apsz)localObject).a(localAIOPicData, 2) != null) || (((apsz)localObject).a(localAIOPicData, 4) != null)) {
      g(true);
    }
    while ((((apsz)localObject).a(localAIOPicData, 4)) && (((apsz)localObject).a(localAIOPicData, 4) == null))
    {
      e(true);
      return;
      g(false);
    }
    e(false);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            paramView = this.jdField_a_of_type_Apti.a();
          } while ((paramView == null) || (paramView.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData == null) || (paramView.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.a() != 1) || (((AIOPicData)paramView.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData).jdField_d_of_type_Int != 3));
          this.jdField_a_of_type_Apti.j();
          return;
          paramView = this.jdField_a_of_type_Apti.a();
        } while ((paramView == null) || (paramView.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData == null) || (paramView.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.a() != 1));
        paramView = (AIOPicData)paramView.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData;
        switch (paramView.jdField_h_of_type_Int)
        {
        }
        for (;;)
        {
          this.jdField_a_of_type_Apti.a(paramView.jdField_a_of_type_Long, paramView.jdField_a_of_type_Int, 0);
          j();
          return;
          this.jdField_a_of_type_Apti.c(paramView.jdField_a_of_type_Long, paramView.jdField_a_of_type_Int, 4);
          continue;
          this.jdField_a_of_type_Apti.c(paramView.jdField_a_of_type_Long, paramView.jdField_a_of_type_Int, 2);
          continue;
          this.jdField_a_of_type_Apti.c(paramView.jdField_a_of_type_Long, paramView.jdField_a_of_type_Int, 24);
        }
        s();
        return;
        t();
        this.jdField_a_of_type_Apti.aK_();
        return;
        l();
        return;
        if (QLog.isColorLevel()) {
          QLog.d("AIOGalleryPicView", 0, "onClick qq_gallery_danmaku_view ");
        }
        paramView = this.jdField_a_of_type_Apti.a();
        if ((paramView != null) && (paramView.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData != null)) {
          MiniChatActivity.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Apsx.a(), this.jdField_a_of_type_Apsx.a(), false, 26, paramView.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.d, 0L);
        }
        this.jdField_a_of_type_Apti.r();
        return;
        paramView = this.jdField_a_of_type_Apti.a();
      } while ((paramView == null) || (paramView.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData == null) || (paramView.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.a() != 1));
      paramView = (AIOPicData)paramView.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData;
    } while (TextUtils.isEmpty(paramView.o));
    bjeg.a(this.jdField_a_of_type_AndroidAppActivity, paramView.o);
    awqx.b(null, "dc00898", "", "", "0X800A91F", "0X800A91F", 1, 0, "", "", paramView.o, "");
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
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131298293));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131307308));
      this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131307312));
      this.jdField_c_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131307310));
      this.jdField_b_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131307315));
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
      b(a(this.jdField_a_of_type_Apti.a()));
      f(e());
      a(d());
    }
    if (!this.jdField_b_of_type_Boolean) {
      d(true);
    }
  }
  
  public void s()
  {
    Object localObject = this.jdField_a_of_type_Apti.a();
    if ((localObject != null) && (((apsr)localObject).jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData != null) && (((apsr)localObject).jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.a() == 1) && (this.jdField_a_of_type_Apti.e()))
    {
      localObject = (AIOPicData)((apsr)localObject).jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData;
      this.jdField_a_of_type_Apti.a(((AIOPicData)localObject).jdField_a_of_type_Long, ((AIOPicData)localObject).jdField_a_of_type_Int, 2);
      this.jdField_a_of_type_Apti.b(((AIOPicData)localObject).jdField_a_of_type_Long, ((AIOPicData)localObject).jdField_a_of_type_Int, 4);
      j();
    }
  }
  
  void t()
  {
    Object localObject1 = this.jdField_a_of_type_Apti.a();
    Object localObject2;
    if ((localObject1 != null) && (((apsr)localObject1).jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData != null) && (((apsr)localObject1).jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.a() == 1))
    {
      AIOPicData localAIOPicData = (AIOPicData)((apsr)localObject1).jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData;
      apsz localapsz = new apsz();
      localObject2 = localapsz.a(localAIOPicData, 4);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = localapsz.a(localAIOPicData, 2);
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = localapsz.a(localAIOPicData, 1);
      }
      if (localObject2 != null) {}
    }
    else
    {
      return;
    }
    this.jdField_b_of_type_JavaLangString = ((File)localObject2).getAbsolutePath();
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
      localObject1 = EditPicActivity.a(this.jdField_a_of_type_AndroidAppActivity, ((File)localObject2).getAbsolutePath(), true, true, true, true, true, 2, i, 7);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     apux
 * JD-Core Version:    0.7.0.1
 */