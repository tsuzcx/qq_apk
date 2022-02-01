package com.tencent.biz.qqcircle.bizparts;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QCirclePluginDebugPart$2
  implements View.OnClickListener
{
  QCirclePluginDebugPart$2(QCirclePluginDebugPart paramQCirclePluginDebugPart, EditText paramEditText, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    String str = this.a.getText().toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("scheme:");
    localStringBuilder.append(str);
    QLog.d("QCirclePluginDebugPart", 1, localStringBuilder.toString());
    QCircleLauncher.a(this.c.g(), str);
    this.b.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCirclePluginDebugPart.2
 * JD-Core Version:    0.7.0.1
 */