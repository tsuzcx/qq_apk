package com.tencent.mobileqq.activity.photo.album;

import aciy;
import afzf;
import agfj;
import agfq;
import agfr;
import agfs;
import agfu;
import agfv;
import agfw;
import agfx;
import agfy;
import aggf;
import aggg;
import aggh;
import agih;
import ajed;
import aluq;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import awqx;
import baae;
import baaf;
import bbmy;
import behi;
import bejw;
import bjlh;
import bjli;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.photo.PeakFragmentActivity;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GestureSelectGridView;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kzy;
import mqq.app.AppRuntime;
import vhg;
import vhk;
import vhn;
import zqk;

public class NewPhotoListActivity
  extends PeakFragmentActivity
  implements agfj, View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  public static agfx a;
  public int a;
  public agfv a;
  public aggg a;
  public aggh a;
  Dialog jdField_a_of_type_AndroidAppDialog;
  SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  public AsyncTask<Object, Object, List<LocalMediaInfo>> a;
  public Handler a;
  public View a;
  public Button a;
  public CheckBox a;
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  public TextView a;
  behi jdField_a_of_type_Behi = new agfs(this);
  bejw jdField_a_of_type_Bejw = new agfq(this);
  public AlbumListFragment a;
  public GestureSelectGridView a;
  public int b;
  View b;
  public Button b;
  public TextView b;
  int c;
  public Button c;
  public TextView c;
  int jdField_d_of_type_Int;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  int jdField_e_of_type_Int;
  TextView jdField_e_of_type_AndroidWidgetTextView;
  int jdField_f_of_type_Int;
  TextView jdField_f_of_type_AndroidWidgetTextView;
  public int g;
  
  static
  {
    jdField_a_of_type_Agfx = new agfx();
  }
  
  public NewPhotoListActivity()
  {
    this.jdField_a_of_type_AndroidOsHandler = new agfu(this);
  }
  
  public static String a(long paramLong)
  {
    paramLong /= 1000L;
    int i = (int)paramLong % 60;
    int j = (int)paramLong / 60;
    String str1;
    if (i > 9)
    {
      str1 = String.valueOf(i);
      if (j <= 9) {
        break label102;
      }
    }
    label102:
    for (String str2 = String.valueOf(j);; str2 = "0" + String.valueOf(j))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str2).append(":").append(str1);
      return localStringBuilder.toString();
      str1 = "0" + String.valueOf(i);
      break;
    }
  }
  
  private void a(List<String> paramList, HashMap<String, LocalMediaInfo> paramHashMap)
  {
    if ((paramList != null) && (paramHashMap != null) && (this.jdField_a_of_type_Aggh.jdField_a_of_type_Aggf.jdField_b_of_type_JavaUtilHashMap != null))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        if (!paramHashMap.containsKey(str)) {
          paramHashMap.put(str, this.jdField_a_of_type_Aggh.jdField_a_of_type_Aggf.jdField_b_of_type_JavaUtilHashMap.get(str));
        }
      }
    }
  }
  
  private boolean a(Intent paramIntent)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramIntent != null)
    {
      boolean bool3 = paramIntent.getBooleanExtra("extra_directly_back", false);
      boolean bool4 = paramIntent.getBooleanExtra("PhotoConst.IS_VIDEO_RECORDED", false);
      bool1 = bool2;
      if (bool3)
      {
        if (!bool4) {
          break label50;
        }
        this.jdField_a_of_type_Aggh.e(paramIntent);
      }
    }
    for (;;)
    {
      bool1 = true;
      return bool1;
      label50:
      this.jdField_a_of_type_Aggh.d(paramIntent);
    }
  }
  
  public int a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (a(paramString) == null)) {
      return -1;
    }
    return baaf.a(a(paramString));
  }
  
  public LocalMediaInfo a(String paramString)
  {
    aggf localaggf = this.jdField_a_of_type_Aggh.jdField_a_of_type_Aggf;
    LocalMediaInfo localLocalMediaInfo = null;
    if (localaggf.jdField_a_of_type_JavaUtilHashMap != null) {
      localLocalMediaInfo = (LocalMediaInfo)localaggf.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    }
    if ((localLocalMediaInfo == null) && (localaggf.jdField_b_of_type_JavaUtilHashMap != null)) {
      localLocalMediaInfo = (LocalMediaInfo)localaggf.jdField_b_of_type_JavaUtilHashMap.get(paramString);
    }
    for (;;)
    {
      if ((localLocalMediaInfo != null) && ((localLocalMediaInfo.mediaWidth == 0) || (localLocalMediaInfo.mediaHeight == 0)))
      {
        bjli localbjli = new bjli();
        bjlh.a(paramString, localbjli);
        localLocalMediaInfo.mediaWidth = localbjli.a[0];
        localLocalMediaInfo.mediaHeight = localbjli.a[1];
        localLocalMediaInfo.rotation = localbjli.a[2];
        if (localaggf.jdField_b_of_type_JavaUtilHashMap != null)
        {
          paramString = (LocalMediaInfo)localaggf.jdField_b_of_type_JavaUtilHashMap.get(paramString);
          if ((paramString != null) && ((paramString.mediaWidth == 0) || (paramString.mediaHeight == 0)))
          {
            paramString.mediaWidth = localLocalMediaInfo.mediaWidth;
            paramString.mediaHeight = localLocalMediaInfo.mediaHeight;
            paramString.rotation = localLocalMediaInfo.rotation;
          }
        }
      }
      return localLocalMediaInfo;
    }
  }
  
  @TargetApi(8)
  File a()
  {
    Object localObject = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    String str = "JPEG_" + (String)localObject + "_";
    if ("mounted".equals(Environment.getExternalStorageState()))
    {
      boolean bool = false;
      if (Build.VERSION.SDK_INT > 7)
      {
        localObject = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
        bool = true;
      }
      while (bool)
      {
        localObject = File.createTempFile(str, ".jpg", (File)localObject);
        this.jdField_a_of_type_Aggg.jdField_f_of_type_JavaLangString = ((File)localObject).getAbsolutePath();
        return localObject;
        File localFile = new File(Environment.getExternalStorageDirectory(), "DCIM");
        localObject = localFile;
        if (!localFile.exists())
        {
          bool = localFile.mkdirs();
          localObject = localFile;
        }
      }
    }
    return null;
  }
  
  String a(String paramString)
  {
    try
    {
      File localFile = new File(paramString);
      Object localObject = paramString;
      if (localFile.exists())
      {
        localObject = localFile.getName();
        String str = ajed.bh + (String)localObject;
        localObject = paramString;
        if (!str.equals(paramString))
        {
          localObject = new File(ajed.bh);
          if (!((File)localObject).exists()) {
            ((File)localObject).mkdirs();
          }
          localFile.renameTo(new File(str));
          QZLog.d("PhotoListActivity", 2, new Object[] { "saveToDCIM rename to :", str });
          localObject = str;
        }
      }
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      QZLog.e("PhotoListActivity", 2, new Object[] { "saveToDCIM :", localThrowable });
    }
    return paramString;
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList = this.jdField_a_of_type_Aggh.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList;
    int j = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition();
    int k = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getLastVisiblePosition();
    int i = j;
    if (i <= k)
    {
      if ((paramBoolean) && (paramInt != i)) {}
      label399:
      for (;;)
      {
        i += 1;
        break;
        Object localObject = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getChildAt(i - j);
        LocalMediaInfo localLocalMediaInfo = this.jdField_a_of_type_Agfv.a(i);
        if (localObject == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PhotoListActivity", 2, "updateCheckbox view = null at " + i);
          }
        }
        else if (localLocalMediaInfo == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PhotoListActivity", 2, "updateCheckbox info = null at " + i);
          }
        }
        else
        {
          int m;
          agfw localagfw;
          if (paramInt != i)
          {
            m = localArrayList.indexOf(localLocalMediaInfo.path);
            if (m >= 0)
            {
              localagfw = (agfw)((View)localObject).getTag();
              if ((localagfw != null) && (localagfw.a != null)) {
                localagfw.a.setCheckedNumber(m + 1);
              }
            }
          }
          else
          {
            m = baaf.a(localLocalMediaInfo);
            if ((m == 0) || (m == 1))
            {
              localagfw = (agfw)((View)localObject).getTag();
              ImageView localImageView = localagfw.c;
              int n = localLocalMediaInfo.selectStatus;
              if (n == 1)
              {
                localImageView.setVisibility(0);
                localagfw.a.setCheckedNumber(localArrayList.indexOf(localLocalMediaInfo.path) + 1);
                if (((View)localObject).getBackground() != null) {
                  ((View)localObject).setBackgroundDrawable(null);
                }
              }
              for (;;)
              {
                if (!AppSetting.jdField_c_of_type_Boolean) {
                  break label399;
                }
                localObject = PhotoUtils.a(m, localLocalMediaInfo, i, localagfw.a.isChecked());
                localagfw.a.setContentDescription((CharSequence)localObject);
                break;
                if (n == 3)
                {
                  localImageView.setVisibility(4);
                  localagfw.a.setChecked(false);
                }
                else
                {
                  localImageView.setVisibility(4);
                  localagfw.a.setChecked(false);
                  if (((View)localObject).getBackground() != null) {
                    ((View)localObject).setBackgroundDrawable(null);
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void a(Intent paramIntent)
  {
    if (this.jdField_a_of_type_Aggg.t)
    {
      paramIntent.putExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", true);
      paramIntent.putExtra("session_info", getIntent().getParcelableExtra("session_info"));
    }
  }
  
  public void a(QQAlbumInfo paramQQAlbumInfo, int paramInt, Intent paramIntent)
  {
    String str1 = paramIntent.getStringExtra("ALBUM_NAME");
    String str2 = paramIntent.getStringExtra("ALBUM_ID");
    if (((str1 != null) && (!str1.equals(this.jdField_a_of_type_Aggh.jdField_a_of_type_Aggf.jdField_b_of_type_JavaLangString))) || ((str2 != null) && (!str2.equals(this.jdField_a_of_type_Aggh.jdField_a_of_type_Aggf.jdField_c_of_type_JavaLangString))))
    {
      paramInt = 1;
      if ((!paramQQAlbumInfo._id.equals("qzone_album")) && (paramInt != 0))
      {
        this.jdField_a_of_type_Aggh.jdField_a_of_type_Aggf.jdField_b_of_type_JavaLangString = str1;
        this.jdField_a_of_type_Aggh.jdField_a_of_type_Aggf.jdField_c_of_type_JavaLangString = str2;
        this.jdField_a_of_type_Aggg.jdField_e_of_type_Int = paramIntent.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
        if (this.jdField_a_of_type_Aggh.jdField_a_of_type_Aggf.jdField_b_of_type_JavaLangString == null) {
          break label182;
        }
      }
    }
    label182:
    for (paramQQAlbumInfo = this.jdField_a_of_type_Aggh.jdField_a_of_type_Aggf.jdField_b_of_type_JavaLangString;; paramQQAlbumInfo = baae.l)
    {
      setTitle(paramQQAlbumInfo);
      this.jdField_a_of_type_Aggg.d = true;
      runOnUiThread(new NewPhotoListActivity.5(this));
      a(false);
      return;
      paramInt = 0;
      break;
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      FileProvider7Helper.savePhotoToSysAlbum(this, paramString);
      return;
    }
    catch (Exception paramString)
    {
      QZLog.e("PhotoListActivity", 2, new Object[] { "scanMediaFile :", paramString });
    }
  }
  
  public void a(boolean paramBoolean)
  {
    FragmentTransaction localFragmentTransaction;
    ObjectAnimator localObjectAnimator;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListFragment == null)
    {
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListFragment = new AlbumListFragment();
      }
    }
    else
    {
      localFragmentTransaction = getSupportFragmentManager().beginTransaction();
      localFragmentTransaction.setTransition(4097);
      if ((!paramBoolean) || (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListFragment.isAdded())) {
        break label161;
      }
      localObjectAnimator = ObjectAnimator.ofInt(this.jdField_a_of_type_AndroidWidgetFrameLayout, "backgroundColor", new int[] { getResources().getColor(2131099855), getResources().getColor(2131099866) });
      PhotoUtils.a(this.jdField_a_of_type_AndroidWidgetImageView, false);
      localFragmentTransaction.add(2131296906, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListFragment, null);
    }
    for (;;)
    {
      localFragmentTransaction.addToBackStack(null);
      localFragmentTransaction.commit();
      localObjectAnimator.setDuration(300L);
      localObjectAnimator.setEvaluator(new ArgbEvaluator());
      localObjectAnimator.setRepeatMode(2);
      localObjectAnimator.start();
      this.jdField_a_of_type_Aggh.a(paramBoolean);
      return;
      label161:
      localObjectAnimator = ObjectAnimator.ofInt(this.jdField_a_of_type_AndroidWidgetFrameLayout, "backgroundColor", new int[] { getResources().getColor(2131099866), getResources().getColor(2131099855) });
      PhotoUtils.a(this.jdField_a_of_type_AndroidWidgetImageView, true);
      localFragmentTransaction.remove(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListFragment);
    }
  }
  
  public boolean a(LocalMediaInfo paramLocalMediaInfo)
  {
    return (paramLocalMediaInfo != null) && ("image/gif".equals(paramLocalMediaInfo.mMimeType));
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Aggg.t) {
      awqx.b(null, "CliOper", "", "", "0x80083EC", "0x80083EC", 0, 0, "", "", "", "");
    }
  }
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_Aggg.m)
    {
      baaf.jdField_a_of_type_Long = System.currentTimeMillis();
      baaf.jdField_a_of_type_JavaUtilHashMap.put(this.jdField_a_of_type_Aggh.jdField_a_of_type_Aggf.jdField_c_of_type_JavaLangString, Integer.valueOf(this.jdField_a_of_type_Agfv.getCount()));
      if (!TextUtils.isEmpty(paramString))
      {
        baaf.jdField_a_of_type_JavaLangString = paramString;
        HashMap localHashMap = baaf.jdField_c_of_type_JavaUtilHashMap;
        if (localHashMap.containsKey(paramString))
        {
          paramString = (Pair)localHashMap.get(paramString);
          baaf.jdField_b_of_type_JavaLangString = (String)paramString.first;
          baaf.jdField_c_of_type_JavaLangString = (String)paramString.second;
          baaf.a(this, baaf.jdField_b_of_type_JavaLangString, baaf.jdField_c_of_type_JavaLangString);
        }
      }
    }
    baaf.c();
  }
  
  void c()
  {
    Object localObject = (RelativeLayout)findViewById(2131309736);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131296906));
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      ((RelativeLayout)localObject).setFitsSystemWindows(true);
      ((RelativeLayout)localObject).setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302804));
    this.jdField_e_of_type_AndroidWidgetTextView.setContentDescription(getResources().getString(2131629403));
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_e_of_type_AndroidWidgetTextView.setText(getResources().getString(2131625035));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302847));
    int i;
    if (this.jdField_a_of_type_Aggh.jdField_a_of_type_Aggf.jdField_b_of_type_JavaLangString != null)
    {
      localObject = this.jdField_a_of_type_Aggh.jdField_a_of_type_Aggf.jdField_b_of_type_JavaLangString;
      setTitle((CharSequence)localObject);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131302844));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131302797));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131304039));
      this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131307749));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131307755));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131307750));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302321));
      j();
      this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131306214));
      this.jdField_c_of_type_AndroidWidgetButton = ((Button)findViewById(2131310076));
      this.jdField_a_of_type_AndroidViewView = findViewById(2131311730);
      this.jdField_b_of_type_AndroidViewView = findViewById(2131301568);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131312878));
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView = ((GestureSelectGridView)findViewById(2131305818));
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setScrollBarStyle(0);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setNumColumns(3);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setColumnWidth(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setHorizontalSpacing(this.jdField_c_of_type_Int);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setVerticalSpacing(this.jdField_d_of_type_Int);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setPadding(this.jdField_e_of_type_Int, this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getPaddingTop(), this.jdField_e_of_type_Int, this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getPaddingBottom());
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setOnItemClickListener(this.jdField_a_of_type_Behi);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setOnIndexChangedListener(this.jdField_a_of_type_Bejw);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setMaximumVelocity((int)(2500.0F * getResources().getDisplayMetrics().density));
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setOnScrollListener(new agfr(this));
      this.jdField_a_of_type_Agfv = new agfv(this);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setAdapter(this.jdField_a_of_type_Agfv);
      localObject = this.jdField_a_of_type_AndroidViewView;
      if ((!this.jdField_a_of_type_Aggg.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_Aggg.jdField_b_of_type_Int != 2) && (!this.jdField_a_of_type_Aggh.jdField_a_of_type_Aggf.a())) {
        break label751;
      }
      i = 8;
      label545:
      ((View)localObject).setVisibility(i);
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
      if (!this.jdField_a_of_type_Aggg.h) {
        break label756;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Aggg.jdField_f_of_type_Boolean) {
        this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
      }
      this.jdField_a_of_type_Aggh.d();
      if (this.jdField_a_of_type_Aggh.jdField_a_of_type_Aggf.a())
      {
        this.jdField_a_of_type_Aggg.jdField_a_of_type_Vhk = new vhk(this, this.jdField_a_of_type_Aggh);
        vhg.a().a(this.jdField_a_of_type_Aggg.jdField_a_of_type_Vhk);
        vhg.a().a(this);
        d();
        if (getIntent().getBooleanExtra("report_first_exposure", true))
        {
          localObject = (vhn)QQStoryContext.a().getBusinessHandler(1);
          if (localObject != null) {
            ((vhn)localObject).a();
          }
          getIntent().putExtra("report_first_exposure", false);
        }
      }
      this.jdField_a_of_type_Aggh.c();
      return;
      if (this.jdField_a_of_type_Aggg.jdField_b_of_type_Int == 2)
      {
        localObject = baae.m;
        break;
      }
      localObject = baae.l;
      break;
      label751:
      i = 0;
      break label545;
      label756:
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    }
  }
  
  void d()
  {
    aggf localaggf = this.jdField_a_of_type_Aggh.jdField_a_of_type_Aggf;
    Object localObject = vhg.a().a();
    if (this.jdField_a_of_type_Aggg.v) {
      vhg.a().b((List)localObject);
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      SlideItemInfo localSlideItemInfo = (SlideItemInfo)((Iterator)localObject).next();
      if (!localaggf.jdField_a_of_type_JavaUtilArrayList.contains(localSlideItemInfo.jdField_b_of_type_JavaLangString)) {
        localaggf.jdField_a_of_type_JavaUtilArrayList.add(localSlideItemInfo.jdField_b_of_type_JavaLangString);
      }
      if (!localaggf.jdField_b_of_type_JavaUtilArrayList.contains(localSlideItemInfo.a.position)) {
        localaggf.jdField_b_of_type_JavaUtilArrayList.add(localSlideItemInfo.a.position);
      }
      localaggf.jdField_a_of_type_JavaUtilHashMap.put(localSlideItemInfo.jdField_b_of_type_JavaLangString, localSlideItemInfo.a);
    }
    if (localaggf.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
      vhg.a().a(localaggf.jdField_a_of_type_JavaUtilArrayList, localaggf.jdField_b_of_type_JavaUtilHashMap, false);
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    this.jdField_a_of_type_Aggh.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void doOnBackPressed()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListFragment == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListFragment.isAdded())) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.jdField_a_of_type_Aggh.g();
      return;
    }
    a(false);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    zqk.a().c();
    getWindow().setBackgroundDrawable(null);
    super.a();
    try
    {
      super.setContentView(2131495371);
      getWindow().setBackgroundDrawable(null);
      this.jdField_a_of_type_Aggh = agih.a(getIntent().getIntExtra("enter_from", 0), this);
      this.jdField_a_of_type_Aggg = this.jdField_a_of_type_Aggh.jdField_a_of_type_Aggg;
      this.jdField_a_of_type_AndroidContentSharedPreferences = BaseApplication.getContext().getSharedPreferences("share", 4);
      paramBundle = getResources();
      int i = paramBundle.getDisplayMetrics().widthPixels;
      this.jdField_e_of_type_Int = paramBundle.getDimensionPixelSize(2131166199);
      this.jdField_c_of_type_Int = paramBundle.getDimensionPixelSize(2131166201);
      this.jdField_d_of_type_Int = paramBundle.getDimensionPixelSize(2131166202);
      this.jdField_f_of_type_Int = aciy.a(1.0F, paramBundle);
      this.jdField_a_of_type_Int = ((i - this.jdField_e_of_type_Int * 2 - this.jdField_c_of_type_Int * 2) / 3);
      this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
      paramBundle = getIntent();
      this.jdField_a_of_type_Aggh.a(paramBundle);
      c();
      if (QLog.isColorLevel()) {
        QLog.d("SelectPhotoTrace", 2, "PhotoListActivity onCreate(),extra is:" + paramBundle.getExtras());
      }
      if (QLog.isColorLevel()) {
        QLog.d("SelectPhotoTrace", 2, "PhotoListActivity,hashCode is:" + System.identityHashCode(this));
      }
      return true;
    }
    catch (Throwable paramBundle)
    {
      super.finish();
    }
    return false;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (!this.jdField_a_of_type_Aggg.o) {
      afzf.a(this).a();
    }
    if (this.jdField_a_of_type_Agfv != null)
    {
      int i = this.jdField_a_of_type_Agfv.getCount();
      baaf.jdField_a_of_type_JavaUtilHashMap.put(this.jdField_a_of_type_Aggh.jdField_a_of_type_Aggf.jdField_c_of_type_JavaLangString, Integer.valueOf(i));
    }
    if (this.jdField_a_of_type_Aggh.jdField_a_of_type_Aggf.jdField_c_of_type_Boolean) {
      BaseApplicationImpl.getApplication().getRuntime().unRegistObserver(jdField_a_of_type_Agfx);
    }
    if (this.jdField_a_of_type_Aggh.jdField_a_of_type_Aggf.a()) {
      vhg.a().f();
    }
    if (this.jdField_a_of_type_AndroidOsAsyncTask != null) {
      this.jdField_a_of_type_AndroidOsAsyncTask.cancel(true);
    }
    if (this.jdField_a_of_type_Aggh != null) {
      this.jdField_a_of_type_Aggh.b();
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("SelectPhotoTrace", 2, "PhotoListActivity onNewIntent() is called,extra is:" + paramIntent.getExtras());
    }
    if (QLog.isColorLevel()) {
      QLog.d("SelectPhotoTrace", 2, "PhotoListActivityhashCode is:" + System.identityHashCode(this));
    }
    QLog.d("PhotoListActivity", 2, "onNewIntent()");
    if (paramIntent.getBooleanExtra("extra_directly_back", false))
    {
      this.jdField_a_of_type_Aggg.u = false;
      a(paramIntent);
      QLog.d("PhotoListActivity", 2, "PhotoListActivity onNewIntent() camera back");
      if (this.jdField_a_of_type_Aggh.jdField_a_of_type_Aggf.jdField_b_of_type_JavaLangString == null) {
        break label167;
      }
      paramIntent = this.jdField_a_of_type_Aggh.jdField_a_of_type_Aggf.jdField_b_of_type_JavaLangString;
    }
    for (;;)
    {
      setTitle(paramIntent);
      return;
      setIntent(paramIntent);
      this.jdField_a_of_type_Aggh.a(paramIntent);
      break;
      label167:
      if (this.jdField_a_of_type_Aggg.jdField_b_of_type_Int == 2) {
        paramIntent = baae.m;
      } else {
        paramIntent = baae.l;
      }
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    aluq.a(BaseApplicationImpl.getContext(), 2, true);
    this.jdField_a_of_type_AndroidOsAsyncTask = null;
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    aluq.a(BaseApplicationImpl.getContext(), 2, false);
    if (this.jdField_a_of_type_Aggg.i == 100016) {
      if (!getIntent().getBooleanExtra("FROM_QZONR_NO_FINISH", false)) {
        finish();
      }
    }
    do
    {
      return;
      getIntent().removeExtra("FROM_QZONR_NO_FINISH");
      this.jdField_a_of_type_Aggg.i = 0;
      if (this.jdField_a_of_type_AndroidWidgetButton != null) {
        this.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
      }
    } while (!this.jdField_a_of_type_Aggh.jdField_a_of_type_Aggf.a());
    vhg.a().c();
    vhg.a().a(this.jdField_a_of_type_Aggg.jdField_a_of_type_Vhk);
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    if (this.jdField_a_of_type_Aggg.u)
    {
      runOnUiThread(new NewPhotoListActivity.3(this));
      return;
    }
    this.jdField_a_of_type_Aggg.u = true;
  }
  
  public void e()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidAppDialog != null) {
        f();
      }
      while (!this.jdField_a_of_type_AndroidAppDialog.isShowing())
      {
        this.jdField_a_of_type_AndroidAppDialog.show();
        return;
        this.jdField_a_of_type_AndroidAppDialog = new Dialog(this, 2131690181);
        this.jdField_a_of_type_AndroidAppDialog.setCancelable(true);
        this.jdField_a_of_type_AndroidAppDialog.show();
        this.jdField_a_of_type_AndroidAppDialog.setContentView(2131493818);
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("NewPhotoListActivity", 2, "show dialog error", localException);
      }
      this.jdField_a_of_type_AndroidAppDialog = null;
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null) {}
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.cancel();
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("NewPhotoListActivity", 2, "cancel dialog error", localIllegalArgumentException);
    }
  }
  
  public void finish()
  {
    super.finish();
  }
  
  public void g()
  {
    this.jdField_a_of_type_AndroidOsAsyncTask = new agfy(this);
    this.jdField_a_of_type_AndroidOsAsyncTask.execute(new Object[0]);
  }
  
  public void h()
  {
    if (((this.jdField_a_of_type_Aggg.q) && ("$RecentAlbumId".equals(this.jdField_a_of_type_Aggh.jdField_a_of_type_Aggf.jdField_c_of_type_JavaLangString))) || ((this.jdField_a_of_type_Aggg.r) && ("$VideoAlbumId".equals(this.jdField_a_of_type_Aggh.jdField_a_of_type_Aggf.jdField_c_of_type_JavaLangString)))) {
      g();
    }
  }
  
  public void i()
  {
    int j = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition();
    int k = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getLastVisiblePosition();
    int i = j;
    if (i <= k)
    {
      Object localObject = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getChildAt(i - j);
      LocalMediaInfo localLocalMediaInfo = this.jdField_a_of_type_Agfv.a(i);
      if (localObject == null) {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoListActivity", 2, "updateCheckbox view = null at " + i);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        if (localLocalMediaInfo == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PhotoListActivity", 2, "updateCheckbox info = null at " + i);
          }
        }
        else
        {
          int m = this.jdField_a_of_type_Aggh.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList.indexOf(localLocalMediaInfo.path);
          if (m >= 0)
          {
            localObject = (agfw)((View)localObject).getTag();
            if ((localObject != null) && (((agfw)localObject).a != null)) {
              ((agfw)localObject).a.setCheckedNumber(m + 1);
            }
          }
        }
      }
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void j()
  {
    switch (this.jdField_a_of_type_Aggg.jdField_e_of_type_Int)
    {
    case 1: 
    default: 
      return;
    case 0: 
      this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      return;
    }
    aggf localaggf = this.jdField_a_of_type_Aggh.jdField_a_of_type_Aggf;
    baaf.a(this.jdField_b_of_type_AndroidWidgetTextView, localaggf.jdField_a_of_type_JavaUtilArrayList, localaggf.jdField_b_of_type_JavaUtilHashMap, this.jdField_a_of_type_Aggg.p, this, this.jdField_a_of_type_Aggg.jdField_a_of_type_JavaUtilHashMap, localaggf.jdField_a_of_type_JavaUtilHashMap);
    this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
  }
  
  public void k()
  {
    if (kzy.b(BaseApplicationImpl.getContext())) {}
    label27:
    do
    {
      return;
      Intent localIntent = new Intent();
      Object localObject = null;
      try
      {
        File localFile = a();
        localObject = localFile;
      }
      catch (IOException localIOException)
      {
        break label27;
      }
    } while (localObject == null);
    FileProvider7Helper.setSystemCapture(this, localObject, localIntent);
    startActivityForResult(localIntent, 16);
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    aggf localaggf = this.jdField_a_of_type_Aggh.jdField_a_of_type_Aggf;
    switch (paramCompoundButton.getId())
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("PhotoListActivity", 2, "onCheckedChanged, error, default id is checked");
      }
      break;
    }
    for (;;)
    {
      return;
      if (paramBoolean) {
        if (baaf.a(localaggf.jdField_a_of_type_JavaUtilArrayList, localaggf.jdField_b_of_type_Int, localaggf.jdField_b_of_type_JavaUtilHashMap, this.jdField_a_of_type_Aggg.p, localaggf.jdField_a_of_type_JavaUtilHashMap) > 0)
        {
          bbmy.a(this, getResources().getString(2131629431), 0).b(getResources().getDimensionPixelSize(2131167766));
          this.jdField_a_of_type_Aggg.jdField_e_of_type_Int = 0;
          this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
        }
      }
      while (!this.jdField_a_of_type_Aggg.g)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        return;
        if (baaf.a(localaggf.jdField_a_of_type_JavaUtilArrayList, 104345600L, localaggf.jdField_b_of_type_JavaUtilHashMap, this.jdField_a_of_type_Aggg.p, localaggf.jdField_a_of_type_JavaUtilHashMap) > 0)
        {
          bbmy.a(this, getResources().getString(2131653694), 0).b(getResources().getDimensionPixelSize(2131167766));
          baaf.d();
        }
        this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
        this.jdField_a_of_type_Aggg.jdField_e_of_type_Int = 2;
        baaf.a(this.jdField_b_of_type_AndroidWidgetTextView, localaggf.jdField_a_of_type_JavaUtilArrayList, localaggf.jdField_b_of_type_JavaUtilHashMap, this.jdField_a_of_type_Aggg.p, this, this.jdField_a_of_type_Aggg.jdField_a_of_type_JavaUtilHashMap, localaggf.jdField_a_of_type_JavaUtilHashMap);
        continue;
        this.jdField_a_of_type_Aggg.jdField_e_of_type_Int = 0;
        this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      }
    }
  }
  
  @TargetApi(9)
  public void onClick(View paramView)
  {
    aggf localaggf = this.jdField_a_of_type_Aggh.jdField_a_of_type_Aggf;
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131302804: 
      this.jdField_a_of_type_Aggh.a(paramView);
      return;
    case 2131307750: 
    case 2131307755: 
      this.jdField_a_of_type_Aggh.b(paramView);
      return;
    case 2131304039: 
      this.jdField_a_of_type_Aggh.a(paramView, new Bundle(), 2, null);
      return;
    case 2131306214: 
      this.jdField_a_of_type_Aggh.c(paramView);
      return;
    case 2131310076: 
      this.jdField_a_of_type_Aggh.d(paramView);
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListFragment == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListFragment.isAdded())) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        this.jdField_a_of_type_Aggh.b(getIntent());
      }
      a(bool);
      return;
    }
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    super.setTitle(paramCharSequence);
    this.jdField_f_of_type_AndroidWidgetTextView.setText(paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity
 * JD-Core Version:    0.7.0.1
 */