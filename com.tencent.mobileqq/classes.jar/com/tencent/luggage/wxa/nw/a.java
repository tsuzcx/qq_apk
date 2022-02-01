package com.tencent.luggage.wxa.nw;

import com.tencent.luggage.util.c;
import com.tencent.luggage.wxa.do.d;
import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;
import kotlin.contracts.ExperimentalContracts;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/menu/config/ActionSheetControlIndex;", "", "index", "", "(Ljava/lang/String;II)V", "getIndex", "()I", "setIndex", "(I)V", "getControlByte", "config", "Lcom/tencent/luggage/sdk/config/AppBrandSysConfigLU;", "ShareToWeWork", "ShareToFriend", "CopyShortLink", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public enum a
{
  private int e;
  
  static
  {
    a locala1 = new a("ShareToWeWork", 0, 0);
    a = locala1;
    a locala2 = new a("ShareToFriend", 1, 1);
    b = locala2;
    a locala3 = new a("CopyShortLink", 2, 2);
    c = locala3;
    d = new a[] { locala1, locala2, locala3 };
  }
  
  private a(int paramInt)
  {
    this.e = paramInt;
  }
  
  @ExperimentalContracts
  public final int a(@NotNull d paramd)
  {
    Intrinsics.checkParameterIsNotNull(paramd, "config");
    paramd = paramd.H;
    boolean bool = c.a(paramd);
    int j = 0;
    int i = j;
    if (!bool)
    {
      i = paramd.length;
      int k = this.e;
      if (i - 1 < k)
      {
        i = j;
      }
      else
      {
        k = paramd[k];
        if (k < 0)
        {
          i = j;
        }
        else
        {
          i = j;
          if (2 >= k) {
            i = k;
          }
        }
      }
    }
    paramd = new StringBuilder();
    paramd.append("getControlByte for ");
    paramd.append(name());
    paramd.append(" [");
    paramd.append(i);
    paramd.append(']');
    o.d("MicroMsg.ActionSheetControlIndex", paramd.toString());
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nw.a
 * JD-Core Version:    0.7.0.1
 */