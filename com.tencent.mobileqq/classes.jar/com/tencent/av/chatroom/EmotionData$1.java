package com.tencent.av.chatroom;

import java.util.Comparator;

final class EmotionData$1
  implements Comparator<EmotionData>
{
  public int a(EmotionData paramEmotionData1, EmotionData paramEmotionData2)
  {
    if (paramEmotionData1 == paramEmotionData2) {
      return 0;
    }
    if (paramEmotionData1 == null) {
      return -1;
    }
    if (paramEmotionData2 == null) {
      return 1;
    }
    return paramEmotionData1.a - paramEmotionData2.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.chatroom.EmotionData.1
 * JD-Core Version:    0.7.0.1
 */