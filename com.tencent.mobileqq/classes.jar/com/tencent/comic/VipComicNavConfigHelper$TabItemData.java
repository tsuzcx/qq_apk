package com.tencent.comic;

import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;

public class VipComicNavConfigHelper$TabItemData
  implements Comparable<TabItemData>
{
  int a;
  String b;
  String c;
  String d;
  String e;
  
  public int a(@NotNull TabItemData paramTabItemData)
  {
    int i = this.a;
    int j = paramTabItemData.a;
    if (i < j) {
      return -1;
    }
    if (i > j) {
      return 1;
    }
    i = VipComicNavConfigHelper.j().indexOf(this.b);
    j = VipComicNavConfigHelper.j().indexOf(paramTabItemData.b);
    if (i < j) {
      return -1;
    }
    if (i > j) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.comic.VipComicNavConfigHelper.TabItemData
 * JD-Core Version:    0.7.0.1
 */