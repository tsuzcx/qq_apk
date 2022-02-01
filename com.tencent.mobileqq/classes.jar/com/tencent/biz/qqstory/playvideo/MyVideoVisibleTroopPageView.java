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
  int jdField_a_of_type_Int = -1;
  Dialog jdField_a_of_type_AndroidAppDialog;
  Context jdField_a_of_type_AndroidContentContext;
  GestureDetector jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this.jdField_a_of_type_AndroidContentContext, new MyVideoVisibleTroopPageView.3(this));
  TroopManager jdField_a_of_type_ComTencentMobileqqAppTroopManager;
  
  public MyVideoVisibleTroopPageView(Dialog paramDialog, Context paramContext, List<TroopInfo> paramList, TroopManager paramTroopManager)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidAppDialog = paramDialog;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    LayoutInflater.from(paramContext).inflate(2131561832, this, true);
    paramDialog = new MyVideoVisibleTroopPageView.1(this);
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      XListView localXListView = (XListView)findViewById(2131370110);
      paramContext = new MyVideoVisibleTroopPageView.TroopListAdapter(this, paramContext);
      this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = paramTroopManager;
      paramContext.a(paramList);
      localXListView.setAdapter(paramContext);
      localXListView.setVisibility(0);
      localXListView.setOnScrollListener(new MyVideoVisibleTroopPageView.2(this));
      localXListView.setOnTouchListener(paramDialog);
      return;
    }
    paramContext = (TextView)findViewById(2131381180);
    paramList = findViewById(2131376778);
    paramContext.setText(HardCodeUtil.a(2131707093));
    paramContext.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(2130846644), null, null);
    paramList.setVisibility(0);
    paramList.setOnTouchListener(paramDialog);
  }
  
  public String a()
  {
    return HardCodeUtil.a(2131707092);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.MyVideoVisibleTroopPageView
 * JD-Core Version:    0.7.0.1
 */