package com.tencent.aelight.camera.aioeditor.takevideo;

import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.FaceLayer.FaceItem;
import java.util.Comparator;

final class EditVideoDoodle$PoiComparator
  implements Comparator<FaceLayer.FaceItem>
{
  public int a(FaceLayer.FaceItem paramFaceItem1, FaceLayer.FaceItem paramFaceItem2)
  {
    long l = paramFaceItem1.v - paramFaceItem2.v;
    if (l < 0L) {
      return -1;
    }
    if (l == 0L) {
      return 0;
    }
    return 1;
  }
  
  public boolean equals(Object paramObject)
  {
    return (paramObject != null) && ((paramObject instanceof PoiComparator));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditVideoDoodle.PoiComparator
 * JD-Core Version:    0.7.0.1
 */