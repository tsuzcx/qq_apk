package com.tencent.mobileqq.activity.recent;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.ecshopassit.RecentItemEcShop;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.common.WeishiReportUtil;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.subscript.SubscriptRecommendController;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.mobileqq.activity.bless.BlessManager;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.IDragViewProvider;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.activity.recent.data.RecentCallItem;
import com.tencent.mobileqq.activity.recent.data.RecentItemChatMsgData;
import com.tencent.mobileqq.activity.recent.data.RecentItemConfessMsg;
import com.tencent.mobileqq.activity.recent.data.RecentItemEcShopAssitant;
import com.tencent.mobileqq.activity.recent.data.RecentItemServiceAccountFolderData;
import com.tencent.mobileqq.activity.recent.data.RecentItemTroopBarAssitant;
import com.tencent.mobileqq.activity.recent.data.RecentItemTroopMsgData;
import com.tencent.mobileqq.activity.recent.data.RecentMsgBoxItem;
import com.tencent.mobileqq.activity.recent.data.RecentSayHelloBoxItem;
import com.tencent.mobileqq.activity.recent.data.RecentSayHelloListItem;
import com.tencent.mobileqq.activity.recent.data.RecentTroopAssistantItem;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.activity.recent.data.SendBlessRecentItemData;
import com.tencent.mobileqq.apollo.activity.RecentHotchatItem;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.HotChatCenterManager;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qcall.QCallCardInfo;
import com.tencent.mobileqq.qcall.QCallCardManager;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.werewolves.WerewolvesHandler;
import com.tencent.mobileqq.werewolves.WerewolvesPluginManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.IRecentImgv;
import com.tencent.widget.SwipListView;
import com.tencent.widget.SwipListView.SwipListListener;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;
import xha;
import xhb;
import xhc;
import xhd;
import xhe;
import xhf;
import xhg;

