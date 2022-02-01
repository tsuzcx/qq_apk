package com.tencent.mobileqq.activity.contact.troop;

import acvy;
import aixy;
import ajcv;
import ajdf;
import ajdg;
import ajdm;
import ajdv;
import ajeg;
import ajeq;
import ajer;
import ajes;
import ajet;
import ajeu;
import ajev;
import ajew;
import ajex;
import ajey;
import ajez;
import ajfa;
import ajfb;
import ajfc;
import ajfd;
import ajfe;
import ajff;
import ajfg;
import ajfh;
import ajfi;
import ajfj;
import ajfk;
import ajfl;
import ajfm;
import ajfn;
import ajfo;
import ajga;
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
import anhk;
import ankw;
import anmw;
import anni;
import anqd;
import antq;
import anxg;
import aobu;
import aobv;
import aoch;
import aogd;
import aopa;
import awhx;
import awne;
import bbyp;
import bcst;
import bdgn;
import bept;
import bfra;
import bfup;
import bgap;
import bgjt;
import bglf;
import bglp;
import bgmo;
import bgnt;
import bgpa;
import bgtn;
import biau;
import bkhe;
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
  implements aixy, View.OnClickListener, aobv, bkhe, Observer
{
  protected static long c;
  public final long a;
  private ajcv jdField_a_of_type_Ajcv;
  public ajdv a;
  public ajer a;
  public Context a;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  protected View.OnClickListener a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  public TextView a;
  anqd jdField_a_of_type_Anqd = new ajfm(this);
  public antq a;
  anxg jdField_a_of_type_Anxg = new ajez(this);
  public aobu a;
  protected aopa a;
  private awne jdField_a_of_type_Awne;
  public biau a;
  private OverScrollRecyclerView jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView;
  private ThreadExcutor.IThreadListener jdField_a_of_type_ComTencentMobileqqAppThreadExcutor$IThreadListener = new ajfk(this);
  public SwipListView a;
  protected List<MessageRecord> a;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = new ajfj(this);
  public int b;
  public final long b;
  protected View.OnClickListener b;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  protected List<MessageRecord> b;
  public int c;
  View.OnClickListener jdField_c_of_type_AndroidViewView$OnClickListener = new ajfe(this);
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
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new ajfl(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new ajeu(this);
    this.jdField_a_of_type_Ajer = new ajey(this);
    this.jdField_g_of_type_Boolean = true;
    this.jdField_e_of_type_Int = 0;
    this.jdField_d_of_type_AndroidViewView$OnClickListener = new ajfg(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void A()
  {
    this.jdField_f_of_type_Int = bdgn.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.setAdapter(this.jdField_a_of_type_Ajcv);
    this.jdField_b_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(anhk.O, 0);
    ajga.a(this.jdField_b_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_contacts_news", "", "notice", "unnormal_tab_exp", 0, 0, "", "", "", "");
      }
      this.jdField_i_of_type_AndroidViewView.setVisibility(0);
      if (!(this.jdField_b_of_type_JavaUtilList.get(0) instanceof MessageForSystemMsg))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopNotifyAndRecommendView", 2, "initListData error");
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.y();
        this.jdField_a_of_type_Ajcv.a(null);
      }
    }
    else
    {
      this.jdField_i_of_type_AndroidViewView.setVisibility(8);
    }
    this.jdField_a_of_type_Ajcv.a(this.jdField_b_of_type_JavaUtilList);
    this.jdField_a_of_type_Ajcv.notifyDataSetChanged();
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
        if (!bgnt.d(BaseApplication.getContext()))
        {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131691985), 0).b(a());
          return;
        }
      } while ((this.jdField_a_of_type_Awne != null) && (this.jdField_a_of_type_Awne.b()));
      this.jdField_e_of_type_Boolean = true;
      if (this.jdField_a_of_type_Ajcv != null) {
        this.jdField_a_of_type_Ajcv.a(new ajfh(this));
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
    if (this.jdField_a_of_type_Ajcv != null) {
      this.jdField_a_of_type_Ajcv.b();
    }
    this.jdField_e_of_type_Boolean = false;
  }
  
  private void D()
  {
    ThreadManager.post(new TroopNotifyAndRecommendView.27(this), 8, null, false);
  }
  
  private void E()
  {
    this.jdField_g_of_type_Int = bdgn.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
    bfra.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong, new ajev(this), localBundle);
  }
  
  private void a(ajdf paramajdf, MessageRecord paramMessageRecord, int paramInt)
  {
    ajeg localajeg = (ajeg)paramajdf;
    if ((paramMessageRecord == null) || (!(paramMessageRecord instanceof MessageForSystemMsg))) {}
    int m;
    do
    {
      return;
      localajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = ((MessageForSystemMsg)paramMessageRecord).getSystemMsg();
      localajeg.jdField_c_of_type_Long = paramMessageRecord.uniseq;
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
      ajga.a(paramajdf.a(), true);
      localStructMsg = localajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
      localajeg.jdField_a_of_type_Long = paramInt;
      localajeg.jdField_a_of_type_JavaLangString = (localStructMsg.req_uin.get() + "");
      localajeg.jdField_a_of_type_Int = localStructMsg.msg.group_msg_type.get();
      paramInt = localStructMsg.msg.sub_type.get();
      localajeg.jdField_b_of_type_Long = localStructMsg.msg_time.get();
      localajeg.jdField_b_of_type_JavaLangString = localStructMsg.msg.req_uin_nick.get();
      if ((localajeg.jdField_b_of_type_JavaLangString == null) || (localajeg.jdField_b_of_type_JavaLangString.equals(""))) {
        break label721;
      }
      a(localajeg, localStructMsg);
      localajeg.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      str = localStructMsg.msg.group_info.msg_alert.get();
      paramMessageRecord = "";
      if (localStructMsg.msg.bytes_warning_tips.get() != null) {
        paramMessageRecord = localStructMsg.msg.bytes_warning_tips.get().toStringUtf8();
      }
      if (!TextUtils.isEmpty(paramMessageRecord)) {
        break label734;
      }
      localajeg.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      if (localajeg.jdField_a_of_type_Int != 22) {
        break label813;
      }
      paramMessageRecord = localStructMsg.msg;
      localajeg.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      localObject1 = new SpannableString(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131718377, new Object[] { paramMessageRecord.action_uin_nick.get() }));
      ((SpannableString)localObject1).setSpan(new ForegroundColorSpan(Color.parseColor("#00a5e0")), 6, paramMessageRecord.action_uin_nick.get().length() + 6, 33);
      localajeg.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      localajeg.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(new ajfd(this, paramMessageRecord));
    }
    for (;;)
    {
      paramMessageRecord = bfup.a(localStructMsg, localStructMsg.msg.msg_describe.get());
      if (paramMessageRecord == null) {
        break label1072;
      }
      localajeg.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessageRecord);
      label442:
      if (localajeg.jdField_a_of_type_Int != 80) {
        break label1130;
      }
      paramMessageRecord = localStructMsg.msg.actions.get();
      localajeg.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
      localajeg.jdField_a_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)paramMessageRecord.get(0)).name.get());
      localajeg.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131755350);
      localajeg.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839317);
      localajeg.jdField_a_of_type_AndroidWidgetButton.setContentDescription(localajeg.jdField_a_of_type_AndroidWidgetButton.getText() + "");
      localajeg.jdField_a_of_type_AndroidWidgetButton.setTag(localajeg);
      localajeg.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
      label579:
      if (!TextUtils.isEmpty(localajeg.jdField_a_of_type_AndroidWidgetButton.getText())) {
        break label1457;
      }
      localajeg.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      label603:
      if ((paramInt == 2) && (localajeg.jdField_a_of_type_Int == 2) && (((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(String.valueOf(localStructMsg.msg.group_code.get())) != null)) {
        awhx.a().b(String.valueOf(localStructMsg.msg.group_code.get()), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      localajeg.jdField_a_of_type_AndroidWidgetLinearLayout.setTag(paramajdf);
      localajeg.jdField_a_of_type_AndroidWidgetImageView.setTag(paramajdf);
      localajeg.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
      a(localajeg);
      return;
      ajga.a(paramajdf.a(), false);
      break;
      label721:
      localajeg.jdField_b_of_type_JavaLangString = localajeg.jdField_a_of_type_JavaLangString;
      break label206;
      label734:
      localajeg.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      localajeg.jdField_c_of_type_AndroidWidgetTextView.setText(paramMessageRecord);
      paramMessageRecord = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847795);
      paramMessageRecord.setBounds(0, 0, bgtn.a(16.0F), bgtn.a(16.0F));
      localajeg.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(bgtn.a(5.0F));
      localajeg.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawables(paramMessageRecord, null, null, null);
      break label289;
      label813:
      if ((localajeg.jdField_a_of_type_Int == 2) && (localStructMsg.msg.msg_invite_extinfo.uint32_src_type.has()))
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
      localajeg.jdField_c_of_type_AndroidWidgetTextView.setText(anni.a(2131706397) + paramMessageRecord);
      localajeg.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      break;
      Object localObject2 = (ankw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53);
      paramMessageRecord = (MessageRecord)localObject1;
      if (localObject2 != null)
      {
        localObject2 = ((ankw)localObject2).a(String.valueOf(localStructMsg.msg.msg_invite_extinfo.uint64_src_code.get()));
        paramMessageRecord = (MessageRecord)localObject1;
        if (localObject2 != null) {
          paramMessageRecord = ((DiscussionInfo)localObject2).discussionName;
        }
      }
      localajeg.jdField_c_of_type_AndroidWidgetTextView.setText(anni.a(2131706386) + paramMessageRecord);
      localajeg.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      break;
      label1072:
      paramMessageRecord = localStructMsg.msg.msg_additional.get();
      if ((paramMessageRecord == null) || ("".equals(paramMessageRecord)))
      {
        localajeg.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131695489));
        break label442;
      }
      localajeg.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessageRecord);
      break label442;
      label1130:
      if (paramInt == 1)
      {
        paramMessageRecord = localStructMsg.msg.actions.get();
        localajeg.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
        if ((paramMessageRecord != null) && (paramMessageRecord.size() > 0))
        {
          if ((str == null) || ("".equals(str))) {
            if (paramMessageRecord.size() > 1)
            {
              localajeg.jdField_a_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)paramMessageRecord.get(1)).name.get());
              localajeg.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131755350);
              localajeg.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839317);
            }
          }
          for (;;)
          {
            localajeg.jdField_a_of_type_AndroidWidgetButton.setContentDescription(localajeg.jdField_a_of_type_AndroidWidgetButton.getText() + "");
            localajeg.jdField_a_of_type_AndroidWidgetButton.setTag(paramajdf);
            localajeg.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
            break;
            localajeg.jdField_a_of_type_AndroidWidgetButton.setText("");
            continue;
            localajeg.jdField_a_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)paramMessageRecord.get(0)).name.get());
            localajeg.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131755349);
            localajeg.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839316);
          }
        }
        localajeg.jdField_a_of_type_AndroidWidgetButton.setText("");
        localajeg.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(null);
        break label579;
      }
      localajeg.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(null);
      localajeg.jdField_a_of_type_AndroidWidgetButton.setClickable(false);
      localajeg.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131755971);
      localajeg.jdField_a_of_type_AndroidWidgetButton.setText(localStructMsg.msg.msg_decided.get());
      paramMessageRecord = (RelativeLayout.LayoutParams)localajeg.jdField_a_of_type_AndroidWidgetButton.getLayoutParams();
      break label579;
      label1457:
      localajeg.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      break label603;
    }
  }
  
  private void a(ajdm paramajdm, structmsg.StructMsg paramStructMsg)
  {
    String str = bfup.a(paramStructMsg, paramStructMsg.msg.msg_describe.get());
    if (str != null)
    {
      paramajdm.jdField_b_of_type_AndroidWidgetTextView.setText(str);
      return;
    }
    paramStructMsg = paramStructMsg.msg.msg_additional.get();
    if ((paramStructMsg == null) || ("".equals(paramStructMsg)))
    {
      paramajdm.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131695489));
      return;
    }
    paramajdm.jdField_b_of_type_AndroidWidgetTextView.setText(paramStructMsg);
  }
  
  private void a(ajdm paramajdm, structmsg.StructMsg paramStructMsg, int paramInt, String paramString)
  {
    if (paramajdm.jdField_a_of_type_Int == 80)
    {
      paramStructMsg = paramStructMsg.msg.actions.get();
      paramajdm.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
      paramajdm.jdField_a_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)paramStructMsg.get(0)).name.get());
      paramajdm.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131755350);
      paramajdm.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839317);
      paramajdm.jdField_a_of_type_AndroidWidgetButton.setContentDescription(paramajdm.jdField_a_of_type_AndroidWidgetButton.getText() + "");
      paramajdm.jdField_a_of_type_AndroidWidgetButton.setTag(paramajdm);
      paramajdm.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    }
    for (;;)
    {
      paramStructMsg = (RelativeLayout.LayoutParams)paramajdm.jdField_a_of_type_AndroidWidgetButton.getLayoutParams();
      if (paramStructMsg != null)
      {
        paramStructMsg.addRule(11);
        paramStructMsg.rightMargin = 16;
        paramajdm.jdField_a_of_type_AndroidWidgetButton.setLayoutParams(paramStructMsg);
      }
      if (!TextUtils.isEmpty(paramajdm.jdField_a_of_type_AndroidWidgetButton.getText())) {
        break;
      }
      paramajdm.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      return;
      if (paramInt == 1)
      {
        paramStructMsg = paramStructMsg.msg.actions.get();
        paramajdm.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
        if ((paramStructMsg != null) && (paramStructMsg.size() > 0))
        {
          if ((paramString == null) || ("".equals(paramString))) {
            if (paramStructMsg.size() > 1)
            {
              paramajdm.jdField_a_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)paramStructMsg.get(1)).name.get());
              paramajdm.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131755350);
              paramajdm.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839317);
            }
          }
          for (;;)
          {
            paramajdm.jdField_a_of_type_AndroidWidgetButton.setContentDescription(paramajdm.jdField_a_of_type_AndroidWidgetButton.getText() + "");
            paramajdm.jdField_a_of_type_AndroidWidgetButton.setTag(paramajdm);
            paramajdm.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
            break;
            paramajdm.jdField_a_of_type_AndroidWidgetButton.setText("");
            continue;
            paramajdm.jdField_a_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)paramStructMsg.get(0)).name.get());
            paramajdm.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131755349);
            paramajdm.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839316);
          }
        }
        paramajdm.jdField_a_of_type_AndroidWidgetButton.setText("");
        paramajdm.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(null);
      }
      else
      {
        paramajdm.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(null);
        paramajdm.jdField_a_of_type_AndroidWidgetButton.setClickable(false);
        paramajdm.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131755971);
        paramajdm.jdField_a_of_type_AndroidWidgetButton.setText(paramStructMsg.msg.msg_decided.get());
      }
    }
    paramajdm.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
  }
  
  private void a(ajdm paramajdm, structmsg.StructMsg paramStructMsg, String paramString)
  {
    Object localObject;
    if (paramajdm.jdField_a_of_type_Int == 11)
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
          localObject = anni.a(2131714361) + paramString;
        }
      }
      else
      {
        label110:
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label497;
        }
        paramajdm.jdField_c_of_type_AndroidWidgetTextView.setSingleLine(true);
        paramajdm.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        paramajdm.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        label143:
        if (paramajdm.jdField_a_of_type_Int != 22) {
          break label509;
        }
        paramStructMsg = paramStructMsg.msg;
        paramajdm.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        paramString = new SpannableString(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131718377, new Object[] { paramStructMsg.action_uin_nick.get() }));
        paramString.setSpan(new ForegroundColorSpan(Color.parseColor("#00a5e0")), 6, paramStructMsg.action_uin_nick.get().length() + 6, 33);
        paramajdm.jdField_c_of_type_AndroidWidgetTextView.setText(paramString);
        paramajdm.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(new ajet(this, paramStructMsg));
      }
      label497:
      label509:
      while ((paramajdm.jdField_a_of_type_Int != 2) || (!paramStructMsg.msg.msg_invite_extinfo.uint32_src_type.has()))
      {
        return;
        if ((!TextUtils.isEmpty(paramString)) && ((paramajdm.jdField_a_of_type_Int == 1) || (paramajdm.jdField_a_of_type_Int == 22)))
        {
          paramajdm.jdField_c_of_type_AndroidWidgetTextView.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131755973);
          break;
        }
        localObject = new ArrayList();
        ((List)localObject).add(paramStructMsg.msg.msg_qna.get());
        if (paramStructMsg.msg.msg_actor_describe.get() != null) {}
        for (paramString = bfup.a(paramStructMsg, paramStructMsg.msg.msg_actor_describe.get());; paramString = "")
        {
          ((List)localObject).add(paramString);
          ((List)localObject).add(paramStructMsg.msg.msg_additional_list.get());
          ((List)localObject).add(paramStructMsg.msg.msg_additional.get());
          if ((paramajdm.jdField_a_of_type_Int == 12) || (paramajdm.jdField_a_of_type_Int == 83)) {
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
        localObject = anni.a(2131714362);
        break label110;
        paramajdm.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
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
        paramajdm.jdField_c_of_type_AndroidWidgetTextView.setText(anni.a(2131714365) + paramStructMsg);
        paramajdm.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        return;
        ankw localankw = (ankw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53);
        paramString = (String)localObject;
        if (localankw != null)
        {
          paramStructMsg = localankw.a(String.valueOf(paramStructMsg.msg.msg_invite_extinfo.uint64_src_code.get()));
          paramString = (String)localObject;
          if (paramStructMsg != null) {
            paramString = paramStructMsg.discussionName;
          }
        }
        paramajdm.jdField_c_of_type_AndroidWidgetTextView.setText(anni.a(2131714363) + paramString);
        paramajdm.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        return;
      }
      paramString = "";
    }
  }
  
  private void a(ajeg paramajeg)
  {
    int m = 1;
    if (paramajeg == null) {
      return;
    }
    Object localObject;
    String str;
    switch (ajeq.a(paramajeg.jdField_a_of_type_Int))
    {
    default: 
      localObject = String.valueOf(paramajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get());
      m = 4;
      str = paramajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_name.get() + this.jdField_a_of_type_AndroidContentContext.getString(2131695811);
    }
    for (;;)
    {
      localObject = ajeq.a(this.jdField_a_of_type_Aobu, (String)localObject, m);
      paramajeg.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(str);
      paramajeg.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      return;
      localObject = paramajeg.jdField_a_of_type_JavaLangString;
      str = paramajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get() + this.jdField_a_of_type_AndroidContentContext.getString(2131695810);
      continue;
      localObject = String.valueOf(paramajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get());
      str = paramajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin_nick.get() + this.jdField_a_of_type_AndroidContentContext.getString(2131695809);
    }
  }
  
  private void a(ajeg paramajeg, structmsg.StructMsg paramStructMsg)
  {
    if ((paramajeg == null) || (paramStructMsg == null)) {
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
        Object localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
        if (localObject == null) {
          break;
        }
        String str2 = String.valueOf(paramStructMsg.msg.msg_invite_extinfo.uint64_src_code.get());
        String str3 = String.valueOf(paramStructMsg.msg.action_uin.get());
        paramStructMsg = ((TroopManager)localObject).d(str2);
        str1 = bglf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str3, str2, paramStructMsg, true, null);
        paramStructMsg = str1;
        if (TextUtils.isEmpty(str1))
        {
          paramStructMsg = ((TroopManager)localObject).a(str2, str3);
          continue;
          localObject = (ankw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53);
          if (localObject == null) {
            break;
          }
          paramStructMsg = ((ankw)localObject).a(String.valueOf(paramStructMsg.msg.msg_invite_extinfo.uint64_src_code.get()), String.valueOf(paramStructMsg.msg.action_uin.get()));
          if (paramStructMsg == null) {
            break;
          }
          paramStructMsg = paramStructMsg.getDiscussionMemberName();
        }
      }
    }
    switch (ajeq.a(paramajeg.jdField_a_of_type_Int))
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
  
  private void a(RecyclerView paramRecyclerView, String paramString, Bitmap paramBitmap)
  {
    Object localObject;
    ajeg localajeg;
    if (this.jdField_b_of_type_Int == 0)
    {
      int n = paramRecyclerView.getChildCount();
      int m = 0;
      while (m < n)
      {
        localObject = paramRecyclerView.findViewHolderForAdapterPosition(m);
        if ((localObject == null) || (!(localObject instanceof ajeg)))
        {
          m += 1;
        }
        else
        {
          localajeg = (ajeg)localObject;
          switch (ajeq.a(localajeg.jdField_a_of_type_Int))
          {
          default: 
            localObject = String.valueOf(localajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get());
          }
        }
      }
    }
    while ((localajeg.jdField_a_of_type_AndroidWidgetImageView != null) && (paramString.equals(localObject)))
    {
      localajeg.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
      return;
      localObject = localajeg.jdField_a_of_type_JavaLangString;
      continue;
      localObject = String.valueOf(localajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get());
    }
  }
  
  private void a(structmsg.StructMsg paramStructMsg, long paramLong)
  {
    if (paramStructMsg != null)
    {
      long l1 = ((structmsg.StructMsg)paramStructMsg.get()).msg_seq.get() + ((structmsg.StructMsg)paramStructMsg.get()).msg_type.get();
      bdgn.a().a(Long.valueOf(l1), (structmsg.StructMsg)paramStructMsg.get());
      bdgn.a().b(l1);
      bdgn.a().a(paramLong);
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
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_discuss", "", "verify_msg", "Clk_agree", 0, 0, String.valueOf(paramStructMsg.msg.group_code.get()), "", "", "");
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
  
  private void b(ajdm paramajdm)
  {
    int m = 1;
    if (paramajdm == null) {
      return;
    }
    Object localObject;
    String str;
    switch (ajeq.a(paramajdm.jdField_a_of_type_Int))
    {
    default: 
      localObject = String.valueOf(paramajdm.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get());
      m = 4;
      str = paramajdm.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_name.get() + this.jdField_a_of_type_AndroidContentContext.getString(2131695811);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = bgmo.b();
      }
      localObject = aoch.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), m, (String)localObject, 3, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      paramajdm.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(str);
      paramajdm.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      return;
      localObject = paramajdm.jdField_a_of_type_JavaLangString;
      str = paramajdm.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get() + this.jdField_a_of_type_AndroidContentContext.getString(2131695810);
      continue;
      localObject = String.valueOf(paramajdm.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get());
      str = paramajdm.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin_nick.get() + this.jdField_a_of_type_AndroidContentContext.getString(2131695809);
    }
  }
  
  private void b(ajdm paramajdm, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotifyAndRecommendView", 2, "jumpToTroopRequestActivity!" + paramajdm.jdField_a_of_type_Long + ": dealMsgType = " + paramInt);
    }
    Intent localIntent = new Intent(a(), TroopRequestActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putLong("troopMsgId", paramajdm.jdField_a_of_type_Long);
    localBundle.putInt("mTroopMsgType", paramajdm.jdField_a_of_type_Int);
    localBundle.putString("mTroopCode", String.valueOf(paramajdm.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get()));
    localBundle.putString("troopmanagerUin", String.valueOf(paramajdm.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get()));
    localBundle.putString("troopsMsg", paramajdm.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get());
    if ((this.jdField_a_of_type_Ajdv != null) && (paramajdm.jdField_b_of_type_Int < this.jdField_a_of_type_Ajdv.jdField_a_of_type_Int)) {}
    for (boolean bool = true;; bool = false)
    {
      localBundle.putBoolean("is_unread", bool);
      localBundle.putString("troopRequestUin", String.valueOf(paramajdm.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()));
      localBundle.putString("troopsummary", paramajdm.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get());
      localBundle.putLong("infotime", paramajdm.jdField_b_of_type_Long);
      localBundle.putInt("troopfromtab", this.jdField_c_of_type_Int);
      if ((a() instanceof TroopActivity)) {
        localBundle.putBoolean("troop_invitee_is_friend", a((ArrayList)((TroopActivity)a()).a, String.valueOf(paramajdm.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get())));
      }
      if (paramajdm.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() != 83) {
        localIntent.putExtra("troopMsgDealInfo", paramajdm.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_detail.get());
      }
      a((structmsg.StructMsg)paramajdm.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get(), paramajdm.jdField_c_of_type_Long);
      localBundle.putInt("t_s_f", 1001);
      localIntent.putExtras(localBundle);
      a(localIntent);
      return;
    }
  }
  
  private void b(ajdm paramajdm, structmsg.StructMsg paramStructMsg)
  {
    if ((paramajdm == null) || (paramStructMsg == null)) {
      return;
    }
    if ((paramajdm.jdField_a_of_type_Int == 2) && (paramStructMsg.msg.msg_invite_extinfo.uint32_src_type.has()))
    {
      String str1 = paramStructMsg.msg.action_uin_qq_nick.get().toStringUtf8();
      switch (paramStructMsg.msg.msg_invite_extinfo.uint32_src_type.get())
      {
      default: 
        paramStructMsg = str1;
      }
      for (;;)
      {
        paramajdm.jdField_a_of_type_AndroidWidgetTextView.setText(paramStructMsg);
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
        str1 = bglf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str3, str2, paramStructMsg, true, null);
        paramStructMsg = str1;
        if (TextUtils.isEmpty(str1))
        {
          paramStructMsg = ((TroopManager)localObject).a(str2, str3);
          continue;
          localObject = (ankw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53);
          if (localObject == null) {
            break;
          }
          paramStructMsg = ((ankw)localObject).a(String.valueOf(paramStructMsg.msg.msg_invite_extinfo.uint64_src_code.get()), String.valueOf(paramStructMsg.msg.action_uin.get()));
          if (paramStructMsg == null) {
            break;
          }
          paramStructMsg = paramStructMsg.getDiscussionMemberName();
        }
      }
    }
    switch (ajeq.a(paramajdm.jdField_a_of_type_Int))
    {
    default: 
      paramajdm.jdField_a_of_type_AndroidWidgetTextView.setText(paramajdm.jdField_b_of_type_JavaLangString);
      return;
    case 0: 
      paramajdm.jdField_a_of_type_AndroidWidgetTextView.setText(paramStructMsg.msg.group_name.get());
      return;
    case 1: 
      paramajdm.jdField_a_of_type_AndroidWidgetTextView.setText(paramStructMsg.msg.action_uin_nick.get());
      return;
    }
    paramajdm.jdField_a_of_type_AndroidWidgetTextView.setText(paramajdm.jdField_b_of_type_JavaLangString);
  }
  
  private void b(ajeg paramajeg)
  {
    if (paramajeg == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotifyAndRecommendView", 2, "jumpToTroopRequestActivity!" + paramajeg.jdField_a_of_type_Long);
    }
    ajga.a(paramajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, "unnormal_edit");
    Intent localIntent = new Intent(a(), TroopRequestActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putLong("troopMsgId", paramajeg.jdField_a_of_type_Long);
    localBundle.putInt("mTroopMsgType", paramajeg.jdField_a_of_type_Int);
    localBundle.putString("mTroopCode", String.valueOf(paramajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get()));
    localBundle.putString("troopmanagerUin", String.valueOf(paramajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get()));
    localBundle.putString("troopsMsg", paramajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get());
    int m = bdgn.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (paramajeg.jdField_b_of_type_Int < m) {}
    for (boolean bool = true;; bool = false)
    {
      localBundle.putBoolean("is_unread", bool);
      localBundle.putString("troopRequestUin", String.valueOf(paramajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()));
      localBundle.putString("troopsummary", paramajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get());
      localBundle.putLong("infotime", paramajeg.jdField_b_of_type_Long);
      if ((a() instanceof TroopActivity)) {
        localBundle.putBoolean("troop_invitee_is_friend", a((ArrayList)((TroopActivity)a()).a, String.valueOf(paramajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get())));
      }
      if (paramajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() != 83) {
        localIntent.putExtra("troopMsgDealInfo", paramajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_detail.get());
      }
      ajga.a((structmsg.StructMsg)paramajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get());
      a((structmsg.StructMsg)paramajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get(), paramajeg.jdField_c_of_type_Long);
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
        bcst.b(null, "P_CliOper", "Grp_discuss", "", "verify_msg", "Clk_agree", 0, 0, String.valueOf(paramStructMsg.msg.group_code.get()), "", "", "");
      }
      return bool;
    }
  }
  
  private void r()
  {
    int m = bdgn.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (this.jdField_a_of_type_Ajdv != null) {
      if (!ajfo.b()) {
        break label49;
      }
    }
    label49:
    for (this.jdField_a_of_type_Ajdv.jdField_a_of_type_Int = 0;; this.jdField_a_of_type_Ajdv.jdField_a_of_type_Int = m)
    {
      ThreadManager.postImmediately(new TroopNotifyAndRecommendView.6(this), this.jdField_a_of_type_ComTencentMobileqqAppThreadExcutor$IThreadListener, false);
      return;
    }
  }
  
  private void s()
  {
    Object localObject3 = "";
    String str = "";
    List localList = ajfn.d();
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
      bgjt.a("Grp_contacts_news", "notice", "enter_verify", 0, 0, new String[] { localObject2, localObject1 });
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
      this.jdField_e_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561561, null);
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
          if (!bgnt.d(BaseApplication.getContext()))
          {
            QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131691985), 0).b(a());
            return;
          }
          if ((this.jdField_a_of_type_Ajdv == null) || ((this.jdField_a_of_type_Ajdv.b()) && (!this.jdField_a_of_type_Ajdv.a()))) {
            break;
          }
        } while ((this.jdField_a_of_type_Awne != null) && (this.jdField_a_of_type_Awne.a()));
        this.jdField_i_of_type_Boolean = true;
        this.jdField_e_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().h();
      } while (!QLog.isColorLevel());
      QLog.i("TroopNotifyAndRecommendView", 2, "loadNextPage.get next page of Notofication");
      return;
      if ((this.jdField_a_of_type_Antq.jdField_a_of_type_Int != 1) && (this.k))
      {
        this.jdField_i_of_type_Boolean = true;
        this.jdField_e_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_Antq.a();
        if (QLog.isColorLevel()) {
          QLog.i("TroopNotifyAndRecommendView", 2, "loadNextPage.get next page of recommend");
        }
        bgjt.a("Grp_contacts_news", "notice", "recom_,more", 2, 0, new String[0]);
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
    List localList = ajfn.a();
    if ((ajfn.b().isEmpty()) && (this.jdField_b_of_type_JavaUtilList.isEmpty()) && (localList.isEmpty()))
    {
      this.jdField_f_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    this.jdField_f_of_type_AndroidViewView.setVisibility(0);
  }
  
  private void y()
  {
    this.jdField_a_of_type_Ajcv = new ajfb(this, a(), 2131559902);
    this.jdField_a_of_type_Ajcv.a(2131559903);
    this.jdField_a_of_type_Ajcv.a(2131561561);
    this.jdField_a_of_type_Ajcv.a(new ajfc(this));
  }
  
  private void z()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView = ((OverScrollRecyclerView)findViewById(2131378102));
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.setLayoutManager(new LinearLayoutManager(a(), 1, false));
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.addOnScrollListener(new ajff(this));
    this.jdField_a_of_type_Aobu = new aobu(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Aobu.a(this);
  }
  
  public int a()
  {
    return getResources().getDimensionPixelSize(2131298998);
  }
  
  public void a(ajdm paramajdm)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotifyAndRecommendView", 2, "handleGroupSystemMsg! start " + paramajdm.jdField_a_of_type_Long);
    }
    b(paramajdm, 998);
    Object localObject = paramajdm.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_info.msg_alert.get();
    String str4 = paramajdm.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get() + "";
    String str2;
    int m;
    label146:
    String str1;
    if ((this.jdField_a_of_type_Ajdv != null) && (paramajdm.jdField_b_of_type_Int < this.jdField_a_of_type_Ajdv.jdField_a_of_type_Int))
    {
      str2 = "1";
      m = paramajdm.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_inviter_role.get();
      if ((m != 2) && (m != 3)) {
        break label306;
      }
      m = 0;
      switch (paramajdm.jdField_a_of_type_Int)
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
        paramajdm = "";
        localObject = "";
        str1 = "";
      }
    }
    for (;;)
    {
      bgjt.a("Grp_contacts_news", "notice", str1, 3, 0, new String[] { str4, str2, localObject, paramajdm });
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
        if (paramajdm.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get() != 1) {
          break label368;
        }
        paramajdm = "0";
        break;
      }
      label368:
      long l1 = paramajdm.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actor_uin.get();
      if ((l1 != 0L) && (!(l1 + "").equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {}
      for (paramajdm = "2";; paramajdm = "1") {
        break;
      }
      paramajdm = "";
      localObject = "";
      str1 = "refuseask_page";
      continue;
      if (paramajdm.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get() == 1) {}
      for (paramajdm = "0";; paramajdm = "1")
      {
        localObject = "";
        str1 = "enter_invite";
        break;
      }
      if (m != 0) {}
      String str3;
      for (paramajdm = "0";; paramajdm = "1")
      {
        str1 = "refuseinvite_page";
        str3 = "";
        localObject = paramajdm;
        paramajdm = str3;
        break;
      }
      if (m != 0) {}
      for (paramajdm = "0";; paramajdm = "1")
      {
        str1 = "refuseagree_page";
        str3 = "";
        localObject = paramajdm;
        paramajdm = str3;
        break;
      }
      paramajdm = "";
      localObject = "";
      str1 = "quit_page";
      continue;
      str1 = "byquit_page";
      paramajdm = "";
      localObject = "0";
      continue;
      str1 = "byquit_page";
      paramajdm = "";
      localObject = "1";
      continue;
      if ((paramajdm.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get() + "").equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {}
      for (paramajdm = "0";; paramajdm = "1")
      {
        str1 = "set_admin_page";
        str3 = "";
        localObject = paramajdm;
        paramajdm = str3;
        break;
      }
      str1 = "un_admin_page";
      paramajdm = "";
      localObject = "0";
      continue;
      str1 = "un_admin_page";
      paramajdm = "";
      localObject = "1";
    }
  }
  
  public void a(ajdm paramajdm, int paramInt)
  {
    int n = -1;
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotifyAndRecommendView", 2, "bindTroopSystemMsgView! start " + paramajdm.jdField_a_of_type_Long);
    }
    structmsg.StructMsg localStructMsg = paramajdm.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
    paramajdm.jdField_a_of_type_Long = paramInt;
    paramajdm.jdField_a_of_type_JavaLangString = (localStructMsg.req_uin.get() + "");
    paramajdm.jdField_a_of_type_Int = localStructMsg.msg.group_msg_type.get();
    paramInt = localStructMsg.msg.sub_type.get();
    paramajdm.jdField_b_of_type_Long = localStructMsg.msg_time.get();
    paramajdm.jdField_b_of_type_JavaLangString = localStructMsg.msg.req_uin_nick.get();
    String str;
    if ((paramajdm.jdField_b_of_type_JavaLangString != null) && (!paramajdm.jdField_b_of_type_JavaLangString.equals("")))
    {
      b(paramajdm, localStructMsg);
      paramajdm.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      str = localStructMsg.msg.group_info.msg_alert.get();
      a(paramajdm, localStructMsg, str);
      a(paramajdm, localStructMsg);
      a(paramajdm, localStructMsg, paramInt, str);
      if ((paramInt == 2) && (paramajdm.jdField_a_of_type_Int == 2) && (((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(String.valueOf(localStructMsg.msg.group_code.get())) != null)) {
        awhx.a().b(String.valueOf(localStructMsg.msg.group_code.get()), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      if (localStructMsg.msg.bytes_warning_tips.get() == null) {
        break label592;
      }
      str = localStructMsg.msg.bytes_warning_tips.get().toStringUtf8();
      label310:
      if (TextUtils.isEmpty(str)) {
        break label599;
      }
      paramajdm.jdField_d_of_type_AndroidWidgetTextView.setText(str);
      paramajdm.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      label335:
      if (QLog.isColorLevel()) {
        QLog.d("Q.security_verify", 2, String.format("bindTroopSystemMsgView reqUin: %s, warningTips: %s", new Object[] { paramajdm.jdField_a_of_type_JavaLangString, str }));
      }
      paramajdm.jdField_a_of_type_AndroidWidgetLinearLayout.setTag(paramajdm);
      paramajdm.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramajdm.jdField_a_of_type_AndroidWidgetImageView.setTag(paramajdm);
      if ((paramajdm.jdField_a_of_type_Int != 8) && (paramajdm.jdField_a_of_type_Int != 7)) {
        break label611;
      }
      paramajdm.jdField_a_of_type_AndroidWidgetImageView.setEnabled(false);
      label423:
      b(paramajdm);
      if (((paramajdm.jdField_a_of_type_Int == 1) || (paramajdm.jdField_a_of_type_Int == 22) || (paramajdm.jdField_a_of_type_Int == 60)) && (QLog.isColorLevel())) {
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
      QLog.i("TroopNotifyAndRecommendView", 2, String.format("joinGroup subSourceID=%d sourceID=%d msgType=%d", new Object[] { Integer.valueOf(m), Integer.valueOf(paramInt), Integer.valueOf(paramajdm.jdField_a_of_type_Int) }));
      return;
      paramajdm.jdField_b_of_type_JavaLangString = paramajdm.jdField_a_of_type_JavaLangString;
      break;
      str = "";
      break label310;
      paramajdm.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      break label335;
      paramajdm.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      break label423;
    }
  }
  
  protected void a(Intent paramIntent, ajdg paramajdg)
  {
    super.a(paramIntent, paramajdg);
    this.jdField_a_of_type_Antq = ((antq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(22));
    this.jdField_a_of_type_Awne = ((awne)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37));
    i();
    b(paramIntent, paramajdg);
    c(paramIntent, paramajdg);
    this.jdField_a_of_type_AndroidWidgetTextView = paramajdg.a();
    bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_contacts_news", "", "notice", "notice_exp", 0, 0, "", "", "", "");
  }
  
  public void a(List<RecommendTroopItem> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotifyAndRecommendView", 2, "handleRecommendDataResult: " + Log.getStackTraceString(new RuntimeException("debug trace")));
    }
    this.jdField_a_of_type_Ajdg.a(new TroopNotifyAndRecommendView.19(this, paramList));
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
    b(ajfn.b());
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
        Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837954);
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
    int i1 = antq.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (i1 > 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(anhk.W, 9000, 0 - i1);
      this.jdField_a_of_type_Antq.b();
      o();
    }
    int n = 0;
    int m = n;
    if (this.jdField_a_of_type_Antq != null)
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
  
  protected void b(Intent paramIntent, ajdg paramajdg)
  {
    a(this.jdField_a_of_type_Anqd);
    u();
    r();
    this.jdField_a_of_type_Biau = new biau(this.jdField_a_of_type_AndroidContentContext, a());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
    if (ajeq.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) > 0) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(3);
    }
    ajeq.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (this.jdField_a_of_type_Ajdv != null) {
      this.jdField_a_of_type_Ajdv.notifyDataSetChanged();
    }
    int m = bdgn.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotifyAndRecommendView", 2, "notification num:" + m);
    }
    this.jdField_a_of_type_Antq.jdField_c_of_type_Int = m;
    int n = antq.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(anhk.W, 9000, 0 - (m + n));
    bdgn.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
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
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_contacts_news", "", "notice", "todo_tab_exp", 0, 0, "", "", "", "");
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
  
  protected void c(Intent paramIntent, ajdg paramajdg)
  {
    super.a(paramIntent, paramajdg);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this);
    a(this.jdField_a_of_type_Anxg);
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
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_contacts_news", "", "notice", "quit_tab_exp", 0, 0, "", "", "", "");
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
      ajeq.b();
      bdgn.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
      if (this.jdField_a_of_type_Ajdv != null)
      {
        this.jdField_a_of_type_Ajdv.jdField_a_of_type_Int = 0;
        this.jdField_a_of_type_Ajdv.notifyDataSetChanged();
      }
      this.jdField_a_of_type_Antq.jdField_c_of_type_Int = bdgn.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    if (this.jdField_c_of_type_Int == 3) {
      bdgn.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
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
    if (this.jdField_a_of_type_Antq != null) {
      this.jdField_a_of_type_Antq.b();
    }
    if (this.jdField_c_of_type_Int == 3)
    {
      this.jdField_a_of_type_Aobu.c();
      this.jdField_a_of_type_Aobu.a();
    }
  }
  
  protected void g()
  {
    super.g();
    if (this.jdField_a_of_type_Ajdv != null) {
      this.jdField_a_of_type_Ajdv.b();
    }
    if ((this.jdField_a_of_type_Ajdv != null) && (this.jdField_a_of_type_Ajdv.a() > 0)) {
      t();
    }
    b(this.jdField_a_of_type_Anxg);
    MqqHandler localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(TroopNotifyAndRecommendView.class);
    if (localMqqHandler != null) {
      localMqqHandler.removeCallbacksAndMessages(null);
    }
    b(this.jdField_a_of_type_Anqd);
    if (this.jdField_a_of_type_Ajdv != null)
    {
      this.jdField_a_of_type_Ajdv.a();
      this.jdField_a_of_type_Ajdv.notifyDataSetChanged();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this);
    ajeq.b();
    bdgn.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
    if (this.jdField_c_of_type_Boolean) {
      bdgn.a().b();
    }
    bgap.a(a()).a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeHandler(getClass());
    if (this.jdField_a_of_type_Aopa != null) {
      SosoInterface.b(this.jdField_a_of_type_Aopa);
    }
    this.jdField_a_of_type_Antq.b();
    this.jdField_a_of_type_Antq.d();
    this.jdField_a_of_type_Antq.a();
    if (this.jdField_a_of_type_Aobu != null) {
      this.jdField_a_of_type_Aobu.a(null);
    }
    if (this.jdField_a_of_type_Ajcv != null)
    {
      this.jdField_a_of_type_Ajcv.a();
      this.jdField_a_of_type_Ajcv.notifyDataSetChanged();
    }
  }
  
  public void i()
  {
    a(2131559891);
    this.jdField_a_of_type_Ajdv = new ajdv(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getContext(), this.jdField_a_of_type_Ajdg, this);
    this.jdField_a_of_type_ComTencentWidgetSwipListView = ((SwipListView)findViewById(2131379289));
    this.jdField_f_of_type_AndroidViewView = findViewById(2131364487);
    this.jdField_g_of_type_AndroidViewView = findViewById(2131378162);
    this.jdField_h_of_type_AndroidViewView = findViewById(2131378157);
    this.jdField_i_of_type_AndroidViewView = findViewById(2131378166);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378165));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131378163));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378164));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378160));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131378158));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378159));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378167));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131378168));
    p();
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDragEnable(true);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setAdapter(this.jdField_a_of_type_Ajdv);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setOnScrollListener(this);
    this.jdField_i_of_type_AndroidViewView.setOnClickListener(new ajes(this));
    this.jdField_h_of_type_AndroidViewView.setOnClickListener(new ajfa(this));
    this.jdField_g_of_type_AndroidViewView.setOnClickListener(new ajfi(this));
  }
  
  public void j()
  {
    bglp.a(this.jdField_a_of_type_AndroidContentContext, null, this.jdField_a_of_type_AndroidContentContext.getString(2131718843), null, 2131690582, 2131694260, new ajew(this), new ajex(this)).show();
  }
  
  public void k()
  {
    t();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.w();
    bdgn.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
    ajfn.a();
    if (this.jdField_a_of_type_Ajdv != null)
    {
      this.jdField_a_of_type_Ajdv.a();
      this.jdField_a_of_type_Ajdv.notifyDataSetChanged();
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
      this.jdField_a_of_type_Antq.a();
    }
    if ((!this.k) && (this.jdField_a_of_type_Ajdv != null))
    {
      this.jdField_a_of_type_Ajdv.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_Ajdv.notifyDataSetChanged();
    }
    b();
    m();
  }
  
  protected void m()
  {
    if ((this.jdField_f_of_type_Boolean) && (this.jdField_a_of_type_Ajdv != null) && (this.jdField_a_of_type_Ajdv.b()))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("TroopNotifyAndRecommendView", 4, "reportPv");
      }
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_recom", "", "msg_page", "exp", 0, 0, "", "", "", "");
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
    if ((this.jdField_a_of_type_Antq != null) && (!this.jdField_b_of_type_Boolean) && (antq.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) > 0))
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
      case 2131371579: 
        bept.a(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        break;
      case 2131373551: 
        if ((paramView.getTag() instanceof ajdm))
        {
          localObject2 = (ajdm)paramView.getTag();
          if (localObject2 != null)
          {
            localObject3 = ((ajdm)localObject2).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
            m = ((ajdm)localObject2).jdField_a_of_type_Int;
            if (ajeq.a(m) == 0)
            {
              localObject1 = TroopInfoActivity.a(String.valueOf(((ajdm)localObject2).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get()), 4);
              ((Bundle)localObject1).putInt("t_s_f", 1001);
              bfup.a(a(), (Bundle)localObject1, 2);
              if ((m == 2) || (m == 10) || (m == 12))
              {
                m = 1;
                label192:
                localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
                String str = ((ajdm)localObject2).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get() + "";
                if (m == 0) {
                  break label343;
                }
                localObject1 = "0";
                label241:
                bcst.b((QQAppInterface)localObject3, "P_CliOper", "Grp_contacts", "", "notice", "see_data", 0, 0, str, (String)localObject1, "", "");
                localObject2 = ((ajdm)localObject2).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code + "";
                if (m == 0) {
                  break label351;
                }
              }
              label343:
              label351:
              for (localObject1 = "0";; localObject1 = "1")
              {
                bgjt.a("Grp_contacts_news", "notice", "see_data", 0, 0, new String[] { localObject2, localObject1 });
                break;
                m = 0;
                break label192;
                localObject1 = "1";
                break label241;
              }
            }
            if ((((ajdm)localObject2).jdField_a_of_type_Int != 2) || (!TroopInfo.isQidianPrivateTroop(((ajdm)localObject2).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.uint32_group_flagext3.get())))
            {
              if (((ajdm)localObject2).jdField_a_of_type_Int != 82) {
                break label476;
              }
              localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, AccountDetailActivity.class);
              ((Intent)localObject1).putExtra("uin", ((ajdm)localObject2).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get() + "");
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
    switch (ajeq.a(m))
    {
    default: 
      localObject1 = String.valueOf(l1);
      label518:
      if (((anmw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b((String)localObject1)) {
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
      bgjt.a("Grp_contacts_news", "notice", "see_fromdata", 0, 0, new String[] { ((ajdm)localObject2).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code + "", "3" });
      break;
      localObject1 = ((ajdm)localObject2).jdField_a_of_type_JavaLangString;
      break label518;
      localObject1 = String.valueOf(((ajdm)localObject2).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get());
      break label518;
      if ((((structmsg.StructMsg)localObject3).msg.group_msg_type.get() == 2) && (((structmsg.StructMsg)localObject3).msg.sub_type.get() == 3))
      {
        localObject1 = new ProfileActivity.AllInOne((String)localObject1, 26);
        ((ProfileActivity.AllInOne)localObject1).jdField_d_of_type_Int = 1;
      }
      else
      {
        localObject1 = new ProfileActivity.AllInOne((String)localObject1, 24);
        bfup.a((structmsg.StructMsg)localObject3, (ProfileActivity.AllInOne)localObject1);
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
    if (this.jdField_a_of_type_Ajdv != null) {
      this.jdField_a_of_type_Ajdv.a(this.jdField_d_of_type_Int, this.jdField_c_of_type_Int);
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
      if (this.jdField_a_of_type_Ajdv == null) {
        break label99;
      }
    }
    label99:
    for (int m = this.jdField_a_of_type_Ajdv.getCount();; m = 0)
    {
      QLog.d("TroopNotifyAndRecommendView", 2, m);
      if ((this.jdField_a_of_type_Ajdv != null) && (paramInt == 0) && (this.jdField_d_of_type_Int == this.jdField_a_of_type_Ajdv.getCount() - 1)) {
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
    t();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.x();
    bdgn.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
    this.jdField_b_of_type_JavaUtilList.clear();
    if (this.jdField_a_of_type_Ajcv != null) {
      this.jdField_a_of_type_Ajcv.a();
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