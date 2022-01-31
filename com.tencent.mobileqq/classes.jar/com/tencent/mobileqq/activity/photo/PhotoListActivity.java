package com.tencent.mobileqq.activity.photo;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.Uri;
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
import com.tencent.av.camera.QavCameraUsage;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyUploadAvatarActivity;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.EditPicActivity;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager.SlideShowActionListener;
import com.tencent.biz.qqstory.takevideo.slideshow.TransitionHandler;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.activity.aio.photo.PeakActivity;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraReporter;
import com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask;
import com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask.ThumbInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.servlet.QZoneAlbumListNumServlet;
import com.tencent.mobileqq.statistics.MTAReportController;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;
import com.tencent.mobileqq.troop.activity.TroopBarReplyActivity;
import com.tencent.mobileqq.troop.utils.TribeUtils;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.GestureSelectGridView;
import com.tencent.widget.GestureSelectGridView.OnSelectListener;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import cooperation.qqfav.QfavHelper;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.QZoneVideoCommonUtils;
import cooperation.qzone.QZoneVideoCommonUtils.VideoSupport;
import cooperation.qzone.QZoneVideoDownloadActivity;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.model.BaseBusinessAlbumInfo;
import cooperation.qzone.model.BusinessAlbumInfo;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.qzone.report.retention.RetentionReport;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.XMPCoreUtil;
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
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import xcn;
import xco;
import xcq;
import xcr;
import xcs;
import xct;
import xcu;
import xcv;
import xcw;
import xcx;
import xcy;
import xcz;
import xdb;
import xdc;
import xdd;
import xde;
import xdj;
import xdl;
import xdm;
import xdn;
import xdo;

