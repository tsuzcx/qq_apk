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
  public final DynamicFaceLayer a;
  @NonNull
  public final EmptyLayer a;
  @NonNull
  public final FaceLayer a;
  @NonNull
  public final GuideLineLayer a;
  @NonNull
  public final LineLayer a;
  public final ShapeLayer a;
  @NonNull
  public final TextLayer a;
  public final ArrayList<BaseLayer> a;
  
  public DoodleLayout$LayerCollection(@NonNull TextLayer paramTextLayer, @NonNull LineLayer paramLineLayer, @NonNull FaceLayer paramFaceLayer, @NonNull DynamicFaceLayer paramDynamicFaceLayer, @NonNull GuideLineLayer paramGuideLineLayer, @NonNull EmptyLayer paramEmptyLayer, ShapeLayer paramShapeLayer)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextLayer = paramTextLayer;
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerLineLayer = paramLineLayer;
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerFaceLayer = paramFaceLayer;
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerDynamicFaceLayer = paramDynamicFaceLayer;
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerEmptyLayer = paramEmptyLayer;
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerGuideLineLayer = paramGuideLineLayer;
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerShapeLayer = paramShapeLayer;
    this.jdField_a_of_type_JavaUtilArrayList.add(paramFaceLayer);
    this.jdField_a_of_type_JavaUtilArrayList.add(paramDynamicFaceLayer);
    this.jdField_a_of_type_JavaUtilArrayList.add(paramLineLayer);
    this.jdField_a_of_type_JavaUtilArrayList.add(paramTextLayer);
    this.jdField_a_of_type_JavaUtilArrayList.add(paramGuideLineLayer);
    this.jdField_a_of_type_JavaUtilArrayList.add(paramShapeLayer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout.LayerCollection
 * JD-Core Version:    0.7.0.1
 */