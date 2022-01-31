package com.tencent.mobileqq.activity.aio.item;

import aael;
import aciy;
import acjt;
import acju;
import acjx;
import ackl;
import aclk;
import aclm;
import acmr;
import acmv;
import acxm;
import aczk;
import adqe;
import adqf;
import adqg;
import adqh;
import adqi;
import adqj;
import adqk;
import adql;
import adqm;
import adqn;
import adqp;
import adqq;
import adqr;
import adqs;
import adqt;
import adqu;
import adqv;
import adqw;
import adqx;
import adqy;
import adww;
import adwz;
import aegy;
import ajed;
import ajjy;
import ajue;
import akij;
import amxu;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
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
import apdh;
import aphp;
import arxu;
import aryb;
import ascr;
import atqs;
import awao;
import awbk;
import awpu;
import awqx;
import awul;
import awum;
import awus;
import awuw;
import awwe;
import awwr;
import awwu;
import awxd;
import awyc;
import awyy;
import awzo;
import axoa;
import axou;
import axqf;
import axvo;
import axwd;
import azhx;
import azzx;
import babh;
import babr;
import bace;
import bado;
import bafb;
import bakh;
import bakj;
import baky;
import bawl;
import bawm;
import bbmy;
import begr;
import behe;
import bemi;
import beml;
import bezp;
import bfhl;
import bfhn;
import bfhz;
import bfid;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
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
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.customviews.MessageProgressTextView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.ThumbWidthHeightDP;
import com.tencent.mobileqq.doutu.DuiButtonImageView;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.ShareData;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForAudioShare;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForHypertext;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import cooperation.comic.VipComicJumpActivity;
import eipc.EIPCServer;
import java.io.File;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mpl;
import mqq.os.MqqHandler;
import new;
import nfw;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import rsd;
import rse;
import rtr;
import urp;
import vms;

