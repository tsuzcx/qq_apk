package com.tencent.mobileqq.activity.aio.item;

import aean;
import agej;
import aggk;
import aggl;
import aggp;
import aghd;
import agif;
import agjg;
import agjk;
import agvi;
import agxx;
import ahst;
import ahsy;
import ahsz;
import ahta;
import ahtb;
import ahtc;
import ahte;
import ahtf;
import ahtg;
import ahth;
import ahti;
import ahtj;
import ahtk;
import ahtm;
import aics;
import aicv;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.MQLruCache;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import antf;
import anzj;
import aoju;
import asci;
import auog;
import auxu;
import avlv;
import axpf;
import axpm;
import azrm;
import bcrg;
import bcsa;
import bdkh;
import bdll;
import bdol;
import bdos;
import bdow;
import bdqe;
import bdqr;
import bdqu;
import bdrd;
import bdsg;
import bdtc;
import bdts;
import becb;
import beqz;
import berp;
import bete;
import beyb;
import beyq;
import bfuv;
import bgre;
import bhgr;
import bhju;
import bhlg;
import bhlq;
import bhmi;
import bhnt;
import bhpc;
import bhuk;
import bhum;
import bhvc;
import biku;
import bikv;
import blir;
import blji;
import blol;
import bloo;
import bmbt;
import bmko;
import bmkq;
import bmky;
import bmlc;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AudioPlayerBase;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.customviews.MessageProgressTextView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.ThumbWidthHeightDP;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.ShareData;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForAudioShare;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForHypertext;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.XListView;
import cooperation.comic.VipComicJumpActivity;
import java.io.File;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import nnr;
import odr;
import oer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import txw;
import txx;
import tzq;
import yup;
import zps;

