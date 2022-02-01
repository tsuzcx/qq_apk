package com.tencent.mobileqq.activity.aio.stickerrecommended;

public class StickerRecDataUtils
{
  public static boolean a(IStickerRecEmoticon paramIStickerRecEmoticon)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramIStickerRecEmoticon != null)
    {
      if (!(paramIStickerRecEmoticon instanceof StickerRecData)) {
        return false;
      }
      bool1 = bool2;
      if (((StickerRecData)paramIStickerRecEmoticon).s() == 3) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecDataUtils
 * JD-Core Version:    0.7.0.1
 */