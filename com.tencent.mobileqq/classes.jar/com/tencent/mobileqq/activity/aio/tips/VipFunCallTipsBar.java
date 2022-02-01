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
  TipsManager a;
  QQAppInterface b;
  View.OnClickListener c;
  String d;
  private Context e;
  
  public int a()
  {
    return 36;
  }
  
  public View a(Object... paramVarArgs)
  {
    paramVarArgs = (RelativeLayout)LayoutInflater.from(this.e).inflate(2131624349, null);
    ImageView localImageView1 = (ImageView)paramVarArgs.findViewById(2131430250);
    TextView localTextView = (TextView)paramVarArgs.findViewById(2131430251);
    ImageView localImageView2 = (ImageView)paramVarArgs.findViewById(2131430249);
    localTextView.setText(this.e.getResources().getString(2131892697));
    localImageView1.setImageResource(2130846266);
    paramVarArgs.setContentDescription(this.e.getResources().getString(2131892697));
    paramVarArgs.setOnClickListener(new VipFunCallTipsBar.1(this));
    localImageView2.setOnClickListener(this.c);
    return paramVarArgs;
  }
  
  public void a(int paramInt, Object... paramVarArgs) {}
  
  public int b()
  {
    return 10;
  }
  
  public int[] c()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.VipFunCallTipsBar
 * JD-Core Version:    0.7.0.1
 */