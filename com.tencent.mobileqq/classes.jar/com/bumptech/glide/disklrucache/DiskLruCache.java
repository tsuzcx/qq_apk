package com.bumptech.glide.disklrucache;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class DiskLruCache
  implements Closeable
{
  final ThreadPoolExecutor a = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DiskLruCache.DiskLruCacheThreadFactory(null));
  private final File b;
  private final File c;
  private final File d;
  private final File e;
  private final int f;
  private long g;
  private final int h;
  private long i = 0L;
  private Writer j;
  private final LinkedHashMap<String, DiskLruCache.Entry> k = new LinkedHashMap(0, 0.75F, true);
  private int l;
  private long m = 0L;
  private final Callable<Void> n = new DiskLruCache.1(this);
  
  private DiskLruCache(File paramFile, int paramInt1, int paramInt2, long paramLong)
  {
    this.b = paramFile;
    this.f = paramInt1;
    this.c = new File(paramFile, "journal");
    this.d = new File(paramFile, "journal.tmp");
    this.e = new File(paramFile, "journal.bkp");
    this.h = paramInt2;
    this.g = paramLong;
  }
  
  private DiskLruCache.Editor a(String paramString, long paramLong)
  {
    try
    {
      f();
      DiskLruCache.Entry localEntry = (DiskLruCache.Entry)this.k.get(paramString);
      if (paramLong != -1L) {
        if (localEntry != null)
        {
          long l1 = DiskLruCache.Entry.e(localEntry);
          if (l1 == paramLong) {}
        }
        else
        {
          return null;
        }
      }
      if (localEntry == null)
      {
        localEntry = new DiskLruCache.Entry(this, paramString, null);
        this.k.put(paramString, localEntry);
      }
      else
      {
        localEditor = DiskLruCache.Entry.a(localEntry);
        if (localEditor != null) {
          return null;
        }
      }
      DiskLruCache.Editor localEditor = new DiskLruCache.Editor(this, localEntry, null);
      DiskLruCache.Entry.a(localEntry, localEditor);
      this.j.append("DIRTY");
      this.j.append(' ');
      this.j.append(paramString);
      this.j.append('\n');
      this.j.flush();
      return localEditor;
    }
    finally {}
  }
  
  public static DiskLruCache a(File paramFile, int paramInt1, int paramInt2, long paramLong)
  {
    if (paramLong > 0L)
    {
      if (paramInt2 > 0)
      {
        Object localObject = new File(paramFile, "journal.bkp");
        if (((File)localObject).exists())
        {
          File localFile = new File(paramFile, "journal");
          if (localFile.exists()) {
            ((File)localObject).delete();
          } else {
            a((File)localObject, localFile, false);
          }
        }
        localObject = new DiskLruCache(paramFile, paramInt1, paramInt2, paramLong);
        if (((DiskLruCache)localObject).c.exists()) {
          try
          {
            ((DiskLruCache)localObject).b();
            ((DiskLruCache)localObject).c();
            return localObject;
          }
          catch (IOException localIOException)
          {
            PrintStream localPrintStream = System.out;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("DiskLruCache ");
            localStringBuilder.append(paramFile);
            localStringBuilder.append(" is corrupt: ");
            localStringBuilder.append(localIOException.getMessage());
            localStringBuilder.append(", removing");
            localPrintStream.println(localStringBuilder.toString());
            ((DiskLruCache)localObject).a();
          }
        }
        paramFile.mkdirs();
        paramFile = new DiskLruCache(paramFile, paramInt1, paramInt2, paramLong);
        paramFile.d();
        return paramFile;
      }
      throw new IllegalArgumentException("valueCount <= 0");
    }
    throw new IllegalArgumentException("maxSize <= 0");
  }
  
  private void a(DiskLruCache.Editor paramEditor, boolean paramBoolean)
  {
    try
    {
      localEntry = DiskLruCache.Editor.a(paramEditor);
      if (DiskLruCache.Entry.a(localEntry) != paramEditor) {
        break label439;
      }
      int i3 = 0;
      i2 = i3;
      if (paramBoolean)
      {
        i2 = i3;
        if (!DiskLruCache.Entry.d(localEntry))
        {
          int i1 = 0;
          for (;;)
          {
            i2 = i3;
            if (i1 >= this.h) {
              break label126;
            }
            if (DiskLruCache.Editor.b(paramEditor)[i1] == 0) {
              break;
            }
            if (!localEntry.b(i1).exists())
            {
              paramEditor.b();
              return;
            }
            i1 += 1;
          }
          paramEditor.b();
          paramEditor = new StringBuilder();
          paramEditor.append("Newly created entry didn't create value for index ");
          paramEditor.append(i1);
          throw new IllegalStateException(paramEditor.toString());
        }
      }
    }
    finally
    {
      for (;;)
      {
        DiskLruCache.Entry localEntry;
        int i2;
        label126:
        File localFile;
        long l1;
        long l2;
        for (;;)
        {
          label439:
          throw paramEditor;
        }
        i2 += 1;
      }
    }
    if (i2 < this.h)
    {
      paramEditor = localEntry.b(i2);
      if (paramBoolean)
      {
        if (paramEditor.exists())
        {
          localFile = localEntry.a(i2);
          paramEditor.renameTo(localFile);
          l1 = DiskLruCache.Entry.b(localEntry)[i2];
          l2 = localFile.length();
          DiskLruCache.Entry.b(localEntry)[i2] = l2;
          this.i = (this.i - l1 + l2);
        }
      }
      else {
        a(paramEditor);
      }
    }
    else
    {
      this.l += 1;
      DiskLruCache.Entry.a(localEntry, null);
      if ((DiskLruCache.Entry.d(localEntry) | paramBoolean))
      {
        DiskLruCache.Entry.a(localEntry, true);
        this.j.append("CLEAN");
        this.j.append(' ');
        this.j.append(DiskLruCache.Entry.c(localEntry));
        this.j.append(localEntry.a());
        this.j.append('\n');
        if (paramBoolean)
        {
          l1 = this.m;
          this.m = (1L + l1);
          DiskLruCache.Entry.a(localEntry, l1);
        }
      }
      else
      {
        this.k.remove(DiskLruCache.Entry.c(localEntry));
        this.j.append("REMOVE");
        this.j.append(' ');
        this.j.append(DiskLruCache.Entry.c(localEntry));
        this.j.append('\n');
      }
      this.j.flush();
      if ((this.i > this.g) || (e())) {
        this.a.submit(this.n);
      }
      return;
      throw new IllegalStateException();
    }
  }
  
  private static void a(File paramFile)
  {
    if (paramFile.exists())
    {
      if (paramFile.delete()) {
        return;
      }
      throw new IOException();
    }
  }
  
  private static void a(File paramFile1, File paramFile2, boolean paramBoolean)
  {
    if (paramBoolean) {
      a(paramFile2);
    }
    if (paramFile1.renameTo(paramFile2)) {
      return;
    }
    throw new IOException();
  }
  
  private void b()
  {
    localStrictLineReader = new StrictLineReader(new FileInputStream(this.c), Util.a);
    for (;;)
    {
      try
      {
        str1 = localStrictLineReader.a();
        str2 = localStrictLineReader.a();
        localObject2 = localStrictLineReader.a();
        str3 = localStrictLineReader.a();
        str4 = localStrictLineReader.a();
        if (("libcore.io.DiskLruCache".equals(str1)) && ("1".equals(str2)) && (Integer.toString(this.f).equals(localObject2)) && (Integer.toString(this.h).equals(str3)))
        {
          boolean bool = "".equals(str4);
          if (bool) {
            i1 = 0;
          }
        }
      }
      finally
      {
        String str1;
        String str2;
        Object localObject2;
        String str3;
        String str4;
        int i1;
        Util.a(localStrictLineReader);
        continue;
        throw localObject1;
        continue;
      }
      try
      {
        d(localStrictLineReader.a());
        i1 += 1;
      }
      catch (EOFException localEOFException) {}
    }
    this.l = (i1 - this.k.size());
    if (localStrictLineReader.b()) {
      d();
    } else {
      this.j = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.c, true), Util.a));
    }
    Util.a(localStrictLineReader);
    return;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("unexpected journal header: [");
    ((StringBuilder)localObject2).append(str1);
    ((StringBuilder)localObject2).append(", ");
    ((StringBuilder)localObject2).append(str2);
    ((StringBuilder)localObject2).append(", ");
    ((StringBuilder)localObject2).append(str3);
    ((StringBuilder)localObject2).append(", ");
    ((StringBuilder)localObject2).append(str4);
    ((StringBuilder)localObject2).append("]");
    throw new IOException(((StringBuilder)localObject2).toString());
  }
  
  private void c()
  {
    a(this.d);
    Iterator localIterator = this.k.values().iterator();
    while (localIterator.hasNext())
    {
      DiskLruCache.Entry localEntry = (DiskLruCache.Entry)localIterator.next();
      DiskLruCache.Editor localEditor = DiskLruCache.Entry.a(localEntry);
      int i2 = 0;
      int i1 = 0;
      if (localEditor == null)
      {
        while (i1 < this.h)
        {
          this.i += DiskLruCache.Entry.b(localEntry)[i1];
          i1 += 1;
        }
      }
      else
      {
        DiskLruCache.Entry.a(localEntry, null);
        i1 = i2;
        while (i1 < this.h)
        {
          a(localEntry.a(i1));
          a(localEntry.b(i1));
          i1 += 1;
        }
        localIterator.remove();
      }
    }
  }
  
  private void d()
  {
    try
    {
      if (this.j != null) {
        this.j.close();
      }
      BufferedWriter localBufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.d), Util.a));
      try
      {
        localBufferedWriter.write("libcore.io.DiskLruCache");
        localBufferedWriter.write("\n");
        localBufferedWriter.write("1");
        localBufferedWriter.write("\n");
        localBufferedWriter.write(Integer.toString(this.f));
        localBufferedWriter.write("\n");
        localBufferedWriter.write(Integer.toString(this.h));
        localBufferedWriter.write("\n");
        localBufferedWriter.write("\n");
        Iterator localIterator = this.k.values().iterator();
        while (localIterator.hasNext())
        {
          DiskLruCache.Entry localEntry = (DiskLruCache.Entry)localIterator.next();
          StringBuilder localStringBuilder;
          if (DiskLruCache.Entry.a(localEntry) != null)
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("DIRTY ");
            localStringBuilder.append(DiskLruCache.Entry.c(localEntry));
            localStringBuilder.append('\n');
            localBufferedWriter.write(localStringBuilder.toString());
          }
          else
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("CLEAN ");
            localStringBuilder.append(DiskLruCache.Entry.c(localEntry));
            localStringBuilder.append(localEntry.a());
            localStringBuilder.append('\n');
            localBufferedWriter.write(localStringBuilder.toString());
          }
        }
        localBufferedWriter.close();
        if (this.c.exists()) {
          a(this.c, this.e, true);
        }
        a(this.d, this.c, false);
        this.e.delete();
        this.j = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.c, true), Util.a));
        return;
      }
      finally
      {
        localBufferedWriter.close();
      }
      throw localObject1;
    }
    finally {}
    for (;;) {}
  }
  
  private void d(String paramString)
  {
    int i1 = paramString.indexOf(' ');
    if (i1 != -1)
    {
      int i2 = i1 + 1;
      int i3 = paramString.indexOf(' ', i2);
      if (i3 == -1)
      {
        localObject2 = paramString.substring(i2);
        localObject1 = localObject2;
        if (i1 == 6)
        {
          localObject1 = localObject2;
          if (paramString.startsWith("REMOVE")) {
            this.k.remove(localObject2);
          }
        }
      }
      else
      {
        localObject1 = paramString.substring(i2, i3);
      }
      DiskLruCache.Entry localEntry = (DiskLruCache.Entry)this.k.get(localObject1);
      Object localObject2 = localEntry;
      if (localEntry == null)
      {
        localObject2 = new DiskLruCache.Entry(this, (String)localObject1, null);
        this.k.put(localObject1, localObject2);
      }
      if ((i3 != -1) && (i1 == 5) && (paramString.startsWith("CLEAN")))
      {
        paramString = paramString.substring(i3 + 1).split(" ");
        DiskLruCache.Entry.a((DiskLruCache.Entry)localObject2, true);
        DiskLruCache.Entry.a((DiskLruCache.Entry)localObject2, null);
        DiskLruCache.Entry.a((DiskLruCache.Entry)localObject2, paramString);
        return;
      }
      if ((i3 == -1) && (i1 == 5) && (paramString.startsWith("DIRTY")))
      {
        DiskLruCache.Entry.a((DiskLruCache.Entry)localObject2, new DiskLruCache.Editor(this, (DiskLruCache.Entry)localObject2, null));
        return;
      }
      if ((i3 == -1) && (i1 == 4) && (paramString.startsWith("READ"))) {
        return;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("unexpected journal line: ");
      ((StringBuilder)localObject1).append(paramString);
      throw new IOException(((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("unexpected journal line: ");
    ((StringBuilder)localObject1).append(paramString);
    throw new IOException(((StringBuilder)localObject1).toString());
  }
  
  private boolean e()
  {
    int i1 = this.l;
    return (i1 >= 2000) && (i1 >= this.k.size());
  }
  
  private void f()
  {
    if (this.j != null) {
      return;
    }
    throw new IllegalStateException("cache is closed");
  }
  
  private void g()
  {
    while (this.i > this.g) {
      c((String)((Map.Entry)this.k.entrySet().iterator().next()).getKey());
    }
  }
  
  public DiskLruCache.Value a(String paramString)
  {
    try
    {
      f();
      DiskLruCache.Entry localEntry = (DiskLruCache.Entry)this.k.get(paramString);
      if (localEntry == null) {
        return null;
      }
      boolean bool = DiskLruCache.Entry.d(localEntry);
      if (!bool) {
        return null;
      }
      File[] arrayOfFile = localEntry.a;
      int i2 = arrayOfFile.length;
      int i1 = 0;
      while (i1 < i2)
      {
        bool = arrayOfFile[i1].exists();
        if (!bool) {
          return null;
        }
        i1 += 1;
      }
      this.l += 1;
      this.j.append("READ");
      this.j.append(' ');
      this.j.append(paramString);
      this.j.append('\n');
      if (e()) {
        this.a.submit(this.n);
      }
      paramString = new DiskLruCache.Value(this, paramString, DiskLruCache.Entry.e(localEntry), localEntry.a, DiskLruCache.Entry.b(localEntry), null);
      return paramString;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void a()
  {
    close();
    Util.a(this.b);
  }
  
  public DiskLruCache.Editor b(String paramString)
  {
    return a(paramString, -1L);
  }
  
  public boolean c(String paramString)
  {
    try
    {
      f();
      DiskLruCache.Entry localEntry = (DiskLruCache.Entry)this.k.get(paramString);
      int i1 = 0;
      if ((localEntry != null) && (DiskLruCache.Entry.a(localEntry) == null))
      {
        while (i1 < this.h)
        {
          File localFile = localEntry.a(i1);
          if ((localFile.exists()) && (!localFile.delete()))
          {
            paramString = new StringBuilder();
            paramString.append("failed to delete ");
            paramString.append(localFile);
            throw new IOException(paramString.toString());
          }
          this.i -= DiskLruCache.Entry.b(localEntry)[i1];
          DiskLruCache.Entry.b(localEntry)[i1] = 0L;
          i1 += 1;
        }
        this.l += 1;
        this.j.append("REMOVE");
        this.j.append(' ');
        this.j.append(paramString);
        this.j.append('\n');
        this.k.remove(paramString);
        if (e()) {
          this.a.submit(this.n);
        }
        return true;
      }
      return false;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void close()
  {
    try
    {
      Object localObject1 = this.j;
      if (localObject1 == null) {
        return;
      }
      localObject1 = new ArrayList(this.k.values()).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        DiskLruCache.Entry localEntry = (DiskLruCache.Entry)((Iterator)localObject1).next();
        if (DiskLruCache.Entry.a(localEntry) != null) {
          DiskLruCache.Entry.a(localEntry).b();
        }
      }
      g();
      this.j.close();
      this.j = null;
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.disklrucache.DiskLruCache
 * JD-Core Version:    0.7.0.1
 */