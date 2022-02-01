package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import qqcircle.TaskCenterReader.TaskRecord;

public class QCircleTaskItemView
  extends QCircleBaseWidgetView<TaskCenterReader.TaskRecord>
{
  TextView a;
  TextView b;
  TextView c;
  
  public QCircleTaskItemView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  protected void a(TaskCenterReader.TaskRecord paramTaskRecord, int paramInt)
  {
    if (paramTaskRecord != null)
    {
      this.a.setText(paramTaskRecord.title.get());
      this.b.setText(paramTaskRecord.taskDesc.get());
      this.c.setText(paramTaskRecord.bottonDesc.get());
      TextView localTextView = this.c;
      paramInt = paramTaskRecord.bottonJumpFlag.get();
      boolean bool = false;
      if (paramInt > 0) {
        paramInt = 2130845321;
      } else {
        paramInt = 0;
      }
      localTextView.setBackgroundResource(paramInt);
      localTextView = this.c;
      if (paramTaskRecord.bottonJumpFlag.get() > 0) {
        bool = true;
      }
      localTextView.setEnabled(bool);
      this.c.setOnClickListener(new QCircleTaskItemView.1(this, paramTaskRecord));
      if ((!TextUtils.isEmpty(paramTaskRecord.jumpUrl.get())) && (paramTaskRecord.jumpUrl.get().startsWith("mqqapi://qcircle/openRewardAd"))) {
        QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(HostDataTransUtils.getAccount()).setActionType(70).setSubActionType(1).setThrActionType(6));
      }
    }
  }
  
  public int getLayoutId()
  {
    return 2131626976;
  }
  
  protected String getLogTag()
  {
    return "QCircleTaskItemView";
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    this.a = ((TextView)findViewById(2131448799));
    this.b = ((TextView)findViewById(2131448797));
    this.c = ((TextView)findViewById(2131448796));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleTaskItemView
 * JD-Core Version:    0.7.0.1
 */