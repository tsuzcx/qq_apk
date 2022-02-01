package androidx.vectordrawable.graphics.drawable;

import android.animation.TypeEvaluator;
import androidx.core.graphics.PathParser;
import androidx.core.graphics.PathParser.PathDataNode;

class AnimatorInflaterCompat$PathDataEvaluator
  implements TypeEvaluator<PathParser.PathDataNode[]>
{
  private PathParser.PathDataNode[] mNodeArray;
  
  AnimatorInflaterCompat$PathDataEvaluator() {}
  
  AnimatorInflaterCompat$PathDataEvaluator(PathParser.PathDataNode[] paramArrayOfPathDataNode)
  {
    this.mNodeArray = paramArrayOfPathDataNode;
  }
  
  public PathParser.PathDataNode[] evaluate(float paramFloat, PathParser.PathDataNode[] paramArrayOfPathDataNode1, PathParser.PathDataNode[] paramArrayOfPathDataNode2)
  {
    if (PathParser.canMorph(paramArrayOfPathDataNode1, paramArrayOfPathDataNode2))
    {
      if (!PathParser.canMorph(this.mNodeArray, paramArrayOfPathDataNode1)) {
        this.mNodeArray = PathParser.deepCopyNodes(paramArrayOfPathDataNode1);
      }
      int i = 0;
      while (i < paramArrayOfPathDataNode1.length)
      {
        this.mNodeArray[i].interpolatePathDataNode(paramArrayOfPathDataNode1[i], paramArrayOfPathDataNode2[i], paramFloat);
        i += 1;
      }
      return this.mNodeArray;
    }
    paramArrayOfPathDataNode1 = new IllegalArgumentException("Can't interpolate between two incompatible pathData");
    for (;;)
    {
      throw paramArrayOfPathDataNode1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.vectordrawable.graphics.drawable.AnimatorInflaterCompat.PathDataEvaluator
 * JD-Core Version:    0.7.0.1
 */