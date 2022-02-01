package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle;

import android.support.annotation.NonNull;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.DynamicFaceLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.EmptyLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.FaceLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.GuideLineLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.LineLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.ShapeLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.TextLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.base.BaseLayer;
import java.util.ArrayList;

public class DoodleLayout$LayerCollection
{
  @NonNull
  public final TextLayer a;
  @NonNull
  public final LineLayer b;
  @NonNull
  public final FaceLayer c;
  @NonNull
  public final DynamicFaceLayer d;
  @NonNull
  public final EmptyLayer e;
  @NonNull
  public final GuideLineLayer f;
  public final ShapeLayer g;
  public final ArrayList<BaseLayer> h = new ArrayList();
  
  public DoodleLayout$LayerCollection(@NonNull TextLayer paramTextLayer, @NonNull LineLayer paramLineLayer, @NonNull FaceLayer paramFaceLayer, @NonNull DynamicFaceLayer paramDynamicFaceLayer, @NonNull GuideLineLayer paramGuideLineLayer, @NonNull EmptyLayer paramEmptyLayer, ShapeLayer paramShapeLayer)
  {
    this.a = paramTextLayer;
    this.b = paramLineLayer;
    this.c = paramFaceLayer;
    this.d = paramDynamicFaceLayer;
    this.e = paramEmptyLayer;
    this.f = paramGuideLineLayer;
    this.g = paramShapeLayer;
    this.h.add(paramFaceLayer);
    this.h.add(paramDynamicFaceLayer);
    this.h.add(paramLineLayer);
    this.h.add(paramTextLayer);
    this.h.add(paramGuideLineLayer);
    this.h.add(paramShapeLayer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout.LayerCollection
 * JD-Core Version:    0.7.0.1
 */