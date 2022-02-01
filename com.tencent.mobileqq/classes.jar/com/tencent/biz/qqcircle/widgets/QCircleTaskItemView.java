package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import qqcircle.TaskCenterReader.TaskRecord;
import wco;

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
  
  public int a()
  {
    return 2131560818;
  }
  
  protected String a()
  {
    return "QCircleTaskItemView";
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.a = ((TextView)findViewById(2131380125));
    this.b = ((TextView)findViewById(2131380123));
    this.c = ((TextView)findViewById(2131380122));
  }
  
  protected void a(TaskCenterReader.TaskRecord paramTaskRecord)
  {
    boolean bool = false;
    TextView localTextView;
    if (paramTaskRecord != null)
    {
      this.a.setText(paramTaskRecord.title.get());
      this.b.setText(paramTaskRecord.taskDesc.get());
      this.c.setText(paramTaskRecord.bottonDesc.get());
      localTextView = this.c;
      if (paramTaskRecord.bottonJumpFlag.get() <= 0) {
        break label114;
      }
    }
    label114:
    for (int i = 2130843913;; i = 0)
    {
      localTextView.setBackgroundResource(i);
      localTextView = this.c;
      if (paramTaskRecord.bottonJumpFlag.get() > 0) {
        bool = true;
      }
      localTextView.setClickable(bool);
      this.c.setOnClickListener(new wco(this, paramTaskRecord));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleTaskItemView
 * JD-Core Version:    0.7.0.1
 */