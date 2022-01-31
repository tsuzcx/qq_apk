import android.content.ContentValues;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class amhf
  extends aksv
{
  public static int a;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  List<ColorNote> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  static
  {
    jdField_a_of_type_Int = 9;
  }
  
  public amhf(QQAppInterface paramQQAppInterface, ProxyManager paramProxyManager)
  {
    super(paramQQAppInterface, paramProxyManager);
  }
  
  private List<ColorNote> a(List<ColorNote> paramList, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ColorNote localColorNote = (ColorNote)paramList.next();
        if (localColorNote.mExtra == paramInt) {
          localArrayList.add(localColorNote);
        }
      }
    }
    return localArrayList;
  }
  
  private boolean a(ColorNote paramColorNote)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!this.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      bool1 = bool2;
      if (a(paramColorNote.getUniKey(), paramColorNote.mExtra) != null) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final int a()
  {
    try
    {
      int i = a(false).size();
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final ColorNote a(String paramString)
  {
    try
    {
      paramString = a(paramString, 0);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final ColorNote a(String paramString, int paramInt)
  {
    if (paramInt == 0) {}
    for (;;)
    {
      try
      {
        localObject = a(false);
        Iterator localIterator = ((List)localObject).iterator();
        if (!localIterator.hasNext()) {
          break label81;
        }
        localObject = (ColorNote)localIterator.next();
        boolean bool = ((ColorNote)localObject).getUniKey().equals(paramString);
        if (!bool) {
          continue;
        }
        paramString = (String)localObject;
        return paramString;
      }
      finally {}
      Object localObject = a(false, paramInt);
      continue;
      label81:
      paramString = null;
    }
  }
  
  public ColorNote a(String paramString1, String paramString2, String paramString3, Object paramObject)
  {
    ColorNote localColorNote = a(paramString2);
    for (;;)
    {
      try
      {
        localObject = ColorNote.class.getDeclaredField(paramString3);
        localClass = ((Field)localObject).getType();
        ((Field)localObject).setAccessible(true);
        if (localColorNote != null) {
          ((Field)localObject).set(localColorNote, paramObject);
        }
        if ((Modifier.isStatic(((Field)localObject).getModifiers())) || (((Field)localObject).isAnnotationPresent(aulx.class))) {
          break label381;
        }
        localObject = new ContentValues();
        if (localClass != Long.TYPE) {
          continue;
        }
        ((ContentValues)localObject).put(paramString3, (Long)paramObject);
      }
      catch (NoSuchFieldException paramString1)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("ColorNoteProxy", 2, "updateColorNoteFieldByKey error NoSuchFieldException! ", paramString1);
        return null;
        if (localClass != String.class) {
          continue;
        }
        ((ContentValues)localObject).put(paramString3, (String)paramObject);
        continue;
      }
      catch (IllegalAccessException paramString1)
      {
        Object localObject;
        Class localClass;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("ColorNoteProxy", 2, "updateColorNoteFieldByKey error IllegalAccessException! ", paramString1);
        continue;
        if (localClass != Byte.TYPE) {
          continue;
        }
        ((ContentValues)localObject).put(paramString3, (Byte)paramObject);
        continue;
        if (localClass != [B.class) {
          continue;
        }
        ((ContentValues)localObject).put(paramString3, (byte[])paramObject);
        continue;
        if (localClass != Short.TYPE) {
          continue;
        }
        ((ContentValues)localObject).put(paramString3, (Short)paramObject);
        continue;
        if (localClass != Boolean.TYPE) {
          continue;
        }
        ((ContentValues)localObject).put(paramString3, (Boolean)paramObject);
        continue;
        if (localClass != Float.TYPE) {
          continue;
        }
        ((ContentValues)localObject).put(paramString3, (Float)paramObject);
        continue;
        if (localClass != Double.TYPE) {
          continue;
        }
        ((ContentValues)localObject).put(paramString3, (Double)paramObject);
        continue;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("ColorNoteProxy", 2, "updateMsgFieldByUniseq fieldType error! " + localClass.getClass().getSimpleName());
        continue;
      }
      if (localColorNote == null) {
        continue;
      }
      a(paramString1, 0, localColorNote.getTableName(), (ContentValues)localObject, "mUniKey=?", new String[] { paramString2 }, null);
      return localColorNote;
      if (localClass != Integer.TYPE) {
        continue;
      }
      ((ContentValues)localObject).put(paramString3, (Integer)paramObject);
    }
    label381:
    return null;
  }
  
  public ArrayList<ColorNote> a(String paramString, akte paramakte)
  {
    return a(paramString, paramakte, 0);
  }
  
  public ArrayList<ColorNote> a(String paramString, akte paramakte, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        ColorNote localColorNote = (ColorNote)localIterator.next();
        if (localColorNote.mExtra == paramInt) {
          localArrayList.add(localColorNote);
        }
      }
    }
    this.jdField_a_of_type_JavaUtilList.removeAll(localArrayList);
    ??? = localArrayList.iterator();
    while (((Iterator)???).hasNext()) {
      c(paramString, (ColorNote)((Iterator)???).next(), paramakte);
    }
    return localArrayList;
  }
  
  public final List<ColorNote> a()
  {
    for (;;)
    {
      int i;
      ColorNote localColorNote;
      boolean bool;
      try
      {
        ArrayList localArrayList = new ArrayList();
        if (this.jdField_a_of_type_JavaUtilList.isEmpty()) {
          break label160;
        }
        i = this.jdField_a_of_type_JavaUtilList.size() - 1;
        if (i < 0) {
          break label160;
        }
        localColorNote = (ColorNote)this.jdField_a_of_type_JavaUtilList.get(i);
        if (localColorNote.isOpen()) {
          break label171;
        }
        bool = amhi.b(localColorNote);
        if (localColorNote.getServiceType() == 16973824) {
          if ((localArrayList.size() > 0) && (amhi.b((ColorNote)localArrayList.get(0)))) {
            localArrayList.add(1, localColorNote);
          } else {
            localArrayList.add(0, localColorNote);
          }
        }
      }
      finally {}
      if (bool)
      {
        localList1.add(0, localColorNote);
      }
      else
      {
        localList1.add(localColorNote);
        break label171;
        label160:
        List localList2 = a(localList1, 0);
        return localList2;
      }
      label171:
      i -= 1;
    }
  }
  
  public final List<ColorNote> a(boolean paramBoolean)
  {
    try
    {
      List localList = a(paramBoolean, 0);
      return localList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final List<ColorNote> a(boolean paramBoolean, int paramInt)
  {
    try
    {
      if ((this.jdField_a_of_type_JavaUtilList.isEmpty()) && (paramBoolean))
      {
        localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager().a(ColorNote.class);
        if ((localList != null) && (!localList.isEmpty())) {
          this.jdField_a_of_type_JavaUtilList = localList;
        }
      }
      List localList = a(this.jdField_a_of_type_JavaUtilList, paramInt);
      return localList;
    }
    finally {}
  }
  
  protected void a()
  {
    if (QLog.isColorLevel()) {
      QLog.e("ColorNoteProxy", 2, "init ~~ ");
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager().a(ColorNote.class, true, null, null, null, null, null, null);
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      this.jdField_a_of_type_JavaUtilList = ((List)localObject);
      amkg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), false, false);
    }
    localObject = amgm.a();
    if ((localObject != null) && (((amgl)localObject).a() != -1))
    {
      jdField_a_of_type_Int = ((amgl)localObject).a();
      if (QLog.isColorLevel()) {
        QLog.e("ColorNoteConfigProcessor", 2, "init MAX_COUNT " + jdField_a_of_type_Int);
      }
    }
  }
  
  protected void a(String paramString1, int paramInt, String paramString2, ContentValues paramContentValues, String paramString3, String[] paramArrayOfString, akte paramakte)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(paramString1, paramInt, paramString2, paramContentValues, paramString3, paramArrayOfString, 1, paramakte);
  }
  
  protected void a(String paramString1, int paramInt, String paramString2, String paramString3, String[] paramArrayOfString, akte paramakte)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(paramString1, paramInt, paramString2, paramString3, paramArrayOfString, 2, paramakte);
  }
  
  protected void a(String paramString, ColorNote paramColorNote, akte paramakte)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(paramString, 0, paramColorNote.getTableName(), paramColorNote, 0, paramakte);
  }
  
  public void a(String paramString, ColorNote paramColorNote, akte paramakte, boolean paramBoolean)
  {
    if ((!a(paramColorNote)) && (amkg.a())) {
      if (paramColorNote.getServiceType() == 16973824) {
        axqw.b(null, "dc00898", "", "", "0X800A746", "0X800A746", 0, 0, "", "", "", "");
      }
    }
    while (!QLog.isColorLevel()) {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (amhi.b(paramColorNote))
        {
          this.jdField_a_of_type_JavaUtilList.add(0, paramColorNote);
          if (paramColorNote.getServiceType() != 16973824) {
            b(paramString, paramColorNote, paramakte, paramBoolean);
          }
          return;
        }
        this.jdField_a_of_type_JavaUtilList.add(paramColorNote);
      }
    }
    QLog.e("ColorNoteProxy", 2, "addColorNote error! isAfterSyncMsg = " + amkg.a());
  }
  
  public boolean a()
  {
    Object localObject2 = a(false);
    int j;
    label106:
    for (int i = ((List)localObject2).size();; i = j)
    {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        localObject2 = ((List)localObject2).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          ColorNote localColorNote = (ColorNote)((Iterator)localObject2).next();
          j = i;
          if (amhi.b(localColorNote)) {
            j = i - 1;
          }
          if (localColorNote.getServiceType() != 16973824) {
            continue;
          }
          i = j - 1;
          break label106;
        }
        if (i < jdField_a_of_type_Int) {
          return true;
        }
      }
      return false;
    }
  }
  
  public boolean a(String paramString, ColorNote paramColorNote)
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    ArrayList localArrayList = new ArrayList();
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        ColorNote localColorNote = (ColorNote)localIterator.next();
        if (amhi.b(localColorNote)) {
          localArrayList.add(localColorNote);
        }
      }
    }
    localList.removeAll(localArrayList);
    ??? = localArrayList.iterator();
    while (((Iterator)???).hasNext()) {
      c(paramString, (ColorNote)((Iterator)???).next(), null);
    }
    if (paramColorNote != null) {
      a(paramString, paramColorNote, null, false);
    }
    return true;
  }
  
  protected void b() {}
  
  protected void b(String paramString, ColorNote paramColorNote, akte paramakte)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.c(paramString, 0, paramColorNote.getTableName(), paramColorNote, 0, paramakte);
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.d();
  }
  
  protected void b(String paramString, ColorNote paramColorNote, akte paramakte, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      b(paramString, paramColorNote, paramakte);
      return;
    }
    a(paramString, paramColorNote, paramakte);
  }
  
  public void c(String paramString, ColorNote paramColorNote, akte paramakte)
  {
    if (paramColorNote != null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramColorNote);
      a(paramString, 0, paramColorNote.getTableName(), "mUniKey=?", new String[] { String.valueOf(paramColorNote.getUniKey()) }, paramakte);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amhf
 * JD-Core Version:    0.7.0.1
 */