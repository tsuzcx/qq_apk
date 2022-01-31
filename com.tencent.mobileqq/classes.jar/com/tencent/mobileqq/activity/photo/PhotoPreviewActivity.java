package com.tencent.mobileqq.activity.photo;

import NS_MOBILE_OPERATION.PicInfo;
import aciy;
import adwz;
import agcc;
import agcd;
import agce;
import agcf;
import agcg;
import agch;
import agci;
import agcj;
import agck;
import agcl;
import agcm;
import agcn;
import agco;
import agcp;
import agcq;
import agcr;
import agcu;
import agcv;
import agcw;
import agcx;
import agda;
import agdb;
import agdc;
import agdo;
import ageh;
import agew;
import agfd;
import ahji;
import ajia;
import ajjy;
import alrg;
import aluq;
import amym;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
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
import atpd;
import aweg;
import awqm;
import awqx;
import axwv;
import baaf;
import babr;
import bace;
import badq;
import bajq;
import bass;
import basu;
import basv;
import basw;
import bbms;
import bbmy;
import bbqo;
import bbrm;
import beij;
import bfpr;
import bjeh;
import bjlh;
import bjli;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.media.image.ImageManager;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.image.QQLiveImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.activity.aio.photo.PeakActivity;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity.SendVideoInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.DragView;
import com.tencent.widget.HorizontalListView;
import common.config.service.QzoneConfig;
import cooperation.qzone.model.BaseBusinessAlbumInfo;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import java.io.File;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import lor;
import mqq.app.AppRuntime;
import urp;
import vhg;
import vhj;
import vhk;
import vhm;

