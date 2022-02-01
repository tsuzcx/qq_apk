import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PointF;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.mobileqq.richmedia.capture.data.TrackerStickerParam;
import dov.com.qq.im.capture.text.DynamicTextItem;
import dov.com.qq.im.capture.text.TextParcelData;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.StoryGuideLineView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@TargetApi(14)
public class bqjx
  extends bqkj
{
  public static int a;
  public static final String a;
  public static final int b;
  private static String jdField_b_of_type_JavaLangString = "TextLayer";
  public static final int c;
  public static int d;
  public static int e;
  public static volatile int f;
  public Paint a;
  PointF jdField_a_of_type_AndroidGraphicsPointF = new PointF();
  bpse jdField_a_of_type_Bpse = new bpse();
  public bqjy a;
  public bqka a;
  public bqrj a;
  public ArrayList<bqka> a;
  private Paint jdField_b_of_type_AndroidGraphicsPaint;
  bqka jdField_b_of_type_Bqka;
  public int g;
  public int h;
  public int i;
  public int j = c;
  public int k;
  public int l;
  public int m;
  public int n;
  public int o;
  
  static
  {
    jdField_a_of_type_JavaLangString = bqjx.class.getSimpleName();
    jdField_b_of_type_Int = bqyb.a[1];
    c = Color.parseColor("#80000000");
    e = 270;
    f = 5;
  }
  
  public bqjx(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    o();
  }
  
  /* Error */
  private String a(String paramString, bqka parambqka)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 108	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +7 -> 11
    //   7: aload_2
    //   8: ifnonnull +7 -> 15
    //   11: aconst_null
    //   12: astore_2
    //   13: aload_2
    //   14: areturn
    //   15: aload_0
    //   16: invokevirtual 111	bqjx:c	()I
    //   19: aload_0
    //   20: invokevirtual 113	bqjx:d	()I
    //   23: getstatic 119	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   26: invokestatic 125	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   29: astore 4
    //   31: aload 4
    //   33: astore 5
    //   35: new 127	android/graphics/Canvas
    //   38: dup
    //   39: aload 4
    //   41: invokespecial 130	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   44: astore 6
    //   46: aload 4
    //   48: astore 5
    //   50: aload 6
    //   52: aload_0
    //   53: getfield 132	bqjx:jdField_a_of_type_Bqrj	Lbqrj;
    //   56: aload_2
    //   57: invokevirtual 137	bqrj:a	(Lbqrk;)Landroid/graphics/Matrix;
    //   60: invokevirtual 141	android/graphics/Canvas:concat	(Landroid/graphics/Matrix;)V
    //   63: aload 4
    //   65: astore 5
    //   67: aload_2
    //   68: getfield 146	bqka:jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem	Ldov/com/qq/im/capture/text/DynamicTextItem;
    //   71: aload 6
    //   73: invokevirtual 151	dov/com/qq/im/capture/text/DynamicTextItem:b	(Landroid/graphics/Canvas;)V
    //   76: aload 4
    //   78: astore 5
    //   80: aload_1
    //   81: ldc 153
    //   83: invokestatic 156	bqjx:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   86: astore_1
    //   87: aload 4
    //   89: astore 5
    //   91: aload_0
    //   92: aload 4
    //   94: getstatic 162	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   97: bipush 100
    //   99: aload_1
    //   100: invokevirtual 165	bqjx:a	(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;)Z
    //   103: istore_3
    //   104: aload 4
    //   106: astore 5
    //   108: getstatic 42	bqjx:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   111: new 167	java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial 168	java/lang/StringBuilder:<init>	()V
    //   118: ldc 170
    //   120: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: aload_2
    //   124: getfield 178	bqka:u	F
    //   127: invokevirtual 181	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   130: ldc 183
    //   132: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: aload_2
    //   136: getfield 178	bqka:u	F
    //   139: invokevirtual 181	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   142: ldc 185
    //   144: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: aload_1
    //   148: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: invokestatic 193	yuk:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   157: iload_3
    //   158: ifne +23 -> 181
    //   161: aload 4
    //   163: ifnull +16 -> 179
    //   166: aload 4
    //   168: invokevirtual 197	android/graphics/Bitmap:isRecycled	()Z
    //   171: ifne +8 -> 179
    //   174: aload 4
    //   176: invokevirtual 200	android/graphics/Bitmap:recycle	()V
    //   179: aconst_null
    //   180: areturn
    //   181: aload_1
    //   182: astore_2
    //   183: aload 4
    //   185: ifnull -172 -> 13
    //   188: aload_1
    //   189: astore_2
    //   190: aload 4
    //   192: invokevirtual 197	android/graphics/Bitmap:isRecycled	()Z
    //   195: ifne -182 -> 13
    //   198: aload 4
    //   200: invokevirtual 200	android/graphics/Bitmap:recycle	()V
    //   203: aload_1
    //   204: areturn
    //   205: astore_2
    //   206: aconst_null
    //   207: astore 4
    //   209: aconst_null
    //   210: astore_1
    //   211: aload 4
    //   213: astore 5
    //   215: getstatic 42	bqjx:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   218: ldc 202
    //   220: aload_2
    //   221: invokestatic 205	yuk:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   224: aload_1
    //   225: astore_2
    //   226: aload 4
    //   228: ifnull -215 -> 13
    //   231: aload_1
    //   232: astore_2
    //   233: aload 4
    //   235: invokevirtual 197	android/graphics/Bitmap:isRecycled	()Z
    //   238: ifne -225 -> 13
    //   241: aload 4
    //   243: invokevirtual 200	android/graphics/Bitmap:recycle	()V
    //   246: aload_1
    //   247: areturn
    //   248: astore_1
    //   249: aconst_null
    //   250: astore 5
    //   252: aload 5
    //   254: ifnull +16 -> 270
    //   257: aload 5
    //   259: invokevirtual 197	android/graphics/Bitmap:isRecycled	()Z
    //   262: ifne +8 -> 270
    //   265: aload 5
    //   267: invokevirtual 200	android/graphics/Bitmap:recycle	()V
    //   270: aload_1
    //   271: athrow
    //   272: astore_1
    //   273: goto -21 -> 252
    //   276: astore_2
    //   277: aconst_null
    //   278: astore_1
    //   279: goto -68 -> 211
    //   282: astore_2
    //   283: goto -72 -> 211
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	286	0	this	bqjx
    //   0	286	1	paramString	String
    //   0	286	2	parambqka	bqka
    //   103	55	3	bool	boolean
    //   29	213	4	localBitmap1	android.graphics.Bitmap
    //   33	233	5	localBitmap2	android.graphics.Bitmap
    //   44	28	6	localCanvas	Canvas
    // Exception table:
    //   from	to	target	type
    //   15	31	205	java/lang/OutOfMemoryError
    //   15	31	248	finally
    //   35	46	272	finally
    //   50	63	272	finally
    //   67	76	272	finally
    //   80	87	272	finally
    //   91	104	272	finally
    //   108	157	272	finally
    //   215	224	272	finally
    //   35	46	276	java/lang/OutOfMemoryError
    //   50	63	276	java/lang/OutOfMemoryError
    //   67	76	276	java/lang/OutOfMemoryError
    //   80	87	276	java/lang/OutOfMemoryError
    //   91	104	282	java/lang/OutOfMemoryError
    //   108	157	282	java/lang/OutOfMemoryError
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      throw new IllegalArgumentException("folderPath should not be null");
    }
    String str = paramString1;
    if (!paramString1.endsWith("/")) {
      str = paramString1 + "/";
    }
    return str + System.currentTimeMillis() + "_" + paramString2;
  }
  
  private void a(bqka parambqka)
  {
    boolean bool1 = this.jdField_a_of_type_Bqrj.a(parambqka, StoryGuideLineView.jdField_a_of_type_Int, true);
    boolean bool2 = this.jdField_a_of_type_Bqrj.a(parambqka, StoryGuideLineView.jdField_b_of_type_Int, false);
    boolean bool3 = this.jdField_a_of_type_Bqrj.b(parambqka, StoryGuideLineView.d, false);
    if (this.jdField_a_of_type_Bqjy != null) {
      this.jdField_a_of_type_Bqjy.a(bool1, bool2, false, bool3, parambqka.l);
    }
    if (parambqka != null)
    {
      if (parambqka.k) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(parambqka.l, parambqka.r, parambqka.s, parambqka.t, parambqka.jdField_b_of_type_AndroidGraphicsPointF, parambqka.m, 2);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(parambqka.l, parambqka.r, parambqka.s, parambqka.t, parambqka.jdField_b_of_type_AndroidGraphicsPointF, parambqka.m, 1);
  }
  
  public static void c(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        f -= 1;
        f = Math.min(f, 5);
        f = Math.max(f, 4);
        return;
      }
      finally {}
      f += 1;
    }
  }
  
  private boolean e()
  {
    boolean bool = false;
    String str = Build.MANUFACTURER + "-" + Build.MODEL;
    if ((str.equalsIgnoreCase("vivo-vivo X6Plus D")) || (str.equalsIgnoreCase("motorola-Nexus 6"))) {
      bool = true;
    }
    yuk.b(jdField_a_of_type_JavaLangString, "isRubbish:" + bool + " brand:" + str);
    return bool;
  }
  
  private void o()
  {
    this.k = agej.a(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.i = bqrh.a(this.jdField_a_of_type_AndroidContentContext);
    this.h = 1;
    this.g = 1;
    this.jdField_a_of_type_Bqrj = new bqrj();
    this.jdField_a_of_type_Bqrj.a(6.0F);
    this.jdField_a_of_type_Bqrj.b(0.2F);
    this.jdField_a_of_type_Bqrj.a(true);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(2.0F);
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    d = ViewConfiguration.get(this.jdField_a_of_type_AndroidContentContext).getScaledTouchSlop();
    if ((e == 270) && (e())) {
      e = 540;
    }
  }
  
  private void p()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(false, 0.0F, 0.0F, 0.0F, null, false, 1);
  }
  
  public Bundle a()
  {
    Bundle localBundle = super.a();
    ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList.size());
    int i1 = 0;
    while (i1 < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      localArrayList.add(new TextParcelData((bqka)this.jdField_a_of_type_JavaUtilArrayList.get(i1)));
      i1 += 1;
    }
    localBundle.putParcelableArrayList("TextParcelDataList", localArrayList);
    return localBundle;
  }
  
  public bqka a()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > f))
    {
      this.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_Bqka);
      return this.jdField_a_of_type_Bqka;
    }
    return null;
  }
  
  public DynamicTextItem a()
  {
    if (this.jdField_a_of_type_Bqka != null) {
      return this.jdField_a_of_type_Bqka.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem;
    }
    return null;
  }
  
  public DynamicTextItem a(int paramInt)
  {
    return a(null, null, paramInt);
  }
  
  public DynamicTextItem a(bqjz parambqjz, SegmentKeeper paramSegmentKeeper, int paramInt)
  {
    DynamicTextItem localDynamicTextItem = null;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() < f) {
      if (parambqjz == null) {
        break label87;
      }
    }
    label87:
    for (parambqjz = new bqka(this, parambqjz);; parambqjz = new bqka(this))
    {
      parambqjz.jdField_a_of_type_Int = paramInt;
      parambqjz.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper = new SegmentKeeper(paramSegmentKeeper);
      if (parambqjz.jdField_a_of_type_Int == 0) {
        SegmentKeeper.adjustTime(-1L * System.currentTimeMillis());
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(parambqjz);
      localDynamicTextItem = parambqjz.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem;
      this.jdField_a_of_type_Bqka = parambqjz;
      return localDynamicTextItem;
    }
  }
  
  public String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public ArrayList<TrackerStickerParam> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        bqka localbqka = (bqka)localIterator.next();
        if ((localbqka.c()) || (localbqka.d()))
        {
          Object localObject = a(paramString, localbqka);
          localObject = new TrackerStickerParam(c() / 2, d() / 2, 1.0F, 0.0F, 0.0F, 0.0F, c(), d(), c(), d(), (String)localObject, localbqka.jdField_a_of_type_JavaUtilMap);
          ((TrackerStickerParam)localObject).setSegmentList(localbqka.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.getSegmentList());
          localArrayList.add(localObject);
        }
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.g = 1;
    this.h = 1;
    this.j = c;
    this.m = 0;
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_Bqka = null;
    yuk.b(jdField_a_of_type_JavaLangString, "clear over");
  }
  
  public void a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      bqka localbqka = (bqka)localIterator.next();
      if (localbqka.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper != null) {
        localbqka.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.setMode(paramInt);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    this.jdField_a_of_type_AndroidGraphicsPointF.x = (paramInt1 / 2);
    this.jdField_a_of_type_AndroidGraphicsPointF.y = (0.42F * paramInt2);
    jdField_a_of_type_Int = (int)(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.b() * 0.04F);
  }
  
  protected void a(Canvas paramCanvas)
  {
    Iterator localIterator;
    bqka localbqka;
    if (this.g == 6)
    {
      if (this.jdField_b_of_type_Bqka != null) {
        this.jdField_b_of_type_Bqka.a(paramCanvas);
      }
      localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        localbqka = (bqka)localIterator.next();
        if ((this.jdField_b_of_type_Bqka != null) && (localbqka.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem != this.jdField_b_of_type_Bqka.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem)) {
          localbqka.a(paramCanvas);
        }
      }
    }
    if ((this.g == 4) || (this.g == 3)) {
      localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    }
    while (localIterator.hasNext())
    {
      ((bqka)localIterator.next()).a(paramCanvas);
      continue;
      if (this.g == 5)
      {
        localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          localbqka = (bqka)localIterator.next();
          if (localbqka.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem != this.jdField_a_of_type_Bqka.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem) {
            localbqka.a(paramCanvas);
          }
        }
      }
    }
  }
  
  public void a(Canvas paramCanvas, float paramFloat, boolean paramBoolean)
  {
    paramCanvas.save();
    paramCanvas.scale(paramFloat, paramFloat);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      bqka localbqka = (bqka)localIterator.next();
      if (((!localbqka.c()) && (!localbqka.d())) || (paramBoolean)) {
        localbqka.a(paramCanvas);
      }
    }
    paramCanvas.restore();
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    super.a(paramBundle);
    a(paramBundle.getParcelableArrayList("TextParcelDataList"), paramBundle.getBoolean("edit_type_photo"));
  }
  
  public void a(bqjy parambqjy)
  {
    this.jdField_a_of_type_Bqjy = parambqjy;
  }
  
  public void a(DynamicTextItem paramDynamicTextItem)
  {
    Object localObject;
    if ((paramDynamicTextItem != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      localObject = null;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      if (localIterator.hasNext())
      {
        bqka localbqka = (bqka)localIterator.next();
        if (!paramDynamicTextItem.equals(localbqka.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem)) {
          break label72;
        }
        localObject = localbqka;
      }
    }
    label72:
    for (;;)
    {
      break;
      this.jdField_a_of_type_JavaUtilArrayList.remove(localObject);
      return;
    }
  }
  
  public void a(ArrayList<TextParcelData> paramArrayList, boolean paramBoolean)
  {
    if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      b(4);
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      paramArrayList = paramArrayList.iterator();
      do
      {
        if (!paramArrayList.hasNext()) {
          break;
        }
        bqka localbqka = ((TextParcelData)paramArrayList.next()).a(this);
        if (!paramBoolean)
        {
          localbqka.c(true);
          localbqka.jdField_a_of_type_Int = 1;
        }
        this.jdField_a_of_type_JavaUtilArrayList.add(localbqka);
      } while (this.jdField_a_of_type_JavaUtilArrayList.size() <= f);
    }
    k();
  }
  
  public void a(boolean paramBoolean)
  {
    yuk.b(jdField_a_of_type_JavaLangString, "setKeyboardState:" + paramBoolean);
    if (paramBoolean) {}
    for (;;)
    {
      super.k();
      return;
      b(4);
    }
  }
  
  public boolean a()
  {
    return this.g == 1;
  }
  
  public boolean a(long paramLong)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      if (((bqka)localIterator.next()).jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.isSegmentChanged(paramLong)) {
        return false;
      }
    }
    return true;
  }
  
  /* Error */
  public boolean a(android.graphics.Bitmap paramBitmap, android.graphics.Bitmap.CompressFormat paramCompressFormat, int paramInt, String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: getstatic 42	bqjx:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6: new 167	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 168	java/lang/StringBuilder:<init>	()V
    //   13: ldc_w 582
    //   16: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: aload 4
    //   21: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: invokestatic 193	yuk:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   30: aload_1
    //   31: ifnonnull +15 -> 46
    //   34: getstatic 42	bqjx:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   37: ldc_w 584
    //   40: invokestatic 193	yuk:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: iload 5
    //   45: ireturn
    //   46: aconst_null
    //   47: astore 8
    //   49: aconst_null
    //   50: astore 6
    //   52: aconst_null
    //   53: astore 7
    //   55: new 586	java/io/File
    //   58: dup
    //   59: aload 4
    //   61: invokespecial 587	java/io/File:<init>	(Ljava/lang/String;)V
    //   64: astore 9
    //   66: aload 6
    //   68: astore 4
    //   70: aload 9
    //   72: invokevirtual 590	java/io/File:exists	()Z
    //   75: ifne +13 -> 88
    //   78: aload 6
    //   80: astore 4
    //   82: aload 9
    //   84: invokevirtual 593	java/io/File:createNewFile	()Z
    //   87: pop
    //   88: aload 6
    //   90: astore 4
    //   92: new 595	java/io/FileOutputStream
    //   95: dup
    //   96: aload 9
    //   98: invokespecial 598	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   101: astore 6
    //   103: aload_1
    //   104: aload_2
    //   105: iload_3
    //   106: aload 6
    //   108: invokevirtual 602	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   111: pop
    //   112: iconst_1
    //   113: istore 5
    //   115: aload 6
    //   117: ifnull -74 -> 43
    //   120: aload 6
    //   122: invokevirtual 605	java/io/FileOutputStream:close	()V
    //   125: iconst_1
    //   126: ireturn
    //   127: astore_1
    //   128: aload_1
    //   129: invokevirtual 608	java/io/IOException:printStackTrace	()V
    //   132: iconst_1
    //   133: ireturn
    //   134: astore_2
    //   135: aload 7
    //   137: astore_1
    //   138: aload_1
    //   139: astore 4
    //   141: aload_2
    //   142: invokevirtual 609	java/io/FileNotFoundException:printStackTrace	()V
    //   145: aload_1
    //   146: ifnull -103 -> 43
    //   149: aload_1
    //   150: invokevirtual 605	java/io/FileOutputStream:close	()V
    //   153: iconst_0
    //   154: ireturn
    //   155: astore_1
    //   156: aload_1
    //   157: invokevirtual 608	java/io/IOException:printStackTrace	()V
    //   160: iconst_0
    //   161: ireturn
    //   162: astore_2
    //   163: aload 8
    //   165: astore_1
    //   166: aload_1
    //   167: astore 4
    //   169: aload_2
    //   170: invokevirtual 608	java/io/IOException:printStackTrace	()V
    //   173: aload_1
    //   174: ifnull -131 -> 43
    //   177: aload_1
    //   178: invokevirtual 605	java/io/FileOutputStream:close	()V
    //   181: iconst_0
    //   182: ireturn
    //   183: astore_1
    //   184: aload_1
    //   185: invokevirtual 608	java/io/IOException:printStackTrace	()V
    //   188: iconst_0
    //   189: ireturn
    //   190: astore_1
    //   191: aload 4
    //   193: ifnull +8 -> 201
    //   196: aload 4
    //   198: invokevirtual 605	java/io/FileOutputStream:close	()V
    //   201: aload_1
    //   202: athrow
    //   203: astore_2
    //   204: aload_2
    //   205: invokevirtual 608	java/io/IOException:printStackTrace	()V
    //   208: goto -7 -> 201
    //   211: astore_1
    //   212: aload 6
    //   214: astore 4
    //   216: goto -25 -> 191
    //   219: astore_2
    //   220: aload 6
    //   222: astore_1
    //   223: goto -57 -> 166
    //   226: astore_2
    //   227: aload 6
    //   229: astore_1
    //   230: goto -92 -> 138
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	233	0	this	bqjx
    //   0	233	1	paramBitmap	android.graphics.Bitmap
    //   0	233	2	paramCompressFormat	android.graphics.Bitmap.CompressFormat
    //   0	233	3	paramInt	int
    //   0	233	4	paramString	String
    //   1	113	5	bool	boolean
    //   50	178	6	localFileOutputStream	java.io.FileOutputStream
    //   53	83	7	localObject1	Object
    //   47	117	8	localObject2	Object
    //   64	33	9	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   120	125	127	java/io/IOException
    //   70	78	134	java/io/FileNotFoundException
    //   82	88	134	java/io/FileNotFoundException
    //   92	103	134	java/io/FileNotFoundException
    //   149	153	155	java/io/IOException
    //   70	78	162	java/io/IOException
    //   82	88	162	java/io/IOException
    //   92	103	162	java/io/IOException
    //   177	181	183	java/io/IOException
    //   70	78	190	finally
    //   82	88	190	finally
    //   92	103	190	finally
    //   141	145	190	finally
    //   169	173	190	finally
    //   196	201	203	java/io/IOException
    //   103	112	211	finally
    //   103	112	219	java/io/IOException
    //   103	112	226	java/io/FileNotFoundException
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    int i1;
    int i2;
    if (b())
    {
      i1 = (int)paramMotionEvent.getY();
      i2 = Math.abs(i1 - this.l);
      switch (paramMotionEvent.getAction() & 0xFF)
      {
      case 3: 
      case 4: 
      default: 
        this.jdField_a_of_type_Bqrj.a(paramMotionEvent, false);
        if (this.jdField_a_of_type_Bqka == null) {
          p();
        }
        break;
      }
    }
    for (;;)
    {
      bool = true;
      return bool;
      this.jdField_a_of_type_Bqrj.a(this.jdField_a_of_type_Bqka);
      j();
      this.jdField_a_of_type_Bqka.b();
      this.l = i1;
      break;
      this.jdField_a_of_type_Bqka.c();
      break;
      if (this.g == 3) {
        this.jdField_a_of_type_Bqka.c();
      }
      if (i2 <= d) {
        break;
      }
      b(3);
      break;
      if (this.jdField_a_of_type_Bqka != null) {
        this.jdField_a_of_type_Bqka.c();
      }
      a(this, false);
      n();
      if (i2 < d)
      {
        c();
        break;
      }
      if (this.g != 3) {
        break;
      }
      b(4);
      break;
      a(this.jdField_a_of_type_Bqka);
    }
  }
  
  public boolean a(JSONObject paramJSONObject)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.isEmpty())) {
      return false;
    }
    try
    {
      JSONArray localJSONArray = new JSONArray();
      Object localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        localJSONArray.put(new TextParcelData((bqka)((Iterator)localObject).next()).a());
      }
      localObject = new JSONObject();
      ((JSONObject)localObject).put("topLevelWeight", this.t);
      ((JSONObject)localObject).put("isEditPic", this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a.a());
      ((JSONObject)localObject).put("textItems", localJSONArray);
      paramJSONObject.put(jdField_b_of_type_JavaLangString, localObject);
      return true;
    }
    catch (Exception paramJSONObject) {}
    return false;
  }
  
  public int b()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
      return this.jdField_a_of_type_JavaUtilArrayList.size();
    }
    if (b()) {
      return 1;
    }
    return 0;
  }
  
  public void b(int paramInt)
  {
    yuk.b(jdField_a_of_type_JavaLangString, "setMode:" + paramInt + ",preMode:" + this.h);
    this.h = this.g;
    this.g = paramInt;
    if (paramInt == 4) {
      n();
    }
    super.k();
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt2 < 0))
    {
      yuk.e(jdField_a_of_type_JavaLangString, "setTextOffset x:" + paramInt1 + "y=" + paramInt2);
      return;
    }
    yuk.b(jdField_a_of_type_JavaLangString, "setTextTop:" + paramInt1 + "y=" + paramInt2);
    this.n = paramInt1;
    this.o = paramInt2;
  }
  
  public void b(Canvas paramCanvas)
  {
    a(paramCanvas, this.jdField_a_of_type_Float, false);
  }
  
  public void b(DynamicTextItem paramDynamicTextItem)
  {
    if (this.jdField_a_of_type_Bqka != null)
    {
      this.jdField_a_of_type_Bqka.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem = paramDynamicTextItem;
      this.jdField_a_of_type_Bqka.u = paramDynamicTextItem.a();
      this.jdField_a_of_type_Bqka.v = paramDynamicTextItem.b();
    }
    if (this.jdField_b_of_type_Bqka != null)
    {
      this.jdField_b_of_type_Bqka.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem = paramDynamicTextItem;
      if (this.jdField_a_of_type_Bqka != null)
      {
        this.jdField_b_of_type_Bqka.q = this.jdField_a_of_type_Bqka.q;
        this.jdField_b_of_type_Bqka.jdField_b_of_type_Float = this.jdField_a_of_type_Bqka.q;
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    b(5);
    if (paramBoolean) {
      d();
    }
  }
  
  public boolean b()
  {
    return (this.g == 4) || (this.g == 3);
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    if (b())
    {
      float f1 = paramMotionEvent.getX(0);
      float f2 = paramMotionEvent.getY(0);
      int i1 = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
      if (i1 >= 0)
      {
        paramMotionEvent = (bqka)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
        if ((paramMotionEvent != null) && (paramMotionEvent.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper != null) && (paramMotionEvent.d()) && (!paramMotionEvent.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.isCurrentIn())) {}
        while (!this.jdField_a_of_type_Bqrj.a(paramMotionEvent, f1, f2, false))
        {
          i1 -= 1;
          break;
        }
        this.jdField_a_of_type_Bqka = paramMotionEvent;
      }
    }
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        this.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_Bqka);
        this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_Bqka);
      }
      return bool;
    }
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_Bqjy != null) && (this.jdField_a_of_type_Bqka != null))
    {
      if (this.jdField_a_of_type_Bqjy.a(this.jdField_a_of_type_Bqka)) {
        this.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_Bqka);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Bqjy.a(this.jdField_a_of_type_Bqka.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem);
  }
  
  public void c(int paramInt)
  {
    if (paramInt < 0)
    {
      yuk.e(jdField_a_of_type_JavaLangString, "setTextTop:" + paramInt);
      return;
    }
    yuk.b(jdField_a_of_type_JavaLangString, "setTextTop:" + paramInt);
    this.m = paramInt;
  }
  
  public boolean c()
  {
    return (this.n > 0) && (this.o > 0);
  }
  
  public void d()
  {
    if (!a())
    {
      b(6);
      if (this.jdField_a_of_type_Bqka != null)
      {
        this.jdField_b_of_type_Bqka = new bqka(this, this.jdField_a_of_type_Bqka);
        this.jdField_b_of_type_Bqka.a();
        bqka.a(this.jdField_b_of_type_Bqka);
      }
    }
    while (this.jdField_a_of_type_Bqjy == null) {
      return;
    }
    this.jdField_a_of_type_Bqjy.a(1.0F);
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
      this.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
    }
  }
  
  public void f()
  {
    Object localObject1 = new ArrayList();
    Object localObject2;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        bqka localbqka = (bqka)((Iterator)localObject2).next();
        if ((localbqka.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem != null) && (localbqka.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.e())) {
          ((List)localObject1).add(localbqka);
        }
      }
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (bqka)((Iterator)localObject1).next();
      this.jdField_a_of_type_JavaUtilArrayList.remove(localObject2);
    }
    if ((this.jdField_a_of_type_Bqka != null) && (this.jdField_a_of_type_Bqka.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem != null) && (this.jdField_a_of_type_Bqka.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.e())) {
      this.jdField_a_of_type_Bqka = null;
    }
  }
  
  public void g()
  {
    if (this.jdField_b_of_type_Bqka != null)
    {
      b(6);
      bqka.b(this.jdField_b_of_type_Bqka);
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_Bqka != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_Bqka);
      this.jdField_a_of_type_Bqka.c();
      yuk.b(jdField_a_of_type_JavaLangString, "delete " + this.jdField_a_of_type_Bqka);
      this.jdField_a_of_type_Bqka = null;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)
    {
      this.g = 1;
      this.h = 1;
    }
  }
  
  public void i()
  {
    if ((this.jdField_a_of_type_Bqka != null) && (this.jdField_a_of_type_Bqka.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem != null)) {
      this.jdField_a_of_type_Bqka.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.a(-1, false);
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        bqka localbqka = (bqka)localIterator.next();
        if (localbqka.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem != null) {
          localbqka.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.a(-1, false);
        }
      }
    }
    k();
  }
  
  public void j()
  {
    if ((this.jdField_a_of_type_Bqka != null) && (!this.jdField_a_of_type_Bqka.a())) {
      this.jdField_a_of_type_Bqka.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqjx
 * JD-Core Version:    0.7.0.1
 */