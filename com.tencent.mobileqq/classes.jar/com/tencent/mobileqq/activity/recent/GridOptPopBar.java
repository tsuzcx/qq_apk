package com.tencent.mobileqq.activity.recent;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.PopupMenuDialog;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import com.tencent.widget.PopupMenuDialog.OnClickActionListener;
import com.tencent.widget.PopupMenuDialog.OnDismissListener;
import java.util.ArrayList;
import java.util.List;

public class GridOptPopBar
{
  public static PopupMenuDialog.MenuItem c = new PopupMenuDialog.MenuItem(2131430848, BaseApplicationImpl.getContext().getString(2131917073), BaseApplicationImpl.getContext().getString(2131917073), 2130845693);
  public static PopupMenuDialog.MenuItem d = new PopupMenuDialog.MenuItem(2131430849, BaseApplicationImpl.getContext().getString(2131917074), BaseApplicationImpl.getContext().getString(2131917074), 2130845692);
  public static PopupMenuDialog.MenuItem e = new PopupMenuDialog.MenuItem(2131430846, BaseApplicationImpl.getContext().getString(2131917072), BaseApplicationImpl.getContext().getString(2131917072), 2130845691);
  public Activity a;
  RedTouch b = null;
  private List<PopupMenuDialog.MenuItem> f;
  private PopupMenuDialog.OnDismissListener g;
  private PopupMenuDialog.OnClickActionListener h;
  private PopupMenuDialog i;
  
  public GridOptPopBar(Activity paramActivity, List<PopupMenuDialog.MenuItem> paramList, PopupMenuDialog.OnClickActionListener paramOnClickActionListener)
  {
    this.a = paramActivity;
    this.f = paramList;
    this.h = paramOnClickActionListener;
  }
  
  private void b()
  {
    ArrayList localArrayList = new ArrayList();
    List localList = this.f;
    if ((localList != null) && (localList.size() > 0))
    {
      int j = 0;
      while (j < this.f.size())
      {
        localArrayList.add(this.f.get(j));
        j += 1;
      }
    }
    this.i = PopupMenuDialog.build(this.a, localArrayList, this.h, this.g);
  }
  
  @NonNull
  private boolean c()
  {
    PopupMenuDialog localPopupMenuDialog = this.i;
    return (localPopupMenuDialog != null) && (localPopupMenuDialog.isShowing());
  }
  
  public void a()
  {
    if (c()) {
      this.i.dismiss();
    }
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    a(paramView, paramInt1, paramInt2, -1);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.i == null) {
      b();
    }
    this.i.showAsDropDown(paramView, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.GridOptPopBar
 * JD-Core Version:    0.7.0.1
 */