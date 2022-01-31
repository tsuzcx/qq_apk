package com.qq.taf.jce.dynamic;

import java.util.Comparator;

final class StructField$1
  implements Comparator<JceField>
{
  public int compare(JceField paramJceField1, JceField paramJceField2)
  {
    return paramJceField1.getTag() - paramJceField2.getTag();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.qq.taf.jce.dynamic.StructField.1
 * JD-Core Version:    0.7.0.1
 */