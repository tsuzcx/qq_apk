package com.tencent.biz.pubaccount.ecshopassit.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.pubaccount.ecshopassit.conf.EcshopConfBean;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;

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
    setBackgroundColor(paramContext.getResources().getColor(2131167374));
    this.a = new Button(paramContext);
    addView(this.a);
    this.a.getLayoutParams().width = -1;
    this.a.getLayoutParams().height = UIUtils.a(paramContext, 45.0F);
    this.a.setBackgroundResource(2130842868);
    this.a.setTextColor(paramContext.getResources().getColor(2131167374));
    this.a.setTextSize(1, 17.0F);
    int i = UIUtils.a(getContext(), 16.0F);
    setPadding(i, i, i, i);
  }
  
  public void setBtnText(EcshopConfBean paramEcshopConfBean)
  {
    if ((this.a == null) || (paramEcshopConfBean == null) || (getContext() == null))
    {
      QLog.i("MinusViewBotomView", 2, "params error!!");
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    MessageRecord localMessageRecord = localQQAppInterface.getMessageFacade().b("3046055438", 1008);
    if (StringUtil.a(paramEcshopConfBean.a)) {}
    for (paramEcshopConfBean = getContext().getString(2131691929);; paramEcshopConfBean = paramEcshopConfBean.a)
    {
      this.a.setText(paramEcshopConfBean);
      this.a.setOnClickListener(new MinusViewBotomView.1(this, localQQAppInterface, localMessageRecord));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.view.MinusViewBotomView
 * JD-Core Version:    0.7.0.1
 */