package com.tencent.av.wtogether.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.av.wtogether.adapter.QGroupExpandableListAdapter;
import com.tencent.av.wtogether.adapter.QGroupExpandableListAdapter.UIEvent;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.AutomatorObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ListView;
import com.tencent.widget.SwipPinnedHeaderExpandableListView;

public class QGroupListContentView
  extends QBaseContentView
{
  protected QGroupExpandableListAdapter.UIEvent a;
  protected QGroupExpandableListAdapter a;
  private AutomatorObserver a;
  protected SwipPinnedHeaderExpandableListView a;
  
  public QGroupListContentView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_ComTencentMobileqqAppAutomatorObserver = new QGroupListContentView.2(this);
  }
  
  public QGroupListContentView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_ComTencentMobileqqAppAutomatorObserver = new QGroupListContentView.2(this);
  }
  
  public QGroupListContentView(Context paramContext, QGroupExpandableListAdapter.UIEvent paramUIEvent)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqAppAutomatorObserver = new QGroupListContentView.2(this);
    this.jdField_a_of_type_ComTencentAvWtogetherAdapterQGroupExpandableListAdapter$UIEvent = paramUIEvent;
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView != null)
    {
      if (this.jdField_a_of_type_ComTencentAvWtogetherAdapterQGroupExpandableListAdapter != null) {
        this.jdField_a_of_type_ComTencentAvWtogetherAdapterQGroupExpandableListAdapter.b();
      }
      this.jdField_a_of_type_ComTencentAvWtogetherAdapterQGroupExpandableListAdapter = new QGroupExpandableListAdapter(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView, this.jdField_a_of_type_ComTencentAvWtogetherAdapterQGroupExpandableListAdapter$UIEvent);
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setAdapter(this.jdField_a_of_type_ComTencentAvWtogetherAdapterQGroupExpandableListAdapter);
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setOnGroupClickListener(this.jdField_a_of_type_ComTencentAvWtogetherAdapterQGroupExpandableListAdapter);
    }
  }
  
  public ListView a()
  {
    return this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView = new SwipPinnedHeaderExpandableListView(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setId(2131374317);
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setSelector(2131167305);
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setNeedCheckSpringback(true);
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setGroupIndicator(null);
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setDivider(null);
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setPadding(0, 0, 0, AIOUtils.a(54.0F, getResources()));
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setClipToPadding(false);
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setScrollBarStyle(33554432);
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.mForContacts = true;
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    addView(this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView);
    ReportController.b(null, "dc00898", "", "", "0X800B623", "0X800B623", 0, 0, "", "", "", "");
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorObserver);
    if (this.jdField_a_of_type_ComTencentAvWtogetherAdapterQGroupExpandableListAdapter != null) {
      this.jdField_a_of_type_ComTencentAvWtogetherAdapterQGroupExpandableListAdapter.b();
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorObserver);
    if (this.jdField_a_of_type_ComTencentAvWtogetherAdapterQGroupExpandableListAdapter == null) {
      e();
    }
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.postDelayed(new QGroupListContentView.1(this), 200L);
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.wtogether.view.QGroupListContentView
 * JD-Core Version:    0.7.0.1
 */