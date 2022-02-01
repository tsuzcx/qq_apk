package com.tencent.biz.qqstory.base;

import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.VideoReaderConf;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class QQStoryBanInfo
{
  public int a;
  public List<QQUserUIItem> a;
  public List<Long> b = null;
  
  public QQStoryBanInfo(AppInterface paramAppInterface, qqstory_struct.VideoReaderConf paramVideoReaderConf)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_a_of_type_Int = paramVideoReaderConf.ban_type.get();
    List localList = paramVideoReaderConf.user_list.get();
    paramVideoReaderConf = paramVideoReaderConf.user_unionid_list.get();
    UserManager localUserManager = (UserManager)SuperManager.a(2);
    if ((localList != null) && (!localList.isEmpty()) && (paramVideoReaderConf != null) && (!paramVideoReaderConf.isEmpty()) && (localList.size() == paramVideoReaderConf.size()))
    {
      int j = localList.size();
      this.jdField_a_of_type_JavaUtilList = new ArrayList(j);
      int i = 0;
      while (i < j)
      {
        String str = String.valueOf(localList.get(i));
        Object localObject = ((ByteStringMicro)paramVideoReaderConf.get(i)).toStringUtf8();
        localUserManager.a((String)localObject, str);
        localObject = a(paramAppInterface, (String)localObject, str, false);
        if (localObject != null) {
          this.jdField_a_of_type_JavaUtilList.add(localObject);
        }
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("StoryPlayVideoPrivacyActivity ");
          localStringBuilder.append(i);
          localStringBuilder.append(": qq = ");
          localStringBuilder.append(str);
          localStringBuilder.append(", user = ");
          localStringBuilder.append(localObject);
          QLog.d("zivonchen", 2, localStringBuilder.toString());
        }
        i += 1;
      }
    }
  }
  
  private static QQUserUIItem a(AppInterface paramAppInterface, String paramString1, String paramString2, boolean paramBoolean)
  {
    QQUserUIItem localQQUserUIItem = new QQUserUIItem();
    localQQUserUIItem.qq = paramString2;
    localQQUserUIItem.uid = paramString1;
    paramAppInterface = ((FriendsManager)paramAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(String.valueOf(paramString2));
    if (paramAppInterface == null) {
      return null;
    }
    localQQUserUIItem.nickName = paramAppInterface.name;
    localQQUserUIItem.remark = paramAppInterface.remark;
    return localQQUserUIItem;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QQStoryBanInfo banType = ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", uinSize = ");
    List localList = this.jdField_a_of_type_JavaUtilList;
    int j = 0;
    int i;
    if (localList == null) {
      i = 0;
    } else {
      i = localList.size();
    }
    localStringBuilder.append(i);
    localStringBuilder.append(", grouplistSize =");
    localList = this.b;
    if (localList == null) {
      i = j;
    } else {
      i = localList.size();
    }
    localStringBuilder.append(i);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.QQStoryBanInfo
 * JD-Core Version:    0.7.0.1
 */