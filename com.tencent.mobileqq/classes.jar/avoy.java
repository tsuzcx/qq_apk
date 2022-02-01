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

public class avoy
  extends agem
{
  private SparseBooleanArray jdField_a_of_type_AndroidUtilSparseBooleanArray = new SparseBooleanArray(5);
  private HashMap<Long, Boolean> jdField_a_of_type_JavaUtilHashMap = new HashMap(10);
  private ConcurrentHashMap<Long, Boolean> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(5);
  
  public avoy(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  public static void a(ChatMessage paramChatMessage, agen paramagen, View paramView)
  {
    if ((paramagen != null) && (paramView != null) && (paramChatMessage == null)) {}
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
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A613", "0X800A613", 0, 0, i + "", "", "", "");
      aean.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
      i = 2;
      continue;
      if (((MessageForUniteGrayTip)localObject).istroop == 1)
      {
        bool1 = bguq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.frienduin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
        bool2 = bguq.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.frienduin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
        str1 = ((MessageForUniteGrayTip)localObject).tipParam.c;
        str2 = anzj.a(2131714681) + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131697031);
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
        bool1 = ((MessageForUniteGrayTip)localObject).tipParam.c.equals(anzj.a(2131714680) + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131693868));
        if (!bool1) {
          i = 11;
        } else {
          i = 12;
        }
      }
    }
  }
  
  protected agen a()
  {
    return new avpc(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, agen paramagen, View paramView, LinearLayout paramLinearLayout, agjk paramagjk)
  {
    if (!(paramagen instanceof avpc)) {
      QLog.e("ChatItemBuilder", 1, "diffclashh =" + paramagen.getClass());
    }
    avpc localavpc = (avpc)paramagen;
    if (paramView == null)
    {
      paramagen = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558887, null);
      localavpc.b = ((TextView)paramagen.findViewById(2131367669));
      localavpc.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView = ((AutoBgImageView)paramagen.findViewById(2131376611));
      paramView = localavpc.b.getLayoutParams();
      localObject1 = paramagen;
      if ((paramView instanceof ViewGroup.MarginLayoutParams))
      {
        paramView = (ViewGroup.MarginLayoutParams)paramView;
        localObject1 = paramagen;
        if (paramView.rightMargin != BaseChatItemLayout.y) {
          paramView.rightMargin = BaseChatItemLayout.y;
        }
      }
    }
    for (Object localObject1 = paramagen;; localObject1 = paramView)
    {
      localavpc.b.setLineSpacing(0.0F, 1.0F);
      localavpc.b.setIncludeFontPadding(true);
      localavpc.b.setMovementMethod(null);
      localavpc.b.setTextColor(((View)localObject1).getResources().getColorStateList(2131167274));
      localavpc.b.setGravity(19);
      localavpc.b.setBackgroundResource(0);
      Object localObject2;
      int i1;
      axfj localaxfj;
      List localList;
      int i;
      int j;
      int k;
      if ((localObject1 instanceof StickerGrayTipLayout))
      {
        bhsq.a(null, "AIO_Handle_Sticker_Cost");
        localObject2 = (StickerGrayTipLayout)localObject1;
        ((StickerGrayTipLayout)localObject2).a();
        paramagen = EmojiStickerManager.a().a(paramMessageRecord);
        i1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels;
        if ((paramagen != null) && (paramagen.size() > 0))
        {
          localaxfj = (axfj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14);
          localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramagen);
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
              paramagen = localaxfj.a(((MessageForMarketFace)paramView).mMarkFaceMessage);
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
                  break label3015;
                }
                i = -i;
                j = 0;
              }
              for (;;)
              {
                label506:
                float f = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
                if ((paramagen instanceof asre))
                {
                  paramView = (asre)paramagen;
                  if (paramView.a == null) {
                    break label2988;
                  }
                  if ((!EmojiStickerManager.jdField_f_of_type_Boolean) && (bhmi.a() > 1.048576E+008F))
                  {
                    n = 1;
                    label559:
                    if (n == 0) {
                      break label701;
                    }
                    paramagen = paramView.a("fromAIO", true, false, null, i3, i3);
                    label579:
                    paramView = paramView.a.epId;
                  }
                }
                for (;;)
                {
                  if (paramagen != null) {
                    ((StickerGrayTipLayout)localObject2).a(paramagen, i2, j, i3, i4, i5, paramView);
                  }
                  j = i;
                  i = m;
                  break;
                  if (!(paramView instanceof MessageForText)) {
                    break label3030;
                  }
                  paramagen = (MessageForText)paramView;
                  if (TextUtils.isEmpty(paramagen.msg)) {
                    break label3030;
                  }
                  paramagen = EmojiStickerManager.a().a(paramagen.msg);
                  break label424;
                  n = j + i;
                  if (n >= 0) {
                    break label2996;
                  }
                  n = -i;
                  i = -i;
                  ((StickerGrayTipLayout)localObject2).a(n - j);
                  j = 0;
                  break label506;
                  n = 0;
                  break label559;
                  label701:
                  paramagen = paramView.a(this.jdField_a_of_type_AndroidContentContext, f);
                  break label579;
                  if ((paramagen instanceof assj))
                  {
                    paramagen = ((assj)paramagen).b(this.jdField_a_of_type_AndroidContentContext, f);
                    paramView = "";
                  }
                  else if ((paramagen instanceof asrv))
                  {
                    paramagen = ((asrv)paramagen).b(this.jdField_a_of_type_AndroidContentContext, f);
                    paramView = "";
                  }
                  else
                  {
                    if ((paramView instanceof MessageForPic))
                    {
                      paramagen = ahng.a(this.jdField_a_of_type_AndroidContentContext, (MessageForPic)paramView);
                      ThreadManager.post(new UniteGrayTipItemBuilder.1(this, paramView), 5, null, true);
                      paramView = "";
                      continue;
                      ((StickerGrayTipLayout)localObject1).a = new avoz(this);
                      bhsq.a("AIO_Handle_Sticker_Cost", null);
                      if (!(paramMessageRecord instanceof MessageForUniteGrayTip))
                      {
                        localavpc.b.setText(paramMessageRecord.msg);
                        return localObject1;
                      }
                      paramView = (MessageForUniteGrayTip)paramMessageRecord;
                      if (!agej.h) {
                        avpe.a(paramView, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                      }
                      if ((paramView.tipParam != null) && (paramView.tipParam.b == 655381))
                      {
                        paramagen = (MessageForGrayTips.HightlightItem)paramView.tipParam.a.get(paramView.tipParam.a.size() - 1);
                        if ((paramagen != null) && (paramagen.actionType == 38)) {
                          j = 0;
                        }
                      }
                      try
                      {
                        i = Integer.parseInt(paramagen.mMsgActionData);
                        if (this.jdField_a_of_type_AndroidUtilSparseBooleanArray.get(i, true))
                        {
                          bdll.b(null, "dc00898", "", "", "0X8009979", "0X8009979", i, i, "", "", "", "");
                          this.jdField_a_of_type_AndroidUtilSparseBooleanArray.put(i, false);
                        }
                        if ((paramView.tipParam != null) && (paramView.tipParam.b == 655383))
                        {
                          j = 0;
                          if (paramView.tipParam.a != null) {
                            break label2594;
                          }
                          if (paramMessageRecord.istroop != 0) {
                            break label2586;
                          }
                          i = axab.b;
                          label1041:
                          if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramView.uniseq)))
                          {
                            if (QLog.isColorLevel()) {
                              QLog.d("ChatItemBuilder", 2, "Temp Report mark: grayTipsOnShow " + paramView.uniseq);
                            }
                            bdll.b(null, "dc00898", "", "", "0X8009ACF", "0X8009ACF", i, i, "", "", "", "");
                            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramView.uniseq), Boolean.valueOf(false));
                          }
                        }
                        if ((paramView.tipParam != null) && (paramView.tipParam.b == 655397))
                        {
                          avpe.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView);
                          paramagen = paramView.getExtInfoFromExtStr("unite_gray_tips_align");
                          if ((!TextUtils.isEmpty(paramagen)) && (paramagen.equals("center"))) {
                            localavpc.b.setGravity(17);
                          }
                          localavpc.b.setLineSpacing(8.0F, 1.0F);
                          if ((!"null".equals(((ChatBackgroundManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(63)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) || ((!ThemeUtil.isDefaultTheme()) && (!ThemeUtil.isNowThemeIsNight(null, false, null)) && (!ThemeUtil.isNowThemeIsSimple(null, false, null))))
                          {
                            localavpc.b.setTextColor(((View)localObject1).getResources().getColorStateList(2131167183));
                            localavpc.b.setBackgroundResource(2130850747);
                          }
                          paramagen = paramView.getExtInfoFromExtStr("uint64_busi_id");
                          if (("1008".equals(paramagen)) && (!paramView.docTipHasReport))
                          {
                            paramView.docTipHasReport = true;
                            bdll.b(null, "dc00898", "", "", "0X800A638", "0X800A638", paramView.istroop, 0, "", "", "", "");
                          }
                          if ((Long.valueOf(paramagen).equals(Long.valueOf(1021L))) && (!paramView.dkTipHasReport))
                          {
                            paramView.dkTipHasReport = true;
                            bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AD82", "0X800AD82", 0, 0, "", "", "", "");
                          }
                          if ((Long.valueOf(paramagen).equals(Long.valueOf(1038L))) && (!paramView.troopMemberLevelTipHasReport))
                          {
                            paramView.troopMemberLevelTipHasReport = true;
                            paramagen = paramView.getExtInfoFromExtStr("uint64_templ_id");
                            if (!TextUtils.isEmpty(paramagen))
                            {
                              if (!Long.valueOf(paramagen).equals(Long.valueOf(1111L))) {
                                break label2701;
                              }
                              bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B1A2", "0X800B1A2", 0, 0, "", "", "", "");
                            }
                          }
                          label1504:
                          l1 = Long.parseLong(paramMessageRecord.getExtInfoFromExtStr("uint64_busi_type"));
                          l2 = Long.parseLong(paramMessageRecord.getExtInfoFromExtStr("uint64_busi_id"));
                          if ((l1 == 2L) && (l2 == 1024L) && (paramView.tipParam.a != null))
                          {
                            paramagen = (MessageForGrayTips.HightlightItem)paramView.tipParam.a.get(0);
                            if (paramagen != null) {
                              paramagen.actionType = 55;
                            }
                          }
                        }
                        if ((paramView.tipParam != null) && (paramView.tipParam.b == 131090) && (!paramView.troopEssenceMsgHasReport))
                        {
                          paramView.troopEssenceMsgHasReport = true;
                          bfuv.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView.frienduin);
                        }
                        if ((((MessageForUniteGrayTip)paramMessageRecord).editState == 1) && ((paramView.tipParam == null) || ((paramView.tipParam != null) && (paramView.tipParam.a == null))) && (QLog.isColorLevel()))
                        {
                          localObject2 = paramView.tipParam;
                          if (paramView.tipParam != null)
                          {
                            paramagen = paramView.tipParam.a;
                            label1686:
                            QLog.d("ChatItemBuilder", 2, new Object[] { "revoke msg grayTipItemBuilder edit param error grayMsg.tipParam = ", localObject2, " hightLightItems=", paramagen });
                          }
                        }
                        else if ((paramView.tipParam != null) && (paramView.tipParam.b == 2))
                        {
                          localavpc.b.setGravity(17);
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
                            paramagen = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130849579);
                            localavpc.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setImageDrawable(paramagen);
                            localavpc.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131691320));
                            localavpc.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setVisibility(0);
                            localavpc.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setOnClickListener(new avpa(this, localavpc));
                            localavpc.b.setMaxWidth(bhtq.a() - bhtq.b(31.0F));
                            ((ViewGroup.MarginLayoutParams)localavpc.b.getLayoutParams()).rightMargin = 0;
                          }
                          for (;;)
                          {
                            for (;;)
                            {
                              if ((paramView.tipParam == null) || (paramView.tipParam.a == null)) {
                                break label2878;
                              }
                              l1 = paramView.uniseq;
                              l2 = localavpc.jdField_a_of_type_Int;
                              if (QLog.isColorLevel()) {
                                QLog.d("ChatItemBuilder", 2, new Object[] { "revoke msg grayTipItemBuilder msg uinseq=", Long.valueOf(l1), ",holder.mPosition=", Long.valueOf(l2) });
                              }
                              paramagen = paramView.tipParam.a;
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
                                      break label2845;
                                    }
                                    LpReportInfo_dc03950.report(new LpReportInfo_dc03950("16", "8", "1"));
                                    awwi.a("6", "1", "1", LpReportInfo_dc03950.getReportUserType(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
                                  }
                                  this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramView.uniseq), Boolean.valueOf(false));
                                  bool1 = bool2;
                                }
                              }
                              paramLinearLayout = paramView.getHightlightMsgText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLinearLayout.getContext(), bool1, localavpc.b);
                              localavpc.b.setText(paramLinearLayout);
                              localavpc.b.setClickable(true);
                              localavpc.b.setFocusable(true);
                              localavpc.b.setMovementMethod(bivu.a());
                              if (AppSetting.c) {
                                localavpc.b.setAccessibilityDelegate(new avpb(this, l1, l2, paramagen, paramLinearLayout));
                              }
                              localavpc.b.setOnTouchListener(paramagjk);
                              localavpc.b.setOnLongClickListener(paramagjk);
                              if (!TextUtils.isEmpty(paramView.contentDescription)) {
                                localavpc.b.setContentDescription(paramView.contentDescription);
                              }
                              paramLinearLayout = localavpc.b.getLayoutParams();
                              if ((paramView == null) || (paramView.tipParam == null) || (paramView.tipParam.b != 3276801)) {
                                break label2920;
                              }
                              paramagjk = this.jdField_a_of_type_AndroidContentContext.getResources();
                              if (Build.VERSION.SDK_INT < 21) {
                                break label2908;
                              }
                              paramagen = paramagjk.getDrawable(2130850550, this.jdField_a_of_type_AndroidContentContext.getTheme());
                              if (paramagen != null) {
                                paramagen.setBounds(0, 0, paramagen.getIntrinsicWidth(), paramagen.getIntrinsicHeight());
                              }
                              localavpc.b.setCompoundDrawables(paramagen, null, null, null);
                              localavpc.b.setCompoundDrawablePadding(agej.a(8.0F, paramagjk));
                              if ((paramLinearLayout instanceof LinearLayout.LayoutParams)) {
                                ((LinearLayout.LayoutParams)paramLinearLayout).gravity = 16;
                              }
                              if ((localObject1 instanceof StickerGrayTipLayout)) {
                                ((StickerGrayTipLayout)localObject1).setGravity(16);
                              }
                              if (AudioHelper.e()) {
                                QLog.w("ChatItemBuilder", 1, "TencentDocGrayTips, msg[" + paramView.msg + "], getText[" + localavpc.b.getText() + "], getLayoutParams[" + ((LinearLayout.LayoutParams)localavpc.b.getLayoutParams()).gravity + "], gravity[" + ((LinearLayout.LayoutParams)paramLinearLayout).gravity + "]");
                              }
                              a(paramView);
                              a((ChatMessage)paramMessageRecord, localavpc, (View)localObject1);
                              return localObject1;
                              localNumberFormatException1 = localNumberFormatException1;
                              i = j;
                              if (!QLog.isColorLevel()) {
                                break;
                              }
                              QLog.d("ChatItemBuilder", 2, "NumberFormatException: " + paramagen.mMsgActionData);
                              i = j;
                              break;
                              label2586:
                              i = axab.c;
                              break label1041;
                              label2594:
                              paramagen = (MessageForGrayTips.HightlightItem)paramView.tipParam.a.get(paramView.tipParam.a.size() - 1);
                              i = j;
                              if (paramagen == null) {
                                break label1041;
                              }
                              i = j;
                              if (paramagen.actionType != 38) {
                                break label1041;
                              }
                              try
                              {
                                i = Integer.parseInt(paramagen.mMsgActionData);
                              }
                              catch (NumberFormatException localNumberFormatException2)
                              {
                                i = j;
                              }
                            }
                            if (!QLog.isColorLevel()) {
                              break label1041;
                            }
                            QLog.d("ChatItemBuilder", 2, "NumberFormatException: " + paramagen.mMsgActionData);
                            i = j;
                            break label1041;
                            label2701:
                            if (!Long.valueOf(paramagen).equals(Long.valueOf(1112L))) {
                              break label1504;
                            }
                            bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B1A4", "0X800AD82", 0, 0, "", "", "", "");
                            break label1504;
                            paramagen = null;
                            break label1686;
                            localavpc.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setVisibility(8);
                            paramagen = localavpc.b.getLayoutParams();
                            if ((paramagen instanceof ViewGroup.MarginLayoutParams))
                            {
                              paramagen = (ViewGroup.MarginLayoutParams)paramagen;
                              if (paramagen.rightMargin != BaseChatItemLayout.y) {
                                paramagen.rightMargin = BaseChatItemLayout.y;
                              }
                            }
                            localavpc.b.setMaxWidth(2147483647);
                            localavpc.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setOnClickListener(null);
                          }
                        }
                        catch (RuntimeException paramagen)
                        {
                          for (;;)
                          {
                            if (QLog.isColorLevel())
                            {
                              QLog.d("ChatItemBuilder", 2, "deal revoke tips fail", paramagen);
                              continue;
                              label2845:
                              if (localNumberFormatException2.equals("6"))
                              {
                                LpReportInfo_dc03950.report(new LpReportInfo_dc03950("16", "7", "1"));
                                continue;
                                label2878:
                                localavpc.b.setText(paramView.msg);
                                if (AppSetting.c)
                                {
                                  localavpc.b.setAccessibilityDelegate(null);
                                  continue;
                                  label2908:
                                  paramagen = paramagjk.getDrawable(2130850550);
                                  continue;
                                  label2920:
                                  localavpc.b.setCompoundDrawables(null, null, null, null);
                                  localavpc.b.setCompoundDrawablePadding(0);
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
                    paramagen = null;
                    continue;
                    label2988:
                    paramView = "";
                    paramagen = null;
                  }
                }
                label2996:
                i = n;
                int n = j;
                j = i;
                i = n;
                continue;
                label3015:
                n = j;
                j = i;
                i = n;
              }
              label3030:
              paramagen = null;
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
      paramView = (avpc)paramView.getTag();
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
      do
      {
        return;
      } while (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(paramMessageForUniteGrayTip.msgseq)));
      this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramMessageForUniteGrayTip.msgseq), Boolean.valueOf(true));
      bguq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForUniteGrayTip);
      return;
    } while (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(paramMessageForUniteGrayTip.shmsgseq)));
    this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramMessageForUniteGrayTip.shmsgseq), Boolean.valueOf(true));
    avot.b(paramMessageForUniteGrayTip.istroop);
  }
  
  public bhum[] a(View paramView)
  {
    return new bhuk().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avoy
 * JD-Core Version:    0.7.0.1
 */