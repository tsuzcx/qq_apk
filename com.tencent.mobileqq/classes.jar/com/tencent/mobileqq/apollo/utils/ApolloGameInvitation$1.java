package com.tencent.mobileqq.apollo.utils;

import alef;
import alew;
import alex;
import aliq;
import alpo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import bctc;
import bcwc;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URLEncoder;
import org.json.JSONObject;

public class ApolloGameInvitation$1
  implements Runnable
{
  public ApolloGameInvitation$1(alew paramalew) {}
  
  public void run()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(alef.s).append(alew.a(this.this$0).jdField_a_of_type_Int).append("/inviteIcon.png");
    try
    {
      if (new File(((StringBuilder)localObject1).toString()).exists()) {
        localObject1 = BitmapFactory.decodeFile(((StringBuilder)localObject1).toString());
      } else {
        localObject1 = bcwc.b(BaseApplicationImpl.getApplication().getResources(), 2130838498);
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.e("ApolloGameInvitation", 1, "fail to invite wxFriend, oom happens, errInfo->" + localOutOfMemoryError.getMessage());
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloGameInvitation", 1, "fail to invite wxFriend, error happens, errInfo->" + localThrowable.getMessage());
      return;
    }
    while (localException != null)
    {
      Bitmap localBitmap = bctc.a(localThrowable);
      alew.a(this.this$0, String.valueOf(System.currentTimeMillis()));
      String str1 = alpo.a(2131700743) + alew.a(this.this$0).b;
      Object localObject2 = new JSONObject();
      try
      {
        ((JSONObject)localObject2).put("gameId", alew.a(this.this$0).jdField_a_of_type_Int);
        ((JSONObject)localObject2).put("roomId", alew.a(this.this$0).jdField_a_of_type_Long);
        ((JSONObject)localObject2).put("gameMode", alew.a(this.this$0).jdField_c_of_type_Int);
        ((JSONObject)localObject2).put("extendInfo", alew.a(this.this$0).jdField_c_of_type_JavaLangString);
        localObject2 = URLEncoder.encode(((JSONObject)localObject2).toString(), "UTF-8");
        String str2 = URLEncoder.encode(str1, "UTF-8");
        StringBuilder localStringBuilder = new StringBuilder("https://cmshow.qq.com/apollo/html/redirect/mqqapi_cmshow.html");
        localStringBuilder.append("?").append("cmd=game_invite&title=").append(str2).append("&data=").append((String)localObject2);
        WXShareHelper.a().a(new alex(this));
        WXShareHelper.a().a(alew.a(this.this$0), str1, localBitmap, alew.b(this.this$0), localStringBuilder.toString(), 1);
        return;
      }
      catch (Exception localException)
      {
        QLog.w("ApolloGameInvitation", 1, "[inviteWeChatFriend], errInfo->" + localException.getMessage());
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloGameInvitation.1
 * JD-Core Version:    0.7.0.1
 */