import android.content.ContentValues;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.proxy.ProxyListener;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNoteProxy.2;
import com.tencent.mobileqq.colornote.data.ColorNoteProxy.3;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class aplh
  extends anus
{
  public static int a;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  ArrayList<aplj> jdField_a_of_type_JavaUtilArrayList;
  private Comparator<ColorNote> jdField_a_of_type_JavaUtilComparator = new apli(this);
  protected List<ColorNote> a;
  
  static
  {
    jdField_a_of_type_Int = 9;
  }
  
  public aplh(QQAppInterface paramQQAppInterface, ProxyManager paramProxyManager)
  {
    super(paramQQAppInterface, paramProxyManager);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private int a(ColorNote paramColorNote1, ColorNote paramColorNote2)
  {
    long l = paramColorNote1.mTime - paramColorNote2.mTime;
    if (l == 0L) {
      return 0;
    }
    if (l < 0L) {
      return 1;
    }
    return -1;
  }
  
  private void a(int paramInt, ColorNote paramColorNote)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return;
    }
    ArrayList localArrayList = (ArrayList)this.jdField_a_of_type_JavaUtilArrayList.clone();
    int j = localArrayList.size();
    int i = 0;
    label29:
    if (i < j)
    {
      if (paramInt != 1) {
        break label62;
      }
      ((aplj)localArrayList.get(i)).a(paramColorNote);
    }
    for (;;)
    {
      i += 1;
      break label29;
      break;
      label62:
      if (paramInt == 2) {
        ((aplj)localArrayList.get(i)).b(paramColorNote);
      }
    }
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
        if ((Modifier.isStatic(((Field)localObject).getModifiers())) || (((Field)localObject).isAnnotationPresent(notColumn.class))) {
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
  
  public ArrayList<ColorNote> a(String paramString, ProxyListener paramProxyListener)
  {
    return a(paramString, paramProxyListener, 0);
  }
  
  public ArrayList<ColorNote> a(String arg1, ProxyListener paramProxyListener, int paramInt)
  {
    paramProxyListener = new ArrayList();
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        ColorNote localColorNote = (ColorNote)localIterator.next();
        if (localColorNote.mExtra == paramInt) {
          paramProxyListener.add(localColorNote);
        }
      }
    }
    this.jdField_a_of_type_JavaUtilList.removeAll(paramProxyListener);
    a(paramProxyListener);
    return paramProxyListener;
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
      int i;
      try
      {
        ArrayList localArrayList = new ArrayList();
        if (!paramList.isEmpty())
        {
          i = paramList.size() - 1;
          if (i >= 0)
          {
            ColorNote localColorNote = (ColorNote)paramList.get(i);
            if ((localColorNote.isOpen()) && (!aplm.d(localColorNote))) {
              break label96;
            }
            localArrayList.add(localColorNote);
            break label96;
          }
        }
        Collections.sort(localArrayList, this.jdField_a_of_type_JavaUtilComparator);
        paramList = a(localArrayList, 0);
        return paramList;
      }
      finally {}
      label96:
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
        localList = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(ColorNote.class);
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
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(ColorNote.class, true, null, null, null, null, null, null);
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      this.jdField_a_of_type_JavaUtilList = ((List)localObject);
      apoh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), false, false);
    }
    localObject = apkl.a();
    if ((localObject != null) && (((apkk)localObject).a() != -1))
    {
      jdField_a_of_type_Int = ((apkk)localObject).a();
      if (QLog.isColorLevel()) {
        QLog.e("ColorNoteConfigProcessor", 2, "init MAX_COUNT " + jdField_a_of_type_Int);
      }
    }
    apoh.a(BaseApplicationImpl.getContext(), 3, true);
  }
  
  public void a(aplj paramaplj)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramaplj)) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramaplj);
    }
  }
  
  public void a(ColorNote paramColorNote)
  {
    Object localObject2 = this.jdField_a_of_type_JavaUtilList;
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ColorNote localColorNote = (ColorNote)((Iterator)localObject2).next();
        if (localColorNote.equals(paramColorNote))
        {
          localColorNote.mExtLong |= 1L;
          a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), localColorNote.getUniKey(), "mExtLong", Long.valueOf(localColorNote.mExtLong));
        }
      }
      return;
    }
  }
  
  protected void a(String paramString1, int paramInt, String paramString2, ContentValues paramContentValues, String paramString3, String[] paramArrayOfString, ProxyListener paramProxyListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.addMsgQueue(paramString1, paramInt, paramString2, paramContentValues, paramString3, paramArrayOfString, 1, paramProxyListener);
  }
  
  public void a(String arg1, ColorNote paramColorNote, ProxyListener paramProxyListener)
  {
    if (paramColorNote != null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramColorNote);
      ThreadManagerV2.excute(new ColorNoteProxy.2(this, paramColorNote), 32, null, false);
      return;
    }
  }
  
  protected void a(String paramString, ColorNote paramColorNote, ProxyListener paramProxyListener, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      c(paramColorNote);
      return;
    }
    b(paramColorNote);
  }
  
  protected void a(List<ColorNote> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    ThreadManagerV2.excute(new ColorNoteProxy.3(this, paramList), 32, null, false);
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
          if (aplm.b(localColorNote)) {
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
        if (aplm.b(localColorNote)) {
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
  
  public boolean a(String paramString, ColorNote paramColorNote, ProxyListener paramProxyListener, boolean paramBoolean)
  {
    boolean bool = false;
    if ((!a(paramColorNote)) && (apoh.a())) {
      if (paramColorNote.getServiceType() == 16973824) {
        bcef.b(null, "dc00898", "", "", "0X800A746", "0X800A746", 0, 0, "", "", "", "");
      }
    }
    do
    {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (aplm.b(paramColorNote))
        {
          this.jdField_a_of_type_JavaUtilList.add(0, paramColorNote);
          if (paramColorNote.getServiceType() != 16973824) {
            a(paramString, paramColorNote, paramProxyListener, paramBoolean);
          }
          paramBoolean = true;
          return paramBoolean;
        }
        this.jdField_a_of_type_JavaUtilList.add(paramColorNote);
      }
      paramBoolean = bool;
    } while (!QLog.isColorLevel());
    QLog.e("ColorNoteProxy", 2, "addColorNote error! isAfterSyncMsg = " + apoh.a());
    return false;
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.close();
    }
  }
  
  public void b(aplj paramaplj)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramaplj);
    }
  }
  
  protected void b(ColorNote paramColorNote)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.persist(paramColorNote);
    }
    a(1, paramColorNote);
  }
  
  public void c()
  {
    Object localObject2 = this.jdField_a_of_type_JavaUtilList;
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ColorNote localColorNote = (ColorNote)((Iterator)localObject2).next();
        if (aplm.c(localColorNote))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ColorNoteProxy", 2, "clearAllUpcomingMindFlag ~~ " + localColorNote);
          }
          localColorNote.mExtLong &= 0L;
          a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), localColorNote.getUniKey(), "mExtLong", Long.valueOf(localColorNote.mExtLong));
        }
      }
    }
  }
  
  protected void c(ColorNote paramColorNote)
  {
    b(paramColorNote);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aplh
 * JD-Core Version:    0.7.0.1
 */