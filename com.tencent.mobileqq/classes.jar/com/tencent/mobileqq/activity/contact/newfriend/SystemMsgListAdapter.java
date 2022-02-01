package com.tencent.mobileqq.activity.contact.newfriend;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.contact.connections.ConnectionsTabInfo;
import com.tencent.mobileqq.activity.contact.connections.TabLayoutStatus;
import com.tencent.mobileqq.activity.contact.newfriend.msg.ContactBindedMessage;
import com.tencent.mobileqq.activity.contact.newfriend.msg.ContactMatchMessage;
import com.tencent.mobileqq.activity.contact.newfriend.msg.FriendSystemMessage;
import com.tencent.mobileqq.activity.contact.newfriend.msg.MayKnowBannerMessage;
import com.tencent.mobileqq.activity.contact.newfriend.msg.NewFriendBindContactGuideMsg;
import com.tencent.mobileqq.activity.contact.newfriend.msg.NewFriendBindContactGuideMsgV2;
import com.tencent.mobileqq.activity.contact.newfriend.msg.NewFriendMessage;
import com.tencent.mobileqq.activity.contact.newfriend.msg.NewFriendMoreInfoMessage;
import com.tencent.mobileqq.activity.contact.newfriend.msg.NewFriendSlideTabMessage;
import com.tencent.mobileqq.activity.contact.newfriend.msg.NewFriendSubTitleMessage;
import com.tencent.mobileqq.activity.contact.newfriend.msg.NewFriendSysEmptyMessage;
import com.tencent.mobileqq.activity.contact.newfriend.msg.NewFriendTabEmptyMessage;
import com.tencent.mobileqq.activity.contact.newfriend.msg.NewFriendTabGuideMessage;
import com.tencent.mobileqq.activity.contact.newfriend.msg.NewFriendVerifyBlockedMsg;
import com.tencent.mobileqq.activity.contact.newfriend.msg.PhoneContactAddMessage;
import com.tencent.mobileqq.activity.contact.newfriend.msg.QIMFollowMessage;
import com.tencent.mobileqq.activity.contact.newfriend.msg.QIMNotifyAddFriendMsg;
import com.tencent.mobileqq.activity.contact.newfriend.poke.NewFriendNotifyPokeMsgHelper;
import com.tencent.mobileqq.activity.contacts.mayknow.ContactReportUtils;
import com.tencent.mobileqq.activity.contacts.topentry.CTEntryMng;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.FlingHandler;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.richstatus.IIconListener;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SwipListView.SwipListListener;
import com.tencent.widget.XBaseAdapter;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class SystemMsgListAdapter
  extends XBaseAdapter
  implements Handler.Callback, NewFriendManager.INewFriendListener, DecodeTaskCompletionListener, IIconListener, SwipListView.SwipListListener
{
  public int a;
  private Context jdField_a_of_type_AndroidContentContext;
  Handler jdField_a_of_type_AndroidOsHandler = null;
  private TabLayoutStatus jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsTabLayoutStatus = new TabLayoutStatus();
  private ContactBindedBuilder jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendContactBindedBuilder;
  private NewFriendManager jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendManager;
  public SystemMsgListView a;
  private FlingHandler jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  private StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  public XListView a;
  protected Runnable a;
  private Hashtable<String, Bitmap> jdField_a_of_type_JavaUtilHashtable = new Hashtable();
  private List<NewFriendBaseBuilder> jdField_a_of_type_JavaUtilList = new ArrayList();
  private ConcurrentLinkedQueue<Long> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  private boolean jdField_a_of_type_Boolean = true;
  private int b;
  
  public SystemMsgListAdapter(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, SystemMsgListView paramSystemMsgListView, int paramInt, FlingHandler paramFlingHandler)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangRunnable = new SystemMsgListAdapter.2(this);
    this.b = paramInt;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView = paramSystemMsgListView;
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)paramQQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendManager = ((NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEW_FRIEND_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.STATUS_MANAGER));
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendManager.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler = paramFlingHandler;
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendManager.a(0);
  }
  
  private NewFriendBaseBuilder a(NewFriendMessage paramNewFriendMessage, int paramInt)
  {
    Object localObject = null;
    if ((paramNewFriendMessage instanceof ContactMatchMessage)) {
      localObject = new ContactMatchBuilder(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, paramNewFriendMessage);
    }
    do
    {
      NewFriendSlideTabBuilder localNewFriendSlideTabBuilder;
      Handler localHandler;
      do
      {
        do
        {
          return localObject;
          if ((paramNewFriendMessage instanceof ContactBindedMessage))
          {
            if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendContactBindedBuilder == null)
            {
              paramNewFriendMessage = new ContactBindedBuilder(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, paramNewFriendMessage);
              this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendContactBindedBuilder = ((ContactBindedBuilder)paramNewFriendMessage);
              return paramNewFriendMessage;
            }
            localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendContactBindedBuilder;
            ((NewFriendBaseBuilder)localObject).a(paramNewFriendMessage);
            return localObject;
          }
          if (!(paramNewFriendMessage instanceof FriendSystemMessage)) {
            break;
          }
          paramNewFriendMessage = new SystemMsgItemBuilder(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, paramNewFriendMessage);
          localObject = paramNewFriendMessage;
        } while (((SystemMsgItemBuilder)paramNewFriendMessage).a == 0L);
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(Long.valueOf(((SystemMsgItemBuilder)paramNewFriendMessage).a));
        return paramNewFriendMessage;
        if ((paramNewFriendMessage instanceof NewFriendSubTitleMessage)) {
          return new NewFriendSubTitleBuilder(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, paramNewFriendMessage);
        }
        if ((paramNewFriendMessage instanceof NewFriendMoreInfoMessage)) {
          return new NewFriendMoreInfoBuilder(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, paramNewFriendMessage);
        }
        if ((paramNewFriendMessage instanceof NewFriendBindContactGuideMsg)) {
          return new NewFriendBindContactGuideBuilder(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, paramNewFriendMessage);
        }
        if ((paramNewFriendMessage instanceof NewFriendBindContactGuideMsgV2)) {
          return new NewFriendBindContactGuideBuilderV2(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, paramNewFriendMessage);
        }
        if ((paramNewFriendMessage instanceof PhoneContactAddMessage)) {
          return new PhoneContactAddBuilder(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, paramNewFriendMessage);
        }
        if ((paramNewFriendMessage instanceof QIMFollowMessage)) {
          return new QIMFollowerAddBuilder(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, paramNewFriendMessage);
        }
        if ((paramNewFriendMessage instanceof QIMNotifyAddFriendMsg)) {
          return new QIMNotifyAddFriendBuilder(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, paramNewFriendMessage);
        }
        if ((paramNewFriendMessage instanceof NewFriendVerifyBlockedMsg)) {
          return new NewFriendVerifyBlockedBuilder(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, paramNewFriendMessage);
        }
        if ((paramNewFriendMessage instanceof NewFriendSysEmptyMessage)) {
          return new NewFriendSysEmptyBuilder(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, paramNewFriendMessage);
        }
        if ((paramNewFriendMessage instanceof NewFriendTabEmptyMessage))
        {
          paramNewFriendMessage = new NewFriendTabEmptyBuilder(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, paramNewFriendMessage);
          boolean bool = b(paramInt);
          ((NewFriendTabEmptyBuilder)paramNewFriendMessage).a(bool);
          return paramNewFriendMessage;
        }
        if ((paramNewFriendMessage instanceof MayKnowBannerMessage)) {
          return new NewFriendFillAcademicInfoBuilder(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, paramNewFriendMessage);
        }
        if (!(paramNewFriendMessage instanceof NewFriendSlideTabMessage)) {
          break;
        }
        localNewFriendSlideTabBuilder = new NewFriendSlideTabBuilder(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, paramNewFriendMessage);
        localHandler = this.jdField_a_of_type_AndroidOsHandler;
        localObject = localNewFriendSlideTabBuilder;
      } while (localHandler == null);
      localHandler.removeMessages(3);
      localHandler.sendMessage(localHandler.obtainMessage(3, paramNewFriendMessage));
      return localNewFriendSlideTabBuilder;
    } while (!(paramNewFriendMessage instanceof NewFriendTabGuideMessage));
    return new NewFriendTabGuideBuilder(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, paramNewFriendMessage);
  }
  
  private void a(ContactBindedBuilder.ContactBindedHolder paramContactBindedHolder)
  {
    Bitmap localBitmap;
    if ((paramContactBindedHolder.jdField_a_of_type_JavaLangString != null) && (paramContactBindedHolder.jdField_a_of_type_JavaLangString.length() > 0))
    {
      localBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilHashtable.get(paramContactBindedHolder.jdField_a_of_type_JavaLangString);
      if (localBitmap != null) {
        paramContactBindedHolder.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
      }
    }
    if ((paramContactBindedHolder.jdField_b_of_type_JavaLangString != null) && (paramContactBindedHolder.jdField_b_of_type_JavaLangString.length() > 0))
    {
      localBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilHashtable.get(paramContactBindedHolder.jdField_b_of_type_JavaLangString);
      if (localBitmap != null) {
        paramContactBindedHolder.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
      }
    }
    if ((paramContactBindedHolder.jdField_c_of_type_JavaLangString != null) && (paramContactBindedHolder.jdField_c_of_type_JavaLangString.length() > 0))
    {
      localBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilHashtable.get(paramContactBindedHolder.jdField_c_of_type_JavaLangString);
      if (localBitmap != null) {
        paramContactBindedHolder.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
      }
    }
    if ((paramContactBindedHolder.jdField_d_of_type_JavaLangString != null) && (paramContactBindedHolder.jdField_d_of_type_JavaLangString.length() > 0))
    {
      localBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilHashtable.get(paramContactBindedHolder.jdField_d_of_type_JavaLangString);
      if (localBitmap != null) {
        paramContactBindedHolder.jdField_d_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
      }
    }
    if ((paramContactBindedHolder.jdField_e_of_type_JavaLangString != null) && (paramContactBindedHolder.jdField_e_of_type_JavaLangString.length() > 0))
    {
      localBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilHashtable.get(paramContactBindedHolder.jdField_e_of_type_JavaLangString);
      if (localBitmap != null) {
        paramContactBindedHolder.jdField_e_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
      }
    }
  }
  
  private void a(NewFriendSlideTabMessage paramNewFriendSlideTabMessage)
  {
    if ((paramNewFriendSlideTabMessage == null) || (paramNewFriendSlideTabMessage.a == null) || (paramNewFriendSlideTabMessage.a.size() == 0)) {
      if (QLog.isColorLevel()) {
        QLog.e("SystemMsgListAdapter", 2, "refreshHead null");
      }
    }
    do
    {
      return;
      paramNewFriendSlideTabMessage = paramNewFriendSlideTabMessage.a;
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView == null);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView.a(paramNewFriendSlideTabMessage, b());
  }
  
  private void b(int paramInt)
  {
    ThreadManager.postImmediately(new SystemMsgListAdapter.1(this, paramInt), null, true);
  }
  
  private boolean b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView != null) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView.a(paramInt);
    }
    return false;
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    if (!a())
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsTabLayoutStatus.c();
      c();
    }
    MayknowRecommendManager localMayknowRecommendManager;
    Bundle localBundle;
    if ((NetworkUtil.d(this.jdField_a_of_type_AndroidContentContext)) && (a(paramInt2)))
    {
      localMayknowRecommendManager = (MayknowRecommendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
      localBundle = new Bundle();
      localBundle.putString("from", "3");
      if (paramInt1 > 0) {
        break label98;
      }
      localBundle.putInt("load_biz_type", 1);
      localMayknowRecommendManager.a(4, this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsTabLayoutStatus.jdField_a_of_type_Int, localBundle);
    }
    label98:
    while (paramInt1 >= 5) {
      return;
    }
    localBundle.putInt("load_biz_type", 3);
    localMayknowRecommendManager.b(4, this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsTabLayoutStatus.jdField_a_of_type_Int, localBundle);
  }
  
  public int a()
  {
    int i = this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition();
    if (i == 0) {
      return 0;
    }
    return i - 1;
  }
  
  public Bitmap a(int paramInt, String paramString)
  {
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(paramInt, paramString);
    if (localBitmap != null) {
      return localBitmap;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing()) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace(paramString, paramInt, true, (byte)0);
    }
    return ImageUtil.c();
  }
  
  public TabLayoutStatus a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsTabLayoutStatus;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsTabLayoutStatus != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsTabLayoutStatus.b = paramInt2;
      this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsTabLayoutStatus.jdField_a_of_type_Int = paramInt1;
    }
  }
  
  public void a(long paramLong)
  {
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null)
    {
      localHandler.removeMessages(1);
      localHandler.sendEmptyMessageDelayed(1, paramLong);
    }
  }
  
  public void a(NewFriendBaseBuilder paramNewFriendBaseBuilder)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
      this.jdField_a_of_type_JavaUtilList.remove(paramNewFriendBaseBuilder);
    }
  }
  
  public void a(SystemMsgItemBuilder.SystemMsgItemHolder paramSystemMsgItemHolder)
  {
    if ((paramSystemMsgItemHolder == null) || (paramSystemMsgItemHolder.jdField_f_of_type_AndroidWidgetImageView == null)) {
      return;
    }
    int i = paramSystemMsgItemHolder.a.msg.src_id.get();
    Object localObject1;
    if ((i == 3007) || (i == 3019) || (i == 2007) || (i == 4007) || (i == 2019))
    {
      localObject1 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if ((localObject1 != null) && (((FriendsManager)localObject1).b(String.valueOf(paramSystemMsgItemHolder.a.req_uin.get())))) {
        i = 0;
      }
    }
    for (;;)
    {
      Object localObject2;
      if (i != 0)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(32, String.valueOf(paramSystemMsgItemHolder.a.req_uin.get()), 200);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = localObject2;
          if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing())
          {
            this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeStrangeFace(String.valueOf(paramSystemMsgItemHolder.a.req_uin.get()), 200, true, true);
            localObject1 = localObject2;
          }
        }
      }
      for (;;)
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = ImageUtil.c();
        }
        paramSystemMsgItemHolder.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject2);
        return;
        i = 1;
        break;
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(1, String.valueOf(paramSystemMsgItemHolder.a.req_uin.get()));
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = localObject2;
          if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing())
          {
            this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace(String.valueOf(paramSystemMsgItemHolder.a.req_uin.get()), 1, true);
            localObject1 = localObject2;
          }
        }
      }
      i = 0;
    }
  }
  
  public boolean a()
  {
    int i = b();
    Iterator localIterator = ((MayknowRecommendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER)).a().iterator();
    while (localIterator.hasNext()) {
      if (((ConnectionsTabInfo)localIterator.next()).jdField_a_of_type_Int == i) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(int paramInt)
  {
    boolean bool = ((CTEntryMng)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CTENTRY_MNG)).c();
    if (paramInt == 23) {}
    for (paramInt = 1; (paramInt != 0) || (!bool); paramInt = 0) {
      return true;
    }
    return false;
  }
  
  public void ae_()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SystemMsgListAdapter", 2, "onMayKnowStatesChanged");
    }
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null)
    {
      localHandler.removeMessages(2);
      localHandler.sendEmptyMessageDelayed(2, 200L);
      localHandler.removeMessages(1);
      localHandler.sendEmptyMessageDelayed(1, 2000L);
    }
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsTabLayoutStatus != null) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsTabLayoutStatus.jdField_a_of_type_Int;
    }
    return -1;
  }
  
  public void b()
  {
    c();
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SystemMsgListAdapter", 2, "onConnectionTabSelected tabId : " + paramInt1 + ", position =" + paramInt2);
    }
    a(paramInt1, paramInt2);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView.setStickHeadSelection(paramInt2);
    }
    a(0L);
  }
  
  public void b(long paramLong)
  {
    if (paramLong == 0L) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size() > 0)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
      Long localLong;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localLong = (Long)localIterator.next();
      } while ((localLong == null) || (localLong.longValue() != paramLong));
    }
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        c();
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("addFriendTag", 2, String.format(Locale.getDefault(), "checkIfNeedUpdate discussUin: %d needRefresh: %b", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(bool) }));
      return;
    }
  }
  
  public int c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsTabLayoutStatus != null) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsTabLayoutStatus.b;
    }
    return -1;
  }
  
  public void c()
  {
    a(400L);
  }
  
  public void d()
  {
    int j = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
    int i = 0;
    if (i < j)
    {
      Object localObject = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(i).getTag();
      if ((localObject instanceof SystemMsgItemBuilder.SystemMsgItemHolder)) {
        a((SystemMsgItemBuilder.SystemMsgItemHolder)localObject);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((localObject instanceof ContactMatchBuilder.ContactMatchHolder))
        {
          localObject = (ContactMatchBuilder.ContactMatchHolder)localObject;
          ((ContactMatchBuilder.ContactMatchHolder)localObject).jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(a(11, ((ContactMatchBuilder.ContactMatchHolder)localObject).jdField_f_of_type_JavaLangString));
        }
        else if ((localObject instanceof MayKnowRecommendBuilder.MayKnowRecommendHolder))
        {
          localObject = (MayKnowRecommendBuilder.MayKnowRecommendHolder)localObject;
          ((MayKnowRecommendBuilder.MayKnowRecommendHolder)localObject).jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(a(1, ((MayKnowRecommendBuilder.MayKnowRecommendHolder)localObject).jdField_f_of_type_JavaLangString));
        }
        else if ((localObject instanceof PhoneContactAddBuilder.PhoneContactAddHolder))
        {
          localObject = (PhoneContactAddBuilder.PhoneContactAddHolder)localObject;
          ((PhoneContactAddBuilder.PhoneContactAddHolder)localObject).jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(a(11, ((PhoneContactAddBuilder.PhoneContactAddHolder)localObject).jdField_f_of_type_JavaLangString));
        }
        else if ((localObject instanceof ContactBindedBuilder.ContactBindedHolder))
        {
          localObject = (ContactBindedBuilder.ContactBindedHolder)localObject;
          if ((((ContactBindedBuilder.ContactBindedHolder)localObject).jdField_a_of_type_JavaLangString != null) && (((ContactBindedBuilder.ContactBindedHolder)localObject).jdField_a_of_type_JavaLangString.length() > 0)) {
            ((ContactBindedBuilder.ContactBindedHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(a(11, ((ContactBindedBuilder.ContactBindedHolder)localObject).jdField_a_of_type_JavaLangString));
          }
          if ((((ContactBindedBuilder.ContactBindedHolder)localObject).jdField_b_of_type_JavaLangString != null) && (((ContactBindedBuilder.ContactBindedHolder)localObject).jdField_b_of_type_JavaLangString.length() > 0)) {
            ((ContactBindedBuilder.ContactBindedHolder)localObject).jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(a(11, ((ContactBindedBuilder.ContactBindedHolder)localObject).jdField_b_of_type_JavaLangString));
          }
          if ((((ContactBindedBuilder.ContactBindedHolder)localObject).jdField_c_of_type_JavaLangString != null) && (((ContactBindedBuilder.ContactBindedHolder)localObject).jdField_c_of_type_JavaLangString.length() > 0)) {
            ((ContactBindedBuilder.ContactBindedHolder)localObject).jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(a(11, ((ContactBindedBuilder.ContactBindedHolder)localObject).jdField_c_of_type_JavaLangString));
          }
          if ((((ContactBindedBuilder.ContactBindedHolder)localObject).jdField_d_of_type_JavaLangString != null) && (((ContactBindedBuilder.ContactBindedHolder)localObject).jdField_d_of_type_JavaLangString.length() > 0)) {
            ((ContactBindedBuilder.ContactBindedHolder)localObject).jdField_d_of_type_AndroidWidgetImageView.setImageBitmap(a(11, ((ContactBindedBuilder.ContactBindedHolder)localObject).jdField_d_of_type_JavaLangString));
          }
          if ((((ContactBindedBuilder.ContactBindedHolder)localObject).jdField_e_of_type_JavaLangString != null) && (((ContactBindedBuilder.ContactBindedHolder)localObject).jdField_e_of_type_JavaLangString.length() > 0)) {
            ((ContactBindedBuilder.ContactBindedHolder)localObject).jdField_e_of_type_AndroidWidgetImageView.setImageBitmap(a(11, ((ContactBindedBuilder.ContactBindedHolder)localObject).jdField_e_of_type_JavaLangString));
          }
        }
        else if ((localObject instanceof NewFriendVerifyBlockedBuilder.NewFriendVerifyBlockedHolder))
        {
          localObject = (NewFriendVerifyBlockedBuilder.NewFriendVerifyBlockedHolder)localObject;
          ((NewFriendVerifyBlockedBuilder.NewFriendVerifyBlockedHolder)localObject).jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(a(1, ((NewFriendVerifyBlockedBuilder.NewFriendVerifyBlockedHolder)localObject).jdField_f_of_type_JavaLangString));
        }
      }
    }
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.cancelPendingRequests();
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.pause();
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing()) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.resume();
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(null);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendManager.a(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendManager.b(this);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b(this);
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(null);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.destory();
    NewFriendNotifyPokeMsgHelper.a();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size())) {
      return new Object();
    }
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = ((NewFriendBaseBuilder)getItem(paramInt)).a(paramInt, paramView);
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SystemMsgListAdapter", 2, "stopVisibleExpose firstVisible: " + this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition() + " lastvisible: " + this.jdField_a_of_type_ComTencentWidgetXListView.getLastVisiblePosition());
    }
    if ((getCount() > 0) && (this.jdField_a_of_type_ComTencentWidgetXListView.isShown()))
    {
      int i = this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition();
      while ((i <= this.jdField_a_of_type_ComTencentWidgetXListView.getLastVisiblePosition()) && (i < getCount()))
      {
        NewFriendBaseBuilder localNewFriendBaseBuilder = (NewFriendBaseBuilder)getItem(i);
        if ((localNewFriendBaseBuilder instanceof MayKnowRecommendBuilder)) {
          ((MayKnowRecommendBuilder)localNewFriendBaseBuilder).c();
        }
        i += 1;
      }
    }
    if (this.jdField_a_of_type_ComTencentWidgetXListView != null) {
      this.jdField_a_of_type_ComTencentWidgetXListView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      b(b());
    }
    for (;;)
    {
      return false;
      if (paramMessage.what == 2) {
        notifyDataSetChanged();
      } else if (paramMessage.what == 3) {
        a((NewFriendSlideTabMessage)paramMessage.obj);
      }
    }
  }
  
  public void hideMenuPop() {}
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SystemMsgListAdapter", 2, "onResume firstVisible: " + this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition() + " lastvisible: " + this.jdField_a_of_type_ComTencentWidgetXListView.getLastVisiblePosition());
    }
    if ((getCount() > 0) && (this.jdField_a_of_type_ComTencentWidgetXListView.isShown()))
    {
      int i = this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition();
      while ((i <= this.jdField_a_of_type_ComTencentWidgetXListView.getLastVisiblePosition()) && (i < getCount()))
      {
        NewFriendBaseBuilder localNewFriendBaseBuilder = (NewFriendBaseBuilder)getItem(i);
        if ((localNewFriendBaseBuilder instanceof MayKnowRecommendBuilder)) {
          ((MayKnowRecommendBuilder)localNewFriendBaseBuilder).b();
        }
        i += 1;
      }
    }
    if (this.jdField_a_of_type_ComTencentWidgetXListView != null)
    {
      this.jdField_a_of_type_ComTencentWidgetXListView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_ComTencentWidgetXListView.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
    }
  }
  
  public void interceptTouchEvent(boolean paramBoolean)
  {
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler instanceof FlingGestureHandler)))
    {
      localObject = (FlingGestureHandler)this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler;
      if (((FlingGestureHandler)localObject).mTopLayout != null)
      {
        localObject = ((FlingGestureHandler)localObject).mTopLayout;
        if (paramBoolean) {
          break label49;
        }
      }
    }
    label49:
    for (paramBoolean = true;; paramBoolean = false)
    {
      ((TopGestureLayout)localObject).setInterceptTouchFlag(paramBoolean);
      return;
    }
  }
  
  public void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SystemMsgListAdapter", 2, "onResume firstVisible: " + this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition() + " lastvisible: " + this.jdField_a_of_type_ComTencentWidgetXListView.getLastVisiblePosition());
    }
    if ((getCount() > 0) && (this.jdField_a_of_type_ComTencentWidgetXListView.isShown()))
    {
      this.jdField_a_of_type_ComTencentWidgetXListView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList3 = new ArrayList();
      ArrayList localArrayList4 = new ArrayList();
      ArrayList localArrayList5 = new ArrayList();
      int i = this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition();
      if ((i <= this.jdField_a_of_type_ComTencentWidgetXListView.getLastVisiblePosition()) && (i < getCount()))
      {
        Object localObject = (NewFriendBaseBuilder)getItem(i);
        if ((localObject instanceof MayKnowRecommendBuilder))
        {
          localArrayList1.add(((MayKnowRecommendBuilder)localObject).b());
          localArrayList2.add(((MayKnowRecommendBuilder)localObject).a());
          localArrayList3.add(Integer.valueOf(((MayKnowRecommendBuilder)localObject).b()));
          localArrayList4.add(((MayKnowRecommendBuilder)localObject).a());
        }
        for (;;)
        {
          i += 1;
          break;
          if ((localObject instanceof NewFriendSlideTabBuilder))
          {
            localObject = ((NewFriendSlideTabBuilder)localObject).a();
            if (localObject != null) {
              localArrayList5.addAll((Collection)localObject);
            }
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("SystemMsgListAdapter", 2, "reportRecommendFrdExpose exp_uins: " + localArrayList1 + " exp_reasons:" + localArrayList2 + " exp_positions:" + localArrayList3 + " algh_ids:" + localArrayList4);
      }
      ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, b(), localArrayList1, localArrayList2, localArrayList3, localArrayList4, 0, "3");
    }
  }
  
  public void k_(int paramInt)
  {
    c();
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      this.jdField_a_of_type_JavaUtilHashtable.put(paramString, paramBitmap);
    }
    if (paramInt1 <= 0)
    {
      paramInt2 = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
      paramInt1 = 0;
      if (paramInt1 < paramInt2)
      {
        paramString = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(paramInt1).getTag();
        if (paramString != null)
        {
          if (!(paramString instanceof ContactBindedBuilder.ContactBindedHolder)) {
            break label73;
          }
          a((ContactBindedBuilder.ContactBindedHolder)paramString);
        }
        for (;;)
        {
          paramInt1 += 1;
          break;
          label73:
          if ((!(paramString instanceof NewFriendSubTitleBuilder.NewFriendSubTitleHolder)) && (!(paramString instanceof NewFriendMoreInfoBuilder.NewFriendMoreInfoHolder)) && (!(paramString instanceof NewFriendBindContactGuideBuilder.MyHolder)) && (!(paramString instanceof NewFriendSlideTabBuilder.NewFriendSildeTabHolder)) && (!(paramString instanceof NewFriendTabInfoBuilder.NewFriendTabInfoHolder)) && (!(paramString instanceof NewFriendTabEmptyBuilder.NewFriendTabEmptyHolder)) && (!(paramString instanceof NewFriendFillAcademicInfoBuilder.NewFriendFillAcademicInfoHolder)) && (!(paramString instanceof NewFriendTabGuideBuilder.NewFriendTabInfoHolder)) && (!(paramString instanceof NewFriendSysEmptyBuilder.NewFriendSysEmptyHolder)))
          {
            paramString = (NewFriendBaseBuilder.NewFriendBaseHolder)paramString;
            if ((paramString.jdField_f_of_type_JavaLangString != null) && (paramString.jdField_f_of_type_JavaLangString.length() > 0))
            {
              paramBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilHashtable.get(paramString.jdField_f_of_type_JavaLangString);
              if (paramBitmap != null) {
                paramString.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
              }
            }
          }
        }
      }
      this.jdField_a_of_type_JavaUtilHashtable.clear();
    }
  }
  
  public void onGetIcon(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if ((paramInt2 == 200) && (paramBitmap != null)) {
      notifyDataSetChanged();
    }
  }
  
  public void updateCurShowRightView(View paramView)
  {
    if (paramView != null)
    {
      paramView = paramView.getTag(-1);
      if (!(paramView instanceof Integer)) {}
    }
    for (int i = ((Integer)paramView).intValue();; i = -1)
    {
      this.jdField_a_of_type_Int = i;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListAdapter
 * JD-Core Version:    0.7.0.1
 */