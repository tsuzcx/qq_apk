import android.content.ContentValues;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNoteProxy.1;
import com.tencent.mobileqq.colornote.data.ColorNoteProxy.2;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class anyf
  extends amiz
{
  public static int a;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private awbw jdField_a_of_type_Awbw;
  protected List<ColorNote> a;
  
  static
  {
    jdField_a_of_type_Int = 9;
  }
  
  public anyf(QQAppInterface paramQQAppInterface, ProxyManager paramProxyManager)
  {
    super(paramQQAppInterface, paramProxyManager);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
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
  
  public ColorNote a(String paramString)
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
  
  public ColorNote a(String paramString, int paramInt)
  {
    if (paramInt == 0) {}
    for (;;)
    {
      try
      {
        localObject = a(false);
        if (localObject == null) {
          break label86;
        }
        Iterator localIterator = ((List)localObject).iterator();
        if (!localIterator.hasNext()) {
          break label86;
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
      label86:
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
        if ((Modifier.isStatic(((Field)localObject).getModifiers())) || (((Field)localObject).isAnnotationPresent(awdg.class))) {
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
  
  public ArrayList<ColorNote> a(String paramString, amji paramamji)
  {
    return a(paramString, paramamji, 0);
  }
  
  public ArrayList<ColorNote> a(String arg1, amji paramamji, int paramInt)
  {
    paramamji = new ArrayList();
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        ColorNote localColorNote = (ColorNote)localIterator.next();
        if (localColorNote.mExtra == paramInt) {
          paramamji.add(localColorNote);
        }
      }
    }
    this.jdField_a_of_type_JavaUtilList.removeAll(paramamji);
    a(paramamji);
    return paramamji;
  }
  
  public List<ColorNote> a()
  {
    try
    {
      List localList = a(this.jdField_a_of_type_JavaUtilList);
      return localList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public List<ColorNote> a(List<ColorNote> paramList)
  {
    for (;;)
    {
      ArrayList localArrayList;
      int i;
      ColorNote localColorNote;
      boolean bool;
      try
      {
        localArrayList = new ArrayList();
        if (paramList.isEmpty()) {
          break label158;
        }
        i = paramList.size() - 1;
        if (i < 0) {
          break label158;
        }
        localColorNote = (ColorNote)paramList.get(i);
        if (localColorNote.isOpen()) {
          break label170;
        }
        bool = anyi.b(localColorNote);
        if (localColorNote.getServiceType() == 16973824) {
          if ((localArrayList.size() > 0) && (anyi.b((ColorNote)localArrayList.get(0)))) {
            localArrayList.add(1, localColorNote);
          } else {
            localArrayList.add(0, localColorNote);
          }
        }
      }
      finally {}
      if (bool)
      {
        localArrayList.add(0, localColorNote);
      }
      else
      {
        localArrayList.add(localColorNote);
        break label170;
        label158:
        paramList = a(localArrayList, 0);
        return paramList;
      }
      label170:
      i -= 1;
    }
  }
  
  List<ColorNote> a(List<ColorNote> paramList, int paramInt)
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
  
  public List<ColorNote> a(boolean paramBoolean, int paramInt)
  {
    try
    {
      if ((this.jdField_a_of_type_JavaUtilList.isEmpty()) && (paramBoolean))
      {
        localList = this.jdField_a_of_type_Awbw.a(ColorNote.class);
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
    this.jdField_a_of_type_Awbw = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    Object localObject = this.jdField_a_of_type_Awbw.a(ColorNote.class, true, null, null, null, null, null, null);
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      this.jdField_a_of_type_JavaUtilList = ((List)localObject);
      aobd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), false, false);
    }
    localObject = anxl.a();
    if ((localObject != null) && (((anxk)localObject).a() != -1))
    {
      jdField_a_of_type_Int = ((anxk)localObject).a();
      if (QLog.isColorLevel()) {
        QLog.e("ColorNoteConfigProcessor", 2, "init MAX_COUNT " + jdField_a_of_type_Int);
      }
    }
  }
  
  protected void a(ColorNote paramColorNote)
  {
    if (this.jdField_a_of_type_Awbw != null) {
      this.jdField_a_of_type_Awbw.a(paramColorNote);
    }
  }
  
  protected void a(String paramString1, int paramInt, String paramString2, ContentValues paramContentValues, String paramString3, String[] paramArrayOfString, amji paramamji)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(paramString1, paramInt, paramString2, paramContentValues, paramString3, paramArrayOfString, 1, paramamji);
  }
  
  public void a(String arg1, ColorNote paramColorNote, amji paramamji)
  {
    if (paramColorNote != null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramColorNote);
      ThreadManagerV2.excute(new ColorNoteProxy.1(this, paramColorNote), 32, null, false);
      return;
    }
  }
  
  public void a(String paramString, ColorNote paramColorNote, amji paramamji, boolean paramBoolean)
  {
    if ((!a(paramColorNote)) && (aobd.a())) {
      if (paramColorNote.getServiceType() == 16973824) {
        azmj.b(null, "dc00898", "", "", "0X800A746", "0X800A746", 0, 0, "", "", "", "");
      }
    }
    while (!QLog.isColorLevel()) {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (anyi.b(paramColorNote))
        {
          this.jdField_a_of_type_JavaUtilList.add(0, paramColorNote);
          if (paramColorNote.getServiceType() != 16973824) {
            b(paramString, paramColorNote, paramamji, paramBoolean);
          }
          return;
        }
        this.jdField_a_of_type_JavaUtilList.add(paramColorNote);
      }
    }
    QLog.e("ColorNoteProxy", 2, "addColorNote error! isAfterSyncMsg = " + aobd.a());
  }
  
  protected void a(List<ColorNote> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    ThreadManagerV2.excute(new ColorNoteProxy.2(this, paramList), 32, null, false);
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
          if (anyi.b(localColorNote)) {
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
  
  boolean a(ColorNote paramColorNote)
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
        if (anyi.b(localColorNote)) {
          localArrayList.add(localColorNote);
        }
      }
    }
    localList.removeAll(localArrayList);
    ??? = localArrayList.iterator();
    while (((Iterator)???).hasNext()) {
      a(paramString, (ColorNote)((Iterator)???).next(), null);
    }
    if (paramColorNote != null) {
      a(paramString, paramColorNote, null, false);
    }
    return true;
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Awbw != null) {
      this.jdField_a_of_type_Awbw.a();
    }
  }
  
  protected void b(ColorNote paramColorNote)
  {
    a(paramColorNote);
  }
  
  protected void b(String paramString, ColorNote paramColorNote, amji paramamji, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      b(paramColorNote);
      return;
    }
    a(paramColorNote);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anyf
 * JD-Core Version:    0.7.0.1
 */