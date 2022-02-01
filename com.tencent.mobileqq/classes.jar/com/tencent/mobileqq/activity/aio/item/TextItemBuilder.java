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
import android.os.Message;
import android.support.annotation.Nullable;
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
import com.etrump.mixlayout.VasShieldFont;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.common.app.BaseApplicationImpl;
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
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.ark.dict.WordSegmentResult;
import com.tencent.mobileqq.ark.dict.api.IArkDictManager;
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
import com.tencent.mobileqq.model.ChatBackgroundManager;
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
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.troop.todo.TroopTodoUtils;
import com.tencent.mobileqq.troop.utils.TroopRobotManager;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.vas.font.api.FontManagerConstants;
import com.tencent.mobileqq.vas.font.api.IFontManagerService;
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
import mqq.app.AppRuntime;

public class TextItemBuilder
  extends BaseBubbleBuilder
  implements Handler.Callback, BaseBubbleBuilder.TouchDelegate
{
  public static final LRULinkedHashMap<Long, SpannableString> B = new LRULinkedHashMap(50);
  private static String w = "ArkApp.TextItemBuilder";
  public static final int y = BaseChatItemLayout.k + BaseChatItemLayout.n;
  protected static final int z = BaseChatItemLayout.l + BaseChatItemLayout.o;
  Handler A = null;
  protected View.OnClickListener C = new TextItemBuilder.1(this);
  protected View.OnClickListener D = new TextItemBuilder.2(this);
  protected AnimationTextView.OnDoubleClick E = new TextItemBuilder.MyOnDoubleClick(this, this.d, (Activity)this.e);
  private AlphabeticFontHelper a;
  private ETTextView.TextAnimationListener x = new TextItemBuilder.9(this);
  
  public TextItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  private static int a(ETTextView paramETTextView, CharSequence paramCharSequence)
  {
    return (int)Math.ceil(paramETTextView.getPaint().measureText(paramCharSequence, 0, paramCharSequence.length()));
  }
  
  @Nullable
  private SpannableString a(CharSequence paramCharSequence, long paramLong, ArrayList<Pair<Integer, Integer>> paramArrayList)
  {
    float f1;
    if (FontSettingManager.getFontLevel() == 18.0F) {
      f1 = 1.3F;
    } else {
      f1 = 1.5F;
    }
    double d = paramArrayList.size() * 0.3F;
    Double.isNaN(d);
    int i = (int)(d + 0.5D);
    d = paramArrayList.size() * 0.3F;
    Double.isNaN(d);
    int j = (int)(d + 0.5D);
    float f2;
    boolean bool;
    int k;
    float f3;
    if (FontManagerConstants.magicFontConfigInited.get())
    {
      f2 = FontManagerConstants.magicFontNormalSize1;
      f1 = FontManagerConstants.magicFontNormalSize2;
      if (FontSettingManager.getFontLevel() == 18.0F)
      {
        f2 = FontManagerConstants.magicFontMaxSize1;
        f1 = FontManagerConstants.magicFontMaxSize2;
      }
      bool = FontManagerConstants.magicFontOneWordEnable;
      d = paramArrayList.size() * FontManagerConstants.magicFontSize1Number;
      Double.isNaN(d);
      i = (int)(d + 0.5D);
      d = paramArrayList.size() * FontManagerConstants.magicFontSize2Number;
      Double.isNaN(d);
      j = (int)(d + 0.5D);
      k = FontManagerConstants.magicFontGroupSize;
      f3 = f1;
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "generateMagicFont config not init");
      }
      bool = true;
      f3 = 0.7F;
      k = 4;
      f2 = f1;
    }
    paramCharSequence = new SpannableString(paramCharSequence);
    if (paramArrayList.size() == 1)
    {
      if (a(paramLong, paramArrayList, f2, f3, bool, paramCharSequence)) {
        return null;
      }
    }
    else {
      a(paramLong, paramArrayList, f2, f3, i, j, k, paramCharSequence);
    }
    return paramCharSequence;
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
    boolean bool = paramChatMessage instanceof MessageForText;
    String str = "";
    if (bool)
    {
      MessageForText localMessageForText = (MessageForText)paramChatMessage;
      if (paramChatMessage.msgtype == -2008)
      {
        if (paramChatMessage.isSend())
        {
          a(paramHolder, paramContext.getString(2131916158));
          return "";
        }
        a(paramHolder, paramContext.getString(2131916157));
        return "";
      }
      a(paramHolder, paramChatMessage);
      if (!android.text.TextUtils.isEmpty(localMessageForText.sb))
      {
        if (!android.text.TextUtils.isEmpty(localMessageForText.sb2)) {
          a(paramHolder, localMessageForText.sb2);
        } else {
          a(paramHolder, localMessageForText.sb);
        }
        TroopUtils.a(this.d, this.f, this.e, paramHolder.v, paramChatMessage);
        if (AppSetting.e)
        {
          paramChatMessage = com.tencent.mobileqq.text.TextUtils.emoticonToTextForTalkBack(paramChatMessage.msg);
          paramContext = Spannable.Factory.getInstance().newSpannable(paramChatMessage);
          if (Linkify.addLinks(paramContext, 15)) {
            paramHolder.v.setContentDescription(paramContext);
          } else {
            paramHolder.v.setContentDescription(paramChatMessage);
          }
        }
        return localMessageForText.sb.toString();
      }
      a(paramHolder, "");
      paramContext = str;
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("textitem text.sb is null");
        paramContext.append(paramChatMessage.msgtype);
        QLog.d("ChatItemBuilder", 2, paramContext.toString());
        return "";
      }
    }
    else if ((paramChatMessage instanceof MessageForHiBoom))
    {
      paramChatMessage = (MessageForHiBoom)paramChatMessage;
      paramContext = str;
      if (paramChatMessage.mHiBoomMessage != null)
      {
        a(paramHolder, paramChatMessage.mHiBoomMessage.text);
        return paramChatMessage.mHiBoomMessage.text;
      }
    }
    else
    {
      if ((paramChatMessage instanceof MessageForPoke))
      {
        paramContext = (MessageForPoke)paramChatMessage;
        paramChatMessage = HardCodeUtil.a(2131912176);
        if (paramContext.name != null)
        {
          paramChatMessage = new StringBuilder();
          paramChatMessage.append("[");
          paramChatMessage.append(paramContext.name);
          paramChatMessage.append("]请用最新版手机QQ查看。");
          paramChatMessage = paramChatMessage.toString();
        }
        a(paramHolder, paramChatMessage);
        return paramChatMessage;
      }
      a(paramHolder, paramChatMessage.msg);
      TroopUtils.a(this.d, this.f, this.e, paramHolder.v, paramChatMessage);
      paramContext = paramChatMessage.msg;
    }
    return paramContext;
  }
  
  public static String a(String paramString, boolean paramBoolean)
  {
    if (android.text.TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    paramString = new StringBuilder(paramString);
    int k = paramString.length();
    int j;
    for (int i = 0; i < k; i = j + 1)
    {
      j = i;
      if ('\024' == paramString.charAt(i))
      {
        int m = i + 1;
        j = i;
        if (m < k)
        {
          j = i;
          if ('ÿ' == paramString.charAt(m))
          {
            m = i + 2;
            j = i;
            if (m < k)
            {
              if (paramBoolean)
              {
                if (paramString.charAt(m) == '\024') {
                  paramString.setCharAt(m, 'ý');
                }
              }
              else if (paramString.charAt(m) == 'ý') {
                paramString.setCharAt(m, '\024');
              }
              j = i + 4;
            }
          }
        }
      }
    }
    return paramString.toString();
  }
  
  private void a(int paramInt)
  {
    if (paramInt == 0) {
      paramInt = 1;
    } else if (paramInt == 1) {
      paramInt = 2;
    } else if (ChatActivityUtils.a(paramInt)) {
      paramInt = 3;
    } else {
      paramInt = 4;
    }
    ReportController.b(this.d, "dc00898", "", "", "0X800B155", "0X800B155", paramInt, 0, "", "", "", "");
  }
  
  private void a(long paramLong, ArrayList<Pair<Integer, Integer>> paramArrayList, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, int paramInt3, SpannableString paramSpannableString)
  {
    int i = paramInt1;
    paramInt1 = paramInt2;
    int j = 0;
    int m = 0;
    int k = 0;
    paramInt2 = i;
    i = m;
    while (j < paramArrayList.size())
    {
      m = 1;
      boolean bool;
      if ((paramInt3 > 0) && (j % paramInt3 == paramInt3 - 1) && (i == 0)) {
        bool = true;
      } else {
        bool = false;
      }
      if ((paramLong % (paramArrayList.size() - j) >= paramInt2 + paramInt1) && (!bool))
      {
        m = paramInt1;
        paramInt1 = i;
      }
      else
      {
        float f;
        if (((paramInt2 <= 0) && (paramInt1 > 0)) || (((paramInt1 > 0) || (paramInt2 <= 0)) && (k % 2 == 1))) {
          f = paramFloat2;
        } else {
          f = paramFloat1;
        }
        i = paramInt2;
        if (f == paramFloat1) {
          i = paramInt2 - 1;
        }
        paramInt2 = paramInt1;
        if (f == paramFloat2) {
          paramInt2 = paramInt1 - 1;
        }
        paramSpannableString.setSpan(new RelativeSizeSpan(f), ((Integer)((Pair)paramArrayList.get(j)).first).intValue(), ((Integer)((Pair)paramArrayList.get(j)).second).intValue(), 33);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("generateMagicFont word change: ");
          localStringBuilder.append(((Pair)paramArrayList.get(j)).first);
          localStringBuilder.append(" , ");
          localStringBuilder.append(((Pair)paramArrayList.get(j)).second);
          localStringBuilder.append(" size = ");
          localStringBuilder.append(f);
          localStringBuilder.append(" index = ");
          localStringBuilder.append(j);
          localStringBuilder.append(" forceChange = ");
          localStringBuilder.append(bool);
          QLog.d("ChatItemBuilder", 2, localStringBuilder.toString());
        }
        k += 1;
        paramInt1 = m;
        m = paramInt2;
        paramInt2 = i;
      }
      if ((paramInt3 > 0) && (j % paramInt3 == paramInt3 - 1)) {
        i = 0;
      } else {
        i = paramInt1;
      }
      paramLong = (paramLong * 25214903917L + 11L & 0xFFFFFFFF) >> 16;
      j += 1;
      paramInt1 = m;
    }
  }
  
  public static void a(Message paramMessage, XListView paramXListView)
  {
    long l = paramMessage.getData().getLong("msg_id");
    paramXListView = AIOUtils.a(paramXListView, AIOUtils.a(l, paramXListView.getAdapter()));
    if ((paramXListView != null) && ((paramXListView.getTag() instanceof TextItemBuilder.Holder)))
    {
      paramXListView = (TextItemBuilder.Holder)paramXListView.getTag();
      if (paramXListView.z == l)
      {
        if ((paramMessage.obj instanceof SpannableString))
        {
          paramMessage = (SpannableString)paramMessage.obj;
          paramXListView.v.setText(paramMessage);
          ((ETTextView)paramXListView.v).mMagicFont = true;
          if ((paramXListView.v instanceof ETTextView))
          {
            ETTextView localETTextView = (ETTextView)paramXListView.v;
            if (localETTextView.mFont != null) {
              localETTextView.mFont.mText = paramMessage;
            }
          }
        }
        if (((ETTextView)paramXListView.v).isUsingHYFont()) {
          ((ETTextView)paramXListView.v).isParsingMagicFont = false;
        }
        paramXListView.v.requestLayout();
      }
    }
  }
  
  private void a(TextItemBuilder.Holder paramHolder, CharSequence paramCharSequence)
  {
    paramHolder.v.setText(paramCharSequence);
    if (!android.text.TextUtils.isEmpty(paramCharSequence))
    {
      int i;
      if ((QQTheme.isNowSimpleUI()) && (paramCharSequence.length() <= 4)) {
        i = 1;
      } else {
        i = 0;
      }
      paramHolder = paramHolder.v;
      if (i != 0) {
        i = 17;
      } else {
        i = 16;
      }
      paramHolder.setGravity(i);
    }
  }
  
  private void a(ChatMessage paramChatMessage, FontInfo paramFontInfo, ETTextView paramETTextView)
  {
    if ((paramChatMessage instanceof MessageForText))
    {
      ??? = (MessageForText)paramChatMessage;
      paramChatMessage = null;
      if (!android.text.TextUtils.isEmpty(((MessageForText)???).sb)) {
        if (!android.text.TextUtils.isEmpty(((MessageForText)???).sb2)) {
          paramChatMessage = ((MessageForText)???).sb2;
        } else {
          paramChatMessage = ((MessageForText)???).sb;
        }
      }
      if ((paramChatMessage != null) && (com.tencent.mobileqq.text.TextUtils.hasChnChar(paramChatMessage)))
      {
        long l1 = ((MessageForText)???).msgUid;
        long l2 = ((MessageForText)???).uniseq;
        synchronized (B)
        {
          if (B.containsKey(Long.valueOf(l2)))
          {
            paramChatMessage = (SpannableString)B.get(Long.valueOf(l2));
            if (paramChatMessage != null)
            {
              paramETTextView.setText(paramChatMessage);
              paramETTextView.mMagicFont = true;
            }
          }
          else
          {
            if ((paramFontInfo != null) && (paramFontInfo.c == 1)) {
              paramETTextView.isParsingMagicFont = true;
            }
            ((IArkDictManager)BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IArkDictManager.class, "all")).getAnalysisThread().post(new TextItemBuilder.8(this, paramChatMessage, l1, l2));
          }
          return;
        }
      }
    }
  }
  
  private void a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, TextItemBuilder.Holder paramHolder)
  {
    if ((paramHolder.v instanceof AnimationTextView)) {
      paramHolder = (AnimationTextView)paramHolder.v;
    }
    try
    {
      ((IApolloUtil)QRoute.api(IApolloUtil.class)).playApolloEmoticonAction(this.d, this.f, paramChatMessage, paramHolder.getText(), paramViewHolder.l, paramViewHolder.m, false);
      label54:
      paramHolder.onDoubleClick = this.E;
      paramHolder.onSingleClick = new TextItemBuilder.4(this, paramChatMessage.isSend());
      return;
    }
    catch (Exception paramViewHolder)
    {
      break label54;
    }
  }
  
  private void a(ChatMessage paramChatMessage, IFontManagerService paramIFontManagerService, FontInfo paramFontInfo, ETTextView paramETTextView, String paramString)
  {
    if ((paramFontInfo != null) && (paramFontInfo.a != 0))
    {
      StringBuilder localStringBuilder;
      if (this.d.getCurrentUin().equals(paramString))
      {
        if (FontManagerConstants.mMineLastReportTime == 0L) {
          FontManagerConstants.mMineLastReportTime = this.d.getPreferences().getLong("personal_font_last_send_report", 1L);
        }
        if ((FontManagerConstants.mMineLastReportTime < FontManagerConstants.todayStartTime) && (paramChatMessage.time * 1000L > FontManagerConstants.todayStartTime))
        {
          paramIFontManagerService = this.d;
          paramString = new StringBuilder();
          paramString.append("");
          paramString.append(paramFontInfo.c - 1);
          paramString = paramString.toString();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("");
          localStringBuilder.append(paramFontInfo.a);
          ReportController.b(paramIFontManagerService, "CliOper", "", "", "Font_Mall", "0X8007B2B", 0, 0, paramString, localStringBuilder.toString(), "", "");
          FontManagerConstants.mMineLastReportTime = paramChatMessage.time * 1000L;
          paramIFontManagerService = this.d.getPreferences().edit();
          paramIFontManagerService.putLong("personal_font_last_send_report", paramChatMessage.time * 1000L);
          paramIFontManagerService.commit();
        }
      }
      else
      {
        if (FontManagerConstants.mOthersLastReportTime == 0L) {
          FontManagerConstants.mOthersLastReportTime = this.d.getPreferences().getLong("personal_font_last_receive_report", 1L);
        }
        if ((FontManagerConstants.mOthersLastReportTime < FontManagerConstants.todayStartTime) && (paramChatMessage.time * 1000L > FontManagerConstants.todayStartTime))
        {
          paramIFontManagerService = this.d;
          paramString = new StringBuilder();
          paramString.append("");
          paramString.append(paramFontInfo.c - 1);
          paramString = paramString.toString();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("");
          localStringBuilder.append(paramFontInfo.a);
          ReportController.b(paramIFontManagerService, "CliOper", "", "", "Font_Mall", "0X8007B2C", 0, 0, paramString, localStringBuilder.toString(), "", "");
          FontManagerConstants.mOthersLastReportTime = paramChatMessage.time * 1000L;
          paramIFontManagerService = this.d.getPreferences().edit();
          paramIFontManagerService.putLong("personal_font_last_receive_report", paramChatMessage.time * 1000L);
          paramIFontManagerService.commit();
        }
      }
      if (paramFontInfo.f != null)
      {
        paramIFontManagerService = paramFontInfo.f;
        paramIFontManagerService.setSize(paramETTextView.getTextSize());
      }
      else
      {
        paramIFontManagerService = new ETFont(paramFontInfo.a, paramFontInfo.b, paramETTextView.getTextSize(), paramFontInfo.c, paramFontInfo.d);
      }
      if (android.text.TextUtils.isEmpty(paramChatMessage.getExtInfoFromExtStr("font_animation_played"))) {
        paramETTextView.shouldStartAnimation = true;
      } else {
        paramETTextView.shouldStartAnimation = false;
      }
      paramETTextView.setFont(paramIFontManagerService, paramChatMessage, this.f);
      if (QLog.isColorLevel())
      {
        paramChatMessage = new StringBuilder();
        paramChatMessage.append("updateTextFont  fontId = ");
        paramChatMessage.append(paramFontInfo.a);
        paramChatMessage.append("fontType = ");
        paramChatMessage.append(paramFontInfo.c);
        paramChatMessage.append("typeface = ");
        paramChatMessage.append(paramFontInfo.d);
        QLog.d("FontManagerConstants", 2, paramChatMessage.toString());
      }
    }
    else
    {
      if (VasShieldFont.b == 4)
      {
        if (paramIFontManagerService.isFontLoaded(9999)) {
          paramETTextView.setDefaultFont(VasShieldFont.a(paramChatMessage), paramChatMessage.uniseq);
        } else {
          VasShieldFont.b(this.d);
        }
      }
      else {
        paramETTextView.setDefaultFont(VasShieldFont.a(paramChatMessage), paramChatMessage.uniseq);
      }
      if (QLog.isColorLevel())
      {
        paramIFontManagerService = new StringBuilder();
        paramIFontManagerService.append("updateTextFont fontinfo = ");
        if (paramFontInfo == null) {
          paramChatMessage = "null";
        } else {
          paramChatMessage = paramFontInfo.toString();
        }
        paramIFontManagerService.append(paramChatMessage);
        QLog.d("FontManagerConstants", 2, paramIFontManagerService.toString());
      }
    }
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
    int i = TroopTodoUtils.a(this.f, paramChatMessage, this.d);
    if (i == 2)
    {
      a(paramQQCustomMenu, this.e, 2131430283, paramChatMessage, null);
      return;
    }
    if (i == 1) {
      a(paramQQCustomMenu, this.e, 2131430651, paramChatMessage, null);
    }
  }
  
  private boolean a(long paramLong, ArrayList<Pair<Integer, Integer>> paramArrayList, float paramFloat1, float paramFloat2, boolean paramBoolean, SpannableString paramSpannableString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "generateMagicFont oneWord");
    }
    if ((paramBoolean) && (((Integer)((Pair)paramArrayList.get(0)).second).intValue() - ((Integer)((Pair)paramArrayList.get(0)).first).intValue() > 1))
    {
      if (((Integer)((Pair)paramArrayList.get(0)).second).intValue() - ((Integer)((Pair)paramArrayList.get(0)).first).intValue() == 2) {
        i = 1;
      } else {
        i = 2;
      }
      int m = 0;
      int j = 0;
      int k = i;
      int i = m;
      while (i < ((Integer)((Pair)paramArrayList.get(0)).second).intValue() - ((Integer)((Pair)paramArrayList.get(0)).first).intValue())
      {
        if (paramLong % (((Integer)((Pair)paramArrayList.get(0)).second).intValue() - ((Integer)((Pair)paramArrayList.get(0)).first).intValue() - i) < k)
        {
          float f;
          if (j % 2 == 1) {
            f = paramFloat2;
          } else {
            f = paramFloat1;
          }
          paramSpannableString.setSpan(new RelativeSizeSpan(f), ((Integer)((Pair)paramArrayList.get(0)).first).intValue() + i, ((Integer)((Pair)paramArrayList.get(0)).first).intValue() + i + 1, 33);
          m = k - 1;
          int n = j + 1;
          k = m;
          j = n;
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("generateMagicFont oneWord change index = ");
            localStringBuilder.append(((Pair)paramArrayList.get(0)).first);
            localStringBuilder.append(i);
            localStringBuilder.append(" changeSize = ");
            localStringBuilder.append(f);
            QLog.d("ChatItemBuilder", 2, localStringBuilder.toString());
            k = m;
            j = n;
          }
        }
        paramLong = (paramLong * 25214903917L + 11L & 0xFFFFFFFF) >> 16;
        i += 1;
      }
      return false;
    }
    if (QLog.isColorLevel())
    {
      paramSpannableString = new StringBuilder();
      paramSpannableString.append("generateMagicFont oneWord switch = ");
      paramSpannableString.append(paramBoolean);
      paramSpannableString.append(" length = ");
      paramSpannableString.append(((Integer)((Pair)paramArrayList.get(0)).second).intValue() - ((Integer)((Pair)paramArrayList.get(0)).first).intValue());
      QLog.d("ChatItemBuilder", 2, paramSpannableString.toString());
    }
    return true;
  }
  
  private boolean a(ChatMessage paramChatMessage, TextItemBuilder.Holder paramHolder)
  {
    int i;
    int j;
    if (((this.f.a == 3000) || (this.f.a == 1)) && (paramChatMessage.isShowQIMStyleGroup))
    {
      i = Color.parseColor("#FFFFFFFF");
      j = Color.parseColor("#ff5078f0");
      paramHolder.v.setTextColor(i);
      paramHolder.v.setLinkTextColor(j);
      return true;
    }
    if ((this.f.a == 0) && (QIMUserManager.b().a(this.f)))
    {
      if ((paramChatMessage.isSend() ^ true))
      {
        j = Color.parseColor("#ff000000");
        i = Color.parseColor("#ff80e9ff");
      }
      else
      {
        j = Color.parseColor("#FFFFFFFF");
        i = Color.parseColor("#ff5078f0");
      }
      paramHolder.v.setTextColor(j);
      paramHolder.v.setLinkTextColor(i);
      return true;
    }
    return false;
  }
  
  private void b(View paramView, ChatMessage paramChatMessage)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("C2CMessageFold textItemBuilder flag: ");
      ((StringBuilder)localObject).append(paramChatMessage.getExtInfoFromExtStr("key_message_extra_info_flag"));
      QLog.d("ChatItemBuilder", 2, ((StringBuilder)localObject).toString());
    }
    c(paramChatMessage);
    if (((paramView instanceof ETTextView)) && ((paramChatMessage instanceof MessageForText)) && (MessageFoldable.a(paramChatMessage)))
    {
      ETTextView localETTextView = (ETTextView)paramView;
      MessageForText localMessageForText = (MessageForText)paramChatMessage;
      if (!android.text.TextUtils.isEmpty(localMessageForText.sb))
      {
        if (!android.text.TextUtils.isEmpty(localMessageForText.sb2)) {
          paramView = localMessageForText.sb2;
        } else {
          paramView = localMessageForText.sb;
        }
      }
      else {
        paramView = "";
      }
      int i = a(localETTextView, paramView);
      int j = BaseChatItemLayout.e - BaseChatItemLayout.getTextBubblePaddingAlignHead() - BaseChatItemLayout.getTextBubblePaddingAlignError();
      if (i > j)
      {
        String str = this.e.getString(2131892396);
        localObject = android.text.TextUtils.ellipsize(paramView, localETTextView.getPaint(), j - a(localETTextView, str), TextUtils.TruncateAt.END);
        if (!localETTextView.isUsingFZColorFont2())
        {
          paramChatMessage = (ChatMessage)localObject;
          if (!localETTextView.isUsingHYFont()) {}
        }
        else
        {
          paramChatMessage = a((CharSequence)localObject, 3);
        }
        a(localMessageForText, localETTextView, paramView, paramChatMessage, str);
      }
    }
  }
  
  private void b(ChatMessage paramChatMessage)
  {
    if ((this.e instanceof BaseActivity))
    {
      Object localObject = ((BaseActivity)this.e).getChatFragment().k();
      if (localObject != null)
      {
        localObject = (WriteTogetherHelper)((BaseChatPie)localObject).q(74);
        if ((localObject != null) && ((paramChatMessage instanceof MessageForText))) {
          ((WriteTogetherHelper)localObject).b(((MessageForText)paramChatMessage).sb.toString(), 3);
        }
      }
    }
  }
  
  private void b(ChatMessage paramChatMessage, TextItemBuilder.Holder paramHolder)
  {
    if (this.a == null) {
      this.a = new AlphabeticFontHelper();
    }
    if (this.a.a(this.d, (ETTextView)paramHolder.v, this.f.r)) {
      return;
    }
    IFontManagerService localIFontManagerService = (IFontManagerService)this.d.getRuntimeService(IFontManagerService.class, "");
    FontInfo localFontInfo = localIFontManagerService.getUserFont(paramChatMessage);
    ETTextView localETTextView = (ETTextView)paramHolder.v;
    localETTextView.setMinWidth(AIOUtils.b(BubbleInfo.c(), this.e.getResources()));
    if ((!(paramChatMessage instanceof MessageForReplyText)) || (!(paramHolder instanceof ReplyTextItemBuilder.ReplyTextViewHolder))) {
      localETTextView.setMinHeight(AIOUtils.b(57.0F, this.e.getResources()));
    }
    paramHolder = FontManagerConstants.getSenderUin(paramChatMessage);
    if ((localFontInfo != null) && (localFontInfo.c == 1)) {
      localETTextView.isParsingMagicFont = false;
    }
    if (FontManagerConstants.parseMagicFont(paramChatMessage)) {
      a(paramChatMessage, localFontInfo, localETTextView);
    }
    if (localIFontManagerService != null) {
      localIFontManagerService.parseHYDIYFont(paramChatMessage, localFontInfo, paramHolder);
    }
    a(paramChatMessage, localIFontManagerService, localFontInfo, localETTextView, paramHolder);
  }
  
  private void b(ChatMessage paramChatMessage, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", -1);
    if ((paramChatMessage instanceof MessageForText))
    {
      ECommerceDataReportUtil.a(this.d, paramChatMessage, 3);
      MessageForText localMessageForText = (MessageForText)paramChatMessage;
      if (AIOSelectableDelegateImpl.a().l())
      {
        localObject = AIOSelectableDelegateImpl.a().d();
        if ((localObject != null) && (((String)localObject).length() == AIOSelectableDelegateImpl.a().c())) {
          i = 1;
        } else {
          i = 0;
        }
        if (!MessageFoldable.a(paramChatMessage)) {
          break label137;
        }
        localObject = localMessageForText.sb.toString();
      }
      else if (localMessageForText.sb != null)
      {
        localObject = localMessageForText.sb.toString();
      }
      else
      {
        localObject = localMessageForText.msg;
      }
      int i = 1;
      label137:
      localBundle.putString("forward_text", (String)localObject);
      localBundle.putInt("selection_mode", this.u);
      localBundle.putInt("forward_source_uin_type", this.f.a);
      boolean bool = localMessageForText instanceof MessageForWriteTogether;
      localBundle.putBooleanArray("forward_is_write_together", new boolean[] { bool });
      int j;
      if (bool) {
        j = ((MessageForWriteTogether)localMessageForText).baseRev;
      } else {
        j = 0;
      }
      String str = "";
      if (bool) {
        localObject = ((MessageForWriteTogether)localMessageForText).padId;
      } else {
        localObject = "";
      }
      if (bool) {
        str = ((MessageForWriteTogether)localMessageForText).token;
      }
      int k;
      if (bool) {
        k = 1;
      } else {
        k = 0;
      }
      localBundle.putString("forward_source_uin", localMessageForText.frienduin);
      localBundle.putIntArray("forward_write_together_base_rev", new int[] { j });
      localBundle.putStringArray("forward_write_together_pad_id", new String[] { localObject });
      localBundle.putStringArray("forward_write_together_token", new String[] { str });
      localBundle.putInt("forward_write_together_number", k);
      Object localObject = new Intent();
      ((Intent)localObject).putExtras(localBundle);
      ((Intent)localObject).putExtra("direct_send_if_dataline_forward", true);
      ForwardBaseOption.a((Activity)this.e, (Intent)localObject, 21);
      ReportController.b(this.d, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "1", "", "", "");
      if (i != 0) {
        ReportController.b(this.d, "dc00898", "", paramString, "0X8009AAB", "0X8009AAB", 2, 0, "", "", "", "");
      } else {
        ReportController.b(this.d, "dc00898", "", paramString, "0X8009AAC", "0X8009AAC", 3, 0, "", "", "", "");
      }
      if (paramChatMessage.isMultiMsg) {
        ReportController.b(this.d, "dc00898", "", "", "0X8009D66", "0X8009D66", 1, 0, "1", "", "", "");
      }
    }
  }
  
  private void b(QQCustomMenu paramQQCustomMenu, ChatMessage paramChatMessage)
  {
    int i = TroopEssenceUtil.a(this.f, paramChatMessage, this.d);
    if (i == 2)
    {
      a(paramQQCustomMenu, this.e, 2131432608, paramChatMessage, null);
      return;
    }
    if (i == 1) {
      a(paramQQCustomMenu, this.e, 2131432607, paramChatMessage, null);
    }
  }
  
  private void c(ChatMessage paramChatMessage, String paramString)
  {
    paramChatMessage = a(paramChatMessage, paramString, AIOSelectableDelegateImpl.a());
    if (paramChatMessage != null) {
      try
      {
        ((ClipboardManager)this.e.getSystemService("clipboard")).setText(paramChatMessage);
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("Copy message, msg=");
          paramString.append(paramChatMessage);
          QLog.d("ChatItemBuilder", 2, paramString.toString());
          return;
        }
      }
      catch (Exception paramChatMessage)
      {
        QLog.e("ChatItemBuilder", 2, paramChatMessage.toString());
      }
    }
  }
  
  private boolean c(BaseBubbleBuilder.ViewHolder paramViewHolder, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForLongTextMsg)) {
      return true;
    }
    if (AIOUtils.h) {
      return true;
    }
    return !(paramViewHolder instanceof TextItemBuilder.Holder);
  }
  
  private boolean c(ChatMessage paramChatMessage, TextItemBuilder.Holder paramHolder)
  {
    if (((paramChatMessage.istroop != 3000) && (paramChatMessage.istroop != 1)) || ((!paramChatMessage.isShowQIMStyleGroup) && ((!this.f.i) || (!this.f.p)))) {
      return false;
    }
    ETFont localETFont = new ETFont(0, null, 0.0F);
    if ((paramHolder.v instanceof ETTextView)) {
      ((ETTextView)paramHolder.v).setFont(localETFont, paramChatMessage.uniseq);
    }
    return true;
  }
  
  private boolean d(ChatMessage paramChatMessage, TextItemBuilder.Holder paramHolder)
  {
    if (!SimpleUIUtil.e()) {
      return false;
    }
    Object localObject = new ETFont(0, null, 0.0F);
    if ((paramHolder.v instanceof ETTextView)) {
      ((ETTextView)paramHolder.v).setFont((ETFont)localObject, paramChatMessage.uniseq);
    }
    localObject = (ETTextView)paramHolder.v;
    ((ETTextView)localObject).setMinWidth(AIOUtils.b(BubbleInfo.c(), this.e.getResources()));
    if ((!(paramChatMessage instanceof MessageForReplyText)) || (!(paramHolder instanceof ReplyTextItemBuilder.ReplyTextViewHolder))) {
      ((ETTextView)localObject).setMinHeight(AIOUtils.b(57.0F, this.e.getResources()));
    }
    return true;
  }
  
  private void e(View paramView)
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
    localLayoutParams.addRule(7, 2131430578);
    localLayoutParams.addRule(3, 2131430578);
    localLayoutParams.rightMargin = (this.e.getResources().getDimensionPixelSize(2131296615) + DisplayUtil.a(this.e, 10.0F));
    paramView.setVisibility(0);
  }
  
  private BaseChatPie i()
  {
    if (!(this.e instanceof BaseActivity)) {
      return null;
    }
    ChatFragment localChatFragment = ((BaseActivity)this.e).getChatFragment();
    if (localChatFragment == null)
    {
      QLog.e("ChatItemBuilder", 1, "[getChatPie] ChatFragment is null");
      return null;
    }
    return localChatFragment.k();
  }
  
  SpannableString a(CharSequence paramCharSequence, long paramLong)
  {
    String str = com.tencent.mobileqq.text.TextUtils.replaceEmojiWithSpace(paramCharSequence.toString());
    if (android.text.TextUtils.isEmpty(str))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "generateMagicFont msg is empty");
      }
      return null;
    }
    long l1 = System.currentTimeMillis();
    Object localObject1 = ((IArkDictManager)BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IArkDictManager.class, "all")).wordSegment(str);
    String[] arrayOfString = ((WordSegmentResult)localObject1).c;
    long l2 = System.currentTimeMillis();
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("generateMagicFont word segment cost ");
      ((StringBuilder)localObject2).append(l2 - l1);
      ((StringBuilder)localObject2).append("ms; msg length = ");
      ((StringBuilder)localObject2).append(paramCharSequence.length());
      QLog.d("ChatItemBuilder", 2, ((StringBuilder)localObject2).toString());
    }
    if (!((WordSegmentResult)localObject1).a)
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
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("generateMagicFont words count = ");
      ((StringBuilder)localObject1).append(arrayOfString.length);
      QLog.d("ChatItemBuilder", 2, ((StringBuilder)localObject1).toString());
    }
    localObject1 = new ArrayList();
    int j = 0;
    int i = 0;
    while (j < arrayOfString.length)
    {
      while ((i < str.length()) && (str.charAt(i) == ' ')) {
        i += 1;
      }
      localObject2 = arrayOfString[j];
      int k = 0;
      while ((k < ((String)localObject2).length()) && (((String)localObject2).charAt(k) >= '一') && (((String)localObject2).charAt(k) <= 40891)) {
        k += 1;
      }
      if (k == ((String)localObject2).length()) {
        ((ArrayList)localObject1).add(new Pair(Integer.valueOf(i), Integer.valueOf(((String)localObject2).length() + i)));
      }
      i += ((String)localObject2).length();
      j += 1;
    }
    if (((ArrayList)localObject1).size() < 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "generateMagicFont words count = 0");
      }
      return null;
    }
    return a(paramCharSequence, paramLong, (ArrayList)localObject1);
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    Context localContext = paramBaseChatItemLayout.getContext();
    TextItemBuilder.Holder localHolder;
    if ((paramViewHolder instanceof TextItemBuilder.Holder))
    {
      localHolder = (TextItemBuilder.Holder)paramViewHolder;
    }
    else
    {
      localHolder = (TextItemBuilder.Holder)a();
      localHolder.j = paramBaseChatItemLayout;
      paramBaseChatItemLayout.setTag(localHolder);
      paramView = null;
    }
    if (paramView == null)
    {
      localObject1 = new ImageView(localContext);
      ((ImageView)localObject1).setId(2131433475);
      paramView = new RelativeLayout.LayoutParams(-2, -2);
      paramView.addRule(0, 2131430578);
      paramView.addRule(15, 2131429332);
      ((ImageView)localObject1).setContentDescription(HardCodeUtil.a(2131912175));
      paramBaseChatItemLayout.addView((View)localObject1, paramView);
      ((ImageView)localObject1).setOnClickListener(this.D);
      paramView = new ETTextView(localContext);
      com.tencent.mobileqq.text.TextUtils.fixTextViewANRForAnd10(paramView);
      paramView.setTextColor(localContext.getResources().getColorStateList(2131168016));
      paramView.setLinkTextColor(localContext.getResources().getColorStateList(2131168008));
      if (AppSetting.e) {
        paramView.setAutoLinkMask(3);
      } else {
        paramView.setAutoLinkMask(0);
      }
      paramView.setSpannableFactory(QQText.SPANNABLE_FACTORY);
      paramView.setMaxWidth(BaseChatItemLayout.e);
      paramView.setMovementMethod(LinkMovementMethod.getInstance());
      paramView.setTextAnimationListener(this.x);
      paramView.setId(2131430581);
      localObject2 = new ImageView(localContext);
      ((ImageView)localObject2).setId(2131433476);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(1, 2131430578);
      localLayoutParams.addRule(15, 2131429332);
      ((ImageView)localObject2).setContentDescription(HardCodeUtil.a(2131912177));
      localLayoutParams.leftMargin = 10;
      paramBaseChatItemLayout.addView((View)localObject2, localLayoutParams);
      ((ImageView)localObject2).setOnClickListener(this.D);
      localHolder.v = paramView;
      localHolder.x = ((ImageView)localObject1);
      localHolder.y = ((ImageView)localObject2);
      localHolder.w = new AIOSelectableDelegateProxy();
      localHolder.w.a(paramView);
      localHolder.w.a(paramBaseChatItemLayout, paramBaseChatItemLayout);
    }
    ((ETTextView)localHolder.v).setFont(0, paramChatMessage.uniseq);
    localHolder.v.setTypeface(null);
    ((ETTextView)localHolder.v).setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    ((ETTextView)localHolder.v).setStrokeColor(false, 0);
    ((ETTextView)localHolder.v).mMagicFont = false;
    ((ETTextView)localHolder.v).setCacheMeasureResult(true);
    localHolder.v.setTypeface(VasShieldFont.a(paramChatMessage));
    if (!android.text.TextUtils.isEmpty(paramChatMessage.getExtInfoFromExtStr("sens_msg_ctrl_info")))
    {
      localObject1 = ((ETTextView)localHolder.v).getETLayout();
      if (localObject1 != null) {
        ((ETLayout)localObject1).b = (paramChatMessage.uniseq + 1L);
      }
    }
    localHolder.v.setTextSize(0, this.f.r);
    localHolder.v.setGravity(16);
    int i = BaseChatItemLayout.getTextPaddingAlignHead();
    int j = BaseChatItemLayout.getTextPaddingAlignError();
    if (paramChatMessage.isSend())
    {
      i = BaseChatItemLayout.getTextPaddingAlignError();
      j = BaseChatItemLayout.getTextPaddingAlignHead();
    }
    localHolder.v.setPadding(i, BaseChatItemLayout.n, j, BaseChatItemLayout.o);
    localHolder.z = paramChatMessage.uniseq;
    Object localObject1 = a(paramChatMessage, localContext, localHolder);
    if (((ITroopRobotService)this.d.getRuntimeService(ITroopRobotService.class, "all")).hasRobotNewsClassId(paramChatMessage)) {
      TroopRobotManager.a(localHolder.v, paramChatMessage);
    }
    Object localObject2 = AioVipKeywordHelper.a();
    if (((this.f.a == 0) || (this.f.a == 1) || (this.f.a == 3000)) && (!paramChatMessage.isread))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AioVipKeywordHelper", 4, "detectKeyword in TextItemBuilder.getBubbleView()");
      }
      ((AioVipKeywordHelper)localObject2).a(this.d, this.f, paramChatMessage, (String)localObject1, localContext, paramChatMessage.isSend());
    }
    localHolder.v.setOnTouchListener(paramOnLongClickAndTouchListener);
    localHolder.v.setOnLongClickListener(paramOnLongClickAndTouchListener);
    localHolder.B = paramOnLongClickAndTouchListener;
    localHolder.v.setOnClickListener(this.C);
    a(paramChatMessage, paramViewHolder, localHolder);
    a(paramChatMessage, paramBaseChatItemLayout, localContext, localHolder);
    if (localHolder.j != null) {
      if (((TroopRobotManager)this.d.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER)).a(this.d, paramChatMessage)) {
        localHolder.j.setRobotNextTipsView(true, this.e, this.d, paramChatMessage);
      } else {
        localHolder.j.setRobotNextTipsView(false, this.e, this.d, paramChatMessage);
      }
    }
    if (localHolder.w != null) {
      localHolder.w.b(paramChatMessage);
    }
    if ((this.d != null) && (!(this instanceof WriteTogetherItemBuilder)))
    {
      localHolder.A = super.a(localHolder.A, localHolder, paramBaseChatItemLayout, paramChatMessage, -2, DisplayUtil.a(this.e, 21.0F));
      if ((this.f != null) && (this.f.b != null)) {
        paramViewHolder = this.f.b;
      } else {
        paramViewHolder = "";
      }
      boolean bool = TroopEssenceUtil.a(this.d, paramChatMessage, paramViewHolder);
      if ((localHolder.h != null) && (bool) && (localHolder.A != null)) {
        localHolder.h.post(new TextItemBuilder.3(this, localHolder, paramChatMessage, paramChatMessage));
      }
    }
    return paramView;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new TextItemBuilder.Holder();
  }
  
  public CharSequence a(CharSequence paramCharSequence, int paramInt)
  {
    if (paramInt <= paramCharSequence.length() - 1)
    {
      if (paramInt <= 0) {
        return paramCharSequence;
      }
      if ((paramCharSequence instanceof Spanned)) {
        localObject = (Spanned)paramCharSequence;
      } else {
        localObject = null;
      }
      int i = paramCharSequence.length();
      if (localObject == null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramCharSequence, 0, i - paramInt - 1);
        ((StringBuilder)localObject).append(paramCharSequence, i - 1, i);
        return ((StringBuilder)localObject).toString();
      }
      Object localObject = new SpannableStringBuilder();
      ((SpannableStringBuilder)localObject).append(paramCharSequence, 0, i - paramInt - 1);
      ((SpannableStringBuilder)localObject).append(paramCharSequence, i - 1, i);
      return localObject;
    }
    return paramCharSequence;
  }
  
  String a(ChatMessage paramChatMessage, String paramString, AIOSelectableDelegateImpl paramAIOSelectableDelegateImpl)
  {
    if (paramChatMessage.msg != null)
    {
      ECommerceDataReportUtil.a(this.d, paramChatMessage, 2);
      boolean bool = paramChatMessage.isMultiMsg;
      int j = 1;
      int i;
      Object localObject;
      if (bool)
      {
        ReportController.b(this.d, "dc00898", "", "", "0X8009AB7", "0X8009AB7", 0, 0, "", "", "", "");
        if ((paramChatMessage instanceof MessageForLongTextMsg)) {
          i = 2;
        } else {
          i = 1;
        }
        localObject = this.d;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(i);
        ReportController.b((AppRuntime)localObject, "dc00898", "", "", "0X8009D65", "0X8009D65", i, 0, localStringBuilder.toString(), "", "", "");
      }
      ReportController.b(this.d, "CliOper", "", "", "0X800644A", "0X800644A", 0, 0, "1", "", "", "");
      if (paramAIOSelectableDelegateImpl.l())
      {
        localObject = paramAIOSelectableDelegateImpl.d();
        int k = 0;
        i = k;
        if (localObject != null)
        {
          i = k;
          if (((String)localObject).length() == paramAIOSelectableDelegateImpl.c()) {
            i = 1;
          }
        }
        if (((paramChatMessage instanceof MessageForText)) && (MessageFoldable.a(paramChatMessage)))
        {
          paramChatMessage = ((MessageForText)paramChatMessage).sb.toString();
          i = j;
        }
        else
        {
          paramChatMessage = (ChatMessage)localObject;
        }
      }
      else
      {
        paramChatMessage = paramChatMessage.msg;
        i = j;
      }
      if (i != 0)
      {
        ReportController.b(this.d, "dc00898", "", paramString, "0X8009AAB", "0X8009AAB", 1, 0, "", "", "", "");
        return paramChatMessage;
      }
      ReportController.b(this.d, "dc00898", "", paramString, "0X8009AAC", "0X8009AAC", 1, 0, "", "", "", "");
      return paramChatMessage;
    }
    return null;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    QQAppInterface localQQAppInterface = this.d;
    String str2 = "";
    String str1 = str2;
    if (localQQAppInterface != null)
    {
      str1 = this.d.getCurrentAccountUin();
      if (android.text.TextUtils.isEmpty(str1)) {
        str1 = str2;
      }
    }
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    case 2131450309: 
      b(paramChatMessage);
      return;
    case 2131445511: 
      AIOSelectableDelegateImpl.a().a(paramChatMessage);
      ReportController.b(this.d, "dc00898", "", str1, "0X8009AAC", "0X8009AAC", 2, 0, "", "", "", "");
      return;
    case 2131444710: 
      if (this.d != null)
      {
        ChatActivityFacade.a(this.d, this.e, this.f, paramChatMessage.msg, paramChatMessage.uniseq);
        return;
      }
      break;
    case 2131444634: 
      ReportController.b(this.d, "dc00898", "", str1, "0X8009AAB", "0X8009AAB", 3, 0, "", "", "", "");
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    case 2131439015: 
      super.a(paramInt, paramContext, paramChatMessage);
      ReportController.b(this.d, "dc00898", "", str1, "0X8009AAB", "0X8009AAB", 7, 0, "", "", "", "");
      return;
    case 2131438943: 
      super.a(paramInt, paramContext, paramChatMessage);
      ReportController.b(this.d, "dc00898", "", str1, "0X8009AAB", "0X8009AAB", 5, 0, "", "", "", "");
      return;
    case 2131433636: 
      b(paramChatMessage, str1);
      return;
    case 2131432813: 
      if (this.d != null)
      {
        a(paramChatMessage, str1);
        ECommerceDataReportUtil.a(this.d, paramChatMessage, 4);
        QfavReport.a(this.d, 1, 0, paramChatMessage.istroop);
        if (paramChatMessage.isMultiMsg)
        {
          ReportController.b(this.d, "dc00898", "", "", "0X8009D67", "0X8009D67", 1, 0, "1", "", "", "");
          return;
        }
      }
      break;
    case 2131431695: 
      ChatActivityFacade.b(this.e, this.d, paramChatMessage);
      ReportController.b(this.d, "CliOper", "", "", "0X8006447", "0X8006447", 0, 0, "1", "", "", "");
      ReportController.b(this.d, "dc00898", "", str1, "0X8009AAB", "0X8009AAB", 6, 0, "", "", "", "");
      return;
    case 2131431492: 
      c(paramChatMessage, str1);
    }
  }
  
  public void a(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if ((i != 1) && (i != 3)) {
      return;
    }
    a(paramView.getBackground(), null);
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend()) {
      paramView.setPadding(BaseChatItemLayout.getTextBubblePaddingAlignError(), y, BaseChatItemLayout.getTextBubblePaddingAlignHead(), z);
    } else {
      paramView.setPadding(BaseChatItemLayout.getTextBubblePaddingAlignHead(), y, BaseChatItemLayout.getTextBubblePaddingAlignError(), z);
    }
    b(paramView, paramChatMessage);
  }
  
  public void a(View paramView, ChatMessage paramChatMessage, int paramInt)
  {
    super.a(paramView, paramChatMessage, paramInt);
    if (paramInt == 1)
    {
      BaseBubbleBuilder.ViewHolder localViewHolder = (BaseBubbleBuilder.ViewHolder)paramView.getTag();
      if (localViewHolder != null) {
        a(localViewHolder, paramView, paramChatMessage, localViewHolder.i);
      }
    }
    paramView = (BaseBubbleBuilder.ViewHolder)paramView.getTag();
    if (paramView != null) {
      b(paramView.h, paramChatMessage);
    }
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    Drawable localDrawable = paramView.getBackground();
    if (paramBoolean) {
      paramView = null;
    } else {
      paramView = n;
    }
    a(localDrawable, paramView);
  }
  
  protected void a(BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, ChatMessage paramChatMessage, BubbleInfo paramBubbleInfo)
  {
    if ((paramChatMessage instanceof MessageForLongTextMsg))
    {
      localObject = (MessageForLongTextMsg)paramChatMessage;
      if ((((MessageForLongTextMsg)localObject).getExtInfoFromExtStr("long_text_recv_state").equals("2")) || (((MessageForLongTextMsg)localObject).getExtInfoFromExtStr("long_text_recv_state").equals("3"))) {
        return;
      }
    }
    if (!(paramViewHolder instanceof TextItemBuilder.Holder)) {
      return;
    }
    Object localObject = (TextItemBuilder.Holder)paramViewHolder;
    if (a(paramChatMessage, (TextItemBuilder.Holder)localObject)) {
      return;
    }
    boolean bool = SimpleUIUtil.e();
    int i = paramBubbleInfo.a;
    int j = -1;
    if ((i != 0) && (paramBubbleInfo.b()) && (!bool))
    {
      ColorStateList.valueOf(paramBubbleInfo.l);
      if (paramBubbleInfo.l == 0)
      {
        ((TextItemBuilder.Holder)localObject).v.setTextColor(-16777216);
        ColorStateList.valueOf(-16777216);
      }
      else
      {
        ((TextItemBuilder.Holder)localObject).v.setTextColor(paramBubbleInfo.l);
      }
      if (paramBubbleInfo.m == 0) {
        paramViewHolder = paramView.getResources().getColorStateList(2131168018);
      } else {
        paramViewHolder = ColorStateList.valueOf(paramBubbleInfo.m);
      }
      ((TextItemBuilder.Holder)localObject).v.setLinkTextColor(paramViewHolder);
      if ((((TextItemBuilder.Holder)localObject).v instanceof ETTextView)) {
        if (paramBubbleInfo.o)
        {
          ((ETTextView)((TextItemBuilder.Holder)localObject).v).setShadowLayer(3.0F, 0.0F, 0.0F, paramBubbleInfo.n);
          ((ETTextView)((TextItemBuilder.Holder)localObject).v).setStrokeColor(true, paramBubbleInfo.n);
          if (QLog.isColorLevel())
          {
            paramViewHolder = new StringBuilder();
            paramViewHolder.append("bubble has stroke, color = ");
            paramViewHolder.append(paramBubbleInfo.n);
            QLog.d("ChatItemBuilder", 2, paramViewHolder.toString());
          }
        }
        else if ((paramBubbleInfo.p) && (((ChatBackgroundManager)this.d.getManager(QQManagerFactory.CHAT_BACKGROUND_MANAGER)).a(this.e, this.f, ((TextItemBuilder.Holder)localObject).v.getCurrentTextColor(), 10000.0D * ((TextItemBuilder.Holder)localObject).i.q) == 1))
        {
          paramViewHolder = (ETTextView)((TextItemBuilder.Holder)localObject).v;
          float f2 = paramViewHolder.getTextSize() * 3.0F / 16.0F;
          float f1 = f2;
          if (f2 > 25.0F) {
            f1 = 25.0F;
          }
          paramViewHolder.setTextColor(-1);
          ColorStateList.valueOf(-1);
          paramViewHolder.setShadowLayer(f1, 0.0F, 0.0F, paramBubbleInfo.n);
        }
      }
      return;
    }
    paramViewHolder = paramView.getResources();
    if (paramChatMessage.isSend()) {
      i = 2131168020;
    } else {
      i = 2131168016;
    }
    paramView = paramViewHolder.getColorStateList(i);
    ((TextItemBuilder.Holder)localObject).v.setTextColor(paramView);
    if (ConfessMsgUtil.a(this.f))
    {
      if (paramChatMessage.isSend()) {
        i = j;
      } else {
        i = -16777216;
      }
      ((TextItemBuilder.Holder)localObject).v.setTextColor(i);
    }
    if (paramChatMessage.isSend()) {
      paramViewHolder = paramViewHolder.getColorStateList(2131168019);
    } else {
      paramViewHolder = paramViewHolder.getColorStateList(2131168018);
    }
    ((TextItemBuilder.Holder)localObject).v.setLinkTextColor(paramViewHolder);
  }
  
  protected void a(BaseBubbleBuilder.ViewHolder paramViewHolder, ChatMessage paramChatMessage)
  {
    if (c(paramViewHolder, paramChatMessage)) {
      return;
    }
    paramViewHolder = (TextItemBuilder.Holder)paramViewHolder;
    if (c(paramChatMessage, paramViewHolder)) {
      return;
    }
    if (d(paramChatMessage, paramViewHolder)) {
      return;
    }
    if ((paramViewHolder.v instanceof ETTextView)) {
      b(paramChatMessage, paramViewHolder);
    }
  }
  
  void a(TextItemBuilder.Holder paramHolder, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForLongTextMsg)) {
      return;
    }
    if (SimpleUIUtil.e()) {
      return;
    }
    if ((1 == paramChatMessage.istroop) && (AnonymousChatHelper.c(paramChatMessage))) {
      return;
    }
    IFontManagerService localIFontManagerService = (IFontManagerService)this.d.getRuntimeService(IFontManagerService.class, "");
    localIFontManagerService.reportFontEffect(paramChatMessage);
    if (localIFontManagerService.enableEnlargeFontEffect(paramChatMessage))
    {
      localIFontManagerService.enlargeEmojiAndSmall(paramChatMessage);
      localIFontManagerService.enlargeTextMsg(paramHolder.v);
    }
  }
  
  protected void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramViewHolder, paramInt1, paramInt2);
  }
  
  void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, Context paramContext, TextItemBuilder.Holder paramHolder)
  {
    if (paramHolder.y != null) {
      paramHolder.y.setVisibility(8);
    }
    if (paramHolder.x != null) {
      paramHolder.x.setVisibility(8);
    }
    paramBaseChatItemLayout = (TextView)paramBaseChatItemLayout.findViewById(2131430611);
    if ((paramChatMessage.mNeedTimeStamp) && (paramChatMessage.time > 0L) && (paramBaseChatItemLayout != null) && (paramChatMessage.time != ((Long)paramBaseChatItemLayout.getTag()).longValue()))
    {
      if (paramHolder.x != null) {
        paramHolder.x.setPadding(0, AIOUtils.b(70.0F, paramContext.getResources()), 0, 0);
      }
      if (paramHolder.y != null) {
        paramHolder.y.setPadding(0, AIOUtils.b(80.0F, paramContext.getResources()), 0, 0);
      }
    }
    else
    {
      if (paramHolder.x != null) {
        paramHolder.x.setPadding(0, AIOUtils.b(30.0F, paramContext.getResources()), 0, 0);
      }
      if (paramHolder.y != null) {
        paramHolder.y.setPadding(0, AIOUtils.b(30.0F, paramContext.getResources()), 0, 0);
      }
    }
    int i;
    if (((paramChatMessage.extraflag == 32768) && (paramChatMessage.isSendFromLocal())) || (this.d.getMsgCache().g(paramChatMessage))) {
      i = 1;
    } else {
      i = 0;
    }
    if ((paramChatMessage.isFollowMessage()) && (i == 0) && (!(this.e instanceof MultiForwardActivity)) && (!this.f.G)) {
      if (paramChatMessage.isSend())
      {
        if (paramHolder.x != null)
        {
          paramHolder.x.setImageResource(2130848998);
          paramHolder.x.setVisibility(0);
        }
      }
      else if (paramHolder.y != null)
      {
        paramHolder.y.setImageResource(2130848998);
        paramHolder.y.setVisibility(0);
      }
    }
  }
  
  protected void a(ChatMessage paramChatMessage, String paramString)
  {
    AIOSelectableDelegateImpl localAIOSelectableDelegateImpl = AIOSelectableDelegateImpl.a();
    int j;
    if (localAIOSelectableDelegateImpl.l())
    {
      String str = localAIOSelectableDelegateImpl.d();
      if ((str != null) && (str.length() == localAIOSelectableDelegateImpl.c())) {
        i = 1;
      } else {
        i = 0;
      }
      localObject = str;
      j = i;
      if ((paramChatMessage instanceof MessageForText))
      {
        localObject = str;
        j = i;
        if (MessageFoldable.a(paramChatMessage))
        {
          localObject = ((MessageForText)paramChatMessage).sb.toString();
          j = 1;
        }
      }
      localAIOSelectableDelegateImpl.n();
    }
    else
    {
      localObject = paramChatMessage.msg;
      j = 1;
    }
    Object localObject = a(this.d, (Activity)this.e, paramChatMessage, (String)localObject);
    if (android.text.TextUtils.isEmpty((CharSequence)localObject)) {
      return;
    }
    localObject = new StringBuilder((String)localObject);
    int i = 0;
    while (i < ((StringBuilder)localObject).length())
    {
      if ((((StringBuilder)localObject).codePointAt(i) == 20) && (i < ((StringBuilder)localObject).length() - 1) && (((StringBuilder)localObject).charAt(i + 1) == 'ÿ'))
      {
        ReportController.b(this.d, "CliOper", "", "", "ep_mall", "0X800588D", 0, 0, "", "", "", "");
        if (QLog.isColorLevel()) {
          QLog.d("ChatItemBuilder", 2, "report save small emoticon amount");
        }
        QfavReport.a(this.d, 13, 0, paramChatMessage.istroop);
        return;
      }
      i += 1;
    }
    if (j == 0)
    {
      ReportController.b(this.d, "dc00898", "", paramString, "0X8009AAC", "0X8009AAC", 4, 0, "", "", "", "");
      return;
    }
    ReportController.b(this.d, "dc00898", "", paramString, "0X8009AAB", "0X8009AAC", 4, 0, "", "", "", "");
  }
  
  protected void a(QQCustomMenu paramQQCustomMenu, Context paramContext, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage != null) && (paramQQCustomMenu != null) && (paramContext != null) && (WTUtils.a(this.f))) {
      paramQQCustomMenu.a(2131450309, paramContext.getString(2131918127), 0);
    }
  }
  
  public boolean a(BaseBubbleBuilder.ViewHolder paramViewHolder)
  {
    return paramViewHolder instanceof TextItemBuilder.Holder;
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = AIOUtils.a(paramView);
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    if ((paramView != null) && (paramView.istroop == 10007))
    {
      localQQCustomMenu.a(2131431492, this.e.getString(2131888241), 2130839057);
      return localQQCustomMenu.d();
    }
    if ((paramView != null) && (paramView.isMultiMsg))
    {
      localQQCustomMenu.a(2131431492, this.e.getString(2131888241), 2130839057);
      localQQCustomMenu.a(2131433636, this.e.getString(2131889668), 2130839066);
      localQQCustomMenu.a(2131432813, this.e.getString(2131889171), 2130839065);
      return localQQCustomMenu.d();
    }
    if (ConfessMsgUtil.b(paramView)) {
      return localQQCustomMenu.d();
    }
    boolean bool3 = paramView instanceof MessageForText;
    boolean bool1;
    int j;
    if (bool3)
    {
      boolean bool2 = android.text.TextUtils.isEmpty(((MessageForText)paramView).getExtInfoFromExtStr("sticker_info")) ^ true;
      String str = paramView.getExtInfoFromExtStr("key_message_extra_info_flag");
      int i;
      try
      {
        i = Integer.parseInt(str);
      }
      catch (Throwable localThrowable)
      {
        QLog.e("ChatItemBuilder", 1, localThrowable, new Object[0]);
        i = 0;
      }
      if ((i & 0x2) == 2) {
        i = 1;
      } else {
        i = 0;
      }
      bool1 = bool2;
      j = i;
      if (i != 0)
      {
        ReportController.b(this.d, "dc00898", "", "", "0X8009B17", "0X8009B17", 0, 0, "", "", "", "");
        bool1 = bool2;
        j = i;
      }
    }
    else
    {
      bool1 = false;
      j = 0;
    }
    if ((paramView instanceof MessageForPoke)) {
      bool1 = true;
    }
    if (!bool1)
    {
      if (j == 0) {
        localQQCustomMenu.a(2131431492, HardCodeUtil.a(2131912173), 2130839057);
      }
      if ((paramView != null) && (paramView.extraflag == 32768) && (paramView.isSendFromLocal())) {
        localQQCustomMenu.a(2131444710, this.e.getString(2131915632), 2130839073);
      }
      if (j == 0) {
        localQQCustomMenu.a(2131433636, this.e.getString(2131889668), 2130839066);
      }
      a(localQQCustomMenu, this.e, 2131444634, paramView, null);
      if ((paramView != null) && (paramView.extraflag != 32768) && (!this.d.getMsgCache().f(paramView))) {
        a(localQQCustomMenu, this.e, 2131438943, paramView, new Bundle());
      }
      a(localQQCustomMenu, this.e, 2131431695, paramView, new Bundle());
      a(localQQCustomMenu, paramView);
      if ((((IWriteTogetherConfig)QRoute.api(IWriteTogetherConfig.class)).isAllowShowEntrance(this.d, this.f.b)) && (h())) {
        a(localQQCustomMenu, this.e, paramView);
      }
      if (AIOUtils.a(5) == 1) {
        localQQCustomMenu.a(2131432813, this.e.getString(2131889171), 2130839065);
      }
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("isSearch", false);
      super.a(localQQCustomMenu, this.e, 2131449133, paramView, localBundle);
      if ((bool3) || ((paramView instanceof MessageForLongTextMsg))) {
        b(localQQCustomMenu, paramView);
      }
      a(localQQCustomMenu, this.e, 2131444651, paramView, null);
      super.a(localQQCustomMenu, this.e, 2131439015, null, null);
      super.a(localQQCustomMenu, this.e, 2131428089, null, null);
    }
    else
    {
      ChatActivityFacade.a(localQQCustomMenu, this.e, this.f.a);
    }
    return localQQCustomMenu.d();
  }
  
  public void b()
  {
    super.b();
    ETEngine.getInstance().onAIODestroy();
    AlphabeticFontHelper localAlphabeticFontHelper = this.a;
    if (localAlphabeticFontHelper != null) {
      localAlphabeticFontHelper.a();
    }
  }
  
  protected void b(View paramView)
  {
    super.b(paramView);
    if (AIOUtils.a(paramView).isMultiMsg) {
      return;
    }
    paramView = (MessageForText)AIOUtils.a(paramView);
    String str1 = this.e.getString(2131886574);
    String str2 = this.e.getString(2131886575);
    if (paramView.isSendFromLocal()) {
      DialogUtil.a(this.e, 230, str1, str2, new TextItemBuilder.6(this, paramView), new TextItemBuilder.7(this)).show();
    }
  }
  
  protected void b(BaseBubbleBuilder.ViewHolder paramViewHolder, ChatMessage paramChatMessage)
  {
    super.b(paramViewHolder, paramChatMessage);
    if ((paramChatMessage instanceof MessageForLongTextMsg)) {
      return;
    }
    if (!(paramViewHolder instanceof TextItemBuilder.Holder)) {
      return;
    }
    TextItemBuilder.Holder localHolder = (TextItemBuilder.Holder)paramViewHolder;
    if ((paramChatMessage instanceof MessageForText))
    {
      paramChatMessage = (MessageForText)paramChatMessage;
      paramViewHolder = null;
      if (!android.text.TextUtils.isEmpty(paramChatMessage.sb)) {
        if (!android.text.TextUtils.isEmpty(paramChatMessage.sb2)) {
          paramViewHolder = paramChatMessage.sb2;
        } else {
          paramViewHolder = paramChatMessage.sb;
        }
      }
      if ((paramViewHolder != null) && ((paramViewHolder instanceof QQText)))
      {
        paramChatMessage = (QQText)paramViewHolder;
        int j = paramViewHolder.length();
        int i = 0;
        paramViewHolder = (EmoticonSpan[])paramChatMessage.getSpans(0, j, EmoticonSpan.class);
        if ((paramViewHolder.length > 0) && (paramChatMessage.toPurePlainText().length() == 0))
        {
          j = paramViewHolder.length;
          while (i < j)
          {
            paramViewHolder[i].setSize(ScreenUtil.dip2px(26.0F));
            i += 1;
          }
          a(localHolder, paramChatMessage);
        }
      }
    }
  }
  
  public int c(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  void c(MessageRecord paramMessageRecord)
  {
    if (MessageFoldable.a(paramMessageRecord))
    {
      int k = paramMessageRecord.istroop;
      int j = 1;
      int i = j;
      if (k != 0)
      {
        i = j;
        if (paramMessageRecord.istroop != 1) {
          if (ChatActivityUtils.a(paramMessageRecord.istroop)) {
            i = j;
          } else {
            i = 0;
          }
        }
      }
      if ((paramMessageRecord.isMultiMsg) || (this.o) || (i == 0)) {
        MessageFoldable.b(paramMessageRecord);
      }
    }
  }
  
  public BaseBubbleBuilder.TouchDelegate d(View paramView)
  {
    if (BubbleUtils.a(paramView)) {
      return this;
    }
    return null;
  }
  
  protected String d(ChatMessage paramChatMessage)
  {
    if ((!(paramChatMessage instanceof MessageForText)) && (!(paramChatMessage instanceof MessageForReplyText)))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131912172));
      localStringBuilder.append(paramChatMessage.msg);
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131912174));
    localStringBuilder.append(com.tencent.mobileqq.text.TextUtils.emoticonToTextForTalkBack(paramChatMessage.msg));
    return localStringBuilder.toString();
  }
  
  protected boolean h()
  {
    Object localObject = i();
    boolean bool2 = false;
    if (localObject == null) {
      return false;
    }
    localObject = (WriteTogetherHelper)((BaseChatPie)localObject).q(74);
    boolean bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (((WriteTogetherHelper)localObject).d()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 1) && ((this.e instanceof BaseActivity)))
    {
      ChatFragment localChatFragment = ((BaseActivity)this.e).getChatFragment();
      if ((localChatFragment != null) && (localChatFragment.k() != null) && (localChatFragment.k().U != null)) {
        a(paramMessage, localChatFragment.k().U);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TextItemBuilder
 * JD-Core Version:    0.7.0.1
 */