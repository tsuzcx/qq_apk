package com.tencent.biz.qqstory.album.strategy;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.album.model.StoryAlbum;
import com.tencent.biz.qqstory.album.model.StoryAlbum.PicInfo;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.AssertUtils;
import java.util.List;

public abstract class AbstractSplitStrategy<Config extends SplitConfig.BaseSplitConfig>
{
  protected StoryAlbum a;
  private Config a;
  
  public Config a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryAlbumStrategySplitConfig$BaseSplitConfig;
  }
  
  protected List<StoryAlbum.PicInfo> a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum != null) {
      return this.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum.a();
    }
    return null;
  }
  
  protected abstract List<StoryAlbum> a(@NonNull List<StoryAlbum.PicInfo> paramList);
  
  public void a(StoryAlbum paramStoryAlbum)
  {
    if (paramStoryAlbum.b() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      AssertUtils.a(bool);
      this.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum = paramStoryAlbum;
      return;
    }
  }
  
  public void a(Config paramConfig)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryAlbumStrategySplitConfig$BaseSplitConfig = paramConfig;
  }
  
  public List<StoryAlbum> b()
  {
    List localList = a();
    if ((localList == null) || (localList.size() == 0))
    {
      SLog.d("Q.qqstory.recommendAlbum.logic.AbstractSplitStrategy", "data is null");
      return null;
    }
    if ((a() != null) && (localList.size() < a().b))
    {
      SLog.d("Q.qqstory.recommendAlbum.logic.AbstractSplitStrategy", "too little data");
      return null;
    }
    return a(a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.strategy.AbstractSplitStrategy
 * JD-Core Version:    0.7.0.1
 */