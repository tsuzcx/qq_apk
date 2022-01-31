package com.tencent.mobileqq.activity.photo;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.biz.qqstory.takevideo.SlideShowPhotoListManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.activity.aio.photo.PeakActivity;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraReporter;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.camera.utils.CameraUtils;
import com.tencent.mobileqq.pic.IPresendPicMgr.Stub;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;
import com.tencent.mobileqq.troop.activity.TroopBarReplyActivity;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.video.IMediaPlayer;
import com.tencent.mobileqq.video.IMediaPlayer.OnPlayStateListener;
import com.tencent.mobileqq.video.IMediaPlayer.OnPreparedListener;
import com.tencent.mobileqq.video.LocalVideoMediaPlayer;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;
import com.tencent.widget.BubblePopupWindow;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.model.BaseBusinessAlbumInfo;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import wuw;
import wux;
import wuy;
import wuz;
import wva;
import wvb;
import wvc;
import wvd;
import wve;
import wvf;
import wvg;
import wvh;
import wvi;
import wvk;
import wvl;
import wvm;
import wvn;

public class PhotoPreviewActivity
  extends PeakActivity
  implements CompoundButton.OnCheckedChangeListener
{
  static int jdField_a_of_type_Int = 19922944;
  private boolean A;
  private boolean B;
  private boolean C;
  private float jdField_a_of_type_Float = 13.0F;
  public long a;
  SurfaceHolder.Callback jdField_a_of_type_AndroidViewSurfaceHolder$Callback = new wva(this);
  public SurfaceView a;
  View jdField_a_of_type_AndroidViewView;
  public Button a;
  public CheckBox a;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public ProGallery a;
  private IMediaPlayer.OnPlayStateListener jdField_a_of_type_ComTencentMobileqqVideoIMediaPlayer$OnPlayStateListener = new wvd(this);
  private IMediaPlayer.OnPreparedListener jdField_a_of_type_ComTencentMobileqqVideoIMediaPlayer$OnPreparedListener = new wvc(this);
  public IMediaPlayer a;
  public NumberCheckBox a;
  BubblePopupWindow jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
  public String a;
  public ArrayList a;
  HashMap jdField_a_of_type_JavaUtilHashMap;
  wvn jdField_a_of_type_Wvn;
  boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float = 9.0F;
  int jdField_b_of_type_Int;
  View jdField_b_of_type_AndroidViewView;
  public Button b;
  public CheckBox b;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  String jdField_b_of_type_JavaLangString;
  public ArrayList b;
  public HashMap b;
  public boolean b;
  public int c;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  String jdField_c_of_type_JavaLangString;
  public ArrayList c;
  private HashMap jdField_c_of_type_JavaUtilHashMap;
  public int d;
  public TextView d;
  String jdField_d_of_type_JavaLangString;
  boolean jdField_d_of_type_Boolean = false;
  public int e;
  TextView e;
  public String e;
  public boolean e;
  int jdField_f_of_type_Int = 0;
  public String f;
  boolean jdField_f_of_type_Boolean;
  public int g;
  String jdField_g_of_type_JavaLangString = null;
  boolean jdField_g_of_type_Boolean;
  public int h;
  String h;
  public boolean h;
  public int i;
  String i;
  public boolean i;
  public int j;
  String j;
  public boolean j;
  public int k;
  String jdField_k_of_type_JavaLangString;
  boolean jdField_k_of_type_Boolean;
  public int l;
  String jdField_l_of_type_JavaLangString;
  boolean jdField_l_of_type_Boolean;
  public int m;
  String jdField_m_of_type_JavaLangString;
  boolean jdField_m_of_type_Boolean = false;
  public int n;
  String jdField_n_of_type_JavaLangString;
  boolean jdField_n_of_type_Boolean = false;
  public int o;
  String jdField_o_of_type_JavaLangString = "";
  boolean jdField_o_of_type_Boolean = false;
  public int p;
  public String p;
  boolean p;
  public int q;
  boolean q;
  public int r;
  public boolean r;
  private int s;
  public boolean s;
  public boolean t;
  public boolean u = false;
  boolean v = false;
  public boolean w;
  private boolean x;
  private boolean y;
  private boolean z;
  
  public PhotoPreviewActivity()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_p_of_type_Boolean = false;
    this.jdField_e_of_type_Int = 0;
    this.jdField_q_of_type_Boolean = false;
    this.jdField_m_of_type_Int = 1007;
    this.jdField_a_of_type_ComTencentMobileqqVideoIMediaPlayer = new LocalVideoMediaPlayer();
  }
  
  private int a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (a(paramString) == null)) {
      return -1;
    }
    return AlbumUtil.a(a(paramString));
  }
  
  private LocalMediaInfo a(String paramString)
  {
    LocalMediaInfo localLocalMediaInfo1 = null;
    if (this.jdField_b_of_type_JavaUtilHashMap != null) {
      localLocalMediaInfo1 = (LocalMediaInfo)this.jdField_b_of_type_JavaUtilHashMap.get(paramString);
    }
    LocalMediaInfo localLocalMediaInfo2 = localLocalMediaInfo1;
    if (localLocalMediaInfo1 == null)
    {
      localLocalMediaInfo2 = localLocalMediaInfo1;
      if (PhotoListActivity.jdField_a_of_type_JavaUtilHashMap != null) {
        if (!this.jdField_r_of_type_Boolean)
        {
          localLocalMediaInfo2 = localLocalMediaInfo1;
          if (!this.t) {}
        }
        else
        {
          localLocalMediaInfo2 = (LocalMediaInfo)PhotoListActivity.jdField_a_of_type_JavaUtilHashMap.get(paramString);
        }
      }
    }
    return localLocalMediaInfo2;
  }
  
  private URL a(File paramFile)
  {
    if (paramFile == null) {
      return null;
    }
    String str = paramFile.getPath();
    if ((!TextUtils.isEmpty(str)) && (a(str) == 1)) {
      return AlbumUtil.a(str, "VIDEO");
    }
    try
    {
      paramFile = paramFile.toURI().toURL();
      return paramFile;
    }
    catch (MalformedURLException paramFile) {}
    return null;
  }
  
  private void b(int paramInt)
  {
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
  
  private int c()
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
  
  public int a()
  {
    Iterator localIterator = this.jdField_c_of_type_JavaUtilArrayList.iterator();
    int i1 = 0;
    if (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      if ((localInteger == null) || (localInteger.intValue() < 0) || (localInteger.intValue() >= this.jdField_a_of_type_JavaUtilArrayList.size()) || (new File((String)this.jdField_a_of_type_JavaUtilArrayList.get(localInteger.intValue())).length() <= jdField_a_of_type_Int)) {
        break label95;
      }
      i1 += 1;
    }
    label95:
    for (;;)
    {
      break;
      return i1;
    }
  }
  
  public String a()
  {
    if ((this.jdField_k_of_type_Boolean) || (this.jdField_l_of_type_Boolean)) {
      return "已达" + this.jdField_c_of_type_Int + "张上限";
    }
    return "最多只能选择" + this.jdField_c_of_type_Int + "张图片";
  }
  
  public String a(int paramInt)
  {
    return LocalVideoMediaPlayer.a(paramInt);
  }
  
  ArrayList a()
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.C) || (this.jdField_b_of_type_JavaUtilArrayList.isEmpty()))
    {
      int i1 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoProGallery.getFirstVisiblePosition();
      if (i1 < this.jdField_a_of_type_JavaUtilArrayList.size()) {
        localArrayList.add(this.jdField_a_of_type_JavaUtilArrayList.get(i1));
      }
      return localArrayList;
    }
    localArrayList.addAll(this.jdField_b_of_type_JavaUtilArrayList);
    return localArrayList;
  }
  
  void a()
  {
    this.z = BaseApplicationImpl.getApplication().getSharedPreferences(BaseApplicationImpl.getApplication().getRuntime().getAccount(), 4).getBoolean("showFlashPic", true);
    Intent localIntent = getIntent();
    this.jdField_e_of_type_JavaLangString = localIntent.getStringExtra("FROM_WHERE");
    this.u = localIntent.getBooleanExtra("PhotoConst.IS_SINGLE_MODE", false);
    this.jdField_o_of_type_JavaLangString = localIntent.getStringExtra("readSource");
    this.x = localIntent.getBooleanExtra("showFlashPic", false);
    this.jdField_s_of_type_Int = localIntent.getIntExtra("PhotoConst.SEND_BUSINESS_TYPE", -1);
    this.jdField_i_of_type_Int = localIntent.getIntExtra("camera_type", 1);
    this.jdField_j_of_type_Int = localIntent.getIntExtra("camera_front_back", 0);
    this.jdField_k_of_type_Int = localIntent.getIntExtra("camera_filter_id", -1);
    this.jdField_l_of_type_Int = localIntent.getIntExtra("camera_capture_method", -1);
    this.jdField_i_of_type_Boolean = localIntent.getBooleanExtra("PhotoConst.IS_FROM_WEIYUN", false);
    this.jdField_r_of_type_Boolean = localIntent.getBooleanExtra("from_qzone", false);
    this.jdField_s_of_type_Boolean = localIntent.getBooleanExtra("fromQzonePhotoGroup", false);
    this.jdField_j_of_type_Boolean = localIntent.getBooleanExtra("PhotoConst.IS_FROM_SHUOSHUO", false);
    this.t = localIntent.getBooleanExtra("PhotoConst.PHOTOLIST_IS_FROM_HWUPLOAD", false);
    this.jdField_k_of_type_Boolean = localIntent.getBooleanExtra("PhotoConst.IS_FROM_QQSTORY_SLIDESHOW", false);
    this.jdField_l_of_type_Boolean = localIntent.getBooleanExtra("PhotoConst.IS_FROM_QQSTORY_SLIDESHOW_PREVIEW", false);
    this.jdField_b_of_type_JavaUtilHashMap = ((HashMap)localIntent.getSerializableExtra("PeakConstants.selectedMediaInfoHashMap"));
    this.jdField_c_of_type_JavaUtilHashMap = ((HashMap)localIntent.getSerializableExtra("PhotoConst.PANORAMA_IMAGES"));
    this.B = localIntent.getBooleanExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", false);
    this.C = getIntent().getBooleanExtra("PhotoConst.MULTI_PREVIEW_IN_SINGLE_MODE", false);
    Object localObject;
    String str;
    if ((!this.u) && (("FromCamera".equals(this.jdField_e_of_type_JavaLangString)) || ("FromFastImage".equals(this.jdField_e_of_type_JavaLangString))))
    {
      localObject = (BinderWarpper)localIntent.getParcelableExtra("binder_presendService");
      if (localObject != null)
      {
        if (PresendPicMgr.a(null) != null) {
          PresendPicMgr.a(null).b();
        }
        localObject = PresendPicMgr.b(IPresendPicMgr.Stub.a(((BinderWarpper)localObject).a));
        if (!"FromFastImage".equals(this.jdField_e_of_type_JavaLangString)) {
          break label1150;
        }
        this.jdField_m_of_type_Int = 1037;
        str = (String)localIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS").get(0);
        ((PresendPicMgr)localObject).a(str, this.jdField_m_of_type_Int);
        if (QLog.isColorLevel()) {
          QLog.d("PhotoPreviewActivity", 2, "  initData , presendMgr = " + localObject + ",picpath = " + str + ",from = " + this.jdField_e_of_type_JavaLangString + ",mBusiType = " + this.jdField_m_of_type_Int);
        }
      }
    }
    this.w = localIntent.getBooleanExtra("callFromFastImage", false);
    if ("FromFastImage".equals(this.jdField_e_of_type_JavaLangString)) {
      StatisticConstants.c();
    }
    if ("FromCamera".equals(this.jdField_e_of_type_JavaLangString)) {
      StatisticConstants.a();
    }
    localIntent.removeExtra("FROM_WHERE");
    this.jdField_c_of_type_Int = localIntent.getIntExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
    this.jdField_o_of_type_Boolean = localIntent.getBooleanExtra("PhotoConst.SHOW_ALBUM", false);
    this.jdField_p_of_type_Boolean = localIntent.getBooleanExtra("PhotoConst.IS_OVERLOAD", false);
    this.jdField_l_of_type_JavaLangString = localIntent.getStringExtra("back_btn_text");
    localIntent.removeExtra("PhotoConst.SHOW_ALBUM");
    localIntent.removeExtra("PhotoConst.IS_OVERLOAD");
    if (this.jdField_o_of_type_Boolean) {
      if (this.jdField_p_of_type_Boolean)
      {
        this.jdField_a_of_type_JavaUtilArrayList = PhotoListActivity.jdField_a_of_type_JavaUtilArrayList;
        label601:
        this.jdField_b_of_type_JavaUtilArrayList = localIntent.getStringArrayListExtra("PhotoConst.SELECTED_PATHS");
        this.jdField_c_of_type_JavaUtilArrayList = localIntent.getIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS");
        if ((this.jdField_c_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList != null)) {
          break label1396;
        }
        if (QLog.isColorLevel()) {
          QLog.d("PhotoPreviewActivity", 2, "initData(): Error! selectedItem or sSelectedIndex is null");
        }
        finish();
      }
    }
    label832:
    label1365:
    label1373:
    label1396:
    for (int i1 = 0;; i1 = 1)
    {
      if (i1 != 0)
      {
        this.jdField_f_of_type_Int = this.jdField_a_of_type_JavaUtilArrayList.size();
        this.jdField_r_of_type_Int = localIntent.getIntExtra("PhotoConst.CURRENT_SELECTED_INDEX", this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
        localIntent.removeExtra("PhotoConst.CURRENT_SELECTED_INDEX");
        this.jdField_f_of_type_Boolean = localIntent.getBooleanExtra("PhotoConst.HANDLE_DEST_RESULT", false);
        this.jdField_g_of_type_Boolean = localIntent.getBooleanExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", false);
        if (this.jdField_g_of_type_Boolean)
        {
          this.jdField_b_of_type_JavaLangString = localIntent.getStringExtra("PhotoConst.MY_UIN");
          this.jdField_c_of_type_JavaLangString = localIntent.getStringExtra("PhotoConst.MY_NICK");
          this.jdField_d_of_type_JavaLangString = localIntent.getStringExtra("PhotoConst.MY_HEAD_DIR");
        }
        this.jdField_h_of_type_Boolean = localIntent.getBooleanExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", false);
        if (this.jdField_h_of_type_Boolean)
        {
          this.jdField_a_of_type_JavaUtilHashMap = ((HashMap)localIntent.getSerializableExtra("PasterConstants.pasters_data"));
          this.jdField_m_of_type_JavaLangString = localIntent.getStringExtra("PasterConstants.paster_id");
          this.jdField_n_of_type_JavaLangString = localIntent.getStringExtra("PasterConstants.paster_cate_id");
        }
        if (this.jdField_b_of_type_JavaLangString != null) {
          break label1365;
        }
        localObject = this.jdField_q_of_type_JavaLangString;
        this.jdField_b_of_type_JavaLangString = ((String)localObject);
        this.jdField_b_of_type_Int = localIntent.getIntExtra("uintype", -1);
        this.jdField_m_of_type_Boolean = localIntent.getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false);
        this.jdField_n_of_type_Boolean = localIntent.getBooleanExtra("PhotoConst.IS_SINGLE_DERECTBACK_MODE", false);
        this.jdField_e_of_type_Int = localIntent.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
        this.v = localIntent.getBooleanExtra("PhotoConst.SEND_FLAG", false);
        if (this.v)
        {
          localIntent.removeExtra("PhotoConst.SEND_FLAG");
          localObject = PresendPicMgr.a(null);
          if (localObject != null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("PhotoPreviewActivity", 2, "Photo+ send pic,cancel presend!");
            }
            ((PresendPicMgr)localObject).a(1003);
          }
          PhotoUtils.a(this, getIntent(), this.jdField_b_of_type_JavaUtilArrayList, this.jdField_e_of_type_Int, true);
        }
        this.jdField_g_of_type_JavaLangString = localIntent.getStringExtra("PhotoConst.CUSTOM_SENDBTN_TEXT");
        this.jdField_q_of_type_Boolean = localIntent.getBooleanExtra("PhotoConst.IS_JUMPTO_TROOP_ALBUM", false);
        if (this.jdField_q_of_type_Boolean)
        {
          this.jdField_i_of_type_JavaLangString = localIntent.getStringExtra("uinname");
          this.jdField_h_of_type_JavaLangString = localIntent.getStringExtra("uin");
        }
        if ((this.jdField_b_of_type_Int == 1) && (this.jdField_b_of_type_JavaLangString != null))
        {
          localObject = QZoneHelper.a(this.jdField_b_of_type_JavaLangString, this.jdField_h_of_type_JavaLangString);
          if ((localObject == null) || (((BaseBusinessAlbumInfo)localObject).a() == null) || (((BaseBusinessAlbumInfo)localObject).a().equals(""))) {
            break label1373;
          }
          this.jdField_j_of_type_JavaLangString = ((BaseBusinessAlbumInfo)localObject).a();
          this.jdField_k_of_type_JavaLangString = ((BaseBusinessAlbumInfo)localObject).b();
          localIntent.putExtra("UploadPhoto.key_album_id", this.jdField_j_of_type_JavaLangString);
          localIntent.putExtra("UploadPhoto.key_album_name", this.jdField_k_of_type_JavaLangString);
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_Boolean = localIntent.getBooleanExtra("from_health", false);
        this.jdField_b_of_type_Boolean = localIntent.getBooleanExtra("from_readinjoy_ugc_preview", false);
        this.jdField_d_of_type_Boolean = localIntent.getBooleanExtra("from_readinjoy_ugc", false);
        this.jdField_a_of_type_JavaLangString = localIntent.getStringExtra("from_tribe_class_name");
        return;
        label1150:
        this.jdField_m_of_type_Int = 1008;
        break;
        this.jdField_a_of_type_JavaUtilArrayList = localIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
        break label601;
        this.jdField_a_of_type_JavaUtilArrayList = localIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
        if (this.jdField_a_of_type_JavaUtilArrayList == null) {
          this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        }
        if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
        {
          localObject = localIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
          this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
        }
        localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          str = (String)((Iterator)localObject).next();
          if (str != null)
          {
            if (!new File(str).exists()) {
              ((Iterator)localObject).remove();
            }
          }
          else {
            ((Iterator)localObject).remove();
          }
        }
        this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
        this.jdField_b_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
        this.jdField_c_of_type_JavaUtilArrayList.clear();
        if (this.u) {
          break label1396;
        }
        i1 = 0;
        while (i1 < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          this.jdField_c_of_type_JavaUtilArrayList.add(Integer.valueOf(i1));
          i1 += 1;
        }
        localObject = this.jdField_b_of_type_JavaLangString;
        break label832;
        localIntent.putExtra("UploadPhoto.key_album_id", "");
        localIntent.putExtra("UploadPhoto.key_album_name", "");
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (!FileUtils.b(this.jdField_p_of_type_JavaLangString))
    {
      QQToast.a(this, 2131437339, 0).a();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqVideoIMediaPlayer.a(this.jdField_a_of_type_ComTencentMobileqqVideoIMediaPlayer$OnPreparedListener);
    this.jdField_a_of_type_ComTencentMobileqqVideoIMediaPlayer.a(this.jdField_a_of_type_ComTencentMobileqqVideoIMediaPlayer$OnPlayStateListener);
    if (this.jdField_a_of_type_ComTencentMobileqqVideoIMediaPlayer.a(this.jdField_p_of_type_JavaLangString, paramInt)) {
      try
      {
        this.jdField_a_of_type_AndroidViewSurfaceView.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqVideoIMediaPlayer.a(this.jdField_a_of_type_AndroidViewSurfaceView.getHolder());
        return;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("PhotoPreviewActivity", 2, "mMediaPlayer.setDisplay exception : ", localThrowable);
        return;
      }
    }
    DialogUtil.a(this, 232, null, getString(2131437349), new wvb(this), null).show();
  }
  
  protected boolean a()
  {
    return false;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqVideoIMediaPlayer.a();
  }
  
  void b()
  {
    int i2 = 0;
    this.U = true;
    this.V = false;
    this.jdField_a_of_type_AndroidViewView = findViewById(2131365488);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131363091));
    if (this.jdField_e_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131365502));
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131364406));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364405));
    this.jdField_b_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131365503));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365504));
    if (this.x)
    {
      this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new wuw(this));
      this.jdField_a_of_type_AndroidWidgetCheckBox.setContentDescription("闪照");
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription("闪照");
    }
    this.jdField_b_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new wve(this));
    float f1;
    label989:
    int i1;
    label1039:
    Object localObject;
    if (this.jdField_g_of_type_Boolean) {
      if (this.jdField_b_of_type_Int == 9501)
      {
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetCheckBox.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365501));
        this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131365505));
        this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox = ((NumberCheckBox)findViewById(2131365500));
        this.jdField_b_of_type_AndroidViewView = findViewById(2131365499);
        this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363360));
        if (this.jdField_b_of_type_Boolean)
        {
          this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_b_of_type_AndroidViewView.setVisibility(8);
          this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
        }
        this.jdField_b_of_type_AndroidViewView.setOnClickListener(new wvf(this));
        this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365489));
        this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(new wvg(this));
        this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new wvh(this));
        this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(new wvi(this));
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoProGallery = ((ProGallery)findViewById(2131364774));
        if (this.jdField_r_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoProGallery.setSupportMatchParent(true);
        }
        this.jdField_a_of_type_Wvn = new wvn(this);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoProGallery.setAdapter(this.jdField_a_of_type_Wvn);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoProGallery.setOnNoBlankListener(this.jdField_a_of_type_Wvn);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoProGallery.setOnScollListener(new wvk(this));
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoProGallery.setOnItemSelectedListener(new wvl(this));
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoProGallery.setSpacing(getResources().getDimensionPixelSize(2131558524));
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoProGallery.setSelection(this.jdField_r_of_type_Int);
        e();
        if ((this.jdField_n_of_type_Boolean) || (this.u))
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setVisibility(8);
          this.jdField_b_of_type_AndroidViewView.setVisibility(8);
          if (!this.jdField_d_of_type_Boolean) {
            this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          }
          this.jdField_b_of_type_AndroidWidgetCheckBox.setVisibility(8);
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoProGallery.setOnItemClickListener(new wvm(this));
        if (("FromCamera".equals(this.jdField_e_of_type_JavaLangString)) || ("FromFastImage".equals(this.jdField_e_of_type_JavaLangString)) || ("FROM_PHOTO_LIST_FLOW".equals(this.jdField_e_of_type_JavaLangString)))
        {
          this.jdField_c_of_type_AndroidWidgetTextView.setText(2131436111);
          this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(4);
          if (!"FROM_PHOTO_LIST_FLOW".equals(this.jdField_e_of_type_JavaLangString))
          {
            this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setVisibility(8);
            this.jdField_b_of_type_AndroidViewView.setVisibility(8);
          }
        }
        this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(new wux(this));
        if (this.u) {
          this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
        }
        if (!TextUtils.isEmpty(this.jdField_l_of_type_JavaLangString)) {
          this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_l_of_type_JavaLangString);
        }
        if (this.jdField_b_of_type_Int == 1001)
        {
          this.jdField_b_of_type_AndroidWidgetCheckBox.setVisibility(8);
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        this.jdField_a_of_type_AndroidViewSurfaceView = ((SurfaceView)findViewById(2131365506));
        this.jdField_a_of_type_AndroidViewSurfaceView.setZOrderOnTop(true);
        this.jdField_a_of_type_AndroidViewSurfaceView.getHolder().setFormat(-3);
        this.jdField_a_of_type_AndroidViewSurfaceView.getHolder().setType(3);
        this.jdField_a_of_type_AndroidViewSurfaceView.getHolder().addCallback(this.jdField_a_of_type_AndroidViewSurfaceHolder$Callback);
        this.jdField_a_of_type_AndroidViewSurfaceView.getViewTreeObserver().addOnGlobalLayoutListener(new wuy(this));
        this.jdField_a_of_type_AndroidViewSurfaceView.setOnClickListener(new wuz(this));
        if (this.C)
        {
          this.jdField_e_of_type_AndroidWidgetTextView.setText(2131435888);
          this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(getResources().getColorStateList(2131494227));
          this.jdField_b_of_type_AndroidWidgetButton.setVisibility(4);
        }
        f1 = 16.0F / FontSettingManager.a();
        if ((f1 >= 1.0F) && (this.jdField_g_of_type_Int >= 720)) {
          return;
        }
        if (this.jdField_g_of_type_Int >= 270) {
          break label1175;
        }
        f1 *= 0.7F;
        i1 = i2;
        if (QLog.isColorLevel())
        {
          QLog.d("PhotoPreviewActivity", 2, "need scale,reqWidth:" + this.jdField_g_of_type_Int + " scale:" + f1);
          i1 = i2;
        }
        if (i1 >= this.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildCount()) {
          return;
        }
        localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(i1);
        ((View)localObject).setScaleX(f1);
        ((View)localObject).setScaleY(f1);
        if (i1 != this.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildCount() - 1) {
          break label1184;
        }
        localObject = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).rightMargin = ((int)(((RelativeLayout.LayoutParams)localObject).rightMargin * f1));
      }
    }
    for (;;)
    {
      i1 += 1;
      break label1039;
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      break;
      if (this.jdField_h_of_type_Boolean) {
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      }
      for (;;)
      {
        this.jdField_b_of_type_AndroidWidgetCheckBox.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        break;
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      }
      label1175:
      f1 *= 0.8F;
      break label989;
      label1184:
      localObject = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).leftMargin = ((int)(((RelativeLayout.LayoutParams)localObject).leftMargin * f1));
    }
  }
  
  public void c()
  {
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
    if (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a();
    }
  }
  
  public void d()
  {
    this.jdField_e_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
  }
  
  public void e()
  {
    boolean bool = true;
    Object localObject;
    if (this.jdField_g_of_type_Boolean)
    {
      localObject = getString(2131435887);
      if (this.jdField_q_of_type_Boolean) {
        localObject = getString(2131435889);
      }
      if (this.jdField_g_of_type_JavaLangString == null) {
        break label452;
      }
      localObject = this.jdField_g_of_type_JavaLangString;
    }
    label297:
    label452:
    for (;;)
    {
      if (this.jdField_b_of_type_JavaUtilArrayList.size() > 0)
      {
        if ((this.jdField_n_of_type_Boolean) || (this.u))
        {
          this.jdField_b_of_type_AndroidWidgetButton.setEnabled(true);
          this.jdField_b_of_type_AndroidWidgetButton.setText((CharSequence)localObject);
          return;
          if ((this.jdField_k_of_type_Boolean) || (this.jdField_l_of_type_Boolean))
          {
            localObject = getString(2131439300);
            break;
          }
          localObject = getString(2131435888);
          break;
        }
        this.jdField_b_of_type_AndroidWidgetButton.setEnabled(true);
        Button localButton;
        if ((this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) || ((this.jdField_b_of_type_JavaUtilArrayList.size() == 1) && (!this.jdField_q_of_type_Boolean) && (this.jdField_c_of_type_JavaUtilArrayList.contains(Integer.valueOf(this.jdField_r_of_type_Int))) && (a((String)this.jdField_b_of_type_JavaUtilArrayList.get(0)) != 1)))
        {
          this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
          f();
          if ((this.jdField_k_of_type_Boolean) || (this.jdField_l_of_type_Boolean))
          {
            localButton = this.jdField_b_of_type_AndroidWidgetButton;
            if (this.jdField_b_of_type_JavaUtilArrayList.size() < 2) {
              break label297;
            }
          }
        }
        for (bool = true;; bool = false)
        {
          localButton.setEnabled(bool);
          this.jdField_b_of_type_AndroidWidgetButton.setText((String)localObject + "(" + this.jdField_b_of_type_JavaUtilArrayList.size() + ")");
          return;
          this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
          break;
        }
      }
      this.jdField_b_of_type_AndroidWidgetButton.setText((CharSequence)localObject);
      if ((this.jdField_k_of_type_Boolean) || (this.jdField_l_of_type_Boolean)) {
        this.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
      }
      if ((this.jdField_r_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > this.jdField_r_of_type_Int) && (a((String)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_r_of_type_Int)) == 1)) {
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      }
      this.jdField_b_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(null);
      localObject = this.jdField_b_of_type_AndroidWidgetCheckBox;
      if (this.jdField_e_of_type_Int == 2) {}
      for (;;)
      {
        ((CheckBox)localObject).setChecked(bool);
        this.jdField_b_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
        if (this.jdField_e_of_type_Int == 2) {
          this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16734752);
        }
        f();
        return;
        bool = false;
      }
    }
  }
  
  void f()
  {
    switch (this.jdField_e_of_type_Int)
    {
    case 1: 
    default: 
      return;
    case 0: 
      this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131435886));
      this.jdField_b_of_type_AndroidWidgetCheckBox.setChecked(false);
      return;
    }
    g();
    this.jdField_b_of_type_AndroidWidgetCheckBox.setChecked(true);
  }
  
  void g()
  {
    Object localObject = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    int i1 = 0;
    int i2 = 0;
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      long l1 = new File(str).length();
      int i3 = i2;
      if (l1 > jdField_a_of_type_Int) {
        i3 = i2 + 1;
      }
      int i4 = (int)(i1 + l1);
      i1 = i4;
      i2 = i3;
      if (QLog.isColorLevel())
      {
        QLog.d("_photo", 2, "setQualityTextViewText, path:" + str + ",len:" + l1);
        i1 = i4;
        i2 = i3;
      }
    }
    localObject = PhotoUtils.a(this, i1);
    if ((this.jdField_b_of_type_JavaUtilArrayList.size() == 0) || (((String)localObject).equals("0"))) {}
    for (localObject = getString(2131435886);; localObject = getString(2131435886) + "(共" + (String)localObject + ")")
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      return;
    }
  }
  
  public void h()
  {
    getIntent().putExtra("PhotoConst.SEND_BUSINESS_TYPE", this.jdField_s_of_type_Int);
    Object localObject;
    if ("FROM_PHOTO_LIST".equals(this.jdField_e_of_type_JavaLangString))
    {
      localObject = getIntent();
      ((Intent)localObject).setClass(this, PhotoListActivity.class);
      ((Intent)localObject).putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.jdField_e_of_type_Int);
      if (this.u)
      {
        ((Intent)localObject).removeExtra("PhotoConst.PHOTO_PATHS");
        startActivity((Intent)localObject);
      }
    }
    label246:
    do
    {
      do
      {
        for (;;)
        {
          if (getIntent().getBooleanExtra("keep_selected_status_after_finish", false))
          {
            localObject = new Intent();
            ((Intent)localObject).putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.jdField_b_of_type_JavaUtilArrayList);
            ((Intent)localObject).putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", this.jdField_c_of_type_JavaUtilArrayList);
            ((Intent)localObject).putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.jdField_e_of_type_Int);
            setResult(-1, (Intent)localObject);
          }
          super.finish();
          if (!this.jdField_b_of_type_Boolean) {
            break label313;
          }
          overridePendingTransition(2131034375, 2131034374);
          return;
          ((Intent)localObject).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.jdField_b_of_type_JavaUtilArrayList);
          break;
          if ((!"FROM_PHOTO_LIST_FLOW".equals(this.jdField_e_of_type_JavaLangString)) || (this.u)) {
            break label246;
          }
          localObject = new Intent();
          ((Intent)localObject).putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.jdField_b_of_type_JavaUtilArrayList);
          ((Intent)localObject).putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", this.jdField_c_of_type_JavaUtilArrayList);
          ((Intent)localObject).putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.jdField_e_of_type_Int);
          setResult(-1, (Intent)localObject);
        }
      } while ((!"FromCamera".equals(this.jdField_e_of_type_JavaLangString)) && (!"FromFastImage".equals(this.jdField_e_of_type_JavaLangString)));
      localObject = PresendPicMgr.a(null);
    } while (localObject == null);
    if ("FromCamera".equals(this.jdField_e_of_type_JavaLangString)) {}
    for (int i1 = 1016;; i1 = 1017)
    {
      ((PresendPicMgr)localObject).a(i1);
      break;
    }
    label313:
    AlbumUtil.a(this, true, false);
  }
  
  public void i()
  {
    if ((this.jdField_k_of_type_Boolean) || (this.jdField_l_of_type_Boolean))
    {
      SlideShowPhotoListManager.a(this, this.jdField_b_of_type_JavaUtilArrayList);
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
    if (this.jdField_s_of_type_Boolean)
    {
      localObject1 = new Intent();
      ((Intent)localObject1).putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", this.jdField_c_of_type_JavaUtilArrayList);
      super.setResult(-1, (Intent)localObject1);
      super.finish();
      return;
    }
    Object localObject2;
    if (this.jdField_q_of_type_Boolean)
    {
      localObject1 = PresendPicMgr.a(null);
      if (localObject1 != null) {
        ((PresendPicMgr)localObject1).a(1009);
      }
      localObject1 = a();
      if (localObject1 != null) {
        StatisticConstants.b(getIntent(), ((ArrayList)localObject1).size());
      }
      localObject2 = getIntent();
      ((Intent)localObject2).putExtra("open_chatfragment_fromphoto", true);
      AIOGalleryUtils.a(this, (Intent)localObject2, this.jdField_b_of_type_JavaLangString, this.jdField_h_of_type_JavaLangString, this.jdField_i_of_type_JavaLangString, this.jdField_j_of_type_JavaLangString, this.jdField_k_of_type_JavaLangString, this.jdField_e_of_type_Int, (ArrayList)localObject1, 42);
    }
    for (;;)
    {
      Intent localIntent = getIntent();
      if ((localIntent == null) || (!localIntent.getBooleanExtra("custom_photopreview_sendbtn_report", false))) {
        break;
      }
      localObject3 = localIntent.getStringExtra("custom_photopreview_sendbtn_reportActionName");
      localObject2 = localIntent.getStringExtra("custom_photopreview_sendbtn_album_reportReverse2");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = localIntent.getStringExtra("custom_photopreview_sendbtn_camera_reportReverse2");
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = localIntent.getStringExtra("custom_photopreview_sendbtn_reportReverse2");
      }
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      if ((localObject3 == null) || (localObject1 == null)) {
        break;
      }
      ReportController.b(null, "CliOper", "", "", (String)localObject3, (String)localObject3, 0, 0, (String)localObject1, "", "", "");
      return;
      if ((!this.jdField_h_of_type_Boolean) || ((TextUtils.isEmpty(this.jdField_m_of_type_JavaLangString)) && (TextUtils.isEmpty(this.jdField_n_of_type_JavaLangString)))) {
        break label345;
      }
      this.jdField_a_of_type_AndroidWidgetButton.performClick();
    }
    label345:
    if ("FromFastImage".equals(this.jdField_e_of_type_JavaLangString))
    {
      ReportController.b(null, "CliOper", "", "", "0X8004D93", "0X8004D93", 0, 0, "", "", "", "");
      StatisticConstants.d();
    }
    if ("FromCamera".equals(this.jdField_e_of_type_JavaLangString)) {
      StatisticConstants.b();
    }
    if ((TroopBarPublishActivity.class.getSimpleName().equals(this.jdField_a_of_type_JavaLangString)) || (TroopBarReplyActivity.class.getSimpleName().equals(this.jdField_a_of_type_JavaLangString))) {}
    for (Object localObject1 = new ArrayList(this.jdField_b_of_type_JavaUtilArrayList);; localObject1 = a())
    {
      if (localObject1 != null)
      {
        StatisticConstants.a(((ArrayList)localObject1).size(), this.jdField_f_of_type_Int);
        StatisticConstants.a(getIntent(), ((ArrayList)localObject1).size(), this.jdField_e_of_type_Int);
      }
      localObject2 = getIntent();
      if (!this.jdField_i_of_type_Boolean) {
        break;
      }
      localObject1 = new Intent();
      ((Intent)localObject1).putStringArrayListExtra("img_list", this.jdField_b_of_type_JavaUtilArrayList);
      super.setResult(-1, (Intent)localObject1);
      super.finish();
      return;
    }
    Object localObject3 = PresendPicMgr.a(null);
    if (this.jdField_e_of_type_Int == 2)
    {
      if ((this.jdField_c_of_type_JavaUtilArrayList.size() == 0) && (((ArrayList)localObject1).size() == 1) && (FileUtils.a((String)((ArrayList)localObject1).get(0)) > 19922944L))
      {
        QQToast.a(this, getResources().getString(2131435903), 0).b(getResources().getDimensionPixelSize(2131558448));
        this.jdField_b_of_type_AndroidWidgetButton.setClickable(true);
        return;
      }
      if (localObject3 != null)
      {
        ((PresendPicMgr)localObject3).a(1010);
        ((PresendPicMgr)localObject3).a();
      }
      if (("FromCamera".equals(this.jdField_e_of_type_JavaLangString)) || ("FromFastImage".equals(this.jdField_e_of_type_JavaLangString)))
      {
        ReportController.b(null, "CliOper", "", "", "0X8005147", "0X8005147", 0, 0, "", "", "", "");
        label684:
        if (this.y)
        {
          ((Intent)localObject2).putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1040);
          if (this.jdField_b_of_type_Int != 0) {
            break label941;
          }
          ReportController.b(null, "dc00898", "", "", "0X80069A6", "0X80069A6", 0, 0, "", "", "", "");
          ReportController.b(null, "dc00898", "", "", "0X800699A", "0X800699A", 0, 0, "", "", "", "");
        }
      }
    }
    for (;;)
    {
      if (this.jdField_f_of_type_Boolean) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(4);
      }
      if (localObject1 != null) {
        NewFlowCameraReporter.a((List)localObject1);
      }
      if (this.jdField_r_of_type_Boolean)
      {
        ((Intent)localObject2).putExtra("PeakConstants.selectedMediaInfoHashMap", this.jdField_b_of_type_JavaUtilHashMap);
        ((Intent)localObject2).putExtra("PhotoConst.PANORAMA_IMAGES", this.jdField_c_of_type_JavaUtilHashMap);
      }
      if (this.B)
      {
        ((Intent)localObject2).putExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", true);
        ((Intent)localObject2).putExtra("session_info", getIntent().getParcelableExtra("session_info"));
      }
      PhotoUtils.a(this, (Intent)localObject2, (ArrayList)localObject1, this.jdField_e_of_type_Int, this.jdField_f_of_type_Boolean);
      break;
      ReportController.b(null, "CliOper", "", "", "0X800515C", "0X800515C", 0, 0, "", "", "", "");
      break label684;
      if ((localObject3 == null) || (this.jdField_c_of_type_JavaUtilArrayList.size() <= 0) || (this.y) || (this.A) || (this.B)) {
        break label684;
      }
      ((PresendPicMgr)localObject3).a((Intent)localObject2);
      break label684;
      label941:
      if (this.jdField_b_of_type_Int == 3000)
      {
        ReportController.b(null, "dc00898", "", "", "0X80069A7", "0X80069A7", 0, 0, "", "", "", "");
        ReportController.b(null, "dc00898", "", "", "0X800699B", "0X800699B", 0, 0, "", "", "", "");
      }
      else if (this.jdField_b_of_type_Int == 1)
      {
        ReportController.b(null, "dc00898", "", "", "0X80069A8", "0X80069A8", 0, 0, "", "", "", "");
        ReportController.b(null, "dc00898", "", "", "0X800699C", "0X800699C", 0, 0, "", "", "", "");
      }
    }
  }
  
  void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVideoIMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentMobileqqVideoIMediaPlayer.c();
    }
  }
  
  public void k()
  {
    this.jdField_a_of_type_ComTencentMobileqqVideoIMediaPlayer.a();
  }
  
  public void l()
  {
    this.jdField_a_of_type_ComTencentMobileqqVideoIMediaPlayer.b();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (QLog.isDevelopLevel()) {
      QLog.d("PhotoPreviewActivity", 4, "[PhotoPreviewActivity] [onActivityResult] requestCode = " + paramInt1 + "  resultCode:" + paramInt2 + "  ok:" + -1);
    }
    if (((this.jdField_k_of_type_Boolean) || (this.jdField_l_of_type_Boolean)) && (paramInt2 == -1))
    {
      setResult(paramInt2, paramIntent);
      finish();
      return;
    }
    PhotoUtils.a(this, paramInt1, paramInt2, paramIntent, this.jdField_m_of_type_Boolean, this.jdField_b_of_type_JavaLangString);
  }
  
  public void onBackPressed()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoProGallery.a(false)) {
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      super.setResult(0);
      super.finish();
      return;
    }
    h();
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
      label180:
      int i1;
      if (paramBoolean)
      {
        paramCompoundButton = this.jdField_a_of_type_AndroidWidgetCheckBox;
        if (!paramBoolean) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          paramCompoundButton.setChecked(paramBoolean);
          this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16734752);
          this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-5855578);
          if (a() <= 0) {
            break label180;
          }
          QQToast.a(this, getResources().getString(2131435903), 0).b(getResources().getDimensionPixelSize(2131558448));
          this.jdField_e_of_type_Int = 0;
          this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131435886));
          this.jdField_b_of_type_AndroidWidgetCheckBox.setChecked(false);
          break;
        }
        if (this.jdField_b_of_type_JavaUtilArrayList.isEmpty())
        {
          i1 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoProGallery.getFirstVisiblePosition();
          if (i1 < this.jdField_a_of_type_JavaUtilArrayList.size()) {
            if (new File((String)this.jdField_a_of_type_JavaUtilArrayList.get(i1)).length() > 19922944L)
            {
              QQToast.a(this, getResources().getString(2131435903), 0).b(getResources().getDimensionPixelSize(2131558448));
              this.jdField_e_of_type_Int = 0;
              this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131435886));
              this.jdField_b_of_type_AndroidWidgetCheckBox.setChecked(false);
            }
            else
            {
              b(1);
              this.jdField_b_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_JavaUtilArrayList.get(i1));
              this.jdField_c_of_type_JavaUtilArrayList.add(Integer.valueOf(i1));
              this.jdField_b_of_type_AndroidWidgetCheckBox.setChecked(true);
              this.jdField_e_of_type_Int = 2;
              g();
              e();
              paramCompoundButton = PresendPicMgr.a();
              if (paramCompoundButton != null) {
                paramCompoundButton.a((String)this.jdField_a_of_type_JavaUtilArrayList.get(i1), this.jdField_m_of_type_Int);
              }
              paramCompoundButton = getIntent();
              if ((paramCompoundButton != null) && (paramCompoundButton.hasExtra("custom_photopreview_rawcheckbox_reportActionName")))
              {
                paramCompoundButton = paramCompoundButton.getStringExtra("custom_photopreview_rawcheckbox_reportActionName");
                if (paramCompoundButton != null) {
                  ReportController.b(null, "CliOper", "", "", paramCompoundButton, paramCompoundButton, 0, 0, "", "", "", "");
                }
              }
            }
          }
        }
        else
        {
          this.jdField_b_of_type_AndroidWidgetCheckBox.setChecked(true);
          this.jdField_e_of_type_Int = 2;
          g();
          paramCompoundButton = getIntent();
          if ((paramCompoundButton != null) && (paramCompoundButton.hasExtra("custom_photopreview_rawcheckbox_reportActionName")))
          {
            paramCompoundButton = paramCompoundButton.getStringExtra("custom_photopreview_rawcheckbox_reportActionName");
            if (paramCompoundButton != null) {
              ReportController.b(null, "CliOper", "", "", paramCompoundButton, paramCompoundButton, 0, 0, "", "", "", "");
            }
          }
        }
      }
      else
      {
        this.jdField_b_of_type_AndroidWidgetCheckBox.setChecked(false);
        this.jdField_e_of_type_Int = 0;
        this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131435886));
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-5855578);
        continue;
        this.y = paramBoolean;
        if (paramBoolean)
        {
          this.A = true;
          paramCompoundButton = this.jdField_b_of_type_AndroidWidgetCheckBox;
          if (!paramBoolean) {}
          for (paramBoolean = true;; paramBoolean = false)
          {
            paramCompoundButton.setChecked(paramBoolean);
            this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-5855578);
            this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16734752);
            if ((this.jdField_b_of_type_JavaUtilArrayList.isEmpty()) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoProGallery.getFirstVisiblePosition() < this.jdField_a_of_type_JavaUtilArrayList.size()))
            {
              this.jdField_b_of_type_AndroidViewView.performClick();
              e();
            }
            if ((this.z) && (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow == null))
            {
              this.z = false;
              BaseApplicationImpl.getApplication().getSharedPreferences(BaseApplicationImpl.getApplication().getRuntime().getAccount(), 4).edit().putBoolean("showFlashPic", false).commit();
              this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = new BubblePopupWindow(-2, -2);
              paramCompoundButton = new TextView(this);
              i1 = AIOUtils.a(10.0F, getResources());
              paramCompoundButton.setPadding(i1, 0, i1, 0);
              paramCompoundButton.setTextColor(-1);
              paramCompoundButton.setText("选中的图片每人只能查看一次");
              paramCompoundButton.setTextSize(15.0F);
              this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(paramCompoundButton);
              this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(false);
              this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b(this.jdField_a_of_type_AndroidWidgetCheckBox);
            }
            if (this.jdField_b_of_type_Int != 0) {
              break label823;
            }
            ReportController.b(null, "dc00898", "", "", "0X8006997", "0X8006997", 0, 0, "", "", "", "");
            break;
          }
          label823:
          if (this.jdField_b_of_type_Int == 3000) {
            ReportController.b(null, "dc00898", "", "", "0X8006998", "0X8006998", 0, 0, "", "", "", "");
          } else if (this.jdField_b_of_type_Int == 1) {
            ReportController.b(null, "dc00898", "", "", "0X8006999", "0X8006999", 0, 0, "", "", "", "");
          }
        }
        else
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-5855578);
          if (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) {
            this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a();
          }
        }
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentView(2130969180);
    NewFlowCameraReporter.a("preview create");
    this.jdField_g_of_type_Int = getResources().getDisplayMetrics().widthPixels;
    this.jdField_h_of_type_Int = getResources().getDisplayMetrics().heightPixels;
    a();
    b();
  }
  
  protected void onDestroy()
  {
    getIntent().putExtra("PhotoConst.SEND_BUSINESS_TYPE", this.jdField_s_of_type_Int);
    if (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a();
    }
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
            CameraUtils.a((Bitmap)localObject1);
          }
        }
      }
      catch (Throwable localThrowable)
      {
        break label225;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PhotoPreviewActivity", 2, "remove file error");
      }
      if ((this.jdField_i_of_type_Int != 103) || (this.jdField_a_of_type_JavaUtilArrayList == null)) {}
    }
    label225:
    j();
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    a();
    b();
  }
  
  protected void onPause()
  {
    super.onPause();
    SmallScreenUtils.a(BaseApplicationImpl.getContext(), false);
  }
  
  @TargetApi(9)
  protected void onResume()
  {
    super.onResume();
    if ((this.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_AndroidViewView != null)) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    SmallScreenUtils.a(BaseApplicationImpl.getContext(), true);
    if (this.jdField_a_of_type_AndroidWidgetButton != null) {
      this.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.PhotoPreviewActivity
 * JD-Core Version:    0.7.0.1
 */