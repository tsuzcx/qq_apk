package com.tencent.mobileqq.activity.aio.item;

import acex;
import aekt;
import aels;
import aelt;
import aelw;
import aemk;
import aenj;
import aenl;
import aeor;
import aeov;
import afar;
import afcu;
import afxp;
import afxq;
import afxr;
import afxs;
import afxt;
import afxu;
import afxv;
import afxw;
import afxx;
import afxy;
import afya;
import afyb;
import afyc;
import afyd;
import afye;
import afyf;
import afyg;
import afyh;
import afyi;
import afyj;
import agej;
import agem;
import agot;
import aljq;
import alpo;
import amad;
import amnk;
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
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import apfo;
import arof;
import arum;
import aukx;
import aule;
import aupu;
import awga;
import ayvc;
import ayvy;
import azlf;
import azmj;
import azqj;
import azqk;
import azqq;
import azqu;
import azsc;
import azsp;
import azss;
import aztb;
import azua;
import azuw;
import azvm;
import badt;
import bame;
import bamw;
import baoj;
import batw;
import baul;
import bcic;
import bdaj;
import bdbt;
import bdcd;
import bdcs;
import bdec;
import bdfq;
import bdkz;
import bdlb;
import bdlq;
import bdyu;
import bdyv;
import bhpy;
import bhql;
import bhvq;
import bhvt;
import biiv;
import biqt;
import biqv;
import birh;
import birl;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AudioPlayer;
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
import com.tencent.mobileqq.doutu.DuiButtonImageView;
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
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import cooperation.comic.VipComicJumpActivity;
import java.io.File;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import ndd;
import ntd;
import nud;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import swm;
import swn;
import syb;
import wta;
import xod;

