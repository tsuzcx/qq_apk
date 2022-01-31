package com.tencent.mobileqq.apollo;

import android.os.Bundle;
import android.os.Message;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.ApolloDaoManager;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.VasExtensionObserver;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.pb.apollo.STGameResUpdate.STGameVerInfoOut;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;
import yjy;

public class ApolloGameObserver
  extends VasExtensionObserver
{
  public QQAppInterface a;
  DownloadListener jdField_a_of_type_ComTencentMobileqqVipDownloadListener = new yjy(this);
  private String jdField_a_of_type_JavaLangString = "ApolloGameObserver";
  
  public ApolloGameObserver(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
    if (localObject != null)
    {
      Message localMessage = ((MqqHandler)localObject).obtainMessage(73);
      localMessage.sendToTarget();
      localObject = ((MqqHandler)localObject).obtainMessage(75);
      ((Message)localObject).arg1 = 100;
      localMessage.arg2 = paramInt;
      ((Message)localObject).sendToTarget();
    }
  }
  
  protected void f(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean)
    {
      Iterator localIterator = ((List)paramObject).iterator();
      if (localIterator.hasNext())
      {
        paramObject = (STGameResUpdate.STGameVerInfoOut)localIterator.next();
        label49:
        int j;
        Object localObject2;
        if (paramObject.isPatch.get() == 1)
        {
          paramBoolean = true;
          j = paramObject.gameId.get();
          Object localObject1 = paramObject.patchUrl.get();
          localObject2 = paramObject.zipUrl.get();
          String str = paramObject.zipMd5.get();
          Object localObject3 = new StringBuilder().append(ApolloConstant.n).append(j);
          if (!paramBoolean) {
            break label399;
          }
          paramObject = ".patch";
          label112:
          localObject3 = new File(paramObject);
          if (!paramBoolean) {
            break label405;
          }
          paramObject = localObject1;
          label137:
          paramObject = new DownloadTask(paramObject, (File)localObject3);
          paramObject.n = false;
          paramObject.h = false;
          paramObject.l = true;
          paramObject.q = true;
          paramObject.o = true;
          paramObject.p = true;
          paramObject.b = true;
          paramObject.f = "apollo_res";
          localObject1 = new Bundle();
          ((Bundle)localObject1).putString("md5", str);
          ((Bundle)localObject1).putBoolean("isPatch", paramBoolean);
          ((Bundle)localObject1).putInt("gameId", j);
          ((Bundle)localObject1).putString("filePath", ((File)localObject3).getAbsolutePath());
          localObject2 = ((DownloaderFactory)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46)).a(1);
          if ((localObject2 != null) && (((DownloaderInterface)localObject2).a(paramObject.jdField_a_of_type_JavaLangString) == null)) {
            ((DownloaderInterface)localObject2).a(paramObject, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener, (Bundle)localObject1);
          }
        }
        for (;;)
        {
          try
          {
            paramObject = (ApolloDaoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(154);
            if (!paramObject.a.containsKey(Integer.valueOf(j))) {
              break label411;
            }
            i = (int)Float.parseFloat((String)paramObject.a.get(Integer.valueOf(j)));
            VipUtils.a(null, "cmshow", "Apollo", "get_pre_download", 0, i, new String[] { String.valueOf(j) });
            VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "game_renew_start", 3, 3, new String[] { String.valueOf(j) });
          }
          catch (Exception paramObject) {}
          break;
          paramBoolean = false;
          break label49;
          label399:
          paramObject = ".zip";
          break label112;
          label405:
          paramObject = localObject2;
          break label137;
          label411:
          int i = 0;
        }
      }
    }
    else
    {
      ApolloUtil.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloGameObserver
 * JD-Core Version:    0.7.0.1
 */