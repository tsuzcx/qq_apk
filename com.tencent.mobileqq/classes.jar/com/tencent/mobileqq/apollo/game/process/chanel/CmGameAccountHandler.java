package com.tencent.mobileqq.apollo.game.process.chanel;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.game.process.CmGameServerQIPCModule;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopAvatarUtilApi;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;

public class CmGameAccountHandler
  implements DecodeTaskCompletionListener
{
  WeakReference<AppInterface> a;
  FriendListObserver b = new CmGameAccountHandler.1(this);
  private IFaceDecoder c;
  private Map<String, Integer> d = new HashMap();
  private Map<String, Integer> e = new HashMap();
  
  public CmGameAccountHandler(AppInterface paramAppInterface)
  {
    this.a = new WeakReference(paramAppInterface);
    this.c = ((IQQAvatarService)paramAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(paramAppInterface);
    this.c.setDecodeTaskCompletionListener(this);
    paramAppInterface.addObserver(this.b);
  }
  
  public void a()
  {
    QLog.i("apollochannel_CmGameAccountHandler", 1, "onDestroy");
    this.a = null;
    this.d.clear();
    this.e.clear();
    this.d = null;
    this.e = null;
    IFaceDecoder localIFaceDecoder = this.c;
    if (localIFaceDecoder != null)
    {
      localIFaceDecoder.destory();
      this.c = null;
    }
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    Object localObject1 = this.a;
    if (localObject1 != null)
    {
      if (((WeakReference)localObject1).get() == null) {
        return;
      }
      if (paramInt2 != 1)
      {
        if (paramInt2 != 2) {
          return;
        }
        localObject1 = this.c.getBitmapFromCache(1, String.valueOf(paramString), 0, (byte)1);
        if (localObject1 != null)
        {
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("bm != null:");
            ((StringBuilder)localObject2).append(paramString);
            QLog.d("qwe", 2, ((StringBuilder)localObject2).toString());
          }
          localObject1 = ((Bitmap)localObject1).copy(Bitmap.Config.ARGB_8888, true);
          localObject2 = new Bundle();
          ((Bundle)localObject2).putInt("type", 2);
          ((Bundle)localObject2).putString("uin", paramString);
          ((Bundle)localObject2).putParcelable("head", (Parcelable)localObject1);
          paramString = EIPCResult.createResult(0, (Bundle)localObject2);
          CmGameServerQIPCModule.b().callbackResult(paramInt1, paramString);
          return;
        }
        localObject1 = this.e;
        if (localObject1 != null)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramString);
          ((StringBuilder)localObject2).append("head");
          ((Map)localObject1).put(((StringBuilder)localObject2).toString(), Integer.valueOf(paramInt1));
        }
        this.c.requestDecodeFace(paramString, 200, false, 1, true, (byte)0, 1);
        return;
      }
      localObject1 = ContactUtils.b((AppRuntime)this.a.get(), paramString, true);
      if ((((ITroopAvatarUtilApi)QRoute.api(ITroopAvatarUtilApi.class)).isNumeric((String)localObject1)) && (((String)localObject1).equals(paramString)))
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("nickName.equals(uin):");
          ((StringBuilder)localObject1).append(paramString);
          QLog.d("apollochannel_CmGameAccountHandler", 2, ((StringBuilder)localObject1).toString());
        }
        localObject1 = this.d;
        if (localObject1 != null)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramString);
          ((StringBuilder)localObject2).append("nick");
          ((Map)localObject1).put(((StringBuilder)localObject2).toString(), Integer.valueOf(paramInt1));
        }
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("nickName != null:");
        ((StringBuilder)localObject2).append(paramString);
        QLog.d("apollochannel_CmGameAccountHandler", 2, ((StringBuilder)localObject2).toString());
      }
      Object localObject2 = new Bundle();
      ((Bundle)localObject2).putInt("type", 1);
      ((Bundle)localObject2).putString("uin", paramString);
      ((Bundle)localObject2).putString("nickName", (String)localObject1);
      paramString = EIPCResult.createResult(0, (Bundle)localObject2);
      CmGameServerQIPCModule.b().callbackResult(paramInt1, paramString);
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (!TextUtils.isEmpty(paramString)))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onDecodeTaskCompleted:");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("qwe", 2, ((StringBuilder)localObject).toString());
      }
      paramBitmap = paramBitmap.copy(Bitmap.Config.ARGB_8888, true);
      Object localObject = this.e;
      if (localObject != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append("head");
        if (((Map)localObject).get(localStringBuilder.toString()) != null)
        {
          localObject = new Bundle();
          ((Bundle)localObject).putInt("type", 2);
          ((Bundle)localObject).putString("uin", paramString);
          ((Bundle)localObject).putParcelable("head", paramBitmap);
          paramBitmap = EIPCResult.createResult(0, (Bundle)localObject);
          localObject = this.e;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString);
          localStringBuilder.append("head");
          paramInt1 = ((Integer)((Map)localObject).remove(localStringBuilder.toString())).intValue();
          CmGameServerQIPCModule.b().callbackResult(paramInt1, paramBitmap);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.chanel.CmGameAccountHandler
 * JD-Core Version:    0.7.0.1
 */