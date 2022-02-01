package com.tencent.biz.qqstory.takevideo.doodle.ui.doodle;

import android.graphics.Matrix;
import android.graphics.Path;

public class PureLinePath
  extends DoodleLinePath
{
  public Path a;
  public int b;
  public int c;
  
  public PureLinePath(Path paramPath, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1);
    this.jdField_a_of_type_AndroidGraphicsPath = paramPath;
    this.b = paramInt2;
    this.c = paramInt3;
  }
  
  public PureLinePath(DoodleLinePath paramDoodleLinePath, float paramFloat)
  {
    super(paramDoodleLinePath.jdField_a_of_type_Int);
    if ((paramDoodleLinePath instanceof PureLinePath))
    {
      paramDoodleLinePath = (PureLinePath)paramDoodleLinePath;
      Matrix localMatrix = new Matrix();
      localMatrix.postScale(paramFloat, paramFloat);
      this.jdField_a_of_type_AndroidGraphicsPath = new Path();
      this.jdField_a_of_type_AndroidGraphicsPath.addPath(paramDoodleLinePath.jdField_a_of_type_AndroidGraphicsPath, localMatrix);
      this.jdField_a_of_type_Int = paramDoodleLinePath.jdField_a_of_type_Int;
      this.b = paramDoodleLinePath.b;
      this.c = ((int)(paramDoodleLinePath.c * paramFloat));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.PureLinePath
 * JD-Core Version:    0.7.0.1
 */