package com.tencent.mobileqq.activity.editservice;

import ColorNick.QC.GroupNickEmoji;
import ColorNick.QC.GroupNickItem;
import ColorNick.QC.readItemInfoRsp;
import android.os.Handler;
import com.tencent.mobileqq.app.SVIPObserver;
import com.tencent.mobileqq.vas.ColorNickColorPanelAdapter.ColorItem;
import java.util.ArrayList;
import java.util.Iterator;

class EditTroopMemberNickService$11
  extends SVIPObserver
{
  EditTroopMemberNickService$11(EditTroopMemberNickService paramEditTroopMemberNickService) {}
  
  public void onGetColorNickData(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && ((paramObject instanceof readItemInfoRsp)))
    {
      paramObject = (readItemInfoRsp)paramObject;
      EditTroopMemberNickService.d(this.a, paramObject.index);
      Object localObject1 = paramObject.urlprefix;
      Iterator localIterator;
      Object localObject2;
      if ((paramObject.emojilist != null) && (paramObject.emojilist.size() > 0) && (EditTroopMemberNickService.j(this.a).size() == 0))
      {
        localIterator = paramObject.emojilist.iterator();
        while (localIterator.hasNext())
        {
          localObject2 = (GroupNickEmoji)localIterator.next();
          EditTroopMemberNickService.j(this.a).add(Integer.valueOf(((GroupNickEmoji)localObject2).itemid));
        }
        this.a.L.sendEmptyMessage(260);
      }
      if ((paramObject.itemlist != null) && (paramObject.itemlist.size() > 0))
      {
        localIterator = paramObject.itemlist.iterator();
        while (localIterator.hasNext())
        {
          localObject2 = (GroupNickItem)localIterator.next();
          Object localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append((String)localObject1);
          ((StringBuilder)localObject3).append(((GroupNickItem)localObject2).url);
          localObject3 = ((StringBuilder)localObject3).toString();
          localObject2 = new ColorNickColorPanelAdapter.ColorItem(3, null, ((GroupNickItem)localObject2).itemid, (String)localObject3);
          EditTroopMemberNickService.k(this.a).add(localObject2);
        }
        localObject1 = this.a;
        int i = paramObject.left;
        paramBoolean = true;
        if (i != 1) {
          paramBoolean = false;
        }
        EditTroopMemberNickService.c((EditTroopMemberNickService)localObject1, paramBoolean);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.editservice.EditTroopMemberNickService.11
 * JD-Core Version:    0.7.0.1
 */