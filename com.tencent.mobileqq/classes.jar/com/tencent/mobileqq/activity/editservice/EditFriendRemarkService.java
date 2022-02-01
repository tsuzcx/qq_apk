package com.tencent.mobileqq.activity.editservice;

import android.content.Context;
import android.content.Intent;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.troop.activity.editinfo.IEditInfoActivity;
import com.tencent.mobileqq.troop.activity.editinfo.IEditInfoApi;
import com.tencent.mobileqq.widget.navbar.OnItemSelectListener;
import mqq.app.MobileQQ;

public class EditFriendRemarkService
  implements IEditInfoApi
{
  private AppInterface a;
  private IEditInfoActivity b = null;
  private Context c;
  private Boolean d = Boolean.valueOf(false);
  private String e;
  private String f;
  private Intent g;
  private final FriendListObserver h = new EditFriendRemarkService.2(this);
  
  public Intent a(Intent paramIntent)
  {
    this.e = paramIntent.getStringExtra("default_text");
    this.f = paramIntent.getStringExtra("uin");
    this.g = paramIntent;
    return paramIntent;
  }
  
  public void a()
  {
    this.a.removeObserver(this.h);
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 3) {
      a();
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(ViewGroup paramViewGroup1, EditText paramEditText, ViewGroup paramViewGroup2) {}
  
  public void a(IEditInfoActivity paramIEditInfoActivity)
  {
    this.a = ((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null));
    this.b = paramIEditInfoActivity;
    this.c = paramIEditInfoActivity.getContext();
    this.a.addObserver(this.h);
  }
  
  public OnItemSelectListener b()
  {
    return new EditFriendRemarkService.1(this);
  }
  
  public void c() {}
  
  public int d()
  {
    return 0;
  }
  
  public View.OnClickListener e()
  {
    return null;
  }
  
  public EmoticonCallback f()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.editservice.EditFriendRemarkService
 * JD-Core Version:    0.7.0.1
 */