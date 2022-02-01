package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.emoticonview.EmoticonListProvider;
import com.tencent.mobileqq.emoticonview.EmotionPanelInfo;
import java.util.ArrayList;
import java.util.List;

class GameMsgChatPie$9
  implements EmoticonListProvider
{
  GameMsgChatPie$9(GameMsgChatPie paramGameMsgChatPie) {}
  
  public List<EmotionPanelInfo> getEmotionPanelInfo(boolean paramBoolean1, boolean paramBoolean2)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new EmotionPanelInfo(7, 7, null));
    localArrayList.add(new EmotionPanelInfo(4, 4, null));
    localArrayList.add(new EmotionPanelInfo(12, 4, null));
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.GameMsgChatPie.9
 * JD-Core Version:    0.7.0.1
 */