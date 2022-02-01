package com.tencent.mobileqq.activity.aio.intimate.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.intimate.BaseIntimateView;
import com.tencent.mobileqq.activity.aio.intimate.IntimateUtil;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.relationx.friendclue.FriendClueConfigHelper;
import com.tencent.mobileqq.relationx.friendclue.FriendClueReporter;

public class IntimateContentItemClueView
  extends IntimateContentItemBaseView
{
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  FriendClueConfigHelper jdField_a_of_type_ComTencentMobileqqRelationxFriendclueFriendClueConfigHelper;
  private Boolean jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
  
  public IntimateContentItemClueView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public IntimateContentItemClueView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public IntimateContentItemClueView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559252, this, true).findViewById(2131367298));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
  }
  
  protected void a(View paramView)
  {
    if (paramView.getId() != 2131367298) {
      return;
    }
    paramView = this.jdField_a_of_type_ComTencentMobileqqRelationxFriendclueFriendClueConfigHelper;
    if (paramView != null)
    {
      paramView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a());
      FriendClueReporter.b(1);
    }
  }
  
  protected void a(IntimateInfo paramIntimateInfo, int paramInt) {}
  
  protected boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRelationxFriendclueFriendClueConfigHelper == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRelationxFriendclueFriendClueConfigHelper = new FriendClueConfigHelper(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a());
      FriendClueConfigHelper localFriendClueConfigHelper = this.jdField_a_of_type_ComTencentMobileqqRelationxFriendclueFriendClueConfigHelper;
      this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(FriendClueConfigHelper.a());
    }
    else
    {
      this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(FriendClueConfigHelper.a());
    }
    if (IntimateUtil.a(this.jdField_a_of_type_Int)) {
      this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
    }
    return this.jdField_a_of_type_JavaLangBoolean.booleanValue();
  }
  
  protected void b()
  {
    super.b();
    if (this.jdField_a_of_type_JavaLangBoolean.booleanValue()) {
      FriendClueReporter.a(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemClueView
 * JD-Core Version:    0.7.0.1
 */