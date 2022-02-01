package com.tencent.avgame.gamelobby.data;

import androidx.annotation.NonNull;
import java.util.List;

public class AVGameLobbyBannerContentInfo
  extends AVGameBaseData
{
  private List<AVGameLobbyConstants.BannerInfo> a = null;
  
  public int a()
  {
    return 0;
  }
  
  public void a(List<AVGameLobbyConstants.BannerInfo> paramList)
  {
    this.a = paramList;
  }
  
  public List<AVGameLobbyConstants.BannerInfo> b()
  {
    return this.a;
  }
  
  @NonNull
  public int c()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelobby.data.AVGameLobbyBannerContentInfo
 * JD-Core Version:    0.7.0.1
 */