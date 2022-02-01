package com.tencent.av.wtogether.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout.LayoutParams;
import anqj;
import bdla;
import com.tencent.av.wtogether.adapter.QGroupExpandableListAdapter;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.ListView;
import com.tencent.widget.SwipPinnedHeaderExpandableListView;
import mxv;
import nas;

public class QGroupListContentView
  extends QBaseContentView
{
  private anqj a;
  public QGroupExpandableListAdapter a;
  protected SwipPinnedHeaderExpandableListView a;
  protected mxv a;
  
  public QGroupListContentView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Anqj = new nas(this);
  }
  
  public QGroupListContentView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Anqj = new nas(this);
  }
  
  public QGroupListContentView(Context paramContext, mxv parammxv)
  {
    super(paramContext);
    this.jdField_a_of_type_Anqj = new nas(this);
    this.jdField_a_of_type_Mxv = parammxv;
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView != null)
    {
      if (this.jdField_a_of_type_ComTencentAvWtogetherAdapterQGroupExpandableListAdapter != null) {
        this.jdField_a_of_type_ComTencentAvWtogetherAdapterQGroupExpandableListAdapter.c();
      }
      this.jdField_a_of_type_ComTencentAvWtogetherAdapterQGroupExpandableListAdapter = new QGroupExpandableListAdapter(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView, this.jdField_a_of_type_Mxv);
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
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setId(2131374003);
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setSelector(2131167296);
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setNeedCheckSpringback(true);
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setGroupIndicator(null);
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setDivider(null);
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setPadding(0, 0, 0, AIOUtils.dp2px(54.0F, getResources()));
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setClipToPadding(false);
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setScrollBarStyle(33554432);
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.mForContacts = true;
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    addView(this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView);
    bdla.b(null, "dc00898", "", "", "0X800B623", "0X800B623", 0, 0, "", "", "", "");
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anqj);
    if (this.jdField_a_of_type_ComTencentAvWtogetherAdapterQGroupExpandableListAdapter != null) {
      this.jdField_a_of_type_ComTencentAvWtogetherAdapterQGroupExpandableListAdapter.c();
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anqj);
    if (this.jdField_a_of_type_ComTencentAvWtogetherAdapterQGroupExpandableListAdapter == null) {
      e();
    }
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.postDelayed(new QGroupListContentView.1(this), 200L);
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anqj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.wtogether.view.QGroupListContentView
 * JD-Core Version:    0.7.0.1
 */