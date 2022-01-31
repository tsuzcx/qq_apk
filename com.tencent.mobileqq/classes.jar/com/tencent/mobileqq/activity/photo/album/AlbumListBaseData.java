package com.tencent.mobileqq.activity.photo.album;

import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import java.util.ArrayList;

public class AlbumListBaseData
{
  public MediaFileFilter filter;
  public boolean filterVideoGif = false;
  public boolean isBothwidthheight = false;
  public ArrayList<String> recentImagesBlockPaths = null;
  public int recentImagesLimitSize = 210;
  public int recentImagesLimitWidth = -1;
  public int recentImagesMaxCount = 100;
  public int showMediaType;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.AlbumListBaseData
 * JD-Core Version:    0.7.0.1
 */