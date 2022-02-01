package com.tencent.biz.pubaccount.readinjoy.view.pullrefresh;

import aaul;
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
import bcst;
import bgmo;
import bgsg;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshData;
import com.tencent.biz.pubaccount.readinjoy.view.SlideActiveAnimController;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import rcs;
import rcx;
import rdd;
import rdv;
import tfd;
import tfj;
import tfk;
import tfl;

public class ReadInJoySkinAnimManager
  extends tfd
{
  private SoundPool jdField_a_of_type_AndroidMediaSoundPool;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ReadInJoySkinAnimManager.2(this);
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<tfk> jdField_a_of_type_JavaUtilArrayList;
  private List<String> jdField_a_of_type_JavaUtilList;
  private tfl jdField_a_of_type_Tfl;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -2;
  private Context jdField_b_of_type_AndroidContentContext;
  private SoundPool jdField_b_of_type_AndroidMediaSoundPool;
  private String jdField_b_of_type_JavaLangString;
  private ArrayList<tfk> jdField_b_of_type_JavaUtilArrayList;
  private volatile boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = -2;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int = -2;
  private boolean jdField_e_of_type_Boolean = true;
  private int jdField_f_of_type_Int = -2;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int;
  private boolean jdField_g_of_type_Boolean;
  private int jdField_h_of_type_Int;
  private boolean jdField_h_of_type_Boolean;
  private int jdField_i_of_type_Int;
  private boolean jdField_i_of_type_Boolean;
  private int j = -2;
  private int k = 1;
  private int l = -1;
  
  public ReadInJoySkinAnimManager(Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Tfl = new tfl(this);
    boolean bool;
    rcx localrcx;
    if ((float)Runtime.getRuntime().maxMemory() <= 1.415578E+008F)
    {
      bool = true;
      this.jdField_i_of_type_Boolean = bool;
      if ((paramContext instanceof BaseActivity))
      {
        localrcx = (rcx)((BaseActivity)paramContext).app.getManager(270);
        if ((localrcx.a() != 1) || (!localrcx.b())) {
          break label279;
        }
        this.jdField_a_of_type_JavaUtilList = rdv.a();
        this.jdField_d_of_type_Int = rdv.a();
        this.jdField_a_of_type_JavaLangString = rdv.c();
        this.jdField_b_of_type_JavaLangString = localrcx.a();
        this.jdField_c_of_type_JavaLangString = rdv.e();
        this.l = 1;
        label179:
        if (this.jdField_b_of_type_Int == -2)
        {
          this.jdField_b_of_type_Int = ((int)(((BaseActivity)paramContext).getWindowManager().getDefaultDisplay().getHeight() * 0.24F));
          if (this.jdField_d_of_type_Int != 1) {
            break label338;
          }
          this.jdField_c_of_type_Int = ((int)(((BaseActivity)paramContext).getWindowManager().getDefaultDisplay().getWidth() * 0.53F));
        }
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
      bool = false;
      break;
      label279:
      this.jdField_a_of_type_JavaUtilList = rcs.a();
      this.jdField_d_of_type_Int = rcs.b();
      this.jdField_a_of_type_JavaLangString = rcs.d();
      this.jdField_b_of_type_JavaLangString = ((rdd)((BaseActivity)paramContext).app.getManager(261)).a();
      this.jdField_c_of_type_JavaLangString = rcs.e();
      this.l = 2;
      break label179;
      label338:
      if (this.jdField_d_of_type_Int == 2)
      {
        if (localrcx.a()) {
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
      paramString = bgmo.a(paramString.toString(), localOptions);
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
        bgmo.a(paramString2.toString(), paramString3);
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
        paramString2 = bgmo.a(paramString2.toString(), paramString3);
        paramString1 = paramString2;
        if (paramString1 == null) {
          break label333;
        }
        return new BitmapDrawable(paramResources, paramString1);
      }
      catch (OutOfMemoryError paramString2)
      {
        bcst.b(null, "dc00899", "BizTechReport", "", "kan_dian_skin_pull_refresh", "decode_bitmap_oom", paramString3.inSampleSize, paramInt1, this.jdField_b_of_type_JavaLangString, String.valueOf(paramString3.outHeight), String.valueOf(paramString3.outWidth), null);
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
      label333:
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
            a(((tfk)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_e_of_type_Int)).jdField_a_of_type_AndroidGraphicsDrawableDrawable);
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
            if (((tfk)this.jdField_a_of_type_JavaUtilArrayList.get(m)).jdField_a_of_type_Int < paramInt) {}
          }
          for (;;)
          {
            if (m == this.jdField_e_of_type_Int) {
              break label342;
            }
            this.jdField_e_of_type_Int = m;
            a(((tfk)this.jdField_a_of_type_JavaUtilArrayList.get(m)).jdField_a_of_type_AndroidGraphicsDrawableDrawable);
            return;
            m += 1;
            break label117;
            if ((n > 0) && (this.jdField_d_of_type_Int == 2))
            {
              if (this.jdField_e_of_type_Int == -2)
              {
                this.jdField_e_of_type_Int = ((int)Math.floor(Math.random() * n));
                this.jdField_f_of_type_Int = this.jdField_e_of_type_Int;
                a(((tfk)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_e_of_type_Int)).jdField_a_of_type_AndroidGraphicsDrawableDrawable);
              }
              if (this.jdField_e_of_type_Int == this.jdField_f_of_type_Int) {
                break;
              }
              this.jdField_e_of_type_Int = this.jdField_f_of_type_Int;
              a(((tfk)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_e_of_type_Int)).jdField_a_of_type_AndroidGraphicsDrawableDrawable);
              return;
            }
            if ((n <= 0) || (this.jdField_d_of_type_Int != 3) || (this.jdField_f_of_type_Boolean)) {
              break;
            }
            this.jdField_f_of_type_Boolean = true;
            ((SkinPullRefreshHeader)this.jdField_a_of_type_Aaul).removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
            ((SkinPullRefreshHeader)this.jdField_a_of_type_Aaul).post(this.jdField_a_of_type_JavaLangRunnable);
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
    SkinPullRefreshHeader localSkinPullRefreshHeader = (SkinPullRefreshHeader)this.jdField_a_of_type_Aaul;
    if (!this.jdField_a_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      localSkinPullRefreshHeader.a(paramDrawable, bool);
      return;
    }
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
        if ((localAppInterface != null) && (((bgsg.v(this.jdField_b_of_type_AndroidContentContext, localAppInterface.getCurrentAccountUin())) && (this.l == 2)) || (this.l == 1))) {
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
    Object localObject;
    int i1;
    if (paramBoolean)
    {
      if (this.jdField_c_of_type_JavaLangString == null) {
        break label283;
      }
      localObject = a();
      if (localObject != null)
      {
        this.jdField_b_of_type_AndroidMediaSoundPool = ((SoundPool)localObject);
        this.jdField_a_of_type_Tfl.sendEmptyMessage(2);
      }
    }
    else
    {
      i1 = a((String)localList.get(0));
      if ((!this.jdField_i_of_type_Boolean) || ((this.jdField_d_of_type_Int != 1) && (this.jdField_d_of_type_Int != 3))) {
        break label578;
      }
    }
    label283:
    label578:
    for (int n = a(localList.size(), i1);; n = 1)
    {
      localObject = new ArrayList();
      if ((this.jdField_d_of_type_Int == 1) || (this.jdField_d_of_type_Int == 2) || (this.jdField_d_of_type_Int == 3)) {
        bcst.b(null, "dc00899", "BizTechReport", "", "kan_dian_skin_pull_refresh", "decode_bitmap_times", 0, 0, this.jdField_b_of_type_JavaLangString, null, null, null);
      }
      String str2;
      Drawable localDrawable;
      if ((this.jdField_d_of_type_Int == 1) || (this.jdField_d_of_type_Int == 3))
      {
        localResources = BaseApplicationImpl.getContext().getResources();
        str1 = this.jdField_a_of_type_JavaLangString;
        int i2 = localList.size();
        int m = 0;
        localIterator = localList.iterator();
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label366;
          }
          str2 = (String)localIterator.next();
          m += 1;
          if ((m % n != 0) && (m != i2))
          {
            continue;
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("ReadInJoySkinAnimManager", 1, "init soundpool failed");
            break;
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("ReadInJoySkinAnimManager", 1, "voicePath = null");
            break;
          }
          int i3 = b(str2);
          localDrawable = a(str1, "refreshAnimatePictures", str2, localResources, localList.size(), i1);
          if ((i3 != -2) && (localDrawable != null)) {
            ((ArrayList)localObject).add(new tfk(str2, i3, localDrawable));
          }
        }
        label366:
        Collections.sort((List)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoySkinAnimManager", 1, "initResources size = " + ((ArrayList)localObject).size());
        }
        this.jdField_b_of_type_JavaUtilArrayList = ((ArrayList)localObject);
        this.jdField_a_of_type_Tfl.sendEmptyMessage(1);
        return;
      }
      if (this.jdField_d_of_type_Int != 2) {
        break;
      }
      Resources localResources = BaseApplicationImpl.getContext().getResources();
      String str1 = this.jdField_a_of_type_JavaLangString;
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        str2 = (String)localIterator.next();
        localDrawable = a(str1, "refreshRandomPictures", str2, localResources, localList.size(), i1);
        if (localDrawable != null) {
          ((ArrayList)localObject).add(new tfk(str2, 0, localDrawable));
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoySkinAnimManager", 1, "initResources size = " + ((ArrayList)localObject).size());
      }
      this.jdField_b_of_type_JavaUtilArrayList = ((ArrayList)localObject);
      this.jdField_a_of_type_Tfl.sendEmptyMessage(1);
      return;
    }
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_Aaul != null)
    {
      ((SkinPullRefreshHeader)this.jdField_a_of_type_Aaul).removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_f_of_type_Boolean = false;
    }
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null)
    {
      this.jdField_a_of_type_JavaUtilArrayList = this.jdField_b_of_type_JavaUtilArrayList;
      if ((this.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (this.jdField_a_of_type_Aaul != null))
      {
        if (!this.jdField_h_of_type_Boolean) {
          break label98;
        }
        a(((tfk)this.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        ((SkinPullRefreshHeader)this.jdField_a_of_type_Aaul).removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        ((SkinPullRefreshHeader)this.jdField_a_of_type_Aaul).post(this.jdField_a_of_type_JavaLangRunnable);
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_JavaUtilArrayList = null;
      this.k = 3;
      return;
      label98:
      a(((tfk)this.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_AndroidGraphicsDrawableDrawable);
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
        this.jdField_a_of_type_AndroidMediaSoundPool.setOnLoadCompleteListener(new tfj(this, l1));
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
    this.jdField_i_of_type_Int = this.jdField_b_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298748);
    return this.jdField_i_of_type_Int;
  }
  
  public View a(ViewGroup paramViewGroup)
  {
    boolean bool2 = true;
    Object localObject1;
    AbsListView.LayoutParams localLayoutParams;
    int m;
    if (this.jdField_a_of_type_Aaul == null)
    {
      this.jdField_a_of_type_Aaul = ((SkinPullRefreshHeader)LayoutInflater.from(this.jdField_b_of_type_AndroidContentContext).inflate(2131562890, paramViewGroup, false));
      if (((this.jdField_a_of_type_Aaul instanceof RelativeLayout)) && (this.jdField_b_of_type_Int > 0))
      {
        localObject1 = (RelativeLayout)this.jdField_a_of_type_Aaul;
        localLayoutParams = (AbsListView.LayoutParams)((RelativeLayout)localObject1).getLayoutParams();
        paramViewGroup = null;
        if ((this.jdField_d_of_type_Int != 1) && (this.jdField_d_of_type_Int != 3)) {
          break label505;
        }
        paramViewGroup = "refreshAnimatePictures";
        Object localObject2 = this.jdField_a_of_type_JavaUtilList;
        if ((localObject2 == null) || (((List)localObject2).isEmpty()) || (paramViewGroup == null)) {
          break label549;
        }
        paramViewGroup = new StringBuilder(this.jdField_a_of_type_JavaLangString).append(paramViewGroup).append("/").append((String)((List)localObject2).get(0));
        if (!new File(paramViewGroup.toString()).exists()) {
          break label549;
        }
        localObject2 = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
        bgmo.a(paramViewGroup.toString(), (BitmapFactory.Options)localObject2);
        if ((this.jdField_c_of_type_Int == -2) || (((BitmapFactory.Options)localObject2).outWidth == 0)) {
          break label544;
        }
        m = ((BitmapFactory.Options)localObject2).outHeight * this.jdField_c_of_type_Int / ((BitmapFactory.Options)localObject2).outWidth;
        label225:
        n = m;
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoySkinAnimManager", 1, "getRefreshView options.outHeight = " + ((BitmapFactory.Options)localObject2).outHeight + " options.outWidth = " + ((BitmapFactory.Options)localObject2).outWidth);
        }
      }
    }
    label289:
    label549:
    for (int n = m;; n = 0)
    {
      if (n != 0)
      {
        localLayoutParams.height = n;
        ((RelativeLayout)localObject1).setLayoutParams(localLayoutParams);
        if (this.jdField_c_of_type_Int != -2)
        {
          paramViewGroup = (ImageView)((RelativeLayout)localObject1).findViewById(2131376314);
          localObject1 = paramViewGroup.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject1).width = this.jdField_c_of_type_Int;
          paramViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoySkinAnimManager", 1, "getRefreshView sDisplayHeight = " + this.jdField_b_of_type_Int + " sDisplayWidth = " + this.jdField_c_of_type_Int + " refreshType = " + this.jdField_d_of_type_Int);
        }
        if ((this.jdField_b_of_type_AndroidContentContext instanceof BaseActivity))
        {
          paramViewGroup = (rcx)((BaseActivity)this.jdField_b_of_type_AndroidContentContext).app.getManager(270);
          localObject1 = paramViewGroup.a(this.jdField_b_of_type_AndroidContentContext, 0);
          if ((localObject1 == null) || (!((RefreshData)localObject1).isAD)) {
            break label532;
          }
          bool1 = true;
          label456:
          this.jdField_a_of_type_Boolean = bool1;
          localObject1 = (SkinPullRefreshHeader)this.jdField_a_of_type_Aaul;
          if ((paramViewGroup.a() != 1) || (!this.jdField_a_of_type_Boolean)) {
            break label538;
          }
        }
      }
      for (boolean bool1 = bool2;; bool1 = false)
      {
        ((SkinPullRefreshHeader)localObject1).setAdTabVisibility(bool1);
        return (View)this.jdField_a_of_type_Aaul;
        label505:
        if (this.jdField_d_of_type_Int != 2) {
          break;
        }
        paramViewGroup = "refreshRandomPictures";
        break;
        localLayoutParams.height = this.jdField_b_of_type_Int;
        break label289;
        bool1 = false;
        break label456;
      }
      m = 0;
      break label225;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Aaul == null) {
      return;
    }
    this.jdField_a_of_type_Aaul.a(0L);
    if ((this.jdField_a_of_type_Aaul instanceof SkinPullRefreshHeader)) {
      ((SkinPullRefreshHeader)this.jdField_a_of_type_Aaul).a(false, "");
    }
    this.jdField_a_of_type_Aaul.aq_();
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController.b())) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController.a((SkinPullRefreshHeader)this.jdField_a_of_type_Aaul);
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
        if (((tfk)this.jdField_a_of_type_JavaUtilArrayList.get(m)).jdField_a_of_type_Int < i1) {}
      }
      for (;;)
      {
        this.jdField_e_of_type_Int = m;
        a(((tfk)this.jdField_a_of_type_JavaUtilArrayList.get(m)).jdField_a_of_type_AndroidGraphicsDrawableDrawable);
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
            a(((tfk)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_e_of_type_Int)).jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          }
          else if ((n > 0) && (this.jdField_d_of_type_Int == 3))
          {
            this.jdField_e_of_type_Int = 0;
            ((SkinPullRefreshHeader)this.jdField_a_of_type_Aaul).removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
            ((SkinPullRefreshHeader)this.jdField_a_of_type_Aaul).post(this.jdField_a_of_type_JavaLangRunnable);
          }
        }
        label291:
        m = 0;
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Aaul == null) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController.b())) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController.a((SkinPullRefreshHeader)this.jdField_a_of_type_Aaul, paramInt1, paramInt2);
      }
      a(paramInt1);
      b(paramInt1);
    } while ((!this.jdField_e_of_type_Boolean) || ((this.jdField_d_of_type_Int != 2) && (this.jdField_d_of_type_Int != 1) && (this.jdField_d_of_type_Int != 3)));
    paramInt1 = 0;
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      paramInt1 = this.jdField_a_of_type_JavaUtilArrayList.size();
    }
    bcst.b(null, "dc00899", "BizTechReport", "", "kan_dian_skin_pull_refresh", "refresh_times", this.jdField_d_of_type_Int, paramInt1, this.jdField_b_of_type_JavaLangString, null, null, null);
    String str = this.jdField_c_of_type_JavaLangString;
    if ((str != null) && (new File(str).exists()))
    {
      paramInt1 = 1;
      if (this.jdField_b_of_type_Boolean) {
        paramInt1 = 2;
      }
      bcst.b(null, "dc00899", "BizTechReport", "", "kan_dian_skin_pull_refresh", "sound_play_times", paramInt1, 0, this.jdField_b_of_type_JavaLangString, null, null, null);
    }
    this.jdField_e_of_type_Boolean = false;
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    super.a(paramInt, paramBoolean);
    if (this.jdField_a_of_type_Aaul == null) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_Aaul.aq_();
      return;
    }
    this.jdField_a_of_type_Aaul.c(0L);
  }
  
  public void a(SlideActiveAnimController paramSlideActiveAnimController)
  {
    super.a(paramSlideActiveAnimController);
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController.b())) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController.a(this.jdField_b_of_type_JavaLangString, rdv.d(), 261);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Aaul == null) {
      return;
    }
    this.jdField_h_of_type_Boolean = true;
    this.jdField_a_of_type_Aaul.a(0L);
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController.b())) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController.a((SkinPullRefreshHeader)this.jdField_a_of_type_Aaul);
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
    if (this.jdField_a_of_type_Aaul == null) {
      return;
    }
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)))
    {
      this.jdField_a_of_type_Aaul.a(0, paramString);
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_Aaul.a(0);
      return;
    }
    this.jdField_a_of_type_Aaul.a(2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.pullrefresh.ReadInJoySkinAnimManager
 * JD-Core Version:    0.7.0.1
 */