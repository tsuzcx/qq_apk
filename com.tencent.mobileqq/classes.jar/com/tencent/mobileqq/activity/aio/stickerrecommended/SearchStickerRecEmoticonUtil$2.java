package com.tencent.mobileqq.activity.aio.stickerrecommended;

import android.util.SparseIntArray;
import java.util.Comparator;

final class SearchStickerRecEmoticonUtil$2
  implements Comparator<IEmoticonSort>
{
  public int a(IEmoticonSort paramIEmoticonSort1, IEmoticonSort paramIEmoticonSort2)
  {
    if ((paramIEmoticonSort1 != null) && (paramIEmoticonSort2 != null))
    {
      float f1 = SearchStickerRecEmoticonUtil.a().get(paramIEmoticonSort1.c());
      float f2 = SearchStickerRecEmoticonUtil.a().get(paramIEmoticonSort2.c());
      float f3 = paramIEmoticonSort1.b() * 100;
      float f4 = 1.0F / (paramIEmoticonSort1.a() + 1) / 10.0F;
      return Float.compare(paramIEmoticonSort2.b() * 100 + 1.0F / (paramIEmoticonSort2.a() + 1) / 10.0F + f2, f3 + f4 + f1);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.SearchStickerRecEmoticonUtil.2
 * JD-Core Version:    0.7.0.1
 */