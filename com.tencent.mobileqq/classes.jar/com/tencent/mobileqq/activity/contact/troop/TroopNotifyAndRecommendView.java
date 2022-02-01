package com.tencent.mobileqq.activity.contact.troop;

import adab;
import ajjh;
import ajoe;
import ajoo;
import ajop;
import ajov;
import ajpe;
import ajpp;
import ajpz;
import ajqa;
import ajqb;
import ajqc;
import ajqd;
import ajqe;
import ajqf;
import ajqg;
import ajqh;
import ajqi;
import ajqj;
import ajqk;
import ajql;
import ajqm;
import ajqn;
import ajqo;
import ajqp;
import ajqq;
import ajqr;
import ajqs;
import ajqt;
import ajqu;
import ajqv;
import ajqw;
import ajqx;
import ajrj;
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
import antf;
import anws;
import anyw;
import anzj;
import aocj;
import aoga;
import aojs;
import aoof;
import aoog;
import aoot;
import aoti;
import apcq;
import axap;
import axfw;
import bcrg;
import bdll;
import bdzi;
import bfpa;
import bgrb;
import bguq;
import bhaq;
import bhju;
import bhlg;
import bhlq;
import bhmq;
import bhnv;
import bhpc;
import bhtq;
import bjbs;
import blih;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.qqstory.widget.OverScrollRecyclerView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.Stranger;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.troop.data.RecommendTroopItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
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
  implements ajjh, View.OnClickListener, aoog, blih, Observer
{
  protected static long c;
  public final long a;
  private ajoe jdField_a_of_type_Ajoe;
  public ajpe a;
  public ajqa a;
  public Context a;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  protected View.OnClickListener a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  public TextView a;
  aocj jdField_a_of_type_Aocj = new ajqv(this);
  public aoga a;
  aojs jdField_a_of_type_Aojs = new ajqi(this);
  public aoof a;
  protected apcq a;
  private axfw jdField_a_of_type_Axfw;
  public bjbs a;
  private OverScrollRecyclerView jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView;
  private ThreadExcutor.IThreadListener jdField_a_of_type_ComTencentMobileqqAppThreadExcutor$IThreadListener = new ajqt(this);
  public SwipListView a;
  protected List<MessageRecord> a;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = new ajqs(this);
  public int b;
  public final long b;
  protected View.OnClickListener b;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  protected List<MessageRecord> b;
  public int c;
  View.OnClickListener jdField_c_of_type_AndroidViewView$OnClickListener = new ajqn(this);
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  public List<RecommendTroopItem> c;
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
  
  public TroopNotifyAndRecommendView(Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_c_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Long = 1000L;
    this.jdField_b_of_type_Long = 500L;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new ajqu(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new ajqd(this);
    this.jdField_a_of_type_Ajqa = new ajqh(this);
    this.jdField_g_of_type_Boolean = true;
    this.jdField_e_of_type_Int = 0;
    this.jdField_d_of_type_AndroidViewView$OnClickListener = new ajqp(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void A()
  {
    this.jdField_f_of_type_Int = bdzi.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.setAdapter(this.jdField_a_of_type_Ajoe);
    this.jdField_b_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(antf.O, 0);
    ajrj.a(this.jdField_b_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    ArrayList localArrayList = new ArrayList();
    int m = 0;
    while (m < this.jdField_b_of_type_JavaUtilList.size())
    {
      localArrayList.add(this.jdField_b_of_type_JavaUtilList.get(this.jdField_b_of_type_JavaUtilList.size() - m - 1));
      m += 1;
    }
    this.jdField_b_of_type_JavaUtilList = localArrayList;
    if ((this.jdField_b_of_type_JavaUtilList != null) && (this.jdField_b_of_type_JavaUtilList.size() > 0))
    {
      if (this.jdField_i_of_type_AndroidViewView.getVisibility() == 8) {
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_contacts_news", "", "notice", "unnormal_tab_exp", 0, 0, "", "", "", "");
      }
      this.jdField_i_of_type_AndroidViewView.setVisibility(0);
      if (!(this.jdField_b_of_type_JavaUtilList.get(0) instanceof MessageForSystemMsg))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopNotifyAndRecommendView", 2, "initListData error");
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.y();
        this.jdField_a_of_type_Ajoe.a(null);
      }
    }
    else
    {
      this.jdField_i_of_type_AndroidViewView.setVisibility(8);
    }
    this.jdField_a_of_type_Ajoe.a(this.jdField_b_of_type_JavaUtilList);
    this.jdField_a_of_type_Ajoe.notifyDataSetChanged();
    x();
  }
  
  private void B()
  {
    if (this.jdField_e_of_type_Boolean) {}
    do
    {
      do
      {
        return;
        if (!bhnv.d(BaseApplication.getContext()))
        {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131691989), 0).b(a());
          return;
        }
      } while ((this.jdField_a_of_type_Axfw != null) && (this.jdField_a_of_type_Axfw.b()));
      this.jdField_e_of_type_Boolean = true;
      if (this.jdField_a_of_type_Ajoe != null) {
        this.jdField_a_of_type_Ajoe.a(new ajqq(this));
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().c(3);
    } while (!QLog.isColorLevel());
    QLog.i("TroopNotifyAndRecommendView", 2, "loadNextPage.get next page.");
  }
  
  private void C()
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopNotifyAndRecommendView", 2, "stopLoadMore().");
    }
    if (this.jdField_a_of_type_Ajoe != null) {
      this.jdField_a_of_type_Ajoe.b();
    }
    this.jdField_e_of_type_Boolean = false;
  }
  
  private void D()
  {
    ThreadManager.post(new TroopNotifyAndRecommendView.27(this), 8, null, false);
  }
  
  private void E()
  {
    this.jdField_g_of_type_Int = bdzi.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
    bgrb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong, new ajqe(this), localBundle);
  }
  
  private void a(ajoo paramajoo, MessageRecord paramMessageRecord, int paramInt)
  {
    ajpp localajpp = (ajpp)paramajoo;
    if ((paramMessageRecord == null) || (!(paramMessageRecord instanceof MessageForSystemMsg))) {}
    int m;
    do
    {
      return;
      localajpp.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = ((MessageForSystemMsg)paramMessageRecord).getSystemMsg();
      localajpp.jdField_c_of_type_Long = paramMessageRecord.uniseq;
      m = 2;
      if (paramMessageRecord != null) {
        m = ((MessageForSystemMsg)paramMessageRecord).getSystemMsg().msg_type.get();
      }
    } while (m != 2);
    structmsg.StructMsg localStructMsg;
    label206:
    String str;
    label289:
    Object localObject1;
    if (paramInt < this.jdField_g_of_type_Int)
    {
      ajrj.a(paramajoo.a(), true);
      localStructMsg = localajpp.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
      localajpp.jdField_a_of_type_Long = paramInt;
      localajpp.jdField_a_of_type_JavaLangString = (localStructMsg.req_uin.get() + "");
      localajpp.jdField_a_of_type_Int = localStructMsg.msg.group_msg_type.get();
      paramInt = localStructMsg.msg.sub_type.get();
      localajpp.jdField_b_of_type_Long = localStructMsg.msg_time.get();
      localajpp.jdField_b_of_type_JavaLangString = localStructMsg.msg.req_uin_nick.get();
      if ((localajpp.jdField_b_of_type_JavaLangString == null) || (localajpp.jdField_b_of_type_JavaLangString.equals(""))) {
        break label721;
      }
      a(localajpp, localStructMsg);
      localajpp.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      str = localStructMsg.msg.group_info.msg_alert.get();
      paramMessageRecord = "";
      if (localStructMsg.msg.bytes_warning_tips.get() != null) {
        paramMessageRecord = localStructMsg.msg.bytes_warning_tips.get().toStringUtf8();
      }
      if (!TextUtils.isEmpty(paramMessageRecord)) {
        break label734;
      }
      localajpp.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      if (localajpp.jdField_a_of_type_Int != 22) {
        break label813;
      }
      paramMessageRecord = localStructMsg.msg;
      localajpp.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      localObject1 = new SpannableString(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131718513, new Object[] { paramMessageRecord.action_uin_nick.get() }));
      ((SpannableString)localObject1).setSpan(new ForegroundColorSpan(Color.parseColor("#00a5e0")), 6, paramMessageRecord.action_uin_nick.get().length() + 6, 33);
      localajpp.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      localajpp.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(new ajqm(this, paramMessageRecord));
    }
    for (;;)
    {
      paramMessageRecord = bguq.a(localStructMsg, localStructMsg.msg.msg_describe.get());
      if (paramMessageRecord == null) {
        break label1072;
      }
      localajpp.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessageRecord);
      label442:
      if (localajpp.jdField_a_of_type_Int != 80) {
        break label1130;
      }
      paramMessageRecord = localStructMsg.msg.actions.get();
      localajpp.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
      localajpp.jdField_a_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)paramMessageRecord.get(0)).name.get());
      localajpp.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131755351);
      localajpp.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839325);
      localajpp.jdField_a_of_type_AndroidWidgetButton.setContentDescription(localajpp.jdField_a_of_type_AndroidWidgetButton.getText() + "");
      localajpp.jdField_a_of_type_AndroidWidgetButton.setTag(localajpp);
      localajpp.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
      label579:
      if (!TextUtils.isEmpty(localajpp.jdField_a_of_type_AndroidWidgetButton.getText())) {
        break label1457;
      }
      localajpp.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      label603:
      if ((paramInt == 2) && (localajpp.jdField_a_of_type_Int == 2) && (((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(String.valueOf(localStructMsg.msg.group_code.get())) != null)) {
        axap.a().b(String.valueOf(localStructMsg.msg.group_code.get()), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      localajpp.jdField_a_of_type_AndroidWidgetLinearLayout.setTag(paramajoo);
      localajpp.jdField_a_of_type_AndroidWidgetImageView.setTag(paramajoo);
      localajpp.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
      a(localajpp);
      return;
      ajrj.a(paramajoo.a(), false);
      break;
      label721:
      localajpp.jdField_b_of_type_JavaLangString = localajpp.jdField_a_of_type_JavaLangString;
      break label206;
      label734:
      localajpp.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      localajpp.jdField_c_of_type_AndroidWidgetTextView.setText(paramMessageRecord);
      paramMessageRecord = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847814);
      paramMessageRecord.setBounds(0, 0, bhtq.a(16.0F), bhtq.a(16.0F));
      localajpp.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(bhtq.a(5.0F));
      localajpp.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawables(paramMessageRecord, null, null, null);
      break label289;
      label813:
      if ((localajpp.jdField_a_of_type_Int == 2) && (localStructMsg.msg.msg_invite_extinfo.uint32_src_type.has()))
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
      localajpp.jdField_c_of_type_AndroidWidgetTextView.setText(anzj.a(2131706504) + paramMessageRecord);
      localajpp.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      break;
      Object localObject2 = (anws)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53);
      paramMessageRecord = (MessageRecord)localObject1;
      if (localObject2 != null)
      {
        localObject2 = ((anws)localObject2).a(String.valueOf(localStructMsg.msg.msg_invite_extinfo.uint64_src_code.get()));
        paramMessageRecord = (MessageRecord)localObject1;
        if (localObject2 != null) {
          paramMessageRecord = ((DiscussionInfo)localObject2).discussionName;
        }
      }
      localajpp.jdField_c_of_type_AndroidWidgetTextView.setText(anzj.a(2131706493) + paramMessageRecord);
      localajpp.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      break;
      label1072:
      paramMessageRecord = localStructMsg.msg.msg_additional.get();
      if ((paramMessageRecord == null) || ("".equals(paramMessageRecord)))
      {
        localajpp.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131695532));
        break label442;
      }
      localajpp.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessageRecord);
      break label442;
      label1130:
      if (paramInt == 1)
      {
        paramMessageRecord = localStructMsg.msg.actions.get();
        localajpp.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
        if ((paramMessageRecord != null) && (paramMessageRecord.size() > 0))
        {
          if ((str == null) || ("".equals(str))) {
            if (paramMessageRecord.size() > 1)
            {
              localajpp.jdField_a_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)paramMessageRecord.get(1)).name.get());
              localajpp.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131755351);
              localajpp.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839325);
            }
          }
          for (;;)
          {
            localajpp.jdField_a_of_type_AndroidWidgetButton.setContentDescription(localajpp.jdField_a_of_type_AndroidWidgetButton.getText() + "");
            localajpp.jdField_a_of_type_AndroidWidgetButton.setTag(paramajoo);
            localajpp.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
            break;
            localajpp.jdField_a_of_type_AndroidWidgetButton.setText("");
            continue;
            localajpp.jdField_a_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)paramMessageRecord.get(0)).name.get());
            localajpp.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131755350);
            localajpp.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839324);
          }
        }
        localajpp.jdField_a_of_type_AndroidWidgetButton.setText("");
        localajpp.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(null);
        break label579;
      }
      localajpp.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(null);
      localajpp.jdField_a_of_type_AndroidWidgetButton.setClickable(false);
      localajpp.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131755972);
      localajpp.jdField_a_of_type_AndroidWidgetButton.setText(localStructMsg.msg.msg_decided.get());
      paramMessageRecord = (RelativeLayout.LayoutParams)localajpp.jdField_a_of_type_AndroidWidgetButton.getLayoutParams();
      break label579;
      label1457:
      localajpp.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      break label603;
    }
  }
  
  private void a(ajov paramajov, structmsg.StructMsg paramStructMsg)
  {
    String str = bguq.a(paramStructMsg, paramStructMsg.msg.msg_describe.get());
    if (str != null)
    {
      paramajov.jdField_b_of_type_AndroidWidgetTextView.setText(str);
      return;
    }
    paramStructMsg = paramStructMsg.msg.msg_additional.get();
    if ((paramStructMsg == null) || ("".equals(paramStructMsg)))
    {
      paramajov.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131695532));
      return;
    }
    paramajov.jdField_b_of_type_AndroidWidgetTextView.setText(paramStructMsg);
  }
  
  private void a(ajov paramajov, structmsg.StructMsg paramStructMsg, int paramInt, String paramString)
  {
    if (paramajov.jdField_a_of_type_Int == 80)
    {
      paramStructMsg = paramStructMsg.msg.actions.get();
      paramajov.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
      paramajov.jdField_a_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)paramStructMsg.get(0)).name.get());
      paramajov.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131755351);
      paramajov.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839325);
      paramajov.jdField_a_of_type_AndroidWidgetButton.setContentDescription(paramajov.jdField_a_of_type_AndroidWidgetButton.getText() + "");
      paramajov.jdField_a_of_type_AndroidWidgetButton.setTag(paramajov);
      paramajov.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    }
    for (;;)
    {
      paramStructMsg = (RelativeLayout.LayoutParams)paramajov.jdField_a_of_type_AndroidWidgetButton.getLayoutParams();
      if (paramStructMsg != null)
      {
        paramStructMsg.addRule(11);
        paramStructMsg.rightMargin = 16;
        paramajov.jdField_a_of_type_AndroidWidgetButton.setLayoutParams(paramStructMsg);
      }
      if (!TextUtils.isEmpty(paramajov.jdField_a_of_type_AndroidWidgetButton.getText())) {
        break;
      }
      paramajov.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      return;
      if (paramInt == 1)
      {
        paramStructMsg = paramStructMsg.msg.actions.get();
        paramajov.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
        if ((paramStructMsg != null) && (paramStructMsg.size() > 0))
        {
          if ((paramString == null) || ("".equals(paramString))) {
            if (paramStructMsg.size() > 1)
            {
              paramajov.jdField_a_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)paramStructMsg.get(1)).name.get());
              paramajov.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131755351);
              paramajov.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839325);
            }
          }
          for (;;)
          {
            paramajov.jdField_a_of_type_AndroidWidgetButton.setContentDescription(paramajov.jdField_a_of_type_AndroidWidgetButton.getText() + "");
            paramajov.jdField_a_of_type_AndroidWidgetButton.setTag(paramajov);
            paramajov.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
            break;
            paramajov.jdField_a_of_type_AndroidWidgetButton.setText("");
            continue;
            paramajov.jdField_a_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)paramStructMsg.get(0)).name.get());
            paramajov.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131755350);
            paramajov.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839324);
          }
        }
        paramajov.jdField_a_of_type_AndroidWidgetButton.setText("");
        paramajov.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(null);
      }
      else
      {
        paramajov.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(null);
        paramajov.jdField_a_of_type_AndroidWidgetButton.setClickable(false);
        paramajov.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131755972);
        paramajov.jdField_a_of_type_AndroidWidgetButton.setText(paramStructMsg.msg.msg_decided.get());
      }
    }
    paramajov.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
  }
  
  private void a(ajov paramajov, structmsg.StructMsg paramStructMsg, String paramString)
  {
    Object localObject;
    if (paramajov.jdField_a_of_type_Int == 11)
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
          localObject = anzj.a(2131714470) + paramString;
        }
      }
      else
      {
        label110:
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label497;
        }
        paramajov.jdField_c_of_type_AndroidWidgetTextView.setSingleLine(true);
        paramajov.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        paramajov.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        label143:
        if (paramajov.jdField_a_of_type_Int != 22) {
          break label509;
        }
        paramStructMsg = paramStructMsg.msg;
        paramajov.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        paramString = new SpannableString(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131718513, new Object[] { paramStructMsg.action_uin_nick.get() }));
        paramString.setSpan(new ForegroundColorSpan(Color.parseColor("#00a5e0")), 6, paramStructMsg.action_uin_nick.get().length() + 6, 33);
        paramajov.jdField_c_of_type_AndroidWidgetTextView.setText(paramString);
        paramajov.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(new ajqc(this, paramStructMsg));
      }
      label497:
      label509:
      while ((paramajov.jdField_a_of_type_Int != 2) || (!paramStructMsg.msg.msg_invite_extinfo.uint32_src_type.has()))
      {
        return;
        if ((!TextUtils.isEmpty(paramString)) && ((paramajov.jdField_a_of_type_Int == 1) || (paramajov.jdField_a_of_type_Int == 22)))
        {
          paramajov.jdField_c_of_type_AndroidWidgetTextView.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131755974);
          break;
        }
        localObject = new ArrayList();
        ((List)localObject).add(paramStructMsg.msg.msg_qna.get());
        if (paramStructMsg.msg.msg_actor_describe.get() != null) {}
        for (paramString = bguq.a(paramStructMsg, paramStructMsg.msg.msg_actor_describe.get());; paramString = "")
        {
          ((List)localObject).add(paramString);
          ((List)localObject).add(paramStructMsg.msg.msg_additional_list.get());
          ((List)localObject).add(paramStructMsg.msg.msg_additional.get());
          if ((paramajov.jdField_a_of_type_Int == 12) || (paramajov.jdField_a_of_type_Int == 83)) {
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
        localObject = anzj.a(2131714471);
        break label110;
        paramajov.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        break label143;
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
        paramajov.jdField_c_of_type_AndroidWidgetTextView.setText(anzj.a(2131714474) + paramStructMsg);
        paramajov.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        return;
        anws localanws = (anws)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53);
        paramString = (String)localObject;
        if (localanws != null)
        {
          paramStructMsg = localanws.a(String.valueOf(paramStructMsg.msg.msg_invite_extinfo.uint64_src_code.get()));
          paramString = (String)localObject;
          if (paramStructMsg != null) {
            paramString = paramStructMsg.discussionName;
          }
        }
        paramajov.jdField_c_of_type_AndroidWidgetTextView.setText(anzj.a(2131714472) + paramString);
        paramajov.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        return;
      }
      paramString = "";
    }
  }
  
  private void a(ajpp paramajpp)
  {
    int m = 1;
    if (paramajpp == null) {
      return;
    }
    Object localObject;
    String str;
    switch (ajpz.a(paramajpp.jdField_a_of_type_Int))
    {
    default: 
      localObject = String.valueOf(paramajpp.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get());
      m = 4;
      str = paramajpp.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_name.get() + this.jdField_a_of_type_AndroidContentContext.getString(2131695854);
    }
    for (;;)
    {
      localObject = ajpz.a(this.jdField_a_of_type_Aoof, (String)localObject, m);
      paramajpp.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(str);
      paramajpp.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      return;
      localObject = paramajpp.jdField_a_of_type_JavaLangString;
      str = paramajpp.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get() + this.jdField_a_of_type_AndroidContentContext.getString(2131695853);
      continue;
      localObject = String.valueOf(paramajpp.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get());
      str = paramajpp.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin_nick.get() + this.jdField_a_of_type_AndroidContentContext.getString(2131695852);
    }
  }
  
  private void a(ajpp paramajpp, structmsg.StructMsg paramStructMsg)
  {
    if ((paramajpp == null) || (paramStructMsg == null)) {
      return;
    }
    if ((paramajpp.jdField_a_of_type_Int == 2) && (paramStructMsg.msg.msg_invite_extinfo.uint32_src_type.has()))
    {
      String str1 = paramStructMsg.msg.action_uin_qq_nick.get().toStringUtf8();
      switch (paramStructMsg.msg.msg_invite_extinfo.uint32_src_type.get())
      {
      default: 
        paramStructMsg = str1;
      }
      for (;;)
      {
        paramajpp.jdField_a_of_type_AndroidWidgetTextView.setText(paramStructMsg);
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
        str1 = bhlg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str3, str2, paramStructMsg, true, null);
        paramStructMsg = str1;
        if (TextUtils.isEmpty(str1))
        {
          paramStructMsg = ((TroopManager)localObject).a(str2, str3);
          continue;
          localObject = (anws)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53);
          if (localObject == null) {
            break;
          }
          paramStructMsg = ((anws)localObject).a(String.valueOf(paramStructMsg.msg.msg_invite_extinfo.uint64_src_code.get()), String.valueOf(paramStructMsg.msg.action_uin.get()));
          if (paramStructMsg == null) {
            break;
          }
          paramStructMsg = paramStructMsg.getDiscussionMemberName();
        }
      }
    }
    switch (ajpz.a(paramajpp.jdField_a_of_type_Int))
    {
    default: 
      paramajpp.jdField_a_of_type_AndroidWidgetTextView.setText(paramajpp.jdField_b_of_type_JavaLangString);
      return;
    case 0: 
      paramajpp.jdField_a_of_type_AndroidWidgetTextView.setText(paramStructMsg.msg.group_name.get());
      return;
    case 1: 
      paramajpp.jdField_a_of_type_AndroidWidgetTextView.setText(paramStructMsg.msg.action_uin_nick.get());
      return;
    }
    paramajpp.jdField_a_of_type_AndroidWidgetTextView.setText(paramajpp.jdField_b_of_type_JavaLangString);
  }
  
  private void a(RecyclerView paramRecyclerView, String paramString, Bitmap paramBitmap)
  {
    Object localObject;
    ajpp localajpp;
    if (this.jdField_b_of_type_Int == 0)
    {
      int n = paramRecyclerView.getChildCount();
      int m = 0;
      while (m < n)
      {
        localObject = paramRecyclerView.findViewHolderForAdapterPosition(m);
        if ((localObject == null) || (!(localObject instanceof ajpp)))
        {
          m += 1;
        }
        else
        {
          localajpp = (ajpp)localObject;
          switch (ajpz.a(localajpp.jdField_a_of_type_Int))
          {
          default: 
            localObject = String.valueOf(localajpp.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get());
          }
        }
      }
    }
    while ((localajpp.jdField_a_of_type_AndroidWidgetImageView != null) && (paramString.equals(localObject)))
    {
      localajpp.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
      return;
      localObject = localajpp.jdField_a_of_type_JavaLangString;
      continue;
      localObject = String.valueOf(localajpp.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get());
    }
  }
  
  private void a(structmsg.StructMsg paramStructMsg, long paramLong)
  {
    if (paramStructMsg != null)
    {
      long l1 = ((structmsg.StructMsg)paramStructMsg.get()).msg_seq.get() + ((structmsg.StructMsg)paramStructMsg.get()).msg_type.get();
      bdzi.a().a(Long.valueOf(l1), (structmsg.StructMsg)paramStructMsg.get());
      bdzi.a().b(l1);
      bdzi.a().a(paramLong);
    }
  }
  
  private boolean a(int paramInt, structmsg.StructMsg paramStructMsg)
  {
    boolean bool = false;
    int i1;
    int i2;
    if (paramStructMsg != null)
    {
      int m = paramStructMsg.msg_type.get();
      long l1 = paramStructMsg.msg_seq.get();
      long l2 = paramStructMsg.req_uin.get();
      int n = paramStructMsg.msg.sub_type.get();
      i1 = paramStructMsg.msg.src_id.get();
      i2 = paramStructMsg.msg.sub_src_id.get();
      int i3 = paramStructMsg.msg.group_msg_type.get();
      List localList = paramStructMsg.msg.actions.get();
      if ((localList == null) || (paramInt >= localList.size())) {
        break label216;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(m, l1, l2, n, i1, i2, i3, (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)localList.get(paramInt)).action_info.get(), paramInt);
    }
    label216:
    for (bool = true;; bool = false)
    {
      if ((i1 == 116) && (i2 == 0)) {
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_discuss", "", "verify_msg", "Clk_agree", 0, 0, String.valueOf(paramStructMsg.msg.group_code.get()), "", "", "");
      }
      return bool;
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
  
  private void b(ajov paramajov)
  {
    int m = 1;
    if (paramajov == null) {
      return;
    }
    Object localObject;
    String str;
    switch (ajpz.a(paramajov.jdField_a_of_type_Int))
    {
    default: 
      localObject = String.valueOf(paramajov.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get());
      m = 4;
      str = paramajov.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_name.get() + this.jdField_a_of_type_AndroidContentContext.getString(2131695854);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = bhmq.b();
      }
      localObject = aoot.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), m, (String)localObject, 3, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      paramajov.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(str);
      paramajov.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      return;
      localObject = paramajov.jdField_a_of_type_JavaLangString;
      str = paramajov.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get() + this.jdField_a_of_type_AndroidContentContext.getString(2131695853);
      continue;
      localObject = String.valueOf(paramajov.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get());
      str = paramajov.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin_nick.get() + this.jdField_a_of_type_AndroidContentContext.getString(2131695852);
    }
  }
  
  private void b(ajov paramajov, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotifyAndRecommendView", 2, "jumpToTroopRequestActivity!" + paramajov.jdField_a_of_type_Long + ": dealMsgType = " + paramInt);
    }
    Intent localIntent = new Intent(a(), TroopRequestActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putLong("troopMsgId", paramajov.jdField_a_of_type_Long);
    localBundle.putInt("mTroopMsgType", paramajov.jdField_a_of_type_Int);
    localBundle.putString("mTroopCode", String.valueOf(paramajov.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get()));
    localBundle.putString("troopmanagerUin", String.valueOf(paramajov.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get()));
    localBundle.putString("troopsMsg", paramajov.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get());
    if ((this.jdField_a_of_type_Ajpe != null) && (paramajov.jdField_b_of_type_Int < this.jdField_a_of_type_Ajpe.jdField_a_of_type_Int)) {}
    for (boolean bool = true;; bool = false)
    {
      localBundle.putBoolean("is_unread", bool);
      localBundle.putString("troopRequestUin", String.valueOf(paramajov.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()));
      localBundle.putString("troopsummary", paramajov.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get());
      localBundle.putLong("infotime", paramajov.jdField_b_of_type_Long);
      localBundle.putInt("troopfromtab", this.jdField_c_of_type_Int);
      if ((a() instanceof TroopActivity)) {
        localBundle.putBoolean("troop_invitee_is_friend", a((ArrayList)((TroopActivity)a()).a, String.valueOf(paramajov.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get())));
      }
      if (paramajov.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() != 83) {
        localIntent.putExtra("troopMsgDealInfo", paramajov.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_detail.get());
      }
      a((structmsg.StructMsg)paramajov.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get(), paramajov.jdField_c_of_type_Long);
      localBundle.putInt("t_s_f", 1001);
      localIntent.putExtras(localBundle);
      a(localIntent);
      return;
    }
  }
  
  private void b(ajov paramajov, structmsg.StructMsg paramStructMsg)
  {
    if ((paramajov == null) || (paramStructMsg == null)) {
      return;
    }
    if ((paramajov.jdField_a_of_type_Int == 2) && (paramStructMsg.msg.msg_invite_extinfo.uint32_src_type.has()))
    {
      String str1 = paramStructMsg.msg.action_uin_qq_nick.get().toStringUtf8();
      switch (paramStructMsg.msg.msg_invite_extinfo.uint32_src_type.get())
      {
      default: 
        paramStructMsg = str1;
      }
      for (;;)
      {
        paramajov.jdField_a_of_type_AndroidWidgetTextView.setText(paramStructMsg);
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
        str1 = bhlg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str3, str2, paramStructMsg, true, null);
        paramStructMsg = str1;
        if (TextUtils.isEmpty(str1))
        {
          paramStructMsg = ((TroopManager)localObject).a(str2, str3);
          continue;
          localObject = (anws)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53);
          if (localObject == null) {
            break;
          }
          paramStructMsg = ((anws)localObject).a(String.valueOf(paramStructMsg.msg.msg_invite_extinfo.uint64_src_code.get()), String.valueOf(paramStructMsg.msg.action_uin.get()));
          if (paramStructMsg == null) {
            break;
          }
          paramStructMsg = paramStructMsg.getDiscussionMemberName();
        }
      }
    }
    switch (ajpz.a(paramajov.jdField_a_of_type_Int))
    {
    default: 
      paramajov.jdField_a_of_type_AndroidWidgetTextView.setText(paramajov.jdField_b_of_type_JavaLangString);
      return;
    case 0: 
      paramajov.jdField_a_of_type_AndroidWidgetTextView.setText(paramStructMsg.msg.group_name.get());
      return;
    case 1: 
      paramajov.jdField_a_of_type_AndroidWidgetTextView.setText(paramStructMsg.msg.action_uin_nick.get());
      return;
    }
    paramajov.jdField_a_of_type_AndroidWidgetTextView.setText(paramajov.jdField_b_of_type_JavaLangString);
  }
  
  private void b(ajpp paramajpp)
  {
    if (paramajpp == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotifyAndRecommendView", 2, "jumpToTroopRequestActivity!" + paramajpp.jdField_a_of_type_Long);
    }
    ajrj.a(paramajpp.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, "unnormal_edit");
    Intent localIntent = new Intent(a(), TroopRequestActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putLong("troopMsgId", paramajpp.jdField_a_of_type_Long);
    localBundle.putInt("mTroopMsgType", paramajpp.jdField_a_of_type_Int);
    localBundle.putString("mTroopCode", String.valueOf(paramajpp.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get()));
    localBundle.putString("troopmanagerUin", String.valueOf(paramajpp.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get()));
    localBundle.putString("troopsMsg", paramajpp.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get());
    int m = bdzi.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (paramajpp.jdField_b_of_type_Int < m) {}
    for (boolean bool = true;; bool = false)
    {
      localBundle.putBoolean("is_unread", bool);
      localBundle.putString("troopRequestUin", String.valueOf(paramajpp.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()));
      localBundle.putString("troopsummary", paramajpp.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get());
      localBundle.putLong("infotime", paramajpp.jdField_b_of_type_Long);
      if ((a() instanceof TroopActivity)) {
        localBundle.putBoolean("troop_invitee_is_friend", a((ArrayList)((TroopActivity)a()).a, String.valueOf(paramajpp.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get())));
      }
      if (paramajpp.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() != 83) {
        localIntent.putExtra("troopMsgDealInfo", paramajpp.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_detail.get());
      }
      ajrj.a((structmsg.StructMsg)paramajpp.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get());
      a((structmsg.StructMsg)paramajpp.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get(), paramajpp.jdField_c_of_type_Long);
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
    int i1;
    int i2;
    if (paramStructMsg != null)
    {
      int m = paramStructMsg.msg_type.get();
      long l1 = paramStructMsg.msg_seq.get();
      long l2 = paramStructMsg.req_uin.get();
      int n = paramStructMsg.msg.sub_type.get();
      i1 = paramStructMsg.msg.src_id.get();
      i2 = paramStructMsg.msg.sub_src_id.get();
      int i3 = paramStructMsg.msg.group_msg_type.get();
      Object localObject = paramStructMsg.msg.actions.get();
      if ((localObject == null) || (paramInt >= ((List)localObject).size())) {
        break label226;
      }
      localObject = (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)((List)localObject).get(paramInt)).action_info.get();
      ((structmsg.SystemMsgActionInfo)localObject).uint32_req_msg_type.set(2);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(m, l1, l2, n, i1, i2, i3, (structmsg.SystemMsgActionInfo)localObject, paramInt);
    }
    label226:
    for (bool = true;; bool = false)
    {
      if ((i1 == 116) && (i2 == 0)) {
        bdll.b(null, "P_CliOper", "Grp_discuss", "", "verify_msg", "Clk_agree", 0, 0, String.valueOf(paramStructMsg.msg.group_code.get()), "", "", "");
      }
      return bool;
    }
  }
  
  private void r()
  {
    int m = bdzi.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (this.jdField_a_of_type_Ajpe != null) {
      if (!ajqx.b()) {
        break label49;
      }
    }
    label49:
    for (this.jdField_a_of_type_Ajpe.jdField_a_of_type_Int = 0;; this.jdField_a_of_type_Ajpe.jdField_a_of_type_Int = m)
    {
      ThreadManager.postImmediately(new TroopNotifyAndRecommendView.6(this), this.jdField_a_of_type_ComTencentMobileqqAppThreadExcutor$IThreadListener, false);
      return;
    }
  }
  
  private void s()
  {
    Object localObject3 = "";
    String str = "";
    List localList = ajqw.d();
    Object localObject2 = str;
    Object localObject1 = localObject3;
    Intent localIntent;
    int m;
    if ((getContext() instanceof Activity))
    {
      localIntent = ((Activity)getContext()).getIntent();
      localObject2 = str;
      localObject1 = localObject3;
      if (localIntent != null)
      {
        m = localIntent.getIntExtra("key_from", 0);
        if (m == 1)
        {
          localObject1 = "3";
          localObject2 = "1";
        }
      }
    }
    for (;;)
    {
      bhju.a("Grp_contacts_news", "notice", "enter_verify", 0, 0, new String[] { localObject2, localObject1 });
      return;
      localObject2 = str;
      localObject1 = localObject3;
      if (m == 2)
      {
        localObject3 = "3";
        if (localIntent.getBooleanExtra("has_red", false))
        {
          str = "2";
          localObject2 = localObject3;
          localObject1 = str;
          if (localList == null) {
            break label304;
          }
          localObject2 = localObject3;
          localObject1 = str;
          if (localList.size() <= 0) {
            break label304;
          }
          localObject1 = (MessageRecord)localList.get(0);
          if (!(localObject1 instanceof MessageForSystemMsg)) {
            break label296;
          }
          long l1 = ((MessageForSystemMsg)localObject1).getSystemMsg().msg.group_code.get();
          localObject1 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(l1 + "");
          if (localObject1 == null) {
            break label296;
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
          label296:
          localObject1 = "3";
        }
      }
      label304:
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
    }
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
            paramQQAppInterface.a().e("following_group_seq", l1);
          }
        }
      }
    }
  }
  
  private void t()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotifyAndRecommendView", 2, "sendReadConfirm lll");
    }
    ThreadManager.post(new TroopNotifyAndRecommendView.10(this), 8, null, false);
    if (QLog.isColorLevel()) {
      QLog.i("TroopNotifyAndRecommendView", 2, "sendReadConfirm is end!");
    }
  }
  
  private void u()
  {
    if (this.jdField_e_of_type_AndroidViewView == null) {
      this.jdField_e_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561602, null);
    }
    if (this.jdField_e_of_type_AndroidViewView.getParent() == null) {
      this.jdField_a_of_type_ComTencentWidgetSwipListView.addFooterView(this.jdField_e_of_type_AndroidViewView);
    }
    this.jdField_e_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void v()
  {
    if ((this.jdField_i_of_type_Boolean) || (this.jdField_c_of_type_Int == 2) || (this.jdField_c_of_type_Int == 1)) {}
    do
    {
      do
      {
        do
        {
          return;
          if (!bhnv.d(BaseApplication.getContext()))
          {
            QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131691989), 0).b(a());
            return;
          }
          if ((this.jdField_a_of_type_Ajpe == null) || ((this.jdField_a_of_type_Ajpe.b()) && (!this.jdField_a_of_type_Ajpe.a()))) {
            break;
          }
        } while ((this.jdField_a_of_type_Axfw != null) && (this.jdField_a_of_type_Axfw.a()));
        this.jdField_i_of_type_Boolean = true;
        this.jdField_e_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().h();
      } while (!QLog.isColorLevel());
      QLog.i("TroopNotifyAndRecommendView", 2, "loadNextPage.get next page of Notofication");
      return;
      if ((this.jdField_a_of_type_Aoga.jdField_a_of_type_Int != 1) && (this.k))
      {
        this.jdField_i_of_type_Boolean = true;
        this.jdField_e_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_Aoga.a();
        if (QLog.isColorLevel()) {
          QLog.i("TroopNotifyAndRecommendView", 2, "loadNextPage.get next page of recommend");
        }
        bhju.a("Grp_contacts_news", "notice", "recom_,more", 2, 0, new String[0]);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.i("TroopNotifyAndRecommendView", 2, "ray test touch the end of list.");
  }
  
  private void w()
  {
    if (this.jdField_e_of_type_AndroidViewView != null) {
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    }
    this.jdField_i_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.i("TroopNotifyAndRecommendView", 2, "stopLoadMore().");
    }
  }
  
  private void x()
  {
    if (this.jdField_f_of_type_AndroidViewView == null) {
      return;
    }
    List localList = ajqw.a();
    if ((ajqw.b().isEmpty()) && (this.jdField_b_of_type_JavaUtilList.isEmpty()) && (localList.isEmpty()))
    {
      this.jdField_f_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    this.jdField_f_of_type_AndroidViewView.setVisibility(0);
  }
  
  private void y()
  {
    this.jdField_a_of_type_Ajoe = new ajqk(this, a(), 2131559908);
    this.jdField_a_of_type_Ajoe.a(2131559909);
    this.jdField_a_of_type_Ajoe.a(2131561602);
    this.jdField_a_of_type_Ajoe.a(new ajql(this));
  }
  
  private void z()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView = ((OverScrollRecyclerView)findViewById(2131378259));
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.setLayoutManager(new LinearLayoutManager(a(), 1, false));
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.addOnScrollListener(new ajqo(this));
    this.jdField_a_of_type_Aoof = new aoof(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Aoof.a(this);
  }
  
  public int a()
  {
    return getResources().getDimensionPixelSize(2131299011);
  }
  
  public void a(ajov paramajov)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotifyAndRecommendView", 2, "handleGroupSystemMsg! start " + paramajov.jdField_a_of_type_Long);
    }
    b(paramajov, 998);
    Object localObject = paramajov.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_info.msg_alert.get();
    String str4 = paramajov.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get() + "";
    String str2;
    int m;
    label146:
    String str1;
    if ((this.jdField_a_of_type_Ajpe != null) && (paramajov.jdField_b_of_type_Int < this.jdField_a_of_type_Ajpe.jdField_a_of_type_Int))
    {
      str2 = "1";
      m = paramajov.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_inviter_role.get();
      if ((m != 2) && (m != 3)) {
        break label306;
      }
      m = 0;
      switch (paramajov.jdField_a_of_type_Int)
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
        paramajov = "";
        localObject = "";
        str1 = "";
      }
    }
    for (;;)
    {
      bhju.a("Grp_contacts_news", "notice", str1, 3, 0, new String[] { str4, str2, localObject, paramajov });
      return;
      str2 = "0";
      break;
      label306:
      m = 1;
      break label146;
      str1 = "enter_askjoin";
      if ((localObject == null) || ("".equals(localObject))) {}
      for (localObject = "1";; localObject = "0")
      {
        if (paramajov.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get() != 1) {
          break label368;
        }
        paramajov = "0";
        break;
      }
      label368:
      long l1 = paramajov.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actor_uin.get();
      if ((l1 != 0L) && (!(l1 + "").equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {}
      for (paramajov = "2";; paramajov = "1") {
        break;
      }
      paramajov = "";
      localObject = "";
      str1 = "refuseask_page";
      continue;
      if (paramajov.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get() == 1) {}
      for (paramajov = "0";; paramajov = "1")
      {
        localObject = "";
        str1 = "enter_invite";
        break;
      }
      if (m != 0) {}
      String str3;
      for (paramajov = "0";; paramajov = "1")
      {
        str1 = "refuseinvite_page";
        str3 = "";
        localObject = paramajov;
        paramajov = str3;
        break;
      }
      if (m != 0) {}
      for (paramajov = "0";; paramajov = "1")
      {
        str1 = "refuseagree_page";
        str3 = "";
        localObject = paramajov;
        paramajov = str3;
        break;
      }
      paramajov = "";
      localObject = "";
      str1 = "quit_page";
      continue;
      str1 = "byquit_page";
      paramajov = "";
      localObject = "0";
      continue;
      str1 = "byquit_page";
      paramajov = "";
      localObject = "1";
      continue;
      if ((paramajov.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get() + "").equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {}
      for (paramajov = "0";; paramajov = "1")
      {
        str1 = "set_admin_page";
        str3 = "";
        localObject = paramajov;
        paramajov = str3;
        break;
      }
      str1 = "un_admin_page";
      paramajov = "";
      localObject = "0";
      continue;
      str1 = "un_admin_page";
      paramajov = "";
      localObject = "1";
    }
  }
  
  public void a(ajov paramajov, int paramInt)
  {
    int n = -1;
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotifyAndRecommendView", 2, "bindTroopSystemMsgView! start " + paramajov.jdField_a_of_type_Long);
    }
    structmsg.StructMsg localStructMsg = paramajov.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
    paramajov.jdField_a_of_type_Long = paramInt;
    paramajov.jdField_a_of_type_JavaLangString = (localStructMsg.req_uin.get() + "");
    paramajov.jdField_a_of_type_Int = localStructMsg.msg.group_msg_type.get();
    paramInt = localStructMsg.msg.sub_type.get();
    paramajov.jdField_b_of_type_Long = localStructMsg.msg_time.get();
    paramajov.jdField_b_of_type_JavaLangString = localStructMsg.msg.req_uin_nick.get();
    String str;
    if ((paramajov.jdField_b_of_type_JavaLangString != null) && (!paramajov.jdField_b_of_type_JavaLangString.equals("")))
    {
      b(paramajov, localStructMsg);
      paramajov.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      str = localStructMsg.msg.group_info.msg_alert.get();
      a(paramajov, localStructMsg, str);
      a(paramajov, localStructMsg);
      a(paramajov, localStructMsg, paramInt, str);
      if ((paramInt == 2) && (paramajov.jdField_a_of_type_Int == 2) && (((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(String.valueOf(localStructMsg.msg.group_code.get())) != null)) {
        axap.a().b(String.valueOf(localStructMsg.msg.group_code.get()), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      if (localStructMsg.msg.bytes_warning_tips.get() == null) {
        break label592;
      }
      str = localStructMsg.msg.bytes_warning_tips.get().toStringUtf8();
      label310:
      if (TextUtils.isEmpty(str)) {
        break label599;
      }
      paramajov.jdField_d_of_type_AndroidWidgetTextView.setText(str);
      paramajov.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      label335:
      if (QLog.isColorLevel()) {
        QLog.d("Q.security_verify", 2, String.format("bindTroopSystemMsgView reqUin: %s, warningTips: %s", new Object[] { paramajov.jdField_a_of_type_JavaLangString, str }));
      }
      paramajov.jdField_a_of_type_AndroidWidgetLinearLayout.setTag(paramajov);
      paramajov.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramajov.jdField_a_of_type_AndroidWidgetImageView.setTag(paramajov);
      if ((paramajov.jdField_a_of_type_Int != 8) && (paramajov.jdField_a_of_type_Int != 7)) {
        break label611;
      }
      paramajov.jdField_a_of_type_AndroidWidgetImageView.setEnabled(false);
      label423:
      b(paramajov);
      if (((paramajov.jdField_a_of_type_Int == 1) || (paramajov.jdField_a_of_type_Int == 22) || (paramajov.jdField_a_of_type_Int == 60)) && (QLog.isColorLevel())) {
        if ((!localStructMsg.msg.has()) || (!localStructMsg.msg.src_id.has())) {
          break label622;
        }
      }
    }
    label592:
    label599:
    label611:
    label622:
    for (paramInt = localStructMsg.msg.src_id.get();; paramInt = -1)
    {
      int m = n;
      if (localStructMsg.msg.has())
      {
        m = n;
        if (localStructMsg.msg.sub_src_id.has()) {
          m = localStructMsg.msg.sub_src_id.get();
        }
      }
      QLog.i("TroopNotifyAndRecommendView", 2, String.format("joinGroup subSourceID=%d sourceID=%d msgType=%d", new Object[] { Integer.valueOf(m), Integer.valueOf(paramInt), Integer.valueOf(paramajov.jdField_a_of_type_Int) }));
      return;
      paramajov.jdField_b_of_type_JavaLangString = paramajov.jdField_a_of_type_JavaLangString;
      break;
      str = "";
      break label310;
      paramajov.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      break label335;
      paramajov.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      break label423;
    }
  }
  
  protected void a(Intent paramIntent, ajop paramajop)
  {
    super.a(paramIntent, paramajop);
    this.jdField_a_of_type_Aoga = ((aoga)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(22));
    this.jdField_a_of_type_Axfw = ((axfw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37));
    i();
    b(paramIntent, paramajop);
    c(paramIntent, paramajop);
    this.jdField_a_of_type_AndroidWidgetTextView = paramajop.a();
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_contacts_news", "", "notice", "notice_exp", 0, 0, "", "", "", "");
  }
  
  public void a(List<RecommendTroopItem> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotifyAndRecommendView", 2, "handleRecommendDataResult: " + Log.getStackTraceString(new RuntimeException("debug trace")));
    }
    this.jdField_a_of_type_Ajop.a(new TroopNotifyAndRecommendView.19(this, paramList));
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_g_of_type_AndroidViewView == null) || (this.jdField_b_of_type_AndroidWidgetTextView == null) || (this.jdField_a_of_type_AndroidWidgetImageView == null)) {
      return;
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(this.jdField_b_of_type_AndroidWidgetTextView.getText());
    if ((paramBoolean) && (this.jdField_c_of_type_Int == 1))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16725252);
      localSpannableStringBuilder.setSpan(new StyleSpan(1), 0, this.jdField_b_of_type_AndroidWidgetTextView.getText().length(), 18);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      b(false);
      c(false);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(localSpannableStringBuilder);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-7894119);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    b(ajqw.b());
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
        Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837961);
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
    }
  }
  
  protected int b()
  {
    int i1 = aoga.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (i1 > 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(antf.W, 9000, 0 - i1);
      this.jdField_a_of_type_Aoga.b();
      o();
    }
    int n = 0;
    int m = n;
    if (this.jdField_a_of_type_Aoga != null)
    {
      m = n;
      if (!this.jdField_b_of_type_Boolean)
      {
        m = n;
        if (i1 > 0) {
          m = 1;
        }
      }
    }
    return m;
  }
  
  protected void b(Intent paramIntent, ajop paramajop)
  {
    a(this.jdField_a_of_type_Aocj);
    u();
    r();
    this.jdField_a_of_type_Bjbs = new bjbs(this.jdField_a_of_type_AndroidContentContext, a());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
    if (ajpz.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) > 0) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(3);
    }
    ajpz.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (this.jdField_a_of_type_Ajpe != null) {
      this.jdField_a_of_type_Ajpe.notifyDataSetChanged();
    }
    int m = bdzi.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotifyAndRecommendView", 2, "notification num:" + m);
    }
    this.jdField_a_of_type_Aoga.jdField_c_of_type_Int = m;
    int n = aoga.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(antf.W, 9000, 0 - (m + n));
    bdzi.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
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
    int m = paramList.size();
    paramList = String.valueOf(m);
    if (m > 99) {
      paramList = "99+";
    }
    paramList = "待处理(" + paramList + ")";
    if (this.jdField_g_of_type_AndroidViewView.getVisibility() == 8) {
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_contacts_news", "", "notice", "todo_tab_exp", 0, 0, "", "", "", "");
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
  
  protected void c(Intent paramIntent, ajop paramajop)
  {
    super.a(paramIntent, paramajop);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this);
    a(this.jdField_a_of_type_Aojs);
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
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_contacts_news", "", "notice", "quit_tab_exp", 0, 0, "", "", "", "");
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
      ajpz.b();
      bdzi.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
      if (this.jdField_a_of_type_Ajpe != null)
      {
        this.jdField_a_of_type_Ajpe.jdField_a_of_type_Int = 0;
        this.jdField_a_of_type_Ajpe.notifyDataSetChanged();
      }
      this.jdField_a_of_type_Aoga.jdField_c_of_type_Int = bdzi.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    if (this.jdField_c_of_type_Int == 3) {
      bdzi.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
    }
    this.j = true;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int m = (int)paramMotionEvent.getX();
    int n = (int)paramMotionEvent.getY();
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      this.jdField_i_of_type_Int = n;
      this.jdField_h_of_type_Int = m;
      return super.dispatchTouchEvent(paramMotionEvent);
      getParent().requestDisallowInterceptTouchEvent(true);
      continue;
      int i1 = m - this.jdField_h_of_type_Int;
      int i2 = n - this.jdField_i_of_type_Int;
      if ((i1 > 20) || (i1 < -20)) {
        this.l = true;
      }
      if (((i2 > 20) || (i2 < -20)) && (!this.l))
      {
        getParent().requestDisallowInterceptTouchEvent(false);
        continue;
        this.l = false;
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
    if (this.jdField_a_of_type_Aoga != null) {
      this.jdField_a_of_type_Aoga.b();
    }
    if (this.jdField_c_of_type_Int == 3)
    {
      this.jdField_a_of_type_Aoof.c();
      this.jdField_a_of_type_Aoof.a();
    }
  }
  
  protected void g()
  {
    super.g();
    if (this.jdField_a_of_type_Ajpe != null) {
      this.jdField_a_of_type_Ajpe.b();
    }
    if ((this.jdField_a_of_type_Ajpe != null) && (this.jdField_a_of_type_Ajpe.a() > 0)) {
      t();
    }
    b(this.jdField_a_of_type_Aojs);
    MqqHandler localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(TroopNotifyAndRecommendView.class);
    if (localMqqHandler != null) {
      localMqqHandler.removeCallbacksAndMessages(null);
    }
    b(this.jdField_a_of_type_Aocj);
    if (this.jdField_a_of_type_Ajpe != null)
    {
      this.jdField_a_of_type_Ajpe.a();
      this.jdField_a_of_type_Ajpe.notifyDataSetChanged();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this);
    ajpz.b();
    bdzi.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
    if (this.jdField_c_of_type_Boolean) {
      bdzi.a().b();
    }
    bhaq.a(a()).a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeHandler(getClass());
    if (this.jdField_a_of_type_Apcq != null) {
      SosoInterface.b(this.jdField_a_of_type_Apcq);
    }
    this.jdField_a_of_type_Aoga.b();
    this.jdField_a_of_type_Aoga.d();
    this.jdField_a_of_type_Aoga.a();
    if (this.jdField_a_of_type_Aoof != null) {
      this.jdField_a_of_type_Aoof.a(null);
    }
    if (this.jdField_a_of_type_Ajoe != null)
    {
      this.jdField_a_of_type_Ajoe.a();
      this.jdField_a_of_type_Ajoe.notifyDataSetChanged();
    }
  }
  
  public void i()
  {
    a(2131559897);
    this.jdField_a_of_type_Ajpe = new ajpe(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getContext(), this.jdField_a_of_type_Ajop, this);
    this.jdField_a_of_type_ComTencentWidgetSwipListView = ((SwipListView)findViewById(2131379456));
    this.jdField_f_of_type_AndroidViewView = findViewById(2131364531);
    this.jdField_g_of_type_AndroidViewView = findViewById(2131378319);
    this.jdField_h_of_type_AndroidViewView = findViewById(2131378314);
    this.jdField_i_of_type_AndroidViewView = findViewById(2131378323);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378322));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131378320));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378321));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378317));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131378315));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378316));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378324));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131378325));
    p();
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDragEnable(true);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setAdapter(this.jdField_a_of_type_Ajpe);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setOnScrollListener(this);
    this.jdField_i_of_type_AndroidViewView.setOnClickListener(new ajqb(this));
    this.jdField_h_of_type_AndroidViewView.setOnClickListener(new ajqj(this));
    this.jdField_g_of_type_AndroidViewView.setOnClickListener(new ajqr(this));
  }
  
  public void j()
  {
    bhlq.a(this.jdField_a_of_type_AndroidContentContext, null, this.jdField_a_of_type_AndroidContentContext.getString(2131718993), null, 2131690580, 2131694302, new ajqf(this), new ajqg(this)).show();
  }
  
  public void k()
  {
    t();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.w();
    bdzi.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
    ajqw.a();
    if (this.jdField_a_of_type_Ajpe != null)
    {
      this.jdField_a_of_type_Ajpe.a();
      this.jdField_a_of_type_Ajpe.notifyDataSetChanged();
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
      this.jdField_a_of_type_Aoga.a();
    }
    if ((!this.k) && (this.jdField_a_of_type_Ajpe != null))
    {
      this.jdField_a_of_type_Ajpe.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_Ajpe.notifyDataSetChanged();
    }
    b();
    m();
  }
  
  protected void m()
  {
    if ((this.jdField_f_of_type_Boolean) && (this.jdField_a_of_type_Ajpe != null) && (this.jdField_a_of_type_Ajpe.b()))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("TroopNotifyAndRecommendView", 4, "reportPv");
      }
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_recom", "", "msg_page", "exp", 0, 0, "", "", "", "");
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
    if ((this.jdField_a_of_type_Aoga != null) && (!this.jdField_b_of_type_Boolean) && (aoga.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) > 0))
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
    int m;
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
      case 2131371687: 
        bfpa.a(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        break;
      case 2131373670: 
        if ((paramView.getTag() instanceof ajov))
        {
          localObject2 = (ajov)paramView.getTag();
          if (localObject2 != null)
          {
            localObject3 = ((ajov)localObject2).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
            m = ((ajov)localObject2).jdField_a_of_type_Int;
            if (ajpz.a(m) == 0)
            {
              localObject1 = TroopInfoActivity.a(String.valueOf(((ajov)localObject2).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get()), 4);
              ((Bundle)localObject1).putInt("t_s_f", 1001);
              bguq.a(a(), (Bundle)localObject1, 2);
              if ((m == 2) || (m == 10) || (m == 12))
              {
                m = 1;
                label192:
                localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
                String str = ((ajov)localObject2).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get() + "";
                if (m == 0) {
                  break label343;
                }
                localObject1 = "0";
                label241:
                bdll.b((QQAppInterface)localObject3, "P_CliOper", "Grp_contacts", "", "notice", "see_data", 0, 0, str, (String)localObject1, "", "");
                localObject2 = ((ajov)localObject2).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code + "";
                if (m == 0) {
                  break label351;
                }
              }
              label343:
              label351:
              for (localObject1 = "0";; localObject1 = "1")
              {
                bhju.a("Grp_contacts_news", "notice", "see_data", 0, 0, new String[] { localObject2, localObject1 });
                break;
                m = 0;
                break label192;
                localObject1 = "1";
                break label241;
              }
            }
            if ((((ajov)localObject2).jdField_a_of_type_Int != 2) || (!TroopInfo.isQidianPrivateTroop(((ajov)localObject2).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.uint32_group_flagext3.get())))
            {
              if (((ajov)localObject2).jdField_a_of_type_Int != 82) {
                break label476;
              }
              localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, AccountDetailActivity.class);
              ((Intent)localObject1).putExtra("uin", ((ajov)localObject2).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get() + "");
              ((Intent)localObject1).putExtra("source", 112);
              a((Intent)localObject1);
            }
          }
        }
        break;
      }
    }
    label476:
    l1 = ((structmsg.StructMsg)localObject3).req_uin.get();
    switch (ajpz.a(m))
    {
    default: 
      localObject1 = String.valueOf(l1);
      label518:
      if (((anyw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b((String)localObject1)) {
        localObject1 = new ProfileActivity.AllInOne((String)localObject1, 1);
      }
      break;
    }
    for (;;)
    {
      l1 = ((structmsg.StructMsg)localObject3).msg.uint32_group_flagext3.get();
      boolean bool = TroopInfo.isQidianPrivateTroop(l1);
      m = ((structmsg.StructMsg)localObject3).msg.group_msg_type.get();
      if (QLog.isColorLevel()) {
        QLog.d(".troop.qidian_private_troop", 2, "notification headView onClick: msgType=" + m + ", isQidianPrivateTroop=" + bool + ", flagExt3=" + l1);
      }
      if ((bool) && (m == 2)) {
        break;
      }
      ProfileActivity.b(a(), (ProfileActivity.AllInOne)localObject1);
      bhju.a("Grp_contacts_news", "notice", "see_fromdata", 0, 0, new String[] { ((ajov)localObject2).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code + "", "3" });
      break;
      localObject1 = ((ajov)localObject2).jdField_a_of_type_JavaLangString;
      break label518;
      localObject1 = String.valueOf(((ajov)localObject2).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get());
      break label518;
      if ((((structmsg.StructMsg)localObject3).msg.group_msg_type.get() == 2) && (((structmsg.StructMsg)localObject3).msg.sub_type.get() == 3))
      {
        localObject1 = new ProfileActivity.AllInOne((String)localObject1, 26);
        ((ProfileActivity.AllInOne)localObject1).jdField_d_of_type_Int = 1;
      }
      else
      {
        localObject1 = new ProfileActivity.AllInOne((String)localObject1, 24);
        bguq.a((structmsg.StructMsg)localObject3, (ProfileActivity.AllInOne)localObject1);
      }
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    a(this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView, paramString, paramBitmap);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_d_of_type_Int = (paramInt1 + paramInt2 - 1);
    if (this.jdField_a_of_type_Ajpe != null) {
      this.jdField_a_of_type_Ajpe.a(this.jdField_d_of_type_Int, this.jdField_c_of_type_Int);
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
      if (this.jdField_a_of_type_Ajpe == null) {
        break label99;
      }
    }
    label99:
    for (int m = this.jdField_a_of_type_Ajpe.getCount();; m = 0)
    {
      QLog.d("TroopNotifyAndRecommendView", 2, m);
      if ((this.jdField_a_of_type_Ajpe != null) && (paramInt == 0) && (this.jdField_d_of_type_Int == this.jdField_a_of_type_Ajpe.getCount() - 1)) {
        v();
      }
      this.jdField_e_of_type_Int = paramInt;
      return;
    }
  }
  
  public void p()
  {
    z();
    y();
    A();
  }
  
  public void q()
  {
    D();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.x();
    bdzi.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
    this.jdField_b_of_type_JavaUtilList.clear();
    if (this.jdField_a_of_type_Ajoe != null) {
      this.jdField_a_of_type_Ajoe.a();
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