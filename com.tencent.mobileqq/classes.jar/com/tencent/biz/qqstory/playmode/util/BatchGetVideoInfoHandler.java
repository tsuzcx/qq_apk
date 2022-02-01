package com.tencent.biz.qqstory.playmode.util;

import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class BatchGetVideoInfoHandler
{
  public ArrayList<String> a;
  public int b;
  public int c;
  public int d;
  public int e;
  public BatchGetVideoInfoHandler.IBatchGetVideoInfoCallback f;
  
  public void a(int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleFail, reqType:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.e("BatchGetVideoInfoHandler", 2, ((StringBuilder)localObject).toString());
    }
    if (this.f != null)
    {
      localObject = new BatchGetVideoInfoHandler.VideoInfoListEvent();
      ((BatchGetVideoInfoHandler.VideoInfoListEvent)localObject).a = paramInt;
      paramInt = this.b;
      boolean bool2 = false;
      if (paramInt == 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      ((BatchGetVideoInfoHandler.VideoInfoListEvent)localObject).c = bool1;
      boolean bool1 = bool2;
      if (this.c == this.a.size() - 1) {
        bool1 = true;
      }
      ((BatchGetVideoInfoHandler.VideoInfoListEvent)localObject).d = bool1;
      ((BatchGetVideoInfoHandler.VideoInfoListEvent)localObject).f = -100;
      this.f.a((BatchGetVideoInfoHandler.VideoInfoListEvent)localObject);
    }
  }
  
  public void a(int paramInt, ArrayList<StoryVideoItem> paramArrayList)
  {
    if (this.f != null)
    {
      BatchGetVideoInfoHandler.VideoInfoListEvent localVideoInfoListEvent = new BatchGetVideoInfoHandler.VideoInfoListEvent();
      localVideoInfoListEvent.a = paramInt;
      int i = this.b;
      boolean bool2 = true;
      boolean bool1;
      if (i == 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      localVideoInfoListEvent.c = bool1;
      if (this.c == this.a.size()) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      localVideoInfoListEvent.d = bool1;
      localVideoInfoListEvent.b = paramArrayList;
      localVideoInfoListEvent.f = 0;
      if (paramInt == 0) {
        localVideoInfoListEvent.e = (this.d - this.b);
      }
      this.f.a(localVideoInfoListEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.util.BatchGetVideoInfoHandler
 * JD-Core Version:    0.7.0.1
 */