import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import org.json.JSONException;
import org.json.JSONObject;

public class bhtw
{
  public static String a = "com.qq.hotact";
  
  public static int a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    int i = 1;
    if (!bhtx.a(paramQQAppInterface)) {
      if (QLog.isColorLevel()) {
        QLog.d("WholePeopleConstant", 2, "getLebaRednumOrPoint, check wholePeopleEntryIsOpen return false, not show redtouch");
      }
    }
    do
    {
      return 0;
      if ((paramQQAppInterface.a().a != null) && (paramQQAppInterface.a().a.b)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("WholePeopleConstant", 2, "getLebaRednumOrPoint, check wholePeopleEntryIsOpen return false, not show redtouch");
    return 0;
    paramQQAppInterface = (axzw)paramQQAppInterface.getManager(160);
    RedTouchItem localRedTouchItem1 = paramQQAppInterface.a(10013);
    RedTouchItem localRedTouchItem2 = paramQQAppInterface.a(10014);
    int j;
    if ((paramQQAppInterface.a(localRedTouchItem1, false)) && (localRedTouchItem1.passThroughLevel >= 1)) {
      if (localRedTouchItem1.redtouchType == 2)
      {
        j = localRedTouchItem1.count + 0;
        i = 0;
      }
    }
    for (;;)
    {
      int k = i;
      int m = j;
      if (paramQQAppInterface.a(localRedTouchItem2, false))
      {
        k = i;
        m = j;
        if (localRedTouchItem2.passThroughLevel >= 2)
        {
          if (localRedTouchItem2.redtouchType != 2) {
            break label247;
          }
          m = j + localRedTouchItem2.count;
          k = i;
        }
      }
      label183:
      if (QLog.isColorLevel()) {
        QLog.d("WholePeopleConstant", 2, "getLebaRednumOrPoint redNum=" + m + ", redPoint=" + k + ", unreadMsg=" + localRedTouchItem2);
      }
      if (paramBoolean) {}
      for (;;)
      {
        return m;
        j = 0;
        break;
        label247:
        k = i + 1;
        m = j;
        break label183;
        m = k;
      }
      i = 0;
      j = 0;
    }
  }
  
  public static BusinessInfoCheckUpdate.AppInfo a(int paramInt1, int paramInt2)
  {
    BusinessInfoCheckUpdate.AppInfo localAppInfo = new BusinessInfoCheckUpdate.AppInfo();
    if (QLog.isColorLevel()) {
      QLog.i("WholePeopleConstant", 2, "getMsgRedTouch redNum:" + paramInt1 + " redPoint:" + paramInt2);
    }
    if ((paramInt1 <= 0) && (paramInt2 <= 0)) {
      return localAppInfo;
    }
    if (paramInt1 > 0)
    {
      localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
      if (paramInt1 > 99) {
        localRedTypeInfo.red_content.set("99+");
      }
      for (;;)
      {
        localRedTypeInfo.red_type.set(5);
        localRedTypeInfo.red_desc.set("{'cn':'#FF0000'}");
        localAppInfo.red_display_info.red_type_info.add(localRedTypeInfo);
        localAppInfo.iNewFlag.set(1);
        return localAppInfo;
        localRedTypeInfo.red_content.set(String.valueOf(paramInt1));
      }
    }
    BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
    localRedTypeInfo.red_type.set(0);
    localRedTypeInfo.red_desc.set("");
    localRedTypeInfo.red_content.set("");
    localAppInfo.red_display_info.red_type_info.add(localRedTypeInfo);
    localAppInfo.iNewFlag.set(1);
    return localAppInfo;
  }
  
  public static EIPCResult a(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WholePeopleConstant", 2, "clearMsgRedPoint");
    }
    paramString = null;
    Bundle localBundle = new Bundle();
    paramBundle = new EIPCResult();
    paramBundle.data = localBundle;
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      paramString = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    }
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WholePeopleConstant", 2, "clearMsgRedPoint, app is null");
      }
      paramBundle.code = -1;
      return paramBundle;
    }
    ((axzw)paramString.getManager(160)).a(10014);
    paramBundle.code = 0;
    return paramBundle;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, RedTouch paramRedTouch)
  {
    Object localObject1;
    Object localObject2;
    int j;
    boolean bool2;
    int i;
    boolean bool1;
    if (paramQQAppInterface != null)
    {
      localObject1 = (axzw)paramQQAppInterface.getManager(160);
      paramQQAppInterface = ((axzw)localObject1).a(10013);
      localObject2 = ((axzw)localObject1).a(10014);
      if (!((axzw)localObject1).a(paramQQAppInterface, false)) {
        break label1102;
      }
      if (paramQQAppInterface.redtouchType != 2) {
        break label205;
      }
      j = paramQQAppInterface.count;
      bool2 = false;
      i = 0;
      j += 0;
      bool1 = true;
    }
    for (;;)
    {
      int k = i;
      int m = j;
      if (((axzw)localObject1).a((RedTouchItem)localObject2, false))
      {
        k = i;
        m = j;
        if (((RedTouchItem)localObject2).passThroughLevel >= 1)
        {
          if (((RedTouchItem)localObject2).redtouchType != 2) {
            break label269;
          }
          m = j + ((RedTouchItem)localObject2).count;
          k = i;
        }
      }
      label123:
      if (QLog.isColorLevel()) {
        QLog.i("WholePeopleConstant", 2, "updateEntryRedTouch redNum:" + m + " redPoint:" + k + " hasUnnormal:" + bool2 + " isText:" + bool1);
      }
      if ((m <= 0) && (k <= 0) && (!bool2)) {
        paramRedTouch.d();
      }
      label205:
      do
      {
        for (;;)
        {
          return;
          if (paramQQAppInterface.redtouchType == 1)
          {
            bool1 = true;
            bool2 = false;
            i = 1;
            j = 0;
            break;
          }
          if ((paramQQAppInterface.redtouchType != 3) && (paramQQAppInterface.redtouchType != 4)) {
            break label1102;
          }
          if (paramQQAppInterface.redtouchType == 4) {}
          for (bool1 = true;; bool1 = false)
          {
            bool2 = true;
            i = 0;
            j = 0;
            break;
          }
          k = i + 1;
          m = j;
          break label123;
          if (m > 0)
          {
            paramQQAppInterface = new BusinessInfoCheckUpdate.RedTypeInfo();
            localObject1 = new BusinessInfoCheckUpdate.AppInfo();
            if (m > 99) {
              paramQQAppInterface.red_content.set("99+");
            }
            for (;;)
            {
              paramQQAppInterface.red_type.set(5);
              paramQQAppInterface.red_desc.set("{'cn':'#FF0000'}");
              ((BusinessInfoCheckUpdate.AppInfo)localObject1).red_display_info.red_type_info.add(paramQQAppInterface);
              ((BusinessInfoCheckUpdate.AppInfo)localObject1).iNewFlag.set(1);
              paramRedTouch.a((BusinessInfoCheckUpdate.AppInfo)localObject1);
              return;
              paramQQAppInterface.red_content.set(String.valueOf(m));
            }
          }
          if ((bool2) && (bool1))
          {
            localObject1 = new BusinessInfoCheckUpdate.RedTypeInfo();
            localObject2 = new BusinessInfoCheckUpdate.AppInfo();
            ((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_content.set(paramQQAppInterface.tips);
            ((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_type.set(5);
            ((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_desc.set("{'cn':'#FF0000'}");
            ((BusinessInfoCheckUpdate.AppInfo)localObject2).red_display_info.red_type_info.add((MessageMicro)localObject1);
            ((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.set(1);
            paramRedTouch.a((BusinessInfoCheckUpdate.AppInfo)localObject2);
            return;
          }
          if ((!bool2) || (bool1)) {
            break label1031;
          }
          localObject1 = new BusinessInfoCheckUpdate.AppInfo();
          if (!TextUtils.isEmpty(paramQQAppInterface.icon))
          {
            if (!TextUtils.isEmpty(paramQQAppInterface.tips))
            {
              localObject2 = new BusinessInfoCheckUpdate.RedTypeInfo();
              ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_content.set(paramQQAppInterface.tips);
              ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_type.set(4);
              ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_desc.set("{'cn':'#00000000','cr':'#888888'}");
              ((BusinessInfoCheckUpdate.AppInfo)localObject1).red_display_info.red_type_info.add((MessageMicro)localObject2);
              localObject2 = new BusinessInfoCheckUpdate.RedTypeInfo();
              ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_content.set(bggq.a(BaseApplicationImpl.sApplication.getApplicationContext(), 3.0F) + "");
              ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_type.set(9);
              ((BusinessInfoCheckUpdate.AppInfo)localObject1).red_display_info.red_type_info.add((MessageMicro)localObject2);
            }
            localObject2 = new BusinessInfoCheckUpdate.RedTypeInfo();
            ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_content.set(paramQQAppInterface.icon);
            ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_type.set(3);
            paramQQAppInterface = new JSONObject();
            try
            {
              paramQQAppInterface.put("dot", 1);
              ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_desc.set(paramQQAppInterface.toString());
              ((BusinessInfoCheckUpdate.AppInfo)localObject1).red_display_info.red_type_info.add((MessageMicro)localObject2);
              ((BusinessInfoCheckUpdate.AppInfo)localObject1).iNewFlag.set(1);
              paramRedTouch.a((BusinessInfoCheckUpdate.AppInfo)localObject1);
              try
              {
                paramQQAppInterface = (TextView)paramRedTouch.findViewById(30);
                localObject1 = (LinearLayout.LayoutParams)paramQQAppInterface.getLayoutParams();
                ((LinearLayout.LayoutParams)localObject1).weight = 1.0F;
                ((LinearLayout.LayoutParams)localObject1).width = 0;
                paramQQAppInterface.setEllipsize(TextUtils.TruncateAt.END);
                paramQQAppInterface.setLayoutParams((ViewGroup.LayoutParams)localObject1);
                paramQQAppInterface = paramRedTouch.findViewById(100);
                paramQQAppInterface.setPadding(afur.a(160.0F, paramQQAppInterface.getResources()), paramQQAppInterface.getPaddingTop(), paramQQAppInterface.getPaddingRight(), paramQQAppInterface.getPaddingBottom());
                return;
              }
              catch (Exception paramQQAppInterface) {}
              if (QLog.isColorLevel())
              {
                QLog.i("WholePeopleConstant", 2, paramQQAppInterface.getMessage(), paramQQAppInterface);
                return;
              }
            }
            catch (JSONException localJSONException)
            {
              for (;;)
              {
                localJSONException.printStackTrace();
              }
            }
          }
        }
        localObject2 = new BusinessInfoCheckUpdate.RedTypeInfo();
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_content.set(paramQQAppInterface.tips);
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_type.set(4);
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_desc.set("{'cn':'#00000000','cr':'#888888'}");
        ((BusinessInfoCheckUpdate.AppInfo)localObject1).red_display_info.red_type_info.add((MessageMicro)localObject2);
        paramQQAppInterface = new BusinessInfoCheckUpdate.RedTypeInfo();
        paramQQAppInterface.red_type.set(0);
        paramQQAppInterface.red_desc.set("");
        paramQQAppInterface.red_content.set("");
        ((BusinessInfoCheckUpdate.AppInfo)localObject1).red_display_info.red_type_info.add(paramQQAppInterface);
        ((BusinessInfoCheckUpdate.AppInfo)localObject1).iNewFlag.set(1);
        paramRedTouch.a((BusinessInfoCheckUpdate.AppInfo)localObject1);
        try
        {
          paramQQAppInterface = (TextView)paramRedTouch.findViewById(30);
          localObject1 = (LinearLayout.LayoutParams)paramQQAppInterface.getLayoutParams();
          ((LinearLayout.LayoutParams)localObject1).weight = 1.0F;
          ((LinearLayout.LayoutParams)localObject1).width = 0;
          paramQQAppInterface.setEllipsize(TextUtils.TruncateAt.END);
          paramQQAppInterface.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          paramQQAppInterface = paramRedTouch.findViewById(100);
          paramQQAppInterface.setPadding(afur.a(160.0F, paramQQAppInterface.getResources()), paramQQAppInterface.getPaddingTop(), paramQQAppInterface.getPaddingRight(), paramQQAppInterface.getPaddingBottom());
          return;
        }
        catch (Exception paramQQAppInterface) {}
      } while (!QLog.isColorLevel());
      label269:
      QLog.i("WholePeopleConstant", 2, paramQQAppInterface.getMessage(), paramQQAppInterface);
      return;
      label1031:
      paramQQAppInterface = new BusinessInfoCheckUpdate.RedTypeInfo();
      localObject1 = new BusinessInfoCheckUpdate.AppInfo();
      paramQQAppInterface.red_type.set(0);
      paramQQAppInterface.red_desc.set("");
      paramQQAppInterface.red_content.set("");
      ((BusinessInfoCheckUpdate.AppInfo)localObject1).red_display_info.red_type_info.add(paramQQAppInterface);
      ((BusinessInfoCheckUpdate.AppInfo)localObject1).iNewFlag.set(1);
      paramRedTouch.a((BusinessInfoCheckUpdate.AppInfo)localObject1);
      return;
      label1102:
      bool1 = true;
      bool2 = false;
      i = 0;
      j = 0;
    }
  }
  
  public static EIPCResult b(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WholePeopleConstant", 2, "getMsgRedPoint");
    }
    paramString = null;
    paramBundle = new Bundle();
    EIPCResult localEIPCResult = new EIPCResult();
    localEIPCResult.data = paramBundle;
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      paramString = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    }
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WholePeopleConstant", 2, "getMsgRedPoint, app is null");
      }
      localEIPCResult.code = -1;
      return localEIPCResult;
    }
    paramString = (axzw)paramString.getManager(160);
    RedTouchItem localRedTouchItem = paramString.a(10014);
    int i;
    if (paramString.a(localRedTouchItem, false)) {
      if (localRedTouchItem.redtouchType == 2)
      {
        i = localRedTouchItem.count + 0;
        paramInt = 0;
      }
    }
    for (;;)
    {
      paramBundle.putInt("redPointCount", paramInt);
      paramBundle.putInt("redNumCount", i);
      if (QLog.isColorLevel()) {
        QLog.i("WholePeopleConstant", 2, "getMsgRedPoint redPointCount:" + paramInt + " redNumCount:" + i);
      }
      localEIPCResult.code = 0;
      return localEIPCResult;
      paramInt = 1;
      i = 0;
      continue;
      paramInt = 0;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhtw
 * JD-Core Version:    0.7.0.1
 */