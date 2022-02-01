package com.tencent.mobileqq.app.parser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class FTSSearchOpenMixWebAction
  extends JumpAction
{
  public FTSSearchOpenMixWebAction(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  public boolean a()
  {
    try
    {
      boolean bool = b();
      return bool;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doAction error: ");
      localStringBuilder.append(localException.getMessage());
      QLog.e("FTSSearchOpenMixWebAction", 1, localStringBuilder.toString());
      h_("FTSSearchOpenMixWebAction");
    }
    return false;
  }
  
  public boolean b()
  {
    Intent localIntent = new Intent(this.b, QQBrowserActivity.class);
    if (this.f.containsKey("url")) {
      this.f.remove("url");
    }
    Object localObject = this.f.entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      localIntent.putExtra((String)localEntry.getKey(), Uri.decode((String)localEntry.getValue()));
    }
    if (this.f.containsKey("weburl")) {
      localObject = Uri.decode((String)this.f.get("weburl"));
    } else {
      localObject = "";
    }
    if ((!((String)localObject).startsWith("https://sou.qq.com/")) && (!((String)localObject).startsWith("https://sou.html5.qq.com/"))) {
      return false;
    }
    localIntent.putExtra("url", (String)localObject);
    localIntent.putExtra("fragment_class", "com.tencent.mobileqq.search.activity.MixSearchWebFragment");
    this.b.startActivity(localIntent);
    if (((this.b instanceof Activity)) && (!"1".equals(this.f.get("openanimtype")))) {
      ((Activity)this.b).overridePendingTransition(0, 0);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.FTSSearchOpenMixWebAction
 * JD-Core Version:    0.7.0.1
 */