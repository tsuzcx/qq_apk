package com.tencent.mobileqq.activity.aio.intimate.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.intimate.BaseIntimateView;
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
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559377, this, true).findViewById(2131367540));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
  }
  
  protected void a(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
    } while (this.jdField_a_of_type_ComTencentMobileqqRelationxFriendclueFriendClueConfigHelper == null);
    this.jdField_a_of_type_ComTencentMobileqqRelationxFriendclueFriendClueConfigHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a());
    FriendClueReporter.b(1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemClueView
 * JD-Core Version:    0.7.0.1
 */