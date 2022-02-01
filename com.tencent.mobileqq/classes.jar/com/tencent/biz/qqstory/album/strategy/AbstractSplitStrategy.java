package com.tencent.biz.qqstory.album.strategy;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.album.model.StoryAlbum;
import com.tencent.biz.qqstory.album.model.StoryAlbum.PicInfo;
import com.tencent.biz.qqstory.album.model.strategy.BaseSplitConfig;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.AssertUtils;
import java.util.List;

public abstract class AbstractSplitStrategy<Config extends BaseSplitConfig>
{
  protected StoryAlbum a;
  private Config b;
  
  public Config a()
  {
    return this.b;
  }
  
  protected abstract List<StoryAlbum> a(@NonNull List<StoryAlbum.PicInfo> paramList);
  
  public void a(StoryAlbum paramStoryAlbum)
  {
    boolean bool;
    if (paramStoryAlbum.c() > 0) {
      bool = true;
    } else {
      bool = false;
    }
    AssertUtils.assertTrue(bool);
    this.a = paramStoryAlbum;
  }
  
  public void a(Config paramConfig)
  {
    this.b = paramConfig;
  }
  
  protected List<StoryAlbum.PicInfo> b()
  {
    StoryAlbum localStoryAlbum = this.a;
    if (localStoryAlbum != null) {
      return localStoryAlbum.a();
    }
    return null;
  }
  
  public List<StoryAlbum> c()
  {
    List localList = b();
    if ((localList != null) && (localList.size() != 0))
    {
      if ((a() != null) && (localList.size() < a().b))
      {
        SLog.d("Q.qqstory.recommendAlbum.logic.AbstractSplitStrategy", "too little data");
        return null;
      }
      return a(b());
    }
    SLog.d("Q.qqstory.recommendAlbum.logic.AbstractSplitStrategy", "data is null");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.strategy.AbstractSplitStrategy
 * JD-Core Version:    0.7.0.1
 */