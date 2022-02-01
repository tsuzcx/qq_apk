import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.open.component.cache.database.AbstractDbCacheManager;
import com.tencent.open.component.cache.database.DbCacheData;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bjmk
  extends AbstractDbCacheManager
{
  protected Cursor a;
  protected bjmm a;
  protected String b;
  protected final ArrayList<WeakReference<bjml>> b;
  protected String c;
  
  protected bjmk(Context paramContext, Class<? extends DbCacheData> paramClass, long paramLong, String paramString)
  {
    super(paramContext, paramClass, paramLong, paramString);
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    h();
  }
  
  public int a()
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_AndroidDatabaseCursor != null)
        {
          i = this.jdField_a_of_type_AndroidDatabaseCursor.getCount();
          return i;
        }
      }
      finally {}
      int i = 0;
    }
  }
  
  public DbCacheData a(int paramInt)
  {
    try
    {
      DbCacheData localDbCacheData = a(this.jdField_a_of_type_AndroidDatabaseCursor, paramInt);
      return localDbCacheData;
    }
    finally {}
  }
  
  protected List<bjml> a()
  {
    ArrayList localArrayList1;
    Object localObject2;
    for (;;)
    {
      synchronized (this.jdField_b_of_type_JavaUtilArrayList)
      {
        if (this.jdField_b_of_type_JavaUtilArrayList.size() <= 0) {
          break;
        }
        localArrayList1 = new ArrayList();
        Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
        if (!localIterator.hasNext()) {
          break label99;
        }
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if (localWeakReference == null)
        {
          localWeakReference = null;
          if (localWeakReference == null) {
            continue;
          }
          localArrayList1.add(localWeakReference);
        }
      }
      localObject2 = (bjml)localObject1.get();
    }
    for (;;)
    {
      return localObject2;
      localObject2 = null;
      continue;
      label99:
      localObject2 = localArrayList1;
    }
  }
  
  public void a(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      super.a(paramSQLiteDatabase, paramInt);
      return;
    }
    a(paramSQLiteDatabase, this.jdField_b_of_type_JavaLangString);
  }
  
  void a(bjmm parambjmm)
  {
    this.jdField_a_of_type_Bjmm = parambjmm;
  }
  
  public void a(DbCacheData paramDbCacheData, int paramInt)
  {
    try
    {
      a(paramInt, new DbCacheData[] { paramDbCacheData });
      return;
    }
    finally {}
  }
  
  public void a(DbCacheData[] paramArrayOfDbCacheData, int paramInt)
  {
    try
    {
      a(paramInt, paramArrayOfDbCacheData);
      return;
    }
    finally {}
  }
  
  public void b(DbCacheData paramDbCacheData, String paramString)
  {
    try
    {
      a(paramDbCacheData, paramString);
      return;
    }
    finally {}
  }
  
  public void b(String paramString)
  {
    try
    {
      a(paramString);
      return;
    }
    finally {}
  }
  
  public void c()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidDatabaseCursor != null)
      {
        this.jdField_a_of_type_AndroidDatabaseCursor.close();
        this.jdField_a_of_type_AndroidDatabaseCursor = null;
      }
      g();
      e();
      return;
    }
    finally {}
  }
  
  public void d()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidDatabaseCursor != null) {
        this.jdField_a_of_type_AndroidDatabaseCursor.close();
      }
      h();
      e();
      return;
    }
    finally {}
  }
  
  public void e()
  {
    Object localObject = a();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        bjml localbjml = (bjml)((Iterator)localObject).next();
        if (localbjml != null) {
          localbjml.a(this);
        }
      }
    }
  }
  
  protected void g()
  {
    bjmm localbjmm = this.jdField_a_of_type_Bjmm;
    if (localbjmm != null) {
      localbjmm.a(this);
    }
  }
  
  protected void h()
  {
    try
    {
      this.jdField_a_of_type_AndroidDatabaseCursor = a(this.jdField_b_of_type_JavaLangString, this.c);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjmk
 * JD-Core Version:    0.7.0.1
 */