package com.tencent.mobileqq.activity.aio.photo;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.dataline.activities.LiteActivity;
import com.tencent.biz.qqstory.takevideo.EditPicActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.PlusPanelUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.DynamicImageMediaFileFilter;
import com.tencent.mobileqq.activity.photo.FlowThumbDecoder;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.PhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity.sendPhotoTask;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraReporter;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity.SendVideoTask;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.mobileqq.app.BabyQHandler;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FlashPicHelper;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.drawable.EmptyDrawable;
import com.tencent.mobileqq.mixedmsg.MixedMsgManager;
import com.tencent.mobileqq.pic.IPresendPicMgr;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PresendPicMgrService;
import com.tencent.mobileqq.receipt.ReceiptMsgManager;
import com.tencent.mobileqq.receipt.ReceiptUtil;
import com.tencent.mobileqq.richmedia.RichmediaService;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mobileqq.troop.utils.TroopRobotManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AlbumConstants;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DialogUtil.DialogOnClickAdapter;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.HorizontalListView.RecycleListener;
import com.tencent.widget.XEditTextEx;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneClickReport.ReportInfo;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.RemoteRequestSender;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import mqq.app.AccountNotMatchException;
import mqq.os.MqqHandler;
import vox;
import voy;
import voz;
import vpa;
import vpb;
import vpe;
import vpf;
import vpg;
import vph;
import vpi;
import vpo;

