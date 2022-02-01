package com.tencent.TMG.opengl.texture;

import android.util.Log;
import com.tencent.TMG.opengl.glrenderer.GLCanvas;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

public abstract class BasicTexture
{
  public static final int FORMAT_RGB = 0;
  public static final int FORMAT_YUV = 1;
  private static final int MAX_TEXTURE_SIZE = 4096;
  protected static final int STATE_ERROR = -1;
  protected static final int STATE_LOADED = 1;
  protected static final int STATE_UNLOADED = 0;
  private static final String TAG = "BasicTexture";
  protected static final int UNSPECIFIED = -1;
  private static WeakHashMap<BasicTexture, Object> sAllTextures = new WeakHashMap();
  private static ThreadLocal<Class<BasicTexture>> sInFinalizer = new ThreadLocal();
  protected GLCanvas mCanvasRef = null;
  protected int mHeight = -1;
  protected int[] mId;
  int mLeft = 0;
  protected int mState;
  protected int mTextureHeight;
  protected int mTextureWidth;
  int mTop = 0;
  protected int mWidth = -1;
  
  protected BasicTexture()
  {
    this(null, 0, 0);
  }
  
  protected BasicTexture(GLCanvas arg1, int paramInt1, int paramInt2)
  {
    setAssociatedCanvas(???);
    this.mState = paramInt2;
    synchronized (sAllTextures)
    {
      sAllTextures.put(this, null);
      return;
    }
  }
  
  private void freeResource()
  {
    GLCanvas localGLCanvas = this.mCanvasRef;
    if ((localGLCanvas != null) && (this.mId != null))
    {
      localGLCanvas.unloadTexture(this);
      this.mId = null;
    }
    this.mState = 0;
    setAssociatedCanvas(null);
  }
  
  public static boolean inFinalizer()
  {
    return sInFinalizer.get() != null;
  }
  
  public static void invalidateAllTextures()
  {
    synchronized (sAllTextures)
    {
      Iterator localIterator = sAllTextures.keySet().iterator();
      while (localIterator.hasNext())
      {
        BasicTexture localBasicTexture = (BasicTexture)localIterator.next();
        localBasicTexture.mState = 0;
        localBasicTexture.setAssociatedCanvas(null);
      }
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public static void yieldAllTextures()
  {
    synchronized (sAllTextures)
    {
      Iterator localIterator = sAllTextures.keySet().iterator();
      while (localIterator.hasNext()) {
        ((BasicTexture)localIterator.next()).yield();
      }
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void draw(GLCanvas paramGLCanvas, int paramInt1, int paramInt2)
  {
    paramGLCanvas.drawTexture(this, paramInt1, paramInt2, getSourceWidth(), getSourceHeight());
  }
  
  public void draw(GLCanvas paramGLCanvas, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramGLCanvas.drawTexture(this, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public int getFormatType()
  {
    return 0;
  }
  
  public int[] getId()
  {
    return this.mId;
  }
  
  public int getSourceHeight()
  {
    return this.mHeight;
  }
  
  public int getSourceLeft()
  {
    return this.mLeft;
  }
  
  public int getSourceTop()
  {
    return this.mTop;
  }
  
  public int getSourceWidth()
  {
    return this.mWidth;
  }
  
  public abstract int getTarget();
  
  public int getTextureHeight()
  {
    return this.mTextureHeight;
  }
  
  public int getTextureWidth()
  {
    return this.mTextureWidth;
  }
  
  public boolean isExistTextureid(int paramInt)
  {
    boolean bool1;
    boolean bool2;
    int i;
    label128:
    synchronized (sAllTextures)
    {
      Iterator localIterator = sAllTextures.entrySet().iterator();
      bool1 = false;
      BasicTexture localBasicTexture;
      do
      {
        bool2 = bool1;
        if (!localIterator.hasNext()) {
          break;
        }
        localBasicTexture = (BasicTexture)((Map.Entry)localIterator.next()).getKey();
      } while ((localBasicTexture == null) || (localBasicTexture.mId == null));
      i = 0;
      bool2 = bool1;
      if (i < localBasicTexture.mId.length) {
        if (paramInt == localBasicTexture.mId[i])
        {
          bool2 = true;
          break label128;
          return bool2;
        }
      }
    }
  }
  
  public boolean isFlippedVertically()
  {
    return false;
  }
  
  public boolean isLoaded()
  {
    return this.mState == 1;
  }
  
  public abstract boolean isOpaque();
  
  public abstract boolean onBind(GLCanvas paramGLCanvas);
  
  public void recycle()
  {
    freeResource();
  }
  
  protected void setAssociatedCanvas(GLCanvas paramGLCanvas)
  {
    this.mCanvasRef = paramGLCanvas;
  }
  
  public void setSourceLeft(int paramInt)
  {
    this.mLeft = paramInt;
  }
  
  public void setSourceSize(int paramInt1, int paramInt2)
  {
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
  }
  
  public void setSourceTop(int paramInt)
  {
    this.mTop = paramInt;
  }
  
  public void setTextureSize(int paramInt1, int paramInt2)
  {
    this.mTextureWidth = paramInt1;
    this.mTextureHeight = paramInt2;
    if ((this.mTextureWidth > 4096) || (this.mTextureHeight > 4096)) {
      Log.w("BasicTexture", String.format("texture is too large: %d x %d", new Object[] { Integer.valueOf(this.mTextureWidth), Integer.valueOf(this.mTextureHeight) }), new Exception());
    }
    if (this.mWidth == -1)
    {
      this.mWidth = paramInt1;
      this.mHeight = paramInt2;
    }
  }
  
  public void yield()
  {
    freeResource();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.opengl.texture.BasicTexture
 * JD-Core Version:    0.7.0.1
 */