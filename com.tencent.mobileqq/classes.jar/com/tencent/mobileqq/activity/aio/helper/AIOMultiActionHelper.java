package com.tencent.mobileqq.activity.aio.helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.EmoticonDetailJsonDownloaderVars;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.emoticon.EmojiListenerManager;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.emoticon.EmotionJsonDownloadListener;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msgforward.AIOShareActionSheet;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.pic.PicUiInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgManager;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceReportUtil;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import java.text.SimpleDateFormat;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class AIOMultiActionHelper
  implements View.OnClickListener, ILifeCycleHelper
{
  protected View a;
  protected ImageView a;
  protected LinearLayout a;
  private final SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private final BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private final BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  protected ImageView b;
  protected ImageView c;
  protected ImageView d;
  protected ImageView e;
  
  public AIOMultiActionHelper(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseChatPie.a();
    this.jdField_a_of_type_MqqOsMqqHandler = paramBaseChatPie.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramBaseChatPie.a();
  }
  
  private void a(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    this.jdField_a_of_type_AndroidWidgetImageView.setId(2131364684);
    Object localObject = new LinearLayout.LayoutParams(paramInt1, paramInt1);
    ((LinearLayout.LayoutParams)localObject).gravity = 16;
    if (paramInt2 == 1) {
      ((LinearLayout.LayoutParams)localObject).setMargins(paramInt3, 0, 0, 0);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      if (AppSetting.d) {
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131701043));
      }
      localObject = new StateListDrawable();
      Drawable localDrawable = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839481);
      ((StateListDrawable)localObject).addState(new int[] { 16842919 }, localDrawable);
      localDrawable = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839482);
      ((StateListDrawable)localObject).addState(new int[] { 16842910 }, localDrawable);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView);
      if (paramBoolean1) {
        b(paramInt1, paramInt3);
      }
      if (paramBoolean3) {
        a(paramInt1, paramInt3);
      }
      ((MultiFavoriteHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(11)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, this.jdField_a_of_type_AndroidWidgetLinearLayout, paramBoolean4, paramInt1, paramInt1, paramInt3, paramInt4);
      if (paramBoolean5) {
        e(paramInt1, paramInt3);
      }
      if (paramBoolean6) {
        d(paramInt1, paramInt3);
      }
      if (paramBoolean2) {
        c(paramInt1, paramInt3);
      }
      return;
      ((LinearLayout.LayoutParams)localObject).setMargins(0, 0, 0, 0);
    }
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    this.d = new ImageView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    this.d.setId(2131364689);
    if (AppSetting.d) {
      this.d.setContentDescription(HardCodeUtil.a(2131701068));
    }
    Object localObject = new LinearLayout.LayoutParams(paramInt1, paramInt1);
    ((LinearLayout.LayoutParams)localObject).setMargins(paramInt2, 0, 0, 0);
    ((LinearLayout.LayoutParams)localObject).gravity = 16;
    this.d.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.d.setOnClickListener(this);
    localObject = new StateListDrawable();
    Drawable localDrawable = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839443);
    ((StateListDrawable)localObject).addState(new int[] { 16842919 }, localDrawable);
    localDrawable = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839443);
    ((StateListDrawable)localObject).addState(new int[0], localDrawable);
    this.d.setImageDrawable((Drawable)localObject);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.d);
  }
  
  private void d()
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80067F6", "0X80067F6", 0, 0, "", "", "", "");
    if (!NetworkUtil.d(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131692257, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a());
      return;
    }
    Object localObject3 = MultiMsgManager.a().a();
    if (((List)localObject3).size() == 0)
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131698457, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a());
      return;
    }
    Object localObject2 = null;
    int i = 0;
    Object localObject1;
    for (;;)
    {
      localObject1 = localObject2;
      if (i < ((List)localObject3).size())
      {
        localObject1 = (ChatMessage)((List)localObject3).get(i);
        if ((!(localObject1 instanceof MessageForMarketFace)) && (!(localObject1 instanceof MessageForPic))) {}
      }
      else
      {
        if (localObject1 != null) {
          break;
        }
        QLog.e("Q.aio.BaseChatPie.AIOMultiActionHelper", 1, "add to custom face, no market face message or pic message selected");
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131698457, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a());
        return;
      }
      i += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie.AIOMultiActionHelper", 1, "add to custom face, selected message=" + localObject1);
    }
    if ((localObject1 instanceof MessageForPic))
    {
      localObject1 = (MessageForPic)localObject1;
      localObject2 = URLDrawableHelper.getDrawable(URLDrawableHelper.getURL((PicUiInterface)localObject1, 1), -1, -1, null, null, false);
      ((URLDrawable)localObject2).setTag(localObject1);
      AIOGalleryUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (URLDrawable)localObject2, ((MessageForPic)localObject1).frienduin, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDimensionPixelSize(2131299166), null, null);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006448", "0X8006448", 0, 0, "3", "", "", "");
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(false, null, false);
      return;
      if ((localObject1 instanceof MessageForMarketFace))
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006448", "0X8006448", 0, 0, "4", "", "", "");
        localObject3 = (MessageForMarketFace)localObject1;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131692006));
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
        }
        localObject2 = ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER)).a(((MessageForMarketFace)localObject3).mMarkFaceMessage);
        EmoticonPackage localEmoticonPackage = ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER)).a(((PicEmoticonInfo)localObject2).emoticon.epId);
        MarketFaceItemBuilder.jdField_a_of_type_ComTencentMobileqqDataChatMessage = (ChatMessage)localObject3;
        MarketFaceItemBuilder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo = (PicEmoticonInfo)localObject2;
        if ((localEmoticonPackage != null) && (localEmoticonPackage.name != null) && ((localEmoticonPackage.mobileFeetype != 0) || (localEmoticonPackage.downloadCount != 0)))
        {
          i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getInt("emosm_json_last_download_timestamp", 0);
          int j = (int)(System.currentTimeMillis() / 1000L);
          if ((j - i > 86400) || (j < i))
          {
            localObject3 = new MarketFaceItemBuilder.EmoticonDetailJsonDownloaderVars();
            ((MarketFaceItemBuilder.EmoticonDetailJsonDownloaderVars)localObject3).a(6, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (PicEmoticonInfo)localObject2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (QQProgressDialog)localObject1);
            EmojiListenerManager.a().a((EmotionJsonDownloadListener)localObject3);
            ((EmojiManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CHAT_EMOTION_MANAGER)).a(((PicEmoticonInfo)localObject2).emoticon.epId, EmojiManager.c);
          }
          else
          {
            MarketFaceItemBuilder.a(6, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localEmoticonPackage, (PicEmoticonInfo)localObject2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (QQProgressDialog)localObject1);
          }
        }
        else
        {
          localObject3 = new MarketFaceItemBuilder.EmoticonDetailJsonDownloaderVars();
          ((MarketFaceItemBuilder.EmoticonDetailJsonDownloaderVars)localObject3).a(6, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (PicEmoticonInfo)localObject2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (QQProgressDialog)localObject1);
          EmojiListenerManager.a().a((EmotionJsonDownloadListener)localObject3);
          ((EmojiManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CHAT_EMOTION_MANAGER)).a(((PicEmoticonInfo)localObject2).emoticon.epId, EmojiManager.c);
        }
      }
    }
  }
  
  private void d(int paramInt1, int paramInt2)
  {
    this.e = new ImageView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    this.e.setId(2131364685);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(paramInt1, paramInt1);
    localLayoutParams.gravity = 16;
    localLayoutParams.setMargins(paramInt2, 0, 0, 0);
    this.e.setLayoutParams(localLayoutParams);
    this.e.setOnClickListener(this);
    this.e.setContentDescription(HardCodeUtil.a(2131720112));
    this.e.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839498));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.e);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)
    {
      TroopEssenceReportUtil.i(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      TroopEssenceReportUtil.j(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
  }
  
  private void e()
  {
    int i = MultiMsgManager.a().c();
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80059B6", "0X80059B6", 0, 0, "", "", "", "");
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", AIOShareActionSheet.c, AIOShareActionSheet.c, 0, i, "", "", "", "");
    if ((ChatActivityFacade.b != null) && (ChatActivityFacade.b.isShowing())) {}
    do
    {
      return;
      localObject = MultiMsgManager.a().a();
      if (((List)localObject).size() != 0) {
        break;
      }
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131698457, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a());
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80059B7", "0X80059B7", 0, 0, "0", "", "", "");
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1008);
    Object localObject = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(NetConnInfoCenter.getServerTimeMillis()));
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X80064F9", "0X80064F9", 0, 0, (String)localObject, "1", "", "");
    return;
    MultiMsgManager.a().b((List)localObject);
    if (QLog.isDevelopLevel()) {
      QLog.d("MultiMsg_TAG", 4, "checklist.size = " + ((List)localObject).size());
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80059B7", "0X80059B7", 0, 0, "" + ((List)localObject).size(), "", "", "");
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008)
    {
      String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(NetConnInfoCenter.getServerTimeMillis()));
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X80064F9", "0X80064F9", 0, 0, str, "0", "", "");
    }
    ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (List)localObject);
  }
  
  private void e(int paramInt1, int paramInt2)
  {
    ImageView localImageView = new ImageView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    localImageView.setId(2131364688);
    Object localObject = new LinearLayout.LayoutParams(paramInt1, paramInt1);
    ((LinearLayout.LayoutParams)localObject).gravity = 16;
    ((LinearLayout.LayoutParams)localObject).setMargins(paramInt2, 0, 0, 0);
    localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localImageView.setOnClickListener(this);
    if (AppSetting.d) {
      localImageView.setContentDescription(HardCodeUtil.a(2131701044));
    }
    localObject = new StateListDrawable();
    Drawable localDrawable = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839563);
    ((StateListDrawable)localObject).addState(new int[] { 16842919 }, localDrawable);
    localDrawable = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839563);
    ((StateListDrawable)localObject).addState(new int[] { 16842910 }, localDrawable);
    localImageView.setImageDrawable((Drawable)localObject);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localImageView);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    }
    AIOLongShotHelper localAIOLongShotHelper = (AIOLongShotHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(15);
    SelectToBottomHelper localSelectToBottomHelper = (SelectToBottomHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(40);
    if (!localAIOLongShotHelper.a()) {
      localSelectToBottomHelper.b();
    }
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setClickable(true);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.as();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.c = new ImageView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    this.c.setId(2131364687);
    if (AppSetting.d) {
      this.c.setContentDescription(HardCodeUtil.a(2131701054));
    }
    Object localObject = new LinearLayout.LayoutParams(paramInt1, paramInt1);
    ((LinearLayout.LayoutParams)localObject).setMargins(paramInt2, 0, 0, 0);
    ((LinearLayout.LayoutParams)localObject).gravity = 16;
    this.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.c.setOnClickListener(this);
    localObject = new StateListDrawable();
    Drawable localDrawable = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839510);
    ((StateListDrawable)localObject).addState(new int[] { 16842919 }, localDrawable);
    localDrawable = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839511);
    ((StateListDrawable)localObject).addState(new int[] { 16842910 }, localDrawable);
    localDrawable = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839510);
    ((StateListDrawable)localObject).addState(new int[0], localDrawable);
    this.c.setImageDrawable((Drawable)localObject);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.c);
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    int i4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDisplayMetrics().widthPixels;
    int i2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getApplicationContext().getResources().getDimensionPixelSize(2131299166) - 5;
    int i3 = ViewUtils.b(28.0F);
    paramChatMessage = (RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().findViewById(2131364598);
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie.AIOMultiActionHelper", 2, "createMulti");
    }
    int i5 = i4 / 37;
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = new View(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      localObject = new RelativeLayout.LayoutParams(-1, i2);
      ((RelativeLayout.LayoutParams)localObject).addRule(12);
      this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_AndroidViewView.setFocusableInTouchMode(true);
      this.jdField_a_of_type_AndroidViewView.setFocusable(true);
      this.jdField_a_of_type_AndroidViewView.setContentDescription("");
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008) {
        this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      }
      paramChatMessage.addView(this.jdField_a_of_type_AndroidViewView);
    }
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(0);
      localObject = new RelativeLayout.LayoutParams(-1, i2);
      ((RelativeLayout.LayoutParams)localObject).addRule(12);
      ((RelativeLayout.LayoutParams)localObject).setMargins(i5, 0, i5, 0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramChatMessage.addView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setId(2131362469);
    Object localObject = (SelectToBottomHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(40);
    ((SelectToBottomHelper)localObject).a(this.jdField_a_of_type_AndroidWidgetLinearLayout, i2, paramChatMessage);
    paramChatMessage = (AIOLongShotHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(15);
    if (paramChatMessage.a())
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.D) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.h("");
      }
      ((SelectToBottomHelper)localObject).a();
      paramChatMessage.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_AndroidWidgetLinearLayout);
      ((UnreadBackBottomHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(53)).b();
      i = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131165639);
      if (paramChatMessage.a()) {
        i = Color.parseColor("#313546");
      }
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(i);
      a();
      return;
    }
    boolean bool1;
    label431:
    boolean bool2;
    label447:
    boolean bool3;
    label463:
    boolean bool4;
    label479:
    boolean bool5;
    label495:
    boolean bool6;
    label526:
    label533:
    int j;
    label540:
    int k;
    label548:
    int m;
    label556:
    int n;
    label564:
    int i1;
    if (AIOUtils.a(1) == 0)
    {
      bool1 = true;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008) {
        break label644;
      }
      bool2 = true;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008) {
        break label650;
      }
      bool3 = true;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008) {
        break label656;
      }
      bool4 = true;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008) {
        break label662;
      }
      bool5 = true;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) || (!TroopEssenceUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
        break label668;
      }
      bool6 = true;
      if (!bool1) {
        break label674;
      }
      i = 1;
      if (!bool3) {
        break label679;
      }
      j = 1;
      if (!bool2) {
        break label684;
      }
      k = 1;
      if (!bool4) {
        break label690;
      }
      m = 1;
      if (!bool5) {
        break label696;
      }
      n = 1;
      if (!bool6) {
        break label702;
      }
      i1 = 1;
      label572:
      j = i + 1 + j + k + m + n + i1;
      if (j != 1) {
        break label708;
      }
    }
    label644:
    label650:
    label656:
    label662:
    label668:
    label674:
    label679:
    label684:
    label690:
    label696:
    label702:
    label708:
    for (int i = (i4 - i5 * 2 - i3) / 2;; i = (i4 - i5 * 2 - i3 * j) / (j - 1))
    {
      a(i3, bool1, bool2, bool3, bool4, bool5, bool6, j, i, i2 * 3 / 20);
      break;
      bool1 = false;
      break label431;
      bool2 = false;
      break label447;
      bool3 = false;
      break label463;
      bool4 = false;
      break label479;
      bool5 = false;
      break label495;
      bool6 = false;
      break label526;
      i = 0;
      break label533;
      j = 0;
      break label540;
      k = 0;
      break label548;
      m = 0;
      break label556;
      n = 0;
      break label564;
      i1 = 0;
      break label572;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.b != null) {
      this.b.setEnabled(paramBoolean);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    ((SelectToBottomHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(40)).a();
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.ar();
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    this.b = new ImageView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    this.b.setId(2131364683);
    Object localObject = new LinearLayout.LayoutParams(paramInt1, paramInt1);
    ((LinearLayout.LayoutParams)localObject).setMargins(paramInt2, 0, 0, 0);
    ((LinearLayout.LayoutParams)localObject).gravity = 16;
    this.b.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.b.setOnClickListener(this);
    if (AppSetting.d) {
      this.b.setContentDescription(HardCodeUtil.a(2131701034));
    }
    localObject = new StateListDrawable();
    Drawable localDrawable = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839499);
    ((StateListDrawable)localObject).addState(new int[] { 16842919 }, localDrawable);
    localDrawable = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839500);
    ((StateListDrawable)localObject).addState(new int[] { 16842910 }, localDrawable);
    localDrawable = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839499);
    ((StateListDrawable)localObject).addState(new int[0], localDrawable);
    this.b.setImageDrawable((Drawable)localObject);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.b);
  }
  
  public void c()
  {
    List localList = MultiMsgManager.a().a();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) || (this.e == null) || (this.e.getVisibility() != 0)) {
      return;
    }
    long l1 = 0L;
    try
    {
      long l2 = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue();
      l1 = l2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
      this.e.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839498));
      this.e.setEnabled(true);
    }
    if (!TroopEssenceUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l1, localList))
    {
      this.e.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839497));
      this.e.setEnabled(false);
      return;
    }
  }
  
  public String getTag()
  {
    return "Q.aio.BaseChatPie.AIOMultiActionHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[0];
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      e();
      continue;
      d();
      continue;
      int i = MultiMsgManager.a().c();
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", AIOShareActionSheet.d, AIOShareActionSheet.d, 0, i, "", "", "", "");
      ((MultiForwardHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(1)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1, false);
      continue;
      Object localObject = AIOLongShotHelper.a();
      if (localObject != null)
      {
        ((AIOLongShotHelper)localObject).a(paramView);
        continue;
        localObject = (TroopEssenceMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_ESSENCE_MSG_MANAGER);
        if ((localObject != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (this.e != null) && (this.e.isEnabled()))
        {
          ((TroopEssenceMsgManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(false, null, false);
          continue;
          ((MultiForwardHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(1)).a();
        }
      }
    }
  }
  
  public void onMoveToState(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIOMultiActionHelper
 * JD-Core Version:    0.7.0.1
 */