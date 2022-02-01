package com.tencent.mobileqq.addfriend.ui;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.regex.Matcher;

class AddFriendVerifyFragment$7
  extends AddFriendVerifyFragment.AddFriendOnclick
{
  AddFriendVerifyFragment$7(AddFriendVerifyFragment paramAddFriendVerifyFragment, StringBuffer paramStringBuffer, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramAddFriendVerifyFragment);
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    AddFriendVerifyFragment.g(this.e);
    Object localObject = this.a.toString();
    int i = 0;
    while (i < AddFriendVerifyFragment.h(this.e).size())
    {
      String str = ((EditText)AddFriendVerifyFragment.h(this.e).get(i)).getText().toString().trim();
      if ("".equals(str))
      {
        i = 1;
        break label97;
      }
      localObject = ((String)localObject).replaceFirst("\\$\\{answer\\}", Matcher.quoteReplacement(str));
      i += 1;
    }
    i = 0;
    label97:
    if (i != 0) {
      QQToast.makeText(this.e.getActivity(), 0, this.e.getString(2131886666), 0).show(this.e.getQBaseActivity().getTitleBarHeight());
    } else {
      this.e.a((String)localObject, null, "");
    }
    ReportController.b(AddFriendVerifyFragment.f(this.e), "dc00898", "", "", "0X80077B4", "0X80077B4", 0, 0, String.valueOf(this.b), String.valueOf(this.c), "", "");
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportClickEvent action: 0X80077B4  sourceId = ");
      ((StringBuilder)localObject).append(this.b);
      ((StringBuilder)localObject).append(" subSourceId = ");
      ((StringBuilder)localObject).append(this.c);
      QLog.d("IphoneTitleBarFragment", 2, ((StringBuilder)localObject).toString());
    }
    if (!TextUtils.isEmpty(this.e.b)) {
      ReportController.b(AddFriendVerifyFragment.f(this.e), "dc00899", "Qidian", "", "0X8008802", "ClickAddFriendButton", 0, 0, "1", "", "", "");
    }
    this.e.a(this.b, this.d);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.addfriend.ui.AddFriendVerifyFragment.7
 * JD-Core Version:    0.7.0.1
 */