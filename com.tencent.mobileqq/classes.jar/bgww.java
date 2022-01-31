import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class bgww
{
  public static final bgww a;
  private static final bgww[] jdField_a_of_type_ArrayOfBgww = { b, d, q, p, r, f, h, j, k, l, m, n, s, t, v, w, u };
  public static final bgww b;
  public static final bgww c;
  public static final bgww d;
  public static final bgww e;
  public static final bgww f;
  public static final bgww g;
  public static final bgww h;
  public static final bgww i;
  public static final bgww j;
  public static final bgww k;
  public static final bgww l;
  public static final bgww m;
  public static final bgww n;
  public static final bgww o;
  public static final bgww p;
  public static final bgww q;
  public static final bgww r;
  public static final bgww s;
  public static final bgww t;
  public static final bgww u;
  public static final bgww v;
  public static final bgww w;
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  
  static
  {
    jdField_a_of_type_Bgww = new bgww("", -1);
    b = new bgww("mainCamera", 1);
    c = new bgww("", 2);
    d = new bgww("aioMainCamera", 3);
    e = new bgww("", 4);
    f = new bgww("qzoneCamera", 5);
    g = new bgww("", 6);
    h = new bgww("aioGifCamera", 7);
    i = new bgww("", 8);
    j = new bgww("aioGroupSignin", 9);
    k = new bgww("qzoneSignin", 10);
    l = new bgww("qzoneBanner", 11);
    m = new bgww("qzoneTail", 12);
    n = new bgww("qzoneMoodList", 13);
    o = new bgww("", 14);
    p = new bgww("qzoneFriendPlus", 15);
    q = new bgww("qzoneFriendState", 16);
    r = new bgww("qzoneSlideCamera", 17);
    s = new bgww("massSendBless", 18);
    t = new bgww("aioChats", 19);
    u = new bgww("qzonePublishFrame", 20);
    v = new bgww("qudongTakeFacePhoto", 21);
    w = new bgww("webCosMe", 22);
  }
  
  private bgww(String paramString, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public static int a(String paramString)
  {
    int i2 = 201;
    HashMap localHashMap = new HashMap(4);
    localHashMap.put("camera", Integer.valueOf(200));
    localHashMap.put("all", Integer.valueOf(201));
    localHashMap.put("gif", Integer.valueOf(202));
    localHashMap.put("singlegif", Integer.valueOf(203));
    int i1 = i2;
    if (paramString != null)
    {
      i1 = i2;
      if (localHashMap.containsKey(paramString))
      {
        i1 = i2;
        if (localHashMap.get(paramString) != null) {
          i1 = ((Integer)localHashMap.get(paramString)).intValue();
        }
      }
    }
    return i1;
  }
  
  public static bgww a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return jdField_a_of_type_Bgww;
    }
    bgww[] arrayOfbgww = jdField_a_of_type_ArrayOfBgww;
    int i2 = arrayOfbgww.length;
    int i1 = 0;
    if (i1 < i2)
    {
      bgww localbgww = arrayOfbgww[i1];
      if (TextUtils.isEmpty(localbgww.a())) {}
      while (!paramString.equals(localbgww.a()))
      {
        i1 += 1;
        break;
      }
      return localbgww;
    }
    return jdField_a_of_type_Bgww;
  }
  
  @NonNull
  public static String a(@Nullable String paramString)
  {
    HashMap localHashMap = new HashMap(3);
    localHashMap.put("camera", String.valueOf(wsh.jdField_a_of_type_Wsh.jdField_a_of_type_Int));
    localHashMap.put("play", String.valueOf(wsh.b.jdField_a_of_type_Int));
    localHashMap.put("gif", String.valueOf(wsh.c.jdField_a_of_type_Int));
    if ((paramString != null) && (localHashMap.containsKey(paramString)) && (localHashMap.get(paramString) != null)) {
      return (String)localHashMap.get(paramString);
    }
    return String.valueOf(wsh.jdField_a_of_type_Wsh.jdField_a_of_type_Int);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public boolean a(int paramInt)
  {
    return this.jdField_a_of_type_Int == paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bgww
 * JD-Core Version:    0.7.0.1
 */