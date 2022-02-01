package com.tencent.luggage.wxa.qm;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.t.b;
import com.tencent.luggage.wxa.x.e;
import com.tencent.luggage.wxa.x.f;
import com.tencent.luggage.wxa.x.h;
import com.tencent.luggage.wxa.x.i;
import com.tencent.luggage.wxa.x.j;
import com.tencent.luggage.wxa.x.k;
import java.text.NumberFormat;
import java.util.Locale;

public class a
{
  private static final NumberFormat a = NumberFormat.getInstance(Locale.US);
  
  static
  {
    a.setMinimumFractionDigits(2);
    a.setMaximumFractionDigits(2);
    a.setGroupingUsed(false);
  }
  
  public static String a(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4) {
            return "?";
          }
          return "E";
        }
        return "R";
      }
      return "B";
    }
    return "I";
  }
  
  public static String a(long paramLong)
  {
    if (paramLong == -9223372036854775807L) {
      return "?";
    }
    return a.format((float)paramLong / 1000.0F);
  }
  
  public static void a()
  {
    b.a = false;
    b.a(new a.1());
  }
  
  public static void a(com.tencent.luggage.wxa.v.a parama, String paramString)
  {
    int i = 0;
    while (i < parama.a())
    {
      Object localObject = parama.a(i);
      StringBuilder localStringBuilder;
      if ((localObject instanceof j))
      {
        localObject = (j)localObject;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append(String.format("%s: value=%s", new Object[] { ((j)localObject).f, ((j)localObject).b }));
        o.e("MicroMsg.ExoPlayer", localStringBuilder.toString());
      }
      else if ((localObject instanceof k))
      {
        localObject = (k)localObject;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append(String.format("%s: url=%s", new Object[] { ((k)localObject).f, ((k)localObject).b }));
        o.e("MicroMsg.ExoPlayer", localStringBuilder.toString());
      }
      else if ((localObject instanceof i))
      {
        localObject = (i)localObject;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append(String.format("%s: owner=%s", new Object[] { ((i)localObject).f, ((i)localObject).a }));
        o.e("MicroMsg.ExoPlayer", localStringBuilder.toString());
      }
      else if ((localObject instanceof f))
      {
        localObject = (f)localObject;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append(String.format("%s: mimeType=%s, filename=%s, description=%s", new Object[] { ((f)localObject).f, ((f)localObject).a, ((f)localObject).b, ((f)localObject).c }));
        o.e("MicroMsg.ExoPlayer", localStringBuilder.toString());
      }
      else if ((localObject instanceof com.tencent.luggage.wxa.x.a))
      {
        localObject = (com.tencent.luggage.wxa.x.a)localObject;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append(String.format("%s: mimeType=%s, description=%s", new Object[] { ((com.tencent.luggage.wxa.x.a)localObject).f, ((com.tencent.luggage.wxa.x.a)localObject).a, ((com.tencent.luggage.wxa.x.a)localObject).b }));
        o.e("MicroMsg.ExoPlayer", localStringBuilder.toString());
      }
      else if ((localObject instanceof e))
      {
        localObject = (e)localObject;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append(String.format("%s: language=%s, description=%s", new Object[] { ((e)localObject).f, ((e)localObject).a, ((e)localObject).b }));
        o.e("MicroMsg.ExoPlayer", localStringBuilder.toString());
      }
      else if ((localObject instanceof h))
      {
        localObject = (h)localObject;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append(String.format("%s", new Object[] { ((h)localObject).f }));
        o.e("MicroMsg.ExoPlayer", localStringBuilder.toString());
      }
      else if ((localObject instanceof com.tencent.luggage.wxa.w.a))
      {
        localObject = (com.tencent.luggage.wxa.w.a)localObject;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append(String.format("EMSG: scheme=%s, id=%d, value=%s", new Object[] { ((com.tencent.luggage.wxa.w.a)localObject).a, Long.valueOf(((com.tencent.luggage.wxa.w.a)localObject).d), ((com.tencent.luggage.wxa.w.a)localObject).b }));
        o.e("MicroMsg.ExoPlayer", localStringBuilder.toString());
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qm.a
 * JD-Core Version:    0.7.0.1
 */