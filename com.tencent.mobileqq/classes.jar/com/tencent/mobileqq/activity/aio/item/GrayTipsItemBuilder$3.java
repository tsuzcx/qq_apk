package com.tencent.mobileqq.activity.aio.item;

import android.view.View;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil.TipsClickedInterface;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

class GrayTipsItemBuilder$3
  implements FileManagerUtil.TipsClickedInterface
{
  GrayTipsItemBuilder$3(GrayTipsItemBuilder paramGrayTipsItemBuilder) {}
  
  public void onClick(View paramView)
  {
    paramView = DialogUtil.a(this.a.a, 230);
    paramView.setTitle(2131691602);
    paramView.setMessage(2131691603);
    paramView.setNegativeButton(2131690800, new GrayTipsItemBuilder.3.1(this, paramView));
    paramView.setPositiveButton(2131694615, new GrayTipsItemBuilder.3.2(this));
    paramView.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder.3
 * JD-Core Version:    0.7.0.1
 */