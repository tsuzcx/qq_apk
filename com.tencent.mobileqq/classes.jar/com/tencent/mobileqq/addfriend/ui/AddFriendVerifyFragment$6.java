package com.tencent.mobileqq.addfriend.ui;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.friend.api.IFriendHandlerService;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AddFriendVerifyFragment$6
  extends AddFriendVerifyFragment.AddFriendOnclick
{
  AddFriendVerifyFragment$6(AddFriendVerifyFragment paramAddFriendVerifyFragment, EditText paramEditText, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramAddFriendVerifyFragment);
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    AddFriendVerifyFragment.g(this.e);
    Object localObject;
    if ("".equals(this.a.getText().toString().trim()))
    {
      QQToast.makeText(this.e.getActivity(), 0, this.e.getString(2131886666), 0).show(this.e.getQBaseActivity().getTitleBarHeight());
    }
    else if (NetworkUtil.isNetSupport(this.e.getActivity()))
    {
      localObject = this.e.getActivity().getIntent().getStringExtra("extra");
      String str1 = this.a.getText().toString().trim();
      int i = this.e.getActivity().getIntent().getIntExtra("sub_source_id", 0);
      String str2 = this.e.getActivity().getIntent().getStringExtra("src_name");
      ((IFriendHandlerService)AddFriendVerifyFragment.f(this.e).getRuntimeService(IFriendHandlerService.class, "")).requestAddFriend(AddFriendVerifyFragment.a(this.e), (String)localObject, this.b, (byte)0, str1, this.c, i, false, null, false, null, str2, this.e.getActivity().getIntent().getBundleExtra("flc_extra_param"), true);
    }
    else
    {
      QQToast.makeText(this.e.getActivity(), 1, this.e.getString(2131892104), 0).show(this.e.getQBaseActivity().getTitleBarHeight());
    }
    ReportController.b(AddFriendVerifyFragment.f(this.e), "dc00898", "", "", "0X80077B4", "0X80077B4", 0, 0, String.valueOf(this.c), String.valueOf(this.d), "", "");
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportClickEvent action: 0X80077B4  sourceId = ");
      ((StringBuilder)localObject).append(this.c);
      ((StringBuilder)localObject).append(" subSourceId = ");
      ((StringBuilder)localObject).append(this.d);
      QLog.d("IphoneTitleBarFragment", 2, ((StringBuilder)localObject).toString());
    }
    if (!TextUtils.isEmpty(this.e.b)) {
      ReportController.b(AddFriendVerifyFragment.f(this.e), "dc00899", "Qidian", "", "0X8008802", "ClickAddFriendButton", 0, 1, "", "", "", "");
    }
    this.e.a(this.c, this.b);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.addfriend.ui.AddFriendVerifyFragment.6
 * JD-Core Version:    0.7.0.1
 */