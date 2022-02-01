package com.tencent.biz.qqstory.takevideo.doodle.ui.doodle;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.takevideo.doodle.layer.base.BaseLayer;
import com.tencent.biz.qqstory.takevideo.doodle.layer.base.DoodleStrategy;
import java.util.Arrays;
import java.util.List;

public class DoodleLayout$NormalDoodleStategy
  implements DoodleStrategy
{
  @NonNull
  private final BaseLayer[] a;
  
  public DoodleLayout$NormalDoodleStategy(BaseLayer... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {
      throw new IllegalArgumentException("layers should not be null or empty");
    }
    this.a = paramVarArgs;
  }
  
  public void a(List<BaseLayer> paramList, DoodleView paramDoodleView)
  {
    paramList.addAll(Arrays.asList(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout.NormalDoodleStategy
 * JD-Core Version:    0.7.0.1
 */