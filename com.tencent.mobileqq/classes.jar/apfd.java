import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.ARRenderModel.OnlineVideoARRenderable.2;
import com.tencent.mobileqq.ar.ARRenderModel.OnlineVideoARRenderable.5;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener;
import com.tencent.superplayer.api.ISuperPlayer.OnDefinitionInfoListener;
import com.tencent.superplayer.api.ISuperPlayer.OnErrorListener;
import com.tencent.superplayer.api.ISuperPlayer.OnInfoListener;
import com.tencent.superplayer.api.ISuperPlayer.OnSeekCompleteListener;
import com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerOption;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.HashMap;

@TargetApi(11)
public class apfd
  implements SurfaceTexture.OnFrameAvailableListener, aped, ISuperPlayer.OnCompletionListener, ISuperPlayer.OnDefinitionInfoListener, ISuperPlayer.OnErrorListener, ISuperPlayer.OnInfoListener, ISuperPlayer.OnSeekCompleteListener, ISuperPlayer.OnVideoPreparedListener
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = -1L;
  private SurfaceTexture jdField_a_of_type_AndroidGraphicsSurfaceTexture;
  private Surface jdField_a_of_type_AndroidViewSurface;
  private apef jdField_a_of_type_Apef;
  private apff jdField_a_of_type_Apff;
  private apnx jdField_a_of_type_Apnx;
  private apny jdField_a_of_type_Apny = new apfe(this);
  private apoa jdField_a_of_type_Apoa;
  private volatile ISuperPlayer jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
  private Runnable jdField_a_of_type_JavaLangRunnable = new OnlineVideoARRenderable.2(this);
  private String jdField_a_of_type_JavaLangString;
  private final boolean jdField_a_of_type_Boolean = false;
  private float[] jdField_a_of_type_ArrayOfFloat = new float[16];
  private int[] jdField_a_of_type_ArrayOfInt = new int[3];
  private ByteBuffer[] jdField_a_of_type_ArrayOfJavaNioByteBuffer = new ByteBuffer[3];
  private IntBuffer[] jdField_a_of_type_ArrayOfJavaNioIntBuffer = new IntBuffer[3];
  private int jdField_b_of_type_Int;
  private apnx jdField_b_of_type_Apnx;
  private boolean jdField_b_of_type_Boolean;
  private float[] jdField_b_of_type_ArrayOfFloat = new float[16];
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = 0;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int = 1;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int = 0;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int = -1;
  private boolean jdField_g_of_type_Boolean;
  private int jdField_h_of_type_Int = -1;
  private boolean jdField_h_of_type_Boolean;
  private int jdField_i_of_type_Int = -1;
  private boolean jdField_i_of_type_Boolean;
  private boolean j;
  private boolean k;
  private boolean l = true;
  
  public apfd(apef paramapef, apff paramapff)
  {
    this.jdField_a_of_type_Apef = paramapef;
    this.jdField_a_of_type_Apff = paramapff;
    this.jdField_e_of_type_Int = paramapff.jdField_e_of_type_Int;
    this.jdField_d_of_type_Int = paramapff.jdField_d_of_type_Int;
    this.jdField_a_of_type_Apoa = paramapff.jdField_a_of_type_Apoa;
    this.jdField_a_of_type_JavaLangString = paramapff.jdField_b_of_type_JavaLangString;
    this.jdField_a_of_type_Long = paramapff.jdField_b_of_type_Long;
    boolean bool = apfl.a();
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_OnlineVideoARRenderable", 2, "Construction mSoftwarePlayConfig:false  isRubbishDevice:" + bool + "  isSoftPlay:" + this.jdField_a_of_type_Apff.jdField_a_of_type_Boolean);
    }
  }
  
  private int a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    paramInt1 -= 1;
    if (this.jdField_a_of_type_ArrayOfJavaNioIntBuffer[0] == null)
    {
      this.jdField_a_of_type_ArrayOfJavaNioIntBuffer[0] = IntBuffer.allocate(1);
      this.jdField_a_of_type_ArrayOfJavaNioIntBuffer[1] = IntBuffer.allocate(1);
      this.jdField_a_of_type_ArrayOfJavaNioIntBuffer[2] = IntBuffer.allocate(1);
    }
    this.jdField_a_of_type_ArrayOfJavaNioIntBuffer[paramInt1].clear();
    GLES20.glGenTextures(1, this.jdField_a_of_type_ArrayOfJavaNioIntBuffer[paramInt1]);
    int m = this.jdField_a_of_type_ArrayOfJavaNioIntBuffer[paramInt1].get();
    GLES20.glBindTexture(3553, m);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    if ((this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[paramInt1] == null) || (this.jdField_a_of_type_ArrayOfInt[paramInt1] != paramArrayOfByte.length)) {}
    try
    {
      this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[paramInt1] = ByteBuffer.allocateDirect(paramArrayOfByte.length);
      this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[paramInt1].order(ByteOrder.nativeOrder());
      this.jdField_a_of_type_ArrayOfInt[paramInt1] = paramArrayOfByte.length;
      this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[paramInt1].put(paramArrayOfByte);
      this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[paramInt1].position(0);
      GLES20.glTexImage2D(3553, 0, 6409, paramInt2, paramInt3, 0, 6409, 5121, this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[paramInt1]);
      return m;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("AREngine_OnlineVideoARRenderable", 2, "textureYUV, exception=" + localThrowable.getMessage());
          localThrowable.printStackTrace();
        }
      }
    }
  }
  
  private void a()
  {
    QLog.d("AREngine_OnlineVideoARRenderable", 1, "initGl");
    Matrix.setIdentityM(this.jdField_b_of_type_ArrayOfFloat, 0);
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, arrayOfInt, 0);
    this.jdField_a_of_type_Int = arrayOfInt[0];
    QLog.d("AREngine_OnlineVideoARRenderable", 1, "initGl, mTextureID=" + this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Int == 0) {
      return;
    }
    a(false);
  }
  
  private void a(String paramString)
  {
    paramString = SuperPlayerFactory.createVideoInfoForUrl(paramString, 101, MD5Utils.toMD5(paramString));
    SuperPlayerOption localSuperPlayerOption = SuperPlayerOption.obtain();
    localSuperPlayerOption.enableCodecReuse = false;
    localSuperPlayerOption.isPrePlay = false;
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.openMediaPlayer(BaseApplicationImpl.getContext(), paramString, 0L, localSuperPlayerOption);
  }
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(apel paramapel)
  {
    a((float[])paramapel.a("TARGET_SIZE"), (float[])paramapel.a("POSE"), (float[])paramapel.a("CAMERA_MATRIX"), (float[])paramapel.a("CAMERA_POSITION"));
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.jdField_b_of_type_Apnx == null)
      {
        this.jdField_b_of_type_Apnx = apnz.a(this.jdField_a_of_type_Apoa, 3);
        this.jdField_b_of_type_Apnx.a(apfl.jdField_b_of_type_ArrayOfFloat, apfl.jdField_a_of_type_ArrayOfShort);
        this.jdField_b_of_type_Apnx.a("uniform int uDisplayType;\n", null, "    if(uDisplayType == 1){\n        // 需要渲染成圆形\n        float x = vTextureCoord.x;\n        float y = vTextureCoord.y;\n        // 圆心(0.5, 0.5), 0.25=0.5*0.5\n        if(pow(abs(x-0.5), 2.0) + pow(abs(y-0.5), 2.0) >= 0.25) {\n            gl_FragColor[3] = 0.0;\n        }\n    }\n", this.jdField_a_of_type_Apny);
        this.jdField_b_of_type_Apnx.a(this.jdField_a_of_type_Apff.jdField_c_of_type_Int, this.jdField_a_of_type_Apff.jdField_a_of_type_Float, this.jdField_a_of_type_Apff.jdField_b_of_type_Float, this.jdField_a_of_type_Apff.jdField_c_of_type_Float);
      }
    }
    while (this.jdField_a_of_type_Apnx != null) {
      return;
    }
    this.jdField_a_of_type_Apnx = apnz.a(this.jdField_a_of_type_Apoa, 1);
    this.jdField_a_of_type_Apnx.a(apfl.jdField_a_of_type_ArrayOfFloat, apfl.jdField_a_of_type_ArrayOfShort);
    this.jdField_a_of_type_Apnx.a("uniform int uDisplayType;\n", null, "    if(uDisplayType == 1){\n        // 需要渲染成圆形\n        float x = vTextureCoord.x;\n        float y = vTextureCoord.y;\n        // 圆心(0.5, 0.5), 0.25=0.5*0.5\n        if(pow(abs(x-0.5), 2.0) + pow(abs(y-0.5), 2.0) >= 0.25) {\n            gl_FragColor[3] = 0.0;\n        }\n    }\n", this.jdField_a_of_type_Apny);
    this.jdField_a_of_type_Apnx.a(this.jdField_a_of_type_Apff.jdField_c_of_type_Int, this.jdField_a_of_type_Apff.jdField_a_of_type_Float, this.jdField_a_of_type_Apff.jdField_b_of_type_Float, this.jdField_a_of_type_Apff.jdField_c_of_type_Float);
  }
  
  public void a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3, float[] paramArrayOfFloat4)
  {
    if ((!this.jdField_e_of_type_Boolean) || (paramArrayOfFloat2 == null) || (this.jdField_a_of_type_Apff == null)) {
      return;
    }
    GLES20.glBlendFunc(770, 771);
    GLES20.glEnable(3042);
    label54:
    int m;
    if (this.jdField_a_of_type_Apff.jdField_b_of_type_Int == 1)
    {
      paramArrayOfFloat1 = a(paramArrayOfFloat1, paramArrayOfFloat3, paramArrayOfFloat4);
      if (this.jdField_i_of_type_Boolean) {
        break label167;
      }
      if (this.jdField_a_of_type_Apnx == null) {
        a(this.jdField_i_of_type_Boolean);
      }
      if (this.jdField_a_of_type_Apnx != null)
      {
        paramArrayOfFloat2 = this.jdField_a_of_type_Apnx;
        m = this.jdField_a_of_type_Int;
        paramArrayOfFloat3 = this.jdField_a_of_type_Apoa;
        paramArrayOfFloat4 = this.jdField_b_of_type_ArrayOfFloat;
        paramArrayOfFloat2.a(new int[] { m }, paramArrayOfFloat3, paramArrayOfFloat1, paramArrayOfFloat4);
      }
    }
    for (;;)
    {
      GLES20.glDisable(3042);
      GLES20.glBindTexture(3553, 0);
      GLES20.glBindTexture(36197, 0);
      if (!this.l) {
        break;
      }
      this.l = false;
      return;
      paramArrayOfFloat1 = a(paramArrayOfFloat1, paramArrayOfFloat2, paramArrayOfFloat4);
      break label54;
      label167:
      if (this.jdField_b_of_type_Apnx == null) {
        a(this.jdField_i_of_type_Boolean);
      }
      Matrix.setIdentityM(this.jdField_b_of_type_ArrayOfFloat, 0);
      if (this.jdField_b_of_type_Apnx != null)
      {
        paramArrayOfFloat2 = this.jdField_b_of_type_Apnx;
        m = this.jdField_g_of_type_Int;
        int n = this.jdField_h_of_type_Int;
        int i1 = this.jdField_i_of_type_Int;
        paramArrayOfFloat3 = this.jdField_a_of_type_Apoa;
        paramArrayOfFloat4 = this.jdField_b_of_type_ArrayOfFloat;
        paramArrayOfFloat2.a(new int[] { m, n, i1 }, paramArrayOfFloat3, paramArrayOfFloat1, paramArrayOfFloat4);
      }
    }
  }
  
  public float[] a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3)
  {
    Matrix.setIdentityM(this.jdField_a_of_type_ArrayOfFloat, 0);
    if (c() == 2) {
      if (this.jdField_a_of_type_Apff.jdField_a_of_type_Aphz != null)
      {
        Matrix.scaleM(this.jdField_a_of_type_ArrayOfFloat, 0, this.jdField_a_of_type_Apff.jdField_a_of_type_Aphz.jdField_a_of_type_Float * paramArrayOfFloat1[0], this.jdField_a_of_type_Apff.jdField_a_of_type_Aphz.jdField_b_of_type_Float * paramArrayOfFloat1[1], 1.0F);
        Matrix.translateM(this.jdField_a_of_type_ArrayOfFloat, 0, this.jdField_a_of_type_Apff.jdField_a_of_type_Aphz.jdField_c_of_type_Float, this.jdField_a_of_type_Apff.jdField_a_of_type_Aphz.d, this.jdField_a_of_type_Apff.jdField_a_of_type_Aphz.e);
      }
    }
    for (;;)
    {
      return this.jdField_a_of_type_ArrayOfFloat;
      if ((paramArrayOfFloat2 != null) && (paramArrayOfFloat3 != null)) {
        break;
      }
      this.jdField_a_of_type_ArrayOfFloat = new float[16];
    }
    if (this.jdField_a_of_type_Apff.jdField_c_of_type_Int == 1) {}
    for (;;)
    {
      Matrix.multiplyMM(this.jdField_a_of_type_ArrayOfFloat, 0, paramArrayOfFloat2, 0, this.jdField_a_of_type_ArrayOfFloat, 0);
      Matrix.multiplyMM(this.jdField_a_of_type_ArrayOfFloat, 0, paramArrayOfFloat3, 0, this.jdField_a_of_type_ArrayOfFloat, 0);
      break;
      Matrix.scaleM(this.jdField_a_of_type_ArrayOfFloat, 0, paramArrayOfFloat1[0], paramArrayOfFloat1[1], 1.0F);
    }
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Apff != null) {
      return this.jdField_a_of_type_Apff.jdField_a_of_type_Int;
    }
    return 4;
  }
  
  public int c()
  {
    if (this.jdField_a_of_type_Apff != null) {
      return this.jdField_a_of_type_Apff.jdField_b_of_type_Int;
    }
    return 0;
  }
  
  public String c()
  {
    return this.jdField_a_of_type_Apff.jdField_a_of_type_JavaLangString;
  }
  
  @TargetApi(11)
  public void c()
  {
    QLog.d("AREngine_OnlineVideoARRenderable", 1, "init, mHasSDKInit=" + this.jdField_b_of_type_Boolean);
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    a();
    QLog.d("AREngine_OnlineVideoARRenderable", 1, "initSDK");
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = new SurfaceTexture(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.setOnFrameAvailableListener(this);
    this.jdField_a_of_type_AndroidViewSurface = new Surface(this.jdField_a_of_type_AndroidGraphicsSurfaceTexture);
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer = SuperPlayerFactory.createMediaPlayer(BaseApplicationImpl.getContext(), 108, null);
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setSurface(this.jdField_a_of_type_AndroidViewSurface);
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnVideoPreparedListener(this);
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnInfoListener(this);
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnErrorListener(this);
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnDefinitionInfoListener(this);
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnCompletionListener(this);
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnSeekCompleteListener(this);
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_OnlineVideoARRenderable", 2, "start, arResourceInfo=" + this.jdField_a_of_type_Apff);
    }
    if ((this.j) || (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer == null) || (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.isPlaying())) {
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_OnlineVideoARRenderable", 2, "start, mMediaPlayer == null || mMediaPlayer.isPlaying()");
      }
    }
    do
    {
      return;
      if ((this.jdField_a_of_type_Long >= 0L) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("AREngine_OnlineVideoARRenderable", 2, "start, mVideoSize < 0 || TextUtils.isEmpty(mVideoUrl)");
    return;
    if (!this.jdField_b_of_type_Boolean)
    {
      QLog.d("AREngine_OnlineVideoARRenderable", 1, "init failed");
      return;
    }
    this.jdField_c_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_c_of_type_Int = 1;
    this.jdField_f_of_type_Int = 0;
    this.k = false;
    this.jdField_d_of_type_Boolean = true;
    this.j = true;
    String str = appb.a(this.jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_OnlineVideoARRenderable", 2, "start, video dir=" + str + ", mSoftwarePlayConfig=" + false);
    }
    a(this.jdField_a_of_type_JavaLangString);
  }
  
  public boolean d()
  {
    return (this.jdField_b_of_type_Boolean) && (this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) && ((this.jdField_f_of_type_Boolean) || (this.jdField_g_of_type_Boolean) || (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.isPlaying()));
  }
  
  public void e() {}
  
  public boolean e()
  {
    return this.jdField_e_of_type_Boolean;
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_OnlineVideoARRenderable", 2, "onDestroy");
    }
    this.jdField_d_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_i_of_type_Boolean = false;
    this.jdField_c_of_type_Int = 1;
    this.j = false;
    this.jdField_h_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.stop();
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.release();
      if (this.jdField_a_of_type_Apnx != null)
      {
        this.jdField_a_of_type_Apnx.b();
        this.jdField_a_of_type_Apnx = null;
      }
      if (this.jdField_b_of_type_Apnx != null)
      {
        this.jdField_b_of_type_Apnx.b();
        this.jdField_b_of_type_Apnx = null;
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("decode_type", String.valueOf(this.jdField_f_of_type_Int));
      StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance("", "immersed_ar_decode_type", true, 0L, 0L, localHashMap, "", false);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d("AREngine_OnlineVideoARRenderable", 1, "onDestroy exception, msg=" + localException.getMessage());
        if (QLog.isColorLevel()) {
          localException.printStackTrace();
        }
        if (this.jdField_a_of_type_Apef != null) {
          this.jdField_a_of_type_Apef.a(this.jdField_a_of_type_Apff.jdField_a_of_type_JavaLangString);
        }
      }
    }
  }
  
  public void onCompletion(ISuperPlayer paramISuperPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_OnlineVideoARRenderable", 2, "onCompletion");
    }
    if (this.jdField_a_of_type_Apef != null) {
      this.jdField_a_of_type_Apef.b(2, this.jdField_e_of_type_Int - this.jdField_c_of_type_Int);
    }
    if (this.jdField_c_of_type_Int >= this.jdField_e_of_type_Int)
    {
      this.jdField_f_of_type_Boolean = true;
      this.jdField_g_of_type_Boolean = false;
    }
    do
    {
      return;
      paramISuperPlayer = new OnlineVideoARRenderable.5(this);
    } while (this.jdField_a_of_type_Apef == null);
    this.jdField_a_of_type_Apef.a(paramISuperPlayer);
  }
  
  public void onDefinitionInfoUpdate(ISuperPlayer paramISuperPlayer, String paramString, ArrayList<String> paramArrayList) {}
  
  public boolean onError(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    if (this.jdField_a_of_type_Apef != null) {
      this.jdField_a_of_type_Apef.a(this.jdField_a_of_type_Apff.jdField_a_of_type_JavaLangString);
    }
    f();
    return false;
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    this.jdField_e_of_type_Boolean = true;
    this.jdField_a_of_type_Apef.a(this.jdField_a_of_type_JavaLangRunnable);
    if (!this.k)
    {
      this.k = true;
      this.jdField_f_of_type_Int = 1;
    }
  }
  
  public boolean onInfo(ISuperPlayer paramISuperPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    return false;
  }
  
  public void onSeekComplete(ISuperPlayer paramISuperPlayer)
  {
    QLog.d("AREngine_OnlineVideoARRenderable", 1, "onSeekComplete");
    paramISuperPlayer.start();
  }
  
  public void onVideoPrepared(ISuperPlayer paramISuperPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_OnlineVideoARRenderable", 2, "onVideoPrepared. mCanPlay=" + this.jdField_d_of_type_Boolean);
    }
    if (!this.jdField_d_of_type_Boolean) {}
    for (;;)
    {
      return;
      if (this.jdField_h_of_type_Boolean)
      {
        this.jdField_h_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.start();
        return;
      }
      this.jdField_c_of_type_Boolean = true;
      try
      {
        this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.start();
        this.jdField_g_of_type_Boolean = true;
        if (this.jdField_a_of_type_Apef != null)
        {
          this.jdField_a_of_type_Apef.b(0, this.jdField_e_of_type_Int);
          return;
        }
      }
      catch (Exception paramISuperPlayer)
      {
        QLog.d("AREngine_OnlineVideoARRenderable", 1, "onVideoPrepared, exception=" + paramISuperPlayer.getMessage());
        if (QLog.isColorLevel()) {
          paramISuperPlayer.printStackTrace();
        }
        f();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apfd
 * JD-Core Version:    0.7.0.1
 */