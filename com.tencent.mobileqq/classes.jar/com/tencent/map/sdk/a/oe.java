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
    paramc = this.b;
    if (paramc != null)
    {
      this.c = om.a(paramc.a, this.b.b);
      boolean bool;
      if (this.b.h == -1) {
        bool = true;
      } else {
        bool = false;
      }
      this.g = bool;
      if (!this.g) {
        this.a = new oa.a(this.b.h, this.b.e);
      }
      this.d = om.b(this.c, ".disk_idx_root");
      this.f = new ArrayList();
      this.e = new HashMap();
      paramc = om.d(this.d);
      if (paramc != null)
      {
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
      paramc = new StringBuilder("loadRootIndex count:");
      paramc.append(this.e.size());
      paramc.toString();
      os.a();
      paramc = new StringBuilder("loadRootIndex count:");
      paramc.append(this.e.size());
      Log.d("dorothy", paramc.toString());
    }
  }
  
  public final D a(String paramString, Class<D> paramClass)
  {
    os.b();
    Object localObject1 = this.b.i.a(paramString);
    boolean bool = this.g;
    StringBuilder localStringBuilder = null;
    int i = 0;
    if ((!bool) || (this.b.d != -1L))
    {
      paramString = (String)this.e.get(localObject1);
      if ((paramString != null) && (!this.f.contains(paramString)))
      {
        Object localObject2 = os.a("DiskCache");
        "key：".concat(String.valueOf(localObject1));
        "dir : ".concat(String.valueOf(paramString));
        ((os.a)localObject2).a();
        localObject2 = om.d(om.b(new File(paramString), ".disk_idx"));
        Object localObject3 = os.a("DiskCache");
        ((List)localObject2).toArray();
        ((os.a)localObject3).a();
        if (this.a != null)
        {
          localObject3 = ((List)localObject2).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            Object localObject4 = ((String)((Iterator)localObject3).next()).split("#");
            String[] arrayOfString = localObject4[1].split(",");
            localObject4 = localObject4[0];
            String str = arrayOfString[0];
            int j = Integer.parseInt(arrayOfString[1]);
            this.a.a(localObject4, new oe.b(new File(paramString, str), j));
          }
        }
        if (((List)localObject2).size() > 0) {
          this.f.add(paramString);
        }
      }
      if (!this.g)
      {
        paramString = (oe.b)this.a.b(localObject1);
        if (paramString != null)
        {
          paramString = paramString.a;
          break label313;
        }
      }
    }
    paramString = null;
    label313:
    localObject1 = this.b.c.a((String)localObject1, paramString);
    paramString = localStringBuilder;
    if (localObject1 != null) {
      try
      {
        paramString = (nz)paramClass.newInstance();
        paramString.a((byte[])localObject1);
      }
      catch (InstantiationException paramString)
      {
        localStringBuilder = new StringBuilder("The ");
        localStringBuilder.append(paramClass.getSimpleName());
        localStringBuilder.append(" must have a empty construct. #");
        localStringBuilder.append(paramString.getMessage());
        throw new Error(localStringBuilder.toString(), paramString);
      }
      catch (IllegalAccessException paramString)
      {
        localStringBuilder = new StringBuilder("The ");
        localStringBuilder.append(paramClass.getSimpleName());
        localStringBuilder.append(" must have a empty construct. #");
        localStringBuilder.append(paramString.getMessage());
        throw new Error(localStringBuilder.toString(), paramString);
      }
    }
    if (localObject1 != null) {
      i = localObject1.length;
    }
    os.c();
    os.f();
    return paramString;
  }
  
  public final void a()
  {
    if (this.c != null)
    {
      if (this.g)
      {
        this.b.c.a(this.c);
        return;
      }
      this.a.a();
      this.b.c.a(this.c);
    }
  }
  
  public final void a(String paramString, D paramD)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramD == null) {
        return;
      }
      os.b();
      paramString = this.b.i.a(paramString);
      paramD = paramD.b();
      int i = 0;
      if (paramD != null)
      {
        File localFile = this.b.c.a(paramString, this.c.getAbsolutePath(), paramD);
        if ((!this.g) || (this.b.d != -1L))
        {
          Object localObject2 = new oe.b(localFile, paramD.length);
          if (!this.g) {
            this.a.a(paramString, localObject2);
          }
          if (((oe.b)localObject2).a != null)
          {
            localFile = ((oe.b)localObject2).a.getParentFile();
            Object localObject1 = om.b(localFile, ".disk_idx");
            Object localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(paramString);
            ((StringBuilder)localObject3).append("#");
            ((StringBuilder)localObject3).append(((oe.b)localObject2).toString());
            localObject2 = ((StringBuilder)localObject3).toString();
            if (om.d((File)localObject1, (String)localObject2) == -1)
            {
              localObject3 = os.a("DiskCache");
              "index writeLine data:".concat(String.valueOf(localObject2));
              ((os.a)localObject3).a();
              om.c((File)localObject1, (String)localObject2);
            }
            int j = om.d(this.d, localFile.getAbsolutePath());
            if (j != -1)
            {
              localObject1 = ",".concat(String.valueOf(paramString));
              localObject2 = om.a(this.d, j);
              if ((localObject2 != null) && (!((String)localObject2).contains(paramString)))
              {
                localObject2 = os.a("DiskCache");
                "root writeAppend data:".concat(String.valueOf(localObject1));
                ((os.a)localObject2).a();
                om.a(this.d, j, ",".concat(String.valueOf(paramString)));
              }
            }
            else
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(localFile.getAbsolutePath());
              ((StringBuilder)localObject1).append("#");
              ((StringBuilder)localObject1).append(paramString);
              localObject1 = ((StringBuilder)localObject1).toString();
              localObject2 = os.a("DiskCache");
              "root writeLine data:".concat(String.valueOf(localObject1));
              ((os.a)localObject2).a();
              om.c(this.d, (String)localObject1);
            }
            this.e.put(paramString, localFile.getAbsolutePath());
          }
        }
      }
      if (paramD != null) {
        i = paramD.length;
      }
      os.c();
      os.f();
    }
  }
  
  public final void b()
  {
    Object localObject = this.b;
    if ((localObject != null) && (((oe.c)localObject).d != -1L) && (this.e.size() > this.b.d))
    {
      localObject = new StringBuilder("cached tile count:");
      ((StringBuilder)localObject).append(this.e.size());
      ((StringBuilder)localObject).toString();
      os.a();
      localObject = new StringBuilder("cached tile count:");
      ((StringBuilder)localObject).append(this.e.size());
      Log.d("dorothy", ((StringBuilder)localObject).toString());
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.oe
 * JD-Core Version:    0.7.0.1
 */