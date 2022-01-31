package com.tencent.mobileqq.ar.config;

import com.tencent.mobileqq.util.JSONUtils.GenericType;
import com.tencent.mobileqq.util.JSONUtils.NotKey;
import java.util.ArrayList;

public class WorldCupShareInfo$Template
{
  @JSONUtils.GenericType(a=String.class)
  public ArrayList clothes_number = new ArrayList();
  @JSONUtils.GenericType(a=WorldCupShareInfo.ColorScheme.class)
  public ArrayList color_scheme = new ArrayList();
  @JSONUtils.NotKey
  public WorldCupShareInfo.Column column1;
  @JSONUtils.NotKey
  public WorldCupShareInfo.Column column2;
  public String column_image;
  public String date;
  @JSONUtils.GenericType(a=WorldCupShareInfo.Match.class)
  public ArrayList matches = new ArrayList();
  public String news_paper_title_list;
  public int template_id;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.config.WorldCupShareInfo.Template
 * JD-Core Version:    0.7.0.1
 */