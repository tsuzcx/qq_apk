import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class birt
{
  public static final birt a;
  private static final birt[] jdField_a_of_type_ArrayOfBirt = { b, c, e, r, q, s, g, i, k, l, m, n, o, u, t, w, x, v };
  public static final birt b;
  public static final birt c;
  public static final birt d;
  public static final birt e;
  public static final birt f;
  public static final birt g;
  public static final birt h;
  public static final birt i;
  public static final birt j;
  public static final birt k;
  public static final birt l;
  public static final birt m;
  public static final birt n;
  public static final birt o;
  public static final birt p;
  public static final birt q;
  public static final birt r;
  public static final birt s;
  public static final birt t;
  public static final birt u;
  public static final birt v;
  public static final birt w;
  public static final birt x;
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_Birt = new birt("", -1);
    b = new birt("h5", 0);
    c = new birt("mainCamera", 1);
    d = new birt("", 2);
    e = new birt("aioMainCamera", 3);
    f = new birt("", 4);
    g = new birt("qzoneCamera", 5);
    h = new birt("", 6);
    i = new birt("aioGifCamera", 7);
    j = new birt("", 8);
    k = new birt("aioGroupSignin", 9);
    l = new birt("qzoneSignin", 10);
    m = new birt("qzoneBanner", 11);
    n = new birt("qzoneTail", 12);
    o = new birt("qzoneMoodList", 13);
    p = new birt("", 14);
    q = new birt("qzoneFriendPlus", 15);
    r = new birt("qzoneFriendState", 16);
    s = new birt("qzoneSlideCamera", 17);
    t = new birt("aioChats", 18);
    u = new birt("massSendBless", 19);
    v = new birt("qzonePublishFrame", 20);
    w = new birt("qudongTakeFacePhoto", 1001, false);
    x = new birt("web", 1002, false);
  }
  
  private birt(String paramString, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = true;
  }
  
  private birt(String paramString, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public static int a(Intent paramIntent)
  {
    if (paramIntent == null) {
      return jdField_a_of_type_Birt.a();
    }
    return paramIntent.getIntExtra("VIDEO_STORY_FROM_TYPE", jdField_a_of_type_Birt.a());
  }
  
  public static int a(bijd parambijd)
  {
    int i2 = 200;
    int i1 = i2;
    if (parambijd != null)
    {
      i1 = i2;
      if (parambijd.a() != null)
      {
        i1 = i2;
        if (parambijd.a().getIntent() != null) {
          i1 = parambijd.a().getIntent().getIntExtra("AECAMERA_MODE", 200);
        }
      }
    }
    return i1;
  }
  
  public static int a(String paramString)
  {
    int i2 = 200;
    HashMap localHashMap = new HashMap(4);
    localHashMap.put("camera", Integer.valueOf(200));
    localHashMap.put("all", Integer.valueOf(201));
    localHashMap.put("gif", Integer.valueOf(202));
    localHashMap.put("singlegif", Integer.valueOf(203));
    localHashMap.put("cameraAndPlay", Integer.valueOf(204));
    localHashMap.put("cameraAndGif", Integer.valueOf(205));
    localHashMap.put("play", Integer.valueOf(206));
    localHashMap.put("playAndGif", Integer.valueOf(207));
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
  
  public static birt a(int paramInt)
  {
    birt[] arrayOfbirt = jdField_a_of_type_ArrayOfBirt;
    int i2 = arrayOfbirt.length;
    int i1 = 0;
    while (i1 < i2)
    {
      birt localbirt = arrayOfbirt[i1];
      if (paramInt == localbirt.a()) {
        return localbirt;
      }
      i1 += 1;
    }
    return jdField_a_of_type_Birt;
  }
  
  public static birt a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return jdField_a_of_type_Birt;
    }
    birt[] arrayOfbirt = jdField_a_of_type_ArrayOfBirt;
    int i2 = arrayOfbirt.length;
    int i1 = 0;
    if (i1 < i2)
    {
      birt localbirt = arrayOfbirt[i1];
      if (TextUtils.isEmpty(localbirt.a())) {}
      while (!paramString.equals(localbirt.a()))
      {
        i1 += 1;
        break;
      }
      return localbirt;
    }
    return jdField_a_of_type_Birt;
  }
  
  @NonNull
  public static String a(@Nullable String paramString)
  {
    HashMap localHashMap = new HashMap(3);
    localHashMap.put("camera", String.valueOf(biwo.jdField_a_of_type_Biwo.jdField_a_of_type_Int));
    localHashMap.put("play", String.valueOf(biwo.b.jdField_a_of_type_Int));
    localHashMap.put("gif", String.valueOf(biwo.c.jdField_a_of_type_Int));
    if ((paramString != null) && (localHashMap.containsKey(paramString)) && (localHashMap.get(paramString) != null)) {
      return (String)localHashMap.get(paramString);
    }
    return String.valueOf(biwo.jdField_a_of_type_Biwo.jdField_a_of_type_Int);
  }
  
  public static boolean a(Activity paramActivity)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramActivity != null)
    {
      bool1 = bool2;
      if (paramActivity.getIntent() != null)
      {
        int i1 = paramActivity.getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", jdField_a_of_type_Birt.a());
        if (i1 != x.a())
        {
          bool1 = bool2;
          if (i1 != w.a()) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean a(Intent paramIntent)
  {
    boolean bool = false;
    if ((paramIntent == null) || (paramIntent.getIntExtra("VIDEO_STORY_JUMP_TO_TYPE", 0) == 0)) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean a(Intent paramIntent, int paramInt)
  {
    return (paramInt == 14) && (!a(paramIntent)) && (!b(paramIntent));
  }
  
  public static int b(Intent paramIntent)
  {
    if (paramIntent == null) {
      return 0;
    }
    return paramIntent.getIntExtra("VIDEO_STORY_JUMP_TO_TYPE", 0);
  }
  
  public static boolean b(int paramInt)
  {
    return paramInt == t.a();
  }
  
  public static boolean b(Activity paramActivity)
  {
    if (paramActivity == null) {}
    do
    {
      return false;
      paramActivity = paramActivity.getIntent();
    } while (paramActivity == null);
    return d(paramActivity.getIntExtra("VIDEO_STORY_FROM_TYPE", jdField_a_of_type_Birt.a()));
  }
  
  public static boolean b(Intent paramIntent)
  {
    return (paramIntent == null) || (paramIntent.getIntExtra("VIDEO_STORY_MEDIA_TYPE", 100) == 100);
  }
  
  public static int c(Intent paramIntent)
  {
    if (paramIntent == null) {
      return 100;
    }
    return paramIntent.getIntExtra("VIDEO_STORY_MEDIA_TYPE", 100);
  }
  
  public static boolean c(int paramInt)
  {
    return n.a() == paramInt;
  }
  
  public static boolean c(Activity paramActivity)
  {
    if (paramActivity == null) {}
    do
    {
      return false;
      paramActivity = paramActivity.getIntent();
    } while (paramActivity == null);
    if (paramActivity.hasExtra("ORIGIN_VIDEO_STORY_FROM_TYPE")) {}
    for (int i1 = paramActivity.getIntExtra("ORIGIN_VIDEO_STORY_FROM_TYPE", jdField_a_of_type_Birt.a());; i1 = paramActivity.getIntExtra("VIDEO_STORY_FROM_TYPE", jdField_a_of_type_Birt.a())) {
      return f(i1);
    }
  }
  
  public static boolean c(Intent paramIntent)
  {
    return (k(paramIntent)) || (l(paramIntent)) || (m(paramIntent));
  }
  
  public static boolean d(int paramInt)
  {
    return (paramInt == g.a()) || (paramInt == o.a()) || (paramInt == r.a()) || (paramInt == v.a());
  }
  
  public static boolean d(Activity paramActivity)
  {
    if (paramActivity == null) {}
    do
    {
      return false;
      paramActivity = paramActivity.getIntent();
    } while (paramActivity == null);
    int i1;
    if (paramActivity.hasExtra("ORIGIN_VIDEO_STORY_FROM_TYPE"))
    {
      i1 = paramActivity.getIntExtra("ORIGIN_VIDEO_STORY_FROM_TYPE", jdField_a_of_type_Birt.a());
      if (n.a() != i1) {
        break label69;
      }
    }
    label69:
    for (boolean bool = true;; bool = false)
    {
      return bool;
      i1 = paramActivity.getIntExtra("VIDEO_STORY_FROM_TYPE", jdField_a_of_type_Birt.a());
      break;
    }
  }
  
  public static boolean d(Intent paramIntent)
  {
    return (paramIntent != null) && (a(paramIntent) == n.a());
  }
  
  public static boolean e(int paramInt)
  {
    return paramInt == c.a();
  }
  
  public static boolean e(Intent paramIntent)
  {
    int i1 = a(paramIntent);
    return (i1 == k.a()) || (i1 == l.a());
  }
  
  public static boolean f(int paramInt)
  {
    return (paramInt == g.a()) || (paramInt == o.a()) || (paramInt == r.a()) || (paramInt == v.a());
  }
  
  public static boolean f(Intent paramIntent)
  {
    return (paramIntent != null) && (a(paramIntent) == e.a());
  }
  
  public static boolean g(int paramInt)
  {
    return e.a() == paramInt;
  }
  
  public static boolean g(Intent paramIntent)
  {
    return (paramIntent != null) && (a(paramIntent) == w.a());
  }
  
  public static boolean h(Intent paramIntent)
  {
    return (paramIntent != null) && (a(paramIntent) == x.a());
  }
  
  private static boolean i(Intent paramIntent)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramIntent != null)
    {
      bool1 = bool2;
      if (paramIntent.getIntExtra("VIDEO_STORY_FROM_TYPE", jdField_a_of_type_Birt.a()) == t.a()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private static boolean j(Intent paramIntent)
  {
    return (paramIntent != null) && (paramIntent.getIntExtra("VIDEO_STORY_MEDIA_TYPE", 100) == 101);
  }
  
  private static boolean k(Intent paramIntent)
  {
    return (d(paramIntent)) && (j(paramIntent));
  }
  
  private static boolean l(Intent paramIntent)
  {
    return (i(paramIntent)) && (j(paramIntent));
  }
  
  private static boolean m(Intent paramIntent)
  {
    return (e(paramIntent)) && (j(paramIntent));
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(int paramInt)
  {
    return this.jdField_a_of_type_Int == paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     birt
 * JD-Core Version:    0.7.0.1
 */