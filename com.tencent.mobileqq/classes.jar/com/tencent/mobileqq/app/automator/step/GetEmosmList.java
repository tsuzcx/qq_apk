package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.IEmoticonHandler;
import com.tencent.mobileqq.emosm.api.IEmoticonFromGroupDBManagerService;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.vas.config.business.qvip.QVipStickerProcessor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

public class GetEmosmList
  extends AsyncStep
{
  protected int doStep()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "getEmosmList start int QQInitHandler...");
    }
    ((IEmoticonFromGroupDBManagerService)this.mAutomator.k.getRuntimeService(IEmoticonFromGroupDBManagerService.class)).enableWrite2DBAfterTenSec();
    Object localObject2 = this.mAutomator.k.getApp().getSharedPreferences("sticker_pref", 0);
    Object localObject1 = this.mAutomator.k.getCurrentAccountUin();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("sticker_switch_");
    ((StringBuilder)localObject3).append((String)localObject1);
    boolean bool;
    if ((((SharedPreferences)localObject2).getBoolean(((StringBuilder)localObject3).toString(), true)) && (EmojiStickerManager.d())) {
      bool = true;
    } else {
      bool = false;
    }
    EmojiStickerManager.n = bool;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("sticker_max_send_num_");
    ((StringBuilder)localObject3).append((String)localObject1);
    QVipStickerProcessor.b = ((SharedPreferences)localObject2).getInt(((StringBuilder)localObject3).toString(), QVipStickerProcessor.a);
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("sticker_max_show_num_");
    ((StringBuilder)localObject3).append((String)localObject1);
    QVipStickerProcessor.c = ((SharedPreferences)localObject2).getInt(((StringBuilder)localObject3).toString(), QVipStickerProcessor.a);
    EmojiStickerManager.u = DeviceInfoUtil.U();
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("sticker_update_version_time_");
    ((StringBuilder)localObject3).append((String)localObject1);
    EmojiStickerManager.A = ((SharedPreferences)localObject2).getLong(((StringBuilder)localObject3).toString(), 0L);
    QLog.i("QQInitHandler", 1, String.format("Sticker config, switch %b, maxSendNum: %d, isRubbishMachine: %b, updateVersionTime: %d", new Object[] { Boolean.valueOf(EmojiStickerManager.n), Integer.valueOf(QVipStickerProcessor.b), Boolean.valueOf(EmojiStickerManager.u), Long.valueOf(EmojiStickerManager.A) }));
    if (EmojiStickerManager.A == 0L)
    {
      long l = NetConnInfoCenter.getServerTime();
      localObject2 = ((SharedPreferences)localObject2).edit();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("sticker_update_version_time_");
      ((StringBuilder)localObject3).append((String)localObject1);
      ((SharedPreferences.Editor)localObject2).putLong(((StringBuilder)localObject3).toString(), l).apply();
      EmojiStickerManager.A = l;
    }
    localObject2 = (IEmoticonManagerService)this.mAutomator.k.getRuntimeService(IEmoticonManagerService.class);
    localObject1 = this.mAutomator.k.getApplication().getSharedPreferences("mobileQQ", 0);
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("emosm_has_set_emosmpackage_valid_");
    ((StringBuilder)localObject3).append(this.mAutomator.k.getCurrentAccountUin());
    if (!Boolean.valueOf(((SharedPreferences)localObject1).getBoolean(((StringBuilder)localObject3).toString(), false)).booleanValue())
    {
      localObject3 = ((IEmoticonManagerService)localObject2).syncGetTabEmoticonPackages();
      if (localObject3 != null)
      {
        Iterator localIterator = ((List)localObject3).iterator();
        while (localIterator.hasNext()) {
          ((EmoticonPackage)localIterator.next()).valid = true;
        }
        ((IEmoticonManagerService)localObject2).saveEmoticonPackages((List)localObject3);
      }
      localObject2 = ((SharedPreferences)localObject1).edit();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("emosm_has_set_emosmpackage_valid_");
      ((StringBuilder)localObject3).append(this.mAutomator.k.getCurrentAccountUin());
      ((SharedPreferences.Editor)localObject2).putBoolean(((StringBuilder)localObject3).toString(), true).commit();
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("emosm_has_download_emosmpackage_tag_");
    ((StringBuilder)localObject2).append(this.mAutomator.k.getCurrentAccountUin());
    localObject2 = Boolean.valueOf(((SharedPreferences)localObject1).getBoolean(((StringBuilder)localObject2).toString(), false));
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("emosm_has_download_emosmpackage_kandian_tag_");
    ((StringBuilder)localObject3).append(this.mAutomator.k.getCurrentAccountUin());
    localObject1 = Boolean.valueOf(((SharedPreferences)localObject1).getBoolean(((StringBuilder)localObject3).toString(), false));
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("kandianOidbFlag kandianOidbFlag int oidbFlag...");
      ((StringBuilder)localObject3).append(localObject2);
      QLog.d("QQInitHandler", 2, ((StringBuilder)localObject3).toString());
    }
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("kandianOidbFlag kandianOidbFlag int kandianOidbFlag...");
      ((StringBuilder)localObject3).append(localObject1);
      QLog.d("QQInitHandler", 2, ((StringBuilder)localObject3).toString());
    }
    localObject3 = (IEmoticonHandler)this.mAutomator.k.getBusinessHandler(BusinessHandlerFactory.HANDLER_EMOSM);
    if (((Boolean)localObject2).booleanValue()) {
      ((IEmoticonHandler)localObject3).a(0, 0);
    } else {
      ((IEmoticonHandler)localObject3).d(0);
    }
    if (((Boolean)localObject1).booleanValue()) {
      ((IEmoticonHandler)localObject3).a(0, 0, 1, 0);
    } else {
      ((IEmoticonHandler)localObject3).d(1);
    }
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetEmosmList
 * JD-Core Version:    0.7.0.1
 */