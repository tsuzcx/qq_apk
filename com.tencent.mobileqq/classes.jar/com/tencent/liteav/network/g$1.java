package com.tencent.liteav.network;

import com.tencent.liteav.basic.log.TXCLog;
import java.util.Iterator;
import java.util.Vector;
import java.util.Vector<Lcom.tencent.liteav.network.e;>;

class g$1
  implements g.a
{
  g$1(g paramg, String paramString1, String paramString2, String paramString3, String paramString4, g.a parama) {}
  
  public void a(int paramInt, String paramString, Vector<e> paramVector)
  {
    g.a(this.f, this.a);
    g.b(this.f, this.b);
    g.a(this.f, paramInt);
    g.c(this.f, paramString);
    if ((paramVector != null) && (!paramVector.isEmpty()))
    {
      Vector localVector = new Vector();
      Object localObject2 = paramVector.iterator();
      Object localObject1;
      while (((Iterator)localObject2).hasNext())
      {
        e locale = (e)((Iterator)localObject2).next();
        localObject1 = locale.a;
        paramVector = (Vector<e>)localObject1;
        if (((String)localObject1).indexOf("?") != -1) {
          paramVector = ((String)localObject1).substring(0, ((String)localObject1).indexOf("?"));
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramVector);
        ((StringBuilder)localObject1).append("?txSecret=");
        ((StringBuilder)localObject1).append(this.c);
        ((StringBuilder)localObject1).append("&txTime=");
        ((StringBuilder)localObject1).append(this.d);
        ((StringBuilder)localObject1).append("&bizid=");
        ((StringBuilder)localObject1).append(this.b);
        localVector.add(new e(((StringBuilder)localObject1).toString(), locale.b));
      }
      if (this.e != null)
      {
        paramVector = localVector.iterator();
        while (paramVector.hasNext())
        {
          localObject1 = (e)paramVector.next();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("accurl = ");
          ((StringBuilder)localObject2).append(((e)localObject1).a);
          ((StringBuilder)localObject2).append(" quic = ");
          ((StringBuilder)localObject2).append(((e)localObject1).b);
          TXCLog.e("TXRTMPAccUrlFetcher", ((StringBuilder)localObject2).toString());
        }
        this.e.a(paramInt, paramString, localVector);
      }
    }
    else
    {
      paramVector = this.e;
      if (paramVector != null) {
        paramVector.a(paramInt, paramString, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.network.g.1
 * JD-Core Version:    0.7.0.1
 */