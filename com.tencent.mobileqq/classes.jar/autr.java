import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7.FriendShipFlagNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7.HotFriendNotify;

public class autr
{
  private static void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, int paramInt3, String paramString1, int paramInt4, long paramLong1, String paramString2, long paramLong2, long paramLong3, int paramInt5)
  {
    Object localObject5 = bdgc.m(paramQQAppInterface, paramString1);
    alto localalto = (alto)paramQQAppInterface.getManager(51);
    int i = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).getInt("hotDisableInteractive", 0);
    Object localObject1 = "";
    int i3 = 0;
    int i2 = 2097153;
    int j = 1;
    int i4 = 0;
    int i5 = 0;
    int i6 = 0;
    int i7 = 0;
    int m = 0;
    int i8 = 0;
    int i1 = 0;
    int n = 0;
    if (QLog.isColorLevel()) {
      QLog.d("FriendReactive", 2, "addHotFriendAIOGrayTips type=" + paramInt1 + "level=" + paramInt2 + "flag=" + paramInt3 + "IsDisableInteractive=" + localalto.q + "prelevel=" + paramInt4);
    }
    Object localObject2;
    label251:
    int k;
    label292:
    label323:
    boolean bool;
    label332:
    label351:
    Object localObject4;
    label393:
    Object localObject6;
    label608:
    String str;
    if (((paramInt3 != 0) || (paramInt1 == 5)) && (i != 1))
    {
      localObject2 = localObject1;
      if (paramInt1 == 5) {
        i = 9;
      }
      switch (paramInt3)
      {
      default: 
        localObject2 = localObject1;
        j = i;
        m = 0;
        localObject1 = localObject2;
        i = j;
      case 0: 
      case 1: 
        for (;;)
        {
          switch (paramInt1)
          {
          case 4: 
          case 5: 
          default: 
            paramInt4 = 0;
            localObject2 = "";
            paramString2 = (String)localObject1;
            j = i;
            i = m;
            m = i2;
            k = i3;
            localObject1 = localObject2;
            if (paramInt5 != 1) {
              break label3732;
            }
            bool = true;
            localObject2 = aove.c();
            if (localObject2 != null) {
              break label4821;
            }
            localObject2 = new aovd();
            if (!bool) {
              break label4818;
            }
            bool = ((aovd)localObject2).jdField_a_of_type_Boolean;
            if (!bool) {
              break label4815;
            }
            paramString2 = paramString2 + ((aovd)localObject2).jdField_a_of_type_JavaLangString;
            localObject4 = paramString2;
            if (paramInt3 == 8)
            {
              localObject4 = paramString2;
              if (paramInt1 == 5) {
                localObject4 = paramString2 + QzoneConfig.getInstance().getConfig("QZoneSetting", "LoverBonusAIOGrayTipsLinkText", "立即查看");
              }
            }
            localObject4 = autp.a(paramQQAppInterface, (String)localObject4, (String)localObject5, localalto);
            localObject6 = autp.a(paramQQAppInterface, (String)((List)localObject4).get(0), paramString1);
            paramString2 = (String)((List)localObject6).get(0);
            ((List)localObject4).remove(0);
            ((List)localObject6).remove(0);
            if ((k != 0) && (!akey.a(paramString1, paramQQAppInterface))) {
              ((bdug)paramQQAppInterface.a(71)).b(paramString1, k);
            }
            if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (n != 0)) {
              ((bdug)paramQQAppInterface.a(71)).b(paramString1, n, (String)autp.a(paramQQAppInterface, (String)autp.a(paramQQAppInterface, (String)localObject1, (String)localObject5, localalto).get(0), paramString1).get(0));
            }
            if (paramInt3 != 1) {
              break label3738;
            }
            paramInt5 = 2097153;
            localObject1 = new aspy(paramString1, paramString1, paramString2, 0, -5040, paramInt5, ayzl.a());
            if ((localObject6 == null) || (((List)localObject6).size() <= 0)) {
              break label3778;
            }
            paramInt5 = 0;
            while (paramInt5 < ((List)localObject6).size())
            {
              localObject5 = new Bundle();
              str = (String)((List)localObject6).get(paramInt5);
              if (!TextUtils.isEmpty(str))
              {
                ((Bundle)localObject5).putString("image_resource", str);
                k = paramString2.lastIndexOf(str);
                if (k >= 0) {
                  ((aspy)localObject1).a(k, str.length() + k, (Bundle)localObject5);
                }
                if (QLog.isColorLevel()) {
                  QLog.d("reactive", 2, "addHotFriendAIOGrayTips grayStr=" + paramString2 + "iconPos=" + k + "icon=" + str + "grayStr=" + paramString2);
                }
              }
              paramInt5 += 1;
            }
            if (!TextUtils.isEmpty(paramString2)) {
              localObject1 = paramString2;
            }
            j = i1;
            k = i;
            switch (paramInt2)
            {
            default: 
              k = i;
              j = i1;
            }
            for (;;)
            {
              i = k;
              m = j;
              break;
              if (paramInt4 == 1)
              {
                k = 9;
                j = 35;
              }
              else
              {
                j = i1;
                k = i;
                if (paramInt4 == 2)
                {
                  k = 10;
                  j = 36;
                  continue;
                  k = 9;
                  j = 35;
                  continue;
                  k = 10;
                  j = 36;
                }
              }
            }
            if (!TextUtils.isEmpty(paramString2)) {
              localObject1 = paramString2;
            }
            j = i4;
            k = i;
            localObject2 = localObject1;
            switch (paramInt2)
            {
            default: 
              localObject2 = localObject1;
              k = i;
              j = i4;
            case -1: 
            case 0: 
              label1008:
              localObject1 = localObject2;
              i = k;
              m = j;
            }
            break;
          }
        }
        if (TextUtils.isEmpty(paramString2)) {
          localObject1 = autp.a(paramQQAppInterface.getApp(), 65);
        }
        break;
      }
    }
    for (;;)
    {
      k = 9;
      j = 37;
      localObject2 = localObject1;
      break label1008;
      if (TextUtils.isEmpty(paramString2)) {
        localObject1 = autp.a(paramQQAppInterface.getApp(), 68);
      }
      k = 10;
      j = 38;
      localObject2 = localObject1;
      break label1008;
      if (!TextUtils.isEmpty(paramString2)) {
        localObject1 = paramString2;
      }
      switch (paramInt2)
      {
      }
      m = 0;
      break label251;
      if (!TextUtils.isEmpty(paramString2)) {
        localObject1 = paramString2;
      }
      j = i5;
      k = i;
      localObject2 = localObject1;
      switch (paramInt2)
      {
      default: 
        localObject2 = localObject1;
        k = i;
        j = i5;
      case -1: 
      case 0: 
        localObject1 = localObject2;
        i = k;
        m = j;
        break;
      case 1: 
        if (TextUtils.isEmpty(paramString2)) {
          localObject1 = autp.a(paramQQAppInterface.getApp(), 71);
        }
      case 2: 
        label4874:
        for (;;)
        {
          label1204:
          k = 9;
          j = 39;
          localObject2 = localObject1;
          break label1204;
          if (TextUtils.isEmpty(paramString2)) {
            localObject1 = autp.a(paramQQAppInterface.getApp(), 72);
          }
          k = 10;
          j = 40;
          localObject2 = localObject1;
          break label1204;
          if (!TextUtils.isEmpty(paramString2)) {
            localObject1 = paramString2;
          }
          j = i6;
          k = i;
          localObject2 = localObject1;
          label3732:
          label4889:
          switch (paramInt2)
          {
          default: 
            localObject2 = localObject1;
            k = i;
            j = i6;
          case -1: 
          case 1: 
            localObject1 = localObject2;
            i = k;
            m = j;
            break;
          case 0: 
            if (paramInt4 == 1)
            {
              if (!TextUtils.isEmpty(paramString2)) {
                break label4895;
              }
              localObject1 = autp.a(paramQQAppInterface.getApp(), 69);
            }
            label3738:
            label4895:
            for (;;)
            {
              i = 9;
              localObject2 = localObject1;
              for (;;)
              {
                j = 45;
                k = i;
                break;
                localObject2 = localObject1;
                if (paramInt4 == 2)
                {
                  if (TextUtils.isEmpty(paramString2)) {
                    localObject1 = autp.a(paramQQAppInterface.getApp(), 70);
                  }
                  i = 10;
                  localObject2 = localObject1;
                }
              }
              if (!TextUtils.isEmpty(paramString2)) {
                localObject1 = paramString2;
              }
              j = i7;
              k = i;
              switch (paramInt2)
              {
              default: 
                k = i;
                j = i7;
              }
              for (;;)
              {
                i = k;
                m = j;
                break;
                k = 9;
                j = 41;
                continue;
                k = 10;
                j = 42;
              }
              if (!TextUtils.isEmpty(paramString2)) {
                localObject1 = paramString2;
              }
              k = m;
              j = i;
              switch (paramInt2)
              {
              default: 
                j = i;
                k = m;
              }
              for (;;)
              {
                i = j;
                m = k;
                break;
                k = 46;
                j = i;
                continue;
                j = 9;
                k = m;
                continue;
                j = 10;
                k = m;
              }
              if (!TextUtils.isEmpty(paramString2)) {
                localObject1 = paramString2;
              }
              j = i8;
              k = i;
              switch (paramInt2)
              {
              default: 
                k = i;
                j = i8;
              }
              for (;;)
              {
                i = k;
                m = j;
                break;
                j = 46;
                k = i;
                continue;
                k = 9;
                j = 43;
                continue;
                k = 10;
                j = 44;
              }
              if (!TextUtils.isEmpty(paramString2))
              {
                m = 0;
                localObject1 = paramString2;
                break label251;
              }
              localObject1 = QzoneConfig.getInstance().getConfig("QZoneSetting", "LoverBonusAIOGrayTipsMainText", "爱要每天说出来，今日互发消息达到10条，额外获得10点恩爱值奖励，");
              j = i;
              localObject2 = localObject1;
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("Old0x210C7PushHelper", 2, " grayStr" + (String)localObject1);
              j = i;
              localObject2 = localObject1;
              break;
              paramInt4 = localalto.e;
              paramInt4 = localalto.f;
              if (paramInt2 == 1)
              {
                if (paramInt3 == 1)
                {
                  paramString2 = autp.a(paramQQAppInterface.getApp(), 21);
                  paramInt4 = 0;
                  i = 5;
                  j = 1;
                  localObject1 = "";
                  k = i3;
                  m = i2;
                  break label323;
                }
                if (paramInt3 != 2) {
                  break label292;
                }
                paramString2 = autp.a(paramQQAppInterface.getApp(), 24);
                paramInt4 = 0;
                i1 = 8;
                j = i;
                localObject1 = "";
                k = i3;
                m = i2;
                i = i1;
                break label323;
              }
              if (paramInt2 == 2)
              {
                paramString2 = autp.a(paramQQAppInterface.getApp(), 42);
                paramInt4 = 0;
                i = 6;
                j = 2;
                localObject1 = "";
                k = i3;
                m = i2;
                break label323;
              }
              if (paramInt2 != 0) {
                break label292;
              }
              paramString2 = autp.a(paramQQAppInterface.getApp(), 27);
              paramInt4 = 0;
              i1 = 7;
              j = i;
              localObject1 = "";
              k = i3;
              m = i2;
              i = i1;
              break label323;
              paramInt4 = localalto.jdField_a_of_type_Int;
              paramInt4 = localalto.b;
              if (paramInt2 == 1)
              {
                if (paramInt3 == 1)
                {
                  paramString2 = autp.a(paramQQAppInterface.getApp(), 20);
                  paramInt4 = VipUtils.a(paramQQAppInterface, paramString1, 0);
                  if (paramInt4 == 2) {
                    paramInt4 = 27;
                  }
                  for (;;)
                  {
                    i1 = 0;
                    i = 1;
                    j = paramInt4;
                    localObject1 = "";
                    k = i3;
                    m = i2;
                    paramInt4 = i1;
                    break;
                    if (paramInt4 == 1) {
                      paramInt4 = 30;
                    } else {
                      paramInt4 = 3;
                    }
                  }
                }
                if (paramInt3 != 2) {
                  break label292;
                }
                paramString2 = autp.a(paramQQAppInterface.getApp(), 23);
                paramInt4 = VipUtils.a(paramQQAppInterface, paramString1, 0);
                if (paramInt4 == 2) {
                  paramInt4 = 29;
                }
                for (;;)
                {
                  i1 = 0;
                  i = 4;
                  j = paramInt4;
                  localObject1 = "";
                  k = i3;
                  m = i2;
                  paramInt4 = i1;
                  break;
                  if (paramInt4 == 1) {
                    paramInt4 = 28;
                  } else {
                    paramInt4 = 4;
                  }
                }
              }
              if (paramInt2 == 2)
              {
                paramString2 = autp.a(paramQQAppInterface.getApp(), 41);
                paramInt4 = VipUtils.a(paramQQAppInterface, paramString1, 0);
                if (paramInt4 == 2) {
                  paramInt4 = 29;
                }
                for (;;)
                {
                  i1 = 0;
                  i = 2;
                  j = paramInt4;
                  localObject1 = "";
                  k = 1;
                  m = i2;
                  paramInt4 = i1;
                  break;
                  if (paramInt4 == 1) {
                    paramInt4 = 28;
                  } else {
                    paramInt4 = 4;
                  }
                }
              }
              if (paramInt2 != 0) {
                break label292;
              }
              paramString2 = autp.a(paramQQAppInterface.getApp(), 26);
              paramInt4 = 0;
              i1 = 3;
              j = i;
              localObject1 = "";
              k = i3;
              m = i2;
              i = i1;
              break label323;
              j = localalto.g;
              j = localalto.h;
              if (paramInt2 == 1)
              {
                if (paramInt3 == 1)
                {
                  paramString2 = autp.a(paramQQAppInterface.getApp(), 22);
                  paramInt4 = VipUtils.a(paramQQAppInterface, paramString1, 1);
                  if (paramInt4 == 2) {
                    paramInt4 = 31;
                  }
                  for (;;)
                  {
                    i1 = 0;
                    i = 9;
                    j = paramInt4;
                    localObject1 = "";
                    k = 3;
                    m = i2;
                    paramInt4 = i1;
                    break;
                    if (paramInt4 == 1) {
                      paramInt4 = 30;
                    } else {
                      paramInt4 = 5;
                    }
                  }
                }
                if (paramInt3 != 2) {
                  break label292;
                }
                paramInt4 = 0;
                j = m;
                i1 = i;
                localObject2 = "";
                paramString2 = (String)localObject1;
                localObject1 = localObject2;
                k = i3;
                m = i2;
                i = j;
                j = i1;
                break label323;
              }
              if (paramInt2 == 2)
              {
                paramString2 = autp.a(paramQQAppInterface.getApp(), 43);
                paramInt4 = VipUtils.a(paramQQAppInterface, paramString1, 1);
                if (paramInt4 == 2) {
                  paramInt4 = 33;
                }
                for (;;)
                {
                  i1 = 0;
                  i = 10;
                  j = paramInt4;
                  localObject1 = "";
                  k = 4;
                  m = i2;
                  paramInt4 = i1;
                  break;
                  if (paramInt4 == 1) {
                    paramInt4 = 32;
                  } else {
                    paramInt4 = 6;
                  }
                }
              }
              if (paramInt2 != 0) {
                break label292;
              }
              if (paramInt4 == 1)
              {
                paramString2 = autp.a(paramQQAppInterface.getApp(), 28);
                paramInt4 = 0;
                i1 = 11;
                j = i;
                localObject1 = "";
                k = i3;
                m = i2;
                i = i1;
                break label323;
              }
              if (paramInt4 != 2) {
                break label292;
              }
              paramString2 = autp.a(paramQQAppInterface.getApp(), 25);
              paramInt4 = 0;
              i1 = 12;
              j = i;
              localObject1 = "";
              k = i3;
              m = i2;
              i = i1;
              break label323;
              if (QLog.isColorLevel()) {
                QLog.d("Old0x210C7PushHelper", 2, "new boat flag=" + paramInt3 + ",level=" + paramInt2 + ",prelevel=" + paramInt4 + ", loverGrayTips=" + paramString2);
              }
              i1 = 0;
              if (paramInt3 == 0)
              {
                paramInt4 = 0;
                paramString2 = "";
                i = 0;
                j = 2097153;
                k = 0;
                n = 0;
              }
              for (;;)
              {
                label2755:
                if (n > 0)
                {
                  azqs.b(paramQQAppInterface, "dc00898", "", "", "0X8009500", "0X8009500", n, 0, "", "", "", "");
                  localObject2 = paramString2;
                  paramString2 = (String)localObject1;
                  i2 = m;
                  localObject1 = localObject2;
                  n = i;
                  m = j;
                  i = i2;
                  j = i1;
                  break;
                  if (paramInt3 == 1)
                  {
                    if (paramInt2 == 1)
                    {
                      localObject1 = autp.a(paramQQAppInterface.getApp(), 78);
                      paramInt4 = VipUtils.a(paramQQAppInterface, paramString1, 1);
                      if (paramInt4 == 2) {
                        paramInt4 = 31;
                      }
                      for (;;)
                      {
                        i2 = 0;
                        paramString2 = "";
                        i = 0;
                        i1 = paramInt4;
                        j = 2097153;
                        k = 3;
                        n = 1;
                        paramInt4 = i2;
                        break;
                        if (paramInt4 == 1) {
                          paramInt4 = 30;
                        } else {
                          paramInt4 = 5;
                        }
                      }
                    }
                    if (paramInt2 == 2)
                    {
                      if (paramInt4 == 0)
                      {
                        localObject1 = autp.a(paramQQAppInterface.getApp(), 80);
                        paramInt4 = 0;
                        paramString2 = "";
                        i = 0;
                        j = 2097153;
                        k = 4;
                        n = 2;
                        continue;
                      }
                      if (paramInt4 == 1)
                      {
                        localObject1 = autp.a(paramQQAppInterface.getApp(), 79);
                        paramInt4 = 0;
                        paramString2 = "";
                        i = 0;
                        j = 2097153;
                        k = 4;
                        n = 3;
                        continue;
                      }
                      if (QLog.isColorLevel())
                      {
                        QLog.e("Old0x210C7PushHelper", 2, "TYPE_NEW_BOAT flag 1 prelevel error prelevel =" + paramInt4);
                        paramInt4 = 0;
                        paramString2 = "";
                        i = 0;
                        j = 2097153;
                        k = 0;
                        n = 0;
                      }
                    }
                    else if (QLog.isColorLevel())
                    {
                      QLog.e("Old0x210C7PushHelper", 2, "TYPE_NEW_BOAT flag 1 level error level =" + paramInt2);
                      paramInt4 = 0;
                      paramString2 = "";
                      i = 0;
                      j = 2097153;
                      k = 0;
                      n = 0;
                    }
                  }
                  else if (paramInt3 == 2)
                  {
                    if (paramInt2 == 0)
                    {
                      if (paramInt4 == 1)
                      {
                        localObject1 = autp.a(paramQQAppInterface.getApp(), 81);
                        paramInt4 = 0;
                        paramString2 = "";
                        i = 0;
                        j = 2097153;
                        k = 0;
                        n = 4;
                        continue;
                      }
                      if (paramInt4 == 2)
                      {
                        localObject1 = autp.a(paramQQAppInterface.getApp(), 83);
                        paramInt4 = 0;
                        paramString2 = "";
                        i = 0;
                        j = 2097153;
                        k = 0;
                        n = 5;
                      }
                    }
                    else if (paramInt2 == 1)
                    {
                      localObject1 = autp.a(paramQQAppInterface.getApp(), 82);
                      paramInt4 = 0;
                      paramString2 = "";
                      i = 0;
                      j = 2097153;
                      k = 0;
                      n = 6;
                    }
                  }
                  else if (paramInt3 == 3)
                  {
                    if (paramInt2 < 0) {
                      break label3709;
                    }
                    paramString2 = paramQQAppInterface.a();
                    if ((paramString2 == null) || (!paramString2.a()) || (TextUtils.isEmpty(paramString2.a())) || (paramString2.a() != 0) || (!paramString2.a().equals(paramString1))) {
                      break label4889;
                    }
                  }
                }
              }
              for (i = 1;; i = 0)
              {
                if (paramInt2 == 0)
                {
                  paramString2 = autp.a(paramQQAppInterface.getApp(), 84);
                  paramInt4 = 7;
                  label3315:
                  if (i == 0) {
                    break label4874;
                  }
                  localObject1 = "";
                }
                for (;;)
                {
                  i2 = 0;
                  i = 1;
                  j = 2097153;
                  k = 0;
                  localObject2 = paramString2;
                  n = paramInt4;
                  paramInt4 = i2;
                  paramString2 = (String)localObject1;
                  localObject1 = localObject2;
                  break label2755;
                  if (paramInt2 == 1)
                  {
                    paramString2 = autp.a(paramQQAppInterface.getApp(), 85);
                    paramInt4 = 9;
                    break label3315;
                  }
                  paramString2 = "";
                  paramInt4 = 0;
                  break label3315;
                  if (paramInt3 == 4)
                  {
                    if (paramInt2 != 0) {
                      break label3709;
                    }
                    i = 0;
                    paramString2 = paramQQAppInterface.a();
                    paramInt4 = i;
                    if (paramString2 != null)
                    {
                      paramInt4 = i;
                      if (paramString2.a())
                      {
                        paramInt4 = i;
                        if (!TextUtils.isEmpty(paramString2.a()))
                        {
                          paramInt4 = i;
                          if (paramString2.a() == 0)
                          {
                            paramInt4 = i;
                            if (paramString2.a().equals(paramString1)) {
                              paramInt4 = 1;
                            }
                          }
                        }
                      }
                    }
                    paramString2 = autp.a(paramQQAppInterface.getApp(), 86);
                    if (paramInt4 == 0) {
                      break label4859;
                    }
                    localObject1 = "";
                  }
                  for (;;)
                  {
                    paramInt4 = 0;
                    i = 1;
                    j = 2097153;
                    k = 0;
                    localObject2 = paramString2;
                    n = 8;
                    paramString2 = (String)localObject1;
                    localObject1 = localObject2;
                    break label2755;
                    if (paramInt3 == 5)
                    {
                      if (paramInt2 > 0)
                      {
                        if (paramInt2 == 2)
                        {
                          paramString2 = autp.a(paramQQAppInterface.getApp(), 88);
                          paramInt4 = 11;
                        }
                        for (;;)
                        {
                          i2 = 1;
                          localObject2 = "";
                          i = 0;
                          j = 2097155;
                          k = 0;
                          localObject1 = paramString2;
                          n = paramInt4;
                          paramInt4 = i2;
                          paramString2 = (String)localObject2;
                          break;
                          if (paramInt2 == 1)
                          {
                            paramString2 = autp.a(paramQQAppInterface.getApp(), 87);
                            paramInt4 = 10;
                          }
                          else
                          {
                            paramString2 = "";
                            paramInt4 = 0;
                          }
                        }
                      }
                    }
                    else
                    {
                      if (paramInt3 == 6)
                      {
                        if (paramInt2 != 2) {
                          break label3709;
                        }
                        localObject1 = autp.a(paramQQAppInterface.getApp(), 88);
                        paramInt4 = 1;
                        paramString2 = "";
                        i = 0;
                        j = 2097155;
                        k = 0;
                        n = 11;
                        break label2755;
                      }
                      if (QLog.isColorLevel()) {
                        QLog.e("Old0x210C7PushHelper", 2, "TYPE_NEW_BOAT flag  error flag =" + paramInt3);
                      }
                    }
                    label3709:
                    paramInt4 = 0;
                    paramString2 = "";
                    i = 0;
                    j = 2097153;
                    k = 0;
                    n = 0;
                    break label2755;
                    bool = false;
                    break label332;
                    if (paramInt3 == 2)
                    {
                      paramInt5 = 2097154;
                      break label608;
                    }
                    paramInt5 = m;
                    if (paramInt3 != 8) {
                      break label608;
                    }
                    paramInt5 = m;
                    if (paramInt1 != 5) {
                      break label608;
                    }
                    paramInt5 = 655384;
                    break label608;
                    label3778:
                    if ((localObject4 != null) && (((List)localObject4).size() > 0))
                    {
                      paramInt5 = 0;
                      while (paramInt5 < ((List)localObject4).size())
                      {
                        localObject5 = new Bundle();
                        localObject6 = (String)((List)localObject4).get(paramInt5);
                        if (!TextUtils.isEmpty((CharSequence)localObject6))
                        {
                          ((Bundle)localObject5).putInt("key_action", 11);
                          ((Bundle)localObject5).putString("key_action_DATA", (String)localObject6);
                          k = paramString2.lastIndexOf((String)localObject6);
                          if (k >= 0) {
                            ((aspy)localObject1).a(k, ((String)localObject6).length() + k, (Bundle)localObject5);
                          }
                          if (QLog.isColorLevel()) {
                            QLog.d("reactive", 2, "addHotFriendAIOGrayTips grayStr=" + paramString2 + "spanPos=" + k + "iconName=" + (String)localObject6);
                          }
                        }
                        paramInt5 += 1;
                      }
                    }
                    if (bool)
                    {
                      localObject4 = new Bundle();
                      ((Bundle)localObject4).putInt("key_action", 1);
                      k = 0;
                      paramInt5 = k;
                      switch (paramInt1)
                      {
                      default: 
                        paramInt5 = k;
                      }
                    }
                    for (;;)
                    {
                      ((Bundle)localObject4).putString("key_action_DATA", String.format(((aovd)localObject2).b, new Object[] { paramString1, Integer.valueOf(paramInt5) }));
                      paramInt2 = paramString2.length() - ((aovd)localObject2).jdField_a_of_type_JavaLangString.length();
                      if (paramInt2 >= 0)
                      {
                        ((aspy)localObject1).a(paramInt2, paramString2.length(), (Bundle)localObject4);
                        azqs.b(paramQQAppInterface, "dc00898", "", "", "qq_vip", "0X8009CA5", paramInt5, 0, "", "", "", "");
                      }
                      if ((paramInt1 == 5) && (paramInt3 == 8)) {}
                      try
                      {
                        localObject2 = new Bundle();
                        ((Bundle)localObject2).putInt("key_action", 1);
                        ((Bundle)localObject2).putString("key_action_DATA", "mqzone://arouse/lovermainpage");
                        paramInt2 = paramString2.length() - QzoneConfig.getInstance().getConfig("QZoneSetting", "LoverBonusAIOGrayTipsLinkText", "立即查看").length();
                        if (paramInt2 >= 0) {
                          ((aspy)localObject1).a(paramInt2, paramString2.length(), (Bundle)localObject2);
                        }
                      }
                      catch (Exception localException)
                      {
                        for (;;)
                        {
                          QLog.e("reactive", 2, "TYPE_LOVER_CHAT flag=" + paramInt3 + localException.toString());
                        }
                        localObject3 = new MessageForUniteGrayTip();
                        ((MessageForUniteGrayTip)localObject3).hasRead = 0;
                        ((MessageForUniteGrayTip)localObject3).subType = j;
                        ((MessageForUniteGrayTip)localObject3).initGrayTipMsg(paramQQAppInterface, (aspy)localObject1);
                        localObject1 = new StringBuilder(21);
                        ((StringBuilder)localObject1).append(paramLong2).append("_").append(paramLong3);
                        ((MessageForUniteGrayTip)localObject3).tipParam.d = ((StringBuilder)localObject1).toString();
                        localObject1 = paramQQAppInterface.a().b(paramString1, 0);
                        if (localObject1 == null) {
                          break label4735;
                        }
                      }
                      if ((paramInt1 != 5) || (paramInt3 == 8)) {
                        break;
                      }
                      localObject2 = autp.a();
                      if ((localObject2 == null) || (((Map)localObject2).size() <= 0)) {
                        break;
                      }
                      localObject4 = ((Map)localObject2).keySet().iterator();
                      while (((Iterator)localObject4).hasNext())
                      {
                        localObject5 = (String)((Iterator)localObject4).next();
                        localObject6 = new Bundle();
                        str = (String)((Map)localObject2).get(localObject5);
                        if ((!TextUtils.isEmpty((CharSequence)localObject5)) && (!TextUtils.isEmpty(str)))
                        {
                          ((Bundle)localObject6).putInt("key_action", 32);
                          ((Bundle)localObject6).putString("key_action_DATA", (String)localObject5);
                          ((Bundle)localObject6).putString("key_a_action_DATA", str);
                          paramInt2 = paramString2.lastIndexOf((String)localObject5);
                          if (paramInt2 >= 0) {
                            ((aspy)localObject1).a(paramInt2, ((String)localObject5).length() + paramInt2, (Bundle)localObject6);
                          }
                          if (QLog.isColorLevel()) {
                            QLog.d("reactive", 2, "addHotFriendAIOGrayTips grayStr=" + paramString2 + "spanPos=" + paramInt2 + "iconName=" + (String)localObject5 + "value=" + str);
                          }
                        }
                      }
                      if (paramInt2 == 0)
                      {
                        paramInt5 = 1;
                      }
                      else
                      {
                        paramInt5 = 2;
                        continue;
                        if (paramInt2 == 0)
                        {
                          paramInt5 = 3;
                        }
                        else
                        {
                          paramInt5 = 4;
                          continue;
                          if (paramInt2 == 0) {
                            paramInt5 = 5;
                          } else {
                            paramInt5 = 6;
                          }
                        }
                      }
                    }
                    if (!((List)localObject1).isEmpty())
                    {
                      localObject1 = (MessageRecord)((List)localObject1).get(((List)localObject1).size() - 1);
                      if (((localObject1 instanceof MessageForUniteGrayTip)) && (((MessageForUniteGrayTip)localObject1).tipParam != null) && (((MessageForUniteGrayTip)localObject1).subType == ((MessageForUniteGrayTip)localObject3).subType) && (((MessageForUniteGrayTip)localObject1).tipParam.c.equals(((MessageForUniteGrayTip)localObject3).tipParam.c)) && (((MessageForUniteGrayTip)localObject3).tipParam.a - ((MessageForUniteGrayTip)localObject1).tipParam.a <= 1L)) {
                        if (QLog.isColorLevel()) {
                          QLog.d("FriendReactive", 2, "addHotFriendAIOGray look! backend give repeat push!");
                        }
                      }
                    }
                    label4735:
                    do
                    {
                      return;
                      if ((paramInt1 == 5) && (paramInt3 == 8)) {
                        ((MessageForUniteGrayTip)localObject3).msgtype = -5023;
                      }
                      if (!TextUtils.isEmpty(paramString2))
                      {
                        aspz.a(paramQQAppInterface, (MessageForUniteGrayTip)localObject3);
                        if (paramInt4 != 0) {
                          localalto.f(paramString1);
                        }
                      }
                    } while (paramInt1 == 6);
                    azqs.b(paramQQAppInterface, "dc00898", "", "", "0X8007779", "0X8007779", i, 0, "", "", "", "");
                    return;
                    label4815:
                    break label393;
                    label4818:
                    break label393;
                    label4821:
                    break label351;
                    localObject3 = paramString2;
                    paramString2 = (String)localObject1;
                    i2 = m;
                    localObject1 = localObject3;
                    n = i;
                    m = j;
                    i = i2;
                    j = i1;
                    break;
                    label4859:
                    localObject3 = localObject1;
                    localObject1 = paramString2;
                    paramString2 = (String)localObject3;
                  }
                  Object localObject3 = localObject1;
                  localObject1 = paramString2;
                  paramString2 = (String)localObject3;
                }
              }
            }
          }
        }
      }
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2)
  {
    int i;
    try
    {
      localObject2 = bdgc.m(paramQQAppInterface, paramString1);
      localObject1 = (alto)paramQQAppInterface.getManager(51);
      i = -5020;
      if (!QLog.isColorLevel()) {
        break label640;
      }
      QLog.d("FriendReactive", 2, "addLoveGrayTips type=" + paramInt1 + "subtype=" + paramInt2 + "LoverMainkeyText=" + paramString2 + "loveSubkeyText=" + paramString3);
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e("FriendReactive", 2, "addLoveGrayTips exception" + paramQQAppInterface.toString());
      return;
    }
    Object localObject1 = paramString2;
    if (!TextUtils.isEmpty(paramString2))
    {
      localObject1 = paramString2;
      if (paramString2.contains("{friend_nick_name}")) {
        localObject1 = paramString2.replace("{friend_nick_name}", (CharSequence)localObject2);
      }
    }
    Object localObject2 = aone.a().b("" + paramInt2);
    paramString2 = (String)localObject2;
    if (localObject2 == null) {
      paramString2 = new aond().b("0");
    }
    localObject2 = paramString2.jdField_a_of_type_JavaLangString;
    switch (paramString2.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      localObject2 = new aspy(paramString1, paramString1, (String)localObject1, 0, paramInt1, 655384, ayzl.a());
      Bundle localBundle = new Bundle();
      localBundle.putInt("key_action", 1);
      localBundle.putString("key_action_DATA", paramString2);
      if (QLog.isColorLevel()) {
        QLog.d("FriendReactive", 2, "addLoveGrayTips jumpurl=" + paramString2);
      }
      paramInt1 = ((String)localObject1).length() - paramString3.length();
      if (paramInt1 >= 0) {
        ((aspy)localObject2).a(paramInt1, ((String)localObject1).length(), localBundle);
      }
      paramString2 = new MessageForUniteGrayTip();
      paramString2.hasRead = 0;
      paramString2.subType = 9;
      paramString2.initGrayTipMsg(paramQQAppInterface, (aspy)localObject2);
      paramString2.saveExtInfoToExtStr("love_c2c_aio_businessSubtype", paramInt2 + "");
      paramString3 = new StringBuilder(21);
      paramString3.append(paramLong1).append("_").append(paramLong2);
      paramString2.tipParam.d = paramString3.toString();
      paramString1 = paramQQAppInterface.a().b(paramString1, 0);
      if ((paramString1 != null) && (!paramString1.isEmpty()))
      {
        paramString1 = (MessageRecord)paramString1.get(paramString1.size() - 1);
        if (((paramString1 instanceof MessageForUniteGrayTip)) && (((MessageForUniteGrayTip)paramString1).tipParam != null) && (((MessageForUniteGrayTip)paramString1).subType == paramString2.subType) && (((MessageForUniteGrayTip)paramString1).tipParam.c.equals(paramString2.tipParam.c)) && (paramString2.tipParam.a - ((MessageForUniteGrayTip)paramString1).tipParam.a <= 1L))
        {
          if (!QLog.isColorLevel()) {
            break label645;
          }
          QLog.d("FriendReactive", 2, "addLoveGrayTips look! backend give repeat push!");
          return;
          paramString2 = paramString2 + paramString3;
          paramInt1 = -5023;
          break;
        }
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        aspz.a(paramQQAppInterface, paramString2);
        return;
        label640:
        if (paramInt2 >= 2) {}
      }
      else
      {
        label645:
        return;
      }
      switch (paramInt1)
      {
      }
      paramString2 = "";
      paramInt1 = i;
      break;
      paramString2 = "https://h5.qzone.qq.com/mood/lover?_wv=16777219&from=common&qzUseTransparentNavBar=1&_proxy=1";
      continue;
      paramString2 = (String)localObject2;
      continue;
      paramString2 = (String)localObject2;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, submsgtype0xc7.HotFriendNotify paramHotFriendNotify, amlj paramamlj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HotFriend_PushMessage", 2, "decodeC2CMsgPkgSubMsgType0xc7");
    }
    long l3 = paramamlj.b;
    long l4 = paramamlj.c;
    alto localalto;
    long l2;
    Object localObject1;
    String str1;
    int i;
    Object localObject3;
    Object localObject4;
    Object localObject2;
    Bundle localBundle;
    String str2;
    int j;
    int m;
    if (paramHotFriendNotify != null)
    {
      localalto = (alto)paramQQAppInterface.getManager(51);
      l2 = paramHotFriendNotify.uint64_dst_uin.get();
      localObject1 = String.valueOf(l2);
      str1 = bdgc.m(paramQQAppInterface, (String)localObject1);
      i = 1;
      if (paramHotFriendNotify.bytes_wildcard_wording.has())
      {
        localObject3 = autp.a(paramQQAppInterface, paramHotFriendNotify.bytes_wildcard_wording.get().toStringUtf8(), str1, localalto);
        localObject4 = autp.a(paramQQAppInterface, (String)((List)localObject3).get(0), (String)localObject1);
        str1 = (String)((List)localObject4).get(0);
        ((List)localObject3).remove(0);
        ((List)localObject4).remove(0);
        localObject2 = new aspy((String)localObject1, (String)localObject1, str1, 0, -5040, 2097153, ayzl.a());
        if ((localObject4 != null) && (((List)localObject4).size() > 0))
        {
          i = 0;
          while (i < ((List)localObject4).size())
          {
            localBundle = new Bundle();
            str2 = (String)((List)localObject4).get(i);
            if (!TextUtils.isEmpty(str2))
            {
              localBundle.putString("image_resource", str2);
              j = str1.lastIndexOf(str2);
              if (j >= 0) {
                ((aspy)localObject2).a(j, str2.length() + j, localBundle);
              }
              if (QLog.isColorLevel()) {
                QLog.d("reactive", 2, "addHotFriendAIOGrayTips grayStr=" + str1 + "iconPos=" + j + "icon=" + str2 + "grayStr=" + str1);
              }
            }
            i += 1;
          }
        }
        if ((localObject3 != null) && (((List)localObject3).size() > 0))
        {
          Collections.sort((List)localObject3, new auts());
          localObject4 = new ArrayList();
          j = 0;
          if (j < ((List)localObject3).size())
          {
            localBundle = new Bundle();
            str2 = (String)((List)localObject3).get(j);
            if (!TextUtils.isEmpty(str2))
            {
              localBundle.putInt("key_action", 11);
              localBundle.putString("key_action_DATA", str2);
              i = 0;
              m = str1.indexOf(str2, i);
              if (m >= 0) {
                break label473;
              }
            }
          }
        }
      }
    }
    label459:
    label2382:
    label2389:
    for (;;)
    {
      label473:
      int n;
      if (m < 0)
      {
        j += 1;
        break;
        n = str2.length();
        i = m + n;
        Iterator localIterator = ((ArrayList)localObject4).iterator();
        Pair localPair;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localPair = (Pair)localIterator.next();
        } while ((m < ((Integer)localPair.first).intValue()) || (m >= ((Integer)localPair.second).intValue()));
      }
      for (int k = 1;; k = 0)
      {
        if (k != 0) {
          break label2389;
        }
        ((ArrayList)localObject4).add(new Pair(Integer.valueOf(m), Integer.valueOf(m + n)));
        if (m >= 0)
        {
          ((aspy)localObject2).a(m, i, localBundle);
          if (QLog.isColorLevel()) {
            QLog.d("Old0x210C7PushHelper", 2, "spanPos=" + m + " fromIndex=" + i);
          }
        }
        break label459;
        break;
        localObject3 = new MessageForUniteGrayTip();
        ((MessageForUniteGrayTip)localObject3).hasRead = 0;
        ((MessageForUniteGrayTip)localObject3).initGrayTipMsg(paramQQAppInterface, (aspy)localObject2);
        localObject2 = new StringBuilder(21);
        ((StringBuilder)localObject2).append(l3).append("_").append(l4);
        ((MessageForUniteGrayTip)localObject3).tipParam.d = ((StringBuilder)localObject2).toString();
        localObject1 = paramQQAppInterface.a().b((String)localObject1, 0);
        if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
        {
          localObject1 = (MessageRecord)((List)localObject1).get(((List)localObject1).size() - 1);
          if (((localObject1 instanceof MessageForUniteGrayTip)) && (((MessageForUniteGrayTip)localObject1).tipParam != null) && (((MessageForUniteGrayTip)localObject1).subType == ((MessageForUniteGrayTip)localObject3).subType) && (((MessageForUniteGrayTip)localObject1).tipParam.c.equals(((MessageForUniteGrayTip)localObject3).tipParam.c)) && (((MessageForUniteGrayTip)localObject3).tipParam.a - ((MessageForUniteGrayTip)localObject1).tipParam.a <= 1L))
          {
            if (QLog.isColorLevel()) {
              QLog.d("FriendReactive", 2, "addHotFriendAIOGray look! backend give repeat push!");
            }
            return;
          }
        }
        if (!TextUtils.isEmpty(str1)) {
          aspz.a(paramQQAppInterface, (MessageForUniteGrayTip)localObject3);
        }
        i = 0;
        if (!paramHotFriendNotify.uint32_notify_type.has())
        {
          localObject2 = new ArrayList();
          paramamlj = localalto.a(String.valueOf(l2));
          if (paramamlj != null) {
            break label2382;
          }
          paramamlj = new ExtensionInfo();
          paramamlj.uin = String.valueOf(l2);
        }
        for (;;)
        {
          localObject3 = new StringBuilder(128);
          ((StringBuilder)localObject3).append(" === hotFriend uin: ").append(l2);
          ((StringBuilder)localObject3).append(" msgUid: ").append(l4).append(" msgSeq: ").append(l3);
          boolean bool1 = false;
          boolean bool2 = false;
          if (paramHotFriendNotify.uint64_notify_time.has())
          {
            l1 = paramHotFriendNotify.uint64_notify_time.get();
            long l5 = paramQQAppInterface.getPreferences().getLong("inccheckupdatetimeStamp9", 0L);
            bool1 = bool2;
            if (l1 < l5)
            {
              ((StringBuilder)localObject3).append(", notify_time is out of date notifyTime=" + l1 + "timeStamps=" + l5);
              if (QLog.isColorLevel()) {
                QLog.i("HotFriend_PushMessage", 2, ((StringBuilder)localObject3).toString());
              }
              bool1 = true;
            }
            ((StringBuilder)localObject3).append(", notify_time" + l1 + "timeStamps=" + l5);
          }
          long l1 = -1L;
          if (paramHotFriendNotify.uint64_notify_time.has()) {
            l1 = paramHotFriendNotify.uint64_notify_time.get();
          }
          j = i;
          if (paramamlj != null)
          {
            j = i;
            if (paramamlj.lastGrayPushTime == l1)
            {
              j = i;
              if (l1 != -1L)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("FriendReactive", 2, "addHotFriendAIOGrayTips lastPushTime=" + l1 + "needAddGray isfalse");
                }
                j = 0;
              }
            }
            paramamlj.lastGrayPushTime = l1;
          }
          if (paramHotFriendNotify.uint32_praise_hot_level.has())
          {
            i = paramamlj.praiseHotLevel;
            k = paramHotFriendNotify.uint32_praise_hot_level.get();
            paramamlj.praiseHotLevel = k;
            ((StringBuilder)localObject3).append(", praiseHotLevel=").append(k);
            if (paramHotFriendNotify.uint32_praise_flag.has())
            {
              m = paramHotFriendNotify.uint32_praise_flag.get();
              if (j != 0) {
                a(paramQQAppInterface, 1, k, m, String.valueOf(l2), i, l1, null, l3, l4, paramHotFriendNotify.uint32_show_recheck_entry.get());
              }
            }
          }
          if (paramHotFriendNotify.uint32_praise_hot_days.has())
          {
            i = paramHotFriendNotify.uint32_praise_hot_days.get();
            paramamlj.praiseDays = i;
            ((StringBuilder)localObject3).append(", praiseDays=").append(i);
          }
          if (paramHotFriendNotify.uint32_chat_hot_level.has())
          {
            i = paramHotFriendNotify.uint32_chat_hot_level.get();
            k = paramamlj.chatHotLevel;
            paramamlj.chatHotLevel = i;
            ((StringBuilder)localObject3).append(", chatHotLevel=").append(i);
            if (paramHotFriendNotify.uint32_chat_flag.has())
            {
              m = paramHotFriendNotify.uint32_chat_flag.get();
              if (j != 0) {
                a(paramQQAppInterface, 2, i, m, String.valueOf(l2), k, l1, null, l3, l4, paramHotFriendNotify.uint32_show_recheck_entry.get());
              }
            }
          }
          str1 = null;
          if (paramHotFriendNotify.bytes_key_wording.has()) {
            str1 = paramHotFriendNotify.bytes_key_wording.get().toStringUtf8();
          }
          i = -1;
          k = paramamlj.loverChatLevel;
          if (paramHotFriendNotify.uint32_key_hot_level.has())
          {
            i = paramHotFriendNotify.uint32_key_hot_level.get();
            paramamlj.loverChatLevel = i;
            ((StringBuilder)localObject3).append(", loverChatLevel=").append(i);
          }
          if (paramHotFriendNotify.uint32_key_trans_flag.has())
          {
            if (paramHotFriendNotify.uint32_key_trans_flag.get() != 0)
            {
              bool2 = true;
              paramamlj.loverTransFlag = bool2;
              ((StringBuilder)localObject3).append(", loverTransFlag=").append(paramamlj.loverTransFlag);
            }
          }
          else
          {
            if (paramHotFriendNotify.uint32_key_flag.has())
            {
              m = paramHotFriendNotify.uint32_key_flag.get();
              paramamlj.loverFlag = m;
              ((StringBuilder)localObject3).append(", loverFlag=").append(m);
              if (j != 0) {
                a(paramQQAppInterface, 5, i, m, String.valueOf(l2), k, l1, str1, l3, l4, paramHotFriendNotify.uint32_show_recheck_entry.get());
              }
            }
            str1 = null;
            if (paramHotFriendNotify.loverKeyMainWording.has()) {
              str1 = paramHotFriendNotify.loverKeyMainWording.get().toStringUtf8();
            }
            localObject1 = null;
            if (paramHotFriendNotify.loverKeyLinkWording.has()) {
              localObject1 = paramHotFriendNotify.loverKeyLinkWording.get().toStringUtf8();
            }
            i = -1;
            if (paramHotFriendNotify.loverKeySubBusinessType.has()) {
              i = paramHotFriendNotify.loverKeySubBusinessType.get();
            }
            if (paramHotFriendNotify.loverKeyBusinessType.has())
            {
              k = paramHotFriendNotify.loverKeyBusinessType.get();
              if (j != 0) {
                a(paramQQAppInterface, k, i, String.valueOf(l2), str1, (String)localObject1, l3, l4);
              }
            }
            if (paramHotFriendNotify.uint32_key_hot_days.has())
            {
              i = paramHotFriendNotify.uint32_key_hot_days.get();
              paramamlj.loverChatDays = i;
              ((StringBuilder)localObject3).append(", loverChatDays=").append(i);
            }
            if (paramHotFriendNotify.uint32_chat_hot_days.has())
            {
              i = paramHotFriendNotify.uint32_chat_hot_days.get();
              paramamlj.chatDays = i;
              ((StringBuilder)localObject3).append(", chatDays=").append(i);
            }
            if (!autp.b()) {
              break label2228;
            }
            if (paramHotFriendNotify.uint32_boat_level.has())
            {
              i = paramamlj.newBestIntimacyType;
              k = paramHotFriendNotify.uint32_boat_level.get();
              paramamlj.newBestIntimacyType = k;
              ((StringBuilder)localObject3).append(", boatLevel=").append(k);
              if (paramHotFriendNotify.uint32_boat_flag.has())
              {
                m = paramHotFriendNotify.uint32_boat_flag.get();
                if (paramHotFriendNotify.bytes_boat_wording.has()) {
                  paramHotFriendNotify.bytes_boat_wording.get().toStringUtf8();
                }
                if (j != 0) {
                  a(paramQQAppInterface, 6, k, m, String.valueOf(l2), i, l1, null, l3, l4, paramHotFriendNotify.uint32_show_recheck_entry.get());
                }
              }
            }
          }
          for (;;)
          {
            if (paramHotFriendNotify.uint32_close_days.has())
            {
              i = paramHotFriendNotify.uint32_close_days.get();
              paramamlj.bestIntimacyDays = i;
              ((StringBuilder)localObject3).append(", closeDays=").append(i);
            }
            if (paramHotFriendNotify.uint64_last_praise_time.has())
            {
              l1 = paramHotFriendNotify.uint64_last_praise_time.get();
              paramamlj.lastpraiseTime = (86400L * l1 - 28800L);
              ((StringBuilder)localObject3).append(", lastpraiseTime=").append(l1);
            }
            if (paramHotFriendNotify.uint64_last_chat_time.has())
            {
              l1 = paramHotFriendNotify.uint64_last_chat_time.get();
              paramamlj.lastChatTime = (86400L * l1 - 28800L);
              ((StringBuilder)localObject3).append(", lastchatTime=").append(l1);
            }
            if (paramHotFriendNotify.uint64_last_key_time.has())
            {
              l1 = paramHotFriendNotify.uint64_last_key_time.get();
              paramamlj.loverLastChatTime = (86400L * l1 - 28800L);
              ((StringBuilder)localObject3).append(", lastLoverChatTime=").append(l1);
            }
            if (QLog.isColorLevel()) {
              QLog.i("HotFriend_PushMessage", 2, ((StringBuilder)localObject3).toString() + "isTimeOutOfDate=" + bool1);
            }
            if (bool1) {
              break;
            }
            localalto.a(paramamlj);
            ((ArrayList)localObject2).add(String.valueOf(l2));
            if (((ArrayList)localObject2).isEmpty()) {
              break;
            }
            paramQQAppInterface.a(1).notifyUI(107, true, localObject2);
            return;
            bool2 = false;
            break label1552;
            if (paramHotFriendNotify.uint32_close_level.has())
            {
              i = paramamlj.bestIntimacyType;
              k = paramHotFriendNotify.uint32_close_level.get();
              paramamlj.bestIntimacyType = k;
              ((StringBuilder)localObject3).append(", closeLevel=").append(k);
              if (paramHotFriendNotify.uint32_close_flag.has())
              {
                m = paramHotFriendNotify.uint32_close_flag.get();
                if (j != 0) {
                  a(paramQQAppInterface, 3, k, m, String.valueOf(l2), i, l1, null, l3, l4, paramHotFriendNotify.uint32_show_recheck_entry.get());
                }
              }
            }
          }
          if ((paramHotFriendNotify.uint32_notify_type.get() != 1) || (!paramHotFriendNotify.msg_friendship_flag_notify.has())) {
            break;
          }
          autp.a(paramQQAppInterface, paramamlj, (submsgtype0xc7.FriendShipFlagNotify)paramHotFriendNotify.msg_friendship_flag_notify.get());
          return;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("HotFriend_PushMessage", 2, "decodeC2CMsgPkgSubMsgType0xc7 data is null");
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     autr
 * JD-Core Version:    0.7.0.1
 */