package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle;

import android.graphics.Matrix;
import android.graphics.Path;
import java.util.ArrayList;

public class PureLinePath
  extends DoodleLinePath
{
  public Path b;
  public int c;
  public int d;
  ArrayList<PointAction> e;
  
  public PureLinePath(Path paramPath, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1);
    this.b = paramPath;
    this.c = paramInt2;
    this.d = paramInt3;
    this.e = new ArrayList();
  }
  
  public PureLinePath(DoodleLinePath paramDoodleLinePath, float paramFloat)
  {
    super(paramDoodleLinePath.a);
    if ((paramDoodleLinePath instanceof PureLinePath))
    {
      paramDoodleLinePath = (PureLinePath)paramDoodleLinePath;
      Matrix localMatrix = new Matrix();
      localMatrix.postScale(paramFloat, paramFloat);
      this.b = new Path();
      this.b.addPath(paramDoodleLinePath.b, localMatrix);
      this.a = paramDoodleLinePath.a;
      this.c = paramDoodleLinePath.c;
      this.d = ((int)(paramDoodleLinePath.d * paramFloat));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.PureLinePath
 * JD-Core Version:    0.7.0.1
 */