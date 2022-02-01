package com.tencent.mobileqq.activity.framebusiness.controllerinject;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class TabUIHelper
{
  private static ITabDataUtil a;
  
  static
  {
    try
    {
      a = (ITabDataUtil)((Class)TabDataUtil.a.get(0)).newInstance();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("TabUIHelper", 1, "TabUIHelper static statement: ", localException);
    }
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject1 = new HashMap();
    ((HashMap)localObject1).put("NEW_WORLD", "“小世界”");
    ((HashMap)localObject1).put("GUILD", "“频道”");
    int i = 0;
    localObject1 = ((HashMap)localObject1).entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
      String str = (String)((Map.Entry)localObject2).getKey();
      localObject2 = (String)((Map.Entry)localObject2).getValue();
      if (paramString.contains(str))
      {
        if (i == 0)
        {
          localStringBuilder.append((String)localObject2);
        }
        else
        {
          localStringBuilder.append("和");
          localStringBuilder.append((String)localObject2);
        }
        i += 1;
      }
    }
    return localStringBuilder.toString();
  }
  
  public static void a(Context paramContext)
  {
    paramContext = DialogUtil.a(paramContext, 230).setMessage("QQ邀请你体验“小世界”，如需关闭，可在“设置-辅助功能”中进行设置。").setNegativeButton("好的", new TabUIHelper.6()).setPositiveButton("去设置", new TabUIHelper.5());
    paramContext.setCancelable(false);
    paramContext.show();
  }
  
  public static void a(Context paramContext, String paramString)
  {
    boolean bool = paramString.contains("“频道”");
    String str = "，如需关闭，可在“设置-辅助功能”中进行设置。";
    if ((!bool) || (!paramString.contains("“小世界”"))) {
      if (paramString.contains("“频道”")) {
        str = "，聚首畅谈喜爱事物，可在“设置-辅助功能”中进行设置。";
      } else if (paramString.contains("“小世界”")) {
        str = "，精彩视频刷不停，可在“设置-辅助功能”中进行设置。";
      }
    }
    paramContext = DialogUtil.a(paramContext, 230).setTitle("新功能上线");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QQ邀请你体验");
    localStringBuilder.append(paramString);
    localStringBuilder.append(str);
    paramContext = paramContext.setMessage(localStringBuilder.toString()).setNegativeButton("好的", new TabUIHelper.2(paramString)).setPositiveButton("去设置", new TabUIHelper.1(paramString));
    paramContext.setCancelable(false);
    paramContext.show();
  }
  
  public static void b(Context paramContext, String paramString)
  {
    paramContext = DialogUtil.a(paramContext, 230);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QQ邀请你体验");
    localStringBuilder.append(paramString);
    localStringBuilder.append("，如需关闭，可在“设置-辅助功能”中进行设置。");
    paramContext = paramContext.setMessage(localStringBuilder.toString()).setNegativeButton("好的", new TabUIHelper.4(paramString)).setPositiveButton("去设置", new TabUIHelper.3(paramString));
    paramContext.setCancelable(false);
    paramContext.show();
  }
  
  public static void c(Context paramContext, String paramString)
  {
    if (TabDataHelper.getTabFirstNewWorldWithRIJOn(paramContext, paramString))
    {
      str = TabDataHelper.getTabFirstShow(paramContext, paramString);
      if (!TextUtils.isEmpty(str))
      {
        str = a(str);
        TabControlReporter.b(str.contains("“频道”"));
        b(paramContext, str);
        TabDataHelper.updateTabFirstNewWorldWithRIJOn(paramContext, paramString, false);
        TabDataHelper.cleanTabFirstShow(paramContext, paramString);
      }
    }
    String str = TabDataHelper.getTabFirstShow(paramContext, paramString);
    if (!TextUtils.isEmpty(str))
    {
      TabControlReporter.a(str);
      a(paramContext, a(str));
      TabDataHelper.cleanTabFirstShow(paramContext, paramString);
    }
    if (TabDataHelper.getTabFixNewWorldWithRIJOn(paramContext, paramString))
    {
      TabControlReporter.a();
      a(paramContext);
      TabDataHelper.updateTabFixNewWorldWithRIJOn(paramContext, paramString, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.framebusiness.controllerinject.TabUIHelper
 * JD-Core Version:    0.7.0.1
 */