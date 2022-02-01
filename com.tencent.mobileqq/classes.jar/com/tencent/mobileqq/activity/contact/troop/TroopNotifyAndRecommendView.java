package com.tencent.mobileqq.activity.contact.troop;

import abwp;
import aidq;
import aiix;
import aiiy;
import aiiz;
import aiji;
import aijj;
import aijs;
import aike;
import aikf;
import aikq;
import aikt;
import aiku;
import aikv;
import aikw;
import aikx;
import aiky;
import aikz;
import aila;
import ailb;
import ailc;
import aild;
import aile;
import ailf;
import ailh;
import aili;
import ailj;
import ailk;
import aill;
import ailm;
import ailn;
import ailo;
import ailp;
import ailq;
import ailr;
import ails;
import ailt;
import ailu;
import aimg;
import amrb;
import amsw;
import amtj;
import amwl;
import amzp;
import andd;
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
import anmf;
import avnw;
import avtd;
import bbko;
import bcef;
import bcsz;
import bdyk;
import bfap;
import bfkc;
import bftc;
import bfur;
import bfvo;
import bhht;
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
  implements aidq, View.OnClickListener, FaceDecoder.DecodeTaskCompletionListener, AbsListView.OnScrollListener, Observer
{
  protected static long c;
  public final long a;
  public aijs a;
  private aike jdField_a_of_type_Aike;
  aikt jdField_a_of_type_Aikt = new ailp(this);
  public aikv a;
  amwl jdField_a_of_type_Amwl = new ails(this);
  protected amzp a;
  andd jdField_a_of_type_Andd = new aild(this);
  public Context a;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  protected View.OnClickListener a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  protected TextView a;
  private avtd jdField_a_of_type_Avtd;
  public bhht a;
  private SlideAndOverScrollRecyclerView jdField_a_of_type_ComTencentMobileqqActivityContactTroopSlideAndOverScrollRecyclerView;
  private ThreadExcutor.IThreadListener jdField_a_of_type_ComTencentMobileqqAppThreadExcutor$IThreadListener = new ailq(this);
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
  View.OnClickListener jdField_c_of_type_AndroidViewView$OnClickListener = new ailj(this);
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
    this.jdField_a_of_type_MqqOsMqqHandler = new ailo(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new ailr(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new aiky(this);
    this.jdField_a_of_type_Aikv = new ailc(this);
    this.jdField_g_of_type_Boolean = true;
    this.jdField_e_of_type_Int = 0;
    this.jdField_d_of_type_AndroidViewView$OnClickListener = new aill(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void A()
  {
    ThreadManager.postImmediately(new TroopNotifyAndRecommendView.11(this), null, false);
  }
  
  private void B()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotifyAndRecommendView", 2, "sendReadConfirm lll");
    }
    ThreadManager.post(new TroopNotifyAndRecommendView.12(this), 8, null, false);
    if (QLog.isColorLevel()) {
      QLog.i("TroopNotifyAndRecommendView", 2, "sendReadConfirm is end!");
    }
  }
  
  private void C()
  {
    if (this.jdField_e_of_type_AndroidViewView == null) {
      this.jdField_e_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561480, null);
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
            QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692035), 0).b(a());
            return;
          }
          if ((this.jdField_a_of_type_Aijs == null) || ((this.jdField_a_of_type_Aijs.b()) && (!this.jdField_a_of_type_Aijs.a()))) {
            break;
          }
        } while ((this.jdField_a_of_type_Avtd != null) && (this.jdField_a_of_type_Avtd.a()));
        this.jdField_i_of_type_Boolean = true;
        this.jdField_e_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a().h();
      } while (!QLog.isColorLevel());
      QLog.i("TroopNotifyAndRecommendView", 2, "loadNextPage.get next page of Notofication");
      return;
      if ((this.jdField_a_of_type_Amzp.jdField_a_of_type_Int != 1) && (this.k))
      {
        this.jdField_i_of_type_Boolean = true;
        this.jdField_e_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_Amzp.a();
        if (QLog.isColorLevel()) {
          QLog.i("TroopNotifyAndRecommendView", 2, "loadNextPage.get next page of recommend");
        }
        bftc.a("Grp_contacts_news", "notice", "recom_,more", 2, 0, new String[0]);
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
    aikq localaikq;
    do
    {
      return;
      localaikq = (aikq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(383);
    } while (localaikq == null);
    List localList = localaikq.a();
    if ((localaikq.b().isEmpty()) && (this.jdField_b_of_type_JavaUtilList.isEmpty()) && (localList.isEmpty()))
    {
      this.jdField_f_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    this.jdField_f_of_type_AndroidViewView.setVisibility(0);
  }
  
  private void G()
  {
    this.jdField_a_of_type_Aike = new ailf(this, a(), 2131559910);
    this.jdField_a_of_type_Aike.a(2131559911);
    this.jdField_a_of_type_Aike.a(2131561480);
    this.jdField_a_of_type_Aike.a(new ailh(this));
  }
  
  private void H()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopSlideAndOverScrollRecyclerView = ((SlideAndOverScrollRecyclerView)findViewById(2131378029));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopSlideAndOverScrollRecyclerView.setLayoutManager(new LinearLayoutManager(a(), 1, false));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopSlideAndOverScrollRecyclerView.addOnScrollListener(new ailk(this));
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = new FaceDecoder(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.setDecodeTaskCompletionListener(this);
  }
  
  private void I()
  {
    this.jdField_f_of_type_Int = bcsz.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopSlideAndOverScrollRecyclerView.setAdapter(this.jdField_a_of_type_Aike);
    this.jdField_b_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getMsgList(AppConstants.TROOP_SUSPICIOUS_MSG_UIN, 0);
    aimg.a(this.jdField_b_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
        bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_contacts_news", "", "notice", "unnormal_tab_exp", 0, 0, "", "", "", "");
      }
      this.jdField_i_of_type_AndroidViewView.setVisibility(0);
      if (!(this.jdField_b_of_type_JavaUtilList.get(0) instanceof MessageForSystemMsg))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopNotifyAndRecommendView", 2, "initListData error");
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.clearGroupSystemMsgHistory();
        this.jdField_a_of_type_Aike.a(null);
      }
    }
    else
    {
      this.jdField_i_of_type_AndroidViewView.setVisibility(8);
    }
    this.jdField_a_of_type_Aike.a(this.jdField_b_of_type_JavaUtilList);
    this.jdField_a_of_type_Aike.notifyDataSetChanged();
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
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692035), 0).b(a());
          return;
        }
      } while ((this.jdField_a_of_type_Avtd != null) && (this.jdField_a_of_type_Avtd.b()));
      this.jdField_e_of_type_Boolean = true;
      if (this.jdField_a_of_type_Aike != null) {
        this.jdField_a_of_type_Aike.a(new ailm(this));
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
    if (this.jdField_a_of_type_Aike != null) {
      this.jdField_a_of_type_Aike.b();
    }
    this.jdField_e_of_type_Boolean = false;
  }
  
  private void L()
  {
    ThreadManager.post(new TroopNotifyAndRecommendView.29(this), 8, null, false);
  }
  
  private void M()
  {
    this.jdField_g_of_type_Int = bcsz.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
    bfap.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong, new aikz(this), localBundle);
  }
  
  private void a(aiix paramaiix, MessageRecord paramMessageRecord, int paramInt)
  {
    aikf localaikf = (aikf)paramaiix;
    if ((paramMessageRecord == null) || (!(paramMessageRecord instanceof MessageForSystemMsg))) {}
    int n;
    do
    {
      return;
      localaikf.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = ((MessageForSystemMsg)paramMessageRecord).getSystemMsg();
      localaikf.jdField_c_of_type_Long = paramMessageRecord.uniseq;
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
      aimg.a(paramaiix.a(), true);
      localStructMsg = localaikf.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
      localaikf.jdField_a_of_type_Long = paramInt;
      localaikf.jdField_a_of_type_JavaLangString = (localStructMsg.req_uin.get() + "");
      localaikf.jdField_a_of_type_Int = localStructMsg.msg.group_msg_type.get();
      paramInt = localStructMsg.msg.sub_type.get();
      localaikf.jdField_b_of_type_Long = localStructMsg.msg_time.get();
      localaikf.jdField_b_of_type_JavaLangString = localStructMsg.msg.req_uin_nick.get();
      if ((localaikf.jdField_b_of_type_JavaLangString == null) || (localaikf.jdField_b_of_type_JavaLangString.equals(""))) {
        break label739;
      }
      a(localaikf, localStructMsg);
      localaikf.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      str = localStructMsg.msg.group_info.msg_alert.get();
      paramMessageRecord = "";
      if (localStructMsg.msg.bytes_warning_tips.get() != null) {
        paramMessageRecord = localStructMsg.msg.bytes_warning_tips.get().toStringUtf8();
      }
      if (!TextUtils.isEmpty(paramMessageRecord)) {
        break label752;
      }
      localaikf.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      if (localaikf.jdField_a_of_type_Int != 22) {
        break label831;
      }
      paramMessageRecord = localStructMsg.msg;
      localaikf.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      localObject1 = new SpannableString(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131718761, new Object[] { paramMessageRecord.action_uin_nick.get() }));
      ((SpannableString)localObject1).setSpan(new ForegroundColorSpan(Color.parseColor("#00a5e0")), 6, paramMessageRecord.action_uin_nick.get().length() + 6, 33);
      localaikf.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      localaikf.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(new aili(this, paramMessageRecord));
    }
    for (;;)
    {
      a(((aikf)paramaiix).jdField_a_of_type_Aiji, localStructMsg, true);
      paramMessageRecord = TroopUtils.getMsgInfo(localStructMsg, localStructMsg.msg.msg_describe.get());
      if (paramMessageRecord == null) {
        break label1092;
      }
      localaikf.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessageRecord);
      label459:
      if (localaikf.jdField_a_of_type_Int != 80) {
        break label1151;
      }
      paramMessageRecord = localStructMsg.msg.actions.get();
      localaikf.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
      localaikf.jdField_a_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)paramMessageRecord.get(0)).name.get());
      localaikf.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131755352);
      localaikf.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839360);
      localaikf.jdField_a_of_type_AndroidWidgetButton.setContentDescription(localaikf.jdField_a_of_type_AndroidWidgetButton.getText() + "");
      localaikf.jdField_a_of_type_AndroidWidgetButton.setTag(localaikf);
      localaikf.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
      label597:
      if (!TextUtils.isEmpty(localaikf.jdField_a_of_type_AndroidWidgetButton.getText())) {
        break label1482;
      }
      localaikf.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      label621:
      if ((paramInt == 2) && (localaikf.jdField_a_of_type_Int == 2) && (((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(String.valueOf(localStructMsg.msg.group_code.get())) != null)) {
        avnw.a().b(String.valueOf(localStructMsg.msg.group_code.get()), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      localaikf.jdField_a_of_type_AndroidWidgetLinearLayout.setTag(paramaiix);
      localaikf.jdField_a_of_type_AndroidWidgetImageView.setTag(paramaiix);
      localaikf.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
      a(localaikf);
      return;
      aimg.a(paramaiix.a(), false);
      break;
      label739:
      localaikf.jdField_b_of_type_JavaLangString = localaikf.jdField_a_of_type_JavaLangString;
      break label208;
      label752:
      localaikf.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      localaikf.jdField_c_of_type_AndroidWidgetTextView.setText(paramMessageRecord);
      paramMessageRecord = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847724);
      paramMessageRecord.setBounds(0, 0, ViewUtils.dip2px(16.0F), ViewUtils.dip2px(16.0F));
      localaikf.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(ViewUtils.dip2px(5.0F));
      localaikf.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawables(paramMessageRecord, null, null, null);
      break label292;
      label831:
      if ((localaikf.jdField_a_of_type_Int == 2) && (localStructMsg.msg.msg_invite_extinfo.uint32_src_type.has()))
      {
        localObject1 = "";
        switch (localStructMsg.msg.msg_invite_extinfo.uint32_src_type.get())
        {
        }
      }
    }
    paramMessageRecord = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    if (paramMessageRecord != null) {}
    for (paramMessageRecord = paramMessageRecord.a(String.valueOf(localStructMsg.msg.msg_invite_extinfo.uint64_src_code.get()));; paramMessageRecord = "")
    {
      localaikf.jdField_c_of_type_AndroidWidgetTextView.setText(amtj.a(2131706734) + paramMessageRecord);
      localaikf.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      break;
      Object localObject2 = (amrb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53);
      paramMessageRecord = (MessageRecord)localObject1;
      if (localObject2 != null)
      {
        localObject2 = ((amrb)localObject2).a(String.valueOf(localStructMsg.msg.msg_invite_extinfo.uint64_src_code.get()));
        paramMessageRecord = (MessageRecord)localObject1;
        if (localObject2 != null) {
          paramMessageRecord = ((DiscussionInfo)localObject2).discussionName;
        }
      }
      localaikf.jdField_c_of_type_AndroidWidgetTextView.setText(amtj.a(2131706723) + paramMessageRecord);
      localaikf.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      break;
      label1092:
      paramMessageRecord = localStructMsg.msg.msg_additional.get();
      if ((paramMessageRecord == null) || ("".equals(paramMessageRecord)))
      {
        localaikf.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131695671));
        break label459;
      }
      localaikf.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessageRecord);
      break label459;
      label1151:
      if (paramInt == 1)
      {
        paramMessageRecord = localStructMsg.msg.actions.get();
        localaikf.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
        if ((paramMessageRecord != null) && (paramMessageRecord.size() > 0))
        {
          if ((str == null) || ("".equals(str))) {
            if (paramMessageRecord.size() > 1)
            {
              localaikf.jdField_a_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)paramMessageRecord.get(1)).name.get());
              localaikf.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131755352);
              localaikf.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839360);
            }
          }
          for (;;)
          {
            localaikf.jdField_a_of_type_AndroidWidgetButton.setContentDescription(localaikf.jdField_a_of_type_AndroidWidgetButton.getText() + "");
            localaikf.jdField_a_of_type_AndroidWidgetButton.setTag(paramaiix);
            localaikf.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
            break;
            localaikf.jdField_a_of_type_AndroidWidgetButton.setText("");
            continue;
            localaikf.jdField_a_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)paramMessageRecord.get(0)).name.get());
            localaikf.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131755351);
            localaikf.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839359);
          }
        }
        localaikf.jdField_a_of_type_AndroidWidgetButton.setText("");
        localaikf.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(null);
        break label597;
      }
      localaikf.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(null);
      localaikf.jdField_a_of_type_AndroidWidgetButton.setClickable(false);
      localaikf.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131755973);
      localaikf.jdField_a_of_type_AndroidWidgetButton.setText(localStructMsg.msg.msg_decided.get());
      paramMessageRecord = (RelativeLayout.LayoutParams)localaikf.jdField_a_of_type_AndroidWidgetButton.getLayoutParams();
      break label597;
      label1482:
      localaikf.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      break label621;
    }
  }
  
  private void a(aiji paramaiji, structmsg.StructMsg paramStructMsg, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (paramaiji == null) || (paramStructMsg == null) || (paramaiji.jdField_a_of_type_AndroidViewView == null)) {}
    int n;
    aikq localaikq;
    do
    {
      return;
      n = paramStructMsg.msg.group_msg_type.get();
      if ((!ailu.b(n)) && (!paramBoolean))
      {
        paramaiji.jdField_a_of_type_AndroidViewView.setVisibility(8);
        return;
      }
      localaikq = (aikq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(383);
    } while (localaikq == null);
    long l1;
    if (n == 2)
    {
      if (!paramStructMsg.msg.has()) {
        break label779;
      }
      l1 = paramStructMsg.msg.action_uin.get();
    }
    for (;;)
    {
      if (l1 <= 0L)
      {
        paramaiji.jdField_a_of_type_AndroidViewView.setVisibility(8);
        return;
        l1 = paramStructMsg.req_uin.get();
      }
      else
      {
        ailt localailt = localaikq.a(Long.valueOf(l1));
        if (localailt == null)
        {
          localaikq.a(Long.valueOf(l1), 0, "OidbSvc.0x5eb_troopnotifycation");
          localaikq.a(Long.valueOf(l1), 0, "OidbSvc.0x668");
          if (!this.l)
          {
            paramStructMsg = new Message();
            paramStructMsg.what = 1016;
            this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(paramStructMsg, 2000L);
            this.l = true;
          }
          if (paramaiji.jdField_a_of_type_AndroidViewView == null) {
            break;
          }
          paramaiji.jdField_a_of_type_AndroidViewView.setVisibility(8);
          return;
        }
        paramaiji.jdField_a_of_type_AndroidViewView.setVisibility(0);
        Object localObject;
        String str1;
        String str2;
        if (localailt.a())
        {
          n = localailt.b();
          paramStructMsg = localailt.c();
          localObject = localailt.a();
          str1 = localailt.b();
          str2 = String.valueOf(localailt.a());
          if ((paramStructMsg == null) || (paramStructMsg.isEmpty())) {}
        }
        for (;;)
        {
          label350:
          int i1;
          if (!paramStructMsg.isEmpty())
          {
            paramStructMsg = "在" + paramStructMsg;
            if (paramaiji.jdField_b_of_type_AndroidWidgetTextView != null)
            {
              paramaiji.jdField_b_of_type_AndroidWidgetTextView.setText(paramStructMsg);
              paramaiji.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
            }
            if (paramaiji.jdField_a_of_type_AndroidWidgetLinearLayout != null)
            {
              if ((str2.isEmpty()) || ((n != 1) && (n != 2))) {
                break label656;
              }
              paramStructMsg = (TextView)paramaiji.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131373598);
              localObject = (ImageView)paramaiji.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131373597);
              if ((localObject != null) && (paramStructMsg != null))
              {
                if (n != 1) {
                  break label629;
                }
                ((ImageView)localObject).setImageResource(2130845770);
                paramaiji.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130842468);
                label439:
                paramStructMsg.setText(str2);
                paramaiji.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
              }
            }
            label453:
            n = 0;
            label456:
            if (!localailt.b()) {
              break label728;
            }
            i1 = localailt.c();
            paramStructMsg = "LV" + String.valueOf(i1);
            i1 = n;
            if (paramaiji.jdField_a_of_type_AndroidWidgetTextView != null)
            {
              paramaiji.jdField_a_of_type_AndroidWidgetTextView.setText(paramStructMsg);
              paramaiji.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
              i1 = n;
            }
          }
          for (;;)
          {
            if ((this.l) || (i1 == 0)) {
              break label770;
            }
            paramaiji = new Message();
            paramaiji.what = 1016;
            this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(paramaiji, 2000L);
            this.l = true;
            return;
            if ((str1 != null) && (!str1.isEmpty()))
            {
              paramStructMsg = str1;
              break;
            }
            if ((localObject == null) || (((String)localObject).isEmpty())) {
              break label772;
            }
            paramStructMsg = (structmsg.StructMsg)localObject;
            break;
            if (paramaiji.jdField_b_of_type_AndroidWidgetTextView == null) {
              break label350;
            }
            paramaiji.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
            break label350;
            label629:
            if (n != 2) {
              break label439;
            }
            ((ImageView)localObject).setImageResource(2130845768);
            paramaiji.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130842467);
            break label439;
            label656:
            paramaiji.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
            break label453;
            i1 = 1;
            localaikq.a(Long.valueOf(l1), 0, "OidbSvc.0x5eb_troopnotifycation");
            if (paramaiji.jdField_b_of_type_AndroidWidgetTextView != null) {
              paramaiji.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
            }
            n = i1;
            if (paramaiji.jdField_a_of_type_AndroidWidgetLinearLayout == null) {
              break label456;
            }
            paramaiji.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
            n = i1;
            break label456;
            label728:
            n = 1;
            localaikq.a(Long.valueOf(l1), 0, "OidbSvc.0x668");
            i1 = n;
            if (paramaiji.jdField_a_of_type_AndroidWidgetTextView != null)
            {
              paramaiji.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
              i1 = n;
            }
          }
          label770:
          break;
          label772:
          paramStructMsg = "";
        }
        label779:
        l1 = 0L;
      }
    }
  }
  
  private void a(aijj paramaijj, structmsg.StructMsg paramStructMsg)
  {
    String str = TroopUtils.getMsgInfo(paramStructMsg, paramStructMsg.msg.msg_describe.get());
    if (paramaijj.jdField_a_of_type_Int == 91)
    {
      b(paramaijj);
      return;
    }
    if (str != null)
    {
      paramaijj.jdField_b_of_type_AndroidWidgetTextView.setText(str);
      return;
    }
    paramStructMsg = paramStructMsg.msg.msg_additional.get();
    if ((paramStructMsg == null) || ("".equals(paramStructMsg)))
    {
      paramaijj.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131695671));
      return;
    }
    paramaijj.jdField_b_of_type_AndroidWidgetTextView.setText(paramStructMsg);
  }
  
  private void a(aijj paramaijj, structmsg.StructMsg paramStructMsg, int paramInt)
  {
    if (paramaijj.jdField_c_of_type_Int == 1) {
      if ((paramaijj.jdField_d_of_type_Int == 1) && (paramInt == 1))
      {
        paramaijj.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
        paramaijj.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131755352);
        paramaijj.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839360);
        paramaijj.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131698740));
        paramaijj.jdField_a_of_type_AndroidWidgetButton.setContentDescription(paramaijj.jdField_a_of_type_AndroidWidgetButton.getText() + "");
        paramaijj.jdField_a_of_type_AndroidWidgetButton.setTag(paramaijj);
        paramaijj.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      }
    }
    for (;;)
    {
      paramStructMsg = (RelativeLayout.LayoutParams)paramaijj.jdField_a_of_type_AndroidWidgetButton.getLayoutParams();
      if (paramStructMsg != null)
      {
        paramStructMsg.addRule(11);
        paramStructMsg.rightMargin = DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 16.0F);
        paramaijj.jdField_a_of_type_AndroidWidgetButton.setLayoutParams(paramStructMsg);
      }
      paramaijj.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      return;
      paramStructMsg = "";
      if (paramInt == 2) {
        paramStructMsg = this.jdField_a_of_type_AndroidContentContext.getString(2131698737);
      }
      for (;;)
      {
        paramaijj.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(null);
        paramaijj.jdField_a_of_type_AndroidWidgetButton.setClickable(false);
        paramaijj.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131755973);
        paramaijj.jdField_a_of_type_AndroidWidgetButton.setText(paramStructMsg);
        break;
        if (paramInt == 3) {
          paramStructMsg = this.jdField_a_of_type_AndroidContentContext.getString(2131698739);
        } else if (paramInt == 4) {
          paramStructMsg = this.jdField_a_of_type_AndroidContentContext.getString(2131698738);
        }
      }
      if (paramaijj.jdField_c_of_type_Int == 2)
      {
        paramaijj.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(null);
        paramaijj.jdField_a_of_type_AndroidWidgetButton.setClickable(false);
        paramaijj.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131755973);
        paramaijj.jdField_a_of_type_AndroidWidgetButton.setText(paramStructMsg.msg.msg_decided.get());
      }
      else
      {
        QLog.d("TroopNotifyAndRecommendView", 2, "setSecondLineText reqSubMsgType:" + paramaijj.jdField_c_of_type_Int);
      }
    }
  }
  
  private void a(aijj paramaijj, structmsg.StructMsg paramStructMsg, int paramInt, String paramString)
  {
    if (paramaijj.jdField_a_of_type_Int == 91)
    {
      a(paramaijj, paramStructMsg, paramInt);
      return;
    }
    if (paramaijj.jdField_a_of_type_Int == 80)
    {
      paramStructMsg = paramStructMsg.msg.actions.get();
      paramaijj.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
      paramaijj.jdField_a_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)paramStructMsg.get(0)).name.get());
      paramaijj.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131755352);
      paramaijj.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839360);
      paramaijj.jdField_a_of_type_AndroidWidgetButton.setContentDescription(paramaijj.jdField_a_of_type_AndroidWidgetButton.getText() + "");
      paramaijj.jdField_a_of_type_AndroidWidgetButton.setTag(paramaijj);
      paramaijj.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    }
    for (;;)
    {
      paramStructMsg = (RelativeLayout.LayoutParams)paramaijj.jdField_a_of_type_AndroidWidgetButton.getLayoutParams();
      if (paramStructMsg != null)
      {
        paramStructMsg.addRule(11);
        paramStructMsg.rightMargin = DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 16.0F);
        paramaijj.jdField_a_of_type_AndroidWidgetButton.setLayoutParams(paramStructMsg);
      }
      if (!TextUtils.isEmpty(paramaijj.jdField_a_of_type_AndroidWidgetButton.getText())) {
        break label507;
      }
      paramaijj.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      return;
      if (paramInt != 1) {
        break;
      }
      paramStructMsg = paramStructMsg.msg.actions.get();
      paramaijj.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
      if ((paramStructMsg != null) && (paramStructMsg.size() > 0))
      {
        if ((paramString == null) || ("".equals(paramString))) {
          if (paramStructMsg.size() > 1)
          {
            paramaijj.jdField_a_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)paramStructMsg.get(1)).name.get());
            paramaijj.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131755352);
            paramaijj.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839360);
          }
        }
        for (;;)
        {
          paramaijj.jdField_a_of_type_AndroidWidgetButton.setContentDescription(paramaijj.jdField_a_of_type_AndroidWidgetButton.getText() + "");
          paramaijj.jdField_a_of_type_AndroidWidgetButton.setTag(paramaijj);
          paramaijj.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
          break;
          paramaijj.jdField_a_of_type_AndroidWidgetButton.setText("");
          continue;
          paramaijj.jdField_a_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)paramStructMsg.get(0)).name.get());
          paramaijj.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131755351);
          paramaijj.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839359);
        }
      }
      paramaijj.jdField_a_of_type_AndroidWidgetButton.setText("");
      paramaijj.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(null);
    }
    paramaijj.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(null);
    paramaijj.jdField_a_of_type_AndroidWidgetButton.setClickable(false);
    paramaijj.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131755973);
    paramaijj.jdField_a_of_type_AndroidWidgetButton.setText(paramStructMsg.msg.msg_decided.get());
    return;
    label507:
    paramaijj.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
  }
  
  private void a(aijj paramaijj, structmsg.StructMsg paramStructMsg, String paramString)
  {
    if (paramaijj.jdField_a_of_type_Int == 91)
    {
      c(paramaijj);
      return;
    }
    Object localObject;
    if (paramaijj.jdField_a_of_type_Int == 11)
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
          localObject = amtj.a(2131714702) + paramString;
        }
      }
      else
      {
        label125:
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label513;
        }
        paramaijj.jdField_c_of_type_AndroidWidgetTextView.setSingleLine(true);
        paramaijj.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        paramaijj.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      for (;;)
      {
        if (paramaijj.jdField_a_of_type_Int != 22) {
          break label525;
        }
        paramStructMsg = paramStructMsg.msg;
        paramaijj.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        paramString = new SpannableString(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131718761, new Object[] { paramStructMsg.action_uin_nick.get() }));
        paramString.setSpan(new ForegroundColorSpan(Color.parseColor("#00a5e0")), 6, paramStructMsg.action_uin_nick.get().length() + 6, 33);
        paramaijj.jdField_c_of_type_AndroidWidgetTextView.setText(paramString);
        paramaijj.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(new aikx(this, paramStructMsg));
        return;
        if ((!TextUtils.isEmpty(paramString)) && ((paramaijj.jdField_a_of_type_Int == 1) || (paramaijj.jdField_a_of_type_Int == 22)))
        {
          paramaijj.jdField_c_of_type_AndroidWidgetTextView.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131755975);
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
          if ((paramaijj.jdField_a_of_type_Int == 12) || (paramaijj.jdField_a_of_type_Int == 83)) {
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
        localObject = amtj.a(2131714703);
        break label125;
        label513:
        paramaijj.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      label525:
      if ((paramaijj.jdField_a_of_type_Int != 2) || (!paramStructMsg.msg.msg_invite_extinfo.uint32_src_type.has())) {
        break;
      }
      localObject = "";
      switch (paramStructMsg.msg.msg_invite_extinfo.uint32_src_type.get())
      {
      case 0: 
      default: 
        return;
      case 1: 
        paramString = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
        if (paramString == null) {
          break;
        }
      }
      for (paramStructMsg = paramString.a(String.valueOf(paramStructMsg.msg.msg_invite_extinfo.uint64_src_code.get()));; paramStructMsg = "")
      {
        paramaijj.jdField_c_of_type_AndroidWidgetTextView.setText(amtj.a(2131714706) + paramStructMsg);
        paramaijj.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        return;
        amrb localamrb = (amrb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53);
        paramString = (String)localObject;
        if (localamrb != null)
        {
          paramStructMsg = localamrb.a(String.valueOf(paramStructMsg.msg.msg_invite_extinfo.uint64_src_code.get()));
          paramString = (String)localObject;
          if (paramStructMsg != null) {
            paramString = paramStructMsg.discussionName;
          }
        }
        paramaijj.jdField_c_of_type_AndroidWidgetTextView.setText(amtj.a(2131714704) + paramString);
        paramaijj.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        return;
      }
      paramString = "";
    }
  }
  
  private void a(aikf paramaikf)
  {
    int n = 1;
    if (paramaikf == null) {
      return;
    }
    Object localObject;
    String str;
    switch (aiku.a(paramaikf.jdField_a_of_type_Int))
    {
    default: 
      localObject = String.valueOf(paramaikf.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get());
      n = 4;
      str = paramaikf.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_name.get() + this.jdField_a_of_type_AndroidContentContext.getString(2131695994);
    }
    for (;;)
    {
      localObject = aiku.a(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder, (String)localObject, n);
      paramaikf.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(str);
      paramaikf.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      return;
      localObject = paramaikf.jdField_a_of_type_JavaLangString;
      str = paramaikf.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get() + this.jdField_a_of_type_AndroidContentContext.getString(2131695993);
      continue;
      localObject = String.valueOf(paramaikf.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get());
      str = paramaikf.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin_nick.get() + this.jdField_a_of_type_AndroidContentContext.getString(2131695992);
    }
  }
  
  private void a(aikf paramaikf, structmsg.StructMsg paramStructMsg)
  {
    if ((paramaikf == null) || (paramStructMsg == null)) {
      return;
    }
    if ((paramaikf.jdField_a_of_type_Int == 2) && (paramStructMsg.msg.msg_invite_extinfo.uint32_src_type.has()))
    {
      String str1 = paramStructMsg.msg.action_uin_qq_nick.get().toStringUtf8();
      switch (paramStructMsg.msg.msg_invite_extinfo.uint32_src_type.get())
      {
      default: 
        paramStructMsg = str1;
      }
      for (;;)
      {
        paramaikf.jdField_a_of_type_AndroidWidgetTextView.setText(paramStructMsg);
        return;
        paramStructMsg = paramStructMsg.msg.action_uin_nick.get();
        continue;
        Object localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
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
          localObject = (amrb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53);
          if (localObject == null) {
            break;
          }
          paramStructMsg = ((amrb)localObject).a(String.valueOf(paramStructMsg.msg.msg_invite_extinfo.uint64_src_code.get()), String.valueOf(paramStructMsg.msg.action_uin.get()));
          if (paramStructMsg == null) {
            break;
          }
          paramStructMsg = paramStructMsg.getDiscussionMemberName();
        }
      }
    }
    switch (aiku.a(paramaikf.jdField_a_of_type_Int))
    {
    default: 
      paramaikf.jdField_a_of_type_AndroidWidgetTextView.setText(paramaikf.jdField_b_of_type_JavaLangString);
      return;
    case 0: 
      paramaikf.jdField_a_of_type_AndroidWidgetTextView.setText(paramStructMsg.msg.group_name.get());
      return;
    case 1: 
      paramaikf.jdField_a_of_type_AndroidWidgetTextView.setText(paramStructMsg.msg.action_uin_nick.get());
      return;
    }
    paramaikf.jdField_a_of_type_AndroidWidgetTextView.setText(paramaikf.jdField_b_of_type_JavaLangString);
  }
  
  private void a(RecyclerView paramRecyclerView, String paramString, Bitmap paramBitmap)
  {
    Object localObject;
    aikf localaikf;
    if (this.jdField_b_of_type_Int == 0)
    {
      int i1 = paramRecyclerView.getChildCount();
      int n = 0;
      while (n < i1)
      {
        localObject = paramRecyclerView.findViewHolderForAdapterPosition(n);
        if ((localObject == null) || (!(localObject instanceof aikf)))
        {
          n += 1;
        }
        else
        {
          localaikf = (aikf)localObject;
          switch (aiku.a(localaikf.jdField_a_of_type_Int))
          {
          default: 
            localObject = String.valueOf(localaikf.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get());
          }
        }
      }
    }
    while ((localaikf.jdField_a_of_type_AndroidWidgetImageView != null) && (paramString.equals(localObject)))
    {
      localaikf.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
      return;
      localObject = localaikf.jdField_a_of_type_JavaLangString;
      continue;
      localObject = String.valueOf(localaikf.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get());
    }
  }
  
  private void a(structmsg.StructMsg paramStructMsg, long paramLong)
  {
    if (paramStructMsg != null)
    {
      long l1 = ((structmsg.StructMsg)paramStructMsg.get()).msg_seq.get() + ((structmsg.StructMsg)paramStructMsg.get()).msg_type.get();
      bcsz.a().a(Long.valueOf(l1), (structmsg.StructMsg)paramStructMsg.get());
      bcsz.a().b(l1);
      bcsz.a().a(paramLong);
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
          bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_discuss", "", "verify_msg", "Clk_agree", 0, 0, String.valueOf(paramStructMsg.msg.group_code.get()), "", "", "");
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
  
  private void b(aijj paramaijj)
  {
    if (paramaijj.jdField_c_of_type_Int == 1) {
      paramaijj.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131698735) + " " + this.jdField_a_of_type_AndroidContentContext.getString(2131698733));
    }
    for (;;)
    {
      paramaijj.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
      if (paramaijj.jdField_c_of_type_Int == 2)
      {
        if (paramaijj.jdField_d_of_type_Int == 2) {
          paramaijj.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131698742) + " " + this.jdField_a_of_type_AndroidContentContext.getString(2131698732));
        } else if (paramaijj.jdField_d_of_type_Int == 3) {
          paramaijj.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131698744) + " " + this.jdField_a_of_type_AndroidContentContext.getString(2131698732));
        }
      }
      else {
        QLog.d("TroopNotifyAndRecommendView", 2, "setSecondLineText reqSubMsgType:" + paramaijj.jdField_c_of_type_Int);
      }
    }
  }
  
  private void b(aijj paramaijj, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotifyAndRecommendView", 2, "jumpToTroopRequestActivity!" + paramaijj.jdField_a_of_type_Long + ": dealMsgType = " + paramInt);
    }
    Intent localIntent = new Intent(a(), TroopRequestActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putLong("troopMsgId", paramaijj.jdField_a_of_type_Long);
    localBundle.putInt("mTroopMsgType", paramaijj.jdField_a_of_type_Int);
    localBundle.putString("mTroopCode", String.valueOf(paramaijj.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get()));
    localBundle.putString("troopmanagerUin", String.valueOf(paramaijj.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get()));
    localBundle.putString("troopsMsg", paramaijj.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get());
    if ((this.jdField_a_of_type_Aijs != null) && (paramaijj.jdField_b_of_type_Int < this.jdField_a_of_type_Aijs.jdField_a_of_type_Int)) {}
    for (boolean bool = true;; bool = false)
    {
      localBundle.putBoolean("is_unread", bool);
      localBundle.putString("troopRequestUin", String.valueOf(paramaijj.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()));
      localBundle.putString("troopsummary", paramaijj.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get());
      localBundle.putLong("infotime", paramaijj.jdField_b_of_type_Long);
      localBundle.putInt("troopfromtab", this.jdField_c_of_type_Int);
      if ((a() instanceof TroopActivity)) {
        localBundle.putBoolean("troop_invitee_is_friend", a((ArrayList)((TroopActivity)a()).jdField_a_of_type_JavaUtilList, String.valueOf(paramaijj.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get())));
      }
      if (paramaijj.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() != 83) {
        localIntent.putExtra("troopMsgDealInfo", paramaijj.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_detail.get());
      }
      a((structmsg.StructMsg)paramaijj.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get(), paramaijj.jdField_c_of_type_Long);
      localBundle.putInt("t_s_f", 1001);
      localIntent.putExtras(localBundle);
      a(localIntent);
      return;
    }
  }
  
  private void b(aijj paramaijj, structmsg.StructMsg paramStructMsg)
  {
    if ((paramaijj == null) || (paramStructMsg == null)) {
      return;
    }
    if (paramaijj.jdField_a_of_type_Int == 91)
    {
      if (!TextUtils.isEmpty(paramaijj.jdField_d_of_type_JavaLangString))
      {
        paramaijj.jdField_a_of_type_AndroidWidgetTextView.setText(paramaijj.jdField_d_of_type_JavaLangString);
        return;
      }
      if (paramaijj.jdField_d_of_type_Long > 0L)
      {
        paramaijj.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(paramaijj.jdField_d_of_type_Long));
        return;
      }
      QLog.d("TroopNotifyAndRecommendView", 2, "setFirstLineText " + paramaijj.jdField_a_of_type_Int + "reqTroopName and reqTroopCode is null");
      return;
    }
    if ((paramaijj.jdField_a_of_type_Int == 2) && (paramStructMsg.msg.msg_invite_extinfo.uint32_src_type.has()))
    {
      String str1 = paramStructMsg.msg.action_uin_qq_nick.get().toStringUtf8();
      switch (paramStructMsg.msg.msg_invite_extinfo.uint32_src_type.get())
      {
      default: 
        paramStructMsg = str1;
      }
      for (;;)
      {
        paramaijj.jdField_a_of_type_AndroidWidgetTextView.setText(paramStructMsg);
        return;
        paramStructMsg = paramStructMsg.msg.action_uin_nick.get();
        continue;
        Object localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
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
          localObject = (amrb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53);
          if (localObject == null) {
            break;
          }
          paramStructMsg = ((amrb)localObject).a(String.valueOf(paramStructMsg.msg.msg_invite_extinfo.uint64_src_code.get()), String.valueOf(paramStructMsg.msg.action_uin.get()));
          if (paramStructMsg == null) {
            break;
          }
          paramStructMsg = paramStructMsg.getDiscussionMemberName();
        }
      }
    }
    switch (aiku.a(paramaijj.jdField_a_of_type_Int))
    {
    default: 
      paramaijj.jdField_a_of_type_AndroidWidgetTextView.setText(paramaijj.jdField_b_of_type_JavaLangString);
      return;
    case 0: 
      paramaijj.jdField_a_of_type_AndroidWidgetTextView.setText(paramStructMsg.msg.group_name.get());
      return;
    case 1: 
      paramaijj.jdField_a_of_type_AndroidWidgetTextView.setText(paramStructMsg.msg.action_uin_nick.get());
      return;
    }
    paramaijj.jdField_a_of_type_AndroidWidgetTextView.setText(paramaijj.jdField_b_of_type_JavaLangString);
  }
  
  private void b(aikf paramaikf)
  {
    if (paramaikf == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotifyAndRecommendView", 2, "jumpToTroopRequestActivity!" + paramaikf.jdField_a_of_type_Long);
    }
    aimg.a(paramaikf.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, "unnormal_edit");
    Intent localIntent = new Intent(a(), TroopRequestActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putLong("troopMsgId", paramaikf.jdField_a_of_type_Long);
    localBundle.putInt("mTroopMsgType", paramaikf.jdField_a_of_type_Int);
    localBundle.putString("mTroopCode", String.valueOf(paramaikf.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get()));
    localBundle.putString("troopmanagerUin", String.valueOf(paramaikf.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get()));
    localBundle.putString("troopsMsg", paramaikf.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get());
    int n = bcsz.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (paramaikf.jdField_b_of_type_Int < n) {}
    for (boolean bool = true;; bool = false)
    {
      localBundle.putBoolean("is_unread", bool);
      localBundle.putString("troopRequestUin", String.valueOf(paramaikf.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()));
      localBundle.putString("troopsummary", paramaikf.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get());
      localBundle.putLong("infotime", paramaikf.jdField_b_of_type_Long);
      if ((a() instanceof TroopActivity)) {
        localBundle.putBoolean("troop_invitee_is_friend", a((ArrayList)((TroopActivity)a()).jdField_a_of_type_JavaUtilList, String.valueOf(paramaikf.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get())));
      }
      if (paramaikf.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() != 83) {
        localIntent.putExtra("troopMsgDealInfo", paramaikf.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_detail.get());
      }
      aimg.a((structmsg.StructMsg)paramaikf.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get());
      a((structmsg.StructMsg)paramaikf.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get(), paramaikf.jdField_c_of_type_Long);
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
        bcef.b(null, "P_CliOper", "Grp_discuss", "", "verify_msg", "Clk_agree", 0, 0, String.valueOf(paramStructMsg.msg.group_code.get()), "", "", "");
      }
      return bool;
    }
  }
  
  private void c(aijj paramaijj)
  {
    String str1;
    String str2;
    if (paramaijj.jdField_c_of_type_Int == 1)
    {
      str1 = "";
      if (!TextUtils.isEmpty(paramaijj.jdField_e_of_type_JavaLangString))
      {
        str1 = paramaijj.jdField_e_of_type_JavaLangString;
        str2 = "";
        if (TextUtils.isEmpty(paramaijj.jdField_f_of_type_JavaLangString)) {
          break label172;
        }
        str2 = paramaijj.jdField_f_of_type_JavaLangString;
        label46:
        str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131698734) + " " + str1 + this.jdField_a_of_type_AndroidContentContext.getString(2131698731) + str2;
        paramaijj.jdField_c_of_type_AndroidWidgetTextView.setText(str1);
      }
    }
    for (;;)
    {
      paramaijj.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
      if (paramaijj.jdField_e_of_type_Long > 0L)
      {
        str1 = String.valueOf(paramaijj.jdField_e_of_type_Long);
        break;
      }
      QLog.d("TroopNotifyAndRecommendView", 2, "setThirdLine " + paramaijj.jdField_a_of_type_Int + "reqTroopOwnerNickName is Empty");
      break;
      label172:
      if (paramaijj.jdField_f_of_type_Long > 0L)
      {
        str2 = String.valueOf(paramaijj.jdField_f_of_type_Long);
        break label46;
      }
      QLog.d("TroopNotifyAndRecommendView", 2, "setThirdLine " + paramaijj.jdField_a_of_type_Int + "reqSourceTroopName is Empty");
      break label46;
      if (paramaijj.jdField_c_of_type_Int == 2)
      {
        str1 = "";
        if (!TextUtils.isEmpty(paramaijj.jdField_h_of_type_JavaLangString)) {
          str1 = paramaijj.jdField_h_of_type_JavaLangString;
        }
        for (;;)
        {
          paramaijj.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131698728) + " " + str1);
          break;
          if (paramaijj.jdField_h_of_type_Long > 0L) {
            str1 = String.valueOf(paramaijj.jdField_h_of_type_Long);
          } else {
            QLog.d("TroopNotifyAndRecommendView", 2, "setThirdLine " + paramaijj.jdField_a_of_type_Int + "actionName is Empty");
          }
        }
      }
      QLog.d("TroopNotifyAndRecommendView", 2, "setThirdLine " + paramaijj.jdField_c_of_type_Int + "reqSubMsgType is error value");
    }
  }
  
  private void d(aijj paramaijj)
  {
    int i1 = 1;
    if (paramaijj == null) {
      return;
    }
    int n = aiku.a(paramaijj.jdField_a_of_type_Int);
    if (paramaijj.jdField_a_of_type_Int == 91) {
      n = 3;
    }
    long l1;
    String str;
    Object localObject;
    switch (n)
    {
    default: 
      l1 = paramaijj.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get();
      str = paramaijj.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_name.get() + this.jdField_a_of_type_AndroidContentContext.getString(2131695994);
      localObject = String.valueOf(l1);
      n = 4;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = bfvo.b();
      }
      localObject = FaceDrawable.getFaceDrawable((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), n, (String)localObject, 3, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      paramaijj.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(str);
      paramaijj.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      return;
      localObject = paramaijj.jdField_a_of_type_JavaLangString;
      str = paramaijj.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get() + this.jdField_a_of_type_AndroidContentContext.getString(2131695993);
      n = i1;
      continue;
      localObject = String.valueOf(paramaijj.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get());
      str = paramaijj.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin_nick.get() + this.jdField_a_of_type_AndroidContentContext.getString(2131695992);
      n = i1;
      continue;
      l1 = paramaijj.jdField_d_of_type_Long;
      str = paramaijj.jdField_d_of_type_JavaLangString;
      localObject = String.valueOf(l1);
      n = 4;
    }
  }
  
  private void r()
  {
    aikq localaikq = (aikq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(383);
    if (localaikq == null) {
      return;
    }
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_contacts_news", "", "notice", "todo_tab_clk", 0, 0, "", "", "", "");
    localaikq.b(false);
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
      this.jdField_a_of_type_Aijs.b(localArrayList);
      this.jdField_a_of_type_Aijs.notifyDataSetChanged();
      this.jdField_a_of_type_Aijs.a(localaikq.b());
      this.jdField_a_of_type_Aijs.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_Aijs.notifyDataSetChanged();
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    setType(0);
    a(false);
    this.jdField_a_of_type_Aijs.a(localaikq.c());
    this.jdField_a_of_type_Aijs.jdField_a_of_type_Int = bcsz.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if ((this.jdField_c_of_type_JavaUtilList != null) && (this.jdField_c_of_type_JavaUtilList.size() > 0)) {
      this.jdField_a_of_type_Aijs.b(this.jdField_c_of_type_JavaUtilList);
    }
    this.jdField_a_of_type_Aijs.notifyDataSetChanged();
  }
  
  private void s()
  {
    aikq localaikq = (aikq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(383);
    if (localaikq == null) {
      return;
    }
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_contacts_news", "", "notice", "quit_tab_clk", 0, 0, "", "", "", "");
    localaikq.a(false);
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
      this.jdField_a_of_type_Aijs.b(localArrayList);
      this.jdField_a_of_type_Aijs.a(localaikq.a());
      this.jdField_a_of_type_Aijs.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_Aijs.notifyDataSetChanged();
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    setType(0);
    b(false);
    this.jdField_a_of_type_Aijs.a(localaikq.c());
    this.jdField_a_of_type_Aijs.jdField_a_of_type_Int = bcsz.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if ((this.jdField_c_of_type_JavaUtilList != null) && (this.jdField_c_of_type_JavaUtilList.size() > 0)) {
      this.jdField_a_of_type_Aijs.b(this.jdField_c_of_type_JavaUtilList);
    }
    this.jdField_a_of_type_Aijs.notifyDataSetChanged();
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
    aikq localaikq = (aikq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(383);
    if (localaikq == null) {
      return;
    }
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_contacts_news", "", "notice", "unnormal_tab_clk", 0, 0, "", "", "", "");
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
    this.jdField_a_of_type_Aijs.a(localaikq.c());
    this.jdField_a_of_type_Aijs.jdField_a_of_type_Int = bcsz.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Aijs.notifyDataSetChanged();
    c(false);
  }
  
  private void u()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    aikq localaikq;
    do
    {
      return;
      localaikq = (aikq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(383);
    } while (localaikq == null);
    List localList = localaikq.a("OidbSvc.0x5eb_troopnotifycation");
    if (localList != null) {
      localaikq.c(localList);
    }
    localList = localaikq.a("OidbSvc.0x668");
    if (localList != null) {
      localaikq.d(localList);
    }
    this.l = false;
  }
  
  private void v()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    aikq localaikq = (aikq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(383);
    if (this.jdField_a_of_type_Aijs != null) {
      if (this.jdField_c_of_type_Int == 0) {
        break label115;
      }
    }
    label115:
    for (this.jdField_a_of_type_Aijs.jdField_a_of_type_Int = 0;; this.jdField_a_of_type_Aijs.jdField_a_of_type_Int = bcsz.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      this.jdField_a_of_type_Aijs.notifyDataSetChanged();
      this.jdField_a_of_type_Amzp.jdField_c_of_type_Int = bcsz.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (localaikq != null)
      {
        c(localaikq.a());
        b(localaikq.b());
        a(false, 1);
        a(false, 2);
      }
      if (this.jdField_a_of_type_Aike == null) {
        break;
      }
      this.jdField_a_of_type_Aike.notifyDataSetChanged();
      return;
    }
  }
  
  private void w()
  {
    int n = bcsz.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (this.jdField_a_of_type_Aijs != null) {
      if (!ailu.b()) {
        break label49;
      }
    }
    label49:
    for (this.jdField_a_of_type_Aijs.jdField_a_of_type_Int = 0;; this.jdField_a_of_type_Aijs.jdField_a_of_type_Int = n)
    {
      ThreadManager.postImmediately(new TroopNotifyAndRecommendView.6(this), this.jdField_a_of_type_ComTencentMobileqqAppThreadExcutor$IThreadListener, false);
      return;
    }
  }
  
  private void x()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    aikq localaikq;
    do
    {
      return;
      localaikq = (aikq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(383);
    } while ((localaikq == null) || (this.jdField_a_of_type_JavaUtilList == null));
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotifyAndRecommendView", 2, new Object[] { "Get MessageRecords From DB Real Size =", Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()) });
    }
    Object localObject1 = localaikq.a(this.jdField_a_of_type_JavaUtilList);
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotifyAndRecommendView", 2, new Object[] { "Get MessageRecords From DB No Seq Size =", Integer.valueOf(((List)localObject1).size()) });
    }
    setAndCheckNotifyFollowSeq((List)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (ailu.b())
    {
      setType(1);
      ailu.b(false);
    }
    Object localObject2 = new ArrayList();
    int n = 0;
    while (n < ((List)localObject1).size())
    {
      ((List)localObject2).add(((List)localObject1).get(((List)localObject1).size() - n - 1));
      n += 1;
    }
    localaikq.a((List)localObject2, bcsz.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    localObject2 = localaikq.c();
    List localList2 = localaikq.a();
    List localList1 = localaikq.b();
    if (this.jdField_c_of_type_Int == 1) {
      a(true);
    }
    for (localObject1 = localList1;; localObject1 = localObject2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopNotifyAndRecommendView", 2, new Object[] { "withoutExitDatas Size =", Integer.valueOf(((List)localObject2).size()), "exitDataList Size =", Integer.valueOf(localList2.size()), "undealDataList Size=", Integer.valueOf(localList1.size()) });
      }
      if ((localObject2 == null) || (((List)localObject2).size() <= 0) || ((((List)localObject2).get(0) instanceof MessageForSystemMsg))) {
        break label390;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopNotifyAndRecommendView", 2, "initNotificationListData error");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.clearGroupSystemMsgHistory();
      if (this.jdField_a_of_type_Aijs == null) {
        break;
      }
      this.jdField_a_of_type_Aijs.a(null);
      this.jdField_a_of_type_Aijs.notifyDataSetChanged();
      return;
    }
    label390:
    if (this.jdField_a_of_type_Aijs != null)
    {
      this.jdField_a_of_type_Aijs.a((List)localObject1);
      this.jdField_a_of_type_Aijs.notifyDataSetChanged();
      this.jdField_a_of_type_Aijs.a(this.jdField_a_of_type_Amzp);
    }
    c(localList2);
    b(localList1);
    if (!localaikq.b()) {
      a(false, 2);
    }
    if (localaikq.a()) {
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
      localObject1 = (aikq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(383);
    } while (localObject1 == null);
    Object localObject3 = "";
    String str = "";
    List localList = ((aikq)localObject1).d();
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
      bftc.a("Grp_contacts_news", "notice", "enter_verify", 0, 0, new String[] { localObject2, localObject1 });
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
            break label339;
          }
          localObject2 = localObject3;
          localObject1 = str;
          if (localList.size() <= 0) {
            break label339;
          }
          localObject1 = (MessageRecord)localList.get(0);
          if (!(localObject1 instanceof MessageForSystemMsg)) {
            break label331;
          }
          long l1 = ((MessageForSystemMsg)localObject1).getSystemMsg().msg.group_code.get();
          localObject1 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(l1 + "");
          if (localObject1 == null) {
            break label331;
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
          label331:
          localObject1 = "3";
        }
      }
      label339:
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
    }
  }
  
  private void z()
  {
    ThreadManager.postImmediately(new TroopNotifyAndRecommendView.10(this), null, false);
  }
  
  public int a()
  {
    return getResources().getDimensionPixelSize(2131299076);
  }
  
  public void a(aijj paramaijj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotifyAndRecommendView", 2, "handleGroupSystemMsg! start " + paramaijj.jdField_a_of_type_Long);
    }
    b(paramaijj, 998);
    Object localObject = paramaijj.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_info.msg_alert.get();
    String str4 = paramaijj.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get() + "";
    String str2;
    int n;
    label147:
    String str1;
    if ((this.jdField_a_of_type_Aijs != null) && (paramaijj.jdField_b_of_type_Int < this.jdField_a_of_type_Aijs.jdField_a_of_type_Int))
    {
      str2 = "1";
      n = paramaijj.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_inviter_role.get();
      if ((n != 2) && (n != 3)) {
        break label311;
      }
      n = 0;
      switch (paramaijj.jdField_a_of_type_Int)
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
        paramaijj = "";
        localObject = "";
        str1 = "";
      }
    }
    for (;;)
    {
      bftc.a("Grp_contacts_news", "notice", str1, 3, 0, new String[] { str4, str2, localObject, paramaijj });
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
        if (paramaijj.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get() != 1) {
          break label374;
        }
        paramaijj = "0";
        break;
      }
      label374:
      long l1 = paramaijj.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actor_uin.get();
      if ((l1 != 0L) && (!(l1 + "").equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {}
      for (paramaijj = "2";; paramaijj = "1") {
        break;
      }
      paramaijj = "";
      localObject = "";
      str1 = "refuseask_page";
      continue;
      if (paramaijj.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get() == 1) {}
      for (paramaijj = "0";; paramaijj = "1")
      {
        localObject = "";
        str1 = "enter_invite";
        break;
      }
      if (n != 0) {}
      String str3;
      for (paramaijj = "0";; paramaijj = "1")
      {
        str1 = "refuseinvite_page";
        str3 = "";
        localObject = paramaijj;
        paramaijj = str3;
        break;
      }
      if (n != 0) {}
      for (paramaijj = "0";; paramaijj = "1")
      {
        str1 = "refuseagree_page";
        str3 = "";
        localObject = paramaijj;
        paramaijj = str3;
        break;
      }
      paramaijj = "";
      localObject = "";
      str1 = "quit_page";
      continue;
      str1 = "byquit_page";
      paramaijj = "";
      localObject = "0";
      continue;
      str1 = "byquit_page";
      paramaijj = "";
      localObject = "1";
      continue;
      if ((paramaijj.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get() + "").equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {}
      for (paramaijj = "0";; paramaijj = "1")
      {
        str1 = "set_admin_page";
        str3 = "";
        localObject = paramaijj;
        paramaijj = str3;
        break;
      }
      str1 = "un_admin_page";
      paramaijj = "";
      localObject = "0";
      continue;
      str1 = "un_admin_page";
      paramaijj = "";
      localObject = "1";
    }
  }
  
  public void a(aijj paramaijj, int paramInt)
  {
    int i1 = -1;
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotifyAndRecommendView", 2, "bindTroopSystemMsgView! start " + paramaijj.jdField_a_of_type_Long);
    }
    structmsg.StructMsg localStructMsg = paramaijj.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
    paramaijj.jdField_a_of_type_Long = paramInt;
    paramaijj.jdField_a_of_type_JavaLangString = (localStructMsg.req_uin.get() + "");
    paramaijj.jdField_a_of_type_Int = localStructMsg.msg.group_msg_type.get();
    paramInt = localStructMsg.msg.sub_type.get();
    paramaijj.jdField_b_of_type_Long = localStructMsg.msg_time.get();
    paramaijj.jdField_b_of_type_JavaLangString = localStructMsg.msg.req_uin_nick.get();
    Object localObject;
    if ((paramaijj.jdField_b_of_type_JavaLangString != null) && (!paramaijj.jdField_b_of_type_JavaLangString.equals("")))
    {
      if (paramaijj.jdField_a_of_type_Int == 91)
      {
        localObject = new aiiy(localStructMsg);
        if (((aiiy)localObject).a())
        {
          paramaijj.jdField_c_of_type_Int = ((aiiy)localObject).jdField_c_of_type_Int;
          paramaijj.jdField_g_of_type_JavaLangString = ((aiiy)localObject).jdField_a_of_type_JavaLangString;
          paramaijj.jdField_g_of_type_Long = ((aiiy)localObject).jdField_a_of_type_Long;
          paramaijj.jdField_h_of_type_JavaLangString = ((aiiy)localObject).jdField_b_of_type_JavaLangString;
          paramaijj.jdField_h_of_type_Long = ((aiiy)localObject).jdField_b_of_type_Long;
          paramaijj.jdField_d_of_type_Int = ((aiiy)localObject).jdField_a_of_type_Int;
          paramaijj.jdField_d_of_type_Long = ((aiiy)localObject).jdField_c_of_type_Long;
          paramaijj.jdField_d_of_type_JavaLangString = ((aiiy)localObject).jdField_c_of_type_JavaLangString;
          paramaijj.jdField_e_of_type_Long = ((aiiy)localObject).jdField_d_of_type_Long;
          paramaijj.jdField_e_of_type_JavaLangString = ((aiiy)localObject).jdField_d_of_type_JavaLangString;
          paramaijj.jdField_f_of_type_Long = ((aiiy)localObject).jdField_e_of_type_Long;
          paramaijj.jdField_f_of_type_JavaLangString = ((aiiy)localObject).jdField_e_of_type_JavaLangString;
        }
      }
      b(paramaijj, localStructMsg);
      a(paramaijj.jdField_a_of_type_Aiji, localStructMsg, false);
      paramaijj.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      localObject = localStructMsg.msg.group_info.msg_alert.get();
      a(paramaijj, localStructMsg, (String)localObject);
      a(paramaijj, localStructMsg);
      a(paramaijj, localStructMsg, paramInt, (String)localObject);
      if ((paramInt == 2) && (paramaijj.jdField_a_of_type_Int == 2) && (((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(String.valueOf(localStructMsg.msg.group_code.get())) != null)) {
        avnw.a().b(String.valueOf(localStructMsg.msg.group_code.get()), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      if (localStructMsg.msg.bytes_warning_tips.get() == null) {
        break label741;
      }
      localObject = localStructMsg.msg.bytes_warning_tips.get().toStringUtf8();
      label459:
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label749;
      }
      paramaijj.jdField_d_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      paramaijj.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      label484:
      if (QLog.isColorLevel()) {
        QLog.d("Q.security_verify", 2, String.format("bindTroopSystemMsgView reqUin: %s, warningTips: %s", new Object[] { paramaijj.jdField_a_of_type_JavaLangString, localObject }));
      }
      paramaijj.jdField_a_of_type_AndroidWidgetLinearLayout.setTag(paramaijj);
      paramaijj.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramaijj.jdField_a_of_type_AndroidWidgetImageView.setTag(paramaijj);
      if ((paramaijj.jdField_a_of_type_Int != 8) && (paramaijj.jdField_a_of_type_Int != 7)) {
        break label761;
      }
      paramaijj.jdField_a_of_type_AndroidWidgetImageView.setEnabled(false);
      label572:
      d(paramaijj);
      if (((paramaijj.jdField_a_of_type_Int == 1) || (paramaijj.jdField_a_of_type_Int == 22) || (paramaijj.jdField_a_of_type_Int == 60)) && (QLog.isColorLevel())) {
        if ((!localStructMsg.msg.has()) || (!localStructMsg.msg.src_id.has())) {
          break label772;
        }
      }
    }
    label772:
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
      QLog.i("TroopNotifyAndRecommendView", 2, String.format("joinGroup subSourceID=%d sourceID=%d msgType=%d", new Object[] { Integer.valueOf(n), Integer.valueOf(paramInt), Integer.valueOf(paramaijj.jdField_a_of_type_Int) }));
      return;
      paramaijj.jdField_b_of_type_JavaLangString = paramaijj.jdField_a_of_type_JavaLangString;
      break;
      label741:
      localObject = "";
      break label459;
      label749:
      paramaijj.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      break label484;
      label761:
      paramaijj.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      break label572;
    }
  }
  
  protected void a(Intent paramIntent, aiiz paramaiiz)
  {
    super.a(paramIntent, paramaiiz);
    this.jdField_a_of_type_Amzp = ((amzp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(22));
    this.jdField_a_of_type_Avtd = ((avtd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37));
    i();
    b(paramIntent, paramaiiz);
    c(paramIntent, paramaiiz);
    this.jdField_a_of_type_AndroidWidgetTextView = paramaiiz.a();
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_contacts_news", "", "notice", "notice_exp", 0, 0, "", "", "", "");
  }
  
  public void a(List<RecommendTroopItem> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotifyAndRecommendView", 2, "handleRecommendDataResult: " + Log.getStackTraceString(new RuntimeException("debug trace")));
    }
    this.jdField_a_of_type_Aiiz.a(new TroopNotifyAndRecommendView.21(this, paramList));
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
      localObject = (aikq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(383);
    } while (localObject == null);
    b(((aikq)localObject).b());
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
        Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837986);
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
      if (this.jdField_a_of_type_Bhht != null)
      {
        this.jdField_a_of_type_Bhht.c(2131718142);
        this.jdField_a_of_type_Bhht.show();
      }
    }
  }
  
  protected int b()
  {
    int i2 = amzp.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (i2 > 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().d(AppConstants.TROOP_NOTIFICATION_UIN, 9000, 0 - i2);
      this.jdField_a_of_type_Amzp.b();
      o();
    }
    int i1 = 0;
    int n = i1;
    if (this.jdField_a_of_type_Amzp != null)
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
  
  protected void b(Intent paramIntent, aiiz paramaiiz)
  {
    a(this.jdField_a_of_type_Aikt);
    a(this.jdField_a_of_type_Amwl);
    C();
    w();
    this.jdField_a_of_type_Bhht = new bhht(this.jdField_a_of_type_AndroidContentContext, a());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
    if (aiku.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) > 0) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a().a(3);
    }
    aiku.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (this.jdField_a_of_type_Aijs != null) {
      this.jdField_a_of_type_Aijs.notifyDataSetChanged();
    }
    int n = bcsz.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotifyAndRecommendView", 2, "notification num:" + n);
    }
    this.jdField_a_of_type_Amzp.jdField_c_of_type_Int = n;
    int i1 = amzp.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().d(AppConstants.TROOP_NOTIFICATION_UIN, 9000, 0 - (n + i1));
    bcsz.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
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
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_contacts_news", "", "notice", "todo_tab_exp", 0, 0, "", "", "", "");
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
  
  protected void c(Intent paramIntent, aiiz paramaiiz)
  {
    super.a(paramIntent, paramaiiz);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().addObserver(this);
    a(this.jdField_a_of_type_Andd);
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
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_contacts_news", "", "notice", "quit_tab_exp", 0, 0, "", "", "", "");
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
      aiku.b();
      bcsz.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
      if (this.jdField_a_of_type_Aijs != null)
      {
        this.jdField_a_of_type_Aijs.jdField_a_of_type_Int = 0;
        this.jdField_a_of_type_Aijs.notifyDataSetChanged();
      }
      this.jdField_a_of_type_Amzp.jdField_c_of_type_Int = bcsz.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    if (this.jdField_c_of_type_Int == 3) {
      bcsz.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
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
    if (this.jdField_a_of_type_Amzp != null) {
      this.jdField_a_of_type_Amzp.b();
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
    if (this.jdField_a_of_type_Aijs != null) {
      this.jdField_a_of_type_Aijs.b();
    }
    if ((this.jdField_a_of_type_Aijs != null) && (this.jdField_a_of_type_Aijs.a() > 0)) {
      B();
    }
    b(this.jdField_a_of_type_Andd);
    b(this.jdField_a_of_type_Aikt);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(TroopNotifyAndRecommendView.class);
    if (localObject != null) {
      ((MqqHandler)localObject).removeCallbacksAndMessages(null);
    }
    b(this.jdField_a_of_type_Amwl);
    if (this.jdField_a_of_type_Aijs != null)
    {
      this.jdField_a_of_type_Aijs.a();
      this.jdField_a_of_type_Aijs.notifyDataSetChanged();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().deleteObserver(this);
    aiku.b();
    bcsz.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
    if (this.jdField_c_of_type_Boolean) {
      bcsz.a().b();
    }
    bfkc.a(a()).a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeHandler(getClass());
    if (this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener != null) {
      SosoInterface.removeOnLocationListener(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener);
    }
    this.jdField_a_of_type_Amzp.b();
    this.jdField_a_of_type_Amzp.d();
    this.jdField_a_of_type_Amzp.a();
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.setDecodeTaskCompletionListener(null);
    }
    if (this.jdField_a_of_type_Aike != null)
    {
      this.jdField_a_of_type_Aike.a();
      this.jdField_a_of_type_Aike.notifyDataSetChanged();
    }
    localObject = (aikq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(383);
    if (localObject != null)
    {
      ((aikq)localObject).b();
      ((aikq)localObject).a();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().d(AppConstants.TROOP_NOTIFICATION_UIN, 9000, 0 - bcsz.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
  }
  
  public void i()
  {
    a(2131559899);
    this.jdField_a_of_type_Aijs = new aijs(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getContext(), this.jdField_a_of_type_Aiiz, this);
    this.jdField_a_of_type_ComTencentWidgetSwipListView = ((SwipListView)findViewById(2131379226));
    this.jdField_f_of_type_AndroidViewView = findViewById(2131364552);
    this.jdField_g_of_type_AndroidViewView = findViewById(2131378086);
    this.jdField_h_of_type_AndroidViewView = findViewById(2131378081);
    this.jdField_i_of_type_AndroidViewView = findViewById(2131378090);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378089));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131378087));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378088));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378084));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131378082));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378083));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378091));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131378092));
    p();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopSlideAndOverScrollRecyclerView.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDragEnable(true);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setAdapter(this.jdField_a_of_type_Aijs);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setOnScrollListener(this);
    this.jdField_i_of_type_AndroidViewView.setOnClickListener(new aikw(this));
    this.jdField_h_of_type_AndroidViewView.setOnClickListener(new aile(this));
    this.jdField_g_of_type_AndroidViewView.setOnClickListener(new ailn(this));
  }
  
  public void j()
  {
    bfur.a(this.jdField_a_of_type_AndroidContentContext, null, this.jdField_a_of_type_AndroidContentContext.getString(2131719254), null, 2131690620, 2131694416, new aila(this), new ailb(this)).show();
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    B();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.clearGroupSystemMsg();
    bcsz.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
    aikq localaikq = (aikq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(383);
    if (localaikq != null) {
      localaikq.a();
    }
    if (this.jdField_a_of_type_Aijs != null)
    {
      this.jdField_a_of_type_Aijs.a();
      this.jdField_a_of_type_Aijs.notifyDataSetChanged();
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
      this.jdField_a_of_type_Amzp.a();
    }
    if ((!this.k) && (this.jdField_a_of_type_Aijs != null))
    {
      this.jdField_a_of_type_Aijs.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_Aijs.notifyDataSetChanged();
    }
    b();
    m();
  }
  
  protected void m()
  {
    if ((this.jdField_f_of_type_Boolean) && (this.jdField_a_of_type_Aijs != null) && (this.jdField_a_of_type_Aijs.b()))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("TroopNotifyAndRecommendView", 4, "reportPv");
      }
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_recom", "", "msg_page", "exp", 0, 0, "", "", "", "");
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
    if ((this.jdField_a_of_type_Amzp != null) && (!this.jdField_b_of_type_Boolean) && (amzp.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) > 0))
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
    Object localObject2;
    Object localObject3;
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
      case 2131371655: 
        bdyk.a(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        break;
      case 2131373586: 
        if ((paramView.getTag() instanceof aijj))
        {
          localObject2 = (aijj)paramView.getTag();
          if (localObject2 != null)
          {
            localObject3 = ((aijj)localObject2).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
            n = ((aijj)localObject2).jdField_a_of_type_Int;
            if (aiku.a(n) == 0)
            {
              localObject1 = String.valueOf(((aijj)localObject2).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get());
              if (n == 91) {
                localObject1 = String.valueOf(((aijj)localObject2).jdField_d_of_type_Long);
              }
              localObject1 = TroopInfoActivity.a((String)localObject1, 4);
              ((Bundle)localObject1).putInt("t_s_f", 1001);
              TroopUtils.openTroopInfoActivity(a(), (Bundle)localObject1, 2);
              if ((n == 2) || (n == 10) || (n == 12))
              {
                n = 1;
                label212:
                localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
                String str = ((aijj)localObject2).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get() + "";
                if (n == 0) {
                  break label371;
                }
                localObject1 = "0";
                label262:
                bcef.b((QQAppInterface)localObject3, "P_CliOper", "Grp_contacts", "", "notice", "see_data", 0, 0, str, (String)localObject1, "", "");
                localObject2 = ((aijj)localObject2).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code + "";
                if (n == 0) {
                  break label379;
                }
              }
              label371:
              label379:
              for (localObject1 = "0";; localObject1 = "1")
              {
                bftc.a("Grp_contacts_news", "notice", "see_data", 0, 0, new String[] { localObject2, localObject1 });
                break;
                n = 0;
                break label212;
                localObject1 = "1";
                break label262;
              }
            }
            if ((((aijj)localObject2).jdField_a_of_type_Int != 2) || (!TroopInfo.isQidianPrivateTroop(((aijj)localObject2).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.uint32_group_flagext3.get())))
            {
              if (((aijj)localObject2).jdField_a_of_type_Int != 82) {
                break label505;
              }
              localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, AccountDetailActivity.class);
              ((Intent)localObject1).putExtra("uin", ((aijj)localObject2).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get() + "");
              ((Intent)localObject1).putExtra("source", 112);
              a((Intent)localObject1);
            }
          }
        }
        break;
      }
    }
    label505:
    l1 = ((structmsg.StructMsg)localObject3).req_uin.get();
    switch (aiku.a(n))
    {
    default: 
      localObject1 = String.valueOf(l1);
      label546:
      if (((amsw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b((String)localObject1)) {
        localObject1 = new ProfileActivity.AllInOne((String)localObject1, 1);
      }
      break;
    }
    for (;;)
    {
      l1 = ((structmsg.StructMsg)localObject3).msg.uint32_group_flagext3.get();
      boolean bool = TroopInfo.isQidianPrivateTroop(l1);
      n = ((structmsg.StructMsg)localObject3).msg.group_msg_type.get();
      if (QLog.isColorLevel()) {
        QLog.d(".troop.qidian_private_troop", 2, "notification headView onClick: msgType=" + n + ", isQidianPrivateTroop=" + bool + ", flagExt3=" + l1);
      }
      if ((bool) && (n == 2)) {
        break;
      }
      ProfileActivity.b(a(), (ProfileActivity.AllInOne)localObject1);
      bftc.a("Grp_contacts_news", "notice", "see_fromdata", 0, 0, new String[] { ((aijj)localObject2).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code + "", "3" });
      break;
      localObject1 = ((aijj)localObject2).jdField_a_of_type_JavaLangString;
      break label546;
      localObject1 = String.valueOf(((aijj)localObject2).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get());
      break label546;
      if ((((structmsg.StructMsg)localObject3).msg.group_msg_type.get() == 2) && (((structmsg.StructMsg)localObject3).msg.sub_type.get() == 3))
      {
        localObject1 = new ProfileActivity.AllInOne((String)localObject1, 26);
        ((ProfileActivity.AllInOne)localObject1).jdField_d_of_type_Int = 1;
      }
      else
      {
        localObject1 = new ProfileActivity.AllInOne((String)localObject1, 24);
        TroopUtils.prepareTroopNotifyData((structmsg.StructMsg)localObject3, (ProfileActivity.AllInOne)localObject1);
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
    if (this.jdField_a_of_type_Aijs != null) {
      this.jdField_a_of_type_Aijs.a(this.jdField_d_of_type_Int, this.jdField_c_of_type_Int);
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
      if (this.jdField_a_of_type_Aijs == null) {
        break label99;
      }
    }
    label99:
    for (int n = this.jdField_a_of_type_Aijs.getCount();; n = 0)
    {
      QLog.d("TroopNotifyAndRecommendView", 2, n);
      if ((this.jdField_a_of_type_Aijs != null) && (paramInt == 0) && (this.jdField_d_of_type_Int == this.jdField_a_of_type_Aijs.getCount() - 1)) {
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
    bcsz.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
    this.jdField_b_of_type_JavaUtilList.clear();
    if (this.jdField_a_of_type_Aike != null) {
      this.jdField_a_of_type_Aike.a();
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