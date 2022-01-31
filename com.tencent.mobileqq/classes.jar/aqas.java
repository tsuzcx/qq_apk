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
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
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
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class aqas
  extends acjb
{
  private SparseBooleanArray jdField_a_of_type_AndroidUtilSparseBooleanArray = new SparseBooleanArray(5);
  private ConcurrentHashMap<Long, Boolean> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(5);
  
  public aqas(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  public static void a(ChatMessage paramChatMessage, acjc paramacjc, View paramView)
  {
    if ((paramacjc != null) && (paramView != null) && (paramChatMessage == null)) {}
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
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A613", "0X800A613", 0, 0, i + "", "", "", "");
      aael.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
      i = 2;
      continue;
      if (((MessageForUniteGrayTip)localObject).istroop == 1)
      {
        bool1 = azlj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.frienduin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
        bool2 = azlj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.frienduin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
        str1 = ((MessageForUniteGrayTip)localObject).tipParam.c;
        str2 = ajjy.a(2131650109) + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131632219);
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
        bool1 = ((MessageForUniteGrayTip)localObject).tipParam.c.equals(ajjy.a(2131650108) + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131628768));
        if (!bool1) {
          i = 11;
        } else {
          i = 12;
        }
      }
    }
  }
  
  protected acjc a()
  {
    return new aqaw(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, acjc paramacjc, View paramView, LinearLayout paramLinearLayout, acmv paramacmv)
  {
    if (!(paramacjc instanceof aqaw)) {
      QLog.e("ChatItemBuilder", 1, "diffclashh =" + paramacjc.getClass());
    }
    aqaw localaqaw = (aqaw)paramacjc;
    if (paramView == null)
    {
      paramacjc = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131493226, null);
      localaqaw.b = ((TextView)paramacjc.findViewById(2131301543));
      localaqaw.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView = ((AutoBgImageView)paramacjc.findViewById(2131309469));
      paramView = localaqaw.b.getLayoutParams();
      localObject1 = paramacjc;
      if ((paramView instanceof ViewGroup.MarginLayoutParams))
      {
        paramView = (ViewGroup.MarginLayoutParams)paramView;
        localObject1 = paramacjc;
        if (paramView.rightMargin != BaseChatItemLayout.x) {
          paramView.rightMargin = BaseChatItemLayout.x;
        }
      }
    }
    for (Object localObject1 = paramacjc;; localObject1 = paramView)
    {
      localaqaw.b.setLineSpacing(0.0F, 1.0F);
      localaqaw.b.setIncludeFontPadding(true);
      localaqaw.b.setMovementMethod(null);
      localaqaw.b.setTextColor(((View)localObject1).getResources().getColorStateList(2131101511));
      localaqaw.b.setGravity(19);
      localaqaw.b.setBackgroundResource(0);
      Object localObject2;
      int i1;
      arnz localarnz;
      List localList;
      int i;
      int j;
      int k;
      if ((localObject1 instanceof StickerGrayTipLayout))
      {
        baio.a(null, "AIO_Handle_Sticker_Cost");
        localObject2 = (StickerGrayTipLayout)localObject1;
        ((StickerGrayTipLayout)localObject2).a();
        paramacjc = EmojiStickerManager.a().a(paramMessageRecord);
        i1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels;
        if ((paramacjc != null) && (paramacjc.size() > 0))
        {
          localarnz = (arnz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14);
          localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramacjc);
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
              paramacjc = localarnz.a(((MessageForMarketFace)paramView).mMarkFaceMessage);
            }
            for (;;)
            {
              label423:
              int i2 = (int)(localStickerInfo.x * i1);
              i = (int)(localStickerInfo.y * i1);
              int i3 = (int)(localStickerInfo.width * i1);
              int i4 = (int)(localStickerInfo.height * i1);
              int i5 = localStickerInfo.rotate;
              if (k == localList.size() - 1)
              {
                if (i >= 0) {
                  break label2658;
                }
                i = -i;
                j = 0;
              }
              for (;;)
              {
                label505:
                float f = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
                if ((paramacjc instanceof anla))
                {
                  paramView = (anla)paramacjc;
                  if (paramView.a == null) {
                    break label2631;
                  }
                  if ((!EmojiStickerManager.jdField_f_of_type_Boolean) && (bace.a() > 1.048576E+008F))
                  {
                    n = 1;
                    label558:
                    if (n == 0) {
                      break label700;
                    }
                    paramacjc = paramView.a("fromAIO", true, false, null, i3, i3);
                    label578:
                    paramView = paramView.a.epId;
                  }
                }
                for (;;)
                {
                  if (paramacjc != null) {
                    ((StickerGrayTipLayout)localObject2).a(paramacjc, i2, j, i3, i4, i5, paramView);
                  }
                  j = i;
                  i = m;
                  break;
                  if (!(paramView instanceof MessageForText)) {
                    break label2673;
                  }
                  paramacjc = (MessageForText)paramView;
                  if (TextUtils.isEmpty(paramacjc.msg)) {
                    break label2673;
                  }
                  paramacjc = EmojiStickerManager.a().a(paramacjc.msg);
                  break label423;
                  n = j + i;
                  if (n >= 0) {
                    break label2639;
                  }
                  n = -i;
                  i = -i;
                  ((StickerGrayTipLayout)localObject2).a(n - j);
                  j = 0;
                  break label505;
                  n = 0;
                  break label558;
                  label700:
                  paramacjc = paramView.a(this.jdField_a_of_type_AndroidContentContext, f);
                  break label578;
                  if ((paramacjc instanceof anmf))
                  {
                    paramacjc = ((anmf)paramacjc).b(this.jdField_a_of_type_AndroidContentContext, f);
                    paramView = "";
                  }
                  else if ((paramacjc instanceof anlr))
                  {
                    paramacjc = ((anlr)paramacjc).b(this.jdField_a_of_type_AndroidContentContext, f);
                    paramView = "";
                  }
                  else
                  {
                    if ((paramView instanceof MessageForPic))
                    {
                      paramacjc = adkt.a(this.jdField_a_of_type_AndroidContentContext, (MessageForPic)paramView);
                      ThreadManager.post(new UniteGrayTipItemBuilder.1(this, paramView), 5, null, true);
                      paramView = "";
                      continue;
                      ((StickerGrayTipLayout)localObject1).a = new aqat(this);
                      baio.a("AIO_Handle_Sticker_Cost", null);
                      if (!(paramMessageRecord instanceof MessageForUniteGrayTip))
                      {
                        localaqaw.b.setText(paramMessageRecord.msg);
                        return localObject1;
                      }
                      paramView = (MessageForUniteGrayTip)paramMessageRecord;
                      if (!aciy.h) {
                        aqay.a(paramView, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                      }
                      if ((paramView.tipParam != null) && (paramView.tipParam.b == 655381))
                      {
                        paramacjc = (MessageForGrayTips.HightlightItem)paramView.tipParam.a.get(paramView.tipParam.a.size() - 1);
                        if ((paramacjc != null) && (paramacjc.actionType == 38)) {
                          j = 0;
                        }
                      }
                      try
                      {
                        i = Integer.parseInt(paramacjc.mMsgActionData);
                        if (this.jdField_a_of_type_AndroidUtilSparseBooleanArray.get(i, true))
                        {
                          awqx.b(null, "dc00898", "", "", "0X8009979", "0X8009979", i, i, "", "", "", "");
                          this.jdField_a_of_type_AndroidUtilSparseBooleanArray.put(i, false);
                        }
                        if ((paramView.tipParam != null) && (paramView.tipParam.b == 655383))
                        {
                          j = 0;
                          if (paramView.tipParam.a != null) {
                            break label2285;
                          }
                          if (paramMessageRecord.istroop != 0) {
                            break label2277;
                          }
                          i = arin.b;
                          label1040:
                          if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramView.uniseq)))
                          {
                            if (QLog.isColorLevel()) {
                              QLog.d("ChatItemBuilder", 2, "Temp Report mark: grayTipsOnShow " + paramView.uniseq);
                            }
                            awqx.b(null, "dc00898", "", "", "0X8009ACF", "0X8009ACF", i, i, "", "", "", "");
                            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramView.uniseq), Boolean.valueOf(false));
                          }
                        }
                        if ((paramView.tipParam != null) && (paramView.tipParam.b == 655397))
                        {
                          paramacjc = paramView.getExtInfoFromExtStr("unite_gray_tips_align");
                          if ((!TextUtils.isEmpty(paramacjc)) && (paramacjc.equals("center"))) {
                            localaqaw.b.setGravity(17);
                          }
                          localaqaw.b.setLineSpacing(8.0F, 1.0F);
                          if ((!"null".equals(((ChatBackgroundManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(63)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) || ((!ThemeUtil.isDefaultTheme()) && (!ThemeUtil.isNowThemeIsNight(null, false, null)) && (!ThemeUtil.isNowThemeIsSimple(null, false, null))))
                          {
                            localaqaw.b.setTextColor(((View)localObject1).getResources().getColorStateList(2131101438));
                            localaqaw.b.setBackgroundResource(2130849382);
                          }
                          if (("1008".equals(paramView.getExtInfoFromExtStr("uint64_busi_id"))) && (!paramView.docTipHasReport))
                          {
                            paramView.docTipHasReport = true;
                            awqx.b(null, "dc00898", "", "", "0X800A638", "0X800A638", paramView.istroop, 0, "", "", "", "");
                          }
                        }
                        if ((((MessageForUniteGrayTip)paramMessageRecord).editState == 1) && ((paramView.tipParam == null) || ((paramView.tipParam != null) && (paramView.tipParam.a == null))) && (QLog.isColorLevel()))
                        {
                          localObject2 = paramView.tipParam;
                          if (paramView.tipParam == null) {
                            break label2392;
                          }
                          paramacjc = paramView.tipParam.a;
                          label1410:
                          QLog.d("ChatItemBuilder", 2, new Object[] { "revoke msg grayTipItemBuilder edit param error grayMsg.tipParam = ", localObject2, " hightLightItems=", paramacjc });
                        }
                      }
                      catch (NumberFormatException localNumberFormatException1)
                      {
                        try
                        {
                          if ((paramView.tipParam != null) && (paramView.tipParam.b == 1))
                          {
                            paramacjc = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130848294);
                            localaqaw.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setImageDrawable(paramacjc);
                            localaqaw.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131625925));
                            localaqaw.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setVisibility(0);
                            localaqaw.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setOnClickListener(new aqau(this, localaqaw));
                            localaqaw.b.setMaxWidth(bajq.a() - bajq.b(31.0F));
                            ((ViewGroup.MarginLayoutParams)localaqaw.b.getLayoutParams()).rightMargin = 0;
                          }
                          for (;;)
                          {
                            for (;;)
                            {
                              if ((paramView.tipParam == null) || (paramView.tipParam.a == null)) {
                                break label2521;
                              }
                              long l1 = paramView.uniseq;
                              long l2 = localaqaw.jdField_a_of_type_Int;
                              if (QLog.isColorLevel()) {
                                QLog.d("ChatItemBuilder", 2, new Object[] { "revoke msg grayTipItemBuilder msg uinseq=", Long.valueOf(l1), ",holder.mPosition=", Long.valueOf(l2) });
                              }
                              paramacjc = paramView.tipParam.a;
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
                                      break label2488;
                                    }
                                    LpReportInfo_dc03950.report(new LpReportInfo_dc03950("16", "8", "1"));
                                    LpReportInfo_dc03950.report(new LpReportInfo_dc03950("25", "6", "1"));
                                  }
                                  this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramView.uniseq), Boolean.valueOf(false));
                                  bool1 = bool2;
                                }
                              }
                              paramLinearLayout = paramView.getHightlightMsgText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLinearLayout.getContext(), bool1, localaqaw.b);
                              localaqaw.b.setText(paramLinearLayout);
                              localaqaw.b.setClickable(true);
                              localaqaw.b.setFocusable(true);
                              localaqaw.b.setMovementMethod(bbgw.a());
                              if (AppSetting.c) {
                                localaqaw.b.setAccessibilityDelegate(new aqav(this, l1, l2, paramacjc, paramLinearLayout));
                              }
                              localaqaw.b.setOnTouchListener(paramacmv);
                              localaqaw.b.setOnLongClickListener(paramacmv);
                              if (!TextUtils.isEmpty(paramView.contentDescription)) {
                                localaqaw.b.setContentDescription(paramView.contentDescription);
                              }
                              paramLinearLayout = localaqaw.b.getLayoutParams();
                              if ((paramView == null) || (paramView.tipParam == null) || (paramView.tipParam.b != 3276801)) {
                                break label2563;
                              }
                              paramacmv = this.jdField_a_of_type_AndroidContentContext.getResources();
                              if (Build.VERSION.SDK_INT < 21) {
                                break label2551;
                              }
                              paramacjc = paramacmv.getDrawable(2130849188, this.jdField_a_of_type_AndroidContentContext.getTheme());
                              if (paramacjc != null) {
                                paramacjc.setBounds(0, 0, paramacjc.getIntrinsicWidth(), paramacjc.getIntrinsicHeight());
                              }
                              localaqaw.b.setCompoundDrawables(paramacjc, null, null, null);
                              localaqaw.b.setCompoundDrawablePadding(aciy.a(8.0F, paramacmv));
                              if ((paramLinearLayout instanceof LinearLayout.LayoutParams)) {
                                ((LinearLayout.LayoutParams)paramLinearLayout).gravity = 16;
                              }
                              if ((localObject1 instanceof StickerGrayTipLayout)) {
                                ((StickerGrayTipLayout)localObject1).setGravity(16);
                              }
                              if (AudioHelper.d()) {
                                QLog.w("ChatItemBuilder", 1, "TencentDocGrayTips, msg[" + paramView.msg + "], getText[" + localaqaw.b.getText() + "], getLayoutParams[" + ((LinearLayout.LayoutParams)localaqaw.b.getLayoutParams()).gravity + "], gravity[" + ((LinearLayout.LayoutParams)paramLinearLayout).gravity + "]");
                              }
                              a((ChatMessage)paramMessageRecord, localaqaw, (View)localObject1);
                              return localObject1;
                              localNumberFormatException1 = localNumberFormatException1;
                              i = j;
                              if (!QLog.isColorLevel()) {
                                break;
                              }
                              QLog.d("ChatItemBuilder", 2, "NumberFormatException: " + paramacjc.mMsgActionData);
                              i = j;
                              break;
                              label2277:
                              i = arin.c;
                              break label1040;
                              label2285:
                              paramacjc = (MessageForGrayTips.HightlightItem)paramView.tipParam.a.get(paramView.tipParam.a.size() - 1);
                              i = j;
                              if (paramacjc == null) {
                                break label1040;
                              }
                              i = j;
                              if (paramacjc.actionType != 38) {
                                break label1040;
                              }
                              try
                              {
                                i = Integer.parseInt(paramacjc.mMsgActionData);
                              }
                              catch (NumberFormatException localNumberFormatException2)
                              {
                                i = j;
                              }
                            }
                            if (!QLog.isColorLevel()) {
                              break label1040;
                            }
                            QLog.d("ChatItemBuilder", 2, "NumberFormatException: " + paramacjc.mMsgActionData);
                            i = j;
                            break label1040;
                            label2392:
                            paramacjc = null;
                            break label1410;
                            localaqaw.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setVisibility(8);
                            paramacjc = localaqaw.b.getLayoutParams();
                            if ((paramacjc instanceof ViewGroup.MarginLayoutParams))
                            {
                              paramacjc = (ViewGroup.MarginLayoutParams)paramacjc;
                              if (paramacjc.rightMargin != BaseChatItemLayout.x) {
                                paramacjc.rightMargin = BaseChatItemLayout.x;
                              }
                            }
                            localaqaw.b.setMaxWidth(2147483647);
                            localaqaw.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setOnClickListener(null);
                          }
                        }
                        catch (RuntimeException paramacjc)
                        {
                          for (;;)
                          {
                            label2563:
                            if (QLog.isColorLevel())
                            {
                              QLog.d("ChatItemBuilder", 2, "deal revoke tips fail", paramacjc);
                              continue;
                              label2488:
                              if (localNumberFormatException2.equals("6"))
                              {
                                LpReportInfo_dc03950.report(new LpReportInfo_dc03950("16", "7", "1"));
                                continue;
                                label2521:
                                localaqaw.b.setText(paramView.msg);
                                if (AppSetting.c)
                                {
                                  localaqaw.b.setAccessibilityDelegate(null);
                                  continue;
                                  label2551:
                                  paramacjc = paramacmv.getDrawable(2130849188);
                                  continue;
                                  localaqaw.b.setCompoundDrawables(null, null, null, null);
                                  localaqaw.b.setCompoundDrawablePadding(0);
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
                    paramacjc = null;
                    continue;
                    label2631:
                    paramView = "";
                    paramacjc = null;
                  }
                }
                label2639:
                i = n;
                int n = j;
                j = i;
                i = n;
                continue;
                label2658:
                n = j;
                j = i;
                i = n;
              }
              label2673:
              paramacjc = null;
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
      paramView = (aqaw)paramView.getTag();
      if (paramView != null)
      {
        paramView.b.setText(paramChatMessage.msg);
        if (!TextUtils.isEmpty(localMessageForUniteGrayTip.contentDescription)) {
          paramView.b.setContentDescription(localMessageForUniteGrayTip.contentDescription);
        }
      }
    }
  }
  
  public bakj[] a(View paramView)
  {
    return new bakh().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqas
 * JD-Core Version:    0.7.0.1
 */