package com.tencent.biz.pubaccount.readinjoy.view.pullrefresh;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioAttributes.Builder;
import android.media.AudioManager;
import android.media.SoundPool;
import android.media.SoundPool.Builder;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.skin.CommonSkinRes;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoyRefreshManager;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoySkinManager;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshData;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshRes;
import com.tencent.biz.pubaccount.readinjoy.view.SlideActiveAnimController;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.widget.IPullRefreshHeader;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ReadInJoySkinAnimManager
  extends ReadInJoyAnimBaseManager
{
  private SoundPool jdField_a_of_type_AndroidMediaSoundPool;
  private ReadInJoySkinAnimManager.ResourceHandler jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshReadInJoySkinAnimManager$ResourceHandler;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ReadInJoySkinAnimManager.2(this);
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<ReadInJoySkinAnimManager.PngWrapper> jdField_a_of_type_JavaUtilArrayList;
  private List<String> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = -2;
  private Context jdField_b_of_type_AndroidContentContext;
  private SoundPool jdField_b_of_type_AndroidMediaSoundPool;
  private String jdField_b_of_type_JavaLangString;
  private ArrayList<ReadInJoySkinAnimManager.PngWrapper> jdField_b_of_type_JavaUtilArrayList;
  private volatile boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = -2;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int = -2;
  private boolean jdField_e_of_type_Boolean = true;
  private int jdField_f_of_type_Int = -2;
  private boolean jdField_f_of_type_Boolean = false;
  private int jdField_g_of_type_Int;
  private boolean jdField_g_of_type_Boolean = false;
  private int jdField_h_of_type_Int = 0;
  private boolean jdField_h_of_type_Boolean = false;
  private int jdField_i_of_type_Int;
  private boolean jdField_i_of_type_Boolean = false;
  private int j = -2;
  private int k = 1;
  private int l = -1;
  
  public ReadInJoySkinAnimManager(Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshReadInJoySkinAnimManager$ResourceHandler = new ReadInJoySkinAnimManager.ResourceHandler(this);
    if ((float)Runtime.getRuntime().maxMemory() <= 1.415578E+008F) {
      bool = true;
    }
    this.jdField_i_of_type_Boolean = bool;
    ReadInJoyRefreshManager localReadInJoyRefreshManager;
    if ((paramContext instanceof BaseActivity))
    {
      localReadInJoyRefreshManager = (ReadInJoyRefreshManager)((BaseActivity)paramContext).app.getManager(QQManagerFactory.READ_INJOY_REFRESH_MANAGER);
      if ((localReadInJoyRefreshManager.a() != 1) || (!localReadInJoyRefreshManager.b())) {
        break label321;
      }
      this.jdField_a_of_type_JavaUtilList = RefreshRes.a();
      this.jdField_d_of_type_Int = RefreshRes.a();
      this.jdField_a_of_type_JavaLangString = RefreshRes.c();
      this.jdField_b_of_type_JavaLangString = localReadInJoyRefreshManager.a();
      this.jdField_c_of_type_JavaLangString = RefreshRes.e();
      this.l = 1;
      if (this.jdField_b_of_type_Int == -2)
      {
        this.jdField_b_of_type_Int = ((int)(((BaseActivity)paramContext).getWindowManager().getDefaultDisplay().getHeight() * 0.24F));
        if (this.jdField_d_of_type_Int != 1) {
          break label380;
        }
        this.jdField_c_of_type_Int = ((int)(((BaseActivity)paramContext).getWindowManager().getDefaultDisplay().getWidth() * 0.53F));
      }
    }
    for (;;)
    {
      if (this.k == 1)
      {
        this.k = 2;
        ThreadManager.post(new ReadInJoySkinAnimManager.InitResourceRunnable(this, true), 8, null, true);
      }
      return;
      label321:
      this.jdField_a_of_type_JavaUtilList = CommonSkinRes.a();
      this.jdField_d_of_type_Int = CommonSkinRes.b();
      this.jdField_a_of_type_JavaLangString = CommonSkinRes.d();
      this.jdField_b_of_type_JavaLangString = ((ReadInJoySkinManager)((BaseActivity)paramContext).app.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER)).a();
      this.jdField_c_of_type_JavaLangString = CommonSkinRes.e();
      this.l = 2;
      break;
      label380:
      if (this.jdField_d_of_type_Int == 2)
      {
        if (localReadInJoyRefreshManager.a()) {
          this.jdField_c_of_type_Int = ((BaseActivity)paramContext).getWindowManager().getDefaultDisplay().getWidth();
        } else {
          this.jdField_c_of_type_Int = ((int)(((BaseActivity)paramContext).getWindowManager().getDefaultDisplay().getWidth() * 1.0F));
        }
      }
      else if (this.jdField_d_of_type_Int == 3) {
        this.jdField_c_of_type_Int = ((BaseActivity)paramContext).getWindowManager().getDefaultDisplay().getWidth();
      }
    }
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    int m;
    if (paramInt2 > 0)
    {
      m = (int)Math.floor(7340032.0F / paramInt2);
      if (paramInt1 <= m) {}
    }
    for (paramInt1 = (int)Math.ceil(paramInt1 / m);; paramInt1 = 1)
    {
      m = paramInt1;
      if (paramInt1 <= 0)
      {
        QLog.e("ReadInJoySkinAnimManager", 1, "getSamplingRate invalid samplingRate. Here simpleBitmapSize = " + paramInt2 + " samplingRate = " + paramInt1);
        m = 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoySkinAnimManager", 1, "getSamplingRate simpleBitmapSize = " + paramInt2 + " samplingRate = " + m);
      }
      return m;
    }
  }
  
  private int a(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return -1;
    }
    if (Build.VERSION.SDK_INT >= 12) {
      return paramBitmap.getByteCount();
    }
    return paramBitmap.getRowBytes() * paramBitmap.getHeight();
  }
  
  private int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 <= 0) {
      return 1;
    }
    int n = paramOptions.outWidth;
    if (n > paramInt1)
    {
      int m = 2;
      int i1 = n / 2;
      for (;;)
      {
        n = m;
        if (i1 / m < paramInt1) {
          break;
        }
        m *= 2;
      }
    }
    n = 1;
    double d1 = Math.sqrt(1.0D * (paramInt2 * paramInt3) / 10485760.0D);
    while (n < d1) {
      n *= 2;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoySkinAnimManager", 1, "calculateInSampleSize inSampleSize = " + n);
    }
    return n;
  }
  
  private int a(String paramString)
  {
    int m = 0;
    paramString = new StringBuilder(this.jdField_a_of_type_JavaLangString).append("refreshAnimatePictures").append("/").append(paramString);
    BitmapFactory.Options localOptions;
    if (new File(paramString.toString()).exists())
    {
      localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = false;
      localOptions.inPreferredConfig = Bitmap.Config.ARGB_4444;
    }
    try
    {
      paramString = ImageUtil.a(paramString.toString(), localOptions);
      int n = a(paramString);
      m = n;
      if (QLog.isColorLevel())
      {
        QLog.d("ReadInJoySkinAnimManager", 1, "getSamplingRate simpleBitmapSize = " + n);
        m = n;
      }
      return m;
    }
    catch (OutOfMemoryError paramString)
    {
      QLog.e("ReadInJoySkinAnimManager", 1, "getPngDrawable oom = " + paramString);
    }
    return 0;
  }
  
  private Drawable a(String paramString1, String paramString2, String paramString3, Resources paramResources, int paramInt1, int paramInt2)
  {
    paramString2 = new StringBuilder(paramString1).append(paramString2).append("/").append(paramString3);
    if (new File(paramString2.toString()).exists())
    {
      paramString3 = new BitmapFactory.Options();
      if ((this.j == -2) && (this.jdField_c_of_type_Int != -2))
      {
        paramString3.inJustDecodeBounds = true;
        ImageUtil.a(paramString2.toString(), paramString3);
        if (this.jdField_d_of_type_Int == 1) {
          this.j = a(paramString3, this.jdField_c_of_type_Int, paramInt1, paramInt2);
        }
      }
      else
      {
        if (this.j != -2)
        {
          paramString3.inSampleSize = this.j;
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoySkinAnimManager", 1, "mSampleSize = " + this.j);
          }
        }
        paramString3.inJustDecodeBounds = false;
        paramString3.inPreferredConfig = Bitmap.Config.ARGB_4444;
      }
    }
    for (;;)
    {
      try
      {
        paramString2 = ImageUtil.a(paramString2.toString(), paramString3);
        paramString1 = paramString2;
        if (paramString1 == null) {
          break label334;
        }
        return new BitmapDrawable(paramResources, paramString1);
      }
      catch (OutOfMemoryError paramString2)
      {
        ReportController.b(null, "dc00899", "BizTechReport", "", "kan_dian_skin_pull_refresh", "decode_bitmap_oom", paramString3.inSampleSize, paramInt1, this.jdField_b_of_type_JavaLangString, String.valueOf(paramString3.outHeight), String.valueOf(paramString3.outWidth), null);
        QLog.e("ReadInJoySkinAnimManager", 1, "getPngDrawable oom = " + paramString2 + " resFolderPath:" + paramString1);
        return null;
      }
      if (this.jdField_d_of_type_Int == 2)
      {
        this.j = a(paramString3, this.jdField_c_of_type_Int, paramInt1, paramInt2);
        break;
      }
      if (this.jdField_d_of_type_Int != 3) {
        break;
      }
      this.j = a(paramString3, this.jdField_c_of_type_Int, paramInt1, paramInt2);
      break;
      label334:
      QLog.e("ReadInJoySkinAnimManager", 1, "getPngDrawable bitmap = null");
      return null;
      paramString1 = null;
    }
  }
  
  private SoundPool a()
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      SoundPool.Builder localBuilder = new SoundPool.Builder();
      localBuilder.setMaxStreams(1);
      localBuilder.setAudioAttributes(new AudioAttributes.Builder().build());
      return localBuilder.build();
    }
    return new SoundPool(1, 3, 0);
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {}
    for (int n = this.jdField_a_of_type_JavaUtilArrayList.size();; n = 0)
    {
      if ((n > 0) && (this.jdField_d_of_type_Int == 1)) {
        if (paramInt >= this.jdField_b_of_type_Int) {
          paramInt = 100;
        }
      }
      for (;;)
      {
        if (paramInt == 100) {
          if (this.jdField_e_of_type_Int != n - 1)
          {
            this.jdField_e_of_type_Int = (n - 1);
            a(((ReadInJoySkinAnimManager.PngWrapper)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_e_of_type_Int)).jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          }
        }
        label342:
        for (;;)
        {
          return;
          if ((paramInt >= this.jdField_b_of_type_Int) || (paramInt <= 0) || (this.jdField_b_of_type_Int == 0)) {
            break label344;
          }
          paramInt = paramInt * 100 / this.jdField_b_of_type_Int;
          break;
          int m = 0;
          label117:
          if (m < n) {
            if (((ReadInJoySkinAnimManager.PngWrapper)this.jdField_a_of_type_JavaUtilArrayList.get(m)).jdField_a_of_type_Int < paramInt) {}
          }
          for (;;)
          {
            if (m == this.jdField_e_of_type_Int) {
              break label342;
            }
            this.jdField_e_of_type_Int = m;
            a(((ReadInJoySkinAnimManager.PngWrapper)this.jdField_a_of_type_JavaUtilArrayList.get(m)).jdField_a_of_type_AndroidGraphicsDrawableDrawable);
            return;
            m += 1;
            break label117;
            if ((n > 0) && (this.jdField_d_of_type_Int == 2))
            {
              if (this.jdField_e_of_type_Int == -2)
              {
                this.jdField_e_of_type_Int = ((int)Math.floor(Math.random() * n));
                this.jdField_f_of_type_Int = this.jdField_e_of_type_Int;
                a(((ReadInJoySkinAnimManager.PngWrapper)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_e_of_type_Int)).jdField_a_of_type_AndroidGraphicsDrawableDrawable);
              }
              if (this.jdField_e_of_type_Int == this.jdField_f_of_type_Int) {
                break;
              }
              this.jdField_e_of_type_Int = this.jdField_f_of_type_Int;
              a(((ReadInJoySkinAnimManager.PngWrapper)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_e_of_type_Int)).jdField_a_of_type_AndroidGraphicsDrawableDrawable);
              return;
            }
            if ((n <= 0) || (this.jdField_d_of_type_Int != 3) || (this.jdField_f_of_type_Boolean)) {
              break;
            }
            this.jdField_f_of_type_Boolean = true;
            ((SkinPullRefreshHeader)this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader).removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
            ((SkinPullRefreshHeader)this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader).post(this.jdField_a_of_type_JavaLangRunnable);
            return;
            m = 0;
          }
        }
        label344:
        paramInt = 0;
      }
    }
  }
  
  private void a(Drawable paramDrawable)
  {
    SkinPullRefreshHeader localSkinPullRefreshHeader = (SkinPullRefreshHeader)this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader;
    if (!this.jdField_a_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      localSkinPullRefreshHeader.a(paramDrawable, bool);
      return;
    }
  }
  
  private void a(List<String> paramList, ArrayList<ReadInJoySkinAnimManager.PngWrapper> paramArrayList, int paramInt)
  {
    Resources localResources = BaseApplicationImpl.getContext().getResources();
    String str1 = this.jdField_a_of_type_JavaLangString;
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      Drawable localDrawable = a(str1, "refreshRandomPictures", str2, localResources, paramList.size(), paramInt);
      if (localDrawable != null) {
        paramArrayList.add(new ReadInJoySkinAnimManager.PngWrapper(str2, 0, localDrawable));
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoySkinAnimManager", 1, "initResources size = " + paramArrayList.size());
    }
    this.jdField_b_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshReadInJoySkinAnimManager$ResourceHandler.sendEmptyMessage(1);
  }
  
  private void a(List<String> paramList, ArrayList<ReadInJoySkinAnimManager.PngWrapper> paramArrayList, int paramInt1, int paramInt2)
  {
    Resources localResources = BaseApplicationImpl.getContext().getResources();
    String str1 = this.jdField_a_of_type_JavaLangString;
    int n = paramList.size();
    int m = 0;
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      m += 1;
      if ((m % paramInt2 == 0) || (m == n))
      {
        int i1 = b(str2);
        Drawable localDrawable = a(str1, "refreshAnimatePictures", str2, localResources, paramList.size(), paramInt1);
        if ((i1 != -2) && (localDrawable != null)) {
          paramArrayList.add(new ReadInJoySkinAnimManager.PngWrapper(str2, i1, localDrawable));
        }
      }
    }
    Collections.sort(paramArrayList);
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoySkinAnimManager", 1, "initResources size = " + paramArrayList.size());
    }
    this.jdField_b_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshReadInJoySkinAnimManager$ResourceHandler.sendEmptyMessage(1);
  }
  
  private int b(String paramString)
  {
    String str = paramString.substring(0, paramString.length() - 4);
    if (str != null) {
      try
      {
        int m = Integer.parseInt(str);
        if ((m >= 0) && (m <= 100)) {
          return m;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        QLog.e("ReadInJoySkinAnimManager", 1, "getPNGIndex NumberFormatException pngName = " + paramString);
      }
    }
    return -2;
  }
  
  private void b(int paramInt)
  {
    boolean bool;
    if (this.jdField_b_of_type_Boolean)
    {
      if ((paramInt < this.jdField_i_of_type_Int) || (this.jdField_c_of_type_Boolean)) {
        break label99;
      }
      bool = true;
      this.jdField_d_of_type_Boolean = bool;
      if (this.jdField_d_of_type_Boolean)
      {
        AppInterface localAppInterface = ((BaseActivity)this.jdField_b_of_type_AndroidContentContext).getAppInterface();
        if ((localAppInterface != null) && (((SharedPreUtils.t(this.jdField_b_of_type_AndroidContentContext, localAppInterface.getCurrentAccountUin())) && (this.l == 2)) || (this.l == 1))) {
          j();
        }
      }
      if (paramInt < this.jdField_i_of_type_Int) {
        break label104;
      }
      this.jdField_c_of_type_Boolean = true;
    }
    label99:
    label104:
    while (paramInt >= this.jdField_i_of_type_Int)
    {
      return;
      bool = false;
      break;
    }
    this.jdField_c_of_type_Boolean = false;
  }
  
  private void b(boolean paramBoolean)
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if ((localList == null) || (localList.size() <= 0)) {
      return;
    }
    c(paramBoolean);
    int n = a((String)localList.get(0));
    if ((this.jdField_i_of_type_Boolean) && ((this.jdField_d_of_type_Int == 1) || (this.jdField_d_of_type_Int == 3))) {}
    for (int m = a(localList.size(), n);; m = 1)
    {
      ArrayList localArrayList = new ArrayList();
      if ((this.jdField_d_of_type_Int == 1) || (this.jdField_d_of_type_Int == 2) || (this.jdField_d_of_type_Int == 3)) {
        ReportController.b(null, "dc00899", "BizTechReport", "", "kan_dian_skin_pull_refresh", "decode_bitmap_times", 0, 0, this.jdField_b_of_type_JavaLangString, null, null, null);
      }
      if ((this.jdField_d_of_type_Int == 1) || (this.jdField_d_of_type_Int == 3))
      {
        a(localList, localArrayList, n, m);
        return;
      }
      if (this.jdField_d_of_type_Int != 2) {
        break;
      }
      a(localList, localArrayList, n);
      return;
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_c_of_type_JavaLangString == null) {
        break label51;
      }
      localSoundPool = a();
      if (localSoundPool == null) {
        break label35;
      }
      this.jdField_b_of_type_AndroidMediaSoundPool = localSoundPool;
    }
    label35:
    label51:
    while (!QLog.isColorLevel())
    {
      SoundPool localSoundPool;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshReadInJoySkinAnimManager$ResourceHandler.sendEmptyMessage(2);
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.d("ReadInJoySkinAnimManager", 1, "init soundpool failed");
      return;
    }
    QLog.d("ReadInJoySkinAnimManager", 1, "voicePath = null");
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader != null)
    {
      ((SkinPullRefreshHeader)this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader).removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_f_of_type_Boolean = false;
    }
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null)
    {
      this.jdField_a_of_type_JavaUtilArrayList = this.jdField_b_of_type_JavaUtilArrayList;
      if ((this.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader != null))
      {
        if (!this.jdField_h_of_type_Boolean) {
          break label98;
        }
        a(((ReadInJoySkinAnimManager.PngWrapper)this.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        ((SkinPullRefreshHeader)this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader).removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        ((SkinPullRefreshHeader)this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader).post(this.jdField_a_of_type_JavaLangRunnable);
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_JavaUtilArrayList = null;
      this.k = 3;
      return;
      label98:
      a(((ReadInJoySkinAnimManager.PngWrapper)this.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      continue;
      QLog.e("ReadInJoySkinAnimManager", 1, "setPngArray mRefreshPullDownPNGS.size = " + this.jdField_a_of_type_JavaUtilArrayList.size());
    }
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_AndroidMediaSoundPool == null) {
      this.jdField_a_of_type_AndroidMediaSoundPool = this.jdField_b_of_type_AndroidMediaSoundPool;
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidMediaSoundPool = null;
      String str = this.jdField_c_of_type_JavaLangString;
      if ((str != null) && (new File(str).exists()) && (this.jdField_a_of_type_AndroidMediaSoundPool != null))
      {
        this.jdField_g_of_type_Int = this.jdField_a_of_type_AndroidMediaSoundPool.load(str, 0);
        long l1 = System.currentTimeMillis();
        this.jdField_a_of_type_AndroidMediaSoundPool.setOnLoadCompleteListener(new ReadInJoySkinAnimManager.1(this, l1));
      }
      return;
      QLog.e("ReadInJoySkinAnimManager", 1, "setSoundPool mRefreshPullDownPNGS.size != null");
    }
  }
  
  private void j()
  {
    float f2 = 0.5F;
    AudioManager localAudioManager = (AudioManager)this.jdField_b_of_type_AndroidContentContext.getSystemService("audio");
    float f1 = f2;
    if (localAudioManager != null)
    {
      float f3 = localAudioManager.getStreamVolume(3);
      m = localAudioManager.getStreamMaxVolume(3);
      f1 = f2;
      if (m != 0) {
        f1 = f3 / m;
      }
    }
    if (localAudioManager != null) {}
    for (int m = localAudioManager.getRingerMode();; m = 2)
    {
      if (m == 2) {
        this.jdField_h_of_type_Int = this.jdField_a_of_type_AndroidMediaSoundPool.play(this.jdField_g_of_type_Int, f1, f1, 0, 0, 1.0F);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoySkinAnimManager", 1, "playSound volume = " + f1 + " RINGER_MODE_NORMAL = " + 2);
      }
      return;
    }
  }
  
  public int a()
  {
    this.jdField_i_of_type_Int = this.jdField_b_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298917);
    return this.jdField_i_of_type_Int;
  }
  
  public View a(ViewGroup paramViewGroup)
  {
    boolean bool2 = true;
    Object localObject1;
    AbsListView.LayoutParams localLayoutParams;
    int m;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader = ((SkinPullRefreshHeader)LayoutInflater.from(this.jdField_b_of_type_AndroidContentContext).inflate(2131563021, paramViewGroup, false));
      if (((this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader instanceof RelativeLayout)) && (this.jdField_b_of_type_Int > 0))
      {
        localObject1 = (RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader;
        localLayoutParams = (AbsListView.LayoutParams)((RelativeLayout)localObject1).getLayoutParams();
        paramViewGroup = null;
        if ((this.jdField_d_of_type_Int != 1) && (this.jdField_d_of_type_Int != 3)) {
          break label507;
        }
        paramViewGroup = "refreshAnimatePictures";
        Object localObject2 = this.jdField_a_of_type_JavaUtilList;
        if ((localObject2 == null) || (((List)localObject2).isEmpty()) || (paramViewGroup == null)) {
          break label551;
        }
        paramViewGroup = new StringBuilder(this.jdField_a_of_type_JavaLangString).append(paramViewGroup).append("/").append((String)((List)localObject2).get(0));
        if (!new File(paramViewGroup.toString()).exists()) {
          break label551;
        }
        localObject2 = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
        ImageUtil.a(paramViewGroup.toString(), (BitmapFactory.Options)localObject2);
        if ((this.jdField_c_of_type_Int == -2) || (((BitmapFactory.Options)localObject2).outWidth == 0)) {
          break label546;
        }
        m = ((BitmapFactory.Options)localObject2).outHeight * this.jdField_c_of_type_Int / ((BitmapFactory.Options)localObject2).outWidth;
        label227:
        n = m;
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoySkinAnimManager", 1, "getRefreshView options.outHeight = " + ((BitmapFactory.Options)localObject2).outHeight + " options.outWidth = " + ((BitmapFactory.Options)localObject2).outWidth);
        }
      }
    }
    label291:
    label551:
    for (int n = m;; n = 0)
    {
      if (n != 0)
      {
        localLayoutParams.height = n;
        ((RelativeLayout)localObject1).setLayoutParams(localLayoutParams);
        if (this.jdField_c_of_type_Int != -2)
        {
          paramViewGroup = (ImageView)((RelativeLayout)localObject1).findViewById(2131376855);
          localObject1 = paramViewGroup.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject1).width = this.jdField_c_of_type_Int;
          paramViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoySkinAnimManager", 1, "getRefreshView sDisplayHeight = " + this.jdField_b_of_type_Int + " sDisplayWidth = " + this.jdField_c_of_type_Int + " refreshType = " + this.jdField_d_of_type_Int);
        }
        if ((this.jdField_b_of_type_AndroidContentContext instanceof BaseActivity))
        {
          paramViewGroup = (ReadInJoyRefreshManager)((BaseActivity)this.jdField_b_of_type_AndroidContentContext).app.getManager(QQManagerFactory.READ_INJOY_REFRESH_MANAGER);
          localObject1 = paramViewGroup.a(this.jdField_b_of_type_AndroidContentContext, 0);
          if ((localObject1 == null) || (!((RefreshData)localObject1).isAD)) {
            break label534;
          }
          bool1 = true;
          label458:
          this.jdField_a_of_type_Boolean = bool1;
          localObject1 = (SkinPullRefreshHeader)this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader;
          if ((paramViewGroup.a() != 1) || (!this.jdField_a_of_type_Boolean)) {
            break label540;
          }
        }
      }
      for (boolean bool1 = bool2;; bool1 = false)
      {
        ((SkinPullRefreshHeader)localObject1).setAdTabVisibility(bool1);
        return (View)this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader;
        label507:
        if (this.jdField_d_of_type_Int != 2) {
          break;
        }
        paramViewGroup = "refreshRandomPictures";
        break;
        localLayoutParams.height = this.jdField_b_of_type_Int;
        break label291;
        bool1 = false;
        break label458;
      }
      m = 0;
      break label227;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader.a(0L);
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader instanceof SkinPullRefreshHeader)) {
      ((SkinPullRefreshHeader)this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader).a(false, "");
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader.ah_();
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController.b())) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController.a((SkinPullRefreshHeader)this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader);
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {}
    for (int n = this.jdField_a_of_type_JavaUtilArrayList.size();; n = 0)
    {
      int m;
      if ((n > 0) && (this.jdField_d_of_type_Int == 1))
      {
        int i1 = this.jdField_i_of_type_Int * 100 / this.jdField_b_of_type_Int;
        m = 0;
        if (m >= n) {
          break label291;
        }
        if (((ReadInJoySkinAnimManager.PngWrapper)this.jdField_a_of_type_JavaUtilArrayList.get(m)).jdField_a_of_type_Int < i1) {}
      }
      for (;;)
      {
        this.jdField_e_of_type_Int = m;
        a(((ReadInJoySkinAnimManager.PngWrapper)this.jdField_a_of_type_JavaUtilArrayList.get(m)).jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        for (;;)
        {
          this.jdField_c_of_type_Boolean = false;
          return;
          m += 1;
          break;
          if ((n > 0) && (this.jdField_d_of_type_Int == 2))
          {
            this.jdField_e_of_type_Int = ((int)Math.floor(Math.random() * n));
            this.jdField_f_of_type_Int = this.jdField_e_of_type_Int;
            a(((ReadInJoySkinAnimManager.PngWrapper)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_e_of_type_Int)).jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          }
          else if ((n > 0) && (this.jdField_d_of_type_Int == 3))
          {
            this.jdField_e_of_type_Int = 0;
            ((SkinPullRefreshHeader)this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader).removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
            ((SkinPullRefreshHeader)this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader).post(this.jdField_a_of_type_JavaLangRunnable);
          }
        }
        label291:
        m = 0;
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader == null) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController.b())) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController.a((SkinPullRefreshHeader)this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader, paramInt1, paramInt2);
      }
      a(paramInt1);
      b(paramInt1);
    } while ((!this.jdField_e_of_type_Boolean) || ((this.jdField_d_of_type_Int != 2) && (this.jdField_d_of_type_Int != 1) && (this.jdField_d_of_type_Int != 3)));
    paramInt1 = 0;
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      paramInt1 = this.jdField_a_of_type_JavaUtilArrayList.size();
    }
    ReportController.b(null, "dc00899", "BizTechReport", "", "kan_dian_skin_pull_refresh", "refresh_times", this.jdField_d_of_type_Int, paramInt1, this.jdField_b_of_type_JavaLangString, null, null, null);
    String str = this.jdField_c_of_type_JavaLangString;
    if ((str != null) && (new File(str).exists()))
    {
      paramInt1 = 1;
      if (this.jdField_b_of_type_Boolean) {
        paramInt1 = 2;
      }
      ReportController.b(null, "dc00899", "BizTechReport", "", "kan_dian_skin_pull_refresh", "sound_play_times", paramInt1, 0, this.jdField_b_of_type_JavaLangString, null, null, null);
    }
    this.jdField_e_of_type_Boolean = false;
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    super.a(paramInt, paramBoolean);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader == null) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader.ah_();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader.c(0L);
  }
  
  public void a(SlideActiveAnimController paramSlideActiveAnimController)
  {
    super.a(paramSlideActiveAnimController);
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController.b())) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController.a(this.jdField_b_of_type_JavaLangString, RefreshRes.d(), QQManagerFactory.READ_INJOY_SKIN_MANAGER);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader == null) {
      return;
    }
    this.jdField_h_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader.a(0L);
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController.b())) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController.a((SkinPullRefreshHeader)this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader);
    }
    int m = 0;
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      m = this.jdField_a_of_type_JavaUtilArrayList.size();
    }
    if (m > 0)
    {
      double d1 = Math.random();
      this.jdField_f_of_type_Int = ((int)Math.floor(m * d1));
    }
    super.a(paramBoolean);
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader == null) {
      return;
    }
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader.a(0, paramString);
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader.a(0);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader.a(2);
  }
  
  public boolean a()
  {
    if ((this.jdField_g_of_type_Boolean) && (!this.jdField_h_of_type_Boolean)) {
      g();
    }
    this.jdField_e_of_type_Boolean = true;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController.b()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController.a()))
    {
      if (this.jdField_d_of_type_Int == 3) {
        g();
      }
      return true;
    }
    return false;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      this.jdField_g_of_type_Boolean = this.jdField_h_of_type_Boolean;
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController.b()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController.a(paramMotionEvent))) {
      return true;
    }
    return super.a(paramMotionEvent);
  }
  
  public void b()
  {
    super.b();
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController.b())) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController.c();
    }
    this.jdField_h_of_type_Boolean = false;
    if (!this.jdField_g_of_type_Boolean) {
      g();
    }
  }
  
  public void c()
  {
    g();
    super.c();
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoySkinAnimManager", 1, "resource onDestroy");
    }
    if (this.jdField_a_of_type_AndroidMediaSoundPool != null)
    {
      this.jdField_a_of_type_AndroidMediaSoundPool.stop(this.jdField_h_of_type_Int);
      this.jdField_a_of_type_AndroidMediaSoundPool.release();
      this.jdField_a_of_type_AndroidMediaSoundPool = null;
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList = null;
    }
    this.k = 1;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController.h();
    }
    g();
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_AndroidMediaSoundPool != null) {
      this.jdField_a_of_type_AndroidMediaSoundPool.stop(this.jdField_h_of_type_Int);
    }
    g();
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())) {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    this.jdField_a_of_type_JavaUtilArrayList = null;
    if (this.k == 3) {
      this.k = 1;
    }
  }
  
  public void f()
  {
    if (this.k == 1)
    {
      this.k = 2;
      ThreadManager.post(new ReadInJoySkinAnimManager.InitResourceRunnable(this, false), 8, null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.pullrefresh.ReadInJoySkinAnimManager
 * JD-Core Version:    0.7.0.1
 */