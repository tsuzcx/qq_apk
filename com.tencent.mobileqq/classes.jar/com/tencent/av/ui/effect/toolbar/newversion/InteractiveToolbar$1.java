package com.tencent.av.ui.effect.toolbar.newversion;

import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.magicface.EffectFaceManager;
import com.tencent.av.business.manager.magicface.FaceItem;
import com.tencent.av.business.manager.magicface.MagicDataReport;
import com.tencent.av.business.manager.makeup.MakeupMng;
import com.tencent.av.business.manager.material.EffectMaterialManager;
import com.tencent.av.business.manager.voiceRecog.VoiceRecogTips;
import com.tencent.av.ui.ControlUIObserver.RequestPlayMagicFace;
import com.tencent.av.ui.QavListItemBase.ItemInfo;
import com.tencent.av.ui.effect.interfaces.IEffectCallback;
import com.tencent.av.ui.effect.toolbar.BaseToolbar;
import com.tencent.av.utils.AudioHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class InteractiveToolbar$1
  implements IEffectCallback
{
  InteractiveToolbar$1(InteractiveToolbar paramInteractiveToolbar) {}
  
  public void a(long paramLong)
  {
    BaseToolbar.keepInToolbar(InteractiveToolbar.access$700(this.a), paramLong);
  }
  
  public void a(long paramLong, QavListItemBase.ItemInfo paramItemInfo)
  {
    boolean bool = AudioHelper.e();
    int j = 1;
    if (bool)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onEffectClick, seq[");
      ((StringBuilder)localObject1).append(paramLong);
      ((StringBuilder)localObject1).append("], id[");
      ((StringBuilder)localObject1).append(paramItemInfo.a);
      ((StringBuilder)localObject1).append("]");
      QLog.w("InteractiveToolbar", 1, ((StringBuilder)localObject1).toString());
    }
    BaseToolbar.keepInToolbar(InteractiveToolbar.access$000(this.a), paramLong);
    Object localObject1 = InteractiveToolbar.access$100(this.a).b();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(((VideoController)localObject1).p(InteractiveToolbar.access$200(this.a).b().k().s));
    ((StringBuilder)localObject2).append("");
    localObject1 = ((StringBuilder)localObject2).toString();
    VoiceRecogTips.a(InteractiveToolbar.access$300(this.a), paramItemInfo);
    if (paramItemInfo.a.equals("0"))
    {
      this.a.notifyEvent(Integer.valueOf(6101), null, Boolean.valueOf(true));
      MagicDataReport.a(2, (String)localObject1);
      MagicDataReport.a(2);
      if (InteractiveToolbar.access$400(this.a).d(13)) {
        ((MakeupMng)InteractiveToolbar.access$500(this.a).c(13)).b(paramLong, "onEffectClick2");
      }
    }
    else
    {
      localObject2 = paramItemInfo.a;
      bool = false;
      AudioHelper.a((String)localObject2, false);
      if ((paramItemInfo.f != 1) || (ControlUIObserver.RequestPlayMagicFace.h) || (ControlUIObserver.RequestPlayMagicFace.i != 4) || (!TextUtils.equals(ControlUIObserver.RequestPlayMagicFace.g, paramItemInfo.a)) || (this.a.mLastClickItemInfo == paramItemInfo)) {
        bool = true;
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onEffectClick_Check, type[");
        ((StringBuilder)localObject2).append(paramItemInfo.f);
        ((StringBuilder)localObject2).append("], sLastSenderFlag[");
        ((StringBuilder)localObject2).append(ControlUIObserver.RequestPlayMagicFace.h);
        ((StringBuilder)localObject2).append("], sLastItemId[");
        ((StringBuilder)localObject2).append(ControlUIObserver.RequestPlayMagicFace.g);
        ((StringBuilder)localObject2).append("], sLastFrom[");
        ((StringBuilder)localObject2).append(ControlUIObserver.RequestPlayMagicFace.i);
        ((StringBuilder)localObject2).append("], id[");
        ((StringBuilder)localObject2).append(paramItemInfo.a);
        ((StringBuilder)localObject2).append("], isSender[");
        ((StringBuilder)localObject2).append(bool);
        ((StringBuilder)localObject2).append("], click[");
        ((StringBuilder)localObject2).append(this.a.mLastClickItemInfo);
        ((StringBuilder)localObject2).append("], info[");
        ((StringBuilder)localObject2).append(paramItemInfo);
        ((StringBuilder)localObject2).append("]");
        QLog.i("InteractiveToolbar", 2, ((StringBuilder)localObject2).toString());
      }
      new ControlUIObserver.RequestPlayMagicFace(paramLong, paramItemInfo.a, bool, 1).a(InteractiveToolbar.access$600(this.a));
      localObject2 = (FaceItem)this.a.mFaceManager.b(paramItemInfo.a);
      int i = j;
      if (localObject2 != null) {
        if (((FaceItem)localObject2).getType().equalsIgnoreCase("face"))
        {
          i = j;
        }
        else
        {
          i = j;
          if (((FaceItem)localObject2).getType().equalsIgnoreCase("voicesticker"))
          {
            i = 3;
            ReportController.b(null, "dc00898", "", "", "0X800984E", "0X800984E", 0, 0, "", "", "", paramItemInfo.a);
          }
        }
      }
      MagicDataReport.a(paramItemInfo.a, i, (String)localObject1);
      MagicDataReport.a(paramItemInfo.a, i);
    }
  }
  
  public void a(QavListItemBase.ItemInfo paramItemInfo)
  {
    Object localObject = this.a;
    ((InteractiveToolbar)localObject).mLastClickItemInfo = paramItemInfo;
    ((InteractiveToolbar)localObject).mMaterialManager.c(paramItemInfo.a);
    if ((paramItemInfo != null) && (!paramItemInfo.a.equals("0")))
    {
      localObject = (FaceItem)this.a.mFaceManager.b(paramItemInfo.a);
      if (localObject != null) {
        if (((FaceItem)localObject).getType().equalsIgnoreCase("face"))
        {
          ReportController.b(null, "dc00898", "", "", "0X800BC18", "0X800BC18", 0, 0, "", "", "", paramItemInfo.a);
        }
        else
        {
          if (((FaceItem)localObject).getType().equalsIgnoreCase("pendant"))
          {
            i = 2;
            break label167;
          }
          if (((FaceItem)localObject).getType().equalsIgnoreCase("voicesticker"))
          {
            i = 3;
            ReportController.b(null, "dc00898", "", "", "0X800BC17", "0X800BC17", 5, 0, "", "", "", paramItemInfo.a);
            break label167;
          }
        }
      }
      int i = 1;
      label167:
      if ((i == 1) || (i == 2)) {
        MagicDataReport.b(i, paramItemInfo.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.effect.toolbar.newversion.InteractiveToolbar.1
 * JD-Core Version:    0.7.0.1
 */