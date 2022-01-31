package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.R.styleable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.net.MalformedURLException;
import java.net.URL;
import omr;

public class DailyTitleBar
  extends FrameLayout
{
  private final View jdField_a_of_type_AndroidViewView;
  private final TextView jdField_a_of_type_AndroidWidgetTextView;
  private final KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  private final View b;
  private final View c;
  
  public DailyTitleBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131369625);
    this.b = findViewById(2131369634);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378389));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)findViewById(2131368715));
    this.c = findViewById(2131377449);
  }
  
  private void a(Context paramContext)
  {
    setPadding(getPaddingLeft(), getPaddingTop() + ImmersiveUtils.getStatusBarHeight(paramContext), getPaddingRight(), getPaddingBottom());
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    View.inflate(paramContext, 2131559900, this);
    paramAttributeSet = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, R.styleable.DailyTitleBar, 0, 0);
    for (;;)
    {
      int i;
      try
      {
        String str = paramAttributeSet.getString(3);
        i = paramAttributeSet.getColor(4, -16777216);
        int j = paramAttributeSet.getResourceId(0, 2131167134);
        k = paramAttributeSet.getResourceId(2, 2130842420);
        m = paramAttributeSet.getResourceId(1, 2130842608);
        setBackgroundResource(j);
        localTextView = (TextView)findViewById(2131378389);
        localTextView.setText(str);
        localTextView.setTextColor(i);
        if ((i != -1) && (i != 16777215)) {
          break label175;
        }
        findViewById(2131368715).setVisibility(8);
      }
      finally
      {
        int k;
        int m;
        TextView localTextView;
        paramAttributeSet.recycle();
      }
      localTextView.setVisibility(8);
      findViewById(2131368507).setBackgroundResource(k);
      findViewById(2131368683).setBackgroundResource(m);
      paramAttributeSet.recycle();
      setClickable(true);
      a(paramContext);
      b(paramContext);
      return;
      label175:
      if (i != -16777216) {
        if (i != 0) {}
      }
    }
  }
  
  private void b(Context paramContext)
  {
    KandianUrlImageView localKandianUrlImageView = (KandianUrlImageView)findViewById(2131368715);
    Object localObject;
    if (localKandianUrlImageView != null)
    {
      localObject = Aladdin.getConfig(226);
      if (localObject != null)
      {
        int i = ((AladdinConfig)localObject).getIntegerFromString("daily_title_url_switch", 0);
        localObject = ((AladdinConfig)localObject).getString("daily_title_url", "");
        QLog.i("DailyTitleBar", 1, "[initTitleBarImage], urlSwitch = " + i + ", url = " + (String)localObject);
        if ((i != 1) || (TextUtils.isEmpty((CharSequence)localObject))) {}
      }
    }
    try
    {
      omr.a(localKandianUrlImageView, new URL((String)localObject), paramContext);
      return;
    }
    catch (MalformedURLException paramContext)
    {
      QLog.e("DailyTitleBar", 1, "[initTitleBarImage], e = " + paramContext);
    }
  }
  
  public void setOnLeftButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (paramOnClickListener != null)) {
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void setOnRightButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    if ((this.b != null) && (paramOnClickListener != null)) {
      this.b.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void setOnTitleClickListener(View.OnClickListener paramOnClickListener)
  {
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (paramOnClickListener != null)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener);
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView != null) && (paramOnClickListener != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void setTitleText(String paramString)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    }
  }
  
  public void setTitleTextSize(float paramFloat)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.DailyTitleBar
 * JD-Core Version:    0.7.0.1
 */