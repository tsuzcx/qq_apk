package com.tencent.mobileqq.activity.aio.photo;

import aael;
import aaes;
import aciy;
import acnc;
import adyu;
import adyv;
import adyw;
import adyx;
import adyy;
import adyz;
import adza;
import adzb;
import adzd;
import adze;
import adzf;
import adzh;
import adzi;
import adzk;
import aekk;
import afzs;
import afzz;
import agdo;
import ahji;
import ajei;
import ajhz;
import ajjy;
import ajtg;
import amym;
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
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import arno;
import atpc;
import atpg;
import atqj;
import aupw;
import aupz;
import aweg;
import awqm;
import awqx;
import axwv;
import azef;
import azks;
import azzz;
import baae;
import baaf;
import babh;
import babr;
import bace;
import badq;
import bbmy;
import bbrm;
import bfpl;
import bfpr;
import bfpy;
import bgbz;
import bgcb;
import bgcj;
import com.dataline.activities.LiteActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity.sendPhotoTask;
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
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;
import com.tencent.widget.XEditTextEx;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Properties;
import mqq.app.AccountNotMatchException;
import xgx;

public class PhotoListPanel
  extends RelativeLayout
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  public static int a;
  public static int b;
  public static int h;
  private static int m;
  private static int jdField_p_of_type_Int = -1;
  public long a;
  adzb jdField_a_of_type_Adzb;
  public adzd a;
  adze jdField_a_of_type_Adze;
  public adzf a;
  adzi jdField_a_of_type_Adzi;
  adzk jdField_a_of_type_Adzk;
  afzz jdField_a_of_type_Afzz;
  public amym a;
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
  public SessionInfo a;
  public QQAppInterface a;
  Boolean jdField_a_of_type_JavaLangBoolean;
  String jdField_a_of_type_JavaLangString;
  public ArrayList<Integer> a;
  HashMap<LocalMediaInfo, LocalMediaInfo> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public LinkedList<String> a;
  public Map<String, LocalMediaInfo> a;
  public volatile boolean a;
  public long b;
  afzz jdField_b_of_type_Afzz;
  public amym b;
  View jdField_b_of_type_AndroidViewView;
  Button jdField_b_of_type_AndroidWidgetButton;
  private CheckBox jdField_b_of_type_AndroidWidgetCheckBox;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  String jdField_b_of_type_JavaLangString;
  ArrayList<String> jdField_b_of_type_JavaUtilArrayList;
  boolean jdField_b_of_type_Boolean;
  int jdField_c_of_type_Int;
  public View c;
  Button jdField_c_of_type_AndroidWidgetButton;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  String jdField_c_of_type_JavaLangString;
  boolean jdField_c_of_type_Boolean;
  int jdField_d_of_type_Int;
  View jdField_d_of_type_AndroidViewView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private String jdField_d_of_type_JavaLangString;
  boolean jdField_d_of_type_Boolean;
  int jdField_e_of_type_Int;
  private View jdField_e_of_type_AndroidViewView;
  private String jdField_e_of_type_JavaLangString = ajjy.a(2131642298);
  boolean jdField_e_of_type_Boolean;
  int jdField_f_of_type_Int;
  private View jdField_f_of_type_AndroidViewView;
  boolean jdField_f_of_type_Boolean;
  public int g;
  boolean g;
  boolean h;
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
  private int jdField_o_of_type_Int = 2147483647;
  boolean jdField_o_of_type_Boolean;
  boolean jdField_p_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_Int = (int)axwv.a();
    jdField_b_of_type_Int = 20;
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
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    Properties localProperties = new Properties();
    localProperties.put(paramString2, paramString3);
    awqm.a(BaseApplicationImpl.getContext()).reportKVEvent(paramString1, localProperties);
  }
  
  private void a(ArrayList<String> paramArrayList)
  {
    try
    {
      new Intent().putExtra("open_chatfragment_fromphoto", true);
      Intent localIntent = new Intent();
      if (bgbz.a().a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_Int, paramArrayList, localIntent) > 0) {
        aael.a((QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localIntent);
      }
      return;
    }
    catch (AccountNotMatchException paramArrayList)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PhotoListPanel", 2, "AccountNotMatchException", paramArrayList);
      }
      return;
    }
    finally
    {
      a(1023);
    }
  }
  
  private boolean a()
  {
    if (QzoneConfig.getInstance().getConfig("PhotoUpload", "C2CAioEnableSyncImageToQzone", 1) == 0) {}
    while ((this.jdField_o_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1000) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1004))) {
      return false;
    }
    return true;
  }
  
  private boolean b()
  {
    return (this.jdField_b_of_type_AndroidWidgetCheckBox != null) && (this.jdField_b_of_type_AndroidWidgetCheckBox.getVisibility() == 0) && (this.jdField_b_of_type_AndroidWidgetCheckBox.isChecked()) && (this.jdField_e_of_type_AndroidViewView != null) && (this.jdField_e_of_type_AndroidViewView.getVisibility() == 0);
  }
  
  public static int d()
  {
    if (jdField_m_of_type_Int == -1) {
      jdField_m_of_type_Int = BaseApplicationImpl.sApplication.getSharedPreferences("SP_KEY_PHOTO_LIST_PANEL", 0).getInt("SP_KEY_SHOW_MODE", 0);
    }
    return jdField_m_of_type_Int;
  }
  
  @TargetApi(9)
  private void m()
  {
    boolean bool = b();
    if (a()) {}
    for (String str = "qzone_will_upload_to_personal_album"; Build.VERSION.SDK_INT >= 9; str = "qzone_will_upload_to_qun_album" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean(str, bool).apply();
      return;
    }
    ThreadManager.postImmediately(new PhotoListPanel.5(this, str, bool), null, false);
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
  
  public int a()
  {
    int i1 = 0;
    int i3;
    for (int i2 = 0; i1 < this.jdField_a_of_type_JavaUtilLinkedList.size(); i2 = i3)
    {
      i3 = i2;
      if (this.jdField_a_of_type_Adzf.a((String)this.jdField_a_of_type_JavaUtilLinkedList.get(i1)) == 0) {
        i3 = i2 + 1;
      }
      i1 += 1;
    }
    return i2;
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
        break label122;
      }
      i1 = 0;
      localObject = localStringBuilder.append(i1).append(",SELECTED_INDEXS size=");
      if (this.jdField_a_of_type_JavaUtilArrayList != null) {
        break label131;
      }
    }
    label131:
    for (int i1 = i2;; i1 = this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      QLog.d("PhotoListPanel", 2, i1);
      return localIntent;
      label122:
      i1 = ((ArrayList)localObject).size();
      break;
    }
  }
  
  public void a()
  {
    TextView localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131305304);
    int i1 = getResources().getDisplayMetrics().densityDpi;
    if (i1 < 320) {
      localTextView.setCompoundDrawables(null, null, null, null);
    }
    if (jdField_h_of_type_Int == 0)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(8);
    }
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanel", 2, "densityDpi = " + i1 + "qurey time=" + this.jdField_b_of_type_Long);
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
      agdo.a(getContext(), paramIntent, true, this.jdField_a_of_type_JavaUtilHashMap);
      Object localObject1 = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (String)((Iterator)localObject1).next();
        localObject2 = this.jdField_a_of_type_Adzf.a((String)localObject2);
        if (localObject2 != null) {
          ((LocalMediaInfo)localObject2).mChecked = false;
        }
      }
      this.jdField_g_of_type_Int = paramIntent.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
      paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.SELECTED_PATHS");
      this.jdField_a_of_type_JavaUtilLinkedList.clear();
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      paramIntent = paramIntent.iterator();
      while (paramIntent.hasNext())
      {
        localObject1 = (String)paramIntent.next();
        this.jdField_a_of_type_JavaUtilLinkedList.add(localObject1);
        localObject1 = this.jdField_a_of_type_Adzf.a((String)localObject1);
        if (localObject1 != null)
        {
          if (!((LocalMediaInfo)localObject1).mChecked) {
            ((LocalMediaInfo)localObject1).mChecked = true;
          }
          this.jdField_a_of_type_JavaUtilArrayList.add(((LocalMediaInfo)localObject1).position);
        }
      }
      if (this.jdField_a_of_type_Adzd != null) {
        this.jdField_a_of_type_Adzd.a(a());
      }
      this.jdField_a_of_type_Adzf.notifyDataSetChanged();
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
    int i2 = this.jdField_a_of_type_Adzf.getItemViewType(paramInt);
    Object localObject = this.jdField_a_of_type_Adzf.a(paramInt);
    this.jdField_a_of_type_JavaUtilArrayList.remove(((LocalMediaInfo)localObject).position);
    this.jdField_a_of_type_JavaUtilLinkedList.remove(((LocalMediaInfo)localObject).path);
    c();
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanel", 2, "sendMedias, type = " + i2 + ", paths.size() = " + paramArrayList.size() + " mediaInfo:" + localObject + ",allowPresend = " + paramBoolean1 + ",sendInBackground = " + paramBoolean2 + ",reportActionName = " + paramString1 + ",reverse2 = " + paramString2 + ",reverse3 = " + paramString3);
    }
    boolean bool = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", false);
    int i1 = this.jdField_g_of_type_Int;
    if (this.jdField_a_of_type_Adzd != null) {
      this.jdField_a_of_type_Adzd.a(a());
    }
    i();
    if (i2 == 0)
    {
      paramInt = 1;
      localObject = paramArrayList.iterator();
      if (((Iterator)localObject).hasNext())
      {
        if (bace.b((String)((Iterator)localObject).next())) {
          paramInt = 1;
        }
      }
      else
      {
        if (paramInt != 0) {
          break label324;
        }
        if (QLog.isColorLevel()) {
          QLog.e("PhotoListPanel", 2, "PhotoListPanel sendMedias,pics not exits, just return.");
        }
        bbmy.a(this.jdField_a_of_type_AndroidAppActivity, 2131629503, 0).a();
        a();
        this.jdField_a_of_type_JavaUtilLinkedList.clear();
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        if (this.jdField_a_of_type_Adzd != null) {
          this.jdField_a_of_type_Adzd.a(null);
        }
        i();
      }
    }
    label324:
    label764:
    while (i2 != 1)
    {
      for (;;)
      {
        return;
        paramInt = 0;
      }
      if (bool)
      {
        aupw.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramArrayList, i1);
        return;
      }
      if (paramBoolean2)
      {
        localObject = new Intent();
        ((Intent)localObject).putExtra("PhotoConst.SEND_BUSINESS_TYPE", this.jdField_k_of_type_Int);
        ((Intent)localObject).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", paramArrayList);
        ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        ((Intent)localObject).putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        ((Intent)localObject).putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString);
        ((Intent)localObject).putExtra("key_confess_topicid", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_e_of_type_Int);
        ((Intent)localObject).putExtra("PhotoConst.SEND_SIZE_SPEC", i1);
        ((Intent)localObject).putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
        ((Intent)localObject).putExtra("send_in_background", true);
        ((Intent)localObject).putExtra("entrance", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Int);
        if (paramArrayList.size() == 1) {
          ((Intent)localObject).putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramArrayList);
        }
        ThreadManager.post(new SendPhotoActivity.sendPhotoTask((BaseActivity)this.jdField_a_of_type_AndroidAppActivity, (Intent)localObject), 8, null, false);
      }
      for (;;)
      {
        awqx.b(null, "CliOper", "", "", paramString1, paramString1, 0, 0, paramString2, paramString3, "", "");
        return;
        localObject = new Intent(this.jdField_a_of_type_AndroidAppActivity, SendPhotoActivity.class);
        ((Intent)localObject).putExtra("PhotoConst.SEND_BUSINESS_TYPE", this.jdField_k_of_type_Int);
        ((Intent)localObject).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", paramArrayList);
        ((Intent)localObject).putExtra("PhotoConst.PHOTO_COUNT", paramArrayList.size());
        ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        ((Intent)localObject).putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        ((Intent)localObject).putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString);
        ((Intent)localObject).putExtra("key_confess_topicid", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_e_of_type_Int);
        ((Intent)localObject).putExtra("PhotoConst.SEND_SIZE_SPEC", i1);
        ((Intent)localObject).putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
        ((Intent)localObject).putExtra("entrance", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Int);
        if (paramArrayList.size() == 1) {
          ((Intent)localObject).putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramArrayList);
        }
        if (paramBoolean3)
        {
          ((Intent)localObject).putExtra("key_is_sync_qzone", 1);
          if (this.jdField_d_of_type_JavaLangString != null)
          {
            paramArrayList = this.jdField_d_of_type_JavaLangString;
            ((Intent)localObject).putExtra("key_qzone_album_id", paramArrayList);
            ((Intent)localObject).putExtra("key_qzone_batch_id", PhotoUtils.a());
          }
        }
        else
        {
          if (!paramBoolean1) {
            break label962;
          }
          if (i1 != 2) {
            break label897;
          }
          paramArrayList = BaseApplication.getContext();
          if (Build.VERSION.SDK_INT <= 10) {
            break label892;
          }
        }
        for (paramInt = 4;; paramInt = 0)
        {
          paramArrayList = paramArrayList.getSharedPreferences("presend_config_sp", paramInt);
          paramArrayList.edit().putBoolean("key_presend_off_flag", true).commit();
          paramArrayList.edit().putLong("key_presend_off_time", System.currentTimeMillis()).commit();
          a(1020);
          this.jdField_a_of_type_AndroidAppActivity.startActivityForResult((Intent)localObject, 100005);
          break;
          paramArrayList = "";
          break label764;
        }
        if (RichmediaService.a((Intent)localObject))
        {
          if (QLog.isColorLevel()) {
            QLog.d("PhotoListPanel", 2, "sendMedias,start sendPhotoAcitivy,  addPresendMgrHandlerToIntent OK");
          }
          this.jdField_a_of_type_AndroidAppActivity.startActivityForResult((Intent)localObject, 100005);
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("PhotoListPanel", 2, "sendMedias,start sendPhotoAcitivy,  addPresendMgrHandlerToIntent failed");
          }
          this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject);
          continue;
          if (QLog.isColorLevel()) {
            QLog.d("PhotoListPanel", 2, "sendMedias,start sendPhotoAcitivy, not presend");
          }
          this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject);
        }
      }
    }
    label892:
    localObject = (String)paramArrayList.get(0);
    label897:
    label962:
    paramArrayList = this.jdField_a_of_type_Adzf.a((String)localObject);
    File localFile = Environment.getExternalStorageDirectory();
    if ((localFile.exists()) && (localFile.canWrite()))
    {
      paramInt = 1;
      if ((!Environment.getExternalStorageState().equals("mounted")) || (paramInt == 0)) {
        break label1092;
      }
    }
    label1092:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt != 0) {
        break label1097;
      }
      bbmy.a(this.jdField_a_of_type_AndroidAppActivity, 1, 2131653216, 0).b(getResources().getDimensionPixelSize(2131167766));
      return;
      paramInt = 0;
      break;
    }
    label1097:
    if ((paramArrayList != null) && ((paramArrayList.mDuration > 1200000L) || (paramArrayList.fileSize > 1048576000L)))
    {
      bbmy.a(getContext(), getResources().getString(2131653672), 0).b(getResources().getDimensionPixelSize(2131167766));
      return;
    }
    long l1 = new File((String)localObject).length();
    if (azzz.b() > 512000L)
    {
      if ((aweg.jdField_b_of_type_Long != 0L) && (System.currentTimeMillis() - aweg.jdField_b_of_type_Long < 300000L)) {}
      for (paramBoolean1 = true;; paramBoolean1 = false)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoListPanel", 2, "upload video isConfirmed=" + paramBoolean1 + " allowUploadInXGTime=" + aweg.jdField_b_of_type_Long);
        }
        if ((this.jdField_g_of_type_Int == 2) && (l1 > 104345600L))
        {
          bbmy.a(this.jdField_a_of_type_AndroidAppActivity, getResources().getString(2131653694), 0).b(getResources().getDimensionPixelSize(2131167766));
          baaf.d();
        }
        if ((!badq.b(this.jdField_a_of_type_AndroidAppActivity)) || (paramBoolean1) || (l1 < 1048576L)) {
          break label1450;
        }
        localObject = ShortVideoUtils.a(this.jdField_a_of_type_AndroidAppActivity, l1);
        localObject = String.format(getResources().getString(2131653679), new Object[] { localObject });
        paramArrayList = new PhotoListPanel.6(this, paramArrayList, paramBoolean2, paramString1, paramString2, paramString3);
        if (bbrm.a(this.jdField_a_of_type_AndroidAppActivity, 4, new adyy(this, paramArrayList))) {
          babr.a(this.jdField_a_of_type_AndroidAppActivity, 232, null, (String)localObject, new adyz(this, paramArrayList), new adza(this)).show();
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("PhotoListPanel", 2, "show shortvideo_mobile_send_confirm dialog");
        return;
      }
      label1450:
      if (paramArrayList != null) {
        a(paramArrayList, paramBoolean2);
      }
      awqx.b(null, "CliOper", "", "", paramString1, paramString1, 0, 0, paramString2, paramString3, "", "");
      return;
    }
    ShortVideoPreviewActivity.a(this.jdField_a_of_type_AndroidAppActivity, 2131653704);
  }
  
  public void a(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_Adzf == null) {
      return;
    }
    awqx.b(null, "dc00898", "", "", "0X800A913", "0X800A913", PhotoUtils.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo), 0, "", "", "", "");
    int i1 = this.jdField_a_of_type_Adzf.getItemViewType(paramInt);
    if (this.jdField_m_of_type_Boolean)
    {
      b(this.jdField_a_of_type_Adzf.a(paramInt).path);
      return;
    }
    ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilLinkedList);
    Object localObject;
    if ((i1 == 0) || (i1 == 1))
    {
      localObject = this.jdField_a_of_type_Adzf.a(paramInt).path;
      if ((TextUtils.isEmpty((CharSequence)localObject)) || (!bace.b((String)localObject)))
      {
        if (QLog.isColorLevel()) {
          QLog.e("PhotoListPanel", 2, "PhotoListPanel onItemClick,clickPath not exits, just return.");
        }
        bbmy.a(this.jdField_a_of_type_AndroidAppActivity, 2131629503, 0).a();
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
      ((Intent)localObject).putExtra("PhotoConst.CURRENT_SELECTED_INDEX", this.jdField_a_of_type_Adzf.a(paramInt).position);
      ((Intent)localObject).putStringArrayListExtra("PhotoConst.SELECTED_PATHS", localArrayList);
      ((Intent)localObject).putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", this.jdField_a_of_type_JavaUtilArrayList);
      ((Intent)localObject).putExtra("PhotoConst.ALL_MEDIA_PATHS", (Serializable)this.jdField_a_of_type_JavaUtilMap);
      if (this.jdField_a_of_type_AndroidContentIntent != null)
      {
        ((Intent)localObject).putExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", false));
        ((Intent)localObject).putExtra("session_info", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      if (!(this.jdField_a_of_type_AndroidAppActivity instanceof SplashActivity)) {
        break label966;
      }
      ((Intent)localObject).putExtra("key_pic_to_edit_from", 1);
      ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
      localObject = aciy.a((Intent)localObject, null);
      ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      ((Intent)localObject).putExtra("key_activity_code", ChatActivityUtils.a(this.jdField_a_of_type_AndroidAppActivity));
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 9501) {
        break label1030;
      }
      if (!(this.jdField_a_of_type_AndroidAppActivity instanceof SplashActivity)) {
        break label1012;
      }
      ((Intent)localObject).putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
      localObject = aciy.a((Intent)localObject, null);
      label563:
      ((Intent)localObject).putExtra(baae.h, 80);
      ((Intent)localObject).putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      ((Intent)localObject).putExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", true);
      label596:
      ((Intent)localObject).putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.jdField_g_of_type_Int);
      ((Intent)localObject).putExtra("keep_selected_status_after_finish", true);
      ((Intent)localObject).putExtra("PhotoConst.IS_OVERLOAD", false);
      ((Intent)localObject).putExtra("PhotoConst.MAXUM_SELECTED_NUM", this.jdField_e_of_type_Int);
      ((Intent)localObject).putExtra("custom_photopreview_sendbtn_report", true);
      ((Intent)localObject).putExtra("custom_photopreview_sendbtn_reportActionName", "0X8005E0A");
      ((Intent)localObject).putExtra("custom_photopreview_sendbtn_reportReverse2", "0");
      ((Intent)localObject).putExtra("custom_photopreview_editbtn_reportActionName", "0X8005E0B");
      ((Intent)localObject).putExtra("custom_photopreview_rawcheckbox_reportActionName", "0X8005E0C");
      ((Intent)localObject).putExtra("KEY_THUMBNAL_BOUND", xgx.a(paramView.findViewById(2131302715)));
      ((Intent)localObject).putExtra("session_info", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      paramView = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60);
      if ((this.jdField_a_of_type_AndroidContentIntent == null) || (!this.jdField_a_of_type_AndroidContentIntent.hasExtra("showFlashPic"))) {
        ((Intent)localObject).putExtra("showFlashPic", ajhz.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramView, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString));
      }
      ((Intent)localObject).putExtra("PhotoConst.IS_JUMPTO_TROOP_ALBUM", b());
      ((Intent)localObject).setClass(this.jdField_a_of_type_AndroidAppActivity, NewPhotoPreviewActivity.class);
      ((Intent)localObject).putExtra("enter_from", 1);
      ((Intent)localObject).addFlags(603979776);
      this.jdField_a_of_type_AndroidAppActivity.startActivityForResult((Intent)localObject, 100004);
      ajei.a(this.jdField_b_of_type_AndroidViewView);
      if ((this.jdField_a_of_type_AndroidAppActivity instanceof SplashActivity)) {
        awqx.b(null, "dc00898", "", "", "0X800A06C", "0X800A06C", 1, 0, this.jdField_a_of_type_JavaUtilLinkedList.size() + "", "", "", "");
      }
    }
    paramView = "";
    if (i1 == 0) {
      paramView = "0";
    }
    for (;;)
    {
      awqx.b(null, "CliOper", "", "", "0X8005E09", "0X8005E09", 0, 0, paramView, "", "", "");
      return;
      label966:
      if ((this.jdField_a_of_type_AndroidAppActivity instanceof LiteActivity))
      {
        ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", LiteActivity.class.getName());
        break;
      }
      ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ChatActivity.class.getName());
      break;
      label1012:
      ((Intent)localObject).putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", ChatActivity.class.getName());
      break label563;
      label1030:
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 6000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 6003))
      {
        ((Intent)localObject).putExtra(baae.h, 55);
        ((Intent)localObject).putExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", false);
        ((Intent)localObject).putExtra("PhotoConst.IS_SEND_FILESIZE_LIMIT", true);
        break label596;
      }
      ((Intent)localObject).putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SendPhotoActivity.class.getName());
      ((Intent)localObject).putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      ((Intent)localObject).putExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", true);
      ((Intent)localObject).putExtra("key_confess_topicid", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_e_of_type_Int);
      break label596;
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
      paramBaseChatPie.ap();
      return;
      a(1019);
    }
  }
  
  void a(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    atpg.a("TAG", "sendVideo", "info = " + paramLocalMediaInfo + ",sendInBackground = " + paramBoolean);
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, SendVideoActivity.class);
    localIntent.putExtra("send_in_background", paramBoolean);
    localIntent.putExtra("file_send_path", paramLocalMediaInfo.path);
    localIntent.putExtra("file_send_size", paramLocalMediaInfo.fileSize);
    localIntent.putExtra("file_send_duration", paramLocalMediaInfo.mDuration);
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    localIntent.putExtra("PhotoConst.SEND_SIZE_SPEC", this.jdField_g_of_type_Int);
    localIntent.putExtra("file_source", "album_flow");
    String str1 = this.jdField_a_of_type_AndroidAppActivity.getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
    String str2 = this.jdField_a_of_type_AndroidAppActivity.getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", str1);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", str2);
    if (!paramLocalMediaInfo.isSystemMeidaStore) {
      awqx.b(null, "CliOper", "", "", "0X8006130", "0X8006130", 0, 0, "", "", "", "");
    }
    if (this.jdField_g_of_type_Int == 2) {
      baaf.a(0, 1);
    }
    localIntent.putExtra("start_init_activity_after_sended", false);
    if (paramBoolean)
    {
      ThreadManager.executeOnSubThread(new PhotoListPanel.4(this, localIntent));
      return;
    }
    this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo, Intent paramIntent)
  {
    jdField_m_of_type_Int = d();
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
    this.jdField_e_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("PhotoConst.MAXUM_SELECTED_NUM", 20);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 9501)
    {
      this.jdField_e_of_type_Int = 5;
      this.jdField_a_of_type_AndroidContentIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 5);
    }
    this.jdField_f_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("PhotoConst.MAXUM_SELECTED_NUM_VIDEO", 1);
    this.jdField_a_of_type_Long = this.jdField_a_of_type_AndroidContentIntent.getLongExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_SIZE", 1048576000L);
    this.jdField_a_of_type_Afzz = afzz.a(this.jdField_a_of_type_AndroidContentIntent.getIntExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 0));
    this.jdField_l_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", false);
    this.jdField_m_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("PhotoConst.IS_SINGLE_MODE", false);
    this.jdField_k_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("PhotoConst.SEND_BUSINESS_TYPE", 1052);
    if (this.jdField_l_of_type_Boolean) {
      this.jdField_a_of_type_Afzz = new afzs(afzz.d);
    }
    this.jdField_a_of_type_Afzz.a(true);
    this.jdField_c_of_type_Int = ((int)getResources().getDimension(2131165886));
    this.jdField_d_of_type_Int = ((int)getResources().getDimension(2131165887));
    this.jdField_a_of_type_Amym = new amym(this.jdField_i_of_type_Int, this.jdField_d_of_type_Int, this.jdField_d_of_type_Int);
    this.jdField_b_of_type_Amym = new amym(this.jdField_j_of_type_Int, this.jdField_d_of_type_Int, this.jdField_d_of_type_Int);
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
      if (this.jdField_a_of_type_Adzd != null) {
        this.jdField_a_of_type_Adzd.a(a());
      }
      this.jdField_d_of_type_AndroidViewView = findViewById(2131311730);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131296887));
      this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131304039));
      this.jdField_b_of_type_AndroidViewView = findViewById(2131305539);
      this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131307749));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131307755));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131307750));
      this.jdField_a_of_type_AndroidViewView = findViewById(2131305201);
      this.jdField_c_of_type_AndroidWidgetButton = ((Button)findViewById(2131310076));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      if (!this.jdField_e_of_type_Boolean) {
        break label977;
      }
      this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      label749:
      if (this.jdField_f_of_type_Boolean) {
        this.jdField_b_of_type_AndroidWidgetButton.setVisibility(4);
      }
      if (this.jdField_g_of_type_Boolean) {
        this.jdField_c_of_type_AndroidWidgetButton.setVisibility(4);
      }
      this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)findViewById(2131300877));
      switch (jdField_m_of_type_Int)
      {
      default: 
        this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager = new StaggeredGridLayoutManager(1, 0);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Adzf = new adzf(this);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Adzf);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addOnScrollListener(new adyu(this));
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
      label977:
      this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
      this.jdField_a_of_type_AndroidWidgetCheckBox.setContentDescription(ajjy.a(2131642332));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(ajjy.a(2131642307));
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
      break label749;
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager = new GridLayoutManager(getContext(), 2);
      ((GridLayoutManager)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager).setOrientation(0);
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
  
  public void a(ArrayList<String> paramArrayList, boolean paramBoolean)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanel", 2, "sendMedias, paths.size() = " + paramArrayList.size() + ",allowPresend = " + paramBoolean);
    }
    Object localObject = paramArrayList.iterator();
    for (int i1 = 1;; i1 = 0) {
      if (((Iterator)localObject).hasNext())
      {
        if (bace.b((String)((Iterator)localObject).next())) {
          i1 = 1;
        }
      }
      else
      {
        if (i1 != 0) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.e("PhotoListPanel", 2, "PhotoListPanel sendMedias,pics not exits, just return.");
        }
        bbmy.a(this.jdField_a_of_type_AndroidAppActivity, 2131629507, 0).a();
        a();
        this.jdField_a_of_type_JavaUtilLinkedList.clear();
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        i();
        return;
      }
    }
    localObject = Environment.getExternalStorageDirectory();
    if ((((File)localObject).exists()) && (((File)localObject).canWrite()))
    {
      i1 = 1;
      if ((!Environment.getExternalStorageState().equals("mounted")) || (i1 == 0)) {
        break label223;
      }
    }
    label223:
    for (i1 = 1;; i1 = 0)
    {
      if (i1 != 0) {
        break label228;
      }
      bbmy.a(this.jdField_a_of_type_AndroidAppActivity, 1, 2131653216, 0).b(getResources().getDimensionPixelSize(2131167766));
      return;
      i1 = 0;
      break;
    }
    label228:
    if (azzz.b() <= 512000L)
    {
      ShortVideoPreviewActivity.a(this.jdField_a_of_type_AndroidAppActivity, 2131653704);
      return;
    }
    i1 = 0;
    label251:
    if (i1 < paramArrayList.size())
    {
      localObject = (String)paramArrayList.get(i1);
      if (this.jdField_a_of_type_Adzf.a((String)localObject) != 1) {}
    }
    for (i1 = 1;; i1 = 0)
    {
      if ((aweg.jdField_b_of_type_Long != 0L) && (System.currentTimeMillis() - aweg.jdField_b_of_type_Long < 300000L)) {}
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoListPanel", 2, "upload video isConfirmed=" + bool + " allowUploadInXGTime=" + aweg.jdField_b_of_type_Long);
        }
        if ((!badq.b(this.jdField_a_of_type_AndroidAppActivity)) || (bool) || (i1 == 0)) {
          break label475;
        }
        localObject = getResources().getString(2131653417);
        paramArrayList = new PhotoListPanel.10(this, paramArrayList, paramBoolean);
        if (bbrm.a(this.jdField_a_of_type_AndroidAppActivity, 4, new adyv(this, paramArrayList))) {
          babr.a(this.jdField_a_of_type_AndroidAppActivity, 232, null, (String)localObject, new adyw(this, paramArrayList), new adyx(this)).show();
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("PhotoListPanel", 2, "show shortvideo_mobile_send_confirm dialog");
        return;
        i1 += 1;
        break label251;
        bool = false;
      }
      label475:
      b(paramArrayList, paramBoolean);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0) {
        this.jdField_a_of_type_Adzf.a();
      }
      this.jdField_a_of_type_JavaUtilLinkedList.clear();
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      if (this.jdField_a_of_type_Adzd != null) {
        this.jdField_a_of_type_Adzd.a(null);
      }
      this.jdField_a_of_type_Adzf.notifyDataSetChanged();
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
  
  public boolean a(String paramString)
  {
    int i1 = a();
    int i2 = b();
    return (!TextUtils.isEmpty(paramString)) && (i1 > 0) && (i2 == 0);
  }
  
  public boolean a(boolean paramBoolean, BaseChatPie paramBaseChatPie)
  {
    ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilLinkedList);
    int i1;
    if ((b()) && (!a()))
    {
      a(localArrayList);
      paramBoolean = false;
      g();
      if (paramBoolean)
      {
        i1 = 0;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 0) {
          break label607;
        }
        i1 = 1;
      }
    }
    for (;;)
    {
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8009BEB", "0X8009BEB", i1, 0, "", "", "", "");
      return paramBoolean;
      Object localObject1 = (azks)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
      if ((a() > 0) && (paramBoolean) && (paramBaseChatPie != null))
      {
        label183:
        boolean bool;
        if ((paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo != null) && (TextUtils.isEmpty(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mAnonymousNickName)))
        {
          paramBaseChatPie.a(new aaes());
          if (((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) == null) {
            break label501;
          }
          paramBoolean = true;
          localObject1 = babh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgSenderUin + "");
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          localObject3 = paramBaseChatPie.jdField_a_of_type_AndroidContentContext;
          localObject4 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
          str = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgSenderUin + "";
          XEditTextEx localXEditTextEx = paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {
            break label506;
          }
          bool = true;
          label301:
          localObject1 = azef.a((QQAppInterface)localObject2, (Context)localObject3, (String)localObject4, str, (String)localObject1, paramBoolean, localXEditTextEx, bool, true);
          if ((localObject1 != null) && (((SpannableString)localObject1).length() != 0)) {
            paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().insert(0, (CharSequence)localObject1);
          }
          localObject1 = aekk.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo);
          paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mType = 0;
          if (((localObject1 instanceof MessageForPic)) || ((localObject1 instanceof MessageForMixedMsg))) {
            paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.oriMsgType = 1;
          }
        }
        localObject1 = new ArrayList();
        Object localObject2 = azef.a(paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText(), (ArrayList)localObject1);
        Object localObject3 = (arno)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(174);
        Object localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
        i1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
        if (this.jdField_g_of_type_Int == 2) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          ((arno)localObject3).a((QQAppInterface)localObject4, str, i1, localArrayList, paramBoolean, (String)localObject2, (ArrayList)localObject1, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo);
          paramBaseChatPie.aW();
          paramBoolean = true;
          break;
          label501:
          paramBoolean = false;
          break label183;
          label506:
          bool = false;
          break label301;
        }
      }
      if (localArrayList != null) {
        ahji.a(localArrayList);
      }
      if ((b()) && (a())) {}
      for (i1 = 1;; i1 = 0)
      {
        a(localArrayList, this.jdField_c_of_type_Boolean);
        if (i1 != 0)
        {
          paramBaseChatPie = new LpReportInfo_pf00064(723, 1, 5);
          LpReportManager.getInstance().reportToPF00064(paramBaseChatPie, false, false);
          bgcj.a(8);
          a("aio_sync_qzone", "operation_type", "panel_upload");
        }
        paramBoolean = false;
        break;
      }
      label607:
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
        i1 = 2;
      } else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {
        i1 = 3;
      }
    }
  }
  
  public int b()
  {
    int i1 = 0;
    int i3;
    for (int i2 = 0; i1 < this.jdField_a_of_type_JavaUtilLinkedList.size(); i2 = i3)
    {
      i3 = i2;
      if (this.jdField_a_of_type_Adzf.a((String)this.jdField_a_of_type_JavaUtilLinkedList.get(i1)) == 1) {
        i3 = i2 + 1;
      }
      i1 += 1;
    }
    return i2;
  }
  
  public void b()
  {
    if (this.jdField_b_of_type_Boolean) {}
    do
    {
      return;
      this.jdField_c_of_type_Boolean = acnc.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_d_of_type_Boolean);
      if (QLog.isColorLevel()) {
        QLog.d("PhotoListPanel", 2, "initPresend! mAllowPresend = " + this.jdField_c_of_type_Boolean);
      }
    } while (!this.jdField_c_of_type_Boolean);
    BinderWarpper localBinderWarpper = new BinderWarpper(new atqj(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_e_of_type_Int).asBinder());
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("binder_presendService", localBinderWarpper);
    RichmediaService.a(localBundle);
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
      localIntent.putExtra("showFlashPic", ajhz.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localHotChatManager, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString));
    }
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof SplashActivity))
    {
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
      localIntent = aciy.a(localIntent, null);
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      localIntent.putExtra("key_activity_code", ChatActivityUtils.a(this.jdField_a_of_type_AndroidAppActivity));
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 9501) {
        break label461;
      }
      if (!(this.jdField_a_of_type_AndroidAppActivity instanceof SplashActivity)) {
        break label444;
      }
      localIntent.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
      localIntent = aciy.a(localIntent, null);
      label265:
      localIntent.putExtra(baae.h, 80);
      localIntent.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      localIntent.putExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", false);
    }
    for (;;)
    {
      localIntent.putExtra("PhotoConst.DEST_VIDEO_ACTIVITY_CLASS_NAME", SendVideoActivity.class.getName());
      localIntent.putExtra("PhotoConst.DEST_VIDEO_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      localIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.jdField_g_of_type_Int);
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
  
  void b(ArrayList<String> paramArrayList, boolean paramBoolean)
  {
    boolean bool = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", false);
    int i6 = this.jdField_g_of_type_Int;
    if (this.jdField_a_of_type_Adze != null) {
      this.jdField_a_of_type_Adze.a();
    }
    HashMap localHashMap = new HashMap();
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    if (i3 < paramArrayList.size())
    {
      localObject = (String)paramArrayList.get(i3);
      int i4;
      int i5;
      if (this.jdField_a_of_type_Adzf.a((String)localObject) == 1)
      {
        localObject = this.jdField_a_of_type_Adzf.a((String)localObject);
        i4 = i2;
        i5 = i1;
        if (localObject != null)
        {
          SendVideoActivity.SendVideoInfo localSendVideoInfo = new SendVideoActivity.SendVideoInfo();
          localSendVideoInfo.fileSize = ((LocalMediaInfo)localObject).fileSize;
          localSendVideoInfo.duration = ((LocalMediaInfo)localObject).mDuration;
          localHashMap.put(Integer.valueOf(i3), localSendVideoInfo);
          i5 = i1 + 1;
          i4 = i2;
        }
      }
      for (;;)
      {
        i3 += 1;
        i2 = i4;
        i1 = i5;
        break;
        i4 = i2 + 1;
        i5 = i1;
      }
    }
    if ((bool) && (i2 > 0) && (i1 == 0))
    {
      aupw.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramArrayList, i6);
      return;
    }
    Object localObject = new Intent(this.jdField_a_of_type_AndroidAppActivity, SendPhotoActivity.class);
    ((Intent)localObject).putExtra("PhotoConst.SEND_BUSINESS_TYPE", this.jdField_k_of_type_Int);
    ((Intent)localObject).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", paramArrayList);
    if (!localHashMap.isEmpty()) {
      ((Intent)localObject).putExtra("PhotoConst.VIDEO_INFOS", localHashMap);
    }
    ((Intent)localObject).putExtra("PhotoConst.PHOTO_COUNT", paramArrayList.size());
    ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    ((Intent)localObject).putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    ((Intent)localObject).putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString);
    ((Intent)localObject).putExtra("key_confess_topicid", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_e_of_type_Int);
    ((Intent)localObject).putExtra("PhotoConst.SEND_SIZE_SPEC", i6);
    ((Intent)localObject).putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
    ((Intent)localObject).putExtra("entrance", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Int);
    if (paramArrayList.size() == 1) {
      ((Intent)localObject).putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramArrayList);
    }
    if (paramBoolean) {
      if (i6 == 2)
      {
        paramArrayList = BaseApplication.getContext();
        if (Build.VERSION.SDK_INT > 10)
        {
          i3 = 4;
          paramArrayList = paramArrayList.getSharedPreferences("presend_config_sp", i3);
          paramArrayList.edit().putBoolean("key_presend_off_flag", true).commit();
          paramArrayList.edit().putLong("key_presend_off_time", System.currentTimeMillis()).commit();
          a(1020);
          this.jdField_a_of_type_AndroidAppActivity.startActivityForResult((Intent)localObject, 100005);
        }
      }
    }
    for (;;)
    {
      awqx.b(null, "CliOper", "", "", "0X8009AAF", "0X8009AAF", PhotoUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo), 0, String.valueOf(i2), String.valueOf(i1), "", "");
      return;
      i3 = 0;
      break;
      if (RichmediaService.a((Intent)localObject))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoListPanel", 2, "sendMedias,start sendPhotoAcitivy,  addPresendMgrHandlerToIntent OK");
        }
        this.jdField_a_of_type_AndroidAppActivity.startActivityForResult((Intent)localObject, 100005);
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoListPanel", 2, "sendMedias,start sendPhotoAcitivy,  addPresendMgrHandlerToIntent failed");
        }
        this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject);
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("PhotoListPanel", 2, "sendMedias,start sendPhotoAcitivy, not presend");
        }
        this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject);
      }
    }
  }
  
  public int c()
  {
    int i1 = 0;
    if (this.jdField_a_of_type_JavaUtilLinkedList != null) {
      i1 = this.jdField_a_of_type_JavaUtilLinkedList.size();
    }
    return i1;
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
          localObject1 = (adzh)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.findViewHolderForAdapterPosition(i2);
          localObject2 = this.jdField_a_of_type_Adzf.a(i2);
          if (localObject2 != null)
          {
            int i3 = this.jdField_a_of_type_JavaUtilLinkedList.indexOf(((LocalMediaInfo)localObject2).path);
            if (QLog.isColorLevel()) {
              QLog.d("check", 2, "updateCheckView mIndex=" + i3);
            }
            if ((i3 < 0) || (localObject1 == null)) {
              break label251;
            }
            ((adzh)localObject1).a.setCheckedNumber(i3 + 1);
            ((adzh)localObject1).b.setVisibility(0);
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
              ((adzh)localObject1).a.setChecked(false);
              ((adzh)localObject1).b.setVisibility(4);
            }
          }
        }
        return;
        i1 = 0;
      }
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanel", 2, "onEditBtnClicked");
    }
    if (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0)
    {
      Intent localIntent = EditPicActivity.a(this.jdField_a_of_type_AndroidAppActivity, (String)this.jdField_a_of_type_JavaUtilLinkedList.get(0), true, true, true, true, true, 2, 99, 5);
      localIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.jdField_g_of_type_Int);
      localIntent.putExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", false));
      localIntent.putExtra("key_enable_edit_title_bar", true);
      this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
      if ((this.jdField_a_of_type_AndroidAppActivity instanceof SplashActivity)) {
        awqx.b(null, "dc00898", "", "", "0X800A06B", "0X800A06B", 0, 0, "", "", "", "");
      }
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    getParent().requestDisallowInterceptTouchEvent(true);
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Adzk != null) && (paramMotionEvent.getAction() == 0))
    {
      atpg.a("PhotoListPanel", "onTouch", " ACTION_DOWN,x = " + paramMotionEvent.getX() + ",y = " + paramMotionEvent.getY());
      this.jdField_a_of_type_Adzk.a(paramMotionEvent);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanel", 2, "onAlbumBtnClicked");
    }
    if ((this.jdField_a_of_type_Adzb != null) && (this.jdField_a_of_type_Adzb.a(this))) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {}
    try
    {
      ((ajtg)((QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_a_of_type_JavaLangString)).a(20)).e(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true);
      if (!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty())
      {
        ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilLinkedList);
        if (this.jdField_m_of_type_Boolean) {
          this.jdField_a_of_type_AndroidContentIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
        }
        this.jdField_a_of_type_AndroidContentIntent.putExtra("fromPhotoListPanel", true);
        this.jdField_a_of_type_AndroidContentIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", this.jdField_k_of_type_Int);
        this.jdField_a_of_type_AndroidContentIntent.putExtra("peakconstant.request_code", 100006);
        this.jdField_a_of_type_AndroidContentIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.jdField_g_of_type_Int);
        this.jdField_a_of_type_AndroidContentIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 1);
        this.jdField_a_of_type_AndroidContentIntent.putExtra("PhotoConst.IS_SHOW_QZONE_ALBUM", true);
        this.jdField_a_of_type_AndroidContentIntent.putExtra("PhotoConst.is_troop_send_mixed_msg", this.jdField_n_of_type_Boolean);
        this.jdField_a_of_type_AndroidContentIntent.putExtra("PhotoConst.DISABLE_UPLOAD_TO_TROOP_ALBUM", this.jdField_i_of_type_Boolean);
        this.jdField_a_of_type_AndroidContentIntent.putExtra("PhotoConst.UPLOAD_CHECKBOX_IS_CHECKED", b());
        this.jdField_a_of_type_AndroidContentIntent.putExtra("PhotoConst.AIO_TO_PHOTO_LIST_NEED_SHOW_UPLOAD_BAR", a());
        this.jdField_a_of_type_AndroidContentIntent.putExtra("PhotoConst.MY_UIN", this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_AndroidContentIntent.putExtra("PhotoConst.QZONE_ALBUM_FROM_AIO", true);
        acnc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localArrayList, this.jdField_a_of_type_AndroidContentIntent, this.jdField_a_of_type_JavaUtilHashMap);
        g();
        awqx.b(null, "CliOper", "", "", "0X8005E05", "0X8005E05", 0, 0, "", "", "", "");
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
  
  protected void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanel", 2, "onSendBtnClicked");
    }
    if ((this.jdField_a_of_type_Adzb != null) && (this.jdField_a_of_type_Adzb.b(this))) {
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
    Object localObject1 = getResources().getString(2131629465);
    if (b()) {
      localObject1 = getResources().getString(2131629467);
    }
    if (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0)
    {
      bool = true;
      Object localObject2 = localObject1;
      if (bool)
      {
        this.jdField_c_of_type_AndroidWidgetButton.setContentDescription((String)localObject1 + this.jdField_a_of_type_JavaUtilLinkedList.size() + ajjy.a(2131642312));
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
      if (this.jdField_a_of_type_Adzd != null) {
        this.jdField_a_of_type_Adzd.a(c());
      }
      return;
      bool = false;
      break;
      label215:
      if (this.jdField_a_of_type_Adzf.a((String)this.jdField_a_of_type_JavaUtilLinkedList.peek()) != 1) {
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
    if ((this.jdField_a_of_type_JavaUtilLinkedList.size() == 1) && (!b())) {}
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
    switch (this.jdField_g_of_type_Int)
    {
    case 1: 
    default: 
      return;
    case 0: 
      this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      return;
    }
    baaf.a(this.jdField_b_of_type_AndroidWidgetTextView, this.jdField_a_of_type_JavaUtilLinkedList, this.jdField_a_of_type_JavaUtilMap, true, this.jdField_a_of_type_AndroidAppActivity, null, null);
    this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
  }
  
  public void k()
  {
    if ((this.jdField_c_of_type_AndroidViewView != null) && (this.jdField_c_of_type_AndroidViewView.getVisibility() == 0))
    {
      ajei.a(this.jdField_c_of_type_AndroidViewView);
      this.jdField_c_of_type_AndroidViewView = null;
      this.jdField_k_of_type_Boolean = false;
      this.jdField_a_of_type_Adzf.notifyDataSetChanged();
      ajei.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_AndroidViewView);
    }
  }
  
  public void l()
  {
    if (this.jdField_a_of_type_Adzk != null) {
      this.jdField_a_of_type_Adzk.b();
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    switch (paramCompoundButton.getId())
    {
    }
    do
    {
      return;
      if (paramBoolean)
      {
        if (baaf.a(this.jdField_a_of_type_JavaUtilLinkedList, jdField_a_of_type_Int, this.jdField_a_of_type_JavaUtilMap, true, null) > 0)
        {
          bbmy.a(this.jdField_a_of_type_AndroidAppActivity, getResources().getString(2131629431), 0).b(getResources().getDimensionPixelSize(2131167766));
          this.jdField_g_of_type_Int = 0;
          this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
          return;
        }
        if (baaf.a(this.jdField_a_of_type_JavaUtilLinkedList, 104345600L, this.jdField_a_of_type_JavaUtilMap, true, null) > 0)
        {
          bbmy.a(this.jdField_a_of_type_AndroidAppActivity, getResources().getString(2131653694), 0).b(getResources().getDimensionPixelSize(2131167766));
          baaf.d();
        }
        this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
        this.jdField_g_of_type_Int = 2;
        baaf.a(this.jdField_b_of_type_AndroidWidgetTextView, this.jdField_a_of_type_JavaUtilLinkedList, this.jdField_a_of_type_JavaUtilMap, true, this.jdField_a_of_type_AndroidAppActivity, null, null);
        this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(ajjy.a(2131642330));
        awqx.b(null, "CliOper", "", "", "0X8005E07", "0X8005E07", 0, 0, "", "", "", "");
        return;
      }
      this.jdField_g_of_type_Int = 0;
      this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(ajjy.a(2131642284));
      return;
      this.jdField_p_of_type_Boolean = paramBoolean;
      i();
    } while (!AppSetting.jdField_c_of_type_Boolean);
    CheckBox localCheckBox = this.jdField_b_of_type_AndroidWidgetCheckBox;
    StringBuilder localStringBuilder = new StringBuilder().append(ajjy.a(2131642313)).append(this.jdField_e_of_type_JavaLangString).append(",");
    if (this.jdField_b_of_type_AndroidWidgetCheckBox.isChecked()) {}
    for (paramCompoundButton = ajjy.a(2131642339);; paramCompoundButton = ajjy.a(2131642304))
    {
      localCheckBox.setContentDescription(paramCompoundButton);
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      ajei.a(this.jdField_b_of_type_AndroidViewView);
      return;
      e();
      continue;
      d();
      continue;
      if (!this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked())
      {
        if (baaf.a(this.jdField_a_of_type_JavaUtilLinkedList, jdField_a_of_type_Int, this.jdField_a_of_type_JavaUtilMap, true, null) > 0) {
          bbmy.a(this.jdField_a_of_type_AndroidAppActivity, getResources().getString(2131629431), 0).b(getResources().getDimensionPixelSize(2131167766));
        } else {
          this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
        }
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
        continue;
        paramView = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (paramView.hasNext()) {
          awqx.b(null, "dc00898", "", "", "0X800A7B0", "0X800A7B0", ((Integer)paramView.next()).intValue() + 1, 0, "2", "", "", "");
        }
        int i1 = PhotoUtils.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        awqx.b(null, "dc00898", "", "", "0X800A912", "0X800A912", this.jdField_a_of_type_JavaUtilArrayList.size(), 0, "" + i1, "", "", "");
        f();
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {}
        boolean bool;
        for (i1 = 1;; i1 = 0)
        {
          bool = a();
          paramView = bfpy.a();
          paramView.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
          paramView.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
          if (i1 == 0) {
            break label408;
          }
          bfpr.c(this.jdField_a_of_type_AndroidAppActivity, paramView, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString, 100008);
          break;
        }
        label408:
        if (bool)
        {
          Bundle localBundle = new Bundle();
          localBundle.putInt("key_personal_album_enter_model", 0);
          localBundle.putString("key_title", this.jdField_a_of_type_AndroidAppActivity.getString(2131652422));
          localBundle.putBoolean("key_personal_album_is_select_video", false);
          if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))
          {
            localBundle.putString("key_default_album_id", this.jdField_d_of_type_JavaLangString);
            localBundle.putBoolean("key_from_upload", true);
          }
          bfpr.a(this.jdField_a_of_type_AndroidAppActivity, paramView, localBundle, 100009);
          paramView = new LpReportInfo_pf00064(723, 1, 4);
          LpReportManager.getInstance().reportToPF00064(paramView, false, false);
          a("aio_sync_qzone", "operation_type", "panel_select_album");
          continue;
          if (this.jdField_b_of_type_AndroidWidgetCheckBox != null)
          {
            this.jdField_b_of_type_AndroidWidgetCheckBox.performClick();
            continue;
            m();
            bool = b();
            if (a())
            {
              if (bool)
              {
                i1 = 2;
                label579:
                paramView = new LpReportInfo_pf00064(723, 1, i1);
                LpReportManager.getInstance().reportToPF00064(paramView, false, false);
                if (!bool) {
                  break label628;
                }
              }
              label628:
              for (paramView = "panel_check";; paramView = "panel_cancel")
              {
                a("aio_sync_qzone", "operation_type", paramView);
                break;
                i1 = 3;
                break label579;
              }
            }
            if (bool)
            {
              paramView = new bfpl();
              paramView.jdField_a_of_type_Long = Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue();
              paramView.jdField_c_of_type_JavaLangString = "459";
              paramView.jdField_d_of_type_JavaLangString = "3";
              QZoneClickReport.report(this.jdField_a_of_type_JavaLangString, paramView, true);
            }
            else
            {
              paramView = new bfpl();
              paramView.jdField_a_of_type_Long = Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue();
              paramView.jdField_c_of_type_JavaLangString = "459";
              paramView.jdField_d_of_type_JavaLangString = "2";
              QZoneClickReport.report(this.jdField_a_of_type_JavaLangString, paramView, true);
            }
          }
        }
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void setCustomOnClickListener(adzb paramadzb)
  {
    this.jdField_a_of_type_Adzb = paramadzb;
  }
  
  public void setImageCountChangedListener(adzd paramadzd)
  {
    this.jdField_a_of_type_Adzd = paramadzd;
  }
  
  public void setImageOnly(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_JavaLangBoolean == null) && (!paramBoolean))
    {
      this.jdField_a_of_type_AndroidContentIntent.removeExtra("showFlashPic");
      if (this.jdField_a_of_type_Afzz != null) {
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
        this.jdField_b_of_type_Afzz = this.jdField_a_of_type_Afzz;
        this.jdField_a_of_type_Afzz = afzz.a(1);
        return;
      }
    } while (this.jdField_b_of_type_Afzz == null);
    this.jdField_a_of_type_Afzz = this.jdField_b_of_type_Afzz;
    this.jdField_b_of_type_Afzz = null;
  }
  
  public void setImageSentListener(adze paramadze)
  {
    this.jdField_a_of_type_Adze = paramadze;
  }
  
  public void setLastRequestCode(int paramInt)
  {
    this.jdField_n_of_type_Int = paramInt;
  }
  
  public void setMixedMsgMode(boolean paramBoolean)
  {
    this.jdField_n_of_type_Boolean = paramBoolean;
  }
  
  public void setOnSwipeUpAndDragListener(adzk paramadzk)
  {
    this.jdField_a_of_type_Adzk = paramadzk;
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setOnTouchListener(paramadzk);
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
      this.jdField_e_of_type_Int = Math.min(aupz.b(paramQQAppInterface), this.jdField_e_of_type_Int);
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
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setOnTouchListener(this.jdField_a_of_type_Adzk);
      this.jdField_e_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("PhotoConst.MAXUM_SELECTED_NUM", 20);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 9501) {
        this.jdField_e_of_type_Int = 5;
      }
    }
  }
  
  public void setSelectLimitListener(adzi paramadzi)
  {
    this.jdField_a_of_type_Adzi = paramadzi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.PhotoListPanel
 * JD-Core Version:    0.7.0.1
 */