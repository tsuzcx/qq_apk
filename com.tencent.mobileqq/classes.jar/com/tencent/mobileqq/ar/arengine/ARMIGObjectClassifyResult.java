package com.tencent.mobileqq.ar.arengine;

import android.graphics.RectF;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.ar.arcloud.pb.JDSearch.JdSearchDetail;
import com.tencent.mobileqq.ar.arcloud.pb.JDSearch.JdSearchRsp;
import com.tencent.mobileqq.ar.arcloud.pb.JDSearch.JdSkuItem;
import com.tencent.mobileqq.ar.arcloud.pb.JDSearch.Rectangle;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import java.util.Iterator;
import java.util.List;

public class ARMIGObjectClassifyResult
  extends ARCloudObjectClassifyBaseResult
  implements ARCloudObjectClassifyCommonInterface.ARMigObjectClassifyInterface
{
  public static final String a = HardCodeUtil.a(2131898976);
  public int b = -1;
  public String c;
  public long d;
  public int e;
  public String f;
  public ARMIGObjectClassifyResult.RetrievalClassInfo[] g;
  public int h;
  public String i;
  public ARMIGObjectClassifyResult.ObjectBox j;
  public ARMIGObjectClassifyResult.JDSearchResult m;
  public String n = "";
  
  public ARMIGObjectClassifyResult()
  {
    super(2, 0);
  }
  
  public static ARMIGObjectClassifyResult.JDSearchResult a(JDSearch.JdSearchRsp paramJdSearchRsp)
  {
    ARMIGObjectClassifyResult.JDSearchResult localJDSearchResult = new ARMIGObjectClassifyResult.JDSearchResult();
    boolean bool = paramJdSearchRsp.jd_search_errorcode.has();
    int i1 = -1;
    int k;
    if (bool) {
      k = paramJdSearchRsp.jd_search_errorcode.get();
    } else {
      k = -1;
    }
    localJDSearchResult.a = k;
    Object localObject1;
    if (paramJdSearchRsp.jd_search_errormsg.has()) {
      localObject1 = paramJdSearchRsp.jd_search_errormsg.get();
    } else {
      localObject1 = "";
    }
    localJDSearchResult.b = ((String)localObject1);
    if (paramJdSearchRsp.jd_search_detail.has())
    {
      localObject1 = (JDSearch.JdSearchDetail)paramJdSearchRsp.jd_search_detail.get();
      if (((JDSearch.JdSearchDetail)localObject1).errorcode.has()) {
        k = ((JDSearch.JdSearchDetail)localObject1).errorcode.get();
      } else {
        k = -1;
      }
      localJDSearchResult.c = k;
      if (((JDSearch.JdSearchDetail)localObject1).errormsg.has()) {
        paramJdSearchRsp = ((JDSearch.JdSearchDetail)localObject1).errormsg.get();
      } else {
        paramJdSearchRsp = "";
      }
      localJDSearchResult.d = paramJdSearchRsp;
      if (((JDSearch.JdSearchDetail)localObject1).jd_more_url.has()) {
        paramJdSearchRsp = ((JDSearch.JdSearchDetail)localObject1).jd_more_url.get();
      } else {
        paramJdSearchRsp = "";
      }
      localJDSearchResult.g = paramJdSearchRsp;
      Object localObject2;
      if (((JDSearch.JdSearchDetail)localObject1).rectangle.has())
      {
        paramJdSearchRsp = (JDSearch.Rectangle)((JDSearch.JdSearchDetail)localObject1).rectangle.get();
        localObject2 = localJDSearchResult.h;
        bool = paramJdSearchRsp.left.has();
        float f2 = 0.0F;
        if (bool) {
          f1 = paramJdSearchRsp.left.get();
        } else {
          f1 = 0.0F;
        }
        ((RectF)localObject2).left = f1;
        localObject2 = localJDSearchResult.h;
        if (paramJdSearchRsp.top.has()) {
          f1 = paramJdSearchRsp.top.get();
        } else {
          f1 = 0.0F;
        }
        ((RectF)localObject2).top = f1;
        localObject2 = localJDSearchResult.h;
        if (paramJdSearchRsp.right.has()) {
          f1 = paramJdSearchRsp.right.get();
        } else {
          f1 = 0.0F;
        }
        ((RectF)localObject2).right = f1;
        localObject2 = localJDSearchResult.h;
        float f1 = f2;
        if (paramJdSearchRsp.bottom.has()) {
          f1 = paramJdSearchRsp.bottom.get();
        }
        ((RectF)localObject2).bottom = f1;
        k = i1;
        if (paramJdSearchRsp.is_user_rectangle.has()) {
          k = paramJdSearchRsp.is_user_rectangle.get();
        }
        localJDSearchResult.i = k;
      }
      if (((JDSearch.JdSearchDetail)localObject1).jd_sku_item.has()) {
        paramJdSearchRsp = ((JDSearch.JdSearchDetail)localObject1).jd_sku_item.get();
      } else {
        paramJdSearchRsp = null;
      }
      if ((paramJdSearchRsp != null) && (!paramJdSearchRsp.isEmpty())) {
        localJDSearchResult.f = new ARMIGObjectClassifyResult.JDSearchItem[paramJdSearchRsp.size()];
      }
      if ((paramJdSearchRsp != null) && (paramJdSearchRsp.size() > 0))
      {
        k = 0;
        localObject1 = paramJdSearchRsp.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (JDSearch.JdSkuItem)((Iterator)localObject1).next();
          localJDSearchResult.f[k] = new ARMIGObjectClassifyResult.JDSearchItem();
          ARMIGObjectClassifyResult.JDSearchItem localJDSearchItem = localJDSearchResult.f[k];
          if (((JDSearch.JdSkuItem)localObject2).detail_url.has()) {
            paramJdSearchRsp = ((JDSearch.JdSkuItem)localObject2).detail_url.get();
          } else {
            paramJdSearchRsp = "";
          }
          localJDSearchItem.a = paramJdSearchRsp;
          localJDSearchItem = localJDSearchResult.f[k];
          if (((JDSearch.JdSkuItem)localObject2).image_url.has()) {
            paramJdSearchRsp = ((JDSearch.JdSkuItem)localObject2).image_url.get();
          } else {
            paramJdSearchRsp = "";
          }
          localJDSearchItem.b = paramJdSearchRsp;
          localJDSearchItem = localJDSearchResult.f[k];
          if (((JDSearch.JdSkuItem)localObject2).sku_id.has()) {
            paramJdSearchRsp = ((JDSearch.JdSkuItem)localObject2).sku_id.get();
          } else {
            paramJdSearchRsp = "";
          }
          localJDSearchItem.c = paramJdSearchRsp;
          localJDSearchItem = localJDSearchResult.f[k];
          if (((JDSearch.JdSkuItem)localObject2).sku_name.has()) {
            paramJdSearchRsp = ((JDSearch.JdSkuItem)localObject2).sku_name.get();
          } else {
            paramJdSearchRsp = "";
          }
          localJDSearchItem.d = paramJdSearchRsp;
          localJDSearchItem = localJDSearchResult.f[k];
          if (((JDSearch.JdSkuItem)localObject2).sku_price.has()) {
            paramJdSearchRsp = ((JDSearch.JdSkuItem)localObject2).sku_price.get();
          } else {
            paramJdSearchRsp = "";
          }
          localJDSearchItem.e = paramJdSearchRsp;
          k += 1;
        }
      }
    }
    return localJDSearchResult;
  }
  
  private ARMIGObjectClassifyResult.RetrievalItem i()
  {
    if (!e()) {
      return null;
    }
    Object localObject1 = null;
    int k = 0;
    ARMIGObjectClassifyResult.RetrievalClassInfo[] arrayOfRetrievalClassInfo;
    for (;;)
    {
      arrayOfRetrievalClassInfo = this.g;
      if (k >= arrayOfRetrievalClassInfo.length) {
        break;
      }
      int i1 = 0;
      while ((this.g[k].d != null) && (i1 < this.g[k].d.length))
      {
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          if (this.g[k].d[i1].c >= localObject1.c) {}
        }
        else
        {
          localObject2 = this.g[k].d[k];
        }
        i1 += 1;
        localObject1 = localObject2;
      }
      k += 1;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = localObject1;
      if (arrayOfRetrievalClassInfo.length == 1)
      {
        localObject2 = new ARMIGObjectClassifyResult.RetrievalItem();
        ((ARMIGObjectClassifyResult.RetrievalItem)localObject2).m = true;
        ((ARMIGObjectClassifyResult.RetrievalItem)localObject2).b = this.g[0].b;
        ((ARMIGObjectClassifyResult.RetrievalItem)localObject2).c = this.g[0].c;
        ((ARMIGObjectClassifyResult.RetrievalItem)localObject2).d = this.g[0].b;
        ((ARMIGObjectClassifyResult.RetrievalItem)localObject2).n = 0;
        ((ARMIGObjectClassifyResult.RetrievalItem)localObject2).o = "";
      }
    }
    return localObject2;
  }
  
  private ARMIGObjectClassifyResult.MIGObjectSearchResult j()
  {
    if (e())
    {
      ARMIGObjectClassifyResult.MIGObjectSearchResult localMIGObjectSearchResult = new ARMIGObjectClassifyResult.MIGObjectSearchResult();
      ARMIGObjectClassifyResult.RetrievalItem localRetrievalItem = i();
      if (localRetrievalItem == null) {
        return null;
      }
      ARMIGObjectClassifyResult.ObjectBox localObjectBox = this.j;
      if (localObjectBox != null) {
        localMIGObjectSearchResult.b = new RectF(localObjectBox.a, this.j.c, this.j.b, this.j.d);
      } else {
        localMIGObjectSearchResult.b = new RectF();
      }
      boolean bool1 = localRetrievalItem.m;
      boolean bool2 = false;
      if (bool1)
      {
        localMIGObjectSearchResult.c = localRetrievalItem.b;
        localMIGObjectSearchResult.a = false;
        localMIGObjectSearchResult.d = localRetrievalItem.c;
        return localMIGObjectSearchResult;
      }
      localMIGObjectSearchResult.c = localRetrievalItem.e.a;
      bool1 = bool2;
      if (localRetrievalItem.k != null)
      {
        bool1 = bool2;
        if (localRetrievalItem.k.length > 20) {
          bool1 = true;
        }
      }
      localMIGObjectSearchResult.a = bool1;
      localMIGObjectSearchResult.d = localRetrievalItem.c;
      localMIGObjectSearchResult.h = localRetrievalItem.k;
      localMIGObjectSearchResult.e = localRetrievalItem.h;
      localMIGObjectSearchResult.f = localRetrievalItem.i;
      localMIGObjectSearchResult.g = localRetrievalItem.j;
      localMIGObjectSearchResult.i = localRetrievalItem.l;
      return localMIGObjectSearchResult;
    }
    return null;
  }
  
  public boolean a()
  {
    return e();
  }
  
  public boolean a(ARMIGObjectClassifyResult paramARMIGObjectClassifyResult)
  {
    if (paramARMIGObjectClassifyResult == null) {
      return false;
    }
    paramARMIGObjectClassifyResult = paramARMIGObjectClassifyResult.i();
    ARMIGObjectClassifyResult.RetrievalItem localRetrievalItem = i();
    if (paramARMIGObjectClassifyResult != null)
    {
      if (localRetrievalItem == null) {
        return false;
      }
      if (paramARMIGObjectClassifyResult.b.equalsIgnoreCase(localRetrievalItem.b)) {
        return true;
      }
    }
    return false;
  }
  
  public int b()
  {
    if (!a()) {
      return -1;
    }
    if (e())
    {
      ARMIGObjectClassifyResult.RetrievalItem localRetrievalItem = i();
      if ((localRetrievalItem != null) && (localRetrievalItem.k != null) && (localRetrievalItem.k.length > 20)) {
        return 1;
      }
    }
    return 0;
  }
  
  public byte[] c()
  {
    ARMIGObjectClassifyResult.MIGObjectSearchResult localMIGObjectSearchResult = j();
    if ((localMIGObjectSearchResult != null) && (localMIGObjectSearchResult.a)) {
      return localMIGObjectSearchResult.h;
    }
    return null;
  }
  
  public boolean d()
  {
    if (this.b == 0)
    {
      ARMIGObjectClassifyResult.JDSearchResult localJDSearchResult = this.m;
      if ((localJDSearchResult != null) && (localJDSearchResult.a == 0) && (this.m.c == 0) && (this.m.f != null) && (this.m.f.length > 0)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean e()
  {
    if ((this.b == 0) && (this.e == 0))
    {
      ARMIGObjectClassifyResult.RetrievalClassInfo[] arrayOfRetrievalClassInfo = this.g;
      if ((arrayOfRetrievalClassInfo != null) && (arrayOfRetrievalClassInfo.length > 0) && (!arrayOfRetrievalClassInfo[0].b.equalsIgnoreCase(a))) {
        return true;
      }
    }
    return false;
  }
  
  public boolean f()
  {
    ARMIGObjectClassifyResult.RetrievalItem localRetrievalItem = i();
    boolean bool = false;
    if (localRetrievalItem == null) {
      return false;
    }
    if (localRetrievalItem.n == 1) {
      bool = true;
    }
    return bool;
  }
  
  public String g()
  {
    ARMIGObjectClassifyResult.RetrievalItem localRetrievalItem = i();
    if (localRetrievalItem == null) {
      return "";
    }
    return localRetrievalItem.o;
  }
  
  public ARMIGObjectClassifyResult.ARMigObjectClassifyExternalRenderResult h()
  {
    ARMIGObjectClassifyResult.ARMigObjectClassifyExternalRenderResult localARMigObjectClassifyExternalRenderResult = new ARMIGObjectClassifyResult.ARMigObjectClassifyExternalRenderResult();
    localARMigObjectClassifyExternalRenderResult.b = true;
    localARMigObjectClassifyExternalRenderResult.f = this.m;
    localARMigObjectClassifyExternalRenderResult.e = j();
    localARMigObjectClassifyExternalRenderResult.d = false;
    return localARMigObjectClassifyExternalRenderResult;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2;
    if (e())
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("\n {migObjectClassifyResult:");
      localStringBuilder2.append(this.g[0].toString());
      localStringBuilder2.append("} \n");
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    if (d())
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("\n {jdSearchResult:");
      localStringBuilder2.append(this.m.toString());
      localStringBuilder2.append("}\n");
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARMIGObjectClassifyResult
 * JD-Core Version:    0.7.0.1
 */