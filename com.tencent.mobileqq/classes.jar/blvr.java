import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import dov.com.qq.im.ae.mode.AECaptureMode;
import java.util.HashMap;
import java.util.Map;

public class blvr
{
  public static final blvr A = new blvr("circleGuidePicker", 28);
  public static final blvr B = new blvr("tribeShortVideoPicker", 29);
  public static final blvr C = new blvr("kanDianUGCPicPicker", 30);
  public static final blvr D = new blvr("ad", 33);
  public static final blvr E = new blvr("circleMultiCutAdditionalPick", 34);
  public static final blvr F = new blvr("webFromAIO", 35);
  public static final blvr G = new blvr("bless", 36);
  public static final blvr H = new blvr("qudongTakeFacePhoto", 1001, false);
  public static final blvr I = new blvr("web", 1002, false);
  public static final blvr a;
  private static final blvr[] jdField_a_of_type_ArrayOfBlvr = { b, c, e, r, q, s, g, i, k, l, m, n, o, u, t, w, H, I, v, x, z, B, C, F, G, D };
  public static final blvr b;
  public static final blvr c;
  public static final blvr d;
  public static final blvr e;
  public static final blvr f;
  public static final blvr g;
  public static final blvr h;
  public static final blvr i;
  public static final blvr j;
  public static final blvr k;
  public static final blvr l;
  public static final blvr m;
  public static final blvr n;
  public static final blvr o;
  public static final blvr p;
  public static final blvr q;
  public static final blvr r;
  public static final blvr s;
  public static final blvr t;
  public static final blvr u;
  public static final blvr v;
  public static final blvr w;
  public static final blvr x;
  public static final blvr y;
  public static final blvr z;
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_Blvr = new blvr("", -1);
    b = new blvr("h5", 0);
    c = new blvr("mainCamera", 1);
    d = new blvr("", 2);
    e = new blvr("aioMainCamera", 3);
    f = new blvr("", 4);
    g = new blvr("qzoneCamera", 5);
    h = new blvr("", 6);
    i = new blvr("aioGifCamera", 7);
    j = new blvr("", 8);
    k = new blvr("aioGroupSignin", 9);
    l = new blvr("qzoneSignin", 10);
    m = new blvr("qzoneBanner", 11);
    n = new blvr("qzoneTail", 12);
    o = new blvr("qzoneMoodList", 13);
    p = new blvr("", 14);
    q = new blvr("qzoneFriendPlus", 15);
    r = new blvr("qzoneFriendState", 16);
    s = new blvr("qzoneSlideCamera", 17);
    t = new blvr("aioChats", 18);
    u = new blvr("massSendBless", 19);
    v = new blvr("qzonePublishFrame", 20);
    w = new blvr("aioGifCameraTail", 23);
    x = new blvr("circleCamera", 25);
    y = new blvr("circlePickCamera", 26);
    z = new blvr("circleGuideCamera", 27);
  }
  
  private blvr(String paramString, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = true;
  }
  
  private blvr(String paramString, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public static int a(Intent paramIntent)
  {
    if (paramIntent == null) {
      return jdField_a_of_type_Blvr.a();
    }
    return paramIntent.getIntExtra("VIDEO_STORY_FROM_TYPE", jdField_a_of_type_Blvr.a());
  }
  
  public static int a(blio paramblio)
  {
    int i2 = 200;
    int i1;
    if ((paramblio != null) && (paramblio.b() != null)) {
      i1 = paramblio.b().j();
    }
    do
    {
      do
      {
        do
        {
          return i1;
          i1 = i2;
        } while (paramblio == null);
        i1 = i2;
      } while (paramblio.a() == null);
      i1 = i2;
    } while (paramblio.a().getIntent() == null);
    return paramblio.a().getIntent().getIntExtra("AECAMERA_MODE", 200);
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
  
  public static blvr a(int paramInt)
  {
    blvr[] arrayOfblvr = jdField_a_of_type_ArrayOfBlvr;
    int i2 = arrayOfblvr.length;
    int i1 = 0;
    while (i1 < i2)
    {
      blvr localblvr = arrayOfblvr[i1];
      if (paramInt == localblvr.a()) {
        return localblvr;
      }
      i1 += 1;
    }
    return jdField_a_of_type_Blvr;
  }
  
  public static blvr a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return jdField_a_of_type_Blvr;
    }
    blvr[] arrayOfblvr = jdField_a_of_type_ArrayOfBlvr;
    int i2 = arrayOfblvr.length;
    int i1 = 0;
    if (i1 < i2)
    {
      blvr localblvr = arrayOfblvr[i1];
      if (TextUtils.isEmpty(localblvr.a())) {}
      while (!paramString.equals(localblvr.a()))
      {
        i1 += 1;
        break;
      }
      return localblvr;
    }
    return jdField_a_of_type_Blvr;
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
        int i1 = paramActivity.getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", jdField_a_of_type_Blvr.a());
        if (i1 != I.a())
        {
          bool1 = bool2;
          if (i1 != H.a()) {}
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
  
  public static boolean a(bljy parambljy)
  {
    if ((parambljy != null) && (parambljy.a() != null)) {
      return j(parambljy.a().getIntent());
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
    return d(paramActivity.getIntExtra("VIDEO_STORY_FROM_TYPE", jdField_a_of_type_Blvr.a()));
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
    for (int i1 = paramActivity.getIntExtra("ORIGIN_VIDEO_STORY_FROM_TYPE", jdField_a_of_type_Blvr.a());; i1 = paramActivity.getIntExtra("VIDEO_STORY_FROM_TYPE", jdField_a_of_type_Blvr.a())) {
      return f(i1);
    }
  }
  
  public static boolean c(Intent paramIntent)
  {
    return (p(paramIntent)) || (q(paramIntent)) || (r(paramIntent));
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
      i1 = paramActivity.getIntExtra("ORIGIN_VIDEO_STORY_FROM_TYPE", jdField_a_of_type_Blvr.a());
      if (n.a() != i1) {
        break label69;
      }
    }
    label69:
    for (boolean bool = true;; bool = false)
    {
      return bool;
      i1 = paramActivity.getIntExtra("VIDEO_STORY_FROM_TYPE", jdField_a_of_type_Blvr.a());
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
    return (paramInt == x.a()) || (i(paramInt)) || (j(paramInt));
  }
  
  public static boolean h(Intent paramIntent)
  {
    return (paramIntent != null) && (a(paramIntent) == H.a());
  }
  
  public static boolean i(int paramInt)
  {
    return (paramInt == A.a()) || (paramInt == z.a());
  }
  
  public static boolean i(Intent paramIntent)
  {
    return (paramIntent != null) && (a(paramIntent) == I.a());
  }
  
  public static boolean j(int paramInt)
  {
    return paramInt == E.a();
  }
  
  public static boolean j(Intent paramIntent)
  {
    return ((paramIntent != null) && ((a(paramIntent) == x.a()) || (k(paramIntent)))) || (m(paramIntent));
  }
  
  public static boolean k(int paramInt)
  {
    return (paramInt != e.a()) && (paramInt != i.a()) && (paramInt != p.a()) && (paramInt != w.a()) && (paramInt != x.a()) && (paramInt != H.a()) && (paramInt != I.a());
  }
  
  public static boolean k(Intent paramIntent)
  {
    return (paramIntent != null) && ((a(paramIntent) == z.a()) || (a(paramIntent) == A.a()));
  }
  
  public static boolean l(Intent paramIntent)
  {
    if (paramIntent == null) {}
    int i1;
    do
    {
      return false;
      i1 = a(paramIntent);
    } while ((i1 != F.a()) && (i1 != G.a()) && (i1 != D.a()));
    return true;
  }
  
  public static boolean m(Intent paramIntent)
  {
    return (paramIntent != null) && (a(paramIntent) == E.a());
  }
  
  private static boolean n(Intent paramIntent)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramIntent != null)
    {
      bool1 = bool2;
      if (paramIntent.getIntExtra("VIDEO_STORY_FROM_TYPE", jdField_a_of_type_Blvr.a()) == t.a()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private static boolean o(Intent paramIntent)
  {
    return (paramIntent != null) && (paramIntent.getIntExtra("VIDEO_STORY_MEDIA_TYPE", 100) == 101);
  }
  
  private static boolean p(Intent paramIntent)
  {
    return (d(paramIntent)) && (o(paramIntent));
  }
  
  private static boolean q(Intent paramIntent)
  {
    return (n(paramIntent)) && (o(paramIntent));
  }
  
  private static boolean r(Intent paramIntent)
  {
    return (e(paramIntent)) && (o(paramIntent));
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
 * Qualified Name:     blvr
 * JD-Core Version:    0.7.0.1
 */