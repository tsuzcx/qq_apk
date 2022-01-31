import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.open.component.cache.database.AbstractDbCacheManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bfnt
  extends AbstractDbCacheManager
{
  protected Cursor a;
  protected bfnv a;
  protected String b;
  protected final ArrayList<WeakReference<bfnu>> b;
  protected String c;
  
  protected bfnt(Context paramContext, Class<? extends bfnp> paramClass, long paramLong, String paramString)
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
  
  public bfnp a(int paramInt)
  {
    try
    {
      bfnp localbfnp = a(this.jdField_a_of_type_AndroidDatabaseCursor, paramInt);
      return localbfnp;
    }
    finally {}
  }
  
  protected List<bfnu> a()
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
      localObject2 = (bfnu)localObject1.get();
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
  
  public void a(bfnp parambfnp, int paramInt)
  {
    try
    {
      a(paramInt, new bfnp[] { parambfnp });
      return;
    }
    finally {}
  }
  
  void a(bfnv parambfnv)
  {
    this.jdField_a_of_type_Bfnv = parambfnv;
  }
  
  public void a(bfnp[] paramArrayOfbfnp, int paramInt)
  {
    try
    {
      a(paramInt, paramArrayOfbfnp);
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
        bfnu localbfnu = (bfnu)((Iterator)localObject).next();
        if (localbfnu != null) {
          localbfnu.a(this);
        }
      }
    }
  }
  
  public void b(bfnp parambfnp, String paramString)
  {
    try
    {
      a(parambfnp, paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfnt
 * JD-Core Version:    0.7.0.1
 */