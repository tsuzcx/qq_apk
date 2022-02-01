package com.tencent.mobileqq.activity.aio.stickerrecommended.adapter;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseAIOContext;
import com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecData;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecDataUtils;
import com.tencent.mobileqq.activity.aio.stickerrecommended.adapter.mvp.ApolloStickerRecPresenter;
import com.tencent.mobileqq.activity.aio.stickerrecommended.adapter.mvp.ApolloStickerRecView;
import com.tencent.mobileqq.activity.aio.stickerrecommended.adapter.mvp.CommonStickerRecPresenter;
import com.tencent.mobileqq.activity.aio.stickerrecommended.adapter.mvp.CommonStickerRecView;
import com.tencent.mobileqq.activity.aio.stickerrecommended.adapter.mvp.IStickerMvpDirector;
import com.tencent.mobileqq.activity.aio.stickerrecommended.adapter.mvp.IStickerPresenter;
import com.tencent.mobileqq.activity.aio.stickerrecommended.adapter.mvp.IStickerView;
import com.tencent.mobileqq.activity.aio.stickerrecommended.impl.StickerRecManagerImpl;
import com.tencent.mobileqq.activity.aio.stickerrecommended.mvvm.StickerRecViewModel;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.emoticonview.EmotionKeywordHorizonListView;
import com.tencent.mobileqq.emoticonview.api.IRecommendEmotionService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class StickerRecBarAdapter
  extends BaseAdapter
  implements IStickerMvpDirector
{
  public static final int a;
  public static final int b;
  public static final int c;
  private static int d;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private BaseSessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo;
  private BaseAIOContext jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseAIOContext;
  private StickerDrawableDownloader jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedAdapterStickerDrawableDownloader;
  private StickerRecManagerImpl jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedImplStickerRecManagerImpl;
  private StickerRecViewModel jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedMvvmStickerRecViewModel;
  private QBaseActivity jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
  private EmotionKeywordHorizonListView jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordHorizonListView;
  private String jdField_a_of_type_JavaLangString;
  private List<IStickerRecEmoticon> jdField_a_of_type_JavaUtilList;
  private String b;
  private String c;
  private int e = 0;
  
  static
  {
    int i = d;
    d = i + 1;
    jdField_a_of_type_Int = i;
    i = d;
    d = i + 1;
    jdField_b_of_type_Int = i;
    jdField_c_of_type_Int = d;
  }
  
  public StickerRecBarAdapter(QBaseActivity paramQBaseActivity, AppInterface paramAppInterface, BaseAIOContext paramBaseAIOContext, ViewGroup paramViewGroup, EditText paramEditText, EmotionKeywordHorizonListView paramEmotionKeywordHorizonListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity = paramQBaseActivity;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseAIOContext = paramBaseAIOContext;
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo = paramBaseAIOContext.a();
    this.jdField_a_of_type_AndroidWidgetEditText = paramEditText;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedImplStickerRecManagerImpl = StickerRecManagerImpl.get(paramAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordHorizonListView = paramEmotionKeywordHorizonListView;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedAdapterStickerDrawableDownloader = new StickerDrawableDownloader();
  }
  
  public IStickerRecEmoticon a(int paramInt)
  {
    if (paramInt >= this.jdField_a_of_type_JavaUtilList.size())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("get view position exception , position = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",size = ");
      localStringBuilder.append(this.jdField_a_of_type_JavaUtilList.size());
      QLog.e("StickerRecBarAdapter", 2, localStringBuilder.toString());
      return null;
    }
    return (IStickerRecEmoticon)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public IStickerPresenter a(int paramInt)
  {
    if (paramInt == jdField_a_of_type_Int) {
      return new CommonStickerRecPresenter(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseAIOContext, this.jdField_a_of_type_AndroidWidgetEditText);
    }
    if (paramInt == jdField_b_of_type_Int) {
      return new ApolloStickerRecPresenter(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseAIOContext, this.jdField_a_of_type_AndroidWidgetEditText);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("error presenter type:");
    localStringBuilder.append(paramInt);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public IStickerView a(int paramInt, IStickerPresenter paramIStickerPresenter)
  {
    if (paramInt == jdField_a_of_type_Int) {
      return new CommonStickerRecView(paramIStickerPresenter, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseAIOContext, this.jdField_a_of_type_AndroidViewViewGroup, this.jdField_a_of_type_AndroidWidgetEditText);
    }
    if (paramInt == jdField_b_of_type_Int) {
      return new ApolloStickerRecView(paramIStickerPresenter, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseAIOContext, this.jdField_a_of_type_AndroidViewViewGroup, this.jdField_a_of_type_AndroidWidgetEditText, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    }
    return null;
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 149	com/tencent/mobileqq/activity/aio/stickerrecommended/adapter/StickerRecBarAdapter:b	()V
    //   4: invokestatic 152	com/tencent/mobileqq/activity/aio/stickerrecommended/adapter/mvp/CommonStickerRecPresenter:a	()Ljava/util/List;
    //   7: astore_1
    //   8: invokestatic 158	com/tencent/mobileqq/app/ThreadManager:getFileThreadHandler	()Lmqq/os/MqqHandler;
    //   11: new 160	com/tencent/mobileqq/activity/aio/stickerrecommended/adapter/StickerRecBarAdapter$2
    //   14: dup
    //   15: aload_0
    //   16: aload_1
    //   17: invokespecial 163	com/tencent/mobileqq/activity/aio/stickerrecommended/adapter/StickerRecBarAdapter$2:<init>	(Lcom/tencent/mobileqq/activity/aio/stickerrecommended/adapter/StickerRecBarAdapter;Ljava/util/List;)V
    //   20: invokevirtual 169	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   23: pop
    //   24: goto +17 -> 41
    //   27: astore_1
    //   28: goto +18 -> 46
    //   31: astore_1
    //   32: ldc 104
    //   34: iconst_1
    //   35: ldc 171
    //   37: aload_1
    //   38: invokestatic 174	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   41: aload_0
    //   42: invokevirtual 176	com/tencent/mobileqq/activity/aio/stickerrecommended/adapter/StickerRecBarAdapter:c	()V
    //   45: return
    //   46: aload_0
    //   47: invokevirtual 176	com/tencent/mobileqq/activity/aio/stickerrecommended/adapter/StickerRecBarAdapter:c	()V
    //   50: aload_1
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	StickerRecBarAdapter
    //   7	10	1	localList	List
    //   27	1	1	localObject	Object
    //   31	20	1	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   0	24	27	finally
    //   32	41	27	finally
    //   0	24	31	java/lang/Throwable
  }
  
  public void a(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void a(StickerRecViewModel paramStickerRecViewModel)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedMvvmStickerRecViewModel = paramStickerRecViewModel;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(List<IStickerRecEmoticon> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedMvvmStickerRecViewModel.b(false);
      QLog.e("StickerRecBarAdapter", 1, "setData");
      c();
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordHorizonListView.resetCurrentX(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedAdapterStickerDrawableDownloader.a(new StickerRecBarAdapter.1(this));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedAdapterStickerDrawableDownloader.a(this.jdField_a_of_type_JavaUtilList);
      notifyDataSetChanged();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setData:");
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          IStickerRecEmoticon localIStickerRecEmoticon = (IStickerRecEmoticon)paramList.next();
          if ((localIStickerRecEmoticon != null) && (StickerRecManagerImpl.isStickerRecFromRemote(localIStickerRecEmoticon)))
          {
            localStringBuilder.append("thumb=");
            localStringBuilder.append(((StickerRecData)localIStickerRecEmoticon).b());
            localStringBuilder.append(",");
          }
        }
        QLog.d("StickerRecBarAdapter", 2, localStringBuilder.toString());
      }
      return;
    }
    QLog.e("StickerRecBarAdapter", 1, "setData data is null or empty");
  }
  
  public boolean a(boolean paramBoolean)
  {
    boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedMvvmStickerRecViewModel.b();
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    Object localObject;
    if (this.e != 1)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedImplStickerRecManagerImpl.preProcessUsrText(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
      String str = ((IRecommendEmotionService)QRoute.api(IRecommendEmotionService.class)).getSpecKeyWord(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseAIOContext);
      if (!TextUtils.isEmpty(str)) {
        localObject = str;
      }
      if ((paramBoolean) && (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase((String)localObject))) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
    }
    if (paramBoolean)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseAIOContext.a();
      if (localObject != null) {
        ((MqqHandler)localObject).sendMessage(((MqqHandler)localObject).obtainMessage(69, this.jdField_c_of_type_JavaLangString));
      }
      bool1 = true;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showEmotionKeywordLayout isshow = ");
      ((StringBuilder)localObject).append(bool1);
      QLog.d("StickerRecBarAdapter", 2, ((StringBuilder)localObject).toString());
    }
    return bool1;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() > 0) {
      StickerRecManagerImpl.get(this.jdField_a_of_type_ComTencentCommonAppAppInterface).collectReportData(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.e);
    }
  }
  
  public void b(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
  }
  
  public void c()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    CommonStickerRecPresenter.c();
    ApolloStickerRecPresenter.a();
  }
  
  public void c(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public int getCount()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (StickerRecDataUtils.a(a(paramInt))) {
      return jdField_b_of_type_Int;
    }
    return jdField_a_of_type_Int;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    Object localObject2;
    if (paramInt >= this.jdField_a_of_type_JavaUtilList.size())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("get view position exception , position = ");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(",size = ");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaUtilList.size());
      QLog.e("StickerRecBarAdapter", 2, ((StringBuilder)localObject1).toString());
      localObject1 = null;
      localObject2 = paramView;
    }
    else
    {
      IStickerRecEmoticon localIStickerRecEmoticon = (IStickerRecEmoticon)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      StringBuilder localStringBuilder;
      if (paramView == null)
      {
        paramView = new StringBuilder();
        paramView.append("convertView is null, position:");
        paramView.append(paramInt);
        paramView.append(", model:");
        paramView.append(localIStickerRecEmoticon);
        QLog.d("StickerRecBarAdapter", 1, paramView.toString());
        localObject2 = a(getItemViewType(paramInt));
        localObject1 = a(getItemViewType(paramInt), (IStickerPresenter)localObject2);
        paramView = ((IStickerView)localObject1).a();
        paramView.setTag(localObject1);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("convertView is null, view:");
        localStringBuilder.append(localObject1);
        localStringBuilder.append(", presenter:");
        localStringBuilder.append(localObject2);
        QLog.d("StickerRecBarAdapter", 1, localStringBuilder.toString());
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("convertView exist, position:");
        ((StringBuilder)localObject1).append(paramInt);
        ((StringBuilder)localObject1).append(", model:");
        ((StringBuilder)localObject1).append(localIStickerRecEmoticon);
        QLog.d("StickerRecBarAdapter", 1, ((StringBuilder)localObject1).toString());
        localObject1 = (IStickerView)paramView.getTag();
        localObject2 = ((IStickerView)localObject1).a();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("convertView exist, view:");
        localStringBuilder.append(localObject1);
        localStringBuilder.append(", presenter:");
        localStringBuilder.append(localObject2);
        QLog.d("StickerRecBarAdapter", 1, localStringBuilder.toString());
      }
      ((IStickerPresenter)localObject2).a(this.jdField_a_of_type_JavaLangString, this.e);
      ((IStickerPresenter)localObject2).a((IStickerView)localObject1, localIStickerRecEmoticon);
      localObject2 = paramView;
      localObject1 = paramView;
    }
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject2, paramViewGroup, getItemId(paramInt));
    return localObject1;
  }
  
  public int getViewTypeCount()
  {
    return jdField_c_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.adapter.StickerRecBarAdapter
 * JD-Core Version:    0.7.0.1
 */