package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.contact.newfriend.ContactBindedBuilder;
import com.tencent.mobileqq.activity.contact.newfriend.ContactBindedBuilder.ContactBindedHolder;
import com.tencent.mobileqq.activity.contact.newfriend.ContactMatchBuilder.ContactMatchHolder;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendBaseBuilder;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendBaseBuilder.NewFriendBaseHolder;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendBindContactGuideBuilder.MyHolder;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendMoreInfoBuilder.NewFriendMoreInfoHolder;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendSubTitleBuilder.NewFriendSubTitleHolder;
import com.tencent.mobileqq.activity.contact.newfriend.PhoneContactAddBuilder.PhoneContactAddHolder;
import com.tencent.mobileqq.activity.contact.newfriend.PushRecommendBuilder;
import com.tencent.mobileqq.activity.contact.newfriend.PushRecommendBuilder.PushRecommendHolder;
import com.tencent.mobileqq.activity.contact.newfriend.SystemMsgItemBuilder.SystemMsgItemHolder;
import com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListView;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.FlingHandler;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.NewFriendManager.INewFriendListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.newfriend.FriendSystemMessage;
import com.tencent.mobileqq.newfriend.NewFriendMessage;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.richstatus.IIconListener;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SwipListView.SwipListListener;
import com.tencent.widget.XBaseAdapter;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import yii;
import yik;

