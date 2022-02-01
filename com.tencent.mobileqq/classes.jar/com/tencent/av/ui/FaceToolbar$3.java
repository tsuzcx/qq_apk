package com.tencent.av.ui;

import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.magicface.EffectFaceManager;
import com.tencent.av.business.manager.magicface.FaceItem;
import com.tencent.av.business.manager.magicface.MagicDataReport;
import com.tencent.av.business.manager.makeup.MakeupMng;
import com.tencent.av.business.manager.voiceRecog.VoiceRecogTips;
import com.tencent.av.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

class FaceToolbar$3
  implements QAVPtvTemplateAdapter.IEffectCallback
{
  FaceToolbar$3(FaceToolbar paramFaceToolbar) {}
  
  public void a(long paramLong)
  {
    EffectSettingUi.a(this.a.mApp, paramLong);
  }
  
  public void a(long paramLong, QavListItemBase.ItemInfo paramItemInfo)
  {
    boolean bool = AudioHelper.b();
    int j = 1;
    if (bool)
    {
      localObject1 = FaceToolbar.TAG;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onEffectClick, seq[");
      ((StringBuilder)localObject2).append(paramLong);
      ((StringBuilder)localObject2).append("], id[");
      ((StringBuilder)localObject2).append(paramItemInfo.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject2).append("]");
      QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
    EffectSettingUi.a(this.a.mApp, paramLong);
    Object localObject1 = this.a.mApp.a();
    if (this.a.checkDimmStatus(paramItemInfo)) {
      return;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(((VideoController)localObject1).a(this.a.mApp.a().a().c));
    ((StringBuilder)localObject2).append("");
    localObject1 = ((StringBuilder)localObject2).toString();
    VoiceRecogTips.a(this.a.mApp, paramItemInfo);
    if (paramItemInfo.jdField_a_of_type_JavaLangString.equals("0"))
    {
      this.a.notifyEvent(Integer.valueOf(6101), null, Boolean.valueOf(true));
      MagicDataReport.a(2, (String)localObject1);
      MagicDataReport.a(2);
      if (this.a.mApp.a(13)) {
        ((MakeupMng)this.a.mApp.a(13)).a(paramLong, "onEffectClick2");
      }
    }
    else
    {
      localObject2 = paramItemInfo.jdField_a_of_type_JavaLangString;
      bool = false;
      AudioHelper.a((String)localObject2, false);
      if ((paramItemInfo.jdField_a_of_type_Int != 1) || (ControlUIObserver.RequestPlayMagicFace.c) || (ControlUIObserver.RequestPlayMagicFace.b != 4) || (!TextUtils.equals(ControlUIObserver.RequestPlayMagicFace.d, paramItemInfo.jdField_a_of_type_JavaLangString)) || (this.a.mAdapterPendant.a() == paramItemInfo)) {
        bool = true;
      }
      if (QLog.isColorLevel())
      {
        localObject2 = FaceToolbar.TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onEffectClick_Check, type[");
        localStringBuilder.append(paramItemInfo.jdField_a_of_type_Int);
        localStringBuilder.append("], sLastSenderFlag[");
        localStringBuilder.append(ControlUIObserver.RequestPlayMagicFace.c);
        localStringBuilder.append("], sLastItemId[");
        localStringBuilder.append(ControlUIObserver.RequestPlayMagicFace.d);
        localStringBuilder.append("], sLastFrom[");
        localStringBuilder.append(ControlUIObserver.RequestPlayMagicFace.b);
        localStringBuilder.append("], id[");
        localStringBuilder.append(paramItemInfo.jdField_a_of_type_JavaLangString);
        localStringBuilder.append("], isSender[");
        localStringBuilder.append(bool);
        localStringBuilder.append("], click[");
        localStringBuilder.append(this.a.mAdapterPendant.a());
        localStringBuilder.append("], info[");
        localStringBuilder.append(paramItemInfo);
        localStringBuilder.append("]");
        QLog.i((String)localObject2, 2, localStringBuilder.toString());
      }
      new ControlUIObserver.RequestPlayMagicFace(paramLong, paramItemInfo.jdField_a_of_type_JavaLangString, bool, 1).a(this.a.mApp);
      localObject2 = (FaceItem)this.a.mFaceManager.a(paramItemInfo.jdField_a_of_type_JavaLangString);
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
      MagicDataReport.a(paramItemInfo.jdField_a_of_type_JavaLangString, i, (String)localObject1);
      MagicDataReport.a(paramItemInfo.jdField_a_of_type_JavaLangString, i);
    }
  }
  
  public void a(QavListItemBase.ItemInfo paramItemInfo)
  {
    if ((paramItemInfo != null) && (!paramItemInfo.jdField_a_of_type_JavaLangString.equals("0")))
    {
      FaceItem localFaceItem = (FaceItem)this.a.mFaceManager.a(paramItemInfo.jdField_a_of_type_JavaLangString);
      if ((localFaceItem != null) && (!localFaceItem.getType().equalsIgnoreCase("face")))
      {
        if (localFaceItem.getType().equalsIgnoreCase("pendant"))
        {
          i = 2;
          break label89;
        }
        if (localFaceItem.getType().equalsIgnoreCase("voicesticker"))
        {
          i = 3;
          break label89;
        }
      }
      int i = 1;
      label89:
      if ((i == 1) || (i == 2)) {
        MagicDataReport.b(i, paramItemInfo.jdField_a_of_type_JavaLangString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.FaceToolbar.3
 * JD-Core Version:    0.7.0.1
 */