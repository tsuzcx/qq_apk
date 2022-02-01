package com.tencent.av.ui.effect.toolbar.oldversion;

import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.magicface.EffectFaceManager;
import com.tencent.av.business.manager.magicface.FaceItem;
import com.tencent.av.business.manager.magicface.MagicDataReport;
import com.tencent.av.business.manager.makeup.MakeupMng;
import com.tencent.av.business.manager.voiceRecog.VoiceRecogTips;
import com.tencent.av.ui.ControlUIObserver.RequestPlayMagicFace;
import com.tencent.av.ui.QAVPtvTemplateAdapter;
import com.tencent.av.ui.QavListItemBase.ItemInfo;
import com.tencent.av.ui.effect.interfaces.IEffectCallback;
import com.tencent.av.ui.effect.toolbar.BaseToolbar;
import com.tencent.av.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

class FaceToolbar$3
  implements IEffectCallback
{
  FaceToolbar$3(FaceToolbar paramFaceToolbar) {}
  
  public void a(long paramLong)
  {
    BaseToolbar.keepInToolbar(FaceToolbar.access$900(this.a), paramLong);
  }
  
  public void a(long paramLong, QavListItemBase.ItemInfo paramItemInfo)
  {
    boolean bool = AudioHelper.e();
    int j = 1;
    if (bool)
    {
      localObject1 = FaceToolbar.TAG;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onEffectClick, seq[");
      ((StringBuilder)localObject2).append(paramLong);
      ((StringBuilder)localObject2).append("], id[");
      ((StringBuilder)localObject2).append(paramItemInfo.a);
      ((StringBuilder)localObject2).append("]");
      QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
    BaseToolbar.keepInToolbar(FaceToolbar.access$200(this.a), paramLong);
    Object localObject1 = FaceToolbar.access$300(this.a).b();
    if (this.a.checkDimmStatus(paramItemInfo)) {
      return;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(((VideoController)localObject1).p(FaceToolbar.access$400(this.a).b().k().s));
    ((StringBuilder)localObject2).append("");
    localObject1 = ((StringBuilder)localObject2).toString();
    VoiceRecogTips.a(FaceToolbar.access$500(this.a), paramItemInfo);
    if (paramItemInfo.a.equals("0"))
    {
      this.a.notifyEvent(Integer.valueOf(6101), null, Boolean.valueOf(true));
      MagicDataReport.a(2, (String)localObject1);
      MagicDataReport.a(2);
      if (FaceToolbar.access$600(this.a).d(13)) {
        ((MakeupMng)FaceToolbar.access$700(this.a).c(13)).b(paramLong, "onEffectClick2");
      }
    }
    else
    {
      localObject2 = paramItemInfo.a;
      bool = false;
      AudioHelper.a((String)localObject2, false);
      if ((paramItemInfo.f != 1) || (ControlUIObserver.RequestPlayMagicFace.h) || (ControlUIObserver.RequestPlayMagicFace.i != 4) || (!TextUtils.equals(ControlUIObserver.RequestPlayMagicFace.g, paramItemInfo.a)) || (this.a.mAdapterPendant.b() == paramItemInfo)) {
        bool = true;
      }
      if (QLog.isColorLevel())
      {
        localObject2 = FaceToolbar.TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onEffectClick_Check, type[");
        localStringBuilder.append(paramItemInfo.f);
        localStringBuilder.append("], sLastSenderFlag[");
        localStringBuilder.append(ControlUIObserver.RequestPlayMagicFace.h);
        localStringBuilder.append("], sLastItemId[");
        localStringBuilder.append(ControlUIObserver.RequestPlayMagicFace.g);
        localStringBuilder.append("], sLastFrom[");
        localStringBuilder.append(ControlUIObserver.RequestPlayMagicFace.i);
        localStringBuilder.append("], id[");
        localStringBuilder.append(paramItemInfo.a);
        localStringBuilder.append("], isSender[");
        localStringBuilder.append(bool);
        localStringBuilder.append("], click[");
        localStringBuilder.append(this.a.mAdapterPendant.b());
        localStringBuilder.append("], info[");
        localStringBuilder.append(paramItemInfo);
        localStringBuilder.append("]");
        QLog.i((String)localObject2, 2, localStringBuilder.toString());
      }
      new ControlUIObserver.RequestPlayMagicFace(paramLong, paramItemInfo.a, bool, 1).a(FaceToolbar.access$800(this.a));
      localObject2 = (FaceItem)this.a.mFaceManager.b(paramItemInfo.a);
      int i = j;
      if (localObject2 != null) {
        if (((FaceItem)localObject2).getType().equalsIgnoreCase("face"))
        {
          i = j;
        }
        else if (((FaceItem)localObject2).getType().equalsIgnoreCase("pendant"))
        {
          i = 2;
        }
        else
        {
          i = j;
          if (((FaceItem)localObject2).getType().equalsIgnoreCase("voicesticker")) {
            i = 3;
          }
        }
      }
      MagicDataReport.a(paramItemInfo.a, i, (String)localObject1);
      MagicDataReport.a(paramItemInfo.a, i);
    }
  }
  
  public void a(QavListItemBase.ItemInfo paramItemInfo)
  {
    if ((paramItemInfo != null) && (!paramItemInfo.a.equals("0")))
    {
      FaceItem localFaceItem = (FaceItem)this.a.mFaceManager.b(paramItemInfo.a);
      if ((localFaceItem != null) && (!localFaceItem.getType().equalsIgnoreCase("face")))
      {
        if (localFaceItem.getType().equalsIgnoreCase("pendant"))
        {
          i = 2;
          break label91;
        }
        if (localFaceItem.getType().equalsIgnoreCase("voicesticker"))
        {
          i = 3;
          break label91;
        }
      }
      int i = 1;
      label91:
      if ((i == 1) || (i == 2)) {
        MagicDataReport.b(i, paramItemInfo.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.effect.toolbar.oldversion.FaceToolbar.3
 * JD-Core Version:    0.7.0.1
 */