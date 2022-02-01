import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/onlinestatus/constellation/ConstellationTrend;", "", "constellationName", "", "trends", "", "(Ljava/lang/String;Ljava/util/List;)V", "getConstellationName", "()Ljava/lang/String;", "setConstellationName", "(Ljava/lang/String;)V", "getTrends", "()Ljava/util/List;", "setTrends", "(Ljava/util/List;)V", "chosenTrend", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "parse", "text", "toString", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class axyh
{
  @NotNull
  private String jdField_a_of_type_JavaLangString;
  @NotNull
  private List<String> jdField_a_of_type_JavaUtilList;
  
  public axyh()
  {
    this(null, null, 3, null);
  }
  
  public axyh(@NotNull String paramString, @NotNull List<String> paramList)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  @NotNull
  public final axyh a(@Nullable String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConstellationTrend", 2, new Object[] { "parse: called. ", "text: " + paramString });
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        Object localObject1 = paramString.optString("title");
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "optString(\"title\")");
        this.jdField_a_of_type_JavaLangString = ((String)localObject1);
        localObject1 = this.jdField_a_of_type_JavaUtilList;
        Object localObject2 = paramString.optString("lucky_color");
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "luckyColor");
        if (((CharSequence)localObject2).length() > 0)
        {
          i = 1;
          if (i != 0) {
            ((List)localObject1).add("今日幸运颜色为" + (String)localObject2);
          }
          localObject2 = paramString.optString("lucky_number");
          Intrinsics.checkExpressionValueIsNotNull(localObject2, "luckyNumber");
          if (((CharSequence)localObject2).length() <= 0) {
            break label500;
          }
          i = 1;
          if (i != 0) {
            ((List)localObject1).add("今日幸运数字为" + (String)localObject2);
          }
          localObject2 = paramString.optString("great_thing");
          Intrinsics.checkExpressionValueIsNotNull(localObject2, "greatThing");
          Object localObject3 = (CharSequence)localObject2;
          localObject3 = new Regex("[,，]").split((CharSequence)localObject3, 0);
          if (StringsKt.isBlank((CharSequence)localObject2)) {
            break label505;
          }
          i = 1;
          if (i != 0)
          {
            if (((Collection)localObject3).isEmpty()) {
              break label510;
            }
            i = 1;
            if (i != 0) {
              ((List)localObject1).add("今日宜" + (String)((List)localObject3).get(0));
            }
          }
          paramString = paramString.optString("speed_sign_name");
          Intrinsics.checkExpressionValueIsNotNull(paramString, "speedSign");
          if (((CharSequence)paramString).length() <= 0) {
            break label515;
          }
          i = 1;
          if (i != 0) {
            ((List)localObject1).add("速配星座：" + paramString);
          }
          localObject1 = (Iterable)this.jdField_a_of_type_JavaUtilList;
          paramString = (Collection)new ArrayList();
          localObject1 = ((Iterable)localObject1).iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = ((Iterator)localObject1).next();
          if (((CharSequence)localObject2).length() <= 0) {
            break label520;
          }
          i = 1;
          if (i == 0) {
            continue;
          }
          paramString.add(localObject2);
          continue;
        }
        i = 0;
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ConstellationTrend", 2, new Object[] { "parse: called. ", "constellationName: " + this.jdField_a_of_type_JavaLangString, paramString });
        }
        return this;
      }
      continue;
      label500:
      int i = 0;
      continue;
      label505:
      i = 0;
      continue;
      label510:
      i = 0;
      continue;
      label515:
      i = 0;
      continue;
      label520:
      i = 0;
    }
    paramString = (List)paramString;
    return this;
  }
  
  @NotNull
  public final String a()
  {
    if (!((Collection)this.jdField_a_of_type_JavaUtilList).isEmpty()) {}
    for (int i = 1; i != 0; i = 0) {
      return (String)CollectionsKt.random((Collection)this.jdField_a_of_type_JavaUtilList, (Random)Random.Default);
    }
    return "";
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof axyh))
      {
        paramObject = (axyh)paramObject;
        if ((!Intrinsics.areEqual(this.jdField_a_of_type_JavaLangString, paramObject.jdField_a_of_type_JavaLangString)) || (!Intrinsics.areEqual(this.jdField_a_of_type_JavaUtilList, paramObject.jdField_a_of_type_JavaUtilList))) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public int hashCode()
  {
    int j = 0;
    Object localObject = this.jdField_a_of_type_JavaLangString;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      localObject = this.jdField_a_of_type_JavaUtilList;
      if (localObject != null) {
        j = localObject.hashCode();
      }
      return i * 31 + j;
    }
  }
  
  @NotNull
  public String toString()
  {
    return "ConstellationTrend(constellationName=" + this.jdField_a_of_type_JavaLangString + ", trends=" + this.jdField_a_of_type_JavaUtilList + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axyh
 * JD-Core Version:    0.7.0.1
 */