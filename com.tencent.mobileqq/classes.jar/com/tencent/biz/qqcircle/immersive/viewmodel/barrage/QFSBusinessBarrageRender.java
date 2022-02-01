package com.tencent.biz.qqcircle.immersive.viewmodel.barrage;

import android.content.Context;
import com.tencent.biz.qqcircle.immersive.viewmodel.barrage.holder.QFSBaseBarrageHolder;
import com.tencent.biz.qqcircle.immersive.viewmodel.barrage.holder.QFSHotBarrageHolder;
import com.tencent.biz.qqcircle.immersive.viewmodel.barrage.holder.QFSNormalBarrageHolder;
import com.tencent.biz.qqcircle.immersive.viewmodel.barrage.holder.QFSReplayBarrageHolder;
import com.tencent.biz.qqcircle.immersive.viewmodel.barrage.holder.bean.QFSBarrageHolderParam;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rfw.barrage.data.RFWBaseBarrage;
import com.tencent.rfw.barrage.data.RFWViewBarrage;
import com.tencent.rfw.barrage.render.RFWViewBarrageRender;
import com.tencent.rfw.barrage.render.RFWViewBarrageRender.ViewHolder;
import java.lang.ref.WeakReference;

public class QFSBusinessBarrageRender
  extends RFWViewBarrageRender
{
  private WeakReference<Context> a = null;
  
  public QFSBusinessBarrageRender(Context paramContext)
  {
    this.a = new WeakReference(paramContext);
  }
  
  private Context b()
  {
    WeakReference localWeakReference = this.a;
    if (localWeakReference == null) {
      return null;
    }
    return (Context)localWeakReference.get();
  }
  
  public int a(Object paramObject)
  {
    return QFSBarrageViewTypeUtils.a(paramObject);
  }
  
  public RFWViewBarrageRender.ViewHolder a(int paramInt)
  {
    Context localContext = b();
    if (localContext == null)
    {
      QLog.d("DM-FSBusinessBarrageRender", 1, "[onCreateViewHolder] context should not be null.");
      return null;
    }
    if (paramInt == 1) {
      return new QFSNormalBarrageHolder(localContext);
    }
    if (paramInt == 2) {
      return new QFSHotBarrageHolder(localContext);
    }
    if (paramInt == 3) {
      return new QFSReplayBarrageHolder(localContext);
    }
    return null;
  }
  
  public void a(int paramInt, RFWViewBarrageRender.ViewHolder paramViewHolder, RFWViewBarrage paramRFWViewBarrage)
  {
    if (!(paramViewHolder instanceof QFSBaseBarrageHolder))
    {
      QLog.d("DM-FSBusinessBarrageRender", 1, "[onBindViewHolder] current view holder not is FSBaseBarrageHolder type.");
      return;
    }
    if (paramRFWViewBarrage == null)
    {
      QLog.d("DM-FSBusinessBarrageRender", 1, "[onBindViewHolder] danmaku should not be null.");
      return;
    }
    paramRFWViewBarrage = (QFSBarrageHolderParam)paramRFWViewBarrage.r();
    if (paramRFWViewBarrage == null)
    {
      QLog.d("DM-FSBusinessBarrageRender", 1, "[onBindViewHolder] param should not be null.");
      return;
    }
    ((QFSBaseBarrageHolder)paramViewHolder).a(paramRFWViewBarrage);
  }
  
  public boolean a(RFWBaseBarrage paramRFWBaseBarrage)
  {
    return paramRFWBaseBarrage instanceof RFWBaseBarrage;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.viewmodel.barrage.QFSBusinessBarrageRender
 * JD-Core Version:    0.7.0.1
 */