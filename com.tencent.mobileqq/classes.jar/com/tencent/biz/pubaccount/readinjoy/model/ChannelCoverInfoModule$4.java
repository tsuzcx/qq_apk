package com.tencent.biz.pubaccount.readinjoy.model;

import ajjy;
import android.text.TextUtils;
import azxx;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import opa;
import opb;
import org.json.JSONException;
import org.json.JSONObject;
import pox;
import prk;

public class ChannelCoverInfoModule$4
  implements Runnable
{
  public ChannelCoverInfoModule$4(opa paramopa) {}
  
  public void run()
  {
    List localList1 = this.this$0.c();
    if (localList1.isEmpty())
    {
      localList1.add(new pox(TabChannelCoverInfo.TYPE_CHANNEL_MY_CONFIG, ajjy.a(2131635749), ajjy.a(2131635721)));
      localList1.add(new pox(TabChannelCoverInfo.TYPE_CHANNEL_RECOMMEND_CONFIG, ajjy.a(2131635738), ajjy.a(2131635747)));
    }
    Object localObject2 = new HashMap();
    Object localObject1 = localList1.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (pox)((Iterator)localObject1).next();
      ((HashMap)localObject2).put(Long.valueOf(((pox)localObject3).jdField_a_of_type_Long), ((pox)localObject3).jdField_a_of_type_JavaUtilList);
    }
    localObject1 = ((pox)localList1.get(0)).jdField_a_of_type_JavaUtilList;
    Object localObject3 = opa.a(this.this$0);
    Object localObject4;
    if ((localObject3 != null) && (((List)localObject3).size() > 0))
    {
      localObject4 = localList1.iterator();
      while (((Iterator)localObject4).hasNext()) {
        ((pox)((Iterator)localObject4).next()).jdField_a_of_type_JavaUtilList.clear();
      }
      localObject3 = ((List)localObject3).iterator();
      for (;;)
      {
        if (((Iterator)localObject3).hasNext())
        {
          localObject4 = (TabChannelCoverInfo)((Iterator)localObject3).next();
          QLog.d("ChannelCoverInfoModule", 2, ((TabChannelCoverInfo)localObject4).toString());
          if (!TextUtils.isEmpty(((TabChannelCoverInfo)localObject4).redPointJson)) {}
          try
          {
            ((TabChannelCoverInfo)localObject4).redPoint = ((prk)azxx.b(new JSONObject(((TabChannelCoverInfo)localObject4).redPointJson), prk.class));
            List localList2 = (List)((HashMap)localObject2).get(Long.valueOf(((TabChannelCoverInfo)localObject4).channelConfigType));
            if (localList2 != null) {
              localList2.add(localObject4);
            }
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.e("ChannelCoverInfoModule", 2, "loadAllChannelCoverListFromDb: " + localJSONException);
              }
            }
          }
        }
      }
      localObject2 = localList1.iterator();
      while (((Iterator)localObject2).hasNext()) {
        Collections.sort(((pox)((Iterator)localObject2).next()).jdField_a_of_type_JavaUtilList, new opb(this));
      }
      if (((List)localObject1).size() == 0)
      {
        QLog.d("ChannelCoverInfoModule", 2, "loadAllChannelCoverListFromDb mylist empty");
        ((List)localObject1).addAll(this.this$0.b());
        ((pox)localList1.get(1)).jdField_a_of_type_JavaUtilList.clear();
        localObject2 = opa.b(this.this$0).iterator();
      }
    }
    label838:
    for (;;)
    {
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (TabChannelCoverInfo)((Iterator)localObject2).next();
        localObject4 = ((List)localObject1).iterator();
        TabChannelCoverInfo localTabChannelCoverInfo;
        do
        {
          if (!((Iterator)localObject4).hasNext()) {
            break;
          }
          localTabChannelCoverInfo = (TabChannelCoverInfo)((Iterator)localObject4).next();
        } while (((TabChannelCoverInfo)localObject3).mChannelCoverId != localTabChannelCoverInfo.mChannelCoverId);
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label838;
        }
        ((pox)localList1.get(1)).jdField_a_of_type_JavaUtilList.add(localObject3);
        break;
        localObject2 = opa.a(this.this$0, opa.a(this.this$0, (List)localObject1), TabChannelCoverInfo.TYPE_CHANNEL_MY_CONFIG);
        ((List)localObject1).clear();
        ((List)localObject1).addAll((Collection)localObject2);
        localObject2 = localList1.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (pox)((Iterator)localObject2).next();
          opa.a(((pox)localObject3).jdField_a_of_type_JavaUtilList, "loadAllChannelCoverListFromDb " + ((pox)localObject3).jdField_a_of_type_Long);
        }
        opa.a(this.this$0, true, (List)localObject1);
        for (;;)
        {
          ThreadManager.getUIHandler().post(new ChannelCoverInfoModule.4.2(this, localList1));
          return;
          if (QLog.isColorLevel()) {
            QLog.d("ChannelCoverInfoModule", 2, "loadAllChannelCoverListFromDb list is null");
          }
          ((List)localObject1).addAll(this.this$0.b());
          ((pox)localList1.get(1)).jdField_a_of_type_JavaUtilList.clear();
          ((pox)localList1.get(1)).jdField_a_of_type_JavaUtilList.addAll(opa.b(this.this$0));
          localObject2 = localList1.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (pox)((Iterator)localObject2).next();
            opa.a(((pox)localObject3).jdField_a_of_type_JavaUtilList, "loadAllChannelCoverListFromDb default" + ((pox)localObject3).jdField_a_of_type_Long);
          }
          opa.a(this.this$0, true, (List)localObject1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ChannelCoverInfoModule.4
 * JD-Core Version:    0.7.0.1
 */