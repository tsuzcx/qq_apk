package com.tencent.biz.qqstory.playvideo;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.widget.XListView;
import java.util.List;
import nmc;
import nmd;
import nme;

public class MyVideoVisibleTroopPageView
  extends RelativeLayout
{
  public int a;
  public Dialog a;
  Context jdField_a_of_type_AndroidContentContext;
  public GestureDetector a;
  TroopManager jdField_a_of_type_ComTencentMobileqqAppTroopManager;
  
  public MyVideoVisibleTroopPageView(Dialog paramDialog, Context paramContext, List paramList, TroopManager paramTroopManager)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this.jdField_a_of_type_AndroidContentContext, new nme(this));
    this.jdField_a_of_type_AndroidAppDialog = paramDialog;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    LayoutInflater.from(paramContext).inflate(2130970851, this, true);
    paramDialog = new nmc(this);
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      XListView localXListView = (XListView)findViewById(2131364021);
      paramContext = new MyVideoVisibleTroopPageView.TroopListAdapter(this, paramContext);
      this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = paramTroopManager;
      paramContext.a(paramList);
      localXListView.setAdapter(paramContext);
      localXListView.setVisibility(0);
      localXListView.setOnScrollListener(new nmd(this));
      localXListView.setOnTouchListener(paramDialog);
      return;
    }
    paramContext = (TextView)findViewById(2131368953);
    paramList = findViewById(2131371985);
    paramContext.setText("没有可见的群");
    paramContext.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(2130843288), null, null);
    paramList.setVisibility(0);
    paramList.setOnTouchListener(paramDialog);
  }
  
  public String a()
  {
    return "可见的群";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.MyVideoVisibleTroopPageView
 * JD-Core Version:    0.7.0.1
 */