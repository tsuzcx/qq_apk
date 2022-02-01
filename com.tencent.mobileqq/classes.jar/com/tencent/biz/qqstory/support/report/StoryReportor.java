package com.tencent.biz.qqstory.support.report;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.aelight.camera.entry.api.AECameraEntry;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.model.item.IFeedOwner;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryManager;
import com.tencent.biz.qqstory.playvideo.QQStoryWatcherListActivity;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.storyHome.QQStoryMainActivity;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailActivity;
import com.tencent.biz.qqstory.storyHome.memory.QQStoryMemoriesActivity;
import com.tencent.biz.qqstory.storyHome.messagenotify.StoryMessageListActivity;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.troop.activity.TroopStoryMainActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class StoryReportor
{
  public static final String a;
  private static HashMap<String, String> jdField_a_of_type_JavaUtilHashMap;
  private static final List<String> jdField_a_of_type_JavaUtilList = Arrays.asList(new String[] { "time_openshoot", "time_waitshoot", "clk_mode", "start_shoot", "time_shoot", "time_openedit", "time_edit", "clk_function", "time_composite" });
  public static ConcurrentHashMap<Class, Integer> a;
  
  static
  {
    jdField_a_of_type_JavaLangString = StoryApi.a(2131699902);
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(QQStoryMainActivity.class, Integer.valueOf(3));
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(StoryDetailActivity.class, Integer.valueOf(4));
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(QQStoryMemoriesActivity.class, Integer.valueOf(5));
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(StoryMessageListActivity.class, Integer.valueOf(6));
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(QQStoryShareGroupProfileActivity.class, Integer.valueOf(11));
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(TroopStoryMainActivity.class, Integer.valueOf(12));
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(QQStoryWatcherListActivity.class, Integer.valueOf(13));
  }
  
  public static int a(int paramInt)
  {
    int i = 1;
    if (paramInt != 1)
    {
      i = 3;
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt != 6) {
              return 6;
            }
            return 2;
          }
          return 4;
        }
        return 5;
      }
    }
    return i;
  }
  
  @Deprecated
  public static int a(IFeedOwner paramIFeedOwner)
  {
    if (paramIFeedOwner == null) {
      return 4;
    }
    int i = paramIFeedOwner.getRelationType();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return 4;
        }
        return 3;
      }
      return 2;
    }
    return 1;
  }
  
  public static int a(FeedItem paramFeedItem)
  {
    if (paramFeedItem == null) {
      return 0;
    }
    int k = paramFeedItem.type;
    int i = 7;
    int j;
    if (k != 1)
    {
      j = 6;
      if (k != 2)
      {
        if (k == 3) {
          return i;
        }
        if (k != 5)
        {
          if (k != 6)
          {
            if (k != 7) {
              return 1;
            }
            return 11;
          }
          return 10;
        }
        return 9;
      }
      paramFeedItem = (ShareGroupItem)paramFeedItem.getOwner();
      if (paramFeedItem.getRelationType() != 2) {}
    }
    do
    {
      return 3;
      if (paramFeedItem.isPublic()) {
        i = j;
      } else {
        i = 5;
      }
      return i;
      paramFeedItem = (QQUserUIItem)paramFeedItem.getOwner();
      boolean bool = TextUtils.equals(QQStoryContext.a().b(), paramFeedItem.uid);
      i = 4;
      if (bool) {
        return 4;
      }
      if (paramFeedItem.getRelationType() == 0) {
        break;
      }
    } while (paramFeedItem.getRelationType() == 2);
    if (paramFeedItem.isSubscribe()) {
      i = 2;
    }
    return i;
  }
  
  public static int a(Class<? extends QQStoryBaseActivity> paramClass, int paramInt)
  {
    paramClass = (Integer)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramClass);
    if (paramClass == null) {
      return paramInt;
    }
    return paramClass.intValue();
  }
  
  public static int a(@Nullable String paramString, VideoListFeedItem paramVideoListFeedItem)
  {
    if (!TextUtils.isEmpty(paramString)) {
      paramString = MsgTabStoryManager.a(QQStoryContext.a()).a(paramString);
    } else {
      paramString = null;
    }
    if (paramString != null)
    {
      if (paramString.a == 12) {
        return 12;
      }
      if (paramString.a == 13) {
        return 13;
      }
    }
    return a(paramVideoListFeedItem);
  }
  
  public static String a(int paramInt)
  {
    String str2 = "4";
    if (paramInt != 23) {
      if (paramInt != 4444)
      {
        if (paramInt != 210)
        {
          str1 = str2;
          if (paramInt == 211) {
            return str1;
          }
        }
      }
      else
      {
        switch (paramInt)
        {
        default: 
          str1 = str2;
          switch (paramInt)
          {
          default: 
            return "";
          case 222: 
            return "6";
          }
        case 12: 
          return "5";
        case 11: 
          return "3";
        }
        return "1";
      }
    }
    String str1 = "2";
    return str1;
  }
  
  @NonNull
  public static String a(int paramInt, String... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length > paramInt)) {
      return paramVarArgs[paramInt];
    }
    return "";
  }
  
  public static String a(Context paramContext)
  {
    int j = NetworkUtil.getSystemNetwork(paramContext);
    int i = 3;
    if (j == 1) {
      i = 4;
    } else if (j == 2) {
      i = 1;
    } else if (j == 3) {
      i = 2;
    } else if (j != 4) {
      i = 5;
    }
    paramContext = new StringBuilder();
    paramContext.append("");
    paramContext.append(i);
    return paramContext.toString();
  }
  
  public static String a(StoryVideoItem paramStoryVideoItem)
  {
    if (paramStoryVideoItem == null) {
      return "";
    }
    if (paramStoryVideoItem.getPollLayout() == null) {
      return "5";
    }
    boolean bool = paramStoryVideoItem.isMine();
    int i;
    if (paramStoryVideoItem.mPollResult != -1) {
      i = 1;
    } else {
      i = 0;
    }
    if (bool)
    {
      if (i != 0) {
        return "2";
      }
      return "1";
    }
    if (i != 0) {
      return "4";
    }
    return "3";
  }
  
  public static String a(String paramString)
  {
    return (String)jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public static void a(int paramInt, long paramLong)
  {
    paramLong = SystemClock.uptimeMillis() - paramLong;
    if (paramLong > 86400000L) {
      return;
    }
    a("home_page", "time_stay_new", paramInt, (int)paramLong, new String[0]);
  }
  
  public static void a(int paramInt, long paramLong, String paramString)
  {
    paramLong = SystemClock.uptimeMillis() - paramLong;
    if (paramLong > 86400000L) {
      return;
    }
    a("home_page", "time_stay_new", paramInt, (int)paramLong, new String[] { paramString });
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3)
  {
    int i = paramActivity.getIntent().getIntExtra("capture_operation_in", -1);
    if ((i == 10002) || (i == 10000)) {
      a("video_edit_new", paramString1, i, 0, new String[] { paramString2, paramString3 });
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, MessageForStructing paramMessageForStructing, String paramString)
  {
    if (paramMessageForStructing == null) {
      return;
    }
    AbsStructMsg localAbsStructMsg = paramMessageForStructing.structingMsg;
    if (localAbsStructMsg != null)
    {
      if (TextUtils.isEmpty(localAbsStructMsg.mMsg_A_ActionData)) {
        return;
      }
      paramContext = JumpParser.a(paramQQAppInterface, paramContext, localAbsStructMsg.mMsg_A_ActionData);
      if (paramContext == null) {
        return;
      }
      paramQQAppInterface = paramContext.b("usertype");
      paramContext = paramContext.b("unionid");
      if ((TextUtils.isEmpty(paramQQAppInterface)) || (TextUtils.isEmpty(paramContext))) {}
    }
    try
    {
      i = Integer.parseInt(paramQQAppInterface);
    }
    catch (NumberFormatException paramQQAppInterface)
    {
      int i;
      label83:
      break label83;
    }
    i = 0;
    a("share_uin_obj", paramString, TroopUtils.a(paramMessageForStructing.istroop), i, new String[] { paramContext });
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean, String... paramVarArgs)
  {
    if ((paramInt1 == 10002) || (paramInt1 == 10000) || (paramInt1 == 10001) || (!paramBoolean) || (paramInt1 == AECameraEntry.p.a()) || (paramInt1 == AECameraEntry.e.a()))
    {
      a("video_shoot_new", paramString, paramInt1, paramInt2, paramVarArgs);
      if (jdField_a_of_type_JavaUtilList.contains(paramString))
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("op_type", "video_shoot_new");
        localHashMap.put("op_name", String.valueOf(paramString));
        localHashMap.put("op_result", String.valueOf(paramInt2));
        localHashMap.put("op_r1", a(0, paramVarArgs));
        localHashMap.put("op_r2", a(1, paramVarArgs));
        localHashMap.put("op_r3", a(2, paramVarArgs));
        localHashMap.put("op_r4", a(3, paramVarArgs));
        paramVarArgs = new StringBuilder();
        paramVarArgs.append("video_shoot_new_");
        paramVarArgs.append(paramString);
        paramString = paramVarArgs.toString();
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, paramString, true, 0L, 0L, localHashMap, null);
      }
    }
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    a(paramString, paramInt1, paramInt2, true, paramVarArgs);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    jdField_a_of_type_JavaUtilHashMap.put(paramString1, paramString2);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    try
    {
      if (SLog.a()) {
        SLog.b("StoryReportor", "[op_type]%s;[op_name]%s;[op_in]%d;[op_result]%d;[d1]%s;[d2]%s;[d3]%s;[d4]%s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), a(0, paramVarArgs), a(1, paramVarArgs), a(2, paramVarArgs), a(3, paramVarArgs) });
      }
      label80:
      ReportController.b(null, "dc00899", jdField_a_of_type_JavaLangString, "", paramString1, paramString2, paramInt1, paramInt2, a(0, paramVarArgs), a(1, paramVarArgs), a(2, paramVarArgs), a(3, paramVarArgs));
      return;
    }
    catch (Exception localException)
    {
      break label80;
    }
  }
  
  public static void a(String paramString1, String paramString2, Intent paramIntent, String... paramVarArgs)
  {
    if (paramIntent == null) {
      return;
    }
    int i = -1;
    if (paramIntent != null)
    {
      localObject = (EditVideoParams)paramIntent.getParcelableExtra(EditVideoParams.class.getName());
      if (localObject != null) {
        i = ((EditVideoParams)localObject).a("extra_ablum_type", -1);
      } else {
        i = paramIntent.getIntExtra("extra_ablum_type", -1);
      }
    }
    i = a(i);
    paramIntent = new String[paramVarArgs.length + 1];
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append("");
    paramIntent[0] = ((StringBuilder)localObject).toString();
    System.arraycopy(paramVarArgs, 0, paramIntent, 1, paramVarArgs.length);
    a(paramString1, paramString2, 0, 0, paramIntent);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    try
    {
      if (SLog.a()) {
        SLog.b("StoryReportor", "[department]%s;[op_type]%s;[op_name]%s;[op_in]%d;[op_result]%d;[d1]%s;[d2]%s;[d3]%s;[d4]%s", new Object[] { paramString1, paramString2, paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), a(0, paramVarArgs), a(1, paramVarArgs), a(2, paramVarArgs), a(3, paramVarArgs) });
      }
      label86:
      ReportController.b(null, "dc00899", paramString1, "", paramString2, paramString3, paramInt1, paramInt2, a(0, paramVarArgs), a(1, paramVarArgs), a(2, paramVarArgs), a(3, paramVarArgs));
      return;
    }
    catch (Exception localException)
    {
      break label86;
    }
  }
  
  public static void a(String paramString, boolean paramBoolean, long paramLong, String... paramVarArgs)
  {
    HashMap localHashMap = new HashMap();
    if (paramVarArgs != null)
    {
      int j;
      for (int i = 0; i < paramVarArgs.length; i = j)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("op_r");
        j = i + 1;
        localStringBuilder.append(j);
        localHashMap.put(localStringBuilder.toString(), paramVarArgs[i]);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.StoryReportor", 2, new Object[] { "780, reportToBeacon, ", paramString, ", isSuc:", Boolean.valueOf(paramBoolean), " duration:", Long.valueOf(paramLong), " eventValue:", localHashMap.toString() });
    }
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, paramString, paramBoolean, paramLong, 0L, localHashMap, null);
  }
  
  public static void a(String paramString, String... paramVarArgs)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("op_r1", a(0, paramVarArgs));
    localHashMap.put("op_r2", a(1, paramVarArgs));
    a(localHashMap, "reportALUMB", paramString);
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, paramString, true, 0L, 0L, localHashMap, null);
  }
  
  private static void a(Map<String, String> paramMap, String paramString1, String paramString2)
  {
    Iterator localIterator = paramMap.entrySet().iterator();
    paramMap = new StringBuilder();
    paramMap.append("事件Code : ");
    paramMap.append(paramString2);
    paramMap.append("   上报内容 ----------  \n");
    for (paramMap = paramMap.toString(); localIterator.hasNext(); paramMap = paramString2.toString())
    {
      paramString2 = (Map.Entry)localIterator.next();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramMap);
      localStringBuilder.append((String)paramString2.getKey());
      paramMap = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramMap);
      localStringBuilder.append("   :   ");
      paramMap = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramMap);
      localStringBuilder.append((String)paramString2.getValue());
      paramMap = localStringBuilder.toString();
      paramString2 = new StringBuilder();
      paramString2.append(paramMap);
      paramString2.append("\n");
    }
    if (QLog.isColorLevel()) {
      QLog.d(paramString1, 2, paramMap);
    }
  }
  
  public static boolean a(long paramLong1, long paramLong2, long paramLong3)
  {
    return (paramLong1 >= paramLong2) && (paramLong1 <= paramLong3);
  }
  
  public static int b(int paramInt)
  {
    if (paramInt != 10005)
    {
      if (paramInt != 10017) {
        if (paramInt != 10012) {
          if (paramInt == 10013) {
            break label64;
          }
        }
      }
      switch (paramInt)
      {
      default: 
        return 0;
      case 10001: 
        return 4;
      case 10000: 
        return 5;
        return 2;
        label64:
        return 3;
      }
    }
    return 1;
  }
  
  public static int b(FeedItem paramFeedItem)
  {
    int j = 0;
    if (paramFeedItem == null) {
      return 0;
    }
    int k = paramFeedItem.type;
    int i = 2;
    if (k != 1) {
      if (k != 2)
      {
        if ((k != 3) && (k != 5)) {
          return 0;
        }
      }
      else
      {
        paramFeedItem = (ShareGroupItem)paramFeedItem.getOwner();
        if (paramFeedItem.isOwner()) {
          i = 1;
        } else if (paramFeedItem.isSubscribe()) {
          i = 2;
        } else {
          i = 3;
        }
        if (i == 1) {
          return 3;
        }
        if (i == 2) {
          return 4;
        }
        if (i == 3) {
          j = 5;
        }
        return j;
      }
    }
    if (paramFeedItem.getOwner().isMe()) {
      i = 1;
    }
    return i;
  }
  
  public static String b(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 4)
          {
            if (paramInt != 9) {
              return "";
            }
            return "9";
          }
          return "4";
        }
        return "2";
      }
      return "1";
    }
    return "0";
  }
  
  public static void b(String paramString, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    if ((paramInt1 == 10000) || (paramInt1 == 10001)) {
      a("video_edit_new", paramString, paramInt1, paramInt2, paramVarArgs);
    }
    if (jdField_a_of_type_JavaUtilList.contains(paramString))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("op_type", "video_edit_new");
      localHashMap.put("op_name", String.valueOf(paramString));
      localHashMap.put("op_result", String.valueOf(paramInt2));
      localHashMap.put("op_r1", a(0, paramVarArgs));
      localHashMap.put("op_r2", a(1, paramVarArgs));
      localHashMap.put("op_r3", a(2, paramVarArgs));
      localHashMap.put("op_r4", a(3, paramVarArgs));
      paramVarArgs = new StringBuilder();
      paramVarArgs.append("video_edit_new_");
      paramVarArgs.append(paramString);
      paramString = paramVarArgs.toString();
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, paramString, true, 0L, 0L, localHashMap, null);
    }
  }
  
  public static void b(String paramString1, String paramString2, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    try
    {
      if (SLog.a()) {
        SLog.b("StoryReportor", "Dev[op_type]%s;[op_name]%s;[op_in]%d;[op_result]%d;[d1]%s;[d2]%s;[d3]%s;[d4]%s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), a(0, paramVarArgs), a(1, paramVarArgs), a(2, paramVarArgs), a(3, paramVarArgs) });
      }
      label80:
      ReportController.b(null, "dc00899", "grp_story_engineer", "", paramString1, paramString2, paramInt1, paramInt2, a(0, paramVarArgs), a(1, paramVarArgs), a(2, paramVarArgs), a(3, paramVarArgs));
      return;
    }
    catch (Exception localException)
    {
      break label80;
    }
  }
  
  public static void c(String paramString1, String paramString2, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    try
    {
      if (SLog.a()) {
        SLog.b("StoryReportor", "Dev[op_type]%s;[op_name]%s;[op_in]%d;[op_result]%d;[d1]%s;[d2]%s;[d3]%s;[d4]%s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), a(0, paramVarArgs), a(1, paramVarArgs), a(2, paramVarArgs), a(3, paramVarArgs) });
      }
      label80:
      ReportController.b(null, "dc00899", "PGC_story", "", paramString1, paramString2, paramInt1, paramInt2, a(0, paramVarArgs), a(1, paramVarArgs), a(2, paramVarArgs), a(3, paramVarArgs));
      return;
    }
    catch (Exception localException)
    {
      break label80;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.support.report.StoryReportor
 * JD-Core Version:    0.7.0.1
 */