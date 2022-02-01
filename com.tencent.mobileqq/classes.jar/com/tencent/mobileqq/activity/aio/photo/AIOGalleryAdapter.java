package com.tencent.mobileqq.activity.aio.photo;

import aady;
import aavo;
import aawb;
import ahfz;
import ahqz;
import ahra;
import ahrb;
import ahrc;
import ahrd;
import ahri;
import ahsn;
import ahtm;
import ahtp;
import ahty;
import ahub;
import akki;
import aklo;
import aklw;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import anvx;
import asbg;
import atpj;
import bbka;
import bbkd;
import bbkg;
import bdla;
import bhbz;
import blvp;
import bofz;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.galleryactivity.AbstractImageAdapter;
import com.tencent.common.galleryactivity.AbstractImageAdapter.URLImageView2;
import com.tencent.image.JpegExifReader;
import com.tencent.image.QQLiveDrawable;
import com.tencent.image.QQLiveDrawable.OnDownloadListener;
import com.tencent.image.QQLiveDrawable.OnLoopBackListener;
import com.tencent.image.QQLiveDrawable.OnStateListener;
import com.tencent.image.QQLiveDrawable.QQLiveDrawableParams;
import com.tencent.image.QQLiveImage;
import com.tencent.image.RegionDrawableData;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.image.VideoDrawable;
import com.tencent.image.VideoDrawable.VideoDrawableParams;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.widget.AdapterView;
import com.tencent.widget.Gallery.LayoutParams;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import org.json.JSONObject;
import ykv;
import zei;

