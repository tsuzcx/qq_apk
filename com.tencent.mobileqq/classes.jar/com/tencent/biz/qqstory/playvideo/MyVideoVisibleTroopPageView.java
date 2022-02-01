package com.tencent.biz.qqstory.playvideo;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anvx;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.widget.XListView;
import java.util.List;
import xam;
import xan;
import xao;
import xap;

public class MyVideoVisibleTroopPageView
  extends RelativeLayout
{
  public int a;
  public Dialog a;
  Context jdField_a_of_type_AndroidContentContext;
  public GestureDetector a;
  TroopManager jdField_a_of_type_ComTencentMobileqqAppTroopManager;
  
  public MyVideoVisibleTroopPageView(Dialog paramDialog, Context paramContext, List<TroopInfo> paramList, TroopManager paramTroopManager)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this.jdField_a_of_type_AndroidContentContext, new xao(this));
    this.jdField_a_of_type_AndroidAppDialog = paramDialog;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    LayoutInflater.from(paramContext).inflate(2131561866, this, true);
    paramDialog = new xam(this);
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      XListView localXListView = (XListView)findViewById(2131370180);
      paramContext = new xap(this, paramContext);
      this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = paramTroopManager;
      paramContext.a(paramList);
      localXListView.setAdapter(paramContext);
      localXListView.setVisibility(0);
      localXListView.setOnScrollListener(new xan(this));
      localXListView.setOnTouchListener(paramDialog);
      return;
    }
    paramContext = (TextView)findViewById(2131381514);
    paramList = findViewById(2131376917);
    paramContext.setText(anvx.a(2131706530));
    paramContext.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(2130846421), null, null);
    paramList.setVisibility(0);
    paramList.setOnTouchListener(paramDialog);
  }
  
  public String a()
  {
    return anvx.a(2131706529);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.MyVideoVisibleTroopPageView
 * JD-Core Version:    0.7.0.1
 */