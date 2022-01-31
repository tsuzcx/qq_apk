import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.open.component.cache.database.AbstractDbCacheManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bdkn
  extends AbstractDbCacheManager
{
  protected Cursor a;
  protected bdkp a;
  protected String b;
  protected final ArrayList<WeakReference<bdko>> b;
  protected String c;
  
  protected bdkn(Context paramContext, Class<? extends bdkj> paramClass, long paramLong, String paramString)
  {
    super(paramContext, paramClass, paramLong, paramString);
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    d();
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
  
  public bdkj a(int paramInt)
  {
    try
    {
      bdkj localbdkj = a(this.jdField_a_of_type_AndroidDatabaseCursor, paramInt);
      return localbdkj;
    }
    finally {}
  }
  
  protected List<bdko> a()
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
      localObject2 = (bdko)localObject1.get();
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
  
  public void a()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidDatabaseCursor != null) {
        this.jdField_a_of_type_AndroidDatabaseCursor.close();
      }
      d();
      b();
      return;
    }
    finally {}
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
  
  public void a(bdkj parambdkj, int paramInt)
  {
    try
    {
      a(paramInt, new bdkj[] { parambdkj });
      return;
    }
    finally {}
  }
  
  void a(bdkp parambdkp)
  {
    this.jdField_a_of_type_Bdkp = parambdkp;
  }
  
  public void a(bdkj[] paramArrayOfbdkj, int paramInt)
  {
    try
    {
      a(paramInt, paramArrayOfbdkj);
      return;
    }
    finally {}
  }
  
  public void b()
  {
    Object localObject = a();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        bdko localbdko = (bdko)((Iterator)localObject).next();
        if (localbdko != null) {
          localbdko.a(this);
        }
      }
    }
  }
  
  public void b(bdkj parambdkj, String paramString)
  {
    try
    {
      a(parambdkj, paramString);
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
  
  protected void d()
  {
    try
    {
      this.jdField_a_of_type_AndroidDatabaseCursor = a(this.jdField_b_of_type_JavaLangString, this.c);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdkn
 * JD-Core Version:    0.7.0.1
 */