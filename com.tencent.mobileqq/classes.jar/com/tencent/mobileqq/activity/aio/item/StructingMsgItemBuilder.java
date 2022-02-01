package com.tencent.mobileqq.activity.aio.item;

import aeze;
import aezf;
import aezk;
import aezy;
import afaz;
import afbb;
import afbz;
import afce;
import afuj;
import agpg;
import agph;
import agpi;
import agpj;
import agpk;
import agpl;
import agpn;
import agpo;
import agpp;
import agpq;
import agpr;
import agps;
import agpt;
import agpu;
import agpv;
import agpw;
import agpx;
import agpy;
import agqa;
import ahiu;
import ajvj;
import amtj;
import andf;
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
import anxs;
import aqwf;
import atyv;
import awct;
import awhm;
import awhn;
import ayeu;
import bbko;
import bblk;
import bcdb;
import bcef;
import bcgw;
import bcgx;
import bchd;
import bchh;
import bcip;
import bcjc;
import bcjf;
import bcjo;
import bckb;
import bclo;
import bfas;
import bftc;
import bfur;
import bfwr;
import bgaz;
import bgbb;
import bgrd;
import bgre;
import bjnw;
import bjon;
import bjsv;
import bjsy;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.AudioPlayerBase;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.customviews.MessageProgressTextView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForTroopNotification;
import com.tencent.mobileqq.data.ThumbWidthHeightDP;
import com.tencent.mobileqq.doutu.DuiButtonImageView;
import com.tencent.mobileqq.filemanager.util.FileUtil;
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
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.XListView;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import oge;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import uel;
import uem;
import ugf;
import xwa;

