package com.tencent.luggage.wxa.dn;

import com.tencent.luggage.sdk.customize.impl.b;
import java.util.Locale;
import org.apache.commons.lang.StringUtils;

public class a
  extends b
{
  private String a(int paramInt)
  {
    String str = StringUtils.join(new String[] { Integer.toString(paramInt >> 24 & 0xF, 10), Integer.toString(paramInt >> 16 & 0xFF, 10), Integer.toString(paramInt >> 8 & 0xFF, 10), Integer.toString(paramInt & 0xFF, 10) }, ".");
    return String.format(Locale.ENGLISH, "%s(0x%s)", new Object[] { str, Integer.toHexString(paramInt) });
  }
  
  public String a()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" MicroMessenger/");
    ((StringBuilder)localObject).append(a(654316592));
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(" MiniProgramEnv/android");
    localStringBuilder.append(super.a());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dn.a
 * JD-Core Version:    0.7.0.1
 */