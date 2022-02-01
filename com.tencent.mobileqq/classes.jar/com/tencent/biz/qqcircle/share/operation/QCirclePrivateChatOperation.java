package com.tencent.biz.qqcircle.share.operation;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.lib.QCircleHostClassHelper;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants.AppConstants.Key;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants.AppConstants.Value;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants._ChatActivityConstants;
import com.tencent.biz.qcircleshadow.lib.variation.HostChatUtils;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.share.QCircleBaseShareOperation;
import com.tencent.biz.qqcircle.share.QCircleBaseShareOperation.Builder;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qqcircle.utils.QCircleCommonUtil;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;

public class QCirclePrivateChatOperation
  extends QCircleBaseShareOperation
{
  public QCirclePrivateChatOperation(QCircleBaseShareOperation.Builder paramBuilder)
  {
    super(paramBuilder);
  }
  
  public void a()
  {
    if ((f() != null) && (f().b != null) && (i() != null))
    {
      Intent localIntent = new Intent(i(), QCircleHostClassHelper.getChatActivityClass());
      String str = f().b.poster.id.get();
      localIntent.putExtra(QCircleHostConstants.AppConstants.Key.UIN(), str);
      localIntent.putExtra(QCircleHostConstants._ChatActivityConstants.OPEN_CHAT_FRAGMENT(), true);
      if (QCircleCommonUtil.isFriend(str))
      {
        localIntent.putExtra(QCircleHostConstants.AppConstants.Key.UIN_TYPE(), QCircleHostConstants.AppConstants.Value.UIN_TYPE_FRIEND());
      }
      else
      {
        localIntent.putExtra(HostChatUtils.QCIRCLE_CHAT_HIDE_MENU_KEY(), true);
        localIntent.putExtra(QCircleHostConstants.AppConstants.Key.UIN_TYPE(), QCircleHostConstants.AppConstants.Value.UIN_TYPE_TEMP_CIRCLE());
      }
      localIntent.putExtra(QCircleHostConstants._ChatActivityConstants.KEY_AIO_MSG_SOURCE(), QCircleHostConstants._ChatActivityConstants.TYPE_DETAIL_MSG_REMIND());
      Object localObject2 = HostDataTransUtils.getBuddyName(str, true);
      Object localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = localObject2;
        if (!str.equals(localObject2)) {}
      }
      else
      {
        localObject1 = f().b.poster.nick.get();
      }
      str = QCircleHostConstants.AppConstants.Key.UIN_NAME();
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = "";
      }
      localIntent.putExtra(str, (String)localObject2);
      i().startActivity(localIntent);
      return;
    }
    a("QCirclePrivateChat");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.share.operation.QCirclePrivateChatOperation
 * JD-Core Version:    0.7.0.1
 */