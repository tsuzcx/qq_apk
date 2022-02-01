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
    GdtLog.b("GdtVideoCeilingView", "updateBar Style " + this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Int != 1)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.b.setVisibility(0);
      String str = HardCodeUtil.a(2131705246) + this.jdField_a_of_type_JavaLangString;
      int i = "在APP中打开".length();
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (str.length() <= i))
      {
        this.b.setText(str);
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
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379432));
    this.b = ((TextView)findViewById(2131372538));
    this.b.setOnClickListener(new GdtVideoCeilingTitleBar.1(this));
    View localView = findViewById(2131363402);
    int i = AIOUtils.a(5.0F, getResources());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.views.videoceiling.GdtVideoCeilingTitleBar
 * JD-Core Version:    0.7.0.1
 */