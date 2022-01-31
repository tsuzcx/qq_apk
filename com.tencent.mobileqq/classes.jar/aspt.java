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

public class aspt
  extends aepl
{
  private SparseBooleanArray jdField_a_of_type_AndroidUtilSparseBooleanArray = new SparseBooleanArray(5);
  private HashMap<Long, Boolean> jdField_a_of_type_JavaUtilHashMap = new HashMap(10);
  private ConcurrentHashMap<Long, Boolean> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(5);
  
  public aspt(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  public static void a(ChatMessage paramChatMessage, aepm paramaepm, View paramView)
  {
    if ((paramaepm != null) && (paramView != null) && (paramChatMessage == null)) {}
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
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A613", "0X800A613", 0, 0, i + "", "", "", "");
      acjm.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
      i = 2;
      continue;
      if (((MessageForUniteGrayTip)localObject).istroop == 1)
      {
        bool1 = bcpx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.frienduin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
        bool2 = bcpx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.frienduin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
        str1 = ((MessageForUniteGrayTip)localObject).tipParam.c;
        str2 = alud.a(2131716295) + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131698133);
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
        bool1 = ((MessageForUniteGrayTip)localObject).tipParam.c.equals(alud.a(2131716294) + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131694588));
        if (!bool1) {
          i = 11;
        } else {
          i = 12;
        }
      }
    }
  }
  
  protected aepm a()
  {
    return new aspx(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, aepm paramaepm, View paramView, LinearLayout paramLinearLayout, aetk paramaetk)
  {
    if (!(paramaepm instanceof aspx)) {
      QLog.e("ChatItemBuilder", 1, "diffclashh =" + paramaepm.getClass());
    }
    aspx localaspx = (aspx)paramaepm;
    if (paramView == null)
    {
      paramaepm = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558817, null);
      localaspx.b = ((TextView)paramaepm.findViewById(2131367292));
      localaspx.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView = ((AutoBgImageView)paramaepm.findViewById(2131375752));
      paramView = localaspx.b.getLayoutParams();
      localObject1 = paramaepm;
      if ((paramView instanceof ViewGroup.MarginLayoutParams))
      {
        paramView = (ViewGroup.MarginLayoutParams)paramView;
        localObject1 = paramaepm;
        if (paramView.rightMargin != BaseChatItemLayout.x) {
          paramView.rightMargin = BaseChatItemLayout.x;
        }
      }
    }
    for (Object localObject1 = paramaepm;; localObject1 = paramView)
    {
      localaspx.b.setLineSpacing(0.0F, 1.0F);
      localaspx.b.setIncludeFontPadding(true);
      localaspx.b.setMovementMethod(null);
      localaspx.b.setTextColor(((View)localObject1).getResources().getColorStateList(2131167166));
      localaspx.b.setGravity(19);
      localaspx.b.setBackgroundResource(0);
      Object localObject2;
      int i1;
      aufn localaufn;
      List localList;
      int i;
      int j;
      int k;
      if ((localObject1 instanceof StickerGrayTipLayout))
      {
        bdnm.a(null, "AIO_Handle_Sticker_Cost");
        localObject2 = (StickerGrayTipLayout)localObject1;
        ((StickerGrayTipLayout)localObject2).a();
        paramaepm = EmojiStickerManager.a().a(paramMessageRecord);
        i1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels;
        if ((paramaepm != null) && (paramaepm.size() > 0))
        {
          localaufn = (aufn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14);
          localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramaepm);
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
              paramaepm = localaufn.a(((MessageForMarketFace)paramView).mMarkFaceMessage);
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
                  break label2724;
                }
                i = -i;
                j = 0;
              }
              for (;;)
              {
                label506:
                float f = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
                if ((paramaepm instanceof apxv))
                {
                  paramView = (apxv)paramaepm;
                  if (paramView.a == null) {
                    break label2697;
                  }
                  if ((!EmojiStickerManager.jdField_f_of_type_Boolean) && (bdhb.a() > 1.048576E+008F))
                  {
                    n = 1;
                    label559:
                    if (n == 0) {
                      break label701;
                    }
                    paramaepm = paramView.a("fromAIO", true, false, null, i3, i3);
                    label579:
                    paramView = paramView.a.epId;
                  }
                }
                for (;;)
                {
                  if (paramaepm != null) {
                    ((StickerGrayTipLayout)localObject2).a(paramaepm, i2, j, i3, i4, i5, paramView);
                  }
                  j = i;
                  i = m;
                  break;
                  if (!(paramView instanceof MessageForText)) {
                    break label2739;
                  }
                  paramaepm = (MessageForText)paramView;
                  if (TextUtils.isEmpty(paramaepm.msg)) {
                    break label2739;
                  }
                  paramaepm = EmojiStickerManager.a().a(paramaepm.msg);
                  break label424;
                  n = j + i;
                  if (n >= 0) {
                    break label2705;
                  }
                  n = -i;
                  i = -i;
                  ((StickerGrayTipLayout)localObject2).a(n - j);
                  j = 0;
                  break label506;
                  n = 0;
                  break label559;
                  label701:
                  paramaepm = paramView.a(this.jdField_a_of_type_AndroidContentContext, f);
                  break label579;
                  if ((paramaepm instanceof apza))
                  {
                    paramaepm = ((apza)paramaepm).b(this.jdField_a_of_type_AndroidContentContext, f);
                    paramView = "";
                  }
                  else if ((paramaepm instanceof apym))
                  {
                    paramaepm = ((apym)paramaepm).b(this.jdField_a_of_type_AndroidContentContext, f);
                    paramView = "";
                  }
                  else
                  {
                    if ((paramView instanceof MessageForPic))
                    {
                      paramaepm = afwu.a(this.jdField_a_of_type_AndroidContentContext, (MessageForPic)paramView);
                      ThreadManager.post(new UniteGrayTipItemBuilder.1(this, paramView), 5, null, true);
                      paramView = "";
                      continue;
                      ((StickerGrayTipLayout)localObject1).a = new aspu(this);
                      bdnm.a("AIO_Handle_Sticker_Cost", null);
                      if (!(paramMessageRecord instanceof MessageForUniteGrayTip))
                      {
                        localaspx.b.setText(paramMessageRecord.msg);
                        return localObject1;
                      }
                      paramView = (MessageForUniteGrayTip)paramMessageRecord;
                      if (!aepi.h) {
                        aspz.a(paramView, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                      }
                      if ((paramView.tipParam != null) && (paramView.tipParam.b == 655381))
                      {
                        paramaepm = (MessageForGrayTips.HightlightItem)paramView.tipParam.a.get(paramView.tipParam.a.size() - 1);
                        if ((paramaepm != null) && (paramaepm.actionType == 38)) {
                          j = 0;
                        }
                      }
                      try
                      {
                        i = Integer.parseInt(paramaepm.mMsgActionData);
                        if (this.jdField_a_of_type_AndroidUtilSparseBooleanArray.get(i, true))
                        {
                          azqs.b(null, "dc00898", "", "", "0X8009979", "0X8009979", i, i, "", "", "", "");
                          this.jdField_a_of_type_AndroidUtilSparseBooleanArray.put(i, false);
                        }
                        if ((paramView.tipParam != null) && (paramView.tipParam.b == 655383))
                        {
                          j = 0;
                          if (paramView.tipParam.a != null) {
                            break label2351;
                          }
                          if (paramMessageRecord.istroop != 0) {
                            break label2343;
                          }
                          i = auaa.b;
                          label1041:
                          if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramView.uniseq)))
                          {
                            if (QLog.isColorLevel()) {
                              QLog.d("ChatItemBuilder", 2, "Temp Report mark: grayTipsOnShow " + paramView.uniseq);
                            }
                            azqs.b(null, "dc00898", "", "", "0X8009ACF", "0X8009ACF", i, i, "", "", "", "");
                            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramView.uniseq), Boolean.valueOf(false));
                          }
                        }
                        if ((paramView.tipParam != null) && (paramView.tipParam.b == 655397))
                        {
                          aspz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView);
                          paramaepm = paramView.getExtInfoFromExtStr("unite_gray_tips_align");
                          if ((!TextUtils.isEmpty(paramaepm)) && (paramaepm.equals("center"))) {
                            localaspx.b.setGravity(17);
                          }
                          localaspx.b.setLineSpacing(8.0F, 1.0F);
                          if ((!"null".equals(((ChatBackgroundManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(63)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) || ((!ThemeUtil.isDefaultTheme()) && (!ThemeUtil.isNowThemeIsNight(null, false, null)) && (!ThemeUtil.isNowThemeIsSimple(null, false, null))))
                          {
                            localaspx.b.setTextColor(((View)localObject1).getResources().getColorStateList(2131167087));
                            localaspx.b.setBackgroundResource(2130850134);
                          }
                          paramaepm = paramView.getExtInfoFromExtStr("uint64_busi_id");
                          if (("1008".equals(paramaepm)) && (!paramView.docTipHasReport))
                          {
                            paramView.docTipHasReport = true;
                            azqs.b(null, "dc00898", "", "", "0X800A638", "0X800A638", paramView.istroop, 0, "", "", "", "");
                          }
                          if (Long.valueOf(paramaepm).equals(Long.valueOf(1021L)))
                          {
                            paramView.dkTipHasReport = true;
                            azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AD82", "0X800AD82", 0, 0, "", "", "", "");
                          }
                        }
                        if ((((MessageForUniteGrayTip)paramMessageRecord).editState == 1) && ((paramView.tipParam == null) || ((paramView.tipParam != null) && (paramView.tipParam.a == null))) && (QLog.isColorLevel()))
                        {
                          localObject2 = paramView.tipParam;
                          if (paramView.tipParam == null) {
                            break label2458;
                          }
                          paramaepm = paramView.tipParam.a;
                          label1471:
                          QLog.d("ChatItemBuilder", 2, new Object[] { "revoke msg grayTipItemBuilder edit param error grayMsg.tipParam = ", localObject2, " hightLightItems=", paramaepm });
                        }
                      }
                      catch (NumberFormatException localNumberFormatException1)
                      {
                        try
                        {
                          if ((paramView.tipParam != null) && (paramView.tipParam.b == 1))
                          {
                            paramaepm = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130849033);
                            localaspx.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setImageDrawable(paramaepm);
                            localaspx.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131691556));
                            localaspx.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setVisibility(0);
                            localaspx.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setOnClickListener(new aspv(this, localaspx));
                            localaspx.b.setMaxWidth(bdoo.a() - bdoo.b(31.0F));
                            ((ViewGroup.MarginLayoutParams)localaspx.b.getLayoutParams()).rightMargin = 0;
                          }
                          for (;;)
                          {
                            for (;;)
                            {
                              if ((paramView.tipParam == null) || (paramView.tipParam.a == null)) {
                                break label2587;
                              }
                              long l1 = paramView.uniseq;
                              long l2 = localaspx.jdField_a_of_type_Int;
                              if (QLog.isColorLevel()) {
                                QLog.d("ChatItemBuilder", 2, new Object[] { "revoke msg grayTipItemBuilder msg uinseq=", Long.valueOf(l1), ",holder.mPosition=", Long.valueOf(l2) });
                              }
                              paramaepm = paramView.tipParam.a;
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
                                      break label2554;
                                    }
                                    LpReportInfo_dc03950.report(new LpReportInfo_dc03950("16", "8", "1"));
                                    atwh.a("6", "1", "1", LpReportInfo_dc03950.getReportUserType(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
                                  }
                                  this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramView.uniseq), Boolean.valueOf(false));
                                  bool1 = bool2;
                                }
                              }
                              paramLinearLayout = paramView.getHightlightMsgText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLinearLayout.getContext(), bool1, localaspx.b);
                              localaspx.b.setText(paramLinearLayout);
                              localaspx.b.setClickable(true);
                              localaspx.b.setFocusable(true);
                              localaspx.b.setMovementMethod(benv.a());
                              if (AppSetting.c) {
                                localaspx.b.setAccessibilityDelegate(new aspw(this, l1, l2, paramaepm, paramLinearLayout));
                              }
                              localaspx.b.setOnTouchListener(paramaetk);
                              localaspx.b.setOnLongClickListener(paramaetk);
                              if (!TextUtils.isEmpty(paramView.contentDescription)) {
                                localaspx.b.setContentDescription(paramView.contentDescription);
                              }
                              paramLinearLayout = localaspx.b.getLayoutParams();
                              if ((paramView == null) || (paramView.tipParam == null) || (paramView.tipParam.b != 3276801)) {
                                break label2629;
                              }
                              paramaetk = this.jdField_a_of_type_AndroidContentContext.getResources();
                              if (Build.VERSION.SDK_INT < 21) {
                                break label2617;
                              }
                              paramaepm = paramaetk.getDrawable(2130849945, this.jdField_a_of_type_AndroidContentContext.getTheme());
                              if (paramaepm != null) {
                                paramaepm.setBounds(0, 0, paramaepm.getIntrinsicWidth(), paramaepm.getIntrinsicHeight());
                              }
                              localaspx.b.setCompoundDrawables(paramaepm, null, null, null);
                              localaspx.b.setCompoundDrawablePadding(aepi.a(8.0F, paramaetk));
                              if ((paramLinearLayout instanceof LinearLayout.LayoutParams)) {
                                ((LinearLayout.LayoutParams)paramLinearLayout).gravity = 16;
                              }
                              if ((localObject1 instanceof StickerGrayTipLayout)) {
                                ((StickerGrayTipLayout)localObject1).setGravity(16);
                              }
                              if (AudioHelper.d()) {
                                QLog.w("ChatItemBuilder", 1, "TencentDocGrayTips, msg[" + paramView.msg + "], getText[" + localaspx.b.getText() + "], getLayoutParams[" + ((LinearLayout.LayoutParams)localaspx.b.getLayoutParams()).gravity + "], gravity[" + ((LinearLayout.LayoutParams)paramLinearLayout).gravity + "]");
                              }
                              a(paramView);
                              a((ChatMessage)paramMessageRecord, localaspx, (View)localObject1);
                              return localObject1;
                              localNumberFormatException1 = localNumberFormatException1;
                              i = j;
                              if (!QLog.isColorLevel()) {
                                break;
                              }
                              QLog.d("ChatItemBuilder", 2, "NumberFormatException: " + paramaepm.mMsgActionData);
                              i = j;
                              break;
                              label2343:
                              i = auaa.c;
                              break label1041;
                              label2351:
                              paramaepm = (MessageForGrayTips.HightlightItem)paramView.tipParam.a.get(paramView.tipParam.a.size() - 1);
                              i = j;
                              if (paramaepm == null) {
                                break label1041;
                              }
                              i = j;
                              if (paramaepm.actionType != 38) {
                                break label1041;
                              }
                              try
                              {
                                i = Integer.parseInt(paramaepm.mMsgActionData);
                              }
                              catch (NumberFormatException localNumberFormatException2)
                              {
                                i = j;
                              }
                            }
                            if (!QLog.isColorLevel()) {
                              break label1041;
                            }
                            QLog.d("ChatItemBuilder", 2, "NumberFormatException: " + paramaepm.mMsgActionData);
                            i = j;
                            break label1041;
                            label2458:
                            paramaepm = null;
                            break label1471;
                            localaspx.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setVisibility(8);
                            paramaepm = localaspx.b.getLayoutParams();
                            if ((paramaepm instanceof ViewGroup.MarginLayoutParams))
                            {
                              paramaepm = (ViewGroup.MarginLayoutParams)paramaepm;
                              if (paramaepm.rightMargin != BaseChatItemLayout.x) {
                                paramaepm.rightMargin = BaseChatItemLayout.x;
                              }
                            }
                            localaspx.b.setMaxWidth(2147483647);
                            localaspx.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setOnClickListener(null);
                          }
                        }
                        catch (RuntimeException paramaepm)
                        {
                          for (;;)
                          {
                            label2587:
                            label2617:
                            label2629:
                            if (QLog.isColorLevel())
                            {
                              QLog.d("ChatItemBuilder", 2, "deal revoke tips fail", paramaepm);
                              continue;
                              label2554:
                              if (localNumberFormatException2.equals("6"))
                              {
                                LpReportInfo_dc03950.report(new LpReportInfo_dc03950("16", "7", "1"));
                                continue;
                                localaspx.b.setText(paramView.msg);
                                if (AppSetting.c)
                                {
                                  localaspx.b.setAccessibilityDelegate(null);
                                  continue;
                                  paramaepm = paramaetk.getDrawable(2130849945);
                                  continue;
                                  localaspx.b.setCompoundDrawables(null, null, null, null);
                                  localaspx.b.setCompoundDrawablePadding(0);
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
                    paramaepm = null;
                    continue;
                    label2697:
                    paramView = "";
                    paramaepm = null;
                  }
                }
                label2705:
                i = n;
                int n = j;
                j = i;
                i = n;
                continue;
                label2724:
                n = j;
                j = i;
                i = n;
              }
              label2739:
              paramaepm = null;
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
      paramView = (aspx)paramView.getTag();
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
    bcpx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForUniteGrayTip);
  }
  
  public bdpk[] a(View paramView)
  {
    return new bdpi().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aspt
 * JD-Core Version:    0.7.0.1
 */