import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.MessageForGrayTips.HightlightItem;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerInfo;
import com.tencent.mobileqq.emoticonview.StickerGrayTipLayout;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipItemBuilder.1;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.widget.AutoBgImageView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.lp.LpReportInfo_dc03950;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class auwx
  extends afuu
{
  private SparseBooleanArray jdField_a_of_type_AndroidUtilSparseBooleanArray = new SparseBooleanArray(5);
  private HashMap<Long, Boolean> jdField_a_of_type_JavaUtilHashMap = new HashMap(10);
  private ConcurrentHashMap<Long, Boolean> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(5);
  
  public auwx(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  public static void a(ChatMessage paramChatMessage, afuv paramafuv, View paramView)
  {
    if ((paramafuv != null) && (paramView != null) && (paramChatMessage == null)) {}
  }
  
  private void b(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "onDelBtnClick fail cause message is null");
      }
    }
    Object localObject;
    do
    {
      do
      {
        return;
      } while (!(this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity));
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "revoke msg click handle del msg");
      }
      localObject = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
    } while ((localObject == null) || (((ChatFragment)localObject).a() == null));
    for (;;)
    {
      try
      {
        if (!(paramChatMessage instanceof MessageForUniteGrayTip)) {
          continue;
        }
        localObject = (MessageForUniteGrayTip)paramChatMessage;
        if (((MessageForUniteGrayTip)localObject).istroop != 0) {
          continue;
        }
        if (!((MessageForUniteGrayTip)localObject).senderuin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
          continue;
        }
        i = 1;
      }
      catch (RuntimeException localRuntimeException)
      {
        boolean bool1;
        boolean bool2;
        String str1;
        String str2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("ChatItemBuilder", 1, "0X800A613", localRuntimeException);
        continue;
        int i = -1;
        continue;
        continue;
        i = 8;
        continue;
        i = 8;
        continue;
        i = 8;
        continue;
        i = 10;
        continue;
      }
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A613", "0X800A613", 0, 0, i + "", "", "", "");
      adrm.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
      i = 2;
      continue;
      if (((MessageForUniteGrayTip)localObject).istroop == 1)
      {
        bool1 = bfup.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.frienduin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
        bool2 = bfup.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.frienduin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
        str1 = ((MessageForUniteGrayTip)localObject).tipParam.c;
        str2 = anni.a(2131714572) + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131696982);
        if (bool1)
        {
          if (str1.startsWith(str2))
          {
            i = 3;
            continue;
          }
          if (!((MessageForUniteGrayTip)localObject).senderuin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
            continue;
          }
          i = 4;
          continue;
        }
        if (bool2)
        {
          if (str1.startsWith(str2))
          {
            i = 5;
            continue;
          }
          if (!((MessageForUniteGrayTip)localObject).senderuin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
            continue;
          }
          i = 6;
          continue;
        }
        if (!((MessageForUniteGrayTip)localObject).senderuin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
          continue;
        }
        i = 7;
        continue;
      }
      if (((MessageForUniteGrayTip)localObject).istroop == 3000)
      {
        if (!((MessageForUniteGrayTip)localObject).senderuin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
          continue;
        }
        i = 9;
      }
      else
      {
        bool1 = ((MessageForUniteGrayTip)localObject).tipParam.c.equals(anni.a(2131714571) + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131693851));
        if (!bool1) {
          i = 11;
        } else {
          i = 12;
        }
      }
    }
  }
  
  protected afuv a()
  {
    return new auxb(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, afuv paramafuv, View paramView, LinearLayout paramLinearLayout, afzq paramafzq)
  {
    if (!(paramafuv instanceof auxb)) {
      QLog.e("ChatItemBuilder", 1, "diffclashh =" + paramafuv.getClass());
    }
    auxb localauxb = (auxb)paramafuv;
    if (paramView == null)
    {
      paramafuv = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558889, null);
      localauxb.b = ((TextView)paramafuv.findViewById(2131367600));
      localauxb.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView = ((AutoBgImageView)paramafuv.findViewById(2131376479));
      paramView = localauxb.b.getLayoutParams();
      localObject1 = paramafuv;
      if ((paramView instanceof ViewGroup.MarginLayoutParams))
      {
        paramView = (ViewGroup.MarginLayoutParams)paramView;
        localObject1 = paramafuv;
        if (paramView.rightMargin != BaseChatItemLayout.y) {
          paramView.rightMargin = BaseChatItemLayout.y;
        }
      }
    }
    for (Object localObject1 = paramafuv;; localObject1 = paramView)
    {
      localauxb.b.setLineSpacing(0.0F, 1.0F);
      localauxb.b.setIncludeFontPadding(true);
      localauxb.b.setMovementMethod(null);
      localauxb.b.setTextColor(((View)localObject1).getResources().getColorStateList(2131167251));
      localauxb.b.setGravity(19);
      localauxb.b.setBackgroundResource(0);
      Object localObject2;
      int i1;
      awmr localawmr;
      List localList;
      int i;
      int j;
      int k;
      if ((localObject1 instanceof StickerGrayTipLayout))
      {
        bgso.a(null, "AIO_Handle_Sticker_Cost");
        localObject2 = (StickerGrayTipLayout)localObject1;
        ((StickerGrayTipLayout)localObject2).a();
        paramafuv = EmojiStickerManager.a().a(paramMessageRecord);
        i1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels;
        if ((paramafuv != null) && (paramafuv.size() > 0))
        {
          localawmr = (awmr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14);
          localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramafuv);
          i = 0;
          j = 0;
          k = localList.size() - 1;
          if (k >= 0)
          {
            paramView = (MessageRecord)localList.get(k);
            if (paramView.extraflag != 32768) {}
          }
        }
      }
      for (;;)
      {
        k -= 1;
        break;
        EmojiStickerManager.StickerInfo localStickerInfo = EmojiStickerManager.a(paramView);
        if ((localStickerInfo != null) && (EmojiStickerManager.c(paramView)))
        {
          int m = i + 1;
          if (m > EmojiStickerManager.jdField_f_of_type_Int)
          {
            paramView.msgtype = -2006;
            i = m;
          }
          else
          {
            if ((paramView instanceof MessageForMarketFace)) {
              paramafuv = localawmr.a(((MessageForMarketFace)paramView).mMarkFaceMessage);
            }
            for (;;)
            {
              label424:
              int i2 = (int)(localStickerInfo.x * i1);
              i = (int)(localStickerInfo.y * i1);
              int i3 = (int)(localStickerInfo.width * i1);
              int i4 = (int)(localStickerInfo.height * i1);
              int i5 = localStickerInfo.rotate;
              if (k == localList.size() - 1)
              {
                if (i >= 0) {
                  break label2972;
                }
                i = -i;
                j = 0;
              }
              for (;;)
              {
                label506:
                float f = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
                if ((paramafuv instanceof asbq))
                {
                  paramView = (asbq)paramafuv;
                  if (paramView.a == null) {
                    break label2945;
                  }
                  if ((!EmojiStickerManager.jdField_f_of_type_Boolean) && (bgmg.a() > 1.048576E+008F))
                  {
                    n = 1;
                    label559:
                    if (n == 0) {
                      break label701;
                    }
                    paramafuv = paramView.a("fromAIO", true, false, null, i3, i3);
                    label579:
                    paramView = paramView.a.epId;
                  }
                }
                for (;;)
                {
                  if (paramafuv != null) {
                    ((StickerGrayTipLayout)localObject2).a(paramafuv, i2, j, i3, i4, i5, paramView);
                  }
                  j = i;
                  i = m;
                  break;
                  if (!(paramView instanceof MessageForText)) {
                    break label2987;
                  }
                  paramafuv = (MessageForText)paramView;
                  if (TextUtils.isEmpty(paramafuv.msg)) {
                    break label2987;
                  }
                  paramafuv = EmojiStickerManager.a().a(paramafuv.msg);
                  break label424;
                  n = j + i;
                  if (n >= 0) {
                    break label2953;
                  }
                  n = -i;
                  i = -i;
                  ((StickerGrayTipLayout)localObject2).a(n - j);
                  j = 0;
                  break label506;
                  n = 0;
                  break label559;
                  label701:
                  paramafuv = paramView.a(this.jdField_a_of_type_AndroidContentContext, f);
                  break label579;
                  if ((paramafuv instanceof ascv))
                  {
                    paramafuv = ((ascv)paramafuv).b(this.jdField_a_of_type_AndroidContentContext, f);
                    paramView = "";
                  }
                  else if ((paramafuv instanceof asch))
                  {
                    paramafuv = ((asch)paramafuv).b(this.jdField_a_of_type_AndroidContentContext, f);
                    paramView = "";
                  }
                  else
                  {
                    if ((paramView instanceof MessageForPic))
                    {
                      paramafuv = ahdu.a(this.jdField_a_of_type_AndroidContentContext, (MessageForPic)paramView);
                      ThreadManager.post(new UniteGrayTipItemBuilder.1(this, paramView), 5, null, true);
                      paramView = "";
                      continue;
                      ((StickerGrayTipLayout)localObject1).a = new auwy(this);
                      bgso.a("AIO_Handle_Sticker_Cost", null);
                      if (!(paramMessageRecord instanceof MessageForUniteGrayTip))
                      {
                        localauxb.b.setText(paramMessageRecord.msg);
                        return localObject1;
                      }
                      paramView = (MessageForUniteGrayTip)paramMessageRecord;
                      if (!afur.h) {
                        auxd.a(paramView, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                      }
                      if ((paramView.tipParam != null) && (paramView.tipParam.b == 655381))
                      {
                        paramafuv = (MessageForGrayTips.HightlightItem)paramView.tipParam.a.get(paramView.tipParam.a.size() - 1);
                        if ((paramafuv != null) && (paramafuv.actionType == 38)) {
                          j = 0;
                        }
                      }
                      try
                      {
                        i = Integer.parseInt(paramafuv.mMsgActionData);
                        if (this.jdField_a_of_type_AndroidUtilSparseBooleanArray.get(i, true))
                        {
                          bcst.b(null, "dc00898", "", "", "0X8009979", "0X8009979", i, i, "", "", "", "");
                          this.jdField_a_of_type_AndroidUtilSparseBooleanArray.put(i, false);
                        }
                        if ((paramView.tipParam != null) && (paramView.tipParam.b == 655383))
                        {
                          j = 0;
                          if (paramView.tipParam.a != null) {
                            break label2551;
                          }
                          if (paramMessageRecord.istroop != 0) {
                            break label2543;
                          }
                          i = awhj.b;
                          label1041:
                          if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramView.uniseq)))
                          {
                            if (QLog.isColorLevel()) {
                              QLog.d("ChatItemBuilder", 2, "Temp Report mark: grayTipsOnShow " + paramView.uniseq);
                            }
                            bcst.b(null, "dc00898", "", "", "0X8009ACF", "0X8009ACF", i, i, "", "", "", "");
                            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramView.uniseq), Boolean.valueOf(false));
                          }
                        }
                        if ((paramView.tipParam != null) && (paramView.tipParam.b == 655397))
                        {
                          auxd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView);
                          paramafuv = paramView.getExtInfoFromExtStr("unite_gray_tips_align");
                          if ((!TextUtils.isEmpty(paramafuv)) && (paramafuv.equals("center"))) {
                            localauxb.b.setGravity(17);
                          }
                          localauxb.b.setLineSpacing(8.0F, 1.0F);
                          if ((!"null".equals(((ChatBackgroundManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(63)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) || ((!ThemeUtil.isDefaultTheme()) && (!ThemeUtil.isNowThemeIsNight(null, false, null)) && (!ThemeUtil.isNowThemeIsSimple(null, false, null))))
                          {
                            localauxb.b.setTextColor(((View)localObject1).getResources().getColorStateList(2131167171));
                            localauxb.b.setBackgroundResource(2130850728);
                          }
                          paramafuv = paramView.getExtInfoFromExtStr("uint64_busi_id");
                          if (("1008".equals(paramafuv)) && (!paramView.docTipHasReport))
                          {
                            paramView.docTipHasReport = true;
                            bcst.b(null, "dc00898", "", "", "0X800A638", "0X800A638", paramView.istroop, 0, "", "", "", "");
                          }
                          if ((Long.valueOf(paramafuv).equals(Long.valueOf(1021L))) && (!paramView.dkTipHasReport))
                          {
                            paramView.dkTipHasReport = true;
                            bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AD82", "0X800AD82", 0, 0, "", "", "", "");
                          }
                          if ((Long.valueOf(paramafuv).equals(Long.valueOf(1038L))) && (!paramView.troopMemberLevelTipHasReport))
                          {
                            paramView.troopMemberLevelTipHasReport = true;
                            paramafuv = paramView.getExtInfoFromExtStr("uint64_templ_id");
                            if (!TextUtils.isEmpty(paramafuv))
                            {
                              if (!Long.valueOf(paramafuv).equals(Long.valueOf(1111L))) {
                                break label2658;
                              }
                              bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B1A2", "0X800B1A2", 0, 0, "", "", "", "");
                            }
                          }
                          label1504:
                          l1 = Long.parseLong(paramMessageRecord.getExtInfoFromExtStr("uint64_busi_type"));
                          l2 = Long.parseLong(paramMessageRecord.getExtInfoFromExtStr("uint64_busi_id"));
                          if ((l1 == 2L) && (l2 == 1024L) && (paramView.tipParam.a != null))
                          {
                            paramafuv = (MessageForGrayTips.HightlightItem)paramView.tipParam.a.get(0);
                            if (paramafuv != null) {
                              paramafuv.actionType = 55;
                            }
                          }
                        }
                        if ((((MessageForUniteGrayTip)paramMessageRecord).editState == 1) && ((paramView.tipParam == null) || ((paramView.tipParam != null) && (paramView.tipParam.a == null))) && (QLog.isColorLevel()))
                        {
                          localObject2 = paramView.tipParam;
                          if (paramView.tipParam != null)
                          {
                            paramafuv = paramView.tipParam.a;
                            label1643:
                            QLog.d("ChatItemBuilder", 2, new Object[] { "revoke msg grayTipItemBuilder edit param error grayMsg.tipParam = ", localObject2, " hightLightItems=", paramafuv });
                          }
                        }
                        else if ((paramView.tipParam != null) && (paramView.tipParam.b == 2))
                        {
                          localauxb.b.setGravity(17);
                        }
                      }
                      catch (NumberFormatException localNumberFormatException1)
                      {
                        try
                        {
                          long l1;
                          long l2;
                          if ((paramView.tipParam != null) && (paramView.tipParam.b == 1))
                          {
                            paramafuv = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130849570);
                            localauxb.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setImageDrawable(paramafuv);
                            localauxb.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131691317));
                            localauxb.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setVisibility(0);
                            localauxb.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setOnClickListener(new auwz(this, localauxb));
                            localauxb.b.setMaxWidth(bgtn.a() - bgtn.b(31.0F));
                            ((ViewGroup.MarginLayoutParams)localauxb.b.getLayoutParams()).rightMargin = 0;
                          }
                          for (;;)
                          {
                            for (;;)
                            {
                              if ((paramView.tipParam == null) || (paramView.tipParam.a == null)) {
                                break label2835;
                              }
                              l1 = paramView.uniseq;
                              l2 = localauxb.jdField_a_of_type_Int;
                              if (QLog.isColorLevel()) {
                                QLog.d("ChatItemBuilder", 2, new Object[] { "revoke msg grayTipItemBuilder msg uinseq=", Long.valueOf(l1), ",holder.mPosition=", Long.valueOf(l2) });
                              }
                              paramafuv = paramView.tipParam.a;
                              boolean bool1 = false;
                              if ((paramView.tipParam.b == 2097155) || (paramView.tipParam.b == 2097153) || (paramView.tipParam.b == 2097154) || (paramView.tipParam.b == 655397))
                              {
                                boolean bool2 = true;
                                bool1 = bool2;
                                if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramView.uniseq)))
                                {
                                  localObject2 = paramMessageRecord.getExtInfoFromExtStr("friendIconType");
                                  if ((!TextUtils.isEmpty((CharSequence)localObject2)) && ((((String)localObject2).equals("3")) || (((String)localObject2).equals("6"))))
                                  {
                                    if (!((String)localObject2).equals("3")) {
                                      break label2802;
                                    }
                                    LpReportInfo_dc03950.report(new LpReportInfo_dc03950("16", "8", "1"));
                                    awdq.a("6", "1", "1", LpReportInfo_dc03950.getReportUserType(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
                                  }
                                  this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramView.uniseq), Boolean.valueOf(false));
                                  bool1 = bool2;
                                }
                              }
                              paramLinearLayout = paramView.getHightlightMsgText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLinearLayout.getContext(), bool1, localauxb.b);
                              localauxb.b.setText(paramLinearLayout);
                              localauxb.b.setClickable(true);
                              localauxb.b.setFocusable(true);
                              localauxb.b.setMovementMethod(bhuz.a());
                              if (AppSetting.c) {
                                localauxb.b.setAccessibilityDelegate(new auxa(this, l1, l2, paramafuv, paramLinearLayout));
                              }
                              localauxb.b.setOnTouchListener(paramafzq);
                              localauxb.b.setOnLongClickListener(paramafzq);
                              if (!TextUtils.isEmpty(paramView.contentDescription)) {
                                localauxb.b.setContentDescription(paramView.contentDescription);
                              }
                              paramLinearLayout = localauxb.b.getLayoutParams();
                              if ((paramView == null) || (paramView.tipParam == null) || (paramView.tipParam.b != 3276801)) {
                                break label2877;
                              }
                              paramafzq = this.jdField_a_of_type_AndroidContentContext.getResources();
                              if (Build.VERSION.SDK_INT < 21) {
                                break label2865;
                              }
                              paramafuv = paramafzq.getDrawable(2130850537, this.jdField_a_of_type_AndroidContentContext.getTheme());
                              if (paramafuv != null) {
                                paramafuv.setBounds(0, 0, paramafuv.getIntrinsicWidth(), paramafuv.getIntrinsicHeight());
                              }
                              localauxb.b.setCompoundDrawables(paramafuv, null, null, null);
                              localauxb.b.setCompoundDrawablePadding(afur.a(8.0F, paramafzq));
                              if ((paramLinearLayout instanceof LinearLayout.LayoutParams)) {
                                ((LinearLayout.LayoutParams)paramLinearLayout).gravity = 16;
                              }
                              if ((localObject1 instanceof StickerGrayTipLayout)) {
                                ((StickerGrayTipLayout)localObject1).setGravity(16);
                              }
                              if (AudioHelper.e()) {
                                QLog.w("ChatItemBuilder", 1, "TencentDocGrayTips, msg[" + paramView.msg + "], getText[" + localauxb.b.getText() + "], getLayoutParams[" + ((LinearLayout.LayoutParams)localauxb.b.getLayoutParams()).gravity + "], gravity[" + ((LinearLayout.LayoutParams)paramLinearLayout).gravity + "]");
                              }
                              a(paramView);
                              a((ChatMessage)paramMessageRecord, localauxb, (View)localObject1);
                              return localObject1;
                              localNumberFormatException1 = localNumberFormatException1;
                              i = j;
                              if (!QLog.isColorLevel()) {
                                break;
                              }
                              QLog.d("ChatItemBuilder", 2, "NumberFormatException: " + paramafuv.mMsgActionData);
                              i = j;
                              break;
                              label2543:
                              i = awhj.c;
                              break label1041;
                              label2551:
                              paramafuv = (MessageForGrayTips.HightlightItem)paramView.tipParam.a.get(paramView.tipParam.a.size() - 1);
                              i = j;
                              if (paramafuv == null) {
                                break label1041;
                              }
                              i = j;
                              if (paramafuv.actionType != 38) {
                                break label1041;
                              }
                              try
                              {
                                i = Integer.parseInt(paramafuv.mMsgActionData);
                              }
                              catch (NumberFormatException localNumberFormatException2)
                              {
                                i = j;
                              }
                            }
                            if (!QLog.isColorLevel()) {
                              break label1041;
                            }
                            QLog.d("ChatItemBuilder", 2, "NumberFormatException: " + paramafuv.mMsgActionData);
                            i = j;
                            break label1041;
                            label2658:
                            if (!Long.valueOf(paramafuv).equals(Long.valueOf(1112L))) {
                              break label1504;
                            }
                            bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B1A4", "0X800AD82", 0, 0, "", "", "", "");
                            break label1504;
                            paramafuv = null;
                            break label1643;
                            localauxb.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setVisibility(8);
                            paramafuv = localauxb.b.getLayoutParams();
                            if ((paramafuv instanceof ViewGroup.MarginLayoutParams))
                            {
                              paramafuv = (ViewGroup.MarginLayoutParams)paramafuv;
                              if (paramafuv.rightMargin != BaseChatItemLayout.y) {
                                paramafuv.rightMargin = BaseChatItemLayout.y;
                              }
                            }
                            localauxb.b.setMaxWidth(2147483647);
                            localauxb.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setOnClickListener(null);
                          }
                        }
                        catch (RuntimeException paramafuv)
                        {
                          for (;;)
                          {
                            label2835:
                            label2865:
                            label2877:
                            if (QLog.isColorLevel())
                            {
                              QLog.d("ChatItemBuilder", 2, "deal revoke tips fail", paramafuv);
                              continue;
                              label2802:
                              if (localNumberFormatException2.equals("6"))
                              {
                                LpReportInfo_dc03950.report(new LpReportInfo_dc03950("16", "7", "1"));
                                continue;
                                localauxb.b.setText(paramView.msg);
                                if (AppSetting.c)
                                {
                                  localauxb.b.setAccessibilityDelegate(null);
                                  continue;
                                  paramafuv = paramafzq.getDrawable(2130850537);
                                  continue;
                                  localauxb.b.setCompoundDrawables(null, null, null, null);
                                  localauxb.b.setCompoundDrawablePadding(0);
                                  if ((paramLinearLayout instanceof LinearLayout.LayoutParams)) {
                                    ((LinearLayout.LayoutParams)paramLinearLayout).gravity = 17;
                                  }
                                  if ((localObject1 instanceof StickerGrayTipLayout)) {
                                    ((StickerGrayTipLayout)localObject1).setGravity(17);
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                    paramView = "";
                    paramafuv = null;
                    continue;
                    label2945:
                    paramView = "";
                    paramafuv = null;
                  }
                }
                label2953:
                i = n;
                int n = j;
                j = i;
                i = n;
                continue;
                label2972:
                n = j;
                j = i;
                i = n;
              }
              label2987:
              paramafuv = null;
            }
          }
        }
      }
    }
  }
  
  public void a(View paramView, ChatMessage paramChatMessage, int paramInt)
  {
    super.a(paramView, paramChatMessage, paramInt);
    if ((paramInt == 0) && ((paramChatMessage instanceof MessageForUniteGrayTip)))
    {
      MessageForUniteGrayTip localMessageForUniteGrayTip = (MessageForUniteGrayTip)paramChatMessage;
      paramView = (auxb)paramView.getTag();
      if (paramView != null)
      {
        paramView.b.setText(paramChatMessage.msg);
        if (!TextUtils.isEmpty(localMessageForUniteGrayTip.contentDescription)) {
          paramView.b.setContentDescription(localMessageForUniteGrayTip.contentDescription);
        }
      }
    }
  }
  
  protected void a(MessageForUniteGrayTip paramMessageForUniteGrayTip)
  {
    if ((paramMessageForUniteGrayTip != null) && (paramMessageForUniteGrayTip.tipParam != null)) {
      switch (paramMessageForUniteGrayTip.tipParam.b)
      {
      }
    }
    do
    {
      return;
    } while (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(paramMessageForUniteGrayTip.msgseq)));
    this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramMessageForUniteGrayTip.msgseq), Boolean.valueOf(true));
    bfup.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForUniteGrayTip);
  }
  
  public bguj[] a(View paramView)
  {
    return new bguh().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auwx
 * JD-Core Version:    0.7.0.1
 */