package com.tencent.biz.qqstory.support.report;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.model.item.IFeedOwner;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.NetworkUtil;
import java.util.HashMap;

public class StoryReportor
{
  public static final String a;
  private static HashMap a;
  
  static
  {
    jdField_a_of_type_JavaLangString = StoryApi.a(2131432071);
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  @Deprecated
  public static int a(IFeedOwner paramIFeedOwner)
  {
    if (paramIFeedOwner == null) {
      return 4;
    }
    switch (paramIFeedOwner.getRelationType())
    {
    default: 
      return 4;
    case 0: 
      return 1;
    case 1: 
      return 2;
    }
    return 3;
  }
  
  public static int a(FeedItem paramFeedItem)
  {
    int i = 3;
    if (paramFeedItem == null) {
      return 0;
    }
    switch (paramFeedItem.type)
    {
    case 4: 
    default: 
      return 1;
    case 1: 
      paramFeedItem = (QQUserUIItem)paramFeedItem.getOwner();
      if (TextUtils.equals(QQStoryContext.a().b(), paramFeedItem.uid)) {
        return 4;
      }
      if (paramFeedItem.getRelationType() == 0) {
        return 1;
      }
      if (paramFeedItem.getRelationType() == 1) {
        return 2;
      }
      if (paramFeedItem.getRelationType() == 2) {
        return 3;
      }
      return 4;
    case 2: 
      paramFeedItem = (ShareGroupItem)paramFeedItem.getOwner();
      if (paramFeedItem.getRelationType() == 2) {
        return i;
      }
      if (paramFeedItem.isPublic()) {}
      for (i = 6;; i = 5) {
        break;
      }
    case 3: 
      return 7;
    case 5: 
      return 9;
    }
    return 10;
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 10: 
      return "1";
    case 11: 
      return "3";
    case 210: 
      return "2";
    case 211: 
      return "4";
    case 220: 
      return "2";
    case 221: 
      return "4";
    case 23: 
      return "2";
    case 12: 
      return "5";
    }
    return "6";
  }
  
  @NonNull
  public static String a(int paramInt, String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length <= paramInt)) {
      return "";
    }
    return paramVarArgs[paramInt];
  }
  
  public static String a(Context paramContext)
  {
    int i = 4;
    int j = NetworkUtil.a(paramContext);
    if (j == 1) {}
    for (;;)
    {
      return "" + i;
      if (j == 2) {
        i = 1;
      } else if (j == 3) {
        i = 2;
      } else if (j == 4) {
        i = 3;
      } else {
        i = 5;
      }
    }
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
    }
    while (bool) {
      if (i != 0)
      {
        return "2";
        i = 0;
      }
      else
      {
        return "1";
      }
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
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, MessageForStructing paramMessageForStructing, String paramString)
  {
    if (paramMessageForStructing == null) {}
    do
    {
      do
      {
        AbsStructMsg localAbsStructMsg;
        do
        {
          return;
          localAbsStructMsg = paramMessageForStructing.structingMsg;
        } while ((localAbsStructMsg == null) || (TextUtils.isEmpty(localAbsStructMsg.mMsg_A_ActionData)));
        paramContext = JumpParser.a(paramQQAppInterface, paramContext, localAbsStructMsg.mMsg_A_ActionData);
      } while (paramContext == null);
      paramQQAppInterface = paramContext.a("usertype");
      paramContext = paramContext.a("unionid");
    } while ((TextUtils.isEmpty(paramQQAppInterface)) || (TextUtils.isEmpty(paramContext)));
    try
    {
      i = Integer.parseInt(paramQQAppInterface);
      a("share_uin_obj", paramString, TroopUtils.b(paramMessageForStructing.istroop), i, new String[] { paramContext });
      return;
    }
    catch (NumberFormatException paramQQAppInterface)
    {
      for (;;)
      {
        int i = 0;
      }
    }
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
        SLog.d("StoryReportor", "[op_type]%s;[op_name]%s;[op_in]%d;[op_result]%d;[d1]%s;[d2]%s;[d3]%s;[d4]%s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), a(0, paramVarArgs), a(1, paramVarArgs), a(2, paramVarArgs), a(3, paramVarArgs) });
      }
      label78:
      ReportController.b(null, "dc00899", jdField_a_of_type_JavaLangString, "", paramString1, paramString2, paramInt1, paramInt2, a(0, paramVarArgs), a(1, paramVarArgs), a(2, paramVarArgs), a(3, paramVarArgs));
      return;
    }
    catch (Exception localException)
    {
      break label78;
    }
  }
  
  public static int b(FeedItem paramFeedItem)
  {
    if (paramFeedItem == null) {
      return 0;
    }
    int i;
    switch (paramFeedItem.type)
    {
    case 4: 
    default: 
      return 0;
    case 1: 
    case 3: 
    case 5: 
      if (paramFeedItem.getOwner().isMe()) {}
      for (i = 1;; i = 2) {
        return i;
      }
    }
    paramFeedItem = (ShareGroupItem)paramFeedItem.getOwner();
    if (paramFeedItem.isOwner())
    {
      i = 1;
      if (i != 1) {
        break label110;
      }
      i = 3;
    }
    for (;;)
    {
      return i;
      if (paramFeedItem.isSubscribe())
      {
        i = 2;
        break;
      }
      i = 3;
      break;
      label110:
      if (i == 2) {
        i = 4;
      } else if (i == 3) {
        i = 5;
      } else {
        i = 0;
      }
    }
  }
  
  public static void b(String paramString1, String paramString2, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    try
    {
      if (SLog.a()) {
        SLog.b("StoryReportor", "Dev[op_type]%s;[op_name]%s;[op_in]%d;[op_result]%d;[d1]%s;[d2]%s;[d3]%s;[d4]%s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), a(0, paramVarArgs), a(1, paramVarArgs), a(2, paramVarArgs), a(3, paramVarArgs) });
      }
      label78:
      ReportController.b(null, "dc00899", "grp_story_engineer", "", paramString1, paramString2, paramInt1, paramInt2, a(0, paramVarArgs), a(1, paramVarArgs), a(2, paramVarArgs), a(3, paramVarArgs));
      return;
    }
    catch (Exception localException)
    {
      break label78;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.support.report.StoryReportor
 * JD-Core Version:    0.7.0.1
 */