package com.tencent.aelight.camera.aioeditor.takevideo.view.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.aelight.camera.aioeditor.capture.data.QIMFilterCategoryItem;
import com.tencent.aelight.camera.log.AEQLog;

class AEFilterListAdapter$2
  implements View.OnClickListener
{
  AEFilterListAdapter$2(AEFilterListAdapter paramAEFilterListAdapter, QIMFilterCategoryItem paramQIMFilterCategoryItem) {}
  
  public void onClick(View paramView)
  {
    if (paramView == null)
    {
      AEQLog.d("AEFilterListAdapter", "view is null.");
      return;
    }
    AEFilterListAdapter.a(this.b, paramView.getContext(), this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.view.widget.AEFilterListAdapter.2
 * JD-Core Version:    0.7.0.1
 */