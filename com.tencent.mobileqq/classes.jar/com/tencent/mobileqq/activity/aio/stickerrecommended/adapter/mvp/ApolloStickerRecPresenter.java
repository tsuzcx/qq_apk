package com.tencent.mobileqq.activity.aio.stickerrecommended.adapter.mvp;

import android.view.View;
import android.widget.EditText;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.core.BaseAIOContext;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecData;
import com.tencent.mobileqq.activity.aio.stickerrecommended.impl.StickerRecManagerImpl;
import com.tencent.mobileqq.apollo.aio.item.api.IApolloIceBreakShow;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.emoticonview.EmotionKeywordHorizonListView;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class ApolloStickerRecPresenter
  extends CommonStickerRecPresenter
{
  private static CopyOnWriteArrayList<IApolloIceBreakShow> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  StickerRecData jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedStickerRecData;
  ApolloStickerRecView jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedAdapterMvpApolloStickerRecView;
  
  public ApolloStickerRecPresenter(AppInterface paramAppInterface, QBaseActivity paramQBaseActivity, BaseAIOContext paramBaseAIOContext, EditText paramEditText)
  {
    super(paramAppInterface, paramQBaseActivity, paramBaseAIOContext, paramEditText);
  }
  
  public static void a() {}
  
  private void a(IApolloIceBreakShow paramIApolloIceBreakShow)
  {
    synchronized (jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      if (!jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramIApolloIceBreakShow)) {
        jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramIApolloIceBreakShow);
      }
      return;
    }
  }
  
  private void a(EmotionKeywordHorizonListView paramEmotionKeywordHorizonListView)
  {
    if (!QLog.isColorLevel()) {
      return;
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    boolean bool;
    label439:
    synchronized (jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      int j = jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("log apolloIceBreakShows list info count = ");
      ((StringBuilder)localObject2).append(j);
      ((StringBuilder)localObject2).append("\n");
      localStringBuilder1.append(((StringBuilder)localObject2).toString());
      int i = 0;
      for (;;)
      {
        bool = true;
        if (i >= j) {
          break;
        }
        localObject2 = (IApolloIceBreakShow)jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i);
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("log No.");
        localStringBuilder2.append(i);
        localStringBuilder2.append(" apolloIceBreakShow is invisible = ");
        if (((IApolloIceBreakShow)localObject2).getView().getVisibility() != 4) {
          break label439;
        }
        localStringBuilder2.append(bool);
        localStringBuilder2.append("\n");
        localStringBuilder1.append(localStringBuilder2.toString());
        i += 1;
      }
      if (paramEmotionKeywordHorizonListView == null)
      {
        QLog.d("ApolloStickerRec", 2, localStringBuilder1.toString());
        return;
      }
      i = paramEmotionKeywordHorizonListView.getFirstVisiblePosition();
      j = paramEmotionKeywordHorizonListView.getLastVisiblePosition();
      ??? = new StringBuilder();
      ((StringBuilder)???).append("log mEmotionKeywordList info startIndex = ");
      ((StringBuilder)???).append(i);
      ((StringBuilder)???).append(" | endIndex = ");
      ((StringBuilder)???).append(j);
      ((StringBuilder)???).append("\n");
      localStringBuilder1.append(((StringBuilder)???).toString());
      while (i <= j)
      {
        if (paramEmotionKeywordHorizonListView.getChildCount() > i)
        {
          ??? = paramEmotionKeywordHorizonListView.getChild(i);
          if ((??? != null) && (((View)???).getTag() != null) && ((((View)???).getTag() instanceof ApolloStickerRecView)))
          {
            ??? = (ApolloStickerRecView)((View)???).getTag();
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("log No.");
            ((StringBuilder)localObject2).append(i);
            ((StringBuilder)localObject2).append(" mEmotionKeywordList is invisible = ");
            if (((ApolloStickerRecView)???).a.getView().getVisibility() == 4) {
              bool = true;
            } else {
              bool = false;
            }
            ((StringBuilder)localObject2).append(bool);
            ((StringBuilder)localObject2).append("\n");
            localStringBuilder1.append(((StringBuilder)localObject2).toString());
          }
        }
        i += 1;
      }
      QLog.d("ApolloStickerRec", 2, localStringBuilder1.toString());
      return;
    }
  }
  
  public static void b()
  {
    synchronized (jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      if (jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() == 0) {
        return;
      }
      Iterator localIterator = jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (localIterator.hasNext()) {
        ((IApolloIceBreakShow)localIterator.next()).stop();
      }
      jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  private void b(IApolloIceBreakShow paramIApolloIceBreakShow)
  {
    synchronized (jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      if (jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramIApolloIceBreakShow)) {
        jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramIApolloIceBreakShow);
      }
      if (paramIApolloIceBreakShow.isReady()) {
        paramIApolloIceBreakShow.stop();
      }
      return;
    }
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloStickerRec", 2, "sendPic");
    }
    ApolloStickerRecView localApolloStickerRecView = this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedAdapterMvpApolloStickerRecView;
    if ((localApolloStickerRecView != null) && (localApolloStickerRecView.a != null))
    {
      if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseAIOContext != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedAdapterMvpApolloStickerRecView.a.onSend(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseAIOContext);
        return;
      }
      QLog.e("ApolloStickerRec", 1, "[sendApolloMsg] error, mBaseChatPie or mQQApp is null!");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloStickerRec", 2, "sendPic data is null");
    }
  }
  
  public IStickerModel a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedStickerRecData;
  }
  
  public void a(IStickerView paramIStickerView, IStickerModel paramIStickerModel)
  {
    if (!a(paramIStickerView))
    {
      QLog.e("ApolloStickerRec", 1, "binding view error!");
      return;
    }
    if (!a(paramIStickerModel))
    {
      QLog.e("ApolloStickerRec", 1, "binding model error!");
      this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedAdapterMvpApolloStickerRecView.a(false);
      b(this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedAdapterMvpApolloStickerRecView.a);
      return;
    }
    paramIStickerModel = this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedStickerRecData.e();
    if (QLog.isColorLevel())
    {
      paramIStickerView = new StringBuilder();
      paramIStickerView.append("updateApolloView cmsString = ");
      paramIStickerView.append(paramIStickerModel);
      if (paramIStickerView.toString() == null) {
        paramIStickerView = "null";
      } else {
        paramIStickerView = paramIStickerModel;
      }
      QLog.d("ApolloStickerRec", 2, paramIStickerView);
    }
    if (StringUtil.a(paramIStickerModel)) {
      return;
    }
    try
    {
      paramIStickerView = new JSONObject(paramIStickerModel);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedAdapterMvpApolloStickerRecView.a.setJson(paramIStickerView, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedAdapterMvpApolloStickerRecView.a(true);
      a(this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedAdapterMvpApolloStickerRecView.a);
      if (StickerRecManagerImpl.isStickerRecFromRemote(this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedIStickerRecEmoticon)) {
        ((StickerRecData)this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedIStickerRecEmoticon).a(true);
      }
      return;
    }
    catch (JSONException paramIStickerView)
    {
      paramIStickerView.printStackTrace();
    }
  }
  
  public boolean a()
  {
    a(null);
    d();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedIStickerRecEmoticon != null) && (StickerRecManagerImpl.isStickerRecFromRemote(this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedIStickerRecEmoticon))) {
      ((StickerRecData)this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedIStickerRecEmoticon).b(true);
    }
    return true;
  }
  
  public boolean a(IStickerModel paramIStickerModel)
  {
    super.a(paramIStickerModel);
    if ((paramIStickerModel instanceof StickerRecData))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedStickerRecData = ((StickerRecData)paramIStickerModel);
      return true;
    }
    return false;
  }
  
  public boolean a(IStickerView paramIStickerView)
  {
    super.a(paramIStickerView);
    if ((paramIStickerView instanceof ApolloStickerRecView))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedAdapterMvpApolloStickerRecView = ((ApolloStickerRecView)paramIStickerView);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.adapter.mvp.ApolloStickerRecPresenter
 * JD-Core Version:    0.7.0.1
 */