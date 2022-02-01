package android.support.v8.renderscript;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.SystemProperties;
import android.util.Log;
import java.io.File;
import java.lang.reflect.Method;

public class RenderScript
{
  private static final String CACHE_PATH = "com.android.renderscript.cache";
  static final boolean DEBUG = false;
  static final boolean LOG_ENABLED = false;
  static final String LOG_TAG = "RenderScript_jni";
  static boolean isNative = false;
  static Object lock = new Object();
  static String mCachePath;
  static Method registerNativeAllocation;
  static Method registerNativeFree;
  static boolean sInitialized;
  static Object sRuntime;
  static boolean sUseGCHooks;
  private static int thunk = 0;
  private Context mApplicationContext;
  int mContext;
  int mDev;
  Element mElement_ALLOCATION;
  Element mElement_A_8;
  Element mElement_BOOLEAN;
  Element mElement_CHAR_2;
  Element mElement_CHAR_3;
  Element mElement_CHAR_4;
  Element mElement_DOUBLE_2;
  Element mElement_DOUBLE_3;
  Element mElement_DOUBLE_4;
  Element mElement_ELEMENT;
  Element mElement_F32;
  Element mElement_F64;
  Element mElement_FLOAT_2;
  Element mElement_FLOAT_3;
  Element mElement_FLOAT_4;
  Element mElement_I16;
  Element mElement_I32;
  Element mElement_I64;
  Element mElement_I8;
  Element mElement_INT_2;
  Element mElement_INT_3;
  Element mElement_INT_4;
  Element mElement_LONG_2;
  Element mElement_LONG_3;
  Element mElement_LONG_4;
  Element mElement_MATRIX_2X2;
  Element mElement_MATRIX_3X3;
  Element mElement_MATRIX_4X4;
  Element mElement_RGBA_4444;
  Element mElement_RGBA_5551;
  Element mElement_RGBA_8888;
  Element mElement_RGB_565;
  Element mElement_RGB_888;
  Element mElement_SAMPLER;
  Element mElement_SCRIPT;
  Element mElement_SHORT_2;
  Element mElement_SHORT_3;
  Element mElement_SHORT_4;
  Element mElement_TYPE;
  Element mElement_U16;
  Element mElement_U32;
  Element mElement_U64;
  Element mElement_U8;
  Element mElement_UCHAR_2;
  Element mElement_UCHAR_3;
  Element mElement_UCHAR_4;
  Element mElement_UINT_2;
  Element mElement_UINT_3;
  Element mElement_UINT_4;
  Element mElement_ULONG_2;
  Element mElement_ULONG_3;
  Element mElement_ULONG_4;
  Element mElement_USHORT_2;
  Element mElement_USHORT_3;
  Element mElement_USHORT_4;
  RenderScript.RSErrorHandler mErrorCallback = null;
  RenderScript.RSMessageHandler mMessageCallback = null;
  RenderScript.MessageThread mMessageThread;
  Sampler mSampler_CLAMP_LINEAR;
  Sampler mSampler_CLAMP_LINEAR_MIP_LINEAR;
  Sampler mSampler_CLAMP_NEAREST;
  Sampler mSampler_MIRRORED_REPEAT_LINEAR;
  Sampler mSampler_MIRRORED_REPEAT_LINEAR_MIP_LINEAR;
  Sampler mSampler_MIRRORED_REPEAT_NEAREST;
  Sampler mSampler_WRAP_LINEAR;
  Sampler mSampler_WRAP_LINEAR_MIP_LINEAR;
  Sampler mSampler_WRAP_NEAREST;
  
  RenderScript(Context paramContext)
  {
    if (paramContext != null) {
      this.mApplicationContext = paramContext.getApplicationContext();
    }
  }
  
  public static RenderScript create(Context paramContext)
  {
    return create(paramContext, RenderScript.ContextType.NORMAL);
  }
  
  public static RenderScript create(Context paramContext, int paramInt)
  {
    return create(paramContext, paramInt, RenderScript.ContextType.NORMAL);
  }
  
