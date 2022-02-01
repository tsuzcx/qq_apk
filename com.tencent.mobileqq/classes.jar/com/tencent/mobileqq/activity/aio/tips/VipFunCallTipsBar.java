package com.tencent.mobileqq.activity.aio.tips;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;

public class VipFunCallTipsBar
  implements TipsBarTask
{
  private Context jdField_a_of_type_AndroidContentContext;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  TipsManager jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  String jdField_a_of_type_JavaLangString;
  
  public VipFunCallTipsBar(QQAppInterface paramQQAppInterface, TipsManager paramTipsManager, Context paramContext, String paramString, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager = paramTipsManager;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public int a()
  {
    return 36;
  }
  
  public View a(Object... paramVarArgs)
  {
    paramVarArgs = (RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558831, null);
    ImageView localImageView1 = (ImageView)paramVarArgs.findViewById(2131364326);
    TextView localTextView = (TextView)paramVarArgs.findViewById(2131364327);
    ImageView localImageView2 = (ImageView)paramVarArgs.findViewById(2131364325);
    localTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131694980));
    localImageView1.setImageResource(2130844956);
    paramVarArgs.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131694980));
    paramVarArgs.setOnClickListener(new VipFunCallTipsBar.1(this));
    localImageView2.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    return paramVarArgs;
  }
  
  public void a(int paramInt, Object... paramVarArgs) {}
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public int[] a()
  {
    return null;
  }
  
  public int b()
  {
    return 10;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.VipFunCallTipsBar
 * JD-Core Version:    0.7.0.1
 */