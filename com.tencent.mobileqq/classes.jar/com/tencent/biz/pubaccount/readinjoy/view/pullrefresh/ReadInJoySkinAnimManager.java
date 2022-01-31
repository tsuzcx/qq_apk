package com.tencent.biz.pubaccount.readinjoy.view.pullrefresh;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioAttributes.Builder;
import android.media.AudioManager;
import android.media.SoundPool;
import android.media.SoundPool.Builder;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.skin.CommonSkinRes;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoyRefreshManager;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoySkinManager;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshRes;
import com.tencent.biz.ui.IPullRefreshHeader;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import muv;
import muw;
import mux;

public class ReadInJoySkinAnimManager
  extends ReadInJoyAnimBaseManager
{
  private int jdField_a_of_type_Int = -2;
  private SoundPool jdField_a_of_type_AndroidMediaSoundPool;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private List jdField_a_of_type_JavaUtilList;
  private mux jdField_a_of_type_Mux;
  private volatile boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -2;
  private Context jdField_b_of_type_AndroidContentContext;
  private SoundPool jdField_b_of_type_AndroidMediaSoundPool;
  private String jdField_b_of_type_JavaLangString;
  private ArrayList jdField_b_of_type_JavaUtilArrayList;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = -2;
  private boolean jdField_d_of_type_Boolean = true;
  private int e = -2;
  private int f;
  private int g;
  private int h;
  private int i = -2;
  private int j = 1;
  private int k = -1;
  
  public ReadInJoySkinAnimManager(Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Mux = new mux(this);
    if ((paramContext instanceof BaseActivity))
    {
      ReadInJoyRefreshManager localReadInJoyRefreshManager = (ReadInJoyRefreshManager)((BaseActivity)paramContext).app.getManager(269);
      if ((localReadInJoyRefreshManager.a() != 1) || (!localReadInJoyRefreshManager.a())) {
        break label242;
      }
      this.jdField_a_of_type_JavaUtilList = RefreshRes.a();
      this.jdField_c_of_type_Int = RefreshRes.a();
      this.jdField_a_of_type_JavaLangString = RefreshRes.c();
      this.jdField_b_of_type_JavaLangString = localReadInJoyRefreshManager.a();
      this.jdField_c_of_type_JavaLangString = RefreshRes.d();
      this.k = 1;
      if (this.jdField_a_of_type_Int == -2)
      {
        this.jdField_a_of_type_Int = ((int)(((BaseActivity)paramContext).getWindowManager().getDefaultDisplay().getHeight() * 0.24F));
        if (this.jdField_c_of_type_Int != 1) {
          break label301;
        }
        this.jdField_b_of_type_Int = ((int)(((BaseActivity)paramContext).getWindowManager().getDefaultDisplay().getWidth() * 0.53F));
      }
    }
    for (;;)
    {
      if (this.j == 1)
      {
        this.j = 2;
        ThreadManager.post(new muw(this, true), 8, null, true);
      }
      return;
      label242:
      this.jdField_a_of_type_JavaUtilList = CommonSkinRes.a();
      this.jdField_c_of_type_Int = CommonSkinRes.b();
      this.jdField_a_of_type_JavaLangString = CommonSkinRes.c();
      this.jdField_b_of_type_JavaLangString = ((ReadInJoySkinManager)((BaseActivity)paramContext).app.getManager(260)).a();
      this.jdField_c_of_type_JavaLangString = CommonSkinRes.d();
      this.k = 2;
      break;
      label301:
      if (this.jdField_c_of_type_Int == 2) {
        this.jdField_b_of_type_Int = ((int)(((BaseActivity)paramContext).getWindowManager().getDefaultDisplay().getWidth() * 0.92F));
      }
    }
  }
  
  private int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
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
    double d1 = Math.sqrt(1.0D * (paramOptions.outHeight * paramInt2 * paramOptions.outWidth * 2) / 10485760.0D);
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
  
  private Drawable a(String paramString1, String paramString2, String paramString3, Resources paramResources, int paramInt)
  {
    paramString2 = new StringBuilder(paramString1).append(paramString2).append("/").append(paramString3);
    if (new File(paramString2.toString()).exists())
    {
      paramString3 = new BitmapFactory.Options();
      if ((this.i == -2) && (this.jdField_b_of_type_Int != -2))
      {
        paramString3.inJustDecodeBounds = true;
        ImageUtil.a(paramString2.toString(), paramString3);
        if (this.jdField_c_of_type_Int == 1) {
          this.i = a(paramString3, this.jdField_b_of_type_Int, paramInt);
        }
      }
      else
      {
        if (this.i != -2)
        {
          paramString3.inSampleSize = this.i;
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoySkinAnimManager", 1, "mSampleSize = " + this.i);
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
          break label296;
        }
        return new BitmapDrawable(paramResources, paramString1);
      }
      catch (OutOfMemoryError paramString2)
      {
        ReportController.b(null, "dc00899", "BizTechReport", "", "kan_dian_skin_pull_refresh", "decode_bitmap_oom", paramString3.inSampleSize, paramInt, this.jdField_b_of_type_JavaLangString, String.valueOf(paramString3.outHeight), String.valueOf(paramString3.outWidth), null);
        QLog.e("ReadInJoySkinAnimManager", 1, "getPngDrawable oom = " + paramString2 + " resFolderPath:" + paramString1);
        return null;
      }
      if (this.jdField_c_of_type_Int != 2) {
        break;
      }
      this.i = a(paramString3, this.jdField_b_of_type_Int, paramInt);
      break;
      label296:
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
  
  private void a(Drawable paramDrawable)
  {
    ((SkinPullRefreshHeader)this.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader).a(paramDrawable);
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {}
    for (int n = this.jdField_a_of_type_JavaUtilArrayList.size();; n = 0)
    {
      if ((n > 0) && (this.jdField_c_of_type_Int == 1)) {
        if (paramInt >= this.jdField_a_of_type_Int) {
          paramInt = 100;
        }
      }
      for (;;)
      {
        if (paramInt == 100) {
          if (this.jdField_d_of_type_Int != n - 1)
          {
            this.jdField_d_of_type_Int = (n - 1);
            a(((ReadInJoySkinAnimManager.PngWrapper)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_d_of_type_Int)).jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          }
        }
        label287:
        for (;;)
        {
          return;
          if ((paramInt >= this.jdField_a_of_type_Int) || (paramInt <= 0) || (this.jdField_a_of_type_Int == 0)) {
            break label289;
          }
          paramInt = paramInt * 100 / this.jdField_a_of_type_Int;
          break;
          int m = 0;
          label117:
          if (m < n) {
            if (((ReadInJoySkinAnimManager.PngWrapper)this.jdField_a_of_type_JavaUtilArrayList.get(m)).jdField_a_of_type_Int < paramInt) {}
          }
          for (;;)
          {
            if (m == this.jdField_d_of_type_Int) {
              break label287;
            }
            this.jdField_d_of_type_Int = m;
            a(((ReadInJoySkinAnimManager.PngWrapper)this.jdField_a_of_type_JavaUtilArrayList.get(m)).jdField_a_of_type_AndroidGraphicsDrawableDrawable);
            return;
            m += 1;
            break label117;
            if ((n <= 0) || (this.jdField_c_of_type_Int != 2)) {
              break;
            }
            if (this.jdField_d_of_type_Int == -2)
            {
              this.jdField_d_of_type_Int = ((int)Math.floor(Math.random() * n));
              this.e = this.jdField_d_of_type_Int;
              a(((ReadInJoySkinAnimManager.PngWrapper)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_d_of_type_Int)).jdField_a_of_type_AndroidGraphicsDrawableDrawable);
            }
            if (this.jdField_d_of_type_Int == this.e) {
              break;
            }
            this.jdField_d_of_type_Int = this.e;
            a(((ReadInJoySkinAnimManager.PngWrapper)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_d_of_type_Int)).jdField_a_of_type_AndroidGraphicsDrawableDrawable);
            return;
            m = 0;
          }
        }
        label289:
        paramInt = 0;
      }
    }
  }
  
  private void b(boolean paramBoolean)
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if ((localList == null) || (localList.size() <= 0)) {}
    Object localObject;
    String str2;
    Drawable localDrawable;
    label217:
    label235:
    do
    {
      return;
      if (paramBoolean)
      {
        if (this.jdField_c_of_type_JavaLangString == null) {
          break label235;
        }
        localObject = a();
        if (localObject == null) {
          break label217;
        }
        this.jdField_b_of_type_AndroidMediaSoundPool = ((SoundPool)localObject);
        this.jdField_a_of_type_Mux.sendEmptyMessage(2);
      }
      for (;;)
      {
        localObject = new ArrayList();
        if ((this.jdField_c_of_type_Int == 1) || (this.jdField_c_of_type_Int == 2)) {
          ReportController.b(null, "dc00899", "BizTechReport", "", "kan_dian_skin_pull_refresh", "decode_bitmap_times", 0, 0, this.jdField_b_of_type_JavaLangString, null, null, null);
        }
        if (this.jdField_c_of_type_Int != 1) {
          break label310;
        }
        localResources = BaseApplicationImpl.getContext().getResources();
        str1 = this.jdField_a_of_type_JavaLangString;
        localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          str2 = (String)localIterator.next();
          int m = a(str2);
          localDrawable = a(str1, "refreshAnimatePictures", str2, localResources, localList.size());
          if ((m != -2) && (localDrawable != null)) {
            ((ArrayList)localObject).add(new ReadInJoySkinAnimManager.PngWrapper(str2, m, localDrawable));
          }
        }
        if (QLog.isColorLevel())
        {
          QLog.d("ReadInJoySkinAnimManager", 1, "init soundpool failed");
          continue;
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoySkinAnimManager", 1, "voicePath = null");
          }
        }
      }
      Collections.sort((List)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoySkinAnimManager", 1, "initResources size = " + ((ArrayList)localObject).size());
      }
      this.jdField_b_of_type_JavaUtilArrayList = ((ArrayList)localObject);
      this.jdField_a_of_type_Mux.sendEmptyMessage(1);
      return;
    } while (this.jdField_c_of_type_Int != 2);
    label310:
    Resources localResources = BaseApplicationImpl.getContext().getResources();
    String str1 = this.jdField_a_of_type_JavaLangString;
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      str2 = (String)localIterator.next();
      localDrawable = a(str1, "refreshRandomPictures", str2, localResources, localList.size());
      if (localDrawable != null) {
        ((ArrayList)localObject).add(new ReadInJoySkinAnimManager.PngWrapper(str2, 0, localDrawable));
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoySkinAnimManager", 1, "initResources size = " + ((ArrayList)localObject).size());
    }
    this.jdField_b_of_type_JavaUtilArrayList = ((ArrayList)localObject);
    this.jdField_a_of_type_Mux.sendEmptyMessage(1);
  }
  
  private void c(int paramInt)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if ((paramInt < this.h) || (this.jdField_b_of_type_Boolean)) {
        break label97;
      }
      this.jdField_c_of_type_Boolean = true;
      if (this.jdField_c_of_type_Boolean)
      {
        AppInterface localAppInterface = ((BaseActivity)this.jdField_b_of_type_AndroidContentContext).getAppInterface();
        if ((localAppInterface != null) && (((SharedPreUtils.y(this.jdField_b_of_type_AndroidContentContext, localAppInterface.getCurrentAccountUin())) && (this.k == 2)) || (this.k == 1))) {
          h();
        }
      }
      if (paramInt < this.h) {
        break label105;
      }
      this.jdField_b_of_type_Boolean = true;
    }
    label97:
    label105:
    while (paramInt >= this.h)
    {
      return;
      this.jdField_c_of_type_Boolean = false;
      break;
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = this.jdField_b_of_type_JavaUtilArrayList;
    }
    for (;;)
    {
      this.jdField_b_of_type_JavaUtilArrayList = null;
      this.j = 3;
      return;
      QLog.e("ReadInJoySkinAnimManager", 1, "setPngArray mRefreshPullDownPNGS.size = " + this.jdField_a_of_type_JavaUtilArrayList.size());
    }
  }
  
  private void g()
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
        this.f = this.jdField_a_of_type_AndroidMediaSoundPool.load(str, 0);
        long l = System.currentTimeMillis();
        this.jdField_a_of_type_AndroidMediaSoundPool.setOnLoadCompleteListener(new muv(this, l));
      }
      return;
      QLog.e("ReadInJoySkinAnimManager", 1, "setSoundPool mRefreshPullDownPNGS.size != null");
    }
  }
  
  private void h()
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
        this.g = this.jdField_a_of_type_AndroidMediaSoundPool.play(this.f, f1, f1, 0, 0, 1.0F);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoySkinAnimManager", 1, "playSound volume = " + f1 + " RINGER_MODE_NORMAL = " + 2);
      }
      return;
    }
  }
  
  public int a()
  {
    this.h = this.jdField_b_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558434);
    return this.h;
  }
  
  public View a(ViewGroup paramViewGroup)
  {
    int n = 0;
    Object localObject1;
    AbsListView.LayoutParams localLayoutParams;
    Object localObject2;
    if (this.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader == null)
    {
      this.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader = ((SkinPullRefreshHeader)LayoutInflater.from(this.jdField_b_of_type_AndroidContentContext).inflate(2130971602, paramViewGroup, false));
      if (((this.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader instanceof RelativeLayout)) && (this.jdField_a_of_type_Int > 0))
      {
        localObject1 = (RelativeLayout)this.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader;
        localLayoutParams = (AbsListView.LayoutParams)((RelativeLayout)localObject1).getLayoutParams();
        paramViewGroup = null;
        if (this.jdField_c_of_type_Int != 1) {
          break label403;
        }
        paramViewGroup = "refreshAnimatePictures";
        localObject2 = this.jdField_a_of_type_JavaUtilList;
        m = n;
        if (localObject2 != null)
        {
          m = n;
          if (!((List)localObject2).isEmpty())
          {
            m = n;
            if (paramViewGroup != null)
            {
              paramViewGroup = new StringBuilder(this.jdField_a_of_type_JavaLangString).append(paramViewGroup).append("/").append((String)((List)localObject2).get(0));
              m = n;
              if (new File(paramViewGroup.toString()).exists())
              {
                localObject2 = new BitmapFactory.Options();
                ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
                ImageUtil.a(paramViewGroup.toString(), (BitmapFactory.Options)localObject2);
                if ((this.jdField_b_of_type_Int == -2) || (((BitmapFactory.Options)localObject2).outWidth == 0)) {
                  break label430;
                }
              }
            }
          }
        }
      }
    }
    label403:
    label430:
    for (int m = ((BitmapFactory.Options)localObject2).outHeight * this.jdField_b_of_type_Int / ((BitmapFactory.Options)localObject2).outWidth;; m = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoySkinAnimManager", 1, "getRefreshView options.outHeight = " + ((BitmapFactory.Options)localObject2).outHeight + " options.outWidth = " + ((BitmapFactory.Options)localObject2).outWidth);
      }
      if (m != 0) {}
      for (localLayoutParams.height = m;; localLayoutParams.height = this.jdField_a_of_type_Int)
      {
        ((RelativeLayout)localObject1).setLayoutParams(localLayoutParams);
        if (this.jdField_b_of_type_Int != -2)
        {
          paramViewGroup = (ImageView)((RelativeLayout)localObject1).findViewById(2131375147);
          localObject1 = paramViewGroup.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject1).width = this.jdField_b_of_type_Int;
          paramViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoySkinAnimManager", 1, "getRefreshView sDisplayHeight = " + this.jdField_a_of_type_Int + " sDisplayWidth = " + this.jdField_b_of_type_Int + " refreshType = " + this.jdField_c_of_type_Int);
        }
        return (View)this.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader;
        if (this.jdField_c_of_type_Int != 2) {
          break;
        }
        paramViewGroup = "refreshRandomPictures";
        break;
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader.a(0L);
    this.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader.aa_();
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {}
    for (int n = this.jdField_a_of_type_JavaUtilArrayList.size();; n = 0)
    {
      int m;
      if ((n > 0) && (this.jdField_c_of_type_Int == 1))
      {
        int i1 = this.h * 100 / this.jdField_a_of_type_Int;
        m = 0;
        if (m >= n) {
          break label186;
        }
        if (((ReadInJoySkinAnimManager.PngWrapper)this.jdField_a_of_type_JavaUtilArrayList.get(m)).jdField_a_of_type_Int < i1) {}
      }
      for (;;)
      {
        this.jdField_d_of_type_Int = m;
        a(((ReadInJoySkinAnimManager.PngWrapper)this.jdField_a_of_type_JavaUtilArrayList.get(m)).jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        for (;;)
        {
          this.jdField_b_of_type_Boolean = false;
          return;
          m += 1;
          break;
          if ((n > 0) && (this.jdField_c_of_type_Int == 2))
          {
            this.jdField_d_of_type_Int = ((int)Math.floor(Math.random() * n));
            this.e = this.jdField_d_of_type_Int;
            a(((ReadInJoySkinAnimManager.PngWrapper)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_d_of_type_Int)).jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          }
        }
        label186:
        m = 0;
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader == null) {}
    do
    {
      return;
      b(paramInt);
      c(paramInt);
    } while ((!this.jdField_d_of_type_Boolean) || ((this.jdField_c_of_type_Int != 2) && (this.jdField_c_of_type_Int != 1)));
    paramInt = 0;
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      paramInt = this.jdField_a_of_type_JavaUtilArrayList.size();
    }
    ReportController.b(null, "dc00899", "BizTechReport", "", "kan_dian_skin_pull_refresh", "refresh_times", this.jdField_c_of_type_Int, paramInt, this.jdField_b_of_type_JavaLangString, null, null, null);
    String str = this.jdField_c_of_type_JavaLangString;
    if ((str != null) && (new File(str).exists()))
    {
      paramInt = 1;
      if (this.jdField_a_of_type_Boolean) {
        paramInt = 2;
      }
      ReportController.b(null, "dc00899", "BizTechReport", "", "kan_dian_skin_pull_refresh", "sound_play_times", paramInt, 0, this.jdField_b_of_type_JavaLangString, null, null, null);
    }
    this.jdField_d_of_type_Boolean = false;
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    super.a(paramInt, paramBoolean);
    if (this.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader == null) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader.aa_();
      return;
    }
    this.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader.c(0L);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader.a(0L);
    int m = 0;
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      m = this.jdField_a_of_type_JavaUtilArrayList.size();
    }
    if (m > 0)
    {
      double d1 = Math.random();
      this.e = ((int)Math.floor(m * d1));
    }
    super.a(paramBoolean);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoySkinAnimManager", 1, "resource onDestroy");
    }
    if (this.jdField_a_of_type_AndroidMediaSoundPool != null)
    {
      this.jdField_a_of_type_AndroidMediaSoundPool.stop(this.g);
      this.jdField_a_of_type_AndroidMediaSoundPool.release();
      this.jdField_a_of_type_AndroidMediaSoundPool = null;
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        ReadInJoySkinAnimManager.PngWrapper localPngWrapper = (ReadInJoySkinAnimManager.PngWrapper)localIterator.next();
        if (localPngWrapper.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
          localPngWrapper.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
        }
      }
      this.jdField_a_of_type_JavaUtilArrayList = null;
    }
    this.j = 1;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidMediaSoundPool != null) {
      this.jdField_a_of_type_AndroidMediaSoundPool.stop(this.g);
    }
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        ReadInJoySkinAnimManager.PngWrapper localPngWrapper = (ReadInJoySkinAnimManager.PngWrapper)localIterator.next();
        if (localPngWrapper.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
          localPngWrapper.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
        }
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList = null;
    if (this.j == 3) {
      this.j = 1;
    }
  }
  
  public void d()
  {
    if (this.j == 1)
    {
      this.j = 2;
      ThreadManager.post(new muw(this, false), 8, null, true);
    }
  }
  
  public void e()
  {
    this.jdField_d_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.pullrefresh.ReadInJoySkinAnimManager
 * JD-Core Version:    0.7.0.1
 */