public class StructingMsgItemBuilder
  extends BaseBubbleBuilder
  implements aelw, aenl, aeor
{
  public static final int[] a;
  static int c;
  private azsc jdField_a_of_type_Azsc;
  bhvq jdField_a_of_type_Bhvq;
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
    this.jdField_a_of_type_Azsc = new azsc();
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
      bdyv localbdyv = (bdyv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(76);
      bdyu localbdyu = localbdyv.a();
      BaseActivity localBaseActivity = (BaseActivity)this.jdField_a_of_type_AndroidContentContext;
      if ((localbdyu != null) && (localBaseActivity.isResume()) && (localbdyu.b.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (localbdyu.d == 2L) && (paramLong == localbdyu.a)) {
        localbdyv.a(localbdyu, localBaseActivity);
      }
    }
  }
  
  private void a(afyi paramafyi, BaseChatItemLayout paramBaseChatItemLayout, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramBaseChatItemLayout.setHeadIconVisible(false);
      paramafyi.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130849999);
      int i = paramafyi.jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingLeft();
      int j = paramafyi.jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingLeft();
      paramafyi.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, i, 0, j);
      return;
    }
    paramBaseChatItemLayout.setHeadIconVisible(true);
  }
  
  private void a(afyi paramafyi, BaseChatItemLayout paramBaseChatItemLayout, boolean paramBoolean1, AbsStructMsg paramAbsStructMsg, Resources paramResources, boolean paramBoolean2)
  {
    RelativeLayout localRelativeLayout = paramafyi.jdField_b_of_type_AndroidWidgetRelativeLayout;
    if (localRelativeLayout == null)
    {
      localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramafyi.jdField_b_of_type_AndroidWidgetRelativeLayout = localRelativeLayout;
      localRelativeLayout.setId(2131377066);
      paramBaseChatItemLayout.addView(localRelativeLayout);
    }
    for (;;)
    {
      Object localObject2 = (RelativeLayout.LayoutParams)localRelativeLayout.getLayoutParams();
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      }
      ((RelativeLayout.LayoutParams)localObject1).topMargin = aekt.a(-2.0F, paramResources);
      if (paramBoolean2)
      {
        ((RelativeLayout.LayoutParams)localObject1).leftMargin = aekt.a(0.0F, paramResources);
        ((RelativeLayout.LayoutParams)localObject1).addRule(5, 2131364171);
        ((RelativeLayout.LayoutParams)localObject1).addRule(3, 2131364171);
        if (!paramBoolean1) {
          break label501;
        }
        ((RelativeLayout.LayoutParams)localObject1).addRule(1, 0);
        ((RelativeLayout.LayoutParams)localObject1).addRule(7, 2131364180);
        label139:
        localRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject1 = localRelativeLayout.getChildAt(0);
        paramResources = (Resources)localObject1;
        if (localObject1 != null)
        {
          paramResources = (Resources)localObject1;
          if (paramafyi.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
          {
            localObject2 = paramafyi.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
            paramResources = (Resources)localObject1;
            if (localObject2 != null)
            {
              localObject2 = ((View)localObject2).getTag(2131377085);
              if (QLog.isColorLevel()) {
                QLog.d("structMsg", 2, "bindviwfor structmsg tag:" + localObject2);
              }
              if (localObject2 != null)
              {
                paramResources = (Resources)localObject1;
                if (localObject2.getClass() == paramAbsStructMsg.getClass()) {}
              }
              else
              {
                paramResources = null;
              }
            }
          }
        }
        localRelativeLayout.removeAllViews();
        paramResources = paramAbsStructMsg.getSourceView(this.jdField_a_of_type_AndroidContentContext, paramResources);
        if (paramResources == null) {
          break label521;
        }
        paramResources.setId(2131377067);
        localRelativeLayout.addView(paramResources);
        if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
        {
          paramafyi = new View(this.jdField_a_of_type_AndroidContentContext);
          paramBaseChatItemLayout = new RelativeLayout.LayoutParams(-2, -2);
          paramBaseChatItemLayout.addRule(6, 2131377067);
          paramBaseChatItemLayout.addRule(5, 2131377067);
          paramBaseChatItemLayout.addRule(7, 2131377067);
          paramBaseChatItemLayout.addRule(8, 2131377067);
          paramafyi.setBackgroundResource(2130837739);
          localRelativeLayout.addView(paramafyi, paramBaseChatItemLayout);
        }
      }
      for (;;)
      {
        a(paramAbsStructMsg, localRelativeLayout);
        return;
        ((RelativeLayout.LayoutParams)localObject1).leftMargin = aekt.a(10.0F, paramResources);
        if ((!paramBoolean1) || ((paramAbsStructMsg.mMsgServiceID != 83) && (paramAbsStructMsg.mMsgServiceID != 108) && (paramAbsStructMsg.mMsgServiceID != 114) && (paramAbsStructMsg.mMsgServiceID != 116) && (paramAbsStructMsg.mMsgServiceID != 151) && (paramAbsStructMsg.mMsgServiceID != 156)) || (TextUtils.isEmpty(paramAbsStructMsg.mMsgActionData))) {
          break;
        }
        ((RelativeLayout.LayoutParams)localObject1).leftMargin += aekt.a(18.0F, paramResources);
        break;
        label501:
        ((RelativeLayout.LayoutParams)localObject1).addRule(1, 2131364180);
        ((RelativeLayout.LayoutParams)localObject1).addRule(7, 2131364171);
        break label139;
        label521:
        paramBaseChatItemLayout.removeView(localRelativeLayout);
        paramafyi.jdField_b_of_type_AndroidWidgetRelativeLayout = null;
      }
    }
  }
  
  private void a(afyi paramafyi, BaseChatItemLayout paramBaseChatItemLayout, boolean paramBoolean1, StructMsgForGeneralShare paramStructMsgForGeneralShare, Resources paramResources, boolean paramBoolean2)
  {
    RelativeLayout localRelativeLayout = paramafyi.c;
    Object localObject = localRelativeLayout;
    if (localRelativeLayout == null)
    {
      localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramafyi.jdField_b_of_type_AndroidWidgetRelativeLayout = localRelativeLayout;
      localRelativeLayout.setId(2131377065);
      paramBaseChatItemLayout.addView(localRelativeLayout);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localRelativeLayout.getLayoutParams();
      localObject = localLayoutParams;
      if (localLayoutParams == null) {
        localObject = new RelativeLayout.LayoutParams(-2, -2);
      }
      ((RelativeLayout.LayoutParams)localObject).topMargin = (12 - aekt.a(10.0F, paramResources));
      ((RelativeLayout.LayoutParams)localObject).addRule(5, 2131364171);
      ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131364171);
      localObject = localRelativeLayout;
    }
    paramResources = ((RelativeLayout)localObject).getChildAt(0);
    paramStructMsgForGeneralShare = paramStructMsgForGeneralShare.getAdSourceView(this.jdField_a_of_type_AndroidContentContext, paramResources);
    if (paramStructMsgForGeneralShare != null)
    {
      ((RelativeLayout)localObject).addView(paramStructMsgForGeneralShare);
      paramafyi = (RelativeLayout.LayoutParams)paramStructMsgForGeneralShare.getLayoutParams();
      paramafyi.topMargin = xod.a(this.jdField_a_of_type_AndroidContentContext, 10.0F);
      paramafyi.height = -2;
      paramafyi.width = -2;
      return;
    }
    paramBaseChatItemLayout.removeView((View)localObject);
    paramafyi.jdField_b_of_type_AndroidWidgetRelativeLayout = null;
  }
  
  private void a(Activity paramActivity)
  {
    Dialog localDialog = new Dialog(paramActivity);
    localDialog.requestWindowFeature(1);
    localDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    View localView = LayoutInflater.from(paramActivity).inflate(2131559510, null);
    ((ImageView)localView.findViewById(2131367933)).setImageResource(2130839404);
    ((TextView)localView.findViewById(2131377566)).setText(alpo.a(2131714966));
    localDialog.setContentView(localView);
    localDialog.show();
    new Handler(paramActivity.getMainLooper()).postDelayed(new StructingMsgItemBuilder.23(this, localDialog), 1500L);
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
        Object localObject2 = new bhvt();
        ((bhvt)localObject2).jdField_a_of_type_Int = i;
        ((bhvt)localObject2).jdField_b_of_type_Int = 0;
        if (localJSONObject.has("show_name")) {}
        for (((bhvt)localObject2).jdField_a_of_type_JavaLangString = localJSONObject.getString("show_name");; ((bhvt)localObject2).jdField_a_of_type_JavaLangString = "")
        {
          localArrayList1.add(localObject2);
          localObject2 = new swm();
          ((swm)localObject2).jdField_a_of_type_JavaLangString = str;
          ((swm)localObject2).c = localJSONObject.optString("index");
          ((swm)localObject2).d = localJSONObject.optString("index_name");
          ((swm)localObject2).b = localJSONObject.optString("index_type");
          ((swm)localObject2).e = String.valueOf(ndd.a());
          localArrayList2.add(localObject2);
          i += 1;
          break;
        }
      }
      this.jdField_a_of_type_Bhvq = bhvq.a(paramActivity, localArrayList1, new afxu(this, paramActivity, paramChatMessage, localAbsStructMsg, str, localArrayList2), new afxv(this), aekt.a(100.0F, paramActivity.getResources()));
    }
    catch (JSONException paramActivity)
    {
      paramActivity.printStackTrace();
      return;
    }
    int i = paramView.getWidth() * 7 / 2;
    this.jdField_a_of_type_Bhvq.showAsDropDown(paramView, 0 - i, 0);
    this.jdField_a_of_type_Bhvq.dismiss();
    paramActivity = new int[2];
    paramView.getLocationOnScreen(paramActivity);
    this.jdField_a_of_type_Bhvq.showAtLocation(paramView, 0, paramActivity[0], paramActivity[1] + paramView.getHeight());
    this.jdField_a_of_type_Bhvq.setOnDismissListener(new afxw(this));
  }
  
  private void a(View paramView, StructMsgForGeneralShare paramStructMsgForGeneralShare)
  {
    new azqq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView).a(paramStructMsgForGeneralShare.mMsgAction, paramStructMsgForGeneralShare.mMsgUrl, paramStructMsgForGeneralShare.mMsgActionData, paramStructMsgForGeneralShare.mMsg_A_ActionData);
  }
  
  private void a(bdlq parambdlq, afyi paramafyi)
  {
    if (paramafyi.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
      return;
    }
    Object localObject;
    int i;
    if ((parambdlq instanceof bamw))
    {
      localObject = (bamw)parambdlq;
      i = (int)((bamw)localObject).c();
      if ((i != 1004) || (!((bamw)localObject).c()) || (!((bamw)localObject).d())) {
        break label416;
      }
      i = 1006;
    }
    label416:
    for (;;)
    {
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(6, 2131377085);
      ((RelativeLayout.LayoutParams)localObject).addRule(8, 2131377085);
      ((RelativeLayout.LayoutParams)localObject).addRule(5, 2131377085);
      ((RelativeLayout.LayoutParams)localObject).addRule(7, 2131377085);
      if ((paramafyi.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (paramafyi.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131377072) == null) && (paramafyi.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView != null)) {
        paramafyi.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramafyi.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView, (ViewGroup.LayoutParams)localObject);
      }
      switch (i)
      {
      default: 
        if (paramafyi.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView == null) {
          break;
        }
        paramafyi.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setProcessor(null);
        paramafyi.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(8);
        return;
      case 1000: 
      case 1001: 
      case 1002: 
      case 1006: 
      case 4001: 
        if (paramafyi.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView == null)
        {
          MessageProgressTextView localMessageProgressTextView = new MessageProgressTextView(this.jdField_a_of_type_AndroidContentContext);
          localMessageProgressTextView.setTextColor(-1);
          localMessageProgressTextView.setTextSize(2, 15.0F);
          localMessageProgressTextView.setGravity(17);
          localMessageProgressTextView.setId(2131377072);
          localMessageProgressTextView.setBackgroundDrawable(new afcu(2130706432, this.jdField_b_of_type_Float * 12.0F));
          if (paramafyi.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
            paramafyi.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localMessageProgressTextView, (ViewGroup.LayoutParams)localObject);
          }
          paramafyi.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView = localMessageProgressTextView;
        }
        paramafyi.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setProcessor((bamw)parambdlq);
        paramafyi.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(0);
        switch (i)
        {
        }
        for (;;)
        {
          paramafyi.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.a();
          return;
          paramafyi.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setProgress(0);
          return;
          paramafyi.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setProgress(0);
        }
        if (paramafyi.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView == null) {
          break;
        }
        paramafyi.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setProcessor(null);
        paramafyi.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(4);
        return;
      }
    }
  }
  
  private void a(BaseChatItemLayout paramBaseChatItemLayout, MessageForStructing paramMessageForStructing)
  {
    int i = ((StructMsgForGeneralShare)paramMessageForStructing.structingMsg).getProgress();
    if ((paramMessageForStructing.extraflag == 32772) && (i >= 0) && (i < 100))
    {
      amad localamad = (amad)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(28);
      localamad.a(ayvy.a(paramMessageForStructing.msgUid), paramMessageForStructing.frienduin, paramMessageForStructing.uniseq);
      paramMessageForStructing = new afyc(this, paramMessageForStructing, paramBaseChatItemLayout);
      paramBaseChatItemLayout.setTag(2131378335, paramMessageForStructing);
      localamad.a(paramBaseChatItemLayout, paramMessageForStructing);
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
  
  private boolean a(MessageForStructing paramMessageForStructing)
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
  
  private boolean a(AbsStructMsg paramAbsStructMsg)
  {
    return 19 == paramAbsStructMsg.mMsgServiceID;
  }
  
  private boolean a(AbsStructMsg paramAbsStructMsg, bdkz parambdkz)
  {
    boolean bool2 = true;
    int i = 0;
    boolean bool1;
    if ((paramAbsStructMsg == null) || (parambdkz == null) || (this.jdField_a_of_type_AndroidContentContext == null)) {
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
      j = parambdkz.a();
      bool1 = bool2;
    } while (j <= 0);
    for (;;)
    {
      bool1 = bool2;
      if (i >= j) {
        break;
      }
      paramAbsStructMsg = parambdkz.a(i);
      if (paramAbsStructMsg != null)
      {
        bool1 = bool2;
        if (paramAbsStructMsg.a() == 2131366015) {
          break;
        }
      }
      i += 1;
    }
    return false;
  }
  
  private void b(Activity paramActivity)
  {
    Dialog localDialog = new Dialog(paramActivity);
    localDialog.requestWindowFeature(1);
    localDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    View localView = LayoutInflater.from(paramActivity).inflate(2131559510, null);
    ((ImageView)localView.findViewById(2131367933)).setImageResource(2130839391);
    ((TextView)localView.findViewById(2131377566)).setText(alpo.a(2131714965));
    localDialog.setContentView(localView);
    localDialog.show();
    new Handler(paramActivity.getMainLooper()).postDelayed(new StructingMsgItemBuilder.24(this, localDialog), 1500L);
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
        bhvt localbhvt = new bhvt();
        if (localJSONObject.has("index"))
        {
          localbhvt.jdField_a_of_type_Int = localJSONObject.getInt("index");
          localbhvt.jdField_b_of_type_Int = 0;
          if (localJSONObject.has("show_name"))
          {
            localbhvt.jdField_a_of_type_JavaLangString = localJSONObject.getString("show_name");
            localArrayList.add(localbhvt);
            i += 1;
          }
        }
        else
        {
          localbhvt.jdField_a_of_type_Int = i;
          continue;
        }
        localbhvt.jdField_a_of_type_JavaLangString = "";
      }
      catch (JSONException paramActivity)
      {
        paramActivity.printStackTrace();
        return;
      }
    }
    this.jdField_a_of_type_Bhvq = bhvq.a(paramActivity, localArrayList, new afxy(this, paramChatMessage, paramActivity, localAbsStructMsg), new afya(this), aekt.a(100.0F, paramActivity.getResources()));
    int i = paramView.getWidth() * -5 / 7;
    this.jdField_a_of_type_Bhvq.showAsDropDown(paramView, i, 0);
    this.jdField_a_of_type_Bhvq.dismiss();
    paramActivity = new int[2];
    paramView.getLocationOnScreen(paramActivity);
    this.jdField_a_of_type_Bhvq.showAtLocation(paramView, 0, paramActivity[0], paramActivity[1] + paramView.getHeight());
    this.jdField_a_of_type_Bhvq.setOnDismissListener(new afyb(this));
  }
  
  private static void b(String paramString, URL paramURL, ThumbWidthHeightDP paramThumbWidthHeightDP)
  {
    CompressInfo localCompressInfo = new CompressInfo(paramString, 0);
    localCompressInfo.f = true;
    paramString = bame.d(paramURL.toString());
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
        if (awga.b(localCompressInfo))
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
          bool = arof.a(new File(localCompressInfo.c), paramString);
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
          if ((paramChatMessage.getItemByIndex(i) instanceof aztb)) {
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
  
  public aels a(View paramView)
  {
    try
    {
      ChatMessage localChatMessage = aekt.a(paramView);
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
          return (aels)paramView.findViewById(2131368113);
        }
      } while ((((MessageForStructing)localObject).structingMsg == null) || (((MessageForStructing)localObject).structingMsg.mMsgServiceID != 107));
      Object localObject = paramView.findViewById(2131375325);
      if (localObject != null) {
        return (aels)((View)localObject).getTag(-1);
      }
      paramView = "getTouchDelegate when receipt message but the root view is null \r\n" + paramView;
      azlf.a(new IllegalStateException(paramView), "StructingMsgItemBuilderCatchedException" + paramView);
    }
    return null;
  }
  
  protected afyi a()
  {
    return new afyi();
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, aeov paramaeov)
  {
    this.jdField_a_of_type_Azsc.a();
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
        wta.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, localMessageForStructing, "exp");
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
      if ((paramView.getTag() instanceof aelt))
      {
        localObject = (aelt)paramView.getTag();
        j = k;
        if (localObject != null) {
          j = ((aelt)localObject).jdField_b_of_type_Int;
        }
      }
    }
    localAbsStructMsg.message = localMessageForStructing;
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramaeov);
    if (localAbsStructMsg.mMsgServiceID == 76)
    {
      paramInt2 = aekt.a(11.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      k = aekt.a(7.5F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramView.setPadding(0, 0, 0, 0);
      paramViewGroup = (aelt)paramView.getTag();
      paramViewGroup.jdField_a_of_type_AndroidViewView.setPadding(0, 0, 0, 0);
      ((RelativeLayout.LayoutParams)paramViewGroup.jdField_a_of_type_AndroidViewView.getLayoutParams()).setMargins(paramInt2, k, paramInt2, k);
    }
    if (localAbsStructMsg.mMsgServiceID == 35)
    {
      paramViewGroup = (aelt)paramView.getTag();
      paramViewGroup.jdField_a_of_type_AndroidViewView.setPadding(paramViewGroup.jdField_a_of_type_AndroidViewView.getPaddingLeft(), 0, paramViewGroup.jdField_a_of_type_AndroidViewView.getPaddingRight(), 0);
    }
    paramViewGroup = (afyi)paramView.getTag();
    Object localObject = paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
    if (((i == 1) || (j != paramViewGroup.jdField_b_of_type_Int)) && (localAbsStructMsg.mMsgServiceID == 128)) {
      bdaj.a("Grp_AIO", "invite", "send_exp", 0, 0, new String[] { String.valueOf(localAbsStructMsg.uniseq) });
    }
    int m;
    if ((localAbsStructMsg instanceof AbsShareMsg))
    {
      paramInt2 = ((AbsShareMsg)localAbsStructMsg).mContentLayout;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1008) && (localAbsStructMsg.hasFlag(4))) {
        localAbsStructMsg.addFlag(1);
      }
      paramaeov = this.jdField_a_of_type_AndroidContentContext.getResources();
      boolean bool = a(localMessageForStructing);
      if (QLog.isDevelopLevel()) {
        QLog.d("StructingMsgItemBuilder", 4, "getView:position:" + paramInt1 + "hasHead" + bool);
      }
      a(paramViewGroup, (BaseChatItemLayout)localObject, bool);
      a(paramViewGroup, (BaseChatItemLayout)localObject, localMessageForStructing.isSend(), localAbsStructMsg, paramaeov, bool);
      if (((localAbsStructMsg instanceof StructMsgForGeneralShare)) && (((StructMsgForGeneralShare)localAbsStructMsg).mHasAdSource)) {
        a(paramViewGroup, (BaseChatItemLayout)localObject, localMessageForStructing.isSend(), (StructMsgForGeneralShare)localAbsStructMsg, paramaeov, bool);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008) || (localMessageForStructing.structingMsg.mMsgServiceID == 76) || (localMessageForStructing.structingMsg.mMsgServiceID == 21))
      {
        k = paramaeov.getDimensionPixelSize(2131298815);
        m = paramaeov.getDimensionPixelSize(2131298815);
        if ((!BaseChatItemLayout.jdField_a_of_type_Boolean) || (!bool)) {
          break label1008;
        }
        paramInt1 = 1;
        label678:
        AIOLongShotHelper localAIOLongShotHelper = AIOLongShotHelper.a();
        j = paramInt1;
        if (localAIOLongShotHelper != null)
        {
          j = paramInt1;
          if (localAIOLongShotHelper.a()) {
            j = 0;
          }
        }
        paramInt1 = k;
        if (j != 0)
        {
          j = aekt.a(30.0F, paramaeov);
          paramInt1 = j;
          if (((BaseChatItemLayout)localObject).jdField_a_of_type_AndroidWidgetCheckBox != null)
          {
            localObject = (RelativeLayout.LayoutParams)((BaseChatItemLayout)localObject).jdField_a_of_type_AndroidWidgetCheckBox.getLayoutParams();
            paramInt1 = j;
            if (localObject != null)
            {
              ((RelativeLayout.LayoutParams)localObject).leftMargin = aekt.a(5.0F, paramaeov);
              paramInt1 = j;
            }
          }
        }
        paramaeov = (RelativeLayout.LayoutParams)((RelativeLayout)((BaseChatItemLayout)paramView).b()).getLayoutParams();
        if (paramaeov != null)
        {
          if (localMessageForStructing.structingMsg.mMsgServiceID == 21) {
            break label1013;
          }
          paramaeov.setMargins(paramInt1, 0, m, 0);
        }
      }
    }
    for (;;)
    {
      paramView.requestLayout();
      if ((paramViewGroup != null) && (paramViewGroup.jdField_a_of_type_ComTencentMobileqqDataChatMessage == paramChatMessage) && (localAbsStructMsg.hasFlag(16))) {
        ThreadManager.post(new StructingMsgItemBuilder.5(this, paramViewGroup), 2, null, false);
      }
      paramaeov = (bcic)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(132);
      if (paramaeov.b(paramChatMessage))
      {
        paramaeov.a(paramChatMessage.uniseq);
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
        paramaeov = AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidContentContext, 2130772207);
        paramaeov.setAnimationListener(new afyg(this, paramViewGroup));
        paramViewGroup.jdField_a_of_type_AndroidViewView.postDelayed(new StructingMsgItemBuilder.7(this, paramViewGroup, paramaeov), 300L);
      }
      this.jdField_a_of_type_Azsc.a(paramInt2, i);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && ("3046055438".equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
        nud.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, paramView);
      }
      return paramView;
      paramInt2 = -1;
      break;
      label1008:
      paramInt1 = 0;
      break label678;
      label1013:
      paramaeov.setMargins(paramInt1, paramaeov.topMargin, m, paramaeov.bottomMargin);
    }
  }
  
  public View a(ChatMessage paramChatMessage, aelt paramaelt, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aeov paramaeov)
  {
    Bundle localBundle = new Bundle();
    if (((this.jdField_a_of_type_AndroidContentContext instanceof ChatActivity)) || ((this.jdField_a_of_type_AndroidContentContext instanceof SplashActivity))) {}
    label1053:
    label2337:
    for (Object localObject2 = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a().a();; localObject2 = null)
    {
      Object localObject1;
      Object localObject3;
      int i;
      if (paramView == null)
      {
        localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources();
        paramView = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
        paramView.setId(2131364171);
        paramView.setMinimumHeight(aekt.a(44.0F, (Resources)localObject1));
        paramView.setClickable(true);
        paramView.setPadding(BaseChatItemLayout.i, BaseChatItemLayout.g, BaseChatItemLayout.j, BaseChatItemLayout.h);
        paramView.setBackgroundResource(2130837925);
        localObject3 = new RelativeLayout.LayoutParams(-2, -2);
        i = ((Resources)localObject1).getDimensionPixelSize(2131298815);
        ((RelativeLayout.LayoutParams)localObject3).setMargins(i, 0, i, 0);
        ((RelativeLayout.LayoutParams)localObject3).addRule(1, 2131367808);
        paramView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        if (MessageForStructing.class.isInstance(paramChatMessage)) {
          break label203;
        }
      }
      label203:
      MessageForStructing localMessageForStructing;
      AbsStructMsg localAbsStructMsg;
      do
      {
        return paramView;
        if (((paramView instanceof ViewGroup)) && (!c(paramChatMessage))) {
          ((ViewGroup)paramView).removeAllViews();
        }
        break;
        paramaelt.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setMiniAioShieldItemTouchListener(this);
        localMessageForStructing = (MessageForStructing)paramChatMessage;
        localAbsStructMsg = localMessageForStructing.structingMsg;
        if (localAbsStructMsg != null) {
          break label302;
        }
      } while (!QLog.isColorLevel());
      paramaelt = new StringBuilder().append("structMsg is null,msgdata:");
      if (localMessageForStructing == null) {
        paramChatMessage = "null";
      }
      for (;;)
      {
        QLog.d("structMsg", 2, paramChatMessage);
        return paramView;
        if (localMessageForStructing.msgData == null) {
          paramChatMessage = "null";
        } else {
          paramChatMessage = Integer.valueOf(localMessageForStructing.msgData.length);
        }
      }
      label302:
      localAbsStructMsg.message = localMessageForStructing;
      Object localObject4;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008))
      {
        if ((localAbsStructMsg instanceof StructMsgForGeneralShare))
        {
          paramaelt = (StructMsgForGeneralShare)localAbsStructMsg;
          localBundle.putString("VIDEO_PUB_ACCOUNT_UIN", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          localBundle.putString("VIDEO_PUB_ACCOUNT_NAME", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
        }
        localBundle.putBoolean("isPublicAccount", true);
        paramaelt = paramChatMessage.getExtInfoFromExtStr("msg_template_id");
        if ((paramaelt != null) && (!paramaelt.equals("")))
        {
          if (!TextUtils.isEmpty(paramaelt)) {
            localAbsStructMsg.templateIDForPortal = paramaelt;
          }
          if ((localAbsStructMsg instanceof AbsShareMsg))
          {
            localObject1 = ((AbsShareMsg)localAbsStructMsg).getStructMsgItemLists();
            if (localObject1 != null)
            {
              localObject1 = ((List)localObject1).iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject3 = (azqj)((Iterator)localObject1).next();
                if (!TextUtils.isEmpty(paramaelt)) {
                  ((azqj)localObject3).P = paramaelt;
                }
                if ((localObject3 instanceof azqk))
                {
                  localObject3 = (azqk)localObject3;
                  if (((azqk)localObject3).a != null)
                  {
                    localObject3 = ((azqk)localObject3).a.iterator();
                    while (((Iterator)localObject3).hasNext())
                    {
                      localObject4 = (azqj)((Iterator)localObject3).next();
                      if (!TextUtils.isEmpty(paramaelt)) {
                        ((azqj)localObject4).P = paramaelt;
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      localAbsStructMsg.uniseq = localMessageForStructing.uniseq;
      localAbsStructMsg.uin = localMessageForStructing.frienduin;
      localAbsStructMsg.uinType = localMessageForStructing.istroop;
      localAbsStructMsg.currentAccountUin = localMessageForStructing.selfuin;
      localAbsStructMsg.messageVersion = localMessageForStructing.versionCode;
      localBundle.putBoolean("isSend", localMessageForStructing.isSend());
      if (localAbsStructMsg.uinType == 1008)
      {
        localAbsStructMsg.sourceAccoutType = AbsStructMsg.SOURCE_ACCOUNT_TYPE_PA;
        label637:
        localBundle.putInt("accostType", localAbsStructMsg.sourceAccoutType);
        if (localAbsStructMsg.mMsgServiceID == 21) {
          localBundle.putInt("serviceID", localAbsStructMsg.mMsgServiceID);
        }
        if (StructMsgForImageShare.class.isInstance(localAbsStructMsg))
        {
          paramaelt = (StructMsgForImageShare)localAbsStructMsg;
          paramaelt.mIsSend = localMessageForStructing.issend;
          paramaelt.mUniseq = localMessageForStructing.uniseq;
          paramaelt.mMsgType = localMessageForStructing.msgtype;
        }
        paramBaseChatItemLayout.setAddStatesFromChildren(false);
        paramaelt = paramBaseChatItemLayout.getTag();
        if ((paramaelt == null) || (!(paramaelt instanceof afyi))) {
          break label2747;
        }
      }
      label811:
      label2747:
      for (paramaelt = (afyi)paramaelt;; paramaelt = null)
      {
        if (paramaelt == null) {}
        for (localObject1 = a();; localObject1 = paramaelt) {
          for (;;)
          {
            ((afyi)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
            paramaelt = ((afyi)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout;
            localObject3 = paramaelt;
            if (paramaelt == null)
            {
              localObject3 = (RelativeLayout)paramView;
              ((afyi)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject3);
            }
            paramaelt = null;
            paramView.setTag(localObject1);
            if (d(paramChatMessage))
            {
              ((afyi)localObject1).jdField_a_of_type_Boolean = true;
              if (!(localAbsStructMsg instanceof StructMsgForGeneralShare)) {
                break label2044;
              }
              if (localAbsStructMsg.mSType != null) {
                localBundle.putString("sType", localAbsStructMsg.mSType);
              }
              if ((!StructLongMessageDownloadProcessor.b(paramChatMessage)) && (!StructLongMessageDownloadProcessor.d(paramChatMessage))) {}
            }
            try
            {
              for (;;)
              {
                localBundle.putInt("longMsgHolderType", Integer.parseInt(localMessageForStructing.getExtInfoFromExtStr("longMsg_State")));
                localObject4 = ((StructMsgForGeneralShare)localAbsStructMsg).getLayoutStr();
                if (a(localAbsStructMsg.mMsgServiceID))
                {
                  localObject4 = (String)localObject4 + localMessageForStructing.issend;
                  paramaelt = null;
                  if (localObject2 != null) {
                    paramaelt = ((afyj)localObject2).a((String)localObject4, (ViewGroup)paramView);
                  }
                  if (paramaelt != null) {
                    if (localAbsStructMsg.mMsgServiceID == 61)
                    {
                      paramaelt = AbsStructMsg.getInCompatibleView(this.jdField_a_of_type_AndroidContentContext, paramaelt, paramView.getResources().getString(2131699235));
                      label972:
                      paramView.setOnTouchListener(paramaeov);
                      paramView.setOnLongClickListener(paramaeov);
                      if (!(localAbsStructMsg instanceof AbsShareMsg)) {
                        break label2257;
                      }
                      paramaeov = (AbsShareMsg)localAbsStructMsg;
                      localObject2 = paramaeov.getOnClickListener();
                      paramView.setOnClickListener(new afyh(this, paramaeov, localMessageForStructing, paramChatMessage, paramChatMessage.time, (View.OnClickListener)localObject2));
                      if (!StructMsgForImageShare.class.isInstance(localAbsStructMsg)) {
                        break label2168;
                      }
                      aenj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramBaseChatItemLayout, this);
                      if (b(localMessageForStructing)) {
                        aenj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramBaseChatItemLayout, this);
                      }
                      if (!swn.a(localAbsStructMsg)) {
                        break label2198;
                      }
                      paramView.setOnClickListener(null);
                      label1088:
                      if ((localAbsStructMsg.mMsgServiceID == 76) || (localAbsStructMsg.mMsgServiceID == 106))
                      {
                        paramView.setOnClickListener(null);
                        if (localAbsStructMsg.mMsgServiceID != 106)
                        {
                          paramView.setOnLongClickListener(null);
                          paramView.setOnTouchListener(null);
                        }
                      }
                      if (localAbsStructMsg.mMsgServiceID == 79)
                      {
                        paramView.setOnClickListener(null);
                        paramView.setOnClickListener(new afxr(this, paramaeov));
                      }
                      if (localAbsStructMsg.mMsgServiceID != 81) {}
                    }
                  }
                  try
                  {
                    for (;;)
                    {
                      for (;;)
                      {
                        ((RelativeLayout)localObject3).addView(paramaelt);
                        if (localAbsStructMsg.mMsgServiceID == 38)
                        {
                          paramaelt = (bdyv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(76);
                          if (paramaelt != null)
                          {
                            if (!paramaelt.b(paramChatMessage.time)) {
                              break label2337;
                            }
                            paramaelt = new ProgressBar(this.jdField_a_of_type_AndroidContentContext);
                            paramaelt.setId(2131364198);
                            paramaelt.setIndeterminateDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839224));
                            i = aekt.a(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
                            new RelativeLayout.LayoutParams(-2, -2);
                            paramaeov = new RelativeLayout.LayoutParams(i, i);
                            paramaeov.addRule(13, 2131364171);
                            ((RelativeLayout)localObject3).addView(paramaelt, paramaeov);
                            e();
                          }
                        }
                        if (!(localAbsStructMsg instanceof StructMsgForImageShare)) {
                          break label2367;
                        }
                        if (localMessageForStructing.isSendFromLocal())
                        {
                          paramaelt = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForStructing.frienduin, localMessageForStructing.uniseq);
                          ((afyi)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject3);
                          a(paramaelt, (afyi)localObject1);
                        }
                        paramaelt = ((StructMsgForImageShare)localAbsStructMsg).getFirstImageElement();
                        if ((paramaelt != null) && (paramaelt.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null))
                        {
                          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramaelt.jdField_a_of_type_ComTencentMobileqqDataMessageForPic, 2);
                          ThreadManager.getFileThreadHandler().post(new StructingMsgItemBuilder.12(this, paramaelt));
                        }
                        a((StructMsgForImageShare)localAbsStructMsg);
                        if (localAbsStructMsg.adverSign != 1) {
                          break label2395;
                        }
                        paramaelt = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
                        paramaeov = new ImageView(this.jdField_a_of_type_AndroidContentContext);
                        paramaeov.setImageResource(2130841277);
                        paramaelt.setBackgroundColor(0);
                        localObject2 = new RelativeLayout.LayoutParams(aekt.a(80.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), aekt.a(44.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
                        ((RelativeLayout.LayoutParams)localObject2).addRule(11);
                        ((RelativeLayout.LayoutParams)localObject2).addRule(10);
                        paramaelt.setLayoutParams((ViewGroup.LayoutParams)localObject2);
                        localObject2 = new RelativeLayout.LayoutParams(-2, -2);
                        ((RelativeLayout.LayoutParams)localObject2).addRule(11);
                        ((RelativeLayout.LayoutParams)localObject2).addRule(10);
                        ((RelativeLayout.LayoutParams)localObject2).setMargins(0, 12, 12, 0);
                        paramaeov.setLayoutParams((ViewGroup.LayoutParams)localObject2);
                        paramaelt.addView(paramaeov);
                        if ((paramView instanceof RelativeLayout)) {
                          ((RelativeLayout)paramView).addView(paramaelt);
                        }
                        localObject2 = localMessageForStructing.frienduin;
                        l = localAbsStructMsg.msgId;
                        if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
                          paramaelt.setOnClickListener(new afxs(this, paramaeov, paramChatMessage, (String)localObject2, l));
                        }
                        if ((this.jdField_a_of_type_Bhvq != null) && (this.jdField_a_of_type_Bhvq.isShowing())) {
                          this.jdField_a_of_type_Bhvq.dismiss();
                        }
                        if ((paramBaseChatItemLayout != null) && (!aupu.a(localMessageForStructing)))
                        {
                          paramaelt = (DuiButtonImageView)paramBaseChatItemLayout.findViewById(2131365500);
                          if (paramaelt != null) {
                            break label2652;
                          }
                          paramaelt = new DuiButtonImageView(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
                          paramaeov = new RelativeLayout.LayoutParams(aekt.a(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), aekt.a(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
                          paramaeov.addRule(8, 2131364171);
                          paramaeov.addRule(1, 2131364171);
                          paramaeov.bottomMargin = (BaseChatItemLayout.h - aekt.a(6.5F, this.jdField_a_of_type_AndroidContentContext.getResources()));
                          paramaelt.setId(2131365500);
                          paramBaseChatItemLayout.addView(paramaelt, paramaeov);
                          if (((paramChatMessage.extraflag != 32768) || (!paramChatMessage.isSendFromLocal())) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramChatMessage))) {
                            break label2660;
                          }
                          i = 1;
                          if ((!paramChatMessage.isDui) || (i != 0)) {
                            break label2721;
                          }
                          if (!paramChatMessage.isSend()) {
                            break label2666;
                          }
                          paramaelt.setVisibility(8);
                        }
                        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1008) || (this.jdField_a_of_type_JavaUtilHashSet.contains(Long.valueOf(paramChatMessage.uniseq)))) {
                          break;
                        }
                        this.jdField_a_of_type_JavaUtilHashSet.add(Long.valueOf(paramChatMessage.uniseq));
                        amnk.a(117, paramChatMessage, ((afyi)localObject1).jdField_b_of_type_Int);
                        return paramView;
                        paramaelt = localMessageForStructing.getExtInfoFromExtStr("accostType");
                        if ((paramaelt == null) || (paramaelt.equals(""))) {
                          break label637;
                        }
                        try
                        {
                          localAbsStructMsg.sourceAccoutType = Integer.parseInt(paramaelt);
                        }
                        catch (Exception paramaelt) {}
                      }
                      break label637;
                      ((afyi)localObject1).jdField_a_of_type_Boolean = false;
                      break label811;
                      paramaelt = localAbsStructMsg.getView(this.jdField_a_of_type_AndroidContentContext, paramaelt, paramaeov, localBundle);
                      break label972;
                      if (localAbsStructMsg.mMsgServiceID == 61) {}
                      for (paramaelt = AbsStructMsg.getInCompatibleView(this.jdField_a_of_type_AndroidContentContext, null, paramView.getResources().getString(2131699235));; paramaelt = localAbsStructMsg.getView(this.jdField_a_of_type_AndroidContentContext, null, paramaeov, localBundle))
                      {
                        if (localObject2 != null) {
                          ((afyj)localObject2).a((String)localObject4, paramaelt, (ViewGroup)paramView);
                        }
                        break;
                      }
                      label2044:
                      if (((RelativeLayout)localObject3).getChildCount() > 0)
                      {
                        localObject2 = ((RelativeLayout)localObject3).getChildAt(0);
                        paramaelt = (aelt)localObject2;
                        if (localObject2 != null)
                        {
                          localObject4 = ((View)localObject2).getTag(2131377085);
                          if (QLog.isColorLevel()) {
                            QLog.d("structMsg", 2, "bindviwfor structmsg tag:" + localObject4);
                          }
                          if (localObject4 != null)
                          {
                            paramaelt = (aelt)localObject2;
                            if (localObject4.getClass() == localAbsStructMsg.getClass()) {}
                          }
                          else
                          {
                            paramaelt = null;
                          }
                        }
                      }
                      ((RelativeLayout)localObject3).removeAllViews();
                      if (c(paramChatMessage)) {}
                      for (;;)
                      {
                        paramaelt = localAbsStructMsg.getView(this.jdField_a_of_type_AndroidContentContext, paramaelt, paramaeov, localBundle);
                        break;
                        paramaelt = null;
                      }
                      label2168:
                      if ((!StructMsgForGeneralShare.class.isInstance(localAbsStructMsg)) || (!a(localAbsStructMsg))) {
                        break label1053;
                      }
                      a(paramBaseChatItemLayout, localMessageForStructing);
                      break label1053;
                      if (localAbsStructMsg.mMsgServiceID != 78) {
                        break label1088;
                      }
                      localObject2 = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a();
                      localObject4 = (AbsShareMsg)localAbsStructMsg;
                      if (!(localObject2 instanceof agot)) {
                        break label1088;
                      }
                      paramView.setOnClickListener(new afxq(this, (BaseChatPie)localObject2, (AbsShareMsg)localObject4));
                      break label1088;
                      label2257:
                      if ((localAbsStructMsg.mMsgServiceID == 3) || (localAbsStructMsg.mMsgServiceID == 120)) {
                        if (a()) {
                          paramView.setClickable(false);
                        } else {
                          paramView.setClickable(true);
                        }
                      }
                    }
                  }
                  catch (IllegalStateException paramaeov)
                  {
                    for (;;)
                    {
                      long l;
                      paramaeov = paramaelt.getParent();
                      if ((paramaeov != null) && ((paramaeov instanceof ViewGroup))) {
                        ((ViewGroup)paramaeov).removeAllViews();
                      }
                      ((RelativeLayout)localObject3).addView(paramaelt);
                      continue;
                      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0)
                      {
                        paramaelt = paramaelt.a();
                        if (paramaelt != null)
                        {
                          a(paramaelt.a);
                          continue;
                          label2367:
                          if (((localAbsStructMsg instanceof StructMsgForGeneralShare)) || ((localAbsStructMsg instanceof StructMsgForAudioShare)))
                          {
                            a((AbsShareMsg)localAbsStructMsg);
                            continue;
                            label2395:
                            if (localAbsStructMsg.adverSign == 2)
                            {
                              paramaelt = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
                              paramaeov = new TextView(this.jdField_a_of_type_AndroidContentContext);
                              paramaeov.setBackgroundResource(2130841427);
                              paramaeov.setGravity(17);
                              i = localAbsStructMsg.adverSign;
                              paramaeov.setText(alpo.a(2131714960));
                              paramaeov.setTextColor(-1);
                              paramaeov.setTextSize(13.0F);
                              paramaelt.setBackgroundColor(0);
                              localObject2 = new RelativeLayout.LayoutParams(aekt.a(80.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), aekt.a(44.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
                              ((RelativeLayout.LayoutParams)localObject2).addRule(11);
                              ((RelativeLayout.LayoutParams)localObject2).addRule(10);
                              paramaelt.setLayoutParams((ViewGroup.LayoutParams)localObject2);
                              localObject2 = new RelativeLayout.LayoutParams(-2, -2);
                              ((RelativeLayout.LayoutParams)localObject2).addRule(11);
                              ((RelativeLayout.LayoutParams)localObject2).addRule(10);
                              paramaeov.setLayoutParams((ViewGroup.LayoutParams)localObject2);
                              paramaelt.addView(paramaeov);
                              if ((paramView instanceof RelativeLayout)) {
                                ((RelativeLayout)paramView).addView(paramaelt);
                              }
                              localObject2 = localMessageForStructing.frienduin;
                              l = localAbsStructMsg.msgId;
                              localObject2 = localMessageForStructing.getExtInfoFromExtStr("msg_template_id");
                              i = localMessageForStructing.istroop;
                              if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
                              {
                                paramaelt.setOnClickListener(new afxt(this, paramaeov, paramChatMessage, (String)localObject2));
                                continue;
                                label2652:
                                paramaelt.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
                                continue;
                                label2660:
                                i = 0;
                                continue;
                                label2666:
                                if (!paramChatMessage.hasPlayedDui) {
                                  paramChatMessage.hasPlayedDui = DuiButtonImageView.a(paramaelt);
                                }
                                for (;;)
                                {
                                  if (!DuiButtonImageView.jdField_a_of_type_Boolean) {
                                    break label2707;
                                  }
                                  paramaelt.setOnClickListener(this);
                                  paramaelt.setVisibility(0);
                                  break;
                                  paramaelt.f();
                                }
                                paramaelt.setOnClickListener(null);
                                paramaelt.setVisibility(8);
                                continue;
                                paramaelt.setVisibility(8);
                                paramaelt.e();
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
            catch (Exception paramaelt)
            {
              for (;;) {}
            }
          }
        }
      }
    }
  }
  
  public bdkz a(bdkz parambdkz, ChatMessage paramChatMessage, aemk paramaemk)
  {
    paramaemk = (MessageForStructing)paramChatMessage;
    paramChatMessage = paramaemk.structingMsg;
    if (paramChatMessage != null) {
      if ((!(paramChatMessage instanceof AbsShareMsg)) || (!((AbsShareMsg)paramChatMessage).mMsgException)) {}
    }
    label369:
    label375:
    label379:
    for (;;)
    {
      return parambdkz;
      if ((paramChatMessage.mMsgServiceID != 86) && (paramChatMessage.mMsgServiceID != 61) && (paramChatMessage.mMsgServiceID != 91) && (paramChatMessage.mMsgServiceID != 97) && (paramChatMessage.mMsgServiceID != 98) && (!(paramChatMessage instanceof StructMsgForHypertext)) && ((!paramaemk.isSendFromLocal()) || (!(paramChatMessage instanceof AbsShareMsg)) || (!((AbsShareMsg)paramChatMessage).isSdkShareMsg()) || ((paramaemk.extraflag != 32772) && (paramaemk.extraflag != 32768))))
      {
        paramaemk = this.jdField_a_of_type_AndroidContentContext.getResources();
        int i;
        if (paramChatMessage.fwFlag != 1) {
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008) {
            if (!paramChatMessage.hasFlag(32))
            {
              parambdkz.a(2131366771, paramaemk.getString(2131692835), 2130838677);
              if ((paramChatMessage.hasFlag(2)) || ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008) && (TextUtils.isEmpty(paramChatMessage.mMsgUrl))) || (paramChatMessage.mMsgServiceID == 81)) {
                break label375;
              }
              if (paramChatMessage.mMsgServiceID != 14) {
                break label369;
              }
              i = 0;
            }
          }
        }
        for (;;)
        {
          if ((i == 0) && (!a(paramChatMessage, parambdkz))) {
            break label379;
          }
          parambdkz.a(2131366015, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692400), 2130838676);
          return parambdkz;
          if (paramChatMessage.hasFlag(1)) {
            break;
          }
          parambdkz.a(2131366750, paramaemk.getString(2131692835), 2130838677);
          break;
          if (paramChatMessage.mMsgServiceID == 14) {
            break;
          }
          if (!paramChatMessage.hasFlag(1))
          {
            parambdkz.a(2131366750, paramaemk.getString(2131692835), 2130838677);
            break;
          }
          if (paramChatMessage.mMsgServiceID != 35) {
            break;
          }
          parambdkz.a(2131366750, paramaemk.getString(2131692835), 2130838677);
          break;
          i = 1;
          continue;
          i = 0;
        }
      }
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (bdec.a(paramChatMessage.issend)) {
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
    Object localObject6 = agej.a(paramChatMessage);
    Object localObject1;
    if (paramInt == 2131362126) {
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
        localObject1 = baul.a(paramChatMessage, 1);
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
                  agem.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (URLDrawable)localObject1, paramChatMessage.frienduin, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914), paramContext, null);
                } while (!agej.a((String)localObject6));
                biiv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "3009", "2", "40053", agej.b((String)localObject6), new String[] { "1", "", agej.a((String)localObject6) });
                return;
                if (paramInt != 2131366750) {
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
          if ((localObject2 != null) && (((azsp)localObject2).a()))
          {
            paramContext.putExtra("key_forward_image_share", true);
            paramContext.putExtra("key_forward_image_share_appid", Long.toString(((StructMsgForImageShare)localObject1).mSourceAppid));
            paramContext.putExtra("key_forward_image_share_uin_type", ((StructMsgForImageShare)localObject1).uinType);
          }
          arum.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramContext, 21);
          paramContext = paramChatMessage.structingMsg.mMsgUrl;
          localObject1 = paramChatMessage.senderuin;
          localObject2 = Long.toString(paramChatMessage.structingMsg.msgId);
          azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005455", "0X8005455", 0, 0, (String)localObject1, paramContext, (String)localObject2, "");
          azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
          if (paramChatMessage.structingMsg.mMsgServiceID == 84) {
            azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8007166", "0X8007166", 0, 0, "", "", "", "");
          }
          if (agej.a((String)localObject6)) {
            biiv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "3009", "2", "40053", agej.b((String)localObject6), new String[] { "2", "", agej.a((String)localObject6) });
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
          azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D66", "0X8009D66", paramInt, 0, "" + paramInt, "", "", "");
          return;
          if ((paramChatMessage.structingMsg != null) && (paramChatMessage.structingMsg.mMsgServiceID == 35))
          {
            azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006624", "0X8006624", 0, 1, 0, "", "", "", "");
            if (!aukx.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.uniseq))
            {
              paramInt = paramContext.getResources().getDimensionPixelSize(2131298914);
              QQToast.a(paramContext, alpo.a(2131714967), 0).b(paramInt);
              return;
            }
            if (!aukx.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.uniseq)) {
              break;
            }
            bdcd.a(paramContext, 230, null, "选择的消息中，部分图片\\表情等内容可能无法正常转发，是否继续转发？", alpo.a(2131714959), alpo.a(2131714969), new afxp(this, paramChatMessage), new afxx(this)).show();
            return;
          }
          if ((paramChatMessage.structingMsg == null) || (paramChatMessage.structingMsg.mMsgServiceID != 81)) {
            break;
          }
          wta.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramChatMessage, "forward");
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
        if (paramInt != 2131365069) {
          break;
        }
        acex.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
        if (agej.a((String)localObject6)) {
          biiv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "3009", "2", "40053", agej.b((String)localObject6), new String[] { "5", "", agej.a((String)localObject6) });
        }
      } while ((paramChatMessage == null) || (!(paramChatMessage instanceof MessageForStructing)));
      paramContext = (MessageForStructing)paramChatMessage;
    } while ((paramContext.structingMsg == null) || (paramContext.structingMsg.mMsgServiceID != 81));
    wta.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramContext, "delete");
    return;
    long l2;
    long l1;
    if (paramInt == 2131370842)
    {
      super.d(paramChatMessage);
      if (agej.a((String)localObject6)) {
        biiv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "3009", "2", "40053", agej.b((String)localObject6), new String[] { "6", "", agej.a((String)localObject6) });
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
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X80064F7", "0X80064F7", 0, 0, paramContext, String.valueOf(l2), String.valueOf(paramInt), "");
      if ((paramChatMessage == null) || (!(paramChatMessage instanceof MessageForStructing))) {
        break;
      }
      paramContext = (MessageForStructing)paramChatMessage;
      if ((paramContext.structingMsg == null) || (paramContext.structingMsg.mMsgServiceID != 81)) {
        break;
      }
      wta.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramContext, "more");
      return;
      MessageForStructing localMessageForStructing;
      AbsShareMsg localAbsShareMsg;
      if (paramInt == 2131366015)
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
          if (agej.a((String)localObject6))
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
            if (((azsp)localObject2).jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare == null) {
              ((azsp)localObject2).jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare = ((StructMsgForImageShare)localAbsShareMsg);
            }
            localObject5 = agem.a(((azsp)localObject2).a());
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
            Object localObject7 = localObject1[3] + alpo.a(2131714958) + localObject1[5] + alpo.a(2131714964);
            localObject5 = "ADTAG=comic.plugin.read&id=" + localObject1[0] + "&name=" + URLEncoder.encode(localObject1[1]) + "&sectionID=" + localObject1[2] + "&sectionName=" + URLEncoder.encode(localObject1[3]) + "&pageID=" + localObject1[4] + "&page=" + localObject1[5] + "&type=" + localObject1[6];
            localObject4 = localObject5;
            if (!TextUtils.isEmpty(paramContext)) {
              localObject4 = (String)localObject5 + "&scrawl_link=" + URLEncoder.encode(paramContext);
            }
            paramContext = VipComicJumpActivity.a("comicReadShare", "5123", null, null, "354", null, (String)localObject4);
            new biqt(6).a("nLinkType", 0).b("sTitle", localObject1[1]).b("sUrl", paramContext).a("bAppShare", false).a("lAppId", 0L).b("sPublisher", localAbsShareMsg.mSourceName).b("sBrief", (String)localObject7).b("sPath", (String)localObject2).b("sResUrl", localAbsShareMsg.mSourceUrl).a("lCategory", 1L).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
            birh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 2);
            birh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 8, 0, localAbsShareMsg.uinType);
            biiv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "3009", "2", "40053", agej.b((String)localObject6), new String[] { "3", "", agej.a((String)localObject6) });
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
                  paramContext = birl.a((StructMsgForImageShare)localAbsShareMsg);
                  if (paramContext != null)
                  {
                    biqt.a(paramContext.U, localAbsShareMsg.uinType, paramContext.T, paramContext.c, paramContext.S, paramContext.d).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
                    birh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2, 0, localAbsShareMsg.uinType);
                    birh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 3);
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
                  azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D67", "0X8009D67", paramInt, 0, "" + paramInt, "", "", "");
                  return;
                  paramInt = 0;
                  break label1715;
                  if (!agej.b((String)localObject6)) {
                    break label4331;
                  }
                  paramContext = agej.b((String)localObject6);
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
                    localObject4 = agem.a(paramContext.a());
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
                  biqt.a((String)localObject2).c(paramContext).a((Activity)this.jdField_a_of_type_AndroidContentContext, paramContext);
                  birh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 7, 0, localAbsShareMsg.uinType);
                  birh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 2);
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
                    ((afar)paramContext.a(11)).a(paramContext, null, (MessageForStructing)paramChatMessage);
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
                  biqt.a(Float.valueOf(paramContext).floatValue(), Float.valueOf((String)localObject1).floatValue(), (String)localObject4, (String)localObject2, null).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
                  birh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 11, 0, localAbsShareMsg.uinType);
                  birh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 7);
                  return;
                }
              }
              localObject4 = birl.a(localAbsShareMsg.getXmlBytes());
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
                    biqt.a(null, false, localAbsShareMsg.mContentTitle, localAbsShareMsg.mContentSummary, false, 0L, "").b("sBizDataList", paramContext).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
                    birh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 10, 0, localAbsShareMsg.uinType);
                    birh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, i);
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
                    if ((localObject1 instanceof azua))
                    {
                      localObject5 = ((azua)localObject1).a.iterator();
                      localObject1 = paramContext;
                      if (!((Iterator)localObject5).hasNext()) {
                        break label4317;
                      }
                      localObject1 = (azqj)((Iterator)localObject5).next();
                      if (!(localObject1 instanceof azvm)) {
                        continue;
                      }
                      localObject5 = (azvm)localObject1;
                      paramContext = ((azvm)localObject5).S;
                      localObject1 = paramContext;
                      if (!((azvm)localObject5).a()) {
                        break label4317;
                      }
                      ntd.a("0X8006601", ((StructMsgForGeneralShare)localAbsShareMsg).uinType, ntd.a(((azvm)localObject5).r, ((StructMsgForGeneralShare)localObject2).mSourceName), ((azvm)localObject5).U, "");
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
                    localObject3 = bdbt.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), true);
                    localObject1 = localObject3;
                    if (TextUtils.isEmpty((CharSequence)localObject3)) {
                      localObject1 = localAbsShareMsg.mContentSrc;
                    }
                    biqt.a(paramInt, localAbsShareMsg.mContentTitle, localAbsShareMsg.mMsgUrl, localAbsShareMsg.mSourceName, localAbsShareMsg.mContentSummary, paramContext, (String)localObject1, (byte[])localObject4, false, 0L).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a("lCategory", 10L).b("sUin", localAbsShareMsg.mSourceName).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
                    birh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 8, 0, localAbsShareMsg.uinType);
                  }
                  else
                  {
                    localObject6 = new ArrayList();
                    localObject5 = localAbsShareMsg.mContentSummary;
                    if (a(localAbsShareMsg))
                    {
                      ((ArrayList)localObject6).add(biqv.a(true));
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
                      birh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 10, 0, localAbsShareMsg.uinType);
                    }
                    for (;;)
                    {
                      biqt.a(j, localAbsShareMsg.mContentTitle, localAbsShareMsg.mMsgUrl, localAbsShareMsg.mSourceName, (String)localObject1, paramContext, localAbsShareMsg.mContentSrc, (byte[])localObject3, false, 0L).b("sBizDataList", (ArrayList)localObject6).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
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
                      localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131698438) + (String)localObject7;
                      localObject3 = null;
                      j = paramInt;
                      break label3746;
                      if (badt.a(localAbsShareMsg.mMsgUrl)) {
                        birh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 12, 0, localAbsShareMsg.uinType);
                      } else {
                        birh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 8, 0, localAbsShareMsg.uinType);
                      }
                    }
                    paramInt = 2;
                    break label2451;
                    paramInt = 7;
                    break label2451;
                    if (paramInt == 2131364910)
                    {
                      paramContext = (MessageForStructing)paramChatMessage;
                      if ((paramContext == null) || (paramContext.structingMsg == null) || (!"web".equals(paramContext.structingMsg.mMsgAction)) || (paramContext.structingMsg.mMsgUrl == null)) {
                        break;
                      }
                      ((ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(paramContext.structingMsg.mMsgUrl);
                      return;
                    }
                    if (paramInt == 2131370831)
                    {
                      d(paramChatMessage);
                      return;
                    }
                    if (paramInt == 2131366771)
                    {
                      ThreadManager.post(new StructingMsgItemBuilder.4(this, paramChatMessage, paramContext), 8, null, false);
                      return;
                    }
                    if (paramInt == 2131370799)
                    {
                      super.a(paramChatMessage);
                      if (agej.a((String)localObject6)) {
                        biiv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "3009", "2", "40053", agej.b((String)localObject6), new String[] { "4", "", agej.a((String)localObject6) });
                      }
                      if ((paramChatMessage == null) || (!(paramChatMessage instanceof MessageForStructing))) {
                        break;
                      }
                      paramContext = (MessageForStructing)paramChatMessage;
                      if ((paramContext.structingMsg == null) || (paramContext.structingMsg.mMsgServiceID != 81)) {
                        break;
                      }
                      wta.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramContext, "withdraw");
                      return;
                    }
                    if (paramInt == 2131363921)
                    {
                      paramContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramChatMessage.frienduin, paramChatMessage.uniseq);
                      if ((paramContext == null) || (!(paramContext instanceof bamw))) {
                        break;
                      }
                      ((bamw)paramContext).a();
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
    if (aekt.a(paramView).isMultiMsg) {}
    Object localObject2;
    ChatMessage localChatMessage;
    String str1;
    do
    {
      do
      {
        return;
        localObject1 = aekt.a(paramView);
      } while (!afyi.class.isInstance(localObject1));
      localObject2 = this.jdField_a_of_type_AndroidContentContext;
      localChatMessage = ((afyi)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      localObject1 = a(localChatMessage);
      if (localObject1 != null)
      {
        a(paramView, (StructMsgForGeneralShare)localObject1);
        return;
      }
      paramView = ((Context)localObject2).getString(2131690042);
      str1 = ((Context)localObject2).getString(2131690043);
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
        paramView = alpo.a(2131714961);
        localObject2 = alpo.a(2131714962);
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label282;
        }
      }
    }
    for (;;)
    {
      localObject2 = (bhpy)bhql.a(this.jdField_a_of_type_AndroidContentContext, null);
      ((bhpy)localObject2).c(paramView);
      ((bhpy)localObject2).d(this.jdField_a_of_type_AndroidContentContext.getString(2131690648));
      ((bhpy)localObject2).a((CharSequence)localObject1);
      ((bhpy)localObject2).a(new afyd(this, bool, localChatMessage, (bhpy)localObject2));
      ((bhpy)localObject2).show();
      return;
      paramView = alpo.a(2131714963);
      break;
      bdcd.a((Context)localObject2, 230, paramView, str1, new afye(this, localChatMessage, (Context)localObject2), new afyf(this)).show();
      return;
      label282:
      localObject1 = localObject2;
    }
  }
  
  public void a(View paramView, baoj parambaoj, int paramInt1, int paramInt2)
  {
    if (!BaseChatItemLayout.class.isInstance(paramView)) {}
    do
    {
      return;
      if ((parambaoj.jdField_b_of_type_Int == 1) || (parambaoj.jdField_b_of_type_Int == 131075))
      {
        b(paramView, parambaoj, paramInt1, paramInt2);
        return;
      }
    } while (parambaoj.jdField_b_of_type_Int != 52);
    c(paramView, parambaoj, paramInt1, paramInt2);
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    super.a(paramView, paramChatMessage);
    MessageForStructing localMessageForStructing;
    int i;
    if ((paramChatMessage instanceof MessageForStructing))
    {
      localMessageForStructing = (MessageForStructing)paramChatMessage;
      boolean bool = swn.a(localMessageForStructing.structingMsg);
      if (((bool) && (!localMessageForStructing.structingMsg.hasFlag(4))) || (localMessageForStructing.structingMsg.mMsgServiceID == 83) || (localMessageForStructing.structingMsg.mMsgServiceID == 108) || (localMessageForStructing.structingMsg.mMsgServiceID == 151) || (localMessageForStructing.structingMsg.mMsgServiceID == 156))
      {
        if ((!bool) || (localMessageForStructing.structingMsg.hasFlag(4))) {
          break label201;
        }
        i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296297);
        if (!paramChatMessage.isSend()) {
          break label261;
        }
        paramView.setPadding(BaseChatItemLayout.j, BaseChatItemLayout.g, i, BaseChatItemLayout.h);
      }
    }
    for (;;)
    {
      if (localMessageForStructing.structingMsg.mMsgServiceID == 107)
      {
        paramChatMessage = this.jdField_a_of_type_AndroidContentContext.getResources();
        paramView.setPadding(aekt.a(1.5F, paramChatMessage), aekt.a(2.0F, paramChatMessage), aekt.a(1.5F, paramChatMessage), paramView.getPaddingBottom());
      }
      return;
      label201:
      if ((localMessageForStructing.structingMsg.mMsgServiceID == 114) || (localMessageForStructing.structingMsg.mMsgServiceID == 116))
      {
        i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296298);
        break;
      }
      i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296302);
      break;
      label261:
      paramView.setPadding(i, BaseChatItemLayout.g, BaseChatItemLayout.j, BaseChatItemLayout.h);
    }
  }
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, aelt paramaelt, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramaelt, paramInt1, paramInt2);
    if ((!(paramChatMessage instanceof MessageForStructing)) || (((MessageForStructing)paramChatMessage).structingMsg == null)) {}
    do
    {
      return;
      paramBaseChatItemLayout = (MessageForStructing)paramChatMessage;
      paramInt1 = paramBaseChatItemLayout.structingMsg.mMsgServiceID;
    } while ((a(paramBaseChatItemLayout)) || (paramInt1 == 83) || (paramInt1 == 151) || (paramInt1 == 156) || (paramInt1 == 108) || (paramInt1 == 114) || (paramInt1 == 98) || (paramInt1 == 97) || (paramInt1 == 5) || (paramInt1 == 137) || (paramInt1 == 106) || (paramInt1 == 107) || (paramInt1 == 122) || (paramInt1 == 116));
    paramInt2 = paramaelt.jdField_a_of_type_AndroidViewView.getPaddingLeft();
    int i = paramaelt.jdField_a_of_type_AndroidViewView.getPaddingRight();
    int m = paramaelt.jdField_a_of_type_AndroidViewView.getPaddingTop();
    int n = paramaelt.jdField_a_of_type_AndroidViewView.getPaddingBottom();
    int j = aekt.a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    boolean bool = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    int k;
    if (paramChatMessage.isSend())
    {
      paramInt1 = paramInt2;
      if (paramInt2 > j) {
        paramInt1 = paramInt2 - j;
      }
      paramaelt.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130849371);
      j = paramInt1;
      k = i;
      if (bool)
      {
        j = paramInt1;
        k = i;
        if (paramaelt.jdField_a_of_type_AndroidViewView.getParent() != null)
        {
          j = paramInt1;
          k = i;
          if ((paramaelt.jdField_a_of_type_AndroidViewView.getParent() instanceof RelativeLayout))
          {
            paramBaseChatItemLayout = (RelativeLayout)paramaelt.jdField_a_of_type_AndroidViewView.getParent();
            paramContext = new View(paramContext);
            localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
            localLayoutParams.addRule(6, 2131364171);
            localLayoutParams.addRule(5, 2131364171);
            localLayoutParams.addRule(7, 2131364171);
            localLayoutParams.addRule(8, 2131364171);
            if (paramaelt.jdField_b_of_type_AndroidViewView != null) {
              paramBaseChatItemLayout.removeView(paramaelt.jdField_b_of_type_AndroidViewView);
            }
            if (!aule.a(paramChatMessage)) {
              break label440;
            }
            paramContext.setBackgroundResource(2130849368);
            paramaelt.jdField_b_of_type_AndroidViewView = paramContext;
            paramBaseChatItemLayout.addView(paramaelt.jdField_b_of_type_AndroidViewView, localLayoutParams);
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
          paramaelt.jdField_a_of_type_AndroidViewView.setPadding(j, m, k, n);
          return;
          paramContext.setBackgroundResource(2130849367);
          break;
          paramInt1 = i;
          if (i > j) {
            paramInt1 = i - j;
          }
          paramaelt.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130849195);
          j = paramInt2;
          k = paramInt1;
        } while (!bool);
        j = paramInt2;
        k = paramInt1;
      } while (paramaelt.jdField_a_of_type_AndroidViewView.getParent() == null);
      j = paramInt2;
      k = paramInt1;
    } while (!(paramaelt.jdField_a_of_type_AndroidViewView.getParent() instanceof RelativeLayout));
    paramBaseChatItemLayout = (RelativeLayout)paramaelt.jdField_a_of_type_AndroidViewView.getParent();
    paramContext = new View(paramContext);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(6, 2131364171);
    localLayoutParams.addRule(5, 2131364171);
    localLayoutParams.addRule(7, 2131364171);
    localLayoutParams.addRule(8, 2131364171);
    if (paramaelt.jdField_b_of_type_AndroidViewView != null) {
      paramBaseChatItemLayout.removeView(paramaelt.jdField_b_of_type_AndroidViewView);
    }
    if (aule.a(paramChatMessage)) {
      paramContext.setBackgroundResource(2130849192);
    }
    for (;;)
    {
      paramaelt.jdField_b_of_type_AndroidViewView = paramContext;
      paramBaseChatItemLayout.addView(paramaelt.jdField_b_of_type_AndroidViewView, localLayoutParams);
      j = paramInt2;
      k = paramInt1;
      break;
      paramContext.setBackgroundResource(2130849191);
    }
  }
  
  public void a(MessageForStructing paramMessageForStructing) {}
  
  public void a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage, long paramLong, float paramFloat) {}
  
  public void a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage, boolean paramBoolean)
  {
    paramXListView = aekt.a(paramView);
    if ((paramXListView instanceof afyi)) {}
    for (paramXListView = (afyi)paramXListView;; paramXListView = null)
    {
      if (paramXListView != null)
      {
        paramXListView = (ViewGroup)paramXListView.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
        int i = paramXListView.getChildCount();
        paramInt = 0;
        while (paramInt < i)
        {
          if ((paramXListView.getChildAt(paramInt).getTag() instanceof azss))
          {
            paramView = (azss)paramXListView.getChildAt(paramInt).getTag();
            if ((paramView.jdField_a_of_type_AndroidViewView.getTag() instanceof azuw))
            {
              paramView = (ImageView)((azuw)paramView.jdField_a_of_type_AndroidViewView.getTag()).c;
              paramView.clearAnimation();
              paramView.setBackgroundResource(2130841463);
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
  
  public boolean a(aelt paramaelt)
  {
    return paramaelt instanceof afyi;
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
      paramString2 = azqu.a(paramString1.getExtras());
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
        if ((localObject == null) || (((azsp)localObject).d > 0L)) {
          break;
        }
        paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramChatMessage.frienduin, paramChatMessage.uniseq);
        if ((paramChatMessage instanceof bamw))
        {
          if (((bamw)paramChatMessage).c() == 1005L) {}
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
  
  public boolean a(AbsShareMsg paramAbsShareMsg)
  {
    if (paramAbsShareMsg == null) {}
    do
    {
      return false;
      if (syb.b(paramAbsShareMsg.mMsgUrl)) {
        return true;
      }
    } while (((TextUtils.isEmpty(paramAbsShareMsg.mSource_A_ActionData)) || (!paramAbsShareMsg.mSource_A_ActionData.contains("pubaccount"))) && ((TextUtils.isEmpty(paramAbsShareMsg.mSource_I_ActionData)) || (!paramAbsShareMsg.mSource_I_ActionData.contains("public_account"))));
    return true;
  }
  
  public boolean a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage)
  {
    paramXListView = aekt.a(paramView);
    if ((paramXListView instanceof afyi)) {}
    for (paramXListView = (afyi)paramXListView;; paramXListView = null)
    {
      if (paramXListView != null)
      {
        paramXListView = (ViewGroup)paramXListView.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
        int i = paramXListView.getChildCount();
        paramInt = 0;
        while (paramInt < i)
        {
          if ((paramXListView.getChildAt(paramInt).getTag() instanceof azss))
          {
            paramView = (azss)paramXListView.getChildAt(paramInt).getTag();
            if ((paramView.jdField_a_of_type_AndroidViewView.getTag() instanceof azuw)) {
              return bdcs.b(((azuw)paramView.jdField_a_of_type_AndroidViewView.getTag()).jdField_a_of_type_JavaLangString);
            }
          }
          paramInt += 1;
        }
      }
      return false;
    }
  }
  
  public boolean a(XListView paramXListView, int paramInt1, View paramView, ChatMessage paramChatMessage, AudioPlayer paramAudioPlayer, int paramInt2)
  {
    Object localObject = aekt.a(paramView);
    if ((localObject instanceof afyi)) {}
    for (localObject = (afyi)localObject;; localObject = null)
    {
      if (localObject != null)
      {
        localObject = (ViewGroup)((afyi)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
        int i = ((ViewGroup)localObject).getChildCount();
        paramInt2 = 0;
        while (paramInt2 < i)
        {
          if (((((ViewGroup)localObject).getChildAt(paramInt2).getTag() instanceof azss)) && (a(paramXListView, paramInt1, paramView, paramChatMessage)))
          {
            azss localazss = (azss)((ViewGroup)localObject).getChildAt(paramInt2).getTag();
            if ((localazss.jdField_a_of_type_AndroidViewView.getTag() instanceof azuw)) {
              paramAudioPlayer.a(((azuw)localazss.jdField_a_of_type_AndroidViewView.getTag()).jdField_a_of_type_JavaLangString);
            }
          }
          paramInt2 += 1;
        }
        return true;
      }
      return false;
    }
  }
  
  public bdlb[] a(View paramView)
  {
    paramView = (MessageForStructing)aekt.a(paramView);
    bdkz localbdkz = new bdkz();
    if (paramView != null)
    {
      if (!paramView.isMultiMsg) {
        break label40;
      }
      a(localbdkz, paramView, null);
    }
    for (;;)
    {
      return localbdkz.a();
      label40:
      b(localbdkz, paramView, null);
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
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5A7", "0X800A5A7", 0, 0, "" + i, "", "", "");
      return;
    }
  }
  
  public bdkz b(bdkz parambdkz, ChatMessage paramChatMessage, aemk paramaemk)
  {
    paramaemk = (MessageForStructing)paramChatMessage;
    AbsStructMsg localAbsStructMsg = paramaemk.structingMsg;
    if (localAbsStructMsg != null)
    {
      if (((localAbsStructMsg instanceof AbsShareMsg)) && (((AbsShareMsg)localAbsStructMsg).mMsgException))
      {
        acex.a(parambdkz, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008) {
          super.c(parambdkz, this.jdField_a_of_type_AndroidContentContext);
        }
        super.e(parambdkz, this.jdField_a_of_type_AndroidContentContext);
        return parambdkz;
      }
      if (localAbsStructMsg.mMsgServiceID == 86)
      {
        acex.a(parambdkz, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        super.e(parambdkz, this.jdField_a_of_type_AndroidContentContext);
        return parambdkz;
      }
      if (localAbsStructMsg.mMsgServiceID == 61)
      {
        acex.a(parambdkz, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        super.e(parambdkz, this.jdField_a_of_type_AndroidContentContext);
        return parambdkz;
      }
      if (localAbsStructMsg.mMsgServiceID == 91)
      {
        acex.a(parambdkz, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        super.e(parambdkz, this.jdField_a_of_type_AndroidContentContext);
        return parambdkz;
      }
      if (localAbsStructMsg.mMsgServiceID == 97)
      {
        acex.a(parambdkz, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        super.e(parambdkz, this.jdField_a_of_type_AndroidContentContext);
        return parambdkz;
      }
      if (localAbsStructMsg.mMsgServiceID == 98)
      {
        acex.a(parambdkz, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        super.e(parambdkz, this.jdField_a_of_type_AndroidContentContext);
        return parambdkz;
      }
      if (localAbsStructMsg.mMsgServiceID == 128)
      {
        a(paramaemk, parambdkz);
        acex.a(parambdkz, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        b(paramaemk, parambdkz);
        bdaj.a("Grp_AIO", "invite", "send_in", 0, 0, new String[0]);
        return parambdkz;
      }
      if ((localAbsStructMsg instanceof StructMsgForHypertext))
      {
        acex.a(parambdkz, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        super.c(parambdkz, this.jdField_a_of_type_AndroidContentContext);
        super.e(parambdkz, this.jdField_a_of_type_AndroidContentContext);
        return parambdkz;
      }
      if ((paramaemk.isSendFromLocal()) && ((localAbsStructMsg instanceof AbsShareMsg)) && (((AbsShareMsg)localAbsStructMsg).isSdkShareMsg()) && ((paramaemk.extraflag == 32772) || (paramaemk.extraflag == 32768)))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramaemk.frienduin, paramaemk.uniseq) != null) {
          parambdkz.a(2131363921, this.jdField_a_of_type_AndroidContentContext.getString(2131690759), 2130838666);
        }
        for (;;)
        {
          super.e(parambdkz, this.jdField_a_of_type_AndroidContentContext);
          return parambdkz;
          acex.a(parambdkz, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        }
      }
      if ((localAbsStructMsg instanceof StructMsgForImageShare))
      {
        azsp localazsp = ((StructMsgForImageShare)localAbsStructMsg).getFirstImageElement();
        if (localazsp == null) {
          break label1459;
        }
        paramChatMessage = localazsp.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
        if (paramChatMessage != null) {
          break label1456;
        }
        if (localazsp.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare == null)
        {
          localazsp.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare = ((StructMsgForImageShare)localAbsStructMsg);
          localazsp.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.message = paramaemk;
        }
        localazsp.a(this.jdField_a_of_type_AndroidContentContext, null, null);
        paramChatMessage = localazsp.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
      }
    }
    for (;;)
    {
      int i;
      if ((paramChatMessage != null) && (baul.a(this.jdField_a_of_type_AndroidContentContext, paramChatMessage, 65537)))
      {
        i = 1;
        if ((paramChatMessage == null) || (paramChatMessage.imageType != 2000)) {
          break label623;
        }
      }
      label623:
      for (int j = 1;; j = 0)
      {
        if ((i != 0) || (j != 0)) {
          break label629;
        }
        super.e(parambdkz, this.jdField_a_of_type_AndroidContentContext);
        return parambdkz;
        i = 0;
        break;
      }
      label629:
      parambdkz.a(2131362126, this.jdField_a_of_type_AndroidContentContext.getString(2131693475), 2130838675);
      paramChatMessage = this.jdField_a_of_type_AndroidContentContext.getResources();
      if (localAbsStructMsg.fwFlag != 1)
      {
        if (localAbsStructMsg.hasFlag(8)) {
          parambdkz.a(2131364910, paramChatMessage.getString(2131691359), 2130838669);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008) {
          if (!localAbsStructMsg.hasFlag(32))
          {
            parambdkz.a(2131366771, paramChatMessage.getString(2131692835), 2130838677);
            a(paramaemk, parambdkz);
            if (localAbsStructMsg.hasFlag(2)) {
              break label1444;
            }
            if (((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008) && (TextUtils.isEmpty(localAbsStructMsg.mMsgUrl))) || (localAbsStructMsg.mMsgServiceID == 81)) {
              break label1450;
            }
            if (localAbsStructMsg.mMsgServiceID != 14) {
              break label1432;
            }
            j = 0;
          }
        }
      }
      for (;;)
      {
        label795:
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
        label1432:
        label1444:
        for (i = 0;; i = 0)
        {
          if ((paramaemk.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramaemk)))
          {
            int k = 1;
            j = k;
            if (paramaemk.istroop == 1)
            {
              j = k;
              if (localAbsStructMsg != null) {
                if ((localAbsStructMsg.mMsgServiceID != 23) && (localAbsStructMsg.mMsgServiceID != 19) && (localAbsStructMsg.mMsgServiceID != 60) && (!alpo.a(2131714968).equals(localAbsStructMsg.getSourceName())))
                {
                  j = k;
                  if (localAbsStructMsg.mMsgUrl != null)
                  {
                    j = k;
                    if (!localAbsStructMsg.mMsgUrl.startsWith("http://qqweb.qq.com/m/qunactivity")) {}
                  }
                }
                else
                {
                  j = 0;
                }
              }
            }
            if (((1008 != paramaemk.istroop) || (!aljq.u.equals(paramaemk.frienduin))) && ((localAbsStructMsg == null) || (localAbsStructMsg.mMsgUrl == null) || (!localAbsStructMsg.mMsgUrl.startsWith("http://ti.qq.com/remind/view.html"))))
            {
              k = j;
              if (localAbsStructMsg != null)
              {
                k = j;
                if (localAbsStructMsg.mMsgUrl != null)
                {
                  k = j;
                  if (!localAbsStructMsg.mMsgUrl.startsWith("https://mqq.tenpay.com")) {}
                }
              }
            }
            else
            {
              k = 0;
            }
            j = k;
            if (localAbsStructMsg != null)
            {
              j = k;
              if (localAbsStructMsg.mMsgServiceID == 49) {
                j = 0;
              }
            }
            if (j != 0) {
              a(parambdkz, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramaemk);
            }
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1008) || (parambdkz.a() == 0)) {
            a(parambdkz, paramaemk);
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
          if ((j != 0) || (a(localAbsStructMsg, parambdkz))) {
            parambdkz.a(2131366015, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692400), 2130838676);
          }
          if ((localAbsStructMsg != null) && (localAbsStructMsg.mMsgServiceID != 49) && (localAbsStructMsg.mMsgServiceID != 106) && (localAbsStructMsg.mMsgServiceID != 14)) {
            super.c(parambdkz, this.jdField_a_of_type_AndroidContentContext);
          }
          if ((localAbsStructMsg != null) && (localAbsStructMsg.mMsgServiceID == 81)) {
            wta.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramaemk, "press");
          }
          super.e(parambdkz, this.jdField_a_of_type_AndroidContentContext);
          b(paramaemk, parambdkz);
          return parambdkz;
          if (localAbsStructMsg.hasFlag(1)) {
            break;
          }
          parambdkz.a(2131366750, paramChatMessage.getString(2131692835), 2130838677);
          break;
          if (localAbsStructMsg.mMsgServiceID == 14) {
            break;
          }
          if (!localAbsStructMsg.hasFlag(1))
          {
            parambdkz.a(2131366750, paramChatMessage.getString(2131692835), 2130838677);
            break;
          }
          if (localAbsStructMsg.mMsgServiceID != 35) {
            break;
          }
          parambdkz.a(2131366750, paramChatMessage.getString(2131692835), 2130838677);
          azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006625", "0X8006625", 0, 1, 0, "", "", "", "");
          break;
          j = 1;
          break label795;
          a(paramaemk, parambdkz);
        }
        label1450:
        j = 0;
      }
      label1456:
      continue;
      label1459:
      paramChatMessage = null;
    }
  }
  
  protected void b(View paramView, baoj parambaoj, int paramInt1, int paramInt2)
  {
    paramView = aekt.a(paramView);
    if (!afyi.class.isInstance(paramView)) {}
    ChatMessage localChatMessage;
    do
    {
      do
      {
        return;
        paramView = (afyi)paramView;
      } while ((!afyi.class.isInstance(paramView)) || (paramView.jdField_a_of_type_AndroidWidgetRelativeLayout == null) || (!MessageForStructing.class.isInstance(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage)));
      localChatMessage = paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if ((localChatMessage.uniseq == parambaoj.jdField_b_of_type_Long) && (localChatMessage.isSendFromLocal()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("structMsg", 2, "handleMessage status = " + paramInt1 + ", retCode = " + paramInt2 + ", message.uniseq = " + localChatMessage.uniseq + ", file.uniseq = " + parambaoj.jdField_b_of_type_Long);
        }
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localChatMessage.frienduin, localChatMessage.uniseq), paramView);
        if (paramInt1 == 1005) {
          b();
        }
      }
    } while ((localChatMessage.uniseq != parambaoj.jdField_b_of_type_Long) || (paramInt1 != 2003) || (!(((MessageForStructing)localChatMessage).structingMsg instanceof StructMsgForImageShare)));
    paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
    parambaoj = new Bundle();
    paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(((MessageForStructing)localChatMessage).structingMsg.getView(this.jdField_a_of_type_AndroidContentContext, null, null, parambaoj));
  }
  
  public boolean b(ChatMessage paramChatMessage)
  {
    return true;
  }
  
  protected void c(View paramView, baoj parambaoj, int paramInt1, int paramInt2)
  {
    paramView = aekt.a(paramView);
    if (!afyi.class.isInstance(paramView)) {}
    do
    {
      do
      {
        do
        {
          return;
          paramView = (afyi)paramView;
        } while ((!afyi.class.isInstance(paramView)) || (paramView.jdField_a_of_type_AndroidWidgetRelativeLayout == null) || (!MessageForStructing.class.isInstance(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage)));
        paramView = paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      } while ((paramView.uniseq != parambaoj.jdField_b_of_type_Long) || (!paramView.isSendFromLocal()));
      if (QLog.isColorLevel()) {
        QLog.d("structMsg", 2, "handleMessage status = " + paramInt1 + ", retCode = " + paramInt2 + ", message.uniseq = " + paramView.uniseq + ", file.uniseq = " + parambaoj.jdField_b_of_type_Long);
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
      if ((paramChatMessage != null) && (bamw.class.isInstance(paramChatMessage)))
      {
        a(paramBaseChatItemLayout, ((bamw)paramChatMessage).a(), 0, 0);
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
    bdyv localbdyv = (bdyv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(76);
    bdyu localbdyu = localbdyv.a();
    if ((localbdyu != null) && (localbdyu.d == 0L) && (localbdyu.a != 0L)) {
      localbdyv.a(localbdyu.a);
    }
    long l2;
    if ((localbdyu != null) && (localbdyu.d == 1L))
    {
      l2 = localbdyv.a - (NetConnInfoCenter.getServerTimeMillis() - localbdyu.e);
      if (l2 > 0L) {
        break label127;
      }
    }
    for (;;)
    {
      new Handler(this.jdField_a_of_type_AndroidContentContext.getMainLooper()).postDelayed(new StructingMsgItemBuilder.8(this, localbdyu, localbdyv), l1);
      return;
      label127:
      l1 = l2;
    }
  }
  
  public void onClick(View paramView)
  {
    BaseChatPie localBaseChatPie;
    StructMsgForImageShare localStructMsgForImageShare;
    azsp localazsp;
    if (paramView.getId() == 2131365500)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StructingMsgItemBuilder", 2, "[Doutu] Dui Button Clicked.");
      }
      if (QLog.isColorLevel()) {
        QLog.d("StructingMsgItemBuilder", 2, "[Doutu] Dui Button Clicked.");
      }
      localObject = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
      if (localObject == null) {
        break label192;
      }
      localBaseChatPie = ((ChatFragment)localObject).a();
      if (localBaseChatPie == null) {
        break label173;
      }
      localObject = (MessageForStructing)((afyi)aekt.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if ((localObject == null) || (((MessageForStructing)localObject).structingMsg == null) || (!(((MessageForStructing)localObject).structingMsg instanceof StructMsgForImageShare))) {
        break label211;
      }
      localStructMsgForImageShare = (StructMsgForImageShare)((MessageForStructing)localObject).structingMsg;
      localazsp = localStructMsgForImageShare.getFirstImageElement();
      if (localazsp == null) {
        break label211;
      }
    }
    label173:
    label192:
    label211:
    for (Object localObject = new apfo(localazsp.T, localazsp.U, localazsp.c, localStructMsgForImageShare.rawUrl, ((MessageForStructing)localObject).senderuin);; localObject = null)
    {
      localBaseChatPie.a().obtainMessage(79, localObject).sendToTarget();
      for (;;)
      {
        super.onClick(paramView);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder
 * JD-Core Version:    0.7.0.1
 */