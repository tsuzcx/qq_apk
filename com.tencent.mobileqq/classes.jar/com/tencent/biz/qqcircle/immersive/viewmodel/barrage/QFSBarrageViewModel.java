package com.tencent.biz.qqcircle.immersive.viewmodel.barrage;

import android.content.Context;
import android.view.TextureView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.utils.QFSSafeListUtils;
import com.tencent.biz.qqcircle.immersive.utils.QFSThreadUtils;
import com.tencent.biz.qqcircle.immersive.viewmodel.barrage.holder.bean.QFSBarrageHolderParam;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rfw.barrage.core.RFWBarrageManager;
import com.tencent.rfw.barrage.data.RFWBaseBarrage;
import com.tencent.rfw.barrage.inject.RFWBarrageContext;
import com.tencent.rfw.barrage.inject.RFWBarrageContext.Builder;
import com.tencent.rfw.barrage.inject.RFWVideoBarrageConfig;
import com.tencent.rfw.barrage.inject.RFWWindowConfig;
import com.tencent.rfw.barrage.util.RFWBarragePlayerTimerUtils;
import com.tencent.rfw.barrage.util.RFWBarrageTimeUtils;
import com.tencent.rfw.barrage.util.RFWBarrageTimeUtils.RFWUpdateBarrageTimeParam;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class QFSBarrageViewModel
  implements IQFSBarrageViewModel<FeedCloudMeta.StComment>
{
  private RFWBarrageManager a;
  private RFWBarrageContext.Builder b;
  private RFWWindowConfig c;
  private RFWBarragePlayerTimerUtils d;
  private IQFSBarrageViewModel.OnMeasureBarrageListener e;
  private IQFSBarrageViewModel.OnBarrageLoadMoreListener f;
  private IQFSBarrageViewModel.OnBarrageClickPopupListener g;
  private FeedCloudMeta.StFeed h;
  private RFWBaseBarrage i = null;
  private int j = 0;
  
  private RFWBaseBarrage a(FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply)
  {
    if (this.a == null)
    {
      QLog.d("QDM-FSBarrageViewModel", 1, "[setDataSource] barrage manager should not is null.");
      return null;
    }
    String str = b(this.h);
    QFSBarrageHolderParam localQFSBarrageHolderParam = new QFSBarrageHolderParam();
    localQFSBarrageHolderParam.a(paramStComment);
    localQFSBarrageHolderParam.a(paramStReply);
    localQFSBarrageHolderParam.a(str);
    return this.a.a(-2147483647, localQFSBarrageHolderParam);
  }
  
  private RFWBarrageContext.Builder a(Context paramContext)
  {
    RFWBarrageContext.Builder localBuilder = RFWBarrageContext.i();
    localBuilder.a(new QFSBarrageViewModel.BarragePlayTimeSupplier(this));
    localBuilder.a(-10);
    localBuilder.a(new QFSBusinessBarrageRender(paramContext));
    localBuilder.a(new QFSBarrageViewModel.FSBarrageExportImpl(this));
    return localBuilder;
  }
  
  private List<RFWBaseBarrage> a(@NonNull FeedCloudMeta.StComment paramStComment)
  {
    Object localObject = paramStComment.vecReply.get();
    if (QFSSafeListUtils.a((List)localObject)) {
      return null;
    }
    paramStComment = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramStComment.add(a(null, (FeedCloudMeta.StReply)((Iterator)localObject).next()));
    }
    return paramStComment;
  }
  
  private List<RFWBaseBarrage> a(List<FeedCloudMeta.StComment> paramList)
  {
    if (QFSSafeListUtils.a(paramList))
    {
      QLog.d("QDM-FSBarrageViewModel", 1, "[convertCommentsToBarrageList] source not is empty.");
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int k = 0;
    while (k < paramList.size())
    {
      Object localObject = (FeedCloudMeta.StComment)QFSSafeListUtils.a(paramList, k);
      localArrayList.add(a((FeedCloudMeta.StComment)localObject, null));
      localObject = a((FeedCloudMeta.StComment)localObject);
      if (!QFSSafeListUtils.a((List)localObject)) {
        localArrayList.addAll((Collection)localObject);
      }
      k += 1;
    }
    return localArrayList;
  }
  
  private void a(QFSBarrageHolderParam paramQFSBarrageHolderParam)
  {
    IQFSBarrageViewModel.OnBarrageClickPopupListener localOnBarrageClickPopupListener = this.g;
    if (localOnBarrageClickPopupListener == null)
    {
      QLog.d("QDM-FSBarrageViewModel", 1, "[handleBarrageClick] barrage click popup listener should not be null.");
      return;
    }
    localOnBarrageClickPopupListener.a(paramQFSBarrageHolderParam);
  }
  
  private void a(RFWBaseBarrage paramRFWBaseBarrage)
  {
    if (paramRFWBaseBarrage == null)
    {
      QLog.d("QDM-FSBarrageViewModel", 1, "[handlerBarrageClick] barrage should not be null.");
      return;
    }
    Object localObject = paramRFWBaseBarrage.r();
    if (!(localObject instanceof QFSBarrageHolderParam))
    {
      QLog.d("QDM-FSBarrageViewModel", 1, new Object[] { "[handlerBarrageClick] data type not is comment, data: ", localObject });
      return;
    }
    this.i = paramRFWBaseBarrage;
    a((QFSBarrageHolderParam)localObject);
    b(true);
  }
  
  private void a(boolean paramBoolean)
  {
    IQFSBarrageViewModel.OnMeasureBarrageListener localOnMeasureBarrageListener = this.e;
    if (localOnMeasureBarrageListener == null)
    {
      QLog.d("QDM-FSBarrageViewModel", 1, "[setDataSource] barrage listener should not be null.");
      return;
    }
    localOnMeasureBarrageListener.a(paramBoolean);
  }
  
  private String b(FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStFeed == null) {
      paramStFeed = null;
    } else {
      paramStFeed = paramStFeed.poster;
    }
    if (paramStFeed == null) {
      return null;
    }
    return paramStFeed.id.get();
  }
  
  private void b(RFWBaseBarrage paramRFWBaseBarrage) {}
  
  private void b(List<RFWBaseBarrage> paramList, int paramInt, long paramLong)
  {
    if (this.a == null)
    {
      QLog.d("QDM-FSBarrageViewModel", 1, "[updateBarrageDataSource] barrage manager should not be null.");
      return;
    }
    int k = 0;
    while (k < paramList.size())
    {
      RFWBaseBarrage localRFWBaseBarrage1 = (RFWBaseBarrage)QFSSafeListUtils.a(paramList, k);
      this.a.a(localRFWBaseBarrage1);
      RFWBaseBarrage localRFWBaseBarrage2 = (RFWBaseBarrage)QFSSafeListUtils.a(paramList, k - 3);
      RFWBarrageTimeUtils.a(new RFWBarrageTimeUtils.RFWUpdateBarrageTimeParam().a(localRFWBaseBarrage1).b(localRFWBaseBarrage2).a(paramInt).a(paramLong).b(k));
      this.a.b(localRFWBaseBarrage1);
      k += 1;
    }
    QLog.d("QDM-FSBarrageViewModel", 1, new Object[] { "[setDataSource] barrages count: ", Integer.valueOf(paramList.size()), " | hash code:", Integer.valueOf(hashCode()) });
    QFSThreadUtils.b(new QFSBarrageViewModel.FSBarrageMeasureImpl(this, false));
  }
  
  private void b(List<RFWBaseBarrage> paramList, int paramInt1, long paramLong, int paramInt2)
  {
    if (this.a == null)
    {
      QLog.d("QDM-FSBarrageViewModel", 1, "[updateBarrageDataSource] barrage manager should not be null.");
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("barrage count: ");
    ((StringBuilder)localObject).append(QFSSafeListUtils.b(paramList));
    ((StringBuilder)localObject).append(" | totalCount: ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(" | duration: ");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append(" | startIndex: ");
    ((StringBuilder)localObject).append(paramInt2);
    QLog.d("QDM-FSBarrageViewModel", 1, new Object[] { "[appendBarrageDataSource] ", ((StringBuilder)localObject).toString() });
    int k = 0;
    while (k < paramList.size())
    {
      localObject = (RFWBaseBarrage)QFSSafeListUtils.a(paramList, k);
      this.a.a((RFWBaseBarrage)localObject);
      int m = paramInt2 + k;
      RFWBaseBarrage localRFWBaseBarrage = (RFWBaseBarrage)QFSSafeListUtils.a(paramList, m - 3);
      RFWBarrageTimeUtils.a(new RFWBarrageTimeUtils.RFWUpdateBarrageTimeParam().a((RFWBaseBarrage)localObject).b(localRFWBaseBarrage).a(paramInt1).a(paramLong).b(m));
      this.a.b((RFWBaseBarrage)localObject);
      k += 1;
    }
    this.a.a(false);
    QFSThreadUtils.b(new QFSBarrageViewModel.FSBarrageMeasureImpl(this, true));
  }
  
  private void b(boolean paramBoolean)
  {
    RFWBaseBarrage localRFWBaseBarrage = this.i;
    if (localRFWBaseBarrage == null)
    {
      QLog.d("QDM-FSBarrageViewModel", 1, "[updateBarrageClickState] current click barrage should not be null.");
      return;
    }
    localRFWBaseBarrage.a(paramBoolean);
    if (paramBoolean)
    {
      this.i.d();
      return;
    }
    this.i.f();
  }
  
  private void f()
  {
    if (this.d == null) {
      this.d = RFWBarragePlayerTimerUtils.a();
    }
    this.d.b();
  }
  
  private void g()
  {
    RFWBarragePlayerTimerUtils localRFWBarragePlayerTimerUtils = this.d;
    if (localRFWBarragePlayerTimerUtils == null) {
      return;
    }
    localRFWBarragePlayerTimerUtils.d();
  }
  
  private void h()
  {
    RFWBarragePlayerTimerUtils localRFWBarragePlayerTimerUtils = this.d;
    if (localRFWBarragePlayerTimerUtils == null) {
      return;
    }
    localRFWBarragePlayerTimerUtils.e();
  }
  
  private void i()
  {
    RFWBarragePlayerTimerUtils localRFWBarragePlayerTimerUtils = this.d;
    if (localRFWBarragePlayerTimerUtils == null) {
      return;
    }
    localRFWBarragePlayerTimerUtils.c();
  }
  
  private void j()
  {
    RFWBarragePlayerTimerUtils localRFWBarragePlayerTimerUtils = this.d;
    if (localRFWBarragePlayerTimerUtils == null) {
      return;
    }
    localRFWBarragePlayerTimerUtils.f();
  }
  
  private void k()
  {
    this.c = RFWBarrageContext.a();
    this.c.a(3);
    this.c.f(10.0F);
    this.c.c(10.0F);
    this.c.b(10.0F);
    this.c.b(false);
    this.c.d(true);
  }
  
  private long l()
  {
    RFWBarragePlayerTimerUtils localRFWBarragePlayerTimerUtils = this.d;
    if (localRFWBarragePlayerTimerUtils == null) {
      return -1L;
    }
    return localRFWBarragePlayerTimerUtils.g();
  }
  
  private void m()
  {
    IQFSBarrageViewModel.OnBarrageLoadMoreListener localOnBarrageLoadMoreListener = this.f;
    if (localOnBarrageLoadMoreListener == null)
    {
      QLog.d("QDM-FSBarrageViewModel", 1, "[handleBarrageLoadMore] barrage load more listener should not be null.");
      return;
    }
    localOnBarrageLoadMoreListener.a();
  }
  
  private void n()
  {
    RFWBarrageManager localRFWBarrageManager = this.a;
    if (localRFWBarrageManager == null)
    {
      QLog.d("QDM-FSBarrageViewModel", 1, "[handlerSourceDrawFinish] barrage manager should not is null.");
      return;
    }
    if (localRFWBarrageManager.i())
    {
      QLog.d("QDM-FSBarrageViewModel", 1, "[handlerSourceDrawFinish] barrage manager pause handler.");
      d();
    }
  }
  
  public void a()
  {
    if (this.a == null)
    {
      QLog.d("QDM-FSBarrageViewModel", 1, "[start] barrage manager should not be null.");
      return;
    }
    QLog.d("QDM-FSBarrageViewModel", 1, new Object[] { "[start] barrage start, hash code: ", Integer.valueOf(hashCode()) });
    this.j = 1;
    this.a.b();
    f();
  }
  
  public void a(Context paramContext, TextureView paramTextureView)
  {
    k();
    this.b = a(paramContext);
    this.a = new RFWBarrageManager(paramTextureView, this.b.a());
    this.a.a(new QFSBarrageViewModel.BarragePlayListener(this));
    RFWVideoBarrageConfig.a(new QFSBarrageViewModel.BarrageLoggerProxy(null));
  }
  
  public void a(IQFSBarrageViewModel.OnBarrageLoadMoreListener paramOnBarrageLoadMoreListener)
  {
    this.f = paramOnBarrageLoadMoreListener;
  }
  
  public void a(IQFSBarrageViewModel.OnMeasureBarrageListener paramOnMeasureBarrageListener)
  {
    this.e = paramOnMeasureBarrageListener;
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed)
  {
    this.h = paramStFeed;
  }
  
  public void a(List<FeedCloudMeta.StComment> paramList, int paramInt, long paramLong)
  {
    paramList = a(paramList);
    if (QFSSafeListUtils.a(paramList))
    {
      QLog.d("QDM-FSBarrageViewModel", 1, "[setDataSource] barrages not is empty, handler fail.");
      return;
    }
    QFSBarrageViewModel.AsyncUpdateDataSource localAsyncUpdateDataSource = new QFSBarrageViewModel.AsyncUpdateDataSource(this);
    localAsyncUpdateDataSource.a(paramList);
    localAsyncUpdateDataSource.a(paramInt);
    localAsyncUpdateDataSource.a(false);
    localAsyncUpdateDataSource.a(paramLong);
    QFSThreadUtils.c(localAsyncUpdateDataSource);
  }
  
  public void a(List<FeedCloudMeta.StComment> paramList, int paramInt1, long paramLong, int paramInt2)
  {
    paramList = a(paramList);
    if (QFSSafeListUtils.a(paramList))
    {
      QLog.d("QDM-FSBarrageViewModel", 1, "[appendBarrages] barrages not is empty, handler fail.");
      return;
    }
    QFSBarrageViewModel.AsyncUpdateDataSource localAsyncUpdateDataSource = new QFSBarrageViewModel.AsyncUpdateDataSource(this);
    localAsyncUpdateDataSource.a(paramList);
    localAsyncUpdateDataSource.a(paramInt1);
    localAsyncUpdateDataSource.a(true);
    localAsyncUpdateDataSource.a(paramLong);
    localAsyncUpdateDataSource.b(paramInt2);
    QFSThreadUtils.c(localAsyncUpdateDataSource);
  }
  
  public void b()
  {
    if (this.a == null)
    {
      QLog.d("QDM-FSBarrageViewModel", 1, "[pause] barrage manager should not be null.");
      return;
    }
    QLog.d("QDM-FSBarrageViewModel", 1, new Object[] { "[pause] barrage pause, hash code: ", Integer.valueOf(hashCode()) });
    this.j = 2;
    this.a.d();
    g();
  }
  
  public void c()
  {
    if (this.a == null)
    {
      QLog.d("QDM-FSBarrageViewModel", 1, "[pause] barrage manager should not be null.");
      return;
    }
    QLog.d("QDM-FSBarrageViewModel", 1, new Object[] { "[pause] barrage resume, hash code: ", Integer.valueOf(hashCode()) });
    this.j = 3;
    this.a.c();
    h();
  }
  
  public void d()
  {
    i();
    j();
    if (this.a == null)
    {
      QLog.d("QDM-FSBarrageViewModel", 1, "[release] barrage manager should not be null.");
      return;
    }
    QLog.d("QDM-FSBarrageViewModel", 1, new Object[] { "[destroy] barrage destroy, hash code: ", Integer.valueOf(hashCode()) });
    this.j = 4;
    this.a.a(false);
    this.a.e();
  }
  
  public int e()
  {
    return this.j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.viewmodel.barrage.QFSBarrageViewModel
 * JD-Core Version:    0.7.0.1
 */