public class AIOGalleryAdapter
  extends AbstractImageAdapter
  implements akki, QQLiveDrawable.OnDownloadListener, QQLiveDrawable.OnLoopBackListener, QQLiveDrawable.OnStateListener
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long = -1L;
  public ahrc a;
  private ahrd jdField_a_of_type_Ahrd;
  ahsn jdField_a_of_type_Ahsn;
  ahtp jdField_a_of_type_Ahtp;
  aklo jdField_a_of_type_Aklo;
  private SparseArray<URLDrawable> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  public AIOGalleryActivity a;
  private AIOGalleryAdapter.GalleryImageStruct jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct;
  AIORichMediaData jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
  String jdField_a_of_type_JavaLangString;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public boolean a;
  int jdField_b_of_type_Int;
  long jdField_b_of_type_Long = -1L;
  private SparseArray<URLDrawable> jdField_b_of_type_AndroidUtilSparseArray = new SparseArray();
  private URLDrawable jdField_b_of_type_ComTencentImageURLDrawable;
  private AIOGalleryAdapter.GalleryImageStruct jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct;
  boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = -1;
  long jdField_c_of_type_Long = -1L;
  private int jdField_d_of_type_Int = -1;
  private long jdField_d_of_type_Long = -1L;
  private int e;
  private int f;
  private int g;
  
  public AIOGalleryAdapter(Context paramContext, ahtp paramahtp, boolean paramBoolean, int paramInt)
  {
    this.jdField_g_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity = ((AIOGalleryActivity)paramContext);
    this.jdField_a_of_type_Ahtp = paramahtp;
    this.e = paramContext.getResources().getDisplayMetrics().widthPixels;
    this.jdField_f_of_type_Int = paramContext.getResources().getDisplayMetrics().heightPixels;
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Int = paramInt;
    paramContext = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getIntent();
    if (paramContext != null)
    {
      this.jdField_b_of_type_Int = paramContext.getIntExtra("forward_source_uin_type", -1);
      this.jdField_a_of_type_JavaLangString = paramContext.getStringExtra("uin");
    }
  }
  
  public static Drawable a(String paramString, int paramInt1, int paramInt2)
  {
    asbg localasbg = new asbg(Color.rgb(214, 214, 214), paramInt1, paramInt2);
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        URLDrawable localURLDrawable = URLDrawable.getDrawable(paramString, localasbg, localasbg);
        if (localURLDrawable.getStatus() != 1) {
          localURLDrawable.downloadImediatly();
        }
        return localURLDrawable;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e(" AIOGalleryAdapter", 2, "getCoverDrawable():  getDrawable Exception, coverUrl=" + paramString, localException);
        }
      }
    }
    return localasbg;
  }
  
  private View a(int paramInt, ahtm paramahtm)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_d_of_type_Boolean = true;
    AIOShortVideoData localAIOShortVideoData = (AIOShortVideoData)paramahtm.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
    if (localAIOShortVideoData.jdField_b_of_type_Int != 0)
    {
      localObject = new AIOGalleryAdapter.GalleryImageStruct(this, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity, 1);
      ((AIOGalleryAdapter.GalleryImageStruct)localObject).setAdjustViewBounds(true);
      localURLDrawable = (URLDrawable)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
      ((AIOGalleryAdapter.GalleryImageStruct)localObject).setPosition(paramInt);
      ((AIOGalleryAdapter.GalleryImageStruct)localObject).setImageInfo(paramahtm);
      ((AIOGalleryAdapter.GalleryImageStruct)localObject).a();
      if (localURLDrawable != null)
      {
        ((AIOGalleryAdapter.GalleryImageStruct)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct$GalleryUrlImageView.setImageDrawable(localURLDrawable);
        if (QLog.isColorLevel()) {
          QLog.i(" AIOGalleryAdapter", 2, "getView():load thumb hit cache , position is " + paramInt);
        }
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_c_of_type_Boolean) {
          break label400;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_b_of_type_Int != 1) {
          break label340;
        }
        paramahtm = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity;
        paramahtm.jdField_b_of_type_Int -= 1;
        if (this.jdField_b_of_type_Boolean)
        {
          ((AIOGalleryAdapter.GalleryImageStruct)localObject).b(paramInt);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_c_of_type_Boolean = false;
        }
      }
      label400:
      for (;;)
      {
        if ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean))
        {
          this.jdField_a_of_type_Ahtp.a(this.jdField_a_of_type_Int);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean = true;
        }
        return localObject;
        if (localAIOShortVideoData.a(0) != null)
        {
          a(localAIOShortVideoData.jdField_a_of_type_JavaLangString, localAIOShortVideoData.jdField_c_of_type_Int, localAIOShortVideoData.jdField_d_of_type_Int, ((AIOGalleryAdapter.GalleryImageStruct)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct$GalleryUrlImageView, paramInt);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i(" AIOGalleryAdapter", 2, "getView(): load thumb and videoDrawable exist, position is " + paramInt);
          break;
        }
        ((AIOGalleryAdapter.GalleryImageStruct)localObject).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_Ahtp.a(localAIOShortVideoData.jdField_f_of_type_Long, localAIOShortVideoData.jdField_f_of_type_Int, 0);
        QLog.i(" AIOGalleryAdapter", 2, "getView(): load thumb download THUMB, position is " + paramInt);
        break;
        label340:
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_b_of_type_Int == 0)
        {
          ((AIOGalleryAdapter.GalleryImageStruct)localObject).b(paramInt);
          bdla.b(null, "dc00898", "", "", "0X8009EF1", "0X8009EF1", 1, 0, "", "", "", "");
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_c_of_type_Boolean = false;
          continue;
          bdla.b(null, "dc00898", "", "", "0X8009EF1", "0X8009EF1", 2, 0, "", "", "", "");
        }
      }
    }
    paramahtm = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getLayoutInflater().inflate(2131561341, null);
    paramahtm.setTag(2131296400, Boolean.valueOf(true));
    paramahtm.setTag(2131296433, Boolean.valueOf(true));
    paramahtm.setLayoutParams(new Gallery.LayoutParams(-1, -1));
    Object localObject = (URLImageView)paramahtm.findViewById(2131373142);
    URLDrawable localURLDrawable = (URLDrawable)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localURLDrawable != null)
    {
      ((URLImageView)localObject).setImageDrawable(localURLDrawable);
      if (localAIOShortVideoData.jdField_f_of_type_Long != this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Long) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_c_of_type_Boolean = false;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Long != localAIOShortVideoData.jdField_f_of_type_Long) {
        break label703;
      }
      if (a(localAIOShortVideoData, paramahtm))
      {
        ((ImageView)paramahtm.findViewById(2131373141)).setVisibility(8);
        this.jdField_a_of_type_Aklo.f();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_c_of_type_Boolean = false;
      bdla.b(null, "dc00898", "", "", "0X8009EF2", "0X8009EF2", 1, 0, "", "", "", "");
    }
    for (;;)
    {
      if ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean))
      {
        this.jdField_a_of_type_Ahtp.a(this.jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean = true;
      }
      return paramahtm;
      if (localAIOShortVideoData.a(0) == null) {
        break;
      }
      a(localAIOShortVideoData.jdField_a_of_type_JavaLangString, localAIOShortVideoData.jdField_c_of_type_Int, localAIOShortVideoData.jdField_d_of_type_Int, (ImageView)localObject, paramInt);
      break;
      label703:
      bdla.b(null, "dc00898", "", "", "0X8009EF2", "0X8009EF2", 2, 0, "", "", "", "");
    }
  }
  
  private View a(ahtm paramahtm, int paramInt, AIOGalleryAdapter.GalleryImageStruct paramGalleryImageStruct)
  {
    AIOFileVideoData localAIOFileVideoData;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_c_of_type_Boolean = false;
      bdla.b(null, "dc00898", "", "", "0X8009EF3", "0X8009EF3", 1, 0, "", "", "", "");
      localAIOFileVideoData = (AIOFileVideoData)paramahtm.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
      paramGalleryImageStruct.setPosition(paramInt);
      paramGalleryImageStruct.setImageInfo(paramahtm);
      paramGalleryImageStruct.setIgnoreLayout(false);
      if ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean))
      {
        this.jdField_a_of_type_Ahtp.a(this.jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean = true;
      }
      paramGalleryImageStruct = (Drawable)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
      if (!localAIOFileVideoData.b()) {
        break label259;
      }
    }
    label259:
    label580:
    for (;;)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getLayoutInflater().inflate(2131561341, null);
      ((View)localObject).setTag(2131296400, Boolean.valueOf(true));
      ((View)localObject).setTag(2131296433, Boolean.valueOf(true));
      ((View)localObject).setLayoutParams(new Gallery.LayoutParams(-1, -1));
      URLImageView localURLImageView = (URLImageView)((View)localObject).findViewById(2131373142);
      localURLImageView.setImageDrawable(paramGalleryImageStruct);
      if (localAIOFileVideoData.b())
      {
        localURLImageView.setImageDrawable(null);
        return localObject;
        bdla.b(null, "dc00898", "", "", "0X8009EF3", "0X8009EF3", 2, 0, "", "", "", "");
        break;
        if ((paramGalleryImageStruct != null) && (((URLDrawable)paramGalleryImageStruct).getStatus() == 1))
        {
          a(paramInt, true);
          continue;
        }
        if (!TextUtils.isEmpty(localAIOFileVideoData.jdField_b_of_type_JavaLangString))
        {
          localObject = new File(localAIOFileVideoData.jdField_b_of_type_JavaLangString);
          if (!((File)localObject).exists()) {
            break label580;
          }
          paramGalleryImageStruct = URLDrawable.URLDrawableOptions.obtain();
          paramGalleryImageStruct.mRequestWidth = this.e;
          paramGalleryImageStruct.mRequestHeight = this.jdField_f_of_type_Int;
          paramGalleryImageStruct.mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
          paramGalleryImageStruct.mPlayGifImage = true;
          paramGalleryImageStruct.mUseExifOrientation = false;
          paramGalleryImageStruct = URLDrawable.getDrawable((File)localObject, paramGalleryImageStruct);
          ((URLDrawable)paramGalleryImageStruct).setTag(Integer.valueOf(1));
          this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, (URLDrawable)paramGalleryImageStruct);
          continue;
        }
        paramGalleryImageStruct = BaseApplicationImpl.getApplication().getResources().getDrawable(2130838111);
        continue;
      }
      if ((paramahtm.jdField_c_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_d_of_type_Boolean)) {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_b_of_type_Int == 1)
        {
          paramahtm = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity;
          paramahtm.jdField_b_of_type_Int -= 1;
          this.jdField_d_of_type_Long = -1L;
          if (QLog.isColorLevel()) {
            QLog.i(" AIOGalleryAdapter", 1, "FileVideo_AP set hasDoneItemSelectUid = -1");
          }
        }
      }
      for (;;)
      {
        return localObject;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_b_of_type_Int == 0)
        {
          this.jdField_d_of_type_Long = localAIOFileVideoData.jdField_f_of_type_Long;
          localAIOFileVideoData.e = true;
          if (QLog.isColorLevel())
          {
            QLog.i(" AIOGalleryAdapter", 1, "FileVideo_AP set hasDoneItemSelectUid = " + this.jdField_d_of_type_Long);
            continue;
            this.jdField_d_of_type_Long = localAIOFileVideoData.jdField_f_of_type_Long;
            if (QLog.isColorLevel()) {
              QLog.i(" AIOGalleryAdapter", 1, "FileVideo_AP is not EnterImage && isAutoPlayed, set hasDoneItemSelectUid = " + this.jdField_d_of_type_Long);
            }
          }
        }
      }
    }
  }
  
  private URLDrawable a(AIOGalleryAdapter.GalleryImageStruct paramGalleryImageStruct, ahtm paramahtm, AIOImageData paramAIOImageData, boolean paramBoolean, int paramInt, File paramFile)
  {
    Object localObject1 = null;
    Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = this.e;
    ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = this.jdField_f_of_type_Int;
    ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
    ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = true;
    ((URLDrawable.URLDrawableOptions)localObject2).mUseExifOrientation = false;
    ((URLDrawable.URLDrawableOptions)localObject2).mDecodeFileStrategy = 2;
    if ((paramAIOImageData.jdField_b_of_type_Int == 1) && ((paramAIOImageData.jdField_d_of_type_Int & 0x2) == 2)) {
      ((URLDrawable.URLDrawableOptions)localObject2).mUseAutoScaleParams = false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct != null)
      {
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct.a();
        paramGalleryImageStruct.setTag(2131296389, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct.getTag(2131296389));
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct = null;
      }
    }
    else {
      if (paramBoolean) {
        break label406;
      }
    }
    label406:
    label443:
    label451:
    do
    {
      do
      {
        for (;;)
        {
          try
          {
            if (!paramAIOImageData.jdField_d_of_type_Boolean) {
              continue;
            }
            localObject2 = URLDrawable.getDrawable(paramAIOImageData.a(2) + "#" + "PART", (URLDrawable.URLDrawableOptions)localObject2);
            localObject1 = localObject2;
            localObject1.setTag(Integer.valueOf(1));
            this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject1);
            a(localObject1, paramGalleryImageStruct, paramahtm, paramInt, paramFile, paramBoolean);
            if (!paramBoolean) {
              break label443;
            }
            paramahtm = paramAIOImageData.jdField_c_of_type_JavaLangString;
            paramahtm = FileUtils.estimateFileType(paramahtm);
            if (QLog.isColorLevel()) {
              QLog.i(" AIOGalleryAdapter", 2, "getview url is " + localObject1.getURL().toString() + ", file type is " + paramAIOImageData.a(localObject1.getURL().toString()) + ",extName = " + paramahtm);
            }
            if ((paramBoolean) || (!paramAIOImageData.jdField_d_of_type_Boolean) || (paramAIOImageData.jdField_b_of_type_Boolean)) {
              break label451;
            }
            this.jdField_a_of_type_Ahtp.a(paramAIOImageData.jdField_f_of_type_Long, paramAIOImageData.jdField_f_of_type_Int, 2);
            paramahtm = localObject1;
            if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean)
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct = paramGalleryImageStruct;
              paramahtm = localObject1;
            }
          }
          catch (Throwable paramGalleryImageStruct)
          {
            paramahtm = localObject1;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.e(" AIOGalleryAdapter", 2, "[getView] URLDrawable.getDrawable failed.");
            return null;
          }
          return paramahtm;
          if ((paramAIOImageData.a(1) == null) || (BaseApplicationImpl.sImageCache.get(paramAIOImageData.a(1)) == null) || (paramAIOImageData.a(1) == null)) {
            break;
          }
          ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = URLDrawable.getDrawable(paramAIOImageData.a(1), null);
          break;
          localObject2 = URLDrawable.getDrawable(paramFile, (URLDrawable.URLDrawableOptions)localObject2);
          localObject1 = localObject2;
          continue;
          paramahtm = paramAIOImageData.jdField_b_of_type_JavaLangString;
        }
        paramahtm = localObject1;
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean);
      paramahtm = localObject1;
    } while (this.jdField_b_of_type_Boolean);
    this.jdField_a_of_type_Ahtp.a(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean = true;
    return localObject1;
  }
  
  private String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Actives: ");
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      if (i > 0) {
        localStringBuilder.append(" , ");
      }
      localStringBuilder.append(this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(i) + 1);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private void a(int paramInt, ahtm paramahtm, AdapterView<?> paramAdapterView, View paramView)
  {
    this.jdField_d_of_type_Long = -1L;
    if ((this.jdField_d_of_type_Int != paramInt) && (this.jdField_b_of_type_ComTencentImageURLDrawable != null))
    {
      a(this.jdField_d_of_type_Int, this.jdField_b_of_type_ComTencentImageURLDrawable, false);
      if ((this.jdField_b_of_type_ComTencentImageURLDrawable.getStatus() == 1) && ((this.jdField_b_of_type_ComTencentImageURLDrawable.getCurrDrawable() instanceof QQLiveDrawable)))
      {
        QQLiveDrawable localQQLiveDrawable = (QQLiveDrawable)this.jdField_b_of_type_ComTencentImageURLDrawable.getCurrDrawable();
        if (localQQLiveDrawable.getCurrentPosition() > 0L)
        {
          Object localObject = a(this.jdField_d_of_type_Int);
          if ((localObject != null) && (((ahtm)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData != null) && ((((ahtm)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOShortVideoData)))
          {
            localObject = (AIOShortVideoData)((ahtm)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
            a(((AIOShortVideoData)localObject).jdField_a_of_type_Long, ((AIOShortVideoData)localObject).jdField_a_of_type_Int * 1000, localQQLiveDrawable.getCurrentPosition());
          }
        }
        localQQLiveDrawable.recyleAndNotKeepPosition();
        if (QLog.isColorLevel()) {
          QLog.i(" AIOGalleryAdapter", 2, "onItemSelected recyleAndNotKeepPosition =" + localQQLiveDrawable + " mVideoDrawable set null");
        }
        this.jdField_b_of_type_ComTencentImageURLDrawable = null;
      }
    }
    if ((paramahtm != null) && (AIOShortVideoData.class.isInstance(paramahtm.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))) {
      a(paramAdapterView, (AIOShortVideoData)paramahtm.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData, paramView, paramInt);
    }
    do
    {
      do
      {
        return;
        if ((paramahtm == null) || (!AIOImageData.class.isInstance(paramahtm.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))) {
          break;
        }
        paramahtm = (AIOImageData)paramahtm.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
      } while ((paramahtm.jdField_b_of_type_Int != 3) || (paramahtm.a(1) != null) || (paramahtm.a(2) != null) || (paramahtm.a(4) != null) || (paramahtm.jdField_h_of_type_Long >= atpj.c()));
      a(paramInt, -1);
      return;
      this.jdField_d_of_type_Int = -1;
      this.jdField_b_of_type_ComTencentImageURLDrawable = null;
    } while (!QLog.isColorLevel());
    QLog.i(" AIOGalleryAdapter", 2, " onItemSelected():else Data is mVideoDrawable set null");
  }
  
  private void a(int paramInt, URLDrawable paramURLDrawable, boolean paramBoolean)
  {
    if (paramURLDrawable == null) {}
    String str;
    do
    {
      return;
      paramURLDrawable = paramURLDrawable.getCurrDrawable();
      if (VideoDrawable.class.isInstance(paramURLDrawable))
      {
        ((VideoDrawable)paramURLDrawable).stopAudio();
        int i;
        if (this.jdField_b_of_type_Long > 0L)
        {
          this.jdField_a_of_type_Long += System.currentTimeMillis() - this.jdField_b_of_type_Long;
          paramURLDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getIntent();
          if (paramURLDrawable != null)
          {
            i = paramURLDrawable.getIntExtra("forward_source_uin_type", -1);
            str = paramURLDrawable.getStringExtra("uin");
            new bbkg(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getApplication().getBaseContext()).a(bofz.a(), 2001, 0, i, str, this.jdField_a_of_type_Long / 1000L);
            if (this.jdField_b_of_type_Int != 1) {}
          }
        }
        for (;;)
        {
          try
          {
            paramURLDrawable = new JSONObject();
            paramURLDrawable.put("author_id", str);
            paramURLDrawable.put("author_type", "1");
            paramURLDrawable.put("video_type", "1");
            paramURLDrawable.put("video_time", this.jdField_c_of_type_Long + "");
            paramURLDrawable.put("play_time", this.jdField_a_of_type_Long);
            paramURLDrawable.put("content_type", 2);
            paramURLDrawable.put("mobile_type", Build.MODEL);
            paramURLDrawable.put("wifi_ssid", zei.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getApplicationContext()));
            paramURLDrawable.put("wifi_mac", zei.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getApplicationContext()));
            str = ykv.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getApplicationContext());
            if (!paramBoolean) {
              continue;
            }
            i = 2;
            ykv.a("story_grp", "play_video_js", 1003, i, new String[] { paramURLDrawable.toString(), "", str, "" });
          }
          catch (Exception paramURLDrawable)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.w(" AIOGalleryAdapter", 2, "reportTroopVideo exception:" + QLog.getStackTraceString(paramURLDrawable));
            continue;
          }
          this.jdField_b_of_type_Long = -1L;
          this.jdField_a_of_type_Long = -1L;
          this.jdField_c_of_type_Long = -1L;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i(" AIOGalleryAdapter", 2, "AIOGalleryAdapter.stopVideoAudio(): position " + paramInt);
          return;
          i = 3;
        }
      }
    } while ((!QQLiveDrawable.class.isInstance(paramURLDrawable)) || (this.jdField_b_of_type_Int != 1) || (this.jdField_b_of_type_Long <= 0L));
    this.jdField_a_of_type_Long += System.currentTimeMillis() - this.jdField_b_of_type_Long;
    paramURLDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getIntent();
    if (paramURLDrawable != null) {
      str = paramURLDrawable.getStringExtra("uin");
    }
    for (;;)
    {
      try
      {
        paramURLDrawable = new JSONObject();
        paramURLDrawable.put("author_id", str);
        paramURLDrawable.put("author_type", "1");
        paramURLDrawable.put("video_type", "1");
        paramURLDrawable.put("video_time", this.jdField_c_of_type_Long + "");
        paramURLDrawable.put("play_time", this.jdField_a_of_type_Long);
        paramURLDrawable.put("content_type", 2);
        str = ykv.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getApplicationContext());
        if (!paramBoolean) {
          continue;
        }
        paramInt = 2;
        ykv.a("story_grp", "play_video_js", 1003, paramInt, new String[] { paramURLDrawable.toString(), "", str, "" });
      }
      catch (Exception paramURLDrawable)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w(" AIOGalleryAdapter", 2, "reportTroopVideo exception:" + QLog.getStackTraceString(paramURLDrawable));
        continue;
      }
      this.jdField_b_of_type_Long = -1L;
      this.jdField_a_of_type_Long = -1L;
      this.jdField_c_of_type_Long = -1L;
      return;
      paramInt = 3;
    }
  }
  
  private void a(int paramInt, AIOGalleryAdapter.GalleryImageStruct paramGalleryImageStruct, AIOShortVideoData paramAIOShortVideoData, File paramFile, boolean paramBoolean)
  {
    QQLiveDrawable.QQLiveDrawableParams localQQLiveDrawableParams = new QQLiveDrawable.QQLiveDrawableParams();
    localQQLiveDrawableParams.mPreviewWidth = paramAIOShortVideoData.jdField_c_of_type_Int;
    localQQLiveDrawableParams.mPreviewHeight = paramAIOShortVideoData.jdField_d_of_type_Int;
    localQQLiveDrawableParams.mDataSourceType = 3;
    if (paramFile != null) {
      localQQLiveDrawableParams.mDataSource = paramFile.getAbsolutePath();
    }
    localQQLiveDrawableParams.mLoopback = false;
    localQQLiveDrawableParams.mMute = paramBoolean;
    localQQLiveDrawableParams.mPlayType = 2;
    localQQLiveDrawableParams.mListener = this;
    localQQLiveDrawableParams.mLoopBackListener = this;
    localQQLiveDrawableParams.mDownloadListener = this;
    localQQLiveDrawableParams.msgUniseq = paramAIOShortVideoData.jdField_a_of_type_Long;
    localQQLiveDrawableParams.mVideoTime = paramAIOShortVideoData.jdField_a_of_type_Int;
    localQQLiveDrawableParams.mReportTag = "bus_type_aio_short_fs";
    Object localObject = paramAIOShortVideoData.a(0);
    paramFile = URLDrawable.URLDrawableOptions.obtain();
    if ((localObject != null) && (((File)localObject).getAbsoluteFile() != null))
    {
      localQQLiveDrawableParams.mCoverUrl = ShortVideoUtils.getThumbUrl(((File)localObject).getAbsolutePath()).toString();
      localObject = a(localQQLiveDrawableParams.mCoverUrl, paramAIOShortVideoData.jdField_c_of_type_Int, paramAIOShortVideoData.jdField_d_of_type_Int);
      if (!(localObject instanceof URLDrawable)) {
        break label257;
      }
    }
    label257:
    for (paramFile.mLoadingDrawable = ((URLDrawable)localObject).getCurrDrawable();; paramFile.mLoadingDrawable = ((Drawable)localObject))
    {
      paramFile.mExtraInfo = localQQLiveDrawableParams;
      paramFile = URLDrawable.getDrawable(ahfz.a(paramAIOShortVideoData.jdField_a_of_type_Long), paramFile);
      paramGalleryImageStruct.setImageDrawable(paramFile);
      a(paramInt, true);
      this.jdField_b_of_type_ComTencentImageURLDrawable = paramFile;
      this.jdField_d_of_type_Int = paramInt;
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      this.jdField_c_of_type_Long = (paramAIOShortVideoData.jdField_a_of_type_Int * 1000L);
      return;
    }
  }
  
  private void a(long paramLong1, long paramLong2, long paramLong3)
  {
    if (!bhbz.a().a(paramLong1, "0X8009AA6"))
    {
      bhbz.a().a(paramLong1, "0X8009AA6");
      ShortVideoUtils.reportVideoPlayEvent(null, this.jdField_b_of_type_Int, this.jdField_a_of_type_JavaLangString, 2, 2, paramLong2, paramLong3);
    }
  }
  
  private void a(ahtm paramahtm, View paramView)
  {
    this.jdField_g_of_type_Int = 1;
    a(this.jdField_d_of_type_Int, this.jdField_b_of_type_ComTencentImageURLDrawable, false);
    if ((this.jdField_b_of_type_ComTencentImageURLDrawable != null) && (this.jdField_b_of_type_ComTencentImageURLDrawable.getStatus() == 1) && ((this.jdField_b_of_type_ComTencentImageURLDrawable.getCurrDrawable() instanceof QQLiveDrawable)))
    {
      QQLiveDrawable localQQLiveDrawable = (QQLiveDrawable)this.jdField_b_of_type_ComTencentImageURLDrawable.getCurrDrawable();
      if (localQQLiveDrawable.getCurrentPosition() > 0L)
      {
        Object localObject = a(this.jdField_d_of_type_Int);
        if ((localObject != null) && (((ahtm)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData != null) && ((((ahtm)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOShortVideoData)))
        {
          localObject = (AIOShortVideoData)((ahtm)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
          a(((AIOShortVideoData)localObject).jdField_a_of_type_Long, ((AIOShortVideoData)localObject).jdField_a_of_type_Int * 1000, localQQLiveDrawable.getCurrentPosition());
        }
      }
      localQQLiveDrawable.recyleAndNotKeepPosition();
      if (QLog.isColorLevel()) {
        QLog.i(" AIOGalleryAdapter", 2, " recyleAndNotKeepPosition ");
      }
      this.jdField_b_of_type_ComTencentImageURLDrawable = null;
    }
    if ((paramahtm != null) && (AIOShortVideoData.class.isInstance(paramahtm.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))) {
      b(paramahtm, paramView);
    }
    do
    {
      return;
      if ((paramahtm != null) && (AIOFileVideoData.class.isInstance(paramahtm.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)))
      {
        c(paramahtm, paramView);
        return;
      }
    } while (!QLog.isColorLevel());
    if (paramahtm != null)
    {
      QLog.i(" AIOGalleryAdapter", 1, "FileVideo_AP unsupport type :" + paramahtm.getClass().getSimpleName());
      return;
    }
    QLog.i(" AIOGalleryAdapter", 1, "FileVideo_AP unsupport type, image null!");
  }
  
  private void a(URLDrawable paramURLDrawable, AIOGalleryAdapter.GalleryImageStruct paramGalleryImageStruct, ahtm paramahtm, int paramInt, File paramFile, boolean paramBoolean)
  {
    boolean bool = true;
    switch (paramURLDrawable.getStatus())
    {
    }
    for (;;)
    {
      paramGalleryImageStruct.setImageDrawable(paramURLDrawable);
      paramGalleryImageStruct.setOriginalImage(paramBoolean);
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean) {}
      try
      {
        paramURLDrawable.downloadImediatly();
        return;
      }
      catch (Exception paramURLDrawable)
      {
        paramURLDrawable.printStackTrace();
      }
      if (paramahtm.jdField_b_of_type_Int == -2) {}
      try
      {
        paramahtm.jdField_b_of_type_Int = JpegExifReader.readOrientation(paramFile.getAbsolutePath());
        a(paramGalleryImageStruct, paramURLDrawable, paramahtm.jdField_b_of_type_Int);
        if (paramURLDrawable.getStatus() == 1) {
          a(paramInt, bool);
        }
      }
      catch (Exception paramFile)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e(" AIOGalleryAdapter", 2, "read exif error", paramFile);
          }
          paramahtm.jdField_b_of_type_Int = 1;
          continue;
          bool = false;
        }
      }
    }
  }
  
  private void a(AIOFilePicData paramAIOFilePicData, int paramInt)
  {
    Object localObject2 = paramAIOFilePicData.a(20);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = paramAIOFilePicData.a(18);
      if (localObject1 == null) {}
    }
    else
    {
      paramAIOFilePicData = URLDrawable.URLDrawableOptions.obtain();
      paramAIOFilePicData.mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
      paramAIOFilePicData.mFailedDrawable = URLDrawableHelper.TRANSPARENT;
      paramAIOFilePicData.mPlayGifImage = true;
      paramAIOFilePicData.mUseExifOrientation = false;
      paramAIOFilePicData = URLDrawable.getDrawable((File)localObject1, paramAIOFilePicData);
      paramAIOFilePicData.setTag(Integer.valueOf(1));
      paramAIOFilePicData.startDownload();
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramAIOFilePicData);
    }
    do
    {
      do
      {
        do
        {
          return;
          localObject1 = paramAIOFilePicData.a(16);
          if (localObject1 == null) {
            break;
          }
          localObject2 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
          ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = URLDrawableHelper.TRANSPARENT;
          URLDrawable.getDrawable((File)localObject1, (URLDrawable.URLDrawableOptions)localObject2).startDownload();
        } while ((!NetworkUtil.isWifiConnected(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity)) || (paramAIOFilePicData.jdField_a_of_type_Long > atpj.c()));
        this.jdField_a_of_type_Ahtp.a(paramAIOFilePicData.jdField_f_of_type_Long, paramAIOFilePicData.jdField_f_of_type_Int, 18);
        return;
      } while ((!NetworkUtil.isWifiConnected(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity)) || (paramAIOFilePicData.jdField_a_of_type_Long > atpj.c()));
      this.jdField_a_of_type_Ahtp.a(paramAIOFilePicData.jdField_f_of_type_Long, paramAIOFilePicData.jdField_f_of_type_Int, 18);
    } while (!QLog.isDevelopLevel());
    QLog.d(" AIOGalleryAdapter", 4, "onCreateView():Thumb and large pic is not exist, download it. Gallery position is " + paramInt);
  }
  
  private void a(AIOFilePicData paramAIOFilePicData, int paramInt, AIOGalleryAdapter.GalleryImageStruct paramGalleryImageStruct, ahtm paramahtm, boolean paramBoolean)
  {
    Object localObject = null;
    if (paramAIOFilePicData.jdField_a_of_type_Boolean)
    {
      paramAIOFilePicData = paramGalleryImageStruct.a();
      if (!URLDrawable.class.isInstance(paramAIOFilePicData)) {
        break label394;
      }
      localObject = (URLDrawable)paramAIOFilePicData;
      paramAIOFilePicData = ((URLDrawable)localObject).getURL().getRef();
    }
    for (;;)
    {
      if ((paramAIOFilePicData == null) && (FileUtil.fileExistsAndNotEmpty(((AIOFilePicData)paramahtm.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_b_of_type_JavaLangString)))
      {
        paramAIOFilePicData = URLDrawable.URLDrawableOptions.obtain();
        paramAIOFilePicData.mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
        paramAIOFilePicData.mFailedDrawable = URLDrawableHelper.TRANSPARENT;
        paramAIOFilePicData = URLDrawable.getDrawable(new File(((AIOFilePicData)paramahtm.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_b_of_type_JavaLangString), paramAIOFilePicData);
        if (paramAIOFilePicData != null)
        {
          paramGalleryImageStruct.setImageDrawable(paramAIOFilePicData);
          paramAIOFilePicData.downloadImediatly();
        }
      }
      do
      {
        do
        {
          do
          {
            return;
          } while ((localObject != null) && (paramAIOFilePicData != null) && (("PART".equals(paramAIOFilePicData)) || ("DISPLAY".equals(paramAIOFilePicData))));
          paramGalleryImageStruct.setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(2130838111));
          a(paramInt, false);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a().d();
        } while (((AIOFilePicData)paramahtm.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_a_of_type_Long < atpj.c());
        paramGalleryImageStruct.b();
        return;
        localFile = paramAIOFilePicData.a(18);
      } while (localFile == null);
      localObject = paramAIOFilePicData.a(18);
      paramahtm = (ahtm)localObject;
      if (paramBoolean) {
        paramahtm = (String)localObject + "#PART";
      }
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mUseExifOrientation = false;
      ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
      localObject = URLDrawable.getDrawable(localFile, (URLDrawable.URLDrawableOptions)localObject);
      if (((URLDrawable)localObject).getStatus() == 1)
      {
        paramGalleryImageStruct.setImageDrawable((Drawable)localObject);
        a(paramInt, true);
      }
      for (;;)
      {
        paramAIOFilePicData = FileUtils.estimateFileType(paramAIOFilePicData.jdField_c_of_type_JavaLangString);
        if (QLog.isColorLevel()) {
          QLog.i(" AIOGalleryAdapter", 2, "AIOGalleryAdapter.updateView(): Update large image, position=" + paramInt + "url = " + paramahtm + ",extName = " + paramAIOFilePicData);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a().c();
        return;
        ((URLDrawable)localObject).setTag(Integer.valueOf(1));
        ((URLDrawable)localObject).startDownload();
        paramGalleryImageStruct.setDecodingDrawble((URLDrawable)localObject);
      }
      label394:
      File localFile = null;
      paramAIOFilePicData = (AIOFilePicData)localObject;
      localObject = localFile;
    }
  }
  
  private void a(AIOFileVideoData paramAIOFileVideoData, int paramInt, AIOGalleryAdapter.GalleryImageStruct paramGalleryImageStruct)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mUseExifOrientation = false;
    localURLDrawableOptions.mPlayGifImage = true;
    paramAIOFileVideoData = paramAIOFileVideoData.a(0);
    if (paramAIOFileVideoData != null)
    {
      paramAIOFileVideoData = URLDrawable.getDrawable(paramAIOFileVideoData, localURLDrawableOptions);
      if (paramAIOFileVideoData.getStatus() == 1)
      {
        paramGalleryImageStruct.setImageDrawable(paramAIOFileVideoData);
        a(paramInt, true);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a().c();
        return;
        paramAIOFileVideoData.setTag(Integer.valueOf(1));
        paramAIOFileVideoData.startDownload();
        paramGalleryImageStruct.setDecodingDrawble(paramAIOFileVideoData);
      }
    }
    paramGalleryImageStruct.setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(2130838111));
    a(paramInt, true);
  }
  
  private void a(AIOGalleryAdapter.GalleryImageStruct paramGalleryImageStruct, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct != null))
    {
      Drawable localDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct.a();
      paramGalleryImageStruct.setImageDrawable(localDrawable);
      if (URLDrawable.class.isInstance(localDrawable)) {
        this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, (URLDrawable)localDrawable);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct = null;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i(" AIOGalleryAdapter", 2, "getView(): IMAGE_FILE_ERROR");
      }
      return;
      paramGalleryImageStruct.setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(2130838111));
      a(paramInt, false);
    }
  }
  
  private void a(AIOGalleryAdapter.GalleryImageStruct paramGalleryImageStruct, int paramInt, ahtm paramahtm)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_d_of_type_Boolean = true;
    AIOFilePicData localAIOFilePicData;
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_c_of_type_Boolean = false;
      bdla.b(null, "dc00898", "", "", "0X8009EF0", "0X8009EF0", 1, 0, "", "", "", "");
      paramGalleryImageStruct.setCenterBtnVisiable(8);
      localAIOFilePicData = (AIOFilePicData)paramahtm.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
      paramGalleryImageStruct.setPosition(paramInt);
      paramGalleryImageStruct.setImageInfo(paramahtm);
      paramGalleryImageStruct.setIgnoreLayout(false);
      localObject1 = (URLDrawable)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
      if ((localObject1 == null) || (((URLDrawable)localObject1).getStatus() != 1)) {
        break label325;
      }
      paramGalleryImageStruct.setImageDrawable((Drawable)localObject1);
      String str = localAIOFilePicData.a(20);
      localObject2 = ((URLDrawable)localObject1).getURL().toString();
      a(paramInt, true);
      if (((String)localObject2).equals(str)) {
        paramGalleryImageStruct.setOriginalImage(true);
      }
      if (paramahtm.jdField_b_of_type_Int == -2) {
        paramahtm.jdField_b_of_type_Int = JpegExifReader.readOrientation(((URLDrawable)localObject1).getURL().getFile());
      }
      a(paramGalleryImageStruct, (URLDrawable)localObject1, paramahtm.jdField_b_of_type_Int);
      if (!paramGalleryImageStruct.a()) {
        break label316;
      }
    }
    label316:
    for (paramGalleryImageStruct = localAIOFilePicData.jdField_d_of_type_JavaLangString;; paramGalleryImageStruct = localAIOFilePicData.jdField_c_of_type_JavaLangString)
    {
      paramGalleryImageStruct = FileUtils.estimateFileType(paramGalleryImageStruct);
      if (QLog.isColorLevel()) {
        QLog.i(" AIOGalleryAdapter", 2, "getView(): cache url is " + (String)localObject2 + ", cache type is " + localAIOFilePicData.a(((URLDrawable)localObject1).getURL().getFile()) + ",extName = + " + paramGalleryImageStruct);
      }
      return;
      bdla.b(null, "dc00898", "", "", "0X8009EF0", "0X8009EF0", 2, 0, "", "", "", "");
      break;
    }
    label325:
    Object localObject2 = localAIOFilePicData.a(20);
    if (localObject2 == null)
    {
      localObject1 = localAIOFilePicData.a(18);
      if (localObject1 == null) {}
    }
    for (;;)
    {
      if (localObject2 != null) {}
      for (boolean bool = true;; bool = false)
      {
        a(paramGalleryImageStruct, paramInt, paramahtm, localAIOFilePicData, bool, (File)localObject1);
        return;
      }
      localObject1 = localAIOFilePicData.a(16);
      if (localObject1 != null)
      {
        a(paramGalleryImageStruct, paramInt, paramahtm, localAIOFilePicData, (File)localObject1);
        return;
      }
      if (localAIOFilePicData.jdField_a_of_type_Long <= atpj.c())
      {
        if (localAIOFilePicData.jdField_a_of_type_Boolean) {
          paramGalleryImageStruct.setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(2130838111));
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i(" AIOGalleryAdapter", 2, "getView(): No pic");
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean) {
            break;
          }
          return;
          paramGalleryImageStruct.setImageDrawable(URLDrawableHelper.TRANSPARENT);
          this.jdField_a_of_type_Ahtp.a(localAIOFilePicData.jdField_f_of_type_Long, localAIOFilePicData.jdField_f_of_type_Int, 18);
        }
      }
      if ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean))
      {
        this.jdField_a_of_type_Ahtp.a(this.jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean = true;
      }
      paramGalleryImageStruct.setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(2130838111));
      paramGalleryImageStruct.b();
      paramGalleryImageStruct.setTag(2131296386, Float.valueOf(1.5F));
      return;
      localObject1 = localObject2;
    }
  }
  
  private void a(AIOGalleryAdapter.GalleryImageStruct paramGalleryImageStruct, int paramInt, ahtm paramahtm, AIOFilePicData paramAIOFilePicData, File paramFile)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
    localURLDrawableOptions.mFailedDrawable = URLDrawableHelper.TRANSPARENT;
    paramFile = URLDrawable.getDrawable(paramFile, localURLDrawableOptions);
    paramGalleryImageStruct.setImageDrawable(paramFile);
    if (!paramAIOFilePicData.jdField_d_of_type_Boolean) {
      if (paramAIOFilePicData.jdField_a_of_type_Long <= atpj.c())
      {
        paramFile.downloadImediatly();
        a(paramInt, paramahtm.jdField_a_of_type_Int / 100);
        this.jdField_a_of_type_Ahtp.a(paramAIOFilePicData.jdField_f_of_type_Long, paramAIOFilePicData.jdField_f_of_type_Int, 18);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i(" AIOGalleryAdapter", 2, "getView(): url is " + paramAIOFilePicData.a(16) + ", file type is " + 16);
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct = paramGalleryImageStruct;
      }
      return;
      if ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean))
      {
        this.jdField_a_of_type_Ahtp.a(this.jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean = true;
        continue;
        if ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean))
        {
          this.jdField_a_of_type_Ahtp.a(this.jdField_a_of_type_Int);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean = true;
        }
      }
    }
  }
  
  private void a(AIOGalleryAdapter.GalleryImageStruct paramGalleryImageStruct, int paramInt, ahtm paramahtm, AIOFilePicData paramAIOFilePicData, boolean paramBoolean, File paramFile)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = this.e;
    localURLDrawableOptions.mRequestHeight = this.jdField_f_of_type_Int;
    localURLDrawableOptions.mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
    localURLDrawableOptions.mPlayGifImage = true;
    if (paramBoolean == true)
    {
      paramGalleryImageStruct.setOriginalImage(true);
      File localFile = paramAIOFilePicData.a(18);
      localObject = localFile;
      if (localFile == null) {
        localObject = paramAIOFilePicData.a(16);
      }
      if (localObject != null) {
        paramGalleryImageStruct.setImageDrawable(URLDrawable.getDrawable((File)localObject, localURLDrawableOptions));
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct != null))
    {
      localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct.a();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct = null;
    }
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = this.e;
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = this.jdField_f_of_type_Int;
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
    ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
    ((URLDrawable.URLDrawableOptions)localObject).mUseExifOrientation = false;
    localObject = URLDrawable.getDrawable(paramFile, (URLDrawable.URLDrawableOptions)localObject);
    ((URLDrawable)localObject).setTag(Integer.valueOf(1));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject);
    a(paramInt, -1);
    switch (((URLDrawable)localObject).getStatus())
    {
    default: 
      paramGalleryImageStruct.setImageDrawable((Drawable)localObject);
      paramGalleryImageStruct.setOriginalImage(paramBoolean);
      if (!paramBoolean) {
        break;
      }
    }
    for (paramGalleryImageStruct = paramAIOFilePicData.jdField_d_of_type_JavaLangString;; paramGalleryImageStruct = paramAIOFilePicData.jdField_c_of_type_JavaLangString)
    {
      FileUtils.estimateFileType(paramGalleryImageStruct);
      if ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean))
      {
        this.jdField_a_of_type_Ahtp.a(this.jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean = true;
      }
      return;
      if (paramahtm.jdField_b_of_type_Int == -2) {
        paramahtm.jdField_b_of_type_Int = JpegExifReader.readOrientation(paramFile.getAbsolutePath());
      }
      paramGalleryImageStruct.setImageDrawable((Drawable)localObject);
      a(paramGalleryImageStruct, (URLDrawable)localObject, paramahtm.jdField_b_of_type_Int);
      if (((URLDrawable)localObject).getStatus() == 1) {
        bool1 = true;
      }
      a(paramInt, bool1);
      break;
      bool1 = bool2;
      if (((URLDrawable)localObject).getStatus() == 1) {
        bool1 = true;
      }
      a(paramInt, bool1);
      break;
    }
  }
  
  private void a(AIOGalleryAdapter.GalleryImageStruct paramGalleryImageStruct, ahtm paramahtm, int paramInt, AIOImageData paramAIOImageData)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
    localURLDrawableOptions.mFailedDrawable = URLDrawableHelper.TRANSPARENT;
    localURLDrawableOptions.mUseExifOrientation = false;
    if ((paramAIOImageData.jdField_b_of_type_Int == 1) && ((paramAIOImageData.jdField_d_of_type_Int & 0x2) == 2)) {
      localURLDrawableOptions.mUseAutoScaleParams = false;
    }
    paramGalleryImageStruct.setImageDrawable(URLDrawable.getDrawable(paramAIOImageData.a(8), localURLDrawableOptions));
    a(paramInt, paramahtm.jdField_a_of_type_Int / 100);
    if (QLog.isColorLevel()) {
      QLog.i(" AIOGalleryAdapter", 2, "getView(): url is " + paramAIOImageData.a(8) + ", file type is " + 8);
    }
    if (!paramAIOImageData.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_Ahtp.a(paramAIOImageData.jdField_f_of_type_Long, paramAIOImageData.jdField_f_of_type_Int, 2);
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct = paramGalleryImageStruct;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a().a(true);
      }
      if ((QLog.isDevelopLevel()) && (paramAIOImageData.jdField_d_of_type_Boolean)) {
        QQToast.a(paramGalleryImageStruct.getContext(), "Refresh temp display image", 2000).a();
      }
      return;
      if ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean))
      {
        this.jdField_a_of_type_Ahtp.a(this.jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean = true;
      }
    }
  }
  
  private void a(AIOGalleryAdapter.GalleryImageStruct paramGalleryImageStruct, ahtm paramahtm, int paramInt, AIOImageData paramAIOImageData, File paramFile)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
    localURLDrawableOptions.mFailedDrawable = URLDrawableHelper.TRANSPARENT;
    if ((paramAIOImageData.jdField_b_of_type_Int == 1) && ((paramAIOImageData.jdField_d_of_type_Int & 0x2) == 2)) {
      localURLDrawableOptions.mUseAutoScaleParams = false;
    }
    paramFile = URLDrawable.getDrawable(paramFile, localURLDrawableOptions);
    paramGalleryImageStruct.setImageDrawable(paramFile);
    if (!paramAIOImageData.jdField_g_of_type_Boolean)
    {
      paramFile.downloadImediatly();
      a(paramInt, paramahtm.jdField_a_of_type_Int / 100);
      this.jdField_a_of_type_Ahtp.a(paramAIOImageData.jdField_f_of_type_Long, paramAIOImageData.jdField_f_of_type_Int, 2);
      if (QLog.isColorLevel()) {
        QLog.i(" AIOGalleryAdapter", 2, "getView(): url is " + paramAIOImageData.a(1) + ", file type is " + 1);
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct = paramGalleryImageStruct;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a().a(paramAIOImageData.jdField_f_of_type_Boolean);
      }
      return;
    }
    paramahtm = aady.a();
    paramahtm.a();
    paramahtm.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_JavaLangString, paramAIOImageData, 640, new ahqz(this, paramInt, paramGalleryImageStruct, paramAIOImageData));
  }
  
  private void a(AIOGalleryAdapter.GalleryImageStruct paramGalleryImageStruct, ahtm paramahtm, URLDrawable paramURLDrawable, AIOImageData paramAIOImageData)
  {
    paramGalleryImageStruct.setImageDrawable(paramURLDrawable);
    String str2 = paramAIOImageData.a(4);
    String str1 = paramURLDrawable.getURL().toString();
    if (str1.equals(str2)) {
      paramGalleryImageStruct.setOriginalImage(true);
    }
    if (paramahtm.jdField_b_of_type_Int == -2) {}
    try
    {
      paramahtm.jdField_b_of_type_Int = JpegExifReader.readOrientation(paramURLDrawable.getURL().getFile());
      a(paramGalleryImageStruct, paramURLDrawable, paramahtm.jdField_b_of_type_Int);
      if (paramGalleryImageStruct.a())
      {
        paramGalleryImageStruct = paramAIOImageData.jdField_c_of_type_JavaLangString;
        paramGalleryImageStruct = FileUtils.estimateFileType(paramGalleryImageStruct);
        if (QLog.isColorLevel()) {
          QLog.i(" AIOGalleryAdapter", 2, "getView(): cache url is " + str1 + ", cache type is " + paramAIOImageData.a(paramURLDrawable.getURL().getFile()) + ",extName = + " + paramGalleryImageStruct);
        }
        if (paramAIOImageData.jdField_d_of_type_Boolean) {
          this.jdField_a_of_type_Ahtp.a(paramAIOImageData.jdField_f_of_type_Long, paramAIOImageData.jdField_f_of_type_Int, 2);
        }
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e(" AIOGalleryAdapter", 2, "read exif error", localException);
        }
        paramahtm.jdField_b_of_type_Int = 1;
        continue;
        paramGalleryImageStruct = paramAIOImageData.jdField_b_of_type_JavaLangString;
      }
    }
  }
  
  private void a(AIOImageData paramAIOImageData)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_c_of_type_Boolean = false;
      if ((paramAIOImageData.jdField_g_of_type_Int == 1) && (paramAIOImageData.jdField_h_of_type_Boolean))
      {
        bdla.b(null, "dc00898", "", "", "0X8009EF0", "0X8009EF0", 1, 0, "", "", "", "");
        return;
      }
      bdla.b(null, "dc00898", "", "", "0X8009EEF", "0X8009EEF", 1, 0, "", "", "", "");
      return;
    }
    if ((paramAIOImageData.jdField_g_of_type_Int == 1) && (paramAIOImageData.jdField_h_of_type_Boolean))
    {
      bdla.b(null, "dc00898", "", "", "0X8009EF0", "0X8009EF0", 2, 0, "", "", "", "");
      return;
    }
    bdla.b(null, "dc00898", "", "", "0X8009EEF", "0X8009EEF", 2, 0, "", "", "", "");
  }
  
  private void a(AIOImageData paramAIOImageData, int paramInt)
  {
    Object localObject2 = paramAIOImageData.a(4);
    Object localObject1;
    if (localObject2 == null)
    {
      localObject1 = paramAIOImageData.a(2);
      if (localObject1 == null) {}
    }
    for (;;)
    {
      int i;
      if (localObject2 != null)
      {
        i = 1;
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = URLDrawableHelper.TRANSPARENT;
        ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = true;
        ((URLDrawable.URLDrawableOptions)localObject2).mUseExifOrientation = false;
        if ((paramAIOImageData.jdField_b_of_type_Int == 1) && ((paramAIOImageData.jdField_d_of_type_Int & 0x2) == 2)) {
          ((URLDrawable.URLDrawableOptions)localObject2).mUseAutoScaleParams = false;
        }
        if ((i != 0) || (!paramAIOImageData.jdField_d_of_type_Boolean)) {
          break label162;
        }
        paramAIOImageData = URLDrawable.getDrawable(paramAIOImageData.a(2) + "#" + "PART", (URLDrawable.URLDrawableOptions)localObject2);
        label135:
        paramAIOImageData.setTag(Integer.valueOf(1));
        paramAIOImageData.startDownload();
        this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramAIOImageData);
      }
      label162:
      label299:
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              i = 0;
              break;
              paramAIOImageData = URLDrawable.getDrawable((File)localObject1, (URLDrawable.URLDrawableOptions)localObject2);
              break label135;
            } while ((paramAIOImageData.jdField_c_of_type_Boolean) || (paramAIOImageData.jdField_b_of_type_Boolean) || (paramAIOImageData.jdField_a_of_type_Boolean));
            if (paramAIOImageData.a(1) == null) {
              break label299;
            }
            localObject1 = URLDrawable.URLDrawableOptions.obtain();
            ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
            ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = URLDrawableHelper.TRANSPARENT;
            if ((paramAIOImageData.jdField_b_of_type_Int == 1) && ((paramAIOImageData.jdField_d_of_type_Int & 0x2) == 2)) {
              ((URLDrawable.URLDrawableOptions)localObject1).mUseAutoScaleParams = false;
            }
            URLDrawable.getDrawable(paramAIOImageData.a(1), (URLDrawable.URLDrawableOptions)localObject1).startDownload();
          } while ((!NetworkUtil.isWifiConnected(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity)) || (blvp.a(paramAIOImageData.jdField_a_of_type_Int)));
          this.jdField_a_of_type_Ahtp.a(paramAIOImageData.jdField_f_of_type_Long, paramAIOImageData.jdField_f_of_type_Int, 2);
          return;
        } while ((!NetworkUtil.isWifiConnected(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity)) || (blvp.a(paramAIOImageData.jdField_a_of_type_Int)));
        this.jdField_a_of_type_Ahtp.a(paramAIOImageData.jdField_f_of_type_Long, paramAIOImageData.jdField_f_of_type_Int, 2);
      } while (!QLog.isDevelopLevel());
      QLog.d(" AIOGalleryAdapter", 4, "onCreateView():Thumb and large pic is not exist, download it. Gallery position is " + paramInt);
      return;
      localObject1 = localObject2;
    }
  }
  
  private void a(AIOImageData paramAIOImageData, String paramString1, String paramString2, AIOGalleryAdapter.GalleryImageStruct paramGalleryImageStruct, int paramInt, ahtm paramahtm, boolean paramBoolean)
  {
    if (paramString1 != null) {
      paramAIOImageData.jdField_b_of_type_JavaLangString = paramString1;
    }
    if (paramString2 != null) {
      paramAIOImageData.jdField_a_of_type_JavaLangString = paramString2;
    }
    if (paramAIOImageData.jdField_b_of_type_Boolean)
    {
      paramString1 = paramGalleryImageStruct.a();
      if (!URLDrawable.class.isInstance(paramString1)) {
        break label496;
      }
      paramString1 = (URLDrawable)paramString1;
      paramString2 = paramString1.getURL().getRef();
    }
    for (;;)
    {
      if ((paramString1 == null) || (paramString2 == null) || ((!"PART".equals(paramString2)) && (!"DISPLAY".equals(paramString2))))
      {
        paramGalleryImageStruct.setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(2130838111));
        a(paramInt, false);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a().d();
      }
      if (QLog.isColorLevel()) {
        QLog.i(" AIOGalleryAdapter", 2, "AIOGalleryAdapter.updateView(): IMAGE_FILE_ERROR");
      }
      if ((QLog.isDevelopLevel()) && (paramAIOImageData.jdField_d_of_type_Boolean)) {
        QQToast.a(paramGalleryImageStruct.getContext(), "AIOGalleryAdapter.updateView(): error!", 2000).a();
      }
      return;
      paramString2 = paramAIOImageData.a(2);
      if (paramString2 != null)
      {
        paramString1 = paramAIOImageData.a(2);
        if (!paramBoolean) {
          break label493;
        }
        paramString1 = paramString1 + "#PART";
      }
      label493:
      for (;;)
      {
        try
        {
          paramahtm.jdField_b_of_type_Int = JpegExifReader.readOrientation(paramString2.getAbsolutePath());
          if (QLog.isColorLevel()) {
            QLog.i(" AIOGalleryAdapter", 2, "AIOGalleryAdapter.updateView(): read orientation:" + paramahtm.jdField_b_of_type_Int);
          }
          paramString2 = URLDrawable.URLDrawableOptions.obtain();
          if (paramAIOImageData.jdField_b_of_type_Int == 3)
          {
            paramahtm = paramAIOImageData.a(1);
            if (paramahtm != null)
            {
              paramahtm = URLDrawable.getDrawable(paramahtm, null);
              if (paramahtm.getStatus() == 1)
              {
                paramString2.mLoadingDrawable = paramahtm;
                paramString2.mFailedDrawable = paramahtm;
              }
            }
          }
          paramString2.mUseExifOrientation = false;
          paramString2.mPlayGifImage = true;
          paramString2 = URLDrawable.getDrawable(paramString1, paramString2);
          if ((paramString2.getStatus() == 1) && (!paramAIOImageData.jdField_d_of_type_Boolean))
          {
            paramGalleryImageStruct.setImageDrawable(paramString2);
            a(paramInt, true);
            paramString2 = FileUtils.estimateFileType(paramAIOImageData.jdField_b_of_type_JavaLangString);
            if (QLog.isColorLevel()) {
              QLog.i(" AIOGalleryAdapter", 2, "AIOGalleryAdapter.updateView(): Update large image, position=" + paramInt + "url = " + paramString1 + ",extName = " + paramString2);
            }
            paramAIOImageData.jdField_d_of_type_Boolean = paramBoolean;
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a().c();
            return;
          }
        }
        catch (Exception paramString2)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e(" AIOGalleryAdapter", 2, "read exif error", paramString2);
          continue;
          paramString2.setTag(Integer.valueOf(1));
          paramString2.startDownload();
          paramGalleryImageStruct.setDecodingDrawble(paramString2);
          continue;
        }
        if (paramAIOImageData.a(1) == null) {
          break;
        }
        paramGalleryImageStruct.setImageDrawable(URLDrawable.getDrawable(paramAIOImageData.a(1), URLDrawable.URLDrawableOptions.obtain()));
        return;
      }
      label496:
      paramString2 = null;
      paramString1 = null;
    }
  }
  
  private void a(AIOShortVideoData paramAIOShortVideoData, int paramInt)
  {
    File localFile = paramAIOShortVideoData.a(0);
    if (localFile != null)
    {
      paramAIOShortVideoData = URLDrawable.URLDrawableOptions.obtain();
      paramAIOShortVideoData.mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
      paramAIOShortVideoData.mFailedDrawable = URLDrawableHelper.TRANSPARENT;
      paramAIOShortVideoData = URLDrawable.getDrawable(localFile, paramAIOShortVideoData);
      paramAIOShortVideoData.startDownload();
      this.jdField_b_of_type_AndroidUtilSparseArray.put(paramInt, paramAIOShortVideoData);
      if (QLog.isColorLevel()) {
        QLog.i(" AIOGalleryAdapter", 2, "AIOGalleryAdapter.onCreateView(): preload thumb, position=" + paramInt);
      }
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
            if (!paramAIOShortVideoData.jdField_b_of_type_Boolean) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.i(" AIOGalleryAdapter", 2, "AIOGalleryAdapter.onCreateView(): Video error, position=" + paramInt);
          return;
          if (paramAIOShortVideoData.a(1) == null) {
            break;
          }
          if (paramAIOShortVideoData.jdField_b_of_type_Int != 0) {
            this.jdField_a_of_type_Ahtp.a(paramAIOShortVideoData.jdField_f_of_type_Long, paramAIOShortVideoData.jdField_f_of_type_Int, 0);
          }
        } while (!QLog.isColorLevel());
        QLog.i(" AIOGalleryAdapter", 2, "AIOGalleryAdapter.onCreateView(): Video exist and download thumb, position=" + paramInt);
        return;
      } while (paramAIOShortVideoData.jdField_b_of_type_Int == 0);
      this.jdField_a_of_type_Ahtp.a(paramAIOShortVideoData.jdField_f_of_type_Long, paramAIOShortVideoData.jdField_f_of_type_Int, 1);
    } while (!QLog.isDevelopLevel());
    QLog.d(" AIOGalleryAdapter", 4, "onCreateView():Thumb and video is not exist, download video only. Gallery position is " + paramInt);
  }
  
  private void a(AIOShortVideoData paramAIOShortVideoData, int paramInt, AIOGalleryAdapter.GalleryImageStruct paramGalleryImageStruct)
  {
    if (paramAIOShortVideoData.jdField_b_of_type_Int != 0)
    {
      if (!paramAIOShortVideoData.jdField_b_of_type_Boolean) {
        break label69;
      }
      paramGalleryImageStruct.setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(2130838111));
      a(paramInt, false);
      if (QLog.isColorLevel()) {
        QLog.i(" AIOGalleryAdapter", 2, "AIOGalleryAdapter.updateView(): IMAGE_FILE_ERROR, position=" + paramInt);
      }
    }
    label69:
    do
    {
      return;
      File localFile = paramAIOShortVideoData.a(1);
      if (localFile != null)
      {
        paramAIOShortVideoData = URLDrawable.URLDrawableOptions.obtain();
        paramAIOShortVideoData.mLoadingDrawable = URLDrawableHelper.TRANSLUCENT;
        paramAIOShortVideoData.mUseMemoryCache = false;
        VideoDrawable.VideoDrawableParams localVideoDrawableParams = new VideoDrawable.VideoDrawableParams();
        localVideoDrawableParams.mPlayVideoFrame = true;
        localVideoDrawableParams.mEnableAntiAlias = true;
        localVideoDrawableParams.mEnableFilter = true;
        paramAIOShortVideoData.mExtraInfo = localVideoDrawableParams;
        paramAIOShortVideoData = URLDrawable.getDrawable(localFile, paramAIOShortVideoData);
        if (paramAIOShortVideoData.getStatus() == 1) {
          paramGalleryImageStruct.setImageDrawable(paramAIOShortVideoData);
        }
        for (;;)
        {
          a(paramInt, true);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i(" AIOGalleryAdapter", 2, "AIOGalleryAdapter.updateView(): Update video, position=" + paramInt);
          return;
          paramGalleryImageStruct.setDecodingDrawble(paramAIOShortVideoData);
          paramAIOShortVideoData.startDownload();
        }
      }
    } while ((paramAIOShortVideoData.a(0) == null) || (!QLog.isColorLevel()));
    QLog.i(" AIOGalleryAdapter", 2, "AIOGalleryAdapter.updateView(): thumb downloaded, position=" + paramInt);
  }
  
  private void a(AIOShortVideoData paramAIOShortVideoData, View paramView)
  {
    this.jdField_a_of_type_Ahtp.a(paramAIOShortVideoData.jdField_f_of_type_Long, paramAIOShortVideoData.jdField_f_of_type_Int, 1);
    ((ImageView)paramView.findViewById(2131373141)).setVisibility(8);
    if (this.jdField_a_of_type_Aklo != null) {
      this.jdField_a_of_type_Aklo.a(paramAIOShortVideoData, true, false);
    }
  }
  
  private void a(AdapterView<?> paramAdapterView, AIOShortVideoData paramAIOShortVideoData, View paramView, int paramInt)
  {
    this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct = ((AIOGalleryAdapter.GalleryImageStruct)paramView);
    this.jdField_g_of_type_Int = 0;
    if (this.jdField_d_of_type_Int == -1) {
      bdla.b(null, "dc00898", "", "", "0X8007424", "0X8007424", 0, 0, "", "", "", "");
    }
    int i;
    if ((paramAdapterView != null) && (paramAdapterView.getVisibility() == 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getIntent() != null))
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getIntent();
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getIntent().getBooleanExtra("extra.FROM_AIO", false)) {
        break label233;
      }
      paramAdapterView = "1";
      i = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getIntent().getIntExtra("forward_source_uin_type", -1);
      paramView = paramView.getStringExtra("leftViewText");
      if (paramView == null) {
        break label276;
      }
      if (!paramView.equals(anvx.a(2131699571))) {
        break label240;
      }
      paramAdapterView = "2";
    }
    label276:
    for (;;)
    {
      ShortVideoUtils.reportVideoPlay(bofz.a().getAccount(), this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getIntent().getStringExtra("uin"), String.valueOf(paramAIOShortVideoData.jdField_a_of_type_Int * 1000), i, "2", paramAdapterView);
      paramAdapterView = (ahri)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Aawb.a();
      if ((paramAdapterView != null) && (paramAdapterView.s))
      {
        paramAdapterView.s = false;
        if (this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct != null) {
          this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct.b(paramInt);
        }
      }
      return;
      label233:
      paramAdapterView = "3";
      break;
      label240:
      if ((i == 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Aawb != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Aawb.a != null)) {
        paramAdapterView = "3";
      }
    }
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, ImageView paramImageView, int paramInt3)
  {
    if (FileUtils.fileExistsAndNotEmpty(paramString))
    {
      paramString = ShortVideoUtils.getThumbUrl(paramString);
      if (paramString != null)
      {
        paramString = a(paramString.toString(), paramInt1, paramInt2);
        if ((paramString instanceof URLDrawable)) {
          this.jdField_b_of_type_AndroidUtilSparseArray.put(paramInt3, (URLDrawable)paramString);
        }
        paramImageView.setImageDrawable(paramString);
      }
    }
    else
    {
      return;
    }
    QLog.d(" AIOGalleryAdapter", 2, "url  is null ");
  }
  
  private void a(boolean paramBoolean1, ahtm paramahtm, AIOImageData paramAIOImageData, boolean paramBoolean2, String paramString)
  {
    if (paramBoolean1)
    {
      int i = paramahtm.hashCode();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Int = i;
      paramahtm = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a();
      paramahtm.a(i);
      paramahtm.a(i, paramAIOImageData.jdField_a_of_type_Long, paramAIOImageData.jdField_b_of_type_Long);
      paramahtm.b(i, blvp.a(paramAIOImageData.jdField_a_of_type_Int));
      if (paramAIOImageData.e) {
        paramahtm.d(i);
      }
      if (paramString != null)
      {
        paramahtm.a(i, paramString);
        paramahtm.a(i, paramBoolean2);
      }
    }
  }
  
  private void b(ahtm paramahtm, View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_d_of_type_Boolean = true;
    paramahtm = (AIOShortVideoData)paramahtm.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
    aklw localaklw;
    if ((paramahtm != null) && (paramahtm.jdField_b_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Long != paramahtm.jdField_f_of_type_Long))
    {
      localaklw = a(paramahtm);
      if (localaklw != null) {
        break label74;
      }
      a(paramahtm, paramView);
      if (QLog.isColorLevel()) {
        QLog.i(" AIOGalleryAdapter", 2, "onItemSelect undownload notequal");
      }
    }
    label74:
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_Aklo == null);
      this.jdField_a_of_type_Aklo.a(paramView, localaklw);
      paramahtm = (ahri)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Aawb.a();
    } while ((paramahtm == null) || (!paramahtm.s));
    if (QLog.isColorLevel()) {
      QLog.i(" AIOGalleryAdapter", 2, "onItemSelect from nine");
    }
    paramahtm.s = false;
    this.jdField_a_of_type_Aklo.f();
    this.jdField_d_of_type_Long = -1L;
  }
  
  private void b(AIOGalleryAdapter.GalleryImageStruct paramGalleryImageStruct, ahtm paramahtm, int paramInt, AIOImageData paramAIOImageData)
  {
    if (!paramAIOImageData.jdField_g_of_type_Boolean)
    {
      a(paramInt, paramahtm.jdField_a_of_type_Int / 100);
      paramGalleryImageStruct.setImageDrawable(URLDrawableHelper.TRANSPARENT);
      this.jdField_a_of_type_Ahtp.a(paramAIOImageData.jdField_f_of_type_Long, paramAIOImageData.jdField_f_of_type_Int, 2);
      if (QLog.isColorLevel()) {
        QLog.i(" AIOGalleryAdapter", 2, "getView(): No pic");
      }
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a().a(paramAIOImageData.jdField_f_of_type_Boolean);
      }
      return;
      if (paramAIOImageData.jdField_h_of_type_Long <= atpj.c())
      {
        a(paramInt, paramahtm.jdField_a_of_type_Int / 100);
        paramGalleryImageStruct.setImageDrawable(URLDrawableHelper.TRANSPARENT);
        paramahtm = aady.a();
        paramahtm.a();
        paramahtm.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_JavaLangString, paramAIOImageData, 383, new ahra(this));
        a(paramInt, 0);
        paramahtm.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_JavaLangString, paramAIOImageData, 640, new ahrb(this, paramInt, paramGalleryImageStruct, paramAIOImageData));
      }
      else
      {
        if ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean = true;
        }
        paramGalleryImageStruct.setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(2130838111));
        paramGalleryImageStruct.b();
        paramGalleryImageStruct.setTag(2131296386, Float.valueOf(1.5F));
      }
    }
  }
  
  private void c(ahtm paramahtm, View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.i(" AIOGalleryAdapter", 1, "FileVideo_AP onItemSelected is FileVideodata ");
    }
    AIOFileVideoData localAIOFileVideoData = (AIOFileVideoData)paramahtm.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
    if (paramahtm.jdField_c_of_type_Boolean) {
      localAIOFileVideoData.e = true;
    }
    if (localAIOFileVideoData.a(this.jdField_a_of_type_Ahtp))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_d_of_type_Boolean) {
        this.jdField_d_of_type_Long = -1L;
      }
      if (QLog.isColorLevel()) {
        QLog.i(" AIOGalleryAdapter", 1, "FileVideo_AP onItemSelected needUrl return ");
      }
    }
    label283:
    do
    {
      int i;
      do
      {
        return;
        ahri localahri = (ahri)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Aawb.a();
        if ((localahri != null) && (localahri.k == 3)) {}
        for (i = 1;; i = 0)
        {
          if ((!paramahtm.jdField_c_of_type_Boolean) || ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_d_of_type_Boolean) && (i == 0))) {
            break label283;
          }
          if ((i == 0) && ((this.jdField_d_of_type_Long == -1L) || (this.jdField_d_of_type_Long != localAIOFileVideoData.jdField_f_of_type_Long))) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_d_of_type_Boolean = true;
          this.jdField_d_of_type_Long = -1L;
          localAIOFileVideoData.e = true;
          paramahtm = localAIOFileVideoData.a(this.jdField_a_of_type_Boolean);
          this.jdField_a_of_type_Aklo.a(paramView, paramahtm);
          this.jdField_a_of_type_Aklo.b();
          this.jdField_a_of_type_Aklo.f();
          this.jdField_a_of_type_Aklo.b(8);
          if (localahri != null)
          {
            if (QLog.isColorLevel()) {
              QLog.d(" AIOGalleryAdapter", 2, "FileVideo_AP onItemSelected, aioGalleryScene.mIsMute =  " + localahri.q);
            }
            localahri.q = false;
          }
          this.jdField_a_of_type_Boolean = false;
          return;
        }
      } while ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_d_of_type_Boolean) || ((i == 0) && ((this.jdField_d_of_type_Long == -1L) || (this.jdField_d_of_type_Long != localAIOFileVideoData.jdField_f_of_type_Long))));
      this.jdField_d_of_type_Long = -1L;
      paramahtm = localAIOFileVideoData.a(this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_Aklo.a(paramView, paramahtm);
    } while (!QLog.isColorLevel());
    QLog.i(" AIOGalleryAdapter", 1, "FileVideo_AP onItemSelected need user click ");
  }
  
  public void OnDownload(String paramString1, QQLiveDrawable.QQLiveDrawableParams paramQQLiveDrawableParams, String paramString2)
  {
    new Handler(Looper.getMainLooper()).post(new AIOGalleryAdapter.3(this));
  }
  
  public ahtm a(int paramInt)
  {
    if (this.jdField_a_of_type_Ahsn == null) {
      return null;
    }
    return this.jdField_a_of_type_Ahsn.a(paramInt);
  }
  
  public aklw a(AIOShortVideoData paramAIOShortVideoData)
  {
    Object localObject = new File(paramAIOShortVideoData.jdField_b_of_type_JavaLangString);
    long l = 0L;
    boolean bool;
    if (((File)localObject).exists())
    {
      l = ((File)localObject).length();
      if (l >= paramAIOShortVideoData.jdField_h_of_type_Long) {
        break label351;
      }
      bool = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(" AIOGalleryAdapter", 2, "carverW getVideoPlayMedioInfo longvideo GetUrlAction =" + bool);
      }
      if (bool)
      {
        ahub localahub = ahty.a().a(paramAIOShortVideoData.jdField_f_of_type_Long);
        if ((localahub == null) || (!localahub.a())) {
          break label345;
        }
        if (QLog.isColorLevel()) {
          QLog.d(" AIOGalleryAdapter", 2, "carverW getVideoPlayMedioInfo  hit cache");
        }
        localObject = new aklw();
        ((aklw)localObject).jdField_a_of_type_Boolean = true;
        ((aklw)localObject).jdField_a_of_type_ArrayOfJavaLangString = localahub.jdField_a_of_type_ArrayOfJavaLangString;
        ((aklw)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = localahub.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
        ((aklw)localObject).jdField_a_of_type_Int = localahub.jdField_a_of_type_Int;
        ((aklw)localObject).jdField_a_of_type_Long = paramAIOShortVideoData.jdField_f_of_type_Long;
        ((aklw)localObject).jdField_b_of_type_Int = paramAIOShortVideoData.jdField_f_of_type_Int;
      }
      for (;;)
      {
        if ((localObject != null) && (this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long == paramAIOShortVideoData.jdField_f_of_type_Long))
        {
          ((aklw)localObject).e = true;
          if (QLog.isColorLevel()) {
            QLog.d(" AIOGalleryAdapter", 2, new Object[] { "set playMedioInfo.isMute = ", Boolean.valueOf(this.jdField_a_of_type_Boolean), " data.id = ", Long.valueOf(paramAIOShortVideoData.jdField_f_of_type_Long) });
          }
        }
        return localObject;
        if (QLog.isColorLevel()) {
          QLog.d(" AIOGalleryAdapter", 2, "initData, #PLAY_CALLER_SHORT_VIDEO#, not exist");
        }
        bool = true;
        break;
        localObject = new aklw();
        ((aklw)localObject).jdField_a_of_type_Boolean = false;
        ((aklw)localObject).jdField_a_of_type_Long = paramAIOShortVideoData.jdField_f_of_type_Long;
        ((aklw)localObject).jdField_b_of_type_Int = paramAIOShortVideoData.jdField_f_of_type_Int;
        ((aklw)localObject).jdField_a_of_type_JavaLangString = paramAIOShortVideoData.jdField_b_of_type_JavaLangString;
        ((aklw)localObject).jdField_d_of_type_Long = l;
        continue;
        label345:
        localObject = null;
      }
      label351:
      bool = false;
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(" AIOGalleryAdapter", 2, "clearVideoDrawable");
    }
    if ((this.jdField_b_of_type_ComTencentImageURLDrawable != null) && ((this.jdField_b_of_type_ComTencentImageURLDrawable.getCurrDrawable() instanceof QQLiveDrawable)))
    {
      QQLiveDrawable localQQLiveDrawable = (QQLiveDrawable)this.jdField_b_of_type_ComTencentImageURLDrawable.getCurrDrawable();
      if (QLog.isColorLevel()) {
        QLog.d(" AIOGalleryAdapter", 2, "mVideoDrawabl=" + localQQLiveDrawable.getPlayState() + " id=" + localQQLiveDrawable.getMsgUniseq());
      }
      if (localQQLiveDrawable != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(" AIOGalleryAdapter", 2, "clearVideoDrawable recyleAndNotKeepPosition");
        }
        localQQLiveDrawable.recyleAndNotKeepPosition();
      }
    }
    this.jdField_b_of_type_ComTencentImageURLDrawable = null;
    this.jdField_d_of_type_Int = -1;
  }
  
  public void a(int paramInt, View paramView, boolean paramBoolean)
  {
    Object localObject1;
    if ((paramView instanceof AbstractImageAdapter.URLImageView2))
    {
      paramView = (AbstractImageAdapter.URLImageView2)paramView;
      localObject1 = a(paramInt);
      if (localObject1 != null) {
        break label25;
      }
    }
    label25:
    do
    {
      do
      {
        return;
        if (!AIOImageData.class.isInstance(((ahtm)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
          break;
        }
        localObject2 = (AIOImageData)((ahtm)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
      } while ((!paramBoolean) || (((AIOImageData)localObject2).a(8) == null));
      localObject1 = paramView.getDrawable();
      Object localObject2 = ((AIOImageData)localObject2).a(8);
      localObject2 = (String)localObject2 + "#" + "DISPLAY";
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject1);
      localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject1);
      localURLDrawableOptions.mPlayGifImage = true;
      localURLDrawableOptions.mUseExifOrientation = false;
      localObject1 = URLDrawable.getDrawable((String)localObject2, localURLDrawableOptions);
      paramView.setDecodingDrawble((URLDrawable)localObject1);
      ((URLDrawable)localObject1).startDownload();
      if (QLog.isColorLevel()) {
        QLog.i(" AIOGalleryAdapter", 2, "AIOGalleryAdapter.updateDisplayView(): Update dp image, position=" + paramInt);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a().b();
      return;
    } while (!AIOShortVideoData.class.isInstance(((ahtm)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData));
  }
  
  public void a(int paramInt, AIOGalleryAdapter.GalleryImageStruct paramGalleryImageStruct)
  {
    paramGalleryImageStruct = paramGalleryImageStruct.a();
    if (URLDrawable.class.isInstance(paramGalleryImageStruct)) {
      a(paramInt, (URLDrawable)paramGalleryImageStruct, true);
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2, View paramView, boolean paramBoolean)
  {
    ahtm localahtm = a(paramInt);
    if (localahtm == null) {}
    do
    {
      do
      {
        for (;;)
        {
          return;
          if (!(paramView instanceof AIOGalleryAdapter.GalleryImageStruct)) {
            break;
          }
          paramView = (AIOGalleryAdapter.GalleryImageStruct)paramView;
          if (AIOImageData.class.isInstance(localahtm.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
            a((AIOImageData)localahtm.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData, paramString1, paramString2, paramView, paramInt, localahtm, paramBoolean);
          }
          while (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean)
          {
            this.jdField_a_of_type_Ahtp.a(this.jdField_a_of_type_Int);
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean = true;
            return;
            if (AIOShortVideoData.class.isInstance(localahtm.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
              a((AIOShortVideoData)localahtm.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData, paramInt, paramView);
            } else if (AIOFilePicData.class.isInstance(localahtm.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
              a((AIOFilePicData)localahtm.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData, paramInt, paramView, localahtm, paramBoolean);
            } else if (AIOFileVideoData.class.isInstance(localahtm.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
              a((AIOFileVideoData)localahtm.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData, paramInt, paramView);
            }
          }
        }
      } while ((!(paramView instanceof RelativeLayout)) || (!AIOShortVideoData.class.isInstance(localahtm.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)));
      paramString1 = (AIOShortVideoData)localahtm.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
    } while (paramString1.jdField_b_of_type_Int != 0);
    if (QLog.isColorLevel()) {
      QLog.d(" AIOGalleryAdapter", 2, " updateView loadShortVideoCover");
    }
    paramString2 = (URLImageView)paramView.findViewById(2131373142);
    a(paramString1.jdField_a_of_type_JavaLangString, paramString1.jdField_c_of_type_Int, paramString1.jdField_d_of_type_Int, paramString2, paramInt);
  }
  
  public void a(aavo paramaavo)
  {
    super.a(paramaavo);
    this.jdField_a_of_type_Ahsn = ((ahsn)paramaavo);
    b();
  }
  
  public void a(ahrd paramahrd)
  {
    this.jdField_a_of_type_Ahrd = paramahrd;
  }
  
  public void a(aklo paramaklo)
  {
    this.jdField_a_of_type_Aklo = paramaklo;
  }
  
  public void a(Configuration paramConfiguration)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getResources().getDisplayMetrics().widthPixels;
    int j = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getResources().getDisplayMetrics().heightPixels;
    if ((i != this.e) || (j != this.jdField_f_of_type_Int))
    {
      this.e = i;
      this.jdField_f_of_type_Int = j;
      URLDrawable.clearMemoryCache();
      b();
    }
  }
  
  public void a(View paramView, int paramInt) {}
  
  public void a(URLDrawable paramURLDrawable, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt) != null) {
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramURLDrawable);
    }
  }
  
  public void a(AIORichMediaData paramAIORichMediaData)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData = paramAIORichMediaData;
    this.jdField_d_of_type_Long = paramAIORichMediaData.jdField_f_of_type_Long;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Long = paramAIORichMediaData.jdField_f_of_type_Long;
  }
  
  public void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    ahtm localahtm = a(paramInt);
    if (QLog.isColorLevel())
    {
      QLog.d(" AIOGalleryAdapter", 2, "onItemSelected isShortVideoAutoPlay=" + this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_c_of_type_Boolean + " hasDoneItemSelectUid=" + this.jdField_d_of_type_Long + " mContext.entryId=" + this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Long);
      QLog.i(" AIOGalleryAdapter", 1, "FileVideo_AP call onItemSelected ");
    }
    if ((localahtm != null) && (localahtm.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData != null) && (localahtm.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long != this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Long))
    {
      QLog.d(" AIOGalleryAdapter", 2, "onItemSelected not first image.mData.id=" + localahtm.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long + " entryId=" + this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Long);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Long = -1L;
    }
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData != null) && (localahtm != null) && (localahtm.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long != localahtm.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long))
    {
      this.jdField_a_of_type_Boolean = false;
      ahri localahri = (ahri)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Aawb.a();
      if (localahri != null) {
        localahri.q = false;
      }
      if (QLog.isColorLevel()) {
        QLog.d(" AIOGalleryAdapter", 2, "onItemSelected, set mIsmute false,  mDataOfBubble.id = " + this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long + ", image.mData.id + " + localahtm.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long);
      }
    }
    if ((localahtm != null) && ((AIOShortVideoData.class.isInstance(localahtm.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) || (AIOFileVideoData.class.isInstance(localahtm.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))))
    {
      ((AudioManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getSystemService("audio")).requestAudioFocus(null, 3, 2);
      if ((paramView == null) || (!AIOGalleryAdapter.GalleryImageStruct.class.isInstance(paramView))) {
        break label402;
      }
      a(paramInt, localahtm, paramAdapterView, paramView);
    }
    label402:
    while ((paramView == null) || (!(paramView instanceof RelativeLayout)))
    {
      return;
      ((AudioManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getSystemService("audio")).abandonAudioFocus(null);
      break;
    }
    a(localahtm, paramView);
  }
  
  public void a(boolean paramBoolean)
  {
    super.notifyDataSetChanged();
    if (QLog.isColorLevel()) {
      QLog.d(" AIOGalleryAdapter", 2, "notifyDataSetChanged(): Data changed");
    }
    b();
  }
  
  public boolean a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Long == paramLong)
    {
      if (QLog.isColorLevel()) {
        QLog.d(" AIOGalleryAdapter", 2, "carverW isNeedAutoPlay true");
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d(" AIOGalleryAdapter", 2, "carverW isNeedAutoPlay false");
    }
    return false;
  }
  
  public boolean a(AIOShortVideoData paramAIOShortVideoData, View paramView)
  {
    aklw localaklw = a(paramAIOShortVideoData);
    this.jdField_d_of_type_Long = paramAIOShortVideoData.jdField_a_of_type_Long;
    if (localaklw == null)
    {
      a(paramAIOShortVideoData, paramView);
      return false;
    }
    if (this.jdField_a_of_type_Aklo != null) {
      this.jdField_a_of_type_Aklo.a(paramView, localaklw);
    }
    return true;
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    this.jdField_b_of_type_AndroidUtilSparseArray.clear();
    if ((this.jdField_a_of_type_ComTencentImageURLDrawable != null) && (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 0)) {
      this.jdField_a_of_type_ComTencentImageURLDrawable.cancelDownload(true);
    }
    this.jdField_a_of_type_ComTencentImageURLDrawable = null;
    this.jdField_c_of_type_Int = -1;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    Object localObject = a(paramInt1);
    if (localObject == null) {}
    AIOFileVideoData localAIOFileVideoData;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (!AIOImageData.class.isInstance(((ahtm)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
              break;
            }
          } while (((AIOImageData)((ahtm)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_d_of_type_Boolean);
          super.b(paramInt1, paramInt2);
          return;
        } while (AIOShortVideoData.class.isInstance(((ahtm)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData));
        if (AIOFilePicData.class.isInstance(((ahtm)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
        {
          super.b(paramInt1, paramInt2);
          return;
        }
      } while (!AIOFileVideoData.class.isInstance(((ahtm)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData));
      localAIOFileVideoData = (AIOFileVideoData)((ahtm)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
    } while (!localAIOFileVideoData.jdField_d_of_type_Boolean);
    localAIOFileVideoData.jdField_c_of_type_Long = paramInt2;
    ahri localahri = (ahri)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Aawb.a();
    float f1 = (float)(paramInt2 * 100) / 10000.0F;
    if (localAIOFileVideoData.jdField_d_of_type_Boolean) {}
    for (localObject = anvx.a(2131699572) + FileUtil.filesizeToString(((float)localAIOFileVideoData.jdField_h_of_type_Long * f1)) + "/" + FileUtil.filesizeToString(localAIOFileVideoData.jdField_h_of_type_Long) + ")";; localObject = anvx.a(2131699530) + FileUtil.filesizeToString(((float)localAIOFileVideoData.jdField_h_of_type_Long * f1)) + "/" + FileUtil.filesizeToString(localAIOFileVideoData.jdField_h_of_type_Long) + ")")
    {
      localahri.a(localAIOFileVideoData.jdField_f_of_type_Long, f1, (String)localObject);
      return;
    }
  }
  
  public void b(int paramInt, View paramView, boolean paramBoolean)
  {
    a(paramInt, null, null, paramView, paramBoolean);
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d(" AIOGalleryAdapter", 2, "destory");
    }
    if ((this.jdField_b_of_type_ComTencentImageURLDrawable != null) && ((this.jdField_b_of_type_ComTencentImageURLDrawable.getCurrDrawable() instanceof QQLiveDrawable)))
    {
      QQLiveDrawable localQQLiveDrawable = (QQLiveDrawable)this.jdField_b_of_type_ComTencentImageURLDrawable.getCurrDrawable();
      if (localQQLiveDrawable.getCurrentPosition() > 0L)
      {
        Object localObject = a(this.jdField_d_of_type_Int);
        if ((localObject != null) && (((ahtm)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData != null) && ((((ahtm)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOShortVideoData)))
        {
          localObject = (AIOShortVideoData)((ahtm)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
          a(((AIOShortVideoData)localObject).jdField_a_of_type_Long, ((AIOShortVideoData)localObject).jdField_a_of_type_Int * 1000, localQQLiveDrawable.getCurrentPosition());
        }
      }
    }
    bhbz.a().a();
    b();
    a();
  }
  
  public void d()
  {
    if (this.jdField_g_of_type_Int == 0) {
      if (this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct != null) {
        this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct.a();
      }
    }
    while ((this.jdField_g_of_type_Int != 1) || (this.jdField_a_of_type_Aklo == null) || (!this.jdField_a_of_type_Aklo.c())) {
      return;
    }
    this.jdField_a_of_type_Aklo.h();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject;
    }
    AIOGalleryAdapter.GalleryImageStruct localGalleryImageStruct = new AIOGalleryAdapter.GalleryImageStruct(this, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity, 0);
    localGalleryImageStruct.setAdjustViewBounds(true);
    ahtm localahtm = a(paramInt);
    if ((localahtm == null) || (localahtm.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData == null)) {
      QLog.e(" AIOGalleryAdapter", 2, " getView(): position=" + paramInt + " data is null");
    }
    for (;;)
    {
      if ((localahtm != null) && (localahtm.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData != null)) {
        break label217;
      }
      localObject = localGalleryImageStruct;
      break;
      if (QLog.isColorLevel()) {
        QLog.i(" AIOGalleryAdapter", 2, " getView(): position=" + paramInt + " uid=" + localahtm.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long + " isShortVideoAutoPlay=" + this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_c_of_type_Boolean + " mDataLoaded=" + this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean + " entryid=" + this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Long);
      }
    }
    label217:
    AIOImageData localAIOImageData;
    boolean bool2;
    boolean bool1;
    label362:
    File localFile;
    if (AIOImageData.class.isInstance(localahtm.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
    {
      localObject = (AIOImageData)localahtm.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_d_of_type_Boolean = true;
      a((AIOImageData)localObject);
      localGalleryImageStruct.setCenterBtnVisiable(8);
      localAIOImageData = (AIOImageData)localahtm.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
      localGalleryImageStruct.setPosition(paramInt);
      localGalleryImageStruct.setImageInfo(localahtm);
      localGalleryImageStruct.setIgnoreLayout(false);
      localGalleryImageStruct.a(localAIOImageData.i);
      bool2 = false;
      localObject = (URLDrawable)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
      if ((localObject != null) && (((URLDrawable)localObject).getStatus() == 1))
      {
        a(localGalleryImageStruct, localahtm, (URLDrawable)localObject, localAIOImageData);
        bool2 = true;
        if (localGalleryImageStruct.a()) {}
        for (localObject = "original";; localObject = "large")
        {
          bool1 = true;
          a(bool2, localahtm, localAIOImageData, bool1, (String)localObject);
          localObject = localAIOImageData.jdField_f_of_type_Long + "_" + localAIOImageData.jdField_f_of_type_Int;
          if (!this.jdField_a_of_type_JavaUtilArrayList.contains(localObject))
          {
            this.jdField_a_of_type_Ahtp.a(localAIOImageData.jdField_f_of_type_Long, localAIOImageData.jdField_f_of_type_Int);
            this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
          }
          label451:
          localObject = localGalleryImageStruct;
          break;
        }
      }
      localFile = localAIOImageData.a(4);
      if (localFile != null) {
        break label800;
      }
      localObject = localAIOImageData.a(2);
      if (localObject == null) {}
    }
    for (;;)
    {
      if (localFile != null)
      {
        bool2 = true;
        label500:
        localObject = a(localGalleryImageStruct, localahtm, localAIOImageData, bool2, paramInt, (File)localObject);
        if (!((URLDrawable)localObject).isDownloadStarted()) {
          break label791;
        }
        if (BaseApplicationImpl.sImageCache.get(((URLDrawable)localObject).getURL().toString()) == null) {
          break label567;
        }
        bool1 = true;
        label545:
        if (!bool2) {
          break label573;
        }
        localObject = "original";
      }
      for (;;)
      {
        bool2 = true;
        break label362;
        bool2 = false;
        break label500;
        label567:
        bool1 = false;
        break label545;
        label573:
        localObject = "large";
        continue;
        if (localAIOImageData.a(8) != null)
        {
          a(localGalleryImageStruct, localahtm, paramInt, localAIOImageData);
          bool2 = true;
          localObject = null;
          bool1 = false;
          break label362;
        }
        if ((localAIOImageData.jdField_c_of_type_Boolean) || (localAIOImageData.jdField_b_of_type_Boolean) || (localAIOImageData.jdField_a_of_type_Boolean))
        {
          a(localGalleryImageStruct, paramInt);
          localObject = null;
          bool1 = false;
          break label362;
        }
        localObject = localAIOImageData.a(1);
        if (localObject != null)
        {
          a(localGalleryImageStruct, localahtm, paramInt, localAIOImageData, (File)localObject);
          bool2 = true;
          localObject = null;
          bool1 = false;
          break label362;
        }
        b(localGalleryImageStruct, localahtm, paramInt, localAIOImageData);
        localObject = null;
        bool1 = false;
        break label362;
        if (AIOShortVideoData.class.isInstance(localahtm.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
        {
          localObject = a(paramInt, localahtm);
          break;
        }
        if (AIOFilePicData.class.isInstance(localahtm.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
        {
          a(localGalleryImageStruct, paramInt, localahtm);
          break label451;
        }
        if (!AIOFileVideoData.class.isInstance(localahtm.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
          break label451;
        }
        localObject = a(localahtm, paramInt, localGalleryImageStruct);
        break;
        label791:
        localObject = null;
        bool1 = false;
      }
      label800:
      localObject = localFile;
    }
  }
  
  public View onCreateView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = (URLDrawable)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (paramView != null) {
      if (paramView.getStatus() == 3) {
        paramView.restartDownload();
      }
    }
    do
    {
      do
      {
        return null;
        paramView = a(paramInt);
      } while (paramView == null);
      if (AIOImageData.class.isInstance(paramView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
      {
        a((AIOImageData)paramView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData, paramInt);
        return null;
      }
      if (AIOShortVideoData.class.isInstance(paramView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
      {
        a((AIOShortVideoData)paramView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData, paramInt);
        return null;
      }
      if (AIOFilePicData.class.isInstance(paramView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
      {
        a((AIOFilePicData)paramView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData, paramInt);
        return null;
      }
    } while (!QLog.isColorLevel());
    QLog.i(" AIOGalleryAdapter", 2, "AIOGalleryAdapter.onCreateView(): nani...");
    return null;
  }
  
  public void onDestroyView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = (URLDrawable)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (paramView != null)
    {
      if (paramView.getStatus() == 0) {
        paramView.cancelDownload(true);
      }
      this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt);
    }
    this.jdField_b_of_type_AndroidUtilSparseArray.remove(paramInt);
    if (paramInt == this.jdField_c_of_type_Int)
    {
      if ((this.jdField_a_of_type_ComTencentImageURLDrawable != null) && (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 0)) {
        this.jdField_a_of_type_ComTencentImageURLDrawable.cancelDownload(true);
      }
      this.jdField_a_of_type_ComTencentImageURLDrawable = null;
      this.jdField_c_of_type_Int = -1;
    }
    if (QLog.isColorLevel()) {
      QLog.d(" AIOGalleryAdapter", 2, a());
    }
  }
  
  public void onLoopBack(QQLiveDrawable.QQLiveDrawableParams paramQQLiveDrawableParams, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(" AIOGalleryAdapter", 2, "onLoopBack");
    }
    a(paramQQLiveDrawableParams.msgUniseq, 1000L * paramQQLiveDrawableParams.mVideoTime, paramLong);
  }
  
  public void onShowAreaChanged(int paramInt, View paramView, RegionDrawableData paramRegionDrawableData)
  {
    if (!AIOGalleryAdapter.GalleryImageStruct.class.isInstance(paramView)) {}
    do
    {
      return;
      paramView = ((AIOGalleryAdapter.GalleryImageStruct)paramView).a();
    } while (!URLDrawable.class.isInstance(paramView));
    ((URLDrawable)paramView).updateRegionBitmap(paramRegionDrawableData);
  }
  
  public void onSlot(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (QLog.isColorLevel()) {
      QLog.i(" AIOGalleryAdapter", 2, "AIOGalleryAdapter.onSlot(): position is " + paramInt);
    }
    System.gc();
  }
  
  public void onStateChange(String paramString, QQLiveDrawable.QQLiveDrawableParams paramQQLiveDrawableParams, int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      paramObject = new StringBuilder().append("onStateChange => ").append(QQLiveImage.getStateStr(paramInt)).append(", msgUniseq=").append(paramQQLiveDrawableParams.msgUniseq).append(", extra = ").append(paramObject).append(" mSelectImagView=");
      if (this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct == null)
      {
        paramString = "null";
        QLog.d(" AIOGalleryAdapter", 2, paramString);
      }
    }
    else
    {
      if (paramInt != 6) {
        break label162;
      }
      a(paramQQLiveDrawableParams.msgUniseq, paramQQLiveDrawableParams.mVideoTime * 1000L, 1000L * paramQQLiveDrawableParams.mVideoTime);
      if (this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct != null) {
        this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      new Handler(Looper.getMainLooper()).post(new AIOGalleryAdapter.1(this));
    }
    label162:
    while (paramInt != 2)
    {
      return;
      paramString = "not null";
      break;
    }
    new Handler(Looper.getMainLooper()).post(new AIOGalleryAdapter.2(this));
  }
  
  public void onViewDetached(int paramInt, View paramView, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (paramInt == this.jdField_c_of_type_Int)
    {
      if ((this.jdField_a_of_type_ComTencentImageURLDrawable != null) && (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 0)) {
        this.jdField_a_of_type_ComTencentImageURLDrawable.cancelDownload(true);
      }
      this.jdField_a_of_type_ComTencentImageURLDrawable = null;
      this.jdField_c_of_type_Int = -1;
      if (QLog.isColorLevel()) {
        QLog.d(" AIOGalleryAdapter", 2, "destory rawDrawable, position: " + paramInt);
      }
    }
    ahtm localahtm;
    if (AIOGalleryAdapter.GalleryImageStruct.class.isInstance(paramView))
    {
      paramViewGroup = (AIOGalleryAdapter.GalleryImageStruct)paramView;
      localahtm = a(paramInt);
      if (localahtm != null) {
        break label102;
      }
    }
    label102:
    do
    {
      do
      {
        AIORichMediaData localAIORichMediaData;
        do
        {
          return;
          localAIORichMediaData = localahtm.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
          if (AIOImageData.class.isInstance(localAIORichMediaData))
          {
            if (URLDrawable.class.isInstance(((AIOGalleryAdapter.GalleryImageStruct)paramView).a())) {
              this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a().b(localahtm.hashCode());
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a().a();
            return;
          }
        } while (!AIOShortVideoData.class.isInstance(localAIORichMediaData));
        paramView = (URLDrawable)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
        if (paramView == null) {
          break;
        }
        paramViewGroup.setImageDrawable(paramView);
      } while (!QLog.isColorLevel());
      QLog.i(" AIOGalleryAdapter", 2, "AIOGalleryAdapter.onViewDetached(): Use thumb cache replace video.");
      return;
      paramViewGroup.setImageDrawable(URLDrawableHelper.TRANSPARENT);
    } while (!QLog.isColorLevel());
    QLog.i(" AIOGalleryAdapter", 2, "AIOGalleryAdapter.onViewDetached(): No thumb, use TRANSPARENT");
  }
  
  public void onscaleBegin(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AIOGalleryAdapter.GalleryImageStruct localGalleryImageStruct = (AIOGalleryAdapter.GalleryImageStruct)paramView;
    paramView = localGalleryImageStruct.a();
    paramViewGroup = localGalleryImageStruct.a();
    if (((paramView instanceof URLDrawable)) && (((URLDrawable)paramView).isFakeSize()) && (paramViewGroup == null))
    {
      paramView = ((URLDrawable)paramView).getURL();
      if (("file".equals(paramView.getProtocol())) && (paramView.getRef() == null))
      {
        if ((paramInt != this.jdField_c_of_type_Int) || (this.jdField_a_of_type_ComTencentImageURLDrawable == null)) {
          break label152;
        }
        paramViewGroup = this.jdField_a_of_type_ComTencentImageURLDrawable;
        paramView = paramViewGroup;
        if (QLog.isColorLevel())
        {
          paramView = paramViewGroup;
          if (this.jdField_a_of_type_ComTencentImageURLDrawable != null)
          {
            QLog.d(" AIOGalleryAdapter", 2, "use exist raw drawable");
            paramView = paramViewGroup;
          }
        }
        if (paramView.getStatus() != 1) {
          break label281;
        }
        localGalleryImageStruct.setIgnoreLayout(true);
        localGalleryImageStruct.setImageDrawable(paramView);
        localGalleryImageStruct.setIgnoreLayout(false);
      }
    }
    label152:
    label281:
    while (!(paramView instanceof SkinnableBitmapDrawable)) {
      for (;;)
      {
        paramView = a(paramInt);
        if (paramView != null) {
          break;
        }
        return;
        if ((QLog.isColorLevel()) && (this.jdField_a_of_type_ComTencentImageURLDrawable != null)) {
          QLog.d(" AIOGalleryAdapter", 2, "rawDrawable is exist");
        }
        paramView = paramView.toString() + "#" + "NOSAMPLE";
        paramViewGroup = URLDrawable.URLDrawableOptions.obtain();
        paramViewGroup.mUseExifOrientation = false;
        paramViewGroup.mUseMemoryCache = false;
        paramViewGroup = URLDrawable.getDrawable(paramView, paramViewGroup);
        paramViewGroup.setTag(Integer.valueOf(2));
        this.jdField_a_of_type_ComTencentImageURLDrawable = paramViewGroup;
        this.jdField_c_of_type_Int = paramInt;
        paramView = paramViewGroup;
        if (QLog.isColorLevel())
        {
          QLog.d(" AIOGalleryAdapter", 2, "create rawDrawable, position:" + paramInt);
          paramView = paramViewGroup;
          continue;
          localGalleryImageStruct.setDecodingDrawble(paramView);
          paramView.startDownload();
        }
      }
    }
    return;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a().c(paramView.hashCode());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryAdapter
 * JD-Core Version:    0.7.0.1
 */