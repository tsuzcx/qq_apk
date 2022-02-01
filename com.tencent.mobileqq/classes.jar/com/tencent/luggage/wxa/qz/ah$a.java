package com.tencent.luggage.wxa.qz;

import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

class ah$a
{
  private XmlPullParser a;
  private String b;
  private StringBuilder c = new StringBuilder();
  private Map<String, String> d;
  private Map<Integer, Integer> e;
  
  public ah$a(String paramString1, String paramString2, String paramString3)
  {
    this.b = paramString2;
    paramString2 = (XmlPullParser)ah.a().get();
    this.a = paramString2;
    if (paramString2 == null)
    {
      paramString2 = ah.a();
      paramString3 = XmlPullParserFactory.newInstance().newPullParser();
      this.a = paramString3;
      paramString2.set(paramString3);
    }
    this.a.setInput(new StringReader(paramString1));
    this.e = new HashMap();
    this.d = new HashMap();
  }
  
  private void b()
  {
    Object localObject1 = this.c;
    ((StringBuilder)localObject1).append('.');
    ((StringBuilder)localObject1).append(this.a.getName());
    localObject1 = this.c.toString();
    int j = ((String)localObject1).hashCode();
    Object localObject2 = (Integer)this.e.get(Integer.valueOf(j));
    int i = 0;
    StringBuilder localStringBuilder;
    if (localObject2 != null)
    {
      localObject2 = Integer.valueOf(((Integer)localObject2).intValue() + 1);
      this.c.append(localObject2);
      this.e.put(Integer.valueOf(j), localObject2);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(localObject2);
      localObject1 = localStringBuilder.toString();
    }
    else
    {
      this.e.put(Integer.valueOf(j), Integer.valueOf(0));
    }
    this.d.put(localObject1, "");
    while (i < this.a.getAttributeCount())
    {
      localObject2 = this.d;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(".$");
      localStringBuilder.append(this.a.getAttributeName(i));
      ((Map)localObject2).put(localStringBuilder.toString(), this.a.getAttributeValue(i));
      i += 1;
    }
  }
  
  private void c()
  {
    String str = this.a.getText();
    if (str != null) {
      this.d.put(this.c.toString(), str);
    }
  }
  
  private void d()
  {
    StringBuilder localStringBuilder = this.c;
    this.c = localStringBuilder.delete(localStringBuilder.lastIndexOf("."), this.c.length());
  }
  
  public Map<String, String> a()
  {
    int i = this.a.getEventType();
    do
    {
      int j;
      do
      {
        for (;;)
        {
          if (i == 1) {
            break label76;
          }
          j = this.a.next();
          if (j == 2)
          {
            b();
            i = j;
          }
          else
          {
            if (j != 4) {
              break;
            }
            c();
            i = j;
          }
        }
        i = j;
      } while (j != 3);
      d();
      i = j;
    } while (this.c.length() != 0);
    label76:
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qz.ah.a
 * JD-Core Version:    0.7.0.1
 */