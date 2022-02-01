package com.tencent.biz.qqcircle.launcher.parser;

import android.content.Context;
import android.content.Intent;
import com.tencent.biz.qqcircle.activity.QCircleTransFragmentActivity;
import com.tencent.biz.qqcircle.fragments.content.QCircleFlutterContentDetailTransFragment;
import com.tencent.biz.qqcircle.richframework.util.FastClickUtils;
import cooperation.qqcircle.beans.QCircleSchemeBean;
import java.util.HashMap;

public class QCircleFlutterTransSchemeParser
  extends QCircleBaseSchemeParser
{
  public void a(Context paramContext, QCircleSchemeBean paramQCircleSchemeBean)
  {
    a(paramContext, paramQCircleSchemeBean.getAttrs());
  }
  
  public void a(Context paramContext, HashMap<String, String> paramHashMap)
  {
    if (!FastClickUtils.a("QCircleBaseSchemeParserlaunchPage", 500L))
    {
      if (paramContext == null) {
        return;
      }
      Intent localIntent = new Intent();
      localIntent.addFlags(268435456);
      localIntent.setClass(paramContext, QCircleTransFragmentActivity.class);
      localIntent.addFlags(65536);
      localIntent.putExtra("public_fragment_window_feature", 1);
      localIntent.putExtra("public_fragment_class", QCircleFlutterContentDetailTransFragment.class.getName());
      localIntent.putExtra("type", (String)paramHashMap.get("type"));
      paramContext.startActivity(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.launcher.parser.QCircleFlutterTransSchemeParser
 * JD-Core Version:    0.7.0.1
 */