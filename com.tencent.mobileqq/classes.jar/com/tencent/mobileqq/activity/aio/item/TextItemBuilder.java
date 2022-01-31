package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.ClipboardManager;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.RelativeSizeSpan;
import android.text.util.Linkify;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.etrump.mixlayout.ETEngine;
import com.etrump.mixlayout.ETFont;
import com.etrump.mixlayout.ETTextView;
import com.etrump.mixlayout.FontInfo;
import com.etrump.mixlayout.FontManager;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.TouchDelegate;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.qim.QIMUserManager;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAiAppCenter;
import com.tencent.mobileqq.ark.ArkAiDictMgr;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkAppDataReport;
import com.tencent.mobileqq.ark.ArkAppHandler;
import com.tencent.mobileqq.ark.ArkRecommendController;
import com.tencent.mobileqq.ark.ArkRecommendController.ArkAtBabyqGrayTipConfig;
import com.tencent.mobileqq.ark.ArkRecommendController.AttachAppHolder;
import com.tencent.mobileqq.ark.ArkRecommendLogic;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.HiBoomMessage;
import com.tencent.mobileqq.data.MessageForHiBoom;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.RecommendCommonMessage;
import com.tencent.mobileqq.data.RecommendCommonMessage.ArkContextInfo;
import com.tencent.mobileqq.data.RecommendCommonMessage.ArkMsgAppInfo;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.lovelanguage.LoveLanguageManager;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ArkAppReportController;
import com.tencent.mobileqq.statistics.QQCatchedExceptionReporter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQText.ArkHighlightSpan;
import com.tencent.mobileqq.text.QQText.LinkSpan;
import com.tencent.mobileqq.troop.utils.TroopRobotManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.vip.AioVipKeywordHelper;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.AnimationTextView.OnDoubleClick;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import com.tencent.util.Pair;
import com.tencent.widget.ListView;
import com.tencent.widget.XListView;
import com.tencent.wordsegment.WordSegment;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import vil;
import vim;
import vin;
import vio;
import vip;
import viq;
import vir;
import vis;
import vit;
import viu;
import viv;

