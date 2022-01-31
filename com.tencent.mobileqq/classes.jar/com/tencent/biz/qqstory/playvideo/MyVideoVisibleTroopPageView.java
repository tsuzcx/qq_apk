package com.tencent.biz.qqstory.playvideo;

import alpo;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.widget.XListView;
import java.util.List;
import viq;
import vir;
import vis;
import vit;

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
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this.jdField_a_of_type_AndroidContentContext, new vis(this));
    this.jdField_a_of_type_AndroidAppDialog = paramDialog;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    LayoutInflater.from(paramContext).inflate(2131561628, this, true);
    paramDialog = new viq(this);
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      XListView localXListView = (XListView)findViewById(2131369501);
      paramContext = new vit(this, paramContext);
      this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = paramTroopManager;
      paramContext.a(paramList);
      localXListView.setAdapter(paramContext);
      localXListView.setVisibility(0);
      localXListView.setOnScrollListener(new vir(this));
      localXListView.setOnTouchListener(paramDialog);
      return;
    }
    paramContext = (TextView)findViewById(2131380218);
    paramList = findViewById(2131375960);
    paramContext.setText(alpo.a(2131707438));
    paramContext.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(2130845888), null, null);
    paramList.setVisibility(0);
    paramList.setOnTouchListener(paramDialog);
  }
  
  public String a()
  {
    return alpo.a(2131707437);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.MyVideoVisibleTroopPageView
 * JD-Core Version:    0.7.0.1
 */