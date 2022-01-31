package com.tencent.biz.pubaccount.readinjoy.comment.ui;

import alpo;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import bjxj;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.SubCommentData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;
import java.util.List;
import ola;
import omc;
import omt;
import ope;

public class NativeExposeReplyCommentView
  extends FrameLayout
  implements View.OnClickListener, IView
{
  private static String jdField_a_of_type_JavaLangString = "NativeExposeReplyCommentView";
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ola jdField_a_of_type_Ola;
  private omt jdField_a_of_type_Omt;
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
  
  private SubCommentData a(omt paramomt, int paramInt)
  {
    if ((paramomt != null) && ((paramomt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData instanceof CommentData)))
    {
      paramomt = (CommentData)paramomt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
      if ((paramomt.subCommentList != null) && (paramomt.subCommentList.size() > paramInt)) {
        return (SubCommentData)paramomt.subCommentList.get(paramInt);
      }
    }
    return null;
  }
  
  private void a()
  {
    inflate(this.jdField_a_of_type_AndroidContentContext, 2131560011, this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131366380));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131366390));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131366391));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131376247));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376256));
    this.d = ((TextView)findViewById(2131376257));
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131375618));
    this.e = ((TextView)findViewById(2131375617));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131366392);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131376258);
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
    if (!(this.jdField_a_of_type_Omt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData instanceof CommentData)) {}
    while (((CommentData)this.jdField_a_of_type_Omt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData).subCommentNum < 3) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnTouchListener(new ope(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetLinearLayout));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnTouchListener(new ope(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetLinearLayout));
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnTouchListener(new ope(this.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_AndroidWidgetLinearLayout));
    this.d.setOnTouchListener(new ope(this.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_AndroidWidgetLinearLayout));
  }
  
  public void a(omt paramomt)
  {
    if ((paramomt == null) || (paramomt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null)) {}
    while (!(paramomt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData instanceof CommentData)) {
      return;
    }
    CommentData localCommentData = (CommentData)paramomt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
    if (!paramomt.a())
    {
      setVisibility(8);
      return;
    }
    this.jdField_a_of_type_Omt = paramomt;
    setVisibility(0);
    List localList = paramomt.jdField_a_of_type_JavaUtilList;
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
        this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)paramomt.jdField_a_of_type_JavaUtilList.get(i));
        this.jdField_a_of_type_AndroidWidgetTextView.setMovementMethod(omc.a());
        this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)paramomt.b.get(i));
        this.jdField_b_of_type_AndroidWidgetTextView.setMovementMethod(omc.a());
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
          this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)paramomt.jdField_a_of_type_JavaUtilList.get(i));
          this.jdField_c_of_type_AndroidWidgetTextView.setMovementMethod(omc.a());
          this.d.setText((CharSequence)paramomt.b.get(i));
          this.d.setMovementMethod(omc.a());
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          this.d.setOnClickListener(this);
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
        }
      }
    }
    if (localCommentData.subCommentNum > 2)
    {
      this.e.setText(alpo.a(2131707453) + bjxj.a(localCommentData.subCommentNum, 99989500L, "9999万+", "0") + alpo.a(2131707452));
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
    if ((this.jdField_a_of_type_Ola == null) || (this.jdField_a_of_type_Omt == null)) {}
    while (!(this.jdField_a_of_type_Omt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData instanceof CommentData)) {
      return;
    }
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131366380: 
    case 2131366391: 
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130842561);
      this.jdField_a_of_type_Ola.a(this.jdField_a_of_type_Omt, a(this.jdField_a_of_type_Omt, 0));
      return;
    case 2131376247: 
    case 2131376257: 
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130842561);
      this.jdField_a_of_type_Ola.a(this.jdField_a_of_type_Omt, a(this.jdField_a_of_type_Omt, 1));
      return;
    }
    this.jdField_a_of_type_Ola.a(this.jdField_a_of_type_Omt, null);
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    measure(paramInt1, paramInt2);
  }
  
  public void setAdapter(ola paramola)
  {
    this.jdField_a_of_type_Ola = paramola;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ui.NativeExposeReplyCommentView
 * JD-Core Version:    0.7.0.1
 */