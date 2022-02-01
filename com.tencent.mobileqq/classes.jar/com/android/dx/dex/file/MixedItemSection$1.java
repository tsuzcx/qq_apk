package com.android.dx.dex.file;

import java.util.Comparator;

final class MixedItemSection$1
  implements Comparator<OffsettedItem>
{
  public int compare(OffsettedItem paramOffsettedItem1, OffsettedItem paramOffsettedItem2)
  {
    return paramOffsettedItem1.itemType().compareTo(paramOffsettedItem2.itemType());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.dex.file.MixedItemSection.1
 * JD-Core Version:    0.7.0.1
 */