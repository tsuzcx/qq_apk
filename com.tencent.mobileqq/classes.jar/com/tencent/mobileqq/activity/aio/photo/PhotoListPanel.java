package com.tencent.mobileqq.activity.aio.photo;

import acjt;
import aepi;
import aetu;
import agkx;
import agky;
import agkz;
import agla;
import aglb;
import aglc;
import agld;
import agle;
import aglf;
import aglg;
import aglh;
import agli;
import aglk;
import agll;
import agln;
import agws;
import aioz;
import ajrw;
import akcv;
import alok;
import alse;
import alud;
import amdu;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import apkp;
import aufc;
import awis;
import awiw;
import awka;
import axlk;
import axln;
import azdd;
import azqh;
import azqs;
import bazm;
import bciq;
import bcpg;
import bdeu;
import bdez;
import bdfa;
import bdgc;
import bdgm;
import bdhb;
import bdin;
import bdmu;
import bezm;
import bjdn;
import bjdt;
import bjea;
import bjre;
import com.dataline.activities.LiteActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.DynamicImageMediaFileFilter;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.activity.photo.SendPhotoTask;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity.SendVideoInfo;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.richmedia.RichmediaService;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;
import com.tencent.util.Pair;
import com.tencent.widget.XEditTextEx;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AccountNotMatchException;
import nav;
import zjc;