public class TextItemBuilder
  extends BaseBubbleBuilder
  implements Handler.Callback, BaseBubbleBuilder.TouchDelegate
{
  public static final LRULinkedHashMap a;
  public static final int d = BaseChatItemLayout.g + BaseChatItemLayout.l;
  protected static final int e = BaseChatItemLayout.h + BaseChatItemLayout.m;
  public static final int f = BaseChatItemLayout.i + BaseChatItemLayout.n;
  public static final int g = BaseChatItemLayout.j + BaseChatItemLayout.o;
  protected AnimationTextView.OnDoubleClick a;
  public Handler b;
  protected View.OnClickListener b;
  protected View.OnClickListener c = new vin(this);
  
  static
  {
    jdField_a_of_type_ComTencentUtilLRULinkedHashMap = new LRULinkedHashMap(50);
  }
  
  public TextItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_b_of_type_AndroidOsHandler = null;
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new vil(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick = new viv(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext);
    this.jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  }
  
  public static String a(String paramString, boolean paramBoolean)
  {
    if (android.text.TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    paramString = new StringBuilder(paramString);
    int k = paramString.length();
    int i = 0;
    if (i < k)
    {
      int j = i;
      if ('\024' == paramString.charAt(i))
      {
        j = i;
        if (i + 1 < k)
        {
          j = i;
          if ('ÿ' == paramString.charAt(i + 1))
          {
            j = i;
            if (i + 2 < k)
            {
              if (!paramBoolean) {
                break label116;
              }
              if (paramString.charAt(i + 2) == '\024') {
                paramString.setCharAt(i + 2, 'ý');
              }
            }
          }
        }
      }
      for (;;)
      {
        j = i + 4;
        i = j + 1;
        break;
        label116:
        if (paramString.charAt(i + 2) == 'ý') {
          paramString.setCharAt(i + 2, '\024');
        }
      }
    }
    return paramString.toString();
  }
  
  private void a(Spannable paramSpannable)
  {
    int i = 0;
    QQText.ArkHighlightSpan[] arrayOfArkHighlightSpan = (QQText.ArkHighlightSpan[])paramSpannable.getSpans(0, paramSpannable.length(), QQText.ArkHighlightSpan.class);
    if ((arrayOfArkHighlightSpan != null) && (arrayOfArkHighlightSpan.length > 0))
    {
      int j = arrayOfArkHighlightSpan.length;
      while (i < j)
      {
        QQText.ArkHighlightSpan localArkHighlightSpan = arrayOfArkHighlightSpan[i];
        if (localArkHighlightSpan != null)
        {
          localArkHighlightSpan.a = null;
          paramSpannable.removeSpan(localArkHighlightSpan);
        }
        i += 1;
      }
    }
  }
  
  private void a(TextItemBuilder.Holder paramHolder, ChatMessage paramChatMessage, ColorStateList paramColorStateList1, ColorStateList paramColorStateList2)
  {
    paramColorStateList2 = paramHolder.e.getTag(2131363702);
    if ((paramColorStateList2 != null) && (paramColorStateList2.equals("school_troop_span"))) {
      break label26;
    }
    label26:
    label347:
    label350:
    for (;;)
    {
      return;
      if ((paramHolder.e instanceof ETTextView))
      {
        paramColorStateList2 = (ETTextView)paramHolder.e;
        MessageForText localMessageForText;
        if ((paramChatMessage instanceof MessageForText))
        {
          localMessageForText = (MessageForText)paramChatMessage;
          if (!android.text.TextUtils.isEmpty(localMessageForText.sb2)) {
            paramChatMessage = localMessageForText.sb2.toString();
          }
        }
        for (;;)
        {
          if (android.text.TextUtils.isEmpty(paramChatMessage)) {
            break label350;
          }
          Spannable localSpannable = (Spannable)paramColorStateList2.getText();
          if (QLog.isColorLevel()) {
            QLog.d("ChatItemBuilder", 2, "updateArkHighlight msg content=" + Utils.a(paramChatMessage) + ", spanStr=" + Utils.a(localSpannable.toString()));
          }
          if (localMessageForText.isArkAtBabyQMsg()) {
            break;
          }
          int[] arrayOfInt = a(paramChatMessage, localMessageForText);
          if (arrayOfInt != null)
          {
            paramColorStateList2.jdField_b_of_type_Boolean = true;
            if (a(paramHolder, localSpannable))
            {
              if (arrayOfInt.length == 3)
              {
                if (a(paramChatMessage, localSpannable, arrayOfInt[0], arrayOfInt[1])) {
                  break;
                }
                a(paramHolder, localMessageForText, localSpannable, paramColorStateList1, arrayOfInt[0], arrayOfInt[1], arrayOfInt[2]);
                return;
                if (android.text.TextUtils.isEmpty(localMessageForText.sb)) {
                  break label347;
                }
                paramChatMessage = localMessageForText.sb.toString();
                continue;
              }
              int i = 0;
              while (i < arrayOfInt.length)
              {
                if (!a(paramChatMessage, localSpannable, arrayOfInt[i], arrayOfInt[(i + 1)])) {
                  a(paramHolder, localMessageForText, localSpannable, paramColorStateList1, arrayOfInt[i], arrayOfInt[(i + 1)], arrayOfInt[(i + 2)]);
                }
                i += 3;
              }
              break label26;
            }
            a(localSpannable);
            return;
          }
          a(localSpannable);
          paramColorStateList2.jdField_b_of_type_Boolean = false;
          return;
          paramChatMessage = null;
        }
      }
    }
  }
  
  private void a(TextItemBuilder.Holder paramHolder, MessageForText paramMessageForText, Spannable paramSpannable, ColorStateList paramColorStateList, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramMessageForText.mContextList.size() > 0)
    {
      localArkContextInfo = (RecommendCommonMessage.ArkContextInfo)paramMessageForText.mContextList.get(paramInt3);
      if (localArkContextInfo.contextAppInfoList.size() > 0) {
        if (a(paramSpannable, paramInt1, paramInt2)) {
          a(paramHolder, paramMessageForText, paramSpannable, paramColorStateList, paramInt1, paramInt2, paramInt3);
        }
      }
    }
    while (!a(paramSpannable, paramInt1, paramInt2))
    {
      RecommendCommonMessage.ArkContextInfo localArkContextInfo;
      return;
      RecommendCommonMessage.getAppInfosByContext(localArkContextInfo, new vir(this, localArkContextInfo, paramSpannable, paramInt1, paramInt2, paramHolder, paramMessageForText, paramColorStateList, paramInt3));
      return;
    }
    a(paramHolder, paramMessageForText, paramSpannable, paramColorStateList, paramInt1, paramInt2, paramInt3);
  }
  
  private void a(TextItemBuilder.Holder paramHolder, RecommendCommonMessage paramRecommendCommonMessage, Spannable paramSpannable, ColorStateList paramColorStateList, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject4 = paramRecommendCommonMessage.mOldAppInfo.keyword;
    Object localObject2 = localObject4;
    try
    {
      String str3 = paramRecommendCommonMessage.mOldAppInfo.appName;
      localObject2 = localObject4;
      String str4 = paramRecommendCommonMessage.mOldAppInfo.appView;
      String str2 = str3;
      Object localObject3 = localObject4;
      String str1 = str4;
      localObject2 = localObject4;
      Object localObject1;
      if (paramRecommendCommonMessage.mContextList.size() > 0)
      {
        str2 = str3;
        localObject3 = localObject4;
        str1 = str4;
        if (paramInt3 >= 0)
        {
          str2 = str3;
          localObject3 = localObject4;
          str1 = str4;
          localObject2 = localObject4;
          if (paramInt3 < paramRecommendCommonMessage.mContextList.size())
          {
            localObject2 = localObject4;
            RecommendCommonMessage.ArkContextInfo localArkContextInfo = (RecommendCommonMessage.ArkContextInfo)paramRecommendCommonMessage.mContextList.get(paramInt3);
            str2 = str3;
            localObject3 = localObject4;
            str1 = str4;
            if (localArkContextInfo != null)
            {
              localObject1 = localObject4;
              localObject2 = localObject4;
              if (!android.text.TextUtils.isEmpty(localArkContextInfo.keyword))
              {
                localObject2 = localObject4;
                localObject1 = localArkContextInfo.keyword;
              }
              str2 = str3;
              localObject3 = localObject1;
              str1 = str4;
              localObject2 = localObject1;
              if (localArkContextInfo.contextAppInfoList.size() > 0)
              {
                localObject2 = localObject1;
                localObject4 = (RecommendCommonMessage.ArkMsgAppInfo)localArkContextInfo.contextAppInfoList.get(0);
                str2 = str3;
                localObject3 = localObject1;
                str1 = str4;
                if (localObject4 != null)
                {
                  localObject2 = localObject1;
                  str2 = ((RecommendCommonMessage.ArkMsgAppInfo)localObject4).appName;
                  localObject2 = localObject1;
                  str1 = ((RecommendCommonMessage.ArkMsgAppInfo)localObject4).appView;
                  localObject3 = localObject1;
                }
              }
            }
          }
        }
      }
      localObject2 = localObject3;
      paramSpannable.setSpan(new QQText.ArkHighlightSpan(paramColorStateList.getDefaultColor(), new vis(this, paramRecommendCommonMessage, paramHolder, paramInt3, str2, localObject3, str1, paramSpannable)), paramInt1, paramInt2, 17);
      localObject2 = localObject3;
      if (QLog.isColorLevel())
      {
        localObject2 = localObject3;
        QLog.d("ChatItemBuilder", 2, "addArkHighlight msg=" + Utils.a(paramRecommendCommonMessage.msg) + ", start=" + paramInt1 + ", end=" + paramInt2 + ", contextIndex=" + paramInt3 + ", spannable=" + Utils.a(paramSpannable.toString()));
      }
      localObject2 = localObject3;
      if (!paramRecommendCommonMessage.mHasReportShowUnderline)
      {
        localObject2 = localObject3;
        ArkAppDataReport.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2, paramRecommendCommonMessage.mEchoType, paramRecommendCommonMessage.mContextMatchType);
        localObject2 = localObject3;
        if (4 == paramRecommendCommonMessage.mEchoType)
        {
          localObject2 = localObject3;
          ArkAppDataReport.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2, 0, paramRecommendCommonMessage.mContextMatchType);
        }
        localObject2 = localObject3;
        paramHolder = (ArkAppHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(95);
        localObject2 = localObject3;
        if (paramRecommendCommonMessage.isFromArkServer)
        {
          paramInt3 = 2;
          localObject2 = localObject3;
          paramSpannable = paramRecommendCommonMessage.arkServerExtraInfo;
          localObject2 = localObject3;
          paramColorStateList = paramRecommendCommonMessage.arkServerMsgId;
          localObject2 = localObject3;
          localObject1 = paramRecommendCommonMessage.msg;
          localObject2 = localObject3;
          if (!"1".equals(paramRecommendCommonMessage.getExtInfoFromExtStr("ark_text_analysis_flag"))) {
            break label795;
          }
          i = 1;
          label543:
          localObject2 = localObject3;
          paramHolder.a(paramInt3, 3, 1, paramSpannable, paramColorStateList, str2, str1, (String)localObject1, i, 1);
          localObject2 = localObject3;
          paramRecommendCommonMessage.mHasReportShowUnderline = true;
          localObject2 = localObject3;
          paramRecommendCommonMessage.saveRecommendMsg(new WeakReference(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, false);
        }
      }
      else
      {
        localObject2 = localObject3;
        if (!paramRecommendCommonMessage.mHasReportShowUnderlineEach)
        {
          localObject2 = localObject3;
          ArkAppDataReport.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2, paramRecommendCommonMessage.mEchoType, paramRecommendCommonMessage.mContextMatchType, localObject3);
          localObject2 = localObject3;
          if (4 == paramRecommendCommonMessage.mEchoType)
          {
            localObject2 = localObject3;
            ArkAppDataReport.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2, 0, paramRecommendCommonMessage.mContextMatchType, localObject3);
          }
          localObject2 = localObject3;
          paramHolder = (ArkAppHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(95);
          localObject2 = localObject3;
          if (!paramRecommendCommonMessage.isFromArkServer) {
            break label801;
          }
          paramInt3 = 2;
          label701:
          localObject2 = localObject3;
          paramSpannable = paramRecommendCommonMessage.arkServerExtraInfo;
          localObject2 = localObject3;
          paramColorStateList = paramRecommendCommonMessage.arkServerMsgId;
          localObject2 = localObject3;
          localObject1 = paramRecommendCommonMessage.msg;
          localObject2 = localObject3;
          if (!"1".equals(paramRecommendCommonMessage.getExtInfoFromExtStr("ark_text_analysis_flag"))) {
            break label808;
          }
        }
      }
      label795:
      label801:
      label808:
      for (int i = 1;; i = 0)
      {
        localObject2 = localObject3;
        paramHolder.a(paramInt3, 3, 1, paramSpannable, paramColorStateList, str2, str1, (String)localObject1, i, 0);
        localObject2 = localObject3;
        paramRecommendCommonMessage.mHasReportShowUnderlineEach = true;
        return;
        paramInt3 = 100;
        break;
        i = 0;
        break label543;
        paramInt3 = 100;
        break label701;
      }
      return;
    }
    catch (IndexOutOfBoundsException paramHolder)
    {
      QQCatchedExceptionReporter.reportQQCatchedException(paramHolder, "handleArkSpanCatchedException", "addArkHighlight IndexOutOfBoundsException=" + paramHolder + ", keyword=" + localObject2 + ", start=" + paramInt1 + ", end=" + paramInt2);
    }
  }
  
  private boolean a(Spannable paramSpannable, int paramInt1, int paramInt2)
  {
    boolean bool2 = true;
    int i = 0;
    Object localObject1 = (QQText.ArkHighlightSpan[])paramSpannable.getSpans(paramInt1, paramInt2, QQText.ArkHighlightSpan.class);
    boolean bool1 = bool2;
    if (localObject1 != null)
    {
      bool1 = bool2;
      if (localObject1.length > 0)
      {
        if (localObject1.length != 1) {
          break label116;
        }
        localObject1 = localObject1[0];
        if (localObject1 == null) {
          break label110;
        }
        i = paramSpannable.getSpanStart(localObject1);
        int j = paramSpannable.getSpanEnd(localObject1);
        if ((i != paramInt1) || (j != paramInt2)) {
          break label96;
        }
      }
    }
    label96:
    label110:
    for (bool1 = false;; bool1 = true)
    {
      return bool1;
      ((QQText.ArkHighlightSpan)localObject1).a = null;
      paramSpannable.removeSpan(localObject1);
    }
    label116:
    paramInt2 = localObject1.length;
    paramInt1 = i;
    for (;;)
    {
      bool1 = bool2;
      if (paramInt1 >= paramInt2) {
        break;
      }
      Object localObject2 = localObject1[paramInt1];
      if (localObject2 != null)
      {
        localObject2.a = null;
        paramSpannable.removeSpan(localObject2);
      }
      paramInt1 += 1;
    }
  }
  
  private boolean a(TextItemBuilder.Holder paramHolder, Spannable paramSpannable)
  {
    if ((paramHolder.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController$AttachAppHolder == null) || (!paramHolder.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController$AttachAppHolder.jdField_a_of_type_Boolean)) {
      return false;
    }
    paramHolder = (RelativeSizeSpan[])paramSpannable.getSpans(0, paramSpannable.length(), RelativeSizeSpan.class);
    return (paramHolder == null) || (paramHolder.length <= 0);
  }
  
  private boolean a(ChatMessage paramChatMessage, TextItemBuilder.Holder paramHolder)
  {
    int i = 0;
    boolean bool2 = false;
    int j;
    boolean bool1;
    if (((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)) && (paramChatMessage.isShowQIMStyleGroup))
    {
      i = Color.parseColor("#FFFFFFFF");
      j = Color.parseColor("#ff5078f0");
      paramHolder.e.setTextColor(i);
      paramHolder.e.setLinkTextColor(j);
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 0);
      bool1 = bool2;
    } while (!QIMUserManager.a().a(this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo));
    if (!paramChatMessage.isSend()) {
      i = 1;
    }
    if (i != 0) {
      j = Color.parseColor("#ff000000");
    }
    for (i = Color.parseColor("#ff80e9ff");; i = Color.parseColor("#ff5078f0"))
    {
      paramHolder.e.setTextColor(j);
      paramHolder.e.setLinkTextColor(i);
      return true;
      j = Color.parseColor("#FFFFFFFF");
    }
  }
  
  private boolean a(String paramString, Spannable paramSpannable, int paramInt1, int paramInt2)
  {
    QQText.LinkSpan[] arrayOfLinkSpan = (QQText.LinkSpan[])paramSpannable.getSpans(0, paramSpannable.length(), QQText.LinkSpan.class);
    if ((arrayOfLinkSpan != null) && (arrayOfLinkSpan.length > 0))
    {
      int j = arrayOfLinkSpan.length;
      int i = 0;
      while (i < j)
      {
        QQText.LinkSpan localLinkSpan = arrayOfLinkSpan[i];
        int k = paramSpannable.getSpanStart(localLinkSpan);
        int m = paramSpannable.getSpanEnd(localLinkSpan);
        if ((paramInt2 > k) && (paramInt1 < m))
        {
          if (!paramString.substring(k, m).matches("^[0-9]*$")) {
            return true;
          }
          paramSpannable.removeSpan(localLinkSpan);
        }
        i += 1;
      }
    }
    return false;
  }
  
  private int[] a(String paramString, MessageForText paramMessageForText)
  {
    int n = 0;
    if ((android.text.TextUtils.isEmpty(paramMessageForText.mOldAppInfo.keyword)) && (paramMessageForText.mContextList.size() <= 0)) {
      return null;
    }
    ArrayList localArrayList;
    HashMap localHashMap;
    int k;
    RecommendCommonMessage.ArkContextInfo localArkContextInfo;
    int j;
    int i;
    if (paramMessageForText.mContextList.size() > 0)
    {
      if (!paramMessageForText.atInfoParsed) {
        ArkRecommendLogic.a(paramMessageForText, paramMessageForText.getExtInfoFromExtStr("troop_at_info_list"));
      }
      localArrayList = new ArrayList();
      localHashMap = new HashMap();
      k = 0;
      if (k < paramMessageForText.mContextList.size())
      {
        localArkContextInfo = (RecommendCommonMessage.ArkContextInfo)paramMessageForText.mContextList.get(k);
        if (!android.text.TextUtils.isEmpty(localArkContextInfo.keyword))
        {
          j = paramString.indexOf(localArkContextInfo.keyword);
          if (j < 0) {
            break label558;
          }
          if ((localHashMap.containsKey(Integer.valueOf(j))) || (paramMessageForText.isIncludedByAt(j, localArkContextInfo.keyword.length()) >= 0)) {
            break label246;
          }
          i = 1;
        }
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        i = localArkContextInfo.keyword.length() + j;
        if (i <= paramString.length())
        {
          localArrayList.add(Integer.valueOf(j));
          localArrayList.add(Integer.valueOf(i));
          localArrayList.add(Integer.valueOf(k));
          localHashMap.put(Integer.valueOf(j), Integer.valueOf(i - j));
        }
      }
      k += 1;
      break;
      label246:
      i = 0;
      for (;;)
      {
        if (j >= 0) {
          if (!localHashMap.containsKey(Integer.valueOf(j)))
          {
            i = paramMessageForText.isIncludedByAt(j, localArkContextInfo.keyword.length());
            if (i < 0) {}
          }
          else
          {
            if (localHashMap.containsKey(Integer.valueOf(j))) {}
            int m;
            for (j = ((Integer)localHashMap.get(Integer.valueOf(j))).intValue() + j;; j = paramMessageForText.getAtLength(j) + i)
            {
              m = paramString.substring(j).indexOf(localArkContextInfo.keyword);
              if (m < 0) {
                break label407;
              }
              m = j + m;
              j = m;
              if (localHashMap.containsKey(Integer.valueOf(m))) {
                break label411;
              }
              j = m;
              if (paramMessageForText.isIncludedByAt(m, localArkContextInfo.keyword.length()) >= 0) {
                break label411;
              }
              i = 1;
              j = m;
              break;
            }
            label407:
            j = m;
            label411:
            continue;
            if ((localArrayList.size() > 0) && (localArrayList.size() % 3 == 0))
            {
              paramString = new int[localArrayList.size()];
              paramMessageForText = localArrayList.iterator();
              i = n;
              while (paramMessageForText.hasNext())
              {
                paramString[i] = ((Integer)paramMessageForText.next()).intValue();
                i += 1;
              }
              return paramString;
              if (!android.text.TextUtils.isEmpty(paramMessageForText.mOldAppInfo.keyword))
              {
                i = paramString.indexOf(paramMessageForText.mOldAppInfo.keyword);
                j = i + paramMessageForText.mOldAppInfo.keyword.length();
                if ((i >= 0) && (j < paramString.length())) {
                  return new int[] { i, j, 0 };
                }
              }
            }
            return null;
          }
        }
      }
      i = 0;
      continue;
      label558:
      i = 0;
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  public SpannableString a(CharSequence paramCharSequence, long paramLong)
  {
    String str1 = com.tencent.mobileqq.text.TextUtils.f(paramCharSequence.toString());
    if (android.text.TextUtils.isEmpty(str1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "generateMagicFont msg is empty");
      }
      return null;
    }
    String[] arrayOfString;
    if (ArkAiDictMgr.jdField_b_of_type_Boolean)
    {
      long l1 = System.currentTimeMillis();
      arrayOfString = WordSegment.segment(str1);
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "generateMagicFont word segment cost " + (l2 - l1) + "ms; msg length = " + paramCharSequence.length());
      }
      if (arrayOfString == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ChatItemBuilder", 2, "generateMagicFont words = null");
        }
        return null;
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "generateMagicFont so not init");
      }
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "generateMagicFont words count = " + arrayOfString.length);
    }
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    int j = 0;
    int k;
    if (j < arrayOfString.length)
    {
      while ((i < str1.length()) && (str1.charAt(i) == ' ')) {
        i += 1;
      }
      String str2 = arrayOfString[j];
      k = 0;
      for (;;)
      {
        if ((k >= str2.length()) || (str2.charAt(k) < '一') || (str2.charAt(k) > 40891))
        {
          if (k == str2.length()) {
            localArrayList.add(new Pair(Integer.valueOf(i), Integer.valueOf(str2.length() + i)));
          }
          i += str2.length();
          j += 1;
          break;
        }
        k += 1;
      }
    }
    if (localArrayList.size() < 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "generateMagicFont words count = 0");
      }
      return null;
    }
    float f1 = 1.5F;
    if (FontSettingManager.a() == 18.0F) {
      f1 = 1.3F;
    }
    i = (int)(localArrayList.size() * 0.3F + 0.5D);
    j = (int)(localArrayList.size() * 0.3F + 0.5D);
    float f2;
    boolean bool1;
    int i1;
    if (FontManager.jdField_d_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      f2 = FontManager.jdField_c_of_type_Float;
      f1 = FontManager.jdField_d_of_type_Float;
      if (FontSettingManager.a() == 18.0F)
      {
        f2 = FontManager.e;
        f1 = FontManager.jdField_f_of_type_Float;
      }
      bool1 = FontManager.jdField_f_of_type_Boolean;
      i = (int)(localArrayList.size() * FontManager.jdField_a_of_type_Float + 0.5D);
      j = (int)(localArrayList.size() * FontManager.jdField_b_of_type_Float + 0.5D);
      i1 = FontManager.jdField_b_of_type_Int;
    }
    for (;;)
    {
      paramCharSequence = new SpannableString(paramCharSequence);
      if (localArrayList.size() != 1) {
        break label1056;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "generateMagicFont oneWord");
      }
      if ((bool1) && (((Integer)((Pair)localArrayList.get(0)).second).intValue() - ((Integer)((Pair)localArrayList.get(0)).first).intValue() > 1)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "generateMagicFont oneWord switch = " + bool1 + " length = " + (((Integer)((Pair)localArrayList.get(0)).second).intValue() - ((Integer)((Pair)localArrayList.get(0)).first).intValue()));
      }
      return null;
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "generateMagicFont config not init");
      }
      i1 = 4;
      f2 = f1;
      bool1 = true;
      f1 = 0.7F;
    }
    if (((Integer)((Pair)localArrayList.get(0)).second).intValue() - ((Integer)((Pair)localArrayList.get(0)).first).intValue() == 2) {}
    label1171:
    for (i = 1;; i = 2)
    {
      int m = 0;
      k = 0;
      int n = i;
      if (k < ((Integer)((Pair)localArrayList.get(0)).second).intValue() - ((Integer)((Pair)localArrayList.get(0)).first).intValue())
      {
        i = m;
        j = n;
        if (paramLong % (((Integer)((Pair)localArrayList.get(0)).second).intValue() - ((Integer)((Pair)localArrayList.get(0)).first).intValue() - k) < n) {
          if (m % 2 != 1) {
            break label1502;
          }
        }
      }
      label1056:
      label1487:
      label1502:
      for (float f3 = f1;; f3 = f2)
      {
        paramCharSequence.setSpan(new RelativeSizeSpan(f3), ((Integer)((Pair)localArrayList.get(0)).first).intValue() + k, ((Integer)((Pair)localArrayList.get(0)).first).intValue() + k + 1, 33);
        n -= 1;
        m += 1;
        i = m;
        j = n;
        if (QLog.isColorLevel())
        {
          QLog.d("ChatItemBuilder", 2, "generateMagicFont oneWord change index = " + ((Pair)localArrayList.get(0)).first + k + " changeSize = " + f3);
          j = n;
          i = m;
        }
        paramLong = (25214903917L * paramLong + 11L & 0xFFFFFFFF) >> 16;
        k += 1;
        m = i;
        n = j;
        break;
        int i2 = 0;
        k = j;
        m = 0;
        n = 0;
        j = i;
        i = k;
        k = n;
        if (i2 < localArrayList.size())
        {
          boolean bool2 = false;
          bool1 = bool2;
          if (i1 > 0)
          {
            bool1 = bool2;
            if (i2 % i1 == i1 - 1)
            {
              bool1 = bool2;
              if (m == 0) {
                bool1 = true;
              }
            }
          }
          if ((paramLong % (localArrayList.size() - i2) >= j + i) && (!bool1)) {
            break label1487;
          }
          if ((j <= 0) && (i > 0))
          {
            f3 = f1;
            m = j;
            if (f3 == f2) {
              m = j - 1;
            }
            j = i;
            if (f3 == f1) {
              j = i - 1;
            }
            paramCharSequence.setSpan(new RelativeSizeSpan(f3), ((Integer)((Pair)localArrayList.get(i2)).first).intValue(), ((Integer)((Pair)localArrayList.get(i2)).second).intValue(), 33);
            if (QLog.isColorLevel()) {
              QLog.d("ChatItemBuilder", 2, "generateMagicFont word change: " + ((Pair)localArrayList.get(i2)).first + " , " + ((Pair)localArrayList.get(i2)).second + " size = " + f3 + " index = " + i2 + " forceChange = " + bool1);
            }
            n = 1;
            i = m;
            k += 1;
            m = n;
          }
        }
        for (;;)
        {
          n = m;
          if (i1 > 0)
          {
            n = m;
            if (i2 % i1 == i1 - 1) {
              n = 0;
            }
          }
          paramLong = (25214903917L * paramLong + 11L & 0xFFFFFFFF) >> 16;
          i2 += 1;
          m = n;
          n = i;
          i = j;
          j = n;
          break;
          if ((i <= 0) && (j > 0))
          {
            f3 = f2;
            break label1171;
          }
          if (k % 2 == 1)
          {
            f3 = f1;
            break label1171;
            return paramCharSequence;
          }
          f3 = f2;
          break label1171;
          n = j;
          j = i;
          i = n;
        }
      }
    }
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    Context localContext = paramBaseChatItemLayout.getContext();
    TextItemBuilder.Holder localHolder;
    Object localObject1;
    label151:
    Object localObject2;
    Object localObject3;
    if ((paramViewHolder instanceof TextItemBuilder.Holder))
    {
      localHolder = (TextItemBuilder.Holder)paramViewHolder;
      if (paramView != null) {
        break label1692;
      }
      paramView = new ImageView(localContext);
      paramView.setId(2131361943);
      localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(0, 2131361877);
      ((RelativeLayout.LayoutParams)localObject1).addRule(15, 2131361996);
      paramView.setContentDescription("加一");
      paramBaseChatItemLayout.addView(paramView, (ViewGroup.LayoutParams)localObject1);
      paramView.setOnClickListener(this.c);
      localObject1 = new ETTextView(localContext);
      ((ETTextView)localObject1).setTextColor(localContext.getResources().getColorStateList(2131494227));
      ((ETTextView)localObject1).setLinkTextColor(localContext.getResources().getColorStateList(2131494224));
      if (!AppSetting.jdField_b_of_type_Boolean) {
        break label1223;
      }
      ((ETTextView)localObject1).setAutoLinkMask(3);
      ((ETTextView)localObject1).setSpannableFactory(QQText.a);
      ((ETTextView)localObject1).setMaxWidth(BaseChatItemLayout.d);
      ((ETTextView)localObject1).setMovementMethod(LinkMovementMethod.getInstance());
      ((ETTextView)localObject1).setId(2131363575);
      localObject2 = new ImageView(localContext);
      ((ImageView)localObject2).setId(2131361944);
      localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject3).addRule(1, 2131361877);
      ((RelativeLayout.LayoutParams)localObject3).addRule(15, 2131361996);
      ((ImageView)localObject2).setContentDescription("加一");
      ((RelativeLayout.LayoutParams)localObject3).leftMargin = 10;
      paramBaseChatItemLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      ((ImageView)localObject2).setOnClickListener(this.c);
      localHolder.e = ((TextView)localObject1);
      localHolder.jdField_b_of_type_AndroidWidgetImageView = paramView;
      localHolder.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localObject2);
    }
    for (;;)
    {
      ((ETTextView)localHolder.e).setFont(0, paramChatMessage.uniseq);
      localHolder.e.setTypeface(null);
      ((ETTextView)localHolder.e).setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      ((ETTextView)localHolder.e).setStrokeColor(false, 0);
      ((ETTextView)localHolder.e).jdField_a_of_type_Boolean = false;
      if (!android.text.TextUtils.isEmpty(paramChatMessage.getExtInfoFromExtStr("sens_msg_ctrl_info")))
      {
        paramView = ((ETTextView)localHolder.e).a();
        if (paramView != null) {
          paramView.jdField_a_of_type_Long = (paramChatMessage.uniseq + 1L);
        }
      }
      localHolder.e.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
      int j = BaseChatItemLayout.n;
      int i = BaseChatItemLayout.o;
      if (paramChatMessage.isSend())
      {
        j = BaseChatItemLayout.o;
        i = BaseChatItemLayout.n;
      }
      localHolder.e.setPadding(j, BaseChatItemLayout.l, i, BaseChatItemLayout.m);
      localHolder.jdField_a_of_type_Long = paramChatMessage.uniseq;
      paramView = "";
      if ((paramChatMessage instanceof MessageForText))
      {
        paramView = (MessageForText)paramChatMessage;
        if (paramChatMessage.msgtype == -2008) {
          if (paramChatMessage.isSend())
          {
            localHolder.e.setText(localContext.getString(2131436164));
            paramView = "";
          }
        }
      }
      for (;;)
      {
        localObject2 = (TroopRobotManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(202);
        if (TroopRobotManager.b(paramChatMessage)) {
          TroopRobotManager.a(localHolder.e, paramChatMessage);
        }
        localObject3 = AioVipKeywordHelper.a();
        if (((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)) && (!paramChatMessage.isread))
        {
          if (QLog.isColorLevel()) {
            QLog.d("AioVipKeywordHelper", 4, "detectKeyword in TextItemBuilder.getBubbleView()");
          }
          ((AioVipKeywordHelper)localObject3).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage, paramView, localContext, paramChatMessage.isSend());
        }
        localHolder.e.setOnTouchListener(paramOnLongClickAndTouchListener);
        localHolder.e.setOnLongClickListener(paramOnLongClickAndTouchListener);
        localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener = paramOnLongClickAndTouchListener;
        localHolder.e.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
        if ((localHolder.e instanceof AnimationTextView))
        {
          paramView = (AnimationTextView)localHolder.e;
          ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage, paramView, paramViewHolder.jdField_b_of_type_Int, paramViewHolder.jdField_c_of_type_Int, false);
          paramView.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick = this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick;
          paramView.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnSingleClick = new vio(this, paramChatMessage.isSend());
        }
        localHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        localHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        paramViewHolder = (TextView)paramBaseChatItemLayout.findViewById(2131361861);
        if ((!paramChatMessage.mNeedTimeStamp) || (paramChatMessage.time <= 0L) || (paramViewHolder == null) || (paramChatMessage.time == ((Long)paramViewHolder.getTag()).longValue())) {
          break label1583;
        }
        localHolder.jdField_b_of_type_AndroidWidgetImageView.setPadding(0, AIOUtils.a(70.0F, localContext.getResources()), 0, 0);
        localHolder.jdField_c_of_type_AndroidWidgetImageView.setPadding(0, AIOUtils.a(80.0F, localContext.getResources()), 0, 0);
        label849:
        if (((paramChatMessage.extraflag != 32768) || (!paramChatMessage.isSendFromLocal())) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramChatMessage))) {
          break label1630;
        }
        i = 1;
        label883:
        if ((paramChatMessage.isFlowMessage) && (i == 0) && (!(this.jdField_a_of_type_AndroidContentContext instanceof MultiForwardActivity)))
        {
          if (!paramChatMessage.isSend()) {
            break label1636;
          }
          localHolder.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130843958);
          localHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        }
        label932:
        if ((this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity))
        {
          paramViewHolder = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
          if (paramViewHolder != null)
          {
            paramView = paramViewHolder.a().jdField_a_of_type_ComTencentMobileqqArkArkRecommendController;
            if (paramView != null)
            {
              localHolder.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController$AttachAppHolder = paramView.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, localHolder.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController$AttachAppHolder, (View)localObject1, paramBaseChatItemLayout, paramOnLongClickAndTouchListener);
              if ((!ArkAiAppCenter.jdField_f_of_type_Boolean) && (ArkRecommendController.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) && (paramChatMessage.isSend()) && (ArkRecommendController.b != null) && (ArkRecommendController.b.size() > 0) && (localHolder.jdField_b_of_type_Int == localHolder.jdField_c_of_type_Int - 1))
              {
                paramViewHolder = localHolder.e.getText().toString();
                if (!paramViewHolder.startsWith("@babyQ"))
                {
                  paramOnLongClickAndTouchListener = ArkRecommendController.b.keySet().iterator();
                  while (paramOnLongClickAndTouchListener.hasNext())
                  {
                    paramBaseChatItemLayout = (String)paramOnLongClickAndTouchListener.next();
                    if (paramViewHolder.contains(paramBaseChatItemLayout))
                    {
                      paramViewHolder = (ArkRecommendController.ArkAtBabyqGrayTipConfig)ArkRecommendController.b.get(paramBaseChatItemLayout);
                      if (paramViewHolder == null) {
                        break label1680;
                      }
                      paramViewHolder = paramViewHolder.b;
                      label1144:
                      paramView.a(4, paramViewHolder, paramChatMessage, paramBaseChatItemLayout);
                    }
                  }
                }
              }
            }
          }
        }
        if (localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout != null)
        {
          if (!((TroopRobotManager)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage)) {
            break label1659;
          }
          localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setRobotNextTipsView(true, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
        }
        return localObject1;
        localHolder = (TextItemBuilder.Holder)a();
        localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramBaseChatItemLayout;
        paramBaseChatItemLayout.setTag(localHolder);
        paramView = null;
        break;
        label1223:
        ((ETTextView)localObject1).setAutoLinkMask(0);
        break label151;
        localHolder.e.setText(localContext.getString(2131436163));
        paramView = "";
        continue;
        a(localHolder, paramChatMessage);
        if (!android.text.TextUtils.isEmpty(paramView.sb))
        {
          if (!android.text.TextUtils.isEmpty(paramView.sb2))
          {
            localHolder.e.setText(paramView.sb2);
            label1294:
            super.a(localHolder.e, paramChatMessage);
            if (AppSetting.jdField_b_of_type_Boolean)
            {
              localObject2 = com.tencent.mobileqq.text.TextUtils.d(paramChatMessage.msg);
              localObject3 = Spannable.Factory.getInstance().newSpannable((CharSequence)localObject2);
              if (!Linkify.addLinks((Spannable)localObject3, 15)) {
                break label1377;
              }
              localHolder.e.setContentDescription((CharSequence)localObject3);
            }
          }
          for (;;)
          {
            paramView = paramView.sb.toString();
            break;
            localHolder.e.setText(paramView.sb);
            break label1294;
            label1377:
            localHolder.e.setContentDescription((CharSequence)localObject2);
          }
        }
        localHolder.e.setText("");
        if (QLog.isColorLevel()) {
          QLog.d("ChatItemBuilder", 2, "textitem text.sb is null" + paramChatMessage.msgtype);
        }
        paramView = "";
        continue;
        if (!(paramChatMessage instanceof MessageForHiBoom)) {
          break label1492;
        }
        localObject2 = (MessageForHiBoom)paramChatMessage;
        if (((MessageForHiBoom)localObject2).mHiBoomMessage != null)
        {
          localHolder.e.setText(((MessageForHiBoom)localObject2).mHiBoomMessage.text);
          paramView = ((MessageForHiBoom)localObject2).mHiBoomMessage.text;
        }
      }
      label1492:
      if ((paramChatMessage instanceof MessageForPoke))
      {
        paramView = (MessageForPoke)paramChatMessage;
        if (paramView.name == null) {
          break label1685;
        }
      }
      label1680:
      label1685:
      for (paramView = "[" + paramView.name + "]请用最新版手机QQ查看。";; paramView = "[戳一戳]请用最新版手机QQ查看。")
      {
        localHolder.e.setText(paramView);
        break;
        localHolder.e.setText(paramChatMessage.msg);
        super.a(localHolder.e, paramChatMessage);
        paramView = paramChatMessage.msg;
        break;
        label1583:
        localHolder.jdField_b_of_type_AndroidWidgetImageView.setPadding(0, AIOUtils.a(30.0F, localContext.getResources()), 0, 0);
        localHolder.jdField_c_of_type_AndroidWidgetImageView.setPadding(0, AIOUtils.a(30.0F, localContext.getResources()), 0, 0);
        break label849;
        label1630:
        i = 0;
        break label883;
        label1636:
        localHolder.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130843958);
        localHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
        break label932;
        label1659:
        localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setRobotNextTipsView(false, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
        return localObject1;
        paramViewHolder = null;
        break label1144;
      }
      label1692:
      localObject1 = paramView;
    }
  }
  
  public BaseBubbleBuilder.TouchDelegate a(View paramView)
  {
    if (a(paramView)) {
      return this;
    }
    return null;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new TextItemBuilder.Holder();
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForText)) {
      return "说" + com.tencent.mobileqq.text.TextUtils.d(paramChatMessage.msg);
    }
    return "说" + paramChatMessage.msg;
  }
  
  public void a()
  {
    super.a();
    ETEngine.getInstance().onAIODestroy();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    Bundle localBundle;
    MessageForText localMessageForText;
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
    case 2131375567: 
    case 2131375573: 
      do
      {
        do
        {
          return;
          ChatActivityFacade.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006447", "0X8006447", 0, 0, "1", "", "", "");
          return;
        } while (paramChatMessage.msg == null);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800644A", "0X800644A", 0, 0, "1", "", "", "");
        try
        {
          ((ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(paramChatMessage.msg);
          return;
        }
        catch (Exception paramContext) {}
      } while (!QLog.isColorLevel());
      QLog.e("ChatItemBuilder", 2, paramContext.toString());
      return;
    case 2131375575: 
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage.msg, paramChatMessage.uniseq);
      return;
    case 2131363517: 
      localBundle = new Bundle();
      localBundle.putInt("forward_type", -1);
      localMessageForText = (MessageForText)paramChatMessage;
      if (localMessageForText.sb != null)
      {
        paramChatMessage = localMessageForText.sb.toString();
        paramContext = paramChatMessage;
        if (LoveLanguageManager.b(paramChatMessage))
        {
          paramContext = localMessageForText.msg;
          if (!QLog.isColorLevel()) {
            break label625;
          }
          int i = paramContext.length();
          paramInt = i;
          if (i >= 3) {
            paramInt = 3;
          }
          if (paramInt <= 0) {
            break label442;
          }
          paramChatMessage = paramContext.substring(0, paramInt);
          label339:
          QLog.d("ChatItemBuilder", 2, new Object[] { "love language shield singleMsg Send with origin :msgDta[0-2]=", paramChatMessage });
        }
      }
      break;
    }
    label442:
    label625:
    for (;;)
    {
      localBundle.putString("forward_text", paramContext);
      paramContext = new Intent();
      paramContext.putExtras(localBundle);
      paramContext.putExtra("direct_send_if_dataline_forward", true);
      ForwardBaseOption.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramContext, 21);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "1", "", "", "");
      return;
      paramChatMessage = "";
      break label339;
      paramContext = localMessageForText.msg;
      continue;
      StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "", "Translate_external", "Clk_about_translate", 0, 1, 0);
      paramContext = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      if ((paramChatMessage != null) && (paramChatMessage.length() > 0)) {
        paramContext.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      }
      paramContext.putExtra("url", "http://183.62.127.31/MobileQQ/translate.html");
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramContext);
      return;
      e(paramChatMessage);
      return;
      super.c(paramChatMessage);
      return;
      super.a(paramChatMessage);
      return;
      if ((c()) || (!(this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity)) || (((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment() == null)) {
        break;
      }
      ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a().h(paramChatMessage);
      return;
    }
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    if (AIOUtils.a(paramView).isMultiMsg) {}
    String str1;
    String str2;
    do
    {
      return;
      paramView = (MessageForText)AIOUtils.a(paramView);
      str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131433635);
      str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131433636);
    } while (!paramView.isSendFromLocal());
    DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, str1, str2, new vip(this, paramView), new viq(this)).show();
  }
  
  public void a(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      return;
      paramView = paramView.getBackground();
    } while (paramView == null);
    paramView.setColorFilter(null);
    paramView.invalidateSelf();
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(g, d, f, e);
      return;
    }
    paramView.setPadding(f, d, g, e);
  }
  
  public void a(View paramView, ChatMessage paramChatMessage, int paramInt)
  {
    super.a(paramView, paramChatMessage, paramInt);
    Object localObject;
    if (paramInt == 1)
    {
      localObject = (BaseBubbleBuilder.ViewHolder)paramView.getTag();
      if (localObject != null) {
        a((BaseBubbleBuilder.ViewHolder)localObject, paramView, paramChatMessage, ((BaseBubbleBuilder.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo);
      }
    }
    label39:
    do
    {
      do
      {
        do
        {
          do
          {
            break label39;
            break label39;
            do
            {
              return;
            } while ((paramInt != 0) || (!(this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity)));
            localObject = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
          } while (localObject == null);
          localObject = ((ChatFragment)localObject).a().jdField_a_of_type_ComTencentMobileqqArkArkRecommendController;
        } while (localObject == null);
        paramView = (BaseBubbleBuilder.ViewHolder)paramView.getTag();
        if (paramView != null)
        {
          TextItemBuilder.Holder localHolder = (TextItemBuilder.Holder)paramView;
          localHolder.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController$AttachAppHolder = ((ArkRecommendController)localObject).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, localHolder.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController$AttachAppHolder, localHolder.e, paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener);
        }
        if ((paramChatMessage.isSendFromLocal()) && (ArkRecommendController.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo))) {
          ((ArkRecommendController)localObject).a(paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        }
      } while (1 != ArkAiAppCenter.jdField_a_of_type_Int);
      paramView = paramChatMessage.getExtInfoFromExtStr("ark_text_analysis_flag");
      if ("1".equals(paramView))
      {
        ((ArkRecommendController)localObject).a(paramChatMessage);
        return;
      }
    } while (!"0".equals(paramView));
    paramView = new ArrayList();
    paramView.add(paramChatMessage);
    ((ArkRecommendController)localObject).a(paramView);
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    Drawable localDrawable = paramView.getBackground();
    if (localDrawable != null) {
      if (!paramBoolean) {
        break label25;
      }
    }
    label25:
    for (paramView = null;; paramView = jdField_a_of_type_AndroidGraphicsColorFilter)
    {
      localDrawable.setColorFilter(paramView);
      localDrawable.invalidateSelf();
      return;
    }
  }
  
  protected void a(BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, ChatMessage paramChatMessage, BubbleInfo paramBubbleInfo)
  {
    Object localObject;
    if ((paramChatMessage instanceof MessageForLongTextMsg))
    {
      localObject = (MessageForLongTextMsg)paramChatMessage;
      if ((!((MessageForLongTextMsg)localObject).getExtInfoFromExtStr("long_text_recv_state").equals("2")) && (!((MessageForLongTextMsg)localObject).getExtInfoFromExtStr("long_text_recv_state").equals("3"))) {}
    }
    TextItemBuilder.Holder localHolder;
    do
    {
      return;
      localHolder = (TextItemBuilder.Holder)paramViewHolder;
    } while (a(paramChatMessage, localHolder));
    if ((paramBubbleInfo.jdField_a_of_type_Int == 0) || (!paramBubbleInfo.a()))
    {
      paramView = paramView.getResources();
      if (paramChatMessage.isSend())
      {
        paramViewHolder = paramView.getColorStateList(2131494230);
        localHolder.e.setTextColor(paramViewHolder);
        if (!paramChatMessage.isSend()) {
          break label154;
        }
      }
      label154:
      for (paramView = paramView.getColorStateList(2131494229);; paramView = paramView.getColorStateList(2131494228))
      {
        localHolder.e.setLinkTextColor(paramView);
        a(localHolder, paramChatMessage, paramViewHolder, paramView);
        return;
        paramViewHolder = paramView.getColorStateList(2131494227);
        break;
      }
    }
    paramViewHolder = ColorStateList.valueOf(paramBubbleInfo.jdField_b_of_type_Int);
    if (paramBubbleInfo.jdField_b_of_type_Int == 0)
    {
      localHolder.e.setTextColor(-16777216);
      paramViewHolder = ColorStateList.valueOf(-16777216);
      if (paramBubbleInfo.jdField_c_of_type_Int != 0) {
        break label357;
      }
      paramView = paramView.getResources().getColorStateList(2131494228);
      label219:
      localHolder.e.setLinkTextColor(paramView);
      localObject = paramViewHolder;
      if ((localHolder.e instanceof ETTextView))
      {
        if (!paramBubbleInfo.jdField_a_of_type_Boolean) {
          break label369;
        }
        ((ETTextView)localHolder.e).setShadowLayer(3.0F, 0.0F, 0.0F, paramBubbleInfo.d);
        ((ETTextView)localHolder.e).setStrokeColor(true, paramBubbleInfo.d);
        localObject = paramViewHolder;
        if (QLog.isColorLevel())
        {
          QLog.d("ChatItemBuilder", 2, "bubble has stroke, color = " + paramBubbleInfo.d);
          localObject = paramViewHolder;
        }
      }
    }
    for (;;)
    {
      a(localHolder, paramChatMessage, (ColorStateList)localObject, paramView);
      return;
      localHolder.e.setTextColor(paramBubbleInfo.jdField_b_of_type_Int);
      break;
      label357:
      paramView = ColorStateList.valueOf(paramBubbleInfo.jdField_c_of_type_Int);
      break label219;
      label369:
      localObject = paramViewHolder;
      if (paramBubbleInfo.jdField_b_of_type_Boolean)
      {
        localObject = paramViewHolder;
        if (((ChatBackgroundManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(62)).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localHolder.e.getCurrentTextColor(), 10000.0D * localHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.jdField_a_of_type_Double) == 1)
        {
          paramViewHolder = (ETTextView)localHolder.e;
          float f2 = paramViewHolder.getTextSize() * 3.0F / 16.0F;
          float f1 = f2;
          if (f2 > 25.0F) {
            f1 = 25.0F;
          }
          paramViewHolder.setTextColor(-1);
          localObject = ColorStateList.valueOf(-1);
          paramViewHolder.setShadowLayer(f1, 0.0F, 0.0F, paramBubbleInfo.d);
        }
      }
    }
  }
  
  public void a(BaseBubbleBuilder.ViewHolder paramViewHolder, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForLongTextMsg)) {}
    label7:
    Object localObject1;
    label252:
    do
    {
      do
      {
        do
        {
          break label7;
          do
          {
            return;
          } while (AIOUtils.g);
          paramViewHolder = (TextItemBuilder.Holder)paramViewHolder;
          if (((paramChatMessage.istroop == 3000) || (paramChatMessage.istroop == 1)) && ((!paramChatMessage.isShowQIMStyleGroup) && ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Boolean) || (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.h)))) {
            break;
          }
          localObject1 = new ETFont(0, null, 0.0F);
        } while (!(paramViewHolder.e instanceof ETTextView));
        ((ETTextView)paramViewHolder.e).setFont((ETFont)localObject1, paramChatMessage.uniseq);
        return;
      } while (!(paramViewHolder.e instanceof ETTextView));
      localObject1 = ((FontManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(41)).b(paramChatMessage);
      ETTextView localETTextView = (ETTextView)paramViewHolder.e;
      localETTextView.setMinWidth(AIOUtils.a(65.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      localETTextView.setMinHeight(AIOUtils.a(57.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      String str = FontManager.a(paramChatMessage);
      if ((localObject1 != null) && (((FontInfo)localObject1).jdField_b_of_type_Int == 1)) {
        localETTextView.d = true;
      }
      long l1;
      long l2;
      if ((FontManager.a(paramChatMessage)) && ((paramChatMessage instanceof MessageForText)))
      {
        ??? = (MessageForText)paramChatMessage;
        paramViewHolder = null;
        if (!android.text.TextUtils.isEmpty(((MessageForText)???).sb))
        {
          if (android.text.TextUtils.isEmpty(((MessageForText)???).sb2)) {
            break label645;
          }
          paramViewHolder = ((MessageForText)???).sb2;
        }
        if ((paramViewHolder != null) && (com.tencent.mobileqq.text.TextUtils.a(paramViewHolder)))
        {
          l1 = ((MessageForText)paramChatMessage).msgUid;
          l2 = ((MessageForText)paramChatMessage).uniseq;
        }
      }
      for (;;)
      {
        synchronized (jdField_a_of_type_ComTencentUtilLRULinkedHashMap)
        {
          if (jdField_a_of_type_ComTencentUtilLRULinkedHashMap.containsKey(Long.valueOf(l2)))
          {
            paramViewHolder = (SpannableString)jdField_a_of_type_ComTencentUtilLRULinkedHashMap.get(Long.valueOf(l2));
            if (paramViewHolder != null)
            {
              localETTextView.setText(paramViewHolder);
              localETTextView.jdField_a_of_type_Boolean = true;
            }
            if ((localObject1 == null) || (((FontInfo)localObject1).jdField_a_of_type_Int == 0)) {
              break label922;
            }
            if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c().equals(str)) {
              break label702;
            }
            if (FontManager.jdField_a_of_type_Long == 0L) {
              FontManager.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getLong("personal_font_last_send_report", 1L);
            }
            if ((FontManager.jdField_a_of_type_Long < FontManager.jdField_c_of_type_Long) && (paramChatMessage.time * 1000L > FontManager.jdField_c_of_type_Long))
            {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Font_Mall", "0X8007B2B", 0, 0, "" + (((FontInfo)localObject1).jdField_b_of_type_Int - 1), "" + ((FontInfo)localObject1).jdField_a_of_type_Int, "", "");
              FontManager.jdField_a_of_type_Long = paramChatMessage.time * 1000L;
              paramViewHolder = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit();
              paramViewHolder.putLong("personal_font_last_send_report", paramChatMessage.time * 1000L);
              paramViewHolder.commit();
            }
            if (((FontInfo)localObject1).jdField_a_of_type_ComEtrumpMixlayoutETFont == null) {
              break label886;
            }
            paramViewHolder = ((FontInfo)localObject1).jdField_a_of_type_ComEtrumpMixlayoutETFont;
            paramViewHolder.setSize(localETTextView.getTextSize());
            localETTextView.setFont(paramViewHolder, paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("VasFont", 2, "updateTextFont  fontId = " + ((FontInfo)localObject1).jdField_a_of_type_Int + "fontType = " + ((FontInfo)localObject1).jdField_b_of_type_Int + "typeface = " + ((FontInfo)localObject1).jdField_a_of_type_AndroidGraphicsTypeface);
            return;
            paramViewHolder = ((MessageForText)???).sb;
            break label252;
          }
          if ((localObject1 != null) && (((FontInfo)localObject1).jdField_b_of_type_Int == 1)) {
            localETTextView.d = false;
          }
          ArkRecommendLogic.a().post(new vim(this, paramViewHolder, l1, l2));
        }
        if (FontManager.jdField_b_of_type_Long == 0L) {
          FontManager.jdField_b_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getLong("personal_font_last_receive_report", 1L);
        }
        if ((FontManager.jdField_b_of_type_Long < FontManager.jdField_c_of_type_Long) && (paramChatMessage.time * 1000L > FontManager.jdField_c_of_type_Long))
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Font_Mall", "0X8007B2C", 0, 0, "" + (((FontInfo)localObject1).jdField_b_of_type_Int - 1), "" + ((FontInfo)localObject1).jdField_a_of_type_Int, "", "");
          FontManager.jdField_b_of_type_Long = paramChatMessage.time * 1000L;
          paramViewHolder = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit();
          paramViewHolder.putLong("personal_font_last_receive_report", paramChatMessage.time * 1000L);
          paramViewHolder.commit();
          continue;
          paramViewHolder = new ETFont(((FontInfo)localObject1).jdField_a_of_type_Int, ((FontInfo)localObject1).jdField_a_of_type_JavaLangString, localETTextView.getTextSize(), ((FontInfo)localObject1).jdField_b_of_type_Int, ((FontInfo)localObject1).jdField_a_of_type_AndroidGraphicsTypeface);
        }
      }
    } while (!QLog.isColorLevel());
    label645:
    label702:
    label886:
    paramChatMessage = new StringBuilder().append("updateTextFont fontinfo = ");
    label922:
    if (localObject1 == null) {}
    for (paramViewHolder = "null";; paramViewHolder = ((FontInfo)localObject1).toString())
    {
      QLog.d("VasFont", 2, paramViewHolder);
      return;
    }
  }
  
  void a(TextItemBuilder.Holder paramHolder, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForLongTextMsg)) {}
    FontManager localFontManager;
    do
    {
      do
      {
        return;
      } while ((1 == paramChatMessage.istroop) && (AnonymousChatHelper.a(paramChatMessage)));
      localFontManager = (FontManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(41);
      localFontManager.b(paramChatMessage);
    } while (!localFontManager.b(paramChatMessage));
    localFontManager.a(paramChatMessage);
    localFontManager.a(paramHolder.e);
  }
  
  protected void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramViewHolder, paramInt1, paramInt2);
  }
  
  public void a(QQCustomDialog paramQQCustomDialog, View paramView, QQAppInterface paramQQAppInterface, TextItemBuilder.ArkHighLightClickCallback paramArkHighLightClickCallback)
  {
    paramQQCustomDialog.setContentView(2130968842);
    ((TextView)paramQQCustomDialog.findViewById(2131364034)).setText(BaseActivity.sTopActivity.getString(2131438813));
    ArkRecommendController.a(paramQQCustomDialog, true);
    paramQQCustomDialog.setCanceledOnTouchOutside(false);
    if (paramQQAppInterface == null) {
      if (QLog.isColorLevel()) {
        QLog.d("ArkDialog", 2, "appinterface is Empty");
      }
    }
    while (paramArkHighLightClickCallback == null) {
      return;
    }
    paramQQCustomDialog.setNegativeButton(2131438812, new vit(this, paramQQCustomDialog, paramQQAppInterface, paramView));
    paramQQCustomDialog.setPositiveButton(2131438811, new viu(this, paramQQCustomDialog, paramView, paramArkHighLightClickCallback, paramQQAppInterface));
    try
    {
      paramQQCustomDialog.show();
      ArkAppReportController.a(paramQQAppInterface, "", "__global__", "ArkAlertDialogShow", 0L, 0L, 0L, 0L, 0L, "", "");
      return;
    }
    catch (Exception paramQQCustomDialog)
    {
      QQText.ArkHighlightSpan.a(paramView, paramArkHighLightClickCallback);
      ArkRecommendController.a(paramView.getContext(), "error", paramQQAppInterface);
      ArkAppCenter.b("ArkDialog", String.format("Dialog show failed, err=%s", new Object[] { paramQQCustomDialog.getMessage() }));
    }
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = AIOUtils.a(paramView);
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    if (ConfessMsgUtil.a(paramView)) {
      return localQQCustomMenu.a();
    }
    int i;
    if ((paramView instanceof MessageForText)) {
      if (!android.text.TextUtils.isEmpty(((MessageForText)paramView).getExtInfoFromExtStr("sticker_info"))) {
        i = 1;
      }
    }
    for (;;)
    {
      if ((paramView instanceof MessageForPoke)) {
        i = 1;
      }
      if (i == 0)
      {
        localQQCustomMenu.a(2131375573, "复制", 2130838305);
        if ((paramView.extraflag == 32768) && (paramView.isSendFromLocal())) {
          localQQCustomMenu.a(2131375575, this.jdField_a_of_type_AndroidContentContext.getString(2131433721), 2130838317);
        }
        localQQCustomMenu.a(2131363517, this.jdField_a_of_type_AndroidContentContext.getString(2131435083), 2130838313);
        if ((paramView.istroop == 1) && (AIOUtils.a(4) == 1)) {
          localQQCustomMenu.a(2131375585, this.jdField_a_of_type_AndroidContentContext.getString(2131430732), 2130838321);
        }
        a(paramView, localQQCustomMenu);
        if (AIOUtils.a(5) == 1) {
          localQQCustomMenu.a(2131366776, this.jdField_a_of_type_AndroidContentContext.getString(2131431563), 2130838312);
        }
        if ((paramView.vipBubbleID == 100000L) && (!paramView.isSend())) {
          localQQCustomMenu.a(2131375583, this.jdField_a_of_type_AndroidContentContext.getString(2131436450), 2130838292);
        }
        if ((paramView.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramView))) {
          a(localQQCustomMenu, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramView);
        }
        ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        super.b(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext);
      }
      for (;;)
      {
        return localQQCustomMenu.a();
        i = 0;
        break;
        ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      }
      i = 0;
    }
  }
  
  protected void c(View paramView)
  {
    super.c(paramView);
  }
  
  protected void e(ChatMessage paramChatMessage)
  {
    paramChatMessage.msg = a(paramChatMessage.msg, true);
    QfavBuilder.a(null, paramChatMessage.msg).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 1);
    if (android.text.TextUtils.isEmpty(paramChatMessage.msg)) {}
    label179:
    for (;;)
    {
      return;
      paramChatMessage = new StringBuilder(paramChatMessage.msg);
      int i = 0;
      for (;;)
      {
        if (i >= paramChatMessage.length()) {
          break label179;
        }
        if ((paramChatMessage.codePointAt(i) == 20) && (i < paramChatMessage.length() - 1) && (paramChatMessage.charAt(i + 1) == 'ÿ'))
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X800588D", 0, 0, "", "", "", "");
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("ChatItemBuilder", 2, "report save small emoticon amount");
          return;
        }
        i += 1;
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      long l = paramMessage.getData().getLong("msg_id");
      if ((this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity))
      {
        Object localObject = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
        if ((localObject != null) && (((ChatFragment)localObject).a() != null) && (((ChatFragment)localObject).a().jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null))
        {
          localObject = ((ChatFragment)localObject).a().jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
          int i = AIOUtils.a(l, ((XListView)localObject).getAdapter());
          if (QLog.isColorLevel()) {
            QLog.d("ChatItemBuilder", 2, "generateMagicFont updateUI msgId = " + l + " position = " + i);
          }
          localObject = AIOUtils.a((ListView)localObject, i);
          if ((localObject != null) && ((((View)localObject).getTag() instanceof TextItemBuilder.Holder)))
          {
            localObject = (TextItemBuilder.Holder)((View)localObject).getTag();
            if (((TextItemBuilder.Holder)localObject).jdField_a_of_type_Long == l)
            {
              if (QLog.isColorLevel()) {
                QLog.d("ChatItemBuilder", 2, "generateMagicFont updateUI find view position = " + i);
              }
              if ((paramMessage.obj instanceof SpannableString))
              {
                paramMessage = (SpannableString)paramMessage.obj;
                ((TextItemBuilder.Holder)localObject).e.setText(paramMessage);
                ((ETTextView)((TextItemBuilder.Holder)localObject).e).jdField_a_of_type_Boolean = true;
                if ((((TextItemBuilder.Holder)localObject).e instanceof ETTextView))
                {
                  ETTextView localETTextView = (ETTextView)((TextItemBuilder.Holder)localObject).e;
                  if (localETTextView.jdField_a_of_type_ComEtrumpMixlayoutETFont != null) {
                    localETTextView.jdField_a_of_type_ComEtrumpMixlayoutETFont.mText = paramMessage;
                  }
                }
              }
              if (((ETTextView)((TextItemBuilder.Holder)localObject).e).c()) {
                ((ETTextView)((TextItemBuilder.Holder)localObject).e).d = true;
              }
              ((TextItemBuilder.Holder)localObject).e.requestLayout();
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TextItemBuilder
 * JD-Core Version:    0.7.0.1
 */