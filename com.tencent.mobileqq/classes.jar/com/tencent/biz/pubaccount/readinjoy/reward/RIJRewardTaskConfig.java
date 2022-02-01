package com.tencent.biz.pubaccount.readinjoy.reward;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.model.RIJUserLevelModule;
import com.tencent.biz.pubaccount.readinjoy.reward.aidl.RIJAidlClientRedPacketModule;
import com.tencent.biz.pubaccount.readinjoy.reward.utils.Utils;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/reward/RIJRewardTaskConfig;", "", "()V", "CONFIG_KEY_ARTICLE_STATIONARY_TASK_CONSUME_TIME", "", "CONFIG_KEY_ARTICLE_TASK_CONSUME_TIME", "CONFIG_KEY_CONSUME_SINGLE_TASK_TOTAL_TIME", "CONFIG_KEY_CONSUME_TASK_TOTAL_COUNT", "CONFIG_KEY_GUIDE_CONDITION_VIDEO_PROGRESS", "CONFIG_KEY_GUIDE_TIMES_PER_DAY", "CONFIG_KEY_GUIDE_TIMES_PER_PERSON", "CONFIG_KEY_LAST_SHOW_GUIDE_TIMES_STAMPS", "CONFIG_KEY_REWARD_ENABLE", "CONFIG_KEY_REWARD_GUIDE_WORD", "CONFIG_KEY_REWARD_SEND_ONE_COIN_TEXT", "CONFIG_KEY_REWARD_SEND_ONE_COIN_TEXT_WHITE", "CONFIG_KEY_REWARD_SEND_THREE_COIN_TEXT", "CONFIG_KEY_REWARD_SEND_THREE_COIN_TEXT_WHITE", "CONFIG_KEY_SEND_COIN_DIALOG_FIRST_BTN_NUM", "CONFIG_KEY_SEND_COIN_DIALOG_HINT", "CONFIG_KEY_SEND_COIN_DIALOG_SECOND_BTN_NUM", "CONFIG_KEY_SEND_COIN_SUCCESS_ANIM_ENABLE", "CONFIG_KEY_SEND_COIN_SUCCESS_TIPS", "CONFIG_KEY_SEND_COIN_TWO_BTN_ANIM", "CONFIG_KEY_TODAY_SHOW_GUIDE_TIMES", "CONFIG_KEY_TOTAL_SHOW_GUIDE_TIMES", "DEFAULT_GUIDE_CONDITION_VIDEO_PROGRESS", "", "DEFAULT_GUIDE_TIMES_PER_DAY", "", "DEFAULT_GUIDE_TIMES_PER_PERSON", "DEFAULT_MAX_TASK_TIME_FOR_ARTICLE_IN_SEC", "DEFAULT_MAX_TASK_TIME_FOR_ARTICLE_STATIONARY_IN_SEC", "DEFAULT_MISSION_COMPLETED_TIME_IN_MIN", "DEFAULT_MISSION_COUNT_DAILY", "DEFAULT_REWARD_GUIDE_WORD", "DEFAULT_SEND_COIN_DIALOG_FIRST_BTN_NUM", "DEFAULT_SEND_COIN_DIALOG_HINT", "DEFAULT_SEND_COIN_DIALOG_SECOND_BTN_NUM", "DEFAULT_SEND_COIN_SUCCESS_TIPS", "TAG", "aladdinConfig", "Lcom/tencent/aladdin/config/AladdinConfig;", "getAladdinConfig", "()Lcom/tencent/aladdin/config/AladdinConfig;", "dailyMissionCount", "dailyMissionCount$annotations", "getDailyMissionCount", "()I", "enable", "", "enable$annotations", "getEnable", "()Z", "guideConditionVideoPercent", "getGuideConditionVideoPercent", "()F", "maxTaskTimeForArticleInMs", "maxTaskTimeForArticleInMs$annotations", "getMaxTaskTimeForArticleInMs", "maxTaskTimeWhenArticleStationaryInMs", "maxTaskTimeWhenArticleStationaryInMs$annotations", "getMaxTaskTimeWhenArticleStationaryInMs", "missionCompletedTimeInMs", "missionCompletedTimeInMs$annotations", "getMissionCompletedTimeInMs", "needShowGuide", "getNeedShowGuide", "rewardCoinDialogFisrtBtnNum", "getRewardCoinDialogFisrtBtnNum", "rewardCoinDialogHint", "getRewardCoinDialogHint", "()Ljava/lang/String;", "rewardCoinDialogSecondBtnNum", "getRewardCoinDialogSecondBtnNum", "rewardCoinGuideWords", "getRewardCoinGuideWords", "rewardDialogBtnAnimEnable", "getRewardDialogBtnAnimEnable", "rewardOneCoinTextUrl", "getRewardOneCoinTextUrl", "rewardOneCoinTextWhiteUrl", "getRewardOneCoinTextWhiteUrl", "rewardSuccessAnimEnable", "getRewardSuccessAnimEnable", "rewardSuccessTipsWords", "getRewardSuccessTipsWords", "rewardThreeCoinTextUrl", "getRewardThreeCoinTextUrl", "rewardThreeCoinTextWhiteUrl", "getRewardThreeCoinTextWhiteUrl", "updateShowGuideConfig", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJRewardTaskConfig
{
  public static final RIJRewardTaskConfig a = new RIJRewardTaskConfig();
  
  public static final int a()
  {
    if (Utils.a()) {
      return (int)(a.a().getFloatFromString("consume_single_task_total_time", 30.0F) * 60 * 1000);
    }
    return RIJAidlClientRedPacketModule.c();
  }
  
  private final AladdinConfig a()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(372);
    Intrinsics.checkExpressionValueIsNotNull(localAladdinConfig, "Aladdin.getConfig(QQAlad…KANDIAN_COIN_REWARD_TASK)");
    return localAladdinConfig;
  }
  
  public static final boolean a()
  {
    if (Utils.a())
    {
      if (a.a().getIntegerFromString("reward_enable", 0) == 1) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        boolean bool2 = StudyModeManager.a();
        boolean bool3 = RIJUserLevelModule.a().a(5);
        QLog.i("RIJRewardTaskConfig", 1, "isHighestRewardTaskAuthorityOn: " + bool1 + " ,isStudyMode=" + bool2 + ", userLevelEnable=" + bool3);
        if ((!bool1) || (bool2) || (!bool3)) {
          break;
        }
        return true;
      }
      return false;
    }
    return RIJAidlClientRedPacketModule.b();
  }
  
  public static final int b()
  {
    if (Utils.a()) {
      return a.a().getIntegerFromString("consume_task_total_count", 1);
    }
    return RIJAidlClientRedPacketModule.d();
  }
  
  public static final int c()
  {
    if (Utils.a()) {
      return a.a().getIntegerFromString("reward_single_articel_task_consume_time", 40) * 1000;
    }
    return RIJAidlClientRedPacketModule.e();
  }
  
  public static final int d()
  {
    if (Utils.a()) {
      return a.a().getIntegerFromString("reward_articel_stationary_consume", 3) * 1000;
    }
    return RIJAidlClientRedPacketModule.f();
  }
  
  public final float a()
  {
    return a().getFloatFromString("reward_guide_condition_video_progress", 0.8F);
  }
  
  @NotNull
  public final String a()
  {
    String str = a().getString("reward_send_coin_dialog_header_hint", "投币数量决定视频额外推荐量");
    Intrinsics.checkExpressionValueIsNotNull(str, "aladdinConfig.getString(…LT_SEND_COIN_DIALOG_HINT)");
    return str;
  }
  
  public final void a()
  {
    Integer localInteger1 = (Integer)ReadInJoyHelper.a("total_show_guide_times", Integer.valueOf(0));
    Integer localInteger2 = (Integer)ReadInJoyHelper.a("today_show_guide_times", Integer.valueOf(0));
    ReadInJoyHelper.a("total_show_guide_times", Integer.valueOf(localInteger1.intValue() + 1));
    ReadInJoyHelper.a("today_show_guide_times", Integer.valueOf(localInteger2.intValue() + 1));
    ReadInJoyHelper.a("last_show_guide_times_stamps", Long.valueOf(System.currentTimeMillis()));
  }
  
  @NotNull
  public final String b()
  {
    String str = a().getString("reward_guide_word", "喜欢就投个硬币吧~ ");
    Intrinsics.checkExpressionValueIsNotNull(str, "aladdinConfig.getString(…EFAULT_REWARD_GUIDE_WORD)");
    return str;
  }
  
  public final boolean b()
  {
    return a().getIntegerFromString("reward_send_coin_dialog_anim", 1) == 1;
  }
  
  @NotNull
  public final String c()
  {
    String str = a().getString("reward_send_coin_success_tips", "感谢支持~ Y(^o^)Y，我会加油的");
    Intrinsics.checkExpressionValueIsNotNull(str, "aladdinConfig.getString(…T_SEND_COIN_SUCCESS_TIPS)");
    return str;
  }
  
  public final boolean c()
  {
    return a().getIntegerFromString("reward_send_coin_dialog_two_btn_anim", 1) == 1;
  }
  
  @NotNull
  public final String d()
  {
    String str = a().getString("reward_send_one_coin_text", "");
    Intrinsics.checkExpressionValueIsNotNull(str, "aladdinConfig.getString(…D_SEND_ONE_COIN_TEXT, \"\")");
    return str;
  }
  
  public final boolean d()
  {
    int i = a().getIntegerFromString("reward_guide_times_per_person", 3);
    Integer localInteger = (Integer)ReadInJoyHelper.a("total_show_guide_times", Integer.valueOf(0));
    if (QLog.isColorLevel()) {
      QLog.d("RIJRewardTaskConfig", 2, "RIJRewardTaskConfig: guideTimesPerPerson=" + i + ", totalShowGuideTimes=" + localInteger);
    }
    if (Intrinsics.compare(localInteger.intValue(), i) >= 0) {
      return false;
    }
    localInteger = (Integer)ReadInJoyHelper.a("last_show_guide_times_stamps", Integer.valueOf(0));
    long l = System.currentTimeMillis();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("RIJRewardTaskConfig: lastShowGuideTime=").append(localInteger).append(", curTime=").append(l).append(", offset=");
      Intrinsics.checkExpressionValueIsNotNull(localInteger, "lastShowGuideTime");
      if (l - localInteger.intValue() <= TimeUnit.DAYS.toMillis(1L)) {
        break label308;
      }
    }
    label308:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("RIJRewardTaskConfig", 2, bool);
      Intrinsics.checkExpressionValueIsNotNull(localInteger, "lastShowGuideTime");
      if (l - localInteger.intValue() > TimeUnit.DAYS.toMillis(1L)) {
        ReadInJoyHelper.a("today_show_guide_times", Integer.valueOf(0));
      }
      localInteger = (Integer)ReadInJoyHelper.a("today_show_guide_times", Integer.valueOf(0));
      i = a().getIntegerFromString("reward_guide_times_per_day", 1);
      if (QLog.isColorLevel()) {
        QLog.d("RIJRewardTaskConfig", 2, "RIJRewardTaskConfig: todayShowGuideTimes=" + localInteger + ", guideTimesPerDay=" + i);
      }
      if (Intrinsics.compare(localInteger.intValue(), i) < 0) {
        break;
      }
      return false;
    }
    return true;
  }
  
  public final int e()
  {
    return a().getIntegerFromString("reward_send_coin_dialog_first_btn_num", 1);
  }
  
  @NotNull
  public final String e()
  {
    String str = a().getString("reward_send_three_coin_text", "");
    Intrinsics.checkExpressionValueIsNotNull(str, "aladdinConfig.getString(…SEND_THREE_COIN_TEXT, \"\")");
    return str;
  }
  
  public final int f()
  {
    return a().getIntegerFromString("reward_send_coin_dialog_second_btn_num", 3);
  }
  
  @NotNull
  public final String f()
  {
    String str = a().getString("reward_send_one_coin_text_white", "");
    Intrinsics.checkExpressionValueIsNotNull(str, "aladdinConfig.getString(…_ONE_COIN_TEXT_WHITE, \"\")");
    return str;
  }
  
  @NotNull
  public final String g()
  {
    String str = a().getString("reward_send_three_coin_text_white", "");
    Intrinsics.checkExpressionValueIsNotNull(str, "aladdinConfig.getString(…HREE_COIN_TEXT_WHITE, \"\")");
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.reward.RIJRewardTaskConfig
 * JD-Core Version:    0.7.0.1
 */