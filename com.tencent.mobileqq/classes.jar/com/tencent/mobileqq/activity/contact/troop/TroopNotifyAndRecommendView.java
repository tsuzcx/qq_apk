package com.tencent.mobileqq.activity.contact.troop;

import acmw;
import aiyp;
import ajdw;
import ajdx;
import ajef;
import ajeg;
import ajep;
import ajfb;
import ajfc;
import ajfn;
import ajfp;
import ajfq;
import ajfr;
import ajfs;
import ajft;
import ajfu;
import ajfv;
import ajfw;
import ajfx;
import ajfy;
import ajfz;
import ajga;
import ajgb;
import ajgc;
import ajge;
import ajgf;
import ajgg;
import ajgh;
import ajgi;
import ajgj;
import ajgk;
import ajgl;
import ajgm;
import ajgn;
import ajgo;
import ajgp;
import ajgq;
import ajgr;
import ajgu;
import ajhg;
import ajhw;
import ajhx;
import ajhy;
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
import antp;
import anvk;
import anvx;
import anyz;
import aoce;
import aofu;
import aooy;
import awub;
import awzf;
import bcrg;
import bdla;
import bdzy;
import bffn;
import bgiv;
import bgst;
import bhbu;
import bhdj;
import bheg;
import bisl;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.app.face.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.Stranger;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.troop.data.RecommendTroopItem;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
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
import mqq.os.MqqHandler;
import tencent.mobileim.structmsg.structmsg.GroupInfo;
import tencent.mobileim.structmsg.structmsg.MsgInviteExt;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsgAction;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;

