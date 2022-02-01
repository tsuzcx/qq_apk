package com.tencent.mobileqq.apollo.utils;

import amri;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import ankt;
import anku;
import anvx;
import bgua;
import bgyo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URLEncoder;
import org.json.JSONObject;

public class ApolloGameInvitation$1
  implements Runnable
{
  public ApolloGameInvitation$1(ankt paramankt) {}
  
  public void run()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/game/").append(ankt.a(this.this$0).jdField_a_of_type_Int).append("/inviteIcon.png");
    try
    {
      if (new File(((StringBuilder)localObject1).toString()).exists()) {
        localObject1 = BitmapFactory.decodeFile(((StringBuilder)localObject1).toString());
      } else {
        localObject1 = bgyo.b(BaseApplicationImpl.getApplication().getResources(), 2130838660);
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
      Bitmap localBitmap = bgua.a(localThrowable);
      ankt.a(this.this$0, String.valueOf(System.currentTimeMillis()));
      String str1 = anvx.a(2131699873) + ankt.a(this.this$0).b;
      Object localObject2 = new JSONObject();
      try
      {
        ((JSONObject)localObject2).put("gameId", ankt.a(this.this$0).jdField_a_of_type_Int);
        ((JSONObject)localObject2).put("roomId", ankt.a(this.this$0).jdField_a_of_type_Long);
        ((JSONObject)localObject2).put("gameMode", ankt.a(this.this$0).jdField_c_of_type_Int);
        ((JSONObject)localObject2).put("extendInfo", ankt.a(this.this$0).jdField_c_of_type_JavaLangString);
        localObject2 = URLEncoder.encode(((JSONObject)localObject2).toString(), "UTF-8");
        String str2 = URLEncoder.encode(str1, "UTF-8");
        StringBuilder localStringBuilder = new StringBuilder("https://cmshow.qq.com/apollo/html/redirect/mqqapi_cmshow.html");
        localStringBuilder.append("?").append("cmd=game_invite&title=").append(str2).append("&data=").append((String)localObject2);
        WXShareHelper.a().a(new anku(this));
        WXShareHelper.a().a(ankt.a(this.this$0), str1, localBitmap, ankt.b(this.this$0), localStringBuilder.toString(), 1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloGameInvitation.1
 * JD-Core Version:    0.7.0.1
 */