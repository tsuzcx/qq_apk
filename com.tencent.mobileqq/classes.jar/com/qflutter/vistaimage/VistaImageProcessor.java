package com.qflutter.vistaimage;

import androidx.annotation.RequiresApi;
import io.flutter.view.TextureRegistry;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;

@RequiresApi(api=16)
final class VistaImageProcessor
{
  public static final String TAG = "VistaImageProcessor";
  private float density = 1.0F;
  private Map<Long, TextureRecord> textureRecordMap = new ConcurrentHashMap();
  private TextureRegistry textureRegistry;
  
  private void processCreateTextureTask(VistaImageTask paramVistaImageTask, IVistaImage paramIVistaImage)
  {
    Observable.just(paramVistaImageTask).flatMap(new VistaImageProcessor.3(this, paramIVistaImage)).observeOn(AndroidSchedulers.mainThread()).subscribe(new VistaImageProcessor.1(this, paramIVistaImage), new VistaImageProcessor.2(this));
  }
  
  private void processReleaseTextureTask(VistaImageTask paramVistaImageTask)
  {
    Observable.just(paramVistaImageTask).observeOn(AndroidSchedulers.mainThread()).subscribe(new VistaImageProcessor.4(this), new VistaImageProcessor.5(this));
  }
  
  private void processUpdateTextureTask(VistaImageTask paramVistaImageTask, IVistaImage paramIVistaImage)
  {
    long l = paramVistaImageTask.getTextureId();
    Observable.just(paramVistaImageTask).flatMap(new VistaImageProcessor.8(this, paramIVistaImage)).observeOn(AndroidSchedulers.mainThread()).subscribe(new VistaImageProcessor.6(this, l), new VistaImageProcessor.7(this));
  }
  
  void clear()
  {
    if (VistaImageLog.isColorLevel()) {
      VistaImageLog.d("VistaImageProcessor", "[clear]");
    }
    this.textureRegistry = null;
    Iterator localIterator = this.textureRecordMap.values().iterator();
    while (localIterator.hasNext()) {
      ((TextureRecord)localIterator.next()).release();
    }
    this.textureRecordMap.clear();
  }
  
  void processTask(VistaImageTask paramVistaImageTask)
  {
    if (VistaImageLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[processTask] task=");
      ((StringBuilder)localObject).append(paramVistaImageTask.toString());
      VistaImageLog.d("VistaImageProcessor", ((StringBuilder)localObject).toString());
    }
    Object localObject = SchemeService.getInstance().getSchemeHandler(paramVistaImageTask.getScheme());
    if (localObject == null)
    {
      paramVistaImageTask.notifyDartFail("-1", "no IVistaImage implementation");
      return;
    }
    if (paramVistaImageTask.getType() == 0)
    {
      processCreateTextureTask(paramVistaImageTask, (IVistaImage)localObject);
      return;
    }
    if (1 == paramVistaImageTask.getType())
    {
      processReleaseTextureTask(paramVistaImageTask);
      return;
    }
    if (2 == paramVistaImageTask.getType())
    {
      processUpdateTextureTask(paramVistaImageTask, (IVistaImage)localObject);
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[processTask] invalid task type, ");
    ((StringBuilder)localObject).append(paramVistaImageTask.getType());
    VistaImageLog.e("VistaImageProcessor", ((StringBuilder)localObject).toString());
    paramVistaImageTask.notifyDartFail("-12", "invalid task type");
  }
  
  void setDensity(float paramFloat)
  {
    if (VistaImageLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[setDensity] density=");
      localStringBuilder.append(paramFloat);
      VistaImageLog.d("VistaImageProcessor", localStringBuilder.toString());
    }
    if (paramFloat > 0.0F)
    {
      this.density = paramFloat;
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[setDensity] invalid density=");
    localStringBuilder.append(paramFloat);
    VistaImageLog.w("VistaImageProcessor", localStringBuilder.toString());
  }
  
  void setTextureRegistry(TextureRegistry paramTextureRegistry)
  {
    this.textureRegistry = paramTextureRegistry;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qflutter.vistaimage.VistaImageProcessor
 * JD-Core Version:    0.7.0.1
 */