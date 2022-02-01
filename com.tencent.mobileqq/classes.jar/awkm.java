import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.readinjoy.ReadInJoyManager;
import com.tencent.mobileqq.leba.core.redtouch.LebaSpecificRedTouch.1;
import com.tencent.mobileqq.leba.core.redtouch.LebaSpecificRedTouch.2;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;

public class awkm
{
  public int a;
  private Map<Long, awko> a;
  private int b;
  
  public awkm()
  {
    this.jdField_a_of_type_Int = -1;
  }
  
  private int a(RedTouch paramRedTouch)
  {
    if ((paramRedTouch == null) || (!paramRedTouch.a())) {}
    do
    {
      return 0;
      paramRedTouch = paramRedTouch.a();
    } while (paramRedTouch == null);
    if (paramRedTouch.red_type.get() == 0) {
      return 1;
    }
    if (paramRedTouch.red_type.get() == 5) {
      return 2;
    }
    if (paramRedTouch.red_type.get() == 11) {
      return 3;
    }
    return 3;
  }
  
  private void a(long paramLong, RedTouch paramRedTouch)
  {
    if (this.jdField_a_of_type_JavaUtilMap == null) {}
    int i;
    do
    {
      return;
      int j = awkp.a(paramRedTouch);
      i = j;
      if (j == 0) {
        i = a(paramRedTouch);
      }
    } while (i == 0);
    this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramLong), new awko(i, awkp.b(paramRedTouch)));
  }
  
  private void b(QQAppInterface paramQQAppInterface, Context paramContext, RedTouch paramRedTouch)
  {
    Object localObject;
    BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo;
    if (paramQQAppInterface != null)
    {
      localObject = (ReadInJoyManager)paramQQAppInterface.getManager(96);
      if (localObject != null)
      {
        localRedTypeInfo = ((ReadInJoyManager)localObject).a();
        paramQQAppInterface = ((ReadInJoyManager)localObject).a();
        localObject = ((ReadInJoyManager)localObject).a();
      }
    }
    int i;
    switch (((bnrs)localObject).jdField_a_of_type_Int)
    {
    default: 
      return;
    case 1: 
      i = ((bnrs)localObject).jdField_b_of_type_Int;
      if (i > 99) {
        localRedTypeInfo.red_content.set("99+");
      }
      for (;;)
      {
        localRedTypeInfo.red_type.set(5);
        localRedTypeInfo.red_desc.set("{'cn':'#FF0000'}");
        paramQQAppInterface.red_display_info.red_type_info.add(localRedTypeInfo);
        paramQQAppInterface.iNewFlag.set(1);
        paramRedTouch.a(paramQQAppInterface);
        return;
        localRedTypeInfo.red_content.set(i + "");
      }
    case 3: 
      localRedTypeInfo.red_type.set(3);
      i = ((bnrs)localObject).jdField_c_of_type_Int;
      localRedTypeInfo.red_desc.set("{'drawable':" + i + "}");
      paramQQAppInterface.red_display_info.red_type_info.add(localRedTypeInfo);
      paramQQAppInterface.iNewFlag.set(1);
      paramRedTouch.a(paramQQAppInterface);
      return;
    case 2: 
      localObject = ((bnrs)localObject).jdField_b_of_type_JavaLangString;
      localRedTypeInfo.red_content.set((String)localObject + "");
      localRedTypeInfo.red_type.set(4);
      localRedTypeInfo.red_desc.set("{'cr':'#777777'}");
      paramQQAppInterface.red_display_info.red_type_info.add(localRedTypeInfo);
      localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
      localRedTypeInfo.red_type.set(9);
      localRedTypeInfo.red_content.set(bhgr.a(paramContext, 3.0F) + "");
      localRedTypeInfo.red_desc.set("");
      paramQQAppInterface.red_display_info.red_type_info.add(localRedTypeInfo);
      paramContext = new BusinessInfoCheckUpdate.RedTypeInfo();
      paramContext.red_type.set(0);
      paramQQAppInterface.red_display_info.red_type_info.add(paramContext);
      paramQQAppInterface.iNewFlag.set(1);
      paramRedTouch.a(paramQQAppInterface);
      return;
    case 4: 
      paramContext = ((bnrs)localObject).jdField_b_of_type_JavaLangString;
      localRedTypeInfo.red_content.set(paramContext + "");
      localRedTypeInfo.red_type.set(4);
      localRedTypeInfo.red_desc.set("{'cr':'#FF0000'}");
      paramQQAppInterface.red_display_info.red_type_info.add(localRedTypeInfo);
      paramQQAppInterface.iNewFlag.set(1);
      paramRedTouch.a(paramQQAppInterface);
      return;
    }
    paramRedTouch.d();
  }
  
  private void b(QQAppInterface paramQQAppInterface, String paramString, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (paramAppInfo == null) {}
    while ((paramAppInfo.iNewFlag.get() == 0) || (!paramString.equals("com.tx.xingqubuluo.android"))) {
      return;
    }
    if (!TextUtils.isEmpty(paramAppInfo.icon_url.get())) {}
    for (int i = 1;; i = 2)
    {
      bdll.b(paramQQAppInterface, "dc00899", "Grp_tribe", "", "dynamic", "exp_tribe", 0, 0, i + "", "", "", "");
      return;
    }
  }
  
  protected void a(QQAppInterface paramQQAppInterface, Context paramContext, RedTouch paramRedTouch)
  {
    Object localObject;
    if (paramQQAppInterface != null)
    {
      if (!aqyl.a(paramQQAppInterface, "redpoint_leba_show")) {
        break label356;
      }
      localObject = ((aqyp)paramQQAppInterface.getManager(269)).b();
      if (localObject == null) {
        break label263;
      }
      localObject = ((aqyl)localObject).a(paramQQAppInterface);
      if ((paramQQAppInterface.a() == null) || (!paramQQAppInterface.a().a())) {
        break label270;
      }
    }
    label263:
    label270:
    for (int i = 1;; i = 0)
    {
      if ((TextUtils.isEmpty((CharSequence)localObject)) || (i != 0)) {
        break label289;
      }
      BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
      paramQQAppInterface = new BusinessInfoCheckUpdate.AppInfo();
      localRedTypeInfo.red_content.set((String)localObject);
      localRedTypeInfo.red_type.set(4);
      localRedTypeInfo.red_desc.set("{'cn':'#00000000','cr':'#888888'}");
      paramQQAppInterface.red_display_info.red_type_info.add(localRedTypeInfo);
      localObject = new BusinessInfoCheckUpdate.RedTypeInfo();
      ((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_type.set(0);
      ((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_desc.set("");
      ((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_content.set("");
      paramQQAppInterface.red_display_info.red_type_info.add((MessageMicro)localObject);
      paramQQAppInterface.iNewFlag.set(1);
      paramRedTouch.a(paramQQAppInterface);
      try
      {
        paramQQAppInterface = (TextView)paramRedTouch.findViewById(30);
        paramRedTouch = (LinearLayout.LayoutParams)paramQQAppInterface.getLayoutParams();
        paramQQAppInterface.setMaxWidth(agej.a(200.0F, paramContext.getResources()));
        paramRedTouch.weight = 1.0F;
        paramRedTouch.width = 0;
        paramRedTouch.rightMargin = agej.a(4.0F, paramContext.getResources());
        paramQQAppInterface.setEllipsize(TextUtils.TruncateAt.END);
        paramQQAppInterface.setLayoutParams(paramRedTouch);
        return;
      }
      catch (Exception paramQQAppInterface)
      {
        QLog.i("Q.lebatab.LebaSpecificRedTouch", 1, "updateConfessRedTouch", paramQQAppInterface);
        return;
      }
      localObject = "";
      break;
    }
    label289:
    paramQQAppInterface = new BusinessInfoCheckUpdate.RedTypeInfo();
    paramContext = new BusinessInfoCheckUpdate.AppInfo();
    paramQQAppInterface.red_type.set(0);
    paramQQAppInterface.red_desc.set("");
    paramQQAppInterface.red_content.set("");
    paramContext.red_display_info.red_type_info.add(paramQQAppInterface);
    paramContext.iNewFlag.set(1);
    paramRedTouch.a(paramContext);
    return;
    label356:
    paramRedTouch.d();
  }
  
  public void a(QQAppInterface paramQQAppInterface, aysu paramaysu, RedTouch paramRedTouch)
  {
    int i = 1;
    int j = 1;
    if (paramRedTouch == null) {}
    Object localObject;
    do
    {
      return;
      this.jdField_a_of_type_Int = paramaysu.d;
      this.jdField_b_of_type_Int = paramaysu.jdField_c_of_type_Int;
      switch (paramaysu.jdField_a_of_type_Int)
      {
      default: 
        paramRedTouch.a(null);
        return;
      case 11: 
        if ((paramQQAppInterface.a() != null) && (paramQQAppInterface.a().a())) {}
        for (i = 1; i == 0; i = 0)
        {
          paramQQAppInterface = new BusinessInfoCheckUpdate.RedTypeInfo();
          paramQQAppInterface.red_type.set(0);
          paramQQAppInterface.red_content.set("");
          paramQQAppInterface.red_desc.set("");
          paramRedTouch.a(paramQQAppInterface);
          return;
        }
        paramQQAppInterface = new BusinessInfoCheckUpdate.AppInfo();
        paramQQAppInterface.iNewFlag.set(1);
        paramQQAppInterface.exposure_max.set(1);
        localObject = new BusinessInfoCheckUpdate.RedDisplayInfo();
      }
    } while ((TextUtils.isEmpty(paramaysu.jdField_b_of_type_JavaLangString)) && (TextUtils.isEmpty(paramaysu.jdField_c_of_type_JavaLangString)));
    BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
    if (!TextUtils.isEmpty(paramaysu.jdField_b_of_type_JavaLangString))
    {
      localRedTypeInfo.red_type.set(11);
      localRedTypeInfo.red_content.set(paramaysu.jdField_b_of_type_JavaLangString);
      ((BusinessInfoCheckUpdate.RedDisplayInfo)localObject).red_type_info.add(localRedTypeInfo);
    }
    for (i = 1;; i = 0)
    {
      if (!TextUtils.isEmpty(paramaysu.jdField_c_of_type_JavaLangString))
      {
        localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
        localRedTypeInfo.red_type.set(-100);
        localRedTypeInfo.red_content.set(paramaysu.jdField_c_of_type_JavaLangString);
        ((BusinessInfoCheckUpdate.RedDisplayInfo)localObject).red_type_info.add(localRedTypeInfo);
      }
      for (;;)
      {
        if ((i == 0) && (j != 0))
        {
          paramaysu = new BusinessInfoCheckUpdate.RedTypeInfo();
          paramaysu.red_type.set(0);
          ((BusinessInfoCheckUpdate.RedDisplayInfo)localObject).red_type_info.add(paramaysu);
        }
        paramQQAppInterface.red_display_info.set((MessageMicro)localObject);
        paramRedTouch.b(paramQQAppInterface);
        return;
        if ((paramQQAppInterface.a() != null) && (paramQQAppInterface.a().a())) {}
        while (i != 0)
        {
          paramQQAppInterface = new BusinessInfoCheckUpdate.RedTypeInfo();
          paramQQAppInterface.red_type.set(0);
          paramQQAppInterface.red_content.set("");
          paramQQAppInterface.red_desc.set("");
          paramRedTouch.a(paramQQAppInterface);
          return;
          i = 0;
        }
        paramQQAppInterface = (String)paramaysu.jdField_a_of_type_JavaUtilList.get(0);
        paramaysu = new BusinessInfoCheckUpdate.RedTypeInfo();
        paramaysu.red_type.set(3);
        paramaysu.red_content.set(paramQQAppInterface);
        paramaysu.red_desc.set("{'av':1, 'dot':1}");
        paramRedTouch.a(paramaysu);
        return;
        localObject = new BusinessInfoCheckUpdate.RedTypeInfo();
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_type.set(5);
        paramQQAppInterface = paramaysu.jdField_b_of_type_Int + "";
        if (paramaysu.jdField_b_of_type_Int > 99) {
          paramQQAppInterface = "99+";
        }
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_content.set(paramQQAppInterface);
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_desc.set("{'cn':'#FF0000'}");
        paramRedTouch.a((BusinessInfoCheckUpdate.RedTypeInfo)localObject);
        return;
        paramQQAppInterface = new BusinessInfoCheckUpdate.RedTypeInfo();
        paramQQAppInterface.red_type.set(0);
        paramQQAppInterface.red_content.set("");
        paramQQAppInterface.red_desc.set("");
        paramRedTouch.a(paramQQAppInterface);
        return;
        j = 0;
      }
    }
  }
  
  protected void a(QQAppInterface paramQQAppInterface, RedTouch paramRedTouch)
  {
    if (paramRedTouch == null) {
      return;
    }
    paramQQAppInterface = (nlb)paramQQAppInterface.getManager(70);
    oidb_0x791.RedDotInfo localRedDotInfo = paramQQAppInterface.a();
    if (localRedDotInfo == null)
    {
      paramRedTouch.d();
      return;
    }
    yup.a("dynamic", "exp_story", 0, paramQQAppInterface.b(), new String[0]);
    BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
    BusinessInfoCheckUpdate.AppInfo localAppInfo = new BusinessInfoCheckUpdate.AppInfo();
    int i;
    switch (localRedDotInfo.uint32_appid.get())
    {
    default: 
      i = -1;
    case 11: 
    case 37: 
    case 8: 
    case 35: 
      label126:
      while (i != -1)
      {
        if (QLog.isColorLevel()) {
          QLog.i("storyRedDotDebug", 2, "更新动态红点:" + nlb.a(localRedDotInfo));
        }
        localRedTypeInfo.red_type.set(i);
        localAppInfo.red_display_info.red_type_info.add(localRedTypeInfo);
        localAppInfo.iNewFlag.set(1);
        paramRedTouch.a(localRedTypeInfo);
        return;
        localRedTypeInfo.red_content.set(localRedDotInfo.str_custom_buffer.get().toStringUtf8() + "");
        localRedTypeInfo.red_desc.set("{'cn':'#FF0000'}");
        i = 4;
        continue;
        paramQQAppInterface = "New";
        try
        {
          String str = new JSONObject(localRedDotInfo.str_custom_buffer.get().toStringUtf8()).getString("red_word");
          paramQQAppInterface = str;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            yuk.d("Q.lebatab.LebaSpecificRedTouch", "tag red dot json parse error , %s", new Object[] { localException.getMessage() });
          }
        }
        localRedTypeInfo.red_content.set(paramQQAppInterface);
        localRedTypeInfo.red_desc.set("{'cn':'#00000000' ,'cr':'#777777'}");
        i = 4;
        continue;
        i = 0;
        continue;
        paramQQAppInterface = localRedDotInfo.str_custom_buffer.get().toStringUtf8();
        if (TextUtils.isEmpty(paramQQAppInterface)) {
          break label436;
        }
        try
        {
          long l = new JSONObject(paramQQAppInterface).optLong("image_red_display_780", 1L);
          yuk.e("Q.lebatab.LebaSpecificRedTouch", "updateStoryRedTouch() APPID_STORY_IMG: red display=%d", new Object[] { Long.valueOf(l) });
          if (l != 0L) {
            break label445;
          }
          paramRedTouch.d();
          i = -1;
        }
        catch (JSONException paramQQAppInterface)
        {
          yuk.c("Q.lebatab.LebaSpecificRedTouch", "updateStoryRedTouch() APPID_STORY_IMG: Error parse json: ", paramQQAppInterface);
          i = -1;
        }
      }
      label436:
      yuk.b("Q.lebatab.LebaSpecificRedTouch", "updateStoryRedTouch() APPID_STORY_IMG: str_custom_buffer is null");
      label445:
      i = localRedDotInfo.uint32_cmd_uin_type.get();
      if (i == 0)
      {
        localObject = localRedDotInfo.str_face_url.get().toStringUtf8();
        paramQQAppInterface = String.format("{'uin':'%s','dot':1, 'av':1}", new Object[] { localRedDotInfo.uint64_cmd_uin.get() + "" });
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          paramQQAppInterface = "{'av':1, 'dot':1}";
          localRedTypeInfo.red_content.set((String)localObject);
        }
        localRedTypeInfo.red_desc.set(paramQQAppInterface);
      }
      for (;;)
      {
        i = 3;
        break label126;
        if (i != 1) {
          break;
        }
        paramQQAppInterface = "https://p.qlogo.cn/gh/" + localRedDotInfo.uint64_cmd_uin.get() + "/" + localRedDotInfo.uint64_cmd_uin.get() + "/100?t=" + nlb.d;
        localRedTypeInfo.red_content.set(paramQQAppInterface);
        localRedTypeInfo.red_desc.set("{'av':1, 'dot':1}");
      }
    }
    Object localObject = localRedTypeInfo.red_content;
    if (localRedDotInfo.uint32_number.get() > 99) {}
    for (paramQQAppInterface = "99+";; paramQQAppInterface = localRedDotInfo.uint32_number.get() + "")
    {
      ((PBStringField)localObject).set(paramQQAppInterface);
      localRedTypeInfo.red_desc.set("{'cn':'#FF0000'}");
      i = 4;
      break;
    }
  }
  
  protected void a(QQAppInterface paramQQAppInterface, RedTouch paramRedTouch, long paramLong, int paramInt)
  {
    ThreadManager.post(new LebaSpecificRedTouch.1(this, paramQQAppInterface, new Handler(), paramRedTouch, paramLong), 8, null, true);
  }
  
  public void a(QQAppInterface paramQQAppInterface, RedTouch paramRedTouch, String paramString1, String paramString2, long paramLong)
  {
    Object localObject2 = (bbav)paramQQAppInterface.getManager(36);
    int i;
    if (localObject2 != null)
    {
      paramString2 = ((bbav)localObject2).a(paramString1);
      if (paramString2 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.lebatab.LebaSpecificRedTouch", 2, "updateKuolieRedTouch() kuolie appInfo.buffer: " + paramString2.buffer.get());
        }
        Object localObject1 = paramString2.red_display_info.red_type_info.get();
        if (((List)localObject1).size() > 0)
        {
          paramString1 = null;
          localObject2 = ((bbav)localObject2).a(paramString2);
          if (QLog.isColorLevel()) {
            QLog.d("Q.lebatab.LebaSpecificRedTouch", 2, "updateKuolieRedTouch() kuolie appInfo bufferExtParam: " + localObject2);
          }
          if (localObject2 != null) {
            paramString1 = ((JSONObject)localObject2).optString("_red_ext_uin");
          }
          if (!TextUtils.isEmpty(paramString1))
          {
            localObject1 = ((List)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (BusinessInfoCheckUpdate.RedTypeInfo)((Iterator)localObject1).next();
              if (((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_type.get() == 3) {
                try
                {
                  JSONObject localJSONObject = new JSONObject(((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_desc.get());
                  localJSONObject.put("uin", paramString1);
                  ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_desc.set(localJSONObject.toString());
                }
                catch (Throwable localThrowable)
                {
                  QLog.e("Q.lebatab.LebaSpecificRedTouch", 1, "updateKuolieRedTouch()  modify image reddot red_desc JSONException ", localThrowable);
                }
              }
            }
          }
        }
      }
      if ((paramQQAppInterface.a() == null) || (!paramQQAppInterface.a().a())) {
        break label300;
      }
      i = 1;
      if (i == 0) {
        break label306;
      }
      paramRedTouch.b(paramString2);
    }
    for (;;)
    {
      a(paramLong, paramRedTouch);
      return;
      label300:
      i = 0;
      break;
      label306:
      paramRedTouch.a(paramString2);
    }
  }
  
  protected void a(QQAppInterface paramQQAppInterface, RedTouch paramRedTouch, String paramString1, String paramString2, long paramLong, int paramInt)
  {
    ThreadManager.getSubThreadHandler().post(new LebaSpecificRedTouch.2(this, paramQQAppInterface, paramRedTouch, paramString1, paramString2, paramLong));
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (paramString.equals("com.tx.xingqubuluo.android")) {
      b(paramQQAppInterface, paramString, paramAppInfo);
    }
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, Context paramContext, long paramLong, RedTouch paramRedTouch, String paramString, Map<Long, awko> paramMap, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilMap = paramMap;
    boolean bool = false;
    paramMap = String.valueOf(paramLong);
    if ((paramMap != null) && (bnrs.jdField_a_of_type_JavaLangString.equals(paramMap)))
    {
      b(paramQQAppInterface, paramContext, paramRedTouch);
      a(paramLong, paramRedTouch);
      bool = true;
    }
    do
    {
      return bool;
      if (String.valueOf(nql.jdField_a_of_type_Int).equals(paramMap))
      {
        a(paramQQAppInterface, paramRedTouch);
        a(paramLong, paramRedTouch);
        return true;
      }
      if (biur.jdField_a_of_type_JavaLangString.equals(paramString))
      {
        biur.a(paramQQAppInterface, paramRedTouch);
        a(paramLong, paramRedTouch);
        return true;
      }
      if (7759L == paramLong)
      {
        paramRedTouch.a();
        a(paramQQAppInterface, paramContext, paramRedTouch);
        a(paramLong, paramRedTouch);
        return true;
      }
      if (7719L == paramLong)
      {
        a(paramQQAppInterface, paramRedTouch, paramLong, paramInt);
        return true;
      }
    } while (7720L != paramLong);
    a(paramQQAppInterface, paramRedTouch, paramMap, paramString, paramLong, paramInt);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awkm
 * JD-Core Version:    0.7.0.1
 */