package com.tencent.mobileqq.activity.aio.item;

import adrm;
import afur;
import afwq;
import afwr;
import afwv;
import afxj;
import afyl;
import afzm;
import afzq;
import agmg;
import agor;
import ahjj;
import ahjo;
import ahjp;
import ahjq;
import ahjr;
import ahjs;
import ahju;
import ahjv;
import ahjw;
import ahjx;
import ahjy;
import ahjz;
import ahka;
import ahkc;
import ahte;
import ahth;
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
import anhk;
import anni;
import anxi;
import arms;
import atwl;
import aufz;
import autv;
import awwm;
import awwt;
import ayyz;
import bbyp;
import bbzj;
import bcrp;
import bcst;
import bcvs;
import bcvz;
import bcwd;
import bcxl;
import bcxy;
import bcyb;
import bcyk;
import bczn;
import bdaj;
import bdaz;
import bdjg;
import bdsh;
import bdsx;
import bduk;
import bdzi;
import bdzx;
import bfrd;
import bgjt;
import bglf;
import bglp;
import bgmg;
import bgnr;
import bgpa;
import bguh;
import bguj;
import bguz;
import bhkf;
import bhkg;
import bkho;
import bkif;
import bkni;
import bknl;
import blaq;
import bljl;
import bljn;
import bljv;
import bljz;
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
import nlw;
import och;
import odh;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import txu;
import txv;
import tzo;
import yqu;
import zlx;

