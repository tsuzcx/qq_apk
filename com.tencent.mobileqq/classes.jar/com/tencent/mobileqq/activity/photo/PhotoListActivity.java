package com.tencent.mobileqq.activity.photo;

import NS_MOBILE_OPERATION.PicInfo;
import abju;
import aciy;
import adwz;
import afzf;
import afzs;
import afzz;
import agam;
import agaq;
import agbd;
import agbe;
import agbf;
import agbg;
import agbh;
import agbi;
import agbj;
import agbk;
import agbl;
import agbm;
import agbn;
import agbo;
import agbp;
import agbu;
import agbw;
import agbx;
import agby;
import agbz;
import agca;
import agcb;
import agdo;
import ageh;
import ageu;
import ahji;
import ahub;
import ajed;
import ajjy;
import algw;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.BitmapFactory.Options;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import apbx;
import apck;
import autt;
import awcx;
import aweg;
import awmc;
import awqm;
import awqx;
import awrn;
import axwv;
import azhe;
import azvq;
import azyk;
import baae;
import baaf;
import babr;
import bace;
import badq;
import bafb;
import bbms;
import bbmy;
import bbrm;
import befo;
import behi;
import bejw;
import bfhn;
import bfpr;
import bfpy;
import bfqv;
import bfqw;
import bgcj;
import bggp;
import biys;
import bjeg;
import bjgs;
import bjlh;
import bjli;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyUploadAvatarActivity;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.component.media.image.ImageManager;
import com.tencent.mobileqq.activity.FavEmosmManageActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivityForPeak;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.photo.PeakActivity;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity.SendVideoInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.emoticonview.EmotionPreviewFragment;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;
import com.tencent.mobileqq.troop.activity.TroopBarReplyActivity;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GestureSelectGridView;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneVideoDownloadActivity;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.model.BaseBusinessAlbumInfo;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import dov.com.tencent.mobileqq.activity.richmedia.QzoneEditPictureActivity;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import kzy;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import sjj;
import urp;
import vhg;
import vhk;
import vhm;
import vhn;
import wyf;
import zqk;

