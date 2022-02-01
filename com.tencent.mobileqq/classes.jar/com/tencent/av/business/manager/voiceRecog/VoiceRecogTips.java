package com.tencent.av.business.manager.voiceRecog;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.ListAdapter;
import anzj;
import bcrg;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.magicface.FaceItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import lfe;
import lff;
import lgx;
import lgy;
import lgz;
import lio;
import lip;
import ltr;
import mbb;
import mii;

public class VoiceRecogTips
{
  static int jdField_a_of_type_Int = -1;
  static long jdField_a_of_type_Long;
  static long b = -1L;
  VoiceRecogTips.ShowTipsRunable jdField_a_of_type_ComTencentAvBusinessManagerVoiceRecogVoiceRecogTips$ShowTipsRunable;
  String jdField_a_of_type_JavaLangString;
  
  public VoiceRecogTips(VideoAppInterface paramVideoAppInterface, String paramString, lgy paramlgy)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    a(paramVideoAppInterface, paramlgy);
  }
  
  public static void a(VideoAppInterface paramVideoAppInterface)
  {
    paramVideoAppInterface = lio.a(paramVideoAppInterface);
    b = bcrg.a();
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
        lff locallff = paramVideoAppInterface.a().a();
        if (locallff == null)
        {
          i = 11;
          paramInt = 0;
        }
        else
        {
          lgz locallgz = ((lgx)paramVideoAppInterface.a(3)).a();
          if (locallgz == null)
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
            paramInt = locallff.a().jdField_a_of_type_Int;
            if (locallff.a().jdField_a_of_type_Int == 2147483647)
            {
              i = 13;
            }
            else
            {
              Object localObject = locallff.a();
              ((lfe)localObject).jdField_a_of_type_Int += 1;
              if (locallff.a().jdField_a_of_type_Int < locallgz.b)
              {
                i = 15;
              }
              else if (!lio.a(paramVideoAppInterface))
              {
                i = 20;
              }
              else if (!ltr.a().a())
              {
                i = 21;
              }
              else if (ltr.a().a(2))
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
                  if (!(paramHorizontalListView instanceof mii))
                  {
                    i = 14;
                  }
                  else
                  {
                    paramHorizontalListView = (mii)paramHorizontalListView;
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
                      else if (mbb.a(paramVideoAppInterface, 1026, locallgz.a(paramHorizontalListView), null, locallgz.jdField_a_of_type_Int, null))
                      {
                        lip.a();
                        a(paramVideoAppInterface);
                        locallff.a().jdField_a_of_type_Int = 2147483647;
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
  
  static void a(VideoAppInterface paramVideoAppInterface, String paramString)
  {
    paramVideoAppInterface = lio.a(paramVideoAppInterface);
    paramVideoAppInterface.edit().putString("blessingTips", paramString);
    jdField_a_of_type_Long = bcrg.a();
    paramVideoAppInterface.edit().putLong("blessingTime", jdField_a_of_type_Long);
    jdField_a_of_type_Int = 1;
  }
  
  public static void a(VideoAppInterface paramVideoAppInterface, mii parammii)
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
      parammii = null;
      bool = false;
      localObject1 = null;
      if (!bool) {
        break label604;
      }
      if (!mbb.a(paramVideoAppInterface, 1026, ((lgz)localObject1).a(parammii), null, ((lgz)localObject1).d, null)) {
        break label598;
      }
      i = 100;
      lfe.a(((lff)localObject3).a(), (String)localObject2, 2147483647);
      lip.a();
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
        parammii = null;
        bool = false;
        j = 0;
        localObject1 = null;
        break;
      }
      localObject3 = (FaceItem)parammii.a;
      localObject2 = ((lgx)paramVideoAppInterface.a(3)).a();
      if (localObject2 == null)
      {
        i = 12;
        localObject4 = null;
        parammii = null;
        bool = false;
        localObject3 = localObject1;
        j = 0;
        localObject1 = localObject2;
        localObject2 = localObject4;
        break;
      }
      if (!(parammii.a instanceof FaceItem))
      {
        i = 14;
        localObject4 = null;
        parammii = null;
        bool = false;
        localObject3 = localObject1;
        j = 0;
        localObject1 = localObject2;
        localObject2 = localObject4;
        break;
      }
      parammii = ((FaceItem)localObject3).getId();
      j = lfe.a(((lff)localObject1).a(), parammii);
      if (j == 2147483647)
      {
        i = 13;
        localObject3 = parammii;
        bool = false;
        localObject4 = localObject1;
        parammii = null;
        localObject1 = localObject2;
        localObject2 = localObject3;
        localObject3 = localObject4;
        break;
      }
      i = j + 1;
      lfe.a(((lff)localObject1).a(), parammii, i);
      if (i < ((lgz)localObject2).c)
      {
        k = 15;
        localObject3 = parammii;
        bool = false;
        localObject4 = localObject1;
        j = i;
        parammii = null;
        i = k;
        localObject1 = localObject2;
        localObject2 = localObject3;
        localObject3 = localObject4;
        break;
      }
      if (!lio.a(paramVideoAppInterface))
      {
        k = 20;
        localObject3 = parammii;
        bool = false;
        localObject4 = localObject1;
        j = i;
        parammii = null;
        i = k;
        localObject1 = localObject2;
        localObject2 = localObject3;
        localObject3 = localObject4;
        break;
      }
      if (!ltr.a().a())
      {
        k = 21;
        localObject3 = parammii;
        bool = false;
        localObject4 = localObject1;
        j = i;
        parammii = null;
        i = k;
        localObject1 = localObject2;
        localObject2 = localObject3;
        localObject3 = localObject4;
        break;
      }
      if (ltr.a().a(2))
      {
        k = 22;
        localObject3 = parammii;
        bool = false;
        localObject4 = localObject1;
        j = i;
        parammii = null;
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
        localObject4 = parammii;
        i = k;
        parammii = (mii)localObject1;
        localObject1 = localObject2;
        localObject2 = localObject4;
        break;
      }
      int k = 0;
      bool = true;
      localObject3 = localObject1;
      j = i;
      localObject1 = localObject4;
      localObject4 = parammii;
      i = k;
      parammii = (mii)localObject1;
      localObject1 = localObject2;
      localObject2 = localObject4;
      break;
      label598:
      i = 99;
      continue;
      label604:
      mbb.a(paramVideoAppInterface, 1026);
    }
  }
  
  public static boolean a(VideoAppInterface paramVideoAppInterface)
  {
    if (b == -1L) {
      b = lio.a(paramVideoAppInterface).getLong("voiceStickerTabShowFlag", 0L);
    }
    return b > 0L;
  }
  
  public static boolean a(VideoAppInterface paramVideoAppInterface, String paramString)
  {
    if (jdField_a_of_type_Int == -1)
    {
      paramVideoAppInterface = lio.a(paramVideoAppInterface);
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
    mbb.a(paramVideoAppInterface, 1025, anzj.a(2131715624) + paramString + anzj.a(2131715625));
  }
  
  void a(VideoAppInterface paramVideoAppInterface, lgy paramlgy)
  {
    this.jdField_a_of_type_ComTencentAvBusinessManagerVoiceRecogVoiceRecogTips$ShowTipsRunable = new VoiceRecogTips.ShowTipsRunable(paramVideoAppInterface, paramlgy);
    paramVideoAppInterface.a().postDelayed(this.jdField_a_of_type_ComTencentAvBusinessManagerVoiceRecogVoiceRecogTips$ShowTipsRunable, paramlgy.jdField_a_of_type_Int);
  }
  
  public void b(VideoAppInterface paramVideoAppInterface)
  {
    paramVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvBusinessManagerVoiceRecogVoiceRecogTips$ShowTipsRunable);
    this.jdField_a_of_type_ComTencentAvBusinessManagerVoiceRecogVoiceRecogTips$ShowTipsRunable = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.business.manager.voiceRecog.VoiceRecogTips
 * JD-Core Version:    0.7.0.1
 */