public class PhotoPreviewActivity
  extends PeakActivity
  implements CompoundButton.OnCheckedChangeListener, beij, vhm
{
  public static int a;
  public boolean A;
  public boolean B;
  public boolean C;
  public boolean D;
  public boolean E;
  public boolean F;
  public boolean G;
  public boolean H;
  public boolean I = false;
  public boolean J = false;
  boolean K = false;
  public boolean L;
  public boolean M = false;
  private boolean N;
  private boolean O;
  private boolean P;
  private boolean Q;
  private boolean R;
  private boolean S;
  private boolean T;
  private boolean U;
  private boolean V;
  private float jdField_a_of_type_Float = 13.0F;
  public long a;
  public agdb a;
  agdc jdField_a_of_type_Agdc;
  public agew a;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  public SparseArray<URLDrawable> a;
  SurfaceHolder.Callback jdField_a_of_type_AndroidViewSurfaceHolder$Callback = new agck(this);
  public SurfaceView a;
  View jdField_a_of_type_AndroidViewView;
  public Button a;
  public CheckBox a;
  public ImageView a;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public bass a;
  private basu jdField_a_of_type_Basu = new agco(this);
  private basv jdField_a_of_type_Basv = new agcn(this);
  private bbms jdField_a_of_type_Bbms;
  SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = null;
  public DragGallery a;
  public NumberCheckBox a;
  BubblePopupWindow jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
  public DragView a;
  HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  public String a;
  public ArrayList<String> a;
  HashMap<String, String> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  vhk jdField_a_of_type_Vhk;
  boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float = 9.0F;
  public int b;
  View jdField_b_of_type_AndroidViewView;
  public Button b;
  public CheckBox b;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  String jdField_b_of_type_JavaLangString;
  public ArrayList<String> b;
  public HashMap<String, PhotoSendParams> b;
  public boolean b;
  public int c;
  View jdField_c_of_type_AndroidViewView;
  private RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  protected TextView c;
  String jdField_c_of_type_JavaLangString;
  public ArrayList<Integer> c;
  public HashMap<String, PhotoSendParams> c;
  public boolean c;
  public int d;
  public TextView d;
  String d;
  public HashMap<String, PicInfo> d;
  public boolean d;
  public int e;
  TextView e;
  public String e;
  public HashMap<String, PicInfo> e;
  int jdField_f_of_type_Int = 0;
  public String f;
  HashMap<String, byte[]> jdField_f_of_type_JavaUtilHashMap;
  public boolean f;
  public int g;
  String g;
  public HashMap<String, LocalMediaInfo> g;
  public boolean g;
  public int h;
  String jdField_h_of_type_JavaLangString;
  private HashMap<String, Integer> jdField_h_of_type_JavaUtilHashMap;
  boolean jdField_h_of_type_Boolean;
  public int i;
  String jdField_i_of_type_JavaLangString;
  boolean jdField_i_of_type_Boolean;
  public int j;
  String j;
  public boolean j;
  public int k;
  String k;
  public boolean k;
  public int l;
  String jdField_l_of_type_JavaLangString;
  boolean jdField_l_of_type_Boolean;
  int jdField_m_of_type_Int = 0;
  String jdField_m_of_type_JavaLangString;
  boolean jdField_m_of_type_Boolean;
  public int n;
  String jdField_n_of_type_JavaLangString;
  boolean jdField_n_of_type_Boolean;
  public int o;
  String o;
  public boolean o;
  public int p;
  public String p;
  public boolean p;
  public int q;
  public boolean q;
  public int r;
  private String jdField_r_of_type_JavaLangString;
  boolean jdField_r_of_type_Boolean;
  public int s;
  private String jdField_s_of_type_JavaLangString;
  boolean jdField_s_of_type_Boolean;
  public int t;
  boolean t;
  private int jdField_u_of_type_Int;
  boolean jdField_u_of_type_Boolean = false;
  boolean v = false;
  public boolean w = false;
  boolean x = false;
  public boolean y = false;
  public boolean z;
  
  static
  {
    jdField_a_of_type_Int = (int)axwv.a();
  }
  
  public PhotoPreviewActivity()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = true;
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_e_of_type_Int = 0;
    this.jdField_g_of_type_JavaLangString = null;
    this.jdField_n_of_type_Int = 0;
    this.jdField_o_of_type_Int = 1007;
    this.jdField_a_of_type_Bass = new basw();
    this.jdField_o_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  }
  
  private URL a(File paramFile)
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
  
  private void a(int paramInt1, int paramInt2, Intent paramIntent)
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
      ThreadManager.excute(new PhotoPreviewActivity.1(this, str2), 64, null, true);
      if (QLog.isColorLevel()) {
        QLog.i("PhotoPreviewActivity", 2, "onActivityResultForMultiEdit hasEdit:" + bool + ", picPath:" + str2);
      }
      str1 = paramIntent.getStringExtra("key_multi_edit_source_path");
      paramInt1 = this.jdField_a_of_type_JavaUtilArrayList.indexOf(str1);
      if (paramInt1 >= 0) {
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsValue(str1)) {
          break label258;
        }
      }
    }
    label258:
    for (paramIntent = agdo.a(this.jdField_a_of_type_JavaUtilHashMap, str1);; paramIntent = str1)
    {
      this.jdField_a_of_type_JavaUtilHashMap.put(paramIntent, str2);
      this.jdField_a_of_type_JavaUtilArrayList.add(paramInt1, str2);
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramInt1 + 1);
      paramInt2 = this.jdField_b_of_type_JavaUtilArrayList.indexOf(str1);
      if (paramInt2 >= 0)
      {
        this.jdField_b_of_type_JavaUtilArrayList.add(paramInt2, str2);
        this.jdField_b_of_type_JavaUtilArrayList.remove(paramInt2 + 1);
      }
      this.jdField_a_of_type_Agdb.notifyDataSetChanged();
      this.jdField_a_of_type_Agdc.notifyDataSetChanged();
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery.setSelection(paramInt1);
      paramIntent = PresendPicMgr.a();
      if (paramIntent != null)
      {
        paramIntent.b(str1, 1003);
        paramIntent.a(str2, this.jdField_o_of_type_Int);
      }
      return;
    }
  }
  
  private void a(Intent paramIntent, boolean paramBoolean)
  {
    i6 = 0;
    i1 = -1;
    Object localObject1;
    int i2;
    int i5;
    try
    {
      i3 = PhotoUtils.b((SessionInfo)getIntent().getParcelableExtra("session_info"));
      localObject1 = new HashMap();
      ArrayList localArrayList = a();
      i1 = 0;
      i2 = 0;
      i5 = 0;
      int i4 = 0;
      for (;;)
      {
        if (i4 >= localArrayList.size()) {
          break label264;
        }
        localObject2 = (String)localArrayList.get(i4);
        if (!ImageManager.isNetworkUrl((String)localObject2)) {
          break;
        }
        i4 += 1;
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        i3 = i1;
        if (QLog.isColorLevel())
        {
          QLog.e("PhotoPreviewActivity", 2, "submit", localException1);
          i3 = i1;
        }
      }
    }
    if (a((String)localObject2) == 1)
    {
      localObject2 = b((String)localObject2);
      localObject3 = new SendVideoActivity.SendVideoInfo();
      i1 += 1;
      if (((((LocalMediaInfo)localObject2).mDuration > 1200000L) || (((LocalMediaInfo)localObject2).fileSize > 1048576000L)) && (!this.z))
      {
        bbmy.a(this, getResources().getString(2131653672), 0).b(getResources().getDimensionPixelSize(2131167766));
        finish();
      }
    }
    label264:
    do
    {
      return;
      ((SendVideoActivity.SendVideoInfo)localObject3).fileSize = ((LocalMediaInfo)localObject2).fileSize;
      ((SendVideoActivity.SendVideoInfo)localObject3).duration = ((LocalMediaInfo)localObject2).mDuration;
      ((HashMap)localObject1).put(Integer.valueOf(i5), localObject3);
      for (;;)
      {
        i5 += 1;
        break;
        i2 += 1;
      }
      localObject2 = String.valueOf(i2);
      localObject3 = String.valueOf(i1);
      try
      {
        paramIntent.setExtrasClassLoader(SessionInfo.class.getClassLoader());
        if (((HashMap)localObject1).isEmpty()) {
          break label607;
        }
        paramIntent.putExtra("PhotoConst.VIDEO_INFOS", (Serializable)localObject1);
        i1 = 1;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          boolean bool;
          i1 = i6;
          if (QLog.isColorLevel())
          {
            QLog.d("PhotoPreviewActivity", 2, "put extra Exception");
            i1 = i6;
            continue;
            bool = false;
            continue;
            if (paramBoolean)
            {
              PhotoUtils.a(this, paramIntent, localException1, this.jdField_c_of_type_JavaUtilHashMap, this.jdField_e_of_type_Int, true);
              setResult(-1);
              finish();
            }
            for (;;)
            {
              awqx.b(null, "CliOper", "", "", "0X8009AB1", "0X8009AB1", i3, 0, (String)localObject2, (String)localObject3, "", "");
              return;
              PhotoUtils.a(this, paramIntent, localException1, this.jdField_e_of_type_Int, this.jdField_h_of_type_Boolean);
            }
            i1 = 0;
          }
        }
      }
      if ((aweg.b == 0L) || (System.currentTimeMillis() - aweg.b >= 300000L)) {
        break label525;
      }
      bool = true;
      if (QLog.isColorLevel()) {
        QLog.d("PhotoPreviewActivity", 2, "upload video isConfirmed=" + bool + " allowUploadInXGTime=" + aweg.b);
      }
      if ((!badq.b(BaseApplicationImpl.getContext())) || (bool) || (i1 == 0) || (this.z)) {
        break label531;
      }
      localObject1 = getResources().getString(2131653417);
      paramIntent = new PhotoPreviewActivity.15(this, paramBoolean, paramIntent, localException1, i3, (String)localObject2, (String)localObject3);
      if (bbrm.a(this, 4, new agch(this, paramIntent))) {
        babr.a(this, 232, null, (String)localObject1, new agci(this, paramIntent), new agcj(this)).show();
      }
    } while (!QLog.isColorLevel());
    QLog.i("PhotoPreviewActivity", 2, "show shortvideo_mobile_send_confirm dialog");
  }
  
  public static final boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://"))) {
      return false;
    }
    return true;
  }
  
  private int b()
  {
    if (this.jdField_b_of_type_JavaUtilArrayList != null)
    {
      int i2 = 0;
      for (int i1 = 0;; i1 = i3)
      {
        i3 = i1;
        if (i2 >= this.jdField_b_of_type_JavaUtilArrayList.size()) {
          break;
        }
        i3 = i1;
        if (a((String)this.jdField_b_of_type_JavaUtilArrayList.get(i2)) == 1) {
          i3 = i1 + 1;
        }
        i2 += 1;
      }
    }
    int i3 = 0;
    return i3;
  }
  
  private void b(int paramInt)
  {
    if (d()) {
      if ((this.jdField_t_of_type_Int >= 0) && (this.jdField_t_of_type_Int < this.jdField_a_of_type_JavaUtilArrayList.size()))
      {
        int i1 = this.jdField_b_of_type_JavaUtilArrayList.indexOf(this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_t_of_type_Int)) + 1;
        paramInt = i1;
        if (i1 <= 0) {
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
  
  private void b(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1)
    {
      setResult(-1, paramIntent);
      finish();
    }
  }
  
  private void b(String paramString)
  {
    if (d())
    {
      if (this.jdField_a_of_type_Vhk == null) {
        this.jdField_a_of_type_Vhk = new vhk(this, this);
      }
      vhg.a().a(this.jdField_a_of_type_Vhk);
      vhg.a().b(this.jdField_b_of_type_JavaUtilArrayList, PhotoListActivity.jdField_a_of_type_JavaUtilHashMap);
      vhg.a().a(this);
      this.jdField_a_of_type_Vhk.a(this.jdField_b_of_type_JavaUtilArrayList.indexOf(paramString));
      if (this.V)
      {
        paramString = (RelativeLayout)findViewById(2131311520);
        ((ViewGroup)paramString.getParent()).removeView(paramString);
        Object localObject = paramString.getLayoutParams();
        localObject = new RelativeLayout.LayoutParams(((ViewGroup.LayoutParams)localObject).width, ((ViewGroup.LayoutParams)localObject).height);
        ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
        ((RelativeLayout.LayoutParams)localObject).topMargin = bajq.a(8.0F);
        this.jdField_c_of_type_AndroidWidgetRelativeLayout.addView(paramString, (ViewGroup.LayoutParams)localObject);
      }
    }
  }
  
  private void c(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(paramInt);
    this.jdField_b_of_type_AndroidWidgetCheckBox.setVisibility(paramInt);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(paramInt);
    if (paramInt == 0) {
      if (this.jdField_i_of_type_Boolean) {
        if (this.jdField_b_of_type_Int == 9501)
        {
          this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          this.jdField_b_of_type_AndroidWidgetCheckBox.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          if ((this.O) && (this.jdField_e_of_type_JavaUtilHashMap.size() == 0))
          {
            this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
            this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
            this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
            this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new agcp(this));
            this.jdField_a_of_type_AndroidWidgetCheckBox.setContentDescription(ajjy.a(2131642348));
            this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(ajjy.a(2131642343));
          }
        }
      }
    }
    label253:
    while (this.jdField_a_of_type_AndroidWidgetCheckBox.getVisibility() != 0) {
      for (;;)
      {
        return;
        if ((this.C) && (this.jdField_c_of_type_JavaUtilHashMap.size() != 0))
        {
          this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        }
        else
        {
          this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
          continue;
          if (this.jdField_j_of_type_Boolean) {
            this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
          }
          for (;;)
          {
            if ((!this.C) && (!this.D)) {
              break label253;
            }
            this.jdField_b_of_type_AndroidWidgetCheckBox.setVisibility(0);
            this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
            break;
            this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          }
          this.jdField_b_of_type_AndroidWidgetCheckBox.setVisibility(8);
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        }
      }
    }
    this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(paramInt);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(paramInt);
  }
  
  private void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1)
    {
      setResult(-1, paramIntent);
      finish();
    }
  }
  
  private boolean c()
  {
    if (QzoneConfig.getInstance().getConfig("PhotoUpload", "C2CAioEnableSyncImageToQzone", 1) == 0) {}
    while ((this.jdField_b_of_type_Int != 0) && (this.jdField_b_of_type_Int != 1000) && (this.jdField_b_of_type_Int != 1004)) {
      return false;
    }
    return true;
  }
  
  private void d(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(paramInt);
    this.jdField_b_of_type_AndroidWidgetCheckBox.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    if (this.jdField_a_of_type_AndroidWidgetCheckBox.getVisibility() == 0)
    {
      this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(paramInt);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(paramInt);
    }
  }
  
  private void d(int paramInt1, int paramInt2, Intent paramIntent)
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
  
  private boolean d()
  {
    if (Build.VERSION.SDK_INT < 17) {}
    while ((!this.jdField_l_of_type_Boolean) && (!this.jdField_m_of_type_Boolean) && (!this.jdField_n_of_type_Boolean) && (!this.jdField_r_of_type_Boolean) && (!this.jdField_s_of_type_Boolean)) {
      return false;
    }
    return true;
  }
  
  private void e(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (this.jdField_n_of_type_Boolean))
    {
      setResult(paramInt2, paramIntent);
      finish();
    }
    do
    {
      do
      {
        return;
      } while (!this.jdField_n_of_type_Boolean);
      paramIntent = paramIntent.getStringExtra("PhotoConst.FROM_QQSTORY_SLIDESHOW_DATA");
    } while (TextUtils.isEmpty(paramIntent));
    bace.a(new File(paramIntent).getParent());
  }
  
  private void f(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (this.jdField_r_of_type_Boolean))
    {
      setResult(paramInt2, paramIntent);
      finish();
    }
    do
    {
      do
      {
        return;
      } while (!this.jdField_r_of_type_Boolean);
      paramIntent = paramIntent.getStringExtra("PhotoConst.FROM_QQSTORY_SLIDESHOW_DATA");
    } while (TextUtils.isEmpty(paramIntent));
    bace.a(new File(paramIntent).getParent());
  }
  
  private void n()
  {
    this.V = false;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131297747));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131297745));
    if (d()) {
      this.V = bjeh.a(this.jdField_a_of_type_AndroidWidgetLinearLayout, this.jdField_c_of_type_AndroidWidgetRelativeLayout, 0);
    }
    while (this.jdField_a_of_type_AndroidWidgetLinearLayout == null) {
      return;
    }
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    localLayoutParams.height = bjeh.jdField_a_of_type_Int;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.V = true;
  }
  
  private void o()
  {
    bbmy.a(this, 1, ajjy.a(2131642344), 1).a();
  }
  
  private void p()
  {
    if (this.jdField_a_of_type_Bbms == null) {
      this.jdField_a_of_type_Bbms = new bbms(this, getResources().getDimensionPixelSize(2131167766));
    }
    if (!this.jdField_a_of_type_Bbms.isShowing())
    {
      this.jdField_a_of_type_Bbms.c(2131628457);
      this.jdField_a_of_type_Bbms.show();
    }
  }
  
  private void q()
  {
    if ((this.jdField_a_of_type_Bbms != null) && (this.jdField_a_of_type_Bbms.isShowing())) {
      this.jdField_a_of_type_Bbms.dismiss();
    }
  }
  
  public void F()
  {
    Object localObject = this.jdField_a_of_type_Agdb.a(this.jdField_t_of_type_Int);
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = a((String)localObject);
      if (localObject != null)
      {
        if (((LocalMediaInfo)localObject).mMediaType != 0) {
          break label76;
        }
        localObject = "0X8009AB2";
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        awqx.b(null, "dc00898", "", "", (String)localObject, (String)localObject, 4, 0, "", "", "", "");
      }
      a(true);
      return;
      label76:
      if (((LocalMediaInfo)localObject).mMediaType == 1) {
        localObject = "0X8009AB3";
      } else {
        localObject = null;
      }
    }
  }
  
  public void G()
  {
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null)
    {
      Drawable localDrawable = this.jdField_b_of_type_AndroidWidgetRelativeLayout.getBackground();
      if (localDrawable != null) {
        localDrawable.mutate().setAlpha(255);
      }
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    if (b())
    {
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(0);
    }
  }
  
  public void H() {}
  
  public int a()
  {
    return this.jdField_a_of_type_Bass.a();
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
    return ajjy.a(2131642354) + this.jdField_c_of_type_Int + "张图片\\视频";
  }
  
  public String a(int paramInt)
  {
    return basw.a(paramInt);
  }
  
  ArrayList<String> a()
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.T) || (this.jdField_b_of_type_JavaUtilArrayList.isEmpty()))
    {
      int i1 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery.getFirstVisiblePosition();
      if (i1 < this.jdField_a_of_type_JavaUtilArrayList.size()) {
        localArrayList.add(this.jdField_a_of_type_JavaUtilArrayList.get(i1));
      }
      return localArrayList;
    }
    localArrayList.addAll(this.jdField_b_of_type_JavaUtilArrayList);
    return localArrayList;
  }
  
  public void a()
  {
    if ((this.jdField_t_of_type_Int < this.jdField_a_of_type_JavaUtilArrayList.size()) && (this.jdField_t_of_type_Int >= 0))
    {
      String str = (String)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_t_of_type_Int);
      this.jdField_b_of_type_JavaUtilArrayList.add(str);
      this.jdField_c_of_type_JavaUtilArrayList.add(Integer.valueOf(this.jdField_t_of_type_Int));
      if ((this.z) || (d()))
      {
        if (this.jdField_g_of_type_JavaUtilHashMap == null) {
          this.jdField_g_of_type_JavaUtilHashMap = new HashMap();
        }
        LocalMediaInfo localLocalMediaInfo = b(str);
        this.jdField_g_of_type_JavaUtilHashMap.put(str, localLocalMediaInfo);
        if (this.jdField_h_of_type_JavaUtilHashMap == null) {
          this.jdField_h_of_type_JavaUtilHashMap = new HashMap();
        }
        if (localLocalMediaInfo != null) {
          this.jdField_h_of_type_JavaUtilHashMap.put(str, Integer.valueOf(localLocalMediaInfo.panoramaPhotoType));
        }
      }
    }
    b(this.jdField_c_of_type_JavaUtilArrayList.indexOf(Integer.valueOf(this.jdField_t_of_type_Int)) + 1);
    g();
    b((String)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_t_of_type_Int));
  }
  
  public void a(float paramFloat)
  {
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null)
    {
      Drawable localDrawable = this.jdField_b_of_type_AndroidWidgetRelativeLayout.getBackground();
      if (localDrawable != null) {
        localDrawable.mutate().setAlpha((int)(255.0F * paramFloat));
      }
    }
    if (paramFloat < 0.8F)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
      this.jdField_c_of_type_AndroidViewView.setVisibility(4);
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(4);
    }
  }
  
  public void a(int paramInt)
  {
    if (this.E) {
      return;
    }
    if (!bace.b(this.jdField_p_of_type_JavaLangString))
    {
      bbmy.a(this, 2131653686, 0).a();
      return;
    }
    this.jdField_a_of_type_Bass.a(this.jdField_a_of_type_Basv);
    this.jdField_a_of_type_Bass.a(this.jdField_a_of_type_Basu);
    if (this.jdField_a_of_type_Bass.a(this.jdField_p_of_type_JavaLangString, paramInt)) {
      try
      {
        this.jdField_a_of_type_AndroidViewSurfaceView.setVisibility(0);
        this.jdField_a_of_type_Bass.a(this.jdField_a_of_type_AndroidViewSurfaceView.getHolder());
        return;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("PhotoPreviewActivity", 2, "mMediaPlayer.setDisplay exception : ", localThrowable);
        return;
      }
    }
    babr.a(this, 232, null, getString(2131653713), new agcm(this), null).show();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= 0) && (paramInt1 < this.jdField_b_of_type_JavaUtilArrayList.size()) && (paramInt2 >= 0) && (paramInt2 < this.jdField_b_of_type_JavaUtilArrayList.size()))
    {
      Collections.swap(this.jdField_b_of_type_JavaUtilArrayList, paramInt1, paramInt2);
      if (this.jdField_a_of_type_Vhk != null)
      {
        String str = this.jdField_a_of_type_Vhk.a();
        if (!TextUtils.isEmpty(str))
        {
          this.jdField_t_of_type_Int = this.jdField_a_of_type_JavaUtilArrayList.indexOf(str);
          b(this.jdField_t_of_type_Int);
        }
      }
      vhg.a().b(this.jdField_b_of_type_JavaUtilArrayList, PhotoListActivity.jdField_a_of_type_JavaUtilHashMap);
    }
  }
  
  public void a(SlideItemInfo paramSlideItemInfo)
  {
    if (paramSlideItemInfo == null) {
      return;
    }
    int i1 = 0;
    label7:
    if (i1 < this.jdField_a_of_type_JavaUtilArrayList.size()) {
      if (!((String)this.jdField_a_of_type_JavaUtilArrayList.get(i1)).equals(paramSlideItemInfo.jdField_b_of_type_JavaLangString)) {}
    }
    for (;;)
    {
      if ((i1 >= 0) && (i1 < this.jdField_a_of_type_JavaUtilArrayList.size()))
      {
        if (!this.jdField_c_of_type_JavaUtilArrayList.contains(Integer.valueOf(i1))) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
        int i2 = this.jdField_c_of_type_JavaUtilArrayList.indexOf(Integer.valueOf(i1));
        if (i2 >= 0)
        {
          this.jdField_b_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_JavaUtilArrayList.get(i1));
          this.jdField_c_of_type_JavaUtilArrayList.remove(i2);
          if (this.jdField_e_of_type_JavaUtilHashMap != null) {
            this.jdField_e_of_type_JavaUtilHashMap.remove(this.jdField_a_of_type_JavaUtilArrayList.get(i1));
          }
          if (this.jdField_c_of_type_JavaUtilHashMap != null) {
            this.jdField_c_of_type_JavaUtilHashMap.remove(this.jdField_a_of_type_JavaUtilArrayList.get(i1));
          }
          if (this.jdField_h_of_type_JavaUtilHashMap != null) {
            this.jdField_h_of_type_JavaUtilHashMap.remove(this.jdField_a_of_type_JavaUtilArrayList.get(i1));
          }
        }
        g();
        b((String)this.jdField_a_of_type_JavaUtilArrayList.get(i1));
        return;
        i1 += 1;
        break label7;
      }
      if ((i1 != -1) || (paramSlideItemInfo == null)) {
        break;
      }
      this.jdField_b_of_type_JavaUtilArrayList.remove(paramSlideItemInfo.jdField_b_of_type_JavaLangString);
      g();
      b(this.jdField_c_of_type_JavaUtilArrayList.indexOf(Integer.valueOf(this.jdField_t_of_type_Int)) - 1);
      b(paramSlideItemInfo.jdField_b_of_type_JavaLangString);
      return;
      i1 = -1;
    }
  }
  
  public void a(String paramString)
  {
    if ((d()) && (this.jdField_l_of_type_Boolean) && (!this.jdField_t_of_type_Boolean))
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_b_of_type_JavaUtilArrayList);
      this.jdField_c_of_type_JavaUtilArrayList.clear();
      int i1 = 0;
      while (i1 < this.jdField_b_of_type_JavaUtilArrayList.size())
      {
        this.jdField_c_of_type_JavaUtilArrayList.add(Integer.valueOf(i1));
        i1 += 1;
      }
      this.jdField_a_of_type_Agdb.notifyDataSetChanged();
      this.jdField_t_of_type_Boolean = true;
    }
    this.jdField_t_of_type_Int = this.jdField_a_of_type_JavaUtilArrayList.indexOf(paramString);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery.setSelection(this.jdField_t_of_type_Int);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_q_of_type_Boolean) {
      vhg.a().a(vhg.a().c());
    }
    getIntent().putExtra("PhotoConst.SEND_BUSINESS_TYPE", this.jdField_u_of_type_Int);
    Object localObject;
    if ("FROM_PHOTO_LIST".equals(this.jdField_e_of_type_JavaLangString))
    {
      localObject = getIntent();
      ((Intent)localObject).setClass(this, PhotoListActivity.class);
      ((Intent)localObject).putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.jdField_e_of_type_Int);
      if (this.J) {
        ((Intent)localObject).removeExtra("PhotoConst.PHOTO_PATHS");
      }
    }
    for (;;)
    {
      ((Intent)localObject).putExtra("PhotoConst.PHOTO_PATHS_FROM_QZONEALBUM", this.jdField_c_of_type_JavaUtilHashMap);
      ((Intent)localObject).putExtra("PhotoConst.PHOTO_INFOS", this.jdField_e_of_type_JavaUtilHashMap);
      if (this.I)
      {
        ((Intent)localObject).putExtra("PhotoConst.ALWAYS_SHOW_NUMBER_WHEN_ONLY_ONE_IMAGE", true);
        ((Intent)localObject).putExtra("FROM_ARK_CHOOSE_IMAGE", true);
        ((Intent)localObject).putExtra("key_ark_app_res_path", this.jdField_r_of_type_JavaLangString);
        ((Intent)localObject).putExtra("key_should_compress", this.U);
        ((Intent)localObject).putExtra("key_ark_app_engine_res_dir", this.jdField_s_of_type_JavaLangString);
        ((Intent)localObject).putExtra("FROM_ARK_CHOOSE_IMAGE", true);
      }
      startActivity((Intent)localObject);
      label186:
      if (getIntent().getBooleanExtra("keep_selected_status_after_finish", false))
      {
        localObject = new Intent();
        ((Intent)localObject).putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.jdField_b_of_type_JavaUtilArrayList);
        ((Intent)localObject).putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", this.jdField_c_of_type_JavaUtilArrayList);
        ((Intent)localObject).putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.jdField_e_of_type_Int);
        ((Intent)localObject).putExtra("PhotoConst.editPathMap", this.jdField_a_of_type_JavaUtilHashMap);
        setResult(-1, (Intent)localObject);
      }
      super.finish();
      if (paramBoolean) {
        try
        {
          overridePendingTransition(2130772036, 2130772038);
          return;
          ((Intent)localObject).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.jdField_b_of_type_JavaUtilArrayList);
          ((Intent)localObject).putExtra("PhotoConst.editPathMap", this.jdField_a_of_type_JavaUtilHashMap);
          continue;
          if (("FROM_PHOTO_LIST_FLOW".equals(this.jdField_e_of_type_JavaLangString)) && (!this.J))
          {
            localObject = new Intent();
            ((Intent)localObject).putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.jdField_b_of_type_JavaUtilArrayList);
            ((Intent)localObject).putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", this.jdField_c_of_type_JavaUtilArrayList);
            ((Intent)localObject).putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.jdField_e_of_type_Int);
            setResult(-1, (Intent)localObject);
            break label186;
          }
          if (("FromCamera".equals(this.jdField_e_of_type_JavaLangString)) || ("FromFastImage".equals(this.jdField_e_of_type_JavaLangString)))
          {
            localObject = PresendPicMgr.a(null);
            if (localObject == null) {
              break label186;
            }
            if ("FromCamera".equals(this.jdField_e_of_type_JavaLangString)) {}
            for (int i1 = 1016;; i1 = 1017)
            {
              ((PresendPicMgr)localObject).a(i1);
              break;
            }
          }
          if (!"FROM_QZONE_PHOTO_LIST".equals(this.jdField_e_of_type_JavaLangString)) {
            break label186;
          }
          localObject = new Intent();
          ((Intent)localObject).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.jdField_b_of_type_JavaUtilArrayList);
          ((Intent)localObject).putExtra("PhotoConst.PHOTO_PATHS_FROM_QZONEALBUM", this.jdField_c_of_type_JavaUtilHashMap);
          ((Intent)localObject).putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.jdField_e_of_type_Int);
          ((Intent)localObject).putExtra("PeakConstants.selectedMediaInfoHashMap", this.jdField_g_of_type_JavaUtilHashMap);
          setResult(-1, (Intent)localObject);
        }
        catch (Exception localException)
        {
          while (!QLog.isColorLevel()) {}
          QLog.d("PhotoPreviewActivity", 2, "[PhotoPreviewActivity] overridePendingTransition=" + localException);
          return;
        }
      }
    }
    if (this.jdField_b_of_type_Boolean)
    {
      overridePendingTransition(2130772272, 2130772271);
      return;
    }
    baaf.a(this, true, false);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public LocalMediaInfo b(String paramString)
  {
    if (this.jdField_g_of_type_JavaUtilHashMap != null) {}
    for (LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)this.jdField_g_of_type_JavaUtilHashMap.get(paramString);; localLocalMediaInfo = null)
    {
      if ((localLocalMediaInfo == null) && (PhotoListActivity.jdField_a_of_type_JavaUtilHashMap != null) && ((this.E) || (this.z) || (this.F) || (this.B) || (d()) || ("FROM_QZONE_PHOTO_LIST".equals(this.jdField_e_of_type_JavaLangString)))) {
        localLocalMediaInfo = (LocalMediaInfo)PhotoListActivity.jdField_a_of_type_JavaUtilHashMap.get(paramString);
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
          localObject = PhotoListActivity.jdField_a_of_type_JavaUtilHashMap;
          if (localObject == null) {
            break label211;
          }
        }
        label211:
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
  
  void b()
  {
    this.Q = BaseApplicationImpl.getApplication().getSharedPreferences(BaseApplicationImpl.getApplication().getRuntime().getAccount(), 4).getBoolean("showFlashPic", true);
    Intent localIntent = getIntent();
    this.jdField_e_of_type_JavaLangString = localIntent.getStringExtra("FROM_WHERE");
    this.J = localIntent.getBooleanExtra("PhotoConst.IS_SINGLE_MODE", false);
    this.jdField_o_of_type_JavaLangString = localIntent.getStringExtra("readSource");
    this.O = localIntent.getBooleanExtra("showFlashPic", false);
    this.jdField_u_of_type_Int = localIntent.getIntExtra("PhotoConst.SEND_BUSINESS_TYPE", -1);
    this.jdField_i_of_type_Int = localIntent.getIntExtra("camera_type", 1);
    this.jdField_j_of_type_Int = localIntent.getIntExtra("camera_front_back", 0);
    this.jdField_k_of_type_Int = localIntent.getIntExtra("camera_filter_id", -1);
    this.jdField_l_of_type_Int = localIntent.getIntExtra("camera_capture_method", -1);
    this.z = localIntent.getBooleanExtra("from_qzone", false);
    this.C = localIntent.getBooleanExtra("PhotoConst.QZONE_ALBUM_FROM_AIO", false);
    this.D = localIntent.getBooleanExtra("PhotoConst.IS_FROM_MINI_APP", false);
    this.A = localIntent.getBooleanExtra("fromQzonePhotoGroup", false);
    this.jdField_k_of_type_Boolean = localIntent.getBooleanExtra("PhotoConst.IS_FROM_SHUOSHUO", false);
    this.B = localIntent.getBooleanExtra("PhotoConst.PHOTOLIST_IS_FROM_HWUPLOAD", false);
    this.jdField_l_of_type_Boolean = localIntent.getBooleanExtra("PhotoConst.IS_FROM_QQSTORY_SLIDESHOW", false);
    this.jdField_m_of_type_Boolean = localIntent.getBooleanExtra("PhotoConst.IS_FROM_QQSTORY_SLIDESHOW_PREVIEW", false);
    this.jdField_p_of_type_Boolean = localIntent.getBooleanExtra("from_qqstory_custom_data", false);
    this.jdField_o_of_type_Boolean = localIntent.getBooleanExtra("from_qqstory_entrance", false);
    this.jdField_n_of_type_Boolean = localIntent.getBooleanExtra("from_tribe_slideshow", false);
    this.jdField_r_of_type_Boolean = localIntent.getBooleanExtra("from_readinjoy_slideshow", false);
    this.jdField_s_of_type_Boolean = localIntent.getBooleanExtra("from_qzone_slideshow", false);
    this.jdField_q_of_type_Boolean = localIntent.getBooleanExtra("PhotoConst.IS_FROM_EDIT", false);
    this.G = localIntent.getBooleanExtra("PhotoConst.IS_FROM_FROM_AIO_LONGSHOT", false);
    this.jdField_g_of_type_JavaUtilHashMap = ((HashMap)localIntent.getSerializableExtra("PeakConstants.selectedMediaInfoHashMap"));
    this.jdField_h_of_type_JavaUtilHashMap = ((HashMap)localIntent.getSerializableExtra("PhotoConst.PANORAMA_IMAGES"));
    this.S = localIntent.getBooleanExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", false);
    this.T = getIntent().getBooleanExtra("PhotoConst.MULTI_PREVIEW_IN_SINGLE_MODE", false);
    this.M = getIntent().getBooleanExtra("PhotoConst.USE_URL_PATH", false);
    this.jdField_b_of_type_JavaUtilHashMap = ((HashMap)getIntent().getSerializableExtra("PhotoConst.PHOTO_PATHS_FROM_QZONEALBUM"));
    this.jdField_d_of_type_JavaUtilHashMap = ((HashMap)localIntent.getSerializableExtra("PhotoConst.PHOTO_INFOS"));
    this.E = localIntent.getBooleanExtra("fromPhotoListPanel", false);
    this.F = localIntent.getBooleanExtra("PhotoConst.IS_FROM_TROOP_FILE_LIST", false);
    this.N = localIntent.getBooleanExtra("PhotoConst.IS_FROM_EMOTION_FAVORITE", false);
    Object localObject1 = (HashMap)localIntent.getSerializableExtra("PhotoConst.ALL_MEDIA_PATHS");
    this.jdField_m_of_type_Int = localIntent.getIntExtra("PhotoConst.KEY_SHOW_TYPE", 0);
    this.H = localIntent.getBooleanExtra("QZONE_PEAK_SUPPORT_VIDEO_EDIT_WHEN_PREVIEW", false);
    if (localObject1 != null)
    {
      PhotoListActivity.jdField_a_of_type_JavaUtilHashMap = (HashMap)localObject1;
      this.E = true;
    }
    this.jdField_a_of_type_JavaUtilHashMap = ((HashMap)localIntent.getSerializableExtra("PhotoConst.editPathMap"));
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = ((SessionInfo)getIntent().getParcelableExtra("session_info"));
      this.jdField_e_of_type_JavaUtilHashMap = new HashMap(1);
      if (this.jdField_d_of_type_JavaUtilHashMap != null) {
        this.jdField_e_of_type_JavaUtilHashMap.putAll(this.jdField_d_of_type_JavaUtilHashMap);
      }
      this.jdField_c_of_type_JavaUtilHashMap = new HashMap(1);
      if (this.jdField_b_of_type_JavaUtilHashMap != null) {
        this.jdField_c_of_type_JavaUtilHashMap.putAll(this.jdField_b_of_type_JavaUtilHashMap);
      }
      if (QLog.isColorLevel()) {
        QLog.d("aioSendPhotos", 2, "mCanUseURL:" + this.M + " mSelectedSendParams size:" + this.jdField_c_of_type_JavaUtilHashMap.size());
      }
      if ((!this.J) && (("FromCamera".equals(this.jdField_e_of_type_JavaLangString)) || ("FromFastImage".equals(this.jdField_e_of_type_JavaLangString))))
      {
        localObject1 = (BinderWarpper)localIntent.getParcelableExtra("binder_presendService");
        if (localObject1 != null)
        {
          if (PresendPicMgr.a(null) != null) {
            PresendPicMgr.a(null).b();
          }
          localObject1 = PresendPicMgr.b(atpd.a(((BinderWarpper)localObject1).a));
          if (!"FromFastImage".equals(this.jdField_e_of_type_JavaLangString)) {
            break label1699;
          }
          this.jdField_o_of_type_Int = 1037;
          str = (String)localIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS").get(0);
          if (a(str) != 1)
          {
            ((PresendPicMgr)localObject1).a(str, this.jdField_o_of_type_Int);
            if (QLog.isColorLevel()) {
              QLog.d("PhotoPreviewActivity", 2, "  initData , presendMgr = " + localObject1 + ",picpath = " + str + ",from = " + this.jdField_e_of_type_JavaLangString + ",mBusiType = " + this.jdField_o_of_type_Int);
            }
          }
        }
      }
      this.L = localIntent.getBooleanExtra("callFromFastImage", false);
      if ("FromFastImage".equals(this.jdField_e_of_type_JavaLangString)) {
        ageh.c();
      }
      if ("FromCamera".equals(this.jdField_e_of_type_JavaLangString)) {
        ageh.a();
      }
      localIntent.removeExtra("FROM_WHERE");
      this.jdField_c_of_type_Int = localIntent.getIntExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
      this.w = localIntent.getBooleanExtra("PhotoConst.SHOW_ALBUM", false);
      this.x = localIntent.getBooleanExtra("PhotoConst.IS_OVERLOAD", false);
      this.jdField_l_of_type_JavaLangString = localIntent.getStringExtra("back_btn_text");
      localIntent.removeExtra("PhotoConst.IS_OVERLOAD");
      if (this.w) {
        if (this.x)
        {
          this.jdField_a_of_type_JavaUtilArrayList = PhotoListActivity.jdField_a_of_type_JavaUtilArrayList;
          this.jdField_b_of_type_JavaUtilArrayList = localIntent.getStringArrayListExtra("PhotoConst.SELECTED_PATHS");
          if (this.jdField_b_of_type_JavaUtilArrayList == null) {
            this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
          }
          this.jdField_c_of_type_JavaUtilArrayList = localIntent.getIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS");
          if ((this.jdField_c_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList != null)) {
            break label1977;
          }
          if (QLog.isColorLevel()) {
            QLog.d("PhotoPreviewActivity", 2, "initData(): Error! selectedItem or sSelectedIndex is null");
          }
          finish();
          i1 = 0;
          if (i1 != 0)
          {
            this.jdField_f_of_type_Int = this.jdField_a_of_type_JavaUtilArrayList.size();
            this.jdField_t_of_type_Int = localIntent.getIntExtra("PhotoConst.CURRENT_SELECTED_INDEX", this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
            localIntent.removeExtra("PhotoConst.CURRENT_SELECTED_INDEX");
            this.jdField_h_of_type_Boolean = localIntent.getBooleanExtra("PhotoConst.HANDLE_DEST_RESULT", false);
            this.jdField_i_of_type_Boolean = localIntent.getBooleanExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", false);
            if (this.jdField_i_of_type_Boolean)
            {
              this.jdField_b_of_type_JavaLangString = localIntent.getStringExtra("PhotoConst.MY_UIN");
              this.jdField_c_of_type_JavaLangString = localIntent.getStringExtra("PhotoConst.MY_NICK");
              this.jdField_d_of_type_JavaLangString = localIntent.getStringExtra("PhotoConst.MY_HEAD_DIR");
            }
            this.jdField_j_of_type_Boolean = localIntent.getBooleanExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", false);
            if (this.jdField_j_of_type_Boolean)
            {
              this.jdField_f_of_type_JavaUtilHashMap = ((HashMap)localIntent.getSerializableExtra("PasterConstants.pasters_data"));
              this.jdField_m_of_type_JavaLangString = localIntent.getStringExtra("PasterConstants.paster_id");
              this.jdField_n_of_type_JavaLangString = localIntent.getStringExtra("PasterConstants.paster_cate_id");
            }
            if (this.jdField_b_of_type_JavaLangString != null) {
              break label1946;
            }
            localObject1 = this.jdField_q_of_type_JavaLangString;
            this.jdField_b_of_type_JavaLangString = ((String)localObject1);
            this.jdField_b_of_type_Int = localIntent.getIntExtra("uintype", -1);
            this.jdField_u_of_type_Boolean = localIntent.getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false);
            this.v = localIntent.getBooleanExtra("PhotoConst.IS_SINGLE_DERECTBACK_MODE", false);
            this.jdField_e_of_type_Int = localIntent.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
            this.K = localIntent.getBooleanExtra("PhotoConst.SEND_FLAG", false);
            if (this.K)
            {
              localIntent.removeExtra("PhotoConst.SEND_FLAG");
              localObject1 = PresendPicMgr.a(null);
              if (localObject1 != null)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("PhotoPreviewActivity", 2, "Photo+ send pic,cancel presend!");
                }
                ((PresendPicMgr)localObject1).a(1003);
              }
              PhotoUtils.a(this, getIntent(), this.jdField_b_of_type_JavaUtilArrayList, this.jdField_e_of_type_Int, true);
            }
            this.jdField_g_of_type_JavaLangString = localIntent.getStringExtra("PhotoConst.CUSTOM_SENDBTN_TEXT");
            this.y = localIntent.getBooleanExtra("PhotoConst.IS_JUMPTO_TROOP_ALBUM", false);
            if (this.y)
            {
              this.jdField_i_of_type_JavaLangString = localIntent.getStringExtra("uinname");
              this.jdField_h_of_type_JavaLangString = localIntent.getStringExtra("uin");
            }
            if (((this.jdField_b_of_type_Int == 1) || (c())) && (this.jdField_b_of_type_JavaLangString != null))
            {
              localObject1 = bfpr.a(this.jdField_b_of_type_JavaLangString, this.jdField_h_of_type_JavaLangString);
              if ((localObject1 == null) || (((BaseBusinessAlbumInfo)localObject1).a() == null) || (((BaseBusinessAlbumInfo)localObject1).a().equals(""))) {
                break label1954;
              }
              this.jdField_j_of_type_JavaLangString = ((BaseBusinessAlbumInfo)localObject1).a();
              this.jdField_k_of_type_JavaLangString = ((BaseBusinessAlbumInfo)localObject1).b();
              localIntent.putExtra("UploadPhoto.key_album_id", this.jdField_j_of_type_JavaLangString);
              localIntent.putExtra("UploadPhoto.key_album_name", this.jdField_k_of_type_JavaLangString);
            }
          }
          label1517:
          this.jdField_a_of_type_Boolean = localIntent.getBooleanExtra("from_health", false);
          this.jdField_b_of_type_Boolean = localIntent.getBooleanExtra("from_readinjoy_ugc_preview", false);
          this.jdField_c_of_type_Boolean = localIntent.getBooleanExtra("from_readinjoy_ugc_deliver", false);
          this.jdField_d_of_type_Boolean = localIntent.getBooleanExtra("from_readinjoy_ugc_deliver_preview", false);
          this.jdField_f_of_type_Boolean = localIntent.getBooleanExtra("from_readinjoy_ugc", false);
          this.jdField_a_of_type_JavaLangString = localIntent.getStringExtra("from_tribe_class_name");
          this.I = localIntent.getBooleanExtra("FROM_ARK_CHOOSE_IMAGE", false);
          if (this.I)
          {
            this.jdField_r_of_type_JavaLangString = getIntent().getStringExtra("key_ark_app_res_path");
            this.U = getIntent().getBooleanExtra("key_should_compress", false);
            this.jdField_s_of_type_JavaLangString = getIntent().getStringExtra("key_ark_app_engine_res_dir");
          }
          this.jdField_n_of_type_Int = localIntent.getIntExtra("key_pic_to_edit_from", 0);
          if (this.jdField_s_of_type_Boolean) {
            vhg.a().b(19);
          }
          return;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str;
        int i1;
        if (QLog.isColorLevel())
        {
          QLog.e("PhotoPreviewActivity", 2, "submit", localException);
          continue;
          label1699:
          this.jdField_o_of_type_Int = 1008;
          continue;
          this.jdField_a_of_type_JavaUtilArrayList = localIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
          continue;
          Object localObject2;
          if (this.x)
          {
            this.jdField_a_of_type_JavaUtilArrayList = PhotoListActivity.jdField_a_of_type_JavaUtilArrayList;
            if (this.jdField_a_of_type_JavaUtilArrayList == null) {
              this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
            }
            if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
            {
              localObject2 = localIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
              this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
            }
            localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          }
          for (;;)
          {
            if (!((Iterator)localObject2).hasNext()) {
              break label1877;
            }
            str = (String)((Iterator)localObject2).next();
            if ((!this.M) || (!a(str)))
            {
              if (str != null)
              {
                if (new File(str).exists()) {
                  continue;
                }
                ((Iterator)localObject2).remove();
                continue;
                this.jdField_a_of_type_JavaUtilArrayList = localIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
                break;
              }
              ((Iterator)localObject2).remove();
            }
          }
          label1877:
          this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
          this.jdField_b_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
          this.jdField_c_of_type_JavaUtilArrayList.clear();
          if (!this.J)
          {
            i1 = 0;
            for (;;)
            {
              if (i1 < this.jdField_a_of_type_JavaUtilArrayList.size())
              {
                this.jdField_c_of_type_JavaUtilArrayList.add(Integer.valueOf(i1));
                i1 += 1;
                continue;
                label1946:
                localObject2 = this.jdField_b_of_type_JavaLangString;
                break;
                label1954:
                localIntent.putExtra("UploadPhoto.key_album_id", "");
                localIntent.putExtra("UploadPhoto.key_album_name", "");
                break label1517;
              }
            }
          }
          label1977:
          i1 = 1;
        }
      }
    }
  }
  
  public boolean b()
  {
    return ((this.C) || (this.E) || (this.N)) && (this.jdField_b_of_type_JavaUtilArrayList != null) && (!this.jdField_b_of_type_JavaUtilArrayList.isEmpty());
  }
  
  void d()
  {
    int i3 = 1;
    this.ac = true;
    this.ad = false;
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131309737));
    this.jdField_a_of_type_ComTencentWidgetDragView = ((DragView)a(2131299824));
    this.jdField_a_of_type_ComTencentWidgetDragView.setGestureChangeListener(this);
    this.jdField_a_of_type_ComTencentWidgetDragView.setRatioModify(true);
    Object localObject = (Rect)getIntent().getParcelableExtra("KEY_THUMBNAL_BOUND");
    int i1;
    label188:
    label243:
    float f1;
    if (localObject != null) {
      if (this.V)
      {
        i1 = bjeh.jdField_a_of_type_Int;
        ((Rect)localObject).top -= i1;
        ((Rect)localObject).bottom -= i1;
        if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > this.jdField_t_of_type_Int) && (this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_t_of_type_Int) != null))
        {
          LocalMediaInfo localLocalMediaInfo = b((String)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_t_of_type_Int));
          if (localLocalMediaInfo != null) {
            localLocalMediaInfo.thumbRect = ((Rect)localObject);
          }
        }
        this.jdField_a_of_type_ComTencentWidgetDragView.setOriginRect((Rect)localObject);
        this.jdField_a_of_type_AndroidViewView = findViewById(2131311739);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131297793));
        if (this.jdField_g_of_type_Boolean)
        {
          this.jdField_a_of_type_AndroidViewView.setVisibility(0);
          if (!d()) {
            break label1580;
          }
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
        }
        this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131304039));
        this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131300753));
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131300754));
        this.jdField_b_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131307749));
        this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131307755));
        if ((this.O) && (this.jdField_e_of_type_JavaUtilHashMap.size() == 0))
        {
          this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
          this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new agcl(this));
          this.jdField_a_of_type_AndroidWidgetCheckBox.setContentDescription(ajjy.a(2131642351));
          this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(ajjy.a(2131642342));
        }
        this.jdField_b_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
        this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new agcq(this));
        if (!this.jdField_i_of_type_Boolean) {
          break label1631;
        }
        if (this.jdField_b_of_type_Int != 9501) {
          break label1591;
        }
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        label444:
        this.jdField_b_of_type_AndroidWidgetCheckBox.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        label460:
        this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131305859));
        this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131310076));
        this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox = ((NumberCheckBox)findViewById(2131310053));
        this.jdField_b_of_type_AndroidViewView = findViewById(2131310035);
        this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131311534));
        if (!this.jdField_b_of_type_Boolean) {
          break label1712;
        }
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
        label561:
        if (this.G) {
          this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        if (this.w) {
          this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        if (this.jdField_c_of_type_Boolean)
        {
          findViewById(2131299435).setVisibility(0);
          findViewById(2131299435).setOnClickListener(new agcr(this));
        }
        this.jdField_b_of_type_AndroidViewView.setOnClickListener(new agcu(this));
        this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297456));
        this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(new agcv(this));
        this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new agcw(this));
        this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(new agcx(this));
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery = ((DragGallery)findViewById(2131301286));
        if ((this.E) || (this.z) || (this.F) || (d()) || ("FROM_QZONE_PHOTO_LIST".equals(this.jdField_e_of_type_JavaLangString))) {
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery.setSupportMatchParent(true);
        }
        this.jdField_a_of_type_Agdb = new agdb(this);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery.setAdapter(this.jdField_a_of_type_Agdb);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery.setOnNoBlankListener(this.jdField_a_of_type_Agdb);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery.setOnScollListener(new agda(this));
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery.setOnItemSelectedListener(new agcc(this));
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery.setSpacing(getResources().getDimensionPixelSize(2131165934));
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery.setSelection(this.jdField_t_of_type_Int);
        g();
        if ((this.v) || (this.J))
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setVisibility(8);
          this.jdField_b_of_type_AndroidViewView.setVisibility(8);
          if (!this.jdField_c_of_type_Boolean) {
            this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          }
          this.jdField_b_of_type_AndroidWidgetCheckBox.setVisibility(8);
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        if (!this.jdField_d_of_type_Boolean) {
          break label1770;
        }
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        if ((this.jdField_a_of_type_JavaUtilArrayList.size() > 1) && (this.jdField_b_of_type_JavaUtilArrayList.size() > 1)) {
          break label1759;
        }
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
        label973:
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery.setOnItemClickListener(new agcd(this));
        if (("FromCamera".equals(this.jdField_e_of_type_JavaLangString)) || ("FromFastImage".equals(this.jdField_e_of_type_JavaLangString)) || ("FROM_PHOTO_LIST_FLOW".equals(this.jdField_e_of_type_JavaLangString)))
        {
          this.jdField_c_of_type_AndroidWidgetTextView.setText(2131629440);
          this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(4);
          if (!"FROM_PHOTO_LIST_FLOW".equals(this.jdField_e_of_type_JavaLangString))
          {
            this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setVisibility(8);
            this.jdField_b_of_type_AndroidViewView.setVisibility(8);
          }
        }
        this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(new agce(this));
        if (this.J) {
          this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
        }
        if (this.G) {
          this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        if (!d()) {
          break label1806;
        }
        this.jdField_c_of_type_AndroidWidgetTextView.setText("");
        label1138:
        if (this.jdField_b_of_type_Int == 1001)
        {
          this.jdField_b_of_type_AndroidWidgetCheckBox.setVisibility(8);
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        this.jdField_a_of_type_AndroidViewSurfaceView = ((SurfaceView)findViewById(2131301293));
        this.jdField_a_of_type_AndroidViewSurfaceView.setZOrderOnTop(true);
        this.jdField_a_of_type_AndroidViewSurfaceView.getHolder().setFormat(-3);
        this.jdField_a_of_type_AndroidViewSurfaceView.getHolder().setType(3);
        this.jdField_a_of_type_AndroidViewSurfaceView.getHolder().addCallback(this.jdField_a_of_type_AndroidViewSurfaceHolder$Callback);
        this.jdField_a_of_type_AndroidViewSurfaceView.getViewTreeObserver().addOnGlobalLayoutListener(new agcf(this));
        this.jdField_a_of_type_AndroidViewSurfaceView.setOnClickListener(new agcg(this));
        if (this.T)
        {
          this.jdField_e_of_type_AndroidWidgetTextView.setText(2131629407);
          this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(getResources().getColorStateList(2131101287));
          this.jdField_b_of_type_AndroidWidgetButton.setVisibility(4);
        }
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)findViewById(2131300881));
        this.jdField_c_of_type_AndroidViewView = findViewById(2131300879);
        this.jdField_a_of_type_Agdc = new agdc(this);
        this.jdField_a_of_type_Agdc.a(this.jdField_b_of_type_JavaUtilArrayList);
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_Agdc);
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemClickListener(this.jdField_a_of_type_Agdc);
        if (b())
        {
          this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(0);
          this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        }
        f1 = 16.0F / ajia.a();
        if ((f1 >= 1.0F) && (this.jdField_g_of_type_Int >= 720)) {
          break label1866;
        }
        if (this.jdField_g_of_type_Int >= 270) {
          break label1830;
        }
        f1 *= 0.7F;
        label1439:
        if (QLog.isColorLevel()) {
          QLog.d("PhotoPreviewActivity", 2, "need scale,reqWidth:" + this.jdField_g_of_type_Int + " scale:" + f1);
        }
        i1 = 0;
        label1487:
        if (i1 >= this.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildCount()) {
          break label1866;
        }
        localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(i1);
        ((View)localObject).setScaleX(f1);
        ((View)localObject).setScaleY(f1);
        if (i1 != this.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildCount() - 1) {
          break label1839;
        }
        localObject = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).rightMargin = ((int)(((RelativeLayout.LayoutParams)localObject).rightMargin * f1));
      }
    }
    for (;;)
    {
      i1 += 1;
      break label1487;
      i1 = 0;
      break;
      this.jdField_a_of_type_ComTencentWidgetDragView.setEnableDrag(false);
      break label188;
      label1580:
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      break label243;
      label1591:
      if ((this.C) && (this.jdField_c_of_type_JavaUtilHashMap.size() != 0))
      {
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        break label444;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      break label444;
      label1631:
      if (this.jdField_j_of_type_Boolean) {
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      }
      for (;;)
      {
        if ((!this.C) && (!this.D)) {
          break label1691;
        }
        this.jdField_b_of_type_AndroidWidgetCheckBox.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        break;
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      }
      label1691:
      this.jdField_b_of_type_AndroidWidgetCheckBox.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      break label460;
      label1712:
      if (d())
      {
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        break label561;
      }
      if (!this.jdField_c_of_type_Boolean) {
        break label561;
      }
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
      break label561;
      label1759:
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      break label973;
      label1770:
      if (this.jdField_f_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        break label973;
      }
      if (!this.H) {
        break label973;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      break label973;
      label1806:
      if (TextUtils.isEmpty(this.jdField_l_of_type_JavaLangString)) {
        break label1138;
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_l_of_type_JavaLangString);
      break label1138;
      label1830:
      f1 *= 0.8F;
      break label1439;
      label1839:
      localObject = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).leftMargin = ((int)(((RelativeLayout.LayoutParams)localObject).leftMargin * f1));
    }
    label1866:
    int i2;
    if ((d()) && (this.jdField_t_of_type_Int != -1))
    {
      b((String)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_t_of_type_Int));
      int i4 = this.jdField_b_of_type_JavaUtilArrayList.indexOf(this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_t_of_type_Int));
      if ((this.jdField_l_of_type_Boolean) || (this.jdField_m_of_type_Boolean))
      {
        localObject = (String)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_t_of_type_Int);
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = (LocalMediaInfo)this.jdField_g_of_type_JavaUtilHashMap.get(localObject);
          if (localObject != null)
          {
            i2 = baaf.a((LocalMediaInfo)localObject);
            if (!this.jdField_o_of_type_Boolean) {
              break label2105;
            }
            i1 = 0;
            if (i2 != 0) {
              break label2110;
            }
            i2 = 0;
            label1997:
            localObject = new StringBuilder();
            if (i4 + 1 <= 0) {
              break label2115;
            }
          }
        }
      }
    }
    for (;;)
    {
      urp.a("pic_choose_slides", "exp_picViewer", i1, i2, new String[] { i3 + "" });
      f1 = getResources().getDisplayMetrics().density;
      aciy.a(this.jdField_a_of_type_AndroidWidgetButton, (int)(10.0F * f1 + 0.5F), (int)(10.0F * f1 + 0.5F), (int)(10.0F * f1 + 0.5F), (int)(f1 * 10.0F + 0.5F));
      return;
      label2105:
      i1 = 1;
      break;
      label2110:
      i2 = 1;
      break label1997;
      label2115:
      i3 = 0;
    }
  }
  
  public void e()
  {
    this.jdField_g_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
    if (d()) {
      if (this.jdField_a_of_type_Vhk != null) {
        this.jdField_a_of_type_Vhk.c();
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) {
        this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b();
      }
      return;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
      this.jdField_c_of_type_AndroidViewView.setVisibility(4);
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(4);
    }
  }
  
  public void f()
  {
    this.jdField_g_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    if (d()) {
      if (this.jdField_a_of_type_Vhk != null) {
        this.jdField_a_of_type_Vhk.d();
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    } while (!b());
    this.jdField_c_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(0);
  }
  
  public void g()
  {
    boolean bool2 = true;
    boolean bool3 = true;
    boolean bool1 = true;
    Object localObject;
    if ((this.jdField_i_of_type_Boolean) || (this.C)) {
      if (this.G)
      {
        localObject = getString(2131624396);
        if ((this.y) || (this.N)) {
          localObject = getString(2131629467);
        }
        if (this.jdField_m_of_type_Int == 1) {
          localObject = getString(2131629425);
        }
        if (this.jdField_g_of_type_JavaLangString == null) {
          break label832;
        }
        localObject = this.jdField_g_of_type_JavaLangString;
      }
    }
    label399:
    label810:
    label815:
    label832:
    for (;;)
    {
      if ((this.jdField_b_of_type_JavaUtilArrayList != null) && (this.jdField_b_of_type_JavaUtilArrayList.size() > 0))
      {
        if ((this.v) || (this.J))
        {
          if (this.G)
          {
            this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
            this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
          }
          this.jdField_b_of_type_AndroidWidgetButton.setEnabled(true);
          this.jdField_b_of_type_AndroidWidgetButton.setText((CharSequence)localObject);
          if (this.jdField_a_of_type_Agdc != null)
          {
            if (!b()) {
              break label815;
            }
            if (this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getVisibility() == 4)
            {
              this.jdField_c_of_type_AndroidViewView.setVisibility(0);
              this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(0);
            }
            this.jdField_a_of_type_Agdc.notifyDataSetChanged();
          }
          return;
          localObject = getString(2131629465);
          break;
          if (d())
          {
            localObject = getString(2131633751);
            break;
          }
          localObject = getString(2131629407);
          break;
        }
        Button localButton;
        if (this.jdField_m_of_type_Int == 1)
        {
          localButton = this.jdField_b_of_type_AndroidWidgetButton;
          if (this.jdField_b_of_type_JavaUtilArrayList.size() >= 3) {}
          for (bool1 = true;; bool1 = false)
          {
            localButton.setEnabled(bool1);
            this.jdField_b_of_type_AndroidWidgetButton.setText((String)localObject + "(" + this.jdField_b_of_type_JavaUtilArrayList.size() + ")");
            break;
          }
        }
        this.jdField_b_of_type_AndroidWidgetButton.setEnabled(true);
        if ((!this.y) && (this.jdField_c_of_type_JavaUtilArrayList.contains(Integer.valueOf(this.jdField_t_of_type_Int))) && (a((String)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_t_of_type_Int)) != 1))
        {
          this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
          if (this.jdField_c_of_type_Boolean) {
            this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
          }
          h();
          if (d())
          {
            localButton = this.jdField_b_of_type_AndroidWidgetButton;
            if (this.jdField_b_of_type_JavaUtilArrayList.size() < 2) {
              break label506;
            }
          }
        }
        for (;;)
        {
          localButton.setEnabled(bool1);
          this.jdField_b_of_type_AndroidWidgetButton.setText((String)localObject + "(" + this.jdField_b_of_type_JavaUtilArrayList.size() + ")");
          break;
          this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
          break label399;
          label506:
          bool1 = false;
        }
      }
      if (this.H)
      {
        this.jdField_b_of_type_AndroidWidgetButton.setText((CharSequence)localObject);
        if (d()) {
          this.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
        }
        if ((this.z) && (this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > this.jdField_t_of_type_Int)) {
          this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
        }
        this.jdField_b_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(null);
        localObject = this.jdField_b_of_type_AndroidWidgetCheckBox;
        if (this.jdField_e_of_type_Int == 2) {}
        for (bool1 = bool2;; bool1 = false)
        {
          ((CheckBox)localObject).setChecked(bool1);
          this.jdField_b_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
          if (this.jdField_e_of_type_Int == 2) {
            this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16734752);
          }
          h();
          break;
        }
      }
      this.jdField_b_of_type_AndroidWidgetButton.setText((CharSequence)localObject);
      if (d()) {
        this.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
      }
      if ((this.z) && (this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > this.jdField_t_of_type_Int) && (this.jdField_t_of_type_Int != -1))
      {
        if (a((String)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_t_of_type_Int)) == 1) {
          this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        }
      }
      else
      {
        label736:
        this.jdField_b_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(null);
        localObject = this.jdField_b_of_type_AndroidWidgetCheckBox;
        if (this.jdField_e_of_type_Int != 2) {
          break label810;
        }
      }
      for (bool1 = bool3;; bool1 = false)
      {
        ((CheckBox)localObject).setChecked(bool1);
        this.jdField_b_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
        if (this.jdField_e_of_type_Int == 2) {
          this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16734752);
        }
        h();
        break;
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
        break label736;
      }
      this.jdField_c_of_type_AndroidViewView.setVisibility(4);
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(4);
      return;
    }
  }
  
  void h()
  {
    switch (this.jdField_e_of_type_Int)
    {
    case 1: 
    default: 
      return;
    case 0: 
      this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131629435));
      this.jdField_b_of_type_AndroidWidgetCheckBox.setChecked(false);
      return;
    }
    i();
    this.jdField_b_of_type_AndroidWidgetCheckBox.setChecked(true);
  }
  
  void i()
  {
    Object localObject = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if ((!NetworkUtils.isNetworkUrl(str)) && (a(str) == 1))
      {
        str = getString(2131629435);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(str);
      }
    }
    int i1 = baaf.a(this.jdField_b_of_type_JavaUtilArrayList, PhotoListActivity.jdField_a_of_type_JavaUtilHashMap, this.E, this.jdField_c_of_type_JavaUtilHashMap, this.jdField_g_of_type_JavaUtilHashMap);
    if ((this.E) && (i1 == 0))
    {
      localObject = getString(2131629435);
      this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      return;
    }
    localObject = PhotoUtils.a(this, i1);
    if ((this.jdField_b_of_type_JavaUtilArrayList.size() == 0) || (((String)localObject).equals("0"))) {}
    for (localObject = getString(2131629435);; localObject = getString(2131629435) + "(" + ajjy.a(2131642347) + (String)localObject + ")")
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      return;
    }
  }
  
  public void j()
  {
    Object localObject1;
    int i1;
    if ((this.jdField_l_of_type_Boolean) || (this.jdField_m_of_type_Boolean))
    {
      vhj.a(this, this.jdField_b_of_type_JavaUtilArrayList);
      this.jdField_b_of_type_AndroidWidgetButton.setClickable(true);
      localObject1 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      i1 = 0;
      if (((Iterator)localObject1).hasNext())
      {
        if (a((String)((Iterator)localObject1).next()) != 1) {
          break label1771;
        }
        i1 += 1;
      }
    }
    label1121:
    label1771:
    for (;;)
    {
      break;
      this.jdField_b_of_type_JavaUtilArrayList.size();
      Object localObject2;
      Object localObject4;
      Object localObject3;
      do
      {
        return;
        if ((this.jdField_n_of_type_Boolean) || (this.jdField_r_of_type_Boolean))
        {
          vhj.a(this, this.jdField_b_of_type_JavaUtilArrayList);
          this.jdField_b_of_type_AndroidWidgetButton.setClickable(true);
          return;
        }
        if (this.jdField_a_of_type_Boolean)
        {
          localObject1 = new Intent();
          ((Intent)localObject1).putStringArrayListExtra("img_list", this.jdField_b_of_type_JavaUtilArrayList);
          super.setResult(-1, (Intent)localObject1);
          super.finish();
          return;
        }
        if (this.A)
        {
          localObject1 = new Intent();
          ((Intent)localObject1).putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", this.jdField_c_of_type_JavaUtilArrayList);
          super.setResult(-1, (Intent)localObject1);
          super.finish();
          return;
        }
        localObject1 = a();
        if ((this.C) && (localObject1 != null) && (((ArrayList)localObject1).size() == 1))
        {
          localObject1 = (String)((ArrayList)localObject1).get(0);
          if ((localObject1 != null) && (((String)localObject1).startsWith("http")))
          {
            localObject2 = (PhotoSendParams)this.jdField_b_of_type_JavaUtilHashMap.get(localObject1);
            if (localObject2 != null) {
              this.jdField_c_of_type_JavaUtilHashMap.put(localObject1, localObject2);
            }
          }
        }
        if ((!this.y) || (c())) {
          break;
        }
        localObject1 = PresendPicMgr.a(null);
        if (localObject1 != null) {
          ((PresendPicMgr)localObject1).a(1009);
        }
        localObject1 = a();
        if (localObject1 != null) {
          ageh.b(getIntent(), ((ArrayList)localObject1).size());
        }
        localObject2 = getIntent();
        ((Intent)localObject2).putExtra("open_chatfragment_fromphoto", true);
        adwz.a(this, (Intent)localObject2, this.jdField_b_of_type_JavaLangString, this.jdField_h_of_type_JavaLangString, this.jdField_i_of_type_JavaLangString, this.jdField_j_of_type_JavaLangString, this.jdField_k_of_type_JavaLangString, this.jdField_e_of_type_Int, (ArrayList)localObject1, 42);
        localObject4 = getIntent();
        if ((localObject4 != null) && (((Intent)localObject4).getBooleanExtra("custom_photopreview_sendbtn_report", false)))
        {
          localObject3 = ((Intent)localObject4).getStringExtra("custom_photopreview_sendbtn_reportActionName");
          localObject2 = ((Intent)localObject4).getStringExtra("custom_photopreview_sendbtn_album_reportReverse2");
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = ((Intent)localObject4).getStringExtra("custom_photopreview_sendbtn_camera_reportReverse2");
          }
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = ((Intent)localObject4).getStringExtra("custom_photopreview_sendbtn_reportReverse2");
          }
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          if ((localObject3 != null) && (localObject1 != null)) {
            awqx.b(null, "CliOper", "", "", (String)localObject3, (String)localObject3, 0, 0, (String)localObject1, "", "", "");
          }
        }
      } while ((!b()) || (this.jdField_n_of_type_Int <= 0));
      localObject1 = a().iterator();
      i1 = 0;
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label1687;
        }
        localObject2 = (String)((Iterator)localObject1).next();
        localObject3 = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
        for (;;)
        {
          if (((Iterator)localObject3).hasNext())
          {
            localObject4 = (String)((Iterator)localObject3).next();
            if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty((CharSequence)localObject4)) && (((String)localObject2).equals(localObject4)))
            {
              i1 += 1;
              continue;
              if ((this.jdField_j_of_type_Boolean) && ((!TextUtils.isEmpty(this.jdField_m_of_type_JavaLangString)) || (!TextUtils.isEmpty(this.jdField_n_of_type_JavaLangString))))
              {
                this.jdField_a_of_type_AndroidWidgetButton.performClick();
                break;
              }
              if ((this.C) && ((this.jdField_c_of_type_JavaUtilHashMap.size() != 0) || ("FROM_QZONE_PHOTO_LIST".equals(this.jdField_e_of_type_JavaLangString))))
              {
                if (getIntent().getParcelableExtra("PhotoConst.sendToAIOIntent") != null) {}
                for (localObject1 = (Intent)getIntent().getParcelableExtra("PhotoConst.sendToAIOIntent");; localObject1 = getIntent())
                {
                  a((Intent)localObject1, true);
                  break;
                }
              }
              if ("FromFastImage".equals(this.jdField_e_of_type_JavaLangString))
              {
                awqx.b(null, "CliOper", "", "", "0X8004D93", "0X8004D93", 0, 0, "", "", "", "");
                ageh.d();
              }
              if ("FromCamera".equals(this.jdField_e_of_type_JavaLangString)) {
                ageh.b();
              }
              localObject2 = a();
              if ((this.z) && (this.jdField_b_of_type_JavaUtilArrayList != null) && (this.jdField_b_of_type_JavaUtilArrayList.isEmpty()) && (((ArrayList)localObject2).size() == 1))
              {
                localObject1 = (String)((ArrayList)localObject2).get(0);
                localObject3 = b((String)localObject1);
                if (localObject3 != null)
                {
                  if (this.jdField_h_of_type_JavaUtilHashMap == null) {
                    this.jdField_h_of_type_JavaUtilHashMap = new HashMap();
                  }
                  this.jdField_h_of_type_JavaUtilHashMap.put(localObject1, Integer.valueOf(((LocalMediaInfo)localObject3).panoramaPhotoType));
                  if (this.jdField_g_of_type_JavaUtilHashMap != null)
                  {
                    this.jdField_g_of_type_JavaUtilHashMap.clear();
                    this.jdField_g_of_type_JavaUtilHashMap.put(localObject1, localObject3);
                  }
                }
                if ((a((String)localObject1) == 1) && (!baaf.a(this, b(), (LocalMediaInfo)localObject3, this.jdField_k_of_type_Boolean)))
                {
                  this.jdField_b_of_type_AndroidWidgetButton.setClickable(true);
                  return;
                }
              }
              if (localObject2 != null)
              {
                ageh.a(((ArrayList)localObject2).size(), this.jdField_f_of_type_Int);
                ageh.a(getIntent(), ((ArrayList)localObject2).size(), this.jdField_e_of_type_Int);
              }
              localObject3 = getIntent();
              localObject1 = PresendPicMgr.a(null);
              if (this.jdField_e_of_type_Int == 2)
              {
                if ((this.jdField_c_of_type_JavaUtilArrayList.size() == 0) && (((ArrayList)localObject2).size() == 1) && (bace.a((String)((ArrayList)localObject2).get(0)) > 16777216L))
                {
                  bbmy.a(this, getResources().getString(2131629431), 0).b(getResources().getDimensionPixelSize(2131167766));
                  this.jdField_b_of_type_AndroidWidgetButton.setClickable(true);
                  return;
                }
                if (localObject1 != null)
                {
                  ((PresendPicMgr)localObject1).a(1010);
                  ((PresendPicMgr)localObject1).a();
                }
                if (("FromCamera".equals(this.jdField_e_of_type_JavaLangString)) || ("FromFastImage".equals(this.jdField_e_of_type_JavaLangString)))
                {
                  awqx.b(null, "CliOper", "", "", "0X8005147", "0X8005147", 0, 0, "", "", "", "");
                  if (this.P)
                  {
                    ((Intent)localObject3).putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1040);
                    if (this.jdField_b_of_type_Int != 0) {
                      break label1533;
                    }
                    awqx.b(null, "dc00898", "", "", "0X80069A6", "0X80069A6", 0, 0, "", "", "", "");
                    awqx.b(null, "dc00898", "", "", "0X800699A", "0X800699A", 0, 0, "", "", "", "");
                  }
                  if (this.jdField_h_of_type_Boolean) {
                    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
                  }
                  if (localObject2 != null) {
                    ahji.a((List)localObject2);
                  }
                  if ((this.z) || (d()))
                  {
                    ((Intent)localObject3).putExtra("PeakConstants.selectedMediaInfoHashMap", this.jdField_g_of_type_JavaUtilHashMap);
                    ((Intent)localObject3).putExtra("PhotoConst.PANORAMA_IMAGES", this.jdField_h_of_type_JavaUtilHashMap);
                  }
                  if (this.S)
                  {
                    ((Intent)localObject3).putExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", true);
                    ((Intent)localObject3).putExtra("session_info", getIntent().getParcelableExtra("session_info"));
                  }
                  if ((this.y) && (c()))
                  {
                    ((Intent)localObject3).putExtra("key_is_sync_qzone", 1);
                    if (this.jdField_j_of_type_JavaLangString == null) {
                      break label1665;
                    }
                    localObject1 = this.jdField_j_of_type_JavaLangString;
                    ((Intent)localObject3).putExtra("key_qzone_album_id", (String)localObject1);
                    ((Intent)localObject3).putExtra("key_qzone_batch_id", PhotoUtils.a());
                    if (localObject2 != null) {
                      ((Intent)localObject3).putExtra("PhotoConst.PHOTO_COUNT", ((ArrayList)localObject2).size());
                    }
                    localObject1 = new LpReportInfo_pf00064(723, 3, 1);
                    LpReportManager.getInstance().reportToPF00064((LpReportInfo_pf00064)localObject1, false, false);
                    localObject1 = new Properties();
                    ((Properties)localObject1).put("operation_type", "preview_upload");
                    awqm.a(this).reportKVEvent("aio_sync_qzone", (Properties)localObject1);
                  }
                  if (1 != this.jdField_m_of_type_Int) {
                    break label1671;
                  }
                  ((Intent)localObject3).putExtra("PhotoConst.KEY_SHOW_TYPE", 1);
                }
              }
              for (;;)
              {
                a((Intent)localObject3, false);
                break;
                awqx.b(null, "CliOper", "", "", "0X800515C", "0X800515C", 0, 0, "", "", "", "");
                break label1121;
                if ((localObject1 == null) || (this.jdField_c_of_type_JavaUtilArrayList.size() <= 0) || (this.P) || (this.R) || (this.S)) {
                  break label1121;
                }
                ((PresendPicMgr)localObject1).a((Intent)localObject3);
                break label1121;
                label1533:
                if (this.jdField_b_of_type_Int == 3000)
                {
                  awqx.b(null, "dc00898", "", "", "0X80069A7", "0X80069A7", 0, 0, "", "", "", "");
                  awqx.b(null, "dc00898", "", "", "0X800699B", "0X800699B", 0, 0, "", "", "", "");
                  break label1201;
                }
                if (this.jdField_b_of_type_Int != 1) {
                  break label1201;
                }
                awqx.b(null, "dc00898", "", "", "0X80069A8", "0X80069A8", 0, 0, "", "", "", "");
                awqx.b(null, "dc00898", "", "", "0X800699C", "0X800699C", 0, 0, "", "", "", "");
                break label1201;
                localObject1 = "";
                break label1338;
                ((Intent)localObject3).putExtra("PhotoConst.KEY_SHOW_TYPE", 0);
              }
            }
          }
        }
      }
      localObject1 = new StringBuilder();
      if (this.jdField_b_of_type_JavaUtilArrayList != null) {}
      for (int i2 = this.jdField_b_of_type_JavaUtilArrayList.size();; i2 = 0)
      {
        awqx.b(null, "dc00898", "", "", "0X800A070", "0X800A070", 0, 0, i2 + "", i1 + "", "", "");
        return;
      }
    }
  }
  
  void k()
  {
    if (this.jdField_a_of_type_Bass != null) {
      this.jdField_a_of_type_Bass.c();
    }
  }
  
  public void l()
  {
    if (!this.E) {
      this.jdField_a_of_type_Bass.a();
    }
  }
  
  public void m()
  {
    if (!this.E) {
      this.jdField_a_of_type_Bass.b();
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (QLog.isDevelopLevel()) {
      QLog.d("PhotoPreviewActivity", 4, "[PhotoPreviewActivity] [onActivityResult] requestCode = " + paramInt1 + "  resultCode:" + paramInt2 + "  ok:" + -1);
    }
    if ((this.jdField_s_of_type_Boolean) && (paramInt2 == -1))
    {
      setResult(paramInt2, null);
      finish();
      return;
    }
    if (((this.jdField_l_of_type_Boolean) || (this.jdField_m_of_type_Boolean)) && (paramInt2 == -1) && (paramInt1 != 24747))
    {
      setResult(paramInt2, paramIntent);
      finish();
      return;
    }
    if ((paramInt2 != -1) && (paramInt1 == 10002) && (this.jdField_l_of_type_Boolean) && (paramIntent != null))
    {
      String str = paramIntent.getStringExtra("PhotoConst.FROM_QQSTORY_SLIDESHOW_DATA");
      if (!TextUtils.isEmpty(str)) {
        bace.a(new File(str).getParent());
      }
    }
    if (paramInt1 == 10012)
    {
      e(paramInt1, paramInt2, paramIntent);
      return;
    }
    if (paramInt1 == 10013)
    {
      f(paramInt1, paramInt2, paramIntent);
      return;
    }
    if (paramInt1 == 24747)
    {
      vhg.a().a(paramIntent, this.jdField_g_of_type_JavaUtilHashMap);
      return;
    }
    if (paramInt1 == 18001)
    {
      d(paramInt1, paramInt2, paramIntent);
      return;
    }
    if (paramInt1 == 18002)
    {
      c(paramInt1, paramInt2, paramIntent);
      return;
    }
    if (paramInt1 == 18003)
    {
      b(paramInt1, paramInt2, paramIntent);
      return;
    }
    if (paramInt1 == 10000)
    {
      a(paramInt1, paramInt2, paramIntent);
      return;
    }
    PhotoUtils.a(this, paramInt1, paramInt2, paramIntent, this.jdField_u_of_type_Boolean, this.jdField_b_of_type_JavaLangString);
  }
  
  public void onBackPressed()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery.a(false)) {
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      super.setResult(0);
      super.finish();
      return;
    }
    a(false);
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
      label187:
      int i1;
      if (paramBoolean)
      {
        paramCompoundButton = this.jdField_a_of_type_AndroidWidgetCheckBox;
        if (!paramBoolean) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          paramCompoundButton.setChecked(paramBoolean);
          this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(2147483647);
          if (baaf.a(this.jdField_b_of_type_JavaUtilArrayList, jdField_a_of_type_Int, PhotoListActivity.jdField_a_of_type_JavaUtilHashMap, this.E, this.jdField_g_of_type_JavaUtilHashMap) <= 0) {
            break label187;
          }
          bbmy.a(this, getResources().getString(2131629431), 0).b(getResources().getDimensionPixelSize(2131167766));
          this.jdField_e_of_type_Int = 0;
          this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131629435));
          this.jdField_b_of_type_AndroidWidgetCheckBox.setChecked(false);
          break;
        }
        if (this.jdField_b_of_type_JavaUtilArrayList.isEmpty())
        {
          int i2 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery.getFirstVisiblePosition();
          if (i2 < this.jdField_a_of_type_JavaUtilArrayList.size())
          {
            long l1 = new File((String)this.jdField_a_of_type_JavaUtilArrayList.get(i2)).length();
            if (a((String)this.jdField_a_of_type_JavaUtilArrayList.get(i2)) == 1) {}
            for (i1 = 1;; i1 = 0)
            {
              if ((i1 != 0) || (l1 <= axwv.a())) {
                break label341;
              }
              bbmy.a(this, getResources().getString(2131629431), 0).b(getResources().getDimensionPixelSize(2131167766));
              this.jdField_e_of_type_Int = 0;
              this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131629435));
              this.jdField_b_of_type_AndroidWidgetCheckBox.setChecked(false);
              break;
            }
            label341:
            if ((i1 != 0) && (l1 > 104345600L))
            {
              bbmy.a(this, getResources().getString(2131653694), 0).b(getResources().getDimensionPixelSize(2131167766));
              baaf.d();
            }
            b(1);
            this.jdField_b_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_JavaUtilArrayList.get(i2));
            this.jdField_c_of_type_JavaUtilArrayList.add(Integer.valueOf(i2));
            this.jdField_b_of_type_AndroidWidgetCheckBox.setChecked(true);
            this.jdField_e_of_type_Int = 2;
            i();
            g();
            paramCompoundButton = PresendPicMgr.a();
            if ((paramCompoundButton != null) && (a((String)this.jdField_a_of_type_JavaUtilArrayList.get(i2)) != 1)) {
              paramCompoundButton.a((String)this.jdField_a_of_type_JavaUtilArrayList.get(i2), this.jdField_o_of_type_Int);
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
          if (baaf.a(this.jdField_b_of_type_JavaUtilArrayList, 104345600L, PhotoListActivity.jdField_a_of_type_JavaUtilHashMap, this.E, this.jdField_g_of_type_JavaUtilHashMap) > 0)
          {
            bbmy.a(this, getResources().getString(2131653694), 0).b(getResources().getDimensionPixelSize(2131167766));
            baaf.d();
          }
          this.jdField_b_of_type_AndroidWidgetCheckBox.setChecked(true);
          this.jdField_e_of_type_Int = 2;
          i();
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
        this.jdField_b_of_type_AndroidWidgetCheckBox.setChecked(false);
        this.jdField_e_of_type_Int = 0;
        this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131629435));
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
        continue;
        if (this.y)
        {
          o();
          this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
        }
        else
        {
          this.P = paramBoolean;
          if (paramBoolean)
          {
            this.R = true;
            paramCompoundButton = this.jdField_b_of_type_AndroidWidgetCheckBox;
            if (!paramBoolean) {}
            for (paramBoolean = true;; paramBoolean = false)
            {
              paramCompoundButton.setChecked(paramBoolean);
              this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(2147483647);
              if ((this.jdField_b_of_type_JavaUtilArrayList.isEmpty()) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery.getFirstVisiblePosition() < this.jdField_a_of_type_JavaUtilArrayList.size()))
              {
                this.jdField_b_of_type_AndroidViewView.performClick();
                g();
              }
              if ((this.Q) && (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow == null))
              {
                this.Q = false;
                BaseApplicationImpl.getApplication().getSharedPreferences(BaseApplicationImpl.getApplication().getRuntime().getAccount(), 4).edit().putBoolean("showFlashPic", false).commit();
                this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = new BubblePopupWindow(-2, -2);
                paramCompoundButton = new TextView(this);
                i1 = aciy.a(10.0F, getResources());
                paramCompoundButton.setPadding(i1, 0, i1, 0);
                paramCompoundButton.setTextColor(-1);
                paramCompoundButton.setText(ajjy.a(2131642346));
                paramCompoundButton.setTextSize(14.0F);
                this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(paramCompoundButton);
                this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(false);
                this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b(this.jdField_a_of_type_AndroidWidgetTextView);
              }
              if (this.jdField_b_of_type_Int != 0) {
                break label1005;
              }
              awqx.b(null, "dc00898", "", "", "0X8006997", "0X8006997", 0, 0, "", "", "", "");
              break;
            }
            label1005:
            if (this.jdField_b_of_type_Int == 3000) {
              awqx.b(null, "dc00898", "", "", "0X8006998", "0X8006998", 0, 0, "", "", "", "");
            } else if (this.jdField_b_of_type_Int == 1) {
              awqx.b(null, "dc00898", "", "", "0X8006999", "0X8006999", 0, 0, "", "", "", "");
            }
          }
          else
          {
            this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
            if (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) {
              this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b();
            }
          }
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    bjeh.a(this);
    ahji.a("preview create");
    this.jdField_g_of_type_Int = getResources().getDisplayMetrics().widthPixels;
    this.jdField_h_of_type_Int = getResources().getDisplayMetrics().heightPixels;
    b();
    if (bjeh.c()) {
      bjeh.b(this);
    }
    super.onCreate(paramBundle);
    super.setContentView(2131493817);
    n();
    this.jdField_a_of_type_Agew = new agfd();
    afzu.jdField_a_of_type_Float = getResources().getDimension(2131165887);
    if (Build.VERSION.SDK_INT == 19)
    {
      paramBundle = getWindow().getDecorView();
      paramBundle.setSystemUiVisibility(paramBundle.getSystemUiVisibility() | 0x4 | 0x100 | 0x1000);
    }
    d();
  }
  
  public void onDestroy()
  {
    getIntent().putExtra("PhotoConst.SEND_BUSINESS_TYPE", this.jdField_u_of_type_Int);
    if (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b();
    }
    QQLiveImage.onBackground(this);
    super.onDestroy();
    try
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
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
        Object localObject1 = (String)this.jdField_a_of_type_JavaUtilArrayList.get(0);
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
        break label229;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PhotoPreviewActivity", 2, "remove file error");
      }
      if ((this.jdField_i_of_type_Int != 103) || (this.jdField_a_of_type_JavaUtilArrayList == null)) {}
    }
    label229:
    k();
    if ((this.E) && (this.jdField_a_of_type_Agew != null)) {
      this.jdField_a_of_type_Agew.k();
    }
    this.jdField_a_of_type_Agew = null;
    if (d()) {
      vhg.a().f();
    }
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    b();
    d();
  }
  
  public void onPause()
  {
    super.onPause();
    if ((this.E) && (this.jdField_a_of_type_Agew != null)) {
      this.jdField_a_of_type_Agew.i();
    }
    lor.a(BaseApplicationImpl.getContext(), false);
    bbqo.a(BaseApplicationImpl.getContext(), true, 52);
    aluq.a(BaseApplicationImpl.getContext(), 2, true);
  }
  
  @TargetApi(9)
  public void onResume()
  {
    super.onResume();
    QQLiveImage.onForeground(this);
    if ((this.jdField_g_of_type_Boolean) && (this.jdField_a_of_type_AndroidViewView != null)) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    lor.a(BaseApplicationImpl.getContext(), true);
    bbqo.a(BaseApplicationImpl.getContext(), false, 52);
    aluq.a(BaseApplicationImpl.getContext(), 2, false);
    if (this.jdField_a_of_type_AndroidWidgetButton != null) {
      this.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
    }
    if ((this.E) && (this.jdField_a_of_type_Agew != null)) {
      this.jdField_a_of_type_Agew.j();
    }
    if (d())
    {
      vhg.a().c();
      vhg.a().a(this.jdField_a_of_type_Vhk);
      vhg.a().b(this.jdField_b_of_type_JavaUtilArrayList, PhotoListActivity.jdField_a_of_type_JavaUtilHashMap);
    }
  }
  
  public void onStop()
  {
    super.onStop();
    ((AudioManager)getSystemService("audio")).abandonAudioFocus(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.PhotoPreviewActivity
 * JD-Core Version:    0.7.0.1
 */