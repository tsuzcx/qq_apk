package com.tencent.aekit.openrender;

import android.opengl.GLES20;
import android.support.annotation.NonNull;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Arrays;

public class AttributeParam
{
  private static final int PER_FLOAT_BYTE = 4;
  private FloatBuffer buffer;
  private int[] glBuffer;
  public int handle;
  public String name;
  public int perVertexFloat;
  private boolean update;
  private boolean useVBO;
  public float[] vertices;
  
  public AttributeParam(String paramString, float[] paramArrayOfFloat)
  {
    this(paramString, paramArrayOfFloat, false);
  }
  
  public AttributeParam(String paramString, float[] paramArrayOfFloat, int paramInt)
  {
    this(paramString, paramArrayOfFloat, paramInt, false);
  }
  
  public AttributeParam(String paramString, float[] paramArrayOfFloat, int paramInt, boolean paramBoolean)
  {
    this.name = paramString;
    this.vertices = paramArrayOfFloat;
    this.handle = -1;
    this.perVertexFloat = paramInt;
    this.useVBO = paramBoolean;
  }
  
  public AttributeParam(String paramString, float[] paramArrayOfFloat, boolean paramBoolean)
  {
    this(paramString, paramArrayOfFloat, 2, paramBoolean);
  }
  
  public void clear()
  {
    this.vertices = null;
    this.buffer = null;
    if (this.glBuffer != null) {
      GLES20.glDeleteBuffers(this.glBuffer.length, this.glBuffer, 0);
    }
  }
  
  public void initialParams(int paramInt)
  {
    this.handle = GLES20.glGetAttribLocation(paramInt, this.name);
  }
  
  public void setParams(int paramInt)
  {
    if (this.vertices == null) {
      return;
    }
    if ((this.buffer == null) || (this.buffer.capacity() < this.vertices.length)) {
      this.buffer = ByteBuffer.allocateDirect(this.vertices.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    }
    if ((this.useVBO) && (this.glBuffer == null))
    {
      this.glBuffer = new int[1];
      GLES20.glGenBuffers(this.glBuffer.length, this.glBuffer, 0);
    }
    if (this.update)
    {
      this.buffer.put(this.vertices).position(0);
      if (this.glBuffer != null)
      {
        GLES20.glBindBuffer(34962, this.glBuffer[0]);
        GLES20.glBufferData(34962, this.buffer.capacity() * 4, this.buffer, 35044);
      }
      this.update = false;
    }
    if ((this.useVBO) && (this.glBuffer != null))
    {
      GLES20.glBindBuffer(34962, this.glBuffer[0]);
      GLES20.glEnableVertexAttribArray(this.handle);
      GLES20.glVertexAttribPointer(this.handle, this.perVertexFloat, 5126, false, this.perVertexFloat * 4, 0);
      GLES20.glBindBuffer(34962, 0);
      return;
    }
    GLES20.glEnableVertexAttribArray(this.handle);
    GLES20.glVertexAttribPointer(this.handle, this.perVertexFloat, 5126, false, this.perVertexFloat * 4, this.buffer);
  }
  
  public void setVertices(float[] paramArrayOfFloat)
  {
    this.vertices = paramArrayOfFloat;
    this.update = true;
  }
  
  @NonNull
  public String toString()
  {
    return this.name + " = " + Arrays.toString(this.vertices);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.aekit.openrender.AttributeParam
 * JD-Core Version:    0.7.0.1
 */