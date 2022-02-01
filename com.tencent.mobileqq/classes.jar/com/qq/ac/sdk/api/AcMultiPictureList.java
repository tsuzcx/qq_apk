package com.qq.ac.sdk.api;

import com.qq.ac.sdk.a.a.a;
import com.qq.ac.sdk.bean.AcMultiPictureListResponse;
import com.qq.ac.sdk.listener.AcMultiPictureListListener;
import java.util.List;

public class AcMultiPictureList
  extends BaseAcApi<AcMultiPictureList, AcMultiPictureListListener>
{
  public void getMultiPictureList(String paramString, List<String> paramList)
  {
    this.mAcComicImpl.a(paramString, paramList);
  }
  
  public AcMultiPictureList setListener(AcMultiPictureListListener paramAcMultiPictureListListener)
  {
    this.mAcComicImpl.a(paramAcMultiPictureListListener);
    return this;
  }
  
  public AcMultiPictureListResponse syncGetMultiPictureList(String paramString, List<String> paramList)
  {
    return this.mAcComicImpl.b(paramString, paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.qq.ac.sdk.api.AcMultiPictureList
 * JD-Core Version:    0.7.0.1
 */