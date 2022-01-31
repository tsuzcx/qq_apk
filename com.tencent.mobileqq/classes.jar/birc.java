import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class birc
{
  public static final birc a;
  private static final birc[] jdField_a_of_type_ArrayOfBirc = { b, c, e, r, q, s, g, i, k, l, m, n, o, u, t, w, x, v };
  public static final birc b;
  public static final birc c;
  public static final birc d;
  public static final birc e;
  public static final birc f;
  public static final birc g;
  public static final birc h;
  public static final birc i;
  public static final birc j;
  public static final birc k;
  public static final birc l;
  public static final birc m;
  public static final birc n;
  public static final birc o;
  public static final birc p;
  public static final birc q;
  public static final birc r;
  public static final birc s;
  public static final birc t;
  public static final birc u;
  public static final birc v;
  public static final birc w;
  public static final birc x;
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_Birc = new birc("", -1);
    b = new birc("h5", 0);
    c = new birc("mainCamera", 1);
    d = new birc("", 2);
    e = new birc("aioMainCamera", 3);
    f = new birc("", 4);
    g = new birc("qzoneCamera", 5);
    h = new birc("", 6);
    i = new birc("aioGifCamera", 7);
    j = new birc("", 8);
    k = new birc("aioGroupSignin", 9);
    l = new birc("qzoneSignin", 10);
    m = new birc("qzoneBanner", 11);
    n = new birc("qzoneTail", 12);
    o = new birc("qzoneMoodList", 13);
    p = new birc("", 14);
    q = new birc("qzoneFriendPlus", 15);
    r = new birc("qzoneFriendState", 16);
    s = new birc("qzoneSlideCamera", 17);
    t = new birc("aioChats", 18);
    u = new birc("massSendBless", 19);
    v = new birc("qzonePublishFrame", 20);
    w = new birc("qudongTakeFacePhoto", 1001, false);
    x = new birc("web", 1002, false);
  }
  
  private birc(String paramString, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = true;
  }
  
  private birc(String paramString, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public static int a(Intent paramIntent)
  {
    if (paramIntent == null) {
      return jdField_a_of_type_Birc.a();
    }
    return paramIntent.getIntExtra("VIDEO_STORY_FROM_TYPE", jdField_a_of_type_Birc.a());
  }
  
  public static int a(biim parambiim)
  {
    int i2 = 200;
    int i1 = i2;
    if (parambiim != null)
    {
      i1 = i2;
      if (parambiim.a() != null)
      {
        i1 = i2;
        if (parambiim.a().getIntent() != null) {
          i1 = parambiim.a().getIntent().getIntExtra("AECAMERA_MODE", 200);
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
  
  public static birc a(int paramInt)
  {
    birc[] arrayOfbirc = jdField_a_of_type_ArrayOfBirc;
    int i2 = arrayOfbirc.length;
    int i1 = 0;
    while (i1 < i2)
    {
      birc localbirc = arrayOfbirc[i1];
      if (paramInt == localbirc.a()) {
        return localbirc;
      }
      i1 += 1;
    }
    return jdField_a_of_type_Birc;
  }
  
  public static birc a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return jdField_a_of_type_Birc;
    }
    birc[] arrayOfbirc = jdField_a_of_type_ArrayOfBirc;
    int i2 = arrayOfbirc.length;
    int i1 = 0;
    if (i1 < i2)
    {
      birc localbirc = arrayOfbirc[i1];
      if (TextUtils.isEmpty(localbirc.a())) {}
      while (!paramString.equals(localbirc.a()))
      {
        i1 += 1;
        break;
      }
      return localbirc;
    }
    return jdField_a_of_type_Birc;
  }
  
  @NonNull
  public static String a(@Nullable String paramString)
  {
    HashMap localHashMap = new HashMap(3);
    localHashMap.put("camera", String.valueOf(bivx.jdField_a_of_type_Bivx.jdField_a_of_type_Int));
    localHashMap.put("play", String.valueOf(bivx.b.jdField_a_of_type_Int));
    localHashMap.put("gif", String.valueOf(bivx.c.jdField_a_of_type_Int));
    if ((paramString != null) && (localHashMap.containsKey(paramString)) && (localHashMap.get(paramString) != null)) {
      return (String)localHashMap.get(paramString);
    }
    return String.valueOf(bivx.jdField_a_of_type_Bivx.jdField_a_of_type_Int);
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
        int i1 = paramActivity.getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", jdField_a_of_type_Birc.a());
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
    return d(paramActivity.getIntExtra("VIDEO_STORY_FROM_TYPE", jdField_a_of_type_Birc.a()));
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
    for (int i1 = paramActivity.getIntExtra("ORIGIN_VIDEO_STORY_FROM_TYPE", jdField_a_of_type_Birc.a());; i1 = paramActivity.getIntExtra("VIDEO_STORY_FROM_TYPE", jdField_a_of_type_Birc.a())) {
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
      i1 = paramActivity.getIntExtra("ORIGIN_VIDEO_STORY_FROM_TYPE", jdField_a_of_type_Birc.a());
      if (n.a() != i1) {
        break label69;
      }
    }
    label69:
    for (boolean bool = true;; bool = false)
    {
      return bool;
      i1 = paramActivity.getIntExtra("VIDEO_STORY_FROM_TYPE", jdField_a_of_type_Birc.a());
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
      if (paramIntent.getIntExtra("VIDEO_STORY_FROM_TYPE", jdField_a_of_type_Birc.a()) == t.a()) {
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
 * Qualified Name:     birc
 * JD-Core Version:    0.7.0.1
 */