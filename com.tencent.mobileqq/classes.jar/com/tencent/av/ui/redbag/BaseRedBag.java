package com.tencent.av.ui.redbag;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import org.json.JSONObject;

public class BaseRedBag
  extends SubHandleBase
{
  public final int a;
  public final String a;
  public final String b = "appid#0|bargainor_id#0|channel#bqredpacket2";
  public final String c = "appid#0|bargainor_id#0|channel#bqredpacket";
  public final String d = "2";
  public final String e = "16384";
  public final String f = "1";
  
  BaseRedBag(AVRedBagMgr paramAVRedBagMgr)
  {
    super(paramAVRedBagMgr);
    this.jdField_a_of_type_JavaLangString = "appid#0|bargainor_id#0|channel#bqredpacket1";
    this.jdField_a_of_type_Int = 2;
  }
  
  static long a(VideoAppInterface paramVideoAppInterface)
  {
    paramVideoAppInterface = paramVideoAppInterface.a().a().c;
    try
    {
      long l = Long.valueOf(paramVideoAppInterface).longValue();
      return l;
    }
    catch (Exception paramVideoAppInterface) {}
    return 0L;
  }
  
  static String a(VideoAppInterface paramVideoAppInterface)
  {
    return paramVideoAppInterface.getDisplayName(0, paramVideoAppInterface.getCurrentAccountUin(), null);
  }
  
  public static void a(VideoAppInterface paramVideoAppInterface, String paramString)
  {
    long l = RedBagUtil.a(paramVideoAppInterface);
    paramVideoAppInterface = new JSONObject();
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("url", paramString);
      paramVideoAppInterface.put("userId", l);
      paramVideoAppInterface.put("viewTag", "openEmbelUrl");
      paramVideoAppInterface.put("come_from", 2);
      paramVideoAppInterface.put("extra_data", localObject);
      paramString = BaseApplicationImpl.getApplication();
      localObject = new Bundle();
      ((Bundle)localObject).putString("json", paramVideoAppInterface.toString());
      ((Bundle)localObject).putString("callbackSn", "0");
      paramVideoAppInterface = new Intent(paramString.getApplicationContext(), PayBridgeActivity.class);
      paramVideoAppInterface.addFlags(268435456);
      paramVideoAppInterface.putExtras((Bundle)localObject);
      paramVideoAppInterface.putExtra("pay_requestcode", 5);
      paramString.getBaseContext().startActivity(paramVideoAppInterface);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  static String b(VideoAppInterface paramVideoAppInterface)
  {
    return paramVideoAppInterface.a().a().d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.ui.redbag.BaseRedBag
 * JD-Core Version:    0.7.0.1
 */