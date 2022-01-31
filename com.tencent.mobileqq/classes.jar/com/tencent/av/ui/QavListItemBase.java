package com.tencent.av.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

public abstract class QavListItemBase
  extends LinearLayout
  implements View.OnClickListener
{
  protected int a;
  Context jdField_a_of_type_AndroidContentContext;
  QavListItemBase.IClickCallback jdField_a_of_type_ComTencentAvUiQavListItemBase$IClickCallback;
  
  public QavListItemBase(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a(int paramInt) {}
  
  public abstract void a(int paramInt1, int paramInt2);
  
  public void a(int paramInt, QavListItemBase.IClickCallback paramIClickCallback)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentAvUiQavListItemBase$IClickCallback = paramIClickCallback;
  }
  
  public abstract void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, QavListItemBase.ItemInfo paramItemInfo, QavListItemBase.IClickCallback paramIClickCallback);
  
  public void a(QavListItemBase.ItemInfo paramItemInfo, int paramInt) {}
  
  public abstract void b(int paramInt1, int paramInt2);
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentAvUiQavListItemBase$IClickCallback != null) {
      this.jdField_a_of_type_ComTencentAvUiQavListItemBase$IClickCallback.a(this.jdField_a_of_type_Int, this);
    }
  }
  
  public abstract void setHighlight(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.QavListItemBase
 * JD-Core Version:    0.7.0.1
 */