package com.tencent.biz.videostory.widget.view;

import com.tencent.biz.videostory.adapter.MineWSAdapter.NewFeedItemData;

class MineWSPanel$2
  implements MineWSPanel.OnItemClickListener
{
  MineWSPanel$2(MineWSPanel paramMineWSPanel) {}
  
  public void a(MineWSAdapter.NewFeedItemData paramNewFeedItemData)
  {
    int i = paramNewFeedItemData.a();
    if ((MineWSPanel.b(this.a)) && (i == 100))
    {
      MineWSPanel.a(this.a, true);
      return;
    }
    MineWSPanel.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.videostory.widget.view.MineWSPanel.2
 * JD-Core Version:    0.7.0.1
 */