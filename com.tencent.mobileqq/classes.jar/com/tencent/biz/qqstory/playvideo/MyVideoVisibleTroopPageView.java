package com.tencent.biz.qqstory.playvideo;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.widget.XListView;
import java.util.List;

public class MyVideoVisibleTroopPageView
  extends RelativeLayout
{
  Context a;
  TroopManager b;
  int c = -1;
  Dialog d;
  GestureDetector e = new GestureDetector(this.a, new MyVideoVisibleTroopPageView.3(this));
  
  public MyVideoVisibleTroopPageView(Dialog paramDialog, Context paramContext, List<TroopInfo> paramList, TroopManager paramTroopManager)
  {
    super(paramContext);
    this.d = paramDialog;
    this.a = paramContext;
    LayoutInflater.from(paramContext).inflate(2131628211, this, true);
    paramDialog = new MyVideoVisibleTroopPageView.1(this);
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      XListView localXListView = (XListView)findViewById(2131437272);
      paramContext = new MyVideoVisibleTroopPageView.TroopListAdapter(this, paramContext);
      this.b = paramTroopManager;
      paramContext.a(paramList);
      localXListView.setAdapter(paramContext);
      localXListView.setVisibility(0);
      localXListView.setOnScrollListener(new MyVideoVisibleTroopPageView.2(this));
      localXListView.setOnTouchListener(paramDialog);
      return;
    }
    paramContext = (TextView)findViewById(2131450229);
    paramList = findViewById(2131445073);
    paramContext.setText(HardCodeUtil.a(2131904931));
    paramContext.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(2130848196), null, null);
    paramList.setVisibility(0);
    paramList.setOnTouchListener(paramDialog);
  }
  
  public String getTabTitle()
  {
    return HardCodeUtil.a(2131904930);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.MyVideoVisibleTroopPageView
 * JD-Core Version:    0.7.0.1
 */