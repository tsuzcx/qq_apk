package com.tencent.mobileqq.activity.aio.photo;

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
import android.os.Parcelable;
import android.support.annotation.NonNull;
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
import com.dataline.activities.LiteActivity;
import com.tencent.aelight.camera.qqstory.api.IAELaunchEditPic;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade.SendMsgParams;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.ReplyHelper;
import com.tencent.mobileqq.activity.aio.rebuild.PlusPanelUtils;
import com.tencent.mobileqq.activity.aio.reply.ReplyMsgUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.ReplacePhotoDataUtil;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.activity.photo.SendPhotoTask;
import com.tencent.mobileqq.activity.photo.album.QQAlbumUtils;
import com.tencent.mobileqq.activity.photo.albumlogicImp.AlbumListCustomizationAIO;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationAIO;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationFileAssistant;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationAIO;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationFileAssistant;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraReporter;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity;
import com.tencent.mobileqq.activity.shortvideo.SendVideoInfo;
import com.tencent.mobileqq.activity.shortvideo.SendVideoTask;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.mobileqq.app.BabyQHandler;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.drawable.EmptyDrawable;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.mixedmsg.MixedMsgManager;
import com.tencent.mobileqq.pic.IPresendPicMgr;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PresendPicMgrService;
import com.tencent.mobileqq.pic.api.IPicBus;
import com.tencent.mobileqq.pic.api.IPicFlash;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.URIRequest;
import com.tencent.mobileqq.receipt.ReceiptMsgManager;
import com.tencent.mobileqq.receipt.ReceiptUtil;
import com.tencent.mobileqq.richmedia.RichmediaService;
import com.tencent.mobileqq.shortvideo.SVBusiUtil;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mobileqq.troop.troopphoto.api.ITroopPhotoHandler;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AlbumConstants;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SendByFile;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.SwipeUpAndDragListener;
import com.tencent.mobileqq.wifi.FreeWifiHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.BinderWarpper;
import com.tencent.util.Pair;
import com.tencent.widget.XEditTextEx;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneClickReport.ReportInfo;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.qzone.report.retention.RetentionReport;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import mqq.app.AccountNotMatchException;
import mqq.app.AppRuntime;

