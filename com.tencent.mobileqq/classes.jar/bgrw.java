import android.content.Context;
import android.content.res.Resources;
import com.tencent.component.media.image.ImageManager;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.SendByFile.1;
import com.tencent.util.Pair;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class bgrw
{
  private long jdField_a_of_type_Long = a();
  private boolean jdField_a_of_type_Boolean = true;
  private long b = 1048576000L;
  private long c = 104345600L;
  
  public static void a(QQAppInterface paramQQAppInterface, List<String> paramList, String paramString, int paramInt)
  {
    if ((paramQQAppInterface == null) || (paramList == null)) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        if (paramInt == 1) {
          paramQQAppInterface.a().a(str, paramString);
        } else {
          paramQQAppInterface.a().a(str, paramString, paramString, paramInt, true);
        }
      }
    }
  }
  
  protected int a()
  {
    return (int)beao.a();
  }
  
  public bgrw a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
    return this;
  }
  
  public bgrw a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public Pair<ArrayList<String>, ArrayList<String>> a(List<String> paramList, boolean paramBoolean, Map<String, LocalMediaInfo> paramMap1, Map<String, LocalMediaInfo> paramMap2)
  {
    Pair localPair = new Pair(new ArrayList(), new ArrayList());
    if (paramList == null) {
      return localPair;
    }
    ((ArrayList)localPair.first).clear();
    ((ArrayList)localPair.second).clear();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (ImageManager.isNetworkUrl(str))
      {
        ((ArrayList)localPair.first).add(str);
      }
      else
      {
        paramList = null;
        if (paramMap1 != null) {
          paramList = (LocalMediaInfo)paramMap1.get(str);
        }
        Object localObject = paramList;
        if (paramList == null)
        {
          localObject = paramList;
          if (paramMap2 != null) {
            localObject = (LocalMediaInfo)paramMap2.get(str);
          }
        }
        if (localObject == null)
        {
          ((ArrayList)localPair.first).add(str);
        }
        else
        {
          int i = bgkc.getMediaType((LocalMediaInfo)localObject);
          long l2 = ((LocalMediaInfo)localObject).fileSize;
          long l1 = l2;
          if (l2 <= 0L)
          {
            paramList = new File(str);
            l1 = l2;
            if (paramList.exists()) {
              l1 = paramList.length();
            }
          }
          if (i == 1)
          {
            if ((l1 > this.b) || ((l1 > this.c) && (paramBoolean)))
            {
              if (this.jdField_a_of_type_Boolean)
              {
                ((ArrayList)localPair.second).add(str);
                bgkc.c();
              }
            }
            else {
              ((ArrayList)localPair.first).add(str);
            }
          }
          else if ((l1 > this.jdField_a_of_type_Long) && (paramBoolean))
          {
            if (this.jdField_a_of_type_Boolean) {
              ((ArrayList)localPair.second).add(str);
            }
          }
          else {
            ((ArrayList)localPair.first).add(str);
          }
        }
      }
    }
    return localPair;
  }
  
  public boolean a(Context paramContext, String paramString, boolean paramBoolean1, Map<String, LocalMediaInfo> paramMap1, Map<String, LocalMediaInfo> paramMap2, boolean paramBoolean2)
  {
    if (ImageManager.isNetworkUrl(paramString))
    {
      paramBoolean2 = false;
      return paramBoolean2;
    }
    LocalMediaInfo localLocalMediaInfo = null;
    if (paramMap1 != null) {
      localLocalMediaInfo = (LocalMediaInfo)paramMap1.get(paramString);
    }
    paramMap1 = localLocalMediaInfo;
    if (localLocalMediaInfo == null)
    {
      paramMap1 = localLocalMediaInfo;
      if (paramMap2 != null) {
        paramMap1 = (LocalMediaInfo)paramMap2.get(paramString);
      }
    }
    if (paramMap1 == null) {
      return false;
    }
    int i = bgkc.getMediaType(paramMap1);
    long l2 = paramMap1.fileSize;
    long l1 = l2;
    if (l2 <= 0L)
    {
      paramString = new File(paramString);
      l1 = l2;
      if (paramString.exists()) {
        l1 = paramString.length();
      }
    }
    paramString = "";
    double d1;
    if (i == 1)
    {
      if ((l1 <= this.b) && ((l1 <= this.c) || (!paramBoolean1))) {
        break label574;
      }
      if (this.jdField_a_of_type_Boolean)
      {
        if (!paramBoolean2) {
          break label582;
        }
        paramString = "M";
        paramMap1 = new DecimalFormat("#.##");
        if (l1 > this.b)
        {
          double d2 = (float)this.b * 1.0F / 1024.0F / 1024.0F + 1.0F;
          d1 = d2;
          if (d2 > 1000.0D)
          {
            paramString = "G";
            d1 = d2 / 1024.0D;
          }
          label234:
          paramString = String.format(paramContext.getResources().getString(2131689959), new Object[] { "" + paramMap1.format(d1), paramString });
        }
      }
    }
    for (;;)
    {
      label283:
      paramBoolean1 = true;
      for (;;)
      {
        paramMap1 = paramString;
        if (paramBoolean1)
        {
          paramMap1 = paramString;
          if (!paramBoolean2) {
            if (!this.jdField_a_of_type_Boolean) {
              break label560;
            }
          }
        }
        label560:
        for (paramMap1 = paramContext.getResources().getString(2131689831);; paramMap1 = paramContext.getResources().getString(2131689832))
        {
          paramBoolean2 = paramBoolean1;
          if (!paramBoolean1) {
            break;
          }
          bkgk.a(new SendByFile.1(this, paramContext, paramMap1));
          return paramBoolean1;
          d1 = this.c / 1024L / 1024L + 1L;
          break label234;
          if (!paramBoolean2) {
            break label582;
          }
          paramString = String.format(paramContext.getResources().getString(2131689960), new Object[] { "" + (this.c / 1024L / 1024L + 1L) });
          break label283;
          if ((l1 <= this.jdField_a_of_type_Long) || (!paramBoolean1)) {
            break label574;
          }
          if (this.jdField_a_of_type_Boolean) {
            if (paramBoolean2) {
              paramString = String.format(paramContext.getResources().getString(2131689911), new Object[] { "" + this.jdField_a_of_type_Long / 1024L / 1024L });
            }
          }
          for (;;)
          {
            paramBoolean1 = true;
            break;
            if (paramBoolean2) {
              paramString = String.format(paramContext.getResources().getString(2131689912), new Object[] { "" + this.jdField_a_of_type_Long / 1024L / 1024L });
            }
          }
        }
        label574:
        paramString = "";
        paramBoolean1 = false;
      }
      label582:
      paramString = "";
    }
  }
  
  public boolean a(Context paramContext, List<String> paramList, boolean paramBoolean, Map<String, LocalMediaInfo> paramMap1, Map<String, LocalMediaInfo> paramMap2)
  {
    if (paramList == null) {}
    do
    {
      while (!paramList.hasNext())
      {
        return false;
        paramList = paramList.iterator();
      }
    } while (!a(paramContext, (String)paramList.next(), paramBoolean, paramMap1, paramMap2, false));
    return true;
  }
  
  public bgrw b(long paramLong)
  {
    this.b = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgrw
 * JD-Core Version:    0.7.0.1
 */