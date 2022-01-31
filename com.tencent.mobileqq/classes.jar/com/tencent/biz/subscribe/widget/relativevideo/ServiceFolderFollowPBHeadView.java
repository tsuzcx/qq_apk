package com.tencent.biz.subscribe.widget.relativevideo;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.subscribe.widget.StatusView;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import java.util.List;
import vvz;
import whc;
import whd;
import wye;

public class ServiceFolderFollowPBHeadView
  extends RelativeFeedBaseHeaderView
{
  private static String jdField_a_of_type_JavaLangString = "ServiceFolderFollowPBHeadView";
  private LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private StatusView jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView;
  private whd jdField_a_of_type_Whd;
  private boolean jdField_a_of_type_Boolean;
  private TextView b;
  
  public ServiceFolderFollowPBHeadView(Context paramContext)
  {
    super(paramContext);
  }
  
  public int a()
  {
    return 2131493889;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Whd != null) {
      this.jdField_a_of_type_Whd.a();
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.post(new ServiceFolderFollowPBHeadView.2(this, paramInt));
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_Boolean = vvz.a();
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131310146));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131310143));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131310144));
    this.b = ((TextView)paramView.findViewById(2131310139));
    this.jdField_a_of_type_Whd = new whd(getContext(), this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView);
    this.jdField_a_of_type_Whd.a(this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Whd);
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new LinearLayoutManager(getContext());
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.setOrientation(0);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
    ((GradientDrawable)this.jdField_a_of_type_AndroidWidgetLinearLayout.getBackground()).setColor(Color.parseColor("#00cafc"));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new whc(this));
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView = ((StatusView)paramView.findViewById(2131310147));
    if (this.jdField_a_of_type_Boolean) {
      this.b.setTextColor(-10132123);
    }
  }
  
  public void a(Object paramObject) {}
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView != null)
    {
      if (!paramBoolean) {
        break label38;
      }
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.c();
      if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.getVisibility() == 8) {
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.a();
      }
    }
    label38:
    while (this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.getVisibility() != 0) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.b();
  }
  
  public void setData(Object paramObject)
  {
    paramObject = (List)paramObject;
    if (this.jdField_a_of_type_Whd != null) {
      this.jdField_a_of_type_Whd.a(paramObject);
    }
  }
  
  public void setDragHost(DragFrameLayout paramDragFrameLayout)
  {
    if (this.jdField_a_of_type_Whd != null) {
      this.jdField_a_of_type_Whd.a(paramDragFrameLayout);
    }
  }
  
  public void setTopBannerVisibility(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getVisibility() == 8)
      {
        this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(0);
        wye.a("auth_follow", "service_exp", 0, 0, new String[0]);
      }
    }
    while (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getVisibility() != 0) {
      return;
    }
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.ServiceFolderFollowPBHeadView
 * JD-Core Version:    0.7.0.1
 */