public class StructingMsgItemBuilder
  extends BaseBubbleBuilder
  implements aggp, agif, agjg
{
  public static final int[] a;
  static int c;
  private bdqe jdField_a_of_type_Bdqe;
  blol jdField_a_of_type_Blol;
  private List<StructMsgForImageShare> jdField_a_of_type_JavaUtilList = new ArrayList();
  private final float jdField_b_of_type_Float;
  private List<AbsShareMsg> jdField_b_of_type_JavaUtilList = new ArrayList();
  private volatile boolean f;
  private volatile boolean g;
  private volatile boolean h;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 83, 98, 108, 114, 116, 151, 156 };
  }
  
  public StructingMsgItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_b_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_Bdqe = new bdqe();
  }
  
  private StructMsgForGeneralShare a(ChatMessage paramChatMessage)
  {
    if (!(paramChatMessage instanceof MessageForStructing)) {
      paramChatMessage = null;
    }
    StructMsgForGeneralShare localStructMsgForGeneralShare;
    do
    {
      return paramChatMessage;
      paramChatMessage = (MessageForStructing)paramChatMessage;
      if (!(paramChatMessage.structingMsg instanceof StructMsgForGeneralShare)) {
        break;
      }
      localStructMsgForGeneralShare = (StructMsgForGeneralShare)paramChatMessage.structingMsg;
      paramChatMessage = localStructMsgForGeneralShare;
    } while (localStructMsgForGeneralShare.getProgress() >= 0);
    return null;
  }
  
  public static String a()
  {
    return String.valueOf(c);
  }
  
  private void a(long paramLong)
  {
    if (((this.jdField_a_of_type_AndroidContentContext instanceof ChatActivity)) || ((this.jdField_a_of_type_AndroidContentContext instanceof SplashActivity)))
    {
      bikv localbikv = (bikv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(76);
      biku localbiku = localbikv.a();
      BaseActivity localBaseActivity = (BaseActivity)this.jdField_a_of_type_AndroidContentContext;
      if ((localbiku != null) && (localBaseActivity.isResume()) && (localbiku.b.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (localbiku.d == 2L) && (paramLong == localbiku.a)) {
        localbikv.a(localbiku, localBaseActivity);
      }
    }
  }
  
  private void a(ahtm paramahtm, BaseChatItemLayout paramBaseChatItemLayout, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramBaseChatItemLayout.setHeadIconVisible(false);
      paramahtm.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130850680);
      int i = paramahtm.jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingLeft();
      int j = paramahtm.jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingLeft();
      paramahtm.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, i, 0, j);
      return;
    }
    paramBaseChatItemLayout.setHeadIconVisible(true);
  }
  
  private void a(ahtm paramahtm, BaseChatItemLayout paramBaseChatItemLayout, boolean paramBoolean1, AbsStructMsg paramAbsStructMsg, Resources paramResources, boolean paramBoolean2)
  {
    Object localObject2 = paramahtm.jdField_b_of_type_AndroidWidgetRelativeLayout;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramahtm.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject1);
      ((RelativeLayout)localObject1).setId(2131378081);
      paramBaseChatItemLayout.addView((View)localObject1);
    }
    Object localObject3 = (RelativeLayout.LayoutParams)((RelativeLayout)localObject1).getLayoutParams();
    localObject2 = localObject3;
    if (localObject3 == null) {
      localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    }
    ((RelativeLayout.LayoutParams)localObject2).topMargin = agej.a(-2.0F, paramResources);
    if (paramBoolean2)
    {
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = agej.a(0.0F, paramResources);
      ((RelativeLayout.LayoutParams)localObject2).addRule(5, 2131364423);
      ((RelativeLayout.LayoutParams)localObject2).addRule(3, 2131364423);
      ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject3 = ((RelativeLayout)localObject1).getChildAt(0);
      localObject2 = localObject3;
      if (localObject3 != null)
      {
        localObject2 = localObject3;
        if (paramahtm.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
        {
          Object localObject4 = paramahtm.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
          localObject2 = localObject3;
          if (localObject4 != null)
          {
            localObject4 = ((View)localObject4).getTag(2131378101);
            if (QLog.isColorLevel()) {
              QLog.d("structMsg", 2, "bindviwfor structmsg tag:" + localObject4);
            }
            if (localObject4 != null)
            {
              localObject2 = localObject3;
              if (localObject4.getClass() == paramAbsStructMsg.getClass()) {}
            }
            else
            {
              localObject2 = null;
            }
          }
        }
      }
      ((RelativeLayout)localObject1).removeAllViews();
      ((RelativeLayout)localObject1).setBackgroundDrawable(null);
      localObject2 = paramAbsStructMsg.getSourceView(this.jdField_a_of_type_AndroidContentContext, (View)localObject2);
      if (localObject2 == null) {
        break label507;
      }
      ((View)localObject2).setId(2131378082);
      ((RelativeLayout)localObject1).addView((View)localObject2);
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
      {
        paramahtm = new View(this.jdField_a_of_type_AndroidContentContext);
        paramBaseChatItemLayout = new RelativeLayout.LayoutParams(-2, -2);
        paramBaseChatItemLayout.addRule(6, 2131378082);
        paramBaseChatItemLayout.addRule(5, 2131378082);
        paramBaseChatItemLayout.addRule(7, 2131378082);
        paramBaseChatItemLayout.addRule(8, 2131378082);
        paramahtm.setBackgroundResource(2130837978);
        ((RelativeLayout)localObject1).addView(paramahtm, paramBaseChatItemLayout);
      }
    }
    for (;;)
    {
      a(paramAbsStructMsg, (RelativeLayout)localObject1);
      avlv.a((View)localObject2, (RelativeLayout)localObject1, paramBoolean1, paramResources, this.jdField_a_of_type_AndroidContentContext, paramAbsStructMsg);
      return;
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = agej.a(10.0F, paramResources);
      if ((!paramBoolean1) || ((paramAbsStructMsg.mMsgServiceID != 83) && (paramAbsStructMsg.mMsgServiceID != 108) && (paramAbsStructMsg.mMsgServiceID != 114) && (paramAbsStructMsg.mMsgServiceID != 116) && (paramAbsStructMsg.mMsgServiceID != 151) && (paramAbsStructMsg.mMsgServiceID != 156)) || (TextUtils.isEmpty(paramAbsStructMsg.mMsgActionData))) {
        break;
      }
      ((RelativeLayout.LayoutParams)localObject2).leftMargin += agej.a(18.0F, paramResources);
      break;
      label507:
      paramBaseChatItemLayout.removeView((View)localObject1);
      paramahtm.jdField_b_of_type_AndroidWidgetRelativeLayout = null;
    }
  }
  
  private void a(ahtm paramahtm, BaseChatItemLayout paramBaseChatItemLayout, boolean paramBoolean1, StructMsgForGeneralShare paramStructMsgForGeneralShare, Resources paramResources, boolean paramBoolean2)
  {
    RelativeLayout localRelativeLayout = paramahtm.jdField_c_of_type_AndroidWidgetRelativeLayout;
    Object localObject = localRelativeLayout;
    if (localRelativeLayout == null)
    {
      localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramahtm.jdField_b_of_type_AndroidWidgetRelativeLayout = localRelativeLayout;
      localRelativeLayout.setId(2131378080);
      paramBaseChatItemLayout.addView(localRelativeLayout);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localRelativeLayout.getLayoutParams();
      localObject = localLayoutParams;
      if (localLayoutParams == null) {
        localObject = new RelativeLayout.LayoutParams(-2, -2);
      }
      ((RelativeLayout.LayoutParams)localObject).topMargin = (12 - agej.a(10.0F, paramResources));
      ((RelativeLayout.LayoutParams)localObject).addRule(5, 2131364423);
      ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131364423);
      localObject = localRelativeLayout;
    }
    paramResources = ((RelativeLayout)localObject).getChildAt(0);
    paramStructMsgForGeneralShare = paramStructMsgForGeneralShare.getAdSourceView(this.jdField_a_of_type_AndroidContentContext, paramResources, paramBaseChatItemLayout);
    if (paramStructMsgForGeneralShare != null)
    {
      ((RelativeLayout)localObject).addView(paramStructMsgForGeneralShare);
      paramahtm = (RelativeLayout.LayoutParams)paramStructMsgForGeneralShare.getLayoutParams();
      paramahtm.topMargin = zps.a(this.jdField_a_of_type_AndroidContentContext, 10.0F);
      paramahtm.height = -2;
      paramahtm.width = -2;
      return;
    }
    paramBaseChatItemLayout.removeView((View)localObject);
    paramahtm.jdField_b_of_type_AndroidWidgetRelativeLayout = null;
  }
  
  private void a(Activity paramActivity)
  {
    ReportDialog localReportDialog = new ReportDialog(paramActivity);
    localReportDialog.requestWindowFeature(1);
    localReportDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    View localView = LayoutInflater.from(paramActivity).inflate(2131559651, null);
    ((ImageView)localView.findViewById(2131368343)).setImageResource(2130839593);
    ((TextView)localView.findViewById(2131378617)).setText(anzj.a(2131713388));
    localReportDialog.setContentView(localView);
    localReportDialog.show();
    new Handler(paramActivity.getMainLooper()).postDelayed(new StructingMsgItemBuilder.23(this, localReportDialog), 1500L);
    this.g = false;
  }
  
  private void a(Activity paramActivity, View paramView, ChatMessage paramChatMessage)
  {
    String str = paramChatMessage.frienduin;
    AbsStructMsg localAbsStructMsg = ((MessageForStructing)paramChatMessage).structingMsg;
    ArrayList localArrayList1 = new ArrayList();
    Object localObject1 = localAbsStructMsg.adverKey;
    ArrayList localArrayList2 = new ArrayList();
    try
    {
      localObject1 = new JSONArray((String)localObject1);
      i = 0;
      if (i < ((JSONArray)localObject1).length())
      {
        JSONObject localJSONObject = (JSONObject)((JSONArray)localObject1).get(i);
        Object localObject2 = new bloo();
        ((bloo)localObject2).jdField_a_of_type_Int = i;
        ((bloo)localObject2).jdField_b_of_type_Int = 0;
        if (localJSONObject.has("show_name")) {}
        for (((bloo)localObject2).jdField_a_of_type_JavaLangString = localJSONObject.getString("show_name");; ((bloo)localObject2).jdField_a_of_type_JavaLangString = "")
        {
          localArrayList1.add(localObject2);
          localObject2 = new txw();
          ((txw)localObject2).jdField_a_of_type_JavaLangString = str;
          ((txw)localObject2).c = localJSONObject.optString("index");
          ((txw)localObject2).d = localJSONObject.optString("index_name");
          ((txw)localObject2).b = localJSONObject.optString("index_type");
          ((txw)localObject2).e = String.valueOf(nnr.a());
          localArrayList2.add(localObject2);
          i += 1;
          break;
        }
      }
      this.jdField_a_of_type_Blol = blol.a(paramActivity, localArrayList1, new ahsy(this, paramActivity, paramChatMessage, localAbsStructMsg, str, localArrayList2), new ahsz(this), agej.a(100.0F, paramActivity.getResources()));
    }
    catch (JSONException paramActivity)
    {
      paramActivity.printStackTrace();
      return;
    }
    int i = paramView.getWidth() * 7 / 2;
    this.jdField_a_of_type_Blol.showAsDropDown(paramView, 0 - i, 0);
    this.jdField_a_of_type_Blol.dismiss();
    paramActivity = new int[2];
    paramView.getLocationOnScreen(paramActivity);
    this.jdField_a_of_type_Blol.showAtLocation(paramView, 0, paramActivity[0], paramActivity[1] + paramView.getHeight());
    this.jdField_a_of_type_Blol.setOnDismissListener(new ahta(this));
  }
  
  private void a(View paramView, StructMsgForGeneralShare paramStructMsgForGeneralShare)
  {
    new bdos(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView).a(paramStructMsgForGeneralShare.mMsgAction, paramStructMsgForGeneralShare.mMsgUrl, paramStructMsgForGeneralShare.mMsgActionData, paramStructMsgForGeneralShare.mMsg_A_ActionData);
  }
  
  private void a(bhuk parambhuk, MessageForStructing paramMessageForStructing, AbsStructMsg paramAbsStructMsg)
  {
    if ((paramMessageForStructing.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramMessageForStructing)) && (b(paramMessageForStructing, paramAbsStructMsg))) {
      a(parambhuk, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramMessageForStructing);
    }
  }
  
  private void a(bhuk parambhuk, AbsStructMsg paramAbsStructMsg, Resources paramResources)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008) {
      if (!paramAbsStructMsg.hasFlag(32)) {
        parambhuk.a(2131367100, paramResources.getString(2131692400), 2130838939);
      }
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (paramAbsStructMsg.hasFlag(1));
        parambhuk.a(2131367078, paramResources.getString(2131692400), 2130838939);
        return;
      } while (paramAbsStructMsg.mMsgServiceID == 14);
      if (!paramAbsStructMsg.hasFlag(1))
      {
        parambhuk.a(2131367078, paramResources.getString(2131692400), 2130838939);
        return;
      }
    } while (paramAbsStructMsg.mMsgServiceID != 35);
    parambhuk.a(2131367078, paramResources.getString(2131692400), 2130838939);
  }
  
  private void a(bhvc parambhvc, ahtm paramahtm)
  {
    if (paramahtm.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
      return;
    }
    Object localObject;
    int i;
    if ((parambhvc instanceof berp))
    {
      localObject = (berp)parambhvc;
      i = (int)((berp)localObject).c();
      if ((i != 1004) || (!((berp)localObject).c()) || (!((berp)localObject).d())) {
        break label416;
      }
      i = 1006;
    }
    label416:
    for (;;)
    {
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(6, 2131378101);
      ((RelativeLayout.LayoutParams)localObject).addRule(8, 2131378101);
      ((RelativeLayout.LayoutParams)localObject).addRule(5, 2131378101);
      ((RelativeLayout.LayoutParams)localObject).addRule(7, 2131378101);
      if ((paramahtm.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (paramahtm.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131378087) == null) && (paramahtm.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView != null)) {
        paramahtm.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramahtm.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView, (ViewGroup.LayoutParams)localObject);
      }
      switch (i)
      {
      default: 
        if (paramahtm.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView == null) {
          break;
        }
        paramahtm.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setProcessor(null);
        paramahtm.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(8);
        return;
      case 1000: 
      case 1001: 
      case 1002: 
      case 1006: 
      case 4001: 
        if (paramahtm.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView == null)
        {
          MessageProgressTextView localMessageProgressTextView = new MessageProgressTextView(this.jdField_a_of_type_AndroidContentContext);
          localMessageProgressTextView.setTextColor(-1);
          localMessageProgressTextView.setTextSize(2, 15.0F);
          localMessageProgressTextView.setGravity(17);
          localMessageProgressTextView.setId(2131378087);
          localMessageProgressTextView.setBackgroundDrawable(new agxx(2130706432, this.jdField_b_of_type_Float * 12.0F));
          if (paramahtm.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
            paramahtm.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localMessageProgressTextView, (ViewGroup.LayoutParams)localObject);
          }
          paramahtm.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView = localMessageProgressTextView;
        }
        paramahtm.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setProcessor((berp)parambhvc);
        paramahtm.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(0);
        switch (i)
        {
        }
        for (;;)
        {
          paramahtm.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.a();
          return;
          paramahtm.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setProgress(0);
          return;
          paramahtm.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setProgress(0);
        }
        if (paramahtm.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView == null) {
          break;
        }
        paramahtm.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setProcessor(null);
        paramahtm.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(4);
        return;
      }
    }
  }
  
  private void a(BaseChatItemLayout paramBaseChatItemLayout, MessageForStructing paramMessageForStructing)
  {
    int i = ((StructMsgForGeneralShare)paramMessageForStructing.structingMsg).getProgress();
    if ((paramMessageForStructing.extraflag == 32772) && (i >= 0) && (i < 100))
    {
      aoju localaoju = (aoju)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(28);
      localaoju.a(bcsa.a(paramMessageForStructing.msgUid), paramMessageForStructing.frienduin, paramMessageForStructing.uniseq);
      paramMessageForStructing = new ahtg(this, paramMessageForStructing, paramBaseChatItemLayout);
      paramBaseChatItemLayout.setTag(2131379406, paramMessageForStructing);
      localaoju.a(paramBaseChatItemLayout, paramMessageForStructing);
    }
  }
  
  private void a(AbsShareMsg paramAbsShareMsg)
  {
    if (!this.jdField_b_of_type_JavaUtilList.contains(paramAbsShareMsg))
    {
      paramAbsShareMsg.report(Integer.valueOf(0));
      this.jdField_b_of_type_JavaUtilList.add(paramAbsShareMsg);
    }
  }
  
  private void a(AbsStructMsg paramAbsStructMsg, RelativeLayout paramRelativeLayout)
  {
    paramRelativeLayout.setVisibility(0);
    if ((paramAbsStructMsg.mMsgUrl != null) && ((paramAbsStructMsg.mMsgUrl.startsWith("https://3gimg.qq.com/wap30/infoopstatic")) || (paramAbsStructMsg.mMsgUrl.startsWith("https://viola.qq.com/js/redpackIndex.js"))) && ("1".equals(Uri.parse(paramAbsStructMsg.mMsgUrl).getQueryParameter("hidesource")))) {
      paramRelativeLayout.setVisibility(8);
    }
  }
  
  private void a(StructMsgForImageShare paramStructMsgForImageShare)
  {
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramStructMsgForImageShare))
    {
      paramStructMsgForImageShare.report(Long.valueOf(((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent().getLongExtra("req_share_id", 0L)));
      this.jdField_a_of_type_JavaUtilList.add(paramStructMsgForImageShare);
    }
  }
  
  private boolean a(bhuk parambhuk, MessageForStructing paramMessageForStructing, AbsStructMsg paramAbsStructMsg)
  {
    boolean bool2 = false;
    boolean bool1;
    if (((paramAbsStructMsg instanceof AbsShareMsg)) && (((AbsShareMsg)paramAbsStructMsg).mMsgException))
    {
      aean.a(parambhuk, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008) {
        super.c(parambhuk, this.jdField_a_of_type_AndroidContentContext);
      }
      super.e(parambhuk, this.jdField_a_of_type_AndroidContentContext);
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return bool1;
            if (paramAbsStructMsg.mMsgServiceID == 86)
            {
              aean.a(parambhuk, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
              super.e(parambhuk, this.jdField_a_of_type_AndroidContentContext);
              return true;
            }
            if (paramAbsStructMsg.mMsgServiceID == 61)
            {
              aean.a(parambhuk, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
              super.e(parambhuk, this.jdField_a_of_type_AndroidContentContext);
              return true;
            }
            if (paramAbsStructMsg.mMsgServiceID == 91)
            {
              aean.a(parambhuk, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
              super.e(parambhuk, this.jdField_a_of_type_AndroidContentContext);
              return true;
            }
            if (paramAbsStructMsg.mMsgServiceID == 97)
            {
              aean.a(parambhuk, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
              super.e(parambhuk, this.jdField_a_of_type_AndroidContentContext);
              return true;
            }
            if (paramAbsStructMsg.mMsgServiceID == 98)
            {
              aean.a(parambhuk, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
              super.e(parambhuk, this.jdField_a_of_type_AndroidContentContext);
              return true;
            }
            if (paramAbsStructMsg.mMsgServiceID == 128)
            {
              a(paramMessageForStructing, parambhuk);
              aean.a(parambhuk, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
              b(paramMessageForStructing, parambhuk);
              bhju.a("Grp_AIO", "invite", "send_in", 0, 0, new String[0]);
              return true;
            }
            if ((paramAbsStructMsg instanceof StructMsgForHypertext))
            {
              aean.a(parambhuk, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
              super.c(parambhuk, this.jdField_a_of_type_AndroidContentContext);
              super.e(parambhuk, this.jdField_a_of_type_AndroidContentContext);
              return true;
            }
            bool1 = bool2;
          } while (!paramMessageForStructing.isSendFromLocal());
          bool1 = bool2;
        } while (!(paramAbsStructMsg instanceof AbsShareMsg));
        bool1 = bool2;
      } while (!((AbsShareMsg)paramAbsStructMsg).isSdkShareMsg());
      if (paramMessageForStructing.extraflag == 32772) {
        break;
      }
      bool1 = bool2;
    } while (paramMessageForStructing.extraflag != 32768);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForStructing.frienduin, paramMessageForStructing.uniseq) != null) {
      parambhuk.a(2131364167, this.jdField_a_of_type_AndroidContentContext.getString(2131690638), 2130838928);
    }
    for (;;)
    {
      super.e(parambhuk, this.jdField_a_of_type_AndroidContentContext);
      return true;
      aean.a(parambhuk, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    }
  }
  
  private void b(Activity paramActivity)
  {
    ReportDialog localReportDialog = new ReportDialog(paramActivity);
    localReportDialog.requestWindowFeature(1);
    localReportDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    View localView = LayoutInflater.from(paramActivity).inflate(2131559651, null);
    ((ImageView)localView.findViewById(2131368343)).setImageResource(2130839580);
    ((TextView)localView.findViewById(2131378617)).setText(anzj.a(2131713387));
    localReportDialog.setContentView(localView);
    localReportDialog.show();
    new Handler(paramActivity.getMainLooper()).postDelayed(new StructingMsgItemBuilder.24(this, localReportDialog), 1500L);
    this.g = false;
  }
  
  private void b(Activity paramActivity, View paramView, ChatMessage paramChatMessage)
  {
    ArrayList localArrayList = new ArrayList();
    AbsStructMsg localAbsStructMsg = ((MessageForStructing)paramChatMessage).structingMsg;
    Object localObject = localAbsStructMsg.adverKey;
    for (;;)
    {
      try
      {
        localObject = new JSONArray((String)localObject);
        i = 0;
        if (i >= ((JSONArray)localObject).length()) {
          break;
        }
        JSONObject localJSONObject = (JSONObject)((JSONArray)localObject).get(i);
        bloo localbloo = new bloo();
        if (localJSONObject.has("index"))
        {
          localbloo.jdField_a_of_type_Int = localJSONObject.getInt("index");
          localbloo.jdField_b_of_type_Int = 0;
          if (localJSONObject.has("show_name"))
          {
            localbloo.jdField_a_of_type_JavaLangString = localJSONObject.getString("show_name");
            localArrayList.add(localbloo);
            i += 1;
          }
        }
        else
        {
          localbloo.jdField_a_of_type_Int = i;
          continue;
        }
        localbloo.jdField_a_of_type_JavaLangString = "";
      }
      catch (JSONException paramActivity)
      {
        paramActivity.printStackTrace();
        return;
      }
    }
    this.jdField_a_of_type_Blol = blol.a(paramActivity, localArrayList, new ahtc(this, paramChatMessage, paramActivity, localAbsStructMsg), new ahte(this), agej.a(100.0F, paramActivity.getResources()));
    int i = paramView.getWidth() * -5 / 7;
    this.jdField_a_of_type_Blol.showAsDropDown(paramView, i, 0);
    this.jdField_a_of_type_Blol.dismiss();
    paramActivity = new int[2];
    paramView.getLocationOnScreen(paramActivity);
    this.jdField_a_of_type_Blol.showAtLocation(paramView, 0, paramActivity[0], paramActivity[1] + paramView.getHeight());
    this.jdField_a_of_type_Blol.setOnDismissListener(new ahtf(this));
  }
  
  private static void b(String paramString, URL paramURL, ThumbWidthHeightDP paramThumbWidthHeightDP)
  {
    CompressInfo localCompressInfo = new CompressInfo(paramString, 0);
    localCompressInfo.f = true;
    paramString = beqz.d(paramURL.toString());
    QLog.d("StructingMsgItemBuilder", 1, new Object[] { "generateHdPic hdThumbFilePath=", paramString });
    if (!paramString.endsWith("_hd"))
    {
      if (!paramString.endsWith("_big400")) {
        break label136;
      }
      paramString.replace("_big400", "_hd");
    }
    while (new File(paramString).exists())
    {
      QLog.d("StructingMsgItemBuilder", 1, "hd image exists, no need compress");
      paramString = URLDrawable.getDrawable(paramURL);
      if (paramString != null)
      {
        QLog.d("StructingMsgItemBuilder", 1, "hd image invalidateSelf");
        ThreadManager.getUIHandler().post(new StructingMsgItemBuilder.15(paramString));
      }
      return;
      label136:
      paramString = paramString + "_hd";
    }
    localCompressInfo.e = paramString;
    for (;;)
    {
      try
      {
        new File(paramString).getParentFile().mkdirs();
        localCompressInfo.a = paramThumbWidthHeightDP;
        if (azrm.b(localCompressInfo))
        {
          paramThumbWidthHeightDP = "hd image compress success";
          QLog.d("StructingMsgItemBuilder", 1, paramThumbWidthHeightDP);
          if (localCompressInfo.e == null) {
            break;
          }
          paramString = new File(paramString);
          if (!localCompressInfo.e.equals(localCompressInfo.c)) {
            break label392;
          }
          bool = auog.a(new File(localCompressInfo.c), paramString);
          QLog.d("StructingMsgItemBuilder", 1, new Object[] { "ret=", Boolean.valueOf(bool), ", thumbCI.destPath=", localCompressInfo.e, ", thumbCI.srcPath=", localCompressInfo.c });
          if ((!bool) || (BaseApplicationImpl.sImageCache.get(paramURL.toString()) == null)) {
            break;
          }
          BaseApplicationImpl.sImageCache.remove(paramURL.toString());
          paramString = URLDrawable.getDrawable(paramURL);
          if (paramString == null) {
            break;
          }
          QLog.d("StructingMsgItemBuilder", 1, "hd image invalidateSelf");
          ThreadManager.getUIHandler().post(new StructingMsgItemBuilder.16(paramString));
          return;
        }
      }
      catch (Exception paramString)
      {
        QLog.d("StructingMsgItemBuilder", 1, "hd image file parent create fail");
        return;
      }
      paramThumbWidthHeightDP = "hd image compress fail";
      continue;
      label392:
      boolean bool = true;
    }
  }
  
  private boolean b(MessageForStructing paramMessageForStructing)
  {
    return (paramMessageForStructing.isSendFromLocal()) && (paramMessageForStructing.extraflag == 32772) && (paramMessageForStructing.structingMsg != null) && ((paramMessageForStructing.structingMsg instanceof AbsShareMsg)) && (((AbsShareMsg)paramMessageForStructing.structingMsg).isSdkShareMsg()) && (!((AbsShareMsg)paramMessageForStructing.structingMsg).shareData.isFinish());
  }
  
  private boolean b(AbsStructMsg paramAbsStructMsg)
  {
    return 19 == paramAbsStructMsg.mMsgServiceID;
  }
  
  private boolean c(ChatMessage paramChatMessage)
  {
    if (!(paramChatMessage instanceof MessageForStructing)) {}
    do
    {
      return false;
      paramChatMessage = ((MessageForStructing)paramChatMessage).structingMsg;
    } while (!(paramChatMessage instanceof StructMsgForImageShare));
    paramChatMessage = ((StructMsgForImageShare)paramChatMessage).getFirstImageElement();
    if ((paramChatMessage != null) && (paramChatMessage.a())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private static boolean d(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {}
    for (;;)
    {
      return false;
      paramChatMessage = (MessageForStructing)paramChatMessage;
      if ((paramChatMessage.structingMsg instanceof StructMsgForGeneralShare))
      {
        paramChatMessage = (StructMsgForGeneralShare)paramChatMessage.structingMsg;
        int i = 0;
        while (i < paramChatMessage.getItemCount())
        {
          if ((paramChatMessage.getItemByIndex(i) instanceof bdrd)) {
            return true;
          }
          i += 1;
        }
      }
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public aggk a(View paramView)
  {
    try
    {
      ChatMessage localChatMessage = agej.a(paramView);
      if (!(localChatMessage instanceof MessageForStructing)) {
        return null;
      }
    }
    catch (Exception localException)
    {
      do
      {
        for (;;)
        {
          QLog.e("StructingMsgItemBuilder", 1, paramView.getClass().getName(), localException);
          localObject = null;
        }
        localObject = (MessageForStructing)localObject;
        if ((((MessageForStructing)localObject).structingMsg != null) && ((((MessageForStructing)localObject).structingMsg.mMsgServiceID == 5) || (((MessageForStructing)localObject).structingMsg.mMsgServiceID == 137))) {
          return (aggk)paramView.findViewById(2131368523);
        }
      } while ((((MessageForStructing)localObject).structingMsg == null) || (((MessageForStructing)localObject).structingMsg.mMsgServiceID != 107));
      Object localObject = paramView.findViewById(2131376244);
      if (localObject != null) {
        return (aggk)((View)localObject).getTag(-1);
      }
      paramView = "getTouchDelegate when receipt message but the root view is null \r\n" + paramView;
      bdkh.a(new IllegalStateException(paramView), "StructingMsgItemBuilderCatchedException" + paramView);
    }
    return null;
  }
  
  protected ahtm a()
  {
    return new ahtm();
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, agjk paramagjk)
  {
    this.jdField_a_of_type_Bdqe.a();
    if (paramView == null) {}
    MessageForStructing localMessageForStructing;
    AbsStructMsg localAbsStructMsg;
    for (int i = 1;; i = 2)
    {
      localMessageForStructing = (MessageForStructing)paramChatMessage;
      localAbsStructMsg = null;
      if (localMessageForStructing != null) {
        localAbsStructMsg = localMessageForStructing.structingMsg;
      }
      if ((localAbsStructMsg != null) && (localAbsStructMsg.mMsgServiceID == 81)) {
        yup.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, localMessageForStructing, "exp");
      }
      if ((localAbsStructMsg != null) && ((localAbsStructMsg instanceof StructMsgForGeneralShare)) && (!((StructMsgForGeneralShare)localAbsStructMsg).havaPayInfoInit))
      {
        localObject = paramChatMessage.getExtInfoFromExtStr("pa_pay_message");
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals("1"))) {
          ((StructMsgForGeneralShare)localAbsStructMsg).initPay(this.jdField_a_of_type_AndroidContentContext, paramChatMessage);
        }
      }
      if (localAbsStructMsg != null) {
        break;
      }
      return paramView;
    }
    int k = -1;
    int j = k;
    if (paramView != null)
    {
      j = k;
      if ((paramView.getTag() instanceof aggl))
      {
        localObject = (aggl)paramView.getTag();
        j = k;
        if (localObject != null) {
          j = ((aggl)localObject).jdField_b_of_type_Int;
        }
      }
    }
    localAbsStructMsg.message = localMessageForStructing;
    paramagjk = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramagjk);
    if (localAbsStructMsg.mMsgServiceID == 76)
    {
      paramInt2 = agej.a(11.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      k = agej.a(7.5F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramagjk.setPadding(0, 0, 0, 0);
      paramView = (aggl)paramagjk.getTag();
      paramView.jdField_a_of_type_AndroidViewView.setPadding(0, 0, 0, 0);
      ((RelativeLayout.LayoutParams)paramView.jdField_a_of_type_AndroidViewView.getLayoutParams()).setMargins(paramInt2, k, paramInt2, k);
    }
    if (localAbsStructMsg.mMsgServiceID == 35)
    {
      paramView = (aggl)paramagjk.getTag();
      paramView.jdField_a_of_type_AndroidViewView.setPadding(paramView.jdField_a_of_type_AndroidViewView.getPaddingLeft(), 0, paramView.jdField_a_of_type_AndroidViewView.getPaddingRight(), 0);
    }
    Object localObject = (ahtm)paramagjk.getTag();
    BaseChatItemLayout localBaseChatItemLayout = ((ahtm)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
    if (((i == 1) || (j != ((ahtm)localObject).jdField_b_of_type_Int)) && (localAbsStructMsg.mMsgServiceID == 128)) {
      bhju.a("Grp_AIO", "invite", "send_exp", 0, 0, new String[] { String.valueOf(localAbsStructMsg.uniseq) });
    }
    label648:
    int m;
    if ((localAbsStructMsg instanceof AbsShareMsg))
    {
      paramInt2 = ((AbsShareMsg)localAbsStructMsg).mContentLayout;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1008) && (localAbsStructMsg.hasFlag(4))) {
        localAbsStructMsg.addFlag(1);
      }
      Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
      boolean bool = a(localMessageForStructing);
      if (QLog.isDevelopLevel()) {
        QLog.d("StructingMsgItemBuilder", 4, "getView:position:" + paramInt1 + "hasHead" + bool);
      }
      a((ahtm)localObject, localBaseChatItemLayout, bool);
      a((ahtm)localObject, localBaseChatItemLayout, localMessageForStructing.isSend(), localAbsStructMsg, localResources, bool);
      if (((localAbsStructMsg instanceof StructMsgForGeneralShare)) && (((StructMsgForGeneralShare)localAbsStructMsg).mHasAdSource)) {
        a((ahtm)localObject, localBaseChatItemLayout, localMessageForStructing.isSend(), (StructMsgForGeneralShare)localAbsStructMsg, localResources, bool);
      }
      if ((localObject != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
      {
        paramViewGroup = null;
        if ((((ahtm)localObject).jdField_c_of_type_AndroidWidgetRelativeLayout == null) || (((ahtm)localObject).jdField_c_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0)) {
          break label1101;
        }
        paramView = Integer.valueOf(2131378080);
        ((ahtm)localObject).jdField_c_of_type_AndroidViewView = super.a(((ahtm)localObject).jdField_c_of_type_AndroidViewView, (aggl)localObject, localBaseChatItemLayout, paramChatMessage, -2, bhgr.a(this.jdField_a_of_type_AndroidContentContext, 21.0F));
        super.a(((ahtm)localObject).jdField_c_of_type_AndroidViewView, localBaseChatItemLayout, paramView, paramChatMessage, -4, Boolean.valueOf(true));
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008) || (localMessageForStructing.structingMsg.mMsgServiceID == 76) || (localMessageForStructing.structingMsg.mMsgServiceID == 21))
      {
        k = localResources.getDimensionPixelSize(2131298911);
        m = localResources.getDimensionPixelSize(2131298911);
        if ((!BaseChatItemLayout.jdField_a_of_type_Boolean) || (!bool)) {
          break label1138;
        }
        paramInt1 = 1;
        label771:
        paramView = AIOLongShotHelper.a();
        j = paramInt1;
        if (paramView != null)
        {
          j = paramInt1;
          if (paramView.a()) {
            j = 0;
          }
        }
        paramInt1 = k;
        if (j != 0)
        {
          j = agej.a(30.0F, localResources);
          paramInt1 = j;
          if (localBaseChatItemLayout.jdField_a_of_type_AndroidWidgetCheckBox != null)
          {
            paramView = (RelativeLayout.LayoutParams)localBaseChatItemLayout.jdField_a_of_type_AndroidWidgetCheckBox.getLayoutParams();
            paramInt1 = j;
            if (paramView != null)
            {
              paramView.leftMargin = agej.a(5.0F, localResources);
              paramInt1 = j;
            }
          }
        }
        paramView = (RelativeLayout.LayoutParams)((RelativeLayout)((BaseChatItemLayout)paramagjk).b()).getLayoutParams();
        if (paramView != null)
        {
          if (localMessageForStructing.structingMsg.mMsgServiceID == 21) {
            break label1143;
          }
          paramView.setMargins(paramInt1, 0, m, 0);
        }
      }
    }
    for (;;)
    {
      paramagjk.requestLayout();
      if ((localObject != null) && (((ahtm)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage == paramChatMessage) && (localAbsStructMsg.hasFlag(16))) {
        ThreadManager.post(new StructingMsgItemBuilder.5(this, (ahtm)localObject), 2, null, false);
      }
      paramView = (bgre)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(132);
      if (paramView.b(paramChatMessage))
      {
        paramView.a(paramChatMessage.uniseq);
        ((ahtm)localObject).jdField_a_of_type_AndroidViewView.setVisibility(8);
        paramView = AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidContentContext, 2130772211);
        paramView.setAnimationListener(new ahtk(this, (ahtm)localObject));
        ((ahtm)localObject).jdField_a_of_type_AndroidViewView.postDelayed(new StructingMsgItemBuilder.7(this, (ahtm)localObject, paramView), 300L);
      }
      this.jdField_a_of_type_Bdqe.a(paramInt2, i);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && ("3046055438".equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
        oer.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, paramagjk);
      }
      return paramagjk;
      paramInt2 = -1;
      break;
      label1101:
      paramView = paramViewGroup;
      if (((ahtm)localObject).jdField_b_of_type_AndroidWidgetRelativeLayout == null) {
        break label648;
      }
      paramView = paramViewGroup;
      if (((ahtm)localObject).jdField_b_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0) {
        break label648;
      }
      paramView = Integer.valueOf(2131378081);
      break label648;
      label1138:
      paramInt1 = 0;
      break label771;
      label1143:
      paramView.setMargins(paramInt1, paramView.topMargin, m, paramView.bottomMargin);
    }
  }
  
  /* Error */
  public View a(ChatMessage paramChatMessage, aggl paramaggl, View paramView, BaseChatItemLayout paramBaseChatItemLayout, agjk paramagjk)
  {
    // Byte code:
    //   0: new 1199	android/os/Bundle
    //   3: dup
    //   4: invokespecial 1200	android/os/Bundle:<init>	()V
    //   7: astore 15
    //   9: aload_0
    //   10: getfield 92	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   13: instanceof 94
    //   16: ifne +13 -> 29
    //   19: aload_0
    //   20: getfield 92	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   23: instanceof 96
    //   26: ifeq +2862 -> 2888
    //   29: aload_0
    //   30: getfield 92	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   33: checkcast 1202	android/support/v4/app/FragmentActivity
    //   36: invokevirtual 1206	android/support/v4/app/FragmentActivity:getChatFragment	()Lcom/tencent/mobileqq/activity/ChatFragment;
    //   39: invokevirtual 1211	com/tencent/mobileqq/activity/ChatFragment:a	()Lcom/tencent/mobileqq/activity/BaseChatPie;
    //   42: invokevirtual 1216	com/tencent/mobileqq/activity/BaseChatPie:a	()Lahtn;
    //   45: astore 10
    //   47: aload_3
    //   48: ifnonnull +130 -> 178
    //   51: aload_0
    //   52: getfield 92	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   55: invokevirtual 48	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   58: astore 9
    //   60: new 167	android/widget/RelativeLayout
    //   63: dup
    //   64: aload_0
    //   65: getfield 92	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   68: invokespecial 180	android/widget/RelativeLayout:<init>	(Landroid/content/Context;)V
    //   71: astore_3
    //   72: aload_3
    //   73: ldc 210
    //   75: invokevirtual 184	android/widget/RelativeLayout:setId	(I)V
    //   78: aload_3
    //   79: ldc_w 1217
    //   82: aload 9
    //   84: invokestatic 203	agej:a	(FLandroid/content/res/Resources;)I
    //   87: invokevirtual 1220	android/widget/RelativeLayout:setMinimumHeight	(I)V
    //   90: aload_3
    //   91: iconst_1
    //   92: invokevirtual 1223	android/widget/RelativeLayout:setClickable	(Z)V
    //   95: aload_3
    //   96: getstatic 1226	com/tencent/mobileqq/activity/aio/BaseChatItemLayout:j	I
    //   99: getstatic 1228	com/tencent/mobileqq/activity/aio/BaseChatItemLayout:h	I
    //   102: getstatic 1231	com/tencent/mobileqq/activity/aio/BaseChatItemLayout:k	I
    //   105: getstatic 1234	com/tencent/mobileqq/activity/aio/BaseChatItemLayout:i	I
    //   108: invokevirtual 174	android/widget/RelativeLayout:setPadding	(IIII)V
    //   111: aload_3
    //   112: ldc_w 1235
    //   115: invokevirtual 1236	android/widget/RelativeLayout:setBackgroundResource	(I)V
    //   118: new 194	android/widget/RelativeLayout$LayoutParams
    //   121: dup
    //   122: bipush 254
    //   124: bipush 254
    //   126: invokespecial 197	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   129: astore 11
    //   131: aload 9
    //   133: ldc_w 1114
    //   136: invokevirtual 1118	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   139: istore 6
    //   141: aload 11
    //   143: iload 6
    //   145: iconst_0
    //   146: iload 6
    //   148: iconst_0
    //   149: invokevirtual 1051	android/widget/RelativeLayout$LayoutParams:setMargins	(IIII)V
    //   152: aload 11
    //   154: iconst_1
    //   155: ldc_w 1237
    //   158: invokevirtual 213	android/widget/RelativeLayout$LayoutParams:addRule	(II)V
    //   161: aload_3
    //   162: aload 11
    //   164: invokevirtual 217	android/widget/RelativeLayout:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   167: ldc 69
    //   169: aload_1
    //   170: invokevirtual 1240	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   173: ifne +30 -> 203
    //   176: aload_3
    //   177: areturn
    //   178: aload_3
    //   179: instanceof 1242
    //   182: ifeq +18 -> 200
    //   185: aload_0
    //   186: aload_1
    //   187: invokespecial 1244	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:c	(Lcom/tencent/mobileqq/data/ChatMessage;)Z
    //   190: ifne +10 -> 200
    //   193: aload_3
    //   194: checkcast 1242	android/view/ViewGroup
    //   197: invokevirtual 1245	android/view/ViewGroup:removeAllViews	()V
    //   200: goto -33 -> 167
    //   203: aload_2
    //   204: getfield 1246	aggl:jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout	Lcom/tencent/mobileqq/activity/aio/BaseChatItemLayout;
    //   207: aload_0
    //   208: invokevirtual 1250	com/tencent/mobileqq/activity/aio/BaseChatItemLayout:setMiniAioShieldItemTouchListener	(Laggp;)V
    //   211: aload_1
    //   212: checkcast 69	com/tencent/mobileqq/data/MessageForStructing
    //   215: astore 13
    //   217: aload 13
    //   219: getfield 73	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   222: astore 14
    //   224: aload 14
    //   226: ifnonnull +76 -> 302
    //   229: invokestatic 231	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   232: ifeq -56 -> 176
    //   235: new 235	java/lang/StringBuilder
    //   238: dup
    //   239: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   242: ldc_w 1252
    //   245: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: astore_2
    //   249: aload 13
    //   251: ifnonnull +23 -> 274
    //   254: ldc_w 1254
    //   257: astore_1
    //   258: ldc 233
    //   260: iconst_2
    //   261: aload_2
    //   262: aload_1
    //   263: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   266: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   269: invokestatic 251	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   272: aload_3
    //   273: areturn
    //   274: aload 13
    //   276: getfield 1258	com/tencent/mobileqq/data/MessageForStructing:msgData	[B
    //   279: ifnonnull +10 -> 289
    //   282: ldc_w 1254
    //   285: astore_1
    //   286: goto -28 -> 258
    //   289: aload 13
    //   291: getfield 1258	com/tencent/mobileqq/data/MessageForStructing:msgData	[B
    //   294: arraylength
    //   295: invokestatic 691	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   298: astore_1
    //   299: goto -41 -> 258
    //   302: aload 14
    //   304: aload 13
    //   306: putfield 1042	com/tencent/mobileqq/structmsg/AbsStructMsg:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   309: aload_0
    //   310: getfield 124	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   313: ifnull +242 -> 555
    //   316: aload_0
    //   317: getfield 124	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   320: getfield 574	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_Int	I
    //   323: sipush 1008
    //   326: if_icmpne +229 -> 555
    //   329: aload 14
    //   331: instanceof 75
    //   334: ifeq +39 -> 373
    //   337: aload 14
    //   339: checkcast 75	com/tencent/mobileqq/structmsg/StructMsgForGeneralShare
    //   342: astore_2
    //   343: aload 15
    //   345: ldc_w 1260
    //   348: aload_0
    //   349: getfield 124	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   352: getfield 128	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   355: invokevirtual 1264	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   358: aload 15
    //   360: ldc_w 1266
    //   363: aload_0
    //   364: getfield 124	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   367: getfield 1267	com/tencent/mobileqq/activity/aio/SessionInfo:d	Ljava/lang/String;
    //   370: invokevirtual 1264	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   373: aload 15
    //   375: ldc_w 1269
    //   378: iconst_1
    //   379: invokevirtual 1273	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   382: aload_1
    //   383: ldc_w 1275
    //   386: invokevirtual 1028	com/tencent/mobileqq/data/ChatMessage:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   389: astore_2
    //   390: aload_2
    //   391: ifnull +164 -> 555
    //   394: aload_2
    //   395: ldc_w 488
    //   398: invokevirtual 722	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   401: ifne +154 -> 555
    //   404: aload_2
    //   405: invokestatic 305	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   408: ifne +9 -> 417
    //   411: aload 14
    //   413: aload_2
    //   414: putfield 1278	com/tencent/mobileqq/structmsg/AbsStructMsg:templateIDForPortal	Ljava/lang/String;
    //   417: aload 14
    //   419: instanceof 693
    //   422: ifeq +133 -> 555
    //   425: aload 14
    //   427: checkcast 693	com/tencent/mobileqq/structmsg/AbsShareMsg
    //   430: invokevirtual 1282	com/tencent/mobileqq/structmsg/AbsShareMsg:getStructMsgItemLists	()Ljava/util/List;
    //   433: astore 9
    //   435: aload 9
    //   437: ifnull +118 -> 555
    //   440: aload 9
    //   442: invokeinterface 1286 1 0
    //   447: astore 9
    //   449: aload 9
    //   451: invokeinterface 1291 1 0
    //   456: ifeq +99 -> 555
    //   459: aload 9
    //   461: invokeinterface 1294 1 0
    //   466: checkcast 1296	bdol
    //   469: astore 11
    //   471: aload_2
    //   472: invokestatic 305	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   475: ifne +9 -> 484
    //   478: aload 11
    //   480: aload_2
    //   481: putfield 1298	bdol:Z	Ljava/lang/String;
    //   484: aload 11
    //   486: instanceof 1300
    //   489: ifeq -40 -> 449
    //   492: aload 11
    //   494: checkcast 1300	bdom
    //   497: astore 11
    //   499: aload 11
    //   501: getfield 1303	bdom:a	Ljava/util/ArrayList;
    //   504: ifnull -55 -> 449
    //   507: aload 11
    //   509: getfield 1303	bdom:a	Ljava/util/ArrayList;
    //   512: invokevirtual 1304	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   515: astore 11
    //   517: aload 11
    //   519: invokeinterface 1291 1 0
    //   524: ifeq -75 -> 449
    //   527: aload 11
    //   529: invokeinterface 1294 1 0
    //   534: checkcast 1296	bdol
    //   537: astore 12
    //   539: aload_2
    //   540: invokestatic 305	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   543: ifne -26 -> 517
    //   546: aload 12
    //   548: aload_2
    //   549: putfield 1298	bdol:Z	Ljava/lang/String;
    //   552: goto -35 -> 517
    //   555: aload 14
    //   557: aload 13
    //   559: getfield 660	com/tencent/mobileqq/data/MessageForStructing:uniseq	J
    //   562: putfield 1062	com/tencent/mobileqq/structmsg/AbsStructMsg:uniseq	J
    //   565: aload 14
    //   567: aload 13
    //   569: getfield 657	com/tencent/mobileqq/data/MessageForStructing:frienduin	Ljava/lang/String;
    //   572: putfield 1307	com/tencent/mobileqq/structmsg/AbsStructMsg:uin	Ljava/lang/String;
    //   575: aload 14
    //   577: aload 13
    //   579: getfield 1310	com/tencent/mobileqq/data/MessageForStructing:istroop	I
    //   582: putfield 1313	com/tencent/mobileqq/structmsg/AbsStructMsg:uinType	I
    //   585: aload 14
    //   587: aload 13
    //   589: getfield 1316	com/tencent/mobileqq/data/MessageForStructing:selfuin	Ljava/lang/String;
    //   592: putfield 1319	com/tencent/mobileqq/structmsg/AbsStructMsg:currentAccountUin	Ljava/lang/String;
    //   595: aload 14
    //   597: aload 13
    //   599: getfield 1322	com/tencent/mobileqq/data/MessageForStructing:versionCode	I
    //   602: putfield 1325	com/tencent/mobileqq/structmsg/AbsStructMsg:messageVersion	I
    //   605: aload 15
    //   607: ldc_w 1326
    //   610: aload 13
    //   612: invokevirtual 1091	com/tencent/mobileqq/data/MessageForStructing:isSend	()Z
    //   615: invokevirtual 1273	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   618: aload 14
    //   620: getfield 1313	com/tencent/mobileqq/structmsg/AbsStructMsg:uinType	I
    //   623: sipush 1008
    //   626: if_icmpne +1400 -> 2026
    //   629: aload 14
    //   631: getstatic 1329	com/tencent/mobileqq/structmsg/AbsStructMsg:SOURCE_ACCOUNT_TYPE_PA	I
    //   634: putfield 1332	com/tencent/mobileqq/structmsg/AbsStructMsg:sourceAccoutType	I
    //   637: aload 15
    //   639: ldc_w 1334
    //   642: aload 14
    //   644: getfield 1332	com/tencent/mobileqq/structmsg/AbsStructMsg:sourceAccoutType	I
    //   647: invokevirtual 1337	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   650: aload 14
    //   652: getfield 296	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgServiceID	I
    //   655: bipush 21
    //   657: if_icmpne +16 -> 673
    //   660: aload 15
    //   662: ldc_w 1339
    //   665: aload 14
    //   667: getfield 296	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgServiceID	I
    //   670: invokevirtual 1337	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   673: ldc_w 742
    //   676: aload 14
    //   678: invokevirtual 1240	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   681: ifeq +36 -> 717
    //   684: aload 14
    //   686: checkcast 742	com/tencent/mobileqq/structmsg/StructMsgForImageShare
    //   689: astore_2
    //   690: aload_2
    //   691: aload 13
    //   693: getfield 1342	com/tencent/mobileqq/data/MessageForStructing:issend	I
    //   696: putfield 1345	com/tencent/mobileqq/structmsg/StructMsgForImageShare:mIsSend	I
    //   699: aload_2
    //   700: aload 13
    //   702: getfield 660	com/tencent/mobileqq/data/MessageForStructing:uniseq	J
    //   705: putfield 1348	com/tencent/mobileqq/structmsg/StructMsgForImageShare:mUniseq	J
    //   708: aload_2
    //   709: aload 13
    //   711: getfield 1351	com/tencent/mobileqq/data/MessageForStructing:msgtype	I
    //   714: putfield 1354	com/tencent/mobileqq/structmsg/StructMsgForImageShare:mMsgType	I
    //   717: aload 4
    //   719: iconst_0
    //   720: invokevirtual 1357	com/tencent/mobileqq/activity/aio/BaseChatItemLayout:setAddStatesFromChildren	(Z)V
    //   723: aload 4
    //   725: invokevirtual 1358	com/tencent/mobileqq/activity/aio/BaseChatItemLayout:getTag	()Ljava/lang/Object;
    //   728: astore_2
    //   729: aload_2
    //   730: ifnull +2153 -> 2883
    //   733: aload_2
    //   734: instanceof 152
    //   737: ifeq +2146 -> 2883
    //   740: aload_2
    //   741: checkcast 152	ahtm
    //   744: astore_2
    //   745: aload_2
    //   746: ifnonnull +2131 -> 2877
    //   749: aload_0
    //   750: invokevirtual 1010	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:a	()Lahtm;
    //   753: astore 9
    //   755: aload 9
    //   757: aload_0
    //   758: getfield 124	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   761: putfield 1359	ahtm:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   764: aload 9
    //   766: getfield 165	ahtm:jdField_a_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   769: astore_2
    //   770: aload_2
    //   771: astore 11
    //   773: aload_2
    //   774: ifnonnull +27 -> 801
    //   777: aload_3
    //   778: checkcast 167	android/widget/RelativeLayout
    //   781: astore 11
    //   783: aload 9
    //   785: aload 11
    //   787: putfield 165	ahtm:jdField_a_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   790: aload 9
    //   792: getfield 165	ahtm:jdField_a_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   795: ldc_w 1360
    //   798: invokevirtual 184	android/widget/RelativeLayout:setId	(I)V
    //   801: aconst_null
    //   802: astore_2
    //   803: aload_3
    //   804: aload 9
    //   806: invokevirtual 1362	android/view/View:setTag	(Ljava/lang/Object;)V
    //   809: aload_1
    //   810: invokestatic 1364	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:d	(Lcom/tencent/mobileqq/data/ChatMessage;)Z
    //   813: ifeq +1252 -> 2065
    //   816: aload 9
    //   818: iconst_1
    //   819: putfield 1365	ahtm:jdField_a_of_type_Boolean	Z
    //   822: aload 14
    //   824: instanceof 75
    //   827: ifeq +1353 -> 2180
    //   830: aload 14
    //   832: getfield 1368	com/tencent/mobileqq/structmsg/AbsStructMsg:mSType	Ljava/lang/String;
    //   835: ifnull +16 -> 851
    //   838: aload 15
    //   840: ldc_w 1370
    //   843: aload 14
    //   845: getfield 1368	com/tencent/mobileqq/structmsg/AbsStructMsg:mSType	Ljava/lang/String;
    //   848: invokevirtual 1264	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   851: aload_1
    //   852: invokestatic 1373	com/tencent/mobileqq/transfile/StructLongMessageDownloadProcessor:b	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   855: ifne +10 -> 865
    //   858: aload_1
    //   859: invokestatic 1375	com/tencent/mobileqq/transfile/StructLongMessageDownloadProcessor:d	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   862: ifeq +22 -> 884
    //   865: aload 15
    //   867: ldc_w 1377
    //   870: aload 13
    //   872: ldc_w 1379
    //   875: invokevirtual 1380	com/tencent/mobileqq/data/MessageForStructing:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   878: invokestatic 1383	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   881: invokevirtual 1337	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   884: aload 14
    //   886: checkcast 75	com/tencent/mobileqq/structmsg/StructMsgForGeneralShare
    //   889: invokevirtual 1386	com/tencent/mobileqq/structmsg/StructMsgForGeneralShare:getLayoutStr	()Ljava/lang/String;
    //   892: astore 12
    //   894: aload 12
    //   896: astore_2
    //   897: aload_0
    //   898: aload 14
    //   900: getfield 296	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgServiceID	I
    //   903: invokevirtual 1388	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:a	(I)Z
    //   906: ifeq +27 -> 933
    //   909: new 235	java/lang/StringBuilder
    //   912: dup
    //   913: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   916: aload 12
    //   918: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   921: aload 13
    //   923: getfield 1342	com/tencent/mobileqq/data/MessageForStructing:issend	I
    //   926: invokevirtual 1081	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   929: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   932: astore_2
    //   933: aload_0
    //   934: getfield 124	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   937: ifnull +1937 -> 2874
    //   940: aload_0
    //   941: getfield 124	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   944: getfield 574	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_Int	I
    //   947: sipush 1008
    //   950: if_icmpne +1924 -> 2874
    //   953: ldc_w 1390
    //   956: aload_0
    //   957: getfield 124	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   960: getfield 128	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   963: invokevirtual 722	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   966: ifeq +1908 -> 2874
    //   969: aload_0
    //   970: getfield 92	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   973: checkcast 112	com/tencent/mobileqq/app/BaseActivity
    //   976: getfield 1393	com/tencent/mobileqq/app/BaseActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   979: sipush 341
    //   982: invokevirtual 105	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   985: checkcast 1395	akxs
    //   988: invokevirtual 1396	akxs:a	()Z
    //   991: ifne +1883 -> 2874
    //   994: aload 15
    //   996: ldc_w 1398
    //   999: aload_1
    //   1000: getfield 1400	com/tencent/mobileqq/data/ChatMessage:isShowQWalletPubAd	Z
    //   1003: invokevirtual 1273	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   1006: new 235	java/lang/StringBuilder
    //   1009: dup
    //   1010: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   1013: aload_2
    //   1014: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1017: aload_1
    //   1018: getfield 1400	com/tencent/mobileqq/data/ChatMessage:isShowQWalletPubAd	Z
    //   1021: invokevirtual 1086	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1024: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1027: astore 12
    //   1029: aload 12
    //   1031: astore_2
    //   1032: aload_2
    //   1033: astore 12
    //   1035: aconst_null
    //   1036: astore_2
    //   1037: aload 10
    //   1039: ifnull +15 -> 1054
    //   1042: aload 10
    //   1044: aload 12
    //   1046: aload_3
    //   1047: checkcast 1242	android/view/ViewGroup
    //   1050: invokevirtual 1405	ahtn:a	(Ljava/lang/String;Landroid/view/ViewGroup;)Landroid/view/View;
    //   1053: astore_2
    //   1054: aload_2
    //   1055: ifnull +1058 -> 2113
    //   1058: aload 14
    //   1060: getfield 296	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgServiceID	I
    //   1063: bipush 61
    //   1065: if_icmpne +1030 -> 2095
    //   1068: aload_0
    //   1069: getfield 92	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1072: aload_2
    //   1073: aload_3
    //   1074: invokevirtual 1406	android/view/View:getResources	()Landroid/content/res/Resources;
    //   1077: ldc_w 1407
    //   1080: invokevirtual 585	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   1083: invokestatic 1411	com/tencent/mobileqq/structmsg/AbsStructMsg:getInCompatibleView	(Landroid/content/Context;Landroid/view/View;Ljava/lang/String;)Landroid/view/View;
    //   1086: astore_2
    //   1087: aload_3
    //   1088: aload 5
    //   1090: invokevirtual 1415	android/view/View:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   1093: aload_3
    //   1094: aload 5
    //   1096: invokevirtual 1419	android/view/View:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   1099: aload 14
    //   1101: instanceof 693
    //   1104: ifeq +1289 -> 2393
    //   1107: aload 14
    //   1109: checkcast 693	com/tencent/mobileqq/structmsg/AbsShareMsg
    //   1112: astore 5
    //   1114: aload 5
    //   1116: invokevirtual 1423	com/tencent/mobileqq/structmsg/AbsShareMsg:getOnClickListener	()Landroid/view/View$OnClickListener;
    //   1119: astore 10
    //   1121: aload_3
    //   1122: new 1425	ahtl
    //   1125: dup
    //   1126: aload_0
    //   1127: aload 5
    //   1129: aload 13
    //   1131: aload_1
    //   1132: aload_1
    //   1133: getfield 1428	com/tencent/mobileqq/data/ChatMessage:time	J
    //   1136: aload 10
    //   1138: invokespecial 1431	ahtl:<init>	(Lcom/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder;Lcom/tencent/mobileqq/structmsg/AbsShareMsg;Lcom/tencent/mobileqq/data/MessageForStructing;Lcom/tencent/mobileqq/data/ChatMessage;JLandroid/view/View$OnClickListener;)V
    //   1141: invokevirtual 1435	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   1144: ldc_w 742
    //   1147: aload 14
    //   1149: invokevirtual 1240	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   1152: ifeq +1152 -> 2304
    //   1155: aload_0
    //   1156: getfield 99	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1159: invokestatic 1440	agid:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Lagid;
    //   1162: aload 4
    //   1164: aload_0
    //   1165: invokevirtual 1443	agid:a	(Landroid/view/View;Lagif;)V
    //   1168: aload_0
    //   1169: aload 13
    //   1171: invokespecial 1445	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:b	(Lcom/tencent/mobileqq/data/MessageForStructing;)Z
    //   1174: ifeq +16 -> 1190
    //   1177: aload_0
    //   1178: getfield 99	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1181: invokestatic 1440	agid:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Lagid;
    //   1184: aload 4
    //   1186: aload_0
    //   1187: invokevirtual 1443	agid:a	(Landroid/view/View;Lagif;)V
    //   1190: aload 14
    //   1192: invokestatic 1449	txx:a	(Lcom/tencent/mobileqq/structmsg/AbsStructMsg;)Z
    //   1195: ifeq +1139 -> 2334
    //   1198: aload_3
    //   1199: aconst_null
    //   1200: invokevirtual 1435	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   1203: aload 14
    //   1205: getfield 296	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgServiceID	I
    //   1208: bipush 76
    //   1210: if_icmpeq +13 -> 1223
    //   1213: aload 14
    //   1215: getfield 296	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgServiceID	I
    //   1218: bipush 106
    //   1220: if_icmpne +28 -> 1248
    //   1223: aload_3
    //   1224: aconst_null
    //   1225: invokevirtual 1435	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   1228: aload 14
    //   1230: getfield 296	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgServiceID	I
    //   1233: bipush 106
    //   1235: if_icmpeq +13 -> 1248
    //   1238: aload_3
    //   1239: aconst_null
    //   1240: invokevirtual 1419	android/view/View:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   1243: aload_3
    //   1244: aconst_null
    //   1245: invokevirtual 1415	android/view/View:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   1248: aload 14
    //   1250: getfield 296	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgServiceID	I
    //   1253: bipush 79
    //   1255: if_icmpne +22 -> 1277
    //   1258: aload_3
    //   1259: aconst_null
    //   1260: invokevirtual 1435	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   1263: aload_3
    //   1264: new 1451	ahsv
    //   1267: dup
    //   1268: aload_0
    //   1269: aload 5
    //   1271: invokespecial 1454	ahsv:<init>	(Lcom/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder;Lcom/tencent/mobileqq/structmsg/AbsShareMsg;)V
    //   1274: invokevirtual 1435	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   1277: aload 14
    //   1279: getfield 296	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgServiceID	I
    //   1282: bipush 81
    //   1284: if_icmpne +3 -> 1287
    //   1287: aload 11
    //   1289: aload_2
    //   1290: invokevirtual 273	android/widget/RelativeLayout:addView	(Landroid/view/View;)V
    //   1293: aload 14
    //   1295: getfield 296	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgServiceID	I
    //   1298: bipush 38
    //   1300: if_icmpne +128 -> 1428
    //   1303: aload_0
    //   1304: getfield 99	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1307: bipush 76
    //   1309: invokevirtual 105	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1312: checkcast 107	bikv
    //   1315: astore_2
    //   1316: aload_2
    //   1317: ifnull +111 -> 1428
    //   1320: aload_2
    //   1321: aload_1
    //   1322: getfield 1428	com/tencent/mobileqq/data/ChatMessage:time	J
    //   1325: invokevirtual 1457	bikv:b	(J)Z
    //   1328: ifeq +1145 -> 2473
    //   1331: new 1459	android/widget/ProgressBar
    //   1334: dup
    //   1335: aload_0
    //   1336: getfield 92	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1339: invokespecial 1460	android/widget/ProgressBar:<init>	(Landroid/content/Context;)V
    //   1342: astore_2
    //   1343: aload_2
    //   1344: ldc_w 1461
    //   1347: invokevirtual 1462	android/widget/ProgressBar:setId	(I)V
    //   1350: aload_2
    //   1351: aload_0
    //   1352: getfield 92	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1355: invokevirtual 48	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1358: ldc_w 1463
    //   1361: invokevirtual 1466	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   1364: invokevirtual 1469	android/widget/ProgressBar:setIndeterminateDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   1367: ldc_w 1470
    //   1370: aload_0
    //   1371: getfield 92	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1374: invokevirtual 48	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1377: invokestatic 203	agej:a	(FLandroid/content/res/Resources;)I
    //   1380: istore 6
    //   1382: new 194	android/widget/RelativeLayout$LayoutParams
    //   1385: dup
    //   1386: bipush 254
    //   1388: bipush 254
    //   1390: invokespecial 197	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   1393: pop
    //   1394: new 194	android/widget/RelativeLayout$LayoutParams
    //   1397: dup
    //   1398: iload 6
    //   1400: iload 6
    //   1402: invokespecial 197	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   1405: astore 5
    //   1407: aload 5
    //   1409: bipush 13
    //   1411: ldc 210
    //   1413: invokevirtual 213	android/widget/RelativeLayout$LayoutParams:addRule	(II)V
    //   1416: aload 11
    //   1418: aload_2
    //   1419: aload 5
    //   1421: invokevirtual 284	android/widget/RelativeLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   1424: aload_0
    //   1425: invokevirtual 1472	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:e	()V
    //   1428: aload 14
    //   1430: instanceof 742
    //   1433: ifeq +1070 -> 2503
    //   1436: aload 13
    //   1438: invokevirtual 781	com/tencent/mobileqq/data/MessageForStructing:isSendFromLocal	()Z
    //   1441: ifeq +38 -> 1479
    //   1444: aload_0
    //   1445: getfield 99	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1448: invokevirtual 787	com/tencent/mobileqq/app/QQAppInterface:a	()Lbeyb;
    //   1451: aload 13
    //   1453: getfield 657	com/tencent/mobileqq/data/MessageForStructing:frienduin	Ljava/lang/String;
    //   1456: aload 13
    //   1458: getfield 660	com/tencent/mobileqq/data/MessageForStructing:uniseq	J
    //   1461: invokevirtual 792	beyb:a	(Ljava/lang/String;J)Lbhvc;
    //   1464: astore_2
    //   1465: aload 9
    //   1467: aload 11
    //   1469: putfield 165	ahtm:jdField_a_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   1472: aload_0
    //   1473: aload_2
    //   1474: aload 9
    //   1476: invokespecial 1474	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:a	(Lbhvc;Lahtm;)V
    //   1479: aload 14
    //   1481: checkcast 742	com/tencent/mobileqq/structmsg/StructMsgForImageShare
    //   1484: invokevirtual 964	com/tencent/mobileqq/structmsg/StructMsgForImageShare:getFirstImageElement	()Lbdqr;
    //   1487: astore_2
    //   1488: aload_2
    //   1489: ifnull +41 -> 1530
    //   1492: aload_2
    //   1493: getfield 1477	bdqr:jdField_a_of_type_ComTencentMobileqqDataMessageForPic	Lcom/tencent/mobileqq/data/MessageForPic;
    //   1496: ifnull +34 -> 1530
    //   1499: aload_0
    //   1500: getfield 99	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1503: invokevirtual 1480	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/pic/PicPreDownloader;
    //   1506: aload_2
    //   1507: getfield 1477	bdqr:jdField_a_of_type_ComTencentMobileqqDataMessageForPic	Lcom/tencent/mobileqq/data/MessageForPic;
    //   1510: iconst_2
    //   1511: invokevirtual 1485	com/tencent/mobileqq/pic/PicPreDownloader:a	(Lcom/tencent/mobileqq/data/MessageForPic;I)V
    //   1514: invokestatic 1488	com/tencent/mobileqq/app/ThreadManager:getFileThreadHandler	()Lmqq/os/MqqHandler;
    //   1517: new 1490	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder$12
    //   1520: dup
    //   1521: aload_0
    //   1522: aload_2
    //   1523: invokespecial 1493	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder$12:<init>	(Lcom/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder;Lbdqr;)V
    //   1526: invokevirtual 890	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   1529: pop
    //   1530: aload_0
    //   1531: aload 14
    //   1533: checkcast 742	com/tencent/mobileqq/structmsg/StructMsgForImageShare
    //   1536: invokespecial 1495	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:a	(Lcom/tencent/mobileqq/structmsg/StructMsgForImageShare;)V
    //   1539: aload 14
    //   1541: getfield 1498	com/tencent/mobileqq/structmsg/AbsStructMsg:adverSign	I
    //   1544: iconst_1
    //   1545: if_icmpne +986 -> 2531
    //   1548: new 167	android/widget/RelativeLayout
    //   1551: dup
    //   1552: aload_0
    //   1553: getfield 92	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1556: invokespecial 180	android/widget/RelativeLayout:<init>	(Landroid/content/Context;)V
    //   1559: astore_2
    //   1560: new 367	android/widget/ImageView
    //   1563: dup
    //   1564: aload_0
    //   1565: getfield 92	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1568: invokespecial 1499	android/widget/ImageView:<init>	(Landroid/content/Context;)V
    //   1571: astore 5
    //   1573: aload 5
    //   1575: ldc_w 1500
    //   1578: invokevirtual 371	android/widget/ImageView:setImageResource	(I)V
    //   1581: aload_2
    //   1582: iconst_0
    //   1583: invokevirtual 1503	android/widget/RelativeLayout:setBackgroundColor	(I)V
    //   1586: new 194	android/widget/RelativeLayout$LayoutParams
    //   1589: dup
    //   1590: ldc_w 1504
    //   1593: aload_0
    //   1594: getfield 92	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1597: invokevirtual 48	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1600: invokestatic 203	agej:a	(FLandroid/content/res/Resources;)I
    //   1603: ldc_w 1217
    //   1606: aload_0
    //   1607: getfield 92	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1610: invokevirtual 48	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1613: invokestatic 203	agej:a	(FLandroid/content/res/Resources;)I
    //   1616: invokespecial 197	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   1619: astore 10
    //   1621: aload 10
    //   1623: bipush 11
    //   1625: invokevirtual 1506	android/widget/RelativeLayout$LayoutParams:addRule	(I)V
    //   1628: aload 10
    //   1630: bipush 10
    //   1632: invokevirtual 1506	android/widget/RelativeLayout$LayoutParams:addRule	(I)V
    //   1635: aload_2
    //   1636: aload 10
    //   1638: invokevirtual 217	android/widget/RelativeLayout:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   1641: new 194	android/widget/RelativeLayout$LayoutParams
    //   1644: dup
    //   1645: bipush 254
    //   1647: bipush 254
    //   1649: invokespecial 197	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   1652: astore 10
    //   1654: aload 10
    //   1656: bipush 11
    //   1658: invokevirtual 1506	android/widget/RelativeLayout$LayoutParams:addRule	(I)V
    //   1661: aload 10
    //   1663: bipush 10
    //   1665: invokevirtual 1506	android/widget/RelativeLayout$LayoutParams:addRule	(I)V
    //   1668: aload 10
    //   1670: iconst_0
    //   1671: bipush 12
    //   1673: bipush 12
    //   1675: iconst_0
    //   1676: invokevirtual 1051	android/widget/RelativeLayout$LayoutParams:setMargins	(IIII)V
    //   1679: aload 5
    //   1681: aload 10
    //   1683: invokevirtual 1507	android/widget/ImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   1686: aload_2
    //   1687: aload 5
    //   1689: invokevirtual 273	android/widget/RelativeLayout:addView	(Landroid/view/View;)V
    //   1692: aload_3
    //   1693: instanceof 167
    //   1696: ifeq +11 -> 1707
    //   1699: aload_3
    //   1700: checkcast 167	android/widget/RelativeLayout
    //   1703: aload_2
    //   1704: invokevirtual 273	android/widget/RelativeLayout:addView	(Landroid/view/View;)V
    //   1707: aload 13
    //   1709: getfield 657	com/tencent/mobileqq/data/MessageForStructing:frienduin	Ljava/lang/String;
    //   1712: astore 10
    //   1714: aload 14
    //   1716: getfield 1510	com/tencent/mobileqq/structmsg/AbsStructMsg:msgId	J
    //   1719: lstore 7
    //   1721: aload_0
    //   1722: getfield 92	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1725: instanceof 393
    //   1728: ifeq +22 -> 1750
    //   1731: aload_2
    //   1732: new 1512	ahsw
    //   1735: dup
    //   1736: aload_0
    //   1737: aload 5
    //   1739: aload_1
    //   1740: aload 10
    //   1742: lload 7
    //   1744: invokespecial 1515	ahsw:<init>	(Lcom/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder;Landroid/widget/ImageView;Lcom/tencent/mobileqq/data/ChatMessage;Ljava/lang/String;J)V
    //   1747: invokevirtual 1516	android/widget/RelativeLayout:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   1750: aload_0
    //   1751: getfield 510	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_Blol	Lblol;
    //   1754: ifnull +20 -> 1774
    //   1757: aload_0
    //   1758: getfield 510	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_Blol	Lblol;
    //   1761: invokevirtual 1519	blol:isShowing	()Z
    //   1764: ifeq +10 -> 1774
    //   1767: aload_0
    //   1768: getfield 510	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_Blol	Lblol;
    //   1771: invokevirtual 520	blol:dismiss	()V
    //   1774: aload 4
    //   1776: ifnull +192 -> 1968
    //   1779: aload 13
    //   1781: invokestatic 1523	axug:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   1784: ifne +184 -> 1968
    //   1787: aload 4
    //   1789: ldc_w 1524
    //   1792: invokevirtual 1525	com/tencent/mobileqq/activity/aio/BaseChatItemLayout:findViewById	(I)Landroid/view/View;
    //   1795: checkcast 1527	com/tencent/mobileqq/doutu/DuiButtonImageView
    //   1798: astore_2
    //   1799: aload_2
    //   1800: ifnonnull +988 -> 2788
    //   1803: new 1527	com/tencent/mobileqq/doutu/DuiButtonImageView
    //   1806: dup
    //   1807: aload_0
    //   1808: getfield 92	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1811: aload_0
    //   1812: getfield 99	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1815: aload_1
    //   1816: invokespecial 1530	com/tencent/mobileqq/doutu/DuiButtonImageView:<init>	(Landroid/content/Context;Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/ChatMessage;)V
    //   1819: astore_2
    //   1820: new 194	android/widget/RelativeLayout$LayoutParams
    //   1823: dup
    //   1824: ldc_w 1531
    //   1827: aload_0
    //   1828: getfield 92	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1831: invokevirtual 48	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1834: invokestatic 203	agej:a	(FLandroid/content/res/Resources;)I
    //   1837: ldc_w 1531
    //   1840: aload_0
    //   1841: getfield 92	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1844: invokevirtual 48	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1847: invokestatic 203	agej:a	(FLandroid/content/res/Resources;)I
    //   1850: invokespecial 197	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   1853: astore 5
    //   1855: aload 5
    //   1857: bipush 8
    //   1859: ldc 210
    //   1861: invokevirtual 213	android/widget/RelativeLayout$LayoutParams:addRule	(II)V
    //   1864: aload 5
    //   1866: iconst_1
    //   1867: ldc 210
    //   1869: invokevirtual 213	android/widget/RelativeLayout$LayoutParams:addRule	(II)V
    //   1872: aload 5
    //   1874: getstatic 1234	com/tencent/mobileqq/activity/aio/BaseChatItemLayout:i	I
    //   1877: ldc_w 1532
    //   1880: aload_0
    //   1881: getfield 92	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1884: invokevirtual 48	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1887: invokestatic 203	agej:a	(FLandroid/content/res/Resources;)I
    //   1890: isub
    //   1891: putfield 1194	android/widget/RelativeLayout$LayoutParams:bottomMargin	I
    //   1894: aload_2
    //   1895: ldc_w 1524
    //   1898: invokevirtual 1533	com/tencent/mobileqq/doutu/DuiButtonImageView:setId	(I)V
    //   1901: aload 4
    //   1903: aload_2
    //   1904: aload 5
    //   1906: invokevirtual 1534	com/tencent/mobileqq/activity/aio/BaseChatItemLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   1909: aload_1
    //   1910: getfield 1535	com/tencent/mobileqq/data/ChatMessage:extraflag	I
    //   1913: ldc_w 562
    //   1916: if_icmpne +10 -> 1926
    //   1919: aload_1
    //   1920: invokevirtual 1536	com/tencent/mobileqq/data/ChatMessage:isSendFromLocal	()Z
    //   1923: ifne +17 -> 1940
    //   1926: aload_0
    //   1927: getfield 99	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1930: invokevirtual 565	com/tencent/mobileqq/app/QQAppInterface:a	()Lbcrg;
    //   1933: aload_1
    //   1934: invokevirtual 1538	bcrg:c	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   1937: ifeq +859 -> 2796
    //   1940: iconst_1
    //   1941: istore 6
    //   1943: aload_1
    //   1944: getfield 1541	com/tencent/mobileqq/data/ChatMessage:isDui	Z
    //   1947: ifeq +910 -> 2857
    //   1950: iload 6
    //   1952: ifne +905 -> 2857
    //   1955: aload_1
    //   1956: invokevirtual 1542	com/tencent/mobileqq/data/ChatMessage:isSend	()Z
    //   1959: ifeq +843 -> 2802
    //   1962: aload_2
    //   1963: bipush 8
    //   1965: invokevirtual 1543	com/tencent/mobileqq/doutu/DuiButtonImageView:setVisibility	(I)V
    //   1968: aload_0
    //   1969: getfield 124	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   1972: getfield 574	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_Int	I
    //   1975: sipush 1008
    //   1978: if_icmpne -1802 -> 176
    //   1981: aload_0
    //   1982: getfield 1546	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   1985: aload_1
    //   1986: getfield 1155	com/tencent/mobileqq/data/ChatMessage:uniseq	J
    //   1989: invokestatic 740	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1992: invokevirtual 1549	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   1995: ifne -1819 -> 176
    //   1998: aload_0
    //   1999: getfield 1546	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   2002: aload_1
    //   2003: getfield 1155	com/tencent/mobileqq/data/ChatMessage:uniseq	J
    //   2006: invokestatic 740	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2009: invokevirtual 1550	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   2012: pop
    //   2013: bipush 117
    //   2015: aload_1
    //   2016: aload 9
    //   2018: getfield 1059	ahtm:jdField_b_of_type_Int	I
    //   2021: invokestatic 1555	apeg:a	(ILcom/tencent/mobileqq/data/ChatMessage;I)V
    //   2024: aload_3
    //   2025: areturn
    //   2026: aload 13
    //   2028: ldc_w 1334
    //   2031: invokevirtual 1380	com/tencent/mobileqq/data/MessageForStructing:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   2034: astore_2
    //   2035: aload_2
    //   2036: ifnull -1399 -> 637
    //   2039: aload_2
    //   2040: ldc_w 488
    //   2043: invokevirtual 722	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2046: ifne -1409 -> 637
    //   2049: aload 14
    //   2051: aload_2
    //   2052: invokestatic 1383	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   2055: putfield 1332	com/tencent/mobileqq/structmsg/AbsStructMsg:sourceAccoutType	I
    //   2058: goto -1421 -> 637
    //   2061: astore_2
    //   2062: goto -1425 -> 637
    //   2065: aload 9
    //   2067: iconst_0
    //   2068: putfield 1365	ahtm:jdField_a_of_type_Boolean	Z
    //   2071: goto -1249 -> 822
    //   2074: astore 12
    //   2076: ldc_w 841
    //   2079: iconst_1
    //   2080: aload 12
    //   2082: iconst_0
    //   2083: anewarray 253	java/lang/Object
    //   2086: invokestatic 1558	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   2089: aload_2
    //   2090: astore 12
    //   2092: goto -1057 -> 1035
    //   2095: aload 14
    //   2097: aload_0
    //   2098: getfield 92	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2101: aload_2
    //   2102: aload 5
    //   2104: aload 15
    //   2106: invokevirtual 1562	com/tencent/mobileqq/structmsg/AbsStructMsg:getView	(Landroid/content/Context;Landroid/view/View;Lagjk;Landroid/os/Bundle;)Landroid/view/View;
    //   2109: astore_2
    //   2110: goto -1023 -> 1087
    //   2113: aload 14
    //   2115: getfield 296	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgServiceID	I
    //   2118: bipush 61
    //   2120: if_icmpne +42 -> 2162
    //   2123: aload_0
    //   2124: getfield 92	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2127: aconst_null
    //   2128: aload_3
    //   2129: invokevirtual 1406	android/view/View:getResources	()Landroid/content/res/Resources;
    //   2132: ldc_w 1407
    //   2135: invokevirtual 585	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   2138: invokestatic 1411	com/tencent/mobileqq/structmsg/AbsStructMsg:getInCompatibleView	(Landroid/content/Context;Landroid/view/View;Ljava/lang/String;)Landroid/view/View;
    //   2141: astore_2
    //   2142: aload 10
    //   2144: ifnull +15 -> 2159
    //   2147: aload 10
    //   2149: aload 12
    //   2151: aload_2
    //   2152: aload_3
    //   2153: checkcast 1242	android/view/ViewGroup
    //   2156: invokevirtual 1565	ahtn:a	(Ljava/lang/String;Landroid/view/View;Landroid/view/ViewGroup;)V
    //   2159: goto -1072 -> 1087
    //   2162: aload 14
    //   2164: aload_0
    //   2165: getfield 92	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2168: aconst_null
    //   2169: aload 5
    //   2171: aload 15
    //   2173: invokevirtual 1562	com/tencent/mobileqq/structmsg/AbsStructMsg:getView	(Landroid/content/Context;Landroid/view/View;Lagjk;Landroid/os/Bundle;)Landroid/view/View;
    //   2176: astore_2
    //   2177: goto -35 -> 2142
    //   2180: aload 11
    //   2182: invokevirtual 1568	android/widget/RelativeLayout:getChildCount	()I
    //   2185: ifle +83 -> 2268
    //   2188: aload 11
    //   2190: iconst_0
    //   2191: invokevirtual 221	android/widget/RelativeLayout:getChildAt	(I)Landroid/view/View;
    //   2194: astore 10
    //   2196: aload 10
    //   2198: astore_2
    //   2199: aload 10
    //   2201: ifnull +67 -> 2268
    //   2204: aload 10
    //   2206: ldc 222
    //   2208: invokevirtual 226	android/view/View:getTag	(I)Ljava/lang/Object;
    //   2211: astore 12
    //   2213: invokestatic 231	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2216: ifeq +29 -> 2245
    //   2219: ldc 233
    //   2221: iconst_2
    //   2222: new 235	java/lang/StringBuilder
    //   2225: dup
    //   2226: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   2229: ldc 238
    //   2231: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2234: aload 12
    //   2236: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2239: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2242: invokestatic 251	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2245: aload 12
    //   2247: ifnull +19 -> 2266
    //   2250: aload 10
    //   2252: astore_2
    //   2253: aload 12
    //   2255: invokevirtual 257	java/lang/Object:getClass	()Ljava/lang/Class;
    //   2258: aload 14
    //   2260: invokevirtual 257	java/lang/Object:getClass	()Ljava/lang/Class;
    //   2263: if_acmpeq +5 -> 2268
    //   2266: aconst_null
    //   2267: astore_2
    //   2268: aload 11
    //   2270: invokevirtual 260	android/widget/RelativeLayout:removeAllViews	()V
    //   2273: aload_0
    //   2274: aload_1
    //   2275: invokespecial 1244	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:c	(Lcom/tencent/mobileqq/data/ChatMessage;)Z
    //   2278: ifeq +21 -> 2299
    //   2281: aload 14
    //   2283: aload_0
    //   2284: getfield 92	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2287: aload_2
    //   2288: aload 5
    //   2290: aload 15
    //   2292: invokevirtual 1562	com/tencent/mobileqq/structmsg/AbsStructMsg:getView	(Landroid/content/Context;Landroid/view/View;Lagjk;Landroid/os/Bundle;)Landroid/view/View;
    //   2295: astore_2
    //   2296: goto -1209 -> 1087
    //   2299: aconst_null
    //   2300: astore_2
    //   2301: goto -20 -> 2281
    //   2304: ldc 75
    //   2306: aload 14
    //   2308: invokevirtual 1240	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   2311: ifeq -1143 -> 1168
    //   2314: aload_0
    //   2315: aload 14
    //   2317: invokespecial 1570	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:b	(Lcom/tencent/mobileqq/structmsg/AbsStructMsg;)Z
    //   2320: ifeq -1152 -> 1168
    //   2323: aload_0
    //   2324: aload 4
    //   2326: aload 13
    //   2328: invokespecial 1572	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:a	(Lcom/tencent/mobileqq/activity/aio/BaseChatItemLayout;Lcom/tencent/mobileqq/data/MessageForStructing;)V
    //   2331: goto -1163 -> 1168
    //   2334: aload 14
    //   2336: getfield 296	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgServiceID	I
    //   2339: bipush 78
    //   2341: if_icmpne -1138 -> 1203
    //   2344: aload_0
    //   2345: getfield 92	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2348: checkcast 1202	android/support/v4/app/FragmentActivity
    //   2351: invokevirtual 1206	android/support/v4/app/FragmentActivity:getChatFragment	()Lcom/tencent/mobileqq/activity/ChatFragment;
    //   2354: invokevirtual 1211	com/tencent/mobileqq/activity/ChatFragment:a	()Lcom/tencent/mobileqq/activity/BaseChatPie;
    //   2357: astore 10
    //   2359: aload 14
    //   2361: checkcast 693	com/tencent/mobileqq/structmsg/AbsShareMsg
    //   2364: astore 12
    //   2366: aload 10
    //   2368: instanceof 1574
    //   2371: ifeq -1168 -> 1203
    //   2374: aload_3
    //   2375: new 1576	ahsu
    //   2378: dup
    //   2379: aload_0
    //   2380: aload 10
    //   2382: aload 12
    //   2384: invokespecial 1579	ahsu:<init>	(Lcom/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder;Lcom/tencent/mobileqq/activity/BaseChatPie;Lcom/tencent/mobileqq/structmsg/AbsShareMsg;)V
    //   2387: invokevirtual 1435	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   2390: goto -1187 -> 1203
    //   2393: aload 14
    //   2395: getfield 296	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgServiceID	I
    //   2398: iconst_3
    //   2399: if_icmpeq +13 -> 2412
    //   2402: aload 14
    //   2404: getfield 296	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgServiceID	I
    //   2407: bipush 120
    //   2409: if_icmpne -1122 -> 1287
    //   2412: aload_0
    //   2413: invokevirtual 1580	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:a	()Z
    //   2416: ifeq +11 -> 2427
    //   2419: aload_3
    //   2420: iconst_0
    //   2421: invokevirtual 1581	android/view/View:setClickable	(Z)V
    //   2424: goto -1137 -> 1287
    //   2427: aload_3
    //   2428: iconst_1
    //   2429: invokevirtual 1581	android/view/View:setClickable	(Z)V
    //   2432: goto -1145 -> 1287
    //   2435: astore 5
    //   2437: aload_2
    //   2438: invokevirtual 1585	android/view/View:getParent	()Landroid/view/ViewParent;
    //   2441: astore 5
    //   2443: aload 5
    //   2445: ifnull +19 -> 2464
    //   2448: aload 5
    //   2450: instanceof 1242
    //   2453: ifeq +11 -> 2464
    //   2456: aload 5
    //   2458: checkcast 1242	android/view/ViewGroup
    //   2461: invokevirtual 1245	android/view/ViewGroup:removeAllViews	()V
    //   2464: aload 11
    //   2466: aload_2
    //   2467: invokevirtual 273	android/widget/RelativeLayout:addView	(Landroid/view/View;)V
    //   2470: goto -1177 -> 1293
    //   2473: aload_0
    //   2474: getfield 124	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   2477: getfield 574	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_Int	I
    //   2480: ifne -1052 -> 1428
    //   2483: aload_2
    //   2484: invokevirtual 110	bikv:a	()Lbiku;
    //   2487: astore_2
    //   2488: aload_2
    //   2489: ifnull -1061 -> 1428
    //   2492: aload_0
    //   2493: aload_2
    //   2494: getfield 140	biku:a	J
    //   2497: invokespecial 1586	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:a	(J)V
    //   2500: goto -1072 -> 1428
    //   2503: aload 14
    //   2505: instanceof 75
    //   2508: ifne +11 -> 2519
    //   2511: aload 14
    //   2513: instanceof 1588
    //   2516: ifeq -977 -> 1539
    //   2519: aload_0
    //   2520: aload 14
    //   2522: checkcast 693	com/tencent/mobileqq/structmsg/AbsShareMsg
    //   2525: invokespecial 1590	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:a	(Lcom/tencent/mobileqq/structmsg/AbsShareMsg;)V
    //   2528: goto -989 -> 1539
    //   2531: aload 14
    //   2533: getfield 1498	com/tencent/mobileqq/structmsg/AbsStructMsg:adverSign	I
    //   2536: iconst_2
    //   2537: if_icmpne -787 -> 1750
    //   2540: new 167	android/widget/RelativeLayout
    //   2543: dup
    //   2544: aload_0
    //   2545: getfield 92	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2548: invokespecial 180	android/widget/RelativeLayout:<init>	(Landroid/content/Context;)V
    //   2551: astore_2
    //   2552: new 374	android/widget/TextView
    //   2555: dup
    //   2556: aload_0
    //   2557: getfield 92	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2560: invokespecial 1591	android/widget/TextView:<init>	(Landroid/content/Context;)V
    //   2563: astore 5
    //   2565: aload 5
    //   2567: ldc_w 1592
    //   2570: invokevirtual 1593	android/widget/TextView:setBackgroundResource	(I)V
    //   2573: aload 5
    //   2575: bipush 17
    //   2577: invokevirtual 1594	android/widget/TextView:setGravity	(I)V
    //   2580: aload 14
    //   2582: getfield 1498	com/tencent/mobileqq/structmsg/AbsStructMsg:adverSign	I
    //   2585: istore 6
    //   2587: aload 5
    //   2589: ldc_w 1595
    //   2592: invokestatic 379	anzj:a	(I)Ljava/lang/String;
    //   2595: invokevirtual 383	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   2598: aload 5
    //   2600: iconst_m1
    //   2601: invokevirtual 1596	android/widget/TextView:setTextColor	(I)V
    //   2604: aload 5
    //   2606: ldc_w 1597
    //   2609: invokevirtual 1600	android/widget/TextView:setTextSize	(F)V
    //   2612: aload_2
    //   2613: iconst_0
    //   2614: invokevirtual 1503	android/widget/RelativeLayout:setBackgroundColor	(I)V
    //   2617: new 194	android/widget/RelativeLayout$LayoutParams
    //   2620: dup
    //   2621: ldc_w 1504
    //   2624: aload_0
    //   2625: getfield 92	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2628: invokevirtual 48	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   2631: invokestatic 203	agej:a	(FLandroid/content/res/Resources;)I
    //   2634: ldc_w 1217
    //   2637: aload_0
    //   2638: getfield 92	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2641: invokevirtual 48	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   2644: invokestatic 203	agej:a	(FLandroid/content/res/Resources;)I
    //   2647: invokespecial 197	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   2650: astore 10
    //   2652: aload 10
    //   2654: bipush 11
    //   2656: invokevirtual 1506	android/widget/RelativeLayout$LayoutParams:addRule	(I)V
    //   2659: aload 10
    //   2661: bipush 10
    //   2663: invokevirtual 1506	android/widget/RelativeLayout$LayoutParams:addRule	(I)V
    //   2666: aload_2
    //   2667: aload 10
    //   2669: invokevirtual 217	android/widget/RelativeLayout:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   2672: new 194	android/widget/RelativeLayout$LayoutParams
    //   2675: dup
    //   2676: bipush 254
    //   2678: bipush 254
    //   2680: invokespecial 197	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   2683: astore 10
    //   2685: aload 10
    //   2687: bipush 11
    //   2689: invokevirtual 1506	android/widget/RelativeLayout$LayoutParams:addRule	(I)V
    //   2692: aload 10
    //   2694: bipush 10
    //   2696: invokevirtual 1506	android/widget/RelativeLayout$LayoutParams:addRule	(I)V
    //   2699: aload 5
    //   2701: aload 10
    //   2703: invokevirtual 1601	android/widget/TextView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   2706: aload_2
    //   2707: aload 5
    //   2709: invokevirtual 273	android/widget/RelativeLayout:addView	(Landroid/view/View;)V
    //   2712: aload_3
    //   2713: instanceof 167
    //   2716: ifeq +11 -> 2727
    //   2719: aload_3
    //   2720: checkcast 167	android/widget/RelativeLayout
    //   2723: aload_2
    //   2724: invokevirtual 273	android/widget/RelativeLayout:addView	(Landroid/view/View;)V
    //   2727: aload 13
    //   2729: getfield 657	com/tencent/mobileqq/data/MessageForStructing:frienduin	Ljava/lang/String;
    //   2732: astore 10
    //   2734: aload 14
    //   2736: getfield 1510	com/tencent/mobileqq/structmsg/AbsStructMsg:msgId	J
    //   2739: lstore 7
    //   2741: aload 13
    //   2743: ldc_w 1275
    //   2746: invokevirtual 1380	com/tencent/mobileqq/data/MessageForStructing:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   2749: astore 10
    //   2751: aload 13
    //   2753: getfield 1310	com/tencent/mobileqq/data/MessageForStructing:istroop	I
    //   2756: istore 6
    //   2758: aload_0
    //   2759: getfield 92	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2762: instanceof 393
    //   2765: ifeq -1015 -> 1750
    //   2768: aload_2
    //   2769: new 1603	ahsx
    //   2772: dup
    //   2773: aload_0
    //   2774: aload 5
    //   2776: aload_1
    //   2777: aload 10
    //   2779: invokespecial 1606	ahsx:<init>	(Lcom/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder;Landroid/widget/TextView;Lcom/tencent/mobileqq/data/ChatMessage;Ljava/lang/String;)V
    //   2782: invokevirtual 1516	android/widget/RelativeLayout:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   2785: goto -1035 -> 1750
    //   2788: aload_2
    //   2789: aload_1
    //   2790: putfield 1607	com/tencent/mobileqq/doutu/DuiButtonImageView:jdField_a_of_type_ComTencentMobileqqDataChatMessage	Lcom/tencent/mobileqq/data/ChatMessage;
    //   2793: goto -884 -> 1909
    //   2796: iconst_0
    //   2797: istore 6
    //   2799: goto -856 -> 1943
    //   2802: aload_1
    //   2803: getfield 1610	com/tencent/mobileqq/data/ChatMessage:hasPlayedDui	Z
    //   2806: ifne +30 -> 2836
    //   2809: aload_1
    //   2810: aload_2
    //   2811: invokestatic 1613	com/tencent/mobileqq/doutu/DuiButtonImageView:a	(Lcom/tencent/mobileqq/doutu/DuiButtonImageView;)Z
    //   2814: putfield 1610	com/tencent/mobileqq/data/ChatMessage:hasPlayedDui	Z
    //   2817: getstatic 1614	com/tencent/mobileqq/doutu/DuiButtonImageView:jdField_a_of_type_Boolean	Z
    //   2820: ifeq +23 -> 2843
    //   2823: aload_2
    //   2824: aload_0
    //   2825: invokevirtual 1615	com/tencent/mobileqq/doutu/DuiButtonImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   2828: aload_2
    //   2829: iconst_0
    //   2830: invokevirtual 1543	com/tencent/mobileqq/doutu/DuiButtonImageView:setVisibility	(I)V
    //   2833: goto -865 -> 1968
    //   2836: aload_2
    //   2837: invokevirtual 1617	com/tencent/mobileqq/doutu/DuiButtonImageView:f	()V
    //   2840: goto -23 -> 2817
    //   2843: aload_2
    //   2844: aconst_null
    //   2845: invokevirtual 1615	com/tencent/mobileqq/doutu/DuiButtonImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   2848: aload_2
    //   2849: bipush 8
    //   2851: invokevirtual 1543	com/tencent/mobileqq/doutu/DuiButtonImageView:setVisibility	(I)V
    //   2854: goto -886 -> 1968
    //   2857: aload_2
    //   2858: bipush 8
    //   2860: invokevirtual 1543	com/tencent/mobileqq/doutu/DuiButtonImageView:setVisibility	(I)V
    //   2863: aload_2
    //   2864: invokevirtual 1618	com/tencent/mobileqq/doutu/DuiButtonImageView:e	()V
    //   2867: goto -899 -> 1968
    //   2870: astore_2
    //   2871: goto -1987 -> 884
    //   2874: goto -1842 -> 1032
    //   2877: aload_2
    //   2878: astore 9
    //   2880: goto -2125 -> 755
    //   2883: aconst_null
    //   2884: astore_2
    //   2885: goto -2140 -> 745
    //   2888: aconst_null
    //   2889: astore 10
    //   2891: goto -2844 -> 47
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2894	0	this	StructingMsgItemBuilder
    //   0	2894	1	paramChatMessage	ChatMessage
    //   0	2894	2	paramaggl	aggl
    //   0	2894	3	paramView	View
    //   0	2894	4	paramBaseChatItemLayout	BaseChatItemLayout
    //   0	2894	5	paramagjk	agjk
    //   139	2659	6	i	int
    //   1719	1021	7	l	long
    //   58	2821	9	localObject1	Object
    //   45	2845	10	localObject2	Object
    //   129	2336	11	localObject3	Object
    //   537	508	12	localObject4	Object
    //   2074	7	12	localThrowable	java.lang.Throwable
    //   2090	293	12	localObject5	Object
    //   215	2537	13	localMessageForStructing	MessageForStructing
    //   222	2513	14	localAbsStructMsg	AbsStructMsg
    //   7	2284	15	localBundle	Bundle
    // Exception table:
    //   from	to	target	type
    //   2049	2058	2061	java/lang/Exception
    //   933	1029	2074	java/lang/Throwable
    //   1287	1293	2435	java/lang/IllegalStateException
    //   865	884	2870	java/lang/Exception
  }
  
  public bhuk a(bhuk parambhuk, ChatMessage paramChatMessage, aghd paramaghd)
  {
    paramaghd = (MessageForStructing)paramChatMessage;
    paramChatMessage = paramaghd.structingMsg;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramChatMessage != null) {
      if (a(paramaghd, paramChatMessage)) {}
    }
    while ((!bool1) && (!a(paramChatMessage, parambhuk)))
    {
      return parambhuk;
      paramaghd = this.jdField_a_of_type_AndroidContentContext.getResources();
      bool1 = bool2;
      if (paramChatMessage.fwFlag != 1)
      {
        a(parambhuk, paramChatMessage, paramaghd);
        bool1 = a(paramChatMessage);
      }
    }
    parambhuk.a(2131366320, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131691990), 2130838938);
    return parambhuk;
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (bhnt.a(paramChatMessage.issend)) {
      localStringBuilder.append("发出");
    }
    AbsShareMsg localAbsShareMsg;
    for (;;)
    {
      paramChatMessage = ((MessageForStructing)paramChatMessage).structingMsg;
      if ((paramChatMessage == null) || (!(paramChatMessage instanceof AbsShareMsg))) {
        break label210;
      }
      localAbsShareMsg = (AbsShareMsg)paramChatMessage;
      if (localAbsShareMsg.mMsgServiceID != 35) {
        break;
      }
      localStringBuilder.delete(0, localStringBuilder.length());
      localStringBuilder.append(paramChatMessage.mMsgBrief);
      localStringBuilder.append(localAbsShareMsg.getTalkBackStr());
      localStringBuilder.append("按钮");
      return localStringBuilder.toString();
      localStringBuilder.append("发来");
    }
    if (localAbsShareMsg.mMsgServiceID == 107)
    {
      localStringBuilder.append(localAbsShareMsg.getTalkBackStr());
      return localStringBuilder.toString();
    }
    if (TextUtils.isEmpty(localAbsShareMsg.getTalkBackStr()))
    {
      if ((localAbsShareMsg.mContentTitle != null) && (localAbsShareMsg.mContentTitle.trim().length() > 0)) {
        localStringBuilder.append(localAbsShareMsg.mContentTitle);
      }
      if ((localAbsShareMsg.mContentSummary != null) && (localAbsShareMsg.mContentSummary.trim().length() > 0)) {
        localStringBuilder.append(localAbsShareMsg.mContentSummary);
      }
      localStringBuilder.append("按钮");
    }
    for (;;)
    {
      label210:
      return localStringBuilder.toString();
      localStringBuilder.append(localAbsShareMsg.getTalkBackStr());
      localStringBuilder.append("按钮");
    }
  }
  
  public String a(String paramString)
  {
    String str2 = "";
    String str1 = str2;
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.split("/");
      str1 = str2;
      if (paramString.length > 6) {
        str1 = paramString[5];
      }
    }
    return str1;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilList.clear();
    StructMsgForGeneralShare.unRegisterQIPC();
  }
  
  @SuppressLint({"NewApi"})
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    Object localObject6 = aics.a(paramChatMessage);
    Object localObject1;
    if (paramInt == 2131362195) {
      if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForStructing)))
      {
        paramContext = (MessageForStructing)paramChatMessage;
        if ((paramContext.structingMsg == null) || (!(paramContext.structingMsg instanceof StructMsgForImageShare))) {
          break label131;
        }
        paramContext = (StructMsgForImageShare)paramContext.structingMsg;
        paramChatMessage = paramContext.getFirstImageElement();
        if (paramChatMessage == null) {
          break label131;
        }
        paramChatMessage = paramChatMessage.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
        localObject1 = beyq.a(paramChatMessage, 1);
        if (localObject1 != null) {
          break label81;
        }
      }
    }
    label81:
    Object localObject2;
    label131:
    label490:
    int i;
    label1008:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                  localObject1 = URLDrawable.getDrawable((URL)localObject1, -1, -1, null, null, false);
                  ((URLDrawable)localObject1).setTag(paramChatMessage);
                  aicv.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (URLDrawable)localObject1, paramChatMessage.frienduin, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299011), paramContext, null);
                } while (!aics.a((String)localObject6));
                bmbt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "3009", "2", "40053", aics.b((String)localObject6), new String[] { "1", "", aics.a((String)localObject6) });
                return;
                if (paramInt != 2131367078) {
                  break;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("forward", 2, "structingMsgItem forward");
                }
              } while ((paramChatMessage == null) || (!(paramChatMessage instanceof MessageForStructing)));
              paramChatMessage = (MessageForStructing)paramChatMessage;
            } while (paramChatMessage.structingMsg == null);
            if (!(paramChatMessage.structingMsg instanceof StructMsgForImageShare)) {
              break;
            }
          } while (!((StructMsgForImageShare)paramChatMessage.structingMsg).checkImageSharePic(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()));
          localObject1 = new Bundle();
          if ((paramChatMessage.structingMsg.source_puin != null) && (!"".equals(paramChatMessage.structingMsg.source_puin))) {
            ((Bundle)localObject1).putString("source_puin", paramChatMessage.structingMsg.source_puin);
          }
          ((Bundle)localObject1).putInt("forward_type", -3);
          paramChatMessage.structingMsg.mCommentText = null;
          ((Bundle)localObject1).putInt("structmsg_service_id", paramChatMessage.structingMsg.mMsgServiceID);
          ((Bundle)localObject1).putByteArray("stuctmsg_bytes", paramChatMessage.structingMsg.getBytes());
          ((Bundle)localObject1).putLong("structmsg_uniseq", paramChatMessage.uniseq);
          ((Bundle)localObject1).putInt("accostType", paramChatMessage.structingMsg.sourceAccoutType);
          ((Bundle)localObject1).putInt("selection_mode", this.jdField_b_of_type_Int);
          paramContext = new Intent();
          paramContext.putExtras((Bundle)localObject1);
          if (!(paramChatMessage.structingMsg instanceof StructMsgForImageShare)) {
            break label1008;
          }
          localObject1 = (StructMsgForImageShare)paramChatMessage.structingMsg;
          localObject2 = ((StructMsgForImageShare)localObject1).getFirstImageElement();
          if ((localObject2 != null) && (((bdqr)localObject2).a()))
          {
            paramContext.putExtra("key_forward_image_share", true);
            paramContext.putExtra("key_forward_image_share_appid", Long.toString(((StructMsgForImageShare)localObject1).mSourceAppid));
            paramContext.putExtra("key_forward_image_share_uin_type", ((StructMsgForImageShare)localObject1).uinType);
          }
          auxu.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramContext, 21);
          paramContext = paramChatMessage.structingMsg.mMsgUrl;
          localObject1 = paramChatMessage.senderuin;
          localObject2 = Long.toString(paramChatMessage.structingMsg.msgId);
          bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005455", "0X8005455", 0, 0, (String)localObject1, paramContext, (String)localObject2, "");
          bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
          if (paramChatMessage.structingMsg.mMsgServiceID == 84) {
            bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8007166", "0X8007166", 0, 0, "", "", "", "");
          }
          if (aics.a((String)localObject6)) {
            bmbt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "3009", "2", "40053", aics.b((String)localObject6), new String[] { "2", "", aics.a((String)localObject6) });
          }
        } while (!paramChatMessage.isMultiMsg);
        i = 10;
        paramContext = paramChatMessage.structingMsg;
        paramInt = i;
        if (paramContext != null) {
          switch (paramContext.mMsgServiceID)
          {
          default: 
            paramInt = i;
          }
        }
        for (;;)
        {
          bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D66", "0X8009D66", paramInt, 0, "" + paramInt, "", "", "");
          return;
          if ((paramChatMessage.structingMsg != null) && (paramChatMessage.structingMsg.mMsgServiceID == 35))
          {
            bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006624", "0X8006624", 0, 1, 0, "", "", "", "");
            if (!axpf.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.uniseq))
            {
              paramInt = paramContext.getResources().getDimensionPixelSize(2131299011);
              QQToast.a(paramContext, anzj.a(2131713389), 0).b(paramInt);
              return;
            }
            if (!axpf.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.uniseq)) {
              break;
            }
            bhlq.a(paramContext, 230, null, "选择的消息中，部分图片\\表情等内容可能无法正常转发，是否继续转发？", anzj.a(2131713381), anzj.a(2131713391), new ahst(this, paramChatMessage), new ahtb(this)).show();
            return;
          }
          if ((paramChatMessage.structingMsg == null) || (paramChatMessage.structingMsg.mMsgServiceID != 81)) {
            break;
          }
          yup.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramChatMessage, "forward");
          break;
          if ((!(paramChatMessage.structingMsg instanceof StructMsgForAudioShare)) && (!(paramChatMessage.structingMsg instanceof StructMsgForGeneralShare))) {
            break label490;
          }
          paramContext.putExtra("key_forward_share", true);
          paramContext.putExtra("key_forward_share_title", ((AbsShareMsg)paramChatMessage.structingMsg).mContentTitle);
          paramContext.putExtra("key_forward_image_share_uin_type", paramChatMessage.structingMsg.uinType);
          break label490;
          paramInt = 2;
          continue;
          paramInt = 7;
        }
        if (paramInt != 2131365352) {
          break;
        }
        aean.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
        if (aics.a((String)localObject6)) {
          bmbt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "3009", "2", "40053", aics.b((String)localObject6), new String[] { "5", "", aics.a((String)localObject6) });
        }
      } while ((paramChatMessage == null) || (!(paramChatMessage instanceof MessageForStructing)));
      paramContext = (MessageForStructing)paramChatMessage;
    } while ((paramContext.structingMsg == null) || (paramContext.structingMsg.mMsgServiceID != 81));
    yup.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramContext, "delete");
    return;
    long l2;
    long l1;
    if (paramInt == 2131371530)
    {
      super.d(paramChatMessage);
      if (aics.a((String)localObject6)) {
        bmbt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "3009", "2", "40053", aics.b((String)localObject6), new String[] { "6", "", aics.a((String)localObject6) });
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008)
      {
        paramContext = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(NetConnInfoCenter.getServerTimeMillis()));
        l2 = 0L;
        l1 = l2;
        if (paramChatMessage == null) {
          break label4353;
        }
        l1 = l2;
        if (!(paramChatMessage instanceof MessageForStructing)) {
          break label4353;
        }
        localObject1 = (MessageForStructing)paramChatMessage;
        l1 = l2;
        if (((MessageForStructing)localObject1).structingMsg == null) {
          break label4353;
        }
        l1 = l2;
        if (!(((MessageForStructing)localObject1).structingMsg instanceof AbsShareMsg)) {
          break label4353;
        }
        localObject1 = (AbsShareMsg)((MessageForStructing)localObject1).structingMsg;
        l2 = ((AbsShareMsg)localObject1).msgId;
        l1 = l2;
        if (!(localObject1 instanceof StructMsgForGeneralShare)) {
          break label4353;
        }
        localObject1 = (StructMsgForGeneralShare)localObject1;
        paramInt = StructMsgForGeneralShare.clickedItemIndex;
      }
    }
    for (;;)
    {
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X80064F7", "0X80064F7", 0, 0, paramContext, String.valueOf(l2), String.valueOf(paramInt), "");
      if ((paramChatMessage == null) || (!(paramChatMessage instanceof MessageForStructing))) {
        break;
      }
      paramContext = (MessageForStructing)paramChatMessage;
      if ((paramContext.structingMsg == null) || (paramContext.structingMsg.mMsgServiceID != 81)) {
        break;
      }
      yup.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramContext, "more");
      return;
      MessageForStructing localMessageForStructing;
      AbsShareMsg localAbsShareMsg;
      if (paramInt == 2131366320)
      {
        if ((paramChatMessage == null) || (!(paramChatMessage instanceof MessageForStructing))) {
          break;
        }
        localMessageForStructing = (MessageForStructing)paramChatMessage;
        if (localMessageForStructing.structingMsg == null) {
          break;
        }
        localAbsShareMsg = (AbsShareMsg)localMessageForStructing.structingMsg;
        if ((localAbsShareMsg instanceof StructMsgForImageShare))
        {
          i = 0;
          if (aics.a((String)localObject6))
          {
            localObject1 = localAbsShareMsg.mMsgActionData.substring(localAbsShareMsg.mMsgActionData.indexOf("|") + 1).split("\\|");
            paramInt = i;
            if (localObject1.length < 8) {
              break label4348;
            }
            if (!localObject1[7].equals("link"))
            {
              paramInt = i;
              if (!localObject1[7].equals("scrawl_link")) {
                break label4348;
              }
            }
            i = 1;
            paramInt = i;
            if (!localObject1[7].equals("scrawl_link")) {
              break label4348;
            }
            paramInt = i;
            if (localObject1.length <= 8) {
              break label4348;
            }
            paramContext = localObject1[8];
            paramInt = 1;
          }
        }
      }
      label3978:
      for (;;)
      {
        if ((paramInt == 0) && (!TextUtils.isEmpty(localAbsShareMsg.mMsg_A_ActionData)))
        {
          localObject1 = localAbsShareMsg.mMsg_A_ActionData.split("\\|");
          if ((localObject1.length >= 8) && (localObject1[7].equals("link"))) {
            paramInt = 1;
          }
        }
        label2201:
        label3746:
        for (;;)
        {
          label1715:
          Object localObject5;
          Object localObject4;
          if (paramInt != 0)
          {
            localObject2 = ((StructMsgForImageShare)localAbsShareMsg).getFirstImageElement();
            if (localObject2 == null) {
              break label4339;
            }
            if (((bdqr)localObject2).jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare == null) {
              ((bdqr)localObject2).jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare = ((StructMsgForImageShare)localAbsShareMsg);
            }
            localObject5 = aicv.a(((bdqr)localObject2).a());
            localObject4 = ((AIOImageData)localObject5).a(4);
            localObject2 = localObject4;
            if (localObject4 == null) {
              localObject2 = ((AIOImageData)localObject5).a(2);
            }
            if (localObject2 == null) {
              break label4339;
            }
          }
          label2391:
          Object localObject3;
          label2734:
          label2872:
          label3134:
          label4317:
          label4323:
          label4331:
          label4339:
          for (localObject2 = ((File)localObject2).getAbsolutePath();; localObject3 = null)
          {
            Object localObject7 = localObject1[3] + anzj.a(2131713380) + localObject1[5] + anzj.a(2131713386);
            localObject5 = "ADTAG=comic.plugin.read&id=" + localObject1[0] + "&name=" + URLEncoder.encode(localObject1[1]) + "&sectionID=" + localObject1[2] + "&sectionName=" + URLEncoder.encode(localObject1[3]) + "&pageID=" + localObject1[4] + "&page=" + localObject1[5] + "&type=" + localObject1[6];
            localObject4 = localObject5;
            if (!TextUtils.isEmpty(paramContext)) {
              localObject4 = (String)localObject5 + "&scrawl_link=" + URLEncoder.encode(paramContext);
            }
            paramContext = VipComicJumpActivity.a("comicReadShare", "5123", null, null, "354", null, (String)localObject4);
            new bmko(6).a("nLinkType", 0).b("sTitle", localObject1[1]).b("sUrl", paramContext).a("bAppShare", false).a("lAppId", 0L).b("sPublisher", localAbsShareMsg.mSourceName).b("sBrief", (String)localObject7).b("sPath", (String)localObject2).b("sResUrl", localAbsShareMsg.mSourceUrl).a("lCategory", 1L).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
            bmky.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 2);
            bmky.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 8, 0, localAbsShareMsg.uinType);
            bmbt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "3009", "2", "40053", aics.b((String)localObject6), new String[] { "3", "", aics.a((String)localObject6) });
            int j = 0;
            i = paramInt;
            paramInt = j;
            for (;;)
            {
              if ((i == 0) && (paramInt == 0))
              {
                i = 0;
                paramInt = i;
                if ((localAbsShareMsg instanceof StructMsgForImageShare))
                {
                  paramInt = i;
                  if (!localMessageForStructing.isSendFromLocal())
                  {
                    paramContext = ((StructMsgForImageShare)localAbsShareMsg).getFirstImageElement();
                    paramInt = localAbsShareMsg.uinType;
                    if ((paramContext != null) && (paramContext.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null))
                    {
                      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramContext.jdField_a_of_type_ComTencentMobileqqDataMessageForPic, 2);
                      ThreadManager.getFileThreadHandler().post(new StructingMsgItemBuilder.3(this, paramContext, paramInt, paramChatMessage));
                    }
                    paramInt = 1;
                  }
                }
                if (paramInt == 0)
                {
                  paramContext = bmlc.a((StructMsgForImageShare)localAbsShareMsg);
                  if (paramContext != null)
                  {
                    bmko.a(paramContext.ae, localAbsShareMsg.uinType, paramContext.ad, paramContext.c, paramContext.ac, paramContext.d).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
                    bmky.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2, 0, localAbsShareMsg.uinType);
                    bmky.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 3);
                  }
                }
              }
              while (localMessageForStructing.isMultiMsg)
              {
                i = 10;
                paramContext = localMessageForStructing.structingMsg;
                paramInt = i;
                if (paramContext != null) {}
                switch (paramContext.mMsgServiceID)
                {
                default: 
                  paramInt = i;
                  bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D67", "0X8009D67", paramInt, 0, "" + paramInt, "", "", "");
                  return;
                  paramInt = 0;
                  break label1715;
                  if (!aics.b((String)localObject6)) {
                    break label4331;
                  }
                  paramContext = aics.b((String)localObject6);
                  if ((paramContext == null) || (paramContext.length <= 2)) {
                    break label4331;
                  }
                  localObject2 = paramContext[1];
                  paramContext = paramContext[2];
                  paramContext = ((StructMsgForImageShare)localAbsShareMsg).getFirstImageElement();
                  if (paramContext != null)
                  {
                    if (paramContext.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare == null) {
                      paramContext.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare = ((StructMsgForImageShare)localAbsShareMsg);
                    }
                    localObject4 = aicv.a(paramContext.a());
                    localObject1 = ((AIOImageData)localObject4).a(4);
                    paramContext = (Context)localObject1;
                    if (localObject1 == null) {
                      paramContext = ((AIOImageData)localObject4).a(2);
                    }
                    if (paramContext != null) {
                      paramContext.getAbsolutePath();
                    }
                  }
                  paramContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
                  bmko.a((String)localObject2).c(paramContext).a((Activity)this.jdField_a_of_type_AndroidContentContext, paramContext);
                  bmky.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 7, 0, localAbsShareMsg.uinType);
                  bmky.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 2);
                  paramInt = 1;
                  i = 0;
                  break label2201;
                  if ((!(localAbsShareMsg instanceof StructMsgForGeneralShare)) || (localAbsShareMsg.mMsgServiceID != 35)) {
                    break label2734;
                  }
                  paramContext = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
                  if (paramContext != null)
                  {
                    paramContext = paramContext.a();
                    ((agvi)paramContext.a(11)).a(paramContext, null, (MessageForStructing)paramChatMessage);
                  }
                  break;
                }
              }
              if (!TextUtils.isEmpty(localAbsShareMsg.mMsgActionData))
              {
                String[] arrayOfString1 = localAbsShareMsg.mMsgActionData.split("&");
                i = arrayOfString1.length;
                localObject4 = null;
                localObject2 = null;
                localObject1 = null;
                paramContext = null;
                paramInt = 0;
                if (paramInt < i)
                {
                  String[] arrayOfString2 = arrayOfString1[paramInt].split("=");
                  localObject5 = localObject4;
                  localObject6 = localObject2;
                  localObject7 = localObject1;
                  Object localObject8 = paramContext;
                  if (arrayOfString2.length > 1)
                  {
                    if (!arrayOfString2[0].trim().equals("lat")) {
                      break label2872;
                    }
                    localObject8 = arrayOfString2[1];
                    localObject7 = localObject1;
                    localObject6 = localObject2;
                    localObject5 = localObject4;
                  }
                  for (;;)
                  {
                    paramInt += 1;
                    localObject4 = localObject5;
                    localObject2 = localObject6;
                    localObject1 = localObject7;
                    paramContext = (Context)localObject8;
                    break;
                    if (arrayOfString2[0].trim().equals("lon"))
                    {
                      localObject7 = arrayOfString2[1];
                      localObject5 = localObject4;
                      localObject6 = localObject2;
                      localObject8 = paramContext;
                    }
                    else if (arrayOfString2[0].trim().equals("loc"))
                    {
                      localObject6 = arrayOfString2[1];
                      localObject5 = localObject4;
                      localObject7 = localObject1;
                      localObject8 = paramContext;
                    }
                    else
                    {
                      localObject5 = localObject4;
                      localObject6 = localObject2;
                      localObject7 = localObject1;
                      localObject8 = paramContext;
                      if (arrayOfString2[0].trim().equals("title"))
                      {
                        localObject5 = arrayOfString2[1];
                        localObject6 = localObject2;
                        localObject7 = localObject1;
                        localObject8 = paramContext;
                      }
                    }
                  }
                }
                if ((localAbsShareMsg.mMsgServiceID == 32) && (!TextUtils.isEmpty(paramContext)) && (!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject2)))
                {
                  bmko.a(Float.valueOf(paramContext).floatValue(), Float.valueOf((String)localObject1).floatValue(), (String)localObject4, (String)localObject2, null).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
                  bmky.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 11, 0, localAbsShareMsg.uinType);
                  bmky.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 7);
                  return;
                }
              }
              localObject4 = bmlc.a(localAbsShareMsg.getXmlBytes());
              paramContext = localAbsShareMsg.mContentCover;
              if ((localAbsShareMsg instanceof StructMsgForAudioShare))
              {
                paramInt = 2;
                i = 10;
              }
              for (;;)
              {
                if ((localAbsShareMsg.mMsgServiceID == 14) || (localAbsShareMsg.mMsgServiceID == 84))
                {
                  paramContext = new ArrayList();
                  localObject1 = new JSONObject();
                }
                for (;;)
                {
                  try
                  {
                    ((JSONObject)localObject1).put("bFriendCard", true);
                    ((JSONObject)localObject1).put("jumpUrl", localAbsShareMsg.mContentCover);
                    localObject1 = ((JSONObject)localObject1).toString().getBytes();
                    if (localObject1 != null) {
                      paramContext.add(localObject1);
                    }
                    paramContext.add(localAbsShareMsg.getXml().getBytes());
                    bmko.a(null, false, localAbsShareMsg.mContentTitle, localAbsShareMsg.mContentSummary, false, 0L, "").b("sBizDataList", paramContext).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
                    bmky.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 10, 0, localAbsShareMsg.uinType);
                    bmky.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, i);
                    break label2391;
                    if ((!(localAbsShareMsg instanceof StructMsgForGeneralShare)) || (!((StructMsgForGeneralShare)localAbsShareMsg).mIsPAVideoStructMsg)) {
                      break label4323;
                    }
                    localObject2 = (StructMsgForGeneralShare)localAbsShareMsg;
                    paramInt = 0;
                    if (paramInt >= ((StructMsgForGeneralShare)localObject2).getItemCount()) {
                      break label4323;
                    }
                    localObject1 = ((StructMsgForGeneralShare)localObject2).getItemByIndex(paramInt);
                    if ((localObject1 instanceof bdsg))
                    {
                      localObject5 = ((bdsg)localObject1).a.iterator();
                      localObject1 = paramContext;
                      if (!((Iterator)localObject5).hasNext()) {
                        break label4317;
                      }
                      localObject1 = (bdol)((Iterator)localObject5).next();
                      if (!(localObject1 instanceof bdts)) {
                        continue;
                      }
                      localObject5 = (bdts)localObject1;
                      paramContext = ((bdts)localObject5).ac;
                      localObject1 = paramContext;
                      if (!((bdts)localObject5).a()) {
                        break label4317;
                      }
                      odr.a("0X8006601", ((StructMsgForGeneralShare)localAbsShareMsg).uinType, odr.a(((bdts)localObject5).v, ((StructMsgForGeneralShare)localObject2).mSourceName), ((bdts)localObject5).ae, "");
                      i = 2;
                      paramInt = 0;
                      break label3134;
                    }
                    paramInt += 1;
                    continue;
                  }
                  catch (JSONException localJSONException)
                  {
                    localJSONException.printStackTrace();
                    continue;
                  }
                  if (localAbsShareMsg.uinType == 1008)
                  {
                    localObject3 = bhlg.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), true);
                    localObject1 = localObject3;
                    if (TextUtils.isEmpty((CharSequence)localObject3)) {
                      localObject1 = localAbsShareMsg.mContentSrc;
                    }
                    bmko.a(paramInt, localAbsShareMsg.mContentTitle, localAbsShareMsg.mMsgUrl, localAbsShareMsg.mSourceName, localAbsShareMsg.mContentSummary, paramContext, (String)localObject1, (byte[])localObject4, false, 0L).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a("lCategory", 10L).b("sUin", localAbsShareMsg.mSourceName).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
                    bmky.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 8, 0, localAbsShareMsg.uinType);
                  }
                  else
                  {
                    localObject6 = new ArrayList();
                    localObject5 = localAbsShareMsg.mContentSummary;
                    if (a(localAbsShareMsg))
                    {
                      ((ArrayList)localObject6).add(bmkq.a(true));
                      j = paramInt;
                      localObject1 = localObject5;
                      localObject3 = localObject4;
                      if (!TextUtils.isEmpty(localAbsShareMsg.mMsgUrl))
                      {
                        j = paramInt;
                        localObject1 = localObject5;
                        localObject3 = localObject4;
                        if (localAbsShareMsg.mMsgUrl.indexOf("action=accountCard") > -1)
                        {
                          ((ArrayList)localObject6).add(localAbsShareMsg.getXml().getBytes());
                          j = 7;
                          localObject3 = localObject4;
                          localObject1 = localObject5;
                        }
                      }
                      if ((j != 6) && (j != 7)) {
                        break label3978;
                      }
                      bmky.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 10, 0, localAbsShareMsg.uinType);
                    }
                    for (;;)
                    {
                      bmko.a(j, localAbsShareMsg.mContentTitle, localAbsShareMsg.mMsgUrl, localAbsShareMsg.mSourceName, (String)localObject1, paramContext, localAbsShareMsg.mContentSrc, (byte[])localObject3, false, 0L).b("sBizDataList", (ArrayList)localObject6).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
                      break;
                      j = paramInt;
                      localObject1 = localObject5;
                      localObject3 = localObject4;
                      if (TextUtils.isEmpty(localAbsShareMsg.mMsgUrl)) {
                        break label3746;
                      }
                      j = paramInt;
                      localObject1 = localObject5;
                      localObject3 = localObject4;
                      if (localAbsShareMsg.mMsgUrl.indexOf("jq.qq.com") <= -1) {
                        break label3746;
                      }
                      ((ArrayList)localObject6).add(localAbsShareMsg.getXml().getBytes());
                      paramInt = 6;
                      localObject7 = a(localAbsShareMsg.mContentCover);
                      j = paramInt;
                      localObject1 = localObject5;
                      localObject3 = localObject4;
                      if (TextUtils.isEmpty((CharSequence)localObject7)) {
                        break label3746;
                      }
                      localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131697421) + (String)localObject7;
                      localObject3 = null;
                      j = paramInt;
                      break label3746;
                      if (becb.a(localAbsShareMsg.mMsgUrl)) {
                        bmky.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 12, 0, localAbsShareMsg.uinType);
                      } else {
                        bmky.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 8, 0, localAbsShareMsg.uinType);
                      }
                    }
                    paramInt = 2;
                    break label2451;
                    paramInt = 7;
                    break label2451;
                    if (paramInt == 2131365191)
                    {
                      paramContext = (MessageForStructing)paramChatMessage;
                      if ((paramContext == null) || (paramContext.structingMsg == null) || (!"web".equals(paramContext.structingMsg.mMsgAction)) || (paramContext.structingMsg.mMsgUrl == null)) {
                        break;
                      }
                      ((ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(paramContext.structingMsg.mMsgUrl);
                      return;
                    }
                    if (paramInt == 2131371519)
                    {
                      d(paramChatMessage);
                      return;
                    }
                    if (paramInt == 2131367100)
                    {
                      ThreadManager.post(new StructingMsgItemBuilder.4(this, paramChatMessage, paramContext), 8, null, false);
                      return;
                    }
                    if (paramInt == 2131371487)
                    {
                      super.a(paramChatMessage);
                      if (aics.a((String)localObject6)) {
                        bmbt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "3009", "2", "40053", aics.b((String)localObject6), new String[] { "4", "", aics.a((String)localObject6) });
                      }
                      if ((paramChatMessage == null) || (!(paramChatMessage instanceof MessageForStructing))) {
                        break;
                      }
                      paramContext = (MessageForStructing)paramChatMessage;
                      if ((paramContext.structingMsg == null) || (paramContext.structingMsg.mMsgServiceID != 81)) {
                        break;
                      }
                      yup.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramContext, "withdraw");
                      return;
                    }
                    if (paramInt == 2131364167)
                    {
                      paramContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramChatMessage.frienduin, paramChatMessage.uniseq);
                      if ((paramContext == null) || (!(paramContext instanceof berp))) {
                        break;
                      }
                      ((berp)paramContext).a();
                      return;
                    }
                    super.a(paramInt, paramContext, paramChatMessage);
                    return;
                    paramContext = (Context)localObject1;
                  }
                }
                i = 2;
                paramInt = 0;
              }
              paramInt = 0;
              i = 0;
            }
          }
        }
        label2451:
        label4348:
        paramContext = null;
      }
      label4353:
      paramInt = 0;
      l2 = l1;
    }
  }
  
  public void a(int paramInt, ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, ViewGroup paramViewGroup)
  {
    Object localObject = AIOLongShotHelper.a();
    if ((localObject != null) && (((AIOLongShotHelper)localObject).a())) {
      super.a(paramInt, paramChatMessage, paramBaseChatItemLayout, paramViewGroup);
    }
    do
    {
      do
      {
        return;
        if ((!BaseChatItemLayout.jdField_a_of_type_Boolean) || (!(paramChatMessage instanceof MessageForStructing))) {
          break label160;
        }
        localObject = ((MessageForStructing)paramChatMessage).structingMsg;
        if ((!paramChatMessage.isSendFromLocal()) || (!(localObject instanceof AbsShareMsg)) || (!((AbsShareMsg)localObject).isSdkShareMsg()) || ((paramChatMessage.extraflag != 32772) && (paramChatMessage.extraflag != 32768))) {
          break;
        }
      } while ((paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetCheckBox == null) || (paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetCheckBox.getVisibility() != 0));
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
      return;
      if (((AbsStructMsg)localObject).mMsgServiceID != 14) {
        break;
      }
    } while ((paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetCheckBox == null) || (paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetCheckBox.getVisibility() != 0));
    paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
    return;
    label160:
    super.a(paramInt, paramChatMessage, paramBaseChatItemLayout, paramViewGroup);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (agej.a(paramView).isMultiMsg) {}
    Object localObject2;
    ChatMessage localChatMessage;
    String str1;
    do
    {
      do
      {
        return;
        localObject1 = agej.a(paramView);
      } while (!ahtm.class.isInstance(localObject1));
      localObject2 = this.jdField_a_of_type_AndroidContentContext;
      localChatMessage = ((ahtm)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      localObject1 = a(localChatMessage);
      if (localObject1 != null)
      {
        a(paramView, (StructMsgForGeneralShare)localObject1);
        return;
      }
      paramView = ((Context)localObject2).getString(2131689933);
      str1 = ((Context)localObject2).getString(2131689934);
    } while (!localChatMessage.isSendFromLocal());
    Object localObject1 = localChatMessage.getExtInfoFromExtStr("errorString");
    String str2 = localChatMessage.getExtInfoFromExtStr("retCode");
    String str3 = localChatMessage.getExtInfoFromExtStr("import_file_message_flag");
    boolean bool;
    if ((str3 != null) && ("import_file_message_flag_value".equals(str3)))
    {
      bool = String.valueOf(-1000).equals(str2);
      if (bool)
      {
        paramView = anzj.a(2131713383);
        localObject2 = anzj.a(2131713384);
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label282;
        }
      }
    }
    for (;;)
    {
      localObject2 = (blir)blji.a(this.jdField_a_of_type_AndroidContentContext, null);
      ((blir)localObject2).c(paramView);
      ((blir)localObject2).d(this.jdField_a_of_type_AndroidContentContext.getString(2131690580));
      ((blir)localObject2).a((CharSequence)localObject1);
      ((blir)localObject2).a(new ahth(this, bool, localChatMessage, (blir)localObject2));
      ((blir)localObject2).show();
      return;
      paramView = anzj.a(2131713385);
      break;
      bhlq.a((Context)localObject2, 230, paramView, str1, new ahti(this, localChatMessage, (Context)localObject2), new ahtj(this)).show();
      return;
      label282:
      localObject1 = localObject2;
    }
  }
  
  public void a(View paramView, bete parambete, int paramInt1, int paramInt2)
  {
    if (!BaseChatItemLayout.class.isInstance(paramView)) {}
    do
    {
      return;
      if ((parambete.jdField_b_of_type_Int == 1) || (parambete.jdField_b_of_type_Int == 131075))
      {
        b(paramView, parambete, paramInt1, paramInt2);
        return;
      }
    } while (parambete.jdField_b_of_type_Int != 52);
    c(paramView, parambete, paramInt1, paramInt2);
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    super.a(paramView, paramChatMessage);
    MessageForStructing localMessageForStructing;
    int i;
    if ((paramChatMessage instanceof MessageForStructing))
    {
      localMessageForStructing = (MessageForStructing)paramChatMessage;
      boolean bool = txx.a(localMessageForStructing.structingMsg);
      if (((bool) && (!localMessageForStructing.structingMsg.hasFlag(4))) || (localMessageForStructing.structingMsg.mMsgServiceID == 83) || (localMessageForStructing.structingMsg.mMsgServiceID == 108) || (localMessageForStructing.structingMsg.mMsgServiceID == 151) || (localMessageForStructing.structingMsg.mMsgServiceID == 156))
      {
        if ((!bool) || (localMessageForStructing.structingMsg.hasFlag(4))) {
          break label201;
        }
        i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296335);
        if (!paramChatMessage.isSend()) {
          break label261;
        }
        paramView.setPadding(BaseChatItemLayout.k, BaseChatItemLayout.h, i, BaseChatItemLayout.i);
      }
    }
    for (;;)
    {
      if (localMessageForStructing.structingMsg.mMsgServiceID == 107)
      {
        paramChatMessage = this.jdField_a_of_type_AndroidContentContext.getResources();
        paramView.setPadding(agej.a(1.5F, paramChatMessage), agej.a(2.0F, paramChatMessage), agej.a(1.5F, paramChatMessage), paramView.getPaddingBottom());
      }
      return;
      label201:
      if ((localMessageForStructing.structingMsg.mMsgServiceID == 114) || (localMessageForStructing.structingMsg.mMsgServiceID == 116))
      {
        i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296336);
        break;
      }
      i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296340);
      break;
      label261:
      paramView.setPadding(i, BaseChatItemLayout.h, BaseChatItemLayout.k, BaseChatItemLayout.i);
    }
  }
  
  public void a(View paramView, ChatMessage paramChatMessage, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StructingMsgItemBuilder", 2, "updateView type=" + paramInt + ",message=" + paramChatMessage);
    }
    if (paramInt == 891)
    {
      Object localObject = paramView.getTag();
      if (((localObject instanceof ahtm)) && ((paramChatMessage instanceof MessageForStructing)))
      {
        localObject = (ahtm)localObject;
        BaseChatItemLayout localBaseChatItemLayout = ((ahtm)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
        paramChatMessage = (MessageForStructing)paramChatMessage;
        AbsStructMsg localAbsStructMsg = paramChatMessage.structingMsg;
        if (localAbsStructMsg != null) {
          localAbsStructMsg.message = paramChatMessage;
        }
        a((ahtm)localObject, localBaseChatItemLayout, paramChatMessage.isSend(), localAbsStructMsg, paramView.getResources(), a(paramChatMessage));
      }
      return;
    }
    super.a(paramView, paramChatMessage, paramInt);
  }
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, aggl paramaggl, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramaggl, paramInt1, paramInt2);
    if ((!(paramChatMessage instanceof MessageForStructing)) || (((MessageForStructing)paramChatMessage).structingMsg == null)) {}
    do
    {
      return;
      paramBaseChatItemLayout = (MessageForStructing)paramChatMessage;
      paramInt1 = paramBaseChatItemLayout.structingMsg.mMsgServiceID;
    } while ((a(paramBaseChatItemLayout)) || (paramInt1 == 83) || (paramInt1 == 151) || (paramInt1 == 156) || (paramInt1 == 108) || (paramInt1 == 114) || (paramInt1 == 98) || (paramInt1 == 97) || (paramInt1 == 5) || (paramInt1 == 137) || (paramInt1 == 106) || (paramInt1 == 107) || (paramInt1 == 122) || (paramInt1 == 116));
    paramInt2 = paramaggl.jdField_a_of_type_AndroidViewView.getPaddingLeft();
    int i = paramaggl.jdField_a_of_type_AndroidViewView.getPaddingRight();
    int m = paramaggl.jdField_a_of_type_AndroidViewView.getPaddingTop();
    int n = paramaggl.jdField_a_of_type_AndroidViewView.getPaddingBottom();
    int j = agej.a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    boolean bool = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    int k;
    if (paramChatMessage.isSend())
    {
      paramInt1 = paramInt2;
      if (paramInt2 > j) {
        paramInt1 = paramInt2 - j;
      }
      paramaggl.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130850006);
      j = paramInt1;
      k = i;
      if (bool)
      {
        j = paramInt1;
        k = i;
        if (paramaggl.jdField_a_of_type_AndroidViewView.getParent() != null)
        {
          j = paramInt1;
          k = i;
          if ((paramaggl.jdField_a_of_type_AndroidViewView.getParent() instanceof RelativeLayout))
          {
            paramBaseChatItemLayout = (RelativeLayout)paramaggl.jdField_a_of_type_AndroidViewView.getParent();
            paramContext = new View(paramContext);
            localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
            localLayoutParams.addRule(6, 2131364423);
            localLayoutParams.addRule(5, 2131364423);
            localLayoutParams.addRule(7, 2131364423);
            localLayoutParams.addRule(8, 2131364423);
            if (paramaggl.jdField_b_of_type_AndroidViewView != null) {
              paramBaseChatItemLayout.removeView(paramaggl.jdField_b_of_type_AndroidViewView);
            }
            if (!axpm.a(paramChatMessage)) {
              break label440;
            }
            paramContext.setBackgroundResource(2130850003);
            paramaggl.jdField_b_of_type_AndroidViewView = paramContext;
            paramBaseChatItemLayout.addView(paramaggl.jdField_b_of_type_AndroidViewView, localLayoutParams);
            k = i;
            j = paramInt1;
          }
        }
      }
    }
    label440:
    do
    {
      do
      {
        do
        {
          paramaggl.jdField_a_of_type_AndroidViewView.setPadding(j, m, k, n);
          return;
          paramContext.setBackgroundResource(2130850002);
          break;
          paramInt1 = i;
          if (i > j) {
            paramInt1 = i - j;
          }
          paramaggl.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130849830);
          j = paramInt2;
          k = paramInt1;
        } while (!bool);
        j = paramInt2;
        k = paramInt1;
      } while (paramaggl.jdField_a_of_type_AndroidViewView.getParent() == null);
      j = paramInt2;
      k = paramInt1;
    } while (!(paramaggl.jdField_a_of_type_AndroidViewView.getParent() instanceof RelativeLayout));
    paramBaseChatItemLayout = (RelativeLayout)paramaggl.jdField_a_of_type_AndroidViewView.getParent();
    paramContext = new View(paramContext);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(6, 2131364423);
    localLayoutParams.addRule(5, 2131364423);
    localLayoutParams.addRule(7, 2131364423);
    localLayoutParams.addRule(8, 2131364423);
    if (paramaggl.jdField_b_of_type_AndroidViewView != null) {
      paramBaseChatItemLayout.removeView(paramaggl.jdField_b_of_type_AndroidViewView);
    }
    if (axpm.a(paramChatMessage)) {
      paramContext.setBackgroundResource(2130849827);
    }
    for (;;)
    {
      paramaggl.jdField_b_of_type_AndroidViewView = paramContext;
      paramBaseChatItemLayout.addView(paramaggl.jdField_b_of_type_AndroidViewView, localLayoutParams);
      j = paramInt2;
      k = paramInt1;
      break;
      paramContext.setBackgroundResource(2130849826);
    }
  }
  
  public void a(MessageForStructing paramMessageForStructing) {}
  
  public void a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage, long paramLong, float paramFloat) {}
  
  public void a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage, boolean paramBoolean)
  {
    paramXListView = agej.a(paramView);
    if ((paramXListView instanceof ahtm)) {}
    for (paramXListView = (ahtm)paramXListView;; paramXListView = null)
    {
      if (paramXListView != null)
      {
        paramXListView = (ViewGroup)paramXListView.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
        int i = paramXListView.getChildCount();
        paramInt = 0;
        while (paramInt < i)
        {
          if ((paramXListView.getChildAt(paramInt).getTag() instanceof bdqu))
          {
            paramView = (bdqu)paramXListView.getChildAt(paramInt).getTag();
            if ((paramView.jdField_a_of_type_AndroidViewView.getTag() instanceof bdtc))
            {
              paramView = (ImageView)((bdtc)paramView.jdField_a_of_type_AndroidViewView.getTag()).jdField_c_of_type_AndroidViewView;
              paramView.clearAnimation();
              paramView.setBackgroundResource(2130841785);
            }
          }
          paramInt += 1;
        }
      }
      return;
    }
  }
  
  public boolean a(int paramInt)
  {
    boolean bool2 = false;
    int[] arrayOfInt = jdField_a_of_type_ArrayOfInt;
    int j = arrayOfInt.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (paramInt == arrayOfInt[i]) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public boolean a(aggl paramaggl)
  {
    return paramaggl instanceof ahtm;
  }
  
  boolean a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, long paramLong, String paramString13)
  {
    String str1 = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.pubaccount.AccountDetailActivity&uin=" + paramString1;
    String str2 = "mqqapi://card/show_pslcard?src_type=internal&card_type=public_account&uin=" + paramString1 + "&version=1";
    paramString1 = new Intent();
    paramString1.setClass(paramContext, ForwardRecentActivity.class);
    paramString1.putExtra("key_flag_from_plugin", true);
    paramString1.putExtra("strurt_msgid", String.valueOf(paramLong));
    paramString1.putExtra("struct_uin", paramString13);
    paramString1.putExtra("forward_type", 1001);
    paramString1.putExtra("image_url_remote", paramString4);
    paramString1.putExtra("title", paramString2);
    paramString1.putExtra("desc", paramString3);
    paramString1.putExtra("pluginName", "public_account");
    paramString1.putExtra("detail_url", paramString6);
    paramString1.putExtra("app_name", paramString5);
    if (("replyMsg".equals(paramString8)) || ("replyCmd".equals(paramString8))) {}
    for (;;)
    {
      paramString1.putExtra("req_type", 1);
      paramString1.putExtra("req_share_id", -1);
      paramString1.putExtra("brief_key", paramString12);
      paramString1.putExtra("struct_share_key_source_icon", paramString7);
      paramString1.putExtra("struct_share_key_source_action", "plugin");
      paramString1.putExtra("struct_share_key_source_action_data", str1);
      paramString1.putExtra("struct_share_key_source_a_action_data", str1);
      paramString1.putExtra("struct_share_key_source_i_action_data", str2);
      paramString1.putExtra("forward _key_nojump", true);
      paramString2 = bdow.a(paramString1.getExtras());
      if (paramString2 == null) {
        break;
      }
      paramString1.putExtra("stuctmsg_bytes", paramString2.getBytes());
      paramString1.putExtra("k_struct_forward", true);
      paramContext.startActivity(paramString1);
      return true;
      paramString1.putExtra("struct_share_key_content_action", paramString8);
      paramString1.putExtra("struct_share_key_content_action_DATA", paramString9);
      paramString1.putExtra("struct_share_key_content_a_action_DATA", paramString10);
      paramString1.putExtra("struct_share_key_content_i_action_DATA", paramString11);
    }
    return false;
  }
  
  public boolean a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (paramChatMessage.isMultiMsg) {}
    Object localObject;
    do
    {
      return false;
      localObject = (MessageForStructing)paramChatMessage;
      if ((((MessageForStructing)localObject).structingMsg != null) && (StructMsgForImageShare.class.isInstance(((MessageForStructing)localObject).structingMsg)) && (paramChatMessage.isSendFromLocal()))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramChatMessage.frienduin, paramChatMessage.istroop, paramChatMessage.uniseq);
        if (!(localObject instanceof MessageForStructing)) {
          break;
        }
        localObject = (StructMsgForImageShare)((MessageForStructing)localObject).structingMsg;
        if (localObject == null) {
          break;
        }
        localObject = ((StructMsgForImageShare)localObject).getFirstImageElement();
        if ((localObject == null) || (((bdqr)localObject).d > 0L)) {
          break;
        }
        paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramChatMessage.frienduin, paramChatMessage.uniseq);
        if ((paramChatMessage instanceof berp))
        {
          if (((berp)paramChatMessage).c() == 1005L) {}
          for (boolean bool = true;; bool = false) {
            return bool;
          }
        }
        return true;
      }
      if (b((MessageForStructing)localObject))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageForStructing)localObject).frienduin, ((MessageForStructing)localObject).uniseq) != null) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("StructingMsgItemBuilder", 2, "isFailed| Sdk share msg, processor not exist.");
        }
        return true;
      }
    } while ((((MessageForStructing)localObject).structingMsg != null) && ((((MessageForStructing)localObject).structingMsg instanceof StructMsgForGeneralShare)) && (((StructMsgForGeneralShare)((MessageForStructing)localObject).structingMsg).mMsgServiceID == 95) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramChatMessage)));
    return super.a(paramChatMessage, paramBaseChatItemLayout);
  }
  
  protected boolean a(MessageForStructing paramMessageForStructing)
  {
    paramMessageForStructing = paramMessageForStructing.structingMsg;
    boolean bool = paramMessageForStructing.hasFlag(4);
    if (((paramMessageForStructing instanceof AbsShareMsg)) && (((AbsShareMsg)paramMessageForStructing).mMsgException)) {
      bool = true;
    }
    for (;;)
    {
      if ((paramMessageForStructing.mMsgServiceID == 76) || (paramMessageForStructing.mMsgServiceID == 91)) {
        bool = true;
      }
      return bool;
    }
  }
  
  protected boolean a(MessageForStructing paramMessageForStructing, AbsStructMsg paramAbsStructMsg)
  {
    if (((paramAbsStructMsg instanceof AbsShareMsg)) && (((AbsShareMsg)paramAbsStructMsg).mMsgException)) {
      return false;
    }
    if (paramAbsStructMsg.mMsgServiceID == 86) {
      return false;
    }
    if (paramAbsStructMsg.mMsgServiceID == 61) {
      return false;
    }
    if (paramAbsStructMsg.mMsgServiceID == 91) {
      return false;
    }
    if (paramAbsStructMsg.mMsgServiceID == 97) {
      return false;
    }
    if (paramAbsStructMsg.mMsgServiceID == 98) {
      return false;
    }
    if ((paramAbsStructMsg instanceof StructMsgForHypertext)) {
      return false;
    }
    if ((paramMessageForStructing.isSendFromLocal()) && ((paramAbsStructMsg instanceof AbsShareMsg)) && (((AbsShareMsg)paramAbsStructMsg).isSdkShareMsg()))
    {
      if (paramMessageForStructing.extraflag == 32772) {
        break label131;
      }
      if (paramMessageForStructing.extraflag == 32768) {
        return false;
      }
    }
    return true;
    label131:
    return false;
  }
  
  public boolean a(AbsShareMsg paramAbsShareMsg)
  {
    if (paramAbsShareMsg == null) {}
    do
    {
      return false;
      if (tzq.b(paramAbsShareMsg.mMsgUrl)) {
        return true;
      }
    } while (((TextUtils.isEmpty(paramAbsShareMsg.mSource_A_ActionData)) || (!paramAbsShareMsg.mSource_A_ActionData.contains("pubaccount"))) && ((TextUtils.isEmpty(paramAbsShareMsg.mSource_I_ActionData)) || (!paramAbsShareMsg.mSource_I_ActionData.contains("public_account"))));
    return true;
  }
  
  protected boolean a(AbsStructMsg paramAbsStructMsg)
  {
    return (!paramAbsStructMsg.hasFlag(2)) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1008) || (!TextUtils.isEmpty(paramAbsStructMsg.mMsgUrl))) && (paramAbsStructMsg.mMsgServiceID != 81) && (paramAbsStructMsg.mMsgServiceID != 14);
  }
  
  protected boolean a(AbsStructMsg paramAbsStructMsg, bhuk parambhuk)
  {
    boolean bool2 = true;
    int i = 0;
    boolean bool1;
    if ((paramAbsStructMsg == null) || (parambhuk == null) || (this.jdField_a_of_type_AndroidContentContext == null)) {
      bool1 = false;
    }
    int j;
    do
    {
      return bool1;
      this.jdField_a_of_type_AndroidContentContext.getResources();
      if (paramAbsStructMsg.mMsgServiceID != 35) {
        break;
      }
      j = parambhuk.a();
      bool1 = bool2;
    } while (j <= 0);
    for (;;)
    {
      bool1 = bool2;
      if (i >= j) {
        break;
      }
      paramAbsStructMsg = parambhuk.a(i);
      if (paramAbsStructMsg != null)
      {
        bool1 = bool2;
        if (paramAbsStructMsg.a() == 2131366320) {
          break;
        }
      }
      i += 1;
    }
    return false;
  }
  
  public boolean a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage)
  {
    paramXListView = agej.a(paramView);
    if ((paramXListView instanceof ahtm)) {}
    for (paramXListView = (ahtm)paramXListView;; paramXListView = null)
    {
      if (paramXListView != null)
      {
        paramXListView = (ViewGroup)paramXListView.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
        int i = paramXListView.getChildCount();
        paramInt = 0;
        while (paramInt < i)
        {
          if ((paramXListView.getChildAt(paramInt).getTag() instanceof bdqu))
          {
            paramView = (bdqu)paramXListView.getChildAt(paramInt).getTag();
            if ((paramView.jdField_a_of_type_AndroidViewView.getTag() instanceof bdtc)) {
              return bhmi.b(((bdtc)paramView.jdField_a_of_type_AndroidViewView.getTag()).jdField_a_of_type_JavaLangString);
            }
          }
          paramInt += 1;
        }
      }
      return false;
    }
  }
  
  public boolean a(XListView paramXListView, int paramInt1, View paramView, ChatMessage paramChatMessage, AudioPlayerBase paramAudioPlayerBase, int paramInt2)
  {
    Object localObject = agej.a(paramView);
    if ((localObject instanceof ahtm)) {}
    for (localObject = (ahtm)localObject;; localObject = null)
    {
      if (localObject != null)
      {
        localObject = (ViewGroup)((ahtm)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
        int i = ((ViewGroup)localObject).getChildCount();
        paramInt2 = 0;
        while (paramInt2 < i)
        {
          if (((((ViewGroup)localObject).getChildAt(paramInt2).getTag() instanceof bdqu)) && (a(paramXListView, paramInt1, paramView, paramChatMessage)))
          {
            bdqu localbdqu = (bdqu)((ViewGroup)localObject).getChildAt(paramInt2).getTag();
            if ((localbdqu.jdField_a_of_type_AndroidViewView.getTag() instanceof bdtc)) {
              paramAudioPlayerBase.a(((bdtc)localbdqu.jdField_a_of_type_AndroidViewView.getTag()).jdField_a_of_type_JavaLangString);
            }
          }
          paramInt2 += 1;
        }
        return true;
      }
      return false;
    }
  }
  
  public bhum[] a(View paramView)
  {
    paramView = (MessageForStructing)agej.a(paramView);
    bhuk localbhuk = new bhuk();
    if (paramView != null)
    {
      if (!paramView.isMultiMsg) {
        break label40;
      }
      a(localbhuk, paramView, null);
    }
    for (;;)
    {
      return localbhuk.a();
      label40:
      b(localbhuk, paramView, null);
    }
  }
  
  public void a_(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForStructing)))
    {
      paramChatMessage = (MessageForStructing)paramChatMessage;
      if ((paramChatMessage.structingMsg == null) || (!(paramChatMessage.structingMsg instanceof StructMsgForGeneralShare)) || (((StructMsgForGeneralShare)paramChatMessage.structingMsg).mMsgServiceID != 95)) {
        break label105;
      }
    }
    label105:
    for (int i = 7;; i = 5)
    {
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5A7", "0X800A5A7", 0, 0, "" + i, "", "", "");
      return;
    }
  }
  
  public bhuk b(bhuk parambhuk, ChatMessage paramChatMessage, aghd paramaghd)
  {
    MessageForStructing localMessageForStructing = (MessageForStructing)paramChatMessage;
    AbsStructMsg localAbsStructMsg = localMessageForStructing.structingMsg;
    if (localAbsStructMsg != null)
    {
      if (a(parambhuk, localMessageForStructing, localAbsStructMsg)) {
        return parambhuk;
      }
      if ((localAbsStructMsg instanceof StructMsgForImageShare))
      {
        bdqr localbdqr = ((StructMsgForImageShare)localAbsStructMsg).getFirstImageElement();
        if (localbdqr == null) {
          break label787;
        }
        paramaghd = localbdqr.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
        if (paramaghd != null) {
          break label784;
        }
        if (localbdqr.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare == null)
        {
          localbdqr.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare = ((StructMsgForImageShare)localAbsStructMsg);
          localbdqr.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.message = localMessageForStructing;
        }
        localbdqr.a(this.jdField_a_of_type_AndroidContentContext, null, null);
        paramaghd = localbdqr.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
      }
    }
    for (;;)
    {
      int i;
      if ((paramaghd != null) && (beyq.a(this.jdField_a_of_type_AndroidContentContext, paramaghd, 65537)))
      {
        i = 1;
        if ((paramaghd == null) || (paramaghd.imageType != 2000)) {
          break label176;
        }
      }
      label176:
      for (int j = 1;; j = 0)
      {
        if ((i != 0) || (j != 0)) {
          break label182;
        }
        super.e(parambhuk, this.jdField_a_of_type_AndroidContentContext);
        return parambhuk;
        i = 0;
        break;
      }
      label182:
      parambhuk.a(2131362195, this.jdField_a_of_type_AndroidContentContext.getString(2131692954), 2130838937);
      paramaghd = this.jdField_a_of_type_AndroidContentContext.getResources();
      if (localAbsStructMsg.fwFlag != 1)
      {
        if (localAbsStructMsg.hasFlag(8)) {
          parambhuk.a(2131365191, paramaghd.getString(2131691139), 2130838931);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008) {
          if (!localAbsStructMsg.hasFlag(32))
          {
            parambhuk.a(2131367100, paramaghd.getString(2131692400), 2130838939);
            a(localMessageForStructing, parambhuk);
            if (localAbsStructMsg.hasFlag(2)) {
              break label772;
            }
            if (((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008) && (TextUtils.isEmpty(localAbsStructMsg.mMsgUrl))) || (localAbsStructMsg.mMsgServiceID == 81)) {
              break label778;
            }
            if (localAbsStructMsg.mMsgServiceID != 14) {
              break label759;
            }
            j = 0;
          }
        }
      }
      for (;;)
      {
        label349:
        i = j;
        if (localAbsStructMsg.mMsgServiceID == 21)
        {
          i = j;
          if (localAbsStructMsg.mMsgActionData != null)
          {
            i = j;
            if (!localAbsStructMsg.mMsgActionData.startsWith("mqqwpa://im/chat")) {}
          }
        }
        label772:
        for (i = 0;; i = 0)
        {
          a(parambhuk, localMessageForStructing, localAbsStructMsg);
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1008) || (parambhuk.a() == 0)) {
            a(parambhuk, localMessageForStructing);
          }
          j = i;
          if (localAbsStructMsg != null) {
            if (localAbsStructMsg.mMsgServiceID != 14)
            {
              j = i;
              if (localAbsStructMsg.mMsgServiceID != 84) {}
            }
            else
            {
              j = 1;
            }
          }
          if ((j != 0) || (a(localAbsStructMsg, parambhuk))) {
            parambhuk.a(2131366320, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131691990), 2130838938);
          }
          super.a(parambhuk, this.jdField_a_of_type_AndroidContentContext, localMessageForStructing);
          if ((localAbsStructMsg != null) && (localAbsStructMsg.mMsgServiceID != 49) && (localAbsStructMsg.mMsgServiceID != 106) && (localAbsStructMsg.mMsgServiceID != 14)) {
            super.c(parambhuk, this.jdField_a_of_type_AndroidContentContext);
          }
          if ((localAbsStructMsg != null) && (localAbsStructMsg.mMsgServiceID == 81)) {
            yup.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, localMessageForStructing, "press");
          }
          super.e(parambhuk, this.jdField_a_of_type_AndroidContentContext);
          if (bfuv.a(paramChatMessage)) {
            c(localMessageForStructing, parambhuk);
          }
          b(localMessageForStructing, parambhuk);
          return parambhuk;
          if (localAbsStructMsg.hasFlag(1)) {
            break;
          }
          parambhuk.a(2131367078, paramaghd.getString(2131692400), 2130838939);
          break;
          if (localAbsStructMsg.mMsgServiceID == 14) {
            break;
          }
          if (!localAbsStructMsg.hasFlag(1))
          {
            parambhuk.a(2131367078, paramaghd.getString(2131692400), 2130838939);
            break;
          }
          if (localAbsStructMsg.mMsgServiceID != 35) {
            break;
          }
          parambhuk.a(2131367078, paramaghd.getString(2131692400), 2130838939);
          bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006625", "0X8006625", 0, 1, 0, "", "", "", "");
          break;
          label759:
          j = 1;
          break label349;
          a(localMessageForStructing, parambhuk);
        }
        label778:
        j = 0;
      }
      label784:
      continue;
      label787:
      paramaghd = null;
    }
  }
  
  protected void b(View paramView, bete parambete, int paramInt1, int paramInt2)
  {
    paramView = agej.a(paramView);
    if (!ahtm.class.isInstance(paramView)) {}
    ChatMessage localChatMessage;
    do
    {
      do
      {
        return;
        paramView = (ahtm)paramView;
      } while ((!ahtm.class.isInstance(paramView)) || (paramView.jdField_a_of_type_AndroidWidgetRelativeLayout == null) || (!MessageForStructing.class.isInstance(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage)));
      localChatMessage = paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if ((localChatMessage.uniseq == parambete.jdField_b_of_type_Long) && (localChatMessage.isSendFromLocal()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("structMsg", 2, "handleMessage status = " + paramInt1 + ", retCode = " + paramInt2 + ", message.uniseq = " + localChatMessage.uniseq + ", file.uniseq = " + parambete.jdField_b_of_type_Long);
        }
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localChatMessage.frienduin, localChatMessage.uniseq), paramView);
        if (paramInt1 == 1005) {
          b();
        }
      }
    } while ((localChatMessage.uniseq != parambete.jdField_b_of_type_Long) || (paramInt1 != 2003) || (!(((MessageForStructing)localChatMessage).structingMsg instanceof StructMsgForImageShare)));
    paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
    parambete = new Bundle();
    paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(((MessageForStructing)localChatMessage).structingMsg.getView(this.jdField_a_of_type_AndroidContentContext, null, null, parambete));
  }
  
  public boolean b(ChatMessage paramChatMessage)
  {
    return true;
  }
  
  protected boolean b(MessageForStructing paramMessageForStructing, AbsStructMsg paramAbsStructMsg)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramMessageForStructing.istroop == 1)
    {
      bool1 = bool2;
      if (paramAbsStructMsg != null)
      {
        if ((paramAbsStructMsg.mMsgServiceID != 23) && (paramAbsStructMsg.mMsgServiceID != 19) && (paramAbsStructMsg.mMsgServiceID != 60) && (!anzj.a(2131713390).equals(paramAbsStructMsg.getSourceName())))
        {
          bool1 = bool2;
          if (paramAbsStructMsg.mMsgUrl == null) {
            break label105;
          }
          if (!paramAbsStructMsg.mMsgUrl.startsWith("http://qqweb.qq.com/m/qunactivity"))
          {
            bool1 = bool2;
            if (!paramAbsStructMsg.mMsgUrl.startsWith("https://qqweb.qq.com/m/qunactivity")) {
              break label105;
            }
          }
        }
        bool1 = false;
      }
    }
    label105:
    if (((1008 != paramMessageForStructing.istroop) || (!antf.u.equals(paramMessageForStructing.frienduin))) && ((paramAbsStructMsg == null) || (paramAbsStructMsg.mMsgUrl == null) || (!paramAbsStructMsg.mMsgUrl.startsWith("https://ti.qq.com/remind/view.html"))))
    {
      bool2 = bool1;
      if (paramAbsStructMsg != null)
      {
        bool2 = bool1;
        if (paramAbsStructMsg.mMsgUrl != null)
        {
          bool2 = bool1;
          if (!paramAbsStructMsg.mMsgUrl.startsWith("https://mqq.tenpay.com")) {}
        }
      }
    }
    else
    {
      bool2 = false;
    }
    if ((paramAbsStructMsg != null) && (paramAbsStructMsg.mMsgServiceID == 49)) {
      return false;
    }
    return bool2;
  }
  
  protected void c(View paramView, bete parambete, int paramInt1, int paramInt2)
  {
    paramView = agej.a(paramView);
    if (!ahtm.class.isInstance(paramView)) {}
    do
    {
      do
      {
        do
        {
          return;
          paramView = (ahtm)paramView;
        } while ((!ahtm.class.isInstance(paramView)) || (paramView.jdField_a_of_type_AndroidWidgetRelativeLayout == null) || (!MessageForStructing.class.isInstance(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage)));
        paramView = paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      } while ((paramView.uniseq != parambete.jdField_b_of_type_Long) || (!paramView.isSendFromLocal()));
      if (QLog.isColorLevel()) {
        QLog.d("structMsg", 2, "handleMessage status = " + paramInt1 + ", retCode = " + paramInt2 + ", message.uniseq = " + paramView.uniseq + ", file.uniseq = " + parambete.jdField_b_of_type_Long);
      }
    } while ((paramInt1 != 1005) && (paramInt1 != 1001) && (paramInt1 != 1003) && (paramInt1 != 1004) && (paramInt1 != 1002));
    b();
  }
  
  public void c(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    AbsStructMsg localAbsStructMsg = ((MessageForStructing)paramChatMessage).structingMsg;
    if ((localAbsStructMsg != null) && (StructMsgForImageShare.class.isInstance(localAbsStructMsg)))
    {
      paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramChatMessage.frienduin, paramChatMessage.uniseq);
      if ((paramChatMessage != null) && (berp.class.isInstance(paramChatMessage)))
      {
        a(paramBaseChatItemLayout, ((berp)paramChatMessage).a(), 0, 0);
        return;
      }
      paramBaseChatItemLayout.setProgressVisable(false);
      return;
    }
    super.c(paramChatMessage, paramBaseChatItemLayout);
  }
  
  protected void e()
  {
    long l1 = 1L;
    bikv localbikv = (bikv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(76);
    biku localbiku = localbikv.a();
    if ((localbiku != null) && (localbiku.d == 0L) && (localbiku.a != 0L)) {
      localbikv.a(localbiku.a);
    }
    long l2;
    if ((localbiku != null) && (localbiku.d == 1L))
    {
      l2 = localbikv.a - (NetConnInfoCenter.getServerTimeMillis() - localbiku.e);
      if (l2 > 0L) {
        break label127;
      }
    }
    for (;;)
    {
      new Handler(this.jdField_a_of_type_AndroidContentContext.getMainLooper()).postDelayed(new StructingMsgItemBuilder.8(this, localbiku, localbikv), l1);
      return;
      label127:
      l1 = l2;
    }
  }
  
  public void onClick(View paramView)
  {
    BaseChatPie localBaseChatPie;
    StructMsgForImageShare localStructMsgForImageShare;
    bdqr localbdqr;
    if (paramView.getId() == 2131365781)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StructingMsgItemBuilder", 2, "[Doutu] Dui Button Clicked.");
      }
      if (QLog.isColorLevel()) {
        QLog.d("StructingMsgItemBuilder", 2, "[Doutu] Dui Button Clicked.");
      }
      localObject = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
      if (localObject == null) {
        break label199;
      }
      localBaseChatPie = ((ChatFragment)localObject).a();
      if (localBaseChatPie == null) {
        break label180;
      }
      localObject = (MessageForStructing)((ahtm)agej.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if ((localObject == null) || (((MessageForStructing)localObject).structingMsg == null) || (!(((MessageForStructing)localObject).structingMsg instanceof StructMsgForImageShare))) {
        break label218;
      }
      localStructMsgForImageShare = (StructMsgForImageShare)((MessageForStructing)localObject).structingMsg;
      localbdqr = localStructMsgForImageShare.getFirstImageElement();
      if (localbdqr == null) {
        break label218;
      }
    }
    label180:
    label199:
    label218:
    for (Object localObject = new asci(localbdqr.ad, localbdqr.ae, localbdqr.c, localStructMsgForImageShare.rawUrl, ((MessageForStructing)localObject).senderuin);; localObject = null)
    {
      localBaseChatPie.a().obtainMessage(79, localObject).sendToTarget();
      for (;;)
      {
        super.onClick(paramView);
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (QLog.isColorLevel())
        {
          QLog.d("StructingMsgItemBuilder", 2, "[Doutu] curPie is null.");
          continue;
          if (QLog.isColorLevel()) {
            QLog.d("StructingMsgItemBuilder", 2, "[Doutu] chatFragment is null.");
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder
 * JD-Core Version:    0.7.0.1
 */