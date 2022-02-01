package com.tencent.biz.pubaccount.ecshopassit.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import ohh;
import oia;

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
    setBackgroundColor(paramContext.getResources().getColor(2131167337));
    this.a = new Button(paramContext);
    addView(this.a);
    this.a.getLayoutParams().width = -1;
    this.a.getLayoutParams().height = UIUtils.dip2px(paramContext, 45.0F);
    this.a.setBackgroundResource(2130842692);
    this.a.setTextColor(paramContext.getResources().getColor(2131167337));
    this.a.setTextSize(1, 17.0F);
    int i = UIUtils.dip2px(getContext(), 16.0F);
    setPadding(i, i, i, i);
  }
  
  public void setBtnText(ohh paramohh)
  {
    if ((this.a == null) || (paramohh == null) || (getContext() == null))
    {
      QLog.i("MinusViewBotomView", 2, "params error!!");
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    MessageRecord localMessageRecord = localQQAppInterface.getMessageFacade().getLastMsgForMsgTab("3046055438", 1008);
    if (StringUtil.isEmpty(paramohh.a)) {}
    for (paramohh = getContext().getString(2131691723);; paramohh = paramohh.a)
    {
      this.a.setText(paramohh);
      this.a.setOnClickListener(new oia(this, localQQAppInterface, localMessageRecord));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.view.MinusViewBotomView
 * JD-Core Version:    0.7.0.1
 */