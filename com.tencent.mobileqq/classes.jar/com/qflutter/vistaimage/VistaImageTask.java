package com.qflutter.vistaimage;

import android.text.TextUtils;
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
  private SuperChannelTask superChannelTask;
  private long textureId;
  private int type;
  private String uri;
  private int width;
  
  private static VistaImageTask parseCreateTask(Map paramMap)
  {
    Object localObject = (String)paramMap.get("uri");
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      paramMap = new StringBuilder();
      paramMap.append("[parseCreateTask] invalid uri, uri=");
      paramMap.append((String)localObject);
      VistaImageLog.w("VistaImageTask", paramMap.toString());
      return null;
    }
    Integer localInteger1 = (Integer)paramMap.get("width");
    Integer localInteger2 = (Integer)paramMap.get("height");
    if ((localInteger1 == null) && (localInteger2 == null))
    {
      paramMap = new StringBuilder();
      paramMap.append("[parseCreateTask] invalid width or height, width=");
      paramMap.append(localInteger1);
      paramMap.append(", height=");
      paramMap.append(localInteger2);
      VistaImageLog.w("VistaImageTask", paramMap.toString());
      return null;
    }
    paramMap = (Integer)paramMap.get("fit");
    if (paramMap == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[parseCreateTask] invalid fit, fit=");
      ((StringBuilder)localObject).append(paramMap);
      VistaImageLog.w("VistaImageTask", ((StringBuilder)localObject).toString());
      return null;
    }
    VistaImageTask localVistaImageTask = new VistaImageTask();
    int j = 0;
    localVistaImageTask.type = 0;
    int i;
    if (localInteger1 == null) {
      i = 0;
    } else {
      i = localInteger1.intValue();
    }
    localVistaImageTask.width = i;
    if (localInteger2 == null) {
      i = j;
    } else {
      i = localInteger2.intValue();
    }
    localVistaImageTask.height = i;
    localVistaImageTask.fit = paramMap.intValue();
    localVistaImageTask.uri = ((String)localObject);
    return localVistaImageTask;
  }
  
  private static VistaImageTask parseReleaseTask(Map paramMap)
  {
    paramMap = (Integer)paramMap.get("texture_id");
    if (paramMap == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[parseReleaseTask] invalid textureId, textureId=");
      ((StringBuilder)localObject).append(paramMap);
      VistaImageLog.w("VistaImageTask", ((StringBuilder)localObject).toString());
      return null;
    }
    Object localObject = new VistaImageTask();
    ((VistaImageTask)localObject).type = 1;
    ((VistaImageTask)localObject).textureId = paramMap.intValue();
    return localObject;
  }
  
  private static VistaImageTask parseUpdateTask(Map paramMap)
  {
    Object localObject = (String)paramMap.get("uri");
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      paramMap = new StringBuilder();
      paramMap.append("[parseCreateTask] invalid uri, uri=");
      paramMap.append((String)localObject);
      VistaImageLog.w("VistaImageTask", paramMap.toString());
      return null;
    }
    Integer localInteger1 = (Integer)paramMap.get("texture_id");
    if (localInteger1 == null)
    {
      paramMap = new StringBuilder();
      paramMap.append("[parseUpdateTask] invalid textureId, textureId=");
      paramMap.append(localInteger1);
      VistaImageLog.w("VistaImageTask", paramMap.toString());
      return null;
    }
    Integer localInteger2 = (Integer)paramMap.get("width");
    Integer localInteger3 = (Integer)paramMap.get("height");
    if ((localInteger2 == null) && (localInteger3 == null))
    {
      paramMap = new StringBuilder();
      paramMap.append("[parseUpdateTask] invalid width or height, width=");
      paramMap.append(localInteger2);
      paramMap.append(", height=");
      paramMap.append(localInteger3);
      VistaImageLog.w("VistaImageTask", paramMap.toString());
      return null;
    }
    paramMap = (Integer)paramMap.get("fit");
    if (paramMap == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[parseUpdateTask] invalid fit, fit=");
      ((StringBuilder)localObject).append(paramMap);
      VistaImageLog.w("VistaImageTask", ((StringBuilder)localObject).toString());
      return null;
    }
    VistaImageTask localVistaImageTask = new VistaImageTask();
    localVistaImageTask.type = 2;
    localVistaImageTask.textureId = localInteger1.intValue();
    int j = 0;
    int i;
    if (localInteger2 == null) {
      i = 0;
    } else {
      i = localInteger2.intValue();
    }
    localVistaImageTask.width = i;
    if (localInteger3 == null) {
      i = j;
    } else {
      i = localInteger3.intValue();
    }
    localVistaImageTask.height = i;
    localVistaImageTask.fit = paramMap.intValue();
    localVistaImageTask.uri = ((String)localObject);
    return localVistaImageTask;
  }
  
  static VistaImageTask transformTask(SuperChannelTask paramSuperChannelTask)
  {
    if ("createTexture".equals(paramSuperChannelTask.getCommand())) {
      localObject = parseCreateTask(paramSuperChannelTask.getArguments());
    }
    for (;;)
    {
      ((VistaImageTask)localObject).superChannelTask = paramSuperChannelTask;
      return localObject;
      if ("releaseTexture".equals(paramSuperChannelTask.getCommand()))
      {
        localObject = parseReleaseTask(paramSuperChannelTask.getArguments());
      }
      else
      {
        if (!"updateTexture".equals(paramSuperChannelTask.getCommand())) {
          break;
        }
        localObject = parseUpdateTask(paramSuperChannelTask.getArguments());
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[transformTask] invalid command: ");
    ((StringBuilder)localObject).append(paramSuperChannelTask.getCommand());
    VistaImageLog.e("VistaImageTask", ((StringBuilder)localObject).toString());
    return null;
  }
  
  public long getTextureId()
  {
    return this.textureId;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public Observable<TextureRecord> loadImage(IVistaImage paramIVistaImage, float paramFloat)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.qflutter.vistaimage.VistaImageTask
 * JD-Core Version:    0.7.0.1
 */