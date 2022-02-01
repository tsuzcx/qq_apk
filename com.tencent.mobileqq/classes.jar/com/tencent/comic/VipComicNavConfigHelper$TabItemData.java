package com.tencent.comic;

import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;

public class VipComicNavConfigHelper$TabItemData
  implements Comparable<TabItemData>
{
  int jdField_a_of_type_Int;
  String jdField_a_of_type_JavaLangString;
  String b;
  String c;
  String d;
  
  public int a(@NotNull TabItemData paramTabItemData)
  {
    int i = this.jdField_a_of_type_Int;
    int j = paramTabItemData.jdField_a_of_type_Int;
    if (i < j) {
      return -1;
    }
    if (i > j) {
      return 1;
    }
    i = VipComicNavConfigHelper.a().indexOf(this.jdField_a_of_type_JavaLangString);
    j = VipComicNavConfigHelper.a().indexOf(paramTabItemData.jdField_a_of_type_JavaLangString);
    if (i < j) {
      return -1;
    }
    if (i > j) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.comic.VipComicNavConfigHelper.TabItemData
 * JD-Core Version:    0.7.0.1
 */