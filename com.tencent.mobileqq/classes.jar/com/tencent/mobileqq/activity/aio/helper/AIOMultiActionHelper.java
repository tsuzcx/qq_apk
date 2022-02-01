package com.tencent.mobileqq.activity.aio.helper;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.EmoticonDetailJsonDownloaderVars;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticon.EmotionJsonDownloadListener;
import com.tencent.mobileqq.emoticon.IEmojiListenerManager;
import com.tencent.mobileqq.emoticon.api.EmojiManagerServiceConstant;
import com.tencent.mobileqq.emoticon.api.IEmojiManagerService;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
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
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import java.text.SimpleDateFormat;
import java.util.List;
import mqq.app.AppRuntime;
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
    this.jdField_a_of_type_AndroidWidgetImageView.setId(2131364571);
    Object localObject = new LinearLayout.LayoutParams(paramInt1, paramInt1);
    ((LinearLayout.LayoutParams)localObject).gravity = 16;
    if (paramInt2 == 1) {
      ((LinearLayout.LayoutParams)localObject).setMargins(paramInt3, 0, 0, 0);
    } else {
      ((LinearLayout.LayoutParams)localObject).setMargins(0, 0, 0, 0);
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    if (AppSetting.d) {
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131701186));
    }
    localObject = new StateListDrawable();
    Drawable localDrawable = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839337);
    ((StateListDrawable)localObject).addState(new int[] { 16842919 }, localDrawable);
    localDrawable = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839338);
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
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    this.d = new ImageView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    this.d.setId(2131364576);
    if (AppSetting.d) {
      this.d.setContentDescription(HardCodeUtil.a(2131701211));
    }
    Object localObject = new LinearLayout.LayoutParams(paramInt1, paramInt1);
    ((LinearLayout.LayoutParams)localObject).setMargins(paramInt2, 0, 0, 0);
    ((LinearLayout.LayoutParams)localObject).gravity = 16;
    this.d.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.d.setOnClickListener(this);
    localObject = new StateListDrawable();
    Drawable localDrawable = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839299);
    ((StateListDrawable)localObject).addState(new int[] { 16842919 }, localDrawable);
    localDrawable = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839299);
    ((StateListDrawable)localObject).addState(new int[0], localDrawable);
    this.d.setImageDrawable((Drawable)localObject);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.d);
  }
  
  private void d()
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80067F6", "0X80067F6", 0, 0, "", "", "", "");
    if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131692183, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a());
      return;
    }
    Object localObject3 = MultiMsgManager.a().a();
    if (((List)localObject3).size() == 0)
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131698523, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a());
      return;
    }
    int i = 0;
    Object localObject2;
    while (i < ((List)localObject3).size())
    {
      localObject2 = (ChatMessage)((List)localObject3).get(i);
      localObject1 = localObject2;
      if ((localObject2 instanceof MessageForMarketFace)) {
        break label165;
      }
      if ((localObject2 instanceof MessageForPic))
      {
        localObject1 = localObject2;
        break label165;
      }
      i += 1;
    }
    Object localObject1 = null;
    label165:
    if (localObject1 == null)
    {
      QLog.e("Q.aio.BaseChatPie.AIOMultiActionHelper", 1, "add to custom face, no market face message or pic message selected");
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131698523, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a());
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("add to custom face, selected message=");
      ((StringBuilder)localObject2).append(localObject1);
      QLog.d("Q.aio.BaseChatPie.AIOMultiActionHelper", 1, ((StringBuilder)localObject2).toString());
    }
    if ((localObject1 instanceof MessageForPic))
    {
      localObject1 = (MessageForPic)localObject1;
      localObject2 = URLDrawableHelper.getDrawable(URLDrawableHelper.getURL((PicUiInterface)localObject1, 1), -1, -1, null, null, false);
      ((URLDrawable)localObject2).setTag(localObject1);
      AIOGalleryUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (URLDrawable)localObject2, ((MessageForPic)localObject1).frienduin, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDimensionPixelSize(2131299168), null, null);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006448", "0X8006448", 0, 0, "3", "", "", "");
    }
    else if ((localObject1 instanceof MessageForMarketFace))
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006448", "0X8006448", 0, 0, "4", "", "", "");
      localObject3 = (MessageForMarketFace)localObject1;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691927));
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      }
      localObject1 = (IPicEmoticonInfo)((IEmoticonManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IEmoticonManagerService.class)).syncGetEmoticonInfo(((MessageForMarketFace)localObject3).mMarkFaceMessage);
      EmoticonPackage localEmoticonPackage = ((IEmoticonManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IEmoticonManagerService.class)).syncFindEmoticonPackageById(((IPicEmoticonInfo)localObject1).getEmoticon().epId);
      MarketFaceItemBuilder.jdField_a_of_type_ComTencentMobileqqDataChatMessage = (ChatMessage)localObject3;
      MarketFaceItemBuilder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo = (IPicEmoticonInfo)localObject1;
      if ((localEmoticonPackage != null) && (localEmoticonPackage.name != null) && ((localEmoticonPackage.mobileFeetype != 0) || (localEmoticonPackage.downloadCount != 0)))
      {
        i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getInt("emosm_json_last_download_timestamp", 0);
        int j = (int)(System.currentTimeMillis() / 1000L);
        if ((j - i <= 86400) && (j >= i))
        {
          MarketFaceItemBuilder.a(6, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localEmoticonPackage, (IPicEmoticonInfo)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (QQProgressDialog)localObject2);
        }
        else
        {
          localObject3 = new MarketFaceItemBuilder.EmoticonDetailJsonDownloaderVars();
          ((MarketFaceItemBuilder.EmoticonDetailJsonDownloaderVars)localObject3).a(6, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (IPicEmoticonInfo)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (QQProgressDialog)localObject2);
          localObject2 = (IEmojiManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IEmojiManagerService.class, "");
          ((IEmojiManagerService)localObject2).getEmojiListenerManager().addEmotionJsonDownloadListener((EmotionJsonDownloadListener)localObject3);
          ((IEmojiManagerService)localObject2).startDownloadEmosmJson(((IPicEmoticonInfo)localObject1).getEmoticon().epId, EmojiManagerServiceConstant.JSON_EMOSM_MALL);
        }
      }
      else
      {
        localObject3 = new MarketFaceItemBuilder.EmoticonDetailJsonDownloaderVars();
        ((MarketFaceItemBuilder.EmoticonDetailJsonDownloaderVars)localObject3).a(6, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (IPicEmoticonInfo)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (QQProgressDialog)localObject2);
        localObject2 = (IEmojiManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IEmojiManagerService.class);
        ((IEmojiManagerService)localObject2).getEmojiListenerManager().addEmotionJsonDownloadListener((EmotionJsonDownloadListener)localObject3);
        ((IEmojiManagerService)localObject2).startDownloadEmosmJson(((IPicEmoticonInfo)localObject1).getEmoticon().epId, EmojiManagerServiceConstant.JSON_EMOSM_MALL);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(false, null, false);
  }
  
  private void d(int paramInt1, int paramInt2)
  {
    this.e = new ImageView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    this.e.setId(2131364572);
    Object localObject = new LinearLayout.LayoutParams(paramInt1, paramInt1);
    ((LinearLayout.LayoutParams)localObject).gravity = 16;
    ((LinearLayout.LayoutParams)localObject).setMargins(paramInt2, 0, 0, 0);
    this.e.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.e.setOnClickListener(this);
    this.e.setContentDescription(HardCodeUtil.a(2131719844));
    this.e.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839354));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.e);
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    if (localObject != null)
    {
      TroopEssenceReportUtil.i(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((SessionInfo)localObject).jdField_a_of_type_JavaLangString);
      TroopEssenceReportUtil.j(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
  }
  
  private void e()
  {
    int i = MultiMsgManager.a().c();
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80059B6", "0X80059B6", 0, 0, "", "", "", "");
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", AIOShareActionSheet.c, AIOShareActionSheet.c, 0, i, "", "", "", "");
    if ((ChatActivityFacade.b != null) && (ChatActivityFacade.b.isShowing())) {
      return;
    }
    Object localObject1 = MultiMsgManager.a().a();
    if (((List)localObject1).size() == 0)
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131698523, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a());
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80059B7", "0X80059B7", 0, 0, "0", "", "", "");
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008)
      {
        localObject1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(NetConnInfoCenter.getServerTimeMillis()));
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X80064F9", "0X80064F9", 0, 0, (String)localObject1, "1", "", "");
      }
      return;
    }
    MultiMsgManager.a().b((List)localObject1);
    if (QLog.isDevelopLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("checklist.size = ");
      ((StringBuilder)localObject2).append(((List)localObject1).size());
      QLog.d("MultiMsg_TAG", 4, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(((List)localObject1).size());
    ReportController.b((AppRuntime)localObject2, "CliOper", "", "", "0X80059B7", "0X80059B7", 0, 0, localStringBuilder.toString(), "", "", "");
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008)
    {
      localObject2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(NetConnInfoCenter.getServerTimeMillis()));
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X80064F9", "0X80064F9", 0, 0, (String)localObject2, "0", "", "");
    }
    ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (List)localObject1);
  }
  
  private void e(int paramInt1, int paramInt2)
  {
    ImageView localImageView = new ImageView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    localImageView.setId(2131364575);
    Object localObject = new LinearLayout.LayoutParams(paramInt1, paramInt1);
    ((LinearLayout.LayoutParams)localObject).gravity = 16;
    ((LinearLayout.LayoutParams)localObject).setMargins(paramInt2, 0, 0, 0);
    localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localImageView.setOnClickListener(this);
    if (AppSetting.d) {
      localImageView.setContentDescription(HardCodeUtil.a(2131701187));
    }
    localObject = new StateListDrawable();
    Drawable localDrawable = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839420);
    ((StateListDrawable)localObject).addState(new int[] { 16842919 }, localDrawable);
    localDrawable = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839420);
    ((StateListDrawable)localObject).addState(new int[] { 16842910 }, localDrawable);
    localImageView.setImageDrawable((Drawable)localObject);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localImageView);
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if (localObject != null) {
      ((LinearLayout)localObject).setVisibility(0);
    }
    localObject = (AIOLongShotHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(15);
    SelectToBottomHelper localSelectToBottomHelper = (SelectToBottomHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(40);
    if (!((AIOLongShotHelper)localObject).a()) {
      localSelectToBottomHelper.b();
    }
    localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject != null)
    {
      ((View)localObject).setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setClickable(true);
    }
    localObject = (AIOShortcutBarHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(52);
    if (localObject != null)
    {
      ((AIOShortcutBarHelper)localObject).c(16);
      ((AIOShortcutBarHelper)localObject).c(11);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.c = new ImageView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    this.c.setId(2131364574);
    if (AppSetting.d) {
      this.c.setContentDescription(HardCodeUtil.a(2131701197));
    }
    Object localObject = new LinearLayout.LayoutParams(paramInt1, paramInt1);
    ((LinearLayout.LayoutParams)localObject).setMargins(paramInt2, 0, 0, 0);
    ((LinearLayout.LayoutParams)localObject).gravity = 16;
    this.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.c.setOnClickListener(this);
    localObject = new StateListDrawable();
    Drawable localDrawable = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839366);
    ((StateListDrawable)localObject).addState(new int[] { 16842919 }, localDrawable);
    localDrawable = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839367);
    ((StateListDrawable)localObject).addState(new int[] { 16842910 }, localDrawable);
    localDrawable = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839366);
    ((StateListDrawable)localObject).addState(new int[0], localDrawable);
    this.c.setImageDrawable((Drawable)localObject);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.c);
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(boolean paramBoolean)
  {
    ImageView localImageView = this.b;
    if (localImageView != null) {
      localImageView.setEnabled(paramBoolean);
    }
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if (localObject != null) {
      ((LinearLayout)localObject).setVisibility(8);
    }
    ((SelectToBottomHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(40)).a();
    localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = (AIOShortcutBarHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(52);
    if (localObject != null)
    {
      ((AIOShortcutBarHelper)localObject).c(15);
      ((AIOShortcutBarHelper)localObject).c(12);
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    this.b = new ImageView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    this.b.setId(2131364570);
    Object localObject = new LinearLayout.LayoutParams(paramInt1, paramInt1);
    ((LinearLayout.LayoutParams)localObject).setMargins(paramInt2, 0, 0, 0);
    ((LinearLayout.LayoutParams)localObject).gravity = 16;
    this.b.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.b.setOnClickListener(this);
    if (AppSetting.d) {
      this.b.setContentDescription(HardCodeUtil.a(2131701177));
    }
    localObject = new StateListDrawable();
    Drawable localDrawable = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839355);
    ((StateListDrawable)localObject).addState(new int[] { 16842919 }, localDrawable);
    localDrawable = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839356);
    ((StateListDrawable)localObject).addState(new int[] { 16842910 }, localDrawable);
    localDrawable = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839355);
    ((StateListDrawable)localObject).addState(new int[0], localDrawable);
    this.b.setImageDrawable((Drawable)localObject);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.b);
  }
  
  public void c()
  {
    List localList = MultiMsgManager.a().a();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if ((localObject != null) && (((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1))
    {
      localObject = this.e;
      if (localObject != null)
      {
        if (((ImageView)localObject).getVisibility() != 0) {
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
          localException.printStackTrace();
        }
        if (!TroopEssenceUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l1, localList))
        {
          this.e.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839353));
          this.e.setEnabled(false);
          return;
        }
        this.e.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839354));
        this.e.setEnabled(true);
      }
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
    Object localObject1;
    switch (paramView.getId())
    {
    case 2131364573: 
    default: 
      break;
    case 2131364576: 
      ((MultiForwardHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(1)).a();
      break;
    case 2131364575: 
      localObject1 = AIOLongShotHelper.a();
      if (localObject1 != null) {
        ((AIOLongShotHelper)localObject1).a(paramView);
      }
      break;
    case 2131364574: 
      int i = MultiMsgManager.a().c();
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", AIOShareActionSheet.d, AIOShareActionSheet.d, 0, i, "", "", "", "");
      ((MultiForwardHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(1)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1, false);
      break;
    case 2131364572: 
      localObject1 = (TroopEssenceMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_ESSENCE_MSG_MANAGER);
      if (localObject1 != null)
      {
        Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
        if ((localObject2 != null) && (((SessionInfo)localObject2).jdField_a_of_type_Int == 1))
        {
          localObject2 = this.e;
          if ((localObject2 != null) && (((ImageView)localObject2).isEnabled()))
          {
            ((TroopEssenceMsgManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
            this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(false, null, false);
          }
        }
      }
      break;
    case 2131364571: 
      e();
      break;
    case 2131364570: 
      d();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onMoveToState(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIOMultiActionHelper
 * JD-Core Version:    0.7.0.1
 */