public class PhotoListActivity
  extends PeakActivity
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, SlideShowPhotoListManager.SlideShowActionListener, MediaScanner.OnMediaScannerListener
{
  static int jdField_a_of_type_Int = 19922944;
  public static ArrayList a;
  public static HashMap a;
  private static Map jdField_a_of_type_JavaUtilMap = new HashMap();
  private static xdo jdField_a_of_type_Xdo = new xdo();
  public static boolean a;
  public static boolean b;
  public static long f;
  public static int m;
  private static int w;
  boolean A;
  public boolean B = false;
  boolean C = false;
  boolean D = false;
  boolean E = true;
  public boolean F = false;
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
  public boolean S = false;
  private boolean Y;
  private boolean Z;
  public double a;
  public long a;
  Dialog jdField_a_of_type_AndroidAppDialog;
  SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  public AsyncTask a;
  public Handler a;
  View jdField_a_of_type_AndroidViewView;
  Button jdField_a_of_type_AndroidWidgetButton;
  CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public SlideShowPhotoListManager a;
  public LocalMediaInfo a;
  MediaFileFilter jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter;
  public PhotoListActivity.onSelectionChangeListener a;
  AdapterView.OnItemClickListener jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener = new xde(this);
  GestureSelectGridView.OnSelectListener jdField_a_of_type_ComTencentWidgetGestureSelectGridView$OnSelectListener = new xcn(this);
  public GestureSelectGridView a;
  public String a;
  private LinkedHashMap jdField_a_of_type_JavaUtilLinkedHashMap;
  public xdm a;
  private boolean aa;
  private boolean ab;
  private boolean ac;
  private boolean ad;
  private boolean ae;
  private boolean af;
  private boolean ag;
  private boolean ah;
  private boolean ai;
  private boolean aj;
  private boolean ak;
  private boolean al = true;
  private boolean am;
  private boolean an;
  private boolean ao;
  private boolean ap = true;
  public double b;
  public int b;
  public long b;
  View jdField_b_of_type_AndroidViewView;
  protected Button b;
  public CheckBox b;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  public String b;
  public ArrayList b;
  protected HashMap b;
  public HashSet b;
  public int c;
  public long c;
  public View c;
  public Button c;
  public TextView c;
  public String c;
  public ArrayList c;
  public HashMap c;
  public HashSet c;
  int jdField_d_of_type_Int;
  public long d;
  View jdField_d_of_type_AndroidViewView;
  public TextView d;
  public String d;
  public ArrayList d;
  public HashMap d;
  public boolean d;
  int jdField_e_of_type_Int;
  long jdField_e_of_type_Long;
  TextView jdField_e_of_type_AndroidWidgetTextView;
  public String e;
  public HashMap e;
  boolean jdField_e_of_type_Boolean = false;
  int jdField_f_of_type_Int;
  TextView jdField_f_of_type_AndroidWidgetTextView;
  String jdField_f_of_type_JavaLangString;
  public boolean f;
  int jdField_g_of_type_Int;
  public long g;
  TextView jdField_g_of_type_AndroidWidgetTextView;
  String jdField_g_of_type_JavaLangString;
  public boolean g;
  protected int h;
  private long jdField_h_of_type_Long = -1L;
  String jdField_h_of_type_JavaLangString = null;
  boolean jdField_h_of_type_Boolean = true;
  public int i;
  String i;
  public boolean i;
  protected int j;
  public String j;
  boolean j;
  public int k;
  String jdField_k_of_type_JavaLangString;
  boolean jdField_k_of_type_Boolean = false;
  public int l;
  String l;
  protected boolean l;
  String jdField_m_of_type_JavaLangString;
  boolean jdField_m_of_type_Boolean = false;
  public int n;
  private String jdField_n_of_type_JavaLangString = "";
  boolean jdField_n_of_type_Boolean = false;
  public int o;
  private String jdField_o_of_type_JavaLangString;
  boolean jdField_o_of_type_Boolean = true;
  public int p;
  public boolean p;
  public int q;
  boolean q;
  int jdField_r_of_type_Int;
  boolean jdField_r_of_type_Boolean = false;
  public int s;
  boolean s;
  public int t;
  boolean t;
  public int u;
  boolean u;
  boolean v = false;
  protected boolean w;
  private int x;
  public boolean x;
  public boolean y;
  boolean z;
  
  static
  {
    jdField_m_of_type_Int = -1;
  }
  
  public PhotoListActivity()
  {
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_Xdm = null;
    this.jdField_i_of_type_Int = 1;
    this.jdField_j_of_type_Int = 1;
    this.jdField_i_of_type_Boolean = true;
    this.jdField_j_of_type_Boolean = false;
    this.jdField_p_of_type_Boolean = false;
    this.jdField_q_of_type_Boolean = false;
    this.jdField_s_of_type_Boolean = false;
    this.jdField_u_of_type_Boolean = false;
    this.jdField_x_of_type_Boolean = false;
    this.jdField_p_of_type_Int = 0;
    this.jdField_q_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = null;
    this.jdField_a_of_type_AndroidOsHandler = new xdl(this);
    this.jdField_b_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_c_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_g_of_type_Long = 0L;
  }
  
  private String a(LocalMediaInfo paramLocalMediaInfo)
  {
    String str2 = "最多只能选择" + this.jdField_i_of_type_Int + "张图片";
    String str1 = str2;
    if (paramLocalMediaInfo != null)
    {
      paramLocalMediaInfo = MimeHelper.a(paramLocalMediaInfo.mMimeType);
      if ((!this.an) || (!this.K)) {
        break label88;
      }
      str1 = "最多上传" + this.jdField_i_of_type_Int + "个视频或图片";
    }
    label88:
    do
    {
      do
      {
        do
        {
          return str1;
          if ((this.P) && (!this.K)) {
            return "已达" + this.jdField_i_of_type_Int + "张上限";
          }
          if (jdField_w_of_type_Int > 0) {
            break;
          }
          str1 = str2;
        } while (!this.K);
        str1 = str2;
      } while (paramLocalMediaInfo == null);
      str1 = str2;
    } while (!"video".equals(paramLocalMediaInfo[0]));
    if ((jdField_w_of_type_Int == this.jdField_i_of_type_Int) && (this.K) && (paramLocalMediaInfo != null) && ("video".equals(paramLocalMediaInfo[0]))) {
      return "最多只能选择" + this.jdField_i_of_type_Int + "个视频";
    }
    return "图片和视频不能超过" + this.jdField_i_of_type_Int + "个";
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
        String str = AppConstants.aW + (String)localObject;
        localObject = paramString;
        if (!str.equals(paramString))
        {
          localObject = new File(AppConstants.aW);
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
  
  private ArrayList a(String paramString)
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
  
  private List a(int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      if ((paramInt1 >= 0) && (paramInt2 >= 0) && (paramInt1 <= paramInt2) && (paramInt1 <= paramInt2)) {
        try
        {
          if (paramInt1 < this.jdField_a_of_type_Xdm.getCount())
          {
            LocalMediaInfo localLocalMediaInfo = this.jdField_a_of_type_Xdm.a(paramInt1);
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
    int i2 = this.jdField_c_of_type_JavaUtilArrayList.size();
    int i3;
    if (i2 == 0)
    {
      i3 = 601;
      i2 = 0;
      switch (paramInt)
      {
      default: 
        return;
      case 2131363262: 
        i1 = 3;
      }
    }
    for (;;)
    {
      LpReportInfo_pf00064.allReport(i3, i2, i1);
      return;
      i3 = 600;
      if (i2 == 1)
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
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    int i2 = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition();
    int i3 = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getLastVisiblePosition();
    int i1 = i2;
    if (i1 <= i3)
    {
      if ((paramBoolean) && (paramInt != i1)) {}
      label423:
      for (;;)
      {
        i1 += 1;
        break;
        Object localObject = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getChildAt(i1 - i2);
        LocalMediaInfo localLocalMediaInfo = this.jdField_a_of_type_Xdm.a(i1);
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
          xdn localxdn;
          if (paramInt != i1)
          {
            i4 = this.jdField_c_of_type_JavaUtilArrayList.indexOf(localLocalMediaInfo.path);
            if (i4 >= 0)
            {
              localxdn = (xdn)((View)localObject).getTag();
              if ((localxdn != null) && (localxdn.a != null)) {
                localxdn.a.setCheckedNumber(i4 + 1);
              }
            }
          }
          else
          {
            i4 = AlbumUtil.a(localLocalMediaInfo);
            if ((i4 == 0) || (i4 == 1))
            {
              localxdn = (xdn)((View)localObject).getTag();
              ImageView localImageView = localxdn.c;
              int i5 = localLocalMediaInfo.selectStatus;
              if (i5 == 1)
              {
                localImageView.setVisibility(0);
                localxdn.a.setCheckedNumber(this.jdField_c_of_type_JavaUtilArrayList.indexOf(localLocalMediaInfo.path) + 1);
                if (((View)localObject).getBackground() != null) {
                  ((View)localObject).setBackgroundDrawable(null);
                }
              }
              for (;;)
              {
                if (!AppSetting.jdField_b_of_type_Boolean) {
                  break label423;
                }
                localObject = PhotoUtils.a(i4, localLocalMediaInfo, i1, localxdn.a.isChecked());
                localxdn.a.setContentDescription((CharSequence)localObject);
                break;
                if (i5 == 3)
                {
                  localImageView.setVisibility(4);
                  localxdn.a.setChecked(false);
                  if (!this.y)
                  {
                    if (((View)localObject).getBackground() == null) {
                      ((View)localObject).setBackgroundResource(2130837755);
                    }
                  }
                  else {
                    ((View)localObject).setBackgroundDrawable(null);
                  }
                }
                else
                {
                  localImageView.setVisibility(4);
                  localxdn.a.setChecked(false);
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
  
  private void a(LocalMediaInfo paramLocalMediaInfo)
  {
    XMPCoreUtil.a().a(new xcw(this, paramLocalMediaInfo));
  }
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    Properties localProperties = new Properties();
    localProperties.put(paramString2, paramString3);
    MTAReportController.a(BaseApplicationImpl.getContext()).reportKVEvent(paramString1, localProperties);
  }
  
  private void a(List paramList)
  {
    QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").post(new xcv(this, paramList));
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
        d(paramIntent);
      }
    }
    for (;;)
    {
      bool1 = true;
      return bool1;
      label49:
      c(paramIntent);
    }
  }
  
  private boolean a(LocalMediaInfo paramLocalMediaInfo)
  {
    return (paramLocalMediaInfo != null) && ("image/gif".equals(paramLocalMediaInfo.mMimeType));
  }
  
  private boolean a(String paramString)
  {
    if (this.jdField_a_of_type_Xdm.jdField_a_of_type_JavaUtilArrayList != null)
    {
      int i1 = 0;
      for (boolean bool1 = false;; bool1 = bool2)
      {
        bool2 = bool1;
        if (i1 >= this.jdField_a_of_type_Xdm.jdField_a_of_type_JavaUtilArrayList.size()) {
          break;
        }
        bool2 = bool1;
        if (this.jdField_a_of_type_Xdm.jdField_a_of_type_JavaUtilArrayList.get(i1) != null)
        {
          bool2 = bool1;
          if (((LocalMediaInfo)this.jdField_a_of_type_Xdm.jdField_a_of_type_JavaUtilArrayList.get(i1)).path != null)
          {
            bool2 = bool1;
            if (((LocalMediaInfo)this.jdField_a_of_type_Xdm.jdField_a_of_type_JavaUtilArrayList.get(i1)).path.equals(paramString))
            {
              bool2 = bool1;
              if (AlbumUtil.a((LocalMediaInfo)this.jdField_a_of_type_Xdm.jdField_a_of_type_JavaUtilArrayList.get(i1)) == 1) {
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
      StatisticCollector.a(BaseApplication.getContext()).a(null, "qzoneChoosePhotoCamera", true, 0L, 0L, localHashMap, null, true);
      return;
      if (!this.ao)
      {
        this.ao = true;
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
  
  private void c(Intent paramIntent)
  {
    b(5);
    paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if ((paramIntent != null) && (paramIntent.size() > 0) && (!TextUtils.isEmpty((CharSequence)paramIntent.get(0)))) {
      ThreadManager.postImmediately(new xdj(this, (String)paramIntent.get(0)), null, true);
    }
  }
  
  private void c(String paramString)
  {
    try
    {
      Intent localIntent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
      localIntent.setData(Uri.fromFile(new File(paramString)));
      sendBroadcast(localIntent);
      return;
    }
    catch (Exception paramString)
    {
      QZLog.e("PhotoListActivity", 2, new Object[] { "scanMediaFile :", paramString });
    }
  }
  
  private boolean c()
  {
    if (QzoneConfig.getInstance().getConfig("PhotoUpload", "C2CAioEnableSyncImageToQzone", 0) == 0) {}
    while ((this.jdField_k_of_type_Int != 0) && (this.jdField_k_of_type_Int != 1000) && (this.jdField_k_of_type_Int != 1004)) {
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
    c();
    b(4);
    this.jdField_g_of_type_Long = System.currentTimeMillis();
    paramIntent = new EncodeVideoTask(this, paramIntent.getStringExtra("video_new_fake_vid"), true, new EncodeVideoTask.ThumbInfo(), true);
    paramIntent.a(true);
    paramIntent.a(new xco(this));
    paramIntent.execute(new Void[0]);
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
    if (this.ak)
    {
      paramIntent.putExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", true);
      paramIntent.putExtra("session_info", getIntent().getParcelableExtra("session_info"));
    }
  }
  
  private boolean e()
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.contains("qzone_will_upload_to_qun_album" + this.jdField_j_of_type_JavaLangString);
  }
  
  private void f(Intent paramIntent)
  {
    if ((this.jdField_c_of_type_JavaUtilHashMap == null) || (this.jdField_a_of_type_JavaUtilLinkedHashMap == null)) {
      return;
    }
    for (;;)
    {
      try
      {
        if ((!this.ah) && (this.jdField_a_of_type_Xdm != null) && (this.jdField_a_of_type_Xdm.getCount() > 0)) {
          m();
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
  
  private void g(Intent paramIntent)
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
  
  private void j()
  {
    if (this.ak) {
      ReportController.b(null, "CliOper", "", "", "0x80083EC", "0x80083EC", 0, 0, "", "", "", "");
    }
  }
  
  private void k()
  {
    Object localObject = QZoneVideoCommonUtils.a();
    if (!((QZoneVideoCommonUtils.VideoSupport)localObject).a())
    {
      String str = QzoneConfig.getInstance().getConfig("QZoneTextSetting", "PhotoListCameraNotSupport", "当前不支持拍摄");
      if ((((QZoneVideoCommonUtils.VideoSupport)localObject).a() != null) && (((QZoneVideoCommonUtils.VideoSupport)localObject).b())) {
        QQToast.a(this, QzoneConfig.getInstance().getConfig("QZoneTextSetting", "ToastStartLiveVideoFailForMemory", "SD卡不存在或手机内存不足"), 0).a();
      }
      for (;;)
      {
        if (((QZoneVideoCommonUtils.VideoSupport)localObject).a() != null) {
          QZLog.e("PhotoListActivity", 2, new Object[] { "gotoCamera fail", ((QZoneVideoCommonUtils.VideoSupport)localObject).a() });
        }
        b(2);
        return;
        QQToast.a(this, str, 0).a();
      }
    }
    localObject = new Intent(this, QZoneVideoDownloadActivity.class);
    ((Intent)localObject).putExtra("extra.busi_type", 3);
    ((Intent)localObject).putExtra("extra_directly_back", true);
    ((Intent)localObject).putExtra("PhotoConst.PLUGIN_APK", "qzone_plugin.apk");
    ((Intent)localObject).putExtra("DirectBackToQzone", true);
    ((Intent)localObject).putExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME", PhotoListActivity.class.getClass().getName());
    ((Intent)localObject).putExtra("pic_confirm_text", getString(2131435921));
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
  
  private void l()
  {
    if (((this.C) && ("$RecentAlbumId".equals(this.jdField_b_of_type_JavaLangString))) || ((this.D) && ("$VideoAlbumId".equals(this.jdField_b_of_type_JavaLangString)))) {
      new PhotoListActivity.QueryPhotoTask(this).execute(new Object[0]);
    }
  }
  
  private void m()
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
    this.ah = true;
  }
  
  int a(int paramInt)
  {
    Iterator localIterator = this.jdField_c_of_type_JavaUtilArrayList.iterator();
    int i1 = 0;
    if (localIterator.hasNext())
    {
      if (new File((String)localIterator.next()).length() <= paramInt) {
        break label53;
      }
      i1 += 1;
    }
    label53:
    for (;;)
    {
      break;
      return i1;
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
  
  @TargetApi(9)
  void a()
  {
    Object localObject = (RelativeLayout)findViewById(2131362845);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      ((RelativeLayout)localObject).setFitsSystemWindows(true);
      ((RelativeLayout)localObject).setPadding(0, ImmersiveUtils.a(this), 0, 0);
    }
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363262));
    label112:
    int i1;
    if (this.Z)
    {
      this.jdField_e_of_type_AndroidWidgetTextView.setText("微云");
      this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363447));
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
      if (!this.Z) {
        break label896;
      }
      this.jdField_f_of_type_AndroidWidgetTextView.setText("筛选");
      this.jdField_f_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363400));
      if (this.jdField_a_of_type_JavaLangString == null) {
        break label909;
      }
      localObject = this.jdField_a_of_type_JavaLangString;
      label146:
      setTitle((CharSequence)localObject);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131365529));
      this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131365530));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365531));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369485));
      g();
      this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131370975));
      this.jdField_c_of_type_AndroidWidgetButton = ((Button)findViewById(2131365532));
      this.jdField_a_of_type_AndroidViewView = findViewById(2131366448);
      this.jdField_b_of_type_AndroidViewView = findViewById(2131370191);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370194));
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView = ((GestureSelectGridView)findViewById(2131370976));
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setScrollBarStyle(0);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setNumColumns(3);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setColumnWidth(this.jdField_b_of_type_Int);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setHorizontalSpacing(this.jdField_d_of_type_Int);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setVerticalSpacing(this.jdField_e_of_type_Int);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setPadding(this.jdField_f_of_type_Int, this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getPaddingTop(), this.jdField_f_of_type_Int, this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getPaddingBottom());
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setOnItemClickListener(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setOnIndexChangedListener(this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView$OnSelectListener);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setMaximumVelocity((int)(2500.0F * getResources().getDisplayMetrics().density));
      if (this.ag) {
        this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setOnScrollListener(new xcx(this));
      }
      this.jdField_a_of_type_Xdm = new xdm(this);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setAdapter(this.jdField_a_of_type_Xdm);
      String str = this.jdField_h_of_type_JavaLangString;
      localObject = str;
      if (TextUtils.isEmpty(str))
      {
        if (!this.F) {
          break label931;
        }
        localObject = getString(2131435922);
      }
      label485:
      this.jdField_c_of_type_AndroidWidgetButton.setText((CharSequence)localObject);
      localObject = this.jdField_a_of_type_AndroidViewView;
      if ((!this.jdField_i_of_type_Boolean) && (this.jdField_h_of_type_Int != 2) && (!this.P)) {
        break label960;
      }
      i1 = 8;
      label523:
      ((View)localObject).setVisibility(i1);
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
      if (!this.jdField_m_of_type_Boolean) {
        break label976;
      }
      if (this.jdField_k_of_type_Int != 9501) {
        break label965;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      label570:
      this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    }
    for (;;)
    {
      if (this.jdField_n_of_type_Boolean) {
        this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
      }
      e();
      if (this.P)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowPhotoListManager = new SlideShowPhotoListManager(this, this, this.jdField_c_of_type_JavaUtilArrayList, this.jdField_i_of_type_Int, 0);
        if (getIntent().getBooleanExtra("report_first_exposure", true))
        {
          localObject = (TransitionHandler)QQStoryContext.a().getBusinessHandler(1);
          if (localObject != null) {
            ((TransitionHandler)localObject).b();
          }
          getIntent().putExtra("report_first_exposure", false);
          StoryReportor.a("video_edit", "exp_slides", 0, 0, new String[0]);
        }
      }
      if ((this.z) && (this.jdField_e_of_type_JavaLangString != null))
      {
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131370195));
        this.jdField_b_of_type_AndroidWidgetCheckBox = ((CheckBox)this.jdField_b_of_type_AndroidViewView.findViewById(2131370193));
        this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
        this.jdField_b_of_type_AndroidWidgetCheckBox.setOnClickListener(this);
        this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
        this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
        this.jdField_b_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
        this.jdField_c_of_type_AndroidViewView = findViewById(2131370196);
        this.jdField_d_of_type_AndroidViewView = findViewById(2131370192);
        this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
        if (c()) {
          ThreadManager.post(new xcy(this), 8, null, true);
        }
      }
      if (this.M) {
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      return;
      this.jdField_e_of_type_AndroidWidgetTextView.setText("相册");
      break;
      label896:
      this.jdField_f_of_type_AndroidWidgetTextView.setText("取消");
      break label112;
      label909:
      if (this.jdField_h_of_type_Int == 2)
      {
        localObject = "视频";
        break label146;
      }
      localObject = "最近照片";
      break label146;
      label931:
      if (this.jdField_m_of_type_Boolean)
      {
        localObject = getString(2131435920);
        break label485;
      }
      localObject = getString(2131435921);
      break label485;
      label960:
      i1 = 0;
      break label523;
      label965:
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      break label570;
      label976:
      if (this.jdField_p_of_type_Boolean)
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
        Object localObject = this.jdField_a_of_type_Xdm.a(paramInt1);
        int i2 = this.jdField_c_of_type_JavaUtilArrayList.indexOf(((LocalMediaInfo)localObject).path);
        if (i2 >= 0)
        {
          localObject = (xdn)this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getChildAt(((LocalMediaInfo)localObject).position.intValue() - paramInt2).getTag();
          if ((localObject != null) && (((xdn)localObject).a != null)) {
            ((xdn)localObject).a.setCheckedNumber(i2 + 1);
          }
        }
        paramInt1 += 1;
      }
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
      } while ((this.jdField_a_of_type_Xdm == null) || (this.jdField_a_of_type_Xdm.jdField_a_of_type_JavaUtilArrayList == null));
      localObject = (LocalMediaInfo)this.jdField_a_of_type_Xdm.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
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
    boolean bool2 = true;
    if (QLog.isColorLevel()) {
      QLog.d("SelectPhotoTrace", 2, "PhotoListActivity initData(),intent extras is:" + paramIntent.getExtras());
    }
    if (TeamWorkDocEditBrowserActivity.class.getName().equals(paramIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME"))) {
      this.aj = true;
    }
    this.jdField_u_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", true);
    this.jdField_x_of_type_Int = paramIntent.getIntExtra("PhotoConst.current_record_video_count", 0);
    Object localObject;
    if (paramIntent.getBooleanExtra("album_enter_directly", false))
    {
      long l1 = System.currentTimeMillis();
      long l2 = AlbumUtil.jdField_a_of_type_Long;
      if ((this.jdField_u_of_type_Boolean) && (l1 - l2 < 60000L))
      {
        this.jdField_a_of_type_JavaLangString = AlbumUtil.jdField_c_of_type_JavaLangString;
        this.jdField_b_of_type_JavaLangString = AlbumUtil.jdField_b_of_type_JavaLangString;
      }
      if (this.jdField_b_of_type_JavaLangString == null)
      {
        this.jdField_b_of_type_JavaLangString = "$RecentAlbumId";
        this.jdField_a_of_type_JavaLangString = null;
      }
      this.Z = paramIntent.getBooleanExtra("PhotoConst.IS_FROM_WEIYUN", false);
      if (this.Z) {
        this.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("ALBUM_NAME");
      }
      this.aa = "tribe".equals(paramIntent.getStringExtra("video_refer"));
      localObject = paramIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        if (((String)localObject).equals("com.qzone.publish.ui.activity.QZoneUploadPhotoActivity")) {
          this.ac = true;
        }
        if ((((String)localObject).equals("com.qzone.publish.ui.activity.QZonePublishMoodTabActivity")) || (((String)localObject).equals("com.qzone.publish.ui.activity.QZonePublishMoodActivity"))) {
          this.ad = true;
        }
        if (((String)localObject).equals("com.qzone.publish.ui.activity.QZonePublishVoiceMoodActivity")) {
          this.ae = true;
        }
        if ((((String)localObject).equals("com.qzone.album.ui.activity.QzDynamicVideoEditActivity")) || (((String)localObject).equals("com.tencent.mobileqq.activity.richmedia.QzDynamicVideoPreviewActivity")))
        {
          this.af = true;
          this.ad = true;
        }
      }
      this.ag = paramIntent.getBooleanExtra("NEED_QZONE_MACHINE_LEARNING_REPORT", false);
      if (this.ag)
      {
        this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
        g(paramIntent);
      }
      jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("QZONE_SUPPORT_MIX_MOOD", false);
      jdField_b_of_type_Boolean = paramIntent.getBooleanExtra("upload_single_video", false);
      if (((!TextUtils.isEmpty((CharSequence)localObject)) && ((((String)localObject).equals("com.qzone.publish.ui.activity.QZoneUploadPhotoActivity")) || (((String)localObject).equals("com.qzone.publish.ui.activity.QZonePublishMoodActivity")) || (((String)localObject).equals("com.qzone.publish.ui.activity.QZonePublishMoodTabActivity")) || (((String)localObject).equals("com.qzone.common.activities.FeedActionPanelActivity")))) || (this.jdField_k_of_type_Boolean) || (this.af)) {
        this.ai = true;
      }
      this.Y = paramIntent.getBooleanExtra("PeakConstants.showGifTypeIcon", false);
      this.jdField_c_of_type_JavaUtilArrayList = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
      if (this.jdField_c_of_type_JavaUtilArrayList == null) {
        this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
      }
      this.jdField_c_of_type_JavaUtilHashMap = ((HashMap)paramIntent.getSerializableExtra("PeakConstants.selectedMediaInfoHashMap"));
      if (this.jdField_c_of_type_JavaUtilHashMap == null) {
        this.jdField_c_of_type_JavaUtilHashMap = new HashMap();
      }
      this.jdField_d_of_type_JavaUtilHashMap = ((HashMap)paramIntent.getSerializableExtra("PhotoConst.PANORAMA_IMAGES"));
      if (this.jdField_d_of_type_JavaUtilHashMap != null) {
        break label1852;
      }
      this.jdField_d_of_type_JavaUtilHashMap = new HashMap();
      label548:
      this.jdField_d_of_type_JavaUtilArrayList = new ArrayList();
      this.jdField_i_of_type_Int = paramIntent.getIntExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
      this.jdField_j_of_type_Int = paramIntent.getIntExtra("PhotoConst.MAXUM_SELECTED_NUM_VIDEO", 1);
      this.jdField_i_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_SINGLE_MODE", true);
      this.jdField_j_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_NO_PANORAMA", false);
      this.jdField_k_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_FROM_DYNAMIC_ALBUM", false);
      this.jdField_l_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_SHOW_QZONE_ALBUM", false);
      this.jdField_b_of_type_JavaUtilHashMap = ((HashMap)paramIntent.getSerializableExtra("PhotoConst.PHOTO_INFOS"));
      this.jdField_m_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", false);
      this.jdField_n_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.original_button", false);
      this.jdField_o_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.quality_count_tv", true);
      this.jdField_e_of_type_JavaLangString = paramIntent.getStringExtra("PhotoConst.MY_UIN");
      if (this.jdField_m_of_type_Boolean)
      {
        this.jdField_f_of_type_JavaLangString = paramIntent.getStringExtra("PhotoConst.MY_NICK");
        this.jdField_g_of_type_JavaLangString = paramIntent.getStringExtra("PhotoConst.MY_HEAD_DIR");
      }
      this.jdField_d_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.HANDLE_DEST_RESULT", false);
      this.jdField_q_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_SINGLE_DERECTBACK_MODE", false);
      this.jdField_r_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_SINGLE_NEED_EDIT", false);
      this.jdField_s_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false);
      this.jdField_k_of_type_Int = paramIntent.getIntExtra("uintype", -1);
      this.jdField_l_of_type_Int = paramIntent.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
      if (this.jdField_i_of_type_Int > 1) {
        this.jdField_i_of_type_Boolean = false;
      }
      if (paramIntent.getBooleanExtra("PhotoConst.ALWAYS_SHOW_NUMBER_WHEN_ONLY_ONE_IMAGE", false)) {
        this.jdField_i_of_type_Boolean = false;
      }
      this.jdField_t_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", false);
      this.v = paramIntent.getBooleanExtra("PhotoConst.SEND_FLAG", false);
      boolean bool3 = paramIntent.getBooleanExtra("PhotoConst.AIO_TO_PHOTO_LIST_NEED_SHOW_UPLOAD_BAR", false);
      if ((this.jdField_k_of_type_Int != 1) || (paramIntent.getBooleanExtra("is_anonymous", false))) {
        break label1942;
      }
      bool1 = true;
      label877:
      this.z = bool1;
      if ((!this.z) && ((!bool3) || (!c()))) {
        break label1947;
      }
      bool1 = true;
      label903:
      this.z = bool1;
      this.A = paramIntent.getBooleanExtra("PhotoConst.DISABLE_UPLOAD_TO_TROOP_ALBUM", false);
      bool1 = paramIntent.getBooleanExtra("filter_photolist_troopalbum_toolbar", false);
      if ((!this.z) || (bool1) || (this.A)) {
        break label1952;
      }
      bool1 = true;
      label949:
      this.z = bool1;
      this.jdField_i_of_type_JavaLangString = paramIntent.getStringExtra("uinname");
      this.jdField_j_of_type_JavaLangString = paramIntent.getStringExtra("uin");
      if (this.jdField_k_of_type_Int == 9501) {
        this.J = paramIntent.getBooleanExtra("isdevicesupportmultiupload", false);
      }
      if (this.jdField_e_of_type_JavaLangString != null) {
        break label1957;
      }
      localObject = this.jdField_q_of_type_JavaLangString;
      label1011:
      this.jdField_e_of_type_JavaLangString = ((String)localObject);
      this.jdField_h_of_type_Int = paramIntent.getIntExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 1);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter = ((MediaFileFilter)MediaFileFilter.a.get(this.jdField_h_of_type_Int));
      this.jdField_e_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", false);
      if (this.jdField_e_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter = new DynamicImageMediaFileFilter(MediaFileFilter.b);
        this.jdField_h_of_type_Int = 1;
      }
      this.jdField_b_of_type_Long = paramIntent.getLongExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_SIZE", 293601280L);
      this.jdField_f_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_PREVIEW_VIDEO", true);
      this.jdField_g_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_TRIM_VIDEO_BLACK_LIST", false);
      this.jdField_c_of_type_Long = paramIntent.getLongExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_DURATION", 9223372036854775807L);
      this.jdField_d_of_type_Long = paramIntent.getLongExtra("PhotoConst.QZONE_COVER_PHOTOLIST_KEY_VIDEO_DURATION", 9223372036854775807L);
      this.jdField_e_of_type_Long = paramIntent.getLongExtra("PhotoConst.PHOTOLIST_KEY_FILTER_VIDEO_DURATION_LIMIT", 9223372036854775807L);
      if (this.v)
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
        PhotoUtils.a(this, paramIntent, this.jdField_c_of_type_JavaUtilArrayList, this.jdField_l_of_type_Int, true);
      }
      this.jdField_h_of_type_JavaLangString = paramIntent.getStringExtra("PhotoConst.CUSTOM_SENDBTN_TEXT");
      if ((this.z) && (this.jdField_e_of_type_JavaLangString != null))
      {
        localObject = QZoneHelper.a(this.jdField_e_of_type_JavaLangString, this.jdField_j_of_type_JavaLangString);
        if ((localObject == null) || (((BaseBusinessAlbumInfo)localObject).a() == null) || (((BaseBusinessAlbumInfo)localObject).a().equals(""))) {
          break label1966;
        }
        this.jdField_k_of_type_JavaLangString = ((BaseBusinessAlbumInfo)localObject).a();
        this.jdField_l_of_type_JavaLangString = ((BaseBusinessAlbumInfo)localObject).b();
        paramIntent.putExtra("UploadPhoto.key_album_id", this.jdField_k_of_type_JavaLangString);
        paramIntent.putExtra("UploadPhoto.key_album_name", this.jdField_l_of_type_JavaLangString);
      }
      label1332:
      this.F = paramIntent.getBooleanExtra("PhotoConst.IS_JUMPTO_TROOP_ALBUM", false);
      this.G = paramIntent.getBooleanExtra("PhotoConst.UPLOAD_CHECKBOX_IS_CHECKED", false);
      this.H = paramIntent.getBooleanExtra("PhotoConst.IS_FROM_TROOP_BAR", false);
      this.I = paramIntent.getBooleanExtra("PhotoConst.IS_FROM_TROOP_REWARD", false);
      if ((this.F) || (this.H) || (this.I) || (this.an) || (this.P) || (this.O)) {
        break label1989;
      }
    }
    label1852:
    label1989:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.B = bool1;
      this.C = paramIntent.getBooleanExtra("PhotoConst.IS_SHOW_CAMERA", false);
      if (this.C) {
        this.D = paramIntent.getBooleanExtra("PhotoConst.SHOW_CAMERA_IN_VIDEO", false);
      }
      this.jdField_p_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", false);
      if (this.I)
      {
        this.jdField_a_of_type_Double = paramIntent.getDoubleExtra("maxProportion", 0.0D);
        this.jdField_b_of_type_Double = paramIntent.getDoubleExtra("minProportion", 0.0D);
        this.jdField_o_of_type_Int = paramIntent.getIntExtra("imageSizeLimit", 0);
      }
      if (this.jdField_p_of_type_Boolean)
      {
        this.jdField_e_of_type_JavaUtilHashMap = ((HashMap)paramIntent.getSerializableExtra("PasterConstants.pasters_data"));
        this.jdField_c_of_type_JavaLangString = paramIntent.getStringExtra("PasterConstants.paster_id");
        this.jdField_d_of_type_JavaLangString = paramIntent.getStringExtra("PasterConstants.paster_cate_id");
      }
      if (this.ae) {
        this.jdField_o_of_type_Int = paramIntent.getIntExtra("imageSizeLimit", 0);
      }
      this.K = paramIntent.getBooleanExtra("PhotoConst.IS_SUPPORT_VIDEO_CHECKBOX", false);
      this.jdField_n_of_type_JavaLangString = paramIntent.getStringExtra("report_from");
      this.jdField_r_of_type_Int = paramIntent.getIntExtra("PHOTOLIST_START_POSITION", -1);
      paramIntent.removeExtra("PHOTOLIST_START_POSITION");
      this.L = paramIntent.getBooleanExtra("from_health", false);
      this.M = paramIntent.getBooleanExtra("health_video", false);
      this.N = paramIntent.getBooleanExtra("readinjoy_video", false);
      if (this.L)
      {
        this.jdField_s_of_type_Int = paramIntent.getIntExtra("min_width", 200);
        this.jdField_t_of_type_Int = paramIntent.getIntExtra("min_height", 200);
        this.jdField_u_of_type_Int = paramIntent.getIntExtra("max_gif_size", 8388608);
      }
      this.O = paramIntent.getBooleanExtra("from_qqstory", false);
      this.P = paramIntent.getBooleanExtra("from_qqstory_slideshow", false);
      this.Q = paramIntent.getBooleanExtra("from_now", false);
      this.R = paramIntent.getBooleanExtra("from_nearby", false);
      this.jdField_o_of_type_JavaLangString = paramIntent.getStringExtra("from_tribe_class_name");
      this.ak = paramIntent.getBooleanExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", false);
      this.ab = paramIntent.getBooleanExtra("from_qzoneshare", false);
      this.am = paramIntent.getBooleanExtra("PhotoConst.PHOTOLIST_IS_NEED_MEDIA_INFO", false);
      this.an = paramIntent.getBooleanExtra("PhotoConst.PHOTOLIST_IS_FROM_HWUPLOAD", false);
      this.jdField_h_of_type_Long = paramIntent.getLongExtra("PhotoConst.PHOTOLIST_KEY_MAX_MEDIA_SIZE", -1L);
      return;
      this.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("ALBUM_NAME");
      this.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("ALBUM_ID");
      break;
      if ((!this.ac) && (!this.ad)) {
        break label548;
      }
      jdField_w_of_type_Int = 0;
      int i1 = 0;
      while (i1 < this.jdField_c_of_type_JavaUtilArrayList.size())
      {
        localObject = (String)this.jdField_c_of_type_JavaUtilArrayList.get(i1);
        if ((this.jdField_c_of_type_JavaUtilHashMap.containsKey(localObject)) && (AlbumUtil.a((LocalMediaInfo)this.jdField_c_of_type_JavaUtilHashMap.get(localObject)) == 1)) {
          jdField_w_of_type_Int += 1;
        }
        i1 += 1;
      }
      break label548;
      bool1 = false;
      break label877;
      bool1 = false;
      break label903;
      bool1 = false;
      break label949;
      localObject = this.jdField_e_of_type_JavaLangString;
      break label1011;
      paramIntent.putExtra("UploadPhoto.key_album_id", "");
      paramIntent.putExtra("UploadPhoto.key_album_name", "");
      break label1332;
    }
  }
  
  public void a(LocalMediaInfo paramLocalMediaInfo, int paramInt)
  {
    AlbumUtil.a();
    String str = paramLocalMediaInfo.path;
    Intent localIntent = getIntent();
    localIntent.putExtra("ALBUM_NAME", this.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("ALBUM_ID", this.jdField_b_of_type_JavaLangString);
    localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
    localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.jdField_c_of_type_JavaUtilArrayList);
    localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", str);
    localIntent.putExtra("media_info", paramLocalMediaInfo);
    if (localIntent.getBooleanExtra("PhotoConst.MULTI_PREVIEW_IN_SINGLE_MODE", false))
    {
      localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.jdField_b_of_type_JavaUtilArrayList);
      localIntent.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", paramInt);
    }
    if (this.jdField_q_of_type_Boolean)
    {
      paramLocalMediaInfo = AlbumUtil.jdField_c_of_type_JavaUtilHashMap;
      if (!paramLocalMediaInfo.containsKey(str)) {
        paramLocalMediaInfo.put(str, new Pair(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString));
      }
      b(str);
      PhotoUtils.a(this, localIntent, this.jdField_c_of_type_JavaUtilArrayList, 0, this.jdField_d_of_type_Boolean);
      return;
    }
    if (!this.jdField_r_of_type_Boolean)
    {
      localIntent.putExtra("PhotoConst.ALLOW_LOCK", false);
      localIntent.setClass(this, PhotoPreviewActivity.class);
      localIntent.putExtra("PhotoConst.IS_JUMPTO_TROOP_ALBUM", this.F);
      localIntent.putExtra("PasterConstants.pasters_data", this.jdField_e_of_type_JavaUtilHashMap);
      if (this.ad) {
        localIntent.putExtra("PhotoConst.IS_FROM_SHUOSHUO", this.ad);
      }
      localIntent.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
      localIntent.putExtra("PhotoConst.SOURCE_FROM", "FROM_SELECT_PHOTO");
      localIntent.addFlags(603979776);
      paramLocalMediaInfo = getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
      if (ReadInJoyUploadAvatarActivity.class.getName().equals(paramLocalMediaInfo)) {
        break label386;
      }
      startActivity(localIntent);
      finish();
    }
    for (;;)
    {
      AlbumUtil.a(this, true, true);
      return;
      if (100 == localIntent.getIntExtra("Business_Origin", 0))
      {
        localIntent.setClass(this, PhotoCropForPortraitActivity.class);
        localIntent.putExtra("PhotoConst.EDIT_MASK_SHAPE_TYPE", 0);
      }
      for (;;)
      {
        AlbumUtil.a(localIntent, this.jdField_b_of_type_JavaLangString, str, this.jdField_u_of_type_Boolean);
        localIntent.putExtra("PHOTOLIST_START_POSITION", this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition());
        break;
        localIntent.setClass(this, PhotoCropActivity.class);
      }
      label386:
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
    ArrayList localArrayList = new ArrayList(i2);
    while (i1 < i2)
    {
      localArrayList.add(Integer.valueOf(i1));
      i1 += 1;
    }
    localIntent.putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", localArrayList);
    localIntent.putExtra("PhotoConst.SHOW_ALBUM", true);
    localIntent.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
    jdField_m_of_type_Int = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition();
    localIntent.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", this.jdField_c_of_type_JavaUtilArrayList.indexOf(paramString));
    localIntent.setClass(this, PhotoPreviewActivity.class);
    localIntent.addFlags(603979776);
    localIntent.putExtra("PhotoConst.IS_FROM_QQSTORY_SLIDESHOW_PREVIEW", true);
    startActivity(localIntent);
    b(this);
    AlbumUtil.a(this, true, true);
  }
  
  void a(boolean paramBoolean)
  {
    AlbumUtil.a();
    Intent localIntent = getIntent();
    if (!paramBoolean)
    {
      localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.jdField_c_of_type_JavaUtilArrayList);
      if ((this.jdField_c_of_type_JavaUtilArrayList != null) && (this.jdField_c_of_type_JavaUtilArrayList.size() > 0)) {
        ReportController.b(null, "CliOper", "", this.jdField_e_of_type_JavaLangString, "0X8004072", "0X8004072", 0, this.jdField_c_of_type_JavaUtilArrayList.size(), 0, "", "", "", "");
      }
      if ((this.ac) || (this.ad) || (this.am))
      {
        localIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", this.jdField_c_of_type_JavaUtilHashMap);
        localIntent.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", 0);
      }
      localIntent.putExtra("ALBUM_NAME", this.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("ALBUM_ID", this.jdField_b_of_type_JavaLangString);
      localIntent.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
      localIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.jdField_l_of_type_Int);
      localIntent.putExtra("readSource", this.jdField_n_of_type_JavaLangString);
      localIntent.putExtra("PasterConstants.pasters_data", this.jdField_e_of_type_JavaUtilHashMap);
      localIntent.putExtra("PhotoConst.IS_JUMPTO_TROOP_ALBUM", this.F);
      localIntent.putExtra("from_qzone", this.ai);
      jdField_m_of_type_Int = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition();
      localIntent.setClass(this, PhotoPreviewActivity.class);
      localIntent.addFlags(603979776);
      if (this.ad) {
        localIntent.putExtra("PhotoConst.IS_FROM_SHUOSHUO", this.ad);
      }
      if (!this.Z) {
        break label297;
      }
      startActivityForResult(localIntent, 100010);
    }
    for (;;)
    {
      AlbumUtil.a(this, true, true);
      return;
      localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", this.jdField_m_of_type_JavaLangString);
      break;
      label297:
      if (this.L)
      {
        localIntent.putExtra("from_health", true);
        startActivityForResult(localIntent, 100010);
      }
      else
      {
        startActivity(localIntent);
        super.finish();
      }
    }
  }
  
  protected boolean a()
  {
    return false;
  }
  
  public boolean a(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    Object localObject1 = MimeHelper.a(paramLocalMediaInfo.mMimeType);
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
        QQToast.a(this, a(paramLocalMediaInfo), 1000).b(this.jdField_n_of_type_Int);
        this.jdField_a_of_type_Long = l1;
        this.S = true;
        j();
      }
      return false;
    }
    if ((this.an) && (this.jdField_h_of_type_Long != -1L) && (paramBoolean))
    {
      if ((AlbumUtil.a(paramLocalMediaInfo) == 1) && (paramLocalMediaInfo.mDuration > this.jdField_c_of_type_Long))
      {
        QQToast.a(this, "请选择时长在" + this.jdField_c_of_type_Long / 1000L / 60L + "分钟以内的视频", 0).b(this.jdField_n_of_type_Int);
        return false;
      }
      localObject2 = this.jdField_c_of_type_JavaUtilArrayList.iterator();
      for (l1 = 0L; ((Iterator)localObject2).hasNext(); l1 = FileUtils.a((String)((Iterator)localObject2).next()) + l1) {}
      if (FileUtils.a(paramLocalMediaInfo.path) + l1 > this.jdField_h_of_type_Long * 1024L * 1024L)
      {
        localObject1 = new StringBuilder().append("最多上传");
        if (this.jdField_h_of_type_Long < 1024L) {}
        for (paramLocalMediaInfo = this.jdField_h_of_type_Long + "MB";; paramLocalMediaInfo = (float)this.jdField_h_of_type_Long / 1024.0F + "G")
        {
          QQToast.a(this, paramLocalMediaInfo + "大小的图片和视频", 0).b(this.jdField_n_of_type_Int);
          return false;
        }
      }
    }
    this.S = false;
    Object localObject2 = paramLocalMediaInfo.path;
    PresendPicMgr.a();
    if (paramBoolean)
    {
      if ((this.K) && (localObject1 != null) && ("video".equals(localObject1[0])))
      {
        if (!AlbumUtil.a(this, jdField_w_of_type_Int, paramLocalMediaInfo, this.ad)) {
          return false;
        }
        this.jdField_p_of_type_Int += 1;
        jdField_w_of_type_Int += 1;
        if (this.jdField_p_of_type_Int == 1) {
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = paramLocalMediaInfo;
        }
      }
      if ((!TextUtils.isEmpty(paramLocalMediaInfo.mMimeType)) && ("image/gif".equals(paramLocalMediaInfo.mMimeType))) {
        this.jdField_q_of_type_Int += 1;
      }
      this.jdField_c_of_type_JavaUtilArrayList.add(localObject2);
      this.jdField_d_of_type_JavaUtilArrayList.add(paramLocalMediaInfo.position);
      this.jdField_d_of_type_JavaUtilHashMap.put(localObject2, Integer.valueOf(paramLocalMediaInfo.panoramaPhotoType));
      if ((this.ac) || (this.ad) || (this.am)) {
        this.jdField_c_of_type_JavaUtilHashMap.put(localObject2, paramLocalMediaInfo);
      }
      if (this.jdField_c_of_type_JavaUtilHashSet.contains(localObject2)) {
        this.jdField_c_of_type_JavaUtilHashSet.remove(localObject2);
      }
      this.jdField_b_of_type_JavaUtilHashSet.add(localObject2);
      StatisticConstants.a(getIntent(), "param_totalSelNum");
      localObject1 = getIntent();
      if (!((Intent)localObject1).hasExtra("param_initTime")) {
        ((Intent)localObject1).putExtra("param_initTime", System.currentTimeMillis());
      }
      paramLocalMediaInfo.selectStatus = 1;
      localObject1 = (LinkedHashMap)AlbumUtil.jdField_b_of_type_JavaUtilHashMap.get(this.jdField_b_of_type_JavaLangString);
      paramLocalMediaInfo = (LocalMediaInfo)localObject1;
      if (localObject1 == null)
      {
        paramLocalMediaInfo = new LinkedHashMap();
        AlbumUtil.jdField_b_of_type_JavaUtilHashMap.put(this.jdField_b_of_type_JavaLangString, paramLocalMediaInfo);
      }
      paramLocalMediaInfo.put(localObject2, Integer.valueOf(this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition()));
      paramLocalMediaInfo = AlbumUtil.jdField_c_of_type_JavaUtilHashMap;
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
      this.jdField_p_of_type_Int -= 1;
      jdField_w_of_type_Int -= 1;
      if (this.jdField_p_of_type_Int == 1) {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = paramLocalMediaInfo;
      }
    }
    if ((!TextUtils.isEmpty(paramLocalMediaInfo.mMimeType)) && ("image/gif".equals(paramLocalMediaInfo.mMimeType))) {
      this.jdField_q_of_type_Int -= 1;
    }
    this.jdField_c_of_type_JavaUtilArrayList.remove(paramLocalMediaInfo.path);
    this.jdField_d_of_type_JavaUtilArrayList.remove(paramLocalMediaInfo.position);
    this.jdField_d_of_type_JavaUtilHashMap.remove(localObject2);
    if ((this.ac) || (this.ad)) {
      this.jdField_c_of_type_JavaUtilHashMap.remove(localObject2);
    }
    if (this.jdField_b_of_type_JavaUtilHashSet.contains(paramLocalMediaInfo.path)) {
      this.jdField_b_of_type_JavaUtilHashSet.remove(paramLocalMediaInfo.path);
    }
    for (;;)
    {
      paramLocalMediaInfo.selectStatus = 2;
      StatisticConstants.a(getIntent(), "param_cancelSelNum");
      paramLocalMediaInfo = (HashMap)AlbumUtil.jdField_b_of_type_JavaUtilHashMap.get(this.jdField_b_of_type_JavaLangString);
      if (paramLocalMediaInfo != null) {
        paramLocalMediaInfo.remove(localObject2);
      }
      paramLocalMediaInfo = AlbumUtil.jdField_c_of_type_JavaUtilHashMap;
      if (!paramLocalMediaInfo.containsKey(localObject2)) {
        break;
      }
      paramLocalMediaInfo.remove(localObject2);
      break;
      this.jdField_c_of_type_JavaUtilHashSet.add(paramLocalMediaInfo.path);
    }
  }
  
  void b()
  {
    Intent localIntent = getIntent();
    localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.jdField_c_of_type_JavaUtilArrayList);
    if ((this.ac) || (this.ad) || (this.am)) {
      localIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", this.jdField_c_of_type_JavaUtilHashMap);
    }
    if (this.ag) {
      f(localIntent);
    }
    localIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.jdField_l_of_type_Int);
    localIntent.putExtra("PhotoConst.IS_SHOW_QZONE_ALBUM", this.jdField_l_of_type_Boolean);
    localIntent.putExtra("PhotoConst.PHOTO_INFOS", this.jdField_b_of_type_JavaUtilHashMap);
    localIntent.putExtra("PhotoConst.QZONE_ALBUM_NUM", jdField_f_of_type_Long);
    if (this.ai)
    {
      localIntent.putExtra("PhotoConst.IS_FROM_QZONE_AND_NEED_FILTER_RECENT_IMAGES", true);
      localIntent.putExtra("PhotoConst.RECENT_IMAGES_MAX_COUNT", QzoneConfig.getInstance().getConfig("PhotoAlbum", "MaxRecentPhotoNum", 200));
      localIntent.putExtra("PhotoConst.RECENT_IMAGES_LIMIT_SIZE", QzoneConfig.getInstance().getConfig("PhotoAlbum", "RecentPhotoLimitSize", 20480));
      localIntent.putExtra("PhotoConst.RECENT_IMAGES_LIMIT_WIDTH", QzoneConfig.getInstance().getConfig("PhotoAlbum", "RecentPhotoLimitWidth", 100));
      String str = QzoneConfig.getInstance().getConfig("PhotoAlbum", "RecentPhotoBlockPaths", "MagazineUnlock");
      ArrayList localArrayList = null;
      if (str != null) {
        localArrayList = a(str);
      }
      localIntent.putStringArrayListExtra("PhotoConst.RECENT_IMAGES_BLOCK_PATHS", localArrayList);
    }
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
      AlbumUtil.a(this, true, false);
      return;
      if (this.Q)
      {
        startActivityForResult(localIntent, 100009);
      }
      else if (this.O)
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
  
  void b(Intent paramIntent)
  {
    boolean bool;
    label59:
    int i1;
    label117:
    String str2;
    String str1;
    if (c())
    {
      paramIntent = (BusinessAlbumInfo)paramIntent.getParcelableExtra("key_selected_albuminfo");
      if (paramIntent != null)
      {
        this.jdField_k_of_type_JavaLangString = paramIntent.jdField_a_of_type_JavaLangString;
        this.jdField_l_of_type_JavaLangString = paramIntent.jdField_b_of_type_JavaLangString;
      }
      paramIntent = this.jdField_b_of_type_AndroidWidgetCheckBox;
      if ((!this.F) && (!this.G)) {
        break label228;
      }
      bool = true;
      paramIntent.setChecked(bool);
      this.G = false;
      getIntent().putExtra("PhotoConst.UPLOAD_CHECKBOX_IS_CHECKED", false);
      ThreadManager.post(new xcz(this), 8, null, true);
      if (!TextUtils.isEmpty(this.jdField_k_of_type_JavaLangString)) {
        break label240;
      }
      if (!c()) {
        break label233;
      }
      i1 = 2131435933;
      str2 = getString(i1);
      str1 = "";
      paramIntent = "";
      label131:
      if (this.jdField_c_of_type_AndroidWidgetTextView != null)
      {
        if (!"群相册".equals(str2)) {
          break label260;
        }
        this.jdField_d_of_type_AndroidWidgetTextView.setText(2131435931);
      }
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.post(new xdb(this, str2));
      getIntent().putExtra("UploadPhoto.key_album_name", str1);
      getIntent().putExtra("UploadPhoto.key_album_id", paramIntent);
      return;
      this.jdField_k_of_type_JavaLangString = paramIntent.getStringExtra("UploadPhoto.key_album_id");
      this.jdField_l_of_type_JavaLangString = paramIntent.getStringExtra("UploadPhoto.key_album_name");
      break;
      label228:
      bool = false;
      break label59;
      label233:
      i1 = 2131435932;
      break label117;
      label240:
      str2 = this.jdField_l_of_type_JavaLangString;
      str1 = this.jdField_l_of_type_JavaLangString;
      paramIntent = this.jdField_k_of_type_JavaLangString;
      break label131;
      label260:
      if (c()) {
        this.jdField_d_of_type_AndroidWidgetTextView.setText(2131435929);
      } else {
        this.jdField_d_of_type_AndroidWidgetTextView.setText(2131435930);
      }
    }
  }
  
  public void b(String paramString)
  {
    if (this.jdField_u_of_type_Boolean)
    {
      AlbumUtil.jdField_a_of_type_Long = System.currentTimeMillis();
      AlbumUtil.jdField_a_of_type_JavaUtilHashMap.put(this.jdField_b_of_type_JavaLangString, Integer.valueOf(this.jdField_a_of_type_Xdm.getCount()));
      if (!TextUtils.isEmpty(paramString))
      {
        AlbumUtil.jdField_a_of_type_JavaLangString = paramString;
        HashMap localHashMap = AlbumUtil.jdField_c_of_type_JavaUtilHashMap;
        if (localHashMap.containsKey(paramString))
        {
          paramString = (Pair)localHashMap.get(paramString);
          AlbumUtil.jdField_b_of_type_JavaLangString = (String)paramString.first;
          AlbumUtil.jdField_c_of_type_JavaLangString = (String)paramString.second;
          AlbumUtil.a(this, AlbumUtil.jdField_b_of_type_JavaLangString, AlbumUtil.jdField_c_of_type_JavaLangString);
        }
      }
    }
    AlbumUtil.c();
  }
  
  public boolean b()
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
        this.jdField_a_of_type_AndroidAppDialog = new Dialog(this, 2131624516);
        this.jdField_a_of_type_AndroidAppDialog.setCancelable(true);
        this.jdField_a_of_type_AndroidAppDialog.show();
        this.jdField_a_of_type_AndroidAppDialog.setContentView(2130969178);
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
      QLog.e("PhotoListActivity", 2, "cancel dialog error", localIllegalArgumentException);
    }
  }
  
  public void e()
  {
    Object localObject1;
    boolean bool1;
    if (this.jdField_h_of_type_JavaLangString != null)
    {
      localObject1 = this.jdField_h_of_type_JavaLangString;
      if (this.jdField_c_of_type_JavaUtilArrayList.size() <= 0) {
        break label407;
      }
      bool1 = true;
      label24:
      Object localObject2 = localObject1;
      if (bool1) {
        localObject2 = (String)localObject1 + "(" + this.jdField_c_of_type_JavaUtilArrayList.size() + ")";
      }
      if (QLog.isColorLevel()) {
        QLog.d("_photo", 2, "updateButton selectedPhotoList.size()=" + this.jdField_c_of_type_JavaUtilArrayList.size());
      }
      this.jdField_c_of_type_AndroidWidgetButton.setText((CharSequence)localObject2);
      this.jdField_c_of_type_AndroidWidgetButton.setEnabled(bool1);
      this.jdField_b_of_type_AndroidWidgetButton.setEnabled(bool1);
      if (((this.K) && (!this.ad) && (!this.ac)) || ((this.jdField_b_of_type_JavaUtilHashMap != null) && (this.jdField_b_of_type_JavaUtilHashMap.size() > 0))) {
        this.jdField_b_of_type_AndroidWidgetButton.setVisibility(4);
      }
      if (!bool1)
      {
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
        this.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(false);
        this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
        this.jdField_b_of_type_AndroidWidgetTextView.setEnabled(false);
      }
      if (!this.jdField_m_of_type_Boolean) {
        break label417;
      }
      if (bool1)
      {
        this.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(true);
        this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
        this.jdField_b_of_type_AndroidWidgetTextView.setEnabled(true);
        localObject1 = this.jdField_a_of_type_AndroidWidgetButton;
        if ((this.jdField_c_of_type_JavaUtilArrayList.size() != 1) || (this.F)) {
          break label412;
        }
      }
    }
    label407:
    label412:
    for (boolean bool2 = true;; bool2 = false)
    {
      ((Button)localObject1).setEnabled(bool2);
      if (this.jdField_n_of_type_Boolean)
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
      g();
      if (!this.jdField_o_of_type_Boolean) {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      return;
      if (this.F)
      {
        localObject1 = getString(2131435922);
        break;
      }
      if (this.jdField_m_of_type_Boolean)
      {
        localObject1 = getString(2131435920);
        break;
      }
      localObject1 = getString(2131435921);
      break;
      bool1 = false;
      break label24;
    }
    label417:
    if (this.jdField_p_of_type_Boolean) {
      if ((this.jdField_c_of_type_JavaUtilArrayList.size() == 1) && ((this.jdField_b_of_type_JavaUtilHashMap == null) || (this.jdField_b_of_type_JavaUtilHashMap.size() <= 0))) {
        if (((this.ad) || (this.ac)) && (a((String)this.jdField_c_of_type_JavaUtilArrayList.get(0)))) {
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
  
  public void f()
  {
    int i2 = 0;
    Object localObject = this.jdField_c_of_type_JavaUtilArrayList.iterator();
    int i1 = 0;
    int i3;
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      long l1 = new File(str).length();
      i3 = (int)(i1 + l1);
      i1 = i3;
      if (QLog.isColorLevel())
      {
        QLog.d("_photo", 2, "setQualityTextViewText, path:" + str + ",len:" + l1);
        i1 = i3;
      }
    }
    localObject = PhotoUtils.a(this, i1);
    if (((String)localObject).equals("0"))
    {
      localObject = "(999K)";
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
    }
    for (;;)
    {
      i3 = ((String)localObject).length();
      i1 = i2;
      while (i1 < 6 - i3)
      {
        localObject = (String)localObject + " ";
        i1 += 1;
      }
      localObject = "(" + (String)localObject + ")";
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
  }
  
  public void finish()
  {
    super.finish();
  }
  
  public void g()
  {
    switch (this.jdField_l_of_type_Int)
    {
    case 1: 
    default: 
      return;
    case 0: 
      this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      return;
    }
    f();
    this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
  }
  
  public void h()
  {
    if (QavCameraUsage.b(BaseApplicationImpl.getContext())) {}
    label41:
    do
    {
      Intent localIntent;
      do
      {
        return;
        localIntent = new Intent("android.media.action.IMAGE_CAPTURE");
      } while (localIntent.resolveActivity(getPackageManager()) == null);
      Object localObject = null;
      try
      {
        File localFile = a();
        localObject = localFile;
      }
      catch (IOException localIOException)
      {
        break label41;
      }
    } while (localObject == null);
    localIntent.putExtra("output", Uri.fromFile(localObject));
    startActivityForResult(localIntent, 16);
  }
  
  public void i()
  {
    if (this.jdField_b_of_type_JavaLangString.equals("$RecentAlbumId"))
    {
      StatisticCollector.a(this).a(null, "sendAlbumRecent", true, 0L, 0L, null, "");
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
      StatisticConstants.b(getIntent(), this.jdField_c_of_type_JavaUtilArrayList.size());
      localObject = getIntent();
      ((Intent)localObject).putExtra("open_chatfragment_fromphoto", true);
      AIOGalleryUtils.a(this, (Intent)localObject, this.jdField_e_of_type_JavaLangString, this.jdField_j_of_type_JavaLangString, this.jdField_i_of_type_JavaLangString, this.jdField_k_of_type_JavaLangString, this.jdField_l_of_type_JavaLangString, this.jdField_l_of_type_Int, this.jdField_c_of_type_JavaUtilArrayList, 42);
      return;
      if ((this.jdField_a_of_type_JavaLangString.equalsIgnoreCase("Camera")) || (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase("camera")) || (this.jdField_a_of_type_JavaLangString.contains("Camera")) || (this.jdField_a_of_type_JavaLangString.contains("camera")))
      {
        StatisticCollector.a(this).a(null, "sendAlbumRecent", false, 0L, 0L, null, "");
        break;
      }
      StatisticCollector.a(this).a(null, "sendAlbumOther", true, 0L, 0L, null, "");
      break;
    }
    label244:
    if ((this.jdField_p_of_type_Boolean) && ((!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) || (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))))
    {
      this.jdField_a_of_type_AndroidWidgetButton.performClick();
      return;
    }
    if (this.jdField_c_of_type_JavaUtilArrayList != null)
    {
      StatisticConstants.a(getIntent(), this.jdField_c_of_type_JavaUtilArrayList.size());
      StatisticConstants.a(getIntent(), this.jdField_c_of_type_JavaUtilArrayList.size(), this.jdField_l_of_type_Int);
    }
    Intent localIntent = getIntent();
    if (this.Z)
    {
      localObject = new Intent();
      ((Intent)localObject).putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.jdField_c_of_type_JavaUtilArrayList);
      super.setResult(-1, (Intent)localObject);
      super.finish();
      AlbumUtil.a(this, false, false);
      return;
    }
    if (this.jdField_l_of_type_Int == 2)
    {
      if (localObject != null)
      {
        ((PresendPicMgr)localObject).a(1008);
        ((PresendPicMgr)localObject).a();
      }
      ReportController.b(null, "CliOper", "", "", "0X8005148", "0X8005148", 0, 0, "", "", "", "");
      localObject = localIntent.getStringExtra("PhotoConst.PLUGIN_APK");
      String str = localIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
      if (("qzone_plugin.apk".equals(localObject)) && ("com.qzone.video.activity.TrimVideoActivity".equals(str)))
      {
        localIntent.putExtra("PhotoConst.PLUGIN_NAME", "QZone");
        localIntent.putExtra("PhotoConst.PLUGIN_APK", "qzone_plugin.apk");
        localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", "com.qzone.publish.ui.activity.QZonePublishMoodActivity");
      }
      if ("qzone_plugin.apk".equals(localObject)) {
        localIntent.putExtra("isEmbedInTabActivity", getIntent().getBooleanExtra("isEmbedInTabActivity", false));
      }
      if ((this.ac) || ((this.ad) && (jdField_a_of_type_Boolean)) || (this.af) || (this.am)) {
        localIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", this.jdField_c_of_type_JavaUtilHashMap);
      }
      if (this.ag) {
        f(localIntent);
      }
      if (this.jdField_c_of_type_JavaUtilArrayList != null) {
        NewFlowCameraReporter.a(this.jdField_c_of_type_JavaUtilArrayList);
      }
      e(localIntent);
      localIntent.putExtra("PhotoConst.PANORAMA_IMAGES", this.jdField_d_of_type_JavaUtilHashMap);
      if ((c()) && (this.jdField_b_of_type_AndroidWidgetCheckBox != null) && (this.jdField_b_of_type_AndroidWidgetCheckBox.isChecked()))
      {
        localIntent.putExtra("key_is_sync_qzone", 1);
        if (this.jdField_k_of_type_JavaLangString == null) {
          break label782;
        }
      }
    }
    label782:
    for (Object localObject = this.jdField_k_of_type_JavaLangString;; localObject = "")
    {
      localIntent.putExtra("key_qzone_album_id", (String)localObject);
      localIntent.putExtra("key_qzone_batch_id", PhotoUtils.a());
      if (this.jdField_c_of_type_JavaUtilArrayList != null) {
        localIntent.putExtra("PhotoConst.PHOTO_COUNT", this.jdField_c_of_type_JavaUtilArrayList.size());
      }
      localObject = new LpReportInfo_pf00064(723, 2, 5);
      LpReportManager.getInstance().reportToPF00064((LpReportInfo_pf00064)localObject, false, false);
      RetentionReport.a(8);
      a("aio_sync_qzone", "operation_type", "photo_list_upload");
      PhotoUtils.a(this, localIntent, this.jdField_c_of_type_JavaUtilArrayList, this.jdField_l_of_type_Int, this.jdField_d_of_type_Boolean);
      return;
      if ((localObject == null) || (this.ak)) {
        break;
      }
      ((PresendPicMgr)localObject).a(localIntent);
      break;
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((QLog.isDevelopLevel()) && (this.jdField_c_of_type_JavaUtilArrayList != null) && (this.jdField_c_of_type_JavaUtilArrayList.size() != 0)) {
      QLog.d("PhotoListActivity", 4, "[PhotoListActivity] [onActivityResult] selectedPhotoList = " + this.jdField_c_of_type_JavaUtilArrayList.size());
    }
    if ((this.z) && (paramIntent != null) && ((paramInt1 == 100) || (paramInt1 == 100009)) && (paramInt2 == -1))
    {
      b(paramIntent);
      this.jdField_b_of_type_AndroidWidgetCheckBox.setChecked(true);
      return;
    }
    if (((this.O) || (this.P)) && (paramInt2 == -1))
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
    if ((this.Q) && (paramInt1 == 2) && (paramInt2 == -1))
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
        if (!this.N) {
          break label557;
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
        paramIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.jdField_l_of_type_Int);
        setResult(-1, paramIntent);
        super.finish();
        return;
        if (paramIntent == null) {
          break;
        }
        this.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("ALBUM_NAME");
        this.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("ALBUM_ID");
        this.jdField_l_of_type_Int = paramIntent.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
        if (this.jdField_a_of_type_JavaLangString != null) {}
        for (localObject = this.jdField_a_of_type_JavaLangString;; localObject = "最近照片")
        {
          setTitle((CharSequence)localObject);
          runOnUiThread(new xdc(this));
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
        }
        if (this.Z)
        {
          localObject = new Intent();
          ((Intent)localObject).putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.jdField_c_of_type_JavaUtilArrayList);
          super.setResult(-1, (Intent)localObject);
          super.finish();
          AlbumUtil.a(this, false, false);
          continue;
          if (this.M)
          {
            super.setResult(-1, paramIntent);
            super.finish();
          }
        }
      }
      label557:
      if (this.aa)
      {
        super.setResult(-1, paramIntent);
        super.finish();
      }
    }
    else
    {
      if (paramInt1 == 17)
      {
        if ((this.N) && (paramIntent != null) && (!paramIntent.getBooleanExtra("INTENT_VALUE_CANCEL_IN_PREVIEW_ACTIVITY", false)))
        {
          super.setResult(0, paramIntent);
          super.finish();
        }
        AlbumUtil.jdField_a_of_type_Long = 0L;
        return;
      }
      if ((paramInt1 == 10002) && (this.P) && (paramIntent != null))
      {
        localObject = paramIntent.getStringExtra("PhotoConst.FROM_QQSTORY_SLIDESHOW_DATA");
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          FileUtils.a(new File((String)localObject).getParent());
        }
      }
    }
    PhotoUtils.a(this, paramInt1, paramInt2, paramIntent, this.jdField_s_of_type_Boolean, this.jdField_e_of_type_JavaLangString);
  }
  
  public void onBackPressed()
  {
    this.jdField_w_of_type_Boolean = true;
    if ((this.L) || (this.M))
    {
      finish();
      AlbumUtil.a(this, false, false);
      return;
    }
    if (this.Z)
    {
      super.setResult(-1, new Intent());
      super.finish();
      AlbumUtil.a(this, false, false);
      return;
    }
    if ((this.O) || (this.P))
    {
      finish();
      AlbumUtil.a(this, false, false);
      return;
    }
    if (this.Q)
    {
      finish();
      AlbumUtil.a(this, false, false);
      return;
    }
    b();
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
        paramCompoundButton = new QQCustomDialog(this, 2131624516);
        paramCompoundButton.setContentView(2130968855);
        paramCompoundButton.setTitle(getString(2131429887));
        paramCompoundButton.setMessage(getString(2131429889));
        paramCompoundButton.setNegativeButton(getString(2131429890), new xcq(this));
        paramCompoundButton.setCanceledOnTouchOutside(false);
        paramCompoundButton.setCancelable(false);
        paramCompoundButton.show();
        QZoneClickReport.startReportImediately(this.jdField_e_of_type_JavaLangString, "40", "1");
        return;
      }
      this.F = paramBoolean;
      getIntent().putExtra("PhotoConst.IS_JUMPTO_TROOP_ALBUM", this.F);
      e();
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
          ThreadManager.post(new xcr(this, i1, paramCompoundButton), 8, null, true);
          return;
          i1 = 3;
          break;
        }
        if (paramBoolean)
        {
          i1 = a(jdField_a_of_type_Int);
          if (this.aj) {
            i1 = a(6291456);
          }
          if (i1 > 0)
          {
            QQToast.a(this, getResources().getString(2131435938), 0).b(getResources().getDimensionPixelSize(2131558448));
            this.jdField_l_of_type_Int = 0;
            this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
            this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
          }
        }
        while (!this.jdField_o_of_type_Boolean)
        {
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          return;
          this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
          this.jdField_l_of_type_Int = 2;
          f();
          continue;
          this.jdField_l_of_type_Int = 0;
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
    label948:
    label976:
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
                b();
                return;
              }
              if ((this.O) || (this.P))
              {
                b();
                StoryReportor.a("pic_choose_slides", "exp_albumList", 0, 0, new String[0]);
                return;
              }
              if (this.Q)
              {
                b();
                return;
              }
              onBackPressed();
              return;
              AlbumUtil.c();
              AlbumUtil.a();
              if (this.L)
              {
                super.setResult(0);
                super.finish();
                AlbumUtil.a(this, false, false);
                return;
              }
              if (this.Z)
              {
                paramView = new Intent(getIntent());
                paramView.removeExtra("ALBUM_NAME");
                paramView.removeExtra("weiyun_filter_data");
                paramView.setClass(this, AlbumListActivity.class);
                startActivity(paramView);
                return;
              }
              if (this.N)
              {
                super.setResult(0, getIntent());
                super.finish();
                AlbumUtil.a(this, false, false);
                return;
              }
              paramView = PresendPicMgr.a();
              if (paramView != null) {
                paramView.a(1006);
              }
              paramView = getIntent();
              if (this.jdField_c_of_type_JavaUtilArrayList != null) {}
              for (i1 = this.jdField_c_of_type_JavaUtilArrayList.size();; i1 = 0)
              {
                StatisticConstants.b(paramView, i1);
                if (this.jdField_t_of_type_Boolean) {
                  break;
                }
                super.finish();
                AlbumUtil.a(this, false, false);
                return;
              }
              paramView = getIntent();
              localObject1 = paramView.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
              localObject2 = paramView.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
              if (localObject1 == null)
              {
                QQToast.a(this, "请设置INIT_ACTIVITY_CLASS_NAME ", 0).a();
                return;
              }
              paramView.setClassName((String)localObject2, (String)localObject1);
              paramView.removeExtra("PhotoConst.PHOTO_PATHS");
              paramView.removeExtra("PhotoConst.SINGLE_PHOTO_PATH");
              if (this.ac) {
                paramView.removeExtra("PeakConstants.selectedMediaInfoHashMap");
              }
              paramView.addFlags(603979776);
              if (!paramView.getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false)) {
                startActivity(paramView);
              }
              for (;;)
              {
                super.finish();
                AlbumUtil.a(this, false, false);
                return;
                paramView.getStringExtra("PhotoConst.PLUGIN_NAME");
                localObject2 = paramView.getStringExtra("PhotoConst.PLUGIN_APK");
                String str = paramView.getStringExtra("PhotoConst.UIN");
                if ("qzone_plugin.apk".equals(localObject2))
                {
                  QzonePluginProxyActivity.a(paramView, (String)localObject1);
                  QZoneHelper.a(this, str, paramView, 2);
                }
                else if ("qqfav.apk".equals(localObject2))
                {
                  QfavHelper.a(this, str, paramView, 2);
                }
                else
                {
                  QLog.e("PhotoListActivity", 1, "Watermark has been deleted!");
                }
              }
              if (!this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked())
              {
                i1 = a(jdField_a_of_type_Int);
                if (this.aj) {
                  i1 = a(6291456);
                }
                if (i1 > 0)
                {
                  QQToast.a(this, getResources().getString(2131435938), 0).b(getResources().getDimensionPixelSize(2131558448));
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
            ReportController.b(null, "CliOper", "", "", "0x8004B39", "0x8004B39", 0, 0, "", "", "", "");
            if (!TextUtils.isEmpty(this.jdField_o_of_type_JavaLangString))
            {
              if (TroopBarPublishActivity.class.getSimpleName().equals(this.jdField_o_of_type_JavaLangString)) {
                TribeUtils.a("pub_page_new", "clk_photo_edit", 0, 0, new String[0]);
              }
            }
            else
            {
              if (!VersionUtils.d()) {
                break label976;
              }
              new Intent();
              if (!this.jdField_p_of_type_Boolean) {
                break label948;
              }
              paramView = new HashMap(1);
              if ((this.jdField_c_of_type_JavaUtilHashMap != null) && (this.jdField_c_of_type_JavaUtilHashMap.get(this.jdField_c_of_type_JavaUtilArrayList.get(0)) != null)) {
                paramView.put("param_localmediainfo", this.jdField_c_of_type_JavaUtilHashMap.get(this.jdField_c_of_type_JavaUtilArrayList.get(0)));
              }
              paramView = EditPicActivity.a(this, (String)this.jdField_c_of_type_JavaUtilArrayList.get(0), true, true, true, true, true, 3, 99, 5, paramView);
            }
            for (;;)
            {
              e(paramView);
              startActivity(paramView);
              this.jdField_a_of_type_AndroidWidgetButton.setClickable(false);
              return;
              if (!TroopBarReplyActivity.class.getSimpleName().equals(this.jdField_o_of_type_JavaLangString)) {
                break;
              }
              TribeUtils.a("reply", "clk_photo_edit", 0, 0, new String[0]);
              break;
              paramView = EditPicActivity.a(this, (String)this.jdField_c_of_type_JavaUtilArrayList.get(0), true, true, true, true, true, 2, 99, 5);
              continue;
              paramView = EditPicActivity.a(this, (String)this.jdField_c_of_type_JavaUtilArrayList.get(0), true, true, true, true, true, 2, 99, 5);
            }
            a(false);
            return;
            this.jdField_c_of_type_AndroidWidgetButton.setClickable(false);
            if (!this.jdField_c_of_type_JavaUtilArrayList.isEmpty()) {
              b((String)this.jdField_c_of_type_JavaUtilArrayList.get(this.jdField_c_of_type_JavaUtilArrayList.size() - 1));
            }
            AlbumUtil.a();
            if (this.jdField_c_of_type_JavaUtilArrayList.size() != 0) {
              break label1081;
            }
          } while (!QLog.isColorLevel());
          QLog.e("PhotoList", 2, "size == 0");
          return;
          Object localObject2 = getIntent();
          if (((Intent)localObject2).getBooleanExtra("PhotoConst.IS_SEND_FILESIZE_LIMIT", false))
          {
            paramView = this.jdField_c_of_type_JavaUtilArrayList.iterator();
            for (long l1 = 0L; paramView.hasNext(); l1 = FileUtils.a((String)paramView.next()) + l1) {}
            if (FileManagerUtil.a())
            {
              FMDialogUtil.a(this, 2131428241, 2131428237, new xcs(this));
              return;
            }
          }
          if (this.L)
          {
            paramView = new Intent();
            paramView.putStringArrayListExtra("img_list", this.jdField_c_of_type_JavaUtilArrayList);
            super.setResult(-1, paramView);
            super.finish();
            AlbumUtil.a(this, false, false);
            return;
          }
          if (this.ab)
          {
            localObject1 = ((Intent)localObject2).getStringExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME");
            paramView = (View)localObject1;
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              paramView = ((Intent)localObject2).getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
            }
            ((Intent)localObject2).addFlags(603979776);
            QzonePluginProxyActivity.a((Intent)localObject2, paramView);
            QZoneHelper.a(this, QZoneHelper.UserInfo.a(), (Intent)localObject2, -1, null);
            return;
          }
          i();
          return;
          if (!this.E)
          {
            this.jdField_b_of_type_AndroidWidgetCheckBox.setChecked(false);
            paramView = new QQCustomDialog(this, 2131624516);
            paramView.setContentView(2130968855);
            paramView.setTitle(getString(2131429887));
            paramView.setMessage(getString(2131429889));
            paramView.setNegativeButton(getString(2131429890), new xct(this));
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
              break label1459;
            }
            bool = true;
            paramView.setChecked(bool);
          }
        } while (this.jdField_b_of_type_AndroidWidgetCheckBox == null);
        if (this.jdField_b_of_type_AndroidWidgetCheckBox.isChecked()) {}
        for (paramView = "0X80047F8";; paramView = "0X80047F9")
        {
          ReportController.b(null, "CliOper", "", "", paramView, paramView, 0, 0, this.jdField_e_of_type_JavaLangString, "", "", "");
          return;
          bool = false;
          break;
        }
        if (this.jdField_k_of_type_Int == 1)
        {
          if (!this.E)
          {
            this.jdField_b_of_type_AndroidWidgetCheckBox.setChecked(false);
            paramView = new QQCustomDialog(this, 2131624516);
            paramView.setContentView(2130968855);
            paramView.setTitle(getString(2131429887));
            paramView.setMessage(getString(2131429889));
            paramView.setNegativeButton(getString(2131429890), new xcu(this));
            paramView.setCanceledOnTouchOutside(false);
            paramView.setCancelable(false);
            paramView.show();
            QZoneClickReport.startReportImediately(this.jdField_e_of_type_JavaLangString, "40", "1");
            return;
          }
          paramView = QZoneHelper.UserInfo.a();
          paramView.jdField_a_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
          paramView.jdField_b_of_type_JavaLangString = this.jdField_i_of_type_JavaLangString;
          QZoneHelper.c(this, paramView, this.jdField_j_of_type_JavaLangString, this.jdField_i_of_type_JavaLangString, 100);
          return;
        }
      } while (!c());
      paramView = QZoneHelper.UserInfo.a();
      paramView.jdField_a_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
      paramView.jdField_b_of_type_JavaLangString = this.jdField_i_of_type_JavaLangString;
      localObject1 = new Bundle();
      ((Bundle)localObject1).putInt("key_personal_album_enter_model", 0);
      ((Bundle)localObject1).putString("key_title", getString(2131432462));
      ((Bundle)localObject1).putBoolean("key_personal_album_is_select_video", false);
      if (!TextUtils.isEmpty(this.jdField_k_of_type_JavaLangString))
      {
        ((Bundle)localObject1).putString("key_default_album_id", this.jdField_k_of_type_JavaLangString);
        ((Bundle)localObject1).putBoolean("key_from_upload", true);
      }
      QZoneHelper.a(this, paramView, (Bundle)localObject1, 100009);
      paramView = new LpReportInfo_pf00064(723, 2, 4);
      LpReportManager.getInstance().reportToPF00064(paramView, false, false);
      a("aio_sync_qzone", "operation_type", "photo_list_select_album");
      return;
    } while (this.jdField_b_of_type_AndroidWidgetCheckBox == null);
    label1081:
    if (this.jdField_b_of_type_AndroidWidgetCheckBox.isChecked())
    {
      paramView = "0X80047F8";
      if ((b()) && (this.B) && (this.jdField_b_of_type_AndroidWidgetCheckBox != null))
      {
        if (!c()) {
          break label1900;
        }
        localObject1 = "qzone_will_upload_to_personal_album";
        if ((Build.VERSION.SDK_INT < 9) || (!TextUtils.isEmpty(this.jdField_k_of_type_JavaLangString))) {
          break label1928;
        }
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean((String)localObject1, this.jdField_b_of_type_AndroidWidgetCheckBox.isChecked()).apply();
      }
    }
    for (;;)
    {
      label1459:
      ReportController.a(null, "CliOper", "", "", paramView, paramView, 0, 0, this.jdField_e_of_type_JavaLangString, "", "", "");
      label1821:
      return;
      paramView = "0X80047F9";
      break;
      label1900:
      localObject1 = "qzone_will_upload_to_qun_album" + this.jdField_j_of_type_JavaLangString;
      break label1821;
      label1928:
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean((String)localObject1, this.jdField_b_of_type_AndroidWidgetCheckBox.isChecked()).commit();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().setBackgroundDrawable(null);
    try
    {
      super.setContentView(2130970534);
      getWindow().setBackgroundDrawable(null);
      this.jdField_a_of_type_AndroidContentSharedPreferences = BaseApplication.getContext().getSharedPreferences("share", 4);
      paramBundle = getResources();
      int i1 = paramBundle.getDisplayMetrics().widthPixels;
      this.jdField_f_of_type_Int = paramBundle.getDimensionPixelSize(2131558597);
      this.jdField_d_of_type_Int = paramBundle.getDimensionPixelSize(2131558595);
      this.jdField_e_of_type_Int = paramBundle.getDimensionPixelSize(2131558596);
      this.jdField_g_of_type_Int = AIOUtils.a(1.0F, paramBundle);
      this.jdField_b_of_type_Int = ((i1 - this.jdField_f_of_type_Int * 2 - this.jdField_d_of_type_Int * 2) / 3);
      this.jdField_c_of_type_Int = this.jdField_b_of_type_Int;
      paramBundle = getIntent();
      a(paramBundle);
      a();
      if (QLog.isColorLevel()) {
        QLog.d("SelectPhotoTrace", 2, "PhotoListActivity onCreate(),extra is:" + paramBundle.getExtras());
      }
      if (QLog.isColorLevel()) {
        QLog.d("SelectPhotoTrace", 2, "PhotoListActivity,hashCode is:" + System.identityHashCode(this));
      }
      if (this.jdField_l_of_type_Boolean)
      {
        paramBundle = new NewIntent(BaseApplicationImpl.getApplication(), QZoneAlbumListNumServlet.class);
        paramBundle.putExtra("selfuin", Long.valueOf(BaseApplicationImpl.getApplication().getRuntime().getAccount()));
        BaseApplicationImpl.getApplication().getRuntime().registObserver(jdField_a_of_type_Xdo);
        BaseApplicationImpl.getApplication().getRuntime().startServlet(paramBundle);
      }
      return;
    }
    catch (Throwable paramBundle)
    {
      super.finish();
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (!this.jdField_w_of_type_Boolean) {
      AlbumThumbManager.a(this).a();
    }
    if (this.jdField_a_of_type_Xdm != null)
    {
      int i1 = this.jdField_a_of_type_Xdm.getCount();
      AlbumUtil.jdField_a_of_type_JavaUtilHashMap.put(this.jdField_b_of_type_JavaLangString, Integer.valueOf(i1));
    }
    if (this.jdField_l_of_type_Boolean) {
      BaseApplicationImpl.getApplication().getRuntime().unRegistObserver(jdField_a_of_type_Xdo);
    }
    jdField_a_of_type_JavaUtilArrayList = null;
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowPhotoListManager != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowPhotoListManager.b();
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
      this.al = false;
      a(paramIntent);
      QLog.d("PhotoListActivity", 2, "PhotoListActivity onNewIntent() camera back");
      return;
    }
    setIntent(paramIntent);
    a(paramIntent);
  }
  
  protected void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_AndroidOsAsyncTask = null;
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_AndroidWidgetButton != null) {
      this.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowPhotoListManager != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowPhotoListManager.a();
    }
  }
  
  protected void onStart()
  {
    super.onStart();
    if (this.al)
    {
      runOnUiThread(new xdd(this));
      return;
    }
    this.al = true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (this.ap) && (this.z) && (this.jdField_e_of_type_JavaLangString != null))
    {
      b(getIntent());
      this.ap = false;
    }
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