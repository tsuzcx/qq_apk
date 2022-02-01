import android.support.v4.util.ArrayMap;
import android.support.v4.util.SparseArrayCompat;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;
import com.tencent.util.Pair;

public class beli
{
  int jdField_a_of_type_Int;
  ArrayMap<String, Integer> jdField_a_of_type_AndroidSupportV4UtilArrayMap = new ArrayMap();
  SparseArrayCompat<Pair<String, String>> jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat = new SparseArrayCompat();
  
  public static beli a(String paramString)
  {
    GsonBuilder localGsonBuilder = new GsonBuilder();
    localGsonBuilder.registerTypeAdapter(beli.class, a());
    return (beli)localGsonBuilder.create().fromJson(paramString, beli.class);
  }
  
  public static JsonDeserializer<beli> a()
  {
    return new belk();
  }
  
  public static JsonSerializer<beli> a()
  {
    return new belj();
  }
  
  private static String b(String paramString1, String paramString2)
  {
    return paramString1 + "," + paramString2;
  }
  
  public int a(Pair<String, String> paramPair)
  {
    return a((String)paramPair.first, (String)paramPair.second, false);
  }
  
  public int a(Pair<String, String> paramPair, boolean paramBoolean)
  {
    return a((String)paramPair.first, (String)paramPair.second, paramBoolean);
  }
  
  public int a(String paramString1, String paramString2, boolean paramBoolean)
  {
    String str = b(paramString1, paramString2);
    if (this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.containsKey(str)) {
      return ((Integer)this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.get(str)).intValue();
    }
    if (paramBoolean) {
      return -1;
    }
    int i = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = (i + 1);
    this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(str, Integer.valueOf(i));
    SparseArrayCompat localSparseArrayCompat = this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat;
    str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    localSparseArrayCompat.put(i, new Pair(str, paramString1));
    return i;
  }
  
  public Pair<String, String> a(int paramInt)
  {
    if (paramInt >= this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.size()) {
      return null;
    }
    Pair localPair = (Pair)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(paramInt);
    return new Pair(localPair.first, localPair.second);
  }
  
  public String a()
  {
    GsonBuilder localGsonBuilder = new GsonBuilder();
    localGsonBuilder.registerTypeAdapter(beli.class, a());
    return localGsonBuilder.create().toJson(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beli
 * JD-Core Version:    0.7.0.1
 */