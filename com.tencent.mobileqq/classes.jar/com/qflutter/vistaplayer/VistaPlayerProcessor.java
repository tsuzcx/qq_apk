package com.qflutter.vistaplayer;

import com.qflutter.superchannel.SuperChannelResult;
import com.qflutter.superchannel.SuperChannelTask;
import io.flutter.view.TextureRegistry;
import java.util.HashMap;
import java.util.Map;

class VistaPlayerProcessor
{
  static String CMD_DISPOSE = "dispose";
  static String CMD_INITIALIZE = "initial";
  static String CMD_LOOP = "loop";
  static String CMD_PAUSE = "pause";
  static String CMD_PLAYBACK = "playback";
  static String CMD_POSITION = "position";
  static String CMD_PREPARE = "prepare";
  static String CMD_SEEK = "seek";
  static String CMD_SPEED = "speed";
  static String CMD_STOP = "stop";
  static String CMD_VOLUME = "volume";
  private TextureRegistry textureRegistry;
  private IVistaPlayer vistaPlayerImpl;
  
  VistaPlayerProcessor(TextureRegistry paramTextureRegistry, IVistaPlayer paramIVistaPlayer)
  {
    this.textureRegistry = paramTextureRegistry;
    this.vistaPlayerImpl = paramIVistaPlayer;
    if (this.vistaPlayerImpl != null) {
      return;
    }
    throw new IllegalStateException("no IVistaPlayer impl created, maybe you forget VistaPlayerPlugin.register() first");
  }
  
  private SuperChannelResult onPrepare(Object paramObject)
  {
    long l = this.vistaPlayerImpl.prepare(paramObject, this.textureRegistry);
    paramObject = new SuperChannelResult();
    if (l >= 0L)
    {
      localObject = new HashMap();
      ((Map)localObject).put("texture_id", Long.valueOf(l));
      paramObject.success((Map)localObject);
      return paramObject;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("can not create texture, ");
    ((StringBuilder)localObject).append(l);
    paramObject.fail("-2011", ((StringBuilder)localObject).toString());
    return paramObject;
  }
  
  private SuperChannelResult success(Map paramMap)
  {
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap();
    }
    paramMap = new SuperChannelResult();
    paramMap.success((Map)localObject);
    return paramMap;
  }
  
  void clear()
  {
    this.textureRegistry = null;
    this.vistaPlayerImpl.clear();
  }
  
  SuperChannelResult dispatch(SuperChannelTask paramSuperChannelTask)
  {
    String str = paramSuperChannelTask.getCommand();
    boolean bool;
    if (CMD_INITIALIZE.equals(str))
    {
      bool = this.vistaPlayerImpl.initialize();
      paramSuperChannelTask = new HashMap();
      paramSuperChannelTask.put("initialized", Boolean.valueOf(bool));
      return success(paramSuperChannelTask);
    }
    if (CMD_PREPARE.equals(str)) {
      return onPrepare(paramSuperChannelTask.getArguments().get("data_source"));
    }
    int i;
    if (CMD_PLAYBACK.equals(str))
    {
      i = ((Integer)paramSuperChannelTask.getArguments().get("texture_id")).intValue();
      this.vistaPlayerImpl.playback(i);
      return success(null);
    }
    if (CMD_PAUSE.equals(str))
    {
      i = ((Integer)paramSuperChannelTask.getArguments().get("texture_id")).intValue();
      this.vistaPlayerImpl.pause(i);
      return success(null);
    }
    if (CMD_STOP.equals(str))
    {
      i = ((Integer)paramSuperChannelTask.getArguments().get("texture_id")).intValue();
      this.vistaPlayerImpl.stop(i);
      return success(null);
    }
    if (CMD_LOOP.equals(str))
    {
      i = ((Integer)paramSuperChannelTask.getArguments().get("texture_id")).intValue();
      bool = ((Boolean)paramSuperChannelTask.getArguments().get("is_looping")).booleanValue();
      this.vistaPlayerImpl.loop(i, bool);
      return success(null);
    }
    int j;
    if (CMD_POSITION.equals(str))
    {
      i = ((Integer)paramSuperChannelTask.getArguments().get("texture_id")).intValue();
      j = this.vistaPlayerImpl.position(i);
      paramSuperChannelTask = new HashMap();
      paramSuperChannelTask.put("texture_id", Integer.valueOf(i));
      paramSuperChannelTask.put("position", Integer.valueOf(j));
      return success(paramSuperChannelTask);
    }
    if (CMD_SEEK.equals(str))
    {
      i = ((Integer)paramSuperChannelTask.getArguments().get("texture_id")).intValue();
      j = ((Integer)paramSuperChannelTask.getArguments().get("position")).intValue();
      this.vistaPlayerImpl.seekTo(i, j);
      return success(null);
    }
    double d;
    if (CMD_SPEED.equals(str))
    {
      i = ((Integer)paramSuperChannelTask.getArguments().get("texture_id")).intValue();
      d = ((Double)paramSuperChannelTask.getArguments().get("speed")).doubleValue();
      this.vistaPlayerImpl.speed(i, d);
      return success(null);
    }
    if (CMD_VOLUME.equals(str))
    {
      i = ((Integer)paramSuperChannelTask.getArguments().get("texture_id")).intValue();
      d = ((Double)paramSuperChannelTask.getArguments().get("volume")).doubleValue();
      this.vistaPlayerImpl.volume(i, d);
      return success(null);
    }
    if (CMD_DISPOSE.equals(str))
    {
      i = ((Integer)paramSuperChannelTask.getArguments().get("texture_id")).intValue();
      this.vistaPlayerImpl.dispose(i);
      return success(null);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qflutter.vistaplayer.VistaPlayerProcessor
 * JD-Core Version:    0.7.0.1
 */