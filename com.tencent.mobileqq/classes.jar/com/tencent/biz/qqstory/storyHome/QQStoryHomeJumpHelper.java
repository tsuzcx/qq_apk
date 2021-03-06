package com.tencent.biz.qqstory.storyHome;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryNodeConfigManager;
import com.tencent.biz.qqstory.playmode.util.StoryTagUtil;
import com.tencent.biz.qqstory.playvideo.StoryPlayerLauncher;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tencent.biz.qqstory.storyHome.memory.QQStoryMemoriesActivity;
import com.tencent.biz.qqstory.storyHome.messagenotify.StoryMessageListActivity;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.utils.JumpActionLegacy;
import java.util.HashMap;
import org.json.JSONObject;

public class QQStoryHomeJumpHelper
{
  private Activity a;
  private QQStoryHomeJumpHelper.JumpListener b;
  
  public QQStoryHomeJumpHelper(Activity paramActivity, QQStoryHomeJumpHelper.JumpListener paramJumpListener)
  {
    this.a = paramActivity;
    this.b = paramJumpListener;
  }
  
  public static void a(Activity paramActivity, Intent paramIntent)
  {
    long l = paramIntent.getLongExtra("qq_number", -1L);
    int i = paramIntent.getIntExtra("source", 0);
    paramIntent = paramIntent.getStringExtra("union_id");
    if (TextUtils.isEmpty(paramIntent))
    {
      QQStoryMemoriesActivity.a(paramActivity, i, l);
      return;
    }
    StoryApi.a(paramActivity, i, paramIntent);
  }
  
  public static void b(Activity paramActivity, Intent paramIntent)
  {
    Object localObject = paramIntent.getStringExtra("union_id");
    int i = paramIntent.getIntExtra("source", 0);
    paramIntent = paramIntent.getStringExtra("extra_share_from_uid");
    localObject = QQStoryShareGroupProfileActivity.b(paramActivity, 2, (String)localObject, null, i, 0);
    ((Intent)localObject).putExtra("extra_share_from_user_uid", paramIntent);
    paramActivity.startActivity((Intent)localObject);
  }
  
  public static void c(Activity paramActivity, Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("tag_id");
    paramIntent = paramIntent.getStringExtra("tag_type");
    if ((str != null) && (paramIntent != null))
    {
      StoryTagUtil.a(paramActivity, str, paramIntent);
      return;
    }
    SLog.e("Q.qqstory.home.QQStoryHomeJumpHelper", "handleOpenTagAction parm error");
  }
  
  public static void d(Activity paramActivity, Intent paramIntent)
  {
    paramIntent = (StoryConfigManager)SuperManager.a(10);
    Object localObject = "";
    String str = (String)paramIntent.c("mainHallConfig", "");
    paramIntent = (Intent)localObject;
    if (!TextUtils.isEmpty(str)) {
      try
      {
        paramIntent = new JSONObject(str).optString("url");
      }
      catch (Exception paramIntent)
      {
        SLog.d("Q.qqstory.home.QQStoryHomeJumpHelper", "analyze config error , error :%s", new Object[] { paramIntent.getMessage() });
        paramIntent = (Intent)localObject;
      }
    }
    if (TextUtils.isEmpty(paramIntent))
    {
      SLog.d("Q.qqstory.home.QQStoryHomeJumpHelper", "square config not ready , use default config instead");
      return;
    }
    localObject = new Intent(paramActivity, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", paramIntent);
    paramActivity.startActivity((Intent)localObject);
  }
  
  private void e(Intent paramIntent)
  {
    paramIntent = (HashMap)paramIntent.getSerializableExtra("extra_jump_attrs");
    String str = (String)paramIntent.get("parter_api");
    JumpActionLegacy.a(QQStoryContext.j(), this.a, paramIntent, str);
  }
  
  private void f(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("extra_share_from_type", -1);
    paramIntent.getLongExtra("extra_topic_id", -1L);
    paramIntent.getStringExtra("extra_topic_name");
    paramIntent = new StringBuilder();
    paramIntent.append(i);
    paramIntent.append("");
    JumpActionLegacy.j(paramIntent.toString());
  }
  
  private void g(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("extra_share_from_type", -1);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(i);
    localStringBuilder.append("");
    JumpActionLegacy.j(localStringBuilder.toString());
    "1".equals(paramIntent.getStringExtra("to_new_version"));
  }
  
  private void h(Intent paramIntent)
  {
    paramIntent.getStringExtra("EXTRA_USER_UIN");
    String str = paramIntent.getStringExtra("EXTRA_USER_UNION_ID");
    paramIntent.getBooleanExtra("extra_is_show_info_card", false);
    paramIntent.getIntExtra("extra_share_from_type", 0);
    StoryApi.a(this.a, 23, str);
  }
  
  private void i(Intent paramIntent) {}
  
  public void a(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("usertype", 0);
    String str = paramIntent.getStringExtra("unionid");
    paramIntent.getStringExtra("userid");
    paramIntent.getBooleanExtra("showinfocard", true);
    paramIntent.getIntExtra("storysharefrom", 0);
    if (i == 1) {
      StoryApi.a(this.a, 23, str);
    }
  }
  
  public boolean a(int paramInt, Intent paramIntent)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleAction=");
    localStringBuilder.append(paramInt);
    SLog.b("Q.qqstory.home.QQStoryHomeJumpHelper", localStringBuilder.toString());
    switch (paramInt)
    {
    case 3: 
    default: 
      return false;
    case 15: 
      d(this.a, paramIntent);
      return true;
    case 14: 
      c(this.a, paramIntent);
      return true;
    case 13: 
      b(this.a, paramIntent);
      return true;
    case 12: 
      g(paramIntent);
      return true;
    case 11: 
      a(this.a, paramIntent);
      return true;
    case 10: 
      d(paramIntent);
      return true;
    case 9: 
      c(paramIntent);
      return true;
    case 8: 
      b(paramIntent);
      return true;
    case 7: 
      h(paramIntent);
      return true;
    case 6: 
      i(paramIntent);
      return true;
    case 5: 
      e(paramIntent);
      return true;
    case 4: 
      f(paramIntent);
      return true;
    case 2: 
      a(paramIntent);
      return true;
    }
    this.a.setIntent(paramIntent);
    this.b.a(false, true, 16, null);
    return true;
  }
  
  protected void b(Intent paramIntent)
  {
    Intent localIntent = new Intent(this.a, StoryMessageListActivity.class);
    if (((MsgTabStoryNodeConfigManager)QQStoryContext.j().getManager(QQManagerFactory.MSG_TAB_STORY_CONFIG_MANAGER)).a) {
      paramIntent.putExtra("qqstory_message_list_source", 2);
    }
    localIntent.replaceExtras(paramIntent.getExtras());
    this.a.startActivity(localIntent);
  }
  
  protected void c(Intent paramIntent)
  {
    paramIntent = paramIntent.getSerializableExtra("EXTRA_PLAY_INFO");
    if (paramIntent == null)
    {
      SLog.e("Q.qqstory.home.QQStoryHomeJumpHelper", "handle open play list error , no play info !");
      return;
    }
    StoryPlayerLauncher.a(this.a, paramIntent, 31, null);
  }
  
  protected void d(Intent paramIntent)
  {
    Intent localIntent = new Intent(this.a, QQBrowserActivity.class);
    localIntent.replaceExtras(paramIntent.getExtras());
    this.a.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.QQStoryHomeJumpHelper
 * JD-Core Version:    0.7.0.1
 */