  public static RenderScript create(Context arg0, int paramInt, RenderScript.ContextType paramContextType)
  {
    Object localObject = new RenderScript(???);
    if (shouldThunk())
    {
      Log.v("RenderScript_jni", "RS native mode");
      return RenderScriptThunker.create(???, paramInt);
    }
    synchronized (lock)
    {
      boolean bool = sInitialized;
      if (!bool) {}
      try
      {
        Class localClass = Class.forName("dalvik.system.VMRuntime");
        sRuntime = localClass.getDeclaredMethod("getRuntime", new Class[0]).invoke(null, new Object[0]);
        registerNativeAllocation = localClass.getDeclaredMethod("registerNativeAllocation", new Class[] { Integer.TYPE });
        registerNativeFree = localClass.getDeclaredMethod("registerNativeFree", new Class[] { Integer.TYPE });
        sUseGCHooks = true;
      }
      catch (Exception localException)
      {
        label120:
        break label120;
      }
      Log.e("RenderScript_jni", "No GC methods");
      sUseGCHooks = false;
      try
      {
        System.loadLibrary("RSSupport");
        System.loadLibrary("rsjni");
        sInitialized = true;
      }
      catch (UnsatisfiedLinkError paramContextType)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Error loading RS jni library: ");
        ((StringBuilder)localObject).append(paramContextType);
        Log.e("RenderScript_jni", ((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Error loading RS jni library: ");
        ((StringBuilder)localObject).append(paramContextType);
        throw new RSRuntimeException(((StringBuilder)localObject).toString());
      }
      Log.v("RenderScript_jni", "RS compat mode");
      ((RenderScript)localObject).mDev = ((RenderScript)localObject).nDeviceCreate();
      ((RenderScript)localObject).mContext = ((RenderScript)localObject).nContextCreate(((RenderScript)localObject).mDev, 0, paramInt, paramContextType.mID);
      if (((RenderScript)localObject).mContext != 0)
      {
        ((RenderScript)localObject).mMessageThread = new RenderScript.MessageThread((RenderScript)localObject);
        ((RenderScript)localObject).mMessageThread.start();
        return localObject;
      }
      throw new RSDriverException("Failed to create RS context.");
    }
  }
  
  public static RenderScript create(Context paramContext, RenderScript.ContextType paramContextType)
  {
    return create(paramContext, paramContext.getApplicationInfo().targetSdkVersion, paramContextType);
  }
  
  public static void setupDiskCache(File paramFile)
  {
    paramFile = new File(paramFile, "com.android.renderscript.cache");
    mCachePath = paramFile.getAbsolutePath();
    paramFile.mkdirs();
  }
  
  static boolean shouldThunk()
  {
    if (thunk == 0) {
      if ((Build.VERSION.SDK_INT >= 18) && (SystemProperties.getInt("debug.rs.forcecompat", 0) == 0)) {
        thunk = 1;
      } else {
        thunk = -1;
      }
    }
    return thunk == 1;
  }
  
  public void contextDump()
  {
    validate();
    nContextDump(0);
  }
  
  public void destroy()
  {
    validate();
    nContextDeinitToClient(this.mContext);
    RenderScript.MessageThread localMessageThread = this.mMessageThread;
    localMessageThread.mRun = false;
    try
    {
      localMessageThread.join();
      label26:
      nContextDestroy();
      this.mContext = 0;
      nDeviceDestroy(this.mDev);
      this.mDev = 0;
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label26;
    }
  }
  
  public void finish()
  {
    nContextFinish();
  }
  
  public final Context getApplicationContext()
  {
    return this.mApplicationContext;
  }
  
  public RenderScript.RSErrorHandler getErrorHandler()
  {
    return this.mErrorCallback;
  }
  
  public RenderScript.RSMessageHandler getMessageHandler()
  {
    return this.mMessageCallback;
  }
  
  boolean isAlive()
  {
    return this.mContext != 0;
  }
  
  void nAllocationCopyFromBitmap(int paramInt, Bitmap paramBitmap)
  {
    try
    {
      validate();
      rsnAllocationCopyFromBitmap(this.mContext, paramInt, paramBitmap);
      return;
    }
    finally
    {
      paramBitmap = finally;
      throw paramBitmap;
    }
  }
  
  void nAllocationCopyToBitmap(int paramInt, Bitmap paramBitmap)
  {
    try
    {
      validate();
      rsnAllocationCopyToBitmap(this.mContext, paramInt, paramBitmap);
      return;
    }
    finally
    {
      paramBitmap = finally;
      throw paramBitmap;
    }
  }
  
  int nAllocationCreateBitmapBackedAllocation(int paramInt1, int paramInt2, Bitmap paramBitmap, int paramInt3)
  {
    try
    {
      validate();
      paramInt1 = rsnAllocationCreateBitmapBackedAllocation(this.mContext, paramInt1, paramInt2, paramBitmap, paramInt3);
      return paramInt1;
    }
    finally
    {
      paramBitmap = finally;
      throw paramBitmap;
    }
  }
  
  int nAllocationCreateBitmapRef(int paramInt, Bitmap paramBitmap)
  {
    try
    {
      validate();
      paramInt = rsnAllocationCreateBitmapRef(this.mContext, paramInt, paramBitmap);
      return paramInt;
    }
    finally
    {
      paramBitmap = finally;
      throw paramBitmap;
    }
  }
  
  int nAllocationCreateFromAssetStream(int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      validate();
      paramInt1 = rsnAllocationCreateFromAssetStream(this.mContext, paramInt1, paramInt2, paramInt3);
      return paramInt1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  int nAllocationCreateFromBitmap(int paramInt1, int paramInt2, Bitmap paramBitmap, int paramInt3)
  {
    try
    {
      validate();
      paramInt1 = rsnAllocationCreateFromBitmap(this.mContext, paramInt1, paramInt2, paramBitmap, paramInt3);
      return paramInt1;
    }
    finally
    {
      paramBitmap = finally;
      throw paramBitmap;
    }
  }
  
  int nAllocationCreateTyped(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    try
    {
      validate();
      paramInt1 = rsnAllocationCreateTyped(this.mContext, paramInt1, paramInt2, paramInt3, paramInt4);
      return paramInt1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  int nAllocationCubeCreateFromBitmap(int paramInt1, int paramInt2, Bitmap paramBitmap, int paramInt3)
  {
    try
    {
      validate();
      paramInt1 = rsnAllocationCubeCreateFromBitmap(this.mContext, paramInt1, paramInt2, paramBitmap, paramInt3);
      return paramInt1;
    }
    finally
    {
      paramBitmap = finally;
      throw paramBitmap;
    }
  }
  
  void nAllocationData1D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte, int paramInt5)
  {
    try
    {
      validate();
      rsnAllocationData1D(this.mContext, paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfByte, paramInt5);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  void nAllocationData1D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float[] paramArrayOfFloat, int paramInt5)
  {
    try
    {
      validate();
      rsnAllocationData1D(this.mContext, paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfFloat, paramInt5);
      return;
    }
    finally
    {
      paramArrayOfFloat = finally;
      throw paramArrayOfFloat;
    }
  }
  
  void nAllocationData1D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt, int paramInt5)
  {
    try
    {
      validate();
      rsnAllocationData1D(this.mContext, paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt, paramInt5);
      return;
    }
    finally
    {
      paramArrayOfInt = finally;
      throw paramArrayOfInt;
    }
  }
  
  void nAllocationData1D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, short[] paramArrayOfShort, int paramInt5)
  {
    try
    {
      validate();
      rsnAllocationData1D(this.mContext, paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfShort, paramInt5);
      return;
    }
    finally
    {
      paramArrayOfShort = finally;
      throw paramArrayOfShort;
    }
  }
  
  void nAllocationData2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12)
  {
    try
    {
      validate();
      rsnAllocationData2D(this.mContext, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramInt11, paramInt12);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  void nAllocationData2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, byte[] paramArrayOfByte, int paramInt8)
  {
    try
    {
      validate();
      rsnAllocationData2D(this.mContext, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramArrayOfByte, paramInt8);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  void nAllocationData2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float[] paramArrayOfFloat, int paramInt8)
  {
    try
    {
      validate();
      rsnAllocationData2D(this.mContext, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramArrayOfFloat, paramInt8);
      return;
    }
    finally
    {
      paramArrayOfFloat = finally;
      throw paramArrayOfFloat;
    }
  }
  
  void nAllocationData2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int[] paramArrayOfInt, int paramInt8)
  {
    try
    {
      validate();
      rsnAllocationData2D(this.mContext, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramArrayOfInt, paramInt8);
      return;
    }
    finally
    {
      paramArrayOfInt = finally;
      throw paramArrayOfInt;
    }
  }
  
  void nAllocationData2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, short[] paramArrayOfShort, int paramInt8)
  {
    try
    {
      validate();
      rsnAllocationData2D(this.mContext, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramArrayOfShort, paramInt8);
      return;
    }
    finally
    {
      paramArrayOfShort = finally;
      throw paramArrayOfShort;
    }
  }
  
  void nAllocationData2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, Bitmap paramBitmap)
  {
    try
    {
      validate();
      rsnAllocationData2D(this.mContext, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramBitmap);
      return;
    }
    finally
    {
      paramBitmap = finally;
      throw paramBitmap;
    }
  }
  
  void nAllocationData3D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, int paramInt13)
  {
    try
    {
      validate();
      rsnAllocationData3D(this.mContext, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramInt11, paramInt12, paramInt13);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  void nAllocationData3D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, byte[] paramArrayOfByte, int paramInt9)
  {
    try
    {
      validate();
      rsnAllocationData3D(this.mContext, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramArrayOfByte, paramInt9);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  void nAllocationData3D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, float[] paramArrayOfFloat, int paramInt9)
  {
    try
    {
      validate();
      rsnAllocationData3D(this.mContext, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramArrayOfFloat, paramInt9);
      return;
    }
    finally
    {
      paramArrayOfFloat = finally;
      throw paramArrayOfFloat;
    }
  }
  
  void nAllocationData3D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int[] paramArrayOfInt, int paramInt9)
  {
    try
    {
      validate();
      rsnAllocationData3D(this.mContext, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramArrayOfInt, paramInt9);
      return;
    }
    finally
    {
      paramArrayOfInt = finally;
      throw paramArrayOfInt;
    }
  }
  
  void nAllocationData3D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, short[] paramArrayOfShort, int paramInt9)
  {
    try
    {
      validate();
      rsnAllocationData3D(this.mContext, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramArrayOfShort, paramInt9);
      return;
    }
    finally
    {
      paramArrayOfShort = finally;
      throw paramArrayOfShort;
    }
  }
  
