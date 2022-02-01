import android.graphics.Color;
import com.microrapid.opencv.ImageMainColorData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class bpkv
{
  public static int a(ImageMainColorData paramImageMainColorData)
  {
    return Color.argb(255, (int)paramImageMainColorData.r, (int)paramImageMainColorData.g, (int)paramImageMainColorData.b);
  }
  
  public static List<String> a(List<ImageMainColorData> paramList, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int i;
    if (paramList != null)
    {
      paramList = paramList.iterator();
      i = 0;
    }
    for (;;)
    {
      if (paramList.hasNext())
      {
        String str = String.format("#%06X", new Object[] { Integer.valueOf(a((ImageMainColorData)paramList.next()) & 0xFFFFFF) });
        if (!localArrayList.contains(str))
        {
          localArrayList.add(str);
          int j = i + 1;
          i = j;
          if (j < paramInt) {}
        }
      }
      else
      {
        return localArrayList;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpkv
 * JD-Core Version:    0.7.0.1
 */