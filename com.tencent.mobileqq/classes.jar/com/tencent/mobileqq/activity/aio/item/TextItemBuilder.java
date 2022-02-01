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
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.ClipboardManager;
import android.text.Spannable.Factory;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
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
import com.etrump.mixlayout.ETLayout;
import com.etrump.mixlayout.ETTextView;
import com.etrump.mixlayout.ETTextView.TextAnimationListener;
import com.etrump.mixlayout.FontInfo;
import com.etrump.mixlayout.FontManager;
import com.etrump.mixlayout.VasShieldFont;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.TouchDelegate;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.ecommerce.ECommerceDataReportUtil;
import com.tencent.mobileqq.activity.aio.helper.WriteTogetherHelper;
import com.tencent.mobileqq.activity.aio.qim.QIMUserManager;
import com.tencent.mobileqq.activity.selectable.AIOSelectableDelegateImpl;
import com.tencent.mobileqq.activity.selectable.AIOSelectableDelegateProxy;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.ark.ArkAiDictMgr;
import com.tencent.mobileqq.ark.ArkAiDictMgr.WordSegmentResult;
import com.tencent.mobileqq.ark.ArkRecommendLogic;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.bubble.BubbleUtils;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.HiBoomMessage;
import com.tencent.mobileqq.data.MessageForHiBoom;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForWriteTogether;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.limitchat.LimitChatUtil;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.multimsg.MultiMsgUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.AlphabeticFontHelper;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.mobileqq.together.writetogether.WTUtils;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceUtil;
import com.tencent.mobileqq.troop.utils.TroopRobotManager;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.vip.AioVipKeywordHelper;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.AnimationTextView.OnDoubleClick;
import com.tencent.mobileqq.writetogether.api.IWriteTogetherConfig;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import com.tencent.util.Pair;
import com.tencent.widget.XListView;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class TextItemBuilder
  extends BaseBubbleBuilder
  implements Handler.Callback, BaseBubbleBuilder.TouchDelegate
{
  public static final LRULinkedHashMap<Long, SpannableString> a;
  private static String jdField_a_of_type_JavaLangString = "ArkApp.TextItemBuilder";
  public static final int c = BaseChatItemLayout.h + BaseChatItemLayout.m;
  protected static final int d = BaseChatItemLayout.i + BaseChatItemLayout.n;
  public static final int e = BaseChatItemLayout.j + BaseChatItemLayout.o;
  public static final int f = BaseChatItemLayout.k + BaseChatItemLayout.p;
  protected View.OnClickListener a;
  private ETTextView.TextAnimationListener jdField_a_of_type_ComEtrumpMixlayoutETTextView$TextAnimationListener = new TextItemBuilder.9(this);
  private AlphabeticFontHelper jdField_a_of_type_ComTencentMobileqqStudymodeAlphabeticFontHelper;
  protected AnimationTextView.OnDoubleClick a;
  Handler b;
  protected View.OnClickListener b;
  
  static
  {
    jdField_a_of_type_ComTencentUtilLRULinkedHashMap = new LRULinkedHashMap(50);
  }
  
  public TextItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_b_of_type_AndroidOsHandler = null;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new TextItemBuilder.1(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new TextItemBuilder.2(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick = new TextItemBuilder.MyOnDoubleClick(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext);
    this.jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  }
  
  private static int a(ETTextView paramETTextView, CharSequence paramCharSequence)
  {
    return (int)Math.ceil(paramETTextView.getPaint().measureText(paramCharSequence, 0, paramCharSequence.length()));
  }
  
  @Nullable
  private SpannableString a(CharSequence paramCharSequence, long paramLong, ArrayList<Pair<Integer, Integer>> paramArrayList)
  {
    float f1 = 1.5F;
    if (FontSettingManager.getFontLevel() == 18.0F) {
      f1 = 1.3F;
    }
    int i = (int)(paramArrayList.size() * 0.3F + 0.5D);
    int j = (int)(paramArrayList.size() * 0.3F + 0.5D);
    int k = 4;
    boolean bool = true;
    float f2;
    if (FontManager.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      f1 = FontManager.jdField_c_of_type_Float;
      f2 = FontManager.d;
      if (FontSettingManager.getFontLevel() == 18.0F)
      {
        f1 = FontManager.e;
        f2 = FontManager.jdField_f_of_type_Float;
      }
      bool = FontManager.jdField_f_of_type_Boolean;
      i = (int)(paramArrayList.size() * FontManager.jdField_a_of_type_Float + 0.5D);
      j = (int)(paramArrayList.size() * FontManager.jdField_b_of_type_Float + 0.5D);
      k = FontManager.jdField_b_of_type_Int;
    }
    SpannableString localSpannableString;
    for (;;)
    {
      localSpannableString = new SpannableString(paramCharSequence);
      if (paramArrayList.size() != 1) {
        break;
      }
      paramCharSequence = localSpannableString;
      if (a(paramLong, paramArrayList, f1, f2, bool, localSpannableString)) {
        paramCharSequence = null;
      }
      return paramCharSequence;
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "generateMagicFont config not init");
      }
      f2 = 0.7F;
    }
    a(paramLong, paramArrayList, f1, f2, i, j, k, localSpannableString);
    return localSpannableString;
  }
  
  private BaseChatPie a()
  {
    if (!(this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity)) {
      return null;
    }
    ChatFragment localChatFragment = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
    if (localChatFragment == null)
    {
      QLog.e("ChatItemBuilder", 1, "[getChatPie] ChatFragment is null");
      return null;
    }
    return localChatFragment.a();
  }
  
  public static String a(QQAppInterface paramQQAppInterface, Activity paramActivity, ChatMessage paramChatMessage, String paramString)
  {
    paramChatMessage.msg = a(paramChatMessage.msg, true);
    paramString = a(paramString, true);
    QfavBuilder.a(null, paramString).b(paramQQAppInterface, paramChatMessage).a(paramActivity, paramQQAppInterface.getAccount());
    QfavReport.a(paramQQAppInterface, 6, 1);
    return paramString;
  }
  
  private String a(ChatMessage paramChatMessage, Context paramContext, TextItemBuilder.Holder paramHolder)
  {
    Object localObject = "";
    if ((paramChatMessage instanceof MessageForText))
    {
      localObject = (MessageForText)paramChatMessage;
      if (paramChatMessage.msgtype == -2008)
      {
        if (paramChatMessage.isSend())
        {
          paramHolder.jdField_d_of_type_AndroidWidgetTextView.setText(paramContext.getString(2131718941));
          return "";
        }
        paramHolder.jdField_d_of_type_AndroidWidgetTextView.setText(paramContext.getString(2131718940));
        return "";
      }
      a(paramHolder, paramChatMessage);
      if (!android.text.TextUtils.isEmpty(((MessageForText)localObject).sb))
      {
        if (!android.text.TextUtils.isEmpty(((MessageForText)localObject).sb2))
        {
          paramHolder.jdField_d_of_type_AndroidWidgetTextView.setText(((MessageForText)localObject).sb2);
          TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidContentContext, paramHolder.jdField_d_of_type_AndroidWidgetTextView, paramChatMessage);
          if (AppSetting.d)
          {
            paramChatMessage = com.tencent.mobileqq.text.TextUtils.emoticonToTextForTalkBack(paramChatMessage.msg);
            paramContext = Spannable.Factory.getInstance().newSpannable(paramChatMessage);
            if (!Linkify.addLinks(paramContext, 15)) {
              break label196;
            }
            paramHolder.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(paramContext);
          }
        }
        for (;;)
        {
          return ((MessageForText)localObject).sb.toString();
          paramHolder.jdField_d_of_type_AndroidWidgetTextView.setText(((MessageForText)localObject).sb);
          break;
          label196:
          paramHolder.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(paramChatMessage);
        }
      }
      paramHolder.jdField_d_of_type_AndroidWidgetTextView.setText("");
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "textitem text.sb is null" + paramChatMessage.msgtype);
      }
      return "";
    }
    if ((paramChatMessage instanceof MessageForHiBoom))
    {
      paramContext = (MessageForHiBoom)paramChatMessage;
      paramChatMessage = (ChatMessage)localObject;
      if (paramContext.mHiBoomMessage != null)
      {
        paramHolder.jdField_d_of_type_AndroidWidgetTextView.setText(paramContext.mHiBoomMessage.text);
        paramChatMessage = paramContext.mHiBoomMessage.text;
      }
      return paramChatMessage;
    }
    if ((paramChatMessage instanceof MessageForPoke))
    {
      paramContext = (MessageForPoke)paramChatMessage;
      paramChatMessage = HardCodeUtil.a(2131714736);
      if (paramContext.name != null) {
        paramChatMessage = "[" + paramContext.name + "]请用最新版手机QQ查看。";
      }
      paramHolder.jdField_d_of_type_AndroidWidgetTextView.setText(paramChatMessage);
      return paramChatMessage;
    }
    paramHolder.jdField_d_of_type_AndroidWidgetTextView.setText(paramChatMessage.msg);
    TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidContentContext, paramHolder.jdField_d_of_type_AndroidWidgetTextView, paramChatMessage);
    return paramChatMessage.msg;
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
  
  private void a(int paramInt)
  {
    int i = 1;
    if (paramInt == 0) {
      paramInt = i;
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B155", "0X800B155", paramInt, 0, "", "", "", "");
      return;
      if (paramInt == 1) {
        paramInt = 2;
      } else if (ChatActivityUtils.a(paramInt)) {
        paramInt = 3;
      } else {
        paramInt = 4;
      }
    }
  }
  
  private void a(long paramLong, ArrayList<Pair<Integer, Integer>> paramArrayList, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, int paramInt3, SpannableString paramSpannableString)
  {
    int i = 0;
    int j = 0;
    int k = 0;
    float f1;
    label97:
    int m;
    if (k < paramArrayList.size())
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (paramInt3 > 0)
      {
        bool1 = bool2;
        if (k % paramInt3 == paramInt3 - 1)
        {
          bool1 = bool2;
          if (j == 0) {
            bool1 = true;
          }
        }
      }
      if ((paramLong % (paramArrayList.size() - k) >= paramInt1 + paramInt2) && (!bool1)) {
        break label405;
      }
      if ((paramInt1 <= 0) && (paramInt2 > 0))
      {
        f1 = paramFloat2;
        j = paramInt1;
        if (f1 == paramFloat1) {
          j = paramInt1 - 1;
        }
        paramInt1 = paramInt2;
        if (f1 == paramFloat2) {
          paramInt1 = paramInt2 - 1;
        }
        paramSpannableString.setSpan(new RelativeSizeSpan(f1), ((Integer)((Pair)paramArrayList.get(k)).first).intValue(), ((Integer)((Pair)paramArrayList.get(k)).second).intValue(), 33);
        if (QLog.isColorLevel()) {
          QLog.d("ChatItemBuilder", 2, "generateMagicFont word change: " + ((Pair)paramArrayList.get(k)).first + " , " + ((Pair)paramArrayList.get(k)).second + " size = " + f1 + " index = " + k + " forceChange = " + bool1);
        }
        i += 1;
        int n = 1;
        paramInt2 = paramInt1;
        m = j;
        j = n;
      }
    }
    for (;;)
    {
      paramInt1 = j;
      if (paramInt3 > 0)
      {
        paramInt1 = j;
        if (k % paramInt3 == paramInt3 - 1) {
          paramInt1 = 0;
        }
      }
      paramLong = (25214903917L * paramLong + 11L & 0xFFFFFFFF) >> 16;
      k += 1;
      j = paramInt1;
      paramInt1 = m;
      break;
      if ((paramInt2 <= 0) && (paramInt1 > 0))
      {
        f1 = paramFloat1;
        break label97;
      }
      if (i % 2 == 1)
      {
        f1 = paramFloat2;
        break label97;
        return;
      }
      f1 = paramFloat1;
      break label97;
      label405:
      m = paramInt1;
    }
  }
  
  public static void a(Message paramMessage, XListView paramXListView)
  {
    long l = paramMessage.getData().getLong("msg_id");
    paramXListView = AIOUtils.a(paramXListView, AIOUtils.a(l, paramXListView.getAdapter()));
    if ((paramXListView != null) && ((paramXListView.getTag() instanceof TextItemBuilder.Holder)))
    {
      paramXListView = (TextItemBuilder.Holder)paramXListView.getTag();
      if (paramXListView.jdField_a_of_type_Long == l)
      {
        if ((paramMessage.obj instanceof SpannableString))
        {
          paramMessage = (SpannableString)paramMessage.obj;
          paramXListView.jdField_d_of_type_AndroidWidgetTextView.setText(paramMessage);
          ((ETTextView)paramXListView.jdField_d_of_type_AndroidWidgetTextView).mMagicFont = true;
          if ((paramXListView.jdField_d_of_type_AndroidWidgetTextView instanceof ETTextView))
          {
            ETTextView localETTextView = (ETTextView)paramXListView.jdField_d_of_type_AndroidWidgetTextView;
            if (localETTextView.mFont != null) {
              localETTextView.mFont.mText = paramMessage;
            }
          }
        }
        if (((ETTextView)paramXListView.jdField_d_of_type_AndroidWidgetTextView).isUsingHYFont()) {
          ((ETTextView)paramXListView.jdField_d_of_type_AndroidWidgetTextView).isParsingMagicFont = false;
        }
        paramXListView.jdField_d_of_type_AndroidWidgetTextView.requestLayout();
      }
    }
  }
  
  private void a(ChatMessage arg1, FontInfo paramFontInfo, ETTextView paramETTextView)
  {
    MessageForText localMessageForText;
    CharSequence localCharSequence;
    if ((??? instanceof MessageForText))
    {
      localMessageForText = (MessageForText)???;
      localCharSequence = null;
      if (!android.text.TextUtils.isEmpty(localMessageForText.sb))
      {
        if (android.text.TextUtils.isEmpty(localMessageForText.sb2)) {
          break label128;
        }
        localCharSequence = localMessageForText.sb2;
      }
    }
    for (;;)
    {
      long l1;
      long l2;
      if ((localCharSequence != null) && (com.tencent.mobileqq.text.TextUtils.hasChnChar(localCharSequence)))
      {
        l1 = ((MessageForText)???).msgUid;
        l2 = ((MessageForText)???).uniseq;
      }
      synchronized (jdField_a_of_type_ComTencentUtilLRULinkedHashMap)
      {
        if (jdField_a_of_type_ComTencentUtilLRULinkedHashMap.containsKey(Long.valueOf(l2)))
        {
          paramFontInfo = (SpannableString)jdField_a_of_type_ComTencentUtilLRULinkedHashMap.get(Long.valueOf(l2));
          if (paramFontInfo != null)
          {
            paramETTextView.setText(paramFontInfo);
            paramETTextView.mMagicFont = true;
          }
          return;
          label128:
          localCharSequence = localMessageForText.sb;
          continue;
        }
        if ((paramFontInfo != null) && (paramFontInfo.jdField_b_of_type_Int == 1)) {
          paramETTextView.isParsingMagicFont = true;
        }
        ArkRecommendLogic.a().post(new TextItemBuilder.8(this, localCharSequence, l1, l2));
      }
    }
  }
  
  private void a(ChatMessage paramChatMessage, FontManager paramFontManager, FontInfo paramFontInfo, ETTextView paramETTextView, String paramString)
  {
    if ((paramFontInfo != null) && (paramFontInfo.jdField_a_of_type_Int != 0))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin().equals(paramString))
      {
        if (FontManager.jdField_a_of_type_Long == 0L) {
          FontManager.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getLong("personal_font_last_send_report", 1L);
        }
        if ((FontManager.jdField_a_of_type_Long < FontManager.jdField_c_of_type_Long) && (paramChatMessage.time * 1000L > FontManager.jdField_c_of_type_Long))
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Font_Mall", "0X8007B2B", 0, 0, "" + (paramFontInfo.jdField_b_of_type_Int - 1), "" + paramFontInfo.jdField_a_of_type_Int, "", "");
          FontManager.jdField_a_of_type_Long = paramChatMessage.time * 1000L;
          paramFontManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit();
          paramFontManager.putLong("personal_font_last_send_report", paramChatMessage.time * 1000L);
          paramFontManager.commit();
        }
        if (paramFontInfo.jdField_a_of_type_ComEtrumpMixlayoutETFont == null) {
          break label501;
        }
        paramFontManager = paramFontInfo.jdField_a_of_type_ComEtrumpMixlayoutETFont;
        paramFontManager.setSize(paramETTextView.getTextSize());
        label226:
        if (!android.text.TextUtils.isEmpty(paramChatMessage.getExtInfoFromExtStr("font_animation_played"))) {
          break label533;
        }
      }
      label533:
      for (paramETTextView.shouldStartAnimation = true;; paramETTextView.shouldStartAnimation = false)
      {
        paramETTextView.setFont(paramFontManager, paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        if (QLog.isColorLevel()) {
          QLog.d("VasFont", 2, "updateTextFont  fontId = " + paramFontInfo.jdField_a_of_type_Int + "fontType = " + paramFontInfo.jdField_b_of_type_Int + "typeface = " + paramFontInfo.jdField_a_of_type_AndroidGraphicsTypeface);
        }
        return;
        if (FontManager.jdField_b_of_type_Long == 0L) {
          FontManager.jdField_b_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getLong("personal_font_last_receive_report", 1L);
        }
        if ((FontManager.jdField_b_of_type_Long >= FontManager.jdField_c_of_type_Long) || (paramChatMessage.time * 1000L <= FontManager.jdField_c_of_type_Long)) {
          break;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Font_Mall", "0X8007B2C", 0, 0, "" + (paramFontInfo.jdField_b_of_type_Int - 1), "" + paramFontInfo.jdField_a_of_type_Int, "", "");
        FontManager.jdField_b_of_type_Long = paramChatMessage.time * 1000L;
        paramFontManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit();
        paramFontManager.putLong("personal_font_last_receive_report", paramChatMessage.time * 1000L);
        paramFontManager.commit();
        break;
        label501:
        paramFontManager = new ETFont(paramFontInfo.jdField_a_of_type_Int, paramFontInfo.jdField_a_of_type_JavaLangString, paramETTextView.getTextSize(), paramFontInfo.jdField_b_of_type_Int, paramFontInfo.jdField_a_of_type_AndroidGraphicsTypeface);
        break label226;
      }
    }
    if (VasShieldFont.jdField_a_of_type_Int == 4) {
      if (paramFontManager.a(9999))
      {
        paramETTextView.setDefaultFont(VasShieldFont.a(paramChatMessage), paramChatMessage.uniseq);
        label572:
        if (!QLog.isColorLevel()) {
          break label641;
        }
        paramFontManager = new StringBuilder().append("updateTextFont fontinfo = ");
        if (paramFontInfo != null) {
          break label643;
        }
      }
    }
    label641:
    label643:
    for (paramChatMessage = "null";; paramChatMessage = paramFontInfo.toString())
    {
      QLog.d("VasFont", 2, paramChatMessage);
      return;
      VasShieldFont.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      break label572;
      paramETTextView.setDefaultFont(VasShieldFont.a(paramChatMessage), paramChatMessage.uniseq);
      break label572;
      break;
    }
  }
  
  private void a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, TextItemBuilder.Holder paramHolder)
  {
    if ((paramHolder.jdField_d_of_type_AndroidWidgetTextView instanceof AnimationTextView))
    {
      paramHolder = (AnimationTextView)paramHolder.jdField_d_of_type_AndroidWidgetTextView;
      ((IApolloUtil)QRoute.api(IApolloUtil.class)).playApolloEmoticonAction(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage, paramHolder, paramViewHolder.jdField_b_of_type_Int, paramViewHolder.c, false);
      paramHolder.onDoubleClick = this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick;
      paramHolder.onSingleClick = new TextItemBuilder.4(this, paramChatMessage.isSend());
    }
  }
  
  private void a(ChatMessage paramChatMessage, TextItemBuilder.Holder paramHolder)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqStudymodeAlphabeticFontHelper == null) {
      this.jdField_a_of_type_ComTencentMobileqqStudymodeAlphabeticFontHelper = new AlphabeticFontHelper();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqStudymodeAlphabeticFontHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ETTextView)paramHolder.jdField_d_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int)) {
      return;
    }
    FontManager localFontManager = (FontManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CHAT_FONT_MANAGER);
    FontInfo localFontInfo = localFontManager.b(paramChatMessage);
    ETTextView localETTextView = (ETTextView)paramHolder.jdField_d_of_type_AndroidWidgetTextView;
    localETTextView.setMinWidth(AIOUtils.a(65.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    if ((!(paramChatMessage instanceof MessageForReplyText)) || (!(paramHolder instanceof ReplyTextItemBuilder.ReplyTextViewHolder))) {
      localETTextView.setMinHeight(AIOUtils.a(57.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    }
    paramHolder = FontManager.a(paramChatMessage);
    if ((localFontInfo != null) && (localFontInfo.jdField_b_of_type_Int == 1)) {
      localETTextView.isParsingMagicFont = false;
    }
    if (FontManager.a(paramChatMessage)) {
      a(paramChatMessage, localFontInfo, localETTextView);
    }
    if (localFontManager != null) {
      localFontManager.a(paramChatMessage, localFontInfo, paramHolder);
    }
    a(paramChatMessage, localFontManager, localFontInfo, localETTextView, paramHolder);
  }
  
  private void a(MessageForText paramMessageForText, ETTextView paramETTextView, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3)
  {
    paramCharSequence3 = new SpannableStringBuilder(paramCharSequence2).append(paramCharSequence3);
    paramCharSequence3.setSpan(new TextItemBuilder.5(this, paramMessageForText, paramETTextView, paramCharSequence1), paramCharSequence2.length(), paramCharSequence3.length(), 33);
    paramETTextView.setTextMsg(paramCharSequence3);
    paramETTextView.setHighlightColor(0);
    paramETTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramETTextView.setFocusable(false);
  }
  
  private void a(QQCustomMenu paramQQCustomMenu, ChatMessage paramChatMessage)
  {
    int i = TroopEssenceUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (i == 2) {
      a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131366428, paramChatMessage, null);
    }
    while (i != 1) {
      return;
    }
    a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131366427, paramChatMessage, null);
  }
  
  private boolean a(long paramLong, ArrayList<Pair<Integer, Integer>> paramArrayList, float paramFloat1, float paramFloat2, boolean paramBoolean, SpannableString paramSpannableString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "generateMagicFont oneWord");
    }
    if ((!paramBoolean) || (((Integer)((Pair)paramArrayList.get(0)).second).intValue() - ((Integer)((Pair)paramArrayList.get(0)).first).intValue() <= 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "generateMagicFont oneWord switch = " + paramBoolean + " length = " + (((Integer)((Pair)paramArrayList.get(0)).second).intValue() - ((Integer)((Pair)paramArrayList.get(0)).first).intValue()));
      }
      return true;
    }
    if (((Integer)((Pair)paramArrayList.get(0)).second).intValue() - ((Integer)((Pair)paramArrayList.get(0)).first).intValue() == 2) {}
    for (int i = 1;; i = 2)
    {
      int m = 0;
      int k = 0;
      int n = i;
      int j;
      if (k < ((Integer)((Pair)paramArrayList.get(0)).second).intValue() - ((Integer)((Pair)paramArrayList.get(0)).first).intValue())
      {
        i = m;
        j = n;
        if (paramLong % (((Integer)((Pair)paramArrayList.get(0)).second).intValue() - ((Integer)((Pair)paramArrayList.get(0)).first).intValue() - k) < n) {
          if (m % 2 != 1) {
            break label478;
          }
        }
      }
      label478:
      for (float f1 = paramFloat2;; f1 = paramFloat1)
      {
        paramSpannableString.setSpan(new RelativeSizeSpan(f1), ((Integer)((Pair)paramArrayList.get(0)).first).intValue() + k, ((Integer)((Pair)paramArrayList.get(0)).first).intValue() + k + 1, 33);
        n -= 1;
        m += 1;
        i = m;
        j = n;
        if (QLog.isColorLevel())
        {
          QLog.d("ChatItemBuilder", 2, "generateMagicFont oneWord change index = " + ((Pair)paramArrayList.get(0)).first + k + " changeSize = " + f1);
          j = n;
          i = m;
        }
        paramLong = (25214903917L * paramLong + 11L & 0xFFFFFFFF) >> 16;
        k += 1;
        m = i;
        n = j;
        break;
        return false;
      }
    }
  }
  
  private boolean a(BaseBubbleBuilder.ViewHolder paramViewHolder, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForLongTextMsg)) {}
    while ((AIOUtils.h) || (!(paramViewHolder instanceof TextItemBuilder.Holder))) {
      return true;
    }
    return false;
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
      paramHolder.jdField_d_of_type_AndroidWidgetTextView.setTextColor(i);
      paramHolder.jdField_d_of_type_AndroidWidgetTextView.setLinkTextColor(j);
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
    } while (!QIMUserManager.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo));
    if (!paramChatMessage.isSend()) {
      i = 1;
    }
    if (i != 0) {
      j = Color.parseColor("#ff000000");
    }
    for (i = Color.parseColor("#ff80e9ff");; i = Color.parseColor("#ff5078f0"))
    {
      paramHolder.jdField_d_of_type_AndroidWidgetTextView.setTextColor(j);
      paramHolder.jdField_d_of_type_AndroidWidgetTextView.setLinkTextColor(i);
      return true;
      j = Color.parseColor("#FFFFFFFF");
    }
  }
  
  private void b(View paramView, ChatMessage paramChatMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "C2CMessageFold textItemBuilder flag: " + paramChatMessage.getExtInfoFromExtStr("key_message_extra_info_flag"));
    }
    a(paramChatMessage);
    ETTextView localETTextView;
    MessageForText localMessageForText;
    if (((paramView instanceof ETTextView)) && ((paramChatMessage instanceof MessageForText)) && (MessageFoldable.a(paramChatMessage)))
    {
      localETTextView = (ETTextView)paramView;
      localMessageForText = (MessageForText)paramChatMessage;
      if (android.text.TextUtils.isEmpty(localMessageForText.sb)) {
        break label216;
      }
      if (android.text.TextUtils.isEmpty(localMessageForText.sb2)) {
        break label207;
      }
      paramView = localMessageForText.sb2;
    }
    for (;;)
    {
      int i = a(localETTextView, paramView);
      int j = BaseChatItemLayout.e - e - f;
      if (i > j)
      {
        String str = this.jdField_a_of_type_AndroidContentContext.getString(2131694726);
        CharSequence localCharSequence = android.text.TextUtils.ellipsize(paramView, localETTextView.getPaint(), j - a(localETTextView, str), TextUtils.TruncateAt.END);
        if (!localETTextView.isUsingFZColorFont2())
        {
          paramChatMessage = localCharSequence;
          if (!localETTextView.isUsingHYFont()) {}
        }
        else
        {
          paramChatMessage = a(localCharSequence, 3);
        }
        a(localMessageForText, localETTextView, paramView, paramChatMessage, str);
      }
      return;
      label207:
      paramView = localMessageForText.sb;
      continue;
      label216:
      paramView = "";
    }
  }
  
  private void b(ChatMessage paramChatMessage)
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity))
    {
      Object localObject = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a();
      if (localObject != null)
      {
        localObject = (WriteTogetherHelper)((BaseChatPie)localObject).a(74);
        if ((localObject != null) && ((paramChatMessage instanceof MessageForText))) {
          ((WriteTogetherHelper)localObject).b(((MessageForText)paramChatMessage).sb.toString(), 3);
        }
      }
    }
  }
  
  private void b(ChatMessage paramChatMessage, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", -1);
    MessageForText localMessageForText;
    Object localObject;
    int i;
    if ((paramChatMessage instanceof MessageForText))
    {
      ECommerceDataReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, 3);
      localMessageForText = (MessageForText)paramChatMessage;
      if (!AIOSelectableDelegateImpl.a().c()) {
        break label456;
      }
      localObject = AIOSelectableDelegateImpl.a().b();
      if (localObject == null) {
        break label451;
      }
      if (((String)localObject).length() != AIOSelectableDelegateImpl.a().a()) {
        break label446;
      }
      i = 1;
      if (!MessageFoldable.a(paramChatMessage)) {
        break label556;
      }
      localObject = ((MessageForText)paramChatMessage).sb.toString();
      i = 1;
    }
    label513:
    label519:
    label556:
    for (;;)
    {
      localBundle.putString("forward_text", (String)localObject);
      localBundle.putInt("selection_mode", this.jdField_b_of_type_Int);
      localBundle.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      boolean bool = localMessageForText instanceof MessageForWriteTogether;
      localBundle.putBooleanArray("forward_is_write_together", new boolean[] { bool });
      int j;
      label176:
      label191:
      String str;
      label206:
      int k;
      if (bool)
      {
        j = ((MessageForWriteTogether)localMessageForText).baseRev;
        if (!bool) {
          break label497;
        }
        localObject = ((MessageForWriteTogether)localMessageForText).padId;
        if (!bool) {
          break label505;
        }
        str = ((MessageForWriteTogether)localMessageForText).token;
        if (!bool) {
          break label513;
        }
        k = 1;
        label214:
        localBundle.putString("forward_source_uin", localMessageForText.frienduin);
        localBundle.putIntArray("forward_write_together_base_rev", new int[] { j });
        localBundle.putStringArray("forward_write_together_pad_id", new String[] { localObject });
        localBundle.putStringArray("forward_write_together_token", new String[] { str });
        localBundle.putInt("forward_write_together_number", k);
        localObject = new Intent();
        ((Intent)localObject).putExtras(localBundle);
        ((Intent)localObject).putExtra("direct_send_if_dataline_forward", true);
        ForwardBaseOption.a((Activity)this.jdField_a_of_type_AndroidContentContext, (Intent)localObject, 21);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "1", "", "", "");
        if (i == 0) {
          break label519;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", paramString, "0X8009AAB", "0X8009AAB", 2, 0, "", "", "", "");
      }
      for (;;)
      {
        if (paramChatMessage.isMultiMsg) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D66", "0X8009D66", 1, 0, "1", "", "", "");
        }
        return;
        label446:
        i = 0;
        break;
        label451:
        i = 0;
        break;
        label456:
        if (localMessageForText.sb != null) {}
        for (localObject = localMessageForText.sb.toString();; localObject = localMessageForText.msg)
        {
          i = 1;
          break;
        }
        j = 0;
        break label176;
        label497:
        localObject = "";
        break label191;
        label505:
        str = "";
        break label206;
        k = 0;
        break label214;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", paramString, "0X8009AAC", "0X8009AAC", 3, 0, "", "", "", "");
      }
    }
  }
  
  private boolean b(ChatMessage paramChatMessage, TextItemBuilder.Holder paramHolder)
  {
    boolean bool = false;
    if (((paramChatMessage.istroop != 3000) && (paramChatMessage.istroop != 1)) || ((paramChatMessage.isShowQIMStyleGroup) || (LimitChatUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) || ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.h)) || (SimpleUIUtil.a())))
    {
      ETFont localETFont = new ETFont(0, null, 0.0F);
      if ((paramHolder.jdField_d_of_type_AndroidWidgetTextView instanceof ETTextView)) {
        ((ETTextView)paramHolder.jdField_d_of_type_AndroidWidgetTextView).setFont(localETFont, paramChatMessage.uniseq);
      }
      bool = true;
    }
    return bool;
  }
  
  private void c(View paramView)
  {
    if (paramView == null) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
    if (localLayoutParams == null)
    {
      paramView.setVisibility(8);
      return;
    }
    a(localLayoutParams);
    localLayoutParams.addRule(5, 0);
    localLayoutParams.addRule(7, 2131364634);
    localLayoutParams.addRule(3, 2131364634);
    localLayoutParams.rightMargin = (this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296404) + DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
    paramView.setVisibility(0);
  }
  
  private void c(ChatMessage paramChatMessage, String paramString)
  {
    paramChatMessage = a(paramChatMessage, paramString, AIOSelectableDelegateImpl.a());
    if (paramChatMessage != null) {}
    try
    {
      ((ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(paramChatMessage);
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "Copy message, msg=" + paramChatMessage);
      }
      return;
    }
    catch (Exception paramChatMessage)
    {
      QLog.e("ChatItemBuilder", 2, paramChatMessage.toString());
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  SpannableString a(CharSequence paramCharSequence, long paramLong)
  {
    String str1 = com.tencent.mobileqq.text.TextUtils.replaceEmojiWithSpace(paramCharSequence.toString());
    if (android.text.TextUtils.isEmpty(str1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "generateMagicFont msg is empty");
      }
      return null;
    }
    long l1 = System.currentTimeMillis();
    Object localObject = ArkAiDictMgr.a(null, str1);
    String[] arrayOfString = ((ArkAiDictMgr.WordSegmentResult)localObject).jdField_a_of_type_ArrayOfJavaLangString;
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "generateMagicFont word segment cost " + (l2 - l1) + "ms; msg length = " + paramCharSequence.length());
    }
    if (!((ArkAiDictMgr.WordSegmentResult)localObject).jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "generateMagicFont so not init");
      }
      return null;
    }
    if (arrayOfString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ChatItemBuilder", 2, "generateMagicFont words = null");
      }
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "generateMagicFont words count = " + arrayOfString.length);
    }
    int i = 0;
    localObject = new ArrayList();
    int j = 0;
    if (j < arrayOfString.length)
    {
      while ((i < str1.length()) && (str1.charAt(i) == ' ')) {
        i += 1;
      }
      String str2 = arrayOfString[j];
      int k = 0;
      for (;;)
      {
        if ((k >= str2.length()) || (str2.charAt(k) < '一') || (str2.charAt(k) > 40891))
        {
          if (k == str2.length()) {
            ((ArrayList)localObject).add(new Pair(Integer.valueOf(i), Integer.valueOf(str2.length() + i)));
          }
          i += str2.length();
          j += 1;
          break;
        }
        k += 1;
      }
    }
    if (((ArrayList)localObject).size() < 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "generateMagicFont words count = 0");
      }
      return null;
    }
    return a(paramCharSequence, paramLong, (ArrayList)localObject);
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    Context localContext = paramBaseChatItemLayout.getContext();
    TextItemBuilder.Holder localHolder;
    Object localObject1;
    label155:
    Object localObject2;
    Object localObject3;
    if ((paramViewHolder instanceof TextItemBuilder.Holder))
    {
      localHolder = (TextItemBuilder.Holder)paramViewHolder;
      if (paramView != null) {
        break label973;
      }
      localObject1 = new ImageView(localContext);
      ((ImageView)localObject1).setId(2131367238);
      paramView = new RelativeLayout.LayoutParams(-2, -2);
      paramView.addRule(0, 2131364634);
      paramView.addRule(15, 2131363508);
      ((ImageView)localObject1).setContentDescription(HardCodeUtil.a(2131714735));
      paramBaseChatItemLayout.addView((View)localObject1, paramView);
      ((ImageView)localObject1).setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      paramView = new ETTextView(localContext);
      com.tencent.mobileqq.text.TextUtils.fixTextViewANRForAnd10(paramView);
      paramView.setTextColor(localContext.getResources().getColorStateList(2131167052));
      paramView.setLinkTextColor(localContext.getResources().getColorStateList(2131167045));
      if (!AppSetting.d) {
        break label937;
      }
      paramView.setAutoLinkMask(3);
      paramView.setSpannableFactory(QQText.SPANNABLE_FACTORY);
      paramView.setMaxWidth(BaseChatItemLayout.e);
      paramView.setMovementMethod(LinkMovementMethod.getInstance());
      paramView.setTextAnimationListener(this.jdField_a_of_type_ComEtrumpMixlayoutETTextView$TextAnimationListener);
      paramView.setId(2131364637);
      localObject2 = new ImageView(localContext);
      ((ImageView)localObject2).setId(2131367239);
      localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject3).addRule(1, 2131364634);
      ((RelativeLayout.LayoutParams)localObject3).addRule(15, 2131363508);
      ((ImageView)localObject2).setContentDescription(HardCodeUtil.a(2131714737));
      ((RelativeLayout.LayoutParams)localObject3).leftMargin = 10;
      paramBaseChatItemLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      ((ImageView)localObject2).setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      localHolder.jdField_d_of_type_AndroidWidgetTextView = paramView;
      localHolder.b = ((ImageView)localObject1);
      localHolder.c = ((ImageView)localObject2);
      localHolder.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOSelectableDelegateProxy = new AIOSelectableDelegateProxy();
      localHolder.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOSelectableDelegateProxy.a(paramView);
      localHolder.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOSelectableDelegateProxy.a(paramBaseChatItemLayout, paramBaseChatItemLayout);
    }
    label937:
    label966:
    label973:
    for (;;)
    {
      ((ETTextView)localHolder.jdField_d_of_type_AndroidWidgetTextView).setFont(0, paramChatMessage.uniseq);
      localHolder.jdField_d_of_type_AndroidWidgetTextView.setTypeface(null);
      ((ETTextView)localHolder.jdField_d_of_type_AndroidWidgetTextView).setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      ((ETTextView)localHolder.jdField_d_of_type_AndroidWidgetTextView).setStrokeColor(false, 0);
      ((ETTextView)localHolder.jdField_d_of_type_AndroidWidgetTextView).mMagicFont = false;
      ((ETTextView)localHolder.jdField_d_of_type_AndroidWidgetTextView).setCacheMeasureResult(true);
      localHolder.jdField_d_of_type_AndroidWidgetTextView.setTypeface(VasShieldFont.a(paramChatMessage));
      if (!android.text.TextUtils.isEmpty(paramChatMessage.getExtInfoFromExtStr("sens_msg_ctrl_info")))
      {
        localObject1 = ((ETTextView)localHolder.jdField_d_of_type_AndroidWidgetTextView).getETLayout();
        if (localObject1 != null) {
          ((ETLayout)localObject1).jdField_a_of_type_Long = (paramChatMessage.uniseq + 1L);
        }
      }
      localHolder.jdField_d_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
      localHolder.jdField_d_of_type_AndroidWidgetTextView.setGravity(16);
      int j = BaseChatItemLayout.o;
      int i = BaseChatItemLayout.p;
      if (paramChatMessage.isSend())
      {
        j = BaseChatItemLayout.p;
        i = BaseChatItemLayout.o;
      }
      localHolder.jdField_d_of_type_AndroidWidgetTextView.setPadding(j, BaseChatItemLayout.m, i, BaseChatItemLayout.n);
      localHolder.jdField_a_of_type_Long = paramChatMessage.uniseq;
      localObject1 = a(paramChatMessage, localContext, localHolder);
      localObject2 = (TroopRobotManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER);
      if (TroopRobotManager.b(paramChatMessage)) {
        TroopRobotManager.a(localHolder.jdField_d_of_type_AndroidWidgetTextView, paramChatMessage);
      }
      localObject3 = AioVipKeywordHelper.a();
      if (((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)) && (!paramChatMessage.isread))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AioVipKeywordHelper", 4, "detectKeyword in TextItemBuilder.getBubbleView()");
        }
        ((AioVipKeywordHelper)localObject3).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage, (String)localObject1, localContext, paramChatMessage.isSend());
      }
      localHolder.jdField_d_of_type_AndroidWidgetTextView.setOnTouchListener(paramOnLongClickAndTouchListener);
      localHolder.jdField_d_of_type_AndroidWidgetTextView.setOnLongClickListener(paramOnLongClickAndTouchListener);
      localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener = paramOnLongClickAndTouchListener;
      localHolder.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      a(paramChatMessage, paramViewHolder, localHolder);
      a(paramChatMessage, paramBaseChatItemLayout, localContext, localHolder);
      if (localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout != null)
      {
        if (((TroopRobotManager)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage)) {
          localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setRobotNextTipsView(true, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
        }
      }
      else
      {
        label767:
        if (localHolder.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOSelectableDelegateProxy != null) {
          localHolder.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOSelectableDelegateProxy.b(paramChatMessage);
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (!(this instanceof WriteTogetherItemBuilder)))
        {
          localHolder.jdField_d_of_type_AndroidViewView = super.a(localHolder.jdField_d_of_type_AndroidViewView, localHolder, paramBaseChatItemLayout, paramChatMessage, -2, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 21.0F));
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString == null)) {
            break label966;
          }
        }
      }
      for (paramViewHolder = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;; paramViewHolder = "")
      {
        boolean bool = TroopEssenceUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, paramViewHolder);
        if ((localHolder.jdField_a_of_type_AndroidViewView != null) && (bool) && (localHolder.jdField_d_of_type_AndroidViewView != null)) {
          localHolder.jdField_a_of_type_AndroidViewView.post(new TextItemBuilder.3(this, localHolder, paramChatMessage, paramChatMessage));
        }
        return paramView;
        localHolder = (TextItemBuilder.Holder)a();
        localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramBaseChatItemLayout;
        paramBaseChatItemLayout.setTag(localHolder);
        paramView = null;
        break;
        paramView.setAutoLinkMask(0);
        break label155;
        localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setRobotNextTipsView(false, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
        break label767;
      }
    }
  }
  
  public BaseBubbleBuilder.TouchDelegate a(View paramView)
  {
    if (BubbleUtils.a(paramView)) {
      return this;
    }
    return null;
  }
  
  public BaseBubbleBuilder.ViewHolder a()
  {
    return new TextItemBuilder.Holder();
  }
  
  public CharSequence a(CharSequence paramCharSequence, int paramInt)
  {
    if ((paramInt > paramCharSequence.length() - 1) || (paramInt <= 0)) {
      return paramCharSequence;
    }
    if ((paramCharSequence instanceof Spanned)) {}
    int i;
    for (Object localObject = (Spanned)paramCharSequence;; localObject = null)
    {
      i = paramCharSequence.length();
      if (localObject != null) {
        break;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramCharSequence, 0, i - paramInt - 1);
      ((StringBuilder)localObject).append(paramCharSequence, i - 1, i);
      return ((StringBuilder)localObject).toString();
    }
    localObject = new SpannableStringBuilder();
    ((SpannableStringBuilder)localObject).append(paramCharSequence, 0, i - paramInt - 1);
    ((SpannableStringBuilder)localObject).append(paramCharSequence, i - 1, i);
    return localObject;
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    if (((paramChatMessage instanceof MessageForText)) || ((paramChatMessage instanceof MessageForReplyText))) {
      return HardCodeUtil.a(2131714734) + com.tencent.mobileqq.text.TextUtils.emoticonToTextForTalkBack(paramChatMessage.msg);
    }
    return HardCodeUtil.a(2131714732) + paramChatMessage.msg;
  }
  
  String a(ChatMessage paramChatMessage, String paramString, AIOSelectableDelegateImpl paramAIOSelectableDelegateImpl)
  {
    if (paramChatMessage.msg != null)
    {
      ECommerceDataReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, 2);
      int i;
      if (paramChatMessage.isMultiMsg)
      {
        MultiMsgUtil.a("0X8009AB7");
        i = 1;
        if ((paramChatMessage instanceof MessageForLongTextMsg)) {
          i = 2;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D65", "0X8009D65", i, 0, "" + i, "", "", "");
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800644A", "0X800644A", 0, 0, "1", "", "", "");
      int j;
      if (paramAIOSelectableDelegateImpl.c())
      {
        String str = paramAIOSelectableDelegateImpl.b();
        if (str != null) {
          if (str.length() == paramAIOSelectableDelegateImpl.a())
          {
            i = 1;
            j = i;
            paramAIOSelectableDelegateImpl = str;
            if ((paramChatMessage instanceof MessageForText))
            {
              j = i;
              paramAIOSelectableDelegateImpl = str;
              if (MessageFoldable.a(paramChatMessage))
              {
                paramAIOSelectableDelegateImpl = ((MessageForText)paramChatMessage).sb.toString();
                j = 1;
              }
            }
            label210:
            if (j == 0) {
              break label274;
            }
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", paramString, "0X8009AAB", "0X8009AAB", 1, 0, "", "", "", "");
          }
        }
      }
      for (;;)
      {
        return paramAIOSelectableDelegateImpl;
        i = 0;
        break;
        i = 0;
        break;
        paramAIOSelectableDelegateImpl = paramChatMessage.msg;
        j = 1;
        break label210;
        label274:
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", paramString, "0X8009AAC", "0X8009AAC", 1, 0, "", "", "", "");
      }
    }
    return null;
  }
  
  public void a()
  {
    super.a();
    ETEngine.getInstance().onAIODestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqStudymodeAlphabeticFontHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqStudymodeAlphabeticFontHelper.a();
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    String str1;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      String str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      str1 = str2;
      if (android.text.TextUtils.isEmpty(str2)) {
        str1 = "";
      }
    }
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
    case 2131365636: 
    case 2131365448: 
    case 2131376982: 
    case 2131367398: 
    case 2131366625: 
      do
      {
        do
        {
          do
          {
            return;
            str1 = "";
            break;
            ChatActivityFacade.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006447", "0X8006447", 0, 0, "1", "", "", "");
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAB", "0X8009AAB", 6, 0, "", "", "", "");
            return;
            c(paramChatMessage, str1);
            return;
          } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
          ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage.msg, paramChatMessage.uniseq);
          return;
          b(paramChatMessage, str1);
          return;
        } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
        a(paramChatMessage, str1);
        ECommerceDataReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, 4);
        QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, 0, paramChatMessage.istroop);
      } while (!paramChatMessage.isMultiMsg);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D67", "0X8009D67", 1, 0, "1", "", "", "");
      return;
    case 2131371997: 
      super.a(paramInt, paramContext, paramChatMessage);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAB", "0X8009AAB", 7, 0, "", "", "", "");
      return;
    case 2131371954: 
      super.a(paramInt, paramContext, paramChatMessage);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAB", "0X8009AAB", 5, 0, "", "", "", "");
      return;
    case 2131377708: 
      AIOSelectableDelegateImpl.a().a(paramChatMessage);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAC", "0X8009AAC", 2, 0, "", "", "", "");
      return;
    case 2131376927: 
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAB", "0X8009AAB", 3, 0, "", "", "", "");
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    }
    b(paramChatMessage);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (AIOUtils.a(paramView).isMultiMsg) {}
    String str1;
    String str2;
    do
    {
      return;
      paramView = (MessageForText)AIOUtils.a(paramView);
      str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131690018);
      str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131690019);
    } while (!paramView.isSendFromLocal());
    DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, str1, str2, new TextItemBuilder.6(this, paramView), new TextItemBuilder.7(this)).show();
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
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend()) {
      paramView.setPadding(f, c, e, d);
    }
    for (;;)
    {
      b(paramView, paramChatMessage);
      return;
      paramView.setPadding(e, c, f, d);
    }
  }
  
  public void a(View paramView, ChatMessage paramChatMessage, int paramInt)
  {
    super.a(paramView, paramChatMessage, paramInt);
    if (paramInt == 1)
    {
      BaseBubbleBuilder.ViewHolder localViewHolder = (BaseBubbleBuilder.ViewHolder)paramView.getTag();
      if (localViewHolder != null) {
        a(localViewHolder, paramView, paramChatMessage, localViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo);
      }
    }
    paramView = (BaseBubbleBuilder.ViewHolder)paramView.getTag();
    if (paramView != null) {
      b(paramView.jdField_a_of_type_AndroidViewView, paramChatMessage);
    }
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
  
  public void a(BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, ChatMessage paramChatMessage, BubbleInfo paramBubbleInfo)
  {
    Object localObject;
    if ((paramChatMessage instanceof MessageForLongTextMsg))
    {
      localObject = (MessageForLongTextMsg)paramChatMessage;
      if ((!((MessageForLongTextMsg)localObject).getExtInfoFromExtStr("long_text_recv_state").equals("2")) && (!((MessageForLongTextMsg)localObject).getExtInfoFromExtStr("long_text_recv_state").equals("3"))) {}
    }
    label47:
    label202:
    label210:
    do
    {
      do
      {
        break label47;
        break label47;
        do
        {
          return;
        } while (!(paramViewHolder instanceof TextItemBuilder.Holder));
        localObject = (TextItemBuilder.Holder)paramViewHolder;
      } while (a(paramChatMessage, (TextItemBuilder.Holder)localObject));
      boolean bool = SimpleUIUtil.a();
      if ((paramBubbleInfo.jdField_a_of_type_Int == 0) || (!paramBubbleInfo.a()) || (bool))
      {
        paramView = paramView.getResources();
        int i;
        if (paramChatMessage.isSend())
        {
          paramViewHolder = paramView.getColorStateList(2131167056);
          ((TextItemBuilder.Holder)localObject).jdField_d_of_type_AndroidWidgetTextView.setTextColor(paramViewHolder);
          if ((LimitChatUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) || (ConfessMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)))
          {
            if (!paramChatMessage.isSend()) {
              break label202;
            }
            i = -1;
            ((TextItemBuilder.Holder)localObject).jdField_d_of_type_AndroidWidgetTextView.setTextColor(i);
          }
          if (!paramChatMessage.isSend()) {
            break label210;
          }
        }
        for (paramViewHolder = paramView.getColorStateList(2131167055);; paramViewHolder = paramView.getColorStateList(2131167054))
        {
          ((TextItemBuilder.Holder)localObject).jdField_d_of_type_AndroidWidgetTextView.setLinkTextColor(paramViewHolder);
          return;
          paramViewHolder = paramView.getColorStateList(2131167052);
          break;
          i = -16777216;
          break label156;
        }
      }
      ColorStateList.valueOf(paramBubbleInfo.jdField_b_of_type_Int);
      if (paramBubbleInfo.jdField_b_of_type_Int == 0)
      {
        ((TextItemBuilder.Holder)localObject).jdField_d_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        ColorStateList.valueOf(-16777216);
        if (paramBubbleInfo.c != 0) {
          break label394;
        }
      }
      for (paramViewHolder = paramView.getResources().getColorStateList(2131167054);; paramViewHolder = ColorStateList.valueOf(paramBubbleInfo.c))
      {
        ((TextItemBuilder.Holder)localObject).jdField_d_of_type_AndroidWidgetTextView.setLinkTextColor(paramViewHolder);
        if (!(((TextItemBuilder.Holder)localObject).jdField_d_of_type_AndroidWidgetTextView instanceof ETTextView)) {
          break;
        }
        if (!paramBubbleInfo.jdField_a_of_type_Boolean) {
          break label406;
        }
        ((ETTextView)((TextItemBuilder.Holder)localObject).jdField_d_of_type_AndroidWidgetTextView).setShadowLayer(3.0F, 0.0F, 0.0F, paramBubbleInfo.d);
        ((ETTextView)((TextItemBuilder.Holder)localObject).jdField_d_of_type_AndroidWidgetTextView).setStrokeColor(true, paramBubbleInfo.d);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ChatItemBuilder", 2, "bubble has stroke, color = " + paramBubbleInfo.d);
        return;
        ((TextItemBuilder.Holder)localObject).jdField_d_of_type_AndroidWidgetTextView.setTextColor(paramBubbleInfo.jdField_b_of_type_Int);
        break label256;
      }
    } while ((!paramBubbleInfo.jdField_b_of_type_Boolean) || (((ChatBackgroundManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CHAT_BACKGROUND_MANAGER)).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, ((TextItemBuilder.Holder)localObject).jdField_d_of_type_AndroidWidgetTextView.getCurrentTextColor(), 10000.0D * ((TextItemBuilder.Holder)localObject).jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.jdField_a_of_type_Double) != 1));
    label156:
    paramViewHolder = (ETTextView)((TextItemBuilder.Holder)localObject).jdField_d_of_type_AndroidWidgetTextView;
    label256:
    label394:
    label406:
    float f2 = paramViewHolder.getTextSize() * 3.0F / 16.0F;
    float f1 = f2;
    if (f2 > 25.0F) {
      f1 = 25.0F;
    }
    paramViewHolder.setTextColor(-1);
    ColorStateList.valueOf(-1);
    paramViewHolder.setShadowLayer(f1, 0.0F, 0.0F, paramBubbleInfo.d);
  }
  
  public void a(BaseBubbleBuilder.ViewHolder paramViewHolder, ChatMessage paramChatMessage)
  {
    if (a(paramViewHolder, paramChatMessage)) {}
    do
    {
      return;
      paramViewHolder = (TextItemBuilder.Holder)paramViewHolder;
    } while ((b(paramChatMessage, paramViewHolder)) || (!(paramViewHolder.jdField_d_of_type_AndroidWidgetTextView instanceof ETTextView)));
    a(paramChatMessage, paramViewHolder);
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
      } while ((SimpleUIUtil.a()) || ((1 == paramChatMessage.istroop) && (AnonymousChatHelper.a(paramChatMessage))));
      localFontManager = (FontManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CHAT_FONT_MANAGER);
      localFontManager.b(paramChatMessage);
    } while (!localFontManager.b(paramChatMessage));
    localFontManager.a(paramChatMessage);
    localFontManager.a(paramHolder.jdField_d_of_type_AndroidWidgetTextView);
  }
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramViewHolder, paramInt1, paramInt2);
  }
  
  void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, Context paramContext, TextItemBuilder.Holder paramHolder)
  {
    if (paramHolder.c != null) {
      paramHolder.c.setVisibility(8);
    }
    if (paramHolder.b != null) {
      paramHolder.b.setVisibility(8);
    }
    paramBaseChatItemLayout = (TextView)paramBaseChatItemLayout.findViewById(2131364665);
    int i;
    if ((paramChatMessage.mNeedTimeStamp) && (paramChatMessage.time > 0L) && (paramBaseChatItemLayout != null) && (paramChatMessage.time != ((Long)paramBaseChatItemLayout.getTag()).longValue()))
    {
      if (paramHolder.b != null) {
        paramHolder.b.setPadding(0, AIOUtils.a(70.0F, paramContext.getResources()), 0, 0);
      }
      if (paramHolder.c != null) {
        paramHolder.c.setPadding(0, AIOUtils.a(80.0F, paramContext.getResources()), 0, 0);
      }
      if (((paramChatMessage.extraflag != 32768) || (!paramChatMessage.isSendFromLocal())) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().c(paramChatMessage))) {
        break label306;
      }
      i = 1;
      label177:
      if ((paramChatMessage.isFollowMessage()) && (i == 0) && (!(this.jdField_a_of_type_AndroidContentContext instanceof MultiForwardActivity)) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.n))
      {
        if (!paramChatMessage.isSend()) {
          break label312;
        }
        if (paramHolder.b != null)
        {
          paramHolder.b.setImageResource(2130847477);
          paramHolder.b.setVisibility(0);
        }
      }
    }
    label306:
    label312:
    while (paramHolder.c == null)
    {
      return;
      if (paramHolder.b != null) {
        paramHolder.b.setPadding(0, AIOUtils.a(30.0F, paramContext.getResources()), 0, 0);
      }
      if (paramHolder.c == null) {
        break;
      }
      paramHolder.c.setPadding(0, AIOUtils.a(30.0F, paramContext.getResources()), 0, 0);
      break;
      i = 0;
      break label177;
    }
    paramHolder.c.setImageResource(2130847477);
    paramHolder.c.setVisibility(0);
  }
  
  protected void a(ChatMessage paramChatMessage, String paramString)
  {
    AIOSelectableDelegateImpl localAIOSelectableDelegateImpl = AIOSelectableDelegateImpl.a();
    if (localAIOSelectableDelegateImpl.c())
    {
      String str = localAIOSelectableDelegateImpl.b();
      if (str != null) {
        if (str.length() == localAIOSelectableDelegateImpl.a())
        {
          i = 1;
          j = i;
          localObject = str;
          if ((paramChatMessage instanceof MessageForText))
          {
            j = i;
            localObject = str;
            if (MessageFoldable.a(paramChatMessage))
            {
              localObject = ((MessageForText)paramChatMessage).sb.toString();
              j = 1;
            }
          }
          localAIOSelectableDelegateImpl.d();
        }
      }
    }
    for (int i = j;; i = 1)
    {
      localObject = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, paramChatMessage, (String)localObject);
      if (!android.text.TextUtils.isEmpty((CharSequence)localObject)) {
        break label142;
      }
      return;
      i = 0;
      break;
      i = 0;
      break;
      localObject = paramChatMessage.msg;
    }
    label142:
    Object localObject = new StringBuilder((String)localObject);
    int j = 0;
    while (j < ((StringBuilder)localObject).length())
    {
      if ((((StringBuilder)localObject).codePointAt(j) == 20) && (j < ((StringBuilder)localObject).length() - 1) && (((StringBuilder)localObject).charAt(j + 1) == 'ÿ'))
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X800588D", 0, 0, "", "", "", "");
        if (QLog.isColorLevel()) {
          QLog.d("ChatItemBuilder", 2, "report save small emoticon amount");
        }
        QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 13, 0, paramChatMessage.istroop);
        return;
      }
      j += 1;
    }
    if (i == 0)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", paramString, "0X8009AAC", "0X8009AAC", 4, 0, "", "", "", "");
      return;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", paramString, "0X8009AAB", "0X8009AAC", 4, 0, "", "", "", "");
  }
  
  void a(MessageRecord paramMessageRecord)
  {
    int j = 1;
    if (MessageFoldable.a(paramMessageRecord))
    {
      i = j;
      if (paramMessageRecord.istroop != 0)
      {
        i = j;
        if (paramMessageRecord.istroop != 1) {
          if (!ChatActivityUtils.a(paramMessageRecord.istroop)) {
            break label63;
          }
        }
      }
    }
    label63:
    for (int i = j;; i = 0)
    {
      if ((paramMessageRecord.isMultiMsg) || (this.jdField_b_of_type_Boolean) || (i == 0)) {
        MessageFoldable.a(paramMessageRecord);
      }
      return;
    }
  }
  
  protected void a(QQCustomMenu paramQQCustomMenu, Context paramContext, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage != null) && (paramQQCustomMenu != null) && (paramContext != null) && (WTUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo))) {
      paramQQCustomMenu.a(2131382059, paramContext.getString(2131720726), 0);
    }
  }
  
  public boolean a(BaseBubbleBuilder.ViewHolder paramViewHolder)
  {
    return paramViewHolder instanceof TextItemBuilder.Holder;
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = AIOUtils.a(paramView);
    localQQCustomMenu = new QQCustomMenu();
    if ((paramView != null) && (paramView.istroop == 10007))
    {
      localQQCustomMenu.a(2131365448, this.jdField_a_of_type_AndroidContentContext.getString(2131691369), 2130839050);
      return localQQCustomMenu.a();
    }
    if ((paramView != null) && (paramView.isMultiMsg))
    {
      localQQCustomMenu.a(2131365448, this.jdField_a_of_type_AndroidContentContext.getString(2131691369), 2130839050);
      localQQCustomMenu.a(2131367398, this.jdField_a_of_type_AndroidContentContext.getString(2131692687), 2130839059);
      localQQCustomMenu.a(2131366625, this.jdField_a_of_type_AndroidContentContext.getString(2131692258), 2130839058);
      return localQQCustomMenu.a();
    }
    if (ConfessMsgUtil.a(paramView)) {
      return localQQCustomMenu.a();
    }
    if (ApolloGameUtil.a(paramView)) {
      return localQQCustomMenu.a();
    }
    int i = 0;
    j = 0;
    if ((paramView instanceof MessageForText)) {
      if (android.text.TextUtils.isEmpty(((MessageForText)paramView).getExtInfoFromExtStr("sticker_info"))) {
        break label627;
      }
    }
    label627:
    for (i = 1;; i = 0)
    {
      Object localObject = paramView.getExtInfoFromExtStr("key_message_extra_info_flag");
      j = 0;
      try
      {
        int k = Integer.parseInt((String)localObject);
        j = k;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          QLog.e("ChatItemBuilder", 1, localThrowable, new Object[0]);
          continue;
          j = 0;
          continue;
          ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        }
      }
      if ((j & 0x2) != 2) {
        break;
      }
      j = 1;
      if (j != 0) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009B17", "0X8009B17", 0, 0, "", "", "", "");
      }
      if ((paramView instanceof MessageForPoke)) {
        i = 1;
      }
      if (i != 0) {
        break label654;
      }
      if (j == 0) {
        localQQCustomMenu.a(2131365448, HardCodeUtil.a(2131714733), 2130839050);
      }
      if ((paramView != null) && (paramView.extraflag == 32768) && (paramView.isSendFromLocal())) {
        localQQCustomMenu.a(2131376982, this.jdField_a_of_type_AndroidContentContext.getString(2131718489), 2130839066);
      }
      if (j == 0) {
        localQQCustomMenu.a(2131367398, this.jdField_a_of_type_AndroidContentContext.getString(2131692687), 2130839059);
      }
      a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131376927, paramView, null);
      if ((paramView != null) && (paramView.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().b(paramView))) {
        a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131371954, paramView, new Bundle());
      }
      a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131365636, paramView, new Bundle());
      if ((((IWriteTogetherConfig)QRoute.api(IWriteTogetherConfig.class)).isAllowShowEntrance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (b())) {
        a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, paramView);
      }
      if (AIOUtils.a(5) == 1) {
        localQQCustomMenu.a(2131366625, this.jdField_a_of_type_AndroidContentContext.getString(2131692258), 2130839058);
      }
      localObject = new Bundle();
      ((Bundle)localObject).putBoolean("isSearch", false);
      super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131380949, paramView, (Bundle)localObject);
      if (((paramView instanceof MessageForText)) || ((paramView instanceof MessageForLongTextMsg))) {
        a(localQQCustomMenu, paramView);
      }
      a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131376940, paramView, null);
      super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131371997, null, null);
      super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131362524, null, null);
      return localQQCustomMenu.a();
    }
  }
  
  public void b(BaseBubbleBuilder.ViewHolder paramViewHolder, ChatMessage paramChatMessage)
  {
    int i = 0;
    super.b(paramViewHolder, paramChatMessage);
    if ((paramChatMessage instanceof MessageForLongTextMsg)) {
      break label15;
    }
    label15:
    TextItemBuilder.Holder localHolder;
    label146:
    label152:
    for (;;)
    {
      return;
      if ((paramViewHolder instanceof TextItemBuilder.Holder))
      {
        localHolder = (TextItemBuilder.Holder)paramViewHolder;
        if (!(paramChatMessage instanceof MessageForText)) {
          break;
        }
        paramChatMessage = (MessageForText)paramChatMessage;
        paramViewHolder = null;
        if (!android.text.TextUtils.isEmpty(paramChatMessage.sb)) {
          if (android.text.TextUtils.isEmpty(paramChatMessage.sb2)) {
            break label146;
          }
        }
        for (paramViewHolder = paramChatMessage.sb2;; paramViewHolder = paramChatMessage.sb)
        {
          if ((paramViewHolder == null) || (!(paramViewHolder instanceof QQText))) {
            break label152;
          }
          paramChatMessage = (QQText)paramViewHolder;
          paramViewHolder = (EmoticonSpan[])paramChatMessage.getSpans(0, paramViewHolder.length(), EmoticonSpan.class);
          if ((paramViewHolder.length <= 0) || (paramChatMessage.toPurePlainText().length() != 0)) {
            break;
          }
          int j = paramViewHolder.length;
          while (i < j)
          {
            paramViewHolder[i].setSize(ScreenUtil.dip2px(26.0F));
            i += 1;
          }
        }
      }
    }
    localHolder.jdField_d_of_type_AndroidWidgetTextView.setText(paramChatMessage);
  }
  
  protected boolean b()
  {
    Object localObject = a();
    if (localObject == null) {
      return false;
    }
    localObject = (WriteTogetherHelper)((BaseChatPie)localObject).a(74);
    if ((localObject != null) && (((WriteTogetherHelper)localObject).a())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
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
      if ((this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity))
      {
        ChatFragment localChatFragment = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
        if ((localChatFragment != null) && (localChatFragment.a() != null) && (localChatFragment.a().a != null)) {
          a(paramMessage, localChatFragment.a().a);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TextItemBuilder
 * JD-Core Version:    0.7.0.1
 */