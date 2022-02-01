package com.tencent.mobileqq.activity.contact.troop;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.activity.contact.newfriend.BaseSystemMsgInterface;
import com.tencent.mobileqq.activity.contact.recommendtroop.base.ViewHolder;
import com.tencent.mobileqq.activity.contact.troop.generalgroupnotifyparser.AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo;
import com.tencent.mobileqq.activity.contact.troop.generalgroupnotifyparser.GeneralGroupNotifyParser;
import com.tencent.mobileqq.activity.contact.troop.generalgroupnotifyparser.GeneralGroupNotifyParser.GeneralGroupNotifyInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.RecommendTroopManagerImp;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.Stranger;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.managers.TroopRemindSettingManager;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.URIRequest;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.troop.data.NearbyTroops;
import com.tencent.mobileqq.troop.data.RecommendTroopItem;
import com.tencent.mobileqq.troop.utils.TroopBindPubAccountProtocol;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troopinfo.GroupCatalogTool;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.SwipListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import tencent.mobileim.structmsg.structmsg.GroupInfo;
import tencent.mobileim.structmsg.structmsg.MsgInviteExt;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsgAction;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;

public class TroopNotifyAndRecommendView
  extends BaseTroopView
  implements View.OnClickListener, BaseSystemMsgInterface, DecodeTaskCompletionListener, AbsListView.OnScrollListener, Observer
{
  protected static long c;
  public static int d;
  public final long a;
  protected Context a;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  protected View.OnClickListener a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  protected TextView a;
  NotifyAndRecAdapter jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter;
  private SlideAndOverScrollRecyclerView jdField_a_of_type_ComTencentMobileqqActivityContactTroopSlideAndOverScrollRecyclerView;
  private SuspiciousAdapter jdField_a_of_type_ComTencentMobileqqActivityContactTroopSuspiciousAdapter;
  TroopNotificationObserver jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotificationObserver = new TroopNotifyAndRecommendView.5(this);
  TroopNotificationUtils.TroopPrivilegeCallback jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotificationUtils$TroopPrivilegeCallback = new TroopNotifyAndRecommendView.17(this);
  private TroopNotifyHelper.OnTroopSafeDialogClickConfirm jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyHelper$OnTroopSafeDialogClickConfirm = new TroopNotifyAndRecommendView.13(this);
  MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new TroopNotifyAndRecommendView.8(this);
  protected RecommendTroopManagerImp a;
  private ThreadExcutor.IThreadListener jdField_a_of_type_ComTencentMobileqqAppThreadExcutor$IThreadListener = new TroopNotifyAndRecommendView.6(this);
  TroopBusinessObserver jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver = new TroopNotifyAndRecommendView.18(this);
  protected IFaceDecoder a;
  private TroopInfoManager jdField_a_of_type_ComTencentMobileqqModelTroopInfoManager;
  protected SosoInterfaceOnLocationListener a;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  SwipListView jdField_a_of_type_ComTencentWidgetSwipListView;
  protected List<MessageRecord> a;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = new TroopNotifyAndRecommendView.4(this);
  protected int b;
  public final long b;
  protected View.OnClickListener b;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  protected List<MessageRecord> b;
  protected int c;
  View.OnClickListener jdField_c_of_type_AndroidViewView$OnClickListener = new TroopNotifyAndRecommendView.24(this);
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  protected List<RecommendTroopItem> c;
  protected boolean c;
  protected View.OnClickListener d;
  private TextView d;
  protected boolean d;
  protected int e;
  protected View e;
  private TextView e;
  protected boolean e;
  protected int f;
  private View jdField_f_of_type_AndroidViewView;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  protected boolean f;
  protected int g;
  private View g;
  protected boolean g;
  protected int h;
  private View h;
  protected boolean h;
  private int jdField_i_of_type_Int;
  private View jdField_i_of_type_AndroidViewView;
  protected boolean i;
  private int jdField_j_of_type_Int;
  private boolean jdField_j_of_type_Boolean;
  private int jdField_k_of_type_Int;
  private boolean jdField_k_of_type_Boolean;
  private int jdField_l_of_type_Int;
  private boolean jdField_l_of_type_Boolean = false;
  private boolean m;
  
  static
  {
    jdField_d_of_type_Int = 0;
    jdField_c_of_type_Long = 0L;
  }
  
  public TroopNotifyAndRecommendView(Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_c_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Long = 1000L;
    this.jdField_b_of_type_Long = 500L;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new TroopNotifyAndRecommendView.7(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new TroopNotifyAndRecommendView.12(this);
    this.jdField_a_of_type_ComTencentMobileqqSosoLocationSosoInterfaceOnLocationListener = null;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = true;
    this.jdField_e_of_type_Int = 0;
    this.jdField_f_of_type_Int = 0;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_h_of_type_Int = 0;
    this.jdField_d_of_type_AndroidViewView$OnClickListener = new TroopNotifyAndRecommendView.26(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void A()
  {
    TroopNotificationManager localTroopNotificationManager = (TroopNotificationManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_NOTIFICATION_MANAGER);
    if (localTroopNotificationManager == null) {
      return;
    }
    List localList1 = localTroopNotificationManager.a(0);
    List localList2;
    if (this.jdField_c_of_type_Int == 1)
    {
      localList2 = localTroopNotificationManager.a(1);
      if ((localList2 != null) && (!localList2.isEmpty())) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter.a(localList2);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter.notifyDataSetChanged();
      b(localTroopNotificationManager.a(1));
      c(localTroopNotificationManager.a(2));
      F();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter.jdField_a_of_type_Int = 0;
      return;
      setType(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter.a(localList1);
      continue;
      if (this.jdField_c_of_type_Int == 2)
      {
        localList2 = localTroopNotificationManager.a(2);
        if ((localList2 != null) && (!localList2.isEmpty()))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter.a(localTroopNotificationManager.a(2));
        }
        else
        {
          setType(0);
          this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter.a(localList1);
        }
      }
      else if (this.jdField_c_of_type_Int == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter.a(localList1);
      }
    }
  }
  
  private void B()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotifyAndRecommendView", 2, "sendReadConfirm lll");
    }
    ThreadManager.post(new TroopNotifyAndRecommendView.10(this), 8, null, false);
    if (QLog.isColorLevel()) {
      QLog.i("TroopNotifyAndRecommendView", 2, "sendReadConfirm is end!");
    }
  }
  
  private void C()
  {
    if (this.jdField_e_of_type_AndroidViewView == null) {
      this.jdField_e_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561659, null);
    }
    if (this.jdField_e_of_type_AndroidViewView.getParent() == null) {
      this.jdField_a_of_type_ComTencentWidgetSwipListView.addFooterView(this.jdField_e_of_type_AndroidViewView);
    }
    this.jdField_e_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void D()
  {
    if ((this.jdField_i_of_type_Boolean) || (this.jdField_c_of_type_Int == 2) || (this.jdField_c_of_type_Int == 1)) {}
    do
    {
      do
      {
        do
        {
          return;
          if (!NetworkUtil.d(BaseApplication.getContext()))
          {
            QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692257), 0).b(a());
            return;
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter == null) || ((this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter.b()) && (!this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter.a()))) {
            break;
          }
        } while ((this.jdField_a_of_type_ComTencentMobileqqModelTroopInfoManager != null) && (this.jdField_a_of_type_ComTencentMobileqqModelTroopInfoManager.a()));
        this.jdField_i_of_type_Boolean = true;
        this.jdField_e_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a().h();
      } while (!QLog.isColorLevel());
      QLog.i("TroopNotifyAndRecommendView", 2, "loadNextPage.get next page of Notofication");
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqAppRecommendTroopManagerImp.jdField_a_of_type_Int != 1) && (this.jdField_k_of_type_Boolean))
      {
        this.jdField_i_of_type_Boolean = true;
        this.jdField_e_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqAppRecommendTroopManagerImp.a();
        if (QLog.isColorLevel()) {
          QLog.i("TroopNotifyAndRecommendView", 2, "loadNextPage.get next page of recommend");
        }
        TroopReportor.a("Grp_contacts_news", "notice", "recom_,more", 2, 0, new String[0]);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.i("TroopNotifyAndRecommendView", 2, "ray test touch the end of list.");
  }
  
  private void E()
  {
    if (this.jdField_e_of_type_AndroidViewView != null) {
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    }
    this.jdField_i_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.i("TroopNotifyAndRecommendView", 2, "stopLoadMore().");
    }
  }
  
  private void F()
  {
    if ((this.jdField_f_of_type_AndroidViewView == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    TroopNotificationManager localTroopNotificationManager;
    do
    {
      return;
      localTroopNotificationManager = (TroopNotificationManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_NOTIFICATION_MANAGER);
    } while (localTroopNotificationManager == null);
    List localList = localTroopNotificationManager.a(2);
    if ((localTroopNotificationManager.a(1).isEmpty()) && (this.jdField_b_of_type_JavaUtilList.isEmpty()) && (localList.isEmpty()))
    {
      this.jdField_f_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    this.jdField_f_of_type_AndroidViewView.setVisibility(0);
  }
  
  private void G()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopSuspiciousAdapter = new TroopNotifyAndRecommendView.21(this, a(), 2131560030);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopSuspiciousAdapter.a(2131560031);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopSuspiciousAdapter.a(2131561659);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopSuspiciousAdapter.a(new TroopNotifyAndRecommendView.22(this));
  }
  
  private void H()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopSlideAndOverScrollRecyclerView = ((SlideAndOverScrollRecyclerView)findViewById(2131378743));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopSlideAndOverScrollRecyclerView.setLayoutManager(new LinearLayoutManager(a(), 1, false));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopSlideAndOverScrollRecyclerView.addOnScrollListener(new TroopNotifyAndRecommendView.25(this));
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this);
  }
  
  private void I()
  {
    this.jdField_i_of_type_Int = GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopSlideAndOverScrollRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopSuspiciousAdapter);
    this.jdField_b_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(AppConstants.TROOP_SUSPICIOUS_MSG_UIN, 0);
    TroopSuspiciousHelper.a(this.jdField_b_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    ArrayList localArrayList = new ArrayList();
    int n = 0;
    while (n < this.jdField_b_of_type_JavaUtilList.size())
    {
      localArrayList.add(this.jdField_b_of_type_JavaUtilList.get(this.jdField_b_of_type_JavaUtilList.size() - n - 1));
      n += 1;
    }
    this.jdField_b_of_type_JavaUtilList = localArrayList;
    if ((this.jdField_b_of_type_JavaUtilList != null) && (this.jdField_b_of_type_JavaUtilList.size() > 0))
    {
      if (this.jdField_i_of_type_AndroidViewView.getVisibility() == 8) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_contacts_news", "", "notice", "unnormal_tab_exp", 0, 0, "", "", "", "");
      }
      this.jdField_i_of_type_AndroidViewView.setVisibility(0);
      if (!(this.jdField_b_of_type_JavaUtilList.get(0) instanceof MessageForSystemMsg))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopNotifyAndRecommendView", 2, "initListData error");
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.clearGroupSystemMsgHistory();
        this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopSuspiciousAdapter.a(null);
      }
    }
    else
    {
      this.jdField_i_of_type_AndroidViewView.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopSuspiciousAdapter.a(this.jdField_b_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopSuspiciousAdapter.notifyDataSetChanged();
    F();
  }
  
  private void J()
  {
    if (this.jdField_e_of_type_Boolean) {}
    do
    {
      do
      {
        return;
        if (!NetworkUtil.d(BaseApplication.getContext()))
        {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692257), 0).b(a());
          return;
        }
      } while ((this.jdField_a_of_type_ComTencentMobileqqModelTroopInfoManager != null) && (this.jdField_a_of_type_ComTencentMobileqqModelTroopInfoManager.b()));
      this.jdField_e_of_type_Boolean = true;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopSuspiciousAdapter != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopSuspiciousAdapter.a(new TroopNotifyAndRecommendView.27(this));
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a().c(3);
    } while (!QLog.isColorLevel());
    QLog.i("TroopNotifyAndRecommendView", 2, "loadNextPage.get next page.");
  }
  
  private void K()
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopNotifyAndRecommendView", 2, "stopLoadMore().");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopSuspiciousAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopSuspiciousAdapter.b();
    }
    this.jdField_e_of_type_Boolean = false;
  }
  
  private void L()
  {
    ThreadManager.post(new TroopNotifyAndRecommendView.28(this), 8, null, false);
  }
  
  private void M()
  {
    this.jdField_j_of_type_Int = GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1012);
    }
  }
  
  public static long a(List<MessageRecord> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = (MessageRecord)paramList.get(0);
      if ((paramList instanceof MessageForSystemMsg))
      {
        paramList = ((MessageForSystemMsg)paramList).getSystemMsg();
        if ((paramList != null) && (paramList.msg_seq.has()))
        {
          long l1 = paramList.msg_seq.get();
          if (l1 > 0L) {
            return l1;
          }
        }
      }
    }
    return 0L;
  }
  
  public static List<MessageRecord> a(List<MessageRecord> paramList1, List<MessageRecord> paramList2)
  {
    if ((paramList1 == null) || (paramList2 == null)) {
      return paramList1;
    }
    if (a(paramList1) >= a(paramList2))
    {
      paramList1.addAll(paramList2);
      return paramList1;
    }
    paramList2.addAll(paramList1);
    return paramList2;
  }
  
  private void a(long paramLong, structmsg.StructMsg paramStructMsg)
  {
    Bundle localBundle = new Bundle();
    localBundle.putByteArray("structMsg", paramStructMsg.toByteArray());
    TroopBindPubAccountProtocol.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong, new TroopNotifyAndRecommendView.14(this), localBundle);
  }
  
  private void a(RecyclerView paramRecyclerView, String paramString, Bitmap paramBitmap)
  {
    Object localObject;
    SuspiciousHolder localSuspiciousHolder;
    if (this.jdField_b_of_type_Int == 0)
    {
      int i1 = paramRecyclerView.getChildCount();
      int n = 0;
      while (n < i1)
      {
        localObject = paramRecyclerView.findViewHolderForAdapterPosition(n);
        if ((localObject == null) || (!(localObject instanceof SuspiciousHolder)))
        {
          n += 1;
        }
        else
        {
          localSuspiciousHolder = (SuspiciousHolder)localObject;
          switch (TroopNotificationUtils.a(localSuspiciousHolder.jdField_a_of_type_Int))
          {
          default: 
            localObject = String.valueOf(localSuspiciousHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get());
          }
        }
      }
    }
    while ((localSuspiciousHolder.jdField_a_of_type_AndroidWidgetImageView != null) && (paramString.equals(localObject)))
    {
      localSuspiciousHolder.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
      return;
      localObject = localSuspiciousHolder.jdField_a_of_type_JavaLangString;
      continue;
      localObject = String.valueOf(localSuspiciousHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get());
    }
  }
  
  private void a(ViewHolder paramViewHolder, MessageRecord paramMessageRecord, int paramInt)
  {
    SuspiciousHolder localSuspiciousHolder = (SuspiciousHolder)paramViewHolder;
    if ((paramMessageRecord == null) || (!(paramMessageRecord instanceof MessageForSystemMsg))) {}
    int n;
    do
    {
      return;
      localSuspiciousHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = ((MessageForSystemMsg)paramMessageRecord).getSystemMsg();
      localSuspiciousHolder.jdField_c_of_type_Long = paramMessageRecord.uniseq;
      n = 2;
      if (paramMessageRecord != null) {
        n = ((MessageForSystemMsg)paramMessageRecord).getSystemMsg().msg_type.get();
      }
    } while (n != 2);
    structmsg.StructMsg localStructMsg;
    label208:
    String str;
    label292:
    Object localObject1;
    if (paramInt < this.jdField_j_of_type_Int)
    {
      TroopSuspiciousHelper.a(paramViewHolder.a(), true);
      localStructMsg = localSuspiciousHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
      localSuspiciousHolder.jdField_a_of_type_Long = paramInt;
      localSuspiciousHolder.jdField_a_of_type_JavaLangString = (localStructMsg.req_uin.get() + "");
      localSuspiciousHolder.jdField_a_of_type_Int = localStructMsg.msg.group_msg_type.get();
      paramInt = localStructMsg.msg.sub_type.get();
      localSuspiciousHolder.jdField_b_of_type_Long = localStructMsg.msg_time.get();
      localSuspiciousHolder.jdField_b_of_type_JavaLangString = localStructMsg.msg.req_uin_nick.get();
      if ((localSuspiciousHolder.jdField_b_of_type_JavaLangString == null) || (localSuspiciousHolder.jdField_b_of_type_JavaLangString.equals(""))) {
        break label740;
      }
      a(localSuspiciousHolder, localStructMsg);
      localSuspiciousHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      str = localStructMsg.msg.group_info.msg_alert.get();
      paramMessageRecord = "";
      if (localStructMsg.msg.bytes_warning_tips.get() != null) {
        paramMessageRecord = localStructMsg.msg.bytes_warning_tips.get().toStringUtf8();
      }
      if (!TextUtils.isEmpty(paramMessageRecord)) {
        break label753;
      }
      localSuspiciousHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      if (localSuspiciousHolder.jdField_a_of_type_Int != 22) {
        break label832;
      }
      paramMessageRecord = localStructMsg.msg;
      localSuspiciousHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      localObject1 = new SpannableString(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131719693, new Object[] { paramMessageRecord.action_uin_nick.get() }));
      ((SpannableString)localObject1).setSpan(new ForegroundColorSpan(Color.parseColor("#00a5e0")), 6, paramMessageRecord.action_uin_nick.get().length() + 6, 33);
      localSuspiciousHolder.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      localSuspiciousHolder.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(new TroopNotifyAndRecommendView.23(this, paramMessageRecord));
    }
    for (;;)
    {
      a(((SuspiciousHolder)paramViewHolder).jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationAdapter$ApplicantHolder, localStructMsg, true);
      paramMessageRecord = TroopUtils.a(localStructMsg, localStructMsg.msg.msg_describe.get());
      if (paramMessageRecord == null) {
        break label1094;
      }
      localSuspiciousHolder.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessageRecord);
      label459:
      if (localSuspiciousHolder.jdField_a_of_type_Int != 80) {
        break label1153;
      }
      paramMessageRecord = localStructMsg.msg.actions.get();
      localSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
      localSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)paramMessageRecord.get(0)).name.get());
      localSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131755358);
      localSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839458);
      localSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.setContentDescription(localSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.getText() + "");
      localSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.setTag(localSuspiciousHolder);
      localSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
      label597:
      if (!TextUtils.isEmpty(localSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.getText())) {
        break label1484;
      }
      localSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      label621:
      if ((paramInt == 2) && (localSuspiciousHolder.jdField_a_of_type_Int == 2) && (((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(String.valueOf(localStructMsg.msg.group_code.get())) != null)) {
        TroopRemindSettingManager.a().b(String.valueOf(localStructMsg.msg.group_code.get()), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      localSuspiciousHolder.jdField_a_of_type_AndroidWidgetLinearLayout.setTag(paramViewHolder);
      localSuspiciousHolder.jdField_a_of_type_AndroidWidgetImageView.setTag(paramViewHolder);
      localSuspiciousHolder.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
      a(localSuspiciousHolder);
      return;
      TroopSuspiciousHelper.a(paramViewHolder.a(), false);
      break;
      label740:
      localSuspiciousHolder.jdField_b_of_type_JavaLangString = localSuspiciousHolder.jdField_a_of_type_JavaLangString;
      break label208;
      label753:
      localSuspiciousHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      localSuspiciousHolder.jdField_c_of_type_AndroidWidgetTextView.setText(paramMessageRecord);
      paramMessageRecord = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130848172);
      paramMessageRecord.setBounds(0, 0, ViewUtils.a(16.0F), ViewUtils.a(16.0F));
      localSuspiciousHolder.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(ViewUtils.a(5.0F));
      localSuspiciousHolder.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawables(paramMessageRecord, null, null, null);
      break label292;
      label832:
      if ((localSuspiciousHolder.jdField_a_of_type_Int == 2) && (localStructMsg.msg.msg_invite_extinfo.uint32_src_type.has()))
      {
        localObject1 = "";
        switch (localStructMsg.msg.msg_invite_extinfo.uint32_src_type.get())
        {
        }
      }
    }
    paramMessageRecord = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if (paramMessageRecord != null) {}
    for (paramMessageRecord = paramMessageRecord.a(String.valueOf(localStructMsg.msg.msg_invite_extinfo.uint64_src_code.get()));; paramMessageRecord = "")
    {
      localSuspiciousHolder.jdField_c_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131707611) + paramMessageRecord);
      localSuspiciousHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      break;
      Object localObject2 = (DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
      paramMessageRecord = (MessageRecord)localObject1;
      if (localObject2 != null)
      {
        localObject2 = ((DiscussionManager)localObject2).a(String.valueOf(localStructMsg.msg.msg_invite_extinfo.uint64_src_code.get()));
        paramMessageRecord = (MessageRecord)localObject1;
        if (localObject2 != null) {
          paramMessageRecord = ((DiscussionInfo)localObject2).discussionName;
        }
      }
      localSuspiciousHolder.jdField_c_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131707600) + paramMessageRecord);
      localSuspiciousHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      break;
      label1094:
      paramMessageRecord = localStructMsg.msg.msg_additional.get();
      if ((paramMessageRecord == null) || ("".equals(paramMessageRecord)))
      {
        localSuspiciousHolder.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131696171));
        break label459;
      }
      localSuspiciousHolder.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessageRecord);
      break label459;
      label1153:
      if (paramInt == 1)
      {
        paramMessageRecord = localStructMsg.msg.actions.get();
        localSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
        if ((paramMessageRecord != null) && (paramMessageRecord.size() > 0))
        {
          if ((str == null) || ("".equals(str))) {
            if (paramMessageRecord.size() > 1)
            {
              localSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)paramMessageRecord.get(1)).name.get());
              localSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131755358);
              localSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839458);
            }
          }
          for (;;)
          {
            localSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.setContentDescription(localSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.getText() + "");
            localSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.setTag(paramViewHolder);
            localSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
            break;
            localSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.setText("");
            continue;
            localSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)paramMessageRecord.get(0)).name.get());
            localSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131755357);
            localSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839457);
          }
        }
        localSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.setText("");
        localSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(null);
        break label597;
      }
      localSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(null);
      localSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.setClickable(false);
      localSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131755991);
      localSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.setText(localStructMsg.msg.msg_decided.get());
      paramMessageRecord = (RelativeLayout.LayoutParams)localSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.getLayoutParams();
      break label597;
      label1484:
      localSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      break label621;
    }
  }
  
  private void a(NotificationAdapter.ApplicantHolder paramApplicantHolder, structmsg.StructMsg paramStructMsg, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (paramApplicantHolder == null) || (paramStructMsg == null) || (paramApplicantHolder.jdField_a_of_type_AndroidViewView == null)) {}
    label271:
    label322:
    label613:
    label746:
    label748:
    label755:
    label759:
    for (;;)
    {
      return;
      TroopNotificationManager localTroopNotificationManager = (TroopNotificationManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_NOTIFICATION_MANAGER);
      if (localTroopNotificationManager != null)
      {
        int n = paramStructMsg.msg.group_msg_type.get();
        if ((TroopNotifyHelper.b(n)) || (paramBoolean))
        {
          long l1;
          if (n == 2)
          {
            if (!paramStructMsg.msg.has()) {
              break label755;
            }
            l1 = paramStructMsg.msg.action_uin.get();
          }
          for (;;)
          {
            if (l1 <= 0L) {
              break label759;
            }
            TroopNotifyApplicantInfo localTroopNotifyApplicantInfo = localTroopNotificationManager.a(Long.valueOf(l1));
            if (localTroopNotifyApplicantInfo == null)
            {
              localTroopNotificationManager.a(Long.valueOf(l1));
              localTroopNotificationManager.b(Long.valueOf(l1));
              if (this.jdField_l_of_type_Boolean) {
                break;
              }
              paramApplicantHolder = new Message();
              paramApplicantHolder.what = 1016;
              this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(paramApplicantHolder, 2000L);
              this.jdField_l_of_type_Boolean = true;
              return;
              l1 = paramStructMsg.req_uin.get();
              continue;
            }
            paramApplicantHolder.jdField_a_of_type_AndroidViewView.setVisibility(0);
            Object localObject;
            String str1;
            String str2;
            if (localTroopNotifyApplicantInfo.a())
            {
              n = localTroopNotifyApplicantInfo.b();
              paramStructMsg = localTroopNotifyApplicantInfo.c();
              localObject = localTroopNotifyApplicantInfo.a();
              str1 = localTroopNotifyApplicantInfo.b();
              str2 = String.valueOf(localTroopNotifyApplicantInfo.a());
              if (localTroopNotifyApplicantInfo.c())
              {
                paramApplicantHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
                if ((paramStructMsg == null) || (paramStructMsg.isEmpty())) {
                  break label556;
                }
              }
            }
            for (;;)
            {
              int i1;
              if (!paramStructMsg.isEmpty())
              {
                paramStructMsg = "在" + paramStructMsg;
                if (paramApplicantHolder.jdField_b_of_type_AndroidWidgetTextView != null)
                {
                  paramApplicantHolder.jdField_b_of_type_AndroidWidgetTextView.setText(paramStructMsg);
                  paramApplicantHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                }
                if (paramApplicantHolder.jdField_a_of_type_AndroidWidgetLinearLayout != null)
                {
                  if ((str2.isEmpty()) || ((n != 1) && (n != 2))) {
                    break label640;
                  }
                  paramStructMsg = (TextView)paramApplicantHolder.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131374130);
                  localObject = (ImageView)paramApplicantHolder.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131374129);
                  if ((localObject != null) && (paramStructMsg != null))
                  {
                    if (n != 1) {
                      break label613;
                    }
                    ((ImageView)localObject).setImageResource(2130846179);
                    paramApplicantHolder.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130842643);
                    paramStructMsg.setText(str2);
                    paramApplicantHolder.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
                  }
                }
                n = 0;
                if (!localTroopNotifyApplicantInfo.b()) {
                  break label708;
                }
                i1 = localTroopNotifyApplicantInfo.c();
                paramStructMsg = "LV" + String.valueOf(i1);
                i1 = n;
                if (paramApplicantHolder.jdField_a_of_type_AndroidWidgetTextView != null)
                {
                  paramApplicantHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramStructMsg);
                  paramApplicantHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
                  i1 = n;
                }
              }
              for (;;)
              {
                if ((this.jdField_l_of_type_Boolean) || (i1 == 0)) {
                  break label746;
                }
                paramApplicantHolder = new Message();
                paramApplicantHolder.what = 1016;
                this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(paramApplicantHolder, 2000L);
                this.jdField_l_of_type_Boolean = true;
                return;
                paramApplicantHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
                break;
                if ((str1 != null) && (!str1.isEmpty()))
                {
                  paramStructMsg = str1;
                  break label271;
                }
                if ((localObject == null) || (((String)localObject).isEmpty())) {
                  break label748;
                }
                paramStructMsg = (structmsg.StructMsg)localObject;
                break label271;
                if (paramApplicantHolder.jdField_b_of_type_AndroidWidgetTextView == null) {
                  break label322;
                }
                paramApplicantHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
                break label322;
                if (n != 2) {
                  break label411;
                }
                ((ImageView)localObject).setImageResource(2130846177);
                paramApplicantHolder.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130842642);
                break label411;
                paramApplicantHolder.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
                break label425;
                i1 = 1;
                localTroopNotificationManager.a(Long.valueOf(l1));
                if (paramApplicantHolder.jdField_b_of_type_AndroidWidgetTextView != null) {
                  paramApplicantHolder.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
                }
                n = i1;
                if (paramApplicantHolder.jdField_a_of_type_AndroidWidgetLinearLayout == null) {
                  break label428;
                }
                paramApplicantHolder.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
                n = i1;
                break label428;
                n = 1;
                localTroopNotificationManager.b(Long.valueOf(l1));
                i1 = n;
                if (paramApplicantHolder.jdField_a_of_type_AndroidWidgetTextView != null)
                {
                  paramApplicantHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
                  i1 = n;
                }
              }
              break;
              paramStructMsg = "";
            }
            l1 = 0L;
          }
        }
      }
    }
  }
  
  private void a(NotificationAdapter.ViewHolder paramViewHolder, structmsg.StructMsg paramStructMsg)
  {
    String str = TroopUtils.a(paramStructMsg, paramStructMsg.msg.msg_describe.get());
    if (paramViewHolder.jdField_a_of_type_Int == 91)
    {
      b(paramViewHolder);
      return;
    }
    if (str != null)
    {
      paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(str);
      return;
    }
    paramStructMsg = paramStructMsg.msg.msg_additional.get();
    if ((paramStructMsg == null) || ("".equals(paramStructMsg)))
    {
      paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131696171));
      return;
    }
    paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(paramStructMsg);
  }
  
  private void a(NotificationAdapter.ViewHolder paramViewHolder, structmsg.StructMsg paramStructMsg, int paramInt)
  {
    if (!(paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityContactTroopGeneralgroupnotifyparserGeneralGroupNotifyParser$GeneralGroupNotifyInfo instanceof AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo))
    {
      paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      return;
    }
    AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo localAllianceGeneralGroupNotifyInfo = (AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityContactTroopGeneralgroupnotifyparserGeneralGroupNotifyParser$GeneralGroupNotifyInfo;
    if (localAllianceGeneralGroupNotifyInfo.jdField_c_of_type_Int == 1) {
      if ((localAllianceGeneralGroupNotifyInfo.jdField_a_of_type_Int == 1) && (paramInt == 1))
      {
        paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
        paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131755358);
        paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839458);
        paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131699424));
        paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setContentDescription(paramViewHolder.jdField_a_of_type_AndroidWidgetButton.getText() + "");
        paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setTag(paramViewHolder);
        paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      }
    }
    for (;;)
    {
      paramStructMsg = (RelativeLayout.LayoutParams)paramViewHolder.jdField_a_of_type_AndroidWidgetButton.getLayoutParams();
      if (paramStructMsg != null)
      {
        paramStructMsg.addRule(11);
        paramStructMsg.rightMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 16.0F);
        paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setLayoutParams(paramStructMsg);
      }
      paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      return;
      paramStructMsg = "";
      if (paramInt == 2) {
        paramStructMsg = this.jdField_a_of_type_AndroidContentContext.getString(2131699421);
      }
      for (;;)
      {
        paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(null);
        paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setClickable(false);
        paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131755991);
        paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setText(paramStructMsg);
        break;
        if (paramInt == 3) {
          paramStructMsg = this.jdField_a_of_type_AndroidContentContext.getString(2131699423);
        } else if (paramInt == 4) {
          paramStructMsg = this.jdField_a_of_type_AndroidContentContext.getString(2131699422);
        }
      }
      if (localAllianceGeneralGroupNotifyInfo.jdField_c_of_type_Int == 2)
      {
        paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(null);
        paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setClickable(false);
        paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131755991);
        paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setText(paramStructMsg.msg.msg_decided.get());
      }
      else
      {
        QLog.d("TroopNotifyAndRecommendView", 2, "setSecondLineText reqSubMsgType:" + localAllianceGeneralGroupNotifyInfo.jdField_c_of_type_Int);
      }
    }
  }
  
  private void a(NotificationAdapter.ViewHolder paramViewHolder, structmsg.StructMsg paramStructMsg, int paramInt, String paramString)
  {
    if (paramViewHolder.jdField_a_of_type_Int == 91)
    {
      a(paramViewHolder, paramStructMsg, paramInt);
      return;
    }
    if (paramViewHolder.jdField_a_of_type_Int == 80)
    {
      paramStructMsg = paramStructMsg.msg.actions.get();
      paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
      paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)paramStructMsg.get(0)).name.get());
      paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131755358);
      paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839458);
      paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setContentDescription(paramViewHolder.jdField_a_of_type_AndroidWidgetButton.getText() + "");
      paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setTag(paramViewHolder);
      paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    }
    for (;;)
    {
      paramStructMsg = (RelativeLayout.LayoutParams)paramViewHolder.jdField_a_of_type_AndroidWidgetButton.getLayoutParams();
      if (paramStructMsg != null)
      {
        paramStructMsg.addRule(11);
        paramStructMsg.rightMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 16.0F);
        paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setLayoutParams(paramStructMsg);
      }
      if (!TextUtils.isEmpty(paramViewHolder.jdField_a_of_type_AndroidWidgetButton.getText())) {
        break label507;
      }
      paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      return;
      if (paramInt != 1) {
        break;
      }
      paramStructMsg = paramStructMsg.msg.actions.get();
      paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
      if ((paramStructMsg != null) && (paramStructMsg.size() > 0))
      {
        if ((paramString == null) || ("".equals(paramString))) {
          if (paramStructMsg.size() > 1)
          {
            paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)paramStructMsg.get(1)).name.get());
            paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131755358);
            paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839458);
          }
        }
        for (;;)
        {
          paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setContentDescription(paramViewHolder.jdField_a_of_type_AndroidWidgetButton.getText() + "");
          paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setTag(paramViewHolder);
          paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
          break;
          paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setText("");
          continue;
          paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)paramStructMsg.get(0)).name.get());
          paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131755357);
          paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839457);
        }
      }
      paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setText("");
      paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(null);
    }
    paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(null);
    paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setClickable(false);
    paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131755991);
    paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setText(paramStructMsg.msg.msg_decided.get());
    return;
    label507:
    paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
  }
  
  private void a(NotificationAdapter.ViewHolder paramViewHolder, structmsg.StructMsg paramStructMsg, String paramString)
  {
    if (paramViewHolder.jdField_a_of_type_Int == 91)
    {
      c(paramViewHolder);
      return;
    }
    Object localObject;
    if (paramViewHolder.jdField_a_of_type_Int == 11)
    {
      localObject = paramStructMsg.msg.msg_additional.get();
      paramString = (String)localObject;
      if (((String)localObject).length() > 15) {
        paramString = ((String)localObject).subSequence(0, 15) + "...";
      }
    }
    for (;;)
    {
      localObject = paramString;
      if (paramStructMsg.msg.pic_url.has())
      {
        if (!TextUtils.isEmpty(paramString)) {
          localObject = HardCodeUtil.a(2131715544) + paramString;
        }
      }
      else
      {
        label125:
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label512;
        }
        paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setSingleLine(true);
        paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      for (;;)
      {
        if (paramViewHolder.jdField_a_of_type_Int != 22) {
          break label524;
        }
        paramStructMsg = paramStructMsg.msg;
        paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        paramString = new SpannableString(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131719693, new Object[] { paramStructMsg.action_uin_nick.get() }));
        paramString.setSpan(new ForegroundColorSpan(Color.parseColor("#00a5e0")), 5, paramStructMsg.action_uin_nick.get().length() + 6, 33);
        paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText(paramString);
        paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(new TroopNotifyAndRecommendView.11(this, paramStructMsg));
        return;
        if ((!TextUtils.isEmpty(paramString)) && ((paramViewHolder.jdField_a_of_type_Int == 1) || (paramViewHolder.jdField_a_of_type_Int == 22)))
        {
          paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131755993);
          break;
        }
        localObject = new ArrayList();
        ((List)localObject).add(paramStructMsg.msg.msg_qna.get());
        if (paramStructMsg.msg.msg_actor_describe.get() != null) {}
        for (paramString = TroopUtils.a(paramStructMsg, paramStructMsg.msg.msg_actor_describe.get());; paramString = "")
        {
          ((List)localObject).add(paramString);
          ((List)localObject).add(paramStructMsg.msg.msg_additional_list.get());
          ((List)localObject).add(paramStructMsg.msg.msg_additional.get());
          if ((paramViewHolder.jdField_a_of_type_Int == 12) || (paramViewHolder.jdField_a_of_type_Int == 83)) {
            ((List)localObject).add(paramStructMsg.msg.msg_detail.get());
          }
          localObject = ((List)localObject).iterator();
          do
          {
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            paramString = (String)((Iterator)localObject).next();
          } while ((paramString == null) || (paramString.isEmpty()));
          break;
        }
        localObject = HardCodeUtil.a(2131715545);
        break label125;
        label512:
        paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      label524:
      if ((paramViewHolder.jdField_a_of_type_Int != 2) || (!paramStructMsg.msg.msg_invite_extinfo.uint32_src_type.has())) {
        break;
      }
      localObject = "";
      switch (paramStructMsg.msg.msg_invite_extinfo.uint32_src_type.get())
      {
      case 0: 
      default: 
        return;
      case 1: 
        paramString = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        if (paramString == null) {
          break;
        }
      }
      for (paramStructMsg = paramString.a(String.valueOf(paramStructMsg.msg.msg_invite_extinfo.uint64_src_code.get()));; paramStructMsg = "")
      {
        paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131715548) + paramStructMsg);
        paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        return;
        DiscussionManager localDiscussionManager = (DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
        paramString = (String)localObject;
        if (localDiscussionManager != null)
        {
          paramStructMsg = localDiscussionManager.a(String.valueOf(paramStructMsg.msg.msg_invite_extinfo.uint64_src_code.get()));
          paramString = (String)localObject;
          if (paramStructMsg != null) {
            paramString = paramStructMsg.discussionName;
          }
        }
        paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131715546) + paramString);
        paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        return;
      }
      paramString = "";
    }
  }
  
  private void a(SuspiciousHolder paramSuspiciousHolder)
  {
    int n = 1;
    if (paramSuspiciousHolder == null) {
      return;
    }
    Object localObject;
    String str;
    switch (TroopNotificationUtils.a(paramSuspiciousHolder.jdField_a_of_type_Int))
    {
    default: 
      localObject = String.valueOf(paramSuspiciousHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get());
      n = 4;
      str = paramSuspiciousHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_name.get() + this.jdField_a_of_type_AndroidContentContext.getString(2131696499);
    }
    for (;;)
    {
      localObject = TroopNotificationUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder, (String)localObject, n);
      paramSuspiciousHolder.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(str);
      paramSuspiciousHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      return;
      localObject = paramSuspiciousHolder.jdField_a_of_type_JavaLangString;
      str = paramSuspiciousHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get() + this.jdField_a_of_type_AndroidContentContext.getString(2131696498);
      continue;
      localObject = String.valueOf(paramSuspiciousHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get());
      str = paramSuspiciousHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin_nick.get() + this.jdField_a_of_type_AndroidContentContext.getString(2131696497);
    }
  }
  
  private void a(SuspiciousHolder paramSuspiciousHolder, structmsg.StructMsg paramStructMsg)
  {
    if ((paramSuspiciousHolder == null) || (paramStructMsg == null)) {
      return;
    }
    if ((paramSuspiciousHolder.jdField_a_of_type_Int == 2) && (paramStructMsg.msg.msg_invite_extinfo.uint32_src_type.has()))
    {
      String str1 = paramStructMsg.msg.action_uin_qq_nick.get().toStringUtf8();
      switch (paramStructMsg.msg.msg_invite_extinfo.uint32_src_type.get())
      {
      default: 
        paramStructMsg = str1;
      }
      for (;;)
      {
        paramSuspiciousHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramStructMsg);
        return;
        paramStructMsg = paramStructMsg.msg.action_uin_nick.get();
        continue;
        Object localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        if (localObject == null) {
          break;
        }
        String str2 = String.valueOf(paramStructMsg.msg.msg_invite_extinfo.uint64_src_code.get());
        String str3 = String.valueOf(paramStructMsg.msg.action_uin.get());
        paramStructMsg = ((TroopManager)localObject).d(str2);
        str1 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str3, str2, paramStructMsg, true, null);
        paramStructMsg = str1;
        if (TextUtils.isEmpty(str1))
        {
          paramStructMsg = ((TroopManager)localObject).a(str2, str3);
          continue;
          localObject = (DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
          if (localObject == null) {
            break;
          }
          paramStructMsg = ((DiscussionManager)localObject).a(String.valueOf(paramStructMsg.msg.msg_invite_extinfo.uint64_src_code.get()), String.valueOf(paramStructMsg.msg.action_uin.get()));
          if (paramStructMsg == null) {
            break;
          }
          paramStructMsg = paramStructMsg.getDiscussionMemberName();
        }
      }
    }
    switch (TroopNotificationUtils.a(paramSuspiciousHolder.jdField_a_of_type_Int))
    {
    default: 
      paramSuspiciousHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramSuspiciousHolder.jdField_b_of_type_JavaLangString);
      return;
    case 0: 
      paramSuspiciousHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramStructMsg.msg.group_name.get());
      return;
    case 1: 
      paramSuspiciousHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramStructMsg.msg.action_uin_nick.get());
      return;
    }
    paramSuspiciousHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramSuspiciousHolder.jdField_b_of_type_JavaLangString);
  }
  
  private void a(structmsg.StructMsg paramStructMsg, long paramLong)
  {
    if (paramStructMsg != null)
    {
      String str = ((structmsg.StructMsg)paramStructMsg.get()).msg_seq.get() + "_" + ((structmsg.StructMsg)paramStructMsg.get()).msg_type.get();
      GroupSystemMsgController.a().a(str, (structmsg.StructMsg)paramStructMsg.get());
      GroupSystemMsgController.a().b(str);
      GroupSystemMsgController.a().a(paramLong);
    }
  }
  
  private boolean a(int paramInt, structmsg.StructMsg paramStructMsg)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    int n;
    long l1;
    long l2;
    int i1;
    int i2;
    int i3;
    int i4;
    if (paramStructMsg != null)
    {
      n = paramStructMsg.msg_type.get();
      l1 = paramStructMsg.msg_seq.get();
      l2 = paramStructMsg.req_uin.get();
      i1 = paramStructMsg.msg.sub_type.get();
      i2 = paramStructMsg.msg.src_id.get();
      i3 = paramStructMsg.msg.sub_src_id.get();
      i4 = paramStructMsg.msg.group_msg_type.get();
      localObject = paramStructMsg.msg.actions.get();
      if ((localObject == null) || (paramInt >= ((List)localObject).size())) {
        break label235;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a().a(n, l1, l2, i1, i2, i3, i4, (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)((List)localObject).get(paramInt)).action_info.get(), paramInt);
      bool1 = true;
      bool2 = bool1;
      if (i2 == 116)
      {
        bool2 = bool1;
        if (i3 == 0)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_discuss", "", "verify_msg", "Clk_agree", 0, 0, String.valueOf(paramStructMsg.msg.group_code.get()), "", "", "");
          bool2 = bool1;
        }
      }
    }
    return bool2;
    label235:
    Object localObject = new structmsg.SystemMsgActionInfo();
    if (paramInt == 0) {
      ((structmsg.SystemMsgActionInfo)localObject).type.set(11);
    }
    for (;;)
    {
      ((structmsg.SystemMsgActionInfo)localObject).group_code.set(paramStructMsg.msg.group_code.get());
      ((structmsg.SystemMsgActionInfo)localObject).sig.set(ByteStringMicro.EMPTY);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a().a(n, l1, l2, i1, i2, i3, i4, (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgActionInfo)localObject).get(), paramInt);
      break;
      if (paramInt == 1) {
        ((structmsg.SystemMsgActionInfo)localObject).type.set(12);
      } else if (paramInt == 2) {
        ((structmsg.SystemMsgActionInfo)localObject).type.set(14);
      }
    }
  }
  
  private boolean a(List<Stranger> paramList, String paramString)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      do
      {
        if (!paramList.hasNext()) {
          break;
        }
      } while (!TextUtils.equals(((Stranger)paramList.next()).uin, paramString));
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotifyAndRecommendView", 2, "checkInviteeIsFriend stranger list is empty ");
    }
    return false;
  }
  
  private void b(NotificationAdapter.ViewHolder paramViewHolder)
  {
    if (!(paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityContactTroopGeneralgroupnotifyparserGeneralGroupNotifyParser$GeneralGroupNotifyInfo instanceof AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo))
    {
      paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo localAllianceGeneralGroupNotifyInfo = (AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityContactTroopGeneralgroupnotifyparserGeneralGroupNotifyParser$GeneralGroupNotifyInfo;
    if (localAllianceGeneralGroupNotifyInfo.jdField_c_of_type_Int == 1) {
      paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131699419) + " " + this.jdField_a_of_type_AndroidContentContext.getString(2131699417));
    }
    for (;;)
    {
      paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
      if (localAllianceGeneralGroupNotifyInfo.jdField_c_of_type_Int == 2)
      {
        if (localAllianceGeneralGroupNotifyInfo.jdField_a_of_type_Int == 2) {
          paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131699426) + " " + this.jdField_a_of_type_AndroidContentContext.getString(2131699416));
        } else if (localAllianceGeneralGroupNotifyInfo.jdField_a_of_type_Int == 3) {
          paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131699428) + " " + this.jdField_a_of_type_AndroidContentContext.getString(2131699416));
        }
      }
      else {
        QLog.d("TroopNotifyAndRecommendView", 2, "setSecondLineText reqSubMsgType:" + paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityContactTroopGeneralgroupnotifyparserGeneralGroupNotifyParser$GeneralGroupNotifyInfo.jdField_c_of_type_Int);
      }
    }
  }
  
  private void b(NotificationAdapter.ViewHolder paramViewHolder, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotifyAndRecommendView", 2, "jumpToTroopRequestActivity!" + paramViewHolder.jdField_a_of_type_Long + ": dealMsgType = " + paramInt);
    }
    Intent localIntent = new Intent(a(), TroopRequestActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putLong("troopMsgId", paramViewHolder.jdField_a_of_type_Long);
    localBundle.putInt("mTroopMsgType", paramViewHolder.jdField_a_of_type_Int);
    localBundle.putString("mTroopCode", String.valueOf(paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get()));
    localBundle.putString("troopmanagerUin", String.valueOf(paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get()));
    localBundle.putString("troopsMsg", paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get());
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter != null) && (paramViewHolder.jdField_b_of_type_Int < this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter.jdField_a_of_type_Int)) {}
    for (boolean bool = true;; bool = false)
    {
      localBundle.putBoolean("is_unread", bool);
      localBundle.putString("troopRequestUin", String.valueOf(paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()));
      localBundle.putString("troopsummary", paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get());
      localBundle.putLong("infotime", paramViewHolder.jdField_b_of_type_Long);
      localBundle.putInt("troopfromtab", this.jdField_c_of_type_Int);
      if ((a() instanceof TroopActivity)) {
        localBundle.putBoolean("troop_invitee_is_friend", a((ArrayList)((TroopActivity)a()).jdField_a_of_type_JavaUtilList, String.valueOf(paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get())));
      }
      if (paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() != 83) {
        localIntent.putExtra("troopMsgDealInfo", paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_detail.get());
      }
      a((structmsg.StructMsg)paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get(), paramViewHolder.jdField_c_of_type_Long);
      localBundle.putInt("t_s_f", 1001);
      localIntent.putExtras(localBundle);
      a(localIntent);
      return;
    }
  }
  
  private void b(NotificationAdapter.ViewHolder paramViewHolder, structmsg.StructMsg paramStructMsg)
  {
    if ((paramViewHolder == null) || (paramStructMsg == null)) {
      return;
    }
    if ((paramViewHolder.jdField_a_of_type_Int == 91) && ((paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityContactTroopGeneralgroupnotifyparserGeneralGroupNotifyParser$GeneralGroupNotifyInfo instanceof AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)))
    {
      paramStructMsg = (AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityContactTroopGeneralgroupnotifyparserGeneralGroupNotifyParser$GeneralGroupNotifyInfo;
      if (!TextUtils.isEmpty(paramStructMsg.jdField_c_of_type_JavaLangString))
      {
        paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramStructMsg.jdField_c_of_type_JavaLangString);
        return;
      }
      if (paramStructMsg.jdField_c_of_type_Long > 0L)
      {
        paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(paramStructMsg.jdField_c_of_type_Long));
        return;
      }
      QLog.d("TroopNotifyAndRecommendView", 2, "setFirstLineText " + paramViewHolder.jdField_a_of_type_Int + "reqTroopName and reqTroopCode is null");
      return;
    }
    if ((paramViewHolder.jdField_a_of_type_Int == 2) && (paramStructMsg.msg.msg_invite_extinfo.uint32_src_type.has()))
    {
      String str1 = paramStructMsg.msg.action_uin_qq_nick.get().toStringUtf8();
      switch (paramStructMsg.msg.msg_invite_extinfo.uint32_src_type.get())
      {
      default: 
        paramStructMsg = str1;
      }
      for (;;)
      {
        paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramStructMsg);
        return;
        paramStructMsg = paramStructMsg.msg.action_uin_nick.get();
        continue;
        Object localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        if (localObject == null) {
          break;
        }
        String str2 = String.valueOf(paramStructMsg.msg.msg_invite_extinfo.uint64_src_code.get());
        String str3 = String.valueOf(paramStructMsg.msg.action_uin.get());
        paramStructMsg = ((TroopManager)localObject).d(str2);
        str1 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str3, str2, paramStructMsg, true, null);
        paramStructMsg = str1;
        if (TextUtils.isEmpty(str1))
        {
          paramStructMsg = ((TroopManager)localObject).a(str2, str3);
          continue;
          localObject = (DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
          if (localObject == null) {
            break;
          }
          paramStructMsg = ((DiscussionManager)localObject).a(String.valueOf(paramStructMsg.msg.msg_invite_extinfo.uint64_src_code.get()), String.valueOf(paramStructMsg.msg.action_uin.get()));
          if (paramStructMsg == null) {
            break;
          }
          paramStructMsg = paramStructMsg.getDiscussionMemberName();
        }
      }
    }
    switch (TroopNotificationUtils.a(paramViewHolder.jdField_a_of_type_Int))
    {
    default: 
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramViewHolder.jdField_b_of_type_JavaLangString);
      return;
    case 0: 
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramStructMsg.msg.group_name.get());
      return;
    case 1: 
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramStructMsg.msg.action_uin_nick.get());
      return;
    }
    paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramViewHolder.jdField_b_of_type_JavaLangString);
  }
  
  private void b(SuspiciousHolder paramSuspiciousHolder)
  {
    if (paramSuspiciousHolder == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotifyAndRecommendView", 2, "jumpToTroopRequestActivity!" + paramSuspiciousHolder.jdField_a_of_type_Long);
    }
    TroopSuspiciousHelper.a(paramSuspiciousHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, "unnormal_edit");
    Intent localIntent = new Intent(a(), TroopRequestActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putLong("troopMsgId", paramSuspiciousHolder.jdField_a_of_type_Long);
    localBundle.putInt("mTroopMsgType", paramSuspiciousHolder.jdField_a_of_type_Int);
    localBundle.putString("mTroopCode", String.valueOf(paramSuspiciousHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get()));
    localBundle.putString("troopmanagerUin", String.valueOf(paramSuspiciousHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get()));
    localBundle.putString("troopsMsg", paramSuspiciousHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get());
    int n = GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (paramSuspiciousHolder.jdField_b_of_type_Int < n) {}
    for (boolean bool = true;; bool = false)
    {
      localBundle.putBoolean("is_unread", bool);
      localBundle.putString("troopRequestUin", String.valueOf(paramSuspiciousHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()));
      localBundle.putString("troopsummary", paramSuspiciousHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get());
      localBundle.putLong("infotime", paramSuspiciousHolder.jdField_b_of_type_Long);
      if ((a() instanceof TroopActivity)) {
        localBundle.putBoolean("troop_invitee_is_friend", a((ArrayList)((TroopActivity)a()).jdField_a_of_type_JavaUtilList, String.valueOf(paramSuspiciousHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get())));
      }
      if (paramSuspiciousHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() != 83) {
        localIntent.putExtra("troopMsgDealInfo", paramSuspiciousHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_detail.get());
      }
      TroopSuspiciousHelper.a((structmsg.StructMsg)paramSuspiciousHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get());
      a((structmsg.StructMsg)paramSuspiciousHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get(), paramSuspiciousHolder.jdField_c_of_type_Long);
      localBundle.putInt("t_s_f", 1001);
      localBundle.putBoolean("troop_suspicious_request", true);
      localIntent.putExtras(localBundle);
      a(localIntent);
      return;
    }
  }
  
  private boolean b(int paramInt, structmsg.StructMsg paramStructMsg)
  {
    boolean bool = false;
    int i2;
    int i3;
    if (paramStructMsg != null)
    {
      int n = paramStructMsg.msg_type.get();
      long l1 = paramStructMsg.msg_seq.get();
      long l2 = paramStructMsg.req_uin.get();
      int i1 = paramStructMsg.msg.sub_type.get();
      i2 = paramStructMsg.msg.src_id.get();
      i3 = paramStructMsg.msg.sub_src_id.get();
      int i4 = paramStructMsg.msg.group_msg_type.get();
      Object localObject = paramStructMsg.msg.actions.get();
      if ((localObject == null) || (paramInt >= ((List)localObject).size())) {
        break label230;
      }
      localObject = (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)((List)localObject).get(paramInt)).action_info.get();
      ((structmsg.SystemMsgActionInfo)localObject).uint32_req_msg_type.set(2);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a().a(n, l1, l2, i1, i2, i3, i4, (structmsg.SystemMsgActionInfo)localObject, paramInt);
    }
    label230:
    for (bool = true;; bool = false)
    {
      if ((i2 == 116) && (i3 == 0)) {
        ReportController.b(null, "P_CliOper", "Grp_discuss", "", "verify_msg", "Clk_agree", 0, 0, String.valueOf(paramStructMsg.msg.group_code.get()), "", "", "");
      }
      return bool;
    }
  }
  
  private void c(NotificationAdapter.ViewHolder paramViewHolder)
  {
    if (!(paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityContactTroopGeneralgroupnotifyparserGeneralGroupNotifyParser$GeneralGroupNotifyInfo instanceof AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo))
    {
      paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    Object localObject = (AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityContactTroopGeneralgroupnotifyparserGeneralGroupNotifyParser$GeneralGroupNotifyInfo;
    String str;
    if (((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject).jdField_c_of_type_Int == 1)
    {
      str = "";
      if (!TextUtils.isEmpty(((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject).jdField_d_of_type_JavaLangString))
      {
        str = ((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject).jdField_d_of_type_JavaLangString;
        if (TextUtils.isEmpty(((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject).jdField_e_of_type_JavaLangString)) {
          break label196;
        }
        localObject = ((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject).jdField_e_of_type_JavaLangString;
        label70:
        str = this.jdField_a_of_type_AndroidContentContext.getString(2131699418) + " " + str + this.jdField_a_of_type_AndroidContentContext.getString(2131699415) + (String)localObject;
        paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText(str);
      }
    }
    for (;;)
    {
      paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
      if (((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject).jdField_d_of_type_Long > 0L)
      {
        str = String.valueOf(((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject).jdField_d_of_type_Long);
        break;
      }
      QLog.d("TroopNotifyAndRecommendView", 2, "setThirdLine " + paramViewHolder.jdField_a_of_type_Int + "reqTroopOwnerNickName is Empty");
      break;
      label196:
      if (((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject).jdField_e_of_type_Long > 0L)
      {
        localObject = String.valueOf(((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject).jdField_e_of_type_Long);
        break label70;
      }
      QLog.d("TroopNotifyAndRecommendView", 2, "setThirdLine " + paramViewHolder.jdField_a_of_type_Int + "reqSourceTroopName is Empty");
      localObject = "";
      break label70;
      if (paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityContactTroopGeneralgroupnotifyparserGeneralGroupNotifyParser$GeneralGroupNotifyInfo.jdField_c_of_type_Int == 2)
      {
        if (!TextUtils.isEmpty(((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject).jdField_b_of_type_JavaLangString)) {
          str = ((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject).jdField_b_of_type_JavaLangString;
        }
        for (;;)
        {
          paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131699412) + " " + str);
          break;
          if (((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject).jdField_b_of_type_Long > 0L)
          {
            str = String.valueOf(((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject).jdField_b_of_type_Long);
          }
          else
          {
            QLog.d("TroopNotifyAndRecommendView", 2, "setThirdLine " + paramViewHolder.jdField_a_of_type_Int + "actionName is Empty");
            str = "";
          }
        }
      }
      QLog.d("TroopNotifyAndRecommendView", 2, "setThirdLine " + paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityContactTroopGeneralgroupnotifyparserGeneralGroupNotifyParser$GeneralGroupNotifyInfo.jdField_c_of_type_Int + "reqSubMsgType is error value");
    }
  }
  
  private void d(NotificationAdapter.ViewHolder paramViewHolder)
  {
    int i1 = 1;
    if (paramViewHolder == null) {
      return;
    }
    int n = TroopNotificationUtils.a(paramViewHolder.jdField_a_of_type_Int);
    if (paramViewHolder.jdField_a_of_type_Int == 91) {
      n = 3;
    }
    long l1;
    String str;
    Object localObject;
    switch (n)
    {
    default: 
      l1 = paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get();
      str = paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_name.get() + this.jdField_a_of_type_AndroidContentContext.getString(2131696499);
      localObject = String.valueOf(l1);
      n = 4;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = ImageUtil.c();
      }
      localObject = FaceDrawable.getFaceDrawable((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), n, (String)localObject, 3, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(str);
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      return;
      localObject = paramViewHolder.jdField_a_of_type_JavaLangString;
      str = paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get() + this.jdField_a_of_type_AndroidContentContext.getString(2131696498);
      n = i1;
      continue;
      localObject = String.valueOf(paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get());
      str = paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin_nick.get() + this.jdField_a_of_type_AndroidContentContext.getString(2131696497);
      n = i1;
      continue;
      if ((paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityContactTroopGeneralgroupnotifyparserGeneralGroupNotifyParser$GeneralGroupNotifyInfo instanceof AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo))
      {
        localObject = (AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityContactTroopGeneralgroupnotifyparserGeneralGroupNotifyParser$GeneralGroupNotifyInfo;
        l1 = ((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject).jdField_c_of_type_Long;
        str = ((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject).jdField_c_of_type_JavaLangString;
        localObject = String.valueOf(l1);
        n = 4;
      }
      else
      {
        str = null;
        n = -1;
        localObject = null;
      }
    }
  }
  
  private void r()
  {
    TroopNotificationManager localTroopNotificationManager = (TroopNotificationManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_NOTIFICATION_MANAGER);
    if (localTroopNotificationManager == null) {
      return;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_contacts_news", "", "notice", "todo_tab_clk", 0, 0, "", "", "", "");
    localTroopNotificationManager.a(false);
    a(false, 1);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopSlideAndOverScrollRecyclerView.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setVisibility(0);
    if (this.jdField_c_of_type_Int != 1)
    {
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      }
      setType(1);
      a(true);
      ArrayList localArrayList = new ArrayList();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter.b(localArrayList);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter.notifyDataSetChanged();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter.a(localTroopNotificationManager.a(1));
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter.notifyDataSetChanged();
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    setType(0);
    a(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter.a(localTroopNotificationManager.a(0));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter.jdField_a_of_type_Int = GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if ((this.jdField_c_of_type_JavaUtilList != null) && (this.jdField_c_of_type_JavaUtilList.size() > 0)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter.b(this.jdField_c_of_type_JavaUtilList);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter.notifyDataSetChanged();
  }
  
  private void s()
  {
    TroopNotificationManager localTroopNotificationManager = (TroopNotificationManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_NOTIFICATION_MANAGER);
    if (localTroopNotificationManager == null) {
      return;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_contacts_news", "", "notice", "quit_tab_clk", 0, 0, "", "", "", "");
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopSlideAndOverScrollRecyclerView.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setVisibility(0);
    if (this.jdField_c_of_type_Int != 2)
    {
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      }
      setType(2);
      b(true);
      ArrayList localArrayList = new ArrayList();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter.b(localArrayList);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter.a(localTroopNotificationManager.a(2));
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter.notifyDataSetChanged();
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    setType(0);
    b(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter.a(localTroopNotificationManager.a(0));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter.jdField_a_of_type_Int = GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if ((this.jdField_c_of_type_JavaUtilList != null) && (this.jdField_c_of_type_JavaUtilList.size() > 0)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter.b(this.jdField_c_of_type_JavaUtilList);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter.notifyDataSetChanged();
  }
  
  public static void setAndCheckNotifyFollowSeq(List<MessageRecord> paramList, QQAppInterface paramQQAppInterface)
  {
    if (paramList.size() >= 40)
    {
      paramList = (MessageRecord)paramList.get(39);
      if ((paramList instanceof MessageForSystemMsg))
      {
        paramList = ((MessageForSystemMsg)paramList).getSystemMsg();
        if ((paramList != null) && (paramList.msg_seq.has()))
        {
          long l1 = paramList.msg_seq.get();
          if (l1 > 0L) {
            paramQQAppInterface.getMsgCache().e("following_group_seq", l1);
          }
        }
      }
    }
  }
  
  private void t()
  {
    TroopNotificationManager localTroopNotificationManager = (TroopNotificationManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_NOTIFICATION_MANAGER);
    if (localTroopNotificationManager == null) {
      return;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_contacts_news", "", "notice", "unnormal_tab_clk", 0, 0, "", "", "", "");
    if (this.jdField_c_of_type_Int != 3)
    {
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopSlideAndOverScrollRecyclerView.setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setVisibility(8);
      setType(3);
      c(true);
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopSlideAndOverScrollRecyclerView.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setVisibility(0);
    setType(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter.a(localTroopNotificationManager.a(0));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter.jdField_a_of_type_Int = GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter.notifyDataSetChanged();
    c(false);
  }
  
  private void u()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    TroopNotificationManager localTroopNotificationManager;
    do
    {
      return;
      localTroopNotificationManager = (TroopNotificationManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_NOTIFICATION_MANAGER);
    } while (localTroopNotificationManager == null);
    List localList = localTroopNotificationManager.a("OidbSvc.0x5eb_troopnotifycation");
    if (localList != null) {
      localTroopNotificationManager.c(localList);
    }
    localList = localTroopNotificationManager.a("OidbSvc.0x668");
    if (localList != null) {
      localTroopNotificationManager.d(localList);
    }
    this.jdField_l_of_type_Boolean = false;
  }
  
  private void v()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    TroopNotificationManager localTroopNotificationManager = (TroopNotificationManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_NOTIFICATION_MANAGER);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter != null) {
      if (this.jdField_c_of_type_Int == 0) {
        break label117;
      }
    }
    label117:
    for (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter.jdField_a_of_type_Int = 0;; this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter.jdField_a_of_type_Int = GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppRecommendTroopManagerImp.jdField_c_of_type_Int = GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (localTroopNotificationManager != null)
      {
        c(localTroopNotificationManager.a(2));
        b(localTroopNotificationManager.a(1));
        a(false, 1);
        a(false, 2);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter.notifyDataSetChanged();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopSuspiciousAdapter == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopSuspiciousAdapter.notifyDataSetChanged();
      return;
    }
  }
  
  private void w()
  {
    int n = GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter != null)
    {
      if (!TroopNotifyHelper.b()) {
        break label85;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter.jdField_a_of_type_Int = 0;
      setType(1);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilList = ((TroopNotificationManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_NOTIFICATION_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqAppThreadExcutor$IThreadListener);
      if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty())) {
        x();
      }
      return;
      label85:
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter.jdField_a_of_type_Int = n;
    }
  }
  
  private void x()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    TroopNotificationManager localTroopNotificationManager = (TroopNotificationManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_NOTIFICATION_MANAGER);
    List localList2 = localTroopNotificationManager.a(0);
    List localList4 = localTroopNotificationManager.a(2);
    List localList3 = localTroopNotificationManager.a(1);
    if (this.jdField_c_of_type_Int == 1) {
      a(true);
    }
    for (List localList1 = localList3;; localList1 = localList2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopNotifyAndRecommendView", 2, new Object[] { "withoutExitDatas Size =", Integer.valueOf(localList2.size()), "exitDataList Size =", Integer.valueOf(localList4.size()), "undealDataList Size=", Integer.valueOf(localList3.size()) });
      }
      if ((localList2 == null) || (localList2.size() <= 0) || ((localList2.get(0) instanceof MessageForSystemMsg))) {
        break label208;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopNotifyAndRecommendView", 2, "initNotificationListData error");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.clearGroupSystemMsgHistory();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter.a(null);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter.notifyDataSetChanged();
      return;
    }
    label208:
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter.a(localList1);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter.notifyDataSetChanged();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter.a(this.jdField_a_of_type_ComTencentMobileqqAppRecommendTroopManagerImp);
    }
    c(localList4);
    b(localList3);
    if (localTroopNotificationManager.a()) {
      a(true, 1);
    }
    for (;;)
    {
      F();
      y();
      return;
      a(false, 1);
    }
  }
  
  private void y()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    do
    {
      return;
      localObject1 = (TroopNotificationManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_NOTIFICATION_MANAGER);
    } while (localObject1 == null);
    Object localObject3 = "";
    String str = "";
    List localList = ((TroopNotificationManager)localObject1).a();
    Object localObject2 = str;
    Object localObject1 = localObject3;
    Intent localIntent;
    int n;
    if ((getContext() instanceof Activity))
    {
      localIntent = ((Activity)getContext()).getIntent();
      localObject2 = str;
      localObject1 = localObject3;
      if (localIntent != null)
      {
        n = localIntent.getIntExtra("key_from", 0);
        if (n == 1)
        {
          localObject1 = "3";
          localObject2 = "1";
        }
      }
    }
    for (;;)
    {
      TroopReportor.a("Grp_contacts_news", "notice", "enter_verify", 0, 0, new String[] { localObject2, localObject1 });
      return;
      localObject2 = str;
      localObject1 = localObject3;
      if (n == 2)
      {
        localObject3 = "3";
        if (localIntent.getBooleanExtra("has_red", false))
        {
          str = "2";
          localObject2 = localObject3;
          localObject1 = str;
          if (localList == null) {
            break label340;
          }
          localObject2 = localObject3;
          localObject1 = str;
          if (localList.size() <= 0) {
            break label340;
          }
          localObject1 = (MessageRecord)localList.get(0);
          if (!(localObject1 instanceof MessageForSystemMsg)) {
            break label332;
          }
          long l1 = ((MessageForSystemMsg)localObject1).getSystemMsg().msg.group_code.get();
          localObject1 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(l1 + "");
          if (localObject1 == null) {
            break label332;
          }
          if (((TroopInfo)localObject1).isAdmin()) {
            localObject1 = "1";
          }
        }
        for (;;)
        {
          localObject2 = "2";
          break;
          localObject1 = "2";
          continue;
          localObject1 = "3";
          localObject2 = "3";
          break;
          label332:
          localObject1 = "3";
        }
      }
      label340:
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
    }
  }
  
  private void z()
  {
    ThreadManager.postImmediately(new TroopNotifyAndRecommendView.9(this), null, false);
  }
  
  public int a()
  {
    return getResources().getDimensionPixelSize(2131299166);
  }
  
  protected void a(Intent paramIntent, BaseTroopView.ITroopContext paramITroopContext)
  {
    super.a(paramIntent, paramITroopContext);
    this.jdField_a_of_type_ComTencentMobileqqAppRecommendTroopManagerImp = ((RecommendTroopManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.RECOMMEND_TROOP_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqModelTroopInfoManager = ((TroopInfoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOPINFO_MANAGER));
    i();
    b(paramIntent, paramITroopContext);
    c(paramIntent, paramITroopContext);
    this.jdField_a_of_type_AndroidWidgetTextView = paramITroopContext.a();
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_contacts_news", "", "notice", "notice_exp", 0, 0, "", "", "", "");
  }
  
  void a(NotificationAdapter.ViewHolder paramViewHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotifyAndRecommendView", 2, "handleGroupSystemMsg! start " + paramViewHolder.jdField_a_of_type_Long);
    }
    b(paramViewHolder, 998);
    Object localObject = paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_info.msg_alert.get();
    String str4 = paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get() + "";
    String str2;
    int n;
    label147:
    String str1;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter != null) && (paramViewHolder.jdField_b_of_type_Int < this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter.jdField_a_of_type_Int))
    {
      str2 = "1";
      n = paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_inviter_role.get();
      if ((n != 2) && (n != 3)) {
        break label311;
      }
      n = 0;
      switch (paramViewHolder.jdField_a_of_type_Int)
      {
      case 4: 
      case 5: 
      case 8: 
      case 9: 
      case 14: 
      case 17: 
      case 18: 
      case 19: 
      case 20: 
      case 21: 
      default: 
        paramViewHolder = "";
        localObject = "";
        str1 = "";
      }
    }
    for (;;)
    {
      TroopReportor.a("Grp_contacts_news", "notice", str1, 3, 0, new String[] { str4, str2, localObject, paramViewHolder });
      return;
      str2 = "0";
      break;
      label311:
      n = 1;
      break label147;
      str1 = "enter_askjoin";
      if ((localObject == null) || ("".equals(localObject))) {}
      for (localObject = "1";; localObject = "0")
      {
        if (paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get() != 1) {
          break label374;
        }
        paramViewHolder = "0";
        break;
      }
      label374:
      long l1 = paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actor_uin.get();
      if ((l1 != 0L) && (!(l1 + "").equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {}
      for (paramViewHolder = "2";; paramViewHolder = "1") {
        break;
      }
      paramViewHolder = "";
      localObject = "";
      str1 = "refuseask_page";
      continue;
      if (paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get() == 1) {}
      for (paramViewHolder = "0";; paramViewHolder = "1")
      {
        localObject = "";
        str1 = "enter_invite";
        break;
      }
      if (n != 0) {}
      String str3;
      for (paramViewHolder = "0";; paramViewHolder = "1")
      {
        str1 = "refuseinvite_page";
        str3 = "";
        localObject = paramViewHolder;
        paramViewHolder = str3;
        break;
      }
      if (n != 0) {}
      for (paramViewHolder = "0";; paramViewHolder = "1")
      {
        str1 = "refuseagree_page";
        str3 = "";
        localObject = paramViewHolder;
        paramViewHolder = str3;
        break;
      }
      paramViewHolder = "";
      localObject = "";
      str1 = "quit_page";
      continue;
      str1 = "byquit_page";
      paramViewHolder = "";
      localObject = "0";
      continue;
      str1 = "byquit_page";
      paramViewHolder = "";
      localObject = "1";
      continue;
      if ((paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get() + "").equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {}
      for (paramViewHolder = "0";; paramViewHolder = "1")
      {
        str1 = "set_admin_page";
        str3 = "";
        localObject = paramViewHolder;
        paramViewHolder = str3;
        break;
      }
      str1 = "un_admin_page";
      paramViewHolder = "";
      localObject = "0";
      continue;
      str1 = "un_admin_page";
      paramViewHolder = "";
      localObject = "1";
    }
  }
  
  public void a(NotificationAdapter.ViewHolder paramViewHolder, int paramInt)
  {
    int i1 = -1;
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotifyAndRecommendView", 2, "bindTroopSystemMsgView! start " + paramViewHolder.jdField_a_of_type_Long);
    }
    structmsg.StructMsg localStructMsg = paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
    paramViewHolder.jdField_a_of_type_Long = paramInt;
    paramViewHolder.jdField_a_of_type_JavaLangString = (localStructMsg.req_uin.get() + "");
    paramViewHolder.jdField_a_of_type_Int = localStructMsg.msg.group_msg_type.get();
    paramInt = localStructMsg.msg.sub_type.get();
    paramViewHolder.jdField_b_of_type_Long = localStructMsg.msg_time.get();
    paramViewHolder.jdField_b_of_type_JavaLangString = localStructMsg.msg.req_uin_nick.get();
    Object localObject;
    if ((paramViewHolder.jdField_b_of_type_JavaLangString != null) && (!paramViewHolder.jdField_b_of_type_JavaLangString.equals("")))
    {
      localObject = (TroopNotificationManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_NOTIFICATION_MANAGER);
      if (paramViewHolder.jdField_a_of_type_Int == 91) {
        paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityContactTroopGeneralgroupnotifyparserGeneralGroupNotifyParser$GeneralGroupNotifyInfo = ((TroopNotificationManager)localObject).a(91).a(localStructMsg);
      }
      if (paramViewHolder.jdField_a_of_type_Int == 2) {
        paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityContactTroopGeneralgroupnotifyparserGeneralGroupNotifyParser$GeneralGroupNotifyInfo = ((TroopNotificationManager)localObject).a(2).a(localStructMsg);
      }
      b(paramViewHolder, localStructMsg);
      a(paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationAdapter$ApplicantHolder, localStructMsg, false);
      paramViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      localObject = localStructMsg.msg.group_info.msg_alert.get();
      a(paramViewHolder, localStructMsg, (String)localObject);
      a(paramViewHolder, localStructMsg);
      a(paramViewHolder, localStructMsg, paramInt, (String)localObject);
      if ((paramInt == 2) && (paramViewHolder.jdField_a_of_type_Int == 2) && (((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(String.valueOf(localStructMsg.msg.group_code.get())) != null)) {
        TroopRemindSettingManager.a().b(String.valueOf(localStructMsg.msg.group_code.get()), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      if (localStructMsg.msg.bytes_warning_tips.get() == null) {
        break label669;
      }
      localObject = localStructMsg.msg.bytes_warning_tips.get().toStringUtf8();
      label387:
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label677;
      }
      paramViewHolder.jdField_d_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      paramViewHolder.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      label412:
      if (QLog.isColorLevel()) {
        QLog.d("Q.security_verify", 2, String.format("bindTroopSystemMsgView reqUin: %s, warningTips: %s", new Object[] { paramViewHolder.jdField_a_of_type_JavaLangString, localObject }));
      }
      paramViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout.setTag(paramViewHolder);
      paramViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setTag(paramViewHolder);
      if ((paramViewHolder.jdField_a_of_type_Int != 8) && (paramViewHolder.jdField_a_of_type_Int != 7)) {
        break label689;
      }
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setEnabled(false);
      label500:
      d(paramViewHolder);
      if (((paramViewHolder.jdField_a_of_type_Int == 1) || (paramViewHolder.jdField_a_of_type_Int == 22) || (paramViewHolder.jdField_a_of_type_Int == 60)) && (QLog.isColorLevel())) {
        if ((!localStructMsg.msg.has()) || (!localStructMsg.msg.src_id.has())) {
          break label700;
        }
      }
    }
    label669:
    label677:
    label689:
    label700:
    for (paramInt = localStructMsg.msg.src_id.get();; paramInt = -1)
    {
      int n = i1;
      if (localStructMsg.msg.has())
      {
        n = i1;
        if (localStructMsg.msg.sub_src_id.has()) {
          n = localStructMsg.msg.sub_src_id.get();
        }
      }
      QLog.i("TroopNotifyAndRecommendView", 2, String.format("joinGroup subSourceID=%d sourceID=%d msgType=%d", new Object[] { Integer.valueOf(n), Integer.valueOf(paramInt), Integer.valueOf(paramViewHolder.jdField_a_of_type_Int) }));
      return;
      paramViewHolder.jdField_b_of_type_JavaLangString = paramViewHolder.jdField_a_of_type_JavaLangString;
      break;
      localObject = "";
      break label387;
      paramViewHolder.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      break label412;
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      break label500;
    }
  }
  
  protected void a(List<RecommendTroopItem> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotifyAndRecommendView", 2, "handleRecommendDataResult: " + Log.getStackTraceString(new RuntimeException("debug trace")));
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a(new TroopNotifyAndRecommendView.20(this, paramList));
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_g_of_type_AndroidViewView == null) || (this.jdField_b_of_type_AndroidWidgetTextView == null) || (this.jdField_a_of_type_AndroidWidgetImageView == null)) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = new SpannableStringBuilder(this.jdField_b_of_type_AndroidWidgetTextView.getText());
        if ((paramBoolean) && (this.jdField_c_of_type_Int == 1))
        {
          this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16725252);
          ((SpannableStringBuilder)localObject).setSpan(new StyleSpan(1), 0, this.jdField_b_of_type_AndroidWidgetTextView.getText().length(), 18);
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          b(false);
          c(false);
          this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
          return;
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-7894119);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
      localObject = (TroopNotificationManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_NOTIFICATION_MANAGER);
    } while (localObject == null);
    b(((TroopNotificationManager)localObject).a(1));
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    TextView localTextView;
    if (1 == paramInt) {
      localTextView = this.jdField_e_of_type_AndroidWidgetTextView;
    }
    for (;;)
    {
      if (localTextView == null)
      {
        return;
        if (2 == paramInt) {
          localTextView = this.jdField_f_of_type_AndroidWidgetTextView;
        }
      }
      else
      {
        Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838065);
        localDrawable.setBounds(new Rect(0, 0, 9, 9));
        localTextView.setBackgroundResource(0);
        localTextView.setText("");
        localTextView.setCompoundDrawablesWithIntrinsicBounds(localDrawable, null, null, null);
        if ((this.jdField_c_of_type_Int == paramInt) && ((this.jdField_c_of_type_Int == 1) || (this.jdField_c_of_type_Int == 2)))
        {
          localTextView.setVisibility(8);
          return;
        }
        if (paramBoolean)
        {
          localTextView.setVisibility(0);
          return;
        }
        localTextView.setVisibility(8);
        return;
      }
      localTextView = null;
    }
  }
  
  public boolean a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      n();
      b();
      continue;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131719050);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      }
    }
  }
  
  protected int b()
  {
    int i2 = RecommendTroopManagerImp.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (i2 > 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().d(AppConstants.TROOP_NOTIFICATION_UIN, 9000, 0 - i2);
      this.jdField_a_of_type_ComTencentMobileqqAppRecommendTroopManagerImp.b();
      o();
    }
    int i1 = 0;
    int n = i1;
    if (this.jdField_a_of_type_ComTencentMobileqqAppRecommendTroopManagerImp != null)
    {
      n = i1;
      if (!this.jdField_b_of_type_Boolean)
      {
        n = i1;
        if (i2 > 0) {
          n = 1;
        }
      }
    }
    return n;
  }
  
  protected void b(Intent paramIntent, BaseTroopView.ITroopContext paramITroopContext)
  {
    a(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotificationObserver);
    a(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    C();
    w();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidContentContext, a());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
    if (TroopNotificationUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) > 0) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a().a(3);
    }
    TroopNotificationUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter.notifyDataSetChanged();
    }
    int n = GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotifyAndRecommendView", 2, "notification num:" + n);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppRecommendTroopManagerImp.jdField_c_of_type_Int = n;
    int i1 = RecommendTroopManagerImp.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().d(AppConstants.TROOP_NOTIFICATION_UIN, 9000, 0 - (n + i1));
    GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
    this.jdField_c_of_type_Boolean = false;
  }
  
  public void b(List<MessageRecord> paramList)
  {
    if ((this.jdField_g_of_type_AndroidViewView == null) || (this.jdField_b_of_type_AndroidWidgetTextView == null)) {
      return;
    }
    if ((paramList == null) || (paramList.isEmpty()))
    {
      this.jdField_g_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    int n = paramList.size();
    paramList = String.valueOf(n);
    if (n > 99) {
      paramList = "99+";
    }
    paramList = "待处理(" + paramList + ")";
    if (this.jdField_g_of_type_AndroidViewView.getVisibility() == 8) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_contacts_news", "", "notice", "todo_tab_exp", 0, 0, "", "", "", "");
    }
    if (this.jdField_c_of_type_Int == 1)
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramList);
      localSpannableStringBuilder.setSpan(new StyleSpan(1), 0, paramList.length(), 18);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(localSpannableStringBuilder);
    }
    for (;;)
    {
      this.jdField_g_of_type_AndroidViewView.setVisibility(0);
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramList);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if ((this.jdField_h_of_type_AndroidViewView == null) || (this.jdField_b_of_type_AndroidWidgetImageView == null) || (this.jdField_c_of_type_AndroidWidgetTextView == null)) {
      return;
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(this.jdField_c_of_type_AndroidWidgetTextView.getText());
    if ((paramBoolean) && (this.jdField_c_of_type_Int == 2))
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-16725252);
      localSpannableStringBuilder.setSpan(new StyleSpan(1), 0, this.jdField_c_of_type_AndroidWidgetTextView.getText().length(), 18);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      c(false);
      a(false);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(localSpannableStringBuilder);
      return;
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-7894119);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetTextView.setText("退群");
  }
  
  protected void c(Intent paramIntent, BaseTroopView.ITroopContext paramITroopContext)
  {
    super.a(paramIntent, paramITroopContext);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().addObserver(this);
    a(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
    l();
  }
  
  public void c(List<MessageRecord> paramList)
  {
    if ((this.jdField_c_of_type_AndroidWidgetTextView == null) || (this.jdField_h_of_type_AndroidViewView == null)) {
      return;
    }
    if ((paramList == null) || (paramList.isEmpty()))
    {
      this.jdField_h_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    if (this.jdField_g_of_type_AndroidViewView.getVisibility() == 8) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_contacts_news", "", "notice", "quit_tab_exp", 0, 0, "", "", "", "");
    }
    this.jdField_h_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void c(boolean paramBoolean)
  {
    if ((this.jdField_i_of_type_AndroidViewView == null) || (this.jdField_c_of_type_AndroidWidgetImageView == null) || (this.jdField_d_of_type_AndroidWidgetTextView == null)) {
      return;
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(this.jdField_d_of_type_AndroidWidgetTextView.getText());
    if ((paramBoolean) && (this.jdField_c_of_type_Int == 3))
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(-16725252);
      localSpannableStringBuilder.setSpan(new StyleSpan(1), 0, this.jdField_d_of_type_AndroidWidgetTextView.getText().length(), 33);
      this.jdField_d_of_type_AndroidWidgetTextView.setText(localSpannableStringBuilder);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      a(false);
      b(false);
      return;
    }
    this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(-7894119);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_d_of_type_AndroidWidgetTextView.setText("已过滤");
  }
  
  protected void d()
  {
    super.d();
    this.jdField_c_of_type_Boolean = false;
    if (this.jdField_j_of_type_Boolean)
    {
      TroopNotificationUtils.b();
      GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter.jdField_a_of_type_Int = 0;
        this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter.notifyDataSetChanged();
      }
      this.jdField_a_of_type_ComTencentMobileqqAppRecommendTroopManagerImp.jdField_c_of_type_Int = GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    if (this.jdField_c_of_type_Int == 3) {
      GroupSystemMsgController.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
    }
    this.jdField_j_of_type_Boolean = true;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int n = (int)paramMotionEvent.getX();
    int i1 = (int)paramMotionEvent.getY();
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      this.jdField_l_of_type_Int = i1;
      this.jdField_k_of_type_Int = n;
      return super.dispatchTouchEvent(paramMotionEvent);
      getParent().requestDisallowInterceptTouchEvent(true);
      continue;
      int i2 = n - this.jdField_k_of_type_Int;
      int i3 = i1 - this.jdField_l_of_type_Int;
      if ((i2 > 20) || (i2 < -20)) {
        this.m = true;
      }
      if (((i3 > 20) || (i3 < -20)) && (!this.m))
      {
        getParent().requestDisallowInterceptTouchEvent(false);
        continue;
        this.m = false;
      }
    }
  }
  
  protected void e()
  {
    super.e();
  }
  
  protected void f()
  {
    super.f();
    if (this.jdField_a_of_type_ComTencentMobileqqAppRecommendTroopManagerImp != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppRecommendTroopManagerImp.b();
    }
    if (this.jdField_c_of_type_Int == 3)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.pause();
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.cancelPendingRequests();
    }
  }
  
  protected void g()
  {
    super.g();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter.b();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter.a() > 0)) {
      B();
    }
    b(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
    b(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotificationObserver);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(TroopNotifyAndRecommendView.class);
    if (localObject != null) {
      ((MqqHandler)localObject).removeCallbacksAndMessages(null);
    }
    b(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter.a();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter.notifyDataSetChanged();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().deleteObserver(this);
    TroopNotificationUtils.b();
    GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
    if (this.jdField_c_of_type_Boolean) {
      GroupSystemMsgController.a().b();
    }
    GroupCatalogTool.a(a()).a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeHandler(getClass());
    if (this.jdField_a_of_type_ComTencentMobileqqSosoLocationSosoInterfaceOnLocationListener != null) {
      ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).removeOnLocationListener(this.jdField_a_of_type_ComTencentMobileqqSosoLocationSosoInterfaceOnLocationListener);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppRecommendTroopManagerImp.b();
    this.jdField_a_of_type_ComTencentMobileqqAppRecommendTroopManagerImp.d();
    this.jdField_a_of_type_ComTencentMobileqqAppRecommendTroopManagerImp.a();
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(null);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopSuspiciousAdapter != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopSuspiciousAdapter.a();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopSuspiciousAdapter.notifyDataSetChanged();
    }
    localObject = (TroopNotificationManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_NOTIFICATION_MANAGER);
    if (localObject != null) {
      ((TroopNotificationManager)localObject).a();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().d(AppConstants.TROOP_NOTIFICATION_UIN, 9000, 0 - GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
  }
  
  public void i()
  {
    a(2131560019);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter = new NotifyAndRecAdapter(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext, this);
    this.jdField_a_of_type_ComTencentWidgetSwipListView = ((SwipListView)findViewById(2131379953));
    this.jdField_f_of_type_AndroidViewView = findViewById(2131364748);
    this.jdField_g_of_type_AndroidViewView = findViewById(2131378800);
    this.jdField_h_of_type_AndroidViewView = findViewById(2131378795);
    this.jdField_i_of_type_AndroidViewView = findViewById(2131378804);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378803));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131378801));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378802));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378798));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131378796));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378797));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378805));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131378806));
    p();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopSlideAndOverScrollRecyclerView.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDragEnable(true);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setOnScrollListener(this);
    this.jdField_i_of_type_AndroidViewView.setOnClickListener(new TroopNotifyAndRecommendView.1(this));
    this.jdField_h_of_type_AndroidViewView.setOnClickListener(new TroopNotifyAndRecommendView.2(this));
    this.jdField_g_of_type_AndroidViewView.setOnClickListener(new TroopNotifyAndRecommendView.3(this));
  }
  
  public void j()
  {
    DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, null, this.jdField_a_of_type_AndroidContentContext.getString(2131720253), null, 2131690800, 2131694852, new TroopNotifyAndRecommendView.15(this), new TroopNotifyAndRecommendView.16(this)).show();
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    B();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.clearGroupSystemMsg();
    GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
    TroopNotificationManager localTroopNotificationManager = (TroopNotificationManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_NOTIFICATION_MANAGER);
    if (localTroopNotificationManager != null) {
      localTroopNotificationManager.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter.a();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter.notifyDataSetChanged();
    }
    c(null);
    b(null);
    a(false, 1);
    a(false, 2);
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1012);
  }
  
  public void l()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopNotifyAndRecommendView", 4, "onChecked........");
    }
    this.jdField_k_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getBoolean("show_new_troop_recommend", false);
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotifyAndRecommendView", 2, "getNotificationRecommendTroopList showOpen is :" + this.jdField_k_of_type_Boolean);
    }
    if ((this.jdField_g_of_type_Boolean) && (this.jdField_k_of_type_Boolean))
    {
      this.jdField_g_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqAppRecommendTroopManagerImp.a();
    }
    if ((!this.jdField_k_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter.notifyDataSetChanged();
    }
    b();
    m();
  }
  
  protected void m()
  {
    if ((this.jdField_f_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter.b()))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("TroopNotifyAndRecommendView", 4, "reportPv");
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_recom", "", "msg_page", "exp", 0, 0, "", "", "", "");
    }
  }
  
  public void n()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopNotifyAndRecommendView", 4, "refreshRecommendTroopList");
    }
    if (this.jdField_h_of_type_Boolean) {}
    while (!QLog.isDevelopLevel()) {
      return;
    }
    QLog.d("TroopNotifyAndRecommendView", 4, "refreshRecommendTroopList start ");
  }
  
  protected void o()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppRecommendTroopManagerImp != null) && (!this.jdField_b_of_type_Boolean) && (RecommendTroopManagerImp.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) > 0))
    {
      a(1, true);
      return;
    }
    a(1, false);
  }
  
  public void onClick(View paramView)
  {
    long l1 = System.currentTimeMillis();
    if ((l1 - jdField_c_of_type_Long > 0L) && (l1 - jdField_c_of_type_Long < 800L)) {}
    NotificationAdapter.ViewHolder localViewHolder;
    Object localObject2;
    int n;
    Object localObject1;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      jdField_c_of_type_Long = l1;
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131372149: 
        NearbyTroops.a(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        break;
      case 2131374117: 
        if ((paramView.getTag() instanceof NotificationAdapter.ViewHolder))
        {
          localViewHolder = (NotificationAdapter.ViewHolder)paramView.getTag();
          if (localViewHolder != null)
          {
            localObject2 = localViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
            n = localViewHolder.jdField_a_of_type_Int;
            if (TroopNotificationUtils.a(n) == 0)
            {
              localObject2 = String.valueOf(localViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get());
              localObject1 = localObject2;
              if (n == 91)
              {
                localObject1 = localObject2;
                if ((localViewHolder.jdField_a_of_type_ComTencentMobileqqActivityContactTroopGeneralgroupnotifyparserGeneralGroupNotifyParser$GeneralGroupNotifyInfo instanceof AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)) {
                  localObject1 = String.valueOf(((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localViewHolder.jdField_a_of_type_ComTencentMobileqqActivityContactTroopGeneralgroupnotifyparserGeneralGroupNotifyParser$GeneralGroupNotifyInfo).jdField_c_of_type_Long);
                }
              }
              localObject1 = TroopInfoActivity.a((String)localObject1, 4);
              ((Bundle)localObject1).putInt("t_s_f", 1001);
              TroopUtils.a(a(), (Bundle)localObject1, 2);
              if ((n == 2) || (n == 10) || (n == 12))
              {
                n = 1;
                label237:
                localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
                String str = localViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get() + "";
                if (n == 0) {
                  break label396;
                }
                localObject1 = "0";
                label287:
                ReportController.b((AppRuntime)localObject2, "P_CliOper", "Grp_contacts", "", "notice", "see_data", 0, 0, str, (String)localObject1, "", "");
                localObject2 = localViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code + "";
                if (n == 0) {
                  break label404;
                }
              }
              label396:
              label404:
              for (localObject1 = "0";; localObject1 = "1")
              {
                TroopReportor.a("Grp_contacts_news", "notice", "see_data", 0, 0, new String[] { localObject2, localObject1 });
                break;
                n = 0;
                break label237;
                localObject1 = "1";
                break label287;
              }
            }
            if ((localViewHolder.jdField_a_of_type_Int != 2) || (!TroopInfo.isQidianPrivateTroop(localViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.uint32_group_flagext3.get())))
            {
              if (localViewHolder.jdField_a_of_type_Int != 82) {
                break label534;
              }
              localObject1 = new ActivityURIRequest(this.jdField_a_of_type_AndroidContentContext, "/pubaccount/detail");
              ((ActivityURIRequest)localObject1).extra().putString("uin", localViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get() + "");
              ((ActivityURIRequest)localObject1).extra().putInt("source", 112);
              QRoute.startUri((URIRequest)localObject1, null);
            }
          }
        }
        break;
      }
    }
    label534:
    l1 = ((structmsg.StructMsg)localObject2).req_uin.get();
    switch (TroopNotificationUtils.a(n))
    {
    default: 
      localObject1 = String.valueOf(l1);
      label574:
      if (((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b((String)localObject1)) {
        localObject1 = new ProfileActivity.AllInOne((String)localObject1, 1);
      }
      break;
    }
    for (;;)
    {
      l1 = ((structmsg.StructMsg)localObject2).msg.uint32_group_flagext3.get();
      boolean bool = TroopInfo.isQidianPrivateTroop(l1);
      n = ((structmsg.StructMsg)localObject2).msg.group_msg_type.get();
      if (QLog.isColorLevel()) {
        QLog.d(".troop.qidian_private_troop", 2, "notification headView onClick: msgType=" + n + ", isQidianPrivateTroop=" + bool + ", flagExt3=" + l1);
      }
      if ((bool) && (n == 2)) {
        break;
      }
      ProfileActivity.b(a(), (ProfileActivity.AllInOne)localObject1);
      TroopReportor.a("Grp_contacts_news", "notice", "see_fromdata", 0, 0, new String[] { localViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code + "", "3" });
      break;
      localObject1 = localViewHolder.jdField_a_of_type_JavaLangString;
      break label574;
      localObject1 = String.valueOf(localViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get());
      break label574;
      if ((((structmsg.StructMsg)localObject2).msg.group_msg_type.get() == 2) && (((structmsg.StructMsg)localObject2).msg.sub_type.get() == 3))
      {
        localObject1 = new ProfileActivity.AllInOne((String)localObject1, 26);
        ((ProfileActivity.AllInOne)localObject1).jdField_d_of_type_Int = 1;
      }
      else
      {
        localObject1 = new ProfileActivity.AllInOne((String)localObject1, 24);
        TroopUtils.a((structmsg.StructMsg)localObject2, (ProfileActivity.AllInOne)localObject1);
      }
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopSlideAndOverScrollRecyclerView, paramString, paramBitmap);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_g_of_type_Int = (paramInt1 + paramInt2 - 1);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter.a(this.jdField_g_of_type_Int, this.jdField_c_of_type_Int);
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotifyAndRecommendView", 2, "ray test firstvis:" + paramInt1 + " viscount:" + paramInt2);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      paramAbsListView = new StringBuilder().append("ray test lastindex:").append(this.jdField_g_of_type_Int).append("list count");
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter == null) {
        break label99;
      }
    }
    label99:
    for (int n = this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter.getCount();; n = 0)
    {
      QLog.d("TroopNotifyAndRecommendView", 2, n);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter != null) && (paramInt == 0) && (this.jdField_g_of_type_Int == this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter.getCount() - 1)) {
        D();
      }
      this.jdField_h_of_type_Int = paramInt;
      return;
    }
  }
  
  public void p()
  {
    H();
    G();
    I();
  }
  
  public void q()
  {
    L();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.clearGroupSuspiciousMsg();
    GroupSystemMsgController.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
    this.jdField_b_of_type_JavaUtilList.clear();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopSuspiciousAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopSuspiciousAdapter.a();
    }
    if (this.jdField_i_of_type_AndroidViewView != null) {
      this.jdField_i_of_type_AndroidViewView.setVisibility(8);
    }
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1012);
  }
  
  public void setType(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void update(Observable paramObservable, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView
 * JD-Core Version:    0.7.0.1
 */