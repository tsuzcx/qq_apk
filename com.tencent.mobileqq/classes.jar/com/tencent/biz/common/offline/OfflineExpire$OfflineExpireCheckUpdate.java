package com.tencent.biz.common.offline;

import KQQ.ReqItem;
import KQQ.RespItem;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.service.profile.CheckUpdateItemInterface;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import klp;
import mqq.os.MqqHandler;
import tencent.im.sso.offlinpkg.OfflinePkg.BidPkg;
import tencent.im.sso.offlinpkg.OfflinePkg.ReqBody;
import tencent.im.sso.offlinpkg.OfflinePkg.RspBody;

public class OfflineExpire$OfflineExpireCheckUpdate
  implements CheckUpdateItemInterface
{
  public OfflineExpire$OfflineExpireCheckUpdate(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface.getLongAccountUin() % 10L == 6L) {}
    for (boolean bool = true;; bool = false)
    {
      HtmlOffline.jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  public int a()
  {
    return 1;
  }
  
  public ReqItem a()
  {
    if (OfflineExpire.jdField_a_of_type_Boolean) {
      return null;
    }
    OfflineExpire.jdField_a_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d(OfflineExpire.jdField_a_of_type_JavaLangString, 2, "getCheckUpdateItemData");
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    ReqItem localReqItem;
    OfflinePkg.ReqBody localReqBody;
    int k;
    String str;
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      localReqItem = new ReqItem();
      localReqItem.cOperType = 1;
      localReqItem.eServiceID = 127;
      localReqBody = new OfflinePkg.ReqBody();
      localReqBody.uint32_cmd.set(2);
      localReqBody.uint32_platform.set(OfflineExpire.jdField_a_of_type_Int);
      if (QLog.isColorLevel()) {
        QLog.d(OfflineExpire.jdField_a_of_type_JavaLangString, 1, String.format("OfflineExpireCheckUpdate, check update QQ Version: %s", new Object[] { "7.6.3.3560" }));
      }
      localReqBody.str_qver.set(ByteStringMicro.copyFrom("7.6.3.3560".getBytes()));
      localReqBody.str_osrelease.set(ByteStringMicro.copyFrom(Build.VERSION.RELEASE.getBytes()));
      i = NetworkUtil.a(((QQAppInterface)localObject).getApp());
      localReqBody.int32_network.set(i);
      localReqBody.str_from.set(ByteStringMicro.copyFrom("predown".getBytes()));
      localObject = HtmlOffline.a();
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label426;
      }
      String[] arrayOfString = ((String)localObject).split(",");
      int n = arrayOfString.length;
      k = 0;
      if (k >= n) {
        break label426;
      }
      str = arrayOfString[k];
      if (!TextUtils.isEmpty(str)) {
        localObject = str.split("\\|");
      }
    }
    for (;;)
    {
      for (;;)
      {
        int j;
        try
        {
          i = Integer.valueOf(localObject[0]).intValue();
        }
        catch (NumberFormatException localNumberFormatException1)
        {
          int m;
          j = 0;
          localNumberFormatException1.printStackTrace();
          if (QLog.isColorLevel()) {
            QLog.i(OfflineExpire.jdField_a_of_type_JavaLangString, 2, "NumberFormatException:" + str);
          }
          i = 0;
          continue;
        }
        catch (Exception localException1)
        {
          j = 0;
        }
        try
        {
          m = Integer.valueOf(localObject[1]).intValue();
          j = i;
          i = m;
          if (j != 0) {
            break label383;
          }
          k += 1;
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            OfflinePkg.BidPkg localBidPkg;
            j = i;
          }
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          label383:
          j = i;
        }
      }
      return null;
      if (QLog.isColorLevel()) {
        QLog.i(OfflineExpire.jdField_a_of_type_JavaLangString, 2, "Exception:" + str);
      }
      i = 0;
      continue;
      localBidPkg = new OfflinePkg.BidPkg();
      localBidPkg.uint32_bid.set(j);
      localBidPkg.uint32_pkg_id.add(Integer.valueOf(i));
      localReqBody.st_bid_pkg.add(localBidPkg);
    }
    label426:
    localReqItem.vecParam = WupUtil.a(localReqBody.toByteArray());
    return localReqItem;
  }
  
  public void a(RespItem paramRespItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d(OfflineExpire.jdField_a_of_type_JavaLangString, 2, "handleCheckUpdateItemData");
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      if (paramRespItem.cResult != 2) {
        break label279;
      }
      if (paramRespItem.eServiceID == 127)
      {
        paramRespItem = WupUtil.b(paramRespItem.vecUpdate);
        if (paramRespItem != null) {
          localRspBody = new OfflinePkg.RspBody();
        }
      }
    }
    label279:
    while (!QLog.isColorLevel()) {
      try
      {
        OfflinePkg.RspBody localRspBody;
        localRspBody.mergeFrom(paramRespItem);
        OfflineExpire.a(new String(localRspBody.str_expire_pkg.get().toByteArray(), "UTF-8"));
        OfflineExpire.a(new String(localRspBody.str_predown_pkg_ex.get().toByteArray(), "UTF-8"), (QQAppInterface)localObject, ((QQAppInterface)localObject).getApp().getApplicationContext(), 1);
        ThreadManager.getSubThreadHandler().postDelayed(new klp(this), 180000L);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramRespItem)
      {
        for (;;)
        {
          paramRespItem.printStackTrace();
          if (QLog.isColorLevel()) {
            QLog.i(OfflineExpire.jdField_a_of_type_JavaLangString, 2, "handleCheckUpdateItemData: " + QLog.getStackTraceString(paramRespItem));
          }
        }
      }
      catch (UnsupportedEncodingException paramRespItem)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i(OfflineExpire.jdField_a_of_type_JavaLangString, 2, "handleCheckUpdateItemData: " + QLog.getStackTraceString(paramRespItem));
          }
        }
      }
      catch (Exception paramRespItem)
      {
        for (;;)
        {
          paramRespItem.printStackTrace();
          if (QLog.isColorLevel()) {
            QLog.i(OfflineExpire.jdField_a_of_type_JavaLangString, 2, "handleCheckUpdateItemData: " + QLog.getStackTraceString(paramRespItem));
          }
        }
      }
    }
    QLog.d(OfflineExpire.jdField_a_of_type_JavaLangString, 2, "***handleCheckUpdateItemData fail respitem.cResult:" + paramRespItem.cResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.common.offline.OfflineExpire.OfflineExpireCheckUpdate
 * JD-Core Version:    0.7.0.1
 */