package com.tencent.mobileqq.activity.photo.album;

import actj;
import agrg;
import agrn;
import agro;
import agrp;
import agrr;
import agrs;
import agrt;
import agru;
import agrv;
import agrz;
import agsa;
import agsc;
import aguq;
import ajsd;
import amkf;
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
import bbbw;
import bbbx;
import bbdx;
import bfpt;
import bfsh;
import blcj;
import blck;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.photo.PeakFragmentActivity;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GestureSelectGridView;
import com.tencent.widget.TriangleView;
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
import lkj;
import zzz;

public class NewPhotoListActivity
  extends PeakFragmentActivity
  implements agrg, View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  public static agru a;
  public int a;
  public agrs a;
  public agsa a;
  public agsc a;
  Dialog jdField_a_of_type_AndroidAppDialog;
  SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  public AsyncTask<Object, Object, List<LocalMediaInfo>> a;
  public Handler a;
  public View a;
  public Button a;
  public CheckBox a;
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  public TextView a;
  bfpt jdField_a_of_type_Bfpt = new agrp(this);
  bfsh jdField_a_of_type_Bfsh = new agrn(this);
  public AlbumListFragment a;
  public GestureSelectGridView a;
  TriangleView jdField_a_of_type_ComTencentWidgetTriangleView;
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
    jdField_a_of_type_Agru = new agru();
  }
  
  public NewPhotoListActivity()
  {
    this.jdField_a_of_type_AndroidOsHandler = new agrr(this);
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
        this.jdField_a_of_type_Agsc.e(paramIntent);
      }
    }
    for (;;)
    {
      bool1 = true;
      return bool1;
      label50:
      this.jdField_a_of_type_Agsc.d(paramIntent);
    }
  }
  
  public int a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (a(paramString) == null)) {
      return -1;
    }
    return bbbx.a(a(paramString));
  }
  
  public LocalMediaInfo a(String paramString)
  {
    agrz localagrz = this.jdField_a_of_type_Agsc.jdField_a_of_type_Agrz;
    LocalMediaInfo localLocalMediaInfo = null;
    if (localagrz.jdField_a_of_type_JavaUtilHashMap != null) {
      localLocalMediaInfo = (LocalMediaInfo)localagrz.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    }
    if ((localLocalMediaInfo == null) && (localagrz.jdField_b_of_type_JavaUtilHashMap != null)) {
      localLocalMediaInfo = (LocalMediaInfo)localagrz.jdField_b_of_type_JavaUtilHashMap.get(paramString);
    }
    for (;;)
    {
      if ((localLocalMediaInfo != null) && ((localLocalMediaInfo.mediaWidth == 0) || (localLocalMediaInfo.mediaHeight == 0)))
      {
        blck localblck = new blck();
        blcj.a(paramString, localblck);
        localLocalMediaInfo.mediaWidth = localblck.a[0];
        localLocalMediaInfo.mediaHeight = localblck.a[1];
        localLocalMediaInfo.rotation = localblck.a[2];
        if (localagrz.jdField_b_of_type_JavaUtilHashMap != null)
        {
          paramString = (LocalMediaInfo)localagrz.jdField_b_of_type_JavaUtilHashMap.get(paramString);
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
        this.jdField_a_of_type_Agsa.jdField_b_of_type_JavaLangString = ((File)localObject).getAbsolutePath();
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
        String str = ajsd.bj + (String)localObject;
        localObject = paramString;
        if (!str.equals(paramString))
        {
          localObject = new File(ajsd.bj);
          if (!((File)localObject).exists()) {
            ((File)localObject).mkdirs();
          }
          boolean bool2 = localFile.renameTo(new File(str));
          boolean bool1 = bool2;
          if (!bool2) {
            bool1 = bbdx.b(paramString, str);
          }
          QZLog.d("PhotoListActivity", 2, new Object[] { "saveToDCIM rename to :", str });
          localObject = paramString;
          if (bool1) {
            localObject = str;
          }
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
    ArrayList localArrayList = this.jdField_a_of_type_Agsc.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList;
    int j = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition();
    int k = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getLastVisiblePosition();
    int i = j;
    if (i <= k)
    {
      if ((paramBoolean) && (paramInt != i)) {}
      label374:
      for (;;)
      {
        i += 1;
        break;
        Object localObject = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getChildAt(i - j);
        LocalMediaInfo localLocalMediaInfo = this.jdField_a_of_type_Agrs.a(i);
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
          agrt localagrt;
          if (paramInt != i)
          {
            m = localArrayList.indexOf(localLocalMediaInfo.path);
            if (m >= 0)
            {
              localagrt = (agrt)((View)localObject).getTag();
              if ((localagrt != null) && (localagrt.a != null)) {
                localagrt.a.setCheckedNumber(m + 1);
              }
            }
          }
          else
          {
            m = bbbx.a(localLocalMediaInfo);
            if ((m == 0) || (m == 1))
            {
              localagrt = (agrt)((View)localObject).getTag();
              int n = localLocalMediaInfo.selectStatus;
              if (n == 1)
              {
                localagrt.a.setCheckedNumber(localArrayList.indexOf(localLocalMediaInfo.path) + 1);
                if (((View)localObject).getBackground() != null) {
                  ((View)localObject).setBackgroundDrawable(null);
                }
              }
              for (;;)
              {
                if (!AppSetting.d) {
                  break label374;
                }
                localObject = PhotoUtils.a(m, localLocalMediaInfo, i, localagrt.a.isChecked());
                localagrt.a.setContentDescription((CharSequence)localObject);
                break;
                if (n == 3)
                {
                  localagrt.a.setChecked(false);
                }
                else
                {
                  localagrt.a.setChecked(false);
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
  
  public void a(QQAlbumInfo paramQQAlbumInfo, int paramInt, Intent paramIntent)
  {
    String str1 = paramIntent.getStringExtra("ALBUM_NAME");
    String str2 = paramIntent.getStringExtra("ALBUM_ID");
    if (((str1 != null) && (!str1.equals(this.jdField_a_of_type_Agsc.jdField_a_of_type_Agrz.jdField_b_of_type_JavaLangString))) || ((str2 != null) && (!str2.equals(this.jdField_a_of_type_Agsc.jdField_a_of_type_Agrz.jdField_c_of_type_JavaLangString))))
    {
      paramInt = 1;
      if ((!paramQQAlbumInfo._id.equals("qzone_album")) && (paramInt != 0))
      {
        this.jdField_a_of_type_Agsc.jdField_a_of_type_Agrz.jdField_b_of_type_JavaLangString = str1;
        this.jdField_a_of_type_Agsc.jdField_a_of_type_Agrz.jdField_c_of_type_JavaLangString = str2;
        this.jdField_a_of_type_Agsc.jdField_a_of_type_Agrz.jdField_c_of_type_Int = paramIntent.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
        if (this.jdField_a_of_type_Agsc.jdField_a_of_type_Agrz.jdField_b_of_type_JavaLangString == null) {
          break label185;
        }
      }
    }
    label185:
    for (paramQQAlbumInfo = this.jdField_a_of_type_Agsc.jdField_a_of_type_Agrz.jdField_b_of_type_JavaLangString;; paramQQAlbumInfo = bbbw.l)
    {
      setTitle(paramQQAlbumInfo);
      this.jdField_a_of_type_Agsa.jdField_b_of_type_Boolean = true;
      runOnUiThread(new NewPhotoListActivity.4(this));
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
  
  public void a(List<String> paramList, HashMap<String, LocalMediaInfo> paramHashMap)
  {
    if ((paramList != null) && (paramHashMap != null) && (this.jdField_a_of_type_Agsc.jdField_a_of_type_Agrz.jdField_b_of_type_JavaUtilHashMap != null))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        if (!paramHashMap.containsKey(str)) {
          paramHashMap.put(str, this.jdField_a_of_type_Agsc.jdField_a_of_type_Agrz.jdField_b_of_type_JavaUtilHashMap.get(str));
        }
      }
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
      localObjectAnimator = ObjectAnimator.ofInt(this.jdField_a_of_type_AndroidWidgetFrameLayout, "backgroundColor", new int[] { getResources().getColor(2131165414), getResources().getColor(2131165425) });
      PhotoUtils.a(this.jdField_a_of_type_ComTencentWidgetTriangleView, false);
      localFragmentTransaction.add(2131362446, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListFragment, null);
    }
    for (;;)
    {
      localFragmentTransaction.addToBackStack(null);
      localFragmentTransaction.commit();
      localObjectAnimator.setDuration(300L);
      localObjectAnimator.setEvaluator(new ArgbEvaluator());
      localObjectAnimator.setRepeatMode(2);
      localObjectAnimator.start();
      this.jdField_a_of_type_Agsc.a(paramBoolean);
      return;
      label161:
      localObjectAnimator = ObjectAnimator.ofInt(this.jdField_a_of_type_AndroidWidgetFrameLayout, "backgroundColor", new int[] { getResources().getColor(2131165425), getResources().getColor(2131165414) });
      PhotoUtils.a(this.jdField_a_of_type_ComTencentWidgetTriangleView, true);
      localFragmentTransaction.remove(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListFragment);
    }
  }
  
  public boolean a(LocalMediaInfo paramLocalMediaInfo)
  {
    return (paramLocalMediaInfo != null) && ("image/gif".equals(paramLocalMediaInfo.mMimeType));
  }
  
  void b()
  {
    Object localObject = (RelativeLayout)findViewById(2131375493);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131362446));
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      ((RelativeLayout)localObject).setFitsSystemWindows(true);
      ((RelativeLayout)localObject).setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368429));
    this.jdField_e_of_type_AndroidWidgetTextView.setContentDescription(getResources().getString(2131690596));
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_e_of_type_AndroidWidgetTextView.setText(getResources().getString(2131690596));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368472));
    if (this.jdField_a_of_type_Agsc.jdField_a_of_type_Agrz.jdField_b_of_type_JavaLangString != null) {
      localObject = this.jdField_a_of_type_Agsc.jdField_a_of_type_Agrz.jdField_b_of_type_JavaLangString;
    }
    for (;;)
    {
      setTitle((CharSequence)localObject);
      this.jdField_a_of_type_ComTencentWidgetTriangleView = ((TriangleView)findViewById(2131368469));
      this.jdField_a_of_type_ComTencentWidgetTriangleView.setColor(this.jdField_f_of_type_AndroidWidgetTextView.getCurrentTextColor());
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131368422));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131369711));
      this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131373465));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131373471));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131373466));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131367941));
      this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131371910));
      this.jdField_c_of_type_AndroidWidgetButton = ((Button)findViewById(2131375842));
      this.jdField_a_of_type_AndroidViewView = findViewById(2131377544);
      this.jdField_b_of_type_AndroidViewView = findViewById(2131367180);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378707));
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView = ((GestureSelectGridView)findViewById(2131371514));
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setScrollBarStyle(0);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setNumColumns(3);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setColumnWidth(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setHorizontalSpacing(this.jdField_c_of_type_Int);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setVerticalSpacing(this.jdField_d_of_type_Int);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setPadding(this.jdField_e_of_type_Int, this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getPaddingTop(), this.jdField_e_of_type_Int, this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getPaddingBottom());
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setOnItemClickListener(this.jdField_a_of_type_Bfpt);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setOnIndexChangedListener(this.jdField_a_of_type_Bfsh);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setMaximumVelocity((int)(2500.0F * getResources().getDisplayMetrics().density));
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setOnScrollListener(new agro(this));
      this.jdField_a_of_type_Agrs = new agrs(this);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setAdapter(this.jdField_a_of_type_Agrs);
      this.jdField_a_of_type_Agsc.c();
      return;
      if (this.jdField_a_of_type_Agsa.jdField_b_of_type_Int == 2) {
        localObject = bbbw.m;
      } else {
        localObject = bbbw.l;
      }
    }
  }
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_Agsa.d)
    {
      bbbx.jdField_a_of_type_Long = System.currentTimeMillis();
      bbbx.jdField_a_of_type_JavaUtilHashMap.put(this.jdField_a_of_type_Agsc.jdField_a_of_type_Agrz.jdField_c_of_type_JavaLangString, Integer.valueOf(this.jdField_a_of_type_Agrs.getCount()));
      if (!TextUtils.isEmpty(paramString))
      {
        bbbx.jdField_a_of_type_JavaLangString = paramString;
        HashMap localHashMap = bbbx.jdField_c_of_type_JavaUtilHashMap;
        if (localHashMap.containsKey(paramString))
        {
          paramString = (Pair)localHashMap.get(paramString);
          bbbx.jdField_b_of_type_JavaLangString = (String)paramString.first;
          bbbx.jdField_c_of_type_JavaLangString = (String)paramString.second;
          bbbx.a(this, bbbx.jdField_b_of_type_JavaLangString, bbbx.jdField_c_of_type_JavaLangString);
        }
      }
    }
    bbbx.c();
  }
  
  public void b(boolean paramBoolean)
  {
    int i = this.jdField_a_of_type_Agsc.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.size();
    int j;
    if (((i == this.jdField_a_of_type_Agsc.jdField_a_of_type_Agrz.jdField_a_of_type_Int) && (!paramBoolean)) || ((i == this.jdField_a_of_type_Agsc.jdField_a_of_type_Agrz.jdField_a_of_type_Int - 1) && (paramBoolean)))
    {
      i = 1;
      if (i == 0) {
        return;
      }
      j = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition();
      int k = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getLastVisiblePosition();
      i = j;
      label77:
      if (i > k) {
        return;
      }
      if (this.jdField_a_of_type_Agrs.getItemViewType(i) != 2) {
        break label107;
      }
    }
    for (;;)
    {
      i += 1;
      break label77;
      i = 0;
      break;
      label107:
      Object localObject = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getChildAt(i - j);
      LocalMediaInfo localLocalMediaInfo = this.jdField_a_of_type_Agrs.a(i);
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
        localObject = (agrt)((View)localObject).getTag();
        if ((paramBoolean) || (localLocalMediaInfo.selectStatus == 1)) {
          ((agrt)localObject).b.setAlpha(1.0F);
        } else {
          ((agrt)localObject).b.setAlpha(0.3F);
        }
      }
    }
  }
  
  public void c()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidAppDialog != null) {
        d();
      }
      while (!this.jdField_a_of_type_AndroidAppDialog.isShowing())
      {
        this.jdField_a_of_type_AndroidAppDialog.show();
        return;
        this.jdField_a_of_type_AndroidAppDialog = new Dialog(this, 2131755791);
        this.jdField_a_of_type_AndroidAppDialog.setCancelable(true);
        this.jdField_a_of_type_AndroidAppDialog.show();
        this.jdField_a_of_type_AndroidAppDialog.setContentView(2131559386);
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
  
  public void d()
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
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    this.jdField_a_of_type_Agsc.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void doOnBackPressed()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListFragment == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListFragment.isAdded())) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.jdField_a_of_type_Agsc.e();
      return;
    }
    a(false);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    zzz.a().c();
    getWindow().setBackgroundDrawable(null);
    super.a();
    try
    {
      super.setContentView(2131560949);
      getWindow().setBackgroundDrawable(null);
      this.jdField_a_of_type_Agsc = aguq.a(getIntent().getIntExtra("enter_from", 0), this);
      this.jdField_a_of_type_Agsa = this.jdField_a_of_type_Agsc.jdField_a_of_type_Agsa;
      this.jdField_a_of_type_AndroidContentSharedPreferences = BaseApplication.getContext().getSharedPreferences("share", 4);
      paramBundle = getResources();
      int i = paramBundle.getDisplayMetrics().widthPixels;
      this.jdField_e_of_type_Int = paramBundle.getDimensionPixelSize(2131297280);
      this.jdField_c_of_type_Int = paramBundle.getDimensionPixelSize(2131297282);
      this.jdField_d_of_type_Int = paramBundle.getDimensionPixelSize(2131297283);
      this.jdField_f_of_type_Int = actj.a(1.0F, paramBundle);
      this.jdField_a_of_type_Int = ((i - this.jdField_e_of_type_Int * 2 - this.jdField_c_of_type_Int * 2) / 3);
      this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
      if (!CheckPermission.isHasStoragePermission(this)) {
        CheckPermission.requestStorePermission(this, null);
      }
      paramBundle = getIntent();
      this.jdField_a_of_type_Agsc.a(paramBundle);
      b();
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
    this.jdField_a_of_type_Agsc.g();
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
      this.jdField_a_of_type_Agsa.i = false;
      a(paramIntent);
      QLog.d("PhotoListActivity", 2, "PhotoListActivity onNewIntent() camera back");
      if (this.jdField_a_of_type_Agsc.jdField_a_of_type_Agrz.jdField_b_of_type_JavaLangString == null) {
        break label167;
      }
      paramIntent = this.jdField_a_of_type_Agsc.jdField_a_of_type_Agrz.jdField_b_of_type_JavaLangString;
    }
    for (;;)
    {
      setTitle(paramIntent);
      return;
      setIntent(paramIntent);
      this.jdField_a_of_type_Agsc.a(paramIntent);
      break;
      label167:
      if (this.jdField_a_of_type_Agsa.jdField_b_of_type_Int == 2) {
        paramIntent = bbbw.m;
      } else {
        paramIntent = bbbw.l;
      }
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    amkf.a(BaseApplicationImpl.getContext(), 2, true);
    this.jdField_a_of_type_AndroidOsAsyncTask = null;
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.jdField_a_of_type_Agsc.f();
  }
  
  public void doOnStart()
  {
    super.doOnStart();
  }
  
  public void e()
  {
    this.jdField_a_of_type_AndroidOsAsyncTask = new agrv(this);
    this.jdField_a_of_type_AndroidOsAsyncTask.execute(new Object[0]);
  }
  
  public void f()
  {
    if (((this.jdField_a_of_type_Agsa.f) && ("$RecentAlbumId".equals(this.jdField_a_of_type_Agsc.jdField_a_of_type_Agrz.jdField_c_of_type_JavaLangString))) || ((this.jdField_a_of_type_Agsa.g) && ("$VideoAlbumId".equals(this.jdField_a_of_type_Agsc.jdField_a_of_type_Agrz.jdField_c_of_type_JavaLangString)))) {
      e();
    }
  }
  
  public void finish()
  {
    super.finish();
  }
  
  public void g()
  {
    int j = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition();
    int k = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getLastVisiblePosition();
    int i = j;
    if (i <= k)
    {
      Object localObject = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getChildAt(i - j);
      LocalMediaInfo localLocalMediaInfo = this.jdField_a_of_type_Agrs.a(i);
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
          int m = this.jdField_a_of_type_Agsc.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.indexOf(localLocalMediaInfo.path);
          if (m >= 0)
          {
            localObject = (agrt)((View)localObject).getTag();
            if ((localObject != null) && (((agrt)localObject).a != null)) {
              ((agrt)localObject).a.setCheckedNumber(m + 1);
            }
          }
        }
      }
    }
  }
  
  public void h()
  {
    if (lkj.b(BaseApplicationImpl.getContext())) {}
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
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    agrz localagrz = this.jdField_a_of_type_Agsc.jdField_a_of_type_Agrz;
    switch (paramCompoundButton.getId())
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("PhotoListActivity", 2, "onCheckedChanged, error, default id is checked");
      }
      return;
    }
    this.jdField_a_of_type_Agsc.a(paramCompoundButton, paramBoolean);
  }
  
  @TargetApi(9)
  public void onClick(View paramView)
  {
    agrz localagrz = this.jdField_a_of_type_Agsc.jdField_a_of_type_Agrz;
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131368429: 
      this.jdField_a_of_type_Agsc.a(paramView);
      return;
    case 2131369711: 
      this.jdField_a_of_type_Agsc.a(paramView, new Bundle(), 2, null);
      return;
    case 2131371910: 
      this.jdField_a_of_type_Agsc.b(paramView);
      return;
    case 2131375842: 
      this.jdField_a_of_type_Agsc.c(paramView);
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListFragment == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListFragment.isAdded())) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        this.jdField_a_of_type_Agsc.b(getIntent());
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