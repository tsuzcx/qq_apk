import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.colornote.data.ColorNote;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aqep
{
  public static final int[] a = { 17039360, 17104896, 16908289, 16908292 };
  
  public static aqfb a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 16908292: 
      return new aqew();
    case 17104896: 
      return new aqex();
    case 17039360: 
      return new atnb();
    }
    return new aqey();
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
        if (aqda.a(localColorNote, (ColorNote)localIterator2.next())) {
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
    paramColorNote = aqda.c(paramColorNote);
    paramColorNote.setType(2);
    aqcc localaqcc = new aqcc();
    localaqcc.a(paramColorNote.getServiceType(), paramColorNote.getSubType(), 2);
    localaqcc.a(new aqeq(localaqcc, paramColorNote));
    a(paramColorNote.getServiceType());
  }
  
  private static void a(List<ColorNote> paramList)
  {
    if ((paramList != null) && (paramList.size() >= 20))
    {
      aqcc localaqcc = new aqcc();
      int i = 9;
      while (i < paramList.size())
      {
        ColorNote localColorNote = (ColorNote)paramList.get(i);
        localaqcc.a(localColorNote.getServiceType(), localColorNote.getSubType(), 2);
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
    aqcf.a(paramInt);
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
 * Qualified Name:     aqep
 * JD-Core Version:    0.7.0.1
 */