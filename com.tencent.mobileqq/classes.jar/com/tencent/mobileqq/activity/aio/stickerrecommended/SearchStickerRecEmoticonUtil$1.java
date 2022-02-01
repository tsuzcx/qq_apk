package com.tencent.mobileqq.activity.aio.stickerrecommended;

import java.util.Comparator;

final class SearchStickerRecEmoticonUtil$1
  implements Comparator<IEmoticonSort>
{
  public int a(IEmoticonSort paramIEmoticonSort1, IEmoticonSort paramIEmoticonSort2)
  {
    if ((paramIEmoticonSort1 != null) && (paramIEmoticonSort2 != null)) {
      return Float.compare(paramIEmoticonSort1.a(), paramIEmoticonSort2.a());
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.SearchStickerRecEmoticonUtil.1
 * JD-Core Version:    0.7.0.1
 */