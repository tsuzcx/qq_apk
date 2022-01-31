package com.tencent.mobileqq.apollo.plusPanel;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.BaseApplication;

public class MoreAppItemHandler
  extends AppItemHandler
{
  public Drawable a()
  {
    return BaseApplicationImpl.getContext().getResources().getDrawable(2130838705);
  }
  
  public String a()
  {
    return "更多";
  }
  
  public void a()
  {
    Intent localIntent = new Intent(BaseApplicationImpl.getContext(), QQBrowserActivity.class);
    VasWebviewUtil.openQQBrowserActivity(BaseApplicationImpl.getContext(), ApolloConstant.ae, -1L, localIntent, false, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.plusPanel.MoreAppItemHandler
 * JD-Core Version:    0.7.0.1
 */