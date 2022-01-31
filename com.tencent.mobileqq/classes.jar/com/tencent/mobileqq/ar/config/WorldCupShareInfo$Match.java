package com.tencent.mobileqq.ar.config;

import com.tencent.mobileqq.util.JSONUtils.GenericType;
import java.util.ArrayList;

public class WorldCupShareInfo$Match
{
  public String begin_time;
  @JSONUtils.GenericType(a=WorldCupShareInfo.ClothesText.class)
  public ArrayList clothes_text = new ArrayList();
  public int id;
  @JSONUtils.GenericType(a=WorldCupShareInfo.MainText.class)
  public ArrayList main_text = new ArrayList();
  @JSONUtils.GenericType(a=WorldCupShareInfo.MainTitle.class)
  public ArrayList main_title = new ArrayList();
  @JSONUtils.GenericType(a=WorldCupShareInfo.PkTitle.class)
  public ArrayList pk_title = new ArrayList();
  @JSONUtils.GenericType(a=String.class)
  public ArrayList social_title = new ArrayList();
  public String title;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.config.WorldCupShareInfo.Match
 * JD-Core Version:    0.7.0.1
 */