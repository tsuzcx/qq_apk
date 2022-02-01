package com.tencent.mobileqq.activity.aio.intimate.view;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.intimate.BaseIntimateView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.data.IntimateInfo.CommonBody;
import com.tencent.mobileqq.data.IntimateInfo.FriendGiftInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import java.util.Iterator;
import java.util.List;

public class IntimateContentItemGiftView
  extends IntimateContentItemBaseView
{
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private IntimateContentItemGiftView.FriendGiftAdapter jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemGiftView$FriendGiftAdapter;
  private HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  private TextView b;
  private int c = 1;
  private boolean d = false;
  
  public IntimateContentItemGiftView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public IntimateContentItemGiftView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public IntimateContentItemGiftView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void a()
  {
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559255, this, true);
    this.jdField_a_of_type_AndroidViewView = localView.findViewById(2131367314);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131367315));
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)localView.findViewById(2131367318));
    this.b = ((TextView)localView.findViewById(2131367317));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemGiftView$FriendGiftAdapter = new IntimateContentItemGiftView.FriendGiftAdapter(this, null);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setDividerWidth(ViewUtils.a(5.0F));
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemGiftView$FriendGiftAdapter);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnTouchListener(this);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setTransTouchStateToParent(true);
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(this);
  }
  
  protected void a(View paramView)
  {
    if (paramView.getId() != 2131367314) {
      return;
    }
    paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a(), QQBrowserActivity.class);
    String str = this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.friendGiftInfo.str_custom_url;
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, String.format("goToFriendGiftWebPage, url: %s", new Object[] { str }));
    }
    paramView.putExtra("url", str);
    paramView.putExtra("finish_animation_out_to_right", true);
    paramView.putExtra("is_wrap_content", true);
    paramView.putExtra("hide_left_button", false);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a() != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a().startActivity(paramView);
    }
    ReportController.b(null, "dc00898", "", "", "0X800A3B4", "0X800A3B4", this.c, 0, "", "", "", "");
  }
  
  protected void a(IntimateInfo paramIntimateInfo, int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(paramIntimateInfo.friendGiftInfo.str_send_times));
    this.b.setText(paramIntimateInfo.friendGiftInfo.str_desc);
    if (paramIntimateInfo.friendGiftInfo.str_gift_url.size() > 6) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemGiftView$FriendGiftAdapter.a(paramIntimateInfo.friendGiftInfo.str_gift_url.subList(0, 6));
    } else {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemGiftView$FriendGiftAdapter.a(paramIntimateInfo.friendGiftInfo.str_gift_url);
    }
    if (this.d) {
      ReportController.b(null, "dc00898", "", "", "0X800A3B3", "0X800A3B3", this.c, 0, "", "", "", "");
    }
  }
  
  protected boolean a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.commonBodyList != null) && (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.commonBodyList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.commonBodyList.iterator();
      while (localIterator.hasNext())
      {
        IntimateInfo.CommonBody localCommonBody = (IntimateInfo.CommonBody)localIterator.next();
        if (localCommonBody.cmd == 3436)
        {
          this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.friendGiftInfo = IntimateInfo.FriendGiftInfo.copyFrom(localCommonBody);
          if ((this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.friendGiftInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.friendGiftInfo.str_send_times > 0)) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public void setNeedReportPage(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void setReportType(int paramInt)
  {
    this.c = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemGiftView
 * JD-Core Version:    0.7.0.1
 */