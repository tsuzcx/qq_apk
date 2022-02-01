package androidx.core.graphics;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class PathUtils
{
  @NonNull
  @RequiresApi(26)
  public static Collection<PathSegment> flatten(@NonNull Path paramPath)
  {
    return flatten(paramPath, 0.5F);
  }
  
  @NonNull
  @RequiresApi(26)
  public static Collection<PathSegment> flatten(@NonNull Path paramPath, @FloatRange(from=0.0D) float paramFloat)
  {
    paramPath = paramPath.approximate(paramFloat);
    int j = paramPath.length / 3;
    ArrayList localArrayList = new ArrayList(j);
    int i = 1;
    while (i < j)
    {
      int k = i * 3;
      int m = (i - 1) * 3;
      paramFloat = paramPath[k];
      float f1 = paramPath[(k + 1)];
      float f2 = paramPath[(k + 2)];
      float f3 = paramPath[m];
      float f4 = paramPath[(m + 1)];
      float f5 = paramPath[(m + 2)];
      if ((paramFloat != f3) && ((f1 != f4) || (f2 != f5))) {
        localArrayList.add(new PathSegment(new PointF(f4, f5), f3, new PointF(f1, f2), paramFloat));
      }
      i += 1;
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     androidx.core.graphics.PathUtils
 * JD-Core Version:    0.7.0.1
 */