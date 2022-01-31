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

public class aquw
  extends actm
{
  private SparseBooleanArray jdField_a_of_type_AndroidUtilSparseBooleanArray = new SparseBooleanArray(5);
  private ConcurrentHashMap<Long, Boolean> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(5);
  
  public aquw(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  public static void a(ChatMessage paramChatMessage, actn paramactn, View paramView)
  {
    if ((paramactn != null) && (paramView != null) && (paramChatMessage == null)) {}
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
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A613", "0X800A613", 0, 0, i + "", "", "", "");
      aanz.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
      i = 2;
      continue;
      if (((MessageForUniteGrayTip)localObject).istroop == 1)
      {
        bool1 = banb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.frienduin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
        bool2 = banb.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.frienduin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
        str1 = ((MessageForUniteGrayTip)localObject).tipParam.c;
        str2 = ajya.a(2131715911) + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131697954);
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
        bool1 = ((MessageForUniteGrayTip)localObject).tipParam.c.equals(ajya.a(2131715910) + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131694429));
        if (!bool1) {
          i = 11;
        } else {
          i = 12;
        }
      }
    }
  }
  
  protected actn a()
  {
    return new aqva(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, actn paramactn, View paramView, LinearLayout paramLinearLayout, acxj paramacxj)
  {
    if (!(paramactn instanceof aqva)) {
      QLog.e("ChatItemBuilder", 1, "diffclashh =" + paramactn.getClass());
    }
    aqva localaqva = (aqva)paramactn;
    if (paramView == null)
    {
      paramactn = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558782, null);
      localaqva.b = ((TextView)paramactn.findViewById(2131367153));
      localaqva.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView = ((AutoBgImageView)paramactn.findViewById(2131375219));
      paramView = localaqva.b.getLayoutParams();
      localObject1 = paramactn;
      if ((paramView instanceof ViewGroup.MarginLayoutParams))
      {
        paramView = (ViewGroup.MarginLayoutParams)paramView;
        localObject1 = paramactn;
        if (paramView.rightMargin != BaseChatItemLayout.x) {
          paramView.rightMargin = BaseChatItemLayout.x;
        }
      }
    }
    for (Object localObject1 = paramactn;; localObject1 = paramView)
    {
      localaqva.b.setLineSpacing(0.0F, 1.0F);
      localaqva.b.setIncludeFontPadding(true);
      localaqva.b.setMovementMethod(null);
      localaqva.b.setTextColor(((View)localObject1).getResources().getColorStateList(2131167108));
      localaqva.b.setGravity(19);
      localaqva.b.setBackgroundResource(0);
      Object localObject2;
      int i1;
      askf localaskf;
      List localList;
      int i;
      int j;
      int k;
      if ((localObject1 instanceof StickerGrayTipLayout))
      {
        bbkj.a(null, "AIO_Handle_Sticker_Cost");
        localObject2 = (StickerGrayTipLayout)localObject1;
        ((StickerGrayTipLayout)localObject2).a();
        paramactn = EmojiStickerManager.a().a(paramMessageRecord);
        i1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels;
        if ((paramactn != null) && (paramactn.size() > 0))
        {
          localaskf = (askf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14);
          localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramactn);
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
              paramactn = localaskf.a(((MessageForMarketFace)paramView).mMarkFaceMessage);
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
                if ((paramactn instanceof aobp))
                {
                  paramView = (aobp)paramactn;
                  if (paramView.a == null) {
                    break label2631;
                  }
                  if ((!EmojiStickerManager.jdField_f_of_type_Boolean) && (bbdx.a() > 1.048576E+008F))
                  {
                    n = 1;
                    label558:
                    if (n == 0) {
                      break label700;
                    }
                    paramactn = paramView.a("fromAIO", true, false, null, i3, i3);
                    label578:
                    paramView = paramView.a.epId;
                  }
                }
                for (;;)
                {
                  if (paramactn != null) {
                    ((StickerGrayTipLayout)localObject2).a(paramactn, i2, j, i3, i4, i5, paramView);
                  }
                  j = i;
                  i = m;
                  break;
                  if (!(paramView instanceof MessageForText)) {
                    break label2673;
                  }
                  paramactn = (MessageForText)paramView;
                  if (TextUtils.isEmpty(paramactn.msg)) {
                    break label2673;
                  }
                  paramactn = EmojiStickerManager.a().a(paramactn.msg);
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
                  paramactn = paramView.a(this.jdField_a_of_type_AndroidContentContext, f);
                  break label578;
                  if ((paramactn instanceof aocu))
                  {
                    paramactn = ((aocu)paramactn).b(this.jdField_a_of_type_AndroidContentContext, f);
                    paramView = "";
                  }
                  else if ((paramactn instanceof aocg))
                  {
                    paramactn = ((aocg)paramactn).b(this.jdField_a_of_type_AndroidContentContext, f);
                    paramView = "";
                  }
                  else
                  {
                    if ((paramView instanceof MessageForPic))
                    {
                      paramactn = advs.a(this.jdField_a_of_type_AndroidContentContext, (MessageForPic)paramView);
                      ThreadManager.post(new UniteGrayTipItemBuilder.1(this, paramView), 5, null, true);
                      paramView = "";
                      continue;
                      ((StickerGrayTipLayout)localObject1).a = new aqux(this);
                      bbkj.a("AIO_Handle_Sticker_Cost", null);
                      if (!(paramMessageRecord instanceof MessageForUniteGrayTip))
                      {
                        localaqva.b.setText(paramMessageRecord.msg);
                        return localObject1;
                      }
                      paramView = (MessageForUniteGrayTip)paramMessageRecord;
                      if (!actj.h) {
                        aqvc.a(paramView, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                      }
                      if ((paramView.tipParam != null) && (paramView.tipParam.b == 655381))
                      {
                        paramactn = (MessageForGrayTips.HightlightItem)paramView.tipParam.a.get(paramView.tipParam.a.size() - 1);
                        if ((paramactn != null) && (paramactn.actionType == 38)) {
                          j = 0;
                        }
                      }
                      try
                      {
                        i = Integer.parseInt(paramactn.mMsgActionData);
                        if (this.jdField_a_of_type_AndroidUtilSparseBooleanArray.get(i, true))
                        {
                          axqy.b(null, "dc00898", "", "", "0X8009979", "0X8009979", i, i, "", "", "", "");
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
                          i = aser.b;
                          label1040:
                          if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramView.uniseq)))
                          {
                            if (QLog.isColorLevel()) {
                              QLog.d("ChatItemBuilder", 2, "Temp Report mark: grayTipsOnShow " + paramView.uniseq);
                            }
                            axqy.b(null, "dc00898", "", "", "0X8009ACF", "0X8009ACF", i, i, "", "", "", "");
                            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramView.uniseq), Boolean.valueOf(false));
                          }
                        }
                        if ((paramView.tipParam != null) && (paramView.tipParam.b == 655397))
                        {
                          paramactn = paramView.getExtInfoFromExtStr("unite_gray_tips_align");
                          if ((!TextUtils.isEmpty(paramactn)) && (paramactn.equals("center"))) {
                            localaqva.b.setGravity(17);
                          }
                          localaqva.b.setLineSpacing(8.0F, 1.0F);
                          if ((!"null".equals(((ChatBackgroundManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(63)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) || ((!ThemeUtil.isDefaultTheme()) && (!ThemeUtil.isNowThemeIsNight(null, false, null)) && (!ThemeUtil.isNowThemeIsSimple(null, false, null))))
                          {
                            localaqva.b.setTextColor(((View)localObject1).getResources().getColorStateList(2131167034));
                            localaqva.b.setBackgroundResource(2130849627);
                          }
                          if (("1008".equals(paramView.getExtInfoFromExtStr("uint64_busi_id"))) && (!paramView.docTipHasReport))
                          {
                            paramView.docTipHasReport = true;
                            axqy.b(null, "dc00898", "", "", "0X800A638", "0X800A638", paramView.istroop, 0, "", "", "", "");
                          }
                        }
                        if ((((MessageForUniteGrayTip)paramMessageRecord).editState == 1) && ((paramView.tipParam == null) || ((paramView.tipParam != null) && (paramView.tipParam.a == null))) && (QLog.isColorLevel()))
                        {
                          localObject2 = paramView.tipParam;
                          if (paramView.tipParam == null) {
                            break label2392;
                          }
                          paramactn = paramView.tipParam.a;
                          label1410:
                          QLog.d("ChatItemBuilder", 2, new Object[] { "revoke msg grayTipItemBuilder edit param error grayMsg.tipParam = ", localObject2, " hightLightItems=", paramactn });
                        }
                      }
                      catch (NumberFormatException localNumberFormatException1)
                      {
                        try
                        {
                          if ((paramView.tipParam != null) && (paramView.tipParam.b == 1))
                          {
                            paramactn = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130848532);
                            localaqva.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setImageDrawable(paramactn);
                            localaqva.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131691501));
                            localaqva.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setVisibility(0);
                            localaqva.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setOnClickListener(new aquy(this, localaqva));
                            localaqva.b.setMaxWidth(bbll.a() - bbll.b(31.0F));
                            ((ViewGroup.MarginLayoutParams)localaqva.b.getLayoutParams()).rightMargin = 0;
                          }
                          for (;;)
                          {
                            for (;;)
                            {
                              if ((paramView.tipParam == null) || (paramView.tipParam.a == null)) {
                                break label2521;
                              }
                              long l1 = paramView.uniseq;
                              long l2 = localaqva.jdField_a_of_type_Int;
                              if (QLog.isColorLevel()) {
                                QLog.d("ChatItemBuilder", 2, new Object[] { "revoke msg grayTipItemBuilder msg uinseq=", Long.valueOf(l1), ",holder.mPosition=", Long.valueOf(l2) });
                              }
                              paramactn = paramView.tipParam.a;
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
                              paramLinearLayout = paramView.getHightlightMsgText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLinearLayout.getContext(), bool1, localaqva.b);
                              localaqva.b.setText(paramLinearLayout);
                              localaqva.b.setClickable(true);
                              localaqva.b.setFocusable(true);
                              localaqva.b.setMovementMethod(bckl.a());
                              if (AppSetting.d) {
                                localaqva.b.setAccessibilityDelegate(new aquz(this, l1, l2, paramactn, paramLinearLayout));
                              }
                              localaqva.b.setOnTouchListener(paramacxj);
                              localaqva.b.setOnLongClickListener(paramacxj);
                              if (!TextUtils.isEmpty(paramView.contentDescription)) {
                                localaqva.b.setContentDescription(paramView.contentDescription);
                              }
                              paramLinearLayout = localaqva.b.getLayoutParams();
                              if ((paramView == null) || (paramView.tipParam == null) || (paramView.tipParam.b != 3276801)) {
                                break label2563;
                              }
                              paramacxj = this.jdField_a_of_type_AndroidContentContext.getResources();
                              if (Build.VERSION.SDK_INT < 21) {
                                break label2551;
                              }
                              paramactn = paramacxj.getDrawable(2130849432, this.jdField_a_of_type_AndroidContentContext.getTheme());
                              if (paramactn != null) {
                                paramactn.setBounds(0, 0, paramactn.getIntrinsicWidth(), paramactn.getIntrinsicHeight());
                              }
                              localaqva.b.setCompoundDrawables(paramactn, null, null, null);
                              localaqva.b.setCompoundDrawablePadding(actj.a(8.0F, paramacxj));
                              if ((paramLinearLayout instanceof LinearLayout.LayoutParams)) {
                                ((LinearLayout.LayoutParams)paramLinearLayout).gravity = 16;
                              }
                              if ((localObject1 instanceof StickerGrayTipLayout)) {
                                ((StickerGrayTipLayout)localObject1).setGravity(16);
                              }
                              if (AudioHelper.d()) {
                                QLog.w("ChatItemBuilder", 1, "TencentDocGrayTips, msg[" + paramView.msg + "], getText[" + localaqva.b.getText() + "], getLayoutParams[" + ((LinearLayout.LayoutParams)localaqva.b.getLayoutParams()).gravity + "], gravity[" + ((LinearLayout.LayoutParams)paramLinearLayout).gravity + "]");
                              }
                              a((ChatMessage)paramMessageRecord, localaqva, (View)localObject1);
                              return localObject1;
                              localNumberFormatException1 = localNumberFormatException1;
                              i = j;
                              if (!QLog.isColorLevel()) {
                                break;
                              }
                              QLog.d("ChatItemBuilder", 2, "NumberFormatException: " + paramactn.mMsgActionData);
                              i = j;
                              break;
                              label2277:
                              i = aser.c;
                              break label1040;
                              label2285:
                              paramactn = (MessageForGrayTips.HightlightItem)paramView.tipParam.a.get(paramView.tipParam.a.size() - 1);
                              i = j;
                              if (paramactn == null) {
                                break label1040;
                              }
                              i = j;
                              if (paramactn.actionType != 38) {
                                break label1040;
                              }
                              try
                              {
                                i = Integer.parseInt(paramactn.mMsgActionData);
                              }
                              catch (NumberFormatException localNumberFormatException2)
                              {
                                i = j;
                              }
                            }
                            if (!QLog.isColorLevel()) {
                              break label1040;
                            }
                            QLog.d("ChatItemBuilder", 2, "NumberFormatException: " + paramactn.mMsgActionData);
                            i = j;
                            break label1040;
                            label2392:
                            paramactn = null;
                            break label1410;
                            localaqva.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setVisibility(8);
                            paramactn = localaqva.b.getLayoutParams();
                            if ((paramactn instanceof ViewGroup.MarginLayoutParams))
                            {
                              paramactn = (ViewGroup.MarginLayoutParams)paramactn;
                              if (paramactn.rightMargin != BaseChatItemLayout.x) {
                                paramactn.rightMargin = BaseChatItemLayout.x;
                              }
                            }
                            localaqva.b.setMaxWidth(2147483647);
                            localaqva.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setOnClickListener(null);
                          }
                        }
                        catch (RuntimeException paramactn)
                        {
                          for (;;)
                          {
                            label2563:
                            if (QLog.isColorLevel())
                            {
                              QLog.d("ChatItemBuilder", 2, "deal revoke tips fail", paramactn);
                              continue;
                              label2488:
                              if (localNumberFormatException2.equals("6"))
                              {
                                LpReportInfo_dc03950.report(new LpReportInfo_dc03950("16", "7", "1"));
                                continue;
                                label2521:
                                localaqva.b.setText(paramView.msg);
                                if (AppSetting.d)
                                {
                                  localaqva.b.setAccessibilityDelegate(null);
                                  continue;
                                  label2551:
                                  paramactn = paramacxj.getDrawable(2130849432);
                                  continue;
                                  localaqva.b.setCompoundDrawables(null, null, null, null);
                                  localaqva.b.setCompoundDrawablePadding(0);
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
                    paramactn = null;
                    continue;
                    label2631:
                    paramView = "";
                    paramactn = null;
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
              paramactn = null;
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
      paramView = (aqva)paramView.getTag();
      if (paramView != null)
      {
        paramView.b.setText(paramChatMessage.msg);
        if (!TextUtils.isEmpty(localMessageForUniteGrayTip.contentDescription)) {
          paramView.b.setContentDescription(localMessageForUniteGrayTip.contentDescription);
        }
      }
    }
  }
  
  public bbmh[] a(View paramView)
  {
    return new bbmf().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aquw
 * JD-Core Version:    0.7.0.1
 */