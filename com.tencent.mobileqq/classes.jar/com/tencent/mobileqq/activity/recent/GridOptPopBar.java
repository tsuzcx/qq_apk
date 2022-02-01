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
  public static PopupMenuDialog.MenuItem a;
  public static PopupMenuDialog.MenuItem b = new PopupMenuDialog.MenuItem(2131364855, BaseApplicationImpl.getContext().getString(2131719787), BaseApplicationImpl.getContext().getString(2131719787), 2130844469);
  public static PopupMenuDialog.MenuItem c = new PopupMenuDialog.MenuItem(2131364852, BaseApplicationImpl.getContext().getString(2131719785), BaseApplicationImpl.getContext().getString(2131719785), 2130844468);
  public Activity a;
  RedTouch jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch = null;
  private PopupMenuDialog.OnClickActionListener jdField_a_of_type_ComTencentWidgetPopupMenuDialog$OnClickActionListener;
  private PopupMenuDialog.OnDismissListener jdField_a_of_type_ComTencentWidgetPopupMenuDialog$OnDismissListener;
  private PopupMenuDialog jdField_a_of_type_ComTencentWidgetPopupMenuDialog;
  private List<PopupMenuDialog.MenuItem> jdField_a_of_type_JavaUtilList;
  
  static
  {
    jdField_a_of_type_ComTencentWidgetPopupMenuDialog$MenuItem = new PopupMenuDialog.MenuItem(2131364854, BaseApplicationImpl.getContext().getString(2131719786), BaseApplicationImpl.getContext().getString(2131719786), 2130844470);
  }
  
  public GridOptPopBar(Activity paramActivity, List<PopupMenuDialog.MenuItem> paramList, PopupMenuDialog.OnClickActionListener paramOnClickActionListener)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog$OnClickActionListener = paramOnClickActionListener;
  }
  
  @NonNull
  private boolean a()
  {
    return (this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog != null) && (this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.isShowing());
  }
  
  private void b()
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        localArrayList.add(this.jdField_a_of_type_JavaUtilList.get(i));
        i += 1;
      }
    }
    this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog = PopupMenuDialog.a(this.jdField_a_of_type_AndroidAppActivity, localArrayList, this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog$OnClickActionListener, this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog$OnDismissListener);
  }
  
  public void a()
  {
    if (a()) {
      this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.dismiss();
    }
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    a(paramView, paramInt1, paramInt2, -1);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog == null) {
      b();
    }
    this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.showAsDropDown(paramView, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.GridOptPopBar
 * JD-Core Version:    0.7.0.1
 */