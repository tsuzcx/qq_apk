package com.tencent.mobileqq.activity.aio;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.core.FriendChatPie;
import com.tencent.mobileqq.app.BabyQHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XEditTextEx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class BabyQAIOPanel
  extends FrameLayout
  implements View.OnClickListener
{
  private BabyQAIOPanel.PanelDataAdapter a;
  private GridView b;
  private ArrayList<BabyQAIOPanel.GridItemData> c = new ArrayList();
  private QQAppInterface d;
  private Context e;
  private FriendChatPie f;
  
  public BabyQAIOPanel(@NonNull Context paramContext)
  {
    super(paramContext);
    this.e = paramContext;
  }
  
  public BabyQAIOPanel(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.e = paramContext;
  }
  
  private void b()
  {
    this.c.clear();
    BabyQHandler localBabyQHandler = (BabyQHandler)this.d.getBusinessHandler(BusinessHandlerFactory.BABY_Q_HANDLER);
    if ((localBabyQHandler.a != null) && (!localBabyQHandler.a.isEmpty()) && (localBabyQHandler.b != null) && (!localBabyQHandler.b.isEmpty()))
    {
      Iterator localIterator = localBabyQHandler.b.iterator();
      int i = 1;
      while (localIterator.hasNext())
      {
        Object localObject1 = (String)localIterator.next();
        Object localObject2;
        String str;
        Object localObject3;
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject2 = (String[])localBabyQHandler.a.get(localObject1);
          if ((localObject2 != null) && (localObject2.length == 2))
          {
            str = localObject2[0];
            localObject3 = localObject2[1];
          }
        }
        try
        {
          int j = Integer.parseInt(str);
          localObject2 = new BabyQAIOPanel.GridItemData();
          ((BabyQAIOPanel.GridItemData)localObject2).a = ((String)localObject1);
          ((BabyQAIOPanel.GridItemData)localObject2).d = j;
          ((BabyQAIOPanel.GridItemData)localObject2).c = "1".equalsIgnoreCase((String)localObject3);
          ((BabyQAIOPanel.GridItemData)localObject2).b = localBabyQHandler.c(j);
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("loadDatas | item.drawable is :");
            if (((BabyQAIOPanel.GridItemData)localObject2).b == null) {
              str = "null";
            } else {
              str = "not null";
            }
            ((StringBuilder)localObject3).append(str);
            ((StringBuilder)localObject3).append(", itemCode : ");
            ((StringBuilder)localObject3).append(j);
            QLog.d("Q.BabyQ", 2, ((StringBuilder)localObject3).toString());
          }
          if (((BabyQAIOPanel.GridItemData)localObject2).b != null) {
            this.c.add(localObject2);
          }
          for (;;)
          {
            i = 0;
            break;
            if (((String)localObject1).equalsIgnoreCase(this.d.getApp().getResources().getString(2131887760)))
            {
              ((BabyQAIOPanel.GridItemData)localObject2).b = this.d.getApp().getResources().getDrawable(2130839274);
              this.c.add(localObject2);
            }
            else if (((String)localObject1).equalsIgnoreCase(this.d.getApp().getResources().getString(2131887758)))
            {
              ((BabyQAIOPanel.GridItemData)localObject2).b = this.d.getApp().getResources().getDrawable(2130839272);
              this.c.add(localObject2);
            }
            else
            {
              if (!((String)localObject1).equalsIgnoreCase(this.d.getApp().getResources().getString(2131887759))) {
                break;
              }
              ((BabyQAIOPanel.GridItemData)localObject2).b = this.d.getApp().getResources().getDrawable(2130839273);
              this.c.add(localObject2);
            }
          }
        }
        catch (Exception localException)
        {
          label460:
          break label460;
        }
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("initDatas|get item code error :  ");
          ((StringBuilder)localObject1).append(str);
          QLog.d("Q.BabyQ", 2, ((StringBuilder)localObject1).toString());
        }
      }
      if (i != 0) {
        c();
      }
    }
    else
    {
      c();
    }
  }
  
  private void c()
  {
    BabyQAIOPanel.GridItemData localGridItemData = new BabyQAIOPanel.GridItemData();
    localGridItemData.c = false;
    localGridItemData.d = 1;
    localGridItemData.a = this.d.getApp().getResources().getString(2131887758);
    localGridItemData.b = this.d.getApp().getResources().getDrawable(2130839272);
    this.c.add(localGridItemData);
    localGridItemData = new BabyQAIOPanel.GridItemData();
    localGridItemData.c = false;
    localGridItemData.d = 2;
    localGridItemData.a = this.d.getApp().getResources().getString(2131887759);
    localGridItemData.b = this.d.getApp().getResources().getDrawable(2130839273);
    this.c.add(localGridItemData);
    localGridItemData = new BabyQAIOPanel.GridItemData();
    localGridItemData.c = false;
    localGridItemData.d = 3;
    localGridItemData.a = this.d.getApp().getResources().getString(2131887760);
    localGridItemData.b = this.d.getApp().getResources().getDrawable(2130839274);
    this.c.add(localGridItemData);
  }
  
  public void a()
  {
    b();
    BabyQAIOPanel.PanelDataAdapter localPanelDataAdapter = this.a;
    if (localPanelDataAdapter != null) {
      localPanelDataAdapter.notifyDataSetChanged();
    }
  }
  
  public void a(FriendChatPie paramFriendChatPie)
  {
    this.d = paramFriendChatPie.i();
    this.f = paramFriendChatPie;
    setBackgroundColor(this.e.getResources().getColor(2131166015));
    this.b = ((GridView)findViewById(2131434389));
    this.b.setNumColumns(2);
    b();
    this.a = new BabyQAIOPanel.PanelDataAdapter(this);
    this.b.setAdapter(this.a);
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject != null) && ((localObject instanceof BabyQAIOPanel.GridItemViewHolder)))
    {
      localObject = (BabyQAIOPanel.GridItemViewHolder)paramView.getTag();
      String str = ((BabyQAIOPanel.GridItemViewHolder)localObject).b.getText().toString();
      this.f.Y.append(str);
      this.f.ax();
      BabyQHandler localBabyQHandler = (BabyQHandler)this.d.getBusinessHandler(BusinessHandlerFactory.BABY_Q_HANDLER);
      if (localBabyQHandler.a(str))
      {
        localBabyQHandler.b(str);
        a();
      }
      ReportController.b(this.d, "dc00898", "", "", "0X800806D", "0X800806D", ((BabyQAIOPanel.GridItemViewHolder)localObject).e, 0, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.BabyQAIOPanel
 * JD-Core Version:    0.7.0.1
 */