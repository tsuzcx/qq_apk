package com.tencent.mobileqq.app.parser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class FTSSearchOpenMixWebAction
  extends JumpActionBase
{
  public FTSSearchOpenMixWebAction(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  public boolean a()
  {
    try
    {
      boolean bool = d();
      return bool;
    }
    catch (Exception localException)
    {
      QLog.e("FTSSearchOpenMixWebAction", 1, "doAction error: " + localException.getMessage());
      a("FTSSearchOpenMixWebAction");
    }
    return false;
  }
  
  public boolean d()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("url")) {
      this.jdField_a_of_type_JavaUtilHashMap.remove("url");
    }
    Object localObject = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      localIntent.putExtra((String)localEntry.getKey(), Uri.decode((String)localEntry.getValue()));
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("weburl")) {}
    for (localObject = Uri.decode((String)this.jdField_a_of_type_JavaUtilHashMap.get("weburl")); (((String)localObject).startsWith("https://sou.qq.com/")) || (((String)localObject).startsWith("https://sou.html5.qq.com/")); localObject = "")
    {
      localIntent.putExtra("url", (String)localObject);
      localIntent.putExtra("fragment_class", "com.tencent.mobileqq.search.activity.MixSearchWebFragment");
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      if (((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) && (!"1".equals(this.jdField_a_of_type_JavaUtilHashMap.get("openanimtype")))) {
        ((Activity)this.jdField_a_of_type_AndroidContentContext).overridePendingTransition(0, 0);
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.FTSSearchOpenMixWebAction
 * JD-Core Version:    0.7.0.1
 */