public class TroopNotifyAndRecommendView
  extends BaseTroopView
  implements aiyp, View.OnClickListener, FaceDecoder.DecodeTaskCompletionListener, AbsListView.OnScrollListener, Observer
{
  protected static long c;
  public final long a;
  public ajep a;
  private ajfb jdField_a_of_type_Ajfb;
  ajfp jdField_a_of_type_Ajfp = new ajgm(this);
  public ajfr a;
  private ajgu jdField_a_of_type_Ajgu = new ajfv(this);
  public Context a;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  protected View.OnClickListener a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  protected TextView a;
  anyz jdField_a_of_type_Anyz = new ajgp(this);
  protected aoce a;
  aofu jdField_a_of_type_Aofu = new ajga(this);
  private awzf jdField_a_of_type_Awzf;
  public bisl a;
  private SlideAndOverScrollRecyclerView jdField_a_of_type_ComTencentMobileqqActivityContactTroopSlideAndOverScrollRecyclerView;
  private ThreadExcutor.IThreadListener jdField_a_of_type_ComTencentMobileqqAppThreadExcutor$IThreadListener = new ajgn(this);
  public FaceDecoder a;
  protected SosoInterface.OnLocationListener a;
  SwipListView jdField_a_of_type_ComTencentWidgetSwipListView;
  protected List<MessageRecord> a;
  public MqqHandler a;
  public int b;
  public final long b;
  protected View.OnClickListener b;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  protected List<MessageRecord> b;
  public int c;
  View.OnClickListener jdField_c_of_type_AndroidViewView$OnClickListener = new ajgg(this);
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  protected List<RecommendTroopItem> c;
  protected boolean c;
  protected int d;
  protected View.OnClickListener d;
  private TextView d;
  protected boolean d;
  protected int e;
  protected View e;
  private TextView e;
  protected boolean e;
  private int jdField_f_of_type_Int;
  private View jdField_f_of_type_AndroidViewView;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  protected boolean f;
  private int jdField_g_of_type_Int;
  private View jdField_g_of_type_AndroidViewView;
  protected boolean g;
  private int jdField_h_of_type_Int;
  private View jdField_h_of_type_AndroidViewView;
  protected boolean h;
  private int jdField_i_of_type_Int;
  private View jdField_i_of_type_AndroidViewView;
  protected boolean i;
  private boolean j;
  private boolean k;
  private boolean l;
  private boolean m;
  
  public TroopNotifyAndRecommendView(Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_c_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Long = 1000L;
    this.jdField_b_of_type_Long = 500L;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_MqqOsMqqHandler = new ajgl(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new ajgo(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new ajfu(this);
    this.jdField_a_of_type_Ajfr = new ajfz(this);
    this.jdField_g_of_type_Boolean = true;
    this.jdField_e_of_type_Int = 0;
    this.jdField_d_of_type_AndroidViewView$OnClickListener = new ajgi(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void A()
  {
    ajfn localajfn = (ajfn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_NOTIFICATION_MANAGER);
    if (localajfn == null) {
      return;
    }
    List localList1 = localajfn.a(0);
    List localList2;
    if (this.jdField_c_of_type_Int == 1)
    {
      localList2 = localajfn.a(1);
      if ((localList2 != null) && (!localList2.isEmpty())) {
        this.jdField_a_of_type_Ajep.a(localList2);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Ajep.notifyDataSetChanged();
      b(localajfn.a(1));
      c(localajfn.a(2));
      F();
      this.jdField_a_of_type_Ajep.jdField_a_of_type_Int = 0;
      return;
      setType(0);
      this.jdField_a_of_type_Ajep.a(localList1);
      continue;
      if (this.jdField_c_of_type_Int == 2)
      {
        localList2 = localajfn.a(2);
        if ((localList2 != null) && (!localList2.isEmpty()))
        {
          this.jdField_a_of_type_Ajep.a(localajfn.a(2));
        }
        else
        {
          setType(0);
          this.jdField_a_of_type_Ajep.a(localList1);
        }
      }
      else if (this.jdField_c_of_type_Int == 0)
      {
        this.jdField_a_of_type_Ajep.a(localList1);
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
      this.jdField_e_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561542, null);
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
          if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
          {
            QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692125), 0).b(a());
            return;
          }
          if ((this.jdField_a_of_type_Ajep == null) || ((this.jdField_a_of_type_Ajep.b()) && (!this.jdField_a_of_type_Ajep.a()))) {
            break;
          }
        } while ((this.jdField_a_of_type_Awzf != null) && (this.jdField_a_of_type_Awzf.a()));
        this.jdField_i_of_type_Boolean = true;
        this.jdField_e_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a().h();
      } while (!QLog.isColorLevel());
      QLog.i("TroopNotifyAndRecommendView", 2, "loadNextPage.get next page of Notofication");
      return;
      if ((this.jdField_a_of_type_Aoce.jdField_a_of_type_Int != 1) && (this.k))
      {
        this.jdField_i_of_type_Boolean = true;
        this.jdField_e_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_Aoce.a();
        if (QLog.isColorLevel()) {
          QLog.i("TroopNotifyAndRecommendView", 2, "loadNextPage.get next page of recommend");
        }
        bhbu.a("Grp_contacts_news", "notice", "recom_,more", 2, 0, new String[0]);
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
    ajfn localajfn;
    do
    {
      return;
      localajfn = (ajfn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_NOTIFICATION_MANAGER);
    } while (localajfn == null);
    List localList = localajfn.a(2);
    if ((localajfn.a(1).isEmpty()) && (this.jdField_b_of_type_JavaUtilList.isEmpty()) && (localList.isEmpty()))
    {
      this.jdField_f_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    this.jdField_f_of_type_AndroidViewView.setVisibility(0);
  }
  
  private void G()
  {
    this.jdField_a_of_type_Ajfb = new ajgc(this, a(), 2131559954);
    this.jdField_a_of_type_Ajfb.a(2131559955);
    this.jdField_a_of_type_Ajfb.a(2131561542);
    this.jdField_a_of_type_Ajfb.a(new ajge(this));
  }
  
  private void H()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopSlideAndOverScrollRecyclerView = ((SlideAndOverScrollRecyclerView)findViewById(2131378317));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopSlideAndOverScrollRecyclerView.setLayoutManager(new LinearLayoutManager(a(), 1, false));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopSlideAndOverScrollRecyclerView.addOnScrollListener(new ajgh(this));
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = new FaceDecoder(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.setDecodeTaskCompletionListener(this);
  }
  
  private void I()
  {
    this.jdField_f_of_type_Int = bdzy.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopSlideAndOverScrollRecyclerView.setAdapter(this.jdField_a_of_type_Ajfb);
    this.jdField_b_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getMsgList(AppConstants.TROOP_SUSPICIOUS_MSG_UIN, 0);
    ajhg.a(this.jdField_b_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_contacts_news", "", "notice", "unnormal_tab_exp", 0, 0, "", "", "", "");
      }
      this.jdField_i_of_type_AndroidViewView.setVisibility(0);
      if (!(this.jdField_b_of_type_JavaUtilList.get(0) instanceof MessageForSystemMsg))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopNotifyAndRecommendView", 2, "initListData error");
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.clearGroupSystemMsgHistory();
        this.jdField_a_of_type_Ajfb.a(null);
      }
    }
    else
    {
      this.jdField_i_of_type_AndroidViewView.setVisibility(8);
    }
    this.jdField_a_of_type_Ajfb.a(this.jdField_b_of_type_JavaUtilList);
    this.jdField_a_of_type_Ajfb.notifyDataSetChanged();
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
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
        {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692125), 0).b(a());
          return;
        }
      } while ((this.jdField_a_of_type_Awzf != null) && (this.jdField_a_of_type_Awzf.b()));
      this.jdField_e_of_type_Boolean = true;
      if (this.jdField_a_of_type_Ajfb != null) {
        this.jdField_a_of_type_Ajfb.a(new ajgj(this));
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
    if (this.jdField_a_of_type_Ajfb != null) {
      this.jdField_a_of_type_Ajfb.b();
    }
    this.jdField_e_of_type_Boolean = false;
  }
  
  private void L()
  {
    ThreadManager.post(new TroopNotifyAndRecommendView.28(this), 8, null, false);
  }
  
  private void M()
  {
    this.jdField_g_of_type_Int = bdzy.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
    bgiv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong, new ajfw(this), localBundle);
  }
  
  private void a(ajdw paramajdw, MessageRecord paramMessageRecord, int paramInt)
  {
    ajfc localajfc = (ajfc)paramajdw;
    if ((paramMessageRecord == null) || (!(paramMessageRecord instanceof MessageForSystemMsg))) {}
    int n;
    do
    {
      return;
      localajfc.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = ((MessageForSystemMsg)paramMessageRecord).getSystemMsg();
      localajfc.jdField_c_of_type_Long = paramMessageRecord.uniseq;
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
    if (paramInt < this.jdField_g_of_type_Int)
    {
      ajhg.a(paramajdw.a(), true);
      localStructMsg = localajfc.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
      localajfc.jdField_a_of_type_Long = paramInt;
      localajfc.jdField_a_of_type_JavaLangString = (localStructMsg.req_uin.get() + "");
      localajfc.jdField_a_of_type_Int = localStructMsg.msg.group_msg_type.get();
      paramInt = localStructMsg.msg.sub_type.get();
      localajfc.jdField_b_of_type_Long = localStructMsg.msg_time.get();
      localajfc.jdField_b_of_type_JavaLangString = localStructMsg.msg.req_uin_nick.get();
      if ((localajfc.jdField_b_of_type_JavaLangString == null) || (localajfc.jdField_b_of_type_JavaLangString.equals(""))) {
        break label740;
      }
      a(localajfc, localStructMsg);
      localajfc.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      str = localStructMsg.msg.group_info.msg_alert.get();
      paramMessageRecord = "";
      if (localStructMsg.msg.bytes_warning_tips.get() != null) {
        paramMessageRecord = localStructMsg.msg.bytes_warning_tips.get().toStringUtf8();
      }
      if (!TextUtils.isEmpty(paramMessageRecord)) {
        break label753;
      }
      localajfc.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      if (localajfc.jdField_a_of_type_Int != 22) {
        break label832;
      }
      paramMessageRecord = localStructMsg.msg;
      localajfc.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      localObject1 = new SpannableString(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131719151, new Object[] { paramMessageRecord.action_uin_nick.get() }));
      ((SpannableString)localObject1).setSpan(new ForegroundColorSpan(Color.parseColor("#00a5e0")), 6, paramMessageRecord.action_uin_nick.get().length() + 6, 33);
      localajfc.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      localajfc.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(new ajgf(this, paramMessageRecord));
    }
    for (;;)
    {
      a(((ajfc)paramajdw).jdField_a_of_type_Ajef, localStructMsg, true);
      paramMessageRecord = TroopUtils.getMsgInfo(localStructMsg, localStructMsg.msg.msg_describe.get());
      if (paramMessageRecord == null) {
        break label1094;
      }
      localajfc.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessageRecord);
      label459:
      if (localajfc.jdField_a_of_type_Int != 80) {
        break label1153;
      }
      paramMessageRecord = localStructMsg.msg.actions.get();
      localajfc.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
      localajfc.jdField_a_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)paramMessageRecord.get(0)).name.get());
      localajfc.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131755352);
      localajfc.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839381);
      localajfc.jdField_a_of_type_AndroidWidgetButton.setContentDescription(localajfc.jdField_a_of_type_AndroidWidgetButton.getText() + "");
      localajfc.jdField_a_of_type_AndroidWidgetButton.setTag(localajfc);
      localajfc.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
      label597:
      if (!TextUtils.isEmpty(localajfc.jdField_a_of_type_AndroidWidgetButton.getText())) {
        break label1484;
      }
      localajfc.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      label621:
      if ((paramInt == 2) && (localajfc.jdField_a_of_type_Int == 2) && (((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(String.valueOf(localStructMsg.msg.group_code.get())) != null)) {
        awub.a().b(String.valueOf(localStructMsg.msg.group_code.get()), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      localajfc.jdField_a_of_type_AndroidWidgetLinearLayout.setTag(paramajdw);
      localajfc.jdField_a_of_type_AndroidWidgetImageView.setTag(paramajdw);
      localajfc.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
      a(localajfc);
      return;
      ajhg.a(paramajdw.a(), false);
      break;
      label740:
      localajfc.jdField_b_of_type_JavaLangString = localajfc.jdField_a_of_type_JavaLangString;
      break label208;
      label753:
      localajfc.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      localajfc.jdField_c_of_type_AndroidWidgetTextView.setText(paramMessageRecord);
      paramMessageRecord = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847815);
      paramMessageRecord.setBounds(0, 0, ViewUtils.dip2px(16.0F), ViewUtils.dip2px(16.0F));
      localajfc.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(ViewUtils.dip2px(5.0F));
      localajfc.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawables(paramMessageRecord, null, null, null);
      break label292;
      label832:
      if ((localajfc.jdField_a_of_type_Int == 2) && (localStructMsg.msg.msg_invite_extinfo.uint32_src_type.has()))
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
      localajfc.jdField_c_of_type_AndroidWidgetTextView.setText(anvx.a(2131707086) + paramMessageRecord);
      localajfc.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      break;
      Object localObject2 = (antp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
      paramMessageRecord = (MessageRecord)localObject1;
      if (localObject2 != null)
      {
        localObject2 = ((antp)localObject2).a(String.valueOf(localStructMsg.msg.msg_invite_extinfo.uint64_src_code.get()));
        paramMessageRecord = (MessageRecord)localObject1;
        if (localObject2 != null) {
          paramMessageRecord = ((DiscussionInfo)localObject2).discussionName;
        }
      }
      localajfc.jdField_c_of_type_AndroidWidgetTextView.setText(anvx.a(2131707075) + paramMessageRecord);
      localajfc.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      break;
      label1094:
      paramMessageRecord = localStructMsg.msg.msg_additional.get();
      if ((paramMessageRecord == null) || ("".equals(paramMessageRecord)))
      {
        localajfc.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131695923));
        break label459;
      }
      localajfc.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessageRecord);
      break label459;
      label1153:
      if (paramInt == 1)
      {
        paramMessageRecord = localStructMsg.msg.actions.get();
        localajfc.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
        if ((paramMessageRecord != null) && (paramMessageRecord.size() > 0))
        {
          if ((str == null) || ("".equals(str))) {
            if (paramMessageRecord.size() > 1)
            {
              localajfc.jdField_a_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)paramMessageRecord.get(1)).name.get());
              localajfc.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131755352);
              localajfc.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839381);
            }
          }
          for (;;)
          {
            localajfc.jdField_a_of_type_AndroidWidgetButton.setContentDescription(localajfc.jdField_a_of_type_AndroidWidgetButton.getText() + "");
            localajfc.jdField_a_of_type_AndroidWidgetButton.setTag(paramajdw);
            localajfc.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
            break;
            localajfc.jdField_a_of_type_AndroidWidgetButton.setText("");
            continue;
            localajfc.jdField_a_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)paramMessageRecord.get(0)).name.get());
            localajfc.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131755351);
            localajfc.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839380);
          }
        }
        localajfc.jdField_a_of_type_AndroidWidgetButton.setText("");
        localajfc.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(null);
        break label597;
      }
      localajfc.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(null);
      localajfc.jdField_a_of_type_AndroidWidgetButton.setClickable(false);
      localajfc.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131755977);
      localajfc.jdField_a_of_type_AndroidWidgetButton.setText(localStructMsg.msg.msg_decided.get());
      paramMessageRecord = (RelativeLayout.LayoutParams)localajfc.jdField_a_of_type_AndroidWidgetButton.getLayoutParams();
      break label597;
      label1484:
      localajfc.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      break label621;
    }
  }
  
  private void a(ajef paramajef, structmsg.StructMsg paramStructMsg, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (paramajef == null) || (paramStructMsg == null) || (paramajef.jdField_a_of_type_AndroidViewView == null)) {}
    int n;
    ajfn localajfn;
    do
    {
      return;
      n = paramStructMsg.msg.group_msg_type.get();
      if ((!ajgr.b(n)) && (!paramBoolean))
      {
        paramajef.jdField_a_of_type_AndroidViewView.setVisibility(8);
        return;
      }
      localajfn = (ajfn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_NOTIFICATION_MANAGER);
    } while (localajfn == null);
    long l1;
    if (n == 2)
    {
      if (!paramStructMsg.msg.has()) {
        break label763;
      }
      l1 = paramStructMsg.msg.action_uin.get();
    }
    for (;;)
    {
      if (l1 <= 0L)
      {
        paramajef.jdField_a_of_type_AndroidViewView.setVisibility(8);
        return;
        l1 = paramStructMsg.req_uin.get();
      }
      else
      {
        ajgq localajgq = localajfn.a(Long.valueOf(l1));
        if (localajgq == null)
        {
          localajfn.a(Long.valueOf(l1));
          localajfn.b(Long.valueOf(l1));
          if (!this.l)
          {
            paramStructMsg = new Message();
            paramStructMsg.what = 1016;
            this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(paramStructMsg, 2000L);
            this.l = true;
          }
          if (paramajef.jdField_a_of_type_AndroidViewView == null) {
            break;
          }
          paramajef.jdField_a_of_type_AndroidViewView.setVisibility(8);
          return;
        }
        paramajef.jdField_a_of_type_AndroidViewView.setVisibility(0);
        Object localObject;
        String str1;
        String str2;
        if (localajgq.a())
        {
          n = localajgq.b();
          paramStructMsg = localajgq.c();
          localObject = localajgq.a();
          str1 = localajgq.b();
          str2 = String.valueOf(localajgq.a());
          if ((paramStructMsg == null) || (paramStructMsg.isEmpty())) {}
        }
        for (;;)
        {
          label342:
          int i1;
          if (!paramStructMsg.isEmpty())
          {
            paramStructMsg = "在" + paramStructMsg;
            if (paramajef.jdField_b_of_type_AndroidWidgetTextView != null)
            {
              paramajef.jdField_b_of_type_AndroidWidgetTextView.setText(paramStructMsg);
              paramajef.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
            }
            if (paramajef.jdField_a_of_type_AndroidWidgetLinearLayout != null)
            {
              if ((str2.isEmpty()) || ((n != 1) && (n != 2))) {
                break label648;
              }
              paramStructMsg = (TextView)paramajef.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131373815);
              localObject = (ImageView)paramajef.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131373814);
              if ((localObject != null) && (paramStructMsg != null))
              {
                if (n != 1) {
                  break label621;
                }
                ((ImageView)localObject).setImageResource(2130845858);
                paramajef.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130842498);
                label431:
                paramStructMsg.setText(str2);
                paramajef.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
              }
            }
            label445:
            n = 0;
            label448:
            if (!localajgq.b()) {
              break label716;
            }
            i1 = localajgq.c();
            paramStructMsg = "LV" + String.valueOf(i1);
            i1 = n;
            if (paramajef.jdField_a_of_type_AndroidWidgetTextView != null)
            {
              paramajef.jdField_a_of_type_AndroidWidgetTextView.setText(paramStructMsg);
              paramajef.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
              i1 = n;
            }
          }
          for (;;)
          {
            if ((this.l) || (i1 == 0)) {
              break label754;
            }
            paramajef = new Message();
            paramajef.what = 1016;
            this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(paramajef, 2000L);
            this.l = true;
            return;
            if ((str1 != null) && (!str1.isEmpty()))
            {
              paramStructMsg = str1;
              break;
            }
            if ((localObject == null) || (((String)localObject).isEmpty())) {
              break label756;
            }
            paramStructMsg = (structmsg.StructMsg)localObject;
            break;
            if (paramajef.jdField_b_of_type_AndroidWidgetTextView == null) {
              break label342;
            }
            paramajef.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
            break label342;
            label621:
            if (n != 2) {
              break label431;
            }
            ((ImageView)localObject).setImageResource(2130845856);
            paramajef.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130842497);
            break label431;
            label648:
            paramajef.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
            break label445;
            i1 = 1;
            localajfn.a(Long.valueOf(l1));
            if (paramajef.jdField_b_of_type_AndroidWidgetTextView != null) {
              paramajef.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
            }
            n = i1;
            if (paramajef.jdField_a_of_type_AndroidWidgetLinearLayout == null) {
              break label448;
            }
            paramajef.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
            n = i1;
            break label448;
            label716:
            n = 1;
            localajfn.b(Long.valueOf(l1));
            i1 = n;
            if (paramajef.jdField_a_of_type_AndroidWidgetTextView != null)
            {
              paramajef.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
              i1 = n;
            }
          }
          label754:
          break;
          label756:
          paramStructMsg = "";
        }
        label763:
        l1 = 0L;
      }
    }
  }
  
  private void a(ajeg paramajeg, structmsg.StructMsg paramStructMsg)
  {
    String str = TroopUtils.getMsgInfo(paramStructMsg, paramStructMsg.msg.msg_describe.get());
    if (paramajeg.jdField_a_of_type_Int == 91)
    {
      b(paramajeg);
      return;
    }
    if (str != null)
    {
      paramajeg.jdField_b_of_type_AndroidWidgetTextView.setText(str);
      return;
    }
    paramStructMsg = paramStructMsg.msg.msg_additional.get();
    if ((paramStructMsg == null) || ("".equals(paramStructMsg)))
    {
      paramajeg.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131695923));
      return;
    }
    paramajeg.jdField_b_of_type_AndroidWidgetTextView.setText(paramStructMsg);
  }
  
  private void a(ajeg paramajeg, structmsg.StructMsg paramStructMsg, int paramInt)
  {
    if (!(paramajeg.jdField_a_of_type_Ajhy instanceof ajhw))
    {
      paramajeg.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      return;
    }
    ajhw localajhw = (ajhw)paramajeg.jdField_a_of_type_Ajhy;
    if (localajhw.jdField_c_of_type_Int == 1) {
      if ((localajhw.jdField_a_of_type_Int == 1) && (paramInt == 1))
      {
        paramajeg.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
        paramajeg.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131755352);
        paramajeg.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839381);
        paramajeg.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131699063));
        paramajeg.jdField_a_of_type_AndroidWidgetButton.setContentDescription(paramajeg.jdField_a_of_type_AndroidWidgetButton.getText() + "");
        paramajeg.jdField_a_of_type_AndroidWidgetButton.setTag(paramajeg);
        paramajeg.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      }
    }
    for (;;)
    {
      paramStructMsg = (RelativeLayout.LayoutParams)paramajeg.jdField_a_of_type_AndroidWidgetButton.getLayoutParams();
      if (paramStructMsg != null)
      {
        paramStructMsg.addRule(11);
        paramStructMsg.rightMargin = DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 16.0F);
        paramajeg.jdField_a_of_type_AndroidWidgetButton.setLayoutParams(paramStructMsg);
      }
      paramajeg.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      return;
      paramStructMsg = "";
      if (paramInt == 2) {
        paramStructMsg = this.jdField_a_of_type_AndroidContentContext.getString(2131699060);
      }
      for (;;)
      {
        paramajeg.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(null);
        paramajeg.jdField_a_of_type_AndroidWidgetButton.setClickable(false);
        paramajeg.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131755977);
        paramajeg.jdField_a_of_type_AndroidWidgetButton.setText(paramStructMsg);
        break;
        if (paramInt == 3) {
          paramStructMsg = this.jdField_a_of_type_AndroidContentContext.getString(2131699062);
        } else if (paramInt == 4) {
          paramStructMsg = this.jdField_a_of_type_AndroidContentContext.getString(2131699061);
        }
      }
      if (localajhw.jdField_c_of_type_Int == 2)
      {
        paramajeg.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(null);
        paramajeg.jdField_a_of_type_AndroidWidgetButton.setClickable(false);
        paramajeg.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131755977);
        paramajeg.jdField_a_of_type_AndroidWidgetButton.setText(paramStructMsg.msg.msg_decided.get());
      }
      else
      {
        QLog.d("TroopNotifyAndRecommendView", 2, "setSecondLineText reqSubMsgType:" + localajhw.jdField_c_of_type_Int);
      }
    }
  }
  
  private void a(ajeg paramajeg, structmsg.StructMsg paramStructMsg, int paramInt, String paramString)
  {
    if (paramajeg.jdField_a_of_type_Int == 91)
    {
      a(paramajeg, paramStructMsg, paramInt);
      return;
    }
    if (paramajeg.jdField_a_of_type_Int == 80)
    {
      paramStructMsg = paramStructMsg.msg.actions.get();
      paramajeg.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
      paramajeg.jdField_a_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)paramStructMsg.get(0)).name.get());
      paramajeg.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131755352);
      paramajeg.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839381);
      paramajeg.jdField_a_of_type_AndroidWidgetButton.setContentDescription(paramajeg.jdField_a_of_type_AndroidWidgetButton.getText() + "");
      paramajeg.jdField_a_of_type_AndroidWidgetButton.setTag(paramajeg);
      paramajeg.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    }
    for (;;)
    {
      paramStructMsg = (RelativeLayout.LayoutParams)paramajeg.jdField_a_of_type_AndroidWidgetButton.getLayoutParams();
      if (paramStructMsg != null)
      {
        paramStructMsg.addRule(11);
        paramStructMsg.rightMargin = DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 16.0F);
        paramajeg.jdField_a_of_type_AndroidWidgetButton.setLayoutParams(paramStructMsg);
      }
      if (!TextUtils.isEmpty(paramajeg.jdField_a_of_type_AndroidWidgetButton.getText())) {
        break label507;
      }
      paramajeg.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      return;
      if (paramInt != 1) {
        break;
      }
      paramStructMsg = paramStructMsg.msg.actions.get();
      paramajeg.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
      if ((paramStructMsg != null) && (paramStructMsg.size() > 0))
      {
        if ((paramString == null) || ("".equals(paramString))) {
          if (paramStructMsg.size() > 1)
          {
            paramajeg.jdField_a_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)paramStructMsg.get(1)).name.get());
            paramajeg.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131755352);
            paramajeg.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839381);
          }
        }
        for (;;)
        {
          paramajeg.jdField_a_of_type_AndroidWidgetButton.setContentDescription(paramajeg.jdField_a_of_type_AndroidWidgetButton.getText() + "");
          paramajeg.jdField_a_of_type_AndroidWidgetButton.setTag(paramajeg);
          paramajeg.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
          break;
          paramajeg.jdField_a_of_type_AndroidWidgetButton.setText("");
          continue;
          paramajeg.jdField_a_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)paramStructMsg.get(0)).name.get());
          paramajeg.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131755351);
          paramajeg.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839380);
        }
      }
      paramajeg.jdField_a_of_type_AndroidWidgetButton.setText("");
      paramajeg.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(null);
    }
    paramajeg.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(null);
    paramajeg.jdField_a_of_type_AndroidWidgetButton.setClickable(false);
    paramajeg.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131755977);
    paramajeg.jdField_a_of_type_AndroidWidgetButton.setText(paramStructMsg.msg.msg_decided.get());
    return;
    label507:
    paramajeg.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
  }
  
  private void a(ajeg paramajeg, structmsg.StructMsg paramStructMsg, String paramString)
  {
    if (paramajeg.jdField_a_of_type_Int == 91)
    {
      c(paramajeg);
      return;
    }
    Object localObject;
    if (paramajeg.jdField_a_of_type_Int == 11)
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
          localObject = anvx.a(2131715050) + paramString;
        }
      }
      else
      {
        label125:
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label512;
        }
        paramajeg.jdField_c_of_type_AndroidWidgetTextView.setSingleLine(true);
        paramajeg.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        paramajeg.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      for (;;)
      {
        if (paramajeg.jdField_a_of_type_Int != 22) {
          break label524;
        }
        paramStructMsg = paramStructMsg.msg;
        paramajeg.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        paramString = new SpannableString(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131719151, new Object[] { paramStructMsg.action_uin_nick.get() }));
        paramString.setSpan(new ForegroundColorSpan(Color.parseColor("#00a5e0")), 5, paramStructMsg.action_uin_nick.get().length() + 6, 33);
        paramajeg.jdField_c_of_type_AndroidWidgetTextView.setText(paramString);
        paramajeg.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(new ajft(this, paramStructMsg));
        return;
        if ((!TextUtils.isEmpty(paramString)) && ((paramajeg.jdField_a_of_type_Int == 1) || (paramajeg.jdField_a_of_type_Int == 22)))
        {
          paramajeg.jdField_c_of_type_AndroidWidgetTextView.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131755979);
          break;
        }
        localObject = new ArrayList();
        ((List)localObject).add(paramStructMsg.msg.msg_qna.get());
        if (paramStructMsg.msg.msg_actor_describe.get() != null) {}
        for (paramString = TroopUtils.getMsgInfo(paramStructMsg, paramStructMsg.msg.msg_actor_describe.get());; paramString = "")
        {
          ((List)localObject).add(paramString);
          ((List)localObject).add(paramStructMsg.msg.msg_additional_list.get());
          ((List)localObject).add(paramStructMsg.msg.msg_additional.get());
          if ((paramajeg.jdField_a_of_type_Int == 12) || (paramajeg.jdField_a_of_type_Int == 83)) {
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
        localObject = anvx.a(2131715051);
        break label125;
        label512:
        paramajeg.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      label524:
      if ((paramajeg.jdField_a_of_type_Int != 2) || (!paramStructMsg.msg.msg_invite_extinfo.uint32_src_type.has())) {
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
        paramajeg.jdField_c_of_type_AndroidWidgetTextView.setText(anvx.a(2131715054) + paramStructMsg);
        paramajeg.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        return;
        antp localantp = (antp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
        paramString = (String)localObject;
        if (localantp != null)
        {
          paramStructMsg = localantp.a(String.valueOf(paramStructMsg.msg.msg_invite_extinfo.uint64_src_code.get()));
          paramString = (String)localObject;
          if (paramStructMsg != null) {
            paramString = paramStructMsg.discussionName;
          }
        }
        paramajeg.jdField_c_of_type_AndroidWidgetTextView.setText(anvx.a(2131715052) + paramString);
        paramajeg.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        return;
      }
      paramString = "";
    }
  }
  
  private void a(ajfc paramajfc)
  {
    int n = 1;
    if (paramajfc == null) {
      return;
    }
    Object localObject;
    String str;
    switch (ajfq.a(paramajfc.jdField_a_of_type_Int))
    {
    default: 
      localObject = String.valueOf(paramajfc.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get());
      n = 4;
      str = paramajfc.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_name.get() + this.jdField_a_of_type_AndroidContentContext.getString(2131696246);
    }
    for (;;)
    {
      localObject = ajfq.a(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder, (String)localObject, n);
      paramajfc.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(str);
      paramajfc.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      return;
      localObject = paramajfc.jdField_a_of_type_JavaLangString;
      str = paramajfc.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get() + this.jdField_a_of_type_AndroidContentContext.getString(2131696245);
      continue;
      localObject = String.valueOf(paramajfc.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get());
      str = paramajfc.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin_nick.get() + this.jdField_a_of_type_AndroidContentContext.getString(2131696244);
    }
  }
  
  private void a(ajfc paramajfc, structmsg.StructMsg paramStructMsg)
  {
    if ((paramajfc == null) || (paramStructMsg == null)) {
      return;
    }
    if ((paramajfc.jdField_a_of_type_Int == 2) && (paramStructMsg.msg.msg_invite_extinfo.uint32_src_type.has()))
    {
      String str1 = paramStructMsg.msg.action_uin_qq_nick.get().toStringUtf8();
      switch (paramStructMsg.msg.msg_invite_extinfo.uint32_src_type.get())
      {
      default: 
        paramStructMsg = str1;
      }
      for (;;)
      {
        paramajfc.jdField_a_of_type_AndroidWidgetTextView.setText(paramStructMsg);
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
        str1 = ContactUtils.getTroopNickName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str3, str2, paramStructMsg, true, null);
        paramStructMsg = str1;
        if (TextUtils.isEmpty(str1))
        {
          paramStructMsg = ((TroopManager)localObject).a(str2, str3);
          continue;
          localObject = (antp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
          if (localObject == null) {
            break;
          }
          paramStructMsg = ((antp)localObject).a(String.valueOf(paramStructMsg.msg.msg_invite_extinfo.uint64_src_code.get()), String.valueOf(paramStructMsg.msg.action_uin.get()));
          if (paramStructMsg == null) {
            break;
          }
          paramStructMsg = paramStructMsg.getDiscussionMemberName();
        }
      }
    }
    switch (ajfq.a(paramajfc.jdField_a_of_type_Int))
    {
    default: 
      paramajfc.jdField_a_of_type_AndroidWidgetTextView.setText(paramajfc.jdField_b_of_type_JavaLangString);
      return;
    case 0: 
      paramajfc.jdField_a_of_type_AndroidWidgetTextView.setText(paramStructMsg.msg.group_name.get());
      return;
    case 1: 
      paramajfc.jdField_a_of_type_AndroidWidgetTextView.setText(paramStructMsg.msg.action_uin_nick.get());
      return;
    }
    paramajfc.jdField_a_of_type_AndroidWidgetTextView.setText(paramajfc.jdField_b_of_type_JavaLangString);
  }
  
  private void a(RecyclerView paramRecyclerView, String paramString, Bitmap paramBitmap)
  {
    Object localObject;
    ajfc localajfc;
    if (this.jdField_b_of_type_Int == 0)
    {
      int i1 = paramRecyclerView.getChildCount();
      int n = 0;
      while (n < i1)
      {
        localObject = paramRecyclerView.findViewHolderForAdapterPosition(n);
        if ((localObject == null) || (!(localObject instanceof ajfc)))
        {
          n += 1;
        }
        else
        {
          localajfc = (ajfc)localObject;
          switch (ajfq.a(localajfc.jdField_a_of_type_Int))
          {
          default: 
            localObject = String.valueOf(localajfc.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get());
          }
        }
      }
    }
    while ((localajfc.jdField_a_of_type_AndroidWidgetImageView != null) && (paramString.equals(localObject)))
    {
      localajfc.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
      return;
      localObject = localajfc.jdField_a_of_type_JavaLangString;
      continue;
      localObject = String.valueOf(localajfc.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get());
    }
  }
  
  private void a(structmsg.StructMsg paramStructMsg, long paramLong)
  {
    if (paramStructMsg != null)
    {
      String str = ((structmsg.StructMsg)paramStructMsg.get()).msg_seq.get() + "_" + ((structmsg.StructMsg)paramStructMsg.get()).msg_type.get();
      bdzy.a().a(str, (structmsg.StructMsg)paramStructMsg.get());
      bdzy.a().b(str);
      bdzy.a().a(paramLong);
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
          bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_discuss", "", "verify_msg", "Clk_agree", 0, 0, String.valueOf(paramStructMsg.msg.group_code.get()), "", "", "");
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
  
  private void b(ajeg paramajeg)
  {
    if (!(paramajeg.jdField_a_of_type_Ajhy instanceof ajhw))
    {
      paramajeg.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    ajhw localajhw = (ajhw)paramajeg.jdField_a_of_type_Ajhy;
    if (localajhw.jdField_c_of_type_Int == 1) {
      paramajeg.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131699058) + " " + this.jdField_a_of_type_AndroidContentContext.getString(2131699056));
    }
    for (;;)
    {
      paramajeg.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
      if (localajhw.jdField_c_of_type_Int == 2)
      {
        if (localajhw.jdField_a_of_type_Int == 2) {
          paramajeg.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131699065) + " " + this.jdField_a_of_type_AndroidContentContext.getString(2131699055));
        } else if (localajhw.jdField_a_of_type_Int == 3) {
          paramajeg.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131699067) + " " + this.jdField_a_of_type_AndroidContentContext.getString(2131699055));
        }
      }
      else {
        QLog.d("TroopNotifyAndRecommendView", 2, "setSecondLineText reqSubMsgType:" + paramajeg.jdField_a_of_type_Ajhy.jdField_c_of_type_Int);
      }
    }
  }
  
  private void b(ajeg paramajeg, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotifyAndRecommendView", 2, "jumpToTroopRequestActivity!" + paramajeg.jdField_a_of_type_Long + ": dealMsgType = " + paramInt);
    }
    Intent localIntent = new Intent(a(), TroopRequestActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putLong("troopMsgId", paramajeg.jdField_a_of_type_Long);
    localBundle.putInt("mTroopMsgType", paramajeg.jdField_a_of_type_Int);
    localBundle.putString("mTroopCode", String.valueOf(paramajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get()));
    localBundle.putString("troopmanagerUin", String.valueOf(paramajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get()));
    localBundle.putString("troopsMsg", paramajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get());
    if ((this.jdField_a_of_type_Ajep != null) && (paramajeg.jdField_b_of_type_Int < this.jdField_a_of_type_Ajep.jdField_a_of_type_Int)) {}
    for (boolean bool = true;; bool = false)
    {
      localBundle.putBoolean("is_unread", bool);
      localBundle.putString("troopRequestUin", String.valueOf(paramajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()));
      localBundle.putString("troopsummary", paramajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get());
      localBundle.putLong("infotime", paramajeg.jdField_b_of_type_Long);
      localBundle.putInt("troopfromtab", this.jdField_c_of_type_Int);
      if ((a() instanceof TroopActivity)) {
        localBundle.putBoolean("troop_invitee_is_friend", a((ArrayList)((TroopActivity)a()).jdField_a_of_type_JavaUtilList, String.valueOf(paramajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get())));
      }
      if (paramajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() != 83) {
        localIntent.putExtra("troopMsgDealInfo", paramajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_detail.get());
      }
      a((structmsg.StructMsg)paramajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get(), paramajeg.jdField_c_of_type_Long);
      localBundle.putInt("t_s_f", 1001);
      localIntent.putExtras(localBundle);
      a(localIntent);
      return;
    }
  }
  
  private void b(ajeg paramajeg, structmsg.StructMsg paramStructMsg)
  {
    if ((paramajeg == null) || (paramStructMsg == null)) {
      return;
    }
    if ((paramajeg.jdField_a_of_type_Int == 91) && ((paramajeg.jdField_a_of_type_Ajhy instanceof ajhw)))
    {
      paramStructMsg = (ajhw)paramajeg.jdField_a_of_type_Ajhy;
      if (!TextUtils.isEmpty(paramStructMsg.jdField_c_of_type_JavaLangString))
      {
        paramajeg.jdField_a_of_type_AndroidWidgetTextView.setText(paramStructMsg.jdField_c_of_type_JavaLangString);
        return;
      }
      if (paramStructMsg.jdField_c_of_type_Long > 0L)
      {
        paramajeg.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(paramStructMsg.jdField_c_of_type_Long));
        return;
      }
      QLog.d("TroopNotifyAndRecommendView", 2, "setFirstLineText " + paramajeg.jdField_a_of_type_Int + "reqTroopName and reqTroopCode is null");
      return;
    }
    if ((paramajeg.jdField_a_of_type_Int == 2) && (paramStructMsg.msg.msg_invite_extinfo.uint32_src_type.has()))
    {
      String str1 = paramStructMsg.msg.action_uin_qq_nick.get().toStringUtf8();
      switch (paramStructMsg.msg.msg_invite_extinfo.uint32_src_type.get())
      {
      default: 
        paramStructMsg = str1;
      }
      for (;;)
      {
        paramajeg.jdField_a_of_type_AndroidWidgetTextView.setText(paramStructMsg);
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
        str1 = ContactUtils.getTroopNickName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str3, str2, paramStructMsg, true, null);
        paramStructMsg = str1;
        if (TextUtils.isEmpty(str1))
        {
          paramStructMsg = ((TroopManager)localObject).a(str2, str3);
          continue;
          localObject = (antp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
          if (localObject == null) {
            break;
          }
          paramStructMsg = ((antp)localObject).a(String.valueOf(paramStructMsg.msg.msg_invite_extinfo.uint64_src_code.get()), String.valueOf(paramStructMsg.msg.action_uin.get()));
          if (paramStructMsg == null) {
            break;
          }
          paramStructMsg = paramStructMsg.getDiscussionMemberName();
        }
      }
    }
    switch (ajfq.a(paramajeg.jdField_a_of_type_Int))
    {
    default: 
      paramajeg.jdField_a_of_type_AndroidWidgetTextView.setText(paramajeg.jdField_b_of_type_JavaLangString);
      return;
    case 0: 
      paramajeg.jdField_a_of_type_AndroidWidgetTextView.setText(paramStructMsg.msg.group_name.get());
      return;
    case 1: 
      paramajeg.jdField_a_of_type_AndroidWidgetTextView.setText(paramStructMsg.msg.action_uin_nick.get());
      return;
    }
    paramajeg.jdField_a_of_type_AndroidWidgetTextView.setText(paramajeg.jdField_b_of_type_JavaLangString);
  }
  
  private void b(ajfc paramajfc)
  {
    if (paramajfc == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotifyAndRecommendView", 2, "jumpToTroopRequestActivity!" + paramajfc.jdField_a_of_type_Long);
    }
    ajhg.a(paramajfc.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, "unnormal_edit");
    Intent localIntent = new Intent(a(), TroopRequestActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putLong("troopMsgId", paramajfc.jdField_a_of_type_Long);
    localBundle.putInt("mTroopMsgType", paramajfc.jdField_a_of_type_Int);
    localBundle.putString("mTroopCode", String.valueOf(paramajfc.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get()));
    localBundle.putString("troopmanagerUin", String.valueOf(paramajfc.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get()));
    localBundle.putString("troopsMsg", paramajfc.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get());
    int n = bdzy.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (paramajfc.jdField_b_of_type_Int < n) {}
    for (boolean bool = true;; bool = false)
    {
      localBundle.putBoolean("is_unread", bool);
      localBundle.putString("troopRequestUin", String.valueOf(paramajfc.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()));
      localBundle.putString("troopsummary", paramajfc.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get());
      localBundle.putLong("infotime", paramajfc.jdField_b_of_type_Long);
      if ((a() instanceof TroopActivity)) {
        localBundle.putBoolean("troop_invitee_is_friend", a((ArrayList)((TroopActivity)a()).jdField_a_of_type_JavaUtilList, String.valueOf(paramajfc.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get())));
      }
      if (paramajfc.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() != 83) {
        localIntent.putExtra("troopMsgDealInfo", paramajfc.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_detail.get());
      }
      ajhg.a((structmsg.StructMsg)paramajfc.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get());
      a((structmsg.StructMsg)paramajfc.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get(), paramajfc.jdField_c_of_type_Long);
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
        bdla.b(null, "P_CliOper", "Grp_discuss", "", "verify_msg", "Clk_agree", 0, 0, String.valueOf(paramStructMsg.msg.group_code.get()), "", "", "");
      }
      return bool;
    }
  }
  
  private void c(ajeg paramajeg)
  {
    if (!(paramajeg.jdField_a_of_type_Ajhy instanceof ajhw))
    {
      paramajeg.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    Object localObject = (ajhw)paramajeg.jdField_a_of_type_Ajhy;
    String str;
    if (((ajhw)localObject).jdField_c_of_type_Int == 1)
    {
      str = "";
      if (!TextUtils.isEmpty(((ajhw)localObject).jdField_d_of_type_JavaLangString))
      {
        str = ((ajhw)localObject).jdField_d_of_type_JavaLangString;
        if (TextUtils.isEmpty(((ajhw)localObject).jdField_e_of_type_JavaLangString)) {
          break label196;
        }
        localObject = ((ajhw)localObject).jdField_e_of_type_JavaLangString;
        label70:
        str = this.jdField_a_of_type_AndroidContentContext.getString(2131699057) + " " + str + this.jdField_a_of_type_AndroidContentContext.getString(2131699054) + (String)localObject;
        paramajeg.jdField_c_of_type_AndroidWidgetTextView.setText(str);
      }
    }
    for (;;)
    {
      paramajeg.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
      if (((ajhw)localObject).jdField_d_of_type_Long > 0L)
      {
        str = String.valueOf(((ajhw)localObject).jdField_d_of_type_Long);
        break;
      }
      QLog.d("TroopNotifyAndRecommendView", 2, "setThirdLine " + paramajeg.jdField_a_of_type_Int + "reqTroopOwnerNickName is Empty");
      break;
      label196:
      if (((ajhw)localObject).jdField_e_of_type_Long > 0L)
      {
        localObject = String.valueOf(((ajhw)localObject).jdField_e_of_type_Long);
        break label70;
      }
      QLog.d("TroopNotifyAndRecommendView", 2, "setThirdLine " + paramajeg.jdField_a_of_type_Int + "reqSourceTroopName is Empty");
      localObject = "";
      break label70;
      if (paramajeg.jdField_a_of_type_Ajhy.jdField_c_of_type_Int == 2)
      {
        if (!TextUtils.isEmpty(((ajhw)localObject).jdField_b_of_type_JavaLangString)) {
          str = ((ajhw)localObject).jdField_b_of_type_JavaLangString;
        }
        for (;;)
        {
          paramajeg.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131699051) + " " + str);
          break;
          if (((ajhw)localObject).jdField_b_of_type_Long > 0L)
          {
            str = String.valueOf(((ajhw)localObject).jdField_b_of_type_Long);
          }
          else
          {
            QLog.d("TroopNotifyAndRecommendView", 2, "setThirdLine " + paramajeg.jdField_a_of_type_Int + "actionName is Empty");
            str = "";
          }
        }
      }
      QLog.d("TroopNotifyAndRecommendView", 2, "setThirdLine " + paramajeg.jdField_a_of_type_Ajhy.jdField_c_of_type_Int + "reqSubMsgType is error value");
    }
  }
  
  private void d(ajeg paramajeg)
  {
    int i1 = 1;
    if (paramajeg == null) {
      return;
    }
    int n = ajfq.a(paramajeg.jdField_a_of_type_Int);
    if (paramajeg.jdField_a_of_type_Int == 91) {
      n = 3;
    }
    long l1;
    String str;
    Object localObject;
    switch (n)
    {
    default: 
      l1 = paramajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get();
      str = paramajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_name.get() + this.jdField_a_of_type_AndroidContentContext.getString(2131696246);
      localObject = String.valueOf(l1);
      n = 4;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = bheg.b();
      }
      localObject = FaceDrawable.getFaceDrawable((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), n, (String)localObject, 3, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      paramajeg.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(str);
      paramajeg.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      return;
      localObject = paramajeg.jdField_a_of_type_JavaLangString;
      str = paramajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get() + this.jdField_a_of_type_AndroidContentContext.getString(2131696245);
      n = i1;
      continue;
      localObject = String.valueOf(paramajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get());
      str = paramajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin_nick.get() + this.jdField_a_of_type_AndroidContentContext.getString(2131696244);
      n = i1;
      continue;
      if ((paramajeg.jdField_a_of_type_Ajhy instanceof ajhw))
      {
        localObject = (ajhw)paramajeg.jdField_a_of_type_Ajhy;
        l1 = ((ajhw)localObject).jdField_c_of_type_Long;
        str = ((ajhw)localObject).jdField_c_of_type_JavaLangString;
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
    ajfn localajfn = (ajfn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_NOTIFICATION_MANAGER);
    if (localajfn == null) {
      return;
    }
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_contacts_news", "", "notice", "todo_tab_clk", 0, 0, "", "", "", "");
    localajfn.a(false);
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
      this.jdField_a_of_type_Ajep.b(localArrayList);
      this.jdField_a_of_type_Ajep.notifyDataSetChanged();
      this.jdField_a_of_type_Ajep.a(localajfn.a(1));
      this.jdField_a_of_type_Ajep.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_Ajep.notifyDataSetChanged();
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    setType(0);
    a(false);
    this.jdField_a_of_type_Ajep.a(localajfn.a(0));
    this.jdField_a_of_type_Ajep.jdField_a_of_type_Int = bdzy.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if ((this.jdField_c_of_type_JavaUtilList != null) && (this.jdField_c_of_type_JavaUtilList.size() > 0)) {
      this.jdField_a_of_type_Ajep.b(this.jdField_c_of_type_JavaUtilList);
    }
    this.jdField_a_of_type_Ajep.notifyDataSetChanged();
  }
  
  private void s()
  {
    ajfn localajfn = (ajfn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_NOTIFICATION_MANAGER);
    if (localajfn == null) {
      return;
    }
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_contacts_news", "", "notice", "quit_tab_clk", 0, 0, "", "", "", "");
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
      this.jdField_a_of_type_Ajep.b(localArrayList);
      this.jdField_a_of_type_Ajep.a(localajfn.a(2));
      this.jdField_a_of_type_Ajep.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_Ajep.notifyDataSetChanged();
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    setType(0);
    b(false);
    this.jdField_a_of_type_Ajep.a(localajfn.a(0));
    this.jdField_a_of_type_Ajep.jdField_a_of_type_Int = bdzy.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if ((this.jdField_c_of_type_JavaUtilList != null) && (this.jdField_c_of_type_JavaUtilList.size() > 0)) {
      this.jdField_a_of_type_Ajep.b(this.jdField_c_of_type_JavaUtilList);
    }
    this.jdField_a_of_type_Ajep.notifyDataSetChanged();
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
    ajfn localajfn = (ajfn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_NOTIFICATION_MANAGER);
    if (localajfn == null) {
      return;
    }
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_contacts_news", "", "notice", "unnormal_tab_clk", 0, 0, "", "", "", "");
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
    this.jdField_a_of_type_Ajep.a(localajfn.a(0));
    this.jdField_a_of_type_Ajep.jdField_a_of_type_Int = bdzy.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Ajep.notifyDataSetChanged();
    c(false);
  }
  
  private void u()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    ajfn localajfn;
    do
    {
      return;
      localajfn = (ajfn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_NOTIFICATION_MANAGER);
    } while (localajfn == null);
    List localList = localajfn.a("OidbSvc.0x5eb_troopnotifycation");
    if (localList != null) {
      localajfn.c(localList);
    }
    localList = localajfn.a("OidbSvc.0x668");
    if (localList != null) {
      localajfn.d(localList);
    }
    this.l = false;
  }
  
  private void v()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    ajfn localajfn = (ajfn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_NOTIFICATION_MANAGER);
    if (this.jdField_a_of_type_Ajep != null) {
      if (this.jdField_c_of_type_Int == 0) {
        break label117;
      }
    }
    label117:
    for (this.jdField_a_of_type_Ajep.jdField_a_of_type_Int = 0;; this.jdField_a_of_type_Ajep.jdField_a_of_type_Int = bdzy.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      this.jdField_a_of_type_Aoce.jdField_c_of_type_Int = bdzy.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (localajfn != null)
      {
        c(localajfn.a(2));
        b(localajfn.a(1));
        a(false, 1);
        a(false, 2);
      }
      this.jdField_a_of_type_Ajep.notifyDataSetChanged();
      if (this.jdField_a_of_type_Ajfb == null) {
        break;
      }
      this.jdField_a_of_type_Ajfb.notifyDataSetChanged();
      return;
    }
  }
  
  private void w()
  {
    int n = bdzy.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (this.jdField_a_of_type_Ajep != null)
    {
      if (!ajgr.b()) {
        break label85;
      }
      this.jdField_a_of_type_Ajep.jdField_a_of_type_Int = 0;
      setType(1);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilList = ((ajfn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_NOTIFICATION_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqAppThreadExcutor$IThreadListener);
      if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty())) {
        x();
      }
      return;
      label85:
      this.jdField_a_of_type_Ajep.jdField_a_of_type_Int = n;
    }
  }
  
  private void x()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    ajfn localajfn = (ajfn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_NOTIFICATION_MANAGER);
    List localList2 = localajfn.a(0);
    List localList4 = localajfn.a(2);
    List localList3 = localajfn.a(1);
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
      if (this.jdField_a_of_type_Ajep == null) {
        break;
      }
      this.jdField_a_of_type_Ajep.a(null);
      this.jdField_a_of_type_Ajep.notifyDataSetChanged();
      return;
    }
    label208:
    if (this.jdField_a_of_type_Ajep != null)
    {
      this.jdField_a_of_type_Ajep.a(localList1);
      this.jdField_a_of_type_Ajep.notifyDataSetChanged();
      this.jdField_a_of_type_Ajep.a(this.jdField_a_of_type_Aoce);
    }
    c(localList4);
    b(localList3);
    if (localajfn.a()) {
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
      localObject1 = (ajfn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_NOTIFICATION_MANAGER);
    } while (localObject1 == null);
    Object localObject3 = "";
    String str = "";
    List localList = ((ajfn)localObject1).a();
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
      bhbu.a("Grp_contacts_news", "notice", "enter_verify", 0, 0, new String[] { localObject2, localObject1 });
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
    return getResources().getDimensionPixelSize(2131299080);
  }
  
  public void a(ajeg paramajeg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotifyAndRecommendView", 2, "handleGroupSystemMsg! start " + paramajeg.jdField_a_of_type_Long);
    }
    b(paramajeg, 998);
    Object localObject = paramajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_info.msg_alert.get();
    String str4 = paramajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get() + "";
    String str2;
    int n;
    label147:
    String str1;
    if ((this.jdField_a_of_type_Ajep != null) && (paramajeg.jdField_b_of_type_Int < this.jdField_a_of_type_Ajep.jdField_a_of_type_Int))
    {
      str2 = "1";
      n = paramajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_inviter_role.get();
      if ((n != 2) && (n != 3)) {
        break label311;
      }
      n = 0;
      switch (paramajeg.jdField_a_of_type_Int)
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
        paramajeg = "";
        localObject = "";
        str1 = "";
      }
    }
    for (;;)
    {
      bhbu.a("Grp_contacts_news", "notice", str1, 3, 0, new String[] { str4, str2, localObject, paramajeg });
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
        if (paramajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get() != 1) {
          break label374;
        }
        paramajeg = "0";
        break;
      }
      label374:
      long l1 = paramajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actor_uin.get();
      if ((l1 != 0L) && (!(l1 + "").equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {}
      for (paramajeg = "2";; paramajeg = "1") {
        break;
      }
      paramajeg = "";
      localObject = "";
      str1 = "refuseask_page";
      continue;
      if (paramajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get() == 1) {}
      for (paramajeg = "0";; paramajeg = "1")
      {
        localObject = "";
        str1 = "enter_invite";
        break;
      }
      if (n != 0) {}
      String str3;
      for (paramajeg = "0";; paramajeg = "1")
      {
        str1 = "refuseinvite_page";
        str3 = "";
        localObject = paramajeg;
        paramajeg = str3;
        break;
      }
      if (n != 0) {}
      for (paramajeg = "0";; paramajeg = "1")
      {
        str1 = "refuseagree_page";
        str3 = "";
        localObject = paramajeg;
        paramajeg = str3;
        break;
      }
      paramajeg = "";
      localObject = "";
      str1 = "quit_page";
      continue;
      str1 = "byquit_page";
      paramajeg = "";
      localObject = "0";
      continue;
      str1 = "byquit_page";
      paramajeg = "";
      localObject = "1";
      continue;
      if ((paramajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get() + "").equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {}
      for (paramajeg = "0";; paramajeg = "1")
      {
        str1 = "set_admin_page";
        str3 = "";
        localObject = paramajeg;
        paramajeg = str3;
        break;
      }
      str1 = "un_admin_page";
      paramajeg = "";
      localObject = "0";
      continue;
      str1 = "un_admin_page";
      paramajeg = "";
      localObject = "1";
    }
  }
  
  public void a(ajeg paramajeg, int paramInt)
  {
    int i1 = -1;
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotifyAndRecommendView", 2, "bindTroopSystemMsgView! start " + paramajeg.jdField_a_of_type_Long);
    }
    structmsg.StructMsg localStructMsg = paramajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
    paramajeg.jdField_a_of_type_Long = paramInt;
    paramajeg.jdField_a_of_type_JavaLangString = (localStructMsg.req_uin.get() + "");
    paramajeg.jdField_a_of_type_Int = localStructMsg.msg.group_msg_type.get();
    paramInt = localStructMsg.msg.sub_type.get();
    paramajeg.jdField_b_of_type_Long = localStructMsg.msg_time.get();
    paramajeg.jdField_b_of_type_JavaLangString = localStructMsg.msg.req_uin_nick.get();
    Object localObject;
    if ((paramajeg.jdField_b_of_type_JavaLangString != null) && (!paramajeg.jdField_b_of_type_JavaLangString.equals("")))
    {
      localObject = (ajfn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_NOTIFICATION_MANAGER);
      if (paramajeg.jdField_a_of_type_Int == 91) {
        paramajeg.jdField_a_of_type_Ajhy = ((ajfn)localObject).a(91).a(localStructMsg);
      }
      if (paramajeg.jdField_a_of_type_Int == 2) {
        paramajeg.jdField_a_of_type_Ajhy = ((ajfn)localObject).a(2).a(localStructMsg);
      }
      b(paramajeg, localStructMsg);
      a(paramajeg.jdField_a_of_type_Ajef, localStructMsg, false);
      paramajeg.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      localObject = localStructMsg.msg.group_info.msg_alert.get();
      a(paramajeg, localStructMsg, (String)localObject);
      a(paramajeg, localStructMsg);
      a(paramajeg, localStructMsg, paramInt, (String)localObject);
      if ((paramInt == 2) && (paramajeg.jdField_a_of_type_Int == 2) && (((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(String.valueOf(localStructMsg.msg.group_code.get())) != null)) {
        awub.a().b(String.valueOf(localStructMsg.msg.group_code.get()), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      if (localStructMsg.msg.bytes_warning_tips.get() == null) {
        break label669;
      }
      localObject = localStructMsg.msg.bytes_warning_tips.get().toStringUtf8();
      label387:
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label677;
      }
      paramajeg.jdField_d_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      paramajeg.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      label412:
      if (QLog.isColorLevel()) {
        QLog.d("Q.security_verify", 2, String.format("bindTroopSystemMsgView reqUin: %s, warningTips: %s", new Object[] { paramajeg.jdField_a_of_type_JavaLangString, localObject }));
      }
      paramajeg.jdField_a_of_type_AndroidWidgetLinearLayout.setTag(paramajeg);
      paramajeg.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramajeg.jdField_a_of_type_AndroidWidgetImageView.setTag(paramajeg);
      if ((paramajeg.jdField_a_of_type_Int != 8) && (paramajeg.jdField_a_of_type_Int != 7)) {
        break label689;
      }
      paramajeg.jdField_a_of_type_AndroidWidgetImageView.setEnabled(false);
      label500:
      d(paramajeg);
      if (((paramajeg.jdField_a_of_type_Int == 1) || (paramajeg.jdField_a_of_type_Int == 22) || (paramajeg.jdField_a_of_type_Int == 60)) && (QLog.isColorLevel())) {
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
      QLog.i("TroopNotifyAndRecommendView", 2, String.format("joinGroup subSourceID=%d sourceID=%d msgType=%d", new Object[] { Integer.valueOf(n), Integer.valueOf(paramInt), Integer.valueOf(paramajeg.jdField_a_of_type_Int) }));
      return;
      paramajeg.jdField_b_of_type_JavaLangString = paramajeg.jdField_a_of_type_JavaLangString;
      break;
      localObject = "";
      break label387;
      paramajeg.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      break label412;
      paramajeg.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      break label500;
    }
  }
  
  protected void a(Intent paramIntent, ajdx paramajdx)
  {
    super.a(paramIntent, paramajdx);
    this.jdField_a_of_type_Aoce = ((aoce)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.RECOMMEND_TROOP_MANAGER));
    this.jdField_a_of_type_Awzf = ((awzf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOPINFO_MANAGER));
    i();
    b(paramIntent, paramajdx);
    c(paramIntent, paramajdx);
    this.jdField_a_of_type_AndroidWidgetTextView = paramajdx.a();
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_contacts_news", "", "notice", "notice_exp", 0, 0, "", "", "", "");
  }
  
  public void a(List<RecommendTroopItem> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotifyAndRecommendView", 2, "handleRecommendDataResult: " + Log.getStackTraceString(new RuntimeException("debug trace")));
    }
    this.jdField_a_of_type_Ajdx.a(new TroopNotifyAndRecommendView.20(this, paramList));
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
      localObject = (ajfn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_NOTIFICATION_MANAGER);
    } while (localObject == null);
    b(((ajfn)localObject).a(1));
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
        Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838000);
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
      if (this.jdField_a_of_type_Bisl != null)
      {
        this.jdField_a_of_type_Bisl.c(2131718527);
        this.jdField_a_of_type_Bisl.show();
      }
    }
  }
  
  protected int b()
  {
    int i2 = aoce.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (i2 > 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().d(AppConstants.TROOP_NOTIFICATION_UIN, 9000, 0 - i2);
      this.jdField_a_of_type_Aoce.b();
      o();
    }
    int i1 = 0;
    int n = i1;
    if (this.jdField_a_of_type_Aoce != null)
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
  
  protected void b(Intent paramIntent, ajdx paramajdx)
  {
    a(this.jdField_a_of_type_Ajfp);
    a(this.jdField_a_of_type_Anyz);
    C();
    w();
    this.jdField_a_of_type_Bisl = new bisl(this.jdField_a_of_type_AndroidContentContext, a());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
    if (ajfq.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) > 0) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a().a(3);
    }
    ajfq.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (this.jdField_a_of_type_Ajep != null) {
      this.jdField_a_of_type_Ajep.notifyDataSetChanged();
    }
    int n = bdzy.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotifyAndRecommendView", 2, "notification num:" + n);
    }
    this.jdField_a_of_type_Aoce.jdField_c_of_type_Int = n;
    int i1 = aoce.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().d(AppConstants.TROOP_NOTIFICATION_UIN, 9000, 0 - (n + i1));
    bdzy.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
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
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_contacts_news", "", "notice", "todo_tab_exp", 0, 0, "", "", "", "");
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
  
  protected void c(Intent paramIntent, ajdx paramajdx)
  {
    super.a(paramIntent, paramajdx);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().addObserver(this);
    a(this.jdField_a_of_type_Aofu);
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
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_contacts_news", "", "notice", "quit_tab_exp", 0, 0, "", "", "", "");
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
    if (this.j)
    {
      ajfq.b();
      bdzy.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
      if (this.jdField_a_of_type_Ajep != null)
      {
        this.jdField_a_of_type_Ajep.jdField_a_of_type_Int = 0;
        this.jdField_a_of_type_Ajep.notifyDataSetChanged();
      }
      this.jdField_a_of_type_Aoce.jdField_c_of_type_Int = bdzy.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    if (this.jdField_c_of_type_Int == 3) {
      bdzy.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
    }
    this.j = true;
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
      this.jdField_i_of_type_Int = i1;
      this.jdField_h_of_type_Int = n;
      return super.dispatchTouchEvent(paramMotionEvent);
      getParent().requestDisallowInterceptTouchEvent(true);
      continue;
      int i2 = n - this.jdField_h_of_type_Int;
      int i3 = i1 - this.jdField_i_of_type_Int;
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
    if (this.jdField_a_of_type_Aoce != null) {
      this.jdField_a_of_type_Aoce.b();
    }
    if (this.jdField_c_of_type_Int == 3)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.pause();
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.cancelPendingRequests();
    }
  }
  
  protected void g()
  {
    super.g();
    if (this.jdField_a_of_type_Ajep != null) {
      this.jdField_a_of_type_Ajep.b();
    }
    if ((this.jdField_a_of_type_Ajep != null) && (this.jdField_a_of_type_Ajep.a() > 0)) {
      B();
    }
    b(this.jdField_a_of_type_Aofu);
    b(this.jdField_a_of_type_Ajfp);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(TroopNotifyAndRecommendView.class);
    if (localObject != null) {
      ((MqqHandler)localObject).removeCallbacksAndMessages(null);
    }
    b(this.jdField_a_of_type_Anyz);
    if (this.jdField_a_of_type_Ajep != null)
    {
      this.jdField_a_of_type_Ajep.a();
      this.jdField_a_of_type_Ajep.notifyDataSetChanged();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().deleteObserver(this);
    ajfq.b();
    bdzy.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
    if (this.jdField_c_of_type_Boolean) {
      bdzy.a().b();
    }
    bgst.a(a()).a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeHandler(getClass());
    if (this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener != null) {
      SosoInterface.removeOnLocationListener(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener);
    }
    this.jdField_a_of_type_Aoce.b();
    this.jdField_a_of_type_Aoce.d();
    this.jdField_a_of_type_Aoce.a();
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.setDecodeTaskCompletionListener(null);
    }
    if (this.jdField_a_of_type_Ajfb != null)
    {
      this.jdField_a_of_type_Ajfb.a();
      this.jdField_a_of_type_Ajfb.notifyDataSetChanged();
    }
    localObject = (ajfn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_NOTIFICATION_MANAGER);
    if (localObject != null) {
      ((ajfn)localObject).a();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().d(AppConstants.TROOP_NOTIFICATION_UIN, 9000, 0 - bdzy.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
  }
  
  public void i()
  {
    a(2131559943);
    this.jdField_a_of_type_Ajep = new ajep(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getContext(), this.jdField_a_of_type_Ajdx, this);
    this.jdField_a_of_type_ComTencentWidgetSwipListView = ((SwipListView)findViewById(2131379530));
    this.jdField_f_of_type_AndroidViewView = findViewById(2131364634);
    this.jdField_g_of_type_AndroidViewView = findViewById(2131378374);
    this.jdField_h_of_type_AndroidViewView = findViewById(2131378369);
    this.jdField_i_of_type_AndroidViewView = findViewById(2131378378);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378377));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131378375));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378376));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378372));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131378370));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378371));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378379));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131378380));
    p();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopSlideAndOverScrollRecyclerView.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDragEnable(true);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setAdapter(this.jdField_a_of_type_Ajep);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setOnScrollListener(this);
    this.jdField_i_of_type_AndroidViewView.setOnClickListener(new ajfs(this));
    this.jdField_h_of_type_AndroidViewView.setOnClickListener(new ajgb(this));
    this.jdField_g_of_type_AndroidViewView.setOnClickListener(new ajgk(this));
  }
  
  public void j()
  {
    bhdj.a(this.jdField_a_of_type_AndroidContentContext, null, this.jdField_a_of_type_AndroidContentContext.getString(2131719675), null, 2131690697, 2131694617, new ajfx(this), new ajfy(this)).show();
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    B();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.clearGroupSystemMsg();
    bdzy.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
    ajfn localajfn = (ajfn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_NOTIFICATION_MANAGER);
    if (localajfn != null) {
      localajfn.b();
    }
    if (this.jdField_a_of_type_Ajep != null)
    {
      this.jdField_a_of_type_Ajep.a();
      this.jdField_a_of_type_Ajep.notifyDataSetChanged();
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
    this.k = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getBoolean("show_new_troop_recommend", false);
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotifyAndRecommendView", 2, "getNotificationRecommendTroopList showOpen is :" + this.k);
    }
    if ((this.jdField_g_of_type_Boolean) && (this.k))
    {
      this.jdField_g_of_type_Boolean = false;
      this.jdField_a_of_type_Aoce.a();
    }
    if ((!this.k) && (this.jdField_a_of_type_Ajep != null))
    {
      this.jdField_a_of_type_Ajep.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_Ajep.notifyDataSetChanged();
    }
    b();
    m();
  }
  
  protected void m()
  {
    if ((this.jdField_f_of_type_Boolean) && (this.jdField_a_of_type_Ajep != null) && (this.jdField_a_of_type_Ajep.b()))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("TroopNotifyAndRecommendView", 4, "reportPv");
      }
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_recom", "", "msg_page", "exp", 0, 0, "", "", "", "");
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
    if ((this.jdField_a_of_type_Aoce != null) && (!this.jdField_b_of_type_Boolean) && (aoce.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) > 0))
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
    ajeg localajeg;
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
      case 2131371843: 
        bffn.a(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        break;
      case 2131373803: 
        if ((paramView.getTag() instanceof ajeg))
        {
          localajeg = (ajeg)paramView.getTag();
          if (localajeg != null)
          {
            localObject2 = localajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
            n = localajeg.jdField_a_of_type_Int;
            if (ajfq.a(n) == 0)
            {
              localObject2 = String.valueOf(localajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get());
              localObject1 = localObject2;
              if (n == 91)
              {
                localObject1 = localObject2;
                if ((localajeg.jdField_a_of_type_Ajhy instanceof ajhw)) {
                  localObject1 = String.valueOf(((ajhw)localajeg.jdField_a_of_type_Ajhy).jdField_c_of_type_Long);
                }
              }
              localObject1 = TroopInfoActivity.a((String)localObject1, 4);
              ((Bundle)localObject1).putInt("t_s_f", 1001);
              TroopUtils.openTroopInfoActivity(a(), (Bundle)localObject1, 2);
              if ((n == 2) || (n == 10) || (n == 12))
              {
                n = 1;
                label237:
                localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
                String str = localajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get() + "";
                if (n == 0) {
                  break label396;
                }
                localObject1 = "0";
                label287:
                bdla.b((QQAppInterface)localObject2, "P_CliOper", "Grp_contacts", "", "notice", "see_data", 0, 0, str, (String)localObject1, "", "");
                localObject2 = localajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code + "";
                if (n == 0) {
                  break label404;
                }
              }
              label396:
              label404:
              for (localObject1 = "0";; localObject1 = "1")
              {
                bhbu.a("Grp_contacts_news", "notice", "see_data", 0, 0, new String[] { localObject2, localObject1 });
                break;
                n = 0;
                break label237;
                localObject1 = "1";
                break label287;
              }
            }
            if ((localajeg.jdField_a_of_type_Int != 2) || (!TroopInfo.isQidianPrivateTroop(localajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.uint32_group_flagext3.get())))
            {
              if (localajeg.jdField_a_of_type_Int != 82) {
                break label530;
              }
              localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, AccountDetailActivity.class);
              ((Intent)localObject1).putExtra("uin", localajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get() + "");
              ((Intent)localObject1).putExtra("source", 112);
              a((Intent)localObject1);
            }
          }
        }
        break;
      }
    }
    label530:
    l1 = ((structmsg.StructMsg)localObject2).req_uin.get();
    switch (ajfq.a(n))
    {
    default: 
      localObject1 = String.valueOf(l1);
      label570:
      if (((anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b((String)localObject1)) {
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
      bhbu.a("Grp_contacts_news", "notice", "see_fromdata", 0, 0, new String[] { localajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code + "", "3" });
      break;
      localObject1 = localajeg.jdField_a_of_type_JavaLangString;
      break label570;
      localObject1 = String.valueOf(localajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get());
      break label570;
      if ((((structmsg.StructMsg)localObject2).msg.group_msg_type.get() == 2) && (((structmsg.StructMsg)localObject2).msg.sub_type.get() == 3))
      {
        localObject1 = new ProfileActivity.AllInOne((String)localObject1, 26);
        ((ProfileActivity.AllInOne)localObject1).jdField_d_of_type_Int = 1;
      }
      else
      {
        localObject1 = new ProfileActivity.AllInOne((String)localObject1, 24);
        TroopUtils.prepareTroopNotifyData((structmsg.StructMsg)localObject2, (ProfileActivity.AllInOne)localObject1);
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
    this.jdField_d_of_type_Int = (paramInt1 + paramInt2 - 1);
    if (this.jdField_a_of_type_Ajep != null) {
      this.jdField_a_of_type_Ajep.a(this.jdField_d_of_type_Int, this.jdField_c_of_type_Int);
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotifyAndRecommendView", 2, "ray test firstvis:" + paramInt1 + " viscount:" + paramInt2);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      paramAbsListView = new StringBuilder().append("ray test lastindex:").append(this.jdField_d_of_type_Int).append("list count");
      if (this.jdField_a_of_type_Ajep == null) {
        break label99;
      }
    }
    label99:
    for (int n = this.jdField_a_of_type_Ajep.getCount();; n = 0)
    {
      QLog.d("TroopNotifyAndRecommendView", 2, n);
      if ((this.jdField_a_of_type_Ajep != null) && (paramInt == 0) && (this.jdField_d_of_type_Int == this.jdField_a_of_type_Ajep.getCount() - 1)) {
        D();
      }
      this.jdField_e_of_type_Int = paramInt;
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
    bdzy.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
    this.jdField_b_of_type_JavaUtilList.clear();
    if (this.jdField_a_of_type_Ajfb != null) {
      this.jdField_a_of_type_Ajfb.a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView
 * JD-Core Version:    0.7.0.1
 */