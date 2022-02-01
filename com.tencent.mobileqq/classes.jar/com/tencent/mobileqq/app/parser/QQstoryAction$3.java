package com.tencent.mobileqq.app.parser;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qqstory.storyHome.QQStoryHomeJumpHelper.JumpListener;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo2.StoryPublishLauncher;

class QQstoryAction$3
  implements QQStoryHomeJumpHelper.JumpListener
{
  QQstoryAction$3(QQstoryAction paramQQstoryAction) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString)
  {
    paramString = StoryPublishLauncher.a();
    String str1 = ((Activity)this.a.b).getIntent().getStringExtra("from_type");
    paramInt = ((Activity)this.a.b).getIntent().getIntExtra("capture_intent_mode", -1);
    int i = ((Activity)this.a.b).getIntent().getIntExtra("firsttab", -1);
    int j = ((Activity)this.a.b).getIntent().getIntExtra("secondtab", -1);
    String str2 = ((Activity)this.a.b).getIntent().getStringExtra("itemid");
    int k = ((Activity)this.a.b).getIntent().getIntExtra("key_finish_jump_to_page", 1);
    String str3 = ((Activity)this.a.b).getIntent().getStringExtra("web_dispatch_event");
    Bundle localBundle = new Bundle();
    if (TextUtils.equals(str1, "msgTab")) {
      localBundle.putInt("entrance_type", 103);
    } else if (TextUtils.equals(str1, "msgTabNew")) {
      localBundle.putInt("entrance_type", 119);
    } else {
      localBundle.putInt("entrance_type", 15);
    }
    localBundle.putInt("key_finish_jump_to_page", k);
    if (!TextUtils.isEmpty(str3)) {
      localBundle.putString("web_dispatch_event", str3);
    }
    if (paramInt != -1) {
      paramString.a((Activity)this.a.b, localBundle, 2, paramInt, i, j, str2, "", "", true, 20000);
    } else {
      paramString.a((Activity)this.a.b, localBundle, 20000);
    }
    SLog.c("Q.qqstory.publish.QQstoryAction", "launchNewVideoTakeActivity by StoryPublishLauncher");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.QQstoryAction.3
 * JD-Core Version:    0.7.0.1
 */