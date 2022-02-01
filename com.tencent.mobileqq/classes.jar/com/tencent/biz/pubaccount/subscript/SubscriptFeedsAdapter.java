package com.tencent.biz.pubaccount.subscript;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.recent.RecentFaceDecoder;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.kandian.base.image.api.IPublicAccountHttpDownloader;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SubscriptionFeed;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SubscriptionFeedItem;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.CustomWidgetUtil;
import com.tencent.widget.XListView;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class SubscriptFeedsAdapter
  extends BaseAdapter
  implements SubscriptPicManager.ImageHostListener, DecodeTaskCompletionListener
{
  public static int a = 0;
  public static int b = 1;
  public static int c = 2;
  public static int d = 0;
  public static int e = 1;
  private static int j = 3;
  private float A = 0.0F;
  private float B = 0.0F;
  private float C = 0.0F;
  private float D = 0.0F;
  private boolean E = false;
  private boolean F = false;
  private View.OnClickListener G;
  public int f = -1;
  public boolean g = false;
  public int h = -1;
  public boolean i = false;
  private final int k = 10;
  private Activity l;
  private Resources m;
  private QQAppInterface n;
  private XListView o;
  private LayoutInflater p;
  private RecentFaceDecoder q;
  private DragFrameLayout r;
  private SubscriptPicManager s;
  private SubscriptRecommendController t;
  private List<SubscriptionFeed> u = new ArrayList();
  private List<ReadInJoyArticle> v = new ArrayList();
  private List<Object> w = new ArrayList();
  private HashSet<String> x = new HashSet();
  private int y = 0;
  private HashMap<String, Bitmap> z = new HashMap();
  
  public SubscriptFeedsAdapter(Activity paramActivity, QQAppInterface paramQQAppInterface, XListView paramXListView, LayoutInflater paramLayoutInflater)
  {
    this.l = paramActivity;
    this.m = this.l.getResources();
    this.n = paramQQAppInterface;
    this.o = paramXListView;
    this.p = paramLayoutInflater;
    this.q = new RecentFaceDecoder(paramQQAppInterface, this, false);
    this.E = ThemeUtil.isInNightMode(paramQQAppInterface);
    this.A = this.l.getResources().getDimension(2131298740);
    this.B = this.l.getResources().getDimension(2131298742);
    this.C = this.l.getResources().getDimension(2131298741);
    this.D = this.l.getResources().getDimension(2131298739);
  }
  
  private void a(SubscriptFeedsAdapter.FeedItemCellHolder paramFeedItemCellHolder, String paramString)
  {
    Bitmap localBitmap = (Bitmap)this.z.get(paramString);
    if (localBitmap == null)
    {
      paramFeedItemCellHolder.c.setImageDrawable(this.q.a(1008, paramString));
      return;
    }
    paramFeedItemCellHolder.c.setImageBitmap(localBitmap);
  }
  
  public void a()
  {
    if (!this.x.isEmpty()) {
      ReportController.b(null, "CliOper", "", "", "0X8006110", "0X8006110", 0, this.x.size(), 0, "", "", "", "");
    }
    int i1 = this.y;
    if (i1 > 0) {
      ReportController.b(null, "CliOper", "", "", "0X8006154", "0X8006154", 0, i1, 0, "", "", "", "");
    }
    if (this.F) {
      ReportController.b(this.n, "CliOper", "", "", "0X8006431", "0X8006431", 0, 0, "", "", "", "");
    }
    this.x.clear();
    this.x = null;
    this.r = null;
    this.s = null;
    this.t = null;
    this.q.b();
    this.p = null;
    this.o = null;
    this.z.clear();
    this.z = null;
    this.m = null;
    this.l = null;
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.G = paramOnClickListener;
  }
  
  public void a(SubscriptPicManager paramSubscriptPicManager)
  {
    this.s = paramSubscriptPicManager;
  }
  
  public void a(SubscriptRecommendController paramSubscriptRecommendController)
  {
    this.t = paramSubscriptRecommendController;
  }
  
  public void a(DragFrameLayout paramDragFrameLayout)
  {
    this.r = paramDragFrameLayout;
  }
  
  public void a(List<SubscriptionFeed> paramList)
  {
    if (paramList == null) {
      return;
    }
    this.u.clear();
    this.u.addAll(paramList);
  }
  
  public boolean a(ImageView paramImageView)
  {
    boolean bool2 = paramImageView.getTag(2131446606).equals(Integer.valueOf(b));
    boolean bool1 = true;
    if (bool2) {
      return true;
    }
    if (paramImageView.getTag(2131446606).equals(Integer.valueOf(a)))
    {
      int i2 = this.o.getChildCount();
      int i1 = 0;
      while (i1 < i2)
      {
        Object localObject = this.o.getChildAt(i1).getTag();
        if ((localObject != null) && ((localObject instanceof SubscriptFeedsAdapter.FeedItemCellHolder)) && (((SubscriptFeedsAdapter.FeedItemCellHolder)localObject).a.equals(paramImageView.getTag(2131446607)))) {
          return true;
        }
        i1 += 1;
      }
      bool1 = false;
    }
    return bool1;
  }
  
  public void b()
  {
    int i1 = this.f;
    int i3 = 0;
    if ((i1 == 1) && (this.g)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i2 = i3;
    if (this.h == 1)
    {
      i2 = i3;
      if (this.i) {
        i2 = 1;
      }
    }
    this.w.clear();
    this.w.addAll(this.u);
    if ((i1 != 0) && (this.v.size() > 0)) {
      if (this.w.size() <= 6) {
        this.w.add("ReadInJoyArticle");
      } else {
        this.w.add(6, "ReadInJoyArticle");
      }
    }
    if (i2 != 0)
    {
      if (this.w.size() <= 3)
      {
        this.w.add("SubscriptRecommendController");
        return;
      }
      this.w.add(3, "SubscriptRecommendController");
    }
  }
  
  public void b(List<ReadInJoyArticle> paramList)
  {
    if (paramList == null) {
      return;
    }
    this.v.clear();
    this.v.addAll(paramList);
  }
  
  public int getCount()
  {
    return this.w.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.w.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    int i1 = j;
    Object localObject = this.w.get(paramInt);
    if ((localObject instanceof SubscriptionFeed)) {
      return a;
    }
    boolean bool = localObject instanceof String;
    if ((bool) && (localObject.equals("SubscriptRecommendController"))) {
      return c;
    }
    paramInt = i1;
    if (bool)
    {
      paramInt = i1;
      if (localObject.equals("ReadInJoyArticle")) {
        paramInt = b;
      }
    }
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramInt >= 0) && (paramInt < this.w.size()))
    {
      int i3 = getItemViewType(paramInt);
      int i2 = 0;
      Object localObject3;
      int i1;
      if (paramView == null)
      {
        if (i3 == a)
        {
          localObject1 = new SubscriptFeedsAdapter.FeedItemCellHolder(this);
          localObject2 = this.p.inflate(2131626443, null);
          ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject1).b = ((ViewGroup)((View)localObject2).findViewById(2131446595));
          ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject1).c = ((ImageView)((View)localObject2).findViewById(2131446609));
          ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject1).d = ((TextView)((View)localObject2).findViewById(2131446614));
          ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject1).e = ((TextView)((View)localObject2).findViewById(2131444602));
          ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject1).f = ((DragTextView)((View)localObject2).findViewById(2131449123));
          ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject1).g = ((TextView)((View)localObject2).findViewById(2131432993));
          ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject1).h = ((ImageView)((View)localObject2).findViewById(2131432965));
          ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject1).i = ((ImageView)((View)localObject2).findViewById(2131432969));
          ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject1).j = ((Button)((View)localObject2).findViewById(2131438138));
          ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject1).k = ((Button)((View)localObject2).findViewById(2131438144));
          ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject1).l = ((Button)((View)localObject2).findViewById(2131438143));
          ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject1).m = ((Button)((View)localObject2).findViewById(2131438112));
          ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject1).b.setOnClickListener(this.G);
          ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject1).f.setDragViewType(0, (View)localObject2);
          ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject1).f.setOnModeChangeListener(this.r);
          ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject1).j.setOnClickListener(this.G);
          ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject1).k.setOnClickListener(this.G);
          ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject1).l.setOnClickListener(this.G);
          ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject1).m.setOnClickListener(this.G);
          localObject3 = ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject1).g;
          if (this.E)
          {
            paramView = this.m;
            i1 = 2131166832;
          }
          else
          {
            paramView = this.m;
            i1 = 2131166831;
          }
          ((TextView)localObject3).setTextColor(paramView.getColor(i1));
          localObject3 = ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject1).d;
          if (this.E)
          {
            paramView = this.m;
            i1 = 2131166838;
          }
          else
          {
            paramView = this.m;
            i1 = 2131166837;
          }
          ((TextView)localObject3).setTextColor(paramView.getColor(i1));
          localObject3 = ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject1).e;
          if (this.E)
          {
            paramView = this.m;
            i1 = 2131166841;
          }
          else
          {
            paramView = this.m;
            i1 = 2131166840;
          }
          ((TextView)localObject3).setTextColor(paramView.getColor(i1));
          paramView = (View)localObject2;
        }
        else if (i3 == b)
        {
          localObject1 = new SubscriptFeedsAdapter.KandianItemCellHolder(this, null);
          paramView = this.p.inflate(2131626445, null);
          ((SubscriptFeedsAdapter.KandianItemCellHolder)localObject1).a = ((ViewGroup)paramView.findViewById(2131436730));
          ((SubscriptFeedsAdapter.KandianItemCellHolder)localObject1).a.setOnClickListener(this.G);
          localObject2 = (TextView)((SubscriptFeedsAdapter.KandianItemCellHolder)localObject1).a.findViewById(2131436731);
          if (!this.E) {
            i1 = 2130844310;
          } else {
            i1 = 2130844311;
          }
          ((TextView)localObject2).setCompoundDrawablesWithIntrinsicBounds(0, 0, i1, 0);
          ((SubscriptFeedsAdapter.KandianItemCellHolder)localObject1).b.add((ViewGroup)paramView.findViewById(2131436716));
          ((SubscriptFeedsAdapter.KandianItemCellHolder)localObject1).b.add((ViewGroup)paramView.findViewById(2131436717));
          ((SubscriptFeedsAdapter.KandianItemCellHolder)localObject1).b.add((ViewGroup)paramView.findViewById(2131436718));
          ((SubscriptFeedsAdapter.KandianItemCellHolder)localObject1).b.add((ViewGroup)paramView.findViewById(2131436719));
          int i4 = ((SubscriptFeedsAdapter.KandianItemCellHolder)localObject1).b.size();
          localObject2 = this.m;
          if (!this.E) {
            i1 = 2131166847;
          } else {
            i1 = 2131166848;
          }
          int i5 = ((Resources)localObject2).getColor(i1);
          i1 = 0;
          while (i1 < i4)
          {
            localObject2 = (ViewGroup)((SubscriptFeedsAdapter.KandianItemCellHolder)localObject1).b.get(i1);
            ((ViewGroup)localObject2).setOnClickListener(this.G);
            ((ViewGroup)localObject2).setTag(Integer.valueOf(i1));
            ((TextView)((ViewGroup)localObject2).findViewById(2131428812)).setTextColor(i5);
            i1 += 1;
          }
          paramView.setTag(-3, Integer.valueOf(0));
        }
        else if (i3 == c)
        {
          localObject1 = new SubscriptFeedsAdapter.SubscriptRecommendHolder(this, null);
          paramView = this.p.inflate(2131626447, null);
          this.t.a(paramView);
          this.t.b();
          this.t.i();
          paramView.setTag(-3, Integer.valueOf(0));
          this.F = true;
        }
        else
        {
          localObject1 = null;
        }
        if (paramView != null) {
          paramView.setTag(localObject1);
        }
      }
      if (paramView != null)
      {
        Object localObject4;
        Object localObject5;
        if (i3 == a)
        {
          paramView.setTag(2131446601, Integer.valueOf(paramInt));
          localObject4 = (SubscriptFeedsAdapter.FeedItemCellHolder)paramView.getTag();
          localObject1 = (SubscriptionFeed)getItem(paramInt);
          localObject2 = this.x;
          if (localObject2 != null) {
            ((HashSet)localObject2).add(((SubscriptionFeed)localObject1).c);
          }
          ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).a = ((SubscriptionFeed)localObject1).c;
          a((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4, ((SubscriptionFeed)localObject1).c);
          localObject3 = TroopBarAssistantManager.a().a(((SubscriptionFeed)localObject1).c);
          if (TextUtils.isEmpty((CharSequence)localObject3)) {
            ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).d.setText(((SubscriptionFeed)localObject1).c);
          } else {
            ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).d.setText((CharSequence)localObject3);
          }
          ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).e.setText(TimeManager.a().a(((SubscriptionFeed)localObject1).c, ((SubscriptionFeed)localObject1).d));
          if (((SubscriptionFeed)localObject1).b > 0) {
            i1 = 3;
          } else {
            i1 = 0;
          }
          CustomWidgetUtil.a(((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).f, i1, ((SubscriptionFeed)localObject1).b, 2130852592, 99, null);
          if (((SubscriptionFeed)localObject1).e.size() > 0)
          {
            localObject2 = (SubscriptionFeedItem)((SubscriptionFeed)localObject1).e.get(0);
            if (((SubscriptionFeedItem)localObject2).a == 0)
            {
              ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).g.setMaxLines(1);
              ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).g.setText(new QQText(((SubscriptionFeedItem)localObject2).d.replaceFirst("^\\s+", ""), 3, 20));
              ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).h.setVisibility(8);
              ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).i.setVisibility(8);
            }
            else
            {
              if (((SubscriptionFeedItem)localObject2).a == 1)
              {
                ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).g.setMaxLines(2);
                ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).g.setText(((SubscriptionFeedItem)localObject2).c.replaceFirst("^\\s+", ""));
                ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).h.setVisibility(0);
                if (TextUtils.isEmpty(((SubscriptionFeedItem)localObject2).i)) {
                  ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).i.setVisibility(8);
                } else {
                  ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).i.setVisibility(0);
                }
                ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).h.setTag(2131446607, ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).a);
                ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).h.setTag(2131446606, Integer.valueOf(a));
                localObject5 = ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).h.getLayoutParams();
                this.s.a(((IPublicAccountHttpDownloader)QRoute.api(IPublicAccountHttpDownloader.class)).makeURL(((SubscriptionFeedItem)localObject2).b, 1, ((SubscriptionFeed)localObject1).c), ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).h, ((ViewGroup.LayoutParams)localObject5).width, ((ViewGroup.LayoutParams)localObject5).height, this);
                if ((((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).h.getDrawable() instanceof URLDrawable))
                {
                  localObject2 = (URLDrawable)((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).h.getDrawable();
                  if (paramInt >= 10) {
                    ((URLDrawable)localObject2).setAutoDownload(false);
                  }
                }
              }
              else
              {
                if (((SubscriptionFeedItem)localObject2).a != 2) {
                  break label1538;
                }
                ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).g.setMaxLines(1);
                ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).g.setText(2131894286);
                ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).h.setVisibility(0);
                ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).i.setVisibility(8);
                ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).h.setTag(2131446607, ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).a);
                ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).h.setTag(2131446606, Integer.valueOf(a));
                localObject5 = ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).h.getLayoutParams();
                this.s.a(((IPublicAccountHttpDownloader)QRoute.api(IPublicAccountHttpDownloader.class)).makeURL(((SubscriptionFeedItem)localObject2).h.toString(), 1, ((SubscriptionFeed)localObject1).c), ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).h, ((ViewGroup.LayoutParams)localObject5).width, ((ViewGroup.LayoutParams)localObject5).height, this);
              }
              break label1619;
              label1538:
              ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).g.setMaxLines(1);
              ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).g.setText(2131894287);
              ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).h.setVisibility(8);
              ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).i.setVisibility(8);
            }
          }
          else
          {
            localObject2 = localObject1;
            localObject1 = localObject2;
            if (QLog.isColorLevel())
            {
              localObject1 = localObject2;
              if (QLog.isColorLevel())
              {
                QLog.w("SubscriptFeedsAdapter", 2, "getView feed.mItems.size() == 0, is error!!");
                localObject1 = localObject2;
              }
            }
          }
          label1619:
          ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).b.setTag(2131446598, Integer.valueOf(((SubscriptionFeed)localObject1).b));
          ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).b.setTag(2131446607, ((SubscriptionFeed)localObject1).c);
          ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).b.setTag(2131446600, localObject3);
          ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).b.setTag(2131446599, Integer.valueOf(d));
          ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).f.setTag(2131446598, localObject1);
          ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).j.setTag(2131446607, ((SubscriptionFeed)localObject1).c);
          ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).k.setTag(2131446607, ((SubscriptionFeed)localObject1).c);
          ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).l.setTag(2131446607, ((SubscriptionFeed)localObject1).c);
          ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).l.setTag(2131446600, localObject3);
          ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).m.setTag(2131446607, ((SubscriptionFeed)localObject1).c);
          if (!TroopBarAssistantManager.a().b(((SubscriptionFeed)localObject1).c, this.n))
          {
            if (!this.E) {
              ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).b.setBackgroundResource(2130844306);
            } else {
              ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).b.setBackgroundResource(2130844308);
            }
            paramView.setTag(-3, Integer.valueOf((int)(this.A + this.C + this.D)));
            ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).j.setVisibility(0);
            ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).k.setVisibility(8);
          }
          else
          {
            if (!this.E) {
              ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).b.setBackgroundResource(2130844307);
            } else {
              ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).b.setBackgroundResource(2130844309);
            }
            paramView.setTag(-3, Integer.valueOf((int)(this.B + this.C + this.D)));
            ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).j.setVisibility(8);
            ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).k.setVisibility(0);
          }
        }
        else
        {
          localObject1 = "";
          if (i3 == b)
          {
            paramView.setTag(2131446601, Integer.valueOf(paramInt));
            this.y += 1;
            localObject2 = (SubscriptFeedsAdapter.KandianItemCellHolder)paramView.getTag();
            i3 = ((SubscriptFeedsAdapter.KandianItemCellHolder)localObject2).b.size();
            i1 = i2;
            while (i1 < i3)
            {
              localObject4 = (ViewGroup)((SubscriptFeedsAdapter.KandianItemCellHolder)localObject2).b.get(i1);
              localObject3 = (TextView)((ViewGroup)localObject4).findViewById(2131428812);
              localObject4 = (ImageView)((ViewGroup)localObject4).findViewById(2131428811);
              if (i1 < this.v.size())
              {
                localObject5 = (ReadInJoyArticle)this.v.get(i1);
                ((TextView)localObject3).setText(((ReadInJoyArticle)localObject5).mTitle.replaceFirst("^\\s+", (String)localObject1));
                ((ImageView)localObject4).setTag(2131446606, Integer.valueOf(b));
                localObject3 = (WindowManager)this.l.getSystemService("window");
                this.s.a(((IPublicAccountHttpDownloader)QRoute.api(IPublicAccountHttpDownloader.class)).makeURL(((ReadInJoyArticle)localObject5).mFirstPagePicUrl, 1), (ImageView)localObject4, ((WindowManager)localObject3).getDefaultDisplay().getWidth(), ((WindowManager)localObject3).getDefaultDisplay().getHeight(), this);
              }
              i1 += 1;
            }
          }
          i1 = c;
        }
        localObject1 = paramView;
        localObject2 = paramView;
        break label2210;
      }
    }
    Object localObject2 = null;
    Object localObject1 = paramView;
    label2210:
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
    return localObject2;
  }
  
  public int getViewTypeCount()
  {
    return j;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (this.o != null) && (paramString != null))
    {
      if (paramString.length() == 0) {
        return;
      }
      this.z.put(paramString, paramBitmap);
      paramInt2 = this.o.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        paramBitmap = this.o.getChildAt(paramInt1).getTag();
        if ((paramBitmap != null) && ((paramBitmap instanceof SubscriptFeedsAdapter.FeedItemCellHolder)))
        {
          paramBitmap = (SubscriptFeedsAdapter.FeedItemCellHolder)paramBitmap;
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
 * Qualified Name:     com.tencent.biz.pubaccount.subscript.SubscriptFeedsAdapter
 * JD-Core Version:    0.7.0.1
 */