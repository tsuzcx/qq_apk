package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.biz.pubaccount.readinjoy.logic.ReadinjoyAtlasPageLoader.Result;

public class AtlasModeLoadingMore
  extends AtlasModel
{
  public ReadinjoyAtlasPageLoader.Result mErrorInfo;
  public boolean mIsLoadingState;
  
  public AtlasModeLoadingMore(boolean paramBoolean, ReadinjoyAtlasPageLoader.Result paramResult)
  {
    this.type = 4;
    this.mIsLoadingState = paramBoolean;
    this.mErrorInfo = paramResult;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.AtlasModeLoadingMore
 * JD-Core Version:    0.7.0.1
 */