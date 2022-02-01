package androidx.vectordrawable.graphics.drawable;

import android.content.res.Resources.Theme;
import android.graphics.Path;
import android.util.Log;
import androidx.core.graphics.PathParser;
import androidx.core.graphics.PathParser.PathDataNode;

abstract class VectorDrawableCompat$VPath
  extends VectorDrawableCompat.VObject
{
  protected static final int FILL_TYPE_WINDING = 0;
  int mChangingConfigurations;
  int mFillRule = 0;
  protected PathParser.PathDataNode[] mNodes = null;
  String mPathName;
  
  public VectorDrawableCompat$VPath()
  {
    super(null);
  }
  
  public VectorDrawableCompat$VPath(VPath paramVPath)
  {
    super(null);
    this.mPathName = paramVPath.mPathName;
    this.mChangingConfigurations = paramVPath.mChangingConfigurations;
    this.mNodes = PathParser.deepCopyNodes(paramVPath.mNodes);
  }
  
  public void applyTheme(Resources.Theme paramTheme) {}
  
  public boolean canApplyTheme()
  {
    return false;
  }
  
  public PathParser.PathDataNode[] getPathData()
  {
    return this.mNodes;
  }
  
  public String getPathName()
  {
    return this.mPathName;
  }
  
  public boolean isClipPath()
  {
    return false;
  }
  
  public String nodesToString(PathParser.PathDataNode[] paramArrayOfPathDataNode)
  {
    String str = " ";
    int i = 0;
    while (i < paramArrayOfPathDataNode.length)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(paramArrayOfPathDataNode[i].mType);
      ((StringBuilder)localObject).append(":");
      str = ((StringBuilder)localObject).toString();
      localObject = paramArrayOfPathDataNode[i].mParams;
      int j = 0;
      while (j < localObject.length)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append(localObject[j]);
        localStringBuilder.append(",");
        str = localStringBuilder.toString();
        j += 1;
      }
      i += 1;
    }
    return str;
  }
  
  public void printVPath(int paramInt)
  {
    String str = "";
    int i = 0;
    while (i < paramInt)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("    ");
      str = localStringBuilder.toString();
      i += 1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("current path is :");
    localStringBuilder.append(this.mPathName);
    localStringBuilder.append(" pathData is ");
    localStringBuilder.append(nodesToString(this.mNodes));
    Log.v("VectorDrawableCompat", localStringBuilder.toString());
  }
  
  public void setPathData(PathParser.PathDataNode[] paramArrayOfPathDataNode)
  {
    if (!PathParser.canMorph(this.mNodes, paramArrayOfPathDataNode))
    {
      this.mNodes = PathParser.deepCopyNodes(paramArrayOfPathDataNode);
      return;
    }
    PathParser.updateNodes(this.mNodes, paramArrayOfPathDataNode);
  }
  
  public void toPath(Path paramPath)
  {
    paramPath.reset();
    PathParser.PathDataNode[] arrayOfPathDataNode = this.mNodes;
    if (arrayOfPathDataNode != null) {
      PathParser.PathDataNode.nodesToPath(arrayOfPathDataNode, paramPath);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VPath
 * JD-Core Version:    0.7.0.1
 */