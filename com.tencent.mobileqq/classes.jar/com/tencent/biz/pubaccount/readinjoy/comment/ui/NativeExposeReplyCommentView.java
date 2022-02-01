package com.tencent.biz.pubaccount.readinjoy.comment.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import anvx;
import bmhv;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.SubCommentData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import pau;
import pca;
import pdp;
import php;

public class NativeExposeReplyCommentView
  extends FrameLayout
  implements View.OnClickListener, IView
{
  private static String jdField_a_of_type_JavaLangString = "NativeExposeReplyCommentView";
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private pau jdField_a_of_type_Pau;
  private pdp jdField_a_of_type_Pdp;
  private View jdField_b_of_type_AndroidViewView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private TextView d;
  private TextView e;
  
  public NativeExposeReplyCommentView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  public NativeExposeReplyCommentView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  public NativeExposeReplyCommentView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  private SubCommentData a(pdp parampdp, int paramInt)
  {
    if ((parampdp != null) && ((parampdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData instanceof CommentData)))
    {
      parampdp = (CommentData)parampdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
      if ((parampdp.subCommentList != null) && (parampdp.subCommentList.size() > paramInt)) {
        return (SubCommentData)parampdp.subCommentList.get(paramInt);
      }
    }
    return null;
  }
  
  private void a()
  {
    inflate(this.jdField_a_of_type_AndroidContentContext, 2131560222, this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131366830));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131366840));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131366841));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131377242));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377251));
    this.d = ((TextView)findViewById(2131377252));
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131376546));
    this.e = ((TextView)findViewById(2131376545));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131366842);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131377253);
  }
  
  private void a(int paramInt)
  {
    int i = 4;
    int j = 0;
    if (paramInt > 1) {
      if (paramInt > 2)
      {
        i = 0;
        paramInt = j;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(i);
      this.jdField_b_of_type_AndroidViewView.setVisibility(paramInt);
      return;
      i = 0;
      paramInt = 4;
      continue;
      paramInt = 4;
    }
  }
  
  private void b()
  {
    if (!(this.jdField_a_of_type_Pdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData instanceof CommentData)) {}
    while (((CommentData)this.jdField_a_of_type_Pdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData).subCommentNum < 3) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnTouchListener(new php(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetLinearLayout));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnTouchListener(new php(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetLinearLayout));
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnTouchListener(new php(this.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_AndroidWidgetLinearLayout));
    this.d.setOnTouchListener(new php(this.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_AndroidWidgetLinearLayout));
  }
  
  public void a(pdp parampdp)
  {
    if ((parampdp == null) || (parampdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null)) {}
    while (!(parampdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData instanceof CommentData)) {
      return;
    }
    CommentData localCommentData = (CommentData)parampdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
    if (!parampdp.a())
    {
      setVisibility(8);
      return;
    }
    this.jdField_a_of_type_Pdp = parampdp;
    setVisibility(0);
    List localList = parampdp.jdField_a_of_type_JavaUtilList;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(null);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(null);
    int j = localList.size();
    int i = 0;
    if (i < j)
    {
      if (i == 0)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)parampdp.jdField_a_of_type_JavaUtilList.get(i));
        this.jdField_a_of_type_AndroidWidgetTextView.setMovementMethod(pca.a());
        this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)parampdp.b.get(i));
        this.jdField_b_of_type_AndroidWidgetTextView.setMovementMethod(pca.a());
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
      }
      for (;;)
      {
        i += 1;
        break;
        if (i == 1)
        {
          this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)parampdp.jdField_a_of_type_JavaUtilList.get(i));
          this.jdField_c_of_type_AndroidWidgetTextView.setMovementMethod(pca.a());
          this.d.setText((CharSequence)parampdp.b.get(i));
          this.d.setMovementMethod(pca.a());
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          this.d.setOnClickListener(this);
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
        }
      }
    }
    if (localCommentData.subCommentNum > 2)
    {
      this.e.setText(anvx.a(2131706545) + bmhv.a(localCommentData.subCommentNum, 99989500L, "9999万+", "0") + anvx.a(2131706544));
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    }
    for (;;)
    {
      b();
      a(localCommentData.subCommentNum);
      return;
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setOnClickListener(null);
    }
  }
  
  public void comLayout(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    onComLayout(true, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public int getComMeasuredHeight()
  {
    return getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return getMeasuredWidth();
  }
  
  public void measureComponent(int paramInt1, int paramInt2)
  {
    onComMeasure(paramInt1, paramInt2);
  }
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_Pau == null) || (this.jdField_a_of_type_Pdp == null)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.jdField_a_of_type_Pdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData instanceof CommentData)) {
        switch (paramView.getId())
        {
        default: 
          break;
        case 2131366830: 
        case 2131366841: 
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130843003);
          this.jdField_a_of_type_Pau.a(this.jdField_a_of_type_Pdp, a(this.jdField_a_of_type_Pdp, 0), 2);
          break;
        case 2131377242: 
        case 2131377252: 
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130843003);
          this.jdField_a_of_type_Pau.a(this.jdField_a_of_type_Pdp, a(this.jdField_a_of_type_Pdp, 1), 2);
          break;
        case 2131376546: 
          this.jdField_a_of_type_Pau.a(this.jdField_a_of_type_Pdp, null, 1);
        }
      }
    }
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    measure(paramInt1, paramInt2);
  }
  
  public void setAdapter(pau parampau)
  {
    this.jdField_a_of_type_Pau = parampau;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ui.NativeExposeReplyCommentView
 * JD-Core Version:    0.7.0.1
 */