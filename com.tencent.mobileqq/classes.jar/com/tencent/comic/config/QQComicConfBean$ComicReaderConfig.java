package com.tencent.comic.config;

import java.io.Serializable;

public class QQComicConfBean$ComicReaderConfig
  implements Serializable
{
  public static final int SECTION_COMMENT_MASTER_SWITCH_OFF = 0;
  public static final int SECTION_COMMENT_MASTER_SWITCH_ON = 1;
  public static final int SECTION_COMMENT_NUM_VS_DEFAULT = 1;
  public static final int SECTION_COMMENT_NUM_VS_MAX = 3;
  public boolean enablePreRead = true;
  public boolean enablePreload = false;
  public int preloadNum = 3;
  public boolean sectionCommentMasterSwitch = false;
  public int sectionCommentNumVS = 1;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.comic.config.QQComicConfBean.ComicReaderConfig
 * JD-Core Version:    0.7.0.1
 */