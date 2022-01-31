package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.net.URL;
import qyp;
import rdm;

public class VideoCountDownView
  extends RelativeLayout
{
  public final int a;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  private qyp jdField_a_of_type_Qyp;
  private boolean jdField_a_of_type_Boolean;
  public final int b;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  public final int c;
  private ImageView c;
  private ImageView d;
  private ImageView e;
  
  public VideoCountDownView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VideoCountDownView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VideoCountDownView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = getResources().getDimensionPixelOffset(2131296806);
    this.jdField_b_of_type_Int = getResources().getDimensionPixelOffset(2131296794);
    this.jdField_c_of_type_Int = getResources().getDimensionPixelOffset(2131296796);
    d();
  }
  
  private void d()
  {
    LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560189, this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378982));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131363684));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131363655));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)findViewById(2131368944));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131366989);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368895));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368896));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368897));
    this.d = ((ImageView)findViewById(2131368898));
    this.e = ((ImageView)findViewById(2131368899));
    Drawable localDrawable = getResources().getDrawable(2130842829);
    localDrawable.setBounds(0, 0, this.jdField_a_of_type_Int, this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidWidgetButton.setCompoundDrawables(localDrawable, null, null, null);
    localDrawable = getResources().getDrawable(2130842825);
    localDrawable.setBounds(0, 0, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
    this.jdField_b_of_type_AndroidWidgetButton.setCompoundDrawables(localDrawable, null, null, null);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getString(2131719087, new Object[] { Integer.valueOf(paramInt), this.jdField_a_of_type_Qyp.jdField_a_of_type_JavaLangString }));
  }
  
  public void a(URL paramURL)
  {
    try
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.a(paramURL);
      return;
    }
    catch (Exception paramURL)
    {
      paramURL.printStackTrace();
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(8);
  }
  
  public void c()
  {
    this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void setIsXgMode(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setNextVideoInfo(qyp paramqyp)
  {
    this.jdField_a_of_type_Qyp = paramqyp;
    if (this.jdField_a_of_type_Qyp == null) {
      return;
    }
    this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getString(2131719088, new Object[] { this.jdField_a_of_type_Qyp.jdField_a_of_type_JavaLangString }));
      this.jdField_b_of_type_AndroidWidgetButton.setText(getResources().getString(2131719086, new Object[] { rdm.b(paramqyp.jdField_a_of_type_Long) }));
      return;
    }
    this.jdField_b_of_type_AndroidWidgetButton.setText(getResources().getString(2131719089));
  }
  
  public void setOnCustomClickListener(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(paramOnClickListener);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(paramOnClickListener);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
    this.d.setOnClickListener(paramOnClickListener);
    this.e.setOnClickListener(paramOnClickListener);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(paramOnClickListener);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener);
  }
  
  public void setTitle(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.VideoCountDownView
 * JD-Core Version:    0.7.0.1
 */