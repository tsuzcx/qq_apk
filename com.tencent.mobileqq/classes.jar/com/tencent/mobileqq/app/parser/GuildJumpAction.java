package com.tencent.mobileqq.app.parser;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.QPublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.mainframe.GuildMainFrameConstants;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class GuildJumpAction
  extends JumpAction
{
  protected GuildJumpAction(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext)
  {
    super(paramBaseQQAppInterface, paramContext);
  }
  
  private void e()
  {
    ((IGuildMainFrameApi)QRoute.api(IGuildMainFrameApi.class)).gotoGuildTab(this.b, GuildMainFrameConstants.p, null);
  }
  
  private void f()
  {
    QLog.d("QQGuildJumpAction", 4, "gotoShare!!");
    ((IQQGuildRouterApi)QRoute.api(IQQGuildRouterApi.class)).addGuildByShareUrl(this.b, this.c);
  }
  
  public void a(Intent paramIntent)
  {
    QPublicFragmentActivity.Launcher.a(this.b, paramIntent, QPublicTransFragmentActivity.class, ((IGuildFeatureAdapterApi)QRoute.api(IGuildFeatureAdapterApi.class)).getGuildOpenVerifyFragmentClass());
  }
  
  public boolean a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doAction: action=");
    localStringBuilder.append(this.e);
    QLog.i("QQGuildJumpAction", 1, localStringBuilder.toString());
    if ("create".equals(this.e))
    {
      b();
      return true;
    }
    if ("join".equals(this.e))
    {
      c();
      return true;
    }
    if ("show".equals(this.e))
    {
      e();
      return true;
    }
    if ("share".equals(this.e)) {
      f();
    }
    return true;
  }
  
  public void b()
  {
    Intent localIntent = new Intent();
    Bundle localBundle = d();
    localBundle.putString("extra_action", "create");
    localIntent.putExtra("key_params", localBundle);
    a(localIntent);
  }
  
  public void c()
  {
    Intent localIntent = new Intent();
    Bundle localBundle = d();
    localBundle.putString("extra_action", "join");
    localIntent.putExtra("key_params", localBundle);
    a(localIntent);
  }
  
  public Bundle d()
  {
    Bundle localBundle = new Bundle();
    Iterator localIterator = this.f.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str = (String)localEntry.getValue();
      if (!TextUtils.isEmpty(str)) {
        localBundle.putString((String)localEntry.getKey(), str);
      }
    }
    localBundle.putString("pkg_name", this.i);
    localBundle.putString("pkg_sig", this.j);
    localBundle.putString("extra_raw_url", this.c);
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.GuildJumpAction
 * JD-Core Version:    0.7.0.1
 */