public class PhotoListPanel
  extends RelativeLayout
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  public static int a;
  public static int b;
  private static int m;
  public long a;
  agle jdField_a_of_type_Agle;
  public aglg a;
  aglh jdField_a_of_type_Aglh;
  public agli a;
  agll jdField_a_of_type_Agll;
  agln jdField_a_of_type_Agln;
  public Activity a;
  Intent jdField_a_of_type_AndroidContentIntent;
  SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  public Handler a;
  RecyclerView.LayoutManager jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager;
  public RecyclerView a;
  public View a;
  Button jdField_a_of_type_AndroidWidgetButton;
  public CheckBox a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public apkp a;
  private bdmu jdField_a_of_type_Bdmu;
  public SessionInfo a;
  MediaFileFilter jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter;
  public QQAppInterface a;
  Boolean jdField_a_of_type_JavaLangBoolean;
  String jdField_a_of_type_JavaLangString;
  public ArrayList<Integer> a;
  HashMap<LocalMediaInfo, LocalMediaInfo> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public LinkedList<String> a;
  public Map<String, LocalMediaInfo> a;
  public volatile boolean a;
  long jdField_b_of_type_Long;
  View jdField_b_of_type_AndroidViewView;
  Button jdField_b_of_type_AndroidWidgetButton;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  public apkp b;
  MediaFileFilter jdField_b_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter;
  String jdField_b_of_type_JavaLangString;
  ArrayList<String> jdField_b_of_type_JavaUtilArrayList;
  boolean jdField_b_of_type_Boolean;
  public int c;
  public View c;
  Button jdField_c_of_type_AndroidWidgetButton;
  String jdField_c_of_type_JavaLangString;
  boolean jdField_c_of_type_Boolean;
  int jdField_d_of_type_Int = f();
  View jdField_d_of_type_AndroidViewView;
  private String jdField_d_of_type_JavaLangString;
  boolean jdField_d_of_type_Boolean;
  int jdField_e_of_type_Int;
  private String jdField_e_of_type_JavaLangString = alud.a(2131708478);
  boolean jdField_e_of_type_Boolean;
  int jdField_f_of_type_Int;
  boolean jdField_f_of_type_Boolean;
  int jdField_g_of_type_Int;
  boolean jdField_g_of_type_Boolean;
  int jdField_h_of_type_Int;
  boolean jdField_h_of_type_Boolean;
  public int i;
  boolean i;
  public int j;
  boolean j;
  int k;
  public boolean k;
  public int l;
  boolean l;
  public boolean m;
  private int jdField_n_of_type_Int = -1;
  boolean jdField_n_of_type_Boolean = false;
  boolean o;
  boolean p;
  
  static
  {
    jdField_a_of_type_Int = 20;
    jdField_m_of_type_Int = -1;
  }
  
  public PhotoListPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_i_of_type_Boolean = false;
    this.jdField_j_of_type_Boolean = false;
    this.jdField_k_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_i_of_type_Int = 278921216;
    this.jdField_j_of_type_Int = -16777216;
    this.jdField_l_of_type_Boolean = false;
    this.jdField_m_of_type_Boolean = false;
    this.jdField_l_of_type_Int = 0;
  }
  
  public static int a()
  {
    if (jdField_m_of_type_Int == -1) {
      jdField_m_of_type_Int = BaseApplicationImpl.sApplication.getSharedPreferences("SP_KEY_PHOTO_LIST_PANEL", 0).getInt("SP_KEY_SHOW_MODE", 0);
    }
    return jdField_m_of_type_Int;
  }
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    Properties localProperties = new Properties();
    localProperties.put(paramString2, paramString3);
    azqh.a(BaseApplicationImpl.getContext()).reportKVEvent(paramString1, localProperties);
  }
  
  private boolean e()
  {
    return false;
  }
  
  @TargetApi(9)
  private void m()
  {
    boolean bool = e();
    if (a()) {}
    for (String str = "qzone_will_upload_to_personal_album"; Build.VERSION.SDK_INT >= 9; str = "qzone_will_upload_to_qun_album" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean(str, bool).apply();
      return;
    }
    ThreadManager.postImmediately(new PhotoListPanel.3(this, str, bool), null, false);
  }
  
  public static void setShowModeToSp(int paramInt)
  {
    if ((paramInt == 0) || (paramInt == 1))
    {
      jdField_m_of_type_Int = paramInt;
      SharedPreferences.Editor localEditor = BaseApplicationImpl.sApplication.getSharedPreferences("SP_KEY_PHOTO_LIST_PANEL", 0).edit();
      localEditor.putInt("SP_KEY_SHOW_MODE", paramInt);
      localEditor.commit();
    }
  }
  
  protected long a(String paramString)
  {
    return new File(paramString).length();
  }
  
  public aglf a()
  {
    return new aglf(this);
  }
  
  public Intent a()
  {
    int i2 = 0;
    Object localObject = new ArrayList(this.jdField_a_of_type_JavaUtilLinkedList);
    Intent localIntent = new Intent();
    localIntent.putExtra("PhotoConst.SHOW_ALBUM", true);
    localIntent.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", (ArrayList)localObject);
    localIntent.putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", this.jdField_a_of_type_JavaUtilArrayList);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("getSelectedPhotosIntent SELECTED_PATHS size=");
      if (localObject != null) {
        break label123;
      }
      i1 = 0;
      localObject = localStringBuilder.append(i1).append(",SELECTED_INDEXS size=");
      if (this.jdField_a_of_type_JavaUtilArrayList != null) {
        break label132;
      }
    }
    label132:
    for (int i1 = i2;; i1 = this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      QLog.d("PhotoListPanel", 2, i1);
      return localIntent;
      label123:
      i1 = ((ArrayList)localObject).size();
      break;
    }
  }
  
  public HashMap<String, String> a()
  {
    return aioz.a(this.jdField_a_of_type_JavaUtilHashMap);
  }
  
  public void a()
  {
    TextView localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371309);
    int i1 = getResources().getDisplayMetrics().densityDpi;
    if (i1 < 320) {
      localTextView.setCompoundDrawables(null, null, null, null);
    }
    if (jdField_b_of_type_Int == 0)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(8);
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanel", 2, "densityDpi = " + i1 + "qurey time=" + this.jdField_a_of_type_Long);
    }
    ThreadManager.post(new PhotoListPanel.QueryMediaTask(this), 8, null, true);
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_b_of_type_Boolean) {}
    while (!this.jdField_c_of_type_Boolean) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanel", 2, "cancelAllPresendPic, type = " + paramInt);
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_presend_cancel_type", paramInt);
    RichmediaService.d(localBundle);
  }
  
  public void a(int paramInt, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanel", 2, "onActivityResult, requestCode = " + paramInt);
    }
    switch (paramInt)
    {
    default: 
      return;
    case 100004: 
    case 100006: 
      if (QLog.isColorLevel()) {
        QLog.d("PhotoListPanel", 2, "onActivityResult, PeakConstants.REQUEST_PHOTOPREVIEW_RETURE");
      }
      aioz.a(getContext(), paramIntent, true, this.jdField_a_of_type_JavaUtilHashMap);
      Object localObject1 = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (String)((Iterator)localObject1).next();
        localObject2 = this.jdField_a_of_type_Agli.a((String)localObject2);
        if (localObject2 != null) {
          ((LocalMediaInfo)localObject2).mChecked = false;
        }
      }
      this.jdField_c_of_type_Int = paramIntent.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
      paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.SELECTED_PATHS");
      this.jdField_a_of_type_JavaUtilLinkedList.clear();
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      paramIntent = paramIntent.iterator();
      while (paramIntent.hasNext())
      {
        localObject1 = (String)paramIntent.next();
        this.jdField_a_of_type_JavaUtilLinkedList.add(localObject1);
        localObject1 = this.jdField_a_of_type_Agli.a((String)localObject1);
        if (localObject1 != null)
        {
          if (!((LocalMediaInfo)localObject1).mChecked) {
            ((LocalMediaInfo)localObject1).mChecked = true;
          }
          this.jdField_a_of_type_JavaUtilArrayList.add(((LocalMediaInfo)localObject1).position);
        }
      }
      if (this.jdField_a_of_type_Aglg != null) {
        this.jdField_a_of_type_Aglg.a(a());
      }
      this.jdField_a_of_type_Agli.notifyDataSetChanged();
      i();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanel", 2, "onActivityResult, PeakConstants.REQUEST_PHOTOLIST_PANEL_SEND_RETURN");
    }
    b();
  }
  
  public void a(int paramInt, ArrayList<String> paramArrayList, boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, String paramString3, boolean paramBoolean3)
  {
    int i1 = this.jdField_a_of_type_Agli.getItemViewType(paramInt);
    a(paramArrayList, paramBoolean1, paramBoolean2, paramString1, paramString2, paramString3, i1, this.jdField_a_of_type_Agli.a(paramInt));
    boolean bool2 = b();
    Object localObject = new Pair(new ArrayList(), new ArrayList());
    boolean bool1;
    if (this.jdField_a_of_type_Bdmu != null)
    {
      localObject = this.jdField_a_of_type_Bdmu;
      if (this.jdField_c_of_type_Int == 2)
      {
        bool1 = true;
        localObject = ((bdmu)localObject).a(paramArrayList, bool1, this.jdField_a_of_type_JavaUtilMap, null);
        label102:
        if (i1 != 0) {
          break label188;
        }
        if (a(paramArrayList, bool2, this.jdField_c_of_type_Int)) {
          break label144;
        }
      }
    }
    label144:
    label188:
    while (i1 != 1)
    {
      return;
      bool1 = false;
      break;
      ((ArrayList)((Pair)localObject).first).addAll(paramArrayList);
      break label102;
      if (bool2)
      {
        a((ArrayList)((Pair)localObject).first, this.jdField_c_of_type_Int);
        return;
      }
      a((Pair)localObject, paramBoolean1, paramBoolean2, paramString1, paramString2, paramString3, paramBoolean3, this.jdField_c_of_type_Int);
      return;
    }
    if (((ArrayList)((Pair)localObject).first).isEmpty()) {}
    for (paramArrayList = (String)((ArrayList)((Pair)localObject).second).get(0);; paramArrayList = (String)((ArrayList)((Pair)localObject).first).get(0))
    {
      long l1 = a(paramArrayList);
      if (!a(this.jdField_a_of_type_Agli.a(paramArrayList))) {
        break;
      }
      a(paramBoolean2, paramString1, paramString2, paramString3, l1, (Pair)localObject);
      return;
    }
  }
  
  protected void a(akcv paramakcv)
  {
    paramakcv.a();
    if ((paramakcv.jdField_b_of_type_JavaLangString != null) && (!paramakcv.jdField_b_of_type_JavaLangString.equals(""))) {
      paramakcv.a();
    }
  }
  
  protected void a(Intent paramIntent)
  {
    ThreadManager.executeOnSubThread(new PhotoListPanel.2(this, new akcv((BaseActivity)this.jdField_a_of_type_AndroidAppActivity, paramIntent)));
  }
  
  public void a(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_Agli == null) {
      return;
    }
    azqs.b(null, "dc00898", "", "", "0X800A913", "0X800A913", PhotoUtils.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo), 0, "", "", "", "");
    int i1 = this.jdField_a_of_type_Agli.getItemViewType(paramInt);
    if (this.jdField_m_of_type_Boolean)
    {
      b(this.jdField_a_of_type_Agli.a(paramInt).path);
      return;
    }
    ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilLinkedList);
    Object localObject;
    if ((i1 == 0) || (i1 == 1))
    {
      localObject = this.jdField_a_of_type_Agli.a(paramInt).path;
      if ((TextUtils.isEmpty((CharSequence)localObject)) || (!bdhb.b((String)localObject)))
      {
        if (QLog.isColorLevel()) {
          QLog.e("PhotoListPanel", 2, "PhotoListPanel onItemClick,clickPath not exits, just return.");
        }
        QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2131695345, 0).a();
        a();
        this.jdField_a_of_type_JavaUtilLinkedList.clear();
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        i();
        return;
      }
      localObject = new Intent();
      ((Intent)localObject).putExtra("ALBUM_ID", "$RecentAlbumId");
      ((Intent)localObject).putExtra("PhotoConst.SEND_BUSINESS_TYPE", this.jdField_k_of_type_Int);
      ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      ((Intent)localObject).putExtra("PhotoConst.MY_UIN", this.jdField_a_of_type_JavaLangString);
      ((Intent)localObject).putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      ((Intent)localObject).putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString);
      ((Intent)localObject).putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString);
      ((Intent)localObject).putExtra("entrance", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Int);
      ((Intent)localObject).putExtra("PhotoConst.is_troop_send_mixed_msg", this.jdField_n_of_type_Boolean);
      ((Intent)localObject).putExtra("PhotoConst.SHOW_ALBUM", true);
      ((Intent)localObject).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.jdField_b_of_type_JavaUtilArrayList);
      ((Intent)localObject).putExtra("PhotoConst.CURRENT_SELECTED_INDEX", this.jdField_a_of_type_Agli.a(paramInt).position);
      ((Intent)localObject).putStringArrayListExtra("PhotoConst.SELECTED_PATHS", localArrayList);
      ((Intent)localObject).putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", this.jdField_a_of_type_JavaUtilArrayList);
      ((Intent)localObject).putExtra("PhotoConst.ALL_MEDIA_PATHS", (Serializable)this.jdField_a_of_type_JavaUtilMap);
      ((Intent)localObject).putExtra("PhotoConst.editPathMap", aioz.b(this.jdField_a_of_type_JavaUtilHashMap));
      ((Intent)localObject).putExtra("KEY_IS_ANONYMOUS", nav.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
      if (this.jdField_a_of_type_AndroidContentIntent != null)
      {
        ((Intent)localObject).putExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", b());
        ((Intent)localObject).putExtra("session_info", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      if (!(this.jdField_a_of_type_AndroidAppActivity instanceof SplashActivity)) {
        break label998;
      }
      ((Intent)localObject).putExtra("key_pic_to_edit_from", 1);
      ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
      localObject = aepi.a((Intent)localObject, null);
      ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      ((Intent)localObject).putExtra("key_activity_code", ChatActivityUtils.a(this.jdField_a_of_type_AndroidAppActivity));
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 9501) {
        break label1062;
      }
      if (!(this.jdField_a_of_type_AndroidAppActivity instanceof SplashActivity)) {
        break label1044;
      }
      ((Intent)localObject).putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
      localObject = aepi.a((Intent)localObject, null);
      label595:
      ((Intent)localObject).putExtra(bdez.h, 80);
      ((Intent)localObject).putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      ((Intent)localObject).putExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", true);
      label628:
      ((Intent)localObject).putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.jdField_c_of_type_Int);
      ((Intent)localObject).putExtra("keep_selected_status_after_finish", true);
      ((Intent)localObject).putExtra("PhotoConst.IS_OVERLOAD", false);
      ((Intent)localObject).putExtra("PhotoConst.MAXUM_SELECTED_NUM", this.jdField_g_of_type_Int);
      ((Intent)localObject).putExtra("custom_photopreview_sendbtn_report", true);
      ((Intent)localObject).putExtra("custom_photopreview_sendbtn_reportActionName", "0X8005E0A");
      ((Intent)localObject).putExtra("custom_photopreview_sendbtn_reportReverse2", "0");
      ((Intent)localObject).putExtra("custom_photopreview_editbtn_reportActionName", "0X8005E0B");
      ((Intent)localObject).putExtra("custom_photopreview_rawcheckbox_reportActionName", "0X8005E0C");
      ((Intent)localObject).putExtra("KEY_THUMBNAL_BOUND", zjc.a(paramView.findViewById(2131368520)));
      ((Intent)localObject).putExtra("session_info", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      paramView = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60);
      if ((this.jdField_a_of_type_AndroidContentIntent == null) || (!this.jdField_a_of_type_AndroidContentIntent.hasExtra("showFlashPic"))) {
        ((Intent)localObject).putExtra("showFlashPic", alse.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramView, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString));
      }
      ((Intent)localObject).putExtra("PhotoConst.IS_JUMPTO_TROOP_ALBUM", e());
      ((Intent)localObject).setClass(this.jdField_a_of_type_AndroidAppActivity, NewPhotoPreviewActivity.class);
      ((Intent)localObject).putExtra("enter_from", 1);
      ((Intent)localObject).addFlags(603979776);
      this.jdField_a_of_type_AndroidAppActivity.startActivityForResult((Intent)localObject, 100004);
      alok.a(this.jdField_b_of_type_AndroidViewView);
      if ((this.jdField_a_of_type_AndroidAppActivity instanceof SplashActivity)) {
        azqs.b(null, "dc00898", "", "", "0X800A06C", "0X800A06C", 1, 0, this.jdField_a_of_type_JavaUtilLinkedList.size() + "", "", "", "");
      }
    }
    paramView = "";
    if (i1 == 0) {
      paramView = "0";
    }
    for (;;)
    {
      azqs.b(null, "CliOper", "", "", "0X8005E09", "0X8005E09", 0, 0, paramView, "", "", "");
      return;
      label998:
      if ((this.jdField_a_of_type_AndroidAppActivity instanceof LiteActivity))
      {
        ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", LiteActivity.class.getName());
        break;
      }
      ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ChatActivity.class.getName());
      break;
      label1044:
      ((Intent)localObject).putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", ChatActivity.class.getName());
      break label595;
      label1062:
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 6000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 6003))
      {
        ((Intent)localObject).putExtra(bdez.h, 55);
        ((Intent)localObject).putExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", false);
        ((Intent)localObject).putExtra("PhotoConst.IS_SEND_FILESIZE_LIMIT", true);
        break label628;
      }
      ((Intent)localObject).putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SendPhotoActivity.class.getName());
      ((Intent)localObject).putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      ((Intent)localObject).putExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", true);
      ((Intent)localObject).putExtra("key_confess_topicid", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_e_of_type_Int);
      break label628;
      if (i1 == 1) {
        paramView = "1";
      }
    }
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    if (this.jdField_n_of_type_Int != 100006) {
      return;
    }
    this.jdField_n_of_type_Int = -1;
    Intent localIntent = this.jdField_a_of_type_AndroidAppActivity.getIntent();
    if (localIntent.hasExtra("PhotoConst.send_photo_activity_result")) {
      localIntent.removeExtra("PhotoConst.send_photo_activity_result");
    }
    for (;;)
    {
      g();
      paramBaseChatPie.ar();
      return;
      a(1019);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo, Intent paramIntent)
  {
    jdField_m_of_type_Int = a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    if (this.jdField_a_of_type_AndroidContentIntent == null) {
      this.jdField_a_of_type_AndroidContentIntent = new Intent();
    }
    if (this.jdField_a_of_type_AndroidContentIntent.hasExtra("showFlashPic")) {
      this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("showFlashPic", false));
    }
    this.jdField_b_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("key_disable_presend", false);
    this.jdField_e_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("key_disable_quality_cb", false);
    this.jdField_f_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("key_disable_edit_btn", false);
    this.jdField_g_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("key_disable_send_btn", false);
    this.jdField_d_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("key_new_lbs_client", false);
    this.jdField_h_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("key_allow_mix_select", true);
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("key_my_uin");
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("key_my_nick");
    this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("key_my_head_dir");
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanel", 2, "init, mDisablePresend = " + this.jdField_b_of_type_Boolean);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    paramQQAppInterface = this.jdField_a_of_type_AndroidAppActivity.getIntent();
    this.jdField_g_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("PhotoConst.MAXUM_SELECTED_NUM", 20);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 9501)
    {
      this.jdField_g_of_type_Int = 5;
      this.jdField_a_of_type_AndroidContentIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 5);
    }
    this.jdField_h_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("PhotoConst.MAXUM_SELECTED_NUM_VIDEO", 1);
    this.jdField_b_of_type_Long = this.jdField_a_of_type_AndroidContentIntent.getLongExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_SIZE", 1048576000L);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter = MediaFileFilter.getFilter(this.jdField_a_of_type_AndroidContentIntent.getIntExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 0));
    this.jdField_l_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", false);
    this.jdField_m_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("PhotoConst.IS_SINGLE_MODE", false);
    this.jdField_k_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("PhotoConst.SEND_BUSINESS_TYPE", 1052);
    if (this.jdField_l_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter = new DynamicImageMediaFileFilter(MediaFileFilter.MEDIA_FILTER_SHOW_IMAGE);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter.setSupportWebp(true);
    this.jdField_e_of_type_Int = ((int)getResources().getDimension(2131296977));
    this.jdField_f_of_type_Int = ((int)getResources().getDimension(2131296978));
    this.jdField_a_of_type_Apkp = new apkp(this.jdField_i_of_type_Int, this.jdField_f_of_type_Int, this.jdField_f_of_type_Int);
    this.jdField_b_of_type_Apkp = new apkp(this.jdField_j_of_type_Int, this.jdField_f_of_type_Int, this.jdField_f_of_type_Int);
    if (paramQQAppInterface.hasExtra("PhotoConst.SELECTED_PATHS"))
    {
      paramActivity = paramQQAppInterface.getStringArrayListExtra("PhotoConst.SELECTED_PATHS");
      if (paramActivity != null) {
        this.jdField_a_of_type_JavaUtilLinkedList.addAll(paramActivity);
      }
      paramActivity = paramQQAppInterface.getIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS");
      if (paramActivity != null) {
        this.jdField_a_of_type_JavaUtilArrayList.addAll(paramActivity);
      }
      paramQQAppInterface.removeExtra("PhotoConst.SELECTED_PATHS");
      paramQQAppInterface.removeExtra("PhotoConst.SELECTED_INDEXS");
      if (this.jdField_a_of_type_Aglg != null) {
        this.jdField_a_of_type_Aglg.a(a());
      }
      this.jdField_a_of_type_Bdmu = new bdmu().a(this.jdField_d_of_type_Int).a(d());
      this.jdField_d_of_type_AndroidViewView = findViewById(2131378135);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131362448));
      this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131369993));
      this.jdField_b_of_type_AndroidViewView = findViewById(2131371566);
      this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131373968));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131373974));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131373969));
      this.jdField_a_of_type_AndroidViewView = findViewById(2131371203);
      this.jdField_c_of_type_AndroidWidgetButton = ((Button)findViewById(2131376395));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      if (!this.jdField_e_of_type_Boolean) {
        break label1001;
      }
      this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      label776:
      if (this.jdField_f_of_type_Boolean) {
        this.jdField_b_of_type_AndroidWidgetButton.setVisibility(4);
      }
      if (this.jdField_g_of_type_Boolean) {
        this.jdField_c_of_type_AndroidWidgetButton.setVisibility(4);
      }
      this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)findViewById(2131366598));
      switch (jdField_m_of_type_Int)
      {
      default: 
        this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager = new StaggeredGridLayoutManager(1, 0);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Agli = new agli(this);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Agli);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addOnScrollListener(new agkx(this));
      this.jdField_a_of_type_AndroidContentSharedPreferences = BaseApplication.getContext().getSharedPreferences("share", 4);
      i();
      b();
      h();
      return;
      if (!this.jdField_a_of_type_AndroidContentIntent.hasExtra("PhotoConst.SELECTED_PATHS")) {
        break;
      }
      paramQQAppInterface = this.jdField_a_of_type_AndroidContentIntent.getStringArrayListExtra("PhotoConst.SELECTED_PATHS");
      if (paramQQAppInterface != null) {
        this.jdField_a_of_type_JavaUtilLinkedList.addAll(paramQQAppInterface);
      }
      paramQQAppInterface = this.jdField_a_of_type_AndroidContentIntent.getIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS");
      if (paramQQAppInterface == null) {
        break;
      }
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramQQAppInterface);
      break;
      label1001:
      this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
      this.jdField_a_of_type_AndroidWidgetCheckBox.setContentDescription(alud.a(2131708512));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(alud.a(2131708487));
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
      break label776;
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager = new GridLayoutManager(getContext(), 2);
      ((GridLayoutManager)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager).setOrientation(0);
    }
  }
  
  void a(Pair<ArrayList<String>, ArrayList<String>> paramPair, boolean paramBoolean)
  {
    if (((ArrayList)paramPair.first).isEmpty()) {}
    LocalMediaInfo localLocalMediaInfo;
    for (String str = (String)((ArrayList)paramPair.second).get(0);; str = (String)((ArrayList)paramPair.first).get(0))
    {
      localLocalMediaInfo = this.jdField_a_of_type_Agli.a(str);
      if (localLocalMediaInfo != null) {
        break;
      }
      return;
    }
    awiw.a("TAG", "sendVideo", "info = " + localLocalMediaInfo + ",sendInBackground = " + paramBoolean);
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, SendVideoActivity.class);
    localIntent.putExtra("send_in_background", paramBoolean);
    if (!((ArrayList)paramPair.second).isEmpty())
    {
      paramPair = new ArrayList(1);
      paramPair.add(str);
      localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS_BY_FILE", paramPair);
    }
    for (;;)
    {
      localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      localIntent.putExtra("PhotoConst.SEND_SIZE_SPEC", this.jdField_c_of_type_Int);
      localIntent.putExtra("file_source", "album_flow");
      paramPair = this.jdField_a_of_type_AndroidAppActivity.getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
      str = this.jdField_a_of_type_AndroidAppActivity.getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", paramPair);
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", str);
      if (!localLocalMediaInfo.isSystemMeidaStore) {
        azqs.b(null, "CliOper", "", "", "0X8006130", "0X8006130", 0, 0, "", "", "", "");
      }
      if (this.jdField_c_of_type_Int == 2) {
        bdfa.a(0, 1);
      }
      localIntent.putExtra("start_init_activity_after_sended", false);
      if (!paramBoolean) {
        break;
      }
      a(localIntent);
      return;
      localIntent.putExtra("file_send_path", str);
      localIntent.putExtra("file_send_size", localLocalMediaInfo.fileSize);
      localIntent.putExtra("file_send_duration", localLocalMediaInfo.mDuration);
    }
    this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
  }
  
  protected void a(Pair<ArrayList<String>, ArrayList<String>> paramPair, boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, String paramString3, boolean paramBoolean3, int paramInt)
  {
    if (paramBoolean2)
    {
      localIntent = new Intent();
      localIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", this.jdField_k_of_type_Int);
      localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", (ArrayList)paramPair.first);
      if ((paramPair.second != null) && (!((ArrayList)paramPair.second).isEmpty())) {
        localIntent.putExtra("PhotoConst.PHOTO_PATHS_BY_FILE", (Serializable)paramPair.second);
      }
      localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      localIntent.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString);
      localIntent.putExtra("key_confess_topicid", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_e_of_type_Int);
      localIntent.putExtra("PhotoConst.SEND_SIZE_SPEC", paramInt);
      localIntent.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
      localIntent.putExtra("send_in_background", true);
      localIntent.putExtra("entrance", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Int);
      if (((ArrayList)paramPair.first).size() == 1) {
        localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", (Serializable)paramPair.first);
      }
      b(localIntent);
      azqs.b(null, "CliOper", "", "", paramString1, paramString1, 0, 0, paramString2, paramString3, "", "");
      return;
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, SendPhotoActivity.class);
    localIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", this.jdField_k_of_type_Int);
    localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", (ArrayList)paramPair.first);
    if ((paramPair.second != null) && (!((ArrayList)paramPair.second).isEmpty())) {
      localIntent.putExtra("PhotoConst.PHOTO_PATHS_BY_FILE", (Serializable)paramPair.second);
    }
    localIntent.putExtra("PhotoConst.PHOTO_COUNT", ((ArrayList)paramPair.first).size());
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    localIntent.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString);
    localIntent.putExtra("key_confess_topicid", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_e_of_type_Int);
    localIntent.putExtra("PhotoConst.SEND_SIZE_SPEC", paramInt);
    localIntent.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
    localIntent.putExtra("entrance", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Int);
    if (((ArrayList)paramPair.first).size() == 1) {
      localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", (Serializable)paramPair.first);
    }
    if (paramBoolean3)
    {
      localIntent.putExtra("key_is_sync_qzone", 1);
      if (this.jdField_d_of_type_JavaLangString == null) {
        break label547;
      }
    }
    label547:
    for (paramPair = this.jdField_d_of_type_JavaLangString;; paramPair = "")
    {
      localIntent.putExtra("key_qzone_album_id", paramPair);
      localIntent.putExtra("key_qzone_batch_id", PhotoUtils.a());
      a(paramBoolean1, paramInt, localIntent);
      break;
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_b_of_type_Boolean) {}
    while (!this.jdField_c_of_type_Boolean) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanel", 2, "cancelPresendPic, path = " + paramString);
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("key_presend_path", paramString);
    localBundle.putInt("key_presend_cancel_type", 1018);
    RichmediaService.c(localBundle);
  }
  
  public void a(String paramString, int paramInt)
  {
    if (this.jdField_b_of_type_Boolean) {}
    while (!this.jdField_c_of_type_Boolean) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanel", 2, "presendPic, path = " + paramString);
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("key_presend_path", paramString);
    localBundle.putInt("entrance", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Int);
    RichmediaService.b(localBundle);
  }
  
  protected void a(ArrayList<String> paramArrayList, int paramInt)
  {
    axlk.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramArrayList, paramInt);
  }
  
  public void a(@NonNull ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanel", 2, "sendMedias, paths.size() = " + paramArrayList1.size() + ",allowPresend = " + paramBoolean);
    }
    boolean bool2 = a(paramArrayList1);
    boolean bool1 = bool2;
    if (!bool2) {
      bool1 = a(paramArrayList2);
    }
    if (!bool1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PhotoListPanel", 2, "PhotoListPanel sendMedias,pics not exits, just return.");
      }
      if ((d()) || (!paramArrayList1.isEmpty()) || (!paramArrayList2.isEmpty())) {
        QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2131695349, 0).a();
      }
      a();
      this.jdField_a_of_type_JavaUtilLinkedList.clear();
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      i();
    }
    do
    {
      do
      {
        return;
      } while (!c());
      if (!a(paramArrayList1, paramArrayList2)) {
        break;
      }
      String str = getResources().getString(2131719750);
      paramArrayList1 = new PhotoListPanel.8(this, paramArrayList1, paramArrayList2, paramBoolean);
      if (bezm.a(this.jdField_a_of_type_AndroidAppActivity, 4, new agld(this, paramArrayList1))) {
        bdgm.a(this.jdField_a_of_type_AndroidAppActivity, 232, null, str, new agky(this, paramArrayList1), new agkz(this)).show();
      }
    } while (!QLog.isColorLevel());
    QLog.i("PhotoListPanel", 2, "show shortvideo_mobile_send_confirm dialog");
    return;
    if (this.jdField_a_of_type_Aglh != null) {
      this.jdField_a_of_type_Aglh.a();
    }
    b(paramArrayList1, paramArrayList2, paramBoolean);
  }
  
  protected void a(ArrayList<String> paramArrayList, boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, String paramString3, int paramInt, LocalMediaInfo paramLocalMediaInfo)
  {
    this.jdField_a_of_type_JavaUtilArrayList.remove(paramLocalMediaInfo.position);
    this.jdField_a_of_type_JavaUtilLinkedList.remove(paramLocalMediaInfo.path);
    c();
    if (this.jdField_a_of_type_Aglg != null) {
      this.jdField_a_of_type_Aglg.a(a());
    }
    i();
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanel", 2, "sendMedias, type = " + paramInt + ", paths.size() = " + paramArrayList.size() + " mediaInfo:" + paramLocalMediaInfo + ",allowPresend = " + paramBoolean1 + ",sendInBackground = " + paramBoolean2 + ",reportActionName = " + paramString1 + ",reverse2 = " + paramString2 + ",reverse3 = " + paramString3);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0) {
        this.jdField_a_of_type_Agli.a();
      }
      this.jdField_a_of_type_JavaUtilLinkedList.clear();
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      if (this.jdField_a_of_type_Aglg != null) {
        this.jdField_a_of_type_Aglg.a(null);
      }
      this.jdField_a_of_type_Agli.notifyDataSetChanged();
      this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      Intent localIntent = this.jdField_a_of_type_AndroidAppActivity.getIntent();
      if (localIntent != null)
      {
        localIntent.removeExtra("PhotoConst.SELECTED_PATHS");
        localIntent.removeExtra("PhotoConst.SELECTED_INDEXS");
        localIntent.removeExtra("PhotoConst.editPathMap");
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanel", 2, "resetStatus selectSize:" + this.jdField_a_of_type_JavaUtilLinkedList.size() + ", clear:" + paramBoolean);
    }
    i();
    setMixedMsgMode(false);
  }
  
  protected void a(boolean paramBoolean, int paramInt, Intent paramIntent)
  {
    if (paramBoolean)
    {
      if (paramInt == 2)
      {
        Object localObject = BaseApplication.getContext();
        if (Build.VERSION.SDK_INT > 10) {}
        for (paramInt = 4;; paramInt = 0)
        {
          localObject = ((BaseApplication)localObject).getSharedPreferences("presend_config_sp", paramInt);
          ((SharedPreferences)localObject).edit().putBoolean("key_presend_off_flag", true).commit();
          ((SharedPreferences)localObject).edit().putLong("key_presend_off_time", System.currentTimeMillis()).commit();
          a(1020);
          this.jdField_a_of_type_AndroidAppActivity.startActivityForResult(paramIntent, 100005);
          return;
        }
      }
      if (a(paramIntent))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoListPanel", 2, "sendMedias,start sendPhotoAcitivy,  addPresendMgrHandlerToIntent OK");
        }
        this.jdField_a_of_type_AndroidAppActivity.startActivityForResult(paramIntent, 100005);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PhotoListPanel", 2, "sendMedias,start sendPhotoAcitivy,  addPresendMgrHandlerToIntent failed");
      }
      this.jdField_a_of_type_AndroidAppActivity.startActivity(paramIntent);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanel", 2, "sendMedias,start sendPhotoAcitivy, not presend");
    }
    this.jdField_a_of_type_AndroidAppActivity.startActivity(paramIntent);
  }
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, long paramLong, Pair<ArrayList<String>, ArrayList<String>> paramPair)
  {
    if ((azdd.jdField_b_of_type_Long != 0L) && (System.currentTimeMillis() - azdd.jdField_b_of_type_Long < 300000L)) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PhotoListPanel", 2, "upload video isConfirmed=" + bool + " allowUploadInXGTime=" + azdd.jdField_b_of_type_Long);
      }
      if (!a(paramLong, bool)) {
        break;
      }
      String str = ShortVideoUtils.a(this.jdField_a_of_type_AndroidAppActivity, paramLong);
      str = String.format(getResources().getString(2131720118), new Object[] { str });
      paramString1 = new PhotoListPanel.4(this, paramPair, paramBoolean, paramString1, paramString2, paramString3);
      if (bezm.a(this.jdField_a_of_type_AndroidAppActivity, 4, new agla(this, paramString1))) {
        bdgm.a(this.jdField_a_of_type_AndroidAppActivity, 232, null, str, new aglb(this, paramString1), new aglc(this)).show();
      }
      if (QLog.isColorLevel()) {
        QLog.i("PhotoListPanel", 2, "show shortvideo_mobile_send_confirm dialog");
      }
      return;
    }
    if ((!((ArrayList)paramPair.first).isEmpty()) || (!((ArrayList)paramPair.second).isEmpty())) {
      a(paramPair, paramBoolean);
    }
    azqs.b(null, "CliOper", "", "", paramString1, paramString1, 0, 0, paramString2, paramString3, "", "");
  }
  
  protected boolean a()
  {
    if (b() == 0) {}
    while ((this.o) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1000) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1004))) {
      return false;
    }
    return true;
  }
  
  protected boolean a(long paramLong, boolean paramBoolean)
  {
    return (bdin.b(this.jdField_a_of_type_AndroidAppActivity)) && (!paramBoolean) && (paramLong >= 1048576L);
  }
  
  protected boolean a(Intent paramIntent)
  {
    return RichmediaService.a(paramIntent);
  }
  
  protected boolean a(LocalMediaInfo paramLocalMediaInfo)
  {
    paramLocalMediaInfo = Environment.getExternalStorageDirectory();
    if ((paramLocalMediaInfo.exists()) && (paramLocalMediaInfo.canWrite()))
    {
      i1 = 1;
      if ((!Environment.getExternalStorageState().equals("mounted")) || (i1 == 0)) {
        break label75;
      }
    }
    label75:
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 != 0) {
        break label80;
      }
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 1, 2131719547, 0).b(getResources().getDimensionPixelSize(2131298914));
      return false;
      i1 = 0;
      break;
    }
    label80:
    if (bdeu.b() <= 512000L)
    {
      ShortVideoPreviewActivity.a(this.jdField_a_of_type_AndroidAppActivity, 2131720143);
      return false;
    }
    return true;
  }
  
  public boolean a(String paramString)
  {
    int i1 = c();
    int i2 = d();
    return (!TextUtils.isEmpty(paramString)) && (i1 > 0) && (i2 == 0);
  }
  
  protected boolean a(ArrayList<String> paramArrayList)
  {
    if (paramArrayList == null) {
      return false;
    }
    paramArrayList = paramArrayList.iterator();
    do
    {
      if (!paramArrayList.hasNext()) {
        break;
      }
    } while (!bdhb.b((String)paramArrayList.next()));
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  protected boolean a(ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2)
  {
    if ((paramArrayList2 != null) && (!paramArrayList2.isEmpty())) {}
    for (int i1 = 1;; i1 = 0)
    {
      int i2 = 0;
      int i3 = i1;
      if (i2 < paramArrayList1.size())
      {
        paramArrayList2 = (String)paramArrayList1.get(i2);
        if (this.jdField_a_of_type_Agli.a(paramArrayList2) == 1) {
          i3 = 1;
        }
      }
      else
      {
        if ((azdd.jdField_b_of_type_Long == 0L) || (System.currentTimeMillis() - azdd.jdField_b_of_type_Long >= 300000L)) {
          break label155;
        }
      }
      label155:
      for (boolean bool = true;; bool = false)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoListPanel", 2, "upload video isConfirmed=" + bool + " allowUploadInXGTime=" + azdd.jdField_b_of_type_Long);
        }
        if ((!bdin.b(this.jdField_a_of_type_AndroidAppActivity)) || (bool) || (i3 == 0)) {
          break label161;
        }
        return true;
        i2 += 1;
        break;
      }
      label161:
      return false;
    }
  }
  
  protected boolean a(ArrayList<String> paramArrayList, boolean paramBoolean, int paramInt)
  {
    if (!a(paramArrayList))
    {
      if (QLog.isColorLevel()) {
        QLog.e("PhotoListPanel", 2, "PhotoListPanel sendMedias,pics not exits, just return.");
      }
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2131695345, 0).a();
      a();
      this.jdField_a_of_type_JavaUtilLinkedList.clear();
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      if (this.jdField_a_of_type_Aglg != null) {
        this.jdField_a_of_type_Aglg.a(null);
      }
      i();
      return false;
    }
    return true;
  }
  
  public boolean a(boolean paramBoolean, BaseChatPie paramBaseChatPie)
  {
    Object localObject2 = new ArrayList(this.jdField_a_of_type_JavaUtilLinkedList);
    Object localObject1 = new Pair(new ArrayList(), new ArrayList());
    boolean bool;
    label76:
    int i1;
    if (this.jdField_a_of_type_Bdmu != null)
    {
      localObject1 = this.jdField_a_of_type_Bdmu;
      if (this.jdField_c_of_type_Int == 2)
      {
        bool = true;
        localObject1 = ((bdmu)localObject1).a((List)localObject2, bool, this.jdField_a_of_type_JavaUtilMap, null);
        Object localObject3 = (bcpg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
        if ((c() <= 0) || (!paramBoolean) || (paramBaseChatPie == null) || (((ArrayList)((Pair)localObject1).first).isEmpty())) {
          break label639;
        }
        if ((paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo != null) && (TextUtils.isEmpty(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mAnonymousNickName)))
        {
          paramBaseChatPie.a(new acjt());
          if (((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) == null) {
            break label623;
          }
          paramBoolean = true;
          label178:
          localObject2 = bdgc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgSenderUin + "");
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          localObject4 = paramBaseChatPie.jdField_a_of_type_AndroidContentContext;
          localObject5 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
          str = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgSenderUin + "";
          localObject6 = paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {
            break label628;
          }
          bool = true;
          label296:
          localObject2 = bciq.a((QQAppInterface)localObject3, (Context)localObject4, (String)localObject5, str, (String)localObject2, paramBoolean, (EditText)localObject6, bool, true);
          if ((localObject2 != null) && (((SpannableString)localObject2).length() != 0)) {
            paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().insert(0, (CharSequence)localObject2);
          }
          localObject2 = agws.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo);
          paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mType = 0;
          if (((localObject2 instanceof MessageForPic)) || ((localObject2 instanceof MessageForMixedMsg))) {
            paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.oriMsgType = 1;
          }
        }
        localObject2 = new ArrayList();
        localObject3 = bciq.a(paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText(), (ArrayList)localObject2);
        Object localObject4 = (aufc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(174);
        Object localObject5 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
        i1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
        Object localObject6 = (ArrayList)((Pair)localObject1).first;
        if (this.jdField_c_of_type_Int != 2) {
          break label634;
        }
        paramBoolean = true;
        label476:
        ((aufc)localObject4).a((QQAppInterface)localObject5, str, i1, (ArrayList)localObject6, paramBoolean, (String)localObject3, (ArrayList)localObject2, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo);
        paramBaseChatPie.ba();
        if (!((ArrayList)((Pair)localObject1).second).isEmpty()) {
          a(new ArrayList(), (ArrayList)((Pair)localObject1).second, this.jdField_c_of_type_Boolean);
        }
        paramBoolean = true;
        g();
        if (paramBoolean)
        {
          i1 = 0;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 0) {
            break label738;
          }
          i1 = 1;
        }
      }
    }
    for (;;)
    {
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8009BEB", "0X8009BEB", i1, 0, "", "", "", "");
      return paramBoolean;
      bool = false;
      break;
      ((ArrayList)((Pair)localObject1).first).addAll((Collection)localObject2);
      break label76;
      label623:
      paramBoolean = false;
      break label178;
      label628:
      bool = false;
      break label296;
      label634:
      paramBoolean = false;
      break label476;
      label639:
      ajrw.a((List)localObject2);
      if ((e()) && (a())) {}
      for (i1 = 1;; i1 = 0)
      {
        a((ArrayList)((Pair)localObject1).first, (ArrayList)((Pair)localObject1).second, this.jdField_c_of_type_Boolean);
        if (i1 != 0)
        {
          paramBaseChatPie = new LpReportInfo_pf00064(723, 1, 5);
          LpReportManager.getInstance().reportToPF00064(paramBaseChatPie, false, false);
          bjre.a(8);
          a("aio_sync_qzone", "operation_type", "panel_upload");
        }
        paramBoolean = false;
        break;
      }
      label738:
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
        i1 = 2;
      } else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {
        i1 = 3;
      }
    }
  }
  
  protected int b()
  {
    return QzoneConfig.getInstance().getConfig("PhotoUpload", "C2CAioEnableSyncImageToQzone", 1);
  }
  
  public void b()
  {
    if (this.jdField_b_of_type_Boolean) {}
    do
    {
      return;
      this.jdField_c_of_type_Boolean = aetu.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_d_of_type_Boolean);
      if (QLog.isColorLevel()) {
        QLog.d("PhotoListPanel", 2, "initPresend! mAllowPresend = " + this.jdField_c_of_type_Boolean);
      }
    } while (!this.jdField_c_of_type_Boolean);
    BinderWarpper localBinderWarpper = new BinderWarpper(new awka(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_e_of_type_Int).asBinder());
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("binder_presendService", localBinderWarpper);
    RichmediaService.a(localBundle);
  }
  
  protected void b(Intent paramIntent)
  {
    ThreadManager.post(new SendPhotoTask((BaseActivity)this.jdField_a_of_type_AndroidAppActivity, paramIntent, null), 8, null, false);
  }
  
  void b(String paramString)
  {
    Intent localIntent = new Intent();
    if (this.jdField_a_of_type_AndroidContentIntent != null) {
      localIntent.putExtras(this.jdField_a_of_type_AndroidContentIntent);
    }
    localIntent.putExtra("ALBUM_ID", "$RecentAlbumId");
    localIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", this.jdField_k_of_type_Int);
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    localIntent.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString);
    localIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString);
    HotChatManager localHotChatManager = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60);
    if ((this.jdField_a_of_type_AndroidContentIntent == null) || (!this.jdField_a_of_type_AndroidContentIntent.hasExtra("showFlashPic"))) {
      localIntent.putExtra("showFlashPic", alse.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localHotChatManager, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString));
    }
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof SplashActivity))
    {
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
      localIntent = aepi.a(localIntent, null);
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      localIntent.putExtra("key_activity_code", ChatActivityUtils.a(this.jdField_a_of_type_AndroidAppActivity));
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 9501) {
        break label461;
      }
      if (!(this.jdField_a_of_type_AndroidAppActivity instanceof SplashActivity)) {
        break label444;
      }
      localIntent.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
      localIntent = aepi.a(localIntent, null);
      label265:
      localIntent.putExtra(bdez.h, 80);
      localIntent.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      localIntent.putExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", false);
    }
    for (;;)
    {
      localIntent.putExtra("PhotoConst.DEST_VIDEO_ACTIVITY_CLASS_NAME", SendVideoActivity.class.getName());
      localIntent.putExtra("PhotoConst.DEST_VIDEO_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      localIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.jdField_c_of_type_Int);
      localIntent.putExtra("PhotoConst.IS_OVERLOAD", false);
      localIntent.addFlags(603979776);
      localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
      localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramString);
      localIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", this.jdField_k_of_type_Int);
      localIntent.putExtra("PhotoConst.ALLOW_LOCK", false);
      localIntent.setClass(this.jdField_a_of_type_AndroidAppActivity, NewPhotoPreviewActivity.class);
      localIntent.putExtra("enter_from", 1);
      localIntent.addFlags(603979776);
      this.jdField_a_of_type_AndroidAppActivity.startActivityForResult(localIntent, 2);
      return;
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ChatActivity.class.getName());
      break;
      label444:
      localIntent.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", ChatActivity.class.getName());
      break label265;
      label461:
      localIntent.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SendPhotoActivity.class.getName());
      localIntent.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      localIntent.putExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", true);
      localIntent.putExtra("key_confess_topicid", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_e_of_type_Int);
    }
  }
  
  void b(@NonNull ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, boolean paramBoolean)
  {
    boolean bool = b();
    int i6 = this.jdField_c_of_type_Int;
    HashMap localHashMap = new HashMap();
    int i2 = 0;
    int i3 = 0;
    int i1 = 0;
    if (i2 < paramArrayList1.size())
    {
      localObject = (String)paramArrayList1.get(i2);
      int i4;
      int i5;
      if (this.jdField_a_of_type_Agli.a((String)localObject) == 1)
      {
        localObject = this.jdField_a_of_type_Agli.a((String)localObject);
        i4 = i3;
        i5 = i1;
        if (localObject != null)
        {
          SendVideoActivity.SendVideoInfo localSendVideoInfo = new SendVideoActivity.SendVideoInfo();
          localSendVideoInfo.fileSize = ((LocalMediaInfo)localObject).fileSize;
          localSendVideoInfo.duration = ((LocalMediaInfo)localObject).mDuration;
          localHashMap.put(Integer.valueOf(i2), localSendVideoInfo);
          i5 = i1 + 1;
          i4 = i3;
        }
      }
      for (;;)
      {
        i2 += 1;
        i3 = i4;
        i1 = i5;
        break;
        i4 = i3 + 1;
        i5 = i1;
      }
    }
    if ((bool) && (i3 > 0) && (i1 == 0))
    {
      a(paramArrayList1, i6);
      return;
    }
    Object localObject = new Intent(this.jdField_a_of_type_AndroidAppActivity, SendPhotoActivity.class);
    ((Intent)localObject).putStringArrayListExtra("PhotoConst.PHOTO_PATHS_BY_FILE", paramArrayList2);
    ((Intent)localObject).putExtra("PhotoConst.SEND_BUSINESS_TYPE", this.jdField_k_of_type_Int);
    ((Intent)localObject).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", paramArrayList1);
    if (!localHashMap.isEmpty()) {
      ((Intent)localObject).putExtra("PhotoConst.VIDEO_INFOS", localHashMap);
    }
    ((Intent)localObject).putExtra("PhotoConst.PHOTO_COUNT", paramArrayList1.size());
    ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    ((Intent)localObject).putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    ((Intent)localObject).putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString);
    ((Intent)localObject).putExtra("key_confess_topicid", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_e_of_type_Int);
    ((Intent)localObject).putExtra("PhotoConst.SEND_SIZE_SPEC", i6);
    ((Intent)localObject).putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
    ((Intent)localObject).putExtra("entrance", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Int);
    if (paramArrayList1.size() == 1) {
      ((Intent)localObject).putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramArrayList1);
    }
    a(paramBoolean, i6, (Intent)localObject);
    azqs.b(null, "CliOper", "", "", "0X8009AAF", "0X8009AAF", PhotoUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo), 0, String.valueOf(i3), String.valueOf(i1), "", "");
  }
  
  protected boolean b()
  {
    return this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", false);
  }
  
  public int c()
  {
    int i1 = 0;
    int i3;
    for (int i2 = 0; i1 < this.jdField_a_of_type_JavaUtilLinkedList.size(); i2 = i3)
    {
      i3 = i2;
      if (this.jdField_a_of_type_Agli.a((String)this.jdField_a_of_type_JavaUtilLinkedList.get(i1)) == 0) {
        i3 = i2 + 1;
      }
      i1 += 1;
    }
    return i2;
  }
  
  public void c()
  {
    Object localObject1;
    Object localObject2;
    switch (jdField_m_of_type_Int)
    {
    default: 
      localObject1 = ((StaggeredGridLayoutManager)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager).findFirstVisibleItemPositions(null);
      localObject2 = ((StaggeredGridLayoutManager)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager).findLastVisibleItemPositions(null);
      if (localObject1.length <= 0) {
        break;
      }
    }
    for (int i2 = localObject1[0];; i2 = 0)
    {
      int i1;
      if (localObject2.length > 0) {
        i1 = localObject2[0];
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("check", 2, "updateCheckView first=" + i2 + "lastvisible=" + i1);
        }
        label111:
        if (i2 <= i1)
        {
          localObject1 = (aglk)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.findViewHolderForAdapterPosition(i2);
          localObject2 = this.jdField_a_of_type_Agli.a(i2);
          if (localObject2 != null)
          {
            int i3 = this.jdField_a_of_type_JavaUtilLinkedList.indexOf(((LocalMediaInfo)localObject2).path);
            if (QLog.isColorLevel()) {
              QLog.d("check", 2, "updateCheckView mIndex=" + i3);
            }
            if ((i3 < 0) || (localObject1 == null)) {
              break label251;
            }
            ((aglk)localObject1).a.setCheckedNumber(i3 + 1);
            ((aglk)localObject1).b.setVisibility(0);
          }
          for (;;)
          {
            i2 += 1;
            break label111;
            i2 = ((GridLayoutManager)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager).findFirstVisibleItemPosition();
            i1 = ((GridLayoutManager)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager).findLastVisibleItemPosition();
            break;
            label251:
            if (localObject1 == null)
            {
              if (QLog.isColorLevel()) {
                QLog.d("check", 2, "updateCheckView view is null?????=");
              }
            }
            else
            {
              ((aglk)localObject1).a.setChecked(false);
              ((aglk)localObject1).b.setVisibility(4);
            }
          }
        }
        return;
        i1 = 0;
      }
    }
  }
  
  protected boolean c()
  {
    File localFile = Environment.getExternalStorageDirectory();
    if ((localFile.exists()) && (localFile.canWrite()))
    {
      i1 = 1;
      if ((!Environment.getExternalStorageState().equals("mounted")) || (i1 == 0)) {
        break label75;
      }
    }
    label75:
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 != 0) {
        break label80;
      }
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 1, 2131719547, 0).b(getResources().getDimensionPixelSize(2131298914));
      return false;
      i1 = 0;
      break;
    }
    label80:
    if (bdeu.b() <= 512000L)
    {
      ShortVideoPreviewActivity.a(this.jdField_a_of_type_AndroidAppActivity, 2131720143);
      return false;
    }
    return true;
  }
  
  public int d()
  {
    int i1 = 0;
    int i3;
    for (int i2 = 0; i1 < this.jdField_a_of_type_JavaUtilLinkedList.size(); i2 = i3)
    {
      i3 = i2;
      if (this.jdField_a_of_type_Agli.a((String)this.jdField_a_of_type_JavaUtilLinkedList.get(i1)) == 1) {
        i3 = i2 + 1;
      }
      i1 += 1;
    }
    return i2;
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanel", 2, "onEditBtnClicked");
    }
    if (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0)
    {
      Intent localIntent = EditPicActivity.a(this.jdField_a_of_type_AndroidAppActivity, (String)this.jdField_a_of_type_JavaUtilLinkedList.get(0), true, true, true, true, true, 2, 99, 5);
      localIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.jdField_c_of_type_Int);
      localIntent.putExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", b());
      localIntent.putExtra("key_enable_edit_title_bar", true);
      this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
      if ((this.jdField_a_of_type_AndroidAppActivity instanceof SplashActivity)) {
        azqs.b(null, "dc00898", "", "", "0X800A06B", "0X800A06B", 0, 0, "", "", "", "");
      }
    }
  }
  
  public boolean d()
  {
    return (!b()) && (!nav.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    getParent().requestDisallowInterceptTouchEvent(true);
    if (this.jdField_a_of_type_Agln != null)
    {
      this.jdField_a_of_type_Agln.onTouch(this, paramMotionEvent);
      super.dispatchTouchEvent(paramMotionEvent);
      this.jdField_a_of_type_Agln.jdField_c_of_type_Float = paramMotionEvent.getX();
      this.jdField_a_of_type_Agln.d = paramMotionEvent.getY();
      return true;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public int e()
  {
    int i1 = 0;
    if (this.jdField_a_of_type_JavaUtilLinkedList != null) {
      i1 = this.jdField_a_of_type_JavaUtilLinkedList.size();
    }
    return i1;
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanel", 2, "onAlbumBtnClicked");
    }
    if ((this.jdField_a_of_type_Agle != null) && (this.jdField_a_of_type_Agle.a(this))) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {}
    try
    {
      ((amdu)((QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_a_of_type_JavaLangString)).a(20)).e(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true);
      if (!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty())
      {
        ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilLinkedList);
        if (this.jdField_m_of_type_Boolean) {
          this.jdField_a_of_type_AndroidContentIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
        }
        this.jdField_a_of_type_AndroidContentIntent.putExtra("fromPhotoListPanel", true);
        this.jdField_a_of_type_AndroidContentIntent.putExtra("peakconstant.request_code", 100006);
        this.jdField_a_of_type_AndroidContentIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.jdField_c_of_type_Int);
        this.jdField_a_of_type_AndroidContentIntent.putExtra("PhotoConst.is_troop_send_mixed_msg", this.jdField_n_of_type_Boolean);
        this.jdField_a_of_type_AndroidContentIntent.putExtra("PhotoConst.DISABLE_UPLOAD_TO_TROOP_ALBUM", this.jdField_i_of_type_Boolean);
        this.jdField_a_of_type_AndroidContentIntent.putExtra("PhotoConst.UPLOAD_CHECKBOX_IS_CHECKED", e());
        this.jdField_a_of_type_AndroidContentIntent.putExtra("PhotoConst.AIO_TO_PHOTO_LIST_NEED_SHOW_UPLOAD_BAR", a());
        if ((this.jdField_a_of_type_JavaUtilHashMap != null) && (!this.jdField_a_of_type_JavaUtilHashMap.isEmpty())) {
          this.jdField_a_of_type_AndroidContentIntent.putExtra("PhotoConst.SEND_NO_PRESEND", true);
        }
        aetu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localArrayList, this.jdField_a_of_type_AndroidContentIntent, this.jdField_a_of_type_JavaUtilHashMap);
        g();
        azqs.b(null, "CliOper", "", "", "0X8005E05", "0X8005E05", 0, 0, "", "", "", "");
        k();
        return;
      }
    }
    catch (AccountNotMatchException localAccountNotMatchException)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("PhotoListPanel", 2, "onAlbumBtnClicked() getAppRuntime ERROR");
          continue;
          Object localObject = null;
        }
      }
    }
  }
  
  protected int f()
  {
    return (int)bazm.a();
  }
  
  protected void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanel", 2, "onSendBtnClicked");
    }
    if ((this.jdField_a_of_type_Agle != null) && (this.jdField_a_of_type_Agle.b(this))) {
      return;
    }
    a(false, null);
  }
  
  public void g()
  {
    a(true);
  }
  
  public void h()
  {
    if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null))
    {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setBackgroundColor(-16777216);
      this.jdField_c_of_type_AndroidWidgetButton.setTextColor(-1509949441);
    }
  }
  
  public void i()
  {
    Object localObject1 = getResources().getString(2131695307);
    if (e()) {
      localObject1 = getResources().getString(2131695309);
    }
    if (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0)
    {
      bool = true;
      Object localObject2 = localObject1;
      if (bool)
      {
        this.jdField_c_of_type_AndroidWidgetButton.setContentDescription((String)localObject1 + this.jdField_a_of_type_JavaUtilLinkedList.size() + alud.a(2131708492));
        localObject2 = (String)localObject1 + "(" + this.jdField_a_of_type_JavaUtilLinkedList.size() + ")";
      }
      this.jdField_c_of_type_AndroidWidgetButton.setText((CharSequence)localObject2);
      this.jdField_c_of_type_AndroidWidgetButton.setEnabled(bool);
      if (bool) {
        break label215;
      }
      this.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
      this.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(true);
      this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
      this.jdField_b_of_type_AndroidWidgetTextView.setEnabled(true);
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      j();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Aglg != null) {
        this.jdField_a_of_type_Aglg.a(e());
      }
      return;
      bool = false;
      break;
      label215:
      if (this.jdField_a_of_type_Agli.a((String)this.jdField_a_of_type_JavaUtilLinkedList.peek()) != 1) {
        break label266;
      }
      this.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
      if (!this.jdField_h_of_type_Boolean) {
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      }
      j();
    }
    label266:
    this.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(true);
    this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
    this.jdField_b_of_type_AndroidWidgetTextView.setEnabled(true);
    localObject1 = this.jdField_b_of_type_AndroidWidgetButton;
    if ((this.jdField_a_of_type_JavaUtilLinkedList.size() == 1) && (!e())) {}
    for (boolean bool = true;; bool = false)
    {
      ((Button)localObject1).setEnabled(bool);
      break;
    }
  }
  
  void j()
  {
    if (this.jdField_e_of_type_Boolean) {
      return;
    }
    switch (this.jdField_c_of_type_Int)
    {
    case 1: 
    default: 
      return;
    case 0: 
      this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      return;
    }
    bdfa.a(this.jdField_b_of_type_AndroidWidgetTextView, this.jdField_a_of_type_JavaUtilLinkedList, this.jdField_a_of_type_JavaUtilMap, true, this.jdField_a_of_type_AndroidAppActivity, null, null);
    this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
  }
  
  public void k()
  {
    if ((this.jdField_c_of_type_AndroidViewView != null) && (this.jdField_c_of_type_AndroidViewView.getVisibility() == 0))
    {
      alok.a(this.jdField_c_of_type_AndroidViewView);
      this.jdField_c_of_type_AndroidViewView = null;
      this.jdField_k_of_type_Boolean = false;
      this.jdField_a_of_type_Agli.notifyDataSetChanged();
      alok.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_AndroidViewView);
    }
  }
  
  public void l()
  {
    if (this.jdField_a_of_type_Agln != null) {
      this.jdField_a_of_type_Agln.b();
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    switch (paramCompoundButton.getId())
    {
    default: 
      return;
    case 2131373968: 
      if (paramBoolean)
      {
        if (this.jdField_a_of_type_Bdmu != null) {
          this.jdField_a_of_type_Bdmu.a(getContext(), this.jdField_a_of_type_JavaUtilLinkedList, paramBoolean, this.jdField_a_of_type_JavaUtilMap, null);
        }
        this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
        this.jdField_c_of_type_Int = 2;
        bdfa.a(this.jdField_b_of_type_AndroidWidgetTextView, this.jdField_a_of_type_JavaUtilLinkedList, this.jdField_a_of_type_JavaUtilMap, true, this.jdField_a_of_type_AndroidAppActivity, null, null);
        this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(alud.a(2131708510));
        azqs.b(null, "CliOper", "", "", "0X8005E07", "0X8005E07", 0, 0, "", "", "", "");
        return;
      }
      this.jdField_c_of_type_Int = 0;
      this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(alud.a(2131708464));
      return;
    }
    this.p = paramBoolean;
    i();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      alok.a(this.jdField_b_of_type_AndroidViewView);
      return;
      e();
      continue;
      d();
      continue;
      label556:
      if (!this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked())
      {
        this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
        continue;
        paramView = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (paramView.hasNext()) {
          azqs.b(null, "dc00898", "", "", "0X800A7B0", "0X800A7B0", ((Integer)paramView.next()).intValue() + 1, 0, "2", "", "", "");
        }
        int i1 = PhotoUtils.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        azqs.b(null, "dc00898", "", "", "0X800A912", "0X800A912", this.jdField_a_of_type_JavaUtilArrayList.size(), 0, "" + i1, "", "", "");
        f();
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {}
        boolean bool;
        for (i1 = 1;; i1 = 0)
        {
          bool = a();
          paramView = bjea.a();
          paramView.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
          paramView.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
          if (i1 == 0) {
            break label354;
          }
          bjdt.c(this.jdField_a_of_type_AndroidAppActivity, paramView, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString, 100008);
          break;
        }
        label354:
        if (bool)
        {
          Bundle localBundle = new Bundle();
          localBundle.putInt("key_personal_album_enter_model", 0);
          localBundle.putString("key_title", this.jdField_a_of_type_AndroidAppActivity.getString(2131718639));
          localBundle.putBoolean("key_personal_album_is_select_video", false);
          if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))
          {
            localBundle.putString("key_default_album_id", this.jdField_d_of_type_JavaLangString);
            localBundle.putBoolean("key_from_upload", true);
          }
          bjdt.a(this.jdField_a_of_type_AndroidAppActivity, paramView, localBundle, 100009);
          paramView = new LpReportInfo_pf00064(723, 1, 4);
          LpReportManager.getInstance().reportToPF00064(paramView, false, false);
          a("aio_sync_qzone", "operation_type", "panel_select_album");
          continue;
          m();
          bool = e();
          if (a())
          {
            if (bool)
            {
              i1 = 2;
              label507:
              paramView = new LpReportInfo_pf00064(723, 1, i1);
              LpReportManager.getInstance().reportToPF00064(paramView, false, false);
              if (!bool) {
                break label556;
              }
            }
            for (paramView = "panel_check";; paramView = "panel_cancel")
            {
              a("aio_sync_qzone", "operation_type", paramView);
              break;
              i1 = 3;
              break label507;
            }
          }
          if (bool)
          {
            paramView = new bjdn();
            paramView.jdField_a_of_type_Long = Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue();
            paramView.jdField_c_of_type_JavaLangString = "459";
            paramView.jdField_d_of_type_JavaLangString = "3";
            QZoneClickReport.report(this.jdField_a_of_type_JavaLangString, paramView, true);
          }
          else
          {
            paramView = new bjdn();
            paramView.jdField_a_of_type_Long = Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue();
            paramView.jdField_c_of_type_JavaLangString = "459";
            paramView.jdField_d_of_type_JavaLangString = "2";
            QZoneClickReport.report(this.jdField_a_of_type_JavaLangString, paramView, true);
          }
        }
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Agln != null)
    {
      if ((aglk)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.findViewHolderForAdapterPosition(this.jdField_a_of_type_Agln.jdField_c_of_type_Int) == null) {
        return false;
      }
      if ((jdField_m_of_type_Int == 1) && (SystemClock.elapsedRealtime() - this.jdField_a_of_type_Agln.jdField_a_of_type_Long > agln.a()) && (this.jdField_a_of_type_Agln.b.get())) {}
      for (int i1 = 1; i1 != 0; i1 = 0) {
        return true;
      }
      if ((jdField_m_of_type_Int == 0) && (paramMotionEvent.getAction() != 0) && (Math.abs(this.jdField_a_of_type_Agln.jdField_c_of_type_Float - paramMotionEvent.getX()) < Math.abs(this.jdField_a_of_type_Agln.d - paramMotionEvent.getY()))) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void setCustomOnClickListener(agle paramagle)
  {
    this.jdField_a_of_type_Agle = paramagle;
  }
  
  public void setImageCountChangedListener(aglg paramaglg)
  {
    this.jdField_a_of_type_Aglg = paramaglg;
  }
  
  public void setImageOnly(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_JavaLangBoolean == null) && (!paramBoolean))
    {
      this.jdField_a_of_type_AndroidContentIntent.removeExtra("showFlashPic");
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter != null) {
        break label67;
      }
    }
    label67:
    do
    {
      return;
      Intent localIntent = this.jdField_a_of_type_AndroidContentIntent;
      if ((!paramBoolean) && (this.jdField_a_of_type_JavaLangBoolean.booleanValue())) {}
      for (boolean bool = true;; bool = false)
      {
        localIntent.putExtra("showFlashPic", bool);
        break;
      }
      if (paramBoolean)
      {
        this.jdField_b_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter;
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter = MediaFileFilter.getFilter(1);
        return;
      }
    } while (this.jdField_b_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter == null);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter = this.jdField_b_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter;
    this.jdField_b_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter = null;
  }
  
  public void setImageSentListener(aglh paramaglh)
  {
    this.jdField_a_of_type_Aglh = paramaglh;
  }
  
  public void setLastRequestCode(int paramInt)
  {
    this.jdField_n_of_type_Int = paramInt;
  }
  
  public void setMixedMsgMode(boolean paramBoolean)
  {
    this.jdField_n_of_type_Boolean = paramBoolean;
  }
  
  public void setOnSwipeUpAndDragListener(agln paramagln)
  {
    this.jdField_a_of_type_Agln = paramagln;
  }
  
  public void setReceiptMode(boolean paramBoolean, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidContentIntent.putExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", paramBoolean);
    int i1;
    if (this.jdField_i_of_type_Boolean != paramBoolean)
    {
      i1 = 1;
      setImageOnly(paramBoolean);
      this.jdField_i_of_type_Boolean = paramBoolean;
      if (!paramBoolean) {
        break label73;
      }
      this.jdField_g_of_type_Int = Math.min(axln.b(paramQQAppInterface), this.jdField_g_of_type_Int);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setOnTouchListener(null);
    }
    for (;;)
    {
      if (i1 != 0) {
        g();
      }
      return;
      i1 = 0;
      break;
      label73:
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setOnTouchListener(this.jdField_a_of_type_Agln);
      this.jdField_g_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("PhotoConst.MAXUM_SELECTED_NUM", 20);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 9501) {
        this.jdField_g_of_type_Int = 5;
      }
    }
  }
  
  public void setSelectLimitListener(agll paramagll)
  {
    this.jdField_a_of_type_Agll = paramagll;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.PhotoListPanel
 * JD-Core Version:    0.7.0.1
 */