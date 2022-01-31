package com.tencent.map.sdk.a;

import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class oe<D extends nz>
  extends of<D>
{
  private static final oe.a h = new oe.1();
  private oa.a<oe.b> a;
  private oe.c b;
  private File c;
  private File d;
  private Map<String, String> e;
  private List<String> f;
  private boolean g;
  
  oe(oe.c paramc)
  {
    super(paramc);
    this.b = paramc;
    if (this.b != null)
    {
      this.c = om.a(this.b.a, this.b.b);
      if (this.b.h == -1) {}
      for (boolean bool = true;; bool = false)
      {
        this.g = bool;
        if (!this.g) {
          this.a = new oa.a(this.b.h, this.b.e);
        }
        this.d = om.b(this.c, ".disk_idx_root");
        this.f = new ArrayList();
        this.e = new HashMap();
        paramc = om.d(this.d);
        if (paramc == null) {
          break;
        }
        paramc = paramc.iterator();
        while (paramc.hasNext())
        {
          Object localObject = (String)paramc.next();
          if (((String)localObject).length() > 0)
          {
            localObject = ((String)localObject).split("#");
            if (localObject.length > 1)
            {
              String[] arrayOfString = localObject[1].split(",");
              int j = arrayOfString.length;
              int i = 0;
              while (i < j)
              {
                String str = arrayOfString[i];
                this.e.put(str, localObject[0]);
                i += 1;
              }
            }
          }
        }
      }
      new StringBuilder("loadRootIndex count:").append(this.e.size()).toString();
      os.a();
      Log.d("dorothy", "loadRootIndex count:" + this.e.size());
    }
  }
  
  public final D a(String paramString, Class<D> paramClass)
  {
    Object localObject1 = null;
    os.b();
    Object localObject2 = this.b.i.a(paramString);
    int i;
    if ((!this.g) || (this.b.d != -1L))
    {
      paramString = (String)this.e.get(localObject2);
      if ((paramString != null) && (!this.f.contains(paramString)))
      {
        Object localObject3 = os.a("DiskCache");
        "key：".concat(String.valueOf(localObject2));
        "dir : ".concat(String.valueOf(paramString));
        ((os.a)localObject3).a();
        localObject3 = om.d(om.b(new File(paramString), ".disk_idx"));
        Object localObject4 = os.a("DiskCache");
        ((List)localObject3).toArray();
        ((os.a)localObject4).a();
        if (this.a != null)
        {
          localObject4 = ((List)localObject3).iterator();
          while (((Iterator)localObject4).hasNext())
          {
            Object localObject5 = ((String)((Iterator)localObject4).next()).split("#");
            String[] arrayOfString = localObject5[1].split(",");
            localObject5 = localObject5[0];
            String str = arrayOfString[0];
            i = Integer.parseInt(arrayOfString[1]);
            this.a.a(localObject5, new oe.b(new File(paramString, str), i));
          }
        }
        if (((List)localObject3).size() > 0) {
          this.f.add(paramString);
        }
      }
      if (!this.g)
      {
        paramString = (oe.b)this.a.b(localObject2);
        if (paramString == null) {}
      }
    }
    for (paramString = paramString.a;; paramString = null)
    {
      localObject2 = this.b.c.a((String)localObject2, paramString);
      paramString = localObject1;
      if (localObject2 != null) {}
      for (;;)
      {
        try
        {
          paramString = (nz)paramClass.newInstance();
          paramString.a((byte[])localObject2);
          if (localObject2 == null)
          {
            i = 0;
            os.c();
            os.f();
            return paramString;
          }
        }
        catch (IllegalAccessException paramString)
        {
          throw new Error("The " + paramClass.getSimpleName() + " must have a empty construct. #" + paramString.getMessage(), paramString);
        }
        catch (InstantiationException paramString)
        {
          throw new Error("The " + paramClass.getSimpleName() + " must have a empty construct. #" + paramString.getMessage(), paramString);
        }
        i = localObject2.length;
      }
    }
  }
  
  public final void a()
  {
    if (this.c != null)
    {
      if (this.g) {
        this.b.c.a(this.c);
      }
    }
    else {
      return;
    }
    this.a.a();
    this.b.c.a(this.c);
  }
  
  public final void a(String paramString, D paramD)
  {
    int i = 0;
    if ((TextUtils.isEmpty(paramString)) || (paramD == null)) {
      return;
    }
    os.b();
    paramString = this.b.i.a(paramString);
    paramD = paramD.b();
    File localFile;
    Object localObject2;
    Object localObject1;
    if (paramD != null)
    {
      localFile = this.b.c.a(paramString, this.c.getAbsolutePath(), paramD);
      if ((!this.g) || (this.b.d != -1L))
      {
        localObject2 = new oe.b(localFile, paramD.length);
        if (!this.g) {
          this.a.a(paramString, localObject2);
        }
        if (((oe.b)localObject2).a != null)
        {
          localFile = ((oe.b)localObject2).a.getParentFile();
          localObject1 = om.b(localFile, ".disk_idx");
          localObject2 = paramString + "#" + ((oe.b)localObject2).toString();
          if (om.d((File)localObject1, (String)localObject2) == -1)
          {
            os.a locala = os.a("DiskCache");
            "index writeLine data:".concat(String.valueOf(localObject2));
            locala.a();
            om.c((File)localObject1, (String)localObject2);
          }
          int j = om.d(this.d, localFile.getAbsolutePath());
          if (j == -1) {
            break label339;
          }
          localObject1 = ",".concat(String.valueOf(paramString));
          localObject2 = om.a(this.d, j);
          if ((localObject2 != null) && (!((String)localObject2).contains(paramString)))
          {
            localObject2 = os.a("DiskCache");
            "root writeAppend data:".concat(String.valueOf(localObject1));
            ((os.a)localObject2).a();
            om.a(this.d, j, ",".concat(String.valueOf(paramString)));
          }
          this.e.put(paramString, localFile.getAbsolutePath());
        }
      }
    }
    if (paramD == null) {}
    for (;;)
    {
      os.c();
      os.f();
      return;
      label339:
      localObject1 = localFile.getAbsolutePath() + "#" + paramString;
      localObject2 = os.a("DiskCache");
      "root writeLine data:".concat(String.valueOf(localObject1));
      ((os.a)localObject2).a();
      om.c(this.d, (String)localObject1);
      break;
      i = paramD.length;
    }
  }
  
  public final void b()
  {
    if ((this.b != null) && (this.b.d != -1L) && (this.e.size() > this.b.d))
    {
      new StringBuilder("cached tile count:").append(this.e.size()).toString();
      os.a();
      Log.d("dorothy", "cached tile count:" + this.e.size());
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.map.sdk.a.oe
 * JD-Core Version:    0.7.0.1
 */