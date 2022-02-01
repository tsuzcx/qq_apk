import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.colornote.data.ColorNote;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aqts
{
  public static final int[] a = { 17039360, 17104896, 16908292 };
  
  public static aque a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 16908292: 
      return new aqtz();
    case 17104896: 
      return new aqua();
    case 17039360: 
      return new auew();
    }
    return new aqub();
  }
  
  public static List<ColorNote> a(int paramInt)
  {
    List localList1 = b(paramInt);
    List localList2 = c(0);
    if (localList1 == null) {
      return null;
    }
    if ((localList2 == null) || (localList2.size() == 0)) {
      return localList1;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = localList1.iterator();
    while (localIterator1.hasNext())
    {
      ColorNote localColorNote = (ColorNote)localIterator1.next();
      Iterator localIterator2 = localList2.iterator();
      while (localIterator2.hasNext()) {
        if (aqsd.a(localColorNote, (ColorNote)localIterator2.next())) {
          localArrayList.add(localColorNote);
        }
      }
    }
    localList1.removeAll(localArrayList);
    return localList1;
  }
  
  public static List<ColorNote> a(List<ColorNote> paramList)
  {
    Object localObject = paramList;
    if (paramList != null)
    {
      localObject = paramList;
      if (paramList.size() > 3) {
        localObject = paramList.subList(0, 3);
      }
    }
    return localObject;
  }
  
  static List<ColorNote> a(List<ColorNote> paramList, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ColorNote localColorNote = (ColorNote)paramList.next();
      if (localColorNote.getServiceType() == paramInt) {
        localArrayList.add(0, localColorNote);
      }
    }
    return localArrayList;
  }
  
  public static void a(ColorNote paramColorNote)
  {
    if ((paramColorNote == null) || (TextUtils.isEmpty(paramColorNote.getMainTitle()))) {
      return;
    }
    paramColorNote = aqsd.c(paramColorNote);
    paramColorNote.setType(2);
    aqrf localaqrf = new aqrf();
    localaqrf.a(paramColorNote.getServiceType(), paramColorNote.getSubType(), 2);
    localaqrf.a(new aqtt(localaqrf, paramColorNote));
    a(paramColorNote.getServiceType());
  }
  
  private static void a(List<ColorNote> paramList)
  {
    if ((paramList != null) && (paramList.size() >= 20))
    {
      aqrf localaqrf = new aqrf();
      int i = 9;
      while (i < paramList.size())
      {
        ColorNote localColorNote = (ColorNote)paramList.get(i);
        localaqrf.a(localColorNote.getServiceType(), localColorNote.getSubType(), 2);
        i += 1;
      }
    }
  }
  
  public static boolean a(int paramInt)
  {
    if (BaseApplicationImpl.sProcessId == 1)
    {
      List localList = b(paramInt);
      if ((localList != null) && (localList.size() > 20)) {
        a(localList);
      }
      return true;
    }
    aqri.a(paramInt);
    return true;
  }
  
  public static List<ColorNote> b(int paramInt)
  {
    return a(c(2), paramInt);
  }
  
  public static List<ColorNote> c(int paramInt)
  {
    return ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a().a().a(false, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqts
 * JD-Core Version:    0.7.0.1
 */