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
import rld;
import rpt;

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
  private rld jdField_a_of_type_Rld;
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
    this.jdField_a_of_type_Int = getResources().getDimensionPixelOffset(2131296868);
    this.jdField_b_of_type_Int = getResources().getDimensionPixelOffset(2131296856);
    this.jdField_c_of_type_Int = getResources().getDimensionPixelOffset(2131296858);
    d();
  }
  
  private void d()
  {
    LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560353, this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380137));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131363913));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131363884));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)findViewById(2131369436));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131367321);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369377));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369378));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369379));
    this.d = ((ImageView)findViewById(2131369380));
    this.e = ((ImageView)findViewById(2131369381));
    Drawable localDrawable = getResources().getDrawable(2130843202);
    localDrawable.setBounds(0, 0, this.jdField_a_of_type_Int, this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidWidgetButton.setCompoundDrawables(localDrawable, null, null, null);
    localDrawable = getResources().getDrawable(2130843198);
    localDrawable.setBounds(0, 0, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
    this.jdField_b_of_type_AndroidWidgetButton.setCompoundDrawables(localDrawable, null, null, null);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getString(2131717353, new Object[] { Integer.valueOf(paramInt), this.jdField_a_of_type_Rld.jdField_a_of_type_JavaLangString }));
  }
  
  public void a(URL paramURL)
  {
    try
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setImage(paramURL);
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
  
  public void setNextVideoInfo(rld paramrld)
  {
    this.jdField_a_of_type_Rld = paramrld;
    if (this.jdField_a_of_type_Rld == null) {
      return;
    }
    this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getString(2131717354, new Object[] { this.jdField_a_of_type_Rld.jdField_a_of_type_JavaLangString }));
      this.jdField_b_of_type_AndroidWidgetButton.setText(getResources().getString(2131717352, new Object[] { rpt.b(paramrld.jdField_a_of_type_Long) }));
      return;
    }
    this.jdField_b_of_type_AndroidWidgetButton.setText(getResources().getString(2131717355));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.VideoCountDownView
 * JD-Core Version:    0.7.0.1
 */