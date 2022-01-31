package com.tencent.mobileqq.app.automator.step;

import alna;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import apjs;
import aube;
import bdcb;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

public class GetEmosmList
  extends AsyncStep
{
  public int a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "getEmosmList start int QQInitHandler...");
    }
    ((apjs)this.a.app.getManager(259)).a();
    Object localObject1 = this.a.app.getApp().getSharedPreferences("sticker_pref", 0);
    Object localObject2 = this.a.app.getCurrentAccountUin();
    if ((((SharedPreferences)localObject1).getBoolean("sticker_switch_" + (String)localObject2, true)) && (EmojiStickerManager.a())) {}
    for (boolean bool = true;; bool = false)
    {
      EmojiStickerManager.jdField_e_of_type_Boolean = bool;
      EmojiStickerManager.jdField_e_of_type_Int = ((SharedPreferences)localObject1).getInt("sticker_max_send_num_" + (String)localObject2, EmojiStickerManager.c);
      EmojiStickerManager.jdField_f_of_type_Int = ((SharedPreferences)localObject1).getInt("sticker_max_show_num_" + (String)localObject2, EmojiStickerManager.c);
      EmojiStickerManager.jdField_f_of_type_Boolean = bdcb.e();
      EmojiStickerManager.d = ((SharedPreferences)localObject1).getLong("sticker_update_version_time_" + (String)localObject2, 0L);
      QLog.i("QQInitHandler", 1, String.format("Sticker config, switch %b, maxSendNum: %d, isRubbishMachine: %b, updateVersionTime: %d", new Object[] { Boolean.valueOf(EmojiStickerManager.jdField_e_of_type_Boolean), Integer.valueOf(EmojiStickerManager.jdField_e_of_type_Int), Boolean.valueOf(EmojiStickerManager.jdField_f_of_type_Boolean), Long.valueOf(EmojiStickerManager.d) }));
      if (EmojiStickerManager.d == 0L)
      {
        long l = NetConnInfoCenter.getServerTime();
        ((SharedPreferences)localObject1).edit().putLong("sticker_update_version_time_" + (String)localObject2, l).apply();
        EmojiStickerManager.d = l;
      }
      localObject2 = (aube)this.a.app.getManager(14);
      localObject1 = this.a.app.getApplication().getSharedPreferences("mobileQQ", 0);
      if (Boolean.valueOf(((SharedPreferences)localObject1).getBoolean("emosm_has_set_emosmpackage_valid_" + this.a.app.getCurrentAccountUin(), false)).booleanValue()) {
        break label501;
      }
      localObject3 = ((aube)localObject2).a();
      if (localObject3 == null) {
        break label454;
      }
      Iterator localIterator = ((List)localObject3).iterator();
      while (localIterator.hasNext()) {
        ((EmoticonPackage)localIterator.next()).valid = true;
      }
    }
    ((aube)localObject2).a((List)localObject3);
    label454:
    ((SharedPreferences)localObject1).edit().putBoolean("emosm_has_set_emosmpackage_valid_" + this.a.app.getCurrentAccountUin(), true).commit();
    label501:
    localObject2 = Boolean.valueOf(((SharedPreferences)localObject1).getBoolean("emosm_has_download_emosmpackage_tag_" + this.a.app.getCurrentAccountUin(), false));
    localObject1 = Boolean.valueOf(((SharedPreferences)localObject1).getBoolean("emosm_has_download_emosmpackage_kandian_tag_" + this.a.app.getCurrentAccountUin(), false));
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "kandianOidbFlag kandianOidbFlag int oidbFlag..." + localObject2);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "kandianOidbFlag kandianOidbFlag int kandianOidbFlag..." + localObject1);
    }
    Object localObject3 = (alna)this.a.app.a(12);
    if (((Boolean)localObject2).booleanValue())
    {
      ((alna)localObject3).a(0, 0);
      if (!((Boolean)localObject1).booleanValue()) {
        break label708;
      }
      ((alna)localObject3).a(0, 0, 1, 0);
    }
    for (;;)
    {
      return 7;
      ((alna)localObject3).d(0);
      break;
      label708:
      ((alna)localObject3).d(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetEmosmList
 * JD-Core Version:    0.7.0.1
 */