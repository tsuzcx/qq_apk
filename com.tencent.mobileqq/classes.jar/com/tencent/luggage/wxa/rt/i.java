package com.tencent.luggage.wxa.rt;

import android.net.Uri;
import android.net.Uri.Builder;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class i
  implements Comparable<i>
{
  private final Uri a;
  private e.d b = null;
  
  public i(Uri paramUri)
  {
    if (paramUri != null)
    {
      String str = paramUri.getPath();
      Uri localUri = paramUri;
      if (str != null)
      {
        str = o.a(str, false, false);
        localUri = paramUri;
        if (!paramUri.getPath().equals(str)) {
          localUri = paramUri.buildUpon().path(str).build();
        }
      }
      this.a = localUri;
      return;
    }
    throw new NullPointerException("uri == null");
  }
  
  public i(Uri paramUri, String paramString)
  {
    if (paramString != null)
    {
      if (paramUri == null)
      {
        paramUri = new Uri.Builder().path(paramString);
      }
      else
      {
        localObject = paramUri.buildUpon();
        paramUri = (Uri)localObject;
        if (!paramString.isEmpty())
        {
          ((Uri.Builder)localObject).appendPath(paramString);
          paramUri = (Uri)localObject;
        }
      }
      Object localObject = paramUri.build();
      String str = ((Uri)localObject).getPath();
      paramString = (String)localObject;
      if (str != null)
      {
        str = o.a(str, false, false);
        paramString = (String)localObject;
        if (!((Uri)localObject).getPath().equals(str)) {
          paramString = paramUri.path(str).build();
        }
      }
      this.a = paramString;
      return;
    }
    throw new NullPointerException("name == null");
  }
  
  public i(i parami, String paramString)
  {
    this(parami, paramString);
  }
  
  public i(File paramFile)
  {
    this(o.a(paramFile.getPath()));
  }
  
  public i(File paramFile, String paramString)
  {
    this(paramFile, paramString);
  }
  
  public i(String paramString)
  {
    this(o.a(paramString));
  }
  
  public i(String paramString1, String paramString2)
  {
    this(paramString1, paramString2);
  }
  
  public static i a(File paramFile)
  {
    if (paramFile != null) {
      return new i(paramFile);
    }
    return null;
  }
  
  private Uri x()
  {
    if (k()) {
      return this.a;
    }
    String str2 = this.a.getPath();
    String str1 = System.getProperty("user.dir");
    if (!str2.isEmpty())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str1);
      localStringBuilder.append('/');
      localStringBuilder.append(str2);
      str1 = localStringBuilder.toString();
    }
    return this.a.buildUpon().path(str1).build();
  }
  
  e.d a()
  {
    this.b = e.a().a(this.a, this.b);
    return this.b;
  }
  
  public boolean a(i parami)
  {
    e.d locald = a();
    parami = parami.a();
    if (locald.a()) {
      if (!parami.a()) {
        return false;
      }
    }
    try
    {
      parami.a.a(parami.b, locald.a, locald.b);
      return true;
    }
    catch (IOException parami) {}
    return false;
    return false;
  }
  
  public i[] a(j paramj)
  {
    if (paramj == null) {
      return s();
    }
    Object localObject1 = a();
    if (!((e.d)localObject1).a()) {
      return null;
    }
    Object localObject2 = ((e.d)localObject1).a.b(((e.d)localObject1).b, false);
    if (localObject2 == null) {
      return null;
    }
    localObject1 = new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      i locali = new i(this, ((d.a)((Iterator)localObject2).next()).b);
      if (paramj.a(locali)) {
        ((ArrayList)localObject1).add(locali);
      }
    }
    return (i[])((ArrayList)localObject1).toArray(new i[0]);
  }
  
  public i[] a(n paramn)
  {
    if (paramn == null) {
      return s();
    }
    Object localObject1 = a();
    if (!((e.d)localObject1).a()) {
      return null;
    }
    Object localObject2 = ((e.d)localObject1).a.b(((e.d)localObject1).b, false);
    if (localObject2 == null) {
      return null;
    }
    localObject1 = new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      d.a locala = (d.a)((Iterator)localObject2).next();
      if (paramn.a(this, locala.b)) {
        ((ArrayList)localObject1).add(new i(this, locala.b));
      }
    }
    return (i[])((ArrayList)localObject1).toArray(new i[0]);
  }
  
  public int b(i parami)
  {
    return b().compareTo(parami.b());
  }
  
  public String b()
  {
    return o.a(this.a);
  }
  
  public Uri c()
  {
    return this.a;
  }
  
  public String d()
  {
    String str = this.a.getPath();
    int i = str.lastIndexOf("/");
    if (i < 0) {
      return str;
    }
    return str.substring(i + 1, str.length());
  }
  
  public Uri e()
  {
    String str = this.a.getPath();
    int i = str.length();
    int j = str.lastIndexOf('/');
    if ((j != -1) && (str.charAt(i - 1) != '/'))
    {
      if ((str.indexOf('/') == j) && (str.charAt(0) == '/')) {
        str = str.substring(0, j + 1);
      } else {
        str = str.substring(0, j);
      }
      return this.a.buildUpon().path(str).build();
    }
    return null;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof i)) {
      return false;
    }
    return this.a.equals(((i)paramObject).a);
  }
  
  public String f()
  {
    Uri localUri = e();
    if (localUri == null) {
      return null;
    }
    return o.a(localUri);
  }
  
  public i g()
  {
    Uri localUri = e();
    if (localUri == null) {
      return null;
    }
    return new i(localUri);
  }
  
  public boolean h()
  {
    e.d locald = a();
    if (!locald.a()) {
      return false;
    }
    d locald1 = locald.a;
    String str = locald1.d(locald.b, false);
    if (str != null) {
      return new File(str).canRead();
    }
    return locald1.c(locald.b);
  }
  
  public int hashCode()
  {
    return b().hashCode() ^ 0x12D591;
  }
  
  public boolean i()
  {
    e.d locald = a();
    if (!locald.a()) {
      return false;
    }
    d locald1 = locald.a;
    if ((locald1.b() & 0x1) == 0) {
      return false;
    }
    String str = locald1.d(locald.b, true);
    if (str != null) {
      return new File(str).canWrite();
    }
    return locald1.c(locald.b);
  }
  
  public boolean j()
  {
    e.d locald = a();
    if (!locald.a()) {
      return false;
    }
    return locald.a.c(locald.b);
  }
  
  public boolean k()
  {
    String str = this.a.getPath();
    boolean bool1 = this.a.isAbsolute();
    boolean bool2 = false;
    if (!bool1)
    {
      bool1 = bool2;
      if (str.length() > 0)
      {
        bool1 = bool2;
        if (str.charAt(0) != '/') {}
      }
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  public String l()
  {
    return o.a(x());
  }
  
  public i m()
  {
    return new i(x());
  }
  
  public boolean n()
  {
    Object localObject = a();
    boolean bool1 = ((e.d)localObject).a();
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    localObject = ((e.d)localObject).a.d(((e.d)localObject).b);
    bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (((d.a)localObject).f) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean o()
  {
    Object localObject = a();
    boolean bool1 = ((e.d)localObject).a();
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    localObject = ((e.d)localObject).a.d(((e.d)localObject).b);
    bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (!((d.a)localObject).f) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public long p()
  {
    Object localObject = a();
    if (!((e.d)localObject).a()) {
      return 0L;
    }
    localObject = ((e.d)localObject).a.d(((e.d)localObject).b);
    if (localObject == null) {
      return 0L;
    }
    return ((d.a)localObject).e;
  }
  
  public long q()
  {
    Object localObject = a();
    if (!((e.d)localObject).a()) {
      return 0L;
    }
    localObject = ((e.d)localObject).a.d(((e.d)localObject).b);
    if (localObject == null) {
      return 0L;
    }
    return ((d.a)localObject).c;
  }
  
  public String[] r()
  {
    Object localObject1 = a();
    if (!((e.d)localObject1).a()) {
      return null;
    }
    Object localObject2 = ((e.d)localObject1).a.b(((e.d)localObject1).b, false);
    if (localObject2 == null) {
      return null;
    }
    localObject1 = new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((ArrayList)localObject1).add(((d.a)((Iterator)localObject2).next()).b);
    }
    return (String[])((ArrayList)localObject1).toArray(new String[0]);
  }
  
  public i[] s()
  {
    Object localObject1 = a();
    if (!((e.d)localObject1).a()) {
      return null;
    }
    Object localObject2 = ((e.d)localObject1).a.b(((e.d)localObject1).b, false);
    if (localObject2 == null) {
      return null;
    }
    localObject1 = new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((ArrayList)localObject1).add(new i(this, ((d.a)((Iterator)localObject2).next()).b));
    }
    return (i[])((ArrayList)localObject1).toArray(new i[0]);
  }
  
  public boolean t()
  {
    return u();
  }
  
  public String toString()
  {
    return this.a.toString();
  }
  
  public boolean u()
  {
    e.d locald = a();
    if (!locald.a()) {
      return false;
    }
    return locald.a.f(locald.b);
  }
  
  public boolean v()
  {
    Object localObject = a();
    if (((e.d)localObject).a())
    {
      if (((e.d)localObject).a.c(((e.d)localObject).b)) {
        return false;
      }
      ((e.d)localObject).a.a(((e.d)localObject).b, false).close();
      return true;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Cannot resolve path or URI: ");
    ((StringBuilder)localObject).append(this.a);
    throw new FileNotFoundException(((StringBuilder)localObject).toString());
  }
  
  public boolean w()
  {
    e.d locald = a();
    return (locald.a()) && (locald.a.e(locald.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.rt.i
 * JD-Core Version:    0.7.0.1
 */