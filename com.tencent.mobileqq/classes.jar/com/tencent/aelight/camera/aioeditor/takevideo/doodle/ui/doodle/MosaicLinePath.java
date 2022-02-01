package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle;

import android.graphics.Matrix;
import android.graphics.Path;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MosaicLinePath
  extends DoodleLinePath
{
  public Path b;
  public int c;
  public int d;
  List<Integer> e;
  List<Integer> f;
  ArrayList<PointAction> g;
  
  public MosaicLinePath(int paramInt1, int paramInt2)
  {
    super(paramInt1);
    this.d = paramInt2;
    this.b = new Path();
    this.e = new LinkedList();
    this.f = new LinkedList();
    this.g = new ArrayList();
  }
  
  public MosaicLinePath(DoodleLinePath paramDoodleLinePath, float paramFloat)
  {
    super(paramDoodleLinePath.a);
    if ((paramDoodleLinePath instanceof MosaicLinePath))
    {
      paramDoodleLinePath = (MosaicLinePath)paramDoodleLinePath;
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
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.MosaicLinePath
 * JD-Core Version:    0.7.0.1
 */