public class SystemMsgListAdapter
  extends XBaseAdapter
  implements Handler.Callback, NewFriendManager.INewFriendListener, IIconListener, FaceDecoder.DecodeTaskCompletionListener, SwipListView.SwipListListener
{
  public int a;
  private Context jdField_a_of_type_AndroidContentContext;
  Handler jdField_a_of_type_AndroidOsHandler = null;
  private ContactBindedBuilder jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendContactBindedBuilder;
  public SystemMsgListView a;
  private FlingHandler jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler;
  CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new yik(this);
  private NewFriendManager jdField_a_of_type_ComTencentMobileqqAppNewFriendManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  public XListView a;
  public ArrayList a;
  private Hashtable jdField_a_of_type_JavaUtilHashtable = new Hashtable();
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private ConcurrentLinkedQueue jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  private boolean jdField_a_of_type_Boolean = true;
  private int b;
  
  public SystemMsgListAdapter(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, SystemMsgListView paramSystemMsgListView, int paramInt, FlingHandler paramFlingHandler)
  {
    this.jdField_a_of_type_Int = -1;
    this.b = paramInt;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView = paramSystemMsgListView;
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(paramContext, paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
    this.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager = ((NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(33));
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14));
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this);
    this.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler = paramFlingHandler;
    this.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager.a(0);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver, true);
    k();
  }
  
  private void k()
  {
    ThreadManager.postImmediately(new yii(this), null, true);
  }
  
  public void Q_()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SystemMsgListAdapter", 2, "onMayKnowStatesChanged");
    }
    c();
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
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramInt, paramString);
    if (localBitmap != null) {
      return localBitmap;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a()) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramString, paramInt, true, (byte)0);
    }
    return ImageUtil.a();
  }
  
  public void a(int paramInt)
  {
    c();
  }
  
  public void a(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if ((paramInt2 == 200) && (paramBitmap != null)) {
      notifyDataSetChanged();
    }
  }
  
  public void a(long paramLong)
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
  
  public void a(View paramView)
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
  
  public void a(SystemMsgItemBuilder.SystemMsgItemHolder paramSystemMsgItemHolder)
  {
    if ((paramSystemMsgItemHolder == null) || (paramSystemMsgItemHolder.jdField_f_of_type_AndroidWidgetImageView == null)) {
      return;
    }
    int i = paramSystemMsgItemHolder.a.msg.src_id.get();
    Object localObject1;
    if ((i == 3007) || (i == 3019) || (i == 2007) || (i == 4007) || (i == 2019))
    {
      localObject1 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
      if ((localObject1 != null) && (((FriendsManager)localObject1).b(String.valueOf(paramSystemMsgItemHolder.a.req_uin.get())))) {
        i = 0;
      }
    }
    for (;;)
    {
      Object localObject2;
      if (i != 0)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(32, String.valueOf(paramSystemMsgItemHolder.a.req_uin.get()), 200);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = localObject2;
          if (!this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a())
          {
            this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(String.valueOf(paramSystemMsgItemHolder.a.req_uin.get()), 200, true, true);
            localObject1 = localObject2;
          }
        }
      }
      for (;;)
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = ImageUtil.a();
        }
        paramSystemMsgItemHolder.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject2);
        return;
        i = 1;
        break;
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(1, String.valueOf(paramSystemMsgItemHolder.a.req_uin.get()));
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = localObject2;
          if (!this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a())
          {
            this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(String.valueOf(paramSystemMsgItemHolder.a.req_uin.get()), 1, true);
            localObject1 = localObject2;
          }
        }
      }
      i = 0;
    }
  }
  
  public void a(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {}
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_JavaUtilArrayList != null) {
        this.jdField_a_of_type_JavaUtilArrayList.clear();
      }
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        Object localObject = (NewFriendMessage)paramArrayList.next();
        if ((localObject instanceof FriendSystemMessage))
        {
          localObject = (FriendSystemMessage)localObject;
          if ((((FriendSystemMessage)localObject).a != null) && (((FriendSystemMessage)localObject).a.structMsg != null) && (ProfileActivity.e(((FriendSystemMessage)localObject).a.structMsg.msg.src_id.get())))
          {
            if (this.jdField_a_of_type_JavaUtilArrayList == null) {
              this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
            }
            localObject = String.valueOf(((FriendSystemMessage)localObject).a.structMsg.req_uin.get());
            String str = ContactUtils.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject);
            this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
            if (QLog.isDevelopLevel()) {
              QLog.i("SystemMsgListAdapter", 4, String.format(Locale.getDefault(), "preDealNewFriendMessage [%s, %s]", new Object[] { Utils.b((String)localObject), Utils.b(str) }));
            }
          }
        }
      }
    }
  }
  
  public void b()
  {
    c();
  }
  
  public void c()
  {
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null)
    {
      localHandler.removeMessages(1);
      localHandler.sendEmptyMessageDelayed(1, 400L);
    }
  }
  
  public void d() {}
  
  public void e()
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
        else if ((localObject instanceof PushRecommendBuilder.PushRecommendHolder))
        {
          localObject = (PushRecommendBuilder.PushRecommendHolder)localObject;
          ((PushRecommendBuilder.PushRecommendHolder)localObject).jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(a(1, ((PushRecommendBuilder.PushRecommendHolder)localObject).jdField_f_of_type_JavaLangString));
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
      }
    }
  }
  
  public void e(boolean paramBoolean)
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
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a();
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.c();
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a()) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b();
    }
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
    return ((NewFriendBaseBuilder)getItem(paramInt)).a(paramInt, paramView);
  }
  
  public void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager.a(0);
    this.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager.b(this);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b(this);
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(null);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      k();
    }
    return false;
  }
  
  public void i()
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
        if ((localNewFriendBaseBuilder instanceof PushRecommendBuilder)) {
          ((PushRecommendBuilder)localNewFriendBaseBuilder).c();
        }
        i += 1;
      }
    }
  }
  
  public void j()
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
        if ((localNewFriendBaseBuilder instanceof PushRecommendBuilder)) {
          ((PushRecommendBuilder)localNewFriendBaseBuilder).b();
        }
        i += 1;
      }
    }
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
            break label305;
          }
          paramString = (ContactBindedBuilder.ContactBindedHolder)paramString;
          if ((paramString.jdField_a_of_type_JavaLangString != null) && (paramString.jdField_a_of_type_JavaLangString.length() > 0))
          {
            paramBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilHashtable.get(paramString.jdField_a_of_type_JavaLangString);
            if (paramBitmap != null) {
              paramString.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
            }
          }
          if ((paramString.jdField_b_of_type_JavaLangString != null) && (paramString.jdField_b_of_type_JavaLangString.length() > 0))
          {
            paramBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilHashtable.get(paramString.jdField_b_of_type_JavaLangString);
            if (paramBitmap != null) {
              paramString.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
            }
          }
          if ((paramString.jdField_c_of_type_JavaLangString != null) && (paramString.jdField_c_of_type_JavaLangString.length() > 0))
          {
            paramBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilHashtable.get(paramString.jdField_c_of_type_JavaLangString);
            if (paramBitmap != null) {
              paramString.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
            }
          }
          if ((paramString.jdField_d_of_type_JavaLangString != null) && (paramString.jdField_d_of_type_JavaLangString.length() > 0))
          {
            paramBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilHashtable.get(paramString.jdField_d_of_type_JavaLangString);
            if (paramBitmap != null) {
              paramString.jdField_d_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
            }
          }
          if ((paramString.jdField_e_of_type_JavaLangString != null) && (paramString.jdField_e_of_type_JavaLangString.length() > 0))
          {
            paramBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilHashtable.get(paramString.jdField_e_of_type_JavaLangString);
            if (paramBitmap != null) {
              paramString.jdField_e_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
            }
          }
        }
        for (;;)
        {
          paramInt1 += 1;
          break;
          label305:
          if ((!(paramString instanceof NewFriendSubTitleBuilder.NewFriendSubTitleHolder)) && (!(paramString instanceof NewFriendMoreInfoBuilder.NewFriendMoreInfoHolder)) && (!(paramString instanceof NewFriendBindContactGuideBuilder.MyHolder)))
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.SystemMsgListAdapter
 * JD-Core Version:    0.7.0.1
 */