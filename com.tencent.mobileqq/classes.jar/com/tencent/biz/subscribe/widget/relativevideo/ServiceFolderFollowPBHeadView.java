package com.tencent.biz.subscribe.widget.relativevideo;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.tencent.biz.subscribe.SubscribeUtils;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import java.util.List;

public class ServiceFolderFollowPBHeadView
  extends RelativeFeedBaseHeaderView
{
  private static String jdField_a_of_type_JavaLangString = "ServiceFolderFollowPBHeadView";
  private LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ViewPager jdField_a_of_type_AndroidxViewpagerWidgetViewPager;
  private ServiceFolderFollowPBHeadView.ServiceAccountFoldAdapter jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView$ServiceAccountFoldAdapter;
  private boolean jdField_a_of_type_Boolean = false;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  
  public ServiceFolderFollowPBHeadView(Context paramContext)
  {
    super(paramContext);
  }
  
  public int a()
  {
    return 2131559636;
  }
  
  public void a()
  {
    ServiceFolderFollowPBHeadView.ServiceAccountFoldAdapter localServiceAccountFoldAdapter = this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView$ServiceAccountFoldAdapter;
    if (localServiceAccountFoldAdapter != null) {
      localServiceAccountFoldAdapter.b();
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.post(new ServiceFolderFollowPBHeadView.2(this, paramInt));
  }
  
  protected void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_Boolean = SubscribeUtils.a();
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131377280));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131377277));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377278));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377273));
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView$ServiceAccountFoldAdapter = new ServiceFolderFollowPBHeadView.ServiceAccountFoldAdapter(getContext(), this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView);
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView$ServiceAccountFoldAdapter.a(this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView$ServiceAccountFoldAdapter);
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView$ServiceAccountFoldAdapter.a();
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new LinearLayoutManager(getContext());
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.setOrientation(0);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131366273));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366272));
    paramContext = URLDrawable.getDrawable("https://sola.gtimg.cn/aoi/sola/20201119210154_6KQkLOzrpX.png", null);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramContext);
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout.getBackground() != null) && ((this.jdField_a_of_type_AndroidWidgetLinearLayout.getBackground() instanceof GradientDrawable))) {
      ((GradientDrawable)this.jdField_a_of_type_AndroidWidgetLinearLayout.getBackground()).setColor(Color.parseColor("#00cafc"));
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new ServiceFolderFollowPBHeadView.1(this));
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-10132123);
    }
  }
  
  protected void a(Object paramObject) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      if (!TextUtils.isEmpty(paramString)) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void setData(Object paramObject)
  {
    paramObject = (List)paramObject;
    ServiceFolderFollowPBHeadView.ServiceAccountFoldAdapter localServiceAccountFoldAdapter = this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView$ServiceAccountFoldAdapter;
    if (localServiceAccountFoldAdapter != null) {
      localServiceAccountFoldAdapter.a(paramObject);
    }
  }
  
  public void setDragHost(DragFrameLayout paramDragFrameLayout)
  {
    ServiceFolderFollowPBHeadView.ServiceAccountFoldAdapter localServiceAccountFoldAdapter = this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView$ServiceAccountFoldAdapter;
    if (localServiceAccountFoldAdapter != null) {
      localServiceAccountFoldAdapter.a(paramDragFrameLayout);
    }
  }
  
  public void setJumpWebMessageListUrl(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void setTopBannerVisibility(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getVisibility() == 8)
      {
        this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(0);
        VSReporter.a("auth_follow", "service_exp", 0, 0, new String[0]);
      }
    }
    else if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getVisibility() == 0) {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(8);
    }
  }
  
  public void setmFolderViewPager(ViewPager paramViewPager)
  {
    this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager = paramViewPager;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.ServiceFolderFollowPBHeadView
 * JD-Core Version:    0.7.0.1
 */