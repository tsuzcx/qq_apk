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

public class aslk
  extends aekw
{
  private SparseBooleanArray jdField_a_of_type_AndroidUtilSparseBooleanArray = new SparseBooleanArray(5);
  private HashMap<Long, Boolean> jdField_a_of_type_JavaUtilHashMap = new HashMap(10);
  private ConcurrentHashMap<Long, Boolean> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(5);
  
  public aslk(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  public static void a(ChatMessage paramChatMessage, aekx paramaekx, View paramView)
  {
    if ((paramaekx != null) && (paramView != null) && (paramChatMessage == null)) {}
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
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A613", "0X800A613", 0, 0, i + "", "", "", "");
      acex.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
      i = 2;
      continue;
      if (((MessageForUniteGrayTip)localObject).istroop == 1)
      {
        bool1 = bclo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.frienduin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
        bool2 = bclo.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.frienduin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
        str1 = ((MessageForUniteGrayTip)localObject).tipParam.c;
        str2 = alpo.a(2131716283) + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131698131);
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
        bool1 = ((MessageForUniteGrayTip)localObject).tipParam.c.equals(alpo.a(2131716282) + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131694586));
        if (!bool1) {
          i = 11;
        } else {
          i = 12;
        }
      }
    }
  }
  
  protected aekx a()
  {
    return new aslo(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, aekx paramaekx, View paramView, LinearLayout paramLinearLayout, aeov paramaeov)
  {
    if (!(paramaekx instanceof aslo)) {
      QLog.e("ChatItemBuilder", 1, "diffclashh =" + paramaekx.getClass());
    }
    aslo localaslo = (aslo)paramaekx;
    if (paramView == null)
    {
      paramaekx = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558818, null);
      localaslo.b = ((TextView)paramaekx.findViewById(2131367282));
      localaslo.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView = ((AutoBgImageView)paramaekx.findViewById(2131375701));
      paramView = localaslo.b.getLayoutParams();
      localObject1 = paramaekx;
      if ((paramView instanceof ViewGroup.MarginLayoutParams))
      {
        paramView = (ViewGroup.MarginLayoutParams)paramView;
        localObject1 = paramaekx;
        if (paramView.rightMargin != BaseChatItemLayout.x) {
          paramView.rightMargin = BaseChatItemLayout.x;
        }
      }
    }
    for (Object localObject1 = paramaekx;; localObject1 = paramView)
    {
      localaslo.b.setLineSpacing(0.0F, 1.0F);
      localaslo.b.setIncludeFontPadding(true);
      localaslo.b.setMovementMethod(null);
      localaslo.b.setTextColor(((View)localObject1).getResources().getColorStateList(2131167164));
      localaslo.b.setGravity(19);
      localaslo.b.setBackgroundResource(0);
      Object localObject2;
      int i1;
      aube localaube;
      List localList;
      int i;
      int j;
      int k;
      if ((localObject1 instanceof StickerGrayTipLayout))
      {
        bdjd.a(null, "AIO_Handle_Sticker_Cost");
        localObject2 = (StickerGrayTipLayout)localObject1;
        ((StickerGrayTipLayout)localObject2).a();
        paramaekx = EmojiStickerManager.a().a(paramMessageRecord);
        i1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels;
        if ((paramaekx != null) && (paramaekx.size() > 0))
        {
          localaube = (aube)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14);
          localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramaekx);
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
              paramaekx = localaube.a(((MessageForMarketFace)paramView).mMarkFaceMessage);
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
                if ((paramaekx instanceof aptm))
                {
                  paramView = (aptm)paramaekx;
                  if (paramView.a == null) {
                    break label2697;
                  }
                  if ((!EmojiStickerManager.jdField_f_of_type_Boolean) && (bdcs.a() > 1.048576E+008F))
                  {
                    n = 1;
                    label559:
                    if (n == 0) {
                      break label701;
                    }
                    paramaekx = paramView.a("fromAIO", true, false, null, i3, i3);
                    label579:
                    paramView = paramView.a.epId;
                  }
                }
                for (;;)
                {
                  if (paramaekx != null) {
                    ((StickerGrayTipLayout)localObject2).a(paramaekx, i2, j, i3, i4, i5, paramView);
                  }
                  j = i;
                  i = m;
                  break;
                  if (!(paramView instanceof MessageForText)) {
                    break label2739;
                  }
                  paramaekx = (MessageForText)paramView;
                  if (TextUtils.isEmpty(paramaekx.msg)) {
                    break label2739;
                  }
                  paramaekx = EmojiStickerManager.a().a(paramaekx.msg);
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
                  paramaekx = paramView.a(this.jdField_a_of_type_AndroidContentContext, f);
                  break label579;
                  if ((paramaekx instanceof apur))
                  {
                    paramaekx = ((apur)paramaekx).b(this.jdField_a_of_type_AndroidContentContext, f);
                    paramView = "";
                  }
                  else if ((paramaekx instanceof apud))
                  {
                    paramaekx = ((apud)paramaekx).b(this.jdField_a_of_type_AndroidContentContext, f);
                    paramView = "";
                  }
                  else
                  {
                    if ((paramView instanceof MessageForPic))
                    {
                      paramaekx = afsf.a(this.jdField_a_of_type_AndroidContentContext, (MessageForPic)paramView);
                      ThreadManager.post(new UniteGrayTipItemBuilder.1(this, paramView), 5, null, true);
                      paramView = "";
                      continue;
                      ((StickerGrayTipLayout)localObject1).a = new asll(this);
                      bdjd.a("AIO_Handle_Sticker_Cost", null);
                      if (!(paramMessageRecord instanceof MessageForUniteGrayTip))
                      {
                        localaslo.b.setText(paramMessageRecord.msg);
                        return localObject1;
                      }
                      paramView = (MessageForUniteGrayTip)paramMessageRecord;
                      if (!aekt.h) {
                        aslq.a(paramView, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                      }
                      if ((paramView.tipParam != null) && (paramView.tipParam.b == 655381))
                      {
                        paramaekx = (MessageForGrayTips.HightlightItem)paramView.tipParam.a.get(paramView.tipParam.a.size() - 1);
                        if ((paramaekx != null) && (paramaekx.actionType == 38)) {
                          j = 0;
                        }
                      }
                      try
                      {
                        i = Integer.parseInt(paramaekx.mMsgActionData);
                        if (this.jdField_a_of_type_AndroidUtilSparseBooleanArray.get(i, true))
                        {
                          azmj.b(null, "dc00898", "", "", "0X8009979", "0X8009979", i, i, "", "", "", "");
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
                          i = atvr.b;
                          label1041:
                          if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramView.uniseq)))
                          {
                            if (QLog.isColorLevel()) {
                              QLog.d("ChatItemBuilder", 2, "Temp Report mark: grayTipsOnShow " + paramView.uniseq);
                            }
                            azmj.b(null, "dc00898", "", "", "0X8009ACF", "0X8009ACF", i, i, "", "", "", "");
                            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramView.uniseq), Boolean.valueOf(false));
                          }
                        }
                        if ((paramView.tipParam != null) && (paramView.tipParam.b == 655397))
                        {
                          aslq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView);
                          paramaekx = paramView.getExtInfoFromExtStr("unite_gray_tips_align");
                          if ((!TextUtils.isEmpty(paramaekx)) && (paramaekx.equals("center"))) {
                            localaslo.b.setGravity(17);
                          }
                          localaslo.b.setLineSpacing(8.0F, 1.0F);
                          if ((!"null".equals(((ChatBackgroundManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(63)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) || ((!ThemeUtil.isDefaultTheme()) && (!ThemeUtil.isNowThemeIsNight(null, false, null)) && (!ThemeUtil.isNowThemeIsSimple(null, false, null))))
                          {
                            localaslo.b.setTextColor(((View)localObject1).getResources().getColorStateList(2131167085));
                            localaslo.b.setBackgroundResource(2130850061);
                          }
                          paramaekx = paramView.getExtInfoFromExtStr("uint64_busi_id");
                          if (("1008".equals(paramaekx)) && (!paramView.docTipHasReport))
                          {
                            paramView.docTipHasReport = true;
                            azmj.b(null, "dc00898", "", "", "0X800A638", "0X800A638", paramView.istroop, 0, "", "", "", "");
                          }
                          if (Long.valueOf(paramaekx).equals(Long.valueOf(1021L)))
                          {
                            paramView.dkTipHasReport = true;
                            azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AD82", "0X800AD82", 0, 0, "", "", "", "");
                          }
                        }
                        if ((((MessageForUniteGrayTip)paramMessageRecord).editState == 1) && ((paramView.tipParam == null) || ((paramView.tipParam != null) && (paramView.tipParam.a == null))) && (QLog.isColorLevel()))
                        {
                          localObject2 = paramView.tipParam;
                          if (paramView.tipParam == null) {
                            break label2458;
                          }
                          paramaekx = paramView.tipParam.a;
                          label1471:
                          QLog.d("ChatItemBuilder", 2, new Object[] { "revoke msg grayTipItemBuilder edit param error grayMsg.tipParam = ", localObject2, " hightLightItems=", paramaekx });
                        }
                      }
                      catch (NumberFormatException localNumberFormatException1)
                      {
                        try
                        {
                          if ((paramView.tipParam != null) && (paramView.tipParam.b == 1))
                          {
                            paramaekx = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130848960);
                            localaslo.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setImageDrawable(paramaekx);
                            localaslo.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131691555));
                            localaslo.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setVisibility(0);
                            localaslo.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setOnClickListener(new aslm(this, localaslo));
                            localaslo.b.setMaxWidth(bdkf.a() - bdkf.b(31.0F));
                            ((ViewGroup.MarginLayoutParams)localaslo.b.getLayoutParams()).rightMargin = 0;
                          }
                          for (;;)
                          {
                            for (;;)
                            {
                              if ((paramView.tipParam == null) || (paramView.tipParam.a == null)) {
                                break label2587;
                              }
                              long l1 = paramView.uniseq;
                              long l2 = localaslo.jdField_a_of_type_Int;
                              if (QLog.isColorLevel()) {
                                QLog.d("ChatItemBuilder", 2, new Object[] { "revoke msg grayTipItemBuilder msg uinseq=", Long.valueOf(l1), ",holder.mPosition=", Long.valueOf(l2) });
                              }
                              paramaekx = paramView.tipParam.a;
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
                                    atry.a("6", "1", "1", LpReportInfo_dc03950.getReportUserType(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
                                  }
                                  this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramView.uniseq), Boolean.valueOf(false));
                                  bool1 = bool2;
                                }
                              }
                              paramLinearLayout = paramView.getHightlightMsgText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLinearLayout.getContext(), bool1, localaslo.b);
                              localaslo.b.setText(paramLinearLayout);
                              localaslo.b.setClickable(true);
                              localaslo.b.setFocusable(true);
                              localaslo.b.setMovementMethod(bejm.a());
                              if (AppSetting.c) {
                                localaslo.b.setAccessibilityDelegate(new asln(this, l1, l2, paramaekx, paramLinearLayout));
                              }
                              localaslo.b.setOnTouchListener(paramaeov);
                              localaslo.b.setOnLongClickListener(paramaeov);
                              if (!TextUtils.isEmpty(paramView.contentDescription)) {
                                localaslo.b.setContentDescription(paramView.contentDescription);
                              }
                              paramLinearLayout = localaslo.b.getLayoutParams();
                              if ((paramView == null) || (paramView.tipParam == null) || (paramView.tipParam.b != 3276801)) {
                                break label2629;
                              }
                              paramaeov = this.jdField_a_of_type_AndroidContentContext.getResources();
                              if (Build.VERSION.SDK_INT < 21) {
                                break label2617;
                              }
                              paramaekx = paramaeov.getDrawable(2130849872, this.jdField_a_of_type_AndroidContentContext.getTheme());
                              if (paramaekx != null) {
                                paramaekx.setBounds(0, 0, paramaekx.getIntrinsicWidth(), paramaekx.getIntrinsicHeight());
                              }
                              localaslo.b.setCompoundDrawables(paramaekx, null, null, null);
                              localaslo.b.setCompoundDrawablePadding(aekt.a(8.0F, paramaeov));
                              if ((paramLinearLayout instanceof LinearLayout.LayoutParams)) {
                                ((LinearLayout.LayoutParams)paramLinearLayout).gravity = 16;
                              }
                              if ((localObject1 instanceof StickerGrayTipLayout)) {
                                ((StickerGrayTipLayout)localObject1).setGravity(16);
                              }
                              if (AudioHelper.d()) {
                                QLog.w("ChatItemBuilder", 1, "TencentDocGrayTips, msg[" + paramView.msg + "], getText[" + localaslo.b.getText() + "], getLayoutParams[" + ((LinearLayout.LayoutParams)localaslo.b.getLayoutParams()).gravity + "], gravity[" + ((LinearLayout.LayoutParams)paramLinearLayout).gravity + "]");
                              }
                              a(paramView);
                              a((ChatMessage)paramMessageRecord, localaslo, (View)localObject1);
                              return localObject1;
                              localNumberFormatException1 = localNumberFormatException1;
                              i = j;
                              if (!QLog.isColorLevel()) {
                                break;
                              }
                              QLog.d("ChatItemBuilder", 2, "NumberFormatException: " + paramaekx.mMsgActionData);
                              i = j;
                              break;
                              label2343:
                              i = atvr.c;
                              break label1041;
                              label2351:
                              paramaekx = (MessageForGrayTips.HightlightItem)paramView.tipParam.a.get(paramView.tipParam.a.size() - 1);
                              i = j;
                              if (paramaekx == null) {
                                break label1041;
                              }
                              i = j;
                              if (paramaekx.actionType != 38) {
                                break label1041;
                              }
                              try
                              {
                                i = Integer.parseInt(paramaekx.mMsgActionData);
                              }
                              catch (NumberFormatException localNumberFormatException2)
                              {
                                i = j;
                              }
                            }
                            if (!QLog.isColorLevel()) {
                              break label1041;
                            }
                            QLog.d("ChatItemBuilder", 2, "NumberFormatException: " + paramaekx.mMsgActionData);
                            i = j;
                            break label1041;
                            label2458:
                            paramaekx = null;
                            break label1471;
                            localaslo.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setVisibility(8);
                            paramaekx = localaslo.b.getLayoutParams();
                            if ((paramaekx instanceof ViewGroup.MarginLayoutParams))
                            {
                              paramaekx = (ViewGroup.MarginLayoutParams)paramaekx;
                              if (paramaekx.rightMargin != BaseChatItemLayout.x) {
                                paramaekx.rightMargin = BaseChatItemLayout.x;
                              }
                            }
                            localaslo.b.setMaxWidth(2147483647);
                            localaslo.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setOnClickListener(null);
                          }
                        }
                        catch (RuntimeException paramaekx)
                        {
                          for (;;)
                          {
                            label2587:
                            label2617:
                            label2629:
                            if (QLog.isColorLevel())
                            {
                              QLog.d("ChatItemBuilder", 2, "deal revoke tips fail", paramaekx);
                              continue;
                              label2554:
                              if (localNumberFormatException2.equals("6"))
                              {
                                LpReportInfo_dc03950.report(new LpReportInfo_dc03950("16", "7", "1"));
                                continue;
                                localaslo.b.setText(paramView.msg);
                                if (AppSetting.c)
                                {
                                  localaslo.b.setAccessibilityDelegate(null);
                                  continue;
                                  paramaekx = paramaeov.getDrawable(2130849872);
                                  continue;
                                  localaslo.b.setCompoundDrawables(null, null, null, null);
                                  localaslo.b.setCompoundDrawablePadding(0);
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
                    paramaekx = null;
                    continue;
                    label2697:
                    paramView = "";
                    paramaekx = null;
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
              paramaekx = null;
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
      paramView = (aslo)paramView.getTag();
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
    bclo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForUniteGrayTip);
  }
  
  public bdlb[] a(View paramView)
  {
    return new bdkz().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aslk
 * JD-Core Version:    0.7.0.1
 */