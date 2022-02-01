import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import dov.com.qq.im.ae.mode.AECaptureMode;
import java.util.HashMap;
import java.util.Map;

public class born
{
  public static final born A = new born("circleGuidePicker", 28);
  public static final born B = new born("qudongTakeFacePhoto", 1001, false);
  public static final born C = new born("web", 1002, false);
  public static final born a;
  private static final born[] jdField_a_of_type_ArrayOfBorn = { b, c, e, r, q, s, g, i, k, l, m, n, o, u, t, w, B, C, v, x, z };
  public static final born b;
  public static final born c;
  public static final born d;
  public static final born e;
  public static final born f;
  public static final born g;
  public static final born h;
  public static final born i;
  public static final born j;
  public static final born k;
  public static final born l;
  public static final born m;
  public static final born n;
  public static final born o;
  public static final born p;
  public static final born q;
  public static final born r;
  public static final born s;
  public static final born t;
  public static final born u;
  public static final born v;
  public static final born w;
  public static final born x;
  public static final born y;
  public static final born z;
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_Born = new born("", -1);
    b = new born("h5", 0);
    c = new born("mainCamera", 1);
    d = new born("", 2);
    e = new born("aioMainCamera", 3);
    f = new born("", 4);
    g = new born("qzoneCamera", 5);
    h = new born("", 6);
    i = new born("aioGifCamera", 7);
    j = new born("", 8);
    k = new born("aioGroupSignin", 9);
    l = new born("qzoneSignin", 10);
    m = new born("qzoneBanner", 11);
    n = new born("qzoneTail", 12);
    o = new born("qzoneMoodList", 13);
    p = new born("", 14);
    q = new born("qzoneFriendPlus", 15);
    r = new born("qzoneFriendState", 16);
    s = new born("qzoneSlideCamera", 17);
    t = new born("aioChats", 18);
    u = new born("massSendBless", 19);
    v = new born("qzonePublishFrame", 20);
    w = new born("aioGifCameraTail", 23);
    x = new born("circleCamera", 25);
    y = new born("circlePickCamera", 26);
    z = new born("circleGuideCamera", 27);
  }
  
  private born(String paramString, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = true;
  }
  
  private born(String paramString, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public static int a(Intent paramIntent)
  {
    if (paramIntent == null) {
      return jdField_a_of_type_Born.a();
    }
    return paramIntent.getIntExtra("VIDEO_STORY_FROM_TYPE", jdField_a_of_type_Born.a());
  }
  
  public static int a(bofh parambofh)
  {
    int i2 = 200;
    int i1 = i2;
    if (parambofh != null)
    {
      i1 = i2;
      if (parambofh.a() != null)
      {
        i1 = i2;
        if (parambofh.a().getIntent() != null) {
          i1 = parambofh.a().getIntent().getIntExtra("AECAMERA_MODE", 200);
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
  
  public static born a(int paramInt)
  {
    born[] arrayOfborn = jdField_a_of_type_ArrayOfBorn;
    int i2 = arrayOfborn.length;
    int i1 = 0;
    while (i1 < i2)
    {
      born localborn = arrayOfborn[i1];
      if (paramInt == localborn.a()) {
        return localborn;
      }
      i1 += 1;
    }
    return jdField_a_of_type_Born;
  }
  
  public static born a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return jdField_a_of_type_Born;
    }
    born[] arrayOfborn = jdField_a_of_type_ArrayOfBorn;
    int i2 = arrayOfborn.length;
    int i1 = 0;
    if (i1 < i2)
    {
      born localborn = arrayOfborn[i1];
      if (TextUtils.isEmpty(localborn.a())) {}
      while (!paramString.equals(localborn.a()))
      {
        i1 += 1;
        break;
      }
      return localborn;
    }
    return jdField_a_of_type_Born;
  }
  
  @NonNull
  public static String a(@Nullable String paramString)
  {
    if ("camera".equals(paramString)) {
      return String.valueOf(AECaptureMode.NORMAL.name);
    }
    if ("play".equals(paramString)) {
      return String.valueOf(AECaptureMode.PLAY.name);
    }
    if ("gif".equals(paramString)) {
      return String.valueOf(AECaptureMode.GIF.name);
    }
    return String.valueOf(AECaptureMode.NORMAL.name);
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
        int i1 = paramActivity.getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", jdField_a_of_type_Born.a());
        if (i1 != C.a())
        {
          bool1 = bool2;
          if (i1 != B.a()) {}
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
  
  public static boolean a(bofh parambofh)
  {
    if ((parambofh != null) && (parambofh.a() != null)) {
      return j(parambofh.a().getIntent());
    }
    return false;
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
    return d(paramActivity.getIntExtra("VIDEO_STORY_FROM_TYPE", jdField_a_of_type_Born.a()));
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
    for (int i1 = paramActivity.getIntExtra("ORIGIN_VIDEO_STORY_FROM_TYPE", jdField_a_of_type_Born.a());; i1 = paramActivity.getIntExtra("VIDEO_STORY_FROM_TYPE", jdField_a_of_type_Born.a())) {
      return f(i1);
    }
  }
  
  public static boolean c(Intent paramIntent)
  {
    return (n(paramIntent)) || (o(paramIntent)) || (p(paramIntent));
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
      i1 = paramActivity.getIntExtra("ORIGIN_VIDEO_STORY_FROM_TYPE", jdField_a_of_type_Born.a());
      if (n.a() != i1) {
        break label69;
      }
    }
    label69:
    for (boolean bool = true;; bool = false)
    {
      return bool;
      i1 = paramActivity.getIntExtra("VIDEO_STORY_FROM_TYPE", jdField_a_of_type_Born.a());
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
    return (paramIntent != null) && (a(paramIntent) == i.a());
  }
  
  public static boolean h(int paramInt)
  {
    return (paramInt == x.a()) || (i(paramInt));
  }
  
  public static boolean h(Intent paramIntent)
  {
    return (paramIntent != null) && (a(paramIntent) == B.a());
  }
  
  public static boolean i(int paramInt)
  {
    return (paramInt == A.a()) || (paramInt == z.a());
  }
  
  public static boolean i(Intent paramIntent)
  {
    return (paramIntent != null) && (a(paramIntent) == C.a());
  }
  
  public static boolean j(int paramInt)
  {
    return (paramInt != e.a()) && (paramInt != i.a()) && (paramInt != p.a()) && (paramInt != w.a()) && (paramInt != x.a()) && (paramInt != B.a()) && (paramInt != C.a());
  }
  
  public static boolean j(Intent paramIntent)
  {
    return (paramIntent != null) && ((a(paramIntent) == x.a()) || (k(paramIntent)));
  }
  
  public static boolean k(Intent paramIntent)
  {
    return (paramIntent != null) && ((a(paramIntent) == z.a()) || (a(paramIntent) == A.a()));
  }
  
  private static boolean l(Intent paramIntent)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramIntent != null)
    {
      bool1 = bool2;
      if (paramIntent.getIntExtra("VIDEO_STORY_FROM_TYPE", jdField_a_of_type_Born.a()) == t.a()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private static boolean m(Intent paramIntent)
  {
    return (paramIntent != null) && (paramIntent.getIntExtra("VIDEO_STORY_MEDIA_TYPE", 100) == 101);
  }
  
  private static boolean n(Intent paramIntent)
  {
    return (d(paramIntent)) && (m(paramIntent));
  }
  
  private static boolean o(Intent paramIntent)
  {
    return (l(paramIntent)) && (m(paramIntent));
  }
  
  private static boolean p(Intent paramIntent)
  {
    return (e(paramIntent)) && (m(paramIntent));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     born
 * JD-Core Version:    0.7.0.1
 */