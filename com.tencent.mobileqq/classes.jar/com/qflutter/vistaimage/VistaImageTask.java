package com.qflutter.vistaimage;

import com.qflutter.superchannel.SuperChannelResult;
import com.qflutter.superchannel.SuperChannelTask;
import java.util.Map;
import rx.Observable;

class VistaImageTask
{
  private static final String CREATE_TEXTURE_COMMAND = "createTexture";
  static final int CREATE_TEXTURE_TYPE = 0;
  private static final String RELEASE_TEXTURE_COMMAND = "releaseTexture";
  static final int RELEASE_TEXTURE_TYPE = 1;
  public static final String TAG = "VistaImageTask";
  private static final String UPDATE_TEXTURE_COMMAND = "updateTexture";
  static final int UPDATE_TEXTURE_TYPE = 2;
  private int fit;
  private int height;
  private double radius = 0.0D;
  private RendererParams.ImageRepeat repeat = RendererParams.ImageRepeat.NO_REPEAT;
  private String scheme;
  private SuperChannelTask superChannelTask;
  private long textureId = -1L;
  private int type;
  private String uri;
  private int width;
  
  private boolean checkCreateType()
  {
    Object localObject = this.uri;
    int i;
    if ((localObject != null) && (!((String)localObject).isEmpty()))
    {
      if ((this.width <= 0) && (this.height <= 0))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[checkCreateType] invalid size, width=");
        ((StringBuilder)localObject).append(this.width);
        ((StringBuilder)localObject).append(", height=");
        i = this.height;
        ((StringBuilder)localObject).append(i);
        label75:
        VistaImageLog.w("VistaImageTask", ((StringBuilder)localObject).toString());
        return false;
      }
      i = this.fit;
      if ((i >= 0) && (i <= 6))
      {
        localObject = this.scheme;
        if ((localObject != null) && (!((String)localObject).isEmpty())) {
          return true;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[checkCreateType] invalid scheme, ");
      }
    }
    for (String str = this.scheme;; str = this.uri)
    {
      ((StringBuilder)localObject).append(str);
      break label75;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[checkCreateType] invalid fit, ");
      i = this.fit;
      break;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[checkCreateType] invalid uri, ");
    }
  }
  
  private boolean checkReleaseType()
  {
    if (this.textureId < 0L)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[checkUpdateType] invalid textureId, ");
      localStringBuilder.append(this.textureId);
      VistaImageLog.w("VistaImageTask", localStringBuilder.toString());
      return false;
    }
    return true;
  }
  
  private boolean checkUpdateType()
  {
    return (checkCreateType()) && (checkReleaseType());
  }
  
  private static VistaImageTask generateTask(String paramString, Map paramMap)
  {
    VistaImageTask localVistaImageTask = new VistaImageTask();
    boolean bool = "createTexture".equals(paramString);
    int j = -1;
    int k = 0;
    int i;
    if (bool)
    {
      localVistaImageTask.type = 0;
    }
    else
    {
      if ("updateTexture".equals(paramString)) {}
      for (i = 2;; i = 1)
      {
        localVistaImageTask.type = i;
        break label80;
        if (!"releaseTexture".equals(paramString)) {
          break;
        }
      }
      localVistaImageTask.type = -1;
    }
    label80:
    localVistaImageTask.uri = ((String)paramMap.get("uri"));
    paramString = (Integer)paramMap.get("width");
    if (paramString == null) {
      i = 0;
    } else {
      i = paramString.intValue();
    }
    localVistaImageTask.width = i;
    paramString = (Integer)paramMap.get("height");
    if (paramString == null) {
      i = k;
    } else {
      i = paramString.intValue();
    }
    localVistaImageTask.height = i;
    paramString = (Double)paramMap.get("radius");
    double d;
    if (paramString == null) {
      d = 0.0D;
    } else {
      d = paramString.doubleValue();
    }
    localVistaImageTask.radius = d;
    paramString = (Integer)paramMap.get("repeat");
    if (paramString == null) {
      paramString = RendererParams.ImageRepeat.NO_REPEAT;
    } else {
      paramString = RendererParams.ImageRepeat.fromValue(paramString.intValue());
    }
    localVistaImageTask.repeat = paramString;
    paramString = (Integer)paramMap.get("fit");
    if (paramString == null) {
      i = j;
    } else {
      i = paramString.intValue();
    }
    localVistaImageTask.fit = i;
    localVistaImageTask.scheme = ((String)paramMap.get("scheme"));
    paramString = (Integer)paramMap.get("texture_id");
    long l;
    if (paramString == null) {
      l = -1L;
    } else {
      l = paramString.intValue();
    }
    localVistaImageTask.textureId = l;
    return localVistaImageTask;
  }
  
  static VistaImageTask transformTask(SuperChannelTask paramSuperChannelTask)
  {
    VistaImageTask localVistaImageTask = generateTask(paramSuperChannelTask.getCommand(), paramSuperChannelTask.getArguments());
    if (localVistaImageTask.isValid())
    {
      localVistaImageTask.superChannelTask = paramSuperChannelTask;
      return localVistaImageTask;
    }
    return null;
  }
  
  public int getFitType()
  {
    return this.fit;
  }
  
  public int getHeight()
  {
    return this.height;
  }
  
  public double getRadius()
  {
    return this.radius;
  }
  
  public RendererParams.ImageRepeat getRepeat()
  {
    return this.repeat;
  }
  
  String getScheme()
  {
    return this.scheme;
  }
  
  public long getTextureId()
  {
    return this.textureId;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public String getUri()
  {
    return this.uri;
  }
  
  public int getWidth()
  {
    return this.width;
  }
  
  boolean isValid()
  {
    int i = this.type;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[isValid] invalid type, ");
          localStringBuilder.append(this.type);
          VistaImageLog.w("VistaImageTask", localStringBuilder.toString());
          return false;
        }
        return checkUpdateType();
      }
      return checkReleaseType();
    }
    return checkCreateType();
  }
  
  Observable<TextureRecord> loadImage(IVistaImage paramIVistaImage, float paramFloat)
  {
    return Observable.create(new VistaImageTask.1(this, paramIVistaImage, paramFloat));
  }
  
  void notifyDartFail(String paramString1, String paramString2)
  {
    if (this.superChannelTask == null)
    {
      VistaImageLog.w("VistaImageTask", "[notifyDartFail] invalid superChannelTask");
      return;
    }
    SuperChannelResult localSuperChannelResult = new SuperChannelResult();
    localSuperChannelResult.fail(paramString1, paramString2);
    this.superChannelTask.send(localSuperChannelResult);
  }
  
  void notifyDartSuccess(Map paramMap)
  {
    if (this.superChannelTask == null)
    {
      VistaImageLog.w("VistaImageTask", "[notifyDartSuccess] invalid superChannelTask");
      return;
    }
    SuperChannelResult localSuperChannelResult = new SuperChannelResult();
    localSuperChannelResult.success(paramMap);
    this.superChannelTask.send(localSuperChannelResult);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VistaImageTask{type=");
    localStringBuilder.append(this.type);
    localStringBuilder.append(", uri='");
    localStringBuilder.append(this.uri);
    localStringBuilder.append('\'');
    localStringBuilder.append(", width=");
    localStringBuilder.append(this.width);
    localStringBuilder.append(", height=");
    localStringBuilder.append(this.height);
    localStringBuilder.append(", fit=");
    localStringBuilder.append(this.fit);
    localStringBuilder.append(", textureId=");
    localStringBuilder.append(this.textureId);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qflutter.vistaimage.VistaImageTask
 * JD-Core Version:    0.7.0.1
 */