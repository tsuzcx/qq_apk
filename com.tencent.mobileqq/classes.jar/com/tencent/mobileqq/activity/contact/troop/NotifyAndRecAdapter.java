package com.tencent.mobileqq.activity.contact.troop;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contact.newfriend.BaseSystemMsgInterface;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendBaseBuilder;
import com.tencent.mobileqq.activity.contact.recommendtroop.RecommendTroopAdapter;
import com.tencent.mobileqq.activity.contact.recommendtroop.RecommendTroopAdapter.ViewHolder;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RecommendTroopManagerImp;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.TroopNotificationConfig;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.troop.data.RecommendTroopItem;
import com.tencent.mobileqq.troop.utils.NonMainAppListViewFaceLoader;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.SwipListView.SwipListListener;
import com.tencent.widget.XBaseAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.cmd0x935.oidb_0x935.NotifyInfo;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class NotifyAndRecAdapter
  extends XBaseAdapter
  implements SwipListView.SwipListListener
{
  private static HashMap<Long, MessageRecord> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private static HashMap<Long, MessageRecord> jdField_c_of_type_JavaUtilHashMap = new HashMap();
  public int a;
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new NotifyAndRecAdapter.2(this);
  protected View a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private BaseSystemMsgInterface jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseSystemMsgInterface;
  protected BaseTroopView.ITroopContext a;
  private DelMenuBuilder jdField_a_of_type_ComTencentMobileqqActivityContactTroopDelMenuBuilder;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected NonMainAppListViewFaceLoader a;
  HashMap<String, String> jdField_a_of_type_JavaUtilHashMap;
  protected List<MessageRecord> a;
  public boolean a;
  private final int jdField_b_of_type_Int = 0;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new NotifyAndRecAdapter.3(this);
  View jdField_b_of_type_AndroidViewView;
  protected List<RecommendTroopItem> b;
  public boolean b;
  private final int jdField_c_of_type_Int = 1;
  private View.OnClickListener jdField_c_of_type_AndroidViewView$OnClickListener = new NotifyAndRecAdapter.4(this);
  public List<MessageRecord> c;
  protected boolean c;
  private final int d;
  public boolean d;
  private final int jdField_e_of_type_Int = 3;
  private boolean jdField_e_of_type_Boolean;
  private final int jdField_f_of_type_Int = 4;
  private boolean jdField_f_of_type_Boolean;
  private final int jdField_g_of_type_Int = 5;
  private boolean jdField_g_of_type_Boolean = false;
  private final int jdField_h_of_type_Int = 6;
  private boolean jdField_h_of_type_Boolean;
  private int jdField_i_of_type_Int = -1;
  private boolean jdField_i_of_type_Boolean;
  
  public NotifyAndRecAdapter(QQAppInterface paramQQAppInterface, Context paramContext, BaseTroopView.ITroopContext paramITroopContext, BaseSystemMsgInterface paramBaseSystemMsgInterface)
  {
    this.jdField_d_of_type_Int = 2;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_c_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext = paramITroopContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseSystemMsgInterface = paramBaseSystemMsgInterface;
    this.jdField_i_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopDelMenuBuilder = new DelMenuBuilder(this.jdField_a_of_type_AndroidContentContext);
  }
  
  private void a(View paramView)
  {
    if (paramView == null) {}
    label4:
    Object localObject;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              break label4;
              break label4;
              break label4;
              do
              {
                return;
              } while (!NetworkUtil.g(this.jdField_a_of_type_AndroidContentContext));
              if (Utils.a("tag_swip_icon_menu_item", paramView.getTag())) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.i("NotifyAndRecAdapter", 2, "handleDeleteItem|onClick tag is not int");
            return;
            localObject = paramView.getTag(-1);
            paramView = paramView.getTag(-2);
            if (((localObject instanceof Integer)) && ((paramView instanceof Integer))) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.i("NotifyAndRecAdapter", 2, "handleDeleteItem|onClick posTag or subTag is not int");
          return;
          int j = ((Integer)localObject).intValue();
          if (QLog.isColorLevel()) {
            QLog.i("NotifyAndRecAdapter", 2, "handleDeleteItem|onClick position = " + j);
          }
          paramView = a(j);
        } while (!(paramView instanceof MessageRecord));
        paramView = (MessageRecord)paramView;
      } while (!(paramView instanceof MessageForSystemMsg));
      localObject = ((MessageForSystemMsg)paramView).getSystemMsg();
    } while (localObject == null);
    TroopNotifyHelper.a((structmsg.StructMsg)localObject, paramView.uniseq, AppConstants.TROOP_SYSTEM_MSG_UIN);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a().sendEmptyMessage(108);
    }
    TroopNotifyHelper.a((structmsg.StructMsg)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
  }
  
  private void a(RecommendTroopItem paramRecommendTroopItem)
  {
    if ((paramRecommendTroopItem == null) || (TextUtils.isEmpty(paramRecommendTroopItem.uin))) {
      QLog.e("TroopReportor.recommend", 1, "notify reportTroopExposure, troopUin == null or troopUin is empty!");
    }
    String str1;
    String str2;
    do
    {
      do
      {
        return;
        str1 = paramRecommendTroopItem.uin;
        str2 = paramRecommendTroopItem.name;
        paramRecommendTroopItem = paramRecommendTroopItem.recomAlgol;
        if (this.jdField_a_of_type_JavaUtilHashMap == null) {
          this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
        }
      } while (this.jdField_a_of_type_JavaUtilHashMap.containsKey(str1));
      this.jdField_a_of_type_JavaUtilHashMap.put(str1, paramRecommendTroopItem);
      TroopReportor.a("Grp_contacts_news", "notice", "recom_exp_grp", 0, 0, new String[] { str1, paramRecommendTroopItem });
    } while (!QLog.isColorLevel());
    QLog.d("TroopReportor.recommend", 2, String.format("notify reportTroopExposure, troopUin: %s, troopName: %s, recomAlgol:%s", new Object[] { str1, str2, paramRecommendTroopItem }));
  }
  
  private int c()
  {
    int j = 5;
    this.jdField_g_of_type_Boolean = false;
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    int k = this.jdField_a_of_type_JavaUtilList.size();
    if (k == 0)
    {
      if (this.jdField_f_of_type_Boolean)
      {
        this.jdField_g_of_type_Boolean = true;
        this.jdField_e_of_type_Boolean = true;
        return 2;
      }
      this.jdField_g_of_type_Boolean = false;
      this.jdField_e_of_type_Boolean = false;
      return 1;
    }
    if (((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.size() == 0)) && (this.jdField_b_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = true;
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    if (this.jdField_i_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    if ((this.jdField_d_of_type_Boolean) && (k >= 5)) {}
    while (j < k)
    {
      this.jdField_e_of_type_Boolean = true;
      return j + 1;
      if (this.jdField_a_of_type_Int >= 5) {
        this.jdField_d_of_type_Boolean = true;
      } else if (k >= 3) {
        j = 3;
      } else {
        j = k;
      }
    }
    if (this.jdField_f_of_type_Boolean)
    {
      this.jdField_g_of_type_Boolean = true;
      this.jdField_e_of_type_Boolean = true;
      return k + 1;
    }
    this.jdField_e_of_type_Boolean = false;
    return k;
  }
  
  public int a()
  {
    if ((this.jdField_e_of_type_Boolean) && (!this.jdField_i_of_type_Boolean)) {
      return c() - 1;
    }
    return c();
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1 = a(paramInt);
    int j;
    if ((paramView == null) || (!(paramView.getTag() instanceof NotificationAdapter.ViewHolder)))
    {
      paramViewGroup = new NotificationAdapter.ViewHolder();
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopDelMenuBuilder.a(this.jdField_a_of_type_AndroidContentContext, 2131560030, paramViewGroup);
      Object localObject2 = new NotificationAdapter.ApplicantHolder();
      ((NotificationAdapter.ApplicantHolder)localObject2).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131374118);
      ((NotificationAdapter.ApplicantHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView = ((TextView)((NotificationAdapter.ApplicantHolder)localObject2).jdField_a_of_type_AndroidViewView.findViewById(2131374131));
      ((NotificationAdapter.ApplicantHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView = ((TextView)((NotificationAdapter.ApplicantHolder)localObject2).jdField_a_of_type_AndroidViewView.findViewById(2131374132));
      ((NotificationAdapter.ApplicantHolder)localObject2).jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((NotificationAdapter.ApplicantHolder)localObject2).jdField_a_of_type_AndroidViewView.findViewById(2131374128));
      ((NotificationAdapter.ApplicantHolder)localObject2).jdField_c_of_type_AndroidWidgetTextView = ((TextView)((NotificationAdapter.ApplicantHolder)localObject2).jdField_a_of_type_AndroidViewView.findViewById(2131374127));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationAdapter$ApplicantHolder = ((NotificationAdapter.ApplicantHolder)localObject2);
      paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131374134));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131374117));
      paramViewGroup.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131374125));
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131374138));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131374123));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131374135));
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131374137));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131374124));
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131374133));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetShaderAnimLayout = ((ShaderAnimLayout)paramView.findViewById(2131379998));
      localObject2 = (Button)paramView.findViewById(2131379997);
      paramView.setTag(paramViewGroup);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopDelMenuBuilder.a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, localObject1, paramViewGroup, new NotifyAndRecAdapter.5(this), this.jdField_i_of_type_Int);
      paramViewGroup.jdField_b_of_type_Int = paramInt;
      localObject1 = (TroopNotificationConfig)QConfigManager.a().a(634);
      if (localObject1 == null) {
        break label528;
      }
      if (((TroopNotificationConfig)localObject1).jdField_e_of_type_Int != 1) {
        break label444;
      }
      j = 1;
    }
    for (;;)
    {
      label369:
      if ((paramInt < this.jdField_a_of_type_Int) && (j != 0))
      {
        NewFriendBaseBuilder.a(paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout, true);
        localObject1 = a(paramInt);
        if ((localObject1 != null) && ((localObject1 instanceof MessageForSystemMsg))) {
          break label461;
        }
      }
      for (;;)
      {
        label390:
        return paramView;
        paramViewGroup = (NotificationAdapter.ViewHolder)paramView.getTag();
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setPadding(ViewUtils.a(5.0F), 0, ViewUtils.a(5.0F), 0);
        break;
        label444:
        j = 0;
        break label369;
        NewFriendBaseBuilder.a(paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout, false);
        break label390;
        label461:
        paramViewGroup.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = ((MessageForSystemMsg)localObject1).getSystemMsg();
        paramViewGroup.jdField_c_of_type_Long = ((MessageRecord)localObject1).uniseq;
        if (localObject1 != null) {}
        for (j = ((MessageForSystemMsg)localObject1).getSystemMsg().msg_type.get(); j == 2; j = 2)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseSystemMsgInterface.a(paramViewGroup, paramInt);
          return paramView;
        }
      }
      label528:
      j = 0;
    }
  }
  
  public MessageRecord a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (MessageRecord)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int j = 0;
    if (j < paramInt1)
    {
      if (getItemViewType(j) != 0) {}
      for (;;)
      {
        j += 1;
        break;
        MessageRecord localMessageRecord = a(j);
        if ((localMessageRecord != null) && ((localMessageRecord instanceof MessageForSystemMsg)))
        {
          structmsg.StructMsg localStructMsg = ((MessageForSystemMsg)localMessageRecord).getSystemMsg();
          if ((localStructMsg.msg_seq.has()) && (((structmsg.SystemMsg)localStructMsg.msg.get()).sub_type.has()) && (((structmsg.SystemMsg)localStructMsg.msg.get()).sub_type.get() == 1) && (localStructMsg.msg.group_msg_type.has())) {
            if ((paramInt2 == 1) && (!jdField_b_of_type_JavaUtilHashMap.containsKey(Long.valueOf(localStructMsg.msg_seq.get())))) {
              jdField_b_of_type_JavaUtilHashMap.put(Long.valueOf(localStructMsg.msg_seq.get()), localMessageRecord);
            } else if ((paramInt2 == 0) && (!jdField_c_of_type_JavaUtilHashMap.containsKey(Long.valueOf(localStructMsg.msg_seq.get())))) {
              jdField_c_of_type_JavaUtilHashMap.put(Long.valueOf(localStructMsg.msg_seq.get()), localMessageRecord);
            }
          }
        }
      }
    }
  }
  
  public void a(LinearLayout paramLinearLayout)
  {
    if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
      paramLinearLayout.setBackgroundResource(17170444);
    }
    for (;;)
    {
      Object localObject = this.jdField_a_of_type_AndroidContentContext.getResources();
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = AIOUtils.a(238.0F, (Resources)localObject);
      localURLDrawableOptions.mRequestHeight = AIOUtils.a(161.0F, (Resources)localObject);
      localURLDrawableOptions.mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
      localURLDrawableOptions.mFailedDrawable = URLDrawableHelper.TRANSPARENT;
      localObject = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/files/20180622/1bf451e30af44c7c8f49ef5dd5a25822.png", localURLDrawableOptions);
      ((ImageView)paramLinearLayout.findViewById(2131368364)).setImageDrawable((Drawable)localObject);
      return;
      paramLinearLayout.setBackgroundResource(17170443);
    }
  }
  
  public void a(RecommendTroopManagerImp paramRecommendTroopManagerImp)
  {
    ArrayList localArrayList;
    int j;
    Object localObject;
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramRecommendTroopManagerImp != null))
    {
      localArrayList = new ArrayList(3);
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      j = 0;
      if (localIterator.hasNext())
      {
        localObject = (MessageRecord)localIterator.next();
        if (j < 3) {
          break label70;
        }
      }
      if (paramRecommendTroopManagerImp != null) {
        paramRecommendTroopManagerImp.a(localArrayList);
      }
    }
    return;
    label70:
    if ((localObject instanceof MessageForSystemMsg))
    {
      localObject = ((MessageForSystemMsg)localObject).getSystemMsg();
      oidb_0x935.NotifyInfo localNotifyInfo = new oidb_0x935.NotifyInfo();
      localNotifyInfo.uint64_notify_gc.set(((structmsg.StructMsg)localObject).msg.group_code.get());
      localNotifyInfo.uint32_notify_type.set(((structmsg.StructMsg)localObject).msg.group_msg_type.get());
      localArrayList.add(localNotifyInfo);
      j += 1;
    }
    for (;;)
    {
      break;
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    RecommendTroopItem localRecommendTroopItem;
    do
    {
      Iterator localIterator;
      do
      {
        return;
        while ((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.size() <= 0)) {}
        localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
      } while (!localIterator.hasNext());
      localRecommendTroopItem = (RecommendTroopItem)localIterator.next();
    } while (!paramString.equals(localRecommendTroopItem.uin));
    localRecommendTroopItem.hasRequestJoin = true;
    if (QLog.isColorLevel()) {
      QLog.d("NotifyAndRecAdapter", 2, "updateJoinStatus, troopUin: " + paramString);
    }
    notifyDataSetChanged();
  }
  
  public void a(List<MessageRecord> paramList)
  {
    if ((QLog.isColorLevel()) && (paramList != null)) {
      QLog.d("NotifyAndRecAdapter", 2, "noti size is " + paramList.size());
    }
    if ((paramList == null) || (this.jdField_a_of_type_JavaUtilList == null)) {}
    for (;;)
    {
      return;
      HashSet localHashSet = new HashSet();
      this.jdField_a_of_type_JavaUtilList.clear();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramList.next();
        if ((localMessageRecord instanceof MessageForSystemMsg))
        {
          structmsg.StructMsg localStructMsg = ((MessageForSystemMsg)localMessageRecord).getSystemMsg();
          if ((localStructMsg != null) && (localStructMsg.msg_seq.has()) && (!localHashSet.contains(Long.valueOf(localStructMsg.msg_seq.get()))))
          {
            localHashSet.add(Long.valueOf(localStructMsg.msg_seq.get()));
            this.jdField_a_of_type_JavaUtilList.add(localMessageRecord);
          }
        }
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_i_of_type_Boolean;
  }
  
  public int b()
  {
    int k = this.jdField_b_of_type_JavaUtilList.size();
    int j = k;
    if (this.jdField_h_of_type_Boolean) {
      j = k + 1;
    }
    return j;
  }
  
  public void b()
  {
    Iterator localIterator = jdField_c_of_type_JavaUtilHashMap.keySet().iterator();
    long l;
    Object localObject;
    while (localIterator.hasNext())
    {
      l = ((Long)localIterator.next()).longValue();
      localObject = (MessageRecord)jdField_c_of_type_JavaUtilHashMap.get(Long.valueOf(l));
      if ((localObject != null) && ((localObject instanceof MessageForSystemMsg)))
      {
        localObject = ((MessageForSystemMsg)localObject).getSystemMsg();
        if ((((structmsg.StructMsg)localObject).msg_seq.has()) && (((structmsg.StructMsg)localObject).msg.group_code.has()) && (((structmsg.StructMsg)localObject).msg.group_msg_type.has())) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_contacts_news", "", "notice", "todotab_notice_exp", 2, 0, String.valueOf(((structmsg.StructMsg)localObject).msg_seq.get()), String.valueOf(((structmsg.StructMsg)localObject).msg.group_code.get()), String.valueOf(((structmsg.StructMsg)localObject).msg.group_msg_type.get()), "");
        }
      }
    }
    localIterator = jdField_b_of_type_JavaUtilHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      l = ((Long)localIterator.next()).longValue();
      localObject = (MessageRecord)jdField_b_of_type_JavaUtilHashMap.get(Long.valueOf(l));
      if ((localObject != null) && ((localObject instanceof MessageForSystemMsg)))
      {
        localObject = ((MessageForSystemMsg)localObject).getSystemMsg();
        if ((((structmsg.StructMsg)localObject).msg_seq.has()) && (((structmsg.StructMsg)localObject).msg.group_code.has()) && (((structmsg.StructMsg)localObject).msg.group_msg_type.has())) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_contacts_news", "", "notice", "todotab_notice_exp", 1, 0, String.valueOf(((structmsg.StructMsg)localObject).msg_seq.get()), String.valueOf(((structmsg.StructMsg)localObject).msg.group_code.get()), String.valueOf(((structmsg.StructMsg)localObject).msg.group_msg_type.get()), "");
        }
      }
    }
  }
  
  public void b(List<RecommendTroopItem> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NotifyAndRecAdapter", 2, "setRecData: " + paramList);
    }
    this.jdField_b_of_type_JavaUtilList = paramList;
  }
  
  public boolean b()
  {
    return (this.jdField_b_of_type_JavaUtilList != null) && (this.jdField_b_of_type_JavaUtilList.size() > 0);
  }
  
  public int getCount()
  {
    int j = c();
    int k = b();
    if (QLog.isColorLevel()) {
      QLog.d("NotifyAndRecAdapter", 2, "total count is" + j + "," + k);
    }
    return j + k;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 3;
    }
    int j = this.jdField_a_of_type_JavaUtilList.size();
    if (((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.size() == 0)) && (this.jdField_b_of_type_Boolean)) {}
    for (this.jdField_a_of_type_Boolean = true;; this.jdField_a_of_type_Boolean = false)
    {
      if (j != 0) {
        break label85;
      }
      if (paramInt == 0) {
        break;
      }
      if ((paramInt != c() - 1) || (!this.jdField_e_of_type_Boolean)) {
        break label85;
      }
      return 2;
    }
    label85:
    if (this.jdField_a_of_type_Boolean) {
      return 0;
    }
    j = c();
    if (paramInt == j) {
      return 6;
    }
    if ((paramInt == j - 1) && (this.jdField_e_of_type_Boolean)) {
      return 2;
    }
    if ((paramInt == j + 1) && (this.jdField_h_of_type_Boolean)) {
      return 4;
    }
    if (paramInt <= j - 1) {
      return 0;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int j = getItemViewType(paramInt);
    Object localObject2;
    Object localObject1;
    Object localObject3;
    if (j == 1)
    {
      j = paramInt - c() - 1;
      if ((j < 0) || (j >= this.jdField_b_of_type_JavaUtilList.size()))
      {
        localObject2 = paramView;
        localObject1 = paramView;
        paramView = (View)localObject2;
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return localObject1;
      }
      localObject3 = (RecommendTroopItem)this.jdField_b_of_type_JavaUtilList.get(j);
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface instanceof QQAppInterface))) {
        localObject2 = FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 4, ((RecommendTroopItem)localObject3).uin);
      }
    }
    for (;;)
    {
      if (paramView != null)
      {
        localObject1 = paramView;
        if ((paramView.getTag() instanceof RecommendTroopAdapter.ViewHolder)) {}
      }
      else
      {
        localObject1 = RecommendTroopAdapter.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_c_of_type_AndroidViewView$OnClickListener);
      }
      RecommendTroopAdapter.a((RecommendTroopAdapter.ViewHolder)((View)localObject1).getTag(), (RecommendTroopItem)localObject3, (Drawable)localObject2);
      a((RecommendTroopItem)localObject3);
      paramView = (View)localObject1;
      break;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNonMainAppListViewFaceLoader != null)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNonMainAppListViewFaceLoader.a(((RecommendTroopItem)localObject3).uin, true);
        if (localObject1 != null)
        {
          localObject2 = new BitmapDrawable((Bitmap)localObject1);
          continue;
          if (j == 0)
          {
            localObject1 = a(paramInt, paramView, paramViewGroup);
            break;
          }
          if (j == 2)
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_contacts_news", "", "notice", "verify_exp", 0, 0, "", "", "", "");
            localObject2 = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131563167, null);
            localObject3 = (TextView)((View)localObject2).findViewById(2131377687);
            localObject1 = null;
            if (this.jdField_g_of_type_Boolean) {}
            for (;;)
            {
              ((TextView)localObject3).setText((CharSequence)localObject1);
              if (this.jdField_i_of_type_Boolean) {
                ((View)localObject2).setVisibility(8);
              }
              ((View)localObject2).setOnClickListener(new NotifyAndRecAdapter.1(this, (View)localObject2));
              if (!this.jdField_c_of_type_Boolean)
              {
                TroopReportor.a("Grp_contacts_news", "notice", "verify_clk", 2, 0, new String[0]);
                this.jdField_c_of_type_Boolean = true;
              }
              localObject1 = localObject2;
              break;
              if (this.jdField_a_of_type_Int > c() - 2) {
                localObject1 = HardCodeUtil.a(2131707618) + this.jdField_a_of_type_Int + HardCodeUtil.a(2131707620);
              } else {
                localObject1 = HardCodeUtil.a(2131707617);
              }
            }
          }
          if (j == 4)
          {
            j = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("nearby_troop_count", 0).getInt("troop_num", 0);
            this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560819, null);
            this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372163));
            this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131372149);
            if (j != 0)
            {
              localObject1 = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("nearby_troop_count", 0).getString("troop_wording", "");
              this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
            }
            for (;;)
            {
              localObject1 = this.jdField_a_of_type_AndroidViewView;
              break;
              this.jdField_b_of_type_AndroidViewView.setVisibility(8);
              this.jdField_a_of_type_AndroidViewView.setPadding(0, 0, 0, 0);
            }
          }
          if (j == 5)
          {
            localObject1 = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131563168, null);
            ((TextView)((View)localObject1).findViewById(2131368376)).setText(HardCodeUtil.a(2131707616));
            ((LinearLayout)((View)localObject1).findViewById(2131372397)).setVisibility(8);
            break;
          }
          if (j == 6)
          {
            localObject1 = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131563168, null);
            ((TextView)((View)localObject1).findViewById(2131368376)).setText(HardCodeUtil.a(2131707615));
            ((LinearLayout)((View)localObject1).findViewById(2131372397)).setVisibility(8);
            break;
          }
          if (j == 3)
          {
            localObject1 = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131563168, null);
            localObject2 = (TextView)((View)localObject1).findViewById(2131368376);
            ((TextView)localObject2).setText(HardCodeUtil.a(2131707619));
            ((TextView)localObject2).setVisibility(8);
            localObject2 = (LinearLayout)((View)localObject1).findViewById(2131372397);
            ((LinearLayout)localObject2).setVisibility(0);
            a((LinearLayout)localObject2);
            break;
          }
          localObject1 = null;
          break;
        }
      }
      localObject2 = null;
    }
  }
  
  public void hideMenuPop() {}
  
  public void interceptTouchEvent(boolean paramBoolean) {}
  
  public void updateCurShowRightView(View paramView)
  {
    if (paramView != null)
    {
      paramView = paramView.getTag(-1);
      if (!(paramView instanceof Integer)) {}
    }
    for (int j = ((Integer)paramView).intValue();; j = -1)
    {
      this.jdField_i_of_type_Int = j;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.NotifyAndRecAdapter
 * JD-Core Version:    0.7.0.1
 */