  void nAllocationElementData1D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte, int paramInt5)
  {
    try
    {
      validate();
      rsnAllocationElementData1D(this.mContext, paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfByte, paramInt5);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  void nAllocationGenerateMipmaps(int paramInt)
  {
    try
    {
      validate();
      rsnAllocationGenerateMipmaps(this.mContext, paramInt);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  int nAllocationGetType(int paramInt)
  {
    try
    {
      validate();
      paramInt = rsnAllocationGetType(this.mContext, paramInt);
      return paramInt;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  void nAllocationIoReceive(int paramInt)
  {
    try
    {
      validate();
      rsnAllocationIoReceive(this.mContext, paramInt);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  void nAllocationIoSend(int paramInt)
  {
    try
    {
      validate();
      rsnAllocationIoSend(this.mContext, paramInt);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  void nAllocationRead(int paramInt, byte[] paramArrayOfByte)
  {
    try
    {
      validate();
      rsnAllocationRead(this.mContext, paramInt, paramArrayOfByte);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  void nAllocationRead(int paramInt, float[] paramArrayOfFloat)
  {
    try
    {
      validate();
      rsnAllocationRead(this.mContext, paramInt, paramArrayOfFloat);
      return;
    }
    finally
    {
      paramArrayOfFloat = finally;
      throw paramArrayOfFloat;
    }
  }
  
  void nAllocationRead(int paramInt, int[] paramArrayOfInt)
  {
    try
    {
      validate();
      rsnAllocationRead(this.mContext, paramInt, paramArrayOfInt);
      return;
    }
    finally
    {
      paramArrayOfInt = finally;
      throw paramArrayOfInt;
    }
  }
  
  void nAllocationRead(int paramInt, short[] paramArrayOfShort)
  {
    try
    {
      validate();
      rsnAllocationRead(this.mContext, paramInt, paramArrayOfShort);
      return;
    }
    finally
    {
      paramArrayOfShort = finally;
      throw paramArrayOfShort;
    }
  }
  
  void nAllocationResize1D(int paramInt1, int paramInt2)
  {
    try
    {
      validate();
      rsnAllocationResize1D(this.mContext, paramInt1, paramInt2);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  void nAllocationResize2D(int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      validate();
      rsnAllocationResize2D(this.mContext, paramInt1, paramInt2, paramInt3);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  void nAllocationSyncAll(int paramInt1, int paramInt2)
  {
    try
    {
      validate();
      rsnAllocationSyncAll(this.mContext, paramInt1, paramInt2);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  int nContextCreate(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    try
    {
      paramInt1 = rsnContextCreate(paramInt1, paramInt2, paramInt3, paramInt4);
      return paramInt1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  native void nContextDeinitToClient(int paramInt);
  
  void nContextDestroy()
  {
    try
    {
      validate();
      rsnContextDestroy(this.mContext);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  void nContextDump(int paramInt)
  {
    try
    {
      validate();
      rsnContextDump(this.mContext, paramInt);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  void nContextFinish()
  {
    try
    {
      validate();
      rsnContextFinish(this.mContext);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  native String nContextGetErrorMessage(int paramInt);
  
  native int nContextGetUserMessage(int paramInt, int[] paramArrayOfInt);
  
  native void nContextInitToClient(int paramInt);
  
  native int nContextPeekMessage(int paramInt, int[] paramArrayOfInt);
  
  void nContextSendMessage(int paramInt, int[] paramArrayOfInt)
  {
    try
    {
      validate();
      rsnContextSendMessage(this.mContext, paramInt, paramArrayOfInt);
      return;
    }
    finally
    {
      paramArrayOfInt = finally;
      throw paramArrayOfInt;
    }
  }
  
  void nContextSetPriority(int paramInt)
  {
    try
    {
      validate();
      rsnContextSetPriority(this.mContext, paramInt);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  native int nDeviceCreate();
  
  native void nDeviceDestroy(int paramInt);
  
  native void nDeviceSetConfig(int paramInt1, int paramInt2, int paramInt3);
  
  int nElementCreate(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    try
    {
      validate();
      paramInt1 = rsnElementCreate(this.mContext, paramInt1, paramInt2, paramBoolean, paramInt3);
      return paramInt1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  int nElementCreate2(int[] paramArrayOfInt1, String[] paramArrayOfString, int[] paramArrayOfInt2)
  {
    try
    {
      validate();
      int i = rsnElementCreate2(this.mContext, paramArrayOfInt1, paramArrayOfString, paramArrayOfInt2);
      return i;
    }
    finally
    {
      paramArrayOfInt1 = finally;
      throw paramArrayOfInt1;
    }
  }
  
  void nElementGetNativeData(int paramInt, int[] paramArrayOfInt)
  {
    try
    {
      validate();
      rsnElementGetNativeData(this.mContext, paramInt, paramArrayOfInt);
      return;
    }
    finally
    {
      paramArrayOfInt = finally;
      throw paramArrayOfInt;
    }
  }
  
  void nElementGetSubElements(int paramInt, int[] paramArrayOfInt1, String[] paramArrayOfString, int[] paramArrayOfInt2)
  {
    try
    {
      validate();
      rsnElementGetSubElements(this.mContext, paramInt, paramArrayOfInt1, paramArrayOfString, paramArrayOfInt2);
      return;
    }
    finally
    {
      paramArrayOfInt1 = finally;
      throw paramArrayOfInt1;
    }
  }
  
  void nObjDestroy(int paramInt)
  {
    try
    {
      if (this.mContext != 0) {
        rsnObjDestroy(this.mContext, paramInt);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  int nSamplerCreate(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat)
  {
    try
    {
      validate();
      paramInt1 = rsnSamplerCreate(this.mContext, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramFloat);
      return paramInt1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  void nScriptBindAllocation(int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      validate();
      rsnScriptBindAllocation(this.mContext, paramInt1, paramInt2, paramInt3);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  int nScriptCCreate(String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt)
  {
    try
    {
      validate();
      paramInt = rsnScriptCCreate(this.mContext, paramString1, paramString2, paramArrayOfByte, paramInt);
      return paramInt;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  int nScriptFieldIDCreate(int paramInt1, int paramInt2)
  {
    try
    {
      validate();
      paramInt1 = rsnScriptFieldIDCreate(this.mContext, paramInt1, paramInt2);
      return paramInt1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  void nScriptForEach(int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte)
  {
    try
    {
      validate();
      if (paramArrayOfByte == null) {
        rsnScriptForEach(this.mContext, paramInt1, paramInt2, paramInt3, paramInt4);
      } else {
        rsnScriptForEach(this.mContext, paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfByte);
      }
      return;
    }
    finally {}
  }
  
  void nScriptForEachClipped(int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10)
  {
    try
    {
      validate();
      if (paramArrayOfByte == null) {
        rsnScriptForEachClipped(this.mContext, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10);
      } else {
        rsnScriptForEachClipped(this.mContext, paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfByte, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10);
      }
      return;
    }
    finally {}
  }
  
  int nScriptGroupCreate(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4, int[] paramArrayOfInt5)
  {
    try
    {
      validate();
      int i = rsnScriptGroupCreate(this.mContext, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3, paramArrayOfInt4, paramArrayOfInt5);
      return i;
    }
    finally
    {
      paramArrayOfInt1 = finally;
      throw paramArrayOfInt1;
    }
  }
  
  void nScriptGroupExecute(int paramInt)
  {
    try
    {
      validate();
      rsnScriptGroupExecute(this.mContext, paramInt);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  void nScriptGroupSetInput(int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      validate();
      rsnScriptGroupSetInput(this.mContext, paramInt1, paramInt2, paramInt3);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  void nScriptGroupSetOutput(int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      validate();
      rsnScriptGroupSetOutput(this.mContext, paramInt1, paramInt2, paramInt3);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  int nScriptIntrinsicCreate(int paramInt1, int paramInt2)
  {
    try
    {
      validate();
      paramInt1 = rsnScriptIntrinsicCreate(this.mContext, paramInt1, paramInt2);
      return paramInt1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  void nScriptInvoke(int paramInt1, int paramInt2)
  {
    try
    {
      validate();
      rsnScriptInvoke(this.mContext, paramInt1, paramInt2);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  void nScriptInvokeV(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    try
    {
      validate();
      rsnScriptInvokeV(this.mContext, paramInt1, paramInt2, paramArrayOfByte);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  int nScriptKernelIDCreate(int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      validate();
      paramInt1 = rsnScriptKernelIDCreate(this.mContext, paramInt1, paramInt2, paramInt3);
      return paramInt1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  void nScriptSetTimeZone(int paramInt, byte[] paramArrayOfByte)
  {
    try
    {
      validate();
      rsnScriptSetTimeZone(this.mContext, paramInt, paramArrayOfByte);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  void nScriptSetVarD(int paramInt1, int paramInt2, double paramDouble)
  {
    try
    {
      validate();
      rsnScriptSetVarD(this.mContext, paramInt1, paramInt2, paramDouble);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  void nScriptSetVarF(int paramInt1, int paramInt2, float paramFloat)
  {
    try
    {
      validate();
      rsnScriptSetVarF(this.mContext, paramInt1, paramInt2, paramFloat);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  void nScriptSetVarI(int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      validate();
      rsnScriptSetVarI(this.mContext, paramInt1, paramInt2, paramInt3);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  void nScriptSetVarJ(int paramInt1, int paramInt2, long paramLong)
  {
    try
    {
      validate();
      rsnScriptSetVarJ(this.mContext, paramInt1, paramInt2, paramLong);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  void nScriptSetVarObj(int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      validate();
      rsnScriptSetVarObj(this.mContext, paramInt1, paramInt2, paramInt3);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  void nScriptSetVarV(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    try
    {
      validate();
      rsnScriptSetVarV(this.mContext, paramInt1, paramInt2, paramArrayOfByte);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  void nScriptSetVarVE(int paramInt1, int paramInt2, byte[] paramArrayOfByte, int paramInt3, int[] paramArrayOfInt)
  {
    try
    {
      validate();
      rsnScriptSetVarVE(this.mContext, paramInt1, paramInt2, paramArrayOfByte, paramInt3, paramArrayOfInt);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  int nTypeCreate(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2, int paramInt5)
  {
    try
    {
      validate();
      paramInt1 = rsnTypeCreate(this.mContext, paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean1, paramBoolean2, paramInt5);
      return paramInt1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  void nTypeGetNativeData(int paramInt, int[] paramArrayOfInt)
  {
    try
    {
      validate();
      rsnTypeGetNativeData(this.mContext, paramInt, paramArrayOfInt);
      return;
    }
    finally
    {
      paramArrayOfInt = finally;
      throw paramArrayOfInt;
    }
  }
  
  native void rsnAllocationCopyFromBitmap(int paramInt1, int paramInt2, Bitmap paramBitmap);
  
  native void rsnAllocationCopyToBitmap(int paramInt1, int paramInt2, Bitmap paramBitmap);
  
  native int rsnAllocationCreateBitmapBackedAllocation(int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap, int paramInt4);
  
  native int rsnAllocationCreateBitmapRef(int paramInt1, int paramInt2, Bitmap paramBitmap);
  
  native int rsnAllocationCreateFromAssetStream(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  native int rsnAllocationCreateFromBitmap(int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap, int paramInt4);
  
  native int rsnAllocationCreateTyped(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  native int rsnAllocationCubeCreateFromBitmap(int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap, int paramInt4);
  
  native void rsnAllocationData1D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, byte[] paramArrayOfByte, int paramInt6);
  
  native void rsnAllocationData1D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float[] paramArrayOfFloat, int paramInt6);
  
  native void rsnAllocationData1D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int[] paramArrayOfInt, int paramInt6);
  
  native void rsnAllocationData1D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, short[] paramArrayOfShort, int paramInt6);
  
  native void rsnAllocationData2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, int paramInt13);
  
  native void rsnAllocationData2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, byte[] paramArrayOfByte, int paramInt9);
  
  native void rsnAllocationData2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, float[] paramArrayOfFloat, int paramInt9);
  
  native void rsnAllocationData2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int[] paramArrayOfInt, int paramInt9);
  
  native void rsnAllocationData2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, short[] paramArrayOfShort, int paramInt9);
  
  native void rsnAllocationData2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, Bitmap paramBitmap);
  
  native void rsnAllocationData3D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, int paramInt13, int paramInt14);
  
  native void rsnAllocationData3D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, byte[] paramArrayOfByte, int paramInt10);
  
  native void rsnAllocationData3D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, float[] paramArrayOfFloat, int paramInt10);
  
  native void rsnAllocationData3D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int[] paramArrayOfInt, int paramInt10);
  
  native void rsnAllocationData3D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, short[] paramArrayOfShort, int paramInt10);
  
  native void rsnAllocationElementData1D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, byte[] paramArrayOfByte, int paramInt6);
  
  native void rsnAllocationGenerateMipmaps(int paramInt1, int paramInt2);
  
  native int rsnAllocationGetType(int paramInt1, int paramInt2);
  
  native void rsnAllocationIoReceive(int paramInt1, int paramInt2);
  
  native void rsnAllocationIoSend(int paramInt1, int paramInt2);
  
  native void rsnAllocationRead(int paramInt1, int paramInt2, byte[] paramArrayOfByte);
  
  native void rsnAllocationRead(int paramInt1, int paramInt2, float[] paramArrayOfFloat);
  
  native void rsnAllocationRead(int paramInt1, int paramInt2, int[] paramArrayOfInt);
  
  native void rsnAllocationRead(int paramInt1, int paramInt2, short[] paramArrayOfShort);
  
  native void rsnAllocationResize1D(int paramInt1, int paramInt2, int paramInt3);
  
  native void rsnAllocationResize2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  native void rsnAllocationSyncAll(int paramInt1, int paramInt2, int paramInt3);
  
  native int rsnContextCreate(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  native void rsnContextDestroy(int paramInt);
  
  native void rsnContextDump(int paramInt1, int paramInt2);
  
  native void rsnContextFinish(int paramInt);
  
  native void rsnContextSendMessage(int paramInt1, int paramInt2, int[] paramArrayOfInt);
  
  native void rsnContextSetPriority(int paramInt1, int paramInt2);
  
  native int rsnElementCreate(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4);
  
  native int rsnElementCreate2(int paramInt, int[] paramArrayOfInt1, String[] paramArrayOfString, int[] paramArrayOfInt2);
  
  native void rsnElementGetNativeData(int paramInt1, int paramInt2, int[] paramArrayOfInt);
  
  native void rsnElementGetSubElements(int paramInt1, int paramInt2, int[] paramArrayOfInt1, String[] paramArrayOfString, int[] paramArrayOfInt2);
  
  native void rsnObjDestroy(int paramInt1, int paramInt2);
  
  native int rsnSamplerCreate(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, float paramFloat);
  
  native void rsnScriptBindAllocation(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  native int rsnScriptCCreate(int paramInt1, String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt2);
  
  native int rsnScriptFieldIDCreate(int paramInt1, int paramInt2, int paramInt3);
  
  native void rsnScriptForEach(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  native void rsnScriptForEach(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, byte[] paramArrayOfByte);
  
  native void rsnScriptForEachClipped(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11);
  
  native void rsnScriptForEachClipped(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, byte[] paramArrayOfByte, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11);
  
  native int rsnScriptGroupCreate(int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4, int[] paramArrayOfInt5);
  
  native void rsnScriptGroupExecute(int paramInt1, int paramInt2);
  
  native void rsnScriptGroupSetInput(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  native void rsnScriptGroupSetOutput(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  native int rsnScriptIntrinsicCreate(int paramInt1, int paramInt2, int paramInt3);
  
  native void rsnScriptInvoke(int paramInt1, int paramInt2, int paramInt3);
  
  native void rsnScriptInvokeV(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte);
  
  native int rsnScriptKernelIDCreate(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  native void rsnScriptSetTimeZone(int paramInt1, int paramInt2, byte[] paramArrayOfByte);
  
  native void rsnScriptSetVarD(int paramInt1, int paramInt2, int paramInt3, double paramDouble);
  
  native void rsnScriptSetVarF(int paramInt1, int paramInt2, int paramInt3, float paramFloat);
  
  native void rsnScriptSetVarI(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  native void rsnScriptSetVarJ(int paramInt1, int paramInt2, int paramInt3, long paramLong);
  
  native void rsnScriptSetVarObj(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  native void rsnScriptSetVarV(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte);
  
  native void rsnScriptSetVarVE(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte, int paramInt4, int[] paramArrayOfInt);
  
  native int rsnTypeCreate(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean1, boolean paramBoolean2, int paramInt6);
  
  native void rsnTypeGetNativeData(int paramInt1, int paramInt2, int[] paramArrayOfInt);
  
  int safeID(BaseObj paramBaseObj)
  {
    if (paramBaseObj != null) {
      return paramBaseObj.getID(this);
    }
    return 0;
  }
  
  public void sendMessage(int paramInt, int[] paramArrayOfInt)
  {
    nContextSendMessage(paramInt, paramArrayOfInt);
  }
  
  public void setErrorHandler(RenderScript.RSErrorHandler paramRSErrorHandler)
  {
    this.mErrorCallback = paramRSErrorHandler;
    if (isNative)
    {
      paramRSErrorHandler = (RenderScriptThunker)this;
      RenderScript.2 local2 = new RenderScript.2(this);
      paramRSErrorHandler.mN.setErrorHandler(local2);
    }
  }
  
  public void setMessageHandler(RenderScript.RSMessageHandler paramRSMessageHandler)
  {
    this.mMessageCallback = paramRSMessageHandler;
    if (isNative)
    {
      paramRSMessageHandler = (RenderScriptThunker)this;
      RenderScript.1 local1 = new RenderScript.1(this);
      paramRSMessageHandler.mN.setMessageHandler(local1);
    }
  }
  
  public void setPriority(RenderScript.Priority paramPriority)
  {
    validate();
    nContextSetPriority(paramPriority.mID);
  }
  
  void validate()
  {
    if (this.mContext != 0) {
      return;
    }
    throw new RSInvalidStateException("Calling RS with no Context active.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v8.renderscript.RenderScript
 * JD-Core Version:    0.7.0.1
 */