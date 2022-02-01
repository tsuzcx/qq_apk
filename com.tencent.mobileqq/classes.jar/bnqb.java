import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import dov.com.qq.im.ae.mode.AECaptureMode;
import java.util.HashMap;
import java.util.Map;

public class bnqb
{
  public static final bnqb A = new bnqb("circleGuidePicker", 28);
  public static final bnqb B = new bnqb("qudongTakeFacePhoto", 1001, false);
  public static final bnqb C = new bnqb("web", 1002, false);
  public static final bnqb a;
  private static final bnqb[] jdField_a_of_type_ArrayOfBnqb = { b, c, e, r, q, s, g, i, k, l, m, n, o, u, t, w, B, C, v, x, z };
  public static final bnqb b;
  public static final bnqb c;
  public static final bnqb d;
  public static final bnqb e;
  public static final bnqb f;
  public static final bnqb g;
  public static final bnqb h;
  public static final bnqb i;
  public static final bnqb j;
  public static final bnqb k;
  public static final bnqb l;
  public static final bnqb m;
  public static final bnqb n;
  public static final bnqb o;
  public static final bnqb p;
  public static final bnqb q;
  public static final bnqb r;
  public static final bnqb s;
  public static final bnqb t;
  public static final bnqb u;
  public static final bnqb v;
  public static final bnqb w;
  public static final bnqb x;
  public static final bnqb y;
  public static final bnqb z;
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_Bnqb = new bnqb("", -1);
    b = new bnqb("h5", 0);
    c = new bnqb("mainCamera", 1);
    d = new bnqb("", 2);
    e = new bnqb("aioMainCamera", 3);
    f = new bnqb("", 4);
    g = new bnqb("qzoneCamera", 5);
    h = new bnqb("", 6);
    i = new bnqb("aioGifCamera", 7);
    j = new bnqb("", 8);
    k = new bnqb("aioGroupSignin", 9);
    l = new bnqb("qzoneSignin", 10);
    m = new bnqb("qzoneBanner", 11);
    n = new bnqb("qzoneTail", 12);
    o = new bnqb("qzoneMoodList", 13);
    p = new bnqb("", 14);
    q = new bnqb("qzoneFriendPlus", 15);
    r = new bnqb("qzoneFriendState", 16);
    s = new bnqb("qzoneSlideCamera", 17);
    t = new bnqb("aioChats", 18);
    u = new bnqb("massSendBless", 19);
    v = new bnqb("qzonePublishFrame", 20);
    w = new bnqb("aioGifCameraTail", 23);
    x = new bnqb("circleCamera", 25);
    y = new bnqb("circlePickCamera", 26);
    z = new bnqb("circleGuideCamera", 27);
  }
  
  private bnqb(String paramString, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = true;
  }
  
  private bnqb(String paramString, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public static int a(Intent paramIntent)
  {
    if (paramIntent == null) {
      return jdField_a_of_type_Bnqb.a();
    }
    return paramIntent.getIntExtra("VIDEO_STORY_FROM_TYPE", jdField_a_of_type_Bnqb.a());
  }
  
  public static int a(bndy parambndy)
  {
    int i2 = 200;
    int i1 = i2;
    if (parambndy != null)
    {
      i1 = i2;
      if (parambndy.a() != null)
      {
        i1 = i2;
        if (parambndy.a().getIntent() != null) {
          i1 = parambndy.a().getIntent().getIntExtra("AECAMERA_MODE", 200);
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
  
  public static bnqb a(int paramInt)
  {
    bnqb[] arrayOfbnqb = jdField_a_of_type_ArrayOfBnqb;
    int i2 = arrayOfbnqb.length;
    int i1 = 0;
    while (i1 < i2)
    {
      bnqb localbnqb = arrayOfbnqb[i1];
      if (paramInt == localbnqb.a()) {
        return localbnqb;
      }
      i1 += 1;
    }
    return jdField_a_of_type_Bnqb;
  }
  
  public static bnqb a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return jdField_a_of_type_Bnqb;
    }
    bnqb[] arrayOfbnqb = jdField_a_of_type_ArrayOfBnqb;
    int i2 = arrayOfbnqb.length;
    int i1 = 0;
    if (i1 < i2)
    {
      bnqb localbnqb = arrayOfbnqb[i1];
      if (TextUtils.isEmpty(localbnqb.a())) {}
      while (!paramString.equals(localbnqb.a()))
      {
        i1 += 1;
        break;
      }
      return localbnqb;
    }
    return jdField_a_of_type_Bnqb;
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
        int i1 = paramActivity.getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", jdField_a_of_type_Bnqb.a());
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
    return d(paramActivity.getIntExtra("VIDEO_STORY_FROM_TYPE", jdField_a_of_type_Bnqb.a()));
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
    for (int i1 = paramActivity.getIntExtra("ORIGIN_VIDEO_STORY_FROM_TYPE", jdField_a_of_type_Bnqb.a());; i1 = paramActivity.getIntExtra("VIDEO_STORY_FROM_TYPE", jdField_a_of_type_Bnqb.a())) {
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
      i1 = paramActivity.getIntExtra("ORIGIN_VIDEO_STORY_FROM_TYPE", jdField_a_of_type_Bnqb.a());
      if (n.a() != i1) {
        break label69;
      }
    }
    label69:
    for (boolean bool = true;; bool = false)
    {
      return bool;
      i1 = paramActivity.getIntExtra("VIDEO_STORY_FROM_TYPE", jdField_a_of_type_Bnqb.a());
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
      if (paramIntent.getIntExtra("VIDEO_STORY_FROM_TYPE", jdField_a_of_type_Bnqb.a()) == t.a()) {
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
 * Qualified Name:     bnqb
 * JD-Core Version:    0.7.0.1
 */