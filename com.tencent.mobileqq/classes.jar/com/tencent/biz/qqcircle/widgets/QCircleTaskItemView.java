package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import qqcircle.TaskCenterReader.TaskRecord;
import ucx;

public class QCircleTaskItemView
  extends BaseWidgetView<TaskCenterReader.TaskRecord>
{
  TextView a;
  TextView b;
  TextView c;
  
  public QCircleTaskItemView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public int a()
  {
    return 2131560579;
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.a = ((TextView)findViewById(2131378974));
    this.b = ((TextView)findViewById(2131378972));
    this.c = ((TextView)findViewById(2131378971));
  }
  
  protected void a(TaskCenterReader.TaskRecord paramTaskRecord)
  {
    Object localObject;
    if (paramTaskRecord != null)
    {
      this.a.setText(paramTaskRecord.title.get());
      this.b.setText(String.format("%s（%d/%d）", new Object[] { paramTaskRecord.desc.get(), Integer.valueOf(paramTaskRecord.haveDone.get()), Integer.valueOf(paramTaskRecord.maxCnt.get()) }));
      TextView localTextView = this.c;
      StringBuilder localStringBuilder = new StringBuilder();
      if (paramTaskRecord.haveDone.get() >= paramTaskRecord.maxCnt.get()) {
        break label171;
      }
      localObject = "去";
      localTextView.setText((String)localObject + "完成");
      localObject = this.c;
      if (paramTaskRecord.haveDone.get() >= paramTaskRecord.maxCnt.get()) {
        break label177;
      }
    }
    label171:
    label177:
    for (int i = 2130843532;; i = 0)
    {
      ((TextView)localObject).setBackgroundResource(i);
      this.c.setOnClickListener(new ucx(this, paramTaskRecord));
      return;
      localObject = "已";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleTaskItemView
 * JD-Core Version:    0.7.0.1
 */