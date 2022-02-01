package com.tencent.av.business.manager.voiceRecog;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.ListAdapter;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionFlag;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.magicface.EffectFaceManager;
import com.tencent.av.business.manager.magicface.EffectFaceManager.BlessingTips;
import com.tencent.av.business.manager.magicface.EffectFaceManager.VoiceStickerGuideTips;
import com.tencent.av.business.manager.magicface.FaceItem;
import com.tencent.av.recog.AVVoiceRecog;
import com.tencent.av.tips.TipsUtil;
import com.tencent.av.ui.QavListItemBase.ItemInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;

public class VoiceRecogTips
{
  static int jdField_a_of_type_Int = -1;
  static long jdField_a_of_type_Long = 0L;
  static long b = -1L;
  VoiceRecogTips.ShowTipsRunable jdField_a_of_type_ComTencentAvBusinessManagerVoiceRecogVoiceRecogTips$ShowTipsRunable;
  String jdField_a_of_type_JavaLangString;
  
  public VoiceRecogTips(VideoAppInterface paramVideoAppInterface, String paramString, EffectFaceManager.BlessingTips paramBlessingTips)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    a(paramVideoAppInterface, paramBlessingTips);
  }
  
  public static void a(VideoAppInterface paramVideoAppInterface)
  {
    paramVideoAppInterface = VoiceRecogManager.a(paramVideoAppInterface);
    b = MessageCache.a();
    paramVideoAppInterface.edit().putLong("voiceStickerTabShowFlag", b);
  }
  
  public static void a(VideoAppInterface paramVideoAppInterface, int paramInt, HorizontalListView paramHorizontalListView)
  {
    int i;
    if (3 != paramInt)
    {
      paramInt = 0;
      i = 1;
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("VoiceRecogTips", 1, "tryShowVoiceStickerTabTips, ret[" + i + "], count[" + paramInt + "]");
      }
      return;
      if (paramVideoAppInterface == null)
      {
        i = 10;
        paramInt = 0;
      }
      else if (paramHorizontalListView == null)
      {
        paramInt = 0;
        i = 2;
      }
      else
      {
        SessionInfo localSessionInfo = paramVideoAppInterface.a().a();
        if (localSessionInfo == null)
        {
          i = 11;
          paramInt = 0;
        }
        else
        {
          EffectFaceManager.VoiceStickerGuideTips localVoiceStickerGuideTips = ((EffectFaceManager)paramVideoAppInterface.a(3)).a();
          if (localVoiceStickerGuideTips == null)
          {
            i = 12;
            paramInt = 0;
          }
          else if (a(paramVideoAppInterface))
          {
            paramInt = 0;
            i = 13;
          }
          else
          {
            paramInt = localSessionInfo.a().jdField_a_of_type_Int;
            if (localSessionInfo.a().jdField_a_of_type_Int == 2147483647)
            {
              i = 13;
            }
            else
            {
              Object localObject = localSessionInfo.a();
              ((SessionFlag)localObject).jdField_a_of_type_Int += 1;
              if (localSessionInfo.a().jdField_a_of_type_Int < localVoiceStickerGuideTips.b)
              {
                i = 15;
              }
              else if (!VoiceRecogManager.a(paramVideoAppInterface))
              {
                i = 20;
              }
              else if (!AVVoiceRecog.a().a())
              {
                i = 21;
              }
              else if (AVVoiceRecog.a().a(2))
              {
                i = 22;
              }
              else
              {
                localObject = paramHorizontalListView.getAdapter();
                if (localObject == null)
                {
                  i = 3;
                }
                else
                {
                  int j = paramHorizontalListView.getFirstVisiblePosition();
                  i = j;
                  if (j == 0) {
                    i = j + 1;
                  }
                  paramHorizontalListView = ((ListAdapter)localObject).getItem(i);
                  if (!(paramHorizontalListView instanceof QavListItemBase.ItemInfo))
                  {
                    i = 14;
                  }
                  else
                  {
                    paramHorizontalListView = (QavListItemBase.ItemInfo)paramHorizontalListView;
                    if (!(paramHorizontalListView.a instanceof FaceItem))
                    {
                      i = 14;
                    }
                    else
                    {
                      paramHorizontalListView = ((FaceItem)paramHorizontalListView.a).getVoiceName();
                      if (TextUtils.isEmpty(paramHorizontalListView))
                      {
                        i = 16;
                      }
                      else if (TipsUtil.a(paramVideoAppInterface, 1026, localVoiceStickerGuideTips.a(paramHorizontalListView), null, localVoiceStickerGuideTips.jdField_a_of_type_Int, null))
                      {
                        VoiceRecogReport.a();
                        a(paramVideoAppInterface);
                        localSessionInfo.a().jdField_a_of_type_Int = 2147483647;
                        i = 100;
                      }
                      else
                      {
                        i = 99;
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public static void a(VideoAppInterface paramVideoAppInterface, QavListItemBase.ItemInfo paramItemInfo)
  {
    int i;
    int j;
    Object localObject2;
    Object localObject3;
    boolean bool;
    Object localObject1;
    if (paramVideoAppInterface == null)
    {
      i = 10;
      j = 0;
      localObject2 = null;
      localObject3 = null;
      paramItemInfo = null;
      bool = false;
      localObject1 = null;
      if (!bool) {
        break label604;
      }
      if (!TipsUtil.a(paramVideoAppInterface, 1026, ((EffectFaceManager.VoiceStickerGuideTips)localObject1).a(paramItemInfo), null, ((EffectFaceManager.VoiceStickerGuideTips)localObject1).d, null)) {
        break label598;
      }
      i = 100;
      SessionFlag.a(((SessionInfo)localObject3).a(), (String)localObject2, 2147483647);
      VoiceRecogReport.a();
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("VoiceRecogTips", 1, "tryShowVoiceStickerItemTips, ret[" + i + "], count[" + j + "], id[" + (String)localObject2 + "], showTipsRequest[" + bool + "]");
      }
      return;
      localObject1 = paramVideoAppInterface.a().a();
      if (localObject1 == null)
      {
        i = 11;
        localObject2 = null;
        localObject3 = localObject1;
        paramItemInfo = null;
        bool = false;
        j = 0;
        localObject1 = null;
        break;
      }
      localObject3 = (FaceItem)paramItemInfo.a;
      localObject2 = ((EffectFaceManager)paramVideoAppInterface.a(3)).a();
      if (localObject2 == null)
      {
        i = 12;
        localObject4 = null;
        paramItemInfo = null;
        bool = false;
        localObject3 = localObject1;
        j = 0;
        localObject1 = localObject2;
        localObject2 = localObject4;
        break;
      }
      if (!(paramItemInfo.a instanceof FaceItem))
      {
        i = 14;
        localObject4 = null;
        paramItemInfo = null;
        bool = false;
        localObject3 = localObject1;
        j = 0;
        localObject1 = localObject2;
        localObject2 = localObject4;
        break;
      }
      paramItemInfo = ((FaceItem)localObject3).getId();
      j = SessionFlag.a(((SessionInfo)localObject1).a(), paramItemInfo);
      if (j == 2147483647)
      {
        i = 13;
        localObject3 = paramItemInfo;
        bool = false;
        localObject4 = localObject1;
        paramItemInfo = null;
        localObject1 = localObject2;
        localObject2 = localObject3;
        localObject3 = localObject4;
        break;
      }
      i = j + 1;
      SessionFlag.a(((SessionInfo)localObject1).a(), paramItemInfo, i);
      if (i < ((EffectFaceManager.VoiceStickerGuideTips)localObject2).c)
      {
        k = 15;
        localObject3 = paramItemInfo;
        bool = false;
        localObject4 = localObject1;
        j = i;
        paramItemInfo = null;
        i = k;
        localObject1 = localObject2;
        localObject2 = localObject3;
        localObject3 = localObject4;
        break;
      }
      if (!VoiceRecogManager.a(paramVideoAppInterface))
      {
        k = 20;
        localObject3 = paramItemInfo;
        bool = false;
        localObject4 = localObject1;
        j = i;
        paramItemInfo = null;
        i = k;
        localObject1 = localObject2;
        localObject2 = localObject3;
        localObject3 = localObject4;
        break;
      }
      if (!AVVoiceRecog.a().a())
      {
        k = 21;
        localObject3 = paramItemInfo;
        bool = false;
        localObject4 = localObject1;
        j = i;
        paramItemInfo = null;
        i = k;
        localObject1 = localObject2;
        localObject2 = localObject3;
        localObject3 = localObject4;
        break;
      }
      if (AVVoiceRecog.a().a(2))
      {
        k = 22;
        localObject3 = paramItemInfo;
        bool = false;
        localObject4 = localObject1;
        j = i;
        paramItemInfo = null;
        i = k;
        localObject1 = localObject2;
        localObject2 = localObject3;
        localObject3 = localObject4;
        break;
      }
      Object localObject4 = ((FaceItem)localObject3).getVoiceName();
      if (TextUtils.isEmpty((CharSequence)localObject4))
      {
        k = 16;
        bool = false;
        localObject3 = localObject1;
        j = i;
        localObject1 = localObject4;
        localObject4 = paramItemInfo;
        i = k;
        paramItemInfo = (QavListItemBase.ItemInfo)localObject1;
        localObject1 = localObject2;
        localObject2 = localObject4;
        break;
      }
      int k = 0;
      bool = true;
      localObject3 = localObject1;
      j = i;
      localObject1 = localObject4;
      localObject4 = paramItemInfo;
      i = k;
      paramItemInfo = (QavListItemBase.ItemInfo)localObject1;
      localObject1 = localObject2;
      localObject2 = localObject4;
      break;
      label598:
      i = 99;
      continue;
      label604:
      TipsUtil.a(paramVideoAppInterface, 1026);
    }
  }
  
  static void a(VideoAppInterface paramVideoAppInterface, String paramString)
  {
    paramVideoAppInterface = VoiceRecogManager.a(paramVideoAppInterface);
    paramVideoAppInterface.edit().putString("blessingTips", paramString);
    jdField_a_of_type_Long = MessageCache.a();
    paramVideoAppInterface.edit().putLong("blessingTime", jdField_a_of_type_Long);
    jdField_a_of_type_Int = 1;
  }
  
  public static boolean a(VideoAppInterface paramVideoAppInterface)
  {
    if (b == -1L) {
      b = VoiceRecogManager.a(paramVideoAppInterface).getLong("voiceStickerTabShowFlag", 0L);
    }
    return b > 0L;
  }
  
  public static boolean a(VideoAppInterface paramVideoAppInterface, String paramString)
  {
    if (jdField_a_of_type_Int == -1)
    {
      paramVideoAppInterface = VoiceRecogManager.a(paramVideoAppInterface);
      String str = paramVideoAppInterface.getString("blessingTips", null);
      long l = paramVideoAppInterface.getLong("blessingTime", 0L);
      if (!TextUtils.equals(str, paramString)) {
        break label59;
      }
      jdField_a_of_type_Int = 1;
      jdField_a_of_type_Long = l;
    }
    while (jdField_a_of_type_Int == 1)
    {
      return true;
      label59:
      jdField_a_of_type_Int = 0;
    }
    return false;
  }
  
  public static void b(VideoAppInterface paramVideoAppInterface, String paramString)
  {
    TipsUtil.a(paramVideoAppInterface, 1025, HardCodeUtil.a(2131716672) + paramString + HardCodeUtil.a(2131716673));
  }
  
  void a(VideoAppInterface paramVideoAppInterface, EffectFaceManager.BlessingTips paramBlessingTips)
  {
    this.jdField_a_of_type_ComTencentAvBusinessManagerVoiceRecogVoiceRecogTips$ShowTipsRunable = new VoiceRecogTips.ShowTipsRunable(paramVideoAppInterface, paramBlessingTips);
    paramVideoAppInterface.a().postDelayed(this.jdField_a_of_type_ComTencentAvBusinessManagerVoiceRecogVoiceRecogTips$ShowTipsRunable, paramBlessingTips.jdField_a_of_type_Int);
  }
  
  public void b(VideoAppInterface paramVideoAppInterface)
  {
    paramVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvBusinessManagerVoiceRecogVoiceRecogTips$ShowTipsRunable);
    this.jdField_a_of_type_ComTencentAvBusinessManagerVoiceRecogVoiceRecogTips$ShowTipsRunable = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.business.manager.voiceRecog.VoiceRecogTips
 * JD-Core Version:    0.7.0.1
 */