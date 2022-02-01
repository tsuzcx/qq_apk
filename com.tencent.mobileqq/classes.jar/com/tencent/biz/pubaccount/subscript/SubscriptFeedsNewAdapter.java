package com.tencent.biz.pubaccount.subscript;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.mobileqq.activity.recent.RecentFaceDecoder;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.feeds.api.IRIJKanDianFolderStatus;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SubscriptionFeed;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SubscriptionFeedItem;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.CustomWidgetUtil;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class SubscriptFeedsNewAdapter
  extends BaseAdapter
  implements DecodeTaskCompletionListener
{
  public static int a = 0;
  public static int b = 1;
  public static int c = 0;
  public static int d = 1;
  private static int e = 3;
  private Context f;
  private Resources g;
  private QQAppInterface h;
  private XListView i;
  private LayoutInflater j;
  private RecentFaceDecoder k;
  private DragFrameLayout l;
  private List<SubscriptionFeed> m = new ArrayList();
  private List<Object> n = new ArrayList();
  private HashSet<String> o = new HashSet();
  private int p = 0;
  private HashMap<String, Bitmap> q = new HashMap();
  private float r = 0.0F;
  private float s = 0.0F;
  private float t = 0.0F;
  private float u = 0.0F;
  private boolean v = false;
  private boolean w = false;
  private View.OnClickListener x;
  private List<SubscriptFeedsNewAdapter.Msg210Feed> y = new ArrayList();
  
  public SubscriptFeedsNewAdapter(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, LayoutInflater paramLayoutInflater)
  {
    this.f = paramContext;
    this.g = this.f.getResources();
    this.h = paramQQAppInterface;
    this.i = paramXListView;
    this.j = paramLayoutInflater;
    this.k = new RecentFaceDecoder(paramQQAppInterface, this, false);
    this.r = this.f.getResources().getDimension(2131298740);
    this.s = this.f.getResources().getDimension(2131298742);
    this.t = this.f.getResources().getDimension(2131298741);
    this.u = this.f.getResources().getDimension(2131298739);
    b();
  }
  
  private void a(SubscriptFeedsNewAdapter.FeedItemCellHolder paramFeedItemCellHolder, String paramString)
  {
    Bitmap localBitmap = (Bitmap)this.q.get(paramString);
    if (localBitmap == null)
    {
      paramFeedItemCellHolder.c.setImageDrawable(this.k.a(1008, paramString));
      return;
    }
    paramFeedItemCellHolder.c.setImageBitmap(localBitmap);
  }
  
  public void a()
  {
    if (!this.o.isEmpty())
    {
      ReportController.b(null, "CliOper", "", "", "0X8006110", "0X8006110", 0, this.o.size(), 0, "", "", "", "");
      Iterator localIterator = this.o.iterator();
      while (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        String str1;
        try
        {
          Object localObject = new JSONObject();
          ((JSONObject)localObject).put("folder_status", ((IRIJKanDianFolderStatus)QRoute.api(IRIJKanDianFolderStatus.class)).getReportFolderStatus());
          localObject = ((JSONObject)localObject).toString();
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
          str1 = "";
        }
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, str2, "0X80081C7", "0X80081C7", 0, 0, "", "", "", str1, false);
      }
    }
    int i1 = this.p;
    if (i1 > 0) {
      ReportController.b(null, "CliOper", "", "", "0X8006154", "0X8006154", 0, i1, 0, "", "", "", "");
    }
    if (this.w) {
      ReportController.b(this.h, "CliOper", "", "", "0X8006431", "0X8006431", 0, 0, "", "", "", "");
    }
    this.o.clear();
    this.o = null;
    this.l = null;
    this.k.b();
    this.j = null;
    this.i = null;
    this.q.clear();
    this.q = null;
    this.g = null;
    this.f = null;
    this.y.clear();
    this.y = null;
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.x = paramOnClickListener;
  }
  
  public void a(DragFrameLayout paramDragFrameLayout)
  {
    this.l = paramDragFrameLayout;
  }
  
  public void a(List<SubscriptionFeed> paramList)
  {
    if (paramList == null) {
      return;
    }
    this.m.clear();
    this.m.addAll(paramList);
  }
  
  public void b()
  {
    if (this.y.size() > 0) {
      this.y.clear();
    }
    ArrayList localArrayList = new ArrayList();
    this.y.addAll(localArrayList);
  }
  
  public void c()
  {
    this.n.clear();
    this.n.addAll(this.y);
    this.n.addAll(this.m);
  }
  
  public int getCount()
  {
    return this.n.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.n.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    int i1 = e;
    Object localObject = this.n.get(paramInt);
    if ((localObject instanceof SubscriptionFeed)) {
      return a;
    }
    paramInt = i1;
    if ((localObject instanceof SubscriptFeedsNewAdapter.Msg210Feed)) {
      paramInt = b;
    }
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    if ((paramInt >= 0) && (paramInt < this.n.size()))
    {
      int i2 = getItemViewType(paramInt);
      Object localObject2;
      Object localObject3;
      int i1;
      if (paramView == null)
      {
        if (i2 == a)
        {
          localObject2 = new SubscriptFeedsNewAdapter.FeedItemCellHolder(this);
          localObject1 = this.j.inflate(2131626444, null);
          ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject2).b = ((ViewGroup)((View)localObject1).findViewById(2131446595));
          ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject2).c = ((ImageView)((View)localObject1).findViewById(2131446609));
          ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject2).d = ((TextView)((View)localObject1).findViewById(2131446614));
          ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject2).e = ((TextView)((View)localObject1).findViewById(2131444602));
          ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject2).f = ((DragTextView)((View)localObject1).findViewById(2131449123));
          ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject2).g = ((TextView)((View)localObject1).findViewById(2131432993));
          ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject2).h = ((Button)((View)localObject1).findViewById(2131438143));
          ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject2).i = ((Button)((View)localObject1).findViewById(2131438112));
          ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject2).b.setOnClickListener(this.x);
          ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject2).f.setDragViewType(0, (View)localObject1);
          ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject2).f.setOnModeChangeListener(this.l);
          ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject2).h.setOnClickListener(this.x);
          ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject2).i.setOnClickListener(this.x);
          localObject3 = ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject2).g;
          if (this.v)
          {
            paramView = this.g;
            i1 = 2131166832;
          }
          else
          {
            paramView = this.g;
            i1 = 2131166837;
          }
          ((TextView)localObject3).setTextColor(paramView.getColor(i1));
          localObject3 = ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject2).d;
          if (this.v)
          {
            paramView = this.g;
            i1 = 2131166838;
          }
          else
          {
            paramView = this.g;
            i1 = 2131166831;
          }
          ((TextView)localObject3).setTextColor(paramView.getColor(i1));
          localObject3 = ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject2).e;
          if (this.v)
          {
            paramView = this.g;
            i1 = 2131166841;
          }
          else
          {
            paramView = this.g;
            i1 = 2131166840;
          }
          ((TextView)localObject3).setTextColor(paramView.getColor(i1));
          paramView = (View)localObject2;
          localObject2 = paramView;
        }
        else
        {
          if (i2 == b) {
            localObject1 = this.j.inflate(2131626029, null);
          } else {
            localObject1 = paramView;
          }
          localObject2 = null;
        }
        paramView = (View)localObject1;
        if (localObject1 != null)
        {
          paramView = (View)localObject1;
          if (localObject2 != null)
          {
            ((View)localObject1).setTag(localObject2);
            paramView = (View)localObject1;
          }
        }
      }
      if (paramView == null)
      {
        localObject1 = null;
      }
      else
      {
        if (i2 == a)
        {
          paramView.setTag(2131446601, Integer.valueOf(paramInt));
          localObject2 = (SubscriptFeedsNewAdapter.FeedItemCellHolder)paramView.getTag();
          localObject3 = (SubscriptionFeed)getItem(paramInt);
          localObject1 = this.o;
          if (localObject1 != null) {
            ((HashSet)localObject1).add(((SubscriptionFeed)localObject3).c);
          }
          ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject2).a = ((SubscriptionFeed)localObject3).c;
          a((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject2, ((SubscriptionFeed)localObject3).c);
          localObject1 = TroopBarAssistantManager.a().a(((SubscriptionFeed)localObject3).c);
          if (TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject1 = TroopBarAssistantManager.a().e(((SubscriptionFeed)localObject3).c, this.h);
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
              ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject2).d.setText((CharSequence)localObject1);
            } else {
              ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject2).d.setText(((SubscriptionFeed)localObject3).c);
            }
          }
          else
          {
            ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject2).d.setText((CharSequence)localObject1);
          }
          ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject2).e.setText(TimeManager.a().a(((SubscriptionFeed)localObject3).c, ((SubscriptionFeed)localObject3).d));
          if (((SubscriptionFeed)localObject3).b > 0) {
            i1 = 3;
          } else {
            i1 = 0;
          }
          CustomWidgetUtil.a(((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject2).f, i1, ((SubscriptionFeed)localObject3).b, 2130852592, 99, null);
          if (((SubscriptionFeed)localObject3).e.size() > 0)
          {
            SubscriptionFeedItem localSubscriptionFeedItem = (SubscriptionFeedItem)((SubscriptionFeed)localObject3).e.get(0);
            if (localSubscriptionFeedItem.a == 0)
            {
              ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject2).g.setMaxLines(1);
              ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject2).g.setText(new QQText(localSubscriptionFeedItem.d.replaceFirst("^\\s+", ""), 3, 20));
            }
            else if (localSubscriptionFeedItem.a == 1)
            {
              ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject2).g.setMaxLines(2);
              ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject2).g.setText(localSubscriptionFeedItem.c.replaceFirst("^\\s+", ""));
            }
            else if (localSubscriptionFeedItem.a == 2)
            {
              ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject2).g.setMaxLines(1);
              ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject2).g.setText(2131894286);
            }
            else
            {
              ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject2).g.setMaxLines(1);
              ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject2).g.setText(2131894287);
            }
          }
          else if ((QLog.isColorLevel()) && (QLog.isColorLevel()))
          {
            QLog.w("SubscriptFeedsNewAdapter", 2, "getView feed.mItems.size() == 0, is error!!");
          }
          ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject2).b.setTag(2131446598, Integer.valueOf(((SubscriptionFeed)localObject3).b));
          ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject2).b.setTag(2131446607, ((SubscriptionFeed)localObject3).c);
          ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject2).b.setTag(2131446600, localObject1);
          ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject2).b.setTag(2131446599, Integer.valueOf(c));
          ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject2).b.setTag(localObject3);
          ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject2).f.setTag(2131446598, localObject3);
          ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject2).h.setTag(2131446607, ((SubscriptionFeed)localObject3).c);
          ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject2).h.setTag(2131446600, localObject1);
          ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject2).i.setTag(2131446607, ((SubscriptionFeed)localObject3).c);
          paramView.setTag(-3, Integer.valueOf((int)(this.t + this.u)));
        }
        else if (i2 == b)
        {
          localObject1 = (SubscriptFeedsNewAdapter.Msg210Feed)getItem(paramInt);
          ((TextView)paramView.findViewById(2131438911)).setText(((SubscriptFeedsNewAdapter.Msg210Feed)localObject1).a);
          ((ImageView)paramView.findViewById(2131438910)).setImageDrawable(((SubscriptFeedsNewAdapter.Msg210Feed)localObject1).b);
          localObject2 = (DragTextView)paramView.findViewById(2131449123);
          ((DragTextView)localObject2).setDragViewType(0, paramView);
          if (((SubscriptFeedsNewAdapter.Msg210Feed)localObject1).c > 0) {
            i1 = 3;
          } else {
            i1 = 0;
          }
          CustomWidgetUtil.a((TextView)localObject2, i1, ((SubscriptFeedsNewAdapter.Msg210Feed)localObject1).c, 2130852592, 99, null);
          if (((SubscriptFeedsNewAdapter.Msg210Feed)localObject1).c > 0) {
            paramView.findViewById(2131428790).setVisibility(8);
          }
          localObject2 = (ViewGroup)paramView.findViewById(2131438909);
          ((ViewGroup)localObject2).setTag(2131446599, Integer.valueOf(d));
          ((ViewGroup)localObject2).setTag(2131446833, ((SubscriptFeedsNewAdapter.Msg210Feed)localObject1).d);
          ((ViewGroup)localObject2).setTag(2131444210, Integer.valueOf(((SubscriptFeedsNewAdapter.Msg210Feed)localObject1).e));
          ((ViewGroup)localObject2).setTag(2131444211, Integer.valueOf(((SubscriptFeedsNewAdapter.Msg210Feed)localObject1).c));
          ((ViewGroup)localObject2).setOnClickListener(this.x);
        }
        localObject1 = paramView;
      }
    }
    else
    {
      localObject1 = null;
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localObject1;
  }
  
  public int getViewTypeCount()
  {
    return e;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (this.i != null) && (paramString != null))
    {
      if (paramString.length() == 0) {
        return;
      }
      this.q.put(paramString, paramBitmap);
      paramInt2 = this.i.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        paramBitmap = this.i.getChildAt(paramInt1).getTag();
        if ((paramBitmap != null) && ((paramBitmap instanceof SubscriptFeedsNewAdapter.FeedItemCellHolder)))
        {
          paramBitmap = (SubscriptFeedsNewAdapter.FeedItemCellHolder)paramBitmap;
          if (paramString.equals(paramBitmap.a)) {
            a(paramBitmap, paramString);
          }
        }
        paramInt1 += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.subscript.SubscriptFeedsNewAdapter
 * JD-Core Version:    0.7.0.1
 */