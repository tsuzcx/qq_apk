package com.tencent.biz.qqcircle.immersive.part.folder.homepage;

import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.tencent.biz.qqcircle.immersive.views.QFSViewPager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QFSHomePageFragmentPart$1
  implements RadioGroup.OnCheckedChangeListener
{
  QFSHomePageFragmentPart$1(QFSHomePageFragmentPart paramQFSHomePageFragmentPart) {}
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    int i = QFSHomePageFragmentPart.a(this.a).getId();
    boolean bool = true;
    if (i == paramInt) {
      QFSHomePageFragmentPart.b(this.a).setCurrentItem(0);
    } else if (QFSHomePageFragmentPart.c(this.a).getId() == paramInt) {
      QFSHomePageFragmentPart.b(this.a).setCurrentItem(1);
    }
    QFSHomePageFragmentPart localQFSHomePageFragmentPart = this.a;
    if (QFSHomePageFragmentPart.a(localQFSHomePageFragmentPart).getId() != paramInt) {
      bool = false;
    }
    localQFSHomePageFragmentPart.c("qfs_set_folder_viewpage_scrollable", Boolean.valueOf(bool));
    EventCollector.getInstance().onCheckedChanged(paramRadioGroup, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.part.folder.homepage.QFSHomePageFragmentPart.1
 * JD-Core Version:    0.7.0.1
 */