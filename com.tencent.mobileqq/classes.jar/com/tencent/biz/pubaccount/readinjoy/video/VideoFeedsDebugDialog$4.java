package com.tencent.biz.pubaccount.readinjoy.video;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.readinjoy.ReadInJoyHelper;

class VideoFeedsDebugDialog$4
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    boolean bool2 = ReadInJoyHelper.d();
    Object localObject1 = Aladdin.getConfig(260);
    Object localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsDebugDialog;
    boolean bool1;
    if (!bool2)
    {
      bool1 = true;
      ((AladdinConfig)localObject1).update(VideoFeedsDebugDialog.a((VideoFeedsDebugDialog)localObject2, bool1));
      localObject2 = (Button)paramView;
      if (bool2) {
        break label80;
      }
    }
    label80:
    for (localObject1 = "关Titkok(需退出一拖三)";; localObject1 = "开Tittok(需退出一拖三)")
    {
      ((Button)localObject2).setText((CharSequence)localObject1);
      this.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(paramView);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bool1 = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsDebugDialog.4
 * JD-Core Version:    0.7.0.1
 */