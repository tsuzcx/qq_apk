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
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
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
  boolean A;
  boolean B;
  boolean C;
  boolean D;
  boolean E = false;
  public RecyclerView F;
  RecyclerView.LayoutManager G;
  public boolean H = true;
  Button I;
  Button J;
  CheckBox K;
  TextView L;
  TextView M;
  View N;
  View O;
  View P;
  Button Q;
  View R;
  PhotoListPanel.BottomBtnClickListener S;
  PhotoListPanel.ImageSentListener T;
  PhotoListPanel.SelectLimitListener U;
  PhotoListPanel.ImageCountChangedListener V;
  boolean W = false;
  boolean Z = false;
  Handler aa = new Handler(Looper.getMainLooper());
  int ab = 278921216;
  int ac = -16777216;
  EmptyDrawable ad;
  EmptyDrawable ae;
  MediaFileFilter af;
  MediaFileFilter ag;
  boolean ah = false;
  boolean ai = false;
  int aj;
  boolean ak = false;
  Boolean al;
  boolean am;
  boolean an;
  public int ao = 0;
  SwipeUpAndDragListener ap;
  SharedPreferences aq;
  private int ar = -1;
  private SendByFile as;
  private String at;
  private String au = HardCodeUtil.a(2131905887);
  public int c = 0;
  public LinkedList<String> d = new LinkedList();
  public volatile boolean e;
  public PhotoListPanel.PhotoPanelAdapter f;
  public Map<String, LocalMediaInfo> g;
  public long h = 0L;
  public QQAppInterface i;
  Intent j;
  Activity k;
  public SessionInfo l;
  String m;
  String n;
  String o;
  int p = getSizeLimit();
  int q;
  int r;
  int s;
  int t;
  ArrayList<Integer> u = new ArrayList();
  ArrayList<String> v;
  HashMap<LocalMediaInfo, LocalMediaInfo> w = new HashMap();
  boolean x;
  boolean y;
  boolean z;
  
  public PhotoListPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void a(BaseChatPie paramBaseChatPie, Pair<ArrayList<String>, ArrayList<String>> paramPair)
  {
    MessageForReplyText.SourceMsgInfo localSourceMsgInfo = ((ReplyHelper)paramBaseChatPie.q(119)).a();
    boolean bool3 = true;
    boolean bool1;
    if ((localSourceMsgInfo != null) && (TextUtils.isEmpty(localSourceMsgInfo.mAnonymousNickName)))
    {
      paramBaseChatPie.a(new ChatActivityFacade.SendMsgParams());
      if (((HotChatManager)this.i.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).c(this.l.b) != null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      localObject1 = this.i;
      i1 = this.l.a;
      localObject2 = this.l.b;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(localSourceMsgInfo.mSourceMsgSenderUin);
      ((StringBuilder)localObject3).append("");
      localObject1 = ContactUtils.a((BaseQQAppInterface)localObject1, i1, (String)localObject2, ((StringBuilder)localObject3).toString());
      localObject2 = this.i;
      localObject3 = paramBaseChatPie.e;
      localObject4 = this.l.b;
      localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append(localSourceMsgInfo.mSourceMsgSenderUin);
      ((StringBuilder)localObject5).append("");
      localObject5 = ((StringBuilder)localObject5).toString();
      localObject6 = paramBaseChatPie.Y;
      boolean bool2;
      if (this.l.a == 1) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      localObject1 = AtTroopMemberSpan.a((AppRuntime)localObject2, (Context)localObject3, (String)localObject4, (String)localObject5, (String)localObject1, bool1, (EditText)localObject6, bool2, true);
      if ((localObject1 != null) && (((SpannableString)localObject1).length() != 0)) {
        paramBaseChatPie.Y.getEditableText().insert(0, (CharSequence)localObject1);
      }
      localObject1 = ReplyMsgUtils.c(this.i, this.l, localSourceMsgInfo);
      localSourceMsgInfo.mType = 0;
      if (((localObject1 instanceof MessageForPic)) || ((localObject1 instanceof MessageForMixedMsg))) {
        localSourceMsgInfo.oriMsgType = 1;
      }
    }
    Object localObject1 = new ArrayList();
    Object localObject2 = AtTroopMemberSpan.a(paramBaseChatPie.Y.getEditableText(), (ArrayList)localObject1);
    Object localObject3 = (MixedMsgManager)this.i.getManager(QQManagerFactory.MIXED_MSG_MANAGER);
    Object localObject4 = this.i;
    Object localObject5 = this.l.b;
    int i1 = this.l.a;
    Object localObject6 = (ArrayList)paramPair.first;
    if (this.c == 2) {
      bool1 = bool3;
    } else {
      bool1 = false;
    }
    ((MixedMsgManager)localObject3).a((QQAppInterface)localObject4, (String)localObject5, i1, (ArrayList)localObject6, bool1, (String)localObject2, (ArrayList)localObject1, localSourceMsgInfo);
    paramBaseChatPie.bh();
    if (!((ArrayList)paramPair.second).isEmpty()) {
      a(new ArrayList(), (ArrayList)paramPair.second, this.y);
    }
  }
  
  private void t()
  {
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setElementClickParams(this.I, "em_photo_panel_album", null);
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setElementClickParams(this.L, "em_photo_panel_original_photo", null);
  }
  
  private boolean u()
  {
    return false;
  }
  
  @TargetApi(9)
  private void v()
  {
    boolean bool = u();
    Object localObject;
    if (b())
    {
      localObject = "qzone_will_upload_to_personal_album";
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("qzone_will_upload_to_qun_album");
      ((StringBuilder)localObject).append(this.l.b);
      localObject = ((StringBuilder)localObject).toString();
    }
    if (Build.VERSION.SDK_INT >= 9)
    {
      this.aq.edit().putBoolean((String)localObject, bool).apply();
      return;
    }
    ThreadManager.postImmediately(new PhotoListPanel.4(this, (String)localObject, bool), null, false);
  }
  
  public void a()
  {
    SwipeUpAndDragListener.a = SwipeUpAndDragListener.c();
  }
  
  public void a(int paramInt)
  {
    if (this.x) {
      return;
    }
    if (!this.y) {
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
      d();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanel", 2, "onActivityResult, PeakConstants.REQUEST_PHOTOPREVIEW_RETURE");
    }
    ReplacePhotoDataUtil.a(getContext(), paramIntent, true, this.w);
    Object localObject1 = this.d.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (String)((Iterator)localObject1).next();
      localObject2 = this.f.b((String)localObject2);
      if (localObject2 != null) {
        ((LocalMediaInfo)localObject2).mChecked = false;
      }
    }
    this.c = paramIntent.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
    paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.SELECTED_PATHS");
    this.d.clear();
    this.u.clear();
    if (paramIntent != null)
    {
      paramIntent = paramIntent.iterator();
      while (paramIntent.hasNext())
      {
        localObject1 = (String)paramIntent.next();
        this.d.add(localObject1);
        localObject1 = this.f.b((String)localObject1);
        if (localObject1 != null)
        {
          if (!((LocalMediaInfo)localObject1).mChecked) {
            ((LocalMediaInfo)localObject1).mChecked = true;
          }
          this.u.add(((LocalMediaInfo)localObject1).position);
        }
      }
    }
    paramIntent = this.V;
    if (paramIntent != null) {
      paramIntent.a(getSelectedPhotosIntent());
    }
    this.f.notifyDataSetChanged();
    n();
  }
  
  public void a(int paramInt, ArrayList<String> paramArrayList, boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, String paramString3, boolean paramBoolean3)
  {
    int i1 = this.f.getItemViewType(paramInt);
    a(paramArrayList, paramBoolean1, paramBoolean2, paramString1, paramString2, paramString3, i1, this.f.a(paramInt));
    boolean bool2 = i();
    Pair localPair = new Pair(new ArrayList(), new ArrayList());
    SendByFile localSendByFile = this.as;
    if (localSendByFile != null)
    {
      boolean bool1;
      if (this.c == 2) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      localPair = localSendByFile.a(paramArrayList, bool1, this.g, null);
    }
    else
    {
      ((ArrayList)localPair.first).addAll(paramArrayList);
    }
    if (i1 == 0)
    {
      if (!a(paramArrayList, bool2, this.c)) {
        return;
      }
      if (bool2)
      {
        a((ArrayList)localPair.first, this.c);
        return;
      }
      a(localPair, paramBoolean1, paramBoolean2, paramString1, paramString2, paramString3, paramBoolean3, this.c);
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
      long l1 = c(paramArrayList);
      if (!a(this.f.b(paramArrayList))) {
        return;
      }
      a(paramBoolean2, paramString1, paramString2, paramString3, l1, localPair);
    }
  }
  
  protected void a(Intent paramIntent)
  {
    ThreadManager.executeOnSubThread(new PhotoListPanel.3(this, new SendVideoTask((BaseActivity)this.k, paramIntent)));
  }
  
  public void a(View paramView, int paramInt)
  {
    if (this.f == null) {
      return;
    }
    ReportController.b(null, "dc00898", "", "", "0X800A913", "0X800A913", PhotoUtils.getTypeforReport2(this.l), 0, "", "", "", "");
    int i1 = this.f.getItemViewType(paramInt);
    if (this.ai)
    {
      b(this.f.a(paramInt).path);
      return;
    }
    Object localObject2 = new ArrayList(this.d);
    String str = "0";
    if ((i1 == 0) || (i1 == 1))
    {
      Object localObject1 = this.f.a(paramInt).path;
      if ((TextUtils.isEmpty((CharSequence)localObject1)) || (!FileUtils.fileExistsAndNotEmpty((String)localObject1))) {
        break label1394;
      }
      localObject1 = new ActivityURIRequest(this.k, "/base/album/photopreview");
      ((ActivityURIRequest)localObject1).extra().putString("ALBUM_ID", "$RecentAlbumId");
      ((ActivityURIRequest)localObject1).extra().putInt("PhotoConst.SEND_BUSINESS_TYPE", this.aj);
      ((ActivityURIRequest)localObject1).extra().putString("uin", this.l.b);
      ((ActivityURIRequest)localObject1).extra().putString("PhotoConst.MY_UIN", this.m);
      ((ActivityURIRequest)localObject1).extra().putInt("uintype", this.l.a);
      ((ActivityURIRequest)localObject1).extra().putString("troop_uin", this.l.c);
      ((ActivityURIRequest)localObject1).extra().putString("uinname", this.l.e);
      ((ActivityURIRequest)localObject1).extra().putInt("entrance", this.l.s);
      ((ActivityURIRequest)localObject1).extra().putBoolean("PhotoConst.is_troop_send_mixed_msg", this.ak);
      ((ActivityURIRequest)localObject1).extra().putBoolean("PhotoConst.SHOW_ALBUM", true);
      ((ActivityURIRequest)localObject1).extra().putStringArrayList("PhotoConst.PHOTO_PATHS", this.v);
      ((ActivityURIRequest)localObject1).extra().putInt("PhotoConst.CURRENT_SELECTED_INDEX", this.f.a(paramInt).position.intValue());
      ((ActivityURIRequest)localObject1).extra().putStringArrayList("PhotoConst.SELECTED_PATHS", (ArrayList)localObject2);
      ((ActivityURIRequest)localObject1).extra().putIntegerArrayList("PhotoConst.SELECTED_INDEXS", this.u);
      ((ActivityURIRequest)localObject1).extra().putSerializable("PhotoConst.ALL_MEDIA_PATHS", (Serializable)this.g);
      ((ActivityURIRequest)localObject1).extra().putSerializable("PhotoConst.editPathMap", ReplacePhotoDataUtil.b(this.w));
      ((ActivityURIRequest)localObject1).extra().putBoolean("KEY_IS_ANONYMOUS", AnonymousChatHelper.a().a(this.l.b));
      if (this.j != null)
      {
        ((ActivityURIRequest)localObject1).extra().putBoolean("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", i());
        ((ActivityURIRequest)localObject1).extra().putParcelable("session_info", this.l);
      }
      localObject2 = this.k;
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
      ((ActivityURIRequest)localObject1).extra().putString("key_activity_code", ChatActivityUtils.a(this.k));
      if (this.l.a == 9501)
      {
        if ((this.k instanceof SplashActivity))
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
      else if ((this.l.a != 6000) && (this.l.a != 6003))
      {
        ((ActivityURIRequest)localObject1).extra().putString("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SendPhotoActivity.class.getName());
        ((ActivityURIRequest)localObject1).extra().putString("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        ((ActivityURIRequest)localObject1).extra().putBoolean("PhotoConst.SHOULD_SEND_RAW_PHOTO", true);
        ((ActivityURIRequest)localObject1).extra().putInt("key_confess_topicid", this.l.v);
      }
      else
      {
        ((ActivityURIRequest)localObject1).extra().putInt(AlbumConstants.h, 55);
        ((ActivityURIRequest)localObject1).extra().putBoolean("PhotoConst.SHOULD_SEND_RAW_PHOTO", false);
        ((ActivityURIRequest)localObject1).extra().putBoolean("PhotoConst.IS_SEND_FILESIZE_LIMIT", true);
      }
      ((ActivityURIRequest)localObject1).extra().putInt("PhotoConst.CURRENT_QUALITY_TYPE", this.c);
      ((ActivityURIRequest)localObject1).extra().putBoolean("keep_selected_status_after_finish", true);
      ((ActivityURIRequest)localObject1).extra().putBoolean("PhotoConst.IS_OVERLOAD", false);
      ((ActivityURIRequest)localObject1).extra().putInt("PhotoConst.MAXUM_SELECTED_NUM", this.s);
      ((ActivityURIRequest)localObject1).extra().putBoolean("custom_photopreview_sendbtn_report", true);
      ((ActivityURIRequest)localObject1).extra().putString("custom_photopreview_sendbtn_reportActionName", "0X8005E0A");
      ((ActivityURIRequest)localObject1).extra().putString("custom_photopreview_sendbtn_reportReverse2", "0");
      ((ActivityURIRequest)localObject1).extra().putString("custom_photopreview_editbtn_reportActionName", "0X8005E0B");
      ((ActivityURIRequest)localObject1).extra().putString("custom_photopreview_rawcheckbox_reportActionName", "0X8005E0C");
      ((ActivityURIRequest)localObject1).extra().putParcelable("KEY_THUMBNAL_BOUND", AnimationUtils.a(paramView.findViewById(2131436048)));
      ((ActivityURIRequest)localObject1).extra().putParcelable("session_info", this.l);
      paramView = this.j;
      if ((paramView == null) || (!paramView.hasExtra("showFlashPic")))
      {
        paramView = this.i;
        if (paramView != null) {
          paramView = (HotChatManager)paramView.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
        }
        ((ActivityURIRequest)localObject1).extra().putBoolean("showFlashPic", ((IPicFlash)QRoute.api(IPicFlash.class)).showFlashPicOption(this.l.a, this.l.c));
      }
      ((ActivityURIRequest)localObject1).extra().putBoolean("PhotoConst.IS_JUMPTO_TROOP_ALBUM", u());
      ((ActivityURIRequest)localObject1).extra().putInt("enter_from", 1);
      ((ActivityURIRequest)localObject1).extra().putString("KEY_PHOTO_LIST_CLASS_NAME", PhotoListCustomizationAIO.a);
      ((ActivityURIRequest)localObject1).extra().putString("KEY_ALBUM_LIST_CLASS_NAME", AlbumListCustomizationAIO.j);
      ((ActivityURIRequest)localObject1).extra().putString("KEY_PHOTO_PREVIEW_CLASS_NAME", PhotoPreviewCustomizationAIO.a);
      ((ActivityURIRequest)localObject1).extra().putBoolean("PHOTO_PREVIEW_NEED_DRAG_KEY", true);
      if (QFileAssistantUtils.a(this.l.b))
      {
        ((ActivityURIRequest)localObject1).extra().putInt(AlbumConstants.h, 2);
        ((ActivityURIRequest)localObject1).extra().putInt("enter_from", 51);
        ((ActivityURIRequest)localObject1).extra().putString("KEY_PHOTO_LIST_CLASS_NAME", PhotoListCustomizationFileAssistant.a);
        ((ActivityURIRequest)localObject1).extra().putString("KEY_PHOTO_PREVIEW_CLASS_NAME", PhotoPreviewCustomizationFileAssistant.a);
      }
      ((ActivityURIRequest)localObject1).setFlags(603979776);
      ((ActivityURIRequest)localObject1).setRequestCode(10004);
      QRoute.startUri((URIRequest)localObject1);
      BabyQHandler.a(this.O);
      if ((this.k instanceof SplashActivity))
      {
        paramView = new StringBuilder();
        paramView.append(this.d.size());
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
    label1394:
    if (QLog.isColorLevel()) {
      QLog.e("PhotoListPanel", 2, "PhotoListPanel onItemClick,clickPath not exits, just return.");
    }
    QQToast.makeText(this.k, 2131892634, 0).show();
    c();
    this.d.clear();
    this.u.clear();
    n();
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    if (this.ar != 10006) {
      return;
    }
    this.ar = -1;
    Intent localIntent = this.k.getIntent();
    if (localIntent.hasExtra("PhotoConst.send_photo_activity_result")) {
      localIntent.removeExtra("PhotoConst.send_photo_activity_result");
    } else {
      a(1019);
    }
    l();
    paramBaseChatPie.aw();
  }
  
  protected void a(SendVideoTask paramSendVideoTask)
  {
    paramSendVideoTask.a();
    if ((paramSendVideoTask.c != null) && (!paramSendVideoTask.c.equals(""))) {
      paramSendVideoTask.b();
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Activity paramActivity, BaseSessionInfo paramBaseSessionInfo, Intent paramIntent)
  {
    a();
    this.i = paramQQAppInterface;
    this.j = paramIntent;
    if (this.j == null) {
      this.j = new Intent();
    }
    if (this.j.hasExtra("showFlashPic")) {
      this.al = Boolean.valueOf(this.j.getBooleanExtra("showFlashPic", false));
    }
    this.x = this.j.getBooleanExtra("key_disable_presend", false);
    this.A = this.j.getBooleanExtra("key_disable_quality_cb", false);
    this.B = this.j.getBooleanExtra("key_disable_edit_btn", false);
    this.C = this.j.getBooleanExtra("key_disable_send_btn", false);
    this.z = this.j.getBooleanExtra("key_new_lbs_client", false);
    this.D = this.j.getBooleanExtra("key_allow_mix_select", true);
    this.m = this.j.getStringExtra("key_my_uin");
    this.n = this.j.getStringExtra("key_my_nick");
    this.o = this.j.getStringExtra("key_my_head_dir");
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("init, mDisablePresend = ");
      paramQQAppInterface.append(this.x);
      QLog.d("PhotoListPanel", 2, paramQQAppInterface.toString());
    }
    if ((paramBaseSessionInfo instanceof SessionInfo)) {
      this.l = ((SessionInfo)paramBaseSessionInfo);
    }
    this.k = paramActivity;
    paramQQAppInterface = this.k.getIntent();
    this.s = this.j.getIntExtra("PhotoConst.MAXUM_SELECTED_NUM", 20);
    if (this.l.a == 9501)
    {
      this.s = 5;
      this.j.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 5);
    }
    this.t = this.j.getIntExtra("PhotoConst.MAXUM_SELECTED_NUM_VIDEO", 1);
    this.af = MediaFileFilter.getFilter(this.j.getIntExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 0));
    this.ah = this.j.getBooleanExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", false);
    this.ai = this.j.getBooleanExtra("PhotoConst.IS_SINGLE_MODE", false);
    this.aj = this.j.getIntExtra("PhotoConst.SEND_BUSINESS_TYPE", 1052);
    if (this.ah)
    {
      paramActivity = this.af;
      paramActivity.needVideo = false;
      paramActivity.needGif = false;
    }
    this.af.needWebp = true;
    this.q = ((int)getResources().getDimension(2131297482));
    this.r = ((int)getResources().getDimension(2131297483));
    int i1 = this.ab;
    int i2 = this.r;
    this.ad = new EmptyDrawable(i1, i2, i2);
    i1 = this.ac;
    i2 = this.r;
    this.ae = new EmptyDrawable(i1, i2, i2);
    if (paramQQAppInterface.hasExtra("PhotoConst.SELECTED_PATHS"))
    {
      paramActivity = paramQQAppInterface.getStringArrayListExtra("PhotoConst.SELECTED_PATHS");
      if (paramActivity != null) {
        this.d.addAll(paramActivity);
      }
      paramActivity = paramQQAppInterface.getIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS");
      if (paramActivity != null) {
        this.u.addAll(paramActivity);
      }
      paramQQAppInterface.removeExtra("PhotoConst.SELECTED_PATHS");
      paramQQAppInterface.removeExtra("PhotoConst.SELECTED_INDEXS");
      paramQQAppInterface = this.V;
      if (paramQQAppInterface != null) {
        paramQQAppInterface.a(getSelectedPhotosIntent());
      }
    }
    else if (this.j.hasExtra("PhotoConst.SELECTED_PATHS"))
    {
      paramQQAppInterface = this.j.getStringArrayListExtra("PhotoConst.SELECTED_PATHS");
      if (paramQQAppInterface != null) {
        this.d.addAll(paramQQAppInterface);
      }
      paramQQAppInterface = this.j.getIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS");
      if (paramQQAppInterface != null) {
        this.u.addAll(paramQQAppInterface);
      }
    }
    this.as = new SendByFile().a(this.p).a(r());
    this.R = findViewById(2131447695);
    this.I = ((Button)findViewById(2131428167));
    this.J = ((Button)findViewById(2131437877));
    this.O = findViewById(2131439806);
    this.K = ((CheckBox)findViewById(2131442912));
    this.L = ((TextView)findViewById(2131442918));
    this.M = ((TextView)findViewById(2131442913));
    this.N = findViewById(2131439364);
    this.Q = ((Button)findViewById(2131445580));
    this.I.setOnClickListener(this);
    this.J.setOnClickListener(this);
    if (this.A)
    {
      this.K.setVisibility(4);
      this.L.setVisibility(4);
      this.M.setVisibility(4);
    }
    else
    {
      this.K.setOnCheckedChangeListener(this);
      this.K.setContentDescription(HardCodeUtil.a(2131905920));
      this.L.setOnClickListener(this);
      this.L.setContentDescription(HardCodeUtil.a(2131905896));
      this.M.setOnClickListener(this);
    }
    if (this.B) {
      this.J.setVisibility(4);
    }
    if (this.C) {
      this.Q.setVisibility(4);
    }
    this.Q.setOnClickListener(this);
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setElementClickParams(this.Q, "em_aio_image", null);
    this.F = ((RecyclerView)findViewById(2131433480));
    this.G = new PhotoListPanel.1(this, 1, 0);
    this.f = new PhotoListPanel.PhotoPanelAdapter(this);
    this.F.setLayoutManager(this.G);
    this.F.setAdapter(this.f);
    this.F.addOnScrollListener(new PhotoListPanel.2(this));
    this.aq = BaseApplication.getContext().getSharedPreferences("share", 4);
    n();
    d();
    m();
    t();
  }
  
  void a(Pair<ArrayList<String>, ArrayList<String>> paramPair, boolean paramBoolean)
  {
    if (((ArrayList)paramPair.first).isEmpty()) {
      localObject1 = paramPair.second;
    } else {
      localObject1 = paramPair.first;
    }
    String str = (String)((ArrayList)localObject1).get(0);
    Object localObject1 = this.f.b(str);
    if (localObject1 == null) {
      return;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("info = ");
    ((StringBuilder)localObject2).append(localObject1);
    ((StringBuilder)localObject2).append(",sendInBackground = ");
    ((StringBuilder)localObject2).append(paramBoolean);
    Logger.a("TAG", "sendVideo", ((StringBuilder)localObject2).toString());
    localObject2 = new Intent(this.k, SendVideoActivity.class);
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
    ((Intent)localObject2).putExtra("uin", this.l.b);
    ((Intent)localObject2).putExtra("uintype", this.l.a);
    ((Intent)localObject2).putExtra("PhotoConst.SEND_SIZE_SPEC", this.c);
    ((Intent)localObject2).putExtra("file_source", "album_flow");
    paramPair = this.k.getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
    str = this.k.getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
    ((Intent)localObject2).putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", paramPair);
    ((Intent)localObject2).putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", str);
    if (!((LocalMediaInfo)localObject1).isSystemMeidaStore) {
      ReportController.b(null, "CliOper", "", "", "0X8006130", "0X8006130", 0, 0, "", "", "", "");
    }
    if (this.c == 2) {
      AlbumUtil.a(0, 1);
    }
    ((Intent)localObject2).putExtra("start_init_activity_after_sended", false);
    if (paramBoolean)
    {
      a((Intent)localObject2);
      return;
    }
    this.k.startActivity((Intent)localObject2);
  }
  
  protected void a(Pair<ArrayList<String>, ArrayList<String>> paramPair, boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, String paramString3, boolean paramBoolean3, int paramInt)
  {
    Intent localIntent;
    if (paramBoolean2)
    {
      localIntent = new Intent();
      localIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", this.aj);
      localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", (ArrayList)paramPair.first);
      if ((paramPair.second != null) && (!((ArrayList)paramPair.second).isEmpty())) {
        localIntent.putExtra("PhotoConst.PHOTO_PATHS_BY_FILE", (Serializable)paramPair.second);
      }
      localIntent.putExtra("uin", this.l.b);
      localIntent.putExtra("uintype", this.l.a);
      localIntent.putExtra("troop_uin", this.l.c);
      localIntent.putExtra("key_confess_topicid", this.l.v);
      localIntent.putExtra("PhotoConst.SEND_SIZE_SPEC", paramInt);
      localIntent.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
      localIntent.putExtra("send_in_background", true);
      localIntent.putExtra("entrance", this.l.s);
      if (((ArrayList)paramPair.first).size() == 1) {
        localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", (Serializable)paramPair.first);
      }
      localIntent.putExtra("key_pic_send_source", 8);
      b(localIntent);
    }
    else
    {
      localIntent = new Intent(this.k, SendPhotoActivity.class);
      localIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", this.aj);
      localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", (ArrayList)paramPair.first);
      if ((paramPair.second != null) && (!((ArrayList)paramPair.second).isEmpty())) {
        localIntent.putExtra("PhotoConst.PHOTO_PATHS_BY_FILE", (Serializable)paramPair.second);
      }
      localIntent.putExtra("PhotoConst.PHOTO_COUNT", ((ArrayList)paramPair.first).size());
      localIntent.putExtra("uin", this.l.b);
      localIntent.putExtra("uintype", this.l.a);
      localIntent.putExtra("troop_uin", this.l.c);
      localIntent.putExtra("key_confess_topicid", this.l.v);
      localIntent.putExtra("PhotoConst.SEND_SIZE_SPEC", paramInt);
      localIntent.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
      localIntent.putExtra("entrance", this.l.s);
      if (((ArrayList)paramPair.first).size() == 1) {
        localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", (Serializable)paramPair.first);
      }
      localIntent.putExtra("key_pic_send_source", 8);
      if (paramBoolean3)
      {
        localIntent.putExtra("key_is_sync_qzone", 1);
        paramPair = this.at;
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
    if (this.x) {
      return;
    }
    if (!this.y) {
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
    if (QFileAssistantUtils.a(this.l.b)) {
      return;
    }
    if (this.x) {
      return;
    }
    if (!this.y) {
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
    ((Bundle)localObject).putInt("entrance", this.l.s);
    RichmediaService.b((Bundle)localObject);
  }
  
  protected void a(ArrayList<String> paramArrayList, int paramInt)
  {
    ReceiptMsgManager.a().a(this.i, this.l, paramArrayList, paramInt);
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
      if ((r()) || (!paramArrayList1.isEmpty()) || (!paramArrayList2.isEmpty())) {
        QQToast.makeText(this.k, 2131892636, 0).show();
      }
      c();
      this.d.clear();
      this.u.clear();
      n();
      return;
    }
    if (!j()) {
      return;
    }
    if (a(paramArrayList1, paramArrayList2))
    {
      localObject = getResources().getString(2131916238);
      paramArrayList1 = new PhotoListPanel.9(this, paramArrayList1, paramArrayList2, paramBoolean);
      if (FreeWifiHelper.a(this.k, 4, new PhotoListPanel.10(this, paramArrayList1))) {
        DialogUtil.a(this.k, 232, null, (String)localObject, new PhotoListPanel.11(this, paramArrayList1), new PhotoListPanel.12(this)).show();
      }
      if (QLog.isColorLevel()) {
        QLog.i("PhotoListPanel", 2, "show shortvideo_mobile_send_confirm dialog");
      }
      return;
    }
    Object localObject = this.T;
    if (localObject != null) {
      ((PhotoListPanel.ImageSentListener)localObject).a();
    }
    b(paramArrayList1, paramArrayList2, paramBoolean);
  }
  
  protected void a(ArrayList<String> paramArrayList, boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, String paramString3, int paramInt, LocalMediaInfo paramLocalMediaInfo)
  {
    this.u.remove(paramLocalMediaInfo.position);
    this.d.remove(paramLocalMediaInfo.path);
    f();
    Object localObject = this.V;
    if (localObject != null) {
      ((PhotoListPanel.ImageCountChangedListener)localObject).a(getSelectedPhotosIntent());
    }
    n();
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
      if (this.d.size() > 0) {
        this.f.a();
      }
      this.d.clear();
      this.u.clear();
      localObject = this.V;
      if (localObject != null) {
        ((PhotoListPanel.ImageCountChangedListener)localObject).a(null);
      }
      this.f.notifyDataSetChanged();
      this.K.setChecked(false);
      this.w.clear();
      localObject = this.k.getIntent();
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
      ((StringBuilder)localObject).append(this.d.size());
      ((StringBuilder)localObject).append(", clear:");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("PhotoListPanel", 2, ((StringBuilder)localObject).toString());
    }
    n();
    setMixedMsgMode(false);
  }
  
  public void a(boolean paramBoolean, Intent paramIntent)
  {
    if (paramBoolean)
    {
      this.k.startActivityForResult(paramIntent, 10005);
      return;
    }
    this.k.startActivity(paramIntent);
  }
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, long paramLong, Pair<ArrayList<String>, ArrayList<String>> paramPair)
  {
    boolean bool;
    if ((SVBusiUtil.c != 0L) && (System.currentTimeMillis() - SVBusiUtil.c < 300000L)) {
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
      ((StringBuilder)localObject).append(SVBusiUtil.c);
      QLog.d("PhotoListPanel", 2, ((StringBuilder)localObject).toString());
    }
    if (a(paramLong, bool))
    {
      localObject = ShortVideoUtils.stringForFileSize(this.k, paramLong);
      localObject = String.format(getResources().getString(2131916620), new Object[] { localObject });
      paramString1 = new PhotoListPanel.5(this, paramPair, paramBoolean, paramString1, paramString2, paramString3);
      if (FreeWifiHelper.a(this.k, 4, new PhotoListPanel.6(this, paramString1))) {
        DialogUtil.a(this.k, 232, null, (String)localObject, new PhotoListPanel.7(this, paramString1), new PhotoListPanel.8(this)).show();
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
  
  protected boolean a(long paramLong, boolean paramBoolean)
  {
    return (NetworkUtil.isMobileNetWork(this.k)) && (!paramBoolean) && (paramLong >= 1048576L);
  }
  
  public boolean a(BaseChatPie paramBaseChatPie, List<String> paramList, boolean paramBoolean)
  {
    Pair localPair = new Pair(new ArrayList(), new ArrayList());
    SendByFile localSendByFile = this.as;
    if (localSendByFile != null)
    {
      boolean bool;
      if (this.c == 2) {
        bool = true;
      } else {
        bool = false;
      }
      localPair = localSendByFile.a(paramList, bool, this.g, null);
    }
    else
    {
      ((ArrayList)localPair.first).addAll(paramList);
    }
    if ((getSelectedPhotoCount() > 0) && (paramBoolean) && (paramBaseChatPie != null) && (!((ArrayList)localPair.first).isEmpty())) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    int i1;
    if (paramBoolean)
    {
      a(paramBaseChatPie, localPair);
      if (this.l.a == 0) {
        i1 = 1;
      } else if (this.l.a == 1) {
        i1 = 2;
      } else if (this.l.a == 3000) {
        i1 = 3;
      } else {
        i1 = 0;
      }
      ReportController.b(this.i, "CliOper", "", "", "0X8009BEB", "0X8009BEB", i1, 0, "", "", "", "");
    }
    else
    {
      NewFlowCameraReporter.a(paramList);
      if ((u()) && (b())) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      a((ArrayList)localPair.first, (ArrayList)localPair.second, this.y);
      if (i1 != 0)
      {
        paramBaseChatPie = new LpReportInfo_pf00064(723, 1, 5);
        LpReportManager.getInstance().reportToPF00064(paramBaseChatPie, false, false);
        RetentionReport.report(8);
      }
    }
    l();
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
      QQToast.makeText(this.k, 1, 2131916075, 0).show(getResources().getDimensionPixelSize(2131299920));
      return false;
    }
    if (Utils.c() <= 512000L)
    {
      ShortVideoPreviewActivity.showAlertDialog(this.k, 2131916644);
      return false;
    }
    return true;
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
      if (this.f.a(paramArrayList2) == 1)
      {
        i3 = 1;
        break;
      }
      i2 += 1;
    }
    boolean bool1;
    if ((SVBusiUtil.c != 0L) && (System.currentTimeMillis() - SVBusiUtil.c < 300000L)) {
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
      paramArrayList1.append(SVBusiUtil.c);
      QLog.d("PhotoListPanel", 2, paramArrayList1.toString());
    }
    boolean bool2 = bool3;
    if (NetworkUtil.isMobileNetWork(this.k))
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
      QQToast.makeText(this.k, 2131892634, 0).show();
      c();
      this.d.clear();
      this.u.clear();
      paramArrayList = this.V;
      if (paramArrayList != null) {
        paramArrayList.a(null);
      }
      n();
      return false;
    }
    return true;
  }
  
  public boolean a(boolean paramBoolean, BaseChatPie paramBaseChatPie)
  {
    return a(paramBaseChatPie, this.d, paramBoolean);
  }
  
  protected void b(Intent paramIntent)
  {
    ThreadManager.post(new SendPhotoTask((BaseActivity)this.k, paramIntent, null), 8, null, false);
  }
  
  public void b(String paramString)
  {
    ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(this.k, "/base/album/photopreview");
    Object localObject = this.j;
    if ((localObject != null) && (((Intent)localObject).getExtras() != null)) {
      localActivityURIRequest.extra().putAll(this.j.getExtras());
    }
    localActivityURIRequest.extra().putString("ALBUM_ID", "$RecentAlbumId");
    localActivityURIRequest.extra().putInt("PhotoConst.SEND_BUSINESS_TYPE", this.aj);
    localActivityURIRequest.extra().putString("uin", this.l.b);
    localActivityURIRequest.extra().putInt("uintype", this.l.a);
    localActivityURIRequest.extra().putString("troop_uin", this.l.c);
    localActivityURIRequest.extra().putString("uinname", this.l.e);
    localObject = this.j;
    if ((localObject == null) || (!((Intent)localObject).hasExtra("showFlashPic")))
    {
      localObject = this.i;
      if (localObject != null) {
        localObject = (HotChatManager)((QQAppInterface)localObject).getManager(QQManagerFactory.HOT_CHAT_MANAGER);
      }
      localActivityURIRequest.extra().putBoolean("showFlashPic", ((IPicFlash)QRoute.api(IPicFlash.class)).showFlashPicOption(this.l.a, this.l.c));
    }
    if ((this.k instanceof SplashActivity))
    {
      localActivityURIRequest.extra().putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
      localActivityURIRequest = AIOUtils.a(localActivityURIRequest, null);
    }
    else
    {
      localActivityURIRequest.extra().putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ChatActivity.class.getName());
    }
    localActivityURIRequest.extra().putString("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localActivityURIRequest.extra().putString("key_activity_code", ChatActivityUtils.a(this.k));
    if (this.l.a == 9501)
    {
      if ((this.k instanceof SplashActivity))
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
      localActivityURIRequest.extra().putInt("key_confess_topicid", this.l.v);
    }
    localActivityURIRequest.extra().putString("PhotoConst.DEST_VIDEO_ACTIVITY_CLASS_NAME", SendVideoActivity.class.getName());
    localActivityURIRequest.extra().putString("PhotoConst.DEST_VIDEO_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localActivityURIRequest.extra().putInt("PhotoConst.CURRENT_QUALITY_TYPE", this.c);
    localActivityURIRequest.extra().putBoolean("PhotoConst.IS_OVERLOAD", false);
    localActivityURIRequest.setFlags(603979776);
    localActivityURIRequest.extra().putBoolean("PhotoConst.IS_SINGLE_MODE", true);
    localActivityURIRequest.extra().putString("PhotoConst.SINGLE_PHOTO_PATH", paramString);
    localActivityURIRequest.extra().putInt("PhotoConst.SEND_BUSINESS_TYPE", this.aj);
    localActivityURIRequest.extra().putBoolean("PhotoConst.ALLOW_LOCK", false);
    localActivityURIRequest.extra().putInt("enter_from", 1);
    localActivityURIRequest.extra().putString("KEY_PHOTO_LIST_CLASS_NAME", PhotoListCustomizationAIO.a);
    localActivityURIRequest.extra().putString("KEY_ALBUM_LIST_CLASS_NAME", AlbumListCustomizationAIO.j);
    localActivityURIRequest.extra().putString("KEY_PHOTO_PREVIEW_CLASS_NAME", PhotoPreviewCustomizationAIO.a);
    localActivityURIRequest.extra().putBoolean("PHOTO_PREVIEW_NEED_DRAG_KEY", true);
    QRoute.startUri(localActivityURIRequest);
  }
  
  void b(@NonNull ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, boolean paramBoolean)
  {
    boolean bool = i();
    int i6 = this.c;
    HashMap localHashMap = new HashMap();
    int i2 = 0;
    int i3 = 0;
    int i5;
    for (int i1 = 0; i2 < paramArrayList1.size(); i1 = i5)
    {
      localObject = (String)paramArrayList1.get(i2);
      int i4;
      if (this.f.a((String)localObject) == 1)
      {
        localObject = this.f.b((String)localObject);
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
    Object localObject = new Intent(this.k, SendPhotoActivity.class);
    ((Intent)localObject).putStringArrayListExtra("PhotoConst.PHOTO_PATHS_BY_FILE", paramArrayList2);
    ((Intent)localObject).putExtra("PhotoConst.SEND_BUSINESS_TYPE", this.aj);
    ((Intent)localObject).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", paramArrayList1);
    if (!localHashMap.isEmpty()) {
      ((Intent)localObject).putExtra("PhotoConst.VIDEO_INFOS", localHashMap);
    }
    ((Intent)localObject).putExtra("PhotoConst.PHOTO_COUNT", paramArrayList1.size());
    ((Intent)localObject).putExtra("uin", this.l.b);
    ((Intent)localObject).putExtra("uintype", this.l.a);
    ((Intent)localObject).putExtra("troop_uin", this.l.c);
    ((Intent)localObject).putExtra("key_confess_topicid", this.l.v);
    ((Intent)localObject).putExtra("PhotoConst.SEND_SIZE_SPEC", i6);
    ((Intent)localObject).putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
    ((Intent)localObject).putExtra("entrance", this.l.s);
    ((Intent)localObject).putExtra("key_pic_send_source", 8);
    if (paramArrayList1.size() == 1) {
      ((Intent)localObject).putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramArrayList1);
    }
    if ((paramBoolean) && (i6 == 2)) {
      a(1020);
    }
    a(PhotoListPanelUtils.a(paramBoolean, i6, (Intent)localObject), (Intent)localObject);
    ReportController.b(null, "CliOper", "", "", "0X8009AAF", "0X8009AAF", PhotoUtils.getTypeforReportSpcialDiscuss(this.l), 0, String.valueOf(i3), String.valueOf(i1), "", "");
  }
  
  protected boolean b()
  {
    int i1 = getSyncToQzoneConfig();
    boolean bool = false;
    if (i1 == 0) {
      return false;
    }
    if (this.am) {
      return false;
    }
    SessionInfo localSessionInfo = this.l;
    if (localSessionInfo == null) {
      return false;
    }
    if ((localSessionInfo.a == 0) || (this.l.a == 1000) || (this.l.a == 1004)) {
      bool = true;
    }
    return bool;
  }
  
  protected long c(String paramString)
  {
    return new File(paramString).length();
  }
  
  public void c()
  {
    Object localObject = (TextView)this.N.findViewById(2131439492);
    int i1 = getResources().getDisplayMetrics().densityDpi;
    if (i1 < 320) {
      ((TextView)localObject).setCompoundDrawables(null, null, null, null);
    }
    if (b == 0)
    {
      this.N.setVisibility(0);
      this.F.setVisibility(8);
    }
    this.h = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("densityDpi = ");
      ((StringBuilder)localObject).append(i1);
      ((StringBuilder)localObject).append("qurey time=");
      ((StringBuilder)localObject).append(this.h);
      QLog.d("PhotoListPanel", 2, ((StringBuilder)localObject).toString());
    }
    ThreadManager.post(new PhotoListPanel.QueryMediaTask(this), 8, null, true);
  }
  
  public void d()
  {
    if (this.x) {
      return;
    }
    this.y = PlusPanelUtils.a(this.l, this.z);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initPresend! mAllowPresend = ");
      ((StringBuilder)localObject).append(this.y);
      QLog.d("PhotoListPanel", 2, ((StringBuilder)localObject).toString());
    }
    if (this.y)
    {
      localObject = new BinderWarpper(new PresendPicMgrService(this.l.a, this.l.b, this.l.c, this.m, this.l.v).asBinder());
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("binder_presendService", (Parcelable)localObject);
      RichmediaService.a(localBundle);
    }
  }
  
  public boolean d(String paramString)
  {
    int i1 = getSelectedPhotoCount();
    int i2 = getSelectedVideoCount();
    return (!TextUtils.isEmpty(paramString)) && (i1 > 0) && (i2 == 0);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    getParent().requestDisallowInterceptTouchEvent(true);
    SwipeUpAndDragListener localSwipeUpAndDragListener = this.ap;
    if (localSwipeUpAndDragListener != null)
    {
      localSwipeUpAndDragListener.onTouch(this, paramMotionEvent);
      super.dispatchTouchEvent(paramMotionEvent);
      this.ap.l = paramMotionEvent.getX();
      this.ap.m = paramMotionEvent.getY();
      return true;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public PhotoListPanel.CheckBoxClickedListener e()
  {
    return new PhotoListPanel.CheckBoxClickedListener(this);
  }
  
  public void f()
  {
    Object localObject1 = ((StaggeredGridLayoutManager)this.G).findFirstVisibleItemPositions(null);
    Object localObject2 = ((StaggeredGridLayoutManager)this.G).findLastVisibleItemPositions(null);
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
      localObject1 = (PhotoListPanel.PhotoPanelAdapter.RecyclerHolder)this.F.findViewHolderForAdapterPosition(i3);
      localObject2 = this.f.a(i3);
      if (localObject2 != null)
      {
        i1 = this.d.indexOf(((LocalMediaInfo)localObject2).path);
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("updateCheckView mIndex=");
          ((StringBuilder)localObject2).append(i1);
          QLog.d("check", 2, ((StringBuilder)localObject2).toString());
        }
        if ((i1 >= 0) && (localObject1 != null))
        {
          ((PhotoListPanel.PhotoPanelAdapter.RecyclerHolder)localObject1).c.setCheckedNumber(i1 + 1);
          ((PhotoListPanel.PhotoPanelAdapter.RecyclerHolder)localObject1).f.setVisibility(0);
        }
        else if (localObject1 == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("check", 2, "updateCheckView view is null?????=");
          }
        }
        else
        {
          ((PhotoListPanel.PhotoPanelAdapter.RecyclerHolder)localObject1).c.setChecked(false);
          ((PhotoListPanel.PhotoPanelAdapter.RecyclerHolder)localObject1).f.setVisibility(4);
        }
      }
      i3 += 1;
    }
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanel", 2, "onEditBtnClicked");
    }
    if (this.d.size() > 0)
    {
      Intent localIntent = ((IAELaunchEditPic)QRoute.api(IAELaunchEditPic.class)).startEditPic(this.k, (String)this.d.get(0), true, true, true, true, true, 2, 140, 5);
      localIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.c);
      localIntent.putExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", i());
      localIntent.putExtra("key_enable_edit_title_bar", true);
      this.k.startActivity(localIntent);
      if ((this.k instanceof SplashActivity)) {
        ReportController.b(null, "dc00898", "", "", "0X800A06B", "0X800A06B", 0, 0, "", "", "", "");
      }
    }
  }
  
  public int getSelectedMediaCount()
  {
    LinkedList localLinkedList = this.d;
    if (localLinkedList != null) {
      return localLinkedList.size();
    }
    return 0;
  }
  
  public int getSelectedPhotoCount()
  {
    int i1 = 0;
    int i3;
    for (int i2 = 0; i1 < this.d.size(); i2 = i3)
    {
      i3 = i2;
      if (this.f.a((String)this.d.get(i1)) == 0) {
        i3 = i2 + 1;
      }
      i1 += 1;
    }
    return i2;
  }
  
  public Intent getSelectedPhotosIntent()
  {
    ArrayList localArrayList = new ArrayList(this.d);
    Intent localIntent = new Intent();
    localIntent.putExtra("PhotoConst.SHOW_ALBUM", true);
    localIntent.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", localArrayList);
    localIntent.putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", this.u);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getSelectedPhotosIntent SELECTED_PATHS size=");
      localStringBuilder.append(localArrayList.size());
      localStringBuilder.append(",SELECTED_INDEXS size=");
      localArrayList = this.u;
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
  
  public int getSelectedVideoCount()
  {
    int i1 = 0;
    int i3;
    for (int i2 = 0; i1 < this.d.size(); i2 = i3)
    {
      i3 = i2;
      if (this.f.a((String)this.d.get(i1)) == 1) {
        i3 = i2 + 1;
      }
      i1 += 1;
    }
    return i2;
  }
  
  protected int getSizeLimit()
  {
    return (int)((IPicBus)QRoute.api(IPicBus.class)).getC2CPicSizeLimit();
  }
  
  protected int getSyncToQzoneConfig()
  {
    return QzoneConfig.getInstance().getConfig("PhotoUpload", "C2CAioEnableSyncImageToQzone", 1);
  }
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanel", 2, "onAlbumBtnClicked");
    }
    Object localObject = this.S;
    if ((localObject != null) && (((PhotoListPanel.BottomBtnClickListener)localObject).a(this))) {
      return;
    }
    if (this.l.a == 1) {}
    try
    {
      ((ITroopPhotoHandler)((QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.m)).getBusinessHandler(BusinessHandlerFactory.TROOP_PHOTO_HANDLER)).a(this.l.b, true);
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
    if (!this.d.isEmpty()) {
      localObject = new ArrayList(this.d);
    }
    if (this.ai) {
      this.j.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
    }
    this.j.putExtra("fromPhotoListPanel", true);
    this.j.putExtra("peakconstant.request_code", 10006);
    this.j.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.c);
    this.j.putExtra("PhotoConst.is_troop_send_mixed_msg", this.ak);
    this.j.putExtra("PhotoConst.DISABLE_UPLOAD_TO_TROOP_ALBUM", this.E);
    this.j.putExtra("PhotoConst.UPLOAD_CHECKBOX_IS_CHECKED", u());
    this.j.putExtra("PhotoConst.AIO_TO_PHOTO_LIST_NEED_SHOW_UPLOAD_BAR", b());
    localHashMap = this.w;
    if ((localHashMap != null) && (!localHashMap.isEmpty())) {
      this.j.putExtra("PhotoConst.SEND_NO_PRESEND", true);
    }
    PlusPanelUtils.a(this.i, this.k, this.l, (ArrayList)localObject, this.j, this.w);
    l();
    ReportController.b(null, "CliOper", "", "", "0X8005E05", "0X8005E05", 0, 0, "", "", "", "");
    p();
  }
  
  protected boolean i()
  {
    return this.j.getBooleanExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", false);
  }
  
  protected boolean j()
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
      QQToast.makeText(this.k, 1, 2131916075, 0).show(getResources().getDimensionPixelSize(2131299920));
      return false;
    }
    if (Utils.c() <= 512000L)
    {
      ShortVideoPreviewActivity.showAlertDialog(this.k, 2131916644);
      return false;
    }
    return true;
  }
  
  protected void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanel", 2, "onSendBtnClicked");
    }
    PhotoListPanel.BottomBtnClickListener localBottomBtnClickListener = this.S;
    if ((localBottomBtnClickListener != null) && (localBottomBtnClickListener.b(this))) {
      return;
    }
    a(false, null);
  }
  
  public void l()
  {
    a(true);
  }
  
  public void m()
  {
    if (ThemeUtil.isNowThemeIsNight(this.i, false, null))
    {
      this.F.setBackgroundColor(-16777216);
      this.Q.setTextColor(-1509949441);
    }
  }
  
  public void n()
  {
    Activity localActivity = this.k;
    if (localActivity != null) {
      localActivity.runOnUiThread(new PhotoListPanel.13(this));
    }
  }
  
  void o()
  {
    if (this.A) {
      return;
    }
    int i1 = this.c;
    if (i1 != 0)
    {
      if (i1 != 2) {
        return;
      }
      QQAlbumUtils.a(this.M, this.d, this.g, true, this.k, null, null);
      this.K.setChecked(true);
      return;
    }
    this.K.setChecked(false);
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int i1 = paramCompoundButton.getId();
    if (i1 != 2131434403)
    {
      if (i1 == 2131442912) {
        if (paramBoolean)
        {
          SendByFile localSendByFile = this.as;
          if (localSendByFile != null) {
            localSendByFile.a(getContext(), this.d, paramBoolean, this.g, null);
          }
          this.K.setChecked(true);
          this.c = 2;
          QQAlbumUtils.a(this.M, this.d, this.g, true, this.k, null, null);
          this.L.setContentDescription(HardCodeUtil.a(2131905919));
          ReportController.b(null, "CliOper", "", "", "0X8005E07", "0X8005E07", 0, 0, "", "", "", "");
        }
        else
        {
          this.c = 0;
          this.K.setChecked(false);
          this.M.setVisibility(4);
          this.L.setContentDescription(HardCodeUtil.a(2131905874));
        }
      }
    }
    else
    {
      this.an = paramBoolean;
      n();
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
    case 2131449185: 
      if (this.l.a == 1) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      bool = b();
      localObject = QZoneHelper.UserInfo.getInstance();
      ((QZoneHelper.UserInfo)localObject).qzone_uin = this.m;
      ((QZoneHelper.UserInfo)localObject).nickname = this.n;
      if (i1 != 0)
      {
        QZoneHelper.forwardToQunAlbumListSelect(this.k, (QZoneHelper.UserInfo)localObject, this.l.b, this.l.e, 10008);
      }
      else if (bool)
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("key_personal_album_enter_model", 0);
        localBundle.putString("key_title", this.k.getString(2131915134));
        localBundle.putBoolean("key_personal_album_is_select_video", false);
        if (!TextUtils.isEmpty(this.at))
        {
          localBundle.putString("key_default_album_id", this.at);
          localBundle.putBoolean("key_from_upload", true);
        }
        QZoneHelper.forwardToPersonalAlbumSelect(this.k, (QZoneHelper.UserInfo)localObject, localBundle, 10009);
        localObject = new LpReportInfo_pf00064(723, 1, 4);
        LpReportManager.getInstance().reportToPF00064((LpReportInfo_pf00064)localObject, false, false);
      }
      break;
    case 2131445580: 
      localObject = this.u.iterator();
      while (((Iterator)localObject).hasNext()) {
        ReportController.b(null, "dc00898", "", "", "0X800A7B0", "0X800A7B0", ((Integer)((Iterator)localObject).next()).intValue() + 1, 0, "2", "", "", "");
      }
      i1 = PhotoUtils.getTypeforReport2(this.l);
      int i2 = this.u.size();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(i1);
      ReportController.b(null, "dc00898", "", "", "0X800A912", "0X800A912", i2, 0, ((StringBuilder)localObject).toString(), "", "", "");
      k();
      break;
    case 2131442913: 
    case 2131442918: 
      if (!this.K.isChecked()) {
        this.K.setChecked(true);
      } else {
        this.K.setChecked(false);
      }
      break;
    case 2131437877: 
      g();
      break;
    case 2131434403: 
      v();
      bool = u();
      if (b())
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
        ((QZoneClickReport.ReportInfo)localObject).toUin = Long.valueOf(this.m).longValue();
        ((QZoneClickReport.ReportInfo)localObject).actionType = "459";
        ((QZoneClickReport.ReportInfo)localObject).subactionType = "3";
        QZoneClickReport.report(this.m, (QZoneClickReport.ReportInfo)localObject, true);
      }
      else
      {
        localObject = new QZoneClickReport.ReportInfo();
        ((QZoneClickReport.ReportInfo)localObject).toUin = Long.valueOf(this.m).longValue();
        ((QZoneClickReport.ReportInfo)localObject).actionType = "459";
        ((QZoneClickReport.ReportInfo)localObject).subactionType = "2";
        QZoneClickReport.report(this.m, (QZoneClickReport.ReportInfo)localObject, true);
      }
      break;
    case 2131428167: 
      h();
    }
    BabyQHandler.a(this.O);
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    Object localObject = this.ap;
    if (localObject != null)
    {
      localObject = (PhotoListPanel.PhotoPanelAdapter.RecyclerHolder)this.F.findViewHolderForAdapterPosition(((SwipeUpAndDragListener)localObject).r);
      boolean bool2 = false;
      if (localObject == null) {
        return false;
      }
      Math.abs(this.ap.l - paramMotionEvent.getX());
      Math.abs(this.ap.m - paramMotionEvent.getY());
      boolean bool1 = bool2;
      if (paramMotionEvent.getAction() != 0)
      {
        bool1 = bool2;
        if (this.ap.f) {
          bool1 = true;
        }
      }
      return bool1;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  void p()
  {
    View localView = this.P;
    if ((localView != null) && (localView.getVisibility() == 0))
    {
      BabyQHandler.a(this.P);
      this.P = null;
      this.Z = false;
      this.f.notifyDataSetChanged();
      BabyQHandler.a(this.k, this.O);
    }
  }
  
  public void q()
  {
    SwipeUpAndDragListener localSwipeUpAndDragListener = this.ap;
    if (localSwipeUpAndDragListener != null) {
      localSwipeUpAndDragListener.b();
    }
  }
  
  public boolean r()
  {
    return (!i()) && (!AnonymousChatHelper.a().a(this.l.b));
  }
  
  public HashMap<String, String> s()
  {
    return ReplacePhotoDataUtil.a(this.w);
  }
  
  public void setCustomOnClickListener(PhotoListPanel.BottomBtnClickListener paramBottomBtnClickListener)
  {
    this.S = paramBottomBtnClickListener;
  }
  
  public void setImageCountChangedListener(PhotoListPanel.ImageCountChangedListener paramImageCountChangedListener)
  {
    this.V = paramImageCountChangedListener;
  }
  
  public void setImageOnly(boolean paramBoolean)
  {
    if ((this.al == null) && (!paramBoolean))
    {
      this.j.removeExtra("showFlashPic");
    }
    else
    {
      localObject = this.j;
      boolean bool;
      if ((!paramBoolean) && (this.al.booleanValue())) {
        bool = true;
      } else {
        bool = false;
      }
      ((Intent)localObject).putExtra("showFlashPic", bool);
    }
    Object localObject = this.af;
    if (localObject == null) {
      return;
    }
    if (paramBoolean)
    {
      this.ag = ((MediaFileFilter)localObject);
      this.af = MediaFileFilter.getFilter(1);
      return;
    }
    localObject = this.ag;
    if (localObject != null)
    {
      this.af = ((MediaFileFilter)localObject);
      this.ag = null;
    }
  }
  
  public void setImageSentListener(PhotoListPanel.ImageSentListener paramImageSentListener)
  {
    this.T = paramImageSentListener;
  }
  
  public void setLastRequestCode(int paramInt)
  {
    this.ar = paramInt;
  }
  
  public void setMediaFileFilter(int paramInt)
  {
    this.af = MediaFileFilter.getFilter(paramInt);
  }
  
  public void setMixedMsgMode(boolean paramBoolean)
  {
    this.ak = paramBoolean;
  }
  
  public void setOnSwipeUpAndDragListener(SwipeUpAndDragListener paramSwipeUpAndDragListener)
  {
    this.ap = paramSwipeUpAndDragListener;
  }
  
  public void setReceiptMode(boolean paramBoolean, QQAppInterface paramQQAppInterface)
  {
    this.j.putExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", paramBoolean);
    int i1;
    if (this.E != paramBoolean) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    setImageOnly(paramBoolean);
    this.E = paramBoolean;
    if (paramBoolean)
    {
      this.s = Math.min(ReceiptUtil.b(paramQQAppInterface), this.s);
      this.F.setOnTouchListener(null);
    }
    else
    {
      this.F.setOnTouchListener(this.ap);
      this.s = this.j.getIntExtra("PhotoConst.MAXUM_SELECTED_NUM", 20);
      if (this.l.a == 9501) {
        this.s = 5;
      }
    }
    if (i1 != 0) {
      l();
    }
  }
  
  public void setSelectLimitListener(PhotoListPanel.SelectLimitListener paramSelectLimitListener)
  {
    this.U = paramSelectLimitListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.PhotoListPanel
 * JD-Core Version:    0.7.0.1
 */