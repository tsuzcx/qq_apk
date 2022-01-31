package com.tencent.mobileqq.activity.aio.item;

import acjm;
import aepi;
import aeqh;
import aeqi;
import aeql;
import aeqz;
import aery;
import aesa;
import aetg;
import aetk;
import affg;
import afhj;
import agce;
import agcf;
import agcg;
import agch;
import agci;
import agcj;
import agck;
import agcl;
import agcm;
import agcn;
import agcp;
import agcq;
import agcr;
import agcs;
import agct;
import agcu;
import agcv;
import agcw;
import agcx;
import agcy;
import agiy;
import agjb;
import agti;
import alof;
import alud;
import ames;
import amrz;
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
import apjx;
import arso;
import aryv;
import aupg;
import aupn;
import auud;
import awkj;
import ayzl;
import azah;
import azpo;
import azqs;
import azus;
import azut;
import azuz;
import azvd;
import azwl;
import azwy;
import azxb;
import azxk;
import azyj;
import azzf;
import azzv;
import baic;
import baqn;
import barf;
import bass;
import bayf;
import bayu;
import bcml;
import bdes;
import bdgc;
import bdgm;
import bdhb;
import bdil;
import bdjz;
import bdpi;
import bdpk;
import bdpz;
import bedd;
import bede;
import bhuf;
import bhus;
import bhzx;
import biaa;
import binc;
import biva;
import bivc;
import bivo;
import bivs;
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
import wxj;
import xsm;

