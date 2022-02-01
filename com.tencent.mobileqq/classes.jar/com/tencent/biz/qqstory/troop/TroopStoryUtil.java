package com.tencent.biz.qqstory.troop;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForTroopStory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;

public class TroopStoryUtil
{
  public static MessageRecord a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface != null) && (a(paramString)))
    {
      TroopStoryManager localTroopStoryManager = (TroopStoryManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_STORY_MANAGER);
      String str = a(paramString);
      paramString = localTroopStoryManager.a(paramString);
      if (paramString != null) {
        return paramQQAppInterface.getMessageFacade().d(str, 1, paramString.longValue());
      }
    }
    return null;
  }
  
  public static String a(Intent paramIntent, @NonNull String paramString1, String paramString2)
  {
    boolean bool = TextUtils.isEmpty(paramString2);
    int k = 0;
    if ((!bool) && (!TextUtils.isEmpty(paramString1))) {
      paramString1 = paramString1.replace("$GCODE$", paramString2);
    } else {
      QLog.e("TroopStoryUtil", 1, new Object[] { "configTroopStoryProfileFromAIO empty. troopUin=", "", ", url=", paramString1 });
    }
    int i = 8;
    if (paramIntent != null) {
      i = paramIntent.getIntExtra("extra_share_group_from", 8);
    }
    int j = 78;
    if (paramIntent != null) {
      j = paramIntent.getIntExtra("extra_play_video_from", 78);
    }
    if (paramIntent != null) {
      k = paramIntent.getIntExtra("extra_last_open_from", 0);
    }
    paramIntent = new StringBuilder(paramString1);
    paramIntent.append("&troopStoryMemoriesFrom=");
    paramIntent.append(i);
    paramIntent.append("&playVideoFrom=");
    paramIntent.append(j);
    paramIntent.append("&lastOpenFrom=");
    paramIntent.append(k);
    return paramIntent.toString();
  }
  
  public static String a(MessageForShortVideo paramMessageForShortVideo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("gs_");
    localStringBuilder.append(paramMessageForShortVideo.frienduin);
    localStringBuilder.append('_');
    localStringBuilder.append(paramMessageForShortVideo.getMd5());
    localStringBuilder.append('_');
    localStringBuilder.append(MD5Utils.toMD5(paramMessageForShortVideo.uuid));
    localStringBuilder.append("-700");
    return localStringBuilder.toString().toLowerCase();
  }
  
  public static String a(String paramString)
  {
    if (a(paramString))
    {
      paramString = paramString.split("_");
      if (paramString.length > 2) {
        return paramString[1];
      }
    }
    return null;
  }
  
  public static void a(MessageForTroopStory paramMessageForTroopStory, Bundle paramBundle)
  {
    paramBundle.putInt("forward_type", 32);
    paramBundle.putLong("key_uid", paramMessageForTroopStory.uid);
    paramBundle.putString("key_union_id", paramMessageForTroopStory.unionId);
    paramBundle.putString("key_md5", paramMessageForTroopStory.md5);
    paramBundle.putString("key_thumb_url", paramMessageForTroopStory.thumbUrl);
    paramBundle.putString("key_doodle_url", paramMessageForTroopStory.doodleUrl);
    paramBundle.putInt("key_video_width", paramMessageForTroopStory.videoWidth);
    paramBundle.putInt("key_video_height", paramMessageForTroopStory.videoHeight);
    paramBundle.putString("key_source_name", paramMessageForTroopStory.sourceName);
    paramBundle.putString("key_source_action_type", paramMessageForTroopStory.sourceActionType);
    paramBundle.putString("key_source_action_data", paramMessageForTroopStory.sourceActionData);
    paramBundle.putString("key_compatible_text", paramMessageForTroopStory.compatibleText);
    paramBundle.putInt("key_ctr_version", paramMessageForTroopStory.ctrVersion);
  }
  
  public static boolean a(int paramInt, MessageRecord paramMessageRecord)
  {
    return (QQStoryManager.i()) && (paramInt == 1) && ((paramMessageRecord instanceof MessageForShortVideo)) && (((MessageForShortVideo)paramMessageRecord).busiType == 1);
  }
  
  public static boolean a(String paramString)
  {
    return (paramString != null) && (paramString.startsWith("gs_"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.troop.TroopStoryUtil
 * JD-Core Version:    0.7.0.1
 */