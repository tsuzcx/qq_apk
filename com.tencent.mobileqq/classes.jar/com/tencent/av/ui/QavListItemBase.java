package com.tencent.av.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.av.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public abstract class QavListItemBase
  extends LinearLayout
  implements View.OnClickListener
{
  protected int a;
  Context jdField_a_of_type_AndroidContentContext;
  QavListItemBase.IClickCallback jdField_a_of_type_ComTencentAvUiQavListItemBase$IClickCallback;
  final String jdField_a_of_type_JavaLangString;
  
  public QavListItemBase(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    paramContext = new StringBuilder();
    paramContext.append(getClass().getSimpleName());
    paramContext.append("_");
    paramContext.append(AudioHelper.b());
    this.jdField_a_of_type_JavaLangString = paramContext.toString();
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
    if (this.jdField_a_of_type_ComTencentAvUiQavListItemBase$IClickCallback != null)
    {
      long l = AudioHelper.b();
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onClick, seq[");
      localStringBuilder.append(l);
      localStringBuilder.append("], mPosition[");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
      this.jdField_a_of_type_ComTencentAvUiQavListItemBase$IClickCallback.a(l, this.jdField_a_of_type_Int, this);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public abstract void setHighlight(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.QavListItemBase
 * JD-Core Version:    0.7.0.1
 */