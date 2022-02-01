package com.tencent.mobileqq.activity.aio.item;

import android.view.View;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil.TipsClickedInterface;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

class GrayTipsItemBuilder$3
  implements QQFileManagerUtil.TipsClickedInterface
{
  GrayTipsItemBuilder$3(GrayTipsItemBuilder paramGrayTipsItemBuilder) {}
  
  public void onClick(View paramView)
  {
    paramView = DialogUtil.a(this.a.c, 230);
    paramView.setTitle(2131888486);
    paramView.setMessage(2131888487);
    paramView.setNegativeButton(2131887648, new GrayTipsItemBuilder.3.1(this, paramView));
    paramView.setPositiveButton(2131892267, new GrayTipsItemBuilder.3.2(this));
    paramView.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder.3
 * JD-Core Version:    0.7.0.1
 */