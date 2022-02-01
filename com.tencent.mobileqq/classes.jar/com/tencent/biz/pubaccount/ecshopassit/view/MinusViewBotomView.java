package com.tencent.biz.pubaccount.ecshopassit.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import bhsr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import ofu;
import ogn;
import zps;

public class MinusViewBotomView
  extends FrameLayout
{
  private Button a;
  
  public MinusViewBotomView(@NonNull Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public MinusViewBotomView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    setBackgroundColor(paramContext.getResources().getColor(2131167302));
    this.a = new Button(paramContext);
    addView(this.a);
    this.a.getLayoutParams().width = -1;
    this.a.getLayoutParams().height = zps.a(paramContext, 45.0F);
    this.a.setBackgroundResource(2130842647);
    this.a.setTextColor(paramContext.getResources().getColor(2131167302));
    this.a.setTextSize(1, 17.0F);
    int i = zps.a(getContext(), 16.0F);
    setPadding(i, i, i, i);
  }
  
  public void setBtnText(ofu paramofu)
  {
    if ((this.a == null) || (paramofu == null) || (getContext() == null))
    {
      QLog.i("MinusViewBotomView", 2, "params error!!");
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    MessageRecord localMessageRecord = localQQAppInterface.a().b("3046055438", 1008);
    if (bhsr.a(paramofu.a)) {}
    for (paramofu = getContext().getString(2131691678);; paramofu = paramofu.a)
    {
      this.a.setText(paramofu);
      this.a.setOnClickListener(new ogn(this, localQQAppInterface, localMessageRecord));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.view.MinusViewBotomView
 * JD-Core Version:    0.7.0.1
 */