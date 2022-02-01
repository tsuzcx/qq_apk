package com.tencent.luggage.wxa.ot;

import com.tencent.luggage.wxa.qz.o;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/profile/IDKeyReporter;", "Lcom/tencent/mm/plugin/appbrand/profile/IIDKeyProfiler;", "()V", "TAG", "", "idkeyGroupForPair", "", "id1", "", "id2", "key1", "key2", "value1", "value2", "important", "", "idkeyGroupForPairAverger", "id", "value", "idkeyGroupForPairAvergerForSegment", "idkeyGroupStat", "lstIdKeyDataInfos", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/profile/IDKey;", "isImportant", "idkeyStat", "ID", "", "key", "val", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class b
  implements c
{
  public static final b a = new b();
  
  public void a(long paramLong1, long paramLong2, long paramLong3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("idkeyStat ID:");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append(" key:");
    localStringBuilder.append(paramLong2);
    localStringBuilder.append(", val:");
    localStringBuilder.append(paramLong3);
    o.e("Luggage.IDKeyReporter", localStringBuilder.toString());
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("idkeyStat ID:");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append(" key:");
    localStringBuilder.append(paramLong2);
    localStringBuilder.append(" val:");
    localStringBuilder.append(paramLong3);
    localStringBuilder.append(" important:");
    localStringBuilder.append(paramBoolean);
    o.e("Luggage.IDKeyReporter", localStringBuilder.toString());
  }
  
  public void a(@Nullable ArrayList<a> paramArrayList, boolean paramBoolean)
  {
    if (paramArrayList != null)
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      paramArrayList = ((Iterable)paramArrayList).iterator();
      while (paramArrayList.hasNext())
      {
        a locala = (a)paramArrayList.next();
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append('(');
        localStringBuilder2.append(locala.a());
        localStringBuilder2.append(',');
        localStringBuilder2.append(locala.b());
        localStringBuilder2.append(',');
        localStringBuilder2.append(locala.c());
        localStringBuilder2.append(')');
        localStringBuilder1.append(localStringBuilder2.toString());
        localStringBuilder1.append(",");
      }
      paramArrayList = new StringBuilder();
      paramArrayList.append("idkeyGroupStat ");
      paramArrayList.append(localStringBuilder1);
      paramArrayList.append(" important:");
      paramArrayList.append(paramBoolean);
      o.e("Luggage.IDKeyReporter", paramArrayList.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ot.b
 * JD-Core Version:    0.7.0.1
 */