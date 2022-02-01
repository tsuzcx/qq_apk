package com.tencent.lbssearch.object.param;

public enum TranslateParam$CoordType
{
  static
  {
    GPS = new CoordType("GPS", 1);
    SOGOU = new CoordType("SOGOU", 2);
    BAIDU = new CoordType("BAIDU", 3);
    MAPBAR = new CoordType("MAPBAR", 4);
    STANDARD = new CoordType("STANDARD", 5);
  }
  
  private TranslateParam$CoordType() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.lbssearch.object.param.TranslateParam.CoordType
 * JD-Core Version:    0.7.0.1
 */