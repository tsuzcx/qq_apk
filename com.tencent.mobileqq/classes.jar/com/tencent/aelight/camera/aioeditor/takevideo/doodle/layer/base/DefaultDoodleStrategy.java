package com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.base;

import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.DynamicFaceLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.FaceLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.LineLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.TextLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleView;
import java.util.List;

public class DefaultDoodleStrategy
  implements DoodleStrategy
{
  public void a(List<BaseLayer> paramList, DoodleView paramDoodleView)
  {
    FaceLayer localFaceLayer = new FaceLayer(paramDoodleView);
    DynamicFaceLayer localDynamicFaceLayer = new DynamicFaceLayer(paramDoodleView);
    LineLayer localLineLayer = new LineLayer(paramDoodleView);
    paramDoodleView = new TextLayer(paramDoodleView);
    paramList.add(localFaceLayer);
    paramList.add(localDynamicFaceLayer);
    paramList.add(localLineLayer);
    paramList.add(paramDoodleView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.base.DefaultDoodleStrategy
 * JD-Core Version:    0.7.0.1
 */