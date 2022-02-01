package com.tencent.mobileqq.app.parser;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.intervideo.groupvideo.IGroupVideoManager;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class GroupVideoAction
  extends JumpAction
{
  public GroupVideoAction(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  private boolean c()
  {
    String str1 = (String)this.f.get("roomcode");
    String str2 = (String)this.f.get("fromid");
    String str3 = (String)this.f.get("isgroupcode");
    String str4 = (String)this.f.get("backtype");
    String str5 = (String)this.f.get("open_type");
    String str6 = (String)this.f.get("extra");
    IGroupVideoManager localIGroupVideoManager = (IGroupVideoManager)this.a.getManager(QQManagerFactory.GROUP_VIDEO_PLUGIN_MANAGER);
    try
    {
      i = Integer.parseInt(str3);
    }
    catch (Exception localException)
    {
      int i;
      label106:
      StringBuilder localStringBuilder;
      break label106;
    }
    i = 1;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("[goToGroupVideoPlugin], roomId:");
    localStringBuilder.append(str1);
    localStringBuilder.append(",fromId:");
    localStringBuilder.append(str2);
    localStringBuilder.append(" isGroupCode:");
    localStringBuilder.append(str3);
    QLog.i("GroupVideoAction", 1, localStringBuilder.toString());
    localIGroupVideoManager.a(this.b, str1, this.a.getCurrentUin(), i, "download", str2, str4, str5, str6);
    return true;
  }
  
  private boolean d()
  {
    Object localObject = (String)this.f.get("fromid");
    localObject = (IGroupVideoManager)this.a.getManager(QQManagerFactory.GROUP_VIDEO_PLUGIN_MANAGER);
    QLog.i("GroupVideoAction", 1, "[goToPreLoadGroupVideoPlugin]");
    ((IGroupVideoManager)localObject).a(null, 10L);
    return true;
  }
  
  public boolean a()
  {
    boolean bool = false;
    try
    {
      if ("openroom".equals(this.e)) {
        return c();
      }
      if ("preload".equals(this.e)) {
        bool = d();
      }
      return bool;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doAction error: ");
      localStringBuilder.append(localException.getMessage());
      QLog.e("GroupVideoAction", 1, localStringBuilder.toString());
      h_("GroupVideoAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.GroupVideoAction
 * JD-Core Version:    0.7.0.1
 */