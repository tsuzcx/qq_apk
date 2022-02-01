package com.tencent.aelight.camera.aioeditor.capture.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.aelight.camera.aioeditor.capture.AbsQIMCaptureController;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class QIMProviderContainerView$1
  implements View.OnClickListener
{
  QIMProviderContainerView$1(QIMProviderContainerView paramQIMProviderContainerView) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131373983)
    {
      MusicProviderView localMusicProviderView = (MusicProviderView)QIMProviderContainerView.a(this.a).get(Integer.valueOf(104));
      if ((localMusicProviderView != null) && (!localMusicProviderView.c()))
      {
        QQToast.a(BaseApplicationImpl.getContext(), HardCodeUtil.a(2131709774), 0).a();
        return;
      }
    }
    switch (paramView.getId())
    {
    case 2131373984: 
    default: 
      break;
    case 2131373985: 
      StoryReportor.a("clk_face", StoryReportor.b(-1), 0, false, new String[0]);
      break;
    case 2131373983: 
      StoryReportor.a("clk_music", StoryReportor.b(-1), 0, false, new String[0]);
      break;
    case 2131373982: 
      StoryReportor.a("clk_filter", StoryReportor.b(-1), 0, false, new String[0]);
      break;
    case 2131373981: 
      StoryReportor.a("clk_effect", StoryReportor.b(-1), 0, false, new String[0]);
      break;
    case 2131373980: 
      StoryReportor.a("clk_beauty", StoryReportor.b(-1), 0, false, new String[0]);
    }
    int i = ((Integer)paramView.getTag()).intValue();
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("onclick, index: ");
      paramView.append(i);
      QLog.i("ProviderContainerView", 2, paramView.toString());
    }
    this.a.a(i, 0, null, false);
    if (QIMProviderContainerView.a(this.a) != null) {
      QIMProviderContainerView.a(this.a).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.view.QIMProviderContainerView.1
 * JD-Core Version:    0.7.0.1
 */