package com.tencent.biz.pubaccount.util;

import android.os.Bundle;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.BDHCommonUploadProcessor;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.JSPttDownloadProcessor;
import com.tencent.mobileqq.transfile.JSPttUploadProcessor;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mth;

public class PAH5Manager
  implements INetEngine.INetEngineListener
{
  public TroopMemberApiService a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private INetEngine jdField_a_of_type_ComTencentMobileqqTransfileINetEngine;
  TransProcessorHandler jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = new mth(this);
  private String jdField_a_of_type_JavaLangString;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public HashMap a;
  private ArrayList b;
  public HashMap b;
  private ArrayList jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  HashMap jdField_c_of_type_JavaUtilHashMap = new HashMap();
  
  public PAH5Manager(TroopMemberApiService paramTroopMemberApiService, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService = paramTroopMemberApiService;
    this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine = paramQQAppInterface.getNetEngine(0);
  }
  
  private void a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      HttpNetReq localHttpNetReq = (HttpNetReq)localIterator.next();
      if (localHttpNetReq.jdField_a_of_type_JavaLangString.equals(paramString)) {
        localArrayList.add(localHttpNetReq);
      }
    }
    this.jdField_b_of_type_JavaUtilArrayList.removeAll(localArrayList);
  }
  
  public void a()
  {
    Object localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine != null)
    {
      localObject1 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (HttpNetReq)((Iterator)localObject1).next();
        this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.b((NetReq)localObject2);
      }
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localObject1 != null)
    {
      localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      TransferRequest localTransferRequest;
      while (((Iterator)localObject2).hasNext())
      {
        localTransferRequest = (TransferRequest)((Iterator)localObject2).next();
        ((TransFileController)localObject1).a(localTransferRequest.jdField_c_of_type_JavaLangString, localTransferRequest.jdField_a_of_type_Long);
      }
      localObject2 = this.jdField_c_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localTransferRequest = (TransferRequest)((Iterator)localObject2).next();
        ((TransFileController)localObject1).b(localTransferRequest.jdField_c_of_type_JavaLangString, localTransferRequest.jdField_a_of_type_Long);
      }
    }
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_b_of_type_JavaUtilHashMap.clear();
    this.jdField_c_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_JavaUtilArrayList.clear();
  }
  
  public void a(long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      TransferRequest localTransferRequest = (TransferRequest)localIterator.next();
      if (localTransferRequest.jdField_a_of_type_Long == paramLong) {
        localArrayList.add(localTransferRequest);
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList.removeAll(localArrayList);
  }
  
  public void a(Bundle paramBundle)
  {
    if (HttpUtil.a() == 0)
    {
      paramBundle.putLong("uniseq", 0L);
      paramBundle.putString("pic_server_id", "-1");
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(24, paramBundle);
      return;
    }
    String str = paramBundle.getString("pic_local_path");
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("pic_puin");
    TransFileController localTransFileController = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.a(new Class[] { BDHCommonUploadProcessor.class });
    localTransFileController.a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.jdField_a_of_type_Boolean = true;
    localTransferRequest.jdField_c_of_type_Int = 10;
    localTransferRequest.i = str;
    localTransferRequest.jdField_a_of_type_Long = ((Math.random() * 1000000.0D));
    localTransferRequest.jdField_c_of_type_JavaLangString = "0";
    localTransferRequest.jdField_b_of_type_Int = 24;
    localTransferRequest.jdField_a_of_type_JavaLangString = "PAJSSDKPicUploadProcess";
    localTransFileController.a(localTransferRequest);
    this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(localTransferRequest.jdField_a_of_type_Long), paramBundle);
    this.jdField_b_of_type_JavaUtilHashMap.put(Long.valueOf(localTransferRequest.jdField_a_of_type_Long), paramBundle);
    this.jdField_a_of_type_JavaUtilArrayList.add(localTransferRequest);
  }
  
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2) {}
  
  public void a(NetResp paramNetResp)
  {
    Object localObject;
    Bundle localBundle;
    if ((paramNetResp != null) && ((paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq instanceof HttpNetReq)))
    {
      localObject = (HttpNetReq)paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq;
      if ((paramNetResp.jdField_a_of_type_Int == 0) || (paramNetResp.jdField_a_of_type_Int == 1))
      {
        localBundle = (Bundle)this.jdField_c_of_type_JavaUtilHashMap.remove(((HttpNetReq)localObject).jdField_a_of_type_JavaLangString);
        a(((HttpNetReq)localObject).jdField_a_of_type_JavaLangString);
        if (localBundle != null)
        {
          if ((((HttpNetReq)localObject).jdField_a_of_type_JavaLangString == null) || (paramNetResp.jdField_a_of_type_Int != 0)) {
            break label290;
          }
          paramNetResp = ((HttpNetReq)localObject).jdField_a_of_type_JavaLangString.split("/");
          if (paramNetResp.length < 2) {
            break label290;
          }
          localBundle.putString("pic_local_id", paramNetResp[(paramNetResp.length - 2)]);
          localObject = ((HttpNetReq)localObject).jdField_c_of_type_JavaLangString;
          if ((localObject == null) || ("".equals(localObject))) {
            break label290;
          }
          paramNetResp = new File((String)localObject);
          if (!paramNetResp.exists()) {
            break label290;
          }
          localBundle.putString("pic_local_path", (String)localObject);
        }
      }
    }
    try
    {
      String str1 = FileUtils.a((String)localObject);
      int i = ((String)localObject).lastIndexOf(".");
      if (i != -1)
      {
        String str2 = ((String)localObject).substring(i + 1);
        if ((str1 != null) && (!str1.equals(str2)))
        {
          localObject = ((String)localObject).substring(0, i) + "." + str1;
          if (paramNetResp.renameTo(new File((String)localObject))) {
            localBundle.putString("pic_local_path", (String)localObject);
          }
        }
      }
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(26, localBundle);
      return;
    }
    catch (Exception paramNetResp)
    {
      localBundle.putString("pic_local_id", "-1");
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(26, localBundle);
      return;
    }
    label290:
    localBundle.putString("pic_local_id", "-1");
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(26, localBundle);
  }
  
  public void b(long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_c_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      TransferRequest localTransferRequest = (TransferRequest)localIterator.next();
      if (localTransferRequest.jdField_a_of_type_Long == paramLong) {
        localArrayList.add(localTransferRequest);
      }
    }
    this.jdField_c_of_type_JavaUtilArrayList.removeAll(localArrayList);
  }
  
  public void b(Bundle paramBundle)
  {
    int k = 0;
    if (HttpUtil.a() == 0)
    {
      paramBundle.putString("pic_local_id", "-1");
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(26, paramBundle);
    }
    do
    {
      return;
      String str = paramBundle.getString("pic_server_id");
      paramBundle.putInt("seq", paramBundle.getInt("seq", -1));
      HttpNetReq localHttpNetReq = new HttpNetReq();
      localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = this;
      localHttpNetReq.jdField_a_of_type_JavaLangString = str;
      localHttpNetReq.jdField_c_of_type_Long = 180000L;
      if (localHttpNetReq.jdField_a_of_type_JavaLangString == null) {
        break;
      }
      Object localObject1 = localHttpNetReq.jdField_a_of_type_JavaLangString.split("/");
      if (localObject1.length < 2) {
        break;
      }
      localObject1 = localObject1[(localObject1.length - 2)];
      localHttpNetReq.jdField_c_of_type_JavaLangString = (AppConstants.aJ + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount() + "/" + "c2bPIC/" + (String)localObject1 + ".png");
      Object localObject2 = new File(AppConstants.aJ + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount() + "/" + "c2bPIC/");
      ArrayList localArrayList = new ArrayList();
      localObject2 = ((File)localObject2).listFiles();
      if (localObject2 != null)
      {
        int i = 0;
        int j;
        while (i < localObject2.length)
        {
          if (!localObject2[i].isDirectory())
          {
            j = localObject2[i].getName().lastIndexOf(".");
            if (j != -1) {
              localArrayList.add(localObject2[i].getName().substring(0, j));
            }
          }
          i += 1;
        }
        i = 0;
        for (;;)
        {
          j = k;
          if (i < localArrayList.size())
          {
            if (((String)localObject1).equalsIgnoreCase((String)localArrayList.get(i))) {
              j = 1;
            }
          }
          else
          {
            if (j == 0) {
              break;
            }
            paramBundle.putString("pic_local_id", (String)localObject1);
            this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(26, paramBundle);
            return;
          }
          i += 1;
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.a(localHttpNetReq);
      this.jdField_c_of_type_JavaUtilHashMap.put(str, paramBundle);
      this.jdField_b_of_type_JavaUtilArrayList.add(localHttpNetReq);
    } while (paramBundle.getInt("is_showProgress_tips") != 1);
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(25, paramBundle);
    return;
    paramBundle.putString("pic_local_id", "-1");
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(26, paramBundle);
  }
  
  public void c(Bundle paramBundle)
  {
    String str = paramBundle.getString("pic_local_path");
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.a(new Class[] { JSPttUploadProcessor.class });
    ((TransFileController)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
    localObject = new TransferRequest();
    ((TransferRequest)localObject).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    ((TransferRequest)localObject).jdField_c_of_type_JavaLangString = "255";
    ((TransferRequest)localObject).jdField_a_of_type_Int = 9999;
    ((TransferRequest)localObject).jdField_b_of_type_Int = 32;
    ((TransferRequest)localObject).jdField_a_of_type_Long = ((Math.random() * 1000000.0D));
    ((TransferRequest)localObject).jdField_a_of_type_Boolean = true;
    ((TransferRequest)localObject).i = str;
    ((TransferRequest)localObject).jdField_e_of_type_Int = 102;
    ((TransferRequest)localObject).l = true;
    ((TransferRequest)localObject).n = 2;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((TransferRequest)localObject);
    this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(((TransferRequest)localObject).jdField_a_of_type_Long), paramBundle);
    this.jdField_b_of_type_JavaUtilHashMap.put(Long.valueOf(((TransferRequest)localObject).jdField_a_of_type_Long), paramBundle);
    this.jdField_c_of_type_JavaUtilArrayList.add(localObject);
  }
  
  public void d(Bundle paramBundle)
  {
    String str = paramBundle.getString("pic_server_id");
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.a(new Class[] { JSPttDownloadProcessor.class });
    ((TransFileController)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
    localObject = new TransferRequest();
    ((TransferRequest)localObject).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    ((TransferRequest)localObject).jdField_c_of_type_JavaLangString = "255";
    ((TransferRequest)localObject).jdField_a_of_type_Int = 9999;
    ((TransferRequest)localObject).jdField_b_of_type_Int = 32;
    ((TransferRequest)localObject).jdField_a_of_type_Long = ((Math.random() * 1000.0D));
    ((TransferRequest)localObject).jdField_a_of_type_Boolean = false;
    ((TransferRequest)localObject).jdField_e_of_type_JavaLangString = str;
    ((TransferRequest)localObject).h = (AppConstants.aJ + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount() + "/" + "c2bPTT/" + str + ".amr");
    if (new File(((TransferRequest)localObject).h).exists())
    {
      paramBundle.putString("pic_local_id", new PublicAccountH5AbilityForPtt().a(((TransferRequest)localObject).h));
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(26, paramBundle);
      return;
    }
    ((TransferRequest)localObject).jdField_b_of_type_Boolean = true;
    ((TransferRequest)localObject).d = 5;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((TransferRequest)localObject);
    this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(((TransferRequest)localObject).jdField_a_of_type_Long), paramBundle);
    this.jdField_b_of_type_JavaUtilHashMap.put(Long.valueOf(((TransferRequest)localObject).jdField_a_of_type_Long), paramBundle);
    this.jdField_c_of_type_JavaUtilArrayList.add(localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.PAH5Manager
 * JD-Core Version:    0.7.0.1
 */