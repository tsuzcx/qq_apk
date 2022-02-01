package com.tencent.mobileqq.apollo.script;

import afqz;
import agnf;
import agvm;
import ancc;
import anck;
import ancr;
import android.content.Context;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import anhm;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import com.tencent.widget.XListView;
import common.config.service.QzoneConfig;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class SpriteUIHandler
  implements ancr
{
  private ancc jdField_a_of_type_Ancc;
  private SpriteUIHandler.SpriteVisibleRunnable jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteUIHandler$SpriteVisibleRunnable;
  private WeakReference<XListView> jdField_a_of_type_JavaLangRefWeakReference;
  private WeakReference<afqz> b;
  
  public SpriteUIHandler(ancc paramancc)
  {
    this.jdField_a_of_type_Ancc = paramancc;
  }
  
  public static int a(Context paramContext)
  {
    int i = 0;
    if (paramContext != null) {
      i = AIOUtils.dp2px(46.0F, paramContext.getResources());
    }
    return Math.max(i, (int)((float)DeviceInfoUtil.getDispalyHeight() / 7.0F / 2.84D) + 40);
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
        int i = AIOUtils.findMessagePosition(paramLong, (ListAdapter)localObject2);
        if (i >= 0)
        {
          ChatMessage localChatMessage = (ChatMessage)((afqz)localObject2).getItem(i);
          localObject2 = ((afqz)localObject2).a.a(localChatMessage, (BaseAdapter)localObject2);
          ApolloItemBuilder localApolloItemBuilder;
          View localView;
          if (((localObject2 instanceof ApolloItemBuilder)) && ((localChatMessage instanceof MessageForApollo)))
          {
            localApolloItemBuilder = (ApolloItemBuilder)localObject2;
            i = AIOUtils.findMessagePosition(paramLong, ((XListView)localObject1).getAdapter());
            localView = AIOUtils.getViewByPostion((ListView)localObject1, i);
            if (!(localView instanceof BaseChatItemLayout)) {
              break label204;
            }
            localObject1 = (BaseChatItemLayout)AIOUtils.getViewByPostion((ListView)localObject1, i);
            if (paramInt != 1) {
              break label189;
            }
            localApolloItemBuilder.a((View)localObject1, (MessageForApollo)localChatMessage);
          }
          for (;;)
          {
            if ((!(localObject2 instanceof agnf)) || (!(localChatMessage instanceof MessageForApollo))) {
              break label226;
            }
            localObject1 = (agnf)localObject2;
            if (paramInt != 1) {
              break;
            }
            ((agnf)localObject1).a((MessageForApollo)localChatMessage);
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
  
  public afqz a()
  {
    if (this.b == null) {
      return null;
    }
    return (afqz)this.b.get();
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
    if (!anck.b(paramQQAppInterface, paramInt, paramString))
    {
      QLog.i("cmshow_scripted_SpriteUIHandler", 1, "[onDoubleTap], condition NOT meet.");
      return;
    }
    if (anhm.a(paramQQAppInterface.getCurrentUin(), paramQQAppInterface) == 0)
    {
      QLog.i("cmshow_scripted_SpriteUIHandler", 1, "[onDoubleTap] sava onDoubleTap user is init status return");
      return;
    }
    if (this.jdField_a_of_type_Ancc.d == 1)
    {
      paramInt = 1;
      if (paramInt != 0) {
        break label201;
      }
      bool = true;
      label58:
      a(bool, true, null);
      if (QLog.isColorLevel()) {
        if (paramInt != 0) {
          break label207;
        }
      }
    }
    label201:
    label207:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("cmshow_scripted_SpriteUIHandler", 2, new Object[] { "isShow:", Boolean.valueOf(bool) });
      if (paramInt != 0) {
        break label213;
      }
      QQToast.a(BaseApplicationImpl.getContext(), BaseApplicationImpl.getContext().getResources().getString(2131690079), 1).a();
      VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "aio_double_disappear_clk", this.jdField_a_of_type_Ancc.jdField_a_of_type_JavaLangString, 0, 0, new String[] { Integer.toString(ApolloUtil.b(this.jdField_a_of_type_Ancc.jdField_a_of_type_Int)), "", "", String.valueOf(System.currentTimeMillis() / 1000L) });
      return;
      paramInt = 0;
      break;
      bool = false;
      break label58;
    }
    label213:
    VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "aio_double_show_clk", 0, 0, new String[] { Integer.toString(ApolloUtil.b(this.jdField_a_of_type_Ancc.jdField_a_of_type_Int)), "0" });
  }
  
  public void a(XListView paramXListView, afqz paramafqz)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramXListView);
    this.b = new WeakReference(paramafqz);
  }
  
  public void a(String paramString)
  {
    ThreadManager.getUIHandler().post(new SpriteUIHandler.7(this, paramString));
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (!"none_apollo_play_action".equals(paramString)) {
      return;
    }
    QLog.d("cmshow_scripted_SpriteUIHandler", 1, new Object[] { "showOrHideSurfaceView isHide:", Boolean.valueOf(paramBoolean) });
    paramString = this.jdField_a_of_type_Ancc.a();
    ThreadManager.getUIHandler().post(new SpriteUIHandler.6(this, paramString, paramBoolean));
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteUIHandler$SpriteVisibleRunnable != null) {
      ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteUIHandler$SpriteVisibleRunnable);
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteUIHandler$SpriteVisibleRunnable = new SpriteUIHandler.SpriteVisibleRunnable(this.jdField_a_of_type_Ancc, paramBoolean1, paramBoolean2, paramString);
    ThreadManager.getSubThreadHandler().post(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteUIHandler$SpriteVisibleRunnable);
  }
  
  public boolean a(MotionEvent paramMotionEvent, RelativeLayout paramRelativeLayout)
  {
    int i;
    float f3;
    float f1;
    if (this.jdField_a_of_type_Ancc.d == 1)
    {
      i = 0;
      f3 = paramMotionEvent.getY();
      f1 = 0.0F;
      if (paramRelativeLayout != null) {
        f1 = paramRelativeLayout.getHeight();
      }
      if (i == 0) {
        break label74;
      }
    }
    label74:
    for (float f2 = QzoneConfig.getInstance().getConfig("CMShow", "AioCMShowDisappearHeight", 0.3F);; f2 = QzoneConfig.getInstance().getConfig("CMShow", "AioCMShowDisplayHeight", 0.3F))
    {
      if (f3 < (1.0F - f2) * f1) {
        break label94;
      }
      return true;
      i = 1;
      break;
    }
    label94:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteUIHandler
 * JD-Core Version:    0.7.0.1
 */