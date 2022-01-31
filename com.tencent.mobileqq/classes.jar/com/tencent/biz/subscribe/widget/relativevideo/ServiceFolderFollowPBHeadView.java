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
import xxl;
import yku;
import ykv;
import yvu;

public class ServiceFolderFollowPBHeadView
  extends RelativeFeedBaseHeaderView
{
  private static String jdField_a_of_type_JavaLangString = "ServiceFolderFollowPBHeadView";
  private LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private StatusView jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView;
  private ykv jdField_a_of_type_Ykv;
  private boolean jdField_a_of_type_Boolean;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  
  public ServiceFolderFollowPBHeadView(Context paramContext)
  {
    super(paramContext);
  }
  
  public int a()
  {
    return 2131559509;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.post(new ServiceFolderFollowPBHeadView.2(this, paramInt));
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_Boolean = xxl.a();
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131376411));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131376408));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376409));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376404));
    this.jdField_a_of_type_Ykv = new ykv(getContext(), this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView);
    this.jdField_a_of_type_Ykv.a(this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Ykv);
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new LinearLayoutManager(getContext());
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.setOrientation(0);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
    ((GradientDrawable)this.jdField_a_of_type_AndroidWidgetLinearLayout.getBackground()).setColor(Color.parseColor("#00cafc"));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new yku(this));
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView = ((StatusView)paramView.findViewById(2131376412));
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-10132123);
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
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.d();
      if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.getVisibility() == 8) {
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.b();
      }
    }
    label38:
    while (this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.getVisibility() != 0) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.c();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Ykv != null) {
      this.jdField_a_of_type_Ykv.a();
    }
  }
  
  public void setData(Object paramObject)
  {
    paramObject = (List)paramObject;
    if (this.jdField_a_of_type_Ykv != null) {
      this.jdField_a_of_type_Ykv.a(paramObject);
    }
  }
  
  public void setDragHost(DragFrameLayout paramDragFrameLayout)
  {
    if (this.jdField_a_of_type_Ykv != null) {
      this.jdField_a_of_type_Ykv.a(paramDragFrameLayout);
    }
  }
  
  public void setJumpWebMessageListUrl(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void setTopBannerVisibility(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getVisibility() == 8)
      {
        this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(0);
        yvu.a("auth_follow", "service_exp", 0, 0, new String[0]);
      }
    }
    while (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getVisibility() != 0) {
      return;
    }
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.ServiceFolderFollowPBHeadView
 * JD-Core Version:    0.7.0.1
 */