public class PhotoListPanel
  extends RelativeLayout
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  public static int a = 20;
  public static int b;
  public long a;
  Activity jdField_a_of_type_AndroidAppActivity;
  Intent jdField_a_of_type_AndroidContentIntent;
  SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  RecyclerView.LayoutManager jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager;
  public RecyclerView a;
  View jdField_a_of_type_AndroidViewView;
  Button jdField_a_of_type_AndroidWidgetButton;
  CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public SessionInfo a;
  PhotoListPanel.BottomBtnClickListener jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$BottomBtnClickListener;
  PhotoListPanel.ImageCountChangedListener jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$ImageCountChangedListener;
  PhotoListPanel.ImageSentListener jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$ImageSentListener;
  public PhotoListPanel.PhotoPanelAdapter a;
  PhotoListPanel.SelectLimitListener jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SelectLimitListener;
  MediaFileFilter jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter;
  public QQAppInterface a;
  EmptyDrawable jdField_a_of_type_ComTencentMobileqqDrawableEmptyDrawable;
  private SendByFile jdField_a_of_type_ComTencentMobileqqUtilsSendByFile;
  SwipeUpAndDragListener jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener;
  Boolean jdField_a_of_type_JavaLangBoolean;
  String jdField_a_of_type_JavaLangString;
  ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  HashMap<LocalMediaInfo, LocalMediaInfo> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public LinkedList<String> a;
  public Map<String, LocalMediaInfo> a;
  public volatile boolean a;
  View jdField_b_of_type_AndroidViewView;
  Button jdField_b_of_type_AndroidWidgetButton;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  MediaFileFilter jdField_b_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter;
  EmptyDrawable jdField_b_of_type_ComTencentMobileqqDrawableEmptyDrawable;
  String jdField_b_of_type_JavaLangString;
  ArrayList<String> jdField_b_of_type_JavaUtilArrayList;
  boolean jdField_b_of_type_Boolean;
  public int c;
  View jdField_c_of_type_AndroidViewView;
  Button jdField_c_of_type_AndroidWidgetButton;
  String jdField_c_of_type_JavaLangString;
  boolean jdField_c_of_type_Boolean;
  int jdField_d_of_type_Int = e();
  View jdField_d_of_type_AndroidViewView;
  private String jdField_d_of_type_JavaLangString;
  boolean jdField_d_of_type_Boolean;
  int jdField_e_of_type_Int;
  private String jdField_e_of_type_JavaLangString = HardCodeUtil.a(2131708089);
  boolean jdField_e_of_type_Boolean;
  int jdField_f_of_type_Int;
  boolean jdField_f_of_type_Boolean;
  int jdField_g_of_type_Int;
  boolean jdField_g_of_type_Boolean;
  int jdField_h_of_type_Int;
  boolean jdField_h_of_type_Boolean;
  int jdField_i_of_type_Int = 278921216;
  boolean jdField_i_of_type_Boolean = false;
  int j;
  public boolean j;
  int jdField_k_of_type_Int;
  boolean jdField_k_of_type_Boolean = false;
  public int l;
  boolean l;
  private int jdField_m_of_type_Int = -1;
  boolean jdField_m_of_type_Boolean = false;
  boolean n = false;
  boolean o = false;
  boolean p;
  boolean q;
  
  public PhotoListPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
    this.jdField_a_of_type_Long = 0L;
    this.jdField_j_of_type_Boolean = true;
    this.jdField_l_of_type_Boolean = false;
    this.jdField_j_of_type_Int = -16777216;
    this.jdField_l_of_type_Int = 0;
  }
  
  private void a(BaseChatPie paramBaseChatPie, Pair<ArrayList<String>, ArrayList<String>> paramPair)
  {
    MessageForReplyText.SourceMsgInfo localSourceMsgInfo = ((ReplyHelper)paramBaseChatPie.a(119)).a();
    boolean bool3 = true;
    boolean bool1;
    if ((localSourceMsgInfo != null) && (TextUtils.isEmpty(localSourceMsgInfo.mAnonymousNickName)))
    {
      paramBaseChatPie.a(new ChatActivityFacade.SendMsgParams());
      if (((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) != null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      i1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(localSourceMsgInfo.mSourceMsgSenderUin);
      ((StringBuilder)localObject3).append("");
      localObject1 = ContactUtils.a((BaseQQAppInterface)localObject1, i1, (String)localObject2, ((StringBuilder)localObject3).toString());
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      localObject3 = paramBaseChatPie.jdField_a_of_type_AndroidContentContext;
      localObject4 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append(localSourceMsgInfo.mSourceMsgSenderUin);
      ((StringBuilder)localObject5).append("");
      localObject5 = ((StringBuilder)localObject5).toString();
      localObject6 = paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx;
      boolean bool2;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      localObject1 = AtTroopMemberSpan.a((AppRuntime)localObject2, (Context)localObject3, (String)localObject4, (String)localObject5, (String)localObject1, bool1, (EditText)localObject6, bool2, true);
      if ((localObject1 != null) && (((SpannableString)localObject1).length() != 0)) {
        paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().insert(0, (CharSequence)localObject1);
      }
      localObject1 = ReplyMsgUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localSourceMsgInfo);
      localSourceMsgInfo.mType = 0;
      if (((localObject1 instanceof MessageForPic)) || ((localObject1 instanceof MessageForMixedMsg))) {
        localSourceMsgInfo.oriMsgType = 1;
      }
    }
    Object localObject1 = new ArrayList();
    Object localObject2 = AtTroopMemberSpan.a(paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText(), (ArrayList)localObject1);
    Object localObject3 = (MixedMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MIXED_MSG_MANAGER);
    Object localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    Object localObject5 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    int i1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    Object localObject6 = (ArrayList)paramPair.first;
    if (this.jdField_c_of_type_Int == 2) {
      bool1 = bool3;
    } else {
      bool1 = false;
    }
    ((MixedMsgManager)localObject3).a((QQAppInterface)localObject4, (String)localObject5, i1, (ArrayList)localObject6, bool1, (String)localObject2, (ArrayList)localObject1, localSourceMsgInfo);
    paramBaseChatPie.ak();
    if (!((ArrayList)paramPair.second).isEmpty()) {
      a(new ArrayList(), (ArrayList)paramPair.second, this.jdField_c_of_type_Boolean);
    }
  }
  
  private boolean e()
  {
    return false;
  }
  
  @TargetApi(9)
  private void n()
  {
    boolean bool = e();
    Object localObject;
    if (a())
    {
      localObject = "qzone_will_upload_to_personal_album";
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("qzone_will_upload_to_qun_album");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      localObject = ((StringBuilder)localObject).toString();
    }
    if (Build.VERSION.SDK_INT >= 9)
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean((String)localObject, bool).apply();
      return;
    }
    ThreadManager.postImmediately(new PhotoListPanel.4(this, (String)localObject, bool), null, false);
  }
  
  protected int a()
  {
    return QzoneConfig.getInstance().getConfig("PhotoUpload", "C2CAioEnableSyncImageToQzone", 1);
  }
  
  protected long a(String paramString)
  {
    return new File(paramString).length();
  }
  
  public Intent a()
  {
    ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilLinkedList);
    Intent localIntent = new Intent();
    localIntent.putExtra("PhotoConst.SHOW_ALBUM", true);
    localIntent.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", localArrayList);
    localIntent.putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", this.jdField_a_of_type_JavaUtilArrayList);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getSelectedPhotosIntent SELECTED_PATHS size=");
      localStringBuilder.append(localArrayList.size());
      localStringBuilder.append(",SELECTED_INDEXS size=");
      localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      int i1;
      if (localArrayList == null) {
        i1 = 0;
      } else {
        i1 = localArrayList.size();
      }
      localStringBuilder.append(i1);
      QLog.d("PhotoListPanel", 2, localStringBuilder.toString());
    }
    return localIntent;
  }
  
  public PhotoListPanel.CheckBoxClickedListener a()
  {
    return new PhotoListPanel.CheckBoxClickedListener(this);
  }
  
  public HashMap<String, String> a()
  {
    return ReplacePhotoDataUtil.a(this.jdField_a_of_type_JavaUtilHashMap);
  }
  
  public void a()
  {
    SwipeUpAndDragListener.jdField_a_of_type_Int = SwipeUpAndDragListener.a();
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("cancelAllPresendPic, type = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("PhotoListPanel", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("key_presend_cancel_type", paramInt);
    RichmediaService.d((Bundle)localObject);
  }
  
  public void a(int paramInt, Intent paramIntent)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onActivityResult, requestCode = ");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d("PhotoListPanel", 2, ((StringBuilder)localObject1).toString());
    }
    switch (paramInt)
    {
    default: 
      return;
    case 10005: 
      if (QLog.isColorLevel()) {
        QLog.d("PhotoListPanel", 2, "onActivityResult, PeakConstants.REQUEST_PHOTOLIST_PANEL_SEND_RETURN");
      }
      c();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanel", 2, "onActivityResult, PeakConstants.REQUEST_PHOTOPREVIEW_RETURE");
    }
    ReplacePhotoDataUtil.a(getContext(), paramIntent, true, this.jdField_a_of_type_JavaUtilHashMap);
    Object localObject1 = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (String)((Iterator)localObject1).next();
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$PhotoPanelAdapter.a((String)localObject2);
      if (localObject2 != null) {
        ((LocalMediaInfo)localObject2).mChecked = false;
      }
    }
    this.jdField_c_of_type_Int = paramIntent.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
    paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.SELECTED_PATHS");
    this.jdField_a_of_type_JavaUtilLinkedList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if (paramIntent != null)
    {
      paramIntent = paramIntent.iterator();
      while (paramIntent.hasNext())
      {
        localObject1 = (String)paramIntent.next();
        this.jdField_a_of_type_JavaUtilLinkedList.add(localObject1);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$PhotoPanelAdapter.a((String)localObject1);
        if (localObject1 != null)
        {
          if (!((LocalMediaInfo)localObject1).mChecked) {
            ((LocalMediaInfo)localObject1).mChecked = true;
          }
          this.jdField_a_of_type_JavaUtilArrayList.add(((LocalMediaInfo)localObject1).position);
        }
      }
    }
    paramIntent = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$ImageCountChangedListener;
    if (paramIntent != null) {
      paramIntent.a(a());
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$PhotoPanelAdapter.notifyDataSetChanged();
    j();
  }
  
  public void a(int paramInt, ArrayList<String> paramArrayList, boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, String paramString3, boolean paramBoolean3)
  {
    int i1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$PhotoPanelAdapter.getItemViewType(paramInt);
    a(paramArrayList, paramBoolean1, paramBoolean2, paramString1, paramString2, paramString3, i1, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$PhotoPanelAdapter.a(paramInt));
    boolean bool2 = b();
    Pair localPair = new Pair(new ArrayList(), new ArrayList());
    SendByFile localSendByFile = this.jdField_a_of_type_ComTencentMobileqqUtilsSendByFile;
    if (localSendByFile != null)
    {
      boolean bool1;
      if (this.jdField_c_of_type_Int == 2) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      localPair = localSendByFile.a(paramArrayList, bool1, this.jdField_a_of_type_JavaUtilMap, null);
    }
    else
    {
      ((ArrayList)localPair.first).addAll(paramArrayList);
    }
    if (i1 == 0)
    {
      if (!a(paramArrayList, bool2, this.jdField_c_of_type_Int)) {
        return;
      }
      if (bool2)
      {
        a((ArrayList)localPair.first, this.jdField_c_of_type_Int);
        return;
      }
      a(localPair, paramBoolean1, paramBoolean2, paramString1, paramString2, paramString3, paramBoolean3, this.jdField_c_of_type_Int);
      return;
    }
    if (i1 == 1)
    {
      if (((ArrayList)localPair.first).isEmpty()) {
        paramArrayList = localPair.second;
      } else {
        paramArrayList = localPair.first;
      }
      paramArrayList = (String)((ArrayList)paramArrayList).get(0);
      long l1 = a(paramArrayList);
      if (!a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$PhotoPanelAdapter.a(paramArrayList))) {
        return;
      }
      a(paramBoolean2, paramString1, paramString2, paramString3, l1, localPair);
    }
  }
  
  protected void a(Intent paramIntent)
  {
    ThreadManager.executeOnSubThread(new PhotoListPanel.3(this, new SendVideoTask((BaseActivity)this.jdField_a_of_type_AndroidAppActivity, paramIntent)));
  }
  
  public void a(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$PhotoPanelAdapter == null) {
      return;
    }
    ReportController.b(null, "dc00898", "", "", "0X800A913", "0X800A913", PhotoUtils.getTypeforReport2(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo), 0, "", "", "", "");
    int i1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$PhotoPanelAdapter.getItemViewType(paramInt);
    if (this.n)
    {
      b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$PhotoPanelAdapter.a(paramInt).path);
      return;
    }
    Object localObject2 = new ArrayList(this.jdField_a_of_type_JavaUtilLinkedList);
    String str = "0";
    if ((i1 == 0) || (i1 == 1))
    {
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$PhotoPanelAdapter.a(paramInt).path;
      if ((TextUtils.isEmpty((CharSequence)localObject1)) || (!FileUtils.fileExistsAndNotEmpty((String)localObject1))) {
        break label1376;
      }
      localObject1 = new ActivityURIRequest(this.jdField_a_of_type_AndroidAppActivity, "/base/album/photopreview");
      ((ActivityURIRequest)localObject1).extra().putString("ALBUM_ID", "$RecentAlbumId");
      ((ActivityURIRequest)localObject1).extra().putInt("PhotoConst.SEND_BUSINESS_TYPE", this.jdField_k_of_type_Int);
      ((ActivityURIRequest)localObject1).extra().putString("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      ((ActivityURIRequest)localObject1).extra().putString("PhotoConst.MY_UIN", this.jdField_a_of_type_JavaLangString);
      ((ActivityURIRequest)localObject1).extra().putInt("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      ((ActivityURIRequest)localObject1).extra().putString("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString);
      ((ActivityURIRequest)localObject1).extra().putString("uinname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString);
      ((ActivityURIRequest)localObject1).extra().putInt("entrance", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Int);
      ((ActivityURIRequest)localObject1).extra().putBoolean("PhotoConst.is_troop_send_mixed_msg", this.o);
      ((ActivityURIRequest)localObject1).extra().putBoolean("PhotoConst.SHOW_ALBUM", true);
      ((ActivityURIRequest)localObject1).extra().putStringArrayList("PhotoConst.PHOTO_PATHS", this.jdField_b_of_type_JavaUtilArrayList);
      ((ActivityURIRequest)localObject1).extra().putInt("PhotoConst.CURRENT_SELECTED_INDEX", this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$PhotoPanelAdapter.a(paramInt).position.intValue());
      ((ActivityURIRequest)localObject1).extra().putStringArrayList("PhotoConst.SELECTED_PATHS", (ArrayList)localObject2);
      ((ActivityURIRequest)localObject1).extra().putIntegerArrayList("PhotoConst.SELECTED_INDEXS", this.jdField_a_of_type_JavaUtilArrayList);
      ((ActivityURIRequest)localObject1).extra().putSerializable("PhotoConst.ALL_MEDIA_PATHS", (Serializable)this.jdField_a_of_type_JavaUtilMap);
      ((ActivityURIRequest)localObject1).extra().putSerializable("PhotoConst.editPathMap", ReplacePhotoDataUtil.b(this.jdField_a_of_type_JavaUtilHashMap));
      ((ActivityURIRequest)localObject1).extra().putBoolean("KEY_IS_ANONYMOUS", AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
      if (this.jdField_a_of_type_AndroidContentIntent != null)
      {
        ((ActivityURIRequest)localObject1).extra().putBoolean("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", b());
        ((ActivityURIRequest)localObject1).extra().putParcelable("session_info", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      localObject2 = this.jdField_a_of_type_AndroidAppActivity;
      if ((localObject2 instanceof SplashActivity))
      {
        ((ActivityURIRequest)localObject1).extra().putInt("key_pic_to_edit_from", 1);
        ((ActivityURIRequest)localObject1).extra().putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
        localObject1 = AIOUtils.a((ActivityURIRequest)localObject1, null);
      }
      else if ((localObject2 instanceof LiteActivity))
      {
        ((ActivityURIRequest)localObject1).extra().putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", LiteActivity.class.getName());
      }
      else
      {
        ((ActivityURIRequest)localObject1).extra().putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ChatActivity.class.getName());
      }
      ((ActivityURIRequest)localObject1).extra().putString("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      ((ActivityURIRequest)localObject1).extra().putString("key_activity_code", ChatActivityUtils.a(this.jdField_a_of_type_AndroidAppActivity));
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 9501)
      {
        if ((this.jdField_a_of_type_AndroidAppActivity instanceof SplashActivity))
        {
          ((ActivityURIRequest)localObject1).extra().putString("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
          localObject1 = AIOUtils.a((ActivityURIRequest)localObject1, null);
        }
        else
        {
          ((ActivityURIRequest)localObject1).extra().putString("PhotoConst.DEST_ACTIVITY_CLASS_NAME", ChatActivity.class.getName());
        }
        ((ActivityURIRequest)localObject1).extra().putInt(AlbumConstants.h, 80);
        ((ActivityURIRequest)localObject1).extra().putString("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        ((ActivityURIRequest)localObject1).extra().putBoolean("PhotoConst.SHOULD_SEND_RAW_PHOTO", true);
      }
      else if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 6000) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 6003))
      {
        ((ActivityURIRequest)localObject1).extra().putString("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SendPhotoActivity.class.getName());
        ((ActivityURIRequest)localObject1).extra().putString("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        ((ActivityURIRequest)localObject1).extra().putBoolean("PhotoConst.SHOULD_SEND_RAW_PHOTO", true);
        ((ActivityURIRequest)localObject1).extra().putInt("key_confess_topicid", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_e_of_type_Int);
      }
      else
      {
        ((ActivityURIRequest)localObject1).extra().putInt(AlbumConstants.h, 55);
        ((ActivityURIRequest)localObject1).extra().putBoolean("PhotoConst.SHOULD_SEND_RAW_PHOTO", false);
        ((ActivityURIRequest)localObject1).extra().putBoolean("PhotoConst.IS_SEND_FILESIZE_LIMIT", true);
      }
      ((ActivityURIRequest)localObject1).extra().putInt("PhotoConst.CURRENT_QUALITY_TYPE", this.jdField_c_of_type_Int);
      ((ActivityURIRequest)localObject1).extra().putBoolean("keep_selected_status_after_finish", true);
      ((ActivityURIRequest)localObject1).extra().putBoolean("PhotoConst.IS_OVERLOAD", false);
      ((ActivityURIRequest)localObject1).extra().putInt("PhotoConst.MAXUM_SELECTED_NUM", this.jdField_g_of_type_Int);
      ((ActivityURIRequest)localObject1).extra().putBoolean("custom_photopreview_sendbtn_report", true);
      ((ActivityURIRequest)localObject1).extra().putString("custom_photopreview_sendbtn_reportActionName", "0X8005E0A");
      ((ActivityURIRequest)localObject1).extra().putString("custom_photopreview_sendbtn_reportReverse2", "0");
      ((ActivityURIRequest)localObject1).extra().putString("custom_photopreview_editbtn_reportActionName", "0X8005E0B");
      ((ActivityURIRequest)localObject1).extra().putString("custom_photopreview_rawcheckbox_reportActionName", "0X8005E0C");
      ((ActivityURIRequest)localObject1).extra().putParcelable("KEY_THUMBNAL_BOUND", AnimationUtils.a(paramView.findViewById(2131369084)));
      ((ActivityURIRequest)localObject1).extra().putParcelable("session_info", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      paramView = this.jdField_a_of_type_AndroidContentIntent;
      if ((paramView == null) || (!paramView.hasExtra("showFlashPic")))
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (paramView != null) {
          paramView = (HotChatManager)paramView.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
        }
        ((ActivityURIRequest)localObject1).extra().putBoolean("showFlashPic", ((IPicFlash)QRoute.api(IPicFlash.class)).showFlashPicOption(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString));
      }
      ((ActivityURIRequest)localObject1).extra().putBoolean("PhotoConst.IS_JUMPTO_TROOP_ALBUM", e());
      ((ActivityURIRequest)localObject1).extra().putInt("enter_from", 1);
      ((ActivityURIRequest)localObject1).extra().putString("KEY_PHOTO_LIST_CLASS_NAME", PhotoListCustomizationAIO.jdField_a_of_type_JavaLangString);
      ((ActivityURIRequest)localObject1).extra().putString("KEY_ALBUM_LIST_CLASS_NAME", AlbumListCustomizationAIO.jdField_a_of_type_JavaLangString);
      ((ActivityURIRequest)localObject1).extra().putString("KEY_PHOTO_PREVIEW_CLASS_NAME", PhotoPreviewCustomizationAIO.jdField_a_of_type_JavaLangString);
      ((ActivityURIRequest)localObject1).extra().putBoolean("PHOTO_PREVIEW_NEED_DRAG_KEY", true);
      if (QFileAssistantUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
      {
        ((ActivityURIRequest)localObject1).extra().putInt(AlbumConstants.h, 2);
        ((ActivityURIRequest)localObject1).extra().putInt("enter_from", 51);
        ((ActivityURIRequest)localObject1).extra().putString("KEY_PHOTO_LIST_CLASS_NAME", PhotoListCustomizationFileAssistant.jdField_a_of_type_JavaLangString);
        ((ActivityURIRequest)localObject1).extra().putString("KEY_PHOTO_PREVIEW_CLASS_NAME", PhotoPreviewCustomizationFileAssistant.jdField_a_of_type_JavaLangString);
      }
      ((ActivityURIRequest)localObject1).setFlags(603979776);
      ((ActivityURIRequest)localObject1).setRequestCode(10004);
      QRoute.startUri((URIRequest)localObject1);
      BabyQHandler.a(this.jdField_b_of_type_AndroidViewView);
      if ((this.jdField_a_of_type_AndroidAppActivity instanceof SplashActivity))
      {
        paramView = new StringBuilder();
        paramView.append(this.jdField_a_of_type_JavaUtilLinkedList.size());
        paramView.append("");
        ReportController.b(null, "dc00898", "", "", "0X800A06C", "0X800A06C", 1, 0, paramView.toString(), "", "", "");
      }
    }
    if (i1 == 0) {
      paramView = str;
    }
    for (;;)
    {
      break;
      if (i1 == 1) {
        paramView = "1";
      } else {
        paramView = "";
      }
    }
    ReportController.b(null, "CliOper", "", "", "0X8005E09", "0X8005E09", 0, 0, paramView, "", "", "");
    return;
    label1376:
    if (QLog.isColorLevel()) {
      QLog.e("PhotoListPanel", 2, "PhotoListPanel onItemClick,clickPath not exits, just return.");
    }
    QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2131694908, 0).a();
    b();
    this.jdField_a_of_type_JavaUtilLinkedList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    j();
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    if (this.jdField_m_of_type_Int != 10006) {
      return;
    }
    this.jdField_m_of_type_Int = -1;
    Intent localIntent = this.jdField_a_of_type_AndroidAppActivity.getIntent();
    if (localIntent.hasExtra("PhotoConst.send_photo_activity_result")) {
      localIntent.removeExtra("PhotoConst.send_photo_activity_result");
    } else {
      a(1019);
    }
    h();
    paramBaseChatPie.Q();
  }
  
  protected void a(SendVideoTask paramSendVideoTask)
  {
    paramSendVideoTask.a();
    if ((paramSendVideoTask.jdField_b_of_type_JavaLangString != null) && (!paramSendVideoTask.jdField_b_of_type_JavaLangString.equals(""))) {
      paramSendVideoTask.a();
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Activity paramActivity, BaseSessionInfo paramBaseSessionInfo, Intent paramIntent)
  {
    a();
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
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("init, mDisablePresend = ");
      paramQQAppInterface.append(this.jdField_b_of_type_Boolean);
      QLog.d("PhotoListPanel", 2, paramQQAppInterface.toString());
    }
    if ((paramBaseSessionInfo instanceof SessionInfo)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = ((SessionInfo)paramBaseSessionInfo);
    }
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    paramQQAppInterface = this.jdField_a_of_type_AndroidAppActivity.getIntent();
    this.jdField_g_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("PhotoConst.MAXUM_SELECTED_NUM", 20);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 9501)
    {
      this.jdField_g_of_type_Int = 5;
      this.jdField_a_of_type_AndroidContentIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 5);
    }
    this.jdField_h_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("PhotoConst.MAXUM_SELECTED_NUM_VIDEO", 1);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter = MediaFileFilter.getFilter(this.jdField_a_of_type_AndroidContentIntent.getIntExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 0));
    this.jdField_m_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", false);
    this.n = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("PhotoConst.IS_SINGLE_MODE", false);
    this.jdField_k_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("PhotoConst.SEND_BUSINESS_TYPE", 1052);
    if (this.jdField_m_of_type_Boolean)
    {
      paramActivity = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter;
      paramActivity.needVideo = false;
      paramActivity.needGif = false;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter.needWebp = true;
    this.jdField_e_of_type_Int = ((int)getResources().getDimension(2131297101));
    this.jdField_f_of_type_Int = ((int)getResources().getDimension(2131297102));
    int i1 = this.jdField_i_of_type_Int;
    int i2 = this.jdField_f_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqDrawableEmptyDrawable = new EmptyDrawable(i1, i2, i2);
    i1 = this.jdField_j_of_type_Int;
    i2 = this.jdField_f_of_type_Int;
    this.jdField_b_of_type_ComTencentMobileqqDrawableEmptyDrawable = new EmptyDrawable(i1, i2, i2);
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
      paramQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$ImageCountChangedListener;
      if (paramQQAppInterface != null) {
        paramQQAppInterface.a(a());
      }
    }
    else if (this.jdField_a_of_type_AndroidContentIntent.hasExtra("PhotoConst.SELECTED_PATHS"))
    {
      paramQQAppInterface = this.jdField_a_of_type_AndroidContentIntent.getStringArrayListExtra("PhotoConst.SELECTED_PATHS");
      if (paramQQAppInterface != null) {
        this.jdField_a_of_type_JavaUtilLinkedList.addAll(paramQQAppInterface);
      }
      paramQQAppInterface = this.jdField_a_of_type_AndroidContentIntent.getIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS");
      if (paramQQAppInterface != null) {
        this.jdField_a_of_type_JavaUtilArrayList.addAll(paramQQAppInterface);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsSendByFile = new SendByFile().a(this.jdField_d_of_type_Int).a(d());
    this.jdField_d_of_type_AndroidViewView = findViewById(2131378985);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131362556));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131370603));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131372295);
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131374724));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131374730));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131374725));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131371919);
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)findViewById(2131377197));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    if (this.jdField_e_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
      this.jdField_a_of_type_AndroidWidgetCheckBox.setContentDescription(HardCodeUtil.a(2131708123));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(HardCodeUtil.a(2131708098));
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    }
    if (this.jdField_f_of_type_Boolean) {
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(4);
    }
    if (this.jdField_g_of_type_Boolean) {
      this.jdField_c_of_type_AndroidWidgetButton.setVisibility(4);
    }
    this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)findViewById(2131367032));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager = new PhotoListPanel.1(this, 1, 0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$PhotoPanelAdapter = new PhotoListPanel.PhotoPanelAdapter(this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$PhotoPanelAdapter);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addOnScrollListener(new PhotoListPanel.2(this));
    this.jdField_a_of_type_AndroidContentSharedPreferences = BaseApplication.getContext().getSharedPreferences("share", 4);
    j();
    c();
    i();
  }
  
  void a(Pair<ArrayList<String>, ArrayList<String>> paramPair, boolean paramBoolean)
  {
    if (((ArrayList)paramPair.first).isEmpty()) {
      localObject1 = paramPair.second;
    } else {
      localObject1 = paramPair.first;
    }
    String str = (String)((ArrayList)localObject1).get(0);
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$PhotoPanelAdapter.a(str);
    if (localObject1 == null) {
      return;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("info = ");
    ((StringBuilder)localObject2).append(localObject1);
    ((StringBuilder)localObject2).append(",sendInBackground = ");
    ((StringBuilder)localObject2).append(paramBoolean);
    Logger.a("TAG", "sendVideo", ((StringBuilder)localObject2).toString());
    localObject2 = new Intent(this.jdField_a_of_type_AndroidAppActivity, SendVideoActivity.class);
    ((Intent)localObject2).putExtra("send_in_background", paramBoolean);
    if (!((ArrayList)paramPair.second).isEmpty())
    {
      paramPair = new ArrayList(1);
      paramPair.add(str);
      ((Intent)localObject2).putStringArrayListExtra("PhotoConst.PHOTO_PATHS_BY_FILE", paramPair);
    }
    else
    {
      ((Intent)localObject2).putExtra("file_send_path", str);
      ((Intent)localObject2).putExtra("file_send_size", ((LocalMediaInfo)localObject1).fileSize);
      ((Intent)localObject2).putExtra("file_send_duration", ((LocalMediaInfo)localObject1).mDuration);
    }
    ((Intent)localObject2).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    ((Intent)localObject2).putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    ((Intent)localObject2).putExtra("PhotoConst.SEND_SIZE_SPEC", this.jdField_c_of_type_Int);
    ((Intent)localObject2).putExtra("file_source", "album_flow");
    paramPair = this.jdField_a_of_type_AndroidAppActivity.getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
    str = this.jdField_a_of_type_AndroidAppActivity.getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
    ((Intent)localObject2).putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", paramPair);
    ((Intent)localObject2).putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", str);
    if (!((LocalMediaInfo)localObject1).isSystemMeidaStore) {
      ReportController.b(null, "CliOper", "", "", "0X8006130", "0X8006130", 0, 0, "", "", "", "");
    }
    if (this.jdField_c_of_type_Int == 2) {
      AlbumUtil.a(0, 1);
    }
    ((Intent)localObject2).putExtra("start_init_activity_after_sended", false);
    if (paramBoolean)
    {
      a((Intent)localObject2);
      return;
    }
    this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject2);
  }
  
  protected void a(Pair<ArrayList<String>, ArrayList<String>> paramPair, boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, String paramString3, boolean paramBoolean3, int paramInt)
  {
    Intent localIntent;
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
      localIntent.putExtra("key_pic_send_source", 8);
      b(localIntent);
    }
    else
    {
      localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, SendPhotoActivity.class);
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
      localIntent.putExtra("key_pic_send_source", 8);
      if (paramBoolean3)
      {
        localIntent.putExtra("key_is_sync_qzone", 1);
        paramPair = this.jdField_d_of_type_JavaLangString;
        if (paramPair == null) {
          paramPair = "";
        }
        localIntent.putExtra("key_qzone_album_id", paramPair);
        localIntent.putExtra("key_qzone_batch_id", PhotoUtils.makeBatchIdQzone());
      }
      if ((paramBoolean1) && (paramInt == 2)) {
        a(1020);
      }
      a(PhotoListPanelUtils.a(paramBoolean1, paramInt, localIntent), localIntent);
    }
    ReportController.b(null, "CliOper", "", "", paramString1, paramString1, 0, 0, paramString2, paramString3, "", "");
  }
  
  void a(String paramString)
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("cancelPresendPic, path = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("PhotoListPanel", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("key_presend_path", paramString);
    ((Bundle)localObject).putInt("key_presend_cancel_type", 1018);
    RichmediaService.c((Bundle)localObject);
  }
  
  void a(String paramString, int paramInt)
  {
    if (QFileAssistantUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      return;
    }
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("presendPic, path = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("PhotoListPanel", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("key_presend_path", paramString);
    ((Bundle)localObject).putInt("entrance", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Int);
    RichmediaService.b((Bundle)localObject);
  }
  
  protected void a(ArrayList<String> paramArrayList, int paramInt)
  {
    ReceiptMsgManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramArrayList, paramInt);
  }
  
  public void a(@NonNull ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sendMedias, paths.size() = ");
      ((StringBuilder)localObject).append(paramArrayList1.size());
      ((StringBuilder)localObject).append(",allowPresend = ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("PhotoListPanel", 2, ((StringBuilder)localObject).toString());
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
        QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2131694910, 0).a();
      }
      b();
      this.jdField_a_of_type_JavaUtilLinkedList.clear();
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      j();
      return;
    }
    if (!c()) {
      return;
    }
    if (a(paramArrayList1, paramArrayList2))
    {
      localObject = getResources().getString(2131718735);
      paramArrayList1 = new PhotoListPanel.9(this, paramArrayList1, paramArrayList2, paramBoolean);
      if (FreeWifiHelper.a(this.jdField_a_of_type_AndroidAppActivity, 4, new PhotoListPanel.10(this, paramArrayList1))) {
        DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 232, null, (String)localObject, new PhotoListPanel.11(this, paramArrayList1), new PhotoListPanel.12(this)).show();
      }
      if (QLog.isColorLevel()) {
        QLog.i("PhotoListPanel", 2, "show shortvideo_mobile_send_confirm dialog");
      }
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$ImageSentListener;
    if (localObject != null) {
      ((PhotoListPanel.ImageSentListener)localObject).a();
    }
    b(paramArrayList1, paramArrayList2, paramBoolean);
  }
  
  protected void a(ArrayList<String> paramArrayList, boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, String paramString3, int paramInt, LocalMediaInfo paramLocalMediaInfo)
  {
    this.jdField_a_of_type_JavaUtilArrayList.remove(paramLocalMediaInfo.position);
    this.jdField_a_of_type_JavaUtilLinkedList.remove(paramLocalMediaInfo.path);
    d();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$ImageCountChangedListener;
    if (localObject != null) {
      ((PhotoListPanel.ImageCountChangedListener)localObject).a(a());
    }
    j();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sendMedias, type = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", paths.size() = ");
      ((StringBuilder)localObject).append(paramArrayList.size());
      ((StringBuilder)localObject).append(" mediaInfo:");
      ((StringBuilder)localObject).append(paramLocalMediaInfo);
      ((StringBuilder)localObject).append(",allowPresend = ");
      ((StringBuilder)localObject).append(paramBoolean1);
      ((StringBuilder)localObject).append(",sendInBackground = ");
      ((StringBuilder)localObject).append(paramBoolean2);
      ((StringBuilder)localObject).append(",reportActionName = ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(",reverse2 = ");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(",reverse3 = ");
      ((StringBuilder)localObject).append(paramString3);
      QLog.d("PhotoListPanel", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$PhotoPanelAdapter.a();
      }
      this.jdField_a_of_type_JavaUtilLinkedList.clear();
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$ImageCountChangedListener;
      if (localObject != null) {
        ((PhotoListPanel.ImageCountChangedListener)localObject).a(null);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$PhotoPanelAdapter.notifyDataSetChanged();
      this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      localObject = this.jdField_a_of_type_AndroidAppActivity.getIntent();
      if (localObject != null)
      {
        ((Intent)localObject).removeExtra("PhotoConst.SELECTED_PATHS");
        ((Intent)localObject).removeExtra("PhotoConst.SELECTED_INDEXS");
        ((Intent)localObject).removeExtra("PhotoConst.editPathMap");
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("resetStatus selectSize:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaUtilLinkedList.size());
      ((StringBuilder)localObject).append(", clear:");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("PhotoListPanel", 2, ((StringBuilder)localObject).toString());
    }
    j();
    setMixedMsgMode(false);
  }
  
  public void a(boolean paramBoolean, Intent paramIntent)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidAppActivity.startActivityForResult(paramIntent, 10005);
      return;
    }
    this.jdField_a_of_type_AndroidAppActivity.startActivity(paramIntent);
  }
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, long paramLong, Pair<ArrayList<String>, ArrayList<String>> paramPair)
  {
    boolean bool;
    if ((SVBusiUtil.b != 0L) && (System.currentTimeMillis() - SVBusiUtil.b < 300000L)) {
      bool = true;
    } else {
      bool = false;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("upload video isConfirmed=");
      ((StringBuilder)localObject).append(bool);
      ((StringBuilder)localObject).append(" allowUploadInXGTime=");
      ((StringBuilder)localObject).append(SVBusiUtil.b);
      QLog.d("PhotoListPanel", 2, ((StringBuilder)localObject).toString());
    }
    if (a(paramLong, bool))
    {
      localObject = ShortVideoUtils.stringForFileSize(this.jdField_a_of_type_AndroidAppActivity, paramLong);
      localObject = String.format(getResources().getString(2131719084), new Object[] { localObject });
      paramString1 = new PhotoListPanel.5(this, paramPair, paramBoolean, paramString1, paramString2, paramString3);
      if (FreeWifiHelper.a(this.jdField_a_of_type_AndroidAppActivity, 4, new PhotoListPanel.6(this, paramString1))) {
        DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 232, null, (String)localObject, new PhotoListPanel.7(this, paramString1), new PhotoListPanel.8(this)).show();
      }
      if (QLog.isColorLevel()) {
        QLog.i("PhotoListPanel", 2, "show shortvideo_mobile_send_confirm dialog");
      }
      return;
    }
    if ((!((ArrayList)paramPair.first).isEmpty()) || (!((ArrayList)paramPair.second).isEmpty())) {
      a(paramPair, paramBoolean);
    }
    ReportController.b(null, "CliOper", "", "", paramString1, paramString1, 0, 0, paramString2, paramString3, "", "");
  }
  
  protected boolean a()
  {
    int i1 = a();
    boolean bool = false;
    if (i1 == 0) {
      return false;
    }
    if (this.p) {
      return false;
    }
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    if (localSessionInfo == null) {
      return false;
    }
    if ((localSessionInfo.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1004)) {
      bool = true;
    }
    return bool;
  }
  
  protected boolean a(long paramLong, boolean paramBoolean)
  {
    return (NetworkUtil.isMobileNetWork(this.jdField_a_of_type_AndroidAppActivity)) && (!paramBoolean) && (paramLong >= 1048576L);
  }
  
  public boolean a(BaseChatPie paramBaseChatPie, List<String> paramList, boolean paramBoolean)
  {
    Pair localPair = new Pair(new ArrayList(), new ArrayList());
    SendByFile localSendByFile = this.jdField_a_of_type_ComTencentMobileqqUtilsSendByFile;
    if (localSendByFile != null)
    {
      boolean bool;
      if (this.jdField_c_of_type_Int == 2) {
        bool = true;
      } else {
        bool = false;
      }
      localPair = localSendByFile.a(paramList, bool, this.jdField_a_of_type_JavaUtilMap, null);
    }
    else
    {
      ((ArrayList)localPair.first).addAll(paramList);
    }
    if ((b() > 0) && (paramBoolean) && (paramBaseChatPie != null) && (!((ArrayList)localPair.first).isEmpty())) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    int i1;
    if (paramBoolean)
    {
      a(paramBaseChatPie, localPair);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) {
        i1 = 1;
      } else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
        i1 = 2;
      } else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {
        i1 = 3;
      } else {
        i1 = 0;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8009BEB", "0X8009BEB", i1, 0, "", "", "", "");
    }
    else
    {
      NewFlowCameraReporter.a(paramList);
      if ((e()) && (a())) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      a((ArrayList)localPair.first, (ArrayList)localPair.second, this.jdField_c_of_type_Boolean);
      if (i1 != 0)
      {
        paramBaseChatPie = new LpReportInfo_pf00064(723, 1, 5);
        LpReportManager.getInstance().reportToPF00064(paramBaseChatPie, false, false);
        RetentionReport.report(8);
      }
    }
    h();
    return paramBoolean;
  }
  
  protected boolean a(LocalMediaInfo paramLocalMediaInfo)
  {
    paramLocalMediaInfo = Environment.getExternalStorageDirectory();
    int i1;
    if ((paramLocalMediaInfo.exists()) && (paramLocalMediaInfo.canWrite())) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if ((Environment.getExternalStorageState().equals("mounted")) && (i1 != 0)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 == 0)
    {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 1, 2131718574, 0).b(getResources().getDimensionPixelSize(2131299168));
      return false;
    }
    if (Utils.b() <= 512000L)
    {
      ShortVideoPreviewActivity.showAlertDialog(this.jdField_a_of_type_AndroidAppActivity, 2131719108);
      return false;
    }
    return true;
  }
  
  public boolean a(String paramString)
  {
    int i1 = b();
    int i2 = c();
    return (!TextUtils.isEmpty(paramString)) && (i1 > 0) && (i2 == 0);
  }
  
  protected boolean a(ArrayList<String> paramArrayList)
  {
    boolean bool2 = false;
    if (paramArrayList == null) {
      return false;
    }
    paramArrayList = paramArrayList.iterator();
    do
    {
      bool1 = bool2;
      if (!paramArrayList.hasNext()) {
        break;
      }
    } while (!FileUtils.fileExistsAndNotEmpty((String)paramArrayList.next()));
    boolean bool1 = true;
    return bool1;
  }
  
  protected boolean a(ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2)
  {
    boolean bool3 = false;
    int i1;
    if ((paramArrayList2 != null) && (!paramArrayList2.isEmpty())) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i2 = 0;
    int i3;
    for (;;)
    {
      i3 = i1;
      if (i2 >= paramArrayList1.size()) {
        break;
      }
      paramArrayList2 = (String)paramArrayList1.get(i2);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$PhotoPanelAdapter.a(paramArrayList2) == 1)
      {
        i3 = 1;
        break;
      }
      i2 += 1;
    }
    boolean bool1;
    if ((SVBusiUtil.b != 0L) && (System.currentTimeMillis() - SVBusiUtil.b < 300000L)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (QLog.isColorLevel())
    {
      paramArrayList1 = new StringBuilder();
      paramArrayList1.append("upload video isConfirmed=");
      paramArrayList1.append(bool1);
      paramArrayList1.append(" allowUploadInXGTime=");
      paramArrayList1.append(SVBusiUtil.b);
      QLog.d("PhotoListPanel", 2, paramArrayList1.toString());
    }
    boolean bool2 = bool3;
    if (NetworkUtil.isMobileNetWork(this.jdField_a_of_type_AndroidAppActivity))
    {
      bool2 = bool3;
      if (!bool1)
      {
        bool2 = bool3;
        if (i3 != 0) {
          bool2 = true;
        }
      }
    }
    return bool2;
  }
  
  protected boolean a(ArrayList<String> paramArrayList, boolean paramBoolean, int paramInt)
  {
    if (!a(paramArrayList))
    {
      if (QLog.isColorLevel()) {
        QLog.e("PhotoListPanel", 2, "PhotoListPanel sendMedias,pics not exits, just return.");
      }
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2131694908, 0).a();
      b();
      this.jdField_a_of_type_JavaUtilLinkedList.clear();
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      paramArrayList = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$ImageCountChangedListener;
      if (paramArrayList != null) {
        paramArrayList.a(null);
      }
      j();
      return false;
    }
    return true;
  }
  
  public boolean a(boolean paramBoolean, BaseChatPie paramBaseChatPie)
  {
    return a(paramBaseChatPie, this.jdField_a_of_type_JavaUtilLinkedList, paramBoolean);
  }
  
  public int b()
  {
    int i1 = 0;
    int i3;
    for (int i2 = 0; i1 < this.jdField_a_of_type_JavaUtilLinkedList.size(); i2 = i3)
    {
      i3 = i2;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$PhotoPanelAdapter.a((String)this.jdField_a_of_type_JavaUtilLinkedList.get(i1)) == 0) {
        i3 = i2 + 1;
      }
      i1 += 1;
    }
    return i2;
  }
  
  public void b()
  {
    Object localObject = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372030);
    int i1 = getResources().getDisplayMetrics().densityDpi;
    if (i1 < 320) {
      ((TextView)localObject).setCompoundDrawables(null, null, null, null);
    }
    if (jdField_b_of_type_Int == 0)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(8);
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("densityDpi = ");
      ((StringBuilder)localObject).append(i1);
      ((StringBuilder)localObject).append("qurey time=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
      QLog.d("PhotoListPanel", 2, ((StringBuilder)localObject).toString());
    }
    ThreadManager.post(new PhotoListPanel.QueryMediaTask(this), 8, null, true);
  }
  
  protected void b(Intent paramIntent)
  {
    ThreadManager.post(new SendPhotoTask((BaseActivity)this.jdField_a_of_type_AndroidAppActivity, paramIntent, null), 8, null, false);
  }
  
  public void b(String paramString)
  {
    ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(this.jdField_a_of_type_AndroidAppActivity, "/base/album/photopreview");
    Object localObject = this.jdField_a_of_type_AndroidContentIntent;
    if ((localObject != null) && (((Intent)localObject).getExtras() != null)) {
      localActivityURIRequest.extra().putAll(this.jdField_a_of_type_AndroidContentIntent.getExtras());
    }
    localActivityURIRequest.extra().putString("ALBUM_ID", "$RecentAlbumId");
    localActivityURIRequest.extra().putInt("PhotoConst.SEND_BUSINESS_TYPE", this.jdField_k_of_type_Int);
    localActivityURIRequest.extra().putString("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    localActivityURIRequest.extra().putInt("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    localActivityURIRequest.extra().putString("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString);
    localActivityURIRequest.extra().putString("uinname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString);
    localObject = this.jdField_a_of_type_AndroidContentIntent;
    if ((localObject == null) || (!((Intent)localObject).hasExtra("showFlashPic")))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (localObject != null) {
        localObject = (HotChatManager)((QQAppInterface)localObject).getManager(QQManagerFactory.HOT_CHAT_MANAGER);
      }
      localActivityURIRequest.extra().putBoolean("showFlashPic", ((IPicFlash)QRoute.api(IPicFlash.class)).showFlashPicOption(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString));
    }
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof SplashActivity))
    {
      localActivityURIRequest.extra().putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
      localActivityURIRequest = AIOUtils.a(localActivityURIRequest, null);
    }
    else
    {
      localActivityURIRequest.extra().putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ChatActivity.class.getName());
    }
    localActivityURIRequest.extra().putString("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localActivityURIRequest.extra().putString("key_activity_code", ChatActivityUtils.a(this.jdField_a_of_type_AndroidAppActivity));
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 9501)
    {
      if ((this.jdField_a_of_type_AndroidAppActivity instanceof SplashActivity))
      {
        localActivityURIRequest.extra().putString("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
        localActivityURIRequest = AIOUtils.a(localActivityURIRequest, null);
      }
      else
      {
        localActivityURIRequest.extra().putString("PhotoConst.DEST_ACTIVITY_CLASS_NAME", ChatActivity.class.getName());
      }
      localActivityURIRequest.extra().putInt(AlbumConstants.h, 80);
      localActivityURIRequest.extra().putString("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      localActivityURIRequest.extra().putBoolean("PhotoConst.SHOULD_SEND_RAW_PHOTO", false);
    }
    else
    {
      localActivityURIRequest.extra().putString("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SendPhotoActivity.class.getName());
      localActivityURIRequest.extra().putString("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      localActivityURIRequest.extra().putBoolean("PhotoConst.SHOULD_SEND_RAW_PHOTO", true);
      localActivityURIRequest.extra().putInt("key_confess_topicid", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_e_of_type_Int);
    }
    localActivityURIRequest.extra().putString("PhotoConst.DEST_VIDEO_ACTIVITY_CLASS_NAME", SendVideoActivity.class.getName());
    localActivityURIRequest.extra().putString("PhotoConst.DEST_VIDEO_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localActivityURIRequest.extra().putInt("PhotoConst.CURRENT_QUALITY_TYPE", this.jdField_c_of_type_Int);
    localActivityURIRequest.extra().putBoolean("PhotoConst.IS_OVERLOAD", false);
    localActivityURIRequest.setFlags(603979776);
    localActivityURIRequest.extra().putBoolean("PhotoConst.IS_SINGLE_MODE", true);
    localActivityURIRequest.extra().putString("PhotoConst.SINGLE_PHOTO_PATH", paramString);
    localActivityURIRequest.extra().putInt("PhotoConst.SEND_BUSINESS_TYPE", this.jdField_k_of_type_Int);
    localActivityURIRequest.extra().putBoolean("PhotoConst.ALLOW_LOCK", false);
    localActivityURIRequest.extra().putInt("enter_from", 1);
    localActivityURIRequest.extra().putString("KEY_PHOTO_LIST_CLASS_NAME", PhotoListCustomizationAIO.jdField_a_of_type_JavaLangString);
    localActivityURIRequest.extra().putString("KEY_ALBUM_LIST_CLASS_NAME", AlbumListCustomizationAIO.jdField_a_of_type_JavaLangString);
    localActivityURIRequest.extra().putString("KEY_PHOTO_PREVIEW_CLASS_NAME", PhotoPreviewCustomizationAIO.jdField_a_of_type_JavaLangString);
    localActivityURIRequest.extra().putBoolean("PHOTO_PREVIEW_NEED_DRAG_KEY", true);
    QRoute.startUri(localActivityURIRequest);
  }
  
  void b(@NonNull ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, boolean paramBoolean)
  {
    boolean bool = b();
    int i6 = this.jdField_c_of_type_Int;
    HashMap localHashMap = new HashMap();
    int i2 = 0;
    int i3 = 0;
    int i5;
    for (int i1 = 0; i2 < paramArrayList1.size(); i1 = i5)
    {
      localObject = (String)paramArrayList1.get(i2);
      int i4;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$PhotoPanelAdapter.a((String)localObject) == 1)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$PhotoPanelAdapter.a((String)localObject);
        i4 = i3;
        i5 = i1;
        if (localObject != null)
        {
          SendVideoInfo localSendVideoInfo = new SendVideoInfo();
          localSendVideoInfo.fileSize = ((LocalMediaInfo)localObject).fileSize;
          localSendVideoInfo.duration = ((LocalMediaInfo)localObject).mDuration;
          localHashMap.put(Integer.valueOf(i2), localSendVideoInfo);
          i5 = i1 + 1;
          i4 = i3;
        }
      }
      else
      {
        i4 = i3 + 1;
        i5 = i1;
      }
      i2 += 1;
      i3 = i4;
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
    ((Intent)localObject).putExtra("key_pic_send_source", 8);
    if (paramArrayList1.size() == 1) {
      ((Intent)localObject).putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramArrayList1);
    }
    if ((paramBoolean) && (i6 == 2)) {
      a(1020);
    }
    a(PhotoListPanelUtils.a(paramBoolean, i6, (Intent)localObject), (Intent)localObject);
    ReportController.b(null, "CliOper", "", "", "0X8009AAF", "0X8009AAF", PhotoUtils.getTypeforReportSpcialDiscuss(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo), 0, String.valueOf(i3), String.valueOf(i1), "", "");
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
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$PhotoPanelAdapter.a((String)this.jdField_a_of_type_JavaUtilLinkedList.get(i1)) == 1) {
        i3 = i2 + 1;
      }
      i1 += 1;
    }
    return i2;
  }
  
  public void c()
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_c_of_type_Boolean = PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_d_of_type_Boolean);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initPresend! mAllowPresend = ");
      ((StringBuilder)localObject).append(this.jdField_c_of_type_Boolean);
      QLog.d("PhotoListPanel", 2, ((StringBuilder)localObject).toString());
    }
    if (this.jdField_c_of_type_Boolean)
    {
      localObject = new BinderWarpper(new PresendPicMgrService(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_e_of_type_Int).asBinder());
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("binder_presendService", (Parcelable)localObject);
      RichmediaService.a(localBundle);
    }
  }
  
  protected boolean c()
  {
    File localFile = Environment.getExternalStorageDirectory();
    int i1;
    if ((localFile.exists()) && (localFile.canWrite())) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if ((Environment.getExternalStorageState().equals("mounted")) && (i1 != 0)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 == 0)
    {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 1, 2131718574, 0).b(getResources().getDimensionPixelSize(2131299168));
      return false;
    }
    if (Utils.b() <= 512000L)
    {
      ShortVideoPreviewActivity.showAlertDialog(this.jdField_a_of_type_AndroidAppActivity, 2131719108);
      return false;
    }
    return true;
  }
  
  public int d()
  {
    LinkedList localLinkedList = this.jdField_a_of_type_JavaUtilLinkedList;
    if (localLinkedList != null) {
      return localLinkedList.size();
    }
    return 0;
  }
  
  public void d()
  {
    Object localObject1 = ((StaggeredGridLayoutManager)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager).findFirstVisibleItemPositions(null);
    Object localObject2 = ((StaggeredGridLayoutManager)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager).findLastVisibleItemPositions(null);
    int i1;
    if (localObject1.length > 0) {
      i1 = localObject1[0];
    } else {
      i1 = 0;
    }
    int i2;
    if (localObject2.length > 0) {
      i2 = localObject2[0];
    } else {
      i2 = 0;
    }
    int i3 = i1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("updateCheckView first=");
      ((StringBuilder)localObject1).append(i1);
      ((StringBuilder)localObject1).append("lastvisible=");
      ((StringBuilder)localObject1).append(i2);
      QLog.d("check", 2, ((StringBuilder)localObject1).toString());
      i3 = i1;
    }
    while (i3 <= i2)
    {
      localObject1 = (PhotoListPanel.PhotoPanelAdapter.RecyclerHolder)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.findViewHolderForAdapterPosition(i3);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$PhotoPanelAdapter.a(i3);
      if (localObject2 != null)
      {
        i1 = this.jdField_a_of_type_JavaUtilLinkedList.indexOf(((LocalMediaInfo)localObject2).path);
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("updateCheckView mIndex=");
          ((StringBuilder)localObject2).append(i1);
          QLog.d("check", 2, ((StringBuilder)localObject2).toString());
        }
        if ((i1 >= 0) && (localObject1 != null))
        {
          ((PhotoListPanel.PhotoPanelAdapter.RecyclerHolder)localObject1).a.setCheckedNumber(i1 + 1);
          ((PhotoListPanel.PhotoPanelAdapter.RecyclerHolder)localObject1).b.setVisibility(0);
        }
        else if (localObject1 == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("check", 2, "updateCheckView view is null?????=");
          }
        }
        else
        {
          ((PhotoListPanel.PhotoPanelAdapter.RecyclerHolder)localObject1).a.setChecked(false);
          ((PhotoListPanel.PhotoPanelAdapter.RecyclerHolder)localObject1).b.setVisibility(4);
        }
      }
      i3 += 1;
    }
  }
  
  public boolean d()
  {
    return (!b()) && (!AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    getParent().requestDisallowInterceptTouchEvent(true);
    SwipeUpAndDragListener localSwipeUpAndDragListener = this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener;
    if (localSwipeUpAndDragListener != null)
    {
      localSwipeUpAndDragListener.onTouch(this, paramMotionEvent);
      super.dispatchTouchEvent(paramMotionEvent);
      this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.c = paramMotionEvent.getX();
      this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.d = paramMotionEvent.getY();
      return true;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected int e()
  {
    return (int)((IPicBus)QRoute.api(IPicBus.class)).getC2CPicSizeLimit();
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanel", 2, "onEditBtnClicked");
    }
    if (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0)
    {
      Intent localIntent = ((IAELaunchEditPic)QRoute.api(IAELaunchEditPic.class)).startEditPic(this.jdField_a_of_type_AndroidAppActivity, (String)this.jdField_a_of_type_JavaUtilLinkedList.get(0), true, true, true, true, true, 2, 140, 5);
      localIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.jdField_c_of_type_Int);
      localIntent.putExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", b());
      localIntent.putExtra("key_enable_edit_title_bar", true);
      this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
      if ((this.jdField_a_of_type_AndroidAppActivity instanceof SplashActivity)) {
        ReportController.b(null, "dc00898", "", "", "0X800A06B", "0X800A06B", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanel", 2, "onAlbumBtnClicked");
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$BottomBtnClickListener;
    if ((localObject != null) && (((PhotoListPanel.BottomBtnClickListener)localObject).a(this))) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {}
    try
    {
      ((ITroopPhotoHandler)((QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_a_of_type_JavaLangString)).getBusinessHandler(BusinessHandlerFactory.TROOP_PHOTO_HANDLER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true);
    }
    catch (AccountNotMatchException localAccountNotMatchException)
    {
      label85:
      HashMap localHashMap;
      break label85;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanel", 2, "onAlbumBtnClicked() getAppRuntime ERROR");
    }
    localObject = null;
    if (!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty()) {
      localObject = new ArrayList(this.jdField_a_of_type_JavaUtilLinkedList);
    }
    if (this.n) {
      this.jdField_a_of_type_AndroidContentIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
    }
    this.jdField_a_of_type_AndroidContentIntent.putExtra("fromPhotoListPanel", true);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("peakconstant.request_code", 10006);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.jdField_c_of_type_Int);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("PhotoConst.is_troop_send_mixed_msg", this.o);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("PhotoConst.DISABLE_UPLOAD_TO_TROOP_ALBUM", this.jdField_i_of_type_Boolean);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("PhotoConst.UPLOAD_CHECKBOX_IS_CHECKED", e());
    this.jdField_a_of_type_AndroidContentIntent.putExtra("PhotoConst.AIO_TO_PHOTO_LIST_NEED_SHOW_UPLOAD_BAR", a());
    localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
    if ((localHashMap != null) && (!localHashMap.isEmpty())) {
      this.jdField_a_of_type_AndroidContentIntent.putExtra("PhotoConst.SEND_NO_PRESEND", true);
    }
    PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (ArrayList)localObject, this.jdField_a_of_type_AndroidContentIntent, this.jdField_a_of_type_JavaUtilHashMap);
    h();
    ReportController.b(null, "CliOper", "", "", "0X8005E05", "0X8005E05", 0, 0, "", "", "", "");
    l();
  }
  
  protected void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanel", 2, "onSendBtnClicked");
    }
    PhotoListPanel.BottomBtnClickListener localBottomBtnClickListener = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$BottomBtnClickListener;
    if ((localBottomBtnClickListener != null) && (localBottomBtnClickListener.b(this))) {
      return;
    }
    a(false, null);
  }
  
  public void h()
  {
    a(true);
  }
  
  public void i()
  {
    if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null))
    {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setBackgroundColor(-16777216);
      this.jdField_c_of_type_AndroidWidgetButton.setTextColor(-1509949441);
    }
  }
  
  public void j()
  {
    Activity localActivity = this.jdField_a_of_type_AndroidAppActivity;
    if (localActivity != null) {
      localActivity.runOnUiThread(new PhotoListPanel.13(this));
    }
  }
  
  void k()
  {
    if (this.jdField_e_of_type_Boolean) {
      return;
    }
    int i1 = this.jdField_c_of_type_Int;
    if (i1 != 0)
    {
      if (i1 != 2) {
        return;
      }
      QQAlbumUtils.a(this.jdField_b_of_type_AndroidWidgetTextView, this.jdField_a_of_type_JavaUtilLinkedList, this.jdField_a_of_type_JavaUtilMap, true, this.jdField_a_of_type_AndroidAppActivity, null, null);
      this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
  }
  
  void l()
  {
    View localView = this.jdField_c_of_type_AndroidViewView;
    if ((localView != null) && (localView.getVisibility() == 0))
    {
      BabyQHandler.a(this.jdField_c_of_type_AndroidViewView);
      this.jdField_c_of_type_AndroidViewView = null;
      this.jdField_l_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$PhotoPanelAdapter.notifyDataSetChanged();
      BabyQHandler.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_AndroidViewView);
    }
  }
  
  public void m()
  {
    SwipeUpAndDragListener localSwipeUpAndDragListener = this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener;
    if (localSwipeUpAndDragListener != null) {
      localSwipeUpAndDragListener.b();
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int i1 = paramCompoundButton.getId();
    if (i1 != 2131367824)
    {
      if (i1 == 2131374724) {
        if (paramBoolean)
        {
          SendByFile localSendByFile = this.jdField_a_of_type_ComTencentMobileqqUtilsSendByFile;
          if (localSendByFile != null) {
            localSendByFile.a(getContext(), this.jdField_a_of_type_JavaUtilLinkedList, paramBoolean, this.jdField_a_of_type_JavaUtilMap, null);
          }
          this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
          this.jdField_c_of_type_Int = 2;
          QQAlbumUtils.a(this.jdField_b_of_type_AndroidWidgetTextView, this.jdField_a_of_type_JavaUtilLinkedList, this.jdField_a_of_type_JavaUtilMap, true, this.jdField_a_of_type_AndroidAppActivity, null, null);
          this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(HardCodeUtil.a(2131708121));
          ReportController.b(null, "CliOper", "", "", "0X8005E07", "0X8005E07", 0, 0, "", "", "", "");
        }
        else
        {
          this.jdField_c_of_type_Int = 0;
          this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
          this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(HardCodeUtil.a(2131708075));
        }
      }
    }
    else
    {
      this.q = paramBoolean;
      j();
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
  
  public void onClick(View paramView)
  {
    int i1;
    boolean bool;
    Object localObject;
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131380267: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      bool = a();
      localObject = QZoneHelper.UserInfo.getInstance();
      ((QZoneHelper.UserInfo)localObject).qzone_uin = this.jdField_a_of_type_JavaLangString;
      ((QZoneHelper.UserInfo)localObject).nickname = this.jdField_b_of_type_JavaLangString;
      if (i1 != 0)
      {
        QZoneHelper.forwardToQunAlbumListSelect(this.jdField_a_of_type_AndroidAppActivity, (QZoneHelper.UserInfo)localObject, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString, 10008);
      }
      else if (bool)
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("key_personal_album_enter_model", 0);
        localBundle.putString("key_title", this.jdField_a_of_type_AndroidAppActivity.getString(2131717659));
        localBundle.putBoolean("key_personal_album_is_select_video", false);
        if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))
        {
          localBundle.putString("key_default_album_id", this.jdField_d_of_type_JavaLangString);
          localBundle.putBoolean("key_from_upload", true);
        }
        QZoneHelper.forwardToPersonalAlbumSelect(this.jdField_a_of_type_AndroidAppActivity, (QZoneHelper.UserInfo)localObject, localBundle, 10009);
        localObject = new LpReportInfo_pf00064(723, 1, 4);
        LpReportManager.getInstance().reportToPF00064((LpReportInfo_pf00064)localObject, false, false);
      }
      break;
    case 2131377197: 
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ReportController.b(null, "dc00898", "", "", "0X800A7B0", "0X800A7B0", ((Integer)((Iterator)localObject).next()).intValue() + 1, 0, "2", "", "", "");
      }
      i1 = PhotoUtils.getTypeforReport2(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      int i2 = this.jdField_a_of_type_JavaUtilArrayList.size();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(i1);
      ReportController.b(null, "dc00898", "", "", "0X800A912", "0X800A912", i2, 0, ((StringBuilder)localObject).toString(), "", "", "");
      g();
      break;
    case 2131374725: 
    case 2131374730: 
      if (!this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
        this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
      } else {
        this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      }
      break;
    case 2131370603: 
      e();
      break;
    case 2131367824: 
      n();
      bool = e();
      if (a())
      {
        if (bool) {
          i1 = 2;
        } else {
          i1 = 3;
        }
        localObject = new LpReportInfo_pf00064(723, 1, i1);
        LpReportManager.getInstance().reportToPF00064((LpReportInfo_pf00064)localObject, false, false);
      }
      else if (bool)
      {
        localObject = new QZoneClickReport.ReportInfo();
        ((QZoneClickReport.ReportInfo)localObject).toUin = Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue();
        ((QZoneClickReport.ReportInfo)localObject).actionType = "459";
        ((QZoneClickReport.ReportInfo)localObject).subactionType = "3";
        QZoneClickReport.report(this.jdField_a_of_type_JavaLangString, (QZoneClickReport.ReportInfo)localObject, true);
      }
      else
      {
        localObject = new QZoneClickReport.ReportInfo();
        ((QZoneClickReport.ReportInfo)localObject).toUin = Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue();
        ((QZoneClickReport.ReportInfo)localObject).actionType = "459";
        ((QZoneClickReport.ReportInfo)localObject).subactionType = "2";
        QZoneClickReport.report(this.jdField_a_of_type_JavaLangString, (QZoneClickReport.ReportInfo)localObject, true);
      }
      break;
    case 2131362556: 
      f();
    }
    BabyQHandler.a(this.jdField_b_of_type_AndroidViewView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener;
    if (localObject != null)
    {
      localObject = (PhotoListPanel.PhotoPanelAdapter.RecyclerHolder)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.findViewHolderForAdapterPosition(((SwipeUpAndDragListener)localObject).jdField_e_of_type_Int);
      boolean bool2 = false;
      if (localObject == null) {
        return false;
      }
      Math.abs(this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.c - paramMotionEvent.getX());
      Math.abs(this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.d - paramMotionEvent.getY());
      boolean bool1 = bool2;
      if (paramMotionEvent.getAction() != 0)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.jdField_a_of_type_Boolean) {
          bool1 = true;
        }
      }
      return bool1;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
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
    }
    else
    {
      localObject = this.jdField_a_of_type_AndroidContentIntent;
      boolean bool;
      if ((!paramBoolean) && (this.jdField_a_of_type_JavaLangBoolean.booleanValue())) {
        bool = true;
      } else {
        bool = false;
      }
      ((Intent)localObject).putExtra("showFlashPic", bool);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter;
    if (localObject == null) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_b_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter = ((MediaFileFilter)localObject);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter = MediaFileFilter.getFilter(1);
      return;
    }
    localObject = this.jdField_b_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter;
    if (localObject != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter = ((MediaFileFilter)localObject);
      this.jdField_b_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter = null;
    }
  }
  
  public void setImageSentListener(PhotoListPanel.ImageSentListener paramImageSentListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$ImageSentListener = paramImageSentListener;
  }
  
  public void setLastRequestCode(int paramInt)
  {
    this.jdField_m_of_type_Int = paramInt;
  }
  
  public void setMixedMsgMode(boolean paramBoolean)
  {
    this.o = paramBoolean;
  }
  
  public void setOnSwipeUpAndDragListener(SwipeUpAndDragListener paramSwipeUpAndDragListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener = paramSwipeUpAndDragListener;
  }
  
  public void setReceiptMode(boolean paramBoolean, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidContentIntent.putExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", paramBoolean);
    int i1;
    if (this.jdField_i_of_type_Boolean != paramBoolean) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    setImageOnly(paramBoolean);
    this.jdField_i_of_type_Boolean = paramBoolean;
    if (paramBoolean)
    {
      this.jdField_g_of_type_Int = Math.min(ReceiptUtil.b(paramQQAppInterface), this.jdField_g_of_type_Int);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setOnTouchListener(null);
    }
    else
    {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener);
      this.jdField_g_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("PhotoConst.MAXUM_SELECTED_NUM", 20);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 9501) {
        this.jdField_g_of_type_Int = 5;
      }
    }
    if (i1 != 0) {
      h();
    }
  }
  
  public void setSelectLimitListener(PhotoListPanel.SelectLimitListener paramSelectLimitListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SelectLimitListener = paramSelectLimitListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.PhotoListPanel
 * JD-Core Version:    0.7.0.1
 */