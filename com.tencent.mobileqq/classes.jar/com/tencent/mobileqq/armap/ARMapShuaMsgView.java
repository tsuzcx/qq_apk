package com.tencent.mobileqq.armap;

import aavb;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.portal.StrokeTextView;
import com.tencent.qphone.base.util.QLog;

public class ARMapShuaMsgView
  extends RelativeLayout
{
  public int a;
  private Context jdField_a_of_type_AndroidContentContext;
  public View a;
  ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  public ConversationPullDownActiveBase a;
  public StrokeTextView a;
  Runnable jdField_a_of_type_JavaLangRunnable = new aavb(this);
  
  public ARMapShuaMsgView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    LayoutInflater.from(paramContext).inflate(2130970217, this, true);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131369682);
    this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView = ((StrokeTextView)findViewById(2131363921));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131363031));
    this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.setInnerTextColor(Color.parseColor("#565a5c"));
    this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.setStrokeColor(Color.parseColor("#ffffff"));
    this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.setStrokeSize(AIOUtils.a(1.5F, getResources()));
    this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.setTextSize(1, 14.0F);
    this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.setStrokeEnable(true);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapShuaMsgView", 2, "showPullMsgProcess" + this.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_Int = 0;
    removeCallbacks(null);
    this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.setText("正在刷新");
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    setVisibility(0);
    bringToFront();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
    Drawable localDrawable = null;
    String str = "";
    if (QLog.isColorLevel()) {
      QLog.d("ARMapShuaMsgView", 2, "showPullMsgResult, pull=" + this.jdField_a_of_type_Int);
    }
    if (this.jdField_a_of_type_Int == 0)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      switch (paramInt)
      {
      default: 
        Object localObject = str;
        if (localDrawable != null)
        {
          paramInt = (int)this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.getTextSize() + 2;
          localDrawable.setBounds(0, 0, paramInt, paramInt);
          localObject = new SpannableString("[O]" + " " + str);
          ((SpannableString)localObject).setSpan(new ImageSpan(localDrawable, 0), 0, "[O]".length(), 17);
        }
        this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.setText((CharSequence)localObject);
        postDelayed(this.jdField_a_of_type_JavaLangRunnable, 300L);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = -1;
      return;
      localDrawable = getResources().getDrawable(2130845317);
      str = getResources().getString(2131434336);
      break;
      localDrawable = getResources().getDrawable(2130845315);
      str = getResources().getString(2131434332);
      break;
      localDrawable = getResources().getDrawable(2130845316);
      str = getResources().getString(2131434332);
      break;
      this.jdField_a_of_type_AndroidViewView.setVisibility(4);
    }
  }
  
  public void a(ConversationPullDownActiveBase paramConversationPullDownActiveBase)
  {
    this.jdField_a_of_type_ComTencentMobileqqArmapConversationPullDownActiveBase = paramConversationPullDownActiveBase;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int == 0;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapShuaMsgView", 2, "reset" + this.jdField_a_of_type_Int);
    }
    removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
    this.jdField_a_of_type_Int = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.ARMapShuaMsgView
 * JD-Core Version:    0.7.0.1
 */