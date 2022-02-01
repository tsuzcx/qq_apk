import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import dov.com.qq.im.ae.mode.AECaptureMode;
import java.util.HashMap;
import java.util.Map;

public class bnlb
{
  public static final bnlb A = new bnlb("circleGuidePicker", 28);
  public static final bnlb B = new bnlb("tribeShortVideoPicker", 29);
  public static final bnlb C = new bnlb("kanDianUGCPicPicker", 30);
  public static final bnlb D = new bnlb("ad", 33);
  public static final bnlb E = new bnlb("circleMultiCutAdditionalPick", 34);
  public static final bnlb F = new bnlb("webFromAIO", 35);
  public static final bnlb G = new bnlb("bless", 36);
  public static final bnlb H = new bnlb("qudongTakeFacePhoto", 1001, false);
  public static final bnlb I = new bnlb("web", 1002, false);
  public static final bnlb J = new bnlb("faceUnlock", 1003, false);
  public static final bnlb a;
  private static final bnlb[] jdField_a_of_type_ArrayOfBnlb = { b, c, e, r, q, s, g, i, k, l, m, n, o, u, t, w, H, I, v, x, z, B, C, F, G, D, J };
  public static final bnlb b;
  public static final bnlb c;
  public static final bnlb d;
  public static final bnlb e;
  public static final bnlb f;
  public static final bnlb g;
  public static final bnlb h;
  public static final bnlb i;
  public static final bnlb j;
  public static final bnlb k;
  public static final bnlb l;
  public static final bnlb m;
  public static final bnlb n;
  public static final bnlb o;
  public static final bnlb p;
  public static final bnlb q;
  public static final bnlb r;
  public static final bnlb s;
  public static final bnlb t;
  public static final bnlb u;
  public static final bnlb v;
  public static final bnlb w;
  public static final bnlb x;
  public static final bnlb y;
  public static final bnlb z;
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_Bnlb = new bnlb("", -1);
    b = new bnlb("h5", 0);
    c = new bnlb("mainCamera", 1);
    d = new bnlb("", 2);
    e = new bnlb("aioMainCamera", 3);
    f = new bnlb("", 4);
    g = new bnlb("qzoneCamera", 5);
    h = new bnlb("", 6);
    i = new bnlb("aioGifCamera", 7);
    j = new bnlb("", 8);
    k = new bnlb("aioGroupSignin", 9);
    l = new bnlb("qzoneSignin", 10);
    m = new bnlb("qzoneBanner", 11);
    n = new bnlb("qzoneTail", 12);
    o = new bnlb("qzoneMoodList", 13);
    p = new bnlb("", 14);
    q = new bnlb("qzoneFriendPlus", 15);
    r = new bnlb("qzoneFriendState", 16);
    s = new bnlb("qzoneSlideCamera", 17);
    t = new bnlb("aioChats", 18);
    u = new bnlb("massSendBless", 19);
    v = new bnlb("qzonePublishFrame", 20);
    w = new bnlb("aioGifCameraTail", 23);
    x = new bnlb("circleCamera", 25);
    y = new bnlb("circlePickCamera", 26);
    z = new bnlb("circleGuideCamera", 27);
  }
  
  private bnlb(String paramString, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = true;
  }
  
  private bnlb(String paramString, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public static int a(Intent paramIntent)
  {
    if (paramIntent == null) {
      return jdField_a_of_type_Bnlb.a();
    }
    return paramIntent.getIntExtra("VIDEO_STORY_FROM_TYPE", jdField_a_of_type_Bnlb.a());
  }
  
  public static int a(bmvf parambmvf)
  {
    int i2 = 200;
    int i1;
    if ((parambmvf != null) && (parambmvf.b() != null)) {
      i1 = parambmvf.b().j();
    }
    do
    {
      do
      {
        do
        {
          return i1;
          i1 = i2;
        } while (parambmvf == null);
        i1 = i2;
      } while (parambmvf.a() == null);
      i1 = i2;
    } while (parambmvf.a().getIntent() == null);
    return parambmvf.a().getIntent().getIntExtra("AECAMERA_MODE", 200);
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
  
  public static bnlb a(int paramInt)
  {
    bnlb[] arrayOfbnlb = jdField_a_of_type_ArrayOfBnlb;
    int i2 = arrayOfbnlb.length;
    int i1 = 0;
    while (i1 < i2)
    {
      bnlb localbnlb = arrayOfbnlb[i1];
      if (paramInt == localbnlb.a()) {
        return localbnlb;
      }
      i1 += 1;
    }
    return jdField_a_of_type_Bnlb;
  }
  
  public static bnlb a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return jdField_a_of_type_Bnlb;
    }
    bnlb[] arrayOfbnlb = jdField_a_of_type_ArrayOfBnlb;
    int i2 = arrayOfbnlb.length;
    int i1 = 0;
    if (i1 < i2)
    {
      bnlb localbnlb = arrayOfbnlb[i1];
      if (TextUtils.isEmpty(localbnlb.a())) {}
      while (!paramString.equals(localbnlb.a()))
      {
        i1 += 1;
        break;
      }
      return localbnlb;
    }
    return jdField_a_of_type_Bnlb;
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
        int i1 = paramActivity.getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", jdField_a_of_type_Bnlb.a());
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
  
  public static boolean a(bmxa parambmxa)
  {
    if ((parambmxa != null) && (parambmxa.a() != null)) {
      return j(parambmxa.a().getIntent());
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
    return d(paramActivity.getIntExtra("VIDEO_STORY_FROM_TYPE", jdField_a_of_type_Bnlb.a()));
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
    for (int i1 = paramActivity.getIntExtra("ORIGIN_VIDEO_STORY_FROM_TYPE", jdField_a_of_type_Bnlb.a());; i1 = paramActivity.getIntExtra("VIDEO_STORY_FROM_TYPE", jdField_a_of_type_Bnlb.a())) {
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
      i1 = paramActivity.getIntExtra("ORIGIN_VIDEO_STORY_FROM_TYPE", jdField_a_of_type_Bnlb.a());
      if (n.a() != i1) {
        break label69;
      }
    }
    label69:
    for (boolean bool = true;; bool = false)
    {
      return bool;
      i1 = paramActivity.getIntExtra("VIDEO_STORY_FROM_TYPE", jdField_a_of_type_Bnlb.a());
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
      if (paramIntent.getIntExtra("VIDEO_STORY_FROM_TYPE", jdField_a_of_type_Bnlb.a()) == t.a()) {
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
 * Qualified Name:     bnlb
 * JD-Core Version:    0.7.0.1
 */