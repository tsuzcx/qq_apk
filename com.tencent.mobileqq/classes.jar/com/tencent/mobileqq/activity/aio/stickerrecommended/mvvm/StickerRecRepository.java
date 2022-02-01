package com.tencent.mobileqq.activity.aio.stickerrecommended.mvvm;

import android.os.Handler;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon;
import com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecManager.ImgUpdateListener;
import com.tencent.mobileqq.activity.aio.stickerrecommended.impl.StickerRecManagerImpl;
import com.tencent.mobileqq.activity.aio.stickerrecommended.mvvm.data.StickerRecLiveData;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mvvm.BaseRepository;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class StickerRecRepository
  extends BaseRepository
  implements IStickerRecManager.ImgUpdateListener
{
  private AppInterface a;
  private StickerRecManagerImpl b;
  private StickerRecViewModel c;
  
  public AppInterface a()
  {
    return this.a;
  }
  
  public void a(AppInterface paramAppInterface)
  {
    this.a = paramAppInterface;
    this.b = StickerRecManagerImpl.get(this.a);
  }
  
  public void a(StickerRecViewModel paramStickerRecViewModel)
  {
    this.c = paramStickerRecViewModel;
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.b == null) {
      this.b = StickerRecManagerImpl.get(this.a);
    }
    if (paramBoolean)
    {
      this.b.setImgUpdateListener(this);
      return;
    }
    this.b.setImgUpdateListener(null);
  }
  
  public StickerRecManagerImpl b()
  {
    if (this.b == null) {
      this.b = StickerRecManagerImpl.get(this.a);
    }
    return this.b;
  }
  
  public void c()
  {
    AppInterface localAppInterface = this.a;
    if (localAppInterface == null) {
      return;
    }
    if (this.b == null) {
      this.b = StickerRecManagerImpl.get(localAppInterface);
    }
    if (!this.b.hasInit()) {
      ThreadManager.executeOnSubThread(new StickerRecRepository.1(this));
    }
  }
  
  public void onImgUpdated(List<IStickerRecEmoticon> paramList, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("data=");
      localStringBuilder.append(paramList.size());
      QLog.d("StickerRecRepository", 2, localStringBuilder.toString());
    }
    paramList = new StickerRecLiveData(paramList, paramString1, paramString2, paramInt, paramString3);
    ThreadManagerV2.getUIHandlerV2().post(new StickerRecRepository.2(this, paramList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.mvvm.StickerRecRepository
 * JD-Core Version:    0.7.0.1
 */