package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.TroopRedpoint.TroopRedTouchManager;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;

public class RecentItemTencentDocsAssistantData
  extends AbsRecentUserBusinessBaseData
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
    this.mTitleName = paramContext.getString(2131719599);
    this.mMsgExtroInfo = "";
    paramQQAppInterface = (TroopRedTouchManager)paramQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH_EX);
    int j = 0;
    oidb_0x791.RedDotInfo localRedDotInfo = paramQQAppInterface.a(46, false);
    Object localObject3;
    Object localObject2;
    Object localObject4;
    Object localObject1;
    if (localRedDotInfo == null)
    {
      this.mUnreadNum = 0;
      this.mDisplayTime = 0L;
      this.mShowTime = "";
      this.mLastMsg = paramContext.getString(2131719600);
    }
    else
    {
      int i = j;
      if (localRedDotInfo.uint32_number.has())
      {
        i = j;
        if (localRedDotInfo.bool_display_reddot.get()) {
          i = localRedDotInfo.uint32_number.get();
        }
      }
      this.mUnreadNum = i;
      long l;
      if (localRedDotInfo.uint32_last_time.has()) {
        l = localRedDotInfo.uint32_last_time.get();
      } else {
        l = 0L;
      }
      this.mDisplayTime = l;
      localObject3 = null;
      localObject2 = null;
      localObject4 = null;
      localObject1 = localObject3;
    }
    for (;;)
    {
      try
      {
        if (!localRedDotInfo.str_custom_buffer.has()) {
          break label652;
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
          localObject1 = paramQQAppInterface;
          localObject2 = paramQQAppInterface;
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
            localObject1 = localObject3;
            localObject2 = localObject3;
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
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("RecentItemTencentDocsAssistantData update error");
        ((StringBuilder)localObject2).append(paramQQAppInterface.getMessage());
        QLog.e("RecentItemTencentDocsAssistantData", 1, ((StringBuilder)localObject2).toString());
        localObject2 = localObject1;
      }
      if ((this.mDisplayTime > 0L) && (this.mDisplayTime != 9223372036854775806L)) {
        this.mShowTime = TimeManager.a().a(getRecentUserUin(), this.mDisplayTime);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        this.mLastMsg = ((CharSequence)localObject2);
      } else {
        this.mLastMsg = paramContext.getString(2131719600);
      }
      if (AppSetting.d)
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append(this.mTitleName);
        paramQQAppInterface.append(",");
        if (this.mUnreadNum != 0) {
          if (this.mUnreadNum == 1)
          {
            paramQQAppInterface.append("有一条未读");
          }
          else if (this.mUnreadNum == 2)
          {
            paramQQAppInterface.append("有两条未读");
          }
          else if (this.mUnreadNum > 0)
          {
            paramQQAppInterface.append("有");
            paramQQAppInterface.append(this.mUnreadNum);
            paramQQAppInterface.append("条未读,");
          }
        }
        if (this.mMsgExtroInfo != null)
        {
          paramContext = new StringBuilder();
          paramContext.append(this.mMsgExtroInfo);
          paramContext.append(",");
          paramQQAppInterface.append(paramContext.toString());
        }
        paramQQAppInterface.append(this.mLastMsg);
        paramQQAppInterface.append(",");
        paramQQAppInterface.append(this.mShowTime);
        this.mContentDesc = paramQQAppInterface.toString();
      }
      return;
      label652:
      paramQQAppInterface = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemTencentDocsAssistantData
 * JD-Core Version:    0.7.0.1
 */