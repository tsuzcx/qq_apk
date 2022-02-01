package com.tencent.mobileqq.adapter;

import java.util.Comparator;

final class ContactBindedAdapter$1
  implements Comparator<String>
{
  public int a(String paramString1, String paramString2)
  {
    if ("★".equals(paramString2)) {}
    do
    {
      return 1;
      if ("★".equals(paramString1)) {
        return -1;
      }
      if ("#".equals(paramString2)) {
        return -1;
      }
    } while ("#".equals(paramString1));
    return paramString1.compareTo(paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.ContactBindedAdapter.1
 * JD-Core Version:    0.7.0.1
 */