package com.tencent.mobileqq.apollo.script;

import actj;
import acup;
import adkr;
import adte;
import ajez;
import ajfh;
import ajfo;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import bbdh;
import bcql;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import com.tencent.widget.XListView;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class SpriteUIHandler
  implements ajfo
{
  private ajez jdField_a_of_type_Ajez;
  private SpriteUIHandler.SpriteVisibleRunnable jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteUIHandler$SpriteVisibleRunnable;
  private WeakReference<XListView> jdField_a_of_type_JavaLangRefWeakReference;
  private WeakReference<acup> b;
  
  public SpriteUIHandler(ajez paramajez)
  {
    this.jdField_a_of_type_Ajez = paramajez;
  }
  
  public static int a(Context paramContext)
  {
    int i = 0;
    if (paramContext != null) {
      i = actj.a(46.0F, paramContext.getResources());
    }
    return Math.max(i, (int)((float)bbdh.h() / 7.0F / 2.84D) + 40);
  }
  
  private void a(long paramLong, int paramInt)
  {
    Object localObject2 = a();
    if (localObject2 == null) {
      QLog.e("cmshow_scripted_SpriteUIHandler", 1, "adatper is null.");
    }
    label189:
    label204:
    label226:
    for (;;)
    {
      return;
      Object localObject1 = a();
      if (localObject1 != null)
      {
        int i = actj.a(paramLong, (ListAdapter)localObject2);
        if (i >= 0)
        {
          ChatMessage localChatMessage = (ChatMessage)((acup)localObject2).getItem(i);
          localObject2 = ((acup)localObject2).a.a(localChatMessage, (BaseAdapter)localObject2);
          ApolloItemBuilder localApolloItemBuilder;
          View localView;
          if (((localObject2 instanceof ApolloItemBuilder)) && ((localChatMessage instanceof MessageForApollo)))
          {
            localApolloItemBuilder = (ApolloItemBuilder)localObject2;
            i = actj.a(paramLong, ((XListView)localObject1).getAdapter());
            localView = actj.a((ListView)localObject1, i);
            if (!(localView instanceof BaseChatItemLayout)) {
              break label204;
            }
            localObject1 = (BaseChatItemLayout)actj.a((ListView)localObject1, i);
            if (paramInt != 1) {
              break label189;
            }
            localApolloItemBuilder.a((View)localObject1, (MessageForApollo)localChatMessage);
          }
          for (;;)
          {
            if ((!(localObject2 instanceof adkr)) || (!(localChatMessage instanceof MessageForApollo))) {
              break label226;
            }
            localObject1 = (adkr)localObject2;
            if (paramInt != 1) {
              break;
            }
            ((adkr)localObject1).a((MessageForApollo)localChatMessage);
            return;
            localApolloItemBuilder.b((View)localObject1, (MessageForApollo)localChatMessage);
            continue;
            if ((localView == null) && (paramInt == 1)) {
              localApolloItemBuilder.a(null, (MessageForApollo)localChatMessage);
            }
          }
        }
      }
    }
  }
  
  public acup a()
  {
    if (this.b == null) {
      return null;
    }
    return (acup)this.b.get();
  }
  
  public XListView a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
      return null;
    }
    return (XListView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  public void a(int paramInt)
  {
    ThreadManager.getUIHandler().post(new SpriteUIHandler.4(this, paramInt));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    ThreadManager.getUIHandler().post(new SpriteUIHandler.5(this, paramInt1, paramInt2));
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteUIHandler", 2, new Object[] { "[onActionDownloadNotify], downloadStatus:", Integer.valueOf(paramInt2), ",msgId:", Long.valueOf(paramLong) });
    }
    ThreadManager.getUIHandler().post(new SpriteUIHandler.1(this, paramLong, paramInt2, paramInt1));
  }
  
  public void a(SpriteTaskParam paramSpriteTaskParam, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteUIHandler", 2, new Object[] { "[onTaskStart], msgId:", Long.valueOf(paramLong) });
    }
    paramSpriteTaskParam = new SpriteUIHandler.2(this, paramLong);
    ThreadManager.getUIHandler().post(paramSpriteTaskParam);
  }
  
  public void a(SpriteTaskParam paramSpriteTaskParam, long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteUIHandler", 2, new Object[] { "[onTaskComplete], msgId:", Long.valueOf(paramLong), ",type:", Integer.valueOf(paramInt) });
    }
    paramSpriteTaskParam = new SpriteUIHandler.3(this, paramLong, paramInt);
    ThreadManager.getUIHandler().post(paramSpriteTaskParam);
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    if (!ajfh.b(paramQQAppInterface, paramInt, paramString))
    {
      QLog.i("cmshow_scripted_SpriteUIHandler", 1, "[onDoubleTap], condition NOT meet.");
      return;
    }
    if (this.jdField_a_of_type_Ajez.d == 1)
    {
      paramInt = 1;
      if (paramInt != 0) {
        break label178;
      }
      bool = true;
      label38:
      a(bool, true, null);
      if (QLog.isColorLevel()) {
        if (paramInt != 0) {
          break label184;
        }
      }
    }
    label178:
    label184:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("cmshow_scripted_SpriteUIHandler", 2, new Object[] { "isShow:", Boolean.valueOf(bool) });
      if (paramInt != 0) {
        break label190;
      }
      bcql.a(BaseApplicationImpl.getContext(), BaseApplicationImpl.getContext().getResources().getString(2131690093), 1).a();
      VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "aio_double_disappear_clk", this.jdField_a_of_type_Ajez.jdField_a_of_type_JavaLangString, 0, 0, new String[] { Integer.toString(ApolloUtil.b(this.jdField_a_of_type_Ajez.jdField_a_of_type_Int)), "", "", String.valueOf(System.currentTimeMillis() / 1000L) });
      return;
      paramInt = 0;
      break;
      bool = false;
      break label38;
    }
    label190:
    VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "aio_double_show_clk", 0, 0, new String[] { Integer.toString(ApolloUtil.b(this.jdField_a_of_type_Ajez.jdField_a_of_type_Int)), "0" });
  }
  
  public void a(XListView paramXListView, acup paramacup)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramXListView);
    this.b = new WeakReference(paramacup);
  }
  
  public void a(String paramString)
  {
    ThreadManager.getUIHandler().post(new SpriteUIHandler.6(this, paramString));
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteUIHandler$SpriteVisibleRunnable != null) {
      ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteUIHandler$SpriteVisibleRunnable);
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteUIHandler$SpriteVisibleRunnable = new SpriteUIHandler.SpriteVisibleRunnable(this.jdField_a_of_type_Ajez, paramBoolean1, paramBoolean2, paramString);
    ThreadManager.getSubThreadHandler().post(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteUIHandler$SpriteVisibleRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteUIHandler
 * JD-Core Version:    0.7.0.1
 */