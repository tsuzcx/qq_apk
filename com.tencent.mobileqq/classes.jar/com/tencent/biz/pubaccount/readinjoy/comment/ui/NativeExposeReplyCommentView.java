package com.tencent.biz.pubaccount.readinjoy.comment.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import anzj;
import bnrf;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.SubCommentData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import orv;
import osy;
import otp;
import oxh;

public class NativeExposeReplyCommentView
  extends FrameLayout
  implements View.OnClickListener, IView
{
  private static String jdField_a_of_type_JavaLangString = "NativeExposeReplyCommentView";
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private orv jdField_a_of_type_Orv;
  private otp jdField_a_of_type_Otp;
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
  
  private SubCommentData a(otp paramotp, int paramInt)
  {
    if ((paramotp != null) && ((paramotp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData instanceof CommentData)))
    {
      paramotp = (CommentData)paramotp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
      if ((paramotp.subCommentList != null) && (paramotp.subCommentList.size() > paramInt)) {
        return (SubCommentData)paramotp.subCommentList.get(paramInt);
      }
    }
    return null;
  }
  
  private void a()
  {
    inflate(this.jdField_a_of_type_AndroidContentContext, 2131560169, this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131366684));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131366694));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131366695));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131377220));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377229));
    this.d = ((TextView)findViewById(2131377230));
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131376525));
    this.e = ((TextView)findViewById(2131376524));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131366696);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131377231);
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
    if (!(this.jdField_a_of_type_Otp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData instanceof CommentData)) {}
    while (((CommentData)this.jdField_a_of_type_Otp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData).subCommentNum < 3) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnTouchListener(new oxh(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetLinearLayout));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnTouchListener(new oxh(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetLinearLayout));
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnTouchListener(new oxh(this.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_AndroidWidgetLinearLayout));
    this.d.setOnTouchListener(new oxh(this.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_AndroidWidgetLinearLayout));
  }
  
  public void a(otp paramotp)
  {
    if ((paramotp == null) || (paramotp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null)) {}
    while (!(paramotp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData instanceof CommentData)) {
      return;
    }
    CommentData localCommentData = (CommentData)paramotp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
    if (!paramotp.a())
    {
      setVisibility(8);
      return;
    }
    this.jdField_a_of_type_Otp = paramotp;
    setVisibility(0);
    List localList = paramotp.jdField_a_of_type_JavaUtilList;
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
        this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)paramotp.jdField_a_of_type_JavaUtilList.get(i));
        this.jdField_a_of_type_AndroidWidgetTextView.setMovementMethod(osy.a());
        this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)paramotp.b.get(i));
        this.jdField_b_of_type_AndroidWidgetTextView.setMovementMethod(osy.a());
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
          this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)paramotp.jdField_a_of_type_JavaUtilList.get(i));
          this.jdField_c_of_type_AndroidWidgetTextView.setMovementMethod(osy.a());
          this.d.setText((CharSequence)paramotp.b.get(i));
          this.d.setMovementMethod(osy.a());
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          this.d.setOnClickListener(this);
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
        }
      }
    }
    if (localCommentData.subCommentNum > 2)
    {
      this.e.setText(anzj.a(2131705963) + bnrf.a(localCommentData.subCommentNum, 99989500L, "9999万+", "0") + anzj.a(2131705962));
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
    if ((this.jdField_a_of_type_Orv == null) || (this.jdField_a_of_type_Otp == null)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.jdField_a_of_type_Otp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData instanceof CommentData)) {
        switch (paramView.getId())
        {
        default: 
          break;
        case 2131366684: 
        case 2131366695: 
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130842917);
          this.jdField_a_of_type_Orv.a(this.jdField_a_of_type_Otp, a(this.jdField_a_of_type_Otp, 0), 2);
          break;
        case 2131377220: 
        case 2131377230: 
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130842917);
          this.jdField_a_of_type_Orv.a(this.jdField_a_of_type_Otp, a(this.jdField_a_of_type_Otp, 1), 2);
          break;
        case 2131376525: 
          this.jdField_a_of_type_Orv.a(this.jdField_a_of_type_Otp, null, 1);
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
  
  public void setAdapter(orv paramorv)
  {
    this.jdField_a_of_type_Orv = paramorv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ui.NativeExposeReplyCommentView
 * JD-Core Version:    0.7.0.1
 */