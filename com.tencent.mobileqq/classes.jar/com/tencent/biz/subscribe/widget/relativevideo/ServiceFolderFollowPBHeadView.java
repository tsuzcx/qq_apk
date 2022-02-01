package com.tencent.biz.subscribe.widget.relativevideo;

import aace;
import aacf;
import aacg;
import aanb;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bdvn;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import java.util.List;
import zqn;

public class ServiceFolderFollowPBHeadView
  extends RelativeFeedBaseHeaderView
{
  private static String jdField_a_of_type_JavaLangString = "ServiceFolderFollowPBHeadView";
  private aacg jdField_a_of_type_Aacg;
  private ViewPager jdField_a_of_type_AndroidSupportV4ViewViewPager;
  private LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private boolean jdField_a_of_type_Boolean;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  
  public ServiceFolderFollowPBHeadView(Context paramContext)
  {
    super(paramContext);
  }
  
  public int a()
  {
    return 2131559684;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Aacg != null) {
      this.jdField_a_of_type_Aacg.b();
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.post(new ServiceFolderFollowPBHeadView.3(this, paramInt));
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_Boolean = zqn.a();
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131377432));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131377429));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377430));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377425));
    this.jdField_a_of_type_Aacg = new aacg(getContext(), this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView);
    this.jdField_a_of_type_Aacg.a(this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Aacg);
    this.jdField_a_of_type_Aacg.a();
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new LinearLayoutManager(getContext());
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.setOrientation(0);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131366219));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366218));
    paramContext = URLDrawable.getDrawable("https://sola.gtimg.cn/aoi/sola/20200530172043_bPKKBWfucM.png", null);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramContext);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131366217));
    if (bdvn.a()) {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    }
    for (;;)
    {
      ((GradientDrawable)this.jdField_a_of_type_AndroidWidgetLinearLayout.getBackground()).setColor(Color.parseColor("#00cafc"));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new aacf(this));
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-10132123);
      }
      return;
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new aace(this));
    }
  }
  
  public void a(Object paramObject) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  public void setData(Object paramObject)
  {
    paramObject = (List)paramObject;
    if (this.jdField_a_of_type_Aacg != null) {
      this.jdField_a_of_type_Aacg.a(paramObject);
    }
  }
  
  public void setDragHost(DragFrameLayout paramDragFrameLayout)
  {
    if (this.jdField_a_of_type_Aacg != null) {
      this.jdField_a_of_type_Aacg.a(paramDragFrameLayout);
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
        aanb.a("auth_follow", "service_exp", 0, 0, new String[0]);
      }
    }
    while (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getVisibility() != 0) {
      return;
    }
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(8);
  }
  
  public void setmFolderViewPager(ViewPager paramViewPager)
  {
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = paramViewPager;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.ServiceFolderFollowPBHeadView
 * JD-Core Version:    0.7.0.1
 */