public class StructingMsgItemBuilder
  extends BaseBubbleBuilder
  implements aezk, afbb, afbz
{
  public static final int[] a;
  public static int c;
  private agqa jdField_a_of_type_Agqa;
  private bcip jdField_a_of_type_Bcip;
  bjsv jdField_a_of_type_Bjsv;
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
    this.jdField_a_of_type_Bcip = new bcip();
    this.jdField_a_of_type_Agqa = new agqa(this);
  }
  
  private int a(ChatMessage paramChatMessage, Context paramContext, aezf paramaezf, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4, int paramInt5)
  {
    int i = paramInt1;
    if (paramInt1 > paramInt2) {
      i = paramInt1 - paramInt2;
    }
    paramaezf.jdField_a_of_type_AndroidViewView.setBackgroundResource(paramInt3);
    RelativeLayout localRelativeLayout;
    RelativeLayout.LayoutParams localLayoutParams;
    if ((paramBoolean) && (paramaezf.jdField_a_of_type_AndroidViewView.getParent() != null) && ((paramaezf.jdField_a_of_type_AndroidViewView.getParent() instanceof RelativeLayout)))
    {
      localRelativeLayout = (RelativeLayout)paramaezf.jdField_a_of_type_AndroidViewView.getParent();
      paramContext = new View(paramContext);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(6, 2131364441);
      localLayoutParams.addRule(5, 2131364441);
      localLayoutParams.addRule(7, 2131364441);
      localLayoutParams.addRule(8, 2131364441);
      if (paramaezf.jdField_b_of_type_AndroidViewView != null) {
        localRelativeLayout.removeView(paramaezf.jdField_b_of_type_AndroidViewView);
      }
      if (!awct.a(paramChatMessage)) {
        break label172;
      }
      paramContext.setBackgroundResource(paramInt4);
    }
    for (;;)
    {
      paramaezf.jdField_b_of_type_AndroidViewView = paramContext;
      localRelativeLayout.addView(paramaezf.jdField_b_of_type_AndroidViewView, localLayoutParams);
      return i;
      label172:
      paramContext.setBackgroundResource(paramInt5);
    }
  }
  
  private View a(ChatMessage paramChatMessage, afce paramafce, Bundle paramBundle, AbsStructMsg paramAbsStructMsg, RelativeLayout paramRelativeLayout, View paramView)
  {
    if (paramRelativeLayout.getChildCount() > 0)
    {
      View localView = paramRelativeLayout.getChildAt(0);
      paramView = localView;
      if (localView != null)
      {
        Object localObject = localView.getTag(2131377871);
        if (QLog.isColorLevel()) {
          QLog.d("structMsg", 2, "bindviwfor structmsg tag:" + localObject);
        }
        if (localObject != null)
        {
          paramView = localView;
          if (localObject.getClass() == paramAbsStructMsg.getClass()) {}
        }
        else
        {
          paramView = null;
        }
      }
    }
    paramRelativeLayout.removeAllViews();
    if (c(paramChatMessage)) {}
    for (;;)
    {
      return paramAbsStructMsg.getView(this.jdField_a_of_type_AndroidContentContext, paramView, paramafce, paramBundle);
      paramView = null;
    }
  }
  
  private View a(ChatMessage paramChatMessage, ViewGroup paramViewGroup, afce paramafce, agpy paramagpy, Bundle paramBundle, MessageForStructing paramMessageForStructing, AbsStructMsg paramAbsStructMsg)
  {
    String str2 = ((StructMsgForGeneralShare)paramAbsStructMsg).getLayoutStr();
    String str1 = str2;
    if (a(paramAbsStructMsg.mMsgServiceID)) {
      str1 = str2 + paramMessageForStructing.issend;
    }
    paramMessageForStructing = a(paramChatMessage, paramBundle, str1);
    if (paramagpy != null) {}
    for (paramChatMessage = paramagpy.a(paramMessageForStructing, paramViewGroup);; paramChatMessage = null)
    {
      paramafce = paramAbsStructMsg.getView(this.jdField_a_of_type_AndroidContentContext, null, paramafce, paramBundle);
      if ((paramChatMessage == null) && (paramagpy != null)) {
        paramagpy.a(paramMessageForStructing, paramafce, paramViewGroup);
      }
      return paramafce;
    }
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
  
  private String a(ChatMessage paramChatMessage, Bundle paramBundle, String paramString)
  {
    String str = paramString;
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)
      {
        str = paramString;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1008)
        {
          str = paramString;
          if ("2711679534".equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin))
          {
            str = paramString;
            if (!((ajvj)((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app.getManager(341)).a())
            {
              paramBundle.putBoolean("isShowQWalletPubAd", paramChatMessage.isShowQWalletPubAd);
              str = paramString + paramChatMessage.isShowQWalletPubAd;
            }
          }
        }
      }
      return str;
    }
    catch (Throwable paramChatMessage)
    {
      QLog.e("StructingMsgItemBuilder", 1, paramChatMessage, new Object[0]);
    }
    return paramString;
  }
  
  private void a(int paramInt1, AbsStructMsg paramAbsStructMsg, int paramInt2, agpx paramagpx)
  {
    if (((paramInt1 == 1) || (paramInt2 != paramagpx.jdField_b_of_type_Int)) && (paramAbsStructMsg.mMsgServiceID == 128)) {
      bftc.a("Grp_AIO", "invite", "send_exp", 0, 0, new String[] { String.valueOf(paramAbsStructMsg.uniseq) });
    }
  }
  
  private void a(long paramLong)
  {
    if (((this.jdField_a_of_type_AndroidContentContext instanceof ChatActivity)) || ((this.jdField_a_of_type_AndroidContentContext instanceof SplashActivity)))
    {
      bgre localbgre = (bgre)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(76);
      bgrd localbgrd = localbgre.a();
      BaseActivity localBaseActivity = (BaseActivity)this.jdField_a_of_type_AndroidContentContext;
      if ((localbgrd != null) && (localBaseActivity.isResume()) && (localbgrd.b.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin)) && (localbgrd.d == 2L) && (paramLong == localbgrd.a)) {
        localbgre.a(localbgrd, localBaseActivity);
      }
    }
  }
  
  private void a(agpx paramagpx, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      paramagpx.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.a();
      return;
      paramagpx.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setProgress(0);
      return;
      paramagpx.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setProgress(0);
    }
  }
  
  private void a(agpx paramagpx, BaseChatItemLayout paramBaseChatItemLayout, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramBaseChatItemLayout.setHeadIconVisible(false);
      paramagpx.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130850605);
      int i = paramagpx.jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingLeft();
      int j = paramagpx.jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingLeft();
      paramagpx.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, i, 0, j);
      return;
    }
    paramBaseChatItemLayout.setHeadIconVisible(true);
  }
  
  private void a(agpx paramagpx, BaseChatItemLayout paramBaseChatItemLayout, boolean paramBoolean1, AbsStructMsg paramAbsStructMsg, Resources paramResources, boolean paramBoolean2)
  {
    Object localObject2 = paramagpx.jdField_b_of_type_AndroidWidgetRelativeLayout;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramagpx.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject1);
      ((RelativeLayout)localObject1).setId(2131377851);
      paramBaseChatItemLayout.addView((View)localObject1);
    }
    Object localObject3 = (RelativeLayout.LayoutParams)((RelativeLayout)localObject1).getLayoutParams();
    localObject2 = localObject3;
    if (localObject3 == null) {
      localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    }
    ((RelativeLayout.LayoutParams)localObject2).topMargin = AIOUtils.dp2px(-2.0F, paramResources);
    if (paramBoolean2)
    {
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = AIOUtils.dp2px(0.0F, paramResources);
      ((RelativeLayout.LayoutParams)localObject2).addRule(5, 2131364441);
      ((RelativeLayout.LayoutParams)localObject2).addRule(3, 2131364441);
      ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject3 = ((RelativeLayout)localObject1).getChildAt(0);
      localObject2 = localObject3;
      if (localObject3 != null)
      {
        localObject2 = localObject3;
        if (paramagpx.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
        {
          Object localObject4 = paramagpx.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
          localObject2 = localObject3;
          if (localObject4 != null)
          {
            localObject4 = ((View)localObject4).getTag(2131377871);
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
        break label442;
      }
      ((View)localObject2).setId(2131377852);
      ((RelativeLayout)localObject1).addView((View)localObject2);
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
      {
        paramagpx = new View(this.jdField_a_of_type_AndroidContentContext);
        paramBaseChatItemLayout = new RelativeLayout.LayoutParams(-2, -2);
        paramBaseChatItemLayout.addRule(6, 2131377852);
        paramBaseChatItemLayout.addRule(5, 2131377852);
        paramBaseChatItemLayout.addRule(7, 2131377852);
        paramBaseChatItemLayout.addRule(8, 2131377852);
        paramagpx.setBackgroundResource(2130838003);
        ((RelativeLayout)localObject1).addView(paramagpx, paramBaseChatItemLayout);
      }
    }
    for (;;)
    {
      a(paramAbsStructMsg, (RelativeLayout)localObject1);
      atyv.a((View)localObject2, (RelativeLayout)localObject1, paramBoolean1, paramResources, this.jdField_a_of_type_AndroidContentContext, paramAbsStructMsg);
      return;
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = AIOUtils.dp2px(10.0F, paramResources);
      if (!a(paramBoolean1, paramAbsStructMsg)) {
        break;
      }
      ((RelativeLayout.LayoutParams)localObject2).leftMargin += AIOUtils.dp2px(18.0F, paramResources);
      break;
      label442:
      paramBaseChatItemLayout.removeView((View)localObject1);
      paramagpx.jdField_b_of_type_AndroidWidgetRelativeLayout = null;
    }
  }
  
  private void a(agpx paramagpx, BaseChatItemLayout paramBaseChatItemLayout, boolean paramBoolean1, StructMsgForGeneralShare paramStructMsgForGeneralShare, Resources paramResources, boolean paramBoolean2)
  {
    RelativeLayout localRelativeLayout = paramagpx.jdField_c_of_type_AndroidWidgetRelativeLayout;
    Object localObject = localRelativeLayout;
    if (localRelativeLayout == null)
    {
      localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramagpx.jdField_b_of_type_AndroidWidgetRelativeLayout = localRelativeLayout;
      localRelativeLayout.setId(2131377850);
      paramBaseChatItemLayout.addView(localRelativeLayout);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localRelativeLayout.getLayoutParams();
      localObject = localLayoutParams;
      if (localLayoutParams == null) {
        localObject = new RelativeLayout.LayoutParams(-2, -2);
      }
      ((RelativeLayout.LayoutParams)localObject).topMargin = (12 - AIOUtils.dp2px(10.0F, paramResources));
      ((RelativeLayout.LayoutParams)localObject).addRule(5, 2131364441);
      ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131364441);
      localObject = localRelativeLayout;
    }
    paramResources = ((RelativeLayout)localObject).getChildAt(0);
    paramStructMsgForGeneralShare = paramStructMsgForGeneralShare.getAdSourceView(this.jdField_a_of_type_AndroidContentContext, paramResources, paramBaseChatItemLayout);
    if (paramStructMsgForGeneralShare != null)
    {
      ((RelativeLayout)localObject).addView(paramStructMsgForGeneralShare);
      paramagpx = (RelativeLayout.LayoutParams)paramStructMsgForGeneralShare.getLayoutParams();
      paramagpx.topMargin = UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 10.0F);
      paramagpx.height = -2;
      paramagpx.width = -2;
      return;
    }
    paramBaseChatItemLayout.removeView((View)localObject);
    paramagpx.jdField_b_of_type_AndroidWidgetRelativeLayout = null;
  }
  
  private void a(Activity paramActivity)
  {
    ReportDialog localReportDialog = new ReportDialog(paramActivity);
    localReportDialog.requestWindowFeature(1);
    localReportDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    View localView = LayoutInflater.from(paramActivity).inflate(2131559653, null);
    ((ImageView)localView.findViewById(2131368367)).setImageResource(2130839630);
    ((TextView)localView.findViewById(2131378381)).setText(amtj.a(2131713620));
    localReportDialog.setContentView(localView);
    localReportDialog.show();
    new Handler(paramActivity.getMainLooper()).postDelayed(new StructingMsgItemBuilder.19(this, localReportDialog), 1500L);
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
        Object localObject2 = new bjsy();
        ((bjsy)localObject2).jdField_a_of_type_Int = i;
        ((bjsy)localObject2).jdField_b_of_type_Int = 0;
        if (localJSONObject.has("show_name")) {}
        for (((bjsy)localObject2).jdField_a_of_type_JavaLangString = localJSONObject.getString("show_name");; ((bjsy)localObject2).jdField_a_of_type_JavaLangString = "")
        {
          localArrayList1.add(localObject2);
          localObject2 = new uel();
          ((uel)localObject2).jdField_a_of_type_JavaLangString = str;
          ((uel)localObject2).c = localJSONObject.optString("index");
          ((uel)localObject2).d = localJSONObject.optString("index_name");
          ((uel)localObject2).b = localJSONObject.optString("index_type");
          ((uel)localObject2).e = String.valueOf(HttpUtil.getNetWorkType());
          localArrayList2.add(localObject2);
          i += 1;
          break;
        }
      }
      this.jdField_a_of_type_Bjsv = bjsv.a(paramActivity, localArrayList1, new agpi(this, paramActivity, paramChatMessage, localAbsStructMsg, str, localArrayList2), new agpj(this), AIOUtils.dp2px(100.0F, paramActivity.getResources()));
    }
    catch (JSONException paramActivity)
    {
      paramActivity.printStackTrace();
      return;
    }
    int i = paramView.getWidth() * 7 / 2;
    this.jdField_a_of_type_Bjsv.showAsDropDown(paramView, 0 - i, 0);
    this.jdField_a_of_type_Bjsv.dismiss();
    paramActivity = new int[2];
    paramView.getLocationOnScreen(paramActivity);
    this.jdField_a_of_type_Bjsv.showAtLocation(paramView, 0, paramActivity[0], paramActivity[1] + paramView.getHeight());
    this.jdField_a_of_type_Bjsv.setOnDismissListener(new agpk(this));
  }
  
  private void a(Bundle paramBundle, MessageForStructing paramMessageForStructing, AbsStructMsg paramAbsStructMsg)
  {
    paramAbsStructMsg.uniseq = paramMessageForStructing.uniseq;
    paramAbsStructMsg.uin = paramMessageForStructing.frienduin;
    paramAbsStructMsg.uinType = paramMessageForStructing.istroop;
    paramAbsStructMsg.currentAccountUin = paramMessageForStructing.selfuin;
    paramAbsStructMsg.messageVersion = paramMessageForStructing.versionCode;
    paramBundle.putBoolean("isSend", paramMessageForStructing.isSend());
    if (paramAbsStructMsg.uinType == 1008) {
      paramAbsStructMsg.sourceAccoutType = AbsStructMsg.SOURCE_ACCOUNT_TYPE_PA;
    }
    do
    {
      return;
      paramBundle = paramMessageForStructing.getExtInfoFromExtStr("accostType");
    } while ((paramBundle == null) || (paramBundle.equals("")));
    try
    {
      paramAbsStructMsg.sourceAccoutType = Integer.parseInt(paramBundle);
      return;
    }
    catch (Exception paramBundle) {}
  }
  
  private void a(View paramView, AbsShareMsg paramAbsShareMsg)
  {
    BaseChatPie localBaseChatPie = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a();
    if ((localBaseChatPie instanceof ahiu)) {
      paramView.setOnClickListener(new agph(this, localBaseChatPie, paramAbsShareMsg));
    }
  }
  
  private void a(View paramView, AbsShareMsg paramAbsShareMsg, MessageForStructing paramMessageForStructing, ChatMessage paramChatMessage, long paramLong, View.OnClickListener paramOnClickListener)
  {
    if (paramAbsShareMsg.mMsgServiceID == 81) {
      xwa.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramMessageForStructing, "clk_play");
    }
    while (paramAbsShareMsg.mMsgServiceID != 98)
    {
      AIOUtils.isUserOperatedInAIO = true;
      if (!a()) {
        break;
      }
      return;
    }
    int i;
    label60:
    String str1;
    label76:
    String str3;
    if ((bckb.a(paramAbsShareMsg.mExtraData) & 0x2) != 0)
    {
      i = 1;
      if (!awhm.a(paramChatMessage, "isFaceScoreSecondMember")) {
        break label136;
      }
      str1 = "2";
      str3 = paramChatMessage.frienduin;
      if (i == 0) {
        break label144;
      }
    }
    label136:
    label144:
    for (String str2 = "2";; str2 = "1")
    {
      awhm.a("clk_obj", str3, new String[] { str1, "", "", str2 });
      break;
      i = 0;
      break label60;
      str1 = "1";
      break label76;
    }
    if ((((bgre)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(76)).b(paramLong)) && (paramAbsShareMsg.mMsgServiceID == 38)) {}
    for (;;)
    {
      if ((paramMessageForStructing instanceof MessageForTroopNotification))
      {
        paramView = (MessageForTroopNotification)paramMessageForStructing;
        bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_bulletin", "", "AIOchat", "obj_clk", 0, 0, paramView.frienduin, "" + paramView.feedType, "", "");
      }
      a((MessageForStructing)paramChatMessage);
      return;
      paramOnClickListener.onClick(paramView);
    }
  }
  
  private void a(View paramView, AbsStructMsg paramAbsStructMsg)
  {
    if (paramAbsStructMsg.mMsgServiceID == 35)
    {
      paramView = (aezf)paramView.getTag();
      paramView.jdField_a_of_type_AndroidViewView.setPadding(paramView.jdField_a_of_type_AndroidViewView.getPaddingLeft(), 0, paramView.jdField_a_of_type_AndroidViewView.getPaddingRight(), 0);
    }
  }
  
  private void a(View paramView, AbsStructMsg paramAbsStructMsg, AbsShareMsg paramAbsShareMsg)
  {
    if (paramAbsStructMsg.mMsgServiceID == 79)
    {
      paramView.setOnClickListener(null);
      paramView.setOnClickListener(new agpw(this, paramAbsShareMsg));
    }
  }
  
  private void a(View paramView, StructMsgForGeneralShare paramStructMsgForGeneralShare)
  {
    new bchd(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView).a(paramStructMsgForGeneralShare.mMsgAction, paramStructMsgForGeneralShare.mMsgUrl, paramStructMsgForGeneralShare.mMsgActionData, paramStructMsgForGeneralShare.mMsg_A_ActionData);
  }
  
  private void a(bgaz parambgaz, AbsStructMsg paramAbsStructMsg, Resources paramResources)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1008) {
      if (!paramAbsStructMsg.hasFlag(32)) {
        parambgaz.a(2131367116, paramResources.getString(2131692448), 2130838971);
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
        parambgaz.a(2131367094, paramResources.getString(2131692448), 2130838971);
        return;
      } while (paramAbsStructMsg.mMsgServiceID == 14);
      if (!paramAbsStructMsg.hasFlag(1))
      {
        parambgaz.a(2131367094, paramResources.getString(2131692448), 2130838971);
        return;
      }
    } while (paramAbsStructMsg.mMsgServiceID != 35);
    parambgaz.a(2131367094, paramResources.getString(2131692448), 2130838971);
  }
  
  private void a(BaseChatItemLayout paramBaseChatItemLayout, MessageForStructing paramMessageForStructing)
  {
    int i = ((StructMsgForGeneralShare)paramMessageForStructing.structingMsg).getProgress();
    if ((paramMessageForStructing.extraflag == 32772) && (i >= 0) && (i < 100))
    {
      andf localandf = (andf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(28);
      localandf.a(bblk.a(paramMessageForStructing.msgUid), paramMessageForStructing.frienduin, paramMessageForStructing.uniseq);
      paramMessageForStructing = new agpp(this, paramMessageForStructing, paramBaseChatItemLayout);
      paramBaseChatItemLayout.setTag(2131379176, paramMessageForStructing);
      localandf.a(paramBaseChatItemLayout, paramMessageForStructing);
    }
  }
  
  private void a(BaseChatItemLayout paramBaseChatItemLayout1, MessageForStructing paramMessageForStructing, BaseChatItemLayout paramBaseChatItemLayout2, Resources paramResources, boolean paramBoolean)
  {
    int k;
    int m;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1008) || (paramMessageForStructing.structingMsg.mMsgServiceID == 76) || (paramMessageForStructing.structingMsg.mMsgServiceID == 21))
    {
      k = paramResources.getDimensionPixelSize(2131298976);
      m = paramResources.getDimensionPixelSize(2131298976);
      if ((!BaseChatItemLayout.jdField_a_of_type_Boolean) || (!paramBoolean)) {
        break label206;
      }
    }
    label206:
    for (int i = 1;; i = 0)
    {
      AIOLongShotHelper localAIOLongShotHelper = AIOLongShotHelper.a();
      int j = i;
      if (localAIOLongShotHelper != null)
      {
        j = i;
        if (localAIOLongShotHelper.a()) {
          j = 0;
        }
      }
      i = k;
      if (j != 0)
      {
        j = AIOUtils.dp2px(30.0F, paramResources);
        i = j;
        if (paramBaseChatItemLayout2.jdField_a_of_type_AndroidWidgetCheckBox != null)
        {
          paramBaseChatItemLayout2 = (RelativeLayout.LayoutParams)paramBaseChatItemLayout2.jdField_a_of_type_AndroidWidgetCheckBox.getLayoutParams();
          i = j;
          if (paramBaseChatItemLayout2 != null)
          {
            paramBaseChatItemLayout2.leftMargin = AIOUtils.dp2px(5.0F, paramResources);
            i = j;
          }
        }
      }
      paramBaseChatItemLayout1 = (RelativeLayout.LayoutParams)((RelativeLayout)paramBaseChatItemLayout1.b()).getLayoutParams();
      if (paramBaseChatItemLayout1 != null)
      {
        if (paramMessageForStructing.structingMsg.mMsgServiceID == 21) {
          break;
        }
        paramBaseChatItemLayout1.setMargins(i, 0, m, 0);
      }
      return;
    }
    paramBaseChatItemLayout1.setMargins(i, paramBaseChatItemLayout1.topMargin, m, paramBaseChatItemLayout1.bottomMargin);
  }
  
  private void a(BaseChatItemLayout paramBaseChatItemLayout, MessageForStructing paramMessageForStructing, AbsStructMsg paramAbsStructMsg)
  {
    if (StructMsgForImageShare.class.isInstance(paramAbsStructMsg)) {
      afaz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramBaseChatItemLayout, this);
    }
    for (;;)
    {
      if (b(paramMessageForStructing)) {
        afaz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramBaseChatItemLayout, this);
      }
      return;
      if ((StructMsgForGeneralShare.class.isInstance(paramAbsStructMsg)) && (b(paramAbsStructMsg))) {
        a(paramBaseChatItemLayout, paramMessageForStructing);
      }
    }
  }
  
  private void a(ChatMessage paramChatMessage, agpx paramagpx)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1008) && (!this.jdField_a_of_type_JavaUtilHashSet.contains(Long.valueOf(paramChatMessage.uniseq))))
    {
      this.jdField_a_of_type_JavaUtilHashSet.add(Long.valueOf(paramChatMessage.uniseq));
      anxs.a(117, paramChatMessage, paramagpx.jdField_b_of_type_Int);
    }
  }
  
  private void a(ChatMessage paramChatMessage, agpx paramagpx, BaseChatItemLayout paramBaseChatItemLayout)
  {
    Integer localInteger;
    if ((paramagpx.jdField_c_of_type_AndroidWidgetRelativeLayout != null) && (paramagpx.jdField_c_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0)) {
      localInteger = Integer.valueOf(2131377850);
    }
    for (;;)
    {
      paramagpx.jdField_c_of_type_AndroidViewView = super.a(paramagpx.jdField_c_of_type_AndroidViewView, paramagpx, paramBaseChatItemLayout, paramChatMessage, -2, DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 21.0F));
      super.a(paramagpx.jdField_c_of_type_AndroidViewView, paramBaseChatItemLayout, localInteger, paramChatMessage, -4, Boolean.valueOf(true));
      return;
      if ((paramagpx.jdField_b_of_type_AndroidWidgetRelativeLayout != null) && (paramagpx.jdField_b_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0)) {
        localInteger = Integer.valueOf(2131377851);
      } else {
        localInteger = null;
      }
    }
  }
  
  private void a(ChatMessage paramChatMessage, Bundle paramBundle, AbsStructMsg paramAbsStructMsg)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1008))
    {
      Object localObject;
      if ((paramAbsStructMsg instanceof StructMsgForGeneralShare))
      {
        localObject = (StructMsgForGeneralShare)paramAbsStructMsg;
        paramBundle.putString("VIDEO_PUB_ACCOUNT_UIN", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
        paramBundle.putString("VIDEO_PUB_ACCOUNT_NAME", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendNick);
      }
      paramBundle.putBoolean("isPublicAccount", true);
      paramChatMessage = paramChatMessage.getExtInfoFromExtStr("msg_template_id");
      if ((paramChatMessage != null) && (!paramChatMessage.equals("")))
      {
        if (!TextUtils.isEmpty(paramChatMessage)) {
          paramAbsStructMsg.templateIDForPortal = paramChatMessage;
        }
        if ((paramAbsStructMsg instanceof AbsShareMsg))
        {
          paramBundle = ((AbsShareMsg)paramAbsStructMsg).getStructMsgItemLists();
          if (paramBundle != null)
          {
            paramBundle = paramBundle.iterator();
            while (paramBundle.hasNext())
            {
              paramAbsStructMsg = (bcgw)paramBundle.next();
              if (!TextUtils.isEmpty(paramChatMessage)) {
                paramAbsStructMsg.Z = paramChatMessage;
              }
              if ((paramAbsStructMsg instanceof bcgx))
              {
                paramAbsStructMsg = (bcgx)paramAbsStructMsg;
                if (paramAbsStructMsg.a != null)
                {
                  paramAbsStructMsg = paramAbsStructMsg.a.iterator();
                  while (paramAbsStructMsg.hasNext())
                  {
                    localObject = (bcgw)paramAbsStructMsg.next();
                    if (!TextUtils.isEmpty(paramChatMessage)) {
                      ((bcgw)localObject).Z = paramChatMessage;
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
  
  private void a(ChatMessage paramChatMessage, View paramView, BaseChatItemLayout paramBaseChatItemLayout, MessageForStructing paramMessageForStructing, AbsStructMsg paramAbsStructMsg)
  {
    if ((paramAbsStructMsg instanceof AbsShareMsg)) {
      b(paramChatMessage, paramView, paramBaseChatItemLayout, paramMessageForStructing, paramAbsStructMsg);
    }
    while ((paramAbsStructMsg.mMsgServiceID != 3) && (paramAbsStructMsg.mMsgServiceID != 120)) {
      return;
    }
    if (a())
    {
      paramView.setClickable(false);
      return;
    }
    paramView.setClickable(true);
  }
  
  private void a(ChatMessage paramChatMessage, View paramView, MessageForStructing paramMessageForStructing, AbsStructMsg paramAbsStructMsg)
  {
    RelativeLayout localRelativeLayout;
    Object localObject;
    RelativeLayout.LayoutParams localLayoutParams;
    long l;
    if (paramAbsStructMsg.adverSign == 1)
    {
      localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      localObject = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      ((ImageView)localObject).setImageResource(2130841627);
      localRelativeLayout.setBackgroundColor(0);
      localLayoutParams = new RelativeLayout.LayoutParams(AIOUtils.dp2px(80.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.dp2px(44.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      localLayoutParams.addRule(11);
      localLayoutParams.addRule(10);
      localRelativeLayout.setLayoutParams(localLayoutParams);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(11);
      localLayoutParams.addRule(10);
      localLayoutParams.setMargins(0, 12, 12, 0);
      ((ImageView)localObject).setLayoutParams(localLayoutParams);
      localRelativeLayout.addView((View)localObject);
      if ((paramView instanceof RelativeLayout)) {
        ((RelativeLayout)paramView).addView(localRelativeLayout);
      }
      paramView = paramMessageForStructing.frienduin;
      l = paramAbsStructMsg.msgId;
      if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
        localRelativeLayout.setOnClickListener(new agpu(this, (ImageView)localObject, paramChatMessage, paramView, l));
      }
    }
    do
    {
      do
      {
        return;
      } while (paramAbsStructMsg.adverSign != 2);
      localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      localObject = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject).setBackgroundResource(2130841789);
      ((TextView)localObject).setGravity(17);
      int i = paramAbsStructMsg.adverSign;
      ((TextView)localObject).setText(amtj.a(2131713614));
      ((TextView)localObject).setTextColor(-1);
      ((TextView)localObject).setTextSize(13.0F);
      localRelativeLayout.setBackgroundColor(0);
      localLayoutParams = new RelativeLayout.LayoutParams(AIOUtils.dp2px(80.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.dp2px(44.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      localLayoutParams.addRule(11);
      localLayoutParams.addRule(10);
      localRelativeLayout.setLayoutParams(localLayoutParams);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(11);
      localLayoutParams.addRule(10);
      ((TextView)localObject).setLayoutParams(localLayoutParams);
      localRelativeLayout.addView((View)localObject);
      if ((paramView instanceof RelativeLayout)) {
        ((RelativeLayout)paramView).addView(localRelativeLayout);
      }
      paramView = paramMessageForStructing.frienduin;
      l = paramAbsStructMsg.msgId;
      paramView = paramMessageForStructing.getExtInfoFromExtStr("msg_template_id");
      i = paramMessageForStructing.istroop;
    } while (!(this.jdField_a_of_type_AndroidContentContext instanceof Activity));
    localRelativeLayout.setOnClickListener(new agpv(this, (TextView)localObject, paramChatMessage, paramView));
  }
  
  private void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, MessageForStructing paramMessageForStructing)
  {
    int j = 1;
    int i;
    if (!awhn.a(paramMessageForStructing))
    {
      paramMessageForStructing = (DuiButtonImageView)paramBaseChatItemLayout.findViewById(2131365813);
      if (paramMessageForStructing != null) {
        break label197;
      }
      paramMessageForStructing = new DuiButtonImageView(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(AIOUtils.dp2px(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.dp2px(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      localLayoutParams.addRule(8, 2131364441);
      localLayoutParams.addRule(1, 2131364441);
      localLayoutParams.bottomMargin = (BaseChatItemLayout.i - AIOUtils.dp2px(6.5F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramMessageForStructing.setId(2131365813);
      paramBaseChatItemLayout.addView(paramMessageForStructing, localLayoutParams);
      paramBaseChatItemLayout = paramMessageForStructing;
      if (paramChatMessage.extraflag == 32768)
      {
        i = j;
        if (paramChatMessage.isSendFromLocal()) {}
      }
      else
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().c(paramChatMessage)) {
          break label207;
        }
        i = j;
      }
    }
    for (;;)
    {
      if ((paramChatMessage.isDui) && (i == 0))
      {
        if (paramChatMessage.isSend())
        {
          paramBaseChatItemLayout.setVisibility(8);
          return;
          label197:
          paramMessageForStructing.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
          paramBaseChatItemLayout = paramMessageForStructing;
          break;
          label207:
          i = 0;
          continue;
        }
        if (!paramChatMessage.hasPlayedDui) {
          paramChatMessage.hasPlayedDui = DuiButtonImageView.a(paramBaseChatItemLayout);
        }
        while (DuiButtonImageView.jdField_a_of_type_Boolean)
        {
          paramBaseChatItemLayout.setOnClickListener(this);
          paramBaseChatItemLayout.setVisibility(0);
          return;
          paramBaseChatItemLayout.f();
        }
        paramBaseChatItemLayout.setOnClickListener(null);
        paramBaseChatItemLayout.setVisibility(8);
        return;
      }
    }
    paramBaseChatItemLayout.setVisibility(8);
    paramBaseChatItemLayout.e();
  }
  
  private void a(ChatMessage paramChatMessage, AbsStructMsg paramAbsStructMsg)
  {
    if (((paramAbsStructMsg instanceof StructMsgForGeneralShare)) && (!((StructMsgForGeneralShare)paramAbsStructMsg).havaPayInfoInit))
    {
      String str = paramChatMessage.getExtInfoFromExtStr("pa_pay_message");
      if ((!TextUtils.isEmpty(str)) && (str.equals("1"))) {
        ((StructMsgForGeneralShare)paramAbsStructMsg).initPay(this.jdField_a_of_type_AndroidContentContext, paramChatMessage);
      }
    }
  }
  
  private void a(ChatMessage paramChatMessage, AbsStructMsg paramAbsStructMsg, agpx paramagpx)
  {
    if ((paramagpx != null) && (paramagpx.jdField_a_of_type_ComTencentMobileqqDataChatMessage == paramChatMessage) && (paramAbsStructMsg.hasFlag(16))) {
      ThreadManager.post(new StructingMsgItemBuilder.3(this, paramagpx), 2, null, false);
    }
  }
  
  private void a(ChatMessage paramChatMessage, AbsStructMsg paramAbsStructMsg, RelativeLayout paramRelativeLayout)
  {
    if (paramAbsStructMsg.mMsgServiceID == 38)
    {
      paramAbsStructMsg = (bgre)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(76);
      if (paramAbsStructMsg != null)
      {
        if (!paramAbsStructMsg.b(paramChatMessage.time)) {
          break label131;
        }
        paramChatMessage = new ProgressBar(this.jdField_a_of_type_AndroidContentContext);
        paramChatMessage.setId(2131364468);
        paramChatMessage.setIndeterminateDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839445));
        int i = AIOUtils.dp2px(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        new RelativeLayout.LayoutParams(-2, -2);
        paramAbsStructMsg = new RelativeLayout.LayoutParams(i, i);
        paramAbsStructMsg.addRule(13, 2131364441);
        paramRelativeLayout.addView(paramChatMessage, paramAbsStructMsg);
        e();
      }
    }
    label131:
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType != 0);
      paramChatMessage = paramAbsStructMsg.a();
    } while (paramChatMessage == null);
    a(paramChatMessage.a);
  }
  
  private void a(ChatMessage paramChatMessage, String paramString1, String paramString2)
  {
    boolean bool = String.valueOf(-1000).equals(paramString2);
    Object localObject;
    if (bool)
    {
      paramString2 = amtj.a(2131713615);
      localObject = amtj.a(2131713616);
      if (TextUtils.isEmpty(paramString1)) {
        break label113;
      }
    }
    for (;;)
    {
      localObject = (bjnw)bjon.a(this.jdField_a_of_type_AndroidContentContext, null);
      ((bjnw)localObject).c(paramString2);
      ((bjnw)localObject).d(this.jdField_a_of_type_AndroidContentContext.getString(2131690620));
      ((bjnw)localObject).a(paramString1);
      ((bjnw)localObject).a(new agps(this, bool, paramChatMessage, (bjnw)localObject));
      ((bjnw)localObject).show();
      return;
      paramString2 = amtj.a(2131713617);
      break;
      label113:
      paramString1 = (String)localObject;
    }
  }
  
  private void a(MessageForStructing paramMessageForStructing, AbsStructMsg paramAbsStructMsg)
  {
    if (StructMsgForImageShare.class.isInstance(paramAbsStructMsg))
    {
      paramAbsStructMsg = (StructMsgForImageShare)paramAbsStructMsg;
      paramAbsStructMsg.mIsSend = paramMessageForStructing.issend;
      paramAbsStructMsg.mUniseq = paramMessageForStructing.uniseq;
      paramAbsStructMsg.mMsgType = paramMessageForStructing.msgtype;
    }
  }
  
  private void a(MessageForStructing paramMessageForStructing, AbsStructMsg paramAbsStructMsg, agpx paramagpx, RelativeLayout paramRelativeLayout)
  {
    if ((paramAbsStructMsg instanceof StructMsgForImageShare)) {
      a(paramMessageForStructing, (StructMsgForImageShare)paramAbsStructMsg, paramagpx, paramRelativeLayout);
    }
    while ((!(paramAbsStructMsg instanceof StructMsgForGeneralShare)) && (!(paramAbsStructMsg instanceof StructMsgForAudioShare))) {
      return;
    }
    a((AbsShareMsg)paramAbsStructMsg);
  }
  
  private void a(MessageForStructing paramMessageForStructing, AbsStructMsg paramAbsStructMsg, Bundle paramBundle)
  {
    paramBundle.putInt("accostType", paramAbsStructMsg.sourceAccoutType);
    if (paramAbsStructMsg.mMsgServiceID == 21) {
      paramBundle.putInt("serviceID", paramAbsStructMsg.mMsgServiceID);
    }
    if ((paramAbsStructMsg instanceof StructMsgForGeneralShare))
    {
      if (paramAbsStructMsg.mSType != null) {
        paramBundle.putString("sType", paramAbsStructMsg.mSType);
      }
      if ((!StructLongMessageDownloadProcessor.isPALongMsg(paramMessageForStructing)) && (!StructLongMessageDownloadProcessor.needFetchOldLongMsg(paramMessageForStructing))) {}
    }
    try
    {
      paramBundle.putInt("longMsgHolderType", Integer.parseInt(paramMessageForStructing.getExtInfoFromExtStr("longMsg_State")));
      return;
    }
    catch (Exception paramMessageForStructing) {}
  }
  
  private void a(MessageForStructing paramMessageForStructing, StructMsgForImageShare paramStructMsgForImageShare, agpx paramagpx, RelativeLayout paramRelativeLayout)
  {
    if (paramMessageForStructing.isSendFromLocal())
    {
      paramMessageForStructing = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().findProcessor(paramMessageForStructing.frienduin, paramMessageForStructing.uniseq);
      paramagpx.jdField_a_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout;
      a(paramMessageForStructing, paramagpx);
    }
    paramMessageForStructing = paramStructMsgForImageShare.getFirstImageElement();
    if ((paramMessageForStructing != null) && (paramMessageForStructing.a != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPicPreDownloader().a(paramMessageForStructing.a, 2);
      ThreadManager.getFileThreadHandler().post(new StructingMsgItemBuilder.6(this, paramMessageForStructing));
    }
    a(paramStructMsgForImageShare);
  }
  
  private void a(AbsShareMsg paramAbsShareMsg)
  {
    if (!this.jdField_b_of_type_JavaUtilList.contains(paramAbsShareMsg))
    {
      paramAbsShareMsg.report(Integer.valueOf(0));
      this.jdField_b_of_type_JavaUtilList.add(paramAbsShareMsg);
    }
  }
  
  private void a(AbsStructMsg paramAbsStructMsg)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType != 1008) && (paramAbsStructMsg.hasFlag(4))) {
      paramAbsStructMsg.addFlag(1);
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
  
  private void a(IHttpCommunicatorListener paramIHttpCommunicatorListener, agpx paramagpx)
  {
    if (paramagpx.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
      return;
    }
    Object localObject;
    int i;
    if ((paramIHttpCommunicatorListener instanceof BaseTransProcessor))
    {
      localObject = (BaseTransProcessor)paramIHttpCommunicatorListener;
      i = (int)((BaseTransProcessor)localObject).getFileStatus();
      if ((i != 1004) || (!((BaseTransProcessor)localObject).isRawPic()) || (!((BaseTransProcessor)localObject).isPause())) {
        break label368;
      }
      i = 1006;
    }
    label368:
    for (;;)
    {
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(6, 2131377871);
      ((RelativeLayout.LayoutParams)localObject).addRule(8, 2131377871);
      ((RelativeLayout.LayoutParams)localObject).addRule(5, 2131377871);
      ((RelativeLayout.LayoutParams)localObject).addRule(7, 2131377871);
      if ((paramagpx.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (paramagpx.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131377857) == null) && (paramagpx.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView != null)) {
        paramagpx.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramagpx.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView, (ViewGroup.LayoutParams)localObject);
      }
      switch (i)
      {
      default: 
        if (paramagpx.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView == null) {
          break;
        }
        paramagpx.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setProcessor(null);
        paramagpx.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(8);
        return;
      case 1000: 
      case 1001: 
      case 1002: 
      case 1006: 
      case 4001: 
        if (paramagpx.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView == null)
        {
          MessageProgressTextView localMessageProgressTextView = new MessageProgressTextView(this.jdField_a_of_type_AndroidContentContext);
          localMessageProgressTextView.setTextColor(-1);
          localMessageProgressTextView.setTextSize(2, 15.0F);
          localMessageProgressTextView.setGravity(17);
          localMessageProgressTextView.setId(2131377857);
          localMessageProgressTextView.setBackgroundDrawable(new afuj(2130706432, this.jdField_b_of_type_Float * 12.0F));
          if (paramagpx.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
            paramagpx.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localMessageProgressTextView, (ViewGroup.LayoutParams)localObject);
          }
          paramagpx.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView = localMessageProgressTextView;
        }
        paramagpx.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setProcessor((BaseTransProcessor)paramIHttpCommunicatorListener);
        paramagpx.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(0);
        a(paramagpx, i);
        return;
        if (paramagpx.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView == null) {
          break;
        }
        paramagpx.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setProcessor(null);
        paramagpx.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(4);
        return;
      }
    }
  }
  
  private boolean a(MessageForStructing paramMessageForStructing, int paramInt)
  {
    return (!a(paramMessageForStructing)) && (paramInt != 83) && (paramInt != 151) && (paramInt != 156) && (paramInt != 108) && (paramInt != 114) && (paramInt != 98) && (paramInt != 97) && (paramInt != 5) && (paramInt != 137) && (paramInt != 106) && (paramInt != 107) && (paramInt != 122) && (paramInt != 116);
  }
  
  private boolean a(boolean paramBoolean, AbsStructMsg paramAbsStructMsg)
  {
    return (paramBoolean) && ((paramAbsStructMsg.mMsgServiceID == 83) || (paramAbsStructMsg.mMsgServiceID == 108) || (paramAbsStructMsg.mMsgServiceID == 114) || (paramAbsStructMsg.mMsgServiceID == 116) || (paramAbsStructMsg.mMsgServiceID == 151) || (paramAbsStructMsg.mMsgServiceID == 156)) && (!TextUtils.isEmpty(paramAbsStructMsg.mMsgActionData));
  }
  
  private int b(ChatMessage paramChatMessage, Context paramContext, aezf paramaezf, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4, int paramInt5)
  {
    int i = paramInt1;
    if (paramInt1 > paramInt2) {
      i = paramInt1 - paramInt2;
    }
    paramaezf.jdField_a_of_type_AndroidViewView.setBackgroundResource(paramInt3);
    RelativeLayout localRelativeLayout;
    RelativeLayout.LayoutParams localLayoutParams;
    if ((paramBoolean) && (paramaezf.jdField_a_of_type_AndroidViewView.getParent() != null) && ((paramaezf.jdField_a_of_type_AndroidViewView.getParent() instanceof RelativeLayout)))
    {
      localRelativeLayout = (RelativeLayout)paramaezf.jdField_a_of_type_AndroidViewView.getParent();
      paramContext = new View(paramContext);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(6, 2131364441);
      localLayoutParams.addRule(5, 2131364441);
      localLayoutParams.addRule(7, 2131364441);
      localLayoutParams.addRule(8, 2131364441);
      if (paramaezf.jdField_b_of_type_AndroidViewView != null) {
        localRelativeLayout.removeView(paramaezf.jdField_b_of_type_AndroidViewView);
      }
      if (!awct.a(paramChatMessage)) {
        break label172;
      }
      paramContext.setBackgroundResource(paramInt4);
    }
    for (;;)
    {
      paramaezf.jdField_b_of_type_AndroidViewView = paramContext;
      localRelativeLayout.addView(paramaezf.jdField_b_of_type_AndroidViewView, localLayoutParams);
      return i;
      label172:
      paramContext.setBackgroundResource(paramInt5);
    }
  }
  
  private void b(Activity paramActivity)
  {
    ReportDialog localReportDialog = new ReportDialog(paramActivity);
    localReportDialog.requestWindowFeature(1);
    localReportDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    View localView = LayoutInflater.from(paramActivity).inflate(2131559653, null);
    ((ImageView)localView.findViewById(2131368367)).setImageResource(2130839615);
    ((TextView)localView.findViewById(2131378381)).setText(amtj.a(2131713619));
    localReportDialog.setContentView(localView);
    localReportDialog.show();
    new Handler(paramActivity.getMainLooper()).postDelayed(new StructingMsgItemBuilder.20(this, localReportDialog), 1500L);
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
        bjsy localbjsy = new bjsy();
        if (localJSONObject.has("index"))
        {
          localbjsy.jdField_a_of_type_Int = localJSONObject.getInt("index");
          localbjsy.jdField_b_of_type_Int = 0;
          if (localJSONObject.has("show_name"))
          {
            localbjsy.jdField_a_of_type_JavaLangString = localJSONObject.getString("show_name");
            localArrayList.add(localbjsy);
            i += 1;
          }
        }
        else
        {
          localbjsy.jdField_a_of_type_Int = i;
          continue;
        }
        localbjsy.jdField_a_of_type_JavaLangString = "";
      }
      catch (JSONException paramActivity)
      {
        paramActivity.printStackTrace();
        return;
      }
    }
    this.jdField_a_of_type_Bjsv = bjsv.a(paramActivity, localArrayList, new agpl(this, paramChatMessage, paramActivity, localAbsStructMsg), new agpn(this), AIOUtils.dp2px(100.0F, paramActivity.getResources()));
    int i = paramView.getWidth() * -5 / 7;
    this.jdField_a_of_type_Bjsv.showAsDropDown(paramView, i, 0);
    this.jdField_a_of_type_Bjsv.dismiss();
    paramActivity = new int[2];
    paramView.getLocationOnScreen(paramActivity);
    this.jdField_a_of_type_Bjsv.showAtLocation(paramView, 0, paramActivity[0], paramActivity[1] + paramView.getHeight());
    this.jdField_a_of_type_Bjsv.setOnDismissListener(new agpo(this));
  }
  
  private void b(View paramView, AbsStructMsg paramAbsStructMsg)
  {
    if (paramAbsStructMsg.mMsgServiceID == 76)
    {
      int i = AIOUtils.dp2px(11.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      int j = AIOUtils.dp2px(7.5F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramView.setPadding(0, 0, 0, 0);
      paramView = (aezf)paramView.getTag();
      paramView.jdField_a_of_type_AndroidViewView.setPadding(0, 0, 0, 0);
      ((RelativeLayout.LayoutParams)paramView.jdField_a_of_type_AndroidViewView.getLayoutParams()).setMargins(i, j, i, j);
    }
  }
  
  private void b(ChatMessage paramChatMessage, View paramView, BaseChatItemLayout paramBaseChatItemLayout, MessageForStructing paramMessageForStructing, AbsStructMsg paramAbsStructMsg)
  {
    AbsShareMsg localAbsShareMsg = (AbsShareMsg)paramAbsStructMsg;
    View.OnClickListener localOnClickListener = localAbsShareMsg.getOnClickListener();
    paramView.setOnClickListener(new agpt(this, localAbsShareMsg, paramMessageForStructing, paramChatMessage, paramChatMessage.time, localOnClickListener));
    a(paramBaseChatItemLayout, paramMessageForStructing, paramAbsStructMsg);
    if (uem.a(paramAbsStructMsg)) {
      paramView.setOnClickListener(null);
    }
    for (;;)
    {
      c(paramView, paramAbsStructMsg);
      a(paramView, paramAbsStructMsg, localAbsShareMsg);
      return;
      if (paramAbsStructMsg.mMsgServiceID == 78) {
        a(paramView, (AbsShareMsg)paramAbsStructMsg);
      }
    }
  }
  
  private static void b(String paramString, URL paramURL, ThumbWidthHeightDP paramThumbWidthHeightDP)
  {
    CompressInfo localCompressInfo = new CompressInfo(paramString, 0);
    localCompressInfo.f = true;
    paramString = AbsDownloader.getFilePath(paramURL.toString());
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
        ThreadManager.getUIHandler().post(new StructingMsgItemBuilder.11(paramString));
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
        if (ayeu.b(localCompressInfo))
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
          bool = FileUtil.copyFile(new File(localCompressInfo.c), paramString);
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
          ThreadManager.getUIHandler().post(new StructingMsgItemBuilder.12(paramString));
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
  
  private void c(View paramView, AbsStructMsg paramAbsStructMsg)
  {
    if ((paramAbsStructMsg.mMsgServiceID == 76) || (paramAbsStructMsg.mMsgServiceID == 106))
    {
      paramView.setOnClickListener(null);
      if (paramAbsStructMsg.mMsgServiceID != 106)
      {
        paramView.setOnLongClickListener(null);
        paramView.setOnTouchListener(null);
      }
    }
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
          if ((paramChatMessage.getItemByIndex(i) instanceof bcjo)) {
            return true;
          }
          i += 1;
        }
      }
    }
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_Bjsv != null) && (this.jdField_a_of_type_Bjsv.isShowing())) {
      this.jdField_a_of_type_Bjsv.dismiss();
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public aeze a(View paramView)
  {
    try
    {
      ChatMessage localChatMessage = AIOUtils.getMessage(paramView);
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
          return (aeze)paramView.findViewById(2131368548);
        }
      } while ((((MessageForStructing)localObject).structingMsg == null) || (((MessageForStructing)localObject).structingMsg.mMsgServiceID != 107));
      Object localObject = paramView.findViewById(2131376010);
      if (localObject != null) {
        return (aeze)((View)localObject).getTag(-1);
      }
      paramView = "getTouchDelegate when receipt message but the root view is null \r\n" + paramView;
      bcdb.a(new IllegalStateException(paramView), "StructingMsgItemBuilderCatchedException" + paramView);
    }
    return null;
  }
  
  protected agpx a()
  {
    return new agpx();
  }
  
  public Context a()
  {
    return this.jdField_a_of_type_AndroidContentContext;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, afce paramafce)
  {
    this.jdField_a_of_type_Bcip.a();
    int i;
    MessageForStructing localMessageForStructing;
    AbsStructMsg localAbsStructMsg;
    if (paramView == null)
    {
      i = 1;
      localMessageForStructing = (MessageForStructing)paramChatMessage;
      localAbsStructMsg = localMessageForStructing.structingMsg;
      if (localAbsStructMsg != null) {
        break label42;
      }
    }
    label42:
    int j;
    do
    {
      return paramView;
      i = 2;
      break;
      if (localAbsStructMsg.mMsgServiceID == 81) {
        xwa.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, localMessageForStructing, "exp");
      }
      a(paramChatMessage, localAbsStructMsg);
      int k = -1;
      j = k;
      if (paramView != null)
      {
        j = k;
        if ((paramView.getTag() instanceof aezf)) {
          j = ((aezf)paramView.getTag()).jdField_b_of_type_Int;
        }
      }
      localAbsStructMsg.message = localMessageForStructing;
      paramViewGroup = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramafce);
      b(paramViewGroup, localAbsStructMsg);
      a(paramViewGroup, localAbsStructMsg);
      paramafce = (agpx)paramViewGroup.getTag();
      paramView = paramViewGroup;
    } while (paramafce == null);
    paramView = paramafce.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
    a(i, localAbsStructMsg, j, paramafce);
    if ((localAbsStructMsg instanceof AbsShareMsg)) {}
    for (paramInt2 = ((AbsShareMsg)localAbsStructMsg).mContentLayout;; paramInt2 = -1)
    {
      a(localAbsStructMsg);
      Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
      boolean bool = a(localMessageForStructing);
      if (QLog.isDevelopLevel()) {
        QLog.d("StructingMsgItemBuilder", 4, "getView:position:" + paramInt1 + "hasHead" + bool);
      }
      a(paramafce, paramView, bool);
      a(paramafce, paramView, localMessageForStructing.isSend(), localAbsStructMsg, localResources, bool);
      if (((localAbsStructMsg instanceof StructMsgForGeneralShare)) && (((StructMsgForGeneralShare)localAbsStructMsg).mHasAdSource)) {
        a(paramafce, paramView, localMessageForStructing.isSend(), (StructMsgForGeneralShare)localAbsStructMsg, localResources, bool);
      }
      if ((paramafce != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
        a(paramChatMessage, paramafce, paramView);
      }
      a((BaseChatItemLayout)paramViewGroup, localMessageForStructing, paramView, localResources, bool);
      paramViewGroup.requestLayout();
      a(paramChatMessage, localAbsStructMsg, paramafce);
      paramView = (bfas)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(132);
      if (paramView.b(paramChatMessage))
      {
        paramView.a(paramChatMessage.uniseq);
        paramafce.jdField_a_of_type_AndroidViewView.setVisibility(8);
        paramView = AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidContentContext, 2130772219);
        paramView.setAnimationListener(new agpg(this, paramafce));
        paramafce.jdField_a_of_type_AndroidViewView.postDelayed(new StructingMsgItemBuilder.2(this, paramafce, paramView), 300L);
      }
      this.jdField_a_of_type_Bcip.a(paramInt2, i);
      oge.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, paramViewGroup);
      return paramViewGroup;
    }
  }
  
  public View a(ChatMessage paramChatMessage, aezf paramaezf, View paramView, BaseChatItemLayout paramBaseChatItemLayout, afce paramafce)
  {
    Object localObject1 = null;
    Bundle localBundle = new Bundle();
    if (((this.jdField_a_of_type_AndroidContentContext instanceof ChatActivity)) || ((this.jdField_a_of_type_AndroidContentContext instanceof SplashActivity))) {
      localObject1 = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a().getViewCache();
    }
    Object localObject2;
    Object localObject3;
    MessageForStructing localMessageForStructing;
    AbsStructMsg localAbsStructMsg;
    if (paramView == null)
    {
      localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources();
      paramView = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramView.setId(2131364441);
      paramView.setMinimumHeight(AIOUtils.dp2px(44.0F, (Resources)localObject2));
      paramView.setClickable(true);
      paramView.setPadding(BaseChatItemLayout.j, BaseChatItemLayout.h, BaseChatItemLayout.k, BaseChatItemLayout.i);
      paramView.setBackgroundResource(2130838054);
      localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      int i = ((Resources)localObject2).getDimensionPixelSize(2131298976);
      ((RelativeLayout.LayoutParams)localObject3).setMargins(i, 0, i, 0);
      ((RelativeLayout.LayoutParams)localObject3).addRule(1, 2131368236);
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
      paramaezf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setMiniAioShieldItemTouchListener(this);
      localMessageForStructing = (MessageForStructing)paramChatMessage;
      localAbsStructMsg = localMessageForStructing.structingMsg;
      if (localAbsStructMsg != null) {
        break label287;
      }
      if (QLog.isColorLevel())
      {
        paramaezf = new StringBuilder().append("structMsg is null,msgdata:");
        if (localMessageForStructing != null) {
          break label259;
        }
        paramChatMessage = "null";
      }
    }
    for (;;)
    {
      QLog.d("structMsg", 2, paramChatMessage);
      return paramView;
      if (!c(paramChatMessage)) {
        ((ViewGroup)paramView).removeAllViews();
      }
      break;
      label259:
      if (localMessageForStructing.msgData == null) {
        paramChatMessage = "null";
      } else {
        paramChatMessage = Integer.valueOf(localMessageForStructing.msgData.length);
      }
    }
    label287:
    localAbsStructMsg.message = localMessageForStructing;
    a(paramChatMessage, localBundle, localAbsStructMsg);
    a(localBundle, localMessageForStructing, localAbsStructMsg);
    a(localMessageForStructing, localAbsStructMsg, localBundle);
    a(localMessageForStructing, localAbsStructMsg);
    paramBaseChatItemLayout.setAddStatesFromChildren(false);
    paramaezf = paramBaseChatItemLayout.getTag();
    if (paramaezf != null) {}
    for (paramaezf = (agpx)paramaezf;; paramaezf = null)
    {
      if (paramaezf == null) {
        paramaezf = a();
      }
      for (;;)
      {
        paramaezf.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
        localObject3 = paramaezf.jdField_a_of_type_AndroidWidgetRelativeLayout;
        localObject2 = localObject3;
        if (localObject3 == null)
        {
          localObject2 = (RelativeLayout)paramView;
          paramaezf.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject2);
          paramaezf.jdField_a_of_type_AndroidWidgetRelativeLayout.setId(2131377867);
        }
        paramView.setTag(paramaezf);
        if (d(paramChatMessage)) {
          paramaezf.jdField_a_of_type_Boolean = true;
        }
        for (;;)
        {
          if ((localAbsStructMsg instanceof StructMsgForGeneralShare))
          {
            localObject1 = a(paramChatMessage, (ViewGroup)paramView, paramafce, (agpy)localObject1, localBundle, localMessageForStructing, localAbsStructMsg);
            paramView.setOnTouchListener(paramafce);
            paramView.setOnLongClickListener(paramafce);
            a(paramChatMessage, paramView, paramBaseChatItemLayout, localMessageForStructing, localAbsStructMsg);
          }
          try
          {
            ((RelativeLayout)localObject2).addView((View)localObject1);
            a(paramChatMessage, localAbsStructMsg, (RelativeLayout)localObject2);
            a(localMessageForStructing, localAbsStructMsg, paramaezf, (RelativeLayout)localObject2);
            a(paramChatMessage, paramView, localMessageForStructing, localAbsStructMsg);
            f();
            a(paramChatMessage, paramBaseChatItemLayout, localMessageForStructing);
            a(paramChatMessage, paramaezf);
            return paramView;
            paramaezf.jdField_a_of_type_Boolean = false;
            continue;
            localObject1 = a(paramChatMessage, paramafce, localBundle, localAbsStructMsg, (RelativeLayout)localObject2, null);
          }
          catch (IllegalStateException paramafce)
          {
            for (;;)
            {
              ((ViewGroup)((View)localObject1).getParent()).removeAllViews();
              ((RelativeLayout)localObject2).addView((View)localObject1);
            }
          }
        }
      }
    }
  }
  
  public bgaz a(bgaz parambgaz, ChatMessage paramChatMessage, aezy paramaezy)
  {
    paramaezy = (MessageForStructing)paramChatMessage;
    paramChatMessage = paramaezy.structingMsg;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramChatMessage != null) {
      if (a(paramaezy, paramChatMessage)) {}
    }
    while (!bool1)
    {
      return parambgaz;
      paramaezy = this.jdField_a_of_type_AndroidContentContext.getResources();
      bool1 = bool2;
      if (paramChatMessage.fwFlag != 1)
      {
        a(parambgaz, paramChatMessage, paramaezy);
        bool1 = a(paramChatMessage);
      }
    }
    parambgaz.a(2131366347, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692036), 2130838970);
    return parambgaz;
  }
  
  public QQAppInterface a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (bfwr.a(paramChatMessage.issend)) {
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
    if (!this.jdField_a_of_type_Agqa.a(paramInt, paramContext, paramChatMessage)) {
      super.a(paramInt, paramContext, paramChatMessage);
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
    Context localContext = this.jdField_a_of_type_AndroidContentContext;
    ChatMessage localChatMessage = ((agpx)AIOUtils.getHolder(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (localChatMessage.isMultiMsg) {}
    Object localObject;
    do
    {
      return;
      localObject = a(localChatMessage);
      if (localObject != null)
      {
        a(paramView, (StructMsgForGeneralShare)localObject);
        return;
      }
      paramView = localContext.getString(2131689947);
      localObject = localContext.getString(2131689948);
    } while (!localChatMessage.isSendFromLocal());
    String str1 = localChatMessage.getExtInfoFromExtStr("errorString");
    String str2 = localChatMessage.getExtInfoFromExtStr("retCode");
    String str3 = localChatMessage.getExtInfoFromExtStr("import_file_message_flag");
    if ((str3 != null) && ("import_file_message_flag_value".equals(str3)))
    {
      a(localChatMessage, str1, str2);
      return;
    }
    bfur.a(localContext, 230, paramView, (String)localObject, new agpq(this, localChatMessage, localContext), new agpr(this)).show();
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    super.a(paramView, paramChatMessage);
    MessageForStructing localMessageForStructing;
    int i;
    if ((paramChatMessage instanceof MessageForStructing))
    {
      localMessageForStructing = (MessageForStructing)paramChatMessage;
      boolean bool = uem.a(localMessageForStructing.structingMsg);
      if (((bool) && (!localMessageForStructing.structingMsg.hasFlag(4))) || (localMessageForStructing.structingMsg.mMsgServiceID == 83) || (localMessageForStructing.structingMsg.mMsgServiceID == 108) || (localMessageForStructing.structingMsg.mMsgServiceID == 151) || (localMessageForStructing.structingMsg.mMsgServiceID == 156))
      {
        if ((!bool) || (localMessageForStructing.structingMsg.hasFlag(4))) {
          break label201;
        }
        i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296388);
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
        paramView.setPadding(AIOUtils.dp2px(1.5F, paramChatMessage), AIOUtils.dp2px(2.0F, paramChatMessage), AIOUtils.dp2px(1.5F, paramChatMessage), paramView.getPaddingBottom());
      }
      return;
      label201:
      if ((localMessageForStructing.structingMsg.mMsgServiceID == 114) || (localMessageForStructing.structingMsg.mMsgServiceID == 116))
      {
        i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296389);
        break;
      }
      i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296393);
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
      if (((localObject instanceof agpx)) && ((paramChatMessage instanceof MessageForStructing)))
      {
        localObject = (agpx)localObject;
        BaseChatItemLayout localBaseChatItemLayout = ((agpx)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
        paramChatMessage = (MessageForStructing)paramChatMessage;
        AbsStructMsg localAbsStructMsg = paramChatMessage.structingMsg;
        if (localAbsStructMsg != null) {
          localAbsStructMsg.message = paramChatMessage;
        }
        a((agpx)localObject, localBaseChatItemLayout, paramChatMessage.isSend(), localAbsStructMsg, paramView.getResources(), a(paramChatMessage));
      }
      return;
    }
    super.a(paramView, paramChatMessage, paramInt);
  }
  
  public void a(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    if (!BaseChatItemLayout.class.isInstance(paramView)) {}
    do
    {
      return;
      if ((paramFileMsg.fileType == 1) || (paramFileMsg.fileType == 131075))
      {
        b(paramView, paramFileMsg, paramInt1, paramInt2);
        return;
      }
    } while (paramFileMsg.fileType != 52);
    c(paramView, paramFileMsg, paramInt1, paramInt2);
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    super.a(paramChatMessage);
  }
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, aezf paramaezf, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramaezf, paramInt1, paramInt2);
    paramBaseChatItemLayout = (MessageForStructing)paramChatMessage;
    int i;
    int j;
    int k;
    boolean bool;
    if (a(paramBaseChatItemLayout, paramBaseChatItemLayout.structingMsg.mMsgServiceID))
    {
      paramInt1 = paramaezf.jdField_a_of_type_AndroidViewView.getPaddingLeft();
      paramInt2 = paramaezf.jdField_a_of_type_AndroidViewView.getPaddingRight();
      i = paramaezf.jdField_a_of_type_AndroidViewView.getPaddingTop();
      j = paramaezf.jdField_a_of_type_AndroidViewView.getPaddingBottom();
      k = AIOUtils.dp2px(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      bool = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (!paramChatMessage.isSend()) {
        break label144;
      }
      paramInt1 = b(paramChatMessage, paramContext, paramaezf, paramInt1, k, bool, 2130849923, 2130849920, 2130849919);
    }
    for (;;)
    {
      paramaezf.jdField_a_of_type_AndroidViewView.setPadding(paramInt1, i, paramInt2, j);
      return;
      label144:
      paramInt2 = a(paramChatMessage, paramContext, paramaezf, paramInt2, k, bool, 2130849747, 2130849744, 2130849743);
    }
  }
  
  protected void a(MessageForStructing paramMessageForStructing) {}
  
  public void a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage, long paramLong, float paramFloat) {}
  
  public void a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage, boolean paramBoolean)
  {
    paramXListView = AIOUtils.getHolder(paramView);
    if ((paramXListView instanceof agpx)) {}
    for (paramXListView = (agpx)paramXListView;; paramXListView = null)
    {
      if (paramXListView != null)
      {
        paramXListView = (ViewGroup)paramXListView.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
        int i = paramXListView.getChildCount();
        paramInt = 0;
        while (paramInt < i)
        {
          if ((paramXListView.getChildAt(paramInt).getTag() instanceof bcjf))
          {
            paramView = (bcjf)paramXListView.getChildAt(paramInt).getTag();
            if ((paramView.jdField_a_of_type_AndroidViewView.getTag() instanceof bclo))
            {
              paramView = (ImageView)((bclo)paramView.jdField_a_of_type_AndroidViewView.getTag()).jdField_c_of_type_AndroidViewView;
              paramView.clearAnimation();
              paramView.setBackgroundResource(2130841827);
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
  
  public boolean a(aezf paramaezf)
  {
    return paramaezf instanceof agpx;
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
      paramString2 = bchh.a(paramString1.getExtras());
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
        localObject = ((StructMsgForImageShare)((MessageForStructing)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getMsgItemByUniseq(paramChatMessage.frienduin, paramChatMessage.istroop, paramChatMessage.uniseq)).structingMsg).getFirstImageElement();
        if ((localObject == null) || (((bcjc)localObject).d > 0L)) {
          break;
        }
        paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().findProcessor(paramChatMessage.frienduin, paramChatMessage.uniseq);
        if ((paramChatMessage instanceof BaseTransProcessor))
        {
          if (((BaseTransProcessor)paramChatMessage).getFileStatus() == 1005L) {}
          for (boolean bool = true;; bool = false) {
            return bool;
          }
        }
        return true;
      }
      if (b((MessageForStructing)localObject))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().findProcessor(((MessageForStructing)localObject).frienduin, ((MessageForStructing)localObject).uniseq) != null) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("StructingMsgItemBuilder", 2, "isFailed| Sdk share msg, processor not exist.");
        }
        return true;
      }
    } while ((((MessageForStructing)localObject).structingMsg != null) && ((((MessageForStructing)localObject).structingMsg instanceof StructMsgForGeneralShare)) && (((StructMsgForGeneralShare)((MessageForStructing)localObject).structingMsg).mMsgServiceID == 95) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().c(paramChatMessage)));
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
      if (ugf.b(paramAbsShareMsg.mMsgUrl)) {
        return true;
      }
    } while (((TextUtils.isEmpty(paramAbsShareMsg.mSource_A_ActionData)) || (!paramAbsShareMsg.mSource_A_ActionData.contains("pubaccount"))) && ((TextUtils.isEmpty(paramAbsShareMsg.mSource_I_ActionData)) || (!paramAbsShareMsg.mSource_I_ActionData.contains("public_account"))));
    return true;
  }
  
  protected boolean a(AbsStructMsg paramAbsStructMsg)
  {
    return (!paramAbsStructMsg.hasFlag(2)) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType != 1008) || (!TextUtils.isEmpty(paramAbsStructMsg.mMsgUrl))) && (paramAbsStructMsg.mMsgServiceID != 81) && (paramAbsStructMsg.mMsgServiceID != 14);
  }
  
  public boolean a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage)
  {
    paramXListView = AIOUtils.getHolder(paramView);
    if ((paramXListView instanceof agpx)) {}
    for (paramXListView = (agpx)paramXListView;; paramXListView = null)
    {
      if (paramXListView != null)
      {
        paramXListView = (ViewGroup)paramXListView.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
        int i = paramXListView.getChildCount();
        paramInt = 0;
        while (paramInt < i)
        {
          if ((paramXListView.getChildAt(paramInt).getTag() instanceof bcjf))
          {
            paramView = (bcjf)paramXListView.getChildAt(paramInt).getTag();
            if ((paramView.jdField_a_of_type_AndroidViewView.getTag() instanceof bclo)) {
              return FileUtils.fileExistsAndNotEmpty(((bclo)paramView.jdField_a_of_type_AndroidViewView.getTag()).jdField_a_of_type_JavaLangString);
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
    Object localObject = AIOUtils.getHolder(paramView);
    if ((localObject instanceof agpx)) {}
    for (localObject = (agpx)localObject;; localObject = null)
    {
      if (localObject != null)
      {
        localObject = (ViewGroup)((agpx)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
        int i = ((ViewGroup)localObject).getChildCount();
        paramInt2 = 0;
        while (paramInt2 < i)
        {
          if (((((ViewGroup)localObject).getChildAt(paramInt2).getTag() instanceof bcjf)) && (a(paramXListView, paramInt1, paramView, paramChatMessage)))
          {
            bcjf localbcjf = (bcjf)((ViewGroup)localObject).getChildAt(paramInt2).getTag();
            if ((localbcjf.jdField_a_of_type_AndroidViewView.getTag() instanceof bclo)) {
              paramAudioPlayerBase.a(((bclo)localbcjf.jdField_a_of_type_AndroidViewView.getTag()).jdField_a_of_type_JavaLangString);
            }
          }
          paramInt2 += 1;
        }
        return true;
      }
      return false;
    }
  }
  
  public bgbb[] a(View paramView)
  {
    paramView = (MessageForStructing)AIOUtils.getMessage(paramView);
    bgaz localbgaz = new bgaz();
    if (paramView != null)
    {
      if (!paramView.isMultiMsg) {
        break label40;
      }
      a(localbgaz, paramView, null);
    }
    for (;;)
    {
      return localbgaz.a();
      label40:
      b(localbgaz, paramView, null);
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
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5A7", "0X800A5A7", 0, 0, "" + i, "", "", "");
      return;
    }
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public bgaz b(bgaz parambgaz, ChatMessage paramChatMessage, aezy paramaezy)
  {
    return this.jdField_a_of_type_Agqa.a(parambgaz, paramChatMessage, paramaezy);
  }
  
  protected void b(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    paramView = AIOUtils.getHolder(paramView);
    if (!agpx.class.isInstance(paramView)) {}
    ChatMessage localChatMessage;
    do
    {
      do
      {
        return;
        paramView = (agpx)paramView;
      } while ((!agpx.class.isInstance(paramView)) || (paramView.jdField_a_of_type_AndroidWidgetRelativeLayout == null) || (!MessageForStructing.class.isInstance(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage)));
      localChatMessage = paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if ((localChatMessage.uniseq == paramFileMsg.uniseq) && (localChatMessage.isSendFromLocal()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("structMsg", 2, "handleMessage status = " + paramInt1 + ", retCode = " + paramInt2 + ", message.uniseq = " + localChatMessage.uniseq + ", file.uniseq = " + paramFileMsg.uniseq);
        }
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().findProcessor(localChatMessage.frienduin, localChatMessage.uniseq), paramView);
        if (paramInt1 == 1005) {
          b();
        }
      }
    } while ((localChatMessage.uniseq != paramFileMsg.uniseq) || (paramInt1 != 2003) || (!(((MessageForStructing)localChatMessage).structingMsg instanceof StructMsgForImageShare)));
    paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
    paramFileMsg = new Bundle();
    paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(((MessageForStructing)localChatMessage).structingMsg.getView(this.jdField_a_of_type_AndroidContentContext, null, null, paramFileMsg));
  }
  
  public boolean b(ChatMessage paramChatMessage)
  {
    return true;
  }
  
  protected void c(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    paramView = AIOUtils.getHolder(paramView);
    if (!agpx.class.isInstance(paramView)) {}
    do
    {
      do
      {
        do
        {
          return;
          paramView = (agpx)paramView;
        } while ((!agpx.class.isInstance(paramView)) || (paramView.jdField_a_of_type_AndroidWidgetRelativeLayout == null) || (!MessageForStructing.class.isInstance(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage)));
        paramView = paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      } while ((paramView.uniseq != paramFileMsg.uniseq) || (!paramView.isSendFromLocal()));
      if (QLog.isColorLevel()) {
        QLog.d("structMsg", 2, "handleMessage status = " + paramInt1 + ", retCode = " + paramInt2 + ", message.uniseq = " + paramView.uniseq + ", file.uniseq = " + paramFileMsg.uniseq);
      }
    } while ((paramInt1 != 1005) && (paramInt1 != 1001) && (paramInt1 != 1003) && (paramInt1 != 1004) && (paramInt1 != 1002));
    b();
  }
  
  public void c(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    AbsStructMsg localAbsStructMsg = ((MessageForStructing)paramChatMessage).structingMsg;
    if ((localAbsStructMsg != null) && (StructMsgForImageShare.class.isInstance(localAbsStructMsg)))
    {
      paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().findProcessor(paramChatMessage.frienduin, paramChatMessage.uniseq);
      if ((paramChatMessage != null) && (BaseTransProcessor.class.isInstance(paramChatMessage)))
      {
        a(paramBaseChatItemLayout, ((BaseTransProcessor)paramChatMessage).getFileMsg(), 0, 0);
        return;
      }
      paramBaseChatItemLayout.setProgressVisable(false);
      return;
    }
    super.c(paramChatMessage, paramBaseChatItemLayout);
  }
  
  public void d(ChatMessage paramChatMessage)
  {
    super.d(paramChatMessage);
  }
  
  protected void e()
  {
    long l1 = 1L;
    bgre localbgre = (bgre)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(76);
    bgrd localbgrd = localbgre.a();
    if ((localbgrd != null) && (localbgrd.d == 0L) && (localbgrd.a != 0L)) {
      localbgre.a(localbgrd.a);
    }
    long l2;
    if ((localbgrd != null) && (localbgrd.d == 1L))
    {
      l2 = localbgre.a - (NetConnInfoCenter.getServerTimeMillis() - localbgrd.e);
      if (l2 > 0L) {
        break label127;
      }
    }
    for (;;)
    {
      new Handler(this.jdField_a_of_type_AndroidContentContext.getMainLooper()).postDelayed(new StructingMsgItemBuilder.4(this, localbgrd, localbgre), l1);
      return;
      label127:
      l1 = l2;
    }
  }
  
  public void onClick(View paramView)
  {
    BaseChatPie localBaseChatPie;
    StructMsgForImageShare localStructMsgForImageShare;
    bcjc localbcjc;
    if (paramView.getId() == 2131365813)
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
      localObject = (MessageForStructing)((agpx)AIOUtils.getHolder(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if ((localObject == null) || (((MessageForStructing)localObject).structingMsg == null) || (!(((MessageForStructing)localObject).structingMsg instanceof StructMsgForImageShare))) {
        break label218;
      }
      localStructMsgForImageShare = (StructMsgForImageShare)((MessageForStructing)localObject).structingMsg;
      localbcjc = localStructMsgForImageShare.getFirstImageElement();
      if (localbcjc == null) {
        break label218;
      }
    }
    label180:
    label199:
    label218:
    for (Object localObject = new aqwf(localbcjc.ad, localbcjc.ae, localbcjc.c, localStructMsgForImageShare.rawUrl, ((MessageForStructing)localObject).senderuin);; localObject = null)
    {
      localBaseChatPie.getUIHandler().obtainMessage(79, localObject).sendToTarget();
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