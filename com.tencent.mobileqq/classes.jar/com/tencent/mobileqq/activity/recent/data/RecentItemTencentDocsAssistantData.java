package com.tencent.mobileqq.activity.recent.data;

import ajlh;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import nan;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;

public class RecentItemTencentDocsAssistantData
  extends RecentUserBaseData
{
  private static final String TAG = "RecentItemTencentDocsAssistantData";
  
  public RecentItemTencentDocsAssistantData(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentItemTencentDocsAssistantData", 2, "RecentItemTencentDocsAssistantData update");
    }
    super.a(paramQQAppInterface, paramContext);
    this.mTitleName = paramContext.getString(2131720741);
    this.mMsgExtroInfo = "";
    oidb_0x791.RedDotInfo localRedDotInfo = ((nan)paramQQAppInterface.getManager(70)).a(46, false);
    if (localRedDotInfo == null)
    {
      this.mUnreadNum = 0;
      this.mDisplayTime = 0L;
      this.mShowTime = "";
      this.mLastMsg = paramContext.getString(2131720742);
      if (AppSetting.c)
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append(this.mTitleName).append(",");
        if (this.mUnreadNum != 0) {
          break label556;
        }
      }
    }
    for (;;)
    {
      if (this.mMsgExtroInfo != null) {
        paramQQAppInterface.append(this.mMsgExtroInfo + ",");
      }
      paramQQAppInterface.append(this.mLastMsg).append(",").append(this.mShowTime);
      this.mContentDesc = paramQQAppInterface.toString();
      return;
      int i;
      label214:
      long l;
      label241:
      Object localObject2;
      Object localObject3;
      Object localObject4;
      Object localObject1;
      if ((localRedDotInfo.uint32_number.has()) && (localRedDotInfo.bool_display_reddot.get()))
      {
        i = localRedDotInfo.uint32_number.get();
        this.mUnreadNum = i;
        if (!localRedDotInfo.uint32_last_time.has()) {
          break label496;
        }
        l = localRedDotInfo.uint32_last_time.get();
        this.mDisplayTime = l;
        localObject2 = null;
        localObject3 = null;
        localObject4 = null;
        localObject1 = localObject3;
      }
      for (;;)
      {
        try
        {
          if (!localRedDotInfo.str_custom_buffer.has()) {
            continue;
          }
          localObject1 = localObject3;
          paramQQAppInterface = localRedDotInfo.str_custom_buffer.get().toStringUtf8();
          if (paramQQAppInterface != null)
          {
            localObject1 = localObject3;
            JSONObject localJSONObject = new JSONObject(paramQQAppInterface);
            paramQQAppInterface = localObject4;
            localObject1 = localObject3;
            if (localJSONObject.has("msg"))
            {
              localObject1 = localObject3;
              paramQQAppInterface = localJSONObject.getString("msg");
            }
            localObject2 = paramQQAppInterface;
            localObject1 = paramQQAppInterface;
            if (!localRedDotInfo.bool_display_reddot.get())
            {
              localObject3 = paramQQAppInterface;
              localObject1 = paramQQAppInterface;
              if (localJSONObject.has("lastMsg"))
              {
                localObject3 = paramQQAppInterface;
                localObject1 = paramQQAppInterface;
                if (!TextUtils.isEmpty(localJSONObject.getString("lastMsg")))
                {
                  localObject1 = paramQQAppInterface;
                  localObject3 = localJSONObject.getString("lastMsg");
                }
              }
              localObject2 = localObject3;
              localObject1 = localObject3;
              if (localJSONObject.has("lastTime"))
              {
                localObject1 = localObject3;
                this.mDisplayTime = localJSONObject.getInt("lastTime");
                localObject2 = localObject3;
              }
            }
          }
        }
        catch (Exception paramQQAppInterface)
        {
          label496:
          QLog.e("RecentItemTencentDocsAssistantData", 1, "RecentItemTencentDocsAssistantData update error" + paramQQAppInterface.getMessage());
          localObject2 = localObject1;
          continue;
          this.mLastMsg = paramContext.getString(2131720742);
        }
        if ((this.mDisplayTime > 0L) && (this.mDisplayTime != 9223372036854775806L)) {
          this.mShowTime = ajlh.a().a(a(), this.mDisplayTime);
        }
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          continue;
        }
        this.mLastMsg = ((CharSequence)localObject2);
        break;
        i = 0;
        break label214;
        l = 0L;
        break label241;
        paramQQAppInterface = null;
      }
      break;
      label556:
      if (this.mUnreadNum == 1) {
        paramQQAppInterface.append("有一条未读");
      } else if (this.mUnreadNum == 2) {
        paramQQAppInterface.append("有两条未读");
      } else if (this.mUnreadNum > 0) {
        paramQQAppInterface.append("有").append(this.mUnreadNum).append("条未读,");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemTencentDocsAssistantData
 * JD-Core Version:    0.7.0.1
 */