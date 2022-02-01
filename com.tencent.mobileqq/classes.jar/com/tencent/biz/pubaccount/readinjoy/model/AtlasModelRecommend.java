package com.tencent.biz.pubaccount.readinjoy.model;

import java.util.List;

public class AtlasModelRecommend
  extends AtlasModel
{
  public static final int STATE_DATA = 2;
  public static final int STATE_ERROR = 1;
  public static final int STATE_LOADING = 0;
  private AtlasModelRecommend.State mState = new AtlasModelRecommend.LoadingState(null);
  
  public AtlasModelRecommend()
  {
    this.type = 2;
  }
  
  public List<AtlasModelImageList> getRecommends()
  {
    return this.mState.a();
  }
  
  public boolean hasData()
  {
    return this.mState.b();
  }
  
  public boolean isError()
  {
    return this.mState.c();
  }
  
  public boolean isLoading()
  {
    return this.mState.a();
  }
  
  public void setState(int paramInt, List<AtlasModelImageList> paramList)
  {
    if (paramInt == 0) {
      this.mState = new AtlasModelRecommend.LoadingState(paramList);
    }
    do
    {
      return;
      if (paramInt == 1)
      {
        this.mState = new AtlasModelRecommend.ErrorState(paramList);
        return;
      }
    } while (paramInt != 2);
    this.mState = new AtlasModelRecommend.DataState(paramList);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mState =").append(this.mState);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.AtlasModelRecommend
 * JD-Core Version:    0.7.0.1
 */