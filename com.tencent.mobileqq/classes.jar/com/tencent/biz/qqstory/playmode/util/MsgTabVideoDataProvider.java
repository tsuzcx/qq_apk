package com.tencent.biz.qqstory.playmode.util;

import android.text.TextUtils;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInsertLocalVideoInfoSegment;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodePullVideoBasicInfoSegment;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeVidListPullSegment;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;
import nmo;
import nmp;

public class MsgTabVideoDataProvider
{
  public MsgTabVideoDataProvider.OnRequestVideoListListener a;
  public List a;
  public Map a;
  
  public MsgTabVideoDataProvider(MsgTabVideoDataProvider.OnRequestVideoListListener paramOnRequestVideoListListener, List paramList)
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilMsgTabVideoDataProvider$OnRequestVideoListListener = paramOnRequestVideoListListener;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public static int a(List paramList, int paramInt)
  {
    Object localObject;
    int j;
    int i;
    int k;
    MsgTabVideoData localMsgTabVideoData;
    if ((paramList != null) && (paramList.size() > 0))
    {
      localObject = null;
      int m = paramList.size();
      j = 0;
      i = 0;
      k = 0;
      if (j < m)
      {
        localMsgTabVideoData = (MsgTabVideoData)paramList.get(j);
        if (localMsgTabVideoData.jdField_b_of_type_Boolean) {
          label57:
          return j;
        }
        if (localObject == null) {
          if (!localMsgTabVideoData.a)
          {
            k = 1;
            label75:
            localObject = localMsgTabVideoData;
          }
        }
      }
    }
    for (;;)
    {
      j += 1;
      break;
      k = 0;
      break label75;
      if ((localObject.a) && (!localMsgTabVideoData.a))
      {
        i = j;
        k = 1;
        localObject = localMsgTabVideoData;
        continue;
        if (paramInt != 1)
        {
          j = i;
          if (paramInt != 3) {
            break label57;
          }
        }
        j = i;
        if (k != 0) {
          break label57;
        }
        return paramList.size() - 1;
        return -1;
      }
    }
  }
  
  private void a(MsgTabNodeInfo paramMsgTabNodeInfo1, MsgTabNodeInfo paramMsgTabNodeInfo2, int paramInt1, List paramList, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, long paramLong)
  {
    long l = System.currentTimeMillis();
    int i;
    if (paramBoolean2)
    {
      i = 1;
      if (!paramBoolean1) {
        break label95;
      }
    }
    label95:
    for (int j = 1;; j = 2)
    {
      StoryReportor.b("play_video", "msg_tab", i, j, new String[] { String.valueOf(l - paramLong), String.valueOf(paramInt1), String.valueOf(paramInt2) });
      ThreadManager.getUIHandler().post(new nmp(this, paramMsgTabNodeInfo2, paramMsgTabNodeInfo1, paramInt1, paramBoolean1, paramList, paramInt2, paramBoolean2));
      return;
      i = 2;
      break;
    }
  }
  
  public MsgTabNodeInfo a(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    int i = this.jdField_a_of_type_JavaUtilList.indexOf(paramMsgTabNodeInfo);
    if ((i >= 0) && (i < this.jdField_a_of_type_JavaUtilList.size() - 1)) {
      return (MsgTabNodeInfo)this.jdField_a_of_type_JavaUtilList.get(i + 1);
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilMsgTabVideoDataProvider$OnRequestVideoListListener = null;
  }
  
  public void a(MsgTabNodeInfo paramMsgTabNodeInfo1, MsgTabNodeInfo paramMsgTabNodeInfo2, int paramInt)
  {
    long l = System.currentTimeMillis();
    List localList = (List)this.jdField_a_of_type_JavaUtilMap.get(paramMsgTabNodeInfo1.a);
    if ((localList != null) && (!localList.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgTab.MsgTabVideoDataProvider", 2, new Object[] { "requestVideoList memory hit. nodeId=", paramMsgTabNodeInfo1.a, ",currentNodeId=", paramMsgTabNodeInfo2.a });
      }
      a(paramMsgTabNodeInfo1, paramMsgTabNodeInfo2, paramInt, localList, true, 0, true, l);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabVideoDataProvider", 2, new Object[] { "requestVideoList first db then network. nodeId=", paramMsgTabNodeInfo1.a });
    }
    Stream.of(paramMsgTabNodeInfo1).map(new ThreadOffFunction(2)).map(new MsgTabNodeVidListPullSegment(false)).map(new MsgTabNodePullVideoBasicInfoSegment()).map(new MsgTabNodeInsertLocalVideoInfoSegment(paramMsgTabNodeInfo1)).subscribe(new nmo(this, paramMsgTabNodeInfo1, paramMsgTabNodeInfo2, paramInt, l));
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      paramString1 = (List)this.jdField_a_of_type_JavaUtilMap.get(paramString1);
      if ((paramString1 != null) && (!paramString1.isEmpty()))
      {
        paramString1 = paramString1.iterator();
        while (paramString1.hasNext())
        {
          MsgTabVideoData localMsgTabVideoData = (MsgTabVideoData)paramString1.next();
          if (TextUtils.equals(localMsgTabVideoData.jdField_b_of_type_JavaLangString, paramString2)) {
            localMsgTabVideoData.a = true;
          }
        }
      }
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    int j = 1;
    int k = 0;
    label23:
    MsgTabVideoData localMsgTabVideoData;
    if (TextUtils.isEmpty(paramString3))
    {
      if (TextUtils.isEmpty(paramString2)) {
        break label194;
      }
      i = 1;
      if (i != 0)
      {
        paramString3 = (List)this.jdField_a_of_type_JavaUtilMap.get(paramString2);
        i = k;
        if (paramString3 != null)
        {
          i = k;
          if (!paramString3.isEmpty())
          {
            Iterator localIterator = paramString3.iterator();
            do
            {
              i = k;
              if (!localIterator.hasNext()) {
                break;
              }
              localMsgTabVideoData = (MsgTabVideoData)localIterator.next();
            } while (!TextUtils.equals(paramString1, localMsgTabVideoData.jdField_b_of_type_JavaLangString));
            if (paramString3.size() != 1) {
              break label200;
            }
          }
        }
      }
    }
    label194:
    label200:
    for (int i = j;; i = 0)
    {
      paramString3.remove(localMsgTabVideoData);
      if (i != 0)
      {
        paramString1 = this.jdField_a_of_type_JavaUtilList.iterator();
        while (paramString1.hasNext())
        {
          paramString3 = (MsgTabNodeInfo)paramString1.next();
          if (TextUtils.equals(paramString2, paramString3.a)) {
            this.jdField_a_of_type_JavaUtilList.remove(paramString3);
          }
        }
      }
      return;
      paramString2 = paramString3;
      break;
      i = 0;
      break label23;
    }
  }
  
  public MsgTabNodeInfo b(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    int i = this.jdField_a_of_type_JavaUtilList.indexOf(paramMsgTabNodeInfo);
    if ((i > 0) && (i < this.jdField_a_of_type_JavaUtilList.size())) {
      return (MsgTabNodeInfo)this.jdField_a_of_type_JavaUtilList.get(i - 1);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.util.MsgTabVideoDataProvider
 * JD-Core Version:    0.7.0.1
 */