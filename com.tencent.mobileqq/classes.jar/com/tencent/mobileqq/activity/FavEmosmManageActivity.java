package com.tencent.mobileqq.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.FavEmoRoamingHandler;
import com.tencent.mobileqq.app.FavEmoRoamingObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emosm.favroaming.FavEmoConstant;
import com.tencent.mobileqq.emosm.favroaming.FavroamingDBManager;
import com.tencent.mobileqq.emosm.favroaming.FavroamingManager;
import com.tencent.mobileqq.emosm.favroaming.SyncListener;
import com.tencent.mobileqq.emosm.vipcomic.VipComicMqqManager;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.FavoriteEmoticonInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.GridView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;
import sju;
import sjw;
import sjx;
import sjy;
import sjz;
import ska;
import skb;

public class FavEmosmManageActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, View.OnClickListener, AdapterView.OnItemClickListener
{
  int jdField_a_of_type_Int;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new sju(this);
  public Handler a;
  Button jdField_a_of_type_AndroidWidgetButton;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  FavEmosmManageActivity.FavEmoAdapter jdField_a_of_type_ComTencentMobileqqActivityFavEmosmManageActivity$FavEmoAdapter;
  FavEmoRoamingObserver jdField_a_of_type_ComTencentMobileqqAppFavEmoRoamingObserver = new sjz(this);
  public FavroamingDBManager a;
  SyncListener jdField_a_of_type_ComTencentMobileqqEmosmFavroamingSyncListener = new sjx(this);
  GridView jdField_a_of_type_ComTencentWidgetGridView;
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  public List a;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean();
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int;
  Button jdField_b_of_type_AndroidWidgetButton;
  public List b;
  boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int = 0;
  private Button jdField_c_of_type_AndroidWidgetButton;
  
