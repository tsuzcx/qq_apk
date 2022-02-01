package com.tencent.aekit.openrender;

import android.util.Log;
import com.tencent.aekit.openrender.internal.AEChainI;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.AEProfiler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AEFilterChain
{
  private static final String TAG = "AEFilterChain";
  private static final String fragShader = "precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n";
  private static final String vertexShader = "precision highp float;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\n\nvoid main() {\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate;\n}\n";
  private VideoFilterBase copyFilter = new VideoFilterBase("precision highp float;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\n\nvoid main() {\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate;\n}\n", "precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private List<AEChainI> filterList = new ArrayList();
  
  private void copy(Frame paramFrame, int paramInt)
  {
    if (this.copyFilter == null) {
      return;
    }
    Frame localFrame = new Frame();
    this.copyFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height, paramInt, 0.0D, localFrame);
    localFrame.clear();
  }
  
  public void add(int paramInt, AEChainI paramAEChainI)
  {
    this.filterList.add(paramInt, paramAEChainI);
  }
  
  public void add(AEChainI paramAEChainI)
  {
    this.filterList.add(paramAEChainI);
  }
  
  public void add(List<? extends AEChainI> paramList)
  {
    if (paramList == null) {
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      AEChainI localAEChainI = (AEChainI)paramList.next();
      this.filterList.add(localAEChainI);
    }
  }
  
  public void clearFilterList()
  {
    this.filterList.clear();
  }
  
  public boolean containFilter(AEChainI paramAEChainI)
  {
    List localList = this.filterList;
    return (localList != null) && (localList.contains(paramAEChainI));
  }
  
  public void destroy()
  {
    clearFilterList();
    this.copyFilter.clearGLSLSelf();
  }
  
  public int indexOfFilter(AEChainI paramAEChainI)
  {
    if (containFilter(paramAEChainI)) {
      return this.filterList.indexOf(paramAEChainI);
    }
    return -1;
  }
  
  public void init()
  {
    this.copyFilter.ApplyGLSLFilter();
  }
  
  public Frame process(Frame paramFrame)
  {
    Iterator localIterator = this.filterList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (AEChainI)localIterator.next();
      if ((localObject != null) && (((AEChainI)localObject).isApplied()))
      {
        localObject = ((AEChainI)localObject).render(paramFrame);
        if ((localObject != paramFrame) && (!paramFrame.unlock())) {
          paramFrame.clear();
        }
        paramFrame = (Frame)localObject;
      }
    }
    return paramFrame;
  }
  
  public void process(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject1 = new Frame();
    ((Frame)localObject1).setSizedTexture(paramInt1, paramInt3, paramInt4);
    if (this.filterList.isEmpty())
    {
      copy((Frame)localObject1, paramInt2);
      ((Frame)localObject1).clear();
      return;
    }
    Iterator localIterator = this.filterList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (AEChainI)localIterator.next();
      if ((localObject2 != null) && (((AEChainI)localObject2).isApplied()))
      {
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(localObject2.getClass().getSimpleName());
        ((StringBuilder)localObject3).append("@");
        ((StringBuilder)localObject3).append(localObject2.hashCode());
        localObject3 = ((StringBuilder)localObject3).toString();
        AEProfiler.getInstance().start((String)localObject3, true);
        Frame localFrame2 = ((AEChainI)localObject2).render((Frame)localObject1);
        long l = AEProfiler.getInstance().end((String)localObject3, true);
        AEProfiler.getInstance().add(2, (String)localObject3, l);
        if (localFrame2 != localObject1)
        {
          localObject2 = ((Frame)localObject1).nextFrame;
          localObject3 = localObject1;
          while (localObject2 != null)
          {
            if (localFrame2 == localObject2)
            {
              ((Frame)localObject3).nextFrame = localFrame2.nextFrame;
              localFrame2.nextFrame = null;
            }
            Frame localFrame1 = ((Frame)localObject2).nextFrame;
            localObject3 = localObject2;
            localObject2 = localFrame1;
          }
          if (!((Frame)localObject1).unlock()) {
            ((Frame)localObject1).clear();
          }
        }
        localObject1 = localFrame2;
      }
    }
    copy((Frame)localObject1, paramInt2);
    if (!((Frame)localObject1).unlock()) {
      ((Frame)localObject1).clear();
    }
  }
  
  public void process(int paramInt1, int paramInt2, int paramInt3, int paramInt4, AEChainI... paramVarArgs)
  {
    Object localObject1 = TAG;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[process] + BEGIN, width = ");
    ((StringBuilder)localObject2).append(paramInt3);
    ((StringBuilder)localObject2).append(", height = ");
    ((StringBuilder)localObject2).append(paramInt4);
    Log.i((String)localObject1, ((StringBuilder)localObject2).toString());
    localObject1 = new Frame();
    ((Frame)localObject1).setSizedTexture(paramInt1, paramInt3, paramInt4);
    paramInt3 = paramVarArgs.length;
    paramInt1 = 0;
    while (paramInt1 < paramInt3)
    {
      AEChainI localAEChainI = paramVarArgs[paramInt1];
      localObject2 = localObject1;
      if (localAEChainI != null) {
        if (!localAEChainI.isApplied())
        {
          localObject2 = localObject1;
        }
        else
        {
          localObject2 = localAEChainI.render((Frame)localObject1);
          String str = TAG;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[process] filter = ");
          localStringBuilder.append(localAEChainI);
          Log.d(str, localStringBuilder.toString());
          if ((localObject2 != localObject1) && (!((Frame)localObject1).unlock())) {
            ((Frame)localObject1).clear();
          }
        }
      }
      paramInt1 += 1;
      localObject1 = localObject2;
    }
    copy((Frame)localObject1, paramInt2);
    if (!((Frame)localObject1).unlock()) {
      ((Frame)localObject1).clear();
    }
    Log.i(TAG, "[process] + END");
  }
  
  public void remove(int paramInt)
  {
    if (paramInt >= 0) {
      this.filterList.remove(paramInt);
    }
  }
  
  public void remove(AEChainI paramAEChainI)
  {
    int i = this.filterList.indexOf(paramAEChainI);
    if (i >= 0) {
      this.filterList.remove(i);
    }
  }
  
  public void setFilterList(List<AEChainI> paramList)
  {
    this.filterList = paramList;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AEFilterChain{filterList=");
    localStringBuilder.append(this.filterList);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aekit.openrender.AEFilterChain
 * JD-Core Version:    0.7.0.1
 */