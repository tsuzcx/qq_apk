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
import com.tencent.mobileqq.utils.AudioHelper;
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
    boolean bool = false;
    int j = 1;
    if (AudioHelper.e()) {
      QLog.w(FaceToolbar.TAG, 1, "onEffectClick, seq[" + paramLong + "], id[" + paramItemInfo.jdField_a_of_type_JavaLangString + "]");
    }
    EffectSettingUi.a(this.a.mApp, paramLong);
    Object localObject = this.a.mApp.a();
    if (this.a.checkDimmStatus(paramItemInfo)) {}
    do
    {
      return;
      localObject = ((VideoController)localObject).a(this.a.mApp.a().a().d) + "";
      VoiceRecogTips.a(this.a.mApp, paramItemInfo);
      if (!paramItemInfo.jdField_a_of_type_JavaLangString.equals("0")) {
        break;
      }
      this.a.notifyEvent(Integer.valueOf(6101), null, Boolean.valueOf(true));
      MagicDataReport.a(2, (String)localObject);
      MagicDataReport.a(2);
    } while (!this.a.mApp.a(13));
    ((MakeupMng)this.a.mApp.a(13)).a(paramLong, "onEffectClick2");
    return;
    AudioHelper.a(paramItemInfo.jdField_a_of_type_JavaLangString, false);
    if ((paramItemInfo.jdField_a_of_type_Int == 1) && (!ControlUIObserver.RequestPlayMagicFace.c) && (ControlUIObserver.RequestPlayMagicFace.b == 4) && (TextUtils.equals(ControlUIObserver.RequestPlayMagicFace.d, paramItemInfo.jdField_a_of_type_JavaLangString)) && (this.a.mAdapterPendant.a() != paramItemInfo)) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i(FaceToolbar.TAG, 2, "onEffectClick_Check, type[" + paramItemInfo.jdField_a_of_type_Int + "], sLastSenderFlag[" + ControlUIObserver.RequestPlayMagicFace.c + "], sLastItemId[" + ControlUIObserver.RequestPlayMagicFace.d + "], sLastFrom[" + ControlUIObserver.RequestPlayMagicFace.b + "], id[" + paramItemInfo.jdField_a_of_type_JavaLangString + "], isSender[" + bool + "], click[" + this.a.mAdapterPendant.a() + "], info[" + paramItemInfo + "]");
      }
      new ControlUIObserver.RequestPlayMagicFace(paramLong, paramItemInfo.jdField_a_of_type_JavaLangString, bool, 1).a(this.a.mApp);
      FaceItem localFaceItem = (FaceItem)this.a.mFaceManager.a(paramItemInfo.jdField_a_of_type_JavaLangString);
      int i = j;
      if (localFaceItem != null)
      {
        if (!localFaceItem.getType().equalsIgnoreCase("face")) {
          break label488;
        }
        i = j;
      }
      for (;;)
      {
        MagicDataReport.a(paramItemInfo.jdField_a_of_type_JavaLangString, i, (String)localObject);
        MagicDataReport.a(paramItemInfo.jdField_a_of_type_JavaLangString, i);
        return;
        label488:
        if (localFaceItem.getType().equalsIgnoreCase("pendant"))
        {
          i = 2;
        }
        else if (localFaceItem.getType().equalsIgnoreCase("voicesticker"))
        {
          i = 3;
        }
        else
        {
          i = j;
          if (localFaceItem.getType().equalsIgnoreCase("creativecop")) {
            i = 4;
          }
        }
      }
      bool = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.FaceToolbar.3
 * JD-Core Version:    0.7.0.1
 */