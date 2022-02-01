package com.tencent.mobileqq.addfriend.ui;

import android.app.Dialog;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

class AddFriendVerifyFragment$3
  extends AddFriendVerifyFragment.AddFriendOnclick
{
  AddFriendVerifyFragment$3(AddFriendVerifyFragment paramAddFriendVerifyFragment, int paramInt)
  {
    super(paramAddFriendVerifyFragment);
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    if (this.b.f != null)
    {
      this.b.getActivity().getWindow().setSoftInputMode(2);
      this.b.f.hideSoftInputFromWindow(AddFriendVerifyFragment.c(this.b).getWindowToken(), 0);
      AddFriendVerifyFragment.c(this.b).clearFocus();
    }
    Object localObject;
    if (AddFriendVerifyFragment.c(this.b).getText().toString().length() > 30)
    {
      localObject = new ReportDialog(this.b.getActivity(), 2131953338);
      ((Dialog)localObject).setContentView(2131629210);
      ((TextView)((Dialog)localObject).findViewById(2131431876)).setText(this.b.getString(2131888051));
      ((ProgressBar)((Dialog)localObject).findViewById(2131433567)).setVisibility(8);
      ((ImageView)((Dialog)localObject).findViewById(2131449154)).setImageResource(2130840055);
      ((Dialog)localObject).show();
    }
    else
    {
      localObject = AddFriendVerifyFragment.c(this.b).getText().toString().trim();
      this.b.a((String)localObject, false);
      if ((this.b.getString(2131888921).equals(localObject)) && (!AddFriendVerifyFragment.d(this.b))) {
        AddFriendVerifyFragment.e(this.b);
      }
      localObject = this.b;
      ((AddFriendVerifyFragment)localObject).a(AddFriendVerifyFragment.c((AddFriendVerifyFragment)localObject).getText().toString().trim());
      if (this.a == 0) {
        ReportController.b(AddFriendVerifyFragment.f(this.b), "dc00898", "", "", "0X800796F", "0X800796F", 0, 0, "", "", "", "");
      } else {
        ReportController.b(AddFriendVerifyFragment.f(this.b), "dc00898", "", "", "0X8007976", "0X8007976", 0, 0, "", "", "", "");
      }
      if (!TextUtils.isEmpty(this.b.b)) {
        ReportController.b(AddFriendVerifyFragment.f(this.b), "dc00899", "Qidian", "", "0X8008802", "ClickAddFriendButton", 0, 0, "1", "", "", "");
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.addfriend.ui.AddFriendVerifyFragment.3
 * JD-Core Version:    0.7.0.1
 */