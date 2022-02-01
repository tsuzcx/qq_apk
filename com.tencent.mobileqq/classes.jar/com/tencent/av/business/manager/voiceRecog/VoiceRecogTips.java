package com.tencent.av.business.manager.voiceRecog;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.ListAdapter;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionFlag;
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
    int j = 14;
    if (3 != paramInt) {
      paramInt = 1;
    }
    EffectFaceManager.VoiceStickerGuideTips localVoiceStickerGuideTips;
    for (;;)
    {
      i = 0;
      break label326;
      if (paramVideoAppInterface == null)
      {
        paramInt = 10;
      }
      else if (paramHorizontalListView == null)
      {
        paramInt = 2;
      }
      else
      {
        localVoiceStickerGuideTips = ((EffectFaceManager)paramVideoAppInterface.a(3)).a();
        if (localVoiceStickerGuideTips == null)
        {
          paramInt = 12;
        }
        else
        {
          if (!a(paramVideoAppInterface)) {
            break;
          }
          paramInt = 13;
        }
      }
    }
    int i = SessionFlag.a().jdField_a_of_type_Int;
    if (SessionFlag.a().jdField_a_of_type_Int == 2147483647)
    {
      paramInt = 13;
    }
    else
    {
      Object localObject = SessionFlag.a();
      ((SessionFlag)localObject).jdField_a_of_type_Int += 1;
      if (SessionFlag.a().jdField_a_of_type_Int < localVoiceStickerGuideTips.b)
      {
        paramInt = 15;
      }
      else if (!VoiceRecogManager.a(paramVideoAppInterface))
      {
        paramInt = 20;
      }
      else if (!AVVoiceRecog.a().a())
      {
        paramInt = 21;
      }
      else if (AVVoiceRecog.a().a(2))
      {
        paramInt = 22;
      }
      else
      {
        localObject = paramHorizontalListView.getAdapter();
        if (localObject == null)
        {
          paramInt = 3;
        }
        else
        {
          int k = paramHorizontalListView.getFirstVisiblePosition();
          paramInt = k;
          if (k == 0) {
            paramInt = k + 1;
          }
          paramHorizontalListView = ((ListAdapter)localObject).getItem(paramInt);
          if (!(paramHorizontalListView instanceof QavListItemBase.ItemInfo))
          {
            paramInt = j;
          }
          else
          {
            paramHorizontalListView = (QavListItemBase.ItemInfo)paramHorizontalListView;
            if (!(paramHorizontalListView.a instanceof FaceItem))
            {
              paramInt = j;
            }
            else
            {
              paramHorizontalListView = ((FaceItem)paramHorizontalListView.a).getVoiceName();
              if (TextUtils.isEmpty(paramHorizontalListView))
              {
                paramInt = 16;
              }
              else if (TipsUtil.a(paramVideoAppInterface, 1026, localVoiceStickerGuideTips.a(paramHorizontalListView), null, localVoiceStickerGuideTips.jdField_a_of_type_Int, null))
              {
                VoiceRecogReport.a();
                a(paramVideoAppInterface);
                SessionFlag.a().jdField_a_of_type_Int = 2147483647;
                paramInt = 100;
              }
              else
              {
                paramInt = 99;
              }
            }
          }
        }
      }
    }
    label326:
    if (QLog.isDevelopLevel())
    {
      paramVideoAppInterface = new StringBuilder();
      paramVideoAppInterface.append("tryShowVoiceStickerTabTips, ret[");
      paramVideoAppInterface.append(paramInt);
      paramVideoAppInterface.append("], count[");
      paramVideoAppInterface.append(i);
      paramVideoAppInterface.append("]");
      QLog.w("VoiceRecogTips", 1, paramVideoAppInterface.toString());
    }
  }
  
  public static void a(VideoAppInterface paramVideoAppInterface, QavListItemBase.ItemInfo paramItemInfo)
  {
    String str1 = null;
    boolean bool = false;
    int i;
    if (paramVideoAppInterface == null)
    {
      paramItemInfo = null;
      i = 10;
    }
    FaceItem localFaceItem;
    EffectFaceManager.VoiceStickerGuideTips localVoiceStickerGuideTips;
    for (;;)
    {
      str2 = null;
      j = 0;
      break label243;
      if (paramVideoAppInterface.a().a() == null)
      {
        paramItemInfo = null;
        i = 11;
      }
      else
      {
        localFaceItem = (FaceItem)paramItemInfo.a;
        localVoiceStickerGuideTips = ((EffectFaceManager)paramVideoAppInterface.a(3)).a();
        if (localVoiceStickerGuideTips == null)
        {
          i = 12;
          paramItemInfo = localVoiceStickerGuideTips;
        }
        else
        {
          if ((paramItemInfo.a instanceof FaceItem)) {
            break;
          }
          i = 14;
          paramItemInfo = localVoiceStickerGuideTips;
        }
      }
    }
    String str2 = localFaceItem.getId();
    int j = SessionFlag.a().a(str2);
    if (j == 2147483647)
    {
      i = 13;
      paramItemInfo = localVoiceStickerGuideTips;
    }
    else
    {
      j += 1;
      SessionFlag.a().a(str2, j);
      if (j < localVoiceStickerGuideTips.c)
      {
        i = 15;
        paramItemInfo = localVoiceStickerGuideTips;
      }
      else if (!VoiceRecogManager.a(paramVideoAppInterface))
      {
        i = 20;
        paramItemInfo = localVoiceStickerGuideTips;
      }
      else if (!AVVoiceRecog.a().a())
      {
        i = 21;
        paramItemInfo = localVoiceStickerGuideTips;
      }
      else if (AVVoiceRecog.a().a(2))
      {
        i = 22;
        paramItemInfo = localVoiceStickerGuideTips;
      }
      else
      {
        str1 = localFaceItem.getVoiceName();
        if (TextUtils.isEmpty(str1))
        {
          i = 16;
          paramItemInfo = localVoiceStickerGuideTips;
        }
        else
        {
          bool = true;
          i = 0;
          paramItemInfo = localVoiceStickerGuideTips;
        }
      }
    }
    label243:
    if (bool)
    {
      if (TipsUtil.a(paramVideoAppInterface, 1026, paramItemInfo.a(str1), null, paramItemInfo.d, null))
      {
        SessionFlag.a().a(str2, 2147483647);
        VoiceRecogReport.a();
        i = 100;
      }
      else
      {
        i = 99;
      }
    }
    else {
      TipsUtil.a(paramVideoAppInterface, 1026);
    }
    if (QLog.isDevelopLevel())
    {
      paramVideoAppInterface = new StringBuilder();
      paramVideoAppInterface.append("tryShowVoiceStickerItemTips, ret[");
      paramVideoAppInterface.append(i);
      paramVideoAppInterface.append("], count[");
      paramVideoAppInterface.append(j);
      paramVideoAppInterface.append("], id[");
      paramVideoAppInterface.append(str2);
      paramVideoAppInterface.append("], showTipsRequest[");
      paramVideoAppInterface.append(bool);
      paramVideoAppInterface.append("]");
      QLog.w("VoiceRecogTips", 1, paramVideoAppInterface.toString());
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
    int i = jdField_a_of_type_Int;
    boolean bool = false;
    if (i == -1)
    {
      paramVideoAppInterface = VoiceRecogManager.a(paramVideoAppInterface);
      String str = paramVideoAppInterface.getString("blessingTips", null);
      long l = paramVideoAppInterface.getLong("blessingTime", 0L);
      if (TextUtils.equals(str, paramString))
      {
        jdField_a_of_type_Int = 1;
        jdField_a_of_type_Long = l;
      }
      else
      {
        jdField_a_of_type_Int = 0;
      }
    }
    if (jdField_a_of_type_Int == 1) {
      bool = true;
    }
    return bool;
  }
  
  public static void b(VideoAppInterface paramVideoAppInterface, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131716327));
    localStringBuilder.append(paramString);
    localStringBuilder.append(HardCodeUtil.a(2131716328));
    TipsUtil.a(paramVideoAppInterface, 1025, localStringBuilder.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.voiceRecog.VoiceRecogTips
 * JD-Core Version:    0.7.0.1
 */