public class PhotoListPanel
  extends RelativeLayout
  implements View.OnClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, CompoundButton.OnCheckedChangeListener, HorizontalListView.RecycleListener
{
  public static int a;
  public static int g;
  public long a;
  public Activity a;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new vox(this);
  Intent jdField_a_of_type_AndroidContentIntent;
  public SharedPreferences a;
  public Handler a;
  public View a;
  Button jdField_a_of_type_AndroidWidgetButton;
  public CheckBox a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public SessionInfo a;
  PhotoListPanel.BottomBtnClickListener jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$BottomBtnClickListener;
  PhotoListPanel.ImageCountChangedListener jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$ImageCountChangedListener;
  PhotoListPanel.ImageSentListener jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$ImageSentListener;
  public PhotoListPanel.MyAdapter a;
  public PhotoListPanel.SelectLimitListener a;
  public PhotoListPanel.SwipeUpAndDragListener a;
  public MediaFileFilter a;
  public QQAppInterface a;
  EmptyDrawable jdField_a_of_type_ComTencentMobileqqDrawableEmptyDrawable;
  public HorizontalListView a;
  Boolean jdField_a_of_type_JavaLangBoolean;
  public String a;
  public ArrayList a;
  public LinkedList a;
  public volatile boolean a;
  int jdField_b_of_type_Int;
  public long b;
  View jdField_b_of_type_AndroidViewView;
  Button jdField_b_of_type_AndroidWidgetButton;
  private CheckBox jdField_b_of_type_AndroidWidgetCheckBox;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  MediaFileFilter jdField_b_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter;
  EmptyDrawable jdField_b_of_type_ComTencentMobileqqDrawableEmptyDrawable;
  String jdField_b_of_type_JavaLangString;
  public ArrayList b;
  boolean jdField_b_of_type_Boolean;
  public int c;
  View jdField_c_of_type_AndroidViewView;
  Button jdField_c_of_type_AndroidWidgetButton;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  String jdField_c_of_type_JavaLangString;
  boolean jdField_c_of_type_Boolean;
  public int d;
  View jdField_d_of_type_AndroidViewView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private String jdField_d_of_type_JavaLangString;
  boolean jdField_d_of_type_Boolean;
  public int e;
  private View jdField_e_of_type_AndroidViewView;
  private String jdField_e_of_type_JavaLangString = "群相册";
  boolean jdField_e_of_type_Boolean;
  public int f;
  private View jdField_f_of_type_AndroidViewView;
  boolean jdField_f_of_type_Boolean;
  private View jdField_g_of_type_AndroidViewView;
  boolean jdField_g_of_type_Boolean;
  int h;
  public boolean h;
  int jdField_i_of_type_Int = -16777216;
  boolean jdField_i_of_type_Boolean = false;
  int jdField_j_of_type_Int;
  boolean jdField_j_of_type_Boolean = false;
  public int k;
  boolean k;
  private int jdField_l_of_type_Int = 2147483647;
  boolean jdField_l_of_type_Boolean = false;
  boolean m = false;
  boolean n = false;
  private boolean o = true;
  
  static
  {
    jdField_a_of_type_Int = 19922944;
  }
  
  public PhotoListPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_k_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_h_of_type_Int = 278921216;
    this.jdField_k_of_type_Int = 4097;
  }
  
  private void a(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("UploadPhoto.key_album_id");
    paramIntent = paramIntent.getStringExtra("UploadPhoto.key_album_name");
    a(str, paramIntent);
    QZoneHelper.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, str, paramIntent);
  }
  
  private void a(String paramString1, String paramString2)
  {
    this.jdField_e_of_type_JavaLangString = paramString2;
    this.jdField_d_of_type_JavaLangString = paramString1;
    if (this.jdField_c_of_type_AndroidWidgetTextView != null)
    {
      if (!"群相册".equals(paramString2)) {
        break label52;
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setText(2131435914);
    }
    for (;;)
    {
      ThreadManager.getUIHandler().post(new vpe(this, paramString2));
      return;
      label52:
      this.jdField_d_of_type_AndroidWidgetTextView.setText(2131435913);
    }
  }
  
  private void a(ArrayList paramArrayList)
  {
    try
    {
      new Intent().putExtra("open_chatfragment_fromphoto", true);
      Intent localIntent = new Intent();
      if (RemoteHandleManager.a().a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_f_of_type_Int, paramArrayList, localIntent) > 0) {
        ChatActivityFacade.a((QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localIntent);
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
    return (this.jdField_e_of_type_AndroidViewView != null) && (this.jdField_e_of_type_AndroidViewView.getVisibility() == 0);
  }
  
  private boolean b()
  {
    return (this.jdField_b_of_type_AndroidWidgetCheckBox != null) && (this.jdField_b_of_type_AndroidWidgetCheckBox.getVisibility() == 0) && (this.jdField_b_of_type_AndroidWidgetCheckBox.isChecked());
  }
  
  private int c()
  {
    return QzoneConfig.getInstance().getConfig("PhotoUpload", "QunAiOthresholdNum", 3);
  }
  
  private boolean c()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_AndroidContentSharedPreferences.contains("qzone_will_upload_to_qun_album" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      bool = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("qzone_will_upload_to_qun_album" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false);
    }
    return bool;
  }
  
  private boolean d()
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.contains("qzone_will_upload_to_qun_album" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
  }
  
  private boolean e()
  {
    boolean bool = true;
    if (d()) {
      bool = c();
    }
    while (QzoneConfig.getInstance().getConfig("PhotoUpload", "QunAioCheckBoxState", 0) == 1) {
      return bool;
    }
    return false;
  }
  
  private void k()
  {
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_a_of_type_JavaLangString);
      if (((HotChatManager)localQQAppInterface.getManager(59)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
        return;
      }
      if ((!this.jdField_i_of_type_Boolean) && (!TroopInfo.isQidianPrivateTroop(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
      {
        if (this.o)
        {
          ((TroopHandler)localQQAppInterface.a(20)).e(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true);
          this.o = false;
        }
        ThreadManager.postImmediately(new vpb(this, localQQAppInterface), null, true);
        return;
      }
    }
    catch (AccountNotMatchException localAccountNotMatchException)
    {
      if (QLog.isColorLevel())
      {
        QLog.e("PhotoListPanel", 2, localAccountNotMatchException, new Object[0]);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PhotoListPanel", 2, localThrowable, new Object[0]);
      }
    }
  }
  
  private void l()
  {
    if ((this.jdField_e_of_type_AndroidViewView != null) && (this.jdField_e_of_type_AndroidViewView.getVisibility() != 8))
    {
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
      this.o = true;
    }
    h();
  }
  
  @TargetApi(9)
  private void m()
  {
    boolean bool = b();
    if (Build.VERSION.SDK_INT >= 9)
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("qzone_will_upload_to_qun_album" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, bool).apply();
      return;
    }
    ThreadManager.postImmediately(new vph(this, bool), null, false);
  }
  
  int a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
    int i1 = 0;
    if (localIterator.hasNext())
    {
      if (new File((String)localIterator.next()).length() <= jdField_a_of_type_Int) {
        break label55;
      }
      i1 += 1;
    }
    label55:
    for (;;)
    {
      break;
      return i1;
    }
  }
  
  public ArrayList a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$MyAdapter.a((String)this.jdField_a_of_type_JavaUtilLinkedList.peek()) != 0) {
      return null;
    }
    return new ArrayList(this.jdField_a_of_type_JavaUtilLinkedList);
  }
  
  public void a()
  {
    TextView localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369480);
    int i1 = getResources().getDisplayMetrics().densityDpi;
    if (i1 < 320) {
      localTextView.setCompoundDrawables(null, null, null, null);
    }
    if (jdField_g_of_type_Int == 0)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(8);
    }
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanel", 2, "densityDpi = " + i1 + "qurey time=" + this.jdField_b_of_type_Long);
    }
    ThreadManager.post(new vpo(this), 8, null, true);
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
    case 100007: 
    default: 
      return;
    case 100004: 
    case 100006: 
      if (QLog.isColorLevel()) {
        QLog.d("PhotoListPanel", 2, "onActivityResult, PeakConstants.REQUEST_PHOTOPREVIEW_RETURE");
      }
      Object localObject1 = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (String)((Iterator)localObject1).next();
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$MyAdapter.a((String)localObject2);
        if (localObject2 != null) {
          ((LocalMediaInfo)localObject2).mChecked = false;
        }
      }
      this.jdField_f_of_type_Int = paramIntent.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
      paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.SELECTED_PATHS");
      this.jdField_a_of_type_JavaUtilLinkedList.clear();
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      paramIntent = paramIntent.iterator();
      while (paramIntent.hasNext())
      {
        localObject1 = (String)paramIntent.next();
        this.jdField_a_of_type_JavaUtilLinkedList.add(localObject1);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$MyAdapter.a((String)localObject1);
        if (localObject1 != null)
        {
          if (!((LocalMediaInfo)localObject1).mChecked) {
            ((LocalMediaInfo)localObject1).mChecked = true;
          }
          this.jdField_a_of_type_JavaUtilArrayList.add(((LocalMediaInfo)localObject1).position);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$MyAdapter.notifyDataSetChanged();
      k();
      h();
      return;
    case 100005: 
      if (QLog.isColorLevel()) {
        QLog.d("PhotoListPanel", 2, "onActivityResult, PeakConstants.REQUEST_PHOTOLIST_PANEL_SEND_RETURN");
      }
      b();
      return;
    }
    a(paramIntent);
  }
  
  public void a(int paramInt, ArrayList paramArrayList, boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanel", 2, "sendMedias, type = " + paramInt + ", paths.size() = " + paramArrayList.size() + ",allowPresend = " + paramBoolean1 + ",sendInBackground = " + paramBoolean2 + ",reportActionName = " + paramString1 + ",reverse2 = " + paramString2 + ",reverse3 = " + paramString3);
    }
    boolean bool = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", false);
    int i1 = this.jdField_f_of_type_Int;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$ImageSentListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$ImageSentListener.a();
    }
    if (paramInt == 0)
    {
      paramInt = 1;
      localObject = paramArrayList.iterator();
      if (((Iterator)localObject).hasNext())
      {
        if (FileUtils.b((String)((Iterator)localObject).next())) {
          paramInt = 1;
        }
      }
      else
      {
        if (paramInt != 0) {
          break label238;
        }
        if (QLog.isColorLevel()) {
          QLog.e("PhotoListPanel", 2, "PhotoListPanel sendMedias,pics not exits, just return.");
        }
        QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2131434505, 0).a();
        a();
        this.jdField_a_of_type_JavaUtilLinkedList.clear();
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        h();
      }
    }
    label238:
    while (paramInt != 1)
    {
      for (;;)
      {
        return;
        paramInt = 0;
      }
      if (bool)
      {
        ReceiptMsgManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramArrayList, i1);
        return;
      }
      if (paramBoolean2)
      {
        localObject = new Intent();
        ((Intent)localObject).putExtra("PhotoConst.SEND_BUSINESS_TYPE", this.jdField_j_of_type_Int);
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
        ReportController.b(null, "CliOper", "", "", paramString1, paramString1, 0, 0, paramString2, paramString3, "", "");
        return;
        localObject = new Intent(this.jdField_a_of_type_AndroidAppActivity, SendPhotoActivity.class);
        ((Intent)localObject).putExtra("PhotoConst.SEND_BUSINESS_TYPE", this.jdField_j_of_type_Int);
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
        ((Intent)localObject).addFlags(603979776);
        if (paramBoolean1)
        {
          if (i1 == 2)
          {
            paramArrayList = BaseApplication.getContext();
            if (Build.VERSION.SDK_INT > 10) {}
            for (paramInt = 4;; paramInt = 0)
            {
              paramArrayList = paramArrayList.getSharedPreferences("presend_config_sp", paramInt);
              paramArrayList.edit().putBoolean("key_presend_off_flag", true).commit();
              paramArrayList.edit().putLong("key_presend_off_time", System.currentTimeMillis()).commit();
              a(1020);
              this.jdField_a_of_type_AndroidAppActivity.startActivityForResult((Intent)localObject, 100005);
              break;
            }
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
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("PhotoListPanel", 2, "sendMedias,start sendPhotoAcitivy, not presend");
          }
          this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject);
        }
      }
    }
    Object localObject = (String)paramArrayList.get(0);
    paramArrayList = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$MyAdapter.a((String)localObject);
    File localFile = Environment.getExternalStorageDirectory();
    if ((localFile.exists()) && (localFile.canWrite()))
    {
      paramInt = 1;
      if ((!Environment.getExternalStorageState().equals("mounted")) || (paramInt == 0)) {
        break label961;
      }
    }
    label961:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt != 0) {
        break label966;
      }
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 1, 2131434770, 0).b(getResources().getDimensionPixelSize(2131558448));
      return;
      paramInt = 0;
      break;
    }
    label966:
    if (Utils.b() > 512000L)
    {
      if ((ShortVideoBusiManager.jdField_b_of_type_Long != 0L) && (System.currentTimeMillis() - ShortVideoBusiManager.jdField_b_of_type_Long < 300000L)) {}
      for (paramBoolean1 = true;; paramBoolean1 = false)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoListPanel", 2, "upload video isConfirmed=" + paramBoolean1 + " allowUploadInXGTime=" + ShortVideoBusiManager.jdField_b_of_type_Long);
        }
        if ((!NetworkUtil.b(this.jdField_a_of_type_AndroidAppActivity)) || (paramBoolean1)) {
          break label1171;
        }
        long l1 = new File((String)localObject).length();
        localObject = ShortVideoUtils.a(this.jdField_a_of_type_AndroidAppActivity, l1);
        localObject = String.format(getResources().getString(2131437376), new Object[] { localObject });
        DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 232, null, (String)localObject, new vpi(this, paramArrayList, paramBoolean2, paramString1, paramString2, paramString3), new voy(this)).show();
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("PhotoListPanel", 2, "show shortvideo_mobile_send_confirm dialog");
        return;
      }
      if (paramArrayList != null) {
        a(paramArrayList, paramBoolean2);
      }
      ReportController.b(null, "CliOper", "", "", paramString1, paramString1, 0, 0, paramString2, paramString3, "", "");
      return;
    }
    label1171:
    ShortVideoPreviewActivity.a(this.jdField_a_of_type_AndroidAppActivity, 2131437372);
  }
  
  public void a(View paramView)
  {
    if ((paramView != null) && (paramView.getTag() != null) && ((paramView.getTag() instanceof PhotoListPanel.MyAdapter.Holder))) {
      ((PhotoListPanel.MyAdapter.Holder)paramView.getTag()).jdField_a_of_type_ComTencentImageURLDrawable = null;
    }
  }
  
  public void a(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    Logger.a("TAG", "sendVideo", "info = " + paramLocalMediaInfo + ",sendInBackground = " + paramBoolean);
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, SendVideoActivity.class);
    localIntent.putExtra("send_in_background", paramBoolean);
    localIntent.putExtra("file_send_path", paramLocalMediaInfo.path);
    localIntent.putExtra("file_send_size", paramLocalMediaInfo.fileSize);
    localIntent.putExtra("file_send_duration", paramLocalMediaInfo.mDuration);
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    localIntent.putExtra("file_source", "album_flow");
    String str1 = this.jdField_a_of_type_AndroidAppActivity.getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
    String str2 = this.jdField_a_of_type_AndroidAppActivity.getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", str1);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", str2);
    if (!paramLocalMediaInfo.isSystemMeidaStore) {
      ReportController.b(null, "CliOper", "", "", "0X8006130", "0X8006130", 0, 0, "", "", "", "");
    }
    localIntent.putExtra("start_init_activity_after_sended", false);
    if (paramBoolean)
    {
      new SendVideoActivity.SendVideoTask((BaseActivity)this.jdField_a_of_type_AndroidAppActivity, localIntent).execute(new Void[0]);
      return;
    }
    this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo, Intent paramIntent)
  {
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
    this.jdField_h_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("key_allow_mix_select", false);
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("key_my_uin");
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("key_my_nick");
    this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("key_my_head_dir");
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanel", 2, "init, mDisablePresend = " + this.jdField_b_of_type_Boolean);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    paramQQAppInterface = this.jdField_a_of_type_AndroidAppActivity.getIntent();
    this.jdField_d_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("PhotoConst.MAXUM_SELECTED_NUM", 20);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 9501)
    {
      this.jdField_d_of_type_Int = 5;
      this.jdField_a_of_type_AndroidContentIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 5);
    }
    this.jdField_e_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("PhotoConst.MAXUM_SELECTED_NUM_VIDEO", 1);
    this.jdField_a_of_type_Long = this.jdField_a_of_type_AndroidContentIntent.getLongExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_SIZE", 293601280L);
    int i1 = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 0);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter = ((MediaFileFilter)MediaFileFilter.a.get(i1));
    this.jdField_l_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", false);
    this.m = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("PhotoConst.IS_SINGLE_MODE", false);
    this.jdField_j_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("PhotoConst.SEND_BUSINESS_TYPE", 1007);
    if (this.jdField_l_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter = new DynamicImageMediaFileFilter(MediaFileFilter.jdField_b_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter);
    }
    this.jdField_b_of_type_Int = ((int)getResources().getDimension(2131560789));
    this.jdField_c_of_type_Int = ((int)getResources().getDimension(2131560788));
    this.jdField_a_of_type_ComTencentMobileqqDrawableEmptyDrawable = new EmptyDrawable(this.jdField_h_of_type_Int, this.jdField_c_of_type_Int, this.jdField_c_of_type_Int);
    this.jdField_b_of_type_ComTencentMobileqqDrawableEmptyDrawable = new EmptyDrawable(this.jdField_i_of_type_Int, this.jdField_c_of_type_Int, this.jdField_c_of_type_Int);
    if (paramQQAppInterface.hasExtra("PhotoConst.SELECTED_PATHS"))
    {
      paramActivity = paramQQAppInterface.getStringArrayListExtra("PhotoConst.SELECTED_PATHS");
      if (paramActivity != null) {
        this.jdField_a_of_type_JavaUtilLinkedList.addAll(paramActivity);
      }
      paramQQAppInterface = paramQQAppInterface.getIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS");
      if (paramQQAppInterface != null) {
        this.jdField_a_of_type_JavaUtilArrayList.addAll(paramQQAppInterface);
      }
    }
    this.jdField_d_of_type_AndroidViewView = findViewById(2131366450);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131369474));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131365524));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131369475);
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131365525));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365526));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369476));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131369479);
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)findViewById(2131365527));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    if (this.jdField_e_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
    }
    for (;;)
    {
      if (this.jdField_f_of_type_Boolean) {
        this.jdField_b_of_type_AndroidWidgetButton.setVisibility(4);
      }
      if (this.jdField_g_of_type_Boolean) {
        this.jdField_c_of_type_AndroidWidgetButton.setVisibility(4);
      }
      this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)findViewById(2131369477));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$MyAdapter = new PhotoListPanel.MyAdapter(this);
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$MyAdapter);
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemClickListener(this);
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setRecycleListener(this);
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnScrollStateChangedListener(new voz(this));
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnTouchListener(new vpa(this));
      paramQQAppInterface = getResources();
      FlowThumbDecoder.a = paramQQAppInterface.getDimension(2131560788);
      FlowThumbDecoder.b = paramQQAppInterface.getDimension(2131560790);
      FlowThumbDecoder.c = paramQQAppInterface.getDimension(2131560789);
      FlowThumbDecoder.d = FlowThumbDecoder.b / FlowThumbDecoder.a;
      FlowThumbDecoder.e = FlowThumbDecoder.c / FlowThumbDecoder.a;
      this.jdField_a_of_type_AndroidContentSharedPreferences = BaseApplication.getContext().getSharedPreferences("share", 4);
      h();
      b();
      paramQQAppInterface = new IntentFilter();
      paramQQAppInterface.addAction("android.intent.action.SCREEN_OFF");
      this.jdField_a_of_type_AndroidAppActivity.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramQQAppInterface);
      return;
      this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
      this.jdField_a_of_type_AndroidWidgetCheckBox.setContentDescription("原图");
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription("原图");
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
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
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$MyAdapter.a();
      }
      this.jdField_a_of_type_JavaUtilLinkedList.clear();
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$MyAdapter.notifyDataSetChanged();
    }
    this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
    l();
    h();
    setMixedMsgMode(false);
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$MyAdapter.a((String)this.jdField_a_of_type_JavaUtilLinkedList.peek()) != 0) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilLinkedList.size();
  }
  
  public void b()
  {
    if (this.jdField_b_of_type_Boolean) {}
    do
    {
      return;
      this.jdField_c_of_type_Boolean = PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_d_of_type_Boolean);
      if (QLog.isColorLevel()) {
        QLog.d("PhotoListPanel", 2, "initPresend! mAllowPresend = " + this.jdField_c_of_type_Boolean);
      }
    } while (!this.jdField_c_of_type_Boolean);
    BinderWarpper localBinderWarpper = new BinderWarpper(new PresendPicMgrService(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_e_of_type_Int).asBinder());
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("binder_presendService", localBinderWarpper);
    RichmediaService.a(localBundle);
  }
  
  public void b(View paramView) {}
  
  void b(String paramString)
  {
    Intent localIntent = new Intent();
    if (this.jdField_a_of_type_AndroidContentIntent != null) {
      localIntent.putExtras(this.jdField_a_of_type_AndroidContentIntent);
    }
    localIntent.putExtra("ALBUM_ID", "$RecentAlbumId");
    localIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", this.jdField_j_of_type_Int);
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    localIntent.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString);
    localIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString);
    HotChatManager localHotChatManager = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59);
    if ((this.jdField_a_of_type_AndroidContentIntent == null) || (!this.jdField_a_of_type_AndroidContentIntent.hasExtra("showFlashPic"))) {
      localIntent.putExtra("showFlashPic", FlashPicHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localHotChatManager, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString));
    }
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof SplashActivity))
    {
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
      localIntent = AIOUtils.a(localIntent, null);
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      localIntent.putExtra("key_activity_code", ChatActivityUtils.a(this.jdField_a_of_type_AndroidAppActivity));
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 9501) {
        break label464;
      }
      if (!(this.jdField_a_of_type_AndroidAppActivity instanceof SplashActivity)) {
        break label447;
      }
      localIntent.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
      localIntent = AIOUtils.a(localIntent, null);
      label265:
      localIntent.putExtra(AlbumConstants.h, 80);
      localIntent.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      localIntent.putExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", false);
    }
    for (;;)
    {
      localIntent.putExtra("PhotoConst.DEST_VIDEO_ACTIVITY_CLASS_NAME", SendVideoActivity.class.getName());
      localIntent.putExtra("PhotoConst.DEST_VIDEO_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      localIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.jdField_f_of_type_Int);
      localIntent.putExtra("PhotoConst.IS_OVERLOAD", false);
      localIntent.setClass(this.jdField_a_of_type_AndroidAppActivity, PhotoPreviewActivity.class);
      localIntent.addFlags(603979776);
      localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
      localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramString);
      localIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", this.jdField_j_of_type_Int);
      localIntent.putExtra("PhotoConst.ALLOW_LOCK", false);
      localIntent.setClass(this.jdField_a_of_type_AndroidAppActivity, PhotoPreviewActivity.class);
      localIntent.addFlags(603979776);
      this.jdField_a_of_type_AndroidAppActivity.startActivityForResult(localIntent, 2);
      return;
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ChatActivity.class.getName());
      break;
      label447:
      localIntent.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", ChatActivity.class.getName());
      break label265;
      label464:
      localIntent.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SendPhotoActivity.class.getName());
      localIntent.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      localIntent.putExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", true);
      localIntent.putExtra("key_confess_topicid", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_e_of_type_Int);
    }
  }
  
  public void c()
  {
    int i1 = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getFirstVisiblePosition();
    int i2 = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getLastVisiblePosition();
    if (QLog.isColorLevel()) {
      QLog.d("check", 2, "updateCheckView first=" + i1 + "lastvisible=" + i2);
    }
    if (i1 <= i2)
    {
      View localView = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.b(i1);
      LocalMediaInfo localLocalMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$MyAdapter.a(i1);
      if (localLocalMediaInfo != null)
      {
        int i3 = this.jdField_a_of_type_JavaUtilLinkedList.indexOf(localLocalMediaInfo.path);
        if (QLog.isColorLevel()) {
          QLog.d("check", 2, "updateCheckView mIndex=" + i3);
        }
        if ((i3 < 0) || (localView == null)) {
          break label183;
        }
        ((PhotoListPanel.MyAdapter.Holder)localView.getTag()).jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setCheckedNumber(i3 + 1);
        ((PhotoListPanel.MyAdapter.Holder)localView.getTag()).b.setVisibility(0);
      }
      for (;;)
      {
        i1 += 1;
        break;
        label183:
        if (localView == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("check", 2, "updateCheckView view is null?????=");
          }
        }
        else
        {
          ((PhotoListPanel.MyAdapter.Holder)localView.getTag()).jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
          ((PhotoListPanel.MyAdapter.Holder)localView.getTag()).b.setVisibility(4);
        }
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
      localIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.jdField_f_of_type_Int);
      localIntent.putExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", false));
      this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
    }
  }
  
  protected void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanel", 2, "onAlbumBtnClicked");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$BottomBtnClickListener != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$BottomBtnClickListener.a(this);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {}
    try
    {
      ((TroopHandler)((QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_a_of_type_JavaLangString)).a(20)).e(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true);
      if ((!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty()) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$MyAdapter.a((String)this.jdField_a_of_type_JavaUtilLinkedList.peek()) == 1))
      {
        QQCustomDialog localQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 2131432976);
        localQQCustomDialog.setPositiveButton(2131433016, new DialogUtil.DialogOnClickAdapter());
        localQQCustomDialog.show();
        return;
      }
    }
    catch (AccountNotMatchException localAccountNotMatchException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoListPanel", 2, "onAlbumBtnClicked() getAppRuntime ERROR");
        }
      }
    }
    if (!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty()) {}
    for (ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilLinkedList);; localArrayList = null)
    {
      if (this.m) {
        this.jdField_a_of_type_AndroidContentIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
      }
      this.jdField_a_of_type_AndroidContentIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", this.jdField_j_of_type_Int);
      this.jdField_a_of_type_AndroidContentIntent.putExtra("peakconstant.request_code", 100006);
      this.jdField_a_of_type_AndroidContentIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.jdField_f_of_type_Int);
      this.jdField_a_of_type_AndroidContentIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 1);
      this.jdField_a_of_type_AndroidContentIntent.putExtra("PhotoConst.IS_SHOW_QZONE_ALBUM", true);
      this.jdField_a_of_type_AndroidContentIntent.putExtra("PhotoConst.is_troop_send_mixed_msg", this.n);
      this.jdField_a_of_type_AndroidContentIntent.putExtra("PhotoConst.DISABLE_UPLOAD_TO_TROOP_ALBUM", this.jdField_i_of_type_Boolean);
      PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localArrayList, this.jdField_a_of_type_AndroidContentIntent);
      g();
      ReportController.b(null, "CliOper", "", "", "0X8005E05", "0X8005E05", 0, 0, "", "", "", "");
      j();
      return;
    }
  }
  
  protected void f()
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanel", 2, "onSendBtnClicked");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$BottomBtnClickListener != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$BottomBtnClickListener.b(this);
      return;
    }
    int i1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$MyAdapter.a((String)this.jdField_a_of_type_JavaUtilLinkedList.peek());
    ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilLinkedList);
    Object localObject1;
    Object localObject2;
    if (i1 == 0)
    {
      localObject1 = "0X8005A2F";
      localObject2 = localArrayList.size() + "";
      if (!b()) {
        break label131;
      }
      a(localArrayList);
    }
    for (;;)
    {
      g();
      return;
      localObject1 = "0X80058E2";
      localObject2 = "";
      break;
      label131:
      Object localObject3 = (TroopRobotManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(202);
      if ((this.n) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (b() > 0) && (!((TroopRobotManager)localObject3).a()))
      {
        if (((this.jdField_a_of_type_AndroidAppActivity instanceof FragmentActivity)) && (((FragmentActivity)this.jdField_a_of_type_AndroidAppActivity).getChatFragment() != null))
        {
          localObject1 = ((FragmentActivity)this.jdField_a_of_type_AndroidAppActivity).getChatFragment().a();
          if (localObject1 != null)
          {
            localObject2 = new ArrayList();
            localObject3 = AtTroopMemberSpan.a(((BaseChatPie)localObject1).jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText(), (ArrayList)localObject2);
            MixedMsgManager localMixedMsgManager = (MixedMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(173);
            QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
            i1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
            if (this.jdField_f_of_type_Int == 2) {}
            for (;;)
            {
              localMixedMsgManager.a(localQQAppInterface, str, i1, localArrayList, bool, (String)localObject3, (ArrayList)localObject2, ((BaseChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo);
              ((BaseChatPie)localObject1).aL();
              break;
              bool = false;
            }
          }
        }
      }
      else
      {
        if (localArrayList != null) {
          NewFlowCameraReporter.a(localArrayList);
        }
        a(i1, localArrayList, this.jdField_c_of_type_Boolean, false, (String)localObject1, (String)localObject2, "");
      }
    }
  }
  
  public void g()
  {
    a(true);
  }
  
  public void h()
  {
    Object localObject1 = getResources().getString(2131435904);
    if (b()) {
      localObject1 = getResources().getString(2131435906);
    }
    if (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0)
    {
      bool = true;
      Object localObject2 = localObject1;
      if (bool)
      {
        this.jdField_c_of_type_AndroidWidgetButton.setContentDescription((String)localObject1 + this.jdField_a_of_type_JavaUtilLinkedList.size() + "张");
        localObject2 = (String)localObject1 + "(" + this.jdField_a_of_type_JavaUtilLinkedList.size() + ")";
      }
      this.jdField_c_of_type_AndroidWidgetButton.setText((CharSequence)localObject2);
      this.jdField_c_of_type_AndroidWidgetButton.setEnabled(bool);
      if (bool) {
        break label212;
      }
      this.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
      this.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(true);
      this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
      this.jdField_b_of_type_AndroidWidgetTextView.setEnabled(true);
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      i();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$ImageCountChangedListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$ImageCountChangedListener.a(b());
      }
      return;
      bool = false;
      break;
      label212:
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$MyAdapter.a((String)this.jdField_a_of_type_JavaUtilLinkedList.peek()) != 1) {
        break label291;
      }
      this.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
      this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      this.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(false);
      this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
      this.jdField_b_of_type_AndroidWidgetTextView.setEnabled(false);
      if (!this.jdField_h_of_type_Boolean) {
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      }
    }
    label291:
    this.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(true);
    this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
    this.jdField_b_of_type_AndroidWidgetTextView.setEnabled(true);
    localObject1 = this.jdField_b_of_type_AndroidWidgetButton;
    if (this.jdField_a_of_type_JavaUtilLinkedList.size() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ((Button)localObject1).setEnabled(bool);
      i();
      break;
    }
  }
  
  void i()
  {
    if (this.jdField_e_of_type_Boolean) {
      return;
    }
    switch (this.jdField_f_of_type_Int)
    {
    case 1: 
    default: 
      return;
    case 0: 
      this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      return;
    }
    setQualityTvRawPhotoText();
    this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
  }
  
  public void j()
  {
    if ((this.jdField_c_of_type_AndroidViewView != null) && (this.jdField_c_of_type_AndroidViewView.getVisibility() == 0))
    {
      BabyQHandler.a(this.jdField_c_of_type_AndroidViewView);
      this.jdField_c_of_type_AndroidViewView = null;
      this.jdField_k_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$MyAdapter.notifyDataSetChanged();
      BabyQHandler.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_AndroidViewView);
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
        if (a() > 0)
        {
          QQToast.a(this.jdField_a_of_type_AndroidAppActivity, getResources().getString(2131435920), 0).b(getResources().getDimensionPixelSize(2131558448));
          this.jdField_f_of_type_Int = 0;
          this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
          return;
        }
        this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
        this.jdField_f_of_type_Int = 2;
        setQualityTvRawPhotoText();
        this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription("原图");
        ReportController.b(null, "CliOper", "", "", "0X8005E07", "0X8005E07", 0, 0, "", "", "", "");
        return;
      }
      this.jdField_f_of_type_Int = 0;
      this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription("原图");
      return;
      h();
    } while (!AppSetting.jdField_b_of_type_Boolean);
    CheckBox localCheckBox = this.jdField_b_of_type_AndroidWidgetCheckBox;
    StringBuilder localStringBuilder = new StringBuilder().append("上传到").append(this.jdField_e_of_type_JavaLangString).append(",");
    if (this.jdField_b_of_type_AndroidWidgetCheckBox.isChecked()) {}
    for (paramCompoundButton = "已选中";; paramCompoundButton = "未选中")
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
      BabyQHandler.a(this.jdField_b_of_type_AndroidViewView);
      return;
      e();
      continue;
      d();
      continue;
      if (!this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked())
      {
        if (a() > 0) {
          QQToast.a(this.jdField_a_of_type_AndroidAppActivity, getResources().getString(2131435920), 0).b(getResources().getDimensionPixelSize(2131558448));
        } else {
          this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
        }
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
        continue;
        f();
        continue;
        paramView = QZoneHelper.UserInfo.a();
        paramView.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
        paramView.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
        QZoneHelper.c(this.jdField_a_of_type_AndroidAppActivity, paramView, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString, 100008);
        continue;
        if (this.jdField_b_of_type_AndroidWidgetCheckBox != null)
        {
          this.jdField_b_of_type_AndroidWidgetCheckBox.performClick();
          continue;
          m();
          if (b())
          {
            paramView = new QZoneClickReport.ReportInfo();
            paramView.jdField_a_of_type_Long = Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue();
            paramView.jdField_c_of_type_JavaLangString = "459";
            paramView.jdField_d_of_type_JavaLangString = "3";
            QZoneClickReport.report(this.jdField_a_of_type_JavaLangString, paramView, true);
          }
          else
          {
            paramView = new QZoneClickReport.ReportInfo();
            paramView.jdField_a_of_type_Long = Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue();
            paramView.jdField_c_of_type_JavaLangString = "459";
            paramView.jdField_d_of_type_JavaLangString = "2";
            QZoneClickReport.report(this.jdField_a_of_type_JavaLangString, paramView, true);
          }
        }
      }
    }
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$MyAdapter == null) {
      return;
    }
    int i1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$MyAdapter.getItemViewType(paramInt);
    if (this.m)
    {
      b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$MyAdapter.a(paramInt).path);
      return;
    }
    int i2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$MyAdapter.a((String)this.jdField_a_of_type_JavaUtilLinkedList.peek());
    if ((!this.jdField_h_of_type_Boolean) && (i2 != -1) && (i2 != i1))
    {
      paramAdapterView = DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 2131432975);
      paramAdapterView.setPositiveButton(2131433016, new DialogUtil.DialogOnClickAdapter());
      paramAdapterView.show();
      return;
    }
    paramView = new ArrayList(this.jdField_a_of_type_JavaUtilLinkedList);
    if (i1 == 0)
    {
      paramAdapterView = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$MyAdapter.a(paramInt).path;
      if ((TextUtils.isEmpty(paramAdapterView)) || (!FileUtils.b(paramAdapterView)))
      {
        if (QLog.isColorLevel()) {
          QLog.e("PhotoListPanel", 2, "PhotoListPanel onItemClick,clickPath not exits, just return.");
        }
        QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2131434505, 0).a();
        a();
        this.jdField_a_of_type_JavaUtilLinkedList.clear();
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        h();
        return;
      }
      paramAdapterView = new Intent();
      paramAdapterView.putExtra("ALBUM_ID", "$RecentAlbumId");
      paramAdapterView.putExtra("PhotoConst.SEND_BUSINESS_TYPE", this.jdField_j_of_type_Int);
      paramAdapterView.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      paramAdapterView.putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      paramAdapterView.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString);
      paramAdapterView.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString);
      paramAdapterView.putExtra("entrance", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Int);
      paramAdapterView.putExtra("PhotoConst.is_troop_send_mixed_msg", this.n);
      paramAdapterView.putExtra("PhotoConst.SHOW_ALBUM", true);
      paramAdapterView.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.jdField_b_of_type_JavaUtilArrayList);
      paramAdapterView.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$MyAdapter.a(paramInt).position);
      paramAdapterView.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", paramView);
      paramAdapterView.putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", this.jdField_a_of_type_JavaUtilArrayList);
      if (this.jdField_a_of_type_AndroidContentIntent != null)
      {
        paramAdapterView.putExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", false));
        paramAdapterView.putExtra("session_info", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      if ((this.jdField_a_of_type_AndroidAppActivity instanceof SplashActivity))
      {
        paramAdapterView.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
        paramAdapterView = AIOUtils.a(paramAdapterView, null);
        label455:
        paramAdapterView.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        paramAdapterView.putExtra("key_activity_code", ChatActivityUtils.a(this.jdField_a_of_type_AndroidAppActivity));
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 9501) {
          break label852;
        }
        if (!(this.jdField_a_of_type_AndroidAppActivity instanceof SplashActivity)) {
          break label835;
        }
        paramAdapterView.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
        paramAdapterView = AIOUtils.a(paramAdapterView, null);
        label524:
        paramAdapterView.putExtra(AlbumConstants.h, 80);
        paramAdapterView.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        paramAdapterView.putExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", true);
        label554:
        paramAdapterView.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.jdField_f_of_type_Int);
        paramAdapterView.putExtra("keep_selected_status_after_finish", true);
        paramAdapterView.putExtra("PhotoConst.IS_OVERLOAD", false);
        paramAdapterView.putExtra("PhotoConst.MAXUM_SELECTED_NUM", this.jdField_d_of_type_Int);
        paramAdapterView.putExtra("custom_photopreview_sendbtn_report", true);
        paramAdapterView.putExtra("custom_photopreview_sendbtn_reportActionName", "0X8005E0A");
        paramAdapterView.putExtra("custom_photopreview_sendbtn_reportReverse2", "0");
        paramAdapterView.putExtra("custom_photopreview_editbtn_reportActionName", "0X8005E0B");
        paramAdapterView.putExtra("custom_photopreview_rawcheckbox_reportActionName", "0X8005E0C");
        paramView = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59);
        if ((this.jdField_a_of_type_AndroidContentIntent == null) || (!this.jdField_a_of_type_AndroidContentIntent.hasExtra("showFlashPic"))) {
          paramAdapterView.putExtra("showFlashPic", FlashPicHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramView, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString));
        }
        paramAdapterView.setClass(this.jdField_a_of_type_AndroidAppActivity, PhotoPreviewActivity.class);
        paramAdapterView.addFlags(603979776);
        this.jdField_a_of_type_AndroidAppActivity.startActivityForResult(paramAdapterView, 100004);
        BabyQHandler.a(this.jdField_b_of_type_AndroidViewView);
        label746:
        paramAdapterView = "";
        if (i1 != 0) {
          break label1423;
        }
        paramAdapterView = "0";
      }
    }
    for (;;)
    {
      ReportController.b(null, "CliOper", "", "", "0X8005E09", "0X8005E09", 0, 0, paramAdapterView, "", "", "");
      return;
      if ((this.jdField_a_of_type_AndroidAppActivity instanceof LiteActivity))
      {
        paramAdapterView.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", LiteActivity.class.getName());
        break label455;
      }
      paramAdapterView.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ChatActivity.class.getName());
      break label455;
      label835:
      paramAdapterView.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", ChatActivity.class.getName());
      break label524;
      label852:
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 6000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 6003))
      {
        paramAdapterView.putExtra(AlbumConstants.h, 55);
        paramAdapterView.putExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", false);
        paramAdapterView.putExtra("PhotoConst.IS_SEND_FILESIZE_LIMIT", true);
        break label554;
      }
      paramAdapterView.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SendPhotoActivity.class.getName());
      paramAdapterView.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      paramAdapterView.putExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", true);
      paramAdapterView.putExtra("key_confess_topicid", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_e_of_type_Int);
      break label554;
      if (i1 != 1) {
        break label746;
      }
      paramAdapterView = (String)this.jdField_a_of_type_JavaUtilLinkedList.peek();
      LocalMediaInfo localLocalMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$MyAdapter.a(paramInt);
      if (localLocalMediaInfo.fileSize > this.jdField_a_of_type_Long)
      {
        if (!(this.jdField_a_of_type_AndroidAppActivity instanceof BaseActivity)) {
          break;
        }
        paramAdapterView = (BaseActivity)this.jdField_a_of_type_AndroidAppActivity;
        paramAdapterView = DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 232, null, this.jdField_a_of_type_AndroidAppActivity.getString(2131437386), new vpf(this, paramAdapterView), new vpg(this));
        try
        {
          paramAdapterView.show();
          return;
        }
        catch (Exception paramAdapterView)
        {
          return;
        }
      }
      if ((this.jdField_a_of_type_JavaUtilLinkedList.size() >= this.jdField_e_of_type_Int) && (paramAdapterView != null) && (!paramAdapterView.equals(localLocalMediaInfo.path)))
      {
        paramAdapterView = DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 2131432976);
        paramAdapterView.setPositiveButton(2131433016, new DialogUtil.DialogOnClickAdapter());
        paramAdapterView.show();
        return;
      }
      paramAdapterView = new Intent(this.jdField_a_of_type_AndroidAppActivity, ShortVideoPreviewActivity.class);
      paramAdapterView.putExtra("file_send_path", localLocalMediaInfo.path);
      paramAdapterView.putExtra("file_send_size", localLocalMediaInfo.fileSize);
      paramAdapterView.putExtra("file_send_duration", localLocalMediaInfo.mDuration);
      paramAdapterView.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      paramAdapterView.putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      paramAdapterView.putExtra("file_source", "album");
      paramAdapterView.putExtra("custom_shortvideopreview_sendbtn_reportActionName", "0X8005E0A");
      paramAdapterView.putExtra("custom_shortvideopreview_sendbtn_reportReverse2", "1");
      if ((this.jdField_a_of_type_AndroidAppActivity instanceof SplashActivity))
      {
        paramAdapterView.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
        paramAdapterView = AIOUtils.a(paramAdapterView, null);
        label1273:
        paramAdapterView.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        paramAdapterView.putExtra("key_activity_code", ChatActivityUtils.a(this.jdField_a_of_type_AndroidAppActivity));
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 6000) {
          break label1395;
        }
        paramAdapterView.putExtra(AlbumConstants.h, 55);
        paramAdapterView.putExtra("PhotoConst.IS_SUPPORT_VIDEO_CHECKBOX", true);
        paramAdapterView.putExtra("PhotoConst.PHOTO_PATHS", paramView);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidAppActivity.startActivity(paramAdapterView);
        break;
        if ((this.jdField_a_of_type_AndroidAppActivity instanceof LiteActivity))
        {
          paramAdapterView.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", LiteActivity.class.getName());
          break label1273;
        }
        paramAdapterView.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ChatActivity.class.getName());
        break label1273;
        label1395:
        paramAdapterView.putExtra("PhotoConst.DEST_VIDEO_ACTIVITY_CLASS_NAME", SendVideoActivity.class.getName());
        paramAdapterView.putExtra("PhotoConst.DEST_VIDEO_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      }
      label1423:
      if (i1 == 1) {
        paramAdapterView = "1";
      }
    }
  }
  
  public boolean onItemLongClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanel", 2, "onItemLongClick position" + paramInt);
    }
    return true;
  }
  
  public void setCustomOnClickListener(PhotoListPanel.BottomBtnClickListener paramBottomBtnClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$BottomBtnClickListener = paramBottomBtnClickListener;
  }
  
  public void setImageCountChangedListener(PhotoListPanel.ImageCountChangedListener paramImageCountChangedListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$ImageCountChangedListener = paramImageCountChangedListener;
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
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter = ((MediaFileFilter)MediaFileFilter.a.get(1));
        return;
      }
    } while (this.jdField_b_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter == null);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter = this.jdField_b_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter;
    this.jdField_b_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter = null;
  }
  
  public void setImageSentListener(PhotoListPanel.ImageSentListener paramImageSentListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$ImageSentListener = paramImageSentListener;
  }
  
  public void setMixedMsgMode(boolean paramBoolean)
  {
    this.n = paramBoolean;
  }
  
  public void setOnSwipeUpAndDragListener(PhotoListPanel.SwipeUpAndDragListener paramSwipeUpAndDragListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener = paramSwipeUpAndDragListener;
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnTouchListener(paramSwipeUpAndDragListener);
  }
  
  public void setQualityTvRawPhotoText()
  {
    int i2 = 0;
    Object localObject = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
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
        QLog.d("PhotoListPanel", 2, "setQualityTextViewText, path:" + str + ",len:" + l1);
        i1 = i3;
      }
    }
    localObject = PhotoUtils.a(this.jdField_a_of_type_AndroidAppActivity, i1);
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
    if (this.jdField_a_of_type_JavaUtilLinkedList.isEmpty()) {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
    }
  }
  
  public void setReceiptMode(boolean paramBoolean, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidContentIntent.putExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", paramBoolean);
    setImageOnly(paramBoolean);
    this.jdField_i_of_type_Boolean = paramBoolean;
    if (paramBoolean)
    {
      this.jdField_d_of_type_Int = Math.min(ReceiptUtil.b(paramQQAppInterface), this.jdField_d_of_type_Int);
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnTouchListener(null);
    }
    for (;;)
    {
      g();
      return;
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener);
      this.jdField_d_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("PhotoConst.MAXUM_SELECTED_NUM", 20);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 9501) {
        this.jdField_d_of_type_Int = 5;
      }
    }
  }
  
  public void setSelectLimitListener(PhotoListPanel.SelectLimitListener paramSelectLimitListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SelectLimitListener = paramSelectLimitListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.PhotoListPanel
 * JD-Core Version:    0.7.0.1
 */