package com.tencent.mobileqq.activity.aio.stickerrecommended;

public class StickerRecDataUtils
{
  public static boolean a(IStickerRecEmoticon paramIStickerRecEmoticon)
  {
    if ((paramIStickerRecEmoticon == null) || (!(paramIStickerRecEmoticon instanceof StickerRecData))) {}
    while (((StickerRecData)paramIStickerRecEmoticon).e() != 3) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecDataUtils
 * JD-Core Version:    0.7.0.1
 */