public class PhotoListActivity
  extends PeakActivity
  implements agam, View.OnClickListener, CompoundButton.OnCheckedChangeListener, vhm
{
  static int jdField_a_of_type_Int = (int)axwv.a();
  private static agbz jdField_a_of_type_Agbz = new agbz();
  public static ArrayList<String> a;
  public static HashMap<String, LocalMediaInfo> a;
  private static Map<String, LocalMediaInfo> jdField_a_of_type_JavaUtilMap;
  public static boolean a;
  public static boolean c;
  public static long f;
  public static int n;
  private static int x;
  boolean A;
  boolean B = false;
  public boolean C = false;
  public boolean D = false;
  boolean E = true;
  boolean F = false;
  boolean G;
  public boolean H = false;
  public boolean I = false;
  public boolean J = false;
  public boolean K = false;
  public boolean L;
  public boolean M;
  public boolean N;
  public boolean O;
  public boolean P;
  public boolean Q;
  public boolean R;
  public boolean S;
  public boolean T;
  public boolean U;
  public boolean V;
  boolean W = false;
  public boolean X = false;
  public boolean Y = false;
  public double a;
  public long a;
  public afzz a;
  public agbx a;
  public agcb a;
  Dialog jdField_a_of_type_AndroidAppDialog;
  SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  AsyncTask<Object, Object, List<LocalMediaInfo>> jdField_a_of_type_AndroidOsAsyncTask;
  public Handler a;
  View jdField_a_of_type_AndroidViewView;
  Button jdField_a_of_type_AndroidWidgetButton;
  CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private bbms jdField_a_of_type_Bbms;
  behi jdField_a_of_type_Behi = new agbp(this);
  bejw jdField_a_of_type_Bejw = new agbd(this);
  SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = null;
  public LocalMediaInfo a;
  public GestureSelectGridView a;
  public String a;
  public HashSet<String> a;
  private LinkedHashMap<String, LocalMediaInfo> jdField_a_of_type_JavaUtilLinkedHashMap;
  private vhk jdField_a_of_type_Vhk;
  private boolean aA;
  private boolean aB;
  private boolean aC;
  private boolean aD;
  private boolean aE;
  private boolean aF;
  private boolean ae;
  private boolean af;
  private boolean ag;
  private boolean ah;
  private boolean ai;
  private boolean aj;
  private boolean ak;
  private boolean al;
  private boolean am;
  private boolean an;
  private boolean ao;
  private boolean ap;
  private boolean aq;
  private boolean ar;
  private boolean as;
  private boolean at;
  private boolean au;
  private boolean av;
  private boolean aw;
  private boolean ax = true;
  private boolean ay;
  private boolean az;
  public double b;
  public int b;
  public long b;
  View jdField_b_of_type_AndroidViewView;
  protected Button b;
  CheckBox jdField_b_of_type_AndroidWidgetCheckBox;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  public String b;
  public ArrayList<String> b;
  public HashMap<String, PicInfo> b;
  public HashSet<String> b;
  public boolean b;
  public int c;
  public long c;
  public Button c;
  TextView c;
  public String c;
  public ArrayList<String> c;
  public HashMap<String, LocalMediaInfo> c;
  int jdField_d_of_type_Int;
  public long d;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  public String d;
  public ArrayList<Integer> d;
  public HashMap<String, Integer> d;
  public boolean d;
  int jdField_e_of_type_Int;
  public long e;
  public TextView e;
  public String e;
  HashMap<String, PhotoSendParams> jdField_e_of_type_JavaUtilHashMap;
  int jdField_f_of_type_Int;
  TextView jdField_f_of_type_AndroidWidgetTextView;
  String jdField_f_of_type_JavaLangString;
  public HashMap<String, byte[]> f;
  boolean jdField_f_of_type_Boolean = false;
  int jdField_g_of_type_Int;
  public long g;
  TextView jdField_g_of_type_AndroidWidgetTextView;
  String jdField_g_of_type_JavaLangString;
  private HashMap<LocalMediaInfo, LocalMediaInfo> jdField_g_of_type_JavaUtilHashMap = new HashMap();
  public boolean g;
  protected int h;
  TextView jdField_h_of_type_AndroidWidgetTextView;
  String jdField_h_of_type_JavaLangString = null;
  public boolean h;
  public int i;
  private long jdField_i_of_type_Long = -1L;
  String jdField_i_of_type_JavaLangString;
  public boolean i;
  protected int j;
  public String j;
  public boolean j;
  int jdField_k_of_type_Int = 0;
  String jdField_k_of_type_JavaLangString;
  public boolean k;
  public int l;
  String l;
  public boolean l;
  public int m;
  public String m;
  protected boolean m;
  private String jdField_n_of_type_JavaLangString = "";
  boolean jdField_n_of_type_Boolean = false;
  public int o;
  private String jdField_o_of_type_JavaLangString;
  boolean jdField_o_of_type_Boolean = false;
  public int p;
  private String jdField_p_of_type_JavaLangString;
  boolean jdField_p_of_type_Boolean = true;
  public int q;
  public boolean q;
  public int r;
  private String jdField_r_of_type_JavaLangString;
  boolean jdField_r_of_type_Boolean = false;
  public int s;
  boolean s;
  public int t;
  boolean t;
  public int u;
  boolean u;
  public int v;
  public boolean v;
  boolean w = false;
  protected boolean x;
  private int y;
  public boolean y;
  boolean z;
  
  static
  {
    jdField_n_of_type_Int = -1;
    jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public PhotoListActivity()
  {
    this.jdField_d_of_type_Boolean = false;
    this.jdField_i_of_type_Boolean = true;
    this.jdField_a_of_type_Agbx = null;
    this.jdField_i_of_type_Int = 1;
    this.jdField_j_of_type_Int = 1;
    this.jdField_j_of_type_Boolean = true;
    this.jdField_k_of_type_Boolean = false;
    this.jdField_l_of_type_Boolean = false;
    this.jdField_q_of_type_Boolean = false;
    this.jdField_s_of_type_Boolean = false;
    this.jdField_t_of_type_Boolean = false;
    this.jdField_v_of_type_Boolean = false;
    this.jdField_q_of_type_Int = 0;
    this.jdField_r_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = null;
    this.jdField_a_of_type_AndroidOsHandler = new agbw(this);
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_b_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_g_of_type_Long = 0L;
  }
  
  private int a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (a(paramString) == null)) {
      return -1;
    }
    return baaf.a(a(paramString));
  }
  
  private Intent a(Intent paramIntent, String paramString)
  {
    if ((this.ao) || (this.an) || (this.ap) || (this.al) || (this.av)) {
      paramIntent = QzoneEditPictureActivity.a(this, paramString);
    }
    return paramIntent;
  }
  
  private LocalMediaInfo a(String paramString)
  {
    LocalMediaInfo localLocalMediaInfo = null;
    if (this.jdField_c_of_type_JavaUtilHashMap != null) {
      localLocalMediaInfo = (LocalMediaInfo)this.jdField_c_of_type_JavaUtilHashMap.get(paramString);
    }
    if ((localLocalMediaInfo == null) && (jdField_a_of_type_JavaUtilHashMap != null)) {
      localLocalMediaInfo = (LocalMediaInfo)jdField_a_of_type_JavaUtilHashMap.get(paramString);
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
        paramString = (LocalMediaInfo)jdField_a_of_type_JavaUtilHashMap.get(paramString);
        if ((paramString != null) && ((paramString.mediaWidth == 0) || (paramString.mediaHeight == 0)))
        {
          paramString.mediaWidth = localLocalMediaInfo.mediaWidth;
          paramString.mediaHeight = localLocalMediaInfo.mediaHeight;
          paramString.rotation = localLocalMediaInfo.rotation;
        }
      }
      return localLocalMediaInfo;
    }
  }
  
  public static String a(long paramLong)
  {
    paramLong /= 1000L;
    int i1 = (int)paramLong % 60;
    int i2 = (int)paramLong / 60;
    String str1;
    if (i1 > 9)
    {
      str1 = String.valueOf(i1);
      if (i2 <= 9) {
        break label104;
      }
    }
    label104:
    for (String str2 = String.valueOf(i2);; str2 = "0" + String.valueOf(i2))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str2).append(":").append(str1);
      return localStringBuilder.toString();
      str1 = "0" + String.valueOf(i1);
      break;
    }
  }
  
  private String a(LocalMediaInfo paramLocalMediaInfo)
  {
    String str2 = ajjy.a(2131642289) + this.jdField_i_of_type_Int + "张图片\\视频";
    String str1 = str2;
    if (paramLocalMediaInfo != null)
    {
      paramLocalMediaInfo = agaq.a(paramLocalMediaInfo.mMimeType);
      if ((!this.aC) || (!this.K)) {
        break label99;
      }
      str1 = ajjy.a(2131642326) + this.jdField_i_of_type_Int + ajjy.a(2131642333);
    }
    label99:
    do
    {
      return str1;
      if ((k()) && (!this.K)) {
        return ajjy.a(2131642294) + this.jdField_i_of_type_Int + ajjy.a(2131642306);
      }
      if (this.T) {
        return "已达到照片墙上限12张";
      }
      if ((jdField_x_of_type_Int > 0) || ((this.K) && (paramLocalMediaInfo != null) && ("video".equals(paramLocalMediaInfo[0]))))
      {
        if ((jdField_x_of_type_Int == this.jdField_i_of_type_Int) && (this.K) && (paramLocalMediaInfo != null) && ("video".equals(paramLocalMediaInfo[0]))) {
          new StringBuilder().append(ajjy.a(2131642296)).append(this.jdField_i_of_type_Int).append(ajjy.a(2131642309)).toString();
        }
        if ((k()) && (!this.ar)) {
          return ajjy.a(2131642311) + this.jdField_i_of_type_Int + "张照片\\视频";
        }
        return ajjy.a(2131642300) + this.jdField_i_of_type_Int + "张图片\\视频";
      }
      if ((this.jdField_k_of_type_Int == 1) || (this.ag)) {
        break;
      }
      str1 = str2;
    } while (!this.af);
    return getResources().getString(2131629415, new Object[] { Integer.valueOf(this.jdField_i_of_type_Int) });
  }
  
  private String a(String paramString)
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
  
  private ArrayList<String> a(String paramString)
  {
    localArrayList = new ArrayList();
    try
    {
      paramString = paramString.split(";");
      if ((paramString != null) && (paramString.length > 0))
      {
        int i1 = 0;
        while (i1 < paramString.length)
        {
          localArrayList.add(paramString[i1]);
          i1 += 1;
        }
      }
      return localArrayList;
    }
    catch (NullPointerException paramString)
    {
      QLog.e("PhotoListActivity", 2, "parseBlockPaths error!");
    }
  }
  
  private List<LocalMediaInfo> a(int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      if ((paramInt1 >= 0) && (paramInt2 >= 0) && (paramInt1 <= paramInt2) && (paramInt1 <= paramInt2)) {
        try
        {
          if (paramInt1 < this.jdField_a_of_type_Agbx.getCount())
          {
            LocalMediaInfo localLocalMediaInfo = this.jdField_a_of_type_Agbx.a(paramInt1);
            if (localLocalMediaInfo.mMimeType.equals("image/jpeg")) {
              localArrayList.add(localLocalMediaInfo);
            }
          }
          paramInt1 += 1;
        }
        catch (Exception localException)
        {
          QLog.e("PhotoListActivity", 2, "getExposedMedia error!", localException);
        }
      }
    }
    return localArrayList;
  }
  
  private void a(int paramInt)
  {
    int i1 = 2;
    if (TextUtils.isEmpty(this.jdField_n_of_type_JavaLangString)) {
      return;
    }
    int i4 = this.jdField_c_of_type_JavaUtilArrayList.size();
    int i3;
    int i2;
    if (i4 == 0)
    {
      i3 = 601;
      i2 = 0;
      switch (paramInt)
      {
      default: 
        return;
      case 2131302804: 
        i1 = 3;
      }
    }
    for (;;)
    {
      if ((this.jdField_k_of_type_Int != 1) || (paramInt != 2131310076)) {
        break label153;
      }
      LpReportInfo_pf00064.allReport(586, 47, 3, String.valueOf(i4));
      return;
      i3 = 600;
      if (i4 == 1)
      {
        i2 = 1;
        break;
      }
      i2 = 2;
      break;
      i1 = 4;
      continue;
      i1 = 1;
      continue;
      i1 = 5;
    }
    label153:
    LpReportInfo_pf00064.allReport(i3, i2, i1);
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    int i2 = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition();
    int i3 = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getLastVisiblePosition();
    int i1 = i2;
    if (i1 <= i3)
    {
      if ((paramBoolean) && (paramInt != i1)) {}
      label391:
      for (;;)
      {
        i1 += 1;
        break;
        Object localObject = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getChildAt(i1 - i2);
        LocalMediaInfo localLocalMediaInfo = this.jdField_a_of_type_Agbx.a(i1);
        if (localObject == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PhotoListActivity", 2, "updateCheckbox view = null at " + i1);
          }
        }
        else if (localLocalMediaInfo == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PhotoListActivity", 2, "updateCheckbox info = null at " + i1);
          }
        }
        else
        {
          int i4;
          agby localagby;
          if (paramInt != i1)
          {
            i4 = this.jdField_c_of_type_JavaUtilArrayList.indexOf(localLocalMediaInfo.path);
            if (i4 >= 0)
            {
              localagby = (agby)((View)localObject).getTag();
              if ((localagby != null) && (localagby.a != null)) {
                localagby.a.setCheckedNumber(i4 + 1);
              }
            }
          }
          else
          {
            i4 = baaf.a(localLocalMediaInfo);
            if ((i4 == 0) || (i4 == 1))
            {
              localagby = (agby)((View)localObject).getTag();
              ImageView localImageView = localagby.c;
              int i5 = localLocalMediaInfo.selectStatus;
              if (i5 == 1)
              {
                localImageView.setVisibility(0);
                localagby.a.setCheckedNumber(this.jdField_c_of_type_JavaUtilArrayList.indexOf(localLocalMediaInfo.path) + 1);
                if (((View)localObject).getBackground() != null) {
                  ((View)localObject).setBackgroundDrawable(null);
                }
              }
              for (;;)
              {
                if (!AppSetting.jdField_c_of_type_Boolean) {
                  break label391;
                }
                localObject = PhotoUtils.a(i4, localLocalMediaInfo, i1, localagby.a.isChecked());
                localagby.a.setContentDescription((CharSequence)localObject);
                break;
                if (i5 == 3)
                {
                  localImageView.setVisibility(4);
                  localagby.a.setChecked(false);
                }
                else
                {
                  localImageView.setVisibility(4);
                  localagby.a.setChecked(false);
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
  
  private void a(Intent paramIntent, boolean paramBoolean)
  {
    int i7 = PhotoUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    Object localObject1 = new HashMap();
    int i1 = 0;
    int i2 = 0;
    int i6 = 0;
    int i5 = 0;
    while (i5 < this.jdField_c_of_type_JavaUtilArrayList.size())
    {
      localObject2 = (String)this.jdField_c_of_type_JavaUtilArrayList.get(i5);
      if (ImageManager.isNetworkUrl((String)localObject2))
      {
        i5 += 1;
      }
      else
      {
        int i3;
        int i4;
        if (a((String)localObject2) == 1)
        {
          localObject2 = a((String)localObject2);
          i3 = i2;
          i4 = i1;
          if (localObject2 != null)
          {
            localObject3 = new SendVideoActivity.SendVideoInfo();
            ((SendVideoActivity.SendVideoInfo)localObject3).fileSize = ((LocalMediaInfo)localObject2).fileSize;
            ((SendVideoActivity.SendVideoInfo)localObject3).duration = ((LocalMediaInfo)localObject2).mDuration;
            ((HashMap)localObject1).put(Integer.valueOf(i6), localObject3);
            i4 = i1 + 1;
            i3 = i2;
          }
        }
        for (;;)
        {
          i6 += 1;
          i1 = i4;
          i2 = i3;
          break;
          i3 = i2 + 1;
          i4 = i1;
        }
      }
    }
    Object localObject2 = String.valueOf(i2);
    Object localObject3 = String.valueOf(i1);
    if (!((HashMap)localObject1).isEmpty()) {
      paramIntent.putExtra("PhotoConst.VIDEO_INFOS", (Serializable)localObject1);
    }
    for (i1 = 1;; i1 = 0)
    {
      if ((aweg.jdField_b_of_type_Long != 0L) && (System.currentTimeMillis() - aweg.jdField_b_of_type_Long < 300000L)) {}
      for (boolean bool = true;; bool = false)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoListActivity", 2, "upload video isConfirmed=" + bool + " allowUploadInXGTime=" + aweg.jdField_b_of_type_Long);
        }
        if ((!badq.b(BaseApplicationImpl.getContext())) || (bool) || (i1 == 0) || (this.av)) {
          break;
        }
        localObject1 = getResources().getString(2131653417);
        paramIntent = new PhotoListActivity.17(this, paramBoolean, paramIntent, i7, (String)localObject2, (String)localObject3);
        if (bbrm.a(this, 4, new agbj(this, paramIntent))) {
          babr.a(this, 232, null, (String)localObject1, new agbk(this, paramIntent), new agbm(this)).show();
        }
        if (QLog.isColorLevel()) {
          QLog.i("PhotoListActivity", 2, "show shortvideo_mobile_send_confirm dialog");
        }
        return;
      }
      if (paramBoolean) {
        PhotoUtils.a(this, paramIntent, this.jdField_c_of_type_JavaUtilArrayList, this.jdField_e_of_type_JavaUtilHashMap, this.jdField_m_of_type_Int, false);
      }
      for (;;)
      {
        awqx.b(null, "CliOper", "", "", "0X8009AB0", "0X8009AB0", i7, 0, (String)localObject2, (String)localObject3, "", "");
        return;
        PhotoUtils.a(this, paramIntent, this.jdField_c_of_type_JavaUtilArrayList, this.jdField_m_of_type_Int, this.jdField_d_of_type_Boolean);
      }
    }
  }
  
  private void a(LocalMediaInfo paramLocalMediaInfo)
  {
    if (TextUtils.isEmpty(paramLocalMediaInfo.path)) {}
    Object localObject;
    do
    {
      return;
      if (!bjeg.c(getIntent()))
      {
        f();
        localObject = new Bundle();
        ((Bundle)localObject).putString("KEY_PIC_TO_VIDEO_LOCAL_PIC_PATH", paramLocalMediaInfo.path);
        ((Bundle)localObject).putBoolean("VIDEO_STORY_PHOTO_LIST_TO_EDIT", true);
        getIntent().putExtra("VIDEO_STORY_MEDIA_TYPE", 101);
        a(paramLocalMediaInfo, (Bundle)localObject);
        return;
      }
      localObject = wyf.a().a(paramLocalMediaInfo.path, "2");
    } while (TextUtils.isEmpty((CharSequence)localObject));
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    azvq.a(paramLocalMediaInfo.path, localOptions);
    int i1 = awmc.jdField_a_of_type_Int;
    float f1 = localOptions.outWidth / localOptions.outHeight;
    int i3 = autt.a(i1);
    int i4 = autt.a((int)(i3 / f1));
    int i2 = i3;
    i1 = i4;
    if (i4 > bjgs.jdField_a_of_type_Int)
    {
      i2 = autt.a((int)(i3 * bjgs.jdField_a_of_type_Int / i4));
      i1 = bjgs.jdField_a_of_type_Int;
    }
    wyf.a().a(paramLocalMediaInfo.path, (String)localObject, "2", i2, i1, false, 0, new agbu(this, (String)localObject, paramLocalMediaInfo));
  }
  
  private void a(LocalMediaInfo paramLocalMediaInfo, Bundle paramBundle)
  {
    if (paramLocalMediaInfo != null)
    {
      int i1 = getIntent().getIntExtra("entrance_type", 120);
      biys.a(this, paramLocalMediaInfo.path, paramLocalMediaInfo, 0, (int)paramLocalMediaInfo.mDuration, i1, 10023, 0, null, null, false, 11, 14, paramBundle);
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    Properties localProperties = new Properties();
    localProperties.put(paramString2, paramString3);
    awqm.a(BaseApplicationImpl.getContext()).reportKVEvent(paramString1, localProperties);
  }
  
  private void a(List<LocalMediaInfo> paramList)
  {
    QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").post(new PhotoListActivity.21(this, paramList));
  }
  
  private void a(List<String> paramList, HashMap<String, LocalMediaInfo> paramHashMap)
  {
    if ((paramList != null) && (paramHashMap != null) && (jdField_a_of_type_JavaUtilHashMap != null))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        if (!paramHashMap.containsKey(str)) {
          paramHashMap.put(str, jdField_a_of_type_JavaUtilHashMap.get(str));
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
          break label49;
        }
        c(paramIntent);
      }
    }
    for (;;)
    {
      bool1 = true;
      return bool1;
      label49:
      b(paramIntent);
    }
  }
  
  private boolean a(LocalMediaInfo paramLocalMediaInfo)
  {
    return (paramLocalMediaInfo != null) && ("image/gif".equals(paramLocalMediaInfo.mMimeType));
  }
  
  private boolean a(String paramString)
  {
    if (this.jdField_a_of_type_Agbx.jdField_a_of_type_JavaUtilArrayList != null)
    {
      int i1 = 0;
      for (boolean bool1 = false;; bool1 = bool2)
      {
        bool2 = bool1;
        if (i1 >= this.jdField_a_of_type_Agbx.jdField_a_of_type_JavaUtilArrayList.size()) {
          break;
        }
        bool2 = bool1;
        if (this.jdField_a_of_type_Agbx.jdField_a_of_type_JavaUtilArrayList.get(i1) != null)
        {
          bool2 = bool1;
          if (((LocalMediaInfo)this.jdField_a_of_type_Agbx.jdField_a_of_type_JavaUtilArrayList.get(i1)).path != null)
          {
            bool2 = bool1;
            if (((LocalMediaInfo)this.jdField_a_of_type_Agbx.jdField_a_of_type_JavaUtilArrayList.get(i1)).path.equals(paramString))
            {
              bool2 = bool1;
              if (baaf.a((LocalMediaInfo)this.jdField_a_of_type_Agbx.jdField_a_of_type_JavaUtilArrayList.get(i1)) == 1) {
                bool2 = true;
              }
            }
          }
        }
        i1 += 1;
      }
    }
    boolean bool2 = false;
    return bool2;
  }
  
  private void b(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    switch (paramInt)
    {
    }
    while (localHashMap.size() > 0)
    {
      QLog.i("PhotoListActivity", 2, "begin report");
      awrn.a(BaseApplication.getContext()).a(null, "qzoneChoosePhotoCamera", true, 0L, 0L, localHashMap, null, true);
      return;
      if (!this.aD)
      {
        this.aD = true;
        localHashMap.put("exposure", "1");
        QLog.i("PhotoListActivity", 2, "exposure");
        continue;
        localHashMap.put("click_fail", "1");
        QLog.i("PhotoListActivity", 2, "click_fail");
        continue;
        localHashMap.put("click_pass", "1");
        QLog.i("PhotoListActivity", 2, "click_pass");
        continue;
        localHashMap.put("result_video", "1");
        QLog.i("PhotoListActivity", 2, "result_video");
        continue;
        localHashMap.put("result_photo", "1");
        QLog.i("PhotoListActivity", 2, "result_photo");
      }
    }
    QLog.i("PhotoListActivity", 2, "no param");
  }
  
  private void b(Intent paramIntent)
  {
    b(5);
    paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if ((paramIntent != null) && (paramIntent.size() > 0) && (!TextUtils.isEmpty((CharSequence)paramIntent.get(0)))) {
      ThreadManager.postImmediately(new PhotoListActivity.9(this, (String)paramIntent.get(0)), null, true);
    }
  }
  
  private void b(LocalMediaInfo paramLocalMediaInfo)
  {
    bggp.a().a(new agbn(this, paramLocalMediaInfo));
  }
  
  private boolean b(Intent paramIntent)
  {
    if (this.aj)
    {
      startActivityForResult(paramIntent, 10012);
      return true;
    }
    if (this.ak)
    {
      startActivityForResult(paramIntent, 10013);
      return true;
    }
    if (this.am)
    {
      startActivity(paramIntent);
      finish();
      return true;
    }
    return false;
  }
  
  private boolean b(LocalMediaInfo paramLocalMediaInfo)
  {
    if ((paramLocalMediaInfo.mediaWidth < 320) || (paramLocalMediaInfo.mediaHeight < 320))
    {
      paramLocalMediaInfo = babr.a(this, 230, null, ajjy.a(2131642302), ajjy.a(2131642286), null, null, new agbo(this));
      try
      {
        paramLocalMediaInfo.show();
        return false;
      }
      catch (Exception paramLocalMediaInfo)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PhotoListActivity", 2, "showLocationFailDialog fail!", paramLocalMediaInfo);
          }
        }
      }
    }
    return true;
  }
  
  private void c(Intent paramIntent)
  {
    e();
    b(4);
    this.jdField_g_of_type_Long = System.currentTimeMillis();
    Object localObject = paramIntent.getStringExtra("video_new_fake_vid");
    paramIntent = paramIntent.getStringExtra("file_video_source_dir");
    sjj localsjj = new sjj();
    localsjj.a(true);
    localObject = sjj.a((String)localObject);
    String str = ahub.a(((PublishVideoEntry)localObject).mLocalRawVideoDir);
    if (TextUtils.isEmpty(str))
    {
      QZLog.i("PhotoListActivity", 1, "get target path fail");
      return;
    }
    localsjj.a((PublishVideoEntry)localObject, str, false, true, new agbe(this, str, (PublishVideoEntry)localObject, paramIntent));
  }
  
  private void c(String paramString)
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
  
  private boolean c()
  {
    if (QzoneConfig.getInstance().getConfig("PhotoUpload", "C2CAioEnableSyncImageToQzone", 1) == 0) {}
    while ((this.jdField_l_of_type_Int != 0) && (this.jdField_l_of_type_Int != 1000) && (this.jdField_l_of_type_Int != 1004)) {
      return false;
    }
    return true;
  }
  
  private int d()
  {
    return QzoneConfig.getInstance().getConfig("PhotoUpload", "QunAiOthresholdNum", 3);
  }
  
  private void d(Intent paramIntent)
  {
    if (this.aw)
    {
      paramIntent.putExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", true);
      paramIntent.putExtra("session_info", getIntent().getParcelableExtra("session_info"));
    }
  }
  
  private boolean d()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_AndroidContentSharedPreferences.contains("qzone_will_upload_to_qun_album" + this.jdField_j_of_type_JavaLangString)) {
      bool = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("qzone_will_upload_to_qun_album" + this.jdField_j_of_type_JavaLangString, false);
    }
    return bool;
  }
  
  private void e(Intent paramIntent)
  {
    if ((this.jdField_c_of_type_JavaUtilHashMap == null) || (this.jdField_a_of_type_JavaUtilLinkedHashMap == null)) {
      return;
    }
    for (;;)
    {
      try
      {
        if ((!this.au) && (this.jdField_a_of_type_Agbx != null) && (this.jdField_a_of_type_Agbx.getCount() > 0)) {
          p();
        }
        int i2 = QzoneConfig.getInstance().getConfig("PhotoAlbum", "MachineLearningExposedMediaUpperBound", 50) - this.jdField_c_of_type_JavaUtilHashMap.size();
        if (i2 <= 0) {
          break;
        }
        int i1 = 0;
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.entrySet().iterator();
        if ((localIterator.hasNext()) && (i1 < i2))
        {
          LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)((Map.Entry)localIterator.next()).getValue();
          if (!this.jdField_c_of_type_JavaUtilHashMap.containsKey(localLocalMediaInfo.path))
          {
            localArrayList.add(localLocalMediaInfo);
            i1 += 1;
          }
        }
        else
        {
          paramIntent.putExtra("qzone_album_machine_learning_exposed_media_list", (Serializable)localArrayList);
          return;
        }
      }
      catch (Exception paramIntent)
      {
        QLog.e("PhotoListActivity", 2, "prepareExposedMediaInfo error!", paramIntent);
        return;
      }
    }
  }
  
  private boolean e()
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.contains("qzone_will_upload_to_qun_album" + this.jdField_j_of_type_JavaLangString);
  }
  
  private void f(Intent paramIntent)
  {
    if (paramIntent != null) {
      try
      {
        if (this.jdField_a_of_type_JavaUtilLinkedHashMap == null) {
          return;
        }
        paramIntent = paramIntent.getSerializableExtra("qzone_album_machine_learning_exposed_media_list");
        if (paramIntent != null)
        {
          paramIntent = ((List)paramIntent).iterator();
          while (paramIntent.hasNext())
          {
            LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)paramIntent.next();
            this.jdField_a_of_type_JavaUtilLinkedHashMap.put(localLocalMediaInfo.path, localLocalMediaInfo);
          }
        }
        return;
      }
      catch (Exception paramIntent)
      {
        QLog.e("PhotoListActivity", 2, "restoreUnSelectedExposedData error!", paramIntent);
      }
    }
  }
  
  private boolean h()
  {
    boolean bool = true;
    if (c()) {
      if ((QzoneConfig.getInstance().getConfig("PhotoUpload", "C2CAioRememberState", 0) == 1) && (this.jdField_a_of_type_AndroidContentSharedPreferences.contains("qzone_will_upload_to_personal_album"))) {
        bool = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("qzone_will_upload_to_personal_album", false);
      }
    }
    do
    {
      do
      {
        return bool;
      } while (QzoneConfig.getInstance().getConfig("PhotoUpload", "C2CAioCheckBoxState", 0) == 1);
      return false;
      if (e()) {
        return d();
      }
    } while (QzoneConfig.getInstance().getConfig("PhotoUpload", "QunAioCheckBoxState", 0) == 1);
    return false;
  }
  
  private boolean i()
  {
    boolean bool2 = false;
    if ((!e()) || (!d())) {
      if (this.jdField_c_of_type_JavaUtilArrayList == null) {
        break label54;
      }
    }
    label54:
    for (int i1 = this.jdField_c_of_type_JavaUtilArrayList.size();; i1 = 0)
    {
      boolean bool1 = bool2;
      if (i1 >= d())
      {
        bool1 = bool2;
        if (h()) {
          bool1 = true;
        }
      }
      return bool1;
    }
  }
  
  private boolean j()
  {
    if (this.jdField_c_of_type_JavaUtilArrayList.size() > 0)
    {
      Iterator localIterator = this.jdField_c_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        if (a((String)localIterator.next()) == 0) {
          return false;
        }
      }
    }
    return true;
  }
  
  private void k()
  {
    if (this.aw) {
      awqx.b(null, "CliOper", "", "", "0x80083EC", "0x80083EC", 0, 0, "", "", "", "");
    }
  }
  
  private boolean k()
  {
    if (Build.VERSION.SDK_INT < 17) {}
    while ((!this.P) && (!this.aj) && (!this.ak) && (!this.R) && (!this.am)) {
      return false;
    }
    return true;
  }
  
  private void l()
  {
    Object localObject = vhg.a().a();
    if (this.V) {
      vhg.a().b((List)localObject);
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      SlideItemInfo localSlideItemInfo = (SlideItemInfo)((Iterator)localObject).next();
      if (!this.jdField_c_of_type_JavaUtilArrayList.contains(localSlideItemInfo.jdField_b_of_type_JavaLangString)) {
        this.jdField_c_of_type_JavaUtilArrayList.add(localSlideItemInfo.jdField_b_of_type_JavaLangString);
      }
      if (!this.jdField_d_of_type_JavaUtilArrayList.contains(localSlideItemInfo.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.position)) {
        this.jdField_d_of_type_JavaUtilArrayList.add(localSlideItemInfo.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.position);
      }
      this.jdField_c_of_type_JavaUtilHashMap.put(localSlideItemInfo.jdField_b_of_type_JavaLangString, localSlideItemInfo.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
    }
    if (this.jdField_c_of_type_JavaUtilArrayList.size() > 0) {
      vhg.a().a(this.jdField_c_of_type_JavaUtilArrayList, jdField_a_of_type_JavaUtilHashMap, false);
    }
  }
  
  private boolean l()
  {
    if (Build.VERSION.SDK_INT < 17) {
      return false;
    }
    return this.R;
  }
  
  private void m()
  {
    Object localObject = bfqv.a();
    if ((!((bfqw)localObject).a()) || (!autt.a()))
    {
      String str = QzoneConfig.getInstance().getConfig("QZoneTextSetting", "PhotoListCameraNotSupport", "当前不支持拍摄");
      if ((((bfqw)localObject).a() != null) && (((bfqw)localObject).b())) {
        bbmy.a(this, QzoneConfig.getInstance().getConfig("QZoneTextSetting", "ToastStartLiveVideoFailForMemory", "SD卡不存在或手机内存不足"), 0).a();
      }
      for (;;)
      {
        if (((bfqw)localObject).a() != null) {
          QZLog.e("PhotoListActivity", 2, new Object[] { "gotoCamera fail", ((bfqw)localObject).a() });
        }
        b(2);
        return;
        bbmy.a(this, str, 0).a();
      }
    }
    localObject = new Intent(this, QZoneVideoDownloadActivity.class);
    ((Intent)localObject).putExtra("extra.busi_type", 3);
    ((Intent)localObject).putExtra("extra_directly_back", true);
    ((Intent)localObject).putExtra("PhotoConst.PLUGIN_APK", "qzone_plugin.apk");
    ((Intent)localObject).putExtra("DirectBackToQzone", true);
    ((Intent)localObject).putExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME", PhotoListActivity.class.getClass().getName());
    ((Intent)localObject).putExtra("pic_confirm_text", getString(2131629407));
    ((Intent)localObject).putExtra("enable_edit_video", true);
    ((Intent)localObject).putExtra("enable_input_text", false);
    ((Intent)localObject).putExtra("enable_priv_list", false);
    ((Intent)localObject).putExtra("entry_source", 5);
    ((Intent)localObject).putExtra("support_record", true);
    ((Intent)localObject).putExtra("enable_local_video", false);
    ((Intent)localObject).putExtra("enable_local_button", false);
    ((Intent)localObject).putExtra("go_publish_activity", false);
    ((Intent)localObject).putExtra("enterPtu", false);
    if ("$VideoAlbumId".equals(this.jdField_b_of_type_JavaLangString)) {
      ((Intent)localObject).putExtra("support_pic", false);
    }
    for (;;)
    {
      ((Intent)localObject).putExtra("key_latitude", getIntent().getDoubleExtra("key_latitude", 4.9E-324D));
      ((Intent)localObject).putExtra("key_longtitude", getIntent().getDoubleExtra("key_longtitude", 4.9E-324D));
      startActivity((Intent)localObject);
      b(3);
      return;
      ((Intent)localObject).putExtra("support_pic", true);
    }
  }
  
  private void n()
  {
    if (((this.C) && ("$RecentAlbumId".equals(this.jdField_b_of_type_JavaLangString))) || ((this.D) && ("$VideoAlbumId".equals(this.jdField_b_of_type_JavaLangString)))) {
      new agca(this).execute(new Object[0]);
    }
  }
  
  private void o()
  {
    int i2 = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition();
    int i3 = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getLastVisiblePosition();
    int i1 = i2;
    if (i1 <= i3)
    {
      Object localObject = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getChildAt(i1 - i2);
      LocalMediaInfo localLocalMediaInfo = this.jdField_a_of_type_Agbx.a(i1);
      if (localObject == null) {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoListActivity", 2, "updateCheckbox view = null at " + i1);
        }
      }
      for (;;)
      {
        i1 += 1;
        break;
        if (localLocalMediaInfo == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PhotoListActivity", 2, "updateCheckbox info = null at " + i1);
          }
        }
        else
        {
          int i4 = this.jdField_c_of_type_JavaUtilArrayList.indexOf(localLocalMediaInfo.path);
          if (i4 >= 0)
          {
            localObject = (agby)((View)localObject).getTag();
            if ((localObject != null) && (((agby)localObject).a != null)) {
              ((agby)localObject).a.setCheckedNumber(i4 + 1);
            }
          }
        }
      }
    }
  }
  
  private void p()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView == null) || (this.jdField_a_of_type_JavaUtilLinkedHashMap == null)) {
      return;
    }
    Object localObject = a(this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition(), this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getLastVisiblePosition());
    if ((localObject != null) && (this.jdField_a_of_type_JavaUtilLinkedHashMap != null))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)((Iterator)localObject).next();
        if (!this.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(localLocalMediaInfo.path)) {
          this.jdField_a_of_type_JavaUtilLinkedHashMap.put(localLocalMediaInfo.path, localLocalMediaInfo);
        }
      }
    }
    this.au = true;
  }
  
  private void q()
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
  
  private void r()
  {
    if ((this.jdField_a_of_type_Bbms != null) && (this.jdField_a_of_type_Bbms.isShowing())) {
      this.jdField_a_of_type_Bbms.dismiss();
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
        this.jdField_m_of_type_JavaLangString = ((File)localObject).getAbsolutePath();
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
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= 0) && (paramInt1 < this.jdField_c_of_type_JavaUtilArrayList.size()) && (paramInt2 >= 0) && (paramInt2 < this.jdField_c_of_type_JavaUtilArrayList.size()))
    {
      Collections.swap(this.jdField_c_of_type_JavaUtilArrayList, paramInt1, paramInt2);
      paramInt2 = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition();
      int i1 = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getLastVisiblePosition();
      paramInt1 = paramInt2;
      while (paramInt1 <= i1)
      {
        Object localObject = this.jdField_a_of_type_Agbx.a(paramInt1);
        int i2 = this.jdField_c_of_type_JavaUtilArrayList.indexOf(((LocalMediaInfo)localObject).path);
        if (i2 >= 0)
        {
          localObject = (agby)this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getChildAt(((LocalMediaInfo)localObject).position.intValue() - paramInt2).getTag();
          if ((localObject != null) && (((agby)localObject).a != null)) {
            ((agby)localObject).a.setCheckedNumber(i2 + 1);
          }
        }
        paramInt1 += 1;
      }
      vhg.a().b(this.jdField_c_of_type_JavaUtilArrayList, jdField_a_of_type_JavaUtilHashMap);
    }
  }
  
  public void a(int paramInt, LocalMediaInfo paramLocalMediaInfo)
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {}
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_Agbx == null) || (this.jdField_a_of_type_Agbx.jdField_a_of_type_JavaUtilArrayList == null));
      localObject = (LocalMediaInfo)this.jdField_a_of_type_Agbx.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    } while ((localObject == null) || (paramLocalMediaInfo == null) || (((LocalMediaInfo)localObject).path == null) || (paramLocalMediaInfo.path == null) || (!((LocalMediaInfo)localObject).path.equals(paramLocalMediaInfo.path)));
    Object localObject = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
    ((Message)localObject).what = 0;
    Bundle localBundle = new Bundle();
    localBundle.putInt("ALBUMLIST_POSITION", paramInt);
    localBundle.putLong("ALBUMLIST_ITEM_DURATION", paramLocalMediaInfo.mDuration);
    ((Message)localObject).setData(localBundle);
    this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
  }
  
  void a(Intent paramIntent)
  {
    int i3 = 0;
    if (QLog.isColorLevel()) {
      QLog.d("SelectPhotoTrace", 2, "PhotoListActivity initData(),intent extras is:" + paramIntent.getExtras());
    }
    this.jdField_v_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", true);
    this.jdField_y_of_type_Int = paramIntent.getIntExtra("PhotoConst.current_record_video_count", 0);
    if (paramIntent.getBooleanExtra("album_enter_directly", false))
    {
      long l1 = System.currentTimeMillis();
      long l2 = baaf.jdField_a_of_type_Long;
      if ((this.jdField_v_of_type_Boolean) && (l1 - l2 < 60000L))
      {
        this.jdField_a_of_type_JavaLangString = baaf.jdField_c_of_type_JavaLangString;
        this.jdField_b_of_type_JavaLangString = baaf.jdField_b_of_type_JavaLangString;
      }
    }
    for (;;)
    {
      if (this.jdField_b_of_type_JavaLangString == null)
      {
        this.jdField_b_of_type_JavaLangString = "$RecentAlbumId";
        this.jdField_a_of_type_JavaLangString = null;
      }
      this.V = paramIntent.getBooleanExtra("PhotoConst.IS_FROM_EDIT", false);
      if ("qqfav.apk".equals(paramIntent.getStringExtra("PhotoConst.PLUGIN_APK"))) {
        this.af = true;
      }
      this.ag = paramIntent.getBooleanExtra("PhotoConst.IS_FROM_EMOTION_FAVORITE", false);
      this.ah = paramIntent.getBooleanExtra("PhotoConst.IS_FROM_EMOTION_FAVORITE_TO_ALBUM", false);
      this.az = paramIntent.getBooleanExtra("PhotoConst.IS_FROM_MINI_APP", false);
      this.aA = false;
      this.ai = "tribe".equals(paramIntent.getStringExtra("video_refer"));
      this.K = paramIntent.getBooleanExtra("PhotoConst.IS_SUPPORT_VIDEO_CHECKBOX", false);
      this.ar = paramIntent.getBooleanExtra("fromPhotoListPanel", false);
      if (this.ar) {
        this.K = true;
      }
      Object localObject = paramIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        if (((String)localObject).equals("com.qzone.publish.ui.activity.QZoneUploadPhotoRealActivity")) {
          this.an = true;
        }
        if ((((String)localObject).equals("com.qzone.publish.ui.activity.QZonePublishMoodTabActivity")) || (((String)localObject).equals("com.qzone.publish.ui.activity.QZonePublishMoodRealActivity")) || ("com.tencent.pubaccount.publish.QQPublicAccountPublishFeedActivity".equals(localObject))) {
          this.ao = true;
        }
        if (((String)localObject).equals("com.qzone.publish.ui.activity.QZonePublishVoiceMoodActivity")) {
          this.ap = true;
        }
        if (paramIntent.getBooleanExtra("PhotoConst.IS_FROM_P2V", false))
        {
          this.aq = true;
          this.ao = true;
        }
        if (paramIntent.getBooleanExtra("PhotoConst.IS_FROM_TROOP_FILE_LIST", false)) {
          this.as = true;
        }
      }
      this.at = paramIntent.getBooleanExtra("NEED_QZONE_MACHINE_LEARNING_REPORT", false);
      if (this.at)
      {
        this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
        f(paramIntent);
      }
      jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("QZONE_SUPPORT_MIX_MOOD", false);
      this.jdField_b_of_type_Boolean = paramIntent.getBooleanExtra("QZONE_PEAK_SUPPORT_VIDEO_EDIT_WHEN_PREVIEW", false);
      jdField_c_of_type_Boolean = paramIntent.getBooleanExtra("upload_single_video", false);
      if (((!TextUtils.isEmpty((CharSequence)localObject)) && ((((String)localObject).equals("com.qzone.publish.ui.activity.QZoneUploadPhotoRealActivity")) || (((String)localObject).equals("com.qzone.publish.ui.activity.QZonePublishMoodRealActivity")) || (((String)localObject).equals("com.qzone.publish.ui.activity.QZonePublishMoodTabActivity")) || (((String)localObject).equals("com.qzone.common.activities.FeedActionPanelActivity")) || ("com.tencent.pubaccount.publish.QQPublicAccountPublishFeedActivity".equals(localObject)))) || (this.jdField_l_of_type_Boolean) || (this.aq)) {
        this.av = true;
      }
      this.jdField_k_of_type_Int = paramIntent.getIntExtra("PhotoConst.KEY_SHOW_TYPE", 0);
      this.ae = paramIntent.getBooleanExtra("PeakConstants.showGifTypeIcon", false);
      this.jdField_c_of_type_JavaUtilArrayList = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
      if (this.jdField_c_of_type_JavaUtilArrayList == null) {
        this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
      }
      agdo.a(this, getIntent(), false, this.jdField_g_of_type_JavaUtilHashMap);
      this.jdField_d_of_type_JavaUtilHashMap = ((HashMap)paramIntent.getSerializableExtra("PhotoConst.PANORAMA_IMAGES"));
      if (this.jdField_d_of_type_JavaUtilHashMap == null) {
        this.jdField_d_of_type_JavaUtilHashMap = new HashMap();
      }
      this.jdField_c_of_type_JavaUtilHashMap = ((HashMap)paramIntent.getSerializableExtra("PeakConstants.selectedMediaInfoHashMap"));
      if (this.jdField_c_of_type_JavaUtilHashMap == null) {
        this.jdField_c_of_type_JavaUtilHashMap = new HashMap();
      }
      this.jdField_e_of_type_JavaUtilHashMap = ((HashMap)getIntent().getSerializableExtra("PhotoConst.PHOTO_PATHS_FROM_QZONEALBUM"));
      if (this.jdField_e_of_type_JavaUtilHashMap == null) {
        this.jdField_e_of_type_JavaUtilHashMap = new HashMap(1);
      }
      this.jdField_d_of_type_JavaUtilArrayList = new ArrayList();
      this.jdField_i_of_type_Int = paramIntent.getIntExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
      this.jdField_j_of_type_Int = paramIntent.getIntExtra("PhotoConst.MAXUM_SELECTED_NUM_VIDEO", 1);
      this.jdField_j_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_SINGLE_MODE", true);
      this.jdField_k_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_NO_PANORAMA", false);
      this.jdField_l_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_FROM_DYNAMIC_ALBUM", false);
      this.jdField_m_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_SHOW_QZONE_ALBUM", false);
      this.jdField_b_of_type_JavaUtilHashMap = ((HashMap)paramIntent.getSerializableExtra("PhotoConst.PHOTO_INFOS"));
      this.jdField_n_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", false);
      this.jdField_o_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.original_button", false);
      this.jdField_p_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.quality_count_tv", true);
      this.jdField_e_of_type_JavaLangString = paramIntent.getStringExtra("PhotoConst.MY_UIN");
      if (this.jdField_n_of_type_Boolean)
      {
        this.jdField_f_of_type_JavaLangString = paramIntent.getStringExtra("PhotoConst.MY_NICK");
        this.jdField_g_of_type_JavaLangString = paramIntent.getStringExtra("PhotoConst.MY_HEAD_DIR");
      }
      this.jdField_d_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.HANDLE_DEST_RESULT", false);
      this.jdField_r_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_SINGLE_DERECTBACK_MODE", false);
      this.jdField_s_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_SINGLE_NEED_EDIT", false);
      this.W = getIntent().getBooleanExtra("PhotoConst.QZONE_ALBUM_FROM_AIO", false);
      this.jdField_t_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false);
      this.jdField_l_of_type_Int = paramIntent.getIntExtra("uintype", -1);
      this.jdField_m_of_type_Int = paramIntent.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
      if (this.jdField_i_of_type_Int > 1) {
        this.jdField_j_of_type_Boolean = false;
      }
      if (paramIntent.getBooleanExtra("PhotoConst.ALWAYS_SHOW_NUMBER_WHEN_ONLY_ONE_IMAGE", false)) {
        this.jdField_j_of_type_Boolean = false;
      }
      this.jdField_u_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", false);
      this.w = paramIntent.getBooleanExtra("PhotoConst.SEND_FLAG", false);
      boolean bool2 = paramIntent.getBooleanExtra("PhotoConst.AIO_TO_PHOTO_LIST_NEED_SHOW_UPLOAD_BAR", false);
      boolean bool1;
      if ((this.jdField_l_of_type_Int == 1) && (!paramIntent.getBooleanExtra("is_anonymous", false)))
      {
        bool1 = true;
        label1049:
        this.z = bool1;
        if ((!this.z) && ((!bool2) || (!c()))) {
          break label2302;
        }
        bool1 = true;
        label1077:
        this.z = bool1;
        this.A = paramIntent.getBooleanExtra("PhotoConst.DISABLE_UPLOAD_TO_TROOP_ALBUM", false);
        bool1 = paramIntent.getBooleanExtra("filter_photolist_troopalbum_toolbar", false);
        if ((!this.z) || (bool1) || (this.A)) {
          break label2308;
        }
        bool1 = true;
        label1127:
        this.z = bool1;
        this.jdField_i_of_type_JavaLangString = paramIntent.getStringExtra("uinname");
        this.jdField_j_of_type_JavaLangString = paramIntent.getStringExtra("uin");
        if (this.jdField_l_of_type_Int == 9501) {
          this.J = paramIntent.getBooleanExtra("isdevicesupportmultiupload", false);
        }
        if (this.jdField_e_of_type_JavaLangString != null) {
          break label2314;
        }
        localObject = this.jdField_q_of_type_JavaLangString;
        this.jdField_e_of_type_JavaLangString = ((String)localObject);
        this.jdField_h_of_type_Int = paramIntent.getIntExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 1);
        this.jdField_a_of_type_Afzz = ((afzz)afzz.a.get(this.jdField_h_of_type_Int));
        this.jdField_f_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", false);
        if (this.jdField_f_of_type_Boolean)
        {
          this.jdField_a_of_type_Afzz = new afzs(afzz.d);
          this.jdField_h_of_type_Int = 1;
        }
        this.jdField_b_of_type_Long = paramIntent.getLongExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_SIZE", 1048576000L);
        this.jdField_g_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_PREVIEW_VIDEO", true);
        this.jdField_h_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_TRIM_VIDEO_BLACK_LIST", false);
        this.jdField_c_of_type_Long = paramIntent.getLongExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_DURATION", 9223372036854775807L);
        this.jdField_d_of_type_Long = paramIntent.getLongExtra("PhotoConst.QZONE_COVER_PHOTOLIST_KEY_VIDEO_DURATION", 9223372036854775807L);
        this.jdField_e_of_type_Long = paramIntent.getLongExtra("PhotoConst.PHOTOLIST_KEY_FILTER_VIDEO_DURATION_LIMIT", 9223372036854775807L);
      }
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = ((SessionInfo)getIntent().getParcelableExtra("session_info"));
        if (this.w)
        {
          paramIntent.removeExtra("PhotoConst.SEND_FLAG");
          localObject = PresendPicMgr.a();
          if (localObject != null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("PhotoListActivity", 2, "Photo+ send pic,cancel presend!");
            }
            ((PresendPicMgr)localObject).a(1004);
          }
          PhotoUtils.a(this, paramIntent, this.jdField_c_of_type_JavaUtilArrayList, this.jdField_m_of_type_Int, true);
        }
        this.jdField_h_of_type_JavaLangString = paramIntent.getStringExtra("PhotoConst.CUSTOM_SENDBTN_TEXT");
        if ((this.z) && (this.jdField_e_of_type_JavaLangString != null))
        {
          localObject = bfpr.a(this.jdField_e_of_type_JavaLangString, this.jdField_j_of_type_JavaLangString);
          if ((localObject != null) && (((BaseBusinessAlbumInfo)localObject).a() != null) && (!((BaseBusinessAlbumInfo)localObject).a().equals("")))
          {
            this.jdField_k_of_type_JavaLangString = ((BaseBusinessAlbumInfo)localObject).a();
            this.jdField_l_of_type_JavaLangString = ((BaseBusinessAlbumInfo)localObject).b();
            paramIntent.putExtra("UploadPhoto.key_album_id", this.jdField_k_of_type_JavaLangString);
            paramIntent.putExtra("UploadPhoto.key_album_name", this.jdField_l_of_type_JavaLangString);
          }
        }
        else
        {
          this.F = paramIntent.getBooleanExtra("PhotoConst.IS_JUMPTO_TROOP_ALBUM", false);
          this.G = paramIntent.getBooleanExtra("PhotoConst.UPLOAD_CHECKBOX_IS_CHECKED", false);
          this.H = paramIntent.getBooleanExtra("PhotoConst.IS_FROM_TROOP_BAR", false);
          this.I = paramIntent.getBooleanExtra("PhotoConst.IS_FROM_TROOP_REWARD", false);
          if ((this.F) || (this.H) || (this.I) || (this.aC) || (this.O) || (this.ai) || (k())) {
            break label2369;
          }
          bool1 = true;
          this.B = bool1;
          this.C = paramIntent.getBooleanExtra("PhotoConst.IS_SHOW_CAMERA", false);
          if (this.C) {
            this.D = paramIntent.getBooleanExtra("PhotoConst.SHOW_CAMERA_IN_VIDEO", false);
          }
          this.jdField_q_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", false);
          if (this.I)
          {
            this.jdField_a_of_type_Double = paramIntent.getDoubleExtra("maxProportion", 0.0D);
            this.jdField_b_of_type_Double = paramIntent.getDoubleExtra("minProportion", 0.0D);
            this.jdField_p_of_type_Int = paramIntent.getIntExtra("imageSizeLimit", 0);
          }
          if (this.jdField_q_of_type_Boolean)
          {
            this.jdField_f_of_type_JavaUtilHashMap = ((HashMap)paramIntent.getSerializableExtra("PasterConstants.pasters_data"));
            this.jdField_c_of_type_JavaLangString = paramIntent.getStringExtra("PasterConstants.paster_id");
            this.jdField_d_of_type_JavaLangString = paramIntent.getStringExtra("PasterConstants.paster_cate_id");
          }
          if (this.ap) {
            this.jdField_p_of_type_Int = paramIntent.getIntExtra("imageSizeLimit", 0);
          }
          this.jdField_n_of_type_JavaLangString = paramIntent.getStringExtra("report_from");
          this.jdField_s_of_type_Int = paramIntent.getIntExtra("PHOTOLIST_START_POSITION", -1);
          paramIntent.removeExtra("PHOTOLIST_START_POSITION");
          this.L = paramIntent.getBooleanExtra("from_health", false);
          this.M = paramIntent.getBooleanExtra("health_video", false);
          this.N = paramIntent.getBooleanExtra("readinjoy_video", false);
          if (this.L)
          {
            this.jdField_t_of_type_Int = paramIntent.getIntExtra("min_width", 200);
            this.jdField_u_of_type_Int = paramIntent.getIntExtra("min_height", 200);
            this.jdField_v_of_type_Int = paramIntent.getIntExtra("max_gif_size", 8388608);
          }
          this.O = paramIntent.getBooleanExtra("from_qqstory", false);
          this.P = paramIntent.getBooleanExtra("from_qqstory_slideshow", false);
          this.Q = paramIntent.getBooleanExtra("key_from_qqstory_text_filter", false);
          this.R = paramIntent.getBooleanExtra("from_qqstory_custom_data", false);
          this.S = paramIntent.getBooleanExtra("from_qqstory_entrance", false);
          if (paramIntent.getIntExtra("edit_video_type", 10002) != 10023) {
            break label2375;
          }
          bool1 = true;
          this.aF = bool1;
          this.am = paramIntent.getBooleanExtra("from_qzone_slideshow", false);
          this.T = paramIntent.getBooleanExtra("from_nearby", false);
          this.jdField_o_of_type_JavaLangString = paramIntent.getStringExtra("from_tribe_class_name");
          this.aw = paramIntent.getBooleanExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", false);
          this.al = paramIntent.getBooleanExtra("from_qzoneshare", false);
          this.aj = paramIntent.getBooleanExtra("from_tribe_slideshow", false);
          this.ak = paramIntent.getBooleanExtra("from_readinjoy_slideshow", false);
          this.aB = paramIntent.getBooleanExtra("PhotoConst.PHOTOLIST_IS_NEED_MEDIA_INFO", false);
          this.aC = paramIntent.getBooleanExtra("PhotoConst.PHOTOLIST_IS_FROM_HWUPLOAD", false);
          this.jdField_i_of_type_Long = paramIntent.getLongExtra("PhotoConst.PHOTOLIST_KEY_MAX_MEDIA_SIZE", -1L);
          this.U = paramIntent.getBooleanExtra("key_from_kandian_uploadimg", false);
          this.X = paramIntent.getBooleanExtra("FROM_ARK_CHOOSE_IMAGE", false);
          if (this.X)
          {
            this.jdField_p_of_type_JavaLangString = getIntent().getStringExtra("key_ark_app_res_path");
            this.aE = getIntent().getBooleanExtra("key_should_compress", false);
            this.jdField_r_of_type_JavaLangString = getIntent().getStringExtra("key_ark_app_engine_res_dir");
          }
          this.ay = paramIntent.getBooleanExtra("PhotoConst.IS_FROM_EDIT", false);
          if (this.jdField_k_of_type_Int != 1) {
            break label2511;
          }
          paramIntent = this.jdField_c_of_type_JavaUtilArrayList.iterator();
          i2 = 0;
          i1 = 0;
          for (;;)
          {
            if (paramIntent.hasNext())
            {
              localObject = (String)paramIntent.next();
              if ((this.jdField_c_of_type_JavaUtilHashMap.containsKey(localObject)) && (baaf.a((LocalMediaInfo)this.jdField_c_of_type_JavaUtilHashMap.get(localObject)) == 1))
              {
                paramIntent.remove();
                i1 = 1;
                continue;
                this.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("ALBUM_NAME");
                this.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("ALBUM_ID");
                break;
                bool1 = false;
                break label1049;
                label2302:
                bool1 = false;
                break label1077;
                label2308:
                bool1 = false;
                break label1127;
                label2314:
                localObject = this.jdField_e_of_type_JavaLangString;
              }
            }
          }
        }
      }
      catch (Exception localException)
      {
        int i2;
        int i1;
        for (;;)
        {
          if (QLog.isColorLevel())
          {
            QLog.e("PhotoListActivity", 2, "submit", localException);
            continue;
            paramIntent.putExtra("UploadPhoto.key_album_id", "");
            paramIntent.putExtra("UploadPhoto.key_album_name", "");
            continue;
            label2369:
            bool1 = false;
            continue;
            label2375:
            bool1 = false;
            continue;
            if ((!this.jdField_c_of_type_JavaUtilHashMap.containsKey(localException)) && (!localException.startsWith("http://qzs.qq.com")) && (localException.toLowerCase().endsWith(".gif")))
            {
              paramIntent.remove();
              i2 = 1;
            }
          }
        }
        paramIntent = null;
        if (this.jdField_c_of_type_JavaUtilArrayList.size() > this.jdField_i_of_type_Int)
        {
          paramIntent = getResources().getString(2131629415, new Object[] { Integer.valueOf(this.jdField_i_of_type_Int) });
          this.jdField_c_of_type_JavaUtilArrayList.subList(this.jdField_i_of_type_Int, this.jdField_c_of_type_JavaUtilArrayList.size()).clear();
        }
        for (;;)
        {
          if (paramIntent != null) {
            bbmy.a(this, paramIntent, 0).b(this.jdField_o_of_type_Int);
          }
          label2511:
          if ((!this.an) && (!this.ao) && (!k())) {
            break;
          }
          jdField_x_of_type_Int = 0;
          i1 = i3;
          while (i1 < this.jdField_c_of_type_JavaUtilArrayList.size())
          {
            paramIntent = (String)this.jdField_c_of_type_JavaUtilArrayList.get(i1);
            if ((this.jdField_c_of_type_JavaUtilHashMap.containsKey(paramIntent)) && (baaf.a((LocalMediaInfo)this.jdField_c_of_type_JavaUtilHashMap.get(paramIntent)) == 1)) {
              jdField_x_of_type_Int += 1;
            }
            i1 += 1;
          }
          if (i1 != 0) {
            paramIntent = getResources().getString(2131629420);
          } else if (i2 != 0) {
            paramIntent = getResources().getString(2131629419);
          }
        }
      }
    }
  }
  
  public void a(SlideItemInfo paramSlideItemInfo)
  {
    Object localObject1;
    int i1;
    if ((this.jdField_a_of_type_Agbx != null) && (paramSlideItemInfo != null))
    {
      localObject1 = this.jdField_a_of_type_Agbx.a();
      i1 = 0;
      if (i1 >= ((List)localObject1).size()) {
        break label523;
      }
      if (!((LocalMediaInfo)((List)localObject1).get(i1)).path.equals(paramSlideItemInfo.jdField_b_of_type_JavaLangString)) {
        break label369;
      }
    }
    for (;;)
    {
      if ((i1 >= 0) && (i1 < ((List)localObject1).size()))
      {
        paramSlideItemInfo = this.jdField_a_of_type_Agbx.a(i1);
        paramSlideItemInfo.selectStatus = 2;
        localObject1 = paramSlideItemInfo.path;
        localObject2 = agaq.a(paramSlideItemInfo.mMimeType);
        if ((this.K) && (localObject2 != null) && ("video".equals(localObject2[0])))
        {
          this.jdField_q_of_type_Int -= 1;
          jdField_x_of_type_Int -= 1;
          if (this.jdField_q_of_type_Int == 1) {
            this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = paramSlideItemInfo;
          }
          if (jdField_x_of_type_Int < 0) {
            jdField_x_of_type_Int = 0;
          }
        }
        if ((!TextUtils.isEmpty(paramSlideItemInfo.mMimeType)) && ("image/gif".equals(paramSlideItemInfo.mMimeType))) {
          this.jdField_r_of_type_Int -= 1;
        }
        this.jdField_c_of_type_JavaUtilArrayList.remove(localObject1);
        this.jdField_d_of_type_JavaUtilArrayList.remove(paramSlideItemInfo.position);
        this.jdField_d_of_type_JavaUtilHashMap.remove(localObject1);
        if ((this.ar) || (this.an) || (this.ao) || (this.aB) || (k())) {
          this.jdField_c_of_type_JavaUtilHashMap.remove(localObject1);
        }
        ageh.a(getIntent(), "param_cancelSelNum");
        localObject2 = (HashMap)baaf.jdField_b_of_type_JavaUtilHashMap.get(this.jdField_b_of_type_JavaLangString);
        if (localObject2 != null) {
          ((HashMap)localObject2).remove(localObject1);
        }
        localObject2 = baaf.jdField_c_of_type_JavaUtilHashMap;
        if (((HashMap)localObject2).containsKey(localObject1)) {
          ((HashMap)localObject2).remove(localObject1);
        }
        if (this.jdField_a_of_type_Agcb != null) {
          this.jdField_a_of_type_Agcb.a(false, paramSlideItemInfo);
        }
        a(i1, false);
        g();
        vhg.a().b(this.jdField_c_of_type_JavaUtilArrayList, jdField_a_of_type_JavaUtilHashMap);
      }
      label369:
      while (i1 != -1)
      {
        Object localObject2;
        return;
        i1 += 1;
        break;
      }
      this.jdField_c_of_type_JavaUtilArrayList.remove(paramSlideItemInfo.jdField_b_of_type_JavaLangString);
      if ((this.ar) || (this.an) || (this.ao) || (this.aB) || (k())) {
        this.jdField_c_of_type_JavaUtilHashMap.remove(paramSlideItemInfo.jdField_b_of_type_JavaLangString);
      }
      ageh.a(getIntent(), "param_cancelSelNum");
      localObject1 = (HashMap)baaf.jdField_b_of_type_JavaUtilHashMap.get(this.jdField_b_of_type_JavaLangString);
      if (localObject1 != null) {
        ((HashMap)localObject1).remove(paramSlideItemInfo.jdField_b_of_type_JavaLangString);
      }
      localObject1 = baaf.jdField_c_of_type_JavaUtilHashMap;
      if (((HashMap)localObject1).containsKey(paramSlideItemInfo.jdField_b_of_type_JavaLangString)) {
        ((HashMap)localObject1).remove(paramSlideItemInfo.jdField_b_of_type_JavaLangString);
      }
      o();
      g();
      vhg.a().b(this.jdField_c_of_type_JavaUtilArrayList, jdField_a_of_type_JavaUtilHashMap);
      return;
      label523:
      i1 = -1;
    }
  }
  
  public void a(LocalMediaInfo paramLocalMediaInfo, int paramInt)
  {
    baaf.a();
    String str = paramLocalMediaInfo.path;
    Intent localIntent = getIntent();
    if (this.Q)
    {
      localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", str);
      super.setResult(-1, localIntent);
      super.finish();
      baaf.a(this, false, false);
      return;
    }
    localIntent.putExtra("ALBUM_NAME", this.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("ALBUM_ID", this.jdField_b_of_type_JavaLangString);
    localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
    localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.jdField_c_of_type_JavaUtilArrayList);
    localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", str);
    localIntent.putExtra("media_info", paramLocalMediaInfo);
    localIntent.putExtra("PhotoConst.IS_OVERLOAD", this.jdField_y_of_type_Boolean);
    if (localIntent.getBooleanExtra("PhotoConst.MULTI_PREVIEW_IN_SINGLE_MODE", false))
    {
      localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.jdField_b_of_type_JavaUtilArrayList);
      localIntent.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", paramInt);
    }
    if (this.jdField_r_of_type_Boolean)
    {
      paramLocalMediaInfo = baaf.jdField_c_of_type_JavaUtilHashMap;
      if (!paramLocalMediaInfo.containsKey(str)) {
        paramLocalMediaInfo.put(str, new Pair(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString));
      }
      b(str);
      PhotoUtils.a(this, localIntent, this.jdField_c_of_type_JavaUtilArrayList, 0, this.jdField_d_of_type_Boolean);
      return;
    }
    if (!this.jdField_s_of_type_Boolean)
    {
      localIntent.putExtra("PhotoConst.ALLOW_LOCK", false);
      localIntent.setClass(this, PhotoPreviewActivity.class);
      localIntent.putExtra("PhotoConst.IS_JUMPTO_TROOP_ALBUM", this.F);
      localIntent.putExtra("PasterConstants.pasters_data", this.jdField_f_of_type_JavaUtilHashMap);
      if (this.ao) {
        localIntent.putExtra("PhotoConst.IS_FROM_SHUOSHUO", this.ao);
      }
      localIntent.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
      localIntent.putExtra("PhotoConst.SOURCE_FROM", "FROM_SELECT_PHOTO");
      localIntent.addFlags(603979776);
      paramLocalMediaInfo = getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
      if (ReadInJoyUploadAvatarActivity.class.getName().equals(paramLocalMediaInfo)) {
        break label582;
      }
      startActivity(localIntent);
      finish();
    }
    for (;;)
    {
      baaf.a(this, true, true);
      return;
      paramInt = localIntent.getIntExtra("Business_Origin", 0);
      if ((100 == paramInt) || (102 == paramInt) || (103 == paramInt)) {
        if (100 == paramInt)
        {
          int i1 = azyk.b(this);
          localIntent.putExtra("PhotoConst.CLIP_WIDTH", i1);
          localIntent.putExtra("PhotoConst.CLIP_HEIGHT", i1);
          localIntent.putExtra("PhotoConst.TARGET_WIDTH", 1080);
          localIntent.putExtra("PhotoConst.TARGET_HEIGHT", 1080);
          localIntent.putExtra("PhotoConst.TARGET_SAMPLE_SIZE", 1620);
          label475:
          localIntent.setClass(this, PhotoCropForPortraitActivity.class);
          localIntent.putExtra("PhotoConst.EDIT_MASK_SHAPE_TYPE", ageu.c(paramInt));
        }
      }
      for (;;)
      {
        baaf.a(localIntent, this.jdField_b_of_type_JavaLangString, str, this.jdField_v_of_type_Boolean);
        localIntent.putExtra("PHOTOLIST_START_POSITION", this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition());
        break;
        localIntent.putExtra("PhotoConst.IS_WITH_PENDANT", false);
        localIntent.putExtra("PhotoConst.TARGET_WIDTH", 640);
        localIntent.putExtra("PhotoConst.TARGET_HEIGHT", 640);
        break label475;
        localIntent.setClass(this, PhotoCropActivity.class);
      }
      label582:
      startActivityForResult(localIntent, 100014);
    }
  }
  
  public void a(String paramString)
  {
    int i1 = 0;
    Intent localIntent = getIntent();
    localIntent.putExtra("ALBUM_NAME", this.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("ALBUM_ID", this.jdField_b_of_type_JavaLangString);
    localIntent.putExtra("PhotoConst.IS_OVERLOAD", false);
    localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.jdField_c_of_type_JavaUtilArrayList);
    localIntent.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.jdField_c_of_type_JavaUtilArrayList);
    int i2 = this.jdField_c_of_type_JavaUtilArrayList.size();
    Object localObject = new ArrayList(i2);
    while (i1 < i2)
    {
      ((ArrayList)localObject).add(Integer.valueOf(i1));
      i1 += 1;
    }
    localIntent.putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", (ArrayList)localObject);
    i1 = this.jdField_c_of_type_JavaUtilArrayList.indexOf(paramString);
    if ((i1 > 0) && (i1 < this.jdField_a_of_type_Agbx.getCount()))
    {
      localObject = this.jdField_a_of_type_Agbx.a(i1);
      if ((localObject != null) && (!this.jdField_c_of_type_JavaUtilHashMap.containsKey(((LocalMediaInfo)localObject).path))) {
        this.jdField_c_of_type_JavaUtilHashMap.put(((LocalMediaInfo)localObject).path, localObject);
      }
    }
    localIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", this.jdField_c_of_type_JavaUtilHashMap);
    localIntent.putExtra("PhotoConst.SHOW_ALBUM", true);
    localIntent.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
    jdField_n_of_type_Int = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition();
    localIntent.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", this.jdField_c_of_type_JavaUtilArrayList.indexOf(paramString));
    localIntent.setClass(this, PhotoPreviewActivity.class);
    localIntent.addFlags(603979776);
    if ((this.aj) || (this.ak) || (this.am)) {
      b(localIntent);
    }
    for (;;)
    {
      baaf.a(this, true, true);
      return;
      localIntent.putExtra("PhotoConst.IS_FROM_QQSTORY_SLIDESHOW_PREVIEW", true);
      startActivity(localIntent);
    }
  }
  
  void a(boolean paramBoolean)
  {
    baaf.a();
    Intent localIntent = getIntent();
    localIntent.putExtra("PhotoConst.SHOW_ALBUM", false);
    if (!paramBoolean)
    {
      localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.jdField_c_of_type_JavaUtilArrayList);
      if ((this.jdField_c_of_type_JavaUtilArrayList != null) && (this.jdField_c_of_type_JavaUtilArrayList.size() > 0)) {
        awqx.b(null, "CliOper", "", this.jdField_e_of_type_JavaLangString, "0X8004072", "0X8004072", 0, this.jdField_c_of_type_JavaUtilArrayList.size(), 0, "", "", "", "");
      }
      if ((this.jdField_b_of_type_JavaUtilHashMap == null) || (this.jdField_b_of_type_JavaUtilHashMap.size() <= 0)) {
        break label455;
      }
      localIntent.putExtra("PhotoConst.PHOTO_INFOS", this.jdField_b_of_type_JavaUtilHashMap);
      localIntent.putExtra("PhotoConst.PHOTO_PATHS_FROM_QZONEALBUM", getIntent().getSerializableExtra("PhotoConst.PHOTO_PATHS_FROM_QZONEALBUM"));
      localIntent.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", 0);
      localIntent.putExtra("PhotoConst.USE_URL_PATH", true);
      localIntent.putExtra("PhotoConst.QZONE_ALBUM_FROM_AIO", getIntent().getBooleanExtra("PhotoConst.QZONE_ALBUM_FROM_AIO", false));
      label170:
      if (this.ar)
      {
        localIntent.putExtra("key_pic_to_edit_from", 2);
        localIntent.putExtra("fromPhotoListPanel", this.ar);
      }
      if ((this.ar) || (this.an) || (this.ao) || (this.aB))
      {
        localIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", this.jdField_c_of_type_JavaUtilHashMap);
        localIntent.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", 0);
      }
      localIntent.putExtra("PhotoConst.IS_FROM_MINI_APP", this.az);
      localIntent.putExtra("ALBUM_NAME", this.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("ALBUM_ID", this.jdField_b_of_type_JavaLangString);
      localIntent.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
      localIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.jdField_m_of_type_Int);
      localIntent.putExtra("readSource", this.jdField_n_of_type_JavaLangString);
      localIntent.putExtra("PasterConstants.pasters_data", this.jdField_f_of_type_JavaUtilHashMap);
      localIntent.putExtra("PhotoConst.IS_JUMPTO_TROOP_ALBUM", this.F);
      localIntent.putExtra("from_qzone", this.av);
      localIntent.putExtra("p_e_s_type", 3);
      jdField_n_of_type_Int = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition();
      localIntent.setClass(this, PhotoPreviewActivity.class);
      localIntent.addFlags(603979776);
      if (this.ao) {
        localIntent.putExtra("PhotoConst.IS_FROM_SHUOSHUO", this.ao);
      }
      if (!this.L) {
        break label467;
      }
      localIntent.putExtra("from_health", true);
      startActivityForResult(localIntent, 100010);
    }
    for (;;)
    {
      baaf.a(this, true, true);
      return;
      localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", this.jdField_m_of_type_JavaLangString);
      break;
      label455:
      localIntent.putExtra("PhotoConst.USE_URL_PATH", false);
      break label170;
      label467:
      if ((this.aj) || (this.ak) || (this.am))
      {
        b(localIntent);
      }
      else if (this.jdField_k_of_type_Int == 1)
      {
        abju.a(this, localIntent, PublicFragmentActivityForPeak.class, QzonePhotoPreviewActivity.class);
      }
      else
      {
        startActivity(localIntent);
        super.finish();
      }
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    Object localObject1 = agaq.a(paramLocalMediaInfo.mMimeType);
    if ((!this.K) && (localObject1 != null) && (!"image".equals(localObject1[0]))) {
      return false;
    }
    int i1 = paramLocalMediaInfo.selectStatus;
    if (((i1 == 1) && (paramBoolean)) || ((i1 == 2) && (!paramBoolean))) {
      return false;
    }
    long l1;
    if ((i1 == 2) && (paramBoolean) && (this.jdField_c_of_type_JavaUtilArrayList.size() >= this.jdField_i_of_type_Int))
    {
      l1 = System.currentTimeMillis();
      if (l1 - this.jdField_a_of_type_Long >= 700L)
      {
        bbmy.a(this, a(paramLocalMediaInfo), 1000).b(this.jdField_o_of_type_Int);
        this.jdField_a_of_type_Long = l1;
        this.Y = true;
        k();
      }
      return false;
    }
    if ((k()) && (!biys.a(this, paramLocalMediaInfo))) {
      return false;
    }
    if ((this.aC) && (this.jdField_i_of_type_Long != -1L) && (paramBoolean))
    {
      if ((baaf.a(paramLocalMediaInfo) == 1) && (paramLocalMediaInfo.mDuration > this.jdField_c_of_type_Long))
      {
        bbmy.a(this, ajjy.a(2131642317) + this.jdField_c_of_type_Long / 1000L / 60L + ajjy.a(2131642314), 0).b(this.jdField_o_of_type_Int);
        return false;
      }
      localObject2 = this.jdField_c_of_type_JavaUtilArrayList.iterator();
      for (l1 = 0L; ((Iterator)localObject2).hasNext(); l1 = bace.a((String)((Iterator)localObject2).next()) + l1) {}
      if (bace.a(paramLocalMediaInfo.path) + l1 > this.jdField_i_of_type_Long * 1024L * 1024L)
      {
        localObject1 = new StringBuilder().append(ajjy.a(2131642336));
        if (this.jdField_i_of_type_Long < 1024L) {}
        for (paramLocalMediaInfo = this.jdField_i_of_type_Long + "MB";; paramLocalMediaInfo = (float)this.jdField_i_of_type_Long / 1024.0F + "G")
        {
          bbmy.a(this, paramLocalMediaInfo + ajjy.a(2131642319), 0).b(this.jdField_o_of_type_Int);
          return false;
        }
      }
    }
    if ((this.ar) && (paramBoolean))
    {
      if ((baaf.a(paramLocalMediaInfo) == 1) && ((paramLocalMediaInfo.mDuration > 1200000L) || (paramLocalMediaInfo.fileSize > this.jdField_b_of_type_Long)))
      {
        bbmy.a(this, getResources().getString(2131653672), 0).b(getResources().getDimensionPixelSize(2131167766));
        return false;
      }
      if ((this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) && (baaf.a(paramLocalMediaInfo) == 1) && (paramLocalMediaInfo.fileSize > 104345600L))
      {
        bbmy.a(this, getResources().getString(2131653694), 0).b(getResources().getDimensionPixelSize(2131167766));
        baaf.d();
      }
    }
    this.Y = false;
    Object localObject2 = paramLocalMediaInfo.path;
    PresendPicMgr.a();
    if (paramBoolean)
    {
      if ((this.K) && (localObject1 != null) && ("video".equals(localObject1[0])))
      {
        if (!baaf.a(this, jdField_x_of_type_Int, paramLocalMediaInfo, this.ao)) {
          return false;
        }
        this.jdField_q_of_type_Int += 1;
        jdField_x_of_type_Int += 1;
        if (this.jdField_q_of_type_Int == 1) {
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = paramLocalMediaInfo;
        }
      }
      if ((!TextUtils.isEmpty(paramLocalMediaInfo.mMimeType)) && ("image/gif".equals(paramLocalMediaInfo.mMimeType))) {
        this.jdField_r_of_type_Int += 1;
      }
      this.jdField_c_of_type_JavaUtilArrayList.add(localObject2);
      this.jdField_d_of_type_JavaUtilArrayList.add(paramLocalMediaInfo.position);
      this.jdField_d_of_type_JavaUtilHashMap.put(localObject2, Integer.valueOf(paramLocalMediaInfo.panoramaPhotoType));
      if ((this.ar) || (this.an) || (this.ao) || (this.aB) || (k())) {
        this.jdField_c_of_type_JavaUtilHashMap.put(localObject2, paramLocalMediaInfo);
      }
      if (this.jdField_b_of_type_JavaUtilHashSet.contains(localObject2)) {
        this.jdField_b_of_type_JavaUtilHashSet.remove(localObject2);
      }
      this.jdField_a_of_type_JavaUtilHashSet.add(localObject2);
      ageh.a(getIntent(), "param_totalSelNum");
      localObject1 = getIntent();
      if (!((Intent)localObject1).hasExtra("param_initTime")) {
        ((Intent)localObject1).putExtra("param_initTime", System.currentTimeMillis());
      }
      paramLocalMediaInfo.selectStatus = 1;
      localObject1 = (LinkedHashMap)baaf.jdField_b_of_type_JavaUtilHashMap.get(this.jdField_b_of_type_JavaLangString);
      paramLocalMediaInfo = (LocalMediaInfo)localObject1;
      if (localObject1 == null)
      {
        paramLocalMediaInfo = new LinkedHashMap();
        baaf.jdField_b_of_type_JavaUtilHashMap.put(this.jdField_b_of_type_JavaLangString, paramLocalMediaInfo);
      }
      paramLocalMediaInfo.put(localObject2, Integer.valueOf(this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition()));
      paramLocalMediaInfo = baaf.jdField_c_of_type_JavaUtilHashMap;
      if (!paramLocalMediaInfo.containsKey(localObject2)) {
        paramLocalMediaInfo.put(localObject2, new Pair(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString));
      }
      paramBoolean = i();
      if (this.jdField_b_of_type_AndroidWidgetCheckBox != null) {
        this.jdField_b_of_type_AndroidWidgetCheckBox.setChecked(paramBoolean);
      }
      return true;
    }
    if ((this.K) && (localObject1 != null) && ("video".equals(localObject1[0])))
    {
      this.jdField_q_of_type_Int -= 1;
      jdField_x_of_type_Int -= 1;
      if (this.jdField_q_of_type_Int == 1) {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = paramLocalMediaInfo;
      }
      if (jdField_x_of_type_Int < 0) {
        jdField_x_of_type_Int = 0;
      }
    }
    if ((!TextUtils.isEmpty(paramLocalMediaInfo.mMimeType)) && ("image/gif".equals(paramLocalMediaInfo.mMimeType))) {
      this.jdField_r_of_type_Int -= 1;
    }
    this.jdField_c_of_type_JavaUtilArrayList.remove(paramLocalMediaInfo.path);
    this.jdField_d_of_type_JavaUtilArrayList.remove(paramLocalMediaInfo.position);
    this.jdField_d_of_type_JavaUtilHashMap.remove(localObject2);
    if ((this.ar) || (this.an) || (this.ao) || (k())) {
      this.jdField_c_of_type_JavaUtilHashMap.remove(localObject2);
    }
    if (this.jdField_a_of_type_JavaUtilHashSet.contains(paramLocalMediaInfo.path)) {
      this.jdField_a_of_type_JavaUtilHashSet.remove(paramLocalMediaInfo.path);
    }
    for (;;)
    {
      paramLocalMediaInfo.selectStatus = 2;
      ageh.a(getIntent(), "param_cancelSelNum");
      paramLocalMediaInfo = (HashMap)baaf.jdField_b_of_type_JavaUtilHashMap.get(this.jdField_b_of_type_JavaLangString);
      if (paramLocalMediaInfo != null) {
        paramLocalMediaInfo.remove(localObject2);
      }
      paramLocalMediaInfo = baaf.jdField_c_of_type_JavaUtilHashMap;
      if (!paramLocalMediaInfo.containsKey(localObject2)) {
        break;
      }
      paramLocalMediaInfo.remove(localObject2);
      break;
      this.jdField_b_of_type_JavaUtilHashSet.add(paramLocalMediaInfo.path);
    }
  }
  
  void b()
  {
    Object localObject = (RelativeLayout)findViewById(2131309736);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      ((RelativeLayout)localObject).setFitsSystemWindows(true);
      ((RelativeLayout)localObject).setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302804));
    this.jdField_e_of_type_AndroidWidgetTextView.setContentDescription(ajjy.a(2131642291));
    this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302832));
    this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
    label166:
    int i1;
    if ((l()) || (this.ay))
    {
      this.jdField_f_of_type_AndroidWidgetTextView.setText(ajjy.a(2131642331));
      this.jdField_f_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302847));
      this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302860));
      if (this.jdField_a_of_type_JavaLangString == null) {
        break label892;
      }
      localObject = this.jdField_a_of_type_JavaLangString;
      setTitle((CharSequence)localObject);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131304039));
      this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131307749));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131307755));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131307750));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302321));
      h();
      this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131306214));
      this.jdField_c_of_type_AndroidWidgetButton = ((Button)findViewById(2131310076));
      this.jdField_a_of_type_AndroidViewView = findViewById(2131311730);
      this.jdField_b_of_type_AndroidViewView = findViewById(2131301568);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131312878));
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView = ((GestureSelectGridView)findViewById(2131305818));
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setScrollBarStyle(0);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setNumColumns(3);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setColumnWidth(this.jdField_b_of_type_Int);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setHorizontalSpacing(this.jdField_d_of_type_Int);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setVerticalSpacing(this.jdField_e_of_type_Int);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setPadding(this.jdField_f_of_type_Int, this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getPaddingTop(), this.jdField_f_of_type_Int, this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getPaddingBottom());
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setOnItemClickListener(this.jdField_a_of_type_Behi);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setOnIndexChangedListener(this.jdField_a_of_type_Bejw);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setMaximumVelocity((int)(2500.0F * getResources().getDisplayMetrics().density));
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setOnScrollListener(new agbl(this));
      this.jdField_a_of_type_Agbx = new agbx(this);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setAdapter(this.jdField_a_of_type_Agbx);
      String str = this.jdField_h_of_type_JavaLangString;
      localObject = str;
      if (TextUtils.isEmpty(str))
      {
        if ((!this.F) && (!this.ag)) {
          break label914;
        }
        localObject = getString(2131629467);
      }
      label519:
      this.jdField_c_of_type_AndroidWidgetButton.setText((CharSequence)localObject);
      localObject = this.jdField_a_of_type_AndroidViewView;
      if ((!this.jdField_j_of_type_Boolean) && (this.jdField_h_of_type_Int != 2) && (!k())) {
        break label984;
      }
      i1 = 8;
      label557:
      ((View)localObject).setVisibility(i1);
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
      if (!this.jdField_n_of_type_Boolean) {
        break label1000;
      }
      if (this.jdField_l_of_type_Int != 9501) {
        break label989;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      label604:
      this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    }
    for (;;)
    {
      if (this.jdField_o_of_type_Boolean) {
        this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
      }
      g();
      if (k())
      {
        this.jdField_a_of_type_Vhk = new vhk(this, this);
        if (getIntent().getIntExtra("qq_sub_business_id", -1) == 3)
        {
          vhg.a().c(22);
          vhg.a().b(14);
          vhg.a().e();
        }
        vhg.a().a(this.jdField_a_of_type_Vhk);
        vhg.a().a(this);
        l();
        if (getIntent().getBooleanExtra("report_first_exposure", true))
        {
          localObject = (vhn)QQStoryContext.a().getBusinessHandler(1);
          if (localObject != null) {
            ((vhn)localObject).a();
          }
          getIntent().putExtra("report_first_exposure", false);
          if (this.P) {
            urp.a("video_edit", "exp_slides", 0, 0, new String[0]);
          }
        }
      }
      if (this.M) {
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      if (this.X)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoListActivity", 2, "ArkApp ark app res:" + this.jdField_p_of_type_JavaLangString);
        }
        this.jdField_b_of_type_AndroidWidgetButton.setVisibility(4);
      }
      return;
      this.jdField_f_of_type_AndroidWidgetTextView.setText(ajjy.a(2131642292));
      break;
      label892:
      if (this.jdField_h_of_type_Int == 2)
      {
        localObject = baae.jdField_m_of_type_JavaLangString;
        break label166;
      }
      localObject = baae.jdField_l_of_type_JavaLangString;
      break label166;
      label914:
      if (1 == this.jdField_k_of_type_Int)
      {
        localObject = getString(2131629425);
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetTextView.setText(getString(2131629437));
        break label519;
      }
      if (this.jdField_n_of_type_Boolean)
      {
        localObject = getString(2131629465);
        break label519;
      }
      localObject = getString(2131629407);
      break label519;
      label984:
      i1 = 0;
      break label557;
      label989:
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      break label604;
      label1000:
      if (this.jdField_q_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      }
    }
  }
  
  public void b(String paramString)
  {
    if (this.jdField_v_of_type_Boolean)
    {
      baaf.jdField_a_of_type_Long = System.currentTimeMillis();
      baaf.jdField_a_of_type_JavaUtilHashMap.put(this.jdField_b_of_type_JavaLangString, Integer.valueOf(this.jdField_a_of_type_Agbx.getCount()));
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
  
  boolean b()
  {
    if (c()) {
      if (QzoneConfig.getInstance().getConfig("PhotoUpload", "C2CAioRememberState", 0) != 1) {}
    }
    while (QzoneConfig.getInstance().getConfig("PhotoUpload", "QunAioRememberUpload", 1) != 0)
    {
      return true;
      return false;
    }
    return false;
  }
  
  void d()
  {
    Object localObject2 = null;
    Intent localIntent = getIntent();
    localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.jdField_c_of_type_JavaUtilArrayList);
    Object localObject3;
    String str;
    if ((this.ar) || (this.an) || (this.ao) || (this.aB))
    {
      localObject3 = new HashMap();
      Iterator localIterator = this.jdField_c_of_type_JavaUtilArrayList.iterator();
      if (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if (jdField_a_of_type_JavaUtilHashMap == null) {
          break label589;
        }
      }
    }
    label589:
    for (Object localObject1 = (LocalMediaInfo)jdField_a_of_type_JavaUtilHashMap.get(str);; localObject1 = null)
    {
      if (localObject1 != null)
      {
        ((HashMap)localObject3).put(str, localObject1);
        break;
      }
      if (this.jdField_c_of_type_JavaUtilHashMap != null) {
        localObject1 = (LocalMediaInfo)this.jdField_c_of_type_JavaUtilHashMap.get(str);
      }
      if (localObject1 == null) {
        break;
      }
      ((HashMap)localObject3).put(str, localObject1);
      break;
      localIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", (Serializable)localObject3);
      if (this.ag) {
        awqx.b(null, "dc00898", "", "", "0X800A6DF", "0X800A6DF", 0, 0, "", "", "", "");
      }
      if (this.ar) {
        localIntent.putExtra("fromPhotoListPanel", true);
      }
      if (this.at) {
        e(localIntent);
      }
      if (this.X) {
        localIntent.putExtra("FROM_ARK_CHOOSE_IMAGE", true);
      }
      localIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.jdField_m_of_type_Int);
      localIntent.putExtra("PhotoConst.IS_SHOW_QZONE_ALBUM", this.jdField_m_of_type_Boolean);
      localIntent.putExtra("PhotoConst.PHOTO_INFOS", this.jdField_b_of_type_JavaUtilHashMap);
      localIntent.putExtra("PhotoConst.QZONE_ALBUM_NUM", jdField_f_of_type_Long);
      if (this.av)
      {
        localIntent.putExtra("PhotoConst.IS_FROM_QZONE_AND_NEED_FILTER_RECENT_IMAGES", true);
        localIntent.putExtra("PhotoConst.RECENT_IMAGES_MAX_COUNT", QzoneConfig.getInstance().getConfig("PhotoAlbum", "MaxRecentPhotoNum", 200));
        localIntent.putExtra("PhotoConst.RECENT_IMAGES_LIMIT_SIZE", QzoneConfig.getInstance().getConfig("PhotoAlbum", "RecentPhotoLimitSize", 20480));
        localIntent.putExtra("PhotoConst.RECENT_IMAGES_LIMIT_WIDTH", QzoneConfig.getInstance().getConfig("PhotoAlbum", "RecentPhotoLimitWidth", 100));
        localObject3 = QzoneConfig.getInstance().getConfig("PhotoAlbum", "RecentPhotoBlockPaths", "MagazineUnlock");
        localObject1 = localObject2;
        if (localObject3 != null) {
          localObject1 = a((String)localObject3);
        }
        localIntent.putStringArrayListExtra("PhotoConst.RECENT_IMAGES_BLOCK_PATHS", (ArrayList)localObject1);
        localIntent.putExtra("from_qzone", this.av);
      }
      localIntent.putExtra("PhotoConst.IS_FROM_QQSTORY_SLIDESHOW", k());
      localIntent.putExtra("from_qqstory_custom_data", l());
      localIntent.putExtra("from_qqstory_entrance", this.S);
      localIntent.putExtra("peak.myUin", this.jdField_e_of_type_JavaLangString);
      localIntent.setClass(this, AlbumListActivity.class);
      localIntent.addFlags(603979776);
      if ((this.L) || (this.M))
      {
        localIntent.putExtra("key_is_for_health", true);
        startActivityForResult(localIntent, 100009);
      }
      for (;;)
      {
        baaf.a(this, true, false);
        return;
        if ((this.O) || (this.aj) || (this.ak) || (this.ai) || (this.N))
        {
          startActivityForResult(localIntent, 100009);
        }
        else
        {
          startActivity(localIntent);
          super.finish();
        }
      }
    }
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
        QLog.e("PhotoListActivity", 2, "show dialog error", localException);
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
      QLog.e("PhotoListActivity", 2, "cancel dialog error", localIllegalArgumentException);
    }
  }
  
  public void finish()
  {
    super.finish();
  }
  
  public void g()
  {
    boolean bool1;
    Object localObject2;
    if (this.jdField_h_of_type_JavaLangString != null)
    {
      localObject1 = this.jdField_h_of_type_JavaLangString;
      if (1 != this.jdField_k_of_type_Int) {
        break label549;
      }
      if (this.jdField_c_of_type_JavaUtilArrayList.size() < 3) {
        break label540;
      }
      bool1 = true;
      localObject2 = localObject1;
      label38:
      if (QLog.isColorLevel()) {
        QLog.d("_photo", 2, "updateButton selectedPhotoList.size()=" + this.jdField_c_of_type_JavaUtilArrayList.size());
      }
      this.jdField_c_of_type_AndroidWidgetButton.setText((CharSequence)localObject2);
      this.jdField_c_of_type_AndroidWidgetButton.setEnabled(bool1);
      if (AppSetting.jdField_c_of_type_Boolean)
      {
        localObject1 = String.format(getString(2131626435), new Object[] { Integer.valueOf(this.jdField_c_of_type_JavaUtilArrayList.size()) });
        this.jdField_c_of_type_AndroidWidgetButton.setContentDescription((CharSequence)localObject1);
      }
      this.jdField_b_of_type_AndroidWidgetButton.setEnabled(bool1);
      if ((this.jdField_b_of_type_JavaUtilHashMap != null) && (this.jdField_b_of_type_JavaUtilHashMap.size() > 0)) {
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      }
      if (!bool1)
      {
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
        this.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(false);
        this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
        this.jdField_b_of_type_AndroidWidgetTextView.setEnabled(false);
      }
      if (!this.jdField_n_of_type_Boolean) {
        break label693;
      }
      if (bool1)
      {
        this.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(true);
        this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
        this.jdField_b_of_type_AndroidWidgetTextView.setEnabled(true);
        if ((this.jdField_b_of_type_JavaUtilHashMap == null) || (this.jdField_b_of_type_JavaUtilHashMap.size() <= 0) || (this.jdField_c_of_type_JavaUtilArrayList.size() != this.jdField_b_of_type_JavaUtilHashMap.size())) {
          break label625;
        }
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      }
    }
    for (;;)
    {
      if (this.jdField_k_of_type_Int == 1)
      {
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
      }
      if (this.jdField_o_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        if (bool1)
        {
          this.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(true);
          this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
          this.jdField_b_of_type_AndroidWidgetTextView.setEnabled(true);
        }
      }
      h();
      if (!this.jdField_p_of_type_Boolean) {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      if ((this.jdField_h_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_Agbx != null))
      {
        int i2 = this.jdField_a_of_type_Agbx.getCount();
        int i1 = i2;
        if (i2 > 0)
        {
          i1 = i2;
          if (this.jdField_a_of_type_Agbx.getItemViewType(0) == 2) {
            i1 = i2 - 1;
          }
        }
        this.jdField_h_of_type_AndroidWidgetTextView.setText(String.format(getString(2131623997), new Object[] { String.valueOf(i1) }));
      }
      return;
      if ((this.F) || (this.ag))
      {
        localObject1 = getString(2131629467);
        break;
      }
      if (1 == this.jdField_k_of_type_Int)
      {
        localObject1 = getString(2131629425);
        break;
      }
      if (this.jdField_n_of_type_Boolean)
      {
        localObject1 = getString(2131629465);
        break;
      }
      localObject1 = getString(2131629407);
      break;
      label540:
      bool1 = false;
      localObject2 = localObject1;
      break label38;
      label549:
      if (this.jdField_c_of_type_JavaUtilArrayList.size() > 0) {}
      for (bool2 = true;; bool2 = false)
      {
        localObject2 = localObject1;
        bool1 = bool2;
        if (!bool2) {
          break;
        }
        localObject2 = (String)localObject1 + "(" + this.jdField_c_of_type_JavaUtilArrayList.size() + ")";
        bool1 = bool2;
        break;
      }
      label625:
      if ((!this.ar) || (!j())) {
        break label650;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    }
    label650:
    Object localObject1 = this.jdField_a_of_type_AndroidWidgetButton;
    if ((this.jdField_c_of_type_JavaUtilArrayList.size() == 1) && (!this.F)) {}
    for (boolean bool2 = true;; bool2 = false)
    {
      ((Button)localObject1).setEnabled(bool2);
      break;
    }
    label693:
    if (this.jdField_q_of_type_Boolean) {
      if ((this.jdField_c_of_type_JavaUtilArrayList.size() == 1) && ((this.jdField_b_of_type_JavaUtilHashMap == null) || (this.jdField_b_of_type_JavaUtilHashMap.size() <= 0))) {
        if (((this.ao) || (this.an)) && (a((String)this.jdField_c_of_type_JavaUtilArrayList.get(0)))) {
          this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      break;
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      continue;
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      continue;
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    }
  }
  
  public void h()
  {
    switch (this.jdField_m_of_type_Int)
    {
    case 1: 
    default: 
      return;
    case 0: 
      this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      return;
    }
    baaf.a(this.jdField_b_of_type_AndroidWidgetTextView, this.jdField_c_of_type_JavaUtilArrayList, jdField_a_of_type_JavaUtilHashMap, this.ar, this, this.jdField_e_of_type_JavaUtilHashMap, this.jdField_c_of_type_JavaUtilHashMap);
    this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
  }
  
  public void i()
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
  
  public void j()
  {
    Object localObject;
    if (this.jdField_b_of_type_JavaLangString.equals("$RecentAlbumId"))
    {
      awrn.a(this).a(null, "sendAlbumRecent", true, 0L, 0L, null, "");
      localObject = PresendPicMgr.a();
      if ((this.jdField_b_of_type_AndroidWidgetCheckBox == null) || (!this.jdField_b_of_type_AndroidWidgetCheckBox.isChecked()) || (c())) {
        break label239;
      }
    }
    label239:
    for (boolean bool = true;; bool = false)
    {
      this.F = bool;
      if (!this.F) {
        break label244;
      }
      if (localObject != null) {
        ((PresendPicMgr)localObject).a(1007);
      }
      ageh.b(getIntent(), this.jdField_c_of_type_JavaUtilArrayList.size());
      localObject = getIntent();
      ((Intent)localObject).putExtra("open_chatfragment_fromphoto", true);
      adwz.a(this, (Intent)localObject, this.jdField_e_of_type_JavaLangString, this.jdField_j_of_type_JavaLangString, this.jdField_i_of_type_JavaLangString, this.jdField_k_of_type_JavaLangString, this.jdField_l_of_type_JavaLangString, this.jdField_m_of_type_Int, this.jdField_c_of_type_JavaUtilArrayList, 42);
      return;
      if ((this.jdField_a_of_type_JavaLangString.equalsIgnoreCase("Camera")) || (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase("camera")) || (this.jdField_a_of_type_JavaLangString.contains("Camera")) || (this.jdField_a_of_type_JavaLangString.contains("camera")))
      {
        awrn.a(this).a(null, "sendAlbumRecent", false, 0L, 0L, null, "");
        break;
      }
      awrn.a(this).a(null, "sendAlbumOther", true, 0L, 0L, null, "");
      break;
    }
    label244:
    if ((this.jdField_q_of_type_Boolean) && ((!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) || (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))))
    {
      this.jdField_a_of_type_AndroidWidgetButton.performClick();
      return;
    }
    if ((this.W) && (this.jdField_b_of_type_JavaUtilHashMap != null) && (this.jdField_b_of_type_JavaUtilHashMap.size() > 0))
    {
      a(getIntent(), true);
      return;
    }
    if (this.jdField_c_of_type_JavaUtilArrayList != null)
    {
      ageh.a(getIntent(), this.jdField_c_of_type_JavaUtilArrayList.size());
      ageh.a(getIntent(), this.jdField_c_of_type_JavaUtilArrayList.size(), this.jdField_m_of_type_Int);
    }
    Intent localIntent = getIntent();
    if (this.ah)
    {
      FavEmosmManageActivity.a(this, this.jdField_c_of_type_JavaUtilArrayList);
      super.finish();
      baaf.a(this, false, false);
      return;
    }
    if (this.ag) {
      if (this.ag) {
        if (this.jdField_c_of_type_JavaUtilArrayList == null) {
          break label954;
        }
      }
    }
    label794:
    label935:
    label941:
    label954:
    for (int i1 = this.jdField_c_of_type_JavaUtilArrayList.size();; i1 = 0)
    {
      awqx.b(null, "CliOper", "", "", "0X800A6D8", "0X800A6D8", 0, 0, String.valueOf(i1), "", "", "");
      localObject = new Intent();
      ((Intent)localObject).putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.jdField_c_of_type_JavaUtilArrayList);
      super.setResult(-1, (Intent)localObject);
      super.finish();
      baaf.a(this, false, false);
      return;
      if (this.jdField_m_of_type_Int == 2)
      {
        if (localObject != null)
        {
          ((PresendPicMgr)localObject).a(1008);
          ((PresendPicMgr)localObject).a();
        }
        awqx.b(null, "CliOper", "", "", "0X8005148", "0X8005148", 0, 0, "", "", "", "");
        localObject = localIntent.getStringExtra("PhotoConst.PLUGIN_APK");
        String str = localIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
        if (("qzone_plugin.apk".equals(localObject)) && ("com.qzone.video.activity.TrimVideoActivity".equals(str)))
        {
          localIntent.putExtra("PhotoConst.PLUGIN_NAME", "QZone");
          localIntent.putExtra("PhotoConst.PLUGIN_APK", "qzone_plugin.apk");
          localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
          localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", "com.qzone.publish.ui.activity.QZonePublishMoodRealActivity");
        }
        if ("qzone_plugin.apk".equals(localObject)) {
          localIntent.putExtra("isEmbedInTabActivity", getIntent().getBooleanExtra("isEmbedInTabActivity", false));
        }
        if ((this.ar) || (this.an) || ((this.ao) && (jdField_a_of_type_Boolean)) || (this.aq) || (this.aB)) {
          localIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", this.jdField_c_of_type_JavaUtilHashMap);
        }
        if (this.at) {
          e(localIntent);
        }
        if (this.jdField_c_of_type_JavaUtilArrayList != null) {
          ahji.a(this.jdField_c_of_type_JavaUtilArrayList);
        }
        d(localIntent);
        localIntent.putExtra("PhotoConst.PANORAMA_IMAGES", this.jdField_d_of_type_JavaUtilHashMap);
        if ((c()) && (this.jdField_b_of_type_AndroidWidgetCheckBox != null) && (this.jdField_b_of_type_AndroidWidgetCheckBox.isChecked()))
        {
          localIntent.putExtra("key_is_sync_qzone", 1);
          if (this.jdField_k_of_type_JavaLangString == null) {
            break label935;
          }
          localObject = this.jdField_k_of_type_JavaLangString;
          localIntent.putExtra("key_qzone_album_id", (String)localObject);
          localIntent.putExtra("key_qzone_batch_id", PhotoUtils.a());
          if (this.jdField_c_of_type_JavaUtilArrayList != null) {
            localIntent.putExtra("PhotoConst.PHOTO_COUNT", this.jdField_c_of_type_JavaUtilArrayList.size());
          }
          localObject = new LpReportInfo_pf00064(723, 2, 5);
          LpReportManager.getInstance().reportToPF00064((LpReportInfo_pf00064)localObject, false, false);
          bgcj.a(8);
          a("aio_sync_qzone", "operation_type", "photo_list_upload");
        }
        if (1 != this.jdField_k_of_type_Int) {
          break label941;
        }
        localIntent.putExtra("PhotoConst.KEY_SHOW_TYPE", 1);
        localIntent.putExtra("PhotoConst.KEY_SHOW_ORIGIN_TYPE", 1);
      }
      for (;;)
      {
        a(localIntent, false);
        return;
        if ((localObject == null) || (this.aw)) {
          break;
        }
        ((PresendPicMgr)localObject).a(localIntent);
        break;
        localObject = "";
        break label794;
        localIntent.putExtra("PhotoConst.KEY_SHOW_TYPE", 0);
      }
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i1 = 1;
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((QLog.isDevelopLevel()) && (this.jdField_c_of_type_JavaUtilArrayList != null) && (this.jdField_c_of_type_JavaUtilArrayList.size() != 0)) {
      QLog.d("PhotoListActivity", 4, "[PhotoListActivity] [onActivityResult] selectedPhotoList = " + this.jdField_c_of_type_JavaUtilArrayList.size());
    }
    if ((this.z) && (paramIntent != null) && ((paramInt1 == 100) || (paramInt1 == 100009)) && (paramInt2 == -1))
    {
      this.jdField_b_of_type_AndroidWidgetCheckBox.setChecked(true);
      if (!TextUtils.isEmpty(this.jdField_k_of_type_JavaLangString))
      {
        bfpr.a(this.jdField_e_of_type_JavaLangString, this.jdField_j_of_type_JavaLangString, this.jdField_k_of_type_JavaLangString, this.jdField_l_of_type_JavaLangString);
        bfpr.a(this.jdField_e_of_type_JavaLangString, this.jdField_k_of_type_JavaLangString, this.jdField_k_of_type_JavaLangString, this.jdField_l_of_type_JavaLangString, true);
      }
      return;
    }
    if (((this.O) || (this.P) || (this.am)) && (paramInt2 == -1) && (paramInt1 != 24747))
    {
      setResult(paramInt2, paramIntent);
      finish();
      return;
    }
    if ((this.O) && (paramInt1 == 2) && (paramInt2 == -1))
    {
      setResult(paramInt2, paramIntent);
      finish();
      return;
    }
    Object localObject;
    if (paramInt2 == -1)
    {
      switch (paramInt1)
      {
      }
      for (;;)
      {
        if ((!this.ak) && (!this.N) && (!this.ai)) {
          break label775;
        }
        super.setResult(-1, paramIntent);
        super.finish();
        return;
        setResult(-1, paramIntent);
        finish();
        continue;
        paramIntent = PresendPicMgr.a();
        if (paramIntent != null) {
          paramIntent.a(this.jdField_m_of_type_JavaLangString, 1008);
        }
        a(true);
        return;
        paramIntent = new Intent();
        paramIntent.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.jdField_c_of_type_JavaUtilArrayList);
        paramIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.jdField_m_of_type_Int);
        setResult(-1, paramIntent);
        super.finish();
        return;
        if (paramIntent == null) {
          break;
        }
        this.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("ALBUM_NAME");
        this.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("ALBUM_ID");
        this.jdField_m_of_type_Int = paramIntent.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
        if (this.jdField_a_of_type_JavaLangString != null) {}
        for (localObject = this.jdField_a_of_type_JavaLangString;; localObject = baae.jdField_l_of_type_JavaLangString)
        {
          setTitle((CharSequence)localObject);
          runOnUiThread(new PhotoListActivity.3(this));
          break;
        }
        if (paramIntent == null) {
          break;
        }
        this.jdField_c_of_type_JavaUtilArrayList = paramIntent.getStringArrayListExtra("img_list");
        if (this.L)
        {
          paramIntent = new Intent();
          paramIntent.putStringArrayListExtra("img_list", this.jdField_c_of_type_JavaUtilArrayList);
          super.setResult(-1, paramIntent);
          super.finish();
          return;
          if (this.M)
          {
            super.setResult(-1, paramIntent);
            super.finish();
            continue;
            if (this.aj)
            {
              super.setResult(-1, paramIntent);
              super.finish();
              continue;
              if (this.ah)
              {
                localObject = paramIntent.getStringArrayListExtra("PhotoConst.SELECTED_PATHS");
                if ((localObject == null) || (((ArrayList)localObject).size() <= 0)) {
                  break label657;
                }
                FavEmosmManageActivity.a(this, (ArrayList)localObject);
              }
              for (;;)
              {
                super.finish();
                if (!this.ag) {
                  break;
                }
                setResult(-1, paramIntent);
                super.finish();
                break;
                label657:
                FavEmosmManageActivity.a(this, this.jdField_c_of_type_JavaUtilArrayList);
              }
              vhg.a().a(paramIntent, this.jdField_c_of_type_JavaUtilHashMap);
            }
          }
        }
      }
    }
    if (paramInt1 == 17)
    {
      if ((this.N) && (paramIntent != null) && (!paramIntent.getBooleanExtra("INTENT_VALUE_CANCEL_IN_PREVIEW_ACTIVITY", false)))
      {
        super.setResult(0, paramIntent);
        super.finish();
      }
      baaf.jdField_a_of_type_Long = 0L;
      return;
    }
    if (paramInt1 == 10002) {
      if ((this.P) && (paramIntent != null))
      {
        localObject = paramIntent.getStringExtra("PhotoConst.FROM_QQSTORY_SLIDESHOW_DATA");
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          bace.a(new File((String)localObject).getParent());
        }
      }
    }
    for (;;)
    {
      label775:
      PhotoUtils.a(this, paramInt1, paramInt2, paramIntent, this.jdField_t_of_type_Boolean, this.jdField_e_of_type_JavaLangString);
      return;
      if (paramInt1 == 10012)
      {
        if ((this.aj) && (paramIntent != null))
        {
          localObject = paramIntent.getStringExtra("PhotoConst.FROM_QQSTORY_SLIDESHOW_DATA");
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            bace.a(new File((String)localObject).getParent());
          }
        }
      }
      else if (paramInt1 == 10001)
      {
        if ((this.am) && (paramIntent != null))
        {
          localObject = paramIntent.getStringExtra("PhotoConst.FROM_QQSTORY_SLIDESHOW_DATA");
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            bace.a(new File((String)localObject).getParent());
          }
          super.setResult(0, paramIntent);
          super.finish();
        }
      }
      else if (paramInt1 == 100010)
      {
        if (k()) {
          if (this.ax) {
            runOnUiThread(new PhotoListActivity.4(this));
          } else {
            this.ax = true;
          }
        }
      }
      else if (paramInt1 == 10023)
      {
        if ((paramIntent != null) && (paramIntent.getBooleanExtra("key_edit_to_photo_list", false))) {}
        for (;;)
        {
          if (i1 == 0) {
            break label989;
          }
          super.finish();
          break;
          i1 = 0;
        }
      }
      else
      {
        label989:
        if (paramInt1 == 100015) {
          if (this.ax) {
            runOnUiThread(new PhotoListActivity.5(this));
          } else {
            this.ax = true;
          }
        }
      }
    }
  }
  
  public void onBackPressed()
  {
    this.jdField_x_of_type_Boolean = true;
    if ((this.L) || (this.M))
    {
      finish();
      baaf.a(this, false, false);
      return;
    }
    if ((this.O) || (this.P) || (this.ai) || (this.N) || (this.aj) || (this.ak))
    {
      if (this.ay) {
        vhg.a().a(vhg.a().c());
      }
      finish();
      baaf.a(this, false, false);
      return;
    }
    if (k())
    {
      if (this.ay) {
        vhg.a().a(vhg.a().c());
      }
      finish();
      baaf.a(this, false, false);
      return;
    }
    if (this.X)
    {
      algw.a().a("callbackArk", null, null);
      finish();
      baaf.a(this, false, false);
      return;
    }
    d();
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
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
      if (LocalMultiProcConfig.getInt4UinString(this.jdField_e_of_type_JavaLangString + "__qzone_pic_permission__" + this.jdField_j_of_type_JavaLangString, -1, this.jdField_e_of_type_JavaLangString) != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.E = bool;
        if (this.E) {
          break;
        }
        this.jdField_b_of_type_AndroidWidgetCheckBox.setChecked(false);
        paramCompoundButton = new bafb(this, 2131690181);
        paramCompoundButton.setContentView(2131493345);
        paramCompoundButton.setTitle(getString(2131632185));
        paramCompoundButton.setMessage(getString(2131632183));
        paramCompoundButton.setNegativeButton(getString(2131632184), new agbf(this));
        paramCompoundButton.setCanceledOnTouchOutside(false);
        paramCompoundButton.setCancelable(false);
        paramCompoundButton.show();
        QZoneClickReport.startReportImediately(this.jdField_e_of_type_JavaLangString, "40", "1");
        return;
      }
      this.F = paramBoolean;
      getIntent().putExtra("PhotoConst.IS_JUMPTO_TROOP_ALBUM", this.F);
      g();
      if (c())
      {
        int i1;
        if (paramBoolean)
        {
          i1 = 2;
          if (!paramBoolean) {
            break label279;
          }
        }
        label279:
        for (paramCompoundButton = "photo_list_check";; paramCompoundButton = "photo_list_cancel")
        {
          ThreadManager.post(new PhotoListActivity.12(this, i1, paramCompoundButton), 8, null, true);
          return;
          i1 = 3;
          break;
        }
        if (paramBoolean) {
          if (baaf.a(this.jdField_c_of_type_JavaUtilArrayList, jdField_a_of_type_Int, jdField_a_of_type_JavaUtilHashMap, this.ar, this.jdField_c_of_type_JavaUtilHashMap) > 0)
          {
            bbmy.a(this, getResources().getString(2131629431), 0).b(getResources().getDimensionPixelSize(2131167766));
            this.jdField_m_of_type_Int = 0;
            this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
            this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
          }
        }
        while (!this.jdField_p_of_type_Boolean)
        {
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          return;
          if (baaf.a(this.jdField_c_of_type_JavaUtilArrayList, 104345600L, jdField_a_of_type_JavaUtilHashMap, this.ar, this.jdField_c_of_type_JavaUtilHashMap) > 0)
          {
            bbmy.a(this, getResources().getString(2131653694), 0).b(getResources().getDimensionPixelSize(2131167766));
            baaf.d();
          }
          this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
          this.jdField_m_of_type_Int = 2;
          baaf.a(this.jdField_b_of_type_AndroidWidgetTextView, this.jdField_c_of_type_JavaUtilArrayList, jdField_a_of_type_JavaUtilHashMap, this.ar, this, this.jdField_e_of_type_JavaUtilHashMap, this.jdField_c_of_type_JavaUtilHashMap);
          continue;
          this.jdField_m_of_type_Int = 0;
          this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
        }
      }
    }
  }
  
  @TargetApi(9)
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    boolean bool;
    if (LocalMultiProcConfig.getInt4UinString(this.jdField_e_of_type_JavaLangString + "__qzone_pic_permission__" + this.jdField_j_of_type_JavaLangString, -1, this.jdField_e_of_type_JavaLangString) != 0)
    {
      bool = true;
      this.E = bool;
      a(i1);
      switch (i1)
      {
      }
    }
    Object localObject1;
    label712:
    label717:
    label1269:
    label2040:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                bool = false;
                break;
                if (this.L)
                {
                  d();
                  return;
                }
                if ((k()) && (vhg.a().a() == 13)) {
                  urp.a("pic_fictitious", "clk_back", getIntent(), new String[0]);
                }
                if ((this.O) || (this.P))
                {
                  d();
                  if (this.S) {}
                  for (i1 = 0;; i1 = 1)
                  {
                    urp.a("pic_choose_slides", "exp_albumList", i1, 0, new String[0]);
                    return;
                  }
                }
                if ((this.ai) || (this.N) || (this.aj) || (this.ak) || (this.X) || (this.am))
                {
                  d();
                  return;
                }
                onBackPressed();
                return;
                baaf.c();
                baaf.a();
                if (this.L)
                {
                  super.setResult(0);
                  super.finish();
                  baaf.a(this, false, false);
                  return;
                }
                if (this.ag) {
                  awqx.b(null, "dc00898", "", "", "0X800A6E0", "0X800A6E0", 0, 0, "", "", "", "");
                }
                if (this.N)
                {
                  super.setResult(0, getIntent());
                  super.finish();
                  baaf.a(this, false, false);
                  return;
                }
                if (this.az)
                {
                  paramView = getIntent();
                  localObject1 = new Intent();
                  localObject2 = paramView.getStringExtra("PhotoConst.DEST_BROADCAST_ACTION_NAME");
                  if (QLog.isColorLevel()) {
                    QLog.d("PhotoListActivity", 2, String.format("sendPhoto action=%s", new Object[] { localObject2 }));
                  }
                  this.aA = true;
                  if (TextUtils.isEmpty((CharSequence)localObject2))
                  {
                    bbmy.a(this, ajjy.a(2131642303), 0).a();
                    return;
                  }
                  if (QLog.isColorLevel()) {
                    QLog.d("PhotoListActivity", 2, String.format("sendPhoto extras=%s", new Object[] { paramView.getExtras() }));
                  }
                  ((Intent)localObject1).setComponent(null);
                  ((Intent)localObject1).setAction((String)localObject2);
                  ((Intent)localObject1).setFlags(getIntent().getFlags() & 0xDFFFFFFF & 0xFBFFFFFF);
                  super.sendBroadcast((Intent)localObject1);
                  super.finish();
                  baaf.a(this, false, false);
                  return;
                }
                if (this.X)
                {
                  algw.a().a("callbackArk", null, null);
                  finish();
                }
                if (k())
                {
                  if (this.S)
                  {
                    i1 = 0;
                    urp.a("pic_choose_slides", "exit_picChoose", i1, 0, new String[0]);
                  }
                }
                else
                {
                  paramView = PresendPicMgr.a();
                  if (paramView != null) {
                    paramView.a(1006);
                  }
                  paramView = getIntent();
                  if (this.jdField_c_of_type_JavaUtilArrayList == null) {
                    break label712;
                  }
                }
                for (i1 = this.jdField_c_of_type_JavaUtilArrayList.size();; i1 = 0)
                {
                  ageh.b(paramView, i1);
                  if (this.jdField_u_of_type_Boolean) {
                    break label717;
                  }
                  if (k()) {
                    vhg.a().a(vhg.a().c());
                  }
                  super.finish();
                  baaf.a(this, false, false);
                  return;
                  i1 = 1;
                  break;
                }
                paramView = getIntent();
                localObject1 = paramView.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
                localObject2 = paramView.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
                if (localObject1 == null)
                {
                  bbmy.a(this, "请设置INIT_ACTIVITY_CLASS_NAME ", 0).a();
                  return;
                }
                paramView.setClassName((String)localObject2, (String)localObject1);
                paramView.removeExtra("PhotoConst.PHOTO_PATHS");
                paramView.removeExtra("PhotoConst.SINGLE_PHOTO_PATH");
                if (this.an) {
                  paramView.removeExtra("PeakConstants.selectedMediaInfoHashMap");
                }
                paramView.addFlags(603979776);
                if (!paramView.getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false)) {
                  startActivity(paramView);
                }
                for (;;)
                {
                  super.finish();
                  baaf.a(this, false, false);
                  return;
                  paramView.getStringExtra("PhotoConst.PLUGIN_NAME");
                  localObject2 = paramView.getStringExtra("PhotoConst.PLUGIN_APK");
                  String str = paramView.getStringExtra("PhotoConst.UIN");
                  if ("qzone_plugin.apk".equals(localObject2))
                  {
                    QzonePluginProxyActivity.a(paramView, (String)localObject1);
                    bfpr.a(this, str, paramView, 2);
                  }
                  else if ("qqfav.apk".equals(localObject2))
                  {
                    bfhn.a(this, str, paramView, 2);
                  }
                  else
                  {
                    QLog.e("PhotoListActivity", 1, "Watermark has been deleted!");
                  }
                }
                if (!this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked())
                {
                  if (baaf.a(this.jdField_c_of_type_JavaUtilArrayList, jdField_a_of_type_Int, jdField_a_of_type_JavaUtilHashMap, this.ar, this.jdField_c_of_type_JavaUtilHashMap) > 0)
                  {
                    bbmy.a(this, getResources().getString(2131629431), 0).b(getResources().getDimensionPixelSize(2131167766));
                    return;
                  }
                  this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
                  return;
                }
                this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
                return;
              } while (this.jdField_c_of_type_JavaUtilArrayList.size() <= 0);
              getIntent().removeExtra("param_initTime");
              getIntent().putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.jdField_c_of_type_JavaUtilArrayList);
              awqx.b(null, "CliOper", "", "", "0x8004B39", "0x8004B39", 0, 0, "", "", "", "");
              if (!TextUtils.isEmpty(this.jdField_o_of_type_JavaLangString))
              {
                if (TroopBarPublishActivity.class.getSimpleName().equals(this.jdField_o_of_type_JavaLangString)) {
                  azhe.a("pub_page_new", "clk_photo_edit", 0, 0, new String[0]);
                }
              }
              else
              {
                if (!befo.d()) {
                  break label1336;
                }
                if (!this.jdField_q_of_type_Boolean) {
                  break label1269;
                }
                paramView = new HashMap(1);
                if ((this.jdField_c_of_type_JavaUtilHashMap != null) && (this.jdField_c_of_type_JavaUtilHashMap.get(this.jdField_c_of_type_JavaUtilArrayList.get(0)) != null)) {
                  paramView.put("param_localmediainfo", this.jdField_c_of_type_JavaUtilHashMap.get(this.jdField_c_of_type_JavaUtilArrayList.get(0)));
                }
                paramView = a(EditPicActivity.a(this, (String)this.jdField_c_of_type_JavaUtilArrayList.get(0), true, true, true, true, true, 3, 99, 5, paramView), (String)this.jdField_c_of_type_JavaUtilArrayList.get(0));
              }
              for (;;)
              {
                d(paramView);
                startActivity(paramView);
                this.jdField_a_of_type_AndroidWidgetButton.setClickable(false);
                return;
                if (!TroopBarReplyActivity.class.getSimpleName().equals(this.jdField_o_of_type_JavaLangString)) {
                  break;
                }
                azhe.a("reply", "clk_photo_edit", 0, 0, new String[0]);
                break;
                localObject1 = a(EditPicActivity.a(this, (String)this.jdField_c_of_type_JavaUtilArrayList.get(0), true, true, true, true, true, 2, 99, 5), (String)this.jdField_c_of_type_JavaUtilArrayList.get(0));
                paramView = (View)localObject1;
                if (this.ar)
                {
                  ((Intent)localObject1).putExtra("key_enable_edit_title_bar", true);
                  paramView = (View)localObject1;
                  continue;
                  paramView = a(EditPicActivity.a(this, (String)this.jdField_c_of_type_JavaUtilArrayList.get(0), true, true, true, true, true, 2, 99, 5), (String)this.jdField_c_of_type_JavaUtilArrayList.get(0));
                }
              }
              if (this.ag)
              {
                EmotionPreviewFragment.a(this, getIntent(), this.jdField_c_of_type_JavaUtilArrayList);
                awqx.b(null, "dc00898", "", "", "0X800A6DC", "0X800A6DC", 0, 0, "", "", "", "");
                return;
              }
              a(false);
            } while (!this.ar);
            awqx.b(null, "dc00898", "", "", "0X800A06C", "0X800A06C", 2, 0, this.jdField_c_of_type_JavaUtilArrayList.size() + "", "", "", "");
            return;
            this.jdField_c_of_type_AndroidWidgetButton.setClickable(false);
            if (!this.jdField_c_of_type_JavaUtilArrayList.isEmpty()) {
              b((String)this.jdField_c_of_type_JavaUtilArrayList.get(this.jdField_c_of_type_JavaUtilArrayList.size() - 1));
            }
            baaf.a();
            if (this.jdField_c_of_type_JavaUtilArrayList.size() != 0) {
              break label1560;
            }
          } while (!QLog.isColorLevel());
          QLog.e("PhotoList", 2, "size == 0");
          return;
          Object localObject2 = getIntent();
          if (((Intent)localObject2).getBooleanExtra("PhotoConst.IS_SEND_FILESIZE_LIMIT", false))
          {
            paramView = this.jdField_c_of_type_JavaUtilArrayList.iterator();
            for (long l1 = 0L; paramView.hasNext(); l1 = bace.a((String)paramView.next()) + l1) {}
            if (apck.a())
            {
              apbx.a(this, 2131627035, 2131627040, new agbg(this));
              return;
            }
          }
          if (this.X)
          {
            if (this.jdField_c_of_type_JavaUtilArrayList.size() > 0)
            {
              if (QLog.isColorLevel())
              {
                paramView = new StringBuilder(this.jdField_c_of_type_JavaUtilArrayList.size() * 128);
                i1 = 0;
                while (i1 < this.jdField_c_of_type_JavaUtilArrayList.size())
                {
                  paramView.append(String.format(Locale.CHINA, "choose image[%d],path=%s \r\n", new Object[] { Integer.valueOf(i1), this.jdField_c_of_type_JavaUtilArrayList.get(i1) }));
                  i1 += 1;
                }
                QLog.d("PhotoListActivity", 2, paramView.toString());
              }
              q();
              ThreadManagerV2.executeOnSubThread(new PhotoListActivity.14(this));
            }
            for (;;)
            {
              finish();
              return;
              algw.a().a("callbackArk", null, null);
            }
          }
          if (this.L)
          {
            paramView = new Intent();
            paramView.putStringArrayListExtra("img_list", this.jdField_c_of_type_JavaUtilArrayList);
            super.setResult(-1, paramView);
            super.finish();
            baaf.a(this, false, false);
            return;
          }
          if ((this.az) && (!this.aA))
          {
            paramView = ((Intent)localObject2).getStringExtra("PhotoConst.DEST_BROADCAST_ACTION_NAME");
            if (QLog.isColorLevel()) {
              QLog.d("PhotoListActivity", 2, String.format("sendPhoto action=%s", new Object[] { paramView }));
            }
            if ((localObject2 == null) || (this.jdField_c_of_type_JavaUtilArrayList == null) || (this.jdField_c_of_type_JavaUtilArrayList.size() == 0))
            {
              QLog.e("PhotoListActivity", 1, "broadcast photo, action=" + paramView + ", selected photo list is empty!");
              return;
            }
            ((Intent)localObject2).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.jdField_c_of_type_JavaUtilArrayList);
            this.aA = true;
            if (!TextUtils.isEmpty(paramView)) {
              break label2040;
            }
            bbmy.a(this, ajjy.a(2131642320), 0).a();
          }
          while (this.al)
          {
            localObject1 = ((Intent)localObject2).getStringExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME");
            paramView = (View)localObject1;
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              paramView = ((Intent)localObject2).getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
            }
            ((Intent)localObject2).addFlags(603979776);
            QzonePluginProxyActivity.a((Intent)localObject2, paramView);
            bfpr.a(this, bfpy.a(), (Intent)localObject2, -1, null);
            return;
            if (QLog.isColorLevel()) {
              QLog.d("PhotoListActivity", 2, String.format("sendPhoto extras=%s", new Object[] { ((Intent)localObject2).getExtras() }));
            }
            ((Intent)localObject2).setComponent(null);
            ((Intent)localObject2).setAction(paramView);
            super.sendBroadcast((Intent)localObject2);
            super.finish();
            baaf.a(this, false, false);
          }
          j();
          return;
          if (!this.E)
          {
            this.jdField_b_of_type_AndroidWidgetCheckBox.setChecked(false);
            paramView = new bafb(this, 2131690181);
            paramView.setContentView(2131493345);
            paramView.setTitle(getString(2131632185));
            paramView.setMessage(getString(2131632183));
            paramView.setNegativeButton(getString(2131632184), new agbh(this));
            paramView.setCanceledOnTouchOutside(false);
            paramView.setCancelable(false);
            paramView.show();
            QZoneClickReport.startReportImediately(this.jdField_e_of_type_JavaLangString, "40", "1");
            return;
          }
          if (this.jdField_b_of_type_AndroidWidgetCheckBox != null)
          {
            paramView = this.jdField_b_of_type_AndroidWidgetCheckBox;
            if (this.jdField_b_of_type_AndroidWidgetCheckBox.isChecked()) {
              break label2291;
            }
            bool = true;
            paramView.setChecked(bool);
          }
        } while (this.jdField_b_of_type_AndroidWidgetCheckBox == null);
        if (this.jdField_b_of_type_AndroidWidgetCheckBox.isChecked()) {}
        for (paramView = "0X80047F8";; paramView = "0X80047F9")
        {
          awqx.b(null, "CliOper", "", "", paramView, paramView, 0, 0, this.jdField_e_of_type_JavaLangString, "", "", "");
          return;
          bool = false;
          break;
        }
        if (this.jdField_l_of_type_Int == 1)
        {
          if (!this.E)
          {
            this.jdField_b_of_type_AndroidWidgetCheckBox.setChecked(false);
            paramView = new bafb(this, 2131690181);
            paramView.setContentView(2131493345);
            paramView.setTitle(getString(2131632185));
            paramView.setMessage(getString(2131632183));
            paramView.setNegativeButton(getString(2131632184), new agbi(this));
            paramView.setCanceledOnTouchOutside(false);
            paramView.setCancelable(false);
            paramView.show();
            QZoneClickReport.startReportImediately(this.jdField_e_of_type_JavaLangString, "40", "1");
            return;
          }
          paramView = bfpy.a();
          paramView.jdField_a_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
          paramView.jdField_b_of_type_JavaLangString = this.jdField_i_of_type_JavaLangString;
          bfpr.c(this, paramView, this.jdField_j_of_type_JavaLangString, this.jdField_i_of_type_JavaLangString, 100);
          return;
        }
      } while (!c());
      paramView = bfpy.a();
      paramView.jdField_a_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
      paramView.jdField_b_of_type_JavaLangString = this.jdField_i_of_type_JavaLangString;
      localObject1 = new Bundle();
      ((Bundle)localObject1).putInt("key_personal_album_enter_model", 0);
      ((Bundle)localObject1).putString("key_title", getString(2131652422));
      ((Bundle)localObject1).putBoolean("key_personal_album_is_select_video", false);
      if (!TextUtils.isEmpty(this.jdField_k_of_type_JavaLangString))
      {
        ((Bundle)localObject1).putString("key_default_album_id", this.jdField_k_of_type_JavaLangString);
        ((Bundle)localObject1).putBoolean("key_from_upload", true);
      }
      bfpr.a(this, paramView, (Bundle)localObject1, 100009);
      paramView = new LpReportInfo_pf00064(723, 2, 4);
      LpReportManager.getInstance().reportToPF00064(paramView, false, false);
      a("aio_sync_qzone", "operation_type", "photo_list_select_album");
      return;
    } while (this.jdField_b_of_type_AndroidWidgetCheckBox == null);
    label1336:
    label2291:
    if (this.jdField_b_of_type_AndroidWidgetCheckBox.isChecked())
    {
      paramView = "0X80047F8";
      if ((b()) && (this.B) && (this.jdField_b_of_type_AndroidWidgetCheckBox != null))
      {
        if (!c()) {
          break label2732;
        }
        localObject1 = "qzone_will_upload_to_personal_album";
        if ((Build.VERSION.SDK_INT < 9) || (!TextUtils.isEmpty(this.jdField_k_of_type_JavaLangString))) {
          break label2760;
        }
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean((String)localObject1, this.jdField_b_of_type_AndroidWidgetCheckBox.isChecked()).apply();
      }
    }
    for (;;)
    {
      label1560:
      label2653:
      awqx.a(null, "CliOper", "", "", paramView, paramView, 0, 0, this.jdField_e_of_type_JavaLangString, "", "", "");
      return;
      paramView = "0X80047F9";
      break;
      label2732:
      localObject1 = "qzone_will_upload_to_qun_album" + this.jdField_j_of_type_JavaLangString;
      break label2653;
      label2760:
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean((String)localObject1, this.jdField_b_of_type_AndroidWidgetCheckBox.isChecked()).commit();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    zqk.a().c();
    getWindow().setBackgroundDrawable(null);
    super.c();
    try
    {
      super.setContentView(2131495370);
      getWindow().setBackgroundDrawable(null);
      this.jdField_a_of_type_AndroidContentSharedPreferences = BaseApplication.getContext().getSharedPreferences("share", 4);
      paramBundle = getResources();
      int i1 = paramBundle.getDisplayMetrics().widthPixels;
      this.jdField_f_of_type_Int = paramBundle.getDimensionPixelSize(2131166199);
      this.jdField_d_of_type_Int = paramBundle.getDimensionPixelSize(2131166201);
      this.jdField_e_of_type_Int = paramBundle.getDimensionPixelSize(2131166202);
      this.jdField_g_of_type_Int = aciy.a(1.0F, paramBundle);
      this.jdField_b_of_type_Int = ((i1 - this.jdField_f_of_type_Int * 2 - this.jdField_d_of_type_Int * 2) / 3);
      this.jdField_c_of_type_Int = this.jdField_b_of_type_Int;
      paramBundle = getIntent();
      a(paramBundle);
      b();
      if (QLog.isColorLevel()) {
        QLog.d("SelectPhotoTrace", 2, "PhotoListActivity onCreate(),extra is:" + paramBundle.getExtras());
      }
      if (QLog.isColorLevel()) {
        QLog.d("SelectPhotoTrace", 2, "PhotoListActivity,hashCode is:" + System.identityHashCode(this));
      }
      if (this.jdField_m_of_type_Boolean)
      {
        paramBundle = new NewIntent(BaseApplicationImpl.getApplication(), awcx.class);
        paramBundle.putExtra("selfuin", Long.valueOf(BaseApplicationImpl.getApplication().getRuntime().getAccount()));
        BaseApplicationImpl.getApplication().getRuntime().registObserver(jdField_a_of_type_Agbz);
        BaseApplicationImpl.getApplication().getRuntime().startServlet(paramBundle);
      }
      return;
    }
    catch (Throwable paramBundle)
    {
      super.finish();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (!this.jdField_x_of_type_Boolean) {
      afzf.a(this).a();
    }
    if (this.jdField_a_of_type_Agbx != null)
    {
      int i1 = this.jdField_a_of_type_Agbx.getCount();
      baaf.jdField_a_of_type_JavaUtilHashMap.put(this.jdField_b_of_type_JavaLangString, Integer.valueOf(i1));
    }
    if (this.jdField_m_of_type_Boolean) {
      BaseApplicationImpl.getApplication().getRuntime().unRegistObserver(jdField_a_of_type_Agbz);
    }
    jdField_a_of_type_JavaUtilArrayList = null;
    if (k()) {
      vhg.a().f();
    }
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("SelectPhotoTrace", 2, "PhotoListActivity onNewIntent() is called,extra is:" + paramIntent.getExtras());
    }
    if (QLog.isColorLevel()) {
      QLog.d("SelectPhotoTrace", 2, "PhotoListActivityhashCode is:" + System.identityHashCode(this));
    }
    QLog.d("PhotoListActivity", 2, "onNewIntent()");
    if (paramIntent.getBooleanExtra("extra_directly_back", false))
    {
      this.ax = false;
      a(paramIntent);
      QLog.d("PhotoListActivity", 2, "PhotoListActivity onNewIntent() camera back");
      if (this.jdField_a_of_type_JavaLangString == null) {
        break label150;
      }
      paramIntent = this.jdField_a_of_type_JavaLangString;
    }
    for (;;)
    {
      setTitle(paramIntent);
      return;
      setIntent(paramIntent);
      a(paramIntent);
      break;
      label150:
      if (this.jdField_h_of_type_Int == 2) {
        paramIntent = baae.jdField_m_of_type_JavaLangString;
      } else {
        paramIntent = baae.jdField_l_of_type_JavaLangString;
      }
    }
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_AndroidOsAsyncTask = null;
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_AndroidWidgetButton != null) {
      this.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
    }
    if (k())
    {
      vhg.a().c();
      vhg.a().a(this.jdField_a_of_type_Vhk);
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if (this.ax)
    {
      runOnUiThread(new PhotoListActivity.6(this));
      return;
    }
    this.ax = true;
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    super.setTitle(paramCharSequence);
    this.jdField_g_of_type_AndroidWidgetTextView.setText(paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.PhotoListActivity
 * JD-Core Version:    0.7.0.1
 */