package androidx.core.graphics;

import android.graphics.Path;
import androidx.annotation.Nullable;
import java.util.ArrayList;

public class PathParser
{
  private static final String LOGTAG = "PathParser";
  
  private static void addNode(ArrayList<PathParser.PathDataNode> paramArrayList, char paramChar, float[] paramArrayOfFloat)
  {
    paramArrayList.add(new PathParser.PathDataNode(paramChar, paramArrayOfFloat));
  }
  
  public static boolean canMorph(@Nullable PathParser.PathDataNode[] paramArrayOfPathDataNode1, @Nullable PathParser.PathDataNode[] paramArrayOfPathDataNode2)
  {
    if (paramArrayOfPathDataNode1 != null)
    {
      if (paramArrayOfPathDataNode2 == null) {
        return false;
      }
      if (paramArrayOfPathDataNode1.length != paramArrayOfPathDataNode2.length) {
        return false;
      }
      int i = 0;
      while (i < paramArrayOfPathDataNode1.length) {
        if (paramArrayOfPathDataNode1[i].mType == paramArrayOfPathDataNode2[i].mType)
        {
          if (paramArrayOfPathDataNode1[i].mParams.length != paramArrayOfPathDataNode2[i].mParams.length) {
            return false;
          }
          i += 1;
        }
        else
        {
          return false;
        }
      }
      return true;
    }
    return false;
  }
  
  static float[] copyOfRange(float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    if (paramInt1 <= paramInt2)
    {
      int i = paramArrayOfFloat.length;
      if ((paramInt1 >= 0) && (paramInt1 <= i))
      {
        paramInt2 -= paramInt1;
        i = Math.min(paramInt2, i - paramInt1);
        float[] arrayOfFloat = new float[paramInt2];
        System.arraycopy(paramArrayOfFloat, paramInt1, arrayOfFloat, 0, i);
        return arrayOfFloat;
      }
      throw new ArrayIndexOutOfBoundsException();
    }
    throw new IllegalArgumentException();
  }
  
  public static PathParser.PathDataNode[] createNodesFromPathData(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int j = 1;
    int i = 0;
    while (j < paramString.length())
    {
      j = nextStart(paramString, j);
      String str = paramString.substring(i, j).trim();
      if (str.length() > 0)
      {
        float[] arrayOfFloat = getFloats(str);
        addNode(localArrayList, str.charAt(0), arrayOfFloat);
      }
      i = j;
      j += 1;
    }
    if ((j - i == 1) && (i < paramString.length())) {
      addNode(localArrayList, paramString.charAt(i), new float[0]);
    }
    return (PathParser.PathDataNode[])localArrayList.toArray(new PathParser.PathDataNode[localArrayList.size()]);
  }
  