  public FavEmosmManageActivity()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
  }
  
  void a()
  {
    Object localObject = getResources();
    int i = ((Resources)localObject).getDisplayMetrics().widthPixels;
    int j = AIOUtils.a(0.0F, (Resources)localObject);
    int k = AIOUtils.a(4.0F, (Resources)localObject);
    int m = AIOUtils.a(4.0F, (Resources)localObject);
    this.jdField_a_of_type_Int = ((i - j * 2 - k * 3) / 4);
    this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
    this.rightViewText.setVisibility(0);
    this.rightViewText.setText(2131438006);
    this.rightViewText.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131364490));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131364491));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131364493));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131364492));
    this.jdField_a_of_type_ComTencentWidgetGridView = ((GridView)super.findViewById(2131364494));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetGridView.setScrollBarStyle(0);
    this.jdField_a_of_type_ComTencentWidgetGridView.setNumColumns(4);
    this.jdField_a_of_type_ComTencentWidgetGridView.setColumnWidth(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentWidgetGridView.setHorizontalSpacing(k);
    this.jdField_a_of_type_ComTencentWidgetGridView.setVerticalSpacing(m);
    this.jdField_a_of_type_ComTencentWidgetGridView.setPadding(j, this.jdField_a_of_type_ComTencentWidgetGridView.getPaddingTop(), j, this.jdField_a_of_type_ComTencentWidgetGridView.getPaddingBottom());
    this.jdField_a_of_type_ComTencentWidgetGridView.setOnItemClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetGridView.setMaximumVelocity((int)(2500.0F * getResources().getDisplayMetrics().density));
    boolean bool = super.getIntent().getBooleanExtra("extra_key_from_web", false);
    this.jdField_a_of_type_Boolean = bool;
    this.jdField_b_of_type_Boolean = bool;
    if (this.jdField_a_of_type_Boolean)
    {
      localObject = super.getIntent().getStringArrayListExtra("extra_key_pkgids");
      ArrayList localArrayList1 = super.getIntent().getStringArrayListExtra("extra_key_paths");
      ArrayList localArrayList2 = super.getIntent().getStringArrayListExtra("extra_key_md5s");
      j = super.getIntent().getIntExtra("extra_key_faile_count", 0);
      if ((localObject != null) && (localArrayList1 != null) && (localArrayList2 != null))
      {
        i = Math.min(((List)localObject).size(), localArrayList1.size());
        k = Math.min(localArrayList2.size(), i);
        i = 0;
        while (i < k)
        {
          FavoriteEmoticonInfo localFavoriteEmoticonInfo = new FavoriteEmoticonInfo();
          localFavoriteEmoticonInfo.c = ((String)((List)localObject).get(i));
          localFavoriteEmoticonInfo.d = ((String)localArrayList1.get(i));
          localFavoriteEmoticonInfo.a = ((String)localArrayList2.get(i));
          this.jdField_a_of_type_JavaUtilList.add(localFavoriteEmoticonInfo);
          i += 1;
        }
      }
      this.rightViewText.setText(2131434920);
      if (this.leftView != null) {
        this.leftView.setVisibility(8);
      }
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      if (j > 0) {
        QQToast.a(this, j + "个下载失败", 0).a();
      }
    }
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)findViewById(2131364489));
    this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_c_of_type_Int == 0)
    {
      paramAdapterView = ((FavEmosmManageActivity.FavEmoAdapter.Holder)paramView.getTag()).a.getDrawable();
      if ((paramAdapterView instanceof URLDrawable))
      {
        paramAdapterView = (URLDrawable)paramAdapterView;
        if ((paramAdapterView.getStatus() == 3) || (paramAdapterView.getStatus() == 2)) {
          paramAdapterView.restartDownload();
        }
      }
      return;
    }
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > paramInt))
    {
      if (((Byte)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).byteValue() != 0) {
        break label114;
      }
      this.jdField_a_of_type_JavaUtilArrayList.set(paramInt, Byte.valueOf((byte)1));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityFavEmosmManageActivity$FavEmoAdapter.notifyDataSetChanged();
      e();
      return;
      label114:
      this.jdField_a_of_type_JavaUtilArrayList.set(paramInt, Byte.valueOf((byte)0));
    }
  }
  
  public void a(List paramList)
  {
    if ((paramList == null) || (paramList.size() < 1)) {
      return;
    }
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      paramList.addAll(this.jdField_a_of_type_JavaUtilList);
    }
    if (paramList.size() > 0) {
      paramList.remove(0);
    }
    int j = paramList.size();
    int i = 0;
    while (i < paramList.size())
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(Byte.valueOf((byte)0));
      i += 1;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityFavEmosmManageActivity$FavEmoAdapter = new FavEmosmManageActivity.FavEmoAdapter(this, paramList);
    this.jdField_a_of_type_ComTencentWidgetGridView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityFavEmosmManageActivity$FavEmoAdapter);
    if (j - 1 - FavEmoConstant.jdField_a_of_type_Int > 0) {
      this.jdField_c_of_type_Int = 1;
    }
    e();
  }
  
  void b()
  {
    ((FavroamingDBManager)this.app.getManager(148)).a(new sjw(this));
  }
  
  public void b(List paramList)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityFavEmosmManageActivity$FavEmoAdapter == null) || (paramList == null) || (paramList.size() < 1)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if (paramList.size() > 0) {
      paramList.remove(0);
    }
    if (paramList.size() > 0)
    {
      int i = 0;
      while (i < paramList.size())
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(Byte.valueOf((byte)0));
        i += 1;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityFavEmosmManageActivity$FavEmoAdapter.a(paramList);
    this.jdField_a_of_type_ComTencentMobileqqActivityFavEmosmManageActivity$FavEmoAdapter.notifyDataSetChanged();
    e();
  }
  
  public void c()
  {
    ((FavroamingDBManager)this.app.getManager(148)).a(new sjy(this));
  }
  
  void d()
  {
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size()) {
      if (((Byte)this.jdField_a_of_type_JavaUtilArrayList.get(i)).byteValue() != 1) {}
    }
    for (i = 0;; i = 1)
    {
      Object localObject1;
      if (i != 0)
      {
        this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFavEmoRoamingObserver);
        localObject1 = (FavEmoRoamingHandler)this.app.a(72);
        if (localObject1 != null)
        {
          ((FavEmoRoamingHandler)localObject1).a(this.jdField_b_of_type_JavaUtilList, false);
          if (QLog.isColorLevel()) {
            QLog.d("FavEmoRoamingHandler", 2, "-------start delfav---------delResid=" + this.jdField_b_of_type_JavaUtilList.toString());
          }
          ReportController.b(this.app, "CliOper", "", "", "0X8005CF2", "0X8005CF2", 0, 0, this.jdField_b_of_type_JavaUtilList.size() + "", "", "", "");
        }
      }
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
      {
        localObject1 = this.app.getHandler(ChatActivity.class);
        if (localObject1 != null) {
          ((MqqHandler)localObject1).obtainMessage(10).sendToTarget();
        }
        return;
        i += 1;
        break;
      }
      Object localObject2;
      int j;
      label281:
      Object localObject3;
      if ((this.jdField_a_of_type_Boolean) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityFavEmosmManageActivity$FavEmoAdapter.jdField_a_of_type_JavaUtilList;
        int k = Math.min(this.jdField_a_of_type_JavaUtilArrayList.size(), ((List)localObject1).size());
        i = 0;
        localObject2 = new ArrayList();
        j = 0;
        if (j < k)
        {
          localObject3 = (Byte)this.jdField_a_of_type_JavaUtilArrayList.get(j);
          if (localObject3 == null) {
            break label569;
          }
          if (((Byte)localObject3).byteValue() != 0) {}
        }
      }
      label569:
      for (;;)
      {
        j += 1;
        break label281;
        localObject3 = (EmoticonInfo)((List)localObject1).get(j);
        if (localObject3 != null)
        {
          ((List)localObject2).add(localObject3);
          i += 1;
          continue;
          ThreadManager.post(new ska(this, (List)localObject2), 5, null, true);
          ReportController.b(this.app, "CliOper", "", "", "0X8005C79", "0X8005C79", 0, 0, String.valueOf(i), "", "", "");
          this.jdField_a_of_type_Boolean = false;
          localObject1 = this.app.getHandler(ChatActivity.class);
          if (localObject1 != null) {
            ((MqqHandler)localObject1).obtainMessage(10).sendToTarget();
          }
          QQToast.a(this, "趣图已添加至收藏面板", 0).a();
          localObject1 = (VipComicMqqManager)this.app.getManager(140);
          i = 0;
          if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
          {
            if (((Byte)this.jdField_a_of_type_JavaUtilArrayList.get(i)).byteValue() == 0) {}
            do
            {
              i += 1;
              break;
              localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityFavEmosmManageActivity$FavEmoAdapter.getItem(i);
            } while (localObject2 == null);
            ThreadManager.post(new skb(this, localObject2, (VipComicMqqManager)localObject1, i), 5, null, false);
            return;
          }
          localObject1 = this.app.getHandler(ChatActivity.class);
          if (localObject1 == null) {
            break;
          }
          ((MqqHandler)localObject1).obtainMessage(10).sendToTarget();
          return;
        }
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130968966);
    super.setTitle(2131438010);
    this.jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingFavroamingDBManager = ((FavroamingDBManager)this.app.getManager(148));
    ((FavroamingManager)this.app.getManager(102)).a(this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingSyncListener);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    a();
    b();
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      paramBundle = new IntentFilter("com.tencent.mobileqq.action.update.emotiom");
      getApplicationContext().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_AndroidOsHandler = null;
    this.jdField_b_of_type_JavaUtilList.clear();
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      getApplicationContext().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
    if (this.jdField_b_of_type_Boolean) {
      getApplicationContext().sendBroadcast(new Intent("com.tencent.mobileqq.action.update.emotiom"));
    }
    ((FavroamingManager)this.app.getManager(102)).b(this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingSyncListener);
    if (this.jdField_a_of_type_ComTencentMobileqqAppFavEmoRoamingObserver != null) {
      this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFavEmoRoamingObserver);
    }
  }
  
  void e()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityFavEmosmManageActivity$FavEmoAdapter == null) || (this.jdField_a_of_type_JavaUtilArrayList == null)) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFavEmosmManageActivity$FavEmoAdapter.getCount() > 0)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      this.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#00a5e0"));
    }
    Object localObject;
    int i;
    for (;;)
    {
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      for (i = 0; ((Iterator)localObject).hasNext(); i = ((Byte)((Iterator)localObject).next()).byteValue() + i) {}
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      this.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#cccccc"));
    }
    if (this.jdField_a_of_type_Boolean)
    {
      if (i >= 0)
      {
        this.jdField_b_of_type_AndroidWidgetButton.setEnabled(true);
        return;
      }
      this.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
      return;
    }
    if (i > 0) {
      this.jdField_b_of_type_AndroidWidgetButton.setEnabled(true);
    }
    for (;;)
    {
      localObject = String.format(getString(2131438008), new Object[] { Integer.valueOf(i) });
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      this.jdField_b_of_type_AndroidWidgetButton.setText(getString(2131438005));
      return;
      this.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 207)
    {
      i = ((Integer)paramMessage.obj).intValue();
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > i)) {
        this.jdField_a_of_type_JavaUtilArrayList.remove(i);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityFavEmosmManageActivity$FavEmoAdapter != null) {}
    }
    while ((paramMessage.what != 206) || (this.jdField_a_of_type_ComTencentMobileqqActivityFavEmosmManageActivity$FavEmoAdapter == null))
    {
      int i;
      return false;
      this.jdField_a_of_type_ComTencentMobileqqActivityFavEmosmManageActivity$FavEmoAdapter.a(i);
      this.jdField_a_of_type_ComTencentMobileqqActivityFavEmosmManageActivity$FavEmoAdapter.notifyDataSetChanged();
      e();
      d();
      return false;
    }
    b((List)paramMessage.obj);
    return false;
  }
  
  protected boolean onBackEvent()
  {
    ReportController.b(this.app, "CliOper", "", "", "ep_mall", "0X80057D4", 0, 0, "", "", "", "");
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131363410: 
    case 2131364491: 
    case 2131364493: 
      do
      {
        do
        {
          do
          {
            return;
            if (this.jdField_b_of_type_Boolean)
            {
              ReportController.b(this.app, "CliOper", "", "", "0X8005C7A", "0X8005C7A", 0, 0, "", "", "", "");
              super.onBackEvent();
              return;
            }
          } while (this.jdField_a_of_type_ComTencentMobileqqActivityFavEmosmManageActivity$FavEmoAdapter == null);
          if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0)
          {
            this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
            this.rightViewText.setText(2131438006);
            this.jdField_c_of_type_Int = 0;
            this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
            i = 0;
            while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
            {
              this.jdField_a_of_type_JavaUtilArrayList.set(i, Byte.valueOf((byte)0));
              i += 1;
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityFavEmosmManageActivity$FavEmoAdapter.notifyDataSetChanged();
            e();
            ReportController.b(this.app, "CliOper", "", "", "ep_mall", "0X80057D5", 0, 0, "", "", "", "");
            return;
          }
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          this.rightViewText.setText(2131438007);
          this.jdField_c_of_type_Int = 1;
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
          this.jdField_a_of_type_ComTencentMobileqqActivityFavEmosmManageActivity$FavEmoAdapter.notifyDataSetChanged();
          ReportController.b(this.app, "CliOper", "", "", "ep_mall", "0X80057D3", 0, 0, "", "", "", "");
          return;
        } while (this.jdField_a_of_type_ComTencentMobileqqActivityFavEmosmManageActivity$FavEmoAdapter == null);
        int i = 0;
        while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          this.jdField_a_of_type_JavaUtilArrayList.set(i, Byte.valueOf((byte)1));
          i += 1;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityFavEmosmManageActivity$FavEmoAdapter.notifyDataSetChanged();
        e();
        ReportController.b(this.app, "CliOper", "", "", "ep_mall", "0X80057D6", 0, 0, "", "", "", "");
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityFavEmosmManageActivity$FavEmoAdapter == null);
      d();
      ReportController.b(this.app, "CliOper", "", "", "ep_mall", "0X80057D7", 0, 0, "", "", "", "");
      return;
    }
    VasH5PayUtil.a(this.app, this, "mvip.n.a.bqsc_edit", 3, "1450000516", "CJCLUBT", getString(2131436926), "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FavEmosmManageActivity
 * JD-Core Version:    0.7.0.1
 */