package com.tencent.biz.pubaccount.readinjoy.video;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.readinjoy.ReadInJoyHelper;
import mqq.app.AppRuntime;

class VideoFeedsDebugDialog$3
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    boolean bool2 = ReadInJoyHelper.j(ReadInJoyUtils.a());
    Object localObject = ReadInJoyUtils.a();
    boolean bool1;
    Button localButton;
    if (!bool2)
    {
      bool1 = true;
      ReadInJoyHelper.i((AppRuntime)localObject, bool1);
      localButton = (Button)paramView;
      if (bool2) {
        break label68;
      }
    }
    label68:
    for (localObject = "关闭debug信息";; localObject = "开启debug信息")
    {
      localButton.setText((CharSequence)localObject);
      this.a.onClick(paramView);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bool1 = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsDebugDialog.3
 * JD-Core Version:    0.7.0.1
 */