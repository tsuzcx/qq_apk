package com.tencent.biz.pubaccount.readinjoy.model;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFHandlerUtils;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFService;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyOidbHelper;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import lqn;
import lqo;
import lqp;
import lqq;
import mqq.app.MobileQQ;
import tencent.im.oidb.cmd0x69f.oidb_cmd0x69f.ChannelInfo;
import tencent.im.oidb.cmd0x69f.oidb_cmd0x69f.ReqBody;
import tencent.im.oidb.cmd0x69f.oidb_cmd0x69f.RspBody;

public class ChannelCoverInfoModule
  extends ChannelInfoModule
{
  private int jdField_a_of_type_Int;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private LinkedHashMap jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  private int jdField_b_of_type_Int;
  private LinkedHashMap jdField_b_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  
  public ChannelCoverInfoModule(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, ReadInJoyMSFService paramReadInJoyMSFService, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramReadInJoyMSFService, paramHandler);
    if (QLog.isColorLevel()) {
      QLog.d("ChannelCoverInfoModule", 2, "construct!");
    }
  }
  
  private int a(int paramInt)
  {
    if (paramInt == 0) {
      return this.jdField_a_of_type_Int;
    }
    if (paramInt == 56) {
      return this.jdField_b_of_type_Int;
    }
    return 0;
  }
  
  private int a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    int j = 0;
    paramQQAppInterface = paramQQAppInterface.getApplication().getSharedPreferences("sp_public_account_with_cuin_" + paramQQAppInterface.getCurrentAccountUin(), 0);
    int i = j;
    if (paramQQAppInterface != null)
    {
      if (paramInt != 0) {
        break label57;
      }
      i = paramQQAppInterface.getInt("readInJoy_mian_channel_cover_seq", 0);
    }
    label57:
    do
    {
      return i;
      i = j;
    } while (paramInt != 56);
    return paramQQAppInterface.getInt("readInJoy_video_channel_cover_seq", 0);
  }
  
  private ChannelCoverInfo a(int paramInt1, int paramInt2)
  {
    ChannelCoverInfo localChannelCoverInfo = null;
    localObject2 = this.jdField_a_of_type_JavaLangObject;
    if (paramInt2 == 0) {}
    for (;;)
    {
      try
      {
        localChannelCoverInfo = (ChannelCoverInfo)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt1));
        return localChannelCoverInfo;
      }
      finally {}
      if (paramInt2 == 56) {
        localChannelCoverInfo = (ChannelCoverInfo)this.jdField_b_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt1));
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0) {
      this.jdField_a_of_type_Int = paramInt2;
    }
    while (paramInt1 != 56) {
      return;
    }
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  private void a(ChannelCoverInfo paramChannelCoverInfo, int paramInt)
  {
    localObject = this.jdField_a_of_type_JavaLangObject;
    if (paramInt == 0) {}
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_JavaUtilLinkedHashMap.put(Integer.valueOf(paramChannelCoverInfo.mChannelCoverId), paramChannelCoverInfo);
        return;
      }
      finally {}
      if (paramInt == 56) {
        this.jdField_b_of_type_JavaUtilLinkedHashMap.put(Integer.valueOf(paramChannelCoverInfo.mChannelCoverId), paramChannelCoverInfo);
      }
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2)
  {
    paramQQAppInterface = paramQQAppInterface.getApplication().getSharedPreferences("sp_public_account_with_cuin_" + paramQQAppInterface.getCurrentAccountUin(), 0);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.edit();
      if (paramInt2 != 0) {
        break label104;
      }
      paramQQAppInterface.putInt("readInJoy_mian_channel_cover_seq", paramInt1);
    }
    for (;;)
    {
      paramQQAppInterface.commit();
      if (QLog.isColorLevel()) {
        QLog.d("ChannelCoverInfoModule", 2, "updateChannelCoverSeqConfig, seq =" + paramInt1 + " ;channelId = " + paramInt2);
      }
      return;
      label104:
      if (paramInt2 == 56) {
        paramQQAppInterface.putInt("readInJoy_video_channel_cover_seq", paramInt1);
      }
    }
  }
  
  private boolean a(ChannelCoverInfo paramChannelCoverInfo, int paramInt)
  {
    if (paramChannelCoverInfo == null) {
      return false;
    }
    paramChannelCoverInfo = paramChannelCoverInfo.clone();
    a(paramChannelCoverInfo, paramInt);
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new lqo(this, paramChannelCoverInfo));
    return true;
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    ChannelCoverInfo localChannelCoverInfo = a(paramInt1, paramInt2);
    if (localChannelCoverInfo != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChannelCoverInfoModule", 2, "removeChannelCoverInfoFromDBAndCache channelID=" + paramInt2 + " ;channelCoverId = " + paramInt1);
      }
      b(localChannelCoverInfo, paramInt2);
      this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new lqn(this, localChannelCoverInfo));
    }
  }
  
  private void b(ChannelCoverInfo paramChannelCoverInfo, int paramInt)
  {
    localObject = this.jdField_a_of_type_JavaLangObject;
    Iterator localIterator;
    if (paramInt == 0) {
      label61:
      break label85;
    }
    for (;;)
    {
      label85:
      try
      {
        localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
        if (localIterator.hasNext())
        {
          if (((Integer)localIterator.next()).intValue() != paramChannelCoverInfo.mChannelCoverId) {
            break;
          }
          localIterator.remove();
        }
        return;
      }
      finally {}
      if (paramInt == 56)
      {
        localIterator = this.jdField_b_of_type_JavaUtilLinkedHashMap.keySet().iterator();
        if (localIterator.hasNext())
        {
          if (((Integer)localIterator.next()).intValue() != paramChannelCoverInfo.mChannelCoverId) {
            break label61;
          }
          localIterator.remove();
        }
      }
    }
  }
  
  private List d()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilLinkedHashMap.size());
      Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
      if (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        localArrayList.add((ChannelCoverInfo)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localInteger));
      }
    }
    return localList;
  }
  
  private List d(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChannelCoverInfoModule", 2, "loadFromDb with selection=" + "mChannelID = ?" + ", channelId=" + paramInt);
    }
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(ChannelCoverInfo.class, true, "mChannelID = ?", new String[] { String.valueOf(paramInt) }, null, null, null, null);
  }
  
  private List e()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      ArrayList localArrayList = new ArrayList(this.jdField_b_of_type_JavaUtilLinkedHashMap.size());
      Iterator localIterator = this.jdField_b_of_type_JavaUtilLinkedHashMap.keySet().iterator();
      if (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        localArrayList.add((ChannelCoverInfo)this.jdField_b_of_type_JavaUtilLinkedHashMap.get(localInteger));
      }
    }
    return localList;
  }
  
  public List a(int paramInt)
  {
    List localList = null;
    if (paramInt == 0) {
      localList = d();
    }
    while (paramInt != 56) {
      return localList;
    }
    return e();
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChannelCoverInfoModule", 2, "unInitialize!");
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
      this.jdField_b_of_type_JavaUtilLinkedHashMap.clear();
      return;
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChannelCoverInfoModule", 2, "requestChannelCoverListFromServer");
    }
    Object localObject = new oidb_cmd0x69f.ReqBody();
    long l = Long.valueOf(ReadInJoyUtils.a()).longValue();
    ((oidb_cmd0x69f.ReqBody)localObject).uint64_uin.set(l);
    ((oidb_cmd0x69f.ReqBody)localObject).uint32_req_channel_jump_url.set(1);
    ((oidb_cmd0x69f.ReqBody)localObject).uint32_req_channel_id.set(paramInt);
    ((oidb_cmd0x69f.ReqBody)localObject).uint32_req_channel_cover.set(1);
    if (paramInt == 0)
    {
      ((oidb_cmd0x69f.ReqBody)localObject).uint64_req_ctrl_bits.set(7L);
      int j = a(paramInt);
      int i = j;
      if (j == 0)
      {
        i = j;
        if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null)
        {
          i = j;
          if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {
            i = a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramInt);
          }
        }
      }
      ((oidb_cmd0x69f.ReqBody)localObject).uint32_req_channel_seq.set(i);
      localObject = ReadInJoyOidbHelper.a("OidbSvc.0x69f", 1695, 0, ((oidb_cmd0x69f.ReqBody)localObject).toByteArray());
      if (paramInt != 0) {
        break label205;
      }
      ((ToServiceMsg)localObject).getAttributes().put("req_channellist_source", Integer.valueOf(3));
    }
    for (;;)
    {
      a((ToServiceMsg)localObject);
      return;
      if (paramInt != 56) {
        break;
      }
      ((oidb_cmd0x69f.ReqBody)localObject).uint64_req_ctrl_bits.set(3L);
      break;
      label205:
      if (paramInt == 56) {
        ((ToServiceMsg)localObject).getAttributes().put("req_channellist_source", Integer.valueOf(4));
      }
    }
  }
  
  public void a(int paramInt, String paramString, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChannelCoverInfoModule", 2, "updateMainChannelCoverInfo, channelCoverId = " + paramInt + " ;articleTitle = " + paramString + " ;articleId = " + paramLong);
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      ChannelCoverInfo localChannelCoverInfo = (ChannelCoverInfo)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt));
      if (localChannelCoverInfo != null)
      {
        localChannelCoverInfo.mChannelCoverSummary = paramString;
        localChannelCoverInfo.mArticleId = paramLong;
        a(localChannelCoverInfo, 0);
        d(d(), 0);
      }
      return;
    }
  }
  
  public void a(List paramList, int paramInt)
  {
    if ((paramList == null) || (paramList.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChannelCoverInfoModule", 2, "saveChannelCoverList, list is empty");
      }
      return;
    }
    ArrayList localArrayList = new ArrayList();
    if (QLog.isColorLevel()) {}
    for (StringBuilder localStringBuilder = new StringBuilder("saveChannelCoverList channelID=" + paramInt + "\n");; localStringBuilder = null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ChannelCoverInfo localChannelCoverInfo1 = ReadInJoyMSFHandlerUtils.a((oidb_cmd0x69f.ChannelInfo)paramList.next(), paramInt);
        if ((localChannelCoverInfo1.mChannelCoverName == null) || ("".equals(localChannelCoverInfo1.mChannelCoverName)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ChannelCoverInfoModule", 2, "saveChannelCoverList coverName is null, filter this info");
          }
        }
        else
        {
          if ((localChannelCoverInfo1.mChannelCoverSummary == null) || ("".equals(localChannelCoverInfo1.mChannelCoverSummary)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ChannelCoverInfoModule", 2, "saveChannelCoverList coverSummary is null");
            }
            ChannelCoverInfo localChannelCoverInfo2 = a(localChannelCoverInfo1.mChannelCoverId, paramInt);
            if ((localChannelCoverInfo2 != null) && (localChannelCoverInfo2.mChannelCoverSummary != null) && (!"".equals(localChannelCoverInfo2.mChannelCoverSummary)))
            {
              localChannelCoverInfo1.mChannelCoverSummary = localChannelCoverInfo2.mChannelCoverSummary;
              if (QLog.isColorLevel()) {
                QLog.d("ChannelCoverInfoModule", 2, "saveChannelCoverList modify coverSummary, summary is " + localChannelCoverInfo2.mChannelCoverSummary);
              }
            }
          }
          localArrayList.add(localChannelCoverInfo1);
          if ((QLog.isColorLevel()) && (localStringBuilder != null)) {
            localStringBuilder.append("[channelCoverId=").append(localChannelCoverInfo1.mChannelCoverId).append(", mChannelCoverName=").append(localChannelCoverInfo1.mChannelCoverName).append(", mChannelCoverStyle=").append(localChannelCoverInfo1.mChannelCoverStyle).append(", mChannelCoverSummary=").append(localChannelCoverInfo1.mChannelCoverSummary).append(", mChannelCoverPicUrl=").append(localChannelCoverInfo1.mChannelCoverPicUrl).append(", mChannelJumpUrl=").append(localChannelCoverInfo1.mChannelJumpUrl).append(", mArticleIds=").append(localChannelCoverInfo1.mArticleId).append(", mChannelType=").append(localChannelCoverInfo1.mChannelType).append(", isExternalExposure = ").append(localChannelCoverInfo1.isExternalExposure).append(", externalExposureIcon : ").append(localChannelCoverInfo1.externalExposureBackgroundUrl).append("]\n");
          }
        }
      }
      if ((QLog.isColorLevel()) && (localStringBuilder != null)) {
        QLog.d("ChannelCoverInfoModule", 2, localStringBuilder.toString());
      }
      c(localArrayList, paramInt);
      return;
    }
  }
  
  protected void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int m = ((Integer)paramToServiceMsg.getAttribute("req_channellist_source", Integer.valueOf(1))).intValue();
    paramToServiceMsg = new oidb_cmd0x69f.RspBody();
    int i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, paramToServiceMsg);
    if (QLog.isColorLevel()) {
      QLog.d("ChannelCoverInfoModule", 2, "handleGetChannelAndSubscribeList, result=" + i);
    }
    if (i == 0) {
      if (!paramToServiceMsg.uint32_req_channel_id.has()) {
        break label367;
      }
    }
    label367:
    for (i = paramToServiceMsg.uint32_req_channel_id.get();; i = -1)
    {
      int n;
      if (paramToServiceMsg.uint32_channel_seq.has())
      {
        n = paramToServiceMsg.uint32_channel_seq.get();
        int k = a(i);
        int j = k;
        if (k == 0)
        {
          j = k;
          if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null)
          {
            j = k;
            if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {
              j = a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, i);
            }
          }
        }
        if (n <= j) {
          if (QLog.isColorLevel()) {
            QLog.d("ChannelCoverInfoModule", 2, "handleGetChannelAndSubscribeList, seq is " + n + " ;lastseq = " + j + "; not need to update");
          }
        }
      }
      do
      {
        do
        {
          do
          {
            return;
            a(i, n);
            if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) && ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface))) {
              a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, n, i);
            }
            if ((m != 3) || (i != 0)) {
              break;
            }
          } while (!paramToServiceMsg.rpt_channel_list.has());
          a(paramToServiceMsg.rpt_channel_list.get(), 0);
          return;
        } while ((m != 4) || (i != 56) || (!paramToServiceMsg.rpt_channel_list.has()));
        a(paramToServiceMsg.rpt_channel_list.get(), 56);
        return;
        if (m == 3)
        {
          ReadInJoyLogicEngineEventDispatcher.a().e(false, null);
          return;
        }
      } while (m != 4);
      ReadInJoyLogicEngineEventDispatcher.a().f(false, null);
      return;
    }
  }
  
  public void b(List paramList, int paramInt)
  {
    if (paramList == null) {
      return;
    }
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ChannelCoverInfo localChannelCoverInfo = (ChannelCoverInfo)paramList.next();
      localLinkedHashMap.put(Integer.valueOf(localChannelCoverInfo.mChannelCoverId), localChannelCoverInfo);
    }
    paramList = this.jdField_a_of_type_JavaLangObject;
    if (paramInt == 0) {}
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
        this.jdField_a_of_type_JavaUtilLinkedHashMap.putAll(localLinkedHashMap);
        return;
      }
      finally {}
      if (paramInt == 56)
      {
        this.jdField_b_of_type_JavaUtilLinkedHashMap.clear();
        this.jdField_b_of_type_JavaUtilLinkedHashMap.putAll(localMap);
      }
    }
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new lqp(this, paramInt));
  }
  
  public void c(List paramList, int paramInt)
  {
    if (paramList == null) {
      return;
    }
    Object localObject = a(paramInt);
    if ((localObject != null) && (paramList != null) && (QLog.isColorLevel())) {
      QLog.d("ChannelCoverInfoModule", 2, "saveNewAndRemoveOldChannelCoverInfo removeListSize =" + ((List)localObject).size() + " ;addListSize = " + paramList.size());
    }
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        b(((ChannelCoverInfo)((Iterator)localObject).next()).mChannelCoverId, paramInt);
      }
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      a((ChannelCoverInfo)paramList.next(), paramInt);
    }
    d(a(paramInt), paramInt);
  }
  
  public void d(List paramList, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.post(new lqq(this, paramInt, paramList));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ChannelCoverInfoModule
 * JD-Core Version:    0.7.0.1
 */