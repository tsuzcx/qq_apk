package com.tencent.av.ui;

import actn;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Rect;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import axqw;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.magicface.FaceItem;
import com.tencent.av.opengl.texture.YUVTexture;
import com.tencent.av.opengl.ui.GLRootView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;
import com.tencent.ttpic.openapi.util.FaceDetectUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.BitSet;
import java.util.List;
import java.util.Observable;
import lgf;
import lgq;
import lhw;
import lpf;
import lpg;
import lpq;
import lqt;
import lqu;
import lsh;
import lsk;
import mah;
import mck;
import mcp;
import mee;
import mei;
import miq;
import miw;
import mjd;
import mli;
import mnc;
import mqq.os.MqqHandler;
import muf;

public class VideoLayerUIBase
  extends lsk
{
  public Context a;
  protected Display a;
  public View a;
  public ImageView a;
  public VideoController a;
  public VideoAppInterface a;
  protected Runnable a;
  public final String a;
  private mah jdField_a_of_type_Mah;
  protected mee a;
  private miq jdField_a_of_type_Miq;
  public miw a;
  protected mjd a;
  protected mli a;
  mnc jdField_a_of_type_Mnc = null;
  private float[] jdField_a_of_type_ArrayOfFloat;
  public mee[] a;
  long jdField_b_of_type_Long = 0L;
  protected GLRootView b;
  private RenderBuffer jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
  protected Runnable b;
  private TextureRender jdField_c_of_type_ComTencentTtpicOpenapiFilterTextureRender;
  private boolean jdField_c_of_type_Boolean;
  private Rect d = new Rect();
  protected boolean d;
  private boolean e;
  private boolean f;
  public int n;
  public int o;
  public int p;
  public int q = -1;
  protected int r;
  protected int s;
  public int t = 2;
  protected int u;
  
  public VideoLayerUIBase(VideoAppInterface paramVideoAppInterface, Context paramContext, View paramView)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaLangRunnable = new VideoLayerUIBase.1(this);
    this.jdField_b_of_type_JavaLangRunnable = new VideoLayerUIBase.2(this);
    this.jdField_a_of_type_JavaLangString = (getClass().getSimpleName() + "_" + AudioHelper.b());
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "onCreate:" + this + ", VideoAppInterface:" + paramVideoAppInterface + ", rootView:" + paramView);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidViewDisplay = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362925));
    this.jdField_a_of_type_Mli = new mli(this);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Mli);
  }
  
  public static boolean a(lgf paramlgf)
  {
    return (paramlgf.jdField_d_of_type_Int == 1) || (paramlgf.jdField_d_of_type_Int == 2);
  }
  
  private void b(Observable paramObservable, Object paramObject)
  {
    Object[] arrayOfObject = (Object[])paramObject;
    switch (((Integer)arrayOfObject[0]).intValue())
    {
    default: 
      a(paramObservable, paramObject);
    }
    label154:
    label158:
    do
    {
      do
      {
        for (;;)
        {
          return;
          paramObservable = (mcp)mck.a(arrayOfObject);
          paramObject = (FaceItem)((lhw)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3)).a(paramObservable.c);
          int i;
          if ((paramObject != null) && (paramObject.isInCreative()))
          {
            i = 1;
            if ((paramObject == null) || (!paramObject.isInteract())) {
              break label154;
            }
          }
          for (int j = 1;; j = 0)
          {
            if ((!i()) && (j != 0) && (i == 0)) {
              break label158;
            }
            y();
            this.jdField_a_of_type_Mnc.a(paramObservable.a(), (ViewGroup)this.jdField_a_of_type_AndroidViewView, paramObservable);
            return;
            i = 0;
            break;
          }
        }
      } while (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3));
      y();
      paramObservable = (String)arrayOfObject[1];
      paramObject = (Boolean)arrayOfObject[2];
      this.jdField_a_of_type_Mnc.a((ViewGroup)this.jdField_a_of_type_AndroidViewView, paramObservable, paramObject.booleanValue());
      return;
    } while (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3));
    y();
    this.jdField_a_of_type_Mnc.a((ViewGroup)this.jdField_a_of_type_AndroidViewView);
  }
  
  public static boolean b(lgf paramlgf)
  {
    return (paramlgf.jdField_d_of_type_Int == 3) || (paramlgf.jdField_d_of_type_Int == 4);
  }
  
  protected int a(int paramInt)
  {
    if (this.jdField_a_of_type_ArrayOfMee == null) {
      return -1;
    }
    int i = paramInt;
    if (i < this.jdField_a_of_type_ArrayOfMee.length)
    {
      mee localmee = this.jdField_a_of_type_ArrayOfMee[i];
      j = i;
      if (!TextUtils.isEmpty(localmee.b())) {
        if (localmee.a() != 1) {
          break label94;
        }
      }
    }
    for (int j = i;; j = -1)
    {
      b("getUnusedView, start[" + paramInt + "], result_index[" + j + "]");
      return j;
      label94:
      i += 1;
      break;
    }
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int j = 0;
    int i = 1;
    int m = this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getResources().getDimensionPixelSize(2131298953);
    int k = this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getResources().getDimensionPixelSize(2131298954);
    if (paramInt4 - paramInt2 > m)
    {
      paramInt2 = 1;
      if (paramInt5 - paramInt3 <= k) {
        break label106;
      }
      paramInt4 = 1;
      label65:
      paramInt5 = h();
      if (paramInt5 != 3) {
        break label174;
      }
      if (paramInt1 != 1) {
        break label126;
      }
      paramInt3 = 3;
    }
    label106:
    label126:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            return paramInt3;
                            if (paramInt4 - paramInt2 < -m)
                            {
                              paramInt2 = 2;
                              break;
                            }
                            paramInt2 = 0;
                            break;
                            paramInt4 = j;
                            if (paramInt5 - paramInt3 >= -k) {
                              break label65;
                            }
                            paramInt4 = 2;
                            break label65;
                            if (paramInt1 == 2) {
                              return 3;
                            }
                            if (paramInt1 == 4) {
                              return 3;
                            }
                            paramInt3 = i;
                          } while (paramInt1 != 3);
                          if (paramInt2 != 2) {
                            break label164;
                          }
                          paramInt3 = i;
                        } while (paramInt4 == 2);
                        return 4;
                        if (paramInt4 == 2) {
                          return 2;
                        }
                        return 3;
                        if (paramInt5 != 2) {
                          break label235;
                        }
                        if (paramInt1 == 1) {
                          return 2;
                        }
                        if (paramInt1 == 3) {
                          return 2;
                        }
                        if (paramInt1 == 4) {
                          return 2;
                        }
                        paramInt3 = i;
                      } while (paramInt1 != 2);
                      if (paramInt2 != 2) {
                        break label225;
                      }
                      paramInt3 = i;
                    } while (paramInt4 != 1);
                    return 4;
                    if (paramInt4 == 1) {
                      return 3;
                    }
                    return 2;
                    if (paramInt5 != 1) {
                      break label299;
                    }
                    paramInt3 = i;
                  } while (paramInt1 == 2);
                  paramInt3 = i;
                } while (paramInt1 == 3);
                paramInt3 = i;
              } while (paramInt1 == 4);
              paramInt3 = i;
            } while (paramInt1 != 1);
            if (paramInt2 == 1)
            {
              if (paramInt4 == 1) {
                return 3;
              }
              return 2;
            }
            paramInt3 = i;
          } while (paramInt4 != 1);
          return 4;
          paramInt3 = i;
        } while (paramInt5 != 4);
        if (paramInt1 == 1) {
          return 4;
        }
        if (paramInt1 == 2) {
          return 4;
        }
        if (paramInt1 == 3) {
          return 4;
        }
        paramInt3 = i;
      } while (paramInt1 != 4);
      if (paramInt2 == 1)
      {
        if (paramInt4 == 2) {
          return 2;
        }
        return 3;
      }
      paramInt3 = i;
    } while (paramInt4 == 2);
    label164:
    label174:
    label225:
    label235:
    return 4;
  }
  
  protected int a(String paramString1, String paramString2, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString2))
    {
      int i = 0;
      while (i < this.jdField_a_of_type_ArrayOfMee.length)
      {
        paramString1 = this.jdField_a_of_type_ArrayOfMee[i];
        if ((paramString2.equals(paramString1.b())) && (paramInt == paramString1.h()) && (paramString1.a() == 0)) {
          return i;
        }
        i += 1;
      }
    }
    return -1;
  }
  
  public long a(String paramString)
  {
    int i = 0;
    while ((this.jdField_a_of_type_ArrayOfMee != null) && (i < this.jdField_a_of_type_ArrayOfMee.length))
    {
      mee localmee = this.jdField_a_of_type_ArrayOfMee[i];
      if ((localmee.a() == 0) && (paramString.equals(localmee.b()))) {
        return localmee.a();
      }
      i += 1;
    }
    return 0L;
  }
  
  public GLRootView a()
  {
    return this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView;
  }
  
  String a()
  {
    String str = "[" + this.jdField_a_of_type_JavaLangString + "]VideoView[5]:\r\n";
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfMee.length)
    {
      mee localmee = this.jdField_a_of_type_ArrayOfMee[i];
      str = str + "---------index[" + i + "], size[" + localmee.b() + ", " + localmee.c() + "], " + localmee.c() + "\r\n";
      i += 1;
    }
    return str;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int i = this.jdField_a_of_type_ArrayOfMee[paramInt1].d();
    int j = this.jdField_a_of_type_ArrayOfMee[paramInt2].d();
    this.jdField_a_of_type_ArrayOfMee[paramInt1].c(j);
    this.jdField_a_of_type_ArrayOfMee[paramInt2].c(i);
    Object localObject;
    String str1;
    String str2;
    label139:
    float f1;
    boolean bool1;
    float f2;
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 4)
    {
      if (paramInt1 == 0)
      {
        this.jdField_a_of_type_ArrayOfMee[paramInt1].a(ImageView.ScaleType.CENTER_CROP);
        this.jdField_a_of_type_ArrayOfMee[paramInt2].a(ImageView.ScaleType.CENTER_INSIDE);
        localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
        str1 = this.jdField_a_of_type_ArrayOfMee[paramInt1].b();
        str2 = this.jdField_a_of_type_ArrayOfMee[paramInt2].b();
        if (!((String)localObject).equals(str1)) {
          break label694;
        }
        this.jdField_a_of_type_ArrayOfMee[paramInt1].a(ImageView.ScaleType.CENTER_CROP);
        i = this.jdField_a_of_type_ArrayOfMee[paramInt1].f();
        f1 = this.jdField_a_of_type_ArrayOfMee[paramInt1].d();
        j = this.jdField_a_of_type_ArrayOfMee[paramInt1].g();
        bool1 = this.jdField_a_of_type_ArrayOfMee[paramInt1].i();
        boolean bool2 = this.jdField_a_of_type_ArrayOfMee[paramInt1].h();
        int k = this.jdField_a_of_type_ArrayOfMee[paramInt2].f();
        f2 = this.jdField_a_of_type_ArrayOfMee[paramInt2].d();
        int m = this.jdField_a_of_type_ArrayOfMee[paramInt2].g();
        boolean bool3 = this.jdField_a_of_type_ArrayOfMee[paramInt2].i();
        boolean bool4 = this.jdField_a_of_type_ArrayOfMee[paramInt2].h();
        this.jdField_a_of_type_ArrayOfMee[paramInt1].h(bool4);
        this.jdField_a_of_type_ArrayOfMee[paramInt1].k(k);
        this.jdField_a_of_type_ArrayOfMee[paramInt1].a(f2);
        this.jdField_a_of_type_ArrayOfMee[paramInt1].j(m);
        this.jdField_a_of_type_ArrayOfMee[paramInt1].j(bool3);
        this.jdField_a_of_type_ArrayOfMee[paramInt2].h(bool2);
        this.jdField_a_of_type_ArrayOfMee[paramInt2].k(i);
        this.jdField_a_of_type_ArrayOfMee[paramInt2].a(f1);
        this.jdField_a_of_type_ArrayOfMee[paramInt2].j(j);
        this.jdField_a_of_type_ArrayOfMee[paramInt2].j(bool1);
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_ArrayOfMee[paramInt1];
      this.jdField_a_of_type_ArrayOfMee[paramInt1] = this.jdField_a_of_type_ArrayOfMee[paramInt2];
      this.jdField_a_of_type_ArrayOfMee[paramInt2] = localObject;
      bool1 = this.jdField_a_of_type_ArrayOfMee[paramInt1].f();
      this.jdField_a_of_type_ArrayOfMee[paramInt1].g(bool1);
      bool1 = this.jdField_a_of_type_ArrayOfMee[paramInt2].f();
      this.jdField_a_of_type_ArrayOfMee[paramInt2].g(bool1);
      f1 = muf.a(BaseApplicationImpl.getContext(), 12.0F);
      f2 = muf.a(BaseApplicationImpl.getContext(), 18.0F);
      if (paramInt1 != 0) {
        break label719;
      }
      this.jdField_a_of_type_ArrayOfMee[paramInt1].a(f2);
      label465:
      if (paramInt2 != 0) {
        break label732;
      }
      this.jdField_a_of_type_ArrayOfMee[paramInt2].a(f2);
    }
    for (;;)
    {
      c(false);
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 2) {
        this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Boolean = k();
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 4) {
        b(this.jdField_a_of_type_ComTencentAvVideoController.a());
      }
      localObject = this.jdField_a_of_type_ArrayOfMee[paramInt1].b();
      str1 = this.jdField_a_of_type_ArrayOfMee[paramInt2].b();
      if (QLog.isColorLevel()) {
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "switchVideo, end, [" + paramInt1 + "]=[" + (String)localObject + "], [" + paramInt2 + "]=[" + str1 + "]");
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(8005), localObject, str1 });
      return;
      if (paramInt2 != 0) {
        break;
      }
      this.jdField_a_of_type_ArrayOfMee[paramInt1].a(ImageView.ScaleType.CENTER_INSIDE);
      this.jdField_a_of_type_ArrayOfMee[paramInt2].a(ImageView.ScaleType.CENTER_CROP);
      break;
      label694:
      if (!((String)localObject).equals(str2)) {
        break label139;
      }
      this.jdField_a_of_type_ArrayOfMee[paramInt2].a(ImageView.ScaleType.CENTER_CROP);
      break label139;
      label719:
      this.jdField_a_of_type_ArrayOfMee[paramInt1].a(f1);
      break label465;
      label732:
      this.jdField_a_of_type_ArrayOfMee[paramInt2].a(f1);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean) {}
  
  public void a(long paramLong, mee parammee)
  {
    if ((parammee != null) && (!parammee.c())) {
      parammee.a(paramLong, this.jdField_a_of_type_Miw.b());
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    int i = a("showNick", paramString, paramInt);
    if (i >= 0)
    {
      paramString = this.jdField_a_of_type_ArrayOfMee[i];
      if (this.jdField_a_of_type_Miw == null) {
        break label86;
      }
      if (this.jdField_a_of_type_Miw.a() != 3) {
        break label69;
      }
      paramInt = 1;
    }
    for (;;)
    {
      if ((i == 0) && (paramInt == 0))
      {
        if ((this.n != 0) && (this.o != 0))
        {
          paramString.j(false);
          return;
          label69:
          paramInt = 0;
        }
        else
        {
          paramString.j(true);
        }
      }
      else
      {
        paramString.j(true);
        return;
        label86:
        paramInt = 0;
      }
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int i = 0;
      while (i < this.jdField_a_of_type_ArrayOfMee.length)
      {
        mee localmee = this.jdField_a_of_type_ArrayOfMee[i];
        if ((paramString.equals((String)localmee.a(0))) && (localmee.a() == 0)) {
          localmee.g(paramBoolean);
        }
        i += 1;
      }
    }
  }
  
  protected void a(Observable paramObservable, Object paramObject) {}
  
  @RequiresApi(api=17)
  public void a(lqt paramlqt)
  {
    int i;
    if ((this.jdField_a_of_type_Miq != null) && (this.jdField_a_of_type_Miq.a()))
    {
      Object localObject;
      if (!this.jdField_c_of_type_Boolean)
      {
        this.jdField_c_of_type_Boolean = true;
        this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = new RenderBuffer(paramlqt.a(), paramlqt.b(), 33984);
        this.jdField_c_of_type_ComTencentTtpicOpenapiFilterTextureRender = new TextureRender();
        this.e = this.jdField_a_of_type_Miq.b();
        if (this.e)
        {
          localObject = this.jdField_a_of_type_Miq.a(paramlqt.a(), paramlqt.b(), true);
          this.jdField_a_of_type_ArrayOfFloat = new float[16];
          Matrix.setIdentityM(this.jdField_a_of_type_ArrayOfFloat, 0);
          float[] arrayOfFloat = this.jdField_a_of_type_ArrayOfFloat;
          float f1 = localObject[1];
          i = paramlqt.b();
          arrayOfFloat[5] = (f1 * 1.0F / (localObject[0] * i / paramlqt.a()));
          this.jdField_a_of_type_ArrayOfFloat[13] = (1.0F - this.jdField_a_of_type_ArrayOfFloat[5]);
        }
      }
      else
      {
        a(paramlqt, true);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glViewport(0, 0, paramlqt.a(), paramlqt.b());
        this.jdField_c_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(3553, this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId(), null, null);
        localObject = this.jdField_a_of_type_Miq;
        i = this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId();
        if (!this.e) {
          break label292;
        }
      }
      label292:
      for (paramlqt = this.jdField_a_of_type_ArrayOfFloat;; paramlqt = null)
      {
        ((miq)localObject).a(3553, i, paramlqt, null, SystemClock.elapsedRealtimeNanos());
        return;
        this.jdField_a_of_type_Miq.a(paramlqt.a(), paramlqt.b(), false);
        break;
      }
    }
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = false;
      i = this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId();
      this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.destroy();
      this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = null;
      this.jdField_c_of_type_ComTencentTtpicOpenapiFilterTextureRender.release();
      this.jdField_c_of_type_ComTencentTtpicOpenapiFilterTextureRender = null;
      this.jdField_a_of_type_ArrayOfFloat = null;
      GLES20.glDeleteTextures(1, new int[] { i }, 0);
    }
    GLES20.glBindFramebuffer(36160, 0);
    a(paramlqt, false);
    f(paramlqt);
  }
  
  protected void a(lqt paramlqt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      lgq locallgq = lgq.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      if (locallgq != null)
      {
        Object localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
        if (((lgf)localObject).jdField_d_of_type_Int == 2) {}
        for (int i = 1;; i = 0)
        {
          boolean bool = ((lgf)localObject).a.get(5);
          if ((i == 0) || (bool)) {
            break;
          }
          localObject = ((lgf)localObject).jdField_d_of_type_JavaLangString;
          int j = e();
          i = 0;
          while (i < j)
          {
            mee localmee = (mee)a(i);
            if ((localObject != null) && (((String)localObject).equals(localmee.b())))
            {
              byte[] arrayOfByte = localmee.a().c();
              locallgq.a(localmee.b(), arrayOfByte);
            }
            i += 1;
          }
        }
      }
    }
    if (this.jdField_a_of_type_Mah != null) {
      this.jdField_a_of_type_Mah.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramlqt);
    }
    if ((paramBoolean) && (this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer != null))
    {
      if (!d())
      {
        this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
        super.a(paramlqt);
        this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
        return;
      }
      super.b(true);
      super.a(paramlqt);
      super.b(false);
      return;
    }
    super.a(paramlqt);
  }
  
  public void a(miq parammiq)
  {
    this.jdField_a_of_type_Miq = parammiq;
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onLayout|left: " + paramInt1 + ", top: " + paramInt2 + ", right: " + paramInt3 + ", bottom: " + paramInt4);
    }
    c(false);
  }
  
  protected boolean a(int paramInt1, int paramInt2)
  {
    return false;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    int i = this.jdField_a_of_type_ArrayOfMee[paramInt1].d();
    int j = this.jdField_a_of_type_ArrayOfMee[paramInt2].d();
    this.jdField_a_of_type_ArrayOfMee[paramInt1].c(j);
    this.jdField_a_of_type_ArrayOfMee[paramInt2].c(i);
    Object localObject;
    String str1;
    String str2;
    label139:
    float f1;
    boolean bool1;
    float f2;
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 4)
    {
      if (paramInt1 == 0)
      {
        this.jdField_a_of_type_ArrayOfMee[paramInt1].a(ImageView.ScaleType.CENTER_CROP);
        this.jdField_a_of_type_ArrayOfMee[paramInt2].a(ImageView.ScaleType.CENTER_INSIDE);
        localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
        str1 = this.jdField_a_of_type_ArrayOfMee[paramInt1].b();
        str2 = this.jdField_a_of_type_ArrayOfMee[paramInt2].b();
        if (!((String)localObject).equals(str1)) {
          break label677;
        }
        this.jdField_a_of_type_ArrayOfMee[paramInt1].a(ImageView.ScaleType.CENTER_CROP);
        i = this.jdField_a_of_type_ArrayOfMee[paramInt1].f();
        f1 = this.jdField_a_of_type_ArrayOfMee[paramInt1].d();
        j = this.jdField_a_of_type_ArrayOfMee[paramInt1].g();
        bool1 = this.jdField_a_of_type_ArrayOfMee[paramInt1].i();
        boolean bool2 = this.jdField_a_of_type_ArrayOfMee[paramInt1].h();
        int k = this.jdField_a_of_type_ArrayOfMee[paramInt2].f();
        f2 = this.jdField_a_of_type_ArrayOfMee[paramInt2].d();
        int m = this.jdField_a_of_type_ArrayOfMee[paramInt2].g();
        boolean bool3 = this.jdField_a_of_type_ArrayOfMee[paramInt2].i();
        boolean bool4 = this.jdField_a_of_type_ArrayOfMee[paramInt2].h();
        this.jdField_a_of_type_ArrayOfMee[paramInt1].h(bool4);
        this.jdField_a_of_type_ArrayOfMee[paramInt1].k(k);
        this.jdField_a_of_type_ArrayOfMee[paramInt1].a(f2);
        this.jdField_a_of_type_ArrayOfMee[paramInt1].j(m);
        this.jdField_a_of_type_ArrayOfMee[paramInt1].j(bool3);
        this.jdField_a_of_type_ArrayOfMee[paramInt2].h(bool2);
        this.jdField_a_of_type_ArrayOfMee[paramInt2].k(i);
        this.jdField_a_of_type_ArrayOfMee[paramInt2].a(f1);
        this.jdField_a_of_type_ArrayOfMee[paramInt2].j(j);
        this.jdField_a_of_type_ArrayOfMee[paramInt2].j(bool1);
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_ArrayOfMee[paramInt1];
      this.jdField_a_of_type_ArrayOfMee[paramInt1] = this.jdField_a_of_type_ArrayOfMee[paramInt2];
      this.jdField_a_of_type_ArrayOfMee[paramInt2] = localObject;
      bool1 = this.jdField_a_of_type_ArrayOfMee[paramInt1].f();
      this.jdField_a_of_type_ArrayOfMee[paramInt1].g(bool1);
      bool1 = this.jdField_a_of_type_ArrayOfMee[paramInt2].f();
      this.jdField_a_of_type_ArrayOfMee[paramInt2].g(bool1);
      f1 = muf.a(BaseApplicationImpl.getContext(), 12.0F);
      f2 = muf.a(BaseApplicationImpl.getContext(), 18.0F);
      if (paramInt1 != 0) {
        break label702;
      }
      this.jdField_a_of_type_ArrayOfMee[paramInt1].a(f2);
      label465:
      if (paramInt2 != 0) {
        break label715;
      }
      this.jdField_a_of_type_ArrayOfMee[paramInt2].a(f2);
    }
    for (;;)
    {
      this.jdField_a_of_type_ArrayOfMee[0].a(0, 0, 0, 0);
      this.jdField_a_of_type_ArrayOfMee[0].b(0, 0, super.b(), super.c());
      this.jdField_a_of_type_ArrayOfMee[0].d(-15197410);
      h();
      localObject = this.jdField_a_of_type_ArrayOfMee[paramInt1].b();
      str1 = this.jdField_a_of_type_ArrayOfMee[paramInt2].b();
      if (QLog.isColorLevel()) {
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "swapGLVideoView, end, [" + paramInt1 + "]=[" + (String)localObject + "], [" + paramInt2 + "]=[" + str1 + "]");
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(new VideoLayerUIBase.3(this, (String)localObject, str1));
      return;
      if (paramInt2 != 0) {
        break;
      }
      this.jdField_a_of_type_ArrayOfMee[paramInt1].a(ImageView.ScaleType.CENTER_INSIDE);
      this.jdField_a_of_type_ArrayOfMee[paramInt2].a(ImageView.ScaleType.CENTER_CROP);
      break;
      label677:
      if (!((String)localObject).equals(str2)) {
        break label139;
      }
      this.jdField_a_of_type_ArrayOfMee[paramInt2].a(ImageView.ScaleType.CENTER_CROP);
      break label139;
      label702:
      this.jdField_a_of_type_ArrayOfMee[paramInt1].a(f1);
      break label465;
      label715:
      this.jdField_a_of_type_ArrayOfMee[paramInt2].a(f1);
    }
  }
  
  void b(String paramString)
  {
    if (QLog.isColorLevel())
    {
      paramString = "printGLVideoView[" + paramString + "]\r\n";
      paramString = paramString + a();
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, paramString);
    }
  }
  
  void b(lgf paramlgf)
  {
    if (paramlgf.jdField_i_of_type_Int == 3000) {
      if (k()) {
        axqw.b(null, "CliOper", "", "", "0X80041B3", "0X80041B3", 0, 0, "", "", "", "");
      }
    }
    while (paramlgf.jdField_i_of_type_Int != 1)
    {
      return;
      axqw.b(null, "CliOper", "", "", "0X80041B2", "0X80041B2", 0, 0, "", "", "", "");
      return;
    }
    if (k())
    {
      if (paramlgf.C == 10)
      {
        axqw.b(null, "CliOper", "", "", "0X8005939", "0X8005939", 0, 0, "", "", "", "");
        return;
      }
      axqw.b(null, "CliOper", "", "", "0X80046E0", "0X80046E0", 0, 0, "", "", "", "");
      return;
    }
    if (paramlgf.C == 10)
    {
      axqw.b(null, "CliOper", "", "", "0X8005938", "0X8005938", 0, 0, "", "", "", "");
      return;
    }
    axqw.b(null, "CliOper", "", "", "0X80046DF", "0X80046DF", 0, 0, "", "", "", "");
  }
  
  public boolean b(String paramString, int paramInt)
  {
    int i = a("isBigView", paramString, paramInt);
    b("isBigView, uin[" + paramString + "], videoSrcType[" + paramInt + "], result_index[" + i + "]");
    return i == 0;
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    int i = 0;
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return;
    }
    int i1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298952);
    int i2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298949);
    Rect localRect = super.b();
    int k = localRect.width() - i1;
    int j = localRect.height() - i2;
    int m = this.jdField_a_of_type_ArrayOfMee[1].b().left + paramInt1;
    paramInt2 = this.jdField_a_of_type_ArrayOfMee[1].b().top + paramInt2;
    if (m < 0)
    {
      paramInt1 = 0;
      if (paramInt2 >= 0) {
        break label146;
      }
      paramInt2 = i;
    }
    for (;;)
    {
      this.jdField_a_of_type_ArrayOfMee[1].b(paramInt1, paramInt2, paramInt1 + i1, paramInt2 + i2);
      return;
      paramInt1 = k;
      if (m > k) {
        break;
      }
      paramInt1 = m;
      break;
      label146:
      if (paramInt2 > j) {
        paramInt2 = j;
      }
    }
  }
  
  public void c(long paramLong, boolean paramBoolean)
  {
    String str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
    int i = a("onCameraOpened_" + paramBoolean, str, 1);
    if (i >= 0) {
      this.jdField_a_of_type_ArrayOfMee[i].a(paramLong, paramBoolean);
    }
  }
  
  public void c(boolean paramBoolean) {}
  
  public void d(lqt paramlqt)
  {
    int i3 = paramlqt.a();
    int i4 = paramlqt.b();
    int[] arrayOfInt = new int[4];
    int[] tmp23_21 = arrayOfInt;
    tmp23_21[0] = -1;
    int[] tmp27_23 = tmp23_21;
    tmp27_23[1] = -1;
    int[] tmp31_27 = tmp27_23;
    tmp31_27[2] = -1;
    int[] tmp35_31 = tmp31_27;
    tmp35_31[3] = -1;
    tmp35_31;
    int i = 0;
    if (this.jdField_a_of_type_Mjd != null)
    {
      this.jdField_a_of_type_Mjd.a(i3, i4);
      this.jdField_a_of_type_Mjd.a();
    }
    int i5 = e();
    int j = 0;
    Object localObject1;
    mei localmei;
    boolean bool1;
    Object localObject2;
    int i1;
    boolean bool2;
    String str;
    int m;
    int k;
    if (j < i5)
    {
      localObject1 = a(j);
      if (!((lsh)localObject1).a()) {
        break label853;
      }
      localmei = ((lsh)localObject1).a(paramlqt);
      bool1 = ((lsh)localObject1).c();
      localObject2 = ((mee)localObject1).a().c();
      i1 = 0;
      int i2 = 0;
      bool2 = ((mee)localObject1).g();
      str = null;
      m = i1;
      k = i2;
      localObject1 = str;
      if (localObject2 != null)
      {
        lpf locallpf = (lpf)lpg.a((byte[])localObject2).get(6);
        m = i1;
        k = i2;
        localObject1 = str;
        if (locallpf != null)
        {
          localObject1 = locallpf.a();
          k = (short)(localObject1[0] << 8 | localObject1[1] & 0xFF);
          m = (short)(localObject1[2] << 8 | localObject1[3] & 0xFF);
          localObject1 = FaceDetectUtil.parseOrigFaceDataModelJson(new String((byte[])localObject1, 4, localObject1.length - 4));
        }
      }
      if ((bool1) && (localObject2 != null)) {
        if (QLog.isDebugVersion())
        {
          str = this.jdField_a_of_type_JavaLangString;
          localObject2 = new StringBuilder().append("bufAll self length").append(localObject2.length).append("feature points:detectFaceHeight:=").append(k).append(",detectFaceWidth:=").append(m).append(",faceTextureWidth:=").append(localmei.b).append(",faceTextureHeight:=").append(localmei.c).append("faceModel size:=");
          if (localObject1 != null)
          {
            i1 = ((List)localObject1).size();
            label370:
            QLog.i(str, 2, i1 + ":isMirror:=" + bool2);
          }
        }
        else
        {
          label397:
          arrayOfInt[i] = localmei.a;
          if (this.jdField_a_of_type_Mjd != null) {
            this.jdField_a_of_type_Mjd.a(arrayOfInt[i], localmei.b, localmei.c, m, k, bool2, (List)localObject1, bool1);
          }
          i += 1;
        }
      }
    }
    label642:
    label663:
    label853:
    for (;;)
    {
      j += 1;
      break;
      i1 = 0;
      break label370;
      if ((localObject2 == null) || (!QLog.isDebugVersion())) {
        break label397;
      }
      str = this.jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder().append("bufAll peer length").append(localObject2.length).append("feature points:detectFaceHeight:=").append(k).append(",detectFaceWidth:=").append(m).append(",faceTextureWidth:=").append(localmei.b).append(",faceTextureHeight:=").append(localmei.c).append("faceModel size:=");
      if (localObject1 != null) {}
      for (i1 = ((List)localObject1).size();; i1 = 0)
      {
        QLog.i(str, 2, i1 + ":isMirror:=" + bool2);
        break;
      }
      paramlqt = null;
      if (this.jdField_a_of_type_Mjd != null)
      {
        bool1 = lpq.a();
        paramlqt = this.jdField_a_of_type_Mjd;
        if (bool1)
        {
          i = 720;
          if (!bool1) {
            break label756;
          }
          j = 1280;
          paramlqt = paramlqt.a(i, j);
        }
      }
      else
      {
        if (!this.jdField_b_of_type_Boolean) {
          break label763;
        }
        this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
        if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender == null) {
          this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender = new TextureRender();
        }
        if (this.jdField_b_of_type_ComTencentTtpicOpenapiFilterTextureRender == null) {
          this.jdField_b_of_type_ComTencentTtpicOpenapiFilterTextureRender = new TextureRender();
        }
        if (paramlqt == null) {
          break label782;
        }
        localObject1 = this.jdField_a_of_type_Mjd.a();
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(3553, paramlqt.getTextureId(), null, (float[])localObject1);
        paramlqt.unlock();
      }
      for (;;)
      {
        if (this.jdField_b_of_type_Boolean) {
          this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
        }
        return;
        i = 540;
        break;
        label756:
        j = 960;
        break label642;
        label763:
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glViewport(0, 0, i3, i4);
        break label663;
        if (arrayOfInt[0] != -1) {
          this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(3553, arrayOfInt[0], null, null);
        }
        if (arrayOfInt[1] != -1)
        {
          GLES20.glViewport(0, 0, 300, 300);
          this.jdField_b_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(3553, arrayOfInt[1], null, null);
          GLES20.glViewport(0, 0, i3, i4);
        }
      }
    }
  }
  
  public boolean d()
  {
    return (this.jdField_a_of_type_Mjd != null) && (this.jdField_a_of_type_Mjd.a(this.jdField_a_of_type_Miw));
  }
  
  public void e(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Mjd != null) {
      this.jdField_a_of_type_Mjd.b();
    }
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender = null;
    this.jdField_b_of_type_ComTencentTtpicOpenapiFilterTextureRender = null;
  }
  
  void f(lqt paramlqt)
  {
    if (this.jdField_b_of_type_Long == 0L) {}
    long l1;
    do
    {
      return;
      l1 = this.jdField_b_of_type_Long;
      this.jdField_b_of_type_Long = 0L;
      if ((paramlqt instanceof lqu))
      {
        Bitmap localBitmap = Bitmap.createBitmap(paramlqt.a(), paramlqt.b(), Bitmap.Config.ARGB_8888);
        long l2 = AudioHelper.c();
        paramlqt.a(localBitmap, paramlqt.a(), paramlqt.b());
        long l3 = AudioHelper.c();
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "tryScreenShot, screenShotFlag[" + l1 + "], cost_nanos[" + (l3 - l2) + "]");
        ThreadManager.getSubThreadHandler().post(new VideoLayerUIBase.4(this, localBitmap, l1));
        return;
      }
    } while (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(20001), Long.valueOf(l1), Boolean.valueOf(false), null });
  }
  
  public int g()
  {
    return this.t;
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_Mjd != null) {
      this.jdField_a_of_type_Mjd.c();
    }
  }
  
  public void g(int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvVideoController.a().M = paramInt;
  }
  
  public int h()
  {
    Rect localRect = super.b();
    int i = localRect.centerX();
    int j = localRect.centerY();
    int k = this.jdField_a_of_type_ArrayOfMee[1].b().centerX();
    int m = this.jdField_a_of_type_ArrayOfMee[1].b().centerY();
    if ((k < i) && (m < j)) {
      return 1;
    }
    if ((k < i) && (m > j)) {
      return 4;
    }
    if ((k > i) && (m < j)) {
      return 2;
    }
    if ((k > i) && (m > j)) {
      return 3;
    }
    return 0;
  }
  
  protected void h(int paramInt) {}
  
  public boolean i()
  {
    if (j()) {
      return false;
    }
    return this.jdField_a_of_type_Miw.b();
  }
  
  public boolean j()
  {
    return this.f;
  }
  
  protected boolean k()
  {
    String str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
    mee localmee = this.jdField_a_of_type_ArrayOfMee[0];
    if ((localmee.a() == 0) && (str.equals(localmee.b()))) {}
    for (boolean bool = false;; bool = true)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "isLocalFront: " + bool);
      }
      b(String.format("isLocalFront, self isLocalFront[%s]", new Object[] { Boolean.valueOf(bool) }));
      return bool;
    }
  }
  
  protected void l()
  {
    this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView = ((GLRootView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362926));
    this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView.setContentPane(this);
    this.jdField_a_of_type_Mah = this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView.a();
    if (this.jdField_a_of_type_Mah != null) {
      this.jdField_a_of_type_Mah.a(this);
    }
  }
  
  protected boolean l()
  {
    boolean bool2 = false;
    String str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.jdField_a_of_type_ArrayOfMee.length)
      {
        mee localmee = this.jdField_a_of_type_ArrayOfMee[i];
        if ((localmee.a() == 0) && (!str.equals(localmee.b()))) {
          bool1 = true;
        }
      }
      else
      {
        b("isRemoteHasVideo, peer isRemoteHasVideo[" + bool1 + "]");
        return bool1;
      }
      i += 1;
    }
  }
  
  protected void m() {}
  
  public boolean m()
  {
    int i = 0;
    boolean bool2;
    for (boolean bool1 = true;; bool1 = bool2)
    {
      bool2 = bool1;
      mee localmee;
      if (i < this.jdField_a_of_type_ArrayOfMee.length)
      {
        localmee = this.jdField_a_of_type_ArrayOfMee[i];
        bool2 = bool1;
        if (localmee.a() == 0)
        {
          bool1 = localmee.d();
          bool2 = bool1;
          if (!bool1)
          {
            QLog.d(this.jdField_a_of_type_JavaLangString, 1, "doGlassRemoteVideo failed !!!! i=" + i + ", getVisibility=" + localmee.a());
            bool2 = bool1;
          }
        }
      }
      else
      {
        if (!bool2) {
          break;
        }
        if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        }
        return false;
      }
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "doGlassRemoteVideo i=" + i + ", getVisibility=" + localmee.a());
      i += 1;
    }
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "doGlassRemoteVideo failed and cancel Glass");
    n();
    return false;
  }
  
  protected void n()
  {
    this.jdField_a_of_type_ArrayOfMee = new mee[MultiVideoCtrlLayerUIBase.b];
    int i = actn.a(71.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    if (ImmersiveUtils.isSupporImmersive() != 1) {
      i -= ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidContentContext);
    }
    for (;;)
    {
      int j = 0;
      if (j < this.jdField_a_of_type_ArrayOfMee.length)
      {
        this.jdField_a_of_type_ArrayOfMee[j] = new mee(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, String.format("%s_%s", new Object[] { this.jdField_a_of_type_JavaLangString, Integer.valueOf(j) }), this.jdField_a_of_type_ComTencentAvVideoController.g());
        this.jdField_a_of_type_ArrayOfMee[j].a(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_a_of_type_ArrayOfMee[j].a(1);
        this.jdField_a_of_type_ArrayOfMee[j].c(false);
        this.jdField_a_of_type_ArrayOfMee[j].h(2130841651);
        this.jdField_a_of_type_ArrayOfMee[j].e(this.jdField_a_of_type_Miw.b());
        if (j == 0) {
          this.jdField_a_of_type_ArrayOfMee[j].c(j * 2);
        }
        for (;;)
        {
          this.jdField_a_of_type_ArrayOfMee[j].i(i);
          a(this.jdField_a_of_type_ArrayOfMee[j]);
          j += 1;
          break;
          this.jdField_a_of_type_ArrayOfMee[j].c((this.jdField_a_of_type_ArrayOfMee.length - j) * 2);
        }
      }
      return;
    }
  }
  
  public void n(int paramInt)
  {
    int k = 0;
    int i2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298952);
    int i3 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298949);
    int i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298950);
    int j = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298951);
    if (this.o == 0) {
      j = i;
    }
    Object localObject = super.b();
    int m = this.jdField_a_of_type_ArrayOfMee[1].b().left;
    int i1 = this.jdField_a_of_type_ArrayOfMee[1].b().top;
    switch (paramInt)
    {
    default: 
      i = 0;
      j = k;
    }
    for (;;)
    {
      localObject = new VideoLayerUIBase.MoveSmallViewAnimation(this, paramInt, m, i1, i, j, null);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post((Runnable)localObject);
      return;
      j += this.n;
      continue;
      k = ((Rect)localObject).width();
      j += this.n;
      i = k - i - i2;
      continue;
      k = ((Rect)localObject).width();
      j = ((Rect)localObject).height() - j - i3;
      i = k - i - i2;
      continue;
      j = ((Rect)localObject).height() - j - i3;
    }
  }
  
  public boolean n()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfMee.length)
    {
      mee localmee = this.jdField_a_of_type_ArrayOfMee[i];
      if (localmee.a() == 0) {
        localmee.h();
      }
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "doCancelGlassRemoteVideo i=" + i + ", getVisibility=" + localmee.a());
      i += 1;
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    return false;
  }
  
  public void p()
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "onDestroy, mDestroyed[" + this.f + "]");
    }
    this.f = true;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_Mli);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView.setOnTouchListener(null);
    this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView.setContentPane(null);
    super.i();
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfMee.length)
    {
      this.jdField_a_of_type_ArrayOfMee[i].a(1);
      this.jdField_a_of_type_ArrayOfMee[i].m(true);
      this.jdField_a_of_type_ArrayOfMee[i].k(false);
      this.jdField_a_of_type_ArrayOfMee[i].g(false);
      this.jdField_a_of_type_ArrayOfMee[i].l(true);
      i += 1;
    }
    if (this.jdField_a_of_type_Mah != null) {
      this.jdField_a_of_type_Mah.b();
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView = null;
    this.jdField_a_of_type_ArrayOfMee = null;
    this.jdField_a_of_type_Mah = null;
    if (this.jdField_a_of_type_Mjd != null) {
      this.jdField_a_of_type_Mjd.b();
    }
  }
  
  public void q()
  {
    if (this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView != null) {
      this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView.onResume();
    }
    a(this.s, false);
  }
  
  protected void s() {}
  
  public void v()
  {
    if (this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView != null) {
      this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView.setVisibility(0);
    }
  }
  
  public void w()
  {
    if (this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView != null) {
      this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView.setVisibility(8);
    }
  }
  
  public void x()
  {
    if (this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView != null) {
      this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView.onPause();
    }
    if (this.jdField_a_of_type_Mah != null) {
      this.jdField_a_of_type_Mah.c();
    }
  }
  
  void y()
  {
    if (this.jdField_a_of_type_Mnc == null) {
      this.jdField_a_of_type_Mnc = new mnc(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_AndroidContentContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.ui.VideoLayerUIBase
 * JD-Core Version:    0.7.0.1
 */