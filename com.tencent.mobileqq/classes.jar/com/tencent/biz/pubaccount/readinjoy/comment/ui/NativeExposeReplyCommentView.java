package com.tencent.biz.pubaccount.readinjoy.comment.ui;

import ajya;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import bhvy;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.SubCommentData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;
import java.util.List;
import ogn;
import oho;
import oif;
import okq;

public class NativeExposeReplyCommentView
  extends FrameLayout
  implements View.OnClickListener, IView
{
  private static String jdField_a_of_type_JavaLangString = "NativeExposeReplyCommentView";
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ogn jdField_a_of_type_Ogn;
  private oif jdField_a_of_type_Oif;
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
  
  private SubCommentData a(oif paramoif, int paramInt)
  {
    if ((paramoif != null) && ((paramoif.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData instanceof CommentData)))
    {
      paramoif = (CommentData)paramoif.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
      if ((paramoif.subCommentList != null) && (paramoif.subCommentList.size() > paramInt)) {
        return (SubCommentData)paramoif.subCommentList.get(paramInt);
      }
    }
    return null;
  }
  
  private void a()
  {
    inflate(this.jdField_a_of_type_AndroidContentContext, 2131559911, this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131366286));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131366296));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131366297));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131375752));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131375761));
    this.d = ((TextView)findViewById(2131375762));
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131375137));
    this.e = ((TextView)findViewById(2131375136));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131366298);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131375763);
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
    if (!(this.jdField_a_of_type_Oif.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData instanceof CommentData)) {}
    while (((CommentData)this.jdField_a_of_type_Oif.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData).subCommentNum < 3) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnTouchListener(new okq(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetLinearLayout));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnTouchListener(new okq(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetLinearLayout));
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnTouchListener(new okq(this.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_AndroidWidgetLinearLayout));
    this.d.setOnTouchListener(new okq(this.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_AndroidWidgetLinearLayout));
  }
  
  public void a(oif paramoif)
  {
    if ((paramoif == null) || (paramoif.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null)) {}
    while (!(paramoif.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData instanceof CommentData)) {
      return;
    }
    CommentData localCommentData = (CommentData)paramoif.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
    if (!paramoif.a())
    {
      setVisibility(8);
      return;
    }
    this.jdField_a_of_type_Oif = paramoif;
    setVisibility(0);
    List localList = paramoif.jdField_a_of_type_JavaUtilList;
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
        this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)paramoif.jdField_a_of_type_JavaUtilList.get(i));
        this.jdField_a_of_type_AndroidWidgetTextView.setMovementMethod(oho.a());
        this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)paramoif.b.get(i));
        this.jdField_b_of_type_AndroidWidgetTextView.setMovementMethod(oho.a());
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
          this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)paramoif.jdField_a_of_type_JavaUtilList.get(i));
          this.jdField_c_of_type_AndroidWidgetTextView.setMovementMethod(oho.a());
          this.d.setText((CharSequence)paramoif.b.get(i));
          this.d.setMovementMethod(oho.a());
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          this.d.setOnClickListener(this);
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
        }
      }
    }
    if (localCommentData.subCommentNum > 2)
    {
      this.e.setText(ajya.a(2131707081) + bhvy.a(localCommentData.subCommentNum, 99989500L, "9999万+", "0") + ajya.a(2131707080));
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
    if ((this.jdField_a_of_type_Ogn == null) || (this.jdField_a_of_type_Oif == null)) {}
    while (!(this.jdField_a_of_type_Oif.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData instanceof CommentData)) {
      return;
    }
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131366286: 
    case 2131366297: 
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130842390);
      this.jdField_a_of_type_Ogn.a(this.jdField_a_of_type_Oif, a(this.jdField_a_of_type_Oif, 0));
      return;
    case 2131375752: 
    case 2131375762: 
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130842390);
      this.jdField_a_of_type_Ogn.a(this.jdField_a_of_type_Oif, a(this.jdField_a_of_type_Oif, 1));
      return;
    }
    this.jdField_a_of_type_Ogn.a(this.jdField_a_of_type_Oif, null);
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    measure(paramInt1, paramInt2);
  }
  
  public void setAdapter(ogn paramogn)
  {
    this.jdField_a_of_type_Ogn = paramogn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ui.NativeExposeReplyCommentView
 * JD-Core Version:    0.7.0.1
 */