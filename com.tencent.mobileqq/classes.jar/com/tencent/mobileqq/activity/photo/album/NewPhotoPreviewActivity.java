package com.tencent.mobileqq.activity.photo.album;

import agdo;
import agew;
import agfz;
import agga;
import aggb;
import aggc;
import aggd;
import aggf;
import aggs;
import aggt;
import aggv;
import aggw;
import agih;
import alrg;
import aluq;
import amym;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aweg;
import awqx;
import axwv;
import baaf;
import babr;
import badq;
import bajq;
import bbmy;
import bbqo;
import bbrm;
import beij;
import bjeh;
import bjlh;
import bjli;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.media.image.ImageManager;
import com.tencent.image.QQLiveImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.activity.aio.photo.PeakActivity;
import com.tencent.mobileqq.activity.photo.DragGallery;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity.SendVideoInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.DragView;
import com.tencent.widget.HorizontalListView;
import java.io.File;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import lor;
import vhg;
import vhk;
import vhm;

public class NewPhotoPreviewActivity
  extends PeakActivity
  implements CompoundButton.OnCheckedChangeListener, beij, vhm
{
  float jdField_a_of_type_Float = 13.0F;
  public int a;
  public agew a;
  public aggc a;
  public aggd a;
  public aggs a;
  public aggt a;
  public SurfaceView a;
  public View a;
  public Button a;
  public CheckBox a;
  public ImageView a;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public TextView a;
  public DragGallery a;
  public NumberCheckBox a;
  public BubblePopupWindow a;
  public DragView a;
  public HorizontalListView a;
  public boolean a;
  float b;
  public int b;
  public View b;
  public Button b;
  public CheckBox b;
  public RelativeLayout b;
  public TextView b;
  public View c;
  public RelativeLayout c;
  public TextView c;
  public TextView d;
  public TextView e;
  
  public NewPhotoPreviewActivity()
  {
    this.jdField_b_of_type_Float = 9.0F;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Aggc = new aggc(this);
  }
  
  public static final boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://"))) {
      return false;
    }
    return true;
  }
  
  private void f()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131297747));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131297745));
    if (this.jdField_a_of_type_Aggt.jdField_a_of_type_Aggf.a()) {
      this.jdField_a_of_type_Boolean = bjeh.a(this.jdField_a_of_type_AndroidWidgetLinearLayout, this.jdField_a_of_type_AndroidWidgetRelativeLayout, 0);
    }
    while (this.jdField_a_of_type_AndroidWidgetLinearLayout == null) {
      return;
    }
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    localLayoutParams.height = bjeh.jdField_a_of_type_Int;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void F()
  {
    Object localObject = this.jdField_a_of_type_Aggc.a(a());
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = a((String)localObject);
      if (localObject != null)
      {
        if (((LocalMediaInfo)localObject).mMediaType != 0) {
          break label77;
        }
        localObject = "0X8009AB2";
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        awqx.b(null, "dc00898", "", "", (String)localObject, (String)localObject, 4, 0, "", "", "", "");
      }
      this.jdField_a_of_type_Aggt.a(true);
      return;
      label77:
      if (((LocalMediaInfo)localObject).mMediaType == 1) {
        localObject = "0X8009AB3";
      } else {
        localObject = null;
      }
    }
  }
  
  public void G()
  {
    if (this.jdField_c_of_type_AndroidWidgetRelativeLayout != null)
    {
      Drawable localDrawable = this.jdField_c_of_type_AndroidWidgetRelativeLayout.getBackground();
      if (localDrawable != null) {
        localDrawable.mutate().setAlpha(255);
      }
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    if (this.jdField_a_of_type_Aggt.a())
    {
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(0);
    }
  }
  
  public void H() {}
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery.getSelectedItemPosition();
  }
  
  public int a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (b(paramString) == null)) {
      return -1;
    }
    return baaf.a(b(paramString));
  }
  
  public Drawable a(String paramString, int paramInt1, int paramInt2, LocalMediaInfo paramLocalMediaInfo)
  {
    amym localamym = new amym(Color.rgb(214, 214, 214), paramInt1, paramInt2);
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        URLDrawable localURLDrawable = URLDrawable.getDrawable(paramString, paramInt1, paramInt2, localamym, localamym);
        localURLDrawable.setTag(paramLocalMediaInfo);
        if (localURLDrawable.getStatus() != 1) {
          localURLDrawable.downloadImediatly();
        }
        return localURLDrawable;
      }
      catch (Exception paramLocalMediaInfo)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PhotoPreviewActivity", 2, "getCoverDrawable():  getDrawable Exception, coverUrl=" + paramString, paramLocalMediaInfo);
        }
      }
    }
    return localamym;
  }
  
  public LocalMediaInfo a(String paramString)
  {
    LocalMediaInfo localLocalMediaInfo = b(paramString);
    paramString = localLocalMediaInfo;
    if (localLocalMediaInfo == null)
    {
      paramString = new LocalMediaInfo();
      paramString.mMediaType = 0;
    }
    return paramString;
  }
  
  public String a()
  {
    return "最多只能选择" + this.jdField_a_of_type_Aggt.jdField_a_of_type_Aggf.jdField_a_of_type_Int + "张图片\\视频";
  }
  
  public URL a(File paramFile)
  {
    if (paramFile == null) {
      return null;
    }
    String str = paramFile.getPath();
    if ((!TextUtils.isEmpty(str)) && (a(str) == 1)) {
      return baaf.a(str, "VIDEO");
    }
    try
    {
      paramFile = paramFile.toURI().toURL();
      return paramFile;
    }
    catch (MalformedURLException paramFile) {}
    return null;
  }
  
  public ArrayList<String> a()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_Aggt.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList.isEmpty())
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery.getFirstVisiblePosition();
      if (i < this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaUtilArrayList.size()) {
        localArrayList.add(this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaUtilArrayList.get(i));
      }
      return localArrayList;
    }
    localArrayList.addAll(this.jdField_a_of_type_Aggt.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList);
    return localArrayList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Aggt.jdField_a_of_type_Aggw != null) {
      this.jdField_a_of_type_Aggt.jdField_a_of_type_Aggw.at_();
    }
    Object localObject = "";
    if (a() != -1)
    {
      String str = (String)this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaUtilArrayList.get(a());
      this.jdField_a_of_type_Aggt.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList.add(str);
      this.jdField_a_of_type_Aggt.jdField_a_of_type_Aggf.jdField_b_of_type_JavaUtilArrayList.add(Integer.valueOf(a()));
      localObject = str;
      if (this.jdField_a_of_type_Aggt.jdField_a_of_type_Aggf.a())
      {
        if (this.jdField_a_of_type_Aggt.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilHashMap == null) {
          this.jdField_a_of_type_Aggt.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilHashMap = new HashMap();
        }
        localObject = b(str);
        this.jdField_a_of_type_Aggt.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilHashMap.put(str, localObject);
        localObject = str;
      }
    }
    c((String)localObject);
    this.jdField_a_of_type_Aggt.c();
    b((String)this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaUtilArrayList.get(a()));
  }
  
  public void a(float paramFloat)
  {
    if (this.jdField_c_of_type_AndroidWidgetRelativeLayout != null)
    {
      Drawable localDrawable = this.jdField_c_of_type_AndroidWidgetRelativeLayout.getBackground();
      if (localDrawable != null) {
        localDrawable.mutate().setAlpha((int)(255.0F * paramFloat));
      }
    }
    if (paramFloat < 0.8F)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
      this.jdField_c_of_type_AndroidViewView.setVisibility(4);
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(4);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= 0) && (paramInt1 < this.jdField_a_of_type_Aggt.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList.size()) && (paramInt2 >= 0) && (paramInt2 < this.jdField_a_of_type_Aggt.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      Collections.swap(this.jdField_a_of_type_Aggt.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList, paramInt1, paramInt2);
      if (this.jdField_a_of_type_Aggs.jdField_a_of_type_Vhk != null)
      {
        String str = this.jdField_a_of_type_Aggs.jdField_a_of_type_Vhk.a();
        if (!TextUtils.isEmpty(str)) {
          c(str);
        }
      }
      vhg.a().b(this.jdField_a_of_type_Aggt.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Aggt.jdField_a_of_type_Aggf.jdField_b_of_type_JavaUtilHashMap);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool = false;
    String str2;
    String str1;
    if ((paramInt2 == -1) && (paramIntent != null))
    {
      if (!paramIntent.getBooleanExtra("PhotoConst.SEND_ORIGIN", false)) {
        bool = true;
      }
      str2 = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
      ThreadManager.excute(new NewPhotoPreviewActivity.1(this, str2), 64, null, true);
      if (QLog.isColorLevel()) {
        QLog.i("PhotoPreviewActivity", 2, "onActivityResultForMultiEdit hasEdit:" + bool + ", picPath:" + str2);
      }
      str1 = paramIntent.getStringExtra("key_multi_edit_source_path");
      paramInt1 = this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaUtilArrayList.indexOf(str1);
      if (paramInt1 >= 0) {
        if (!this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaUtilHashMap.containsValue(str1)) {
          break label297;
        }
      }
    }
    label297:
    for (paramIntent = agdo.a(this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaUtilHashMap, str1);; paramIntent = str1)
    {
      this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaUtilHashMap.put(paramIntent, str2);
      this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaUtilArrayList.add(paramInt1, str2);
      this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaUtilArrayList.remove(paramInt1 + 1);
      paramInt2 = this.jdField_a_of_type_Aggt.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList.indexOf(str1);
      if (paramInt2 >= 0)
      {
        this.jdField_a_of_type_Aggt.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList.add(paramInt2, str2);
        this.jdField_a_of_type_Aggt.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList.remove(paramInt2 + 1);
      }
      this.jdField_a_of_type_Aggc.notifyDataSetChanged();
      this.jdField_a_of_type_Aggd.notifyDataSetChanged();
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery.setSelection(paramInt1);
      paramIntent = PresendPicMgr.a();
      if (paramIntent != null)
      {
        paramIntent.b(str1, 1003);
        paramIntent.a(str2, this.jdField_a_of_type_Aggs.j);
      }
      return;
    }
  }
  
  public void a(Intent paramIntent, boolean paramBoolean)
  {
    i1 = 0;
    i = -1;
    Object localObject1;
    int j;
    int n;
    try
    {
      k = PhotoUtils.b((SessionInfo)getIntent().getParcelableExtra("session_info"));
      localObject1 = new HashMap();
      ArrayList localArrayList = a();
      i = 0;
      j = 0;
      n = 0;
      int m = 0;
      for (;;)
      {
        if (m >= localArrayList.size()) {
          break label266;
        }
        localObject2 = (String)localArrayList.get(m);
        if (!ImageManager.isNetworkUrl((String)localObject2)) {
          break;
        }
        m += 1;
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        k = i;
        if (QLog.isColorLevel())
        {
          QLog.e("PhotoPreviewActivity", 2, "submit", localException1);
          k = i;
        }
      }
    }
    if (a((String)localObject2) == 1)
    {
      localObject2 = b((String)localObject2);
      localObject3 = new SendVideoActivity.SendVideoInfo();
      i += 1;
      if (((((LocalMediaInfo)localObject2).mDuration > 1200000L) || (((LocalMediaInfo)localObject2).fileSize > 1048576000L)) && (this.jdField_a_of_type_Aggt.b()))
      {
        bbmy.a(this, getResources().getString(2131653672), 0).b(getResources().getDimensionPixelSize(2131167766));
        finish();
      }
    }
    label266:
    do
    {
      return;
      ((SendVideoActivity.SendVideoInfo)localObject3).fileSize = ((LocalMediaInfo)localObject2).fileSize;
      ((SendVideoActivity.SendVideoInfo)localObject3).duration = ((LocalMediaInfo)localObject2).mDuration;
      ((HashMap)localObject1).put(Integer.valueOf(n), localObject3);
      for (;;)
      {
        n += 1;
        break;
        j += 1;
      }
      localObject2 = String.valueOf(j);
      localObject3 = String.valueOf(i);
      try
      {
        paramIntent.setExtrasClassLoader(SessionInfo.class.getClassLoader());
        if (((HashMap)localObject1).isEmpty()) {
          break label621;
        }
        paramIntent.putExtra("PhotoConst.VIDEO_INFOS", (Serializable)localObject1);
        i = 1;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          boolean bool;
          i = i1;
          if (QLog.isColorLevel())
          {
            QLog.d("PhotoPreviewActivity", 2, "put extra Exception");
            i = i1;
            continue;
            bool = false;
            continue;
            if (paramBoolean)
            {
              PhotoUtils.a(this, paramIntent, localException1, this.jdField_a_of_type_Aggs.jdField_c_of_type_JavaUtilHashMap, this.jdField_a_of_type_Aggs.jdField_c_of_type_Int, true);
              setResult(-1);
              finish();
            }
            for (;;)
            {
              awqx.b(null, "CliOper", "", "", "0X8009AB1", "0X8009AB1", k, 0, (String)localObject2, (String)localObject3, "", "");
              return;
              PhotoUtils.a(this, paramIntent, localException1, this.jdField_a_of_type_Aggs.jdField_c_of_type_Int, this.jdField_a_of_type_Aggs.b);
            }
            i = 0;
          }
        }
      }
      if ((aweg.b == 0L) || (System.currentTimeMillis() - aweg.b >= 300000L)) {
        break label527;
      }
      bool = true;
      if (QLog.isColorLevel()) {
        QLog.d("PhotoPreviewActivity", 2, "upload video isConfirmed=" + bool + " allowUploadInXGTime=" + aweg.b);
      }
      if ((!badq.b(BaseApplicationImpl.getContext())) || (bool) || (i == 0) || (!this.jdField_a_of_type_Aggt.b())) {
        break label533;
      }
      localObject1 = getResources().getString(2131653417);
      paramIntent = new NewPhotoPreviewActivity.2(this, paramBoolean, paramIntent, localException1, k, (String)localObject2, (String)localObject3);
      if (bbrm.a(this, 4, new agfz(this, paramIntent))) {
        babr.a(this, 232, null, (String)localObject1, new agga(this, paramIntent), new aggb(this)).show();
      }
    } while (!QLog.isColorLevel());
    QLog.i("PhotoPreviewActivity", 2, "show shortvideo_mobile_send_confirm dialog");
  }
  
  public void a(SlideItemInfo paramSlideItemInfo)
  {
    if (paramSlideItemInfo == null) {
      return;
    }
    if (this.jdField_a_of_type_Aggt.jdField_a_of_type_Aggw != null) {
      this.jdField_a_of_type_Aggt.jdField_a_of_type_Aggw.a(paramSlideItemInfo);
    }
    int i = 0;
    label30:
    if (i < this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaUtilArrayList.size()) {
      if (!((String)this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaUtilArrayList.get(i)).equals(paramSlideItemInfo.b)) {}
    }
    for (;;)
    {
      if ((i >= 0) && (i < this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaUtilArrayList.size()))
      {
        if (!this.jdField_a_of_type_Aggt.jdField_a_of_type_Aggf.jdField_b_of_type_JavaUtilArrayList.contains(Integer.valueOf(i))) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
        int j = this.jdField_a_of_type_Aggt.jdField_a_of_type_Aggf.jdField_b_of_type_JavaUtilArrayList.indexOf(Integer.valueOf(i));
        if (j >= 0)
        {
          this.jdField_a_of_type_Aggt.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaUtilArrayList.get(i));
          this.jdField_a_of_type_Aggt.jdField_a_of_type_Aggf.jdField_b_of_type_JavaUtilArrayList.remove(j);
          if (this.jdField_a_of_type_Aggs.jdField_e_of_type_JavaUtilHashMap != null) {
            this.jdField_a_of_type_Aggs.jdField_e_of_type_JavaUtilHashMap.remove(this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaUtilArrayList.get(i));
          }
          if (this.jdField_a_of_type_Aggs.jdField_c_of_type_JavaUtilHashMap != null) {
            this.jdField_a_of_type_Aggs.jdField_c_of_type_JavaUtilHashMap.remove(this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaUtilArrayList.get(i));
          }
        }
        this.jdField_a_of_type_Aggt.c();
        b((String)this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaUtilArrayList.get(i));
        return;
        i += 1;
        break label30;
      }
      if ((i != -1) || (paramSlideItemInfo == null)) {
        break;
      }
      this.jdField_a_of_type_Aggt.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList.remove(paramSlideItemInfo.b);
      this.jdField_a_of_type_Aggt.c();
      c(paramSlideItemInfo.b);
      b(paramSlideItemInfo.b);
      return;
      i = -1;
    }
  }
  
  public void a(String paramString)
  {
    int j = 0;
    if ((this.jdField_a_of_type_Aggt.jdField_a_of_type_Aggf.a()) && (!this.jdField_a_of_type_Aggs.jdField_f_of_type_Boolean))
    {
      this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_Aggt.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_Aggt.jdField_a_of_type_Aggf.jdField_b_of_type_JavaUtilArrayList.clear();
      i = 0;
      while (i < this.jdField_a_of_type_Aggt.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList.size())
      {
        this.jdField_a_of_type_Aggt.jdField_a_of_type_Aggf.jdField_b_of_type_JavaUtilArrayList.add(Integer.valueOf(i));
        i += 1;
      }
      this.jdField_a_of_type_Aggc.notifyDataSetChanged();
      this.jdField_a_of_type_Aggs.jdField_f_of_type_Boolean = true;
    }
    int i = this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaUtilArrayList.indexOf(paramString);
    if (i < 0) {
      i = j;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery.setSelection(i);
      return;
    }
  }
  
  void a(String paramString, int paramInt)
  {
    if (paramInt >= 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setCheckedNumber(paramInt);
      return;
    }
    paramInt = this.jdField_a_of_type_Aggt.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList.indexOf(paramString) + 1;
    if (paramInt <= 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
      return;
    }
    if (this.jdField_a_of_type_Aggt.jdField_a_of_type_Aggf.a()) {
      if (a() != -1)
      {
        int i = this.jdField_a_of_type_Aggt.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList.indexOf(this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaUtilArrayList.get(a())) + 1;
        paramInt = i;
        if (i <= 0) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
        return;
      }
    }
    if (paramInt >= 1000) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setTextSize(this.jdField_b_of_type_Float);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setCheckedNumber(paramInt);
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setTextSize(this.jdField_a_of_type_Float);
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public LocalMediaInfo b(String paramString)
  {
    if (this.jdField_a_of_type_Aggt.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilHashMap != null) {}
    for (LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)this.jdField_a_of_type_Aggt.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilHashMap.get(paramString);; localLocalMediaInfo = null)
    {
      if ((localLocalMediaInfo == null) && (this.jdField_a_of_type_Aggt.jdField_a_of_type_Aggf.jdField_b_of_type_JavaUtilHashMap != null)) {
        localLocalMediaInfo = (LocalMediaInfo)this.jdField_a_of_type_Aggt.jdField_a_of_type_Aggf.jdField_b_of_type_JavaUtilHashMap.get(paramString);
      }
      for (;;)
      {
        Object localObject;
        if ((localLocalMediaInfo != null) && ((localLocalMediaInfo.mediaWidth == 0) || (localLocalMediaInfo.mediaHeight == 0)))
        {
          localObject = new bjli();
          bjlh.a(paramString, (bjli)localObject);
          localLocalMediaInfo.mediaWidth = localObject.a[0];
          localLocalMediaInfo.mediaHeight = localObject.a[1];
          localLocalMediaInfo.rotation = localObject.a[2];
          localObject = this.jdField_a_of_type_Aggt.jdField_a_of_type_Aggf.jdField_b_of_type_JavaUtilHashMap;
          if (localObject == null) {
            break label196;
          }
        }
        label196:
        for (paramString = (LocalMediaInfo)((HashMap)localObject).get(paramString);; paramString = null)
        {
          if ((paramString != null) && ((paramString.mediaWidth == 0) || (paramString.mediaHeight == 0)))
          {
            paramString.mediaWidth = localLocalMediaInfo.mediaWidth;
            paramString.mediaHeight = localLocalMediaInfo.mediaHeight;
            paramString.rotation = localLocalMediaInfo.rotation;
          }
          return localLocalMediaInfo;
        }
      }
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Aggs.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
    if (this.jdField_a_of_type_Aggt.jdField_a_of_type_Aggf.a()) {
      if (this.jdField_a_of_type_Aggs.jdField_a_of_type_Vhk != null) {
        this.jdField_a_of_type_Aggs.jdField_a_of_type_Vhk.c();
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) {
        this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b();
      }
      return;
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
      this.jdField_c_of_type_AndroidViewView.setVisibility(4);
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(4);
    }
  }
  
  public void b(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1)
    {
      setResult(-1, paramIntent);
      finish();
    }
  }
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_Aggt.jdField_a_of_type_Aggf.a())
    {
      if (this.jdField_a_of_type_Aggs.jdField_a_of_type_Vhk == null) {
        this.jdField_a_of_type_Aggs.jdField_a_of_type_Vhk = new vhk(this, this);
      }
      vhg.a().a(this.jdField_a_of_type_Aggs.jdField_a_of_type_Vhk);
      vhg.a().b(this.jdField_a_of_type_Aggt.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Aggt.jdField_a_of_type_Aggf.jdField_b_of_type_JavaUtilHashMap);
      vhg.a().a(this);
      this.jdField_a_of_type_Aggs.jdField_a_of_type_Vhk.a(this.jdField_a_of_type_Aggt.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList.indexOf(paramString));
      if (this.jdField_a_of_type_Boolean)
      {
        paramString = (RelativeLayout)findViewById(2131311520);
        ((ViewGroup)paramString.getParent()).removeView(paramString);
        Object localObject = paramString.getLayoutParams();
        localObject = new RelativeLayout.LayoutParams(((ViewGroup.LayoutParams)localObject).width, ((ViewGroup.LayoutParams)localObject).height);
        ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
        ((RelativeLayout.LayoutParams)localObject).topMargin = bajq.a(8.0F);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramString, (ViewGroup.LayoutParams)localObject);
      }
    }
  }
  
  public void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1)
    {
      setResult(-1, paramIntent);
      finish();
    }
  }
  
  public void c(String paramString)
  {
    a(paramString, -1);
  }
  
  public void d()
  {
    this.jdField_a_of_type_Aggs.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    if (this.jdField_a_of_type_Aggt.jdField_a_of_type_Aggf.a()) {
      if (this.jdField_a_of_type_Aggs.jdField_a_of_type_Vhk != null) {
        this.jdField_a_of_type_Aggs.jdField_a_of_type_Vhk.d();
      }
    }
    do
    {
      return;
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    } while (!this.jdField_a_of_type_Aggt.a());
    this.jdField_c_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(0);
  }
  
  public void d(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1) {
      AIOLongShotHelper.a(this, paramIntent);
    }
    while ((paramIntent == null) || (!paramIntent.getBooleanExtra("NOCANCEL4DATALIN", false))) {
      return;
    }
    setResult(-1, paramIntent);
    finish();
  }
  
  public void e()
  {
    switch (this.jdField_a_of_type_Aggs.jdField_c_of_type_Int)
    {
    case 1: 
    default: 
      return;
    case 0: 
      this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131629435));
      this.jdField_b_of_type_AndroidWidgetCheckBox.setChecked(false);
      return;
    }
    this.jdField_a_of_type_Aggt.a(this.jdField_b_of_type_AndroidWidgetTextView);
    this.jdField_b_of_type_AndroidWidgetCheckBox.setChecked(true);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (QLog.isDevelopLevel()) {
      QLog.d("PhotoPreviewActivity", 4, "[PhotoPreviewActivity] [onActivityResult] requestCode = " + paramInt1 + "  resultCode:" + paramInt2 + "  ok:" + -1);
    }
    this.jdField_a_of_type_Aggt.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery.a(false))) {
      return;
    }
    this.jdField_a_of_type_Aggt.a(false);
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    switch (paramCompoundButton.getId())
    {
    }
    for (;;)
    {
      if ((!this.jdField_b_of_type_AndroidWidgetCheckBox.isChecked()) && (!this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()))
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
      }
      return;
      if (paramBoolean)
      {
        paramCompoundButton = this.jdField_a_of_type_AndroidWidgetCheckBox;
        if (!paramBoolean) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          paramCompoundButton.setChecked(paramBoolean);
          this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(2147483647);
          if (baaf.a(this.jdField_a_of_type_Aggt.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Aggt.jdField_a_of_type_Aggf.jdField_b_of_type_Int, this.jdField_a_of_type_Aggt.jdField_a_of_type_Aggf.jdField_b_of_type_JavaUtilHashMap, true, this.jdField_a_of_type_Aggt.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilHashMap) <= 0) {
            break label213;
          }
          bbmy.a(this, getResources().getString(2131629431), 0).b(getResources().getDimensionPixelSize(2131167766));
          this.jdField_a_of_type_Aggs.jdField_c_of_type_Int = 0;
          this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131629435));
          this.jdField_b_of_type_AndroidWidgetCheckBox.setChecked(false);
          break;
        }
        label213:
        if (this.jdField_a_of_type_Aggt.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList.isEmpty())
        {
          int j = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery.getFirstVisiblePosition();
          if (j < this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaUtilArrayList.size())
          {
            long l = new File((String)this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaUtilArrayList.get(j)).length();
            if (a((String)this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaUtilArrayList.get(j)) == 1) {}
            for (int i = 1;; i = 0)
            {
              if ((i != 0) || (l <= axwv.a())) {
                break label385;
              }
              bbmy.a(this, getResources().getString(2131629431), 0).b(getResources().getDimensionPixelSize(2131167766));
              this.jdField_a_of_type_Aggs.jdField_c_of_type_Int = 0;
              this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131629435));
              this.jdField_b_of_type_AndroidWidgetCheckBox.setChecked(false);
              break;
            }
            if ((i != 0) && (l > 104345600L))
            {
              bbmy.a(this, getResources().getString(2131653694), 0).b(getResources().getDimensionPixelSize(2131167766));
              baaf.d();
            }
            a("", 1);
            this.jdField_a_of_type_Aggt.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaUtilArrayList.get(j));
            this.jdField_a_of_type_Aggt.jdField_a_of_type_Aggf.jdField_b_of_type_JavaUtilArrayList.add(Integer.valueOf(j));
            this.jdField_b_of_type_AndroidWidgetCheckBox.setChecked(true);
            this.jdField_a_of_type_Aggs.jdField_c_of_type_Int = 2;
            this.jdField_a_of_type_Aggt.a(this.jdField_b_of_type_AndroidWidgetTextView);
            this.jdField_a_of_type_Aggt.c();
            paramCompoundButton = PresendPicMgr.a();
            if ((paramCompoundButton != null) && (a((String)this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaUtilArrayList.get(j)) != 1)) {
              paramCompoundButton.a((String)this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaUtilArrayList.get(j), this.jdField_a_of_type_Aggs.j);
            }
            paramCompoundButton = getIntent();
            if ((paramCompoundButton != null) && (paramCompoundButton.hasExtra("custom_photopreview_rawcheckbox_reportActionName")))
            {
              paramCompoundButton = paramCompoundButton.getStringExtra("custom_photopreview_rawcheckbox_reportActionName");
              if (paramCompoundButton != null) {
                awqx.b(null, "CliOper", "", "", paramCompoundButton, paramCompoundButton, 0, 0, "", "", "", "");
              }
            }
          }
        }
        else
        {
          if (baaf.a(this.jdField_a_of_type_Aggt.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList, 104345600L, this.jdField_a_of_type_Aggt.jdField_a_of_type_Aggf.jdField_b_of_type_JavaUtilHashMap, true, this.jdField_a_of_type_Aggt.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilHashMap) > 0)
          {
            bbmy.a(this, getResources().getString(2131653694), 0).b(getResources().getDimensionPixelSize(2131167766));
            baaf.d();
          }
          this.jdField_b_of_type_AndroidWidgetCheckBox.setChecked(true);
          this.jdField_a_of_type_Aggs.jdField_c_of_type_Int = 2;
          this.jdField_a_of_type_Aggt.a(this.jdField_b_of_type_AndroidWidgetTextView);
          paramCompoundButton = getIntent();
          if ((paramCompoundButton != null) && (paramCompoundButton.hasExtra("custom_photopreview_rawcheckbox_reportActionName")))
          {
            paramCompoundButton = paramCompoundButton.getStringExtra("custom_photopreview_rawcheckbox_reportActionName");
            if (paramCompoundButton != null) {
              awqx.b(null, "CliOper", "", "", paramCompoundButton, paramCompoundButton, 0, 0, "", "", "", "");
            }
          }
        }
      }
      else
      {
        label385:
        this.jdField_b_of_type_AndroidWidgetCheckBox.setChecked(false);
        this.jdField_a_of_type_Aggs.jdField_c_of_type_Int = 0;
        this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131629435));
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
        continue;
        this.jdField_a_of_type_Aggt.jdField_a_of_type_Aggv.b(paramBoolean);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.jdField_a_of_type_Aggt = agih.a(getIntent().getIntExtra("enter_from", 0), this);
    this.jdField_a_of_type_Aggs = this.jdField_a_of_type_Aggt.jdField_a_of_type_Aggs;
    bjeh.a(this);
    this.jdField_a_of_type_Aggt.a(getIntent());
    if (this.jdField_a_of_type_Aggt.jdField_a_of_type_Aggf.jdField_a_of_type_JavaLangString == null) {
      this.jdField_a_of_type_Aggt.jdField_a_of_type_Aggf.jdField_a_of_type_JavaLangString = this.q;
    }
    if (bjeh.c()) {
      bjeh.b(this);
    }
    super.onCreate(paramBundle);
    super.setContentView(2131493817);
    f();
    if (Build.VERSION.SDK_INT == 19)
    {
      paramBundle = getWindow().getDecorView();
      paramBundle.setSystemUiVisibility(paramBundle.getSystemUiVisibility() | 0x4 | 0x100 | 0x1000);
    }
    this.jdField_a_of_type_Aggt.b();
  }
  
  public void onDestroy()
  {
    getIntent().putExtra("PhotoConst.SEND_BUSINESS_TYPE", this.jdField_a_of_type_Aggs.jdField_e_of_type_Int);
    if (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b();
    }
    QQLiveImage.onBackground(this);
    super.onDestroy();
    try
    {
      Iterator localIterator = this.jdField_a_of_type_Aggt.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (String)localIterator.next();
        if (localObject2 != null)
        {
          localObject2 = new File((String)localObject2);
          URLDrawable.removeMemoryCacheByUrl(((File)localObject2).toURL().toString());
          URLDrawable.removeMemoryCacheByUrl(((File)localObject2).toURL().toString() + "#NOSAMPLE");
        }
      }
      try
      {
        Object localObject1 = (String)this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaUtilArrayList.get(0);
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject1 = BaseApplicationImpl.sImageCache.remove((String)localObject1 + "#short_video_camera_preview_cache");
          if ((localObject1 instanceof Bitmap))
          {
            if (QLog.isColorLevel()) {
              QLog.d("PhotoPreviewActivity", 2, "recycle short video preview cache");
            }
            alrg.a((Bitmap)localObject1);
          }
        }
      }
      catch (Throwable localThrowable)
      {
        break label245;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PhotoPreviewActivity", 2, "remove file error");
      }
      if ((this.jdField_a_of_type_Aggs.jdField_f_of_type_Int != 103) || (this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaUtilArrayList == null)) {}
    }
    label245:
    if (this.jdField_a_of_type_Agew != null) {
      this.jdField_a_of_type_Agew.k();
    }
    this.jdField_a_of_type_Agew = null;
    if (this.jdField_a_of_type_Aggt.jdField_a_of_type_Aggf.a()) {
      vhg.a().f();
    }
    if (this.jdField_a_of_type_Aggt != null) {
      this.jdField_a_of_type_Aggt.a();
    }
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    this.jdField_a_of_type_Aggt.a(paramIntent);
    this.jdField_a_of_type_Aggt.b();
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Agew != null) {
      this.jdField_a_of_type_Agew.i();
    }
    lor.a(BaseApplicationImpl.getContext(), false);
    bbqo.a(BaseApplicationImpl.getContext(), true);
    aluq.a(BaseApplicationImpl.getContext(), 2, true);
  }
  
  @TargetApi(9)
  public void onResume()
  {
    super.onResume();
    QQLiveImage.onForeground(this);
    if ((this.jdField_a_of_type_Aggs.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidViewView != null)) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    lor.a(BaseApplicationImpl.getContext(), true);
    bbqo.a(BaseApplicationImpl.getContext(), false);
    aluq.a(BaseApplicationImpl.getContext(), 2, false);
    if (this.jdField_a_of_type_AndroidWidgetButton != null) {
      this.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
    }
    if (this.jdField_a_of_type_Agew != null) {
      this.jdField_a_of_type_Agew.j();
    }
    if (this.jdField_a_of_type_Aggt.jdField_a_of_type_Aggf.a())
    {
      vhg.a().c();
      vhg.a().a(this.jdField_a_of_type_Aggs.jdField_a_of_type_Vhk);
      vhg.a().b(this.jdField_a_of_type_Aggt.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Aggt.jdField_a_of_type_Aggf.jdField_b_of_type_JavaUtilHashMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity
 * JD-Core Version:    0.7.0.1
 */