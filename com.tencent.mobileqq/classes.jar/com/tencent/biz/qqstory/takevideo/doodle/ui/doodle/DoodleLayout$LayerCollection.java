package com.tencent.biz.qqstory.takevideo.doodle.ui.doodle;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.takevideo.doodle.layer.EmptyLayer;
import com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer;
import com.tencent.biz.qqstory.takevideo.doodle.layer.LineLayer;
import com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer;
import java.util.ArrayList;

public class DoodleLayout$LayerCollection
{
  @NonNull
  public final EmptyLayer a;
  @NonNull
  public final FaceLayer a;
  @NonNull
  public final LineLayer a;
  @NonNull
  public final TextLayer a;
  public final ArrayList a;
  
  public DoodleLayout$LayerCollection(@NonNull TextLayer paramTextLayer, @NonNull LineLayer paramLineLayer, @NonNull FaceLayer paramFaceLayer, @NonNull EmptyLayer paramEmptyLayer)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextLayer = paramTextLayer;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerLineLayer = paramLineLayer;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerFaceLayer = paramFaceLayer;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerEmptyLayer = paramEmptyLayer;
    this.jdField_a_of_type_JavaUtilArrayList.add(paramFaceLayer);
    this.jdField_a_of_type_JavaUtilArrayList.add(paramLineLayer);
    this.jdField_a_of_type_JavaUtilArrayList.add(paramTextLayer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout.LayerCollection
 * JD-Core Version:    0.7.0.1
 */