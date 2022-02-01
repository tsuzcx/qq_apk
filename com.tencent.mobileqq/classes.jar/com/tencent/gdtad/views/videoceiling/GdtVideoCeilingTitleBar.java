package com.tencent.gdtad.views.videoceiling;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;

public class GdtVideoCeilingTitleBar
  extends RelativeLayout
{
  private int jdField_a_of_type_Int;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private GdtVideoCeilingTitleBar.OnBtnClickListener jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingTitleBar$OnBtnClickListener;
  private String jdField_a_of_type_JavaLangString;
  private TextView b;
  
  public GdtVideoCeilingTitleBar(Context paramContext)
  {
    super(paramContext);
  }
  
  public GdtVideoCeilingTitleBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public GdtVideoCeilingTitleBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("updateBar Style ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
    GdtLog.b("GdtVideoCeilingView", ((StringBuilder)localObject).toString());
    if (this.jdField_a_of_type_Int != 1)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.b.setVisibility(0);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131705323));
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      localObject = ((StringBuilder)localObject).toString();
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (((String)localObject).length() <= 7))
      {
        this.b.setText((CharSequence)localObject);
        return;
      }
      this.b.setText("在APP中打开");
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.b.setVisibility(8);
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378784));
    this.b = ((TextView)findViewById(2131372123));
    this.b.setOnClickListener(new GdtVideoCeilingTitleBar.1(this));
    View localView = findViewById(2131363334);
    int i = AIOUtils.b(5.0F, getResources());
    AIOUtils.a(localView, i, i, 0, i);
    localView.setOnClickListener(new GdtVideoCeilingTitleBar.2(this));
  }
  
  public void setAppName(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void setOnBtnClickListener(GdtVideoCeilingTitleBar.OnBtnClickListener paramOnBtnClickListener)
  {
    this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingTitleBar$OnBtnClickListener = paramOnBtnClickListener;
  }
  
  public void setStyle(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setWebBarTitle(String paramString)
  {
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (!TextUtils.isEmpty(paramString))) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.views.videoceiling.GdtVideoCeilingTitleBar
 * JD-Core Version:    0.7.0.1
 */