  public static Path createPathFromPathData(String paramString)
  {
    Path localPath = new Path();
    Object localObject = createNodesFromPathData(paramString);
    if (localObject != null) {
      try
      {
        PathParser.PathDataNode.nodesToPath((PathParser.PathDataNode[])localObject, localPath);
        return localPath;
      }
      catch (RuntimeException localRuntimeException)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Error in parsing ");
        ((StringBuilder)localObject).append(paramString);
        throw new RuntimeException(((StringBuilder)localObject).toString(), localRuntimeException);
      }
    }
    return null;
  }
  
  public static PathParser.PathDataNode[] deepCopyNodes(PathParser.PathDataNode[] paramArrayOfPathDataNode)
  {
    if (paramArrayOfPathDataNode == null) {
      return null;
    }
    PathParser.PathDataNode[] arrayOfPathDataNode = new PathParser.PathDataNode[paramArrayOfPathDataNode.length];
    int i = 0;
    while (i < paramArrayOfPathDataNode.length)
    {
      arrayOfPathDataNode[i] = new PathParser.PathDataNode(paramArrayOfPathDataNode[i]);
      i += 1;
    }
    return arrayOfPathDataNode;
  }
  
  private static void extract(String paramString, int paramInt, PathParser.ExtractFloatResult paramExtractFloatResult)
  {
    paramExtractFloatResult.mEndWithNegOrDot = false;
    int j = paramInt;
    int i = 0;
    int m = 0;
    int k = 0;
    while (j < paramString.length())
    {
      int n = paramString.charAt(j);
      if (n != 32)
      {
        if ((n != 69) && (n != 101)) {}
        switch (n)
        {
        default: 
          break;
        case 46: 
          if (m == 0)
          {
            i = 0;
            m = 1;
            break label141;
          }
          paramExtractFloatResult.mEndWithNegOrDot = true;
          break;
        case 45: 
          if ((j != paramInt) && (i == 0))
          {
            paramExtractFloatResult.mEndWithNegOrDot = true;
          }
          else
          {
            i = 0;
            break label141;
            i = 1;
          }
          break;
        }
      }
      i = 0;
      k = 1;
      label141:
      if (k != 0) {
        break;
      }
      j += 1;
    }
    paramExtractFloatResult.mEndPosition = j;
  }
  
  private static float[] getFloats(String paramString)
  {
    if ((paramString.charAt(0) != 'z') && (paramString.charAt(0) != 'Z')) {}
    for (;;)
    {
      int m;
      int j;
      try
      {
        float[] arrayOfFloat = new float[paramString.length()];
        localObject = new PathParser.ExtractFloatResult();
        int n = paramString.length();
        i = 1;
        k = 0;
        if (i < n)
        {
          extract(paramString, i, (PathParser.ExtractFloatResult)localObject);
          m = ((PathParser.ExtractFloatResult)localObject).mEndPosition;
          j = k;
          if (i < m)
          {
            arrayOfFloat[k] = Float.parseFloat(paramString.substring(i, m));
            j = k + 1;
          }
          if (!((PathParser.ExtractFloatResult)localObject).mEndWithNegOrDot) {
            break label177;
          }
          i = m;
          k = j;
          continue;
        }
        arrayOfFloat = copyOfRange(arrayOfFloat, 0, k);
        return arrayOfFloat;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("error in parsing \"");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("\"");
        throw new RuntimeException(((StringBuilder)localObject).toString(), localNumberFormatException);
      }
      return new float[0];
      label177:
      int i = m + 1;
      int k = j;
    }
  }
  
  public static boolean interpolatePathDataNodes(PathParser.PathDataNode[] paramArrayOfPathDataNode1, PathParser.PathDataNode[] paramArrayOfPathDataNode2, PathParser.PathDataNode[] paramArrayOfPathDataNode3, float paramFloat)
  {
    if ((paramArrayOfPathDataNode1 != null) && (paramArrayOfPathDataNode2 != null) && (paramArrayOfPathDataNode3 != null))
    {
      if ((paramArrayOfPathDataNode1.length == paramArrayOfPathDataNode2.length) && (paramArrayOfPathDataNode2.length == paramArrayOfPathDataNode3.length))
      {
        boolean bool = canMorph(paramArrayOfPathDataNode2, paramArrayOfPathDataNode3);
        int i = 0;
        if (!bool) {
          return false;
        }
        while (i < paramArrayOfPathDataNode1.length)
        {
          paramArrayOfPathDataNode1[i].interpolatePathDataNode(paramArrayOfPathDataNode2[i], paramArrayOfPathDataNode3[i], paramFloat);
          i += 1;
        }
        return true;
      }
      throw new IllegalArgumentException("The nodes to be interpolated and resulting nodes must have the same length");
    }
    paramArrayOfPathDataNode1 = new IllegalArgumentException("The nodes to be interpolated and resulting nodes cannot be null");
    for (;;)
    {
      throw paramArrayOfPathDataNode1;
    }
  }
  
  private static int nextStart(String paramString, int paramInt)
  {
    while (paramInt < paramString.length())
    {
      int i = paramString.charAt(paramInt);
      if ((((i - 65) * (i - 90) <= 0) || ((i - 97) * (i - 122) <= 0)) && (i != 101) && (i != 69)) {
        return paramInt;
      }
      paramInt += 1;
    }
    return paramInt;
  }
  
  public static void updateNodes(PathParser.PathDataNode[] paramArrayOfPathDataNode1, PathParser.PathDataNode[] paramArrayOfPathDataNode2)
  {
    int i = 0;
    while (i < paramArrayOfPathDataNode2.length)
    {
      paramArrayOfPathDataNode1[i].mType = paramArrayOfPathDataNode2[i].mType;
      int j = 0;
      while (j < paramArrayOfPathDataNode2[i].mParams.length)
      {
        paramArrayOfPathDataNode1[i].mParams[j] = paramArrayOfPathDataNode2[i].mParams[j];
        j += 1;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.graphics.PathParser
 * JD-Core Version:    0.7.0.1
 */