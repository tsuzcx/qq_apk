package com.tencent.biz.pubaccount.weishi_new.drama.cache;

public class WSEpisodeResultUtil
{
  private static int a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      return 1;
    }
    if (paramBoolean2) {
      return 3;
    }
    return 2;
  }
  
  public static WSDramaEpisodeDataFetcher.EpisodeExt a(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    WSDramaEpisodeDataFetcher.EpisodeExt localEpisodeExt = new WSDramaEpisodeDataFetcher.EpisodeExt();
    localEpisodeExt.a = paramString;
    localEpisodeExt.b = paramBoolean2;
    if (paramBoolean2) {
      localEpisodeExt.d = paramBoolean3;
    } else {
      localEpisodeExt.c = paramBoolean3;
    }
    localEpisodeExt.e = a(paramBoolean1, paramBoolean2);
    return localEpisodeExt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.cache.WSEpisodeResultUtil
 * JD-Core Version:    0.7.0.1
 */