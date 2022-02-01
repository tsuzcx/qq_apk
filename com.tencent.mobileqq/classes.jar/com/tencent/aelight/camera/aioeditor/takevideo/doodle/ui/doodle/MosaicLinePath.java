package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle;

import android.graphics.Matrix;
import android.graphics.Path;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MosaicLinePath
  extends DoodleLinePath
{
  public Path a;
  ArrayList<PointAction> jdField_a_of_type_JavaUtilArrayList;
  List<Integer> jdField_a_of_type_JavaUtilList;
  public int b;
  List<Integer> b;
  public int c;
  
  public MosaicLinePath(int paramInt1, int paramInt2)
  {
    super(paramInt1);
    this.c = paramInt2;
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    this.jdField_a_of_type_JavaUtilList = new LinkedList();
    this.jdField_b_of_type_JavaUtilList = new LinkedList();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public MosaicLinePath(DoodleLinePath paramDoodleLinePath, float paramFloat)
  {
    super(paramDoodleLinePath.jdField_a_of_type_Int);
    if ((paramDoodleLinePath instanceof MosaicLinePath))
    {
      paramDoodleLinePath = (MosaicLinePath)paramDoodleLinePath;
      Matrix localMatrix = new Matrix();
      localMatrix.postScale(paramFloat, paramFloat);
      this.jdField_a_of_type_AndroidGraphicsPath = new Path();
      this.jdField_a_of_type_AndroidGraphicsPath.addPath(paramDoodleLinePath.jdField_a_of_type_AndroidGraphicsPath, localMatrix);
      this.jdField_a_of_type_Int = paramDoodleLinePath.jdField_a_of_type_Int;
      this.jdField_b_of_type_Int = paramDoodleLinePath.jdField_b_of_type_Int;
      this.c = ((int)(paramDoodleLinePath.c * paramFloat));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.MosaicLinePath
 * JD-Core Version:    0.7.0.1
 */