public class RecentAdapter
  extends BaseAdapter
  implements View.OnClickListener, View.OnLongClickListener, DragFrameLayout.IDragViewProvider, DragFrameLayout.OnDragModeChangedListener, FaceDecoder.DecodeTaskCompletionListener, SwipListView.SwipListListener
{
  public int a;
  private long jdField_a_of_type_Long;
  protected Context a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new xhg(this);
  private OnRecentUserOpsListener jdField_a_of_type_ComTencentMobileqqActivityRecentOnRecentUserOpsListener;
  protected RecentFaceDecoder a;
  protected RecentItemBuilderFactory a;
  protected DragFrameLayout a;
  public QQAppInterface a;
  protected BubblePopupWindow a;
  protected XListView a;
  private Hashtable jdField_a_of_type_JavaUtilHashtable = new Hashtable();
  public final List a;
  private int b;
  protected List b;
  private int c;
  
  public RecentAdapter(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, OnRecentUserOpsListener paramOnRecentUserOpsListener, int paramInt)
  {
    this(paramContext, paramQQAppInterface, paramXListView, paramOnRecentUserOpsListener, paramInt, false);
  }
  
  public RecentAdapter(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, OnRecentUserOpsListener paramOnRecentUserOpsListener, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentOnRecentUserOpsListener = paramOnRecentUserOpsListener;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilList = new ArrayList(99);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentItemBuilderFactory = new RecentItemBuilderFactory(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentItemBuilderFactory.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder = new RecentFaceDecoder(paramQQAppInterface, this, paramBoolean);
    if (paramInt == 0) {
      this.jdField_b_of_type_Int = 0;
    }
    for (;;)
    {
      this.c = paramInt;
      return;
      if (paramInt == 1) {
        this.jdField_b_of_type_Int = 5;
      } else if (paramInt == 9) {
        this.jdField_b_of_type_Int = 11;
      } else if (paramInt == 10) {
        this.jdField_b_of_type_Int = 15;
      } else if (paramInt == 11) {
        this.jdField_b_of_type_Int = 17;
      }
    }
  }
  
  private void e() {}
  
  public RecentBaseData a(View paramView)
  {
    if ((paramView != null) && ((paramView.getTag(-1) instanceof Integer)))
    {
      paramView = getItem(((Integer)paramView.getTag(-1)).intValue());
      if ((paramView instanceof RecentBaseData)) {
        return (RecentBaseData)paramView;
      }
    }
    return null;
  }
  
  public DragFrameLayout a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  }
  
  public List a()
  {
    ArrayList localArrayList = new ArrayList();
    int j = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(i);
      if (localView != null)
      {
        localView = localView.findViewById(2131363189);
        if ((localView != null) && ((localView instanceof DragTextView)))
        {
          DragTextView localDragTextView = (DragTextView)localView;
          if ((localView.getVisibility() == 0) && (localDragTextView.a() != -1)) {
            localArrayList.add(localView);
          }
        }
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "setExtraFlag:" + paramInt);
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
  
  public void a(View paramView, RecentBaseData paramRecentBaseData)
  {
    a(paramView, paramRecentBaseData, null);
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Drawable paramDrawable)
  {
    if ((paramView == null) || (paramRecentBaseData == null)) {
      return;
    }
    Drawable localDrawable = paramDrawable;
    int i;
    if (paramDrawable == null)
    {
      i = paramRecentBaseData.a();
      if ((!(paramRecentBaseData instanceof RecentCallItem)) || (!((RecentCallItem)paramRecentBaseData).b())) {
        break label85;
      }
      i = 3002;
    }
    label85:
    for (;;)
    {
      localDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a(i, paramRecentBaseData.a());
      paramDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentItemBuilderFactory.a(paramRecentBaseData);
      if (paramDrawable == null) {
        break;
      }
      paramDrawable.a(paramView, paramRecentBaseData, this.jdField_a_of_type_AndroidContentContext, localDrawable);
      return;
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, MessageRecord paramMessageRecord, Drawable paramDrawable)
  {
    if ((paramView == null) || (paramMessageRecord == null)) {}
    Drawable localDrawable;
    do
    {
      return;
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.recent", 4, "updateSayHelloBoxItem|uin:" + paramMessageRecord.senderuin);
      }
      localDrawable = paramDrawable;
      if (paramDrawable == null) {
        localDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a(paramMessageRecord.istroop, paramMessageRecord.senderuin);
      }
      paramDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentItemBuilderFactory.a(paramRecentBaseData);
    } while ((paramDrawable == null) || (!(paramDrawable instanceof SayHelloBoxItemBuilder)));
    ((SayHelloBoxItemBuilder)paramDrawable).a(paramView, paramRecentBaseData, paramMessageRecord, localDrawable);
  }
  
  public void a(RecentBaseData paramRecentBaseData)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetXListView == null) || (paramRecentBaseData == null)) {
      return;
    }
    int j = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
    int i = 0;
    label22:
    View localView;
    RecentBaseData localRecentBaseData;
    if (i < j)
    {
      localView = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(i);
      localRecentBaseData = a(localView);
      if (localRecentBaseData != null) {
        break label57;
      }
    }
    label57:
    while (!localRecentBaseData.equals(paramRecentBaseData))
    {
      i += 1;
      break label22;
      break;
    }
    a(localView, localRecentBaseData);
  }
  
  public void a(RecentBaseData paramRecentBaseData, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentOnRecentUserOpsListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentOnRecentUserOpsListener.a(paramRecentBaseData, paramString);
    }
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramRecentBaseData);
      e();
      notifyDataSetChanged();
    }
  }
  
  public void a(RecentBaseData paramRecentBaseData, String paramString1, String paramString2)
  {
    if (Utils.a(paramString1, this.jdField_a_of_type_AndroidContentContext.getResources().getString(RecentItemBaseBuilder.a[0])))
    {
      i = paramRecentBaseData.a();
      if (i == 7220)
      {
        ReadInJoyUtils.a();
        PublicAccountReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80067CE", "0X80067CE", 0, 0, "", "", "", ReadInJoyUtils.c(), false);
      }
    }
    while (this.jdField_a_of_type_ComTencentMobileqqActivityRecentOnRecentUserOpsListener == null)
    {
      do
      {
        try
        {
          int i;
          paramString1 = (KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(161);
          paramString1.d();
          paramString1.c();
          a(paramRecentBaseData, paramString2);
          switch (i)
          {
          default: 
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "999", paramString2, "", "");
            return;
          }
        }
        catch (Exception paramString1)
        {
          for (;;)
          {
            QLog.d("Q.recent", 1, "clean kandian error" + paramString1);
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "0", "", paramString2, "");
          return;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "1", "", paramString2, "");
        return;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "2", "", paramString2, "");
        return;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "3", "", paramString2, "");
        if ((paramRecentBaseData instanceof RecentItemEcShop)) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Shop_lifeservice", "", "Shop_DelMsghelper", "Clk_DelshopItem", 0, 0, paramRecentBaseData.a(), "", paramRecentBaseData.b, "");
        }
        paramString1 = paramRecentBaseData.a();
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", paramString1, "0X80064C9", "0X80064C9", 0, 0, "" + paramRecentBaseData.c, "", "", "");
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", "", "0X80067EE", "0X80067EE", 0, 0, "" + paramRecentBaseData.a(), "", "", "");
      } while (!AppConstants.aH.equals(paramString1));
      WeishiReportUtil.a();
      return;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "4", "", paramString2, "");
      return;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "5", "", paramString2, "");
      return;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "6", "", paramString2, "");
      return;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "7", "", paramString2, "");
      return;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "8", "", paramString2, "");
      return;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "9", "", paramString2, "");
      return;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80050FC", "0X80050FC", 0, 0, "", "", "", "");
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "grp_lbs", "", "msg_box", "swipe_msg", 0, 0, "", "", "", "");
      return;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80050FE", "0X80050FE", 0, 0, "", "", "", "");
      return;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006353", "0X8006353", 0, 0, "", "", "", "");
      return;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", "0", "0X80064C5", "0X80064C5", 0, 0, "" + paramRecentBaseData.c, "", "", "");
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", "", "0X80067EE", "0X80067EE", 0, 0, "" + paramRecentBaseData.a(), "", "", "");
      return;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", "1", "0X80064C5", "0X80064C5", 0, 0, "" + paramRecentBaseData.c, "", "", "");
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", "", "0X80067EE", "0X80067EE", 0, 0, "" + paramRecentBaseData.a(), "", "", "");
      return;
      ReadinjoyReportUtils.a();
      return;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80090EB", "0X80090EB", 0, 0, "", "", "", "");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentOnRecentUserOpsListener.a(paramString1, paramRecentBaseData, paramString2);
  }
  
  public void a(DragFrameLayout paramDragFrameLayout)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = paramDragFrameLayout;
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this, true);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.setDragViewProvider(this);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a(paramQQAppInterface);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != paramQQAppInterface)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
      a(null);
      this.jdField_b_of_type_JavaUtilList = null;
    }
  }
  
  public void a(RecentUser paramRecentUser, StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2, StringBuilder paramStringBuilder3)
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramRecentUser.uin, 1008);
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = ((MessageRecord)localObject2).getExtInfoFromExtStr("gdt_msgClick");
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        str = "0";
        localObject2 = ((MessageRecord)localObject2).getExtInfoFromExtStr("pa_msgId");
        paramStringBuilder1.append((String)localObject2 + ",");
      }
    }
    try
    {
      localObject1 = new JSONObject((String)localObject1);
      paramStringBuilder1 = str;
      if (((JSONObject)localObject1).has("ad_id")) {
        paramStringBuilder1 = ((JSONObject)localObject1).getString("ad_id");
      }
    }
    catch (Exception paramStringBuilder1)
    {
      for (;;)
      {
        paramStringBuilder1 = str;
        if (QLog.isColorLevel())
        {
          QLog.i("Q.recent", 2, " parse ad_id error");
          paramStringBuilder1 = str;
        }
      }
    }
    paramStringBuilder2.append(paramStringBuilder1 + ",");
    paramStringBuilder3.append(paramRecentUser.uin + ",");
  }
  
  protected void a(String paramString)
  {
    ReportController.b(null, "dc00899", "Grp_video", "", "notice", "call", 0, 0, paramString, "" + TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString), "", "");
  }
  
  public void a(String paramString, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetXListView == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    int j = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
    int i = 0;
    label26:
    View localView;
    RecentBaseData localRecentBaseData;
    if (i < j)
    {
      localView = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(i);
      localRecentBaseData = a(localView);
      if ((localRecentBaseData != null) && (localRecentBaseData.a() == paramInt)) {
        break label71;
      }
    }
    label71:
    while (!Utils.a(localRecentBaseData.a(), paramString))
    {
      i += 1;
      break label26;
      break;
    }
    a(localView, localRecentBaseData);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetXListView == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    int j = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
    int i = 1;
    label26:
    View localView;
    RecentBaseData localRecentBaseData;
    if (i < j)
    {
      localView = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(i);
      localRecentBaseData = a(localView);
      if ((localRecentBaseData != null) && (Utils.a(paramString, localRecentBaseData.a()))) {
        break label74;
      }
    }
    label74:
    int k;
    do
    {
      i += 1;
      break label26;
      break;
      k = localRecentBaseData.a();
      if ((paramBoolean) && (k == 1))
      {
        a(localView, localRecentBaseData);
        return;
      }
    } while ((paramBoolean) || ((k != 0) && (k != 1000) && (k != 1020) && (k != 1003) && (k != 1025) && (k != 1029) && (k != 1005) && (k != 1004) && (k != 1008) && (k != 1001) && (k != 10002) && (k != 10004) && (k != 1009) && (k != 1023) && (k != 1024) && (k != 7000) && (k != 1010) && (k != 7220)));
    a(localView, localRecentBaseData);
  }
  
  public void a(List paramList)
  {
    Object localObject2 = null;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    d();
    Object localObject3;
    if ((this.jdField_a_of_type_ComTencentWidgetXListView instanceof SwipListView))
    {
      localObject3 = (SwipListView)this.jdField_a_of_type_ComTencentWidgetXListView;
      localObject1 = localObject2;
      if (this.jdField_a_of_type_Int >= 0)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_Int < this.jdField_a_of_type_JavaUtilList.size()) {
          localObject1 = this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int);
        }
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent", 4, "setDataList findsel, [" + this.jdField_a_of_type_Int + "," + localObject1 + "]");
      }
      this.jdField_a_of_type_Int = -1;
      localObject2 = localObject1;
    }
    for (Object localObject1 = localObject3;; localObject1 = null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      boolean bool;
      label364:
      label371:
      int i;
      int j;
      if (paramList != null)
      {
        try
        {
          paramList = paramList.iterator();
          while (paramList.hasNext())
          {
            localObject3 = (RecentBaseData)paramList.next();
            if (localObject3 == null) {
              break label522;
            }
            if (!RecentUtil.a((RecentBaseData)localObject3))
            {
              Object localObject4;
              if ((localObject3 instanceof RecentItemChatMsgData))
              {
                localObject4 = ((RecentItemChatMsgData)localObject3).a;
                if ((localObject4 != null) && (((RecentUser)localObject4).type == 1008) && (ServiceAccountFolderManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((RecentUser)localObject4).uin))) {}
              }
              else
              {
                if ((localObject3 instanceof RecentItemTroopMsgData))
                {
                  localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(true).a(((RecentItemTroopMsgData)localObject3).a.uin);
                  if (localObject4 != null)
                  {
                    WerewolvesPluginManager localWerewolvesPluginManager = ((WerewolvesHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(107)).a("");
                    if ((((HotChatInfo)localObject4).isGameRoom) || (((HotChatInfo)localObject4).troopUin.equals(localWerewolvesPluginManager.a))) {
                      continue;
                    }
                  }
                }
                this.jdField_a_of_type_JavaUtilList.add(localObject3);
              }
            }
          }
          if (localObject1 == null) {
            break label371;
          }
        }
        catch (Exception paramList) {}
        if (this.jdField_a_of_type_JavaUtilList.size() != 0) {
          break label540;
        }
        bool = false;
        localObject1.setDragEnable(bool);
        if ((localObject2 instanceof RecentBaseData))
        {
          paramList = (RecentBaseData)localObject2;
          i = Math.max(localObject1.getFirstVisiblePosition(), 0);
          j = Math.min(localObject1.getLastVisiblePosition() + 1, this.jdField_a_of_type_JavaUtilList.size());
        }
      }
      for (;;)
      {
        if (i < j)
        {
          if (!paramList.equals(this.jdField_a_of_type_JavaUtilList.get(i))) {
            break label546;
          }
          this.jdField_a_of_type_Int = i;
          if (QLog.isDevelopLevel()) {
            QLog.i("Q.recent", 4, "setDataList getsel, [" + i + "," + this.jdField_a_of_type_JavaUtilList.get(i) + "]");
          }
        }
        if ((localObject1 != null) && (this.jdField_a_of_type_Int == -1)) {
          localObject1.u();
        }
        notifyDataSetChanged();
        return;
        label522:
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("Q.recent", 2, "setDataList, [item is null]");
        break;
        label540:
        bool = true;
        break label364;
        label546:
        i += 1;
      }
      localObject2 = null;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a == null) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a.a();
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a.c();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a.a()) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a.b();
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    int j = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
    int i = 0;
    label76:
    RecentBaseData localRecentBaseData;
    if (i < j)
    {
      localRecentBaseData = a(this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(i));
      if (localRecentBaseData != null) {
        break label107;
      }
    }
    for (;;)
    {
      i += 1;
      break label76;
      break;
      label107:
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a(localRecentBaseData.a(), localRecentBaseData.a(), false);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    int i;
    Object localObject1;
    Object localObject2;
    MessageHandler localMessageHandler;
    Object localObject5;
    Object localObject3;
    Object localObject4;
    if (paramBoolean)
    {
      if (this.c == 0) {
        i = 1;
      }
      for (;;)
      {
        if (paramInt == 2)
        {
          if (i != 0)
          {
            paramDragFrameLayout = this.jdField_a_of_type_JavaUtilList.iterator();
            for (;;)
            {
              if (paramDragFrameLayout.hasNext())
              {
                localObject1 = paramDragFrameLayout.next();
                if (((localObject1 instanceof RecentBaseData)) && ((localObject1 instanceof RecentUserBaseData)))
                {
                  localObject1 = (RecentUserBaseData)localObject1;
                  if (((RecentUserBaseData)localObject1).c > 0)
                  {
                    localObject2 = ((RecentUserBaseData)localObject1).a();
                    RecentReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (RecentBaseData)localObject1, (RecentUser)localObject2, true);
                    continue;
                    i = 0;
                    break;
                  }
                }
              }
            }
          }
          paramDragFrameLayout = (EcShopAssistantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(87);
          if ((paramDragFrameLayout != null) && (paramDragFrameLayout.e))
          {
            paramDragFrameLayout.e = false;
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
            paramDragFrameLayout = (DragFrameLayout)localObject1;
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              paramDragFrameLayout = "noLogin";
            }
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("ecshop_sp" + paramDragFrameLayout, 0).edit().putBoolean("folder_reddot", false).commit();
          }
          localMessageHandler = (MessageHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(0);
          if (localMessageHandler != null) {
            localMessageHandler.e(false);
          }
          paramDragFrameLayout = null;
          localObject1 = null;
          localObject2 = null;
          Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
          if (localIterator.hasNext())
          {
            localObject5 = localIterator.next();
            if ((!(localObject5 instanceof RecentBaseData)) || (!(localObject5 instanceof RecentUserBaseData))) {
              break label2334;
            }
            localObject3 = (RecentUserBaseData)localObject5;
            if (((RecentUserBaseData)localObject3).c <= 0) {
              break label2334;
            }
            localObject4 = ((RecentUserBaseData)localObject3).a();
            ((RecentUserBaseData)localObject3).c();
            if (((RecentUser)localObject4).type != 1008) {
              break label2321;
            }
            if (paramDragFrameLayout != null) {
              break label2308;
            }
            localObject2 = new StringBuilder();
            localObject1 = new StringBuilder();
            paramDragFrameLayout = new StringBuilder();
            label360:
            a((RecentUser)localObject4, (StringBuilder)localObject2, (StringBuilder)localObject1, paramDragFrameLayout);
            label371:
            if ((localObject5 instanceof RecentItemTroopMsgData))
            {
              paramInt = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(((RecentUser)localObject4).uin);
              if ((paramInt == 2) || (paramInt == 4))
              {
                RecentUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (RecentUser)localObject4, true, false);
                localObject5 = localObject2;
                localObject4 = localObject1;
                localObject3 = paramDragFrameLayout;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      localObject2 = localObject3;
      localObject1 = localObject4;
      paramDragFrameLayout = (DragFrameLayout)localObject5;
      break;
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (localMessageHandler == null) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        RecentUtil.a((QQAppInterface)localObject3, (RecentUser)localObject4, paramBoolean, false);
        localObject3 = paramDragFrameLayout;
        localObject4 = localObject1;
        localObject5 = localObject2;
        break;
      }
      if ((localObject5 instanceof RecentItemTroopBarAssitant))
      {
        TroopBarAssistantManager.a().i(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        SubscriptRecommendController.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (localMessageHandler == null) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          RecentUtil.a((QQAppInterface)localObject3, (RecentUser)localObject4, paramBoolean, false);
          localObject3 = paramDragFrameLayout;
          localObject4 = localObject1;
          localObject5 = localObject2;
          break;
        }
      }
      if ((localObject5 instanceof RecentItemServiceAccountFolderData))
      {
        if (QLog.isColorLevel()) {
          QLog.d("RecentAdapter", 2, "clearServiceAccountFolderUnreadByTabRed");
        }
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (localMessageHandler == null) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          RecentUtil.a((QQAppInterface)localObject3, (RecentUser)localObject4, paramBoolean, false);
          ServiceAccountFolderManager.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, NetConnInfoCenter.getServerTime());
          localObject3 = paramDragFrameLayout;
          localObject4 = localObject1;
          localObject5 = localObject2;
          if (!PublicAccountConfigUtil.c) {
            break;
          }
          ServiceAccountFolderManager.a().e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          localObject3 = paramDragFrameLayout;
          localObject4 = localObject1;
          localObject5 = localObject2;
          break;
        }
      }
      if ((localObject5 instanceof SendBlessRecentItemData))
      {
        ThreadManager.post(new xhb(this), 5, null, true);
        localObject3 = paramDragFrameLayout;
        localObject4 = localObject1;
        localObject5 = localObject2;
      }
      else
      {
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (localMessageHandler == null) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          RecentUtil.a((QQAppInterface)localObject3, (RecentUser)localObject4, paramBoolean, false);
          localObject3 = paramDragFrameLayout;
          localObject4 = localObject1;
          localObject5 = localObject2;
          break;
        }
        if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.n)
        {
          localObject3 = (QCallFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37);
          if (localObject3 != null) {
            ((QCallFacade)localObject3).b(MessageCache.a());
          }
        }
        if (this.c == 0)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800419D", "0X800419D", 0, 0, "", "", "", "");
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80041A0", "0X80041A0", 0, 0, "", "", "", "");
          if (!TextUtils.isEmpty(paramDragFrameLayout)) {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", String.valueOf(localObject2), "0X8005C37", "0X8005C37", 0, 1, 0, String.valueOf(paramDragFrameLayout), String.valueOf(NetConnInfoCenter.getServerTime() * 1000L), "", String.valueOf(localObject1));
          }
        }
        ReadinjoySPEventReport.a().k();
        label1234:
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
                            int j;
                            do
                            {
                              do
                              {
                                do
                                {
                                  return;
                                  paramDragFrameLayout = paramDragFrameLayout.a();
                                } while (paramDragFrameLayout == null);
                                paramDragFrameLayout = (Integer)paramDragFrameLayout.getTag();
                              } while (paramDragFrameLayout == null);
                              j = paramDragFrameLayout.intValue();
                              paramDragFrameLayout = getItem(j);
                              if (QLog.isColorLevel()) {
                                QLog.d("Drag", 2, "onChange:" + paramDragFrameLayout);
                              }
                            } while (!(paramDragFrameLayout instanceof RecentBaseData));
                            localObject1 = (RecentBaseData)paramDragFrameLayout;
                            if ((i != 0) && ((paramDragFrameLayout instanceof RecentUserBaseData)))
                            {
                              localObject2 = ((RecentUserBaseData)paramDragFrameLayout).a();
                              RecentReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (RecentBaseData)localObject1, (RecentUser)localObject2, false);
                            }
                            if ((paramDragFrameLayout instanceof RecentItemTroopBarAssitant))
                            {
                              paramDragFrameLayout = (RecentItemTroopBarAssitant)paramDragFrameLayout;
                              paramDragFrameLayout.c();
                              TroopBarAssistantManager.a().i(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramDragFrameLayout.a(), paramDragFrameLayout.a());
                              return;
                            }
                            if ((paramDragFrameLayout instanceof RecentItemServiceAccountFolderData))
                            {
                              if (QLog.isColorLevel()) {
                                QLog.d("RecentAdapter", 2, "clearServiceAccountFolderUnreadByFolderRed, red dot switch:" + PublicAccountConfigUtil.b);
                              }
                              paramDragFrameLayout = (RecentItemServiceAccountFolderData)paramDragFrameLayout;
                              i = paramDragFrameLayout.c;
                              if (!PublicAccountConfigUtil.b)
                              {
                                paramDragFrameLayout.c();
                                ServiceAccountFolderManager.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, NetConnInfoCenter.getServerTime());
                                if (PublicAccountConfigUtil.c) {
                                  ServiceAccountFolderManager.a().e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                                }
                                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramDragFrameLayout.a(), paramDragFrameLayout.a());
                                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(true, 0);
                              }
                              if (PublicAccountConfigUtil.b)
                              {
                                paramInt = 1;
                                if (!paramDragFrameLayout.a()) {
                                  break label1234;
                                }
                              }
                              for (paramDragFrameLayout = "0";; paramDragFrameLayout = "1")
                              {
                                ThreadManager.executeOnSubThread(new xhc(this, paramInt, paramDragFrameLayout, String.valueOf(i), String.valueOf(j + 1)));
                                return;
                                paramInt = 0;
                                break;
                              }
                            }
                            if (!(paramDragFrameLayout instanceof RecentItemEcShopAssitant)) {
                              break;
                            }
                            paramDragFrameLayout = (RecentItemEcShopAssitant)paramDragFrameLayout;
                            paramDragFrameLayout.c();
                            RecentUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDragFrameLayout.a(), paramDragFrameLayout.a());
                            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramDragFrameLayout.a(), paramDragFrameLayout.a());
                            paramDragFrameLayout = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramDragFrameLayout.a(), 1008);
                          } while (paramDragFrameLayout == null);
                          localObject1 = (EcShopAssistantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(87);
                        } while (localObject1 == null);
                        ((EcShopAssistantManager)localObject1).a(paramDragFrameLayout.time);
                        return;
                        if (!(paramDragFrameLayout instanceof RecentUserBaseData)) {
                          break;
                        }
                        localObject1 = (RecentUserBaseData)paramDragFrameLayout;
                        localObject2 = ((RecentUserBaseData)localObject1).a();
                        if (((RecentUser)localObject2).type == 1008) {
                          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", "" + ((RecentUser)localObject2).uin, "0X80064CA", "0X80064CA", 0, 0, "" + ((RecentUserBaseData)localObject1).c, "", "", "");
                        }
                        ((RecentUserBaseData)localObject1).c();
                        RecentUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (RecentUser)localObject2, true, false);
                        if (this.c == 0) {
                          RecentUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (RecentUser)localObject2);
                        }
                        if ((paramDragFrameLayout instanceof SendBlessRecentItemData)) {
                          ((BlessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(137)).b(true);
                        }
                      } while ((((RecentUser)localObject2).type != 0) || (!Utils.b(((RecentUser)localObject2).uin)));
                      paramDragFrameLayout = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
                    } while (paramDragFrameLayout.getBoolean("babyQ_toast_flag", false));
                    i = paramDragFrameLayout.getInt("babyQ_drag_count", 0) + 1;
                    paramInt = i;
                    if (i >= 3)
                    {
                      DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, "babyQ提醒", "是否需要关闭babyQ的推送开关\n", "取消", "确定", new xhd(this), new xhe(this)).show();
                      paramInt = 0;
                      paramDragFrameLayout.edit().putBoolean("babyQ_toast_flag", true);
                    }
                    paramDragFrameLayout.edit().putInt("babyQ_drag_count", paramInt).commit();
                    return;
                    if (!(paramDragFrameLayout instanceof RecentTroopAssistantItem)) {
                      break;
                    }
                    paramDragFrameLayout = (RecentTroopAssistantItem)paramDragFrameLayout;
                    paramDragFrameLayout.c();
                    RecentUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDragFrameLayout.a(), paramDragFrameLayout.a());
                    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramDragFrameLayout.a(), paramDragFrameLayout.a());
                    paramDragFrameLayout = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramDragFrameLayout.a(), 1);
                  } while (paramDragFrameLayout == null);
                  TroopAssistantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDragFrameLayout.time);
                  return;
                  if (!(paramDragFrameLayout instanceof RecentItemEcShop)) {
                    break;
                  }
                  paramDragFrameLayout = (RecentItemEcShop)paramDragFrameLayout;
                  ReportController.b(null, "dc00899", "Pb_account_lifeservice", paramDragFrameLayout.a(), "0X80064D3", "0X80064D3", 0, 0, "" + paramDragFrameLayout.c, "", "", "");
                  paramDragFrameLayout.c();
                  RecentUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDragFrameLayout.a(), paramDragFrameLayout.a());
                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramDragFrameLayout.a(), paramDragFrameLayout.a());
                  paramDragFrameLayout = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramDragFrameLayout.a(), 1008);
                } while (paramDragFrameLayout == null);
                localObject1 = (EcShopAssistantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(87);
              } while (localObject1 == null);
              ((EcShopAssistantManager)localObject1).a(paramDragFrameLayout.time);
              return;
              if (!(paramDragFrameLayout instanceof RecentMsgBoxItem)) {
                break;
              }
              paramDragFrameLayout = (RecentMsgBoxItem)paramDragFrameLayout;
              paramDragFrameLayout.c();
              if (MsgProxyUtils.c(paramDragFrameLayout.a()))
              {
                ThreadManager.post(new xhf(this, paramDragFrameLayout.a(), paramDragFrameLayout.a()), 8, null, false);
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005298", "0X8005298", 0, 0, "", "", "", "");
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "grp_lbs", "", "msg_box", "drag_hi", 0, 0, "", "", "", "");
                return;
              }
              RecentUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDragFrameLayout.a(), paramDragFrameLayout.a());
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramDragFrameLayout.a(), paramDragFrameLayout.a());
              if (MsgProxyUtils.e(paramDragFrameLayout.a()))
              {
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "grp_lbs", "", "msg_box", "drag_update", 0, 0, "", "", "", "");
                return;
              }
            } while (!MsgProxyUtils.f(paramDragFrameLayout.a()));
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "grp_lbs", "", "msg_box", "drag_focus", 0, 0, "", "", "", "");
            return;
            if ((paramDragFrameLayout instanceof RecentSayHelloListItem))
            {
              paramDragFrameLayout = (RecentSayHelloListItem)paramDragFrameLayout;
              paramDragFrameLayout.c();
              RecentUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDragFrameLayout.a(), paramDragFrameLayout.a());
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramDragFrameLayout.a(), paramDragFrameLayout.a());
              return;
            }
            if (!(paramDragFrameLayout instanceof RecentHotchatItem)) {
              break;
            }
            paramDragFrameLayout = (RecentHotchatItem)paramDragFrameLayout;
            paramDragFrameLayout.c();
            RecentUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDragFrameLayout.a(), paramDragFrameLayout.a());
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramDragFrameLayout.a(), paramDragFrameLayout.a());
            paramDragFrameLayout = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramDragFrameLayout.a(), 1);
          } while (paramDragFrameLayout == null);
          ((HotChatCenterManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(254)).a(paramDragFrameLayout.time);
          return;
        } while (!(paramDragFrameLayout instanceof RecentItemConfessMsg));
        ConfessMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (RecentItemConfessMsg)paramDragFrameLayout, false);
        return;
        label2308:
        localObject3 = paramDragFrameLayout;
        paramDragFrameLayout = (DragFrameLayout)localObject2;
        localObject2 = localObject3;
        break label360;
        label2321:
        localObject3 = paramDragFrameLayout;
        paramDragFrameLayout = (DragFrameLayout)localObject2;
        localObject2 = localObject3;
        break label371;
        label2334:
        localObject3 = localObject2;
        localObject4 = localObject1;
        localObject5 = paramDragFrameLayout;
      }
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentWidgetXListView instanceof SwipListView);
  }
  
  public List b()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return new ArrayList(this.jdField_a_of_type_JavaUtilList);
    }
    return null;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  public void b(RecentBaseData paramRecentBaseData)
  {
    if ((paramRecentBaseData != null) && (paramRecentBaseData.a() == 8) && (paramRecentBaseData.g == 25))
    {
      localObject = (PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
      if ((localObject == null) || (paramRecentBaseData.f == null)) {
        break label104;
      }
    }
    label104:
    for (Object localObject = ((PhoneContactManager)localObject).c(paramRecentBaseData.f);; localObject = null)
    {
      if (localObject != null) {
        paramRecentBaseData.b = ((PhoneContact)localObject).name;
      }
      do
      {
        return;
        localObject = ((QCallCardManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(139)).a(paramRecentBaseData.a());
      } while (localObject == null);
      paramRecentBaseData.b = ((QCallCardInfo)localObject).nickname;
      return;
    }
  }
  
  public boolean b()
  {
    return (c()) || (this.jdField_a_of_type_JavaUtilList.size() == 0);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.b();
    }
  }
  
  protected boolean c()
  {
    return (this.jdField_b_of_type_Int == 3) || (this.jdField_b_of_type_Int == 8);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null)
    {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a();
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = null;
    }
  }
  
  public void e(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      FrameHelperActivity.b(paramBoolean);
      return;
    }
  }
  
  public int getCount()
  {
    if ((c()) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      return 1;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    try
    {
      if ((c()) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
        return Integer.valueOf(this.jdField_b_of_type_Int);
      }
      if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size()))
      {
        Object localObject = this.jdField_a_of_type_JavaUtilList.get(paramInt);
        return localObject;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, localException.toString());
      }
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    Object localObject = getItem(paramInt);
    return this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentItemBuilderFactory.a(localObject);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = getItem(paramInt);
    RecentItemBaseBuilder localRecentItemBaseBuilder = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentItemBuilderFactory.a(localObject);
    if ((localObject instanceof RecentBaseData))
    {
      localObject = (RecentBaseData)localObject;
      b((RecentBaseData)localObject);
      return localRecentItemBaseBuilder.a(paramInt, localObject, this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder, paramView, paramViewGroup, this.jdField_a_of_type_AndroidContentContext, this, this, this);
    }
    if ((localObject instanceof Integer)) {
      return localRecentItemBaseBuilder.a(paramInt, localObject, null, paramView, paramViewGroup, this.jdField_a_of_type_AndroidContentContext, this, this, this);
    }
    if ((localObject instanceof String)) {
      return localRecentItemBaseBuilder.a(paramInt, localObject, null, paramView, paramViewGroup, this.jdField_a_of_type_AndroidContentContext, null, null, null);
    }
    return localRecentItemBaseBuilder.a(paramInt, localObject, null, paramView, paramViewGroup, this.jdField_a_of_type_AndroidContentContext, null, null, null);
  }
  
  public int getViewTypeCount()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentItemBuilderFactory.b();
  }
  
  public void onClick(View paramView)
  {
    if (paramView == null) {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent", 4, "RecentAdpater onClick v is null");
      }
    }
    label395:
    label442:
    do
    {
      Object localObject;
      do
      {
        do
        {
          do
          {
            for (;;)
            {
              return;
              if (Utils.a("tag_swip_icon_menu_item", paramView.getTag()))
              {
                localObject = paramView.getTag(-1);
                paramView = paramView.getTag(-2);
                if ((!(localObject instanceof Integer)) || (!(paramView instanceof Integer)))
                {
                  if (!QLog.isDevelopLevel()) {
                    continue;
                  }
                  QLog.i("Q.recent", 4, "RecentAdpater onClick tag is not int");
                  return;
                }
                i = ((Integer)localObject).intValue();
                int j = ((Integer)paramView).intValue();
                try
                {
                  paramView = this.jdField_a_of_type_AndroidContentContext.getResources().getString(j);
                  localObject = getItem(i);
                  if (QLog.isDevelopLevel()) {
                    QLog.i("Q.recent", 4, "onClick|obj = " + localObject + ", " + paramView);
                  }
                  if ((paramView != null) && ((localObject instanceof RecentBaseData)))
                  {
                    a((RecentBaseData)localObject, paramView, "2");
                    return;
                  }
                }
                catch (Exception paramView)
                {
                  for (;;)
                  {
                    if (QLog.isDevelopLevel()) {
                      QLog.i("Q.recent", 4, paramView.toString());
                    }
                    paramView = null;
                  }
                }
              }
            }
            if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentOnRecentUserOpsListener == null) {
              break label442;
            }
            localObject = paramView.getTag(-1);
            if ((localObject instanceof Integer)) {
              break;
            }
          } while (!QLog.isDevelopLevel());
          QLog.i("Q.recent", 4, "RecentAdpater onClick tag is not int");
          return;
          int i = ((Integer)localObject).intValue();
          localObject = getItem(i);
          if (QLog.isDevelopLevel()) {
            QLog.i("Q.recent", 4, "onClick|obj = " + localObject);
          }
          if (!(localObject instanceof RecentBaseData)) {
            break;
          }
          if (((paramView instanceof IRecentImgv)) && ((localObject instanceof RecentItemEcShop))) {
            this.jdField_a_of_type_ComTencentMobileqqActivityRecentOnRecentUserOpsListener.a(paramView, localObject);
          }
          for (;;)
          {
            if (!(localObject instanceof RecentItemTroopMsgData)) {
              break label395;
            }
            paramView = (RecentItemTroopMsgData)localObject;
            if ((paramView == null) || (!paramView.b)) {
              break;
            }
            a(paramView.a());
            return;
            RecentBaseData localRecentBaseData = (RecentBaseData)localObject;
            localRecentBaseData.i = i;
            this.jdField_a_of_type_ComTencentMobileqqActivityRecentOnRecentUserOpsListener.a(paramView, localRecentBaseData, localRecentBaseData.b, true);
          }
        } while (!(localObject instanceof RecentTroopAssistantItem));
        paramView = (RecentTroopAssistantItem)localObject;
      } while ((paramView == null) || (!paramView.b));
      a(paramView.a());
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentOnRecentUserOpsListener.a(paramView, localObject);
      return;
    } while (!QLog.isDevelopLevel());
    QLog.i("Q.recent", 4, "onClick|mRecentLis is null");
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetXListView == null) || (TextUtils.isEmpty(paramString))) {
      break label14;
    }
    label14:
    while ((paramBitmap == null) && (paramInt1 > 0)) {
      return;
    }
    if (paramBitmap != null) {
      this.jdField_a_of_type_JavaUtilHashtable.put(paramInt2 + ":" + paramString, paramBitmap);
    }
    long l = System.currentTimeMillis();
    boolean bool1;
    if ((this.jdField_a_of_type_Long > 0L) && (l - this.jdField_a_of_type_Long > 300L))
    {
      bool1 = true;
      label94:
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder().append("RecentAdapter.onDecodeTaskCompleted type=").append(paramInt2).append(", uin=").append(paramString).append(", remainingTasks=").append(paramInt1).append(", isdecodeFaceTimeout=").append(bool1).append(", avatar == null ? | ");
        if (paramBitmap != null) {
          break label236;
        }
      }
    }
    label236:
    for (boolean bool2 = true;; bool2 = false)
    {
      QLog.d("RecentAdapter", 2, bool2 + ",style | " + this.c);
      if ((paramInt1 > 0) && (!bool1)) {
        break;
      }
      synchronized (this.jdField_a_of_type_JavaUtilHashtable)
      {
        if (this.jdField_a_of_type_JavaUtilHashtable.size() != 0) {
          break label242;
        }
        return;
      }
      bool1 = false;
      break label94;
    }
    label242:
    if (paramInt1 == 0)
    {
      this.jdField_a_of_type_Long = 0L;
      bool1 = false;
      paramInt2 = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
      paramInt1 = 0;
    }
    for (;;)
    {
      if (paramInt1 < paramInt2)
      {
        View localView = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(paramInt1);
        RecentBaseData localRecentBaseData = a(localView);
        if (localRecentBaseData == null)
        {
          break label812;
          this.jdField_a_of_type_Long = l;
          break;
        }
        int i = localRecentBaseData.a();
        i = ((Integer)RecentFaceDecoder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, localRecentBaseData.a()).first).intValue();
        if (i == -2147483648) {
          break label812;
        }
        if ((localRecentBaseData instanceof RecentSayHelloBoxItem))
        {
          paramBitmap = ((RecentSayHelloBoxItem)localRecentBaseData).jdField_a_of_type_JavaUtilList;
          paramString = ((RecentSayHelloBoxItem)localRecentBaseData).jdField_a_of_type_JavaLangObject;
          if (paramBitmap != null) {
            try
            {
              if (paramBitmap.size() > 0)
              {
                paramBitmap = new LinkedList(paramBitmap).iterator();
                while (paramBitmap.hasNext())
                {
                  MessageRecord localMessageRecord = (MessageRecord)paramBitmap.next();
                  Object localObject = i + ":" + localMessageRecord.senderuin;
                  localObject = (Bitmap)this.jdField_a_of_type_JavaUtilHashtable.get(localObject);
                  if (localObject != null) {
                    a(localView, localRecentBaseData, localMessageRecord, new BitmapDrawable(BaseApplication.getContext().getResources(), (Bitmap)localObject));
                  }
                }
              }
            }
            finally {}
          }
          break label812;
        }
        paramString = i + ":" + localRecentBaseData.a();
        paramString = (Bitmap)this.jdField_a_of_type_JavaUtilHashtable.get(paramString);
        if (paramString == null) {
          break label812;
        }
        if (i == 103)
        {
          l = System.currentTimeMillis();
          paramBitmap = BaseApplication.getContext().getResources().getDrawable(2130839192);
          if ((paramBitmap instanceof SkinnableBitmapDrawable)) {
            ((SkinnableBitmapDrawable)paramBitmap).setGravity(81);
          }
          if ((paramBitmap instanceof BitmapDrawable)) {
            ((BitmapDrawable)paramBitmap).setGravity(81);
          }
          paramBitmap.setBounds(0, 0, paramBitmap.getIntrinsicWidth(), paramBitmap.getIntrinsicHeight());
          paramBitmap = new LayerDrawable(new Drawable[] { new BitmapDrawable(BaseApplication.getContext().getResources(), paramString), paramBitmap });
          paramString = paramBitmap;
          if (QLog.isDevelopLevel()) {
            QLog.i("Q.recent", 4, "onDecodeTaskCompleted, subaccount cost = " + (System.currentTimeMillis() - l));
          }
        }
        for (paramString = paramBitmap;; paramString = new BitmapDrawable(BaseApplication.getContext().getResources(), paramString))
        {
          a(localView, localRecentBaseData, paramString);
          bool1 = true;
          break;
        }
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent", 4, "decodecomplete|faceCache size = " + this.jdField_a_of_type_JavaUtilHashtable.size() + ", isNeedUpdateAvatar=" + bool1);
      }
      this.jdField_a_of_type_JavaUtilHashtable.clear();
      return;
      label812:
      paramInt1 += 1;
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentItemBuilderFactory != null) {}
    for (int i = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentItemBuilderFactory.a(); (i == 0) && (FrameHelperActivity.a()); i = 0) {
      return false;
    }
    if (paramView == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent", 4, "RecentAdpater onLongClick v is null");
      }
      return false;
    }
    Object localObject1 = paramView.getTag(-1);
    if (!(localObject1 instanceof Integer))
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent", 4, "RecentAdpater onLongClick tag is not int");
      }
      return false;
    }
    int j = ((Integer)localObject1).intValue();
    localObject1 = getItem(j);
    if ((localObject1 instanceof RecentBaseData)) {}
    for (localObject1 = (RecentBaseData)localObject1;; localObject1 = null)
    {
      if (localObject1 == null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("Q.recent", 4, "RecentAdpater onLongClick item is null, pos = " + j);
        }
        return false;
      }
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentItemBuilderFactory.a(localObject1);
      if (((RecentBaseData)localObject1).a() == 1)
      {
        i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(((RecentBaseData)localObject1).a());
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "right", 0, 0, ((RecentBaseData)localObject1).a(), String.valueOf(i - 1), "", "");
      }
      if ("9970".equals(((RecentBaseData)localObject1).a())) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Shop_lifeservice", "", "Shop_folder", "Press_Shopfolderlong", 0, 0, "", "", "", "");
      }
      paramView.setSelected(true);
      if (localObject2 != null) {}
      for (localObject1 = ((RecentItemBaseBuilder)localObject2).a((RecentBaseData)localObject1, this.jdField_a_of_type_AndroidContentContext);; localObject1 = null)
      {
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          localObject2 = new QQCustomMenu();
          i = 0;
          while (i < ((List)localObject1).size())
          {
            ((QQCustomMenu)localObject2).a(j, (String)((List)localObject1).get(i));
            i += 1;
          }
          try
          {
            this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = BubbleContextMenu.a(paramView, (QQCustomMenu)localObject2, this.jdField_a_of_type_AndroidViewView$OnClickListener, new xha(this, paramView));
            return true;
          }
          catch (Throwable paramView)
          {
            paramView.printStackTrace();
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("Q.recent", 2, "long click showAsDropDown", paramView);
          return false;
        }
        if (QLog.isDevelopLevel()) {
          QLog.i("Q.recent", 4, "RecentAdpater onLongClick no menu, builder = " + localObject2);
        }
        return false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentAdapter
 * JD-Core Version:    0.7.0.1
 */