public class StructingMsgItemBuilder
  extends BaseBubbleBuilder
  implements aeql, aesa, aetg
{
  public static final int[] a;
  static int c;
  private azwl jdField_a_of_type_Azwl;
  bhzx jdField_a_of_type_Bhzx;
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
    this.jdField_a_of_type_Azwl = new azwl();
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
      bede localbede = (bede)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(76);
      bedd localbedd = localbede.a();
      BaseActivity localBaseActivity = (BaseActivity)this.jdField_a_of_type_AndroidContentContext;
      if ((localbedd != null) && (localBaseActivity.isResume()) && (localbedd.b.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (localbedd.d == 2L) && (paramLong == localbedd.a)) {
        localbede.a(localbedd, localBaseActivity);
      }
    }
  }
  
  private void a(agcx paramagcx, BaseChatItemLayout paramBaseChatItemLayout, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramBaseChatItemLayout.setHeadIconVisible(false);
      paramagcx.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130850072);
      int i = paramagcx.jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingLeft();
      int j = paramagcx.jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingLeft();
      paramagcx.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, i, 0, j);
      return;
    }
    paramBaseChatItemLayout.setHeadIconVisible(true);
  }
  
  private void a(agcx paramagcx, BaseChatItemLayout paramBaseChatItemLayout, boolean paramBoolean1, AbsStructMsg paramAbsStructMsg, Resources paramResources, boolean paramBoolean2)
  {
    RelativeLayout localRelativeLayout = paramagcx.jdField_b_of_type_AndroidWidgetRelativeLayout;
    if (localRelativeLayout == null)
    {
      localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramagcx.jdField_b_of_type_AndroidWidgetRelativeLayout = localRelativeLayout;
      localRelativeLayout.setId(2131377120);
      paramBaseChatItemLayout.addView(localRelativeLayout);
    }
    for (;;)
    {
      Object localObject2 = (RelativeLayout.LayoutParams)localRelativeLayout.getLayoutParams();
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      }
      ((RelativeLayout.LayoutParams)localObject1).topMargin = aepi.a(-2.0F, paramResources);
      if (paramBoolean2)
      {
        ((RelativeLayout.LayoutParams)localObject1).leftMargin = aepi.a(0.0F, paramResources);
        ((RelativeLayout.LayoutParams)localObject1).addRule(5, 2131364173);
        ((RelativeLayout.LayoutParams)localObject1).addRule(3, 2131364173);
        if (!paramBoolean1) {
          break label501;
        }
        ((RelativeLayout.LayoutParams)localObject1).addRule(1, 0);
        ((RelativeLayout.LayoutParams)localObject1).addRule(7, 2131364182);
        label139:
        localRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject1 = localRelativeLayout.getChildAt(0);
        paramResources = (Resources)localObject1;
        if (localObject1 != null)
        {
          paramResources = (Resources)localObject1;
          if (paramagcx.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
          {
            localObject2 = paramagcx.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
            paramResources = (Resources)localObject1;
            if (localObject2 != null)
            {
              localObject2 = ((View)localObject2).getTag(2131377139);
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
        paramResources.setId(2131377121);
        localRelativeLayout.addView(paramResources);
        if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
        {
          paramagcx = new View(this.jdField_a_of_type_AndroidContentContext);
          paramBaseChatItemLayout = new RelativeLayout.LayoutParams(-2, -2);
          paramBaseChatItemLayout.addRule(6, 2131377121);
          paramBaseChatItemLayout.addRule(5, 2131377121);
          paramBaseChatItemLayout.addRule(7, 2131377121);
          paramBaseChatItemLayout.addRule(8, 2131377121);
          paramagcx.setBackgroundResource(2130837740);
          localRelativeLayout.addView(paramagcx, paramBaseChatItemLayout);
        }
      }
      for (;;)
      {
        a(paramAbsStructMsg, localRelativeLayout);
        return;
        ((RelativeLayout.LayoutParams)localObject1).leftMargin = aepi.a(10.0F, paramResources);
        if ((!paramBoolean1) || ((paramAbsStructMsg.mMsgServiceID != 83) && (paramAbsStructMsg.mMsgServiceID != 108) && (paramAbsStructMsg.mMsgServiceID != 114) && (paramAbsStructMsg.mMsgServiceID != 116) && (paramAbsStructMsg.mMsgServiceID != 151) && (paramAbsStructMsg.mMsgServiceID != 156)) || (TextUtils.isEmpty(paramAbsStructMsg.mMsgActionData))) {
          break;
        }
        ((RelativeLayout.LayoutParams)localObject1).leftMargin += aepi.a(18.0F, paramResources);
        break;
        label501:
        ((RelativeLayout.LayoutParams)localObject1).addRule(1, 2131364182);
        ((RelativeLayout.LayoutParams)localObject1).addRule(7, 2131364173);
        break label139;
        label521:
        paramBaseChatItemLayout.removeView(localRelativeLayout);
        paramagcx.jdField_b_of_type_AndroidWidgetRelativeLayout = null;
      }
    }
  }
  
  private void a(agcx paramagcx, BaseChatItemLayout paramBaseChatItemLayout, boolean paramBoolean1, StructMsgForGeneralShare paramStructMsgForGeneralShare, Resources paramResources, boolean paramBoolean2)
  {
    RelativeLayout localRelativeLayout = paramagcx.c;
    Object localObject = localRelativeLayout;
    if (localRelativeLayout == null)
    {
      localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramagcx.jdField_b_of_type_AndroidWidgetRelativeLayout = localRelativeLayout;
      localRelativeLayout.setId(2131377119);
      paramBaseChatItemLayout.addView(localRelativeLayout);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localRelativeLayout.getLayoutParams();
      localObject = localLayoutParams;
      if (localLayoutParams == null) {
        localObject = new RelativeLayout.LayoutParams(-2, -2);
      }
      ((RelativeLayout.LayoutParams)localObject).topMargin = (12 - aepi.a(10.0F, paramResources));
      ((RelativeLayout.LayoutParams)localObject).addRule(5, 2131364173);
      ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131364173);
      localObject = localRelativeLayout;
    }
    paramResources = ((RelativeLayout)localObject).getChildAt(0);
    paramStructMsgForGeneralShare = paramStructMsgForGeneralShare.getAdSourceView(this.jdField_a_of_type_AndroidContentContext, paramResources);
    if (paramStructMsgForGeneralShare != null)
    {
      ((RelativeLayout)localObject).addView(paramStructMsgForGeneralShare);
      paramagcx = (RelativeLayout.LayoutParams)paramStructMsgForGeneralShare.getLayoutParams();
      paramagcx.topMargin = xsm.a(this.jdField_a_of_type_AndroidContentContext, 10.0F);
      paramagcx.height = -2;
      paramagcx.width = -2;
      return;
    }
    paramBaseChatItemLayout.removeView((View)localObject);
    paramagcx.jdField_b_of_type_AndroidWidgetRelativeLayout = null;
  }
  
  private void a(Activity paramActivity)
  {
    Dialog localDialog = new Dialog(paramActivity);
    localDialog.requestWindowFeature(1);
    localDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    View localView = LayoutInflater.from(paramActivity).inflate(2131559509, null);
    ((ImageView)localView.findViewById(2131367944)).setImageResource(2130839405);
    ((TextView)localView.findViewById(2131377620)).setText(alud.a(2131714978));
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
        Object localObject2 = new biaa();
        ((biaa)localObject2).jdField_a_of_type_Int = i;
        ((biaa)localObject2).jdField_b_of_type_Int = 0;
        if (localJSONObject.has("show_name")) {}
        for (((biaa)localObject2).jdField_a_of_type_JavaLangString = localJSONObject.getString("show_name");; ((biaa)localObject2).jdField_a_of_type_JavaLangString = "")
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
      this.jdField_a_of_type_Bhzx = bhzx.a(paramActivity, localArrayList1, new agcj(this, paramActivity, paramChatMessage, localAbsStructMsg, str, localArrayList2), new agck(this), aepi.a(100.0F, paramActivity.getResources()));
    }
    catch (JSONException paramActivity)
    {
      paramActivity.printStackTrace();
      return;
    }
    int i = paramView.getWidth() * 7 / 2;
    this.jdField_a_of_type_Bhzx.showAsDropDown(paramView, 0 - i, 0);
    this.jdField_a_of_type_Bhzx.dismiss();
    paramActivity = new int[2];
    paramView.getLocationOnScreen(paramActivity);
    this.jdField_a_of_type_Bhzx.showAtLocation(paramView, 0, paramActivity[0], paramActivity[1] + paramView.getHeight());
    this.jdField_a_of_type_Bhzx.setOnDismissListener(new agcl(this));
  }
  
  private void a(View paramView, StructMsgForGeneralShare paramStructMsgForGeneralShare)
  {
    new azuz(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView).a(paramStructMsgForGeneralShare.mMsgAction, paramStructMsgForGeneralShare.mMsgUrl, paramStructMsgForGeneralShare.mMsgActionData, paramStructMsgForGeneralShare.mMsg_A_ActionData);
  }
  
  private void a(bdpz parambdpz, agcx paramagcx)
  {
    if (paramagcx.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
      return;
    }
    Object localObject;
    int i;
    if ((parambdpz instanceof barf))
    {
      localObject = (barf)parambdpz;
      i = (int)((barf)localObject).c();
      if ((i != 1004) || (!((barf)localObject).c()) || (!((barf)localObject).d())) {
        break label416;
      }
      i = 1006;
    }
    label416:
    for (;;)
    {
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(6, 2131377139);
      ((RelativeLayout.LayoutParams)localObject).addRule(8, 2131377139);
      ((RelativeLayout.LayoutParams)localObject).addRule(5, 2131377139);
      ((RelativeLayout.LayoutParams)localObject).addRule(7, 2131377139);
      if ((paramagcx.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (paramagcx.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131377126) == null) && (paramagcx.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView != null)) {
        paramagcx.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramagcx.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView, (ViewGroup.LayoutParams)localObject);
      }
      switch (i)
      {
      default: 
        if (paramagcx.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView == null) {
          break;
        }
        paramagcx.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setProcessor(null);
        paramagcx.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(8);
        return;
      case 1000: 
      case 1001: 
      case 1002: 
      case 1006: 
      case 4001: 
        if (paramagcx.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView == null)
        {
          MessageProgressTextView localMessageProgressTextView = new MessageProgressTextView(this.jdField_a_of_type_AndroidContentContext);
          localMessageProgressTextView.setTextColor(-1);
          localMessageProgressTextView.setTextSize(2, 15.0F);
          localMessageProgressTextView.setGravity(17);
          localMessageProgressTextView.setId(2131377126);
          localMessageProgressTextView.setBackgroundDrawable(new afhj(2130706432, this.jdField_b_of_type_Float * 12.0F));
          if (paramagcx.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
            paramagcx.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localMessageProgressTextView, (ViewGroup.LayoutParams)localObject);
          }
          paramagcx.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView = localMessageProgressTextView;
        }
        paramagcx.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setProcessor((barf)parambdpz);
        paramagcx.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(0);
        switch (i)
        {
        }
        for (;;)
        {
          paramagcx.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.a();
          return;
          paramagcx.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setProgress(0);
          return;
          paramagcx.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setProgress(0);
        }
        if (paramagcx.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView == null) {
          break;
        }
        paramagcx.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setProcessor(null);
        paramagcx.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(4);
        return;
      }
    }
  }
  
  private void a(BaseChatItemLayout paramBaseChatItemLayout, MessageForStructing paramMessageForStructing)
  {
    int i = ((StructMsgForGeneralShare)paramMessageForStructing.structingMsg).getProgress();
    if ((paramMessageForStructing.extraflag == 32772) && (i >= 0) && (i < 100))
    {
      ames localames = (ames)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(28);
      localames.a(azah.a(paramMessageForStructing.msgUid), paramMessageForStructing.frienduin, paramMessageForStructing.uniseq);
      paramMessageForStructing = new agcr(this, paramMessageForStructing, paramBaseChatItemLayout);
      paramBaseChatItemLayout.setTag(2131378389, paramMessageForStructing);
      localames.a(paramBaseChatItemLayout, paramMessageForStructing);
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
  
  private boolean a(AbsStructMsg paramAbsStructMsg, bdpi parambdpi)
  {
    boolean bool2 = true;
    int i = 0;
    boolean bool1;
    if ((paramAbsStructMsg == null) || (parambdpi == null) || (this.jdField_a_of_type_AndroidContentContext == null)) {
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
      j = parambdpi.a();
      bool1 = bool2;
    } while (j <= 0);
    for (;;)
    {
      bool1 = bool2;
      if (i >= j) {
        break;
      }
      paramAbsStructMsg = parambdpi.a(i);
      if (paramAbsStructMsg != null)
      {
        bool1 = bool2;
        if (paramAbsStructMsg.a() == 2131366017) {
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
    View localView = LayoutInflater.from(paramActivity).inflate(2131559509, null);
    ((ImageView)localView.findViewById(2131367944)).setImageResource(2130839392);
    ((TextView)localView.findViewById(2131377620)).setText(alud.a(2131714977));
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
        biaa localbiaa = new biaa();
        if (localJSONObject.has("index"))
        {
          localbiaa.jdField_a_of_type_Int = localJSONObject.getInt("index");
          localbiaa.jdField_b_of_type_Int = 0;
          if (localJSONObject.has("show_name"))
          {
            localbiaa.jdField_a_of_type_JavaLangString = localJSONObject.getString("show_name");
            localArrayList.add(localbiaa);
            i += 1;
          }
        }
        else
        {
          localbiaa.jdField_a_of_type_Int = i;
          continue;
        }
        localbiaa.jdField_a_of_type_JavaLangString = "";
      }
      catch (JSONException paramActivity)
      {
        paramActivity.printStackTrace();
        return;
      }
    }
    this.jdField_a_of_type_Bhzx = bhzx.a(paramActivity, localArrayList, new agcn(this, paramChatMessage, paramActivity, localAbsStructMsg), new agcp(this), aepi.a(100.0F, paramActivity.getResources()));
    int i = paramView.getWidth() * -5 / 7;
    this.jdField_a_of_type_Bhzx.showAsDropDown(paramView, i, 0);
    this.jdField_a_of_type_Bhzx.dismiss();
    paramActivity = new int[2];
    paramView.getLocationOnScreen(paramActivity);
    this.jdField_a_of_type_Bhzx.showAtLocation(paramView, 0, paramActivity[0], paramActivity[1] + paramView.getHeight());
    this.jdField_a_of_type_Bhzx.setOnDismissListener(new agcq(this));
  }
  
  private static void b(String paramString, URL paramURL, ThumbWidthHeightDP paramThumbWidthHeightDP)
  {
    CompressInfo localCompressInfo = new CompressInfo(paramString, 0);
    localCompressInfo.f = true;
    paramString = baqn.d(paramURL.toString());
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
        if (awkj.b(localCompressInfo))
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
          bool = arso.a(new File(localCompressInfo.c), paramString);
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
          if ((paramChatMessage.getItemByIndex(i) instanceof azxk)) {
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
  
  public aeqh a(View paramView)
  {
    try
    {
      ChatMessage localChatMessage = aepi.a(paramView);
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
          return (aeqh)paramView.findViewById(2131368124);
        }
      } while ((((MessageForStructing)localObject).structingMsg == null) || (((MessageForStructing)localObject).structingMsg.mMsgServiceID != 107));
      Object localObject = paramView.findViewById(2131375376);
      if (localObject != null) {
        return (aeqh)((View)localObject).getTag(-1);
      }
      paramView = "getTouchDelegate when receipt message but the root view is null \r\n" + paramView;
      azpo.a(new IllegalStateException(paramView), "StructingMsgItemBuilderCatchedException" + paramView);
    }
    return null;
  }
  
  protected agcx a()
  {
    return new agcx();
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, aetk paramaetk)
  {
    this.jdField_a_of_type_Azwl.a();
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
        wxj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, localMessageForStructing, "exp");
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
      if ((paramView.getTag() instanceof aeqi))
      {
        localObject = (aeqi)paramView.getTag();
        j = k;
        if (localObject != null) {
          j = ((aeqi)localObject).jdField_b_of_type_Int;
        }
      }
    }
    localAbsStructMsg.message = localMessageForStructing;
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramaetk);
    if (localAbsStructMsg.mMsgServiceID == 76)
    {
      paramInt2 = aepi.a(11.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      k = aepi.a(7.5F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramView.setPadding(0, 0, 0, 0);
      paramViewGroup = (aeqi)paramView.getTag();
      paramViewGroup.jdField_a_of_type_AndroidViewView.setPadding(0, 0, 0, 0);
      ((RelativeLayout.LayoutParams)paramViewGroup.jdField_a_of_type_AndroidViewView.getLayoutParams()).setMargins(paramInt2, k, paramInt2, k);
    }
    if (localAbsStructMsg.mMsgServiceID == 35)
    {
      paramViewGroup = (aeqi)paramView.getTag();
      paramViewGroup.jdField_a_of_type_AndroidViewView.setPadding(paramViewGroup.jdField_a_of_type_AndroidViewView.getPaddingLeft(), 0, paramViewGroup.jdField_a_of_type_AndroidViewView.getPaddingRight(), 0);
    }
    paramViewGroup = (agcx)paramView.getTag();
    Object localObject = paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
    if (((i == 1) || (j != paramViewGroup.jdField_b_of_type_Int)) && (localAbsStructMsg.mMsgServiceID == 128)) {
      bdes.a("Grp_AIO", "invite", "send_exp", 0, 0, new String[] { String.valueOf(localAbsStructMsg.uniseq) });
    }
    int m;
    if ((localAbsStructMsg instanceof AbsShareMsg))
    {
      paramInt2 = ((AbsShareMsg)localAbsStructMsg).mContentLayout;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1008) && (localAbsStructMsg.hasFlag(4))) {
        localAbsStructMsg.addFlag(1);
      }
      paramaetk = this.jdField_a_of_type_AndroidContentContext.getResources();
      boolean bool = a(localMessageForStructing);
      if (QLog.isDevelopLevel()) {
        QLog.d("StructingMsgItemBuilder", 4, "getView:position:" + paramInt1 + "hasHead" + bool);
      }
      a(paramViewGroup, (BaseChatItemLayout)localObject, bool);
      a(paramViewGroup, (BaseChatItemLayout)localObject, localMessageForStructing.isSend(), localAbsStructMsg, paramaetk, bool);
      if (((localAbsStructMsg instanceof StructMsgForGeneralShare)) && (((StructMsgForGeneralShare)localAbsStructMsg).mHasAdSource)) {
        a(paramViewGroup, (BaseChatItemLayout)localObject, localMessageForStructing.isSend(), (StructMsgForGeneralShare)localAbsStructMsg, paramaetk, bool);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008) || (localMessageForStructing.structingMsg.mMsgServiceID == 76) || (localMessageForStructing.structingMsg.mMsgServiceID == 21))
      {
        k = paramaetk.getDimensionPixelSize(2131298815);
        m = paramaetk.getDimensionPixelSize(2131298815);
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
          j = aepi.a(30.0F, paramaetk);
          paramInt1 = j;
          if (((BaseChatItemLayout)localObject).jdField_a_of_type_AndroidWidgetCheckBox != null)
          {
            localObject = (RelativeLayout.LayoutParams)((BaseChatItemLayout)localObject).jdField_a_of_type_AndroidWidgetCheckBox.getLayoutParams();
            paramInt1 = j;
            if (localObject != null)
            {
              ((RelativeLayout.LayoutParams)localObject).leftMargin = aepi.a(5.0F, paramaetk);
              paramInt1 = j;
            }
          }
        }
        paramaetk = (RelativeLayout.LayoutParams)((RelativeLayout)((BaseChatItemLayout)paramView).b()).getLayoutParams();
        if (paramaetk != null)
        {
          if (localMessageForStructing.structingMsg.mMsgServiceID == 21) {
            break label1013;
          }
          paramaetk.setMargins(paramInt1, 0, m, 0);
        }
      }
    }
    for (;;)
    {
      paramView.requestLayout();
      if ((paramViewGroup != null) && (paramViewGroup.jdField_a_of_type_ComTencentMobileqqDataChatMessage == paramChatMessage) && (localAbsStructMsg.hasFlag(16))) {
        ThreadManager.post(new StructingMsgItemBuilder.5(this, paramViewGroup), 2, null, false);
      }
      paramaetk = (bcml)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(132);
      if (paramaetk.b(paramChatMessage))
      {
        paramaetk.a(paramChatMessage.uniseq);
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
        paramaetk = AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidContentContext, 2130772207);
        paramaetk.setAnimationListener(new agcv(this, paramViewGroup));
        paramViewGroup.jdField_a_of_type_AndroidViewView.postDelayed(new StructingMsgItemBuilder.7(this, paramViewGroup, paramaetk), 300L);
      }
      this.jdField_a_of_type_Azwl.a(paramInt2, i);
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
      paramaetk.setMargins(paramInt1, paramaetk.topMargin, m, paramaetk.bottomMargin);
    }
  }
  
  public View a(ChatMessage paramChatMessage, aeqi paramaeqi, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aetk paramaetk)
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
        paramView.setId(2131364173);
        paramView.setMinimumHeight(aepi.a(44.0F, (Resources)localObject1));
        paramView.setClickable(true);
        paramView.setPadding(BaseChatItemLayout.i, BaseChatItemLayout.g, BaseChatItemLayout.j, BaseChatItemLayout.h);
        paramView.setBackgroundResource(2130837926);
        localObject3 = new RelativeLayout.LayoutParams(-2, -2);
        i = ((Resources)localObject1).getDimensionPixelSize(2131298815);
        ((RelativeLayout.LayoutParams)localObject3).setMargins(i, 0, i, 0);
        ((RelativeLayout.LayoutParams)localObject3).addRule(1, 2131367819);
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
        paramaeqi.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setMiniAioShieldItemTouchListener(this);
        localMessageForStructing = (MessageForStructing)paramChatMessage;
        localAbsStructMsg = localMessageForStructing.structingMsg;
        if (localAbsStructMsg != null) {
          break label302;
        }
      } while (!QLog.isColorLevel());
      paramaeqi = new StringBuilder().append("structMsg is null,msgdata:");
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
          paramaeqi = (StructMsgForGeneralShare)localAbsStructMsg;
          localBundle.putString("VIDEO_PUB_ACCOUNT_UIN", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          localBundle.putString("VIDEO_PUB_ACCOUNT_NAME", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
        }
        localBundle.putBoolean("isPublicAccount", true);
        paramaeqi = paramChatMessage.getExtInfoFromExtStr("msg_template_id");
        if ((paramaeqi != null) && (!paramaeqi.equals("")))
        {
          if (!TextUtils.isEmpty(paramaeqi)) {
            localAbsStructMsg.templateIDForPortal = paramaeqi;
          }
          if ((localAbsStructMsg instanceof AbsShareMsg))
          {
            localObject1 = ((AbsShareMsg)localAbsStructMsg).getStructMsgItemLists();
            if (localObject1 != null)
            {
              localObject1 = ((List)localObject1).iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject3 = (azus)((Iterator)localObject1).next();
                if (!TextUtils.isEmpty(paramaeqi)) {
                  ((azus)localObject3).P = paramaeqi;
                }
                if ((localObject3 instanceof azut))
                {
                  localObject3 = (azut)localObject3;
                  if (((azut)localObject3).a != null)
                  {
                    localObject3 = ((azut)localObject3).a.iterator();
                    while (((Iterator)localObject3).hasNext())
                    {
                      localObject4 = (azus)((Iterator)localObject3).next();
                      if (!TextUtils.isEmpty(paramaeqi)) {
                        ((azus)localObject4).P = paramaeqi;
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
          paramaeqi = (StructMsgForImageShare)localAbsStructMsg;
          paramaeqi.mIsSend = localMessageForStructing.issend;
          paramaeqi.mUniseq = localMessageForStructing.uniseq;
          paramaeqi.mMsgType = localMessageForStructing.msgtype;
        }
        paramBaseChatItemLayout.setAddStatesFromChildren(false);
        paramaeqi = paramBaseChatItemLayout.getTag();
        if ((paramaeqi == null) || (!(paramaeqi instanceof agcx))) {
          break label2747;
        }
      }
      label811:
      label2747:
      for (paramaeqi = (agcx)paramaeqi;; paramaeqi = null)
      {
        if (paramaeqi == null) {}
        for (localObject1 = a();; localObject1 = paramaeqi) {
          for (;;)
          {
            ((agcx)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
            paramaeqi = ((agcx)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout;
            localObject3 = paramaeqi;
            if (paramaeqi == null)
            {
              localObject3 = (RelativeLayout)paramView;
              ((agcx)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject3);
            }
            paramaeqi = null;
            paramView.setTag(localObject1);
            if (d(paramChatMessage))
            {
              ((agcx)localObject1).jdField_a_of_type_Boolean = true;
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
                  paramaeqi = null;
                  if (localObject2 != null) {
                    paramaeqi = ((agcy)localObject2).a((String)localObject4, (ViewGroup)paramView);
                  }
                  if (paramaeqi != null) {
                    if (localAbsStructMsg.mMsgServiceID == 61)
                    {
                      paramaeqi = AbsStructMsg.getInCompatibleView(this.jdField_a_of_type_AndroidContentContext, paramaeqi, paramView.getResources().getString(2131699247));
                      label972:
                      paramView.setOnTouchListener(paramaetk);
                      paramView.setOnLongClickListener(paramaetk);
                      if (!(localAbsStructMsg instanceof AbsShareMsg)) {
                        break label2257;
                      }
                      paramaetk = (AbsShareMsg)localAbsStructMsg;
                      localObject2 = paramaetk.getOnClickListener();
                      paramView.setOnClickListener(new agcw(this, paramaetk, localMessageForStructing, paramChatMessage, paramChatMessage.time, (View.OnClickListener)localObject2));
                      if (!StructMsgForImageShare.class.isInstance(localAbsStructMsg)) {
                        break label2168;
                      }
                      aery.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramBaseChatItemLayout, this);
                      if (b(localMessageForStructing)) {
                        aery.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramBaseChatItemLayout, this);
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
                        paramView.setOnClickListener(new agcg(this, paramaetk));
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
                        ((RelativeLayout)localObject3).addView(paramaeqi);
                        if (localAbsStructMsg.mMsgServiceID == 38)
                        {
                          paramaeqi = (bede)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(76);
                          if (paramaeqi != null)
                          {
                            if (!paramaeqi.b(paramChatMessage.time)) {
                              break label2337;
                            }
                            paramaeqi = new ProgressBar(this.jdField_a_of_type_AndroidContentContext);
                            paramaeqi.setId(2131364200);
                            paramaeqi.setIndeterminateDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839225));
                            i = aepi.a(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
                            new RelativeLayout.LayoutParams(-2, -2);
                            paramaetk = new RelativeLayout.LayoutParams(i, i);
                            paramaetk.addRule(13, 2131364173);
                            ((RelativeLayout)localObject3).addView(paramaeqi, paramaetk);
                            e();
                          }
                        }
                        if (!(localAbsStructMsg instanceof StructMsgForImageShare)) {
                          break label2367;
                        }
                        if (localMessageForStructing.isSendFromLocal())
                        {
                          paramaeqi = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForStructing.frienduin, localMessageForStructing.uniseq);
                          ((agcx)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject3);
                          a(paramaeqi, (agcx)localObject1);
                        }
                        paramaeqi = ((StructMsgForImageShare)localAbsStructMsg).getFirstImageElement();
                        if ((paramaeqi != null) && (paramaeqi.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null))
                        {
                          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramaeqi.jdField_a_of_type_ComTencentMobileqqDataMessageForPic, 2);
                          ThreadManager.getFileThreadHandler().post(new StructingMsgItemBuilder.12(this, paramaeqi));
                        }
                        a((StructMsgForImageShare)localAbsStructMsg);
                        if (localAbsStructMsg.adverSign != 1) {
                          break label2395;
                        }
                        paramaeqi = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
                        paramaetk = new ImageView(this.jdField_a_of_type_AndroidContentContext);
                        paramaetk.setImageResource(2130841278);
                        paramaeqi.setBackgroundColor(0);
                        localObject2 = new RelativeLayout.LayoutParams(aepi.a(80.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), aepi.a(44.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
                        ((RelativeLayout.LayoutParams)localObject2).addRule(11);
                        ((RelativeLayout.LayoutParams)localObject2).addRule(10);
                        paramaeqi.setLayoutParams((ViewGroup.LayoutParams)localObject2);
                        localObject2 = new RelativeLayout.LayoutParams(-2, -2);
                        ((RelativeLayout.LayoutParams)localObject2).addRule(11);
                        ((RelativeLayout.LayoutParams)localObject2).addRule(10);
                        ((RelativeLayout.LayoutParams)localObject2).setMargins(0, 12, 12, 0);
                        paramaetk.setLayoutParams((ViewGroup.LayoutParams)localObject2);
                        paramaeqi.addView(paramaetk);
                        if ((paramView instanceof RelativeLayout)) {
                          ((RelativeLayout)paramView).addView(paramaeqi);
                        }
                        localObject2 = localMessageForStructing.frienduin;
                        l = localAbsStructMsg.msgId;
                        if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
                          paramaeqi.setOnClickListener(new agch(this, paramaetk, paramChatMessage, (String)localObject2, l));
                        }
                        if ((this.jdField_a_of_type_Bhzx != null) && (this.jdField_a_of_type_Bhzx.isShowing())) {
                          this.jdField_a_of_type_Bhzx.dismiss();
                        }
                        if ((paramBaseChatItemLayout != null) && (!auud.a(localMessageForStructing)))
                        {
                          paramaeqi = (DuiButtonImageView)paramBaseChatItemLayout.findViewById(2131365502);
                          if (paramaeqi != null) {
                            break label2652;
                          }
                          paramaeqi = new DuiButtonImageView(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
                          paramaetk = new RelativeLayout.LayoutParams(aepi.a(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), aepi.a(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
                          paramaetk.addRule(8, 2131364173);
                          paramaetk.addRule(1, 2131364173);
                          paramaetk.bottomMargin = (BaseChatItemLayout.h - aepi.a(6.5F, this.jdField_a_of_type_AndroidContentContext.getResources()));
                          paramaeqi.setId(2131365502);
                          paramBaseChatItemLayout.addView(paramaeqi, paramaetk);
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
                          paramaeqi.setVisibility(8);
                        }
                        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1008) || (this.jdField_a_of_type_JavaUtilHashSet.contains(Long.valueOf(paramChatMessage.uniseq)))) {
                          break;
                        }
                        this.jdField_a_of_type_JavaUtilHashSet.add(Long.valueOf(paramChatMessage.uniseq));
                        amrz.a(117, paramChatMessage, ((agcx)localObject1).jdField_b_of_type_Int);
                        return paramView;
                        paramaeqi = localMessageForStructing.getExtInfoFromExtStr("accostType");
                        if ((paramaeqi == null) || (paramaeqi.equals(""))) {
                          break label637;
                        }
                        try
                        {
                          localAbsStructMsg.sourceAccoutType = Integer.parseInt(paramaeqi);
                        }
                        catch (Exception paramaeqi) {}
                      }
                      break label637;
                      ((agcx)localObject1).jdField_a_of_type_Boolean = false;
                      break label811;
                      paramaeqi = localAbsStructMsg.getView(this.jdField_a_of_type_AndroidContentContext, paramaeqi, paramaetk, localBundle);
                      break label972;
                      if (localAbsStructMsg.mMsgServiceID == 61) {}
                      for (paramaeqi = AbsStructMsg.getInCompatibleView(this.jdField_a_of_type_AndroidContentContext, null, paramView.getResources().getString(2131699247));; paramaeqi = localAbsStructMsg.getView(this.jdField_a_of_type_AndroidContentContext, null, paramaetk, localBundle))
                      {
                        if (localObject2 != null) {
                          ((agcy)localObject2).a((String)localObject4, paramaeqi, (ViewGroup)paramView);
                        }
                        break;
                      }
                      label2044:
                      if (((RelativeLayout)localObject3).getChildCount() > 0)
                      {
                        localObject2 = ((RelativeLayout)localObject3).getChildAt(0);
                        paramaeqi = (aeqi)localObject2;
                        if (localObject2 != null)
                        {
                          localObject4 = ((View)localObject2).getTag(2131377139);
                          if (QLog.isColorLevel()) {
                            QLog.d("structMsg", 2, "bindviwfor structmsg tag:" + localObject4);
                          }
                          if (localObject4 != null)
                          {
                            paramaeqi = (aeqi)localObject2;
                            if (localObject4.getClass() == localAbsStructMsg.getClass()) {}
                          }
                          else
                          {
                            paramaeqi = null;
                          }
                        }
                      }
                      ((RelativeLayout)localObject3).removeAllViews();
                      if (c(paramChatMessage)) {}
                      for (;;)
                      {
                        paramaeqi = localAbsStructMsg.getView(this.jdField_a_of_type_AndroidContentContext, paramaeqi, paramaetk, localBundle);
                        break;
                        paramaeqi = null;
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
                      if (!(localObject2 instanceof agti)) {
                        break label1088;
                      }
                      paramView.setOnClickListener(new agcf(this, (BaseChatPie)localObject2, (AbsShareMsg)localObject4));
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
                  catch (IllegalStateException paramaetk)
                  {
                    for (;;)
                    {
                      long l;
                      paramaetk = paramaeqi.getParent();
                      if ((paramaetk != null) && ((paramaetk instanceof ViewGroup))) {
                        ((ViewGroup)paramaetk).removeAllViews();
                      }
                      ((RelativeLayout)localObject3).addView(paramaeqi);
                      continue;
                      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0)
                      {
                        paramaeqi = paramaeqi.a();
                        if (paramaeqi != null)
                        {
                          a(paramaeqi.a);
                          continue;
                          label2367:
                          if (((localAbsStructMsg instanceof StructMsgForGeneralShare)) || ((localAbsStructMsg instanceof StructMsgForAudioShare)))
                          {
                            a((AbsShareMsg)localAbsStructMsg);
                            continue;
                            label2395:
                            if (localAbsStructMsg.adverSign == 2)
                            {
                              paramaeqi = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
                              paramaetk = new TextView(this.jdField_a_of_type_AndroidContentContext);
                              paramaetk.setBackgroundResource(2130841428);
                              paramaetk.setGravity(17);
                              i = localAbsStructMsg.adverSign;
                              paramaetk.setText(alud.a(2131714972));
                              paramaetk.setTextColor(-1);
                              paramaetk.setTextSize(13.0F);
                              paramaeqi.setBackgroundColor(0);
                              localObject2 = new RelativeLayout.LayoutParams(aepi.a(80.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), aepi.a(44.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
                              ((RelativeLayout.LayoutParams)localObject2).addRule(11);
                              ((RelativeLayout.LayoutParams)localObject2).addRule(10);
                              paramaeqi.setLayoutParams((ViewGroup.LayoutParams)localObject2);
                              localObject2 = new RelativeLayout.LayoutParams(-2, -2);
                              ((RelativeLayout.LayoutParams)localObject2).addRule(11);
                              ((RelativeLayout.LayoutParams)localObject2).addRule(10);
                              paramaetk.setLayoutParams((ViewGroup.LayoutParams)localObject2);
                              paramaeqi.addView(paramaetk);
                              if ((paramView instanceof RelativeLayout)) {
                                ((RelativeLayout)paramView).addView(paramaeqi);
                              }
                              localObject2 = localMessageForStructing.frienduin;
                              l = localAbsStructMsg.msgId;
                              localObject2 = localMessageForStructing.getExtInfoFromExtStr("msg_template_id");
                              i = localMessageForStructing.istroop;
                              if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
                              {
                                paramaeqi.setOnClickListener(new agci(this, paramaetk, paramChatMessage, (String)localObject2));
                                continue;
                                label2652:
                                paramaeqi.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
                                continue;
                                label2660:
                                i = 0;
                                continue;
                                label2666:
                                if (!paramChatMessage.hasPlayedDui) {
                                  paramChatMessage.hasPlayedDui = DuiButtonImageView.a(paramaeqi);
                                }
                                for (;;)
                                {
                                  if (!DuiButtonImageView.jdField_a_of_type_Boolean) {
                                    break label2707;
                                  }
                                  paramaeqi.setOnClickListener(this);
                                  paramaeqi.setVisibility(0);
                                  break;
                                  paramaeqi.f();
                                }
                                paramaeqi.setOnClickListener(null);
                                paramaeqi.setVisibility(8);
                                continue;
                                paramaeqi.setVisibility(8);
                                paramaeqi.e();
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
            catch (Exception paramaeqi)
            {
              for (;;) {}
            }
          }
        }
      }
    }
  }
  
  public bdpi a(bdpi parambdpi, ChatMessage paramChatMessage, aeqz paramaeqz)
  {
    paramaeqz = (MessageForStructing)paramChatMessage;
    paramChatMessage = paramaeqz.structingMsg;
    if (paramChatMessage != null) {
      if ((!(paramChatMessage instanceof AbsShareMsg)) || (!((AbsShareMsg)paramChatMessage).mMsgException)) {}
    }
    label369:
    label375:
    label379:
    for (;;)
    {
      return parambdpi;
      if ((paramChatMessage.mMsgServiceID != 86) && (paramChatMessage.mMsgServiceID != 61) && (paramChatMessage.mMsgServiceID != 91) && (paramChatMessage.mMsgServiceID != 97) && (paramChatMessage.mMsgServiceID != 98) && (!(paramChatMessage instanceof StructMsgForHypertext)) && ((!paramaeqz.isSendFromLocal()) || (!(paramChatMessage instanceof AbsShareMsg)) || (!((AbsShareMsg)paramChatMessage).isSdkShareMsg()) || ((paramaeqz.extraflag != 32772) && (paramaeqz.extraflag != 32768))))
      {
        paramaeqz = this.jdField_a_of_type_AndroidContentContext.getResources();
        int i;
        if (paramChatMessage.fwFlag != 1) {
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008) {
            if (!paramChatMessage.hasFlag(32))
            {
              parambdpi.a(2131366781, paramaeqz.getString(2131692837), 2130838678);
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
          if ((i == 0) && (!a(paramChatMessage, parambdpi))) {
            break label379;
          }
          parambdpi.a(2131366017, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692401), 2130838677);
          return parambdpi;
          if (paramChatMessage.hasFlag(1)) {
            break;
          }
          parambdpi.a(2131366760, paramaeqz.getString(2131692837), 2130838678);
          break;
          if (paramChatMessage.mMsgServiceID == 14) {
            break;
          }
          if (!paramChatMessage.hasFlag(1))
          {
            parambdpi.a(2131366760, paramaeqz.getString(2131692837), 2130838678);
            break;
          }
          if (paramChatMessage.mMsgServiceID != 35) {
            break;
          }
          parambdpi.a(2131366760, paramaeqz.getString(2131692837), 2130838678);
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
    if (bdil.a(paramChatMessage.issend)) {
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
    Object localObject6 = agiy.a(paramChatMessage);
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
        localObject1 = bayu.a(paramChatMessage, 1);
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
                  agjb.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (URLDrawable)localObject1, paramChatMessage.frienduin, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914), paramContext, null);
                } while (!agiy.a((String)localObject6));
                binc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "3009", "2", "40053", agiy.b((String)localObject6), new String[] { "1", "", agiy.a((String)localObject6) });
                return;
                if (paramInt != 2131366760) {
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
          if ((localObject2 != null) && (((azwy)localObject2).a()))
          {
            paramContext.putExtra("key_forward_image_share", true);
            paramContext.putExtra("key_forward_image_share_appid", Long.toString(((StructMsgForImageShare)localObject1).mSourceAppid));
            paramContext.putExtra("key_forward_image_share_uin_type", ((StructMsgForImageShare)localObject1).uinType);
          }
          aryv.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramContext, 21);
          paramContext = paramChatMessage.structingMsg.mMsgUrl;
          localObject1 = paramChatMessage.senderuin;
          localObject2 = Long.toString(paramChatMessage.structingMsg.msgId);
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005455", "0X8005455", 0, 0, (String)localObject1, paramContext, (String)localObject2, "");
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
          if (paramChatMessage.structingMsg.mMsgServiceID == 84) {
            azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8007166", "0X8007166", 0, 0, "", "", "", "");
          }
          if (agiy.a((String)localObject6)) {
            binc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "3009", "2", "40053", agiy.b((String)localObject6), new String[] { "2", "", agiy.a((String)localObject6) });
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
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D66", "0X8009D66", paramInt, 0, "" + paramInt, "", "", "");
          return;
          if ((paramChatMessage.structingMsg != null) && (paramChatMessage.structingMsg.mMsgServiceID == 35))
          {
            azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006624", "0X8006624", 0, 1, 0, "", "", "", "");
            if (!aupg.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.uniseq))
            {
              paramInt = paramContext.getResources().getDimensionPixelSize(2131298914);
              QQToast.a(paramContext, alud.a(2131714979), 0).b(paramInt);
              return;
            }
            if (!aupg.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.uniseq)) {
              break;
            }
            bdgm.a(paramContext, 230, null, "选择的消息中，部分图片\\表情等内容可能无法正常转发，是否继续转发？", alud.a(2131714971), alud.a(2131714981), new agce(this, paramChatMessage), new agcm(this)).show();
            return;
          }
          if ((paramChatMessage.structingMsg == null) || (paramChatMessage.structingMsg.mMsgServiceID != 81)) {
            break;
          }
          wxj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramChatMessage, "forward");
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
        if (paramInt != 2131365071) {
          break;
        }
        acjm.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
        if (agiy.a((String)localObject6)) {
          binc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "3009", "2", "40053", agiy.b((String)localObject6), new String[] { "5", "", agiy.a((String)localObject6) });
        }
      } while ((paramChatMessage == null) || (!(paramChatMessage instanceof MessageForStructing)));
      paramContext = (MessageForStructing)paramChatMessage;
    } while ((paramContext.structingMsg == null) || (paramContext.structingMsg.mMsgServiceID != 81));
    wxj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramContext, "delete");
    return;
    long l2;
    long l1;
    if (paramInt == 2131370861)
    {
      super.d(paramChatMessage);
      if (agiy.a((String)localObject6)) {
        binc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "3009", "2", "40053", agiy.b((String)localObject6), new String[] { "6", "", agiy.a((String)localObject6) });
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
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X80064F7", "0X80064F7", 0, 0, paramContext, String.valueOf(l2), String.valueOf(paramInt), "");
      if ((paramChatMessage == null) || (!(paramChatMessage instanceof MessageForStructing))) {
        break;
      }
      paramContext = (MessageForStructing)paramChatMessage;
      if ((paramContext.structingMsg == null) || (paramContext.structingMsg.mMsgServiceID != 81)) {
        break;
      }
      wxj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramContext, "more");
      return;
      MessageForStructing localMessageForStructing;
      AbsShareMsg localAbsShareMsg;
      if (paramInt == 2131366017)
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
          if (agiy.a((String)localObject6))
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
            if (((azwy)localObject2).jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare == null) {
              ((azwy)localObject2).jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare = ((StructMsgForImageShare)localAbsShareMsg);
            }
            localObject5 = agjb.a(((azwy)localObject2).a());
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
            Object localObject7 = localObject1[3] + alud.a(2131714970) + localObject1[5] + alud.a(2131714976);
            localObject5 = "ADTAG=comic.plugin.read&id=" + localObject1[0] + "&name=" + URLEncoder.encode(localObject1[1]) + "&sectionID=" + localObject1[2] + "&sectionName=" + URLEncoder.encode(localObject1[3]) + "&pageID=" + localObject1[4] + "&page=" + localObject1[5] + "&type=" + localObject1[6];
            localObject4 = localObject5;
            if (!TextUtils.isEmpty(paramContext)) {
              localObject4 = (String)localObject5 + "&scrawl_link=" + URLEncoder.encode(paramContext);
            }
            paramContext = VipComicJumpActivity.a("comicReadShare", "5123", null, null, "354", null, (String)localObject4);
            new biva(6).a("nLinkType", 0).b("sTitle", localObject1[1]).b("sUrl", paramContext).a("bAppShare", false).a("lAppId", 0L).b("sPublisher", localAbsShareMsg.mSourceName).b("sBrief", (String)localObject7).b("sPath", (String)localObject2).b("sResUrl", localAbsShareMsg.mSourceUrl).a("lCategory", 1L).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
            bivo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 2);
            bivo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 8, 0, localAbsShareMsg.uinType);
            binc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "3009", "2", "40053", agiy.b((String)localObject6), new String[] { "3", "", agiy.a((String)localObject6) });
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
                  paramContext = bivs.a((StructMsgForImageShare)localAbsShareMsg);
                  if (paramContext != null)
                  {
                    biva.a(paramContext.U, localAbsShareMsg.uinType, paramContext.T, paramContext.c, paramContext.S, paramContext.d).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
                    bivo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2, 0, localAbsShareMsg.uinType);
                    bivo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 3);
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
                  azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D67", "0X8009D67", paramInt, 0, "" + paramInt, "", "", "");
                  return;
                  paramInt = 0;
                  break label1715;
                  if (!agiy.b((String)localObject6)) {
                    break label4331;
                  }
                  paramContext = agiy.b((String)localObject6);
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
                    localObject4 = agjb.a(paramContext.a());
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
                  biva.a((String)localObject2).c(paramContext).a((Activity)this.jdField_a_of_type_AndroidContentContext, paramContext);
                  bivo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 7, 0, localAbsShareMsg.uinType);
                  bivo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 2);
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
                    ((affg)paramContext.a(11)).a(paramContext, null, (MessageForStructing)paramChatMessage);
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
                  biva.a(Float.valueOf(paramContext).floatValue(), Float.valueOf((String)localObject1).floatValue(), (String)localObject4, (String)localObject2, null).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
                  bivo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 11, 0, localAbsShareMsg.uinType);
                  bivo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 7);
                  return;
                }
              }
              localObject4 = bivs.a(localAbsShareMsg.getXmlBytes());
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
                    biva.a(null, false, localAbsShareMsg.mContentTitle, localAbsShareMsg.mContentSummary, false, 0L, "").b("sBizDataList", paramContext).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
                    bivo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 10, 0, localAbsShareMsg.uinType);
                    bivo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, i);
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
                    if ((localObject1 instanceof azyj))
                    {
                      localObject5 = ((azyj)localObject1).a.iterator();
                      localObject1 = paramContext;
                      if (!((Iterator)localObject5).hasNext()) {
                        break label4317;
                      }
                      localObject1 = (azus)((Iterator)localObject5).next();
                      if (!(localObject1 instanceof azzv)) {
                        continue;
                      }
                      localObject5 = (azzv)localObject1;
                      paramContext = ((azzv)localObject5).S;
                      localObject1 = paramContext;
                      if (!((azzv)localObject5).a()) {
                        break label4317;
                      }
                      ntd.a("0X8006601", ((StructMsgForGeneralShare)localAbsShareMsg).uinType, ntd.a(((azzv)localObject5).r, ((StructMsgForGeneralShare)localObject2).mSourceName), ((azzv)localObject5).U, "");
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
                    localObject3 = bdgc.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), true);
                    localObject1 = localObject3;
                    if (TextUtils.isEmpty((CharSequence)localObject3)) {
                      localObject1 = localAbsShareMsg.mContentSrc;
                    }
                    biva.a(paramInt, localAbsShareMsg.mContentTitle, localAbsShareMsg.mMsgUrl, localAbsShareMsg.mSourceName, localAbsShareMsg.mContentSummary, paramContext, (String)localObject1, (byte[])localObject4, false, 0L).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a("lCategory", 10L).b("sUin", localAbsShareMsg.mSourceName).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
                    bivo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 8, 0, localAbsShareMsg.uinType);
                  }
                  else
                  {
                    localObject6 = new ArrayList();
                    localObject5 = localAbsShareMsg.mContentSummary;
                    if (a(localAbsShareMsg))
                    {
                      ((ArrayList)localObject6).add(bivc.a(true));
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
                      bivo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 10, 0, localAbsShareMsg.uinType);
                    }
                    for (;;)
                    {
                      biva.a(j, localAbsShareMsg.mContentTitle, localAbsShareMsg.mMsgUrl, localAbsShareMsg.mSourceName, (String)localObject1, paramContext, localAbsShareMsg.mContentSrc, (byte[])localObject3, false, 0L).b("sBizDataList", (ArrayList)localObject6).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
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
                      localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131698450) + (String)localObject7;
                      localObject3 = null;
                      j = paramInt;
                      break label3746;
                      if (baic.a(localAbsShareMsg.mMsgUrl)) {
                        bivo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 12, 0, localAbsShareMsg.uinType);
                      } else {
                        bivo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 8, 0, localAbsShareMsg.uinType);
                      }
                    }
                    paramInt = 2;
                    break label2451;
                    paramInt = 7;
                    break label2451;
                    if (paramInt == 2131364912)
                    {
                      paramContext = (MessageForStructing)paramChatMessage;
                      if ((paramContext == null) || (paramContext.structingMsg == null) || (!"web".equals(paramContext.structingMsg.mMsgAction)) || (paramContext.structingMsg.mMsgUrl == null)) {
                        break;
                      }
                      ((ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(paramContext.structingMsg.mMsgUrl);
                      return;
                    }
                    if (paramInt == 2131370850)
                    {
                      d(paramChatMessage);
                      return;
                    }
                    if (paramInt == 2131366781)
                    {
                      ThreadManager.post(new StructingMsgItemBuilder.4(this, paramChatMessage, paramContext), 8, null, false);
                      return;
                    }
                    if (paramInt == 2131370818)
                    {
                      super.a(paramChatMessage);
                      if (agiy.a((String)localObject6)) {
                        binc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "3009", "2", "40053", agiy.b((String)localObject6), new String[] { "4", "", agiy.a((String)localObject6) });
                      }
                      if ((paramChatMessage == null) || (!(paramChatMessage instanceof MessageForStructing))) {
                        break;
                      }
                      paramContext = (MessageForStructing)paramChatMessage;
                      if ((paramContext.structingMsg == null) || (paramContext.structingMsg.mMsgServiceID != 81)) {
                        break;
                      }
                      wxj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramContext, "withdraw");
                      return;
                    }
                    if (paramInt == 2131363923)
                    {
                      paramContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramChatMessage.frienduin, paramChatMessage.uniseq);
                      if ((paramContext == null) || (!(paramContext instanceof barf))) {
                        break;
                      }
                      ((barf)paramContext).a();
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
    if (aepi.a(paramView).isMultiMsg) {}
    Object localObject2;
    ChatMessage localChatMessage;
    String str1;
    do
    {
      do
      {
        return;
        localObject1 = aepi.a(paramView);
      } while (!agcx.class.isInstance(localObject1));
      localObject2 = this.jdField_a_of_type_AndroidContentContext;
      localChatMessage = ((agcx)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
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
        paramView = alud.a(2131714973);
        localObject2 = alud.a(2131714974);
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label282;
        }
      }
    }
    for (;;)
    {
      localObject2 = (bhuf)bhus.a(this.jdField_a_of_type_AndroidContentContext, null);
      ((bhuf)localObject2).c(paramView);
      ((bhuf)localObject2).d(this.jdField_a_of_type_AndroidContentContext.getString(2131690648));
      ((bhuf)localObject2).a((CharSequence)localObject1);
      ((bhuf)localObject2).a(new agcs(this, bool, localChatMessage, (bhuf)localObject2));
      ((bhuf)localObject2).show();
      return;
      paramView = alud.a(2131714975);
      break;
      bdgm.a((Context)localObject2, 230, paramView, str1, new agct(this, localChatMessage, (Context)localObject2), new agcu(this)).show();
      return;
      label282:
      localObject1 = localObject2;
    }
  }
  
  public void a(View paramView, bass parambass, int paramInt1, int paramInt2)
  {
    if (!BaseChatItemLayout.class.isInstance(paramView)) {}
    do
    {
      return;
      if ((parambass.jdField_b_of_type_Int == 1) || (parambass.jdField_b_of_type_Int == 131075))
      {
        b(paramView, parambass, paramInt1, paramInt2);
        return;
      }
    } while (parambass.jdField_b_of_type_Int != 52);
    c(paramView, parambass, paramInt1, paramInt2);
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
        paramView.setPadding(aepi.a(1.5F, paramChatMessage), aepi.a(2.0F, paramChatMessage), aepi.a(1.5F, paramChatMessage), paramView.getPaddingBottom());
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
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, aeqi paramaeqi, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramaeqi, paramInt1, paramInt2);
    if ((!(paramChatMessage instanceof MessageForStructing)) || (((MessageForStructing)paramChatMessage).structingMsg == null)) {}
    do
    {
      return;
      paramBaseChatItemLayout = (MessageForStructing)paramChatMessage;
      paramInt1 = paramBaseChatItemLayout.structingMsg.mMsgServiceID;
    } while ((a(paramBaseChatItemLayout)) || (paramInt1 == 83) || (paramInt1 == 151) || (paramInt1 == 156) || (paramInt1 == 108) || (paramInt1 == 114) || (paramInt1 == 98) || (paramInt1 == 97) || (paramInt1 == 5) || (paramInt1 == 137) || (paramInt1 == 106) || (paramInt1 == 107) || (paramInt1 == 122) || (paramInt1 == 116));
    paramInt2 = paramaeqi.jdField_a_of_type_AndroidViewView.getPaddingLeft();
    int i = paramaeqi.jdField_a_of_type_AndroidViewView.getPaddingRight();
    int m = paramaeqi.jdField_a_of_type_AndroidViewView.getPaddingTop();
    int n = paramaeqi.jdField_a_of_type_AndroidViewView.getPaddingBottom();
    int j = aepi.a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    boolean bool = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    int k;
    if (paramChatMessage.isSend())
    {
      paramInt1 = paramInt2;
      if (paramInt2 > j) {
        paramInt1 = paramInt2 - j;
      }
      paramaeqi.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130849444);
      j = paramInt1;
      k = i;
      if (bool)
      {
        j = paramInt1;
        k = i;
        if (paramaeqi.jdField_a_of_type_AndroidViewView.getParent() != null)
        {
          j = paramInt1;
          k = i;
          if ((paramaeqi.jdField_a_of_type_AndroidViewView.getParent() instanceof RelativeLayout))
          {
            paramBaseChatItemLayout = (RelativeLayout)paramaeqi.jdField_a_of_type_AndroidViewView.getParent();
            paramContext = new View(paramContext);
            localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
            localLayoutParams.addRule(6, 2131364173);
            localLayoutParams.addRule(5, 2131364173);
            localLayoutParams.addRule(7, 2131364173);
            localLayoutParams.addRule(8, 2131364173);
            if (paramaeqi.jdField_b_of_type_AndroidViewView != null) {
              paramBaseChatItemLayout.removeView(paramaeqi.jdField_b_of_type_AndroidViewView);
            }
            if (!aupn.a(paramChatMessage)) {
              break label440;
            }
            paramContext.setBackgroundResource(2130849441);
            paramaeqi.jdField_b_of_type_AndroidViewView = paramContext;
            paramBaseChatItemLayout.addView(paramaeqi.jdField_b_of_type_AndroidViewView, localLayoutParams);
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
          paramaeqi.jdField_a_of_type_AndroidViewView.setPadding(j, m, k, n);
          return;
          paramContext.setBackgroundResource(2130849440);
          break;
          paramInt1 = i;
          if (i > j) {
            paramInt1 = i - j;
          }
          paramaeqi.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130849268);
          j = paramInt2;
          k = paramInt1;
        } while (!bool);
        j = paramInt2;
        k = paramInt1;
      } while (paramaeqi.jdField_a_of_type_AndroidViewView.getParent() == null);
      j = paramInt2;
      k = paramInt1;
    } while (!(paramaeqi.jdField_a_of_type_AndroidViewView.getParent() instanceof RelativeLayout));
    paramBaseChatItemLayout = (RelativeLayout)paramaeqi.jdField_a_of_type_AndroidViewView.getParent();
    paramContext = new View(paramContext);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(6, 2131364173);
    localLayoutParams.addRule(5, 2131364173);
    localLayoutParams.addRule(7, 2131364173);
    localLayoutParams.addRule(8, 2131364173);
    if (paramaeqi.jdField_b_of_type_AndroidViewView != null) {
      paramBaseChatItemLayout.removeView(paramaeqi.jdField_b_of_type_AndroidViewView);
    }
    if (aupn.a(paramChatMessage)) {
      paramContext.setBackgroundResource(2130849265);
    }
    for (;;)
    {
      paramaeqi.jdField_b_of_type_AndroidViewView = paramContext;
      paramBaseChatItemLayout.addView(paramaeqi.jdField_b_of_type_AndroidViewView, localLayoutParams);
      j = paramInt2;
      k = paramInt1;
      break;
      paramContext.setBackgroundResource(2130849264);
    }
  }
  
  public void a(MessageForStructing paramMessageForStructing) {}
  
  public void a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage, long paramLong, float paramFloat) {}
  
  public void a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage, boolean paramBoolean)
  {
    paramXListView = aepi.a(paramView);
    if ((paramXListView instanceof agcx)) {}
    for (paramXListView = (agcx)paramXListView;; paramXListView = null)
    {
      if (paramXListView != null)
      {
        paramXListView = (ViewGroup)paramXListView.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
        int i = paramXListView.getChildCount();
        paramInt = 0;
        while (paramInt < i)
        {
          if ((paramXListView.getChildAt(paramInt).getTag() instanceof azxb))
          {
            paramView = (azxb)paramXListView.getChildAt(paramInt).getTag();
            if ((paramView.jdField_a_of_type_AndroidViewView.getTag() instanceof azzf))
            {
              paramView = (ImageView)((azzf)paramView.jdField_a_of_type_AndroidViewView.getTag()).c;
              paramView.clearAnimation();
              paramView.setBackgroundResource(2130841464);
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
  
  public boolean a(aeqi paramaeqi)
  {
    return paramaeqi instanceof agcx;
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
      paramString2 = azvd.a(paramString1.getExtras());
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
        if ((localObject == null) || (((azwy)localObject).d > 0L)) {
          break;
        }
        paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramChatMessage.frienduin, paramChatMessage.uniseq);
        if ((paramChatMessage instanceof barf))
        {
          if (((barf)paramChatMessage).c() == 1005L) {}
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
    paramXListView = aepi.a(paramView);
    if ((paramXListView instanceof agcx)) {}
    for (paramXListView = (agcx)paramXListView;; paramXListView = null)
    {
      if (paramXListView != null)
      {
        paramXListView = (ViewGroup)paramXListView.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
        int i = paramXListView.getChildCount();
        paramInt = 0;
        while (paramInt < i)
        {
          if ((paramXListView.getChildAt(paramInt).getTag() instanceof azxb))
          {
            paramView = (azxb)paramXListView.getChildAt(paramInt).getTag();
            if ((paramView.jdField_a_of_type_AndroidViewView.getTag() instanceof azzf)) {
              return bdhb.b(((azzf)paramView.jdField_a_of_type_AndroidViewView.getTag()).jdField_a_of_type_JavaLangString);
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
    Object localObject = aepi.a(paramView);
    if ((localObject instanceof agcx)) {}
    for (localObject = (agcx)localObject;; localObject = null)
    {
      if (localObject != null)
      {
        localObject = (ViewGroup)((agcx)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
        int i = ((ViewGroup)localObject).getChildCount();
        paramInt2 = 0;
        while (paramInt2 < i)
        {
          if (((((ViewGroup)localObject).getChildAt(paramInt2).getTag() instanceof azxb)) && (a(paramXListView, paramInt1, paramView, paramChatMessage)))
          {
            azxb localazxb = (azxb)((ViewGroup)localObject).getChildAt(paramInt2).getTag();
            if ((localazxb.jdField_a_of_type_AndroidViewView.getTag() instanceof azzf)) {
              paramAudioPlayer.a(((azzf)localazxb.jdField_a_of_type_AndroidViewView.getTag()).jdField_a_of_type_JavaLangString);
            }
          }
          paramInt2 += 1;
        }
        return true;
      }
      return false;
    }
  }
  
  public bdpk[] a(View paramView)
  {
    paramView = (MessageForStructing)aepi.a(paramView);
    bdpi localbdpi = new bdpi();
    if (paramView != null)
    {
      if (!paramView.isMultiMsg) {
        break label40;
      }
      a(localbdpi, paramView, null);
    }
    for (;;)
    {
      return localbdpi.a();
      label40:
      b(localbdpi, paramView, null);
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
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5A7", "0X800A5A7", 0, 0, "" + i, "", "", "");
      return;
    }
  }
  
  public bdpi b(bdpi parambdpi, ChatMessage paramChatMessage, aeqz paramaeqz)
  {
    paramaeqz = (MessageForStructing)paramChatMessage;
    AbsStructMsg localAbsStructMsg = paramaeqz.structingMsg;
    if (localAbsStructMsg != null)
    {
      if (((localAbsStructMsg instanceof AbsShareMsg)) && (((AbsShareMsg)localAbsStructMsg).mMsgException))
      {
        acjm.a(parambdpi, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008) {
          super.c(parambdpi, this.jdField_a_of_type_AndroidContentContext);
        }
        super.e(parambdpi, this.jdField_a_of_type_AndroidContentContext);
        return parambdpi;
      }
      if (localAbsStructMsg.mMsgServiceID == 86)
      {
        acjm.a(parambdpi, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        super.e(parambdpi, this.jdField_a_of_type_AndroidContentContext);
        return parambdpi;
      }
      if (localAbsStructMsg.mMsgServiceID == 61)
      {
        acjm.a(parambdpi, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        super.e(parambdpi, this.jdField_a_of_type_AndroidContentContext);
        return parambdpi;
      }
      if (localAbsStructMsg.mMsgServiceID == 91)
      {
        acjm.a(parambdpi, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        super.e(parambdpi, this.jdField_a_of_type_AndroidContentContext);
        return parambdpi;
      }
      if (localAbsStructMsg.mMsgServiceID == 97)
      {
        acjm.a(parambdpi, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        super.e(parambdpi, this.jdField_a_of_type_AndroidContentContext);
        return parambdpi;
      }
      if (localAbsStructMsg.mMsgServiceID == 98)
      {
        acjm.a(parambdpi, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        super.e(parambdpi, this.jdField_a_of_type_AndroidContentContext);
        return parambdpi;
      }
      if (localAbsStructMsg.mMsgServiceID == 128)
      {
        a(paramaeqz, parambdpi);
        acjm.a(parambdpi, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        b(paramaeqz, parambdpi);
        bdes.a("Grp_AIO", "invite", "send_in", 0, 0, new String[0]);
        return parambdpi;
      }
      if ((localAbsStructMsg instanceof StructMsgForHypertext))
      {
        acjm.a(parambdpi, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        super.c(parambdpi, this.jdField_a_of_type_AndroidContentContext);
        super.e(parambdpi, this.jdField_a_of_type_AndroidContentContext);
        return parambdpi;
      }
      if ((paramaeqz.isSendFromLocal()) && ((localAbsStructMsg instanceof AbsShareMsg)) && (((AbsShareMsg)localAbsStructMsg).isSdkShareMsg()) && ((paramaeqz.extraflag == 32772) || (paramaeqz.extraflag == 32768)))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramaeqz.frienduin, paramaeqz.uniseq) != null) {
          parambdpi.a(2131363923, this.jdField_a_of_type_AndroidContentContext.getString(2131690759), 2130838667);
        }
        for (;;)
        {
          super.e(parambdpi, this.jdField_a_of_type_AndroidContentContext);
          return parambdpi;
          acjm.a(parambdpi, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        }
      }
      if ((localAbsStructMsg instanceof StructMsgForImageShare))
      {
        azwy localazwy = ((StructMsgForImageShare)localAbsStructMsg).getFirstImageElement();
        if (localazwy == null) {
          break label1459;
        }
        paramChatMessage = localazwy.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
        if (paramChatMessage != null) {
          break label1456;
        }
        if (localazwy.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare == null)
        {
          localazwy.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare = ((StructMsgForImageShare)localAbsStructMsg);
          localazwy.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.message = paramaeqz;
        }
        localazwy.a(this.jdField_a_of_type_AndroidContentContext, null, null);
        paramChatMessage = localazwy.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
      }
    }
    for (;;)
    {
      int i;
      if ((paramChatMessage != null) && (bayu.a(this.jdField_a_of_type_AndroidContentContext, paramChatMessage, 65537)))
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
        super.e(parambdpi, this.jdField_a_of_type_AndroidContentContext);
        return parambdpi;
        i = 0;
        break;
      }
      label629:
      parambdpi.a(2131362126, this.jdField_a_of_type_AndroidContentContext.getString(2131693477), 2130838676);
      paramChatMessage = this.jdField_a_of_type_AndroidContentContext.getResources();
      if (localAbsStructMsg.fwFlag != 1)
      {
        if (localAbsStructMsg.hasFlag(8)) {
          parambdpi.a(2131364912, paramChatMessage.getString(2131691360), 2130838670);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008) {
          if (!localAbsStructMsg.hasFlag(32))
          {
            parambdpi.a(2131366781, paramChatMessage.getString(2131692837), 2130838678);
            a(paramaeqz, parambdpi);
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
          if ((paramaeqz.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramaeqz)))
          {
            int k = 1;
            j = k;
            if (paramaeqz.istroop == 1)
            {
              j = k;
              if (localAbsStructMsg != null) {
                if ((localAbsStructMsg.mMsgServiceID != 23) && (localAbsStructMsg.mMsgServiceID != 19) && (localAbsStructMsg.mMsgServiceID != 60) && (!alud.a(2131714980).equals(localAbsStructMsg.getSourceName())))
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
            if (((1008 != paramaeqz.istroop) || (!alof.u.equals(paramaeqz.frienduin))) && ((localAbsStructMsg == null) || (localAbsStructMsg.mMsgUrl == null) || (!localAbsStructMsg.mMsgUrl.startsWith("http://ti.qq.com/remind/view.html"))))
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
              a(parambdpi, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramaeqz);
            }
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1008) || (parambdpi.a() == 0)) {
            a(parambdpi, paramaeqz);
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
          if ((j != 0) || (a(localAbsStructMsg, parambdpi))) {
            parambdpi.a(2131366017, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692401), 2130838677);
          }
          if ((localAbsStructMsg != null) && (localAbsStructMsg.mMsgServiceID != 49) && (localAbsStructMsg.mMsgServiceID != 106) && (localAbsStructMsg.mMsgServiceID != 14)) {
            super.c(parambdpi, this.jdField_a_of_type_AndroidContentContext);
          }
          if ((localAbsStructMsg != null) && (localAbsStructMsg.mMsgServiceID == 81)) {
            wxj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramaeqz, "press");
          }
          super.e(parambdpi, this.jdField_a_of_type_AndroidContentContext);
          b(paramaeqz, parambdpi);
          return parambdpi;
          if (localAbsStructMsg.hasFlag(1)) {
            break;
          }
          parambdpi.a(2131366760, paramChatMessage.getString(2131692837), 2130838678);
          break;
          if (localAbsStructMsg.mMsgServiceID == 14) {
            break;
          }
          if (!localAbsStructMsg.hasFlag(1))
          {
            parambdpi.a(2131366760, paramChatMessage.getString(2131692837), 2130838678);
            break;
          }
          if (localAbsStructMsg.mMsgServiceID != 35) {
            break;
          }
          parambdpi.a(2131366760, paramChatMessage.getString(2131692837), 2130838678);
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006625", "0X8006625", 0, 1, 0, "", "", "", "");
          break;
          j = 1;
          break label795;
          a(paramaeqz, parambdpi);
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
  
  protected void b(View paramView, bass parambass, int paramInt1, int paramInt2)
  {
    paramView = aepi.a(paramView);
    if (!agcx.class.isInstance(paramView)) {}
    ChatMessage localChatMessage;
    do
    {
      do
      {
        return;
        paramView = (agcx)paramView;
      } while ((!agcx.class.isInstance(paramView)) || (paramView.jdField_a_of_type_AndroidWidgetRelativeLayout == null) || (!MessageForStructing.class.isInstance(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage)));
      localChatMessage = paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if ((localChatMessage.uniseq == parambass.jdField_b_of_type_Long) && (localChatMessage.isSendFromLocal()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("structMsg", 2, "handleMessage status = " + paramInt1 + ", retCode = " + paramInt2 + ", message.uniseq = " + localChatMessage.uniseq + ", file.uniseq = " + parambass.jdField_b_of_type_Long);
        }
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localChatMessage.frienduin, localChatMessage.uniseq), paramView);
        if (paramInt1 == 1005) {
          b();
        }
      }
    } while ((localChatMessage.uniseq != parambass.jdField_b_of_type_Long) || (paramInt1 != 2003) || (!(((MessageForStructing)localChatMessage).structingMsg instanceof StructMsgForImageShare)));
    paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
    parambass = new Bundle();
    paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(((MessageForStructing)localChatMessage).structingMsg.getView(this.jdField_a_of_type_AndroidContentContext, null, null, parambass));
  }
  
  public boolean b(ChatMessage paramChatMessage)
  {
    return true;
  }
  
  protected void c(View paramView, bass parambass, int paramInt1, int paramInt2)
  {
    paramView = aepi.a(paramView);
    if (!agcx.class.isInstance(paramView)) {}
    do
    {
      do
      {
        do
        {
          return;
          paramView = (agcx)paramView;
        } while ((!agcx.class.isInstance(paramView)) || (paramView.jdField_a_of_type_AndroidWidgetRelativeLayout == null) || (!MessageForStructing.class.isInstance(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage)));
        paramView = paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      } while ((paramView.uniseq != parambass.jdField_b_of_type_Long) || (!paramView.isSendFromLocal()));
      if (QLog.isColorLevel()) {
        QLog.d("structMsg", 2, "handleMessage status = " + paramInt1 + ", retCode = " + paramInt2 + ", message.uniseq = " + paramView.uniseq + ", file.uniseq = " + parambass.jdField_b_of_type_Long);
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
      if ((paramChatMessage != null) && (barf.class.isInstance(paramChatMessage)))
      {
        a(paramBaseChatItemLayout, ((barf)paramChatMessage).a(), 0, 0);
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
    bede localbede = (bede)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(76);
    bedd localbedd = localbede.a();
    if ((localbedd != null) && (localbedd.d == 0L) && (localbedd.a != 0L)) {
      localbede.a(localbedd.a);
    }
    long l2;
    if ((localbedd != null) && (localbedd.d == 1L))
    {
      l2 = localbede.a - (NetConnInfoCenter.getServerTimeMillis() - localbedd.e);
      if (l2 > 0L) {
        break label127;
      }
    }
    for (;;)
    {
      new Handler(this.jdField_a_of_type_AndroidContentContext.getMainLooper()).postDelayed(new StructingMsgItemBuilder.8(this, localbedd, localbede), l1);
      return;
      label127:
      l1 = l2;
    }
  }
  
  public void onClick(View paramView)
  {
    BaseChatPie localBaseChatPie;
    StructMsgForImageShare localStructMsgForImageShare;
    azwy localazwy;
    if (paramView.getId() == 2131365502)
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
      localObject = (MessageForStructing)((agcx)aepi.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if ((localObject == null) || (((MessageForStructing)localObject).structingMsg == null) || (!(((MessageForStructing)localObject).structingMsg instanceof StructMsgForImageShare))) {
        break label211;
      }
      localStructMsgForImageShare = (StructMsgForImageShare)((MessageForStructing)localObject).structingMsg;
      localazwy = localStructMsgForImageShare.getFirstImageElement();
      if (localazwy == null) {
        break label211;
      }
    }
    label173:
    label192:
    label211:
    for (Object localObject = new apjx(localazwy.T, localazwy.U, localazwy.c, localStructMsgForImageShare.rawUrl, ((MessageForStructing)localObject).senderuin);; localObject = null)
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