public class StructingMsgItemBuilder
  extends BaseBubbleBuilder
  implements afwv, afyl, afzm
{
  public static final int[] a;
  static int c;
  private bcxl jdField_a_of_type_Bcxl;
  bkni jdField_a_of_type_Bkni;
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
    this.jdField_a_of_type_Bcxl = new bcxl();
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
      bhkg localbhkg = (bhkg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(76);
      bhkf localbhkf = localbhkg.a();
      BaseActivity localBaseActivity = (BaseActivity)this.jdField_a_of_type_AndroidContentContext;
      if ((localbhkf != null) && (localBaseActivity.isResume()) && (localbhkf.b.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (localbhkf.d == 2L) && (paramLong == localbhkf.a)) {
        localbhkg.a(localbhkf, localBaseActivity);
      }
    }
  }
  
  private void a(ahkc paramahkc, BaseChatItemLayout paramBaseChatItemLayout, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramBaseChatItemLayout.setHeadIconVisible(false);
      paramahkc.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130850664);
      int i = paramahkc.jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingLeft();
      int j = paramahkc.jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingLeft();
      paramahkc.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, i, 0, j);
      return;
    }
    paramBaseChatItemLayout.setHeadIconVisible(true);
  }
  
  private void a(ahkc paramahkc, BaseChatItemLayout paramBaseChatItemLayout, boolean paramBoolean1, AbsStructMsg paramAbsStructMsg, Resources paramResources, boolean paramBoolean2)
  {
    Object localObject2 = paramahkc.jdField_b_of_type_AndroidWidgetRelativeLayout;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramahkc.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject1);
      ((RelativeLayout)localObject1).setId(2131377927);
      paramBaseChatItemLayout.addView((View)localObject1);
    }
    Object localObject3 = (RelativeLayout.LayoutParams)((RelativeLayout)localObject1).getLayoutParams();
    localObject2 = localObject3;
    if (localObject3 == null) {
      localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    }
    ((RelativeLayout.LayoutParams)localObject2).topMargin = afur.a(-2.0F, paramResources);
    if (paramBoolean2)
    {
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = afur.a(0.0F, paramResources);
      ((RelativeLayout.LayoutParams)localObject2).addRule(5, 2131364379);
      ((RelativeLayout.LayoutParams)localObject2).addRule(3, 2131364379);
      if (!paramBoolean1) {
        break label527;
      }
      ((RelativeLayout.LayoutParams)localObject2).addRule(1, 0);
      ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131364388);
      label143:
      ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject3 = ((RelativeLayout)localObject1).getChildAt(0);
      localObject2 = localObject3;
      if (localObject3 != null)
      {
        localObject2 = localObject3;
        if (paramahkc.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
        {
          Object localObject4 = paramahkc.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
          localObject2 = localObject3;
          if (localObject4 != null)
          {
            localObject4 = ((View)localObject4).getTag(2131377946);
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
        break label547;
      }
      ((View)localObject2).setId(2131377928);
      ((RelativeLayout)localObject1).addView((View)localObject2);
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
      {
        paramahkc = new View(this.jdField_a_of_type_AndroidContentContext);
        paramBaseChatItemLayout = new RelativeLayout.LayoutParams(-2, -2);
        paramBaseChatItemLayout.addRule(6, 2131377928);
        paramBaseChatItemLayout.addRule(5, 2131377928);
        paramBaseChatItemLayout.addRule(7, 2131377928);
        paramBaseChatItemLayout.addRule(8, 2131377928);
        paramahkc.setBackgroundResource(2130837971);
        ((RelativeLayout)localObject1).addView(paramahkc, paramBaseChatItemLayout);
      }
    }
    for (;;)
    {
      a(paramAbsStructMsg, (RelativeLayout)localObject1);
      autv.a((View)localObject2, (RelativeLayout)localObject1, paramBoolean1, paramResources, this.jdField_a_of_type_AndroidContentContext, paramAbsStructMsg);
      return;
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = afur.a(10.0F, paramResources);
      if ((!paramBoolean1) || ((paramAbsStructMsg.mMsgServiceID != 83) && (paramAbsStructMsg.mMsgServiceID != 108) && (paramAbsStructMsg.mMsgServiceID != 114) && (paramAbsStructMsg.mMsgServiceID != 116) && (paramAbsStructMsg.mMsgServiceID != 151) && (paramAbsStructMsg.mMsgServiceID != 156)) || (TextUtils.isEmpty(paramAbsStructMsg.mMsgActionData))) {
        break;
      }
      ((RelativeLayout.LayoutParams)localObject2).leftMargin += afur.a(18.0F, paramResources);
      break;
      label527:
      ((RelativeLayout.LayoutParams)localObject2).addRule(1, 2131364388);
      ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131364379);
      break label143;
      label547:
      paramBaseChatItemLayout.removeView((View)localObject1);
      paramahkc.jdField_b_of_type_AndroidWidgetRelativeLayout = null;
    }
  }
  
  private void a(ahkc paramahkc, BaseChatItemLayout paramBaseChatItemLayout, boolean paramBoolean1, StructMsgForGeneralShare paramStructMsgForGeneralShare, Resources paramResources, boolean paramBoolean2)
  {
    RelativeLayout localRelativeLayout = paramahkc.c;
    Object localObject = localRelativeLayout;
    if (localRelativeLayout == null)
    {
      localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramahkc.jdField_b_of_type_AndroidWidgetRelativeLayout = localRelativeLayout;
      localRelativeLayout.setId(2131377926);
      paramBaseChatItemLayout.addView(localRelativeLayout);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localRelativeLayout.getLayoutParams();
      localObject = localLayoutParams;
      if (localLayoutParams == null) {
        localObject = new RelativeLayout.LayoutParams(-2, -2);
      }
      ((RelativeLayout.LayoutParams)localObject).topMargin = (12 - afur.a(10.0F, paramResources));
      ((RelativeLayout.LayoutParams)localObject).addRule(5, 2131364379);
      ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131364379);
      localObject = localRelativeLayout;
    }
    paramResources = ((RelativeLayout)localObject).getChildAt(0);
    paramStructMsgForGeneralShare = paramStructMsgForGeneralShare.getAdSourceView(this.jdField_a_of_type_AndroidContentContext, paramResources, paramBaseChatItemLayout);
    if (paramStructMsgForGeneralShare != null)
    {
      ((RelativeLayout)localObject).addView(paramStructMsgForGeneralShare);
      paramahkc = (RelativeLayout.LayoutParams)paramStructMsgForGeneralShare.getLayoutParams();
      paramahkc.topMargin = zlx.a(this.jdField_a_of_type_AndroidContentContext, 10.0F);
      paramahkc.height = -2;
      paramahkc.width = -2;
      return;
    }
    paramBaseChatItemLayout.removeView((View)localObject);
    paramahkc.jdField_b_of_type_AndroidWidgetRelativeLayout = null;
  }
  
  private void a(Activity paramActivity)
  {
    ReportDialog localReportDialog = new ReportDialog(paramActivity);
    localReportDialog.requestWindowFeature(1);
    localReportDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    View localView = LayoutInflater.from(paramActivity).inflate(2131559645, null);
    ((ImageView)localView.findViewById(2131368269)).setImageResource(2130839584);
    ((TextView)localView.findViewById(2131378459)).setText(anni.a(2131713279));
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
        Object localObject2 = new bknl();
        ((bknl)localObject2).jdField_a_of_type_Int = i;
        ((bknl)localObject2).jdField_b_of_type_Int = 0;
        if (localJSONObject.has("show_name")) {}
        for (((bknl)localObject2).jdField_a_of_type_JavaLangString = localJSONObject.getString("show_name");; ((bknl)localObject2).jdField_a_of_type_JavaLangString = "")
        {
          localArrayList1.add(localObject2);
          localObject2 = new txu();
          ((txu)localObject2).jdField_a_of_type_JavaLangString = str;
          ((txu)localObject2).c = localJSONObject.optString("index");
          ((txu)localObject2).d = localJSONObject.optString("index_name");
          ((txu)localObject2).b = localJSONObject.optString("index_type");
          ((txu)localObject2).e = String.valueOf(nlw.a());
          localArrayList2.add(localObject2);
          i += 1;
          break;
        }
      }
      this.jdField_a_of_type_Bkni = bkni.a(paramActivity, localArrayList1, new ahjo(this, paramActivity, paramChatMessage, localAbsStructMsg, str, localArrayList2), new ahjp(this), afur.a(100.0F, paramActivity.getResources()));
    }
    catch (JSONException paramActivity)
    {
      paramActivity.printStackTrace();
      return;
    }
    int i = paramView.getWidth() * 7 / 2;
    this.jdField_a_of_type_Bkni.showAsDropDown(paramView, 0 - i, 0);
    this.jdField_a_of_type_Bkni.dismiss();
    paramActivity = new int[2];
    paramView.getLocationOnScreen(paramActivity);
    this.jdField_a_of_type_Bkni.showAtLocation(paramView, 0, paramActivity[0], paramActivity[1] + paramView.getHeight());
    this.jdField_a_of_type_Bkni.setOnDismissListener(new ahjq(this));
  }
  
  private void a(View paramView, StructMsgForGeneralShare paramStructMsgForGeneralShare)
  {
    new bcvz(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView).a(paramStructMsgForGeneralShare.mMsgAction, paramStructMsgForGeneralShare.mMsgUrl, paramStructMsgForGeneralShare.mMsgActionData, paramStructMsgForGeneralShare.mMsg_A_ActionData);
  }
  
  private void a(bguz parambguz, ahkc paramahkc)
  {
    if (paramahkc.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
      return;
    }
    Object localObject;
    int i;
    if ((parambguz instanceof bdsx))
    {
      localObject = (bdsx)parambguz;
      i = (int)((bdsx)localObject).c();
      if ((i != 1004) || (!((bdsx)localObject).c()) || (!((bdsx)localObject).d())) {
        break label416;
      }
      i = 1006;
    }
    label416:
    for (;;)
    {
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(6, 2131377946);
      ((RelativeLayout.LayoutParams)localObject).addRule(8, 2131377946);
      ((RelativeLayout.LayoutParams)localObject).addRule(5, 2131377946);
      ((RelativeLayout.LayoutParams)localObject).addRule(7, 2131377946);
      if ((paramahkc.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (paramahkc.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131377933) == null) && (paramahkc.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView != null)) {
        paramahkc.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramahkc.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView, (ViewGroup.LayoutParams)localObject);
      }
      switch (i)
      {
      default: 
        if (paramahkc.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView == null) {
          break;
        }
        paramahkc.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setProcessor(null);
        paramahkc.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(8);
        return;
      case 1000: 
      case 1001: 
      case 1002: 
      case 1006: 
      case 4001: 
        if (paramahkc.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView == null)
        {
          MessageProgressTextView localMessageProgressTextView = new MessageProgressTextView(this.jdField_a_of_type_AndroidContentContext);
          localMessageProgressTextView.setTextColor(-1);
          localMessageProgressTextView.setTextSize(2, 15.0F);
          localMessageProgressTextView.setGravity(17);
          localMessageProgressTextView.setId(2131377933);
          localMessageProgressTextView.setBackgroundDrawable(new agor(2130706432, this.jdField_b_of_type_Float * 12.0F));
          if (paramahkc.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
            paramahkc.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localMessageProgressTextView, (ViewGroup.LayoutParams)localObject);
          }
          paramahkc.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView = localMessageProgressTextView;
        }
        paramahkc.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setProcessor((bdsx)parambguz);
        paramahkc.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(0);
        switch (i)
        {
        }
        for (;;)
        {
          paramahkc.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.a();
          return;
          paramahkc.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setProgress(0);
          return;
          paramahkc.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setProgress(0);
        }
        if (paramahkc.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView == null) {
          break;
        }
        paramahkc.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setProcessor(null);
        paramahkc.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(4);
        return;
      }
    }
  }
  
  private void a(BaseChatItemLayout paramBaseChatItemLayout, MessageForStructing paramMessageForStructing)
  {
    int i = ((StructMsgForGeneralShare)paramMessageForStructing.structingMsg).getProgress();
    if ((paramMessageForStructing.extraflag == 32772) && (i >= 0) && (i < 100))
    {
      anxi localanxi = (anxi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(28);
      localanxi.a(bbzj.a(paramMessageForStructing.msgUid), paramMessageForStructing.frienduin, paramMessageForStructing.uniseq);
      paramMessageForStructing = new ahjw(this, paramMessageForStructing, paramBaseChatItemLayout);
      paramBaseChatItemLayout.setTag(2131379239, paramMessageForStructing);
      localanxi.a(paramBaseChatItemLayout, paramMessageForStructing);
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
  
  private boolean a(AbsStructMsg paramAbsStructMsg, bguh parambguh)
  {
    boolean bool2 = true;
    int i = 0;
    boolean bool1;
    if ((paramAbsStructMsg == null) || (parambguh == null) || (this.jdField_a_of_type_AndroidContentContext == null)) {
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
      j = parambguh.a();
      bool1 = bool2;
    } while (j <= 0);
    for (;;)
    {
      bool1 = bool2;
      if (i >= j) {
        break;
      }
      paramAbsStructMsg = parambguh.a(i);
      if (paramAbsStructMsg != null)
      {
        bool1 = bool2;
        if (paramAbsStructMsg.a() == 2131366271) {
          break;
        }
      }
      i += 1;
    }
    return false;
  }
  
  private void b(Activity paramActivity)
  {
    ReportDialog localReportDialog = new ReportDialog(paramActivity);
    localReportDialog.requestWindowFeature(1);
    localReportDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    View localView = LayoutInflater.from(paramActivity).inflate(2131559645, null);
    ((ImageView)localView.findViewById(2131368269)).setImageResource(2130839571);
    ((TextView)localView.findViewById(2131378459)).setText(anni.a(2131713278));
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
        bknl localbknl = new bknl();
        if (localJSONObject.has("index"))
        {
          localbknl.jdField_a_of_type_Int = localJSONObject.getInt("index");
          localbknl.jdField_b_of_type_Int = 0;
          if (localJSONObject.has("show_name"))
          {
            localbknl.jdField_a_of_type_JavaLangString = localJSONObject.getString("show_name");
            localArrayList.add(localbknl);
            i += 1;
          }
        }
        else
        {
          localbknl.jdField_a_of_type_Int = i;
          continue;
        }
        localbknl.jdField_a_of_type_JavaLangString = "";
      }
      catch (JSONException paramActivity)
      {
        paramActivity.printStackTrace();
        return;
      }
    }
    this.jdField_a_of_type_Bkni = bkni.a(paramActivity, localArrayList, new ahjs(this, paramChatMessage, paramActivity, localAbsStructMsg), new ahju(this), afur.a(100.0F, paramActivity.getResources()));
    int i = paramView.getWidth() * -5 / 7;
    this.jdField_a_of_type_Bkni.showAsDropDown(paramView, i, 0);
    this.jdField_a_of_type_Bkni.dismiss();
    paramActivity = new int[2];
    paramView.getLocationOnScreen(paramActivity);
    this.jdField_a_of_type_Bkni.showAtLocation(paramView, 0, paramActivity[0], paramActivity[1] + paramView.getHeight());
    this.jdField_a_of_type_Bkni.setOnDismissListener(new ahjv(this));
  }
  
  private static void b(String paramString, URL paramURL, ThumbWidthHeightDP paramThumbWidthHeightDP)
  {
    CompressInfo localCompressInfo = new CompressInfo(paramString, 0);
    localCompressInfo.f = true;
    paramString = bdsh.d(paramURL.toString());
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
        if (ayyz.b(localCompressInfo))
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
          bool = atwl.a(new File(localCompressInfo.c), paramString);
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
          if ((paramChatMessage.getItemByIndex(i) instanceof bcyk)) {
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
  
  public afwq a(View paramView)
  {
    try
    {
      ChatMessage localChatMessage = afur.a(paramView);
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
          return (afwq)paramView.findViewById(2131368450);
        }
      } while ((((MessageForStructing)localObject).structingMsg == null) || (((MessageForStructing)localObject).structingMsg.mMsgServiceID != 107));
      Object localObject = paramView.findViewById(2131376104);
      if (localObject != null) {
        return (afwq)((View)localObject).getTag(-1);
      }
      paramView = "getTouchDelegate when receipt message but the root view is null \r\n" + paramView;
      bcrp.a(new IllegalStateException(paramView), "StructingMsgItemBuilderCatchedException" + paramView);
    }
    return null;
  }
  
  protected ahkc a()
  {
    return new ahkc();
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, afzq paramafzq)
  {
    this.jdField_a_of_type_Bcxl.a();
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
        yqu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, localMessageForStructing, "exp");
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
      if ((paramView.getTag() instanceof afwr))
      {
        localObject = (afwr)paramView.getTag();
        j = k;
        if (localObject != null) {
          j = ((afwr)localObject).jdField_b_of_type_Int;
        }
      }
    }
    localAbsStructMsg.message = localMessageForStructing;
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramafzq);
    if (localAbsStructMsg.mMsgServiceID == 76)
    {
      paramInt2 = afur.a(11.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      k = afur.a(7.5F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramView.setPadding(0, 0, 0, 0);
      paramViewGroup = (afwr)paramView.getTag();
      paramViewGroup.jdField_a_of_type_AndroidViewView.setPadding(0, 0, 0, 0);
      ((RelativeLayout.LayoutParams)paramViewGroup.jdField_a_of_type_AndroidViewView.getLayoutParams()).setMargins(paramInt2, k, paramInt2, k);
    }
    if (localAbsStructMsg.mMsgServiceID == 35)
    {
      paramViewGroup = (afwr)paramView.getTag();
      paramViewGroup.jdField_a_of_type_AndroidViewView.setPadding(paramViewGroup.jdField_a_of_type_AndroidViewView.getPaddingLeft(), 0, paramViewGroup.jdField_a_of_type_AndroidViewView.getPaddingRight(), 0);
    }
    paramViewGroup = (ahkc)paramView.getTag();
    Object localObject = paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
    if (((i == 1) || (j != paramViewGroup.jdField_b_of_type_Int)) && (localAbsStructMsg.mMsgServiceID == 128)) {
      bgjt.a("Grp_AIO", "invite", "send_exp", 0, 0, new String[] { String.valueOf(localAbsStructMsg.uniseq) });
    }
    int m;
    if ((localAbsStructMsg instanceof AbsShareMsg))
    {
      paramInt2 = ((AbsShareMsg)localAbsStructMsg).mContentLayout;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1008) && (localAbsStructMsg.hasFlag(4))) {
        localAbsStructMsg.addFlag(1);
      }
      paramafzq = this.jdField_a_of_type_AndroidContentContext.getResources();
      boolean bool = a(localMessageForStructing);
      if (QLog.isDevelopLevel()) {
        QLog.d("StructingMsgItemBuilder", 4, "getView:position:" + paramInt1 + "hasHead" + bool);
      }
      a(paramViewGroup, (BaseChatItemLayout)localObject, bool);
      a(paramViewGroup, (BaseChatItemLayout)localObject, localMessageForStructing.isSend(), localAbsStructMsg, paramafzq, bool);
      if (((localAbsStructMsg instanceof StructMsgForGeneralShare)) && (((StructMsgForGeneralShare)localAbsStructMsg).mHasAdSource)) {
        a(paramViewGroup, (BaseChatItemLayout)localObject, localMessageForStructing.isSend(), (StructMsgForGeneralShare)localAbsStructMsg, paramafzq, bool);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008) || (localMessageForStructing.structingMsg.mMsgServiceID == 76) || (localMessageForStructing.structingMsg.mMsgServiceID == 21))
      {
        k = paramafzq.getDimensionPixelSize(2131298898);
        m = paramafzq.getDimensionPixelSize(2131298898);
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
          j = afur.a(30.0F, paramafzq);
          paramInt1 = j;
          if (((BaseChatItemLayout)localObject).jdField_a_of_type_AndroidWidgetCheckBox != null)
          {
            localObject = (RelativeLayout.LayoutParams)((BaseChatItemLayout)localObject).jdField_a_of_type_AndroidWidgetCheckBox.getLayoutParams();
            paramInt1 = j;
            if (localObject != null)
            {
              ((RelativeLayout.LayoutParams)localObject).leftMargin = afur.a(5.0F, paramafzq);
              paramInt1 = j;
            }
          }
        }
        paramafzq = (RelativeLayout.LayoutParams)((RelativeLayout)((BaseChatItemLayout)paramView).b()).getLayoutParams();
        if (paramafzq != null)
        {
          if (localMessageForStructing.structingMsg.mMsgServiceID == 21) {
            break label1013;
          }
          paramafzq.setMargins(paramInt1, 0, m, 0);
        }
      }
    }
    for (;;)
    {
      paramView.requestLayout();
      if ((paramViewGroup != null) && (paramViewGroup.jdField_a_of_type_ComTencentMobileqqDataChatMessage == paramChatMessage) && (localAbsStructMsg.hasFlag(16))) {
        ThreadManager.post(new StructingMsgItemBuilder.5(this, paramViewGroup), 2, null, false);
      }
      paramafzq = (bfrd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(132);
      if (paramafzq.b(paramChatMessage))
      {
        paramafzq.a(paramChatMessage.uniseq);
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
        paramafzq = AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidContentContext, 2130772211);
        paramafzq.setAnimationListener(new ahka(this, paramViewGroup));
        paramViewGroup.jdField_a_of_type_AndroidViewView.postDelayed(new StructingMsgItemBuilder.7(this, paramViewGroup, paramafzq), 300L);
      }
      this.jdField_a_of_type_Bcxl.a(paramInt2, i);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && ("3046055438".equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
        odh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, paramView);
      }
      return paramView;
      paramInt2 = -1;
      break;
      label1008:
      paramInt1 = 0;
      break label678;
      label1013:
      paramafzq.setMargins(paramInt1, paramafzq.topMargin, m, paramafzq.bottomMargin);
    }
  }
  
  /* Error */
  public View a(ChatMessage paramChatMessage, afwr paramafwr, View paramView, BaseChatItemLayout paramBaseChatItemLayout, afzq paramafzq)
  {
    // Byte code:
    //   0: new 1138	android/os/Bundle
    //   3: dup
    //   4: invokespecial 1139	android/os/Bundle:<init>	()V
    //   7: astore 15
    //   9: aload_0
    //   10: getfield 92	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   13: instanceof 94
    //   16: ifne +13 -> 29
    //   19: aload_0
    //   20: getfield 92	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   23: instanceof 96
    //   26: ifeq +2851 -> 2877
    //   29: aload_0
    //   30: getfield 92	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   33: checkcast 1141	android/support/v4/app/FragmentActivity
    //   36: invokevirtual 1145	android/support/v4/app/FragmentActivity:getChatFragment	()Lcom/tencent/mobileqq/activity/ChatFragment;
    //   39: invokevirtual 1150	com/tencent/mobileqq/activity/ChatFragment:a	()Lcom/tencent/mobileqq/activity/BaseChatPie;
    //   42: invokevirtual 1155	com/tencent/mobileqq/activity/BaseChatPie:a	()Lahkd;
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
    //   79: ldc_w 1156
    //   82: aload 9
    //   84: invokestatic 203	afur:a	(FLandroid/content/res/Resources;)I
    //   87: invokevirtual 1159	android/widget/RelativeLayout:setMinimumHeight	(I)V
    //   90: aload_3
    //   91: iconst_1
    //   92: invokevirtual 1162	android/widget/RelativeLayout:setClickable	(Z)V
    //   95: aload_3
    //   96: getstatic 1165	com/tencent/mobileqq/activity/aio/BaseChatItemLayout:j	I
    //   99: getstatic 1167	com/tencent/mobileqq/activity/aio/BaseChatItemLayout:h	I
    //   102: getstatic 1170	com/tencent/mobileqq/activity/aio/BaseChatItemLayout:k	I
    //   105: getstatic 1173	com/tencent/mobileqq/activity/aio/BaseChatItemLayout:i	I
    //   108: invokevirtual 174	android/widget/RelativeLayout:setPadding	(IIII)V
    //   111: aload_3
    //   112: ldc_w 1174
    //   115: invokevirtual 1175	android/widget/RelativeLayout:setBackgroundResource	(I)V
    //   118: new 194	android/widget/RelativeLayout$LayoutParams
    //   121: dup
    //   122: bipush 254
    //   124: bipush 254
    //   126: invokespecial 197	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   129: astore 11
    //   131: aload 9
    //   133: ldc_w 1051
    //   136: invokevirtual 1055	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   139: istore 6
    //   141: aload 11
    //   143: iload 6
    //   145: iconst_0
    //   146: iload 6
    //   148: iconst_0
    //   149: invokevirtual 993	android/widget/RelativeLayout$LayoutParams:setMargins	(IIII)V
    //   152: aload 11
    //   154: iconst_1
    //   155: ldc_w 1176
    //   158: invokevirtual 213	android/widget/RelativeLayout$LayoutParams:addRule	(II)V
    //   161: aload_3
    //   162: aload 11
    //   164: invokevirtual 218	android/widget/RelativeLayout:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   167: ldc 69
    //   169: aload_1
    //   170: invokevirtual 1179	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   173: ifne +30 -> 203
    //   176: aload_3
    //   177: areturn
    //   178: aload_3
    //   179: instanceof 1181
    //   182: ifeq +18 -> 200
    //   185: aload_0
    //   186: aload_1
    //   187: invokespecial 1183	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:c	(Lcom/tencent/mobileqq/data/ChatMessage;)Z
    //   190: ifne +10 -> 200
    //   193: aload_3
    //   194: checkcast 1181	android/view/ViewGroup
    //   197: invokevirtual 1184	android/view/ViewGroup:removeAllViews	()V
    //   200: goto -33 -> 167
    //   203: aload_2
    //   204: getfield 1185	afwr:jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout	Lcom/tencent/mobileqq/activity/aio/BaseChatItemLayout;
    //   207: aload_0
    //   208: invokevirtual 1189	com/tencent/mobileqq/activity/aio/BaseChatItemLayout:setMiniAioShieldItemTouchListener	(Lafwv;)V
    //   211: aload_1
    //   212: checkcast 69	com/tencent/mobileqq/data/MessageForStructing
    //   215: astore 13
    //   217: aload 13
    //   219: getfield 73	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   222: astore 14
    //   224: aload 14
    //   226: ifnonnull +76 -> 302
    //   229: invokestatic 232	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   232: ifeq -56 -> 176
    //   235: new 236	java/lang/StringBuilder
    //   238: dup
    //   239: invokespecial 237	java/lang/StringBuilder:<init>	()V
    //   242: ldc_w 1191
    //   245: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: astore_2
    //   249: aload 13
    //   251: ifnonnull +23 -> 274
    //   254: ldc_w 1193
    //   257: astore_1
    //   258: ldc 234
    //   260: iconst_2
    //   261: aload_2
    //   262: aload_1
    //   263: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   266: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   269: invokestatic 252	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   272: aload_3
    //   273: areturn
    //   274: aload 13
    //   276: getfield 1197	com/tencent/mobileqq/data/MessageForStructing:msgData	[B
    //   279: ifnonnull +10 -> 289
    //   282: ldc_w 1193
    //   285: astore_1
    //   286: goto -28 -> 258
    //   289: aload 13
    //   291: getfield 1197	com/tencent/mobileqq/data/MessageForStructing:msgData	[B
    //   294: arraylength
    //   295: invokestatic 660	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   298: astore_1
    //   299: goto -41 -> 258
    //   302: aload 14
    //   304: aload 13
    //   306: putfield 984	com/tencent/mobileqq/structmsg/AbsStructMsg:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   309: aload_0
    //   310: getfield 124	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   313: ifnull +242 -> 555
    //   316: aload_0
    //   317: getfield 124	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   320: getfield 1020	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_Int	I
    //   323: sipush 1008
    //   326: if_icmpne +229 -> 555
    //   329: aload 14
    //   331: instanceof 75
    //   334: ifeq +39 -> 373
    //   337: aload 14
    //   339: checkcast 75	com/tencent/mobileqq/structmsg/StructMsgForGeneralShare
    //   342: astore_2
    //   343: aload 15
    //   345: ldc_w 1199
    //   348: aload_0
    //   349: getfield 124	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   352: getfield 128	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   355: invokevirtual 1203	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   358: aload 15
    //   360: ldc_w 1205
    //   363: aload_0
    //   364: getfield 124	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   367: getfield 1206	com/tencent/mobileqq/activity/aio/SessionInfo:d	Ljava/lang/String;
    //   370: invokevirtual 1203	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   373: aload 15
    //   375: ldc_w 1208
    //   378: iconst_1
    //   379: invokevirtual 1212	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   382: aload_1
    //   383: ldc_w 1214
    //   386: invokevirtual 970	com/tencent/mobileqq/data/ChatMessage:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   389: astore_2
    //   390: aload_2
    //   391: ifnull +164 -> 555
    //   394: aload_2
    //   395: ldc_w 489
    //   398: invokevirtual 691	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   401: ifne +154 -> 555
    //   404: aload_2
    //   405: invokestatic 306	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   408: ifne +9 -> 417
    //   411: aload 14
    //   413: aload_2
    //   414: putfield 1217	com/tencent/mobileqq/structmsg/AbsStructMsg:templateIDForPortal	Ljava/lang/String;
    //   417: aload 14
    //   419: instanceof 662
    //   422: ifeq +133 -> 555
    //   425: aload 14
    //   427: checkcast 662	com/tencent/mobileqq/structmsg/AbsShareMsg
    //   430: invokevirtual 1221	com/tencent/mobileqq/structmsg/AbsShareMsg:getStructMsgItemLists	()Ljava/util/List;
    //   433: astore 9
    //   435: aload 9
    //   437: ifnull +118 -> 555
    //   440: aload 9
    //   442: invokeinterface 1225 1 0
    //   447: astore 9
    //   449: aload 9
    //   451: invokeinterface 1230 1 0
    //   456: ifeq +99 -> 555
    //   459: aload 9
    //   461: invokeinterface 1233 1 0
    //   466: checkcast 1235	bcvs
    //   469: astore 11
    //   471: aload_2
    //   472: invokestatic 306	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   475: ifne +9 -> 484
    //   478: aload 11
    //   480: aload_2
    //   481: putfield 1238	bcvs:X	Ljava/lang/String;
    //   484: aload 11
    //   486: instanceof 1240
    //   489: ifeq -40 -> 449
    //   492: aload 11
    //   494: checkcast 1240	bcvt
    //   497: astore 11
    //   499: aload 11
    //   501: getfield 1243	bcvt:a	Ljava/util/ArrayList;
    //   504: ifnull -55 -> 449
    //   507: aload 11
    //   509: getfield 1243	bcvt:a	Ljava/util/ArrayList;
    //   512: invokevirtual 1244	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   515: astore 11
    //   517: aload 11
    //   519: invokeinterface 1230 1 0
    //   524: ifeq -75 -> 449
    //   527: aload 11
    //   529: invokeinterface 1233 1 0
    //   534: checkcast 1235	bcvs
    //   537: astore 12
    //   539: aload_2
    //   540: invokestatic 306	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   543: ifne -26 -> 517
    //   546: aload 12
    //   548: aload_2
    //   549: putfield 1238	bcvs:X	Ljava/lang/String;
    //   552: goto -35 -> 517
    //   555: aload 14
    //   557: aload 13
    //   559: getfield 629	com/tencent/mobileqq/data/MessageForStructing:uniseq	J
    //   562: putfield 1008	com/tencent/mobileqq/structmsg/AbsStructMsg:uniseq	J
    //   565: aload 14
    //   567: aload 13
    //   569: getfield 626	com/tencent/mobileqq/data/MessageForStructing:frienduin	Ljava/lang/String;
    //   572: putfield 1247	com/tencent/mobileqq/structmsg/AbsStructMsg:uin	Ljava/lang/String;
    //   575: aload 14
    //   577: aload 13
    //   579: getfield 1250	com/tencent/mobileqq/data/MessageForStructing:istroop	I
    //   582: putfield 1253	com/tencent/mobileqq/structmsg/AbsStructMsg:uinType	I
    //   585: aload 14
    //   587: aload 13
    //   589: getfield 1256	com/tencent/mobileqq/data/MessageForStructing:selfuin	Ljava/lang/String;
    //   592: putfield 1259	com/tencent/mobileqq/structmsg/AbsStructMsg:currentAccountUin	Ljava/lang/String;
    //   595: aload 14
    //   597: aload 13
    //   599: getfield 1262	com/tencent/mobileqq/data/MessageForStructing:versionCode	I
    //   602: putfield 1265	com/tencent/mobileqq/structmsg/AbsStructMsg:messageVersion	I
    //   605: aload 15
    //   607: ldc_w 1266
    //   610: aload 13
    //   612: invokevirtual 1043	com/tencent/mobileqq/data/MessageForStructing:isSend	()Z
    //   615: invokevirtual 1212	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   618: aload 14
    //   620: getfield 1253	com/tencent/mobileqq/structmsg/AbsStructMsg:uinType	I
    //   623: sipush 1008
    //   626: if_icmpne +1389 -> 2015
    //   629: aload 14
    //   631: getstatic 1269	com/tencent/mobileqq/structmsg/AbsStructMsg:SOURCE_ACCOUNT_TYPE_PA	I
    //   634: putfield 1272	com/tencent/mobileqq/structmsg/AbsStructMsg:sourceAccoutType	I
    //   637: aload 15
    //   639: ldc_w 1274
    //   642: aload 14
    //   644: getfield 1272	com/tencent/mobileqq/structmsg/AbsStructMsg:sourceAccoutType	I
    //   647: invokevirtual 1277	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   650: aload 14
    //   652: getfield 297	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgServiceID	I
    //   655: bipush 21
    //   657: if_icmpne +16 -> 673
    //   660: aload 15
    //   662: ldc_w 1279
    //   665: aload 14
    //   667: getfield 297	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgServiceID	I
    //   670: invokevirtual 1277	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   673: ldc_w 711
    //   676: aload 14
    //   678: invokevirtual 1179	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   681: ifeq +36 -> 717
    //   684: aload 14
    //   686: checkcast 711	com/tencent/mobileqq/structmsg/StructMsgForImageShare
    //   689: astore_2
    //   690: aload_2
    //   691: aload 13
    //   693: getfield 1282	com/tencent/mobileqq/data/MessageForStructing:issend	I
    //   696: putfield 1285	com/tencent/mobileqq/structmsg/StructMsgForImageShare:mIsSend	I
    //   699: aload_2
    //   700: aload 13
    //   702: getfield 629	com/tencent/mobileqq/data/MessageForStructing:uniseq	J
    //   705: putfield 1288	com/tencent/mobileqq/structmsg/StructMsgForImageShare:mUniseq	J
    //   708: aload_2
    //   709: aload 13
    //   711: getfield 1291	com/tencent/mobileqq/data/MessageForStructing:msgtype	I
    //   714: putfield 1294	com/tencent/mobileqq/structmsg/StructMsgForImageShare:mMsgType	I
    //   717: aload 4
    //   719: iconst_0
    //   720: invokevirtual 1297	com/tencent/mobileqq/activity/aio/BaseChatItemLayout:setAddStatesFromChildren	(Z)V
    //   723: aload 4
    //   725: invokevirtual 1298	com/tencent/mobileqq/activity/aio/BaseChatItemLayout:getTag	()Ljava/lang/Object;
    //   728: astore_2
    //   729: aload_2
    //   730: ifnull +2142 -> 2872
    //   733: aload_2
    //   734: instanceof 152
    //   737: ifeq +2135 -> 2872
    //   740: aload_2
    //   741: checkcast 152	ahkc
    //   744: astore_2
    //   745: aload_2
    //   746: ifnonnull +2120 -> 2866
    //   749: aload_0
    //   750: invokevirtual 952	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:a	()Lahkc;
    //   753: astore 9
    //   755: aload 9
    //   757: aload_0
    //   758: getfield 124	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   761: putfield 1299	ahkc:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   764: aload 9
    //   766: getfield 165	ahkc:jdField_a_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   769: astore_2
    //   770: aload_2
    //   771: astore 11
    //   773: aload_2
    //   774: ifnonnull +16 -> 790
    //   777: aload_3
    //   778: checkcast 167	android/widget/RelativeLayout
    //   781: astore 11
    //   783: aload 9
    //   785: aload 11
    //   787: putfield 165	ahkc:jdField_a_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   790: aconst_null
    //   791: astore_2
    //   792: aload_3
    //   793: aload 9
    //   795: invokevirtual 1301	android/view/View:setTag	(Ljava/lang/Object;)V
    //   798: aload_1
    //   799: invokestatic 1303	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:d	(Lcom/tencent/mobileqq/data/ChatMessage;)Z
    //   802: ifeq +1252 -> 2054
    //   805: aload 9
    //   807: iconst_1
    //   808: putfield 1304	ahkc:jdField_a_of_type_Boolean	Z
    //   811: aload 14
    //   813: instanceof 75
    //   816: ifeq +1353 -> 2169
    //   819: aload 14
    //   821: getfield 1307	com/tencent/mobileqq/structmsg/AbsStructMsg:mSType	Ljava/lang/String;
    //   824: ifnull +16 -> 840
    //   827: aload 15
    //   829: ldc_w 1309
    //   832: aload 14
    //   834: getfield 1307	com/tencent/mobileqq/structmsg/AbsStructMsg:mSType	Ljava/lang/String;
    //   837: invokevirtual 1203	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   840: aload_1
    //   841: invokestatic 1312	com/tencent/mobileqq/transfile/StructLongMessageDownloadProcessor:b	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   844: ifne +10 -> 854
    //   847: aload_1
    //   848: invokestatic 1314	com/tencent/mobileqq/transfile/StructLongMessageDownloadProcessor:d	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   851: ifeq +22 -> 873
    //   854: aload 15
    //   856: ldc_w 1316
    //   859: aload 13
    //   861: ldc_w 1318
    //   864: invokevirtual 1319	com/tencent/mobileqq/data/MessageForStructing:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   867: invokestatic 1322	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   870: invokevirtual 1277	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   873: aload 14
    //   875: checkcast 75	com/tencent/mobileqq/structmsg/StructMsgForGeneralShare
    //   878: invokevirtual 1325	com/tencent/mobileqq/structmsg/StructMsgForGeneralShare:getLayoutStr	()Ljava/lang/String;
    //   881: astore 12
    //   883: aload 12
    //   885: astore_2
    //   886: aload_0
    //   887: aload 14
    //   889: getfield 297	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgServiceID	I
    //   892: invokevirtual 1327	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:a	(I)Z
    //   895: ifeq +27 -> 922
    //   898: new 236	java/lang/StringBuilder
    //   901: dup
    //   902: invokespecial 237	java/lang/StringBuilder:<init>	()V
    //   905: aload 12
    //   907: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   910: aload 13
    //   912: getfield 1282	com/tencent/mobileqq/data/MessageForStructing:issend	I
    //   915: invokevirtual 1033	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   918: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   921: astore_2
    //   922: aload_0
    //   923: getfield 124	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   926: ifnull +1937 -> 2863
    //   929: aload_0
    //   930: getfield 124	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   933: getfield 1020	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_Int	I
    //   936: sipush 1008
    //   939: if_icmpne +1924 -> 2863
    //   942: ldc_w 1329
    //   945: aload_0
    //   946: getfield 124	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   949: getfield 128	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   952: invokevirtual 691	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   955: ifeq +1908 -> 2863
    //   958: aload_0
    //   959: getfield 92	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   962: checkcast 112	com/tencent/mobileqq/app/BaseActivity
    //   965: getfield 1332	com/tencent/mobileqq/app/BaseActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   968: sipush 341
    //   971: invokevirtual 105	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   974: checkcast 1334	akmh
    //   977: invokevirtual 1335	akmh:a	()Z
    //   980: ifne +1883 -> 2863
    //   983: aload 15
    //   985: ldc_w 1337
    //   988: aload_1
    //   989: getfield 1339	com/tencent/mobileqq/data/ChatMessage:isShowQWalletPubAd	Z
    //   992: invokevirtual 1212	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   995: new 236	java/lang/StringBuilder
    //   998: dup
    //   999: invokespecial 237	java/lang/StringBuilder:<init>	()V
    //   1002: aload_2
    //   1003: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1006: aload_1
    //   1007: getfield 1339	com/tencent/mobileqq/data/ChatMessage:isShowQWalletPubAd	Z
    //   1010: invokevirtual 1038	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1013: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1016: astore 12
    //   1018: aload 12
    //   1020: astore_2
    //   1021: aload_2
    //   1022: astore 12
    //   1024: aconst_null
    //   1025: astore_2
    //   1026: aload 10
    //   1028: ifnull +15 -> 1043
    //   1031: aload 10
    //   1033: aload 12
    //   1035: aload_3
    //   1036: checkcast 1181	android/view/ViewGroup
    //   1039: invokevirtual 1344	ahkd:a	(Ljava/lang/String;Landroid/view/ViewGroup;)Landroid/view/View;
    //   1042: astore_2
    //   1043: aload_2
    //   1044: ifnull +1058 -> 2102
    //   1047: aload 14
    //   1049: getfield 297	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgServiceID	I
    //   1052: bipush 61
    //   1054: if_icmpne +1030 -> 2084
    //   1057: aload_0
    //   1058: getfield 92	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1061: aload_2
    //   1062: aload_3
    //   1063: invokevirtual 1345	android/view/View:getResources	()Landroid/content/res/Resources;
    //   1066: ldc_w 1346
    //   1069: invokevirtual 1348	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   1072: invokestatic 1352	com/tencent/mobileqq/structmsg/AbsStructMsg:getInCompatibleView	(Landroid/content/Context;Landroid/view/View;Ljava/lang/String;)Landroid/view/View;
    //   1075: astore_2
    //   1076: aload_3
    //   1077: aload 5
    //   1079: invokevirtual 1356	android/view/View:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   1082: aload_3
    //   1083: aload 5
    //   1085: invokevirtual 1360	android/view/View:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   1088: aload 14
    //   1090: instanceof 662
    //   1093: ifeq +1289 -> 2382
    //   1096: aload 14
    //   1098: checkcast 662	com/tencent/mobileqq/structmsg/AbsShareMsg
    //   1101: astore 5
    //   1103: aload 5
    //   1105: invokevirtual 1364	com/tencent/mobileqq/structmsg/AbsShareMsg:getOnClickListener	()Landroid/view/View$OnClickListener;
    //   1108: astore 10
    //   1110: aload_3
    //   1111: new 1366	ahkb
    //   1114: dup
    //   1115: aload_0
    //   1116: aload 5
    //   1118: aload 13
    //   1120: aload_1
    //   1121: aload_1
    //   1122: getfield 1369	com/tencent/mobileqq/data/ChatMessage:time	J
    //   1125: aload 10
    //   1127: invokespecial 1372	ahkb:<init>	(Lcom/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder;Lcom/tencent/mobileqq/structmsg/AbsShareMsg;Lcom/tencent/mobileqq/data/MessageForStructing;Lcom/tencent/mobileqq/data/ChatMessage;JLandroid/view/View$OnClickListener;)V
    //   1130: invokevirtual 1376	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   1133: ldc_w 711
    //   1136: aload 14
    //   1138: invokevirtual 1179	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   1141: ifeq +1152 -> 2293
    //   1144: aload_0
    //   1145: getfield 99	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1148: invokestatic 1381	afyj:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Lafyj;
    //   1151: aload 4
    //   1153: aload_0
    //   1154: invokevirtual 1384	afyj:a	(Landroid/view/View;Lafyl;)V
    //   1157: aload_0
    //   1158: aload 13
    //   1160: invokespecial 1386	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:b	(Lcom/tencent/mobileqq/data/MessageForStructing;)Z
    //   1163: ifeq +16 -> 1179
    //   1166: aload_0
    //   1167: getfield 99	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1170: invokestatic 1381	afyj:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Lafyj;
    //   1173: aload 4
    //   1175: aload_0
    //   1176: invokevirtual 1384	afyj:a	(Landroid/view/View;Lafyl;)V
    //   1179: aload 14
    //   1181: invokestatic 1390	txv:a	(Lcom/tencent/mobileqq/structmsg/AbsStructMsg;)Z
    //   1184: ifeq +1139 -> 2323
    //   1187: aload_3
    //   1188: aconst_null
    //   1189: invokevirtual 1376	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   1192: aload 14
    //   1194: getfield 297	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgServiceID	I
    //   1197: bipush 76
    //   1199: if_icmpeq +13 -> 1212
    //   1202: aload 14
    //   1204: getfield 297	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgServiceID	I
    //   1207: bipush 106
    //   1209: if_icmpne +28 -> 1237
    //   1212: aload_3
    //   1213: aconst_null
    //   1214: invokevirtual 1376	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   1217: aload 14
    //   1219: getfield 297	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgServiceID	I
    //   1222: bipush 106
    //   1224: if_icmpeq +13 -> 1237
    //   1227: aload_3
    //   1228: aconst_null
    //   1229: invokevirtual 1360	android/view/View:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   1232: aload_3
    //   1233: aconst_null
    //   1234: invokevirtual 1356	android/view/View:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   1237: aload 14
    //   1239: getfield 297	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgServiceID	I
    //   1242: bipush 79
    //   1244: if_icmpne +22 -> 1266
    //   1247: aload_3
    //   1248: aconst_null
    //   1249: invokevirtual 1376	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   1252: aload_3
    //   1253: new 1392	ahjl
    //   1256: dup
    //   1257: aload_0
    //   1258: aload 5
    //   1260: invokespecial 1395	ahjl:<init>	(Lcom/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder;Lcom/tencent/mobileqq/structmsg/AbsShareMsg;)V
    //   1263: invokevirtual 1376	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   1266: aload 14
    //   1268: getfield 297	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgServiceID	I
    //   1271: bipush 81
    //   1273: if_icmpne +3 -> 1276
    //   1276: aload 11
    //   1278: aload_2
    //   1279: invokevirtual 274	android/widget/RelativeLayout:addView	(Landroid/view/View;)V
    //   1282: aload 14
    //   1284: getfield 297	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgServiceID	I
    //   1287: bipush 38
    //   1289: if_icmpne +128 -> 1417
    //   1292: aload_0
    //   1293: getfield 99	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1296: bipush 76
    //   1298: invokevirtual 105	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1301: checkcast 107	bhkg
    //   1304: astore_2
    //   1305: aload_2
    //   1306: ifnull +111 -> 1417
    //   1309: aload_2
    //   1310: aload_1
    //   1311: getfield 1369	com/tencent/mobileqq/data/ChatMessage:time	J
    //   1314: invokevirtual 1398	bhkg:b	(J)Z
    //   1317: ifeq +1145 -> 2462
    //   1320: new 1400	android/widget/ProgressBar
    //   1323: dup
    //   1324: aload_0
    //   1325: getfield 92	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1328: invokespecial 1401	android/widget/ProgressBar:<init>	(Landroid/content/Context;)V
    //   1331: astore_2
    //   1332: aload_2
    //   1333: ldc_w 1402
    //   1336: invokevirtual 1403	android/widget/ProgressBar:setId	(I)V
    //   1339: aload_2
    //   1340: aload_0
    //   1341: getfield 92	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1344: invokevirtual 48	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1347: ldc_w 1404
    //   1350: invokevirtual 1407	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   1353: invokevirtual 1410	android/widget/ProgressBar:setIndeterminateDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   1356: ldc_w 1411
    //   1359: aload_0
    //   1360: getfield 92	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1363: invokevirtual 48	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1366: invokestatic 203	afur:a	(FLandroid/content/res/Resources;)I
    //   1369: istore 6
    //   1371: new 194	android/widget/RelativeLayout$LayoutParams
    //   1374: dup
    //   1375: bipush 254
    //   1377: bipush 254
    //   1379: invokespecial 197	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   1382: pop
    //   1383: new 194	android/widget/RelativeLayout$LayoutParams
    //   1386: dup
    //   1387: iload 6
    //   1389: iload 6
    //   1391: invokespecial 197	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   1394: astore 5
    //   1396: aload 5
    //   1398: bipush 13
    //   1400: ldc 210
    //   1402: invokevirtual 213	android/widget/RelativeLayout$LayoutParams:addRule	(II)V
    //   1405: aload 11
    //   1407: aload_2
    //   1408: aload 5
    //   1410: invokevirtual 285	android/widget/RelativeLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   1413: aload_0
    //   1414: invokevirtual 1413	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:e	()V
    //   1417: aload 14
    //   1419: instanceof 711
    //   1422: ifeq +1070 -> 2492
    //   1425: aload 13
    //   1427: invokevirtual 889	com/tencent/mobileqq/data/MessageForStructing:isSendFromLocal	()Z
    //   1430: ifeq +38 -> 1468
    //   1433: aload_0
    //   1434: getfield 99	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1437: invokevirtual 1416	com/tencent/mobileqq/app/QQAppInterface:a	()Lbdzi;
    //   1440: aload 13
    //   1442: getfield 626	com/tencent/mobileqq/data/MessageForStructing:frienduin	Ljava/lang/String;
    //   1445: aload 13
    //   1447: getfield 629	com/tencent/mobileqq/data/MessageForStructing:uniseq	J
    //   1450: invokevirtual 1421	bdzi:a	(Ljava/lang/String;J)Lbguz;
    //   1453: astore_2
    //   1454: aload 9
    //   1456: aload 11
    //   1458: putfield 165	ahkc:jdField_a_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   1461: aload_0
    //   1462: aload_2
    //   1463: aload 9
    //   1465: invokespecial 1423	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:a	(Lbguz;Lahkc;)V
    //   1468: aload 14
    //   1470: checkcast 711	com/tencent/mobileqq/structmsg/StructMsgForImageShare
    //   1473: invokevirtual 906	com/tencent/mobileqq/structmsg/StructMsgForImageShare:getFirstImageElement	()Lbcxy;
    //   1476: astore_2
    //   1477: aload_2
    //   1478: ifnull +41 -> 1519
    //   1481: aload_2
    //   1482: getfield 1426	bcxy:jdField_a_of_type_ComTencentMobileqqDataMessageForPic	Lcom/tencent/mobileqq/data/MessageForPic;
    //   1485: ifnull +34 -> 1519
    //   1488: aload_0
    //   1489: getfield 99	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1492: invokevirtual 1429	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/pic/PicPreDownloader;
    //   1495: aload_2
    //   1496: getfield 1426	bcxy:jdField_a_of_type_ComTencentMobileqqDataMessageForPic	Lcom/tencent/mobileqq/data/MessageForPic;
    //   1499: iconst_2
    //   1500: invokevirtual 1434	com/tencent/mobileqq/pic/PicPreDownloader:a	(Lcom/tencent/mobileqq/data/MessageForPic;I)V
    //   1503: invokestatic 1437	com/tencent/mobileqq/app/ThreadManager:getFileThreadHandler	()Lmqq/os/MqqHandler;
    //   1506: new 1439	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder$12
    //   1509: dup
    //   1510: aload_0
    //   1511: aload_2
    //   1512: invokespecial 1442	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder$12:<init>	(Lcom/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder;Lbcxy;)V
    //   1515: invokevirtual 828	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   1518: pop
    //   1519: aload_0
    //   1520: aload 14
    //   1522: checkcast 711	com/tencent/mobileqq/structmsg/StructMsgForImageShare
    //   1525: invokespecial 1444	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:a	(Lcom/tencent/mobileqq/structmsg/StructMsgForImageShare;)V
    //   1528: aload 14
    //   1530: getfield 1447	com/tencent/mobileqq/structmsg/AbsStructMsg:adverSign	I
    //   1533: iconst_1
    //   1534: if_icmpne +986 -> 2520
    //   1537: new 167	android/widget/RelativeLayout
    //   1540: dup
    //   1541: aload_0
    //   1542: getfield 92	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1545: invokespecial 180	android/widget/RelativeLayout:<init>	(Landroid/content/Context;)V
    //   1548: astore_2
    //   1549: new 368	android/widget/ImageView
    //   1552: dup
    //   1553: aload_0
    //   1554: getfield 92	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1557: invokespecial 1448	android/widget/ImageView:<init>	(Landroid/content/Context;)V
    //   1560: astore 5
    //   1562: aload 5
    //   1564: ldc_w 1449
    //   1567: invokevirtual 372	android/widget/ImageView:setImageResource	(I)V
    //   1570: aload_2
    //   1571: iconst_0
    //   1572: invokevirtual 1452	android/widget/RelativeLayout:setBackgroundColor	(I)V
    //   1575: new 194	android/widget/RelativeLayout$LayoutParams
    //   1578: dup
    //   1579: ldc_w 1453
    //   1582: aload_0
    //   1583: getfield 92	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1586: invokevirtual 48	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1589: invokestatic 203	afur:a	(FLandroid/content/res/Resources;)I
    //   1592: ldc_w 1156
    //   1595: aload_0
    //   1596: getfield 92	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1599: invokevirtual 48	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1602: invokestatic 203	afur:a	(FLandroid/content/res/Resources;)I
    //   1605: invokespecial 197	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   1608: astore 10
    //   1610: aload 10
    //   1612: bipush 11
    //   1614: invokevirtual 1455	android/widget/RelativeLayout$LayoutParams:addRule	(I)V
    //   1617: aload 10
    //   1619: bipush 10
    //   1621: invokevirtual 1455	android/widget/RelativeLayout$LayoutParams:addRule	(I)V
    //   1624: aload_2
    //   1625: aload 10
    //   1627: invokevirtual 218	android/widget/RelativeLayout:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   1630: new 194	android/widget/RelativeLayout$LayoutParams
    //   1633: dup
    //   1634: bipush 254
    //   1636: bipush 254
    //   1638: invokespecial 197	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   1641: astore 10
    //   1643: aload 10
    //   1645: bipush 11
    //   1647: invokevirtual 1455	android/widget/RelativeLayout$LayoutParams:addRule	(I)V
    //   1650: aload 10
    //   1652: bipush 10
    //   1654: invokevirtual 1455	android/widget/RelativeLayout$LayoutParams:addRule	(I)V
    //   1657: aload 10
    //   1659: iconst_0
    //   1660: bipush 12
    //   1662: bipush 12
    //   1664: iconst_0
    //   1665: invokevirtual 993	android/widget/RelativeLayout$LayoutParams:setMargins	(IIII)V
    //   1668: aload 5
    //   1670: aload 10
    //   1672: invokevirtual 1456	android/widget/ImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   1675: aload_2
    //   1676: aload 5
    //   1678: invokevirtual 274	android/widget/RelativeLayout:addView	(Landroid/view/View;)V
    //   1681: aload_3
    //   1682: instanceof 167
    //   1685: ifeq +11 -> 1696
    //   1688: aload_3
    //   1689: checkcast 167	android/widget/RelativeLayout
    //   1692: aload_2
    //   1693: invokevirtual 274	android/widget/RelativeLayout:addView	(Landroid/view/View;)V
    //   1696: aload 13
    //   1698: getfield 626	com/tencent/mobileqq/data/MessageForStructing:frienduin	Ljava/lang/String;
    //   1701: astore 10
    //   1703: aload 14
    //   1705: getfield 1459	com/tencent/mobileqq/structmsg/AbsStructMsg:msgId	J
    //   1708: lstore 7
    //   1710: aload_0
    //   1711: getfield 92	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1714: instanceof 394
    //   1717: ifeq +22 -> 1739
    //   1720: aload_2
    //   1721: new 1461	ahjm
    //   1724: dup
    //   1725: aload_0
    //   1726: aload 5
    //   1728: aload_1
    //   1729: aload 10
    //   1731: lload 7
    //   1733: invokespecial 1464	ahjm:<init>	(Lcom/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder;Landroid/widget/ImageView;Lcom/tencent/mobileqq/data/ChatMessage;Ljava/lang/String;J)V
    //   1736: invokevirtual 1465	android/widget/RelativeLayout:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   1739: aload_0
    //   1740: getfield 511	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_Bkni	Lbkni;
    //   1743: ifnull +20 -> 1763
    //   1746: aload_0
    //   1747: getfield 511	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_Bkni	Lbkni;
    //   1750: invokevirtual 1468	bkni:isShowing	()Z
    //   1753: ifeq +10 -> 1763
    //   1756: aload_0
    //   1757: getfield 511	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_Bkni	Lbkni;
    //   1760: invokevirtual 521	bkni:dismiss	()V
    //   1763: aload 4
    //   1765: ifnull +192 -> 1957
    //   1768: aload 13
    //   1770: invokestatic 1472	axbp:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   1773: ifne +184 -> 1957
    //   1776: aload 4
    //   1778: ldc_w 1473
    //   1781: invokevirtual 1474	com/tencent/mobileqq/activity/aio/BaseChatItemLayout:findViewById	(I)Landroid/view/View;
    //   1784: checkcast 1476	com/tencent/mobileqq/doutu/DuiButtonImageView
    //   1787: astore_2
    //   1788: aload_2
    //   1789: ifnonnull +988 -> 2777
    //   1792: new 1476	com/tencent/mobileqq/doutu/DuiButtonImageView
    //   1795: dup
    //   1796: aload_0
    //   1797: getfield 92	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1800: aload_0
    //   1801: getfield 99	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1804: aload_1
    //   1805: invokespecial 1479	com/tencent/mobileqq/doutu/DuiButtonImageView:<init>	(Landroid/content/Context;Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/ChatMessage;)V
    //   1808: astore_2
    //   1809: new 194	android/widget/RelativeLayout$LayoutParams
    //   1812: dup
    //   1813: ldc_w 1480
    //   1816: aload_0
    //   1817: getfield 92	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1820: invokevirtual 48	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1823: invokestatic 203	afur:a	(FLandroid/content/res/Resources;)I
    //   1826: ldc_w 1480
    //   1829: aload_0
    //   1830: getfield 92	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1833: invokevirtual 48	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1836: invokestatic 203	afur:a	(FLandroid/content/res/Resources;)I
    //   1839: invokespecial 197	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   1842: astore 5
    //   1844: aload 5
    //   1846: bipush 8
    //   1848: ldc 210
    //   1850: invokevirtual 213	android/widget/RelativeLayout$LayoutParams:addRule	(II)V
    //   1853: aload 5
    //   1855: iconst_1
    //   1856: ldc 210
    //   1858: invokevirtual 213	android/widget/RelativeLayout$LayoutParams:addRule	(II)V
    //   1861: aload 5
    //   1863: getstatic 1173	com/tencent/mobileqq/activity/aio/BaseChatItemLayout:i	I
    //   1866: ldc_w 1481
    //   1869: aload_0
    //   1870: getfield 92	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1873: invokevirtual 48	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1876: invokestatic 203	afur:a	(FLandroid/content/res/Resources;)I
    //   1879: isub
    //   1880: putfield 1133	android/widget/RelativeLayout$LayoutParams:bottomMargin	I
    //   1883: aload_2
    //   1884: ldc_w 1473
    //   1887: invokevirtual 1482	com/tencent/mobileqq/doutu/DuiButtonImageView:setId	(I)V
    //   1890: aload 4
    //   1892: aload_2
    //   1893: aload 5
    //   1895: invokevirtual 1483	com/tencent/mobileqq/activity/aio/BaseChatItemLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   1898: aload_1
    //   1899: getfield 1484	com/tencent/mobileqq/data/ChatMessage:extraflag	I
    //   1902: ldc_w 1485
    //   1905: if_icmpne +10 -> 1915
    //   1908: aload_1
    //   1909: invokevirtual 1486	com/tencent/mobileqq/data/ChatMessage:isSendFromLocal	()Z
    //   1912: ifne +17 -> 1929
    //   1915: aload_0
    //   1916: getfield 99	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1919: invokevirtual 1489	com/tencent/mobileqq/app/QQAppInterface:a	()Lbbyp;
    //   1922: aload_1
    //   1923: invokevirtual 1493	bbyp:c	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   1926: ifeq +859 -> 2785
    //   1929: iconst_1
    //   1930: istore 6
    //   1932: aload_1
    //   1933: getfield 1496	com/tencent/mobileqq/data/ChatMessage:isDui	Z
    //   1936: ifeq +910 -> 2846
    //   1939: iload 6
    //   1941: ifne +905 -> 2846
    //   1944: aload_1
    //   1945: invokevirtual 1497	com/tencent/mobileqq/data/ChatMessage:isSend	()Z
    //   1948: ifeq +843 -> 2791
    //   1951: aload_2
    //   1952: bipush 8
    //   1954: invokevirtual 1498	com/tencent/mobileqq/doutu/DuiButtonImageView:setVisibility	(I)V
    //   1957: aload_0
    //   1958: getfield 124	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   1961: getfield 1020	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_Int	I
    //   1964: sipush 1008
    //   1967: if_icmpne -1791 -> 176
    //   1970: aload_0
    //   1971: getfield 1501	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   1974: aload_1
    //   1975: getfield 1094	com/tencent/mobileqq/data/ChatMessage:uniseq	J
    //   1978: invokestatic 709	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1981: invokevirtual 1504	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   1984: ifne -1808 -> 176
    //   1987: aload_0
    //   1988: getfield 1501	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   1991: aload_1
    //   1992: getfield 1094	com/tencent/mobileqq/data/ChatMessage:uniseq	J
    //   1995: invokestatic 709	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1998: invokevirtual 1505	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   2001: pop
    //   2002: bipush 117
    //   2004: aload_1
    //   2005: aload 9
    //   2007: getfield 1001	ahkc:jdField_b_of_type_Int	I
    //   2010: invokestatic 1510	aoqq:a	(ILcom/tencent/mobileqq/data/ChatMessage;I)V
    //   2013: aload_3
    //   2014: areturn
    //   2015: aload 13
    //   2017: ldc_w 1274
    //   2020: invokevirtual 1319	com/tencent/mobileqq/data/MessageForStructing:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   2023: astore_2
    //   2024: aload_2
    //   2025: ifnull -1388 -> 637
    //   2028: aload_2
    //   2029: ldc_w 489
    //   2032: invokevirtual 691	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2035: ifne -1398 -> 637
    //   2038: aload 14
    //   2040: aload_2
    //   2041: invokestatic 1322	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   2044: putfield 1272	com/tencent/mobileqq/structmsg/AbsStructMsg:sourceAccoutType	I
    //   2047: goto -1410 -> 637
    //   2050: astore_2
    //   2051: goto -1414 -> 637
    //   2054: aload 9
    //   2056: iconst_0
    //   2057: putfield 1304	ahkc:jdField_a_of_type_Boolean	Z
    //   2060: goto -1249 -> 811
    //   2063: astore 12
    //   2065: ldc_w 779
    //   2068: iconst_1
    //   2069: aload 12
    //   2071: iconst_0
    //   2072: anewarray 254	java/lang/Object
    //   2075: invokestatic 1513	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   2078: aload_2
    //   2079: astore 12
    //   2081: goto -1057 -> 1024
    //   2084: aload 14
    //   2086: aload_0
    //   2087: getfield 92	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2090: aload_2
    //   2091: aload 5
    //   2093: aload 15
    //   2095: invokevirtual 1517	com/tencent/mobileqq/structmsg/AbsStructMsg:getView	(Landroid/content/Context;Landroid/view/View;Lafzq;Landroid/os/Bundle;)Landroid/view/View;
    //   2098: astore_2
    //   2099: goto -1023 -> 1076
    //   2102: aload 14
    //   2104: getfield 297	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgServiceID	I
    //   2107: bipush 61
    //   2109: if_icmpne +42 -> 2151
    //   2112: aload_0
    //   2113: getfield 92	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2116: aconst_null
    //   2117: aload_3
    //   2118: invokevirtual 1345	android/view/View:getResources	()Landroid/content/res/Resources;
    //   2121: ldc_w 1346
    //   2124: invokevirtual 1348	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   2127: invokestatic 1352	com/tencent/mobileqq/structmsg/AbsStructMsg:getInCompatibleView	(Landroid/content/Context;Landroid/view/View;Ljava/lang/String;)Landroid/view/View;
    //   2130: astore_2
    //   2131: aload 10
    //   2133: ifnull +15 -> 2148
    //   2136: aload 10
    //   2138: aload 12
    //   2140: aload_2
    //   2141: aload_3
    //   2142: checkcast 1181	android/view/ViewGroup
    //   2145: invokevirtual 1520	ahkd:a	(Ljava/lang/String;Landroid/view/View;Landroid/view/ViewGroup;)V
    //   2148: goto -1072 -> 1076
    //   2151: aload 14
    //   2153: aload_0
    //   2154: getfield 92	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2157: aconst_null
    //   2158: aload 5
    //   2160: aload 15
    //   2162: invokevirtual 1517	com/tencent/mobileqq/structmsg/AbsStructMsg:getView	(Landroid/content/Context;Landroid/view/View;Lafzq;Landroid/os/Bundle;)Landroid/view/View;
    //   2165: astore_2
    //   2166: goto -35 -> 2131
    //   2169: aload 11
    //   2171: invokevirtual 1523	android/widget/RelativeLayout:getChildCount	()I
    //   2174: ifle +83 -> 2257
    //   2177: aload 11
    //   2179: iconst_0
    //   2180: invokevirtual 222	android/widget/RelativeLayout:getChildAt	(I)Landroid/view/View;
    //   2183: astore 10
    //   2185: aload 10
    //   2187: astore_2
    //   2188: aload 10
    //   2190: ifnull +67 -> 2257
    //   2193: aload 10
    //   2195: ldc 223
    //   2197: invokevirtual 227	android/view/View:getTag	(I)Ljava/lang/Object;
    //   2200: astore 12
    //   2202: invokestatic 232	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2205: ifeq +29 -> 2234
    //   2208: ldc 234
    //   2210: iconst_2
    //   2211: new 236	java/lang/StringBuilder
    //   2214: dup
    //   2215: invokespecial 237	java/lang/StringBuilder:<init>	()V
    //   2218: ldc 239
    //   2220: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2223: aload 12
    //   2225: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2228: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2231: invokestatic 252	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2234: aload 12
    //   2236: ifnull +19 -> 2255
    //   2239: aload 10
    //   2241: astore_2
    //   2242: aload 12
    //   2244: invokevirtual 258	java/lang/Object:getClass	()Ljava/lang/Class;
    //   2247: aload 14
    //   2249: invokevirtual 258	java/lang/Object:getClass	()Ljava/lang/Class;
    //   2252: if_acmpeq +5 -> 2257
    //   2255: aconst_null
    //   2256: astore_2
    //   2257: aload 11
    //   2259: invokevirtual 261	android/widget/RelativeLayout:removeAllViews	()V
    //   2262: aload_0
    //   2263: aload_1
    //   2264: invokespecial 1183	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:c	(Lcom/tencent/mobileqq/data/ChatMessage;)Z
    //   2267: ifeq +21 -> 2288
    //   2270: aload 14
    //   2272: aload_0
    //   2273: getfield 92	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2276: aload_2
    //   2277: aload 5
    //   2279: aload 15
    //   2281: invokevirtual 1517	com/tencent/mobileqq/structmsg/AbsStructMsg:getView	(Landroid/content/Context;Landroid/view/View;Lafzq;Landroid/os/Bundle;)Landroid/view/View;
    //   2284: astore_2
    //   2285: goto -1209 -> 1076
    //   2288: aconst_null
    //   2289: astore_2
    //   2290: goto -20 -> 2270
    //   2293: ldc 75
    //   2295: aload 14
    //   2297: invokevirtual 1179	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   2300: ifeq -1143 -> 1157
    //   2303: aload_0
    //   2304: aload 14
    //   2306: invokespecial 1524	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:a	(Lcom/tencent/mobileqq/structmsg/AbsStructMsg;)Z
    //   2309: ifeq -1152 -> 1157
    //   2312: aload_0
    //   2313: aload 4
    //   2315: aload 13
    //   2317: invokespecial 1526	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:a	(Lcom/tencent/mobileqq/activity/aio/BaseChatItemLayout;Lcom/tencent/mobileqq/data/MessageForStructing;)V
    //   2320: goto -1163 -> 1157
    //   2323: aload 14
    //   2325: getfield 297	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgServiceID	I
    //   2328: bipush 78
    //   2330: if_icmpne -1138 -> 1192
    //   2333: aload_0
    //   2334: getfield 92	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2337: checkcast 1141	android/support/v4/app/FragmentActivity
    //   2340: invokevirtual 1145	android/support/v4/app/FragmentActivity:getChatFragment	()Lcom/tencent/mobileqq/activity/ChatFragment;
    //   2343: invokevirtual 1150	com/tencent/mobileqq/activity/ChatFragment:a	()Lcom/tencent/mobileqq/activity/BaseChatPie;
    //   2346: astore 10
    //   2348: aload 14
    //   2350: checkcast 662	com/tencent/mobileqq/structmsg/AbsShareMsg
    //   2353: astore 12
    //   2355: aload 10
    //   2357: instanceof 1528
    //   2360: ifeq -1168 -> 1192
    //   2363: aload_3
    //   2364: new 1530	ahjk
    //   2367: dup
    //   2368: aload_0
    //   2369: aload 10
    //   2371: aload 12
    //   2373: invokespecial 1533	ahjk:<init>	(Lcom/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder;Lcom/tencent/mobileqq/activity/BaseChatPie;Lcom/tencent/mobileqq/structmsg/AbsShareMsg;)V
    //   2376: invokevirtual 1376	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   2379: goto -1187 -> 1192
    //   2382: aload 14
    //   2384: getfield 297	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgServiceID	I
    //   2387: iconst_3
    //   2388: if_icmpeq +13 -> 2401
    //   2391: aload 14
    //   2393: getfield 297	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgServiceID	I
    //   2396: bipush 120
    //   2398: if_icmpne -1122 -> 1276
    //   2401: aload_0
    //   2402: invokevirtual 1534	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:a	()Z
    //   2405: ifeq +11 -> 2416
    //   2408: aload_3
    //   2409: iconst_0
    //   2410: invokevirtual 1535	android/view/View:setClickable	(Z)V
    //   2413: goto -1137 -> 1276
    //   2416: aload_3
    //   2417: iconst_1
    //   2418: invokevirtual 1535	android/view/View:setClickable	(Z)V
    //   2421: goto -1145 -> 1276
    //   2424: astore 5
    //   2426: aload_2
    //   2427: invokevirtual 1539	android/view/View:getParent	()Landroid/view/ViewParent;
    //   2430: astore 5
    //   2432: aload 5
    //   2434: ifnull +19 -> 2453
    //   2437: aload 5
    //   2439: instanceof 1181
    //   2442: ifeq +11 -> 2453
    //   2445: aload 5
    //   2447: checkcast 1181	android/view/ViewGroup
    //   2450: invokevirtual 1184	android/view/ViewGroup:removeAllViews	()V
    //   2453: aload 11
    //   2455: aload_2
    //   2456: invokevirtual 274	android/widget/RelativeLayout:addView	(Landroid/view/View;)V
    //   2459: goto -1177 -> 1282
    //   2462: aload_0
    //   2463: getfield 124	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   2466: getfield 1020	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_Int	I
    //   2469: ifne -1052 -> 1417
    //   2472: aload_2
    //   2473: invokevirtual 110	bhkg:a	()Lbhkf;
    //   2476: astore_2
    //   2477: aload_2
    //   2478: ifnull -1061 -> 1417
    //   2481: aload_0
    //   2482: aload_2
    //   2483: getfield 140	bhkf:a	J
    //   2486: invokespecial 1540	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:a	(J)V
    //   2489: goto -1072 -> 1417
    //   2492: aload 14
    //   2494: instanceof 75
    //   2497: ifne +11 -> 2508
    //   2500: aload 14
    //   2502: instanceof 1542
    //   2505: ifeq -977 -> 1528
    //   2508: aload_0
    //   2509: aload 14
    //   2511: checkcast 662	com/tencent/mobileqq/structmsg/AbsShareMsg
    //   2514: invokespecial 1544	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:a	(Lcom/tencent/mobileqq/structmsg/AbsShareMsg;)V
    //   2517: goto -989 -> 1528
    //   2520: aload 14
    //   2522: getfield 1447	com/tencent/mobileqq/structmsg/AbsStructMsg:adverSign	I
    //   2525: iconst_2
    //   2526: if_icmpne -787 -> 1739
    //   2529: new 167	android/widget/RelativeLayout
    //   2532: dup
    //   2533: aload_0
    //   2534: getfield 92	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2537: invokespecial 180	android/widget/RelativeLayout:<init>	(Landroid/content/Context;)V
    //   2540: astore_2
    //   2541: new 375	android/widget/TextView
    //   2544: dup
    //   2545: aload_0
    //   2546: getfield 92	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2549: invokespecial 1545	android/widget/TextView:<init>	(Landroid/content/Context;)V
    //   2552: astore 5
    //   2554: aload 5
    //   2556: ldc_w 1546
    //   2559: invokevirtual 1547	android/widget/TextView:setBackgroundResource	(I)V
    //   2562: aload 5
    //   2564: bipush 17
    //   2566: invokevirtual 1548	android/widget/TextView:setGravity	(I)V
    //   2569: aload 14
    //   2571: getfield 1447	com/tencent/mobileqq/structmsg/AbsStructMsg:adverSign	I
    //   2574: istore 6
    //   2576: aload 5
    //   2578: ldc_w 1549
    //   2581: invokestatic 380	anni:a	(I)Ljava/lang/String;
    //   2584: invokevirtual 384	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   2587: aload 5
    //   2589: iconst_m1
    //   2590: invokevirtual 1550	android/widget/TextView:setTextColor	(I)V
    //   2593: aload 5
    //   2595: ldc_w 1551
    //   2598: invokevirtual 1554	android/widget/TextView:setTextSize	(F)V
    //   2601: aload_2
    //   2602: iconst_0
    //   2603: invokevirtual 1452	android/widget/RelativeLayout:setBackgroundColor	(I)V
    //   2606: new 194	android/widget/RelativeLayout$LayoutParams
    //   2609: dup
    //   2610: ldc_w 1453
    //   2613: aload_0
    //   2614: getfield 92	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2617: invokevirtual 48	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   2620: invokestatic 203	afur:a	(FLandroid/content/res/Resources;)I
    //   2623: ldc_w 1156
    //   2626: aload_0
    //   2627: getfield 92	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2630: invokevirtual 48	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   2633: invokestatic 203	afur:a	(FLandroid/content/res/Resources;)I
    //   2636: invokespecial 197	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   2639: astore 10
    //   2641: aload 10
    //   2643: bipush 11
    //   2645: invokevirtual 1455	android/widget/RelativeLayout$LayoutParams:addRule	(I)V
    //   2648: aload 10
    //   2650: bipush 10
    //   2652: invokevirtual 1455	android/widget/RelativeLayout$LayoutParams:addRule	(I)V
    //   2655: aload_2
    //   2656: aload 10
    //   2658: invokevirtual 218	android/widget/RelativeLayout:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   2661: new 194	android/widget/RelativeLayout$LayoutParams
    //   2664: dup
    //   2665: bipush 254
    //   2667: bipush 254
    //   2669: invokespecial 197	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   2672: astore 10
    //   2674: aload 10
    //   2676: bipush 11
    //   2678: invokevirtual 1455	android/widget/RelativeLayout$LayoutParams:addRule	(I)V
    //   2681: aload 10
    //   2683: bipush 10
    //   2685: invokevirtual 1455	android/widget/RelativeLayout$LayoutParams:addRule	(I)V
    //   2688: aload 5
    //   2690: aload 10
    //   2692: invokevirtual 1555	android/widget/TextView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   2695: aload_2
    //   2696: aload 5
    //   2698: invokevirtual 274	android/widget/RelativeLayout:addView	(Landroid/view/View;)V
    //   2701: aload_3
    //   2702: instanceof 167
    //   2705: ifeq +11 -> 2716
    //   2708: aload_3
    //   2709: checkcast 167	android/widget/RelativeLayout
    //   2712: aload_2
    //   2713: invokevirtual 274	android/widget/RelativeLayout:addView	(Landroid/view/View;)V
    //   2716: aload 13
    //   2718: getfield 626	com/tencent/mobileqq/data/MessageForStructing:frienduin	Ljava/lang/String;
    //   2721: astore 10
    //   2723: aload 14
    //   2725: getfield 1459	com/tencent/mobileqq/structmsg/AbsStructMsg:msgId	J
    //   2728: lstore 7
    //   2730: aload 13
    //   2732: ldc_w 1214
    //   2735: invokevirtual 1319	com/tencent/mobileqq/data/MessageForStructing:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   2738: astore 10
    //   2740: aload 13
    //   2742: getfield 1250	com/tencent/mobileqq/data/MessageForStructing:istroop	I
    //   2745: istore 6
    //   2747: aload_0
    //   2748: getfield 92	com/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2751: instanceof 394
    //   2754: ifeq -1015 -> 1739
    //   2757: aload_2
    //   2758: new 1557	ahjn
    //   2761: dup
    //   2762: aload_0
    //   2763: aload 5
    //   2765: aload_1
    //   2766: aload 10
    //   2768: invokespecial 1560	ahjn:<init>	(Lcom/tencent/mobileqq/activity/aio/item/StructingMsgItemBuilder;Landroid/widget/TextView;Lcom/tencent/mobileqq/data/ChatMessage;Ljava/lang/String;)V
    //   2771: invokevirtual 1465	android/widget/RelativeLayout:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   2774: goto -1035 -> 1739
    //   2777: aload_2
    //   2778: aload_1
    //   2779: putfield 1561	com/tencent/mobileqq/doutu/DuiButtonImageView:jdField_a_of_type_ComTencentMobileqqDataChatMessage	Lcom/tencent/mobileqq/data/ChatMessage;
    //   2782: goto -884 -> 1898
    //   2785: iconst_0
    //   2786: istore 6
    //   2788: goto -856 -> 1932
    //   2791: aload_1
    //   2792: getfield 1564	com/tencent/mobileqq/data/ChatMessage:hasPlayedDui	Z
    //   2795: ifne +30 -> 2825
    //   2798: aload_1
    //   2799: aload_2
    //   2800: invokestatic 1567	com/tencent/mobileqq/doutu/DuiButtonImageView:a	(Lcom/tencent/mobileqq/doutu/DuiButtonImageView;)Z
    //   2803: putfield 1564	com/tencent/mobileqq/data/ChatMessage:hasPlayedDui	Z
    //   2806: getstatic 1568	com/tencent/mobileqq/doutu/DuiButtonImageView:jdField_a_of_type_Boolean	Z
    //   2809: ifeq +23 -> 2832
    //   2812: aload_2
    //   2813: aload_0
    //   2814: invokevirtual 1569	com/tencent/mobileqq/doutu/DuiButtonImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   2817: aload_2
    //   2818: iconst_0
    //   2819: invokevirtual 1498	com/tencent/mobileqq/doutu/DuiButtonImageView:setVisibility	(I)V
    //   2822: goto -865 -> 1957
    //   2825: aload_2
    //   2826: invokevirtual 1571	com/tencent/mobileqq/doutu/DuiButtonImageView:f	()V
    //   2829: goto -23 -> 2806
    //   2832: aload_2
    //   2833: aconst_null
    //   2834: invokevirtual 1569	com/tencent/mobileqq/doutu/DuiButtonImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   2837: aload_2
    //   2838: bipush 8
    //   2840: invokevirtual 1498	com/tencent/mobileqq/doutu/DuiButtonImageView:setVisibility	(I)V
    //   2843: goto -886 -> 1957
    //   2846: aload_2
    //   2847: bipush 8
    //   2849: invokevirtual 1498	com/tencent/mobileqq/doutu/DuiButtonImageView:setVisibility	(I)V
    //   2852: aload_2
    //   2853: invokevirtual 1572	com/tencent/mobileqq/doutu/DuiButtonImageView:e	()V
    //   2856: goto -899 -> 1957
    //   2859: astore_2
    //   2860: goto -1987 -> 873
    //   2863: goto -1842 -> 1021
    //   2866: aload_2
    //   2867: astore 9
    //   2869: goto -2114 -> 755
    //   2872: aconst_null
    //   2873: astore_2
    //   2874: goto -2129 -> 745
    //   2877: aconst_null
    //   2878: astore 10
    //   2880: goto -2833 -> 47
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2883	0	this	StructingMsgItemBuilder
    //   0	2883	1	paramChatMessage	ChatMessage
    //   0	2883	2	paramafwr	afwr
    //   0	2883	3	paramView	View
    //   0	2883	4	paramBaseChatItemLayout	BaseChatItemLayout
    //   0	2883	5	paramafzq	afzq
    //   139	2648	6	i	int
    //   1708	1021	7	l	long
    //   58	2810	9	localObject1	Object
    //   45	2834	10	localObject2	Object
    //   129	2325	11	localObject3	Object
    //   537	497	12	localObject4	Object
    //   2063	7	12	localThrowable	java.lang.Throwable
    //   2079	293	12	localObject5	Object
    //   215	2526	13	localMessageForStructing	MessageForStructing
    //   222	2502	14	localAbsStructMsg	AbsStructMsg
    //   7	2273	15	localBundle	Bundle
    // Exception table:
    //   from	to	target	type
    //   2038	2047	2050	java/lang/Exception
    //   922	1018	2063	java/lang/Throwable
    //   1276	1282	2424	java/lang/IllegalStateException
    //   854	873	2859	java/lang/Exception
  }
  
  public bguh a(bguh parambguh, ChatMessage paramChatMessage, afxj paramafxj)
  {
    paramafxj = (MessageForStructing)paramChatMessage;
    paramChatMessage = paramafxj.structingMsg;
    if (paramChatMessage != null) {
      if ((!(paramChatMessage instanceof AbsShareMsg)) || (!((AbsShareMsg)paramChatMessage).mMsgException)) {}
    }
    label369:
    label375:
    label379:
    for (;;)
    {
      return parambguh;
      if ((paramChatMessage.mMsgServiceID != 86) && (paramChatMessage.mMsgServiceID != 61) && (paramChatMessage.mMsgServiceID != 91) && (paramChatMessage.mMsgServiceID != 97) && (paramChatMessage.mMsgServiceID != 98) && (!(paramChatMessage instanceof StructMsgForHypertext)) && ((!paramafxj.isSendFromLocal()) || (!(paramChatMessage instanceof AbsShareMsg)) || (!((AbsShareMsg)paramChatMessage).isSdkShareMsg()) || ((paramafxj.extraflag != 32772) && (paramafxj.extraflag != 32768))))
      {
        paramafxj = this.jdField_a_of_type_AndroidContentContext.getResources();
        int i;
        if (paramChatMessage.fwFlag != 1) {
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008) {
            if (!paramChatMessage.hasFlag(32))
            {
              parambguh.a(2131367049, paramafxj.getString(2131692395), 2130838929);
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
          if ((i == 0) && (!a(paramChatMessage, parambguh))) {
            break label379;
          }
          parambguh.a(2131366271, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131691986), 2130838928);
          return parambguh;
          if (paramChatMessage.hasFlag(1)) {
            break;
          }
          parambguh.a(2131367027, paramafxj.getString(2131692395), 2130838929);
          break;
          if (paramChatMessage.mMsgServiceID == 14) {
            break;
          }
          if (!paramChatMessage.hasFlag(1))
          {
            parambguh.a(2131367027, paramafxj.getString(2131692395), 2130838929);
            break;
          }
          if (paramChatMessage.mMsgServiceID != 35) {
            break;
          }
          parambguh.a(2131367027, paramafxj.getString(2131692395), 2130838929);
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
    if (bgnr.a(paramChatMessage.issend)) {
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
    Object localObject6 = ahte.a(paramChatMessage);
    Object localObject1;
    if (paramInt == 2131362186) {
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
        localObject1 = bdzx.a(paramChatMessage, 1);
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
                  ahth.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (URLDrawable)localObject1, paramChatMessage.frienduin, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298998), paramContext, null);
                } while (!ahte.a((String)localObject6));
                blaq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "3009", "2", "40053", ahte.b((String)localObject6), new String[] { "1", "", ahte.a((String)localObject6) });
                return;
                if (paramInt != 2131367027) {
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
          if ((localObject2 != null) && (((bcxy)localObject2).a()))
          {
            paramContext.putExtra("key_forward_image_share", true);
            paramContext.putExtra("key_forward_image_share_appid", Long.toString(((StructMsgForImageShare)localObject1).mSourceAppid));
            paramContext.putExtra("key_forward_image_share_uin_type", ((StructMsgForImageShare)localObject1).uinType);
          }
          aufz.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramContext, 21);
          paramContext = paramChatMessage.structingMsg.mMsgUrl;
          localObject1 = paramChatMessage.senderuin;
          localObject2 = Long.toString(paramChatMessage.structingMsg.msgId);
          bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005455", "0X8005455", 0, 0, (String)localObject1, paramContext, (String)localObject2, "");
          bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
          if (paramChatMessage.structingMsg.mMsgServiceID == 84) {
            bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8007166", "0X8007166", 0, 0, "", "", "", "");
          }
          if (ahte.a((String)localObject6)) {
            blaq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "3009", "2", "40053", ahte.b((String)localObject6), new String[] { "2", "", ahte.a((String)localObject6) });
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
          bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D66", "0X8009D66", paramInt, 0, "" + paramInt, "", "", "");
          return;
          if ((paramChatMessage.structingMsg != null) && (paramChatMessage.structingMsg.mMsgServiceID == 35))
          {
            bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006624", "0X8006624", 0, 1, 0, "", "", "", "");
            if (!awwm.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.uniseq))
            {
              paramInt = paramContext.getResources().getDimensionPixelSize(2131298998);
              QQToast.a(paramContext, anni.a(2131713280), 0).b(paramInt);
              return;
            }
            if (!awwm.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.uniseq)) {
              break;
            }
            bglp.a(paramContext, 230, null, "选择的消息中，部分图片\\表情等内容可能无法正常转发，是否继续转发？", anni.a(2131713272), anni.a(2131713282), new ahjj(this, paramChatMessage), new ahjr(this)).show();
            return;
          }
          if ((paramChatMessage.structingMsg == null) || (paramChatMessage.structingMsg.mMsgServiceID != 81)) {
            break;
          }
          yqu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramChatMessage, "forward");
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
        if (paramInt != 2131365308) {
          break;
        }
        adrm.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
        if (ahte.a((String)localObject6)) {
          blaq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "3009", "2", "40053", ahte.b((String)localObject6), new String[] { "5", "", ahte.a((String)localObject6) });
        }
      } while ((paramChatMessage == null) || (!(paramChatMessage instanceof MessageForStructing)));
      paramContext = (MessageForStructing)paramChatMessage;
    } while ((paramContext.structingMsg == null) || (paramContext.structingMsg.mMsgServiceID != 81));
    yqu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramContext, "delete");
    return;
    long l2;
    long l1;
    if (paramInt == 2131371422)
    {
      super.d(paramChatMessage);
      if (ahte.a((String)localObject6)) {
        blaq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "3009", "2", "40053", ahte.b((String)localObject6), new String[] { "6", "", ahte.a((String)localObject6) });
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
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X80064F7", "0X80064F7", 0, 0, paramContext, String.valueOf(l2), String.valueOf(paramInt), "");
      if ((paramChatMessage == null) || (!(paramChatMessage instanceof MessageForStructing))) {
        break;
      }
      paramContext = (MessageForStructing)paramChatMessage;
      if ((paramContext.structingMsg == null) || (paramContext.structingMsg.mMsgServiceID != 81)) {
        break;
      }
      yqu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramContext, "more");
      return;
      MessageForStructing localMessageForStructing;
      AbsShareMsg localAbsShareMsg;
      if (paramInt == 2131366271)
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
          if (ahte.a((String)localObject6))
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
            if (((bcxy)localObject2).jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare == null) {
              ((bcxy)localObject2).jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare = ((StructMsgForImageShare)localAbsShareMsg);
            }
            localObject5 = ahth.a(((bcxy)localObject2).a());
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
            Object localObject7 = localObject1[3] + anni.a(2131713271) + localObject1[5] + anni.a(2131713277);
            localObject5 = "ADTAG=comic.plugin.read&id=" + localObject1[0] + "&name=" + URLEncoder.encode(localObject1[1]) + "&sectionID=" + localObject1[2] + "&sectionName=" + URLEncoder.encode(localObject1[3]) + "&pageID=" + localObject1[4] + "&page=" + localObject1[5] + "&type=" + localObject1[6];
            localObject4 = localObject5;
            if (!TextUtils.isEmpty(paramContext)) {
              localObject4 = (String)localObject5 + "&scrawl_link=" + URLEncoder.encode(paramContext);
            }
            paramContext = VipComicJumpActivity.a("comicReadShare", "5123", null, null, "354", null, (String)localObject4);
            new bljl(6).a("nLinkType", 0).b("sTitle", localObject1[1]).b("sUrl", paramContext).a("bAppShare", false).a("lAppId", 0L).b("sPublisher", localAbsShareMsg.mSourceName).b("sBrief", (String)localObject7).b("sPath", (String)localObject2).b("sResUrl", localAbsShareMsg.mSourceUrl).a("lCategory", 1L).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
            bljv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 2);
            bljv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 8, 0, localAbsShareMsg.uinType);
            blaq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "3009", "2", "40053", ahte.b((String)localObject6), new String[] { "3", "", ahte.a((String)localObject6) });
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
                  paramContext = bljz.a((StructMsgForImageShare)localAbsShareMsg);
                  if (paramContext != null)
                  {
                    bljl.a(paramContext.ac, localAbsShareMsg.uinType, paramContext.ab, paramContext.c, paramContext.aa, paramContext.d).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
                    bljv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2, 0, localAbsShareMsg.uinType);
                    bljv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 3);
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
                  bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D67", "0X8009D67", paramInt, 0, "" + paramInt, "", "", "");
                  return;
                  paramInt = 0;
                  break label1715;
                  if (!ahte.b((String)localObject6)) {
                    break label4331;
                  }
                  paramContext = ahte.b((String)localObject6);
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
                    localObject4 = ahth.a(paramContext.a());
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
                  bljl.a((String)localObject2).c(paramContext).a((Activity)this.jdField_a_of_type_AndroidContentContext, paramContext);
                  bljv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 7, 0, localAbsShareMsg.uinType);
                  bljv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 2);
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
                    ((agmg)paramContext.a(11)).a(paramContext, null, (MessageForStructing)paramChatMessage);
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
                  bljl.a(Float.valueOf(paramContext).floatValue(), Float.valueOf((String)localObject1).floatValue(), (String)localObject4, (String)localObject2, null).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
                  bljv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 11, 0, localAbsShareMsg.uinType);
                  bljv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 7);
                  return;
                }
              }
              localObject4 = bljz.a(localAbsShareMsg.getXmlBytes());
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
                    bljl.a(null, false, localAbsShareMsg.mContentTitle, localAbsShareMsg.mContentSummary, false, 0L, "").b("sBizDataList", paramContext).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
                    bljv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 10, 0, localAbsShareMsg.uinType);
                    bljv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, i);
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
                    if ((localObject1 instanceof bczn))
                    {
                      localObject5 = ((bczn)localObject1).a.iterator();
                      localObject1 = paramContext;
                      if (!((Iterator)localObject5).hasNext()) {
                        break label4317;
                      }
                      localObject1 = (bcvs)((Iterator)localObject5).next();
                      if (!(localObject1 instanceof bdaz)) {
                        continue;
                      }
                      localObject5 = (bdaz)localObject1;
                      paramContext = ((bdaz)localObject5).aa;
                      localObject1 = paramContext;
                      if (!((bdaz)localObject5).a()) {
                        break label4317;
                      }
                      och.a("0X8006601", ((StructMsgForGeneralShare)localAbsShareMsg).uinType, och.a(((bdaz)localObject5).v, ((StructMsgForGeneralShare)localObject2).mSourceName), ((bdaz)localObject5).ac, "");
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
                    localObject3 = bglf.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), true);
                    localObject1 = localObject3;
                    if (TextUtils.isEmpty((CharSequence)localObject3)) {
                      localObject1 = localAbsShareMsg.mContentSrc;
                    }
                    bljl.a(paramInt, localAbsShareMsg.mContentTitle, localAbsShareMsg.mMsgUrl, localAbsShareMsg.mSourceName, localAbsShareMsg.mContentSummary, paramContext, (String)localObject1, (byte[])localObject4, false, 0L).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a("lCategory", 10L).b("sUin", localAbsShareMsg.mSourceName).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
                    bljv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 8, 0, localAbsShareMsg.uinType);
                  }
                  else
                  {
                    localObject6 = new ArrayList();
                    localObject5 = localAbsShareMsg.mContentSummary;
                    if (a(localAbsShareMsg))
                    {
                      ((ArrayList)localObject6).add(bljn.a(true));
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
                      bljv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 10, 0, localAbsShareMsg.uinType);
                    }
                    for (;;)
                    {
                      bljl.a(j, localAbsShareMsg.mContentTitle, localAbsShareMsg.mMsgUrl, localAbsShareMsg.mSourceName, (String)localObject1, paramContext, localAbsShareMsg.mContentSrc, (byte[])localObject3, false, 0L).b("sBizDataList", (ArrayList)localObject6).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
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
                      localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131697341) + (String)localObject7;
                      localObject3 = null;
                      j = paramInt;
                      break label3746;
                      if (bdjg.a(localAbsShareMsg.mMsgUrl)) {
                        bljv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 12, 0, localAbsShareMsg.uinType);
                      } else {
                        bljv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 8, 0, localAbsShareMsg.uinType);
                      }
                    }
                    paramInt = 2;
                    break label2451;
                    paramInt = 7;
                    break label2451;
                    if (paramInt == 2131365147)
                    {
                      paramContext = (MessageForStructing)paramChatMessage;
                      if ((paramContext == null) || (paramContext.structingMsg == null) || (!"web".equals(paramContext.structingMsg.mMsgAction)) || (paramContext.structingMsg.mMsgUrl == null)) {
                        break;
                      }
                      ((ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(paramContext.structingMsg.mMsgUrl);
                      return;
                    }
                    if (paramInt == 2131371411)
                    {
                      d(paramChatMessage);
                      return;
                    }
                    if (paramInt == 2131367049)
                    {
                      ThreadManager.post(new StructingMsgItemBuilder.4(this, paramChatMessage, paramContext), 8, null, false);
                      return;
                    }
                    if (paramInt == 2131371380)
                    {
                      super.a(paramChatMessage);
                      if (ahte.a((String)localObject6)) {
                        blaq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "3009", "2", "40053", ahte.b((String)localObject6), new String[] { "4", "", ahte.a((String)localObject6) });
                      }
                      if ((paramChatMessage == null) || (!(paramChatMessage instanceof MessageForStructing))) {
                        break;
                      }
                      paramContext = (MessageForStructing)paramChatMessage;
                      if ((paramContext.structingMsg == null) || (paramContext.structingMsg.mMsgServiceID != 81)) {
                        break;
                      }
                      yqu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramContext, "withdraw");
                      return;
                    }
                    if (paramInt == 2131364126)
                    {
                      paramContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramChatMessage.frienduin, paramChatMessage.uniseq);
                      if ((paramContext == null) || (!(paramContext instanceof bdsx))) {
                        break;
                      }
                      ((bdsx)paramContext).a();
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
    if (afur.a(paramView).isMultiMsg) {}
    Object localObject2;
    ChatMessage localChatMessage;
    String str1;
    do
    {
      do
      {
        return;
        localObject1 = afur.a(paramView);
      } while (!ahkc.class.isInstance(localObject1));
      localObject2 = this.jdField_a_of_type_AndroidContentContext;
      localChatMessage = ((ahkc)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      localObject1 = a(localChatMessage);
      if (localObject1 != null)
      {
        a(paramView, (StructMsgForGeneralShare)localObject1);
        return;
      }
      paramView = ((Context)localObject2).getString(2131689926);
      str1 = ((Context)localObject2).getString(2131689927);
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
        paramView = anni.a(2131713274);
        localObject2 = anni.a(2131713275);
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label282;
        }
      }
    }
    for (;;)
    {
      localObject2 = (bkho)bkif.a(this.jdField_a_of_type_AndroidContentContext, null);
      ((bkho)localObject2).c(paramView);
      ((bkho)localObject2).d(this.jdField_a_of_type_AndroidContentContext.getString(2131690582));
      ((bkho)localObject2).a((CharSequence)localObject1);
      ((bkho)localObject2).a(new ahjx(this, bool, localChatMessage, (bkho)localObject2));
      ((bkho)localObject2).show();
      return;
      paramView = anni.a(2131713276);
      break;
      bglp.a((Context)localObject2, 230, paramView, str1, new ahjy(this, localChatMessage, (Context)localObject2), new ahjz(this)).show();
      return;
      label282:
      localObject1 = localObject2;
    }
  }
  
  public void a(View paramView, bduk parambduk, int paramInt1, int paramInt2)
  {
    if (!BaseChatItemLayout.class.isInstance(paramView)) {}
    do
    {
      return;
      if ((parambduk.jdField_b_of_type_Int == 1) || (parambduk.jdField_b_of_type_Int == 131075))
      {
        b(paramView, parambduk, paramInt1, paramInt2);
        return;
      }
    } while (parambduk.jdField_b_of_type_Int != 52);
    c(paramView, parambduk, paramInt1, paramInt2);
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    super.a(paramView, paramChatMessage);
    MessageForStructing localMessageForStructing;
    int i;
    if ((paramChatMessage instanceof MessageForStructing))
    {
      localMessageForStructing = (MessageForStructing)paramChatMessage;
      boolean bool = txv.a(localMessageForStructing.structingMsg);
      if (((bool) && (!localMessageForStructing.structingMsg.hasFlag(4))) || (localMessageForStructing.structingMsg.mMsgServiceID == 83) || (localMessageForStructing.structingMsg.mMsgServiceID == 108) || (localMessageForStructing.structingMsg.mMsgServiceID == 151) || (localMessageForStructing.structingMsg.mMsgServiceID == 156))
      {
        if ((!bool) || (localMessageForStructing.structingMsg.hasFlag(4))) {
          break label201;
        }
        i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296331);
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
        paramView.setPadding(afur.a(1.5F, paramChatMessage), afur.a(2.0F, paramChatMessage), afur.a(1.5F, paramChatMessage), paramView.getPaddingBottom());
      }
      return;
      label201:
      if ((localMessageForStructing.structingMsg.mMsgServiceID == 114) || (localMessageForStructing.structingMsg.mMsgServiceID == 116))
      {
        i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296332);
        break;
      }
      i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296336);
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
      if (((localObject instanceof ahkc)) && ((paramChatMessage instanceof MessageForStructing)))
      {
        localObject = (ahkc)localObject;
        BaseChatItemLayout localBaseChatItemLayout = ((ahkc)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
        paramChatMessage = (MessageForStructing)paramChatMessage;
        AbsStructMsg localAbsStructMsg = paramChatMessage.structingMsg;
        if (localAbsStructMsg != null) {
          localAbsStructMsg.message = paramChatMessage;
        }
        a((ahkc)localObject, localBaseChatItemLayout, paramChatMessage.isSend(), localAbsStructMsg, paramView.getResources(), a(paramChatMessage));
      }
      return;
    }
    super.a(paramView, paramChatMessage, paramInt);
  }
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, afwr paramafwr, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramafwr, paramInt1, paramInt2);
    if ((!(paramChatMessage instanceof MessageForStructing)) || (((MessageForStructing)paramChatMessage).structingMsg == null)) {}
    do
    {
      return;
      paramBaseChatItemLayout = (MessageForStructing)paramChatMessage;
      paramInt1 = paramBaseChatItemLayout.structingMsg.mMsgServiceID;
    } while ((a(paramBaseChatItemLayout)) || (paramInt1 == 83) || (paramInt1 == 151) || (paramInt1 == 156) || (paramInt1 == 108) || (paramInt1 == 114) || (paramInt1 == 98) || (paramInt1 == 97) || (paramInt1 == 5) || (paramInt1 == 137) || (paramInt1 == 106) || (paramInt1 == 107) || (paramInt1 == 122) || (paramInt1 == 116));
    paramInt2 = paramafwr.jdField_a_of_type_AndroidViewView.getPaddingLeft();
    int i = paramafwr.jdField_a_of_type_AndroidViewView.getPaddingRight();
    int m = paramafwr.jdField_a_of_type_AndroidViewView.getPaddingTop();
    int n = paramafwr.jdField_a_of_type_AndroidViewView.getPaddingBottom();
    int j = afur.a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    boolean bool = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    int k;
    if (paramChatMessage.isSend())
    {
      paramInt1 = paramInt2;
      if (paramInt2 > j) {
        paramInt1 = paramInt2 - j;
      }
      paramafwr.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130849995);
      j = paramInt1;
      k = i;
      if (bool)
      {
        j = paramInt1;
        k = i;
        if (paramafwr.jdField_a_of_type_AndroidViewView.getParent() != null)
        {
          j = paramInt1;
          k = i;
          if ((paramafwr.jdField_a_of_type_AndroidViewView.getParent() instanceof RelativeLayout))
          {
            paramBaseChatItemLayout = (RelativeLayout)paramafwr.jdField_a_of_type_AndroidViewView.getParent();
            paramContext = new View(paramContext);
            localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
            localLayoutParams.addRule(6, 2131364379);
            localLayoutParams.addRule(5, 2131364379);
            localLayoutParams.addRule(7, 2131364379);
            localLayoutParams.addRule(8, 2131364379);
            if (paramafwr.jdField_b_of_type_AndroidViewView != null) {
              paramBaseChatItemLayout.removeView(paramafwr.jdField_b_of_type_AndroidViewView);
            }
            if (!awwt.a(paramChatMessage)) {
              break label440;
            }
            paramContext.setBackgroundResource(2130849992);
            paramafwr.jdField_b_of_type_AndroidViewView = paramContext;
            paramBaseChatItemLayout.addView(paramafwr.jdField_b_of_type_AndroidViewView, localLayoutParams);
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
          paramafwr.jdField_a_of_type_AndroidViewView.setPadding(j, m, k, n);
          return;
          paramContext.setBackgroundResource(2130849991);
          break;
          paramInt1 = i;
          if (i > j) {
            paramInt1 = i - j;
          }
          paramafwr.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130849819);
          j = paramInt2;
          k = paramInt1;
        } while (!bool);
        j = paramInt2;
        k = paramInt1;
      } while (paramafwr.jdField_a_of_type_AndroidViewView.getParent() == null);
      j = paramInt2;
      k = paramInt1;
    } while (!(paramafwr.jdField_a_of_type_AndroidViewView.getParent() instanceof RelativeLayout));
    paramBaseChatItemLayout = (RelativeLayout)paramafwr.jdField_a_of_type_AndroidViewView.getParent();
    paramContext = new View(paramContext);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(6, 2131364379);
    localLayoutParams.addRule(5, 2131364379);
    localLayoutParams.addRule(7, 2131364379);
    localLayoutParams.addRule(8, 2131364379);
    if (paramafwr.jdField_b_of_type_AndroidViewView != null) {
      paramBaseChatItemLayout.removeView(paramafwr.jdField_b_of_type_AndroidViewView);
    }
    if (awwt.a(paramChatMessage)) {
      paramContext.setBackgroundResource(2130849816);
    }
    for (;;)
    {
      paramafwr.jdField_b_of_type_AndroidViewView = paramContext;
      paramBaseChatItemLayout.addView(paramafwr.jdField_b_of_type_AndroidViewView, localLayoutParams);
      j = paramInt2;
      k = paramInt1;
      break;
      paramContext.setBackgroundResource(2130849815);
    }
  }
  
  public void a(MessageForStructing paramMessageForStructing) {}
  
  public void a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage, long paramLong, float paramFloat) {}
  
  public void a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage, boolean paramBoolean)
  {
    paramXListView = afur.a(paramView);
    if ((paramXListView instanceof ahkc)) {}
    for (paramXListView = (ahkc)paramXListView;; paramXListView = null)
    {
      if (paramXListView != null)
      {
        paramXListView = (ViewGroup)paramXListView.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
        int i = paramXListView.getChildCount();
        paramInt = 0;
        while (paramInt < i)
        {
          if ((paramXListView.getChildAt(paramInt).getTag() instanceof bcyb))
          {
            paramView = (bcyb)paramXListView.getChildAt(paramInt).getTag();
            if ((paramView.jdField_a_of_type_AndroidViewView.getTag() instanceof bdaj))
            {
              paramView = (ImageView)((bdaj)paramView.jdField_a_of_type_AndroidViewView.getTag()).c;
              paramView.clearAnimation();
              paramView.setBackgroundResource(2130841775);
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
  
  public boolean a(afwr paramafwr)
  {
    return paramafwr instanceof ahkc;
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
      paramString2 = bcwd.a(paramString1.getExtras());
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
        if ((localObject == null) || (((bcxy)localObject).d > 0L)) {
          break;
        }
        paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramChatMessage.frienduin, paramChatMessage.uniseq);
        if ((paramChatMessage instanceof bdsx))
        {
          if (((bdsx)paramChatMessage).c() == 1005L) {}
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
      if (tzo.b(paramAbsShareMsg.mMsgUrl)) {
        return true;
      }
    } while (((TextUtils.isEmpty(paramAbsShareMsg.mSource_A_ActionData)) || (!paramAbsShareMsg.mSource_A_ActionData.contains("pubaccount"))) && ((TextUtils.isEmpty(paramAbsShareMsg.mSource_I_ActionData)) || (!paramAbsShareMsg.mSource_I_ActionData.contains("public_account"))));
    return true;
  }
  
  public boolean a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage)
  {
    paramXListView = afur.a(paramView);
    if ((paramXListView instanceof ahkc)) {}
    for (paramXListView = (ahkc)paramXListView;; paramXListView = null)
    {
      if (paramXListView != null)
      {
        paramXListView = (ViewGroup)paramXListView.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
        int i = paramXListView.getChildCount();
        paramInt = 0;
        while (paramInt < i)
        {
          if ((paramXListView.getChildAt(paramInt).getTag() instanceof bcyb))
          {
            paramView = (bcyb)paramXListView.getChildAt(paramInt).getTag();
            if ((paramView.jdField_a_of_type_AndroidViewView.getTag() instanceof bdaj)) {
              return bgmg.b(((bdaj)paramView.jdField_a_of_type_AndroidViewView.getTag()).jdField_a_of_type_JavaLangString);
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
    Object localObject = afur.a(paramView);
    if ((localObject instanceof ahkc)) {}
    for (localObject = (ahkc)localObject;; localObject = null)
    {
      if (localObject != null)
      {
        localObject = (ViewGroup)((ahkc)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
        int i = ((ViewGroup)localObject).getChildCount();
        paramInt2 = 0;
        while (paramInt2 < i)
        {
          if (((((ViewGroup)localObject).getChildAt(paramInt2).getTag() instanceof bcyb)) && (a(paramXListView, paramInt1, paramView, paramChatMessage)))
          {
            bcyb localbcyb = (bcyb)((ViewGroup)localObject).getChildAt(paramInt2).getTag();
            if ((localbcyb.jdField_a_of_type_AndroidViewView.getTag() instanceof bdaj)) {
              paramAudioPlayerBase.a(((bdaj)localbcyb.jdField_a_of_type_AndroidViewView.getTag()).jdField_a_of_type_JavaLangString);
            }
          }
          paramInt2 += 1;
        }
        return true;
      }
      return false;
    }
  }
  
  public bguj[] a(View paramView)
  {
    paramView = (MessageForStructing)afur.a(paramView);
    bguh localbguh = new bguh();
    if (paramView != null)
    {
      if (!paramView.isMultiMsg) {
        break label40;
      }
      a(localbguh, paramView, null);
    }
    for (;;)
    {
      return localbguh.a();
      label40:
      b(localbguh, paramView, null);
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
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5A7", "0X800A5A7", 0, 0, "" + i, "", "", "");
      return;
    }
  }
  
  public bguh b(bguh parambguh, ChatMessage paramChatMessage, afxj paramafxj)
  {
    paramafxj = (MessageForStructing)paramChatMessage;
    AbsStructMsg localAbsStructMsg = paramafxj.structingMsg;
    if (localAbsStructMsg != null)
    {
      if (((localAbsStructMsg instanceof AbsShareMsg)) && (((AbsShareMsg)localAbsStructMsg).mMsgException))
      {
        adrm.a(parambguh, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008) {
          super.c(parambguh, this.jdField_a_of_type_AndroidContentContext);
        }
        super.e(parambguh, this.jdField_a_of_type_AndroidContentContext);
        return parambguh;
      }
      if (localAbsStructMsg.mMsgServiceID == 86)
      {
        adrm.a(parambguh, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        super.e(parambguh, this.jdField_a_of_type_AndroidContentContext);
        return parambguh;
      }
      if (localAbsStructMsg.mMsgServiceID == 61)
      {
        adrm.a(parambguh, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        super.e(parambguh, this.jdField_a_of_type_AndroidContentContext);
        return parambguh;
      }
      if (localAbsStructMsg.mMsgServiceID == 91)
      {
        adrm.a(parambguh, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        super.e(parambguh, this.jdField_a_of_type_AndroidContentContext);
        return parambguh;
      }
      if (localAbsStructMsg.mMsgServiceID == 97)
      {
        adrm.a(parambguh, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        super.e(parambguh, this.jdField_a_of_type_AndroidContentContext);
        return parambguh;
      }
      if (localAbsStructMsg.mMsgServiceID == 98)
      {
        adrm.a(parambguh, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        super.e(parambguh, this.jdField_a_of_type_AndroidContentContext);
        return parambguh;
      }
      if (localAbsStructMsg.mMsgServiceID == 128)
      {
        a(paramafxj, parambguh);
        adrm.a(parambguh, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        b(paramafxj, parambguh);
        bgjt.a("Grp_AIO", "invite", "send_in", 0, 0, new String[0]);
        return parambguh;
      }
      if ((localAbsStructMsg instanceof StructMsgForHypertext))
      {
        adrm.a(parambguh, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        super.c(parambguh, this.jdField_a_of_type_AndroidContentContext);
        super.e(parambguh, this.jdField_a_of_type_AndroidContentContext);
        return parambguh;
      }
      if ((paramafxj.isSendFromLocal()) && ((localAbsStructMsg instanceof AbsShareMsg)) && (((AbsShareMsg)localAbsStructMsg).isSdkShareMsg()) && ((paramafxj.extraflag == 32772) || (paramafxj.extraflag == 32768)))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramafxj.frienduin, paramafxj.uniseq) != null) {
          parambguh.a(2131364126, this.jdField_a_of_type_AndroidContentContext.getString(2131690640), 2130838918);
        }
        for (;;)
        {
          super.e(parambguh, this.jdField_a_of_type_AndroidContentContext);
          return parambguh;
          adrm.a(parambguh, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        }
      }
      if ((localAbsStructMsg instanceof StructMsgForImageShare))
      {
        bcxy localbcxy = ((StructMsgForImageShare)localAbsStructMsg).getFirstImageElement();
        if (localbcxy == null) {
          break label1483;
        }
        paramChatMessage = localbcxy.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
        if (paramChatMessage != null) {
          break label1480;
        }
        if (localbcxy.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare == null)
        {
          localbcxy.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare = ((StructMsgForImageShare)localAbsStructMsg);
          localbcxy.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.message = paramafxj;
        }
        localbcxy.a(this.jdField_a_of_type_AndroidContentContext, null, null);
        paramChatMessage = localbcxy.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
      }
    }
    for (;;)
    {
      int i;
      if ((paramChatMessage != null) && (bdzx.a(this.jdField_a_of_type_AndroidContentContext, paramChatMessage, 65537)))
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
        super.e(parambguh, this.jdField_a_of_type_AndroidContentContext);
        return parambguh;
        i = 0;
        break;
      }
      label629:
      parambguh.a(2131362186, this.jdField_a_of_type_AndroidContentContext.getString(2131692945), 2130838927);
      paramChatMessage = this.jdField_a_of_type_AndroidContentContext.getResources();
      if (localAbsStructMsg.fwFlag != 1)
      {
        if (localAbsStructMsg.hasFlag(8)) {
          parambguh.a(2131365147, paramChatMessage.getString(2131691139), 2130838921);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008) {
          if (!localAbsStructMsg.hasFlag(32))
          {
            parambguh.a(2131367049, paramChatMessage.getString(2131692395), 2130838929);
            a(paramafxj, parambguh);
            if (localAbsStructMsg.hasFlag(2)) {
              break label1468;
            }
            if (((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008) && (TextUtils.isEmpty(localAbsStructMsg.mMsgUrl))) || (localAbsStructMsg.mMsgServiceID == 81)) {
              break label1474;
            }
            if (localAbsStructMsg.mMsgServiceID != 14) {
              break label1456;
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
        label1456:
        label1468:
        for (i = 0;; i = 0)
        {
          if ((paramafxj.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramafxj)))
          {
            int k = 1;
            j = k;
            if (paramafxj.istroop == 1)
            {
              j = k;
              if (localAbsStructMsg != null)
              {
                if ((localAbsStructMsg.mMsgServiceID != 23) && (localAbsStructMsg.mMsgServiceID != 19) && (localAbsStructMsg.mMsgServiceID != 60) && (!anni.a(2131713281).equals(localAbsStructMsg.getSourceName())))
                {
                  j = k;
                  if (localAbsStructMsg.mMsgUrl == null) {
                    break label984;
                  }
                  if (!localAbsStructMsg.mMsgUrl.startsWith("http://qqweb.qq.com/m/qunactivity"))
                  {
                    j = k;
                    if (!localAbsStructMsg.mMsgUrl.startsWith("https://qqweb.qq.com/m/qunactivity")) {
                      break label984;
                    }
                  }
                }
                j = 0;
              }
            }
            label984:
            if (((1008 != paramafxj.istroop) || (!anhk.u.equals(paramafxj.frienduin))) && ((localAbsStructMsg == null) || (localAbsStructMsg.mMsgUrl == null) || (!localAbsStructMsg.mMsgUrl.startsWith("https://ti.qq.com/remind/view.html"))))
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
              a(parambguh, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramafxj);
            }
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1008) || (parambguh.a() == 0)) {
            a(parambguh, paramafxj);
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
          if ((j != 0) || (a(localAbsStructMsg, parambguh))) {
            parambguh.a(2131366271, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131691986), 2130838928);
          }
          super.a(parambguh, this.jdField_a_of_type_AndroidContentContext, paramafxj);
          if ((localAbsStructMsg != null) && (localAbsStructMsg.mMsgServiceID != 49) && (localAbsStructMsg.mMsgServiceID != 106) && (localAbsStructMsg.mMsgServiceID != 14)) {
            super.c(parambguh, this.jdField_a_of_type_AndroidContentContext);
          }
          if ((localAbsStructMsg != null) && (localAbsStructMsg.mMsgServiceID == 81)) {
            yqu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramafxj, "press");
          }
          super.e(parambguh, this.jdField_a_of_type_AndroidContentContext);
          b(paramafxj, parambguh);
          return parambguh;
          if (localAbsStructMsg.hasFlag(1)) {
            break;
          }
          parambguh.a(2131367027, paramChatMessage.getString(2131692395), 2130838929);
          break;
          if (localAbsStructMsg.mMsgServiceID == 14) {
            break;
          }
          if (!localAbsStructMsg.hasFlag(1))
          {
            parambguh.a(2131367027, paramChatMessage.getString(2131692395), 2130838929);
            break;
          }
          if (localAbsStructMsg.mMsgServiceID != 35) {
            break;
          }
          parambguh.a(2131367027, paramChatMessage.getString(2131692395), 2130838929);
          bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006625", "0X8006625", 0, 1, 0, "", "", "", "");
          break;
          j = 1;
          break label795;
          a(paramafxj, parambguh);
        }
        label1474:
        j = 0;
      }
      label1480:
      continue;
      label1483:
      paramChatMessage = null;
    }
  }
  
  protected void b(View paramView, bduk parambduk, int paramInt1, int paramInt2)
  {
    paramView = afur.a(paramView);
    if (!ahkc.class.isInstance(paramView)) {}
    ChatMessage localChatMessage;
    do
    {
      do
      {
        return;
        paramView = (ahkc)paramView;
      } while ((!ahkc.class.isInstance(paramView)) || (paramView.jdField_a_of_type_AndroidWidgetRelativeLayout == null) || (!MessageForStructing.class.isInstance(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage)));
      localChatMessage = paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if ((localChatMessage.uniseq == parambduk.jdField_b_of_type_Long) && (localChatMessage.isSendFromLocal()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("structMsg", 2, "handleMessage status = " + paramInt1 + ", retCode = " + paramInt2 + ", message.uniseq = " + localChatMessage.uniseq + ", file.uniseq = " + parambduk.jdField_b_of_type_Long);
        }
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localChatMessage.frienduin, localChatMessage.uniseq), paramView);
        if (paramInt1 == 1005) {
          b();
        }
      }
    } while ((localChatMessage.uniseq != parambduk.jdField_b_of_type_Long) || (paramInt1 != 2003) || (!(((MessageForStructing)localChatMessage).structingMsg instanceof StructMsgForImageShare)));
    paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
    parambduk = new Bundle();
    paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(((MessageForStructing)localChatMessage).structingMsg.getView(this.jdField_a_of_type_AndroidContentContext, null, null, parambduk));
  }
  
  public boolean b(ChatMessage paramChatMessage)
  {
    return true;
  }
  
  protected void c(View paramView, bduk parambduk, int paramInt1, int paramInt2)
  {
    paramView = afur.a(paramView);
    if (!ahkc.class.isInstance(paramView)) {}
    do
    {
      do
      {
        do
        {
          return;
          paramView = (ahkc)paramView;
        } while ((!ahkc.class.isInstance(paramView)) || (paramView.jdField_a_of_type_AndroidWidgetRelativeLayout == null) || (!MessageForStructing.class.isInstance(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage)));
        paramView = paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      } while ((paramView.uniseq != parambduk.jdField_b_of_type_Long) || (!paramView.isSendFromLocal()));
      if (QLog.isColorLevel()) {
        QLog.d("structMsg", 2, "handleMessage status = " + paramInt1 + ", retCode = " + paramInt2 + ", message.uniseq = " + paramView.uniseq + ", file.uniseq = " + parambduk.jdField_b_of_type_Long);
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
      if ((paramChatMessage != null) && (bdsx.class.isInstance(paramChatMessage)))
      {
        a(paramBaseChatItemLayout, ((bdsx)paramChatMessage).a(), 0, 0);
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
    bhkg localbhkg = (bhkg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(76);
    bhkf localbhkf = localbhkg.a();
    if ((localbhkf != null) && (localbhkf.d == 0L) && (localbhkf.a != 0L)) {
      localbhkg.a(localbhkf.a);
    }
    long l2;
    if ((localbhkf != null) && (localbhkf.d == 1L))
    {
      l2 = localbhkg.a - (NetConnInfoCenter.getServerTimeMillis() - localbhkf.e);
      if (l2 > 0L) {
        break label127;
      }
    }
    for (;;)
    {
      new Handler(this.jdField_a_of_type_AndroidContentContext.getMainLooper()).postDelayed(new StructingMsgItemBuilder.8(this, localbhkf, localbhkg), l1);
      return;
      label127:
      l1 = l2;
    }
  }
  
  public void onClick(View paramView)
  {
    BaseChatPie localBaseChatPie;
    StructMsgForImageShare localStructMsgForImageShare;
    bcxy localbcxy;
    if (paramView.getId() == 2131365738)
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
      localObject = (MessageForStructing)((ahkc)afur.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if ((localObject == null) || (((MessageForStructing)localObject).structingMsg == null) || (!(((MessageForStructing)localObject).structingMsg instanceof StructMsgForImageShare))) {
        break label218;
      }
      localStructMsgForImageShare = (StructMsgForImageShare)((MessageForStructing)localObject).structingMsg;
      localbcxy = localStructMsgForImageShare.getFirstImageElement();
      if (localbcxy == null) {
        break label218;
      }
    }
    label180:
    label199:
    label218:
    for (Object localObject = new arms(localbcxy.ab, localbcxy.ac, localbcxy.c, localStructMsgForImageShare.rawUrl, ((MessageForStructing)localObject).senderuin);; localObject = null)
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