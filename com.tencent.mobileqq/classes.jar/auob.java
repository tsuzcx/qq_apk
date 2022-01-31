import NS_MOBILE_NEWEST_FEEDS.QzoneData;
import NS_MOBILE_NEWEST_FEEDS.feed_info;
import NS_MOBILE_NEWEST_FEEDS.newest_feeds_rsp;
import NS_QQ_STORY_META.META.StImage;
import NS_QQ_STORY_META.META.StStoryFeed;
import NS_WEISHI_QQ_PROFILE.stGetNewestFeedRspInner;
import android.content.Intent;
import android.text.TextUtils;
import com.qq.taf.jce.JceInputStream;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class auob
  extends MSFServlet
{
  private void b(boolean paramBoolean, newest_feeds_rsp paramnewest_feeds_rsp)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    if (localQQAppInterface == null) {
      return;
    }
    if ((paramBoolean) && (paramnewest_feeds_rsp != null))
    {
      a(paramBoolean, paramnewest_feeds_rsp);
      localQQAppInterface.a().a(paramnewest_feeds_rsp);
      localQQAppInterface.a().d();
      return;
    }
    localQQAppInterface.a().c();
  }
  
  protected void a(boolean paramBoolean, newest_feeds_rsp paramnewest_feeds_rsp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QzoneContactsFeedServlet", 2, String.format("onGetQzoneContactsFeed isSuc=%s last_feed_time=%s", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(paramnewest_feeds_rsp.last_feed_time) }));
    }
    QQAppInterface localQQAppInterface;
    ajjj localajjj;
    if (paramBoolean)
    {
      localQQAppInterface = (QQAppInterface)getAppRuntime();
      if (localQQAppInterface != null)
      {
        localajjj = (ajjj)localQQAppInterface.getManager(51);
        if (localajjj == null) {}
      }
    }
    ArrayList localArrayList;
    Object localObject1;
    Object localObject2;
    long l;
    for (;;)
    {
      Object localObject4;
      Object localObject5;
      try
      {
        localArrayList = new ArrayList();
        localObject1 = paramnewest_feeds_rsp.mapVcByte;
        if ((localObject1 == null) || (((Map)localObject1).isEmpty())) {
          break;
        }
        localObject2 = ((Map)localObject1).keySet().iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        Object localObject3 = (Long)((Iterator)localObject2).next();
        localObject4 = (QzoneData)((Map)localObject1).get(localObject3);
        localObject3 = localajjj.a(String.valueOf(localObject3));
        if (localObject3 == null) {
          continue;
        }
        if (((QzoneData)localObject4).iType == 2)
        {
          localObject5 = new JceInputStream();
          ((JceInputStream)localObject5).wrap(((QzoneData)localObject4).vcByte);
          ((JceInputStream)localObject5).setServerEncoding("utf-8");
          localObject4 = new stGetNewestFeedRspInner();
          ((stGetNewestFeedRspInner)localObject4).readFrom((JceInputStream)localObject5);
          localObject5 = ((stGetNewestFeedRspInner)localObject4).mapItemInfo;
          if ((localObject5 == null) || (((Map)localObject5).isEmpty())) {
            continue;
          }
          localObject4 = (String)((Map)localObject5).get("upload_time");
          localObject5 = (String)((Map)localObject5).get("desc");
          if (QLog.isColorLevel()) {
            QLog.d("QzoneContactsFeedServlet", 2, String.format("onGetQzoneContactsFeed weishi feed, uploadTime=%s desc=%s", new Object[] { localObject4, localObject5 }));
          }
          try
          {
            l = Long.valueOf((String)localObject4).longValue();
            if ((((ExtensionInfo)localObject3).feedTime > l) && (((ExtensionInfo)localObject3).feedType != 1)) {
              continue;
            }
            ((ExtensionInfo)localObject3).feedType = 1;
            ((ExtensionInfo)localObject3).feedTime = l;
            ((ExtensionInfo)localObject3).feedContent = ((String)localObject5);
            ((ExtensionInfo)localObject3).feedHasPhoto = false;
            ((ExtensionInfo)localObject3).feedPhotoUrl = null;
            localArrayList.add(localObject3);
          }
          catch (NumberFormatException localNumberFormatException)
          {
            QLog.e("QzoneContactsFeedServlet", 1, "onGetQzoneContactsFeed fail.", localNumberFormatException);
          }
          continue;
          return;
        }
      }
      catch (Exception paramnewest_feeds_rsp)
      {
        QLog.e("QzoneContactsFeedServlet", 1, "onGetQzoneContactsFeed fail.", paramnewest_feeds_rsp);
      }
      int i = ((QzoneData)localObject4).iType;
      if (i == 3) {
        try
        {
          localObject5 = new META.StStoryFeed();
          ((META.StStoryFeed)localObject5).mergeFrom(((QzoneData)localObject4).vcByte);
          if (QLog.isColorLevel()) {
            QLog.d("QzoneContactsFeedServlet", 2, String.format("onGetQzoneContactsFeed story feed, uploadTime=%s feedPhotoUrl=%s", new Object[] { Long.valueOf(((META.StStoryFeed)localObject5).createTime.get()), ((META.StStoryFeed)localObject5).coverImage.url.get() }));
          }
          if (((localNumberFormatException.feedTime <= ((META.StStoryFeed)localObject5).createTime.get()) || (localNumberFormatException.feedType == 2)) && (!TextUtils.isEmpty(((META.StStoryFeed)localObject5).coverImage.url.get())))
          {
            localNumberFormatException.feedType = 2;
            localNumberFormatException.feedTime = ((META.StStoryFeed)localObject5).createTime.get();
            localNumberFormatException.feedContent = BaseApplicationImpl.getApplication().getString(2131624459);
            localNumberFormatException.feedHasPhoto = false;
            localNumberFormatException.feedPhotoUrl = ((META.StStoryFeed)localObject5).coverImage.url.get();
            localArrayList.add(localNumberFormatException);
          }
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          QLog.e("QzoneContactsFeedServlet", 1, "onGetQzoneContactsFeed fail.", localInvalidProtocolBufferMicroException);
        }
      }
    }
    paramnewest_feeds_rsp = paramnewest_feeds_rsp.vec_feed_info;
    label630:
    String str;
    if ((paramnewest_feeds_rsp != null) && (!paramnewest_feeds_rsp.isEmpty()))
    {
      paramnewest_feeds_rsp = paramnewest_feeds_rsp.iterator();
      while (paramnewest_feeds_rsp.hasNext())
      {
        localObject1 = (feed_info)paramnewest_feeds_rsp.next();
        localObject2 = localajjj.a(String.valueOf(((feed_info)localObject1).opuin));
        if (localObject2 != null)
        {
          l = ((feed_info)localObject1).time;
          str = auoc.a(((feed_info)localObject1).strcontent, localQQAppInterface);
          if (((feed_info)localObject1).has_pic != 1L) {
            break label879;
          }
        }
      }
    }
    label879:
    for (paramBoolean = true;; paramBoolean = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QzoneContactsFeedServlet", 2, String.format("onGetQzoneContactsFeed qzone feed, qZoneFeedTime=%s qZoneFeedContent=%s qZoneFeedHasPhoto=%s", new Object[] { Long.valueOf(l), str, Boolean.valueOf(paramBoolean) }));
      }
      if ((((ExtensionInfo)localObject2).feedTime > l) && (((ExtensionInfo)localObject2).feedType != 0)) {
        break label630;
      }
      ((ExtensionInfo)localObject2).feedType = 0;
      ((ExtensionInfo)localObject2).feedTime = l;
      ((ExtensionInfo)localObject2).feedContent = str;
      ((ExtensionInfo)localObject2).feedHasPhoto = paramBoolean;
      ((ExtensionInfo)localObject2).feedPhotoUrl = ((feed_info)localObject1).strImgUrl;
      localArrayList.add(localObject2);
      break label630;
      if (QLog.isColorLevel()) {
        QLog.d("QzoneContactsFeedServlet", 2, String.format("onGetQzoneContactsFeed update size=%s", new Object[] { Integer.valueOf(localArrayList.size()) }));
      }
      if (localArrayList.size() <= 0) {
        break;
      }
      localajjj.b(localArrayList);
      paramnewest_feeds_rsp = (FriendListHandler)localQQAppInterface.a(1);
      if (paramnewest_feeds_rsp == null) {
        break;
      }
      paramnewest_feeds_rsp.notifyUI(2, true, null);
      return;
    }
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      paramIntent = auoa.a(paramFromServiceMsg.getWupBuffer());
      if (paramIntent != null)
      {
        b(true, paramIntent);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QzoneContactsFeedServlet", 2, "inform QzoneContactsFeedServlet isSuccess false");
      }
      b(false, null);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QzoneContactsFeedServlet", 2, "inform QzoneContactsFeedServlet resultcode fail.");
    }
    b(false, null);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (paramIntent == null) {
      return;
    }
    byte[] arrayOfByte = new auoa(auoc.a(paramIntent)).encode();
    paramIntent = arrayOfByte;
    if (arrayOfByte == null) {
      paramIntent = new byte[4];
    }
    paramPacket.setTimeout(60000L);
    paramPacket.setSSOCommand("SQQzoneSvc." + "getAIONewestFeeds");
    paramPacket.putSendData(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     auob
 * JD-Core Version:    0.7.0.1
 */