public class StructingMsgItemBuilder
  extends BaseBubbleBuilder
  implements acjx, aclm, acmr
{
  public static final int[] a;
  static int c;
  private awwe jdField_a_of_type_Awwe;
  bemi jdField_a_of_type_Bemi;
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
    this.jdField_a_of_type_Awwe = new awwe();
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
      bawm localbawm = (bawm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(76);
      bawl localbawl = localbawm.a();
      BaseActivity localBaseActivity = (BaseActivity)this.jdField_a_of_type_AndroidContentContext;
      if ((localbawl != null) && (localBaseActivity.isResume()) && (localbawl.b.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (localbawl.d == 2L) && (paramLong == localbawl.a)) {
        localbawm.a(localbawl, localBaseActivity);
      }
    }
  }
  
  private void a(adqx paramadqx, BaseChatItemLayout paramBaseChatItemLayout, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramBaseChatItemLayout.setHeadIconVisible(false);
      paramadqx.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130849314);
      int i = paramadqx.jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingLeft();
      int j = paramadqx.jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingLeft();
      paramadqx.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, i, 0, j);
      return;
    }
    paramBaseChatItemLayout.setHeadIconVisible(true);
  }
  
  private void a(adqx paramadqx, BaseChatItemLayout paramBaseChatItemLayout, boolean paramBoolean1, AbsStructMsg paramAbsStructMsg, Resources paramResources, boolean paramBoolean2)
  {
    RelativeLayout localRelativeLayout = paramadqx.jdField_b_of_type_AndroidWidgetRelativeLayout;
    if (localRelativeLayout == null)
    {
      localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramadqx.jdField_b_of_type_AndroidWidgetRelativeLayout = localRelativeLayout;
      localRelativeLayout.setId(2131310768);
      paramBaseChatItemLayout.addView(localRelativeLayout);
    }
    for (;;)
    {
      Object localObject2 = (RelativeLayout.LayoutParams)localRelativeLayout.getLayoutParams();
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      }
      ((RelativeLayout.LayoutParams)localObject1).topMargin = aciy.a(-2.0F, paramResources);
      if (paramBoolean2)
      {
        ((RelativeLayout.LayoutParams)localObject1).leftMargin = aciy.a(0.0F, paramResources);
        ((RelativeLayout.LayoutParams)localObject1).addRule(5, 2131298552);
        ((RelativeLayout.LayoutParams)localObject1).addRule(3, 2131298552);
        if (!paramBoolean1) {
          break label493;
        }
        ((RelativeLayout.LayoutParams)localObject1).addRule(1, 0);
        ((RelativeLayout.LayoutParams)localObject1).addRule(7, 2131298561);
      }
      for (;;)
      {
        localRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject1 = localRelativeLayout.getChildAt(0);
        paramResources = (Resources)localObject1;
        if (localObject1 != null)
        {
          paramResources = (Resources)localObject1;
          if (paramadqx.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
          {
            localObject2 = paramadqx.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
            paramResources = (Resources)localObject1;
            if (localObject2 != null)
            {
              localObject2 = ((View)localObject2).getTag(2131310787);
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
        paramAbsStructMsg = paramAbsStructMsg.getSourceView(this.jdField_a_of_type_AndroidContentContext, paramResources);
        if (paramAbsStructMsg == null) {
          break label513;
        }
        paramAbsStructMsg.setId(2131310769);
        localRelativeLayout.addView(paramAbsStructMsg);
        if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
        {
          paramadqx = new View(this.jdField_a_of_type_AndroidContentContext);
          paramBaseChatItemLayout = new RelativeLayout.LayoutParams(-2, -2);
          paramBaseChatItemLayout.addRule(6, 2131310769);
          paramBaseChatItemLayout.addRule(5, 2131310769);
          paramBaseChatItemLayout.addRule(7, 2131310769);
          paramBaseChatItemLayout.addRule(8, 2131310769);
          paramadqx.setBackgroundResource(2130837674);
          localRelativeLayout.addView(paramadqx, paramBaseChatItemLayout);
        }
        return;
        ((RelativeLayout.LayoutParams)localObject1).leftMargin = aciy.a(10.0F, paramResources);
        if ((!paramBoolean1) || ((paramAbsStructMsg.mMsgServiceID != 83) && (paramAbsStructMsg.mMsgServiceID != 108) && (paramAbsStructMsg.mMsgServiceID != 114) && (paramAbsStructMsg.mMsgServiceID != 116) && (paramAbsStructMsg.mMsgServiceID != 151) && (paramAbsStructMsg.mMsgServiceID != 156)) || (TextUtils.isEmpty(paramAbsStructMsg.mMsgActionData))) {
          break;
        }
        ((RelativeLayout.LayoutParams)localObject1).leftMargin += aciy.a(18.0F, paramResources);
        break;
        label493:
        ((RelativeLayout.LayoutParams)localObject1).addRule(1, 2131298561);
        ((RelativeLayout.LayoutParams)localObject1).addRule(7, 2131298552);
      }
      label513:
      paramBaseChatItemLayout.removeView(localRelativeLayout);
      paramadqx.jdField_b_of_type_AndroidWidgetRelativeLayout = null;
      return;
    }
  }
  
  private void a(adqx paramadqx, BaseChatItemLayout paramBaseChatItemLayout, boolean paramBoolean1, StructMsgForGeneralShare paramStructMsgForGeneralShare, Resources paramResources, boolean paramBoolean2)
  {
    RelativeLayout localRelativeLayout = paramadqx.c;
    Object localObject = localRelativeLayout;
    if (localRelativeLayout == null)
    {
      localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramadqx.jdField_b_of_type_AndroidWidgetRelativeLayout = localRelativeLayout;
      localRelativeLayout.setId(2131310767);
      paramBaseChatItemLayout.addView(localRelativeLayout);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localRelativeLayout.getLayoutParams();
      localObject = localLayoutParams;
      if (localLayoutParams == null) {
        localObject = new RelativeLayout.LayoutParams(-2, -2);
      }
      ((RelativeLayout.LayoutParams)localObject).topMargin = (12 - aciy.a(10.0F, paramResources));
      ((RelativeLayout.LayoutParams)localObject).addRule(5, 2131298552);
      ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131298552);
      localObject = localRelativeLayout;
    }
    paramResources = ((RelativeLayout)localObject).getChildAt(0);
    paramStructMsgForGeneralShare = paramStructMsgForGeneralShare.getAdSourceView(this.jdField_a_of_type_AndroidContentContext, paramResources);
    if (paramStructMsgForGeneralShare != null)
    {
      ((RelativeLayout)localObject).addView(paramStructMsgForGeneralShare);
      paramadqx = (RelativeLayout.LayoutParams)paramStructMsgForGeneralShare.getLayoutParams();
      paramadqx.topMargin = vms.a(this.jdField_a_of_type_AndroidContentContext, 10.0F);
      paramadqx.height = -2;
      paramadqx.width = -2;
      return;
    }
    paramBaseChatItemLayout.removeView((View)localObject);
    paramadqx.jdField_b_of_type_AndroidWidgetRelativeLayout = null;
  }
  
  private void a(Activity paramActivity)
  {
    Dialog localDialog = new Dialog(paramActivity);
    localDialog.requestWindowFeature(1);
    localDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    View localView = LayoutInflater.from(paramActivity).inflate(2131493890, null);
    ((ImageView)localView.findViewById(2131302181)).setImageResource(2130839291);
    ((TextView)localView.findViewById(2131311233)).setText(ajjy.a(2131648794));
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
        Object localObject2 = new beml();
        ((beml)localObject2).jdField_a_of_type_Int = i;
        ((beml)localObject2).jdField_b_of_type_Int = 0;
        if (localJSONObject.has("show_name")) {}
        for (((beml)localObject2).jdField_a_of_type_JavaLangString = localJSONObject.getString("show_name");; ((beml)localObject2).jdField_a_of_type_JavaLangString = "")
        {
          localArrayList1.add(localObject2);
          localObject2 = new rsd();
          ((rsd)localObject2).jdField_a_of_type_JavaLangString = str;
          ((rsd)localObject2).c = localJSONObject.optString("index");
          ((rsd)localObject2).d = localJSONObject.optString("index_name");
          ((rsd)localObject2).b = localJSONObject.optString("index_type");
          ((rsd)localObject2).e = String.valueOf(mpl.a());
          localArrayList2.add(localObject2);
          i += 1;
          break;
        }
      }
      this.jdField_a_of_type_Bemi = bemi.a(paramActivity, localArrayList1, new adqj(this, paramActivity, paramChatMessage, localAbsStructMsg, str, localArrayList2), new adqk(this), aciy.a(100.0F, paramActivity.getResources()));
    }
    catch (JSONException paramActivity)
    {
      paramActivity.printStackTrace();
      return;
    }
    int i = paramView.getWidth() * 7 / 2;
    this.jdField_a_of_type_Bemi.showAsDropDown(paramView, 0 - i, 0);
    this.jdField_a_of_type_Bemi.dismiss();
    paramActivity = new int[2];
    paramView.getLocationOnScreen(paramActivity);
    this.jdField_a_of_type_Bemi.showAtLocation(paramView, 0, paramActivity[0], paramActivity[1] + paramView.getHeight());
    this.jdField_a_of_type_Bemi.setOnDismissListener(new adql(this));
  }
  
  private void a(View paramView, StructMsgForGeneralShare paramStructMsgForGeneralShare)
  {
    new awus(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView).a(paramStructMsgForGeneralShare.mMsgAction, paramStructMsgForGeneralShare.mMsgUrl, paramStructMsgForGeneralShare.mMsgActionData, paramStructMsgForGeneralShare.mMsg_A_ActionData);
  }
  
  private void a(baky parambaky, adqx paramadqx)
  {
    if (paramadqx.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
      return;
    }
    Object localObject;
    int i;
    if ((parambaky instanceof axou))
    {
      localObject = (axou)parambaky;
      i = (int)((axou)localObject).c();
      if ((i != 1004) || (!((axou)localObject).c()) || (!((axou)localObject).d())) {
        break label416;
      }
      i = 1006;
    }
    label416:
    for (;;)
    {
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(6, 2131310787);
      ((RelativeLayout.LayoutParams)localObject).addRule(8, 2131310787);
      ((RelativeLayout.LayoutParams)localObject).addRule(5, 2131310787);
      ((RelativeLayout.LayoutParams)localObject).addRule(7, 2131310787);
      if ((paramadqx.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (paramadqx.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131310774) == null) && (paramadqx.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView != null)) {
        paramadqx.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramadqx.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView, (ViewGroup.LayoutParams)localObject);
      }
      switch (i)
      {
      default: 
        if (paramadqx.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView == null) {
          break;
        }
        paramadqx.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setProcessor(null);
        paramadqx.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(8);
        return;
      case 1000: 
      case 1001: 
      case 1002: 
      case 1006: 
      case 4001: 
        if (paramadqx.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView == null)
        {
          MessageProgressTextView localMessageProgressTextView = new MessageProgressTextView(this.jdField_a_of_type_AndroidContentContext);
          localMessageProgressTextView.setTextColor(-1);
          localMessageProgressTextView.setTextSize(2, 15.0F);
          localMessageProgressTextView.setGravity(17);
          localMessageProgressTextView.setId(2131310774);
          localMessageProgressTextView.setBackgroundDrawable(new aczk(2130706432, this.jdField_b_of_type_Float * 12.0F));
          if (paramadqx.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
            paramadqx.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localMessageProgressTextView, (ViewGroup.LayoutParams)localObject);
          }
          paramadqx.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView = localMessageProgressTextView;
        }
        paramadqx.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setProcessor((axou)parambaky);
        paramadqx.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(0);
        switch (i)
        {
        }
        for (;;)
        {
          paramadqx.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.a();
          return;
          paramadqx.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setProgress(0);
          return;
          paramadqx.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setProgress(0);
        }
        if (paramadqx.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView == null) {
          break;
        }
        paramadqx.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setProcessor(null);
        paramadqx.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(4);
        return;
      }
    }
  }
  
  private void a(BaseChatItemLayout paramBaseChatItemLayout, MessageForStructing paramMessageForStructing)
  {
    int i = ((StructMsgForGeneralShare)paramMessageForStructing.structingMsg).getProgress();
    if ((paramMessageForStructing.extraflag == 32772) && (i >= 0) && (i < 100))
    {
      ajue localajue = (ajue)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(28);
      localajue.a(awbk.a(paramMessageForStructing.msgUid), paramMessageForStructing.frienduin, paramMessageForStructing.uniseq);
      paramMessageForStructing = new adqr(this, paramMessageForStructing, paramBaseChatItemLayout);
      paramBaseChatItemLayout.setTag(2131311968, paramMessageForStructing);
      localajue.a(paramBaseChatItemLayout, paramMessageForStructing);
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
  
  private boolean a(AbsStructMsg paramAbsStructMsg, bakh parambakh)
  {
    boolean bool2 = true;
    int i = 0;
    boolean bool1;
    if ((paramAbsStructMsg == null) || (parambakh == null) || (this.jdField_a_of_type_AndroidContentContext == null)) {
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
      j = parambakh.a();
      bool1 = bool2;
    } while (j <= 0);
    for (;;)
    {
      bool1 = bool2;
      if (i >= j) {
        break;
      }
      paramAbsStructMsg = parambakh.a(i);
      if (paramAbsStructMsg != null)
      {
        bool1 = bool2;
        if (paramAbsStructMsg.a() == 2131300328) {
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
    View localView = LayoutInflater.from(paramActivity).inflate(2131493890, null);
    ((ImageView)localView.findViewById(2131302181)).setImageResource(2130839278);
    ((TextView)localView.findViewById(2131311233)).setText(ajjy.a(2131648793));
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
        beml localbeml = new beml();
        if (localJSONObject.has("index"))
        {
          localbeml.jdField_a_of_type_Int = localJSONObject.getInt("index");
          localbeml.jdField_b_of_type_Int = 0;
          if (localJSONObject.has("show_name"))
          {
            localbeml.jdField_a_of_type_JavaLangString = localJSONObject.getString("show_name");
            localArrayList.add(localbeml);
            i += 1;
          }
        }
        else
        {
          localbeml.jdField_a_of_type_Int = i;
          continue;
        }
        localbeml.jdField_a_of_type_JavaLangString = "";
      }
      catch (JSONException paramActivity)
      {
        paramActivity.printStackTrace();
        return;
      }
    }
    this.jdField_a_of_type_Bemi = bemi.a(paramActivity, localArrayList, new adqn(this, paramChatMessage, paramActivity, localAbsStructMsg), new adqp(this), aciy.a(100.0F, paramActivity.getResources()));
    int i = paramView.getWidth() * -5 / 7;
    this.jdField_a_of_type_Bemi.showAsDropDown(paramView, i, 0);
    this.jdField_a_of_type_Bemi.dismiss();
    paramActivity = new int[2];
    paramView.getLocationOnScreen(paramActivity);
    this.jdField_a_of_type_Bemi.showAtLocation(paramView, 0, paramActivity[0], paramActivity[1] + paramView.getHeight());
    this.jdField_a_of_type_Bemi.setOnDismissListener(new adqq(this));
  }
  
  private static void b(String paramString, URL paramURL, ThumbWidthHeightDP paramThumbWidthHeightDP)
  {
    CompressInfo localCompressInfo = new CompressInfo(paramString, 0);
    localCompressInfo.f = true;
    paramString = axoa.d(paramURL.toString());
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
        if (atqs.b(localCompressInfo))
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
          bool = apdh.a(new File(localCompressInfo.c), paramString);
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
          if ((paramChatMessage.getItemByIndex(i) instanceof awxd)) {
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
  
  public acjt a(View paramView)
  {
    try
    {
      ChatMessage localChatMessage = aciy.a(paramView);
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
          return (acjt)paramView.findViewById(2131302356);
        }
      } while ((((MessageForStructing)localObject).structingMsg == null) || (((MessageForStructing)localObject).structingMsg.mMsgServiceID != 107));
      Object localObject = paramView.findViewById(2131309111);
      if (localObject != null) {
        return (acjt)((View)localObject).getTag(-1);
      }
      paramView = "getTouchDelegate when receipt message but the root view is null \r\n" + paramView;
      awpu.a(new IllegalStateException(paramView), "StructingMsgItemBuilderCatchedException" + paramView);
    }
    return null;
  }
  
  public acju a()
  {
    return new adqx();
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, acmv paramacmv)
  {
    this.jdField_a_of_type_Awwe.a();
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
        urp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, localMessageForStructing, "exp");
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
      if ((paramView.getTag() instanceof acju))
      {
        localObject = (acju)paramView.getTag();
        j = k;
        if (localObject != null) {
          j = ((acju)localObject).jdField_b_of_type_Int;
        }
      }
    }
    localAbsStructMsg.message = localMessageForStructing;
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramacmv);
    if (localAbsStructMsg.mMsgServiceID == 76)
    {
      paramInt2 = aciy.a(11.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      k = aciy.a(7.5F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramView.setPadding(0, 0, 0, 0);
      paramViewGroup = (acju)paramView.getTag();
      paramViewGroup.jdField_a_of_type_AndroidViewView.setPadding(0, 0, 0, 0);
      ((RelativeLayout.LayoutParams)paramViewGroup.jdField_a_of_type_AndroidViewView.getLayoutParams()).setMargins(paramInt2, k, paramInt2, k);
    }
    if (localAbsStructMsg.mMsgServiceID == 35)
    {
      paramViewGroup = (acju)paramView.getTag();
      paramViewGroup.jdField_a_of_type_AndroidViewView.setPadding(paramViewGroup.jdField_a_of_type_AndroidViewView.getPaddingLeft(), 0, paramViewGroup.jdField_a_of_type_AndroidViewView.getPaddingRight(), 0);
    }
    paramViewGroup = (adqx)paramView.getTag();
    Object localObject = paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
    if (((i == 1) || (j != paramViewGroup.jdField_b_of_type_Int)) && (localAbsStructMsg.mMsgServiceID == 128)) {
      azzx.a("Grp_AIO", "invite", "send_exp", 0, 0, new String[] { String.valueOf(localAbsStructMsg.uniseq) });
    }
    int m;
    if ((localAbsStructMsg instanceof AbsShareMsg))
    {
      paramInt2 = ((AbsShareMsg)localAbsStructMsg).mContentLayout;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1008) && (localAbsStructMsg.hasFlag(4))) {
        localAbsStructMsg.addFlag(1);
      }
      paramacmv = this.jdField_a_of_type_AndroidContentContext.getResources();
      boolean bool = a(localMessageForStructing);
      if (QLog.isDevelopLevel()) {
        QLog.d("StructingMsgItemBuilder", 4, "getView:position:" + paramInt1 + "hasHead" + bool);
      }
      a(paramViewGroup, (BaseChatItemLayout)localObject, bool);
      a(paramViewGroup, (BaseChatItemLayout)localObject, localMessageForStructing.isSend(), localAbsStructMsg, paramacmv, bool);
      if (((localAbsStructMsg instanceof StructMsgForGeneralShare)) && (((StructMsgForGeneralShare)localAbsStructMsg).mHasAdSource)) {
        a(paramViewGroup, (BaseChatItemLayout)localObject, localMessageForStructing.isSend(), (StructMsgForGeneralShare)localAbsStructMsg, paramacmv, bool);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008) || (localMessageForStructing.structingMsg.mMsgServiceID == 76) || (localMessageForStructing.structingMsg.mMsgServiceID == 21))
      {
        k = paramacmv.getDimensionPixelSize(2131167688);
        m = paramacmv.getDimensionPixelSize(2131167688);
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
          j = aciy.a(30.0F, paramacmv);
          paramInt1 = j;
          if (((BaseChatItemLayout)localObject).jdField_a_of_type_AndroidWidgetCheckBox != null)
          {
            localObject = (RelativeLayout.LayoutParams)((BaseChatItemLayout)localObject).jdField_a_of_type_AndroidWidgetCheckBox.getLayoutParams();
            paramInt1 = j;
            if (localObject != null)
            {
              ((RelativeLayout.LayoutParams)localObject).leftMargin = aciy.a(5.0F, paramacmv);
              paramInt1 = j;
            }
          }
        }
        paramacmv = (RelativeLayout.LayoutParams)((RelativeLayout)((BaseChatItemLayout)paramView).b()).getLayoutParams();
        if (paramacmv != null)
        {
          if (localMessageForStructing.structingMsg.mMsgServiceID == 21) {
            break label1013;
          }
          paramacmv.setMargins(paramInt1, 0, m, 0);
        }
      }
    }
    for (;;)
    {
      paramView.requestLayout();
      if ((paramViewGroup != null) && (paramViewGroup.jdField_a_of_type_ComTencentMobileqqDataChatMessage == paramChatMessage) && (localAbsStructMsg.hasFlag(16))) {
        ThreadManager.post(new StructingMsgItemBuilder.5(this, paramViewGroup), 2, null, false);
      }
      paramacmv = (azhx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(132);
      if (paramacmv.b(paramChatMessage))
      {
        paramacmv.a(paramChatMessage.uniseq);
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
        paramacmv = AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidContentContext, 2130772196);
        paramacmv.setAnimationListener(new adqv(this, paramViewGroup));
        paramViewGroup.jdField_a_of_type_AndroidViewView.postDelayed(new StructingMsgItemBuilder.7(this, paramViewGroup, paramacmv), 300L);
      }
      this.jdField_a_of_type_Awwe.a(paramInt2, i);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && ("3046055438".equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
        nfw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, paramView);
      }
      return paramView;
      paramInt2 = -1;
      break;
      label1008:
      paramInt1 = 0;
      break label678;
      label1013:
      paramacmv.setMargins(paramInt1, paramacmv.topMargin, m, paramacmv.bottomMargin);
    }
  }
  
  public View a(ChatMessage paramChatMessage, acju paramacju, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acmv paramacmv)
  {
    Bundle localBundle = new Bundle();
    if (((this.jdField_a_of_type_AndroidContentContext instanceof ChatActivity)) || ((this.jdField_a_of_type_AndroidContentContext instanceof SplashActivity))) {}
    label1056:
    label2340:
    for (Object localObject2 = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a().a();; localObject2 = null)
    {
      Object localObject1;
      Object localObject3;
      int i;
      if (paramView == null)
      {
        localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources();
        paramView = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
        paramView.setId(2131298552);
        paramView.setMinimumHeight(aciy.a(44.0F, (Resources)localObject1));
        paramView.setClickable(true);
        paramView.setPadding(BaseChatItemLayout.i, BaseChatItemLayout.g, BaseChatItemLayout.j, BaseChatItemLayout.h);
        paramView.setBackgroundResource(2130837719);
        localObject3 = new RelativeLayout.LayoutParams(-2, -2);
        i = ((Resources)localObject1).getDimensionPixelSize(2131167688);
        ((RelativeLayout.LayoutParams)localObject3).setMargins(i, 0, i, 0);
        ((RelativeLayout.LayoutParams)localObject3).addRule(1, 2131302061);
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
        paramacju.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setMiniAioShieldItemTouchListener(this);
        localMessageForStructing = (MessageForStructing)paramChatMessage;
        localAbsStructMsg = localMessageForStructing.structingMsg;
        if (localAbsStructMsg != null) {
          break label302;
        }
      } while (!QLog.isColorLevel());
      paramacju = new StringBuilder().append("structMsg is null,msgdata:");
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
          paramacju = (StructMsgForGeneralShare)localAbsStructMsg;
          localBundle.putString("VIDEO_PUB_ACCOUNT_UIN", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          localBundle.putString("VIDEO_PUB_ACCOUNT_NAME", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
        }
        localBundle.putBoolean("isPublicAccount", true);
        paramacju = paramChatMessage.getExtInfoFromExtStr("msg_template_id");
        if ((paramacju != null) && (!paramacju.equals("")))
        {
          if (!TextUtils.isEmpty(paramacju)) {
            localAbsStructMsg.templateIDForPortal = paramacju;
          }
          if ((localAbsStructMsg instanceof AbsShareMsg))
          {
            localObject1 = ((AbsShareMsg)localAbsStructMsg).getStructMsgItemLists();
            if (localObject1 != null)
            {
              localObject1 = ((List)localObject1).iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject3 = (awul)((Iterator)localObject1).next();
                if (!TextUtils.isEmpty(paramacju)) {
                  ((awul)localObject3).P = paramacju;
                }
                if ((localObject3 instanceof awum))
                {
                  localObject3 = (awum)localObject3;
                  if (((awum)localObject3).a != null)
                  {
                    localObject3 = ((awum)localObject3).a.iterator();
                    while (((Iterator)localObject3).hasNext())
                    {
                      localObject4 = (awul)((Iterator)localObject3).next();
                      if (!TextUtils.isEmpty(paramacju)) {
                        ((awul)localObject4).P = paramacju;
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
          paramacju = (StructMsgForImageShare)localAbsStructMsg;
          paramacju.mIsSend = localMessageForStructing.issend;
          paramacju.mUniseq = localMessageForStructing.uniseq;
          paramacju.mMsgType = localMessageForStructing.msgtype;
        }
        paramBaseChatItemLayout.setAddStatesFromChildren(false);
        paramacju = paramBaseChatItemLayout.getTag();
        if ((paramacju == null) || (!(paramacju instanceof adqx))) {
          break label2750;
        }
      }
      label814:
      label2750:
      for (paramacju = (adqx)paramacju;; paramacju = null)
      {
        if (paramacju == null) {}
        for (localObject1 = new adqx();; localObject1 = paramacju) {
          for (;;)
          {
            ((adqx)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
            paramacju = ((adqx)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout;
            localObject3 = paramacju;
            if (paramacju == null)
            {
              localObject3 = (RelativeLayout)paramView;
              ((adqx)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject3);
            }
            paramacju = null;
            paramView.setTag(localObject1);
            if (d(paramChatMessage))
            {
              ((adqx)localObject1).jdField_a_of_type_Boolean = true;
              if (!(localAbsStructMsg instanceof StructMsgForGeneralShare)) {
                break label2047;
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
                  paramacju = null;
                  if (localObject2 != null) {
                    paramacju = ((adqy)localObject2).a((String)localObject4, (ViewGroup)paramView);
                  }
                  if (paramacju != null) {
                    if (localAbsStructMsg.mMsgServiceID == 61)
                    {
                      paramacju = AbsStructMsg.getInCompatibleView(this.jdField_a_of_type_AndroidContentContext, paramacju, paramView.getResources().getString(2131633191));
                      label975:
                      paramView.setOnTouchListener(paramacmv);
                      paramView.setOnLongClickListener(paramacmv);
                      if (!(localAbsStructMsg instanceof AbsShareMsg)) {
                        break label2260;
                      }
                      paramacmv = (AbsShareMsg)localAbsStructMsg;
                      localObject2 = paramacmv.getOnClickListener();
                      paramView.setOnClickListener(new adqw(this, paramacmv, localMessageForStructing, paramChatMessage, paramChatMessage.time, (View.OnClickListener)localObject2));
                      if (!StructMsgForImageShare.class.isInstance(localAbsStructMsg)) {
                        break label2171;
                      }
                      aclk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramBaseChatItemLayout, this);
                      if (b(localMessageForStructing)) {
                        aclk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramBaseChatItemLayout, this);
                      }
                      if (!rse.a(localAbsStructMsg)) {
                        break label2201;
                      }
                      paramView.setOnClickListener(null);
                      label1091:
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
                        paramView.setOnClickListener(new adqg(this, paramacmv));
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
                        ((RelativeLayout)localObject3).addView(paramacju);
                        if (localAbsStructMsg.mMsgServiceID == 38)
                        {
                          paramacju = (bawm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(76);
                          if (paramacju != null)
                          {
                            if (!paramacju.b(paramChatMessage.time)) {
                              break label2340;
                            }
                            paramacju = new ProgressBar(this.jdField_a_of_type_AndroidContentContext);
                            paramacju.setId(2131298579);
                            paramacju.setIndeterminateDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839113));
                            i = aciy.a(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
                            new RelativeLayout.LayoutParams(-2, -2);
                            paramacmv = new RelativeLayout.LayoutParams(i, i);
                            paramacmv.addRule(13, 2131298552);
                            ((RelativeLayout)localObject3).addView(paramacju, paramacmv);
                            e();
                          }
                        }
                        if (!(localAbsStructMsg instanceof StructMsgForImageShare)) {
                          break label2370;
                        }
                        if (localMessageForStructing.isSendFromLocal())
                        {
                          paramacju = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForStructing.frienduin, localMessageForStructing.uniseq);
                          ((adqx)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject3);
                          a(paramacju, (adqx)localObject1);
                        }
                        paramacju = ((StructMsgForImageShare)localAbsStructMsg).getFirstImageElement();
                        if ((paramacju != null) && (paramacju.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null))
                        {
                          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramacju.jdField_a_of_type_ComTencentMobileqqDataMessageForPic, 2);
                          ThreadManager.getFileThreadHandler().post(new StructingMsgItemBuilder.12(this, paramacju));
                        }
                        a((StructMsgForImageShare)localAbsStructMsg);
                        if (localAbsStructMsg.adverSign != 1) {
                          break label2398;
                        }
                        paramacju = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
                        paramacmv = new ImageView(this.jdField_a_of_type_AndroidContentContext);
                        paramacmv.setImageResource(2130841083);
                        paramacju.setBackgroundColor(0);
                        localObject2 = new RelativeLayout.LayoutParams(aciy.a(80.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), aciy.a(44.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
                        ((RelativeLayout.LayoutParams)localObject2).addRule(11);
                        ((RelativeLayout.LayoutParams)localObject2).addRule(10);
                        paramacju.setLayoutParams((ViewGroup.LayoutParams)localObject2);
                        localObject2 = new RelativeLayout.LayoutParams(-2, -2);
                        ((RelativeLayout.LayoutParams)localObject2).addRule(11);
                        ((RelativeLayout.LayoutParams)localObject2).addRule(10);
                        ((RelativeLayout.LayoutParams)localObject2).setMargins(0, 12, 12, 0);
                        paramacmv.setLayoutParams((ViewGroup.LayoutParams)localObject2);
                        paramacju.addView(paramacmv);
                        if ((paramView instanceof RelativeLayout)) {
                          ((RelativeLayout)paramView).addView(paramacju);
                        }
                        localObject2 = localMessageForStructing.frienduin;
                        l = localAbsStructMsg.msgId;
                        if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
                          paramacju.setOnClickListener(new adqh(this, paramacmv, paramChatMessage, (String)localObject2, l));
                        }
                        if ((this.jdField_a_of_type_Bemi != null) && (this.jdField_a_of_type_Bemi.isShowing())) {
                          this.jdField_a_of_type_Bemi.dismiss();
                        }
                        if ((paramBaseChatItemLayout != null) && (!ascr.a(localMessageForStructing)))
                        {
                          paramacju = (DuiButtonImageView)paramBaseChatItemLayout.findViewById(2131299837);
                          if (paramacju != null) {
                            break label2655;
                          }
                          paramacju = new DuiButtonImageView(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
                          paramacmv = new RelativeLayout.LayoutParams(aciy.a(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), aciy.a(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
                          paramacmv.addRule(8, 2131298552);
                          paramacmv.addRule(1, 2131298552);
                          paramacmv.bottomMargin = (BaseChatItemLayout.h - aciy.a(6.5F, this.jdField_a_of_type_AndroidContentContext.getResources()));
                          paramacju.setId(2131299837);
                          paramBaseChatItemLayout.addView(paramacju, paramacmv);
                          if (((paramChatMessage.extraflag != 32768) || (!paramChatMessage.isSendFromLocal())) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramChatMessage))) {
                            break label2663;
                          }
                          i = 1;
                          if ((!paramChatMessage.isDui) || (i != 0)) {
                            break label2724;
                          }
                          if (!paramChatMessage.isSend()) {
                            break label2669;
                          }
                          paramacju.setVisibility(8);
                        }
                        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1008) || (this.jdField_a_of_type_JavaUtilHashSet.contains(Long.valueOf(paramChatMessage.uniseq)))) {
                          break;
                        }
                        this.jdField_a_of_type_JavaUtilHashSet.add(Long.valueOf(paramChatMessage.uniseq));
                        akij.a(117, paramChatMessage, ((adqx)localObject1).jdField_b_of_type_Int);
                        return paramView;
                        paramacju = localMessageForStructing.getExtInfoFromExtStr("accostType");
                        if ((paramacju == null) || (paramacju.equals(""))) {
                          break label637;
                        }
                        try
                        {
                          localAbsStructMsg.sourceAccoutType = Integer.parseInt(paramacju);
                        }
                        catch (Exception paramacju) {}
                      }
                      break label637;
                      ((adqx)localObject1).jdField_a_of_type_Boolean = false;
                      break label814;
                      paramacju = localAbsStructMsg.getView(this.jdField_a_of_type_AndroidContentContext, paramacju, paramacmv, localBundle);
                      break label975;
                      if (localAbsStructMsg.mMsgServiceID == 61) {}
                      for (paramacju = AbsStructMsg.getInCompatibleView(this.jdField_a_of_type_AndroidContentContext, null, paramView.getResources().getString(2131633191));; paramacju = localAbsStructMsg.getView(this.jdField_a_of_type_AndroidContentContext, null, paramacmv, localBundle))
                      {
                        if (localObject2 != null) {
                          ((adqy)localObject2).a((String)localObject4, paramacju, (ViewGroup)paramView);
                        }
                        break;
                      }
                      label2047:
                      if (((RelativeLayout)localObject3).getChildCount() > 0)
                      {
                        localObject2 = ((RelativeLayout)localObject3).getChildAt(0);
                        paramacju = (acju)localObject2;
                        if (localObject2 != null)
                        {
                          localObject4 = ((View)localObject2).getTag(2131310787);
                          if (QLog.isColorLevel()) {
                            QLog.d("structMsg", 2, "bindviwfor structmsg tag:" + localObject4);
                          }
                          if (localObject4 != null)
                          {
                            paramacju = (acju)localObject2;
                            if (localObject4.getClass() == localAbsStructMsg.getClass()) {}
                          }
                          else
                          {
                            paramacju = null;
                          }
                        }
                      }
                      ((RelativeLayout)localObject3).removeAllViews();
                      if (c(paramChatMessage)) {}
                      for (;;)
                      {
                        paramacju = localAbsStructMsg.getView(this.jdField_a_of_type_AndroidContentContext, paramacju, paramacmv, localBundle);
                        break;
                        paramacju = null;
                      }
                      label2171:
                      if ((!StructMsgForGeneralShare.class.isInstance(localAbsStructMsg)) || (!a(localAbsStructMsg))) {
                        break label1056;
                      }
                      a(paramBaseChatItemLayout, localMessageForStructing);
                      break label1056;
                      if (localAbsStructMsg.mMsgServiceID != 78) {
                        break label1091;
                      }
                      localObject2 = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a();
                      localObject4 = (AbsShareMsg)localAbsStructMsg;
                      if (!(localObject2 instanceof aegy)) {
                        break label1091;
                      }
                      paramView.setOnClickListener(new adqf(this, (BaseChatPie)localObject2, (AbsShareMsg)localObject4));
                      break label1091;
                      label2260:
                      if ((localAbsStructMsg.mMsgServiceID == 3) || (localAbsStructMsg.mMsgServiceID == 120)) {
                        if (a()) {
                          paramView.setClickable(false);
                        } else {
                          paramView.setClickable(true);
                        }
                      }
                    }
                  }
                  catch (IllegalStateException paramacmv)
                  {
                    for (;;)
                    {
                      long l;
                      paramacmv = paramacju.getParent();
                      if ((paramacmv != null) && ((paramacmv instanceof ViewGroup))) {
                        ((ViewGroup)paramacmv).removeAllViews();
                      }
                      ((RelativeLayout)localObject3).addView(paramacju);
                      continue;
                      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0)
                      {
                        paramacju = paramacju.a();
                        if (paramacju != null)
                        {
                          a(paramacju.a);
                          continue;
                          label2370:
                          if (((localAbsStructMsg instanceof StructMsgForGeneralShare)) || ((localAbsStructMsg instanceof StructMsgForAudioShare)))
                          {
                            a((AbsShareMsg)localAbsStructMsg);
                            continue;
                            label2398:
                            if (localAbsStructMsg.adverSign == 2)
                            {
                              paramacju = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
                              paramacmv = new TextView(this.jdField_a_of_type_AndroidContentContext);
                              paramacmv.setBackgroundResource(2130841230);
                              paramacmv.setGravity(17);
                              i = localAbsStructMsg.adverSign;
                              paramacmv.setText(ajjy.a(2131648788));
                              paramacmv.setTextColor(-1);
                              paramacmv.setTextSize(13.0F);
                              paramacju.setBackgroundColor(0);
                              localObject2 = new RelativeLayout.LayoutParams(aciy.a(80.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), aciy.a(44.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
                              ((RelativeLayout.LayoutParams)localObject2).addRule(11);
                              ((RelativeLayout.LayoutParams)localObject2).addRule(10);
                              paramacju.setLayoutParams((ViewGroup.LayoutParams)localObject2);
                              localObject2 = new RelativeLayout.LayoutParams(-2, -2);
                              ((RelativeLayout.LayoutParams)localObject2).addRule(11);
                              ((RelativeLayout.LayoutParams)localObject2).addRule(10);
                              paramacmv.setLayoutParams((ViewGroup.LayoutParams)localObject2);
                              paramacju.addView(paramacmv);
                              if ((paramView instanceof RelativeLayout)) {
                                ((RelativeLayout)paramView).addView(paramacju);
                              }
                              localObject2 = localMessageForStructing.frienduin;
                              l = localAbsStructMsg.msgId;
                              localObject2 = localMessageForStructing.getExtInfoFromExtStr("msg_template_id");
                              i = localMessageForStructing.istroop;
                              if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
                              {
                                paramacju.setOnClickListener(new adqi(this, paramacmv, paramChatMessage, (String)localObject2));
                                continue;
                                label2655:
                                paramacju.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
                                continue;
                                label2663:
                                i = 0;
                                continue;
                                label2669:
                                if (!paramChatMessage.hasPlayedDui) {
                                  paramChatMessage.hasPlayedDui = DuiButtonImageView.a(paramacju);
                                }
                                for (;;)
                                {
                                  if (!DuiButtonImageView.jdField_a_of_type_Boolean) {
                                    break label2710;
                                  }
                                  paramacju.setOnClickListener(this);
                                  paramacju.setVisibility(0);
                                  break;
                                  paramacju.f();
                                }
                                paramacju.setOnClickListener(null);
                                paramacju.setVisibility(8);
                                continue;
                                paramacju.setVisibility(8);
                                paramacju.e();
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
            catch (Exception paramacju)
            {
              for (;;) {}
            }
          }
        }
      }
    }
  }
  
  public bakh a(bakh parambakh, ChatMessage paramChatMessage, ackl paramackl)
  {
    paramackl = (MessageForStructing)paramChatMessage;
    paramChatMessage = paramackl.structingMsg;
    if (paramChatMessage != null) {
      if ((!(paramChatMessage instanceof AbsShareMsg)) || (!((AbsShareMsg)paramChatMessage).mMsgException)) {}
    }
    label369:
    label375:
    label379:
    for (;;)
    {
      return parambakh;
      if ((paramChatMessage.mMsgServiceID != 86) && (paramChatMessage.mMsgServiceID != 61) && (paramChatMessage.mMsgServiceID != 91) && (paramChatMessage.mMsgServiceID != 97) && (paramChatMessage.mMsgServiceID != 98) && (!(paramChatMessage instanceof StructMsgForHypertext)) && ((!paramackl.isSendFromLocal()) || (!(paramChatMessage instanceof AbsShareMsg)) || (!((AbsShareMsg)paramChatMessage).isSdkShareMsg()) || ((paramackl.extraflag != 32772) && (paramackl.extraflag != 32768))))
      {
        paramackl = this.jdField_a_of_type_AndroidContentContext.getResources();
        int i;
        if (paramChatMessage.fwFlag != 1) {
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008) {
            if (!paramChatMessage.hasFlag(32))
            {
              parambakh.a(2131301042, paramackl.getString(2131627114), 2130838599);
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
          if ((i == 0) && (!a(paramChatMessage, parambakh))) {
            break label379;
          }
          parambakh.a(2131300328, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131626722), 2130838598);
          return parambakh;
          if (paramChatMessage.hasFlag(1)) {
            break;
          }
          parambakh.a(2131301021, paramackl.getString(2131627114), 2130838599);
          break;
          if (paramChatMessage.mMsgServiceID == 14) {
            break;
          }
          if (!paramChatMessage.hasFlag(1))
          {
            parambakh.a(2131301021, paramackl.getString(2131627114), 2130838599);
            break;
          }
          if (paramChatMessage.mMsgServiceID != 35) {
            break;
          }
          parambakh.a(2131301021, paramackl.getString(2131627114), 2130838599);
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
    if (bado.a(paramChatMessage.issend)) {
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
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilList.clear();
    if (StructMsgForGeneralShare.receiptServer != null) {
      QIPCServerHelper.getInstance().getServer().unRegisterModule(StructMsgForGeneralShare.receiptServer);
    }
  }
  
  @SuppressLint({"NewApi"})
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    Object localObject5 = adww.a(paramChatMessage);
    Object localObject1;
    if (paramInt == 2131296581) {
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
        localObject1 = axwd.a(paramChatMessage, 1);
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
                  adwz.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (URLDrawable)localObject1, paramChatMessage.frienduin, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167766), paramContext, null);
                } while (!adww.a((String)localObject5));
                bezp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "3009", "2", "40053", adww.b((String)localObject5), new String[] { "1", "", adww.a((String)localObject5) });
                return;
                if (paramInt != 2131301021) {
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
          if ((localObject2 != null) && (((awwr)localObject2).a()))
          {
            paramContext.putExtra("key_forward_image_share", true);
            paramContext.putExtra("key_forward_image_share_appid", Long.toString(((StructMsgForImageShare)localObject1).mSourceAppid));
            paramContext.putExtra("key_forward_image_share_uin_type", ((StructMsgForImageShare)localObject1).uinType);
          }
          aphp.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramContext, 21);
          paramContext = paramChatMessage.structingMsg.mMsgUrl;
          localObject1 = paramChatMessage.senderuin;
          localObject2 = Long.toString(paramChatMessage.structingMsg.msgId);
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005455", "0X8005455", 0, 0, (String)localObject1, paramContext, (String)localObject2, "");
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
          if (paramChatMessage.structingMsg.mMsgServiceID == 84) {
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8007166", "0X8007166", 0, 0, "", "", "", "");
          }
          if (adww.a((String)localObject5)) {
            bezp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "3009", "2", "40053", adww.b((String)localObject5), new String[] { "2", "", adww.a((String)localObject5) });
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
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D66", "0X8009D66", paramInt, 0, "" + paramInt, "", "", "");
          return;
          if ((paramChatMessage.structingMsg != null) && (paramChatMessage.structingMsg.mMsgServiceID == 35))
          {
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006624", "0X8006624", 0, 1, 0, "", "", "", "");
            if (!arxu.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.uniseq))
            {
              paramInt = paramContext.getResources().getDimensionPixelSize(2131167766);
              bbmy.a(paramContext, ajjy.a(2131648795), 0).b(paramInt);
              return;
            }
            if (!arxu.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.uniseq)) {
              break;
            }
            babr.a(paramContext, 230, null, "选择的消息中，部分图片\\表情等内容可能无法正常转发，是否继续转发？", ajjy.a(2131648787), ajjy.a(2131648797), new adqe(this, paramChatMessage), new adqm(this)).show();
            return;
          }
          if ((paramChatMessage.structingMsg == null) || (paramChatMessage.structingMsg.mMsgServiceID != 81)) {
            break;
          }
          urp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramChatMessage, "forward");
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
        if (paramInt != 2131299417) {
          break;
        }
        aael.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
        if (adww.a((String)localObject5)) {
          bezp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "3009", "2", "40053", adww.b((String)localObject5), new String[] { "5", "", adww.a((String)localObject5) });
        }
      } while ((paramChatMessage == null) || (!(paramChatMessage instanceof MessageForStructing)));
      paramContext = (MessageForStructing)paramChatMessage;
    } while ((paramContext.structingMsg == null) || (paramContext.structingMsg.mMsgServiceID != 81));
    urp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramContext, "delete");
    return;
    long l2;
    long l1;
    if (paramInt == 2131304871)
    {
      super.d(paramChatMessage);
      if (adww.a((String)localObject5)) {
        bezp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "3009", "2", "40053", adww.b((String)localObject5), new String[] { "6", "", adww.a((String)localObject5) });
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008)
      {
        paramContext = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(NetConnInfoCenter.getServerTimeMillis()));
        l2 = 0L;
        l1 = l2;
        if (paramChatMessage == null) {
          break label3810;
        }
        l1 = l2;
        if (!(paramChatMessage instanceof MessageForStructing)) {
          break label3810;
        }
        localObject1 = (MessageForStructing)paramChatMessage;
        l1 = l2;
        if (((MessageForStructing)localObject1).structingMsg == null) {
          break label3810;
        }
        l1 = l2;
        if (!(((MessageForStructing)localObject1).structingMsg instanceof AbsShareMsg)) {
          break label3810;
        }
        localObject1 = (AbsShareMsg)((MessageForStructing)localObject1).structingMsg;
        l2 = ((AbsShareMsg)localObject1).msgId;
        l1 = l2;
        if (!(localObject1 instanceof StructMsgForGeneralShare)) {
          break label3810;
        }
        localObject1 = (StructMsgForGeneralShare)localObject1;
        paramInt = StructMsgForGeneralShare.clickedItemIndex;
      }
    }
    for (;;)
    {
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X80064F7", "0X80064F7", 0, 0, paramContext, String.valueOf(l2), String.valueOf(paramInt), "");
      if ((paramChatMessage == null) || (!(paramChatMessage instanceof MessageForStructing))) {
        break;
      }
      paramContext = (MessageForStructing)paramChatMessage;
      if ((paramContext.structingMsg == null) || (paramContext.structingMsg.mMsgServiceID != 81)) {
        break;
      }
      urp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramContext, "more");
      return;
      MessageForStructing localMessageForStructing;
      AbsShareMsg localAbsShareMsg;
      if (paramInt == 2131300328)
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
          if (adww.a((String)localObject5))
          {
            localObject1 = localAbsShareMsg.mMsgActionData.substring(localAbsShareMsg.mMsgActionData.indexOf("|") + 1).split("\\|");
            paramInt = i;
            if (localObject1.length < 8) {
              break label3805;
            }
            if (!localObject1[7].equals("link"))
            {
              paramInt = i;
              if (!localObject1[7].equals("scrawl_link")) {
                break label3805;
              }
            }
            i = 1;
            paramInt = i;
            if (!localObject1[7].equals("scrawl_link")) {
              break label3805;
            }
            paramInt = i;
            if (localObject1.length <= 8) {
              break label3805;
            }
            paramContext = localObject1[8];
            paramInt = 1;
          }
        }
      }
      label3072:
      for (;;)
      {
        if ((paramInt == 0) && (!TextUtils.isEmpty(localAbsShareMsg.mMsg_A_ActionData)))
        {
          localObject1 = localAbsShareMsg.mMsg_A_ActionData.split("\\|");
          if ((localObject1.length >= 8) && (localObject1[7].equals("link"))) {
            paramInt = 1;
          }
        }
        label2186:
        label3238:
        for (;;)
        {
          label1715:
          Object localObject4;
          Object localObject3;
          if (paramInt != 0)
          {
            localObject2 = ((StructMsgForImageShare)localAbsShareMsg).getFirstImageElement();
            if (localObject2 == null) {
              break label3796;
            }
            if (((awwr)localObject2).jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare == null) {
              ((awwr)localObject2).jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare = ((StructMsgForImageShare)localAbsShareMsg);
            }
            localObject4 = adwz.a(((awwr)localObject2).a());
            localObject3 = ((AIOImageData)localObject4).a(4);
            localObject2 = localObject3;
            if (localObject3 == null) {
              localObject2 = ((AIOImageData)localObject4).a(2);
            }
            if (localObject2 == null) {
              break label3796;
            }
          }
          label2362:
          label3774:
          label3780:
          label3788:
          label3796:
          for (localObject2 = ((File)localObject2).getAbsolutePath();; localObject2 = null)
          {
            Object localObject6 = localObject1[3] + ajjy.a(2131648786) + localObject1[5] + ajjy.a(2131648792);
            localObject4 = "ADTAG=comic.plugin.read&id=" + localObject1[0] + "&name=" + URLEncoder.encode(localObject1[1]) + "&sectionID=" + localObject1[2] + "&sectionName=" + URLEncoder.encode(localObject1[3]) + "&pageID=" + localObject1[4] + "&page=" + localObject1[5] + "&type=" + localObject1[6];
            localObject3 = localObject4;
            if (!TextUtils.isEmpty(paramContext)) {
              localObject3 = (String)localObject4 + "&scrawl_link=" + URLEncoder.encode(paramContext);
            }
            paramContext = VipComicJumpActivity.a("comicReadShare", "5123", null, null, "354", null, (String)localObject3);
            new bfhl(6).a("nLinkType", 0).b("sTitle", localObject1[1]).b("sUrl", paramContext).a("bAppShare", false).a("lAppId", 0L).b("sPublisher", localAbsShareMsg.mSourceName).b("sBrief", (String)localObject6).b("sPath", (String)localObject2).b("sResUrl", localAbsShareMsg.mSourceUrl).a("lCategory", 1L).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
            bfhz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 2);
            bezp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "3009", "2", "40053", adww.b((String)localObject5), new String[] { "3", "", adww.a((String)localObject5) });
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
                  paramContext = bfid.a((StructMsgForImageShare)localAbsShareMsg);
                  if (paramContext != null)
                  {
                    bfhl.a(paramContext.U, localAbsShareMsg.uinType, paramContext.T, paramContext.c, paramContext.S, paramContext.d).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
                    bfhz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 3);
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
                  label2419:
                  awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D67", "0X8009D67", paramInt, 0, "" + paramInt, "", "", "");
                  return;
                  paramInt = 0;
                  break label1715;
                  if (!adww.b((String)localObject5)) {
                    break label3788;
                  }
                  paramContext = adww.b((String)localObject5);
                  if ((paramContext == null) || (paramContext.length <= 2)) {
                    break label3788;
                  }
                  localObject2 = paramContext[1];
                  paramContext = paramContext[2];
                  paramContext = ((StructMsgForImageShare)localAbsShareMsg).getFirstImageElement();
                  if (paramContext != null)
                  {
                    if (paramContext.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare == null) {
                      paramContext.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare = ((StructMsgForImageShare)localAbsShareMsg);
                    }
                    localObject3 = adwz.a(paramContext.a());
                    localObject1 = ((AIOImageData)localObject3).a(4);
                    paramContext = (Context)localObject1;
                    if (localObject1 == null) {
                      paramContext = ((AIOImageData)localObject3).a(2);
                    }
                    if (paramContext != null) {
                      paramContext.getAbsolutePath();
                    }
                  }
                  paramContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
                  bfhl.a((String)localObject2).c(paramContext).a((Activity)this.jdField_a_of_type_AndroidContentContext, paramContext);
                  bfhz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 2);
                  paramInt = 1;
                  i = 0;
                  break label2186;
                  if ((!(localAbsShareMsg instanceof StructMsgForGeneralShare)) || (localAbsShareMsg.mMsgServiceID != 35)) {
                    break label2687;
                  }
                  paramContext = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
                  if (paramContext != null)
                  {
                    paramContext = paramContext.a();
                    ((acxm)paramContext.a(11)).a(paramContext, null, (MessageForStructing)paramChatMessage);
                  }
                  break;
                }
              }
              label2687:
              if (!TextUtils.isEmpty(localAbsShareMsg.mMsgActionData))
              {
                String[] arrayOfString1 = localAbsShareMsg.mMsgActionData.split("&");
                i = arrayOfString1.length;
                localObject3 = null;
                localObject2 = null;
                localObject1 = null;
                paramContext = null;
                paramInt = 0;
                if (paramInt < i)
                {
                  String[] arrayOfString2 = arrayOfString1[paramInt].split("=");
                  localObject4 = localObject3;
                  localObject5 = localObject2;
                  localObject6 = localObject1;
                  Object localObject7 = paramContext;
                  if (arrayOfString2.length > 1)
                  {
                    if (!arrayOfString2[0].trim().equals("lat")) {
                      break label2825;
                    }
                    localObject7 = arrayOfString2[1];
                    localObject6 = localObject1;
                    localObject5 = localObject2;
                    localObject4 = localObject3;
                  }
                  for (;;)
                  {
                    paramInt += 1;
                    localObject3 = localObject4;
                    localObject2 = localObject5;
                    localObject1 = localObject6;
                    paramContext = (Context)localObject7;
                    break;
                    if (arrayOfString2[0].trim().equals("lon"))
                    {
                      localObject6 = arrayOfString2[1];
                      localObject4 = localObject3;
                      localObject5 = localObject2;
                      localObject7 = paramContext;
                    }
                    else if (arrayOfString2[0].trim().equals("loc"))
                    {
                      localObject5 = arrayOfString2[1];
                      localObject4 = localObject3;
                      localObject6 = localObject1;
                      localObject7 = paramContext;
                    }
                    else
                    {
                      localObject4 = localObject3;
                      localObject5 = localObject2;
                      localObject6 = localObject1;
                      localObject7 = paramContext;
                      if (arrayOfString2[0].trim().equals("title"))
                      {
                        localObject4 = arrayOfString2[1];
                        localObject5 = localObject2;
                        localObject6 = localObject1;
                        localObject7 = paramContext;
                      }
                    }
                  }
                }
                if ((localAbsShareMsg.mMsgServiceID == 32) && (!TextUtils.isEmpty(paramContext)) && (!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject2)))
                {
                  bfhl.a(Float.valueOf(paramContext).floatValue(), Float.valueOf((String)localObject1).floatValue(), (String)localObject3, (String)localObject2, null).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
                  bfhz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 7);
                  return;
                }
              }
              localObject3 = bfid.a(localAbsShareMsg.getXmlBytes());
              paramContext = localAbsShareMsg.mContentCover;
              if ((localAbsShareMsg instanceof StructMsgForAudioShare))
              {
                paramInt = 2;
                i = 10;
              }
              for (;;)
              {
                if (localAbsShareMsg.uinType == 1008)
                {
                  localObject2 = babh.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), true);
                  localObject1 = localObject2;
                  if (TextUtils.isEmpty((CharSequence)localObject2)) {
                    localObject1 = localAbsShareMsg.mContentSrc;
                  }
                  bfhl.a(paramInt, localAbsShareMsg.mContentTitle, localAbsShareMsg.mMsgUrl, localAbsShareMsg.mSourceName, localAbsShareMsg.mContentSummary, paramContext, (String)localObject1, (byte[])localObject3, false, 0L).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a("lCategory", 10L).b("sUin", localAbsShareMsg.mSourceName).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
                  label3196:
                  bfhz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, i);
                  break label2362;
                  if ((!(localAbsShareMsg instanceof StructMsgForGeneralShare)) || (!((StructMsgForGeneralShare)localAbsShareMsg).mIsPAVideoStructMsg)) {
                    break label3780;
                  }
                  localObject2 = (StructMsgForGeneralShare)localAbsShareMsg;
                  paramInt = 0;
                  if (paramInt >= ((StructMsgForGeneralShare)localObject2).getItemCount()) {
                    break label3780;
                  }
                  localObject1 = ((StructMsgForGeneralShare)localObject2).getItemByIndex(paramInt);
                  if ((localObject1 instanceof awyc))
                  {
                    localObject4 = ((awyc)localObject1).a.iterator();
                    do
                    {
                      localObject1 = paramContext;
                      if (!((Iterator)localObject4).hasNext()) {
                        break;
                      }
                      localObject1 = (awul)((Iterator)localObject4).next();
                    } while (!(localObject1 instanceof awzo));
                    localObject4 = (awzo)localObject1;
                    paramContext = ((awzo)localObject4).S;
                    localObject1 = paramContext;
                    if (!((awzo)localObject4).a()) {
                      break label3774;
                    }
                    new.a("0X8006601", ((StructMsgForGeneralShare)localAbsShareMsg).uinType, new.a(((awzo)localObject4).p, ((StructMsgForGeneralShare)localObject2).mSourceName), ((awzo)localObject4).U, "");
                  }
                }
                for (;;)
                {
                  i = 2;
                  paramInt = 0;
                  break label3072;
                  paramInt += 1;
                  break label3238;
                  localObject1 = new ArrayList();
                  if (a(localAbsShareMsg)) {
                    ((ArrayList)localObject1).add(bfhn.a(true));
                  }
                  bfhl.a(paramInt, localAbsShareMsg.mContentTitle, localAbsShareMsg.mMsgUrl, localAbsShareMsg.mSourceName, localAbsShareMsg.mContentSummary, paramContext, localAbsShareMsg.mContentSrc, (byte[])localObject3, false, 0L).b("sBizDataList", (ArrayList)localObject1).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
                  break label3196;
                  paramInt = 2;
                  break label2419;
                  paramInt = 7;
                  break label2419;
                  if (paramInt == 2131299262)
                  {
                    paramContext = (MessageForStructing)paramChatMessage;
                    if ((paramContext == null) || (paramContext.structingMsg == null) || (!"web".equals(paramContext.structingMsg.mMsgAction)) || (paramContext.structingMsg.mMsgUrl == null)) {
                      break;
                    }
                    ((ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(paramContext.structingMsg.mMsgUrl);
                    return;
                  }
                  if (paramInt == 2131304860)
                  {
                    d(paramChatMessage);
                    return;
                  }
                  if (paramInt == 2131301042)
                  {
                    ThreadManager.post(new StructingMsgItemBuilder.4(this, paramChatMessage, paramContext), 8, null, false);
                    return;
                  }
                  if (paramInt == 2131304829)
                  {
                    super.a(paramChatMessage);
                    if (adww.a((String)localObject5)) {
                      bezp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "3009", "2", "40053", adww.b((String)localObject5), new String[] { "4", "", adww.a((String)localObject5) });
                    }
                    if ((paramChatMessage == null) || (!(paramChatMessage instanceof MessageForStructing))) {
                      break;
                    }
                    paramContext = (MessageForStructing)paramChatMessage;
                    if ((paramContext.structingMsg == null) || (paramContext.structingMsg.mMsgServiceID != 81)) {
                      break;
                    }
                    urp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramContext, "withdraw");
                    return;
                  }
                  if (paramInt == 2131298310)
                  {
                    paramContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramChatMessage.frienduin, paramChatMessage.uniseq);
                    if ((paramContext == null) || (!(paramContext instanceof axou))) {
                      break;
                    }
                    ((axou)paramContext).a();
                    return;
                  }
                  super.a(paramInt, paramContext, paramChatMessage);
                  return;
                  paramContext = (Context)localObject1;
                }
                i = 2;
                paramInt = 0;
              }
              paramInt = 0;
              i = 0;
            }
          }
        }
        label2825:
        label3805:
        paramContext = null;
      }
      label3810:
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
    if (aciy.a(paramView).isMultiMsg) {}
    Object localObject2;
    ChatMessage localChatMessage;
    String str1;
    do
    {
      do
      {
        return;
        localObject1 = aciy.a(paramView);
      } while (!adqx.class.isInstance(localObject1));
      localObject2 = this.jdField_a_of_type_AndroidContentContext;
      localChatMessage = ((adqx)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      localObject1 = a(localChatMessage);
      if (localObject1 != null)
      {
        a(paramView, (StructMsgForGeneralShare)localObject1);
        return;
      }
      paramView = ((Context)localObject2).getString(2131624443);
      str1 = ((Context)localObject2).getString(2131624444);
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
        paramView = ajjy.a(2131648789);
        localObject2 = ajjy.a(2131648790);
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label282;
        }
      }
    }
    for (;;)
    {
      localObject2 = (begr)behe.a(this.jdField_a_of_type_AndroidContentContext, null);
      ((begr)localObject2).c(paramView);
      ((begr)localObject2).d(this.jdField_a_of_type_AndroidContentContext.getString(2131625035));
      ((begr)localObject2).a((CharSequence)localObject1);
      ((begr)localObject2).a(new adqs(this, bool, localChatMessage, (begr)localObject2));
      ((begr)localObject2).show();
      return;
      paramView = ajjy.a(2131648791);
      break;
      babr.a((Context)localObject2, 230, paramView, str1, new adqt(this, localChatMessage, (Context)localObject2), new adqu(this)).show();
      return;
      label282:
      localObject1 = localObject2;
    }
  }
  
  public void a(View paramView, axqf paramaxqf, int paramInt1, int paramInt2)
  {
    if (!BaseChatItemLayout.class.isInstance(paramView)) {}
    do
    {
      return;
      if ((paramaxqf.jdField_b_of_type_Int == 1) || (paramaxqf.jdField_b_of_type_Int == 131075))
      {
        b(paramView, paramaxqf, paramInt1, paramInt2);
        return;
      }
    } while (paramaxqf.jdField_b_of_type_Int != 52);
    c(paramView, paramaxqf, paramInt1, paramInt2);
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    super.a(paramView, paramChatMessage);
    MessageForStructing localMessageForStructing;
    int i;
    if ((paramChatMessage instanceof MessageForStructing))
    {
      localMessageForStructing = (MessageForStructing)paramChatMessage;
      boolean bool = rse.a(localMessageForStructing.structingMsg);
      if (((bool) && (!localMessageForStructing.structingMsg.hasFlag(4))) || (localMessageForStructing.structingMsg.mMsgServiceID == 83) || (localMessageForStructing.structingMsg.mMsgServiceID == 108) || (localMessageForStructing.structingMsg.mMsgServiceID == 151) || (localMessageForStructing.structingMsg.mMsgServiceID == 156))
      {
        if ((!bool) || (localMessageForStructing.structingMsg.hasFlag(4))) {
          break label201;
        }
        i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131165219);
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
        paramView.setPadding(aciy.a(1.5F, paramChatMessage), aciy.a(2.0F, paramChatMessage), aciy.a(1.5F, paramChatMessage), paramView.getPaddingBottom());
      }
      return;
      label201:
      if ((localMessageForStructing.structingMsg.mMsgServiceID == 114) || (localMessageForStructing.structingMsg.mMsgServiceID == 116))
      {
        i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131165220);
        break;
      }
      i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131165224);
      break;
      label261:
      paramView.setPadding(i, BaseChatItemLayout.g, BaseChatItemLayout.j, BaseChatItemLayout.h);
    }
  }
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, acju paramacju, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramacju, paramInt1, paramInt2);
    if ((!(paramChatMessage instanceof MessageForStructing)) || (((MessageForStructing)paramChatMessage).structingMsg == null)) {}
    do
    {
      return;
      paramBaseChatItemLayout = (MessageForStructing)paramChatMessage;
      paramInt1 = paramBaseChatItemLayout.structingMsg.mMsgServiceID;
    } while ((a(paramBaseChatItemLayout)) || (paramInt1 == 83) || (paramInt1 == 151) || (paramInt1 == 156) || (paramInt1 == 108) || (paramInt1 == 114) || (paramInt1 == 98) || (paramInt1 == 97) || (paramInt1 == 5) || (paramInt1 == 137) || (paramInt1 == 106) || (paramInt1 == 107) || (paramInt1 == 122) || (paramInt1 == 116));
    paramInt2 = paramacju.jdField_a_of_type_AndroidViewView.getPaddingLeft();
    int i = paramacju.jdField_a_of_type_AndroidViewView.getPaddingRight();
    int m = paramacju.jdField_a_of_type_AndroidViewView.getPaddingTop();
    int n = paramacju.jdField_a_of_type_AndroidViewView.getPaddingBottom();
    int j = aciy.a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    boolean bool = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    int k;
    if (paramChatMessage.isSend())
    {
      paramInt1 = paramInt2;
      if (paramInt2 > j) {
        paramInt1 = paramInt2 - j;
      }
      paramacju.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130848708);
      j = paramInt1;
      k = i;
      if (bool)
      {
        j = paramInt1;
        k = i;
        if (paramacju.jdField_a_of_type_AndroidViewView.getParent() != null)
        {
          j = paramInt1;
          k = i;
          if ((paramacju.jdField_a_of_type_AndroidViewView.getParent() instanceof RelativeLayout))
          {
            paramBaseChatItemLayout = (RelativeLayout)paramacju.jdField_a_of_type_AndroidViewView.getParent();
            paramContext = new View(paramContext);
            localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
            localLayoutParams.addRule(6, 2131298552);
            localLayoutParams.addRule(5, 2131298552);
            localLayoutParams.addRule(7, 2131298552);
            localLayoutParams.addRule(8, 2131298552);
            if (paramacju.jdField_b_of_type_AndroidViewView != null) {
              paramBaseChatItemLayout.removeView(paramacju.jdField_b_of_type_AndroidViewView);
            }
            if (!aryb.a(paramChatMessage)) {
              break label440;
            }
            paramContext.setBackgroundResource(2130848705);
            paramacju.jdField_b_of_type_AndroidViewView = paramContext;
            paramBaseChatItemLayout.addView(paramacju.jdField_b_of_type_AndroidViewView, localLayoutParams);
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
          paramacju.jdField_a_of_type_AndroidViewView.setPadding(j, m, k, n);
          return;
          paramContext.setBackgroundResource(2130848704);
          break;
          paramInt1 = i;
          if (i > j) {
            paramInt1 = i - j;
          }
          paramacju.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130848515);
          j = paramInt2;
          k = paramInt1;
        } while (!bool);
        j = paramInt2;
        k = paramInt1;
      } while (paramacju.jdField_a_of_type_AndroidViewView.getParent() == null);
      j = paramInt2;
      k = paramInt1;
    } while (!(paramacju.jdField_a_of_type_AndroidViewView.getParent() instanceof RelativeLayout));
    paramBaseChatItemLayout = (RelativeLayout)paramacju.jdField_a_of_type_AndroidViewView.getParent();
    paramContext = new View(paramContext);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(6, 2131298552);
    localLayoutParams.addRule(5, 2131298552);
    localLayoutParams.addRule(7, 2131298552);
    localLayoutParams.addRule(8, 2131298552);
    if (paramacju.jdField_b_of_type_AndroidViewView != null) {
      paramBaseChatItemLayout.removeView(paramacju.jdField_b_of_type_AndroidViewView);
    }
    if (aryb.a(paramChatMessage)) {
      paramContext.setBackgroundResource(2130848512);
    }
    for (;;)
    {
      paramacju.jdField_b_of_type_AndroidViewView = paramContext;
      paramBaseChatItemLayout.addView(paramacju.jdField_b_of_type_AndroidViewView, localLayoutParams);
      j = paramInt2;
      k = paramInt1;
      break;
      paramContext.setBackgroundResource(2130848511);
    }
  }
  
  public void a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage, long paramLong, float paramFloat) {}
  
  public void a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage, boolean paramBoolean)
  {
    paramXListView = aciy.a(paramView);
    if ((paramXListView instanceof adqx)) {}
    for (paramXListView = (adqx)paramXListView;; paramXListView = null)
    {
      if (paramXListView != null)
      {
        paramXListView = (ViewGroup)paramXListView.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
        int i = paramXListView.getChildCount();
        paramInt = 0;
        while (paramInt < i)
        {
          if ((paramXListView.getChildAt(paramInt).getTag() instanceof awwu))
          {
            paramView = (awwu)paramXListView.getChildAt(paramInt).getTag();
            if ((paramView.jdField_a_of_type_AndroidViewView.getTag() instanceof awyy))
            {
              paramView = (ImageView)((awyy)paramView.jdField_a_of_type_AndroidViewView.getTag()).c;
              paramView.clearAnimation();
              paramView.setBackgroundResource(2130841264);
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
  
  public boolean a(acju paramacju)
  {
    return paramacju instanceof adqx;
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
      paramString2 = awuw.a(paramString1.getExtras());
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
        if ((localObject == null) || (((awwr)localObject).d > 0L)) {
          break;
        }
        paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramChatMessage.frienduin, paramChatMessage.uniseq);
        if ((paramChatMessage instanceof axou))
        {
          if (((axou)paramChatMessage).c() == 1005L) {}
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
      if (rtr.b(paramAbsShareMsg.mMsgUrl)) {
        return true;
      }
    } while (((TextUtils.isEmpty(paramAbsShareMsg.mSource_A_ActionData)) || (!paramAbsShareMsg.mSource_A_ActionData.contains("pubaccount"))) && ((TextUtils.isEmpty(paramAbsShareMsg.mSource_I_ActionData)) || (!paramAbsShareMsg.mSource_I_ActionData.contains("public_account"))));
    return true;
  }
  
  public boolean a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage)
  {
    paramXListView = aciy.a(paramView);
    if ((paramXListView instanceof adqx)) {}
    for (paramXListView = (adqx)paramXListView;; paramXListView = null)
    {
      if (paramXListView != null)
      {
        paramXListView = (ViewGroup)paramXListView.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
        int i = paramXListView.getChildCount();
        paramInt = 0;
        while (paramInt < i)
        {
          if ((paramXListView.getChildAt(paramInt).getTag() instanceof awwu))
          {
            paramView = (awwu)paramXListView.getChildAt(paramInt).getTag();
            if ((paramView.jdField_a_of_type_AndroidViewView.getTag() instanceof awyy)) {
              return bace.b(((awyy)paramView.jdField_a_of_type_AndroidViewView.getTag()).jdField_a_of_type_JavaLangString);
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
    Object localObject = aciy.a(paramView);
    if ((localObject instanceof adqx)) {}
    for (localObject = (adqx)localObject;; localObject = null)
    {
      if (localObject != null)
      {
        localObject = (ViewGroup)((adqx)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
        int i = ((ViewGroup)localObject).getChildCount();
        paramInt2 = 0;
        while (paramInt2 < i)
        {
          if (((((ViewGroup)localObject).getChildAt(paramInt2).getTag() instanceof awwu)) && (a(paramXListView, paramInt1, paramView, paramChatMessage)))
          {
            awwu localawwu = (awwu)((ViewGroup)localObject).getChildAt(paramInt2).getTag();
            if ((localawwu.jdField_a_of_type_AndroidViewView.getTag() instanceof awyy)) {
              paramAudioPlayer.a(((awyy)localawwu.jdField_a_of_type_AndroidViewView.getTag()).jdField_a_of_type_JavaLangString);
            }
          }
          paramInt2 += 1;
        }
        return true;
      }
      return false;
    }
  }
  
  public bakj[] a(View paramView)
  {
    paramView = (MessageForStructing)aciy.a(paramView);
    bakh localbakh = new bakh();
    if (paramView != null)
    {
      if (!paramView.isMultiMsg) {
        break label40;
      }
      a(localbakh, paramView, null);
    }
    for (;;)
    {
      return localbakh.a();
      label40:
      b(localbakh, paramView, null);
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
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5A7", "0X800A5A7", 0, 0, "" + i, "", "", "");
      return;
    }
  }
  
  public bakh b(bakh parambakh, ChatMessage paramChatMessage, ackl paramackl)
  {
    paramackl = (MessageForStructing)paramChatMessage;
    AbsStructMsg localAbsStructMsg = paramackl.structingMsg;
    if (localAbsStructMsg != null)
    {
      if (((localAbsStructMsg instanceof AbsShareMsg)) && (((AbsShareMsg)localAbsStructMsg).mMsgException))
      {
        aael.a(parambakh, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008) {
          super.c(parambakh, this.jdField_a_of_type_AndroidContentContext);
        }
        super.d(parambakh, this.jdField_a_of_type_AndroidContentContext);
        return parambakh;
      }
      if (localAbsStructMsg.mMsgServiceID == 86)
      {
        aael.a(parambakh, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        super.d(parambakh, this.jdField_a_of_type_AndroidContentContext);
        return parambakh;
      }
      if (localAbsStructMsg.mMsgServiceID == 61)
      {
        aael.a(parambakh, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        super.d(parambakh, this.jdField_a_of_type_AndroidContentContext);
        return parambakh;
      }
      if (localAbsStructMsg.mMsgServiceID == 91)
      {
        aael.a(parambakh, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        super.d(parambakh, this.jdField_a_of_type_AndroidContentContext);
        return parambakh;
      }
      if (localAbsStructMsg.mMsgServiceID == 97)
      {
        aael.a(parambakh, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        super.d(parambakh, this.jdField_a_of_type_AndroidContentContext);
        return parambakh;
      }
      if (localAbsStructMsg.mMsgServiceID == 98)
      {
        aael.a(parambakh, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        super.d(parambakh, this.jdField_a_of_type_AndroidContentContext);
        return parambakh;
      }
      if (localAbsStructMsg.mMsgServiceID == 128)
      {
        a(paramackl, parambakh);
        aael.a(parambakh, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        b(paramackl, parambakh);
        azzx.a("Grp_AIO", "invite", "send_in", 0, 0, new String[0]);
        return parambakh;
      }
      if ((localAbsStructMsg instanceof StructMsgForHypertext))
      {
        aael.a(parambakh, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        super.c(parambakh, this.jdField_a_of_type_AndroidContentContext);
        super.d(parambakh, this.jdField_a_of_type_AndroidContentContext);
        return parambakh;
      }
      if ((paramackl.isSendFromLocal()) && ((localAbsStructMsg instanceof AbsShareMsg)) && (((AbsShareMsg)localAbsStructMsg).isSdkShareMsg()) && ((paramackl.extraflag == 32772) || (paramackl.extraflag == 32768)))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramackl.frienduin, paramackl.uniseq) != null) {
          parambakh.a(2131298310, this.jdField_a_of_type_AndroidContentContext.getString(2131625146), 2130838588);
        }
        for (;;)
        {
          super.d(parambakh, this.jdField_a_of_type_AndroidContentContext);
          return parambakh;
          aael.a(parambakh, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        }
      }
      if ((localAbsStructMsg instanceof StructMsgForImageShare))
      {
        awwr localawwr = ((StructMsgForImageShare)localAbsStructMsg).getFirstImageElement();
        if (localawwr == null) {
          break label1423;
        }
        paramChatMessage = localawwr.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
        if (paramChatMessage != null) {
          break label1420;
        }
        if (localawwr.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare == null)
        {
          localawwr.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare = ((StructMsgForImageShare)localAbsStructMsg);
          localawwr.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.message = paramackl;
        }
        localawwr.a(this.jdField_a_of_type_AndroidContentContext, null, null);
        paramChatMessage = localawwr.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
      }
    }
    for (;;)
    {
      int i;
      if ((paramChatMessage != null) && (axwd.a(this.jdField_a_of_type_AndroidContentContext, paramChatMessage, 65537)))
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
        super.d(parambakh, this.jdField_a_of_type_AndroidContentContext);
        return parambakh;
        i = 0;
        break;
      }
      label629:
      parambakh.a(2131296581, this.jdField_a_of_type_AndroidContentContext.getString(2131627732), 2130838597);
      paramChatMessage = this.jdField_a_of_type_AndroidContentContext.getResources();
      if (localAbsStructMsg.fwFlag != 1)
      {
        if (localAbsStructMsg.hasFlag(8)) {
          parambakh.a(2131299262, paramChatMessage.getString(2131625730), 2130838591);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008) {
          if (!localAbsStructMsg.hasFlag(32))
          {
            parambakh.a(2131301042, paramChatMessage.getString(2131627114), 2130838599);
            a(paramackl, parambakh);
            if (localAbsStructMsg.hasFlag(2)) {
              break label1408;
            }
            if (((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008) && (TextUtils.isEmpty(localAbsStructMsg.mMsgUrl))) || (localAbsStructMsg.mMsgServiceID == 81)) {
              break label1414;
            }
            if (localAbsStructMsg.mMsgServiceID != 14) {
              break label1396;
            }
            i = 0;
          }
        }
      }
      for (;;)
      {
        label795:
        j = i;
        if (localAbsStructMsg.mMsgServiceID == 21)
        {
          j = i;
          if (localAbsStructMsg.mMsgActionData != null)
          {
            j = i;
            if (!localAbsStructMsg.mMsgActionData.startsWith("mqqwpa://im/chat")) {}
          }
        }
        label1408:
        for (j = 0;; j = 0)
        {
          if ((paramackl.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramackl)))
          {
            int k = 1;
            i = k;
            if (paramackl.istroop == 1)
            {
              i = k;
              if (localAbsStructMsg != null) {
                if ((localAbsStructMsg.mMsgServiceID != 23) && (localAbsStructMsg.mMsgServiceID != 19) && (localAbsStructMsg.mMsgServiceID != 60) && (!ajjy.a(2131648796).equals(localAbsStructMsg.getSourceName())))
                {
                  i = k;
                  if (localAbsStructMsg.mMsgUrl != null)
                  {
                    i = k;
                    if (!localAbsStructMsg.mMsgUrl.startsWith("http://qqweb.qq.com/m/qunactivity")) {}
                  }
                }
                else
                {
                  i = 0;
                }
              }
            }
            if (((1008 != paramackl.istroop) || (!ajed.u.equals(paramackl.frienduin))) && ((localAbsStructMsg == null) || (localAbsStructMsg.mMsgUrl == null) || (!localAbsStructMsg.mMsgUrl.startsWith("http://ti.qq.com/remind/view.html"))))
            {
              k = i;
              if (localAbsStructMsg != null)
              {
                k = i;
                if (localAbsStructMsg.mMsgUrl != null)
                {
                  k = i;
                  if (!localAbsStructMsg.mMsgUrl.startsWith("https://mqq.tenpay.com")) {}
                }
              }
            }
            else
            {
              k = 0;
            }
            i = k;
            if (localAbsStructMsg != null)
            {
              i = k;
              if (localAbsStructMsg.mMsgServiceID == 49) {
                i = 0;
              }
            }
            if (i != 0) {
              a(parambakh, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramackl);
            }
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1008) || (parambakh.a() == 0)) {
            a(parambakh, paramackl);
          }
          if ((j != 0) || (a(localAbsStructMsg, parambakh))) {
            parambakh.a(2131300328, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131626722), 2130838598);
          }
          if ((localAbsStructMsg != null) && (localAbsStructMsg.mMsgServiceID != 49) && (localAbsStructMsg.mMsgServiceID != 106) && (localAbsStructMsg.mMsgServiceID != 14)) {
            super.c(parambakh, this.jdField_a_of_type_AndroidContentContext);
          }
          if ((localAbsStructMsg != null) && (localAbsStructMsg.mMsgServiceID == 81)) {
            urp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramackl, "press");
          }
          super.d(parambakh, this.jdField_a_of_type_AndroidContentContext);
          b(paramackl, parambakh);
          return parambakh;
          if (localAbsStructMsg.hasFlag(1)) {
            break;
          }
          parambakh.a(2131301021, paramChatMessage.getString(2131627114), 2130838599);
          break;
          if (localAbsStructMsg.mMsgServiceID == 14) {
            break;
          }
          if (!localAbsStructMsg.hasFlag(1))
          {
            parambakh.a(2131301021, paramChatMessage.getString(2131627114), 2130838599);
            break;
          }
          if (localAbsStructMsg.mMsgServiceID != 35) {
            break;
          }
          parambakh.a(2131301021, paramChatMessage.getString(2131627114), 2130838599);
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006625", "0X8006625", 0, 1, 0, "", "", "", "");
          break;
          label1396:
          i = 1;
          break label795;
          a(paramackl, parambakh);
        }
        label1414:
        i = 0;
      }
      label1420:
      continue;
      label1423:
      paramChatMessage = null;
    }
  }
  
  protected void b(View paramView, axqf paramaxqf, int paramInt1, int paramInt2)
  {
    paramView = aciy.a(paramView);
    if (!adqx.class.isInstance(paramView)) {}
    ChatMessage localChatMessage;
    do
    {
      do
      {
        return;
        paramView = (adqx)paramView;
      } while ((!adqx.class.isInstance(paramView)) || (paramView.jdField_a_of_type_AndroidWidgetRelativeLayout == null) || (!MessageForStructing.class.isInstance(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage)));
      localChatMessage = paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if ((localChatMessage.uniseq == paramaxqf.jdField_b_of_type_Long) && (localChatMessage.isSendFromLocal()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("structMsg", 2, "handleMessage status = " + paramInt1 + ", retCode = " + paramInt2 + ", message.uniseq = " + localChatMessage.uniseq + ", file.uniseq = " + paramaxqf.jdField_b_of_type_Long);
        }
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localChatMessage.frienduin, localChatMessage.uniseq), paramView);
        if (paramInt1 == 1005) {
          b();
        }
      }
    } while ((localChatMessage.uniseq != paramaxqf.jdField_b_of_type_Long) || (paramInt1 != 2003) || (!(((MessageForStructing)localChatMessage).structingMsg instanceof StructMsgForImageShare)));
    paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
    paramaxqf = new Bundle();
    paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(((MessageForStructing)localChatMessage).structingMsg.getView(this.jdField_a_of_type_AndroidContentContext, null, null, paramaxqf));
  }
  
  public boolean b(ChatMessage paramChatMessage)
  {
    return true;
  }
  
  protected void c(View paramView, axqf paramaxqf, int paramInt1, int paramInt2)
  {
    paramView = aciy.a(paramView);
    if (!adqx.class.isInstance(paramView)) {}
    do
    {
      do
      {
        do
        {
          return;
          paramView = (adqx)paramView;
        } while ((!adqx.class.isInstance(paramView)) || (paramView.jdField_a_of_type_AndroidWidgetRelativeLayout == null) || (!MessageForStructing.class.isInstance(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage)));
        paramView = paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      } while ((paramView.uniseq != paramaxqf.jdField_b_of_type_Long) || (!paramView.isSendFromLocal()));
      if (QLog.isColorLevel()) {
        QLog.d("structMsg", 2, "handleMessage status = " + paramInt1 + ", retCode = " + paramInt2 + ", message.uniseq = " + paramView.uniseq + ", file.uniseq = " + paramaxqf.jdField_b_of_type_Long);
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
      if ((paramChatMessage != null) && (axou.class.isInstance(paramChatMessage)))
      {
        a(paramBaseChatItemLayout, ((axou)paramChatMessage).a(), 0, 0);
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
    bawm localbawm = (bawm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(76);
    bawl localbawl = localbawm.a();
    if ((localbawl != null) && (localbawl.d == 0L) && (localbawl.a != 0L)) {
      localbawm.a(localbawl.a);
    }
    long l2;
    if ((localbawl != null) && (localbawl.d == 1L))
    {
      l2 = localbawm.a - (NetConnInfoCenter.getServerTimeMillis() - localbawl.e);
      if (l2 > 0L) {
        break label127;
      }
    }
    for (;;)
    {
      new Handler(this.jdField_a_of_type_AndroidContentContext.getMainLooper()).postDelayed(new StructingMsgItemBuilder.8(this, localbawl, localbawm), l1);
      return;
      label127:
      l1 = l2;
    }
  }
  
  public void onClick(View paramView)
  {
    BaseChatPie localBaseChatPie;
    StructMsgForImageShare localStructMsgForImageShare;
    awwr localawwr;
    if (paramView.getId() == 2131299837)
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
      localObject = (MessageForStructing)((adqx)aciy.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if ((localObject == null) || (((MessageForStructing)localObject).structingMsg == null) || (!(((MessageForStructing)localObject).structingMsg instanceof StructMsgForImageShare))) {
        break label211;
      }
      localStructMsgForImageShare = (StructMsgForImageShare)((MessageForStructing)localObject).structingMsg;
      localawwr = localStructMsgForImageShare.getFirstImageElement();
      if (localawwr == null) {
        break label211;
      }
    }
    label173:
    label192:
    label211:
    for (Object localObject = new amxu(localawwr.T, localawwr.U, localawwr.c, localStructMsgForImageShare.rawUrl, ((MessageForStructing)localObject).senderuin);; localObject = null)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder
 * JD-Core Version:    0.7.0.1
 */